import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.widget.ListView;

public class peh
  implements sly
{
  ped a;
  
  peh(ped paramped1, ped paramped2)
  {
    this.a = paramped2;
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    if (!this.b.a().c()) {
      return;
    }
    this.b.a().e(false);
    this.b.a().a().a(paramReadInJoyBaseListView);
    this.b.a().a().a(this.b.a().a().a().getLastVisiblePosition() + 1, this.b.a().a().a(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     peh
 * JD-Core Version:    0.7.0.1
 */