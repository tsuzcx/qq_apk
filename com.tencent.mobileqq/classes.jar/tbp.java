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

public class tbp
  implements bdys
{
  public tbp(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView, View.OnClickListener paramOnClickListener1, String paramString1, int paramInt, String paramString2, Context paramContext, View.OnClickListener paramOnClickListener2) {}
  
  public void a(bdxz parambdxz, bdya parambdya, String paramString)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RefreshData localRefreshData = rmu.b(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView), 0);
    if (paramString.equals("close"))
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      parambdxz = new pqg();
      for (;;)
      {
        try
        {
          parambdxz.e();
          parambdxz.a("skin_id", this.jdField_a_of_type_JavaLangString);
          parambdxz.a("channel_id", this.jdField_a_of_type_Int);
          if ((localRefreshData == null) || (!localRefreshData.isAD)) {
            continue;
          }
          parambdxz.a("ad_page", i);
        }
        catch (JSONException parambdya)
        {
          parambdya.printStackTrace();
          continue;
        }
        olh.a(localQQAppInterface, "", "0X800969E", "0X800969E", 0, 0, this.jdField_a_of_type_JavaLangString, "" + pqu.a(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), parambdxz.a(), false);
        return;
        i = 0;
      }
    }
    if (paramString.equals("open_sound"))
    {
      parambdxz = parambdxz.a(anvx.a(2131712536));
      if (parambdxz != null) {
        parambdxz.c(0.0F);
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
          parambdxz = new pqg();
          try
          {
            parambdxz.e();
            parambdxz.a("skin_id", this.jdField_a_of_type_JavaLangString);
            parambdxz.a("channel_id", this.jdField_a_of_type_Int);
            if ((localRefreshData == null) || (!localRefreshData.isAD)) {
              break label460;
            }
            i = 1;
            parambdxz.a("ad_page", i);
          }
          catch (JSONException parambdya)
          {
            parambdya.printStackTrace();
            continue;
          }
          olh.a(localQQAppInterface, "", "0X800969D", "0X800969D", 0, 0, this.jdField_a_of_type_JavaLangString, "" + pqu.a(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), parambdxz.a(), false);
          return;
        }
        catch (Exception parambdxz)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(parambdxz));
          continue;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.isPlaying()) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.start();
        }
        catch (Exception parambdxz) {}
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(parambdxz));
          continue;
          label460:
          i = 0;
        }
      }
    }
    parambdxz = bhey.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    if (parambdxz != null)
    {
      parambdxz.a();
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView).onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
    }
    for (;;)
    {
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView, this.jdField_a_of_type_Int, paramString, ((bdxv)parambdya).g_());
      return;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        parambdxz = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        parambdxz.putExtra("url", paramString);
        this.jdField_a_of_type_AndroidContentContext.startActivity(parambdxz);
        this.jdField_b_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbp
 * JD-Core Version:    0.7.0.1
 */