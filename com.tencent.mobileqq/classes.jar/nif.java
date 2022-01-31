import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;

class nif
  extends ohe
{
  nif(nia paramnia) {}
  
  public void a(float paramFloat, int paramInt)
  {
    super.a(paramFloat, paramInt);
    paramFloat /= paramInt;
    nia.a(this.a).setY((1.0F - paramFloat) * nia.a(this.a).getHeight() * 0.03F);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int i = 1;
    super.a(paramTabChannelCoverInfo);
    if (paramTabChannelCoverInfo != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelTabSelected, channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), ", channelName = ", paramTabChannelCoverInfo.mChannelCoverName });
      nia.a(this.a);
      if (bgmq.A())
      {
        nia.b(this.a, paramTabChannelCoverInfo);
        nia.b(this.a, nia.a(this.a, nia.a(this.a)));
      }
      nia.a(paramTabChannelCoverInfo.mChannelCoverId, 1);
      this.a.c(paramTabChannelCoverInfo.mChannelCoverId);
    }
    try
    {
      paramTabChannelCoverInfo = new ocg().a("source", "303").a(paramTabChannelCoverInfo.mChannelCoverId);
      if (nhi.a()) {}
      for (;;)
      {
        nia.a("0X8009B94", "", paramTabChannelCoverInfo.b("style", i).a());
        return;
        i = 0;
      }
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
    nia.a(this.a, paramInt);
    nia.a(this.a).a();
  }
  
  public void a(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onIndependentMainChannelListupdate, success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i) });
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      nia.a(this.a, paramList);
    }
  }
  
  public void as_()
  {
    super.as_();
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 8;
    nia.a(this.a, paramBoolean);
    if (!odi.a())
    {
      ImageView localImageView = nia.a(this.a);
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    nia.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nif
 * JD-Core Version:    0.7.0.1
 */