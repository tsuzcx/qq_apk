package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.gson.JsonObject;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParticleSystemEx
{
  private static final String TAG = ParticleSystemEx.class.getSimpleName();
  private AdvanceRes[] mAdvanceRes;
  private List<ParticleTemplate> mClouds = new ArrayList();
  final Context mContext;
  private long mNativeCtx;
  private FloatBuffer mParticleCenterBuffer;
  private FloatBuffer mParticleColorBuffer;
  private FloatBuffer mParticleSizeBuffer;
  private FloatBuffer mParticleTexCoord;
  private float[] mPositionIndex;
  private Map<Sprite, ParticleTemplate> mSpriteMap = new HashMap();
  
  public ParticleSystemEx(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNativeCtx = nativeInit();
  }
  
  private void createCache(int paramInt1, int paramInt2)
  {
    this.mPositionIndex = new float[paramInt2 * 6];
    paramInt2 = 0;
    while (paramInt2 < this.mPositionIndex.length)
    {
      this.mPositionIndex[paramInt2] = (paramInt2 % 6 + 0.5F);
      paramInt2 += 1;
    }
    this.mParticleCenterBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 3 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleSizeBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 2 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleTexCoord = ByteBuffer.allocateDirect(paramInt1 * 6 * 2 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleColorBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 4 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
  }
  
  private void loadFinish()
  {
    this.mAdvanceRes = new AdvanceRes[this.mClouds.size()];
    int i = 0;
    int j = 0;
    int m;
    for (int k = 0; i < this.mClouds.size(); k = m)
    {
      ParticleTemplate localParticleTemplate = (ParticleTemplate)this.mClouds.get(i);
      m = k + localParticleTemplate.mMaxCount;
      k = j;
      if (localParticleTemplate.mMaxCount > j) {
        k = localParticleTemplate.mMaxCount;
      }
      this.mAdvanceRes[i] = new AdvanceRes();
      i += 1;
      j = k;
    }
    nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
    createCache(k, j);
  }
  
  private void loadParticle(String paramString)
  {
    Object localObject3;
    Object localObject1;
    StringBuilder localStringBuilder;
    try
    {
      if (paramString.startsWith("/"))
      {
        localObject3 = new InputStreamReader(new FileInputStream(paramString));
        localObject1 = new BufferedReader((Reader)localObject3, 1024);
        localStringBuilder = new StringBuilder();
        for (;;)
        {
          String str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break;
          }
          localStringBuilder.append(str);
        }
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      localObject1 = localStringBuilder.toString();
      ((InputStreamReader)localObject3).close();
      try
      {
        for (;;)
        {
          localObject1 = GsonUtils.json2JsonObject((String)localObject1);
          paramString = ParticleTemplate.fromJson(this, (JsonObject)localObject1, paramString.substring(0, paramString.lastIndexOf('/')));
          if (paramString == null) {
            break;
          }
          this.mClouds.add(paramString);
          this.mSpriteMap.put(paramString.mSprite, paramString);
          return;
          localObject3 = this.mContext.getAssets().open(paramString);
          localObject1 = new byte[((InputStream)localObject3).available()];
          ((InputStream)localObject3).read((byte[])localObject1);
          localObject1 = new String((byte[])localObject1);
          ((InputStream)localObject3).close();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          LogUtils.e(TAG, localException.getMessage());
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static native void nativeAdvance(long paramLong, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, FloatBuffer paramFloatBuffer3, FloatBuffer paramFloatBuffer4, AdvanceRes[] paramArrayOfAdvanceRes);
  
  public static native void nativeEmitAt(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public static native long nativeInit();
  
  public static native void nativeRegisterTemplate(long paramLong, Object[] paramArrayOfObject);
  
  public static native void nativeRelease(long paramLong);
  
  public List<FrameParticleData> advance()
  {
    int j = 0;
    if (this.mClouds.isEmpty()) {
      return null;
    }
    nativeAdvance(this.mNativeCtx, this.mParticleCenterBuffer, this.mParticleSizeBuffer, this.mParticleTexCoord, this.mParticleColorBuffer, this.mAdvanceRes);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mAdvanceRes.length)
    {
      FrameParticleData localFrameParticleData = new FrameParticleData();
      localArrayList.add(localFrameParticleData);
      AdvanceRes localAdvanceRes = this.mAdvanceRes[i];
      localFrameParticleData.particleCount = localAdvanceRes.particleCount;
      j += localAdvanceRes.particleCount;
      localFrameParticleData.positionIndex = Arrays.copyOf(this.mPositionIndex, localAdvanceRes.particleCount * 6);
      localFrameParticleData.particleCenter = new float[localAdvanceRes.particleCenterLen];
      this.mParticleCenterBuffer.position(localAdvanceRes.particleCenterOffset);
      this.mParticleCenterBuffer.get(localFrameParticleData.particleCenter);
      localFrameParticleData.particleSize = new float[localAdvanceRes.particleSizeLen];
      this.mParticleSizeBuffer.position(localAdvanceRes.particleSizeOffset);
      this.mParticleSizeBuffer.get(localFrameParticleData.particleSize);
      localFrameParticleData.texCoords = new float[localAdvanceRes.texCoordsLen];
      this.mParticleTexCoord.position(localAdvanceRes.texCoordsOffset);
      this.mParticleTexCoord.get(localFrameParticleData.texCoords);
      localFrameParticleData.particleColor = new float[localAdvanceRes.particleColorLen];
      this.mParticleColorBuffer.position(localAdvanceRes.particleColorOffset);
      this.mParticleColorBuffer.get(localFrameParticleData.particleColor);
      localFrameParticleData.audioPath = ((ParticleTemplate)this.mClouds.get(i)).mSprite.audioPath;
      localFrameParticleData.playAudio = localAdvanceRes.playAudio;
      localFrameParticleData.blendMode = ((ParticleTemplate)this.mClouds.get(i)).mSprite.blendMode;
      i += 1;
    }
    return localArrayList;
  }
  
  public void emitImmediately(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nativeEmitAt(this.mNativeCtx, paramFloat1, paramFloat2, paramFloat3);
  }
  
  protected void finalize()
  {
    release();
  }
  
  public List<Sprite> getSprites()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mClouds.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ParticleTemplate)localIterator.next()).mSprite);
    }
    return localArrayList;
  }
  
  public void loadParticleData(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        loadParticle((String)paramList.next());
      }
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      loadFinish();
    }
  }
  
  public void loadTestData()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("assets://flower1.json");
    loadParticleData(localArrayList);
  }
  
  public void release()
  {
    if (this.mNativeCtx != -1L)
    {
      nativeRelease(this.mNativeCtx);
      this.mNativeCtx = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleSystemEx
 * JD-Core Version:    0.7.0.1
 */