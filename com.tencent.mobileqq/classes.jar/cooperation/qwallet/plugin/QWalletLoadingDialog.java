package cooperation.qwallet.plugin;

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
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qqpay.ui.R.style;
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
    this(paramContext, R.style.d, paramBoolean);
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.mIsNeedOpenPatternLock)
    {
      localObject = this.mContext;
      if ((localObject instanceof QBaseActivity))
      {
        ((QBaseActivity)localObject).setCanLock(this.mBackupActivityCanLock);
        QBaseActivity.isUnLockSuccess = true;
      }
    }
    Object localObject = this.mAnimatedDrawale;
    if (localObject != null) {
      ((Animatable)localObject).stop();
    }
  }
  
  protected void init(Context paramContext)
  {
    if ((this.mIsNeedOpenPatternLock) && ((paramContext instanceof QBaseActivity)))
    {
      localObject = (QBaseActivity)paramContext;
      this.mBackupActivityCanLock = ((QBaseActivity)localObject).getCanLock();
      ((QBaseActivity)localObject).setCanLock(false);
    }
    super.requestWindowFeature(1);
    this.mContext = paramContext;
    WindowManager.LayoutParams localLayoutParams1 = null;
    localObject = localLayoutParams1;
    try
    {
      Window localWindow = getWindow();
      if (localWindow != null)
      {
        localObject = localLayoutParams1;
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          localObject = localLayoutParams1;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject = localLayoutParams1;
            if (!OSUtils.isEMUI3_1())
            {
              localObject = localLayoutParams1;
              if (Build.VERSION.SDK_INT >= 28)
              {
                localObject = localLayoutParams1;
                WindowManager.LayoutParams localLayoutParams2 = localWindow.getAttributes();
                if (localLayoutParams2 != null)
                {
                  localObject = localLayoutParams1;
                  localLayoutParams2.layoutInDisplayCutoutMode = 1;
                  localObject = localLayoutParams1;
                  localWindow.setAttributes(localLayoutParams2);
                }
              }
              localObject = localLayoutParams1;
              getWindow().clearFlags(67108864);
              localObject = localLayoutParams1;
              getWindow().addFlags(-2147483648);
              localObject = localLayoutParams1;
              getWindow().setStatusBarColor(0);
              localObject = localLayoutParams1;
              getWindow().getDecorView().setSystemUiVisibility(9216);
              break label187;
            }
          }
          localObject = localLayoutParams1;
          getWindow().addFlags(4194304);
        }
      }
      label187:
      localObject = localLayoutParams1;
      paramContext = LayoutInflater.from(paramContext).inflate(R.layout.B, null);
      localObject = paramContext;
      setContentView(paramContext);
      localObject = paramContext;
      paramContext.findViewById(R.id.ck).getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(this.mContext);
      localObject = paramContext;
      paramContext.setFitsSystemWindows(false);
      if (localWindow != null)
      {
        localObject = paramContext;
        localLayoutParams1 = localWindow.getAttributes();
        localObject = paramContext;
        localLayoutParams1.width = -1;
        localObject = paramContext;
        localLayoutParams1.height = -1;
        localObject = paramContext;
        localWindow.setAttributes(localLayoutParams1);
      }
      localObject = paramContext;
      setCanceledOnTouchOutside(false);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
    this.mCenterView = ((TextView)paramContext.findViewById(R.id.aE));
    localObject = this.mCenterView;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.mCenterView.setText(R.string.dr);
    }
    paramContext = (ImageView)paramContext.findViewById(R.id.aC);
    if (paramContext != null)
    {
      paramContext.setVisibility(0);
      paramContext.setImageResource(R.drawable.Z);
    }
    paramContext = (ImageView)super.findViewById(R.id.bo);
    localObject = new TranslateAnimation(1, -1.0F, 2, 1.0F, 1, 0.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((TranslateAnimation)localObject).setDuration(800L);
    ((TranslateAnimation)localObject).setRepeatCount(-1);
    paramContext.startAnimation((Animation)localObject);
    super.setCancelable(false);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.mAnimatedDrawale = ((Animatable)this.mContext.getResources().getDrawable(R.drawable.b));
    if (this.mAnimatedDrawale != null)
    {
      TextView localTextView = this.mCenterView;
      if (localTextView != null)
      {
        localTextView.setCompoundDrawablePadding(10);
        this.mCenterView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.mAnimatedDrawale, null, null, null);
        this.mAnimatedDrawale.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletLoadingDialog
 * JD-Core Version:    0.7.0.1
 */