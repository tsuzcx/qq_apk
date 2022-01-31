import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.GalleryFragment;
import java.util.List;

public class qra
  implements qoj<qnz>
{
  public qra(GalleryFragment paramGalleryFragment) {}
  
  public List<qnz> a(int paramInt1, int paramInt2)
  {
    return qny.b(paramInt1, paramInt2);
  }
  
  public void a(List<qnz> paramList, boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qra
 * JD-Core Version:    0.7.0.1
 */