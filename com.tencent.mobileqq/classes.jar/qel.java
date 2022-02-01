import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.liveroom.LiveRoomProxyActivity;

class qel
  implements View.OnClickListener
{
  qel(qej paramqej, int paramInt, slt paramslt, pvc parampvc) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 120) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Slt.a(), this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a.c, "kandian feed click");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pet localpet = this.jdField_a_of_type_Slt.a().a();
      if (localpet != null) {
        localpet.a(paramView, this.jdField_a_of_type_Pvc.a(), 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qel
 * JD-Core Version:    0.7.0.1
 */