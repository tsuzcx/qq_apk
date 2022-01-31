package cooperation.qzone.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anmf;

public class RedTouchExtendButton$RedInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new anmf();
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public RedTouchExtendButton$RedInfo() {}
  
  public RedTouchExtendButton$RedInfo(Parcel paramParcel)
  {
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.c = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof RedInfo));
      paramObject = (RedInfo)paramObject;
    } while ((!a(Boolean.valueOf(paramObject.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean))) || (!a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) || (!a(Integer.valueOf(paramObject.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int))) || (!a(paramObject.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString)) || (!a(paramObject.c, this.c)) || (!a(Integer.valueOf(paramObject.jdField_b_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int))));
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeString(this.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widget.RedTouchExtendButton.RedInfo
 * JD-Core Version:    0.7.0.1
 */