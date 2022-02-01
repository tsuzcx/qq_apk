import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class svz
  implements View.OnClickListener
{
  svz(svy paramsvy) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(this.a.a, 2, 0, 0);
    FastWebActivity.a(this.a.a).b(2, FastWebActivity.a(this.a.a), this.a.a.a.innerUniqueID);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svz
 * JD-Core Version:    0.7.0.1
 */