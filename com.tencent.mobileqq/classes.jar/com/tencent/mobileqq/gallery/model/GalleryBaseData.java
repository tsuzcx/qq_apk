package com.tencent.mobileqq.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aqmk;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;

public abstract class GalleryBaseData
  implements Parcelable
{
  public static final Parcelable.Creator<GalleryBaseData> CREATOR = new aqmk();
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  
  public static GalleryBaseData a(String paramString)
  {
    if (AIOPicData.class.getSimpleName().equals(paramString)) {
      return new AIOPicData();
    }
    if (AIOShortVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOShortVideoData();
    }
    if (AIOFilePicData.class.getSimpleName().equals(paramString)) {
      return new AIOFilePicData();
    }
    if (AIOFileVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOFileVideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public abstract int a();
  
  public void a(int paramInt) {}
  
  public void a(Parcel paramParcel)
  {
    boolean bool2 = true;
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
        break label101;
      }
      bool1 = true;
      label75:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label106;
      }
    }
    label101:
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label75;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(getClass().getSimpleName());
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
        break label109;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label114;
      }
    }
    label109:
    label114:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.model.GalleryBaseData
 * JD-Core Version:    0.7.0.1
 */