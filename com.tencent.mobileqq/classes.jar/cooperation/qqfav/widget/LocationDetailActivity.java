package cooperation.qqfav.widget;

import amgn;
import amgv;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aykk;
import bfnz;
import bgpw;
import bgqm;
import bgrj;
import bgro;
import bgrp;
import bgrq;
import bgrr;
import bgrs;
import bgrt;
import bgru;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class LocationDetailActivity
  extends PoiMapActivity
{
  private amgn jdField_a_of_type_Amgn;
  public bgrj a;
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
    if (bfnz.e()) {
      this.f.setAlpha(0.9F);
    }
    this.f.setText(new aykk(this.u, 3, 22));
  }
  
  private void C()
  {
    this.jdField_a_of_type_Amgn = new amgn(this, true, false, true, true, 0);
    this.jdField_a_of_type_Amgn.a(a());
    this.jdField_a_of_type_Amgn.a(this);
    this.jdField_a_of_type_Amgn.a(new bgrs(this));
    this.jdField_a_of_type_Amgn.a(new bgrt(this));
    boolean bool = c();
    if (!bool) {
      this.jdField_a_of_type_Amgn.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Amgn.h();
    }
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_Amgn != null) && (this.jdField_a_of_type_Amgn.c())) {
      this.jdField_a_of_type_Amgn.f();
    }
  }
  
  public amgv a()
  {
    return new bgro(this, Long.valueOf(this.b));
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
      bgpw.a(this, (String)localObject, localIntent, i);
      return;
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    this.v = true;
    if ((this.jdField_a_of_type_Amgn != null) && (!this.jdField_a_of_type_Amgn.c()))
    {
      if (this.jdField_a_of_type_Amgn.b())
      {
        this.jdField_a_of_type_Amgn.e();
        return true;
      }
      this.jdField_a_of_type_Amgn.i();
      return false;
    }
    this.v = false;
    return false;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Amgn != null) {
      return this.jdField_a_of_type_Amgn.c();
    }
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Amgn != null) && (this.b != -1L) && (this.b != 0L)) {
      this.jdField_a_of_type_Amgn.p();
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.findViewById(2131375675);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if (!super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f1 = super.getResources().getDisplayMetrics().density;
      this.f = new TextView(paramBundle.getContext());
      this.f.setId(2131370916);
      this.f.setBackgroundResource(2130839129);
      this.f.setMaxLines(3);
      int i = (int)(15.0F * f1);
      this.f.setPadding(i, i, i, i);
      this.f.setTextColor(super.getResources().getColor(2131166854));
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
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
      C();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Amgn != null) {
      this.jdField_a_of_type_Amgn.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Amgn != null) {
      this.jdField_a_of_type_Amgn.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Amgn != null) {
      this.jdField_a_of_type_Amgn.a();
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
    TextView localTextView1 = (TextView)findViewById(2131368429);
    localTextView1.setText(2131692370);
    localTextView1.setOnClickListener(new bgrp(this));
    ((TextView)super.findViewById(2131368472)).setText(2131693990);
    TextView localTextView2 = (TextView)super.findViewById(2131368457);
    int i;
    if (!localBundle.getBoolean("forNewFavorite", false))
    {
      i = 33;
      if (c())
      {
        if (e())
        {
          i = 256;
          i = 0x21 | i;
        }
      }
      else
      {
        this.jdField_a_of_type_Bgrj = new bgrq(this, this, new bgru(this), i, 7, null);
        localTextView1.setText(localBundle.getString("leftViewText"));
        localTextView2.setVisibility(8);
        this.d = ((ImageView)super.findViewById(2131368441));
        this.d.setVisibility(0);
        this.d.setImageResource(2130839753);
        this.d.setContentDescription(super.getString(2131694319));
        this.d.setOnClickListener(this.jdField_a_of_type_Bgrj);
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131368445));
        if (bgqm.a()) {
          break label304;
        }
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
      i = 128;
      break;
      label304:
      if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
        continue;
        localTextView1.setText(2131690331);
        localTextView2.setText(2131694644);
        localTextView2.setOnClickListener(new bgrr(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */