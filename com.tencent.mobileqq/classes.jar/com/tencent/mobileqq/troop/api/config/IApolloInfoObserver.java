package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import friendlist.stTroopMemberInfo;
import java.util.ArrayList;

public abstract interface IApolloInfoObserver
{
  public abstract void a(@NonNull AppInterface paramAppInterface, ArrayList<stTroopMemberInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.IApolloInfoObserver
 * JD-Core Version:    0.7.0.1
 */