import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nrq
{
  public int a;
  public String a;
  public ArrayList<nrr> a;
  
  public nrq()
  {
    this.jdField_a_of_type_JavaLangString = "#FFFFFF";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static nrq a(String paramString)
  {
    nrq localnrq = new nrq();
    if (!bbkk.a(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      localnrq.jdField_a_of_type_Int = paramString.optInt("tab_switch");
      localnrq.jdField_a_of_type_JavaLangString = paramString.optString("tab_background", "#FFFFFF");
      paramString = paramString.optJSONArray("tabs");
      if ((paramString != null) && (paramString.length() > 0))
      {
        ArrayList localArrayList = new ArrayList(paramString.length());
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.optJSONObject(i);
          nrr localnrr = new nrr();
          localnrr.jdField_a_of_type_Int = localJSONObject.optInt("tabid");
          localnrr.c = localJSONObject.optString("icon_normal");
          localnrr.d = localJSONObject.optString("icon_selected");
          localnrr.e = localJSONObject.optString("textcolor_normal");
          localnrr.f = localJSONObject.optString("textcolor_selected");
          localnrr.b = localJSONObject.optString("jump_url");
          localnrr.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localArrayList.add(localnrr);
          i += 1;
        }
        localnrq.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      return localnrq;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localnrq;
  }
  
  public nrr a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      nrr localnrr = (nrr)localIterator.next();
      if (localnrr.jdField_a_of_type_Int == paramInt) {
        return localnrr;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrq
 * JD-Core Version:    0.7.0.1
 */