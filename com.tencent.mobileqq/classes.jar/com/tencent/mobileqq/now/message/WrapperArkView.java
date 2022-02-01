package com.tencent.mobileqq.now.message;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class WrapperArkView
  extends FrameLayout
{
  int a;
  MessageForArkApp b;
  ChatItemBuilder c;
  private OnArkViewTouchListener d;
  
  public WrapperArkView(@NonNull Context paramContext, ViewGroup paramViewGroup, MessageForArkApp paramMessageForArkApp, ChatItemBuilder paramChatItemBuilder, int paramInt)
  {
    super(paramContext);
    this.b = paramMessageForArkApp;
    this.c = paramChatItemBuilder;
    this.a = paramInt;
    setLayoutParams(paramViewGroup.getLayoutParams());
  }
  
  private View a(ChatMessage paramChatMessage)
  {
    return this.c.a(0, 0, paramChatMessage, null, this, this.d);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.b.arkContainer instanceof QQLiveArkContainerWrapper)) {
      ((QQLiveArkContainerWrapper)this.b.arkContainer).j();
    }
    this.b.arkContainer = new QQLiveArkContainerWrapper();
    removeAllViews();
    addView(a(this.b));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.b.arkContainer instanceof QQLiveArkContainerWrapper)) {
      ((QQLiveArkContainerWrapper)this.b.arkContainer).j();
    }
  }
  
  public void setOnArkViewTouchListener(OnArkViewTouchListener paramOnArkViewTouchListener)
  {
    this.d = paramOnArkViewTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.WrapperArkView
 * JD-Core Version:    0.7.0.1
 */