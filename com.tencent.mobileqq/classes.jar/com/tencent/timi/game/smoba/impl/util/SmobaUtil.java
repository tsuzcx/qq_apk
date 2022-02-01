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
    paramActivity = new CommonDialog.Builder(paramActivity).a(paramString1).c(paramString2).d(paramString3).a(new SmobaUtil.8()).e("晚点再说").b(new SmobaUtil.7()).a();
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
    paramActivity = new CommonDialog.Builder(paramActivity).a(paramString1).c(paramString2).d(paramString3).a(paramSmobaGangupCheckParam).e("晚点再说").b(new SmobaUtil.6(paramSmobaCheckCallback, paramString1)).a(false).a();
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
    if (!GameCoreUtil.a(paramActivity, paramBoolean ^ true, "王者荣耀", SmobaSchemeUtil.a(), "https://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.tmgp.sgame&channel=0002160650432d595942&fromcase=40001", new SmobaUtil.1()))
    {
      b(paramSmobaCheckCallback, "游戏未安装");
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
            localObject1 = "你使用了QQ区帐号，无法加入微信区车队，再看看别的队或自己创建队伍当队长吧～";
          } else {
            localObject1 = "你使用了QQ区帐号，无法加入微信区房间";
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!paramBoolean)
          {
            if (i != 0) {
              CustomToastView.a((String)localObject1);
            } else {
              a(paramActivity, "帐号所属平台不一致", (String)localObject1, "去看看");
            }
            CustomToastView.a((String)localObject1);
          }
          b(paramSmobaCheckCallback, "帐号所属平台不一致");
          return false;
        }
      }
      Object localObject3 = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a();
      localObject2 = "加入";
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
                    CustomToastView.a("游戏帐号英雄数不满1个，无法参与排位赛，试试其他匹配赛的车队吧");
                  } else {
                    a(paramActivity, "英雄数量不满足排位赛要求", "游戏帐号英雄数不满1个，无法参与排位赛，试试其他匹配赛的车队吧", "去看看");
                  }
                }
                b(paramSmobaCheckCallback, "英雄数量不满足排位赛要求");
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
                    a(false, paramActivity, "段位不匹配", "当前游戏帐号段位不符合车队要求噢，请切换帐号后再加入车队吧", "切换帐号", paramSmobaGangupCheckParam, paramBoolean, paramSmobaCheckCallback);
                  }
                  else
                  {
                    if (i != 0) {
                      CustomToastView.a("你的游戏段位不满足车队需求呢，再看看别的队或自己创建队伍当队长吧～");
                    } else {
                      a(paramActivity, "段位不匹配", "你的游戏段位不满足车队需求呢，我们为你推荐了其他车队噢", "去看看");
                    }
                    b(paramSmobaCheckCallback, "段位不匹配");
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
            localObject1 = "默认游戏帐号不是安卓区的";
            if (!bool)
            {
              if ((m < 6) && (((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(j)))
              {
                paramSmobaGangupCheckParam = "游戏帐号不满6级，无法一起开黑哦。先去游戏中提升等级，稍等一会儿就生效了。";
                localObject1 = "游戏帐号等级不足6级";
              }
              else if (!((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(j))
              {
                paramSmobaGangupCheckParam = "你没有符合条件的安卓区游戏帐号，请先到游戏中创建吧";
              }
              else
              {
                localObject1 = "无法成功操作，原因是：";
                paramSmobaGangupCheckParam = "(1) 你当前游戏帐号是苹果区\n(2) 你当前游戏帐号不满6级";
              }
              b(paramActivity, (String)localObject1, paramSmobaGangupCheckParam, "启动游戏");
              b(paramSmobaCheckCallback, (String)localObject1);
              return false;
            }
            if (!((ISmobaService)ServiceCenter.a(ISmobaService.class)).b(j))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("请切换为安卓系统的游戏帐号，才能");
              if (paramSmobaGangupCheckParam.b) {
                localObject2 = "创建";
              }
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append("车队噢");
              localObject2 = ((StringBuilder)localObject3).toString();
              Logger.a("SmobaUtil", "checkIsGangupAvaliable - wrong gamePlatform");
            }
            else
            {
              Logger.a("SmobaUtil", "checkIsGangupAvaliable - level too low");
              localObject2 = "默认的游戏帐号不满6级，无法一起开黑哦。请先切换游戏帐号再一起开黑吧";
              localObject1 = "游戏帐号等级不足6级";
            }
            a(false, paramActivity, (String)localObject1, (String)localObject2, "切换帐号", paramSmobaGangupCheckParam, paramBoolean, paramSmobaCheckCallback);
            return false;
          }
          return false;
        }
        if (!paramBoolean) {
          b(paramActivity, "帐号尚未创建游戏角色", "请先到游戏中创建游戏角色，再回来试试吧", "启动游戏");
        }
        b(paramSmobaCheckCallback, "帐号尚未创建游戏角色");
        return false;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("请先关联游戏帐号，才能");
      if (paramSmobaGangupCheckParam.b) {
        localObject2 = "创建";
      }
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("车队噢");
      a(true, paramActivity, "尚未关联游戏角色", ((StringBuilder)localObject1).toString(), "关联帐号", paramSmobaGangupCheckParam, paramBoolean, paramSmobaCheckCallback);
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
      CustomToastView.a("请先绑定你的默认王者帐号");
      b(paramSmobaCheckCallback, "请先绑定你的默认王者帐号");
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
    paramActivity = new CommonDialog.Builder(paramActivity).a(paramString1).c(paramString2).d(paramString3).a(new SmobaUtil.10()).e("晚点再说").b(new SmobaUtil.9()).a();
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