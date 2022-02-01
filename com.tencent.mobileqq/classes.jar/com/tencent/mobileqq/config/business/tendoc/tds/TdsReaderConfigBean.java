package com.tencent.mobileqq.config.business.tendoc.tds;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class TdsReaderConfigBean
{
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static TdsReaderConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TdsReaderConfigBean localTdsReaderConfigBean = new TdsReaderConfigBean();
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfQConfItem[i];
        JSONObject localJSONObject;
        try
        {
          localObject = new JSONObject(((QConfItem)localObject).a);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("TdsReaderView_TdsReaderConfigBean", 1, "parse error", localJSONException);
          localJSONObject = null;
        }
        if (localJSONObject != null)
        {
          if (localJSONObject.has("has_gray")) {
            localTdsReaderConfigBean.jdField_a_of_type_Boolean = localJSONObject.optBoolean("has_gray");
          }
          a(localJSONObject, localTdsReaderConfigBean.jdField_a_of_type_JavaUtilMap);
        }
        i += 1;
      }
      return localTdsReaderConfigBean;
    }
    QLog.e("TdsReaderView_TdsReaderConfigBean", 1, "parse error, confFiles is no-valid.");
    return null;
  }
  
  public static void a(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if (paramJSONObject != null)
    {
      if (paramMap == null) {
        return;
      }
      if (paramJSONObject.has("facade_plugin_name")) {
        paramMap.put("facade_plugin_name", paramJSONObject.optString("facade_plugin_name"));
      }
      if (paramJSONObject.has("facade_plugin_name_prefix")) {
        paramMap.put("facade_plugin_name_prefix", paramJSONObject.optString("facade_plugin_name_prefix"));
      }
      if (paramJSONObject.has("facade_plugin_url")) {
        paramMap.put("facade_plugin_url", paramJSONObject.optString("facade_plugin_url"));
      }
      if (paramJSONObject.has("facade_plugin_md5")) {
        paramMap.put("facade_plugin_md5", paramJSONObject.optString("facade_plugin_md5"));
      }
      if (paramJSONObject.has("facade_plugin_entry_class")) {
        paramMap.put("facade_plugin_entry_class", paramJSONObject.optString("facade_plugin_entry_class"));
      }
      if (paramJSONObject.has("pre_load_info")) {
        paramMap.put("pre_load_info", paramJSONObject.optString("pre_load_info"));
      }
      if (paramJSONObject.has("global_required_res_info")) {
        paramMap.put("global_required_res_info", paramJSONObject.optString("global_required_res_info"));
      }
      if (paramJSONObject.has("docs_plugin_info")) {
        paramMap.put("docs_plugin_info", paramJSONObject.optString("docs_plugin_info"));
      }
      if (paramJSONObject.has("docs_font_info")) {
        paramMap.put("docs_font_info", paramJSONObject.optString("docs_font_info"));
      }
      if (paramJSONObject.has("sheets_plugin_info")) {
        paramMap.put("sheets_plugin_info", paramJSONObject.optString("sheets_plugin_info"));
      }
      if (paramJSONObject.has("slides_plugin_info")) {
        paramMap.put("slides_plugin_info", paramJSONObject.optString("slides_plugin_info"));
      }
      if (paramJSONObject.has("slides_res_info")) {
        paramMap.put("slides_res_info", paramJSONObject.optString("slides_res_info"));
      }
    }
  }
  
  public static void a(boolean paramBoolean, TdsReaderConfigBean paramTdsReaderConfigBean)
  {
    if (paramTdsReaderConfigBean == null)
    {
      QLog.w("TdsReaderView_TdsReaderConfigBean", 1, "source error, configBean is null.");
      return;
    }
    boolean bool = paramTdsReaderConfigBean.jdField_a_of_type_JavaUtilMap.isEmpty() ^ true;
    if (bool) {
      TdsReaderGlobal.a(paramBoolean, paramTdsReaderConfigBean.jdField_a_of_type_JavaUtilMap);
    }
    if (paramTdsReaderConfigBean.jdField_a_of_type_Boolean)
    {
      TdsReaderGrayConfigProcessor.a();
      return;
    }
    if (!bool) {
      return;
    }
    TdsReaderGlobal.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.tds.TdsReaderConfigBean
 * JD-Core Version:    0.7.0.1
 */