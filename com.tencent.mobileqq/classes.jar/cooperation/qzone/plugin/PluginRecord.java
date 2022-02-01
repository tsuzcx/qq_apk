package cooperation.qzone.plugin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginRecord
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<PluginRecord> CREATOR = new PluginRecord.1();
  public int actype;
  public String app;
  public String id;
  boolean loaded;
  public String mInstalledPath;
  public String mProcesses;
  public String mainVersion;
  public String md5;
  public String md5_2;
  public String name;
  public String old_ver;
  public float progress;
  public long size;
  public int state;
  public String url;
  public String ver;
  
  public PluginRecord()
  {
    this.state = 0;
    this.progress = 0.0F;
    this.url = "";
    this.app = "";
    this.ver = "";
    this.old_ver = "";
    this.name = "";
    this.id = "";
    this.mainVersion = "";
    this.md5 = "";
    this.md5_2 = "";
    this.actype = 0;
    this.loaded = false;
  }
  
  protected PluginRecord(Parcel paramParcel)
  {
    boolean bool = false;
    this.state = 0;
    this.progress = 0.0F;
    this.url = "";
    this.app = "";
    this.ver = "";
    this.old_ver = "";
    this.name = "";
    this.id = "";
    this.mainVersion = "";
    this.md5 = "";
    this.md5_2 = "";
    this.actype = 0;
    this.loaded = false;
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
    this.state = 0;
    this.progress = 0.0F;
    this.url = "";
    this.app = "";
    this.ver = "";
    this.old_ver = "";
    this.name = "";
    this.id = "";
    this.mainVersion = "";
    this.md5 = "";
    this.md5_2 = "";
    this.actype = 0;
    this.loaded = false;
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
  
  protected PluginRecord clone()
  {
    return new PluginRecord(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof PluginRecord)) {
        return false;
      }
      paramObject = (PluginRecord)paramObject;
      bool1 = bool2;
      if (this.actype == paramObject.actype)
      {
        bool1 = bool2;
        if (equals(this.url, paramObject.url))
        {
          bool1 = bool2;
          if (equals(this.app, paramObject.app))
          {
            bool1 = bool2;
            if (equals(this.ver, paramObject.ver))
            {
              bool1 = bool2;
              if (equals(this.name, paramObject.name))
              {
                bool1 = bool2;
                if (equals(this.id, paramObject.id))
                {
                  bool1 = bool2;
                  if (equals(this.mainVersion, paramObject.mainVersion))
                  {
                    bool1 = bool2;
                    if (equals(this.md5, paramObject.md5))
                    {
                      bool1 = bool2;
                      if (equals(this.old_ver, paramObject.old_ver))
                      {
                        bool1 = bool2;
                        if (equals(this.md5_2, paramObject.md5_2)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void fromJson(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fromJson :");
        localStringBuilder.append(paramString);
        QLog.d("QZonePluginManger", 2, localStringBuilder.toString());
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
    String str = this.id;
    int j = 0;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    str = this.ver;
    if (str != null) {
      j = str.hashCode();
    }
    return (527 + i) * 31 + j;
  }
  
  public boolean isValid()
  {
    return TextUtils.isEmpty(this.id) ^ true;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("toJson :");
        localStringBuilder.append(localJSONObject);
        QLog.d("QZonePluginManger", 2, localStringBuilder.toString());
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PluginRecord", 1, localJSONException, new Object[0]);
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PluginRecord{");
    localStringBuilder.append(this.id);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.ver);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.state);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
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
    paramParcel.writeByte((byte)this.loaded);
    paramParcel.writeString(this.old_ver);
    paramParcel.writeString(this.md5_2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginRecord
 * JD-Core Version:    0.7.0.1
 */