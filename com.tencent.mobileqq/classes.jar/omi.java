import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class omi
{
  public int a;
  public String a;
  public omk a;
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
  
  public omi()
  {
    this.jdField_a_of_type_Omk = new omk();
  }
  
  public static omi a(String paramString, omi paramomi)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramomi == null) {
      paramomi = new omi();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramomi.l = paramString.optString("button_desc", "");
        paramomi.s = paramString.optString("word_content_no_wifi", "");
        paramomi.t = paramString.optString("word_content_wifi", "");
        paramomi.u = paramString.optString("word_highlight", "");
        paramomi.v = paramString.optString("word_highlight_color", "");
        paramomi.w = paramString.optString("word_title", "");
        paramomi.m = paramString.optString("detail_url", "");
        paramomi.n = paramString.optString("activity_url", "");
        paramomi.k = paramString.optString("game_icon", "");
        paramomi.x = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramomi;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramomi.jdField_a_of_type_Omk = omk.a(str);
        return paramomi;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramomi;
      }
    }
  }
  
  public static omi a(String paramString, omi paramomi, omh paramomh)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramomi == null) {
      paramomi = new omi();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramomi.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramomi.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramomi.b = paramString.optString("package_name", "");
        paramomi.c = paramString.optString("business_type", "");
        paramomi.d = paramString.optString("plat_form", "");
        paramomi.e = paramString.optString("appid", "");
        paramomi.f = paramString.optString("oper_type", "");
        paramomi.r = paramString.optString("game_stage", "");
        paramomi.g = paramString.optString("game_status", "");
        paramomi.h = paramString.optString("game_kind", "");
        paramomi.i = paramString.optString("game_sub_kind", "");
        paramomi.j = paramString.optString("play_nums", "");
        paramomi.o = paramString.optString("game_tags", "");
        paramomi.p = paramString.optString("game_download_url", "");
        paramomi.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramomi.b)) {
          paramomh.b = paramomi.b;
        }
        if (!TextUtils.isEmpty(paramomi.p)) {
          paramomh.e = paramomi.p;
        }
        paramString = paramomi;
        if (TextUtils.isEmpty(paramomi.e)) {
          break;
        }
        paramomh.c = paramomi.e;
        return paramomi;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramomi;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, omi paramomi, omh paramomh)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramomi, paramomh);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramomi);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramomh.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramomi.b)))
    {
      paramomi.b = paramomh.b;
      paramomi.x = String.valueOf(paramomh.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omi
 * JD-Core Version:    0.7.0.1
 */