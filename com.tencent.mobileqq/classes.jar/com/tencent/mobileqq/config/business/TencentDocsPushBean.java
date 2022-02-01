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
    Object localObject1 = paramArrayOfQConfItem;
    String str = "MiniCodeConfigAioMsg";
    if ((localObject1 != null) && (localObject1.length > 0)) {
      try
      {
        TencentDocsPushBean localTencentDocsPushBean = new TencentDocsPushBean();
        localObject1 = "MiniCodeConfigAioArkH5";
        int i = 0;
        for (;;)
        {
          Object localObject2 = paramArrayOfQConfItem;
          if (i >= localObject2.length) {
            break;
          }
          localObject2 = new JSONObject(localObject2[i].b);
          if (((JSONObject)localObject2).has(str))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get(str);
            localTencentDocsPushBean.a.put("docs_miniapp_config_aio_msg", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigAioEdit"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigAioEdit");
            localTencentDocsPushBean.a.put("docs_miniapp_config_aio_edit", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigBottomEdit"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigBottomEdit");
            localTencentDocsPushBean.a.put("docs_miniapp_config_bottom_edit", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigMyFile"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigMyFile");
            localTencentDocsPushBean.a.put("docs_miniapp_config_my_file", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigTroopFile"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigTroopFile");
            localTencentDocsPushBean.a.put("docs_miniapp_config_troop_file", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigGrayBar"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigGrayBar");
            localTencentDocsPushBean.a.put("docs_miniapp_config_gray_bar", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigMenuEdit"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigMenuEdit");
            localTencentDocsPushBean.a.put("docs_miniapp_config_menu_edit", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigDownloadEdit"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigDownloadEdit");
            localTencentDocsPushBean.a.put("docs_miniapp_config_download_edit", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("docs_miniapp_config_online_preview"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("docs_miniapp_config_online_preview");
            localTencentDocsPushBean.a.put("docs_miniapp_config_online_preview", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigTemplateList"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigTemplateList");
            localTencentDocsPushBean.a.put("docs_miniapp_config_templatelist", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigOcrSave"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigOcrSave");
            localTencentDocsPushBean.a.put("docs_miniapp_config_ocr_save", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has("MiniCodeConfigUrl2Doc"))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get("MiniCodeConfigUrl2Doc");
            localTencentDocsPushBean.a.put("docs_miniapp_config_url_2_doc", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          else if (((JSONObject)localObject2).has((String)localObject1))
          {
            localObject2 = (JSONObject)((JSONObject)localObject2).get((String)localObject1);
            HashMap localHashMap = localTencentDocsPushBean.a;
            localHashMap.put("docs_miniapp_config_aio_ark_h5", TencentDocsPushItemBean.a((JSONObject)localObject2));
          }
          i += 1;
        }
        return localTencentDocsPushBean;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public HashMap<String, TencentDocsPushItemBean> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TencentDocsPushBean
 * JD-Core Version:    0.7.0.1
 */