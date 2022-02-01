package com.tencent.mobileqq.structmsg.view;

import agej;
import aghd;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import bdsy;
import bdtc;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class StructMsgItemPAAudio$3
  implements Runnable
{
  public StructMsgItemPAAudio$3(bdsy parambdsy, View paramView, bdtc parambdtc) {}
  
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
        if (((ViewGroup)localObject2).getId() != 2131378101) {
          break label64;
        }
        localObject2 = (StructMsgForGeneralShare)((ViewGroup)localObject2).getTag(2131378101);
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
      localObject1 = (aghd)agej.a(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    } while (localObject1 == null);
    long l = ((aghd)localObject1).a.uniseq;
    this.this$0.ag = ((StructMsgForGeneralShare)localObject2).uin;
    this.this$0.jdField_a_of_type_Boolean = this.this$0.a(l);
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bdtc.c.setBackgroundResource(2130841785);
      return;
    }
    this.jdField_a_of_type_Bdtc.c.setBackgroundResource(2130772123);
    ((AnimationDrawable)this.jdField_a_of_type_Bdtc.c.getBackground()).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.3
 * JD-Core Version:    0.7.0.1
 */