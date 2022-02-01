package com.tencent.mobileqq.newnearby.impl;

import com.tencent.mobileqq.newnearby.INearbyVersionControl;

public class NearbyVersionControlImpl
  implements INearbyVersionControl
{
  private int mLocalVersion = 1;
  
  public int getVersion()
  {
    return this.mLocalVersion;
  }
  
  public void updateVersion(int paramInt)
  {
    this.mLocalVersion = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyVersionControlImpl
 * JD-Core Version:    0.7.0.1
 */