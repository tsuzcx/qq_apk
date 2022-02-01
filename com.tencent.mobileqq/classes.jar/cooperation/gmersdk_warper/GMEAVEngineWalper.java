package cooperation.gmersdk_warper;

import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import java.util.HashMap;
import java.util.Map;

public class GMEAVEngineWalper
{
  static GMEAVEngineWalper jdField_a_of_type_CooperationGmersdk_warperGMEAVEngineWalper = null;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new GMEAVEngineWalper.7(this);
  AVEngineEventHandler jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler;
  private GMEAVManager.RoomInfoListener jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$RoomInfoListener = new GMEAVEngineWalper.8(this);
  TMG_DownloadInfo jdField_a_of_type_CooperationGmersdk_warperTMG_DownloadInfo;
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  public static GMEAVEngineWalper a()
  {
    if (jdField_a_of_type_CooperationGmersdk_warperGMEAVEngineWalper == null) {
      jdField_a_of_type_CooperationGmersdk_warperGMEAVEngineWalper = new GMEAVEngineWalper();
    }
    return jdField_a_of_type_CooperationGmersdk_warperGMEAVEngineWalper;
  }
  
  private void a()
  {
    TMG_Downloader.a().a(this.jdField_a_of_type_CooperationGmersdk_warperTMG_DownloadInfo, new GMEAVEngineWalper.1(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_CooperationGmersdk_warperTMG_DownloadInfo = new TMG_DownloadInfo(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, TMGProformanceHelper.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$RoomInfoListener);
    GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new GMEAVManager.AppInfo();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(AVEngineEventHandler paramAVEngineEventHandler)
  {
    this.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler = paramAVEngineEventHandler;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new GMEAVEngineWalper.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
        this.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.a(paramBoolean, 0);
      }
      return;
    }
    GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new GMEAVEngineWalper.5(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
        this.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.b(paramBoolean, 0);
      }
      return;
    }
    GMEAVManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new GMEAVEngineWalper.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper
 * JD-Core Version:    0.7.0.1
 */