package com.tencent.mobileqq.hotpic;

import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class DiskStorageManager
  implements DiskStorageManagerInterface
{
  private int jdField_a_of_type_Int = 0;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  
  public DiskStorageManager()
  {
    this(50);
  }
  
  public DiskStorageManager(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    throw new IllegalArgumentException("Max count must be positive number!");
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
    while (paramList.hasNext())
    {
      File localFile = (File)paramList.next();
      if (!a(localFile, 0L, i))
      {
        localFile.length();
        if (localFile.delete())
        {
          i -= 1;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delte file ");
          localStringBuilder.append(localFile.getName());
          localStringBuilder.append(" fail");
          Log.d("DiskStorageManager", localStringBuilder.toString());
        }
      }
    }
  }
  
  private void b(File paramFile)
  {
    a(HotVideoUtils.a(paramFile.getParentFile()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.DiskStorageManager
 * JD-Core Version:    0.7.0.1
 */