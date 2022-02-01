import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.liveroom.LiveRoomProxyActivity;

class qgg
  implements View.OnClickListener
{
  qgg(qge paramqge, int paramInt, snh paramsnh, pxk parampxk) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 120) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Snh.a(), this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.a.c, "kandian feed click");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      spb localspb = this.jdField_a_of_type_Snh.a();
      if (localspb != null) {
        localspb.a(paramView, this.jdField_a_of_type_Pxk.a(), 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgg
 * JD-Core Version:    0.7.0.1
 */