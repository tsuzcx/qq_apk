package com.tencent.mobileqq.structmsg.view;

import aekt;
import aemk;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import azus;
import azuw;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class StructMsgItemPAAudio$3
  implements Runnable
{
  public StructMsgItemPAAudio$3(azus paramazus, View paramView, azuw paramazuw) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getParent();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      localObject2 = localObject3;
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (((ViewGroup)localObject2).getId() != 2131377085) {
          break label64;
        }
        localObject2 = (StructMsgForGeneralShare)((ViewGroup)localObject2).getTag(2131377085);
      }
    }
    if (localObject2 == null) {}
    label64:
    do
    {
      do
      {
        return;
        localObject1 = ((ViewGroup)localObject2).getParent();
        break;
        this.this$0.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject1);
      } while (this.this$0.jdField_a_of_type_AndroidViewViewGroup == null);
      localObject1 = (aemk)aekt.a(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    } while (localObject1 == null);
    long l = ((aemk)localObject1).a.uniseq;
    this.this$0.W = ((StructMsgForGeneralShare)localObject2).uin;
    this.this$0.jdField_a_of_type_Boolean = this.this$0.a(l);
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Azuw.c.setBackgroundResource(2130841463);
      return;
    }
    this.jdField_a_of_type_Azuw.c.setBackgroundResource(2130772119);
    ((AnimationDrawable)this.jdField_a_of_type_Azuw.c.getBackground()).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.3
 * JD-Core Version:    0.7.0.1
 */