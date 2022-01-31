package com.tencent.mobileqq.filemanager.data;

import android.text.TextUtils;
import arby;
import arso;
import awge;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileManagerProxy$4
  implements Runnable
{
  public FileManagerProxy$4(arby paramarby, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject2 = "select * from ( select * from " + FileManagerEntity.tableName() + " where bDelInFM = 0  and nRelatedSessionId = " + this.jdField_a_of_type_Long + "  order by srvTime desc limit " + 2000 + ") ";
    awgf localawgf = arby.a(this.this$0).getEntityManagerFactory().createEntityManager();
    localObject2 = localawgf.a(FileManagerEntity.class, (String)localObject2, null);
    for (;;)
    {
      synchronized (arby.a(this.this$0))
      {
        arby.a(this.this$0, new HashMap());
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("find ZipList file:");
          if (localObject2 == null)
          {
            i = 0;
            QLog.i("FileManagerProxy<FileAssistant>", 1, i);
          }
        }
        else
        {
          if (localObject2 == null) {
            return;
          }
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            return;
          }
          ??? = (FileManagerEntity)((Iterator)localObject2).next();
          if ((this.jdField_a_of_type_JavaLangString == null) || (((FileManagerEntity)???).zipFileId == null) || (((FileManagerEntity)???).zipFileId.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
            break label259;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": fileId is error! continiu");
        }
      }
      int i = ((List)localObject2).size();
      continue;
      label259:
      if (TextUtils.isEmpty(((FileManagerEntity)???).strServerPath))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": serverPath is empty!");
        }
        ((FileManagerEntity)???).setStatus(1001);
        localObject1.b((awge)???);
      }
      else if (!arso.b(((FileManagerEntity)???).getFilePath()))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": file not exist!");
        }
        ((FileManagerEntity)???).setStatus(1001);
        localObject1.b((awge)???);
      }
      else
      {
        try
        {
          synchronized (arby.a(this.this$0))
          {
            arby.a(this.this$0).put(((FileManagerEntity)???).zipInnerPath, ???);
          }
        }
        catch (Exception localException)
        {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + " getPath error:" + localException.toString());
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy.4
 * JD-Core Version:    0.7.0.1
 */