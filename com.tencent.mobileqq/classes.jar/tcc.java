import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class tcc
  implements bibd
{
  public tcc(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a()
  {
    tlo.b("WSRecommendFragment", "endOfRefresh");
    this.a.a.d();
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    tlo.b("WSRecommendFragment", "startLoadMore");
    ((tjl)this.a.b()).a(false, false, "");
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    tlo.b("WSRecommendFragment", "startTopRefresh");
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
      ((tjl)this.a.b()).a(true, false, "");
    } while (WSRecommendFragment.c(this.a));
    ((tjl)this.a.b()).a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcc
 * JD-Core Version:    0.7.0.1
 */