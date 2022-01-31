package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.io.File;

public class EffectTriggerFilter
  extends BaseFilter
{
  private static final int FLAG_DECREASE_CHANGE = 1;
  private static final int FLAG_INCREASE_CHANGE = 0;
  public static final String LOOKUP_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform lowp float alpha;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\nnewColor = mix(newColor, textureColor, alpha);\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n";
  public static final String LOOKUP_TABLE_FILE_NAME = "filterEffect.lut";
  private static final String TAG = EffectTriggerFilter.class.getSimpleName();
  private long mAlphaChangeTime;
  private BaseFilter mAlphaFilter = new AlphaAdjustFilter();
  private boolean mAlreadyRenderInSingleFrame = false;
  private float mCurAlphaRadio = 0.0F;
  private EffectTriggerFilter.EFFECT_TRIGGERED_STATUS mCurEffectStatus = EffectTriggerFilter.EFFECT_TRIGGERED_STATUS.NOT_CHANGE;
  private TRIGGERED_STATUS mCurStatus = TRIGGERED_STATUS.NOT_TRIGGERED;
  private String mDataPath;
  private boolean mIsInAlphaChange = false;
  private StickerItem mItem;
  private TRIGGERED_STATUS mLastStatus = TRIGGERED_STATUS.NOT_TRIGGERED;
  private String mLutFilterName;
  private float mStartAlphaRadio = 0.0F;
  private long mStartChangeTime;
  private float mTargetAlpha = 1.0F;
  private TriggerCtrlItem triggerCtrlItem;
  private boolean triggered = false;
  
  public EffectTriggerFilter(StickerItem paramStickerItem, String paramString)
  {
    super("varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform lowp float alpha;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\nnewColor = mix(newColor, textureColor, alpha);\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n");
    this.mItem = paramStickerItem;
    this.mDataPath = paramString;
    this.mLutFilterName = this.mItem.lutFilterName;
    this.mAlphaChangeTime = ((this.mItem.filterAlphaGradientDuration * 1000.0D));
    this.mTargetAlpha = this.mItem.alpha;
    this.triggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
    initParams();
  }
  
  private void endChangeTime(float paramFloat)
  {
    this.mCurAlphaRadio = paramFloat;
    this.mCurEffectStatus = EffectTriggerFilter.EFFECT_TRIGGERED_STATUS.NOT_CHANGE;
    this.mIsInAlphaChange = false;
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 2147483647, 2147483647);; paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647))
    {
      String str = paramString;
      if (!BitmapUtils.isLegal(paramString)) {
        str = null;
      }
      return str;
    }
  }
  
  private boolean isAlphaRadioValid(int paramInt, float paramFloat)
  {
    if (paramInt == 0) {
      if (this.mCurAlphaRadio >= paramFloat) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt != 1) {
        break;
      }
    } while (this.mCurAlphaRadio > paramFloat);
    return false;
    return false;
  }
  
  private boolean isDecrease()
  {
    return this.mCurEffectStatus == EffectTriggerFilter.EFFECT_TRIGGERED_STATUS.DECREASE_TRIGGERED;
  }
  
  private boolean isInChangeStatus()
  {
    int i;
    if ((isIncrease()) || (isDecrease()))
    {
      i = 1;
      if (System.currentTimeMillis() - this.mStartChangeTime >= this.mAlphaChangeTime) {
        break label49;
      }
    }
    label49:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label54;
      }
      return true;
      i = 0;
      break;
    }
    label54:
    return false;
  }
  
  private boolean isIncrease()
  {
    return this.mCurEffectStatus == EffectTriggerFilter.EFFECT_TRIGGERED_STATUS.INCREASE_TRIGGERED;
  }
  
  private TRIGGERED_STATUS updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    return this.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
  }
  
  private void updateAplha()
  {
    int i = 1;
    if (isInChangeStatus()) {
      this.mIsInAlphaChange = true;
    }
    if ((this.mIsInAlphaChange) && (this.mAlphaChangeTime != 0L))
    {
      f2 = (float)(System.currentTimeMillis() - this.mStartChangeTime) / (float)this.mAlphaChangeTime;
      if (isIncrease())
      {
        f1 = this.mTargetAlpha;
        i = 0;
        this.mCurAlphaRadio = (f2 * (f1 - this.mStartAlphaRadio) + this.mStartAlphaRadio);
        if (!isAlphaRadioValid(i, f1)) {
          endChangeTime(f1);
        }
        setAdjustParam(1.0F - this.mCurAlphaRadio);
      }
    }
    while ((!this.triggered) || (!isIncrease())) {
      for (;;)
      {
        float f2;
        do
        {
          return;
        } while (!isDecrease());
        float f1 = 0.0F;
      }
    }
    this.mCurAlphaRadio = this.mTargetAlpha;
    setAdjustParam(1.0F - this.mCurAlphaRadio);
  }
  
  private void updateChangeTriggerStatus()
  {
    if ((this.mCurStatus == TRIGGERED_STATUS.FIRST_TRIGGERED) && (this.mLastStatus == TRIGGERED_STATUS.NOT_TRIGGERED)) {}
    for (this.mCurEffectStatus = EffectTriggerFilter.EFFECT_TRIGGERED_STATUS.INCREASE_TRIGGERED;; this.mCurEffectStatus = EffectTriggerFilter.EFFECT_TRIGGERED_STATUS.DECREASE_TRIGGERED)
    {
      updateStartChangeParams();
      do
      {
        return;
      } while ((this.mCurStatus != TRIGGERED_STATUS.NOT_TRIGGERED) || ((this.mLastStatus != TRIGGERED_STATUS.TRIGGERED) && (this.mLastStatus != TRIGGERED_STATUS.FIRST_TRIGGERED)));
    }
  }
  
  private void updateStartChangeParams()
  {
    this.mStartChangeTime = System.currentTimeMillis();
    this.mStartAlphaRadio = this.mCurAlphaRadio;
  }
  
  public void ApplyGLSLFilter()
  {
    super.apply();
    if (this.mAlphaFilter != null) {
      this.mAlphaFilter.apply();
    }
  }
  
  public void clearGLSLSelf()
  {
    if (this.mAlphaFilter != null) {
      this.mAlphaFilter.clearGLSLSelf();
    }
    super.clearGLSLSelf();
  }
  
  public int getOrderMode()
  {
    if (this.mItem != null) {
      return this.mItem.filterOrderMode;
    }
    return 0;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("alpha", 0.0F));
    Object localObject = this.mDataPath + File.separator + this.mLutFilterName;
    if ((this.mLutFilterName == null) || (!FileUtils.exists((String)localObject))) {}
    for (localObject = getBitmap(this.mDataPath + File.separator + "filterEffect.lut");; localObject = getBitmap((String)localObject))
    {
      addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject, 33986, true));
      return;
    }
  }
  
  public boolean isAlreadyRenderInSingleFrame()
  {
    return this.mAlreadyRenderInSingleFrame;
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) || (isInChangeStatus());
  }
  
  public void reset()
  {
    this.mAlreadyRenderInSingleFrame = false;
    this.mCurStatus = TRIGGERED_STATUS.NOT_TRIGGERED;
    this.mLastStatus = TRIGGERED_STATUS.NOT_TRIGGERED;
    this.mCurEffectStatus = EffectTriggerFilter.EFFECT_TRIGGERED_STATUS.NOT_CHANGE;
    this.mIsInAlphaChange = false;
    this.mStartChangeTime = 0L;
    this.mCurAlphaRadio = 0.0F;
    this.mStartAlphaRadio = 0.0F;
    this.triggered = false;
    if (this.triggerCtrlItem != null) {
      this.triggerCtrlItem.reset();
    }
  }
  
  public void setAdjustParam(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
  
  public void setAlreadyRenderInSingleFrame(boolean paramBoolean)
  {
    this.mAlreadyRenderInSingleFrame = paramBoolean;
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    this.triggered = this.triggerCtrlItem.isTriggered();
    this.mCurStatus = updateActionTriggered(paramPTDetectInfo);
    updateChangeTriggerStatus();
    updateAplha();
    this.mLastStatus = this.mCurStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.EffectTriggerFilter
 * JD-Core Version:    0.7.0.1
 */