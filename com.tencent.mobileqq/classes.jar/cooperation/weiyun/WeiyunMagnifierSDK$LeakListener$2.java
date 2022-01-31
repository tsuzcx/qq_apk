package cooperation.weiyun;

import ajya;
import bcql;
import bids;
import com.tencent.common.app.BaseApplicationImpl;

public class WeiyunMagnifierSDK$LeakListener$2
  implements Runnable
{
  public WeiyunMagnifierSDK$LeakListener$2(bids parambids, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = ajya.a(2131716937) + this.b;; str = ajya.a(2131716936))
    {
      bcql.a(localBaseApplicationImpl, str, 2000).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.WeiyunMagnifierSDK.LeakListener.2
 * JD-Core Version:    0.7.0.1
 */