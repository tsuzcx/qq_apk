package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import java.io.File;
import java.util.Arrays;

final class TimiGameQQTrtcUtil$1
  implements OnLoadListener
{
  TimiGameQQTrtcUtil$1(TimiGameQQTrtcUtil.ITrtcCheckResult paramITrtcCheckResult) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      paramLoadExtResult = Utils.o(paramLoadExtResult.getRelatedFilesFolder("trtc_entry"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloaded trtc so: ");
      localStringBuilder.append(Arrays.toString(new File(paramLoadExtResult).list()));
      QLog.d("TimiGameQQTrtcCheckUtil", 2, localStringBuilder.toString());
      TXLiveBase.setLibraryPath(paramLoadExtResult);
      TimiGameQQTrtcUtil.b = true;
      ThreadManagerV2.getUIHandlerV2().post(new TimiGameQQTrtcUtil.1.1(this));
      return;
    }
    QLog.e("TimiGameQQTrtcCheckUtil", 2, "Trtc SO加载异常");
    ThreadManagerV2.getUIHandlerV2().post(new TimiGameQQTrtcUtil.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.1
 * JD-Core Version:    0.7.0.1
 */