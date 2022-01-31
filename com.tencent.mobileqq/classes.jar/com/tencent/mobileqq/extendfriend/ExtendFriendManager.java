package com.tencent.mobileqq.extendfriend;

import acpm;
import acpn;
import acpo;
import acpp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.CacheData;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtendFriendManager
  implements ExtendFriendResourceDownloader.ResourceDownloaderListener, Manager
{
  public static ExtendFriendSquareFragment.CacheData a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new acpm(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendManager.ExtendFriendConfig jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver = new acpn(this);
  private ExtendFriendResourceDownloader jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ExtendFriendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader = new ExtendFriendResourceDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a(this);
    }
  }
  
  private ExtendFriendManager.ExtendFriendConfig a(String paramString)
  {
    ExtendFriendManager.ExtendFriendConfig localExtendFriendConfig = new ExtendFriendManager.ExtendFriendConfig(this);
    try
    {
      paramString = new JSONObject(paramString);
      localExtendFriendConfig.jdField_a_of_type_JavaLangString = paramString.optString("contactEntranceTitle");
      localExtendFriendConfig.jdField_b_of_type_JavaLangString = paramString.optString("contactEntranceLine1");
      localExtendFriendConfig.jdField_c_of_type_JavaLangString = paramString.optString("contactEntranceLine2");
      localExtendFriendConfig.jdField_d_of_type_JavaLangString = paramString.optString("addEntranceTitle");
      localExtendFriendConfig.jdField_e_of_type_JavaLangString = paramString.optString("addEntranceLine1");
      localExtendFriendConfig.jdField_a_of_type_Int = paramString.optInt("maxPlayers");
      localExtendFriendConfig.jdField_b_of_type_Int = paramString.optInt("minPlayers");
      localExtendFriendConfig.jdField_c_of_type_Int = paramString.optInt("voiceMaxLength");
      localExtendFriendConfig.jdField_d_of_type_Int = paramString.optInt("maxSlipTimes");
      localExtendFriendConfig.jdField_e_of_type_Int = paramString.optInt("redisplayInterval");
      localExtendFriendConfig.jdField_f_of_type_JavaLangString = paramString.optString("defaultDecleration");
      localExtendFriendConfig.jdField_f_of_type_Int = paramString.optInt("declerationMinLen");
      localExtendFriendConfig.jdField_g_of_type_Int = paramString.optInt("isExpandEntranceOnTop");
      localExtendFriendConfig.jdField_g_of_type_JavaLangString = paramString.optString("resourceURL");
      localExtendFriendConfig.jdField_h_of_type_JavaLangString = paramString.optString("resourceMD5");
      localExtendFriendConfig.jdField_h_of_type_Int = paramString.optInt("isShowGroup");
      return localExtendFriendConfig;
    }
    catch (JSONException paramString)
    {
      QLog.e("ExtendFriendManager", 2, "parseConfig fail.", paramString);
    }
    return null;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s mDownloader=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig, this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig.jdField_h_of_type_JavaLangString);
      if (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a();
        b(false);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
        }
        return;
        b(true);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ExtendFriendManager", 1, "checkToDownloadResource fail.", localException);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if (localCard != null)
        {
          if (TextUtils.isEmpty(localCard.declaration)) {
            continue;
          }
          bool1 = true;
          boolean bool2 = localCard.isShowCard;
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData profileComplete=%s showCard=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          if (jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment$CacheData != null)
          {
            jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment$CacheData.b = bool1;
            jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment$CacheData.c = bool2;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        QLog.e("ExtendFriendManager", 1, "updateSwitchInCacheData fail.", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment$CacheData }));
      }
      return;
      bool1 = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(128)).a(5, true, Boolean.valueOf(paramBoolean));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig.jdField_a_of_type_Int <= 0)) {
        break label66;
      }
    }
    label66:
    for (this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig.jdField_b_of_type_Int + new Random().nextInt(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig.jdField_b_of_type_Int));; this.jdField_a_of_type_Int = new Random().nextInt(10000000)) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_Long = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config").getLong("sp_extend_friend_last_vanish", 0L);
    }
    return this.jdField_a_of_type_Long;
  }
  
  public ExtendFriendManager.ExtendFriendConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig = a(str);
        ThreadManager.getSubThreadHandler().post(new acpo(this));
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig;
  }
  
  public String a()
  {
    int k = 0;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      String str = String.valueOf(a());
      int i = str.length();
      int m = str.length() / 3 + i;
      int n = str.length() % 3;
      i = n;
      int j = m;
      if (n == 0)
      {
        i = n + 3;
        j = m - 1;
      }
      char[] arrayOfChar = new char[j];
      m = 0;
      j = k;
      k = i;
      i = m;
      if (i < arrayOfChar.length)
      {
        if (i == k)
        {
          k += 4;
          arrayOfChar[i] = ',';
          j += 1;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfChar[i] = str.charAt(i - j);
        }
      }
      this.jdField_a_of_type_JavaLangString = new String(arrayOfChar);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config").edit().putInt("sp_extend_friend_vanish_combo", paramInt).apply();
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config").edit().putLong("sp_extend_friend_last_vanish", paramLong).apply();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager$ExtendFriendConfig = a(paramString);
    ThreadManager.getSubThreadHandler().post(new acpp(this));
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("onResourceDownloadComplete mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.add(6, -1);
    Date localDate = new Date(a());
    return localCalendar.getTime().getDate() == localDate.getDate();
  }
  
  public int b()
  {
    if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_b_of_type_Int = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config").getInt("sp_extend_friend_vanish_combo", 0);
    }
    return this.jdField_b_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(paramBoolean);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.b();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a(null);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader = null;
      this.jdField_a_of_type_Boolean = false;
    }
    jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment$CacheData = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager
 * JD-Core Version:    0.7.0.1
 */