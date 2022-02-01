package com.tencent.mobileqq.kandian.biz.daily;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DailyDynamicHeaderBackgroundController
{
  public static void a(Drawable paramDrawable)
  {
    if (!a())
    {
      QLog.i("DailyDynamicHeaderBackgroundController", 1, "blurBackground, isNeedToBlurBackground : NO");
      return;
    }
    if ((paramDrawable instanceof URLDrawable)) {
      ((URLDrawable)paramDrawable).setDecodeHandler(new DailyDynamicHeaderBackgroundController.1());
    }
  }
  
  public static void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (b())
    {
      paramImageView.setColorFilter(855638016, PorterDuff.Mode.DARKEN);
      return;
    }
    paramImageView.clearColorFilter();
  }
  
  private static boolean a()
  {
    Object localObject = (ReadInJoyLogicManager)((QQAppInterface)ReadInJoyUtils.a()).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().a();
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("is_blur_background", "0");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedToBlurBackground, isBlurBackground = ");
        localStringBuilder.append((String)localObject);
        QLog.i("DailyDynamicHeaderBackgroundController", 1, localStringBuilder.toString());
        return "1".equals(localObject);
      }
    }
    return false;
  }
  
  private static boolean b()
  {
    Object localObject = (ReadInJoyLogicManager)((QQAppInterface)ReadInJoyUtils.a()).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().a();
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("is_cover_background", "0");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedGrayLayer, isCoverBackground = ");
        localStringBuilder.append((String)localObject);
        QLog.i("DailyDynamicHeaderBackgroundController", 1, localStringBuilder.toString());
        return "1".equals(localObject);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderBackgroundController
 * JD-Core Version:    0.7.0.1
 */