package com.tencent.mobileqq.medalwall;

import SummaryCard.TMedalWallInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import anri;
import anvk;
import awux;
import axqj;
import aymd;
import bhbx;
import bhhr;
import bkys;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;

public class MedalWallMng
  implements Handler.Callback, Manager
{
  public static int a;
  protected static final String a;
  public static int b;
  public static final String b;
  public static int c;
  public static int d;
  public static int e;
  public static int f = 6;
  public static int g = 7;
  protected final SparseArray<MedalInfo> a;
  protected final bkys a;
  protected QQAppInterface a;
  protected final ArrayList<awux> a;
  protected boolean a;
  private boolean b;
  private String c;
  private String d;
  private String e;
  protected int h;
  protected int i;
  private int j = -2147483648;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "tencent/MobileQQ/medal/";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    jdField_e_of_type_Int = 5;
  }
  
  public MedalWallMng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Bkys = new bkys(ThreadManager.getSubThreadLooper(), this);
    this.h = 0;
  }
  
  public static String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("validateUrl>>> url=%s", new Object[] { paramString }));
    }
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.startsWith("https://"));
      paramString = "https://" + paramString;
      str = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("MedalWallMng", 2, String.format("validateUrl<<< url=%s", new Object[] { paramString }));
    return paramString;
  }
  
  private void a(awux paramawux)
  {
    if ((paramawux == null) || (paramawux.jdField_a_of_type_ComTencentMobileqqDataMedalInfo == null)) {}
    while (!FileUtils.fileExistsAndNotEmpty(paramawux.jdField_b_of_type_JavaLangString)) {
      return;
    }
    try
    {
      Resources localResources = BaseApplicationImpl.getApplication().getResources();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int k = localResources.getDimensionPixelSize(2131298276);
      localURLDrawableOptions.mRequestWidth = k;
      localURLDrawableOptions.mRequestHeight = k;
      URLDrawable.getDrawable(new File(paramawux.jdField_b_of_type_JavaLangString), localURLDrawableOptions).startDownload(true);
      return;
    }
    catch (Exception paramawux)
    {
      QLog.e("MedalWallMng", 1, "tryPreloadImg fail.", paramawux);
    }
  }
  
  public static void a(MedalInfo paramMedalInfo, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalInfo[");
    paramStringBuilder.append("iId: ").append(paramMedalInfo.iId).append(",");
    paramStringBuilder.append("iType: ").append(paramMedalInfo.iType).append(",");
    paramStringBuilder.append("iLevel: ").append(paramMedalInfo.iLevel).append(",");
    paramStringBuilder.append("iLevelCount: ").append(paramMedalInfo.iLevelCount).append(",");
    paramStringBuilder.append("lEndTime: ").append(paramMedalInfo.lEndTime).append(",");
    paramStringBuilder.append("iUnreadLevel1: ").append(paramMedalInfo.iUnreadLevel1).append(",");
    paramStringBuilder.append("iUnreadLevel2: ").append(paramMedalInfo.iUnreadLevel2).append(",");
    paramStringBuilder.append("iUnreadLevel3: ").append(paramMedalInfo.iUnreadLevel3).append(",");
    paramStringBuilder.append("iNoProgress: ").append(paramMedalInfo.iNoProgress).append(",");
    paramStringBuilder.append("strName: ").append(paramMedalInfo.strName);
    paramStringBuilder.append("] ");
  }
  
  public static void a(MedalID paramMedalID, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalID[");
    paramStringBuilder.append("id: ").append(paramMedalID.jdField_a_of_type_Int).append(",");
    paramStringBuilder.append("level: ").append(paramMedalID.jdField_b_of_type_Int);
    paramStringBuilder.append("] ");
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCheckResFlag value: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4);
    if (((SharedPreferences)localObject).getInt("MEDAL_CHECK_RES_STATE", 0) != paramInt) {
      ((SharedPreferences)localObject).edit().putInt("MEDAL_CHECK_RES_STATE", paramInt).apply();
    }
  }
  
  private boolean b()
  {
    boolean bool;
    if (bhhr.X(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != 1)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    while ((((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).medalSwitchDisable) || (bhbx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      return true;
      bool = false;
      break;
    }
    return false;
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        if (!QLog.isColorLevel()) {
          break label223;
        }
        StringBuilder localStringBuilder = new StringBuilder(200);
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().query(MedalInfo.class);
        if ((localObject4 != null) && (((List)localObject4).size() > 0)) {
          synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.clear();
            localObject4 = ((List)localObject4).iterator();
            if (((Iterator)localObject4).hasNext())
            {
              MedalInfo localMedalInfo = (MedalInfo)((Iterator)localObject4).next();
              if (localMedalInfo == null) {
                continue;
              }
              this.jdField_a_of_type_AndroidUtilSparseArray.put(localMedalInfo.iId, localMedalInfo);
              if ((!QLog.isColorLevel()) || (localStringBuilder == null)) {
                continue;
              }
              a(localMedalInfo, localStringBuilder);
              localStringBuilder.append("\r\n");
            }
          }
        }
      }
      finally {}
      this.jdField_a_of_type_Boolean = true;
      if ((QLog.isColorLevel()) && (localObject2 != null))
      {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "init size: %d \r\n{%s}", new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.size()), localObject2.toString() }));
        continue;
        label223:
        Object localObject3 = null;
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckMedalRes checkedCount: %d", new Object[] { Integer.valueOf(this.h) }));
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.h <= 0) {
        break label190;
      }
      k = this.h - 1;
      break label178;
      if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        awux localawux1 = (awux)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if ((localawux1 == null) || (localawux1.jdField_a_of_type_Boolean))
        {
          this.h = (k + 1);
        }
        else if (localawux1.a())
        {
          this.h = (k + 1);
          a(localawux1);
        }
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        ThreadManager.post(new MedalWallMng.DownloadResTask(this, localawux2), 5, null, false);
        return;
      }
      if (this.i > 0)
      {
        b(2);
        return;
      }
      b(1);
      return;
    }
    for (;;)
    {
      label178:
      Object localObject = null;
      break;
      k += 1;
      break;
      label190:
      k = 0;
    }
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "doCheckForLogin");
    }
    this.jdField_a_of_type_Bkys.removeMessages(3);
    Object localObject = (aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((aymd)localObject).a(10015);
    boolean bool = ((aymd)localObject).b(localRedTouchItem);
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("doCheckForLogin item=%s hasMedalRedPoint=%s", new Object[] { localRedTouchItem, Boolean.valueOf(bool) }));
    }
    int k;
    if (bool)
    {
      localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
      k = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4).getInt("MEDAL_CHECK_RES_STATE", 0);
      if (k == 2) {
        b();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, String.format("doCheckForLogin hasMedalRedPoint=%s, flag=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(k) }));
      }
      return;
      c();
      continue;
      b(0);
      k = 0;
    }
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    this.jdField_c_of_type_JavaLangString = localSharedPreferences.getString("hostUrl", "");
    this.jdField_d_of_type_JavaLangString = localSharedPreferences.getString("guestUrl", "");
    this.jdField_e_of_type_JavaLangString = localSharedPreferences.getString("shareUrl", "");
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,local hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString }));
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    }
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    }
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = "https://ti.qq.com/qqmedal2/share.html?_wv=16777217&_wwv=4&_bid=2450";
    }
  }
  
  public Card a(TMedalWallInfo paramTMedalWallInfo, boolean paramBoolean)
  {
    int m = 0;
    int k = 0;
    Object localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
    int i3 = 0;
    for (;;)
    {
      Object localObject2;
      int i2;
      int i1;
      try
      {
        if (i3 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
        {
          localObject2 = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i3);
          if (localObject2 == null) {
            break label528;
          }
          if (((MedalInfo)localObject2).iLevel == 255)
          {
            i2 = k;
            i1 = m;
            if (((MedalInfo)localObject2).iUnreadLevel1 != 1) {
              break label521;
            }
            m += 1;
            break label528;
          }
          i2 = k;
          i1 = m;
          if (((MedalInfo)localObject2).iLevelCount <= 1) {
            break label521;
          }
          int n = m;
          if (((MedalInfo)localObject2).iLevel >= 1)
          {
            n = m;
            if (((MedalInfo)localObject2).iUnreadLevel1 == 1) {
              n = m + 1;
            }
          }
          m = k;
          if (((MedalInfo)localObject2).iLevel >= 2)
          {
            m = k;
            if (((MedalInfo)localObject2).iUnreadLevel2 == 1) {
              m = k + 1;
            }
          }
          i2 = m;
          i1 = n;
          if (((MedalInfo)localObject2).iLevel < 3) {
            break label521;
          }
          i2 = m;
          i1 = n;
          if (((MedalInfo)localObject2).iUnreadLevel3 != 1) {
            break label521;
          }
          k = m + 1;
          m = n;
          break label528;
        }
        localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject2 = ((anvk)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramTMedalWallInfo != null)
        {
          ((Card)localObject2).iMedalCount = paramTMedalWallInfo.iMedalCount;
          if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo needCheck: %s, compute[iNewCount: %d, iUpgradeCount: %d] server[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(paramTMedalWallInfo.iNewCount), Integer.valueOf(paramTMedalWallInfo.iUpgradeCount), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
          }
          if ((paramBoolean) && ((paramTMedalWallInfo.iNewCount > m) || (paramTMedalWallInfo.iUpgradeCount > k)))
          {
            paramTMedalWallInfo.iNewCount = Math.min(paramTMedalWallInfo.iNewCount, m);
            paramTMedalWallInfo.iUpgradeCount = Math.min(paramTMedalWallInfo.iUpgradeCount, k);
          }
          ((Card)localObject2).iNewCount = paramTMedalWallInfo.iNewCount;
          ((Card)localObject2).iUpgradeCount = paramTMedalWallInfo.iUpgradeCount;
          ((anvk)localObject1).a((Card)localObject2);
          return localObject2;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo compute[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
      }
      ((Card)localObject2).iNewCount = Math.min(((Card)localObject2).iNewCount, m);
      ((Card)localObject2).iUpgradeCount = Math.min(((Card)localObject2).iUpgradeCount, k);
      continue;
      label521:
      k = i2;
      m = i1;
      label528:
      i3 += 1;
    }
  }
  
  public MedalInfo a(int paramInt)
  {
    d();
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      MedalInfo localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localMedalInfo;
      if (localMedalInfo == null)
      {
        ??? = new MedalInfo();
        ((MedalInfo)???).iId = paramInt;
        ((MedalInfo)???).iLevel = 0;
        ((MedalInfo)???).iUnreadLevel1 = 0;
        ((MedalInfo)???).iUnreadLevel2 = 0;
        ((MedalInfo)???).iUnreadLevel3 = 0;
      }
      return ???;
    }
  }
  
  public String a()
  {
    if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null)) {
      g();
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public String a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null)) {
      g();
    }
    StringBuilder localStringBuilder;
    if (!paramBoolean)
    {
      localStringBuilder = new StringBuilder(this.jdField_d_of_type_JavaLangString);
      localStringBuilder.append("&tuin=").append(axqj.a(paramString));
    }
    for (paramString = localStringBuilder;; paramString = new StringBuilder(this.jdField_c_of_type_JavaLangString))
    {
      paramString.append("&from=").append(paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "getMedalWallUrl url: %s", new Object[] { paramString }));
      }
      return paramString.toString();
    }
  }
  
  public ArrayList<MedalID> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    Object localObject;
    try
    {
      paramString = paramString.replaceAll("new_medals=", "").replaceAll("update_medals=", "").replaceAll("&", ",").split(",");
      k = 0;
      if (k >= paramString.length) {
        break label136;
      }
      if ((paramString[k] == null) || (paramString[k].isEmpty())) {
        break label338;
      }
      localObject = paramString[k].split("_");
      if (localObject.length != 3) {
        break label338;
      }
      localArrayList.add(new MedalID(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1])));
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "summarycard", paramString);
      }
    }
    label133:
    return localArrayList;
    label136:
    int m = localArrayList.size() - 1;
    label144:
    if (m >= 0)
    {
      paramString = (MedalID)localArrayList.get(m);
      localObject = a(paramString.jdField_a_of_type_Int);
      switch (paramString.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (k != 0)
      {
        localArrayList.remove(m);
        if (QLog.isColorLevel())
        {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "parsePromptParams local read [id: %d , level: %d]", new Object[] { Integer.valueOf(paramString.jdField_a_of_type_Int), Integer.valueOf(paramString.jdField_b_of_type_Int) }));
          break label350;
          if (((MedalInfo)localObject).iUnreadLevel1 != 2) {
            break label357;
          }
          k = 1;
          continue;
          if (((MedalInfo)localObject).iUnreadLevel2 != 2) {
            break label362;
          }
          k = 1;
          continue;
          if (((MedalInfo)localObject).iUnreadLevel3 != 2) {
            break label367;
          }
          k = 1;
          continue;
          k = ((MedalInfo)localObject).iUnreadLevel1;
          if (k == 2)
          {
            k = 1;
            continue;
          }
          k = 0;
          continue;
          label338:
          k += 1;
          break;
          k = 0;
          continue;
        }
      }
      label350:
      m -= 1;
      break label144;
      break label133;
      label357:
      k = 0;
      continue;
      label362:
      k = 0;
      continue;
      label367:
      k = 0;
    }
  }
  
  public void a()
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkForLogin medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!b()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "checkForLogin medal is off!");
    return;
    this.jdField_a_of_type_Bkys.removeMessages(3);
    this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(3, 1000L);
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetMedalStrongReminderConfig value: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  /* Error */
  public void a(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 380	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   10: invokevirtual 386	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 7
    //   15: new 93	java/util/ArrayList
    //   18: dup
    //   19: iconst_5
    //   20: invokespecial 626	java/util/ArrayList:<init>	(I)V
    //   23: astore 6
    //   25: iload_1
    //   26: iconst_2
    //   27: if_icmpne +311 -> 338
    //   30: aload_0
    //   31: getfield 91	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   34: astore 8
    //   36: aload 8
    //   38: monitorenter
    //   39: iconst_0
    //   40: istore_3
    //   41: iload_3
    //   42: aload_0
    //   43: getfield 91	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   46: invokevirtual 425	android/util/SparseArray:size	()I
    //   49: if_icmpge +267 -> 316
    //   52: aload_0
    //   53: getfield 91	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   56: iload_3
    //   57: invokevirtual 520	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   60: checkcast 213	com/tencent/mobileqq/data/MedalInfo
    //   63: astore 9
    //   65: aload 9
    //   67: aload 6
    //   69: invokevirtual 630	com/tencent/mobileqq/data/MedalInfo:putReportInfo	(Ljava/util/ArrayList;)V
    //   72: aload 9
    //   74: invokevirtual 633	com/tencent/mobileqq/data/MedalInfo:setRead	()V
    //   77: aload 9
    //   79: invokevirtual 636	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   82: sipush 1000
    //   85: if_icmpne +13 -> 98
    //   88: aload 7
    //   90: aload 9
    //   92: invokevirtual 640	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   95: goto +472 -> 567
    //   98: aload 9
    //   100: invokevirtual 636	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   103: sipush 1001
    //   106: if_icmpeq +14 -> 120
    //   109: aload 9
    //   111: invokevirtual 636	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   114: sipush 1002
    //   117: if_icmpne +450 -> 567
    //   120: aload 7
    //   122: aload 9
    //   124: invokevirtual 644	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   127: pop
    //   128: goto +439 -> 567
    //   131: astore_2
    //   132: aload 8
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: iconst_0
    //   139: istore_3
    //   140: aload_2
    //   141: invokevirtual 647	java/lang/Throwable:printStackTrace	()V
    //   144: iload_1
    //   145: ifne +322 -> 467
    //   148: aload_0
    //   149: aconst_null
    //   150: iconst_1
    //   151: invokevirtual 649	com/tencent/mobileqq/medalwall/MedalWallMng:a	(LSummaryCard/TMedalWallInfo;Z)Lcom/tencent/mobileqq/data/Card;
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   159: getstatic 461	com/tencent/mobileqq/app/QQManagerFactory:LOCAL_REDTOUCH_MANAGER	I
    //   162: invokevirtual 359	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   165: checkcast 463	aymd
    //   168: astore 7
    //   170: iload_1
    //   171: iconst_1
    //   172: if_icmpeq +8 -> 180
    //   175: iload_1
    //   176: iconst_2
    //   177: if_icmpne +338 -> 515
    //   180: aload 7
    //   182: sipush 10015
    //   185: invokevirtual 651	aymd:a	(I)V
    //   188: aload 7
    //   190: sipush 10016
    //   193: invokevirtual 651	aymd:a	(I)V
    //   196: aload 6
    //   198: invokevirtual 652	java/util/ArrayList:isEmpty	()Z
    //   201: ifne +21 -> 222
    //   204: aload_0
    //   205: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   208: getstatic 657	com/tencent/mobileqq/app/BusinessHandlerFactory:CARD_HANLDER	I
    //   211: invokevirtual 661	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   214: checkcast 663	anri
    //   217: aload 6
    //   219: invokevirtual 665	anri:b	(Ljava/util/ArrayList;)V
    //   222: aload_2
    //   223: ifnull +17 -> 240
    //   226: aload_2
    //   227: getfield 535	com/tencent/mobileqq/data/Card:iNewCount	I
    //   230: ifne +15 -> 245
    //   233: aload_2
    //   234: getfield 536	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   237: ifne +8 -> 245
    //   240: aload_0
    //   241: iconst_0
    //   242: invokespecial 450	com/tencent/mobileqq/medalwall/MedalWallMng:b	(I)V
    //   245: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +67 -> 315
    //   251: invokestatic 289	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   254: astore 6
    //   256: aload_2
    //   257: ifnonnull +287 -> 544
    //   260: iconst_0
    //   261: istore 4
    //   263: aload_2
    //   264: ifnonnull +289 -> 553
    //   267: ldc 120
    //   269: iconst_2
    //   270: aload 6
    //   272: ldc_w 667
    //   275: iconst_4
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: iload_1
    //   282: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: iconst_1
    //   288: iload_3
    //   289: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   292: aastore
    //   293: dup
    //   294: iconst_2
    //   295: iload 4
    //   297: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: aastore
    //   301: dup
    //   302: iconst_3
    //   303: iload 5
    //   305: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: aastore
    //   309: invokestatic 300	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   312: invokestatic 302	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: return
    //   316: aload 8
    //   318: monitorexit
    //   319: aload_0
    //   320: getfield 96	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   323: astore 8
    //   325: aload 8
    //   327: monitorenter
    //   328: aload_0
    //   329: getfield 96	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   332: invokevirtual 668	java/util/ArrayList:clear	()V
    //   335: aload 8
    //   337: monitorexit
    //   338: aload_2
    //   339: instanceof 150
    //   342: ifeq +220 -> 562
    //   345: aload_2
    //   346: checkcast 150	awux
    //   349: astore_2
    //   350: aload_2
    //   351: getfield 153	awux:jdField_a_of_type_ComTencentMobileqqDataMedalInfo	Lcom/tencent/mobileqq/data/MedalInfo;
    //   354: getfield 216	com/tencent/mobileqq/data/MedalInfo:iId	I
    //   357: istore_3
    //   358: aload_2
    //   359: getfield 153	awux:jdField_a_of_type_ComTencentMobileqqDataMedalInfo	Lcom/tencent/mobileqq/data/MedalInfo;
    //   362: astore 8
    //   364: aload 8
    //   366: aload 6
    //   368: invokevirtual 630	com/tencent/mobileqq/data/MedalInfo:putReportInfo	(Ljava/util/ArrayList;)V
    //   371: aload 8
    //   373: invokevirtual 633	com/tencent/mobileqq/data/MedalInfo:setRead	()V
    //   376: aload 8
    //   378: invokevirtual 636	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   381: sipush 1000
    //   384: if_icmpne +40 -> 424
    //   387: aload 7
    //   389: aload 8
    //   391: invokevirtual 640	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   394: aload_0
    //   395: getfield 96	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   398: astore 7
    //   400: aload 7
    //   402: monitorenter
    //   403: aload_0
    //   404: getfield 96	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   407: aload_2
    //   408: invokevirtual 670	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   411: pop
    //   412: aload 7
    //   414: monitorexit
    //   415: goto -271 -> 144
    //   418: astore_2
    //   419: aload 8
    //   421: monitorexit
    //   422: aload_2
    //   423: athrow
    //   424: aload 8
    //   426: invokevirtual 636	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   429: sipush 1001
    //   432: if_icmpeq +14 -> 446
    //   435: aload 8
    //   437: invokevirtual 636	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   440: sipush 1002
    //   443: if_icmpne -49 -> 394
    //   446: aload 7
    //   448: aload 8
    //   450: invokevirtual 644	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   453: pop
    //   454: goto -60 -> 394
    //   457: astore_2
    //   458: goto -318 -> 140
    //   461: astore_2
    //   462: aload 7
    //   464: monitorexit
    //   465: aload_2
    //   466: athrow
    //   467: aload_0
    //   468: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   471: getstatic 355	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   474: invokevirtual 359	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   477: checkcast 361	anvk
    //   480: astore 7
    //   482: aload 7
    //   484: aload_0
    //   485: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   488: invokevirtual 342	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   491: invokevirtual 364	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   494: astore_2
    //   495: aload_2
    //   496: iconst_0
    //   497: putfield 536	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   500: aload_2
    //   501: iconst_0
    //   502: putfield 535	com/tencent/mobileqq/data/Card:iNewCount	I
    //   505: aload 7
    //   507: aload_2
    //   508: invokevirtual 545	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   511: pop
    //   512: goto -357 -> 155
    //   515: aload_2
    //   516: ifnull +17 -> 533
    //   519: aload_2
    //   520: getfield 535	com/tencent/mobileqq/data/Card:iNewCount	I
    //   523: ifne -327 -> 196
    //   526: aload_2
    //   527: getfield 536	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   530: ifne -334 -> 196
    //   533: aload 7
    //   535: sipush 10015
    //   538: invokevirtual 651	aymd:a	(I)V
    //   541: goto -345 -> 196
    //   544: aload_2
    //   545: getfield 535	com/tencent/mobileqq/data/Card:iNewCount	I
    //   548: istore 4
    //   550: goto -287 -> 263
    //   553: aload_2
    //   554: getfield 536	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   557: istore 5
    //   559: goto -292 -> 267
    //   562: iconst_0
    //   563: istore_3
    //   564: goto -149 -> 415
    //   567: iload_3
    //   568: iconst_1
    //   569: iadd
    //   570: istore_3
    //   571: goto -530 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	this	MedalWallMng
    //   0	574	1	paramInt	int
    //   0	574	2	paramObject	Object
    //   40	531	3	k	int
    //   261	288	4	m	int
    //   1	557	5	n	int
    //   23	344	6	localObject1	Object
    //   34	415	8	localObject3	Object
    //   63	60	9	localMedalInfo	MedalInfo
    // Exception table:
    //   from	to	target	type
    //   41	95	131	finally
    //   98	120	131	finally
    //   120	128	131	finally
    //   132	135	131	finally
    //   316	319	131	finally
    //   30	39	137	java/lang/Throwable
    //   135	137	137	java/lang/Throwable
    //   319	328	137	java/lang/Throwable
    //   338	358	137	java/lang/Throwable
    //   422	424	137	java/lang/Throwable
    //   328	338	418	finally
    //   419	422	418	finally
    //   358	394	457	java/lang/Throwable
    //   394	403	457	java/lang/Throwable
    //   424	446	457	java/lang/Throwable
    //   446	454	457	java/lang/Throwable
    //   465	467	457	java/lang/Throwable
    //   403	415	461	finally
    //   462	465	461	finally
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { paramString1, paramString2, paramString3 }));
    }
    if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null)) {
      g();
    }
    if ((bhbx.a(paramString1, this.jdField_c_of_type_JavaLangString)) && (bhbx.a(paramString2, this.jdField_d_of_type_JavaLangString)) && (bhbx.a(paramString3, this.jdField_e_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 4, "onGetConfig, no change return.");
      }
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putString("hostUrl", paramString1);
    localEditor.putString("guestUrl", paramString2);
    localEditor.putString("shareUrl", paramString3);
    localEditor.commit();
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString3;
    if (paramInt != 1) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean, TMedalWallInfo paramTMedalWallInfo, SparseArray<MedalInfo> paramSparseArray)
  {
    d();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(200);
      ((StringBuilder)???).append("onGetSelfNewObtainedMedaInfo isSuc:").append(paramBoolean);
      if (paramTMedalWallInfo != null) {
        ((StringBuilder)???).append(", iMedalCount:").append(paramTMedalWallInfo.iMedalCount).append(", iNewCount:").append(paramTMedalWallInfo.iNewCount).append(", iUpgradeCount:").append(paramTMedalWallInfo.iUpgradeCount);
      }
      if (paramSparseArray != null)
      {
        ((StringBuilder)???).append(", medalInfoArrayList: ").append(paramSparseArray.size());
        k = 0;
        if (k < paramSparseArray.size())
        {
          localObject2 = (MedalInfo)paramSparseArray.valueAt(k);
          if (localObject2 == null) {}
          for (;;)
          {
            k += 1;
            break;
            ((StringBuilder)???).append("\r\n info [id: ").append(((MedalInfo)localObject2).iId).append(", iLevel: ").append(((MedalInfo)localObject2).iLevel).append(", name: ").append(((MedalInfo)localObject2).strName).append(", res: ").append(((MedalInfo)localObject2).strResJson).append("]");
          }
        }
      }
      QLog.i("MedalWallMng", 2, ((StringBuilder)???).toString());
    }
    if (!paramBoolean)
    {
      b(2);
      c();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject3 = this.jdField_a_of_type_AndroidUtilSparseArray;
    int k = 0;
    for (;;)
    {
      MedalInfo localMedalInfo;
      try
      {
        if (k >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
          break label446;
        }
        localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
        if (localMedalInfo == null) {
          break label591;
        }
        if (paramSparseArray != null)
        {
          ??? = (MedalInfo)paramSparseArray.get(localMedalInfo.iId);
          if ((??? != null) || (!localMedalInfo.isUnread())) {
            break label591;
          }
          localMedalInfo.setRead();
          if (localMedalInfo.getStatus() != 1000) {
            break label413;
          }
          ((EntityManager)localObject2).persistOrReplace(localMedalInfo);
          if (!QLog.isColorLevel()) {
            break label591;
          }
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetSelfNewObtainedMedaInfo just local is unread [id: %d, level: %d, name: %s]", new Object[] { Integer.valueOf(localMedalInfo.iId), Integer.valueOf(localMedalInfo.iLevel), localMedalInfo.strName }));
        }
      }
      finally {}
      ??? = null;
      continue;
      label413:
      if ((localMedalInfo.getStatus() == 1001) || (localMedalInfo.getStatus() == 1002))
      {
        ((EntityManager)localObject2).update(localMedalInfo);
        continue;
        label446:
        k = 0;
        while ((paramSparseArray != null) && (k < paramSparseArray.size()))
        {
          localObject3 = (MedalInfo)paramSparseArray.valueAt(k);
          if (localObject3 == null)
          {
            k += 1;
          }
          else
          {
            if (((MedalInfo)localObject3).getStatus() == 1000) {
              ((EntityManager)localObject2).persistOrReplace((Entity)localObject3);
            }
            for (;;)
            {
              synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
              {
                this.jdField_a_of_type_AndroidUtilSparseArray.put(((MedalInfo)localObject3).iId, localObject3);
              }
              if ((((MedalInfo)localObject3).getStatus() == 1001) || (((MedalInfo)localObject3).getStatus() == 1002)) {
                ((EntityManager)localObject2).update((Entity)localObject3);
              }
            }
          }
        }
        a(paramTMedalWallInfo, true);
        b(0);
        break;
        label591:
        k += 1;
      }
    }
  }
  
  public boolean a()
  {
    if (this.j == -2147483648)
    {
      this.j = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 3);
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "isMedalStrongReminderOff value: %s", new Object[] { Integer.valueOf(this.j) }));
      }
    }
    return this.j == 1;
  }
  
  public boolean a(BaseActivity paramBaseActivity, View paramView, int paramInt, Object paramObject)
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkShowMedalGuide medal strong reminder is off!");
      }
    }
    for (;;)
    {
      return false;
      if (this.jdField_b_of_type_Boolean)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkShowMedalGuide isMedalConfigOff: %s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
        return false;
      }
      Object localObject1 = (aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
      Object localObject3 = ((aymd)localObject1).a(10015);
      boolean bool = ((aymd)localObject1).b((RedTouchItem)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, String.format("checkShowMedalGuide item=%s hasMedalRedPoint=%s", new Object[] { localObject3, Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no red point");
        return false;
      }
      localObject3 = null;
      localObject1 = null;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = localObject1;
          awux localawux = (awux)localIterator.next();
          if (localawux != null)
          {
            localObject3 = localObject1;
            if (localawux.jdField_b_of_type_Boolean) {
              break label668;
            }
            localObject3 = localObject1;
            if (!localawux.jdField_a_of_type_Boolean) {
              break label668;
            }
            localObject3 = localObject1;
            if (TextUtils.isEmpty(localawux.jdField_a_of_type_JavaLangString)) {
              break label668;
            }
            localObject3 = localObject1;
            if (TextUtils.isEmpty(localawux.jdField_b_of_type_JavaLangString)) {
              break label668;
            }
            localObject3 = localObject1;
            if (localawux.jdField_a_of_type_Int == 2) {
              break label668;
            }
            localObject3 = localObject1;
            if (localawux.jdField_a_of_type_ComTencentMobileqqDataMedalInfo == null) {
              break label668;
            }
            localObject3 = localawux;
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              bool = localawux.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.isNewer(((awux)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo);
              if (!bool) {
                break label668;
              }
              localObject3 = localawux;
            }
            localObject1 = localObject3;
          }
        }
        if ((localObject1 != null) && (((awux)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null))
        {
          ((awux)localObject1).jdField_b_of_type_Boolean = true;
          localObject3 = ((awux)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo;
          if ((paramObject instanceof Card))
          {
            paramObject = (Card)paramObject;
            if (((MedalInfo)localObject3).iLevel == 255)
            {
              if (((MedalInfo)localObject3).iUnreadLevel1 != 1) {
                break label659;
              }
              k = 0;
              n = 1;
              label399:
              paramObject.iNewCount -= n;
              paramObject.iUpgradeCount -= k;
            }
          }
          else
          {
            paramObject = Message.obtain();
            paramObject.what = 4;
            paramObject.obj = localObject1;
            this.jdField_a_of_type_Bkys.sendMessage(paramObject);
            MedalGuideView.a((awux)localObject1, paramBaseActivity, paramView, paramInt);
            if (QLog.isDevelopLevel()) {
              QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "checkShowMedalGuide [%d, %d,  %s]", new Object[] { Integer.valueOf(((MedalInfo)localObject3).iId), Integer.valueOf(((MedalInfo)localObject3).iLevel), ((MedalInfo)localObject3).strName }));
            }
            return true;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          Object localObject2 = localObject3;
          continue;
          if (((MedalInfo)localObject3).iLevelCount > 1)
          {
            if ((((MedalInfo)localObject3).iLevel >= 1) && (((MedalInfo)localObject3).iUnreadLevel1 == 1)) {}
            for (int m = 1;; m = 0)
            {
              if ((((MedalInfo)localObject3).iLevel >= 2) && (((MedalInfo)localObject3).iUnreadLevel2 == 1)) {}
              for (int i1 = 1;; i1 = 0)
              {
                n = m;
                k = i1;
                if (((MedalInfo)localObject3).iLevel < 3) {
                  break label399;
                }
                n = m;
                k = i1;
                if (((MedalInfo)localObject3).iUnreadLevel3 != 1) {
                  break label399;
                }
                k = i1 + 1;
                n = m;
                break label399;
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.i("MedalWallMng", 4, "checkShowMedalGuide no medal to show");
                return false;
              }
            }
          }
          label659:
          int k = 0;
          int n = 0;
          continue;
          label668:
          localObject3 = localObject2;
        }
      }
    }
  }
  
  public void b()
  {
    boolean bool1 = a();
    boolean bool2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("onGetSelfObtainNewMedalNotice isMedalStrongReminderOff=%s isMedalOff=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    if ((bool1) || (bool2)) {
      return;
    }
    this.jdField_a_of_type_Bkys.removeMessages(3);
    ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).x();
  }
  
  protected void c()
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkMedalWall medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!b()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "checkMedalWall medal is off!");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalWall mIsInit: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    this.jdField_a_of_type_Bkys.removeMessages(3);
    this.jdField_a_of_type_Bkys.removeMessages(1);
    this.h = 0;
    this.i = 0;
    d();
    ArrayList localArrayList = new ArrayList();
    ??? = this.jdField_a_of_type_AndroidUtilSparseArray;
    int k = 0;
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
          {
            MedalInfo localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
            if ((localMedalInfo == null) || (!localMedalInfo.isUnread())) {
              break label255;
            }
            awux localawux = new awux();
            localawux.jdField_a_of_type_ComTencentMobileqqDataMedalInfo = localMedalInfo;
            localArrayList.add(localawux);
          }
        }
        finally {}
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localCollection);
          if (this.h >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          this.jdField_a_of_type_Bkys.sendEmptyMessage(1);
          return;
        }
      }
      label255:
      k += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        e();
        return true;
        awux localawux = (awux)paramMessage.obj;
        if (localawux != null)
        {
          if (localawux.jdField_a_of_type_Int == 2) {
            this.i += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "MSG_DOWNLOAD_RES_RESULT failCount: %d, cost: %d, failCode: %d, url: %s", new Object[] { Integer.valueOf(this.i), Integer.valueOf(paramMessage.arg1), Integer.valueOf(localawux.jdField_b_of_type_Int), localawux.jdField_a_of_type_JavaLangString }));
          }
        }
      } while (this.h >= this.jdField_a_of_type_JavaUtilArrayList.size());
      this.jdField_a_of_type_Bkys.sendEmptyMessage(1);
      return true;
      f();
      return true;
    } while (!(paramMessage.obj instanceof awux));
    a(0, (awux)paramMessage.obj);
    return true;
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng
 * JD-Core Version:    0.7.0.1
 */