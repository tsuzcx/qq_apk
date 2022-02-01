import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class raw
  implements uyg
{
  public raw(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable) {}
  
  public void a(URL paramURL, suk paramsuk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment cover download success");
    }
    ReadInJoyDeliverVideoActivity.c(this.a, ShortVideoPreviewActivity.a(paramsuk.a()));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment local cover is " + ReadInJoyDeliverVideoActivity.a(this.a));
    }
    this.a.setRightViewTextDisable(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     raw
 * JD-Core Version:    0.7.0.1
 */