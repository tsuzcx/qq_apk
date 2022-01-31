import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class obm
{
  public String A;
  public String B;
  public String C;
  public String D;
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public obm(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementSoftInfo", 2, "softData = " + paramString);
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramString = new JSONObject(new JSONObject(paramString).optString("SoftAd"));
        a(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo = " + toString());
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo Exception = " + paramString.getMessage());
          }
          paramString = null;
        }
      }
    }
    QLog.d("AdvertisementSoftInfo", 2, "softData = null");
  }
  
  public obm(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sAdID");
        this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("adImg");
        this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("adTxt");
        this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("adAbb");
        this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("buttonTxt");
        this.jdField_f_of_type_JavaLangString = paramJSONObject.optString("jmpUrl");
        this.g = paramJSONObject.optString("appScheme");
        this.h = paramJSONObject.optString("miniProgramUrl");
        this.jdField_a_of_type_Int = paramJSONObject.optInt("contentType");
        this.jdField_b_of_type_Int = paramJSONObject.optInt("video_percent");
        this.jdField_c_of_type_Int = paramJSONObject.optInt("sourceId");
        this.jdField_d_of_type_Int = paramJSONObject.optInt("bizPlatId");
        this.jdField_e_of_type_Int = paramJSONObject.optInt("goodsType");
        this.i = paramJSONObject.optString("goodsId");
        this.j = paramJSONObject.optString("goodsName");
        this.jdField_f_of_type_Int = paramJSONObject.optInt("accountId");
        this.k = paramJSONObject.optString("goodsPrice");
        this.l = paramJSONObject.optString("goodsPromotionPrice");
        this.m = paramJSONObject.optString("goodsPromotionTxt");
        this.C = paramJSONObject.optString("button");
        paramJSONObject = new JSONObject(paramJSONObject.optString("extendInfo"));
        this.n = paramJSONObject.optString("game_pkg_name");
        this.o = paramJSONObject.optString("game_app_id");
        this.p = paramJSONObject.optString("game_app_name");
        this.q = paramJSONObject.optString("game_apk_url");
        this.r = paramJSONObject.optString("app_download_schema");
        this.s = paramJSONObject.optString("download_api_url");
        this.t = paramJSONObject.optString("downloadNum");
        this.u = paramJSONObject.optString("game_adtag");
        this.v = paramJSONObject.optString("__ADSTR__");
        this.w = paramJSONObject.optString("cmsid");
        this.x = paramJSONObject.optString("soft_video_style");
        this.z = paramJSONObject.optString("big_card_show_percent");
        this.A = paramJSONObject.optString("big_card_show_second");
        this.y = paramJSONObject.optString("big_card_show_type");
        this.B = paramJSONObject.optString("small_card_start_time");
        this.D = paramJSONObject.optString("bizPlatName");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo = " + toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo Exception = " + paramJSONObject.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obm
 * JD-Core Version:    0.7.0.1
 */