package com.tencent.mobileqq.dating;

import aceq;
import acer;
import aces;
import acet;
import acev;
import acew;
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
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new acet(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimationView jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView;
  private GalleryProgressView jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AIOImageData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
  private IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private IAIOImageProviderCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = new aceq(this);
  private CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler;
  private CountDownProgressBar jdField_a_of_type_ComTencentWidgetCountDownProgressBar;
  private String jdField_a_of_type_JavaLangString = "";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
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
          paramString = URLDrawableDecodeHandler.a((Bitmap)localObject, i1);
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
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(localMessage);
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2131493267);
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(8);
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
    localObject = AnimationUtils.a((int)(m * f1), (int)(n * f1), i1, i2, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(paramDrawable, localRect, (Rect)localObject, GalleryImage.a(localRect, paramDrawable), 350L);
    paramDrawable = new AlphaAnimation(0.0F, 1.0F);
    paramDrawable.setInterpolator(new AccelerateInterpolator());
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2131493267);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramDrawable);
  }
  
  private void a(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = paramString;
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessageDelayed(localMessage, 200L);
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
        localStringBuilder.append(getString(2131438105));
      }
    }
    for (;;)
    {
      return String.format(getString(2131438104), new Object[] { localStringBuilder });
      m = Math.min((int)(d1 / 86400000.0D), 7);
      break;
      m = (int)(d1 / 3600000.0D);
      if (m != 0)
      {
        localStringBuilder.append(m);
        localStringBuilder.append(getString(2131438106));
      }
      int n = (int)((d1 - m * 3600000.0D) / 60000.0D);
      if ((m == 0) && (n == 0))
      {
        localStringBuilder.append(1);
        localStringBuilder.append(getString(2131438107));
      }
      else if (n != 0)
      {
        localStringBuilder.append(n);
        localStringBuilder.append(getString(2131438107));
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
    localObject = AnimationUtils.a((int)(m * f1), (int)(n * f1), i1, i2, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(paramDrawable, localRect, (Rect)localObject, GalleryImage.a(localRect, paramDrawable), 0, 0, 350L);
    paramDrawable = new AlphaAnimation(1.0F, 0.0F);
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramDrawable);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(7);
    paramString = a(paramString);
    if (paramString != null)
    {
      Message localMessage = new Message();
      localMessage.what = 5;
      localMessage.obj = paramString;
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(localMessage);
    }
  }
  
  private void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(7);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.k = true;
    this.mNeedStatusTrans = false;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 13) {
      getWindow().addFlags(8192);
    }
    setContentView(2130970442);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362845));
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)findViewById(2131364824));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131370504));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370505);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370506));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370507));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370508);
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar = ((CountDownProgressBar)findViewById(2131370509));
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(2500L, 3);
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setOnCountDownLinstener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView = new GalleryProgressView();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(this, (ImageView)findViewById(2131370510));
    paramBundle = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = IAIOImageProvider.Stub.a(paramBundle.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData = ((AIOImageData)getIntent().getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("isreaded", false);
    this.jdField_b_of_type_Long = getIntent().getLongExtra("uniseq", 0L);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("md5");
    this.e = getIntent().getBooleanExtra("is_send", false);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("self_uin");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("self_identify", true);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("curtype", 0);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBundle = getSharedPreferences(this.jdField_a_of_type_JavaLangString, 4);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("HOTCHAT_FLASHPIC_SHOT", 0);
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
        break label666;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840606);
      if (!this.jdField_a_of_type_Boolean) {
        break label653;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438090);
      label565:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "mIsReaded:" + this.jdField_b_of_type_Boolean + ",mScreenShotCount:" + this.jdField_a_of_type_Int + ",mIsSend:" + this.e);
      }
      return true;
      this.jdField_a_of_type_Int = paramBundle.getInt("commen_flashpic_shot", 0);
      break;
      label653:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438101);
      break label565;
      label666:
      if ((this.jdField_a_of_type_Int >= 2) && (!this.e))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840606);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438093);
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
        this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(1);
      }
      else if (this.jdField_c_of_type_JavaLangString != null)
      {
        paramBundle = this.jdField_c_of_type_JavaLangString;
        this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        a(0);
        ThreadManager.getFileThreadHandler().post(new acer(this, paramBundle));
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
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.f, 2);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap().recycle();
      System.gc();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.hotchat", 2, "", localException);
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    if ((isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e) && (!this.g) && (this.jdField_c_of_type_JavaLangString != null) && (!this.jdField_c_of_type_JavaLangString.equals("I:E")))
    {
      String str = this.jdField_c_of_type_JavaLangString;
      ThreadManager.getFileThreadHandler().post(new acev(this, str));
    }
    super.doOnPause();
  }
  
  protected void doOnStart()
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.postDelayed(new aces(this), 350L);
    }
  }
  
  public void e()
  {
    finish();
    this.j = false;
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
        ThreadManager.getFileThreadHandler().post(new acew(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(4);
      }
      return false;
    }
    return super.isSupportScreenShot();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363262) {
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
          this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.b(0);
          this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a();
          a(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.f, 2);
          return true;
        }
      } while ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.f) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean));
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(3, 500L);
      return true;
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "on touch: " + paramMotionEvent.getAction());
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean);
    b(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity
 * JD-Core Version:    0.7.0.1
 */