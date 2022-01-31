package com.tencent.ttpic.particlesystem2d;

import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.WMGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ParticleItem
{
  private static final String TAG = ParticleItem.class.getSimpleName();
  private TreeSet<Integer> activeWMGroupIndiesSet = new TreeSet();
  public boolean canUpdateTexture = true;
  public int clearMode;
  public int curRepeatCount = 0;
  public int curTexture;
  public int curWMGroupId;
  public int emissionMode;
  public float emitterX;
  public float emitterY;
  private TreeSet<Integer> idleWMGroupIndiesSet = new TreeSet();
  public boolean lastFrameParticleReachMax;
  public long lastUpdateTimestamp;
  public List<WMGroup> lockedWMGroups = new ArrayList();
  public int maxRepeatCount = 1;
  public int minUpdateInterval;
  public boolean particleAlwaysUpdate;
  public boolean particleReachMax;
  public Particle[] particles;
  public float screenRatioScale = 1.0F;
  public StickerItem stickerItem;
  public boolean takenByParticle = false;
  public boolean textureUpdated;
  public TriggerCtrlItem triggerCtrlItem;
  public boolean triggered;
  public int updateCount = 0;
  public List<WMGroup> wmGroupCopies;
  
  public ParticleItem(StickerItem paramStickerItem)
  {
    this.stickerItem = paramStickerItem;
    initIdleWMGroupIndiesSet();
  }
  
  private void initIdleWMGroupIndiesSet()
  {
    int i = 0;
    while (i < this.stickerItem.wmGroupConfigCopies.size())
    {
      this.idleWMGroupIndiesSet.add(Integer.valueOf(i));
      i += 1;
    }
  }
  
  public List<WMGroup> getActiveWMGroups()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.activeWMGroupIndiesSet.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (((WMGroup)this.wmGroupCopies.get(i)).isAsyncDrawFinished()) {
        localArrayList.add(this.wmGroupCopies.get(i));
      }
    }
    return localArrayList;
  }
  
  public WMGroup getAvailableWMGroup()
  {
    if (!this.idleWMGroupIndiesSet.isEmpty()) {
      return (WMGroup)this.wmGroupCopies.get(((Integer)this.idleWMGroupIndiesSet.pollFirst()).intValue());
    }
    return null;
  }
  
  public void recycleWMGroup(int paramInt)
  {
    this.idleWMGroupIndiesSet.add(Integer.valueOf(paramInt));
    this.activeWMGroupIndiesSet.remove(Integer.valueOf(paramInt));
    ((WMGroup)this.wmGroupCopies.get(paramInt)).reset();
  }
  
  public void reset()
  {
    this.particleReachMax = false;
    this.lastFrameParticleReachMax = false;
    this.canUpdateTexture = true;
    this.curRepeatCount = 0;
    this.curTexture = 0;
    this.triggered = false;
    if (this.particles != null)
    {
      Particle[] arrayOfParticle = this.particles;
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
    if (this.stickerItem.wmGroupConfigCopies != null)
    {
      Iterator localIterator = this.wmGroupCopies.iterator();
      while (localIterator.hasNext())
      {
        WMGroup localWMGroup = (WMGroup)localIterator.next();
        localWMGroup.unlock();
        localWMGroup.reset();
      }
    }
  }
  
  public void useWMGroup(int paramInt)
  {
    this.idleWMGroupIndiesSet.remove(Integer.valueOf(paramInt));
    this.activeWMGroupIndiesSet.add(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.particlesystem2d.ParticleItem
 * JD-Core Version:    0.7.0.1
 */