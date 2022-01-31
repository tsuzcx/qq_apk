import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class qhy
{
  private static boolean b;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new qhz(this));
  private qia jdField_a_of_type_Qia;
  private boolean jdField_a_of_type_Boolean;
  
  public qhy(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    ThreadManager.executeOnSubThread(new VideoPluginInstall.1(this));
  }
  
  private void c()
  {
    TVK_SDKMgr.setOnLogListener(new qic(null));
    try
    {
      if (!b)
      {
        TVK_SDKMgr.setDebugEnable(true);
        TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video", 2, "initVideoSDK() finish");
        }
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new VideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(qia paramqia)
  {
    this.jdField_a_of_type_Qia = paramqia;
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Qia = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhy
 * JD-Core Version:    0.7.0.1
 */