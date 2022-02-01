package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.MultiImageTextView;

public class AccountOnlineStatusFormSimpleItem
  extends FormSimpleItem
{
  public AccountOnlineStatusFormSimpleItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public AccountOnlineStatusFormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    super.a();
    this.a.setCompoundDrawablePadding(AIOUtils.dp2px(12.0F, getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AccountOnlineStatusFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */