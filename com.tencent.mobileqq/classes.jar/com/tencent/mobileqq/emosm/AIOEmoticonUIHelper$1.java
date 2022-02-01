package com.tencent.mobileqq.emosm;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class AIOEmoticonUIHelper$1
  extends EmoticonObserver
{
  AIOEmoticonUIHelper$1(AIOEmoticonUIHelper paramAIOEmoticonUIHelper) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    BaseChatPie localBaseChatPie = this.a.b();
    if ((paramInt != 6) && (paramInt != 7)) {
      if (paramInt != 9)
      {
        if (paramInt == 107) {}
      }
      else
      {
        QLog.d(this.a.getTag(), 1, "not support old emosm recommend");
        return;
      }
    }
    if (localBaseChatPie == null) {
      return;
    }
    if ((localBaseChatPie.af != null) && (localBaseChatPie.af.isShowing())) {
      localBaseChatPie.af.dismiss();
    }
    if (paramObject == null) {
      return;
    }
    EmoticonResp localEmoticonResp = (EmoticonResp)paramObject;
    int i;
    if (paramBoolean)
    {
      i = localEmoticonResp.delEpId;
      if ((localEmoticonResp.keySeq != null) && (!localEmoticonResp.keySeq.equals(""))) {
        paramObject = localEmoticonResp.keySeq;
      } else {
        paramObject = HardCodeUtil.a(2131899218);
      }
    }
    else
    {
      i = -404;
      paramObject = HardCodeUtil.a(2131899206);
    }
    if (TextUtils.isEmpty(localEmoticonResp.emoticonId))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.getTag(), 2, "auth type emoticon id is null");
      }
      return;
    }
    ((IEmoticonManagerService)localBaseChatPie.i().getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticon(String.valueOf(localEmoticonResp.epId), localEmoticonResp.emoticonId, new AIOEmoticonUIHelper.1.1(this, paramInt, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper.1
 * JD-Core Version:    0.7.0.1
 */