import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager.OnVideoCompositeListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class mbz
  implements ReadInJoyVideoCompositeManager.OnVideoCompositeListener
{
  public mbz(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onError: code - " + paramInt + " msg - " + paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new mcb(this));
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onSuccess: outputPath - " + paramString);
    ReadInJoyDeliverVideoActivity.b(this.a, paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new mca(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbz
 * JD-Core Version:    0.7.0.1
 */