import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lxu
  implements Runnable
{
  public lxu(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(ReadInJoyDeliverUGCActivity.a(this.a))) && (!TextUtils.isEmpty(ReadInJoyDeliverUGCActivity.b(this.a))) && (!ReadInJoyDeliverUGCActivity.a(this.a).equals(ReadInJoyDeliverUGCActivity.b(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "clearTempFile(image), origin:" + ReadInJoyDeliverUGCActivity.a(this.a) + ", compress:" + ReadInJoyDeliverUGCActivity.b(this.a));
      }
      File localFile = new File(ReadInJoyDeliverUGCActivity.b(this.a));
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxu
 * JD-Core Version:    0.7.0.1
 */