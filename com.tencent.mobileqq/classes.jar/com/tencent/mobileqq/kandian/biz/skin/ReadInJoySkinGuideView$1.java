package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

class ReadInJoySkinGuideView$1
  implements Runnable
{
  ReadInJoySkinGuideView$1(ReadInJoySkinGuideView paramReadInJoySkinGuideView, QQAppInterface paramQQAppInterface, String paramString1, View.OnClickListener paramOnClickListener1, String paramString2, View.OnClickListener paramOnClickListener2, Context paramContext, int paramInt) {}
  
  public void run()
  {
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.a.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    new SceneBuilder().a(this.b).a((int)DeviceInfoUtil.F()).a(new ReadInJoySkinGuideView.1.2(this)).a(this.this$0.a, new ReadInJoySkinGuideView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView.1
 * JD-Core Version:    0.7.0.1
 */