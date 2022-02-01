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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new HotChatFlashPicActivity.4(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimationView jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView;
  private GalleryProgressView jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AIOImageData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
  private IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private IAIOImageProviderCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = new HotChatFlashPicActivity.1(this);
  private CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler;
  private CountDownProgressBar jdField_a_of_type_ComTencentWidgetCountDownProgressBar;
  private String jdField_a_of_type_JavaLangString = "";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e;
  private boolean f = false;
  private boolean g = false;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int n = 1;
    int m = 1;
    int i2 = n;
    if (paramInt1 != 0)
    {
      i2 = n;
      if (paramInt2 != 0)
      {
        i2 = n;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          n = paramOptions.outHeight;
          int i1 = paramOptions.outWidth;
          for (;;)
          {
            i2 = m;
            if (n <= paramInt2) {
              break;
            }
            i2 = m;
            if (i1 <= paramInt1) {
              break;
            }
            int i3 = Math.round(n / paramInt2);
            i2 = Math.round(i1 / paramInt1);
            if (i3 <= i2) {
              i3 = i2;
            }
            i2 = m;
            if (i3 < 2) {
              break;
            }
            i1 >>= 1;
            n >>= 1;
            m <<= 1;
          }
        }
      }
    }
    return i2;
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
    Object localObject1 = getResources().getDisplayMetrics();
    int n = ((DisplayMetrics)localObject1).widthPixels;
    int i1 = ((DisplayMetrics)localObject1).heightPixels;
    int m;
    if (n != 0)
    {
      m = i1;
      if (i1 != 0) {}
    }
    else
    {
      m = 320;
      n = 320;
    }
    Object localObject4 = null;
    Object localObject3 = null;
    localObject1 = localObject3;
    Object localObject2 = localObject4;
    for (;;)
    {
      int i2;
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        i1 = 1;
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
        localOptions.inSampleSize = a(localOptions, n, m);
        localObject1 = localObject3;
        localObject2 = localObject4;
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramString, localOptions);
        localObject1 = localObject3;
        localObject2 = localObject4;
        i2 = localBitmap.getWidth() / 16;
        if (i2 != 0) {
          break label487;
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
          paramString.append(n);
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(",reqHeight:");
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramString.append(m);
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
          paramString.append(i1);
          localObject1 = localObject3;
          localObject2 = localObject4;
          QLog.d("Q.hotchat", 2, paramString.toString());
        }
        localObject1 = localObject3;
        localObject2 = localObject4;
        paramString = ((IPicFlash)QRoute.api(IPicFlash.class)).getMosaicBitmap(localBitmap, i1);
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
      label487:
      i1 = i2;
    }
  }
  
  private String a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4) == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2) == null))
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_c_of_type_JavaLangString);
      if (localObject == null)
      {
        localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_JavaLangString);
        if ((localObject == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
          localObject = "I:E";
        }
      }
    }
    else
    {
      this.g = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4) != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_c_of_type_JavaLangString;
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_JavaLangString;
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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e);
      QLog.d("Q.hotchat", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private String a(String paramString)
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2131166403);
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
    float f2 = i1;
    float f1 = m;
    float f3 = f2 / f1;
    float f4 = i2;
    f2 = n;
    f3 = Math.min(f3, f4 / f2);
    localObject = AnimationUtils.a((int)(f1 * f3), (int)(f2 * f3), i1, i2, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(paramDrawable, localRect, (Rect)localObject, GalleryImage.getCutValue(localRect, paramDrawable), 350L);
    paramDrawable = new AlphaAnimation(0.0F, 1.0F);
    paramDrawable.setInterpolator(new AccelerateInterpolator());
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2131166403);
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
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= 2))
    {
      this.jdField_a_of_type_Long = getSharedPreferences(this.jdField_a_of_type_JavaLangString, 4).getLong("commen_flashpic_shot_deadlineday", 0L);
      double d1 = this.jdField_a_of_type_Long - System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      int m;
      if ((d1 >= 0.0D) && (d1 < 86400000.0D))
      {
        Double.isNaN(d1);
        m = (int)(d1 / 3600000.0D);
        if (m != 0)
        {
          localStringBuilder.append(m);
          localStringBuilder.append(getString(2131691022));
        }
        double d2 = m;
        Double.isNaN(d2);
        Double.isNaN(d1);
        int n = (int)((d1 - d2 * 3600000.0D) / 60000.0D);
        if ((m == 0) && (n == 0))
        {
          localStringBuilder.append(1);
          localStringBuilder.append(getString(2131691023));
        }
        else if (n != 0)
        {
          localStringBuilder.append(n);
          localStringBuilder.append(getString(2131691023));
        }
      }
      else
      {
        m = 7;
        if (d1 >= 0.0D)
        {
          Double.isNaN(d1);
          m = Math.min((int)(d1 / 86400000.0D), 7);
        }
        localStringBuilder.append(m);
        localStringBuilder.append(getString(2131691021));
      }
      return String.format(getString(2131691020), new Object[] { localStringBuilder });
    }
    return "error happen";
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      finish();
      return;
    }
    if (this.j) {
      return;
    }
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int m = paramDrawable.getIntrinsicWidth();
    int n = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject).widthPixels;
    int i2 = ((DisplayMetrics)localObject).heightPixels;
    float f2 = i1;
    float f1 = m;
    float f3 = f2 / f1;
    float f4 = i2;
    f2 = n;
    f3 = Math.min(f3, f4 / f2);
    localObject = AnimationUtils.a((int)(f1 * f3), (int)(f2 * f3), i1, i2, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(paramDrawable, localRect, (Rect)localObject, GalleryImage.getCutValue(localRect, paramDrawable), 0, 0, 350L);
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
    setContentView(2131561182);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376809));
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)findViewById(2131362696));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131366964));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366968);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366966));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366967));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131366963);
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar = ((CountDownProgressBar)findViewById(2131366962));
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(2500L, 3);
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setOnCountDownLinstener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView = new GalleryProgressView();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(this, (ImageView)findViewById(2131366965));
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
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Int = paramBundle.getInt("HOTCHAT_FLASHPIC_SHOT", 0);
    } else {
      this.jdField_a_of_type_Int = paramBundle.getInt("commen_flashpic_shot", 0);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = paramBundle.getLong("commen_flashpic_shot_deadlineday", 0L);
      if (((this.jdField_a_of_type_Long != 0L) || (this.jdField_a_of_type_Int != 0)) && (this.jdField_a_of_type_Long <= System.currentTimeMillis()))
      {
        this.jdField_a_of_type_Int = 0;
        paramBundle = paramBundle.edit();
        paramBundle.putInt("commen_flashpic_shot", this.jdField_a_of_type_Int);
        paramBundle.putLong("commen_flashpic_shot_deadlineday", 0L);
        paramBundle.commit();
      }
      this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(4500L, 5);
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData != null))
    {
      if ((this.jdField_a_of_type_Int >= 2) && (!this.e))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842643);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693228);
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      else
      {
        this.jdField_c_of_type_JavaLangString = a();
        paramBundle = this.jdField_c_of_type_JavaLangString;
        if ((paramBundle != null) && (paramBundle.equals("I:E")))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(1);
        }
        else
        {
          paramBundle = this.jdField_c_of_type_JavaLangString;
          if (paramBundle != null)
          {
            this.jdField_d_of_type_JavaLangString = paramBundle;
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
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Int, 2);
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842643);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693226);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691018);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("mIsReaded:");
      paramBundle.append(this.jdField_b_of_type_Boolean);
      paramBundle.append(",mScreenShotCount:");
      paramBundle.append(this.jdField_a_of_type_Int);
      paramBundle.append(",mIsSend:");
      paramBundle.append(this.e);
      QLog.d("Q.hotchat", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    BitmapDrawable localBitmapDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
    if ((localBitmapDrawable != null) && (localBitmapDrawable.getBitmap() != null)) {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap().recycle();
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.hotchat", 2, "", localException1);
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a();
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
    if ((isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e) && (!this.g))
    {
      String str = this.jdField_c_of_type_JavaLangString;
      if ((str != null) && (!str.equals("I:E")) && (!this.jdField_c_of_type_Boolean))
      {
        str = this.jdField_c_of_type_JavaLangString;
        ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.5(this, str));
      }
    }
    super.doOnPause();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    String str = this.jdField_d_of_type_JavaLangString;
    if ((str != null) && (this.k)) {
      if (this.h) {
        d(str);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.postDelayed(new HotChatFlashPicActivity.3(this), 350L);
      }
    }
    this.k = false;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    c(this.jdField_d_of_type_JavaLangString);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_c_of_type_Boolean) {
      ThreadManagerV2.executeOnFileThread(new HotChatFlashPicActivity.7(this));
    }
  }
  
  public void g() {}
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public void h()
  {
    this.j = true;
  }
  
  public void i()
  {
    finish();
    this.j = false;
  }
  
  public boolean isSupportScreenShot()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportScreenShot,mIsPicShow:");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",mScreenShotCount:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",mHadShot:");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      QLog.d("Q.hotchat", 2, localStringBuilder.toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_d_of_type_Boolean = true;
        ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.6(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(4);
      }
      return false;
    }
    return super.isSupportScreenShot();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369202) {
      finish();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if ((m != 1) && (m != 3)) {
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(3);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("on touch: ");
        paramView.append(paramMotionEvent.getAction());
        QLog.d("Q.hotchat", 2, paramView.toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean)
      {
        b(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable());
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("action down,mLargeError:");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean);
        paramView.append(",mIsLoading:");
        paramView.append(this.f);
        QLog.d("Q.hotchat", 2, paramView.toString());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean) && (!this.f))
      {
        this.f = true;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.b(0);
        this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a();
        a(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Int, 2);
        return true;
      }
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!this.f) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(3, 500L);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity
 * JD-Core Version:    0.7.0.1
 */