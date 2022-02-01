package com.tencent.mobileqq.qwallet.hb.grap.voice;

import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransProcessor;

@QAPI(process={""})
public abstract interface IVoiceRedPacketHelper
  extends QRouteApi
{
  public static final String KEY_VOICE_SCORE_ID = "voice_score_id";
  
  public abstract void checkAndSendMessage(MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver, long paramLong, byte[] paramArrayOfByte, String paramString, BaseTransProcessor paramBaseTransProcessor);
  
  public abstract int getRedPackTypeForPtt(MessageRecord paramMessageRecord);
  
  public abstract ByteStringMicro getVoiceScoreIdBytes(MessageRecord paramMessageRecord);
  
  public abstract boolean isNeedInterceptSend(MessageRecord paramMessageRecord);
  
  public abstract boolean isRedPackPTT(MessageRecord paramMessageRecord);
  
  public abstract void saveVoiceScoreId(String paramString, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.IVoiceRedPacketHelper
 * JD-Core Version:    0.7.0.1
 */