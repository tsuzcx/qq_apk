package me.ele.uetool.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.ele.uetool.UETool;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;

public class CollectViewsLayout
  extends View
{
  protected Element childElement;
  protected Paint dashLinePaint = new CollectViewsLayout.3(this);
  protected List<Element> elements = new ArrayList();
  private final int halfEndPointWidth = DimenUtil.dip2px(2.5F);
  protected Element parentElement;
  protected final int screenHeight = DimenUtil.getScreenHeight();
  protected final int screenWidth = DimenUtil.getScreenWidth();
  private final int textBgFillingSpace = DimenUtil.dip2px(2.0F);
  private Paint textBgPaint = new CollectViewsLayout.2(this);
  private final int textLineDistance = DimenUtil.dip2px(5.0F);
  protected Paint textPaint = new CollectViewsLayout.1(this);
  
  public CollectViewsLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public CollectViewsLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CollectViewsLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void createElements(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    traverse(paramView, localArrayList);
    Collections.sort(localArrayList, new CollectViewsLayout.4(this));
    this.elements.addAll(localArrayList);
  }
  
  private void drawLineWithEndPoint(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramCanvas.drawLine(paramInt1, paramInt2, paramInt3, paramInt4, this.textPaint);
    if (paramInt1 == paramInt3)
    {
      paramCanvas.drawLine(paramInt1 - this.halfEndPointWidth, paramInt2, this.halfEndPointWidth + paramInt3, paramInt2, this.textPaint);
      paramCanvas.drawLine(paramInt1 - this.halfEndPointWidth, paramInt4, this.halfEndPointWidth + paramInt3, paramInt4, this.textPaint);
    }
    while (paramInt2 != paramInt4) {
      return;
    }
    paramCanvas.drawLine(paramInt1, paramInt2 - this.halfEndPointWidth, paramInt1, this.halfEndPointWidth + paramInt4, this.textPaint);
    paramCanvas.drawLine(paramInt3, paramInt2 - this.halfEndPointWidth, paramInt3, this.halfEndPointWidth + paramInt4, this.textPaint);
  }
  
  private View getTargetDecorView(Activity paramActivity, View paramView)
  {
    Context localContext;
    if (((paramView instanceof ViewGroup)) && (((ViewGroup)paramView).getChildCount() > 0)) {
      localContext = ((ViewGroup)paramView).getChildAt(0).getContext();
    }
    for (;;)
    {
      if (localContext != null)
      {
        if (localContext == paramActivity) {
          return paramView;
        }
        if ((localContext instanceof ContextWrapper)) {
          localContext = ((ContextWrapper)localContext).getBaseContext();
        } else {
          return null;
        }
      }
      else
      {
        return null;
        localContext = null;
      }
    }
  }
  
  private boolean isParentNotVisible(Element paramElement)
  {
    if (paramElement == null) {
      return false;
    }
    if ((paramElement.getRect().left >= DimenUtil.getScreenWidth()) || (paramElement.getRect().top >= DimenUtil.getScreenHeight())) {
      return true;
    }
    return isParentNotVisible(paramElement.getParentElement());
  }
  
  private void traverse(View paramView, List<Element> paramList)
  {
    if (UETool.getInstance().getFilterClasses().contains(paramView.getClass().getName())) {
      break label21;
    }
    for (;;)
    {
      label21:
      return;
      if ((paramView.getAlpha() != 0.0F) && (paramView.getVisibility() == 0) && (!"DESABLE_UETOOL".equals(paramView.getTag())))
      {
        paramList.add(new Element(paramView));
        if (!(paramView instanceof ViewGroup)) {
          break;
        }
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          traverse(paramView.getChildAt(i), paramList);
          i += 1;
        }
      }
    }
  }
  
  protected void drawLineWithText(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    drawLineWithText(paramCanvas, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  protected void drawLineWithText(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
      return;
    }
    int i;
    if (paramInt1 > paramInt3)
    {
      i = paramInt3;
      paramInt3 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt2 > paramInt4)
      {
        i = paramInt2;
        paramInt2 = paramInt4;
      }
      for (;;)
      {
        if (paramInt1 == paramInt3)
        {
          drawLineWithEndPoint(paramCanvas, paramInt1, paramInt2 + paramInt5, paramInt3, i - paramInt5);
          str = DimenUtil.px2dip(i - paramInt2, true);
          drawText(paramCanvas, str, this.textLineDistance + paramInt1, (i - paramInt2) / 2 + paramInt2 + getTextHeight(str) / 2.0F);
          return;
        }
        if (paramInt2 != i) {
          break;
        }
        drawLineWithEndPoint(paramCanvas, paramInt1 + paramInt5, paramInt2, paramInt3 - paramInt5, i);
        String str = DimenUtil.px2dip(paramInt3 - paramInt1, true);
        drawText(paramCanvas, str, (paramInt3 - paramInt1) / 2 + paramInt1 - getTextWidth(str) / 2.0F, paramInt2 - this.textLineDistance);
        return;
        i = paramInt4;
      }
    }
  }
  
  protected void drawText(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    float f3 = paramFloat1 - this.textBgFillingSpace;
    float f2 = paramFloat2 - getTextHeight(paramString);
    float f4 = getTextWidth(paramString);
    float f5 = this.textBgFillingSpace + (f4 + paramFloat1);
    f4 = this.textBgFillingSpace + paramFloat2;
    paramFloat1 = f5;
    paramFloat2 = f3;
    if (f3 < 0.0F)
    {
      paramFloat1 = f5 - f3;
      paramFloat2 = 0.0F;
    }
    if (f2 < 0.0F) {}
    for (f2 = f4 - f2;; f2 = f4)
    {
      if (f2 > this.screenHeight)
      {
        f3 = this.screenHeight;
        f1 = f3 + (f1 - f2);
        f2 = f3;
      }
      for (;;)
      {
        if (paramFloat1 > this.screenWidth)
        {
          f3 = this.screenWidth;
          paramFloat2 = f3 + (paramFloat2 - paramFloat1);
          paramFloat1 = f3;
        }
        for (;;)
        {
          paramCanvas.drawRect(paramFloat2, f1, paramFloat1, f2, this.textBgPaint);
          paramCanvas.drawText(paramString, this.textBgFillingSpace + paramFloat2, f2 - this.textBgFillingSpace, this.textPaint);
          return;
        }
      }
      f1 = f2;
    }
  }
  
  protected Element getTargetElement(float paramFloat1, float paramFloat2)
  {
    int i = this.elements.size() - 1;
    Element localElement;
    for (;;)
    {
      if (i >= 0)
      {
        localElement = (Element)this.elements.get(i);
        if ((!localElement.getRect().contains((int)paramFloat1, (int)paramFloat2)) || (isParentNotVisible(localElement.getParentElement())))
        {
          i -= 1;
        }
        else if (localElement != this.childElement)
        {
          this.childElement = localElement;
          this.parentElement = localElement;
          if (this.parentElement != null) {
            break label156;
          }
        }
      }
    }
    for (;;)
    {
      if (localElement == null) {
        Toast.makeText(getContext(), String.format("could not found view in (%1$.0f , %2$.0f), please select view again", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }), 0).show();
      }
      return localElement;
      if (this.parentElement == null) {
        break;
      }
      this.parentElement = this.parentElement.getParentElement();
      break;
      label156:
      localElement = this.parentElement;
      continue;
      localElement = null;
    }
  }
  
  protected Element getTargetElementByView(View paramView)
  {
    Iterator localIterator = this.elements.iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (localElement.getView() == paramView) {
        return localElement;
      }
    }
    return null;
  }
  
  protected List<Element> getTargetElements(float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.elements.size() - 1;
    while (i >= 0)
    {
      Element localElement = (Element)this.elements.get(i);
      if (localElement.getRect().contains((int)paramFloat1, (int)paramFloat2)) {
        localArrayList.add(localElement);
      }
      i -= 1;
    }
    return localArrayList;
  }
  
  protected Element getTargetSimilarElement(Element paramElement, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = null;
    int i = this.elements.size() - 1;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < 0) {
        break;
      }
      localObject1 = (Element)this.elements.get(i);
      if ((((Element)localObject1).getRect().contains((int)paramFloat1, (int)paramFloat2)) && (!isParentNotVisible(((Element)localObject1).getParentElement())) && (isSimilar((Element)localObject1, paramElement))) {
        break;
      }
      i -= 1;
    }
    if (localObject1 == null)
    {
      i = this.elements.size() - 1;
      while (i >= 0)
      {
        Element localElement = (Element)this.elements.get(i);
        if ((localElement.getRect().contains((int)paramFloat1, (int)paramFloat2)) && (!isParentNotVisible(localElement.getParentElement())))
        {
          localObject2 = localElement;
          if (localElement.getView().getClass().equals(paramElement.getView().getClass())) {
            break label191;
          }
        }
        i -= 1;
      }
      localObject2 = localObject1;
      label191:
      if (localObject2 == null) {
        Toast.makeText(getContext(), String.format("could not found similar view in (%1$.0f , %2$.0f), please select view again", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }), 0).show();
      }
      return localObject2;
    }
    return localObject1;
  }
  
  protected float getTextHeight(String paramString)
  {
    Rect localRect = new Rect();
    this.textPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.height();
  }
  
  protected float getTextWidth(String paramString)
  {
    return this.textPaint.measureText(paramString);
  }
  
  protected boolean isSimilar(Element paramElement1, Element paramElement2)
  {
    paramElement1 = paramElement1.getView();
    paramElement2 = paramElement2.getView();
    if ((paramElement1.getId() == paramElement2.getId()) && (paramElement1.getClass().equals(paramElement2.getClass()))) {}
    while ((paramElement1.getClass().equals(paramElement2.getClass())) && (paramElement1.getHeight() == paramElement2.getHeight()) && (paramElement1.getWidth() == paramElement2.getWidth())) {
      return true;
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    for (;;)
    {
      int i;
      try
      {
        Activity localActivity = UETool.getInstance().getTargetActivity();
        Object localObject1 = localActivity.getWindowManager();
        if (Build.VERSION.SDK_INT > 16)
        {
          createElements(localActivity.getWindow().getDecorView());
          return;
        }
        Object localObject2 = Class.forName("android.view.WindowManagerImpl$CompatModeWrapper").getDeclaredField("mWindowManager");
        ((Field)localObject2).setAccessible(true);
        Field localField = Class.forName("android.view.WindowManagerImpl").getDeclaredField("mViews");
        localField.setAccessible(true);
        localObject1 = Arrays.asList((View[])localField.get(((Field)localObject2).get(localObject1)));
        i = ((List)localObject1).size() - 1;
        if (i < 0) {
          break;
        }
        localObject2 = getTargetDecorView(localActivity, (View)((List)localObject1).get(i));
        if (localObject2 != null)
        {
          createElements((View)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i -= 1;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.elements.clear();
    this.childElement = null;
    this.parentElement = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.view.CollectViewsLayout
 * JD-Core Version:    0.7.0.1
 */