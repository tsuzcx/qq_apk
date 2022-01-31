package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjle;
import java.io.Serializable;
import java.util.ArrayList;

public class QCirclePublishPictureTagInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<QCirclePublishPictureTagInfo> CREATOR = new bjle();
  public String picId;
  public ArrayList<String> picTags;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.picId);
    paramParcel.writeList(this.picTags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.model.QCirclePublishPictureTagInfo
 * JD-Core Version:    0.7.0.1
 */