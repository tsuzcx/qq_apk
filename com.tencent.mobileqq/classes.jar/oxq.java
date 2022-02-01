import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

class oxq
  extends pvq
{
  private oxq(oxo paramoxo) {}
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (oxo.a(this.a) == paramInt))
    {
      oxo.a(this.a, (ArrayList)paramList);
      if ((oxo.a(this.a) == null) || (oxo.a(this.a) == null) || (oxo.a(this.a).size() <= 0)) {
        break label200;
      }
      oxo.a(this.a).a(oxo.a(this.a));
      oxo.a(this.a).notifyDataSetChanged();
      if (oxo.a(this.a).findHeaderViewPosition(oxo.a(this.a)) < 0) {
        oxo.a(this.a).addHeaderView(oxo.a(this.a));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onSubChannelListUpdate infos size" + oxo.a(this.a).size());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onSubChannelListUpdate" + paramBoolean);
      }
      return;
      label200:
      oxo.a(this.a).removeHeaderView(oxo.a(this.a));
    }
  }
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (oxo.a(this.a) == 0))
    {
      oxo.a(this.a, (ArrayList)paramList);
      if ((oxo.a(this.a) == null) || (oxo.a(this.a).size() <= 0)) {
        break label183;
      }
      oxo.a(this.a).a(oxo.a(this.a));
      oxo.a(this.a).notifyDataSetChanged();
      if (oxo.a(this.a).findHeaderViewPosition(oxo.a(this.a)) < 0) {
        oxo.a(this.a).addHeaderView(oxo.a(this.a));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate infos size" + oxo.a(this.a).size());
      }
      QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate" + paramBoolean);
      return;
      label183:
      oxo.a(this.a).removeHeaderView(oxo.a(this.a));
    }
  }
  
  public void c(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (oxo.a(this.a) == 56))
    {
      oxo.a(this.a, (ArrayList)paramList);
      if ((oxo.a(this.a) == null) || (oxo.a(this.a) == null) || (oxo.a(this.a).size() <= 0)) {
        break label201;
      }
      oxo.a(this.a).a(oxo.a(this.a));
      oxo.a(this.a).notifyDataSetChanged();
      if (oxo.a(this.a).findHeaderViewPosition(oxo.a(this.a)) < 0) {
        oxo.a(this.a).addHeaderView(oxo.a(this.a));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onVideoChannelListUpdate infos size" + oxo.a(this.a).size());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onVideoChannelListUpdate" + paramBoolean);
      }
      return;
      label201:
      oxo.a(this.a).removeHeaderView(oxo.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxq
 * JD-Core Version:    0.7.0.1
 */