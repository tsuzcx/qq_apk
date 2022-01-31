package com.tencent.mobileqq.shortvideo.videotransfer;

import android.text.TextUtils;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TransferRender
{
  private static final int STASTE_TRANSFER = 2;
  private static final int STATE_CACHE = 1;
  private static final int STATE_NONE = 0;
  public static final String TAG = "TransferRender";
  private static int TRANSFER_BUFFER_TIME = 300;
  private RenderBuffer mCacheFBO;
  private GPUBaseFilter mCacheFilter;
  private int[] mCommonFloatParamPos = { -1, -1, -1, -1 };
  private float[] mCommonFloats = new float[4];
  private long mEndTimeMs = -1L;
  private int mLastHeight = 0;
  private int mLastWidth = 0;
  private List<TransferInstFilter> mLevelEffectTransFilterList;
  private long mNTransIndex = -1L;
  private float mSpeedRate = 1.0F;
  private long mStartTimeMs = -1L;
  private int mState = 0;
  private List<TransferInstFilter> mTransFilterList;
  private TransferData mTransferData;
  
  private void checkState(long paramLong)
  {
    if ((paramLong < 0L) || (this.mTransferData == null) || (this.mTransFilterList == null))
    {
      this.mState = 0;
      this.mStartTimeMs = -1L;
      this.mEndTimeMs = -1L;
      return;
    }
    Object localObject = this.mTransferData.getPositions();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      this.mState = 0;
      this.mStartTimeMs = -1L;
      this.mEndTimeMs = -1L;
      return;
    }
    if (paramLong == 0L) {
      resetExtendParam();
    }
    Long localLong;
    long l2;
    if (this.mSpeedRate > 0.0F)
    {
      l1 = getDuration();
      localObject = ((ArrayList)localObject).iterator();
      i = -1;
      while (((Iterator)localObject).hasNext())
      {
        localLong = (Long)((Iterator)localObject).next();
        l2 = localLong.longValue() + l1;
        int j = i + 1;
        if (TRANSFER_BUFFER_TIME + paramLong < localLong.longValue())
        {
          this.mState = 0;
          this.mStartTimeMs = -1L;
          this.mEndTimeMs = -1L;
          return;
        }
        i = j;
        if (TRANSFER_BUFFER_TIME + paramLong >= localLong.longValue())
        {
          if (paramLong < localLong.longValue())
          {
            this.mState = 1;
            this.mStartTimeMs = localLong.longValue();
            this.mEndTimeMs = l2;
            return;
          }
          i = j;
          if (paramLong <= l2)
          {
            if (this.mState == 0)
            {
              this.mState = 1;
              this.mStartTimeMs = localLong.longValue();
              this.mEndTimeMs = l2;
              return;
            }
            if (this.mState == 1)
            {
              this.mState = 2;
              this.mStartTimeMs = localLong.longValue();
              this.mEndTimeMs = l2;
              fillCommonFloats(j);
              this.mNTransIndex = j;
              return;
            }
            this.mStartTimeMs = localLong.longValue();
            this.mEndTimeMs = l2;
            fillCommonFloats(j);
            this.mNTransIndex = j;
            return;
          }
        }
      }
      this.mState = 0;
      this.mStartTimeMs = -1L;
      this.mEndTimeMs = -1L;
      return;
    }
    long l1 = getDuration();
    int i = ((ArrayList)localObject).size() - 1;
    while (i >= 0)
    {
      localLong = Long.valueOf(((Long)((ArrayList)localObject).get(i)).longValue() - this.mTransferData.getReverseShift());
      l2 = localLong.longValue() + l1;
      if (paramLong - TRANSFER_BUFFER_TIME > localLong.longValue())
      {
        this.mState = 0;
        this.mStartTimeMs = -1L;
        this.mEndTimeMs = -1L;
        return;
      }
      if (paramLong - TRANSFER_BUFFER_TIME <= localLong.longValue())
      {
        if (paramLong > localLong.longValue())
        {
          this.mState = 1;
          this.mStartTimeMs = localLong.longValue();
          this.mEndTimeMs = l2;
          return;
        }
        if (paramLong >= l2) {}
      }
      else
      {
        i -= 1;
        continue;
      }
      if (this.mState == 0)
      {
        this.mState = 1;
        this.mStartTimeMs = localLong.longValue();
        this.mEndTimeMs = l2;
        return;
      }
      if (this.mState == 1)
      {
        this.mState = 2;
        this.mStartTimeMs = localLong.longValue();
        this.mEndTimeMs = l2;
        fillCommonFloats(i);
        return;
      }
      this.mStartTimeMs = localLong.longValue();
      this.mEndTimeMs = l2;
      fillCommonFloats(i);
      return;
    }
    this.mState = 0;
    this.mStartTimeMs = -1L;
    this.mEndTimeMs = -1L;
  }
  
  private void clearTransFilter(List<TransferInstFilter> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((TransferInstFilter)localIterator.next()).destroy();
      }
      paramList.clear();
    }
  }
  
  private void fillCommonFloats(int paramInt)
  {
    this.mCommonFloats[0] = 0.0F;
    this.mCommonFloats[1] = 0.0F;
    this.mCommonFloats[2] = 0.0F;
    this.mCommonFloats[3] = 0.0F;
    if (this.mTransferData == null) {}
    do
    {
      do
      {
        return;
      } while (this.mTransferData.mConfigData == null);
      if (this.mTransferData.mConfigData.mCommonFloat1 != null) {
        this.mCommonFloats[0] = getExtentParamValue(this.mTransferData.mConfigData.mCommonFloat1, 0, paramInt);
      }
      if (this.mTransferData.mConfigData.mCommonFloat2 != null) {
        this.mCommonFloats[1] = getExtentParamValue(this.mTransferData.mConfigData.mCommonFloat2, 1, paramInt);
      }
      if (this.mTransferData.mConfigData.mCommonFloat3 != null) {
        this.mCommonFloats[2] = getExtentParamValue(this.mTransferData.mConfigData.mCommonFloat3, 2, paramInt);
      }
    } while (this.mTransferData.mConfigData.mCommonFloat4 == null);
    this.mCommonFloats[3] = getExtentParamValue(this.mTransferData.mConfigData.mCommonFloat3, 3, paramInt);
  }
  
  private long getDuration()
  {
    if (this.mTransferData != null)
    {
      if (this.mSpeedRate != -1.0F) {
        this.mSpeedRate = 1.0F;
      }
      return ((float)this.mTransferData.mConfigData.mDuration * this.mSpeedRate);
    }
    return 0L;
  }
  
  private int getExtendParamPosition(TransferConfig.ParamRule paramParamRule, int paramInt1, int paramInt2)
  {
    if (paramParamRule == null) {}
    do
    {
      return 0;
      if (paramParamRule.mMode == 2) {
        return (paramParamRule.mStartPos + paramInt1) % paramInt2;
      }
    } while ((paramParamRule.mMode == 0) || (paramParamRule.mMode == 4) || (paramParamRule.mMode == 3) || (paramParamRule.mMode != 1));
    return 0;
  }
  
  private float getExtentParamValue(TransferConfig.ExtendParamFloats paramExtendParamFloats, int paramInt1, int paramInt2)
  {
    if (paramExtendParamFloats == null) {}
    while ((paramInt1 < 0) || (paramInt1 >= this.mCommonFloatParamPos.length) || (paramExtendParamFloats.mValues == null) || (paramExtendParamFloats.mValues.length == 0)) {
      return 0.0F;
    }
    if (paramExtendParamFloats.mRule == null)
    {
      this.mCommonFloatParamPos[paramInt1] = paramInt2;
      if (this.mCommonFloatParamPos[paramInt1] < 0) {
        this.mCommonFloatParamPos[paramInt1] = 0;
      }
      for (;;)
      {
        return paramExtendParamFloats.mValues[this.mCommonFloatParamPos[paramInt1]];
        this.mCommonFloatParamPos[paramInt1] %= paramExtendParamFloats.mValues.length;
      }
    }
    if (paramExtendParamFloats.mRule.mLevel == 0) {
      this.mCommonFloatParamPos[paramInt1] = getExtendParamPosition(paramExtendParamFloats.mRule, paramInt2, paramExtendParamFloats.mValues.length);
    }
    for (;;)
    {
      return paramExtendParamFloats.mValues[this.mCommonFloatParamPos[paramInt1]];
      if (paramExtendParamFloats.mRule.mLevel == 1) {
        this.mCommonFloatParamPos[paramInt1] = nextExtendParamPosition(paramExtendParamFloats.mRule, this.mCommonFloatParamPos[paramInt1], paramExtendParamFloats.mValues.length);
      }
    }
  }
  
  private void initTransFilterList(List<HashMap<String, String>> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.mTransFilterList.add(new TransferInstFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\ngl_Position = uMVPMatrix * position;\ntextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n}", "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform vec2 inputImageTextureSize;\nuniform vec2 inputImageTexture2Size;\nuniform vec2 timeRange; //start, duration\nuniform float time;\n\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n"));
      return;
    }
    int i = 0;
    label38:
    Object localObject1;
    if (i < paramList.size())
    {
      Object localObject2 = (String)((HashMap)paramList.get(i)).get("vsh");
      String str = (String)((HashMap)paramList.get(i)).get("fsh");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\ngl_Position = uMVPMatrix * position;\ntextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n}";
      }
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform vec2 inputImageTextureSize;\nuniform vec2 inputImageTexture2Size;\nuniform vec2 timeRange; //start, duration\nuniform float time;\n\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n";
      }
      localObject1 = new TransferInstFilter((String)localObject1, (String)localObject2);
      ((TransferInstFilter)localObject1).setShaderID(paramInt);
      ((TransferInstFilter)localObject1).init();
      ((TransferInstFilter)localObject1).onOutputSizeChanged(this.mLastWidth, this.mLastHeight);
      if (!paramBoolean) {
        break label185;
      }
      this.mLevelEffectTransFilterList.add(localObject1);
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label185:
      this.mTransFilterList.add(localObject1);
    }
  }
  
  private int nextExtendParamPosition(TransferConfig.ParamRule paramParamRule, int paramInt1, int paramInt2)
  {
    if (paramParamRule == null) {}
    do
    {
      do
      {
        return 0;
        if (paramInt1 < 0) {
          return paramParamRule.mStartPos;
        }
        if (paramParamRule.mMode != 2) {
          break;
        }
        paramInt1 += 1;
      } while (paramInt1 >= paramInt2);
      return paramInt1;
    } while ((paramParamRule.mMode == 0) || (paramParamRule.mMode == 4) || (paramParamRule.mMode == 3) || (paramParamRule.mMode != 1));
    return 0;
  }
  
  private void reCreateTransFilter()
  {
    clearTransFilter(this.mTransFilterList);
    clearTransFilter(this.mLevelEffectTransFilterList);
    if (this.mTransFilterList == null) {
      this.mTransFilterList = new ArrayList();
    }
    if (this.mLevelEffectTransFilterList == null) {
      this.mLevelEffectTransFilterList = new ArrayList();
    }
    if (this.mTransferData != null) {
      initTransFilterList(this.mTransferData.mConfigData.shaderList, this.mTransferData.mConfigData.mID, this.mTransferData.mConfigData.mLevelEffectShader);
    }
    if (SLog.isEnable()) {
      SLog.d("TransferRender", "reCreateTransFilter , mTransferData : " + this.mTransferData + " mTransFilterList.size :" + this.mTransFilterList.size() + " mLevelEffectTransFilterList.size : " + this.mLevelEffectTransFilterList.size());
    }
  }
  
  private void resetExtendParam()
  {
    this.mCommonFloats[0] = 0.0F;
    this.mCommonFloats[1] = 0.0F;
    this.mCommonFloats[2] = 0.0F;
    this.mCommonFloats[3] = 0.0F;
    this.mCommonFloatParamPos[0] = -1;
    this.mCommonFloatParamPos[1] = -1;
    this.mCommonFloatParamPos[2] = -1;
    this.mCommonFloatParamPos[3] = -1;
  }
  
  public void destroy()
  {
    if (this.mTransFilterList != null)
    {
      Iterator localIterator = this.mTransFilterList.iterator();
      while (localIterator.hasNext()) {
        ((TransferInstFilter)localIterator.next()).destroy();
      }
      this.mTransFilterList.clear();
      this.mTransFilterList = null;
    }
    if (this.mCacheFilter != null)
    {
      this.mCacheFilter.destroy();
      this.mCacheFilter = null;
    }
    if (this.mCacheFBO != null)
    {
      this.mCacheFBO.destroy();
      this.mCacheFBO = null;
    }
    this.mLastWidth = 0;
    this.mLastHeight = 0;
  }
  
  public boolean isWorking()
  {
    return this.mState != 0;
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    this.mLastHeight = paramInt2;
    this.mLastWidth = paramInt1;
    if ((this.mCacheFBO == null) || (this.mCacheFBO.getWidth() != paramInt1) || (this.mCacheFBO.getHeight() != paramInt2))
    {
      if (this.mCacheFBO != null)
      {
        this.mCacheFBO.destroy();
        this.mCacheFBO = null;
      }
      this.mCacheFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
    reCreateTransFilter();
  }
  
  public int process(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    checkState(paramLong);
    if (this.mState == 0) {
      return -1;
    }
    if (this.mState == 1)
    {
      if (this.mCacheFilter == null)
      {
        this.mCacheFilter = new GPUBaseFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
        this.mCacheFilter.init();
        this.mCacheFilter.onOutputSizeChanged(this.mLastWidth, this.mLastHeight);
      }
      if ((this.mCacheFBO != null) && (this.mCacheFilter != null))
      {
        this.mCacheFBO.bind();
        this.mCacheFilter.drawTexture(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
        this.mCacheFBO.unbind();
      }
    }
    label261:
    label545:
    label561:
    for (;;)
    {
      return -1;
      if (this.mCacheFBO != null)
      {
        Object localObject;
        boolean bool;
        int j;
        int i;
        if ((this.mLevelEffectTransFilterList != null) && (!this.mLevelEffectTransFilterList.isEmpty()))
        {
          long l1 = this.mNTransIndex;
          long l2 = this.mLevelEffectTransFilterList.size();
          localObject = (TransferInstFilter)this.mLevelEffectTransFilterList.get((int)(l1 % l2));
          if (this.mSpeedRate > 0.0F)
          {
            ((TransferInstFilter)localObject).updateData((int)this.mStartTimeMs, (int)this.mEndTimeMs, (int)paramLong, this.mCommonFloats[0], this.mCommonFloats[1], this.mCommonFloats[2], this.mCommonFloats[3]);
            ((TransferInstFilter)localObject).setInputTextureID(paramInt);
            bool = ((TransferInstFilter)localObject).drawTexture(paramInt, this.mCacheFBO.getTexId(), paramArrayOfFloat1, paramArrayOfFloat2);
            j = ((TransferInstFilter)localObject).getOutputTextureID();
            if (!bool) {
              break label329;
            }
            paramInt = 1;
            i = paramInt;
            paramInt = j;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label561;
          }
          return paramInt;
          ((TransferInstFilter)localObject).updateData((int)this.mEndTimeMs, (int)this.mStartTimeMs, (int)(this.mStartTimeMs + this.mEndTimeMs - paramLong), this.mCommonFloats[0], this.mCommonFloats[1], this.mCommonFloats[2], this.mCommonFloats[3]);
          break;
          label329:
          paramInt = 0;
          break label261;
          if ((this.mTransFilterList != null) && (!this.mTransFilterList.isEmpty()))
          {
            localObject = this.mTransFilterList.iterator();
            j = paramInt;
            i = 1;
            if (((Iterator)localObject).hasNext())
            {
              TransferInstFilter localTransferInstFilter = (TransferInstFilter)((Iterator)localObject).next();
              if (this.mSpeedRate > 0.0F)
              {
                localTransferInstFilter.updateData((int)this.mStartTimeMs, (int)this.mEndTimeMs, (int)paramLong, this.mCommonFloats[0], this.mCommonFloats[1], this.mCommonFloats[2], this.mCommonFloats[3]);
                label443:
                localTransferInstFilter.setInputTextureID(j);
                bool = localTransferInstFilter.drawTexture(paramInt, this.mCacheFBO.getTexId(), paramArrayOfFloat1, paramArrayOfFloat2);
                j = localTransferInstFilter.getOutputTextureID();
                if ((i == 0) || (!bool)) {
                  break label545;
                }
              }
              for (i = 1;; i = 0)
              {
                break;
                localTransferInstFilter.updateData((int)this.mEndTimeMs, (int)this.mStartTimeMs, (int)(this.mStartTimeMs + this.mEndTimeMs - paramLong), this.mCommonFloats[0], this.mCommonFloats[1], this.mCommonFloats[2], this.mCommonFloats[3]);
                break label443;
              }
            }
            paramInt = j;
          }
          else
          {
            i = 1;
          }
        }
      }
    }
  }
  
  public void setSpeedRate(float paramFloat)
  {
    this.mSpeedRate = paramFloat;
  }
  
  public void setTransferData(TransferData paramTransferData)
  {
    this.mTransferData = paramTransferData;
    reCreateTransFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferRender
 * JD-Core Version:    0.7.0.1
 */