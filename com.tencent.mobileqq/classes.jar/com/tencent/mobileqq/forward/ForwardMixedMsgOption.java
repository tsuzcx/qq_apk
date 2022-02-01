package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import aufz;
import auhp;
import awmg;
import bdnt;
import bgtn;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ForwardMixedMsgOption
  extends aufz
{
  public MessageForMixedMsg a;
  
  public ForwardMixedMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public View a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    localLinearLayout.setOrientation(0);
    Object localObject2 = new AnimationTextView(this.jdField_a_of_type_AndroidAppActivity);
    ((AnimationTextView)localObject2).setText(new bdnt(a(), 5, 16));
    ((AnimationTextView)localObject2).setMaxLines(2);
    ((AnimationTextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((AnimationTextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165687));
    ((AnimationTextView)localObject2).setTextSize(14.0F);
    Object localObject1 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject1).setImageResource(2130840115);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.gravity = 17;
    localLinearLayout.addView((View)localObject2, localLayoutParams);
    localObject2 = new LinearLayout.LayoutParams(bgtn.a(8.0F), bgtn.a(14.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    ((LinearLayout.LayoutParams)localObject2).setMargins(bgtn.a(3.0F), 0, 0, 0);
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject1 = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject1).setBackgroundResource(2130840125);
    ((View)localObject1).setOnClickListener(new auhp(this));
    localObject2 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    int i = bgtn.a(20.0F);
    ((FrameLayout)localObject2).setPadding(0, i, 0, i);
    ((FrameLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject2).addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -2));
    return localObject2;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg != null)
    {
      MessageForMixedMsg localMessageForMixedMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
      return MessageForMixedMsg.getTextFromMixedMsgForForwardPreview(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
    }
    return super.a();
  }
  
  public void a()
  {
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (n()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean a()
  {
    super.a();
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("FORWARD_MSG_UNISEQ", -1L);
    Object localObject;
    if (l != -1L)
    {
      localObject = (ChatMessage)((awmg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a.get(Long.valueOf(l));
      if (localObject == null) {
        break label176;
      }
      if (!(localObject instanceof MessageForMixedMsg)) {
        break label88;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "MessageForMixedMsg");
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg = ((MessageForMixedMsg)localObject);
    }
    label176:
    for (;;)
    {
      return true;
      label88:
      if ((localObject instanceof MessageForLongMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "MessageForLongMsg");
        }
        localObject = (MessageForLongMsg)localObject;
        try
        {
          localObject = ((MessageForLongMsg)localObject).rebuildLongMsg();
          if (!(localObject instanceof MessageForMixedMsg)) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg = ((MessageForMixedMsg)localObject);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "rebuildLongMsg error :" + localException.toString());
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg: " + l);
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean i()
  {
    return true;
  }
  
  public void j()
  {
    super.j();
    AbstractGifImage.pauseAll();
  }
  
  public void k()
  {
    super.k();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMixedMsgOption
 * JD-Core Version:    0.7.0.1
 */