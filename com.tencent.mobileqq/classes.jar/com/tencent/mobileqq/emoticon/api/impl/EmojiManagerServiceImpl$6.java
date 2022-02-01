package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class EmojiManagerServiceImpl$6
  extends EmojiManagerServiceImpl.SyncFetchEmoticonKeyObserver
{
  EmojiManagerServiceImpl$6(EmojiManagerServiceImpl paramEmojiManagerServiceImpl, EmoticonHandler paramEmoticonHandler, ReqInfo paramReqInfo, Object paramObject)
  {
    super(paramEmojiManagerServiceImpl, paramEmoticonHandler);
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp)
  {
    if (this.d.get() == null) {
      return;
    }
    ??? = (EmoticonHandler)this.d.get();
    int i = paramEmoticonResp.epId;
    int j = paramEmoticonResp.timestamp;
    Object localObject1 = (ArrayList)paramEmoticonResp.data;
    if ((this.a.strGetKeySeq != null) && (this.a.strGetKeySeq.equals(paramEmoticonResp.keySeq)))
    {
      ((EmoticonHandler)???).b(this);
      ??? = this.a;
      ((ReqInfo)???).encryptKeysSuccess = paramBoolean;
      ((ReqInfo)???).encryptKeysResultCode = paramEmoticonResp.resultcode;
      this.a.timeoutReason = paramEmoticonResp.timeoutReason;
      synchronized (this.b)
      {
        this.b.notify();
      }
    }
    if (QLog.isColorLevel())
    {
      ??? = EmojiManagerServiceImpl.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchEmoticonEncryptKeys|net get key backepId=");
      localStringBuilder.append(i);
      localStringBuilder.append(" tstamp=");
      localStringBuilder.append(j);
      localStringBuilder.append(" list.size=");
      if (localObject1 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      }
      localStringBuilder.append(localObject1);
      localStringBuilder.append(" encryptSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" er.resultCode=");
      localStringBuilder.append(paramEmoticonResp.resultcode);
      QLog.d((String)???, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */