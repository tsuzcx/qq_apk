package dov.com.qq.im.ptv;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.MotionEvent;
import boqw;

public class LWMotionEvent
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<LWMotionEvent> CREATOR = new boqw();
  public float a;
  public int a;
  public float b;
  public int b;
  
  public LWMotionEvent()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  private LWMotionEvent(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_b_of_type_Float = paramParcel.readFloat();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Int = (paramMotionEvent.getAction() & 0xFF);
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    this.jdField_b_of_type_Int = 0;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LWMotionEvent
 * JD-Core Version:    0.7.0.1
 */