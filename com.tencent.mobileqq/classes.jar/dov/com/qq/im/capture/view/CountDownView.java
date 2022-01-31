package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import blvm;
import blvn;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class CountDownView
  extends RelativeLayout
{
  private static final String jdField_a_of_type_JavaLangString = CountDownView.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new blvm(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blvn jdField_a_of_type_Blvn;
  private PlayerUtil.Player jdField_a_of_type_ComTencentTtpicBaseutilsAudioPlayerUtil$Player;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private boolean jdField_a_of_type_Boolean;
  private PlayerUtil.Player b;
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, 2130772007);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      setVisibility(4);
      if (this.jdField_a_of_type_Blvn != null) {
        this.jdField_a_of_type_Blvn.b();
      }
      return;
    }
    String str = String.format(getResources().getConfiguration().locale, "%d", new Object[] { Integer.valueOf(paramInt) });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
    }
    try
    {
      Thread.sleep(150L);
      if (paramInt == 1)
      {
        PlayerUtil.startPlayer(this.jdField_a_of_type_ComTencentTtpicBaseutilsAudioPlayerUtil$Player, true);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        LogUtils.e(localInterruptedException);
        continue;
        if (paramInt <= 3) {
          PlayerUtil.startPlayer(this.b, true);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      setVisibility(4);
      if (this.jdField_a_of_type_Blvn != null) {
        this.jdField_a_of_type_Blvn.a();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 0)
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "Invalid input for countdown timer: " + paramInt + " seconds");
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375582));
  }
  
  public void setCountDownListener(blvn paramblvn)
  {
    this.jdField_a_of_type_Blvn = paramblvn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.CountDownView
 * JD-Core Version:    0.7.0.1
 */