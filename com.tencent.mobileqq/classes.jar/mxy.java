import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class mxy
  implements Runnable
{
  public mxy(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    int i = 0;
    if (PublicAccountImageCollectionMainActivity.d(this.a)) {
      i = 1;
    }
    PublicAccountImageCollectionMainActivity.a(this.a).a(this.a.c, PublicAccountImageCollectionMainActivity.b(this.a), i);
    PublicAccountImageCollectionMainActivity.a(this.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxy
 * JD-Core Version:    0.7.0.1
 */