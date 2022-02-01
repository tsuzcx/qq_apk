package com.tencent.mobileqq.kandian.repo.ugc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DeliverData
  implements Parcelable
{
  public static final Parcelable.Creator<DeliverData> CREATOR = new DeliverData.1();
  private static int jdField_a_of_type_Int = 9;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int[] jdField_b_of_type_ArrayOfInt;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  
  public DeliverData()
  {
    int i = jdField_a_of_type_Int;
    this.jdField_a_of_type_ArrayOfInt = new int[i];
    this.jdField_b_of_type_ArrayOfInt = new int[i];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[i];
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[i];
  }
  
  public DeliverData(Parcel paramParcel)
  {
    int i = jdField_a_of_type_Int;
    this.jdField_a_of_type_ArrayOfInt = new int[i];
    this.jdField_b_of_type_ArrayOfInt = new int[i];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[i];
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[i];
    if (paramParcel.readInt() > 0) {
      paramParcel.readIntArray(this.jdField_a_of_type_ArrayOfInt);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readIntArray(this.jdField_b_of_type_ArrayOfInt);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readStringArray(this.jdField_b_of_type_ArrayOfJavaLangString);
    }
  }
  
  public void a()
  {
    int i = jdField_a_of_type_Int;
    this.jdField_a_of_type_ArrayOfInt = new int[i];
    this.jdField_b_of_type_ArrayOfInt = new int[i];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[i];
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[i];
  }
  
  public void a(int paramInt, Integer paramInteger)
  {
    if (paramInt < jdField_a_of_type_Int) {
      this.jdField_a_of_type_ArrayOfInt[paramInt] = paramInteger.intValue();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt < jdField_a_of_type_Int) {
      this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    }
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void b(int paramInt, Integer paramInteger)
  {
    if (paramInt < jdField_a_of_type_Int) {
      this.jdField_b_of_type_ArrayOfInt[paramInt] = paramInteger.intValue();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (paramInt < jdField_a_of_type_Int) {
      this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    }
  }
  
  public int[] b()
  {
    return this.jdField_b_of_type_ArrayOfInt;
  }
  
  public String[] b()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeIntArray(this.jdField_a_of_type_ArrayOfInt);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    localObject = this.jdField_b_of_type_ArrayOfInt;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeIntArray(this.jdField_b_of_type_ArrayOfInt);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    localObject = this.jdField_b_of_type_ArrayOfJavaLangString;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeStringArray(this.jdField_b_of_type_ArrayOfJavaLangString);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.DeliverData
 * JD-Core Version:    0.7.0.1
 */