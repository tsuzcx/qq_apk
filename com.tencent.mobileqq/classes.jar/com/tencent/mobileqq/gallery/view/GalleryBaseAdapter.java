package com.tencent.mobileqq.gallery.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import apsu;
import aptf;
import apvk;

public class GalleryBaseAdapter
  extends BaseAdapter
{
  aptf jdField_a_of_type_Aptf;
  private apvk jdField_a_of_type_Apvk;
  
  private apvk a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aptf != null) && (this.jdField_a_of_type_Aptf.a != null) && (paramInt == this.jdField_a_of_type_Aptf.a.b())) {
      return this.jdField_a_of_type_Apvk;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    apvk localapvk = a(paramInt1);
    if (localapvk != null) {
      localapvk.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    apvk localapvk = a(paramInt);
    if (localapvk != null) {
      localapvk.c();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(aptf paramaptf)
  {
    this.jdField_a_of_type_Aptf = paramaptf;
  }
  
  public void a(apvk paramapvk)
  {
    this.jdField_a_of_type_Apvk = paramapvk;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Aptf == null) || (this.jdField_a_of_type_Aptf.a == null)) {
      return 0;
    }
    return this.jdField_a_of_type_Aptf.a.a();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_Aptf == null) || (this.jdField_a_of_type_Aptf.a == null)) {
      return null;
    }
    return this.jdField_a_of_type_Aptf.a.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.GalleryBaseAdapter
 * JD-Core Version:    0.7.0.1
 */