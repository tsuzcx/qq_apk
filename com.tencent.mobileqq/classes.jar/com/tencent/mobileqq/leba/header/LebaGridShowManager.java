package com.tencent.mobileqq.leba.header;

import aejj;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.campuscircle.CampusLebaEntryChecker;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.leba.LebaGridManager;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class LebaGridShowManager
{
  private static volatile LebaGridShowManager jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public int a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap a;
  public List a;
  public Set a;
  public int[] a;
  List b = new ArrayList();
  private List c = new ArrayList();
  
  private LebaGridShowManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ArrayOfInt = new int[10];
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    b();
  }
  
  public static Bitmap a(File paramFile)
  {
    Bitmap localBitmap = null;
    Object localObject = localBitmap;
    if (paramFile != null)
    {
      localObject = localBitmap;
      if (BaseApplicationImpl.sImageCache != null)
      {
        String str = "LebaIcon://" + paramFile.getAbsolutePath();
        localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
        localObject = localBitmap;
        if (localBitmap == null)
        {
          localObject = localBitmap;
          if (paramFile.exists())
          {
            paramFile = LebaGridUtils.a(paramFile);
            localObject = paramFile;
            if (paramFile != null)
            {
              BaseApplicationImpl.sImageCache.put(str, paramFile);
              localObject = paramFile;
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public static LebaGridShowManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager == null) {
        jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager = new LebaGridShowManager();
      }
      return jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager;
    }
  }
  
  private void a(Context paramContext, PluginInfo paramPluginInfo, List paramList, LebaGridItemInfo paramLebaGridItemInfo)
  {
    for (;;)
    {
      try
      {
        paramContext = LebaGridUtils.a(paramContext, paramPluginInfo.pkgName, paramPluginInfo.resBigUrl);
        if (paramContext != null) {
          paramLebaGridItemInfo.jdField_a_of_type_JavaLangString = ("LebaIcon://" + paramContext.getAbsolutePath());
        }
        paramLebaGridItemInfo = a(paramContext);
        if ((paramLebaGridItemInfo == null) && (QLog.isColorLevel())) {
          QLog.d("Q.lebatab.", 2, "can't find bitmap from local, info=" + paramPluginInfo.resName);
        }
        if ((paramContext != null) && (!paramContext.exists()))
        {
          if ((paramContext != null) && (paramContext.exists()) && (paramLebaGridItemInfo == null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.lebatab.", 2, "handleLocalList.delete file.");
            }
            paramContext.delete();
          }
          paramLebaGridItemInfo = new HashMap();
          paramLebaGridItemInfo.put("KEY", paramPluginInfo.pkgName);
          paramLebaGridItemInfo.put("URL", new URL(paramPluginInfo.resBigUrl));
          paramLebaGridItemInfo.put("FILE", paramContext);
          paramList.add(paramLebaGridItemInfo);
          return;
        }
      }
      catch (Exception paramContext)
      {
        if ((!QLog.isColorLevel()) || (paramContext == null)) {
          continue;
        }
        QLog.d("Q.lebatab.mgr", 2, paramContext.toString());
        return;
      }
      if (paramLebaGridItemInfo != null) {}
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaGridShowManager", 2, "Download success icon key = " + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        if (localMap != null)
        {
          String str = (String)localMap.get("KEY");
          if ((str != null) && (str.equals(paramString))) {
            this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
          }
        }
      }
      return;
    }
  }
  
  private boolean a(LebaGridItemInfo paramLebaGridItemInfo, QQAppInterface paramQQAppInterface)
  {
    if ((paramLebaGridItemInfo == null) || (paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while (paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == 905);
        if ((!"看点".equals(paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName)) || (!ReadInJoyHelper.h())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.lebatab.mgr", 2, "hide leba kandian");
      return true;
      if (LebaGridUtils.a(paramLebaGridItemInfo))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName, paramLebaGridItemInfo);
        return true;
      }
      if (paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId != 6005) {
        break;
      }
      if (QLog.isColorLevel())
      {
        paramLebaGridItemInfo = new StringBuilder().append("getLebaShowList isNowTabAdded:");
        paramQQAppInterface.a();
        QLog.d("Q.qqstory.fourTab", 2, NowLiveManager.c + "  isNowTabShow:" + paramQQAppInterface.a().a + "isSDKAPISupportStory:" + QQStoryManager.j());
      }
    } while (!paramQQAppInterface.a().a());
    return false;
  }
  
  private Bitmap b(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((i > 300) && (j > 300)) {
      localOptions.inSampleSize = 3;
    }
    localOptions.inJustDecodeBounds = false;
    return SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
  }
  
  private void b()
  {
    LebaGridItemInfo localLebaGridItemInfo = new LebaGridItemInfo();
    localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo = new PluginInfo();
    localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName = "qzone_feedlist";
    localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId = 10000;
    String str = "";
    if (a() != null) {
      str = a().getCurrentAccountUin();
    }
    localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.jumpInfo = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { str, "tab_qzone" });
    localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.uiJumpType = 1;
    this.b.add(localLebaGridItemInfo);
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        Map localMap;
        if (localIterator.hasNext())
        {
          localMap = (Map)localIterator.next();
          if (localMap == null) {
            continue;
          }
          String str = (String)localMap.get("KEY");
          if ((str == null) || (!str.equals(paramString))) {
            continue;
          }
          if (!localMap.containsKey("TIME")) {
            break label200;
          }
          i = ((Integer)localMap.get("TIME")).intValue();
          if (i < 3) {
            continue;
          }
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("LebaGridShowManager", 2, "Download failed icon key = " + paramString + ",time=" + i);
          }
        }
        return;
        i += 1;
        localMap.put("TIME", Integer.valueOf(i));
        localMap.put("LOADING", Boolean.valueOf(false));
      }
      label200:
      int i = 0;
    }
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public LebaGridItemInfo a(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)localIterator.next();
      if ((localLebaGridItemInfo != null) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == paramInt)) {
        return localLebaGridItemInfo;
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.b;
  }
  
  public List a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = ((LebaGridManager)paramQQAppInterface.getManager(211)).a(2);
    if ((QLog.isColorLevel()) && (localObject1 != null)) {
      QLog.i("Q.lebatab.mgr", 2, "loadLebaFromDB" + ((List)localObject1).size());
    }
    if (localObject1 != null)
    {
      CampusLebaEntryChecker localCampusLebaEntryChecker = paramQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker;
      if ((localCampusLebaEntryChecker == null) && (QLog.isDevelopLevel())) {
        QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems campusLebaEntryChecker is null");
      }
      WholePeopleLebaEntryChecker localWholePeopleLebaEntryChecker = paramQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeopleLebaEntryChecker;
      if ((localWholePeopleLebaEntryChecker == null) && (QLog.isDevelopLevel())) {
        QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems wholePeopleChecker is null");
      }
      Object localObject2 = new ArrayList((Collection)localObject1);
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      boolean bool1 = false;
      while (((Iterator)localObject2).hasNext())
      {
        PluginInfo localPluginInfo = (PluginInfo)((Iterator)localObject2).next();
        if (localPluginInfo != null) {
          if ((localPluginInfo.pluginId == 4086) && (localCampusLebaEntryChecker != null) && (!localCampusLebaEntryChecker.a))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems camps entry switch is off ");
            }
          }
          else if ((localPluginInfo.pluginId == 770) && (!localPluginInfo.isAllowFlag(1)) && (localWholePeopleLebaEntryChecker != null) && (!localWholePeopleLebaEntryChecker.a))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems wholePeople entry switch is off ");
            }
          }
          else
          {
            boolean bool2 = bool1;
            if (localPluginInfo.pluginId == 770) {
              bool2 = true;
            }
            LebaGridItemInfo localLebaGridItemInfo = new LebaGridItemInfo();
            for (;;)
            {
              try
              {
                a(paramContext, localPluginInfo, localArrayList2, localLebaGridItemInfo);
                localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo = localPluginInfo;
                localObject4 = JumpParser.a(paramQQAppInterface, paramContext, localPluginInfo.jumpInfo);
                if ((localObject4 != null) && ("app".equals(((JumpAction)localObject4).a())))
                {
                  localObject3 = ((JumpAction)localObject4).a("cmp");
                  String str = ((JumpAction)localObject4).a("pkg");
                  if ((localObject3 != null) && (((String)localObject3).compareTo("cooperation.readinjoy.ReadInJoyProxyActivity") == 0))
                  {
                    bool1 = bool2;
                    if (!ReadInJoyHelper.a()) {
                      break;
                    }
                  }
                  if ((localObject3 != null) && (str != null))
                  {
                    localObject4 = paramContext.getPackageManager();
                    localObject3 = new ComponentName(str, (String)localObject3);
                  }
                }
              }
              catch (Exception localException)
              {
                try
                {
                  Object localObject4;
                  Object localObject3;
                  ((PackageManager)localObject4).getActivityInfo((ComponentName)localObject3, 32);
                  if (localPluginInfo.openFlag != 1) {
                    break label540;
                  }
                  b1 = 0;
                  localLebaGridItemInfo.jdField_a_of_type_Byte = b1;
                  ((List)localObject1).add(localLebaGridItemInfo);
                  bool1 = bool2;
                }
                catch (PackageManager.NameNotFoundException localNameNotFoundException)
                {
                  localNameNotFoundException.printStackTrace();
                  bool1 = bool2;
                }
                localException = localException;
                bool1 = bool2;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              bool1 = bool2;
              if (localException == null) {
                break;
              }
              QLog.d("Q.lebatab.mgr", 2, localException.toString());
              bool1 = bool2;
              break;
              break;
              label540:
              byte b1 = 1;
            }
          }
        }
      }
      if (localWholePeopleLebaEntryChecker != null) {
        localWholePeopleLebaEntryChecker.a(bool1);
      }
      Collections.sort((List)localObject1, new LebaGridUtils.LebaItemComparator());
      a(paramQQAppInterface, (List)localObject1);
      LebaGridUtils.a(localArrayList1, b(paramQQAppInterface));
    }
    if (localArrayList2.size() > 0) {
      a(localArrayList2);
    }
    return localArrayList1;
  }
  
  public List a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)localIterator.next();
        if (!a(localLebaGridItemInfo, paramQQAppInterface)) {
          localArrayList.add(localLebaGridItemInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        String str;
        Object localObject1;
        if (localMap != null)
        {
          str = (String)localMap.get("KEY");
          localObject1 = (URL)localMap.get("URL");
          localObject2 = MsfSdkUtils.insertMtype("Dynamic", ((URL)localObject1).toString());
        }
        try
        {
          localObject2 = new URL((String)localObject2);
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            Object localObject3;
            QLog.d("LebaGridShowManager", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
            continue;
            boolean bool = false;
          }
        }
        Object localObject2 = (File)localMap.get("FILE");
        localObject3 = localMap.get("LOADING");
        if ((localObject3 == null) || (!(localObject3 instanceof Boolean))) {
          break label273;
        }
        bool = ((Boolean)localObject3).booleanValue();
        if ((!TextUtils.isEmpty(str)) && (!bool) && (this.jdField_a_of_type_JavaUtilSet.add(str)))
        {
          a(str, (URL)localObject1, (File)localObject2);
          localMap.put("LOADING", Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d("LebaGridShowManager", 2, "reDownload icon key = " + str);
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    LebaShowListManager.a().a(paramQQAppInterface, paramLong1, paramBoolean, paramLong2, paramLong3);
    if (paramQQAppInterface.q) {}
    for (;;)
    {
      synchronized (this.c)
      {
        Object localObject = this.c.iterator();
        if (((Iterator)localObject).hasNext())
        {
          LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)((Iterator)localObject).next();
          if ((localLebaGridItemInfo == null) || (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo == null) || (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId != paramLong1)) {
            continue;
          }
          if (paramBoolean)
          {
            i = 0;
            localLebaGridItemInfo.jdField_a_of_type_Byte = ((byte)i);
            if (paramLong3 == -9223372036854775808L)
            {
              localLebaGridItemInfo.jdField_a_of_type_Long = paramLong2;
              i = 1;
              localObject = localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo;
              if (!paramBoolean) {
                break label252;
              }
              j = 1;
              ((PluginInfo)localObject).openFlag = j;
              ((LebaGridManager)paramQQAppInterface.getManager(211)).a(localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo);
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, ret = " + i);
              }
            }
          }
          else
          {
            i = 1;
            continue;
          }
          if (paramLong2 != localLebaGridItemInfo.jdField_a_of_type_Long) {
            break label244;
          }
          localLebaGridItemInfo.jdField_a_of_type_Long = paramLong3;
          i = 1;
        }
      }
      int i = 1;
      continue;
      label244:
      i = -2147483648;
      continue;
      label252:
      int j = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList != null) {
        break label104;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.i("Q.lebatab.mgr", 4, i);
      synchronized (this.c)
      {
        this.c.clear();
        if (paramList != null) {
          this.c.addAll(paramList);
        }
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (RedTouchHandler)paramQQAppInterface.a(31);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a(3, true, null);
          }
        }
        return;
        label104:
        i = paramList.size();
      }
    }
  }
  
  public void a(DownloadIconsListener paramDownloadIconsListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramDownloadIconsListener);
      return;
    }
  }
  
  public void a(String paramString, URL paramURL, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaGridShowManager", 2, "Download icon for " + paramString);
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.a(new aejj(this, localQQAppInterface, paramURL, paramFile, paramString));
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 48	com/tencent/mobileqq/leba/header/LebaGridShowManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 48	com/tencent/mobileqq/leba/header/LebaGridShowManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   20: invokevirtual 559	java/util/ArrayList:clear	()V
    //   23: aload_0
    //   24: getfield 48	com/tencent/mobileqq/leba/header/LebaGridShowManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   27: aload_1
    //   28: invokevirtual 560	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   31: pop
    //   32: aload_2
    //   33: monitorexit
    //   34: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +40 -> 77
    //   40: ldc 169
    //   42: iconst_2
    //   43: new 62	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 562
    //   53: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokeinterface 353 1 0
    //   62: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc_w 564
    //   68: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 356	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_1
    //   78: invokeinterface 335 1 0
    //   83: astore_3
    //   84: aload_3
    //   85: invokeinterface 180 1 0
    //   90: ifeq -84 -> 6
    //   93: aload_3
    //   94: invokeinterface 184 1 0
    //   99: checkcast 186	java/util/Map
    //   102: astore 4
    //   104: aload 4
    //   106: ldc 145
    //   108: invokeinterface 187 2 0
    //   113: checkcast 189	java/lang/String
    //   116: astore 5
    //   118: aload 4
    //   120: ldc 148
    //   122: invokeinterface 187 2 0
    //   127: checkcast 150	java/net/URL
    //   130: astore_1
    //   131: ldc_w 475
    //   134: aload_1
    //   135: invokevirtual 476	java/net/URL:toString	()Ljava/lang/String;
    //   138: invokestatic 482	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_2
    //   142: new 150	java/net/URL
    //   145: dup
    //   146: aload_2
    //   147: invokespecial 153	java/net/URL:<init>	(Ljava/lang/String;)V
    //   150: astore_2
    //   151: aload_2
    //   152: astore_1
    //   153: aload 4
    //   155: ldc 155
    //   157: invokeinterface 187 2 0
    //   162: checkcast 71	java/io/File
    //   165: astore_2
    //   166: aload_0
    //   167: getfield 44	com/tencent/mobileqq/leba/header/LebaGridShowManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   170: aload 5
    //   172: invokeinterface 494 2 0
    //   177: ifeq -93 -> 84
    //   180: aload_0
    //   181: aload 5
    //   183: aload_1
    //   184: aload_2
    //   185: invokevirtual 497	com/tencent/mobileqq/leba/header/LebaGridShowManager:a	(Ljava/lang/String;Ljava/net/URL;Ljava/io/File;)V
    //   188: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +30 -> 221
    //   194: ldc 169
    //   196: iconst_2
    //   197: new 62	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 566
    //   207: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 5
    //   212: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload 4
    //   223: ldc_w 320
    //   226: iconst_1
    //   227: invokestatic 325	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   230: invokeinterface 318 3 0
    //   235: pop
    //   236: goto -152 -> 84
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: aload_2
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    //   249: astore_2
    //   250: ldc 169
    //   252: iconst_1
    //   253: new 62	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 501
    //   263: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_2
    //   267: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: aload_2
    //   274: invokestatic 507	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: goto -124 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	LebaGridShowManager
    //   0	280	1	paramList	List
    //   249	25	2	localMalformedURLException	MalformedURLException
    //   83	11	3	localIterator	Iterator
    //   102	120	4	localMap	Map
    //   116	95	5	str	String
    // Exception table:
    //   from	to	target	type
    //   9	16	239	finally
    //   34	77	239	finally
    //   77	84	239	finally
    //   84	142	239	finally
    //   142	151	239	finally
    //   153	221	239	finally
    //   221	236	239	finally
    //   247	249	239	finally
    //   250	277	239	finally
    //   16	34	244	finally
    //   245	247	244	finally
    //   142	151	249	java/net/MalformedURLException
  }
  
  public boolean a()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)localIterator.next();
        if ((localLebaGridItemInfo != null) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == 905)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public List b(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)localIterator.next();
        if ((!a(localLebaGridItemInfo, paramQQAppInterface)) && ((localLebaGridItemInfo.jdField_a_of_type_Byte == 0) || (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == 0))) {
          localArrayList.add(localLebaGridItemInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public void b(DownloadIconsListener paramDownloadIconsListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramDownloadIconsListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramDownloadIconsListener);
      }
      return;
    }
  }
  
  public List c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.q)
    {
      Object localObject = a().a(paramQQAppInterface);
      paramQQAppInterface = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramQQAppInterface.add(((LebaGridItemInfo)((Iterator)localObject).next()).a());
      }
      return paramQQAppInterface;
    }
    return LebaShowListManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.LebaGridShowManager
 * JD-Core Version:    0.7.0.1
 */