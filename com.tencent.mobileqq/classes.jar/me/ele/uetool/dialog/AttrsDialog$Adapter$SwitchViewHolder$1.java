package me.ele.uetool.dialog;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import me.ele.uetool.TransparentActivity;
import me.ele.uetool.UETCore;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;
import me.ele.uetool.base.item.SwitchItem;

class AttrsDialog$Adapter$SwitchViewHolder$1
  implements CompoundButton.OnCheckedChangeListener
{
  AttrsDialog$Adapter$SwitchViewHolder$1(AttrsDialog.Adapter.SwitchViewHolder paramSwitchViewHolder, View paramView, AttrsDialog.AttrDialogCallback paramAttrDialogCallback) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    try
    {
      if ((((SwitchItem)this.this$0.item).getType() == 0) && (((SwitchItem)this.this$0.item).getCallBack() != null) && (paramBoolean))
      {
        if ((((SwitchItem)this.this$0.item).getName().equals("背景色板")) || (((SwitchItem)this.this$0.item).getName().equals("字体颜色"))) {
          ((SwitchItem)this.this$0.item).getCallBack().callBack(((SwitchItem)this.this$0.item).getElement(), new AttrsDialog.Adapter.SwitchViewHolder.1.1(this));
        }
        for (;;)
        {
          AttrsDialog.Adapter.SwitchViewHolder.access$300(this.this$0).setChecked(false);
          return;
          ((SwitchItem)this.this$0.item).getCallBack().callBack(((SwitchItem)this.this$0.item).getElement(), null);
        }
      }
      label475:
      int i;
      label669:
      return;
    }
    catch (Exception paramCompoundButton)
    {
      paramCompoundButton.printStackTrace();
      do
      {
        if (AttrsDialog.access$100() == null) {
          return;
        }
        AttrsDialog.access$100().refresh();
        return;
        if ((((SwitchItem)this.this$0.item).getType() == 0) && (((SwitchItem)this.this$0.item).getCallBack() == null) && (((SwitchItem)this.this$0.item).getName().equals("开发者属性")))
        {
          UETCore.setDevFlag(paramBoolean);
          ((AttrsDialog.Adapter)((RecyclerView)this.val$itemView.getParent()).getAdapter()).notifyDataSetChanged(((SwitchItem)this.this$0.item).getElement());
          return;
        }
        if ((((SwitchItem)this.this$0.item).getType() == 5) && (paramBoolean))
        {
          paramCompoundButton = (TransparentActivity)AttrsDialog.access$400();
          paramCompoundButton.changeHierarchyView(((SwitchItem)this.this$0.item).getElement().getView());
          paramCompoundButton.dismissAttrsDialog();
        }
        if (((SwitchItem)this.this$0.item).getType() == 2)
        {
          if ((this.val$callback == null) || (!paramBoolean)) {
            return;
          }
          this.val$callback.enableMove();
          return;
        }
        if (((SwitchItem)this.this$0.item).getType() == 3)
        {
          ((SwitchItem)this.this$0.item).setChecked(paramBoolean);
          if (this.val$callback == null) {
            return;
          }
          this.val$callback.showValidViews(this.this$0.getAdapterPosition(), paramBoolean);
          return;
        }
        if (((SwitchItem)this.this$0.item).getType() != 4) {
          break;
        }
        ((SwitchItem)this.this$0.item).setChecked(paramBoolean);
        if (this.val$callback != null) {
          this.val$callback.showReason(this.this$0.getAdapterPosition(), paramBoolean);
        }
        if (!(((SwitchItem)this.this$0.item).getElement().getView() instanceof TextView)) {
          break label669;
        }
        paramCompoundButton = (TextView)((SwitchItem)this.this$0.item).getElement().getView();
      } while (((SwitchItem)this.this$0.item).getType() != 1);
      if (paramBoolean) {}
      for (i = 1;; i = 0)
      {
        paramCompoundButton.setTypeface(null, i);
        break;
        if (((SwitchItem)this.this$0.item).getType() == 6)
        {
          if (this.val$callback == null) {
            break label475;
          }
          this.val$callback.selectMultipleView();
          break label475;
        }
        if (((SwitchItem)this.this$0.item).getType() != 7) {
          break label475;
        }
        ((SwitchItem)this.this$0.item).setChecked(paramBoolean);
        if (paramBoolean)
        {
          ((SwitchItem)this.this$0.item).getElement().getView().setVisibility(4);
          break label475;
        }
        ((SwitchItem)this.this$0.item).getElement().getView().setVisibility(0);
        break label475;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.SwitchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */