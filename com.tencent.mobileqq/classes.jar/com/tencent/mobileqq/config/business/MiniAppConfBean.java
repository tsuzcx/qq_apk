package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class MiniAppConfBean
{
  private int jdField_a_of_type_Int = 60;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new MiniAppConfBean.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean = false;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = false;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  
  public static MiniAppConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    MiniAppConfBean localMiniAppConfBean = new MiniAppConfBean();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (i < paramArrayOfQConfItem.length)
        {
          String str1 = paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString;
          if (str1 == null) {
            break label681;
          }
          Object localObject = new JSONObject(str1);
          if (((JSONObject)localObject).has("aio_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("aio_mini_app_on", 1) != 1) {
              break label695;
            }
            bool = true;
            localMiniAppConfBean.jdField_a_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("mini_app_local_search"))
          {
            if (((JSONObject)localObject).optInt("mini_app_local_search", 1) != 1) {
              break label701;
            }
            bool = true;
            localMiniAppConfBean.jdField_b_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("mini_app_refresh_time")) {
            localMiniAppConfBean.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("mini_app_refresh_time", 60);
          }
          if (((JSONObject)localObject).has("popBarShowMiniAppStore"))
          {
            if (((JSONObject)localObject).optInt("popBarShowMiniAppStore", 0) != 1) {
              break label707;
            }
            bool = true;
            localMiniAppConfBean.jdField_c_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("minigame_splash")) {
            ((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).saveConfigData(str1);
          }
          if (((JSONObject)localObject).has("mini_app_entry_auto_show"))
          {
            if (((JSONObject)localObject).optInt("mini_app_entry_auto_show", 0) != 1) {
              break label713;
            }
            bool = true;
            localMiniAppConfBean.jdField_d_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("contact_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("contact_mini_app_on", 0) != 1) {
              break label719;
            }
            bool = true;
            localMiniAppConfBean.jdField_f_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("more_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("more_mini_app_on", 0) != 1) {
              break label725;
            }
            bool = true;
            localMiniAppConfBean.jdField_e_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("group_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("group_mini_app_on", 0) != 1) {
              break label731;
            }
            bool = true;
            localMiniAppConfBean.jdField_g_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("avatar_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("avatar_mini_app_on", 0) != 1) {
              break label737;
            }
            bool = true;
            localMiniAppConfBean.h = bool;
            if (((JSONObject)localObject).has("avatar_mini_app_url")) {
              localMiniAppConfBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("avatar_mini_app_url");
            }
          }
          if (((JSONObject)localObject).has("back_to_home_scene_list"))
          {
            if (localMiniAppConfBean.jdField_a_of_type_JavaUtilArrayList == null) {
              localMiniAppConfBean.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            localMiniAppConfBean.jdField_a_of_type_JavaUtilArrayList.clear();
            String[] arrayOfString = ((JSONObject)localObject).optString("back_to_home_scene_list", "1044|1007|1008|2003").split("\\|");
            int k = arrayOfString.length;
            j = 0;
            if (j < k)
            {
              String str2 = arrayOfString[j];
              if (TextUtils.isEmpty(str2)) {
                break label688;
              }
              localMiniAppConfBean.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(str2));
              break label688;
            }
          }
          if (1 == ((JSONObject)localObject).optInt("enable_c2c_plus_panel", 0))
          {
            localMiniAppConfBean.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("url", "");
            localMiniAppConfBean.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("icon", "");
            localMiniAppConfBean.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("icon_night", "");
            localMiniAppConfBean.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("simple_icon", "");
            localMiniAppConfBean.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("simple_icon_night", "");
            localMiniAppConfBean.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("name", BaseApplicationImpl.sApplication.getString(2131698476));
            localObject = BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject instanceof QQAppInterface))
            {
              localObject = (QQAppInterface)localObject;
              AioPanelMiniAppManager.a((QQAppInterface)localObject).a((QQAppInterface)localObject, localMiniAppConfBean);
            }
          }
          localStringBuilder.append("config: ").append(str1).append(",");
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.d("MiniAppConfProcessor", 2, "parse, failed!");
        paramArrayOfQConfItem.printStackTrace();
        return null;
      }
      QLog.e("MiniAppConfProcessor", 2, "parse, content:" + localStringBuilder.toString());
      return localMiniAppConfBean;
      label681:
      i += 1;
      continue;
      label688:
      j += 1;
      continue;
      label695:
      boolean bool = false;
      continue;
      label701:
      bool = false;
      continue;
      label707:
      bool = false;
      continue;
      label713:
      bool = false;
      continue;
      label719:
      bool = false;
      continue;
      label725:
      bool = false;
      continue;
      label731:
      bool = false;
      continue;
      label737:
      bool = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public String e()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public String f()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public boolean f()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public String g()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public String toString()
  {
    new StringBuilder().append("miniAppEntryEnable:").append(this.jdField_a_of_type_Boolean).append(", miniAppRefreshTime:").append(this.jdField_a_of_type_Int).append(",miniAppLocalSearchEnable").append(this.jdField_b_of_type_Boolean);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MiniAppConfBean
 * JD-Core Version:    0.7.0.1
 */