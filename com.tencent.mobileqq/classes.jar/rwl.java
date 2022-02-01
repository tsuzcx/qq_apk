import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.GalleryFragment;
import java.util.List;

public class rwl
  implements rtf<rsv>
{
  public rwl(GalleryFragment paramGalleryFragment) {}
  
  public List<rsv> a(int paramInt1, int paramInt2)
  {
    return rsu.b(paramInt1, paramInt2);
  }
  
  public void a(List<rsv> paramList, boolean paramBoolean)
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
 * Qualified Name:     rwl
 * JD-Core Version:    0.7.0.1
 */