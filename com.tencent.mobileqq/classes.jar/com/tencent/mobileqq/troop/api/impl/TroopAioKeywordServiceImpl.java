package com.tencent.mobileqq.troop.api.impl;

import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.troop.api.ITroopAioKeywordService;
import com.tencent.mobileqq.troop.observer.KeywordTipInfoObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x971.oidb_0x971.ReqBody;

public class TroopAioKeywordServiceImpl
  implements ITroopAioKeywordService
{
  public static final String TAG = "TroopAioKeywordServiceImpl";
  private AppInterface app;
  
  public void getTroopAioKeywordTipInfo(List<Integer> paramList, KeywordTipInfoObserver paramKeywordTipInfoObserver)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject = new oidb_0x971.ReqBody();
      ((oidb_0x971.ReqBody)localObject).rule_id.set(paramList);
      ProtoUtils.a(this.app, paramKeywordTipInfoObserver, ((oidb_0x971.ReqBody)localObject).toByteArray(), "OidbSvc.0x971_0", 2417, 0);
      if (QLog.isColorLevel())
      {
        paramKeywordTipInfoObserver = new StringBuilder();
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramKeywordTipInfoObserver.append((Integer)((Iterator)localObject).next());
          paramKeywordTipInfoObserver.append(";");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTroopAioKeywordTipInfo,ruleIds.size=");
        ((StringBuilder)localObject).append(paramList.size());
        ((StringBuilder)localObject).append(",content=");
        ((StringBuilder)localObject).append(paramKeywordTipInfoObserver.toString());
        QLog.i("TroopAioKeywordServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopAioKeywordServiceImpl", 2, "getTroopAioKeywordTipInfo, ruleIds == null || ruleIds.size() == 0");
    }
    paramKeywordTipInfoObserver.a(false, null);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      this.app = ((AppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopAioKeywordServiceImpl
 * JD-Core Version:    0.7.0.1
 */