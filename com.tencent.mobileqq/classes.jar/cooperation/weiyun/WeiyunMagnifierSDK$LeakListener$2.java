package cooperation.weiyun;

import alpo;
import bkfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunMagnifierSDK$LeakListener$2
  implements Runnable
{
  public WeiyunMagnifierSDK$LeakListener$2(bkfo parambkfo, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = alpo.a(2131717309) + this.b;; str = alpo.a(2131717308))
    {
      QQToast.a(localBaseApplicationImpl, str, 2000).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.WeiyunMagnifierSDK.LeakListener.2
 * JD-Core Version:    0.7.0.1
 */