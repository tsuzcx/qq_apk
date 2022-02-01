package com.tencent.mobileqq.werewolves;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;

public class GameView
  extends FrameLayout
{
  GameRoomChatPie a;
  
  public GameView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GameView(Context paramContext, GameRoomChatPie paramGameRoomChatPie)
  {
    super(paramContext);
    this.a = paramGameRoomChatPie;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ((GiftPanelHelper)this.a.q(136)).e();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.GameView
 * JD-Core Version:    0.7.0.1
 */