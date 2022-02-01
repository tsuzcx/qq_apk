package com.tencent.mobileqq.minicode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type.Builder;
import android.support.annotation.RequiresApi;

public class YuvProxy$NV21ToBitmap
{
  private Allocation in;
  private Allocation out;
  private Type.Builder rgbaType;
  private RenderScript rs;
  private ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic;
  private Type.Builder yuvType;
  
  @RequiresApi(api=17)
  public YuvProxy$NV21ToBitmap(Context paramContext)
  {
    this.rs = RenderScript.create(paramContext);
    this.yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(this.rs, Element.U8_4(this.rs));
  }
  
  public void destroy()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.rs.destroy();
      return;
    }
    RenderScript.releaseAllContexts();
  }
  
  @RequiresApi(api=17)
  public Bitmap nv21ToBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.yuvType == null)
    {
      this.yuvType = new Type.Builder(this.rs, Element.U8(this.rs)).setX(paramArrayOfByte.length);
      this.in = Allocation.createTyped(this.rs, this.yuvType.create(), 1);
      this.rgbaType = new Type.Builder(this.rs, Element.RGBA_8888(this.rs)).setX(paramInt1).setY(paramInt2);
      this.out = Allocation.createTyped(this.rs, this.rgbaType.create(), 1);
    }
    this.in.copyFrom(paramArrayOfByte);
    this.yuvToRgbIntrinsic.setInput(this.in);
    this.yuvToRgbIntrinsic.forEach(this.out);
    paramArrayOfByte = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.out.copyTo(paramArrayOfByte);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.YuvProxy.NV21ToBitmap
 * JD-Core Version:    0.7.0.1
 */