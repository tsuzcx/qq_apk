import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.GalleryFragment;
import java.util.List;

public class rcy
  implements qzz<qzp>
{
  public rcy(GalleryFragment paramGalleryFragment) {}
  
  public List<qzp> a(int paramInt1, int paramInt2)
  {
    return qzo.b(paramInt1, paramInt2);
  }
  
  public void a(List<qzp> paramList, boolean paramBoolean)
  {
    GalleryFragment.a(this.a).addAll(paramList);
    GalleryFragment.a(this.a).notifyDataSetChanged();
    if (GalleryFragment.a(this.a).isEmpty())
    {
      GalleryFragment.a(this.a).setVisibility(0);
      return;
    }
    GalleryFragment.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rcy
 * JD-Core Version:    0.7.0.1
 */