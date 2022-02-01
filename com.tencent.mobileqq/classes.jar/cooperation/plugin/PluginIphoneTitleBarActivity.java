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
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected ViewGroup a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  protected float b;
  protected View.OnClickListener c = new PluginIphoneTitleBarActivity.1(this);
  public RelativeLayout e;
  protected ImageView f;
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  protected TextView l;
  public View r;
  protected boolean r;
  
  public PluginIphoneTitleBarActivity()
  {
    this.jdField_r_of_type_AndroidViewView = null;
    this.jdField_r_of_type_Boolean = true;
  }
  
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
  
  protected View a()
  {
    this.j = ((TextView)findViewById(2131369233));
    this.f = ((ImageView)findViewById(2131369216));
    this.l = ((TextView)findViewById(2131379495));
    f(this.j);
    f(this.f);
    return this.j;
  }
  
  protected String a()
  {
    TextView localTextView = this.i;
    if ((localTextView != null) && (localTextView.getText() != null) && (this.i.getText().length() != 0)) {
      return this.i.getText().toString();
    }
    return getString(2131690706);
  }
  
  protected void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    a(getString(paramInt), paramOnClickListener);
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130850439));
    if (this.h == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376636));
      f(this.jdField_a_of_type_AndroidViewViewGroup);
      b();
      c();
      a();
      b(paramIntent);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.b = getResources().getDisplayMetrics().density;
    if (paramBoolean)
    {
      requestWindowFeature(7);
      super.setContentView(paramView);
      getWindow().setFeatureInt(7, 2131558946);
      a(getIntent());
      return;
    }
    requestWindowFeature(1);
    super.setContentView(paramView);
  }
  
  protected void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.j.setVisibility(0);
    this.j.setText(paramCharSequence);
    this.j.setEnabled(true);
    if (paramOnClickListener != null) {
      this.j.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected boolean a()
  {
    finish();
    return false;
  }
  
  protected View b()
  {
    this.h = ((TextView)findViewById(2131369202));
    TextView localTextView = this.h;
    if (localTextView != null)
    {
      localTextView.setOnClickListener(this.c);
      f(this.h);
    }
    return this.h;
  }
  
  protected void b(Intent paramIntent)
  {
    Object localObject = this.h;
    if ((localObject != null) && ((localObject instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.h;
      localObject = paramIntent.getExtras().getString("leftViewText");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = getString(2131690706);
      }
      if (this.jdField_r_of_type_Boolean)
      {
        localTextView.setText("  ");
        return;
      }
      localTextView.setText(paramIntent);
    }
  }
  
  protected View c()
  {
    this.i = ((TextView)findViewById(2131369249));
    return this.i;
  }
  
  protected void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.h.setVisibility(8);
    this.h = ((TextView)findViewById(2131369204));
    f(this.h);
    this.h.setVisibility(0);
    this.h.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.h.setOnClickListener(this.c);
      return;
    }
    this.h.setOnClickListener(paramOnClickListener);
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
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.i.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.i.getCompoundDrawablePadding();
      this.i.setCompoundDrawablePadding(10);
      TextView localTextView = this.i;
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      Drawable[] arrayOfDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  protected boolean f()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      ((Animatable)localObject).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.i.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      localObject = this.i;
      Drawable[] arrayOfDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void g(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  protected void h(int paramInt)
  {
    Object localObject = this.h;
    if ((localObject != null) && ((localObject instanceof TextView)))
    {
      String str = getString(paramInt);
      TextView localTextView = this.h;
      if (str != null)
      {
        localObject = str;
        if (!"".equals(str)) {}
      }
      else
      {
        localObject = getString(2131690706);
      }
      if (this.jdField_r_of_type_Boolean)
      {
        localTextView.setText("  ");
        return;
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  public void m_(int paramInt)
  {
    this.b = getResources().getDisplayMetrics().density;
    requestWindowFeature(1);
    super.setContentView(paramInt);
    a(getIntent());
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setContentView(int paramInt)
  {
    Object localObject1 = getIntent();
    int m = 1;
    boolean bool;
    if (localObject1 != null) {
      bool = ((Intent)localObject1).getBooleanExtra("showTitleBar", true);
    } else {
      bool = true;
    }
    if (!this.v)
    {
      if (bool) {
        requestWindowFeature(7);
      }
      super.setContentView(paramInt);
      if (bool) {
        getWindow().setFeatureInt(7, 2131558946);
      }
    }
    else if (bool)
    {
      Object localObject3 = LayoutInflater.from(this);
      localObject1 = ((LayoutInflater)localObject3).inflate(2131558948, null);
      try
      {
        localObject3 = ((LayoutInflater)localObject3).inflate(paramInt, (ViewGroup)localObject1, false);
        this.e = ((RelativeLayout)((View)localObject1).findViewById(2131378893));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.e.setFitsSystemWindows(true);
          this.e.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131376636);
        this.e.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        this.mContentView = ((View)localObject3);
        super.setContentView(this.e);
        m = 0;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
      }
      catch (InflateException localInflateException)
      {
        localInflateException.printStackTrace();
      }
      if (m != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("layout with merge ,use framelayout to immersive");
          ((StringBuilder)localObject2).append(getComponentName());
          QLog.e("IphoneTitleBarActivity", 2, ((StringBuilder)localObject2).toString());
        }
        super.setContentView(paramInt);
        getWindow().setFeatureInt(7, 2131558946);
        Object localObject2 = this.jdField_r_of_type_AndroidViewView;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        this.b = getResources().getDisplayMetrics().density;
        a(getIntent());
      }
    }
    else
    {
      super.setContentView(paramInt);
    }
    this.b = getResources().getDisplayMetrics().density;
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
    TextView localTextView = this.i;
    if ((localTextView != null) && ((localTextView instanceof TextView)))
    {
      localTextView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */