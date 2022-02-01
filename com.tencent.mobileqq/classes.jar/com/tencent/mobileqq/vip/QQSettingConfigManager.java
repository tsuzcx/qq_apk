package com.tencent.mobileqq.vip;

import MQQ.MenumItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QQSettingConfigManager
{
  private static Object c = new Object();
  private static QQSettingConfigManager d = null;
  private final Map<Integer, String> a = new HashMap();
  private final Map<Integer, String> b = new HashMap();
  
  private QQSettingConfigManager()
  {
    Object localObject1 = this.a;
    Integer localInteger1 = Integer.valueOf(1);
    ((Map)localObject1).put(localInteger1, "key_svip_item_my_shopping_");
    Object localObject2 = this.a;
    localObject1 = Integer.valueOf(2);
    ((Map)localObject2).put(localObject1, "key_svip_item_my_vip_");
    Object localObject3 = this.a;
    localObject2 = Integer.valueOf(3);
    ((Map)localObject3).put(localObject2, "key_svip_item_makup_");
    Map localMap = this.a;
    localObject3 = Integer.valueOf(4);
    localMap.put(localObject3, "key_svip_item_my_love_zone_");
    localMap = this.a;
    Integer localInteger2 = Integer.valueOf(5);
    localMap.put(localInteger2, "key_svip_item_cu_king_card_");
    this.b.put(localInteger1, "d_qq_shopping");
    this.b.put(localObject1, "d_vip_identity");
    this.b.put(localObject2, "d_decoration");
    this.b.put(localObject3, "d_lovespace");
    this.b.put(localInteger2, "d_vip_card");
  }
  
  public static QQSettingConfigManager a()
  {
    if (d == null) {
      synchronized (c)
      {
        if (d == null) {
          d = new QQSettingConfigManager();
        }
      }
    }
    return d;
  }
  
  private void a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    if (paramInt < 0)
    {
      paramSharedPreferences.edit().putInt(paramString, paramInt).commit();
      if (QLog.isColorLevel())
      {
        paramSharedPreferences = new StringBuilder();
        paramSharedPreferences.append("set sp key:");
        paramSharedPreferences.append(paramString);
        paramSharedPreferences.append(" value=");
        paramSharedPreferences.append(paramInt);
        QLog.d("QSetting.ConfigManager", 1, paramSharedPreferences.toString());
      }
    }
    else
    {
      paramSharedPreferences.edit().putInt(paramString, 0).commit();
      if (QLog.isColorLevel())
      {
        paramSharedPreferences = new StringBuilder();
        paramSharedPreferences.append("set sp key:");
        paramSharedPreferences.append(paramString);
        paramSharedPreferences.append(" value=0");
        QLog.d("QSetting.ConfigManager", 1, paramSharedPreferences.toString());
      }
    }
  }
  
  private void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramSharedPreferences.edit().putString(paramString1, paramString2).commit();
      if (QLog.isColorLevel())
      {
        paramSharedPreferences = new StringBuilder();
        paramSharedPreferences.append("set sp key:");
        paramSharedPreferences.append(paramString1);
        paramSharedPreferences.append(" value=");
        paramSharedPreferences.append(paramString2);
        QLog.d("QSetting.ConfigManager", 1, paramSharedPreferences.toString());
      }
    }
    else
    {
      paramSharedPreferences.edit().putString(paramString1, null).commit();
      if (QLog.isColorLevel())
      {
        paramSharedPreferences = new StringBuilder();
        paramSharedPreferences.append("set sp key:");
        paramSharedPreferences.append(paramString1);
        paramSharedPreferences.append(" value=null");
        QLog.d("QSetting.ConfigManager", 1, paramSharedPreferences.toString());
      }
    }
  }
  
  private void b(@NonNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = paramQQAppInterface.getApp().getSharedPreferences("sp_svip_qqsetting_me", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_svip_items_flag_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localStringBuilder.toString();
    ((SharedPreferences)localObject).edit().putInt(paramQQAppInterface, paramInt).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set sp key:");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append(" value=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QSetting.ConfigManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private int c(@NonNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = paramQQAppInterface.getApp().getSharedPreferences("sp_svip_qqsetting_me", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_svip_items_flag_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramInt = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get sp key:key_svip_items_flag_");
      ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append(" value=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QSetting.ConfigManager", 1, ((StringBuilder)localObject).toString());
    }
    return paramInt;
  }
  
  public int a(Integer paramInteger)
  {
    return 1 << paramInteger.intValue();
  }
  
  public MenumItem a(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString)
  {
    MenumItem localMenumItem = new MenumItem();
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("sp_svip_qqsetting_me", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("key_title_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localMenumItem.title = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("key_icon_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localMenumItem.icon = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("key_jumpurl_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localMenumItem.jumpurl = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("key_user_group_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localMenumItem.user_group = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("get sp itemKey:");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(" icon = ");
      paramQQAppInterface.append(localMenumItem.icon);
      paramQQAppInterface.append(" title = ");
      paramQQAppInterface.append(localMenumItem.title);
      QLog.d("QSetting.ConfigManager", 1, paramQQAppInterface.toString());
    }
    return localMenumItem;
  }
  
  public Map<Integer, MenumItem> a(@NonNull QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    int i = c(paramQQAppInterface, 0);
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((1 << localInteger.intValue() & i) != 0) {
        localHashMap.put(localInteger, a(paramQQAppInterface, (String)this.a.get(localInteger)));
      } else if ((2 != localInteger.intValue()) && (5 != localInteger.intValue())) {
        localHashMap.put(localInteger, null);
      }
    }
    return localHashMap;
  }
  
  public void a(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString, MenumItem paramMenumItem)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("sp_svip_qqsetting_me", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("key_icon_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    a(localSharedPreferences, localStringBuilder.toString(), paramMenumItem.icon);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("key_title_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    a(localSharedPreferences, localStringBuilder.toString(), paramMenumItem.title);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("key_user_group_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    a(localSharedPreferences, localStringBuilder.toString(), paramMenumItem.user_group);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("key_jumpurl_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    a(localSharedPreferences, localStringBuilder.toString(), paramMenumItem.jumpurl);
  }
  
  public void a(@NonNull QQAppInterface paramQQAppInterface, Map<Integer, MenumItem> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = (Integer)localIterator.next();
      Object localObject2 = (String)this.a.get(localObject1);
      int j = i | a((Integer)localObject1);
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        a(paramQQAppInterface, (String)localObject2, (MenumItem)paramMap.get(localObject1));
        i = j;
        if (!TextUtils.isEmpty(((MenumItem)paramMap.get(localObject1)).icon))
        {
          localObject1 = ((MenumItem)paramMap.get(localObject1)).icon;
          localObject2 = URLDrawableHelperConstants.a;
          VasApngUtil.getApngURLDrawable((String)localObject1, new int[] { 1 }, (Drawable)localObject2, null, null);
          i = j;
        }
      }
    }
    b(paramQQAppInterface, i);
  }
  
  public boolean a(@NonNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = c(paramQQAppInterface, 0);
    if ((4 == paramInt) && ((i & 0x4) == 0)) {
      return false;
    }
    if ((32 == paramInt) && ((i & 0x20) == 0)) {
      return false;
    }
    paramQQAppInterface = this.a.keySet().iterator();
    while (paramQQAppInterface.hasNext()) {
      if (a((Integer)paramQQAppInterface.next()) == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public String b(Integer paramInteger)
  {
    Object localObject = (String)this.b.get(paramInteger);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("注册表 : QQSettingConfigManager.jceIDWithItemIdMap : itemId ");
      ((StringBuilder)localObject).append(paramInteger);
      ((StringBuilder)localObject).append("不存在");
      QLog.d("QSetting.ConfigManager", 1, ((StringBuilder)localObject).toString());
      return "";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.QQSettingConfigManager
 * JD-Core Version:    0.7.0.1
 */