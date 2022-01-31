package cooperation.qwallet.plugin;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
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
import com.tencent.widget.immersive.SystemBarCompact;

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
    this(paramContext, 2131624512, paramBoolean);
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
    if ((this.mIsNeedOpenPatternLock) && ((paramContext instanceof BaseActivity)))
    {
      localObject = (BaseActivity)paramContext;
      this.mBackupActivityCanLock = ((BaseActivity)localObject).getCanLock();
      ((BaseActivity)localObject).setCanLock(false);
    }
    super.requestWindowFeature(1);
    this.mContext = paramContext;
    Object localObject = getWindow();
    paramContext = LayoutInflater.from(paramContext).inflate(2130971057, null);
    setContentView(paramContext);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((Window)localObject).addFlags(67108864);
      new SystemBarCompact(this, true, this.mContext.getResources().getColor(2131494260)).init();
      paramContext.setFitsSystemWindows(true);
      paramContext.setPadding(0, ImmersiveUtils.a(this.mContext), 0, 0);
    }
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    ((Window)localObject).setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
    localObject = (TextView)paramContext.findViewById(2131363262);
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(2131433712);
    }
    this.mCenterView = ((TextView)paramContext.findViewById(2131363400));
    if (this.mCenterView != null)
    {
      this.mCenterView.setVisibility(0);
      this.mCenterView.setText(2131432147);
    }
    paramContext = (TextView)paramContext.findViewById(2131364662);
    if (paramContext != null)
    {
      paramContext.setVisibility(0);
      paramContext.setText(2131432164);
    }
    paramContext = (ImageView)super.findViewById(2131368124);
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
    this.mAnimatedDrawale = ((Animatable)this.mContext.getResources().getDrawable(2130838606));
    if ((this.mAnimatedDrawale != null) && (this.mCenterView != null))
    {
      this.mCenterView.setCompoundDrawablePadding(10);
      this.mCenterView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.mAnimatedDrawale, null, null, null);
      this.mAnimatedDrawale.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletLoadingDialog
 * JD-Core Version:    0.7.0.1
 */