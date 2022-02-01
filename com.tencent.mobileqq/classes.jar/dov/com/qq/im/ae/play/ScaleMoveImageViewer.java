package dov.com.qq.im.ae.play;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.videoshelf.ImagePositonManager;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.PicChooseJumpUtil;
import java.lang.reflect.Field;

public class ScaleMoveImageViewer
  extends ImageView
  implements View.OnClickListener, View.OnTouchListener
{
  private static final float MAX_SCALE = 4.0F;
  private static final float MIN_SCALE = 0.2F;
  private static final String TAG = ScaleMoveImageViewer.class.getSimpleName();
  private float SOURCE_SCALE;
  private float currentX;
  private float currentY;
  private Matrix initMatrix = new Matrix();
  private boolean isAnimationPlaying = false;
  private boolean isImageSelected = false;
  private ScaleMoveImageViewer.OnSaveScrollInfoListener listener;
  private Activity mActivity;
  private LayerDrawable mAnimationDrawable;
  private Drawable mAnimationSolidDrawable;
  private float mBaseDistance = 0.0F;
  private Matrix mCurrentMatrix = new Matrix();
  private boolean mIsSelecting = false;
  private Matrix mLastGestureMatrix = new Matrix();
  private Drawable mMaskCoverImage;
  private boolean mMovable = false;
  private NodeItem mNodeItem = new NodeItem();
  private boolean mSigleDown = true;
  private ValueAnimator mValueAnimator;
  private int prePointerCount;
  private float preX;
  private float preY;
  private float touchDownX;
  private float touchDownY;
  private float touchUpX;
  private float touchUpY;
  private float[] values = new float[9];
  
  public ScaleMoveImageViewer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleMoveImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    clearSeclected();
    this.mAnimationDrawable = ((LayerDrawable)getResources().getDrawable(2130837680));
    this.mAnimationSolidDrawable = this.mAnimationDrawable.findDrawableByLayerId(2131368809);
    this.mMaskCoverImage = getResources().getDrawable(2130837689);
  }
  
  private void drawAnimationIfNeed(Canvas paramCanvas)
  {
    if (!this.isAnimationPlaying) {
      return;
    }
    this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.mAnimationDrawable.draw(paramCanvas);
  }
  
  private void drawCoverImage(Canvas paramCanvas)
  {
    if (this.mMaskCoverImage != null)
    {
      this.mMaskCoverImage.setBounds(0, getHeight() / 2, getWidth(), getHeight());
      this.mMaskCoverImage.draw(paramCanvas);
    }
  }
  
  private float getScale()
  {
    this.mCurrentMatrix.getValues(this.values);
    return Math.min(this.values[0], this.values[4]);
  }
  
  private void onTouchScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = getScale();
    if (((f > 4.0F) && (paramFloat1 < 1.0F)) || ((f < 0.2F) && (paramFloat1 > 1.0F)) || ((paramFloat1 < 4.0F) && (paramFloat1 > 0.2F))) {
      this.mCurrentMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    }
    if (getScale() < this.SOURCE_SCALE) {
      this.mCurrentMatrix.set(this.mLastGestureMatrix);
    }
    ImagePositonManager.setShowPosition(getDrawable(), this.mCurrentMatrix, getWidth(), getHeight());
    setImageMatrix(this.mCurrentMatrix);
    updateCurrentMatrix();
    this.mLastGestureMatrix.set(this.mCurrentMatrix);
  }
  
  private void updateCurrentMatrix()
  {
    if ((this.mNodeItem != null) && (this.mNodeItem.matrix != null)) {
      this.mNodeItem.matrix.set(this.mCurrentMatrix);
    }
  }
  
  public void activeSelected()
  {
    this.mIsSelecting = true;
  }
  
  public void clearBitmaps()
  {
    if ((this.mNodeItem.bitmap != null) && (!this.mNodeItem.bitmap.isRecycled())) {
      this.mNodeItem.bitmap.recycle();
    }
    if ((this.mNodeItem.cropBitmap != null) && (!this.mNodeItem.cropBitmap.isRecycled())) {
      this.mNodeItem.cropBitmap.recycle();
    }
    setImageBitmap(null);
  }
  
  public void clearSeclected()
  {
    this.mIsSelecting = false;
  }
  
  public NodeItem getNode()
  {
    return this.mNodeItem;
  }
  
  public int getNodeGroupID()
  {
    return this.mNodeItem.nodeGroupID;
  }
  
  public int getNodeID()
  {
    return this.mNodeItem.nodeID;
  }
  
  public boolean isImageSelected()
  {
    return this.isImageSelected;
  }
  
  public void onClick(View paramView)
  {
    if (this.mIsSelecting) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      activeSelected();
      AEBaseDataReporter.a().h();
      PicChooseJumpUtil.b(this.mActivity, this.mNodeItem.nodeID);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.mNodeItem.once) {
      updateMatrix(getWidth(), getHeight());
    }
    for (;;)
    {
      try
      {
        super.onDraw(paramCanvas);
        drawAnimationIfNeed(paramCanvas);
        drawCoverImage(paramCanvas);
        return;
      }
      catch (Throwable paramCanvas) {}
      this.mCurrentMatrix.set(this.mNodeItem.matrix);
      setImageMatrix(this.mCurrentMatrix);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.currentX = 0.0F;
    this.currentY = 0.0F;
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      this.currentX += paramMotionEvent.getX();
      this.currentY += paramMotionEvent.getY();
      i += 1;
    }
    this.currentX /= j;
    this.currentY /= j;
    if (j != this.prePointerCount)
    {
      this.preX = this.currentX;
      this.preY = this.currentY;
      this.prePointerCount = j;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.touchDownX = paramMotionEvent.getRawX();
      this.touchDownY = paramMotionEvent.getRawY();
      this.mSigleDown = true;
      this.mBaseDistance = 0.0F;
      return true;
      this.mSigleDown = false;
      return true;
      float f1 = this.currentX;
      float f2 = this.preX;
      float f3 = this.currentY;
      float f4 = this.preY;
      ImagePositonManager.setMovePosition(getDrawable(), this.mCurrentMatrix, f1 - f2, f3 - f4, getWidth(), getHeight());
      setImageMatrix(this.mCurrentMatrix);
      updateCurrentMatrix();
      this.preX = this.currentX;
      this.preY = this.currentY;
      if (paramMotionEvent.getPointerCount() == 2)
      {
        f1 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f2 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        f3 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        f4 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
        if (this.mBaseDistance == 0.0F)
        {
          this.mBaseDistance = f3;
          return true;
        }
        if (Math.abs(f3 - this.mBaseDistance) >= 10.0F)
        {
          f4 = f3 / this.mBaseDistance;
          this.mBaseDistance = f3;
          onTouchScale(f4, f1, f2);
          return true;
          this.touchUpX = paramMotionEvent.getRawX();
          this.touchUpY = paramMotionEvent.getRawY();
          this.prePointerCount = 0;
          if ((Math.abs(this.touchUpX - this.touchDownX) > 10.0F) || (Math.abs(this.touchDownY - this.touchUpY) > 10.0F))
          {
            if (this.listener != null)
            {
              this.listener.onSaveScrollInfo(this.mNodeItem);
              return true;
            }
          }
          else if (this.mSigleDown) {
            try
            {
              paramMotionEvent = View.class.getDeclaredField("mListenerInfo");
              paramMotionEvent.setAccessible(true);
              paramMotionEvent = paramMotionEvent.get(paramView);
              Field localField = paramMotionEvent.getClass().getDeclaredField("mOnClickListener");
              localField.setAccessible(true);
              paramMotionEvent = localField.get(paramMotionEvent);
              if ((paramMotionEvent != null) && ((paramMotionEvent instanceof View.OnClickListener)))
              {
                ((View.OnClickListener)paramMotionEvent).onClick(paramView);
                return true;
              }
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
            }
          }
        }
      }
    }
    return true;
  }
  
  public void setImageSelected(boolean paramBoolean)
  {
    this.isImageSelected = paramBoolean;
  }
  
  public void setMovable(boolean paramBoolean)
  {
    this.mMovable = paramBoolean;
    if (this.mMovable)
    {
      setOnTouchListener(this);
      return;
    }
    setOnTouchListener(null);
  }
  
  public void setNodeBitmap(Bitmap paramBitmap)
  {
    this.mNodeItem.bitmap = paramBitmap;
    this.mNodeItem.once = true;
    if (this.listener != null) {
      this.listener.onSaveScrollInfo(this.mNodeItem);
    }
  }
  
  public void setNodeInfo(NodeItem paramNodeItem)
  {
    this.mNodeItem.nodeID = paramNodeItem.nodeID;
    this.mNodeItem.nodeGroupID = paramNodeItem.nodeGroupID;
    this.mNodeItem.once = paramNodeItem.once;
    this.mNodeItem.matrix.set(paramNodeItem.matrix);
    this.mNodeItem.bitmap = paramNodeItem.bitmap;
    this.mNodeItem.maskRect = paramNodeItem.maskRect;
    this.mNodeItem.zIndex = paramNodeItem.zIndex;
    this.mNodeItem.type = paramNodeItem.type;
  }
  
  public void setOnSaveScrollInfoListener(ScaleMoveImageViewer.OnSaveScrollInfoListener paramOnSaveScrollInfoListener)
  {
    this.listener = paramOnSaveScrollInfoListener;
  }
  
  public void startAnimaterIfNeed()
  {
    if (this.mValueAnimator == null)
    {
      this.mValueAnimator = ValueAnimator.ofInt(new int[] { 150, 0 });
      this.mValueAnimator.setDuration(700L);
      this.mValueAnimator.setRepeatCount(4);
      this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
      this.mValueAnimator.setRepeatMode(2);
      this.mValueAnimator.addUpdateListener(new ScaleMoveImageViewer.1(this));
      this.mValueAnimator.addListener(new ScaleMoveImageViewer.2(this));
    }
    if (this.mValueAnimator.isRunning()) {
      this.mValueAnimator.cancel();
    }
    this.mValueAnimator.start();
  }
  
  public void updateCropBitmap()
  {
    this.mNodeItem.matrix.getValues(this.values);
    int i = (int)((int)(0 - this.values[2]) / this.values[0]);
    int j = (int)((int)(0 - this.values[5]) / this.values[4]);
    int k = (int)(getWidth() / this.values[0]);
    int m = (int)(getHeight() / this.values[4]);
    if ((k <= 0) || (m <= 0) || (i < 0) || (j < 0))
    {
      if ((this.mNodeItem.cropBitmap != null) && (!this.mNodeItem.cropBitmap.isRecycled())) {
        this.mNodeItem.cropBitmap.recycle();
      }
      if (this.mNodeItem.bitmap != null) {
        this.mNodeItem.cropBitmap = Bitmap.createBitmap(this.mNodeItem.bitmap, 0, 0, this.mNodeItem.bitmap.getWidth() - 1, this.mNodeItem.bitmap.getHeight() - 1);
      }
      if (this.listener != null) {
        this.listener.onSaveScrollInfo(this.mNodeItem);
      }
    }
    for (;;)
    {
      return;
      if ((this.mNodeItem.cropBitmap != null) && (!this.mNodeItem.cropBitmap.isRecycled()) && (this.mNodeItem.bitmap != this.mNodeItem.cropBitmap)) {
        this.mNodeItem.cropBitmap.recycle();
      }
      if ((this.mNodeItem.bitmap != null) && (!this.mNodeItem.bitmap.isRecycled())) {}
      try
      {
        this.mNodeItem.cropBitmap = Bitmap.createBitmap(this.mNodeItem.bitmap, i, j, k, m);
        if (this.listener == null) {
          continue;
        }
        this.listener.onSaveScrollInfo(this.mNodeItem);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.mNodeItem.cropBitmap = this.mNodeItem.bitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          this.mNodeItem.cropBitmap = this.mNodeItem.bitmap;
        }
      }
    }
  }
  
  public void updateMatrix(int paramInt1, int paramInt2)
  {
    this.initMatrix.reset();
    this.mCurrentMatrix.set(this.initMatrix);
    if (this.mNodeItem != null) {
      this.mNodeItem.once = false;
    }
    int k = 720;
    int m = 1280;
    Drawable localDrawable = getDrawable();
    int j;
    int i;
    if (localDrawable != null)
    {
      j = localDrawable.getIntrinsicWidth();
      i = localDrawable.getIntrinsicHeight();
    }
    for (;;)
    {
      float f = Math.max(paramInt1 * 1.0F / j, paramInt2 * 1.0F / i);
      this.SOURCE_SCALE = f;
      this.mCurrentMatrix.postTranslate(paramInt1 / 2 - j / 2, paramInt2 / 2 - i / 2);
      this.mCurrentMatrix.postScale(f, f, paramInt1 / 2, paramInt2 / 2);
      setImageMatrix(this.mCurrentMatrix);
      this.mLastGestureMatrix.set(this.mCurrentMatrix);
      updateCurrentMatrix();
      return;
      i = m;
      j = k;
      if (this.mNodeItem != null)
      {
        i = m;
        j = k;
        if (this.mNodeItem.bitmap != null)
        {
          j = this.mNodeItem.bitmap.getWidth();
          i = this.mNodeItem.bitmap.getHeight();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.ScaleMoveImageViewer
 * JD-Core Version:    0.7.0.1
 */