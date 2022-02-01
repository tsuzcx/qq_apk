package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class NearbyAuthVideoPlayerFragment$2
  implements DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  NearbyAuthVideoPlayerFragment$2(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish  url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("   progress:");
      localStringBuilder.append(paramInt);
      QLog.i("NearbyAuthVideoPlayerFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish  url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("   isSuccess:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("  isFileExist:");
      localStringBuilder.append(paramBoolean2);
      QLog.i("NearbyAuthVideoPlayerFragment", 2, localStringBuilder.toString());
    }
    if (!this.a.isDetached())
    {
      if (this.a.getBaseActivity() == null) {
        return;
      }
      this.a.getBaseActivity().runOnUiThread(new NearbyAuthVideoPlayerFragment.2.1(this, paramBoolean1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.2
 * JD-Core Version:    0.7.0.1
 */