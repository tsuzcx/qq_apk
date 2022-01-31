import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;

public class org
  extends osp
{
  public org(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment) {}
  
  public void a(int paramInt, List<Long> paramList)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.a(this.a)) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyDynamicChannelFragment.a(this.a).a(osj.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.b(this.a)), paramList));
      ReadInJoyDynamicChannelFragment.a(this.a).a(true, true);
    }
    for (;;)
    {
      paramList = osj.a().a();
      if (paramList == null) {
        break;
      }
      ReadInJoyDynamicChannelFragment.a(this.a, paramList.a(ReadInJoyDynamicChannelFragment.c(this.a)));
      return;
      ReadInJoyDynamicChannelFragment.b(this.a).b();
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    ReadInJoyDynamicChannelFragment.a(this.a, paramTopBannerInfo);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.d(this.a)) {
      return;
    }
    paramInt = osj.a().a(Integer.valueOf(paramInt));
    if ((paramBoolean1) && (paramInt > 0)) {}
    for (String str = String.format(this.a.getResources().getString(2131718327), new Object[] { Integer.valueOf(paramInt) });; str = this.a.getResources().getString(2131718326))
    {
      ReadInJoyDynamicChannelFragment.c(this.a).a(paramBoolean1, str);
      if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
        ReadInJoyDynamicChannelFragment.a(this.a).a(osj.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.e(this.a)), paramList));
      }
      ReadInJoyDynamicChannelFragment.d(this.a).a(true, true);
      return;
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.f(this.a)) {
      return;
    }
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyDynamicChannelFragment.a(this.a).a(osj.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.g(this.a)), paramList));
    }
    ReadInJoyDynamicChannelFragment.e(this.a).a(paramBoolean1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     org
 * JD-Core Version:    0.7.0.1
 */