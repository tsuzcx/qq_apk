package com.tencent.tav.decoder.factory;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.IAVResample;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.resample.TAVResample;

public class AVResampleFactory
{
  private static final String TAG = "AVResampleFactory";
  private static AVResampleFactory instance;
  private boolean tavResampleEnable;
  
  public AVResampleFactory()
  {
    boolean bool = false;
    this.tavResampleEnable = false;
    try
    {
      if (Class.forName("com.tencent.tavkit.resample.TAVResample") != null) {
        bool = true;
      }
      this.tavResampleEnable = bool;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("newAVResample: ");
      localStringBuilder.append(localClassNotFoundException);
      Logger.w("AVResampleFactory", localStringBuilder.toString());
    }
  }
  
  public static AVResampleFactory getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new AVResampleFactory();
      }
      AVResampleFactory localAVResampleFactory = instance;
      return localAVResampleFactory;
    }
    finally {}
  }
  
  public static void setInstance(AVResampleFactory paramAVResampleFactory)
  {
    try
    {
      instance = paramAVResampleFactory;
      return;
    }
    finally
    {
      paramAVResampleFactory = finally;
      throw paramAVResampleFactory;
    }
  }
  
  @Nullable
  public IAVResample newAVResample(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.tavResampleEnable) {
      return new TAVResample(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.factory.AVResampleFactory
 * JD-Core Version:    0.7.0.1
 */