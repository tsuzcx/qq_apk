import android.os.Build;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.view.RendererUtils;

public class lqe
{
  static int jdField_a_of_type_Int = -1;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  
  public static int a(boolean paramBoolean)
  {
    int j = 1;
    if (jdField_a_of_type_Int == -1)
    {
      lom locallom = lom.a();
      if (((locallom == null) || (!locallom.h())) && (!a())) {
        break label107;
      }
    }
    label107:
    for (jdField_a_of_type_Int = 1;; jdField_a_of_type_Int = 0)
    {
      QLog.i("Render", 1, "getFrameAngle, mInversion[" + jdField_a_of_type_Int + "], manufacture[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "]");
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (jdField_a_of_type_Int != 1) {
          i = 3;
        }
      }
      return i;
    }
  }
  
  public static void a()
  {
    if (!lph.b()) {
      return;
    }
    VideoPrefsUtil.setMaterialMute(true);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      FileUtil.writeBitmapToFile(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {}
    for (;;)
    {
      try
      {
        str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.isInversionWhenFaceDetect.name(), "0");
        try
        {
          if ("1".equals(str))
          {
            jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
            QLog.i("Render", 1, "isSpecialDevices, [" + jdField_a_of_type_JavaLangBoolean + "], manufacture[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "], dpcValue[" + str + "]");
            return jdField_a_of_type_JavaLangBoolean.booleanValue();
          }
          if ((!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"TAH-AN00".equalsIgnoreCase(Build.MODEL)) && (!"TAH-AN00m".equalsIgnoreCase(Build.MODEL)))) {
            continue;
          }
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
          continue;
          QLog.i("Render", 1, "isSpecialDevices", localThrowable1);
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        String str = null;
        continue;
      }
      continue;
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lqe
 * JD-Core Version:    0.7.0.1
 */