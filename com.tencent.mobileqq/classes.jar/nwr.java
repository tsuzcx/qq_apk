import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;

class nwr
  extends oxe
{
  nwr(nwm paramnwm) {}
  
  public void a(float paramFloat, int paramInt)
  {
    super.a(paramFloat, paramInt);
    paramFloat /= paramInt;
    nwm.a(this.a).setY((1.0F - paramFloat) * nwm.a(this.a).getHeight() * 0.03F);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    super.a(paramTabChannelCoverInfo);
    if (paramTabChannelCoverInfo != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelTabSelected, channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), ", channelName = ", paramTabChannelCoverInfo.mChannelCoverName });
      nwm.a(paramTabChannelCoverInfo.mChannelCoverId, 1);
      this.a.c(paramTabChannelCoverInfo.mChannelCoverId);
      nwm.a(this.a);
      if (bkbq.A())
      {
        nwm.b(this.a, paramTabChannelCoverInfo);
        nwm.b(this.a, nwm.a(this.a, nwm.a(this.a)));
      }
    }
    try
    {
      nwm.a("0X8009B94", "", new orz().a("source", "303").a(paramTabChannelCoverInfo.mChannelCoverId).b("style", 0).a());
      return;
    }
    catch (JSONException paramTabChannelCoverInfo)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "report click channel bar exception, e = ", paramTabChannelCoverInfo);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    paramInt = this.a.b();
    nwm.a(this.a, paramInt);
    nwm.a(this.a).a();
  }
  
  public void a(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onIndependentMainChannelListupdate, success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i) });
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      nwm.a(this.a, paramList);
    }
  }
  
  public void au_()
  {
    super.au_();
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 8;
    nwm.a(this.a, paramBoolean);
    if (!otb.a())
    {
      ImageView localImageView = nwm.a(this.a);
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    nwm.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nwr
 * JD-Core Version:    0.7.0.1
 */