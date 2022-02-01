package com.tencent.timi.game.gift.impl.timi;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/ReceiverSelectorView;", "Landroid/widget/RelativeLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "certainReceiverNameTv", "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "attachAdapter", "", "receiverAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setCertainReceiverName", "receiverName", "", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "setCertainReceiverNameVisibility", "visible", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ReceiverSelectorView
  extends RelativeLayout
{
  private RecyclerView a;
  private AvatarTextView b;
  
  @JvmOverloads
  public ReceiverSelectorView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ReceiverSelectorView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ReceiverSelectorView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new TextView(getContext());
    paramContext.setId(2131444370);
    paramContext.setText((CharSequence)ResUtils.c(2131887790));
    paramContext.setTextColor(Color.parseColor("#66FFFFFF"));
    paramContext.setTextSize(1, 12.0F);
    paramContext = (View)paramContext;
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(15);
    paramAttributeSet.leftMargin = LayoutExKt.b(16);
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    RecyclerView localRecyclerView = new RecyclerView(getContext());
    localRecyclerView.setId(2131444371);
    paramAttributeSet = localRecyclerView.getItemAnimator();
    paramContext = paramAttributeSet;
    if (!(paramAttributeSet instanceof SimpleItemAnimator)) {
      paramContext = null;
    }
    paramContext = (SimpleItemAnimator)paramContext;
    if (paramContext != null) {
      paramContext.setSupportsChangeAnimations(false);
    }
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(localRecyclerView.getContext(), 0, false));
    this.a = localRecyclerView;
    paramContext = (View)localRecyclerView;
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, LayoutExKt.b(58));
    paramAttributeSet.addRule(1, 2131444370);
    paramAttributeSet.addRule(15);
    paramAttributeSet.leftMargin = LayoutExKt.b(10);
    paramAttributeSet.rightMargin = LayoutExKt.b(10);
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new AvatarTextView(getContext());
    paramContext.setId(2131444368);
    this.b = paramContext;
    paramContext.setTextColor(Color.parseColor("#FFFFFF"));
    paramContext.setTextSize(1, 12.0F);
    paramContext = (View)paramContext;
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(5, 2131444371);
    paramAttributeSet.addRule(15);
    paramAttributeSet.leftMargin = LayoutExKt.b(44);
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
  }
  
  public final void a(@NotNull RecyclerView.Adapter<?> paramAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramAdapter, "receiverAdapter");
    RecyclerView localRecyclerView = this.a;
    if (localRecyclerView != null) {
      localRecyclerView.setAdapter(paramAdapter);
    }
  }
  
  public final void setCertainReceiverName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "receiverName");
    AvatarTextView localAvatarTextView = this.b;
    if (localAvatarTextView != null) {
      localAvatarTextView.e();
    }
    localAvatarTextView = this.b;
    if (localAvatarTextView != null) {
      localAvatarTextView.setText((CharSequence)paramString);
    }
  }
  
  public final void setCertainReceiverName(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    AvatarTextView localAvatarTextView = this.b;
    if (localAvatarTextView != null) {
      localAvatarTextView.setUserId(paramQQUserId);
    }
  }
  
  public final void setCertainReceiverNameVisibility(boolean paramBoolean)
  {
    AvatarTextView localAvatarTextView = this.b;
    if (localAvatarTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localAvatarTextView.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.ReceiverSelectorView
 * JD-Core Version:    0.7.0.1
 */