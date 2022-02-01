package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Pair;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ParticleSystem
{
  private static final String TAG = "ParticleSystem";
  private long mAdvanceIndex = 0L;
  private List<ParticleCloud> mClouds = new ArrayList();
  private final Context mContext;
  private ArrayList<Particle> mCopiedParticles = new ArrayList();
  double[] mParamsPool;
  final Particle mPool = new Particle();
  private Random mRandom = new Random();
  private Map<Sprite, ParticleCloud> mSpriteMap = new HashMap();
  
  public ParticleSystem(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static long compile(String paramString)
  {
    return nativeCompile(paramString);
  }
  
  private void createCache(int paramInt)
  {
    this.mParamsPool = new double[paramInt * 11];
    int i = 0;
    while (i < paramInt)
    {
      localObject = new Particle();
      ((Particle)localObject).paramOffset = (i * 11);
      ((Particle)localObject).next = this.mPool.next;
      Particle localParticle = this.mPool;
      localParticle.next = ((Particle)localObject);
      localParticle.total += 1;
      i += 1;
    }
    Object localObject = this.mClouds.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ParticleCloud)((Iterator)localObject).next()).createCache();
    }
  }
  
  private void loadFinish()
  {
    Iterator localIterator = this.mClouds.iterator();
    double d1;
    double d2;
    for (int i = 0; localIterator.hasNext(); i = (int)(d1 + d2))
    {
      ParticleCloud localParticleCloud = (ParticleCloud)localIterator.next();
      d1 = i;
      d2 = ((Attribute)localParticleCloud.mAttrs.get("particleCountMax")).value();
      Double.isNaN(d1);
    }
    createCache(i);
  }
  
  private void loadParticle(String paramString)
  {
    try
    {
      paramString = GsonUtils.json2JsonObject(paramString);
    }
    catch (Exception paramString)
    {
      LogUtils.e(TAG, paramString.getMessage());
      paramString = null;
    }
    paramString = ParticleCloud.fromJson(this, paramString);
    this.mClouds.add(paramString);
    this.mSpriteMap.put(paramString.mSprite, paramString);
  }
  
  public static native double[] nativeAdvance(long[] paramArrayOfLong, double[] paramArrayOfDouble, int[] paramArrayOfInt, int paramInt);
  
  public static native void nativeAdvanceEx(long[] paramArrayOfLong, double[] paramArrayOfDouble, int[] paramArrayOfInt, int paramInt, DoubleBuffer paramDoubleBuffer);
  
  public static native long nativeCompile(String paramString);
  
  public static native void nativeReleaseExpression(long[] paramArrayOfLong);
  
  private Particle obtainUnlocked()
  {
    if (this.mPool.next == null)
    {
      int i = 100;
      while (i > 0)
      {
        localParticle1 = new Particle();
        localParticle1.next = this.mPool.next;
        localParticle2 = this.mPool;
        localParticle2.next = localParticle1;
        localParticle2.total += 1;
        i -= 1;
      }
    }
    Particle localParticle1 = this.mPool.next;
    this.mPool.next = localParticle1.next;
    localParticle1.next = null;
    Particle localParticle2 = this.mPool;
    localParticle2.total -= 1;
    return localParticle1;
  }
  
  public static void releaseExpression(long[] paramArrayOfLong)
  {
    nativeReleaseExpression(paramArrayOfLong);
  }
  
  public ArrayList<Particle> advance()
  {
    ArrayList localArrayList = new ArrayList();
    double d = System.currentTimeMillis();
    Double.isNaN(d);
    d /= 1000.0D;
    Iterator localIterator = this.mClouds.iterator();
    Object localObject1 = this;
    ParticleCloud localParticleCloud;
    if (localIterator.hasNext()) {
      localParticleCloud = (ParticleCloud)localIterator.next();
    }
    for (;;)
    {
      int i;
      synchronized (((ParticleSystem)localObject1).mPool)
      {
        Pair localPair = localParticleCloud.getAdvanceExpression(d);
        nativeAdvanceEx(((ParticleExpressionBundle)localPair.second).expressions, ((ParticleSystem)localObject1).mParamsPool, ((ParticleExpressionBundle)localPair.second).paramOffsets, ((ParticleExpressionBundle)localPair.second).paramLine, localParticleCloud.mResultBuffer);
        localParticleCloud.mResultBuffer.rewind();
        localParticleCloud.mResultBuffer.get(localParticleCloud.mResultArray);
        int k = localParticleCloud.mVarAttributes.length;
        i = 0;
        if (i < k)
        {
          Attribute localAttribute = localParticleCloud.mVarAttributes[i];
          int m = ((Particle)localPair.first).total;
          localObject1 = ((Particle)localPair.first).next;
          int j = 0;
          if (localObject1 == null) {
            break label275;
          }
          ((Particle)localObject1).a[localAttribute.mVarIndex] = localParticleCloud.mResultArray[(i * m + j)];
          localObject1 = ((Particle)localObject1).next;
          j += 1;
          continue;
        }
        localArrayList.add(localPair.first);
      }
      return localArrayList;
      label275:
      i += 1;
    }
  }
  
  public ArrayList<Particle> advanceAsync()
  {
    this.mCopiedParticles.clear();
    synchronized (this.mPool)
    {
      Iterator localIterator = this.mClouds.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (ParticleCloud)localIterator.next();
        this.mCopiedParticles.add(((ParticleCloud)localObject1).mCopiedParticles);
        Particle localParticle1 = ((ParticleCloud)localObject1).mCopiedParticles;
        localObject1 = ((ParticleCloud)localObject1).mParticles;
        localParticle1.total = ((Particle)localObject1).total;
        while (((Particle)localObject1).next != null)
        {
          localParticle1.next.copy(((Particle)localObject1).next);
          localParticle1 = localParticle1.next;
          localObject1 = ((Particle)localObject1).next;
        }
      }
      return this.mCopiedParticles;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  Particle advanceObtainUnlocked()
  {
    Particle localParticle = obtainUnlocked();
    int i = 0;
    while (i < 11)
    {
      this.mParamsPool[(localParticle.paramOffset + i)] = Math.abs(this.mRandom.nextInt());
      i += 1;
    }
    return localParticle;
  }
  
  public void emitImmediately(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext())
    {
      ParticleCloud localParticleCloud = (ParticleCloud)localIterator.next();
      if (localParticleCloud.mEmitRate == 0L)
      {
        if (localParticleCloud.mParticles.total >= localParticleCloud.mMaxCount)
        {
          LogUtils.e(TAG, String.format("max: %d, now %d, can't emit any more", new Object[] { Long.valueOf(localParticleCloud.mMaxCount), Integer.valueOf(localParticleCloud.mParticles.total) }));
          return;
        }
        localParticleCloud.emitImmediately(paramDouble1, paramDouble2, paramDouble3);
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext()) {
      ((ParticleCloud)localIterator.next()).release();
    }
  }
  
  public List<Sprite> getSprites()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ParticleCloud)localIterator.next()).mSprite);
    }
    return localArrayList;
  }
  
  public void loadParticleData(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (String)paramList.next();
        Object localObject2;
        if (((String)localObject1).startsWith("/"))
        {
          localObject1 = new InputStreamReader(new FileInputStream((String)localObject1));
          localObject2 = new BufferedReader((Reader)localObject1, 1024);
          StringBuilder localStringBuilder = new StringBuilder();
          for (;;)
          {
            String str = ((BufferedReader)localObject2).readLine();
            if (str == null) {
              break;
            }
            localStringBuilder.append(str);
          }
          localArrayList.add(localStringBuilder.toString());
          ((InputStreamReader)localObject1).close();
        }
        else
        {
          localObject1 = this.mContext.getAssets().open((String)localObject1);
          localObject2 = new byte[((InputStream)localObject1).available()];
          ((InputStream)localObject1).read((byte[])localObject2);
          localArrayList.add(new String((byte[])localObject2));
          ((InputStream)localObject1).close();
        }
      }
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      if (!localArrayList.isEmpty()) {
        loadParticles(localArrayList);
      }
    }
  }
  
  public void loadParticles(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      loadParticle((String)paramList.next());
    }
    loadFinish();
  }
  
  void putUnlocked(Particle paramParticle)
  {
    paramParticle.next = this.mPool.next;
    Particle localParticle = this.mPool;
    localParticle.next = paramParticle;
    localParticle.total += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleSystem
 * JD-Core Version:    0.7.0.1
 */