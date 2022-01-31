package com.tencent.mobileqq.leba.model.pluginactions;

import aebb;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;

public class JDPluginAction
  extends PluginAction
{
  long jdField_a_of_type_Long;
  Intent jdField_a_of_type_AndroidContentIntent;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aebb(this);
  qqshop_code.SRsp jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp;
  
  public JDPluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Object localObject = a();
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (localObject == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    do
    {
      return;
      localObject = (EcshopReportHandler)((QQAppInterface)localObject).a(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localObject == null);
    ((EcshopReportHandler)localObject).a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
  
  public void a(Message paramMessage)
  {
    Object localObject = a();
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (localObject == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      localObject = (EcshopReportHandler)((QQAppInterface)localObject).a(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = URLUtil.a(str2, "code", paramMessage.auth_code.get());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", str3);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.i("AuthCode", 2, "newUrl:" + str3);
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          a(str2);
          if (localObject != null) {
            ((EcshopReportHandler)localObject).a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localObject != null) {
            ((EcshopReportHandler)localObject).a(134246777, null, "not_jump", str1, "", 0L, false);
          }
          this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp = paramMessage;
        }
      }
      catch (Exception paramMessage)
      {
        QLog.e("AuthCode", 1, "authcode resp exception:" + paramMessage);
        return;
      }
      finally
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (localObject != null) {
            ((EcshopReportHandler)localObject).a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  void a(String paramString)
  {
    ((VasExtensionHandler)a().a(71)).c(paramString);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void c(LebaGridItemInfo paramLebaGridItemInfo)
  {
    if (paramLebaGridItemInfo == null) {
      return;
    }
    Object localObject = a(paramLebaGridItemInfo);
    QQAppInterface localQQAppInterface = a();
    long l = NetConnInfoCenter.getServerTime();
    if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
      }
      ((Intent)localObject).putExtra("url", URLUtil.a("", "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      a(paramLebaGridItemInfo.a.jumpInfo);
      localObject = (EcshopReportHandler)localQQAppInterface.a(88);
      if (localObject != null) {
        ((EcshopReportHandler)localObject).a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
      }
    }
    for (;;)
    {
      ReportController.a(localQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + paramLebaGridItemInfo.a.pluginId, "", "", "");
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
      a(paramLebaGridItemInfo.a.jumpInfo);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134007, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.JDPluginAction
 * JD-Core Version:    0.7.0.1
 */