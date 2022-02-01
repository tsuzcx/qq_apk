package com.unnamed.b.atv.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.unnamed.b.atv.view.AndroidTreeView;
import com.unnamed.b.atv.view.TreeNodeWrapperView;
import me.ele.uetool.util.JarResource;

public abstract class TreeNode$BaseNodeViewHolder<E>
{
  protected int containerStyle;
  protected Context context;
  protected TreeNode mNode;
  private View mView;
  protected AndroidTreeView tView;
  
  public TreeNode$BaseNodeViewHolder(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public abstract View createNodeView(TreeNode paramTreeNode, E paramE);
  
  public int getContainerStyle()
  {
    return this.containerStyle;
  }
  
  public ViewGroup getNodeItemsView()
  {
    return (ViewGroup)getView().findViewById(JarResource.getIdByName("id", "node_items"));
  }
  
  public View getNodeView()
  {
    return createNodeView(this.mNode, this.mNode.getValue());
  }
  
  public AndroidTreeView getTreeView()
  {
    return this.tView;
  }
  
  public View getView()
  {
    if (this.mView != null) {
      return this.mView;
    }
    View localView = getNodeView();
    TreeNodeWrapperView localTreeNodeWrapperView = new TreeNodeWrapperView(localView.getContext(), getContainerStyle());
    localTreeNodeWrapperView.insertNodeView(localView);
    this.mView = localTreeNodeWrapperView;
    return this.mView;
  }
  
  public boolean isInitialized()
  {
    return this.mView != null;
  }
  
  public void setContainerStyle(int paramInt)
  {
    this.containerStyle = paramInt;
  }
  
  public void setTreeViev(AndroidTreeView paramAndroidTreeView)
  {
    this.tView = paramAndroidTreeView;
  }
  
  public void toggle(boolean paramBoolean) {}
  
  public void toggleSelectionMode(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.unnamed.b.atv.model.TreeNode.BaseNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */