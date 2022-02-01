package com.unnamed.b.atv.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.model.TreeNode.TreeNodeLongClickListener;

class AndroidTreeView$3
  implements View.OnLongClickListener
{
  AndroidTreeView$3(AndroidTreeView paramAndroidTreeView, TreeNode paramTreeNode) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.val$n.getLongClickListener() != null) {
      return this.val$n.getLongClickListener().onLongClick(this.val$n, this.val$n.getValue());
    }
    if (AndroidTreeView.access$200(this.this$0) != null) {
      return AndroidTreeView.access$200(this.this$0).onLongClick(this.val$n, this.val$n.getValue());
    }
    if (AndroidTreeView.access$100(this.this$0)) {
      this.this$0.toggleNode(this.val$n);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.unnamed.b.atv.view.AndroidTreeView.3
 * JD-Core Version:    0.7.0.1
 */