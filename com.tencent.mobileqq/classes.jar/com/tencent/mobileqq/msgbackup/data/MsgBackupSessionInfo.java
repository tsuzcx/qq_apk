package com.tencent.mobileqq.msgbackup.data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class MsgBackupSessionInfo
{
  public int a;
  public long a;
  public String a;
  public ConcurrentHashMap<Long, MsgBackupSessionTask> a;
  public AtomicBoolean a;
  public boolean a;
  public String b;
  public ConcurrentHashMap<Long, MsgBackupSessionTask> b = new ConcurrentHashMap();
  public boolean b;
  public boolean c;
  public boolean d;
  
  public MsgBackupSessionInfo()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupSessionInfo
 * JD-Core Version:    0.7.0.1
 */