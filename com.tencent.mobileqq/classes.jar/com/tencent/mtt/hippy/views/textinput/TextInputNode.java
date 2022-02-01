package com.tencent.mtt.hippy.views.textinput;

import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.a.f;
import com.tencent.mtt.hippy.dom.a.g;
import com.tencent.mtt.hippy.dom.a.g.a;
import com.tencent.mtt.hippy.dom.a.h;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.PixelUtil;

public class TextInputNode
  extends TextNode
  implements g.a
{
  private float[] mComputedPadding;
  private EditText mEditText;
  
  public TextInputNode(boolean paramBoolean)
  {
    super(paramBoolean);
    setMeasureFunction(this);
  }
  
  private int getMeasureSpec(float paramFloat, f paramf)
  {
    if (paramf == f.b) {
      return View.MeasureSpec.makeMeasureSpec((int)paramFloat, 1073741824);
    }
    if (paramf == f.c) {
      return View.MeasureSpec.makeMeasureSpec((int)paramFloat, -2147483648);
    }
    return View.MeasureSpec.makeMeasureSpec(0, 0);
  }
  
  public void layoutAfter(HippyEngineContext paramHippyEngineContext) {}
  
  public void layoutBefore(HippyEngineContext paramHippyEngineContext)
  {
    if (this.mEditText == null)
    {
      this.mEditText = new EditText(ContextHolder.getAppContext());
      this.mEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      setDefaultPadding(4, this.mEditText.getPaddingLeft());
      setDefaultPadding(1, this.mEditText.getPaddingTop());
      setDefaultPadding(5, this.mEditText.getPaddingRight());
      setDefaultPadding(3, this.mEditText.getPaddingBottom());
      this.mComputedPadding = new float[] { getPadding(4), getPadding(1), getPadding(5), getPadding(3) };
    }
  }
  
  public long measure(g paramg, float paramFloat1, f paramf1, float paramFloat2, f paramf2)
  {
    paramg = this.mEditText;
    int i;
    if (this.mFontSize == -1) {
      i = (int)Math.ceil(PixelUtil.dp2px(14.0F));
    } else {
      i = this.mFontSize;
    }
    paramg.setTextSize(0, i);
    this.mComputedPadding = new float[] { getPadding(4), getPadding(1), getPadding(5), getPadding(3) };
    this.mEditText.setPadding((int)Math.floor(getPadding(4)), (int)Math.floor(getPadding(1)), (int)Math.floor(getPadding(5)), (int)Math.floor(getPadding(3)));
    if (this.mNumberOfLines != -1) {
      this.mEditText.setLines(this.mNumberOfLines);
    }
    this.mEditText.measure(getMeasureSpec(paramFloat1, paramf1), getMeasureSpec(paramFloat2, paramf2));
    return h.a(this.mEditText.getMeasuredWidth(), this.mEditText.getMeasuredHeight());
  }
  
  public void setPadding(int paramInt, float paramFloat)
  {
    super.setPadding(paramInt, paramFloat);
    this.mComputedPadding = new float[] { getPadding(4), getPadding(1), getPadding(5), getPadding(3) };
    markUpdated();
  }
  
  public void updateProps(HippyMap paramHippyMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.TextInputNode
 * JD-Core Version:    0.7.0.1
 */