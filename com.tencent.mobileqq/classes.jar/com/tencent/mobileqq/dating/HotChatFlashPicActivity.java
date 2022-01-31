package com.tencent.mobileqq.dating;

import agki;
import agkj;
import agkl;
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
import apid;
import apie;
import bcyz;
import bdgf;
import bhvu;
import bnle;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.CountDownProgressBar;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import zja;
import zjc;
import zjd;
import zji;

public class HotChatFlashPicActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener, bhvu, zja
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private agki jdField_a_of_type_Agki;
  private agkl jdField_a_of_type_Agkl = new apid(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new apie(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdgf jdField_a_of_type_Bdgf;
  private AnimationView jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AIOImageData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
  private CountDownProgressBar jdField_a_of_type_ComTencentWidgetCountDownProgressBar;
  private String jdField_a_of_type_JavaLangString = "";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private zji jdField_a_of_type_Zji;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = 1;
    int n = 1;
    int i2 = n;
    if (paramInt1 != 0)
    {
      i2 = n;
      if (paramInt2 != 0)
      {
        i2 = n;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i2 = n;
        }
      }
    }
    label43:
    int i1;
    label55:
    do
    {
      do
      {
        return i2;
        n = paramOptions.outHeight;
        i1 = paramOptions.outWidth;
        i2 = m;
      } while (n <= paramInt2);
      i2 = m;
    } while (i1 <= paramInt1);
    int i3 = Math.round(n / paramInt2);
    i2 = Math.round(i1 / paramInt1);
    if (i3 > i2) {}
    for (;;)
    {
      i2 = m;
      if (i3 < 2) {
        break;
      }
      m <<= 1;
      i1 >>= 1;
      n >>= 1;
      break label55;
      i3 = i2;
    }
  }
  
  private long a()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int m = localCalendar.get(11);
    int n = localCalendar.get(12);
    int i1 = localCalendar.get(13);
    return l + (86399000L - m * 3600 * 1000 - n * 60 * 1000 - i1 * 1000);
  }
  
  private Bitmap a(String paramString)
  {
    int m = 320;
    int i1 = 1;
    Object localObject = getResources().getDisplayMetrics();
    int n = ((DisplayMetrics)localObject).widthPixels;
    int i2 = ((DisplayMetrics)localObject).heightPixels;
    if ((n == 0) || (i2 == 0)) {
      n = 320;
    }
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = a(localOptions, n, m);
        localObject = SafeBitmapFactory.decodeFile(paramString, localOptions);
        i2 = ((Bitmap)localObject).getWidth() / 16;
        if (i2 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotchat", 2, "reqWidth:" + n + ",reqHeight:" + m + ",inSampleSize:" + localOptions.inSampleSize + ",block:" + i1);
          }
          paramString = bcyz.a((Bitmap)localObject, i1);
        }
        i1 = i2;
      }
      catch (Exception localException1)
      {
        try
        {
          ((Bitmap)localObject).recycle();
          return paramString;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          localObject = paramString;
          continue;
        }
        catch (Exception localException2)
        {
          localObject = paramString;
          continue;
        }
        localException1 = localException1;
        localObject = null;
        paramString = (String)localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.hotchat", 2, "FlashPicActivity getMosaicBitmap Exception：" + localException1.toString());
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject = null;
        localOutOfMemoryError1.printStackTrace();
        paramString = (String)localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.hotchat", 2, "FlashPicActivity getMosaicBitmap oom：" + localOutOfMemoryError1.toString());
        return localObject;
      }
      continue;
      m = i2;
    }
  }
  
  private String a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4) != null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2) != null))
    {
      this.g = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4) != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_c_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "checkLocalFileExist,filePath:" + (String)localObject + ",isOrigin:" + false + ",isSendFromLocal:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e);
      }
      return localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_JavaLangString;
      continue;
      String str = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_c_of_type_JavaLangString);
      localObject = str;
      if (str == null)
      {
        str = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_JavaLangString);
        localObject = str;
        if (str == null)
        {
          localObject = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
            localObject = "I:E";
          }
        }
      }
    }
  }
  
  private String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("I:N"))) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString + "_fp";
      if (!new File(str).exists()) {
        break;
      }
      paramString = str;
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.hotchat", 4, "flash pic cache file exist");
    return str;
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_Bdgf.sendMessage(localMessage);
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2131166286);
    if (this.i) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.i = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "update mosaic");
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(8);
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(paramBitmap);
      this.jdField_a_of_type_Bdgf.sendEmptyMessage(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int m = paramDrawable.getIntrinsicWidth();
    int n = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject).widthPixels;
    int i2 = ((DisplayMetrics)localObject).heightPixels;
    float f1 = Math.min(i1 / m, i2 / n);
    localObject = zjc.a((int)(m * f1), (int)(n * f1), i1, i2, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(paramDrawable, localRect, (Rect)localObject, zjd.a(localRect, paramDrawable), 350L);
    paramDrawable = new AlphaAnimation(0.0F, 1.0F);
    paramDrawable.setInterpolator(new AccelerateInterpolator());
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2131166286);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramDrawable);
  }
  
  private void a(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = paramString;
    this.jdField_a_of_type_Bdgf.sendMessageDelayed(localMessage, 200L);
  }
  
  private String b()
  {
    int m = 7;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int < 2)) {
      return "error happen";
    }
    this.jdField_a_of_type_Long = getSharedPreferences(this.jdField_a_of_type_JavaLangString, 4).getLong("commen_flashpic_shot_deadlineday", 0L);
    double d1 = this.jdField_a_of_type_Long - System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((d1 < 0.0D) || (d1 >= 86400000.0D)) {
      if (d1 < 0.0D)
      {
        localStringBuilder.append(m);
        localStringBuilder.append(getString(2131691030));
      }
    }
    for (;;)
    {
      return String.format(getString(2131691029), new Object[] { localStringBuilder });
      m = Math.min((int)(d1 / 86400000.0D), 7);
      break;
      m = (int)(d1 / 3600000.0D);
      if (m != 0)
      {
        localStringBuilder.append(m);
        localStringBuilder.append(getString(2131691032));
      }
      int n = (int)((d1 - m * 3600000.0D) / 60000.0D);
      if ((m == 0) && (n == 0))
      {
        localStringBuilder.append(1);
        localStringBuilder.append(getString(2131691033));
      }
      else if (n != 0)
      {
        localStringBuilder.append(n);
        localStringBuilder.append(getString(2131691033));
      }
    }
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      finish();
    }
    while (this.j) {
      return;
    }
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int m = paramDrawable.getIntrinsicWidth();
    int n = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject).widthPixels;
    int i2 = ((DisplayMetrics)localObject).heightPixels;
    float f1 = Math.min(i1 / m, i2 / n);
    localObject = zjc.a((int)(m * f1), (int)(n * f1), i1, i2, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(paramDrawable, localRect, (Rect)localObject, zjd.a(localRect, paramDrawable), 0, 0, 350L);
    paramDrawable = new AlphaAnimation(1.0F, 0.0F);
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramDrawable);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_Bdgf.sendEmptyMessage(7);
    paramString = a(paramString);
    if (paramString != null)
    {
      Message localMessage = new Message();
      localMessage.what = 5;
      localMessage.obj = paramString;
      this.jdField_a_of_type_Bdgf.sendMessage(localMessage);
    }
  }
  
  private void c(String paramString)
  {
    this.jdField_a_of_type_Bdgf.sendEmptyMessage(7);
    a(a(paramString));
  }
  
  private void d(String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(a(paramString));
    a(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "count down stop");
    }
    if (this.jdField_c_of_type_Boolean) {
      b(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    c(this.jdField_d_of_type_JavaLangString);
  }
  
  public void c() {}
  
  public void d()
  {
    this.j = true;
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "on back pressed");
    }
    b(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.k = true;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    if (bnle.c(this))
    {
      this.mNeedStatusTrans = true;
      this.mActNeedImmersive = false;
      super.doOnCreate(paramBundle);
      if (Build.VERSION.SDK_INT > 13) {
        getWindow().addFlags(8192);
      }
      setContentView(2131561051);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376034));
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)findViewById(2131362576));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131366479));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131366483);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366481));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366482));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131366478);
      this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar = ((CountDownProgressBar)findViewById(2131366477));
      this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(2500L, 3);
      this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setOnCountDownLinstener(this);
      this.jdField_a_of_type_Zji = new zji();
      this.jdField_a_of_type_Zji.a(this, (ImageView)findViewById(2131366480));
      paramBundle = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (paramBundle != null)
      {
        this.jdField_a_of_type_Agki = agkj.a(paramBundle.a);
        this.jdField_a_of_type_Agki.a(this.jdField_a_of_type_Agkl);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData = ((AIOImageData)getIntent().getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("isreaded", false);
      this.jdField_b_of_type_Long = getIntent().getLongExtra("uniseq", 0L);
      this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("md5");
      this.e = getIntent().getBooleanExtra("is_send", false);
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("self_uin");
      this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("self_identify", true);
      this.jdField_b_of_type_Int = getIntent().getIntExtra("curtype", 0);
      this.jdField_a_of_type_Bdgf = new bdgf(this.jdField_a_of_type_AndroidOsHandler$Callback);
      paramBundle = getSharedPreferences(this.jdField_a_of_type_JavaLangString, 4);
      if (!this.jdField_a_of_type_Boolean) {
        break label656;
      }
      this.jdField_a_of_type_Int = paramBundle.getInt("HOTCHAT_FLASHPIC_SHOT", 0);
      label440:
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = paramBundle.getLong("commen_flashpic_shot_deadlineday", 0L);
        if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Long <= System.currentTimeMillis()))
        {
          this.jdField_a_of_type_Int = 0;
          paramBundle = paramBundle.edit();
          paramBundle.putInt("commen_flashpic_shot", this.jdField_a_of_type_Int);
          paramBundle.putLong("commen_flashpic_shot_deadlineday", 0L);
          paramBundle.commit();
        }
        this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(4500L, 5);
      }
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData != null)) {
        break label686;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842199);
      if (!this.jdField_a_of_type_Boolean) {
        break label673;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693457);
      label577:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "mIsReaded:" + this.jdField_b_of_type_Boolean + ",mScreenShotCount:" + this.jdField_a_of_type_Int + ",mIsSend:" + this.e);
      }
      return true;
      this.mNeedStatusTrans = false;
      break;
      label656:
      this.jdField_a_of_type_Int = paramBundle.getInt("commen_flashpic_shot", 0);
      break label440;
      label673:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691027);
      break label577;
      label686:
      if ((this.jdField_a_of_type_Int >= 2) && (!this.e))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842199);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693459);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          break;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
        }
      }
      this.jdField_c_of_type_JavaLangString = a();
      if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals("I:E")))
      {
        this.jdField_a_of_type_Bdgf.sendEmptyMessage(1);
      }
      else if (this.jdField_c_of_type_JavaLangString != null)
      {
        paramBundle = this.jdField_c_of_type_JavaLangString;
        this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        a(0);
        ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.2(this, paramBundle));
      }
      else
      {
        this.f = true;
        a(0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(1) != null)
        {
          this.h = true;
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotchat", 2, "flashpic thumbImageFile exists");
          }
        }
        this.jdField_a_of_type_Agki.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Int, 2);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap().recycle();
      if ((this.jdField_a_of_type_Agki == null) || (getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {}
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          this.jdField_a_of_type_Agki.a();
          System.gc();
          return;
          localException1 = localException1;
        } while (!QLog.isColorLevel());
        QLog.w("Q.hotchat", 2, "", localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void doOnPause()
  {
    if ((isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e) && (!this.g) && (this.jdField_c_of_type_JavaLangString != null) && (!this.jdField_c_of_type_JavaLangString.equals("I:E")) && (!this.jdField_c_of_type_Boolean))
    {
      String str = this.jdField_c_of_type_JavaLangString;
      ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.5(this, str));
    }
    super.doOnPause();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.k))
    {
      if (!this.h) {
        break label39;
      }
      d(this.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      this.k = false;
      return;
      label39:
      this.jdField_a_of_type_Bdgf.postDelayed(new HotChatFlashPicActivity.3(this), 350L);
    }
  }
  
  public void e()
  {
    finish();
    this.j = false;
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_c_of_type_Boolean) {
      ThreadManagerV2.executeOnFileThread(new HotChatFlashPicActivity.7(this));
    }
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public boolean isSupportScreenShot()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "isSupportScreenShot,mIsPicShow:" + this.jdField_c_of_type_Boolean + ",mScreenShotCount:" + this.jdField_a_of_type_Int + ",mHadShot:" + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_d_of_type_Boolean = true;
        ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.6(this));
        this.jdField_a_of_type_Bdgf.sendEmptyMessage(4);
      }
      return false;
    }
    return super.isSupportScreenShot();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368624) {
      finish();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.hotchat", 2, "action down,mLargeError:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean + ",mIsLoading:" + this.f);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean) && (!this.f))
        {
          this.f = true;
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_Zji.b(0);
          this.jdField_a_of_type_Zji.a();
          a(0);
          this.jdField_a_of_type_Agki.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Int, 2);
          return true;
        }
      } while ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.f) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean));
      this.jdField_a_of_type_Bdgf.sendEmptyMessageDelayed(3, 500L);
      return true;
      this.jdField_a_of_type_Bdgf.removeMessages(3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "on touch: " + paramMotionEvent.getAction());
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean);
    b(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity
 * JD-Core Version:    0.7.0.1
 */