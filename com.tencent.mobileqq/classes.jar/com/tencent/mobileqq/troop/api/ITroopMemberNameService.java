package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopMemberNameService
  extends IRuntimeService
{
  public abstract String getTroopMemberColorNick(String paramString1, String paramString2);
  
  public abstract String getTroopMemberName(TroopMemberInfo paramTroopMemberInfo);
  
  public abstract String getTroopMemberName(String paramString1, String paramString2);
  
  public abstract String getTroopMemberName(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void getTroopMemberNameAsync(String paramString1, String paramString2, ITroopMemberNameService.OnGetTroopMemberNameCallback paramOnGetTroopMemberNameCallback);
  
  public abstract String getTroopMemberNameInUI(String paramString1, String paramString2);
  
  public abstract String getTroopMemberNameRemarkFirst(String paramString1, String paramString2);
  
  public abstract String getTroopMemberNameWithoutRemark(String paramString1, String paramString2);
  
  public abstract String getTroopMemberNick(String paramString1, String paramString2);
  
  public abstract String getTroopMemberNickByTroopCode(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopMemberNameService
 * JD-Core Version:    0.7.0.1
 */