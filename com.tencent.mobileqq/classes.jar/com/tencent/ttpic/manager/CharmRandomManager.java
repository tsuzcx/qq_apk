package com.tencent.ttpic.manager;

import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CharmRandomManager
{
  public static final int ALWAYS_TRIGGERED_RANDOM_INDEX = 0;
  public static final int HAND_RANDOM_INDEX = 0;
  private static final CharmRandomManager INSTANCE = new CharmRandomManager();
  private static final Random mRandom = new Random(System.currentTimeMillis());
  private boolean isUpdateFaceCharm;
  private boolean isUpdateHandCharm;
  private Map<Integer, Double> mCharmValueMap = new HashMap();
  private Map<Integer, Double> mHandsValueMap = new HashMap();
  
  CharmRandomManager()
  {
    clearAll();
  }
  
  public static CharmRandomManager getInstance()
  {
    return INSTANCE;
  }
  
  public void clearAll()
  {
    this.mCharmValueMap.clear();
    this.mHandsValueMap.clear();
  }
  
  public void clearFaceRandoms()
  {
    this.mCharmValueMap.clear();
  }
  
  public void clearHandRandoms()
  {
    this.mHandsValueMap.clear();
  }
  
  public boolean constainsFaceCharm(int paramInt)
  {
    return this.mCharmValueMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public boolean containsHandCharm(int paramInt)
  {
    return this.mHandsValueMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public double getFaceCharmValue(int paramInt)
  {
    return ((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue();
  }
  
  public double getHandCharmValue()
  {
    return ((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue();
  }
  
  public void removeCharmRange(int paramInt)
  {
    this.mCharmValueMap.remove(Integer.valueOf(paramInt));
  }
  
  public void updateCharmValue(List<Integer> paramList, boolean paramBoolean)
  {
    boolean bool = CollectionUtils.isEmpty(paramList);
    Integer localInteger = Integer.valueOf(0);
    if (((!bool) && (!this.mCharmValueMap.containsKey(paramList.get(0)))) || ((paramBoolean) && (!this.mHandsValueMap.containsKey(localInteger))))
    {
      if (this.isUpdateHandCharm)
      {
        if ((paramBoolean) && (!this.mHandsValueMap.containsKey(localInteger)))
        {
          d1 = mRandom.nextDouble();
          break label310;
        }
        if (this.mHandsValueMap.containsKey(localInteger))
        {
          d1 = ((Double)this.mHandsValueMap.get(localInteger)).doubleValue();
          break label310;
        }
      }
      else if (this.isUpdateFaceCharm)
      {
        if ((!CollectionUtils.isEmpty(paramList)) && (!this.mCharmValueMap.containsKey(paramList.get(0))))
        {
          d1 = mRandom.nextDouble();
          break label310;
        }
        if ((!CollectionUtils.isEmpty(paramList)) && (this.mCharmValueMap.containsKey(paramList.get(0))))
        {
          d1 = ((Double)this.mCharmValueMap.get(paramList.get(0))).doubleValue();
          break label310;
        }
      }
    }
    else
    {
      if ((!CollectionUtils.isEmpty(paramList)) && (this.mCharmValueMap.containsKey(paramList.get(0))))
      {
        d1 = ((Double)this.mCharmValueMap.get(paramList.get(0))).doubleValue();
        break label310;
      }
      if (this.mHandsValueMap.containsKey(localInteger))
      {
        d1 = ((Double)this.mHandsValueMap.get(localInteger)).doubleValue();
        break label310;
      }
    }
    double d1 = -1.0D;
    label310:
    double d2 = d1;
    if (d1 < 0.0D) {
      d2 = mRandom.nextDouble();
    }
    if (!CollectionUtils.isEmpty(paramList))
    {
      int i = ((Integer)paramList.get(0)).intValue();
      this.mCharmValueMap.put(Integer.valueOf(i), Double.valueOf(d2));
      i = 1;
      while (i < paramList.size())
      {
        int j = ((Integer)paramList.get(i)).intValue();
        if (!this.mCharmValueMap.containsKey(Integer.valueOf(j))) {
          this.mCharmValueMap.put(paramList.get(i), Double.valueOf(mRandom.nextDouble()));
        }
        i += 1;
      }
    }
    if (paramBoolean) {
      this.mHandsValueMap.put(localInteger, Double.valueOf(d2));
    }
  }
  
  public void updateCharmValueForCosFunGroup(List<Integer> paramList, double paramDouble, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramDouble = -1.0D;
    }
    this.mCharmValueMap.put(Integer.valueOf(0), Double.valueOf(paramDouble));
    if (paramList != null)
    {
      int i = 1;
      while (i < paramList.size())
      {
        int j = ((Integer)paramList.get(i)).intValue();
        if (!this.mCharmValueMap.containsKey(Integer.valueOf(j))) {
          this.mCharmValueMap.put(paramList.get(i), Double.valueOf(paramDouble));
        }
        i += 1;
      }
    }
    this.mHandsValueMap.put(Integer.valueOf(0), Double.valueOf(paramDouble));
  }
  
  public void updateUpdateMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isUpdateFaceCharm = paramBoolean1;
    this.isUpdateHandCharm = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.manager.CharmRandomManager
 * JD-Core Version:    0.7.0.1
 */