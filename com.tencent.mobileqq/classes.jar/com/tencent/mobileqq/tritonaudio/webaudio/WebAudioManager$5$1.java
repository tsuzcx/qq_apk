package com.tencent.mobileqq.tritonaudio.webaudio;

import android.media.MediaFormat;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class WebAudioManager$5$1
  implements AudioDecoder.OnDecodeProcessListener
{
  WebAudioManager$5$1(WebAudioManager.5 param5, AudioDecoder paramAudioDecoder) {}
  
  @RequiresApi(api=16)
  public void onDecodeProcess(byte[] paramArrayOfByte, MediaFormat paramMediaFormat, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (!WebAudioManager.access$100(this.this$1.this$0).containsKey(Integer.valueOf(this.this$1.val$decodeId))) {
        WebAudioManager.access$100(this.this$1.this$0).put(Integer.valueOf(this.this$1.val$decodeId), new WebAudioManager.DecodeAsPlayStatus(this.this$1.this$0));
      }
      WebAudioManager.DecodeAsPlayStatus localDecodeAsPlayStatus = (WebAudioManager.DecodeAsPlayStatus)WebAudioManager.access$100(this.this$1.this$0).get(Integer.valueOf(this.this$1.val$decodeId));
      ArrayList localArrayList = (ArrayList)WebAudioManager.access$200(this.this$1.this$0).get(Integer.valueOf(this.this$1.val$decodeId));
      paramMediaFormat = localArrayList;
      if (localArrayList == null) {
        paramMediaFormat = new ArrayList();
      }
      if (paramBoolean2)
      {
        WebAudioManager.DecodeAsPlayStatus.access$302(localDecodeAsPlayStatus, 3);
        return;
      }
      int i = AudioNativeManager.loadRawData(paramArrayOfByte, this.val$audioDecoder.getSampleRate(), this.val$audioDecoder.getChannelCount(), this.val$audioDecoder.getBitsPerChannel());
      paramMediaFormat.add(Integer.valueOf(i));
      WebAudioManager.access$200(this.this$1.this$0).put(Integer.valueOf(this.this$1.val$decodeId), paramMediaFormat);
      int j = WebAudioManager.DecodeAsPlayStatus.access$300(localDecodeAsPlayStatus);
      if (j != 0)
      {
        if (j == 2)
        {
          paramArrayOfByte = WebAudioManager.DecodeAsPlayStatus.access$400(localDecodeAsPlayStatus);
          if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty()))
          {
            paramArrayOfByte = paramArrayOfByte.iterator();
            while (paramArrayOfByte.hasNext()) {
              AudioNativeManager.setQueueBuffer(((Integer)paramArrayOfByte.next()).intValue(), i);
            }
          }
        }
      }
      else {
        WebAudioManager.DecodeAsPlayStatus.access$302(localDecodeAsPlayStatus, 1);
      }
      if (paramBoolean1)
      {
        paramArrayOfByte = new JSONObject();
        try
        {
          paramArrayOfByte.put("decodeId", this.this$1.val$decodeId);
          paramArrayOfByte.put("status", "ok");
          if (this.this$1.val$argument != null) {
            this.this$1.val$argument.subscribe("onDecodeWebAudioDataDone", paramArrayOfByte.toString());
          }
        }
        catch (JSONException paramArrayOfByte)
        {
          if (WebAudioManager.access$500(this.this$1.this$0) != null) {
            WebAudioManager.access$500(this.this$1.this$0).printLog(LogDelegate.Level.ERROR, "WebAudioManager", "onDecodeProcess isfirst jsonexception:", paramArrayOfByte);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.5.1
 * JD-Core Version:    0.7.0.1
 */