import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

class ncd
  implements Runnable
{
  ncd(nby paramnby) {}
  
  public void run()
  {
    if ((PublicAccountImageCollectionMainActivity.a(this.a.a) != null) && (PublicAccountImageCollectionMainActivity.a(this.a.a) != null))
    {
      PublicAccountImageCollectionMainActivity.a(this.a.a).a(true);
      PublicAccountImageCollectionMainActivity.a(this.a.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncd
 * JD-Core Version:    0.7.0.1
 */