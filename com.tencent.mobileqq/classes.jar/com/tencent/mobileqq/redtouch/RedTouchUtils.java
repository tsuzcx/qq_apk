package com.tencent.mobileqq.redtouch;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class RedTouchUtils
{
  public static RedAppInfo a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchUtils BusinessInfo2RedAppInfo", 2, "appInfo is null ");
      }
      return null;
    }
    RedAppInfo localRedAppInfo = new RedAppInfo();
    localRedAppInfo.a(paramAppInfo.uiAppId.get());
    localRedAppInfo.b(paramAppInfo.iNewFlag.get());
    localRedAppInfo.c(paramAppInfo.type.get());
    localRedAppInfo.a(paramAppInfo.buffer.get());
    localRedAppInfo.b(paramAppInfo.path.get());
    localRedAppInfo.d(paramAppInfo.modify_ts.get());
    localRedAppInfo.e(paramAppInfo.appset.get());
    localRedAppInfo.f(paramAppInfo.num.get());
    localRedAppInfo.c(paramAppInfo.icon_url.get());
    localRedAppInfo.h(paramAppInfo.icon_type.get());
    localRedAppInfo.g(paramAppInfo.icon_flag.get());
    localRedAppInfo.i(paramAppInfo.push_red_ts.get());
    localRedAppInfo.j(paramAppInfo.mission_level.get());
    localRedAppInfo.k(paramAppInfo.exposure_max.get());
    Object localObject1 = new ArrayList();
    Object localObject2 = paramAppInfo.missions.get();
    int j = 0;
    int i;
    if ((localObject2 != null) && (paramAppInfo.missions.get().size() > 0))
    {
      i = 0;
      while (i < paramAppInfo.missions.get().size())
      {
        ((ArrayList)localObject1).add(paramAppInfo.missions.get().get(i));
        i += 1;
      }
    }
    localRedAppInfo.a((ArrayList)localObject1);
    localObject1 = new RedDisplayInfo();
    RedTypeInfo localRedTypeInfo = new RedTypeInfo();
    localObject2 = new ArrayList();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get()).tab_display_info.get();
    paramAppInfo = ((BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get()).red_type_info.get();
    if (localRedTypeInfo1 != null)
    {
      localRedTypeInfo.setRedContent(localRedTypeInfo1.red_content.get());
      localRedTypeInfo.setRedDesc(localRedTypeInfo1.red_desc.get());
      localRedTypeInfo.setRedPriority(localRedTypeInfo1.red_priority.get());
      localRedTypeInfo.setRedType(localRedTypeInfo1.red_type.get());
    }
    ((RedDisplayInfo)localObject1).a(localRedTypeInfo);
    if ((paramAppInfo != null) && (paramAppInfo.size() > 0))
    {
      i = j;
      while (i < paramAppInfo.size())
      {
        localRedTypeInfo = new RedTypeInfo();
        localRedTypeInfo.setRedContent(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i)).red_content.get());
        localRedTypeInfo.setRedDesc(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i)).red_desc.get());
        localRedTypeInfo.setRedPriority(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i)).red_priority.get());
        localRedTypeInfo.setRedType(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i)).red_type.get());
        ((ArrayList)localObject2).add(localRedTypeInfo);
        i += 1;
      }
    }
    ((RedDisplayInfo)localObject1).a((ArrayList)localObject2);
    localRedAppInfo.a((RedDisplayInfo)localObject1);
    return localRedAppInfo;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(RedAppInfo paramRedAppInfo)
  {
    if (paramRedAppInfo == null) {
      return null;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.uiAppId.set(paramRedAppInfo.a());
    localAppInfo.iNewFlag.set(paramRedAppInfo.b());
    localAppInfo.type.set(paramRedAppInfo.c());
    localAppInfo.buffer.set(paramRedAppInfo.d());
    localAppInfo.path.set(paramRedAppInfo.e());
    localAppInfo.modify_ts.set(paramRedAppInfo.f());
    localAppInfo.missions.set(paramRedAppInfo.g());
    localAppInfo.appset.set(paramRedAppInfo.h());
    localAppInfo.num.set(paramRedAppInfo.i());
    localAppInfo.icon_url.set(paramRedAppInfo.j());
    localAppInfo.icon_flag.set(paramRedAppInfo.k());
    localAppInfo.icon_type.set(paramRedAppInfo.l());
    localAppInfo.push_red_ts.set(paramRedAppInfo.m());
    localAppInfo.mission_level.set(paramRedAppInfo.n());
    localAppInfo.exposure_max.set(paramRedAppInfo.p());
    BusinessInfoCheckUpdate.RedDisplayInfo localRedDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
    Object localObject = paramRedAppInfo.o();
    paramRedAppInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    RedTypeInfo localRedTypeInfo;
    if (localObject != null)
    {
      localRedTypeInfo = ((RedDisplayInfo)localObject).b();
      paramRedAppInfo.red_content.set(localRedTypeInfo.getRedContent());
      paramRedAppInfo.red_desc.set(localRedTypeInfo.getRedDesc());
      paramRedAppInfo.red_priority.set(localRedTypeInfo.getRedPriority());
      paramRedAppInfo.red_type.set(localRedTypeInfo.getRedType());
    }
    localRedDisplayInfo.tab_display_info.set(paramRedAppInfo);
    paramRedAppInfo = new ArrayList();
    if (localObject != null)
    {
      localObject = ((RedDisplayInfo)localObject).a();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          localRedTypeInfo = (RedTypeInfo)((List)localObject).get(i);
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo1.red_content.set(localRedTypeInfo.getRedContent());
          localRedTypeInfo1.red_desc.set(localRedTypeInfo.getRedDesc());
          localRedTypeInfo1.red_priority.set(localRedTypeInfo.getRedPriority());
          localRedTypeInfo1.red_type.set(localRedTypeInfo.getRedType());
          paramRedAppInfo.add(localRedTypeInfo1);
          i += 1;
        }
      }
    }
    localRedDisplayInfo.red_type_info.set(paramRedAppInfo);
    localAppInfo.red_display_info.set(localRedDisplayInfo);
    return localAppInfo;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if ((paramString1 == null) && (paramString2 == null)) {
      return false;
    }
    int i = b(paramString1, "8.8.17");
    int j = b("8.8.17", paramString2);
    if ((i != -1) && (i != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((j != 1) && (j != 0) && (!paramString2.equals("0.0.0"))) {
      j = 0;
    } else {
      j = 1;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return 0;
    }
    if ((paramString1 != null) && (paramString2 == null)) {
      return 1;
    }
    if ((paramString1 == null) && (paramString2 != null)) {
      return -1;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int i = 0;
    for (;;)
    {
      int j;
      int k;
      try
      {
        if ((i < arrayOfString1.length) && (i < arrayOfString2.length))
        {
          j = Integer.parseInt(arrayOfString1[i]);
          k = Integer.parseInt(arrayOfString2[i]);
          if (j < k) {
            return -1;
          }
        }
        else
        {
          if (arrayOfString1.length > i) {
            return 1;
          }
          j = arrayOfString2.length;
          if (j > i) {
            return -1;
          }
          return 0;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return paramString1.compareTo(paramString2);
      }
      if (j > k) {
        return 1;
      }
      i += 1;
    }
  }
  
  public static String b(@NonNull BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramAppInfo = paramAppInfo.buffer.get();
    if (!TextUtils.isEmpty(paramAppInfo)) {
      try
      {
        paramAppInfo = new JSONObject(paramAppInfo).getString("ad_id");
        return paramAppInfo;
      }
      catch (Exception paramAppInfo)
      {
        QLog.e("RedTouchUtilsgetAdIdFromAppInfo error", 1, paramAppInfo, new Object[0]);
      }
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchUtils
 * JD-Core Version:    0.7.0.1
 */