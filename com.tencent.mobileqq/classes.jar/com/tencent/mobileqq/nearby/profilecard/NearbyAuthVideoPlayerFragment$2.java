package com.tencent.mobileqq.nearby.profilecard;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class NearbyAuthVideoPlayerFragment$2
  implements DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  NearbyAuthVideoPlayerFragment$2(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAuthVideoPlayerFragment", 2, "onDownloadFinish  url:" + paramString + "   progress:" + paramInt);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAuthVideoPlayerFragment", 2, "onDownloadFinish  url:" + paramString + "   isSuccess:" + paramBoolean1 + "  isFileExist:" + paramBoolean2);
    }
    if ((this.a.isDetached()) || (this.a.getActivity() == null)) {
      return;
    }
    this.a.getActivity().runOnUiThread(new NearbyAuthVideoPlayerFragment.2.1(this, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.2
 * JD-Core Version:    0.7.0.1
 */