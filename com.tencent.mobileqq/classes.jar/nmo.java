import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class nmo
{
  public int a;
  public String a;
  public nmq a;
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
  
  public nmo()
  {
    this.jdField_a_of_type_Nmq = new nmq();
  }
  
  public static nmo a(String paramString, nmo paramnmo)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramnmo == null) {
      paramnmo = new nmo();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramnmo.l = paramString.optString("button_desc", "");
        paramnmo.s = paramString.optString("word_content_no_wifi", "");
        paramnmo.t = paramString.optString("word_content_wifi", "");
        paramnmo.u = paramString.optString("word_highlight", "");
        paramnmo.v = paramString.optString("word_highlight_color", "");
        paramnmo.w = paramString.optString("word_title", "");
        paramnmo.m = paramString.optString("detail_url", "");
        paramnmo.n = paramString.optString("activity_url", "");
        paramnmo.k = paramString.optString("game_icon", "");
        paramnmo.x = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramnmo;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramnmo.jdField_a_of_type_Nmq = nmq.a(str);
        return paramnmo;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramnmo;
      }
    }
  }
  
  public static nmo a(String paramString, nmo paramnmo, nmn paramnmn)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramnmo == null) {
      paramnmo = new nmo();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramnmo.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramnmo.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramnmo.b = paramString.optString("package_name", "");
        paramnmo.c = paramString.optString("business_type", "");
        paramnmo.d = paramString.optString("plat_form", "");
        paramnmo.e = paramString.optString("appid", "");
        paramnmo.f = paramString.optString("oper_type", "");
        paramnmo.r = paramString.optString("game_stage", "");
        paramnmo.g = paramString.optString("game_status", "");
        paramnmo.h = paramString.optString("game_kind", "");
        paramnmo.i = paramString.optString("game_sub_kind", "");
        paramnmo.j = paramString.optString("play_nums", "");
        paramnmo.o = paramString.optString("game_tags", "");
        paramnmo.p = paramString.optString("game_download_url", "");
        paramnmo.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramnmo.b)) {
          paramnmn.b = paramnmo.b;
        }
        if (!TextUtils.isEmpty(paramnmo.p)) {
          paramnmn.e = paramnmo.p;
        }
        paramString = paramnmo;
        if (TextUtils.isEmpty(paramnmo.e)) {
          break;
        }
        paramnmn.c = paramnmo.e;
        return paramnmo;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramnmo;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, nmo paramnmo, nmn paramnmn)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramnmo, paramnmn);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramnmo);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramnmn.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramnmo.b)))
    {
      paramnmo.b = paramnmn.b;
      paramnmo.x = String.valueOf(paramnmn.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmo
 * JD-Core Version:    0.7.0.1
 */