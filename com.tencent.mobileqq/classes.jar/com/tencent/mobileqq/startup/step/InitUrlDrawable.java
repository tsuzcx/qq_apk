package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pic.URLDrawableDepWrapInit;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.vas.theme.effect.QEffectApngImageView;
import com.tencent.mobileqq.vas.theme.effect.QEffectGifImageView;
import com.tencent.mobileqq.vas.theme.effect.QEffectLoad;
import com.tencent.mobileqq.vas.theme.effect.QEffectLottieImageView;
import com.tencent.qq.effect.engine.QEffectEngine;
import com.tencent.xaction.log.IQLog;

public class InitUrlDrawable
  extends Step
{
  public static DiskCache a;
  private static IQLog a;
  public static volatile boolean a = false;
  
  static
  {
    jdField_a_of_type_ComTencentXactionLogIQLog = new InitUrlDrawable.1();
  }
  
  protected boolean doStep()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    jdField_a_of_type_Boolean = true;
    com.tencent.xaction.log.QLog.a(jdField_a_of_type_ComTencentXactionLogIQLog);
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
    }
    catch (Throwable localThrowable)
    {
      com.tencent.qphone.base.util.QLog.e("AutoMonitor", 1, "", localThrowable);
    }
    jdField_a_of_type_ComTencentMobileqqTransfileDiskCache = AbsDownloader.sDiskCache;
    com.tencent.mobileqq.transfile.URLDrawableHelper.diskCachePath = jdField_a_of_type_ComTencentMobileqqTransfileDiskCache.getDirectory();
    JpegExifReader.initJpegExifReader(new InitUrlDrawable.JpegExifReaderOperator());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable
 * JD-Core Version:    0.7.0.1
 */