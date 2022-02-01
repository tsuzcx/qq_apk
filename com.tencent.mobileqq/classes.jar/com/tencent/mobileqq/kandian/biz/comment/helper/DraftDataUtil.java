package com.tencent.mobileqq.kandian.biz.comment.helper;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtSpan;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DraftDataUtil
{
  private static final LruCache<String, List<BaseCommentData.CommentRptData>> a = new LruCache(20);
  
  public static CharSequence a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = (List)a.get(paramString);
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return null;
      }
      paramString = new SpannableStringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramString, (BaseCommentData.CommentRptData)((Iterator)localObject).next());
      }
      return paramString;
    }
    return null;
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, BaseCommentData.CommentRptData paramCommentRptData)
  {
    int i = paramCommentRptData.jdField_a_of_type_Int;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 3)
        {
          paramSpannableStringBuilder = new StringBuilder();
          paramSpannableStringBuilder.append("未处理的case: ");
          paramSpannableStringBuilder.append(paramCommentRptData.jdField_a_of_type_Int);
          ReadInJoyHelper.a("DraftDataUtil", new IllegalArgumentException(paramSpannableStringBuilder.toString()));
        }
      }
      else
      {
        i = paramSpannableStringBuilder.length();
        paramSpannableStringBuilder.append(paramCommentRptData.jdField_a_of_type_JavaLangString);
        paramSpannableStringBuilder.setSpan(new RIJCommentAtSpan(paramCommentRptData.b, 0L, paramCommentRptData.jdField_a_of_type_JavaLangString, -12541697), i, paramCommentRptData.jdField_a_of_type_JavaLangString.length() + i, 33);
        return;
      }
    }
    paramSpannableStringBuilder.append(paramCommentRptData.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a.remove(paramString);
  }
  
  public static void a(String paramString, CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      a(paramString);
      return;
    }
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = RIJCommentRptDataUtil.a((Spanned)paramCharSequence);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        a.put(paramString, localObject);
        return;
      }
    }
    Object localObject = new LinkedList();
    BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
    localCommentRptData.jdField_a_of_type_Int = 0;
    localCommentRptData.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
    ((List)localObject).add(localCommentRptData);
    a.put(paramString, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.DraftDataUtil
 * JD-Core Version:    0.7.0.1
 */