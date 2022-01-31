package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.util.LogUtil;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

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
    this.mParticleCenterBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 3 * 32 / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleSizeBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 2 * 32 / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleTexCoord = ByteBuffer.allocateDirect(paramInt1 * 6 * 2 * 32 / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mParticleColorBuffer = ByteBuffer.allocateDirect(paramInt1 * 6 * 4 * 32 / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
  }
  
  private void loadFinish()
  {
    this.mAdvanceRes = new AdvanceRes[this.mClouds.size()];
    int m = 0;
    int i = 0;
    int j = 0;
    while (j < this.mClouds.size())
    {
      ParticleTemplate localParticleTemplate = (ParticleTemplate)this.mClouds.get(j);
      m += localParticleTemplate.mMaxCount;
      int k = i;
      if (localParticleTemplate.mMaxCount > i) {
        k = localParticleTemplate.mMaxCount;
      }
      this.mAdvanceRes[j] = new AdvanceRes();
      j += 1;
      i = k;
    }
    nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
    createCache(m, i);
  }
  
  private void loadParticle(String paramString)
  {
    Object localObject1;
    Object localObject3;
    try
    {
      if (paramString.startsWith("/"))
      {
        localObject1 = new BufferedReader(new InputStreamReader(new FileInputStream(paramString)), 1024);
        localObject3 = new StringBuilder();
        for (;;)
        {
          String str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break;
          }
          ((StringBuilder)localObject3).append(str);
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
      localObject1 = ((StringBuilder)localObject3).toString();
      localObject3 = null;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        paramString = ParticleTemplate.fromJson(this, (JSONObject)localObject1, paramString.substring(0, paramString.lastIndexOf('/')));
        if (paramString == null) {
          continue;
        }
        this.mClouds.add(paramString);
        this.mSpriteMap.put(paramString.mSprite, paramString);
        return;
        localObject1 = this.mContext.getAssets().open(paramString);
        localObject3 = new byte[((InputStream)localObject1).available()];
        ((InputStream)localObject1).read((byte[])localObject3);
        localObject1 = new String((byte[])localObject3);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          LogUtil.e(TAG, localJSONException.getMessage());
          Object localObject2 = localObject3;
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
    ArrayList localArrayList = null;
    Object localObject;
    if (this.mClouds.isEmpty()) {
      localObject = localArrayList;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject;
              localObject = localArrayList;
            } while (this.mPositionIndex == null);
            localObject = localArrayList;
          } while (this.mParticleCenterBuffer == null);
          localObject = localArrayList;
        } while (this.mParticleSizeBuffer == null);
        localObject = localArrayList;
      } while (this.mParticleTexCoord == null);
      localObject = localArrayList;
    } while (this.mParticleColorBuffer == null);
    int j = 0;
    nativeAdvance(this.mNativeCtx, this.mParticleCenterBuffer, this.mParticleSizeBuffer, this.mParticleTexCoord, this.mParticleColorBuffer, this.mAdvanceRes);
    localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= this.mAdvanceRes.length) {
        break;
      }
      localObject = new FrameParticleData();
      localArrayList.add(localObject);
      AdvanceRes localAdvanceRes = this.mAdvanceRes[i];
      ((FrameParticleData)localObject).particleCount = localAdvanceRes.particleCount;
      j += localAdvanceRes.particleCount;
      ((FrameParticleData)localObject).positionIndex = Arrays.copyOf(this.mPositionIndex, localAdvanceRes.particleCount * 6);
      ((FrameParticleData)localObject).particleCenter = new float[localAdvanceRes.particleCenterLen];
      this.mParticleCenterBuffer.position(localAdvanceRes.particleCenterOffset);
      this.mParticleCenterBuffer.get(((FrameParticleData)localObject).particleCenter);
      ((FrameParticleData)localObject).particleSize = new float[localAdvanceRes.particleSizeLen];
      this.mParticleSizeBuffer.position(localAdvanceRes.particleSizeOffset);
      this.mParticleSizeBuffer.get(((FrameParticleData)localObject).particleSize);
      ((FrameParticleData)localObject).texCoords = new float[localAdvanceRes.texCoordsLen];
      this.mParticleTexCoord.position(localAdvanceRes.texCoordsOffset);
      this.mParticleTexCoord.get(((FrameParticleData)localObject).texCoords);
      ((FrameParticleData)localObject).particleColor = new float[localAdvanceRes.particleColorLen];
      this.mParticleColorBuffer.position(localAdvanceRes.particleColorOffset);
      this.mParticleColorBuffer.get(((FrameParticleData)localObject).particleColor);
      ((FrameParticleData)localObject).audioPath = ((ParticleTemplate)this.mClouds.get(i)).mSprite.audioPath;
      ((FrameParticleData)localObject).playAudio = localAdvanceRes.playAudio;
      ((FrameParticleData)localObject).blendMode = ((ParticleTemplate)this.mClouds.get(i)).mSprite.blendMode;
      i += 1;
    }
  }
  
  public void emitImmediately(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nativeEmitAt(this.mNativeCtx, paramFloat1, paramFloat2, paramFloat3);
  }
  
  protected void finalize()
    throws Throwable
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
    this.mParticleCenterBuffer = null;
    this.mParticleSizeBuffer = null;
    this.mParticleTexCoord = null;
    this.mParticleColorBuffer = null;
    this.mPositionIndex = null;
  }
  
  private class TexCoord
  {
    float[] texCoord = new float[12];
    
    private TexCoord() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleSystemEx
 * JD-Core Version:    0.7.0.1
 */