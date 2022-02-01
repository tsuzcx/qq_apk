package com.tencent.mobileqq.uniformdownload.core;

import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfo;
import com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfoMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class UniformDownloadMgr$8
  implements Runnable
{
  UniformDownloadMgr$8(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    UniformDownloadMgr.b(this.this$0).d();
    if (UniformDownloadMgr.d(this.this$0))
    {
      QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. start resume");
      Object localObject2 = UniformDownloadMgr.e(this.this$0).b();
      UniformDownloadMgr.e(this.this$0).c();
      Object localObject1 = new HashMap();
      Object localObject4;
      Object localObject3;
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (DownloadingRbResmeInfo)((Map.Entry)localObject4).getValue();
          if (localObject4 != null)
          {
            if (((DownloadingRbResmeInfo)localObject4).e)
            {
              ((Map)localObject1).put(localObject3, localObject4);
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[");
              localStringBuilder.append((String)localObject3);
              localStringBuilder.append("] nId:[");
              localStringBuilder.append(((DownloadingRbResmeInfo)localObject4).a);
              localStringBuilder.append("] - 1");
              QLog.i("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
              this.this$0.a(new DownloadInfoBuilder().a((String)localObject3).b(((DownloadingRbResmeInfo)localObject4).b).a(((DownloadingRbResmeInfo)localObject4).d).c(((DownloadingRbResmeInfo)localObject4).c).a(((DownloadingRbResmeInfo)localObject4).f).a(((DownloadingRbResmeInfo)localObject4).a).a(true));
            }
          }
          else
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[");
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("] -1");
            QLog.e("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject4).toString());
          }
        }
      }
      if (((Map)localObject1).size() > 0)
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (DownloadingRbResmeInfo)((Map.Entry)localObject3).getValue();
          if (localObject3 != null)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[");
            ((StringBuilder)localObject4).append((String)localObject2);
            ((StringBuilder)localObject4).append("] nId:[");
            ((StringBuilder)localObject4).append(((DownloadingRbResmeInfo)localObject3).a);
            ((StringBuilder)localObject4).append("] - 2");
            QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject4).toString());
            this.this$0.a(new DownloadInfoBuilder().a((String)localObject2).b(((DownloadingRbResmeInfo)localObject3).b).a(((DownloadingRbResmeInfo)localObject3).d).c(((DownloadingRbResmeInfo)localObject3).c).a(((DownloadingRbResmeInfo)localObject3).f).a(((DownloadingRbResmeInfo)localObject3).a).a(true));
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append("] -2");
            QLog.e("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject3).toString());
          }
        }
      }
    }
    else
    {
      QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. not resume");
      UniformDownloadMgr.e(this.this$0).c();
    }
    UniformDownloadMgr.b(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.8
 * JD-Core Version:    0.7.0.1
 */