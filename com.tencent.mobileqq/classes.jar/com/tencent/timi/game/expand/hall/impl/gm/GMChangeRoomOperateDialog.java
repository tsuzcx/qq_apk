package com.tencent.timi.game.expand.hall.impl.gm;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ui.widget.SimpleSlideUpDialog;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.RecommendProxyOuterClass.KuolieRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/gm/GMChangeRoomOperateDialog;", "Lcom/tencent/timi/game/ui/widget/SimpleSlideUpDialog;", "Landroid/view/View$OnClickListener;", "dataList", "", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "context", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "itemClickListener", "Lcom/tencent/timi/game/expand/hall/impl/gm/GMChangeRoomOperateDialog$ItemClickListener;", "getItemClickListener", "()Lcom/tencent/timi/game/expand/hall/impl/gm/GMChangeRoomOperateDialog$ItemClickListener;", "setItemClickListener", "(Lcom/tencent/timi/game/expand/hall/impl/gm/GMChangeRoomOperateDialog$ItemClickListener;)V", "maxContentHeight", "", "contentView", "Landroid/view/View;", "initViews", "", "onClick", "v", "onDetachedFromWindow", "setContentHeight", "currentHeiht", "shadowBgView", "ItemClickListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GMChangeRoomOperateDialog
  extends SimpleSlideUpDialog
  implements View.OnClickListener
{
  @Nullable
  private GMChangeRoomOperateDialog.ItemClickListener a;
  private final int b;
  private final List<RecommendProxyOuterClass.KuolieRoomInfo> c;
  
  public GMChangeRoomOperateDialog(@NotNull List<RecommendProxyOuterClass.KuolieRoomInfo> paramList, @NotNull Context paramContext)
  {
    super(paramContext);
    this.c = paramList;
    this.b = LayoutExKt.b(450);
    setContentView(2131629429);
    e();
  }
  
  private final void a(int paramInt)
  {
    if (paramInt > this.b)
    {
      Object localObject = (ScrollView)findViewById(2131431334);
      if (localObject != null) {
        localObject = ((ScrollView)localObject).getLayoutParams();
      } else {
        localObject = null;
      }
      if ((localObject instanceof ViewGroup.LayoutParams))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.b;
        ScrollView localScrollView = (ScrollView)findViewById(2131431334);
        if (localScrollView != null) {
          localScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localObject = (ScrollView)findViewById(2131431334);
        if (localObject != null) {
          ((ScrollView)localObject).requestLayout();
        }
      }
    }
  }
  
  private final void e()
  {
    Object localObject = (ScrollView)findViewById(2131431334);
    if (localObject != null) {
      ((ScrollView)localObject).setBackgroundColor(Color.parseColor("#F3101016"));
    }
    ((LinearLayout)findViewById(2131444357)).removeAllViews();
    int i = LayoutExKt.b(50);
    localObject = ((Iterable)this.c).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecommendProxyOuterClass.KuolieRoomInfo localKuolieRoomInfo = (RecommendProxyOuterClass.KuolieRoomInfo)((Iterator)localObject).next();
      View localView = LayoutInflater.from(this.e).inflate(2131629456, null);
      TextView localTextView = (TextView)localView.findViewById(2131435951);
      if (localTextView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localKuolieRoomInfo.room_index.get());
        localStringBuilder.append("  ");
        localStringBuilder.append(localKuolieRoomInfo.room_id.get());
        localTextView.setText((CharSequence)localStringBuilder.toString());
      }
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new GMChangeRoomOperateDialog.initViews..inlined.forEach.lambda.1(localKuolieRoomInfo, this, i));
      }
      ((LinearLayout)findViewById(2131444357)).addView(localView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, i));
    }
    findViewById(2131445743).setOnClickListener((View.OnClickListener)this);
    a(i * this.c.size());
  }
  
  @Nullable
  public final GMChangeRoomOperateDialog.ItemClickListener a()
  {
    return this.a;
  }
  
  public final void a(@Nullable GMChangeRoomOperateDialog.ItemClickListener paramItemClickListener)
  {
    this.a = paramItemClickListener;
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
    ScrollView localScrollView = (ScrollView)findViewById(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localScrollView, "contentRootView");
    return (View)localScrollView;
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if ((!NoDoubleClickUtils.a()) && (paramView.getId() == 2131445743)) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.GMChangeRoomOperateDialog
 * JD-Core Version:    0.7.0.1
 */