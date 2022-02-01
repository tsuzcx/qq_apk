import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ohh
{
  public int a;
  public String a;
  public ArrayList<ohi> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public ohh()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = "#FFFFFF";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ohh a(String paramString)
  {
    int i = 0;
    ohh localohh = new ohh();
    if (!StringUtil.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localohh.jdField_b_of_type_Int = paramString.optInt("jump_tab_id", 2);
        localohh.jdField_c_of_type_Int = paramString.optInt("tab_switch");
        localohh.jdField_b_of_type_JavaLangString = paramString.optString("tab_background", "#FFFFFF");
        localohh.jdField_d_of_type_Int = paramString.optInt("is_preload");
        localohh.jdField_a_of_type_Int = paramString.optInt("ark_report_switch", 1);
        localohh.jdField_a_of_type_JavaLangString = paramString.optString("btn_txt");
        localohh.jdField_c_of_type_JavaLangString = paramString.optString("minus_view_titie_url", "https://i.gtimg.cn/channel/imglib/202005/upload_0130d1d150ac825d9804c01c17955272.png");
        localohh.jdField_d_of_type_JavaLangString = paramString.optString("recommend_title_url", "https://i.gtimg.cn/channel/imglib/202005/upload_d10f6014892e80a6195c5a965a6b8ac0.png");
        paramString = paramString.optJSONArray("tabs");
        if ((paramString != null) && (paramString.length() > 0))
        {
          ArrayList localArrayList = new ArrayList(paramString.length());
          if (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.optJSONObject(i);
            ohi localohi = new ohi();
            localohi.jdField_a_of_type_Int = localJSONObject.optInt("tabid");
            localohi.jdField_c_of_type_JavaLangString = localJSONObject.optString("icon_normal");
            localohi.jdField_d_of_type_JavaLangString = localJSONObject.optString("icon_selected");
            localohi.e = localJSONObject.optString("textcolor_normal", "#CCCCCC");
            localohi.f = localJSONObject.optString("textcolor_selected", "#000000");
            localohi.jdField_b_of_type_JavaLangString = localJSONObject.optString("jump_url", "https://h5.qianbao.qq.com/qqshop/index?_wwv=128&_wv=7");
            localohi.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
            localohi.jdField_b_of_type_Int = localJSONObject.optInt("page_type", 0);
            localohi.g = localJSONObject.optString("min_app_version", "8.3.3");
            if (!localArrayList.contains(localohi)) {
              localArrayList.add(localohi);
            }
          }
          else
          {
            localohh.jdField_a_of_type_JavaUtilArrayList = localArrayList;
          }
        }
        else
        {
          return localohh;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localohh;
      }
      i += 1;
    }
  }
  
  public ohi a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ohi localohi = (ohi)localIterator.next();
      if (localohi.jdField_a_of_type_Int == paramInt) {
        return localohi;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohh
 * JD-Core Version:    0.7.0.1
 */