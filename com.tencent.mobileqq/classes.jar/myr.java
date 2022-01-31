import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class myr
  implements Runnable
{
  public myr(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
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
 * Qualified Name:     myr
 * JD-Core Version:    0.7.0.1
 */