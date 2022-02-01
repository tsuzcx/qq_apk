package com.tencent.mobileqq.kandian.biz.common;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyVIconHelper
{
  public static void a(ReadInJoyUserInfo paramReadInJoyUserInfo, NativeReadInjoyImageView paramNativeReadInjoyImageView)
  {
    if (paramReadInJoyUserInfo == null)
    {
      QLog.d("ReadInJoyVIconHelper", 2, "[setVIconWithUserInfo], userInfo is null.");
      return;
    }
    if (paramNativeReadInjoyImageView != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[refreshVIcon], userInfo = ");
        localStringBuilder.append(paramReadInJoyUserInfo);
        QLog.i("ReadInJoyVIconHelper", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramReadInJoyUserInfo.smallIconUrl))
      {
        paramNativeReadInjoyImageView.setVisibility(0);
        paramNativeReadInjoyImageView.setImageSrc(paramReadInJoyUserInfo.smallIconUrl);
        return;
      }
      if (!TextUtils.isEmpty(paramReadInJoyUserInfo.largeIconUrl))
      {
        paramNativeReadInjoyImageView.setVisibility(0);
        paramNativeReadInjoyImageView.setImageSrc(paramReadInJoyUserInfo.largeIconUrl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyVIconHelper
 * JD-Core Version:    0.7.0.1
 */