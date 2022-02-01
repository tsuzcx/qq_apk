package com.tencent.qqperf.monitor.file;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.nativememorymonitor.library.IFileMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class ExternalDirFileOperationMonitor
  implements IFileMonitor
{
  Context jdField_a_of_type_AndroidContentContext;
  String jdField_a_of_type_JavaLangString;
  
  public ExternalDirFileOperationMonitor(Context paramContext)
  {
    File localFile = paramContext.getExternalCacheDir();
    if (localFile != null) {
      this.jdField_a_of_type_JavaLangString = localFile.getParent();
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(String paramString1, String paramString2)
  {
    if (!ExternalDirOperationConfig.a(this.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (paramString1.startsWith(ExternalDirOperationConfig.jdField_a_of_type_JavaLangString))
      {
        if (paramString1.startsWith(this.jdField_a_of_type_JavaLangString)) {
          return;
        }
        if (paramString2 == null) {
          paramString2 = String.format("external file deleted %s", new Object[] { paramString1 });
        } else {
          paramString2 = String.format("external file rename from %s to %s", new Object[] { paramString1, paramString2 });
        }
        QLog.e("ExternalDirFileOperationMonitor", 1, paramString2);
        Object localObject = ExternalDirOperationConfigProcessor.a().jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString1.startsWith((String)((Iterator)localObject).next())) {
            return;
          }
        }
        int i = ExternalDirOperationConfig.jdField_a_of_type_JavaLangString.length();
        int j = paramString1.lastIndexOf(File.separator);
        if (i >= j) {
          paramString1 = "";
        } else {
          paramString1 = paramString1.substring(i, j);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("EXTERNAL_FILE_DELETE_DIR:");
        ((StringBuilder)localObject).append(paramString1);
        CaughtExceptionReport.a(new Throwable(((StringBuilder)localObject).toString()), paramString2);
      }
    }
  }
  
  public void onFileRemove(String paramString)
  {
    a(paramString, null);
  }
  
  public void onFileRename(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.file.ExternalDirFileOperationMonitor
 * JD-Core Version:    0.7.0.1
 */