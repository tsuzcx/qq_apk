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
import anhk;
import aqcb;
import aqck;
import aufz;
import bdnt;
import bljn;
import bljz;
import bllb;
import bllf;
import bllg;
import bllh;
import blli;
import bllj;
import bllk;
import blll;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class LocationDetailActivity
  extends PoiMapActivity
{
  private aqcb jdField_a_of_type_Aqcb;
  public bllb a;
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
    this.f.setText(new bdnt(this.u, 3, 22));
  }
  
  private void C()
  {
    bljn.a(this, "", this.b, 0L);
  }
  
  private void D()
  {
    this.jdField_a_of_type_Aqcb = new aqcb(this, true, false, true, true, 0);
    this.jdField_a_of_type_Aqcb.a(a(false));
    this.jdField_a_of_type_Aqcb.a(this);
    this.jdField_a_of_type_Aqcb.a(new bllj(this));
    this.jdField_a_of_type_Aqcb.a(new bllk(this));
    boolean bool = c();
    if (!bool) {
      this.jdField_a_of_type_Aqcb.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Aqcb.h();
    }
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_Aqcb != null) && (this.jdField_a_of_type_Aqcb.c())) {}
    for (int i = 256;; i = 128) {
      return i | 0x50;
    }
  }
  
  private Intent b()
  {
    if ((this.r != null) && (this.s != null))
    {
      Intent localIntent = a();
      localIntent.putExtra("forward_type", -2).putExtra("forward_latitude", localIntent.getStringExtra("latitude")).putExtra("forward_longitude", localIntent.getStringExtra("longitude")).putExtra("forward_location", this.m).putExtra("forward_location_string", this.m).putExtra("forward_thumb", anhk.cf + this.r + "_" + this.s + ".png").putExtra("isFromFavorites", true).putExtra("title", this.l).putExtra("summary", this.m);
      return localIntent;
    }
    return null;
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_Aqcb != null) && (this.jdField_a_of_type_Aqcb.c())) {
      this.jdField_a_of_type_Aqcb.f();
    }
  }
  
  public aqck a(boolean paramBoolean)
  {
    return new bllf(this, Long.valueOf(this.b));
  }
  
  public void a(Bundle paramBundle)
  {
    Intent localIntent = b();
    if (localIntent != null)
    {
      localIntent.putExtras(paramBundle);
      aufz.a(getActivity(), localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_shoucang");
      return;
    }
    QQToast.a(this, 2131692007, 1, 2000).b(5);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = b(this);
    Intent localIntent = new Intent(c(this));
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("modify", paramBoolean);
    localIntent.putExtra("favId", this.b);
    localIntent.putExtra("note", this.u);
    localIntent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = localIntent.getStringExtra("pluginsdk_selfuin");
    if (paramBoolean) {}
    for (int i = 13322;; i = 13321)
    {
      bljn.a(this, (String)localObject, localIntent, i);
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
    if ((this.jdField_a_of_type_Aqcb != null) && (!this.jdField_a_of_type_Aqcb.c()))
    {
      if (this.jdField_a_of_type_Aqcb.b())
      {
        this.jdField_a_of_type_Aqcb.e();
        return true;
      }
      this.jdField_a_of_type_Aqcb.i();
      return false;
    }
    this.v = false;
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Aqcb != null) && (this.b != -1L) && (this.b != 0L)) {
      this.jdField_a_of_type_Aqcb.p();
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
    paramBundle = super.findViewById(2131376992);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if (!super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f1 = super.getResources().getDisplayMetrics().density;
      this.f = new TextView(paramBundle.getContext());
      this.f.setId(2131371810);
      this.f.setBackgroundResource(2130839391);
      this.f.setMaxLines(3);
      int i = (int)(15.0F * f1);
      this.f.setPadding(i, i, i, i);
      this.f.setTextColor(super.getResources().getColor(2131166986));
      this.f.setTextSize(14.0F);
      this.f.setIncludeFontPadding(false);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = ((int)(f1 * 50.0F) + ImmersiveUtils.getStatusBarHeight(this));
      localLayoutParams.gravity = 48;
      paramBundle.addView(this.f, localLayoutParams);
    }
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
      D();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aqcb != null) {
      this.jdField_a_of_type_Aqcb.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aqcb != null) {
      this.jdField_a_of_type_Aqcb.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aqcb != null) {
      this.jdField_a_of_type_Aqcb.a();
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
    TextView localTextView1 = (TextView)findViewById(2131368947);
    localTextView1.setText(2131692032);
    localTextView1.setOnClickListener(new bllg(this));
    ((TextView)super.findViewById(2131368994)).setText(2131693399);
    TextView localTextView2 = (TextView)super.findViewById(2131368979);
    if (!localBundle.getBoolean("forNewFavorite", false))
    {
      this.jdField_a_of_type_Bllb = new bllh(this, this, new blll(this), a(), 7, null);
      localTextView1.setText(localBundle.getString("leftViewText"));
      localTextView2.setVisibility(8);
      this.d = ((ImageView)super.findViewById(2131368961));
      this.d.setVisibility(0);
      this.d.setImageResource(2130840281);
      this.d.setContentDescription(super.getString(2131693747));
      this.d.setOnClickListener(this.jdField_a_of_type_Bllb);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131368965));
      if (!bljz.a()) {
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
        localTextView1.setText(2131690389);
        localTextView2.setText(2131693974);
        localTextView2.setOnClickListener(new blli(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */