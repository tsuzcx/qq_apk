import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class rws
  implements berv
{
  public rws(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a()
  {
    sai.b("WSRecommendFragment", "endOfRefresh");
    WSRecommendFragment.a(this.a).d();
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    sai.b("WSRecommendFragment", "startLoadMore");
    WSRecommendFragment.a(this.a).a(false, false, "");
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    sai.b("WSRecommendFragment", "startTopRefresh");
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
 * Qualified Name:     rws
 * JD-Core Version:    0.7.0.1
 */