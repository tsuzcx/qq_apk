package com.tencent.mobileqq.filemanager.data;

import android.content.ContentValues;
import apen;

public class FileManagerProxy$2
  implements Runnable
{
  public FileManagerProxy$2(apen paramapen, ContentValues paramContentValues, long paramLong) {}
  
  public void run()
  {
    try
    {
      this.this$0.a(FileManagerEntity.tableName(), this.jdField_a_of_type_AndroidContentContentValues, "nSessionId=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) }, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy.2
 * JD-Core Version:    0.7.0.1
 */