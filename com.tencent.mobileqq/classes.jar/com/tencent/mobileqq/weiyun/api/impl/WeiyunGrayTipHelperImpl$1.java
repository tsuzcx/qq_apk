package com.tencent.mobileqq.weiyun.api.impl;

import android.os.Bundle;
import android.os.Process;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;

class WeiyunGrayTipHelperImpl$1
  implements Runnable
{
  WeiyunGrayTipHelperImpl$1(WeiyunGrayTipHelperImpl paramWeiyunGrayTipHelperImpl, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5) {}
  
  public void run()
  {
    if (!(this.a instanceof QQAppInterface)) {
      return;
    }
    Process.setThreadPriority(10);
    UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(this.b, this.c, this.d, this.e, -5023, 2424833, MessageCache.c());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", this.f);
    int i = this.g;
    localUniteGrayTipParam.a(i, this.h.length() + i, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg((QQAppInterface)this.a, localUniteGrayTipParam);
    UniteGrayTipMsgUtil.a((QQAppInterface)this.a, (MessageForUniteGrayTip)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunGrayTipHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */