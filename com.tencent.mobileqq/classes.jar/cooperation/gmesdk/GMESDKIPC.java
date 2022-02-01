package cooperation.gmesdk;

import com.tencent.common.app.BaseApplicationImpl;
import cooperation.gmersdk_warper.GMEAVEngineWalper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GMESDKIPC
{
  private static int jdField_a_of_type_Int = -1;
  private static GMESDKIPC jdField_a_of_type_CooperationGmesdkGMESDKIPC;
  String jdField_a_of_type_JavaLangString;
  WeakReference<GMESDK_Event> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  String b;
  String c;
  String d;
  String e = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  String f = "105d1e43c456bc800b4adacd57ac1199";
  
  public static GMESDKIPC a()
  {
    if (jdField_a_of_type_CooperationGmesdkGMESDKIPC == null) {
      try
      {
        if (jdField_a_of_type_CooperationGmesdkGMESDKIPC == null) {
          jdField_a_of_type_CooperationGmesdkGMESDKIPC = new GMESDKIPC();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationGmesdkGMESDKIPC;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    jdField_a_of_type_CooperationGmesdkGMESDKIPC = null;
  }
  
  public void a(GMESDK_Event paramGMESDK_Event)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGMESDK_Event);
  }
  
  public void a(String paramString)
  {
    GMEAVEngineWalper.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.f = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    GMEAVEngineWalper.a().a(1, this.e, this.f);
    GMEAVEngineWalper.a().a(BaseApplicationImpl.getContext(), this.b, this.jdField_a_of_type_JavaLangString, "0", this.c);
    GMEAVEngineWalper.a().a(new GMESDKIPC.1(this, paramBoolean1, paramBoolean2));
  }
  
  public void a(boolean paramBoolean)
  {
    GMEAVEngineWalper.a().a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    GMEAVEngineWalper.a().b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.gmesdk.GMESDKIPC
 * JD-Core Version:    0.7.0.1
 */