package com.tencent.mobileqq.gallery.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import aqml;
import aqng;
import aqpn;

public class GalleryBaseAdapter
  extends BaseAdapter
{
  aqng jdField_a_of_type_Aqng;
  private aqpn jdField_a_of_type_Aqpn;
  
  private aqpn a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aqng != null) && (this.jdField_a_of_type_Aqng.a != null) && (paramInt == this.jdField_a_of_type_Aqng.a.b())) {
      return this.jdField_a_of_type_Aqpn;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aqpn localaqpn = a(paramInt1);
    if (localaqpn != null) {
      localaqpn.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    aqpn localaqpn = a(paramInt);
    if (localaqpn != null) {
      localaqpn.c();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(aqng paramaqng)
  {
    this.jdField_a_of_type_Aqng = paramaqng;
  }
  
  public void a(aqpn paramaqpn)
  {
    this.jdField_a_of_type_Aqpn = paramaqpn;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Aqng == null) || (this.jdField_a_of_type_Aqng.a == null)) {
      return 0;
    }
    return this.jdField_a_of_type_Aqng.a.a();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_Aqng == null) || (this.jdField_a_of_type_Aqng.a == null)) {
      return null;
    }
    return this.jdField_a_of_type_Aqng.a.a(paramInt);
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