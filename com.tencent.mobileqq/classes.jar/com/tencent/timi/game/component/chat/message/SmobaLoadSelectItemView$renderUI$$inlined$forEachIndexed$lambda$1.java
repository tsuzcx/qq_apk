package com.tencent.timi.game.component.chat.message;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.team.impl.event.ChooseLaneEvent;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.utils.ThreadPool;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$renderUI$4$2"}, k=3, mv={1, 1, 16})
final class SmobaLoadSelectItemView$renderUI$$inlined$forEachIndexed$lambda$1
  implements View.OnClickListener
{
  SmobaLoadSelectItemView$renderUI$$inlined$forEachIndexed$lambda$1(int paramInt1, FrameLayout paramFrameLayout, SmobaLoadSelectItemView paramSmobaLoadSelectItemView, IMsg paramIMsg, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = this.c.getRoomInfo();
    if (localYoloRoomInfo != null)
    {
      Object localObject1 = ((Iterable)SmobaLoadSelectItemView.a(this.c)).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((FrameLayout)((Iterator)localObject1).next()).setClickable(false);
      }
      localObject1 = new int[2];
      Object tmp65_63 = localObject1;
      tmp65_63[0] = 0;
      Object tmp69_65 = tmp65_63;
      tmp69_65[1] = 0;
      tmp69_65;
      ((ImageView)SmobaLoadSelectItemView.b(this.c).get(this.a)).getLocationOnScreen((int[])tmp69_65);
      this.b.setBackgroundDrawable((Drawable)SmobaLoadSelectItemView.c(this.c));
      Object localObject2 = ((Iterable)SmobaLoadSelectItemView.b(this.c)).iterator();
      int i = 0;
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject3 = (ImageView)localObject3;
        if (i != this.a)
        {
          SmobaLoadSelectItemView.a(this.c, (ImageView)localObject3, Color.parseColor("#F5A300"), Color.parseColor("#CCCCCC"));
        }
        else
        {
          SmobaLoadSelectItemView localSmobaLoadSelectItemView = this.c;
          SmobaLoadSelectItemView.a(localSmobaLoadSelectItemView, SmobaLoadSelectItemView.c(localSmobaLoadSelectItemView), Color.parseColor("#FFFFFF"), Color.parseColor("#F5A300"));
          SmobaLoadSelectItemView.a(this.c, (ImageView)localObject3, Color.parseColor("#F5A300"), Color.parseColor("#FFFFFF"));
        }
        i += 1;
      }
      localObject2 = ((Iterable)SmobaLoadSelectItemView.d(this.c)).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject3 = (TextView)localObject3;
        if (i == this.a) {
          SmobaLoadSelectItemView.a(this.c, (TextView)localObject3, Color.parseColor("#000000"), Color.parseColor("#FFFFFF"));
        } else {
          SmobaLoadSelectItemView.a(this.c, (TextView)localObject3, Color.parseColor("#000000"), Color.parseColor("#A2A4A9"));
        }
        i += 1;
      }
      i = LayoutExKt.b(20);
      int j = LayoutExKt.b(250);
      int k = tmp69_65[0];
      int m = tmp69_65[1];
      double d1 = 400L;
      double d2 = i - k;
      Double.isNaN(d2);
      Double.isNaN(d2);
      i = j - m;
      double d3 = i * i;
      Double.isNaN(d3);
      d2 = Math.sqrt(d2 * d2 + d3);
      d3 = 300;
      Double.isNaN(d3);
      double d4 = LayoutExKt.b(200);
      Double.isNaN(d4);
      d2 = d2 * d3 / d4;
      Double.isNaN(d1);
      localObject2 = SimpleEventBus.getInstance();
      i = ((Number)SmobaLoadSelectItemView.e(this.c).get(this.a)).intValue();
      j = ((Number)SmobaLoadSelectItemView.f(this.c).get(this.a)).intValue();
      k = tmp69_65[0];
      m = tmp69_65[1];
      long l = (d1 + d2);
      ((SimpleEventBus)localObject2).dispatchEvent((SimpleBaseEvent)new ChooseLaneEvent(i, j, k, m, l));
      ThreadPool.a((Runnable)new SmobaLoadSelectItemView.renderUI..inlined.forEachIndexed.lambda.1.1(tmp65_63, this), l - 100);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaLoadSelectItemView.renderUI..inlined.forEachIndexed.lambda.1
 * JD-Core Version:    0.7.0.1
 */