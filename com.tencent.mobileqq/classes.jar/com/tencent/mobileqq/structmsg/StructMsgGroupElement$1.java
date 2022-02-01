package com.tencent.mobileqq.structmsg;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class StructMsgGroupElement$1
  implements View.OnClickListener
{
  StructMsgGroupElement$1(StructMsgGroupElement paramStructMsgGroupElement) {}
  
  public void onClick(View paramView)
  {
    if (StructMsgGroupElement.a(this.a) != null) {
      try
      {
        int j = Integer.parseInt(String.valueOf(paramView.getTag()));
        int i = 0;
        while (i < this.a.au.size())
        {
          Object localObject = (View)StructMsgGroupElement.b(this.a).get(i);
          if (localObject != null) {
            if (i != j)
            {
              AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)this.a.au.get(i);
              if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgGroupItemElement))) {
                ((StructMsgGroupItemElement)localAbsStructMsgElement).c();
              } else {
                ((View)localObject).setVisibility(8);
              }
            }
            else
            {
              localObject = (AbsStructMsgElement)this.a.au.get(i);
              if ((localObject != null) && ((localObject instanceof StructMsgGroupItemElement))) {
                ((StructMsgGroupItemElement)localObject).d();
              }
            }
          }
          i += 1;
        }
        EventCollector.getInstance().onViewClicked(paramView);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupElement.1
 * JD-Core Version:    0.7.0.1
 */