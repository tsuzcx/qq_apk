package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInjoyFloatingWindowHelper;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class RIJDailyPopupStep
  extends BasePopupStep
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean = false;
  
  public RIJDailyPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJDailyPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private boolean b()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject1 == null) {
      localObject1 = new Intent();
    } else {
      localObject1 = ((Activity)localObject1).getIntent();
    }
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localObject1 != null)
    {
      bool1 = bool3;
      if (((Intent)localObject1).hasExtra("arg_channel_rowkey"))
      {
        bool1 = bool3;
        if (((Intent)localObject1).hasExtra("arg_channel_article_url"))
        {
          String str1 = ((Intent)localObject1).getStringExtra("arg_channel_rowkey");
          String str2 = ((Intent)localObject1).getStringExtra("arg_channel_article_url");
          bool1 = bool2;
          if (!TextUtils.isEmpty(str1))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(str2))
            {
              Object localObject2 = new Bundle();
              ((Bundle)localObject2).putString("floating_window_rowkey", str1);
              ((Bundle)localObject2).putString("float_layer_article_url", str2);
              ReadInjoyFloatingWindowHelper.a(this.jdField_a_of_type_AndroidAppActivity, 5, 1, (Bundle)localObject2, 0);
              localObject2 = this.jdField_a_of_type_AndroidAppActivity;
              if (localObject2 != null)
              {
                localObject2 = (RIJTabFrameBase)RIJJumpUtils.a((Context)localObject2);
                if (localObject2 != null) {
                  ((RIJTabFrameBase)localObject2).b(32);
                }
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[handleDailyJumpToRecommendChannel], open floating window, rowKey = ");
              ((StringBuilder)localObject2).append(str1);
              ((StringBuilder)localObject2).append(", articleURL = ");
              ((StringBuilder)localObject2).append(str2);
              QLog.i("RIJDailyPopupStep", 1, ((StringBuilder)localObject2).toString());
              bool1 = true;
            }
          }
          ((Intent)localObject1).removeExtra("arg_channel_rowkey");
          ((Intent)localObject1).removeExtra("arg_channel_article_url");
        }
      }
    }
    return bool1;
  }
  
  protected void g()
  {
    a(this.jdField_a_of_type_Boolean);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_Boolean = b();
    a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJDailyPopupStep
 * JD-Core Version:    0.7.0.1
 */