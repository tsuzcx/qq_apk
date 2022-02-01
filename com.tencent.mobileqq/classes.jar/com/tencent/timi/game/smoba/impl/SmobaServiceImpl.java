package com.tencent.timi.game.smoba.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.scheme.tools.smoba.SmobaSchemeUtil;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.smoba.api.SmobaCheckCallback;
import com.tencent.timi.game.smoba.api.SmobaGangupCheckParam;
import com.tencent.timi.game.smoba.impl.config.SmobaConfigManager;
import com.tencent.timi.game.smoba.impl.util.SmobaUtil;
import com.tencent.timi.game.smoba.impl.util.gamecore.GameCoreUtil;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaConfigRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaBigGradeLevel;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameMode;
import trpc.yes.common.GameDataServerOuterClass.SmobaLadderGrade;

public class SmobaServiceImpl
  implements ISmobaService
{
  public String a(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return "段位不限";
      }
      Object localObject1 = SmobaConfigManager.a().b();
      if (localObject1 != null) {
        localObject1 = ((GameDataServerOuterClass.GetSmobaConfigRsp)localObject1).big_grade_level_conf_list.get();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if (((List)localObject1).size() == 0) {
          return "段位不限";
        }
        if (paramList.size() >= ((List)localObject1).size()) {
          return "段位不限";
        }
        int j = paramList.size();
        int i = 0;
        if (j == 1)
        {
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject2 = (GameDataServerOuterClass.SmobaBigGradeLevel)((List)localObject1).get(i);
            if (((GameDataServerOuterClass.SmobaBigGradeLevel)localObject2).big_grade_level.get() == ((Integer)paramList.get(0)).intValue()) {
              return ((GameDataServerOuterClass.SmobaBigGradeLevel)localObject2).short_level_name.get();
            }
            i += 1;
          }
        }
        j = ((Integer)paramList.get(0)).intValue();
        int k = ((Integer)paramList.get(paramList.size() - 1)).intValue();
        Object localObject2 = "";
        paramList = "";
        while (i < ((List)localObject1).size())
        {
          GameDataServerOuterClass.SmobaBigGradeLevel localSmobaBigGradeLevel = (GameDataServerOuterClass.SmobaBigGradeLevel)((List)localObject1).get(i);
          if (localSmobaBigGradeLevel.big_grade_level.get() == j) {
            localObject2 = localSmobaBigGradeLevel.merge_show_begin.get();
          }
          if (localSmobaBigGradeLevel.big_grade_level.get() == k) {
            paramList = localSmobaBigGradeLevel.merge_show_end.get();
          }
          i += 1;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(paramList)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(paramList);
          return ((StringBuilder)localObject1).toString();
        }
      }
    }
    return "段位不限";
  }
  
  public void a(Context paramContext) {}
  
  public boolean a()
  {
    if (!GameCoreUtil.a(TimiGameActivityManager.a(), true, "王者荣耀", SmobaSchemeUtil.a(), "https://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.tmgp.sgame&channel=0002160650432d595942&fromcase=40001", null)) {
      return false;
    }
    return SmobaSchemeUtil.b();
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 6) && (paramInt != 60) && (paramInt != 61) && (paramInt != 210)) {
      return paramInt == 211;
    }
    return true;
  }
  
  public boolean a(Activity paramActivity, SmobaGangupCheckParam paramSmobaGangupCheckParam, boolean paramBoolean, SmobaCheckCallback paramSmobaCheckCallback)
  {
    return SmobaUtil.a(paramActivity, paramSmobaGangupCheckParam, paramBoolean, paramSmobaCheckCallback);
  }
  
  public boolean b(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3) && (paramInt != 6) && (paramInt != 7) && (paramInt != 60) && (paramInt != 62) && (paramInt != 210)) {
      return paramInt == 212;
    }
    return true;
  }
  
  public int c(int paramInt)
  {
    GameDataServerOuterClass.SmobaLadderGrade localSmobaLadderGrade = d(paramInt);
    if (localSmobaLadderGrade != null) {
      return localSmobaLadderGrade.big_grade_level.get();
    }
    return 0;
  }
  
  public GameDataServerOuterClass.SmobaLadderGrade d(int paramInt)
  {
    Object localObject = SmobaConfigManager.a().b();
    if (localObject != null) {
      localObject = ((GameDataServerOuterClass.GetSmobaConfigRsp)localObject).ladder_grade_conf_list.get();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameDataServerOuterClass.SmobaLadderGrade localSmobaLadderGrade = (GameDataServerOuterClass.SmobaLadderGrade)((Iterator)localObject).next();
        if (localSmobaLadderGrade.disp_grade_level.get() == paramInt) {
          return localSmobaLadderGrade;
        }
      }
    }
    return null;
  }
  
  public GameDataServerOuterClass.SmobaGameMode e(int paramInt)
  {
    Object localObject = SmobaConfigManager.a().b();
    if (localObject != null) {
      localObject = ((GameDataServerOuterClass.GetSmobaConfigRsp)localObject).game_mode_conf_list.get();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameDataServerOuterClass.SmobaGameMode localSmobaGameMode = (GameDataServerOuterClass.SmobaGameMode)((Iterator)localObject).next();
        if (localSmobaGameMode.game_mode.get() == paramInt) {
          return localSmobaGameMode;
        }
      }
    }
    return null;
  }
  
  public String f(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {}
            return "游走";
          }
          return "打野";
        }
        return "发育路";
      }
      return "中路";
    }
    return "对抗路";
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.SmobaServiceImpl
 * JD-Core Version:    0.7.0.1
 */