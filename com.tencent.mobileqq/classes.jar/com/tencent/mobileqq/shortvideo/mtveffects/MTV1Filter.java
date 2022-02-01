package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class MTV1Filter
  extends MTVBaseFilter
{
  private static final int BOTTOM_COLOR_BLUE = -14333474;
  private static final int BOTTOM_COLOR_WHITE = -14868179;
  private static final int BOTTOM_COLOR_YELLOW = -13530;
  private static final float DOV_SCALE = 1.5F;
  private static final float ENTRANCE_1_RECT_MAX_MARGIN_HEIGHT = 0.4F;
  private static final float ENTRANCE_1_RECT_MAX_MARGIN_WIDTH = 0.2F;
  private static final float ENTRANCE_2_RECT_CROSS_HEIGHT = 0.25F;
  private static final float ENTRANCE_2_RECT_CROSS_HEIGHT_DELTA = 0.16F;
  private static final float ENTRANCE_2_RECT_MARGIN_HEIGHT = 0.26F;
  private static final float ENTRANCE_2_RECT_MARGIN_WIDTH = 0.09F;
  private static final float ENTRANCE_SHAPE_CHANGE_POS = 0.7F;
  private static final int GAIN_TYPE_HIGH = 2;
  private static final int GAIN_TYPE_LOW = 1;
  private static final int GAIN_TYPE_NONE = 0;
  public static final String GLITCH_FILE_NAME = "screen_glitch.mp4";
  private static final float HIGH_1_RECT_KEEP_TIME_POSITION = 600.0F;
  private static final float HIGH_1_RECT_MARGIN_HEIGHT = 0.3F;
  private static final float HIGH_1_RECT_MARGIN_WIDTH = 0.0F;
  private static final float HIGH_2_RECT_CROSS_KEEP_TIME_POSITION_1 = 300.0F;
  private static final float HIGH_2_RECT_CROSS_KEEP_TIME_POSITION_2 = 900.0F;
  private static final float HIGH_2_RECT_CROSS_MOVE_TIME_POSITION = 1300.0F;
  private static final float HIGH_2_RECT_HEIGHT = 0.64F;
  private static final float HIGH_2_RECT_MARGIN_HEIGHT_END = 0.74F;
  private static final float HIGH_2_RECT_MARGIN_HEIGHT_START = 0.35F;
  private static final float HIGH_2_RECT_MOVE_MARGIN_WIDTH = 0.09F;
  private static final long HIGH_EFFECT_PERIOD = 10000L;
  private static final float LOW_1_RECT_KEEP_TIME_POSITION = 240.0F;
  private static final float LOW_1_RECT_KEEP_TIME_POSITION_2 = 360.0F;
  private static final float LOW_1_RECT_MARGIN_HEIGHT = 0.6F;
  private static final float LOW_1_RECT_MARGIN_HEIGHT_DELTA = 0.08F;
  private static final float LOW_1_RECT_MARGIN_WIDTH = 0.09F;
  private static final float LOW_2_RECT_CROSS_HEIGHT = -0.35F;
  private static final float LOW_2_RECT_CROSS_KEEP_TIME_POSITION_1 = 120.0F;
  private static final float LOW_2_RECT_CROSS_KEEP_TIME_POSITION_2 = 500.0F;
  private static final float LOW_2_RECT_MARGIN_HEIGHT = 0.65F;
  private static final float LOW_2_RECT_MARGIN_WIDTH = 0.09F;
  private static final long LOW_EFFECT_PERIOD = 10000L;
  public static final String MATERIAL_FILE_NAME = "material.png";
  private static final int MAX_DOV_COLOR_INTERVAL = 1000;
  private static final int MAX_DOV_COLOR_TIME = 900;
  private static final int MAX_DOV_GLITCH_INTERVAL = 800;
  private static final int MAX_DOV_GLITCH_TIME = 700;
  private static final int MAX_DOV_SCALE_INTERVAL = 1000;
  private static final int MAX_DOV_SCALE_TIME = 1000;
  private static final int MAX_DOV_SHOW_INTERVAL = 1000;
  private static final int MAX_DOV_SHOW_TIME = 3000;
  private static final int MAX_HIGH_PERIOD_TIMES = 2;
  private static final int MAX_LOW_PERIOD_TIMES = 2;
  private static final int MAX_NONE_EFFECT_SHOW = 3000;
  private static final int MAX_NONE_TEXT_SHOW_INTERVAL = 1000;
  private static final int MAX_NONE_TEXT_SHOW_TIME = 200;
  private static final int MAX_NONE_TEXT_SHOW_TIMES = 3;
  private static final int MAX_TODAY_COLOR_INTERVAL = 1000;
  private static final int MAX_TODAY_COLOR_TIME = 500;
  private static final int MAX_TODAY_GLITCH_INTERVAL = 3000;
  private static final int MAX_TODAY_GLITCH_TIME = 500;
  private static final int MAX_TODAY_SCALE_INTERVAL = 1000;
  private static final int MAX_TODAY_SCALE_TIME = 500;
  private static final int MAX_TODAY_SHOW_INTERVAL = 1500;
  private static final int MAX_TODAY_SHOW_TIME = 2000;
  private static final int MAX_VIDEO_CHANGE_INTERVAL = 300;
  private static final int MIN_DOV_COLOR_TIME = 600;
  private static final int MIN_DOV_GLITCH_TIME = 500;
  private static final int MIN_DOV_SCALE_TIME = 500;
  private static final int MIN_DOV_SHOW_TIME = 1500;
  private static final int MIN_NONE_TEXT_SHOW_TIME = 60;
  private static final int MIN_TODAY_COLOR_TIME = 200;
  private static final int MIN_TODAY_GLITCH_TIME = 200;
  private static final int MIN_TODAY_SCALE_TIME = 200;
  private static final int MIN_TODAY_SHOW_TIME = 1000;
  private static final float MUSIC_GAIN_THREASHOLD_HIGH = 0.7F;
  private static final float MUSIC_GAIN_THREASHOLD_LOW = 0.4F;
  public static final int STATE_ENTRANCE = 1;
  public static final int STATE_HIGH_GAIN_EFFECT = 2;
  public static final int STATE_LOW_GAIN_EFFECT = 3;
  public static final int STATE_NONE = 0;
  public static final int STATE_NONE_GAIN_TRANSITION_EFFECT = 4;
  public static final String TAG = "QQMTV1Filter";
  private static final int TEXT_COLOR_BLUE = -14737950;
  private static final int TEXT_COLOR_YELLOW = -265654;
  private static final int TIME_ENTRANCE = 800;
  private static final int TIME_HIGH_GAIN_EFFECT = 1300;
  private static final int TIME_LOW_GAIN_EFFECT = 500;
  private static final int TIME_NONE_EFFECT = 3000;
  private static final int TIME_NONE_GAIN_TRANSITION_EFFECT = 800;
  private static final float TODAY_OFFSET_X = -0.1F;
  private static final float TODAY_OFFSET_Y = -0.1F;
  private static final float TODAY_SCALE = 1.5F;
  private final RectF BG_TEXT_DISTORTION_RECT = new RectF(0.15F, 1.0F, 1.0F, -0.1F);
  private final RectF BG_TEXT_RECT = new RectF(0.317F, 0.884F, 1.0F, 0.031F);
  private final RectF DOV_RECT = new RectF(0.0F, 0.95F, 0.154F, 0.64F);
  private final RectF TODAY_RECT = new RectF(0.81F, 0.525F, 1.0F, 0.06500003F);
  private MTVBaseFilter.TextParam mBGTextParam = new MTVBaseFilter.TextParam();
  private GPUBaseFilter mBaseFilter;
  private int mBottomColor;
  private MTV1BottomLayerRender mBottomRender = new MTV1BottomLayerRender();
  private RandomTime mDovColorTime = new RandomTime();
  private RandomTime mDovGlitchTime = new RandomTime();
  private RandomTime mDovScaleTime = new RandomTime();
  private RandomTime mDovShowTime = new RandomTime();
  private MTVBaseFilter.TextParam mDovTextParam = new MTVBaseFilter.TextParam();
  private Mp4MaterialLoader mGlitchLoader = new Mp4MaterialLoader();
  private long mHighPerioadTimes = 2L;
  private long mHighPeriodStartNs = -1L;
  private long mLowPerioadTimes = 2L;
  private long mLowPeriodStartNs = -1L;
  private int mMaterialID = -1;
  private int mPaletteID;
  private float[] mShapePoints;
  private boolean mShowEntrance = true;
  private int mState = 1;
  private long mStateEndPos = 0L;
  private long mStateStartPos = 0L;
  private RandomTime mTodayColorTime = new RandomTime();
  private RandomTime mTodayGlitchTime = new RandomTime();
  private RandomTime mTodayScaleTime = new RandomTime();
  private RandomTime mTodayShowTime = new RandomTime();
  private MTVBaseFilter.TextParam mTodayTextParam = new MTVBaseFilter.TextParam();
  private MTV1TopLayerRender mTopRender = new MTV1TopLayerRender();
  private RandomTime mVideoChangeTime = new RandomTime(false);
  private MTV1VideoLayerRender mVideoRender = new MTV1VideoLayerRender();
  
  public MTV1Filter(String paramString)
  {
    super(1017, paramString);
  }
  
  private long calcEndPos(int paramInt, long paramLong, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean) {
      i = -1;
    }
    switch (paramInt)
    {
    default: 
      return paramLong;
    case 1: 
      return paramLong + i * 800;
    case 2: 
      return paramLong + i * 1300;
    case 3: 
      return paramLong + i * 500;
    case 4: 
      return paramLong + i * 800;
    }
    return paramLong + i * 3000;
  }
  
  private boolean checkHighTimesLimited(long paramLong)
  {
    if (paramLong - this.mHighPeriodStartNs < 10000L)
    {
      if (this.mHighPerioadTimes >= 0L) {
        this.mHighPerioadTimes -= 1L;
      }
      return this.mHighPerioadTimes > 0L;
    }
    this.mHighPeriodStartNs = paramLong;
    this.mHighPerioadTimes = 2L;
    return true;
  }
  
  private boolean checkLowTimesLimited(long paramLong)
  {
    if (paramLong - this.mLowPeriodStartNs < 10000L)
    {
      if (this.mLowPerioadTimes >= 0L) {
        this.mLowPerioadTimes -= 1L;
      }
      return this.mLowPerioadTimes > 0L;
    }
    this.mLowPeriodStartNs = paramLong;
    this.mLowPerioadTimes = 2L;
    return true;
  }
  
  private void checkPlayData(long paramLong)
  {
    switch (this.mState)
    {
    default: 
      if ((this.mState != 0) && (this.mState != 4))
      {
        this.mDovTextParam.mShow = checkRandomTime(this.mDovShowTime, paramLong, 1500L, 3000L, 1000L);
        if (checkRandomTime(this.mDovGlitchTime, paramLong, 500L, 700L, 800L))
        {
          this.mDovTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
          label115:
          if (!checkRandomTime(this.mDovScaleTime, paramLong, 500L, 1000L, 1000L)) {
            break label414;
          }
          this.mDovTextParam.mRect = scaleAndOffset(this.DOV_RECT, 1.5F, 0.0F, 0.0F);
          label154:
          this.mDovTextParam.mChangeColor = checkRandomTime(this.mDovColorTime, paramLong, 600L, 900L, 1000L);
          if (this.mDovTextParam.mChangeColor) {
            this.mDovTextParam.mColor = -14737950;
          }
          if (!this.mDovTextParam.mShow) {
            break label428;
          }
          this.mTodayTextParam.mShow = false;
          if ((this.mTodayTextParam.mGlitchID < 0) && (this.mDovTextParam.mGlitchID < 0)) {
            break label805;
          }
          if (this.mGlitchLoader != null) {
            this.mGlitchLoader.resume();
          }
        }
      }
      break;
    }
    label414:
    label428:
    label494:
    while (this.mGlitchLoader == null)
    {
      return;
      this.mBottomColor = -14868179;
      fillBGTextParam(false, false, 0, false);
      this.mPaletteID = -1;
      fillShapePoints(paramLong);
      break;
      if (checkRandomTime(this.mVideoChangeTime, paramLong, 300L, 300L))
      {
        this.mPaletteID = 0;
        this.mBottomColor = -13530;
        fillBGTextParam(true, true, -14737950, false);
      }
      for (;;)
      {
        fillShapePoints(paramLong);
        break;
        this.mBottomColor = -14333474;
        fillBGTextParam(true, true, -265654, false);
        this.mPaletteID = 1;
      }
      this.mBottomColor = -14333474;
      fillBGTextParam(true, true, -265654, false);
      this.mPaletteID = 1;
      fillShapePoints(paramLong);
      break;
      this.mShapePoints = null;
      this.mBottomColor = -14868179;
      fillBGTextParam(false, false, 0, false);
      this.mPaletteID = -1;
      break;
      this.mDovTextParam.mGlitchID = -1;
      break label115;
      this.mDovTextParam.mRect = this.DOV_RECT;
      break label154;
      this.mTodayTextParam.mShow = checkRandomTime(this.mTodayShowTime, paramLong, 1000L, 2000L, 1500L);
      if (checkRandomTime(this.mTodayScaleTime, paramLong, 200L, 500L, 1000L))
      {
        this.mTodayTextParam.mRect = scaleAndOffset(this.TODAY_RECT, 1.5F, -0.1F, -0.1F);
        if (!checkRandomTime(this.mTodayGlitchTime, paramLong, 200L, 500L, 3000L)) {
          break label590;
        }
      }
      for (this.mTodayTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();; this.mTodayTextParam.mGlitchID = -1)
      {
        this.mTodayTextParam.mChangeColor = checkRandomTime(this.mTodayColorTime, paramLong, 200L, 500L, 1000L);
        if (!this.mTodayTextParam.mChangeColor) {
          break;
        }
        this.mTodayTextParam.mColor = -14737950;
        break;
        this.mTodayTextParam.mRect = this.TODAY_RECT;
        break label494;
      }
      this.mDovTextParam.mShow = checkRandomTime(this.mDovShowTime, paramLong, 60L, 200L, 1000L);
      if (checkRandomTime(this.mDovGlitchTime, paramLong, 500L, 700L, 800L)) {}
      for (this.mDovTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();; this.mDovTextParam.mGlitchID = -1)
      {
        this.mDovTextParam.mRect = this.DOV_RECT;
        this.mDovTextParam.mChangeColor = false;
        if (!this.mDovTextParam.mShow) {
          break label712;
        }
        this.mTodayTextParam.mShow = false;
        break;
      }
      this.mTodayTextParam.mShow = checkRandomTime(this.mTodayShowTime, paramLong, 60L, 200L, 1000L);
      this.mTodayTextParam.mRect = this.TODAY_RECT;
      if (checkRandomTime(this.mTodayGlitchTime, paramLong, 200L, 500L, 3000L)) {}
      for (this.mTodayTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();; this.mTodayTextParam.mGlitchID = -1)
      {
        this.mTodayTextParam.mChangeColor = false;
        break;
      }
    }
    label590:
    this.mGlitchLoader.pause();
    label712:
  }
  
  private void checkPlayState(long paramLong, float paramFloat)
  {
    if ((!this.mShowEntrance) && (this.mState == 1)) {
      enterState(0, paramLong);
    }
    boolean bool = isStateFinish(this.mState, paramLong);
    if ((!bool) && (this.mState != 0)) {}
    do
    {
      do
      {
        return;
        clearState(this.mState);
        if (this.mState == 1)
        {
          i = getMusicGainType(paramFloat);
          if (i == 2)
          {
            if (checkHighTimesLimited(paramLong))
            {
              enterState(2, paramLong);
              return;
            }
            enterState(0, paramLong);
            return;
          }
          if (i == 1)
          {
            if (checkLowTimesLimited(paramLong))
            {
              enterState(3, paramLong);
              return;
            }
            enterState(0, paramLong);
            return;
          }
          enterState(0, paramLong);
          return;
        }
        if (this.mState != 0) {
          break;
        }
        if (bool)
        {
          if (checkLowTimesLimited(paramLong))
          {
            enterState(3, paramLong);
            return;
          }
          enterState(0, paramLong);
          return;
        }
        i = getMusicGainType(paramFloat);
        if (i == 2)
        {
          if (checkHighTimesLimited(paramLong))
          {
            enterState(2, paramLong);
            return;
          }
          enterState(0, paramLong);
          return;
        }
      } while (i != 1);
      if (checkLowTimesLimited(paramLong))
      {
        enterState(3, paramLong);
        return;
      }
      enterState(0, paramLong);
      return;
      if (this.mState == 2)
      {
        i = getMusicGainType(paramFloat);
        if (i == 2)
        {
          enterState(4, paramLong);
          return;
        }
        if (i == 1)
        {
          if (checkLowTimesLimited(paramLong))
          {
            enterState(3, paramLong);
            return;
          }
          enterState(0, paramLong);
          return;
        }
        enterState(0, paramLong);
        return;
      }
      if (this.mState == 3)
      {
        i = getMusicGainType(paramFloat);
        if (i == 2)
        {
          if (checkHighTimesLimited(paramLong))
          {
            enterState(2, paramLong);
            return;
          }
          enterState(0, paramLong);
          return;
        }
        if (i == 1)
        {
          enterState(4, paramLong);
          return;
        }
        enterState(0, paramLong);
        return;
      }
    } while (this.mState != 4);
    int i = getMusicGainType(paramFloat);
    if (i == 2)
    {
      if (checkHighTimesLimited(paramLong))
      {
        enterState(2, paramLong);
        return;
      }
      enterState(0, paramLong);
      return;
    }
    if (i == 1)
    {
      enterState(4, paramLong);
      return;
    }
    enterState(0, paramLong);
  }
  
  private void clearState(int paramInt)
  {
    if (paramInt == 1) {}
    do
    {
      do
      {
        return;
      } while (paramInt == 0);
      if (paramInt == 2)
      {
        this.mVideoChangeTime.reset();
        return;
      }
    } while ((paramInt == 3) || (paramInt != 4));
  }
  
  private void enterState(int paramInt, long paramLong)
  {
    this.mStateStartPos = paramLong;
    this.mState = paramInt;
    paramInt = this.mState;
    paramLong = this.mStateStartPos;
    if (getPlayMode() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.mStateEndPos = calcEndPos(paramInt, paramLong, bool);
      return;
    }
  }
  
  private void fillBGTextParam(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    this.mBGTextParam.mShow = paramBoolean1;
    this.mBGTextParam.mChangeColor = paramBoolean2;
    this.mBGTextParam.mColor = paramInt;
    this.mBGTextParam.mDistortion = paramBoolean3;
    if (this.mBGTextParam.mDistortion)
    {
      this.mBGTextParam.mRect = this.BG_TEXT_DISTORTION_RECT;
      return;
    }
    this.mBGTextParam.mRect = this.BG_TEXT_RECT;
  }
  
  private void fillShapePoints(long paramLong)
  {
    if (this.mState == 1) {
      if ((float)Math.abs(paramLong - this.mStateStartPos) * 1.0F / (float)Math.abs(this.mStateEndPos - this.mStateStartPos) < 0.7F) {
        this.mShapePoints = MTV1ShapePoints.getOneRectPoints(0.2F * (float)Math.abs(paramLong - this.mStateStartPos) / (float)Math.abs(this.mStateEndPos - this.mStateStartPos), 0.4F * (float)Math.abs(paramLong - this.mStateStartPos) / (float)Math.abs(this.mStateEndPos - this.mStateStartPos), 0.0F);
      }
    }
    do
    {
      return;
      this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09F, 0.26F, 0.16F, 0.25F, -1.0F);
      return;
      if (this.mState == 2)
      {
        f = (float)Math.abs(paramLong - this.mStateStartPos);
        if (f < 300.0F)
        {
          this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09F, 0.26F, 0.16F, 0.25F, -1.0F);
          return;
        }
        if (f < 600.0F)
        {
          this.mShapePoints = MTV1ShapePoints.getOneRectPoints(0.0F, 0.3F, 0.0F);
          return;
        }
        if (f < 900.0F)
        {
          this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09F, 0.26F, 0.16F, 0.25F, -1.0F);
          return;
        }
        if (f < 1300.0F)
        {
          this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09F, ((float)Math.abs(paramLong - this.mStateStartPos) - 900.0F) * 1.0F / 400.0F * 0.39F + 0.35F, 0.16F, -1.0F, 0.64F);
          return;
        }
        this.mShapePoints = null;
        return;
      }
    } while (this.mState != 3);
    float f = (float)Math.abs(paramLong - this.mStateStartPos);
    if (f < 120.0F)
    {
      this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09F, 0.65F, 0.0F, -0.35F, -1.0F);
      return;
    }
    if (f < 240.0F)
    {
      this.mShapePoints = MTV1ShapePoints.getOneRectPoints(0.09F, 0.6F, 0.0F);
      return;
    }
    if (f < 360.0F)
    {
      this.mShapePoints = MTV1ShapePoints.getOneRectPoints(0.0F, 0.6F, 0.08F);
      return;
    }
    if (f < 500.0F)
    {
      this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09F, 0.26F, 0.16F, 0.25F, -1.0F);
      return;
    }
    this.mShapePoints = null;
  }
  
  private int getMusicGainType(float paramFloat)
  {
    if (paramFloat > 0.7F) {
      return 2;
    }
    if (paramFloat > 0.4F) {
      return 1;
    }
    return 0;
  }
  
  private void initMaterialData(int paramInt1, int paramInt2)
  {
    this.mVideoRender.setMaterialTexture(this.mMaterialID, paramInt1, paramInt2);
    this.mVideoRender.removeAllMaterials();
    this.mVideoRender.addMaterial(1, new RectF(0.012F, 0.204F, 0.33F, 0.2F));
    this.mVideoRender.addMaterial(0, new RectF(0.012F, 0.164F, 0.33F, 0.16F));
    this.mBottomRender.setMaterialTexture(this.mMaterialID, paramInt1, paramInt2);
    this.mBottomRender.removeAllMaterials();
    this.mBottomRender.addMaterial(0, new RectF(0.373F, 1.0F, 1.0F, 0.0F));
    this.mTopRender.setMaterialTexture(this.mMaterialID, paramInt1, paramInt2);
    this.mTopRender.removeAllMaterials();
    this.mTopRender.addMaterial(1, new RectF(0.233463F, 1.0F, 0.337224F, 0.625F));
    this.mTopRender.addMaterial(0, new RectF(0.0F, 1.0F, 0.199741F, 0.686F));
  }
  
  private boolean isStateFinish(int paramInt, long paramLong)
  {
    int i = 800;
    switch (paramInt)
    {
    default: 
      i = -1;
    }
    while (Math.abs(paramLong - this.mStateStartPos) > i)
    {
      return true;
      i = 1300;
      continue;
      i = 500;
      continue;
      i = 3000;
    }
    return false;
  }
  
  /* Error */
  private void loadMaterial(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: ldc 139
    //   11: new 473	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 476
    //   21: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_1
    //   25: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc_w 485
    //   31: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 489	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 495	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: invokevirtual 498	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:getMaterialPath	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: invokestatic 504	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +17 -> 70
    //   56: aload_0
    //   57: iconst_m1
    //   58: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   61: ldc 139
    //   63: ldc_w 506
    //   66: invokestatic 509	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: return
    //   70: aload_0
    //   71: getfield 296	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mGlitchLoader	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader;
    //   74: invokevirtual 513	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:isInited	()Z
    //   77: ifne +45 -> 122
    //   80: aload_0
    //   81: getfield 296	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mGlitchLoader	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader;
    //   84: iload_1
    //   85: iload_2
    //   86: invokevirtual 516	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:init	(II)V
    //   89: aload_0
    //   90: getfield 296	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mGlitchLoader	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader;
    //   93: new 473	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   100: aload_3
    //   101: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 38
    //   106: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 489	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokevirtual 519	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:start	(Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 296	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mGlitchLoader	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader;
    //   119: invokevirtual 381	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:pause	()V
    //   122: aload_0
    //   123: getfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   126: ifgt -57 -> 69
    //   129: new 521	java/io/FileInputStream
    //   132: dup
    //   133: new 473	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   140: aload_3
    //   141: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 83
    //   146: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 489	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 523	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   155: astore_3
    //   156: aload_3
    //   157: astore 5
    //   159: aload 4
    //   161: astore 6
    //   163: new 525	java/io/BufferedInputStream
    //   166: dup
    //   167: aload_3
    //   168: invokespecial 528	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   171: astore 4
    //   173: aload_3
    //   174: astore 5
    //   176: aload 4
    //   178: astore 6
    //   180: aload 4
    //   182: invokestatic 534	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   185: astore 7
    //   187: aload_3
    //   188: astore 5
    //   190: aload 4
    //   192: astore 6
    //   194: aload_0
    //   195: sipush 3553
    //   198: aload 7
    //   200: invokestatic 540	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   203: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   206: aload_3
    //   207: astore 5
    //   209: aload 4
    //   211: astore 6
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   218: iload_1
    //   219: iload_2
    //   220: invokespecial 544	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:revertTexture	(III)I
    //   223: istore_1
    //   224: iload_1
    //   225: iflt +29 -> 254
    //   228: aload_3
    //   229: astore 5
    //   231: aload 4
    //   233: astore 6
    //   235: aload_0
    //   236: getfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   239: invokestatic 547	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:deleteTexture	(I)V
    //   242: aload_3
    //   243: astore 5
    //   245: aload 4
    //   247: astore 6
    //   249: aload_0
    //   250: iload_1
    //   251: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   254: aload_3
    //   255: astore 5
    //   257: aload 4
    //   259: astore 6
    //   261: aload_0
    //   262: aload 7
    //   264: invokevirtual 552	android/graphics/Bitmap:getWidth	()I
    //   267: aload 7
    //   269: invokevirtual 555	android/graphics/Bitmap:getHeight	()I
    //   272: invokespecial 557	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:initMaterialData	(II)V
    //   275: aload_3
    //   276: ifnull +7 -> 283
    //   279: aload_3
    //   280: invokevirtual 562	java/io/InputStream:close	()V
    //   283: aload 4
    //   285: ifnull -216 -> 69
    //   288: aload 4
    //   290: invokevirtual 562	java/io/InputStream:close	()V
    //   293: return
    //   294: astore_3
    //   295: return
    //   296: astore 4
    //   298: aconst_null
    //   299: astore_3
    //   300: aload_3
    //   301: astore 5
    //   303: aload 7
    //   305: astore 6
    //   307: ldc 139
    //   309: new 473	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 564
    //   319: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 4
    //   324: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 489	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 509	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_3
    //   334: astore 5
    //   336: aload 7
    //   338: astore 6
    //   340: aload_0
    //   341: iconst_m1
    //   342: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   345: aload_3
    //   346: astore 5
    //   348: aload 7
    //   350: astore 6
    //   352: aload 4
    //   354: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   357: aload_3
    //   358: ifnull +7 -> 365
    //   361: aload_3
    //   362: invokevirtual 562	java/io/InputStream:close	()V
    //   365: aload 7
    //   367: ifnull -298 -> 69
    //   370: aload 7
    //   372: invokevirtual 562	java/io/InputStream:close	()V
    //   375: return
    //   376: astore_3
    //   377: return
    //   378: astore_3
    //   379: aconst_null
    //   380: astore 7
    //   382: aconst_null
    //   383: astore_3
    //   384: aload 7
    //   386: astore 5
    //   388: aload_3
    //   389: astore 6
    //   391: ldc 139
    //   393: ldc_w 572
    //   396: invokestatic 509	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload 7
    //   401: astore 5
    //   403: aload_3
    //   404: astore 6
    //   406: aload_0
    //   407: iconst_m1
    //   408: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   411: aload 7
    //   413: ifnull +8 -> 421
    //   416: aload 7
    //   418: invokevirtual 562	java/io/InputStream:close	()V
    //   421: aload_3
    //   422: ifnull -353 -> 69
    //   425: aload_3
    //   426: invokevirtual 562	java/io/InputStream:close	()V
    //   429: return
    //   430: astore_3
    //   431: return
    //   432: astore_3
    //   433: aconst_null
    //   434: astore 5
    //   436: aload 5
    //   438: ifnull +8 -> 446
    //   441: aload 5
    //   443: invokevirtual 562	java/io/InputStream:close	()V
    //   446: aload 6
    //   448: ifnull +8 -> 456
    //   451: aload 6
    //   453: invokevirtual 562	java/io/InputStream:close	()V
    //   456: aload_3
    //   457: athrow
    //   458: astore_3
    //   459: goto -176 -> 283
    //   462: astore_3
    //   463: goto -98 -> 365
    //   466: astore 4
    //   468: goto -47 -> 421
    //   471: astore 4
    //   473: goto -27 -> 446
    //   476: astore 4
    //   478: goto -22 -> 456
    //   481: astore_3
    //   482: goto -46 -> 436
    //   485: astore_3
    //   486: goto -50 -> 436
    //   489: astore 4
    //   491: aconst_null
    //   492: astore 4
    //   494: aload_3
    //   495: astore 7
    //   497: aload 4
    //   499: astore_3
    //   500: goto -116 -> 384
    //   503: astore 5
    //   505: aload_3
    //   506: astore 7
    //   508: aload 4
    //   510: astore_3
    //   511: goto -127 -> 384
    //   514: astore 4
    //   516: goto -216 -> 300
    //   519: astore 5
    //   521: aload 4
    //   523: astore 7
    //   525: aload 5
    //   527: astore 4
    //   529: goto -229 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	MTV1Filter
    //   0	532	1	paramInt1	int
    //   0	532	2	paramInt2	int
    //   48	232	3	localObject1	java.lang.Object
    //   294	1	3	localIOException1	java.io.IOException
    //   299	63	3	localObject2	java.lang.Object
    //   376	1	3	localIOException2	java.io.IOException
    //   378	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   383	43	3	localObject3	java.lang.Object
    //   430	1	3	localIOException3	java.io.IOException
    //   432	25	3	localObject4	java.lang.Object
    //   458	1	3	localIOException4	java.io.IOException
    //   462	1	3	localIOException5	java.io.IOException
    //   481	1	3	localObject5	java.lang.Object
    //   485	10	3	localObject6	java.lang.Object
    //   499	12	3	localObject7	java.lang.Object
    //   4	285	4	localBufferedInputStream	java.io.BufferedInputStream
    //   296	57	4	localException1	java.lang.Exception
    //   466	1	4	localIOException6	java.io.IOException
    //   471	1	4	localIOException7	java.io.IOException
    //   476	1	4	localIOException8	java.io.IOException
    //   489	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   492	17	4	localObject8	java.lang.Object
    //   514	8	4	localException2	java.lang.Exception
    //   527	1	4	localObject9	java.lang.Object
    //   157	285	5	localObject10	java.lang.Object
    //   503	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   519	7	5	localException3	java.lang.Exception
    //   1	451	6	localObject11	java.lang.Object
    //   7	517	7	localObject12	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   288	293	294	java/io/IOException
    //   129	156	296	java/lang/Exception
    //   370	375	376	java/io/IOException
    //   129	156	378	java/lang/OutOfMemoryError
    //   425	429	430	java/io/IOException
    //   129	156	432	finally
    //   279	283	458	java/io/IOException
    //   361	365	462	java/io/IOException
    //   416	421	466	java/io/IOException
    //   441	446	471	java/io/IOException
    //   451	456	476	java/io/IOException
    //   163	173	481	finally
    //   307	333	481	finally
    //   340	345	481	finally
    //   352	357	481	finally
    //   180	187	485	finally
    //   194	206	485	finally
    //   213	224	485	finally
    //   235	242	485	finally
    //   249	254	485	finally
    //   261	275	485	finally
    //   391	399	485	finally
    //   406	411	485	finally
    //   163	173	489	java/lang/OutOfMemoryError
    //   180	187	503	java/lang/OutOfMemoryError
    //   194	206	503	java/lang/OutOfMemoryError
    //   213	224	503	java/lang/OutOfMemoryError
    //   235	242	503	java/lang/OutOfMemoryError
    //   249	254	503	java/lang/OutOfMemoryError
    //   261	275	503	java/lang/OutOfMemoryError
    //   163	173	514	java/lang/Exception
    //   180	187	519	java/lang/Exception
    //   194	206	519	java/lang/Exception
    //   213	224	519	java/lang/Exception
    //   235	242	519	java/lang/Exception
    //   249	254	519	java/lang/Exception
    //   261	275	519	java/lang/Exception
  }
  
  private void resetInner(long paramLong)
  {
    if (this.mShowEntrance) {
      enterState(1, paramLong);
    }
    for (;;)
    {
      this.mRandom.reset();
      this.mDovGlitchTime.reset();
      this.mDovShowTime.reset();
      this.mDovScaleTime.reset();
      this.mDovColorTime.reset();
      this.mTodayColorTime.reset();
      this.mTodayScaleTime.reset();
      this.mTodayShowTime.reset();
      this.mTodayGlitchTime.reset();
      this.mVideoChangeTime.reset();
      this.mHighPeriodStartNs = -1L;
      this.mHighPerioadTimes = 2L;
      this.mLowPeriodStartNs = -1L;
      this.mLowPerioadTimes = 2L;
      return;
      enterState(0, paramLong);
    }
  }
  
  private int revertTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mBaseFilter == null) {
      return -1;
    }
    GLES20.glActiveTexture(33984);
    int i = GlUtil.createTexture(3553);
    if (i < 0) {
      return -1;
    }
    GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
    RenderBuffer localRenderBuffer = new RenderBuffer(paramInt2, paramInt3, 33984);
    localRenderBuffer.setTexId(i);
    localRenderBuffer.bind();
    this.mBaseFilter.drawTexture(paramInt1, new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F }, null);
    localRenderBuffer.unbind();
    localRenderBuffer.recoverInitialTexId();
    localRenderBuffer.destroy();
    return i;
  }
  
  private static RectF scaleAndOffset(RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramRectF = new RectF(paramRectF);
    paramRectF.right = ((paramRectF.right - paramRectF.left) * paramFloat1 + paramRectF.left);
    paramRectF.bottom = (paramRectF.top - (paramRectF.top - paramRectF.bottom) * paramFloat1);
    paramRectF.left += paramFloat2;
    paramRectF.right += paramFloat2;
    paramRectF.top -= paramFloat3;
    paramRectF.bottom -= paramFloat3;
    return paramRectF;
  }
  
  public boolean onDraw(RenderBuffer paramRenderBuffer, int paramInt, long paramLong, float paramFloat, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    boolean bool1 = false;
    super.onDraw(paramRenderBuffer, paramInt, paramLong, paramFloat, paramArrayOfFloat1, paramArrayOfFloat2);
    if (this.mMaterialID < 0)
    {
      SLog.e("QQMTV1Filter", "MTV1 material image load error");
      return false;
    }
    checkPlayState(paramLong, paramFloat);
    checkPlayData(paramLong);
    if (getPlayMode() == 0)
    {
      SLog.e("QQMTV1Filter", "MTV1 playmode is none, return");
      return false;
    }
    this.mBottomRender.updateData(this.mBottomColor, this.mBGTextParam);
    boolean bool2 = updateRendBuffer(paramRenderBuffer, this.mBottomRender.process(paramRenderBuffer, paramInt, paramArrayOfFloat1, paramArrayOfFloat2));
    this.mVideoRender.updateData(this.mShapePoints, this.mPaletteID);
    if ((updateRendBuffer(paramRenderBuffer, this.mVideoRender.process(paramRenderBuffer, paramInt, null, paramArrayOfFloat2))) || (bool2)) {}
    for (int i = 1;; i = 0)
    {
      this.mTopRender.updateData(this.mDovTextParam, this.mTodayTextParam);
      if ((updateRendBuffer(paramRenderBuffer, this.mTopRender.process(paramRenderBuffer, paramInt, paramArrayOfFloat1, paramArrayOfFloat2))) || (i != 0)) {
        bool1 = true;
      }
      this.mGlitchLoader.releaseCurrentTexture();
      return bool1;
    }
  }
  
  public void onReset(long paramLong)
  {
    resetInner(paramLong);
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    this.mBottomRender.onSurfaceChanged(paramInt1, paramInt2);
    this.mTopRender.onSurfaceChanged(paramInt1, paramInt2);
    this.mVideoRender.onSurfaceChanged(paramInt1, paramInt2);
    if (this.mBaseFilter != null) {
      this.mBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
    for (;;)
    {
      loadMaterial(paramInt1, paramInt2);
      return;
      this.mBaseFilter = new GPUBaseFilter();
      this.mBaseFilter.init();
      if (this.mBaseFilter.isInitialized()) {
        this.mBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
      } else {
        this.mBaseFilter = null;
      }
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.mMaterialID > 0)
    {
      GlUtil.deleteTexture(this.mMaterialID);
      this.mMaterialID = -1;
    }
    this.mBottomRender.onSurfaceDestroy();
    this.mTopRender.onSurfaceDestroy();
    this.mVideoRender.onSurfaceDestroy();
    if (this.mBaseFilter != null)
    {
      this.mBaseFilter.destroy();
      this.mBaseFilter = null;
    }
    this.mGlitchLoader.unInit();
    this.mState = 1;
    this.mStateStartPos = 0L;
    this.mStateEndPos = 0L;
    this.mShapePoints = null;
  }
  
  public void setShowEntrance(boolean paramBoolean)
  {
    this.mShowEntrance = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTV1Filter
 * JD-Core Version:    0.7.0.1
 */