import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils.PhotoCollectionInfo;
import java.util.ArrayList;

public class myq
  implements Runnable
{
  public myq(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    PublicAccountImageCollectionMainActivity.a(this.a).c(this.a.b);
    PublicAccountImageCollectionMainActivity.a(this.a).e(this.a.b);
    PublicAccountImageCollectionMainActivity.a(this.a).b(this.a.b);
    PublicAccountImageCollectionMainActivity.a(this.a).d(this.a.b);
    if (PublicAccountImageCollectionMainActivity.c(this.a))
    {
      PublicAccountImageCollectionMainActivity.a(this.a).a(this.a.b, PublicAccountImageCollectionMainActivity.a(this.a), PublicAccountImageCollectionMainActivity.e(this.a), PublicAccountImageCollectionMainActivity.f(this.a));
      return;
    }
    if ((PublicAccountImageCollectionMainActivity.a(this.a) != null) && (PublicAccountImageCollectionMainActivity.a(this.a).a != null)) {}
    for (int i = PublicAccountImageCollectionMainActivity.a(this.a).a.size();; i = 0)
    {
      PublicAccountReportUtils.a(null, this.a.a, "0X8007B8A", "0X8007B8A", 0, 0, this.a.b, this.a.c, "" + PublicAccountImageCollectionMainActivity.b(this.a, PublicAccountImageCollectionMainActivity.a(this.a)), "" + i, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myq
 * JD-Core Version:    0.7.0.1
 */