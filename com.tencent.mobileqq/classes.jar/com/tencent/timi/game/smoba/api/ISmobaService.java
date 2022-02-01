package com.tencent.timi.game.smoba.api;

import android.app.Activity;
import com.tencent.timi.game.router.IService;
import java.util.List;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameMode;
import trpc.yes.common.GameDataServerOuterClass.SmobaLadderGrade;

public abstract interface ISmobaService
  extends IService
{
  public abstract String a(List<Integer> paramList);
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean a(Activity paramActivity, SmobaGangupCheckParam paramSmobaGangupCheckParam, boolean paramBoolean, SmobaCheckCallback paramSmobaCheckCallback);
  
  public abstract boolean b(int paramInt);
  
  public abstract int c(int paramInt);
  
  public abstract GameDataServerOuterClass.SmobaLadderGrade d(int paramInt);
  
  public abstract GameDataServerOuterClass.SmobaGameMode e(int paramInt);
  
  public abstract String f(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.ISmobaService
 * JD-Core Version:    0.7.0.1
 */