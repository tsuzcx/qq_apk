package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.ui.view.VTransformView;
import com.tencent.viola.utils.ViolaUtils;

public class VTransform
  extends VDiv
{
  private static final String OPACITY = "opacity";
  private static final String TRANSFORM = "translation";
  private int distanceYInList;
  private float lastAlpha = 0.0F;
  private float lastTransformY;
  private int length;
  private int top = -1;
  private String type;
  
  public VTransform(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    listenerScrollEvent(paramDomObject);
  }
  
  private int getLength(DomObject paramDomObject)
  {
    return (int)ViolaUtils.getFloatCompactWithPercent(paramDomObject.getAttributes().get("length"), paramDomObject.getLayoutHeight());
  }
  
  private int getTop(RecyclerView paramRecyclerView, DomObject paramDomObject)
  {
    if (paramRecyclerView == null) {
      return -1;
    }
    return (int)ViolaUtils.getFloatCompactWithPercent(paramDomObject.getAttributes().get("top"), paramRecyclerView.getHeight());
  }
  
  private boolean hasAlpha(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    return paramString.contains("opacity");
  }
  
  private boolean hasTranslationY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("translation");
  }
  
  private void initAttr(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    this.type = ((String)paramDomObject.getAttributes().get("type"));
    this.length = getLength(paramDomObject);
    this.distanceYInList = ((int)ViolaUtils.getLayoutYInList(getInstance().getInstanceId(), paramDomObject.getRef()));
  }
  
  private void listenerScrollEvent(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    Object localObject = paramDomObject;
    DomObject localDomObject;
    do
    {
      if ((localObject instanceof DomObjectCell))
      {
        ((DomObjectCell)localObject).addScrollEvent(paramDomObject.getRef());
        return;
      }
      localDomObject = ((DomObject)localObject).getDomParent();
      localObject = localDomObject;
    } while (localDomObject != null);
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VTransformView(paramContext);
    paramContext.bindComponent(this);
    initAttr(this.mDomObj);
    if (hasAlpha(this.type)) {
      paramContext.setAlpha(0.0F);
    }
    if (hasTranslationY(this.type)) {
      paramContext.setTranslationY(this.mDomObj.getLayoutHeight());
    }
    return paramContext;
  }
  
  public boolean isReuse()
  {
    return false;
  }
  
  public void onScroll(RecyclerView paramRecyclerView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {}
    View localView;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localView = getHostView();
            } while (localView == null);
            if (this.top == -1) {
              this.top = getTop(paramRecyclerView, this.mDomObj);
            }
            paramInt1 = localView.getHeight();
            paramInt2 = this.distanceYInList - Math.abs(paramInt2);
          } while ((paramInt2 - this.top > 0) && (this.length + paramInt2 < this.top));
          f2 = (this.top - paramInt2) / this.length;
          f1 = f2;
          if (!hasAlpha(this.type)) {
            break;
          }
        } while (f2 == this.lastAlpha);
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = 0.0F;
        }
        f2 = f1;
        if (f1 > 1.0F) {
          f2 = 1.0F;
        }
        localView.setAlpha(f2);
        this.lastAlpha = f2;
        f1 = f2;
      } while (!hasTranslationY(this.type));
      f2 = (1.0F - f1) * paramInt1;
    } while (f2 == this.lastTransformY);
    float f1 = f2;
    if (f2 > paramInt1) {
      f1 = paramInt1;
    }
    float f2 = f1;
    if (f1 < 0.0F) {
      f2 = 0.0F;
    }
    localView.setTranslationY(f2);
    this.lastTransformY = f2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VTransform
 * JD-Core Version:    0.7.0.1
 */