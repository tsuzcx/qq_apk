import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.ListViewEventListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

class nax
  implements PublicAccountImageCollectionListView.ListViewEventListener
{
  nax(naw paramnaw) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof nbc))
    {
      if (!this.a.b) {
        ((PublicAccountImageCollectionMainActivity)naw.a(this.a)).h();
      }
      this.a.b = true;
    }
    while ((paramObject instanceof nbd)) {
      if (naw.a(this.a))
      {
        this.a.d(true);
        return;
        ((PublicAccountImageCollectionMainActivity)naw.a(this.a)).g();
      }
      else
      {
        this.a.d(false);
        return;
      }
    }
    this.a.d(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nax
 * JD-Core Version:    0.7.0.1
 */