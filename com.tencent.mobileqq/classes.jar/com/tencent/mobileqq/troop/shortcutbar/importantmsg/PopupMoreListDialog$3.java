package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;

class PopupMoreListDialog$3
  extends CommonAdapter<ShortcutBarInfo>
{
  PopupMoreListDialog$3(PopupMoreListDialog paramPopupMoreListDialog, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new ShortcutBarMoreListHolder(paramContext, paramViewGroup);
    paramContext.a = ((LinearLayout)paramViewGroup.findViewById(2131445868));
    paramContext.c = ((ImageView)paramViewGroup.findViewById(2131445869));
    paramContext.b = ((URLImageView)paramViewGroup.findViewById(2131445872));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131445873));
    return paramContext;
  }
  
  protected void a(ViewHolder paramViewHolder, ShortcutBarInfo paramShortcutBarInfo, int paramInt)
  {
    PopupMoreListDialog.a(this.a, paramViewHolder, paramShortcutBarInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog.3
 * JD-Core Version:    0.7.0.1
 */