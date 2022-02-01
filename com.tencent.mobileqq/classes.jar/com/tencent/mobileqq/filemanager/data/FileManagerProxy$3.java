package com.tencent.mobileqq.filemanager.data;

import android.content.ContentValues;

class FileManagerProxy$3
  implements Runnable
{
  FileManagerProxy$3(FileManagerProxy paramFileManagerProxy, ContentValues paramContentValues, long paramLong) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy.3
 * JD-Core Version:    0.7.0.1
 */