package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView.OnUpdateDrawingListener;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PersonalityLabelShareActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ShareHelper.OnUseResListener, TagCloudView.OnUpdateDrawingListener
{
  TagCloudView a;
  ImageView b;
  TextView c;
  View d;
  View e;
  View f;
  View g;
  Button h;
  Button i;
  Bitmap j;
  Bitmap k;
  Bitmap l;
  int m = 0;
  float n;
  boolean o = true;
  ShareHelper p;
  ProfilePersonalityLabelInfo q;
  Drawable r;
  Drawable s;
  TextPaint t = new TextPaint(7);
  boolean u = false;
  
  private void e()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new PersonalityLabelShareActivity.1(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      f();
      return;
    }
    f();
  }
  
  private void f()
  {
    this.o = false;
    ThreadManager.postImmediately(new PersonalityLabelShareActivity.2(this), null, true);
  }
  
  private void g()
  {
    ArrayList localArrayList = new ArrayList(this.q.getSize());
    if (this.r == null) {
      this.r = getResources().getDrawable(2131165733);
    }
    Object localObject1 = this.q.getLatestThumbLocalUrl();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    Object localObject3 = null;
    Object localObject2;
    if (!bool)
    {
      localObject1 = new File((String)localObject1);
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:///");
        localStringBuilder.append(((File)localObject1).getAbsolutePath());
        localObject1 = URLDrawable.getDrawable(new URL(localStringBuilder.toString()), this.r, this.r);
      }
      catch (Exception localException1)
      {
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          break label336;
        }
        QLog.i("PersonalityLabelDeleteActivity", 2, localException1.getMessage(), localException1);
        localObject1 = localObject3;
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          break label336;
        }
      }
      QLog.i("PersonalityLabelDeleteActivity", 2, localMalformedURLException2.getMessage(), localMalformedURLException2);
      localObject1 = localObject3;
    }
    else
    {
      Object localObject4 = this.q.getLatestThumbUrl();
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && ((((String)localObject4).startsWith("http")) || (((String)localObject4).startsWith("https"))))
      {
        localObject1 = this.r;
        localObject1 = URLDrawable.getDrawable((String)localObject4, (Drawable)localObject1, (Drawable)localObject1);
      }
      else
      {
        localObject1 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = new File((String)localObject4);
          try
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("file:///");
            ((StringBuilder)localObject4).append(((File)localObject1).getAbsolutePath());
            localObject1 = URLDrawable.getDrawable(new URL(((StringBuilder)localObject4).toString()), this.r, this.r);
          }
          catch (Exception localException2)
          {
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              QLog.i("PersonalityLabelDeleteActivity", 2, localException2.getMessage(), localException2);
              localObject1 = localObject3;
            }
          }
          catch (MalformedURLException localMalformedURLException1)
          {
            localMalformedURLException1.printStackTrace();
            localObject2 = localObject3;
          }
        }
      }
    }
    label336:
    TagUtil.a(localArrayList, this.q, this.n);
    this.a.setTags(localArrayList);
    this.a.setTagIcon(localObject2);
  }
  
  public Point a(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getDrawingRect(localRect);
    ((ViewGroup)paramView.getParent()).offsetDescendantRectToMyCoords(paramView, localRect);
    int i1 = localRect.top;
    return new Point(localRect.left, i1);
  }
  
  void a()
  {
    this.n = getResources().getDisplayMetrics().density;
    Object localObject1 = (BounceScrollView)findViewById(2131429717);
    ((BounceScrollView)localObject1).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject1).mScrollFlag = 1;
    this.a = ((TagCloudView)findViewById(2131446836));
    this.a.setOnUpdateDrawingListener(this);
    this.a.setMinHeight((int)(this.n * 150.0F));
    this.a.setThreshold((int)(this.n * 7.5F));
    this.d = findViewById(2131439800);
    this.e = findViewById(2131435773);
    this.f = findViewById(2131447193);
    this.g = findViewById(2131437736);
    this.d.setOnClickListener(this);
    this.b = ((ImageView)findViewById(2131442819));
    this.c = ((TextView)findViewById(2131447062));
    this.m = getResources().getDimensionPixelSize(2131299131);
    localObject1 = ContactUtils.a(this.app, this.app.getCurrentAccountUin());
    String str1 = HardCodeUtil.a(2131905765);
    String str2 = HardCodeUtil.a(2131905786);
    int i1 = getResources().getDisplayMetrics().widthPixels;
    int i2 = AIOUtils.b(20.0F, getResources());
    int i3 = AIOUtils.b(1.0F, getResources());
    int i4 = this.m;
    int i5 = AIOUtils.b(10.0F, getResources());
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(this.c.getTextSize());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(str2);
    localObject2 = ((StringBuilder)localObject2).toString();
    float f1 = i1 - i2 * 5 - i3 - i4 - i5;
    String str3 = (String)TextUtils.ellipsize((CharSequence)localObject2, localTextPaint, f1, TextUtils.TruncateAt.END);
    if (TextUtils.equals((CharSequence)localObject2, str3))
    {
      this.c.setText(str3);
    }
    else
    {
      do
      {
        localObject1 = (String)((String)localObject1).subSequence(0, ((String)localObject1).length() - 1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("...");
        ((StringBuilder)localObject2).append(str2);
        localObject2 = ((StringBuilder)localObject2).toString();
        str3 = (String)TextUtils.ellipsize((CharSequence)localObject2, localTextPaint, f1, TextUtils.TruncateAt.END);
      } while (!TextUtils.equals((CharSequence)localObject2, str3));
      this.c.setText(str3);
    }
    this.h = ((Button)findViewById(2131430004));
    this.i = ((Button)findViewById(2131430026));
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j = b();
    if (this.j == null)
    {
      QQToast.makeText(this, 1, HardCodeUtil.a(2131905764), 0).show();
      finish();
    }
    this.b.setImageBitmap(this.j);
    g();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.k = paramBitmap;
    paramBitmap = this.l;
    if (paramBitmap != null)
    {
      paramBitmap.recycle();
      this.l = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = (paramBoolean ^ true);
  }
  
  Bitmap b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap start");
    }
    Object localObject2;
    int i4;
    Object localObject1;
    int i1;
    int i2;
    int i3;
    try
    {
      localObject2 = QRUtils.a(String.format(ShareHelper.a, new Object[] { this.app.getCurrentAccountUin() }), 29);
      i4 = ((BitMatrix)localObject2).a();
      localObject1 = new int[i4 * i4];
      i1 = 0;
    }
    catch (Exception localException2)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label252;
      }
      QLog.i("PersonalityLabelDeleteActivity", 2, localException2.getMessage());
      localObject1 = localObject2;
      break label252;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      localObject2 = null;
    }
    if (i2 < i4) {
      if (((BitMatrix)localObject2).a(i2, i1)) {
        i3 = -16777216;
      }
    }
    label305:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, i4, 0, 0, i4, i4);
      localObject1 = Bitmap.createBitmap(this.m, this.m, Bitmap.Config.ARGB_8888);
      try
      {
        new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, this.m, this.m), null);
        ((Bitmap)localObject2).recycle();
      }
      catch (Exception localException1)
      {
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("PersonalityLabelDeleteActivity", 2, localOutOfMemoryError2.getMessage());
        localObject1 = localObject2;
      }
      label252:
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap end");
      }
      return localObject1;
      for (;;)
      {
        if (i1 >= i4) {
          break label305;
        }
        i2 = 0;
        break;
        i3 = -1;
        localObject1[(i1 * i4 + i2)] = i3;
        i2 += 1;
        break;
        i1 += 1;
      }
    }
  }
  
  Bitmap c()
  {
    int i1 = this.d.getWidth();
    int i2 = this.d.getHeight();
    Bitmap localBitmap;
    Object localObject;
    try
    {
      localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      try
      {
        localObject = new Canvas(localBitmap);
        ((Canvas)localObject).drawColor(-1);
        Point localPoint1 = a(this.a);
        ((Canvas)localObject).save();
        ((Canvas)localObject).translate(localPoint1.x, localPoint1.y);
        if (this.k != null) {
          ((Canvas)localObject).drawBitmap(this.k, 0.0F, 0.0F, this.t);
        }
        ((Canvas)localObject).restore();
        Point localPoint2 = a(this.f);
        localPoint1 = a(this.e);
        Point localPoint3 = a(this.g);
        ((Canvas)localObject).save();
        i1 = AIOUtils.b(40.0F, getResources());
        i2 = AIOUtils.b(18.0F, getResources());
        ((Canvas)localObject).translate(localPoint3.x + localPoint2.x + localPoint1.x, localPoint3.y + localPoint2.y + localPoint1.y);
        this.s.setBounds(0, 0, i1, i2);
        this.s.draw((Canvas)localObject);
        ((Canvas)localObject).restore();
        localPoint3 = a(this.c);
        ((Canvas)localObject).save();
        Layout localLayout = this.c.getLayout();
        ((Canvas)localObject).translate(localPoint3.x + localPoint2.x + localPoint1.x, localPoint3.y + localPoint2.y + localPoint1.y);
        localLayout.draw((Canvas)localObject);
        ((Canvas)localObject).restore();
        ((Canvas)localObject).save();
        localPoint2 = a(this.b);
        ((Canvas)localObject).translate(localPoint1.x + localPoint2.x, localPoint1.y + localPoint2.y);
        ((Canvas)localObject).drawBitmap(this.j, null, new Rect(0, 0, this.m, this.m), null);
        ((Canvas)localObject).restore();
        return localBitmap;
      }
      catch (Exception localException1) {}catch (OutOfMemoryError localOutOfMemoryError1) {}
      localObject = localBitmap;
    }
    catch (Exception localException2)
    {
      localBitmap = null;
      localObject = localBitmap;
      if (!QLog.isColorLevel()) {
        break label446;
      }
      QLog.i("PersonalityLabelDeleteActivity", 2, localException2.getMessage());
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      localBitmap = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("PersonalityLabelDeleteActivity", 2, localOutOfMemoryError2.getMessage());
      localObject = localBitmap;
    }
    label446:
    return localObject;
  }
  
  void d()
  {
    setLeftViewName(2131887440);
    this.rightViewText.setVisibility(8);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusDrawable(null);
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusColor(-16777216);
      this.mSystemBarComp.setStatusBarColor(-16777216);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      if (paramInt1 == 1)
      {
        QRUtils.a(2, 2131914127);
      }
      else if (paramInt1 == 21)
      {
        Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
        finish();
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627630);
    this.q = ((ProfilePersonalityLabelInfo)getIntent().getParcelableExtra("data"));
    a();
    this.s = getResources().getDrawable(2130847312);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    d();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430026)
    {
      if (!this.o)
      {
        QQToast.makeText(this, 2131897148, 0).show();
      }
      else
      {
        if (this.l == null) {
          this.l = c();
        }
        if (this.l == null)
        {
          QQToast.makeText(this, 1, 2131897149, 0).show();
        }
        else
        {
          if (this.p == null) {
            this.p = new ShareHelper(this, this.app, this, this);
          }
          this.p.a(this.l);
          this.p.a(null);
        }
      }
    }
    else if (paramView.getId() == 2131430004)
    {
      if (this.o)
      {
        if (this.l == null) {
          this.l = c();
        }
        if (this.l == null) {
          QQToast.makeText(this, 1, 2131897149, 0).show();
        } else if (!this.u) {
          e();
        } else {
          QQToast.makeText(this, 0, HardCodeUtil.a(2131905770), 0).show();
        }
      }
    }
    else if (paramView.getId() == 2131439800)
    {
      this.u = false;
      Bitmap localBitmap = this.l;
      if (localBitmap != null)
      {
        localBitmap.recycle();
        this.l = null;
      }
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity
 * JD-Core Version:    0.7.0.1
 */