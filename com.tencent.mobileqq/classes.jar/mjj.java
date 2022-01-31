import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.IButtonHandle;
import com.tencent.mobileqq.surfaceviewaction.gl.Layer;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class mjj
  implements SceneBuilder.IButtonHandle
{
  mjj(mjg parammjg) {}
  
  public void a(Layer paramLayer, Sprite paramSprite, String paramString)
  {
    if (paramString.equals("close"))
    {
      this.a.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView);
      PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C82", "0X8008C82", 0, 0, this.a.jdField_b_of_type_JavaLangString, "" + ReadInJoyUtils.e(), "" + ReadInJoySkinGuideView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView), "", false);
    }
    do
    {
      return;
      if (paramString.equals("use_skin"))
      {
        this.a.jdField_b_of_type_AndroidViewView$OnClickListener.onClick(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView);
        SharedPreUtils.r(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C83", "0X8008C83", 0, 0, this.a.jdField_b_of_type_JavaLangString, "" + ReadInJoyUtils.e(), "" + ReadInJoySkinGuideView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView), "", false);
        return;
      }
      if (paramString.equals("open_sound"))
      {
        paramLayer = (Sprite)paramLayer.a("声音红点");
        if (paramLayer != null) {
          paramLayer.e = 0.0F;
        }
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a == null) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a = new MediaPlayer();
        }
        for (;;)
        {
          try
          {
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a.setDataSource(this.a.jdField_a_of_type_JavaLangString + "/audio.mp3");
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a.prepare();
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a.start();
            PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C81", "0X8008C81", 0, 0, this.a.jdField_b_of_type_JavaLangString, "" + ReadInJoyUtils.e(), "" + ReadInJoySkinGuideView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView), "", false);
            return;
          }
          catch (Exception paramLayer)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(paramLayer));
            continue;
          }
          try
          {
            if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a.isPlaying()) {
              continue;
            }
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a.start();
          }
          catch (Exception paramLayer) {}
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(paramLayer));
          }
        }
      }
      paramLayer = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramString);
      if (paramLayer != null)
      {
        paramLayer.b();
        return;
      }
    } while ((!paramString.startsWith("https://")) && (!paramString.startsWith("http://")));
    paramLayer = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramLayer.putExtra("url", paramString);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramLayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjj
 * JD-Core Version:    0.7.0.1
 */