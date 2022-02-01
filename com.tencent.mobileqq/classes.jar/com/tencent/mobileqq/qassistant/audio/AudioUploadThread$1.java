package com.tencent.mobileqq.qassistant.audio;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.IOException;
import java.util.HashMap;

class AudioUploadThread$1
  implements ITransactionCallback
{
  private final long jdField_a_of_type_Long = System.currentTimeMillis();
  
  AudioUploadThread$1(AudioUploadThread paramAudioUploadThread, String paramString, VoiceBean paramVoiceBean) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    AssistantUtils.a("AudioUploadThread", "onFailed, duration:" + (l1 - l2) + ", retCode:" + paramInt);
    FileUtils.e(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    AssistantUtils.a("AudioUploadThread", "onSuccess duration:" + l);
    FileUtils.e(this.jdField_a_of_type_JavaLangString);
    try
    {
      AudioUploadThread.a(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread, this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBean, paramArrayOfByte, l);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      AssistantUtils.a("AudioUploadThread", "onSuccess, parse rsp error:" + paramArrayOfByte.getMessage());
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void onSwitch2BackupChannel()
  {
    AssistantUtils.a("AudioUploadThread", "onSwitch2BackupChannel");
  }
  
  public void onTransStart()
  {
    AssistantUtils.a("AudioUploadThread", "onTransStart");
  }
  
  public void onUpdateProgress(int paramInt)
  {
    AssistantUtils.a("AudioUploadThread", "onUpdateProgress transferedSize:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioUploadThread.1
 * JD-Core Version:    0.7.0.1
 */