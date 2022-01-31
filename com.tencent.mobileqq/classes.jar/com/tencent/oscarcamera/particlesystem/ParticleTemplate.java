package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

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
  private String mColorA = "0";
  private String mColorB = "0";
  private String mColorG = "0";
  private String mColorR = "0";
  private double mEmitRate;
  private String mHeight = "0";
  private String mLife = "0";
  public int mMaxCount;
  private String mPosX = "0";
  private String mPosY = "0";
  private String mPosZ = "0";
  public Sprite mSprite;
  private ParticleSystemEx mSystem;
  private String mWidth = "0";
  
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
  
  private double doubleValue(JsonObject paramJsonObject, String paramString)
  {
    paramJsonObject = paramJsonObject.get(paramString);
    if (((paramJsonObject instanceof JsonPrimitive)) && (((JsonPrimitive)paramJsonObject).isNumber())) {
      return paramJsonObject.getAsNumber().doubleValue();
    }
    return 0.0D;
  }
  
  static ParticleTemplate fromJson(ParticleSystemEx paramParticleSystemEx, JsonObject paramJsonObject, String paramString)
  {
    paramParticleSystemEx = new ParticleTemplate(paramParticleSystemEx);
    for (;;)
    {
      String str;
      JsonElement localJsonElement;
      try
      {
        Iterator localIterator = paramJsonObject.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        localJsonElement = paramJsonObject.get(str);
        if (!(localJsonElement instanceof JsonPrimitive)) {
          break label112;
        }
        if (((JsonPrimitive)localJsonElement).isNumber())
        {
          initAttr(paramParticleSystemEx, str, localJsonElement.getAsNumber());
          continue;
        }
        if (!((JsonPrimitive)localJsonElement).isString()) {
          continue;
        }
      }
      catch (Exception paramParticleSystemEx)
      {
        paramParticleSystemEx.printStackTrace();
        return null;
      }
      initAttr(paramParticleSystemEx, str, localJsonElement.getAsString());
      continue;
      label112:
      if (((localJsonElement instanceof JsonObject)) && (TextUtils.equals(str, "sprite"))) {
        paramParticleSystemEx.initSprite((JsonObject)localJsonElement, paramString);
      } else if (((localJsonElement instanceof JsonObject)) && (TextUtils.equals(str, "audio"))) {
        paramParticleSystemEx.mSprite.audioPath = GsonUtils.getStringUnsafe((JsonObject)localJsonElement, "path");
      }
    }
    return paramParticleSystemEx;
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
  
  private void initSprite(JsonObject paramJsonObject, String paramString)
  {
    Object localObject = null;
    InputStream localInputStream = null;
    this.mSprite.path = GsonUtils.optString(paramJsonObject, "path");
    String str = paramString + File.separator + this.mSprite.path;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    if (str.startsWith("/")) {
      BitmapFactory.decodeFile(str, localOptions);
    }
    for (;;)
    {
      if ((localOptions.outWidth != 0) && (localOptions.outHeight != 0)) {
        break label218;
      }
      throw new RuntimeException("tex outWith or outHeight is 0");
      AssetManager localAssetManager = this.mSystem.mContext.getAssets();
      paramString = localInputStream;
      try
      {
        localInputStream = localAssetManager.open(str);
        paramString = localInputStream;
        localObject = localInputStream;
        BitmapFactory.decodeStream(localInputStream, null, localOptions);
        if (localInputStream != null) {
          try
          {
            localInputStream.close();
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
      catch (IOException localIOException)
      {
        localObject = paramString;
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
        if (localObject == null) {}
      }
    }
    try
    {
      ((InputStream)localObject).close();
      throw paramJsonObject;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    label218:
    this.mSprite.frameCount = ((int)doubleValue(paramJsonObject, "frameCount"));
    this.mSprite.width = ((int)doubleValue(paramJsonObject, "width"));
    this.mSprite.height = ((int)doubleValue(paramJsonObject, "height"));
    this.mSprite.blendMode = ((int)doubleValue(paramJsonObject, "blendMode"));
    this.mSprite.animated = ((int)doubleValue(paramJsonObject, "animated"));
    this.mSprite.looped = ((int)doubleValue(paramJsonObject, "looped"));
    this.mSprite.frameDuration = doubleValue(paramJsonObject, "frameDuration");
    preCalTexCoords(this.mSprite, localOptions.outWidth, localOptions.outHeight, this.mSprite.width, this.mSprite.height);
  }
  
  private void preCalTexCoords(Sprite paramSprite, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 / paramInt4;
    int j = paramInt1 / paramInt3;
    float f1 = paramInt3 * 1.0F / paramInt1;
    float f2 = paramInt4 * 1.0F / paramInt2;
    paramSprite.texCoords = new float[i * j * 12];
    paramInt3 = 0;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      paramInt2 = 0;
      while (paramInt2 < j)
      {
        PointF localPointF = new PointF(paramInt2 * f1, paramInt1 * f2);
        Object localObject1 = new PointF(localPointF.x, localPointF.y + f2);
        Object localObject2 = new PointF(localPointF.x + f1, localPointF.y);
        Object localObject3 = new PointF(((PointF)localObject2).x, localPointF.y + f2);
        float[] arrayOfFloat = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        arrayOfFloat[paramInt3] = ((PointF)localObject2).x;
        arrayOfFloat = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        arrayOfFloat[paramInt4] = ((PointF)localObject2).y;
        arrayOfFloat = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        arrayOfFloat[paramInt3] = ((PointF)localObject3).x;
        arrayOfFloat = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        arrayOfFloat[paramInt4] = ((PointF)localObject3).y;
        localObject3 = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        localObject3[paramInt3] = ((PointF)localObject1).x;
        localObject3 = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        localObject3[paramInt4] = ((PointF)localObject1).y;
        localObject3 = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        localObject3[paramInt3] = ((PointF)localObject2).x;
        localObject3 = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        localObject3[paramInt4] = ((PointF)localObject2).y;
        localObject2 = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        localObject2[paramInt3] = ((PointF)localObject1).x;
        localObject2 = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        localObject2[paramInt4] = ((PointF)localObject1).y;
        localObject1 = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        localObject1[paramInt3] = localPointF.x;
        localObject1 = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        localObject1[paramInt4] = localPointF.y;
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleTemplate
 * JD-Core Version:    0.7.0.1
 */