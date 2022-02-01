import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.liveroom.LiveRoomProxyActivity;

class pyr
  implements View.OnClickListener
{
  pyr(pyp parampyp, int paramInt, sel paramsel, ppu paramppu) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 120) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Sel.a(), this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a.c, "kandian feed click");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      sgf localsgf = this.jdField_a_of_type_Sel.a();
      if (localsgf != null) {
        localsgf.a(paramView, this.jdField_a_of_type_Ppu.a(), 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyr
 * JD-Core Version:    0.7.0.1
 */