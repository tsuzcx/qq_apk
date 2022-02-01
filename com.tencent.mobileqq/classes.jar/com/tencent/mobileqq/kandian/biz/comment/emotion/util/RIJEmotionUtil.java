package com.tencent.mobileqq.kandian.biz.comment.emotion.util;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.kandian.biz.biu.BiuTextBuilder;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJBaseEmotionInfo;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.emotionsize.IRIJEmotionSize;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.IEmotionSpan;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.IShrinkLength;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.RIJEmotionImageSpan;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.RIJEmotionTextSpan;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJEmotionUtil
{
  public static final Pattern a = Pattern.compile("(\\[[^\\[\\]_]+?_[^\\[\\]_]+?])");
  
  public static int a(Spanned paramSpanned)
  {
    int i;
    if ((paramSpanned instanceof BiuTextBuilder)) {
      i = ((BiuTextBuilder)paramSpanned).a();
    } else {
      i = paramSpanned.length();
    }
    return a(paramSpanned, i);
  }
  
  private static int a(Spanned paramSpanned, int paramInt)
  {
    int j = paramSpanned.length();
    int i = 0;
    IShrinkLength[] arrayOfIShrinkLength = (IShrinkLength[])paramSpanned.getSpans(0, j, IShrinkLength.class);
    j = paramInt;
    if (arrayOfIShrinkLength != null)
    {
      int k = arrayOfIShrinkLength.length;
      for (;;)
      {
        j = paramInt;
        if (i >= k) {
          break;
        }
        IShrinkLength localIShrinkLength = arrayOfIShrinkLength[i];
        j = paramSpanned.getSpanStart(localIShrinkLength);
        paramInt = paramInt - (paramSpanned.getSpanEnd(localIShrinkLength) - j) + localIShrinkLength.a();
        i += 1;
      }
    }
    return j;
  }
  
  public static void a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("os", 1);
      localJSONObject.put("emoticons_id", paramString);
    }
    catch (JSONException paramString)
    {
      QLog.w("RIJEmotionUtil", 4, paramString.getMessage(), paramString);
    }
    PublicAccountReportUtils.a(null, "", "0X800B99F", "0X800B99F", 0, 0, String.valueOf(paramInt), "", "", localJSONObject.toString(), false);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int j = paramSpannableStringBuilder.length();
    int i = 0;
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramSpannableStringBuilder.getSpans(0, j, EmoticonSpan.class);
    if (arrayOfEmoticonSpan != null)
    {
      j = arrayOfEmoticonSpan.length;
      while (i < j)
      {
        paramSpannableStringBuilder.removeSpan(arrayOfEmoticonSpan[i]);
        i += 1;
      }
    }
  }
  
  public static void a(Spanned paramSpanned, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramSpanned)) {
      return;
    }
    int j = paramSpanned.length();
    int i = 0;
    paramSpanned = (IEmotionSpan[])paramSpanned.getSpans(0, j, IEmotionSpan.class);
    if ((paramSpanned != null) && (paramSpanned.length != 0))
    {
      paramJSONObject.put("emoticons", 1);
      StringBuilder localStringBuilder = new StringBuilder();
      j = paramSpanned.length;
      while (i < j)
      {
        Object localObject = paramSpanned[i];
        if ((localObject instanceof RIJEmotionTextSpan))
        {
          localStringBuilder.append(localObject.b().a);
          localStringBuilder.append(',');
        }
        i += 1;
      }
      paramJSONObject.put("emoticons_id", localStringBuilder.toString());
      return;
    }
    paramJSONObject.put("emoticons", 0);
  }
  
  public static void a(IViewProxy paramIViewProxy, Spannable paramSpannable)
  {
    if (paramSpannable != null)
    {
      if (paramSpannable.length() == 0) {
        return;
      }
      Matcher localMatcher = a.matcher(paramSpannable);
      while (localMatcher.find())
      {
        int i = localMatcher.start();
        int j = localMatcher.end();
        Object localObject = RIJEmotionCacheManager.b(localMatcher.group());
        if (localObject != null)
        {
          localObject = new RIJEmotionImageSpan((RIJBaseEmotionInfo)localObject);
          ((RIJEmotionImageSpan)localObject).b(IRIJEmotionSize.b, IRIJEmotionSize.b);
          ((RIJEmotionImageSpan)localObject).a(paramIViewProxy);
          paramSpannable.setSpan(localObject, i, j, 33);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EmoticonInfo paramEmoticonInfo, EditText paramEditText)
  {
    if ((paramEmoticonInfo instanceof RIJBaseEmotionInfo))
    {
      paramQQAppInterface = (RIJBaseEmotionInfo)paramEmoticonInfo;
      int i = paramEditText.getSelectionStart();
      int j = paramEditText.getSelectionEnd();
      paramEmoticonInfo = new SpannableStringBuilder(paramEditText.getText());
      a(paramEmoticonInfo);
      paramEmoticonInfo.replace(i, j, paramQQAppInterface.c);
      j = paramQQAppInterface.c.length() + i;
      paramEmoticonInfo.setSpan(new RIJEmotionTextSpan(paramQQAppInterface), i, j, 33);
      paramEditText.setText(paramEmoticonInfo);
      paramEditText.setSelection(j);
      a(1, paramQQAppInterface.a);
      return;
    }
    ReadInJoyBaseDeliverActivity.a(paramQQAppInterface, paramEmoticonInfo, paramEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil
 * JD-Core Version:    0.7.0.1
 */