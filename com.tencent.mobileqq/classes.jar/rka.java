import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.2.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.2.2;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class rka
  implements ovp
{
  public rka(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onError: code - " + paramInt + " msg - " + paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new ReadInJoyDeliverVideoActivity.2.2(this));
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onSuccess: outputPath - " + paramString);
    ReadInJoyDeliverVideoActivity.b(this.a, paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new ReadInJoyDeliverVideoActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rka
 * JD-Core Version:    0.7.0.1
 */