package com.tencent.tmdownloader.internal.a;

import android.text.TextUtils;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.AppDataReportConfig;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.BoutiqueGameConfig;
import com.tencent.tmassistant.common.jce.BypassInterceptConfig;
import com.tencent.tmassistant.common.jce.ConfigItem;
import com.tencent.tmassistant.common.jce.GetConfigResponse;
import com.tencent.tmassistant.common.jce.NewQqCenterConfig;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.t;
import com.tencent.tmdownloader.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends PostHttpRequest
{
  private static ArrayList<Integer> c = new ArrayList();
  private static ArrayList<Integer> d = new ArrayList();
  private static volatile a e = null;
  private long a = 0L;
  private long b = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  
  static
  {
    c.add(Integer.valueOf(4));
    c.add(Integer.valueOf(6));
    c.add(Integer.valueOf(8));
    c.add(Integer.valueOf(9));
    c.add(Integer.valueOf(11));
    c.add(Integer.valueOf(12));
    d.add(Integer.valueOf(8));
  }
  
  public static a a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new a();
      }
      return e;
    }
    finally {}
  }
  
  private String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return "[]";
    }
    localStringBuilder.append("[");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append("key:" + (String)localEntry.getKey());
      localStringBuilder.append(",value:" + (String)localEntry.getValue());
      localStringBuilder.append("||");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void a(GetConfigResponse paramGetConfigResponse, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramGetConfigResponse != null)) {}
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if ((paramGetConfigResponse.settingList == null) || (paramGetConfigResponse.settingList.size() == 0))
        {
          ac.c("GetConfigEngine", "<onRequestFinished> request failed!");
          return;
        }
        localObject1 = paramGetConfigResponse.settingList;
        i = ((ArrayList)localObject1).size();
        ac.c("GetConfigEngine", "<onRequestFinished> response.settingList size = " + paramGetConfigResponse.settingList.size() + ",current process : " + t.e());
        paramGetConfigResponse = ((ArrayList)localObject1).iterator();
        if (!paramGetConfigResponse.hasNext()) {
          break label717;
        }
        localObject1 = (ConfigItem)paramGetConfigResponse.next();
        if ((localObject1 == null) || (((ConfigItem)localObject1).configuration == null)) {
          continue;
        }
        ac.c("GetConfigEngine", "<onRequestFinished> item.type = " + ((ConfigItem)localObject1).type);
        switch (((ConfigItem)localObject1).type)
        {
        case 6: 
          localObject2 = (BatchReportConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, BatchReportConfig.class);
          if (localObject2 == null) {
            continue;
          }
          ac.c("GetConfigEngine", "<onRequestFinished>  reportConfig.batchReportInterval = " + ((BatchReportConfig)localObject2).batchReportInterval + " reportConfig.batchReportMaxCount = " + ((BatchReportConfig)localObject2).batchReportMaxCount + " reportConfig.reportRetryCount = " + ((BatchReportConfig)localObject2).reportRetryCount);
          com.tencent.tmdownloader.internal.storage.b.a().a(((ConfigItem)localObject1).configuration);
          break;
        case 8: 
          com.tencent.tmdownloader.internal.storage.b.a().b(((ConfigItem)localObject1).configuration);
        }
      }
      finally {}
      continue;
      Object localObject2 = (BypassInterceptConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, BypassInterceptConfig.class);
      if (localObject2 != null) {
        ac.c("GetConfigEngine", "<onRequestFinished>  status = " + ((BypassInterceptConfig)localObject2).status + " config.pkgList = " + ((BypassInterceptConfig)localObject2).pkgList);
      }
      com.tencent.tmdownloader.internal.storage.b.a().a("key_bypass_config", ((ConfigItem)localObject1).configuration, BypassInterceptConfig.class);
      continue;
      localObject2 = (BoutiqueGameConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, BoutiqueGameConfig.class);
      if ((localObject2 != null) && (((BoutiqueGameConfig)localObject2).pkgList != null) && (((BoutiqueGameConfig)localObject2).pkgList.size() != 0))
      {
        ac.c("nemo_bgg", "<onRequestFinished> CONFIG_RECOMMEND_GAMES  size = " + ((BoutiqueGameConfig)localObject2).pkgList.size() + "\ncontent=" + ((BoutiqueGameConfig)localObject2).pkgList);
        com.tencent.tmdownloader.internal.storage.b.a().a("key_recommend_games_config", ((ConfigItem)localObject1).configuration, BoutiqueGameConfig.class);
        localObject1 = GlobalUtil.getCurrentDay();
        Settings.getInstance().setString("KEY_CRG_DATE", (String)localObject1);
        ac.c("nemo_bgg", "save KEY_CRG_DATE:" + (String)localObject1);
      }
      else
      {
        ac.e("nemo_bgg", "<onRequestFinished> CONFIG_RECOMMEND_GAMES error, boutiqueGameConfig is null!");
        continue;
        localObject2 = (NewQqCenterConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, NewQqCenterConfig.class);
        if (localObject2 != null)
        {
          ac.c("GetConfigEngine", "get NewQqCenterConfig succ.\ndetailSwitch=" + ((NewQqCenterConfig)localObject2).detailSwitch + "\nentranceSwitch=" + ((NewQqCenterConfig)localObject2).entranceSwitch + "\nenterOldViaList=" + ((NewQqCenterConfig)localObject2).enterOldViaList + "\nmap=" + a(((NewQqCenterConfig)localObject2).appNewsUrlMap));
          com.tencent.tmdownloader.internal.storage.b.a().c(((ConfigItem)localObject1).configuration);
        }
        else
        {
          ac.e("GetConfigEngine", "CONFIG_NEW_APP_CENTER Bad content!");
          continue;
          localObject1 = (AppDataReportConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, AppDataReportConfig.class);
          ac.e("GetConfigEngine", "config 12=" + localObject1);
          if (localObject1 != null)
          {
            com.tencent.tmassistant.a.b.a().a((AppDataReportConfig)localObject1);
            continue;
            label717:
            if (i == d.size())
            {
              this.b = System.currentTimeMillis();
            }
            else
            {
              this.a = System.currentTimeMillis();
              paramGetConfigResponse = GlobalUtil.getCurrentDay();
              localObject1 = GlobalUtil.getDayAndHour(System.currentTimeMillis());
              localObject2 = Settings.getInstance().getString("KEY_GET_CFG_REQUEST_DAY");
              i = Settings.getInstance().getInt("KEY_GET_CFG_SUCC_COUNT");
              if (!TextUtils.equals((CharSequence)localObject2, paramGetConfigResponse)) {
                i = 0;
              }
              Settings.getInstance().setString("KEY_GET_CFG_REQUEST_DAY", paramGetConfigResponse);
              Settings.getInstance().setString("KEY_GET_CFG_REQUEST_HOUR", (String)localObject1);
              Settings.getInstance().setInt("KEY_GET_CFG_SUCC_COUNT", i + 1);
              ac.c("GetConfigEngine", "[onRequestFinished] day=" + paramGetConfigResponse + ",dayAndHour=" + (String)localObject1 + ",count=" + i);
            }
          }
        }
      }
    }
  }
  
  /* Error */
  private void a(ArrayList<Integer> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +84 -> 87
    //   6: aload_1
    //   7: invokevirtual 122	java/util/ArrayList:size	()I
    //   10: ifle +77 -> 87
    //   13: new 328	com/tencent/tmassistant/common/jce/GetConfigRequest
    //   16: dup
    //   17: invokespecial 329	com/tencent/tmassistant/common/jce/GetConfigRequest:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: new 20	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 23	java/util/ArrayList:<init>	()V
    //   29: putfield 332	com/tencent/tmassistant/common/jce/GetConfigRequest:typeList	Ljava/util/ArrayList;
    //   32: aload_2
    //   33: getfield 332	com/tencent/tmassistant/common/jce/GetConfigRequest:typeList	Ljava/util/ArrayList;
    //   36: aload_1
    //   37: invokevirtual 336	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   40: pop
    //   41: aload_2
    //   42: invokestatic 340	com/tencent/tmassistant/common/ProtocolPackage:buildRequest	(Lcom/qq/taf/jce/JceStruct;)Lcom/tencent/tmassistant/common/jce/Request;
    //   45: invokestatic 344	com/tencent/tmassistant/common/ProtocolPackage:buildPostData	(Lcom/tencent/tmassistant/common/jce/Request;)[B
    //   48: astore_1
    //   49: ldc 124
    //   51: ldc_w 346
    //   54: invokestatic 131	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 350	com/tencent/tmdownloader/internal/a/a:sendRequest	([B)Z
    //   62: ifne +22 -> 84
    //   65: invokestatic 355	com/tencent/tmassistantbase/util/l:a	()Landroid/os/Handler;
    //   68: new 357	com/tencent/tmdownloader/internal/a/b
    //   71: dup
    //   72: aload_0
    //   73: aload_1
    //   74: invokespecial 360	com/tencent/tmdownloader/internal/a/b:<init>	(Lcom/tencent/tmdownloader/internal/a/a;[B)V
    //   77: ldc2_w 361
    //   80: invokevirtual 368	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   83: pop
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: ldc 124
    //   89: ldc_w 370
    //   92: invokestatic 131	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: goto -11 -> 84
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	a
    //   0	103	1	paramArrayList	ArrayList<Integer>
    //   20	22	2	localGetConfigRequest	com.tencent.tmassistant.common.jce.GetConfigRequest
    // Exception table:
    //   from	to	target	type
    //   6	84	98	finally
    //   87	95	98	finally
  }
  
  private boolean e()
  {
    long l = System.currentTimeMillis();
    if (l - this.f <= 2000L) {
      ac.c("GetConfigEngine", "[memoryFrequencyControl] last call within 2s, give up this call.");
    }
    do
    {
      return false;
      this.f = l;
    } while (l - this.a < 1800000L);
    return true;
  }
  
  private boolean f()
  {
    String str1 = GlobalUtil.getCurrentDay();
    String str2 = GlobalUtil.getDayAndHour(System.currentTimeMillis());
    String str3 = Settings.getInstance().getString("KEY_GET_CFG_REQUEST_DAY");
    if (TextUtils.equals(str2, Settings.getInstance().getString("KEY_GET_CFG_REQUEST_HOUR")))
    {
      ac.c("GetConfigEngine", "hour not allowed:" + str2);
      return false;
    }
    int i = Settings.getInstance().getInt("KEY_GET_CFG_SUCC_COUNT");
    if (!TextUtils.equals(str1, str3))
    {
      Settings.getInstance().setInt("KEY_GET_CFG_SUCC_COUNT", 0);
      i = 0;
    }
    if (i >= 10)
    {
      ac.c("GetConfigEngine", "success count not allowed:" + i);
      return false;
    }
    return true;
  }
  
  private ArrayList<Integer> g()
  {
    String str1 = GlobalUtil.getCurrentDay();
    String str2 = Settings.getInstance().getString("KEY_CRG_DATE");
    ac.c("nemo_bgg", "<requestAllConfig> date = " + str1 + ", KEY_CRG_DATE = " + str2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(c);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      localArrayList.add(Integer.valueOf(10));
    }
    return localArrayList;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (!t.a())
        {
          f.a().b();
          return;
        }
        if (!e())
        {
          ac.c("GetConfigEngine", "memoryFrequencyControl is false!");
          continue;
        }
        ac.c("GetConfigEngine", "memoryFrequencyControl passed!");
      }
      finally {}
      if (!f())
      {
        ac.c("GetConfigEngine", "persistenceFrequencyControl is false!");
      }
      else
      {
        ac.c("GetConfigEngine", "persistenceFrequencyControl passed!");
        a(g());
      }
    }
  }
  
  public void c()
  {
    for (;;)
    {
      long l;
      try
      {
        if (!t.a())
        {
          f.a().c();
          return;
        }
        l = System.currentTimeMillis();
        if (l - this.g <= 2000L)
        {
          ac.c("GetConfigEngine", "<requestShareUrl> last call within 2s, give up this call!!");
          continue;
        }
        this.g = l;
      }
      finally {}
      if (l - this.b >= 1800000L) {
        a(d);
      } else {
        ac.c("GetConfigEngine", "<requestShareUrl> timeGap < REQUEST_TIME_GAP");
      }
    }
  }
  
  public void d()
  {
    for (;;)
    {
      try
      {
        if (!t.a())
        {
          f.a().d();
          return;
        }
        long l = System.currentTimeMillis();
        if (l - this.h <= 2000L)
        {
          ac.c("GetConfigEngine", "<requestNewAppCenterConfig> last call within 2s, give up this call!!");
          continue;
        }
        this.h = l;
      }
      finally {}
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(Integer.valueOf(11));
      a(localArrayList);
    }
  }
  
  public void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    for (;;)
    {
      try
      {
        ac.c("GetConfigEngine", "<onFinished> errorCode:" + paramInt);
        if ((paramArrayOfByte2 == null) || (paramInt != 0))
        {
          ac.c("GetConfigEngine", "<onFinished> response is null || errorCode != TMAssistantDownloadErrorCode.DownloadSDKErrorCode_NONE, returned");
          a(null, false);
          return;
        }
        paramArrayOfByte1 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
        if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.body == null)) {
          break label141;
        }
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte1.body, GetConfigResponse.class);
        if ((paramArrayOfByte1 == null) || (!(paramArrayOfByte1 instanceof GetConfigResponse))) {
          break label124;
        }
        paramArrayOfByte1 = (GetConfigResponse)paramArrayOfByte1;
        if (paramArrayOfByte1.ret == 0)
        {
          a(paramArrayOfByte1, true);
          continue;
        }
        a(paramArrayOfByte1, false);
      }
      finally {}
      continue;
      label124:
      a(null, false);
      ac.c("GetConfigEngine", "<onFinished> null == jceResponse || jceResponse is not instanceof GetConfigResponse");
      continue;
      label141:
      a(null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.a
 * JD-Core Version:    0.7.0.1
 */