package com.tencent.qqperf.debug;

import android.os.Environment;
import java.io.File;

public class IOMonitor
{
  private static FileIOMonitor jdField_a_of_type_ComTencentQqperfDebugFileIOMonitor;
  static IOMonitor jdField_a_of_type_ComTencentQqperfDebugIOMonitor;
  private static SQLiteMonitor jdField_a_of_type_ComTencentQqperfDebugSQLiteMonitor;
  public static File a;
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  public static boolean d = false;
  private boolean e = false;
  
  static
  {
    File localFile = Environment.getExternalStorageDirectory();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile);
    localStringBuilder.append("/tencent/SNGAPM/");
    jdField_a_of_type_JavaIoFile = new File(localStringBuilder.toString());
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    FileIOMonitor localFileIOMonitor = jdField_a_of_type_ComTencentQqperfDebugFileIOMonitor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.debug.IOMonitor
 * JD-Core Version:    0.7.0.1
 */