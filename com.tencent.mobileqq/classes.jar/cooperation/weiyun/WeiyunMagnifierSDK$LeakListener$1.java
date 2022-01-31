package cooperation.weiyun;

import alud;
import bkjv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunMagnifierSDK$LeakListener$1
  implements Runnable
{
  public WeiyunMagnifierSDK$LeakListener$1(bkjv parambkjv, String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_JavaLangString + alud.a(2131717322), 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.WeiyunMagnifierSDK.LeakListener.1
 * JD-Core Version:    0.7.0.1
 */