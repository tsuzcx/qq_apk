import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class qpo
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = qpo.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  qpo(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label89;
      }
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.c;
      localJSONObject.put("common_data", str1);
    }
    catch (Exception localException)
    {
      String str1;
      label31:
      String str2;
      break label31;
    }
    str2 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (str1 = paramVideoInfo.g;; str1 = "0")
    {
      nol.a(null, str2, "0X800A018", "0X800A018", 0, 0, "0", "0", str1, npu.a("", paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      return;
      label89:
      str1 = "";
      break;
    }
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.b)) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "innerCheckAdParamValid() 参数无效");
      }
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(179);
    if (localAladdinConfig == null) {
      return true;
    }
    if (localAladdinConfig.getIntegerFromString("like_action_download_bar_is_display", 1) == 1) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      i = localAladdinConfig.getIntegerFromString("like_action_download_bar_display_count_every_day", 2147483647);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "innerCheckIsNeedShow() 神灯配置 isNeedDisplay=" + bool + ", displayCountEveryDay=" + i);
      }
      if (bool) {
        break;
      }
      return false;
    }
    if (this.jdField_a_of_type_Int < 0) {
      this.jdField_a_of_type_Int = bhvy.H(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "innerCheckIsNeedShow() 本地显示次数(更新前) mLocalShowCountToday=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int < i)
    {
      this.jdField_a_of_type_Int += 1;
      return true;
    }
    return false;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Int > 0) {
      bhvy.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
    }
  }
  
  void a(VideoInfo paramVideoInfo, qmo paramqmo)
  {
    if ((paramqmo.j != null) && (paramqmo.j.getVisibility() == 0)) {}
    do
    {
      do
      {
        return;
      } while ((paramqmo.a != null) && (paramqmo.a.a != null) && (!paramqmo.a.a.l));
      if ((!a(paramVideoInfo)) || (!b())) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramqmo.j == null)
      {
        paramqmo.j = ((ViewGroup)((ViewStub)paramqmo.o.findViewById(2131378977)).inflate());
        paramqmo.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)paramqmo.j.findViewById(2131376125));
        paramqmo.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramqmo.j.findViewById(2131376126));
      }
    } while (paramqmo.j.getVisibility() == 0);
    if (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_JavaLangString)) {}
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bbll.a(32.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bbll.a(32.0F);
      localObject = URLDrawable.getDrawable(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(new int[] { 0, 0, baxn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 3.0F), 3 });
      ((URLDrawable)localObject).setDecodeHandler(bavw.j);
      paramqmo.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      label235:
      paramqmo.jdField_c_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.b);
      paramqmo.j.setOnClickListener(this);
      paramqmo.j.setTag(paramVideoInfo);
      paramqmo.j.setVisibility(0);
      qoi.a(paramqmo.j, 200);
      return;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      break label235;
    }
  }
  
  void a(qmo paramqmo)
  {
    if ((paramqmo.j != null) && (paramqmo.j.getVisibility() == 0)) {
      paramqmo.j.setVisibility(8);
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    paramView = (VideoInfo)paramView.getTag();
    qoi.a(this.jdField_a_of_type_AndroidAppActivity, paramView.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpo
 * JD-Core Version:    0.7.0.1
 */