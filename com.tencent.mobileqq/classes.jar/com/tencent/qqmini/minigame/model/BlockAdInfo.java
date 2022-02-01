package com.tencent.qqmini.minigame.model;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;

public class BlockAdInfo
{
  public static final int BLOCK_AD_SAFE_GAP = 32;
  public static final int BLOCK_UPDATE_SIZE_LEFT = 1;
  public static final int BLOCK_UPDATE_SIZE_NO = -1;
  public static final int BLOCK_UPDATE_SIZE_TOP = 2;
  private static final String TAG = "BlockAdPositionInfo";
  private ArrayList<MiniAppInfo> mAdMiniAppInfoList = new ArrayList();
  private String mAdUnitId = "";
  private int mId = 0;
  private int mLeft = 0;
  private int mOri = 0;
  private int mRealHeight = 0;
  private int mRealWidth = 0;
  private int mSize = 0;
  private int mTop = 0;
  
  public BlockAdInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mAdUnitId = paramString;
    this.mLeft = paramInt1;
    this.mTop = paramInt2;
    this.mSize = paramInt3;
    this.mOri = paramInt4;
    this.mId = paramInt5;
  }
  
  public String getAdUnitId()
  {
    return this.mAdUnitId;
  }
  
  public ArrayList<MiniAppInfo> getBlockAdInfo()
  {
    return this.mAdMiniAppInfoList;
  }
  
  public int getCompId()
  {
    return this.mId;
  }
  
  public int getLeft()
  {
    return this.mLeft;
  }
  
  public int getOri()
  {
    return this.mOri;
  }
  
  public int getRealHeight()
  {
    return this.mRealHeight;
  }
  
  public int getRealWidth()
  {
    return this.mRealWidth;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  public int getTop()
  {
    return this.mTop;
  }
  
  public boolean isValid()
  {
    if ((this.mLeft >= 0) && (this.mTop >= 0) && (this.mSize > 0))
    {
      int i = this.mOri;
      if ((i == 0) || (i == 90)) {
        return true;
      }
    }
    return false;
  }
  
  public void setLeft(int paramInt)
  {
    this.mLeft = paramInt;
  }
  
  public void setRealHeight(int paramInt)
  {
    this.mRealHeight = paramInt;
  }
  
  public void setRealWidth(int paramInt)
  {
    this.mRealWidth = paramInt;
  }
  
  public void setTop(int paramInt)
  {
    this.mTop = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.model.BlockAdInfo
 * JD-Core Version:    0.7.0.1
 */