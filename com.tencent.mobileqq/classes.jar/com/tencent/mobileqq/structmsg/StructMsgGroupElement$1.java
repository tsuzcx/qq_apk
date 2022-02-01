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
    if (StructMsgGroupElement.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = Integer.parseInt(String.valueOf(paramView.getTag()));
        i = 0;
        if (i >= this.a.a.size()) {
          break;
        }
        View localView = (View)StructMsgGroupElement.a(this.a).get(i);
        if (localView == null) {
          break label174;
        }
        if (i == j) {
          break label135;
        }
        AbsStructMsgElement localAbsStructMsgElement2 = (AbsStructMsgElement)this.a.a.get(i);
        if ((localAbsStructMsgElement2 != null) && ((localAbsStructMsgElement2 instanceof StructMsgGroupItemElement))) {
          ((StructMsgGroupItemElement)localAbsStructMsgElement2).a();
        } else {
          localView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      label135:
      AbsStructMsgElement localAbsStructMsgElement1 = (AbsStructMsgElement)this.a.a.get(i);
      if ((localAbsStructMsgElement1 != null) && ((localAbsStructMsgElement1 instanceof StructMsgGroupItemElement))) {
        ((StructMsgGroupItemElement)localAbsStructMsgElement1).b();
      }
      label174:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupElement.1
 * JD-Core Version:    0.7.0.1
 */