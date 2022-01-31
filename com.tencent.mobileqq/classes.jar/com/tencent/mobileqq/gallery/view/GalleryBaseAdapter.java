package com.tencent.mobileqq.gallery.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import aqmj;
import aqne;
import aqpl;

public class GalleryBaseAdapter
  extends BaseAdapter
{
  aqne jdField_a_of_type_Aqne;
  private aqpl jdField_a_of_type_Aqpl;
  
  private aqpl a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aqne != null) && (this.jdField_a_of_type_Aqne.a != null) && (paramInt == this.jdField_a_of_type_Aqne.a.b())) {
      return this.jdField_a_of_type_Aqpl;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aqpl localaqpl = a(paramInt1);
    if (localaqpl != null) {
      localaqpl.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    aqpl localaqpl = a(paramInt);
    if (localaqpl != null) {
      localaqpl.c();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(aqne paramaqne)
  {
    this.jdField_a_of_type_Aqne = paramaqne;
  }
  
  public void a(aqpl paramaqpl)
  {
    this.jdField_a_of_type_Aqpl = paramaqpl;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Aqne == null) || (this.jdField_a_of_type_Aqne.a == null)) {
      return 0;
    }
    return this.jdField_a_of_type_Aqne.a.a();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_Aqne == null) || (this.jdField_a_of_type_Aqne.a == null)) {
      return null;
    }
    return this.jdField_a_of_type_Aqne.a.a(paramInt);
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