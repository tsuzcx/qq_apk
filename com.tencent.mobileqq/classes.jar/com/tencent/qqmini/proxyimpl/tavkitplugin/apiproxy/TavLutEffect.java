package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTimeRange;

public class TavLutEffect
  extends BaseEffectNode
{
  private Bitmap a;
  private String b;
  private CMTimeRange c;
  private float d = 1.0F;
  
  public BaseEffectNode.Filter a()
  {
    return new TavLutEffect.LutEffectFilter(this);
  }
  
  public void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void a(CMTimeRange paramCMTimeRange)
  {
    this.c = paramCMTimeRange;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public CMTimeRange c()
  {
    return this.c;
  }
  
  public float d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavLutEffect
 * JD-Core Version:    0.7.0.1
 */