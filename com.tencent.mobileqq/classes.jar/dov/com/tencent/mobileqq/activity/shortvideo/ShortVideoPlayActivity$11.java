package dov.com.tencent.mobileqq.activity.shortvideo;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$11
  implements TVK_SDKMgr.InstallListener
{
  ShortVideoPlayActivity$11(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ShortVideoPlayActivity.a(this.a, false);
    ShortVideoPlayActivity.b(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.b(this.a));
    this.a.a(HardCodeUtil.a(2131713972));
    ShortVideoPlayActivity.c(this.a, 3000);
    ShortVideoPlayActivity.d(this.a, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onInstalledFailed:" + paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    ShortVideoPlayActivity.a(this.a, true);
    ShortVideoPlayActivity.b(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.b(this.a));
    this.a.a.post(new ShortVideoPlayActivity.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.11
 * JD-Core Version:    0.7.0.1
 */