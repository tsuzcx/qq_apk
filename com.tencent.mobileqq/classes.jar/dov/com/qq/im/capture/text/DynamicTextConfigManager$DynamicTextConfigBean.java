package dov.com.qq.im.capture.text;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicTextConfigManager$DynamicTextConfigBean
{
  public ArrayList<DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo> fontInfos = new ArrayList();
  public int iconDrawableId;
  public int predownload;
  public int text_id;
  
  public static DynamicTextConfigBean convertFrom(JSONObject paramJSONObject)
  {
    do
    {
      try
      {
        DynamicTextConfigBean localDynamicTextConfigBean = new DynamicTextConfigBean();
        int j;
        int i;
        Object localObject2 = paramJSONObject;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (paramJSONObject.has("text_id")) {
            localDynamicTextConfigBean.text_id = paramJSONObject.getInt("text_id");
          }
          if (paramJSONObject.has("predownload")) {
            localDynamicTextConfigBean.predownload = paramJSONObject.getInt("predownload");
          }
          if (paramJSONObject.has("fonts"))
          {
            paramJSONObject = paramJSONObject.getJSONArray("fonts");
            j = paramJSONObject.length();
            i = 0;
            while (i < j)
            {
              localObject2 = DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo.a((JSONObject)paramJSONObject.get(i));
              ((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject2).jdField_a_of_type_Int = localDynamicTextConfigBean.text_id;
              if (localObject2 != null) {
                localDynamicTextConfigBean.fontInfos.add(localObject2);
              }
              i += 1;
            }
          }
          localObject2 = localDynamicTextConfigBean;
          return localObject2;
        }
        catch (JSONException localJSONException2)
        {
          paramJSONObject = localJSONException1;
          Object localObject1 = localJSONException2;
          continue;
        }
        localJSONException1 = localJSONException1;
        paramJSONObject = null;
      }
    } while (!QLog.isColorLevel());
    QLog.i("DText", 2, localJSONException1.toString());
    return paramJSONObject;
  }
  
  public int getProgress()
  {
    int j;
    if (this.fontInfos == null)
    {
      j = 100;
      return j;
    }
    int k = this.fontInfos.size();
    Iterator localIterator = this.fontInfos.iterator();
    for (int i = 0;; i = ((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localIterator.next()).b * 1 / k + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public boolean isContainsResUrl(String paramString)
  {
    if ((this.fontInfos == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Iterator localIterator = this.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localIterator.next();
      if ((localDynamicTextFontInfo != null) && (paramString.equals(localDynamicTextFontInfo.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean
 * JD-Core Version:    0.7.0.1
 */