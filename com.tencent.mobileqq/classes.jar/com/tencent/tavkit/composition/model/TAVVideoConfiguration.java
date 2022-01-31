package com.tencent.tavkit.composition.model;

import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVVideoConfiguration
  implements Cloneable
{
  public static final CGRect FIX_RENDER_SIZE = new CGRect();
  public static final CGRect SOURCE_SIZE = new CGRect();
  private TAVVideoConfiguration.TAVVideoConfigurationContentMode contentMode = TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit;
  private List<TAVVideoEffect> effects = new ArrayList();
  @Nullable
  private CGRect frame = SOURCE_SIZE;
  private int preferRotation = 0;
  private Matrix transform = new Matrix();
  
  public void addEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    if (this.effects == null) {
      this.effects = new ArrayList();
    }
    this.effects.add(paramTAVVideoEffect);
  }
  
  public TAVVideoConfiguration clone()
  {
    TAVVideoConfiguration localTAVVideoConfiguration = new TAVVideoConfiguration();
    localTAVVideoConfiguration.contentMode = this.contentMode;
    localTAVVideoConfiguration.frame = this.frame;
    localTAVVideoConfiguration.transform = this.transform;
    localTAVVideoConfiguration.effects = new ArrayList(this.effects);
    localTAVVideoConfiguration.preferRotation = this.preferRotation;
    return localTAVVideoConfiguration;
  }
  
  public boolean frameEnable()
  {
    return (this.frame != null) && (this.frame != FIX_RENDER_SIZE) && (this.frame != SOURCE_SIZE) && (Utils.isRectValid(this.frame));
  }
  
  public TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode()
  {
    return this.contentMode;
  }
  
  public List<TAVVideoEffect> getEffects()
  {
    return this.effects;
  }
  
  @Nullable
  public CGRect getFrame()
  {
    return this.frame;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public Matrix getTransform()
  {
    return this.transform;
  }
  
  public void setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    this.contentMode = paramTAVVideoConfigurationContentMode;
  }
  
  public void setEffects(List<TAVVideoEffect> paramList)
  {
    this.effects = paramList;
  }
  
  public void setFrame(@Nullable CGRect paramCGRect)
  {
    this.frame = paramCGRect;
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.preferRotation = paramInt;
  }
  
  public void setTransform(Matrix paramMatrix)
  {
    this.transform = paramMatrix;
  }
  
  public String toString()
  {
    return "TAVVideoConfiguration{contentMode=" + this.contentMode + ", frame=" + this.frame + ", transform=" + this.transform + '}';
  }
  
  public void updateTimeRange(CMTimeRange paramCMTimeRange)
  {
    if (this.effects == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.effects.iterator();
      while (localIterator.hasNext())
      {
        TAVVideoEffect localTAVVideoEffect = (TAVVideoEffect)localIterator.next();
        if ((localTAVVideoEffect instanceof TAVAttachTimeRangeSourceEffect)) {
          ((TAVAttachTimeRangeSourceEffect)localTAVVideoEffect).attachTimeRange(paramCMTimeRange);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVVideoConfiguration
 * JD-Core Version:    0.7.0.1
 */