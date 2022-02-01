package cooperation.qzone.contentbox;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;

class QZoneMsgFragment$2
  extends BroadcastReceiver
{
  QZoneMsgFragment$2(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j;
    int k;
    boolean bool;
    int i;
    if (paramIntent.getAction() == "com.qzone.sync_comment_like")
    {
      j = paramIntent.getIntExtra("sync_comment_commentnum", 0);
      paramContext = paramIntent.getStringExtra("sync_comment_likekey");
      k = paramIntent.getIntExtra("sync_comment_likenum", 0);
      bool = paramIntent.getBooleanExtra("sync_comment_haslike", false);
      if ((this.this$0.adapter != null) && (!TextUtils.isEmpty(paramContext))) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.this$0.adapter.getCount())
      {
        paramIntent = (MQMsg)this.this$0.adapter.getItem(i);
        if ((paramIntent != null) && (paramIntent.msgInteractData != null) && (paramIntent.msgInteractData.likeCell != null) && (paramIntent.msgInteractData.likeCell.likeKey.equals(paramContext)))
        {
          paramIntent.msgInteractData.likeCell.totalLike = k;
          paramIntent.msgInteractData.totalComment = j;
          paramIntent.msgInteractData.likeCell.liked = bool;
          ((QZoneMsgManager)this.this$0.app.getManager(QQManagerFactory.QZONE_MSG_MANAGER)).saveMsgToDB(paramIntent);
        }
      }
      else
      {
        this.this$0.adapter.notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.2
 * JD-Core Version:    0.7.0.1
 */