package cooperation.qqfav.widget;

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
import aobw;
import aocf;
import bamp;
import bhtb;
import bivc;
import bivs;
import biwp;
import biwu;
import biwv;
import biww;
import biwx;
import biwy;
import biwz;
import bixa;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class LocationDetailActivity
  extends PoiMapActivity
{
  private aobw jdField_a_of_type_Aobw;
  public biwp a;
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
    if (bhtb.e()) {
      this.f.setAlpha(0.9F);
    }
    this.f.setText(new bamp(this.u, 3, 22));
  }
  
  private void C()
  {
    this.jdField_a_of_type_Aobw = new aobw(this, true, false, true, true, 0);
    this.jdField_a_of_type_Aobw.a(a(false));
    this.jdField_a_of_type_Aobw.a(this);
    this.jdField_a_of_type_Aobw.a(new biwy(this));
    this.jdField_a_of_type_Aobw.a(new biwz(this));
    boolean bool = c();
    if (!bool) {
      this.jdField_a_of_type_Aobw.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Aobw.h();
    }
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_Aobw != null) && (this.jdField_a_of_type_Aobw.c())) {
      this.jdField_a_of_type_Aobw.f();
    }
  }
  
  public aocf a(boolean paramBoolean)
  {
    return new biwu(this, Long.valueOf(this.b));
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
      bivc.a(this, (String)localObject, localIntent, i);
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
    if ((this.jdField_a_of_type_Aobw != null) && (!this.jdField_a_of_type_Aobw.c()))
    {
      if (this.jdField_a_of_type_Aobw.b())
      {
        this.jdField_a_of_type_Aobw.e();
        return true;
      }
      this.jdField_a_of_type_Aobw.i();
      return false;
    }
    this.v = false;
    return false;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Aobw != null) {
      return this.jdField_a_of_type_Aobw.c();
    }
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Aobw != null) && (this.b != -1L) && (this.b != 0L)) {
      this.jdField_a_of_type_Aobw.q();
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
    paramBundle = super.findViewById(2131376222);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if (!super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f1 = super.getResources().getDisplayMetrics().density;
      this.f = new TextView(paramBundle.getContext());
      this.f.setId(2131371246);
      this.f.setBackgroundResource(2130839214);
      this.f.setMaxLines(3);
      int i = (int)(15.0F * f1);
      this.f.setPadding(i, i, i, i);
      this.f.setTextColor(super.getResources().getColor(2131166903));
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
    if (this.jdField_a_of_type_Aobw != null) {
      this.jdField_a_of_type_Aobw.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aobw != null) {
      this.jdField_a_of_type_Aobw.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aobw != null) {
      this.jdField_a_of_type_Aobw.a();
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
    TextView localTextView1 = (TextView)findViewById(2131368624);
    localTextView1.setText(2131692447);
    localTextView1.setOnClickListener(new biwv(this));
    ((TextView)super.findViewById(2131368670)).setText(2131694108);
    TextView localTextView2 = (TextView)super.findViewById(2131368655);
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
        this.jdField_a_of_type_Biwp = new biww(this, this, new bixa(this), i, 7, null);
        localTextView1.setText(localBundle.getString("leftViewText"));
        localTextView2.setVisibility(8);
        this.d = ((ImageView)super.findViewById(2131368638));
        this.d.setVisibility(0);
        this.d.setImageResource(2130840102);
        this.d.setContentDescription(super.getString(2131694478));
        this.d.setOnClickListener(this.jdField_a_of_type_Biwp);
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131368642));
        if (bivs.a()) {
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
        localTextView1.setText(2131690382);
        localTextView2.setText(2131694802);
        localTextView2.setOnClickListener(new biwx(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */