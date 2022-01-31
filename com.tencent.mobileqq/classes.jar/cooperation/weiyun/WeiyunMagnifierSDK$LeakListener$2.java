package cooperation.weiyun;

import ajjy;
import bbmy;
import bgtz;
import com.tencent.common.app.BaseApplicationImpl;

public class WeiyunMagnifierSDK$LeakListener$2
  implements Runnable
{
  public WeiyunMagnifierSDK$LeakListener$2(bgtz parambgtz, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = ajjy.a(2131651135) + this.b;; str = ajjy.a(2131651134))
    {
      bbmy.a(localBaseApplicationImpl, str, 2000).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.WeiyunMagnifierSDK.LeakListener.2
 * JD-Core Version:    0.7.0.1
 */