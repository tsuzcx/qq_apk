package com.tencent.sharp.jni;

import android.content.Intent;
import bhmk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

abstract class TraeAudioManager$switchThread
  extends Thread
{
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap = null;
  boolean jdField_a_of_type_Boolean = true;
  boolean[] jdField_a_of_type_ArrayOfBoolean = { false };
  boolean b = false;
  
  TraeAudioManager$switchThread(TraeAudioManager paramTraeAudioManager, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + paramLong);
    this.jdField_a_of_type_Long = paramLong;
    this.b = BaseApplicationImpl.processName.endsWith(":video");
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "switchThread.init");
    }
  }
  
  public abstract String a();
  
  public abstract void a();
  
  void a(int paramInt)
  {
    this.this$0.b();
    AudioDeviceInterface.LogTraceEntry(a() + " err:" + paramInt + " ConnectedDevice: " + this.this$0.a.d());
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.this$0.a();
    }
    do
    {
      return;
      this.this$0.b = this.this$0.a.d();
      localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get("PARAM_SESSIONID");
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, " sessonID:" + localObject + "sessionConnectedDev: " + this.this$0.b);
      }
      if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L)) {
        break;
      }
      this.this$0.a();
    } while (!QLog.isColorLevel());
    QLog.w(this.jdField_a_of_type_JavaLangString, 2, "processDeviceConnectRes sid null,don't send res");
    return;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this.jdField_a_of_type_JavaUtilHashMap.get("PARAM_DEVICE"));
    if (this.this$0.a((Intent)localObject, this.jdField_a_of_type_JavaUtilHashMap, paramInt) == 0) {
      this.this$0.a();
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "switchThread start, [" + getClass().getSimpleName() + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
      }
      super.start();
      return;
    }
    finally {}
  }
  
  public void a(HashMap<String, Object> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public abstract void b();
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "quit.begin, _running[" + this.jdField_a_of_type_Boolean + "], cur_seq[" + this.jdField_a_of_type_Long + "], new_seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_Boolean = false;
    interrupt();
    b();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i != 0) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait();
      label102:
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "quit.end, cur_seq[" + this.jdField_a_of_type_Long + "], new_seq[" + paramLong + "]");
      }
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label102;
    }
  }
  
  void e()
  {
    this.this$0.a.d(a());
    a(0);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "run begin, seq[" + this.jdField_a_of_type_Long + "], _running[" + this.jdField_a_of_type_Boolean + "]");
    }
    this.this$0.b();
    a();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = true;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "run end, seq[" + this.jdField_a_of_type_Long + "]");
      }
      return;
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.switchThread
 * JD-Core Version:    0.7.0.1
 */