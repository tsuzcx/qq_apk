package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.gamecenter.web.view.BaseNestHeaderLayout;

public class MiniGamePublicAccountHeadLayout
  extends BaseNestHeaderLayout
{
  public MiniGamePublicAccountHeadLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public MiniGamePublicAccountHeadLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void initView() {}
  
  public int getLayoutId()
  {
    return 2131559423;
  }
  
  public boolean isPined()
  {
    return false;
  }
  
  public boolean isShow(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHeadLayout
 * JD-Core Version:    0.7.0.1
 */