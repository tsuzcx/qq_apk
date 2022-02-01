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
  private boolean a = true;
  private boolean b = true;
  private int c = 60;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private String j = "";
  private ArrayList<Integer> k = new MiniAppConfBean.1(this);
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private String p = "";
  private String q = "";
  
  public static MiniAppConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1 = "back_to_home_scene_list";
    Object localObject2 = "avatar_mini_app_on";
    String str1 = "mini_app_refresh_time";
    MiniAppConfBean localMiniAppConfBean = new MiniAppConfBean();
    Object localObject3 = new StringBuilder();
    int i1 = 0;
    for (;;)
    {
      Object localObject4 = paramArrayOfQConfItem;
      for (;;)
      {
        int i2;
        try
        {
          if (i1 < localObject4.length)
          {
            String str2 = localObject4[i1].b;
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
            localMiniAppConfBean.a = bool;
            if (localJSONObject.has("mini_app_local_search"))
            {
              if (localJSONObject.optInt("mini_app_local_search", 1) != 1) {
                break label803;
              }
              bool = true;
              localMiniAppConfBean.b = bool;
            }
            if (localJSONObject.has(str1)) {
              localMiniAppConfBean.c = localJSONObject.optInt(str1, 60);
            }
            if (!localJSONObject.has("popBarShowMiniAppStore")) {
              break label815;
            }
            if (localJSONObject.optInt("popBarShowMiniAppStore", 0) != 1) {
              break label809;
            }
            bool = true;
            localMiniAppConfBean.d = bool;
            if (localJSONObject.has("minigame_splash")) {
              ((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).saveConfigData(str2);
            }
            if (localJSONObject.has("mini_app_entry_auto_show"))
            {
              if (localJSONObject.optInt("mini_app_entry_auto_show", 0) != 1) {
                break label818;
              }
              bool = true;
              localMiniAppConfBean.e = bool;
            }
            if (localJSONObject.has("contact_mini_app_on"))
            {
              if (localJSONObject.optInt("contact_mini_app_on", 0) != 1) {
                break label824;
              }
              bool = true;
              localMiniAppConfBean.g = bool;
            }
            if (localJSONObject.has("more_mini_app_on"))
            {
              if (localJSONObject.optInt("more_mini_app_on", 0) != 1) {
                break label830;
              }
              bool = true;
              localMiniAppConfBean.f = bool;
            }
            if (localJSONObject.has("group_mini_app_on"))
            {
              if (localJSONObject.optInt("group_mini_app_on", 0) != 1) {
                break label836;
              }
              bool = true;
              localMiniAppConfBean.h = bool;
            }
            if (localJSONObject.has((String)localObject2))
            {
              if (localJSONObject.optInt((String)localObject2, 0) != 1) {
                break label842;
              }
              bool = true;
              localMiniAppConfBean.i = bool;
              if (localJSONObject.has("avatar_mini_app_url")) {
                localMiniAppConfBean.j = localJSONObject.optString("avatar_mini_app_url");
              }
            }
            Object localObject5 = localObject1;
            localObject4 = localObject2;
            if (localJSONObject.has((String)localObject1))
            {
              if (localMiniAppConfBean.k == null) {
                localMiniAppConfBean.k = new ArrayList();
              }
              localMiniAppConfBean.k.clear();
              String[] arrayOfString = localJSONObject.optString((String)localObject1, "1044|1007|1008|2003").split("\\|");
              int i3 = arrayOfString.length;
              i2 = 0;
              localObject5 = localObject1;
              localObject4 = localObject2;
              if (i2 < i3)
              {
                localObject4 = arrayOfString[i2];
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label848;
                }
                localMiniAppConfBean.k.add(Integer.valueOf((String)localObject4));
                break label848;
              }
            }
            localObject2 = localObject5;
            if (1 == localJSONObject.optInt("enable_c2c_plus_panel", 0))
            {
              localMiniAppConfBean.l = localJSONObject.optString("url", "");
              localMiniAppConfBean.m = localJSONObject.optString("icon", "");
              localMiniAppConfBean.n = localJSONObject.optString("icon_night", "");
              localMiniAppConfBean.o = localJSONObject.optString("simple_icon", "");
              localMiniAppConfBean.p = localJSONObject.optString("simple_icon_night", "");
              localMiniAppConfBean.q = localJSONObject.optString("name", BaseApplicationImpl.sApplication.getString(2131896488));
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
        i2 += 1;
      }
      i1 += 1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.l;
  }
  
  public String k()
  {
    return this.m;
  }
  
  public String l()
  {
    return this.n;
  }
  
  public String m()
  {
    return this.o;
  }
  
  public String n()
  {
    return this.p;
  }
  
  public String o()
  {
    return this.q;
  }
  
  public ArrayList<Integer> p()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("miniAppEntryEnable:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", miniAppRefreshTime:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",miniAppLocalSearchEnable");
    localStringBuilder.append(this.b);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MiniAppConfBean
 * JD-Core Version:    0.7.0.1
 */