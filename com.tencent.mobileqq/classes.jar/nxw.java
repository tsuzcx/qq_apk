import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class nxw
{
  public int a;
  public String a;
  public nxy a;
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
  
  public nxw()
  {
    this.jdField_a_of_type_Nxy = new nxy();
  }
  
  public static nxw a(String paramString, nxw paramnxw)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramnxw == null) {
      paramnxw = new nxw();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramnxw.l = paramString.optString("button_desc", "");
        paramnxw.s = paramString.optString("word_content_no_wifi", "");
        paramnxw.t = paramString.optString("word_content_wifi", "");
        paramnxw.u = paramString.optString("word_highlight", "");
        paramnxw.v = paramString.optString("word_highlight_color", "");
        paramnxw.w = paramString.optString("word_title", "");
        paramnxw.m = paramString.optString("detail_url", "");
        paramnxw.n = paramString.optString("activity_url", "");
        paramnxw.k = paramString.optString("game_icon", "");
        paramnxw.x = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramnxw;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramnxw.jdField_a_of_type_Nxy = nxy.a(str);
        return paramnxw;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramnxw;
      }
    }
  }
  
  public static nxw a(String paramString, nxw paramnxw, nxv paramnxv)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramnxw == null) {
      paramnxw = new nxw();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramnxw.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramnxw.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramnxw.b = paramString.optString("package_name", "");
        paramnxw.c = paramString.optString("business_type", "");
        paramnxw.d = paramString.optString("plat_form", "");
        paramnxw.e = paramString.optString("appid", "");
        paramnxw.f = paramString.optString("oper_type", "");
        paramnxw.r = paramString.optString("game_stage", "");
        paramnxw.g = paramString.optString("game_status", "");
        paramnxw.h = paramString.optString("game_kind", "");
        paramnxw.i = paramString.optString("game_sub_kind", "");
        paramnxw.j = paramString.optString("play_nums", "");
        paramnxw.o = paramString.optString("game_tags", "");
        paramnxw.p = paramString.optString("game_download_url", "");
        paramnxw.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramnxw.b)) {
          paramnxv.b = paramnxw.b;
        }
        if (!TextUtils.isEmpty(paramnxw.p)) {
          paramnxv.e = paramnxw.p;
        }
        paramString = paramnxw;
        if (TextUtils.isEmpty(paramnxw.e)) {
          break;
        }
        paramnxv.c = paramnxw.e;
        return paramnxw;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramnxw;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, nxw paramnxw, nxv paramnxv)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramnxw, paramnxv);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramnxw);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramnxv.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramnxw.b)))
    {
      paramnxw.b = paramnxv.b;
      paramnxw.x = String.valueOf(paramnxv.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxw
 * JD-Core Version:    0.7.0.1
 */