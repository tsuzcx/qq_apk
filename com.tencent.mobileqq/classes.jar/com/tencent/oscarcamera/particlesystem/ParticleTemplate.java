package com.tencent.oscarcamera.particlesystem;

import android.graphics.PointF;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.ttpic.util.GsonUtils;
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
  public static final String ATTR_MAX_COUNT = String.format("%s", new Object[] { "particleCountMax" });
  public static final String ATTR_POS_X = String.format("%s", new Object[] { "positionX" });
  public static final String ATTR_POS_Y = String.format("%s", new Object[] { "positionY" });
  public static final String ATTR_POS_Z = String.format("%s", new Object[] { "positionZ" });
  public static final String ATTR_WIDTH;
  private static final String TAG = "ParticleTemplate";
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
    ParticleTemplate localParticleTemplate = new ParticleTemplate(paramParticleSystemEx);
    try
    {
      Iterator localIterator = paramJsonObject.keySet().iterator();
      for (;;)
      {
        paramParticleSystemEx = localParticleTemplate;
        if (!localIterator.hasNext()) {
          break;
        }
        paramParticleSystemEx = (String)localIterator.next();
        JsonElement localJsonElement = paramJsonObject.get(paramParticleSystemEx);
        if ((localJsonElement instanceof JsonPrimitive))
        {
          if (((JsonPrimitive)localJsonElement).isNumber()) {
            initAttr(localParticleTemplate, paramParticleSystemEx, localJsonElement.getAsNumber());
          } else if (((JsonPrimitive)localJsonElement).isString()) {
            initAttr(localParticleTemplate, paramParticleSystemEx, localJsonElement.getAsString());
          }
        }
        else if (((localJsonElement instanceof JsonObject)) && (TextUtils.equals(paramParticleSystemEx, "sprite"))) {
          localParticleTemplate.initSprite((JsonObject)localJsonElement, paramString);
        } else if (((localJsonElement instanceof JsonObject)) && (TextUtils.equals(paramParticleSystemEx, "audio"))) {
          localParticleTemplate.mSprite.audioPath = GsonUtils.getStringUnsafe((JsonObject)localJsonElement, "path");
        }
      }
      return paramParticleSystemEx;
    }
    catch (Exception paramParticleSystemEx)
    {
      paramParticleSystemEx.printStackTrace();
      paramParticleSystemEx = null;
    }
  }
  
  private static void initAttr(ParticleTemplate paramParticleTemplate, String paramString, Object paramObject)
  {
    String str;
    if ((paramObject instanceof String)) {
      str = (String)paramObject;
    } else if ((paramObject instanceof Number)) {
      str = paramObject.toString();
    } else {
      str = null;
    }
    if (str == null) {
      return;
    }
    if (TextUtils.equals(ATTR_MAX_COUNT, paramString))
    {
      int i;
      if ((paramObject instanceof Number)) {
        i = ((Number)paramObject).intValue();
      } else {
        i = 0;
      }
      paramParticleTemplate.mMaxCount = i;
      if (paramParticleTemplate.mMaxCount < 0) {
        paramParticleTemplate.mMaxCount = 0;
      }
    }
    else if (TextUtils.equals(ATTR_EMIT_RATE, paramString))
    {
      double d;
      if ((paramObject instanceof Number)) {
        d = ((Number)paramObject).doubleValue();
      } else {
        d = 0.0D;
      }
      paramParticleTemplate.mEmitRate = d;
      if (paramParticleTemplate.mEmitRate < 0.0D) {
        paramParticleTemplate.mEmitRate = 0.0D;
      }
    }
    else
    {
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
      if (TextUtils.equals(ATTR_POS_Z, paramString)) {
        paramParticleTemplate.mPosZ = str;
      }
    }
  }
  
  /* Error */
  private void initSprite(JsonObject paramJsonObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   4: aload_1
    //   5: ldc 207
    //   7: invokestatic 235	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
    //   10: putfield 237	com/tencent/oscarcamera/particlesystem/Sprite:path	Ljava/lang/String;
    //   13: new 239	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: getstatic 249	java/io/File:separator	Ljava/lang/String;
    //   31: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: aload_0
    //   37: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   40: getfield 237	com/tencent/oscarcamera/particlesystem/Sprite:path	Ljava/lang/String;
    //   43: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_3
    //   52: new 252	android/graphics/BitmapFactory$Options
    //   55: dup
    //   56: invokespecial 253	android/graphics/BitmapFactory$Options:<init>	()V
    //   59: astore 5
    //   61: aload 5
    //   63: iconst_1
    //   64: putfield 257	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   67: aload_3
    //   68: ldc_w 259
    //   71: invokevirtual 263	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +13 -> 87
    //   77: aload_3
    //   78: aload 5
    //   80: invokestatic 269	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   83: pop
    //   84: goto +91 -> 175
    //   87: aload_0
    //   88: getfield 125	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSystem	Lcom/tencent/oscarcamera/particlesystem/ParticleSystemEx;
    //   91: getfield 275	com/tencent/oscarcamera/particlesystem/ParticleSystemEx:mContext	Landroid/content/Context;
    //   94: invokevirtual 281	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   97: astore 6
    //   99: aconst_null
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_2
    //   104: aload 6
    //   106: aload_3
    //   107: invokevirtual 287	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   110: astore_3
    //   111: aload_3
    //   112: aconst_null
    //   113: aload 5
    //   115: invokestatic 291	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   118: pop
    //   119: aload_3
    //   120: ifnull +55 -> 175
    //   123: aload_3
    //   124: invokevirtual 296	java/io/InputStream:close	()V
    //   127: goto +48 -> 175
    //   130: astore_1
    //   131: aload_3
    //   132: astore_2
    //   133: goto +211 -> 344
    //   136: astore 4
    //   138: goto +14 -> 152
    //   141: astore_1
    //   142: goto +202 -> 344
    //   145: astore_2
    //   146: aload 4
    //   148: astore_3
    //   149: aload_2
    //   150: astore 4
    //   152: aload_3
    //   153: astore_2
    //   154: aload 4
    //   156: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   159: aload_3
    //   160: ifnull +15 -> 175
    //   163: aload_3
    //   164: invokevirtual 296	java/io/InputStream:close	()V
    //   167: goto +8 -> 175
    //   170: astore_2
    //   171: aload_2
    //   172: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   175: aload 5
    //   177: getfield 300	android/graphics/BitmapFactory$Options:outWidth	I
    //   180: ifeq +153 -> 333
    //   183: aload 5
    //   185: getfield 303	android/graphics/BitmapFactory$Options:outHeight	I
    //   188: ifeq +145 -> 333
    //   191: aload_0
    //   192: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   195: aload_0
    //   196: aload_1
    //   197: ldc_w 305
    //   200: invokespecial 307	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lcom/google/gson/JsonObject;Ljava/lang/String;)D
    //   203: d2i
    //   204: putfield 309	com/tencent/oscarcamera/particlesystem/Sprite:frameCount	I
    //   207: aload_0
    //   208: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   211: aload_0
    //   212: aload_1
    //   213: ldc 58
    //   215: invokespecial 307	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lcom/google/gson/JsonObject;Ljava/lang/String;)D
    //   218: d2i
    //   219: putfield 311	com/tencent/oscarcamera/particlesystem/Sprite:width	I
    //   222: aload_0
    //   223: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   226: aload_0
    //   227: aload_1
    //   228: ldc 62
    //   230: invokespecial 307	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lcom/google/gson/JsonObject;Ljava/lang/String;)D
    //   233: d2i
    //   234: putfield 313	com/tencent/oscarcamera/particlesystem/Sprite:height	I
    //   237: aload_0
    //   238: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   241: aload_0
    //   242: aload_1
    //   243: ldc_w 315
    //   246: invokespecial 307	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lcom/google/gson/JsonObject;Ljava/lang/String;)D
    //   249: d2i
    //   250: putfield 317	com/tencent/oscarcamera/particlesystem/Sprite:blendMode	I
    //   253: aload_0
    //   254: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   257: aload_0
    //   258: aload_1
    //   259: ldc_w 319
    //   262: invokespecial 307	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lcom/google/gson/JsonObject;Ljava/lang/String;)D
    //   265: d2i
    //   266: putfield 321	com/tencent/oscarcamera/particlesystem/Sprite:animated	I
    //   269: aload_0
    //   270: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   273: aload_0
    //   274: aload_1
    //   275: ldc_w 323
    //   278: invokespecial 307	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lcom/google/gson/JsonObject;Ljava/lang/String;)D
    //   281: d2i
    //   282: putfield 325	com/tencent/oscarcamera/particlesystem/Sprite:looped	I
    //   285: aload_0
    //   286: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   289: aload_0
    //   290: aload_1
    //   291: ldc_w 327
    //   294: invokespecial 307	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lcom/google/gson/JsonObject;Ljava/lang/String;)D
    //   297: putfield 329	com/tencent/oscarcamera/particlesystem/Sprite:frameDuration	D
    //   300: aload_0
    //   301: aload_0
    //   302: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   305: aload 5
    //   307: getfield 300	android/graphics/BitmapFactory$Options:outWidth	I
    //   310: aload 5
    //   312: getfield 303	android/graphics/BitmapFactory$Options:outHeight	I
    //   315: aload_0
    //   316: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   319: getfield 311	com/tencent/oscarcamera/particlesystem/Sprite:width	I
    //   322: aload_0
    //   323: getfield 130	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   326: getfield 313	com/tencent/oscarcamera/particlesystem/Sprite:height	I
    //   329: invokespecial 333	com/tencent/oscarcamera/particlesystem/ParticleTemplate:preCalTexCoords	(Lcom/tencent/oscarcamera/particlesystem/Sprite;IIII)V
    //   332: return
    //   333: new 335	java/lang/RuntimeException
    //   336: dup
    //   337: ldc_w 337
    //   340: invokespecial 340	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   343: athrow
    //   344: aload_2
    //   345: ifnull +15 -> 360
    //   348: aload_2
    //   349: invokevirtual 296	java/io/InputStream:close	()V
    //   352: goto +8 -> 360
    //   355: astore_2
    //   356: aload_2
    //   357: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   360: aload_1
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	ParticleTemplate
    //   0	362	1	paramJsonObject	JsonObject
    //   0	362	2	paramString	String
    //   20	144	3	localObject1	Object
    //   100	1	4	localObject2	Object
    //   136	11	4	localIOException	java.io.IOException
    //   150	5	4	str	String
    //   59	252	5	localOptions	android.graphics.BitmapFactory.Options
    //   97	8	6	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   111	119	130	finally
    //   111	119	136	java/io/IOException
    //   104	111	141	finally
    //   154	159	141	finally
    //   104	111	145	java/io/IOException
    //   123	127	170	java/io/IOException
    //   163	167	170	java/io/IOException
    //   348	352	355	java/io/IOException
  }
  
  private void preCalTexCoords(Sprite paramSprite, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 / paramInt4;
    int j = paramInt1 / paramInt3;
    float f1 = paramInt3 * 1.0F / paramInt1;
    float f2 = paramInt4 * 1.0F / paramInt2;
    paramSprite.texCoords = new float[i * j * 12];
    paramInt2 = 0;
    paramInt1 = 0;
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
        paramSprite.texCoords[paramInt4] = localPointF.y;
        paramInt3 += 1;
        paramInt1 = paramInt4 + 1;
      }
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleTemplate
 * JD-Core Version:    0.7.0.1
 */