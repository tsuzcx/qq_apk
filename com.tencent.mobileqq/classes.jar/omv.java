import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class omv
{
  public int a;
  public String a;
  public CopyOnWriteArrayList<omw> a;
  public JSONArray a;
  public int b;
  public String b;
  public String c = "2";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  
  public omv()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static omv a(String paramString)
  {
    omv localomv = new omv();
    try
    {
      paramString = new JSONObject(paramString);
      localomv.jdField_a_of_type_JavaLangString = paramString.optString("more_btn_url");
      localomv.jdField_b_of_type_JavaLangString = paramString.optString("trace_id");
      localomv.d = paramString.optString("md_style");
      localomv.f = paramString.optString("game_tips");
      localomv.g = paramString.optString("game_tips_icon");
      localomv.j = paramString.optString("game_id");
      localomv.o = paramString.optString("game_name");
      localomv.l = paramString.optString("game_icon");
      localomv.m = paramString.optString("game_desc");
      localomv.n = paramString.optString("game_btn_text");
      localomv.k = paramString.optString("game_jump_url");
      localomv.jdField_a_of_type_OrgJsonJSONArray = paramString.optJSONArray("app_picthree");
      localomv.p = paramString.optString("article_title");
      localomv.jdField_b_of_type_Int = paramString.optInt("card_size");
      localomv.jdField_a_of_type_Int = paramString.optInt("style_type");
      localomv.h = paramString.optString("left_big_img_url");
      localomv.i = paramString.optString("background_img_url");
      int i1 = paramString.optInt("obj_type");
      if (i1 != 0) {
        localomv.c = String.valueOf(i1);
      }
      if (localomv.jdField_b_of_type_Int > 0)
      {
        a(paramString, localomv.jdField_b_of_type_Int, localomv);
        return localomv;
      }
      a(paramString, 5, localomv);
      return localomv;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallMiniGameInfo", 2, "json error:" + paramString.getMessage());
      }
    }
    return localomv;
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt, omv paramomv)
  {
    paramomv.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i1 = 1;
    while (i1 <= paramInt)
    {
      omw localomw = new omw();
      localomw.jdField_a_of_type_JavaLangString = paramJSONObject.optString("game_id" + i1);
      localomw.c = paramJSONObject.optString("game_slot_type" + i1);
      localomw.d = paramJSONObject.optString("game_title" + i1);
      localomw.jdField_b_of_type_JavaLangString = paramJSONObject.optString("game_url" + i1);
      paramomv.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localomw);
      i1 += 1;
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((omw)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > paramInt) {
        str1 = ((omw)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public String b(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > paramInt) {
        str1 = ((omw)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_b_of_type_JavaLangString;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omv
 * JD-Core Version:    0.7.0.1
 */