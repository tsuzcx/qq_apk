package com.tencent.mobileqq.richmediabrowser;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import axtm;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public abstract class AIOBrowserBaseData
  extends RichMediaBaseData
{
  public static final Parcelable.Creator<AIOBrowserBaseData> CREATOR = new axtm();
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  
  public static AIOBrowserBaseData a(String paramString)
  {
    if (AIOPictureData.class.getSimpleName().equals(paramString)) {
      return new AIOPictureData();
    }
    if (AIOVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOVideoData();
    }
    if (AIOFilePictureData.class.getSimpleName().equals(paramString)) {
      return new AIOFilePictureData();
    }
    if (AIOFileVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOFileVideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    super.readFromParcel(paramParcel);
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label106;
      }
      bool1 = true;
      label80:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label111;
      }
    }
    label106:
    label111:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.d);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label104;
      }
      paramInt = 1;
      label79:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label109;
      }
    }
    label104:
    label109:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData
 * JD-Core Version:    0.7.0.1
 */