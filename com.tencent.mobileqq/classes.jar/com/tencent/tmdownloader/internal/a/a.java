package com.tencent.tmdownloader.internal.a;

import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.BypassInterceptConfig;
import com.tencent.tmassistant.common.jce.ConfigItem;
import com.tencent.tmassistant.common.jce.GetConfigResponse;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.f;
import com.tencent.tmdownloader.internal.storage.b;
import java.util.ArrayList;
import java.util.Iterator;

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
  
  static
  {
    c.add(Integer.valueOf(4));
    c.add(Integer.valueOf(6));
    c.add(Integer.valueOf(8));
    c.add(Integer.valueOf(9));
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
          r.c("GetConfigEngine", "<onRequestFinished> request failed!");
          return;
        }
        localObject1 = paramGetConfigResponse.settingList;
        i = ((ArrayList)localObject1).size();
        r.c("GetConfigEngine", "<onRequestFinished> response.settingList size = " + paramGetConfigResponse.settingList.size() + ",current process : " + m.e());
        paramGetConfigResponse = ((ArrayList)localObject1).iterator();
        if (!paramGetConfigResponse.hasNext()) {
          break label378;
        }
        localObject1 = (ConfigItem)paramGetConfigResponse.next();
        if ((localObject1 == null) || (((ConfigItem)localObject1).configuration == null)) {
          continue;
        }
        r.c("GetConfigEngine", "<onRequestFinished> item.type = " + ((ConfigItem)localObject1).type);
        switch (((ConfigItem)localObject1).type)
        {
        case 6: 
          localObject2 = (BatchReportConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, BatchReportConfig.class);
          if (localObject2 == null) {
            continue;
          }
          r.c("GetConfigEngine", "<onRequestFinished>  reportConfig.batchReportInterval = " + ((BatchReportConfig)localObject2).batchReportInterval + " reportConfig.batchReportMaxCount = " + ((BatchReportConfig)localObject2).batchReportMaxCount + " reportConfig.reportRetryCount = " + ((BatchReportConfig)localObject2).reportRetryCount);
          b.a().a(((ConfigItem)localObject1).configuration);
          break;
        case 8: 
          b.a().b(((ConfigItem)localObject1).configuration);
        }
      }
      finally {}
      continue;
      Object localObject2 = (BypassInterceptConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, BypassInterceptConfig.class);
      if (localObject2 != null) {
        r.c("GetConfigEngine", "<onRequestFinished>  status = " + ((BypassInterceptConfig)localObject2).status + " config.pkgList = " + ((BypassInterceptConfig)localObject2).pkgList);
      }
      b.a().a("key_bypass_config", ((ConfigItem)localObject1).configuration, BypassInterceptConfig.class);
      continue;
      label378:
      if (i == d.size()) {
        this.b = System.currentTimeMillis();
      } else {
        this.a = System.currentTimeMillis();
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
    //   3: ifnull +83 -> 86
    //   6: aload_1
    //   7: invokevirtual 60	java/util/ArrayList:size	()I
    //   10: ifle +76 -> 86
    //   13: new 182	com/tencent/tmassistant/common/jce/GetConfigRequest
    //   16: dup
    //   17: invokespecial 183	com/tencent/tmassistant/common/jce/GetConfigRequest:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: new 19	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 22	java/util/ArrayList:<init>	()V
    //   29: putfield 186	com/tencent/tmassistant/common/jce/GetConfigRequest:typeList	Ljava/util/ArrayList;
    //   32: aload_2
    //   33: getfield 186	com/tencent/tmassistant/common/jce/GetConfigRequest:typeList	Ljava/util/ArrayList;
    //   36: aload_1
    //   37: invokevirtual 190	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   40: pop
    //   41: aload_2
    //   42: invokestatic 194	com/tencent/tmassistant/common/ProtocolPackage:buildRequest	(Lcom/qq/taf/jce/JceStruct;)Lcom/tencent/tmassistant/common/jce/Request;
    //   45: invokestatic 198	com/tencent/tmassistant/common/ProtocolPackage:buildPostData	(Lcom/tencent/tmassistant/common/jce/Request;)[B
    //   48: astore_1
    //   49: ldc 62
    //   51: ldc 200
    //   53: invokestatic 69	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: aload_1
    //   58: invokevirtual 204	com/tencent/tmdownloader/internal/a/a:sendRequest	([B)Z
    //   61: ifne +22 -> 83
    //   64: invokestatic 209	com/tencent/tmassistantbase/util/f:a	()Landroid/os/Handler;
    //   67: new 211	com/tencent/tmdownloader/internal/a/b
    //   70: dup
    //   71: aload_0
    //   72: aload_1
    //   73: invokespecial 214	com/tencent/tmdownloader/internal/a/b:<init>	(Lcom/tencent/tmdownloader/internal/a/a;[B)V
    //   76: ldc2_w 215
    //   79: invokevirtual 222	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   82: pop
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: ldc 62
    //   88: ldc 224
    //   90: invokestatic 69	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: goto -10 -> 83
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
    //   0	101	1	paramArrayList	ArrayList<Integer>
    //   20	22	2	localGetConfigRequest	com.tencent.tmassistant.common.jce.GetConfigRequest
    // Exception table:
    //   from	to	target	type
    //   6	83	96	finally
    //   86	93	96	finally
  }
  
  public void b()
  {
    for (;;)
    {
      long l;
      try
      {
        if (!m.a())
        {
          f.a().b();
          return;
        }
        l = System.currentTimeMillis();
        if (l - this.f <= 2000L)
        {
          r.c("GetConfigEngine", "<requestAllConfig> last call within 2s, give up this call!!");
          continue;
        }
        this.f = l;
      }
      finally {}
      if (l - this.a >= 300000L) {
        a(c);
      } else {
        r.c("GetConfigEngine", "<requestAllConfig> timeGap < REQUEST_TIME_GAP");
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
        if (!m.a())
        {
          f.a().c();
          return;
        }
        l = System.currentTimeMillis();
        if (l - this.g <= 2000L)
        {
          r.c("GetConfigEngine", "<requestShareUrl> last call within 2s, give up this call!!");
          continue;
        }
        this.g = l;
      }
      finally {}
      if (l - this.b >= 300000L) {
        a(d);
      } else {
        r.c("GetConfigEngine", "<requestShareUrl> timeGap < REQUEST_TIME_GAP");
      }
    }
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    for (;;)
    {
      try
      {
        r.c("GetConfigEngine", "<onFinished> errorCode:" + paramInt);
        if ((paramArrayOfByte2 == null) || (paramInt != 0))
        {
          r.c("GetConfigEngine", "<onFinished> response is null || errorCode != TMAssistantDownloadErrorCode.DownloadSDKErrorCode_NONE, returned");
          a(null, false);
          return;
        }
        paramArrayOfByte1 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
        if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.body == null)) {
          break label140;
        }
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte1.body, GetConfigResponse.class);
        if ((paramArrayOfByte1 == null) || (!(paramArrayOfByte1 instanceof GetConfigResponse))) {
          break label123;
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
      label123:
      a(null, false);
      r.c("GetConfigEngine", "<onFinished> null == jceResponse || jceResponse is not instanceof GetConfigResponse");
      continue;
      label140:
      a(null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.a
 * JD-Core Version:    0.7.0.1
 */