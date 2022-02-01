import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;

class ord
  extends pvq
{
  ord(oqy paramoqy) {}
  
  public void a(float paramFloat, int paramInt)
  {
    super.a(paramFloat, paramInt);
    paramFloat /= paramInt;
    oqy.a(this.a).setY((1.0F - paramFloat) * oqy.a(this.a).getHeight() * 0.03F);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    super.a(paramTabChannelCoverInfo);
    if (paramTabChannelCoverInfo != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelTabSelected, channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), ", channelName = ", paramTabChannelCoverInfo.mChannelCoverName });
      oqy.a(paramTabChannelCoverInfo.mChannelCoverId, 1);
      this.a.c(paramTabChannelCoverInfo.mChannelCoverId);
      oqy.a(this.a);
      if (bmhv.E())
      {
        oqy.b(this.a, paramTabChannelCoverInfo);
        oqy.b(this.a, oqy.a(this.a, oqy.a(this.a)));
      }
    }
    try
    {
      oqy.a("0X8009B94", "", new pqg().a("source", "303").a(paramTabChannelCoverInfo.mChannelCoverId).b("style", 0).a());
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
    paramInt = this.a.c();
    oqy.a(this.a, paramInt);
    oqy.a(this.a).a();
  }
  
  public void a(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onIndependentMainChannelListupdate, success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i) });
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      oqy.a(this.a, paramList);
    }
  }
  
  public void aj_()
  {
    super.aj_();
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 8;
    oqy.a(this.a, paramBoolean);
    if (!pli.a())
    {
      ImageView localImageView = oqy.a(this.a);
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    oqy.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ord
 * JD-Core Version:    0.7.0.1
 */