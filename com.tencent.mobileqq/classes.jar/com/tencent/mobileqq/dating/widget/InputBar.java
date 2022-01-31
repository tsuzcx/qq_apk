package com.tencent.mobileqq.dating.widget;

import abqw;
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
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public InputBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public InputBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  @TargetApi(11)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h == 0) {
      this.h = paramInt4;
    }
    do
    {
      do
      {
        while (!this.jdField_a_of_type_Boolean)
        {
          return;
          if ((paramInt4 == this.h) && (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback != null)) {
            this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback.a();
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.e("InputBar", 4, "inputBar onLayout top is: " + paramInt2 + "changed is: " + paramBoolean);
        }
      } while (paramInt2 <= 0);
      if (this.d <= 0)
      {
        this.d = paramInt2;
        this.g = paramInt2;
        return;
      }
      if ((paramInt2 != this.d) && (paramInt2 == this.g))
      {
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
        }
        this.d = paramInt2;
        return;
      }
    } while ((paramInt2 == this.d) || (paramInt2 == this.g));
    getHandler().post(new abqw(this, paramInt2));
    this.d = paramInt2;
  }
  
  public void setmCallback(InputBar.IIputBarCallback paramIIputBarCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback = paramIIputBarCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.InputBar
 * JD-Core Version:    0.7.0.1
 */