import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.ListViewEventListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

class mvw
  implements PublicAccountImageCollectionListView.ListViewEventListener
{
  mvw(mvv parammvv) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof mwb))
    {
      if (!this.a.b) {
        ((PublicAccountImageCollectionMainActivity)mvv.a(this.a)).h();
      }
      this.a.b = true;
    }
    while ((paramObject instanceof mwc)) {
      if (mvv.a(this.a))
      {
        this.a.d(true);
        return;
        ((PublicAccountImageCollectionMainActivity)mvv.a(this.a)).g();
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
 * Qualified Name:     mvw
 * JD-Core Version:    0.7.0.1
 */