package com.tencent.mobileqq.guild.audio;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;
import java.io.File;
import java.util.Arrays;

class TRTCAudioRoomRemote$1
  implements OnLoadListener
{
  TRTCAudioRoomRemote$1(TRTCAudioRoomRemote paramTRTCAudioRoomRemote, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback, Context paramContext) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      TRTCAudioRoomRemote.a(this.c, new Handler(Looper.getMainLooper()));
      paramLoadExtResult = Utils.o(paramLoadExtResult.getRelatedFilesFolder("trtc_entry"));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloaded trtc so: ");
      ((StringBuilder)localObject).append(Arrays.toString(new File(paramLoadExtResult).list()));
      QLog.i("TRTCAudioRoomRemote", 2, ((StringBuilder)localObject).toString());
      if (TRTCAudioRoomRemote.b(this.c) == null)
      {
        localObject = this.c;
        TRTCAudioRoomRemote.a((TRTCAudioRoomRemote)localObject, new TRTCAudioRoomRemote.TRTCAudioRoomServerQIPCModule((TRTCAudioRoomRemote)localObject));
        QIPCServerHelper.getInstance().register(TRTCAudioRoomRemote.b(this.c));
      }
      if (TRTCAudioRoomRemote.c(this.c))
      {
        QLog.i("TRTCAudioRoomRemote", 1, "already bound:");
        this.a.a(0, "");
        return;
      }
      QLog.i("TRTCAudioRoomRemote", 1, "QIPCServerHelper addListener");
      QIPCServerHelper.getInstance().getServer().addListener(new TRTCAudioRoomRemote.1.1(this, paramInt));
      this.c.a(this.b, paramLoadExtResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomRemote.1
 * JD-Core Version:    0.7.0.1
 */