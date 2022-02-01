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
    if (paramString == null) {
      throw new FileNotFoundException("file path is null!");
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      throw new FileNotFoundException("file not exist!");
    }
    setDirectory(paramString.isDirectory());
    setPath(paramString.getAbsolutePath());
    setName(paramString.getName());
    setSize(paramString.length());
    setDate(paramString.lastModified());
    setApkPackeageName("");
    setGroupName("");
  }
  
  private boolean compare(FileInfo paramFileInfo)
  {
    return (getSize() == paramFileInfo.getSize()) && (getDate() == paramFileInfo.getDate()) && (getPath().equals(paramFileInfo.getPath()));
  }
  
  public static FileInfo create(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    File localFile;
    do
    {
      return null;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (localFile.length() == 0L));
    try
    {
      paramString = new FileInfo(paramString);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
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
    if ((paramObject == null) || (!(paramObject instanceof FileInfo))) {
      return false;
    }
    return compare((FileInfo)paramObject);
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
    return (getName() + getSize() + getDate()).hashCode();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.FileInfo
 * JD-Core Version:    0.7.0.1
 */