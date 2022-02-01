package me.ele.uetool.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.BriefDescItem;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;
import me.ele.uetool.util.ViewKnife;

public class MultipleAttrsDialog
  extends ReportDialog
{
  private static final String TAG = "MultipleAttrsDialog";
  private static int clickItemNum = -1;
  private static MultipleAttrsDialog.Refresh refresh;
  private MultipleAttrsDialog.Adapter adapter = new MultipleAttrsDialog.Adapter();
  private RecyclerView.LayoutManager layoutManager = new MultipleAttrsDialog.FoucsLinearLayoutManager(this, getContext());
  private RecyclerView vList;
  
  public MultipleAttrsDialog(Context paramContext)
  {
    super(paramContext, JarResource.getIdByName("style", "qb_uet_Theme.Holo.Dialog.background.Translucent"));
  }
  
  public static List<Item> getAttrs(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    View localView = paramElement.getView();
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject1 = new SwitchItem("背景色板", paramElement, 0);
      ((SwitchItem)localObject1).setCallBack(new MultipleAttrsDialog.1(localView));
      localArrayList.add(localObject1);
    }
    if ((localView instanceof TextView))
    {
      localObject1 = (TextView)localView;
      if (((TextView)localObject1).getTypeface() == null) {
        break label522;
      }
    }
    label522:
    for (boolean bool = ((TextView)localObject1).getTypeface().isBold();; bool = false)
    {
      localArrayList.add(new SwitchItem("文字加粗", paramElement, 1, bool));
      Object localObject2 = new AddMinusEditItem("字号（px）", paramElement, 2, ((TextView)localObject1).getTextSize() + "");
      ((AddMinusEditItem)localObject2).setAddMin(new MultipleAttrsDialog.2());
      localArrayList.add(localObject2);
      localArrayList.add(new EditTextItem("文字颜色", paramElement, 3, Util.intToHexColor(((TextView)localObject1).getCurrentTextColor())));
      localObject1 = ViewKnife.getMargin(paramElement);
      localArrayList.add(new AddMinusEditItem("上外边距（dp）", paramElement, 10, DimenUtil.px2dip(localObject1[1])));
      localArrayList.add(new AddMinusEditItem("左外边距（dp）", paramElement, 11, DimenUtil.px2dip(localObject1[0])));
      localArrayList.add(new AddMinusEditItem("宽（dp）", paramElement, 4, DimenUtil.px2dip(localView.getWidth())));
      localArrayList.add(new AddMinusEditItem("高（dp）", paramElement, 5, DimenUtil.px2dip(localView.getHeight())));
      localObject1 = new EditTextItem("透明度", paramElement, -1, String.valueOf(localView.getAlpha()));
      ((EditTextItem)localObject1).setCallBack(new MultipleAttrsDialog.3());
      localArrayList.add(localObject1);
      localObject2 = Util.getBackground(localView);
      if (((localObject2 instanceof String)) || (localObject2 == null))
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
        localObject1 = new EditTextItem("背景颜色", paramElement, -1, (String)localObject1);
        ((EditTextItem)localObject1).setCallBack(new MultipleAttrsDialog.4());
        localArrayList.add(localObject1);
      }
      localArrayList.add(new AddMinusEditItem("左内边距（dp）", paramElement, 6, DimenUtil.px2dip(localView.getPaddingLeft())));
      localArrayList.add(new AddMinusEditItem("右内边距（dp）", paramElement, 7, DimenUtil.px2dip(localView.getPaddingRight())));
      localArrayList.add(new AddMinusEditItem("上内边距（dp）", paramElement, 8, DimenUtil.px2dip(localView.getPaddingTop())));
      localArrayList.add(new AddMinusEditItem("下内边距（dp）", paramElement, 9, DimenUtil.px2dip(localView.getPaddingBottom())));
      return localArrayList;
    }
  }
  
  public static void setRefresh(MultipleAttrsDialog.Refresh paramRefresh)
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
    this.vList.setAdapter(this.adapter);
    this.layoutManager.setAutoMeasureEnabled(false);
    this.vList.setLayoutManager(this.layoutManager);
  }
  
  public void setCallBack(MultipleAttrsDialog.ValidCallBack paramValidCallBack)
  {
    this.adapter.setCallBack(paramValidCallBack);
  }
  
  public void show(Element paramElement, List<Element> paramList)
  {
    show();
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(51);
    localLayoutParams.width = DimenUtil.getScreenWidth();
    localLayoutParams.height = (DimenUtil.getScreenHeight() / 2);
    localWindow.setAttributes(localLayoutParams);
    this.layoutManager.scrollToPosition(0);
    this.adapter.notifyDataSetChanged(paramElement);
    this.adapter.setElementList(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog
 * JD-Core Version:    0.7.0.1
 */