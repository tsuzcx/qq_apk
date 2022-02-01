import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.liveroom.LiveRoomProxyActivity;

class qqn
  implements View.OnClickListener
{
  qqn(qql paramqql, int paramInt, szd paramszd, qfw paramqfw) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 120) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Szd.a(), this.jdField_a_of_type_Qfw.a().mSocialFeedInfo.a.c, "kandian feed click");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pnw localpnw = this.jdField_a_of_type_Szd.a().a();
      if (localpnw != null) {
        localpnw.a(paramView, this.jdField_a_of_type_Qfw.a(), 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqn
 * JD-Core Version:    0.7.0.1
 */