package com.tencent.timi.game.liveroom.impl.profile.operate;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.SimpleSlideUpDialog;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog;", "Lcom/tencent/timi/game/ui/widget/SimpleSlideUpDialog;", "Landroid/view/View$OnClickListener;", "type", "", "dataList", "", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "context", "Landroid/content/Context;", "blurBackgroundView", "Landroid/view/View;", "(ILjava/util/List;Landroid/content/Context;Landroid/view/View;)V", "itemClickListener", "Lcom/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog$ItemClickListener;", "getItemClickListener", "()Lcom/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog$ItemClickListener;", "setItemClickListener", "(Lcom/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog$ItemClickListener;)V", "contentView", "initViews", "", "onClick", "v", "onDetachedFromWindow", "shadowBgView", "ItemClickListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileOperateDialog
  extends SimpleSlideUpDialog
  implements View.OnClickListener
{
  @Nullable
  private ProfileOperateDialog.ItemClickListener a;
  private final int b;
  private final List<AdminReason> c;
  private final View d;
  
  public ProfileOperateDialog(int paramInt, @NotNull List<? extends AdminReason> paramList, @NotNull Context paramContext, @Nullable View paramView)
  {
    super(paramContext);
    this.b = paramInt;
    this.c = paramList;
    this.d = paramView;
    setContentView(2131629455);
    e();
  }
  
  private final void e()
  {
    Object localObject1 = (RelativeLayout)findViewById(2131431334);
    if (localObject1 != null) {
      ((RelativeLayout)localObject1).setBackgroundColor(Color.parseColor("#F3101016"));
    }
    ((LinearLayout)findViewById(2131444357)).removeAllViews();
    localObject1 = (LinearLayout)findViewById(2131444357);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "reasonLinear");
    localObject1 = ((LinearLayout)localObject1).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "reasonLinear.context");
    int i = (int)((Context)localObject1).getResources().getDimension(2131299896);
    localObject1 = ((Iterable)this.c).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AdminReason)((Iterator)localObject1).next();
      View localView = LayoutInflater.from(this.e).inflate(2131629456, null);
      TextView localTextView = (TextView)localView.findViewById(2131435951);
      if (localTextView != null) {
        localTextView.setText((CharSequence)((AdminReason)localObject2).desc);
      }
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new ProfileOperateDialog.initViews..inlined.forEach.lambda.1((AdminReason)localObject2, this, i));
      }
      ((LinearLayout)findViewById(2131444357)).addView(localView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, i));
    }
    localObject1 = (TextView)findViewById(2131430274);
    Object localObject2 = (View.OnClickListener)this;
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    findViewById(2131445743).setOnClickListener((View.OnClickListener)localObject2);
  }
  
  @Nullable
  public final ProfileOperateDialog.ItemClickListener a()
  {
    return this.a;
  }
  
  public final void a(@Nullable ProfileOperateDialog.ItemClickListener paramItemClickListener)
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
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "contentRootView");
    return (View)localRelativeLayout;
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (!NoDoubleClickUtils.a())
    {
      int i = paramView.getId();
      if ((i == 2131445743) || (i == 2131430274)) {
        dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.operate.ProfileOperateDialog
 * JD-Core Version:    0.7.0.1
 */