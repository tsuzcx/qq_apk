package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vas.qvip.util.ReportAmsAdvHelper;

public class QQVipArkHeaderView
  extends RelativeLayout
  implements IHeaderView
{
  private int jdField_a_of_type_Int;
  private QQVipMsgInfo jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo;
  private QvipArkView jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView;
  
  public QQVipArkHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131559586, this);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView = ((QvipArkView)findViewById(2131374419));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView.setmQqVipArkHeaderView(this);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView.addOnLayoutChangeListener(new QQVipArkHeaderView.1(this));
  }
  
  public void a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity, int paramInt)
  {
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView;
    if (paramActivity != null)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo = paramQQVipMsgInfo;
      paramActivity.load(paramQQVipMsgInfo.mArkAppName, paramQQVipMsgInfo.mArkAppView, paramQQVipMsgInfo.mArkAppMinVersion, paramQQVipMsgInfo.mArkMetaList, paramQQVipMsgInfo.mArkAppConfig, null);
      if (paramQQVipMsgInfo.mIsAmsAdv) {
        ReportAmsAdvHelper.a(103, paramQQVipMsgInfo.mAmsMessageExposeUrl);
      }
      try
      {
        QQVipHelper.a(117, paramQQVipMsgInfo, paramInt);
        return;
      }
      catch (Throwable paramQQVipMsgInfo)
      {
        paramQQVipMsgInfo.printStackTrace();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipArkHeaderView
 * JD-Core Version:    0.7.0.1
 */