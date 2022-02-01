package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;

public abstract interface IGetMemberListObserver
{
  public abstract void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.IGetMemberListObserver
 * JD-Core Version:    0.7.0.1
 */