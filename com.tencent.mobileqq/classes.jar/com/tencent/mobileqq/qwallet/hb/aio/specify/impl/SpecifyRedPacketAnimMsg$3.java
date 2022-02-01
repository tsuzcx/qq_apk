package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import android.text.TextUtils;
import com.qwallet.temp.ISpriteVideoViewTemp.OnFrameEndListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class SpecifyRedPacketAnimMsg$3
  implements IPreloadService.OnGetPathListener
{
  SpecifyRedPacketAnimMsg$3(SpecifyRedPacketAnimMsg paramSpecifyRedPacketAnimMsg, WeakReference paramWeakReference1, ISpriteVideoViewTemp.OnFrameEndListener paramOnFrameEndListener, WeakReference paramWeakReference2) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      ThreadManager.getUIHandler().post(new SpecifyRedPacketAnimMsg.3.1(this, paramPathResult));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SpecifyRedPacketAnimMsg", 2, "showAnim start playVideo err: download fail");
    }
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyRedPacketAnimMsg.3
 * JD-Core Version:    0.7.0.1
 */