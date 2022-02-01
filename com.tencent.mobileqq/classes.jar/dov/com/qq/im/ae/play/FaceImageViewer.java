package dov.com.qq.im.ae.play;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import bnqm;
import bnrj;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.videoshelf.ImagePositonManager;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import java.lang.reflect.Field;

public class FaceImageViewer
  extends ImageView
  implements View.OnClickListener, View.OnTouchListener
{
  private static final float ADD_ICON_WIDTH = 68.0F;
  private static final float CENTER_VIEW_WIDTH = 720.0F;
  private static final String TAG = FaceImageViewer.class.getSimpleName();
  private final int COMBINED_ACTION_PROTECT_DURATION = 300;
  private final int DRAG = 1;
  private final int MAX_SINGLE_CLICK_DURATION = 100;
  private final int MIN_MOVE_EVENT_COUNT_IN_COMBINED_ACTION = 5;
  private final int NONE = 0;
  private final int ZOOM = 2;
  private long actionDownTime;
  private long combinedActionProtectExpireAt;
  private float currentX;
  private float currentY;
  private Matrix initMatrix = new Matrix();
  private boolean isAnimationPlaying;
  private boolean isCombinedAction;
  private boolean isFirstDraw = true;
  private boolean isImageSelected;
  private FaceImageViewer.OnSaveScrollInfoListener listener;
  private Activity mActivity;
  private LayerDrawable mAnimationDrawable;
  private Drawable mAnimationSolidDrawable;
  private float mBaseDistance;
  private int mCenterViewWidth;
  private Matrix mCurrentMatrix = new Matrix();
  private boolean mIsSelecting;
  private float mLastRotation = 0.0F;
  private boolean mMovable;
  private NodeItem mNodeItem = new NodeItem();
  private boolean mSigleDown = true;
  private ValueAnimator mValueAnimator;
  private int mode = 0;
  private int moveEventCount;
  private int prePointerCount;
  private float preX;
  private float preY;
  private float touchDownX;
  private float touchDownY;
  private float touchUpX;
  private float touchUpY;
  private float[] values = new float[9];
  
  public FaceImageViewer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FaceImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    clearSeclected();
    this.mAnimationDrawable = ((LayerDrawable)getResources().getDrawable(2130837676));
    this.mAnimationSolidDrawable = this.mAnimationDrawable.findDrawableByLayerId(2131368579);
  }
  
  private float calcRotation(MotionEvent paramMotionEvent)
  {
    double d = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    return (float)Math.toDegrees(Math.atan2(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), d));
  }
  
  private void drawAnimationIfNeed(Canvas paramCanvas)
  {
    if (!this.isAnimationPlaying) {
      return;
    }
    this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.mAnimationDrawable.draw(paramCanvas);
  }
  
  private float getScale()
  {
    this.mCurrentMatrix.getValues(this.values);
    return Math.min(this.values[0], this.values[4]);
  }
  
  private void onTouchScaleAndRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mCurrentMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    ImagePositonManager.setShowPosition(getDrawable(), this.mCurrentMatrix, getWidth(), getHeight());
    this.mCurrentMatrix.postRotate(paramFloat4, getWidth() / 2, getHeight() / 2);
    setImageMatrix(this.mCurrentMatrix);
    updateCurrentMatrix();
  }
  
  private void operateMoveEvent(MotionEvent paramMotionEvent)
  {
    switch (this.mode)
    {
    }
    float f1;
    float f2;
    do
    {
      return;
      f1 = this.currentX;
      f2 = this.preX;
      f3 = this.currentY;
      f4 = this.preY;
      ImagePositonManager.setMovePosition(getDrawable(), this.mCurrentMatrix, f1 - f2, f3 - f4, getWidth(), getHeight());
      setImageMatrix(this.mCurrentMatrix);
      updateCurrentMatrix();
      this.preX = this.currentX;
      this.preY = this.currentY;
      return;
      f1 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
      f2 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
      f3 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      f4 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      f4 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      if (this.mBaseDistance == 0.0F)
      {
        this.mBaseDistance = f4;
        return;
      }
    } while (Math.abs(f4 - this.mBaseDistance) < 1.0F);
    float f3 = f4 / this.mBaseDistance;
    this.mBaseDistance = f4;
    float f4 = calcRotation(paramMotionEvent);
    float f5 = this.mLastRotation;
    this.mLastRotation = calcRotation(paramMotionEvent);
    onTouchScaleAndRotate(f3, f1, f2, f4 - f5);
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
      bnqm.a().h();
      bnrj.b(this.mActivity, this.mNodeItem.nodeID);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
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
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.actionDownTime = System.currentTimeMillis();
      this.touchDownX = paramMotionEvent.getRawX();
      this.touchDownY = paramMotionEvent.getRawY();
      this.mSigleDown = true;
      this.isCombinedAction = false;
      this.moveEventCount = 0;
      this.mBaseDistance = 0.0F;
      this.mode = 1;
      return true;
      this.mSigleDown = false;
      this.mLastRotation = calcRotation(paramMotionEvent);
      this.isCombinedAction = true;
      this.mode = 2;
      return true;
      this.mode = 0;
      return true;
      operateMoveEvent(paramMotionEvent);
      this.moveEventCount += 1;
      return true;
      long l1 = System.currentTimeMillis();
      long l2 = this.actionDownTime;
      if (this.moveEventCount > 5) {
        this.isCombinedAction = true;
      }
      if (this.isCombinedAction) {
        this.combinedActionProtectExpireAt = (l1 + 300L);
      }
      for (;;)
      {
        this.touchUpX = paramMotionEvent.getRawX();
        this.touchUpY = paramMotionEvent.getRawY();
        this.prePointerCount = 0;
        if ((Math.abs(this.touchUpX - this.touchDownX) <= 10.0F) && (Math.abs(this.touchDownY - this.touchUpY) <= 10.0F)) {
          break label406;
        }
        if (this.listener == null) {
          break;
        }
        this.listener.onSaveScrollInfo(this.mNodeItem);
        return true;
        if (l1 <= this.combinedActionProtectExpireAt) {
          this.mSigleDown = false;
        }
      }
      label406:
      if ((this.mSigleDown) && (l1 - l2 < 100L)) {
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
  }
  
  public void setOnSaveScrollInfoListener(FaceImageViewer.OnSaveScrollInfoListener paramOnSaveScrollInfoListener)
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
      this.mValueAnimator.addUpdateListener(new FaceImageViewer.1(this));
      this.mValueAnimator.addListener(new FaceImageViewer.2(this));
    }
    if (this.mValueAnimator.isRunning()) {
      this.mValueAnimator.cancel();
    }
    this.mValueAnimator.start();
  }
  
  public void transformCurrentMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.initMatrix.reset();
    this.mCurrentMatrix.set(this.initMatrix);
    this.mCurrentMatrix.postTranslate(paramFloat3, paramFloat4);
    this.mCurrentMatrix.postScale(paramFloat1, paramFloat1, getWidth() / 2, getHeight() / 2);
    this.mCurrentMatrix.postRotate(paramFloat2, getWidth() / 2, getHeight() / 2);
    setImageMatrix(this.mCurrentMatrix);
    updateCurrentMatrix();
    this.mNodeItem.once = false;
  }
  
  public void updateCropBitmap()
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    draw(new Canvas(localBitmap));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.mNodeItem.cropBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      localBitmap.recycle();
    }
    if (this.listener != null) {
      this.listener.onSaveScrollInfo(this.mNodeItem);
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
      this.mCurrentMatrix.postTranslate(paramInt1 / 2 - j / 2, paramInt2 / 2 - i / 2);
      this.mCurrentMatrix.postScale(f, f, paramInt1 / 2, paramInt2 / 2);
      setImageMatrix(this.mCurrentMatrix);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceImageViewer
 * JD-Core Version:    0.7.0.1
 */