package com.tencent.viola.ui.dom;

import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.view.VTextView;

public class VImgSpan
  extends ImageSpan
{
  private DomObjectText domObjectText;
  private boolean mLoaded = false;
  private VTextView mTv;
  
  public VImgSpan(DomObjectText paramDomObjectText, Drawable paramDrawable, String paramString, int paramInt)
  {
    super(paramDrawable, paramString, paramInt);
    this.domObjectText = paramDomObjectText;
  }
  
  public void loadUrl(String paramString, int paramInt1, int paramInt2)
  {
    ImageAdapterHolder localImageAdapterHolder = new ImageAdapterHolder();
    localImageAdapterHolder.setImgSpanListener(new VImgSpan.1(this));
    VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
    if (localVComponentAdapter != null) {
      localVComponentAdapter.setImgSpan(paramString, paramInt1, paramInt2, localImageAdapterHolder);
    }
  }
  
  public void setTv(VTextView paramVTextView)
  {
    if (!this.mLoaded) {
      this.mTv = paramVTextView;
    }
  }
  
  public void updateMeasureState(TextPaint paramTextPaint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.VImgSpan
 * JD-Core Version:    0.7.0.1
 */