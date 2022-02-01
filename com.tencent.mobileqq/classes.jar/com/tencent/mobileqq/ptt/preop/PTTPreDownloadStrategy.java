package com.tencent.mobileqq.ptt.preop;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader.IPreDownloadStrategy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class PTTPreDownloadStrategy
  implements IPTTPreDownloader.IPreDownloadStrategy, Runnable
{
  private volatile boolean a;
  private PTTPreDownloadStrategy.StrategyInfo b = new PTTPreDownloadStrategy.StrategyInfo(1);
  private PTTPreDownloadStrategy.StrategyInfo c = new PTTPreDownloadStrategy.StrategyInfo(3);
  private PTTPreDownloadStrategy.StrategyInfo d = new PTTPreDownloadStrategy.StrategyInfo(2);
  private WeakReference<AppRuntime> e;
  private Handler f;
  
  public PTTPreDownloadStrategy(AppRuntime paramAppRuntime, Handler paramHandler)
  {
    this.e = new WeakReference(paramAppRuntime);
    this.f = paramHandler;
    this.a = false;
  }
  
  private void a(PTTPreDownloadStrategy.StrategyInfo paramStrategyInfo)
  {
    if (paramStrategyInfo.a.a == -2147483648)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PTTPreDownloadStrategy", 4, "initStrategyInfoIfNeccessary");
      }
      Date localDate = new Date();
      Object localObject1 = (AppRuntime)this.e.get();
      PreDownloadParams.Params localParams1 = PreDownloadParams.a((AppRuntime)localObject1, paramStrategyInfo.b);
      paramStrategyInfo.a.a = localParams1.a;
      int i;
      if (paramStrategyInfo.a.a > 0)
      {
        PreDownloadParams.Params localParams2 = new PreDownloadParams.Params();
        localObject1 = PreDownloadParams.a((AppRuntime)localObject1, paramStrategyInfo.b, localParams2);
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd").format(localDate);
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("PreTime:");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" curTime:");
          localStringBuilder.append((String)localObject2);
          QLog.d("PTTPreDownloadStrategy", 4, localStringBuilder.toString());
        }
        if (((String)localObject2).equals(localObject1))
        {
          i = 0;
          while (i <= 5)
          {
            paramStrategyInfo.a.b[i] = localParams2.b[i];
            i += 1;
          }
        }
        if (localParams2.a > -1)
        {
          localObject1 = new HashMap();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localParams2.a);
          i = 0;
          while (i <= 5)
          {
            ((StringBuilder)localObject2).append('#');
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(localParams2.b[i]);
            i += 1;
          }
          ((HashMap)localObject1).put("RemainCfg", ((StringBuilder)localObject2).toString());
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttPreDownloadDailyRemain", true, 0L, 0L, (HashMap)localObject1, "");
        }
        i = 0;
        while (i <= 5)
        {
          paramStrategyInfo.a.b[i] = localParams1.b[i];
          i += 1;
        }
      }
      b(paramStrategyInfo);
      if (!this.a)
      {
        long l2 = localDate.getTime();
        i = localDate.getHours();
        localDate.setHours(0);
        localDate.setMinutes(0);
        localDate.setSeconds(0);
        long l3 = localDate.getTime();
        long l1;
        if (i < 0) {
          l1 = 0L;
        } else {
          l1 = 86400000L;
        }
        l1 -= l2 - l3;
        if (QLog.isDevelopLevel())
        {
          l2 = l1 / 1000L;
          paramStrategyInfo = new StringBuilder();
          paramStrategyInfo.append("Next reset time offset:");
          paramStrategyInfo.append(l2 / 60L);
          paramStrategyInfo.append(":");
          paramStrategyInfo.append(l2 % 60L);
          QLog.d("PTTPreDownloadStrategy", 4, paramStrategyInfo.toString());
        }
        this.a = true;
        this.f.postDelayed(this, l1);
      }
    }
  }
  
  private void b(PTTPreDownloadStrategy.StrategyInfo paramStrategyInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStrategyInfo.b);
    localStringBuilder.append(":");
    localStringBuilder.append(paramStrategyInfo.a);
    paramStrategyInfo = localStringBuilder.toString();
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloadStrategy", 4, paramStrategyInfo);
    }
  }
  
  private long c(MessageForPtt paramMessageForPtt)
  {
    long l2 = paramMessageForPtt.fileSize;
    long l1 = l2;
    if (l2 <= 0L)
    {
      if (paramMessageForPtt.voiceType == 1) {
        if (paramMessageForPtt.voiceLength <= 0) {
          return 10240L;
        }
      }
      for (int i = paramMessageForPtt.voiceLength * 1200;; i = paramMessageForPtt.voiceLength * 700)
      {
        return i;
        if ((paramMessageForPtt.voiceType != 0) || (paramMessageForPtt.voiceLength <= 0)) {
          break;
        }
      }
      l1 = 4096L;
    }
    return l1;
  }
  
  private void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloadStrategy", 4, "save");
    }
    AppRuntime localAppRuntime = (AppRuntime)this.e.get();
    if (localAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (this.b.a.a != -2147483648)
    {
      PreDownloadParams.a(localAppRuntime, this.b.a, this.b.b);
      b(this.b);
      localHashMap.put("C2CDownload", String.valueOf(this.b.c));
      localHashMap.put("C2CView", String.valueOf(this.b.e));
      localHashMap.put("C2CCancel", String.valueOf(this.b.f));
      localHashMap.put("C2CEscape", String.valueOf(this.b.d));
    }
    if (this.c.a.a != -2147483648)
    {
      PreDownloadParams.a(localAppRuntime, this.c.a, this.c.b);
      b(this.c);
      b(this.b);
      localHashMap.put("GroupDownload", String.valueOf(this.c.c));
      localHashMap.put("GroupView", String.valueOf(this.c.e));
      localHashMap.put("GroupCancel", String.valueOf(this.c.f));
      localHashMap.put("GroupEscape", String.valueOf(this.c.d));
    }
    if (this.d.a.a != -2147483648)
    {
      PreDownloadParams.a(localAppRuntime, this.d.a, this.d.b);
      b(this.d);
      localHashMap.put("DiscussDownload", String.valueOf(this.d.c));
      localHashMap.put("DiscussView", String.valueOf(this.d.e));
      localHashMap.put("DiscussCancel", String.valueOf(this.d.f));
      localHashMap.put("DiscussEscape", String.valueOf(this.d.d));
    }
    if (localHashMap.size() > 0)
    {
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttPreDownloadPV", true, 0L, 0L, localHashMap, "");
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloadStrategy", 4, "onDestroy");
    }
    this.f.removeCallbacks(this);
    this.a = false;
    c();
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    PTTPreDownloadStrategy.StrategyInfo localStrategyInfo;
    if (paramMessageForPtt.istroop == 0) {
      localStrategyInfo = this.b;
    } else if (paramMessageForPtt.istroop == 1) {
      localStrategyInfo = this.c;
    } else if (paramMessageForPtt.istroop == 3000) {
      localStrategyInfo = this.d;
    } else {
      localStrategyInfo = null;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (localStrategyInfo != null)
    {
      long l1 = 0L;
      int i = NetworkCenter.getInstance().getNetType();
      try
      {
        a(localStrategyInfo);
        Object localObject;
        if (localStrategyInfo.a.a > 0)
        {
          long l2 = paramMessageForPtt.msgRecTime - paramMessageForPtt.msgTime;
          if ((l2 >= -10000L) && (l2 <= localStrategyInfo.a.a * 24 * 60 * 60 * 100))
          {
            l2 = c(paramMessageForPtt);
            if (l2 > localStrategyInfo.a.b[i])
            {
              localStrategyInfo.d += 1;
            }
            else
            {
              localStrategyInfo.c += 1;
              paramMessageForPtt.estimatedSize = l2;
              l1 = localStrategyInfo.a.b[i];
              localObject = localStrategyInfo.a.b;
              localObject[i] = ((int)(localObject[i] - l2));
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("canDownload:");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(" sesion:");
          ((StringBuilder)localObject).append(localStrategyInfo.b);
          ((StringBuilder)localObject).append(" net:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(" - ");
          ((StringBuilder)localObject).append(paramMessageForPtt.estimatedSize);
          ((StringBuilder)localObject).append(" = ");
          ((StringBuilder)localObject).append(localStrategyInfo.a.b[i]);
          ((StringBuilder)localObject).append(", pttSize:");
          ((StringBuilder)localObject).append(paramMessageForPtt.fileSize);
          QLog.d("PTTPreDownloadStrategy", 4, ((StringBuilder)localObject).toString());
          return bool1;
        }
      }
      finally {}
    }
    return bool2;
  }
  
  public boolean a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 2) {
      return true;
    }
    PTTPreDownloadStrategy.StrategyInfo localStrategyInfo = null;
    if (paramMessageForPtt.istroop == 0) {
      localStrategyInfo = this.b;
    } else if (paramMessageForPtt.istroop == 1) {
      localStrategyInfo = this.c;
    } else if (paramMessageForPtt.istroop == 3000) {
      localStrategyInfo = this.d;
    }
    if (localStrategyInfo != null)
    {
      int i;
      if ((paramMessageForPtt.extFlag & 1L) > 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        i = NetworkCenter.getInstance().getNetType();
        try
        {
          a(localStrategyInfo);
          long l1 = localStrategyInfo.a.b[i];
          long l2 = paramMessageForPtt.fileSize + l1;
          Object localObject = PreDownloadParams.a((AppRuntime)this.e.get(), localStrategyInfo.b);
          if (l2 > localObject.b[i]) {
            localStrategyInfo.a.b[i] = localObject.b[i];
          } else {
            localStrategyInfo.a.b[i] = ((int)l2);
          }
          if (paramInt == 1) {
            localStrategyInfo.e += 1;
          } else if (paramInt == 3) {
            localStrategyInfo.f += 1;
          }
          if (!QLog.isDevelopLevel()) {
            break label418;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("consume sesion:");
          ((StringBuilder)localObject).append(localStrategyInfo.b);
          ((StringBuilder)localObject).append(" netType:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(" + ");
          ((StringBuilder)localObject).append(paramMessageForPtt.fileSize);
          ((StringBuilder)localObject).append(" = ");
          ((StringBuilder)localObject).append(localStrategyInfo.a.b[i]);
          QLog.d("PTTPreDownloadStrategy", 4, ((StringBuilder)localObject).toString());
          return true;
        }
        finally {}
      }
      if (QLog.isDevelopLevel())
      {
        paramMessageForPtt = new StringBuilder();
        paramMessageForPtt.append("consume sesion:");
        paramMessageForPtt.append(localStrategyInfo.b);
        paramMessageForPtt.append(" not preDownload");
        QLog.d("PTTPreDownloadStrategy", 4, paramMessageForPtt.toString());
      }
    }
    bool = false;
    label418:
    return bool;
  }
  
  public void b()
  {
    this.b = new PTTPreDownloadStrategy.StrategyInfo(1);
    this.c = new PTTPreDownloadStrategy.StrategyInfo(3);
    this.d = new PTTPreDownloadStrategy.StrategyInfo(2);
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.estimatedSize <= 0L) {
      return false;
    }
    PTTPreDownloadStrategy.StrategyInfo localStrategyInfo = null;
    if (paramMessageForPtt.istroop == 0) {
      localStrategyInfo = this.b;
    } else if (paramMessageForPtt.istroop == 1) {
      localStrategyInfo = this.c;
    } else if (paramMessageForPtt.istroop == 3000) {
      localStrategyInfo = this.d;
    }
    if (localStrategyInfo != null)
    {
      int i = NetworkCenter.getInstance().getNetType();
      try
      {
        long l1 = localStrategyInfo.a.b[i];
        localStrategyInfo.a.b[i] += (int)(paramMessageForPtt.estimatedSize - paramMessageForPtt.fileSize);
        long l2 = paramMessageForPtt.estimatedSize;
        paramMessageForPtt.estimatedSize = 0L;
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fixEstimatedSize sesion:");
          localStringBuilder.append(localStrategyInfo.b);
          localStringBuilder.append(" net:");
          localStringBuilder.append(i);
          localStringBuilder.append(", ");
          localStringBuilder.append(l1);
          localStringBuilder.append(" + ");
          localStringBuilder.append(l2);
          localStringBuilder.append(" - ");
          localStringBuilder.append(paramMessageForPtt.fileSize);
          localStringBuilder.append(" = ");
          localStringBuilder.append(localStrategyInfo.a.b[i]);
          localStringBuilder.append(", PttSize:");
          localStringBuilder.append(paramMessageForPtt.fileSize);
          QLog.d("PTTPreDownloadStrategy", 4, localStringBuilder.toString());
        }
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloadStrategy", 4, "reset");
    }
    this.f.removeCallbacks(this);
    this.a = false;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PTTPreDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */