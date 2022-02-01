package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQUserPersonalData;
import cooperation.qzone.util.QZLog;
import cooperation.vip.VipReporterManager;

class MsgPhotoView$3
  implements View.OnClickListener
{
  MsgPhotoView$3(MsgPhotoView paramMsgPhotoView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.this$0.mData.mqUserPersonalData;
    if (localObject1 == null)
    {
      QZLog.i("MsgPhotoView", 1, " vip icon click data = null");
      return;
    }
    switch (paramView.getId())
    {
    default: 
      paramView = "";
      break;
    case 2080571460: 
      localObject1 = ((MQUserPersonalData)localObject1).mYJumpUrl;
      Object localObject2 = paramView.getTag();
      paramView = (View)localObject1;
      if (localObject2 != null)
      {
        paramView = (View)localObject1;
        if ((localObject2 instanceof Boolean))
        {
          int i;
          if (((Boolean)localObject2).booleanValue()) {
            i = 11;
          } else {
            i = 10;
          }
          VipReporterManager.a(i, 2);
          paramView = (View)localObject1;
        }
      }
      break;
    case 2080571459: 
      paramView = ((MQUserPersonalData)localObject1).mBVJumpUrl;
      VipReporterManager.a(12, 2);
      break;
    case 2080571458: 
      paramView = ((MQUserPersonalData)localObject1).mLYJumpUrl;
      VipReporterManager.a(13, 2);
    }
    if (QZLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MsgVip vip icon click url = ");
      ((StringBuilder)localObject1).append(paramView);
      QZLog.i("MsgPhotoView", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new Intent(this.this$0.mContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView);
    ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_vip");
    this.this$0.mContext.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.3
 * JD-Core Version:    0.7.0.1
 */