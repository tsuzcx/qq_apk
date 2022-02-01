import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;

public class pym
  extends StaggeredGridLayoutManager
{
  public pym(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public boolean canScrollVertically()
  {
    return (this.a.a.e) && (super.canScrollVertically());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pym
 * JD-Core Version:    0.7.0.1
 */