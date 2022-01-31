package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import com.tencent.image.ApngImage;
import java.io.File;

public class VasApngDownloader$VasApngImage
  extends ApngImage
{
  private float a;
  
  public VasApngDownloader$VasApngImage(File paramFile, boolean paramBoolean, Bundle paramBundle)
  {
    super(paramFile, paramBoolean, paramBundle);
    this.a = paramBundle.getFloat("key_frame_delay_fraction", 0.0F);
  }
  
  /* Error */
  protected boolean getNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 25	com/tencent/image/ApngImage:getNextFrame	()Z
    //   6: ifeq +33 -> 39
    //   9: aload_0
    //   10: getfield 20	com/tencent/mobileqq/transfile/VasApngDownloader$VasApngImage:a	F
    //   13: fconst_0
    //   14: fcmpl
    //   15: ifle +18 -> 33
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 29	com/tencent/mobileqq/transfile/VasApngDownloader$VasApngImage:currentFrameDelay	I
    //   23: i2f
    //   24: aload_0
    //   25: getfield 20	com/tencent/mobileqq/transfile/VasApngDownloader$VasApngImage:a	F
    //   28: fmul
    //   29: f2i
    //   30: putfield 29	com/tencent/mobileqq/transfile/VasApngDownloader$VasApngImage:currentFrameDelay	I
    //   33: iconst_1
    //   34: istore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_1
    //   41: goto -6 -> 35
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	VasApngImage
    //   34	7	1	bool	boolean
    //   44	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	33	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasApngDownloader.VasApngImage
 * JD-Core Version:    0.7.0.1
 */