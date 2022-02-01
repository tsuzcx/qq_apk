package com.tencent.mobileqq.flashshow.list.blocks;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.widget.BaseWidgetView;

public class FSBaseListBlock$BaseListVH
  extends RecyclerView.ViewHolder
{
  public FSBaseListBlock$BaseListVH(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      this.itemView.setTag(this);
      ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.blocks.FSBaseListBlock.BaseListVH
 * JD-Core Version:    0.7.0.1
 */