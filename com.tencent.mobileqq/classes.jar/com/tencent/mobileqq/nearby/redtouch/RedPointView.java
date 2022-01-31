package com.tencent.mobileqq.nearby.redtouch;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.ArrayList;
import java.util.List;

public class RedPointView
  extends FrameLayout
{
  protected static int e = 1;
  protected int a;
  protected Context a;
  protected Handler a;
  protected View a;
  protected List<BusinessInfoCheckUpdate.RedTypeInfo> a;
  protected boolean a;
  protected int b;
  protected int c;
  protected int d;
  protected int f = 21;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  
  public RedPointView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedPointView(Context paramContext, View paramView)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  private void a()
  {
    this.k = this.f;
    this.l = this.g;
    this.m = this.h;
    this.n = this.i;
    this.o = this.j;
    this.p = 99;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = 10;
    this.b = 20;
    this.c = 30;
    this.d = 40;
  }
  
  public void setMaxNum(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedPointView
 * JD-Core Version:    0.7.0.1
 */