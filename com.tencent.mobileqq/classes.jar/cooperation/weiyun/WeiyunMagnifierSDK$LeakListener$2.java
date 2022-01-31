package cooperation.weiyun;

import alud;
import bkjv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunMagnifierSDK$LeakListener$2
  implements Runnable
{
  public WeiyunMagnifierSDK$LeakListener$2(bkjv parambkjv, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = alud.a(2131717321) + this.b;; str = alud.a(2131717320))
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