package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.map.core.interfaces.IMapOptions;
import com.tencent.map.sdk.a.pb;

public final class TencentMapOptions
  implements IMapOptions
{
  public static final int LOGO_POSITION_BOTTOM_CENTER = 4;
  public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
  public static final int LOGO_POSITION_BOTTOM_RIGHT = 1;
  public static final int LOGO_POSITION_TOP_CENTER = 5;
  public static final int LOGO_POSITION_TOP_LEFT = 3;
  public static final int LOGO_POSITION_TOP_RIGHT = 2;
  public static final int SCALEVIEW_POSITION_BOTTOM_CENTER = 4;
  public static final int SCALEVIEW_POSITION_BOTTOM_LEFT = 0;
  public static final int SCALEVIEW_POSITION_BOTTOM_RIGHT = 1;
  public static final int SCALEVIEW_POSITION_TOP_CENTER = 5;
  public static final int SCALEVIEW_POSITION_TOP_LEFT = 3;
  public static final int SCALEVIEW_POSITION_TOP_RIGHT = 2;
  public static final int ZOOM_POSITION_BOTTOM_LEFT = 0;
  public static final int ZOOM_POSITION_BOTTOM_RIGHT = 1;
  public static final int ZOOM_POSITION_TOP_LEFT = 3;
  public static final int ZOOM_POSITION_TOP_RIGHT = 2;
  private String a;
  private String b;
  private boolean c = false;
  private Object d;
  private int e;
  private int f;
  private String g;
  private String h;
  private boolean i = false;
  
  static void a()
  {
    pb.a = null;
  }
  
  public static Typeface getTypeface()
  {
    if (pb.a == null) {
      return Typeface.DEFAULT;
    }
    return pb.a;
  }
  
  public final String getCustomAssetsPath()
  {
    return this.a;
  }
  
  public final String getCustomLocalPath()
  {
    return this.b;
  }
  
  public final Object getExtSurface()
  {
    return this.d;
  }
  
  public final int getExtSurfaceHeight()
  {
    return this.f;
  }
  
  public final int getExtSurfaceWidth()
  {
    return this.e;
  }
  
  public final String getSubId()
  {
    return this.g;
  }
  
  public final String getSubKey()
  {
    return this.h;
  }
  
  public final boolean isHandDrawMapEnable()
  {
    return this.c;
  }
  
  public final boolean isMultipleInfoWindowEnable()
  {
    return this.i;
  }
  
  public final void setCustomAssetsPath(String paramString)
  {
    this.a = paramString;
  }
  
  public final void setCustomLocalPath(String paramString)
  {
    this.b = paramString;
  }
  
  public final void setExtSurface(Object paramObject)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder))) {
      throw new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
    }
    this.d = paramObject;
  }
  
  public final void setExtSurfaceDimension(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public final TencentMapOptions setHandDrawMapEnable(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public final void setMultipleInfoWindowEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public final void setSubInfo(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (this.h = paramString1.trim(); paramString2 != null; this.h = "")
    {
      this.g = paramString2.trim();
      return;
    }
    this.g = "";
  }
  
  public final void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != null) {
      pb.a = paramTypeface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMapOptions
 * JD-Core Version:    0.7.0.1
 */