package com.tencent.mobileqq.profile.PersonalityLabel;

import agor;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
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
  PersonalityLabel jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel;
  ShareHelper jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper;
  TagCloudView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView;
  public boolean a;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  public boolean b;
  public Bitmap c;
  View c;
  View d;
  
  public PersonalityLabelShareActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.getSize());
    Object localObject3 = null;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2131493236);
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
        TagUtil.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel, this.jdField_a_of_type_Float);
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
      localObject2 = QRUtils.a(String.format(ShareHelper.a, new Object[] { this.app.getCurrentAccountUin() }), 29);
      m = ((BitMatrix)localObject2).a();
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
      if (((BitMatrix)localObject2).a(j, i)) {
        k = -16777216;
      }
    }
    label305:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, m, 0, 0, m, m);
      localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888);
      for (;;)
      {
        if (i >= m) {
          break label305;
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
    Object localObject = (BounceScrollView)findViewById(2131370705);
    ((BounceScrollView)localObject).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject).mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView = ((TagCloudView)findViewById(2131370962));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setOnUpdateDrawingListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setMinHeight((int)(this.jdField_a_of_type_Float * 150.0F));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setThreshold((int)(this.jdField_a_of_type_Float * 7.5F));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370961);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370963);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131370964);
    this.d = findViewById(2131362823);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370965));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363632));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131559451);
    localObject = ContactUtils.a(this.app, this.app.getCurrentAccountUin());
    int i = getResources().getDisplayMetrics().widthPixels - AIOUtils.a(20.0F, getResources()) * 5 - AIOUtils.a(1.0F, getResources()) - this.jdField_a_of_type_Int - AIOUtils.a(10.0F, getResources());
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize());
    String str1 = "来自" + (String)localObject + "的个性标签";
    String str2 = (String)TextUtils.ellipsize(str1, localTextPaint, i, TextUtils.TruncateAt.END);
    if (TextUtils.equals(str1, str2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370966));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131370967));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidGraphicsBitmap = a();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        QQToast.a(this, 1, "生成二维码失败，请重试", 0).a();
        finish();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      d();
      return;
      do
      {
        localObject = (String)((String)localObject).subSequence(0, ((String)localObject).length() - 1);
        str1 = "来自" + (String)localObject + "..." + "的个性标签";
        str2 = (String)TextUtils.ellipsize(str1, localTextPaint, i, TextUtils.TruncateAt.END);
      } while (!TextUtils.equals(str1, str2));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
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
    //   1: getfield 310	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   4: invokevirtual 431	android/view/View:getWidth	()I
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 310	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   12: invokevirtual 434	android/view/View:getHeight	()I
    //   15: istore_3
    //   16: iload_2
    //   17: iload_3
    //   18: getstatic 212	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   21: invokestatic 218	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   24: astore 4
    //   26: new 224	android/graphics/Canvas
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 227	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   35: astore 5
    //   37: aload 5
    //   39: iconst_m1
    //   40: invokevirtual 437	android/graphics/Canvas:drawColor	(I)V
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 120	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   48: invokevirtual 439	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   51: astore 6
    //   53: aload 5
    //   55: invokevirtual 442	android/graphics/Canvas:save	()I
    //   58: pop
    //   59: aload 5
    //   61: aload 6
    //   63: getfield 445	android/graphics/Point:x	I
    //   66: i2f
    //   67: aload 6
    //   69: getfield 448	android/graphics/Point:y	I
    //   72: i2f
    //   73: invokevirtual 452	android/graphics/Canvas:translate	(FF)V
    //   76: aload_0
    //   77: getfield 426	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   80: ifnull +18 -> 98
    //   83: aload 5
    //   85: aload_0
    //   86: getfield 426	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   89: fconst_0
    //   90: fconst_0
    //   91: aload_0
    //   92: getfield 42	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidTextTextPaint	Landroid/text/TextPaint;
    //   95: invokevirtual 455	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   98: aload 5
    //   100: invokevirtual 458	android/graphics/Canvas:restore	()V
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 316	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   108: invokevirtual 439	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   111: astore 7
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 313	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   118: invokevirtual 439	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   121: astore 6
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 319	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:d	Landroid/view/View;
    //   128: invokevirtual 439	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   131: astore 8
    //   133: aload 5
    //   135: invokevirtual 442	android/graphics/Canvas:save	()I
    //   138: pop
    //   139: ldc_w 459
    //   142: aload_0
    //   143: invokevirtual 66	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:getResources	()Landroid/content/res/Resources;
    //   146: invokestatic 352	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   149: istore_2
    //   150: ldc_w 460
    //   153: aload_0
    //   154: invokevirtual 66	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:getResources	()Landroid/content/res/Resources;
    //   157: invokestatic 352	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   160: istore_3
    //   161: aload 5
    //   163: aload 8
    //   165: getfield 445	android/graphics/Point:x	I
    //   168: aload 7
    //   170: getfield 445	android/graphics/Point:x	I
    //   173: iadd
    //   174: aload 6
    //   176: getfield 445	android/graphics/Point:x	I
    //   179: iadd
    //   180: i2f
    //   181: aload 8
    //   183: getfield 448	android/graphics/Point:y	I
    //   186: aload 7
    //   188: getfield 448	android/graphics/Point:y	I
    //   191: iadd
    //   192: aload 6
    //   194: getfield 448	android/graphics/Point:y	I
    //   197: iadd
    //   198: i2f
    //   199: invokevirtual 452	android/graphics/Canvas:translate	(FF)V
    //   202: aload_0
    //   203: getfield 462	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   206: iconst_0
    //   207: iconst_0
    //   208: iload_2
    //   209: iload_3
    //   210: invokevirtual 467	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   213: aload_0
    //   214: getfield 462	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   217: aload 5
    //   219: invokevirtual 471	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   222: aload 5
    //   224: invokevirtual 458	android/graphics/Canvas:restore	()V
    //   227: aload_0
    //   228: aload_0
    //   229: getfield 333	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   232: invokevirtual 439	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   235: astore 8
    //   237: aload 5
    //   239: invokevirtual 442	android/graphics/Canvas:save	()I
    //   242: pop
    //   243: aload_0
    //   244: getfield 333	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   247: invokevirtual 475	android/widget/TextView:getLayout	()Landroid/text/Layout;
    //   250: astore 9
    //   252: aload 8
    //   254: getfield 445	android/graphics/Point:x	I
    //   257: aload 7
    //   259: getfield 445	android/graphics/Point:x	I
    //   262: iadd
    //   263: aload 6
    //   265: getfield 445	android/graphics/Point:x	I
    //   268: iadd
    //   269: i2f
    //   270: fstore_1
    //   271: aload 8
    //   273: getfield 448	android/graphics/Point:y	I
    //   276: istore_2
    //   277: aload 5
    //   279: fload_1
    //   280: aload 7
    //   282: getfield 448	android/graphics/Point:y	I
    //   285: iload_2
    //   286: iadd
    //   287: aload 6
    //   289: getfield 448	android/graphics/Point:y	I
    //   292: iadd
    //   293: i2f
    //   294: invokevirtual 452	android/graphics/Canvas:translate	(FF)V
    //   297: aload 9
    //   299: aload 5
    //   301: invokevirtual 478	android/text/Layout:draw	(Landroid/graphics/Canvas;)V
    //   304: aload 5
    //   306: invokevirtual 458	android/graphics/Canvas:restore	()V
    //   309: aload 5
    //   311: invokevirtual 442	android/graphics/Canvas:save	()I
    //   314: pop
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 328	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   320: invokevirtual 439	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:a	(Landroid/view/View;)Landroid/graphics/Point;
    //   323: astore 7
    //   325: aload 6
    //   327: getfield 445	android/graphics/Point:x	I
    //   330: aload 7
    //   332: getfield 445	android/graphics/Point:x	I
    //   335: iadd
    //   336: i2f
    //   337: fstore_1
    //   338: aload 6
    //   340: getfield 448	android/graphics/Point:y	I
    //   343: istore_2
    //   344: aload 5
    //   346: fload_1
    //   347: aload 7
    //   349: getfield 448	android/graphics/Point:y	I
    //   352: iload_2
    //   353: iadd
    //   354: i2f
    //   355: invokevirtual 452	android/graphics/Canvas:translate	(FF)V
    //   358: aload 5
    //   360: aload_0
    //   361: getfield 397	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   364: aconst_null
    //   365: new 229	android/graphics/Rect
    //   368: dup
    //   369: iconst_0
    //   370: iconst_0
    //   371: aload_0
    //   372: getfield 33	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_Int	I
    //   375: aload_0
    //   376: getfield 33	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:jdField_a_of_type_Int	I
    //   379: invokespecial 232	android/graphics/Rect:<init>	(IIII)V
    //   382: aconst_null
    //   383: invokevirtual 236	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   386: aload 5
    //   388: invokevirtual 458	android/graphics/Canvas:restore	()V
    //   391: aload 4
    //   393: areturn
    //   394: astore 6
    //   396: aconst_null
    //   397: astore 5
    //   399: aload 5
    //   401: astore 4
    //   403: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq -15 -> 391
    //   409: ldc 138
    //   411: iconst_2
    //   412: aload 6
    //   414: invokevirtual 242	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   417: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 5
    //   422: areturn
    //   423: astore 6
    //   425: aconst_null
    //   426: astore 5
    //   428: aload 5
    //   430: astore 4
    //   432: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq -44 -> 391
    //   438: ldc 138
    //   440: iconst_2
    //   441: aload 6
    //   443: invokevirtual 146	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   446: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    setLeftViewName(2131432414);
    getTitleBarView().setBackgroundResource(2130838214);
    this.rightViewText.setVisibility(8);
    this.leftView.setTextColor(getResources().getColorStateList(2130842956));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130844179));
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusDrawable(null);
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusColor(-16777216);
      this.mSystemBarComp.setStatusBarColor(-16777216);
    }
  }
  
  void c()
  {
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.postImmediately(new agor(this), null, true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label25;
      }
      QRUtils.a(2, 2131430007);
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label25:
      if (paramInt1 == 21)
      {
        Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
        finish();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970514);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel = ((PersonalityLabel)getIntent().getParcelableExtra("data"));
    a();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842966);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370967) {
      if (!this.jdField_a_of_type_Boolean) {
        QQToast.a(this, 2131439091, 0).a();
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
          this.jdField_c_of_type_AndroidGraphicsBitmap = b();
        }
        if (this.jdField_c_of_type_AndroidGraphicsBitmap == null)
        {
          QQToast.a(this, 1, 2131439090, 0).a();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper == null) {
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper = new ShareHelper(this, this.app, this, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper.a(this.jdField_c_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper.a(null);
        return;
        if (paramView.getId() != 2131370966) {
          break;
        }
      } while (!this.jdField_a_of_type_Boolean);
      if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_c_of_type_AndroidGraphicsBitmap = b();
      }
      if (this.jdField_c_of_type_AndroidGraphicsBitmap == null)
      {
        QQToast.a(this, 1, 2131439090, 0).a();
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        c();
        return;
      }
      QQToast.a(this, 0, "已保存", 0).a();
      return;
    } while (paramView.getId() != 2131370961);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity
 * JD-Core Version:    0.7.0.1
 */