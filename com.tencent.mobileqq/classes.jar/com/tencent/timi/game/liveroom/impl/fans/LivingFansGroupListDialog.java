package com.tencent.timi.game.liveroom.impl.fans;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorFansGroupItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper;
import com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager;
import com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager.Companion;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.SimpleSlideUpDialog;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupListDialog;", "Lcom/tencent/timi/game/ui/widget/SimpleSlideUpDialog;", "Landroid/view/View$OnClickListener;", "dialogContext", "Landroid/content/Context;", "anchorUid", "", "fansGroupList", "", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorFansGroupItem;", "isLandscape", "", "(Landroid/content/Context;JLjava/util/List;Z)V", "TAG", "", "adapter", "Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupListAdapter;", "getDialogContext", "()Landroid/content/Context;", "isDismissed", "()Z", "acquireReportModuleMap", "", "contentView", "Landroid/view/View;", "dismiss", "", "initView", "jumpToFunPage", "item", "onClick", "v", "reportData", "shadowBgView", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingFansGroupListDialog
  extends SimpleSlideUpDialog
  implements View.OnClickListener
{
  private final String a;
  private LivingFansGroupListAdapter b;
  private boolean c;
  @NotNull
  private final Context d;
  private final long f;
  private final List<QQLiveAnchorFansGroupItem> g;
  private final boolean h;
  
  public LivingFansGroupListDialog(@NotNull Context paramContext, long paramLong, @NotNull List<? extends QQLiveAnchorFansGroupItem> paramList, boolean paramBoolean)
  {
    super(paramContext);
    this.d = paramContext;
    this.f = paramLong;
    this.g = paramList;
    this.h = paramBoolean;
    this.a = "LivingFansGroupListDialog";
    setContentView(2131629444);
    a();
  }
  
  private final void a()
  {
    Object localObject1 = new LinearLayoutManager(this.e, 1, false);
    Object localObject2 = (RecyclerView)findViewById(2131431331);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "contentRecycler");
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
    this.b = new LivingFansGroupListAdapter(this.d, this.g, (LivingFansGroupHolder.ItemClickListener)new LivingFansGroupListDialog.initView.1(this), this.f);
    localObject1 = (RecyclerView)findViewById(2131431331);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "contentRecycler");
    ((RecyclerView)localObject1).setAdapter((RecyclerView.Adapter)this.b);
    localObject1 = findViewById(2131445743);
    localObject2 = (View.OnClickListener)this;
    ((View)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    ((MediumBoldTextView)findViewById(2131430274)).setOnClickListener((View.OnClickListener)localObject2);
    e();
  }
  
  private final void a(QQLiveAnchorFansGroupItem paramQQLiveAnchorFansGroupItem)
  {
    Intent localIntent = new Intent(this.d, JumpActivity.class);
    paramQQLiveAnchorFansGroupItem = Uri.parse(paramQQLiveAnchorFansGroupItem.groupCardSchema);
    Intrinsics.checkExpressionValueIsNotNull(paramQQLiveAnchorFansGroupItem, "Uri.parse(item.groupCardSchema)");
    localIntent.setData(paramQQLiveAnchorFansGroupItem);
    this.d.startActivity(localIntent);
  }
  
  private final void e()
  {
    if (!LivingOperateHelper.a.a(this.f))
    {
      Object localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      Object localObject2 = (RelativeLayout)findViewById(2131431872);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "dialogRootRel");
      ((ILiveReportService)localObject1).a(localObject2, "pg_qqlive_audience", TGReportAudienceParamsManager.a.a().a());
      Map localMap = (Map)new LinkedHashMap();
      localMap.put("qqlive_group_num", String.valueOf(this.g.size()));
      int i = 0;
      localObject1 = ((Iterable)this.g).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((QQLiveAnchorFansGroupItem)((Iterator)localObject1).next()).isMember == 1) {
          i = 1;
        }
      }
      localObject2 = "1";
      if (i != 0) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localMap.put("qqlive_is_fan", localObject1);
      if (this.h) {
        localObject1 = localObject2;
      } else {
        localObject1 = "0";
      }
      localMap.put("qqlive_screen_orientation", localObject1);
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (LinearLayout)findViewById(2131431334);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "contentRootView");
      ((ILiveReportService)localObject1).a((View)localObject2, true, null, "em_qqlive_anchorfan_group", localMap);
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (RecyclerView)findViewById(2131431331);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "contentRecycler");
      ((ILiveReportService)localObject1).a((View)localObject2, true, null, "em_qqlive_anchorfan_list", (Map)new LinkedHashMap());
    }
  }
  
  @NotNull
  public View b()
  {
    View localView = findViewById(2131445743);
    Intrinsics.checkExpressionValueIsNotNull(localView, "shadowView");
    return localView;
  }
  
  @NotNull
  public View c()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "contentRootView");
    return (View)localLinearLayout;
  }
  
  public void dismiss()
  {
    this.c = true;
    super.dismiss();
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (!NoDoubleClickUtils.a())
    {
      int i = paramView.getId();
      if ((i == 2131430274) || (i == 2131445743)) {
        dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.fans.LivingFansGroupListDialog
 * JD-Core Version:    0.7.0.1
 */