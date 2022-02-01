import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nsf
{
  public String a;
  public nsg a;
  public nsh a;
  public nsi a;
  public boolean a;
  public String b;
  public String c;
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("title")) {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("title");
    }
    if (paramJSONObject.has("video")) {
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("video");
    }
    if (paramJSONObject.has("picture")) {
      this.jdField_c_of_type_JavaLangString = paramJSONObject.getString("picture");
    }
    if (paramJSONObject.has("picture_attr")) {
      c(paramJSONObject.getJSONObject("picture_attr"));
    }
    if (paramJSONObject.has("video_attr")) {
      d(paramJSONObject.getJSONObject("video_attr"));
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Nsg = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Nsg = new nsg();
      if (paramJSONObject.has("articleid")) {
        this.jdField_a_of_type_Nsg.jdField_a_of_type_Long = paramJSONObject.getLong("articleid");
      }
      if (paramJSONObject.has("id")) {
        this.jdField_a_of_type_Nsg.jdField_b_of_type_Long = paramJSONObject.getLong("id");
      }
      if (paramJSONObject.has("jumpurl")) {
        this.jdField_a_of_type_Nsg.jdField_a_of_type_JavaLangString = paramJSONObject.getString("jumpurl");
      }
      if (paramJSONObject.has("msgtype")) {
        this.jdField_a_of_type_Nsg.jdField_a_of_type_Int = paramJSONObject.getInt("msgtype");
      }
      if (paramJSONObject.has("tasktype")) {
        this.jdField_a_of_type_Nsg.jdField_b_of_type_Int = paramJSONObject.getInt("tasktype");
      }
      if (paramJSONObject.has("time")) {
        this.jdField_a_of_type_Nsg.c = paramJSONObject.getLong("time");
      }
      if (paramJSONObject.has("uniqueid")) {
        this.jdField_a_of_type_Nsg.d = paramJSONObject.getLong("uniqueid");
      }
      if (paramJSONObject.has("rowkey")) {
        this.jdField_a_of_type_Nsg.jdField_b_of_type_JavaLangString = paramJSONObject.getString("rowkey");
      }
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Nsh = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Nsh = new nsh();
      if (paramJSONObject.has("cover")) {
        this.jdField_a_of_type_Nsh.jdField_a_of_type_JavaLangString = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("cover_orig")) {
        this.jdField_a_of_type_Nsh.jdField_b_of_type_JavaLangString = paramJSONObject.getString("cover_orig");
      }
      if (paramJSONObject.has("large")) {
        this.jdField_a_of_type_Nsh.jdField_a_of_type_Int = paramJSONObject.getInt("large");
      }
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Nsi = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Nsi = new nsi();
      if (paramJSONObject.has("busitype")) {
        this.jdField_a_of_type_Nsi.jdField_a_of_type_Int = paramJSONObject.getInt("busitype");
      }
      if (paramJSONObject.has("cover")) {
        this.jdField_a_of_type_Nsi.jdField_a_of_type_JavaLangString = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("cover_orig")) {
        this.jdField_a_of_type_Nsi.jdField_d_of_type_JavaLangString = paramJSONObject.getString("cover_orig");
      }
      if (paramJSONObject.has("fulltime")) {
        this.jdField_a_of_type_Nsi.jdField_b_of_type_Int = paramJSONObject.getInt("fulltime");
      }
      if (paramJSONObject.has("h5url")) {
        this.jdField_a_of_type_Nsi.jdField_b_of_type_JavaLangString = paramJSONObject.getString("h5url");
      }
      if (paramJSONObject.has("preheight")) {
        this.jdField_a_of_type_Nsi.jdField_c_of_type_Int = paramJSONObject.getInt("preheight");
      }
      if (paramJSONObject.has("prewidth")) {
        this.jdField_a_of_type_Nsi.jdField_d_of_type_Int = paramJSONObject.getInt("prewidth");
      }
      if (paramJSONObject.has("vid")) {
        this.jdField_a_of_type_Nsi.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vid");
      }
      if (paramJSONObject.has("large")) {
        this.jdField_a_of_type_Nsi.e = paramJSONObject.getInt("large");
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          Object localObject = paramString.getJSONObject("msg");
          if (((JSONObject)localObject).has("item"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("item");
            int i;
            JSONArray localJSONArray;
            if (localObject == null)
            {
              i = 0;
              break label189;
              if (j >= i) {
                continue;
              }
              localJSONArray = ((JSONArray)localObject).getJSONArray(j);
              if (localJSONArray == null)
              {
                k = 0;
                break label194;
                if (m >= k) {
                  break label200;
                }
                a(localJSONArray.getJSONObject(m));
                m += 1;
                continue;
              }
            }
            else
            {
              i = ((JSONArray)localObject).length();
              break label189;
            }
            int k = localJSONArray.length();
            break label194;
          }
        }
        if (!paramString.has("msg_attr")) {
          break;
        }
        b(paramString.getJSONObject("msg_attr"));
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DynamicInfo", 2, "DynamicInfo Exception:" + paramString.getMessage());
      return;
      label189:
      int j = 0;
      continue;
      label194:
      int m = 0;
      continue;
      label200:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsf
 * JD-Core Version:    0.7.0.1
 */