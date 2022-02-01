package com.tencent.mobileqq.flashshow.api.bean;

import java.util.HashMap;

public class FSFolderBean
  extends FSInitBean
{
  HashMap<String, String> attrs;
  private boolean isPublish;
  private float mBottomMargin = 0.0F;
  private boolean mHasRedDot;
  private String mLastPageScheme;
  private int mQQCircleUnreadRedNum;
  private byte[] mRedDotTransInfo;
  private int mTabType = -1;
  
  public FSFolderBean(FSReportBean paramFSReportBean)
  {
    super(paramFSReportBean);
  }
  
  public int getAssignShowTabType()
  {
    return this.mTabType;
  }
  
  public HashMap<String, String> getAttrs()
  {
    return this.attrs;
  }
  
  public float getBottomMarginPx()
  {
    return this.mBottomMargin;
  }
  
  public String getLastPageScheme()
  {
    return this.mLastPageScheme;
  }
  
  public int getQQCircleUnreadRedNum()
  {
    return this.mQQCircleUnreadRedNum;
  }
  
  public byte[] getRedDotTransInfo()
  {
    return this.mRedDotTransInfo;
  }
  
  public boolean hasRedDotShownOnEntrance()
  {
    return this.mHasRedDot;
  }
  
  public boolean isPublish()
  {
    return this.isPublish;
  }
  
  public void setAssignShowTabType(int paramInt)
  {
    this.mTabType = paramInt;
  }
  
  public void setAttrs(HashMap<String, String> paramHashMap)
  {
    this.attrs = paramHashMap;
  }
  
  public void setBottomMargin(float paramFloat)
  {
    this.mBottomMargin = paramFloat;
  }
  
  public void setHasRedDot(boolean paramBoolean)
  {
    this.mHasRedDot = paramBoolean;
  }
  
  public void setLastPageScheme(String paramString)
  {
    this.mLastPageScheme = paramString;
  }
  
  public void setPublish(boolean paramBoolean)
  {
    this.isPublish = paramBoolean;
  }
  
  public void setRedDotTransInfo(byte[] paramArrayOfByte)
  {
    this.mRedDotTransInfo = paramArrayOfByte;
  }
  
  public void setUnreadRedNum(int paramInt)
  {
    this.mQQCircleUnreadRedNum = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.bean.FSFolderBean
 * JD-Core Version:    0.7.0.1
 */