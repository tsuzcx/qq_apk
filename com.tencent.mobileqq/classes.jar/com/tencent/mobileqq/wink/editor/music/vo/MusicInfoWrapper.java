package com.tencent.mobileqq.wink.editor.music.vo;

import .r8.java8methods.utility.Integer.hashCode.II;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.AudioModel.Builder;
import com.tencent.videocut.model.AudioModel.LyricInfo;
import com.tencent.videocut.model.AudioModel.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/vo/MusicInfoWrapper;", "", "musicInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "localPath", "", "startTime", "", "duration", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Ljava/lang/String;II)V", "getDuration", "()I", "getLocalPath", "()Ljava/lang/String;", "getMusicInfo", "()Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "getStartTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toAudioModel", "Lcom/tencent/videocut/model/AudioModel;", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicInfoWrapper
{
  @Nullable
  private final WinkEditorMusicInfo a;
  @NotNull
  private final String b;
  private final int c;
  private final int d;
  
  public MusicInfoWrapper(@Nullable WinkEditorMusicInfo paramWinkEditorMusicInfo, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramWinkEditorMusicInfo;
    this.b = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  @NotNull
  public final AudioModel a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((WinkEditorMusicInfo)localObject).k();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "musicInfo.lyricFormat");
      String str = this.a.j();
      Intrinsics.checkExpressionValueIsNotNull(str, "musicInfo.lyric");
      localObject = new AudioModel.LyricInfo((String)localObject, str, null, null, 12, null);
      long l = this.a.h();
      return new AudioModel.Builder().a(this.a.c()).c(this.a.e()).b(this.b).b(Float.valueOf(1.0F)).a(AudioModel.Type.MUSIC).a((AudioModel.LyricInfo)localObject).b(Long.valueOf(this.c * 1000L)).c(Long.valueOf(this.d * 1000L)).a(Long.valueOf(l * 1000L)).a(Float.valueOf(0.5F)).a();
    }
    return new AudioModel.Builder().a();
  }
  
  @Nullable
  public final WinkEditorMusicInfo b()
  {
    return this.a;
  }
  
  @NotNull
  public final String c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final int e()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MusicInfoWrapper))
      {
        paramObject = (MusicInfoWrapper)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (this.d == paramObject.d)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.c)) * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.d);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicInfoWrapper(musicInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", localPath=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper
 * JD-Core Version:    0.7.0.1
 */