package cooperation.vip.ar.util;

import android.text.TextUtils;
import azqh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Properties;

public final class VipARUtils$5
  implements Runnable
{
  public VipARUtils$5(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VipARUtils", 2, "reportMta matId = " + this.jdField_a_of_type_JavaLangString + " mtaKey = " + this.b + " mtaValue = " + this.c);
    }
    try
    {
      if ((this.c != null) && (!TextUtils.isEmpty(this.c)))
      {
        Properties localProperties = new Properties();
        localProperties.put(this.b, this.c);
        azqh.a(BaseApplicationImpl.getContext()).reportTimeKVEvent(this.jdField_a_of_type_JavaLangString, localProperties, this.jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.5
 * JD-Core Version:    0.7.0.1
 */