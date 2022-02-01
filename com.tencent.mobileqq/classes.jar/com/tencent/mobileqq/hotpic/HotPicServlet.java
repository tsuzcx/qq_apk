package com.tencent.mobileqq.hotpic;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class HotPicServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof AppInterface)))
    {
      if (paramIntent.getBooleanExtra("isFrom_EmoSearch", false))
      {
        ((IEmotionSearchManagerService)((BaseQQAppInterface)localAppRuntime).getRuntimeService(IEmotionSearchManagerService.class)).handleResonpse(paramIntent, paramFromServiceMsg);
        return;
      }
      ((IEmosmService)QRoute.api(IEmosmService.class)).handleResonpse((BaseQQAppInterface)localAppRuntime, paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      QLog.e("HotPicServlet", 1, "onSend : req is null");
      return;
    }
    paramPacket.setSSOCommand(paramIntent.getStringExtra("key_cmd"));
    paramPacket.putSendData(paramIntent.getByteArrayExtra("key_body"));
    paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 6000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicServlet
 * JD-Core Version:    0.7.0.1
 */