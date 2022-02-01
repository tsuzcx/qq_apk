package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import cooperation.qzone.util.PanoramaUtil;
import cooperation.qzone.util.QZLog;
import java.util.Timer;
import java.util.TimerTask;

public class PanoramaLoadingBall
  extends View
{
  private static final float INCREASE_SPEED = 0.3F;
  private static final int ROTATE_SPEED = 2;
  public static final int START_DEGREE = 60;
  private static final String TAG = "PanoramaLoadingBall";
  private static final int TYPE_ANTI_CLOCK_WISE = 1;
  private static final int TYPE_CLOCK_WISE = 0;
  public static final int TYPE_HORIZONTAL = 0;
  public static final int TYPE_VERTICAL = 1;
  private Context context;
  private float currentDegree;
  private float finalDegree;
  private Handler handler = new PanoramaLoadingBall.1(this, Looper.getMainLooper());
  private int inCircleRadius;
  private boolean isStop;
  private Paint mPaint;
  private int mViewHeight = PanoramaLoadingLayout.HEIGHT;
  private int mViewWidth = PanoramaLoadingLayout.WIDTH;
  private int midCircleRadius;
  private int outCircleRadius;
  private PanoramaLoadingBackground panoramaLoadingBackground;
  private int rotateDirection;
  private Timer timer;
  private TimerTask timerTask;
  private int type;
  
  public PanoramaLoadingBall(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PanoramaLoadingBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void drawMidCircle(Canvas paramCanvas)
  {
    this.mPaint.setColor(-1);
    this.mPaint.setStrokeWidth(3.0F);
    this.mPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(this.mViewWidth / 2, this.mViewWidth / 2, this.midCircleRadius, this.mPaint);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    setPivotX(this.mViewWidth / 2 + 5);
    setPivotY(this.mViewHeight / 2 - 5);
  }
  
  private int measureHeight(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.mViewHeight = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewHeight);
      } else {
        paramInt = this.mViewHeight;
      }
    }
  }
  
  private int measureWidth(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.mViewWidth = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewWidth);
      } else {
        paramInt = this.mViewWidth;
      }
    }
  }
  
  private void startTimerTask()
  {
    stopTimer();
    this.isStop = false;
    this.timer = new Timer();
    this.timerTask = new PanoramaLoadingBall.2(this);
    try
    {
      this.timer.schedule(this.timerTask, 0L, 15L);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QZLog.e("PanoramaLoadingBall", "startTimerTask IllegalStateException", localIllegalStateException);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.outCircleRadius = (this.mViewWidth / 2);
    this.midCircleRadius = (this.outCircleRadius - this.outCircleRadius / 5);
    this.inCircleRadius = (this.outCircleRadius - this.outCircleRadius * 2 / 5);
    drawMidCircle(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(measureWidth(paramInt1), measureHeight(paramInt2));
  }
  
  public void setRotationX(float paramFloat)
  {
    float f = 255.0F;
    if (!PanoramaUtil.getInstance().isClosePanoramaRotation()) {
      super.setRotationX(paramFloat);
    }
    paramFloat = paramFloat / this.finalDegree * (255 - PanoramaLoadingBackground.MIN_ALPHA) + PanoramaLoadingBackground.MIN_ALPHA;
    if (paramFloat > 255.0F) {
      paramFloat = f;
    }
    for (;;)
    {
      if (this.panoramaLoadingBackground != null) {
        this.panoramaLoadingBackground.setContentAlpha((int)paramFloat);
      }
      return;
    }
  }
  
  public void setRotationY(float paramFloat)
  {
    if (!PanoramaUtil.getInstance().isClosePanoramaRotation()) {
      super.setRotationY(paramFloat);
    }
  }
  
  public void startRotate(float paramFloat, int paramInt, PanoramaLoadingBackground paramPanoramaLoadingBackground)
  {
    this.finalDegree = paramFloat;
    this.currentDegree = paramFloat;
    this.type = paramInt;
    this.panoramaLoadingBackground = paramPanoramaLoadingBackground;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt != 0) {
        break label42;
      }
      setRotationX(paramFloat);
    }
    for (;;)
    {
      startTimerTask();
      return;
      label42:
      setRotationY(paramFloat);
    }
  }
  
  public void stopTimer()
  {
    this.isStop = true;
    if (this.timer != null) {
      this.timer.cancel();
    }
    if (this.timerTask != null) {
      this.timerTask.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBall
 * JD-Core Version:    0.7.0.1
 */