package com.tencent.qav.controller;

import android.content.Context;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.CallingStateMonitor;

public class QavCtrl
{
  private Context jdField_a_of_type_AndroidContentContext;
  private MultiOperatorImpl jdField_a_of_type_ComTencentQavControllerMultiMultiOperatorImpl;
  
  public QavCtrl(Context paramContext, MultiOperatorImpl paramMultiOperatorImpl)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    CallingStateMonitor.a().a(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentQavControllerMultiMultiOperatorImpl = paramMultiOperatorImpl;
    ClientLogReport.instance();
    GAClientLogReport.instance();
  }
  
  public static int a()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i = 3;
    if (bool)
    {
      i = 1;
    }
    else if (AppNetConnInfo.isMobileConn())
    {
      int j = AppNetConnInfo.getMobileInfo();
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4) {
              i = 100;
            } else {
              i = 14;
            }
          }
          else {
            i = 11;
          }
        }
        else {
          i = 9;
        }
      }
    }
    else
    {
      i = 0;
    }
    AVLog.c("QavCtrl", String.format("getApn networkType=%s", new Object[] { Integer.valueOf(i) }));
    return i;
  }
  
  public static void a(VideoChannelInterface paramVideoChannelInterface)
  {
    if (paramVideoChannelInterface != null) {
      paramVideoChannelInterface.sendGetGatewayMsg();
    }
  }
  
  public static void a(VideoChannelInterface paramVideoChannelInterface, Context paramContext, long paramLong)
  {
    if (paramVideoChannelInterface != null) {
      paramVideoChannelInterface.sendGetVideoConfig(ConfigSystemImpl.a(paramLong, String.valueOf(AppSetting.a()), paramContext));
    }
  }
  
  public IMultiOperator a()
  {
    return this.jdField_a_of_type_ComTencentQavControllerMultiMultiOperatorImpl;
  }
  
  public void a()
  {
    MultiOperatorImpl localMultiOperatorImpl = this.jdField_a_of_type_ComTencentQavControllerMultiMultiOperatorImpl;
    if (localMultiOperatorImpl != null)
    {
      localMultiOperatorImpl.g();
      this.jdField_a_of_type_ComTencentQavControllerMultiMultiOperatorImpl = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    CallingStateMonitor.a().a();
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.controller.QavCtrl
 * JD-Core Version:    0.7.0.1
 */