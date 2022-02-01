package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor;
import com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor.InflateParams;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class VideoFeedsResourceLoader
{
  private static int jdField_a_of_type_Int;
  private static LayoutInflateProcessor jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor;
  private static HashMap<Integer, Drawable> jdField_a_of_type_JavaUtilHashMap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  public VideoFeedsResourceLoader(Context paramContext)
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor = new LayoutInflateProcessor(paramContext.getApplicationContext());
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    jdField_a_of_type_Int += 1;
    a(paramContext);
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaUtilHashMap;
    if (localObject == null) {
      return null;
    }
    if (((HashMap)localObject).containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    try
    {
      paramContext = paramContext.getResources().getDrawable(paramInt);
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramContext);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("innerGetDrawableFromCache() OutOfMemoryError e=");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.d("VideoFeedsResourceLoader", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static View a(int paramInt, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor;
    if (localObject != null) {
      return ((LayoutInflateProcessor)localObject).a(paramInt, paramBoolean, paramLayoutParams);
    }
    if (paramBoolean)
    {
      localObject = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(paramInt, null, false);
      ((View)localObject).setLayoutParams(paramLayoutParams);
      return localObject;
    }
    return null;
  }
  
  private LayoutInflateProcessor.InflateParams a()
  {
    return new LayoutInflateProcessor.InflateParams(2131560337, null, new VideoFeedsResourceLoader.2(this));
  }
  
  private LayoutInflateProcessor.InflateParams a(int paramInt)
  {
    if (ReadInJoyHelper.b()) {
      return new LayoutInflateProcessor.InflateParams(2131560357, paramInt, null, new VideoFeedsResourceLoader.3(this));
    }
    return new LayoutInflateProcessor.InflateParams(2131560341, paramInt, null, new VideoFeedsResourceLoader.4(this));
  }
  
  public static LayoutInflateProcessor a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor;
  }
  
  private void a(Context paramContext)
  {
    ThreadManager.excute(new VideoFeedsResourceLoader.1(this, new WeakReference(paramContext)), 16, null, true);
  }
  
  public void a()
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor;
    if (localObject != null) {
      ((LayoutInflateProcessor)localObject).a();
    }
    localObject = jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int <= 0)
    {
      jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor = null;
      jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  public void a(int paramInt)
  {
    LayoutInflateProcessor.InflateParams localInflateParams1;
    if (paramInt == 0) {
      localInflateParams1 = new LayoutInflateProcessor.InflateParams(2131560373, null, null);
    } else {
      localInflateParams1 = null;
    }
    LayoutInflateProcessor.InflateParams localInflateParams2 = new LayoutInflateProcessor.InflateParams(2131560115, null, null);
    LayoutInflateProcessor.InflateParams localInflateParams3 = new LayoutInflateProcessor.InflateParams(2131560269, null, null);
    LayoutInflateProcessor.InflateParams localInflateParams4 = a(1);
    LayoutInflateProcessor.InflateParams localInflateParams5 = a();
    LayoutInflateProcessor.InflateParams localInflateParams6 = a(2);
    jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor.a(new LayoutInflateProcessor.InflateParams[] { localInflateParams1, localInflateParams2, localInflateParams3, localInflateParams4, localInflateParams5, localInflateParams6 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsResourceLoader
 * JD-Core Version:    0.7.0.1
 */