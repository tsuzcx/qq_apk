package cooperation.liveroom;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.commons.IReportDelegate;
import mqq.app.AppRuntime;

final class LiveRoomPluginHelper$1
  implements LoadLibCallback
{
  LiveRoomPluginHelper$1(LiveRoomPluginHelper.InitViolaListener paramInitViolaListener, AppRuntime paramAppRuntime, String paramString, IReportDelegate paramIReportDelegate) {}
  
  public void onError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initViola: load so error,code=");
    localStringBuilder.append(paramInt);
    QLog.e("LiveRoomPluginHelper", 2, localStringBuilder.toString());
    this.val$initViolaListener.onLoadSoError(paramInt);
  }
  
  public void onFinish(int paramInt)
  {
    QLog.i("LiveRoomPluginHelper", 2, "initViola: load so success");
    this.val$initViolaListener.onLoadSoSuccess();
    LiveRoomPluginHelper.access$000(this.val$app, this.val$mainJs, this.val$reportDelegate, this.val$initViolaListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginHelper.1
 * JD-Core Version:    0.7.0.1
 */