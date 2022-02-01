package com.tencent.timi.game.component.chat.message;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.ui.utils.ResUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disableIcons", "", "disableTextColor", "eventReceiver", "com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$eventReceiver$1", "Lcom/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$eventReceiver$1;", "flDrawalbe", "Landroid/graphics/drawable/GradientDrawable;", "normalIcons", "normalTextColor", "roadDescTvs", "", "Landroid/widget/TextView;", "roadDescs", "", "roadFls", "Landroid/widget/FrameLayout;", "roadIDs", "roadIconIvs", "Landroid/widget/ImageView;", "selectedIcons", "selectedTextColor", "colorAnim", "", "roadIv", "fromColor", "toColor", "colorBgAnim", "drawable", "onAttachedToWindow", "onDetachedFromWindow", "renderUI", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "textColorAnim", "roadTv", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaLoadSelectItemView
  extends BaseMessageView
{
  private final List<FrameLayout> a = (List)new ArrayList();
  private final List<ImageView> b = (List)new ArrayList();
  private final List<TextView> c = (List)new ArrayList();
  private final List<String> d;
  private final List<Integer> e;
  private final List<Integer> f;
  private final List<Integer> g;
  private final List<Integer> h;
  private final int i;
  private final int j;
  private final int k;
  private GradientDrawable l;
  private final SmobaLoadSelectItemView.eventReceiver.1 m;
  private HashMap n;
  
  @JvmOverloads
  public SmobaLoadSelectItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SmobaLoadSelectItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SmobaLoadSelectItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i1 = 0;
    this.d = CollectionsKt.listOf(new String[] { "发育路", "对抗路", "中路", "打野", "游走" });
    this.e = CollectionsKt.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5) });
    this.f = CollectionsKt.listOf(new Integer[] { Integer.valueOf(2130853010), Integer.valueOf(2130853007), Integer.valueOf(2130853016), Integer.valueOf(2130853004), Integer.valueOf(2130853013) });
    this.g = CollectionsKt.listOf(new Integer[] { Integer.valueOf(2130853011), Integer.valueOf(2130853008), Integer.valueOf(2130853017), Integer.valueOf(2130853005), Integer.valueOf(2130853014) });
    this.h = CollectionsKt.listOf(new Integer[] { Integer.valueOf(2130853012), Integer.valueOf(2130853009), Integer.valueOf(2130853018), Integer.valueOf(2130853006), Integer.valueOf(2130853015) });
    this.i = ResUtils.b(2131165564);
    this.j = ResUtils.b(2131168464);
    this.k = Color.parseColor("#A2A4A9");
    this.m = new SmobaLoadSelectItemView.eventReceiver.1(this);
    setContentView(2131629484);
    paramContext = (FrameLayout)a(2131445138);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "rootContainer");
    this.l = ViewExKt.a((View)paramContext, LayoutExKt.b(4), new int[] { Color.parseColor("#F5A300") });
    paramContext = (FrameLayout)a(2131445138);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "rootContainer");
    ViewExKt.a((View)paramContext, LayoutExKt.b(15), new int[] { ResUtils.b(2131168464) });
    paramInt = 0;
    while (paramInt <= 4)
    {
      paramContext = (LinearLayout)a(2131437608);
      paramAttributeSet = new FrameLayout(getContext());
      this.a.add(paramAttributeSet);
      Object localObject1 = (ViewGroup)paramAttributeSet;
      Object localObject2 = new ImageView(((ViewGroup)localObject1).getContext());
      this.b.add(localObject2);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      localObject2 = (View)localObject2;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(LayoutExKt.b(28), LayoutExKt.b(28));
      localLayoutParams.topMargin = LayoutExKt.b(7);
      localLayoutParams.gravity = 1;
      paramAttributeSet.addView((View)localObject2, (ViewGroup.LayoutParams)localLayoutParams);
      localObject1 = new TextView(((ViewGroup)localObject1).getContext());
      this.c.add(localObject1);
      LayoutExKt.a((TextView)localObject1, 10.0F);
      localObject2 = (View)localObject1;
      localObject1 = (View)paramAttributeSet;
      localLayoutParams = new FrameLayout.LayoutParams(LayoutExKt.a((View)localObject1), LayoutExKt.a((View)localObject1));
      localLayoutParams.topMargin = LayoutExKt.b(38);
      localLayoutParams.gravity = 1;
      paramAttributeSet.addView((View)localObject2, (ViewGroup.LayoutParams)localLayoutParams);
      Intrinsics.checkExpressionValueIsNotNull((LinearLayout)a(2131437608), "loadContainer");
      paramAttributeSet = new LinearLayout.LayoutParams(LayoutExKt.b(48), LayoutExKt.b(60));
      paramAttributeSet.weight = 1.0F;
      paramContext.addView((View)localObject1, (ViewGroup.LayoutParams)paramAttributeSet);
      paramInt += 1;
    }
    paramContext = ((Iterable)this.c).iterator();
    paramInt = i1;
    while (paramContext.hasNext())
    {
      paramAttributeSet = paramContext.next();
      if (paramInt < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      ((TextView)paramAttributeSet).setText((CharSequence)this.d.get(paramInt));
      paramInt += 1;
    }
  }
  
  private final void a(GradientDrawable paramGradientDrawable, int paramInt1, int paramInt2)
  {
    paramGradientDrawable = ObjectAnimator.ofInt(paramGradientDrawable, "color", new int[] { paramInt1, paramInt2 });
    paramGradientDrawable.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    paramGradientDrawable.setDuration(80L).start();
  }
  
  private final void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    paramImageView = ObjectAnimator.ofInt(paramImageView, "colorFilter", new int[] { paramInt1, paramInt2 });
    paramImageView.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    paramImageView.setDuration(80L).start();
  }
  
  private final void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView = ObjectAnimator.ofInt(paramTextView, "textColor", new int[] { paramInt1, paramInt2 });
    paramTextView.setEvaluator((TypeEvaluator)new ArgbEvaluator());
    paramTextView.setDuration(80L).start();
  }
  
  public View a(int paramInt)
  {
    if (this.n == null) {
      this.n = new HashMap();
    }
    View localView2 = (View)this.n.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.n.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.b(paramIMsg);
    int i4 = paramIMsg.m();
    int i3 = 0;
    int i2 = 0;
    int i1;
    Object localObject1;
    Object localObject2;
    if ((1 <= i4) && (5 >= i4))
    {
      paramIMsg = ((Iterable)this.a).iterator();
      i1 = 0;
      while (paramIMsg.hasNext())
      {
        localObject1 = paramIMsg.next();
        if (i1 < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject1 = (FrameLayout)localObject1;
        ((FrameLayout)localObject1).setClickable(false);
        if (i1 == i4 - 1) {
          ((FrameLayout)localObject1).setBackgroundDrawable((Drawable)this.l);
        } else {
          ((FrameLayout)localObject1).setBackgroundDrawable(null);
        }
        i1 += 1;
      }
      localObject1 = ((Iterable)this.b).iterator();
      i1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramIMsg = ((Iterator)localObject1).next();
        if (i1 < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject2 = (ImageView)paramIMsg;
        if (i1 == i4 - 1) {
          paramIMsg = this.h;
        } else {
          paramIMsg = this.f;
        }
        ((ImageView)localObject2).setImageResource(((Number)paramIMsg.get(i1)).intValue());
        i1 += 1;
      }
      paramIMsg = ((Iterable)this.c).iterator();
      i1 = i2;
    }
    while (paramIMsg.hasNext())
    {
      localObject1 = paramIMsg.next();
      if (i1 < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject1 = (TextView)localObject1;
      if (i1 == i4 - 1) {
        i2 = this.j;
      } else {
        i2 = this.k;
      }
      ((TextView)localObject1).setTextColor(i2);
      i1 += 1;
      continue;
      localObject1 = ((Iterable)this.a).iterator();
      i1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i1 < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject2 = (FrameLayout)localObject2;
        Object localObject3 = getRoomInfo();
        if (localObject3 != null)
        {
          IReportService localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
          View localView = (View)localObject2;
          String str = paramIMsg.a();
          localObject3 = YoloRoomUtil.c((YoloRoomOuterClass.YoloRoomInfo)localObject3);
          ((ConcurrentHashMap)localObject3).put("yes_user_branch", String.valueOf(((Number)this.e.get(i1)).intValue()));
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "YoloRoomUtil.getCommonRo…                        }");
          IReportService.DefaultImpls.a(localIReportService, localView, false, str, "em_yes_chat_branch_choose", (Map)localObject3, 2, null);
        }
        ((FrameLayout)localObject2).setBackgroundDrawable(null);
        ((FrameLayout)localObject2).setOnClickListener((View.OnClickListener)new SmobaLoadSelectItemView.renderUI..inlined.forEachIndexed.lambda.1(i1, (FrameLayout)localObject2, this, paramIMsg, i4));
        boolean bool;
        if (i4 >= 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((FrameLayout)localObject2).setClickable(bool);
        i1 += 1;
      }
      localObject1 = ((Iterable)this.b).iterator();
      i1 = i3;
      while (((Iterator)localObject1).hasNext())
      {
        paramIMsg = ((Iterator)localObject1).next();
        if (i1 < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject2 = (ImageView)paramIMsg;
        if (i4 < 0) {
          paramIMsg = this.f;
        } else {
          paramIMsg = this.g;
        }
        ((ImageView)localObject2).setImageResource(((Number)paramIMsg.get(i1)).intValue());
        i1 += 1;
      }
      paramIMsg = ((Iterable)this.c).iterator();
      while (paramIMsg.hasNext())
      {
        localObject1 = (TextView)paramIMsg.next();
        if (i4 < 0) {
          i1 = this.k;
        } else {
          i1 = this.i;
        }
        ((TextView)localObject1).setTextColor(i1);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this.m);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaLoadSelectItemView
 * JD-Core Version:    0.7.0.1
 */