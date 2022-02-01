package com.tencent.open.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

public class ToastUtil
{
  protected static ToastUtil a;
  protected Handler a;
  protected Toast a;
  protected Toast b = null;
  
  public ToastUtil()
  {
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static ToastUtil a()
  {
    if (jdField_a_of_type_ComTencentOpenBaseToastUtil == null) {
      jdField_a_of_type_ComTencentOpenBaseToastUtil = new ToastUtil();
    }
    return jdField_a_of_type_ComTencentOpenBaseToastUtil;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ToastUtil.2(this, paramInt1, paramInt2));
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ToastUtil.3(this, paramView, paramInt));
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ToastUtil.1(this, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil
 * JD-Core Version:    0.7.0.1
 */