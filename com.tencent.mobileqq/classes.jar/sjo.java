import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class sjo
  implements bfzp
{
  public sjo(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a()
  {
    sne.b("WSRecommendFragment", "endOfRefresh");
    WSRecommendFragment.a(this.a).d();
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    sne.b("WSRecommendFragment", "startLoadMore");
    WSRecommendFragment.a(this.a).a(false, false, "");
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    sne.b("WSRecommendFragment", "startTopRefresh");
    if (WSRecommendFragment.a(this.a)) {
      WSRecommendFragment.a(this.a, false);
    }
    do
    {
      return;
      if (!WSRecommendFragment.b(this.a)) {
        WSRecommendFragment.b(this.a, true);
      }
      WSRecommendFragment.a(this.a, System.currentTimeMillis());
      WSRecommendFragment.a(this.a).a(true, false, "");
    } while (WSRecommendFragment.c(this.a));
    WSRecommendFragment.a(this.a).a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjo
 * JD-Core Version:    0.7.0.1
 */