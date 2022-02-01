package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ForwardMixedMsgOption
  extends ForwardBaseOption
{
  protected MessageForMixedMsg a;
  
  public ForwardMixedMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected View a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.s);
    localLinearLayout.setOrientation(0);
    Object localObject1 = new AnimationTextView(this.s);
    ((AnimationTextView)localObject1).setText(new QQText(n(), 5, 16));
    ((AnimationTextView)localObject1).setMaxLines(2);
    ((AnimationTextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((AnimationTextView)localObject1).setTextColor(this.s.getResources().getColorStateList(2131166157));
    ((AnimationTextView)localObject1).setTextSize(14.0F);
    Object localObject2 = new ImageView(this.s);
    ((ImageView)localObject2).setImageResource(2130840437);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.gravity = 17;
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0F), ViewUtils.dip2px(14.0F));
    localLayoutParams.gravity = 17;
    localLayoutParams.setMargins(ViewUtils.dip2px(3.0F), 0, 0, 0);
    SimpleModeHelper.a((TextView)localObject1, (ImageView)localObject2, localLayoutParams);
    localLinearLayout.addView((View)localObject2, localLayoutParams);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject1 = new View(this.s);
    ((View)localObject1).setBackgroundResource(2130840448);
    ((View)localObject1).setOnClickListener(new ForwardMixedMsgOption.1(this));
    localObject2 = new FrameLayout(this.s);
    int i = ViewUtils.dip2px(20.0F);
    ((FrameLayout)localObject2).setPadding(0, i, 0, i);
    ((FrameLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject2).addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -2));
    return localObject2;
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
  }
  
  public boolean e()
  {
    super.e();
    long l = this.t.getLong("FORWARD_MSG_UNISEQ", -1L);
    if (l != -1L)
    {
      Object localObject = (ChatMessage)((MixedMsgManager)this.q.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a.get(Long.valueOf(l));
      if (localObject != null)
      {
        if ((localObject instanceof MessageForMixedMsg))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "MessageForMixedMsg");
          }
          this.a = ((MessageForMixedMsg)localObject);
        }
        else if ((localObject instanceof MessageForLongMsg))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "MessageForLongMsg");
          }
          localObject = (MessageForLongMsg)localObject;
          try
          {
            localObject = ((MessageForLongMsg)localObject).rebuildLongMsg();
            if (!(localObject instanceof MessageForMixedMsg)) {
              break label226;
            }
            this.a = ((MessageForMixedMsg)localObject);
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label226;
            }
          }
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("rebuildLongMsg error :");
          localStringBuilder2.append(localException.toString());
          QLog.e("ForwardOption.ForwardMixedMsgOption", 2, localStringBuilder2.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("no msg: ");
        localStringBuilder1.append(l);
        QLog.e("ForwardOption.ForwardMixedMsgOption", 2, localStringBuilder1.toString());
      }
    }
    label226:
    return true;
  }
  
  public void i()
  {
    super.i();
    AbstractGifImage.resumeAll();
  }
  
  public void j()
  {
    super.j();
    AbstractGifImage.pauseAll();
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public boolean l()
  {
    return true;
  }
  
  public String n()
  {
    MessageForMixedMsg localMessageForMixedMsg = this.a;
    if (localMessageForMixedMsg != null) {
      return MessageForMixedMsg.getTextFromMixedMsgForForwardPreview(localMessageForMixedMsg);
    }
    return super.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMixedMsgOption
 * JD-Core Version:    0.7.0.1
 */