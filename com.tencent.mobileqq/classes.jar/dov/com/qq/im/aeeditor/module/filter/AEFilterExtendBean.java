package dov.com.qq.im.aeeditor.module.filter;

import java.io.Serializable;
import java.util.Map;

public class AEFilterExtendBean
  implements Serializable
{
  private Map<String, String> adjustParams;
  private float defaultEffectAlpha = 1.0F;
  private float glowStrength;
  private String lutID;
  private String motionID;
  
  public Map<String, String> getAdjustParams()
  {
    return this.adjustParams;
  }
  
  public float getDefaultEffectAlpha()
  {
    return this.defaultEffectAlpha;
  }
  
  public float getGlowStrength()
  {
    return this.glowStrength;
  }
  
  public String getLutID()
  {
    return this.lutID;
  }
  
  public String getMotionID()
  {
    return this.motionID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEFilterExtendBean
 * JD-Core Version:    0.7.0.1
 */