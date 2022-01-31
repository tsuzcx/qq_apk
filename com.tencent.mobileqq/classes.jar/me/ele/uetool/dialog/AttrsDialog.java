package me.ele.uetool.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.BriefDescItem;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.util.JarResource;

public class AttrsDialog
  extends Dialog
{
  private static Context context;
  private static AttrsDialog.Refresh refresh;
  private AttrsDialog.Adapter adapter = new AttrsDialog.Adapter();
  private RecyclerView.LayoutManager layoutManager = new AttrsDialog.FoucsLinearLayoutManager(this, getContext(), 1, false);
  private AttrsDialog.AttrDialogTouchCallback touchCallback;
  private RecyclerView vList;
  
  public AttrsDialog(Context paramContext)
  {
    super(paramContext, JarResource.getIdByName("style", "qb_uet_Theme.Holo.Dialog.background.Translucent"));
  }
  
  public static void setContext(Context paramContext)
  {
    context = paramContext;
  }
  
  public static void setRefresh(AttrsDialog.Refresh paramRefresh)
  {
    refresh = paramRefresh;
  }
  
  public void dismiss()
  {
    super.dismiss();
    refresh = null;
  }
  
  public final void notifyItemRangeRemoved(int paramInt)
  {
    this.adapter.notifyValidViewItemRemoved(paramInt);
  }
  
  public void notifyReasonItemInserted(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new TextItem("", (String)paramList.get(i)));
      i += 1;
    }
    this.adapter.notifyValidViewItemInserted(paramInt, localArrayList);
  }
  
  public void notifyValidViewItemInserted(int paramInt, List<Element> paramList, Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Element localElement = (Element)paramList.get(i);
      localArrayList.add(new BriefDescItem(localElement, paramElement.equals(localElement)));
      i += 1;
    }
    this.adapter.notifyValidViewItemInserted(paramInt, localArrayList);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(JarResource.getIdByName("layout", "qb_uet_dialog_attrs"));
    this.vList = ((RecyclerView)findViewById(JarResource.getIdByName("id", "list")));
    this.adapter.setHasStableIds(true);
    this.vList.setItemAnimator(null);
    this.vList.setAdapter(this.adapter);
    this.layoutManager.setAutoMeasureEnabled(false);
    this.vList.setLayoutManager(this.layoutManager);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    cancel();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.touchCallback.touch(f1, f2);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAttrDialogCallback(AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
  {
    this.adapter.setAttrDialogCallback(paramAttrDialogCallback);
  }
  
  public void setTouchCallback(AttrsDialog.AttrDialogTouchCallback paramAttrDialogTouchCallback)
  {
    this.touchCallback = paramAttrDialogTouchCallback;
  }
  
  public void show(Element paramElement)
  {
    show();
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(51);
    localLayoutParams.x = paramElement.getRect().left;
    if (DimenUtil.getScreenHeight() / 2 < paramElement.getRect().centerY()) {}
    for (int i = 0;; i = DimenUtil.getScreenHeight())
    {
      localLayoutParams.y = i;
      localLayoutParams.width = DimenUtil.getScreenWidth();
      localLayoutParams.height = (DimenUtil.getScreenHeight() / 2);
      localWindow.setAttributes(localLayoutParams);
      this.adapter.notifyDataSetChanged(paramElement);
      this.layoutManager.scrollToPosition(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog
 * JD-Core Version:    0.7.0.1
 */