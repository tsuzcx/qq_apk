package com.tencent.ttpic.openapi.manager;

import java.util.Arrays;

public class FaceOffFilterManager
{
  public static final int CHANGE_SWITCH_OFF = 1;
  public static final int CHANGE_SWITCH_ON = 0;
  public static final int COSMETIC_CHANGE_MODE_RANDOM = 0;
  public static final int COSMETIC_CHANGE_MODE_SEQUENCE = 1;
  public static final int LEFTCHEEK = 1;
  public static final int LEFTSHADOW = 3;
  public static final int LIPS = 0;
  private static final int MATERIAL_COUNT = 5;
  public static final int RIGHTCHEEK = 2;
  public static final int RIGHTSHADOW = 4;
  public static final int SHELTER_SWITCH_OFF = 1;
  public static final int SHELTER_SWITCH_ON = 0;
  private int changeSwitch = 0;
  private int cosmeticChangeMode = 0;
  private int[] materialIndex = new int[5];
  private int[] materialMaxCount = new int[5];
  private boolean[] needUpdate = new boolean[5];
  private int shelterSwitch = 0;
  
  public static FaceOffFilterManager getInstance()
  {
    return FaceOffFilterManager.Holder.access$100();
  }
  
  public int getChangeSwitch()
  {
    return this.changeSwitch;
  }
  
  public int getRandomIndex(int paramInt)
  {
    return this.materialIndex[paramInt];
  }
  
  public int getShelterSwitch()
  {
    return this.shelterSwitch;
  }
  
  public void reset()
  {
    Arrays.fill(this.materialIndex, 0);
    Arrays.fill(this.needUpdate, true);
    Arrays.fill(this.materialMaxCount, 0);
    this.shelterSwitch = 0;
    this.changeSwitch = 0;
    this.cosmeticChangeMode = 0;
  }
  
  public void setCosmeticChangeMode(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1)) {
      this.cosmeticChangeMode = paramInt;
    }
  }
  
  public void setMaterialsMaxCount(int paramInt1, int paramInt2)
  {
    this.materialMaxCount[paramInt1] = Math.max(paramInt2, this.materialMaxCount[paramInt1]);
  }
  
  public void setSwitch(int paramInt1, int paramInt2)
  {
    this.shelterSwitch = paramInt1;
    this.changeSwitch = paramInt2;
  }
  
  public void setUpdateStatus(int paramInt, boolean paramBoolean)
  {
    this.needUpdate[paramInt] = paramBoolean;
  }
  
  public void updateIndex()
  {
    int i = 0;
    if (i < 5)
    {
      if (this.needUpdate[i] != 0) {
        if (this.materialMaxCount[i] > 1)
        {
          if (this.cosmeticChangeMode != 1) {
            break label79;
          }
          int[] arrayOfInt = this.materialIndex;
          arrayOfInt[i] += 1;
          arrayOfInt = this.materialIndex;
          arrayOfInt[i] %= this.materialMaxCount[i];
        }
      }
      for (;;)
      {
        this.needUpdate[i] = false;
        i += 1;
        break;
        label79:
        for (int j = this.materialIndex[i]; j == this.materialIndex[i]; j = (int)(Math.random() * this.materialMaxCount[i])) {}
        this.materialIndex[i] = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.FaceOffFilterManager
 * JD-Core Version:    0.7.0.1
 */