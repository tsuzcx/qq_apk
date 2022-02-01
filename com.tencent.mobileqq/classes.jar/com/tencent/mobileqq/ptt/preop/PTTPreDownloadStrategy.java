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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PTTPreDownloadStrategy.StrategyInfo jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo = new PTTPreDownloadStrategy.StrategyInfo(1);
  private WeakReference<AppRuntime> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private PTTPreDownloadStrategy.StrategyInfo b = new PTTPreDownloadStrategy.StrategyInfo(3);
  private PTTPreDownloadStrategy.StrategyInfo c = new PTTPreDownloadStrategy.StrategyInfo(2);
  
  public PTTPreDownloadStrategy(AppRuntime paramAppRuntime, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private long a(MessageForPtt paramMessageForPtt)
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
  
  private void a(PTTPreDownloadStrategy.StrategyInfo paramStrategyInfo)
  {
    if (paramStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int == -2147483648)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PTTPreDownloadStrategy", 4, "initStrategyInfoIfNeccessary");
      }
      Date localDate = new Date();
      Object localObject1 = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      PreDownloadParams.Params localParams1 = PreDownloadParams.a((AppRuntime)localObject1, paramStrategyInfo.jdField_a_of_type_Int);
      paramStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int = localParams1.jdField_a_of_type_Int;
      int i;
      if (paramStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int > 0)
      {
        PreDownloadParams.Params localParams2 = new PreDownloadParams.Params();
        localObject1 = PreDownloadParams.a((AppRuntime)localObject1, paramStrategyInfo.jdField_a_of_type_Int, localParams2);
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
            paramStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localParams2.jdField_a_of_type_ArrayOfInt[i];
            i += 1;
          }
        }
        if (localParams2.jdField_a_of_type_Int > -1)
        {
          localObject1 = new HashMap();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localParams2.jdField_a_of_type_Int);
          i = 0;
          while (i <= 5)
          {
            ((StringBuilder)localObject2).append('#');
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append('_');
            ((StringBuilder)localObject2).append(localParams2.jdField_a_of_type_ArrayOfInt[i]);
            i += 1;
          }
          ((HashMap)localObject1).put("RemainCfg", ((StringBuilder)localObject2).toString());
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttPreDownloadDailyRemain", true, 0L, 0L, (HashMap)localObject1, "");
        }
        i = 0;
        while (i <= 5)
        {
          paramStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localParams1.jdField_a_of_type_ArrayOfInt[i];
          i += 1;
        }
      }
      b(paramStrategyInfo);
      if (!this.jdField_a_of_type_Boolean)
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
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, l1);
      }
    }
  }
  
  private void b(PTTPreDownloadStrategy.StrategyInfo paramStrategyInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStrategyInfo.jdField_a_of_type_Int);
    localStringBuilder.append(":");
    localStringBuilder.append(paramStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params);
    paramStrategyInfo = localStringBuilder.toString();
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloadStrategy", 4, paramStrategyInfo);
    }
  }
  
  private void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloadStrategy", 4, "save");
    }
    AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != -2147483648)
    {
      PreDownloadParams.a(localAppRuntime, this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo.jdField_a_of_type_Int);
      b(this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo);
      localHashMap.put("C2CDownload", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo.b));
      localHashMap.put("C2CView", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo.d));
      localHashMap.put("C2CCancel", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo.e));
      localHashMap.put("C2CEscape", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo.c));
    }
    if (this.b.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != -2147483648)
    {
      PreDownloadParams.a(localAppRuntime, this.b.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.b.jdField_a_of_type_Int);
      b(this.b);
      b(this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo);
      localHashMap.put("GroupDownload", String.valueOf(this.b.b));
      localHashMap.put("GroupView", String.valueOf(this.b.d));
      localHashMap.put("GroupCancel", String.valueOf(this.b.e));
      localHashMap.put("GroupEscape", String.valueOf(this.b.c));
    }
    if (this.c.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != -2147483648)
    {
      PreDownloadParams.a(localAppRuntime, this.c.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.c.jdField_a_of_type_Int);
      b(this.c);
      localHashMap.put("DiscussDownload", String.valueOf(this.c.b));
      localHashMap.put("DiscussView", String.valueOf(this.c.d));
      localHashMap.put("DiscussCancel", String.valueOf(this.c.e));
      localHashMap.put("DiscussEscape", String.valueOf(this.c.c));
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    PTTPreDownloadStrategy.StrategyInfo localStrategyInfo;
    if (paramMessageForPtt.istroop == 0) {
      localStrategyInfo = this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo;
    } else if (paramMessageForPtt.istroop == 1) {
      localStrategyInfo = this.b;
    } else if (paramMessageForPtt.istroop == 3000) {
      localStrategyInfo = this.c;
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
        if (localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int > 0)
        {
          long l2 = paramMessageForPtt.msgRecTime - paramMessageForPtt.msgTime;
          if ((l2 >= -10000L) && (l2 <= localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int * 24 * 60 * 60 * 100))
          {
            l2 = a(paramMessageForPtt);
            if (l2 > localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i])
            {
              localStrategyInfo.c += 1;
            }
            else
            {
              localStrategyInfo.b += 1;
              paramMessageForPtt.estimatedSize = l2;
              l1 = localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
              localObject = localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt;
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
          ((StringBuilder)localObject).append(localStrategyInfo.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(" net:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(" - ");
          ((StringBuilder)localObject).append(paramMessageForPtt.estimatedSize);
          ((StringBuilder)localObject).append(" = ");
          ((StringBuilder)localObject).append(localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i]);
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
      localStrategyInfo = this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo;
    } else if (paramMessageForPtt.istroop == 1) {
      localStrategyInfo = this.b;
    } else if (paramMessageForPtt.istroop == 3000) {
      localStrategyInfo = this.c;
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
          long l1 = localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
          long l2 = paramMessageForPtt.fileSize + l1;
          Object localObject = PreDownloadParams.a((AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localStrategyInfo.jdField_a_of_type_Int);
          if (l2 > localObject.jdField_a_of_type_ArrayOfInt[i]) {
            localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localObject.jdField_a_of_type_ArrayOfInt[i];
          } else {
            localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = ((int)l2);
          }
          if (paramInt == 1) {
            localStrategyInfo.d += 1;
          } else if (paramInt == 3) {
            localStrategyInfo.e += 1;
          }
          if (!QLog.isDevelopLevel()) {
            break label418;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("consume sesion:");
          ((StringBuilder)localObject).append(localStrategyInfo.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(" netType:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(" + ");
          ((StringBuilder)localObject).append(paramMessageForPtt.fileSize);
          ((StringBuilder)localObject).append(" = ");
          ((StringBuilder)localObject).append(localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i]);
          QLog.d("PTTPreDownloadStrategy", 4, ((StringBuilder)localObject).toString());
          return true;
        }
        finally {}
      }
      if (QLog.isDevelopLevel())
      {
        paramMessageForPtt = new StringBuilder();
        paramMessageForPtt.append("consume sesion:");
        paramMessageForPtt.append(localStrategyInfo.jdField_a_of_type_Int);
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
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo = new PTTPreDownloadStrategy.StrategyInfo(1);
    this.b = new PTTPreDownloadStrategy.StrategyInfo(3);
    this.c = new PTTPreDownloadStrategy.StrategyInfo(2);
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.estimatedSize <= 0L) {
      return false;
    }
    PTTPreDownloadStrategy.StrategyInfo localStrategyInfo = null;
    if (paramMessageForPtt.istroop == 0) {
      localStrategyInfo = this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloadStrategy$StrategyInfo;
    } else if (paramMessageForPtt.istroop == 1) {
      localStrategyInfo = this.b;
    } else if (paramMessageForPtt.istroop == 3000) {
      localStrategyInfo = this.c;
    }
    if (localStrategyInfo != null)
    {
      int i = NetworkCenter.getInstance().getNetType();
      try
      {
        long l1 = localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
        localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] += (int)(paramMessageForPtt.estimatedSize - paramMessageForPtt.fileSize);
        long l2 = paramMessageForPtt.estimatedSize;
        paramMessageForPtt.estimatedSize = 0L;
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fixEstimatedSize sesion:");
          localStringBuilder.append(localStrategyInfo.jdField_a_of_type_Int);
          localStringBuilder.append(" net:");
          localStringBuilder.append(i);
          localStringBuilder.append(", ");
          localStringBuilder.append(l1);
          localStringBuilder.append(" + ");
          localStringBuilder.append(l2);
          localStringBuilder.append(" - ");
          localStringBuilder.append(paramMessageForPtt.fileSize);
          localStringBuilder.append(" = ");
          localStringBuilder.append(localStrategyInfo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i]);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PTTPreDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */