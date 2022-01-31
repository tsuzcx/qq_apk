package cooperation.qqreader.host.filemanager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.FileInfo;

public class ReaderFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ReaderFileInfo> CREATOR = new ReaderFileInfo.1();
  public static final String KEY_BUNDLE = "key_reader_file_for_bundle";
  private String a;
  private String b;
  
  protected ReaderFileInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public ReaderFileInfo(FileInfo paramFileInfo)
  {
    this.a = paramFileInfo.c();
    this.b = paramFileInfo.d();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public String getPath()
  {
    return this.a;
  }
  
  public void setName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.filemanager.ReaderFileInfo
 * JD-Core Version:    0.7.0.1
 */