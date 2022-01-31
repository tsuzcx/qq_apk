package me.ele.uetool.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.Provider;
import me.ele.uetool.UETool;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.view.RegionView;

public class FragmentListTreeDialog
  extends Dialog
  implements Provider
{
  private ViewGroup containerView;
  private RegionView regionView;
  
  public FragmentListTreeDialog(Context paramContext)
  {
    super(paramContext);
    requestWindowFeature(1);
  }
  
  private void createTree(boolean paramBoolean)
  {
    Object localObject = TreeNode.root();
    Activity localActivity = UETool.getInstance().getTargetActivity();
    if ((localActivity instanceof FragmentActivity)) {
      createTreeNode((TreeNode)localObject, ((FragmentActivity)localActivity).getSupportFragmentManager(), paramBoolean);
    }
    this.containerView.removeAllViews();
    localObject = new AndroidTreeView(getContext(), (TreeNode)localObject);
    ((AndroidTreeView)localObject).setDefaultAnimation(true);
    ((AndroidTreeView)localObject).setUse2dScroll(true);
    ((AndroidTreeView)localObject).setDefaultContainerStyle(JarResource.getIdByName("style", "qb_uet_TreeNodeStyleCustom"));
    this.containerView.addView(((AndroidTreeView)localObject).getView());
    ((AndroidTreeView)localObject).expandAll();
  }
  
  private TreeNode createTreeNode(TreeNode paramTreeNode, FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    if (paramFragmentManager.getFragments() == null)
    {
      paramFragmentManager = null;
      return paramFragmentManager;
    }
    Iterator localIterator = paramFragmentManager.getFragments().iterator();
    for (;;)
    {
      paramFragmentManager = paramTreeNode;
      if (!localIterator.hasNext()) {
        break;
      }
      paramFragmentManager = (Fragment)localIterator.next();
      paramTreeNode.addChild(createTreeNode(new TreeNode(new FragmentListTreeDialog.TreeItem(paramFragmentManager, paramBoolean)).setViewHolder(new FragmentListTreeDialog.TreeItemVH(getContext(), this)), paramFragmentManager.getChildFragmentManager(), paramBoolean));
    }
  }
  
  public void onClickTreeItem(RectF paramRectF)
  {
    this.regionView.drawRegion(paramRectF);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().addFlags(-2147483648);
    super.onCreate(paramBundle);
    setContentView(JarResource.getIdByName("layout", "qb_uet_dialog_fragment_list_tree"));
    this.containerView = ((ViewGroup)findViewById(JarResource.getIdByName("id", "container")));
    this.regionView = ((RegionView)findViewById(JarResource.getIdByName("id", "region")));
    paramBundle = (CheckBox)findViewById(JarResource.getIdByName("id", "checkbox"));
    createTree(paramBundle.isChecked());
    paramBundle.setOnCheckedChangeListener(new FragmentListTreeDialog.1(this));
  }
  
  protected void onStart()
  {
    super.onStart();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().setLayout(-1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.FragmentListTreeDialog
 * JD-Core Version:    0.7.0.1
 */