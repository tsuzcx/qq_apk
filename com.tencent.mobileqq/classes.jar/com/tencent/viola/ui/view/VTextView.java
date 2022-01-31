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
    if (this.mWeakReference != null) {
      return (VText)this.mWeakReference.get();
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
    if ((getComponent() == null) || (getComponent().getDomObject() == null))
    {
      paramCanvas = new StringBuilder().append("getComponent() ==  null ||  getComponent().getDomObject() == null : ");
      if (getComponent() == null) {}
      for (boolean bool = true;; bool = false)
      {
        ViolaLogUtils.e("VTextView", bool);
        return;
      }
    }
    StyleSpace localStyleSpace = getComponent().getDomObject().getPadding();
    Layout localLayout2 = getTextLayout();
    Layout localLayout1 = localLayout2;
    if (localLayout2 == null)
    {
      localLayout1 = localLayout2;
      if (getComponent() != null)
      {
        localLayout1 = localLayout2;
        if ((getComponent().getDomObject() instanceof DomObjectText))
        {
          ((DomObjectText)getComponent().getDomObject()).recalculateLayout();
          ((DomObjectText)getComponent().getDomObject()).swap();
          getComponent().updateExtra(getComponent().getDomObject().getExtra());
          localLayout1 = getTextLayout();
        }
      }
    }
    if (localLayout1 != null)
    {
      if (localStyleSpace != null) {
        paramCanvas.translate(localStyleSpace.get(0), localStyleSpace.get(1));
      }
      localLayout1.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      if (getComponent().getDomObject() != null) {
        ViolaLogUtils.e("VTextView", "layout null domObject :" + getComponent().getDomObject().toString());
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsRich) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      setHighlightColor(Color.parseColor("#22000000"));
      continue;
      setHighlightColor(getResources().getColor(17170445));
    }
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
        if ((getComponent() != null) && (getComponent().getDomObject() != null) && ((getComponent().getDomObject() instanceof DomObjectText)))
        {
          paramLayout = (DomObjectText)getComponent().getDomObject();
          if (paramLayout.isRichClickable)
          {
            setFocusable(false);
            setMovementMethod(LinkMovementMethod.getInstance());
          }
          paramLayout.imgSpanSetTv(this);
        }
        paramLayout = getComponent().getDomObject().getPadding();
        if (paramLayout != null) {
          setPadding((int)paramLayout.get(0), (int)paramLayout.get(1), (int)paramLayout.get(2), (int)paramLayout.get(3));
        }
        setHighlightColor(Color.parseColor("#22000000"));
      }
    }
    if ((this.mWeakReference != null) && ((VText)this.mWeakReference.get() != null)) {}
  }
  
  public void setTextLayout(Layout paramLayout, float paramFloat1, float paramFloat2)
  {
    setTextLayout(paramLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.VTextView
 * JD-Core Version:    0.7.0.1
 */