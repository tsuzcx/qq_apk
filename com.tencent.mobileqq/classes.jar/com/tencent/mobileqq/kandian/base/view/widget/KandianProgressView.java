package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.image.ImageUtils;
import java.io.File;

public class KandianProgressView
  extends LinearLayout
{
  ProgressBar a;
  ImageView b;
  ImageView c;
  ImageView d;
  TextView e;
  TextView f;
  TextView g;
  TextView h;
  TextView i;
  String j;
  KandianProgressView.ClickCallBack k;
  String l = "";
  public Bundle m;
  View.OnClickListener n = new KandianProgressView.1(this);
  
  public KandianProgressView(Context paramContext, Bundle paramBundle, String paramString1, String paramString2, KandianProgressView.ClickCallBack paramClickCallBack)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131626434, this);
    this.j = paramString1;
    this.k = paramClickCallBack;
    this.l = paramString2;
    this.m = paramBundle;
    b();
  }
  
  private void b()
  {
    this.e = ((TextView)findViewById(2131432777));
    this.f = ((TextView)findViewById(2131445229));
    this.g = ((TextView)findViewById(2131444741));
    this.h = ((TextView)findViewById(2131431723));
    this.i = ((TextView)findViewById(2131439427));
    this.a = ((ProgressBar)findViewById(2131440737));
    this.b = ((ImageView)findViewById(2131431462));
    this.c = ((ImageView)findViewById(2131444734));
    this.d = ((ImageView)findViewById(2131431708));
    this.c.setOnClickListener(this.n);
    this.g.setOnClickListener(this.n);
    this.d.setOnClickListener(this.n);
    this.h.setOnClickListener(this.n);
    setCoverImg();
  }
  
  private void setFailView(int paramInt)
  {
    this.e.setVisibility(paramInt);
    this.c.setVisibility(paramInt);
    this.g.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
    this.h.setVisibility(paramInt);
  }
  
  private void setProgressRunning(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setProgressView(0);
      setFailView(8);
      return;
    }
    setProgressView(8);
    setFailView(0);
  }
  
  private void setProgressView(int paramInt)
  {
    this.a.setVisibility(paramInt);
    this.i.setVisibility(paramInt);
  }
  
  public void a()
  {
    setProgressRunning(false);
  }
  
  public void a(int paramInt)
  {
    this.a.setProgress(paramInt);
    TextView localTextView = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131903887));
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
    setProgressRunning(true);
  }
  
  public void setCoverImg()
  {
    setImage(this.l);
  }
  
  protected void setImage(String paramString)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      localObject = new BitmapFactory.Options();
      int i2 = 1;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int i1 = AIOUtils.b(100.0F, getResources());
      int i3 = AIOUtils.b(100.0F, getResources());
      float f1 = ((BitmapFactory.Options)localObject).outWidth / i1;
      float f2 = ((BitmapFactory.Options)localObject).outHeight / i3;
      i1 = i2;
      if (f1 >= 1.0F)
      {
        i1 = i2;
        if (f2 >= 1.0F) {
          i1 = (int)Math.floor(Math.min(f1, f2));
        }
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = i1;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      paramString = ImageUtils.a(ImageUtils.a(paramString), (Bitmap)localObject);
      this.b.setImageBitmap(paramString);
      this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      label172:
      break label172;
    }
    this.b.setImageDrawable(new ColorDrawable(-16777216));
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return;
    this.b.setImageDrawable(new ColorDrawable(-16777216));
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void setViewInformation(Bundle paramBundle, String paramString1, String paramString2)
  {
    this.j = paramString1;
    this.l = paramString2;
    this.m = paramBundle;
    setCoverImg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.KandianProgressView
 * JD-Core Version:    0.7.0.1
 */