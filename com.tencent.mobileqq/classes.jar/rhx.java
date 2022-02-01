import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class rhx
  implements vgd
{
  public rhx(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable) {}
  
  public void a(URL paramURL, syk paramsyk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment cover download success");
    }
    ReadInJoyDeliverVideoActivity.c(this.a, ShortVideoPreviewActivity.a(paramsyk.a()));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment local cover is " + ReadInJoyDeliverVideoActivity.a(this.a));
    }
    this.a.setRightViewTextDisable(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhx
 * JD-Core Version:    0.7.0.1
 */