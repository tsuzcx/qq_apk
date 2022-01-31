package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.dialog.AttrsDialog;
import me.ele.uetool.util.ChangePool;

public class EditAttrLayout
  extends CollectViewsLayout
{
  private Paint areaPaint = new EditAttrLayout.2(this);
  private Context context;
  private GestureDetector detector;
  private AttrsDialog dialog;
  private List<Element> elementList = new ArrayList(16);
  GestureDetector.OnGestureListener gestureListener = new EditAttrLayout.1(this);
  private float lastX;
  private float lastY;
  private final int lineBorderDistance = DimenUtil.dip2px(5.0F);
  private EditAttrLayout.IMode mode = new EditAttrLayout.ShowMode(this);
  private final int moveUnit = DimenUtil.dip2px(1.0F);
  private EditAttrLayout.OnDragListener onDragListener;
  private Element targetElement;
  
  public EditAttrLayout(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.detector = new GestureDetector(paramContext, this.gestureListener);
  }
  
  public EditAttrLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EditAttrLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void findSimilarView(Element paramElement)
  {
    int i = this.elements.size() - 1;
    if (i >= 0) {
      if (isSimilar(paramElement, (Element)this.elements.get(i)))
      {
        Object localObject = ((Element)this.elements.get(i)).getView();
        if (!(localObject instanceof ViewGroup)) {
          break label143;
        }
        localObject = (ViewGroup)localObject;
        j = 0;
        label72:
        if (j >= ((ViewGroup)localObject).getChildCount()) {
          break label143;
        }
        if (!this.elementList.contains(((ViewGroup)localObject).getChildAt(j))) {
          break label112;
        }
      }
    }
    label143:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {}
      for (;;)
      {
        i -= 1;
        break;
        label112:
        j += 1;
        break label72;
        this.elementList.add(this.elements.get(i));
      }
      return;
    }
  }
  
  public void clickAndShow(Element paramElement)
  {
    if (paramElement != null)
    {
      ChangePool.getInstance().addToPool(paramElement);
      this.elementList.clear();
      findSimilarView(paramElement);
      this.targetElement = paramElement;
      invalidate();
      if (this.dialog == null)
      {
        this.dialog = new AttrsDialog(getContext());
        AttrsDialog.setRefresh(new EditAttrLayout.3(this));
        this.dialog.setAttrDialogCallback(new EditAttrLayout.4(this));
        this.dialog.setTouchCallback(new EditAttrLayout.5(this));
        this.dialog.setOnDismissListener(new EditAttrLayout.6(this));
      }
      this.dialog.show(this.targetElement);
    }
  }
  
  public void dismissAttrsDialog()
  {
    if (this.dialog != null) {
      this.dialog.dismiss();
    }
  }
  
  public void findByViewAndShowDialog(View paramView)
  {
    clickAndShow(getTargetElementByView(paramView));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.targetElement = null;
    dismissAttrsDialog();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.targetElement != null)
    {
      this.targetElement.reset();
      paramCanvas.drawRect(this.targetElement.getRect(), this.areaPaint);
      this.mode.onDraw(paramCanvas);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((this.mode instanceof EditAttrLayout.ShowMode)) || ((this.mode instanceof EditAttrLayout.MultipleChosenMode))) {
      this.detector.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return true;
      switch (paramMotionEvent.getAction())
      {
      default: 
        break;
      case 0: 
        this.lastX = paramMotionEvent.getX();
        this.lastY = paramMotionEvent.getY();
        break;
      case 1: 
        this.mode.triggerActionUp(paramMotionEvent);
        break;
      case 2: 
        this.mode.triggerActionMove(paramMotionEvent);
      }
    }
  }
  
  public void setOnDragListener(EditAttrLayout.OnDragListener paramOnDragListener)
  {
    this.onDragListener = paramOnDragListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout
 * JD-Core Version:    0.7.0.1
 */