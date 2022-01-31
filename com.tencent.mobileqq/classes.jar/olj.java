import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPluginInstall.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.ArrayList;
import java.util.List;

public class olj
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(new olk());
  private static List<oll> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  public static void a()
  {
    if ((!a()) && (!jdField_a_of_type_Boolean)) {
      ThreadManager.post(new VideoPluginInstall.1(), 8, null, true);
    }
  }
  
  public static void a(oll paramoll)
  {
    jdField_a_of_type_JavaUtilList.add(paramoll);
  }
  
  public static boolean a()
  {
    return TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext());
  }
  
  public static boolean a(oll paramoll)
  {
    return jdField_a_of_type_JavaUtilList.contains(paramoll);
  }
  
  private static void c()
  {
    TVK_SDKMgr.setOnLogListener(new oln(null));
    try
    {
      if (!b)
      {
        TVK_SDKMgr.setDebugEnable(true);
        TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
        if (QLog.isColorLevel()) {
          QLog.e("gifvideo.VideoPluginInstall", 2, "initVideoSDK() finish");
        }
        b = true;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olj
 * JD-Core Version:    0.7.0.1
 */