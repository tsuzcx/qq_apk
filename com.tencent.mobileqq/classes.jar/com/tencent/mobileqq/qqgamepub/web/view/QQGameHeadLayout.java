package com.tencent.mobileqq.qqgamepub.web.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class QQGameHeadLayout
  extends BaseNestHeaderLayout
{
  public QQGameHeadLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QQGameHeadLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a() {}
  
  protected int getLayoutId()
  {
    return 2131624901;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.view.QQGameHeadLayout
 * JD-Core Version:    0.7.0.1
 */