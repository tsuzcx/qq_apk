import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public final class klx
  implements Runnable
{
  public klx(int paramInt, String paramString, AppRuntime paramAppRuntime, HashMap paramHashMap, AsyncBack paramAsyncBack, boolean paramBoolean) {}
  
  public void run()
  {
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "start checkUpThread. delay:" + this.jdField_a_of_type_Int + ", businessId:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int > 0) {}
    try
    {
      Thread.sleep(this.jdField_a_of_type_Int * 1000);
      label75:
      HtmlOffline.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack, true, true, this.jdField_a_of_type_Boolean);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klx
 * JD-Core Version:    0.7.0.1
 */