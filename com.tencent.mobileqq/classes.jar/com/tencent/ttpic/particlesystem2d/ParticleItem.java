package com.tencent.ttpic.particlesystem2d;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.TreeSet;

public class ParticleItem
{
  private static final String TAG = "ParticleItem";
  private TreeSet<Integer> activeWMGroupIndiesSet = new TreeSet();
  public boolean canUpdateTexture = true;
  public int clearMode;
  public int curRepeatCount = 0;
  public int curTexture;
  public int curWMGroupId;
  public int emissionMode;
  public float emitterX;
  public float emitterY;
  public String id;
  private TreeSet<Integer> idleWMGroupIndiesSet = new TreeSet();
  public boolean lastFrameParticleReachMax;
  public long lastUpdateTimestamp;
  public int maxRepeatCount = 1;
  public int minUpdateInterval;
  public boolean particleAlwaysUpdate;
  public boolean particleReachMax;
  public Particle[] particles;
  public float screenRatioScale = 1.0F;
  public StickerItem stickerItem;
  public boolean takenByParticle = false;
  public boolean textureUpdated;
  public boolean triggered;
  public int updateCount = 0;
  
  public ParticleItem(StickerItem paramStickerItem)
  {
    this.stickerItem = paramStickerItem;
    initIdleWMGroupIndiesSet();
  }
  
  private void initIdleWMGroupIndiesSet() {}
  
  public void recycleWMGroup(int paramInt)
  {
    this.idleWMGroupIndiesSet.add(Integer.valueOf(paramInt));
    this.activeWMGroupIndiesSet.remove(Integer.valueOf(paramInt));
  }
  
  public void reset()
  {
    this.particleReachMax = false;
    this.lastFrameParticleReachMax = false;
    this.canUpdateTexture = true;
    this.curRepeatCount = 0;
    this.curTexture = 0;
    this.triggered = false;
    Particle[] arrayOfParticle = this.particles;
    if (arrayOfParticle != null)
    {
      int j = arrayOfParticle.length;
      int i = 0;
      while (i < j)
      {
        Particle localParticle = arrayOfParticle[i];
        localParticle.alive = false;
        localParticle.texture = 0;
        i += 1;
      }
    }
    resetWMGroup();
  }
  
  public void resetWMGroup()
  {
    this.idleWMGroupIndiesSet.clear();
    this.activeWMGroupIndiesSet.clear();
    initIdleWMGroupIndiesSet();
  }
  
  public void useWMGroup(int paramInt)
  {
    this.idleWMGroupIndiesSet.remove(Integer.valueOf(paramInt));
    this.activeWMGroupIndiesSet.add(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.particlesystem2d.ParticleItem
 * JD-Core Version:    0.7.0.1
 */