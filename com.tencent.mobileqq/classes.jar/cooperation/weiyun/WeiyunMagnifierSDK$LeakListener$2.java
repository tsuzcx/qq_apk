package cooperation.weiyun;

import ajyc;
import bcpw;
import bidb;
import com.tencent.common.app.BaseApplicationImpl;

public class WeiyunMagnifierSDK$LeakListener$2
  implements Runnable
{
  public WeiyunMagnifierSDK$LeakListener$2(bidb parambidb, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = ajyc.a(2131716926) + this.b;; str = ajyc.a(2131716925))
    {
      bcpw.a(localBaseApplicationImpl, str, 2000).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.WeiyunMagnifierSDK.LeakListener.2
 * JD-Core Version:    0.7.0.1
 */