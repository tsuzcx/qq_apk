package cooperation.qqfav.widget;

import ampn;
import ampo;
import ampp;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.text.QQText;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;

public class LocationDetailActivity
  extends PoiMapActivity
{
  private FadeIconImageView a;
  public long b = -1L;
  public ImageView d;
  public TextView f;
  public String r;
  public String s;
  public String t;
  public String u;
  private boolean v;
  
  @TargetApi(11)
  private void A()
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
    if (VersionUtils.e()) {
      this.f.setAlpha(0.9F);
    }
    this.f.setText(new QQText(this.u, 3, 22));
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
      QfavHelper.a(this, (String)localObject, localIntent, i);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        A();
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
    paramBundle = super.findViewById(2131365657);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if (!super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f1 = super.getResources().getDisplayMetrics().density;
      this.f = new TextView(paramBundle.getContext());
      this.f.setId(2131362134);
      this.f.setBackgroundResource(2130838585);
      this.f.setMaxLines(3);
      int i = (int)(15.0F * f1);
      this.f.setPadding(i, i, i, i);
      this.f.setTextColor(super.getResources().getColor(2131494214));
      this.f.setTextSize(14.0F);
      this.f.setIncludeFontPadding(false);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = ((int)(f1 * 50.0F) + ImmersiveUtils.a(this));
      localLayoutParams.gravity = 48;
      paramBundle.addView(this.f, localLayoutParams);
    }
    this.u = super.getIntent().getStringExtra("note");
    this.o = true;
    if (this.h != null) {
      this.h.setVisibility(8);
    }
    A();
  }
  
  public void onStart()
  {
    super.overridePendingTransition(0, 0);
    super.onStart();
  }
  
  protected void t()
  {
    Bundle localBundle = super.getIntent().getExtras();
    this.t = localBundle.getString("loc");
    this.r = localBundle.getString("lat");
    this.s = localBundle.getString("lon");
    this.b = localBundle.getLong("favId");
    TextView localTextView1 = (TextView)findViewById(2131363245);
    localTextView1.setText(2131431566);
    localTextView1.setOnClickListener(new ampn(this));
    ((TextView)super.findViewById(2131363381)).setText(2131431619);
    TextView localTextView2 = (TextView)super.findViewById(2131363428);
    if (!localBundle.getBoolean("forNewFavorite", false))
    {
      ampo localampo = new ampo(this, this, new LocationDetailActivity.LocationActions(this), 33, 7, null);
      localTextView1.setText(localBundle.getString("leftViewText"));
      localTextView2.setVisibility(8);
      this.d = ((ImageView)super.findViewById(2131363474));
      this.d.setVisibility(0);
      this.d.setImageResource(2130839147);
      this.d.setContentDescription(super.getString(2131433937));
      this.d.setOnClickListener(localampo);
      this.a = ((FadeIconImageView)findViewById(2131364029));
      if (!QfavUtil.a()) {
        if (this.a != null)
        {
          this.a.setVisibility(0);
          this.v = true;
        }
      }
    }
    for (;;)
    {
      localTextView2.setTag(localTextView2.getText());
      return;
      if (this.a != null)
      {
        this.a.setVisibility(8);
        continue;
        localTextView1.setText(2131432414);
        localTextView2.setText(2131434754);
        localTextView2.setOnClickListener(new ampp(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */