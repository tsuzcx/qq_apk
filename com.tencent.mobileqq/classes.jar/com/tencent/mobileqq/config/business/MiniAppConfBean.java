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
    Object localObject1 = "back_to_home_scene_list";
    Object localObject2 = "avatar_mini_app_on";
    String str1 = "mini_app_refresh_time";
    MiniAppConfBean localMiniAppConfBean = new MiniAppConfBean();
    Object localObject3 = new StringBuilder();
    int i = 0;
    for (;;)
    {
      Object localObject4 = paramArrayOfQConfItem;
      for (;;)
      {
        int j;
        try
        {
          if (i < localObject4.length)
          {
            String str2 = localObject4[i].jdField_a_of_type_JavaLangString;
            if (str2 == null)
            {
              localObject4 = localObject1;
              localObject5 = localObject2;
              localObject1 = localObject3;
              localObject2 = localObject4;
              localObject3 = localObject5;
              break;
            }
            JSONObject localJSONObject = new JSONObject(str2);
            if (!localJSONObject.has("aio_mini_app_on")) {
              break label800;
            }
            if (localJSONObject.optInt("aio_mini_app_on", 1) != 1) {
              break label794;
            }
            bool = true;
            localMiniAppConfBean.jdField_a_of_type_Boolean = bool;
            if (localJSONObject.has("mini_app_local_search"))
            {
              if (localJSONObject.optInt("mini_app_local_search", 1) != 1) {
                break label803;
              }
              bool = true;
              localMiniAppConfBean.jdField_b_of_type_Boolean = bool;
            }
            if (localJSONObject.has(str1)) {
              localMiniAppConfBean.jdField_a_of_type_Int = localJSONObject.optInt(str1, 60);
            }
            if (!localJSONObject.has("popBarShowMiniAppStore")) {
              break label815;
            }
            if (localJSONObject.optInt("popBarShowMiniAppStore", 0) != 1) {
              break label809;
            }
            bool = true;
            localMiniAppConfBean.jdField_c_of_type_Boolean = bool;
            if (localJSONObject.has("minigame_splash")) {
              ((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).saveConfigData(str2);
            }
            if (localJSONObject.has("mini_app_entry_auto_show"))
            {
              if (localJSONObject.optInt("mini_app_entry_auto_show", 0) != 1) {
                break label818;
              }
              bool = true;
              localMiniAppConfBean.jdField_d_of_type_Boolean = bool;
            }
            if (localJSONObject.has("contact_mini_app_on"))
            {
              if (localJSONObject.optInt("contact_mini_app_on", 0) != 1) {
                break label824;
              }
              bool = true;
              localMiniAppConfBean.jdField_f_of_type_Boolean = bool;
            }
            if (localJSONObject.has("more_mini_app_on"))
            {
              if (localJSONObject.optInt("more_mini_app_on", 0) != 1) {
                break label830;
              }
              bool = true;
              localMiniAppConfBean.jdField_e_of_type_Boolean = bool;
            }
            if (localJSONObject.has("group_mini_app_on"))
            {
              if (localJSONObject.optInt("group_mini_app_on", 0) != 1) {
                break label836;
              }
              bool = true;
              localMiniAppConfBean.jdField_g_of_type_Boolean = bool;
            }
            if (localJSONObject.has((String)localObject2))
            {
              if (localJSONObject.optInt((String)localObject2, 0) != 1) {
                break label842;
              }
              bool = true;
              localMiniAppConfBean.h = bool;
              if (localJSONObject.has("avatar_mini_app_url")) {
                localMiniAppConfBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("avatar_mini_app_url");
              }
            }
            Object localObject5 = localObject1;
            localObject4 = localObject2;
            if (localJSONObject.has((String)localObject1))
            {
              if (localMiniAppConfBean.jdField_a_of_type_JavaUtilArrayList == null) {
                localMiniAppConfBean.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              localMiniAppConfBean.jdField_a_of_type_JavaUtilArrayList.clear();
              String[] arrayOfString = localJSONObject.optString((String)localObject1, "1044|1007|1008|2003").split("\\|");
              int k = arrayOfString.length;
              j = 0;
              localObject5 = localObject1;
              localObject4 = localObject2;
              if (j < k)
              {
                localObject4 = arrayOfString[j];
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label848;
                }
                localMiniAppConfBean.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf((String)localObject4));
                break label848;
              }
            }
            localObject2 = localObject5;
            if (1 == localJSONObject.optInt("enable_c2c_plus_panel", 0))
            {
              localMiniAppConfBean.jdField_b_of_type_JavaLangString = localJSONObject.optString("url", "");
              localMiniAppConfBean.jdField_c_of_type_JavaLangString = localJSONObject.optString("icon", "");
              localMiniAppConfBean.jdField_d_of_type_JavaLangString = localJSONObject.optString("icon_night", "");
              localMiniAppConfBean.jdField_e_of_type_JavaLangString = localJSONObject.optString("simple_icon", "");
              localMiniAppConfBean.jdField_f_of_type_JavaLangString = localJSONObject.optString("simple_icon_night", "");
              localMiniAppConfBean.jdField_g_of_type_JavaLangString = localJSONObject.optString("name", BaseApplicationImpl.sApplication.getString(2131698542));
              localObject1 = BaseApplicationImpl.getApplication().getRuntime();
              if ((localObject1 instanceof QQAppInterface))
              {
                localObject1 = (QQAppInterface)localObject1;
                AioPanelMiniAppManager.a((QQAppInterface)localObject1).a((QQAppInterface)localObject1, localMiniAppConfBean);
              }
            }
            localObject1 = localObject3;
            ((StringBuilder)localObject1).append("config: ");
            ((StringBuilder)localObject1).append(str2);
            ((StringBuilder)localObject1).append(",");
            localObject3 = localObject4;
            break;
          }
          paramArrayOfQConfItem = new StringBuilder();
          paramArrayOfQConfItem.append("parse, content:");
          paramArrayOfQConfItem.append(((StringBuilder)localObject3).toString());
          paramArrayOfQConfItem = paramArrayOfQConfItem.toString();
          try
          {
            QLog.e("MiniAppConfProcessor", 2, paramArrayOfQConfItem);
            return localMiniAppConfBean;
          }
          catch (Exception paramArrayOfQConfItem) {}
          QLog.d("MiniAppConfProcessor", 2, "parse, failed!");
        }
        catch (Exception paramArrayOfQConfItem) {}
        paramArrayOfQConfItem.printStackTrace();
        return null;
        label794:
        boolean bool = false;
        continue;
        label800:
        continue;
        label803:
        bool = false;
        continue;
        label809:
        bool = false;
        continue;
        label815:
        continue;
        label818:
        bool = false;
        continue;
        label824:
        bool = false;
        continue;
        label830:
        bool = false;
        continue;
        label836:
        bool = false;
        continue;
        label842:
        bool = false;
        continue;
        label848:
        j += 1;
      }
      i += 1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("miniAppEntryEnable:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", miniAppRefreshTime:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",miniAppLocalSearchEnable");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MiniAppConfBean
 * JD-Core Version:    0.7.0.1
 */