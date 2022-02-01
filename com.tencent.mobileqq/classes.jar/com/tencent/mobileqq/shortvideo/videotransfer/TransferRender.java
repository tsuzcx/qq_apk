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
    if (paramLong >= 0L)
    {
      Object localObject = this.mTransferData;
      if ((localObject != null) && (this.mTransFilterList != null))
      {
        localObject = ((TransferData)localObject).getPositions();
        if ((localObject != null) && (((ArrayList)localObject).size() != 0))
        {
          if (paramLong == 0L) {
            resetExtendParam();
          }
          Long localLong;
          long l2;
          int j;
          if (this.mSpeedRate > 0.0F)
          {
            l1 = getDuration();
            localObject = ((ArrayList)localObject).iterator();
            i = -1;
            while (((Iterator)localObject).hasNext())
            {
              localLong = (Long)((Iterator)localObject).next();
              l2 = localLong.longValue() + l1;
              j = i + 1;
              if (paramLong + TRANSFER_BUFFER_TIME < localLong.longValue())
              {
                this.mState = 0;
                this.mStartTimeMs = -1L;
                this.mEndTimeMs = -1L;
                return;
              }
              i = j;
              if (paramLong + TRANSFER_BUFFER_TIME >= localLong.longValue())
              {
                if (paramLong < localLong.longValue())
                {
                  this.mState = 1;
                  this.mStartTimeMs = localLong.longValue();
                  this.mEndTimeMs = l2;
                  return;
                }
                if (paramLong > l2)
                {
                  i = j;
                }
                else
                {
                  i = this.mState;
                  if (i == 0)
                  {
                    this.mState = 1;
                    this.mStartTimeMs = localLong.longValue();
                    this.mEndTimeMs = l2;
                    return;
                  }
                  if (i == 1)
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
              if (paramLong >= l2)
              {
                j = this.mState;
                if (j == 0)
                {
                  this.mState = 1;
                  this.mStartTimeMs = localLong.longValue();
                  this.mEndTimeMs = l2;
                  return;
                }
                if (j == 1)
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
            }
            i -= 1;
          }
          this.mState = 0;
          this.mStartTimeMs = -1L;
          this.mEndTimeMs = -1L;
          return;
        }
        this.mState = 0;
        this.mStartTimeMs = -1L;
        this.mEndTimeMs = -1L;
        return;
      }
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
    Object localObject = this.mCommonFloats;
    localObject[0] = 0.0F;
    localObject[1] = 0.0F;
    localObject[2] = 0.0F;
    localObject[3] = 0.0F;
    localObject = this.mTransferData;
    if (localObject == null) {
      return;
    }
    if (((TransferData)localObject).mConfigData == null) {
      return;
    }
    if (this.mTransferData.mConfigData.mCommonFloat1 != null) {
      this.mCommonFloats[0] = getExtentParamValue(this.mTransferData.mConfigData.mCommonFloat1, 0, paramInt);
    }
    if (this.mTransferData.mConfigData.mCommonFloat2 != null) {
      this.mCommonFloats[1] = getExtentParamValue(this.mTransferData.mConfigData.mCommonFloat2, 1, paramInt);
    }
    if (this.mTransferData.mConfigData.mCommonFloat3 != null) {
      this.mCommonFloats[2] = getExtentParamValue(this.mTransferData.mConfigData.mCommonFloat3, 2, paramInt);
    }
    if (this.mTransferData.mConfigData.mCommonFloat4 != null) {
      this.mCommonFloats[3] = getExtentParamValue(this.mTransferData.mConfigData.mCommonFloat3, 3, paramInt);
    }
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
    if (paramParamRule == null) {
      return 0;
    }
    if (paramParamRule.mMode == 2) {
      return (paramParamRule.mStartPos + paramInt1) % paramInt2;
    }
    if (paramParamRule.mMode == 0) {
      return 0;
    }
    if (paramParamRule.mMode == 4) {
      return 0;
    }
    if (paramParamRule.mMode == 3) {
      return 0;
    }
    paramInt1 = paramParamRule.mMode;
    return 0;
  }
  
  private float getExtentParamValue(TransferConfig.ExtendParamFloats paramExtendParamFloats, int paramInt1, int paramInt2)
  {
    if (paramExtendParamFloats == null) {
      return 0.0F;
    }
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= this.mCommonFloatParamPos.length) {
        return 0.0F;
      }
      if (paramExtendParamFloats.mValues != null)
      {
        if (paramExtendParamFloats.mValues.length == 0) {
          return 0.0F;
        }
        if (paramExtendParamFloats.mRule == null)
        {
          int[] arrayOfInt = this.mCommonFloatParamPos;
          arrayOfInt[paramInt1] = paramInt2;
          if (arrayOfInt[paramInt1] < 0) {
            arrayOfInt[paramInt1] = 0;
          } else {
            arrayOfInt[paramInt1] %= paramExtendParamFloats.mValues.length;
          }
          return paramExtendParamFloats.mValues[this.mCommonFloatParamPos[paramInt1]];
        }
        if (paramExtendParamFloats.mRule.mLevel == 0) {
          this.mCommonFloatParamPos[paramInt1] = getExtendParamPosition(paramExtendParamFloats.mRule, paramInt2, paramExtendParamFloats.mValues.length);
        } else if (paramExtendParamFloats.mRule.mLevel == 1) {
          this.mCommonFloatParamPos[paramInt1] = nextExtendParamPosition(paramExtendParamFloats.mRule, this.mCommonFloatParamPos[paramInt1], paramExtendParamFloats.mValues.length);
        }
        return paramExtendParamFloats.mValues[this.mCommonFloatParamPos[paramInt1]];
      }
    }
    return 0.0F;
  }
  
  private void initTransFilterList(List<HashMap<String, String>> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject2 = (String)((HashMap)paramList.get(i)).get("vsh");
        String str = (String)((HashMap)paramList.get(i)).get("fsh");
        Object localObject1 = localObject2;
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
        if (paramBoolean) {
          this.mLevelEffectTransFilterList.add(localObject1);
        } else {
          this.mTransFilterList.add(localObject1);
        }
        i += 1;
      }
      return;
    }
    this.mTransFilterList.add(new TransferInstFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\ngl_Position = uMVPMatrix * position;\ntextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n}", "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform vec2 inputImageTextureSize;\nuniform vec2 inputImageTexture2Size;\nuniform vec2 timeRange; //start, duration\nuniform float time;\n\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n"));
  }
  
  private int nextExtendParamPosition(TransferConfig.ParamRule paramParamRule, int paramInt1, int paramInt2)
  {
    if (paramParamRule == null) {
      return 0;
    }
    if (paramInt1 < 0) {
      return paramParamRule.mStartPos;
    }
    if (paramParamRule.mMode == 2)
    {
      paramInt1 += 1;
      if (paramInt1 >= paramInt2) {
        return 0;
      }
      return paramInt1;
    }
    if (paramParamRule.mMode == 0) {
      return 0;
    }
    if (paramParamRule.mMode == 4) {
      return 0;
    }
    if (paramParamRule.mMode == 3) {
      return 0;
    }
    paramInt1 = paramParamRule.mMode;
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
    Object localObject = this.mTransferData;
    if (localObject != null) {
      initTransFilterList(((TransferData)localObject).mConfigData.shaderList, this.mTransferData.mConfigData.mID, this.mTransferData.mConfigData.mLevelEffectShader);
    }
    if (SLog.isEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reCreateTransFilter , mTransferData : ");
      ((StringBuilder)localObject).append(this.mTransferData);
      ((StringBuilder)localObject).append(" mTransFilterList.size :");
      ((StringBuilder)localObject).append(this.mTransFilterList.size());
      ((StringBuilder)localObject).append(" mLevelEffectTransFilterList.size : ");
      ((StringBuilder)localObject).append(this.mLevelEffectTransFilterList.size());
      SLog.d("TransferRender", ((StringBuilder)localObject).toString());
    }
  }
  
  private void resetExtendParam()
  {
    Object localObject = this.mCommonFloats;
    localObject[0] = 0.0F;
    localObject[1] = 0.0F;
    localObject[2] = 0.0F;
    localObject[3] = 0.0F;
    localObject = this.mCommonFloatParamPos;
    localObject[0] = -1;
    localObject[1] = -1;
    localObject[2] = -1;
    localObject[3] = -1;
  }
  
  public void destroy()
  {
    Object localObject = this.mTransFilterList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TransferInstFilter)((Iterator)localObject).next()).destroy();
      }
      this.mTransFilterList.clear();
      this.mTransFilterList = null;
    }
    localObject = this.mCacheFilter;
    if (localObject != null)
    {
      ((GPUBaseFilter)localObject).destroy();
      this.mCacheFilter = null;
    }
    localObject = this.mCacheFBO;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
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
    RenderBuffer localRenderBuffer = this.mCacheFBO;
    if ((localRenderBuffer == null) || (localRenderBuffer.getWidth() != paramInt1) || (this.mCacheFBO.getHeight() != paramInt2))
    {
      localRenderBuffer = this.mCacheFBO;
      if (localRenderBuffer != null)
      {
        localRenderBuffer.destroy();
        this.mCacheFBO = null;
      }
      this.mCacheFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
    reCreateTransFilter();
  }
  
  public int process(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    checkState(paramLong);
    int j = this.mState;
    if (j == 0) {
      return -1;
    }
    int i = 1;
    Object localObject1;
    if (j == 1)
    {
      if (this.mCacheFilter == null)
      {
        this.mCacheFilter = new GPUBaseFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
        this.mCacheFilter.init();
        this.mCacheFilter.onOutputSizeChanged(this.mLastWidth, this.mLastHeight);
      }
      localObject1 = this.mCacheFBO;
      if ((localObject1 != null) && (this.mCacheFilter != null))
      {
        ((RenderBuffer)localObject1).bind();
        this.mCacheFilter.drawTexture(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
        this.mCacheFBO.unbind();
      }
    }
    else if (this.mCacheFBO != null)
    {
      localObject1 = this.mLevelEffectTransFilterList;
      long l1;
      long l2;
      int k;
      int m;
      Object localObject2;
      boolean bool;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        l1 = this.mNTransIndex;
        l2 = this.mLevelEffectTransFilterList.size();
        localObject1 = (TransferInstFilter)this.mLevelEffectTransFilterList.get((int)(l1 % l2));
        if (this.mSpeedRate > 0.0F)
        {
          j = (int)this.mStartTimeMs;
          k = (int)this.mEndTimeMs;
          m = (int)paramLong;
          localObject2 = this.mCommonFloats;
          ((TransferInstFilter)localObject1).updateData(j, k, m, localObject2[0], localObject2[1], localObject2[2], localObject2[3]);
        }
        else
        {
          l1 = this.mEndTimeMs;
          j = (int)l1;
          l2 = this.mStartTimeMs;
          k = (int)l2;
          m = (int)(l2 + l1 - paramLong);
          localObject2 = this.mCommonFloats;
          ((TransferInstFilter)localObject1).updateData(j, k, m, localObject2[0], localObject2[1], localObject2[2], localObject2[3]);
        }
        ((TransferInstFilter)localObject1).setInputTextureID(paramInt);
        bool = ((TransferInstFilter)localObject1).drawTexture(paramInt, this.mCacheFBO.getTexId(), paramArrayOfFloat1, paramArrayOfFloat2);
        j = ((TransferInstFilter)localObject1).getOutputTextureID();
        if (bool) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
        i = j;
      }
      else
      {
        localObject1 = this.mTransFilterList;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = this.mTransFilterList.iterator();
          i = paramInt;
          j = 1;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TransferInstFilter)((Iterator)localObject1).next();
            int n;
            float[] arrayOfFloat;
            if (this.mSpeedRate > 0.0F)
            {
              k = (int)this.mStartTimeMs;
              m = (int)this.mEndTimeMs;
              n = (int)paramLong;
              arrayOfFloat = this.mCommonFloats;
              ((TransferInstFilter)localObject2).updateData(k, m, n, arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
            }
            else
            {
              l1 = this.mEndTimeMs;
              k = (int)l1;
              l2 = this.mStartTimeMs;
              m = (int)l2;
              n = (int)(l2 + l1 - paramLong);
              arrayOfFloat = this.mCommonFloats;
              ((TransferInstFilter)localObject2).updateData(k, m, n, arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
            }
            ((TransferInstFilter)localObject2).setInputTextureID(i);
            bool = ((TransferInstFilter)localObject2).drawTexture(paramInt, this.mCacheFBO.getTexId(), paramArrayOfFloat1, paramArrayOfFloat2);
            k = ((TransferInstFilter)localObject2).getOutputTextureID();
            if ((j != 0) && (bool)) {
              i = 1;
            } else {
              i = 0;
            }
            j = i;
            i = k;
          }
          paramInt = j;
        }
        else
        {
          j = 1;
          i = paramInt;
          paramInt = j;
        }
      }
      if (paramInt != 0) {
        return i;
      }
    }
    return -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferRender
 * JD-Core Version:    0.7.0.1
 */