package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bnae;
import cooperation.qzone.widget.RedTouchExtendButton.RedInfo;

public class DiscoverTab
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoverTab> CREATOR = new bnae();
  public int a;
  public RedTouchExtendButton.RedInfo a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  
  public DiscoverTab() {}
  
  public DiscoverTab(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo = ((RedTouchExtendButton.RedInfo)paramParcel.readParcelable(getClass().getClassLoader()));
    this.c = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label108;
      }
    }
    label108:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.d = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo, 0);
    paramParcel.writeString(this.c);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label93;
      }
    }
    label93:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.d);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.DiscoverTab
 * JD-Core Version:    0.7.0.1
 */