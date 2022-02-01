package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;

class TeamWorkForceShare$1
  implements Runnable
{
  TeamWorkForceShare$1(TeamWorkForceShare paramTeamWorkForceShare, Bitmap paramBitmap) {}
  
  public void run()
  {
    TeamWorkForceShare.a(this.this$0).dismiss();
    Object localObject = this.a;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      if (TeamWorkForceShare.d(this.this$0) == null)
      {
        TeamWorkForceShare.c(this.this$0).getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localObject = new ShareActionSheetV2.Param();
        ((ShareActionSheetV2.Param)localObject).context = TeamWorkForceShare.c(this.this$0);
        ((ShareActionSheetV2.Param)localObject).fullScreen = false;
        TeamWorkForceShare.a(this.this$0, ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject));
        localObject = new Intent();
        ((Intent)localObject).putExtra("forward_type", -3);
        ((Intent)localObject).putExtra("key_share_data_line_support_type", 1);
        TeamWorkForceShare.d(this.this$0).setIntentForStartForwardRecentActivity((Intent)localObject);
        TeamWorkForceShare.d(this.this$0).setActionSheetItems(this.this$0.b(), this.this$0.c());
        TeamWorkForceShare.d(this.this$0).setItemClickListenerV2(this.this$0);
        TeamWorkForceShare.d(this.this$0).setCancelListener(this.this$0);
        TeamWorkForceShare.d(this.this$0).setRowVisibility(0, 0, 0);
      }
      TeamWorkForceShare.d(this.this$0).show();
      return;
    }
    localObject = TeamWorkForceShare.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("decode image failed, url = ");
    localStringBuilder.append(TeamWorkForceShare.b(this.this$0));
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    QQToast.makeText(TeamWorkForceShare.c(this.this$0), HardCodeUtil.a(2131912112), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.1
 * JD-Core Version:    0.7.0.1
 */