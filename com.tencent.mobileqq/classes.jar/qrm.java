import android.content.Context;
import android.os.Handler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class qrm
  implements TVK_SDKMgr.InstallListener
{
  public qrm(GdtVideoCommonView paramGdtVideoCommonView, Context paramContext) {}
  
  public void onInstallProgress(float paramFloat)
  {
    GdtLog.a("GdtVideoCommonView", "installSDK onInstallProgress arg0=" + paramFloat + " " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    GdtLog.a("GdtVideoCommonView", "installSDK onInstalledFailed arg0=" + paramInt + " " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
  }
  
  public void onInstalledSuccessed()
  {
    GdtLog.a("GdtVideoCommonView", "installSDK onInstalledSuccessed " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
    GdtVideoCommonView.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView).post(new qrn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qrm
 * JD-Core Version:    0.7.0.1
 */