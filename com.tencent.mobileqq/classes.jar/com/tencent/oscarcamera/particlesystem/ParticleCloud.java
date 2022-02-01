package com.tencent.oscarcamera.particlesystem;

import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.ttpic.util.GsonUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParticleCloud
{
  private static final String TAG = "ParticleCloud";
  private static final HashMap<String, Object> s_params = new HashMap();
  private long[] mAttrExpressions;
  private double[] mAttrValue;
  public HashMap<String, Attribute> mAttrs = new HashMap();
  Particle mCopiedParticles = new Particle();
  long mEmitRate;
  double mLastQuotaTime;
  long mMaxCount;
  public String mName;
  Particle mParticles = new Particle();
  long mQuota;
  double[] mResultArray;
  DoubleBuffer mResultBuffer;
  public Sprite mSprite;
  private ParticleSystem mSystem;
  Attribute[] mVarAttributes;
  private long[] mVarExpressions;
  private int[] paramOffsets;
  
  public ParticleCloud(ParticleSystem paramParticleSystem)
  {
    this.mSystem = paramParticleSystem;
    this.mSprite = new Sprite();
  }
  
  private void advanceParticle(Particle paramParticle, double paramDouble)
  {
    if (this.mSprite.animated == 1)
    {
      long l = (int)((paramDouble - paramParticle.birth) / this.mSprite.frameDuration);
      int i = (int)(l % this.mSprite.frameCount);
      if (this.mSprite.looped == 1)
      {
        paramParticle.currFrame = i;
        return;
      }
      if (this.mSprite.looped == 2)
      {
        if ((l / this.mSprite.frameCount & 1L) == 1L)
        {
          paramParticle.currFrame = (this.mSprite.frameCount - 1 - i);
          return;
        }
        paramParticle.currFrame = i;
        return;
      }
      if (l >= this.mSprite.frameCount) {
        i = this.mSprite.frameCount - 1;
      }
      paramParticle.currFrame = i;
    }
  }
  
  private void computeQuota(double paramDouble)
  {
    double d1 = this.mLastQuotaTime;
    if (d1 == 0.0D)
    {
      this.mLastQuotaTime = paramDouble;
    }
    else
    {
      long l = this.mEmitRate;
      double d2 = l;
      Double.isNaN(d2);
      int i = (int)(d2 * (paramDouble - d1));
      if (i > 0)
      {
        this.mQuota += i;
        paramDouble = i;
        d2 = l;
        Double.isNaN(paramDouble);
        Double.isNaN(d2);
        this.mLastQuotaTime = (d1 + paramDouble / d2);
      }
    }
    if (this.mQuota > this.mMaxCount - this.mParticles.total) {
      this.mQuota = (this.mMaxCount - this.mParticles.total);
    }
  }
  
  private static Attribute createAttr(String paramString, Object paramObject)
  {
    Attribute localAttribute = new Attribute();
    localAttribute.mName = paramString;
    localAttribute.mValue = new Value(paramObject);
    int i;
    if (AttributeConst.ATTR_INDEX_MAP.containsKey(paramString)) {
      i = ((Integer)AttributeConst.ATTR_INDEX_MAP.get(paramString)).intValue();
    } else {
      i = -1;
    }
    localAttribute.mVarIndex = i;
    return localAttribute;
  }
  
  private double doubleValue(JsonObject paramJsonObject, String paramString)
  {
    paramJsonObject = paramJsonObject.get(paramString);
    if (((paramJsonObject instanceof JsonPrimitive)) && (((JsonPrimitive)paramJsonObject).isNumber())) {
      return paramJsonObject.getAsNumber().doubleValue();
    }
    return 0.0D;
  }
  
  static ParticleCloud fromJson(ParticleSystem paramParticleSystem, JsonObject paramJsonObject)
  {
    paramParticleSystem = new ParticleCloud(paramParticleSystem);
    try
    {
      paramParticleSystem.mName = paramJsonObject.get("name").getAsString();
      Iterator localIterator = paramJsonObject.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        JsonElement localJsonElement = paramJsonObject.get((String)localObject);
        if ((!(localJsonElement instanceof Number)) && (!(localJsonElement instanceof String)))
        {
          if (((localJsonElement instanceof JsonObject)) && (TextUtils.equals((CharSequence)localObject, "sprite"))) {
            paramParticleSystem.initSprite((JsonObject)localJsonElement);
          } else if (((localJsonElement instanceof JsonObject)) && (TextUtils.equals((CharSequence)localObject, "audio"))) {
            paramParticleSystem.mSprite.audioPath = GsonUtils.getStringUnsafe((JsonObject)localJsonElement, "path");
          }
        }
        else
        {
          localObject = createAttr((String)localObject, localJsonElement);
          paramParticleSystem.mAttrs.put(((Attribute)localObject).mName, localObject);
        }
      }
      paramParticleSystem.optimized();
      return paramParticleSystem;
    }
    catch (Exception paramParticleSystem)
    {
      paramParticleSystem.printStackTrace();
    }
    return null;
  }
  
  private void initParticle(Particle paramParticle, double paramDouble)
  {
    paramParticle.birth = paramDouble;
    paramParticle.tex = this.mSprite.path;
    paramParticle.frameCount = this.mSprite.frameCount;
    paramParticle.musicPlayed = false;
    paramParticle.a[2] = (this.mAttrValue[2]);
    paramParticle.a[0] = this.mAttrValue[0];
    paramParticle.a[1] = this.mAttrValue[1];
    paramParticle.a[7] = this.mAttrValue[7];
    paramParticle.a[8] = this.mAttrValue[8];
    paramParticle.a[9] = this.mAttrValue[9];
    paramParticle.a[3] = this.mAttrValue[3];
    paramParticle.a[4] = this.mAttrValue[4];
    paramParticle.a[5] = this.mAttrValue[5];
    paramParticle.a[6] = this.mAttrValue[6];
    advanceParticle(paramParticle, paramDouble);
  }
  
  private void initSprite(JsonObject paramJsonObject)
  {
    this.mSprite.path = GsonUtils.optString(paramJsonObject, "path");
    this.mSprite.frameCount = ((int)doubleValue(paramJsonObject, "frameCount"));
    this.mSprite.width = ((int)doubleValue(paramJsonObject, "width"));
    this.mSprite.height = ((int)doubleValue(paramJsonObject, "height"));
    this.mSprite.blendMode = ((int)doubleValue(paramJsonObject, "blendMode"));
    this.mSprite.animated = ((int)doubleValue(paramJsonObject, "animated"));
    this.mSprite.looped = ((int)doubleValue(paramJsonObject, "looped"));
    this.mSprite.frameDuration = doubleValue(paramJsonObject, "frameDuration");
  }
  
  private void optimized()
  {
    this.mMaxCount = (((Attribute)this.mAttrs.get("particleCountMax")).value());
    this.mEmitRate = (((Attribute)this.mAttrs.get("emissionRate")).value());
    this.mAttrExpressions = new long[10];
    this.mAttrExpressions[2] = ((Attribute)this.mAttrs.get("life")).expression();
    this.mAttrExpressions[3] = ((Attribute)this.mAttrs.get("colorR")).expression();
    this.mAttrExpressions[4] = ((Attribute)this.mAttrs.get("colorG")).expression();
    this.mAttrExpressions[5] = ((Attribute)this.mAttrs.get("colorB")).expression();
    this.mAttrExpressions[6] = ((Attribute)this.mAttrs.get("colorA")).expression();
    this.mAttrExpressions[7] = ((Attribute)this.mAttrs.get("positionX")).expression();
    this.mAttrExpressions[8] = ((Attribute)this.mAttrs.get("positionY")).expression();
    this.mAttrExpressions[9] = ((Attribute)this.mAttrs.get("positionZ")).expression();
    this.mAttrExpressions[0] = ((Attribute)this.mAttrs.get("width")).expression();
    this.mAttrExpressions[1] = ((Attribute)this.mAttrs.get("height")).expression();
    this.mAttrValue = new double[10];
    this.mAttrValue[2] = ((Attribute)this.mAttrs.get("life")).value();
    this.mAttrValue[3] = ((Attribute)this.mAttrs.get("colorR")).value();
    this.mAttrValue[4] = ((Attribute)this.mAttrs.get("colorG")).value();
    this.mAttrValue[5] = ((Attribute)this.mAttrs.get("colorB")).value();
    this.mAttrValue[6] = ((Attribute)this.mAttrs.get("colorA")).value();
    this.mAttrValue[7] = ((Attribute)this.mAttrs.get("positionX")).value();
    this.mAttrValue[8] = ((Attribute)this.mAttrs.get("positionY")).value();
    this.mAttrValue[9] = ((Attribute)this.mAttrs.get("positionZ")).value();
    this.mAttrValue[0] = ((Attribute)this.mAttrs.get("width")).value();
    this.mAttrValue[1] = ((Attribute)this.mAttrs.get("height")).value();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mAttrs.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Attribute)this.mAttrs.get(localObject);
      if (((Attribute)localObject).expression() != -1L) {
        localArrayList.add(localObject);
      }
    }
    this.mVarExpressions = new long[localArrayList.size()];
    this.mVarAttributes = new Attribute[localArrayList.size()];
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      this.mVarExpressions[i] = ((Attribute)localArrayList.get(i)).expression();
      this.mVarAttributes[i] = ((Attribute)localArrayList.get(i));
      i += 1;
    }
    this.paramOffsets = new int[(int)((Attribute)this.mAttrs.get("particleCountMax")).value() * 11];
  }
  
  public void createCache()
  {
    this.mResultBuffer = ByteBuffer.allocateDirect((int)(this.mMaxCount * this.mVarExpressions.length * 64L)).order(ByteOrder.nativeOrder()).asDoubleBuffer();
    this.mResultArray = new double[(int)(this.mMaxCount * this.mVarExpressions.length)];
    this.mCopiedParticles = new Particle();
    Particle localParticle = this.mCopiedParticles;
    int i = 0;
    while (i < this.mMaxCount)
    {
      localParticle.next = new Particle();
      localParticle = localParticle.next;
      i += 1;
    }
  }
  
  public void emitImmediately(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d = System.currentTimeMillis();
    Double.isNaN(d);
    d /= 1000.0D;
    Particle localParticle1 = this.mSystem.advanceObtainUnlocked();
    initParticle(localParticle1, d);
    localParticle1.touchedPosition[0] = paramDouble1;
    localParticle1.touchedPosition[1] = paramDouble2;
    localParticle1.touchedPosition[2] = paramDouble3;
    localParticle1.next = this.mParticles.next;
    Particle localParticle2 = this.mParticles;
    localParticle2.next = localParticle1;
    localParticle2.total += 1;
  }
  
  public Pair<Particle, ParticleExpressionBundle> getAdvanceExpression(double paramDouble)
  {
    ParticleExpressionBundle localParticleExpressionBundle = new ParticleExpressionBundle();
    Particle localParticle2 = this.mParticles.next;
    Particle localParticle1 = this.mParticles;
    for (;;)
    {
      Particle localParticle3 = localParticle1;
      for (localParticle1 = localParticle2;; localParticle1 = localParticle2)
      {
        if (localParticle1 == null) {
          break label158;
        }
        if ((localParticle1.a[2] <= 0.0D) || (localParticle1.a[2] + localParticle1.birth > paramDouble)) {
          break;
        }
        localParticle3.next = localParticle1.next;
        localParticle2 = localParticle1.next;
        this.mSystem.putUnlocked(localParticle1);
        localParticle1 = this.mParticles;
        localParticle1.total -= 1;
      }
      advanceParticle(localParticle1, paramDouble);
      this.mSystem.mParamsPool[(localParticle1.paramOffset + 10)] = (paramDouble - localParticle1.birth);
      localParticle2 = localParticle1.next;
    }
    label158:
    computeQuota(paramDouble);
    long l1 = this.mParticles.total;
    long l2 = this.mMaxCount;
    if ((l1 < l2) && (this.mQuota > 0L))
    {
      l1 = Math.min(l2 - this.mParticles.total, this.mQuota);
      this.mQuota -= l1;
      while (l1 > 0L)
      {
        localParticle1 = this.mSystem.advanceObtainUnlocked();
        initParticle(localParticle1, paramDouble);
        this.mSystem.mParamsPool[(localParticle1.paramOffset + 10)] = (paramDouble - localParticle1.birth);
        localParticle1.next = this.mParticles.next;
        localParticle2 = this.mParticles;
        localParticle2.next = localParticle1;
        localParticle2.total += 1;
        l1 -= 1L;
      }
    }
    localParticle1 = this.mParticles.next;
    int i = 0;
    int j = this.mParticles.total;
    while (i < j)
    {
      this.paramOffsets[i] = localParticle1.paramOffset;
      localParticle1 = localParticle1.next;
      i += 1;
    }
    localParticleExpressionBundle.expressions = this.mVarExpressions;
    localParticleExpressionBundle.paramLine = this.mParticles.total;
    localParticleExpressionBundle.paramOffsets = this.paramOffsets;
    return new Pair(this.mParticles, localParticleExpressionBundle);
  }
  
  public void release()
  {
    ParticleSystem.releaseExpression(this.mVarExpressions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleCloud
 * JD-Core Version:    0.7.0.1
 */