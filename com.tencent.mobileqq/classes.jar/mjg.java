import android.content.Context;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class mjg
  implements Runnable
{
  public mjg(ReadInJoySkinGuideView paramReadInJoySkinGuideView, QQAppInterface paramQQAppInterface, String paramString1, View.OnClickListener paramOnClickListener1, String paramString2, View.OnClickListener paramOnClickListener2, Context paramContext) {}
  
  public void run()
  {
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260);
    new SceneBuilder().a(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a.getWidth()).a(new mjj(this)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a, new mjh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjg
 * JD-Core Version:    0.7.0.1
 */