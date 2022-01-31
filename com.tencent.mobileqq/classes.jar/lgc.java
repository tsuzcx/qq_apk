import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;

public class lgc
  implements Runnable
{
  public lgc(ReadInJoyArkViewController paramReadInJoyArkViewController, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = new HashMap();
      ((HashMap)localObject).put("action", this.jdField_a_of_type_JavaLangString);
      if (this.b == null)
      {
        str = "";
        ((HashMap)localObject).put("appname", str);
        if (this.c != null) {
          break label240;
        }
        str = "";
        label47:
        ((HashMap)localObject).put("appver", str);
        if (this.jdField_a_of_type_JavaLangString.equals("download")) {
          ((HashMap)localObject).put("result", "" + this.jdField_a_of_type_Int);
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actionReadInJoyArkConfig", TextUtils.equals(this.jdField_a_of_type_JavaLangString, "show"), 0L, 0L, (HashMap)localObject, null);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("report actionReadInJoyArkConfig name:");
          if (this.b != null) {
            break label248;
          }
          str = "";
          label150:
          localObject = ((StringBuilder)localObject).append(str).append(", ver:");
          if (this.c != null) {
            break label256;
          }
        }
      }
      label256:
      for (String str = "";; str = this.c)
      {
        QLog.d("ReadInJoyArkViewController", 2, str + ", action:" + this.jdField_a_of_type_JavaLangString);
        if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, "except")) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "download"))) {
          return;
        }
        ReadInJoyHelper.b(ReadInJoyUtils.a(), this.c);
        return;
        str = this.b;
        break;
        label240:
        str = this.c;
        break label47;
        label248:
        str = this.b;
        break label150;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyArkViewController", 1, "report ark error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgc
 * JD-Core Version:    0.7.0.1
 */