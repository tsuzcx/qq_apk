package com.tencent.mobileqq.vashealth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.vashealth.config.StepConfigBean;
import com.tencent.mobileqq.vashealth.config.StepConfigProcessor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class StepCounterServlert
  extends MSFServlet
{
  static int a;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MyServlet onReceive.");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
    QLog.i("health_manager", 1, ((StringBuilder)localObject).toString());
    if ((paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getServiceCmd().equals("cmd_refresh_steps")))
    {
      localObject = new Bundle();
      if (StepConfigProcessor.a().a() == 2)
      {
        paramFromServiceMsg = paramFromServiceMsg.getAttributes();
        if (paramFromServiceMsg.containsKey("health_step_count_history")) {
          ((Bundle)localObject).putSerializable("health_step_count_history", (Serializable)paramFromServiceMsg.get("health_step_count_history"));
        }
        if (paramFromServiceMsg.containsKey("health_has_shutdown_flag")) {
          ((Bundle)localObject).putBoolean("health_has_shutdown_flag", ((Boolean)paramFromServiceMsg.get("health_has_shutdown_flag")).booleanValue());
        }
        if (paramFromServiceMsg.containsKey("health_last_sensor_event_time")) {
          ((Bundle)localObject).putLong("health_last_sensor_event_time", ((Long)paramFromServiceMsg.get("health_last_sensor_event_time")).longValue());
        }
      }
      else
      {
        String str = paramIntent.getStringExtra("json_string");
        paramFromServiceMsg = (String)paramFromServiceMsg.getAttribute("StepInfoJSON");
        if (!TextUtils.isEmpty(str)) {
          ((Bundle)localObject).putString("json_string", str);
        }
        if (!TextUtils.isEmpty(paramFromServiceMsg)) {
          ((Bundle)localObject).putString("StepInfoJSON", paramFromServiceMsg);
        }
        if (paramIntent.getExtras().getString("json_getstepcallback") != null) {
          ((Bundle)localObject).putString("json_getstepcallback", paramIntent.getExtras().getString("json_getstepcallback"));
        }
      }
      notifyObserver(paramIntent, 0, true, (Bundle)localObject, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("msf_cmd_type");
    paramPacket = new ToServiceMsg(null, "0", (String)localObject);
    paramPacket.setMsfCommand(MsfCommand.msf_step_counter);
    paramPacket.setNeedCallback(true);
    paramPacket.setTimeout(30000L);
    if (((String)localObject).equals("cmd_health_switch"))
    {
      paramPacket.addAttribute("isOpen", Boolean.valueOf(paramIntent.getBooleanExtra("isOpen", false)));
    }
    else if (((String)localObject).equals("cmd_update_lastreport_time"))
    {
      long l = paramIntent.getLongExtra("last_report_time", 0L);
      boolean bool = paramIntent.getBooleanExtra("has_report_yes", false);
      paramPacket.addAttribute("last_report_time", Long.valueOf(l));
      paramPacket.addAttribute("has_report_yes", Boolean.valueOf(bool));
      paramPacket.setNeedCallback(false);
    }
    else if (((String)localObject).equals("cmd_reset_step"))
    {
      int i = paramIntent.getIntExtra("server_step", -1);
      if (-1 != i) {
        paramPacket.addAttribute("server_step", Integer.valueOf(i));
      }
    }
    else if (((String)localObject).equals("cmd_step_update_config"))
    {
      localObject = StepConfigProcessor.a();
      paramPacket.addAttribute("stepCounterMode", Integer.valueOf(((StepConfigBean)localObject).a()));
      paramPacket.addAttribute("stepCadence", Integer.valueOf(((StepConfigBean)localObject).b()));
      paramPacket.addAttribute("activeReportInterval", Integer.valueOf(((StepConfigBean)localObject).c()));
      paramPacket.addAttribute("passiveReportInterval", Integer.valueOf(((StepConfigBean)localObject).d()));
      paramPacket.addAttribute("maxRecordDays", Integer.valueOf(((StepConfigBean)localObject).e()));
      paramPacket.setNeedCallback(false);
    }
    sendToMSF(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepCounterServlert
 * JD-Core Version:    0.7.0.1
 */