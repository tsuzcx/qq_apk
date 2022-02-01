package com.tencent.mobileqq.qassistant.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import bakl;
import bamv;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory.ListenerAdapter;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieTask;

public class AssistantBackView
  extends ImageView
{
  private int jdField_a_of_type_Int = -1446926;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private LottieComposition.Factory.ListenerAdapter jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private LottieTask<LottieComposition> jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new AssistantBackView.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -16725252;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public AssistantBackView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AssistantBackView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AssistantBackView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    LottieComposition.Factory.ListenerAdapter localListenerAdapter = new LottieComposition.Factory.ListenerAdapter(new bamv(this));
    LottieTask localLottieTask = LottieCompositionFactory.fromAsset(getContext(), "login_btn_lottie_anim.json");
    localLottieTask.addListener(localListenerAdapter);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask = localLottieTask;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter = localListenerAdapter;
      return;
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((this.jdField_a_of_type_AndroidGraphicsPath == null) || (i != this.jdField_c_of_type_Int) || (j != this.d))
        {
          this.jdField_c_of_type_Int = i;
          this.d = j;
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
          this.jdField_a_of_type_AndroidGraphicsPath = new Path();
          this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 100.0F, 100.0F, Path.Direction.CW);
          this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.INVERSE_WINDING);
        }
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
      localOutOfMemoryError = localOutOfMemoryError;
      localOutOfMemoryError.printStackTrace();
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.clearComposition();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      this.jdField_c_of_type_Boolean = false;
      if (isEnabled()) {
        setBackgroundColor(this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        try
        {
          super.onDraw(paramCanvas);
        }
        catch (Throwable localThrowable)
        {
          localOutOfMemoryError.printStackTrace();
        }
        break;
        setBackgroundColor(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    boolean bool = isEnabled();
    super.setEnabled(paramBoolean);
    if (bool == paramBoolean) {
      return;
    }
    bakl.a("AssistantBackView", "setEnabled isEnabled:" + isEnabled() + "  mLottieDrawable:" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.AssistantBackView
 * JD-Core Version:    0.7.0.1
 */