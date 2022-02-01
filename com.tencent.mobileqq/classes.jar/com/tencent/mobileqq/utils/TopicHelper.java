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
    if (paramTopicInfo != null)
    {
      if (TextUtils.isEmpty(paramTopicInfo.a())) {
        return paramString;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramTopicInfo.a());
      ((StringBuilder)localObject).append("#");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      paramString = new SpannableString(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("topicName is ");
        localStringBuilder.append((String)localObject);
        QLog.i("TopicHelper", 2, localStringBuilder.toString());
      }
      paramString.setSpan(new TopicHelper.1(paramContext, paramTopicInfo), 0, ((String)localObject).length(), 33);
      return paramString;
    }
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, TopicInfo paramTopicInfo, String paramString)
  {
    if (paramTopicInfo != null)
    {
      if (TextUtils.isEmpty(paramTopicInfo.a())) {
        return paramString;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramString);
      localStringBuilder1.append("\n");
      localStringBuilder1.append("#");
      localStringBuilder1.append(paramTopicInfo.a());
      localStringBuilder1.append("#");
      SpannableString localSpannableString = new SpannableString(localStringBuilder1.toString());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("topicAndDescWithLine is ");
        localStringBuilder2.append(localStringBuilder1);
        QLog.i("TopicHelper", 2, localStringBuilder2.toString());
      }
      localSpannableString.setSpan(new TopicHelper.2(paramContext, paramTopicInfo), paramString.length(), localStringBuilder1.length(), 33);
      return localSpannableString;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TopicHelper
 * JD-Core Version:    0.7.0.1
 */