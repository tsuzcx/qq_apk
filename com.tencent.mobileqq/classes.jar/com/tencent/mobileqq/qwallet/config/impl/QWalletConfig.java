package com.tencent.mobileqq.qwallet.config.impl;

import Wallet.RspWalletConfig;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigListener;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QWalletConfig
  implements Serializable
{
  private static final byte[] h = new byte[0];
  private static final long serialVersionUID = 1L;
  private transient String a;
  private int action = 0;
  private transient String b;
  private transient Map<String, List<IQWalletConfigService.ConfigUpdateListener>> c;
  public String commonMsg;
  public Map<String, String> configs = new HashMap();
  private transient byte[] d;
  private transient byte[] e;
  private transient Map<String, Object> f;
  private transient int g = 0;
  public int lastAppId;
  public long lastReqTime;
  private Map<Long, Long> lastReqTimes = new HashMap();
  private Map<String, Long> localVersions = new HashMap();
  public int refreshTime;
  private Map<Long, Integer> refreshTimes = new HashMap();
  public int refreshType;
  public long seriesNo;
  
  private static String a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramAppRuntime.getAccount())))
    {
      StringBuilder localStringBuilder = new StringBuilder(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
      localStringBuilder.append(paramAppRuntime.getAccount());
      localStringBuilder.append("/.config/");
      localStringBuilder.append(".config");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private void a(long paramLong)
  {
    this.lastReqTime = paramLong;
    Iterator localIterator = this.lastReqTimes.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.lastReqTimes.put(localEntry.getKey(), Long.valueOf(paramLong));
    }
  }
  
  private void a(long paramLong1, long paramLong2, RspWalletConfig paramRspWalletConfig)
  {
    long l2 = 1L;
    long l1 = paramLong2;
    paramLong2 = l2;
    while (l1 != 0L) {
      if ((paramLong2 & l1) != 0L)
      {
        this.lastReqTimes.put(Long.valueOf(paramLong2), Long.valueOf(paramLong1));
        this.refreshTimes.put(Long.valueOf(paramLong2), Integer.valueOf(paramRspWalletConfig.refreshTime));
        l1 &= (0xFFFFFFFF ^ paramLong2);
        paramLong2 <<= 1;
      }
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    this.a = paramString;
    if (paramBaseQQAppInterface != null) {
      paramBaseQQAppInterface = paramBaseQQAppInterface.getCurrentAccountUin();
    } else {
      paramBaseQQAppInterface = "";
    }
    this.b = paramBaseQQAppInterface;
    this.c = new HashMap();
    this.f = new ConcurrentHashMap();
    this.d = new byte[0];
    this.e = new byte[0];
    if (this.localVersions == null) {
      this.localVersions = new HashMap();
    }
  }
  
  private void a(Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    try
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = this.e;
      if ((!paramBoolean) || (paramMap != null)) {}
      for (;;)
      {
        try
        {
          Iterator localIterator = this.configs.entrySet().iterator();
          Object localObject2;
          if (localIterator.hasNext())
          {
            localObject2 = (Map.Entry)localIterator.next();
            if (!paramMap.containsKey(((Map.Entry)localObject2).getKey())) {
              localLinkedList.add(((Map.Entry)localObject2).getKey());
            }
          }
          else
          {
            localIterator = localLinkedList.iterator();
            if (localIterator.hasNext())
            {
              localObject2 = (String)localIterator.next();
              this.localVersions.put(localObject2, Long.valueOf(paramLong));
            }
            else
            {
              this.configs.clear();
              if (paramMap != null)
              {
                localIterator = paramMap.entrySet().iterator();
                if (localIterator.hasNext())
                {
                  localObject2 = (Map.Entry)localIterator.next();
                  this.configs.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
                  this.localVersions.put(((Map.Entry)localObject2).getKey(), Long.valueOf(paramLong));
                  continue;
                }
              }
              localObject1 = paramMap;
              if (paramBoolean)
              {
                localObject1 = paramMap;
                if (localLinkedList.size() > 0)
                {
                  localObject1 = new HashMap(paramMap);
                  paramMap = localLinkedList.iterator();
                  if (!paramMap.hasNext()) {
                    break label368;
                  }
                  ((Map)localObject1).put((String)paramMap.next(), null);
                  continue;
                }
              }
              b((Map)localObject1, paramBoolean, paramLong);
              return;
            }
          }
        }
        finally {}
      }
    }
    catch (Throwable paramMap)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateConfig throwable|");
        ((StringBuilder)localObject1).append(paramMap.getMessage());
        QLog.e("QWalletConfig", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  private void b(Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      Map.Entry localEntry;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        QWalletConfigHandler.a(this.b, (String)localEntry.getKey(), (String)localEntry.getValue());
      }
      if (paramBoolean)
      {
        this.f.clear();
      }
      else
      {
        localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          this.f.remove(localEntry.getKey());
        }
      }
      notifyUpdateListeners(paramMap, paramLong);
    }
  }
  
  /* Error */
  public static QWalletConfig readConfig(BaseQQAppInterface paramBaseQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 249	com/tencent/mobileqq/qwallet/config/impl/QWalletConfig:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   4: astore 5
    //   6: aload 5
    //   8: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore_1
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore_3
    //   19: iload_1
    //   20: ifne +56 -> 76
    //   23: aload 4
    //   25: astore_2
    //   26: getstatic 43	com/tencent/mobileqq/qwallet/config/impl/QWalletConfig:h	[B
    //   29: astore 6
    //   31: aload 4
    //   33: astore_2
    //   34: aload 6
    //   36: monitorenter
    //   37: aload 5
    //   39: invokestatic 254	com/tencent/mobileqq/qwallet/impl/QWalletTools:e	(Ljava/lang/String;)Ljava/lang/Object;
    //   42: checkcast 2	com/tencent/mobileqq/qwallet/config/impl/QWalletConfig
    //   45: astore_2
    //   46: aload 6
    //   48: monitorexit
    //   49: goto +27 -> 76
    //   52: astore_3
    //   53: aload_3
    //   54: astore 4
    //   56: goto +7 -> 63
    //   59: astore 4
    //   61: aload_3
    //   62: astore_2
    //   63: aload_2
    //   64: astore_3
    //   65: aload 6
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    //   71: astore_3
    //   72: aload_3
    //   73: invokevirtual 257	java/lang/Exception:printStackTrace	()V
    //   76: aload_2
    //   77: astore_3
    //   78: aload_2
    //   79: ifnonnull +11 -> 90
    //   82: new 2	com/tencent/mobileqq/qwallet/config/impl/QWalletConfig
    //   85: dup
    //   86: invokespecial 258	com/tencent/mobileqq/qwallet/config/impl/QWalletConfig:<init>	()V
    //   89: astore_3
    //   90: aload_3
    //   91: aload_0
    //   92: aload 5
    //   94: invokespecial 260	com/tencent/mobileqq/qwallet/config/impl/QWalletConfig:a	(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/String;)V
    //   97: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +35 -> 135
    //   103: new 77	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   110: astore_0
    //   111: aload_0
    //   112: ldc_w 262
    //   115: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: aload_3
    //   121: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: ldc 221
    //   127: iconst_2
    //   128: aload_0
    //   129: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_3
    //   136: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramBaseQQAppInterface	BaseQQAppInterface
    //   11	9	1	bool	boolean
    //   16	63	2	localObject1	Object
    //   18	1	3	localObject2	Object
    //   64	1	3	localObject4	Object
    //   71	2	3	localException	java.lang.Exception
    //   77	59	3	localObject5	Object
    //   13	42	4	localObject6	Object
    //   59	10	4	localObject7	Object
    //   4	89	5	str	String
    //   29	37	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   46	49	52	finally
    //   37	46	59	finally
    //   65	68	59	finally
    //   26	31	71	java/lang/Exception
    //   34	37	71	java/lang/Exception
    //   68	71	71	java/lang/Exception
  }
  
  public void addUpdateListener(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    synchronized (this.d)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramConfigUpdateListener != null))
      {
        List localList = (List)this.c.get(paramString);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          this.c.put(paramString, localObject);
        }
        if (!((List)localObject).contains(paramConfigUpdateListener)) {
          ((List)localObject).add(paramConfigUpdateListener);
        }
      }
      return;
    }
  }
  
  public String getConfig(String paramString)
  {
    synchronized (this.e)
    {
      paramString = (String)this.configs.get(paramString);
      return paramString;
    }
  }
  
  public ConfigInfo getConfigInfo(String paramString)
  {
    ConfigInfo localConfigInfo = new ConfigInfo();
    localConfigInfo.a = paramString;
    for (;;)
    {
      synchronized (this.e)
      {
        localConfigInfo.b = getConfig(paramString);
        paramString = (Long)this.localVersions.get(paramString);
        if (paramString != null)
        {
          l = paramString.longValue();
          localConfigInfo.c = l;
          return localConfigInfo;
        }
      }
      long l = 0L;
    }
  }
  
  public Object getParsedConfig(String paramString)
  {
    String str2 = getConfig(paramString);
    boolean bool = TextUtils.isEmpty(str2);
    JSONObject localJSONObject = null;
    paramString = null;
    String str1;
    if (!bool)
    {
      try
      {
        localJSONObject = new JSONObject(str2);
        paramString = localJSONObject;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      Object localObject = paramString;
      if (paramString == null) {
        try
        {
          localObject = new JSONArray(str2);
          return localObject;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          str1 = paramString;
        }
      }
    }
    return str1;
  }
  
  public int getValidReqOcca(int paramInt)
  {
    int i = paramInt;
    if (this.refreshType != 0)
    {
      i = paramInt;
      if (this.action != 3)
      {
        if (isVersionUpdate()) {
          return paramInt;
        }
        if (NetConnInfoCenter.getServerTimeMillis() - this.lastReqTime >= this.refreshTime * 1000) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 4)
            {
              paramInt = this.refreshType;
              if ((paramInt & 0x4) != 0) {
                return 4;
              }
              if ((i != 0) && ((paramInt & 0x400) != 0)) {
                return 1024;
              }
            }
          }
          else
          {
            paramInt = this.refreshType;
            if ((paramInt & 0x2) != 0) {
              return 2;
            }
            if ((i != 0) && ((paramInt & 0x200) != 0)) {
              return 512;
            }
          }
        }
        else
        {
          paramInt = this.refreshType;
          if ((paramInt & 0x1) != 0) {
            return 1;
          }
          if ((i != 0) && ((paramInt & 0x100) != 0)) {
            return 256;
          }
        }
        i = -1;
      }
    }
    return i;
  }
  
  public void handleRsp(RspWalletConfig paramRspWalletConfig, long paramLong, IQWalletConfigService.ConfigListener paramConfigListener, IQWalletConfigService paramIQWalletConfigService)
  {
    if (paramRspWalletConfig != null)
    {
      if (paramRspWalletConfig.result != RspWalletConfig.RET_SUCC) {
        return;
      }
      int j = paramRspWalletConfig.refreshTime;
      int i = 86400;
      if (j <= 86400) {
        i = paramRspWalletConfig.refreshTime;
      }
      paramRspWalletConfig.refreshTime = i;
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (paramLong == 0L)
      {
        a(l);
        this.action = paramRspWalletConfig.action;
        if (paramRspWalletConfig.action != 1) {
          if (paramRspWalletConfig.action == 0)
          {
            this.seriesNo = paramRspWalletConfig.seriesNo;
            this.refreshType = paramRspWalletConfig.refreshType;
            this.refreshTime = paramRspWalletConfig.refreshTime;
            this.commonMsg = paramRspWalletConfig.commonMsg;
            a(paramRspWalletConfig.mConfig, true, l);
          }
          else if (paramRspWalletConfig.action == 2)
          {
            this.seriesNo = paramRspWalletConfig.seriesNo;
            this.refreshType = paramRspWalletConfig.refreshType;
            this.refreshTime = paramRspWalletConfig.refreshTime;
            this.commonMsg = paramRspWalletConfig.commonMsg;
            a(paramRspWalletConfig.mConfig, false, l);
          }
          else if (paramRspWalletConfig.action == 3)
          {
            if (this.seriesNo == paramRspWalletConfig.seriesNo) {
              i = 1;
            } else {
              i = 0;
            }
            this.seriesNo = paramRspWalletConfig.seriesNo;
            this.refreshType = paramRspWalletConfig.refreshType;
            this.refreshTime = paramRspWalletConfig.refreshTime;
            this.commonMsg = paramRspWalletConfig.commonMsg;
            a(paramRspWalletConfig.mConfig, false, l);
            if ((paramIQWalletConfigService != null) && (i == 0) && (this.g < 100))
            {
              paramIQWalletConfigService.tryGetConfigAgain();
              this.g += 1;
            }
          }
        }
        if (paramRspWalletConfig.action != 3) {
          this.g = 0;
        }
      }
      else
      {
        a(l, paramLong, paramRspWalletConfig);
        a(paramRspWalletConfig.mConfig, false, l);
        notifyListener(paramConfigListener);
      }
      if (QLog.isColorLevel())
      {
        paramRspWalletConfig = new StringBuilder();
        paramRspWalletConfig.append("after update|");
        paramRspWalletConfig.append(this);
        QLog.d("QWalletConfig", 2, paramRspWalletConfig.toString());
      }
      this.lastAppId = AppSetting.d();
      saveConfig();
    }
  }
  
  public boolean isValidToReq(long paramLong)
  {
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = 1L;
    long l1 = paramLong;
    paramLong = l2;
    Object localObject;
    for (;;)
    {
      int i = 0;
      if (l1 == 0L) {
        break;
      }
      if ((paramLong & l1) != 0L)
      {
        if (this.lastReqTimes.containsKey(Long.valueOf(paramLong))) {
          localObject = (Long)this.lastReqTimes.get(Long.valueOf(paramLong));
        } else {
          localObject = Long.valueOf(0L);
        }
        if (this.refreshTimes.containsKey(Long.valueOf(paramLong))) {
          i = ((Integer)this.refreshTimes.get(Long.valueOf(paramLong))).intValue();
        }
        if (Math.abs(l3 - ((Long)localObject).longValue()) >= i * 1000)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isValidToReq true when");
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(paramLong);
            QLog.d("QWalletConfig", 2, ((StringBuilder)localObject).toString());
          }
          return true;
        }
        l1 &= (0xFFFFFFFF ^ paramLong);
        paramLong <<= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isValidToReq false");
      ((StringBuilder)localObject).append(l1);
      QLog.d("QWalletConfig", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean isVersionUpdate()
  {
    return this.lastAppId != AppSetting.d();
  }
  
  public void notifyListener(IQWalletConfigService.ConfigListener paramConfigListener)
  {
    if (paramConfigListener != null) {
      synchronized (this.e)
      {
        HashMap localHashMap = new HashMap(this.configs);
        paramConfigListener.a(this.b, localHashMap);
        return;
      }
    }
  }
  
  public void notifyUpdateListeners(Map<String, String> paramMap, long paramLong)
  {
    synchronized (this.d)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        if (!TextUtils.isEmpty(str))
        {
          Object localObject2 = (List)this.c.get(str);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              IQWalletConfigService.ConfigUpdateListener localConfigUpdateListener = (IQWalletConfigService.ConfigUpdateListener)((Iterator)localObject2).next();
              try
              {
                localConfigUpdateListener.onUpdate(str, (String)localObject1, new ConfigInfo(str, (String)localObject1, paramLong));
              }
              catch (Throwable localThrowable) {}
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("notifyUpdateListeners|key=");
                localStringBuilder.append(str);
                localStringBuilder.append("|config=");
                localStringBuilder.append((String)localObject1);
                localStringBuilder.append("|errmsg=");
                localStringBuilder.append(localThrowable.getMessage());
                QLog.e("QWalletConfig", 2, localStringBuilder.toString());
              }
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramMap;
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.d)
    {
      this.c.clear();
      this.f.clear();
      return;
    }
  }
  
  public void removeUpdateListener(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    synchronized (this.d)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramConfigUpdateListener != null))
      {
        paramString = (List)this.c.get(paramString);
        if (paramString != null) {
          paramString.remove(paramConfigUpdateListener);
        }
      }
      return;
    }
  }
  
  public void saveConfig()
  {
    if (!TextUtils.isEmpty(this.a)) {
      ThreadManager.getFileThreadHandler().post(new QWalletConfig.1(this));
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QWalletConfig{seriesNo=");
    localStringBuilder.append(this.seriesNo);
    localStringBuilder.append(", refreshType=");
    localStringBuilder.append(this.refreshType);
    localStringBuilder.append(", refreshTime=");
    localStringBuilder.append(this.refreshTime);
    localStringBuilder.append(", lastReqTime=");
    localStringBuilder.append(this.lastReqTime);
    localStringBuilder.append(", commonMsg='");
    localStringBuilder.append(this.commonMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", configs=");
    localStringBuilder.append(this.configs);
    localStringBuilder.append(", refreshTimes=");
    localStringBuilder.append(this.refreshTimes);
    localStringBuilder.append(", lastReqTimes=");
    localStringBuilder.append(this.lastReqTimes);
    localStringBuilder.append(", mSavePath='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCurUin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletConfig
 * JD-Core Version:    0.7.0.1
 */