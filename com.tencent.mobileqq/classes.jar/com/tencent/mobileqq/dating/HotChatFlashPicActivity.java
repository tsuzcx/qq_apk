package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationLister;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.common.galleryactivity.GalleryProgressView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.CountDownProgressBar;
import com.tencent.widget.CountDownProgressBar.OnCountDownLinstener;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class HotChatFlashPicActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener, AnimationLister, CountDownProgressBar.OnCountDownLinstener
{
  private String A;
  private boolean B;
  private AtomicBoolean C = new AtomicBoolean(true);
  private boolean D;
  private BitmapDrawable E;
  private boolean F;
  private boolean G;
  private int H;
  private IAIOImageProviderCallBack I = new HotChatFlashPicActivity.1(this);
  private Handler.Callback J = new HotChatFlashPicActivity.4(this);
  private long a = 0L;
  private RelativeLayout b;
  private AnimationView c;
  private URLImageView d;
  private View e;
  private TextView f;
  private ImageView g;
  private View h;
  private CountDownProgressBar i;
  private GalleryProgressView j;
  private Dialog k;
  private IAIOImageProvider l;
  private AIOImageData m;
  private CustomHandler n;
  private String o = "";
  private boolean p = false;
  private long q;
  private boolean r = false;
  private boolean s = false;
  private String t;
  private int u;
  private boolean v;
  private boolean w = false;
  private String x = null;
  private int y = 0;
  private boolean z = false;
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i2 = 1;
    int i1 = 1;
    int i4 = i2;
    if (paramInt1 != 0)
    {
      i4 = i2;
      if (paramInt2 != 0)
      {
        i4 = i2;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          i2 = paramOptions.outHeight;
          int i3 = paramOptions.outWidth;
          for (;;)
          {
            i4 = i1;
            if (i2 <= paramInt2) {
              break;
            }
            i4 = i1;
            if (i3 <= paramInt1) {
              break;
            }
            int i5 = Math.round(i2 / paramInt2);
            i4 = Math.round(i3 / paramInt1);
            if (i5 <= i4) {
              i5 = i4;
            }
            i4 = i1;
            if (i5 < 2) {
              break;
            }
            i3 >>= 1;
            i2 >>= 1;
            i1 <<= 1;
          }
        }
      }
    }
    return i4;
  }
  
  private void a(int paramInt)
  {
    this.H = paramInt;
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.n.sendMessage(localMessage);
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.b.setBackgroundResource(2131167242);
    if (this.D) {
      this.e.setVisibility(0);
    }
    this.D = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "update mosaic");
    }
    this.c.setVisibility(8);
    if (paramBitmap != null)
    {
      this.d.setImageBitmap(paramBitmap);
      this.n.sendEmptyMessage(8);
      this.d.setVisibility(0);
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int i3 = ((DisplayMetrics)localObject).widthPixels;
    int i4 = ((DisplayMetrics)localObject).heightPixels;
    float f2 = i3;
    float f1 = i1;
    float f3 = f2 / f1;
    float f4 = i4;
    f2 = i2;
    f3 = Math.min(f3, f4 / f2);
    localObject = AnimationUtils.a((int)(f1 * f3), (int)(f2 * f3), i3, i4, false, null);
    this.c.setVisibility(0);
    this.c.setAnimationListener(this);
    this.c.a(paramDrawable, localRect, (Rect)localObject, GalleryImage.getCutValue(localRect, paramDrawable), 350L);
    paramDrawable = new AlphaAnimation(0.0F, 1.0F);
    paramDrawable.setInterpolator(new AccelerateInterpolator());
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.b.setBackgroundResource(2131167242);
    this.b.startAnimation(paramDrawable);
  }
  
  private void a(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = paramString;
    this.n.sendMessageDelayed(localMessage, 200L);
  }
  
  private String b()
  {
    Object localObject;
    if ((this.m.c(4) == null) && (this.m.c(2) == null))
    {
      localObject = d(this.m.c);
      if (localObject == null)
      {
        localObject = d(this.m.b);
        if ((localObject == null) && (this.m.f))
        {
          localObject = this.m;
          localObject = "I:E";
        }
      }
    }
    else
    {
      this.z = true;
      if (this.m.c(4) != null) {
        localObject = this.m.c;
      } else {
        localObject = this.m.b;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkLocalFileExist,filePath:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",isOrigin:");
      localStringBuilder.append(false);
      localStringBuilder.append(",isSendFromLocal:");
      localStringBuilder.append(this.m.j);
      QLog.d("Q.hotchat", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      finish();
      return;
    }
    if (this.F) {
      return;
    }
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int i3 = ((DisplayMetrics)localObject).widthPixels;
    int i4 = ((DisplayMetrics)localObject).heightPixels;
    float f2 = i3;
    float f1 = i1;
    float f3 = f2 / f1;
    float f4 = i4;
    f2 = i2;
    f3 = Math.min(f3, f4 / f2);
    localObject = AnimationUtils.a((int)(f1 * f3), (int)(f2 * f3), i3, i4, false, null);
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.c.setAnimationListener(this);
    this.c.a(paramDrawable, localRect, (Rect)localObject, GalleryImage.getCutValue(localRect, paramDrawable), 0, 0, 350L);
    paramDrawable = new AlphaAnimation(1.0F, 0.0F);
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.b.startAnimation(paramDrawable);
  }
  
  private void b(String paramString)
  {
    this.n.sendEmptyMessage(7);
    paramString = e(paramString);
    if (paramString != null)
    {
      Message localMessage = new Message();
      localMessage.what = 5;
      localMessage.obj = paramString;
      this.n.sendMessage(localMessage);
    }
  }
  
  private long c()
  {
    long l1 = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l1);
    int i1 = localCalendar.get(11);
    int i2 = localCalendar.get(12);
    int i3 = localCalendar.get(13);
    return l1 + (86399000L - i1 * 3600 * 1000 - i2 * 60 * 1000 - i3 * 1000);
  }
  
  private void c(String paramString)
  {
    this.n.sendEmptyMessage(7);
    a(e(paramString));
  }
  
  private String d()
  {
    if (this.u < 2) {
      return "error happen";
    }
    this.a = getSharedPreferences(this.o, 4).getLong("commen_flashpic_shot_deadlineday", 0L);
    double d1 = this.a - System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1;
    if ((d1 >= 0.0D) && (d1 < 86400000.0D))
    {
      Double.isNaN(d1);
      i1 = (int)(d1 / 3600000.0D);
      if (i1 != 0)
      {
        localStringBuilder.append(i1);
        localStringBuilder.append(getString(2131887961));
      }
      double d2 = i1;
      Double.isNaN(d2);
      Double.isNaN(d1);
      int i2 = (int)((d1 - d2 * 3600000.0D) / 60000.0D);
      if ((i1 == 0) && (i2 == 0))
      {
        localStringBuilder.append(1);
        localStringBuilder.append(getString(2131887962));
      }
      else if (i2 != 0)
      {
        localStringBuilder.append(i2);
        localStringBuilder.append(getString(2131887962));
      }
    }
    else
    {
      i1 = 7;
      if (d1 >= 0.0D)
      {
        Double.isNaN(d1);
        i1 = Math.min((int)(d1 / 86400000.0D), 7);
      }
      localStringBuilder.append(i1);
      localStringBuilder.append(getString(2131887960));
    }
    return String.format(getString(2131887959), new Object[] { localStringBuilder });
  }
  
  private String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("I:N")) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_fp");
      paramString = localStringBuilder.toString();
      if (new File(paramString).exists())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.hotchat", 4, "flash pic cache file exist");
        }
        return paramString;
      }
    }
    return null;
  }
  
  private Bitmap e(String paramString)
  {
    Object localObject1 = getResources().getDisplayMetrics();
    int i2 = ((DisplayMetrics)localObject1).widthPixels;
    int i3 = ((DisplayMetrics)localObject1).heightPixels;
    int i1;
    if (i2 != 0)
    {
      i1 = i3;
      if (i3 != 0) {}
    }
    else
    {
      i1 = 320;
      i2 = 320;
    }
    Object localObject4 = null;
    Object localObject3 = null;
    localObject1 = localObject3;
    Object localObject2 = localObject4;
    for (;;)
    {
      int i4;
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        i3 = 1;
        localObject1 = localObject3;
        localObject2 = localObject4;
        localOptions.inJustDecodeBounds = true;
        localObject1 = localObject3;
        localObject2 = localObject4;
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        localObject1 = localObject3;
        localObject2 = localObject4;
        localOptions.inJustDecodeBounds = false;
        localObject1 = localObject3;
        localObject2 = localObject4;
        localOptions.inSampleSize = a(localOptions, i2, i1);
        localObject1 = localObject3;
        localObject2 = localObject4;
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramString, localOptions);
        localObject1 = localObject3;
        localObject2 = localObject4;
        i4 = localBitmap.getWidth() / 16;
        if (i4 != 0) {
          break label494;
        }
        localObject1 = localObject3;
        localObject2 = localObject4;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString = new StringBuilder();
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append("reqWidth:");
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(i2);
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(",reqHeight:");
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(i1);
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(",inSampleSize:");
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(localOptions.inSampleSize);
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(",block:");
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(i3);
          localObject1 = localObject3;
          localObject2 = localObject4;
          QLog.d("Q.hotchat", 2, paramString.toString());
        }
        localObject1 = localObject3;
        localObject2 = localObject4;
        paramString = ((IPicFlash)QRoute.api(IPicFlash.class)).getMosaicBitmap(localBitmap, i3);
        localObject1 = paramString;
        localObject2 = paramString;
        localBitmap.recycle();
        return paramString;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        paramString = (String)localObject1;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("FlashPicActivity getMosaicBitmap oom：");
          paramString.append(localOutOfMemoryError.toString());
          QLog.d("Q.hotchat", 2, paramString.toString());
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        paramString = localOutOfMemoryError;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("FlashPicActivity getMosaicBitmap Exception：");
          paramString.append(localException.toString());
          QLog.d("Q.hotchat", 2, paramString.toString());
          paramString = localOutOfMemoryError;
        }
      }
      return paramString;
      label494:
      i3 = i4;
    }
  }
  
  private void f(String paramString)
  {
    this.E = new BitmapDrawable(e(paramString));
    a(this.E);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "count down stop");
    }
    if (this.r) {
      b(this.d.getDrawable());
    }
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "on back pressed");
    }
    b(this.d.getDrawable());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.G = true;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    if (LiuHaiUtils.enableNotch(this))
    {
      this.mNeedStatusTrans = true;
      this.mActNeedImmersive = false;
    }
    else
    {
      this.mNeedStatusTrans = false;
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 13) {
      getWindow().addFlags(8192);
    }
    setContentView(2131627534);
    this.b = ((RelativeLayout)findViewById(2131445137));
    this.c = ((AnimationView)findViewById(2131428368));
    this.d = ((URLImageView)findViewById(2131433410));
    this.e = findViewById(2131433414);
    this.g = ((ImageView)this.e.findViewById(2131433412));
    this.f = ((TextView)this.e.findViewById(2131433413));
    this.h = findViewById(2131433409);
    this.i = ((CountDownProgressBar)findViewById(2131433408));
    this.i.setOnCountDownLinstener(this);
    this.j = new GalleryProgressView();
    this.j.a(this, (ImageView)findViewById(2131433411));
    paramBundle = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
    if (paramBundle != null)
    {
      this.l = IAIOImageProvider.Stub.a(paramBundle.a);
      this.l.a(this.I);
    }
    this.m = ((AIOImageData)getIntent().getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.p = getIntent().getBooleanExtra("isreaded", false);
    this.q = getIntent().getLongExtra("uniseq", 0L);
    this.t = getIntent().getStringExtra("md5");
    this.v = getIntent().getBooleanExtra("is_send", false);
    this.o = getIntent().getStringExtra("self_uin");
    this.y = getIntent().getIntExtra("curtype", 0);
    this.n = new CustomHandler(this.J);
    paramBundle = getSharedPreferences(this.o, 4);
    this.u = paramBundle.getInt("commen_flashpic_shot", 0);
    this.a = paramBundle.getLong("commen_flashpic_shot_deadlineday", 0L);
    if (((this.a != 0L) || (this.u > 2)) && (this.a <= System.currentTimeMillis()))
    {
      this.u = 0;
      paramBundle = paramBundle.edit();
      paramBundle.putInt("commen_flashpic_shot", this.u);
      paramBundle.putLong("commen_flashpic_shot_deadlineday", 0L);
      paramBundle.commit();
    }
    this.i.setTotalMills(4500L, 5);
    if ((!this.p) && (this.m != null))
    {
      if ((this.u >= 2) && (!this.v))
      {
        this.g.setImageResource(2130843596);
        this.f.setText(d());
        this.e.setVisibility(0);
      }
      else
      {
        this.x = b();
        paramBundle = this.x;
        if ((paramBundle != null) && (paramBundle.equals("I:E")))
        {
          this.n.sendEmptyMessage(1);
        }
        else
        {
          paramBundle = this.x;
          if (paramBundle != null)
          {
            this.A = paramBundle;
            a(0);
            ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.2(this, paramBundle));
          }
          else
          {
            this.w = true;
            a(0);
            if (this.m.c(1) != null)
            {
              this.B = true;
              this.A = this.m.a;
              if (QLog.isColorLevel()) {
                QLog.d("Q.hotchat", 2, "flashpic thumbImageFile exists");
              }
            }
            this.l.a(this.m.L, this.m.M, 2);
          }
        }
      }
    }
    else
    {
      this.g.setImageResource(2130843596);
      this.f.setText(2131887957);
      this.e.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("mIsReaded:");
      paramBundle.append(this.p);
      paramBundle.append(",mScreenShotCount:");
      paramBundle.append(this.u);
      paramBundle.append(",mIsSend:");
      paramBundle.append(this.v);
      QLog.d("Q.hotchat", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    BitmapDrawable localBitmapDrawable = this.E;
    if ((localBitmapDrawable != null) && (localBitmapDrawable.getBitmap() != null)) {
      try
      {
        this.E.getBitmap().recycle();
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.hotchat", 2, "", localException1);
        }
      }
    }
    if ((this.l != null) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
      try
      {
        this.l.a();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    System.gc();
  }
  
  protected void doOnPause()
  {
    if ((isFinishing()) && (!this.m.j) && (!this.z))
    {
      String str = this.x;
      if ((str != null) && (!str.equals("I:E")) && (!this.r))
      {
        str = this.x;
        ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.5(this, str));
      }
    }
    super.doOnPause();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    String str = this.A;
    if ((str != null) && (this.G)) {
      if (this.B) {
        f(str);
      } else {
        this.n.postDelayed(new HotChatFlashPicActivity.3(this), 350L);
      }
    }
    this.G = false;
  }
  
  public void finish()
  {
    super.finish();
    if (this.r) {
      ThreadManagerV2.executeOnFileThread(new HotChatFlashPicActivity.7(this));
    }
  }
  
  public void g()
  {
    this.d.setVisibility(0);
    this.d.setImageDrawable(this.E);
    c(this.A);
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public void h() {}
  
  public void i()
  {
    this.F = true;
  }
  
  public boolean isSupportScreenShot()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportScreenShot,mIsPicShow:");
      localStringBuilder.append(this.r);
      localStringBuilder.append(",mScreenShotCount:");
      localStringBuilder.append(this.u);
      localStringBuilder.append(",mHadShot:");
      localStringBuilder.append(this.s);
      QLog.d("Q.hotchat", 2, localStringBuilder.toString());
    }
    if (this.r)
    {
      if (!this.s)
      {
        this.u += 1;
        this.s = true;
        ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.6(this));
        this.n.sendEmptyMessage(4);
      }
      return false;
    }
    return super.isSupportScreenShot();
  }
  
  public void j()
  {
    finish();
    this.F = false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436180) {
      finish();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 3)) {
        return true;
      }
      this.n.removeMessages(3);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("on touch: ");
        paramView.append(paramMotionEvent.getAction());
        QLog.d("Q.hotchat", 2, paramView.toString());
      }
      if (!this.m.f)
      {
        b(this.d.getDrawable());
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("action down,mLargeError:");
        paramView.append(this.m.f);
        paramView.append(",mIsLoading:");
        paramView.append(this.w);
        QLog.d("Q.hotchat", 2, paramView.toString());
      }
      if ((this.m.f) && (!this.w))
      {
        this.w = true;
        this.e.setVisibility(8);
        this.j.b(0);
        this.j.a();
        a(0);
        this.l.a(this.m.L, this.m.M, 2);
        return true;
      }
      if ((!this.r) && (!this.s) && (!this.w) && (!this.m.f)) {
        this.n.sendEmptyMessageDelayed(3, 500L);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity
 * JD-Core Version:    0.7.0.1
 */