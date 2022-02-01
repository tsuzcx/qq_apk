package com.tencent.mobileqq.data.utils.impl;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.grap.voice.IVoiceRedPacketHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;

public class MessageForPttUtilsApiImpl
  implements IMessageForPttUtilsApi
{
  public byte[] c2cConstructPTTExtraInfo(MessageForPtt paramMessageForPtt)
  {
    byte[] arrayOfByte1 = c2cConstructPttReserveInfo(paramMessageForPtt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 3 + 15];
    arrayOfByte2[0] = 3;
    arrayOfByte2[1] = 8;
    byte[] arrayOfByte3 = PkgTools.shortToHL((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 2, arrayOfByte3.length);
    int i = arrayOfByte3.length + 2;
    arrayOfByte3 = PkgTools.intToHL(paramMessageForPtt.voiceType);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, arrayOfByte3.length);
    i += arrayOfByte3.length;
    arrayOfByte2[i] = 9;
    i += 1;
    arrayOfByte3 = PkgTools.shortToHL((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, 2);
    i += arrayOfByte3.length;
    paramMessageForPtt = PkgTools.intToHL(Utils.a(paramMessageForPtt.voiceLength));
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, paramMessageForPtt.length);
    i += paramMessageForPtt.length;
    arrayOfByte2[i] = 10;
    i += 1;
    paramMessageForPtt = PkgTools.shortToHL((short)arrayOfByte1.length);
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, 2);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i + paramMessageForPtt.length, arrayOfByte1.length);
    i = arrayOfByte1.length;
    return arrayOfByte2;
  }
  
  public byte[] c2cConstructPttReserveInfo(MessageForPtt paramMessageForPtt)
  {
    ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
    localReserveStruct.uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
    localReserveStruct.uint32_redpack_type.set(getRedPackTypeForPtt(paramMessageForPtt));
    localReserveStruct.uint32_autototext_voice.set(paramMessageForPtt.autoToText);
    if (paramMessageForPtt.hasSttTxt()) {
      localReserveStruct.bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
    }
    paramMessageForPtt = ((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).getVoiceScoreIdBytes(paramMessageForPtt);
    if (paramMessageForPtt != null) {
      localReserveStruct.bytes_redpack_score_id.set(paramMessageForPtt);
    }
    return localReserveStruct.toByteArray();
  }
  
  public byte[] changeWaveformToPb(int[] paramArrayOfInt)
  {
    ptt_waveform.PttWaveform localPttWaveform = new ptt_waveform.PttWaveform();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      localPttWaveform.uin32_size.set(paramArrayOfInt.length);
      byte[] arrayOfByte = new byte[paramArrayOfInt.length];
      int j = 0;
      while (j < paramArrayOfInt.length)
      {
        int k = paramArrayOfInt[j];
        int i;
        if (k < 0)
        {
          i = 0;
        }
        else
        {
          i = k;
          if (k > 255) {
            i = 255;
          }
        }
        arrayOfByte[j] = ((byte)(i & 0xFF));
        j += 1;
      }
      localPttWaveform.bytes_amplitudes.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    return localPttWaveform.toByteArray();
  }
  
  public int getRedPackTypeForPtt(MessageForPtt paramMessageForPtt)
  {
    return ((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).getRedPackTypeForPtt(paramMessageForPtt);
  }
  
  public byte[] groupConstructPTTExtraInfo(MessageForPtt paramMessageForPtt)
  {
    Object localObject1 = new ptt_reserve.ReserveStruct();
    Object localObject2;
    if (paramMessageForPtt != null)
    {
      ((ptt_reserve.ReserveStruct)localObject1).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
      ((ptt_reserve.ReserveStruct)localObject1).uint32_redpack_type.set(getRedPackTypeForPtt(paramMessageForPtt));
      ((ptt_reserve.ReserveStruct)localObject1).uint32_autototext_voice.set(paramMessageForPtt.autoToText);
      if (paramMessageForPtt.hasSttTxt()) {
        ((ptt_reserve.ReserveStruct)localObject1).bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
      }
      localObject2 = ((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).getVoiceScoreIdBytes(paramMessageForPtt);
      if (localObject2 != null) {
        ((ptt_reserve.ReserveStruct)localObject1).bytes_redpack_score_id.set((ByteStringMicro)localObject2);
      }
    }
    localObject1 = ((ptt_reserve.ReserveStruct)localObject1).toByteArray();
    if ((QLog.isColorLevel()) && (paramMessageForPtt != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("change flag is ");
      ((StringBuilder)localObject2).append(paramMessageForPtt.voiceChangeFlag);
      QLog.d("pttchangevoice", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.utils.impl.MessageForPttUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */