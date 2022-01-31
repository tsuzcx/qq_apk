import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nva
{
  public int a;
  public String a;
  public ArrayList<nvb> a;
  public int b;
  
  public nva()
  {
    this.jdField_a_of_type_JavaLangString = "#FFFFFF";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static nva a(String paramString)
  {
    int i = 0;
    nva localnva = new nva();
    if (!bdje.a(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localnva.jdField_a_of_type_Int = paramString.optInt("tab_switch");
        localnva.jdField_a_of_type_JavaLangString = paramString.optString("tab_background", "#FFFFFF");
        localnva.jdField_b_of_type_Int = paramString.optInt("is_preload");
        paramString = paramString.optJSONArray("tabs");
        if ((paramString != null) && (paramString.length() > 0))
        {
          ArrayList localArrayList = new ArrayList(paramString.length());
          if (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.optJSONObject(i);
            nvb localnvb = new nvb();
            localnvb.jdField_a_of_type_Int = localJSONObject.optInt("tabid");
            localnvb.c = localJSONObject.optString("icon_normal");
            localnvb.d = localJSONObject.optString("icon_selected");
            localnvb.e = localJSONObject.optString("textcolor_normal", "#CCCCCC");
            localnvb.f = localJSONObject.optString("textcolor_selected", "#000000");
            localnvb.jdField_b_of_type_JavaLangString = localJSONObject.optString("jump_url");
            localnvb.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
            localnvb.jdField_b_of_type_Int = localJSONObject.optInt("page_type", 0);
            localnvb.g = localJSONObject.optString("min_app_version", "8.3.3");
            if (!localArrayList.contains(localnvb)) {
              localArrayList.add(localnvb);
            }
          }
          else
          {
            localnva.jdField_a_of_type_JavaUtilArrayList = localArrayList;
          }
        }
        else
        {
          return localnva;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localnva;
      }
      i += 1;
    }
  }
  
  public nvb a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      nvb localnvb = (nvb)localIterator.next();
      if (localnvb.jdField_a_of_type_Int == paramInt) {
        return localnvb;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nva
 * JD-Core Version:    0.7.0.1
 */