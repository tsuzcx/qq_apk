import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class ovp
  implements bibd
{
  public ovp(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment) {}
  
  public void a()
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "endOfRefresh.");
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "startLoadMore.");
    paramXRecyclerView = ovz.a();
    if (paramXRecyclerView != null) {
      paramXRecyclerView.a(ReadInJoyCGIDynamicChannelFragment.f(this.a), ReadInJoyCGIDynamicChannelFragment.a(this.a).a(), 10);
    }
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "startTopRefresh.");
    paramXRecyclerView = ovz.a();
    if (paramXRecyclerView != null) {
      paramXRecyclerView.a(ReadInJoyCGIDynamicChannelFragment.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ovp
 * JD-Core Version:    0.7.0.1
 */