package com.tencent.mobileqq.kandian.biz.fastweb.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdAppDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdData
  extends ProteusItemData
  implements Parcelable
{
  public static final Parcelable.Creator<AdData> CREATOR = new AdData.1();
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String L;
  public String M;
  public String N;
  public String O;
  public String P;
  public String Q;
  public String R;
  public String S;
  public String T;
  public String U;
  public String V;
  public String W;
  public String X;
  public String Y;
  public String Z;
  public double a;
  public AdvertisementInfo a;
  public AdAppDownloadInfo a;
  public AdGameComponentInfo a;
  public AdvertisementExtInfo a;
  public ArrayList<String> a;
  public JSONObject a;
  public String aa;
  public String ab;
  public String ac;
  public long b;
  public ArrayList<DislikeInfo> b;
  public JSONObject b;
  public int c;
  public long c;
  public ArrayList<String> c;
  public boolean c;
  public int d;
  public long d;
  public ArrayList<String> d;
  public boolean d;
  public int e;
  public long e;
  public boolean e;
  public int f;
  public long f;
  public int g;
  public int h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n;
  public int o;
  public String o;
  public int p;
  public String p;
  public int q;
  public String q;
  public int r;
  public String r;
  public int s;
  public String s = "1";
  public int t;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public AdData(int paramInt)
  {
    super(paramInt);
    this.jdField_q_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.h = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.L = HardCodeUtil.a(2131700045);
    this.jdField_l_of_type_Int = 0;
    this.U = null;
    this.Z = "0";
  }
  
  public AdData(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_q_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    boolean bool = false;
    this.h = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.L = HardCodeUtil.a(2131700045);
    this.jdField_l_of_type_Int = 0;
    this.U = null;
    this.Z = "0";
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.k = paramParcel.readString();
    this.jdField_l_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_m_of_type_JavaLangString = paramParcel.readString();
    this.jdField_n_of_type_JavaLangString = paramParcel.readString();
    this.jdField_o_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_p_of_type_JavaLangString = paramParcel.readString();
    this.jdField_q_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_r_of_type_JavaLangString = paramParcel.readString();
    this.s = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Double = paramParcel.readDouble();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, String.class.getClassLoader());
    this.t = paramParcel.readString();
    this.jdField_u_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readList(this.jdField_b_of_type_JavaUtilArrayList, DislikeInfo.class.getClassLoader());
    this.jdField_v_of_type_JavaLangString = paramParcel.readString();
    this.w = paramParcel.readString();
    this.x = paramParcel.readString();
    this.y = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.z = paramParcel.readString();
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    this.C = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.D = paramParcel.readString();
    this.E = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.F = paramParcel.readString();
    this.G = paramParcel.readString();
    this.H = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.h = paramParcel.readInt();
    this.I = paramParcel.readString();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_Long = paramParcel.readLong();
    this.jdField_i_of_type_Int = paramParcel.readInt();
    this.L = paramParcel.readString();
    this.M = paramParcel.readString();
    this.N = paramParcel.readString();
    this.O = paramParcel.readString();
    this.P = paramParcel.readString();
    this.jdField_m_of_type_Int = paramParcel.readInt();
    this.jdField_n_of_type_Int = paramParcel.readInt();
    this.U = paramParcel.readString();
    this.T = paramParcel.readString();
    this.W = paramParcel.readString();
    this.X = paramParcel.readString();
    this.Y = paramParcel.readString();
    this.aa = paramParcel.readString();
    this.ab = paramParcel.readString();
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    int i1 = paramBaseData.jdField_u_of_type_Int;
    if ((i1 != 17) && (i1 != 22)) {
      switch (i1)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.jdField_j_of_type_Int = paramJSONObject.optInt("appDownLoadStyle");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo = new AdAppDownloadInfo();
    if (paramJSONObject.has("appDownloadInfo"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("appDownloadInfo");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.a(paramJSONObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.b))
      {
        this.jdField_p_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.b;
        this.D = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.b;
        this.jdField_q_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.d;
        try
        {
          this.jdField_c_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.c);
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.e)) {
          this.E = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.e;
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.f = this.A;
      return;
    }
    paramJSONObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo;
    paramJSONObject.b = this.jdField_p_of_type_JavaLangString;
    paramJSONObject.f = this.A;
    paramJSONObject.e = this.E;
    paramJSONObject.c = String.valueOf(this.jdField_c_of_type_Long);
  }
  
  private void d(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("img_url");
    if (paramJSONObject.has("img_url"))
    {
      if (localJSONArray.length() < 0) {
        return;
      }
      int i1 = this.jdField_c_of_type_Int;
      if (i1 == 1)
      {
        this.jdField_l_of_type_JavaLangString = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(0), true);
        return;
      }
      if (i1 == 3)
      {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        int i2 = localJSONArray.length();
        i1 = 0;
        while (i1 < i2)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(i1), true));
          i1 += 1;
        }
        if (i2 < 3)
        {
          if (i2 == 2)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(0), true));
            return;
          }
          if (i2 == 1)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(0), true));
            this.jdField_a_of_type_JavaUtilArrayList.add(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(0), true));
          }
        }
      }
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("bytes_extra_data"))
      {
        localObject = paramJSONObject.opt("bytes_extra_data");
        if ((localObject instanceof JSONObject)) {
          this.U = localObject.toString();
        }
      }
      if (TextUtils.isEmpty(this.U)) {
        this.U = new JSONObject().toString();
      }
      Object localObject = new JSONObject(this.U);
      ((JSONObject)localObject).put("ad_switchs", this.jdField_v_of_type_JavaLangString);
      if (paramJSONObject.has("wechat_app_username")) {
        ((JSONObject)localObject).put("wechat_app_username", paramJSONObject.optString("wechat_app_username"));
      }
      if (paramJSONObject.has("wxappid")) {
        ((JSONObject)localObject).put("wxappid", paramJSONObject.optString("wxappid"));
      }
      if (paramJSONObject.has("wechat_app_path")) {
        ((JSONObject)localObject).put("wechat_app_path", paramJSONObject.optString("wechat_app_path"));
      }
      if (paramJSONObject.has("wechat_app_token")) {
        ((JSONObject)localObject).put("wechat_app_token", paramJSONObject.optString("wechat_app_token"));
      }
      if (paramJSONObject.has("wechat_ad_trace_data")) {
        ((JSONObject)localObject).put("wechat_ad_trace_data", paramJSONObject.optString("wechat_ad_trace_data"));
      }
      if (paramJSONObject.has("ad_source")) {
        this.jdField_q_of_type_Int = paramJSONObject.optInt("ad_source");
      }
      ((JSONObject)localObject).put("AdSource", this.jdField_q_of_type_Int);
      ((JSONObject)localObject).put("jump_type", this.Z);
      ((JSONObject)localObject).put("button_flag", paramJSONObject.optInt("button_flag", -1));
      this.U = ((JSONObject)localObject).toString();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdvertisementExtInfo = new AdvertisementExtInfo(this.U);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label291:
      break label291;
    }
    throw new JSONException("parseAdSwitchInfo JSONException.");
  }
  
  private void f(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("negative")) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("negative");
      ArrayList localArrayList = new ArrayList();
      if (paramJSONObject != null)
      {
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          DislikeInfo localDislikeInfo = new DislikeInfo();
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i1);
          localDislikeInfo.jdField_a_of_type_Long = localJSONObject.optInt("id");
          localDislikeInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("reason");
          localArrayList.add(localDislikeInfo);
          i1 += 1;
        }
        this.jdField_b_of_type_JavaUtilArrayList = localArrayList;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label104:
      break label104;
    }
    paramJSONObject = new JSONException("parseNegativeInfo JSONException.");
    for (;;)
    {
      throw paramJSONObject;
    }
  }
  
  private void g(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("pop_sheet")) {
      return;
    }
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.optString("pop_sheet")).optString("h5Url");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("h5Url = ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("fillCommonData", 2, localStringBuilder.toString());
      }
      this.K = paramJSONObject;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label77:
      break label77;
    }
    throw new JSONException("parsePopSheetInfo JSONException.");
  }
  
  private void h(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("button_flag")) {
      return;
    }
    paramJSONObject = paramJSONObject.optString("button_flag", "1");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buttonFlag = ");
      localStringBuilder.append(paramJSONObject);
      QLog.d("fillCommonData", 2, localStringBuilder.toString());
    }
    this.jdField_e_of_type_Boolean = (paramJSONObject.equals("0") ^ true);
  }
  
  private void i(JSONObject paramJSONObject)
  {
    this.jdField_i_of_type_Int = paramJSONObject.optInt("c2s_switch");
    boolean bool = paramJSONObject.has("c2s_click_url");
    int i2 = 0;
    JSONArray localJSONArray;
    int i3;
    ArrayList localArrayList;
    int i1;
    String str;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localJSONArray = paramJSONObject.optJSONArray("c2s_click_url");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i3 = localJSONArray.length();
        localArrayList = new ArrayList();
        i1 = 0;
        while (i1 < i3)
        {
          str = (String)localJSONArray.opt(i1);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" fillCommonData_C2S clickUrl = ");
            localStringBuilder.append(str);
            QLog.d("fillCommonData_C2S", 2, localStringBuilder.toString());
          }
          localArrayList.add(str);
          i1 += 1;
        }
        this.jdField_c_of_type_JavaUtilArrayList = localArrayList;
      }
    }
    if (paramJSONObject.has("c2s_exposure_url"))
    {
      localJSONArray = paramJSONObject.optJSONArray("c2s_exposure_url");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i3 = localJSONArray.length();
        localArrayList = new ArrayList();
        i1 = i2;
        while (i1 < i3)
        {
          str = (String)localJSONArray.opt(i1);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" fillCommonData_C2S exposureUrl = ");
            localStringBuilder.append(str);
            QLog.d("fillCommonData_C2S", 2, localStringBuilder.toString());
          }
          localArrayList.add(str);
          i1 += 1;
        }
        this.jdField_d_of_type_JavaUtilArrayList = localArrayList;
      }
    }
    this.jdField_n_of_type_Int = paramJSONObject.optInt("phone_component_id");
    this.jdField_r_of_type_Int = paramJSONObject.optInt("experimental_ad_style");
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(" corporateImageName= ");
      paramJSONObject.append(this.I);
      paramJSONObject.append(" traceID = ");
      paramJSONObject.append(this.jdField_u_of_type_JavaLangString);
      paramJSONObject.append(" c2s_switch ");
      paramJSONObject.append(this.jdField_i_of_type_Int);
      paramJSONObject.append(" experimental_ad_style ");
      paramJSONObject.append(this.jdField_r_of_type_Int);
      QLog.d("fillCommonData_C2S", 2, paramJSONObject.toString());
    }
  }
  
  public int a()
  {
    if ((this.jdField_v_of_type_Int == 2) && (!TextUtils.isEmpty(this.aa)))
    {
      if ("1".equals(this.aa)) {
        return 65;
      }
      if ("2".equals(this.aa)) {
        return 184;
      }
      if ("3".equals(this.aa)) {
        return 194;
      }
      return 65;
    }
    int i1 = this.jdField_u_of_type_Int;
    if (i1 != 17)
    {
      switch (i1)
      {
      default: 
        return 0;
      case 10: 
        return 65;
      }
      return 184;
    }
    return 185;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.D)) {
      return this.D;
    }
    if (!TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
      return this.jdField_p_of_type_JavaLangString;
    }
    if (h()) {}
    try
    {
      String str = this.jdField_b_of_type_OrgJsonJSONObject.optJSONObject("extendInfo").optString("game_pkg_name");
      return str;
    }
    catch (Throwable localThrowable)
    {
      label56:
      break label56;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramObject == null) {
        return;
      }
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramObject);
        return;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("e:");
          paramObject.append(paramString.toString());
          QLog.e("addArticleExt", 2, paramObject.toString());
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.jdField_v_of_type_JavaLangString = paramString;
    this.h = paramJSONObject.optInt("autoplay");
    this.w = paramJSONObject.optString("video");
    this.x = paramJSONObject.optString("effect_url");
    this.y = paramJSONObject.optString("landing_page_report_url");
    this.jdField_b_of_type_Long = paramJSONObject.optLong("cl");
    this.z = paramJSONObject.optString("productid");
    this.A = paramJSONObject.optString("mqq_via");
    this.B = paramJSONObject.optString("trl");
    this.C = paramJSONObject.optString("canvas_json");
    this.g = paramJSONObject.optInt("desttype");
    this.D = paramJSONObject.optString("pkg_name");
    this.E = paramJSONObject.optString("pkgurl");
    this.jdField_c_of_type_Long = paramJSONObject.optLong("appid");
    this.F = paramJSONObject.optString("pkg_download_schema");
    this.G = paramJSONObject.optString("invoke_url");
    this.H = paramJSONObject.optString("subordinate_product_id");
    this.jdField_d_of_type_Long = paramJSONObject.optLong("noco_id");
    this.I = paramJSONObject.optString("corporate_image_name");
    if (paramJSONObject.has("inner_ad")) {
      this.aa = paramJSONObject.optJSONObject("inner_ad").optString("style");
    }
    this.jdField_e_of_type_Long = paramJSONObject.optLong("algo_id");
    this.jdField_f_of_type_Long = paramJSONObject.optLong("algo_group");
    this.jdField_c_of_type_Boolean = paramJSONObject.has("native");
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_r_of_type_JavaLangString = paramJSONObject.optString("native");
    }
    this.jdField_i_of_type_JavaLangString = paramJSONObject.optString("posid");
    this.jdField_j_of_type_JavaLangString = paramJSONObject.optString("title");
    this.k = paramJSONObject.optString("content");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("img_type");
    d(paramJSONObject);
    this.jdField_m_of_type_JavaLangString = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(paramJSONObject.optString("click_url"), true);
    this.jdField_n_of_type_JavaLangString = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(paramJSONObject.optString("jump_url"), true);
    this.jdField_o_of_type_JavaLangString = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(paramJSONObject.optString("expose_url"), true);
    this.jdField_d_of_type_Int = paramJSONObject.optInt("producttype");
    this.jdField_p_of_type_JavaLangString = paramJSONObject.optString("pkg_name");
    this.jdField_q_of_type_JavaLangString = paramJSONObject.optString("app_name");
    this.s = paramJSONObject.optString("openudid");
    this.jdField_e_of_type_Int = paramJSONObject.optInt("ad_id");
    this.jdField_a_of_type_Double = paramJSONObject.optDouble("ecpm");
    this.jdField_f_of_type_Int = paramJSONObject.optInt("isContract");
    this.jdField_u_of_type_JavaLangString = paramJSONObject.optString("traceid");
    this.t = paramJSONObject.optString("viewid");
    this.jdField_e_of_type_Int = paramJSONObject.optInt("advertiser_id");
    this.J = paramJSONObject.optString("corporate_logo");
    this.L = paramJSONObject.optString("AdsIconText");
    this.O = paramJSONObject.optString("tags");
    this.M = paramJSONObject.optString("article_id");
    this.N = paramJSONObject.optString("rowkey");
    this.P = paramJSONObject.optString("cash_tag");
    boolean bool = false;
    this.jdField_p_of_type_Int = paramJSONObject.optInt("ad_jump_mode", 0);
    this.jdField_o_of_type_Int = paramJSONObject.optInt("show_inner_floating_bar");
    this.jdField_m_of_type_Int = paramJSONObject.optInt("mini_program_type");
    if (paramJSONObject.optInt("has_ams_popsheet") == 1) {
      bool = true;
    }
    this.jdField_d_of_type_Boolean = bool;
    this.Z = paramJSONObject.optString("jump_type");
    c(paramJSONObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo = new AdGameComponentInfo();
    paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo;
    paramString.a(paramJSONObject, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo);
    this.T = paramJSONObject.optString("ext", "");
    if (TextUtils.isEmpty(this.T)) {
      this.T = new JSONObject().toString();
    }
    this.R = paramJSONObject.optString("__ADSTR__");
    this.S = paramJSONObject.optString("adtag");
    try
    {
      e(paramJSONObject);
      f(paramJSONObject);
      g(paramJSONObject);
    }
    catch (JSONException paramString)
    {
      QLog.e("fillCommonData", 1, paramString.toString());
    }
    h(paramJSONObject);
    i(paramJSONObject);
    this.W = paramJSONObject.optString("liujin_report_url");
    this.X = paramJSONObject.optString("ticket");
    if (TextUtils.isEmpty(this.X)) {
      this.X = paramJSONObject.optString("ad_encrypted_ticket");
    }
    this.Y = paramJSONObject.optString("ams_nfb_url");
    this.ac = paramJSONObject.optString("original_exposure_url");
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean h()
  {
    JSONObject localJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
    return (localJSONObject != null) && (!TextUtils.isEmpty(localJSONObject.optString("sAdID")));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_n_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_p_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_q_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_c_of_type_Boolean);
    paramParcel.writeString(this.jdField_r_of_type_JavaLangString);
    paramParcel.writeString(this.s);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.t);
    paramParcel.writeString(this.jdField_u_of_type_JavaLangString);
    paramParcel.writeList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_v_of_type_JavaLangString);
    paramParcel.writeString(this.w);
    paramParcel.writeString(this.x);
    paramParcel.writeString(this.y);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.z);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
    paramParcel.writeString(this.C);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.D);
    paramParcel.writeString(this.E);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeString(this.F);
    paramParcel.writeString(this.G);
    paramParcel.writeString(this.H);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.I);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeLong(this.jdField_f_of_type_Long);
    paramParcel.writeInt(this.jdField_i_of_type_Int);
    paramParcel.writeString(this.L);
    paramParcel.writeString(this.M);
    paramParcel.writeString(this.N);
    paramParcel.writeString(this.O);
    paramParcel.writeString(this.P);
    paramParcel.writeInt(this.jdField_m_of_type_Int);
    paramParcel.writeInt(this.jdField_n_of_type_Int);
    paramParcel.writeString(this.U);
    paramParcel.writeString(this.T);
    paramParcel.writeString(this.W);
    paramParcel.writeString(this.X);
    paramParcel.writeString(this.Y);
    paramParcel.writeString(this.aa);
    paramParcel.writeString(this.ab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.data.AdData
 * JD-Core Version:    0.7.0.1
 */