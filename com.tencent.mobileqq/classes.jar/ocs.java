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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;
import org.json.JSONException;
import org.json.JSONObject;

public class ocs
  implements rin
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private HashMap<String, qyj> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private npf jdField_a_of_type_Npf;
  private qyj jdField_a_of_type_Qyj;
  private rbt jdField_a_of_type_Rbt;
  private rcy jdField_a_of_type_Rcy;
  private rim jdField_a_of_type_Rim;
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
          if (paramInt1 == noy.jdField_a_of_type_Int)
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
    noy.a(new obk().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt1).b(noy.al).e(a(paramInt1, paramInt2, paramInt3, paramBoolean)).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
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
          localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(aepi.a(13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
          localSpannableStringBuilder.setSpan(new oct(aepi.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), j, j + 1, 33);
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
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(aepi.a(f1, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
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
    if (bdiv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qyj.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Rbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_Rbt.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718951));
    }
    while (this.jdField_a_of_type_Qyj.jdField_a_of_type_Int != 5) {
      return;
    }
    this.jdField_a_of_type_Rbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_Rbt.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718944));
  }
  
  private void i()
  {
    b(noy.jdField_b_of_type_Int, -1);
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
      szl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 3, true);
      this.d = true;
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.h)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.g))) {
        break;
      }
      this.jdField_b_of_type_Int = 1;
    } while (szl.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.g, this.jdField_a_of_type_AndroidAppActivity));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.h)) {
      this.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      odv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.h, "");
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
    for (ReadInjoyHeaderAdDownloadView localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Rbt.b;; localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Rbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView)
    {
      localReadInjoyHeaderAdDownloadView.a(this.jdField_a_of_type_Qyj.jdField_b_of_type_Int);
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
    if (this.jdField_a_of_type_Npf != null) {
      this.jdField_a_of_type_Npf.b();
    }
  }
  
  protected void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_Rbt, paramInt1, paramInt2);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, rbt paramrbt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Rbt = paramrbt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12)
      {
        str = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localqyj2 = (qyj)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localqyj1 = localqyj2;
        if (localqyj2 == null)
        {
          localqyj1 = qyj.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localqyj1);
        }
        if (localqyj1 != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.n = localqyj1.jdField_d_of_type_JavaLangString;
          if ((nop.a(BaseApplicationImpl.getApplication(), localqyj1)) || (bdiv.a(BaseApplicationImpl.getContext(), localqyj1.jdField_d_of_type_JavaLangString))) {
            localqyj1.jdField_a_of_type_Int = 5;
          }
          this.jdField_a_of_type_Qyj = localqyj1;
          if (!this.e) {
            break label237;
          }
          h();
          paramrbt.b.a(a(localqyj1.jdField_a_of_type_Int), localqyj1.jdField_b_of_type_Int);
        }
      }
    }
    label237:
    while (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 1) {
      for (;;)
      {
        paramrbt.u.setTag(2131379971, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
        if (!this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Rcy.a();
          i();
        }
        return;
        paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(a(localqyj1.jdField_a_of_type_Int), localqyj1.jdField_b_of_type_Int);
      }
    }
    String str = paramVideoInfo.jdField_a_of_type_JavaLangString;
    qyj localqyj2 = (qyj)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    qyj localqyj1 = localqyj2;
    if (localqyj2 == null)
    {
      localqyj1 = qyj.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localqyj1);
    }
    if ((nop.a(BaseApplicationImpl.getApplication(), localqyj1)) || (bdiv.a(BaseApplicationImpl.getContext(), localqyj1.jdField_d_of_type_JavaLangString))) {
      localqyj1.jdField_a_of_type_Int = 5;
    }
    this.jdField_a_of_type_Qyj = localqyj1;
    if (this.e)
    {
      h();
      paramrbt.b.a(a(localqyj1.jdField_a_of_type_Int), localqyj1.jdField_b_of_type_Int);
    }
    for (;;)
    {
      d();
      break;
      paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(a(localqyj1.jdField_a_of_type_Int), localqyj1.jdField_b_of_type_Int);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_c_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Npf = new npf(paramActivity, true, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Rcy = new rcy(paramQQAppInterface);
  }
  
  public void a(rbt paramrbt)
  {
    LinearLayout.LayoutParams localLayoutParams1;
    if (!this.e)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)paramrbt.w.getLayoutParams();
      if (TextUtils.isEmpty(paramrbt.Q.getText().toString().trim()))
      {
        paramrbt.Q.setVisibility(8);
        localLayoutParams1.gravity = 16;
        paramrbt.w.setLayoutParams(localLayoutParams1);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
          break label209;
        }
        paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
        paramrbt.w.setVisibility(0);
        label111:
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString))) {
          paramrbt.P.setText(e());
        }
      }
    }
    for (;;)
    {
      return;
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)paramrbt.Q.getLayoutParams();
      localLayoutParams2.topMargin = aepi.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrbt.Q.setLayoutParams(localLayoutParams2);
      paramrbt.Q.setVisibility(0);
      localLayoutParams1.gravity = 16;
      break;
      label209:
      paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(0);
      paramrbt.w.setVisibility(8);
      break label111;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 1))
      {
        paramrbt.b.setVisibility(8);
        paramrbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString)))
      {
        paramrbt.S.setText(e());
        return;
        paramrbt.b.setVisibility(0);
        paramrbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
  }
  
  public void a(rbt paramrbt, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qyj == null) {
      return;
    }
    this.jdField_a_of_type_Qyj.jdField_b_of_type_Int = paramInt2;
    if (paramInt1 != 8) {
      this.jdField_a_of_type_Qyj.jdField_a_of_type_Int = paramInt1;
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
        paramrbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramrbt.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718951));
        paramrbt.b.a(2, 100);
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
        paramrbt.b.setVisibility(0);
        return;
        l();
        if (!this.e) {
          break;
        }
        paramrbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
        if (this.e)
        {
          paramrbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramrbt.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718944));
          paramrbt.b.a(2, 100);
          this.jdField_c_of_type_Boolean = true;
          if (this.jdField_b_of_type_Boolean)
          {
            if (!this.e) {
              break label270;
            }
            paramrbt.b.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt1);
          return;
          paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(2, 100);
          break;
          paramrbt.x.setVisibility(0);
        }
        paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(2, 100);
      }
      paramrbt.x.setVisibility(0);
      return;
    case 4: 
      if (this.e)
      {
        paramrbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramrbt.b.a(4, paramInt2);
        return;
      }
      paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(4, paramInt2);
      return;
    case 6: 
      label270:
      label294:
      if (this.e)
      {
        paramrbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramrbt.b.a(0, 0);
      }
      for (;;)
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131716633), 0).a();
        return;
        paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(0, 0);
      }
    }
    c();
  }
  
  public void a(rim paramrim)
  {
    this.jdField_a_of_type_Rim = paramrim;
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
      if (oee.a(this.jdField_a_of_type_Rcy)) {
        return false;
      }
    } while (!this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public boolean a(VideoInfo paramVideoInfo, rbt paramrbt, double paramDouble, long paramLong)
  {
    if ((paramrbt.u != null) && (paramrbt.u.getVisibility() == 0))
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
    if (this.jdField_a_of_type_Qyj == null) {
      return 0;
    }
    return this.jdField_a_of_type_Qyj.jdField_b_of_type_Int;
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
      return alud.a(2131716548);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt;
    label135:
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_JavaLangString)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_JavaLangString;
      }
      return alud.a(2131716585);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  protected void b()
  {
    if ((d()) && (this.jdField_a_of_type_Qyj != null))
    {
      if ((this.jdField_a_of_type_Qyj.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qyj.jdField_d_of_type_JavaLangString))) {
        oee.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qyj.jdField_d_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    szl.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  public void b(rbt paramrbt)
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_Qyj == null) {
      return 0;
    }
    return this.jdField_a_of_type_Qyj.jdField_a_of_type_Int;
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
    if (this.jdField_a_of_type_Qyj == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Qyj.jdField_a_of_type_Int == 4)
        {
          a(this.jdField_a_of_type_Rbt, 4, b());
          return;
        }
        if (this.jdField_a_of_type_Qyj.jdField_a_of_type_Int == 5)
        {
          String str = this.jdField_a_of_type_Qyj.jdField_d_of_type_JavaLangString;
          if (bdiv.a(BaseApplicationImpl.getContext(), str))
          {
            this.jdField_a_of_type_Qyj.jdField_a_of_type_Int = 1;
            a(this.jdField_a_of_type_Rbt, 1, b());
            return;
          }
          a(this.jdField_a_of_type_Rbt, 5, b());
          return;
        }
      } while (this.jdField_a_of_type_Qyj.jdField_a_of_type_Int != 3);
      a(this.jdField_a_of_type_Rbt, 3, b());
    } while ((this.jdField_a_of_type_Qyj == null) || (this.jdField_a_of_type_Npf == null));
    this.jdField_a_of_type_Npf.a(this.jdField_a_of_type_Qyj);
    return;
    int i = noy.jdField_a_of_type_Int;
    if (nop.a(this.jdField_a_of_type_Qyj, c()))
    {
      f();
      this.jdField_a_of_type_Qyj.jdField_a_of_type_Int = 5;
      b(i, 3);
      return;
    }
    e();
    b(i, 0);
  }
  
  public void c(rbt paramrbt)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_c_of_type_Boolean)
    {
      if (!this.e) {
        break label39;
      }
      paramrbt.b.setVisibility(0);
    }
    for (;;)
    {
      if (this.e) {
        j();
      }
      return;
      label39:
      paramrbt.x.setVisibility(0);
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
    if ((this.jdField_a_of_type_Npf != null) && (this.jdField_a_of_type_Qyj != null)) {
      this.jdField_a_of_type_Npf.b(this.jdField_a_of_type_Qyj);
    }
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Npf != null) && (this.jdField_a_of_type_Qyj != null)) {
      this.jdField_a_of_type_Npf.a(this.jdField_a_of_type_Qyj);
    }
    if ((this.jdField_a_of_type_Rbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView != null) || ((this.jdField_a_of_type_Rbt.b != null) && (this.jdField_a_of_type_Qyj != null))) {
      l();
    }
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_Qyj != null) && (this.jdField_a_of_type_Npf != null)) {
      this.jdField_a_of_type_Npf.e(this.jdField_a_of_type_Qyj);
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_Qyj != null) && (this.jdField_a_of_type_Npf != null)) {
      this.jdField_a_of_type_Npf.a(this.jdField_a_of_type_Qyj, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int k = 0;
    int i = 0;
    int j = 1;
    rbt localrbt = (rbt)paramView.getTag();
    int m = noy.jdField_a_of_type_Int;
    this.jdField_a_of_type_Boolean = true;
    switch (paramView.getId())
    {
    default: 
    case 2131361960: 
    case 2131361959: 
    case 2131361962: 
    case 2131367629: 
    case 2131379686: 
    case 2131379687: 
      do
      {
        return;
        if (this.jdField_a_of_type_Rim != null) {
          this.jdField_a_of_type_Rim.a();
        }
        this.f = true;
        b(paramView.getId());
        a(m, 3, -1, false);
        return;
        b(paramView.getId());
        if (!this.e) {
          break label301;
        }
        if ((a() != 1) || (paramView.getId() != 2131361959) || (localrbt == null)) {
          break;
        }
        localrbt.b.callOnClick();
      } while (localrbt.b.a() == 2);
      localrbt.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramView.getId() == 2131361959) {}
      for (i = 1;; i = 0)
      {
        a(m, i, -1, e());
        if ((paramView.getId() != 2131361959) || (TextUtils.isEmpty(szl.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))) {
          break;
        }
        szl.a(this.jdField_a_of_type_AndroidAppActivity, szl.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdRl, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId);
        return;
      }
      label301:
      if (paramView.getId() == 2131367629) {}
      for (i = j;; i = 0)
      {
        a(m, i, -1, e());
        break;
      }
      k();
      return;
    }
    if (this.e)
    {
      j = localrbt.b.a();
      if (j != 2) {
        break label520;
      }
      if (!bdiv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qyj.jdField_d_of_type_JavaLangString)) {
        break label414;
      }
      i = 5;
      b();
      this.jdField_a_of_type_Qyj.jdField_a_of_type_Int = 1;
    }
    label520:
    for (;;)
    {
      a(m, 1, i, this.d);
      return;
      j = localrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a();
      break;
      label414:
      if (noq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qyj))
      {
        paramView = bfkr.a().c(this.jdField_a_of_type_Qyj.jdField_d_of_type_JavaLangString);
        bfkr.a().a(paramView);
        this.jdField_a_of_type_Qyj.jdField_a_of_type_Int = 5;
        i = 3;
      }
      else if (nop.a(this.jdField_a_of_type_Qyj, this.jdField_a_of_type_Qyj.jdField_a_of_type_Int))
      {
        f();
        this.jdField_a_of_type_Qyj.jdField_a_of_type_Int = 5;
        i = 3;
      }
      else if (bdin.h(BaseApplicationImpl.getContext()))
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
          if (bdin.h(BaseApplicationImpl.getContext()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ocs
 * JD-Core Version:    0.7.0.1
 */