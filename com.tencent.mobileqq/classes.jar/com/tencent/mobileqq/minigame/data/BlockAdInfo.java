package com.tencent.mobileqq.minigame.data;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class BlockAdInfo
{
  public static final int BLOCK_UPDATE_SIZE_LEFT = 1;
  public static final int BLOCK_UPDATE_SIZE_NO = -1;
  public static final int BLOCK_UPDATE_SIZE_TOP = 2;
  private static final String TAG = "BlockAdPositionInfo";
  private ArrayList<MiniAppInfo> mAdMiniAppInfoList = new ArrayList();
  private String mAdUnitId = "";
  private List<GdtAd> mGdtAdInfoList = new ArrayList();
  private int mId;
  private int mLeft;
  private int mOri;
  private int mRealHeight;
  private int mRealWidth;
  private int mSize;
  private int mTop;
  
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
  
  public List<GdtAd> getGdtAdInfoList()
  {
    return this.mGdtAdInfoList;
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
    return (this.mLeft >= 0) && (this.mTop >= 0) && (this.mSize > 0) && ((this.mOri == 0) || (this.mOri == 90));
  }
  
  public void setAdMiniAppInfo(List<GdtAd> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    this.mGdtAdInfoList = paramList;
    this.mAdMiniAppInfoList.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (GdtAd)localIterator.next();
      paramList = "";
      if ((localObject != null) && (((GdtAd)localObject).info != null) && (((GdtAd)localObject).info.display_info != null))
      {
        if (((GdtAd)localObject).info.display_info.basic_info != null) {
          paramList = ((GdtAd)localObject).info.display_info.basic_info.img.get();
        }
        String str = ((GdtAd)localObject).info.display_info.mini_program_id.get();
        localObject = ((GdtAd)localObject).info.display_info.mini_program_name.get();
        if ((!TextUtils.isEmpty(paramList)) && (!TextUtils.isEmpty(paramList)) && (!TextUtils.isEmpty(paramList)))
        {
          MiniAppInfo localMiniAppInfo = new MiniAppInfo();
          localMiniAppInfo.appId = str;
          localMiniAppInfo.iconUrl = paramList;
          localMiniAppInfo.name = ((String)localObject);
          this.mAdMiniAppInfoList.add(localMiniAppInfo);
        }
      }
    }
    this.mSize = this.mGdtAdInfoList.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.BlockAdInfo
 * JD-Core Version:    0.7.0.1
 */