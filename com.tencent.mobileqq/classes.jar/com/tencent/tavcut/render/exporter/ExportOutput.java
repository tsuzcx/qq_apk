package com.tencent.tavcut.render.exporter;

import android.util.Size;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.utils.ResolutionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/exporter/ExportOutput;", "", "width", "", "height", "(II)V", "frameRate", "highProfile", "", "outputSize", "Lcom/tencent/tav/coremedia/CGSize;", "sizeLevel", "sizeLevel$annotations", "()V", "videoBitRate", "calculateSize", "calculateVideoBitRate", "", "convertOutputSize", "dstMinSize", "convertToExportConfig", "Lcom/tencent/tav/core/ExportConfig;", "getOutputSize", "setFrameRate", "setOutputSize", "setResolutionLevel", "level", "Companion", "ResolutionLevel", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class ExportOutput
{
  public static final ExportOutput.Companion a = new ExportOutput.Companion(null);
  private int b = 300;
  private CGSize c;
  private int d;
  private int e;
  private boolean f;
  
  public ExportOutput(int paramInt1, int paramInt2)
  {
    CGSize localCGSize = CGSize.CGSizeZero;
    Intrinsics.checkExpressionValueIsNotNull(localCGSize, "CGSize.CGSizeZero");
    this.c = localCGSize;
    this.e = 30;
    this.c = new CGSize(paramInt1, paramInt2);
  }
  
  private final CGSize a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2)
    {
      i = paramInt3 * paramInt2 / paramInt1;
      if (i <= 3840)
      {
        localSize = ResolutionUtils.a.a(new Size(paramInt3, i), 3840);
        return new CGSize(localSize.getWidth(), localSize.getHeight());
      }
      paramInt1 = paramInt1 * 3840 / paramInt2;
      localSize = ResolutionUtils.a.a(new Size(paramInt1, 3840), 3840);
      return new CGSize(localSize.getWidth(), localSize.getHeight());
    }
    int i = paramInt3 * paramInt1 / paramInt2;
    if (i <= 3840)
    {
      localSize = ResolutionUtils.a.a(new Size(i, paramInt3), 3840);
      return new CGSize(localSize.getWidth(), localSize.getHeight());
    }
    paramInt1 = paramInt2 * 3840 / paramInt1;
    Size localSize = ResolutionUtils.a.a(new Size(3840, paramInt1), 3840);
    return new CGSize(localSize.getWidth(), localSize.getHeight());
  }
  
  private final CGSize b(int paramInt1, int paramInt2)
  {
    int i = this.b;
    if (i != 100)
    {
      if (i != 200)
      {
        if (i != 300)
        {
          if (i != 400)
          {
            if (i != 500) {
              return a(paramInt1, paramInt2, 1080);
            }
            return a(paramInt1, paramInt2, 2560);
          }
          return a(paramInt1, paramInt2, 1440);
        }
        return a(paramInt1, paramInt2, 1080);
      }
      return a(paramInt1, paramInt2, 720);
    }
    return a(paramInt1, paramInt2, 480);
  }
  
  private final void c()
  {
    int i = Math.min((int)this.c.width, (int)this.c.height);
    if (i <= 720)
    {
      this.d = 3145728;
      return;
    }
    if (i <= 960)
    {
      this.d = 4194304;
      return;
    }
    if (i <= 1080)
    {
      this.d = 5242880;
      return;
    }
    if (i < 1440)
    {
      this.d = 8388608;
      return;
    }
    if (i < 2160)
    {
      this.d = 12582912;
      return;
    }
    this.d = 16777216;
  }
  
  @NotNull
  public final ExportConfig a()
  {
    ExportConfig localExportConfig = new ExportConfig((int)this.c.width, (int)this.c.height);
    localExportConfig.setFixOutputSize(false);
    localExportConfig.enableAVSync = true;
    localExportConfig.setHighProfile(this.f);
    localExportConfig.setVideoBitRate(this.d);
    localExportConfig.setVideoFrameRate(this.e);
    localExportConfig.setVideoIFrameInterval(1);
    return localExportConfig;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
    a((int)this.c.width, (int)this.c.height);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.c = b(paramInt1, paramInt2);
    c();
  }
  
  @NotNull
  public final CGSize b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.exporter.ExportOutput
 * JD-Core Version:    0.7.0.1
 */