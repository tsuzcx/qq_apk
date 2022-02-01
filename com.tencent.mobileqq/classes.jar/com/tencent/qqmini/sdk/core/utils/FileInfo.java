package com.tencent.qqmini.sdk.core.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;
import java.io.FileNotFoundException;

public class FileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FileInfo> CREATOR = new FileInfo.1();
  private String apkPackeageName;
  private long date;
  private String description;
  private String groupName;
  private boolean igonFilename = false;
  private boolean isDirectory = false;
  private boolean litePath = false;
  private int mediaId;
  private String name;
  private String path;
  private long size;
  
  public FileInfo()
  {
    setPath("");
    setName("");
    setSize(0L);
    setDate(System.currentTimeMillis());
    setDescription("");
    setApkPackeageName("");
    setGroupName("");
  }
  
  private FileInfo(Parcel paramParcel)
  {
    setPath(paramParcel.readString());
    setName(paramParcel.readString());
    setSize(paramParcel.readLong());
    setDate(paramParcel.readLong());
    setDescription(paramParcel.readString());
    setApkPackeageName(paramParcel.readString());
    setGroupName(paramParcel.readString());
  }
  
  public FileInfo(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        setDirectory(paramString.isDirectory());
        setPath(paramString.getAbsolutePath());
        setName(paramString.getName());
        setSize(paramString.length());
        setDate(paramString.lastModified());
        setApkPackeageName("");
        setGroupName("");
        return;
      }
      throw new FileNotFoundException("file not exist!");
    }
    throw new FileNotFoundException("file path is null!");
  }
  
  private boolean compare(FileInfo paramFileInfo)
  {
    return (getSize() == paramFileInfo.getSize()) && (getDate() == paramFileInfo.getDate()) && (getPath().equals(paramFileInfo.getPath()));
  }
  
  public static FileInfo create(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      File localFile = new File(paramString);
      localObject1 = localObject2;
      if (localFile.exists()) {
        if (localFile.length() == 0L) {
          return null;
        }
      }
    }
    try
    {
      localObject1 = new FileInfo(paramString);
      return localObject1;
    }
    catch (FileNotFoundException paramString) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof FileInfo))) {
      return compare((FileInfo)paramObject);
    }
    return false;
  }
  
  public String getApkPackeageName()
  {
    return this.apkPackeageName;
  }
  
  public long getDate()
  {
    return this.date;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public int getMediaId()
  {
    return this.mediaId;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName());
    localStringBuilder.append(getSize());
    localStringBuilder.append(getDate());
    return localStringBuilder.toString().hashCode();
  }
  
  public boolean isDirectory()
  {
    return this.isDirectory;
  }
  
  public boolean isIgonFilename()
  {
    return this.igonFilename;
  }
  
  public boolean isLitePath()
  {
    return this.litePath;
  }
  
  public void setApkPackeageName(String paramString)
  {
    this.apkPackeageName = paramString;
  }
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setDirectory(boolean paramBoolean)
  {
    this.isDirectory = paramBoolean;
  }
  
  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
  }
  
  public void setIgonFilename()
  {
    this.igonFilename = true;
  }
  
  public void setLitePath(boolean paramBoolean)
  {
    this.litePath = paramBoolean;
  }
  
  public void setMediaId(int paramInt)
  {
    this.mediaId = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.name);
    paramParcel.writeLong(this.size);
    paramParcel.writeLong(this.date);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.apkPackeageName);
    paramParcel.writeString(this.groupName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.FileInfo
 * JD-Core Version:    0.7.0.1
 */