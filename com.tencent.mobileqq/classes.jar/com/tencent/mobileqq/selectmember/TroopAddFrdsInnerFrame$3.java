package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class TroopAddFrdsInnerFrame$3
  extends TroopObserver
{
  TroopAddFrdsInnerFrame$3(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  protected void onTroopBatchReqMemberCmnFrds(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList)
  {
    if ((paramBoolean1) && (this.a.d != null) && (this.a.d.longValue() == paramLong) && (paramString1.equals(this.a.c)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onTroopBatchReqMemberCmnFrds suc. troopUin:%s, cmnfrds.size:%d", new Object[] { paramString1, Integer.valueOf(paramHashMap.size()) }));
      }
      if (paramHashMap.size() > 0)
      {
        paramString1 = this.a.C.obtainMessage(6);
        paramString1.obj = paramHashMap;
        this.a.C.sendMessage(paramString1);
      }
    }
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.a.c)) && (!this.a.c.equals(paramString))) {
      return;
    }
    ThreadManager.post(new TroopAddFrdsInnerFrame.3.1(this, paramList), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.3
 * JD-Core Version:    0.7.0.1
 */