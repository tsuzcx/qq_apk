package com.tencent.mobileqq.medalwall;

import SummaryCard.TMedalWallInfo;
import aeqn;
import alpk;
import alto;
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
import aubj;
import auwx;
import avsm;
import awge;
import awgf;
import awgg;
import ayzl;
import bdeu;
import bdhb;
import bdne;
import bhtd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageForMedalNews;
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
  protected final bhtd a;
  protected QQAppInterface a;
  protected final ArrayList<aubj> a;
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
    this.jdField_a_of_type_Bhtd = new bhtd(ThreadManager.getSubThreadLooper(), this);
    this.h = 0;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.startsWith("http://")) {
      return paramString;
    }
    return "http://" + paramString;
  }
  
  private void a(aubj paramaubj)
  {
    if ((paramaubj == null) || (paramaubj.jdField_a_of_type_ComTencentMobileqqDataMedalInfo == null)) {}
    while (!bdhb.b(paramaubj.jdField_b_of_type_JavaLangString)) {
      return;
    }
    try
    {
      Resources localResources = BaseApplicationImpl.getApplication().getResources();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int k = localResources.getDimensionPixelSize(2131298113);
      localURLDrawableOptions.mRequestWidth = k;
      localURLDrawableOptions.mRequestHeight = k;
      URLDrawable.getDrawable(new File(paramaubj.jdField_b_of_type_JavaLangString), localURLDrawableOptions).startDownload(true);
      return;
    }
    catch (Exception paramaubj)
    {
      QLog.e("MedalWallMng", 1, "tryPreloadImg fail.", paramaubj);
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
    if (bdne.W(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != 1)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    while ((((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).medalSwitchDisable) || (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
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
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(MedalInfo.class);
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
        aubj localaubj1 = (aubj)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if ((localaubj1 == null) || (localaubj1.jdField_a_of_type_Boolean))
        {
          this.h = (k + 1);
        }
        else if (localaubj1.a())
        {
          this.h = (k + 1);
          a(localaubj1);
        }
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        ThreadManager.post(new MedalWallMng.DownloadResTask(this, localaubj2), 5, null, false);
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
    this.jdField_a_of_type_Bhtd.removeMessages(3);
    Object localObject = (avsm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    boolean bool;
    int k;
    if (((avsm)localObject).a(((avsm)localObject).a(10015), false))
    {
      bool = true;
      if (!bool) {
        break label167;
      }
      localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
      k = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4).getInt("MEDAL_CHECK_RES_STATE", 0);
      if (k != 2) {
        break label160;
      }
      b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckForLogin hasRP: %s, flag: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(k) }));
      }
      return;
      bool = false;
      break;
      label160:
      c();
      continue;
      label167:
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
            break label527;
          }
          if (((MedalInfo)localObject2).iLevel == 255)
          {
            i2 = k;
            i1 = m;
            if (((MedalInfo)localObject2).iUnreadLevel1 != 1) {
              break label520;
            }
            m += 1;
            break label527;
          }
          i2 = k;
          i1 = m;
          if (((MedalInfo)localObject2).iLevelCount <= 1) {
            break label520;
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
            break label520;
          }
          i2 = m;
          i1 = n;
          if (((MedalInfo)localObject2).iUnreadLevel3 != 1) {
            break label520;
          }
          k = m + 1;
          m = n;
          break label527;
        }
        localObject1 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localObject2 = ((alto)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
          ((alto)localObject1).a((Card)localObject2);
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
      label520:
      k = i2;
      m = i1;
      label527:
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
      localStringBuilder.append("&tuin=").append(auwx.a(paramString));
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
    this.jdField_a_of_type_Bhtd.removeMessages(3);
    this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(3, 1000L);
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
    //   7: invokevirtual 364	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawgg;
    //   10: invokevirtual 370	awgg:createEntityManager	()Lawgf;
    //   13: astore 7
    //   15: new 93	java/util/ArrayList
    //   18: dup
    //   19: iconst_5
    //   20: invokespecial 609	java/util/ArrayList:<init>	(I)V
    //   23: astore 6
    //   25: iload_1
    //   26: iconst_2
    //   27: if_icmpne +309 -> 336
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
    //   46: invokevirtual 408	android/util/SparseArray:size	()I
    //   49: if_icmpge +265 -> 314
    //   52: aload_0
    //   53: getfield 91	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   56: iload_3
    //   57: invokevirtual 501	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   60: checkcast 197	com/tencent/mobileqq/data/MedalInfo
    //   63: astore 9
    //   65: aload 9
    //   67: aload 6
    //   69: invokevirtual 613	com/tencent/mobileqq/data/MedalInfo:putReportInfo	(Ljava/util/ArrayList;)V
    //   72: aload 9
    //   74: invokevirtual 616	com/tencent/mobileqq/data/MedalInfo:setRead	()V
    //   77: aload 9
    //   79: invokevirtual 619	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   82: sipush 1000
    //   85: if_icmpne +13 -> 98
    //   88: aload 7
    //   90: aload 9
    //   92: invokevirtual 622	awgf:b	(Lawge;)V
    //   95: goto +469 -> 564
    //   98: aload 9
    //   100: invokevirtual 619	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   103: sipush 1001
    //   106: if_icmpeq +14 -> 120
    //   109: aload 9
    //   111: invokevirtual 619	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   114: sipush 1002
    //   117: if_icmpne +447 -> 564
    //   120: aload 7
    //   122: aload 9
    //   124: invokevirtual 625	awgf:a	(Lawge;)Z
    //   127: pop
    //   128: goto +436 -> 564
    //   131: astore_2
    //   132: aload 8
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: iconst_0
    //   139: istore_3
    //   140: aload_2
    //   141: invokevirtual 628	java/lang/Throwable:printStackTrace	()V
    //   144: iload_1
    //   145: ifne +320 -> 465
    //   148: aload_0
    //   149: aconst_null
    //   150: iconst_1
    //   151: invokevirtual 630	com/tencent/mobileqq/medalwall/MedalWallMng:a	(LSummaryCard/TMedalWallInfo;Z)Lcom/tencent/mobileqq/data/Card;
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   159: sipush 160
    //   162: invokevirtual 344	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   165: checkcast 443	avsm
    //   168: astore 7
    //   170: iload_1
    //   171: iconst_1
    //   172: if_icmpeq +8 -> 180
    //   175: iload_1
    //   176: iconst_2
    //   177: if_icmpne +335 -> 512
    //   180: aload 7
    //   182: sipush 10015
    //   185: invokevirtual 632	avsm:a	(I)V
    //   188: aload 7
    //   190: sipush 10016
    //   193: invokevirtual 632	avsm:a	(I)V
    //   196: aload 6
    //   198: invokevirtual 633	java/util/ArrayList:isEmpty	()Z
    //   201: ifne +19 -> 220
    //   204: aload_0
    //   205: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   208: iconst_2
    //   209: invokevirtual 636	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   212: checkcast 638	alpk
    //   215: aload 6
    //   217: invokevirtual 640	alpk:b	(Ljava/util/ArrayList;)V
    //   220: aload_2
    //   221: ifnull +17 -> 238
    //   224: aload_2
    //   225: getfield 516	com/tencent/mobileqq/data/Card:iNewCount	I
    //   228: ifne +15 -> 243
    //   231: aload_2
    //   232: getfield 517	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   235: ifne +8 -> 243
    //   238: aload_0
    //   239: iconst_0
    //   240: invokespecial 433	com/tencent/mobileqq/medalwall/MedalWallMng:b	(I)V
    //   243: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +67 -> 313
    //   249: invokestatic 277	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   252: astore 6
    //   254: aload_2
    //   255: ifnonnull +286 -> 541
    //   258: iconst_0
    //   259: istore 4
    //   261: aload_2
    //   262: ifnonnull +288 -> 550
    //   265: ldc 183
    //   267: iconst_2
    //   268: aload 6
    //   270: ldc_w 642
    //   273: iconst_4
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: iload_1
    //   280: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: iload_3
    //   287: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: iload 4
    //   295: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: aastore
    //   299: dup
    //   300: iconst_3
    //   301: iload 5
    //   303: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: aastore
    //   307: invokestatic 289	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   310: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: return
    //   314: aload 8
    //   316: monitorexit
    //   317: aload_0
    //   318: getfield 96	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   321: astore 8
    //   323: aload 8
    //   325: monitorenter
    //   326: aload_0
    //   327: getfield 96	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   330: invokevirtual 643	java/util/ArrayList:clear	()V
    //   333: aload 8
    //   335: monitorexit
    //   336: aload_2
    //   337: instanceof 131
    //   340: ifeq +219 -> 559
    //   343: aload_2
    //   344: checkcast 131	aubj
    //   347: astore_2
    //   348: aload_2
    //   349: getfield 134	aubj:jdField_a_of_type_ComTencentMobileqqDataMedalInfo	Lcom/tencent/mobileqq/data/MedalInfo;
    //   352: getfield 200	com/tencent/mobileqq/data/MedalInfo:iId	I
    //   355: istore_3
    //   356: aload_2
    //   357: getfield 134	aubj:jdField_a_of_type_ComTencentMobileqqDataMedalInfo	Lcom/tencent/mobileqq/data/MedalInfo;
    //   360: astore 8
    //   362: aload 8
    //   364: aload 6
    //   366: invokevirtual 613	com/tencent/mobileqq/data/MedalInfo:putReportInfo	(Ljava/util/ArrayList;)V
    //   369: aload 8
    //   371: invokevirtual 616	com/tencent/mobileqq/data/MedalInfo:setRead	()V
    //   374: aload 8
    //   376: invokevirtual 619	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   379: sipush 1000
    //   382: if_icmpne +40 -> 422
    //   385: aload 7
    //   387: aload 8
    //   389: invokevirtual 622	awgf:b	(Lawge;)V
    //   392: aload_0
    //   393: getfield 96	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   396: astore 7
    //   398: aload 7
    //   400: monitorenter
    //   401: aload_0
    //   402: getfield 96	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   405: aload_2
    //   406: invokevirtual 645	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   409: pop
    //   410: aload 7
    //   412: monitorexit
    //   413: goto -269 -> 144
    //   416: astore_2
    //   417: aload 8
    //   419: monitorexit
    //   420: aload_2
    //   421: athrow
    //   422: aload 8
    //   424: invokevirtual 619	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   427: sipush 1001
    //   430: if_icmpeq +14 -> 444
    //   433: aload 8
    //   435: invokevirtual 619	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   438: sipush 1002
    //   441: if_icmpne -49 -> 392
    //   444: aload 7
    //   446: aload 8
    //   448: invokevirtual 625	awgf:a	(Lawge;)Z
    //   451: pop
    //   452: goto -60 -> 392
    //   455: astore_2
    //   456: goto -316 -> 140
    //   459: astore_2
    //   460: aload 7
    //   462: monitorexit
    //   463: aload_2
    //   464: athrow
    //   465: aload_0
    //   466: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   469: bipush 51
    //   471: invokevirtual 344	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   474: checkcast 346	alto
    //   477: astore 7
    //   479: aload 7
    //   481: aload_0
    //   482: getfield 84	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   485: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   488: invokevirtual 349	alto:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   491: astore_2
    //   492: aload_2
    //   493: iconst_0
    //   494: putfield 517	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   497: aload_2
    //   498: iconst_0
    //   499: putfield 516	com/tencent/mobileqq/data/Card:iNewCount	I
    //   502: aload 7
    //   504: aload_2
    //   505: invokevirtual 528	alto:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   508: pop
    //   509: goto -354 -> 155
    //   512: aload_2
    //   513: ifnull +17 -> 530
    //   516: aload_2
    //   517: getfield 516	com/tencent/mobileqq/data/Card:iNewCount	I
    //   520: ifne -324 -> 196
    //   523: aload_2
    //   524: getfield 517	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   527: ifne -331 -> 196
    //   530: aload 7
    //   532: sipush 10015
    //   535: invokevirtual 632	avsm:a	(I)V
    //   538: goto -342 -> 196
    //   541: aload_2
    //   542: getfield 516	com/tencent/mobileqq/data/Card:iNewCount	I
    //   545: istore 4
    //   547: goto -286 -> 261
    //   550: aload_2
    //   551: getfield 517	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   554: istore 5
    //   556: goto -291 -> 265
    //   559: iconst_0
    //   560: istore_3
    //   561: goto -148 -> 413
    //   564: iload_3
    //   565: iconst_1
    //   566: iadd
    //   567: istore_3
    //   568: goto -527 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	MedalWallMng
    //   0	571	1	paramInt	int
    //   0	571	2	paramObject	Object
    //   40	528	3	k	int
    //   259	287	4	m	int
    //   1	554	5	n	int
    //   23	342	6	localObject1	Object
    //   34	413	8	localObject3	Object
    //   63	60	9	localMedalInfo	MedalInfo
    // Exception table:
    //   from	to	target	type
    //   41	95	131	finally
    //   98	120	131	finally
    //   120	128	131	finally
    //   132	135	131	finally
    //   314	317	131	finally
    //   30	39	137	java/lang/Throwable
    //   135	137	137	java/lang/Throwable
    //   317	326	137	java/lang/Throwable
    //   336	356	137	java/lang/Throwable
    //   420	422	137	java/lang/Throwable
    //   326	336	416	finally
    //   417	420	416	finally
    //   356	392	455	java/lang/Throwable
    //   392	401	455	java/lang/Throwable
    //   422	444	455	java/lang/Throwable
    //   444	452	455	java/lang/Throwable
    //   463	465	455	java/lang/Throwable
    //   401	413	459	finally
    //   460	463	459	finally
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
    if ((bdeu.a(paramString1, this.jdField_c_of_type_JavaLangString)) && (bdeu.a(paramString2, this.jdField_d_of_type_JavaLangString)) && (bdeu.a(paramString3, this.jdField_e_of_type_JavaLangString)))
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
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, "insertFriendMedalNewsMsg " + paramString2);
    }
    aeqn localaeqn = (aeqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
    Object localObject = localaeqn.a(paramString2, 0, 3);
    if (localObject != null) {
      if (((BeancurdMsg)localObject).originTime < paramLong) {
        break label262;
      }
    }
    label262:
    for (int k = 0;; k = 1) {
      for (;;)
      {
        if (k != 0) {}
        try
        {
          localObject = new BeancurdMsg();
          ((BeancurdMsg)localObject).frienduin = paramString2;
          ((BeancurdMsg)localObject).busiid = 4;
          ((BeancurdMsg)localObject).isNeedDelHistory = true;
          ((BeancurdMsg)localObject).ispush = false;
          ((BeancurdMsg)localObject).originTime = paramLong;
          ((BeancurdMsg)localObject).startTime = ayzl.a();
          ((BeancurdMsg)localObject).validTime = 2592000L;
          ((BeancurdMsg)localObject).buffer = paramString1;
          localaeqn.a((BeancurdMsg)localObject);
          return;
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, new int[] { -2062 });
          if ((localObject != null) && (((List)localObject).size() > 0) && (((MessageForMedalNews)((List)localObject).get(((List)localObject).size() - 1)).ts >= paramLong)) {
            k = 0;
          }
        }
        catch (Exception paramString1)
        {
          do
          {
            paramString1.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.i("MedalWallMng", 2, "handleAIOQQStoryFeedMessage: parse data to MessageRecord has error. Message: " + paramString1.getMessage());
          return;
        }
      }
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
          ((awgf)localObject2).b(localMedalInfo);
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
        ((awgf)localObject2).a(localMedalInfo);
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
              ((awgf)localObject2).b((awge)localObject3);
            }
            for (;;)
            {
              synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
              {
                this.jdField_a_of_type_AndroidUtilSparseArray.put(((MedalInfo)localObject3).iId, localObject3);
              }
              if ((((MedalInfo)localObject3).getStatus() == 1001) || (((MedalInfo)localObject3).getStatus() == 1002)) {
                ((awgf)localObject2).a((awge)localObject3);
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
      this.j = bdne.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 3);
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
      Object localObject1 = (avsm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
      if (((avsm)localObject1).a(((avsm)localObject1).a(10015), false)) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label131;
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no red point");
        return false;
      }
      label131:
      Object localObject3 = null;
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
          aubj localaubj = (aubj)localIterator.next();
          if (localaubj != null)
          {
            localObject3 = localObject1;
            if (localaubj.jdField_b_of_type_Boolean) {
              break label640;
            }
            localObject3 = localObject1;
            if (!localaubj.jdField_a_of_type_Boolean) {
              break label640;
            }
            localObject3 = localObject1;
            if (TextUtils.isEmpty(localaubj.jdField_a_of_type_JavaLangString)) {
              break label640;
            }
            localObject3 = localObject1;
            if (TextUtils.isEmpty(localaubj.jdField_b_of_type_JavaLangString)) {
              break label640;
            }
            localObject3 = localObject1;
            if (localaubj.jdField_a_of_type_Int == 2) {
              break label640;
            }
            localObject3 = localObject1;
            if (localaubj.jdField_a_of_type_ComTencentMobileqqDataMedalInfo == null) {
              break label640;
            }
            localObject3 = localaubj;
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              boolean bool = localaubj.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.isNewer(((aubj)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo);
              if (!bool) {
                break label640;
              }
              localObject3 = localaubj;
            }
            localObject1 = localObject3;
          }
        }
        if ((localObject1 != null) && (((aubj)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null))
        {
          ((aubj)localObject1).jdField_b_of_type_Boolean = true;
          localObject3 = ((aubj)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo;
          if ((paramObject instanceof Card))
          {
            paramObject = (Card)paramObject;
            if (((MedalInfo)localObject3).iLevel == 255)
            {
              if (((MedalInfo)localObject3).iUnreadLevel1 != 1) {
                break label631;
              }
              k = 0;
              n = 1;
              label371:
              paramObject.iNewCount -= n;
              paramObject.iUpgradeCount -= k;
            }
          }
          else
          {
            paramObject = Message.obtain();
            paramObject.what = 4;
            paramObject.obj = localObject1;
            this.jdField_a_of_type_Bhtd.sendMessage(paramObject);
            MedalGuideView.a((aubj)localObject1, paramBaseActivity, paramView, paramInt);
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
                  break label371;
                }
                n = m;
                k = i1;
                if (((MedalInfo)localObject3).iUnreadLevel3 != 1) {
                  break label371;
                }
                k = i1 + 1;
                n = m;
                break label371;
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.i("MedalWallMng", 4, "checkShowMedalGuide no medal to show");
                return false;
              }
            }
          }
          label631:
          k = 0;
          int n = 0;
          continue;
          label640:
          localObject3 = localObject2;
        }
      }
    }
  }
  
  public void b()
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "onGetSelfObtainNewMedalNotice medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!b()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "onGetSelfObtainNewMedalNotice medal is off!");
    return;
    this.jdField_a_of_type_Bhtd.removeMessages(3);
    ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).z();
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
    this.jdField_a_of_type_Bhtd.removeMessages(3);
    this.jdField_a_of_type_Bhtd.removeMessages(1);
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
            aubj localaubj = new aubj();
            localaubj.jdField_a_of_type_ComTencentMobileqqDataMedalInfo = localMedalInfo;
            localArrayList.add(localaubj);
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
          this.jdField_a_of_type_Bhtd.sendEmptyMessage(1);
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
        aubj localaubj = (aubj)paramMessage.obj;
        if (localaubj != null)
        {
          if (localaubj.jdField_a_of_type_Int == 2) {
            this.i += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "MSG_DOWNLOAD_RES_RESULT failCount: %d, cost: %d, failCode: %d, url: %s", new Object[] { Integer.valueOf(this.i), Integer.valueOf(paramMessage.arg1), Integer.valueOf(localaubj.jdField_b_of_type_Int), localaubj.jdField_a_of_type_JavaLangString }));
          }
        }
      } while (this.h >= this.jdField_a_of_type_JavaUtilArrayList.size());
      this.jdField_a_of_type_Bhtd.sendEmptyMessage(1);
      return true;
      f();
      return true;
    } while (!(paramMessage.obj instanceof aubj));
    a(0, (aubj)paramMessage.obj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng
 * JD-Core Version:    0.7.0.1
 */