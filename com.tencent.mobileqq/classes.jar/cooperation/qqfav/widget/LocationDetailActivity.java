package cooperation.qqfav.widget;

import Override;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aqnr;
import aqoa;
import aupt;
import bmaf;
import bman;
import bmar;
import bmbt;
import bmbx;
import bmby;
import bmbz;
import bmca;
import bmcb;
import bmcc;
import bmcd;
import bmce;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class LocationDetailActivity
  extends PoiMapActivity
{
  private aqnr jdField_a_of_type_Aqnr;
  public bmbt a;
  private FadeIconImageView jdField_a_of_type_ComTencentWidgetFadeIconImageView;
  public long b = -1L;
  public ImageView d;
  public TextView f;
  public String r;
  public String s;
  public String t;
  public String u;
  public boolean v;
  private boolean w;
  private boolean x;
  
  @TargetApi(11)
  private void B()
  {
    if (this.f == null) {
      return;
    }
    if (TextUtils.isEmpty(this.u))
    {
      this.f.setVisibility(8);
      return;
    }
    this.f.setVisibility(0);
    if (VersionUtils.isHoneycomb()) {
      this.f.setAlpha(0.9F);
    }
    this.f.setText(new QQText(this.u, 3, 22));
  }
  
  private void C()
  {
    bmaf.a(this, "", this.b, 0L);
  }
  
  private void D()
  {
    setResult(-1, c(this));
    finish();
  }
  
  private void E()
  {
    this.jdField_a_of_type_Aqnr = new aqnr(this, true, false, true, true, 0);
    this.jdField_a_of_type_Aqnr.a(a(false));
    this.jdField_a_of_type_Aqnr.a(this);
    this.jdField_a_of_type_Aqnr.a(new bmcc(this));
    this.jdField_a_of_type_Aqnr.a(new bmcd(this));
    boolean bool = c();
    if (!bool) {
      this.jdField_a_of_type_Aqnr.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Aqnr.h();
    }
  }
  
  private void F()
  {
    bman.a(null, "User_Modify", 7, 0, getIntent().getIntExtra("category", 1));
    bmaf.b(this, "", this.b);
    super.finish();
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_Aqnr != null) && (this.jdField_a_of_type_Aqnr.c())) {}
    for (int i = 256;; i = 128) {
      return i | 0x50;
    }
  }
  
  private Intent b()
  {
    if ((this.r != null) && (this.s != null))
    {
      Intent localIntent = a();
      localIntent.putExtra("forward_type", -2).putExtra("forward_latitude", localIntent.getStringExtra("latitude")).putExtra("forward_longitude", localIntent.getStringExtra("longitude")).putExtra("forward_location", this.m).putExtra("forward_location_string", this.m).putExtra("forward_thumb", AppConstants.PATH_LOCATION_IMG + this.r + "_" + this.s + ".png").putExtra("isFromFavorites", true).putExtra("title", this.l).putExtra("summary", this.m);
      return localIntent;
    }
    return null;
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_Aqnr != null) && (this.jdField_a_of_type_Aqnr.c())) {
      this.jdField_a_of_type_Aqnr.f();
    }
  }
  
  public aqoa a(boolean paramBoolean)
  {
    return new bmbx(this, Long.valueOf(this.b));
  }
  
  public void a(Bundle paramBundle)
  {
    Intent localIntent = b();
    if (localIntent != null)
    {
      localIntent.putExtras(paramBundle);
      aupt.a(getActivity(), localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_shoucang");
      return;
    }
    QQToast.a(this, 2131692147, 1, 2000).b(5);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = a(this);
    Intent localIntent = new Intent(b(this));
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("modify", paramBoolean);
    localIntent.putExtra("favId", this.b);
    localIntent.putExtra("note", this.u);
    localIntent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = localIntent.getStringExtra("pluginsdk_selfuin");
    if (paramBoolean) {}
    for (int i = 13322;; i = 13321)
    {
      bmaf.a(this, (String)localObject, localIntent, i);
      return;
    }
  }
  
  protected boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    this.v = true;
    if ((this.jdField_a_of_type_Aqnr != null) && (!this.jdField_a_of_type_Aqnr.c()))
    {
      if (this.jdField_a_of_type_Aqnr.b())
      {
        this.jdField_a_of_type_Aqnr.e();
        return true;
      }
      this.jdField_a_of_type_Aqnr.i();
      return false;
    }
    this.v = false;
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Aqnr != null) && (this.b != -1L) && (this.b != 0L)) {
      this.jdField_a_of_type_Aqnr.p();
    }
    super.finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if ((paramInt1 != 103) || (paramIntent == null)) {
        break label51;
      }
    }
    for (;;)
    {
      if ((this.d != null) && (13322 != paramInt1) && (103 != paramInt1)) {
        this.d.setOnClickListener(null);
      }
      return;
      label51:
      if (13321 == paramInt1)
      {
        super.finish();
      }
      else if ((13322 == paramInt1) && (paramIntent != null))
      {
        this.u = paramIntent.getStringExtra("note");
        B();
      }
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(0, new Intent());
    if (this.d != null) {
      this.d.setOnClickListener(null);
    }
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.findViewById(2131377155);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if (!this.x) {}
    for (;;)
    {
      this.u = super.getIntent().getStringExtra("note");
      this.o = true;
      if (this.h != null) {
        this.h.setVisibility(8);
      }
      B();
      if (this.b != -1L)
      {
        getIntent().putExtra("big_brother_source_key", "biz_src_jc_shoucang");
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        E();
      }
      return;
      if (!super.getIntent().getBooleanExtra("forNewFavorite", false))
      {
        paramBundle = (FrameLayout)super.findViewById(16908290);
        float f1 = super.getResources().getDisplayMetrics().density;
        this.f = new TextView(paramBundle.getContext());
        this.f.setId(2131372074);
        this.f.setBackgroundResource(2130839455);
        this.f.setMaxLines(3);
        int i = (int)(15.0F * f1);
        this.f.setPadding(i, i, i, i);
        this.f.setTextColor(super.getResources().getColor(2131167026));
        this.f.setTextSize(14.0F);
        this.f.setIncludeFontPadding(false);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
        localLayoutParams.topMargin = ((int)(f1 * 50.0F) + ImmersiveUtils.getStatusBarHeight(this));
        localLayoutParams.gravity = 48;
        paramBundle.addView(this.f, localLayoutParams);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aqnr != null) {
      this.jdField_a_of_type_Aqnr.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aqnr != null) {
      this.jdField_a_of_type_Aqnr.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aqnr != null) {
      this.jdField_a_of_type_Aqnr.a();
    }
  }
  
  public void onStart()
  {
    super.overridePendingTransition(0, 0);
    super.onStart();
  }
  
  public void t()
  {
    Bundle localBundle = super.getIntent().getExtras();
    this.t = localBundle.getString("loc");
    this.r = localBundle.getString("lat");
    this.s = localBundle.getString("lon");
    this.b = localBundle.getLong("favId");
    TextView localTextView1 = (TextView)findViewById(2131369231);
    localTextView1.setText(2131692175);
    localTextView1.setOnClickListener(new bmby(this));
    ((TextView)super.findViewById(2131369278)).setText(2131693687);
    TextView localTextView2 = (TextView)super.findViewById(2131369262);
    this.x = super.getIntent().getBooleanExtra("forNoteNewFavorite", false);
    if ((!this.x) && (!localBundle.getBoolean("forNewFavorite", false)))
    {
      this.jdField_a_of_type_Bmbt = new bmbz(this, this, new bmce(this), a(), 7, null);
      localTextView1.setText(localBundle.getString("leftViewText"));
      localTextView2.setVisibility(8);
      this.d = ((ImageView)super.findViewById(2131369245));
      this.d.setVisibility(0);
      this.d.setImageResource(2130840365);
      this.d.setContentDescription(super.getString(2131694053));
      this.d.setOnClickListener(this.jdField_a_of_type_Bmbt);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131369249));
      if (!bmar.a()) {
        if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
          this.w = true;
        }
      }
    }
    for (;;)
    {
      localTextView2.setTag(localTextView2.getText());
      return;
      if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
        continue;
        if (this.x)
        {
          localTextView2.setText(2131694399);
          localTextView2.setOnClickListener(new bmca(this));
        }
        else
        {
          localTextView1.setText(2131690499);
          localTextView2.setText(2131694288);
          localTextView2.setOnClickListener(new bmcb(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */