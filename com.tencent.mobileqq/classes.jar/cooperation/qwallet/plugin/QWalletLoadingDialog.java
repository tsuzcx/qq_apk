package cooperation.qwallet.plugin;

import ajeq;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QWalletLoadingDialog
  extends Dialog
{
  Animatable mAnimatedDrawale = null;
  protected boolean mBackupActivityCanLock = true;
  TextView mCenterView = null;
  Context mContext = null;
  protected boolean mIsNeedOpenPatternLock;
  
  protected QWalletLoadingDialog(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.mIsNeedOpenPatternLock = paramBoolean;
    init(paramContext);
  }
  
  public QWalletLoadingDialog(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, 2131755804, paramBoolean);
  }
  
  public void dismiss()
  {
    super.dismiss();
    if ((this.mIsNeedOpenPatternLock) && ((this.mContext instanceof BaseActivity)))
    {
      ((BaseActivity)this.mContext).setCanLock(this.mBackupActivityCanLock);
      BaseActivity.isUnLockSuccess = true;
    }
    if (this.mAnimatedDrawale != null) {
      this.mAnimatedDrawale.stop();
    }
  }
  
  protected void init(Context paramContext)
  {
    Object localObject;
    if ((this.mIsNeedOpenPatternLock) && ((paramContext instanceof BaseActivity)))
    {
      localObject = (BaseActivity)paramContext;
      this.mBackupActivityCanLock = ((BaseActivity)localObject).getCanLock();
      ((BaseActivity)localObject).setCanLock(false);
    }
    super.requestWindowFeature(1);
    this.mContext = paramContext;
    label342:
    for (;;)
    {
      try
      {
        localObject = getWindow();
        if ((localObject != null) && (ImmersiveUtils.isSupporImmersive() == 1))
        {
          if ((Build.VERSION.SDK_INT >= 21) && (!ajeq.d()))
          {
            if (Build.VERSION.SDK_INT >= 28)
            {
              localLayoutParams = ((Window)localObject).getAttributes();
              if (localLayoutParams != null)
              {
                localLayoutParams.layoutInDisplayCutoutMode = 1;
                ((Window)localObject).setAttributes(localLayoutParams);
              }
            }
            getWindow().clearFlags(67108864);
            getWindow().addFlags(-2147483648);
            getWindow().setStatusBarColor(0);
            getWindow().getDecorView().setSystemUiVisibility(1280);
          }
        }
        else {
          paramContext = LayoutInflater.from(paramContext).inflate(2131561871, null);
        }
      }
      catch (Throwable paramContext)
      {
        WindowManager.LayoutParams localLayoutParams;
        paramContext = null;
      }
      try
      {
        setContentView(paramContext);
        paramContext.findViewById(2131377007).getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(this.mContext);
        paramContext.setFitsSystemWindows(false);
        localLayoutParams = ((Window)localObject).getAttributes();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        ((Window)localObject).setAttributes(localLayoutParams);
        setCanceledOnTouchOutside(false);
        this.mCenterView = ((TextView)paramContext.findViewById(2131368670));
        if (this.mCenterView != null)
        {
          this.mCenterView.setVisibility(0);
          this.mCenterView.setText(2131717801);
        }
        paramContext = (TextView)paramContext.findViewById(2131368632);
        if (paramContext != null)
        {
          paramContext.setVisibility(0);
          paramContext.setText(2131717800);
        }
        paramContext = (ImageView)super.findViewById(2131372971);
        localObject = new TranslateAnimation(1, -1.0F, 2, 1.0F, 1, 0.0F, 1, 0.0F);
        ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        ((TranslateAnimation)localObject).setDuration(800L);
        ((TranslateAnimation)localObject).setRepeatCount(-1);
        paramContext.startAnimation((Animation)localObject);
        super.setCancelable(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label342;
      }
      getWindow().addFlags(4194304);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.mAnimatedDrawale = ((Animatable)this.mContext.getResources().getDrawable(2130839229));
    if ((this.mAnimatedDrawale != null) && (this.mCenterView != null))
    {
      this.mCenterView.setCompoundDrawablePadding(10);
      this.mCenterView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.mAnimatedDrawale, null, null, null);
      this.mAnimatedDrawale.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletLoadingDialog
 * JD-Core Version:    0.7.0.1
 */