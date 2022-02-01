package com.tencent.mobileqq.minigame.publicaccount;

import albi;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import avfh;
import avft;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class MiniGamePublicAccountWebFragment$1$1
  implements Runnable
{
  MiniGamePublicAccountWebFragment$1$1(MiniGamePublicAccountWebFragment.1 param1, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    Object localObject;
    if (this.val$result.code == 0)
    {
      localObject = this.val$result.data;
      if (localObject != null)
      {
        MiniGamePublicAccountWebFragment.access$002(this.this$1.this$0, (List)((Bundle)localObject).getSerializable("key_msg_list"));
        if (MiniGamePublicAccountWebFragment.access$000(this.this$1.this$0) == null) {
          MiniGamePublicAccountWebFragment.access$002(this.this$1.this$0, new ArrayList());
        }
      }
    }
    int i = MiniGamePublicAccountWebFragment.access$000(this.this$1.this$0).size();
    if (i > 0)
    {
      localObject = MiniGamePublicAccountWebFragment.access$000(this.this$1.this$0).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)((Iterator)localObject).next();
        avfh localavfh = avft.a(localQQGameMsgInfo, this.this$1.this$0.getActivity());
        this.this$1.this$0.mHeaderRecords.add(localavfh);
        if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName))
        {
          albi.a().a(localQQGameMsgInfo.arkAppName);
          MiniGamePublicAccountWebFragment.access$100(this.this$1.this$0).add(localQQGameMsgInfo.arkAppName);
        }
      }
      albi.a().a(MiniGamePublicAccountWebFragment.access$100(this.this$1.this$0));
      if ((this.this$1.this$0.mHeaderRecords != null) && (this.this$1.this$0.mHeaderRecords.size() < 0)) {
        MiniGamePublicAccountWebFragment.access$202(this.this$1.this$0, (avfh)this.this$1.this$0.mHeaderRecords.get(0));
      }
      MiniGamePublicAccountWebFragment.access$300(this.this$1.this$0).setVisibility(8);
      MiniGamePublicAccountWebFragment.access$400(this.this$1.this$0).setVisibility(0);
      this.this$1.this$0.notifyWebHeaderHeight(MiniGamePublicAccountWebFragment.access$500(this.this$1.this$0));
      MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_news_more", "expo", null);
      MiniGamePublicAccountWebFragment.access$602(this.this$1.this$0, new ArrayList(Collections.nCopies(i, Boolean.valueOf(false))));
      MiniGamePublicAccountWebFragment.access$702(this.this$1.this$0, new ArrayList(Collections.nCopies(i, Boolean.valueOf(false))));
      MiniGamePublicAccountWebFragment.access$800(this.this$1.this$0, 0);
      MiniGamePublicAccountWebFragment.access$900(this.this$1.this$0, 0, false);
      return;
    }
    MiniGamePublicAccountWebFragment.access$400(this.this$1.this$0).setVisibility(8);
    MiniGamePublicAccountWebFragment.access$300(this.this$1.this$0).setVisibility(0);
    this.this$1.this$0.notifyWebHeaderHeight(MiniGamePublicAccountWebFragment.access$500(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.1.1
 * JD-Core Version:    0.7.0.1
 */