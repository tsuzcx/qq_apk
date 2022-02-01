package com.tencent.mobileqq.emotionintegrate;

import android.text.TextUtils;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

class AIOEmotionFragment$10
  extends EmoticonObserver
{
  AIOEmotionFragment$10(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    EmoticonResp localEmoticonResp;
    int i;
    label134:
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (paramObject == null);
      localEmoticonResp = (EmoticonResp)paramObject;
      if (paramBoolean)
      {
        i = localEmoticonResp.delEpId;
        if ((localEmoticonResp.keySeq == null) || (localEmoticonResp.keySeq.equals(""))) {
          paramObject = HardCodeUtil.a(2131700101);
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localEmoticonResp.emoticonId)) {
          break label134;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AIOEmotionFragment", 2, "auth type emoticon id is null");
        return;
        paramObject = localEmoticonResp.keySeq;
        continue;
        i = -404;
        paramObject = HardCodeUtil.a(2131700102);
      }
      localQQAppInterface = this.a.a();
    } while (localQQAppInterface == null);
    ((EmoticonManager)localQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(localEmoticonResp.epId), localEmoticonResp.emoticonId, new AIOEmotionFragment.10.1(this, paramInt, localQQAppInterface, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.10
 * JD-Core Version:    0.7.0.1
 */