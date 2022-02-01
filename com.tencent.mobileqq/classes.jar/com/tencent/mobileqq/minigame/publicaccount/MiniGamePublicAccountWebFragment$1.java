package com.tencent.mobileqq.minigame.publicaccount;

import akwh;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import auuq;
import auvc;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class MiniGamePublicAccountWebFragment$1
  implements EIPCResultCallback
{
  MiniGamePublicAccountWebFragment$1(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        MiniGamePublicAccountWebFragment.access$002(this.this$0, (List)paramEIPCResult.getSerializable("key_msg_list"));
        if (MiniGamePublicAccountWebFragment.access$000(this.this$0) == null) {
          MiniGamePublicAccountWebFragment.access$002(this.this$0, new ArrayList());
        }
      }
    }
    int i = MiniGamePublicAccountWebFragment.access$000(this.this$0).size();
    if (i > 0)
    {
      paramEIPCResult = MiniGamePublicAccountWebFragment.access$000(this.this$0).iterator();
      while (paramEIPCResult.hasNext())
      {
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)paramEIPCResult.next();
        auuq localauuq = auvc.a(localQQGameMsgInfo, this.this$0.getActivity());
        this.this$0.mHeaderRecords.add(localauuq);
        if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName))
        {
          akwh.a().a(localQQGameMsgInfo.arkAppName);
          MiniGamePublicAccountWebFragment.access$100(this.this$0).add(localQQGameMsgInfo.arkAppName);
        }
      }
      akwh.a().a(MiniGamePublicAccountWebFragment.access$100(this.this$0));
      MiniGamePublicAccountWebFragment.access$200(this.this$0, 0);
      if ((this.this$0.mHeaderRecords != null) && (this.this$0.mHeaderRecords.size() < 0)) {
        MiniGamePublicAccountWebFragment.access$302(this.this$0, (auuq)this.this$0.mHeaderRecords.get(0));
      }
      this.this$0.getActivity().runOnUiThread(new MiniGamePublicAccountWebFragment.1.1(this));
      MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_news_more", "expo", null);
      MiniGamePublicAccountWebFragment.access$502(this.this$0, new ArrayList(Collections.nCopies(i, Boolean.valueOf(false))));
      MiniGamePublicAccountWebFragment.access$500(this.this$0).set(0, Boolean.valueOf(true));
      return;
    }
    this.this$0.getActivity().runOnUiThread(new MiniGamePublicAccountWebFragment.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.1
 * JD-Core Version:    0.7.0.1
 */