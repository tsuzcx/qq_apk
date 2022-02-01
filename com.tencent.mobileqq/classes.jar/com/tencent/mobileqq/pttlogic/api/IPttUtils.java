package com.tencent.mobileqq.pttlogic.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.ptt.IPttVoiceChangePreSender;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IPttUtils
  extends QRouteApi
{
  public abstract IPttAudioDataManager creatPttAudioDataManager();
  
  public abstract IPttVoiceChangePreSender createPttVoiceChangePreSender(AppRuntime paramAppRuntime);
  
  public abstract int getReceivedPTTStatus(AppInterface paramAppInterface, MessageForPtt paramMessageForPtt);
  
  public abstract void showDialogAboutMeizuRecordPermission(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.IPttUtils
 * JD-Core Version:    0.7.0.1
 */