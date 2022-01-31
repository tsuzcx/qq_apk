import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class obd
{
  public int a;
  public String a;
  public obf a;
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
  
  public obd()
  {
    this.jdField_a_of_type_Obf = new obf();
  }
  
  public static obd a(String paramString, obd paramobd)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramobd == null) {
      paramobd = new obd();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramobd.l = paramString.optString("button_desc", "");
        paramobd.s = paramString.optString("word_content_no_wifi", "");
        paramobd.t = paramString.optString("word_content_wifi", "");
        paramobd.u = paramString.optString("word_highlight", "");
        paramobd.v = paramString.optString("word_highlight_color", "");
        paramobd.w = paramString.optString("word_title", "");
        paramobd.m = paramString.optString("detail_url", "");
        paramobd.n = paramString.optString("activity_url", "");
        paramobd.k = paramString.optString("game_icon", "");
        paramobd.x = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramobd;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramobd.jdField_a_of_type_Obf = obf.a(str);
        return paramobd;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramobd;
      }
    }
  }
  
  public static obd a(String paramString, obd paramobd, obc paramobc)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramobd == null) {
      paramobd = new obd();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramobd.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramobd.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramobd.b = paramString.optString("package_name", "");
        paramobd.c = paramString.optString("business_type", "");
        paramobd.d = paramString.optString("plat_form", "");
        paramobd.e = paramString.optString("appid", "");
        paramobd.f = paramString.optString("oper_type", "");
        paramobd.r = paramString.optString("game_stage", "");
        paramobd.g = paramString.optString("game_status", "");
        paramobd.h = paramString.optString("game_kind", "");
        paramobd.i = paramString.optString("game_sub_kind", "");
        paramobd.j = paramString.optString("play_nums", "");
        paramobd.o = paramString.optString("game_tags", "");
        paramobd.p = paramString.optString("game_download_url", "");
        paramobd.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramobd.b)) {
          paramobc.b = paramobd.b;
        }
        if (!TextUtils.isEmpty(paramobd.p)) {
          paramobc.e = paramobd.p;
        }
        paramString = paramobd;
        if (TextUtils.isEmpty(paramobd.e)) {
          break;
        }
        paramobc.c = paramobd.e;
        return paramobd;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramobd;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, obd paramobd, obc paramobc)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramobd, paramobc);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramobd);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramobc.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramobd.b)))
    {
      paramobd.b = paramobc.b;
      paramobd.x = String.valueOf(paramobc.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obd
 * JD-Core Version:    0.7.0.1
 */