package com.tencent.mobileqq.microapp.out.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import baaf;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.R.dimen;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class PhotoPreviewActivity
  extends BaseActivity
{
  boolean a = true;
  ArrayList b;
  int c = 0;
  String d;
  BubblePopupWindow e;
  PhotoPreviewActivity.a f;
  int g;
  View h;
  ProGallery i;
  TextView j;
  
  public String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("//")) {
        return "file:/" + paramString;
      }
      str = paramString;
    } while (!paramString.startsWith("/"));
    return "file://" + paramString;
  }
  
  void a()
  {
    Intent localIntent = getIntent();
    this.d = localIntent.getStringExtra("back_btn_text");
    this.b = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.b != null) {}
    for (int k = this.b.size();; k = 0)
    {
      this.c = k;
      if (this.c >= 1) {
        break;
      }
      finish();
      return;
    }
    this.g = localIntent.getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    localIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
  }
  
  void b()
  {
    this.h = findViewById(R.id.bd);
    this.j = ((TextView)findViewById(R.id.f));
    this.j.setOnClickListener(new b(this));
    if (this.a) {
      this.h.setVisibility(0);
    }
    findViewById(R.id.ax);
    this.i = ((ProGallery)findViewById(R.id.w));
    this.f = new PhotoPreviewActivity.a(this);
    this.i.setAdapter(this.f);
    this.i.setOnNoBlankListener(this.f);
    this.i.setSpacing(getResources().getDimensionPixelSize(R.dimen.a));
    this.i.setSelection(this.g);
    this.i.setOnItemClickListener(new c(this));
    if (!TextUtils.isEmpty(this.d))
    {
      this.j.setTextColor(-1);
      this.j.setText(this.d);
    }
  }
  
  void c()
  {
    this.a = false;
    this.h.setVisibility(4);
    if (this.e != null) {
      this.e.b();
    }
  }
  
  void d()
  {
    this.a = true;
    this.h.setVisibility(0);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    if (this.i.a(false)) {
      return;
    }
    e();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(R.layout.j);
    int k = getResources().getDisplayMetrics().widthPixels;
    k = getResources().getDisplayMetrics().heightPixels;
    a();
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.e != null) {
      this.e.b();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    a();
    b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.a) && (this.h != null)) {
      this.h.setVisibility(0);
    }
  }
  
  void e()
  {
    baaf.a(this, true, false);
    super.finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */