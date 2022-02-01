package com.tencent.mobileqq.guild.audio;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.trtc.TRTCCloud;
import java.io.File;
import java.util.Arrays;

class TRTCAudioRoomLocal$1
  implements OnLoadListener
{
  TRTCAudioRoomLocal$1(TRTCAudioRoomLocal paramTRTCAudioRoomLocal, Context paramContext, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if ((paramInt == 0) && (paramLoadExtResult != null))
    {
      paramLoadExtResult = Utils.o(paramLoadExtResult.getRelatedFilesFolder("trtc_entry"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloaded trtc so: ");
      localStringBuilder.append(Arrays.toString(new File(paramLoadExtResult).list()));
      QLog.i("TRTCAudioRoomLocal", 2, localStringBuilder.toString());
      TXLiveBase.setLibraryPath(paramLoadExtResult);
      TRTCAudioRoomLocal.a(this.c, TRTCCloud.sharedInstance(this.a));
      paramLoadExtResult = this.c;
      TRTCAudioRoomLocal.a(paramLoadExtResult, TRTCAudioRoomLocal.a(paramLoadExtResult).getBeautyManager());
      TRTCAudioRoomLocal.a(this.c, new Handler(Looper.getMainLooper()));
    }
    paramLoadExtResult = this.b;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.a(paramInt, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomLocal.1
 * JD-Core Version:    0.7.0.1
 */