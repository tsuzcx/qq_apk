package dov.com.qq.im.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.util.DoodleLayoutConnector;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class CaptureComboLocationPaster
  extends CaptureComboBase
  implements URLDrawable.URLDrawableListener
{
  private final float jdField_a_of_type_Float;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  LocationFacePackage jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage;
  String jdField_a_of_type_JavaLangString;
  private final float jdField_b_of_type_Float;
  private final String jdField_b_of_type_JavaLangString;
  private final float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = 0;
  int d = 2;
  
  public CaptureComboLocationPaster(LocationFacePackage paramLocationFacePackage, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage = paramLocationFacePackage;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    if (QLog.isColorLevel()) {
      QLog.d("QCombo.LPaster", 2, "create id=" + paramString1 + " name=" + paramString2);
    }
  }
  
  private URLDrawable a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    LocationFacePackage.Item localItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a(this.jdField_a_of_type_JavaLangString);
    if (localItem != null) {
      return URLDrawable.getDrawable(localItem.d, localURLDrawableOptions);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo.LPaster", 2, "createUrlDrawable no item =" + this.jdField_a_of_type_JavaLangString);
    }
    return null;
  }
  
  public float a()
  {
    return 1.0F;
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
          this.jdField_a_of_type_ComTencentImageURLDrawable = a();
        }
        if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
          break label129;
        }
        if (this.d != 3)
        {
          LocationFacePackage.Item localItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a(this.jdField_a_of_type_JavaLangString);
          if (localItem == null) {
            break label92;
          }
          if (AbsDownloader.a(localItem.d) == null) {
            this.d = 2;
          }
        }
        else
        {
          int i = this.d;
          return i;
        }
        this.d = 3;
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      label92:
      QLog.d("QCombo.LPaster", 2, "getState no item =" + this.jdField_a_of_type_JavaLangString);
      continue;
      label129:
      this.d = 2;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = DoodleLayoutConnector.a().a(paramInt);
    if (paramActivity != null)
    {
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage, this.jdField_a_of_type_JavaLangString, ScreenUtil.a, ScreenUtil.b, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, paramActivity.a());
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "apply id=" + this.jdField_b_of_type_JavaLangString + " name=" + this.jdField_a_of_type_JavaLangString + " state=" + this.d);
      }
    }
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    paramActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a(this.jdField_a_of_type_JavaLangString);
    if (paramActivity != null)
    {
      DoodleLayout localDoodleLayout = DoodleLayoutConnector.a().a(paramInt);
      if (localDoodleLayout != null) {
        localDoodleLayout.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_JavaLangString, paramActivity.c);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "apply id=" + this.jdField_b_of_type_JavaLangString + " name=" + this.jdField_a_of_type_JavaLangString + " state=" + this.d);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "unApply no item =" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(LocationFacePackage paramLocationFacePackage, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (paramIFaceSelectedListener == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "try apply but no listener");
      }
    }
    do
    {
      return;
      paramLocationFacePackage = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (paramLocationFacePackage == null) {
        break;
      }
      paramLocationFacePackage.setBounds(0, 0, paramLocationFacePackage.getIntrinsicWidth(), paramLocationFacePackage.getIntrinsicHeight());
      paramString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a(this.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        paramString.a = paramLocationFacePackage;
        paramIFaceSelectedListener.a(paramString, paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo.LPaster", 2, "applyLocationPaster no item =" + this.jdField_a_of_type_JavaLangString);
    return;
    SLog.e("QCombo.LPaster", "can create drawable from urldrawable:" + this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 108	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 110	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:a	()Lcom/tencent/image/URLDrawable;
    //   14: putfield 108	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   17: aload_0
    //   18: getfield 108	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   21: ifnull +86 -> 107
    //   24: aload_0
    //   25: getfield 108	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   28: invokevirtual 197	com/tencent/image/URLDrawable:getStatus	()I
    //   31: iconst_1
    //   32: if_icmpne +84 -> 116
    //   35: aload_0
    //   36: iconst_3
    //   37: putfield 24	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:d	I
    //   40: aload_0
    //   41: bipush 100
    //   43: putfield 22	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_c_of_type_Int	I
    //   46: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +58 -> 107
    //   52: ldc 44
    //   54: iconst_2
    //   55: new 46	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   62: ldc 199
    //   64: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 26	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 57
    //   76: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 28	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 201
    //   88: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 108	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   95: invokevirtual 197	com/tencent/image/URLDrawable:getStatus	()I
    //   98: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_0
    //   108: getfield 24	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:d	I
    //   111: istore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: iload_1
    //   115: ireturn
    //   116: aload_0
    //   117: getfield 108	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   120: invokevirtual 118	com/tencent/image/URLDrawable:startDownload	()V
    //   123: aload_0
    //   124: getfield 108	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   127: aload_0
    //   128: invokevirtual 205	com/tencent/image/URLDrawable:setURLDrawableListener	(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 24	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:d	I
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 22	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:jdField_c_of_type_Int	I
    //   141: aload_0
    //   142: invokevirtual 207	dov/com/qq/im/capture/paster/CaptureComboLocationPaster:a	()V
    //   145: goto -99 -> 46
    //   148: astore_2
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	CaptureComboLocationPaster
    //   111	4	1	i	int
    //   148	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	148	finally
    //   17	46	148	finally
    //   46	107	148	finally
    //   107	112	148	finally
    //   116	145	148	finally
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_c_of_type_Int = 0;
    this.d = 2;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_c_of_type_Int = 0;
    this.d = 2;
    a(1);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.d = 1;
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_c_of_type_Int = 100;
    this.d = 3;
    b();
  }
  
  public String toString()
  {
    return "LP@" + this.jdField_b_of_type_JavaLangString + "@" + this.jdField_a_of_type_JavaLangString + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboLocationPaster
 * JD-Core Version:    0.7.0.1
 */