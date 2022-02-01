package com.tencent.mobileqq.vip;

import MQQ.MenumItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QQSettingConfigManager
{
  private static QQSettingConfigManager jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager = null;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private final Map<Integer, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Map<Integer, Integer> b = new HashMap();
  
  private QQSettingConfigManager()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), "key_svip_item_my_shopping_");
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), "key_svip_item_my_vip_");
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), "key_svip_item_makup_");
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), "key_svip_item_my_love_zone_");
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), "key_svip_item_cu_king_card_");
    this.b.put(Integer.valueOf(1), Integer.valueOf(12));
    this.b.put(Integer.valueOf(2), Integer.valueOf(1));
    this.b.put(Integer.valueOf(3), Integer.valueOf(6));
    this.b.put(Integer.valueOf(4), Integer.valueOf(7));
    this.b.put(Integer.valueOf(5), Integer.valueOf(13));
  }
  
  private int a(@NonNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramInt = paramQQAppInterface.getApp().getSharedPreferences("sp_svip_qqsetting_me", 0).getInt("key_svip_items_flag_" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QSetting.ConfigManager", 1, "get sp key:key_svip_items_flag_" + paramQQAppInterface.getCurrentAccountUin() + " value=" + paramInt);
    }
    return paramInt;
  }
  
  public static QQSettingConfigManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager == null) {
        jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager = new QQSettingConfigManager();
      }
      return jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager;
    }
  }
  
  private void a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    if (paramInt < 0)
    {
      paramSharedPreferences.edit().putInt(paramString, paramInt).commit();
      if (QLog.isColorLevel()) {
        QLog.d("QSetting.ConfigManager", 1, "set sp key:" + paramString + " value=" + paramInt);
      }
    }
    do
    {
      return;
      paramSharedPreferences.edit().putInt(paramString, 0).commit();
    } while (!QLog.isColorLevel());
    QLog.d("QSetting.ConfigManager", 1, "set sp key:" + paramString + " value=0");
  }
  
  private void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(paramString2)) {
          break;
        }
        paramSharedPreferences.edit().putString(paramString1, paramString2).commit();
      } while (!QLog.isColorLevel());
      QLog.d("QSetting.ConfigManager", 1, "set sp key:" + paramString1 + " value=" + paramString2);
      return;
      paramSharedPreferences.edit().putString(paramString1, null).commit();
    } while (!QLog.isColorLevel());
    QLog.d("QSetting.ConfigManager", 1, "set sp key:" + paramString1 + " value=null");
  }
  
  private void a(@NonNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("sp_svip_qqsetting_me", 0);
    paramQQAppInterface = "key_svip_items_flag_" + paramQQAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putInt(paramQQAppInterface, paramInt).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QSetting.ConfigManager", 1, "set sp key:" + paramQQAppInterface + " value=" + paramInt);
    }
  }
  
  public int a(Integer paramInteger)
  {
    return 1 << paramInteger.intValue();
  }
  
  public MenumItem a(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString)
  {
    MenumItem localMenumItem = new MenumItem();
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("sp_svip_qqsetting_me", 0);
    localMenumItem.title = localSharedPreferences.getString(paramString + "key_title_" + paramQQAppInterface.getCurrentAccountUin(), "");
    localMenumItem.icon = localSharedPreferences.getString(paramString + "key_icon_" + paramQQAppInterface.getCurrentAccountUin(), "");
    localMenumItem.jumpurl = localSharedPreferences.getString(paramString + "key_jumpurl_" + paramQQAppInterface.getCurrentAccountUin(), "");
    localMenumItem.user_group = localSharedPreferences.getInt(paramString + "key_user_group_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("QSetting.ConfigManager", 1, "get sp itemKey:" + paramString + " icon = " + localMenumItem.icon + " title = " + localMenumItem.title);
    }
    return localMenumItem;
  }
  
  public Map<Integer, MenumItem> a(@NonNull QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    int i = a(paramQQAppInterface, 0);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((1 << localInteger.intValue() & i) != 0) {
        localHashMap.put(localInteger, a(paramQQAppInterface, (String)this.jdField_a_of_type_JavaUtilMap.get(localInteger)));
      } else if ((2 != localInteger.intValue()) && (5 != localInteger.intValue())) {
        localHashMap.put(localInteger, null);
      }
    }
    return localHashMap;
  }
  
  public void a(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString, MenumItem paramMenumItem)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("sp_svip_qqsetting_me", 0);
    a(localSharedPreferences, paramString + "key_icon_" + paramQQAppInterface.getCurrentAccountUin(), paramMenumItem.icon);
    a(localSharedPreferences, paramString + "key_title_" + paramQQAppInterface.getCurrentAccountUin(), paramMenumItem.title);
    a(localSharedPreferences, paramString + "key_user_group_" + paramQQAppInterface.getCurrentAccountUin(), paramMenumItem.user_group);
    a(localSharedPreferences, paramString + "key_jumpurl_" + paramQQAppInterface.getCurrentAccountUin(), paramMenumItem.jumpurl);
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
      Object localObject2 = (String)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
      int j = i | a((Integer)localObject1);
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        a(paramQQAppInterface, (String)localObject2, (MenumItem)paramMap.get(localObject1));
        i = j;
        if (!TextUtils.isEmpty(((MenumItem)paramMap.get(localObject1)).icon))
        {
          localObject1 = ((MenumItem)paramMap.get(localObject1)).icon;
          localObject2 = URLDrawableHelper.TRANSPARENT;
          VasApngUtil.getApngURLDrawable((String)localObject1, new int[] { 1 }, (Drawable)localObject2, null, null);
          i = j;
        }
      }
    }
    a(paramQQAppInterface, i);
  }
  
  public boolean a(@NonNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = a(paramQQAppInterface, 0);
    if ((4 == paramInt) && ((i & 0x4) == 0)) {
      return false;
    }
    if ((32 == paramInt) && ((i & 0x20) == 0)) {
      return false;
    }
    paramQQAppInterface = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (paramQQAppInterface.hasNext()) {
      if (a((Integer)paramQQAppInterface.next()) == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public int b(Integer paramInteger)
  {
    Integer localInteger = (Integer)this.b.get(paramInteger);
    if (localInteger == null)
    {
      QLog.d("QSetting.ConfigManager", 1, "注册表 : QQSettingConfigManager.jceIDWithItemIdMap : itemId " + paramInteger + "不存在");
      return -1;
    }
    return localInteger.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.QQSettingConfigManager
 * JD-Core Version:    0.7.0.1
 */