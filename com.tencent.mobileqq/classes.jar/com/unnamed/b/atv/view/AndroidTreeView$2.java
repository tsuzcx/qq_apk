package com.unnamed.b.atv.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.model.TreeNode.TreeNodeClickListener;

class AndroidTreeView$2
  implements View.OnClickListener
{
  AndroidTreeView$2(AndroidTreeView paramAndroidTreeView, TreeNode paramTreeNode) {}
  
  public void onClick(View paramView)
  {
    if (this.val$n.getClickListener() != null) {
      this.val$n.getClickListener().onClick(this.val$n, this.val$n.getValue());
    }
    for (;;)
    {
      if (AndroidTreeView.access$100(this.this$0)) {
        this.this$0.toggleNode(this.val$n);
      }
      return;
      if (AndroidTreeView.access$000(this.this$0) != null) {
        AndroidTreeView.access$000(this.this$0).onClick(this.val$n, this.val$n.getValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.unnamed.b.atv.view.AndroidTreeView.2
 * JD-Core Version:    0.7.0.1
 */