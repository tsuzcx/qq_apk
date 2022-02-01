package com.tencent.mobileqq.qrscan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ScannerParams
  implements Parcelable
{
  public static final Parcelable.Creator<ScannerParams> CREATOR = new ScannerParams.1();
  public int a;
  public ScannerResult a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  
  public ScannerParams() {}
  
  protected ScannerParams(Parcel paramParcel)
  {
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.jdField_d_of_type_Boolean = bool1;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult = ((ScannerResult)paramParcel.readParcelable(ScannerResult.class.getClassLoader()));
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScannerParams { scanForResult: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("  from: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("  fromPicQRDecode: ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("  detectType: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("  preResult: ");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("  preScanResult: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult);
    localStringBuilder.append("  hasCameraSysFeature: ");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("  toDecodeFilePath: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("  qrPhotoPath: ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_c_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_d_of_type_Boolean);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult, paramInt);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ScannerParams
 * JD-Core Version:    0.7.0.1
 */