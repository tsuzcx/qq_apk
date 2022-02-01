package com.tencent.mobileqq.profile.PersonalityLabel;

import Override;
import amtj;
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
import aylp;
import aylr;
import aylu;
import aylx;
import aymb;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import gr;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import yyi;

public class PersonalityLabelShareActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aylu, aylx
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
  aylr jdField_a_of_type_Aylr;
  PersonalityLabel jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel;
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
        requestPermissions(new aylp(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
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
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.getSize());
    Object localObject3 = null;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2131165444);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.getLatestThumbLocalUrl();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = new File((String)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL("file:///" + ((File)localObject1).getAbsolutePath()), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        aymb.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel, this.jdField_a_of_type_Float);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTags(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTagIcon((Drawable)localObject1);
        return;
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PersonalityLabelDeleteActivity", 2, localMalformedURLException2.getMessage(), localMalformedURLException2);
        localObject1 = localObject3;
        continue;
      }
      catch (Exception localException1)
      {
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PersonalityLabelDeleteActivity", 2, localException1.getMessage(), localException1);
        localObject1 = localObject3;
        continue;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.getLatestThumbUrl();
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("http")) || (str.startsWith("https"))))
      {
        localObject1 = URLDrawable.getDrawable(str, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      else
      {
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = new File(str);
          Object localObject2;
          try
          {
            localObject1 = URLDrawable.getDrawable(new URL("file:///" + ((File)localObject1).getAbsolutePath()), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
          catch (MalformedURLException localMalformedURLException1)
          {
            localMalformedURLException1.printStackTrace();
            localObject2 = localObject3;
          }
          catch (Exception localException2)
          {
            localObject2 = localObject3;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("PersonalityLabelDeleteActivity", 2, localException2.getMessage(), localException2);
            localObject2 = localObject3;
          }
        }
      }
    }
  }
  
  Bitmap a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap start");
    }
    int m;
    Object localObject1;
    int i;
    int j;
    int k;
    try
    {
      localObject2 = yyi.a(String.format(aylr.a, new Object[] { this.app.getCurrentAccountUin() }), 29);
      m = ((gr)localObject2).a();
      localObject1 = new int[m * m];
      i = 0;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int), null);
          ((Bitmap)localObject2).recycle();
          if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap end");
          }
          return localObject1;
        }
        catch (Exception localException2)
        {
          localObject2 = localObject1;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject2 = localObject1;
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject2 = null;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("PersonalityLabelDeleteActivity", 2, localOutOfMemoryError1.getMessage());
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("PersonalityLabelDeleteActivity", 2, localException1.getMessage());
          localObject1 = localObject2;
        }
      }
    }
    if (j < m) {
      if (((gr)localObject2).a(j, i)) {
        k = -16777216;
      }
    }
    label306:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, m, 0, 0, m, m);
      localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888);
      for (;;)
      {
        if (i >= m) {
          break label306;
        }
        j = 0;
        break;
        for (;;)
        {
          localObject1[(i * m + j)] = k;
          j += 1;
          break;
          k = -1;
        }
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
    Object localObject = (BounceScrollView)findViewById(2131363689);
    ((BounceScrollView)localObject).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject).mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView = ((TagCloudView)findViewById(2131378209));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setOnUpdateDrawingListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setMinHeight((int)(this.jdField_a_of_type_Float * 150.0F));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setThreshold((int)(this.jdField_a_of_type_Float * 7.5F));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372211);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368721);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131378482);
    this.d = findViewById(2131370365);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374517));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378367));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131298333);
    localObject = ContactUtils.getFriendNick(this.app, this.app.getCurrentAccountUin());
    String str1 = amtj.a(2131707061);
    String str2 = amtj.a(2131707083);
    int i = getResources().getDisplayMetrics().widthPixels - AIOUtils.dp2px(20.0F, getResources()) * 5 - AIOUtils.dp2px(1.0F, getResources()) - this.jdField_a_of_type_Int - AIOUtils.dp2px(10.0F, getResources());
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize());
    String str3 = str1 + (String)localObject + str2;
    String str4 = (String)TextUtils.ellipsize(str3, localTextPaint, i, TextUtils.TruncateAt.END);
    if (TextUtils.equals(str3, str4)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363950));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363972));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidGraphicsBitmap = a();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        QQToast.a(this, 1, amtj.a(2131707060), 0).a();
        finish();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      e();
      return;
      do
      {
        localObject = (String)((String)localObject).subSequence(0, ((String)localObject).length() - 1);
        str3 = str1 + (String)localObject + "..." + str2;
        str4 = (String)TextUtils.ellipsize(str3, localTextPaint, i, TextUtils.TruncateAt.END);
      } while (!TextUtils.equals(str3, str4));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str4);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  /* Error */
  Bitmap b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 342	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   4: invokevirtual 467	android/view/View:getWidth	()I
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 342	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   12: invokevirtual 470	android/view/View:getHeight	()I
    //   15: istore_3
    //   16: iload_2
    //   17: iload_3
    //   18: getstatic 244	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   21: invokestatic 250	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   24: astore 4
    //   26: new 256	android/graphics/Canvas
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 259	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   35: astore 5
    //   37: aload 5
    //   39: iconst_m1
    //   40: invokevirtual 473	android/graphics/Canvas:drawColor	(I)V
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 154	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   48: invokevirtual 475	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   51: astore 6
    //   53: aload 5
    //   55: invokevirtual 478	android/graphics/Canvas:save	()I
    //   58: pop
    //   59: aload 5
    //   61: aload 6
    //   63: getfield 481	android/graphics/Point:x	I
    //   66: i2f
    //   67: aload 6
    //   69: getfield 484	android/graphics/Point:y	I
    //   72: i2f
    //   73: invokevirtual 488	android/graphics/Canvas:translate	(FF)V
    //   76: aload_0
    //   77: getfield 462	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   80: ifnull +18 -> 98
    //   83: aload 5
    //   85: aload_0
    //   86: getfield 462	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   89: fconst_0
    //   90: fconst_0
    //   91: aload_0
    //   92: getfield 42	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidTextTextPaint	Landroid/text/TextPaint;
    //   95: invokevirtual 491	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   98: aload 5
    //   100: invokevirtual 494	android/graphics/Canvas:restore	()V
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 348	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   108: invokevirtual 475	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   111: astore 7
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 345	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   118: invokevirtual 475	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   121: astore 6
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 351	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:d	Landroid/view/View;
    //   128: invokevirtual 475	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   131: astore 8
    //   133: aload 5
    //   135: invokevirtual 478	android/graphics/Canvas:save	()I
    //   138: pop
    //   139: ldc_w 495
    //   142: aload_0
    //   143: invokevirtual 100	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:getResources	()Landroid/content/res/Resources;
    //   146: invokestatic 393	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   149: istore_2
    //   150: ldc_w 496
    //   153: aload_0
    //   154: invokevirtual 100	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:getResources	()Landroid/content/res/Resources;
    //   157: invokestatic 393	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   160: istore_3
    //   161: aload 5
    //   163: aload 8
    //   165: getfield 481	android/graphics/Point:x	I
    //   168: aload 7
    //   170: getfield 481	android/graphics/Point:x	I
    //   173: iadd
    //   174: aload 6
    //   176: getfield 481	android/graphics/Point:x	I
    //   179: iadd
    //   180: i2f
    //   181: aload 8
    //   183: getfield 484	android/graphics/Point:y	I
    //   186: aload 7
    //   188: getfield 484	android/graphics/Point:y	I
    //   191: iadd
    //   192: aload 6
    //   194: getfield 484	android/graphics/Point:y	I
    //   197: iadd
    //   198: i2f
    //   199: invokevirtual 488	android/graphics/Canvas:translate	(FF)V
    //   202: aload_0
    //   203: getfield 498	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   206: iconst_0
    //   207: iconst_0
    //   208: iload_2
    //   209: iload_3
    //   210: invokevirtual 503	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   213: aload_0
    //   214: getfield 498	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   217: aload 5
    //   219: invokevirtual 507	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   222: aload 5
    //   224: invokevirtual 494	android/graphics/Canvas:restore	()V
    //   227: aload_0
    //   228: aload_0
    //   229: getfield 365	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   232: invokevirtual 475	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   235: astore 8
    //   237: aload 5
    //   239: invokevirtual 478	android/graphics/Canvas:save	()I
    //   242: pop
    //   243: aload_0
    //   244: getfield 365	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   247: invokevirtual 511	android/widget/TextView:getLayout	()Landroid/text/Layout;
    //   250: astore 9
    //   252: aload 8
    //   254: getfield 481	android/graphics/Point:x	I
    //   257: aload 7
    //   259: getfield 481	android/graphics/Point:x	I
    //   262: iadd
    //   263: aload 6
    //   265: getfield 481	android/graphics/Point:x	I
    //   268: iadd
    //   269: i2f
    //   270: fstore_1
    //   271: aload 8
    //   273: getfield 484	android/graphics/Point:y	I
    //   276: istore_2
    //   277: aload 5
    //   279: fload_1
    //   280: aload 7
    //   282: getfield 484	android/graphics/Point:y	I
    //   285: iload_2
    //   286: iadd
    //   287: aload 6
    //   289: getfield 484	android/graphics/Point:y	I
    //   292: iadd
    //   293: i2f
    //   294: invokevirtual 488	android/graphics/Canvas:translate	(FF)V
    //   297: aload 9
    //   299: aload 5
    //   301: invokevirtual 514	android/text/Layout:draw	(Landroid/graphics/Canvas;)V
    //   304: aload 5
    //   306: invokevirtual 494	android/graphics/Canvas:restore	()V
    //   309: aload 5
    //   311: invokevirtual 478	android/graphics/Canvas:save	()I
    //   314: pop
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 360	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   320: invokevirtual 475	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   323: astore 7
    //   325: aload 6
    //   327: getfield 481	android/graphics/Point:x	I
    //   330: aload 7
    //   332: getfield 481	android/graphics/Point:x	I
    //   335: iadd
    //   336: i2f
    //   337: fstore_1
    //   338: aload 6
    //   340: getfield 484	android/graphics/Point:y	I
    //   343: istore_2
    //   344: aload 5
    //   346: fload_1
    //   347: aload 7
    //   349: getfield 484	android/graphics/Point:y	I
    //   352: iload_2
    //   353: iadd
    //   354: i2f
    //   355: invokevirtual 488	android/graphics/Canvas:translate	(FF)V
    //   358: aload 5
    //   360: aload_0
    //   361: getfield 434	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   364: aconst_null
    //   365: new 261	android/graphics/Rect
    //   368: dup
    //   369: iconst_0
    //   370: iconst_0
    //   371: aload_0
    //   372: getfield 33	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_Int	I
    //   375: aload_0
    //   376: getfield 33	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_Int	I
    //   379: invokespecial 264	android/graphics/Rect:<init>	(IIII)V
    //   382: aconst_null
    //   383: invokevirtual 268	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   386: aload 5
    //   388: invokevirtual 494	android/graphics/Canvas:restore	()V
    //   391: aload 4
    //   393: areturn
    //   394: astore 6
    //   396: aconst_null
    //   397: astore 5
    //   399: aload 5
    //   401: astore 4
    //   403: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq -15 -> 391
    //   409: ldc 172
    //   411: iconst_2
    //   412: aload 6
    //   414: invokevirtual 274	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   417: invokestatic 205	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 5
    //   422: areturn
    //   423: astore 6
    //   425: aconst_null
    //   426: astore 5
    //   428: aload 5
    //   430: astore 4
    //   432: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq -44 -> 391
    //   438: ldc 172
    //   440: iconst_2
    //   441: aload 6
    //   443: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   446: invokestatic 205	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: aload 5
    //   451: areturn
    //   452: astore 6
    //   454: aload 4
    //   456: astore 5
    //   458: goto -30 -> 428
    //   461: astore 6
    //   463: aload 4
    //   465: astore 5
    //   467: goto -68 -> 399
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	PersonalityLabelShareActivity
    //   270	77	1	f	float
    //   7	347	2	i	int
    //   15	195	3	j	int
    //   24	440	4	localObject1	Object
    //   35	431	5	localObject2	Object
    //   51	288	6	localPoint1	Point
    //   394	19	6	localOutOfMemoryError1	OutOfMemoryError
    //   423	19	6	localException1	Exception
    //   452	1	6	localException2	Exception
    //   461	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   111	237	7	localPoint2	Point
    //   131	141	8	localPoint3	Point
    //   250	48	9	localLayout	android.text.Layout
    // Exception table:
    //   from	to	target	type
    //   16	26	394	java/lang/OutOfMemoryError
    //   16	26	423	java/lang/Exception
    //   26	98	452	java/lang/Exception
    //   98	391	452	java/lang/Exception
    //   26	98	461	java/lang/OutOfMemoryError
    //   98	391	461	java/lang/OutOfMemoryError
  }
  
  void b()
  {
    setLeftViewName(2131690424);
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label25;
      }
      yyi.a(2, 2131716160);
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label25:
      if (paramInt1 == 21)
      {
        Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
        finish();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561268);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel = ((PersonalityLabel)getIntent().getParcelableExtra("data"));
    a();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845566);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    b();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363972) {
      if (!this.jdField_a_of_type_Boolean) {
        QQToast.a(this, 2131698429, 0).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_c_of_type_AndroidGraphicsBitmap = b();
      }
      if (this.jdField_c_of_type_AndroidGraphicsBitmap == null)
      {
        QQToast.a(this, 1, 2131698430, 0).a();
      }
      else
      {
        if (this.jdField_a_of_type_Aylr == null) {
          this.jdField_a_of_type_Aylr = new aylr(this, this.app, this, this);
        }
        this.jdField_a_of_type_Aylr.a(this.jdField_c_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_Aylr.a(null);
        continue;
        if (paramView.getId() == 2131363950)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
              this.jdField_c_of_type_AndroidGraphicsBitmap = b();
            }
            if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
              QQToast.a(this, 1, 2131698430, 0).a();
            } else if (!this.jdField_b_of_type_Boolean) {
              c();
            } else {
              QQToast.a(this, 0, amtj.a(2131707067), 0).a();
            }
          }
        }
        else if (paramView.getId() == 2131372211)
        {
          this.jdField_b_of_type_Boolean = false;
          if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
          {
            this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
            this.jdField_c_of_type_AndroidGraphicsBitmap = null;
          }
          e();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity
 * JD-Core Version:    0.7.0.1
 */