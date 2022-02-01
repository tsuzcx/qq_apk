package com.tencent.mobileqq.dating.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class InputBar
  extends LinearLayout
{
  private ListView a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private boolean g = false;
  private int h;
  private int i;
  private View j;
  private int k = 0;
  private InputBar.IIputBarCallback l;
  
  public InputBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public InputBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.k;
    Object localObject;
    if (paramInt1 == 0)
    {
      this.k = paramInt4;
    }
    else if (paramInt4 == paramInt1)
    {
      localObject = this.l;
      if (localObject != null) {
        ((InputBar.IIputBarCallback)localObject).a();
      }
    }
    if (!this.g) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("inputBar onLayout top is: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("changed is: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.e("InputBar", 4, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 <= 0) {
      return;
    }
    paramInt1 = this.e;
    if (paramInt1 <= 0)
    {
      this.e = paramInt2;
      this.i = paramInt2;
      return;
    }
    if ((paramInt2 != paramInt1) && (paramInt2 == this.i))
    {
      localObject = this.j;
      if (localObject != null) {
        this.a.removeFooterView((View)localObject);
      }
      this.e = paramInt2;
      return;
    }
    if ((paramInt2 != this.e) && (paramInt2 != this.i))
    {
      getHandler().post(new InputBar.1(this, paramInt2));
      this.e = paramInt2;
    }
  }
  
  public void setmCallback(InputBar.IIputBarCallback paramIIputBarCallback)
  {
    this.l = paramIIputBarCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.InputBar
 * JD-Core Version:    0.7.0.1
 */