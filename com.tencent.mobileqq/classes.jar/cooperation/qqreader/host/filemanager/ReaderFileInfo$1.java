package cooperation.qqreader.host.filemanager;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ReaderFileInfo$1
  implements Parcelable.Creator<ReaderFileInfo>
{
  public ReaderFileInfo createFromParcel(Parcel paramParcel)
  {
    return new ReaderFileInfo(paramParcel);
  }
  
  public ReaderFileInfo[] newArray(int paramInt)
  {
    return new ReaderFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.filemanager.ReaderFileInfo.1
 * JD-Core Version:    0.7.0.1
 */