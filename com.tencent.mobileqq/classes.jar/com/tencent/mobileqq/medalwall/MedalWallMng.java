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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
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
  protected static final String b;
  public static int c;
  public static int d;
  public static int e;
  public static int f = 6;
  public static int g = 7;
  protected final SparseArray<MedalInfo> a;
  protected QQAppInterface a;
  protected final WeakReferenceHandler a;
  protected final ArrayList<MedalWallMng.NeedGuideMedal> a;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tencent/MobileQQ/medal/");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    jdField_e_of_type_Int = 5;
  }
  
  public MedalWallMng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.h = 0;
  }
  
  public static String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("validateUrl>>> url=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.startsWith("https://")) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("validateUrl<<< url=%s", new Object[] { paramString }));
    }
    return paramString;
  }
  
  public static void a(MedalInfo paramMedalInfo, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalInfo[");
    paramStringBuilder.append("iId: ");
    paramStringBuilder.append(paramMedalInfo.iId);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iType: ");
    paramStringBuilder.append(paramMedalInfo.iType);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iLevel: ");
    paramStringBuilder.append(paramMedalInfo.iLevel);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iLevelCount: ");
    paramStringBuilder.append(paramMedalInfo.iLevelCount);
    paramStringBuilder.append(",");
    paramStringBuilder.append("lEndTime: ");
    paramStringBuilder.append(paramMedalInfo.lEndTime);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iUnreadLevel1: ");
    paramStringBuilder.append(paramMedalInfo.iUnreadLevel1);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iUnreadLevel2: ");
    paramStringBuilder.append(paramMedalInfo.iUnreadLevel2);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iUnreadLevel3: ");
    paramStringBuilder.append(paramMedalInfo.iUnreadLevel3);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iNoProgress: ");
    paramStringBuilder.append(paramMedalInfo.iNoProgress);
    paramStringBuilder.append(",");
    paramStringBuilder.append("strName: ");
    paramStringBuilder.append(paramMedalInfo.strName);
    paramStringBuilder.append("] ");
  }
  
  public static void a(MedalID paramMedalID, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalID[");
    paramStringBuilder.append("id: ");
    paramStringBuilder.append(paramMedalID.jdField_a_of_type_Int);
    paramStringBuilder.append(",");
    paramStringBuilder.append("level: ");
    paramStringBuilder.append(paramMedalID.jdField_b_of_type_Int);
    paramStringBuilder.append("] ");
  }
  
  private void a(MedalWallMng.NeedGuideMedal paramNeedGuideMedal)
  {
    if (paramNeedGuideMedal != null)
    {
      if (paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo == null) {
        return;
      }
      if (!FileUtils.fileExistsAndNotEmpty(paramNeedGuideMedal.jdField_b_of_type_JavaLangString)) {
        return;
      }
      try
      {
        Resources localResources = BaseApplicationImpl.getApplication().getResources();
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int k = localResources.getDimensionPixelSize(2131298357);
        localURLDrawableOptions.mRequestWidth = k;
        localURLDrawableOptions.mRequestHeight = k;
        URLDrawable.getDrawable(new File(paramNeedGuideMedal.jdField_b_of_type_JavaLangString), localURLDrawableOptions).startDownload(true);
        return;
      }
      catch (Exception paramNeedGuideMedal)
      {
        QLog.e("MedalWallMng", 1, "tryPreloadImg fail.", paramNeedGuideMedal);
      }
    }
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
    if (SharedPreUtils.U(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).medalSwitchDisable) {
      return true;
    }
    return Utils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void d()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      StringBuilder localStringBuilder = null;
      if (QLog.isColorLevel()) {
        localStringBuilder = new StringBuilder(200);
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().query(MedalInfo.class);
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.clear();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            MedalInfo localMedalInfo = (MedalInfo)((Iterator)localObject3).next();
            if (localMedalInfo != null)
            {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(localMedalInfo.iId, localMedalInfo);
              if ((QLog.isColorLevel()) && (localStringBuilder != null))
              {
                a(localMedalInfo, localStringBuilder);
                localStringBuilder.append("\r\n");
              }
            }
          }
        }
      }
      this.jdField_a_of_type_Boolean = true;
      if ((QLog.isColorLevel()) && (localObject1 != null)) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "init size: %d \r\n{%s}", new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.size()), localObject1.toString() }));
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckMedalRes checkedCount: %d", new Object[] { Integer.valueOf(this.h) }));
    }
    int k;
    label182:
    Object localObject2;
    label187:
    label192:
    label199:
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.h > 0)
      {
        k = this.h - 1;
        break label182;
        if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label199;
        }
        MedalWallMng.NeedGuideMedal localNeedGuideMedal = (MedalWallMng.NeedGuideMedal)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if ((localNeedGuideMedal != null) && (!localNeedGuideMedal.jdField_a_of_type_Boolean))
        {
          if (!localNeedGuideMedal.a()) {
            break label187;
          }
          this.h = (k + 1);
          a(localNeedGuideMedal);
          break label192;
        }
        this.h = (k + 1);
        break label192;
        if (k != 0)
        {
          ThreadManager.post(new MedalWallMng.DownloadResTask(this, localNeedGuideMedal), 5, null, false);
          return;
        }
        if (this.i > 0)
        {
          b(2);
          return;
        }
        b(1);
      }
    }
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "doCheckForLogin");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    Object localObject = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(10015);
    boolean bool = ((LocalRedTouchManager)localObject).b(localRedTouchItem);
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
      } else {
        c();
      }
    }
    else
    {
      b(0);
      k = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("doCheckForLogin hasMedalRedPoint=%s, flag=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(k) }));
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
    Object localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
    int i3 = 0;
    int i2 = 0;
    int k = 0;
    for (;;)
    {
      try
      {
        Object localObject2;
        if (i3 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
        {
          localObject2 = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i3);
          if (localObject2 == null)
          {
            n = i2;
            i1 = k;
          }
          else if (((MedalInfo)localObject2).iLevel == 255)
          {
            n = i2;
            i1 = k;
            if (((MedalInfo)localObject2).iUnreadLevel1 == 1)
            {
              n = i2 + 1;
              i1 = k;
            }
          }
          else
          {
            n = i2;
            i1 = k;
            if (((MedalInfo)localObject2).iLevelCount > 1)
            {
              int m = i2;
              if (((MedalInfo)localObject2).iLevel >= 1)
              {
                m = i2;
                if (((MedalInfo)localObject2).iUnreadLevel1 == 1) {
                  m = i2 + 1;
                }
              }
              i2 = k;
              if (((MedalInfo)localObject2).iLevel >= 2)
              {
                i2 = k;
                if (((MedalInfo)localObject2).iUnreadLevel2 == 1) {
                  i2 = k + 1;
                }
              }
              n = m;
              i1 = i2;
              if (((MedalInfo)localObject2).iLevel >= 3)
              {
                n = m;
                i1 = i2;
                if (((MedalInfo)localObject2).iUnreadLevel3 == 1)
                {
                  i1 = i2 + 1;
                  n = m;
                }
              }
            }
          }
        }
        else
        {
          localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          localObject2 = ((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (paramTMedalWallInfo != null)
          {
            ((Card)localObject2).iMedalCount = paramTMedalWallInfo.iMedalCount;
            if (QLog.isColorLevel()) {
              QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo needCheck: %s, compute[iNewCount: %d, iUpgradeCount: %d] server[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i2), Integer.valueOf(k), Integer.valueOf(paramTMedalWallInfo.iNewCount), Integer.valueOf(paramTMedalWallInfo.iUpgradeCount), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
            }
            if ((paramBoolean) && ((paramTMedalWallInfo.iNewCount > i2) || (paramTMedalWallInfo.iUpgradeCount > k)))
            {
              paramTMedalWallInfo.iNewCount = Math.min(paramTMedalWallInfo.iNewCount, i2);
              paramTMedalWallInfo.iUpgradeCount = Math.min(paramTMedalWallInfo.iUpgradeCount, k);
            }
            ((Card)localObject2).iNewCount = paramTMedalWallInfo.iNewCount;
            ((Card)localObject2).iUpgradeCount = paramTMedalWallInfo.iUpgradeCount;
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo compute[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(i2), Integer.valueOf(k), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
            }
            ((Card)localObject2).iNewCount = Math.min(((Card)localObject2).iNewCount, i2);
            ((Card)localObject2).iUpgradeCount = Math.min(((Card)localObject2).iUpgradeCount, k);
          }
          ((FriendsManager)localObject1).a((Card)localObject2);
          return localObject2;
        }
      }
      finally
      {
        int n;
        int i1;
        continue;
        throw paramTMedalWallInfo;
        continue;
        i3 += 1;
        i2 = n;
        k = i1;
      }
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
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.jdField_d_of_type_JavaLangString);
      localStringBuilder.append("&tuin=");
      localStringBuilder.append(NearbyURLSafeUtil.a(paramString));
      paramString = localStringBuilder;
    }
    else
    {
      paramString = new StringBuilder(this.jdField_c_of_type_JavaLangString);
    }
    paramString.append("&from=");
    paramString.append(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "getMedalWallUrl url: %s", new Object[] { paramString }));
    }
    return paramString.toString();
  }
  
  public ArrayList<MedalID> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int k;
      try
      {
        paramString = paramString.replaceAll("new_medals=", "").replaceAll("update_medals=", "").replaceAll("&", ",").split(",");
        k = 0;
        if (k < paramString.length)
        {
          if ((paramString[k] == null) || (paramString[k].isEmpty())) {
            break label309;
          }
          localObject = paramString[k].split("_");
          if (localObject.length != 3) {
            break label309;
          }
          localArrayList.add(new MedalID(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1])));
          break label309;
        }
        k = localArrayList.size() - 1;
        if (k < 0) {
          break label306;
        }
        paramString = (MedalID)localArrayList.get(k);
        Object localObject = a(paramString.jdField_a_of_type_Int);
        m = paramString.jdField_b_of_type_Int;
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if ((m != 255) || (((MedalInfo)localObject).iUnreadLevel1 != 2)) {
                break label316;
              }
              break label321;
            }
            if (((MedalInfo)localObject).iUnreadLevel3 != 2) {
              break label316;
            }
            break label321;
          }
          if (((MedalInfo)localObject).iUnreadLevel2 != 2) {
            break label316;
          }
          break label321;
        }
        if (((MedalInfo)localObject).iUnreadLevel1 != 2) {
          break label316;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          break label306;
        }
        QLog.i("MedalWallMng", 2, "summarycard", paramString);
      }
      if (m != 0)
      {
        localArrayList.remove(k);
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "parsePromptParams local read [id: %d , level: %d]", new Object[] { Integer.valueOf(paramString.jdField_a_of_type_Int), Integer.valueOf(paramString.jdField_b_of_type_Int) }));
        }
      }
      k -= 1;
      continue;
      label306:
      return localArrayList;
      label309:
      k += 1;
      continue;
      label316:
      int m = 0;
      continue;
      label321:
      m = 1;
    }
  }
  
  public void a()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkForLogin medal strong reminder is off!");
      }
      return;
    }
    if (b())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkForLogin medal is off!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(3, 1000L);
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetMedalStrongReminderConfig value: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1 = new ArrayList(5);
    int n = 0;
    if (paramInt == 2) {}
    for (;;)
    {
      int k;
      try
      {
        ??? = this.jdField_a_of_type_AndroidUtilSparseArray;
        k = 0;
        try
        {
          if (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
          {
            MedalInfo localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
            localMedalInfo.putReportInfo((ArrayList)localObject1);
            localMedalInfo.setRead();
            if (localMedalInfo.getStatus() == 1000)
            {
              ((EntityManager)???).persistOrReplace(localMedalInfo);
              break label577;
            }
            if ((localMedalInfo.getStatus() != 1001) && (localMedalInfo.getStatus() != 1002)) {
              break label577;
            }
            ((EntityManager)???).update(localMedalInfo);
            break label577;
          }
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
          if (!(paramObject instanceof MedalWallMng.NeedGuideMedal)) {
            continue;
          }
        }
        finally {}
        paramObject = (MedalWallMng.NeedGuideMedal)paramObject;
        k = paramObject.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iId;
        try
        {
          ??? = paramObject.jdField_a_of_type_ComTencentMobileqqDataMedalInfo;
          ((MedalInfo)???).putReportInfo((ArrayList)localObject1);
          ((MedalInfo)???).setRead();
          if (((MedalInfo)???).getStatus() == 1000) {
            ((EntityManager)???).persistOrReplace((Entity)???);
          } else if ((((MedalInfo)???).getStatus() == 1001) || (((MedalInfo)???).getStatus() == 1002)) {
            ((EntityManager)???).update((Entity)???);
          }
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(paramObject);
          }
          k = 0;
        }
        catch (Throwable paramObject) {}
      }
      catch (Throwable paramObject)
      {
        k = 0;
        paramObject.printStackTrace();
      }
      if (paramInt == 0)
      {
        paramObject = a(null, true);
      }
      else
      {
        ??? = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramObject = ((FriendsManager)???).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramObject != null)
        {
          paramObject.iUpgradeCount = 0;
          paramObject.iNewCount = 0;
          ((FriendsManager)???).a(paramObject);
        }
      }
      ??? = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
      if ((paramInt != 1) && (paramInt != 2))
      {
        if ((paramObject == null) || ((paramObject.iNewCount == 0) && (paramObject.iUpgradeCount == 0))) {
          ((LocalRedTouchManager)???).a(10015);
        }
      }
      else
      {
        ((LocalRedTouchManager)???).a(10015);
        ((LocalRedTouchManager)???).a(10016);
      }
      if (!((ArrayList)localObject1).isEmpty()) {
        ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).b((ArrayList)localObject1);
      }
      if ((paramObject == null) || ((paramObject.iNewCount == 0) && (paramObject.iUpgradeCount == 0))) {
        b(0);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = Locale.getDefault();
        int m;
        if (paramObject == null) {
          m = 0;
        } else {
          m = paramObject.iNewCount;
        }
        if (paramObject != null) {
          n = paramObject.iUpgradeCount;
        }
        QLog.i("MedalWallMng", 2, String.format((Locale)localObject1, "reportReadSelfNewObtainedMedal [nActionType: %d, id: %d, iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
      }
      return;
      label577:
      k += 1;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { paramString1, paramString2, paramString3 }));
    }
    if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null)) {
      g();
    }
    if ((Utils.a(paramString1, this.jdField_c_of_type_JavaLangString)) && (Utils.a(paramString2, this.jdField_d_of_type_JavaLangString)) && (Utils.a(paramString3, this.jdField_e_of_type_JavaLangString)))
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
    if (paramInt != 1) {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
  }
  
  public void a(boolean paramBoolean, TMedalWallInfo paramTMedalWallInfo, SparseArray<MedalInfo> paramSparseArray)
  {
    d();
    int k;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(200);
      ((StringBuilder)???).append("onGetSelfNewObtainedMedaInfo isSuc:");
      ((StringBuilder)???).append(paramBoolean);
      if (paramTMedalWallInfo != null)
      {
        ((StringBuilder)???).append(", iMedalCount:");
        ((StringBuilder)???).append(paramTMedalWallInfo.iMedalCount);
        ((StringBuilder)???).append(", iNewCount:");
        ((StringBuilder)???).append(paramTMedalWallInfo.iNewCount);
        ((StringBuilder)???).append(", iUpgradeCount:");
        ((StringBuilder)???).append(paramTMedalWallInfo.iUpgradeCount);
      }
      if (paramSparseArray != null)
      {
        ((StringBuilder)???).append(", medalInfoArrayList: ");
        ((StringBuilder)???).append(paramSparseArray.size());
        k = 0;
        while (k < paramSparseArray.size())
        {
          localObject2 = (MedalInfo)paramSparseArray.valueAt(k);
          if (localObject2 != null)
          {
            ((StringBuilder)???).append("\r\n info [id: ");
            ((StringBuilder)???).append(((MedalInfo)localObject2).iId);
            ((StringBuilder)???).append(", iLevel: ");
            ((StringBuilder)???).append(((MedalInfo)localObject2).iLevel);
            ((StringBuilder)???).append(", name: ");
            ((StringBuilder)???).append(((MedalInfo)localObject2).strName);
            ((StringBuilder)???).append(", res: ");
            ((StringBuilder)???).append(((MedalInfo)localObject2).strResJson);
            ((StringBuilder)???).append("]");
          }
          k += 1;
        }
      }
      QLog.i("MedalWallMng", 2, ((StringBuilder)???).toString());
    }
    Object localObject3;
    if (!paramBoolean)
    {
      b(2);
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject3 = this.jdField_a_of_type_AndroidUtilSparseArray;
      k = 0;
    }
    try
    {
      if (k >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
        break label475;
      }
      localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
      if (localMedalInfo == null) {
        break label636;
      }
      if (paramSparseArray == null) {
        break label628;
      }
      ??? = (MedalInfo)paramSparseArray.get(localMedalInfo.iId);
    }
    finally
    {
      label475:
      label628:
      do
      {
        MedalInfo localMedalInfo;
        for (;;)
        {
          throw paramTMedalWallInfo;
        }
        ??? = null;
      } while (??? == null);
      label636:
      k += 1;
    }
    if (localMedalInfo.isUnread())
    {
      localMedalInfo.setRead();
      if (localMedalInfo.getStatus() == 1000) {
        ((EntityManager)localObject2).persistOrReplace(localMedalInfo);
      } else if ((localMedalInfo.getStatus() == 1001) || (localMedalInfo.getStatus() == 1002)) {
        ((EntityManager)localObject2).update(localMedalInfo);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetSelfNewObtainedMedaInfo just local is unread [id: %d, level: %d, name: %s]", new Object[] { Integer.valueOf(localMedalInfo.iId), Integer.valueOf(localMedalInfo.iLevel), localMedalInfo.strName }));
        break label636;
        k = 0;
      }
    }
    for (;;)
    {
      if ((paramSparseArray != null) && (k < paramSparseArray.size()))
      {
        localObject3 = (MedalInfo)paramSparseArray.valueAt(k);
        if (localObject3 != null)
        {
          if (((MedalInfo)localObject3).getStatus() == 1000) {
            ((EntityManager)localObject2).persistOrReplace((Entity)localObject3);
          } else if ((((MedalInfo)localObject3).getStatus() == 1001) || (((MedalInfo)localObject3).getStatus() == 1002)) {
            ((EntityManager)localObject2).update((Entity)localObject3);
          }
          synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(((MedalInfo)localObject3).iId, localObject3);
          }
        }
      }
      else
      {
        a(paramTMedalWallInfo, true);
        b(0);
        c();
        return;
        break;
      }
      k += 1;
    }
  }
  
  public boolean a()
  {
    int k = this.j;
    boolean bool = false;
    if (k == -2147483648)
    {
      this.j = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 3);
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "isMedalStrongReminderOff value: %s", new Object[] { Integer.valueOf(this.j) }));
      }
    }
    if (this.j == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, View paramView, int paramInt, Object paramObject)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkShowMedalGuide medal strong reminder is off!");
      }
      return false;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkShowMedalGuide isMedalConfigOff: %s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
      }
      return false;
    }
    Object localObject1 = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    Object localObject2 = ((LocalRedTouchManager)localObject1).a(10015);
    boolean bool = ((LocalRedTouchManager)localObject1).b((RedTouchItem)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("checkShowMedalGuide item=%s hasMedalRedPoint=%s", new Object[] { localObject2, Boolean.valueOf(bool) }));
    }
    if (!bool)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no red point");
      }
      return false;
    }
    localObject2 = null;
    localObject1 = null;
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject3;
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = localObject1;
        localObject3 = (MedalWallMng.NeedGuideMedal)localIterator.next();
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!((MedalWallMng.NeedGuideMedal)localObject3).jdField_b_of_type_Boolean)
          {
            localObject2 = localObject1;
            if (((MedalWallMng.NeedGuideMedal)localObject3).jdField_a_of_type_Boolean)
            {
              localObject2 = localObject1;
              if (!TextUtils.isEmpty(((MedalWallMng.NeedGuideMedal)localObject3).jdField_a_of_type_JavaLangString))
              {
                localObject2 = localObject1;
                if (!TextUtils.isEmpty(((MedalWallMng.NeedGuideMedal)localObject3).jdField_b_of_type_JavaLangString))
                {
                  localObject2 = localObject1;
                  if (((MedalWallMng.NeedGuideMedal)localObject3).jdField_a_of_type_Int != 2)
                  {
                    localObject2 = localObject1;
                    if (((MedalWallMng.NeedGuideMedal)localObject3).jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null) {
                      if (localObject1 != null)
                      {
                        localObject2 = localObject1;
                        bool = ((MedalWallMng.NeedGuideMedal)localObject3).jdField_a_of_type_ComTencentMobileqqDataMedalInfo.isNewer(((MedalWallMng.NeedGuideMedal)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo);
                        if (!bool) {}
                      }
                      else
                      {
                        localObject1 = localObject3;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      MedalInfo localMedalInfo;
      int k;
      int n;
      int i1;
      int m;
      label522:
      label529:
      return false;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localObject3 = localObject2;
      if ((localObject3 != null) && (((MedalWallMng.NeedGuideMedal)localObject3).jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null))
      {
        ((MedalWallMng.NeedGuideMedal)localObject3).jdField_b_of_type_Boolean = true;
        localMedalInfo = ((MedalWallMng.NeedGuideMedal)localObject3).jdField_a_of_type_ComTencentMobileqqDataMedalInfo;
        if ((paramObject instanceof Card))
        {
          paramObject = (Card)paramObject;
          if (localMedalInfo.iLevel == 255)
          {
            if (localMedalInfo.iUnreadLevel1 == 1)
            {
              k = 1;
              break label522;
            }
          }
          else if (localMedalInfo.iLevelCount > 1)
          {
            if ((localMedalInfo.iLevel >= 1) && (localMedalInfo.iUnreadLevel1 == 1)) {
              k = 1;
            } else {
              k = 0;
            }
            if ((localMedalInfo.iLevel >= 2) && (localMedalInfo.iUnreadLevel2 == 1)) {
              n = 1;
            } else {
              n = 0;
            }
            i1 = k;
            m = n;
            if (localMedalInfo.iLevel < 3) {
              break label529;
            }
            i1 = k;
            m = n;
            if (localMedalInfo.iUnreadLevel3 != 1) {
              break label529;
            }
            m = n + 1;
            i1 = k;
            break label529;
          }
          k = 0;
          m = 0;
          i1 = k;
          paramObject.iNewCount -= i1;
          paramObject.iUpgradeCount -= m;
        }
        paramObject = Message.obtain();
        paramObject.what = 4;
        paramObject.obj = localObject3;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramObject);
        MedalGuideView.a((MedalWallMng.NeedGuideMedal)localObject3, paramQBaseActivity, paramView, paramInt);
        if (QLog.isDevelopLevel()) {
          QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "checkShowMedalGuide [%d, %d,  %s]", new Object[] { Integer.valueOf(localMedalInfo.iId), Integer.valueOf(localMedalInfo.iLevel), localMedalInfo.strName }));
        }
        return true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no medal to show");
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
    if (!bool1)
    {
      if (bool2) {
        return;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).l();
    }
  }
  
  protected void c()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkMedalWall medal strong reminder is off!");
      }
      return;
    }
    if (b())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkMedalWall medal is off!");
      }
      return;
    }
    boolean bool = QLog.isColorLevel();
    int k = 0;
    if (bool) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalWall mIsInit: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.h = 0;
    this.i = 0;
    d();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        if (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
        {
          MedalInfo localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
          if ((localMedalInfo != null) && (localMedalInfo.isUnread()))
          {
            MedalWallMng.NeedGuideMedal localNeedGuideMedal = new MedalWallMng.NeedGuideMedal();
            localNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo = localMedalInfo;
            localArrayList.add(localNeedGuideMedal);
          }
        }
        else
        {
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
            if (this.h < this.jdField_a_of_type_JavaUtilArrayList.size()) {
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
            }
            return;
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            return true;
          }
          if ((paramMessage.obj instanceof MedalWallMng.NeedGuideMedal))
          {
            a(0, (MedalWallMng.NeedGuideMedal)paramMessage.obj);
            return true;
          }
        }
        else
        {
          f();
          return true;
        }
      }
      else
      {
        MedalWallMng.NeedGuideMedal localNeedGuideMedal = (MedalWallMng.NeedGuideMedal)paramMessage.obj;
        if (localNeedGuideMedal != null)
        {
          if (localNeedGuideMedal.jdField_a_of_type_Int == 2) {
            this.i += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "MSG_DOWNLOAD_RES_RESULT failCount: %d, cost: %d, failCode: %d, url: %s", new Object[] { Integer.valueOf(this.i), Integer.valueOf(paramMessage.arg1), Integer.valueOf(localNeedGuideMedal.jdField_b_of_type_Int), localNeedGuideMedal.jdField_a_of_type_JavaLangString }));
          }
        }
        if (this.h < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
          return true;
        }
      }
    }
    else {
      e();
    }
    return true;
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng
 * JD-Core Version:    0.7.0.1
 */