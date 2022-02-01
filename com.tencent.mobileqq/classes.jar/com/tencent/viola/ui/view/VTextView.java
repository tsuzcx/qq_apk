package com.tencent.viola.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.viola.ui.component.VText;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectText;
import com.tencent.viola.ui.dom.style.StyleSpace;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;

public class VTextView
  extends TextView
  implements IVView<VText>
{
  public static final String TAG = "VTextView";
  public boolean mIsRich;
  private Layout mLayout;
  WeakReference<VText> mWeakReference;
  private int mlineSpacing;
  
  public VTextView(Context paramContext)
  {
    super(paramContext);
    setIncludeFontPadding(false);
  }
  
  public VTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void bindComponent(VText paramVText)
  {
    this.mWeakReference = new WeakReference(paramVText);
  }
  
  public VText getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VText)localWeakReference.get();
    }
    return null;
  }
  
  public Layout getTextLayout()
  {
    return this.mLayout;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mIsRich) {
      return;
    }
    paramCanvas.save();
    Object localObject = getComponent();
    boolean bool = true;
    if ((localObject != null) && (getComponent().getDomObject() != null))
    {
      StyleSpace localStyleSpace = getComponent().getDomObject().getPadding();
      Layout localLayout = getTextLayout();
      localObject = localLayout;
      if (localLayout == null)
      {
        localObject = localLayout;
        if (getComponent() != null)
        {
          localObject = localLayout;
          if ((getComponent().getDomObject() instanceof DomObjectText))
          {
            ((DomObjectText)getComponent().getDomObject()).recalculateLayout();
            ((DomObjectText)getComponent().getDomObject()).swap();
            getComponent().updateExtra(getComponent().getDomObject().getExtra());
            localObject = getTextLayout();
          }
        }
      }
      if (localObject != null)
      {
        if (localStyleSpace != null) {
          paramCanvas.translate(localStyleSpace.get(0), localStyleSpace.get(1));
        }
        ((Layout)localObject).draw(paramCanvas);
      }
      else if (getComponent().getDomObject() != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("layout null domObject :");
        ((StringBuilder)localObject).append(getComponent().getDomObject().toString());
        ViolaLogUtils.e("VTextView", ((StringBuilder)localObject).toString());
      }
      paramCanvas.restore();
      return;
    }
    paramCanvas = new StringBuilder();
    paramCanvas.append("getComponent() ==  null ||  getComponent().getDomObject() == null : ");
    if (getComponent() != null) {
      bool = false;
    }
    paramCanvas.append(bool);
    ViolaLogUtils.e("VTextView", paramCanvas.toString());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsRich)
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i == 1) {
          setHighlightColor(getResources().getColor(17170445));
        }
      }
      else {
        setHighlightColor(Color.parseColor("#22000000"));
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setLayout(Layout paramLayout)
  {
    this.mLayout = paramLayout;
  }
  
  public void setRichText(boolean paramBoolean, int paramInt)
  {
    this.mIsRich = paramBoolean;
    this.mlineSpacing = paramInt;
  }
  
  public void setTextLayout(Layout paramLayout)
  {
    this.mLayout = paramLayout;
    if (paramLayout != null)
    {
      setContentDescription(paramLayout.getText());
      if (this.mIsRich)
      {
        setIncludeFontPadding(false);
        setLineSpacing(this.mlineSpacing, 1.0F);
        setText(paramLayout.getText());
        if ((getComponent() != null) && (getComponent().getDomObject() != null) && ((getComponent().getDomObject() instanceof DomObjectText)) && (((DomObjectText)getComponent().getDomObject()).isRichClickable))
        {
          setFocusable(false);
          setMovementMethod(LinkMovementMethod.getInstance());
        }
        paramLayout = getComponent().getDomObject().getPadding();
        if (paramLayout != null) {
          setPadding((int)paramLayout.get(0), (int)paramLayout.get(1), (int)paramLayout.get(2), (int)paramLayout.get(3));
        }
        setHighlightColor(Color.parseColor("#22000000"));
      }
    }
    paramLayout = this.mWeakReference;
    if (paramLayout != null) {
      paramLayout = (VText)paramLayout.get();
    }
  }
  
  public void setTextLayout(Layout paramLayout, float paramFloat1, float paramFloat2)
  {
    setTextLayout(paramLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.VTextView
 * JD-Core Version:    0.7.0.1
 */