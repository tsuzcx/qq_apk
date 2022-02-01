package com.tencent.ttpic.filter.juyoujinggame;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
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
    if ((this.filter == null) || (this.mTachiStatus == null) || (this.mTachiStatus.mIsAppear)) {}
    while ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered())) {
      return paramFrame;
    }
    UKYOFilter localUKYOFilter = (UKYOFilter)this.filter;
    return this.mRenderListener.RenderProcessForFilter(paramFrame, null, localUKYOFilter);
  }
  
  public void apply()
  {
    if (this.filter != null) {
      ((UKYOFilter)this.filter).applyChain();
    }
  }
  
  public void checkAppStatus(ArrayList<IHittingStatus> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (this.mTachiStatus == null)) {
      return;
    }
    this.mTachiStatus.updateHittingStatus(paramArrayList);
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
    if (this.mTachiStatus != null) {
      this.mTachiStatus.reset();
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
    if ((paramObject == null) || (!(paramObject instanceof PTDetectInfo))) {}
    do
    {
      do
      {
        return;
        localObject = (PTDetectInfo)paramObject;
        PTFaceAttr localPTFaceAttr = (PTFaceAttr)((PTDetectInfo)localObject).aiAttr.getFaceAttr();
        if ((((PTDetectInfo)localObject).facePoints != null) && (this.mTachiSetting != null) && (localPTFaceAttr != null) && (PTFaceAttr.checkFaceFeatureOutScreenUKYO(((PTDetectInfo)localObject).facePoints, this.mTachiSetting.mWidth, this.mTachiSetting.mHeight, localPTFaceAttr.getFaceDetectScale())))
        {
          this.prefacePoints = ((PTDetectInfo)localObject).facePoints;
          this.prefaceAngles = ((PTDetectInfo)localObject).faceAngles;
          this.prephoneAngle = ((PTDetectInfo)localObject).phoneAngle;
        }
        this.mCurrentTime = ((PTDetectInfo)localObject).timestamp;
      } while (this.mTachiStatus == null);
      this.mTachiStatus.updateCurTime(this.mCurrentTime);
    } while (this.filter == null);
    ((UKYOFilter)this.filter).setImageID(this.mTachiStatus.getImageId());
    Object localObject = (UKYOFilter)this.filter;
    if (this.mTachiStatus.mCurFrameIndex >= 0) {}
    for (int i = this.mTachiStatus.mCurFrameIndex;; i = 0)
    {
      ((UKYOFilter)localObject).setFrameIndex(i);
      ((UKYOFilter)this.filter).setPositions(this.mTachiStatus.updatePositions(this.prefacePoints, this.prefaceAngles, this.prephoneAngle));
      this.filter.updatePreview(paramObject);
      ((NormalVideoFilter)this.filter).setTriggered(true);
      return;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.filter == null) {}
    do
    {
      return;
      ((UKYOFilter)this.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
      if ((this.mTachiSetting != null) && (this.mTachiSetting.mWidth == 0))
      {
        this.mTachiSetting.mWidth = paramInt1;
        this.mTachiSetting.mHeight = paramInt2;
        this.mTachiSetting.updateItemWidth(paramInt1);
      }
    } while (this.mTachiStatus == null);
    this.mTachiStatus.mFaceDetScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOTachi
 * JD-Core Version:    0.7.0.1
 */