package cooperation.qqfav.widget;

import alrv;
import alsd;
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
import axkd;
import befo;
import bfhn;
import bfid;
import bfja;
import bfjf;
import bfjg;
import bfjh;
import bfji;
import bfjj;
import bfjk;
import bfjl;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class LocationDetailActivity
  extends PoiMapActivity
{
  private alrv jdField_a_of_type_Alrv;
  public bfja a;
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
    if (befo.e()) {
      this.f.setAlpha(0.9F);
    }
    this.f.setText(new axkd(this.u, 3, 22));
  }
  
  private void C()
  {
    this.jdField_a_of_type_Alrv = new alrv(this, true, false, true, true, 0);
    this.jdField_a_of_type_Alrv.a(a());
    this.jdField_a_of_type_Alrv.a(this);
    this.jdField_a_of_type_Alrv.a(new bfjj(this));
    this.jdField_a_of_type_Alrv.a(new bfjk(this));
    boolean bool = c();
    if (!bool) {
      this.jdField_a_of_type_Alrv.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Alrv.h();
    }
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_Alrv != null) && (this.jdField_a_of_type_Alrv.c())) {
      this.jdField_a_of_type_Alrv.f();
    }
  }
  
  public alsd a()
  {
    return new bfjf(this, Long.valueOf(this.b));
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
      bfhn.a(this, (String)localObject, localIntent, i);
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
    if ((this.jdField_a_of_type_Alrv != null) && (!this.jdField_a_of_type_Alrv.c()))
    {
      if (this.jdField_a_of_type_Alrv.b())
      {
        this.jdField_a_of_type_Alrv.e();
        return true;
      }
      this.jdField_a_of_type_Alrv.i();
      return false;
    }
    this.v = false;
    return false;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Alrv != null) {
      return this.jdField_a_of_type_Alrv.c();
    }
    return false;
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Alrv != null)
    {
      this.jdField_a_of_type_Alrv.d();
      return;
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
    super.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.findViewById(2131309912);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if (!super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f1 = super.getResources().getDisplayMetrics().density;
      this.f = new TextView(paramBundle.getContext());
      this.f.setId(2131305242);
      this.f.setBackgroundResource(2130839101);
      this.f.setMaxLines(3);
      int i = (int)(15.0F * f1);
      this.f.setPadding(i, i, i, i);
      this.f.setTextColor(super.getResources().getColor(2131101260));
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
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.a();
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
    TextView localTextView1 = (TextView)findViewById(2131302804);
    localTextView1.setText(2131626768);
    localTextView1.setOnClickListener(new bfjg(this));
    ((TextView)super.findViewById(2131302847)).setText(2131628348);
    TextView localTextView2 = (TextView)super.findViewById(2131302832);
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
        this.jdField_a_of_type_Bfja = new bfjh(this, this, new bfjl(this), i, 7, null);
        localTextView1.setText(localBundle.getString("leftViewText"));
        localTextView2.setVisibility(8);
        this.d = ((ImageView)super.findViewById(2131302816));
        this.d.setVisibility(0);
        this.d.setImageResource(2130839704);
        this.d.setContentDescription(super.getString(2131628666));
        this.d.setOnClickListener(this.jdField_a_of_type_Bfja);
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131302820));
        if (bfid.a()) {
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
        localTextView1.setText(2131624770);
        localTextView2.setText(2131628979);
        localTextView2.setOnClickListener(new bfji(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */