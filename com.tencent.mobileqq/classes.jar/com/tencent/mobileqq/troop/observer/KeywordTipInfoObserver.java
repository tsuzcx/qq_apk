package com.tencent.mobileqq.troop.observer;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x971.oidb_0x971.NoticeInfo;
import tencent.im.oidb.cmd0x971.oidb_0x971.RspBody;

public abstract class KeywordTipInfoObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public KeywordTipInfoObserver()
  {
    super(false);
  }
  
  public abstract void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject;
    if (paramInt == 0) {
      localObject = new oidb_0x971.RspBody();
    }
    for (;;)
    {
      try
      {
        ((oidb_0x971.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((oidb_0x971.RspBody)localObject).notices.has()) {
          break label257;
        }
        paramBundle = new ArrayList();
        localObject = ((oidb_0x971.RspBody)localObject).notices.get().iterator();
        paramArrayOfByte = paramBundle;
        if (((Iterator)localObject).hasNext())
        {
          paramArrayOfByte = (oidb_0x971.NoticeInfo)((Iterator)localObject).next();
          TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = new TroopAioKeywordTipInfo();
          localTroopAioKeywordTipInfo.ruleId = paramArrayOfByte.rule_id.get();
          localTroopAioKeywordTipInfo.title = paramArrayOfByte.title.get();
          localTroopAioKeywordTipInfo.summary = paramArrayOfByte.summary.get();
          localTroopAioKeywordTipInfo.url = paramArrayOfByte.url.get();
          localTroopAioKeywordTipInfo.icon = paramArrayOfByte.icon.get();
          localTroopAioKeywordTipInfo.version = paramArrayOfByte.version.get();
          paramBundle.add(localTroopAioKeywordTipInfo);
          continue;
        }
        a(true, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("KeywordTipInfoObserver, e=");
        paramBundle.append(paramArrayOfByte.toString());
        QLog.i("KeywordTipInfoObserver", 1, paramBundle.toString());
        a(false, null);
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("KeywordTipInfoObserver, errorCode=");
      paramArrayOfByte.append(paramInt);
      QLog.i("KeywordTipInfoObserver", 1, paramArrayOfByte.toString());
      a(false, null);
      return;
      label257:
      paramArrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.KeywordTipInfoObserver
 * JD-Core Version:    0.7.0.1
 */