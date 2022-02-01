package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import bkyt;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQUserPersonalData;
import cooperation.qzone.util.QZLog;

class MsgPhotoView$3
  implements View.OnClickListener
{
  MsgPhotoView$3(MsgPhotoView paramMsgPhotoView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.this$0.mData.mqUserPersonalData;
    if (localObject == null)
    {
      QZLog.i("MsgPhotoView", 1, " vip icon click data = null");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = "";
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("MsgPhotoView", 2, "MsgVip vip icon click url = " + str);
      }
      localObject = new Intent(this.this$0.mContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", str);
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_vip");
      this.this$0.mContext.startActivity((Intent)localObject);
      break;
      str = ((MQUserPersonalData)localObject).mBVJumpUrl;
      bkyt.a(12, 2);
      continue;
      str = ((MQUserPersonalData)localObject).mYJumpUrl;
      localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof Boolean)))
      {
        if (((Boolean)localObject).booleanValue()) {}
        for (int i = 11;; i = 10)
        {
          bkyt.a(i, 2);
          break;
        }
        str = ((MQUserPersonalData)localObject).mLYJumpUrl;
        bkyt.a(13, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.3
 * JD-Core Version:    0.7.0.1
 */