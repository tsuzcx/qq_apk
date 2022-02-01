package com.tencent.mobileqq.wink.editor.music.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo;
import java.util.LinkedList;
import java.util.List;

public class WinkEditorMusicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WinkEditorMusicInfo> CREATOR = new WinkEditorMusicInfo.1();
  public static final List<WinkEditorMusicInfo> a = m();
  public static final WinkEditorMusicInfo b = l();
  public boolean c;
  public int d;
  public int e;
  public final int f;
  public final boolean g;
  public final int h;
  private VsMusicItemInfo i;
  
  protected WinkEditorMusicInfo(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.e = 0;
    this.i = ((VsMusicItemInfo)paramParcel.readParcelable(VsMusicItemInfo.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.g = bool1;
    this.h = paramParcel.readInt();
  }
  
  public WinkEditorMusicInfo(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean, int paramInt)
  {
    this(paramVsMusicItemInfo, paramBoolean, paramInt, false, -1);
  }
  
  public WinkEditorMusicInfo(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    this.e = 0;
    this.i = paramVsMusicItemInfo;
    this.c = paramBoolean1;
    this.d = 0;
    this.f = paramInt1;
    this.g = paramBoolean2;
    this.h = paramInt2;
  }
  
  public static WinkEditorMusicInfo l()
  {
    VsMusicItemInfo localVsMusicItemInfo = new VsMusicItemInfo();
    localVsMusicItemInfo.mSongMid = "fakeMid_template_bgm";
    localVsMusicItemInfo.mMusicName = "";
    localVsMusicItemInfo.mUrl = "";
    localVsMusicItemInfo.mAlbumUrl = "";
    return new WinkEditorMusicInfo(localVsMusicItemInfo, false, 3);
  }
  
  @NonNull
  private static List<WinkEditorMusicInfo> m()
  {
    LinkedList localLinkedList = new LinkedList();
    int k;
    for (int j = 0; j < 6; j = k)
    {
      Object localObject = new VsMusicItemInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeMid");
      k = j + 1;
      localStringBuilder.append(k);
      ((VsMusicItemInfo)localObject).mSongMid = localStringBuilder.toString();
      ((VsMusicItemInfo)localObject).mMusicName = "";
      ((VsMusicItemInfo)localObject).mUrl = "";
      ((VsMusicItemInfo)localObject).mAlbumUrl = "";
      if (j == 0) {
        localObject = new WinkEditorMusicInfo((VsMusicItemInfo)localObject, false, 1);
      } else {
        localObject = new WinkEditorMusicInfo((VsMusicItemInfo)localObject, false, 0);
      }
      localLinkedList.add(localObject);
    }
    return localLinkedList;
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(c());
  }
  
  @Nullable
  public VsMusicItemInfo b()
  {
    return this.i;
  }
  
  @NonNull
  public String c()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mSongMid == null) {
      return "";
    }
    return this.i.mSongMid;
  }
  
  @NonNull
  public long d()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return 0L;
    }
    return localVsMusicItemInfo.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public String e()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mMusicName == null) {
      return "";
    }
    return this.i.mMusicName;
  }
  
  @NonNull
  public String f()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mUrl == null) {
      return "";
    }
    return this.i.mUrl;
  }
  
  public int g()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return 0;
    }
    return localVsMusicItemInfo.musicStart;
  }
  
  public int h()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return 0;
    }
    return localVsMusicItemInfo.musicDuration;
  }
  
  @NonNull
  public String i()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mAlbumUrl == null) {
      return "";
    }
    return this.i.mAlbumUrl;
  }
  
  @NonNull
  public String j()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.b == null) {
      return "";
    }
    return this.i.b;
  }
  
  @NonNull
  public String k()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "LRC";
    }
    if (TextUtils.isEmpty(localVsMusicItemInfo.a)) {
      return "LRC";
    }
    return this.i.a;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{songMid:");
    localStringBuilder.append(c());
    localStringBuilder.append(", songName:");
    localStringBuilder.append(e());
    localStringBuilder.append(", songUrl:");
    localStringBuilder.append(f());
    localStringBuilder.append(", selected:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", downloadStatus:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", itemType:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.i, paramInt);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeInt(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo
 * JD-Core Version:    0.7.0.1
 */