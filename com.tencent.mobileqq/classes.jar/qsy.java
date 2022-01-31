import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinSlideDownView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class qsy
  implements axbt
{
  public qsy(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView, View.OnClickListener paramOnClickListener1, String paramString1, int paramInt, String paramString2, Context paramContext, View.OnClickListener paramOnClickListener2) {}
  
  public void a(axba paramaxba, axbb paramaxbb, String paramString)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RefreshData localRefreshData = pnh.b(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView), 0);
    if (paramString.equals("close"))
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      paramaxba = new ocg();
      for (;;)
      {
        try
        {
          paramaxba.e();
          paramaxba.a("skin_id", this.jdField_a_of_type_JavaLangString);
          paramaxba.a("channel_id", this.jdField_a_of_type_Int);
          if ((localRefreshData == null) || (!localRefreshData.isAD)) {
            continue;
          }
          paramaxba.a("ad_page", i);
        }
        catch (JSONException paramaxbb)
        {
          paramaxbb.printStackTrace();
          continue;
        }
        ndn.a(localQQAppInterface, "", "0X800969E", "0X800969E", 0, 0, this.jdField_a_of_type_JavaLangString, "" + obz.e(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), paramaxba.a(), false);
        return;
        i = 0;
      }
    }
    if (paramString.equals("open_sound"))
    {
      paramaxba = paramaxba.a(ajjy.a(2131647286));
      if (paramaxba != null) {
        paramaxba.c(0.0F);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a = new MediaPlayer();
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.setDataSource(this.jdField_b_of_type_JavaLangString + "/audio.mp3");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.prepare();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.start();
          paramaxba = new ocg();
          try
          {
            paramaxba.e();
            paramaxba.a("skin_id", this.jdField_a_of_type_JavaLangString);
            paramaxba.a("channel_id", this.jdField_a_of_type_Int);
            if ((localRefreshData == null) || (!localRefreshData.isAD)) {
              break label460;
            }
            i = 1;
            paramaxba.a("ad_page", i);
          }
          catch (JSONException paramaxbb)
          {
            paramaxbb.printStackTrace();
            continue;
          }
          ndn.a(localQQAppInterface, "", "0X800969D", "0X800969D", 0, 0, this.jdField_a_of_type_JavaLangString, "" + obz.e(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), paramaxba.a(), false);
          return;
        }
        catch (Exception paramaxba)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramaxba));
          continue;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.isPlaying()) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.start();
        }
        catch (Exception paramaxba) {}
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramaxba));
          continue;
          label460:
          i = 0;
        }
      }
    }
    paramaxba = bade.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    if (paramaxba != null)
    {
      paramaxba.c();
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView).onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
    }
    for (;;)
    {
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView, this.jdField_a_of_type_Int, paramString, ((axaw)paramaxbb).g_());
      return;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramaxba = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramaxba.putExtra("url", paramString);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramaxba);
        this.jdField_b_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsy
 * JD-Core Version:    0.7.0.1
 */