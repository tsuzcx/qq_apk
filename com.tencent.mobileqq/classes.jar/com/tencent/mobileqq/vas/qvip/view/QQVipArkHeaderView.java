package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import bicz;
import bidb;
import bide;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;

public class QQVipArkHeaderView
  extends RelativeLayout
  implements bidb
{
  private int jdField_a_of_type_Int;
  private QQVipMsgInfo jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo;
  private QvipArkView jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView;
  
  public QQVipArkHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131559597, this);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView = ((QvipArkView)findViewById(2131374508));
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView.setmQqVipArkHeaderView(this);
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView.addOnLayoutChangeListener(new bide(this));
  }
  
  public void a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView != null)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo = paramQQVipMsgInfo;
      this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQvipArkView.load(paramQQVipMsgInfo.arkAppName, paramQQVipMsgInfo.arkAppView, paramQQVipMsgInfo.arkAppMinVersion, paramQQVipMsgInfo.arkMetaList, paramQQVipMsgInfo.arkAppConfig, null);
    }
    try
    {
      bicz.a(117, paramQQVipMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramQQVipMsgInfo)
    {
      paramQQVipMsgInfo.printStackTrace();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipArkHeaderView
 * JD-Core Version:    0.7.0.1
 */