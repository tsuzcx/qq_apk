package com.tencent.qqperf.debug;

import com.tencent.mobileqq.debug.io.util.NativeMethodHook;

public class FileIOMonitor
  extends Monitor
{
  static FileIOMonitor jdField_a_of_type_ComTencentQqperfDebugFileIOMonitor = null;
  private int jdField_a_of_type_Int;
  private NativeMethodHook jdField_a_of_type_ComTencentMobileqqDebugIoUtilNativeMethodHook = null;
  private String jdField_a_of_type_JavaLangString = null;
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDebugIoUtilNativeMethodHook = new NativeMethodHook();
    this.jdField_a_of_type_ComTencentMobileqqDebugIoUtilNativeMethodHook.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.FileIOMonitor
 * JD-Core Version:    0.7.0.1
 */