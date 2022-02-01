package cooperation.plugin;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class PluginIphoneTitleBarActivity
  extends PluginBaseActivity
{
  private boolean a;
  protected TextView aN;
  protected TextView aO;
  protected TextView aP;
  protected TextView aQ;
  protected TextView aR;
  protected ImageView aS;
  protected ViewGroup aT;
  public View aU = null;
  public RelativeLayout aV;
  protected float aW;
  protected boolean aX = true;
  protected View.OnClickListener aY = new PluginIphoneTitleBarActivity.1(this);
  private Drawable b;
  private Drawable[] c;
  private int d;
  
  @TargetApi(11)
  public static void f(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(1, null);
    }
  }
  
  protected View H()
  {
    this.aP = ((TextView)findViewById(2131436211));
    this.aS = ((ImageView)findViewById(2131436194));
    this.aR = ((TextView)findViewById(2131448242));
    f(this.aP);
    f(this.aS);
    return this.aP;
  }
  
  protected View M()
  {
    this.aN = ((TextView)findViewById(2131436180));
    TextView localTextView = this.aN;
    if (localTextView != null)
    {
      localTextView.setOnClickListener(this.aY);
      f(this.aN);
    }
    return this.aN;
  }
  
  protected View N()
  {
    this.aO = ((TextView)findViewById(2131436227));
    return this.aO;
  }
  
  protected boolean O()
  {
    if (this.b == null)
    {
      this.b = getResources().getDrawable(2130839590);
      this.c = this.aO.getCompoundDrawables();
      this.d = this.aO.getCompoundDrawablePadding();
      this.aO.setCompoundDrawablePadding(10);
      TextView localTextView = this.aO;
      Drawable localDrawable = this.b;
      Drawable[] arrayOfDrawable = this.c;
      localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      ((Animatable)this.b).start();
      return true;
    }
    return false;
  }
  
  protected boolean P()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((Animatable)localObject).stop();
      this.b = null;
      this.aO.setCompoundDrawablePadding(this.d);
      localObject = this.aO;
      Drawable[] arrayOfDrawable = this.c;
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return true;
    }
    return false;
  }
  
  protected void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    a(getString(paramInt), paramOnClickListener);
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130852235));
    if (this.aN == null)
    {
      this.aT = ((ViewGroup)findViewById(2131444897));
      f(this.aT);
      M();
      N();
      H();
      c(paramIntent);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.aW = getResources().getDisplayMetrics().density;
    if (paramBoolean)
    {
      requestWindowFeature(7);
      super.setContentView(paramView);
      getWindow().setFeatureInt(7, 2131624579);
      a(getIntent());
      return;
    }
    requestWindowFeature(1);
    super.setContentView(paramView);
  }
  
  protected void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    this.a = false;
    this.aP.setVisibility(0);
    this.aP.setText(paramCharSequence);
    this.aP.setEnabled(true);
    if (paramOnClickListener != null) {
      this.aP.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected boolean bB_()
  {
    finish();
    return false;
  }
  
  protected void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.aN.setVisibility(8);
    this.aN = ((TextView)findViewById(2131436182));
    f(this.aN);
    this.aN.setVisibility(0);
    this.aN.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.aN.setOnClickListener(this.aY);
      return;
    }
    this.aN.setOnClickListener(paramOnClickListener);
  }
  
  protected void c(Intent paramIntent)
  {
    Object localObject = this.aN;
    if ((localObject != null) && ((localObject instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.aN;
      localObject = paramIntent.getExtras().getString("leftViewText");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = getString(2131887625);
      }
      if (this.aX)
      {
        localTextView.setText("  ");
        return;
      }
      localTextView.setText(paramIntent);
    }
  }
  
  public void c(View paramView)
  {
    super.setContentView(paramView);
  }
  
  public void d(View paramView)
  {
    super.setContentView(paramView);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void e(View paramView)
  {
    super.setContentView(paramView);
  }
  
  protected String f()
  {
    TextView localTextView = this.aO;
    if ((localTextView != null) && (localTextView.getText() != null) && (this.aO.getText().length() != 0)) {
      return this.aO.getText().toString();
    }
    return getString(2131887625);
  }
  
  public void g(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  protected void h(int paramInt)
  {
    Object localObject = this.aN;
    if ((localObject != null) && ((localObject instanceof TextView)))
    {
      String str = getString(paramInt);
      TextView localTextView = this.aN;
      if (str != null)
      {
        localObject = str;
        if (!"".equals(str)) {}
      }
      else
      {
        localObject = getString(2131887625);
      }
      if (this.aX)
      {
        localTextView.setText("  ");
        return;
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void s_(int paramInt)
  {
    this.aW = getResources().getDisplayMetrics().density;
    requestWindowFeature(1);
    super.setContentView(paramInt);
    a(getIntent());
  }
  
  public void setContentView(int paramInt)
  {
    Object localObject1 = getIntent();
    int i = 1;
    boolean bool;
    if (localObject1 != null) {
      bool = ((Intent)localObject1).getBooleanExtra("showTitleBar", true);
    } else {
      bool = true;
    }
    if (!this.aM)
    {
      if (bool) {
        requestWindowFeature(7);
      }
      super.setContentView(paramInt);
      if (bool) {
        getWindow().setFeatureInt(7, 2131624579);
      }
    }
    else if (bool)
    {
      Object localObject3 = LayoutInflater.from(this);
      localObject1 = ((LayoutInflater)localObject3).inflate(2131624581, null);
      try
      {
        localObject3 = ((LayoutInflater)localObject3).inflate(paramInt, (ViewGroup)localObject1, false);
        this.aV = ((RelativeLayout)((View)localObject1).findViewById(2131447595));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.aV.setFitsSystemWindows(true);
          this.aV.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131444897);
        this.aV.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        this.mContentView = ((View)localObject3);
        super.setContentView(this.aV);
        i = 0;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
      }
      catch (InflateException localInflateException)
      {
        localInflateException.printStackTrace();
      }
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("layout with merge ,use framelayout to immersive");
          ((StringBuilder)localObject2).append(getComponentName());
          QLog.e("IphoneTitleBarActivity", 2, ((StringBuilder)localObject2).toString());
        }
        super.setContentView(paramInt);
        getWindow().setFeatureInt(7, 2131624579);
        Object localObject2 = this.aU;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        this.aW = getResources().getDisplayMetrics().density;
        a(getIntent());
      }
    }
    else
    {
      super.setContentView(paramInt);
    }
    this.aW = getResources().getDisplayMetrics().density;
    if (bool) {
      a(getIntent());
    }
  }
  
  public void setContentView(View paramView)
  {
    a(paramView, true);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    TextView localTextView = this.aO;
    if ((localTextView != null) && ((localTextView instanceof TextView)))
    {
      localTextView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */