import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.ListViewEventListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

class mxd
  implements PublicAccountImageCollectionListView.ListViewEventListener
{
  mxd(mxc parammxc) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof mxi))
    {
      if (!this.a.b) {
        ((PublicAccountImageCollectionMainActivity)mxc.a(this.a)).h();
      }
      this.a.b = true;
    }
    while ((paramObject instanceof mxj)) {
      if (mxc.a(this.a))
      {
        this.a.d(true);
        return;
        ((PublicAccountImageCollectionMainActivity)mxc.a(this.a)).g();
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
 * Qualified Name:     mxd
 * JD-Core Version:    0.7.0.1
 */