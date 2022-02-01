package cooperation.plugin;

import Override;
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
import blgg;
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
  protected View.OnClickListener c = new blgg(this);
  public RelativeLayout e;
  public ImageView f;
  protected TextView h;
  public TextView i;
  public TextView j;
  protected TextView k;
  protected TextView l;
  public View r;
  protected boolean r;
  
  public PluginIphoneTitleBarActivity()
  {
    this.jdField_r_of_type_Boolean = true;
  }
  
  @TargetApi(11)
  public static void f(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(1, null);
  }
  
  protected View a()
  {
    this.j = ((TextView)findViewById(2131368979));
    this.f = ((ImageView)findViewById(2131368961));
    this.l = ((TextView)findViewById(2131379492));
    f(this.j);
    f(this.f);
    return this.j;
  }
  
  protected String a()
  {
    if ((this.i == null) || (this.i.getText() == null) || (this.i.getText().length() == 0)) {
      return getString(2131690563);
    }
    return this.i.getText().toString();
  }
  
  protected void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    a(getString(paramInt), paramOnClickListener);
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130850093));
    if (this.h == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376599));
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
      getWindow().setFeatureInt(7, 2131558977);
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
  
  public boolean a()
  {
    finish();
    return false;
  }
  
  protected View b()
  {
    this.h = ((TextView)findViewById(2131368947));
    if (this.h != null)
    {
      this.h.setOnClickListener(this.c);
      f(this.h);
    }
    return this.h;
  }
  
  protected void b(Intent paramIntent)
  {
    TextView localTextView;
    if ((this.h != null) && ((this.h instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localTextView = this.h;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131690563);
      }
      if (this.jdField_r_of_type_Boolean) {
        localTextView.setText("  ");
      }
    }
    else
    {
      return;
    }
    localTextView.setText(paramIntent);
  }
  
  protected View c()
  {
    this.i = ((TextView)findViewById(2131368994));
    return this.i;
  }
  
  protected void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.h.setVisibility(8);
    this.h = ((TextView)findViewById(2131368949));
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  protected void e(View paramView)
  {
    super.setContentView(paramView);
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.i.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.i.getCompoundDrawablePadding();
      this.i.setCompoundDrawablePadding(10);
      this.i.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.i.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.i.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
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
    TextView localTextView;
    String str1;
    if ((this.h != null) && ((this.h instanceof TextView)))
    {
      String str2 = getString(paramInt);
      localTextView = this.h;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = getString(2131690563);
      }
      if (this.jdField_r_of_type_Boolean) {
        localTextView.setText("  ");
      }
    }
    else
    {
      return;
    }
    localTextView.setText(str1);
  }
  
  public void l_(int paramInt)
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
    int m = 1;
    Object localObject1 = getIntent();
    if (localObject1 != null) {}
    for (boolean bool = ((Intent)localObject1).getBooleanExtra("showTitleBar", true);; bool = true)
    {
      if (!this.u)
      {
        if (bool) {
          requestWindowFeature(7);
        }
        super.setContentView(paramInt);
        if (bool) {
          getWindow().setFeatureInt(7, 2131558977);
        }
      }
      for (;;)
      {
        this.b = getResources().getDisplayMetrics().density;
        if (bool) {
          a(getIntent());
        }
        return;
        if (bool)
        {
          Object localObject2 = LayoutInflater.from(this);
          localObject1 = ((LayoutInflater)localObject2).inflate(2131558979, null);
          try
          {
            localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, (ViewGroup)localObject1, false);
            this.e = ((RelativeLayout)((View)localObject1).findViewById(2131378887));
            if (ImmersiveUtils.isSupporImmersive() == 1)
            {
              this.e.setFitsSystemWindows(true);
              this.e.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
            }
            localObject1 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131376599);
            this.e.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
            this.mContentView = ((View)localObject2);
            super.setContentView(this.e);
            m = 0;
          }
          catch (InflateException localInflateException)
          {
            for (;;)
            {
              localInflateException.printStackTrace();
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            for (;;)
            {
              localRuntimeException.printStackTrace();
            }
          }
          if (m == 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.e("IphoneTitleBarActivity", 2, "layout with merge ,use framelayout to immersive" + getComponentName());
          }
          super.setContentView(paramInt);
          getWindow().setFeatureInt(7, 2131558977);
          if (this.jdField_r_of_type_AndroidViewView != null) {
            this.jdField_r_of_type_AndroidViewView.setVisibility(0);
          }
          this.b = getResources().getDisplayMetrics().density;
          a(getIntent());
          return;
        }
        super.setContentView(paramInt);
      }
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
    if ((this.i != null) && ((this.i instanceof TextView)))
    {
      this.i.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.plugin.PluginIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */