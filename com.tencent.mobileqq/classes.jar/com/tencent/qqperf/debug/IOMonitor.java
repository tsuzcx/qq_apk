package com.tencent.qqperf.debug;

import android.os.Environment;
import java.io.File;

public class IOMonitor
{
  private static FileIOMonitor jdField_a_of_type_ComTencentQqperfDebugFileIOMonitor = null;
  static IOMonitor jdField_a_of_type_ComTencentQqperfDebugIOMonitor;
  private static SQLiteMonitor jdField_a_of_type_ComTencentQqperfDebugSQLiteMonitor = null;
  public static File a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  private boolean e = false;
  
  static
  {
    jdField_a_of_type_ComTencentQqperfDebugIOMonitor = null;
    jdField_a_of_type_Boolean = false;
    b = false;
    c = false;
    d = false;
    jdField_a_of_type_JavaIoFile = null;
    File localFile = Environment.getExternalStorageDirectory();
    jdField_a_of_type_JavaIoFile = new File(localFile + "/tencent/SNGAPM/");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_ComTencentQqperfDebugFileIOMonitor != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.IOMonitor
 * JD-Core Version:    0.7.0.1
 */