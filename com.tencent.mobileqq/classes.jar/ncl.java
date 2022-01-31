import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class ncl
  implements Runnable
{
  public ncl(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    if (PublicAccountImageCollectionMainActivity.a(this.a) != null)
    {
      PublicAccountImageCollectionMainActivity.a(this.a).a(PublicAccountImageCollectionMainActivity.a(this.a));
      PublicAccountImageCollectionMainActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncl
 * JD-Core Version:    0.7.0.1
 */