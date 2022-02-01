package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import java.util.HashMap;
import org.json.JSONObject;

public class TencentDocsPushBean
{
  private HashMap<String, TencentDocsPushItemBean> a = new HashMap();
  
  public TencentDocsPushBean()
  {
    TencentDocsPushItemBean localTencentDocsPushItemBean = new TencentDocsPushItemBean();
    localTencentDocsPushItemBean.a(true);
    localTencentDocsPushItemBean.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localTencentDocsPushItemBean);
  }
  
  public static TencentDocsPushBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    for (;;)
    {
      TencentDocsPushBean localTencentDocsPushBean;
      int i;
      JSONObject localJSONObject;
      try
      {
        localTencentDocsPushBean = new TencentDocsPushBean();
        i = 0;
        if (i >= paramArrayOfQConfItem.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfQConfItem[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localTencentDocsPushBean.a.put("docs_miniapp_config_aio_msg", TencentDocsPushItemBean.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localTencentDocsPushBean.a.put("docs_miniapp_config_aio_edit", TencentDocsPushItemBean.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localTencentDocsPushBean.a.put("docs_miniapp_config_bottom_edit", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localTencentDocsPushBean.a.put("docs_miniapp_config_my_file", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localTencentDocsPushBean.a.put("docs_miniapp_config_troop_file", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localTencentDocsPushBean.a.put("docs_miniapp_config_gray_bar", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localTencentDocsPushBean.a.put("docs_miniapp_config_menu_edit", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localTencentDocsPushBean.a.put("docs_miniapp_config_download_edit", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localTencentDocsPushBean.a.put("docs_miniapp_config_online_preview", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localTencentDocsPushBean.a.put("docs_miniapp_config_templatelist", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localTencentDocsPushBean.a.put("docs_miniapp_config_ocr_save", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localTencentDocsPushBean.a.put("docs_miniapp_config_url_2_doc", TencentDocsPushItemBean.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localTencentDocsPushBean.a.put("docs_miniapp_config_aio_ark_h5", TencentDocsPushItemBean.a(localJSONObject));
        break label518;
        label516:
        return localTencentDocsPushBean;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, TencentDocsPushItemBean> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TencentDocsPushBean
 * JD-Core Version:    0.7.0.1
 */