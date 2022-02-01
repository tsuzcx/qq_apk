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
    UniformDownloadMgr.a(this.this$0).d();
    if (UniformDownloadMgr.a(this.this$0))
    {
      QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. start resume");
      Object localObject2 = UniformDownloadMgr.a(this.this$0).a();
      UniformDownloadMgr.a(this.this$0).a();
      Object localObject1 = new HashMap();
      Object localObject3;
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (DownloadingRbResmeInfo)((Map.Entry)localObject4).getValue();
          if (localObject4 != null)
          {
            if (((DownloadingRbResmeInfo)localObject4).jdField_a_of_type_Boolean)
            {
              ((Map)localObject1).put(localObject3, localObject4);
            }
            else
            {
              QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject3 + "] nId:[" + ((DownloadingRbResmeInfo)localObject4).jdField_a_of_type_Int + "] - 1");
              this.this$0.a(new DownloadInfoBuilder().a((String)localObject3).b(((DownloadingRbResmeInfo)localObject4).jdField_a_of_type_JavaLangString).a(((DownloadingRbResmeInfo)localObject4).jdField_a_of_type_Long).c(((DownloadingRbResmeInfo)localObject4).b).a(((DownloadingRbResmeInfo)localObject4).jdField_a_of_type_AndroidOsBundle).a(((DownloadingRbResmeInfo)localObject4).jdField_a_of_type_Int).a(true));
            }
          }
          else {
            QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + (String)localObject3 + "] -1");
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
            QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject2 + "] nId:[" + ((DownloadingRbResmeInfo)localObject3).jdField_a_of_type_Int + "] - 2");
            this.this$0.a(new DownloadInfoBuilder().a((String)localObject2).b(((DownloadingRbResmeInfo)localObject3).jdField_a_of_type_JavaLangString).a(((DownloadingRbResmeInfo)localObject3).jdField_a_of_type_Long).c(((DownloadingRbResmeInfo)localObject3).b).a(((DownloadingRbResmeInfo)localObject3).jdField_a_of_type_AndroidOsBundle).a(((DownloadingRbResmeInfo)localObject3).jdField_a_of_type_Int).a(true));
          }
          else
          {
            QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + (String)localObject2 + "] -2");
          }
        }
      }
    }
    else
    {
      QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. not resume");
      UniformDownloadMgr.a(this.this$0).a();
    }
    UniformDownloadMgr.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.8
 * JD-Core Version:    0.7.0.1
 */