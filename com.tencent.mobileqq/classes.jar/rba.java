import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.Config;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.persist.DBHandler;
import com.tencent.mfsdk.reporter.DFObservable;
import com.tencent.mfsdk.reporter.StackObservable;
import cooperation.qzone.LocalMultiProcConfig;

public class rba
  implements Runnable
{
  private int jdField_a_of_type_Int = 63;
  private Application jdField_a_of_type_AndroidAppApplication;
  
  public rba(MagnifierSDK paramMagnifierSDK, Application paramApplication, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    boolean bool2 = true;
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidAppApplication.getSharedPreferences("MagnifierSDK", 4);
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler = DBHandler.a(this.jdField_a_of_type_AndroidAppApplication.getApplicationContext());
    Config.a();
    boolean bool3 = Config.a;
    boolean bool1;
    if ((this.jdField_a_of_type_Int & 0x1) > 0)
    {
      bool1 = true;
      Config.a = bool1 & bool3;
      bool3 = Config.b;
      if ((this.jdField_a_of_type_Int & 0x2) <= 0) {
        break label254;
      }
      bool1 = true;
      label78:
      Config.b = bool1 & bool3;
      bool3 = Config.c;
      if ((this.jdField_a_of_type_Int & 0x4) <= 0) {
        break label259;
      }
      bool1 = true;
      label99:
      Config.c = bool1 & bool3;
      bool3 = Config.g;
      if ((this.jdField_a_of_type_Int & 0x8) <= 0) {
        break label264;
      }
      bool1 = true;
      label121:
      Config.g = bool1 & bool3;
      bool3 = Config.h;
      if ((this.jdField_a_of_type_Int & 0x10) <= 0) {
        break label269;
      }
      bool1 = true;
      label143:
      Config.h = bool1 & bool3;
      bool3 = Config.i;
      if ((this.jdField_a_of_type_Int & 0x20) <= 0) {
        break label274;
      }
      bool1 = bool2;
      label165:
      Config.i = bool3 & bool1;
      if (Config.a)
      {
        if ((2 != BaseApplicationImpl.sProcessId) && (8 != BaseApplicationImpl.sProcessId)) {
          break label279;
        }
        if (LocalMultiProcConfig.getBool("Qzone_setApm_MemLeak", false)) {
          this.jdField_a_of_type_ComTencentMfsdkMagnifierSDK.a(this.jdField_a_of_type_AndroidAppApplication);
        }
      }
    }
    for (;;)
    {
      if (Config.g) {
        StackObservable.a().addObserver(MagnifierSDK.a());
      }
      DFObservable.a().addObserver(MagnifierSDK.a());
      if ((!Config.b) && (Config.c)) {}
      return;
      bool1 = false;
      break;
      label254:
      bool1 = false;
      break label78;
      label259:
      bool1 = false;
      break label99;
      label264:
      bool1 = false;
      break label121;
      label269:
      bool1 = false;
      break label143;
      label274:
      bool1 = false;
      break label165;
      label279:
      this.jdField_a_of_type_ComTencentMfsdkMagnifierSDK.a(this.jdField_a_of_type_AndroidAppApplication);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rba
 * JD-Core Version:    0.7.0.1
 */