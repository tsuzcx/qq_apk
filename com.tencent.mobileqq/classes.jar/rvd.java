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

public class rvd
  implements azzu
{
  public rvd(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView, View.OnClickListener paramOnClickListener1, String paramString1, int paramInt, String paramString2, Context paramContext, View.OnClickListener paramOnClickListener2) {}
  
  public void a(azzb paramazzb, azzc paramazzc, String paramString)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RefreshData localRefreshData = qiu.b(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView), 0);
    if (paramString.equals("close"))
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      paramazzb = new orz();
      for (;;)
      {
        try
        {
          paramazzb.e();
          paramazzb.a("skin_id", this.jdField_a_of_type_JavaLangString);
          paramazzb.a("channel_id", this.jdField_a_of_type_Int);
          if ((localRefreshData == null) || (!localRefreshData.isAD)) {
            continue;
          }
          paramazzb.a("ad_page", i);
        }
        catch (JSONException paramazzc)
        {
          paramazzc.printStackTrace();
          continue;
        }
        nrt.a(localQQAppInterface, "", "0X800969E", "0X800969E", 0, 0, this.jdField_a_of_type_JavaLangString, "" + ors.e(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), paramazzb.a(), false);
        return;
        i = 0;
      }
    }
    if (paramString.equals("open_sound"))
    {
      paramazzb = paramazzb.a(alpo.a(2131713457));
      if (paramazzb != null) {
        paramazzb.c(0.0F);
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
          paramazzb = new orz();
          try
          {
            paramazzb.e();
            paramazzb.a("skin_id", this.jdField_a_of_type_JavaLangString);
            paramazzb.a("channel_id", this.jdField_a_of_type_Int);
            if ((localRefreshData == null) || (!localRefreshData.isAD)) {
              break label460;
            }
            i = 1;
            paramazzb.a("ad_page", i);
          }
          catch (JSONException paramazzc)
          {
            paramazzc.printStackTrace();
            continue;
          }
          nrt.a(localQQAppInterface, "", "0X800969D", "0X800969D", 0, 0, this.jdField_a_of_type_JavaLangString, "" + ors.e(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), paramazzb.a(), false);
          return;
        }
        catch (Exception paramazzb)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramazzb));
          continue;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.isPlaying()) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.start();
        }
        catch (Exception paramazzb) {}
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramazzb));
          continue;
          label460:
          i = 0;
        }
      }
    }
    paramazzb = bdds.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    if (paramazzb != null)
    {
      paramazzb.c();
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView).onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
    }
    for (;;)
    {
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView, this.jdField_a_of_type_Int, paramString, ((azyx)paramazzc).g_());
      return;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramazzb = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramazzb.putExtra("url", paramString);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramazzb);
        this.jdField_b_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rvd
 * JD-Core Version:    0.7.0.1
 */