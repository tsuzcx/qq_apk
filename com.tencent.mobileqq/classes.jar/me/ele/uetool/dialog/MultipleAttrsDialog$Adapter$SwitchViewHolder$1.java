package me.ele.uetool.dialog;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;
import me.ele.uetool.base.item.SwitchItem;

class MultipleAttrsDialog$Adapter$SwitchViewHolder$1
  implements CompoundButton.OnCheckedChangeListener
{
  MultipleAttrsDialog$Adapter$SwitchViewHolder$1(MultipleAttrsDialog.Adapter.SwitchViewHolder paramSwitchViewHolder, View paramView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    try
    {
      if ((((SwitchItem)this.this$0.item).getType() == 0) && (((SwitchItem)this.this$0.item).getCallBack() != null) && (paramBoolean))
      {
        if ((((SwitchItem)this.this$0.item).getName().equals("背景色板")) || (((SwitchItem)this.this$0.item).getName().equals("文字颜色"))) {
          ((SwitchItem)this.this$0.item).getCallBack().callBack(((SwitchItem)this.this$0.item).getElement(), new MultipleAttrsDialog.Adapter.SwitchViewHolder.1.1(this));
        }
        for (;;)
        {
          MultipleAttrsDialog.Adapter.SwitchViewHolder.access$600(this.this$0).setChecked(false);
          return;
          ((SwitchItem)this.this$0.item).getCallBack().callBack(((SwitchItem)this.this$0.item).getElement(), null);
        }
      }
      if (((SwitchItem)this.this$0.item).getType() != 3) {
        break label232;
      }
    }
    catch (Exception paramCompoundButton)
    {
      paramCompoundButton.printStackTrace();
      return;
    }
    ((SwitchItem)this.this$0.item).setChecked(paramBoolean);
    if (MultipleAttrsDialog.Adapter.SwitchViewHolder.access$700(this.this$0) != null)
    {
      MultipleAttrsDialog.Adapter.SwitchViewHolder.access$700(this.this$0).validView(this.this$0.getAdapterPosition(), paramBoolean);
      return;
      label232:
      paramCompoundButton = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (paramCompoundButton.hasNext())
      {
        Object localObject = (Element)paramCompoundButton.next();
        if ((((Element)localObject).getView() instanceof TextView))
        {
          localObject = (TextView)((Element)localObject).getView();
          if (((SwitchItem)this.this$0.item).getType() == 1)
          {
            if (paramBoolean) {}
            for (int i = 1;; i = 0)
            {
              ((TextView)localObject).setTypeface(null, i);
              break;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.SwitchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */