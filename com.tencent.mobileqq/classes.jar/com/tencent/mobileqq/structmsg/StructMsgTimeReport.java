package com.tencent.mobileqq.structmsg;

import android.os.SystemClock;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Random;

public class StructMsgTimeReport
{
  private long jdField_a_of_type_Long = -1L;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % 300 != 1) {
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Long == -1L) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append("");
    localHashMap.put("cost", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    localHashMap.put("layout", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    localHashMap.put("first", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "structmsg_builder_getview", true, 0L, 0L, localHashMap, "", false);
    this.jdField_a_of_type_Long = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgTimeReport
 * JD-Core Version:    0.7.0.1
 */