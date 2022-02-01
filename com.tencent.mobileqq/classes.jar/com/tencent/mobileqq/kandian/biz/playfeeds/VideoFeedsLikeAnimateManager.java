package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.LikeAnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import mqq.app.AppRuntime;

public class VideoFeedsLikeAnimateManager
{
  private static int jdField_a_of_type_Int;
  private static URLDrawable[] jdField_a_of_type_ArrayOfComTencentImageURLDrawable;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private VideoFeedsLikeAnimateHandler jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateHandler;
  private VideoFeedsLikeAnimateManager.LikeAnimateObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager$LikeAnimateObserver;
  private LikeAnimationInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoLikeAnimationInfo;
  private Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public VideoFeedsLikeAnimateManager(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290));
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        return;
      }
      this.jdField_a_of_type_ArrayOfInt = new int[2];
      jdField_a_of_type_Int = AIOUtils.b(28.0F, paramActivity.getResources());
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilRandom = new Random();
      paramActivity = a();
      if (paramActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateHandler = ((VideoFeedsLikeAnimateHandler)paramActivity.getBusinessHandler(BusinessHandlerFactory.VIDEO_FEEDS_LIKE_ANIMATION_CONFIG));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager$LikeAnimateObserver = new VideoFeedsLikeAnimateManager.LikeAnimateObserver(this);
        paramActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager$LikeAnimateObserver);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoLikeAnimationInfo = ReadInJoyHelper.a();
      paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoLikeAnimationInfo;
      if (paramActivity != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateHandler != null) && (ReadInJoyHelper.a(paramActivity.jdField_a_of_type_Int)))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateHandler.a(paramInt);
          ReadInJoyHelper.a(System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsLikeAnimateManager", 2, "fetch icon list");
          }
        }
        else
        {
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoLikeAnimationInfo, false);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsLikeAnimateManager", 2, "use local icon list");
          }
        }
      }
      else
      {
        paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateHandler;
        if (paramActivity != null)
        {
          paramActivity.a(paramInt);
          ReadInJoyHelper.a(System.currentTimeMillis());
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsLikeAnimateManager", 2, "activity in a invalid state");
    }
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(LikeAnimationInfo paramLikeAnimationInfo, boolean paramBoolean)
  {
    if ((paramLikeAnimationInfo != null) && (paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString != null))
    {
      if (paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length == 0) {
        return;
      }
      if ((jdField_a_of_type_ArrayOfComTencentImageURLDrawable != null) && (!paramBoolean))
      {
        QLog.d("VideoFeedsLikeAnimateManager", 1, "use cache icon");
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = jdField_a_of_type_Int;
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      jdField_a_of_type_ArrayOfComTencentImageURLDrawable = new URLDrawable[paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length];
      i = 0;
      while (i < paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        String str = paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString[i];
        if (!TextUtils.isEmpty(str)) {}
        try
        {
          localObject = URLDrawable.getDrawable(new URL(str), localURLDrawableOptions);
          ((URLDrawable)localObject).startDownload();
          jdField_a_of_type_ArrayOfComTencentImageURLDrawable[i] = localObject;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          Object localObject;
          label129:
          break label129;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("illegal url format: ");
          ((StringBuilder)localObject).append(str);
          QLog.d("VideoFeedsLikeAnimateManager", 2, ((StringBuilder)localObject).toString());
        }
        i += 1;
      }
      QLog.d("VideoFeedsLikeAnimateManager", 1, "start download icon");
    }
    else
    {
      return;
    }
  }
  
  private boolean a()
  {
    Object localObject1 = jdField_a_of_type_ArrayOfComTencentImageURLDrawable;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return false;
      }
      int m = localObject1.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        Object localObject2 = localObject1[i];
        k = j;
        if (localObject2 != null)
        {
          k = j;
          if (localObject2.getStatus() == 1) {
            k = j + 1;
          }
        }
        i += 1;
      }
      if (j == jdField_a_of_type_ArrayOfComTencentImageURLDrawable.length) {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isHit: ");
        ((StringBuilder)localObject1).append(bool1);
        QLog.d("VideoFeedsLikeAnimateManager", 2, ((StringBuilder)localObject1).toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public int a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager$LikeAnimateObserver);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLikeAnimateManager", 2, "parent view is null");
      }
      return;
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    localObject = new VideoFeedsLikeAnimate((ViewGroup)localObject, paramFloat1 - arrayOfInt[0], paramFloat2 - arrayOfInt[1], this.jdField_a_of_type_JavaUtilRandom);
    if (a())
    {
      ((VideoFeedsLikeAnimate)localObject).a(jdField_a_of_type_ArrayOfComTencentImageURLDrawable, 4, jdField_a_of_type_Int);
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      ((VideoFeedsLikeAnimate)localObject).a(5);
      this.jdField_a_of_type_Boolean = false;
    }
    ((VideoFeedsLikeAnimate)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimateManager
 * JD-Core Version:    0.7.0.1
 */