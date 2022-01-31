import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;

public class oje
  extends StaggeredGridLayoutManager
{
  public oje(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public boolean canScrollVertically()
  {
    return (this.a.a.e) && (super.canScrollVertically());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oje
 * JD-Core Version:    0.7.0.1
 */