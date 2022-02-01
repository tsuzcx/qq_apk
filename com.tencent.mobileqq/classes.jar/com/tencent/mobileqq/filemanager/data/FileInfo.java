package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import java.io.File;
import java.io.FileNotFoundException;

public class FileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FileInfo> CREATOR = new FileInfo.1();
  private String a;
  private int b;
  private String c;
  private long d;
  private long e;
  private String f;
  private int g;
  private String h;
  private String i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  
  public FileInfo()
  {
    f("");
    d("");
    a(0L);
    b(System.currentTimeMillis());
    b("");
    b(-1);
    c("");
    a("");
  }
  
  private FileInfo(Parcel paramParcel)
  {
    f(paramParcel.readString());
    d(paramParcel.readString());
    a(paramParcel.readLong());
    b(paramParcel.readLong());
    b(paramParcel.readString());
    b(paramParcel.readInt());
    c(paramParcel.readString());
    a(paramParcel.readString());
  }
  
  public FileInfo(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        b(paramString.isDirectory());
        f(paramString.getAbsolutePath());
        d(paramString.getName());
        a(paramString.length());
        b(paramString.lastModified());
        b(QQFileManagerUtil.k(this.c));
        c("");
        a("");
        return;
      }
      throw new FileNotFoundException("file not exist!");
    }
    throw new FileNotFoundException("file path is null!");
  }
  
  private boolean a(FileInfo paramFileInfo)
  {
    return (f() == paramFileInfo.f()) && (g() == paramFileInfo.g()) && (d().equals(paramFileInfo.d()));
  }
  
  public static FileInfo e(String paramString)
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
  
  public String a()
  {
    return this.i;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public String b()
  {
    return this.h;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void c(String paramString)
  {
    this.h = paramString;
  }
  
  public boolean c()
  {
    return this.a.startsWith(AppConstants.SDCARD_FILE_SAVE_PATH);
  }
  
  public String d()
  {
    return this.a;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof FileInfo))) {
      return a((FileInfo)paramObject);
    }
    return false;
  }
  
  public long f()
  {
    return this.d;
  }
  
  public void f(String paramString)
  {
    this.a = paramString;
  }
  
  public long g()
  {
    return this.e;
  }
  
  public boolean h()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append(f());
    localStringBuilder.append(g());
    return localStringBuilder.toString().hashCode();
  }
  
  public void i()
  {
    this.j = true;
  }
  
  public boolean j()
  {
    return this.k;
  }
  
  public boolean k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileInfo
 * JD-Core Version:    0.7.0.1
 */