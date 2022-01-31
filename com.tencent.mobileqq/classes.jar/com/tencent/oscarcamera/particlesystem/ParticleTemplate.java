package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.json.JSONObject;

public class ParticleTemplate
{
  public static final String ATTR_COLOR_A = String.format("%s", new Object[] { "colorA" });
  public static final String ATTR_COLOR_B;
  public static final String ATTR_COLOR_G;
  public static final String ATTR_COLOR_R;
  public static final String ATTR_EMIT_RATE;
  public static final String ATTR_HEIGHT;
  public static final String ATTR_LIFE;
  public static final String ATTR_MAX_COUNT;
  public static final String ATTR_POS_X = String.format("%s", new Object[] { "positionX" });
  public static final String ATTR_POS_Y = String.format("%s", new Object[] { "positionY" });
  public static final String ATTR_POS_Z = String.format("%s", new Object[] { "positionZ" });
  public static final String ATTR_WIDTH;
  private static final String TAG = ParticleTemplate.class.getSimpleName();
  String mColorA = "0";
  String mColorB = "0";
  String mColorG = "0";
  String mColorR = "0";
  double mEmitRate;
  String mHeight = "0";
  String mLife = "0";
  int mMaxCount;
  String mPosX = "0";
  String mPosY = "0";
  String mPosZ = "0";
  public Sprite mSprite;
  private ParticleSystemEx mSystem;
  String mWidth = "0";
  
  static
  {
    ATTR_MAX_COUNT = String.format("%s", new Object[] { "particleCountMax" });
    ATTR_EMIT_RATE = String.format("%s", new Object[] { "emissionRate" });
    ATTR_WIDTH = String.format("%s", new Object[] { "width" });
    ATTR_HEIGHT = String.format("%s", new Object[] { "height" });
    ATTR_LIFE = String.format("%s", new Object[] { "life" });
    ATTR_COLOR_R = String.format("%s", new Object[] { "colorR" });
    ATTR_COLOR_G = String.format("%s", new Object[] { "colorG" });
    ATTR_COLOR_B = String.format("%s", new Object[] { "colorB" });
  }
  
  public ParticleTemplate(ParticleSystemEx paramParticleSystemEx)
  {
    this.mSystem = paramParticleSystemEx;
    this.mSprite = new Sprite();
  }
  
  private double doubleValue(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.opt(paramString);
    if ((paramJSONObject != null) && ((paramJSONObject instanceof Number))) {
      return ((Number)paramJSONObject).doubleValue();
    }
    return 0.0D;
  }
  
  static ParticleTemplate fromJson(ParticleSystemEx paramParticleSystemEx, JSONObject paramJSONObject, String paramString)
  {
    ParticleTemplate localParticleTemplate = new ParticleTemplate(paramParticleSystemEx);
    for (;;)
    {
      Object localObject;
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        paramParticleSystemEx = localParticleTemplate;
        if (localIterator.hasNext())
        {
          paramParticleSystemEx = (String)localIterator.next();
          localObject = paramJSONObject.get(paramParticleSystemEx);
          if (((localObject instanceof Number)) || ((localObject instanceof String))) {
            initAttr(localParticleTemplate, paramParticleSystemEx, localObject);
          }
        }
        else
        {
          return paramParticleSystemEx;
        }
      }
      catch (Exception paramParticleSystemEx)
      {
        paramParticleSystemEx.printStackTrace();
        paramParticleSystemEx = null;
      }
      if (((localObject instanceof JSONObject)) && (TextUtils.equals(paramParticleSystemEx, "sprite"))) {
        localParticleTemplate.initSprite((JSONObject)localObject, paramString);
      } else if (((localObject instanceof JSONObject)) && (TextUtils.equals(paramParticleSystemEx, "audio"))) {
        localParticleTemplate.mSprite.audioPath = ((JSONObject)localObject).getString("path");
      }
    }
  }
  
  private static void initAttr(ParticleTemplate paramParticleTemplate, String paramString, Object paramObject)
  {
    String str = null;
    if ((paramObject instanceof String)) {
      str = (String)paramObject;
    }
    label21:
    do
    {
      break label21;
      while (str == null)
      {
        return;
        if ((paramObject instanceof Number)) {
          str = paramObject.toString();
        }
      }
      if (TextUtils.equals(ATTR_MAX_COUNT, paramString))
      {
        if ((paramObject instanceof Number)) {}
        for (int i = ((Number)paramObject).intValue();; i = 0)
        {
          paramParticleTemplate.mMaxCount = i;
          if (paramParticleTemplate.mMaxCount >= 0) {
            break;
          }
          paramParticleTemplate.mMaxCount = 0;
          return;
        }
      }
      if (TextUtils.equals(ATTR_EMIT_RATE, paramString))
      {
        if ((paramObject instanceof Number)) {}
        for (double d = ((Number)paramObject).doubleValue();; d = 0.0D)
        {
          paramParticleTemplate.mEmitRate = d;
          if (paramParticleTemplate.mEmitRate >= 0.0D) {
            break;
          }
          paramParticleTemplate.mEmitRate = 0.0D;
          return;
        }
      }
      if (TextUtils.equals(ATTR_WIDTH, paramString))
      {
        paramParticleTemplate.mWidth = str;
        return;
      }
      if (TextUtils.equals(ATTR_HEIGHT, paramString))
      {
        paramParticleTemplate.mHeight = str;
        return;
      }
      if (TextUtils.equals(ATTR_LIFE, paramString))
      {
        paramParticleTemplate.mLife = str;
        return;
      }
      if (TextUtils.equals(ATTR_COLOR_R, paramString))
      {
        paramParticleTemplate.mColorR = str;
        return;
      }
      if (TextUtils.equals(ATTR_COLOR_G, paramString))
      {
        paramParticleTemplate.mColorG = str;
        return;
      }
      if (TextUtils.equals(ATTR_COLOR_B, paramString))
      {
        paramParticleTemplate.mColorB = str;
        return;
      }
      if (TextUtils.equals(ATTR_COLOR_A, paramString))
      {
        paramParticleTemplate.mColorA = str;
        return;
      }
      if (TextUtils.equals(ATTR_POS_X, paramString))
      {
        paramParticleTemplate.mPosX = str;
        return;
      }
      if (TextUtils.equals(ATTR_POS_Y, paramString))
      {
        paramParticleTemplate.mPosY = str;
        return;
      }
    } while (!TextUtils.equals(ATTR_POS_Z, paramString));
    paramParticleTemplate.mPosZ = str;
  }
  
  private void initSprite(JSONObject paramJSONObject, String paramString)
  {
    this.mSprite.path = paramJSONObject.optString("path");
    Object localObject2 = paramString + File.separator + this.mSprite.path;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    if (((String)localObject2).startsWith("/")) {
      BitmapFactory.decodeFile((String)localObject2, localOptions);
    }
    Object localObject1;
    for (;;)
    {
      if ((localOptions.outWidth != 0) && (localOptions.outHeight != 0)) {
        break label213;
      }
      throw new RuntimeException("tex outWith or outHeight is 0");
      AssetManager localAssetManager = this.mSystem.mContext.getAssets();
      localObject1 = null;
      paramString = null;
      try
      {
        localObject2 = localAssetManager.open((String)localObject2);
        paramString = (String)localObject2;
        localObject1 = localObject2;
        BitmapFactory.decodeStream((InputStream)localObject2, null, localOptions);
        if (localObject2 != null) {
          try
          {
            ((InputStream)localObject2).close();
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
      catch (IOException localIOException)
      {
        localObject1 = paramString;
        localIOException.printStackTrace();
        if (paramString != null) {
          try
          {
            paramString.close();
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
    try
    {
      ((InputStream)localObject1).close();
      throw paramJSONObject;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    label213:
    this.mSprite.frameCount = ((int)doubleValue(paramJSONObject, "frameCount"));
    this.mSprite.width = ((int)doubleValue(paramJSONObject, "width"));
    this.mSprite.height = ((int)doubleValue(paramJSONObject, "height"));
    this.mSprite.blendMode = ((int)doubleValue(paramJSONObject, "blendMode"));
    this.mSprite.animated = ((int)doubleValue(paramJSONObject, "animated"));
    this.mSprite.looped = ((int)doubleValue(paramJSONObject, "looped"));
    this.mSprite.frameDuration = doubleValue(paramJSONObject, "frameDuration");
    preCalTexCoords(this.mSprite, localOptions.outWidth, localOptions.outHeight, this.mSprite.width, this.mSprite.height);
  }
  
  private void preCalTexCoords(Sprite paramSprite, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 / paramInt4;
    int j = paramInt1 / paramInt3;
    float f1 = paramInt3 * 1.0F / paramInt1;
    float f2 = paramInt4 * 1.0F / paramInt2;
    paramSprite.texCoords = new float[i * j * 12];
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      paramInt3 = 0;
      while (paramInt3 < j)
      {
        PointF localPointF = new PointF(paramInt3 * f1, paramInt2 * f2);
        Object localObject1 = new PointF(localPointF.x, localPointF.y + f2);
        Object localObject2 = new PointF(localPointF.x + f1, localPointF.y);
        Object localObject3 = new PointF(((PointF)localObject2).x, localPointF.y + f2);
        float[] arrayOfFloat = paramSprite.texCoords;
        paramInt4 = paramInt1 + 1;
        arrayOfFloat[paramInt1] = ((PointF)localObject2).x;
        arrayOfFloat = paramSprite.texCoords;
        paramInt1 = paramInt4 + 1;
        arrayOfFloat[paramInt4] = ((PointF)localObject2).y;
        arrayOfFloat = paramSprite.texCoords;
        paramInt4 = paramInt1 + 1;
        arrayOfFloat[paramInt1] = ((PointF)localObject3).x;
        arrayOfFloat = paramSprite.texCoords;
        paramInt1 = paramInt4 + 1;
        arrayOfFloat[paramInt4] = ((PointF)localObject3).y;
        localObject3 = paramSprite.texCoords;
        paramInt4 = paramInt1 + 1;
        localObject3[paramInt1] = ((PointF)localObject1).x;
        localObject3 = paramSprite.texCoords;
        paramInt1 = paramInt4 + 1;
        localObject3[paramInt4] = ((PointF)localObject1).y;
        localObject3 = paramSprite.texCoords;
        paramInt4 = paramInt1 + 1;
        localObject3[paramInt1] = ((PointF)localObject2).x;
        localObject3 = paramSprite.texCoords;
        paramInt1 = paramInt4 + 1;
        localObject3[paramInt4] = ((PointF)localObject2).y;
        localObject2 = paramSprite.texCoords;
        paramInt4 = paramInt1 + 1;
        localObject2[paramInt1] = ((PointF)localObject1).x;
        localObject2 = paramSprite.texCoords;
        paramInt1 = paramInt4 + 1;
        localObject2[paramInt4] = ((PointF)localObject1).y;
        localObject1 = paramSprite.texCoords;
        paramInt4 = paramInt1 + 1;
        localObject1[paramInt1] = localPointF.x;
        localObject1 = paramSprite.texCoords;
        paramInt1 = paramInt4 + 1;
        localObject1[paramInt4] = localPointF.y;
        paramInt3 += 1;
      }
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleTemplate
 * JD-Core Version:    0.7.0.1
 */