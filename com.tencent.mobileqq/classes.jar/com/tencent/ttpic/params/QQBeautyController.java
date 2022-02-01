package com.tencent.ttpic.params;

import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.light.BeautyController;

public class QQBeautyController
  extends BeautyController
{
  private static final String TAG = "QQBeautyController";
  private ConcurrentHashMap<Integer, Boolean> mBasicOpenStatus;
  
  public QQBeautyController(Map<String, String> paramMap)
  {
    super(paramMap);
    initBasicBeautyOpenStatus();
  }
  
  private void initBasicBeautyOpenStatus()
  {
    if (this.mBasicOpenStatus == null) {
      this.mBasicOpenStatus = new ConcurrentHashMap();
    }
    this.mBasicOpenStatus.put(Integer.valueOf(1), Boolean.valueOf(false));
    this.mBasicOpenStatus.put(Integer.valueOf(2), Boolean.valueOf(false));
    this.mBasicOpenStatus.put(Integer.valueOf(3), Boolean.valueOf(false));
  }
  
  public void checkAssetMakeup()
  {
    if (isAssetHasMakeUp(1))
    {
      LogUtils.i("QQBeautyController", "updateAsset has lips");
      enableBasicBeautyMakeup(1, false);
      enableAssetBeautyMakeup(1, true);
    }
    else
    {
      LogUtils.i("QQBeautyController", "updateAsset has not lips");
      enableBasicBeautyMakeup(1, ((Boolean)this.mBasicOpenStatus.get(Integer.valueOf(1))).booleanValue());
    }
    if (isAssetHasMakeUp(3))
    {
      LogUtils.i("QQBeautyController", "updateAsset has saihong");
      enableBasicBeautyMakeup(3, false);
      enableAssetBeautyMakeup(3, true);
    }
    else
    {
      LogUtils.i("QQBeautyController", "updateAsset has not saihong");
      enableBasicBeautyMakeup(3, ((Boolean)this.mBasicOpenStatus.get(Integer.valueOf(3))).booleanValue());
    }
    if (isAssetHasMakeUp(2))
    {
      LogUtils.i("QQBeautyController", "updateAsset has wuguan");
      enableBasicBeautyMakeup(2, false);
      enableAssetBeautyMakeup(2, true);
      return;
    }
    LogUtils.i("QQBeautyController", "updateAsset has not wuguan");
    enableBasicBeautyMakeup(2, ((Boolean)this.mBasicOpenStatus.get(Integer.valueOf(2))).booleanValue());
  }
  
  public boolean isStatus(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 3)) {
      return ((Boolean)this.mBasicOpenStatus.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return false;
  }
  
  public void openAndUpdateBasicLips(String paramString, int paramInt1, int paramInt2)
  {
    super.openAndUpdateBasicLips(paramString, paramInt1, paramInt2);
    this.mBasicOpenStatus.put(Integer.valueOf(1), Boolean.valueOf(TextUtils.isEmpty(paramString) ^ true));
  }
  
  public void openAndUpdateBasicMultiply(String paramString, int paramInt)
  {
    super.openAndUpdateBasicMultiply(paramString, paramInt);
    this.mBasicOpenStatus.put(Integer.valueOf(3), Boolean.valueOf(TextUtils.isEmpty(paramString) ^ true));
  }
  
  public void openAndUpdateBasicSoftLight(String paramString, int paramInt)
  {
    super.openAndUpdateBasicSoftLight(paramString, paramInt);
    this.mBasicOpenStatus.put(Integer.valueOf(2), Boolean.valueOf(TextUtils.isEmpty(paramString) ^ true));
  }
  
  public void openBasicConfigMap(Map<String, String> paramMap, int paramInt)
  {
    if (paramMap == null) {
      return;
    }
    paramMap.put("beauty.faceFeature.enable", "true");
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        paramMap.put("beauty.makeupMultiply.enable", "true");
        return;
      }
      paramMap.put("beauty.softLight.enable", "true");
      return;
    }
    paramMap.put("beauty.lips.enable", "true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.params.QQBeautyController
 * JD-Core Version:    0.7.0.1
 */