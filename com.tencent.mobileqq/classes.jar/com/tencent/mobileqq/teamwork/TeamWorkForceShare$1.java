package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import anvx;
import bisl;
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
    if ((this.a == null) || (this.a.isRecycled()))
    {
      QLog.d(TeamWorkForceShare.a(), 1, "decode image failed, url = " + TeamWorkForceShare.a(this.this$0));
      QQToast.a(TeamWorkForceShare.a(this.this$0), anvx.a(2131714178), 0).a();
      return;
    }
    if (TeamWorkForceShare.a(this.this$0) == null)
    {
      TeamWorkForceShare.a(this.this$0).getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
      Object localObject = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject).context = TeamWorkForceShare.a(this.this$0);
      ((ShareActionSheetV2.Param)localObject).fullScreen = false;
      TeamWorkForceShare.a(this.this$0, ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject));
      localObject = new Intent();
      ((Intent)localObject).putExtra("forward_type", -3);
      ((Intent)localObject).putExtra("key_share_data_line_support_type", 1);
      TeamWorkForceShare.a(this.this$0).setIntentForStartForwardRecentActivity((Intent)localObject);
      TeamWorkForceShare.a(this.this$0).setActionSheetItems(this.this$0.a(), this.this$0.b());
      TeamWorkForceShare.a(this.this$0).setItemClickListenerV2(this.this$0);
      TeamWorkForceShare.a(this.this$0).setCancelListener(this.this$0);
      TeamWorkForceShare.a(this.this$0).setRowVisibility(0, 0, 0);
    }
    TeamWorkForceShare.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.1
 * JD-Core Version:    0.7.0.1
 */