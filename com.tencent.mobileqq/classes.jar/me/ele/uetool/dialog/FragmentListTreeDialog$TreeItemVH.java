package me.ele.uetool.dialog;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.model.TreeNode.BaseNodeViewHolder;
import me.ele.uetool.Provider;
import me.ele.uetool.util.JarResource;

public class FragmentListTreeDialog$TreeItemVH
  extends TreeNode.BaseNodeViewHolder<FragmentListTreeDialog.TreeItem>
{
  private ImageView arrowView;
  private TextView nameView;
  private Provider provider;
  
  public FragmentListTreeDialog$TreeItemVH(Context paramContext, Provider paramProvider)
  {
    super(paramContext);
    this.provider = paramProvider;
  }
  
  public View createNodeView(TreeNode paramTreeNode, FragmentListTreeDialog.TreeItem paramTreeItem)
  {
    paramTreeNode = LayoutInflater.from(this.context).inflate(JarResource.getIdByName("layout", "qb_uet_cell_tree"), null, false);
    this.nameView = ((TextView)paramTreeNode.findViewById(JarResource.getIdByName("id", "name")));
    this.arrowView = ((ImageView)paramTreeNode.findViewById(JarResource.getIdByName("id", "arrow")));
    this.nameView.setText(Html.fromHtml(paramTreeItem.name));
    if (paramTreeItem.rectF != null) {
      this.nameView.setOnClickListener(new FragmentListTreeDialog.TreeItemVH.1(this, paramTreeItem));
    }
    return paramTreeNode;
  }
  
  public void toggle(boolean paramBoolean)
  {
    super.toggle(paramBoolean);
    ViewPropertyAnimator localViewPropertyAnimator = this.arrowView.animate().setDuration(200L);
    if (paramBoolean) {}
    for (float f = 90.0F;; f = 0.0F)
    {
      localViewPropertyAnimator.rotation(f).start();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.FragmentListTreeDialog.TreeItemVH
 * JD-Core Version:    0.7.0.1
 */