package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.rtmp.TXLiveBase;

class WXLivePlayerApiProxy$1
  implements OnLoadListener
{
  WXLivePlayerApiProxy$1(WXLivePlayerApiProxy paramWXLivePlayerApiProxy) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadResult: ");
    localStringBuilder.append(paramInt);
    QMLog.i("WXLivePlayerApiProxy", localStringBuilder.toString());
    if (paramInt == 0) {
      try
      {
        WXLivePlayerApiProxy.a(Utils.o(paramLoadExtResult.getRelatedFilesFolder("trtc_entry")));
        TXLiveBase.setLibraryPath(WXLivePlayerApiProxy.a());
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WXLivePlayerApiProxy.1
 * JD-Core Version:    0.7.0.1
 */