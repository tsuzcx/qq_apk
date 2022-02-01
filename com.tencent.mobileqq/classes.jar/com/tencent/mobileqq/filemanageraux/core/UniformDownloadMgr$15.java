package com.tencent.mobileqq.filemanageraux.core;

import aure;
import aurj;
import aurk;
import auuk;
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
  public UniformDownloadMgr$15(aure paramaure) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject4;
    Object localObject5;
    synchronized (aure.a(this.this$0))
    {
      if (aure.a(this.this$0).size() > 0)
      {
        localObject4 = aure.a(this.this$0).entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (aurj)((Map.Entry)((Iterator)localObject4).next()).getValue();
          if ((((aurj)localObject5).jdField_a_of_type_Auuk != null) && (8 == ((aurj)localObject5).jdField_a_of_type_Auuk.f()) && (2 == ((aurj)localObject5).jdField_a_of_type_Auuk.g())) {
            localArrayList.add(localObject5);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    Object localObject3;
    while (((Iterator)???).hasNext())
    {
      localObject3 = (aurj)((Iterator)???).next();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> resumeRuningGenDownloadOfOldApp, url:[" + ((aurj)localObject3).jdField_a_of_type_JavaLangString + "]");
      ((aurj)localObject3).jdField_a_of_type_Auuk.a();
    }
    if (aure.a(this.this$0))
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
          localObject5 = (aurk)((Map.Entry)localObject5).getValue();
          if (localObject5 != null)
          {
            if (((aurk)localObject5).jdField_a_of_type_Boolean)
            {
              ((Map)???).put(localObject4, localObject5);
            }
            else
            {
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject4 + "] nId:[" + ((aurk)localObject5).jdField_a_of_type_Int + "] - 1");
              aure.a(this.this$0, (String)localObject4, ((aurk)localObject5).jdField_a_of_type_JavaLangString, ((aurk)localObject5).jdField_a_of_type_Long, ((aurk)localObject5).b, ((aurk)localObject5).jdField_a_of_type_AndroidOsBundle, ((aurk)localObject5).jdField_a_of_type_Int, true);
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
          localObject4 = (aurk)((Map.Entry)localObject4).getValue();
          if (localObject4 != null)
          {
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject3 + "] nId:[" + ((aurk)localObject4).jdField_a_of_type_Int + "] - 2");
            aure.a(this.this$0, (String)localObject3, ((aurk)localObject4).jdField_a_of_type_JavaLangString, ((aurk)localObject4).jdField_a_of_type_Long, ((aurk)localObject4).b, ((aurk)localObject4).jdField_a_of_type_AndroidOsBundle, ((aurk)localObject4).jdField_a_of_type_Int, true);
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
    aure.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.15
 * JD-Core Version:    0.7.0.1
 */