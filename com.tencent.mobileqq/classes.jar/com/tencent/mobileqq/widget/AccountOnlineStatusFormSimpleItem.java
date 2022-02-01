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
  
  protected void b()
  {
    super.b();
    this.a.setCompoundDrawablePadding(AIOUtils.a(12.0F, getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AccountOnlineStatusFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */