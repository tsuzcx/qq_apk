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
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, BaseCommentData.CommentRptData paramCommentRptData)
  {
    int i = paramCommentRptData.a;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 3)
        {
          paramSpannableStringBuilder = new StringBuilder();
          paramSpannableStringBuilder.append("未处理的case: ");
          paramSpannableStringBuilder.append(paramCommentRptData.a);
          ReadInJoyHelper.a("DraftDataUtil", new IllegalArgumentException(paramSpannableStringBuilder.toString()));
        }
      }
      else
      {
        i = paramSpannableStringBuilder.length();
        paramSpannableStringBuilder.append(paramCommentRptData.b);
        paramSpannableStringBuilder.setSpan(new RIJCommentAtSpan(paramCommentRptData.c, 0L, paramCommentRptData.b, -12541697), i, paramCommentRptData.b.length() + i, 33);
        return;
      }
    }
    paramSpannableStringBuilder.append(paramCommentRptData.b);
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
    localCommentRptData.a = 0;
    localCommentRptData.b = paramCharSequence.toString();
    ((List)localObject).add(localCommentRptData);
    a.put(paramString, localObject);
  }
  
  public static CharSequence b(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.DraftDataUtil
 * JD-Core Version:    0.7.0.1
 */