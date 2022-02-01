package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import com.tencent.image.ApngImage;
import java.io.File;

public class VasApngDownloader$VasApngImage
  extends ApngImage
{
  public static final String KEY_FRAME_DELAY_FRACTION = "key_frame_delay_fraction";
  private float frameDelayFraction = 0.0F;
  
  public VasApngDownloader$VasApngImage(File paramFile, boolean paramBoolean, Bundle paramBundle)
  {
    super(paramFile, paramBoolean, paramBundle);
    this.frameDelayFraction = paramBundle.getFloat("key_frame_delay_fraction", 0.0F);
  }
  
  protected boolean getNextFrame()
  {
    try
    {
      if (super.getNextFrame())
      {
        if (this.frameDelayFraction > 0.0F) {
          this.currentFrameDelay = ((int)(this.currentFrameDelay * this.frameDelayFraction));
        }
        return true;
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasApngDownloader.VasApngImage
 * JD-Core Version:    0.7.0.1
 */