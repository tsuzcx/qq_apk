package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import friendlist.stTroopMemberInfo;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;

public abstract interface IGetTroopMemberInfoObserver
{
  public abstract void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong);
  
  public abstract void a(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo);
  
  public abstract Object[] a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList);
  
  public abstract void b(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.IGetTroopMemberInfoObserver
 * JD-Core Version:    0.7.0.1
 */