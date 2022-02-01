package com.tencent.tkd.topicsdk.imagecompress.engine;

import com.tencent.tkd.topicsdk.imagecompress.InputStreamProvider;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/imagecompress/engine/Engine;", "Lcom/tencent/tkd/topicsdk/imagecompress/engine/IEngine;", "srcImg", "Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;", "tagImg", "Ljava/io/File;", "focusAlpha", "", "(Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;Ljava/io/File;Z)V", "compress", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class Engine
  implements IEngine
{
  private final InputStreamProvider a;
  private final File b;
  private final boolean c;
  
  public Engine(@NotNull InputStreamProvider paramInputStreamProvider, @NotNull File paramFile, boolean paramBoolean)
  {
    this.a = paramInputStreamProvider;
    this.b = paramFile;
    this.c = paramBoolean;
  }
  
  @NotNull
  public File a()
  {
    if (this.a.d()) {
      return new GifEngine(this.a, this.b).a();
    }
    return new ImageEngine(this.a, this.b, this.c).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.Engine
 * JD-Core Version:    0.7.0.1
 */