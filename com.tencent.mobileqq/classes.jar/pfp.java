import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import cooperation.liveroom.LiveRoomProxyActivity;

class pfp
  implements View.OnClickListener
{
  pfp(pfm parampfm, pax parampax, rap paramrap) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Pax.a() != null) && (this.jdField_a_of_type_Pax.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pax.a().mSocialFeedInfo.a != null)) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Rap.a(), this.jdField_a_of_type_Pax.a().mSocialFeedInfo.a.c, "kandian biu feed click");
    }
    rbu localrbu;
    do
    {
      return;
      localrbu = this.jdField_a_of_type_Rap.a();
    } while (localrbu == null);
    localrbu.a(paramView, this.jdField_a_of_type_Pax.a(), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfp
 * JD-Core Version:    0.7.0.1
 */