import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import cooperation.liveroom.LiveRoomProxyActivity;

class pfm
  implements View.OnClickListener
{
  pfm(pfj parampfj, pau parampau, ram paramram) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Pau.a() != null) && (this.jdField_a_of_type_Pau.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pau.a().mSocialFeedInfo.a != null)) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Ram.a(), this.jdField_a_of_type_Pau.a().mSocialFeedInfo.a.c, "kandian biu feed click");
    }
    rbr localrbr;
    do
    {
      return;
      localrbr = this.jdField_a_of_type_Ram.a();
    } while (localrbr == null);
    localrbr.a(paramView, this.jdField_a_of_type_Pau.a(), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfm
 * JD-Core Version:    0.7.0.1
 */