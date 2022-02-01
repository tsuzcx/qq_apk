package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/TouchPositionGetableRelativeLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/component/chat/message/TouchPositionGetable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastTouchRawX", "", "lastTouchRawY", "touchPosition", "", "getTouchPosition", "()[F", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class TouchPositionGetableRelativeLayout
  extends RelativeLayout
  implements TouchPositionGetable
{
  private float a;
  private float b;
  private HashMap c;
  
  public TouchPositionGetableRelativeLayout(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchPositionGetableRelativeLayout(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchPositionGetableRelativeLayout(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(int paramInt)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    View localView2 = (View)this.c.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public float[] getTouchPosition()
  {
    return new float[] { this.a, this.b };
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.a = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TouchPositionGetableRelativeLayout
 * JD-Core Version:    0.7.0.1
 */