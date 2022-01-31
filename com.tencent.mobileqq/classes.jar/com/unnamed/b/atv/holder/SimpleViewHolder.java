package com.unnamed.b.atv.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.model.TreeNode.BaseNodeViewHolder;

public class SimpleViewHolder
  extends TreeNode.BaseNodeViewHolder<Object>
{
  public SimpleViewHolder(Context paramContext)
  {
    super(paramContext);
  }
  
  public View createNodeView(TreeNode paramTreeNode, Object paramObject)
  {
    paramTreeNode = new TextView(this.context);
    paramTreeNode.setText(String.valueOf(paramObject));
    return paramTreeNode;
  }
  
  public void toggle(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.unnamed.b.atv.holder.SimpleViewHolder
 * JD-Core Version:    0.7.0.1
 */