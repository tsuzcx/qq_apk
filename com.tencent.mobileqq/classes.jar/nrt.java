import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nrt
{
  public int a;
  public String a;
  public ArrayList<nru> a;
  
  public nrt()
  {
    this.jdField_a_of_type_JavaLangString = "#FFFFFF";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static nrt a(String paramString)
  {
    nrt localnrt = new nrt();
    if (!bbjw.a(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      localnrt.jdField_a_of_type_Int = paramString.optInt("tab_switch");
      localnrt.jdField_a_of_type_JavaLangString = paramString.optString("tab_background", "#FFFFFF");
      paramString = paramString.optJSONArray("tabs");
      if ((paramString != null) && (paramString.length() > 0))
      {
        ArrayList localArrayList = new ArrayList(paramString.length());
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.optJSONObject(i);
          nru localnru = new nru();
          localnru.jdField_a_of_type_Int = localJSONObject.optInt("tabid");
          localnru.c = localJSONObject.optString("icon_normal");
          localnru.d = localJSONObject.optString("icon_selected");
          localnru.e = localJSONObject.optString("textcolor_normal");
          localnru.f = localJSONObject.optString("textcolor_selected");
          localnru.b = localJSONObject.optString("jump_url");
          localnru.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localArrayList.add(localnru);
          i += 1;
        }
        localnrt.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      return localnrt;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localnrt;
  }
  
  public nru a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      nru localnru = (nru)localIterator.next();
      if (localnru.jdField_a_of_type_Int == paramInt) {
        return localnru;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrt
 * JD-Core Version:    0.7.0.1
 */