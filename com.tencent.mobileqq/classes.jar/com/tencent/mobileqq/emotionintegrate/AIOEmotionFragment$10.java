package com.tencent.mobileqq.emotionintegrate;

import android.text.TextUtils;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.qphone.base.util.QLog;

class AIOEmotionFragment$10
  extends EmoticonObserver
{
  AIOEmotionFragment$10(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt != 6) && (paramInt != 7) && (paramInt != 107)) {
      return;
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
        paramObject = HardCodeUtil.a(2131700242);
      }
    }
    else
    {
      paramObject = HardCodeUtil.a(2131700243);
      i = -404;
    }
    if (TextUtils.isEmpty(localEmoticonResp.emoticonId))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, "auth type emoticon id is null");
      }
      return;
    }
    QQAppInterface localQQAppInterface = this.a.a();
    if (localQQAppInterface != null) {
      ((IEmoticonManagerService)localQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticon(String.valueOf(localEmoticonResp.epId), localEmoticonResp.emoticonId, new AIOEmotionFragment.10.1(this, paramInt, localQQAppInterface, i, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.10
 * JD-Core Version:    0.7.0.1
 */