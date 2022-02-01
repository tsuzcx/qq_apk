package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;

public class QQVipArkHeaderView
  extends RelativeLayout
  implements IHeaderView
{
  private QvipArkView a;
  private int b;
  private QQVipMsgInfo c;
  
  public QQVipArkHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131625615, this);
    this.a = ((QvipArkView)findViewById(2131442586));
    this.a.setmQqVipArkHeaderView(this);
    this.a.addOnLayoutChangeListener(new QQVipArkHeaderView.1(this));
  }
  
  public void a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity, int paramInt)
  {
    paramActivity = this.a;
    if (paramActivity != null)
    {
      this.b = paramInt;
      this.c = paramQQVipMsgInfo;
      paramActivity.load(paramQQVipMsgInfo.mArkAppName, paramQQVipMsgInfo.mArkAppView, paramQQVipMsgInfo.mArkAppMinVersion, paramQQVipMsgInfo.mArkMetaList, paramQQVipMsgInfo.mArkAppConfig, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipArkHeaderView
 * JD-Core Version:    0.7.0.1
 */