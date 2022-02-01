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
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private InputBar.IIputBarCallback jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  
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
    paramInt1 = this.h;
    Object localObject;
    if (paramInt1 == 0)
    {
      this.h = paramInt4;
    }
    else if (paramInt4 == paramInt1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback;
      if (localObject != null) {
        ((InputBar.IIputBarCallback)localObject).a();
      }
    }
    if (!this.jdField_a_of_type_Boolean) {
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
    paramInt1 = this.d;
    if (paramInt1 <= 0)
    {
      this.d = paramInt2;
      this.g = paramInt2;
      return;
    }
    if ((paramInt2 != paramInt1) && (paramInt2 == this.g))
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView((View)localObject);
      }
      this.d = paramInt2;
      return;
    }
    if ((paramInt2 != this.d) && (paramInt2 != this.g))
    {
      getHandler().post(new InputBar.1(this, paramInt2));
      this.d = paramInt2;
    }
  }
  
  public void setmCallback(InputBar.IIputBarCallback paramIIputBarCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback = paramIIputBarCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.InputBar
 * JD-Core Version:    0.7.0.1
 */