package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView.ScrollInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.web.view.BaseNestScrollWebView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MiniGamePublicAccountWebView
  extends BaseNestScrollWebView
{
  public static final int HEAD_HEIGHT_DB = 419;
  public static final int TITLE_HEIGHT_DB = 44;
  private CustomWebView.ScrollInterface mCustomScrollInterface;
  private int mHeadHeight = 419;
  
  public MiniGamePublicAccountWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MiniGamePublicAccountWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onPageFinish(String paramString)
  {
    setPaddingTop(AIOUtils.a(AIOUtils.a(ImmersiveUtils.getStatusBarHeight(getContext()), getContext().getResources()) + (this.mHeadHeight + 44), getResources()));
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    if (this.mCustomScrollInterface != null) {
      this.mCustomScrollInterface.onSChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setHeadHeight(int paramInt)
  {
    this.mHeadHeight = paramInt;
  }
  
  public void setPaddingTop(int paramInt)
  {
    super.setPaddingTop(paramInt);
  }
  
  public void setScrollInterface(CustomWebView.ScrollInterface paramScrollInterface)
  {
    this.mCustomScrollInterface = paramScrollInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebView
 * JD-Core Version:    0.7.0.1
 */