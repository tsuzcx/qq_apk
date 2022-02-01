package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

public class MiniGamePublicAccountNavBar
  extends NavBarCommon
{
  private TextView mTitleTv;
  
  public MiniGamePublicAccountNavBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public MiniGamePublicAccountNavBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MiniGamePublicAccountNavBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public TextView getTitleTextView()
  {
    if (this.mTitleTv == null) {
      this.mTitleTv = ((TextView)findViewById(2131436227));
    }
    if (this.mTitleTv == null) {
      this.mTitleTv = new TextView(getContext());
    }
    return this.mTitleTv;
  }
  
  public void setTitleBarTransparent()
  {
    setBackgroundResource(2131168376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountNavBar
 * JD-Core Version:    0.7.0.1
 */