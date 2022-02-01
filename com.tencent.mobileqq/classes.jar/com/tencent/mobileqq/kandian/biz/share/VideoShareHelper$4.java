package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class VideoShareHelper$4
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  VideoShareHelper$4(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDoFavoriteResult isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", operationType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", cid = ");
      localStringBuilder.append(paramString2);
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (!VideoShareHelper.e(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new QQToast(VideoShareHelper.f(this.a));
    paramString2.setDuration(2000);
    if (paramBoolean)
    {
      paramString2.setToastIcon(QQToast.getIconRes(2));
      paramString2.setToastMsg(2131889172);
      paramString2.show(VideoShareHelper.f(this.a).getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(VideoShareHelper.f(this.a), 5.0F));
    }
    else
    {
      paramString2.setToastIcon(QQToast.getIconRes(1));
      paramString2.setToastMsg(2131889173);
      paramString2.show(VideoShareHelper.f(this.a).getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(VideoShareHelper.f(this.a), 5.0F));
    }
    VideoShareHelper.e(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.4
 * JD-Core Version:    0.7.0.1
 */