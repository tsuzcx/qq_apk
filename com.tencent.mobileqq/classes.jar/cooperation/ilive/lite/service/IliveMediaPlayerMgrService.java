package cooperation.ilive.lite.service;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilivesdk.avmediaservice_interface.MediaPlayerInterface;
import com.tencent.livesdk.livesdkplayer.AVCatonReport4Player;
import com.tencent.livesdk.livesdkplayer.AVCatonReportManager;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr;
import cooperation.ilive.lite.report.IliveAVCatonReport;
import cooperation.ilive.lite.report.IliveAVCatonReportManager;
import cooperation.ilive.player.AsyncMediaPlayerManager;

public class IliveMediaPlayerMgrService
  implements MediaPlayerInterface
{
  public AVCatonReport4Player a()
  {
    return new IliveAVCatonReport();
  }
  
  public IMediaPlayerMgr a()
  {
    AVCatonReportManager.a().a(IliveAVCatonReportManager.a());
    return new AsyncMediaPlayerManager(BaseApplicationImpl.getContext());
  }
  
  public void clearEventOutput() {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveMediaPlayerMgrService
 * JD-Core Version:    0.7.0.1
 */