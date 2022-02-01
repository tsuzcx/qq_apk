package com.tencent.mobileqq.nearby.api;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyConfigUtil
{
  DatingConfig a;
  
  public static boolean a(AppInterface paramAppInterface)
  {
    paramAppInterface = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramAppInterface.getAccount(), "key_tabs_array", "");
    int i = 0;
    boolean bool2;
    boolean bool1;
    boolean bool3;
    try
    {
      paramAppInterface = new JSONArray(paramAppInterface);
      bool2 = false;
      bool1 = false;
      for (;;)
      {
        bool3 = bool1;
        bool4 = bool2;
        try
        {
          if (i >= paramAppInterface.length()) {
            break label157;
          }
          int j = paramAppInterface.optJSONObject(i).optInt("tabType");
          if (j == 1) {
            bool2 = true;
          }
          if (j == 5) {
            bool1 = true;
          }
          i += 1;
        }
        catch (Exception paramAppInterface) {}
      }
      bool3 = bool1;
    }
    catch (Exception paramAppInterface)
    {
      bool1 = false;
      bool2 = false;
    }
    boolean bool4 = bool2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNewNearbyTab:");
      localStringBuilder.append(paramAppInterface.toString());
      QLog.e("NearbyConfigUtil", 2, localStringBuilder.toString());
      bool4 = bool2;
      bool3 = bool1;
    }
    label157:
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("isNewNearbyTab: hasOldTab=");
      paramAppInterface.append(bool4);
      paramAppInterface.append(", hasNewTab=");
      paramAppInterface.append(bool3);
      QLog.d("NearbyConfigUtil", 2, paramAppInterface.toString());
    }
    return bool3;
  }
  
  public static boolean a(AppInterface paramAppInterface, int paramInt)
  {
    paramAppInterface = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramAppInterface.getCurrentAccountUin(), "key_banner_enter_items", "");
    boolean bool2 = false;
    try
    {
      paramAppInterface = new JSONArray(paramAppInterface);
      int i = 0;
      boolean bool1;
      Object localObject;
      for (;;)
      {
        bool1 = bool2;
        if (i >= paramAppInterface.length()) {
          break;
        }
        localObject = paramAppInterface.optJSONObject(i);
        if (((JSONObject)localObject).has("id"))
        {
          int j = ((JSONObject)localObject).getInt("id");
          if (j == paramInt)
          {
            bool1 = true;
            break;
          }
        }
        i += 1;
      }
      return bool1;
    }
    catch (Exception paramAppInterface)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hasEnterItem:");
        ((StringBuilder)localObject).append(paramAppInterface.toString());
        QLog.e("NearbyConfigUtil", 2, ((StringBuilder)localObject).toString());
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("hasEnterItem: itemId=");
        paramAppInterface.append(paramInt);
        paramAppInterface.append(", ret=");
        paramAppInterface.append(bool1);
        QLog.d("NearbyConfigUtil", 2, paramAppInterface.toString());
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("self_info");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    int i;
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("charm_level", 0);
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    paramQQAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("nearby_enters", 4).getString("config_content", null);
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      return false;
    }
    for (;;)
    {
      int j;
      try
      {
        paramQQAppInterface = new JSONObject(paramQQAppInterface).optJSONArray("nearby_list_entrance");
        if (paramQQAppInterface != null) {
          break label177;
        }
        return false;
      }
      catch (JSONException paramQQAppInterface)
      {
        int k;
        int m;
        paramQQAppInterface.printStackTrace();
      }
      if (j < paramQQAppInterface.length())
      {
        localObject = paramQQAppInterface.optJSONObject(j);
        k = ((JSONObject)localObject).optInt("id");
        m = ((JSONObject)localObject).optInt("lv_limit");
        if ((k == paramInt) && (i >= m)) {
          return true;
        }
        j += 1;
      }
      else
      {
        return false;
        label177:
        j = 0;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearRedDotInNearbyEnter: redDotType=");
        localStringBuilder.append(paramInt);
        QLog.d("nearby.redpoint", 1, localStringBuilder.toString());
        paramQQAppInterface = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        if (paramInt != 56)
        {
          if (paramInt != 61) {
            break label118;
          }
          continue;
          paramQQAppInterface.d(paramInt);
          return;
        }
        paramQQAppInterface.d(56);
        paramQQAppInterface.d(61);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("clearRedDotInNearbyEnter, exp=");
          localStringBuilder.append(paramQQAppInterface.toString());
          QLog.d("nearby.redpoint", 2, localStringBuilder.toString());
        }
        return;
      }
      label118:
      if (paramInt != 60) {
        if (paramInt != 57) {}
      }
    }
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    paramAppInterface = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramAppInterface.getAccount(), "key_tabs_array", "");
    int i = 0;
    boolean bool1;
    boolean bool2;
    try
    {
      paramAppInterface = new JSONArray(paramAppInterface);
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        try
        {
          if (i >= paramAppInterface.length()) {
            break label132;
          }
          int j = paramAppInterface.optJSONObject(i).optInt("tabType");
          if (j == 6) {
            bool1 = true;
          }
          i += 1;
        }
        catch (Exception paramAppInterface) {}
      }
      bool2 = bool1;
    }
    catch (Exception paramAppInterface)
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNearbyMsgTab:");
      localStringBuilder.append(paramAppInterface.toString());
      QLog.e("NearbyConfigUtil", 2, localStringBuilder.toString());
      bool2 = bool1;
    }
    label132:
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("isNewNearbyTab: hasMsgTab=");
      paramAppInterface.append(bool2);
      QLog.d("NearbyConfigUtil", 2, paramAppInterface.toString());
    }
    return bool2;
  }
  
  public DatingConfig a()
  {
    try
    {
      if (this.a != null)
      {
        localObject1 = this.a;
        return localObject1;
      }
      Object localObject3 = null;
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Object.class;
      Object[] arrayOfObject = FileUtils.readObjectList("dating_others.cfg", arrayOfClass);
      Object localObject1 = localObject3;
      if (arrayOfObject != null)
      {
        localObject1 = localObject3;
        if (arrayOfObject.length == arrayOfClass.length)
        {
          localObject1 = (DatingConfig)arrayOfObject[0];
          this.a = ((DatingConfig)localObject1);
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      DatingConfig localDatingConfig = this.a;
      if (localDatingConfig == null) {
        return;
      }
      this.a = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyConfigUtil
 * JD-Core Version:    0.7.0.1
 */