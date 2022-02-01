package com.tencent.ttpic.util;

import com.tencent.ttpic.facedetect.GenderType;

public class PersonParam
{
  private int mGenderType = 0;
  private boolean mHasMan = false;
  private boolean mHasWomen = false;
  private boolean mIsSets = true;
  private int mPersonID = -1;
  
  public int getGenderType()
  {
    return this.mGenderType;
  }
  
  public int getPersonID()
  {
    return this.mPersonID;
  }
  
  public boolean isGenderMatch(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt < 1) {}
    do
    {
      return true;
      if (this.mIsSets)
      {
        boolean bool1;
        if ((paramInt != GenderType.FEMALE.value) || (!this.mHasWomen))
        {
          bool1 = bool2;
          if (paramInt == GenderType.MALE.value)
          {
            bool1 = bool2;
            if (!this.mHasMan) {}
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    } while (this.mGenderType == paramInt);
    return false;
  }
  
  public void resetParam(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mIsSets = true;
    this.mHasMan = paramBoolean2;
    this.mHasWomen = paramBoolean1;
    this.mPersonID = -1;
    this.mGenderType = 0;
  }
  
  public PersonParam setGenderType(int paramInt)
  {
    this.mIsSets = false;
    this.mGenderType = paramInt;
    return this;
  }
  
  public PersonParam setPersonID(int paramInt)
  {
    this.mIsSets = false;
    this.mPersonID = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.PersonParam
 * JD-Core Version:    0.7.0.1
 */