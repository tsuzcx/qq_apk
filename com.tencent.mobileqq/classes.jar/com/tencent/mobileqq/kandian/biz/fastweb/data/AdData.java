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
  public int A;
  public ArrayList<String> B = null;
  public String C;
  public String D;
  public ArrayList<DislikeInfo> E = null;
  public String F;
  public String G;
  public String H;
  public String I;
  public long J;
  public String K;
  public String L;
  public String M;
  public String N;
  public int O;
  public String P;
  public String Q;
  public long R;
  public String S;
  public String T;
  public String U;
  public long V;
  public int W;
  public String X;
  public long Y;
  public long Z;
  public int aA;
  public int aB;
  public JSONObject aC;
  public int aD;
  public JSONObject aE;
  public int aF;
  public int aG;
  public String aH;
  public String aI;
  public String aJ;
  public String aK;
  public String aL;
  public String aM;
  public String aN;
  public String aO;
  public String aa;
  public boolean ab;
  public String ac;
  public boolean ad;
  public int ae;
  public ArrayList<String> af;
  public ArrayList<String> ag;
  public String ah;
  public String ai;
  public String aj;
  public String ak;
  public String al;
  public int am;
  public AdAppDownloadInfo an;
  public int ao;
  public int ap;
  public String aq;
  public int ar;
  public AdGameComponentInfo as;
  public String at;
  public String au;
  public int av;
  public String aw;
  public int ax;
  public String ay;
  public AdvertisementExtInfo az;
  public AdvertisementInfo j;
  public String k;
  public String l;
  public String m;
  public String n;
  public int o;
  public String p;
  public String q;
  public String r;
  public int s;
  public String t;
  public String u = "";
  public boolean v;
  public String w;
  public String x = "1";
  public int y;
  public double z;
  
  public AdData(int paramInt)
  {
    super(paramInt);
    this.W = 0;
    this.ab = false;
    this.ad = true;
    this.ah = HardCodeUtil.a(2131898091);
    this.ap = 0;
    this.ay = null;
    this.aL = "0";
  }
  
  public AdData(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool = false;
    this.W = 0;
    this.ab = false;
    this.ad = true;
    this.ah = HardCodeUtil.a(2131898091);
    this.ap = 0;
    this.ay = null;
    this.aL = "0";
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readString();
    this.u = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.v = bool;
    this.w = paramParcel.readString();
    this.x = paramParcel.readString();
    this.y = paramParcel.readInt();
    this.z = paramParcel.readDouble();
    this.A = paramParcel.readInt();
    this.B = new ArrayList();
    paramParcel.readList(this.B, String.class.getClassLoader());
    this.C = paramParcel.readString();
    this.D = paramParcel.readString();
    this.E = new ArrayList();
    paramParcel.readList(this.E, DislikeInfo.class.getClassLoader());
    this.F = paramParcel.readString();
    this.G = paramParcel.readString();
    this.H = paramParcel.readString();
    this.I = paramParcel.readString();
    this.J = paramParcel.readLong();
    this.K = paramParcel.readString();
    this.L = paramParcel.readString();
    this.M = paramParcel.readString();
    this.N = paramParcel.readString();
    this.O = paramParcel.readInt();
    this.P = paramParcel.readString();
    this.Q = paramParcel.readString();
    this.R = paramParcel.readLong();
    this.S = paramParcel.readString();
    this.T = paramParcel.readString();
    this.U = paramParcel.readString();
    this.V = paramParcel.readLong();
    this.W = paramParcel.readInt();
    this.X = paramParcel.readString();
    this.Y = paramParcel.readLong();
    this.Z = paramParcel.readLong();
    this.ae = paramParcel.readInt();
    this.ah = paramParcel.readString();
    this.ai = paramParcel.readString();
    this.aj = paramParcel.readString();
    this.ak = paramParcel.readString();
    this.al = paramParcel.readString();
    this.ar = paramParcel.readInt();
    this.av = paramParcel.readInt();
    this.ay = paramParcel.readString();
    this.aw = paramParcel.readString();
    this.aI = paramParcel.readString();
    this.aJ = paramParcel.readString();
    this.aK = paramParcel.readString();
    this.aM = paramParcel.readString();
    this.aN = paramParcel.readString();
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    int i = paramBaseData.aP;
    if ((i != 17) && (i != 22)) {
      switch (i)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.am = paramJSONObject.optInt("appDownLoadStyle");
    this.an = new AdAppDownloadInfo();
    if (paramJSONObject.has("appDownloadInfo"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("appDownloadInfo");
      this.an.a(paramJSONObject);
      if (!TextUtils.isEmpty(this.an.b))
      {
        this.t = this.an.b;
        this.P = this.an.b;
        this.u = this.an.d;
        try
        {
          this.R = Long.parseLong(this.an.c);
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.an.e)) {
          this.Q = this.an.e;
        }
      }
      this.an.f = this.L;
      return;
    }
    paramJSONObject = this.an;
    paramJSONObject.b = this.t;
    paramJSONObject.f = this.L;
    paramJSONObject.e = this.Q;
    paramJSONObject.c = String.valueOf(this.R);
  }
  
  private void d(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("img_url");
    if (paramJSONObject.has("img_url"))
    {
      if (localJSONArray.length() < 0) {
        return;
      }
      int i = this.o;
      if (i == 1)
      {
        this.n = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(0), true);
        return;
      }
      if (i == 3)
      {
        this.B = new ArrayList();
        int i1 = localJSONArray.length();
        i = 0;
        while (i < i1)
        {
          this.B.add(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(i), true));
          i += 1;
        }
        if (i1 < 3)
        {
          if (i1 == 2)
          {
            this.B.add(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(0), true));
            return;
          }
          if (i1 == 1)
          {
            this.B.add(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(0), true));
            this.B.add(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(localJSONArray.optString(0), true));
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
          this.ay = localObject.toString();
        }
      }
      if (TextUtils.isEmpty(this.ay)) {
        this.ay = new JSONObject().toString();
      }
      Object localObject = new JSONObject(this.ay);
      ((JSONObject)localObject).put("ad_switchs", this.F);
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
        this.aB = paramJSONObject.optInt("ad_source");
      }
      ((JSONObject)localObject).put("AdSource", this.aB);
      ((JSONObject)localObject).put("jump_type", this.aL);
      ((JSONObject)localObject).put("button_flag", paramJSONObject.optInt("button_flag", -1));
      this.ay = ((JSONObject)localObject).toString();
      this.az = new AdvertisementExtInfo(this.ay);
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
        int i = 0;
        while (i < paramJSONObject.length())
        {
          DislikeInfo localDislikeInfo = new DislikeInfo();
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          localDislikeInfo.e = localJSONObject.optInt("id");
          localDislikeInfo.c = localJSONObject.optString("reason");
          localArrayList.add(localDislikeInfo);
          i += 1;
        }
        this.E = localArrayList;
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
      this.ac = paramJSONObject;
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
    this.ad = (paramJSONObject.equals("0") ^ true);
  }
  
  private void i(JSONObject paramJSONObject)
  {
    this.ae = paramJSONObject.optInt("c2s_switch");
    boolean bool = paramJSONObject.has("c2s_click_url");
    int i1 = 0;
    JSONArray localJSONArray;
    int i2;
    ArrayList localArrayList;
    int i;
    String str;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localJSONArray = paramJSONObject.optJSONArray("c2s_click_url");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i2 = localJSONArray.length();
        localArrayList = new ArrayList();
        i = 0;
        while (i < i2)
        {
          str = (String)localJSONArray.opt(i);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" fillCommonData_C2S clickUrl = ");
            localStringBuilder.append(str);
            QLog.d("fillCommonData_C2S", 2, localStringBuilder.toString());
          }
          localArrayList.add(str);
          i += 1;
        }
        this.af = localArrayList;
      }
    }
    if (paramJSONObject.has("c2s_exposure_url"))
    {
      localJSONArray = paramJSONObject.optJSONArray("c2s_exposure_url");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i2 = localJSONArray.length();
        localArrayList = new ArrayList();
        i = i1;
        while (i < i2)
        {
          str = (String)localJSONArray.opt(i);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" fillCommonData_C2S exposureUrl = ");
            localStringBuilder.append(str);
            QLog.d("fillCommonData_C2S", 2, localStringBuilder.toString());
          }
          localArrayList.add(str);
          i += 1;
        }
        this.ag = localArrayList;
      }
    }
    this.av = paramJSONObject.optInt("phone_component_id");
    this.aD = paramJSONObject.optInt("experimental_ad_style");
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(" corporateImageName= ");
      paramJSONObject.append(this.X);
      paramJSONObject.append(" traceID = ");
      paramJSONObject.append(this.D);
      paramJSONObject.append(" c2s_switch ");
      paramJSONObject.append(this.ae);
      paramJSONObject.append(" experimental_ad_style ");
      paramJSONObject.append(this.aD);
      QLog.d("fillCommonData_C2S", 2, paramJSONObject.toString());
    }
  }
  
  public void a() {}
  
  public void a(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramObject == null) {
        return;
      }
      if (this.aC == null) {
        this.aC = new JSONObject();
      }
      try
      {
        this.aC.put(paramString, paramObject);
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
    this.F = paramString;
    this.W = paramJSONObject.optInt("autoplay");
    this.G = paramJSONObject.optString("video");
    this.H = paramJSONObject.optString("effect_url");
    this.I = paramJSONObject.optString("landing_page_report_url");
    this.J = paramJSONObject.optLong("cl");
    this.K = paramJSONObject.optString("productid");
    this.L = paramJSONObject.optString("mqq_via");
    this.M = paramJSONObject.optString("trl");
    this.N = paramJSONObject.optString("canvas_json");
    this.O = paramJSONObject.optInt("desttype");
    this.P = paramJSONObject.optString("pkg_name");
    this.Q = paramJSONObject.optString("pkgurl");
    this.R = paramJSONObject.optLong("appid");
    this.S = paramJSONObject.optString("pkg_download_schema");
    this.T = paramJSONObject.optString("invoke_url");
    this.U = paramJSONObject.optString("subordinate_product_id");
    this.V = paramJSONObject.optLong("noco_id");
    this.X = paramJSONObject.optString("corporate_image_name");
    if (paramJSONObject.has("inner_ad")) {
      this.aM = paramJSONObject.optJSONObject("inner_ad").optString("style");
    }
    this.Y = paramJSONObject.optLong("algo_id");
    this.Z = paramJSONObject.optLong("algo_group");
    this.v = paramJSONObject.has("native");
    if (this.v) {
      this.w = paramJSONObject.optString("native");
    }
    this.k = paramJSONObject.optString("posid");
    this.l = paramJSONObject.optString("title");
    this.m = paramJSONObject.optString("content");
    this.o = paramJSONObject.optInt("img_type");
    d(paramJSONObject);
    this.p = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(paramJSONObject.optString("click_url"), true);
    this.q = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(paramJSONObject.optString("jump_url"), true);
    this.r = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addHeadForUrl(paramJSONObject.optString("expose_url"), true);
    this.s = paramJSONObject.optInt("producttype");
    this.t = paramJSONObject.optString("pkg_name");
    this.u = paramJSONObject.optString("app_name");
    this.x = paramJSONObject.optString("openudid");
    this.y = paramJSONObject.optInt("ad_id");
    this.z = paramJSONObject.optDouble("ecpm");
    this.A = paramJSONObject.optInt("isContract");
    this.D = paramJSONObject.optString("traceid");
    this.C = paramJSONObject.optString("viewid");
    this.y = paramJSONObject.optInt("advertiser_id");
    this.aa = paramJSONObject.optString("corporate_logo");
    this.ah = paramJSONObject.optString("AdsIconText");
    this.ak = paramJSONObject.optString("tags");
    this.ai = paramJSONObject.optString("article_id");
    this.aj = paramJSONObject.optString("rowkey");
    this.al = paramJSONObject.optString("cash_tag");
    boolean bool = false;
    this.aA = paramJSONObject.optInt("ad_jump_mode", 0);
    this.ax = paramJSONObject.optInt("show_inner_floating_bar");
    this.ar = paramJSONObject.optInt("mini_program_type");
    if (paramJSONObject.optInt("has_ams_popsheet") == 1) {
      bool = true;
    }
    this.ab = bool;
    this.aL = paramJSONObject.optString("jump_type");
    c(paramJSONObject);
    this.as = new AdGameComponentInfo();
    paramString = this.as;
    paramString.a(paramJSONObject, paramString, this.an);
    this.aw = paramJSONObject.optString("ext", "");
    if (TextUtils.isEmpty(this.aw)) {
      this.aw = new JSONObject().toString();
    }
    this.at = paramJSONObject.optString("__ADSTR__");
    this.au = paramJSONObject.optString("adtag");
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
    this.aI = paramJSONObject.optString("liujin_report_url");
    this.aJ = paramJSONObject.optString("ticket");
    if (TextUtils.isEmpty(this.aJ)) {
      this.aJ = paramJSONObject.optString("ad_encrypted_ticket");
    }
    this.aK = paramJSONObject.optString("ams_nfb_url");
    this.aO = paramJSONObject.optString("original_exposure_url");
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean j()
  {
    JSONObject localJSONObject = this.aE;
    return (localJSONObject != null) && (!TextUtils.isEmpty(localJSONObject.optString("sAdID")));
  }
  
  public String k()
  {
    if (!TextUtils.isEmpty(this.P)) {
      return this.P;
    }
    if (!TextUtils.isEmpty(this.t)) {
      return this.t;
    }
    if (j()) {}
    try
    {
      String str = this.aE.optJSONObject("extendInfo").optString("game_pkg_name");
      return str;
    }
    catch (Throwable localThrowable)
    {
      label56:
      break label56;
    }
    return null;
  }
  
  public int l()
  {
    if ((this.aT == 2) && (!TextUtils.isEmpty(this.aM)))
    {
      if ("1".equals(this.aM)) {
        return 65;
      }
      if ("2".equals(this.aM)) {
        return 184;
      }
      if ("3".equals(this.aM)) {
        return 194;
      }
      return 65;
    }
    int i = this.aP;
    if (i != 17)
    {
      switch (i)
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeByte((byte)this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeString(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeDouble(this.z);
    paramParcel.writeInt(this.A);
    paramParcel.writeList(this.B);
    paramParcel.writeString(this.C);
    paramParcel.writeString(this.D);
    paramParcel.writeList(this.E);
    paramParcel.writeString(this.F);
    paramParcel.writeString(this.G);
    paramParcel.writeString(this.H);
    paramParcel.writeString(this.I);
    paramParcel.writeLong(this.J);
    paramParcel.writeString(this.K);
    paramParcel.writeString(this.L);
    paramParcel.writeString(this.M);
    paramParcel.writeString(this.N);
    paramParcel.writeInt(this.O);
    paramParcel.writeString(this.P);
    paramParcel.writeString(this.Q);
    paramParcel.writeLong(this.R);
    paramParcel.writeString(this.S);
    paramParcel.writeString(this.T);
    paramParcel.writeString(this.U);
    paramParcel.writeLong(this.V);
    paramParcel.writeInt(this.W);
    paramParcel.writeString(this.X);
    paramParcel.writeLong(this.Y);
    paramParcel.writeLong(this.Z);
    paramParcel.writeInt(this.ae);
    paramParcel.writeString(this.ah);
    paramParcel.writeString(this.ai);
    paramParcel.writeString(this.aj);
    paramParcel.writeString(this.ak);
    paramParcel.writeString(this.al);
    paramParcel.writeInt(this.ar);
    paramParcel.writeInt(this.av);
    paramParcel.writeString(this.ay);
    paramParcel.writeString(this.aw);
    paramParcel.writeString(this.aI);
    paramParcel.writeString(this.aJ);
    paramParcel.writeString(this.aK);
    paramParcel.writeString(this.aM);
    paramParcel.writeString(this.aN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.data.AdData
 * JD-Core Version:    0.7.0.1
 */