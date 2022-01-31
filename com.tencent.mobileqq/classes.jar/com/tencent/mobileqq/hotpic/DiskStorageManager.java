package com.tencent.mobileqq.hotpic;

import android.util.Log;
import arau;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class DiskStorageManager
{
  private int jdField_a_of_type_Int;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  
  public DiskStorageManager()
  {
    this(50);
  }
  
  public DiskStorageManager(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max count must be positive number!");
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(List<File> paramList)
  {
    int i = paramList.size();
    if (i <= this.jdField_a_of_type_Int)
    {
      QLog.d("DiskStorageManager", 2, "trim directly return data");
      return;
    }
    paramList = paramList.iterator();
    label31:
    File localFile;
    if (paramList.hasNext())
    {
      localFile = (File)paramList.next();
      if (a(localFile, 0L, i)) {
        break label112;
      }
      localFile.length();
      if (!localFile.delete()) {
        break label79;
      }
      i -= 1;
    }
    label79:
    label112:
    for (;;)
    {
      break label31;
      break;
      Log.d("DiskStorageManager", "delte file " + localFile.getName() + " fail");
    }
  }
  
  private void b(File paramFile)
  {
    a(arau.a(paramFile.getParentFile()));
  }
  
  public void a(File paramFile)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new DiskStorageManager.TouchCallable(this, paramFile));
  }
  
  protected boolean a(File paramFile, long paramLong, int paramInt)
  {
    return paramInt <= this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.DiskStorageManager
 * JD-Core Version:    0.7.0.1
 */