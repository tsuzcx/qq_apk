package cooperation.qzone.panorama.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qzonehub.api.panorama.OnAnimateListener;
import java.util.Timer;
import java.util.TimerTask;

public class PanoramaGuideAnimate
  extends LinearLayout
{
  private static final float ALPHA_RATE = 0.05F;
  private static final int HANDLE_MSG_ALPHA = 292;
  private static final int HANDLE_MSG_ROTATE = 291;
  private static final int ORIENTATION_ANTI_CLOCK_WISE = 1;
  private static final int ORIENTATION_CLOCK_WISE = 0;
  private static final int ROTATE_ANGEL = 45;
  private static final float ROTATE_RATE = 0.15F;
  private static final int TRANSLATION_DISTANCE = 140;
  private float alpha = 1.0F;
  private Context context;
  private int currentOrientation = 0;
  private float currentRotate = 0.0F;
  private float currentTranslation = 0.0F;
  private Handler handler = new PanoramaGuideAnimate.1(this);
  private ImageView imgPhone;
  private OnAnimateListener onAnimateListener;
  private Timer timer;
  private TimerTask timerTask;
  private TextView tvToast;
  
  public PanoramaGuideAnimate(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PanoramaGuideAnimate(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void startTimer()
  {
    Object localObject = this.timer;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.timerTask;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    this.timer = new Timer();
    this.timerTask = new PanoramaGuideAnimate.2(this);
    this.timer.schedule(this.timerTask, 800L, 1L);
  }
  
  @TargetApi(11)
  public void addView(int paramInt)
  {
    setOrientation(1);
    setGravity(1);
    this.imgPhone = new ImageView(this.context);
    this.imgPhone.setImageResource(2130849511);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(100, 100);
    localLayoutParams.bottomMargin = 20;
    addView(this.imgPhone, localLayoutParams);
    this.tvToast = new TextView(this.context);
    if (paramInt == 1) {
      this.tvToast.setText(this.context.getResources().getString(2131914892));
    } else {
      this.tvToast.setText(this.context.getResources().getString(2131914893));
    }
    this.tvToast.setTextColor(-1);
    this.tvToast.setTextSize(14.0F);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    addView(this.tvToast, localLayoutParams);
    this.imgPhone.setRotationY(0.0F);
    this.imgPhone.setTranslationX(0.0F);
    startTimer();
  }
  
  public void onPause()
  {
    Object localObject = this.timer;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.timerTask;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
  }
  
  public void setOnAnimateListener(OnAnimateListener paramOnAnimateListener)
  {
    this.onAnimateListener = paramOnAnimateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaGuideAnimate
 * JD-Core Version:    0.7.0.1
 */