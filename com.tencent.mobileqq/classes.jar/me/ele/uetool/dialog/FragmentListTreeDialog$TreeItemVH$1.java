package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import me.ele.uetool.Provider;

class FragmentListTreeDialog$TreeItemVH$1
  implements View.OnClickListener
{
  FragmentListTreeDialog$TreeItemVH$1(FragmentListTreeDialog.TreeItemVH paramTreeItemVH, FragmentListTreeDialog.TreeItem paramTreeItem) {}
  
  public void onClick(View paramView)
  {
    if (FragmentListTreeDialog.TreeItemVH.access$100(this.this$0) != null) {
      FragmentListTreeDialog.TreeItemVH.access$100(this.this$0).onClickTreeItem(this.val$value.rectF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.FragmentListTreeDialog.TreeItemVH.1
 * JD-Core Version:    0.7.0.1
 */