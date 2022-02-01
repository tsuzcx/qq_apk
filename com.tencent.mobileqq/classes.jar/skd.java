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

public class skd
  implements bdyc
{
  public skd(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView, View.OnClickListener paramOnClickListener1, String paramString1, int paramInt, String paramString2, Context paramContext, View.OnClickListener paramOnClickListener2) {}
  
  public void a(bdxj parambdxj, bdxk parambdxk, String paramString)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RefreshData localRefreshData = qtq.b(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView), 0);
    if (paramString.equals("close"))
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      parambdxj = new paa();
      for (;;)
      {
        try
        {
          parambdxj.e();
          parambdxj.a("skin_id", this.jdField_a_of_type_JavaLangString);
          parambdxj.a("channel_id", this.jdField_a_of_type_Int);
          if ((localRefreshData == null) || (!localRefreshData.isAD)) {
            continue;
          }
          parambdxj.a("ad_page", i);
        }
        catch (JSONException parambdxk)
        {
          parambdxk.printStackTrace();
          continue;
        }
        ocd.a(localQQAppInterface, "", "0X800969E", "0X800969E", 0, 0, this.jdField_a_of_type_JavaLangString, "" + ozs.e(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), parambdxj.a(), false);
        return;
        i = 0;
      }
    }
    if (paramString.equals("open_sound"))
    {
      parambdxj = parambdxj.a(anzj.a(2131711957));
      if (parambdxj != null) {
        parambdxj.c(0.0F);
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
          parambdxj = new paa();
          try
          {
            parambdxj.e();
            parambdxj.a("skin_id", this.jdField_a_of_type_JavaLangString);
            parambdxj.a("channel_id", this.jdField_a_of_type_Int);
            if ((localRefreshData == null) || (!localRefreshData.isAD)) {
              break label460;
            }
            i = 1;
            parambdxj.a("ad_page", i);
          }
          catch (JSONException parambdxk)
          {
            parambdxk.printStackTrace();
            continue;
          }
          ocd.a(localQQAppInterface, "", "0X800969D", "0X800969D", 0, 0, this.jdField_a_of_type_JavaLangString, "" + ozs.e(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), parambdxj.a(), false);
          return;
        }
        catch (Exception parambdxj)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(parambdxj));
          continue;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.isPlaying()) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.start();
        }
        catch (Exception parambdxj) {}
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(parambdxj));
          continue;
          label460:
          i = 0;
        }
      }
    }
    parambdxj = bhni.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    if (parambdxj != null)
    {
      parambdxj.a();
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView).onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
    }
    for (;;)
    {
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView, this.jdField_a_of_type_Int, paramString, ((bdxf)parambdxk).i_());
      return;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        parambdxj = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        parambdxj.putExtra("url", paramString);
        this.jdField_a_of_type_AndroidContentContext.startActivity(parambdxj);
        this.jdField_b_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skd
 * JD-Core Version:    0.7.0.1
 */