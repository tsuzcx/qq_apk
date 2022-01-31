import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import cooperation.liveroom.LiveRoomProxyActivity;

class plp
  implements View.OnClickListener
{
  plp(plm paramplm, pgd parampgd, rqj paramrqj) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Pgd.a() != null) && (this.jdField_a_of_type_Pgd.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a != null)) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Rqj.a(), this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a.c, "kandian biu feed click");
    }
    rro localrro;
    do
    {
      return;
      localrro = this.jdField_a_of_type_Rqj.a();
    } while (localrro == null);
    localrro.a(paramView, this.jdField_a_of_type_Pgd.a(), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     plp
 * JD-Core Version:    0.7.0.1
 */