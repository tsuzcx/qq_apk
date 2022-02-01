package com.tencent.mobileqq.subaccount.api.impl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.KeyValuePair;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class SubAccountControlServiceImpl
  implements ISubAccountControlService
{
  public static String DateFormate = "yyyy-MM-dd";
  public static long sTroopDelayTime = 600L;
  AppInterface app;
  ArrayList<KeyValuePair> associatedQQPairCache = new ArrayList();
  Lock cacheLock = new ReentrantLock();
  boolean isHeadIconLongClick = true;
  boolean isThirdQQDisplay = true;
  public boolean isThirdUnreadReqSkip = false;
  public long lastSpecialCareRequestTime = 0L;
  private ArrayList<QQCustomDialog> listDialog;
  ArrayList<Pair<String, Integer>> listWaittingHint;
  Lock lock = new ReentrantLock();
  Runnable mFetchSubAccountMsgRunnable = new SubAccountControlServiceImpl.2(this);
  Runnable mFetchSubAccountTroopMsgRunnable = new SubAccountControlServiceImpl.3(this);
  private long msgDelayTime = 300L;
  public long specialCareReqAdviseGap = 600L;
  private long thirdQQUnreadDelayTime = 300L;
  Runnable thirdQQUnreadRunable;
  
  public Pair<String, Integer> addHintPair(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addHintPair() subUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" type=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString != null) && (paramString.length() >= 5) && ((paramInt == 0) || (paramInt == 1)))
    {
      localObject = new Pair(paramString, Integer.valueOf(paramInt));
      this.lock.lock();
    }
    for (;;)
    {
      try
      {
        if (this.listWaittingHint != null)
        {
          paramInt = this.listWaittingHint.size() - 1;
          if (paramInt >= 0)
          {
            Pair localPair = (Pair)this.listWaittingHint.get(paramInt);
            if (!paramString.equals(localPair.first)) {
              break label273;
            }
            this.listWaittingHint.remove(paramInt);
            if (!QLog.isColorLevel()) {
              break label273;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("addHintPair() remove old, subUin=");
            localStringBuilder.append((String)localPair.first);
            localStringBuilder.append(" type=");
            localStringBuilder.append(localPair.second);
            QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
            break label273;
          }
        }
        if (this.listWaittingHint == null) {
          this.listWaittingHint = new ArrayList();
        }
        this.listWaittingHint.add(localObject);
        return localObject;
      }
      finally
      {
        this.lock.unlock();
      }
      return null;
      label273:
      paramInt -= 1;
    }
  }
  
  public void bindRecentItem(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    SubAccountControllUtil.a(paramAppInterface, paramString, paramInt);
  }
  
  /* Error */
  public void cancelHintDialog(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +53 -> 56
    //   6: new 94	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: ldc 186
    //   19: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 8
    //   25: aload_1
    //   26: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 8
    //   32: ldc 103
    //   34: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 8
    //   40: iload_2
    //   41: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 108
    //   47: iconst_2
    //   48: aload 8
    //   50: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_1
    //   57: ifnull +325 -> 382
    //   60: aload_1
    //   61: invokevirtual 122	java/lang/String:length	()I
    //   64: iconst_5
    //   65: if_icmpge +4 -> 69
    //   68: return
    //   69: aload_0
    //   70: getfield 49	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   73: invokeinterface 137 1 0
    //   78: aload_0
    //   79: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   82: ifnull +278 -> 360
    //   85: aload_0
    //   86: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   89: invokevirtual 142	java/util/ArrayList:size	()I
    //   92: iconst_1
    //   93: isub
    //   94: istore 4
    //   96: iload 4
    //   98: iflt +262 -> 360
    //   101: aload_0
    //   102: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   105: iload 4
    //   107: invokevirtual 146	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   110: checkcast 190	com/tencent/mobileqq/utils/QQCustomDialog
    //   113: astore 9
    //   115: aload 9
    //   117: ifnull +224 -> 341
    //   120: aload 9
    //   122: invokevirtual 194	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   125: astore 8
    //   127: aload 8
    //   129: ifnull +199 -> 328
    //   132: aload 8
    //   134: instanceof 124
    //   137: ifeq +191 -> 328
    //   140: aload 8
    //   142: checkcast 124	com/tencent/util/Pair
    //   145: astore 8
    //   147: iconst_0
    //   148: istore 6
    //   150: iload_3
    //   151: ifeq +41 -> 192
    //   154: iload 6
    //   156: istore 5
    //   158: aload_1
    //   159: aload 8
    //   161: getfield 150	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   164: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifeq +44 -> 211
    //   170: iload 6
    //   172: istore 5
    //   174: iload_2
    //   175: aload 8
    //   177: getfield 162	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   180: checkcast 126	java/lang/Integer
    //   183: invokevirtual 197	java/lang/Integer:intValue	()I
    //   186: if_icmpne +25 -> 211
    //   189: goto +199 -> 388
    //   192: iload 6
    //   194: istore 5
    //   196: aload_1
    //   197: aload 8
    //   199: getfield 150	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   202: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +6 -> 211
    //   208: goto +180 -> 388
    //   211: iload 5
    //   213: ifeq +138 -> 351
    //   216: aload 9
    //   218: invokevirtual 200	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   221: istore 7
    //   223: iload 7
    //   225: ifeq +8 -> 233
    //   228: aload 9
    //   230: invokevirtual 203	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   233: aload_0
    //   234: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   237: iload 4
    //   239: invokevirtual 157	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   242: pop
    //   243: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +105 -> 351
    //   249: new 94	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   256: astore 9
    //   258: aload 9
    //   260: ldc 205
    //   262: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 9
    //   268: aload 8
    //   270: getfield 150	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   273: checkcast 118	java/lang/String
    //   276: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 9
    //   282: ldc 103
    //   284: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 9
    //   290: aload 8
    //   292: getfield 162	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   295: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 9
    //   301: ldc 207
    //   303: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 9
    //   309: iload_3
    //   310: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: ldc 108
    //   316: iconst_2
    //   317: aload 9
    //   319: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: goto +26 -> 351
    //   328: aload_0
    //   329: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   332: iload 4
    //   334: invokevirtual 157	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   337: pop
    //   338: goto +13 -> 351
    //   341: aload_0
    //   342: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   345: iload 4
    //   347: invokevirtual 157	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   350: pop
    //   351: iload 4
    //   353: iconst_1
    //   354: isub
    //   355: istore 4
    //   357: goto -261 -> 96
    //   360: aload_0
    //   361: getfield 49	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   364: invokeinterface 171 1 0
    //   369: return
    //   370: astore_1
    //   371: aload_0
    //   372: getfield 49	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   375: invokeinterface 171 1 0
    //   380: aload_1
    //   381: athrow
    //   382: return
    //   383: astore 9
    //   385: goto -152 -> 233
    //   388: iconst_1
    //   389: istore 5
    //   391: goto -180 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	SubAccountControlServiceImpl
    //   0	394	1	paramString	String
    //   0	394	2	paramInt	int
    //   0	394	3	paramBoolean	boolean
    //   94	262	4	i	int
    //   156	234	5	j	int
    //   148	45	6	k	int
    //   221	3	7	bool	boolean
    //   13	278	8	localObject1	Object
    //   113	205	9	localObject2	Object
    //   383	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   78	96	370	finally
    //   101	115	370	finally
    //   120	127	370	finally
    //   132	147	370	finally
    //   158	170	370	finally
    //   174	189	370	finally
    //   196	208	370	finally
    //   216	223	370	finally
    //   228	233	370	finally
    //   233	325	370	finally
    //   328	338	370	finally
    //   341	351	370	finally
    //   228	233	383	java/lang/Exception
  }
  
  public void cancelTimedMsgTask(AppInterface paramAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelTimedMsgTask() app.isRunning=");
      Object localObject;
      if (paramAppInterface == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(paramAppInterface.isRunning());
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(" fetchMsgType=");
      localStringBuilder.append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    if (paramAppInterface != null)
    {
      if (!paramAppInterface.isRunning()) {
        return;
      }
      if (paramInt != 2) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mFetchSubAccountMsgRunnable);
      }
      if (paramInt != 1) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mFetchSubAccountTroopMsgRunnable);
      }
    }
  }
  
  public void clearAllData(AppInterface paramAppInterface, String paramString)
  {
    SubAccountControllUtil.a(paramAppInterface, paramString);
  }
  
  public String dealSysMsgContent(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramString1, paramInt, paramString2);
  }
  
  public void destoryHintDialog(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelUnbindDialog() act=");
      if (paramActivity == null) {
        localObject = "null";
      } else {
        localObject = paramActivity.getClass().getSimpleName();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    if (paramActivity == null) {
      return;
    }
    Object localObject = this.listDialog;
    int i;
    if (localObject != null) {
      i = ((ArrayList)localObject).size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        localObject = (QQCustomDialog)this.listDialog.get(i);
        if ((localObject != null) && (((QQCustomDialog)localObject).getOwnerActivity() == paramActivity) && (!((QQCustomDialog)localObject).isShowing())) {}
      }
      try
      {
        ((QQCustomDialog)localObject).dismiss();
        label119:
        this.listDialog.remove(i);
        break label140;
        this.listDialog.remove(i);
        label140:
        i -= 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label119;
      }
    }
  }
  
  KeyValuePair findAssociatedQQCacheItemByKey(String paramString)
  {
    Object localObject = this.associatedQQPairCache;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        int j = ((ArrayList)localObject).size();
        int i = 0;
        if (i < j)
        {
          if (i < this.associatedQQPairCache.size())
          {
            localObject = (KeyValuePair)this.associatedQQPairCache.get(i);
            if (localObject != null)
            {
              boolean bool = TextUtils.equals(((KeyValuePair)localObject).jdField_a_of_type_JavaLangString, paramString);
              if (bool) {
                return localObject;
              }
            }
            i += 1;
          }
        }
        else {
          return null;
        }
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" findAssociatedQQCacheItemByKey error: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.i("SUB_ACCOUNT", 1, ((StringBuilder)localObject).toString());
      }
      localObject = null;
    }
  }
  
  public int getAssociatedQQCacheInt(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.app;
      if (localObject != null)
      {
        if (((AppInterface)localObject).getApp() == null) {
          return 0;
        }
        this.cacheLock.lock();
        try
        {
          localObject = findAssociatedQQCacheItemByKey(paramString);
          int i;
          if (localObject != null)
          {
            i = ((Integer)((KeyValuePair)localObject).jdField_a_of_type_JavaLangObject).intValue();
            return i;
          }
          localObject = this.app.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
          if (localObject != null)
          {
            i = ((SharedPreferences)localObject).getInt(paramString, 0);
            if (this.associatedQQPairCache != null) {
              this.associatedQQPairCache.add(new KeyValuePair(paramString, Integer.valueOf(i)));
            }
            return i;
          }
          return 0;
        }
        finally
        {
          this.cacheLock.unlock();
        }
      }
    }
    return 0;
  }
  
  public String getAssociatedQQCacheString(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.app;
      if (localObject != null)
      {
        if (((AppInterface)localObject).getApp() == null) {
          return "";
        }
        this.cacheLock.lock();
        try
        {
          localObject = findAssociatedQQCacheItemByKey(paramString);
          if (localObject != null)
          {
            paramString = (String)((KeyValuePair)localObject).jdField_a_of_type_JavaLangObject;
            return paramString;
          }
          localObject = this.app.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
          if (localObject != null)
          {
            localObject = ((SharedPreferences)localObject).getString(paramString, "");
            if (this.associatedQQPairCache != null) {
              this.associatedQQPairCache.add(new KeyValuePair(paramString, localObject));
            }
            return localObject;
          }
          return "";
        }
        finally
        {
          this.cacheLock.unlock();
        }
      }
    }
    return "";
  }
  
  public String getDateFormate()
  {
    return DateFormate;
  }
  
  public boolean getIsThirdUnreadReqSkip()
  {
    return this.isThirdUnreadReqSkip;
  }
  
  public long getLastSpecialCareRequestTime()
  {
    return this.lastSpecialCareRequestTime;
  }
  
  public int getReqSubAccountSpecialCareListSysTime(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramString1, paramString2);
  }
  
  public long getSpecialCareReqAdviseGap()
  {
    return this.specialCareReqAdviseGap;
  }
  
  public void getSubAccountSpecialCareList(ArrayList<String> paramArrayList, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.app.getCurrentUin());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_spcares");
    paramString = ((StringBuilder)localObject).toString();
    this.cacheLock.lock();
    try
    {
      localObject = findAssociatedQQCacheItemByKey(paramString);
      if (localObject != null)
      {
        paramArrayList.addAll((ArrayList)((KeyValuePair)localObject).jdField_a_of_type_JavaLangObject);
        break label191;
      }
      localObject = this.app.getApp();
      i = 0;
      localObject = ((BaseApplication)localObject).getSharedPreferences("qq_subaccount_associated_cache", 0).getString(paramString, "").split(";");
      if ((localObject == null) || (i >= localObject.length)) {
        break label174;
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        label174:
        label191:
        this.cacheLock.unlock();
        for (;;)
        {
          throw paramArrayList;
        }
        i += 1;
      }
    }
    if ((!TextUtils.isEmpty(localObject[i])) && (!TextUtils.equals("0", localObject[i])))
    {
      paramArrayList.add(localObject[i]);
      break label219;
      this.associatedQQPairCache.add(new KeyValuePair(paramString, paramArrayList));
      this.cacheLock.unlock();
      return;
    }
  }
  
  public byte[] getThirdQQUnreadNumReqCookie(AppInterface paramAppInterface, String paramString)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramString);
  }
  
  public long getsTroopDelayTime()
  {
    return sTroopDelayTime;
  }
  
  public boolean handleListWaittingHint(String paramString)
  {
    Object localObject1 = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, "");
    if (localObject1 != null) {
      localObject1 = ((ISubAccountService)localObject1).getAllSubUin();
    } else {
      localObject1 = null;
    }
    this.lock.lock();
    try
    {
      localObject2 = this.listWaittingHint;
      bool1 = true;
      if ((localObject2 == null) || (this.listWaittingHint.size() <= 0)) {
        break label252;
      }
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label176;
      }
      i = this.listWaittingHint.size() - 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        boolean bool1;
        int i;
        label176:
        label252:
        label254:
        this.lock.unlock();
        for (;;)
        {
          throw paramString;
        }
        i -= 1;
      }
    }
    if (i >= 0)
    {
      localObject2 = (Pair)this.listWaittingHint.get(i);
      if (((ArrayList)localObject1).contains(((Pair)localObject2).first))
      {
        if (((Integer)((Pair)localObject2).second).intValue() == 1) {
          this.listWaittingHint.remove(i);
        }
      }
      else if (((Integer)((Pair)localObject2).second).intValue() == 0) {
        this.listWaittingHint.remove(i);
      }
    }
    else
    {
      if ((this.listWaittingHint != null) && (this.listWaittingHint.size() > 0))
      {
        if (!"sub.uin.all".equals(paramString))
        {
          localObject1 = this.listWaittingHint.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            boolean bool2 = paramString.equals(((Pair)((Iterator)localObject1).next()).first);
            if (bool2) {
              break label254;
            }
          }
        }
      }
      else {
        bool1 = false;
      }
      this.lock.unlock();
      return bool1;
    }
  }
  
  public boolean isHeadIconLongClickFunc(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.aio_config.name());
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("aioConfig:");
        localStringBuilder.append((String)localObject);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 11) && (!TextUtils.isEmpty(localObject[11])))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("subAccountConfig:");
            localStringBuilder.append(localObject[11]);
            QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
          }
          localObject = localObject[11].split("_");
          if ((localObject != null) && (localObject.length > 0) && (TextUtils.equals("1", localObject[0]))) {
            this.isHeadIconLongClick = true;
          } else {
            this.isHeadIconLongClick = false;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isHeadIconLongClickFunc isHeadIconLongClick=");
      ((StringBuilder)localObject).append(this.isHeadIconLongClick);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    return this.isHeadIconLongClick;
  }
  
  public void launchTimedMsgTask(AppInterface paramAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchTimedMsgTask() app.isRunning=");
      Object localObject;
      if (paramAppInterface == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(paramAppInterface.isRunning());
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(" fetchMsgType=");
      localStringBuilder.append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    if (paramAppInterface != null)
    {
      if (!paramAppInterface.isRunning()) {
        return;
      }
      cancelTimedMsgTask(paramAppInterface, paramInt);
      if (paramInt != 2) {
        ThreadManager.getSubThreadHandler().postDelayed(this.mFetchSubAccountMsgRunnable, this.msgDelayTime * 1000L);
      }
      if (paramInt != 1) {
        ThreadManager.getSubThreadHandler().postDelayed(this.mFetchSubAccountTroopMsgRunnable, sTroopDelayTime * 1000L);
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("launchTimedMsgTask() schedule msgTimer after ");
        paramAppInterface.append(this.msgDelayTime);
        paramAppInterface.append("*1000 ms.");
        QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
      }
    }
  }
  
  public void launchTimedThirdQQUnreadNumTask(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      if (!paramAppInterface.isRunning()) {
        return;
      }
      if (this.thirdQQUnreadRunable != null) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.thirdQQUnreadRunable);
      }
      if (this.thirdQQUnreadRunable == null) {
        this.thirdQQUnreadRunable = new SubAccountControlServiceImpl.4(this, paramAppInterface);
      }
      ThreadManager.getSubThreadHandler().postDelayed(this.thirdQQUnreadRunable, this.thirdQQUnreadDelayTime * 1000L);
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("launchTimedThirdQQUnreadNumTask() next req after ");
        paramAppInterface.append(this.thirdQQUnreadDelayTime);
        paramAppInterface.append("s.");
        QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((AppInterface)paramAppRuntime);
    this.associatedQQPairCache.clear();
    try
    {
      paramAppRuntime = Settings.System.getString(BaseApplication.getContext().getContentResolver(), "date_format");
      if (!TextUtils.isEmpty(paramAppRuntime)) {
        DateFormate = paramAppRuntime;
      }
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
    try
    {
      paramAppRuntime = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getServerConfigValue(ServerConfigManager.ConfigType.common, "subaccountMsgFreq");
      if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramAppRuntime)))
      {
        this.msgDelayTime = Long.parseLong(paramAppRuntime);
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("init msgDelayTime = ");
          paramAppRuntime.append(this.msgDelayTime);
          QLog.d("SUB_ACCOUNT", 2, paramAppRuntime.toString());
        }
      }
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(this.app.getCurrentUin());
      paramAppRuntime.append("_unread_msg_num_interval");
      int i = getAssociatedQQCacheInt(paramAppRuntime.toString());
      if (i != 0)
      {
        updateThirdQQUnreadDelayTime(i);
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    this.lock.lock();
    try
    {
      if (this.listDialog != null) {
        localObject1 = this.listDialog.iterator();
      }
      for (;;)
      {
        QQCustomDialog localQQCustomDialog;
        if (((Iterator)localObject1).hasNext()) {
          localQQCustomDialog = (QQCustomDialog)((Iterator)localObject1).next();
        }
        try
        {
          if (localQQCustomDialog.isShowing()) {
            localQQCustomDialog.dismiss();
          }
        }
        catch (Exception localException) {}
      }
      this.listDialog.clear();
      this.listDialog = null;
      if (this.listWaittingHint != null) {
        this.listWaittingHint.clear();
      }
      this.listWaittingHint = null;
      this.lock.unlock();
      ThreadManager.getSubThreadHandler().removeCallbacks(this.mFetchSubAccountMsgRunnable);
      ThreadManager.getSubThreadHandler().removeCallbacks(this.mFetchSubAccountTroopMsgRunnable);
      if (this.thirdQQUnreadRunable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.thirdQQUnreadRunable);
        this.thirdQQUnreadRunable = null;
      }
      Object localObject1 = this.associatedQQPairCache;
      if (localObject1 != null) {
        ((ArrayList)localObject1).clear();
      }
      return;
    }
    finally
    {
      for (;;)
      {
        this.lock.unlock();
        for (;;)
        {
          throw localObject2;
        }
      }
    }
  }
  
  public ArrayList<Pair<String, Integer>> popWaittingHintPair(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("popWaittingHintPair() subUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    if (paramString == null) {
      return localObject;
    }
    this.lock.lock();
    try
    {
      if (this.listWaittingHint != null) {
        if ("sub.uin.all".equals(paramString))
        {
          ((ArrayList)localObject).addAll(this.listWaittingHint);
          this.listWaittingHint.clear();
        }
        else
        {
          int i = this.listWaittingHint.size() - 1;
          while (i >= 0)
          {
            Pair localPair = (Pair)this.listWaittingHint.get(i);
            if (paramString.equals(localPair.first))
            {
              ((ArrayList)localObject).add(localPair);
              this.listWaittingHint.remove(i);
            }
            i -= 1;
          }
        }
      }
      this.lock.unlock();
      return localObject;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean putAssociatedQQCache(String paramString, Object paramObject)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.app;
      if (localObject != null)
      {
        if (((AppInterface)localObject).getApp() == null) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("putAssociatedQQCache key=");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" value=");
          ((StringBuilder)localObject).append(paramObject);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
        }
        this.cacheLock.lock();
      }
    }
    for (;;)
    {
      try
      {
        localObject = this.associatedQQPairCache;
        boolean bool3 = true;
        bool1 = true;
        boolean bool2 = bool3;
        if (localObject != null)
        {
          localObject = findAssociatedQQCacheItemByKey(paramString);
          if (localObject == null)
          {
            this.associatedQQPairCache.add(new KeyValuePair(paramString, paramObject));
            bool2 = bool3;
          }
          else
          {
            if (((paramObject instanceof Integer)) && ((((KeyValuePair)localObject).jdField_a_of_type_JavaLangObject instanceof Integer))) {
              if ((Integer)((KeyValuePair)localObject).jdField_a_of_type_JavaLangObject == (Integer)paramObject) {
                break label360;
              }
            } else {
              if ((!(paramObject instanceof String)) || (!(((KeyValuePair)localObject).jdField_a_of_type_JavaLangObject instanceof String)) || (TextUtils.equals((String)((KeyValuePair)localObject).jdField_a_of_type_JavaLangObject, (String)paramObject))) {
                break label360;
              }
            }
            bool2 = bool1;
            if (bool1)
            {
              ((KeyValuePair)localObject).jdField_a_of_type_JavaLangObject = paramObject;
              bool2 = bool1;
            }
          }
        }
        this.cacheLock.unlock();
        if (bool2)
        {
          localObject = this.app.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
          if (localObject != null)
          {
            if ((paramObject instanceof Integer))
            {
              ((SharedPreferences)localObject).edit().putInt(paramString, ((Integer)paramObject).intValue()).commit();
              return bool2;
            }
            if ((paramObject instanceof String)) {
              ((SharedPreferences)localObject).edit().putString(paramString, (String)paramObject).commit();
            }
          }
        }
        return bool2;
      }
      finally
      {
        this.cacheLock.unlock();
      }
      return false;
      label360:
      boolean bool1 = false;
    }
  }
  
  boolean requestThirdQQUnreadMsgNum(AppInterface paramAppInterface, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInterface != null)
    {
      if (!paramAppInterface.isRunning()) {
        return false;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = paramAppInterface.getApplication().getAllAccounts();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
      Object localObject3 = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      bool1 = bool2;
      if (((List)localObject2).size() >= 1)
      {
        bool1 = bool2;
        if (localObject3 != null)
        {
          localObject1 = new ArrayList();
          String str = paramAppInterface.getCurrentUin();
          localObject3 = ((ISubAccountService)localObject3).getAllSubUin();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
            if ((localSimpleAccount != null) && (!TextUtils.isEmpty(localSimpleAccount.getUin())) && (!localSimpleAccount.getUin().equals(str)) && (!((List)localObject3).contains(localSimpleAccount.getUin())) && (localSimpleAccount.isLogined())) {
              ((ArrayList)localObject1).add(localSimpleAccount);
            }
          }
          bool1 = bool2;
          if (((ArrayList)localObject1).size() > 0)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("requestThirdQQUnreadMsgNum() really start get other qq unread message mainUin=");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append(" isCronJob=");
              ((StringBuilder)localObject2).append(paramBoolean);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
            }
            paramAppInterface = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getProcessor(paramAppInterface);
            if (paramAppInterface != null) {
              paramAppInterface.a(paramBoolean, (ArrayList)localObject1);
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void setBindUinStatus(AppInterface paramAppInterface, byte paramByte, String paramString)
  {
    SubAccountControllUtil.a(paramAppInterface, paramByte, paramString);
  }
  
  public void setDateFormate(String paramString)
  {
    DateFormate = paramString;
  }
  
  public void setIsThirdUnreadReqSkip(boolean paramBoolean)
  {
    this.isThirdUnreadReqSkip = paramBoolean;
  }
  
  public void setLastSpecialCareRequestTime(long paramLong)
  {
    this.lastSpecialCareRequestTime = paramLong;
  }
  
  public void setTroopDelayTime(long paramLong)
  {
    sTroopDelayTime = paramLong;
  }
  
  /* Error */
  public void showHintDialog(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, Pair<String, Integer> paramPair, android.content.DialogInterface.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +207 -> 210
    //   6: new 94	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   13: astore 10
    //   15: aload 10
    //   17: ldc_w 592
    //   20: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 216
    //   26: astore 9
    //   28: aload_3
    //   29: ifnonnull +10 -> 39
    //   32: ldc 216
    //   34: astore 8
    //   36: goto +51 -> 87
    //   39: new 94	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   46: astore 8
    //   48: aload 8
    //   50: aload_3
    //   51: getfield 150	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   54: checkcast 118	java/lang/String
    //   57: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 8
    //   63: ldc_w 594
    //   66: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 8
    //   72: aload_3
    //   73: getfield 162	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   76: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 8
    //   82: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 8
    //   87: aload 10
    //   89: aload 8
    //   91: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 10
    //   97: ldc_w 596
    //   100: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: ifnonnull +10 -> 115
    //   108: ldc 216
    //   110: astore 8
    //   112: goto +12 -> 124
    //   115: aload_2
    //   116: invokevirtual 256	java/lang/Object:getClass	()Ljava/lang/Class;
    //   119: invokevirtual 261	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   122: astore 8
    //   124: aload 10
    //   126: aload 8
    //   128: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 10
    //   134: ldc_w 598
    //   137: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: ifnonnull +10 -> 152
    //   145: ldc 216
    //   147: astore 8
    //   149: goto +8 -> 157
    //   152: ldc_w 600
    //   155: astore 8
    //   157: aload 10
    //   159: aload 8
    //   161: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 10
    //   167: ldc_w 602
    //   170: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 4
    //   176: ifnonnull +10 -> 186
    //   179: aload 9
    //   181: astore 8
    //   183: goto +8 -> 191
    //   186: ldc_w 600
    //   189: astore 8
    //   191: aload 10
    //   193: aload 8
    //   195: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: ldc 108
    //   201: iconst_2
    //   202: aload 10
    //   204: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_1
    //   211: ifnull +400 -> 611
    //   214: aload_2
    //   215: ifnull +396 -> 611
    //   218: aload_3
    //   219: ifnull +392 -> 611
    //   222: aload 4
    //   224: ifnonnull +4 -> 228
    //   227: return
    //   228: aload_3
    //   229: getfield 150	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   232: checkcast 118	java/lang/String
    //   235: astore 8
    //   237: aload_3
    //   238: getfield 162	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   241: checkcast 126	java/lang/Integer
    //   244: invokevirtual 197	java/lang/Integer:intValue	()I
    //   247: istore 6
    //   249: aload_0
    //   250: getfield 49	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   253: invokeinterface 137 1 0
    //   258: aload_0
    //   259: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   262: ifnull +151 -> 413
    //   265: aload_0
    //   266: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   269: invokevirtual 142	java/util/ArrayList:size	()I
    //   272: iconst_1
    //   273: isub
    //   274: istore 5
    //   276: iload 5
    //   278: iflt +135 -> 413
    //   281: aload_0
    //   282: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   285: iload 5
    //   287: invokevirtual 146	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   290: checkcast 190	com/tencent/mobileqq/utils/QQCustomDialog
    //   293: astore 10
    //   295: aload 10
    //   297: ifnull +320 -> 617
    //   300: aload 10
    //   302: invokevirtual 194	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   305: instanceof 124
    //   308: ifeq +309 -> 617
    //   311: aload 10
    //   313: invokevirtual 194	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   316: checkcast 124	com/tencent/util/Pair
    //   319: astore 9
    //   321: aload 8
    //   323: aload 9
    //   325: getfield 150	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   328: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifeq +286 -> 617
    //   334: aload 10
    //   336: invokevirtual 200	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   339: istore 7
    //   341: iload 7
    //   343: ifeq +8 -> 351
    //   346: aload 10
    //   348: invokevirtual 203	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   351: aload_0
    //   352: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   355: iload 5
    //   357: invokevirtual 157	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   360: pop
    //   361: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +253 -> 617
    //   367: new 94	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   374: astore 10
    //   376: aload 10
    //   378: ldc_w 604
    //   381: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 10
    //   387: aload 9
    //   389: getfield 150	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   392: checkcast 118	java/lang/String
    //   395: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: ldc 108
    //   401: iconst_2
    //   402: aload 10
    //   404: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto +207 -> 617
    //   413: aload_2
    //   414: ldc_w 605
    //   417: invokevirtual 610	com/tencent/mobileqq/app/QBaseActivity:getString	(I)Ljava/lang/String;
    //   420: astore 10
    //   422: ldc_w 612
    //   425: invokestatic 404	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   428: checkcast 612	com/tencent/mobileqq/utils/api/IContactUtils
    //   431: aload_1
    //   432: aload 8
    //   434: iconst_0
    //   435: invokeinterface 616 4 0
    //   440: astore 9
    //   442: aload 9
    //   444: ifnull +182 -> 626
    //   447: aload 9
    //   449: astore_1
    //   450: aload 9
    //   452: invokevirtual 122	java/lang/String:length	()I
    //   455: ifne +6 -> 461
    //   458: goto +168 -> 626
    //   461: iload 6
    //   463: ifne +22 -> 485
    //   466: aload_2
    //   467: ldc_w 617
    //   470: iconst_1
    //   471: anewarray 4	java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: aload_1
    //   477: aastore
    //   478: invokevirtual 620	com/tencent/mobileqq/app/QBaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   481: astore_1
    //   482: goto +19 -> 501
    //   485: aload_2
    //   486: ldc_w 621
    //   489: iconst_1
    //   490: anewarray 4	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: aload_1
    //   496: aastore
    //   497: invokevirtual 620	com/tencent/mobileqq/app/QBaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   500: astore_1
    //   501: aload_2
    //   502: sipush 230
    //   505: invokestatic 626	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   508: aload 10
    //   510: invokevirtual 630	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   513: aload_1
    //   514: invokevirtual 634	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   517: astore_1
    //   518: aload_1
    //   519: aload_3
    //   520: invokevirtual 638	com/tencent/mobileqq/utils/QQCustomDialog:setTag	(Ljava/lang/Object;)V
    //   523: aload_1
    //   524: aload_2
    //   525: invokevirtual 641	com/tencent/mobileqq/utils/QQCustomDialog:setOwnerActivity	(Landroid/app/Activity;)V
    //   528: aload_1
    //   529: aload_2
    //   530: ldc_w 642
    //   533: invokevirtual 610	com/tencent/mobileqq/app/QBaseActivity:getString	(I)Ljava/lang/String;
    //   536: aload 4
    //   538: invokevirtual 646	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   541: pop
    //   542: aload_1
    //   543: new 648	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl$1
    //   546: dup
    //   547: aload_0
    //   548: aload 8
    //   550: iload 6
    //   552: invokespecial 651	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl$1:<init>	(Lcom/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl;Ljava/lang/String;I)V
    //   555: invokevirtual 655	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   558: aload_1
    //   559: invokevirtual 658	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   562: aload_0
    //   563: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   566: ifnonnull +14 -> 580
    //   569: aload_0
    //   570: new 67	java/util/ArrayList
    //   573: dup
    //   574: invokespecial 68	java/util/ArrayList:<init>	()V
    //   577: putfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   580: aload_0
    //   581: getfield 188	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:listDialog	Ljava/util/ArrayList;
    //   584: aload_1
    //   585: invokevirtual 168	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   588: pop
    //   589: aload_0
    //   590: getfield 49	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   593: invokeinterface 171 1 0
    //   598: return
    //   599: astore_1
    //   600: aload_0
    //   601: getfield 49	com/tencent/mobileqq/subaccount/api/impl/SubAccountControlServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   604: invokeinterface 171 1 0
    //   609: aload_1
    //   610: athrow
    //   611: return
    //   612: astore 10
    //   614: goto -263 -> 351
    //   617: iload 5
    //   619: iconst_1
    //   620: isub
    //   621: istore 5
    //   623: goto -347 -> 276
    //   626: aload 8
    //   628: astore_1
    //   629: goto -168 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	this	SubAccountControlServiceImpl
    //   0	632	1	paramAppInterface	AppInterface
    //   0	632	2	paramQBaseActivity	QBaseActivity
    //   0	632	3	paramPair	Pair<String, Integer>
    //   0	632	4	paramOnClickListener	android.content.DialogInterface.OnClickListener
    //   274	348	5	i	int
    //   247	304	6	j	int
    //   339	3	7	bool	boolean
    //   34	593	8	localObject1	Object
    //   26	425	9	localObject2	Object
    //   13	496	10	localObject3	Object
    //   612	1	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   258	276	599	finally
    //   281	295	599	finally
    //   300	341	599	finally
    //   346	351	599	finally
    //   351	410	599	finally
    //   413	442	599	finally
    //   450	458	599	finally
    //   466	482	599	finally
    //   485	501	599	finally
    //   501	580	599	finally
    //   580	589	599	finally
    //   346	351	612	java/lang/Exception
  }
  
  public boolean startGetThirdQQUnreadNum(boolean paramBoolean)
  {
    boolean bool2 = this.isThirdQQDisplay;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (QBaseActivity.mAppForground)
    {
      bool1 = requestThirdQQUnreadMsgNum(this.app, paramBoolean);
      paramBoolean = bool1;
      if (bool1)
      {
        launchTimedThirdQQUnreadNumTask(this.app);
        paramBoolean = bool1;
      }
    }
    else
    {
      this.isThirdUnreadReqSkip = true;
      paramBoolean = bool1;
    }
    if ((!paramBoolean) && (this.thirdQQUnreadRunable != null)) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.thirdQQUnreadRunable);
    }
    return paramBoolean;
  }
  
  public void storeSubAccountSpecialCareList(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("_spcares");
    paramString1 = ((StringBuilder)localObject).toString();
    this.cacheLock.lock();
    try
    {
      paramString2 = findAssociatedQQCacheItemByKey(paramString1);
      if ((paramString2 != null) && (paramString2.jdField_a_of_type_JavaLangObject != null) && ((paramString2.jdField_a_of_type_JavaLangObject instanceof ArrayList)))
      {
        paramString2 = (ArrayList)paramString2.jdField_a_of_type_JavaLangObject;
        paramString2.clear();
        paramString2.addAll(paramArrayList);
      }
      else
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).addAll(paramArrayList);
        if (paramString2 != null) {
          paramString2.jdField_a_of_type_JavaLangObject = localObject;
        } else {
          this.associatedQQPairCache.add(new KeyValuePair(paramString1, localObject));
        }
      }
      this.cacheLock.unlock();
      paramString2 = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (i > 0) {
          paramString2.append(";");
        }
        paramString2.append((String)paramArrayList.get(i));
        i += 1;
      }
      this.app.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0).edit().putString(paramString1, paramString2.toString()).commit();
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_sysTime");
      putAssociatedQQCache(paramString2.toString(), Integer.valueOf(paramInt1));
      this.specialCareReqAdviseGap = paramInt2;
      return;
    }
    finally
    {
      this.cacheLock.unlock();
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void storeThirdQQUnreadInfo(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramString1 = new StringBuilder();
    paramString1.append(this.app.getCurrentUin());
    paramString1.append("_");
    paramString1.append(paramString2);
    paramString1 = paramString1.toString();
    paramString2 = PkgTools.toHexStr(paramArrayOfByte);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(paramString1);
      paramArrayOfByte.append("_last_cookie");
      putAssociatedQQCache(paramArrayOfByte.toString(), paramString2);
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_msgNum");
    putAssociatedQQCache(paramString2.toString(), Integer.valueOf(paramInt1));
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_msgFlag");
    putAssociatedQQCache(paramString2.toString(), Integer.valueOf(paramInt2));
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_redBagTime");
    putAssociatedQQCache(paramString2.toString(), Integer.valueOf(paramInt3));
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_status");
    putAssociatedQQCache(paramString2.toString(), Integer.valueOf(paramInt4));
    if (paramInt5 != 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_lastMsgTime");
      putAssociatedQQCache(paramString2.toString(), Integer.valueOf(paramInt5));
    }
  }
  
  public void storeThirdQQUnreadMsgNumInterval(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    SubAccountControllUtil.b(paramAppInterface, paramString, paramInt);
  }
  
  public void updateThirdQQUnreadDelayTime(int paramInt)
  {
    long l = paramInt;
    if (l > 86400L)
    {
      this.thirdQQUnreadDelayTime = 86400L;
      return;
    }
    if (l < 60L)
    {
      this.thirdQQUnreadDelayTime = 60L;
      return;
    }
    this.thirdQQUnreadDelayTime = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl
 * JD-Core Version:    0.7.0.1
 */