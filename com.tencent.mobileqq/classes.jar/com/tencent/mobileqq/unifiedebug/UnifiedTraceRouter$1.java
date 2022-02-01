package com.tencent.mobileqq.unifiedebug;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class UnifiedTraceRouter$1
  implements Runnable
{
  UnifiedTraceRouter$1(UnifiedTraceRouter paramUnifiedTraceRouter, String paramString, long paramLong, Map paramMap) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this.this$0.a(this.a);
      localObject2 = new StringBuilder();
      UnifiedTraceRouter localUnifiedTraceRouter = this.this$0;
      ((StringBuilder)localObject2).append(localUnifiedTraceRouter.h);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\n");
      localUnifiedTraceRouter.h = ((StringBuilder)localObject2).toString();
      float f2 = this.this$0.d;
      float f1;
      if (((String)localObject1).contains("100%"))
      {
        f1 = f2;
        if (!((String)localObject1).contains("exceed")) {}
      }
      else
      {
        f1 = f2;
        if (this.this$0.b == 32)
        {
          localObject2 = this.this$0.d((String)localObject1);
          f1 = f2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            f1 = Float.parseFloat((String)localObject2);
          }
        }
      }
      localObject2 = this.this$0;
      localObject2 = new UnifiedTraceRouter.TraceRouteInfo((UnifiedTraceRouter)localObject2, ((UnifiedTraceRouter)localObject2).b((String)localObject1), f1);
      ((UnifiedTraceRouter.TraceRouteInfo)localObject2).a = this.this$0.b;
      try
      {
        ((UnifiedTraceRouter.TraceRouteInfo)localObject2).b = InetAddress.getByName(((UnifiedTraceRouter.TraceRouteInfo)localObject2).c).getHostName();
      }
      catch (UnknownHostException localUnknownHostException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("UnknownHost error: ");
        localStringBuilder2.append(localUnknownHostException.getMessage());
        QLog.e("UnifiedTraceRouter", 1, localStringBuilder2.toString());
      }
      this.this$0.f.add(localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = (UnifiedTraceRouter.TraceRouteInfo)this.this$0.f.get(this.this$0.f.size() - 1);
        if (((UnifiedTraceRouter.TraceRouteInfo)localObject1).c.equals(this.this$0.c))
        {
          if (this.this$0.b < 32)
          {
            localObject2 = this.this$0;
            ((UnifiedTraceRouter)localObject2).b = 32;
            ((UnifiedTraceRouter)localObject2).f.remove(localObject1);
            this.this$0.e.postDelayed(this, 100L);
            return;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = this.this$0.f.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (UnifiedTraceRouter.TraceRouteInfo)((Iterator)localObject1).next();
              StringBuilder localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("ttl: ");
              localStringBuilder1.append(((UnifiedTraceRouter.TraceRouteInfo)localObject2).a);
              localStringBuilder1.append(", ");
              localStringBuilder1.append(((UnifiedTraceRouter.TraceRouteInfo)localObject2).b);
              localStringBuilder1.append(", ");
              localStringBuilder1.append(((UnifiedTraceRouter.TraceRouteInfo)localObject2).c);
              localStringBuilder1.append(", ");
              localStringBuilder1.append(((UnifiedTraceRouter.TraceRouteInfo)localObject2).d);
              localStringBuilder1.append("ms");
              QLog.d("UnifiedTraceRouter", 2, localStringBuilder1.toString());
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedTraceRouter", 2, this.this$0.h);
          }
          ((SecSpyFileManager)this.this$0.g.getManager(QQManagerFactory.SEC_SPY_FILEMANAGER)).a(this.b, this.a, this.c, this.this$0.f);
          localObject1 = this.this$0;
          ((UnifiedTraceRouter)localObject1).b = 1;
          ((UnifiedTraceRouter)localObject1).f = new ArrayList();
          return;
        }
        if (this.this$0.b < 32)
        {
          localObject1 = this.this$0;
          ((UnifiedTraceRouter)localObject1).b += 1;
          this.this$0.e.postDelayed(this, 100L);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("traceRoute error: ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("UnifiedTraceRouter", 1, ((StringBuilder)localObject2).toString());
      ((SecSpyFileManager)this.this$0.g.getManager(QQManagerFactory.SEC_SPY_FILEMANAGER)).a(this.b, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter.1
 * JD-Core Version:    0.7.0.1
 */