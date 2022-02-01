package com.tencent.mobileqq.widget;

import android.os.Handler;

public class WebViewProgressBarController
{
  private byte jdField_a_of_type_Byte = -1;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new WebViewProgressBarController.MainThreadHandler(this);
  protected WebViewProgressBar a;
  public boolean a;
  private byte jdField_b_of_type_Byte = 6;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 255;
  private boolean jdField_b_of_type_Boolean = false;
  private float c;
  private float d;
  private float e;
  
  public WebViewProgressBarController()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private long a(long paramLong)
  {
    long l = paramLong;
    if (paramLong > 30L) {
      l = 30L;
    }
    return l;
  }
  
  public byte a()
  {
    return this.jdField_b_of_type_Byte;
  }
  
  public float a()
  {
    return this.e;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    int j = WebViewProgressBarController.DurationGenerator.a(0).b();
    int i = j;
    if (j <= 0) {
      i = WebViewProgressBarController.DurationGenerator.a(0).a();
    }
    this.c = (20.0F / i);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_b_of_type_Byte = 0;
    this.e = this.d;
    this.jdField_b_of_type_Int = 255;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    WebViewProgressBar localWebViewProgressBar = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
    if (localWebViewProgressBar != null) {
      localWebViewProgressBar.setVisibility(0);
    }
    e();
  }
  
  public void a(byte paramByte)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramByte != 0)
    {
      if (paramByte != 1)
      {
        if (paramByte != 2) {
          return;
        }
        paramByte = this.jdField_a_of_type_Byte;
        if ((paramByte == 0) || (paramByte == 1)) {
          c();
        }
        this.jdField_a_of_type_Byte = 2;
        return;
      }
      b();
      return;
    }
    if (this.jdField_a_of_type_Byte == 0) {
      return;
    }
    this.jdField_a_of_type_Byte = 0;
    a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(WebViewProgressBar paramWebViewProgressBar)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = paramWebViewProgressBar;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_Byte != 2) {
        a((byte)2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public byte b()
  {
    return this.jdField_a_of_type_Byte;
  }
  
  public void b()
  {
    WebViewProgressBarController.DurationGenerator.a(0).a();
    int j = WebViewProgressBarController.DurationGenerator.a(1).b();
    int i = j;
    if (j <= 0) {
      i = WebViewProgressBarController.DurationGenerator.a(1).a();
    }
    this.c = (60.0F / i);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Byte = 2;
    this.jdField_a_of_type_Byte = 1;
    e();
  }
  
  public void c()
  {
    WebViewProgressBarController.DurationGenerator.a(1).a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Byte = 5;
    this.c = 0.1333333F;
    float f = this.jdField_b_of_type_Float;
    if (f <= 60.0F)
    {
      this.c = (((60.0F - f) * 0.5F + 40.0F) / 300.0F);
      this.jdField_a_of_type_Float = 0.8166667F;
    }
    else
    {
      this.jdField_a_of_type_Float = (this.c * 245.0F / (100.0F - f));
    }
    e();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Byte = 6;
    this.jdField_b_of_type_Float = 0.0F;
    this.d = ((int)(this.jdField_b_of_type_Float * this.jdField_a_of_type_Int / 100.0F));
    this.jdField_b_of_type_Int = 255;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Byte != 6)
    {
      long l1 = System.currentTimeMillis();
      float f1 = this.jdField_b_of_type_Float;
      if (f1 >= 100.0F)
      {
        d();
      }
      else
      {
        int i = this.jdField_b_of_type_Byte;
        long l2;
        float f2;
        float f3;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4)
                {
                  if (i == 5)
                  {
                    l2 = a(l1 - this.jdField_a_of_type_Long);
                    f1 = this.jdField_b_of_type_Float;
                    f2 = (float)l2;
                    this.jdField_b_of_type_Float = (f1 + this.c * f2);
                    this.jdField_a_of_type_Long = l1;
                    i = this.jdField_a_of_type_Int;
                    this.e = (i * this.jdField_b_of_type_Float / 100.0F);
                    if (this.jdField_b_of_type_Boolean)
                    {
                      if (this.e >= i) {
                        this.e = i;
                      }
                    }
                    else
                    {
                      this.jdField_b_of_type_Int -= (int)(f2 * this.jdField_a_of_type_Float);
                      if (this.jdField_b_of_type_Int <= 0)
                      {
                        d();
                        this.jdField_b_of_type_Int = 0;
                      }
                    }
                  }
                }
                else {
                  this.e = (this.jdField_a_of_type_Int * f1 / 100.0F);
                }
              }
              else
              {
                l2 = a(l1 - this.jdField_a_of_type_Long);
                this.jdField_b_of_type_Float += (float)l2 * this.c;
                this.jdField_a_of_type_Long = l1;
                if (this.jdField_b_of_type_Float >= 98.0F)
                {
                  this.jdField_a_of_type_Long = l1;
                  this.jdField_b_of_type_Byte = 4;
                  this.c = 0.0F;
                }
                this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
              }
            }
            else
            {
              l2 = a(l1 - this.jdField_a_of_type_Long);
              f1 = this.jdField_b_of_type_Float;
              f2 = (float)l2;
              f3 = this.c;
              this.jdField_b_of_type_Float = (f1 + f2 * f3);
              this.jdField_a_of_type_Long = l1;
              if (this.jdField_b_of_type_Float >= 80.0F)
              {
                this.jdField_a_of_type_Long = l1;
                this.jdField_b_of_type_Byte = 3;
                this.c = (f3 / 20.0F);
              }
              this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
            }
          }
          else
          {
            l2 = a(l1 - this.jdField_a_of_type_Long);
            this.jdField_b_of_type_Float += (float)l2 * this.c;
            this.jdField_a_of_type_Long = l1;
            if (this.jdField_b_of_type_Float >= 98.0F)
            {
              this.jdField_a_of_type_Long = l1;
              this.jdField_b_of_type_Byte = 4;
              this.jdField_b_of_type_Float = 98.0F;
              this.c = 0.0F;
            }
            this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
          }
        }
        else
        {
          l2 = a(l1 - this.jdField_a_of_type_Long);
          f1 = this.jdField_b_of_type_Float;
          f2 = (float)l2;
          f3 = this.c;
          this.jdField_b_of_type_Float = (f1 + f2 * f3);
          this.jdField_a_of_type_Long = l1;
          if (this.jdField_b_of_type_Float >= 20.0F)
          {
            this.jdField_a_of_type_Long = l1;
            this.jdField_b_of_type_Byte = 1;
            this.c = (f3 / 5.0F);
          }
          this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(200);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(200, 20L);
    }
    WebViewProgressBar localWebViewProgressBar = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
    if (localWebViewProgressBar != null) {
      localWebViewProgressBar.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBarController
 * JD-Core Version:    0.7.0.1
 */