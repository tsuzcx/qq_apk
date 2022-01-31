import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class nxz
{
  public int a;
  public String a;
  public nyb a;
  public String b = "";
  public String c;
  public String d;
  public String e;
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
  
  public nxz()
  {
    this.jdField_a_of_type_Nyb = new nyb();
  }
  
  public static nxz a(String paramString, nxz paramnxz)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramnxz == null) {
      paramnxz = new nxz();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramnxz.l = paramString.optString("button_desc", "");
        paramnxz.s = paramString.optString("word_content_no_wifi", "");
        paramnxz.t = paramString.optString("word_content_wifi", "");
        paramnxz.u = paramString.optString("word_highlight", "");
        paramnxz.v = paramString.optString("word_highlight_color", "");
        paramnxz.w = paramString.optString("word_title", "");
        paramnxz.m = paramString.optString("detail_url", "");
        paramnxz.n = paramString.optString("activity_url", "");
        paramnxz.k = paramString.optString("game_icon", "");
        paramnxz.x = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramnxz;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramnxz.jdField_a_of_type_Nyb = nyb.a(str);
        return paramnxz;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramnxz;
      }
    }
  }
  
  public static nxz a(String paramString, nxz paramnxz, nxy paramnxy)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramnxz == null) {
      paramnxz = new nxz();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramnxz.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramnxz.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramnxz.b = paramString.optString("package_name", "");
        paramnxz.c = paramString.optString("business_type", "");
        paramnxz.d = paramString.optString("plat_form", "");
        paramnxz.e = paramString.optString("appid", "");
        paramnxz.f = paramString.optString("oper_type", "");
        paramnxz.r = paramString.optString("game_stage", "");
        paramnxz.g = paramString.optString("game_status", "");
        paramnxz.h = paramString.optString("game_kind", "");
        paramnxz.i = paramString.optString("game_sub_kind", "");
        paramnxz.j = paramString.optString("play_nums", "");
        paramnxz.o = paramString.optString("game_tags", "");
        paramnxz.p = paramString.optString("game_download_url", "");
        paramnxz.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramnxz.b)) {
          paramnxy.b = paramnxz.b;
        }
        if (!TextUtils.isEmpty(paramnxz.p)) {
          paramnxy.e = paramnxz.p;
        }
        paramString = paramnxz;
        if (TextUtils.isEmpty(paramnxz.e)) {
          break;
        }
        paramnxy.c = paramnxz.e;
        return paramnxz;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramnxz;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, nxz paramnxz, nxy paramnxy)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramnxz, paramnxy);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramnxz);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramnxy.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramnxz.b)))
    {
      paramnxz.b = paramnxy.b;
      paramnxz.x = String.valueOf(paramnxy.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxz
 * JD-Core Version:    0.7.0.1
 */