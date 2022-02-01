package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.profile.api.ProfileReportUtil;
import com.tencent.timi.game.profile.impl.net.BatchGetSmobaTeamInfoServlet;
import com.tencent.timi.game.profile.impl.net.BatchGetSmobaTeamInfoServlet.Companion;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader.IPAGResourceLoadListener;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.NetRspUserData;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfo;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfoList;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.CommonOuterClass.RoomRouteInfo;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo;
import trpc.yes.common.PremadesTeamServerOuterClass.UserOnlineRouteInfoList;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/view/ProfileItemInTeamView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "isDetached", "", "pagDownloadListener", "com/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$pagDownloadListener$1", "Lcom/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$pagDownloadListener$1;", "pagIconUrl", "pagViewInited", "qqActivity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "reportMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "teamInfo", "Ltrpc/yes/common/PremadesTeamServerOuterClass$SmobaPremadesTeamInfo;", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "acquireSmobaTeamInfo", "", "teamId", "", "initPagView", "pag", "Lorg/libpag/PAGFile;", "initView", "isTeamInGame", "onDetachedFromWindow", "preLoadTeamInfo", "report", "response", "Ltrpc/yes/common/PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoRsp;", "roomInfo", "resizePag", "pagFile", "width", "setData", "result", "Lcom/tencent/timi/game/userinfo/api/NetRspUserData;", "reportParamMap", "", "setDescribeContent", "userInfo", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "setDescribeView", "info", "setStatusView", "setViewVisible", "visible", "showTeamInfoByType", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileItemInTeamView
  extends RelativeLayout
{
  private final String a = "ProfileItemInTeamView";
  private boolean b;
  private boolean c;
  private PremadesTeamServerOuterClass.SmobaPremadesTeamInfo d;
  private CommonOuterClass.QQUserId e;
  private final String f = "https://cdn.yes.qq.com/client_business/fck_user_info_in_team.pag";
  private QBaseActivity g;
  @Nullable
  private View.OnClickListener h;
  private HashMap<String, String> i = new HashMap();
  private final ProfileItemInTeamView.pagDownloadListener.1 j = new ProfileItemInTeamView.pagDownloadListener.1(this);
  private HashMap k;
  
  public ProfileItemInTeamView(@Nullable Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProfileItemInTeamView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ProfileItemInTeamView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private final PAGFile a(PAGFile paramPAGFile, int paramInt)
  {
    Matrix localMatrix = paramPAGFile.getTotalMatrix();
    float f1 = UITools.a(getContext(), paramInt) * 1.0F / paramPAGFile.width();
    localMatrix.setScale(f1, f1);
    paramPAGFile.setMatrix(localMatrix);
    return paramPAGFile;
  }
  
  private final void a()
  {
    RelativeLayout.inflate(getContext(), 2131629461, (ViewGroup)this);
    setPadding(ViewUtils.dip2px(12.0F), ViewUtils.dip2px(16.0F), ViewUtils.dip2px(12.0F), ViewUtils.dip2px(16.0F));
    ViewExKt.a(this, LayoutExKt.b(6), new int[] { Color.parseColor("#FAFAFA") });
    setOnClickListener((View.OnClickListener)new ProfileItemInTeamView.initView.1(this));
    TimiPAGResourceLoader.a.a((TimiPAGResourceLoader.IPAGResourceLoadListener)this.j);
  }
  
  private final void a(long paramLong1, long paramLong2)
  {
    List localList = (List)new ArrayList();
    localList.add(Long.valueOf(paramLong1));
    ProfileItemInTeamView.acquireSmobaTeamInfo.listener.1 local1 = new ProfileItemInTeamView.acquireSmobaTeamInfo.listener.1(this, paramLong1);
    ((NetApi)ServiceCenter.a(NetApi.class)).a(BatchGetSmobaTeamInfoServlet.a.a(localList, paramLong2), PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp.class, (RequestListener)local1);
  }
  
  private final void a(PAGFile paramPAGFile)
  {
    Logger.a(this.a, "initPagView - start");
    if (this.c) {
      return;
    }
    Object localObject = a(paramPAGFile, 35);
    paramPAGFile = PAGComposition.Make(LayoutExKt.b(35), LayoutExKt.b(35));
    if (paramPAGFile == null) {
      return;
    }
    paramPAGFile.addLayer((PAGLayer)localObject);
    localObject = (TimiGamePAGView)a(2131435662);
    if (localObject != null)
    {
      ((TimiGamePAGView)localObject).setComposition(paramPAGFile);
      ((TimiGamePAGView)localObject).setRepeatCount(0);
      ((TimiGamePAGView)localObject).c();
    }
    this.c = true;
    Logger.a(this.a, "initPagView - end");
  }
  
  private final void a(CommonOuterClass.QQUserId paramQQUserId, IUserInfo paramIUserInfo)
  {
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    int m;
    if (((ILoginCoreService)localObject).a() == paramQQUserId.uid.get()) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      paramQQUserId = (MediumBoldTextView)a(2131446860);
      if (paramQQUserId != null) {
        paramQQUserId.setText((CharSequence)"进入");
      }
    }
    else
    {
      String str = "与TA玩";
      localObject = str;
      if (paramIUserInfo != null)
      {
        paramQQUserId = paramIUserInfo.d(paramQQUserId);
        localObject = str;
        if (paramQQUserId != null)
        {
          if (Intrinsics.areEqual("男", paramQQUserId)) {}
          for (paramQQUserId = "与他玩";; paramQQUserId = "与她玩")
          {
            localObject = paramQQUserId;
            break;
            localObject = str;
            if (!Intrinsics.areEqual("女", paramQQUserId)) {
              break;
            }
          }
        }
      }
      paramQQUserId = (MediumBoldTextView)a(2131446860);
      if (paramQQUserId != null) {
        paramQQUserId.setText((CharSequence)localObject);
      }
    }
  }
  
  private final void a(PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp paramBatchGetSmobaTeamInfoRsp, PremadesTeamServerOuterClass.SmobaPremadesTeamInfo paramSmobaPremadesTeamInfo)
  {
    if (paramBatchGetSmobaTeamInfoRsp != null)
    {
      paramSmobaPremadesTeamInfo = paramBatchGetSmobaTeamInfoRsp.share_yolo_room_msg;
      if (paramSmobaPremadesTeamInfo != null)
      {
        m = paramSmobaPremadesTeamInfo.size();
        break label23;
      }
    }
    int m = 0;
    label23:
    if ((m > 0) && (paramBatchGetSmobaTeamInfoRsp != null))
    {
      paramBatchGetSmobaTeamInfoRsp = paramBatchGetSmobaTeamInfoRsp.share_yolo_room_msg;
      if (paramBatchGetSmobaTeamInfoRsp != null)
      {
        paramBatchGetSmobaTeamInfoRsp = (MessageOuterClass.ShareYoloRoomMsg)paramBatchGetSmobaTeamInfoRsp.get(0);
        if (paramBatchGetSmobaTeamInfoRsp != null)
        {
          paramBatchGetSmobaTeamInfoRsp = paramBatchGetSmobaTeamInfoRsp.room_info;
          if (paramBatchGetSmobaTeamInfoRsp != null)
          {
            paramBatchGetSmobaTeamInfoRsp = (YoloRoomOuterClass.YoloRoomInfo)paramBatchGetSmobaTeamInfoRsp.get();
            if (paramBatchGetSmobaTeamInfoRsp != null)
            {
              paramBatchGetSmobaTeamInfoRsp = YoloRoomUtil.b(paramBatchGetSmobaTeamInfoRsp);
              this.i.putAll((Map)paramBatchGetSmobaTeamInfoRsp);
            }
          }
        }
      }
    }
    ProfileReportUtil.a.a((View)this, "em_yes_userprofile_panel_teaming", (Map)this.i);
  }
  
  private final boolean a(PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp paramBatchGetSmobaTeamInfoRsp)
  {
    if (paramBatchGetSmobaTeamInfoRsp != null)
    {
      paramBatchGetSmobaTeamInfoRsp = paramBatchGetSmobaTeamInfoRsp.share_yolo_room_msg;
      if (paramBatchGetSmobaTeamInfoRsp != null)
      {
        paramBatchGetSmobaTeamInfoRsp = paramBatchGetSmobaTeamInfoRsp.get();
        if (paramBatchGetSmobaTeamInfoRsp != null)
        {
          paramBatchGetSmobaTeamInfoRsp = ((Iterable)paramBatchGetSmobaTeamInfoRsp).iterator();
          while (paramBatchGetSmobaTeamInfoRsp.hasNext())
          {
            Object localObject = ((MessageOuterClass.ShareYoloRoomMsg)paramBatchGetSmobaTeamInfoRsp.next()).room_info;
            if (localObject != null)
            {
              localObject = ((YoloRoomOuterClass.YoloRoomInfo)localObject).room_data_info;
              if (localObject != null)
              {
                localObject = ((YoloRoomOuterClass.YoloRoomDataInfo)localObject).sub_create_from;
                if (localObject != null)
                {
                  m = ((PBInt32Field)localObject).get();
                  break label86;
                }
              }
            }
            int m = -1;
            label86:
            localObject = this.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("showTeamInfoByType -");
            localStringBuilder.append(m);
            Logger.b((String)localObject, localStringBuilder.toString());
            if ((m == 0) || (m == 1)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private final boolean a(PremadesTeamServerOuterClass.SmobaPremadesTeamInfo paramSmobaPremadesTeamInfo)
  {
    if (paramSmobaPremadesTeamInfo != null)
    {
      paramSmobaPremadesTeamInfo = paramSmobaPremadesTeamInfo.game_status;
      if (paramSmobaPremadesTeamInfo != null)
      {
        m = paramSmobaPremadesTeamInfo.get();
        break label23;
      }
    }
    int m = -1;
    label23:
    paramSmobaPremadesTeamInfo = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTeamInGame ");
    localStringBuilder.append(m);
    Logger.b(paramSmobaPremadesTeamInfo, localStringBuilder.toString());
    return m == 3;
  }
  
  private final void setDescribeView(PremadesTeamServerOuterClass.SmobaPremadesTeamInfo paramSmobaPremadesTeamInfo)
  {
    if (paramSmobaPremadesTeamInfo != null)
    {
      localObject1 = paramSmobaPremadesTeamInfo.name;
      if (localObject1 != null)
      {
        localObject1 = ((PBStringField)localObject1).get();
        if (localObject1 != null) {
          break label35;
        }
      }
    }
    Object localObject1 = "";
    label35:
    if (paramSmobaPremadesTeamInfo != null)
    {
      localObject2 = paramSmobaPremadesTeamInfo.game_mode;
      if (localObject2 != null)
      {
        localObject2 = Integer.valueOf(((PBInt32Field)localObject2).get());
        break label66;
      }
    }
    Object localObject2 = null;
    label66:
    Object localObject3 = "排位";
    if ((localObject2 != null) && (((Integer)localObject2).intValue() == 1)) {
      localObject2 = localObject3;
    } else if ((localObject2 != null) && (((Integer)localObject2).intValue() == 2)) {
      localObject2 = localObject3;
    } else {
      localObject2 = "匹配";
    }
    int m = 0;
    int n = 0;
    if (paramSmobaPremadesTeamInfo != null)
    {
      paramSmobaPremadesTeamInfo = paramSmobaPremadesTeamInfo.user_list;
      if (paramSmobaPremadesTeamInfo != null)
      {
        paramSmobaPremadesTeamInfo = paramSmobaPremadesTeamInfo.get();
        if (paramSmobaPremadesTeamInfo != null)
        {
          paramSmobaPremadesTeamInfo = ((Iterable)paramSmobaPremadesTeamInfo).iterator();
          m = 0;
          while (paramSmobaPremadesTeamInfo.hasNext())
          {
            localObject3 = (PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)paramSmobaPremadesTeamInfo.next();
            if (((PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)localObject3).status.get() == 0)
            {
              int i1 = n + 1;
              n = i1;
              if (((PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)localObject3).uid.get() != 0L)
              {
                m += 1;
                n = i1;
              }
            }
          }
          break label229;
        }
      }
    }
    n = 0;
    label229:
    paramSmobaPremadesTeamInfo = (MediumBoldTextView)a(2131435661);
    if (paramSmobaPremadesTeamInfo != null) {
      paramSmobaPremadesTeamInfo.setText((CharSequence)localObject1);
    }
    paramSmobaPremadesTeamInfo = (TextView)a(2131446857);
    if (paramSmobaPremadesTeamInfo != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append('/');
      ((StringBuilder)localObject1).append(n);
      paramSmobaPremadesTeamInfo.setText((CharSequence)((StringBuilder)localObject1).toString());
    }
  }
  
  private final void setStatusView(PremadesTeamServerOuterClass.SmobaPremadesTeamInfo paramSmobaPremadesTeamInfo) {}
  
  private final void setViewVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PAGFile localPAGFile = TimiPAGResourceLoader.a(TimiPAGResourceLoader.a, this.f, null, 2, null);
      if (localPAGFile != null) {
        a(localPAGFile);
      }
    }
    ViewExKt.a(this, paramBoolean);
  }
  
  public View a(int paramInt)
  {
    if (this.k == null) {
      this.k = new HashMap();
    }
    View localView2 = (View)this.k.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.k.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    paramQQUserId = TeamInfoAutoUpdateService.a().a(paramQQUserId.uid.get());
    if (paramQQUserId != null)
    {
      paramQQUserId = paramQQUserId.list;
      if (paramQQUserId != null)
      {
        paramQQUserId = paramQQUserId.route_list;
        if (paramQQUserId != null)
        {
          paramQQUserId = paramQQUserId.get();
          if (paramQQUserId != null)
          {
            paramQQUserId = ((Iterable)paramQQUserId).iterator();
            while (paramQQUserId.hasNext()) {
              if (((CommonOuterClass.OnlineRouteInfo)paramQQUserId.next()).yolo_room_route_info.room_type.get() == 1) {
                setViewVisible(true);
              }
            }
          }
        }
      }
    }
  }
  
  @Nullable
  public final View.OnClickListener getClickListener()
  {
    return this.h;
  }
  
  protected void onDetachedFromWindow()
  {
    this.b = true;
    TimiPAGResourceLoader.a.b((TimiPAGResourceLoader.IPAGResourceLoadListener)this.j);
    super.onDetachedFromWindow();
  }
  
  public final void setClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
  }
  
  public final void setData(@Nullable NetRspUserData paramNetRspUserData, @NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull QBaseActivity paramQBaseActivity, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "qqActivity");
    Intrinsics.checkParameterIsNotNull(paramMap, "reportParamMap");
    this.g = paramQBaseActivity;
    this.e = paramQQUserId;
    this.i = new HashMap(paramMap);
    if (paramNetRspUserData != null)
    {
      paramQBaseActivity = paramNetRspUserData.b();
      if (paramQBaseActivity != null)
      {
        paramQBaseActivity = paramQBaseActivity.route_list;
        if (paramQBaseActivity != null)
        {
          paramQBaseActivity = paramQBaseActivity.get();
          if (paramQBaseActivity != null)
          {
            paramQBaseActivity = ((Iterable)paramQBaseActivity).iterator();
            long l1 = 0L;
            for (;;)
            {
              l2 = l1;
              if (!paramQBaseActivity.hasNext()) {
                break;
              }
              paramMap = (CommonOuterClass.OnlineRouteInfo)paramQBaseActivity.next();
              if (paramMap.yolo_room_route_info.room_type.get() == 1) {
                l1 = paramMap.yolo_room_route_info.room_id.get();
              }
            }
          }
        }
      }
    }
    long l2 = 0L;
    if (l2 != 0L) {
      a(l2, paramQQUserId.uid.get());
    }
    if (paramNetRspUserData != null) {
      paramNetRspUserData = paramNetRspUserData.a();
    } else {
      paramNetRspUserData = null;
    }
    a(paramQQUserId, paramNetRspUserData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.ProfileItemInTeamView
 * JD-Core Version:    0.7.0.1
 */