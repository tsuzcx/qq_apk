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
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(7);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ProfilePersonalityLabelInfo jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
  ShareHelper jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper;
  TagCloudView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView;
  boolean jdField_a_of_type_Boolean = true;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  boolean jdField_b_of_type_Boolean = false;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  View jdField_c_of_type_AndroidViewView;
  View d;
  
  private void c()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new PersonalityLabelShareActivity.1(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      d();
      return;
    }
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.postImmediately(new PersonalityLabelShareActivity.2(this), null, true);
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.getSize());
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2131165426);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.getLatestThumbLocalUrl();
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
        localObject1 = URLDrawable.getDrawable(new URL(localStringBuilder.toString()), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
      Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.getLatestThumbUrl();
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && ((((String)localObject4).startsWith("http")) || (((String)localObject4).startsWith("https"))))
      {
        localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
            localObject1 = URLDrawable.getDrawable(new URL(((StringBuilder)localObject4).toString()), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    TagUtil.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo, this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTags(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTagIcon(localObject2);
  }
  
  Bitmap a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap start");
    }
    Object localObject2;
    int m;
    Object localObject1;
    int i;
    int j;
    int k;
    try
    {
      localObject2 = QRUtils.a(String.format(ShareHelper.a, new Object[] { this.app.getCurrentAccountUin() }), 29);
      m = ((BitMatrix)localObject2).a();
      localObject1 = new int[m * m];
      i = 0;
    }
    catch (Exception localException2)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label250;
      }
      QLog.i("PersonalityLabelDeleteActivity", 2, localException2.getMessage());
      localObject1 = localObject2;
      break label250;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      localObject2 = null;
    }
    if (j < m) {
      if (((BitMatrix)localObject2).a(j, i)) {
        k = -16777216;
      }
    }
    label303:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, m, 0, 0, m, m);
      localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888);
      try
      {
        new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int), null);
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
      label250:
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap end");
      }
      return localObject1;
      for (;;)
      {
        if (i >= m) {
          break label303;
        }
        j = 0;
        break;
        k = -1;
        localObject1[(i * m + j)] = k;
        j += 1;
        break;
        i += 1;
      }
    }
  }
  
  public Point a(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getDrawingRect(localRect);
    ((ViewGroup)paramView.getParent()).offsetDescendantRectToMyCoords(paramView, localRect);
    int i = localRect.top;
    return new Point(localRect.left, i);
  }
  
  void a()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    Object localObject1 = (BounceScrollView)findViewById(2131363784);
    ((BounceScrollView)localObject1).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject1).mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView = ((TagCloudView)findViewById(2131378316));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setOnUpdateDrawingListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setMinHeight((int)(this.jdField_a_of_type_Float * 150.0F));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setThreshold((int)(this.jdField_a_of_type_Float * 7.5F));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372289);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368842);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131378568);
    this.d = findViewById(2131370464);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374642));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378460));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131298417);
    localObject1 = ContactUtils.a(this.app, this.app.getCurrentAccountUin());
    String str1 = HardCodeUtil.a(2131707954);
    String str2 = HardCodeUtil.a(2131707976);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = AIOUtils.b(20.0F, getResources());
    int k = AIOUtils.b(1.0F, getResources());
    int m = this.jdField_a_of_type_Int;
    int n = AIOUtils.b(10.0F, getResources());
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(str2);
    localObject2 = ((StringBuilder)localObject2).toString();
    float f = i - j * 5 - k - m - n;
    String str3 = (String)TextUtils.ellipsize((CharSequence)localObject2, localTextPaint, f, TextUtils.TruncateAt.END);
    if (TextUtils.equals((CharSequence)localObject2, str3))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str3);
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
        str3 = (String)TextUtils.ellipsize((CharSequence)localObject2, localTextPaint, f, TextUtils.TruncateAt.END);
      } while (!TextUtils.equals((CharSequence)localObject2, str3));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str3);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364046));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364068));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsBitmap = a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      QQToast.a(this, 1, HardCodeUtil.a(2131707953), 0).a();
      finish();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    e();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
    paramBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
    if (paramBitmap != null)
    {
      paramBitmap.recycle();
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = (paramBoolean ^ true);
  }
  
  Bitmap b()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    Bitmap localBitmap;
    Object localObject;
    try
    {
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      try
      {
        localObject = new Canvas(localBitmap);
        ((Canvas)localObject).drawColor(-1);
        Point localPoint1 = a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView);
        ((Canvas)localObject).save();
        ((Canvas)localObject).translate(localPoint1.x, localPoint1.y);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
          ((Canvas)localObject).drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
        }
        ((Canvas)localObject).restore();
        Point localPoint2 = a(this.jdField_c_of_type_AndroidViewView);
        localPoint1 = a(this.jdField_b_of_type_AndroidViewView);
        Point localPoint3 = a(this.d);
        ((Canvas)localObject).save();
        i = AIOUtils.b(40.0F, getResources());
        j = AIOUtils.b(18.0F, getResources());
        ((Canvas)localObject).translate(localPoint3.x + localPoint2.x + localPoint1.x, localPoint3.y + localPoint2.y + localPoint1.y);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i, j);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw((Canvas)localObject);
        ((Canvas)localObject).restore();
        localPoint3 = a(this.jdField_a_of_type_AndroidWidgetTextView);
        ((Canvas)localObject).save();
        Layout localLayout = this.jdField_a_of_type_AndroidWidgetTextView.getLayout();
        ((Canvas)localObject).translate(localPoint3.x + localPoint2.x + localPoint1.x, localPoint3.y + localPoint2.y + localPoint1.y);
        localLayout.draw((Canvas)localObject);
        ((Canvas)localObject).restore();
        ((Canvas)localObject).save();
        localPoint2 = a(this.jdField_a_of_type_AndroidWidgetImageView);
        ((Canvas)localObject).translate(localPoint1.x + localPoint2.x, localPoint1.y + localPoint2.y);
        ((Canvas)localObject).drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int), null);
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
  
  void b()
  {
    setLeftViewName(2131690529);
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
        QRUtils.a(2, 2131716664);
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
    setContentView(2131561274);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo = ((ProfilePersonalityLabelInfo)getIntent().getParcelableExtra("data"));
    a();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845842);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364068)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        QQToast.a(this, 2131699132, 0).a();
      }
      else
      {
        if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
          this.jdField_c_of_type_AndroidGraphicsBitmap = b();
        }
        if (this.jdField_c_of_type_AndroidGraphicsBitmap == null)
        {
          QQToast.a(this, 1, 2131699133, 0).a();
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper == null) {
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper = new ShareHelper(this, this.app, this, this);
          }
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper.a(this.jdField_c_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper.a(null);
        }
      }
    }
    else if (paramView.getId() == 2131364046)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
          this.jdField_c_of_type_AndroidGraphicsBitmap = b();
        }
        if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
          QQToast.a(this, 1, 2131699133, 0).a();
        } else if (!this.jdField_b_of_type_Boolean) {
          c();
        } else {
          QQToast.a(this, 0, HardCodeUtil.a(2131707960), 0).a();
        }
      }
    }
    else if (paramView.getId() == 2131372289)
    {
      this.jdField_b_of_type_Boolean = false;
      Bitmap localBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
      if (localBitmap != null)
      {
        localBitmap.recycle();
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      }
      e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity
 * JD-Core Version:    0.7.0.1
 */