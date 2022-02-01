package com.tencent.mobileqq.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.model.TopicInfo;
import com.tencent.qphone.base.util.QLog;

public class TopicHelper
{
  public static CharSequence a(Context paramContext, TopicInfo paramTopicInfo, String paramString)
  {
    if ((paramTopicInfo == null) || (TextUtils.isEmpty(paramTopicInfo.a()))) {
      return paramString;
    }
    String str = "#" + paramTopicInfo.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new TopicHelper.1(paramContext, paramTopicInfo), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, TopicInfo paramTopicInfo, String paramString)
  {
    if ((paramTopicInfo == null) || (TextUtils.isEmpty(paramTopicInfo.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramTopicInfo.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new TopicHelper.2(paramContext, paramTopicInfo), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TopicHelper
 * JD-Core Version:    0.7.0.1
 */