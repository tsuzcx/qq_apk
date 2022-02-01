package cooperation.qzone.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

public class QzonePhotoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QzonePhotoInfo> CREATOR = new QzonePhotoInfo.1();
  public String mAlbumId = "";
  public int mBigHeight;
  public String mBigUrl = "";
  public int mBigWidth;
  public long mShootTime;
  public Map<Integer, String> mShouzhang_extend_map = new HashMap();
  public long mUploadTime;
  public String mlloc = "";
  
  public QzonePhotoInfo() {}
  
  protected QzonePhotoInfo(Parcel paramParcel)
  {
    this.mAlbumId = paramParcel.readString();
    this.mBigUrl = paramParcel.readString();
    this.mBigWidth = paramParcel.readInt();
    this.mBigHeight = paramParcel.readInt();
    this.mlloc = paramParcel.readString();
    this.mShouzhang_extend_map = paramParcel.readHashMap(Map.class.getClassLoader());
    this.mShootTime = paramParcel.readLong();
    this.mUploadTime = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAlbumId);
    paramParcel.writeString(this.mBigUrl);
    paramParcel.writeInt(this.mBigWidth);
    paramParcel.writeInt(this.mBigHeight);
    paramParcel.writeString(this.mlloc);
    paramParcel.writeMap(this.mShouzhang_extend_map);
    paramParcel.writeLong(this.mShootTime);
    paramParcel.writeLong(this.mUploadTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.album.QzonePhotoInfo
 * JD-Core Version:    0.7.0.1
 */