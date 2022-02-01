package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.mobileqq.qqgift.config.QQGiftConfig;
import com.tencent.mobileqq.qqgift.config.QQGiftRechargeConfig;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qqgift.utils.PagLoader;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import mqq.os.MqqHandler;
import org.libpag.PAGFile;

public class BannerResManager
{
  private static volatile BannerResManager a;
  private final IQQGiftResDownloadModule b;
  private final QQGiftResourceBusiness c;
  private final SparseArray<SparseArray<Bitmap>> d = new SparseArray();
  private final SparseArray<Bitmap> e = new SparseArray();
  private final SparseArray<Bitmap> f = new SparseArray();
  private final SparseArray<PAGFile> g = new SparseArray();
  private PAGFile h;
  private final SparseArray<PAGFile> i = new SparseArray();
  private int j = 0;
  
  private BannerResManager(IQQGiftResDownloadModule paramIQQGiftResDownloadModule)
  {
    this.b = paramIQQGiftResDownloadModule;
    this.c = ((QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class));
  }
  
  private URLDrawable a(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    try
    {
      paramString = URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramURLDrawableOptions = new StringBuilder();
      paramURLDrawableOptions.append("getDrawable failed: ");
      paramURLDrawableOptions.append(paramString.getMessage());
      QLog.e("BannerResManager", 1, paramURLDrawableOptions.toString());
    }
    return null;
  }
  
  public static BannerResManager a(IQQGiftResDownloadModule paramIQQGiftResDownloadModule)
  {
    try
    {
      if (a == null) {
        a = new BannerResManager(paramIQQGiftResDownloadModule);
      }
      paramIQQGiftResDownloadModule = a;
      return paramIQQGiftResDownloadModule;
    }
    finally {}
  }
  
  private void a(Bitmap paramBitmap, LoadHeadListener paramLoadHeadListener)
  {
    if (paramBitmap == null) {
      paramLoadHeadListener.a();
    }
    ThreadManager.getSubThreadHandler().post(new BannerResManager.4(this, paramBitmap, paramLoadHeadListener));
  }
  
  private void a(String paramString)
  {
    if (QQGiftPAGAnimationViewImpl.a.a())
    {
      SparseArray localSparseArray = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("qq_gift_boom.pag");
      localSparseArray.put(1, PAGFile.Load(localStringBuilder.toString()));
      localSparseArray = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(3);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("qq_gift_boom.pag");
      localSparseArray.put(3, PAGFile.Load(localStringBuilder.toString()));
      localSparseArray = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(4);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("qq_gift_boom.pag");
      localSparseArray.put(4, PAGFile.Load(localStringBuilder.toString()));
      b(paramString);
      return;
    }
    QQGiftPAGAnimationViewImpl.a.a(BaseApplication.getContext(), new BannerResManager.2(this, paramString));
  }
  
  private void a(String paramString, int paramInt)
  {
    SparseArray localSparseArray = new SparseArray();
    this.d.put(paramInt, localSparseArray);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(File.separator);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).outHeight = ImmersiveUtils.dpToPx(30.0F);
    ((BitmapFactory.Options)localObject).outWidth = ImmersiveUtils.dpToPx(22.0F);
    int k = 0;
    while (k < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("qq_gift_");
      localStringBuilder.append(k);
      localStringBuilder.append(".png");
      localSparseArray.put(k, BitmapFactory.decodeFile(localStringBuilder.toString(), (BitmapFactory.Options)localObject));
      k += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("qq_gift_x.png");
    localSparseArray.put(10, BitmapFactory.decodeFile(localStringBuilder.toString(), (BitmapFactory.Options)localObject));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("qq_gift_bg.png");
    localSparseArray.put(11, BitmapFactory.decodeFile(localStringBuilder.toString(), (BitmapFactory.Options)localObject));
    ((BitmapFactory.Options)localObject).outHeight = ImmersiveUtils.dpToPx(60.0F);
    ((BitmapFactory.Options)localObject).outWidth = ImmersiveUtils.dpToPx(60.0F);
    localSparseArray = this.e;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("qqgift_combo.png");
    localSparseArray.put(paramInt, BitmapFactory.decodeFile(localStringBuilder.toString(), (BitmapFactory.Options)localObject));
    ((BitmapFactory.Options)localObject).outHeight = ImmersiveUtils.dpToPx(121.0F);
    ((BitmapFactory.Options)localObject).outWidth = ImmersiveUtils.dpToPx(58.0F);
    localSparseArray = this.f;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("qqgift_stimulate.png");
    localSparseArray.put(paramInt, BitmapFactory.decodeFile(localStringBuilder.toString(), (BitmapFactory.Options)localObject));
  }
  
  @Nullable
  public static BannerResManager b()
  {
    try
    {
      BannerResManager localBannerResManager = a;
      return localBannerResManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("animation.pag");
    this.h = PAGFile.Load(((StringBuilder)localObject).toString());
    localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqgift_combo_wave.pag");
    ((SparseArray)localObject).put(1, PAGFile.Load(localStringBuilder.toString()));
    localObject = this.g;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(3);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqgift_combo_wave.pag");
    ((SparseArray)localObject).put(3, PAGFile.Load(localStringBuilder.toString()));
    localObject = this.g;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(4);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqgift_combo_wave.pag");
    ((SparseArray)localObject).put(4, PAGFile.Load(localStringBuilder.toString()));
  }
  
  private void e()
  {
    SparseArray localSparseArray = new SparseArray();
    this.d.put(2, localSparseArray);
    localSparseArray.put(0, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847960));
    localSparseArray.put(1, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847961));
    localSparseArray.put(2, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847962));
    localSparseArray.put(3, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847963));
    localSparseArray.put(4, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847964));
    localSparseArray.put(5, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847965));
    localSparseArray.put(6, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847966));
    localSparseArray.put(7, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847967));
    localSparseArray.put(8, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847968));
    localSparseArray.put(9, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847969));
    localSparseArray.put(10, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847999));
    localSparseArray.put(11, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847973));
    f();
  }
  
  private void f()
  {
    this.e.put(2, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847974));
    this.f.put(2, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130847998));
  }
  
  private void g()
  {
    if ((PAGFile)this.i.get(2) == null)
    {
      PAGFile localPAGFile = j(2131230833);
      this.i.put(2, localPAGFile);
    }
  }
  
  private void h()
  {
    if ((PAGFile)this.g.get(2) == null)
    {
      PAGFile localPAGFile = j(2131230834);
      this.g.put(2, localPAGFile);
    }
  }
  
  private Bitmap i(int paramInt)
  {
    SparseArray localSparseArray = (SparseArray)this.d.get(2);
    if (localSparseArray != null) {
      return (Bitmap)localSparseArray.get(paramInt);
    }
    return null;
  }
  
  /* Error */
  private PAGFile j(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 164	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 222	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   6: iload_1
    //   7: invokevirtual 260	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 266	java/io/InputStream:available	()I
    //   15: istore_1
    //   16: iload_1
    //   17: ifgt +18 -> 35
    //   20: ldc 80
    //   22: iconst_1
    //   23: ldc_w 268
    //   26: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_2
    //   30: invokestatic 274	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   33: aconst_null
    //   34: areturn
    //   35: iload_1
    //   36: newarray byte
    //   38: astore_3
    //   39: aload_2
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_1
    //   43: invokevirtual 278	java/io/InputStream:read	([BII)I
    //   46: pop
    //   47: aload_3
    //   48: invokestatic 281	org/libpag/PAGFile:Load	([B)Lorg/libpag/PAGFile;
    //   51: astore_3
    //   52: aload_2
    //   53: invokestatic 274	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   56: aload_3
    //   57: areturn
    //   58: astore_3
    //   59: goto +20 -> 79
    //   62: astore_3
    //   63: ldc 80
    //   65: iconst_1
    //   66: ldc_w 283
    //   69: aload_3
    //   70: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_2
    //   74: invokestatic 274	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   77: aconst_null
    //   78: areturn
    //   79: aload_2
    //   80: invokestatic 274	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   83: aload_3
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	BannerResManager
    //   0	85	1	paramInt	int
    //   10	70	2	localInputStream	java.io.InputStream
    //   38	19	3	localObject1	Object
    //   58	1	3	localObject2	Object
    //   62	22	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   11	16	58	finally
    //   20	29	58	finally
    //   35	52	58	finally
    //   63	73	58	finally
    //   11	16	62	java/lang/Throwable
    //   20	29	62	java/lang/Throwable
    //   35	52	62	java/lang/Throwable
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    Object localObject1 = (SparseArray)this.d.get(paramInt1);
    if (localObject1 != null) {
      localObject1 = (Bitmap)((SparseArray)localObject1).get(paramInt2);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = i(paramInt2);
    }
    return localObject2;
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    QQGiftResourceBusiness localQQGiftResourceBusiness = this.c;
    localStringBuilder.append(localQQGiftResourceBusiness.e(localQQGiftResourceBusiness.a(paramInt, 2)));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("banner.pag");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    try
    {
      QLog.i("BannerResManager", 1, "release");
      a = null;
      this.d.clear();
      this.e.clear();
      this.f.clear();
      this.g.clear();
      this.i.clear();
      this.h = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, IQQGiftAnimationResDownloadCallback paramIQQGiftAnimationResDownloadCallback)
  {
    this.b.b(paramInt, new BannerResManager.3(this, paramInt));
  }
  
  public void a(String paramString, LoadHeadListener paramLoadHeadListener)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ImmersiveUtils.dpToPx(40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
    paramString = a(paramString, (URLDrawable.URLDrawableOptions)localObject);
    if (paramString == null) {
      return;
    }
    localObject = paramString.getCurrDrawable();
    if ((localObject instanceof RegionDrawable)) {
      a(((RegionDrawable)localObject).getBitmap(), paramLoadHeadListener);
    }
    paramString.setURLDrawableListener(new BannerResManager.5(this, paramString, paramLoadHeadListener));
    paramString.startDownload(true);
  }
  
  public boolean b(int paramInt)
  {
    return new File(a(paramInt)).exists();
  }
  
  public Bitmap c(int paramInt)
  {
    return a(paramInt, 10);
  }
  
  public void c()
  {
    if (this.j != 0) {
      return;
    }
    this.j = 1;
    e();
    int k = QQGiftConfig.a().bannerDefaultMaterialId;
    if (k == -99)
    {
      this.j = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load banner material id error! id:");
      localStringBuilder.append(k);
      QLog.e("BannerResManager", 1, localStringBuilder.toString());
      return;
    }
    this.b.b(k, new BannerResManager.1(this));
  }
  
  public Bitmap d(int paramInt)
  {
    return a(paramInt, 11);
  }
  
  public PAGFile d()
  {
    return this.h;
  }
  
  public PAGFile e(int paramInt)
  {
    g();
    PAGFile localPAGFile2 = (PAGFile)this.i.get(paramInt);
    PAGFile localPAGFile1 = localPAGFile2;
    if (localPAGFile2 == null) {
      localPAGFile1 = (PAGFile)this.i.get(2);
    }
    if (localPAGFile1 == null) {
      QLog.e("BannerResManager", 1, "getBoomFilePath return null");
    }
    return localPAGFile1;
  }
  
  public Bitmap f(int paramInt)
  {
    Bitmap localBitmap2 = (Bitmap)this.f.get(paramInt);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = (Bitmap)this.f.get(2);
    }
    return localBitmap1;
  }
  
  public Bitmap g(int paramInt)
  {
    Bitmap localBitmap2 = (Bitmap)this.e.get(paramInt);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = (Bitmap)this.e.get(2);
    }
    return localBitmap1;
  }
  
  public PAGFile h(int paramInt)
  {
    h();
    PAGFile localPAGFile2 = (PAGFile)this.g.get(paramInt);
    PAGFile localPAGFile1 = localPAGFile2;
    if (localPAGFile2 == null) {
      localPAGFile1 = (PAGFile)this.g.get(2);
    }
    if (localPAGFile1 == null) {
      QLog.e("BannerResManager", 1, "getComboWavePag return null");
    }
    return localPAGFile1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager
 * JD-Core Version:    0.7.0.1
 */