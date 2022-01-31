import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import cooperation.liveroom.LiveRoomProxyActivity;

class oun
  implements View.OnClickListener
{
  oun(ouk paramouk, opw paramopw, qoe paramqoe) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Opw.a() != null) && (this.jdField_a_of_type_Opw.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Opw.a().mSocialFeedInfo.a != null)) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_Qoe.a(), this.jdField_a_of_type_Opw.a().mSocialFeedInfo.a.c, "kandian biu feed click");
    }
    qpj localqpj;
    do
    {
      return;
      localqpj = this.jdField_a_of_type_Qoe.a();
    } while (localqpj == null);
    localqpj.a(paramView, this.jdField_a_of_type_Opw.a(), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oun
 * JD-Core Version:    0.7.0.1
 */