package com.tencent.mobileqq.qassistant.audio;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.data.VoiceBean;
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
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("onFailed, duration:");
    paramArrayOfByte.append(l1 - l2);
    paramArrayOfByte.append(", retCode:");
    paramArrayOfByte.append(paramInt);
    AssistantUtils.a("AudioUploadThread", paramArrayOfByte.toString());
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    paramHashMap = new StringBuilder();
    paramHashMap.append("onSuccess duration:");
    paramHashMap.append(l);
    AssistantUtils.a("AudioUploadThread", paramHashMap.toString());
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    try
    {
      AudioUploadThread.a(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread, this.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceBean, paramArrayOfByte, l);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("onSuccess, parse rsp error:");
      paramHashMap.append(paramArrayOfByte.getMessage());
      AssistantUtils.a("AudioUploadThread", paramHashMap.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdateProgress transferedSize:");
    localStringBuilder.append(paramInt);
    AssistantUtils.a("AudioUploadThread", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioUploadThread.1
 * JD-Core Version:    0.7.0.1
 */