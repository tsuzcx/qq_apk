package com.tencent.mobileqq.confess;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.confess.data.TroopConfessMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopConfessItemBuilder$TroopConfessViewHolder
  extends BaseBubbleBuilder.ViewHolder
{
  private TextView a;
  private TextView b;
  private ConfessNewsBgView c;
  private TextView d;
  private View e;
  
  public void a(TroopConfessMsg paramTroopConfessMsg)
  {
    if (paramTroopConfessMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopConfessItemBuilder", 2, "TroopConfessViewHolder bindData null is troopConfessMsgItem.");
      }
      return;
    }
    if ((paramTroopConfessMsg.items != null) && (!paramTroopConfessMsg.items.isEmpty()))
    {
      this.a.setText(paramTroopConfessMsg.getConfessToNick());
      this.b.setText(((TroopConfessMsgItem)paramTroopConfessMsg.items.get(0)).topic);
      String str = ((TroopConfessMsgItem)paramTroopConfessMsg.items.get(0)).topic;
      float f = TagUtils.b(str);
      Object localObject;
      if (f > 8.0F)
      {
        this.b.setTextSize(1, 24.0F);
        this.a.setTextSize(1, 18.0F);
        this.b.setLineSpacing(0.0F, 1.1F);
        localObject = str;
        if (f <= 12.0F)
        {
          localObject = str;
          if (TagUtils.a(str))
          {
            double d1 = f;
            Double.isNaN(d1);
            int i = (int)(d1 * 0.7D);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str.substring(0, i));
            ((StringBuilder)localObject).append("\n");
            ((StringBuilder)localObject).append(str.substring(i, str.length()));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
      else
      {
        this.b.setTextSize(1, 24.0F);
        this.a.setTextSize(1, 18.0F);
        this.b.setLineSpacing(0.0F, 1.0F);
        localObject = str;
      }
      this.b.setText((CharSequence)localObject);
      if (paramTroopConfessMsg.totalCount <= 1)
      {
        this.d.setVisibility(8);
        return;
      }
      this.d.setVisibility(0);
      this.d.setText(String.format(HardCodeUtil.a(2131912545), new Object[] { Integer.valueOf(paramTroopConfessMsg.totalCount - 1) }));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopConfessItemBuilder", 2, "TroopConfessViewHolder bindData items is null or empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessItemBuilder.TroopConfessViewHolder
 * JD-Core Version:    0.7.0.1
 */