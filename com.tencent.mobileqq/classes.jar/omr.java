import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;

public final class omr
  implements Parcelable.Creator<AnchorData>
{
  public AnchorData a(Parcel paramParcel)
  {
    boolean bool2 = true;
    AnchorData localAnchorData = new AnchorData();
    localAnchorData.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localAnchorData.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localAnchorData.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label67;
      }
    }
    label67:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAnchorData.jdField_b_of_type_Boolean = bool1;
      return localAnchorData;
      bool1 = false;
      break;
    }
  }
  
  public AnchorData[] a(int paramInt)
  {
    return new AnchorData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omr
 * JD-Core Version:    0.7.0.1
 */