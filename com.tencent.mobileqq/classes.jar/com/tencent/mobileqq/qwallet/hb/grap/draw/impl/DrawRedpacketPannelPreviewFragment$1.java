package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DrawRedpacketPannelPreviewFragment$1
  extends Handler
{
  DrawRedpacketPannelPreviewFragment$1(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 1001) {
      return;
    }
    paramMessage = (DrawRedpacketPannelPreviewFragment.SendImageToAIO)paramMessage.obj;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = DrawRedpacketPannelPreviewFragment.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("save path: ");
      ((StringBuilder)localObject2).append(paramMessage.e);
      ((StringBuilder)localObject2).append(" thread name: ");
      ((StringBuilder)localObject2).append(Thread.currentThread().getName());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.a.getQBaseActivity();
    if (localObject1 != null)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessage.e);
      ((Intent)localObject2).putStringArrayListExtra(((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QAlbumConstants$PHOTO_PATHS(), localArrayList);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
      ((Intent)localObject2).putExtra("uin", paramMessage.a);
      ((Intent)localObject2).putExtra("uintype", paramMessage.b);
      ((Intent)localObject2).putExtra("troop_uin", paramMessage.c);
      ((Intent)localObject2).putExtra("key_confess_topicid", paramMessage.d);
      ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).PeakConstants$SendSizeSpec$SPEC_NOMAL());
      ((Intent)localObject2).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      if (localArrayList.size() == 1) {
        ((Intent)localObject2).putExtra(((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QAlbumConstants$SINGLE_PHOTO_PATH(), localArrayList);
      }
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).startSendPhotoActivity((Context)localObject1, (Intent)localObject2);
      ((Activity)localObject1).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */