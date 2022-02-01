import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.handlers.ViolaHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.widget.AbsListView;

public class pnf
  extends pmk
{
  private tjz a = new tjz();
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    ViolaSDKManager.getInstance().getDomManager().post(new ViolaHandler.1(this, paramBaseArticleInfo));
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560369, paramViewGroup, false);
      localView.setTag(new png(this.a, (WormholeView)localView, this));
    }
    paramView = (png)localView.getTag();
    paramViewGroup = a(paramInt);
    if ((paramViewGroup instanceof BaseArticleInfo))
    {
      paramViewGroup = (BaseArticleInfo)paramViewGroup;
      paramView.a(paramInt);
      paramView.a(paramViewGroup);
      paramView.a(paramViewGroup, paramInt);
    }
    return localView;
  }
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    a(paramBaseArticleInfo);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null) {
      this.a.a(paramAbsListView);
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 136;
  }
  
  public void e()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnf
 * JD-Core Version:    0.7.0.1
 */