package com.tencent.tmdownloader.internal.a;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.AppDataReportConfig;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.BoutiqueGameConfig;
import com.tencent.tmassistant.common.jce.BypassInterceptConfig;
import com.tencent.tmassistant.common.jce.ConfigItem;
import com.tencent.tmassistant.common.jce.GetConfigRequest;
import com.tencent.tmassistant.common.jce.GetConfigResponse;
import com.tencent.tmassistant.common.jce.NewQqCenterConfig;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmassistantbase.util.s;
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
    ArrayList localArrayList = c;
    Integer localInteger = Integer.valueOf(8);
    localArrayList.add(localInteger);
    c.add(Integer.valueOf(9));
    c.add(Integer.valueOf(11));
    c.add(Integer.valueOf(12));
    d.add(localInteger);
  }
  
  public static a a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new a();
        }
      }
      finally {}
    }
    return e;
  }
  
  private String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      localStringBuilder1.append("[");
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("key:");
        localStringBuilder2.append((String)localEntry.getKey());
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(",value:");
        localStringBuilder2.append((String)localEntry.getValue());
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append("||");
      }
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
    return "[]";
  }
  
  private void a(GetConfigResponse paramGetConfigResponse, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramGetConfigResponse != null))
    {
      for (;;)
      {
        try
        {
          if ((paramGetConfigResponse.settingList == null) || (paramGetConfigResponse.settingList.size() == 0)) {
            continue;
          }
          localObject1 = paramGetConfigResponse.settingList;
          i = ((ArrayList)localObject1).size();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<onRequestFinished> response.settingList size = ");
          ((StringBuilder)localObject2).append(paramGetConfigResponse.settingList.size());
          ((StringBuilder)localObject2).append(",current process : ");
          ((StringBuilder)localObject2).append(s.e());
          ab.c("GetConfigEngine", ((StringBuilder)localObject2).toString());
          paramGetConfigResponse = ((ArrayList)localObject1).iterator();
        }
        finally
        {
          Object localObject1;
          int i;
          Object localObject2;
          StringBuilder localStringBuilder;
          continue;
          throw paramGetConfigResponse;
          continue;
          continue;
        }
        if (!paramGetConfigResponse.hasNext()) {
          continue;
        }
        localObject1 = (ConfigItem)paramGetConfigResponse.next();
        if ((localObject1 != null) && (((ConfigItem)localObject1).configuration != null))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<onRequestFinished> item.type = ");
          ((StringBuilder)localObject2).append(((ConfigItem)localObject1).type);
          ab.c("GetConfigEngine", ((StringBuilder)localObject2).toString());
          switch (((ConfigItem)localObject1).type)
          {
          case 12: 
            localObject1 = (AppDataReportConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, AppDataReportConfig.class);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("config 12=");
            ((StringBuilder)localObject2).append(localObject1);
            ab.e("GetConfigEngine", ((StringBuilder)localObject2).toString());
            if (localObject1 != null) {
              com.tencent.tmassistant.a.b.a().a((AppDataReportConfig)localObject1);
            }
            break;
          case 11: 
            localObject2 = (NewQqCenterConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, NewQqCenterConfig.class);
            if (localObject2 != null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("get NewQqCenterConfig succ.\ndetailSwitch=");
              localStringBuilder.append(((NewQqCenterConfig)localObject2).detailSwitch);
              localStringBuilder.append("\nentranceSwitch=");
              localStringBuilder.append(((NewQqCenterConfig)localObject2).entranceSwitch);
              localStringBuilder.append("\nenterOldViaList=");
              localStringBuilder.append(((NewQqCenterConfig)localObject2).enterOldViaList);
              localStringBuilder.append("\nmap=");
              localStringBuilder.append(a(((NewQqCenterConfig)localObject2).appNewsUrlMap));
              ab.c("GetConfigEngine", localStringBuilder.toString());
              com.tencent.tmdownloader.internal.storage.b.a().c(((ConfigItem)localObject1).configuration);
            }
            else
            {
              ab.e("GetConfigEngine", "CONFIG_NEW_APP_CENTER Bad content!");
            }
            break;
          case 10: 
            localObject2 = (BoutiqueGameConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, BoutiqueGameConfig.class);
            if ((localObject2 != null) && (((BoutiqueGameConfig)localObject2).pkgList != null) && (((BoutiqueGameConfig)localObject2).pkgList.size() != 0))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("<onRequestFinished> CONFIG_RECOMMEND_GAMES  size = ");
              localStringBuilder.append(((BoutiqueGameConfig)localObject2).pkgList.size());
              localStringBuilder.append("\ncontent=");
              localStringBuilder.append(((BoutiqueGameConfig)localObject2).pkgList);
              ab.c("nemo_bgg", localStringBuilder.toString());
              com.tencent.tmdownloader.internal.storage.b.a().a("key_recommend_games_config", ((ConfigItem)localObject1).configuration, BoutiqueGameConfig.class);
              localObject1 = GlobalUtil.getCurrentDay();
              Settings.getInstance().setString("KEY_CRG_DATE", (String)localObject1);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("save KEY_CRG_DATE:");
              ((StringBuilder)localObject2).append((String)localObject1);
              ab.c("nemo_bgg", ((StringBuilder)localObject2).toString());
            }
            else
            {
              ab.e("nemo_bgg", "<onRequestFinished> CONFIG_RECOMMEND_GAMES error, boutiqueGameConfig is null!");
            }
            break;
          case 9: 
            localObject2 = (BypassInterceptConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, BypassInterceptConfig.class);
            if (localObject2 != null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("<onRequestFinished>  status = ");
              localStringBuilder.append(((BypassInterceptConfig)localObject2).status);
              localStringBuilder.append(" config.pkgList = ");
              localStringBuilder.append(((BypassInterceptConfig)localObject2).pkgList);
              ab.c("GetConfigEngine", localStringBuilder.toString());
            }
            com.tencent.tmdownloader.internal.storage.b.a().a("key_bypass_config", ((ConfigItem)localObject1).configuration, BypassInterceptConfig.class);
            break;
          case 8: 
            com.tencent.tmdownloader.internal.storage.b.a().b(((ConfigItem)localObject1).configuration);
            break;
          case 6: 
            localObject2 = (BatchReportConfig)ProtocolPackage.bytes2JceObj(((ConfigItem)localObject1).configuration, BatchReportConfig.class);
            if (localObject2 != null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("<onRequestFinished>  reportConfig.batchReportInterval = ");
              localStringBuilder.append(((BatchReportConfig)localObject2).batchReportInterval);
              localStringBuilder.append(" reportConfig.batchReportMaxCount = ");
              localStringBuilder.append(((BatchReportConfig)localObject2).batchReportMaxCount);
              localStringBuilder.append(" reportConfig.reportRetryCount = ");
              localStringBuilder.append(((BatchReportConfig)localObject2).reportRetryCount);
              ab.c("GetConfigEngine", localStringBuilder.toString());
              com.tencent.tmdownloader.internal.storage.b.a().a(((ConfigItem)localObject1).configuration);
            }
            break;
          }
        }
      }
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[onRequestFinished] day=");
        ((StringBuilder)localObject2).append(paramGetConfigResponse);
        ((StringBuilder)localObject2).append(",dayAndHour=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",count=");
        ((StringBuilder)localObject2).append(i);
        ab.c("GetConfigEngine", ((StringBuilder)localObject2).toString());
      }
      return;
    }
    ab.c("GetConfigEngine", "<onRequestFinished> request failed!");
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList != null) {}
    try
    {
      if (paramArrayList.size() > 0)
      {
        GetConfigRequest localGetConfigRequest = new GetConfigRequest();
        localGetConfigRequest.typeList = new ArrayList();
        localGetConfigRequest.typeList.addAll(paramArrayList);
        paramArrayList = ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(localGetConfigRequest));
        ab.c("GetConfigEngine", "<request> begin...");
        if (!sendRequest(paramArrayList)) {
          k.a().postDelayed(new b(this, paramArrayList), 2000L);
        }
      }
      else
      {
        ab.c("GetConfigEngine", "<request> invalid request!!!");
      }
      return;
    }
    finally {}
  }
  
  private boolean e()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.f;
    boolean bool = false;
    if (l1 - l2 <= 2000L)
    {
      ab.c("GetConfigEngine", "[memoryFrequencyControl] last call within 2s, give up this call.");
      return false;
    }
    this.f = l1;
    if (l1 - this.a >= 1800000L) {
      bool = true;
    }
    return bool;
  }
  
  private boolean f()
  {
    Object localObject2 = GlobalUtil.getCurrentDay();
    Object localObject1 = GlobalUtil.getDayAndHour(System.currentTimeMillis());
    String str = Settings.getInstance().getString("KEY_GET_CFG_REQUEST_DAY");
    if (TextUtils.equals((CharSequence)localObject1, Settings.getInstance().getString("KEY_GET_CFG_REQUEST_HOUR")))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("hour not allowed:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ab.c("GetConfigEngine", ((StringBuilder)localObject2).toString());
      return false;
    }
    int i = Settings.getInstance().getInt("KEY_GET_CFG_SUCC_COUNT");
    if (!TextUtils.equals((CharSequence)localObject2, str))
    {
      Settings.getInstance().setInt("KEY_GET_CFG_SUCC_COUNT", 0);
      i = 0;
    }
    if (i >= 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("success count not allowed:");
      ((StringBuilder)localObject1).append(i);
      ab.c("GetConfigEngine", ((StringBuilder)localObject1).toString());
      return false;
    }
    return true;
  }
  
  private ArrayList<Integer> g()
  {
    String str1 = GlobalUtil.getCurrentDay();
    String str2 = Settings.getInstance().getString("KEY_CRG_DATE");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<requestAllConfig> date = ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(", KEY_CRG_DATE = ");
    ((StringBuilder)localObject).append(str2);
    ab.c("nemo_bgg", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((ArrayList)localObject).addAll(c);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      ((ArrayList)localObject).add(Integer.valueOf(10));
    }
    return localObject;
  }
  
  public void b()
  {
    try
    {
      if (!s.a())
      {
        f.a().b();
      }
      else
      {
        if (!e())
        {
          ab.c("GetConfigEngine", "memoryFrequencyControl is false!");
          return;
        }
        ab.c("GetConfigEngine", "memoryFrequencyControl passed!");
        if (!f())
        {
          ab.c("GetConfigEngine", "persistenceFrequencyControl is false!");
          return;
        }
        ab.c("GetConfigEngine", "persistenceFrequencyControl passed!");
        a(g());
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (!s.a())
      {
        f.a().c();
      }
      else
      {
        long l = System.currentTimeMillis();
        if (l - this.g <= 2000L)
        {
          ab.c("GetConfigEngine", "<requestShareUrl> last call within 2s, give up this call!!");
          return;
        }
        this.g = l;
        if (l - this.b >= 1800000L) {
          a(d);
        } else {
          ab.c("GetConfigEngine", "<requestShareUrl> timeGap < REQUEST_TIME_GAP");
        }
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      if (!s.a())
      {
        f.a().d();
      }
      else
      {
        long l = System.currentTimeMillis();
        if (l - this.h <= 2000L)
        {
          ab.c("GetConfigEngine", "<requestNewAppCenterConfig> last call within 2s, give up this call!!");
          return;
        }
        this.h = l;
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(Integer.valueOf(11));
        a(localArrayList);
      }
      return;
    }
    finally {}
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    try
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("<onFinished> errorCode:");
      paramArrayOfByte1.append(paramInt);
      ab.c("GetConfigEngine", paramArrayOfByte1.toString());
      if ((paramArrayOfByte2 != null) && (paramInt == 0))
      {
        paramArrayOfByte1 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
        if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.body != null))
        {
          paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte1.body, GetConfigResponse.class);
          if ((paramArrayOfByte1 != null) && ((paramArrayOfByte1 instanceof GetConfigResponse)))
          {
            paramArrayOfByte1 = (GetConfigResponse)paramArrayOfByte1;
            if (paramArrayOfByte1.ret == 0) {
              a(paramArrayOfByte1, true);
            } else {
              a(paramArrayOfByte1, false);
            }
          }
          else
          {
            a(null, false);
            ab.c("GetConfigEngine", "<onFinished> null == jceResponse || jceResponse is not instanceof GetConfigResponse");
          }
        }
        else
        {
          a(null, false);
        }
        return;
      }
      ab.c("GetConfigEngine", "<onFinished> response is null || errorCode != TMAssistantDownloadErrorCode.DownloadSDKErrorCode_NONE, returned");
      a(null, false);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.a
 * JD-Core Version:    0.7.0.1
 */