package com.tencent.ttpic.filter.juyoujinggame;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import java.util.ArrayList;
import java.util.List;

public class UKYOTachi
  extends RenderItem
{
  private long mCurrentTime;
  private UKYOGame.RenderListener mRenderListener = null;
  private TachiSetting mTachiSetting;
  private UKYOTachi.TachiStatus mTachiStatus;
  private float[] prefaceAngles;
  private List<PointF> prefacePoints;
  private float prephoneAngle;
  
  public UKYOTachi(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem)
  {
    super(paramAEFilterI, paramTriggerCtrlItem);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    Object localObject = paramFrame;
    if (this.filter != null)
    {
      UKYOTachi.TachiStatus localTachiStatus = this.mTachiStatus;
      localObject = paramFrame;
      if (localTachiStatus != null)
      {
        if (localTachiStatus.mIsAppear) {
          return paramFrame;
        }
        if ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered())) {
          return paramFrame;
        }
        localObject = (UKYOFilter)this.filter;
        localObject = this.mRenderListener.RenderProcessForFilter(paramFrame, null, (VideoFilterBase)localObject);
      }
    }
    return localObject;
  }
  
  public void apply()
  {
    if (this.filter != null) {
      ((UKYOFilter)this.filter).applyChain();
    }
  }
  
  public void checkAppStatus(ArrayList<IHittingStatus> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      UKYOTachi.TachiStatus localTachiStatus = this.mTachiStatus;
      if (localTachiStatus == null) {
        return;
      }
      localTachiStatus.updateHittingStatus(paramArrayList);
    }
  }
  
  public void clear()
  {
    if (this.filter != null) {
      ((UKYOFilter)this.filter).clear();
    }
  }
  
  public void initTachiStatus(TachiSetting paramTachiSetting)
  {
    if (paramTachiSetting == null) {
      return;
    }
    this.mTachiSetting = paramTachiSetting;
    this.mTachiStatus = new UKYOTachi.TachiStatus(this, paramTachiSetting);
  }
  
  public void reset()
  {
    UKYOTachi.TachiStatus localTachiStatus = this.mTachiStatus;
    if (localTachiStatus != null) {
      localTachiStatus.reset();
    }
  }
  
  public void setListener(UKYOGame.RenderListener paramRenderListener)
  {
    this.mRenderListener = paramRenderListener;
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.filter != null) {
      ((UKYOFilter)this.filter).setRenderMode(paramInt);
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof PTDetectInfo)) {
        return;
      }
      Object localObject = (PTDetectInfo)paramObject;
      PTFaceAttr localPTFaceAttr = (PTFaceAttr)((PTDetectInfo)localObject).aiAttr.getFaceAttr();
      if ((((PTDetectInfo)localObject).facePoints != null) && (this.mTachiSetting != null) && (localPTFaceAttr != null) && (PTFaceAttr.checkFaceFeatureOutScreenUKYO(((PTDetectInfo)localObject).facePoints, this.mTachiSetting.mWidth, this.mTachiSetting.mHeight, localPTFaceAttr.getFaceDetectScale())))
      {
        this.prefacePoints = ((PTDetectInfo)localObject).facePoints;
        this.prefaceAngles = ((PTDetectInfo)localObject).faceAngles;
        this.prephoneAngle = ((PTDetectInfo)localObject).phoneAngle;
      }
      this.mCurrentTime = ((PTDetectInfo)localObject).timestamp;
      localObject = this.mTachiStatus;
      if (localObject != null)
      {
        ((UKYOTachi.TachiStatus)localObject).updateCurTime(this.mCurrentTime);
        if (this.filter != null)
        {
          ((UKYOFilter)this.filter).setImageID(this.mTachiStatus.getImageId());
          localObject = (UKYOFilter)this.filter;
          int i;
          if (this.mTachiStatus.mCurFrameIndex >= 0) {
            i = this.mTachiStatus.mCurFrameIndex;
          } else {
            i = 0;
          }
          ((UKYOFilter)localObject).setFrameIndex(i);
          ((UKYOFilter)this.filter).setPositions(this.mTachiStatus.updatePositions(this.prefacePoints, this.prefaceAngles, this.prephoneAngle));
          this.filter.updatePreview(paramObject);
          ((NormalVideoFilter)this.filter).setTriggered(true);
        }
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.filter == null) {
      return;
    }
    ((UKYOFilter)this.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    Object localObject = this.mTachiSetting;
    if ((localObject != null) && (((TachiSetting)localObject).mWidth == 0))
    {
      localObject = this.mTachiSetting;
      ((TachiSetting)localObject).mWidth = paramInt1;
      ((TachiSetting)localObject).mHeight = paramInt2;
      ((TachiSetting)localObject).updateItemWidth(paramInt1);
    }
    localObject = this.mTachiStatus;
    if (localObject != null) {
      ((UKYOTachi.TachiStatus)localObject).mFaceDetScale = paramDouble;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOTachi
 * JD-Core Version:    0.7.0.1
 */