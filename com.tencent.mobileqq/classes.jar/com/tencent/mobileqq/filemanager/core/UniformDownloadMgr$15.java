package com.tencent.mobileqq.filemanager.core;

import apdc;
import apdh;
import apdi;
import apwj;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$15
  implements Runnable
{
  public UniformDownloadMgr$15(apdc paramapdc) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject4;
    Object localObject5;
    synchronized (apdc.a(this.this$0))
    {
      if (apdc.a(this.this$0).size() > 0)
      {
        localObject4 = apdc.a(this.this$0).entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (apdh)((Map.Entry)((Iterator)localObject4).next()).getValue();
          if ((((apdh)localObject5).jdField_a_of_type_Apwj != null) && (8 == ((apdh)localObject5).jdField_a_of_type_Apwj.f()) && (2 == ((apdh)localObject5).jdField_a_of_type_Apwj.g())) {
            localArrayList.add(localObject5);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    Object localObject3;
    while (((Iterator)???).hasNext())
    {
      localObject3 = (apdh)((Iterator)???).next();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> resumeRuningGenDownloadOfOldApp, url:[" + ((apdh)localObject3).jdField_a_of_type_JavaLangString + "]");
      ((apdh)localObject3).jdField_a_of_type_Apwj.a();
    }
    if (apdc.a(this.this$0))
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. start resume");
      localObject3 = this.this$0.a();
      this.this$0.d();
      ??? = new HashMap();
      if ((localObject3 != null) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject3).next();
          localObject4 = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (apdi)((Map.Entry)localObject5).getValue();
          if (localObject5 != null)
          {
            if (((apdi)localObject5).jdField_a_of_type_Boolean)
            {
              ((Map)???).put(localObject4, localObject5);
            }
            else
            {
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject4 + "] nId:[" + ((apdi)localObject5).jdField_a_of_type_Int + "] - 1");
              apdc.a(this.this$0, (String)localObject4, ((apdi)localObject5).jdField_a_of_type_JavaLangString, ((apdi)localObject5).jdField_a_of_type_Long, ((apdi)localObject5).b, ((apdi)localObject5).jdField_a_of_type_AndroidOsBundle, ((apdi)localObject5).jdField_a_of_type_Int, true);
            }
          }
          else {
            QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + (String)localObject4 + "] -1");
          }
        }
      }
      if (((Map)???).size() > 0)
      {
        ??? = ((Map)???).entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)???).next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (apdi)((Map.Entry)localObject4).getValue();
          if (localObject4 != null)
          {
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject3 + "] nId:[" + ((apdi)localObject4).jdField_a_of_type_Int + "] - 2");
            apdc.a(this.this$0, (String)localObject3, ((apdi)localObject4).jdField_a_of_type_JavaLangString, ((apdi)localObject4).jdField_a_of_type_Long, ((apdi)localObject4).b, ((apdi)localObject4).jdField_a_of_type_AndroidOsBundle, ((apdi)localObject4).jdField_a_of_type_Int, true);
          }
          else
          {
            QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + (String)localObject3 + "] -2");
          }
        }
      }
    }
    else
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. not resume");
      this.this$0.d();
    }
    apdc.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.15
 * JD-Core Version:    0.7.0.1
 */