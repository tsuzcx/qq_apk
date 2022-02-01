package cooperation.qzone.contentbox;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qzonehub.api.IQzoneRuntimeService;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QZoneMsgFragment$2
  extends BroadcastReceiver
{
  QZoneMsgFragment$2(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == "com.qzone.sync_comment_like")
    {
      int i = 0;
      int j = paramIntent.getIntExtra("sync_comment_commentnum", 0);
      paramContext = paramIntent.getStringExtra("sync_comment_likekey");
      int k = paramIntent.getIntExtra("sync_comment_likenum", 0);
      boolean bool = paramIntent.getBooleanExtra("sync_comment_haslike", false);
      if ((this.this$0.adapter != null) && (!TextUtils.isEmpty(paramContext)))
      {
        while (i < this.this$0.adapter.getCount())
        {
          paramIntent = (MQMsg)this.this$0.adapter.getItem(i);
          if ((paramIntent != null) && (paramIntent.msgInteractData != null) && (paramIntent.msgInteractData.likeCell != null) && (paramIntent.msgInteractData.likeCell.likeKey.equals(paramContext)))
          {
            paramIntent.msgInteractData.likeCell.totalLike = k;
            paramIntent.msgInteractData.totalComment = j;
            paramIntent.msgInteractData.likeCell.liked = bool;
            paramContext = MobileQQ.sMobileQQ.peekAppRuntime();
            if (paramContext == null) {
              break;
            }
            ((IQzoneRuntimeService)paramContext.getRuntimeService(IQzoneRuntimeService.class, "")).saveMsgToDB(paramIntent);
            break;
          }
          i += 1;
        }
        this.this$0.adapter.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.2
 * JD-Core Version:    0.7.0.1
 */