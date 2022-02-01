package cooperation.qzone.plugin;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PluginRecord$1
  implements Parcelable.Creator<PluginRecord>
{
  public PluginRecord createFromParcel(Parcel paramParcel)
  {
    return new PluginRecord(paramParcel);
  }
  
  public PluginRecord[] newArray(int paramInt)
  {
    return new PluginRecord[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginRecord.1
 * JD-Core Version:    0.7.0.1
 */