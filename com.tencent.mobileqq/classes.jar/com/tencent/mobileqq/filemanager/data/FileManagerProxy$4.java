package com.tencent.mobileqq.filemanager.data;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

class FileManagerProxy$4
  implements Runnable
{
  FileManagerProxy$4(FileManagerProxy paramFileManagerProxy, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ( select * from ");
    ((StringBuilder)localObject1).append(FileManagerEntity.tableName());
    ((StringBuilder)localObject1).append(" where bDelInFM = 0  and nRelatedSessionId = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject1).append("  order by srvTime desc limit ");
    ((StringBuilder)localObject1).append(2000);
    ((StringBuilder)localObject1).append(") ");
    Object localObject3 = ((StringBuilder)localObject1).toString();
    localObject1 = FileManagerProxy.a(this.this$0).getEntityManagerFactory().createEntityManager();
    localObject3 = ((EntityManager)localObject1).rawQuery(FileManagerEntity.class, (String)localObject3, null);
    synchronized (FileManagerProxy.a(this.this$0))
    {
      FileManagerProxy.a(this.this$0, new HashMap());
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("find ZipList file:");
        int i;
        if (localObject3 == null) {
          i = 0;
        } else {
          i = ((List)localObject3).size();
        }
        ((StringBuilder)???).append(i);
        QLog.i("FileManagerProxy<FileAssistant>", 1, ((StringBuilder)???).toString());
      }
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ??? = (FileManagerEntity)((Iterator)localObject3).next();
            if ((this.jdField_a_of_type_JavaLangString != null) && (((FileManagerEntity)???).zipFileId != null) && (!((FileManagerEntity)???).zipFileId.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
            {
              if (QLog.isDevelopLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append(((FileManagerEntity)???).fileName);
                ((StringBuilder)???).append(": fileId is error! continiu");
                QLog.e("FileManagerProxy<FileAssistant>", 1, ((StringBuilder)???).toString());
              }
            }
            else if (TextUtils.isEmpty(((FileManagerEntity)???).strServerPath))
            {
              if (QLog.isDevelopLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append(((FileManagerEntity)???).fileName);
                ((StringBuilder)???).append(": serverPath is empty!");
                QLog.e("FileManagerProxy<FileAssistant>", 1, ((StringBuilder)???).toString());
              }
              ((FileManagerEntity)???).setStatus(1001);
              ((EntityManager)localObject1).remove((Entity)???);
            }
            else if (!FileUtil.a(((FileManagerEntity)???).getFilePath()))
            {
              if (QLog.isDevelopLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append(((FileManagerEntity)???).fileName);
                ((StringBuilder)???).append(": file not exist!");
                QLog.e("FileManagerProxy<FileAssistant>", 1, ((StringBuilder)???).toString());
              }
              ((FileManagerEntity)???).setStatus(1001);
              ((EntityManager)localObject1).remove((Entity)???);
            }
            else
            {
              try
              {
                synchronized (FileManagerProxy.a(this.this$0))
                {
                  FileManagerProxy.a(this.this$0).put(((FileManagerEntity)???).zipInnerPath, ???);
                }
              }
              catch (Exception localException)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(((FileManagerEntity)???).fileName);
                localStringBuilder.append(" getPath error:");
                localStringBuilder.append(localException.toString());
                QLog.e("FileManagerProxy<FileAssistant>", 1, localStringBuilder.toString());
                localException.printStackTrace();
              }
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy.4
 * JD-Core Version:    0.7.0.1
 */