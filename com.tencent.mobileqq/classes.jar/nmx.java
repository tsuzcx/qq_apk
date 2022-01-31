import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class nmx
{
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
  
  public nmx(String paramString)
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
        this.jdField_a_of_type_JavaLangString = paramString.optString("sAdID");
        this.jdField_b_of_type_JavaLangString = paramString.optString("adImg");
        this.jdField_d_of_type_JavaLangString = paramString.optString("adTxt");
        this.jdField_c_of_type_JavaLangString = paramString.optString("adAbb");
        this.jdField_e_of_type_JavaLangString = paramString.optString("buttonTxt");
        this.jdField_f_of_type_JavaLangString = paramString.optString("jmpUrl");
        this.g = paramString.optString("appScheme");
        this.h = paramString.optString("miniProgramUrl");
        this.jdField_a_of_type_Int = paramString.optInt("contentType");
        this.jdField_b_of_type_Int = paramString.optInt("video_percent");
        this.jdField_c_of_type_Int = paramString.optInt("sourceId");
        this.jdField_d_of_type_Int = paramString.optInt("bizPlatId");
        this.jdField_e_of_type_Int = paramString.optInt("goodsType");
        this.i = paramString.optString("goodsId");
        this.j = paramString.optString("goodsName");
        this.jdField_f_of_type_Int = paramString.optInt("accountId");
        this.k = paramString.optString("goodsPrice");
        this.l = paramString.optString("goodsPromotionPrice");
        this.m = paramString.optString("goodsPromotionTxt");
        paramString = new JSONObject(paramString.optString("extendInfo"));
        this.n = paramString.optString("game_pkg_name");
        this.o = paramString.optString("game_app_id");
        this.p = paramString.optString("game_app_name");
        this.q = paramString.optString("game_apk_url");
        this.r = paramString.optString("app_download_schema");
        this.s = paramString.optString("download_api_url");
        this.t = paramString.optString("downloadNum");
        this.u = paramString.optString("game_adtag");
        this.v = paramString.optString("__ADSTR__");
        this.w = paramString.optString("cmsid");
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
        }
      }
    }
    QLog.d("AdvertisementSoftInfo", 2, "softData = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmx
 * JD-Core Version:    0.7.0.1
 */