package org.jbox2d.common;

public class Settings
{
  public static int CONTACT_STACK_INIT_SIZE = 10;
  public static final float EPSILON = 1.192093E-007F;
  public static boolean FAST_ABS = true;
  public static boolean FAST_ATAN2 = true;
  public static boolean FAST_CEIL = true;
  public static boolean FAST_FLOOR = true;
  public static boolean FAST_ROUND = true;
  public static final float PI = 3.141593F;
  public static boolean SINCOS_LUT_ENABLED = true;
  public static final int SINCOS_LUT_LENGTH = (int)Math.ceil(57119.865982775773D);
  public static boolean SINCOS_LUT_LERP = false;
  public static final float SINCOS_LUT_PRECISION = 0.00011F;
  public static final float aabbExtension = 0.1F;
  public static final float aabbMultiplier = 2.0F;
  public static final float angularSleepTolerance = 0.03490659F;
  public static final float angularSlop = 0.03490659F;
  public static final float baumgarte = 0.2F;
  public static final float linearSleepTolerance = 0.01F;
  public static final float linearSlop = 0.005F;
  public static final float maxAngularCorrection = 0.1396264F;
  public static final float maxLinearCorrection = 0.2F;
  public static final int maxManifoldPoints = 2;
  public static final int maxPolygonVertices = 8;
  public static final float maxRotation = 1.570796F;
  public static float maxRotationSquared = 2.467401F;
  public static final int maxSubSteps = 8;
  public static final int maxTOIContacts = 32;
  public static final float maxTranslation = 2.0F;
  public static final float maxTranslationSquared = 4.0F;
  public static final float polygonRadius = 0.01F;
  public static final float timeToSleep = 0.5F;
  public static final float toiBaugarte = 0.75F;
  public static final float velocityThreshold = 1.0F;
  
  public static final float mixFriction(float paramFloat1, float paramFloat2)
  {
    return MathUtils.sqrt(paramFloat1 * paramFloat2);
  }
  
  public static final float mixRestitution(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat1;
    }
    return paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Settings
 * JD-Core Version:    0.7.0.1
 */