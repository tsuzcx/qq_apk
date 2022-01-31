import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
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
import org.json.JSONException;
import org.json.JSONObject;

public class noa
  implements qgz
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private HashMap<String, pxh> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private nbl jdField_a_of_type_Nbl;
  private pxh jdField_a_of_type_Pxh;
  private qaq jdField_a_of_type_Qaq;
  private qbz jdField_a_of_type_Qbz;
  private boolean jdField_a_of_type_Boolean;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
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
    int i = 1;
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("source_id", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int);
        localJSONObject2.put("platform_id", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_Int);
        localJSONObject2.put("action_type", paramInt2);
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
        if (this.jdField_b_of_type_Boolean)
        {
          paramInt2 = i;
          localJSONObject2.put("card_style", paramInt2);
          if (paramBoolean) {
            localJSONObject2.put("is_ams_reported", 1);
          }
          if (paramInt1 == nbe.jdField_a_of_type_Int)
          {
            localJSONObject2.put("click_type", 3);
            localJSONObject1.put("click_info_report", localJSONObject2.toString());
            return localJSONObject1;
          }
          localJSONObject2.put("exposure_type", 3);
          localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
          return localJSONObject1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
      paramInt2 = 0;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, false);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    nbe.a(new nmv().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt1).b(nbe.al).e(a(paramInt1, paramInt2, paramInt3, paramBoolean)).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private CharSequence b()
  {
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
          localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(aciy.a(13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
          localSpannableStringBuilder.setSpan(new nob(aciy.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), j, j + 1, 33);
        }
      }
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      if ((!TextUtils.isEmpty(str2)) && (str1.contains(str2)))
      {
        i = str1.indexOf(str2);
        j = str2.length() + i;
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(aciy.a(11.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
      }
      return localSpannableStringBuilder;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_Int;
    }
  }
  
  private String c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  private void h()
  {
    a(nbe.jdField_b_of_type_Int, 1, -1);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
    {
      rvb.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 3, true);
      this.d = true;
    }
    while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.h)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.g)) && (rvb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.g, this.jdField_a_of_type_AndroidAppActivity))) {
      return;
    }
    npa.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.h, "");
    this.d = false;
  }
  
  private void j()
  {
    this.jdField_a_of_type_Qaq.a.a(this.jdField_a_of_type_Pxh.jdField_b_of_type_Int);
  }
  
  public int a()
  {
    int j = 1;
    int i = j;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 1) {
        i = 0;
      }
    }
    return i;
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nbl != null) {
      this.jdField_a_of_type_Nbl.b();
    }
  }
  
  protected void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_Qaq, paramInt1, paramInt2);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    b(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, qaq paramqaq)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Qaq = paramqaq;
    String str;
    pxh localpxh2;
    pxh localpxh1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12)
      {
        str = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localpxh2 = (pxh)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localpxh1 = localpxh2;
        if (localpxh2 == null)
        {
          localpxh1 = pxh.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localpxh1);
        }
        if (localpxh1 != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.n = localpxh1.jdField_d_of_type_JavaLangString;
          if ((nav.a(BaseApplicationImpl.getApplication(), localpxh1)) || (bady.a(BaseApplicationImpl.getContext(), localpxh1.jdField_d_of_type_JavaLangString))) {
            localpxh1.jdField_a_of_type_Int = 5;
          }
          this.jdField_a_of_type_Pxh = localpxh1;
          paramqaq.a.a(a(localpxh1.jdField_a_of_type_Int), localpxh1.jdField_b_of_type_Int);
        }
      }
    }
    for (;;)
    {
      paramqaq.u.setTag(2131313373, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Qbz.a();
        h();
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)
      {
        str = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localpxh2 = (pxh)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localpxh1 = localpxh2;
        if (localpxh2 == null)
        {
          localpxh1 = pxh.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localpxh1);
        }
        if ((nav.a(BaseApplicationImpl.getApplication(), localpxh1)) || (bady.a(BaseApplicationImpl.getContext(), localpxh1.jdField_d_of_type_JavaLangString))) {
          localpxh1.jdField_a_of_type_Int = 5;
        }
        this.jdField_a_of_type_Pxh = localpxh1;
        paramqaq.a.a(a(localpxh1.jdField_a_of_type_Int), localpxh1.jdField_b_of_type_Int);
        d();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Nbl = new nbl(paramActivity, true, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Qbz = new qbz(paramQQAppInterface);
  }
  
  public void a(qaq paramqaq)
  {
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)paramqaq.w.getLayoutParams();
    if (TextUtils.isEmpty(paramqaq.J.getText().toString().trim()))
    {
      paramqaq.J.setVisibility(8);
      localLayoutParams1.gravity = 16;
      paramqaq.w.setLayoutParams(localLayoutParams1);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
        break label202;
      }
      paramqaq.a.setVisibility(8);
      paramqaq.w.setVisibility(0);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString))) {
        paramqaq.I.setText(c());
      }
      return;
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)paramqaq.J.getLayoutParams();
      localLayoutParams2.topMargin = aciy.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramqaq.J.setLayoutParams(localLayoutParams2);
      paramqaq.J.setVisibility(0);
      localLayoutParams1.gravity = 16;
      break;
      label202:
      paramqaq.a.setVisibility(0);
      paramqaq.w.setVisibility(8);
    }
  }
  
  public void a(qaq paramqaq, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pxh == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Pxh.jdField_b_of_type_Int = paramInt2;
      if (paramInt1 != 8) {
        this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = paramInt1;
      }
      this.c = false;
      switch (paramInt1)
      {
      case 2: 
      case 7: 
      default: 
        return;
      case 1: 
        paramqaq.a.a(2, 100);
        this.c = true;
      }
    } while (!this.jdField_b_of_type_Boolean);
    paramqaq.x.setVisibility(0);
    return;
    j();
    return;
    paramqaq.a.a(2, 100);
    this.c = true;
    if (this.jdField_b_of_type_Boolean) {
      paramqaq.x.setVisibility(0);
    }
    a(paramInt1);
    return;
    paramqaq.a.a(4, paramInt2);
    return;
    paramqaq.a.a(0, 0);
    bbmy.a(this.jdField_a_of_type_AndroidAppActivity, ajjy.a(2131650447), 0).a();
    return;
    c();
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
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return true;
      if (npj.a(this.jdField_a_of_type_Qbz)) {
        return false;
      }
    } while (!this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public boolean a(VideoInfo paramVideoInfo, qaq paramqaq, double paramDouble)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramqaq.u != null)
    {
      bool1 = bool2;
      if (paramqaq.u.getVisibility() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "进度判断 video_percent=" + paramDouble);
        }
        bool1 = bool2;
        if (paramDouble > this.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_Pxh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Pxh.jdField_b_of_type_Int;
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
          break label136;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) {
          break label75;
        }
        str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName;
      }
    }
    return str1;
    label75:
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc;
      }
      return ajjy.a(2131650362);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt;
    label136:
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_JavaLangString)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_JavaLangString;
      }
      return ajjy.a(2131650399);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  protected void b()
  {
    if ((b()) && (this.jdField_a_of_type_Pxh != null))
    {
      if ((this.jdField_a_of_type_Pxh.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Pxh.jdField_d_of_type_JavaLangString))) {
        npj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Pxh.jdField_d_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    rvb.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  public void b(qaq paramqaq)
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_Pxh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Pxh.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Pxh == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Pxh.jdField_a_of_type_Int == 4)
        {
          a(this.jdField_a_of_type_Qaq, 4, b());
          return;
        }
        if (this.jdField_a_of_type_Pxh.jdField_a_of_type_Int == 5)
        {
          String str = this.jdField_a_of_type_Pxh.jdField_d_of_type_JavaLangString;
          if (bady.a(BaseApplicationImpl.getContext(), str))
          {
            this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 1;
            a(this.jdField_a_of_type_Qaq, 1, b());
            return;
          }
          a(this.jdField_a_of_type_Qaq, 5, b());
          return;
        }
      } while (this.jdField_a_of_type_Pxh.jdField_a_of_type_Int != 3);
      a(this.jdField_a_of_type_Qaq, 3, b());
    } while ((this.jdField_a_of_type_Pxh == null) || (this.jdField_a_of_type_Nbl == null));
    this.jdField_a_of_type_Nbl.a(this.jdField_a_of_type_Pxh);
    return;
    int i = nbe.jdField_a_of_type_Int;
    if (nav.a(this.jdField_a_of_type_Pxh, c()))
    {
      f();
      this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 5;
      a(i, 3, 3);
      return;
    }
    e();
    a(i, 3, 0);
  }
  
  public void c(qaq paramqaq)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.c) {
      paramqaq.x.setVisibility(0);
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Nbl != null) && (this.jdField_a_of_type_Pxh != null)) {
      this.jdField_a_of_type_Nbl.b(this.jdField_a_of_type_Pxh);
    }
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Nbl != null) && (this.jdField_a_of_type_Pxh != null)) {
      this.jdField_a_of_type_Nbl.a(this.jdField_a_of_type_Pxh);
    }
    if ((this.jdField_a_of_type_Qaq.a != null) && (this.jdField_a_of_type_Pxh != null)) {
      j();
    }
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_Pxh != null) && (this.jdField_a_of_type_Nbl != null)) {
      this.jdField_a_of_type_Nbl.e(this.jdField_a_of_type_Pxh);
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_Pxh != null) && (this.jdField_a_of_type_Nbl != null)) {
      this.jdField_a_of_type_Nbl.a(this.jdField_a_of_type_Pxh, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 2;
    qaq localqaq = (qaq)paramView.getTag();
    int k = nbe.jdField_a_of_type_Int;
    this.jdField_a_of_type_Boolean = true;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301874: 
    case 2131313142: 
      i();
      if (paramView.getId() == 2131301874) {}
      for (i = 3;; i = 2)
      {
        a(k, i, -1, this.d);
        return;
      }
    }
    int j = 0;
    int m = localqaq.a.a();
    if (m == 2)
    {
      if (bady.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Pxh.jdField_d_of_type_JavaLangString))
      {
        b();
        this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 1;
        i = 5;
      }
      for (;;)
      {
        a(k, 3, i, this.d);
        return;
        if (naw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Pxh))
        {
          paramView = bccu.a().c(this.jdField_a_of_type_Pxh.jdField_d_of_type_JavaLangString);
          bccu.a().c(paramView);
          this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 5;
          i = 3;
        }
        else if (nav.a(this.jdField_a_of_type_Pxh, this.jdField_a_of_type_Pxh.jdField_a_of_type_Int))
        {
          f();
          this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 5;
          i = 3;
        }
        else if (badq.h(BaseApplicationImpl.getContext()))
        {
          e();
          i = j;
        }
        else
        {
          i();
          i = j;
        }
      }
    }
    if ((m == 0) || (m == 4)) {
      if (m != 4) {
        break label332;
      }
    }
    for (;;)
    {
      if (badq.h(BaseApplicationImpl.getContext()))
      {
        if (m == 0)
        {
          d();
          return;
        }
        e();
        break;
      }
      i();
      break;
      i = j;
      if (m != 1) {
        break;
      }
      g();
      i = 1;
      break;
      label332:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noa
 * JD-Core Version:    0.7.0.1
 */