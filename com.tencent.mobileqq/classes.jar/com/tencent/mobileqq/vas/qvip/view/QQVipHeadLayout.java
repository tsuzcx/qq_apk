package com.tencent.mobileqq.vas.qvip.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.qqgamepub.web.view.BaseNestHeaderLayout;

public class QQVipHeadLayout
  extends BaseNestHeaderLayout
{
  public QQVipHeadLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QQVipHeadLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a() {}
  
  protected int getLayoutId()
  {
    return 2131628224;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipHeadLayout
 * JD-Core Version:    0.7.0.1
 */