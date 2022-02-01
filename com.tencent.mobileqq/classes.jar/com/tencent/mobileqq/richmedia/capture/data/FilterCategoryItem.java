package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import baah;
import baao;
import java.util.ArrayList;

public class FilterCategoryItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<FilterCategoryItem> CREATOR = new baao();
  public int a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  
  public FilterCategoryItem()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public FilterCategoryItem(Parcel paramParcel)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.g = paramParcel.readString();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label215;
      }
    }
    label215:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.j = paramParcel.readString();
      this.k = paramParcel.readString();
      this.l = paramParcel.readString();
      this.m = paramParcel.readString();
      this.n = paramParcel.readString();
      this.o = paramParcel.readString();
      this.p = paramParcel.readString();
      paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public FilterCategoryItem a()
  {
    try
    {
      FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)super.clone();
      return localFilterCategoryItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public FilterDesc a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return baah.a().a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    return null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains("EMPTY"));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.hashCode() != hashCode()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.intern().hashCode();
  }
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      if (!this.jdField_b_of_type_Boolean) {
        break label193;
      }
    }
    label193:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.j);
      paramParcel.writeString(this.k);
      paramParcel.writeString(this.l);
      paramParcel.writeString(this.m);
      paramParcel.writeString(this.n);
      paramParcel.writeString(this.o);
      paramParcel.writeString(this.p);
      paramParcel.writeInt(0);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem
 * JD-Core Version:    0.7.0.1
 */