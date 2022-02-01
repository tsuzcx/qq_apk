package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/CoverInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/CoverInfo;", "()V", "path", "", "timeAt", "", "Ljava/lang/Long;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/CoverInfo$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class CoverInfo$Builder
  extends Message.Builder<CoverInfo, Builder>
{
  @JvmField
  @Nullable
  public String a;
  @JvmField
  @Nullable
  public Long b;
  
  @NotNull
  public CoverInfo a()
  {
    return new CoverInfo(this.a, this.b, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.CoverInfo.Builder
 * JD-Core Version:    0.7.0.1
 */