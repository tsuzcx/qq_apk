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
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.utils.ViolaUtils;
import java.lang.ref.WeakReference;

public class VTransform
  extends VDiv
{
  public static final String DISABLE = "disable";
  private static final String DISABLE_OPACITY = "disableOpacity";
  public static final String INVERSE = "inverse";
  private static final String OPACITY = "opacity";
  private static final String TRANSFORM = "translation";
  private boolean disable;
  private float disableOpacity;
  private boolean inverse;
  private float lastTransformY;
  private int length;
  private int top = -1;
  private String type;
  private WeakReference<VRecyclerList> weakListRef;
  
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
  
  private float getTransformAlpha(float paramFloat)
  {
    float f = Math.min(Math.max(paramFloat, 0.0F), 1.0F);
    if (this.disable) {
      paramFloat = this.disableOpacity;
    }
    do
    {
      return paramFloat;
      paramFloat = f;
    } while (!this.inverse);
    return 1.0F - f;
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
    Attr localAttr = paramDomObject.getAttributes();
    this.type = ((String)localAttr.get("type"));
    this.length = getLength(paramDomObject);
    this.disableOpacity = ViolaUtils.getFloat(localAttr.get("disableOpacity"), Float.valueOf(1.0F));
    this.inverse = ViolaUtils.getBoolean(localAttr.get("inverse"));
    this.disable = ViolaUtils.getBoolean(localAttr.get("disable"));
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
  
  private void setDisable(Object paramObject)
  {
    if (getHostView() == null) {}
    do
    {
      return;
      this.disable = ViolaUtils.getBoolean(paramObject);
      if (this.disable)
      {
        ((VFrameLayout)getHostView()).setAlpha(this.disableOpacity);
        return;
      }
    } while ((this.weakListRef == null) || (this.weakListRef.get() == null) || (((VRecyclerList)this.weakListRef.get()).getHostView() == null));
    paramObject = (VRecyclerList)this.weakListRef.get();
    onScroll((RecyclerView)paramObject.getHostView(), true, 0, ((VRecyclerView)paramObject.getHostView()).getContentOffsetY());
  }
  
  private void tryInitRecyclerListRef(RecyclerView paramRecyclerView)
  {
    if (!(paramRecyclerView instanceof VRecyclerView)) {}
    do
    {
      return;
      paramRecyclerView = ((VRecyclerView)paramRecyclerView).getComponent();
    } while (paramRecyclerView == null);
    this.weakListRef = new WeakReference(paramRecyclerView);
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VTransformView(paramContext);
    paramContext.bindComponent(this);
    initAttr(this.mDomObj);
    if (hasAlpha(this.type)) {
      paramContext.setAlpha(getTransformAlpha(0.0F));
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
    if ((!paramBoolean) || (this.mDomObj == null)) {}
    View localView;
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
          if (this.weakListRef == null) {
            tryInitRecyclerListRef(paramRecyclerView);
          }
          if (this.top == -1) {
            this.top = getTop(paramRecyclerView, this.mDomObj);
          }
          paramInt1 = localView.getHeight();
          paramInt2 = (int)ViolaUtils.getLayoutYInList(getInstance().getInstanceId(), this.mDomObj.getRef()) - Math.abs(paramInt2);
        } while ((paramInt2 - this.top > 0) && (this.length + paramInt2 < this.top));
        f1 = (this.top - paramInt2) / this.length;
        if (this.inverse) {
          f1 = getTransformAlpha(1.0F - Math.min(Math.max(Math.abs(paramInt2 - this.top) * 1.0F / this.length, 0.0F), 1.0F));
        }
        f2 = f1;
        if (hasAlpha(this.type))
        {
          f2 = f1;
          if (f1 < 0.0F) {
            f2 = 0.0F;
          }
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          localView.setAlpha(f1);
          f2 = f1;
        }
      } while (!hasTranslationY(this.type));
      f2 = (1.0F - f2) * paramInt1;
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
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    if ("disable".equals(paramString))
    {
      setDisable(paramObject);
      return true;
    }
    return super.setProperty(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VTransform
 * JD-Core Version:    0.7.0.1
 */