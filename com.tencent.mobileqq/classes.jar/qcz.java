import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.liveroom.LiveRoomProxyActivity;

class qcz
  implements View.OnClickListener
{
  qcz(qcw paramqcw, pxk parampxk, snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Pxk.a() != null) && (this.jdField_a_of_type_Pxk.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.a != null)) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Snh.a(), this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.a.c, "kandian biu feed click");
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
 * Qualified Name:     qcz
 * JD-Core Version:    0.7.0.1
 */