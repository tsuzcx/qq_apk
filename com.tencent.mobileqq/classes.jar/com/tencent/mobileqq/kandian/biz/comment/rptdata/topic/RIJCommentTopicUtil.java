package com.tencent.mobileqq.kandian.biz.comment.rptdata.topic;

import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.IEmotionSpan;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil.PTSCommentModel;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;

public class RIJCommentTopicUtil
{
  private static final int[] a = { 10, 32, 64, 35, 20 };
  
  private static int a(int paramInt, int[][] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int[] arrayOfInt = paramArrayOfInt[i];
      if ((arrayOfInt[0] <= paramInt) && (arrayOfInt[1] > paramInt)) {
        return arrayOfInt[1] - 1;
      }
      i += 1;
    }
    return paramInt;
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int[][] paramArrayOfInt)
  {
    int i = Character.codePointAt(paramCharSequence, paramInt1);
    if (b(i)) {
      return paramInt1;
    }
    if (a(i)) {
      return paramInt1;
    }
    if (a(paramInt1, paramArrayOfInt)) {
      return paramInt1;
    }
    if (a(paramInt2, paramInt1)) {
      return paramInt1 + 1;
    }
    if (a(paramCharSequence, paramInt1)) {
      return paramCharSequence.length();
    }
    return -1;
  }
  
  public static void a(@NonNull View paramView, @NonNull String paramString)
  {
    String str = paramString.substring(0, paramString.length() - 14);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTopicClick: clickedUrl=");
    localStringBuilder.append(str);
    QLog.d("RIJCommentTopicUtil", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramView = paramView.getTag(2131376111);
    if (!(paramView instanceof RIJCommentRptDataUtil.PTSCommentModel))
    {
      paramString = new StringBuilder();
      paramString.append("onTopicClick: tag is");
      paramString.append(paramView);
      QLog.d("RIJCommentTopicUtil", 1, paramString.toString());
      return;
    }
    paramView = (RIJCommentRptDataUtil.PTSCommentModel)paramView;
    RIJJumpUtils.a(BaseApplication.getContext(), paramString);
    a(paramView, str);
  }
  
  private static void a(RIJCommentRptDataUtil.PTSCommentModel paramPTSCommentModel, String paramString)
  {
    Iterator localIterator = paramPTSCommentModel.a.commentRptDataList.iterator();
    while (localIterator.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)localIterator.next();
      if ((localCommentRptData.a == 3) && (TextUtils.equals(paramString, localCommentRptData.c))) {
        RIJCommentRptDataUtil.a(paramPTSCommentModel, localCommentRptData, "0X800B9E1");
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = ReadInJoyHelper.f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCommentTopicDisplaySwitchOn: topicSwitchOn=");
    localStringBuilder.append(bool);
    QLog.d("RIJCommentTopicUtil", 1, localStringBuilder.toString());
    return bool;
  }
  
  private static boolean a(int paramInt)
  {
    return EmotcationConstants.EMOJI_MAP.get(paramInt, -1) >= 0;
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 - paramInt1 >= 12;
  }
  
  private static boolean a(int paramInt, int[][] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt[i][0] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(Spannable paramSpannable)
  {
    int n = paramSpannable.length();
    int[][] arrayOfInt = a(paramSpannable);
    int i = 0;
    boolean bool1 = false;
    int k = -1;
    while (i < n)
    {
      int m = paramSpannable.charAt(i);
      boolean bool2 = bool1;
      int j = k;
      if (k >= 0)
      {
        int i1 = a(paramSpannable, i, k, arrayOfInt);
        bool2 = bool1;
        j = k;
        if (i1 > 0)
        {
          bool2 = bool1 | a(paramSpannable, k, i1);
          j = -1;
        }
      }
      if (m == 35)
      {
        k = i;
        m = i;
      }
      else
      {
        m = i;
        k = j;
        if (arrayOfInt != null)
        {
          m = a(i, arrayOfInt);
          k = j;
        }
      }
      i = m + 1;
      bool1 = bool2;
    }
    return bool1;
  }
  
  private static boolean a(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 > 1)
    {
      paramSpannable.setSpan(new RIJCommentTopicSpan(), paramInt1, paramInt2, 33);
      return true;
    }
    return false;
  }
  
  public static boolean a(@NonNull BaseCommentData paramBaseCommentData)
  {
    if (!a()) {
      return false;
    }
    paramBaseCommentData = paramBaseCommentData.commentRptDataList;
    if (paramBaseCommentData != null)
    {
      paramBaseCommentData = paramBaseCommentData.iterator();
      while (paramBaseCommentData.hasNext()) {
        if (((BaseCommentData.CommentRptData)paramBaseCommentData.next()).a == 3) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(CharSequence paramCharSequence, int paramInt)
  {
    return paramInt == paramCharSequence.length() - 1;
  }
  
  private static int[][] a(Spanned paramSpanned)
  {
    IEmotionSpan[] arrayOfIEmotionSpan = (IEmotionSpan[])paramSpanned.getSpans(0, paramSpanned.length(), IEmotionSpan.class);
    int[][] arrayOfInt2 = (int[][])null;
    int[][] arrayOfInt1 = arrayOfInt2;
    if (arrayOfIEmotionSpan != null)
    {
      arrayOfInt1 = arrayOfInt2;
      if (arrayOfIEmotionSpan.length > 0)
      {
        arrayOfInt2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { arrayOfIEmotionSpan.length, 2 });
        int i = 0;
        for (;;)
        {
          arrayOfInt1 = arrayOfInt2;
          if (i >= arrayOfIEmotionSpan.length) {
            break;
          }
          arrayOfInt2[i][0] = paramSpanned.getSpanStart(arrayOfIEmotionSpan[i]);
          arrayOfInt2[i][1] = paramSpanned.getSpanEnd(arrayOfIEmotionSpan[i]);
          i += 1;
        }
      }
    }
    return arrayOfInt1;
  }
  
  private static boolean b(int paramInt)
  {
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUtil
 * JD-Core Version:    0.7.0.1
 */