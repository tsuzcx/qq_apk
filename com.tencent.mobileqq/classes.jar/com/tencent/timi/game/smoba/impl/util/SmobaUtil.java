package com.tencent.timi.game.smoba.impl.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.scheme.tools.smoba.SmobaSchemeUtil;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.SmobaCheckCallback;
import com.tencent.timi.game.smoba.api.SmobaGangupCheckParam;
import com.tencent.timi.game.smoba.impl.util.gamecore.GameCoreUtil;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

public class SmobaUtil
{
  public static final boolean a = false;
  private static CommonDialog b;
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    c();
    paramActivity = new CommonDialog.Builder(paramActivity).a(paramString1).c(paramString2).d(paramString3).a(new SmobaUtil.8()).e("????????????").b(new SmobaUtil.7()).a();
    b(paramActivity);
    paramActivity.show();
  }
  
  private static void a(SmobaCheckCallback paramSmobaCheckCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsGangupAvaliable - ");
    localStringBuilder.append(paramSmobaCheckCallback);
    localStringBuilder.append(", onSuccess");
    Logger.a("SmobaUtil", localStringBuilder.toString());
    if (paramSmobaCheckCallback != null) {
      paramSmobaCheckCallback.a();
    }
  }
  
  private static void a(boolean paramBoolean1, Activity paramActivity, String paramString1, String paramString2, String paramString3, @NonNull SmobaGangupCheckParam paramSmobaGangupCheckParam, boolean paramBoolean2, SmobaCheckCallback paramSmobaCheckCallback)
  {
    c();
    paramSmobaGangupCheckParam = new SmobaUtil.5(paramActivity, paramSmobaCheckCallback, paramString1, paramSmobaGangupCheckParam, paramBoolean2);
    if (paramBoolean1)
    {
      paramSmobaGangupCheckParam.onClick(null, 0);
      return;
    }
    paramActivity = new CommonDialog.Builder(paramActivity).a(paramString1).c(paramString2).d(paramString3).a(paramSmobaGangupCheckParam).e("????????????").b(new SmobaUtil.6(paramSmobaCheckCallback, paramString1)).a(false).a();
    b(paramActivity);
    paramActivity.show();
  }
  
  public static boolean a()
  {
    Object localObject = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).b();
    if ((localObject != null) && (((LiveData)localObject).getValue() != null) && (((GameDataServerOuterClass.GetUserSmobaRoleListRsp)((LiveData)localObject).getValue()).role_list != null))
    {
      localObject = ((GameDataServerOuterClass.GetUserSmobaRoleListRsp)((LiveData)localObject).getValue()).role_list.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          GameDataServerOuterClass.SmobaGameRoleAbsInfo localSmobaGameRoleAbsInfo = (GameDataServerOuterClass.SmobaGameRoleAbsInfo)((List)localObject).get(i);
          if ((localSmobaGameRoleAbsInfo != null) && (((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(localSmobaGameRoleAbsInfo.area.get())) && (localSmobaGameRoleAbsInfo.role_level.get() >= 6)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, @NonNull SmobaGangupCheckParam paramSmobaGangupCheckParam, boolean paramBoolean, SmobaCheckCallback paramSmobaCheckCallback)
  {
    if (a)
    {
      a(paramSmobaCheckCallback);
      return true;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkIsGangupAvaliable - ");
    ((StringBuilder)localObject1).append(paramSmobaCheckCallback);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(", checkFrom = ");
    ((StringBuilder)localObject1).append(paramSmobaGangupCheckParam.a);
    ((StringBuilder)localObject1).append(", isCreate = ");
    ((StringBuilder)localObject1).append(paramSmobaGangupCheckParam.b);
    Logger.a("SmobaUtil", ((StringBuilder)localObject1).toString());
    if (!GameCoreUtil.a(paramActivity, paramBoolean ^ true, "????????????", SmobaSchemeUtil.a(), "https://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.tmgp.sgame&channel=0002160650432d595942&fromcase=40001", new SmobaUtil.1()))
    {
      b(paramSmobaCheckCallback, "???????????????");
      return false;
    }
    localObject1 = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).c();
    if ((localObject1 != null) && (((LiveData)localObject1).getValue() != null) && (((GameDataServerOuterClass.GetSmobaAuthInfoRsp)((LiveData)localObject1).getValue()).is_auth.get()))
    {
      int i;
      if (paramSmobaGangupCheckParam.a == 2) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool;
      if (paramSmobaGangupCheckParam.e > 0)
      {
        bool = ((ISmobaService)ServiceCenter.a(ISmobaService.class)).a(paramSmobaGangupCheckParam.e);
        localObject1 = null;
        if (!bool) {
          if (i != 0) {
            localObject1 = "????????????QQ????????????????????????????????????????????????????????????????????????????????????????????????";
          } else {
            localObject1 = "????????????QQ???????????????????????????????????????";
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!paramBoolean)
          {
            if (i != 0) {
              CustomToastView.a((String)localObject1);
            } else {
              a(paramActivity, "???????????????????????????", (String)localObject1, "?????????");
            }
            CustomToastView.a((String)localObject1);
          }
          b(paramSmobaCheckCallback, "???????????????????????????");
          return false;
        }
      }
      Object localObject3 = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a();
      localObject2 = "??????";
      if ((localObject3 != null) && (((LiveData)localObject3).getValue() != null))
      {
        localObject1 = ((GameDataServerOuterClass.GetSmobaDefaultRoleRsp)((LiveData)localObject3).getValue()).role_info;
        int j = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject1).area.get();
        int k = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject1).partition.get();
        int m = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject1).role_level.get();
        if ((j > 0) && (k > 0))
        {
          if ((((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(j)) && (m >= 6))
          {
            if ((paramSmobaGangupCheckParam.d != 1) && (paramSmobaGangupCheckParam.d != 2)) {
              j = 0;
            } else {
              j = 1;
            }
            if (j != 0)
            {
              localObject2 = ((GameDataServerOuterClass.GetSmobaDefaultRoleRsp)((LiveData)localObject3).getValue()).role_info;
              if ((localObject2 != null) && (((GameDataServerOuterClass.SmobaGameRoleInfo)localObject2).hero_count.has()) && (((GameDataServerOuterClass.SmobaGameRoleInfo)localObject2).hero_count.get() < 1))
              {
                if (!paramBoolean) {
                  if (i != 0) {
                    CustomToastView.a("???????????????????????????1???????????????????????????????????????????????????????????????");
                  } else {
                    a(paramActivity, "????????????????????????????????????", "???????????????????????????1???????????????????????????????????????????????????????????????", "?????????");
                  }
                }
                b(paramSmobaCheckCallback, "????????????????????????????????????");
                return false;
              }
            }
            if ((!paramSmobaGangupCheckParam.b) && (paramSmobaGangupCheckParam.f != null) && (paramSmobaGangupCheckParam.f.size() > 0))
            {
              j = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject1).disp_grade_level.get();
              j = ((ISmobaService)ServiceCenter.a(ISmobaService.class)).c(j);
              if ((j > 0) && (!paramSmobaGangupCheckParam.f.contains(Integer.valueOf(j))))
              {
                if (!paramBoolean) {
                  if (a(paramSmobaGangupCheckParam.f))
                  {
                    a(false, paramActivity, "???????????????", "???????????????????????????????????????????????????????????????????????????????????????", "????????????", paramSmobaGangupCheckParam, paramBoolean, paramSmobaCheckCallback);
                  }
                  else
                  {
                    if (i != 0) {
                      CustomToastView.a("???????????????????????????????????????????????????????????????????????????????????????????????????");
                    } else {
                      a(paramActivity, "???????????????", "?????????????????????????????????????????????????????????????????????????????????", "?????????");
                    }
                    b(paramSmobaCheckCallback, "???????????????");
                  }
                }
                return false;
              }
            }
            a(paramSmobaCheckCallback);
            return true;
          }
          if (!paramBoolean)
          {
            bool = a();
            localObject1 = "????????????????????????????????????";
            if (!bool)
            {
              if ((m < 6) && (((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(j)))
              {
                paramSmobaGangupCheckParam = "??????????????????6??????????????????????????????????????????????????????????????????????????????????????????";
                localObject1 = "????????????????????????6???";
              }
              else if (!((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(j))
              {
                paramSmobaGangupCheckParam = "???????????????????????????????????????????????????????????????????????????";
              }
              else
              {
                localObject1 = "?????????????????????????????????";
                paramSmobaGangupCheckParam = "(1) ?????????????????????????????????\n(2) ???????????????????????????6???";
              }
              b(paramActivity, (String)localObject1, paramSmobaGangupCheckParam, "????????????");
              b(paramSmobaCheckCallback, (String)localObject1);
              return false;
            }
            if (!((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(j))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("????????????????????????????????????????????????");
              if (paramSmobaGangupCheckParam.b) {
                localObject2 = "??????";
              }
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append("?????????");
              localObject2 = ((StringBuilder)localObject3).toString();
              Logger.a("SmobaUtil", "checkIsGangupAvaliable - wrong gamePlatform");
            }
            else
            {
              Logger.a("SmobaUtil", "checkIsGangupAvaliable - level too low");
              localObject2 = "???????????????????????????6????????????????????????????????????????????????????????????????????????";
              localObject1 = "????????????????????????6???";
            }
            a(false, paramActivity, (String)localObject1, (String)localObject2, "????????????", paramSmobaGangupCheckParam, paramBoolean, paramSmobaCheckCallback);
            return false;
          }
          return false;
        }
        if (!paramBoolean) {
          b(paramActivity, "??????????????????????????????", "?????????????????????????????????????????????????????????", "????????????");
        }
        b(paramSmobaCheckCallback, "??????????????????????????????");
        return false;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("?????????????????????????????????");
      if (paramSmobaGangupCheckParam.b) {
        localObject2 = "??????";
      }
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("?????????");
      a(true, paramActivity, "????????????????????????", ((StringBuilder)localObject1).toString(), "????????????", paramSmobaGangupCheckParam, paramBoolean, paramSmobaCheckCallback);
      return false;
    }
    Object localObject2 = TimiGameActivityManager.a();
    if ((localObject2 != null) && (localObject1 != null) && (((LiveData)localObject1).getValue() != null))
    {
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a((QBaseActivity)localObject2, ((GameDataServerOuterClass.GetSmobaAuthInfoRsp)((LiveData)localObject1).getValue()).auth_desc.get(), true, new SmobaUtil.2(paramSmobaCheckCallback), new SmobaUtil.3(paramSmobaCheckCallback, paramActivity, paramSmobaGangupCheckParam, paramBoolean));
    }
    else
    {
      paramActivity = new StringBuilder();
      paramActivity.append("checkIsGangupAvaliable  error, topActivity = ");
      paramActivity.append(localObject2);
      paramActivity.append(", smobaAuthInfoLiveData = ");
      paramActivity.append(localObject1);
      Logger.c("SmobaUtil", paramActivity.toString());
      CustomToastView.a("????????????????????????????????????");
      b(paramSmobaCheckCallback, "????????????????????????????????????");
    }
    return false;
  }
  
  public static boolean a(List<Integer> paramList)
  {
    Object localObject = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).b();
    if ((localObject != null) && (((LiveData)localObject).getValue() != null) && (((GameDataServerOuterClass.GetUserSmobaRoleListRsp)((LiveData)localObject).getValue()).role_list != null))
    {
      localObject = ((GameDataServerOuterClass.GetUserSmobaRoleListRsp)((LiveData)localObject).getValue()).role_list.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          GameDataServerOuterClass.SmobaGameRoleAbsInfo localSmobaGameRoleAbsInfo = (GameDataServerOuterClass.SmobaGameRoleAbsInfo)((List)localObject).get(i);
          if ((localSmobaGameRoleAbsInfo != null) && (((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(localSmobaGameRoleAbsInfo.area.get())) && (paramList.contains(Integer.valueOf(((ISmobaService)ServiceCenter.a(ISmobaService.class)).c(localSmobaGameRoleAbsInfo.disp_grade_level.get()))))) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    c();
    paramActivity = new CommonDialog.Builder(paramActivity).a(paramString1).c(paramString2).d(paramString3).a(new SmobaUtil.10()).e("????????????").b(new SmobaUtil.9()).a();
    b(paramActivity);
    paramActivity.show();
  }
  
  private static void b(SmobaCheckCallback paramSmobaCheckCallback, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsGangupAvaliable - ");
    localStringBuilder.append(paramSmobaCheckCallback);
    localStringBuilder.append(", onCheckFail = ");
    localStringBuilder.append(paramString);
    Logger.c("SmobaUtil", localStringBuilder.toString());
    if (paramSmobaCheckCallback != null) {
      paramSmobaCheckCallback.a(paramString);
    }
  }
  
  private static void b(CommonDialog paramCommonDialog)
  {
    b = paramCommonDialog;
    paramCommonDialog = b;
    if (paramCommonDialog != null) {
      paramCommonDialog.setOnDismissListener(new SmobaUtil.4());
    }
  }
  
  private static void c()
  {
    CommonDialog localCommonDialog = b;
    if ((localCommonDialog != null) && (localCommonDialog.isShowing()))
    {
      b.dismiss();
      b = null;
    }
  }
  
  private static void d()
  {
    Object localObject1 = TimiGameActivityManager.a();
    Object localObject2 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("jumpToTeamList-openExpandHall topActivity - ");
    ((StringBuilder)localObject3).append(localObject1);
    ((StringBuilder)localObject3).append(", curHall = ");
    ((StringBuilder)localObject3).append(localObject2);
    Logger.a("SmobaUtil", ((StringBuilder)localObject3).toString());
    if (localObject2 != null)
    {
      ((IExpandHall)localObject2).f();
      return;
    }
    localObject2 = new ExpandHallLaunchParam();
    ((ExpandHallLaunchParam)localObject2).h = true;
    localObject3 = (IExpandHallService)ServiceCenter.a(IExpandHallService.class);
    if (localObject1 == null) {
      localObject1 = Env.a();
    }
    ((IExpandHallService)localObject3).a((Context)localObject1, (ExpandHallLaunchParam)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaUtil
 * JD-Core Version:    0.7.0.1
 */