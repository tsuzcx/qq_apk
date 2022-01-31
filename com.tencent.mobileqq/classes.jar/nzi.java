import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;
import org.json.JSONException;
import org.json.JSONObject;

public class nzi
  implements qtb
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private HashMap<String, qjc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private nmj jdField_a_of_type_Nmj;
  private qjc jdField_a_of_type_Qjc;
  private qmp jdField_a_of_type_Qmp;
  private qnu jdField_a_of_type_Qnu;
  private qta jdField_a_of_type_Qta;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  private boolean jdField_b_of_type_Boolean;
  private Set<String> jdField_c_of_type_JavaUtilSet;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 1;
    case 3: 
      return 1;
    case 4: 
      return 4;
    case 5: 
      return 2;
    }
    return 2;
  }
  
  private JSONObject a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = 3;
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("source_id", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int);
        localJSONObject2.put("platform_id", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_Int);
        localJSONObject2.put("goods_type", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int);
        localJSONObject2.put("goods_id", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.i);
        localJSONObject2.put("goods_name", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.j);
        localJSONObject2.put("account_id", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_Int);
        localJSONObject2.put("content_type", 1);
        localJSONObject2.put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey);
        localJSONObject2.put("cmsid", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.w);
        if (paramInt3 != -1) {
          localJSONObject2.put("button_state", paramInt3);
        }
        if (this.e)
        {
          paramInt3 = i;
          if (this.jdField_b_of_type_Boolean) {
            paramInt3 = 4;
          }
          localJSONObject2.put("card_style", paramInt3);
          if (paramBoolean) {
            localJSONObject2.put("is_ams_reported", 1);
          }
          if (paramInt1 == nmc.jdField_a_of_type_Int)
          {
            if (paramInt2 != 0) {
              localJSONObject2.put("click_pos", paramInt2);
            }
            localJSONObject2.put("link_type", this.jdField_b_of_type_Int);
            localJSONObject2.put("click_type", 3);
            localJSONObject1.put("click_info_report", localJSONObject2.toString());
            return localJSONObject1;
          }
        }
        else
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label355;
          }
          paramInt3 = 1;
          continue;
        }
        localJSONObject2.put("exposure_type", 3);
        localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
        return localJSONObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
      label355:
      paramInt3 = 0;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    nmc.a(new nyd().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt1).b(nmc.al).e(a(paramInt1, paramInt2, paramInt3, paramBoolean)).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private boolean a(VideoInfo paramVideoInfo, double paramDouble, long paramLong)
  {
    double d1 = paramLong / 1000L * paramDouble / 100.0D;
    if (this.e)
    {
      if (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.y)) {
        break label148;
      }
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.y.equals("1")) {
        if (paramDouble <= Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.z).intValue()) {}
      }
    }
    while (paramDouble > this.jdField_a_of_type_Int)
    {
      int i;
      do
      {
        return true;
        return false;
        if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.y.equals("2")) {
          break;
        }
        i = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.A).intValue();
      } while ((d1 != 0.0D) && (d1 > i));
      return false;
    }
    return false;
    label148:
    return false;
  }
  
  private CharSequence b()
  {
    float f1 = 13.0F;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k = "";
    }
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l + " " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
    if (!TextUtils.isEmpty(str1.trim()))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
      int i;
      int j;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l))
      {
        str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l;
        if (str1.contains(str2))
        {
          i = str1.indexOf(str2);
          j = str2.length() + i;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4060")), i, j, 33);
          localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(actj.a(13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
          localSpannableStringBuilder.setSpan(new nzj(actj.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), j, j + 1, 33);
        }
      }
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      if ((!TextUtils.isEmpty(str2)) && (str1.contains(str2)))
      {
        i = str1.indexOf(str2);
        j = str2.length() + i;
        if (c()) {
          break label399;
        }
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        if (!c()) {
          break label424;
        }
      }
      for (;;)
      {
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(actj.a(f1, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
        return localSpannableStringBuilder;
        label399:
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), i, j, 33);
        break;
        label424:
        f1 = 11.0F;
      }
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(paramInt);
      }
      return;
      paramInt = 41;
      continue;
      paramInt = 42;
      continue;
      paramInt = 8;
      continue;
      paramInt = 40;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0, paramInt2, false);
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_Int;
      this.e = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.x.equals("1");
      this.f = false;
    }
  }
  
  private String e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0);
  }
  
  private void h()
  {
    if (bbfr.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qjc.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Qmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_Qmp.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718503));
    }
    while (this.jdField_a_of_type_Qjc.jdField_a_of_type_Int != 5) {
      return;
    }
    this.jdField_a_of_type_Qmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_Qmp.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718496));
  }
  
  private void i()
  {
    b(nmc.jdField_b_of_type_Int, -1);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      String str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null) {
        str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + "_B";
      }
      if ((this.jdField_c_of_type_JavaUtilSet != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(str)))
      {
        this.jdField_c_of_type_JavaUtilSet.add(str);
        i();
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
    {
      shq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 3, true);
      this.d = true;
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.h)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.g))) {
        break;
      }
      this.jdField_b_of_type_Int = 1;
    } while (shq.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.g, this.jdField_a_of_type_AndroidAppActivity));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.h)) {
      this.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      oai.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.h, "");
      this.d = false;
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_JavaLangString)) {
        this.jdField_b_of_type_Int = 2;
      }
    }
  }
  
  private void l()
  {
    if (this.e) {}
    for (ReadInjoyHeaderAdDownloadView localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Qmp.b;; localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Qmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView)
    {
      localReadInjoyHeaderAdDownloadView.a(this.jdField_a_of_type_Qjc.jdField_b_of_type_Int);
      return;
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int;
  }
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
        return localObject;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) {
        return b();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 2)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {}
        for (String str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)
        {
          localObject = str;
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) {
          return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo;
        }
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImg;
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    this.f = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nmj != null) {
      this.jdField_a_of_type_Nmj.b();
    }
  }
  
  protected void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_Qmp, paramInt1, paramInt2);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, qmp paramqmp)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Qmp = paramqmp;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12)
      {
        str = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localqjc2 = (qjc)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localqjc1 = localqjc2;
        if (localqjc2 == null)
        {
          localqjc1 = qjc.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localqjc1);
        }
        if (localqjc1 != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.n = localqjc1.jdField_d_of_type_JavaLangString;
          if ((nlt.a(BaseApplicationImpl.getApplication(), localqjc1)) || (bbfr.a(BaseApplicationImpl.getContext(), localqjc1.jdField_d_of_type_JavaLangString))) {
            localqjc1.jdField_a_of_type_Int = 5;
          }
          this.jdField_a_of_type_Qjc = localqjc1;
          if (!this.e) {
            break label237;
          }
          h();
          paramqmp.b.a(a(localqjc1.jdField_a_of_type_Int), localqjc1.jdField_b_of_type_Int);
        }
      }
    }
    label237:
    while (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 1) {
      for (;;)
      {
        paramqmp.t.setTag(2131379213, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
        if (!this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Qnu.a();
          i();
        }
        return;
        paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(a(localqjc1.jdField_a_of_type_Int), localqjc1.jdField_b_of_type_Int);
      }
    }
    String str = paramVideoInfo.jdField_a_of_type_JavaLangString;
    qjc localqjc2 = (qjc)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    qjc localqjc1 = localqjc2;
    if (localqjc2 == null)
    {
      localqjc1 = qjc.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localqjc1);
    }
    if ((nlt.a(BaseApplicationImpl.getApplication(), localqjc1)) || (bbfr.a(BaseApplicationImpl.getContext(), localqjc1.jdField_d_of_type_JavaLangString))) {
      localqjc1.jdField_a_of_type_Int = 5;
    }
    this.jdField_a_of_type_Qjc = localqjc1;
    if (this.e)
    {
      h();
      paramqmp.b.a(a(localqjc1.jdField_a_of_type_Int), localqjc1.jdField_b_of_type_Int);
    }
    for (;;)
    {
      d();
      break;
      paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(a(localqjc1.jdField_a_of_type_Int), localqjc1.jdField_b_of_type_Int);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_c_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Nmj = new nmj(paramActivity, true, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Qnu = new qnu(paramQQAppInterface);
  }
  
  public void a(qmp paramqmp)
  {
    LinearLayout.LayoutParams localLayoutParams1;
    if (!this.e)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)paramqmp.w.getLayoutParams();
      if (TextUtils.isEmpty(paramqmp.Q.getText().toString().trim()))
      {
        paramqmp.Q.setVisibility(8);
        localLayoutParams1.gravity = 16;
        paramqmp.w.setLayoutParams(localLayoutParams1);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
          break label209;
        }
        paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
        paramqmp.w.setVisibility(0);
        label111:
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString))) {
          paramqmp.P.setText(e());
        }
      }
    }
    for (;;)
    {
      return;
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)paramqmp.Q.getLayoutParams();
      localLayoutParams2.topMargin = actj.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramqmp.Q.setLayoutParams(localLayoutParams2);
      paramqmp.Q.setVisibility(0);
      localLayoutParams1.gravity = 16;
      break;
      label209:
      paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(0);
      paramqmp.w.setVisibility(8);
      break label111;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 1))
      {
        paramqmp.b.setVisibility(8);
        paramqmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString)))
      {
        paramqmp.S.setText(e());
        return;
        paramqmp.b.setVisibility(0);
        paramqmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
  }
  
  public void a(qmp paramqmp, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qjc == null) {
      return;
    }
    this.jdField_a_of_type_Qjc.jdField_b_of_type_Int = paramInt2;
    if (paramInt1 != 8) {
      this.jdField_a_of_type_Qjc.jdField_a_of_type_Int = paramInt1;
    }
    this.jdField_c_of_type_Boolean = false;
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
      return;
    case 1: 
      if (this.e)
      {
        paramqmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramqmp.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718503));
        paramqmp.b.a(2, 100);
      }
    case 3: 
    case 5: 
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        if (!this.e) {
          break label294;
        }
        paramqmp.b.setVisibility(0);
        return;
        l();
        if (!this.e) {
          break;
        }
        paramqmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
        if (this.e)
        {
          paramqmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramqmp.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718496));
          paramqmp.b.a(2, 100);
          this.jdField_c_of_type_Boolean = true;
          if (this.jdField_b_of_type_Boolean)
          {
            if (!this.e) {
              break label270;
            }
            paramqmp.b.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt1);
          return;
          paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(2, 100);
          break;
          paramqmp.x.setVisibility(0);
        }
        paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(2, 100);
      }
      paramqmp.x.setVisibility(0);
      return;
    case 4: 
      if (this.e)
      {
        paramqmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramqmp.b.a(4, paramInt2);
        return;
      }
      paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(4, paramInt2);
      return;
    case 6: 
      label270:
      label294:
      if (this.e)
      {
        paramqmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramqmp.b.a(0, 0);
      }
      for (;;)
      {
        bcql.a(this.jdField_a_of_type_AndroidAppActivity, ajya.a(2131716249), 0).a();
        return;
        paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(0, 0);
      }
    }
    c();
  }
  
  public void a(qta paramqta)
  {
    this.jdField_a_of_type_Qta = paramqta;
  }
  
  public boolean a()
  {
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 2)) {
      bool = true;
    }
    while ((bool) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 2))
    {
      String str1 = b();
      String str2 = a();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    if (MainService.isDebugVersion) {}
    do
    {
      do
      {
        return true;
      } while (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
      if (oar.a(this.jdField_a_of_type_Qnu)) {
        return false;
      }
    } while (!this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public boolean a(VideoInfo paramVideoInfo, qmp paramqmp, double paramDouble, long paramLong)
  {
    if ((paramqmp.t != null) && (paramqmp.t.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "进度判断 video_percent=" + paramDouble);
      }
      return a(paramVideoInfo, paramDouble, paramLong);
    }
    return false;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_Qjc == null) {
      return 0;
    }
    return this.jdField_a_of_type_Qjc.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {
          break label135;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) {
          break label74;
        }
        str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName;
      }
    }
    return str1;
    label74:
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc;
      }
      return ajya.a(2131716164);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt;
    label135:
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_JavaLangString)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_JavaLangString;
      }
      return ajya.a(2131716201);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  protected void b()
  {
    if ((d()) && (this.jdField_a_of_type_Qjc != null))
    {
      if ((this.jdField_a_of_type_Qjc.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qjc.jdField_d_of_type_JavaLangString))) {
        oar.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qjc.jdField_d_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    shq.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  public void b(qmp paramqmp)
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_Qjc == null) {
      return 0;
    }
    return this.jdField_a_of_type_Qjc.jdField_a_of_type_Int;
  }
  
  public String c()
  {
    String str2 = "详情";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.C)) {
            str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.C;
          }
        }
      }
    }
    return str1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Qjc == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Qjc.jdField_a_of_type_Int == 4)
        {
          a(this.jdField_a_of_type_Qmp, 4, b());
          return;
        }
        if (this.jdField_a_of_type_Qjc.jdField_a_of_type_Int == 5)
        {
          String str = this.jdField_a_of_type_Qjc.jdField_d_of_type_JavaLangString;
          if (bbfr.a(BaseApplicationImpl.getContext(), str))
          {
            this.jdField_a_of_type_Qjc.jdField_a_of_type_Int = 1;
            a(this.jdField_a_of_type_Qmp, 1, b());
            return;
          }
          a(this.jdField_a_of_type_Qmp, 5, b());
          return;
        }
      } while (this.jdField_a_of_type_Qjc.jdField_a_of_type_Int != 3);
      a(this.jdField_a_of_type_Qmp, 3, b());
    } while ((this.jdField_a_of_type_Qjc == null) || (this.jdField_a_of_type_Nmj == null));
    this.jdField_a_of_type_Nmj.a(this.jdField_a_of_type_Qjc);
    return;
    int i = nmc.jdField_a_of_type_Int;
    if (nlt.a(this.jdField_a_of_type_Qjc, c()))
    {
      f();
      this.jdField_a_of_type_Qjc.jdField_a_of_type_Int = 5;
      b(i, 3);
      return;
    }
    e();
    b(i, 0);
  }
  
  public void c(qmp paramqmp)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_c_of_type_Boolean)
    {
      if (!this.e) {
        break label39;
      }
      paramqmp.b.setVisibility(0);
    }
    for (;;)
    {
      if (this.e) {
        j();
      }
      return;
      label39:
      paramqmp.x.setVisibility(0);
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public String d()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.D)) {
            str1 = "来自" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.D;
          }
        }
      }
    }
    return str1;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Nmj != null) && (this.jdField_a_of_type_Qjc != null)) {
      this.jdField_a_of_type_Nmj.b(this.jdField_a_of_type_Qjc);
    }
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Nmj != null) && (this.jdField_a_of_type_Qjc != null)) {
      this.jdField_a_of_type_Nmj.a(this.jdField_a_of_type_Qjc);
    }
    if ((this.jdField_a_of_type_Qmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView != null) || ((this.jdField_a_of_type_Qmp.b != null) && (this.jdField_a_of_type_Qjc != null))) {
      l();
    }
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_Qjc != null) && (this.jdField_a_of_type_Nmj != null)) {
      this.jdField_a_of_type_Nmj.e(this.jdField_a_of_type_Qjc);
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_Qjc != null) && (this.jdField_a_of_type_Nmj != null)) {
      this.jdField_a_of_type_Nmj.a(this.jdField_a_of_type_Qjc, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int k = 0;
    int i = 0;
    int j = 1;
    qmp localqmp = (qmp)paramView.getTag();
    int m = nmc.jdField_a_of_type_Int;
    this.jdField_a_of_type_Boolean = true;
    switch (paramView.getId())
    {
    default: 
    case 2131361958: 
    case 2131361957: 
    case 2131361960: 
    case 2131367491: 
    case 2131378971: 
    case 2131378972: 
      do
      {
        return;
        if (this.jdField_a_of_type_Qta != null) {
          this.jdField_a_of_type_Qta.a();
        }
        this.f = true;
        b(paramView.getId());
        a(m, 3, -1, false);
        return;
        b(paramView.getId());
        if (!this.e) {
          break label248;
        }
        if ((a() != 1) || (paramView.getId() != 2131361957) || (localqmp == null)) {
          break;
        }
        localqmp.b.callOnClick();
      } while (localqmp.b.a() == 2);
      localqmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramView.getId() == 2131361957) {}
      for (i = 1;; i = 0)
      {
        a(m, i, -1, e());
        k();
        return;
      }
      label248:
      if (paramView.getId() == 2131367491) {}
      for (i = j;; i = 0)
      {
        a(m, i, -1, e());
        break;
      }
    }
    if (this.e)
    {
      j = localqmp.b.a();
      if (j != 2) {
        break label462;
      }
      if (!bbfr.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qjc.jdField_d_of_type_JavaLangString)) {
        break label356;
      }
      i = 5;
      b();
      this.jdField_a_of_type_Qjc.jdField_a_of_type_Int = 1;
    }
    label462:
    for (;;)
    {
      a(m, 1, i, this.d);
      return;
      j = localqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a();
      break;
      label356:
      if (nlu.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qjc))
      {
        paramView = bdhk.a().c(this.jdField_a_of_type_Qjc.jdField_d_of_type_JavaLangString);
        bdhk.a().a(paramView);
        this.jdField_a_of_type_Qjc.jdField_a_of_type_Int = 5;
        i = 3;
      }
      else if (nlt.a(this.jdField_a_of_type_Qjc, this.jdField_a_of_type_Qjc.jdField_a_of_type_Int))
      {
        f();
        this.jdField_a_of_type_Qjc.jdField_a_of_type_Int = 5;
        i = 3;
      }
      else if (bbfj.h(BaseApplicationImpl.getContext()))
      {
        e();
      }
      else
      {
        k();
        continue;
        if ((j == 0) || (j == 4))
        {
          i = k;
          if (j == 4) {
            i = 2;
          }
          if (bbfj.h(BaseApplicationImpl.getContext()))
          {
            if (j == 0)
            {
              d();
              return;
            }
            e();
          }
          else
          {
            k();
          }
        }
        else if (j == 1)
        {
          g();
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzi
 * JD-Core Version:    0.7.0.1
 */