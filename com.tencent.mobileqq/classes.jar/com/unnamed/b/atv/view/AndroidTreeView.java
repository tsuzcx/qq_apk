package com.unnamed.b.atv.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.unnamed.b.atv.holder.SimpleViewHolder;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.model.TreeNode.BaseNodeViewHolder;
import com.unnamed.b.atv.model.TreeNode.TreeNodeClickListener;
import com.unnamed.b.atv.model.TreeNode.TreeNodeLongClickListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.ele.uetool.util.JarResource;

public class AndroidTreeView
{
  private static final String NODES_PATH_SEPARATOR = ";";
  private boolean applyForRoot;
  private int containerStyle = 0;
  private Class<? extends TreeNode.BaseNodeViewHolder> defaultViewHolderClass = SimpleViewHolder.class;
  private boolean enableAutoToggle = true;
  private Context mContext;
  protected TreeNode mRoot;
  private boolean mSelectionModeEnabled;
  private boolean mUseDefaultAnimation = false;
  private TreeNode.TreeNodeClickListener nodeClickListener;
  private TreeNode.TreeNodeLongClickListener nodeLongClickListener;
  private boolean use2dScroll = false;
  
  public AndroidTreeView(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public AndroidTreeView(Context paramContext, TreeNode paramTreeNode)
  {
    this.mRoot = paramTreeNode;
    this.mContext = paramContext;
  }
  
  private void addNode(ViewGroup paramViewGroup, TreeNode paramTreeNode)
  {
    TreeNode.BaseNodeViewHolder localBaseNodeViewHolder = getViewHolderForNode(paramTreeNode);
    View localView = localBaseNodeViewHolder.getView();
    paramViewGroup.addView(localView);
    if (this.mSelectionModeEnabled) {
      localBaseNodeViewHolder.toggleSelectionMode(this.mSelectionModeEnabled);
    }
    localView.setOnClickListener(new AndroidTreeView.2(this, paramTreeNode));
    localView.setOnLongClickListener(new AndroidTreeView.3(this, paramTreeNode));
  }
  
  private static void collapse(View paramView)
  {
    int i = paramView.getMeasuredHeight();
    AndroidTreeView.5 local5 = new AndroidTreeView.5(paramView, i);
    local5.setDuration((int)(i / paramView.getContext().getResources().getDisplayMetrics().density));
    paramView.startAnimation(local5);
  }
  
  private void collapseNode(TreeNode paramTreeNode, boolean paramBoolean)
  {
    paramTreeNode.setExpanded(false);
    TreeNode.BaseNodeViewHolder localBaseNodeViewHolder = getViewHolderForNode(paramTreeNode);
    if (this.mUseDefaultAnimation) {
      collapse(localBaseNodeViewHolder.getNodeItemsView());
    }
    for (;;)
    {
      localBaseNodeViewHolder.toggle(false);
      if (!paramBoolean) {
        break;
      }
      paramTreeNode = paramTreeNode.getChildren().iterator();
      while (paramTreeNode.hasNext()) {
        collapseNode((TreeNode)paramTreeNode.next(), paramBoolean);
      }
      localBaseNodeViewHolder.getNodeItemsView().setVisibility(8);
    }
  }
  
  private static void expand(View paramView)
  {
    paramView.measure(-1, -2);
    int i = paramView.getMeasuredHeight();
    paramView.getLayoutParams().height = 0;
    paramView.setVisibility(0);
    AndroidTreeView.4 local4 = new AndroidTreeView.4(paramView, i);
    local4.setDuration((int)(i / paramView.getContext().getResources().getDisplayMetrics().density));
    paramView.startAnimation(local4);
  }
  
  private void expandLevel(TreeNode paramTreeNode, int paramInt)
  {
    if (paramTreeNode.getLevel() <= paramInt) {
      expandNode(paramTreeNode, false);
    }
    paramTreeNode = paramTreeNode.getChildren().iterator();
    while (paramTreeNode.hasNext()) {
      expandLevel((TreeNode)paramTreeNode.next(), paramInt);
    }
  }
  
  private void expandNode(TreeNode paramTreeNode, boolean paramBoolean)
  {
    paramTreeNode.setExpanded(true);
    TreeNode.BaseNodeViewHolder localBaseNodeViewHolder = getViewHolderForNode(paramTreeNode);
    localBaseNodeViewHolder.getNodeItemsView().removeAllViews();
    localBaseNodeViewHolder.toggle(true);
    paramTreeNode = paramTreeNode.getChildren().iterator();
    while (paramTreeNode.hasNext())
    {
      TreeNode localTreeNode = (TreeNode)paramTreeNode.next();
      addNode(localBaseNodeViewHolder.getNodeItemsView(), localTreeNode);
      if ((localTreeNode.isExpanded()) || (paramBoolean)) {
        expandNode(localTreeNode, paramBoolean);
      }
    }
    if (this.mUseDefaultAnimation)
    {
      expand(localBaseNodeViewHolder.getNodeItemsView());
      return;
    }
    localBaseNodeViewHolder.getNodeItemsView().setVisibility(0);
  }
  
  private void getSaveState(TreeNode paramTreeNode, StringBuilder paramStringBuilder)
  {
    paramTreeNode = paramTreeNode.getChildren().iterator();
    while (paramTreeNode.hasNext())
    {
      TreeNode localTreeNode = (TreeNode)paramTreeNode.next();
      if (localTreeNode.isExpanded())
      {
        paramStringBuilder.append(localTreeNode.getPath());
        paramStringBuilder.append(";");
        getSaveState(localTreeNode, paramStringBuilder);
      }
    }
  }
  
  private List<TreeNode> getSelected(TreeNode paramTreeNode)
  {
    ArrayList localArrayList = new ArrayList();
    paramTreeNode = paramTreeNode.getChildren().iterator();
    while (paramTreeNode.hasNext())
    {
      TreeNode localTreeNode = (TreeNode)paramTreeNode.next();
      if (localTreeNode.isSelected()) {
        localArrayList.add(localTreeNode);
      }
      localArrayList.addAll(getSelected(localTreeNode));
    }
    return localArrayList;
  }
  
  private TreeNode.BaseNodeViewHolder getViewHolderForNode(TreeNode paramTreeNode)
  {
    TreeNode.BaseNodeViewHolder localBaseNodeViewHolder2 = paramTreeNode.getViewHolder();
    TreeNode.BaseNodeViewHolder localBaseNodeViewHolder1 = localBaseNodeViewHolder2;
    if (localBaseNodeViewHolder2 == null) {}
    try
    {
      localBaseNodeViewHolder1 = (TreeNode.BaseNodeViewHolder)this.defaultViewHolderClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.mContext });
      paramTreeNode.setViewHolder(localBaseNodeViewHolder1);
      if (localBaseNodeViewHolder1.getContainerStyle() <= 0) {
        localBaseNodeViewHolder1.setContainerStyle(this.containerStyle);
      }
      if (localBaseNodeViewHolder1.getTreeView() == null) {
        localBaseNodeViewHolder1.setTreeViev(this);
      }
      return localBaseNodeViewHolder1;
    }
    catch (Exception paramTreeNode)
    {
      throw new RuntimeException("Could not instantiate class " + this.defaultViewHolderClass);
    }
  }
  
  private void makeAllSelection(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mSelectionModeEnabled)
    {
      Iterator localIterator = this.mRoot.getChildren().iterator();
      while (localIterator.hasNext()) {
        selectNode((TreeNode)localIterator.next(), paramBoolean1, paramBoolean2);
      }
    }
  }
  
  private void restoreNodeState(TreeNode paramTreeNode, Set<String> paramSet)
  {
    paramTreeNode = paramTreeNode.getChildren().iterator();
    while (paramTreeNode.hasNext())
    {
      TreeNode localTreeNode = (TreeNode)paramTreeNode.next();
      if (paramSet.contains(localTreeNode.getPath()))
      {
        expandNode(localTreeNode);
        restoreNodeState(localTreeNode, paramSet);
      }
    }
  }
  
  private void selectNode(TreeNode paramTreeNode, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramTreeNode.setSelected(paramBoolean1);
    toogleSelectionForNode(paramTreeNode, true);
    if (paramBoolean2) {
      bool = paramTreeNode.isExpanded();
    }
    if (bool)
    {
      paramTreeNode = paramTreeNode.getChildren().iterator();
      while (paramTreeNode.hasNext()) {
        selectNode((TreeNode)paramTreeNode.next(), paramBoolean1, paramBoolean2);
      }
    }
  }
  
  private void toggleSelectionMode(TreeNode paramTreeNode, boolean paramBoolean)
  {
    toogleSelectionForNode(paramTreeNode, paramBoolean);
    if (paramTreeNode.isExpanded())
    {
      paramTreeNode = paramTreeNode.getChildren().iterator();
      while (paramTreeNode.hasNext()) {
        toggleSelectionMode((TreeNode)paramTreeNode.next(), paramBoolean);
      }
    }
  }
  
  private void toogleSelectionForNode(TreeNode paramTreeNode, boolean paramBoolean)
  {
    if (getViewHolderForNode(paramTreeNode).isInitialized()) {
      getViewHolderForNode(paramTreeNode).toggleSelectionMode(paramBoolean);
    }
  }
  
  public void addNode(TreeNode paramTreeNode1, TreeNode paramTreeNode2)
  {
    paramTreeNode1.addChild(paramTreeNode2);
    if (paramTreeNode1.isExpanded()) {
      addNode(getViewHolderForNode(paramTreeNode1).getNodeItemsView(), paramTreeNode2);
    }
  }
  
  public void collapseAll()
  {
    Iterator localIterator = this.mRoot.getChildren().iterator();
    while (localIterator.hasNext()) {
      collapseNode((TreeNode)localIterator.next(), true);
    }
  }
  
  public void collapseNode(TreeNode paramTreeNode)
  {
    collapseNode(paramTreeNode, false);
  }
  
  public void deselectAll()
  {
    makeAllSelection(false, false);
  }
  
  public void expandAll()
  {
    expandNode(this.mRoot, true);
  }
  
  public void expandLevel(int paramInt)
  {
    Iterator localIterator = this.mRoot.getChildren().iterator();
    while (localIterator.hasNext()) {
      expandLevel((TreeNode)localIterator.next(), paramInt);
    }
  }
  
  public void expandNode(TreeNode paramTreeNode)
  {
    expandNode(paramTreeNode, false);
  }
  
  public String getSaveState()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    getSaveState(this.mRoot, localStringBuilder);
    if (localStringBuilder.length() > 0) {
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  public List<TreeNode> getSelected()
  {
    if (this.mSelectionModeEnabled) {
      return getSelected(this.mRoot);
    }
    return new ArrayList();
  }
  
  public <E> List<E> getSelectedValues(Class<E> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getSelected().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((TreeNode)localIterator.next()).getValue();
      if ((localObject != null) && (localObject.getClass().equals(paramClass))) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public View getView()
  {
    return getView(-1);
  }
  
  public View getView(int paramInt)
  {
    Object localObject1;
    if (paramInt > 0)
    {
      localObject1 = new ContextThemeWrapper(this.mContext, paramInt);
      if (this.use2dScroll) {
        localObject1 = new TwoDScrollView((Context)localObject1);
      }
    }
    for (;;)
    {
      Context localContext = this.mContext;
      Object localObject2 = localContext;
      if (this.containerStyle != 0)
      {
        localObject2 = localContext;
        if (this.applyForRoot) {
          localObject2 = new ContextThemeWrapper(this.mContext, this.containerStyle);
        }
      }
      localObject2 = new LinearLayout((Context)localObject2, null, this.containerStyle);
      ((LinearLayout)localObject2).setId(JarResource.getIdByName("id", "tree_items"));
      ((LinearLayout)localObject2).setOrientation(1);
      ((ViewGroup)localObject1).addView((View)localObject2);
      this.mRoot.setViewHolder(new AndroidTreeView.1(this, this.mContext, (LinearLayout)localObject2));
      expandNode(this.mRoot, false);
      return localObject1;
      localObject1 = new ScrollView((Context)localObject1);
      continue;
      if (this.use2dScroll) {
        localObject1 = new TwoDScrollView(this.mContext);
      } else {
        localObject1 = new ScrollView(this.mContext);
      }
    }
  }
  
  public boolean is2dScrollEnabled()
  {
    return this.use2dScroll;
  }
  
  public boolean isAutoToggleEnabled()
  {
    return this.enableAutoToggle;
  }
  
  public boolean isSelectionModeEnabled()
  {
    return this.mSelectionModeEnabled;
  }
  
  public void removeNode(TreeNode paramTreeNode)
  {
    if (paramTreeNode.getParent() != null)
    {
      TreeNode localTreeNode = paramTreeNode.getParent();
      int i = localTreeNode.deleteChild(paramTreeNode);
      if ((localTreeNode.isExpanded()) && (i >= 0)) {
        getViewHolderForNode(localTreeNode).getNodeItemsView().removeViewAt(i);
      }
    }
  }
  
  public void restoreState(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      collapseAll();
      paramString = new HashSet(Arrays.asList(paramString.split(";")));
      restoreNodeState(this.mRoot, paramString);
    }
  }
  
  public void selectAll(boolean paramBoolean)
  {
    makeAllSelection(true, paramBoolean);
  }
  
  public void selectNode(TreeNode paramTreeNode, boolean paramBoolean)
  {
    if (this.mSelectionModeEnabled)
    {
      paramTreeNode.setSelected(paramBoolean);
      toogleSelectionForNode(paramTreeNode, true);
    }
  }
  
  public void setDefaultAnimation(boolean paramBoolean)
  {
    this.mUseDefaultAnimation = paramBoolean;
  }
  
  public void setDefaultContainerStyle(int paramInt)
  {
    setDefaultContainerStyle(paramInt, false);
  }
  
  public void setDefaultContainerStyle(int paramInt, boolean paramBoolean)
  {
    this.containerStyle = paramInt;
    this.applyForRoot = paramBoolean;
  }
  
  public void setDefaultNodeClickListener(TreeNode.TreeNodeClickListener paramTreeNodeClickListener)
  {
    this.nodeClickListener = paramTreeNodeClickListener;
  }
  
  public void setDefaultNodeLongClickListener(TreeNode.TreeNodeLongClickListener paramTreeNodeLongClickListener)
  {
    this.nodeLongClickListener = paramTreeNodeLongClickListener;
  }
  
  public void setDefaultViewHolder(Class<? extends TreeNode.BaseNodeViewHolder> paramClass)
  {
    this.defaultViewHolderClass = paramClass;
  }
  
  public void setRoot(TreeNode paramTreeNode)
  {
    this.mRoot = paramTreeNode;
  }
  
  public void setSelectionModeEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {
      deselectAll();
    }
    this.mSelectionModeEnabled = paramBoolean;
    Iterator localIterator = this.mRoot.getChildren().iterator();
    while (localIterator.hasNext()) {
      toggleSelectionMode((TreeNode)localIterator.next(), paramBoolean);
    }
  }
  
  public void setUse2dScroll(boolean paramBoolean)
  {
    this.use2dScroll = paramBoolean;
  }
  
  public void setUseAutoToggle(boolean paramBoolean)
  {
    this.enableAutoToggle = paramBoolean;
  }
  
  public void toggleNode(TreeNode paramTreeNode)
  {
    if (paramTreeNode.isExpanded())
    {
      collapseNode(paramTreeNode, false);
      return;
    }
    expandNode(paramTreeNode, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.unnamed.b.atv.view.AndroidTreeView
 * JD-Core Version:    0.7.0.1
 */