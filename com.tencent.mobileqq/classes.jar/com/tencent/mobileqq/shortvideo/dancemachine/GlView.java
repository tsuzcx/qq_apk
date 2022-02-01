package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class GlView
{
  public static final int BLEND_ADDITIVE = 2;
  public static final int BLEND_ALPHA = 1;
  private static final int BLEND_MASK = 7;
  public static final int BLEND_MULTIPLIED = 4;
  public static boolean ENABLE_X_INVERSE = false;
  static final int FLOAT_BYTE = 4;
  private static final int PFLAG_ANIMATION_STARTED = 65536;
  static final int POINTS = 3;
  private static final float[] TEXTURE_COORD = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  static final int TRIANGLES = 1;
  static final int TRIANGLE_FAN = 2;
  static final int TRIANGLE_STRIP = 0;
  private float[] adjustTextureCoord = new float[8];
  private int[] bufferId = new int[1];
  protected GLViewContext context;
  private float[] dstPoint = new float[2];
  private int mBlendMode = 1;
  private Transformation mChildTransformation;
  protected RectF mClipRegion = new RectF();
  protected Color4f mColor = new Color4f(1.0F, 1.0F, 1.0F, 1.0F);
  private Animation mCurrentAnimation;
  private RectF mCurrentDrawRegion = new RectF();
  protected int mCurrentTexture;
  protected int mDrawMode = 2;
  protected boolean mEnableClip = false;
  protected boolean mEnableNegativeVertexAdjust = false;
  protected boolean mHaveMappedClipSize = false;
  protected boolean mHaveMappedSize = false;
  private int mPrivateFlags = 0;
  protected GLShaderManager.GLProgram mProgramObject;
  protected boolean mRequestUpdate;
  private String mShaderKey;
  protected RectF mSizeRegion = new RectF();
  private boolean mUseAdjustTextureCoord = false;
  protected FloatBuffer mVertexBuffer;
  protected int mVertexNum;
  protected PointF[] mVertexPointCache;
  protected int mVertexPointCount = 4;
  protected boolean mVisible;
  protected float mZOrderValue = -0.5F;
  private Matrix matrix = new Matrix();
  private float[] srcPoint = new float[2];
  
  public GlView(GLViewContext paramGLViewContext, String paramString)
  {
    this.context = paramGLViewContext;
    this.mShaderKey = paramString;
    this.mProgramObject = GLShaderManager.createProgram(paramString);
    this.mRequestUpdate = false;
    this.mEnableNegativeVertexAdjust = false;
    this.mUseAdjustTextureCoord = false;
  }
  
  private void allocateFloatBuffer(int paramInt)
  {
    this.mVertexBuffer = ByteBuffer.allocateDirect(paramInt * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertexBuffer.position(0);
  }
  
  private boolean animationHasTranslateAnimation()
  {
    Object localObject = this.mCurrentAnimation;
    if (localObject != null)
    {
      if ((localObject instanceof TranslateAnimation)) {
        return true;
      }
      if ((localObject instanceof AnimationSet))
      {
        localObject = ((AnimationSet)localObject).getAnimations().iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((Animation)((Iterator)localObject).next() instanceof TranslateAnimation)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void disableBlend()
  {
    GLES20.glDisable(3042);
  }
  
  private void drawRegion()
  {
    int i = this.mDrawMode;
    if (i == 0)
    {
      GLES20.glDrawArrays(5, 0, this.mVertexNum);
      return;
    }
    if (i == 1)
    {
      GLES20.glDrawArrays(4, 0, this.mVertexNum);
      return;
    }
    if (i == 2)
    {
      GLES20.glDrawArrays(6, 0, this.mVertexNum);
      return;
    }
    if (i == 3) {
      GLES20.glDrawArrays(0, 0, this.mVertexNum);
    }
  }
  
  private void enableBlend()
  {
    int i = this.mBlendMode;
    if ((i & 0x2) == 2)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 1);
      return;
    }
    if ((i & 0x4) == 4)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(0, 768);
      return;
    }
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
  }
  
  private boolean isAnimationStarted()
  {
    return (this.mPrivateFlags & 0x10000) == 65536;
  }
  
  private void mapPointData(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      Object localObject = this.srcPoint;
      PointF[] arrayOfPointF = this.mVertexPointCache;
      int j = paramInt1 + i;
      localObject[0] = arrayOfPointF[j].x;
      this.srcPoint[1] = this.mVertexPointCache[j].y;
      this.matrix.mapPoints(this.dstPoint, this.srcPoint);
      localObject = this.mVertexPointCache;
      arrayOfPointF = localObject[j];
      float[] arrayOfFloat = this.dstPoint;
      arrayOfPointF.x = arrayOfFloat[0];
      localObject[j].y = arrayOfFloat[1];
      i += 1;
    }
  }
  
  private void negativeVertexAdjust()
  {
    Object localObject;
    if (this.mVertexPointCache[1].y <= 0.0F)
    {
      this.mVertexPointCache[0].set(0.0F, 0.0F);
      this.mVertexPointCache[1].set(0.0F, 0.0F);
      this.mVertexPointCache[2].set(0.0F, 0.0F);
      this.mVertexPointCache[3].set(0.0F, 0.0F);
      int i = 0;
      for (;;)
      {
        localObject = this.adjustTextureCoord;
        if (i >= localObject.length) {
          break;
        }
        localObject[0] = 0.0F;
        i += 1;
      }
    }
    if (this.mVertexPointCache[0].y < 0.0F)
    {
      float f = this.mVertexPointCache[1].y - this.mVertexPointCache[0].y;
      f = (f - this.mVertexPointCache[1].y) / f;
      localObject = this.adjustTextureCoord;
      localObject[0] = 0.0F;
      localObject[1] = f;
      localObject[2] = 0.0F;
      localObject[3] = 1.0F;
      localObject[4] = 1.0F;
      localObject[5] = 1.0F;
      localObject[6] = 1.0F;
      localObject[7] = f;
      localObject = this.mVertexPointCache;
      localObject[0].y = 0.0F;
      localObject[3].y = 0.0F;
    }
  }
  
  private void setAnimation(Animation paramAnimation)
  {
    this.mCurrentAnimation = paramAnimation;
    if (paramAnimation != null)
    {
      if (paramAnimation.getStartTime() == -1L) {
        paramAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
      }
      paramAnimation.reset();
    }
  }
  
  private void setMapDataToRegion(RectF paramRectF)
  {
    paramRectF.left = this.mVertexPointCache[0].x;
    paramRectF.top = this.mVertexPointCache[0].y;
    paramRectF.right = this.mVertexPointCache[2].x;
    paramRectF.bottom = this.mVertexPointCache[2].y;
  }
  
  public void clearAnimation()
  {
    this.mCurrentAnimation = null;
    setAlpha(1.0F);
  }
  
  public void clearStatus() {}
  
  public void draw()
  {
    if (this.mVisible) {
      drawInternal();
    }
  }
  
  public final void drawInternal()
  {
    if (this.mProgramObject == null)
    {
      DanceLog.print("GlView", "GlView: drawInternal mProgramObject=null");
      return;
    }
    enableBlend();
    GLES20.glViewport(this.context.getViewPort().left, this.context.getViewPort().top, this.context.getViewPort().width(), this.context.getViewPort().height());
    GLES20.glUseProgram(this.mProgramObject.programId);
    GLES20.glUniformMatrix4fv(((Integer)this.mProgramObject.uniform.get("u_projectionMatrix")).intValue(), 1, false, this.context.getProjectMatrix(), 0);
    GLES20.glBindBuffer(34962, this.bufferId[0]);
    GlUtil.checkGlError("glBindBuffer");
    if (updateParam())
    {
      transferVertexData();
      this.mVertexBuffer.position(0);
      GLES20.glBufferData(34962, this.mVertexBuffer.capacity() * 4, this.mVertexBuffer, 35044);
    }
    updateAttribute();
    drawRegion();
    GLES20.glBindBuffer(34962, 0);
    disableBlend();
  }
  
  void generateAnimationVertexData()
  {
    Rect localRect = this.context.getViewPort();
    Animation localAnimation = getAnimation();
    if (localAnimation != null)
    {
      if (!localAnimation.isInitialized())
      {
        localAnimation.initialize((int)this.mClipRegion.width(), (int)this.mClipRegion.height(), localRect.width(), localRect.height());
        onAnimationStart();
      }
      if (this.mChildTransformation == null) {
        this.mChildTransformation = new Transformation();
      }
      this.mChildTransformation.getMatrix().reset();
      this.mChildTransformation.setAlpha(1.0F);
      boolean bool2 = localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.mChildTransformation);
      if ((isAnimationStarted()) && (localAnimation.hasEnded())) {
        onAnimationEnd();
      }
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (localAnimation.getFillAfter()) {
          bool1 = true;
        }
      }
      if (bool1)
      {
        setAlpha(this.mChildTransformation.getAlpha());
        if (!this.mChildTransformation.getMatrix().isIdentity())
        {
          this.matrix.reset();
          this.matrix.set(this.mChildTransformation.getMatrix());
          if (!animationHasTranslateAnimation()) {
            this.matrix.postTranslate(this.mClipRegion.left, this.mClipRegion.top);
          }
          this.mVertexPointCache[0].set(0.0F, 0.0F);
          this.mVertexPointCache[1].set(0.0F, this.mClipRegion.height());
          this.mVertexPointCache[2].set(this.mClipRegion.width(), this.mClipRegion.height());
          this.mVertexPointCache[3].set(this.mClipRegion.width(), 0.0F);
          mapPointData(0, 4);
          setMapDataToRegion(this.mCurrentDrawRegion);
          i = 1;
          j = 1;
          break label329;
        }
        i = 1;
        break label327;
      }
    }
    int i = 0;
    label327:
    int j = 0;
    label329:
    if (i == 0) {
      setAlpha(1.0F);
    }
    if (j == 0)
    {
      this.mVertexPointCache[0].set(this.mClipRegion.left, this.mClipRegion.top);
      this.mVertexPointCache[1].set(this.mClipRegion.left, this.mClipRegion.bottom);
      this.mVertexPointCache[2].set(this.mClipRegion.right, this.mClipRegion.bottom);
      this.mVertexPointCache[3].set(this.mClipRegion.right, this.mClipRegion.top);
      this.mCurrentDrawRegion.set(this.mClipRegion);
    }
    if (this.mEnableNegativeVertexAdjust)
    {
      negativeVertexAdjust();
      this.mUseAdjustTextureCoord = true;
    }
  }
  
  public Animation getAnimation()
  {
    return this.mCurrentAnimation;
  }
  
  public RectF getCurrentDrawRegionSize()
  {
    return this.mCurrentDrawRegion;
  }
  
  public void initView(int paramInt)
  {
    Object localObject = this.mProgramObject;
    if (localObject == null)
    {
      DanceLog.print("GlView", "GlView: initView mProgramObject=null");
      return;
    }
    this.mVertexPointCount = paramInt;
    allocateFloatBuffer(((GLShaderManager.GLProgram)localObject).getVertexAttributeSize() * this.mVertexPointCount);
    this.mVertexPointCache = new PointF[this.mVertexPointCount];
    localObject = this.bufferId;
    paramInt = 0;
    GLES20.glGenBuffers(1, (int[])localObject, 0);
    for (;;)
    {
      localObject = this.mVertexPointCache;
      if (paramInt >= localObject.length) {
        break;
      }
      localObject[paramInt] = new PointF();
      paramInt += 1;
    }
  }
  
  final void mapClipRegion()
  {
    if (!this.mHaveMappedClipSize)
    {
      this.context.mapNormalRegion(this.mClipRegion);
      this.mHaveMappedClipSize = true;
    }
  }
  
  final void mapSizeRegion()
  {
    if (!this.mHaveMappedSize)
    {
      this.context.mapNormalRegion(this.mSizeRegion);
      this.mHaveMappedSize = true;
    }
  }
  
  protected void onAnimationEnd()
  {
    this.mPrivateFlags &= 0xFFFEFFFF;
  }
  
  protected void onAnimationStart()
  {
    this.mPrivateFlags |= 0x10000;
  }
  
  public void release()
  {
    clearStatus();
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mColor.setValue(1.0F, 1.0F, 1.0F, paramFloat);
    this.mRequestUpdate = true;
  }
  
  public final void setBlendMode(int paramInt)
  {
    this.mBlendMode = (paramInt & 0x7);
  }
  
  final void setColorAttributeValue()
  {
    int i = 0;
    while (i < this.mVertexPointCount)
    {
      this.mColor.putValue(this.mVertexBuffer);
      i += 1;
    }
  }
  
  final void setVertexCoordinateData(float paramFloat)
  {
    boolean bool = this.context.getSurfaceViewSize().equals(this.context.getViewPort());
    int i = 0;
    while (i < this.mVertexPointCount)
    {
      if (bool) {
        this.mVertexBuffer.put(this.mVertexPointCache[i].x);
      } else if (ENABLE_X_INVERSE) {
        this.mVertexBuffer.put(this.context.getViewPort().width() - this.mVertexPointCache[i].x);
      } else {
        this.mVertexBuffer.put(this.mVertexPointCache[i].x);
      }
      this.mVertexBuffer.put(this.mVertexPointCache[i].y);
      this.mVertexBuffer.put(paramFloat);
      i += 1;
    }
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.mVisible = paramBoolean;
  }
  
  protected void setZOrderValue(float paramFloat)
  {
    this.mZOrderValue = paramFloat;
  }
  
  public void startAnimation(Animation paramAnimation)
  {
    if (this.mCurrentAnimation == null)
    {
      paramAnimation.setStartTime(-1L);
      setAnimation(paramAnimation);
    }
  }
  
  final void surfaceCoordinateMapToViewPortSize()
  {
    mapSizeRegion();
    mapClipRegion();
  }
  
  protected void transferVertexData()
  {
    surfaceCoordinateMapToViewPortSize();
    generateAnimationVertexData();
    this.mVertexBuffer.position(0);
    setVertexCoordinateData(this.mZOrderValue);
    if ((this.mEnableClip) && (this.mSizeRegion.contains(this.mClipRegion)))
    {
      float f3 = (this.mClipRegion.left - this.mSizeRegion.left) / this.mSizeRegion.width();
      float f2 = (this.mSizeRegion.right - this.mClipRegion.right) / this.mSizeRegion.width();
      float f1 = (this.mClipRegion.top - this.mSizeRegion.top) / this.mSizeRegion.height();
      float f4 = (this.mSizeRegion.bottom - this.mClipRegion.bottom) / this.mSizeRegion.height();
      this.mVertexBuffer.put(f3);
      this.mVertexBuffer.put(f1);
      this.mVertexBuffer.put(f3);
      FloatBuffer localFloatBuffer = this.mVertexBuffer;
      f3 = 1.0F - f4;
      localFloatBuffer.put(f3);
      localFloatBuffer = this.mVertexBuffer;
      f2 = 1.0F - f2;
      localFloatBuffer.put(f2);
      this.mVertexBuffer.put(f3);
      this.mVertexBuffer.put(f2);
      this.mVertexBuffer.put(f1);
    }
    else if (this.mUseAdjustTextureCoord)
    {
      this.mVertexBuffer.put(this.adjustTextureCoord);
      this.mUseAdjustTextureCoord = false;
    }
    else
    {
      this.mVertexBuffer.put(TEXTURE_COORD);
    }
    setColorAttributeValue();
    this.mVertexNum = 4;
    this.mDrawMode = 2;
  }
  
  protected void updateAttribute()
  {
    int i = ((Integer)this.mProgramObject.attribute.get("a_position")).intValue();
    GLES20.glVertexAttribPointer(i, 3, 5126, false, 0, 0);
    GLES20.glEnableVertexAttribArray(i);
    i = ((Integer)this.mProgramObject.attribute.get("a_texCoord")).intValue();
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.mProgramObject.getTextureOffset() * this.mVertexPointCount * 4);
    GLES20.glEnableVertexAttribArray(i);
    i = ((Integer)this.mProgramObject.attribute.get("a_color")).intValue();
    GLES20.glVertexAttribPointer(i, 4, 5126, false, 0, this.mProgramObject.getColorOffset() * this.mVertexPointCount * 4);
    GLES20.glEnableVertexAttribArray(i);
    i = ((Integer)this.mProgramObject.uniform.get("u_texture")).intValue();
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.mCurrentTexture);
    GLES20.glUniform1i(i, 0);
  }
  
  protected boolean updateParam()
  {
    boolean bool2 = this.mRequestUpdate;
    boolean bool1 = false;
    this.mRequestUpdate = false;
    if ((this.mCurrentAnimation != null) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GlView
 * JD-Core Version:    0.7.0.1
 */