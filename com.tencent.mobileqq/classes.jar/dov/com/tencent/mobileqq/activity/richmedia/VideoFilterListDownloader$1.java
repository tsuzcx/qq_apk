package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;

class VideoFilterListDownloader$1
  implements Runnable
{
  VideoFilterListDownloader$1(VideoFilterListDownloader paramVideoFilterListDownloader, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this.this$0.a;
    localHttpNetReq.mReqUrl = this.a.resurl;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = (CaptureVideoFilterManager.b + this.a.name + ".zip");
    localHttpNetReq.setUserData(this.a);
    localHttpNetReq.mFailedListener = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    AVNetEngine.a().sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */