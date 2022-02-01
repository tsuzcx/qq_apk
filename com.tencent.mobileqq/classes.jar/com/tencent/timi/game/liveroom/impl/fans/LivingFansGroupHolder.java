package com.tencent.timi.game.liveroom.impl.fans;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorFansGroupItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.TimiRoundImageView;
import com.tencent.timi.game.utils.DrawableUtil;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorFansGroupItem;", "parent", "Landroid/view/ViewGroup;", "resId", "", "listener", "Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder$ItemClickListener;", "anchorUid", "", "(Landroid/view/ViewGroup;ILcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder$ItemClickListener;J)V", "IN_GROUP", "getAnchorUid", "()J", "headerIcon", "Lcom/tencent/timi/game/ui/widget/TimiRoundImageView;", "getHeaderIcon", "()Lcom/tencent/timi/game/ui/widget/TimiRoundImageView;", "setHeaderIcon", "(Lcom/tencent/timi/game/ui/widget/TimiRoundImageView;)V", "itemData", "itemText", "Landroid/widget/TextView;", "getItemText", "()Landroid/widget/TextView;", "setItemText", "(Landroid/widget/TextView;)V", "joinGroupButton", "getJoinGroupButton", "setJoinGroupButton", "getListener", "()Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder$ItemClickListener;", "bindItemData", "", "data", "ItemClickListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingFansGroupHolder
  extends BaseViewHolder<QQLiveAnchorFansGroupItem>
{
  private final int a;
  @Nullable
  private TimiRoundImageView b;
  @Nullable
  private TextView c;
  @Nullable
  private TextView d;
  private QQLiveAnchorFansGroupItem e;
  @NotNull
  private final LivingFansGroupHolder.ItemClickListener f;
  private final long g;
  
  public LivingFansGroupHolder(@Nullable ViewGroup paramViewGroup, int paramInt, @NotNull LivingFansGroupHolder.ItemClickListener paramItemClickListener, long paramLong)
  {
    super(paramViewGroup, paramInt);
    this.f = paramItemClickListener;
    this.g = paramLong;
    this.a = 1;
    this.b = ((TimiRoundImageView)getView(2131434941));
    this.c = ((TextView)getView(2131435951));
    this.d = ((TextView)getView(2131436678));
    paramViewGroup = this.d;
    if (paramViewGroup != null) {
      ViewExKt.a((View)paramViewGroup, LayoutExKt.b(15), new int[] { Color.parseColor("#6666FF") });
    }
    this.itemView.setOnClickListener((View.OnClickListener)new LivingFansGroupHolder.1(this));
    if (!LivingOperateHelper.a.a(this.g))
    {
      paramViewGroup = (Map)new LinkedHashMap();
      paramViewGroup.put("zengzhi_moduleid", "em_qqlive_anchorfan_group");
      paramItemClickListener = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      View localView = this.itemView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "itemView");
      paramItemClickListener.a(localView, true, null, "em_qqlive_group_addbutton", paramViewGroup);
      return;
    }
    paramViewGroup = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    paramItemClickListener = this.itemView;
    Intrinsics.checkExpressionValueIsNotNull(paramItemClickListener, "itemView");
    paramViewGroup.a(paramItemClickListener, true, null, "em_qqlive_anchorfan_list_addbutton", (Map)new LinkedHashMap());
  }
  
  @NotNull
  public final LivingFansGroupHolder.ItemClickListener a()
  {
    return this.f;
  }
  
  public final void a(@NotNull QQLiveAnchorFansGroupItem paramQQLiveAnchorFansGroupItem)
  {
    Intrinsics.checkParameterIsNotNull(paramQQLiveAnchorFansGroupItem, "data");
    this.e = paramQQLiveAnchorFansGroupItem;
    Object localObject = DrawableUtil.a.a(ViewUtils.dpToPx(34.0F), (View)this.b, 2130852861);
    long l = paramQQLiveAnchorFansGroupItem.groupId;
    DrawableUtil localDrawableUtil = DrawableUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://p.qlogo.cn/gh/");
    localStringBuilder.append(l);
    localStringBuilder.append('/');
    localStringBuilder.append(l);
    localStringBuilder.append('/');
    localDrawableUtil.a(localStringBuilder.toString(), (ImageView)this.b, (URLDrawable.URLDrawableOptions)localObject);
    localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramQQLiveAnchorFansGroupItem.name);
    }
    int i;
    if (paramQQLiveAnchorFansGroupItem.isMember == this.a) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = this.d;
    if (localObject != null)
    {
      if (i != 0) {
        paramQQLiveAnchorFansGroupItem = "查看";
      } else {
        paramQQLiveAnchorFansGroupItem = "加群";
      }
      ((TextView)localObject).setText((CharSequence)paramQQLiveAnchorFansGroupItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.fans.LivingFansGroupHolder
 * JD-Core Version:    0.7.0.1
 */