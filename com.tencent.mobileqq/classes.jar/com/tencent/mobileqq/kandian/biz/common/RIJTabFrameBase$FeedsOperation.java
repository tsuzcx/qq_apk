package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase$FeedsOperation;", "", "()V", "operationBitmap", "", "getOperationBitmap", "()I", "setOperationBitmap", "(I)V", "tabFrameVisibleTimeMillis", "", "userStayInTabFrameTimeMillis", "getUserStayInTabFrameTimeMillis", "()J", "setUserStayInTabFrameTimeMillis", "(J)V", "reset", "", "setOperationFlag", "operationBitFlag", "channelId", "startTabFrameStayTimeCalculate", "stopTabFrameStayTimeCalculate", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJTabFrameBase$FeedsOperation
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private long b;
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public final void a()
  {
    RIJXTabBadgeReporter.a.a();
    this.jdField_a_of_type_Int = 0;
    ReadinjoyReportUtils.b();
    this.jdField_a_of_type_Long = 0L;
    QLog.d("RIJTabFrameBase", 1, "reset feeds operation");
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    RIJXTabBadgeReporter.a.a(paramInt2, paramInt1);
    this.jdField_a_of_type_Int |= paramInt1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set operation flag : ");
    localStringBuilder.append(paramInt1);
    QLog.d("RIJTabFrameBase", 1, localStringBuilder.toString());
    ReadinjoyReportUtils.a(paramInt1);
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Long += NetConnInfoCenter.getServerTimeMillis() - this.b;
  }
  
  public final void c()
  {
    this.b = NetConnInfoCenter.getServerTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase.FeedsOperation
 * JD-Core Version:    0.7.0.1
 */