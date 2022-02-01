package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.dinifly.DiniFlyLog;
import com.tencent.mobileqq.dinifly.IDiniFlyQLog;
import com.tencent.mobileqq.pic.URLDrawableDepWrapInit;
import com.tencent.mobileqq.theme.effect.QEffectApngImageView;
import com.tencent.mobileqq.theme.effect.QEffectGifImageView;
import com.tencent.mobileqq.theme.effect.QEffectLoad;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.engine.QEffectEngine;

public class InitUrlDrawable
  extends Step
{
  private static IDiniFlyQLog a;
  public static DiskCache a;
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqDiniflyIDiniFlyQLog = new InitUrlDrawable.1();
  }
  
  protected boolean doStep()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    jdField_a_of_type_Boolean = true;
    DiniFlyLog.setLog(jdField_a_of_type_ComTencentMobileqqDiniflyIDiniFlyQLog);
    QEffectEngine.getInstance().setJsonConvert(new InitUrlDrawable.QEffectJsonConvert());
    QEffectEngine.getInstance().registerLoad(new QEffectLoad());
    QEffectEngine.getInstance().registerEffect(2, "a.png", QEffectApngImageView.class);
    QEffectEngine.getInstance().registerEffect(3, "lottie", QEffectLottieImageView.class);
    QEffectEngine.getInstance().registerEffect(8, "gif", QEffectGifImageView.class);
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    URLDrawable.DEBUG = false;
    try
    {
      URLDrawable.init(URLDrawableDepWrapInit.a(), new InitUrlDrawable.URLDrawableFactory(localBaseApplicationImpl));
      jdField_a_of_type_ComTencentMobileqqTransfileDiskCache = AbsDownloader.sDiskCache;
      com.tencent.mobileqq.transfile.URLDrawableHelper.diskCachePath = jdField_a_of_type_ComTencentMobileqqTransfileDiskCache.getDirectory();
      JpegExifReader.initJpegExifReader(new InitUrlDrawable.JpegExifReaderOperator());
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AutoMonitor", 1, "", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable
 * JD-Core Version:    0.7.0.1
 */