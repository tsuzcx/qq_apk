package cooperation.qzone.plugin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bjkh;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginRecord
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<PluginRecord> CREATOR = new bjkh();
  public static final String LIVE_PLUGIN_ID = "qzone_live_video_plugin_hack.apk";
  public static final String QZONE_LIVE_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzonelive";
  public static final String QZONE_VIDEO_VERTICAL_LAYER_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzone";
  public static final String QZONE_WEISHI_FEEDS_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzonelive";
  public static final int STATE_DOWNLOADED = 2;
  public static final int STATE_DOWNLOADING = 1;
  public static final int STATE_INSTALLED = 4;
  public static final int STATE_INSTALLING = 3;
  public static final int STATE_NODOWNLOAD = 0;
  public static final String VERTICAL_VIDEO_LAYER_PLUGIN_ID = "qzone_vertical_video_plugin.apk";
  public static final String VERTICAL_VIDEO_PLUGIN_NAME = "QZoneVerticalVideo";
  public static final String WEISHI_FEEDS_PLUGIN_ID = "qzone_weishi_feeds_plugin.apk";
  public static final String WEISHI_FEEDS_PLUGIN_NAME = "QZoneWeishiFeedsVideo";
  public int actype;
  public String app = "";
  public String id = "";
  boolean loaded = false;
  public String mInstalledPath;
  public String mProcesses;
  public String mainVersion = "";
  public String md5 = "";
  public String md5_2 = "";
  public String name = "";
  public String old_ver = "";
  public float progress;
  public long size;
  public int state;
  public String url = "";
  public String ver = "";
  
  public PluginRecord() {}
  
  public PluginRecord(Parcel paramParcel)
  {
    this.state = paramParcel.readInt();
    this.progress = paramParcel.readFloat();
    this.url = paramParcel.readString();
    this.app = paramParcel.readString();
    this.ver = paramParcel.readString();
    this.name = paramParcel.readString();
    this.id = paramParcel.readString();
    this.mainVersion = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.actype = paramParcel.readInt();
    this.size = paramParcel.readLong();
    this.mProcesses = paramParcel.readString();
    this.mInstalledPath = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.loaded = bool;
    this.old_ver = paramParcel.readString();
    this.md5_2 = paramParcel.readString();
  }
  
  public PluginRecord(PluginRecord paramPluginRecord)
  {
    this.state = paramPluginRecord.state;
    this.progress = paramPluginRecord.progress;
    this.url = paramPluginRecord.url;
    this.app = paramPluginRecord.app;
    this.ver = paramPluginRecord.ver;
    this.name = paramPluginRecord.name;
    this.id = paramPluginRecord.id;
    this.mainVersion = paramPluginRecord.mainVersion;
    this.md5 = paramPluginRecord.md5;
    this.actype = paramPluginRecord.actype;
    this.size = paramPluginRecord.size;
    this.mProcesses = paramPluginRecord.mProcesses;
    this.mInstalledPath = paramPluginRecord.mInstalledPath;
    this.loaded = paramPluginRecord.loaded;
    this.old_ver = paramPluginRecord.old_ver;
    this.md5_2 = paramPluginRecord.md5_2;
  }
  
  private static boolean equals(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  public PluginRecord clone()
  {
    return new PluginRecord(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PluginRecord))) {}
    do
    {
      return false;
      paramObject = (PluginRecord)paramObject;
    } while ((this.actype != paramObject.actype) || (!equals(this.url, paramObject.url)) || (!equals(this.app, paramObject.app)) || (!equals(this.ver, paramObject.ver)) || (!equals(this.name, paramObject.name)) || (!equals(this.id, paramObject.id)) || (!equals(this.mainVersion, paramObject.mainVersion)) || (!equals(this.md5, paramObject.md5)) || (!equals(this.old_ver, paramObject.old_ver)) || (!equals(this.md5_2, paramObject.md5_2)));
    return true;
  }
  
  public void fromJson(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "fromJson :" + paramString);
      }
      paramString = new JSONObject(paramString);
      this.state = paramString.optInt("state");
      this.progress = ((float)paramString.optDouble("progress", 0.0D));
      this.url = paramString.optString("url");
      this.app = paramString.optString("app");
      this.ver = paramString.optString("ver");
      this.name = paramString.optString("name");
      this.id = paramString.optString("id");
      this.mainVersion = paramString.optString("mainVersion");
      this.md5 = paramString.optString("md5");
      this.mProcesses = paramString.optString("mProcesses");
      this.mInstalledPath = paramString.optString("mInstalledPath");
      this.old_ver = paramString.optString("old_ver");
      this.md5_2 = paramString.optString("md5_2");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.id == null)
    {
      i = 0;
      if (this.ver != null) {
        break label40;
      }
    }
    for (;;)
    {
      return (i + 527) * 31 + j;
      i = this.id.hashCode();
      break;
      label40:
      j = this.ver.hashCode();
    }
  }
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(this.id);
  }
  
  public void reset()
  {
    this.state = 0;
    this.progress = 0.0F;
    this.url = "";
    this.app = "";
    this.ver = "";
    this.name = "";
    this.id = "";
    this.mainVersion = "";
    this.md5 = "";
    this.mProcesses = "";
    this.mInstalledPath = "";
    this.old_ver = "";
    this.md5_2 = "";
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.state);
      localJSONObject.put("progress", this.progress);
      localJSONObject.put("url", this.url);
      localJSONObject.put("app", this.app);
      localJSONObject.put("ver", this.ver);
      localJSONObject.put("name", this.name);
      localJSONObject.put("id", this.id);
      localJSONObject.put("mainVersion", this.mainVersion);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("mProcesses", this.mProcesses);
      localJSONObject.put("mInstalledPath", this.mInstalledPath);
      localJSONObject.put("old_ver", this.old_ver);
      localJSONObject.put("md5_2", this.md5_2);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "toJson :" + localJSONObject);
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PluginRecord", 1, localJSONException, new Object[0]);
      }
    }
  }
  
  public String toString()
  {
    return "PluginRecord{" + this.id + " " + this.ver + " " + this.state + " }";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.state);
    paramParcel.writeFloat(this.progress);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.app);
    paramParcel.writeString(this.ver);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.mainVersion);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.actype);
    paramParcel.writeLong(this.size);
    paramParcel.writeString(this.mProcesses);
    paramParcel.writeString(this.mInstalledPath);
    if (this.loaded) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.old_ver);
      paramParcel.writeString(this.md5_2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginRecord
 * JD-Core Version:    0.7.0.1
 */