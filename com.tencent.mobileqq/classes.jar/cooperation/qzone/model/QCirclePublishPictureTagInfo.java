package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bnap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class QCirclePublishPictureTagInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<QCirclePublishPictureTagInfo> CREATOR = new bnap();
  public HashMap<String, String> exif;
  public String filterId = "";
  public String materialId = "";
  public String picId = "";
  public ArrayList<String> picTags = new ArrayList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.picId);
    paramParcel.writeList(this.picTags);
    paramParcel.writeString(this.materialId);
    paramParcel.writeString(this.filterId);
    paramParcel.writeSerializable(this.exif);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.QCirclePublishPictureTagInfo
 * JD-Core Version:    0.7.0.1
 */