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
    int i;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 1;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          break label62;
        }
        if (paramInt == 3) {
          break label52;
        }
        if (paramInt != 4) {
          return paramLong;
        }
      }
      paramInt = i * 800;
    }
    for (;;)
    {
      return paramLong + paramInt;
      label52:
      paramInt = i * 500;
      continue;
      label62:
      paramInt = i * 1300;
      continue;
      paramInt = i * 3000;
    }
  }
  
  private boolean checkHighTimesLimited(long paramLong)
  {
    if (paramLong - this.mHighPeriodStartNs < 10000L)
    {
      paramLong = this.mHighPerioadTimes;
      if (paramLong >= 0L) {
        this.mHighPerioadTimes = (paramLong - 1L);
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
      paramLong = this.mLowPerioadTimes;
      if (paramLong >= 0L) {
        this.mLowPerioadTimes = (paramLong - 1L);
      }
      return this.mLowPerioadTimes > 0L;
    }
    this.mLowPeriodStartNs = paramLong;
    this.mLowPerioadTimes = 2L;
    return true;
  }
  
  private void checkPlayData(long paramLong)
  {
    int i = this.mState;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              break label181;
            }
          }
          else
          {
            this.mBottomColor = -14333474;
            fillBGTextParam(true, true, -265654, false);
            this.mPaletteID = 1;
            fillShapePoints(paramLong);
            break label181;
          }
        }
        else
        {
          if (checkRandomTime(this.mVideoChangeTime, paramLong, 300L, 300L))
          {
            this.mPaletteID = 0;
            this.mBottomColor = -13530;
            fillBGTextParam(true, true, -14737950, false);
          }
          else
          {
            this.mBottomColor = -14333474;
            fillBGTextParam(true, true, -265654, false);
            this.mPaletteID = 1;
          }
          fillShapePoints(paramLong);
          break label181;
        }
      }
      else
      {
        this.mBottomColor = -14868179;
        fillBGTextParam(false, false, 0, false);
        this.mPaletteID = -1;
        fillShapePoints(paramLong);
        break label181;
      }
    }
    this.mShapePoints = null;
    this.mBottomColor = -14868179;
    fillBGTextParam(false, false, 0, false);
    this.mPaletteID = -1;
    label181:
    i = this.mState;
    Object localObject;
    if ((i != 0) && (i != 4))
    {
      this.mDovTextParam.mShow = checkRandomTime(this.mDovShowTime, paramLong, 1500L, 3000L, 1000L);
      if (checkRandomTime(this.mDovGlitchTime, paramLong, 500L, 700L, 800L)) {
        this.mDovTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
      } else {
        this.mDovTextParam.mGlitchID = -1;
      }
      if (checkRandomTime(this.mDovScaleTime, paramLong, 500L, 1000L, 1000L)) {
        this.mDovTextParam.mRect = scaleAndOffset(this.DOV_RECT, 1.5F, 0.0F, 0.0F);
      } else {
        this.mDovTextParam.mRect = this.DOV_RECT;
      }
      this.mDovTextParam.mChangeColor = checkRandomTime(this.mDovColorTime, paramLong, 600L, 900L, 1000L);
      if (this.mDovTextParam.mChangeColor) {
        this.mDovTextParam.mColor = -14737950;
      }
      if (this.mDovTextParam.mShow)
      {
        this.mTodayTextParam.mShow = false;
      }
      else
      {
        this.mTodayTextParam.mShow = checkRandomTime(this.mTodayShowTime, paramLong, 1000L, 2000L, 1500L);
        if (checkRandomTime(this.mTodayScaleTime, paramLong, 200L, 500L, 1000L)) {
          this.mTodayTextParam.mRect = scaleAndOffset(this.TODAY_RECT, 1.5F, -0.1F, -0.1F);
        } else {
          this.mTodayTextParam.mRect = this.TODAY_RECT;
        }
        if (checkRandomTime(this.mTodayGlitchTime, paramLong, 200L, 500L, 3000L)) {
          this.mTodayTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
        } else {
          this.mTodayTextParam.mGlitchID = -1;
        }
        this.mTodayTextParam.mChangeColor = checkRandomTime(this.mTodayColorTime, paramLong, 200L, 500L, 1000L);
        if (this.mTodayTextParam.mChangeColor) {
          this.mTodayTextParam.mColor = -14737950;
        }
      }
    }
    else
    {
      this.mDovTextParam.mShow = checkRandomTime(this.mDovShowTime, paramLong, 60L, 200L, 1000L);
      if (checkRandomTime(this.mDovGlitchTime, paramLong, 500L, 700L, 800L)) {
        this.mDovTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
      } else {
        this.mDovTextParam.mGlitchID = -1;
      }
      localObject = this.mDovTextParam;
      ((MTVBaseFilter.TextParam)localObject).mRect = this.DOV_RECT;
      ((MTVBaseFilter.TextParam)localObject).mChangeColor = false;
      if (((MTVBaseFilter.TextParam)localObject).mShow)
      {
        this.mTodayTextParam.mShow = false;
      }
      else
      {
        this.mTodayTextParam.mShow = checkRandomTime(this.mTodayShowTime, paramLong, 60L, 200L, 1000L);
        this.mTodayTextParam.mRect = this.TODAY_RECT;
        if (checkRandomTime(this.mTodayGlitchTime, paramLong, 200L, 500L, 3000L)) {
          this.mTodayTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
        } else {
          this.mTodayTextParam.mGlitchID = -1;
        }
        this.mTodayTextParam.mChangeColor = false;
      }
    }
    if ((this.mTodayTextParam.mGlitchID < 0) && (this.mDovTextParam.mGlitchID < 0))
    {
      localObject = this.mGlitchLoader;
      if (localObject != null) {
        ((Mp4MaterialLoader)localObject).pause();
      }
    }
    else
    {
      localObject = this.mGlitchLoader;
      if (localObject != null) {
        ((Mp4MaterialLoader)localObject).resume();
      }
    }
  }
  
  private void checkPlayState(long paramLong, float paramFloat)
  {
    if ((!this.mShowEntrance) && (this.mState == 1)) {
      enterState(0, paramLong);
    }
    boolean bool = isStateFinish(this.mState, paramLong);
    if ((!bool) && (this.mState != 0)) {
      return;
    }
    clearState(this.mState);
    int i = this.mState;
    if (i == 1)
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
    if (i == 0)
    {
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
      if (i == 1)
      {
        if (checkLowTimesLimited(paramLong))
        {
          enterState(3, paramLong);
          return;
        }
        enterState(0, paramLong);
      }
    }
    else
    {
      if (i == 2)
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
      if (i == 3)
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
      if (i == 4)
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
      }
    }
  }
  
  private void clearState(int paramInt)
  {
    if (paramInt == 1) {
      return;
    }
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 2)
    {
      this.mVideoChangeTime.reset();
      return;
    }
  }
  
  private void enterState(int paramInt, long paramLong)
  {
    this.mStateStartPos = paramLong;
    this.mState = paramInt;
    paramInt = this.mState;
    paramLong = this.mStateStartPos;
    boolean bool;
    if (getPlayMode() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.mStateEndPos = calcEndPos(paramInt, paramLong, bool);
  }
  
  private void fillBGTextParam(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    MTVBaseFilter.TextParam localTextParam = this.mBGTextParam;
    localTextParam.mShow = paramBoolean1;
    localTextParam.mChangeColor = paramBoolean2;
    localTextParam.mColor = paramInt;
    localTextParam.mDistortion = paramBoolean3;
    if (localTextParam.mDistortion)
    {
      this.mBGTextParam.mRect = this.BG_TEXT_DISTORTION_RECT;
      return;
    }
    this.mBGTextParam.mRect = this.BG_TEXT_RECT;
  }
  
  private void fillShapePoints(long paramLong)
  {
    int i = this.mState;
    if (i == 1)
    {
      if ((float)Math.abs(paramLong - this.mStateStartPos) * 1.0F / (float)Math.abs(this.mStateEndPos - this.mStateStartPos) < 0.7F)
      {
        this.mShapePoints = MTV1ShapePoints.getOneRectPoints((float)Math.abs(paramLong - this.mStateStartPos) * 0.2F / (float)Math.abs(this.mStateEndPos - this.mStateStartPos), (float)Math.abs(paramLong - this.mStateStartPos) * 0.4F / (float)Math.abs(this.mStateEndPos - this.mStateStartPos), 0.0F);
        return;
      }
      this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09F, 0.26F, 0.16F, 0.25F, -1.0F);
      return;
    }
    float f;
    if (i == 2)
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
    if (i == 3)
    {
      f = (float)Math.abs(paramLong - this.mStateStartPos);
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
    int j = 800;
    int i;
    if (paramInt != 0)
    {
      i = j;
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            i = j;
            if (paramInt != 4) {
              i = -1;
            }
          }
          else
          {
            i = 500;
          }
        }
        else {
          i = 1300;
        }
      }
    }
    else
    {
      i = 3000;
    }
    return Math.abs(paramLong - this.mStateStartPos) > i;
  }
  
  /* Error */
  private void loadMaterial(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 473	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 476
    //   12: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: iload_1
    //   18: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc_w 485
    //   26: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc 139
    //   38: aload_3
    //   39: invokevirtual 489	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 495	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: invokevirtual 498	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:getMaterialPath	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: invokestatic 504	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +17 -> 73
    //   59: aload_0
    //   60: iconst_m1
    //   61: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   64: ldc 139
    //   66: ldc_w 506
    //   69: invokestatic 509	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: return
    //   73: aload_0
    //   74: getfield 296	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mGlitchLoader	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader;
    //   77: invokevirtual 513	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:isInited	()Z
    //   80: ifne +58 -> 138
    //   83: aload_0
    //   84: getfield 296	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mGlitchLoader	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader;
    //   87: iload_1
    //   88: iload_2
    //   89: invokevirtual 516	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:init	(II)V
    //   92: aload_0
    //   93: getfield 296	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mGlitchLoader	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader;
    //   96: astore_3
    //   97: new 473	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   104: astore 5
    //   106: aload 5
    //   108: aload 4
    //   110: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 5
    //   116: ldc 38
    //   118: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_3
    //   123: aload 5
    //   125: invokevirtual 489	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 519	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:start	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 296	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mGlitchLoader	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader;
    //   135: invokevirtual 378	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:pause	()V
    //   138: aload_0
    //   139: getfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   142: ifgt +389 -> 531
    //   145: aconst_null
    //   146: astore 6
    //   148: aconst_null
    //   149: astore 5
    //   151: aconst_null
    //   152: astore_3
    //   153: new 473	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   160: astore 7
    //   162: aload 7
    //   164: aload 4
    //   166: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 7
    //   172: ldc 83
    //   174: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: new 521	java/io/FileInputStream
    //   181: dup
    //   182: aload 7
    //   184: invokevirtual 489	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokespecial 523	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   190: astore 4
    //   192: new 525	java/io/BufferedInputStream
    //   195: dup
    //   196: aload 4
    //   198: invokespecial 528	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   201: astore_3
    //   202: aload_3
    //   203: invokestatic 534	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   206: astore 5
    //   208: aload_0
    //   209: sipush 3553
    //   212: aload 5
    //   214: invokestatic 540	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   217: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   225: iload_1
    //   226: iload_2
    //   227: invokespecial 544	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:revertTexture	(III)I
    //   230: istore_1
    //   231: iload_1
    //   232: iflt +15 -> 247
    //   235: aload_0
    //   236: getfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   239: invokestatic 547	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:deleteTexture	(I)V
    //   242: aload_0
    //   243: iload_1
    //   244: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   247: aload_0
    //   248: aload 5
    //   250: invokevirtual 552	android/graphics/Bitmap:getWidth	()I
    //   253: aload 5
    //   255: invokevirtual 555	android/graphics/Bitmap:getHeight	()I
    //   258: invokespecial 557	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:initMaterialData	(II)V
    //   261: aload 4
    //   263: invokevirtual 562	java/io/InputStream:close	()V
    //   266: aload_3
    //   267: invokevirtual 562	java/io/InputStream:close	()V
    //   270: return
    //   271: astore 6
    //   273: aload_3
    //   274: astore 5
    //   276: aload 6
    //   278: astore_3
    //   279: goto +12 -> 291
    //   282: astore 5
    //   284: goto +35 -> 319
    //   287: astore_3
    //   288: aconst_null
    //   289: astore 5
    //   291: aload 4
    //   293: astore 6
    //   295: aload 5
    //   297: astore 4
    //   299: aload 6
    //   301: astore 5
    //   303: goto +203 -> 506
    //   306: aconst_null
    //   307: astore_3
    //   308: aload 4
    //   310: astore 6
    //   312: goto +34 -> 346
    //   315: astore 5
    //   317: aconst_null
    //   318: astore_3
    //   319: aload 4
    //   321: astore 6
    //   323: aload 5
    //   325: astore 7
    //   327: goto +70 -> 397
    //   330: astore_3
    //   331: aconst_null
    //   332: astore 4
    //   334: goto +172 -> 506
    //   337: aconst_null
    //   338: astore 4
    //   340: aload_3
    //   341: astore 6
    //   343: aload 4
    //   345: astore_3
    //   346: aload_3
    //   347: astore 4
    //   349: aload 6
    //   351: astore 5
    //   353: ldc 139
    //   355: ldc_w 564
    //   358: invokestatic 509	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_3
    //   362: astore 4
    //   364: aload 6
    //   366: astore 5
    //   368: aload_0
    //   369: iconst_m1
    //   370: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   373: aload 6
    //   375: ifnull +11 -> 386
    //   378: aload 6
    //   380: invokevirtual 562	java/io/InputStream:close	()V
    //   383: goto +3 -> 386
    //   386: aload_3
    //   387: ifnull +144 -> 531
    //   390: goto -124 -> 266
    //   393: astore 7
    //   395: aconst_null
    //   396: astore_3
    //   397: aload_3
    //   398: astore 4
    //   400: aload 6
    //   402: astore 5
    //   404: new 473	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   411: astore 8
    //   413: aload_3
    //   414: astore 4
    //   416: aload 6
    //   418: astore 5
    //   420: aload 8
    //   422: ldc_w 566
    //   425: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_3
    //   430: astore 4
    //   432: aload 6
    //   434: astore 5
    //   436: aload 8
    //   438: aload 7
    //   440: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_3
    //   445: astore 4
    //   447: aload 6
    //   449: astore 5
    //   451: ldc 139
    //   453: aload 8
    //   455: invokevirtual 489	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 509	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: aload_3
    //   462: astore 4
    //   464: aload 6
    //   466: astore 5
    //   468: aload_0
    //   469: iconst_m1
    //   470: putfield 298	com/tencent/mobileqq/shortvideo/mtveffects/MTV1Filter:mMaterialID	I
    //   473: aload_3
    //   474: astore 4
    //   476: aload 6
    //   478: astore 5
    //   480: aload 7
    //   482: invokevirtual 572	java/lang/Exception:printStackTrace	()V
    //   485: aload 6
    //   487: ifnull +11 -> 498
    //   490: aload 6
    //   492: invokevirtual 562	java/io/InputStream:close	()V
    //   495: goto +3 -> 498
    //   498: aload_3
    //   499: ifnull +32 -> 531
    //   502: goto -236 -> 266
    //   505: astore_3
    //   506: aload 5
    //   508: ifnull +11 -> 519
    //   511: aload 5
    //   513: invokevirtual 562	java/io/InputStream:close	()V
    //   516: goto +3 -> 519
    //   519: aload 4
    //   521: ifnull +8 -> 529
    //   524: aload 4
    //   526: invokevirtual 562	java/io/InputStream:close	()V
    //   529: aload_3
    //   530: athrow
    //   531: return
    //   532: astore 4
    //   534: goto -197 -> 337
    //   537: astore_3
    //   538: goto -232 -> 306
    //   541: astore 5
    //   543: goto -235 -> 308
    //   546: astore 4
    //   548: goto -282 -> 266
    //   551: astore_3
    //   552: return
    //   553: astore 4
    //   555: goto -169 -> 386
    //   558: astore 4
    //   560: goto -62 -> 498
    //   563: astore 5
    //   565: goto -46 -> 519
    //   568: astore 4
    //   570: goto -41 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	MTV1Filter
    //   0	573	1	paramInt1	int
    //   0	573	2	paramInt2	int
    //   7	272	3	localObject1	Object
    //   287	1	3	localObject2	Object
    //   307	12	3	localObject3	Object
    //   330	11	3	localObject4	Object
    //   345	154	3	localObject5	Object
    //   505	25	3	localObject6	Object
    //   537	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   551	1	3	localIOException1	java.io.IOException
    //   49	476	4	localObject7	Object
    //   532	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   546	1	4	localIOException2	java.io.IOException
    //   553	1	4	localIOException3	java.io.IOException
    //   558	1	4	localIOException4	java.io.IOException
    //   568	1	4	localIOException5	java.io.IOException
    //   104	171	5	localObject8	Object
    //   282	1	5	localException1	java.lang.Exception
    //   289	13	5	localObject9	Object
    //   315	9	5	localException2	java.lang.Exception
    //   351	161	5	localObject10	Object
    //   541	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   563	1	5	localIOException6	java.io.IOException
    //   146	1	6	localObject11	Object
    //   271	6	6	localObject12	Object
    //   293	198	6	localObject13	Object
    //   160	166	7	localObject14	Object
    //   393	88	7	localException3	java.lang.Exception
    //   411	43	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   202	231	271	finally
    //   235	247	271	finally
    //   247	261	271	finally
    //   202	231	282	java/lang/Exception
    //   235	247	282	java/lang/Exception
    //   247	261	282	java/lang/Exception
    //   192	202	287	finally
    //   192	202	315	java/lang/Exception
    //   153	192	330	finally
    //   153	192	393	java/lang/Exception
    //   353	361	505	finally
    //   368	373	505	finally
    //   404	413	505	finally
    //   420	429	505	finally
    //   436	444	505	finally
    //   451	461	505	finally
    //   468	473	505	finally
    //   480	485	505	finally
    //   153	192	532	java/lang/OutOfMemoryError
    //   192	202	537	java/lang/OutOfMemoryError
    //   202	231	541	java/lang/OutOfMemoryError
    //   235	247	541	java/lang/OutOfMemoryError
    //   247	261	541	java/lang/OutOfMemoryError
    //   261	266	546	java/io/IOException
    //   266	270	551	java/io/IOException
    //   378	383	553	java/io/IOException
    //   490	495	558	java/io/IOException
    //   511	516	563	java/io/IOException
    //   524	529	568	java/io/IOException
  }
  
  private void resetInner(long paramLong)
  {
    if (this.mShowEntrance) {
      enterState(1, paramLong);
    } else {
      enterState(0, paramLong);
    }
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
    boolean bool1 = updateRendBuffer(paramRenderBuffer, this.mBottomRender.process(paramRenderBuffer, paramInt, paramArrayOfFloat1, paramArrayOfFloat2));
    this.mVideoRender.updateData(this.mShapePoints, this.mPaletteID);
    boolean bool3 = updateRendBuffer(paramRenderBuffer, this.mVideoRender.process(paramRenderBuffer, paramInt, null, paramArrayOfFloat2));
    boolean bool2 = true;
    int i;
    if ((!bool3) && (!bool1)) {
      i = 0;
    } else {
      i = 1;
    }
    this.mTopRender.updateData(this.mDovTextParam, this.mTodayTextParam);
    bool1 = bool2;
    if (!updateRendBuffer(paramRenderBuffer, this.mTopRender.process(paramRenderBuffer, paramInt, paramArrayOfFloat1, paramArrayOfFloat2))) {
      if (i != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.mGlitchLoader.releaseCurrentTexture();
    return bool1;
  }
  
  public void onReset(long paramLong)
  {
    resetInner(paramLong);
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      this.mBottomRender.onSurfaceChanged(paramInt1, paramInt2);
      this.mTopRender.onSurfaceChanged(paramInt1, paramInt2);
      this.mVideoRender.onSurfaceChanged(paramInt1, paramInt2);
      GPUBaseFilter localGPUBaseFilter = this.mBaseFilter;
      if (localGPUBaseFilter != null)
      {
        localGPUBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mBaseFilter = new GPUBaseFilter();
        this.mBaseFilter.init();
        if (this.mBaseFilter.isInitialized()) {
          this.mBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
        } else {
          this.mBaseFilter = null;
        }
      }
      loadMaterial(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    int i = this.mMaterialID;
    if (i > 0)
    {
      GlUtil.deleteTexture(i);
      this.mMaterialID = -1;
    }
    this.mBottomRender.onSurfaceDestroy();
    this.mTopRender.onSurfaceDestroy();
    this.mVideoRender.onSurfaceDestroy();
    GPUBaseFilter localGPUBaseFilter = this.mBaseFilter;
    if (localGPUBaseFilter != null)
    {
      localGPUBaseFilter.destroy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTV1Filter
 * JD-Core Version:    0.7.0.1
 */