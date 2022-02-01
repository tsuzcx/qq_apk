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
    int i = this.mViewWidth;
    paramCanvas.drawCircle(i / 2, i / 2, this.midCircleRadius, this.mPaint);
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
    if (i != 1073741824) {
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewHeight);
      } else {
        paramInt = this.mViewHeight;
      }
    }
    this.mViewHeight = paramInt;
    return paramInt;
  }
  
  private int measureWidth(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != 1073741824) {
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewWidth);
      } else {
        paramInt = this.mViewWidth;
      }
    }
    this.mViewWidth = paramInt;
    return paramInt;
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.outCircleRadius = (this.mViewWidth / 2);
    int i = this.outCircleRadius;
    this.midCircleRadius = (i - i / 5);
    this.inCircleRadius = (i - i * 2 / 5);
    drawMidCircle(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(measureWidth(paramInt1), measureHeight(paramInt2));
  }
  
  public void setRotationX(float paramFloat)
  {
    if (!PanoramaUtil.getInstance().isClosePanoramaRotation()) {
      super.setRotationX(paramFloat);
    }
    float f = paramFloat / this.finalDegree * (255 - PanoramaLoadingBackground.MIN_ALPHA) + PanoramaLoadingBackground.MIN_ALPHA;
    paramFloat = f;
    if (f > 255.0F) {
      paramFloat = 255.0F;
    }
    PanoramaLoadingBackground localPanoramaLoadingBackground = this.panoramaLoadingBackground;
    if (localPanoramaLoadingBackground != null) {
      localPanoramaLoadingBackground.setContentAlpha((int)paramFloat);
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
    if (Build.VERSION.SDK_INT >= 11) {
      if (paramInt == 0) {
        setRotationX(paramFloat);
      } else {
        setRotationY(paramFloat);
      }
    }
    startTimerTask();
  }
  
  public void stopTimer()
  {
    this.isStop = true;
    Object localObject = this.timer;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.timerTask;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBall
 * JD-Core Version:    0.7.0.1
 */