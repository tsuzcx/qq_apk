package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class TroopAioMsgNavigateUnRead
  extends BaseAioMsgNavigateBarDelegate
{
  private TroopAioMsgNavigateBar a;
  
  public TroopAioMsgNavigateUnRead(QQAppInterface paramQQAppInterface, Context paramContext, TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 1;
    this.a = paramTroopAioMsgNavigateBar;
  }
  
  public int a(int paramInt)
  {
    return 2130853322;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    if (paramLong3 >= paramLong2) {}
    for (;;)
    {
      i = 0;
      break label140;
      if (paramInt2 >= 30) {
        break;
      }
      paramList = this.d.getMessageFacade().getLastMessage(this.f.b, this.f.a);
      if (paramList != null)
      {
        long l = paramList.shmsgseq;
        for (paramLong3 = 0L; paramLong3 < paramInt2; paramLong3 += 1L)
        {
          paramList = this.d.getMessageFacade().d(this.f.b, this.f.a, l);
          if ((paramList != null) && (paramList.msgtype != -2058) && (paramList.shmsgseq < paramLong2)) {
            break label137;
          }
          l -= 1L;
        }
      }
    }
    label137:
    int i = 1;
    label140:
    if (i != 0) {
      return new BaseAioMsgNavigateBarDelegate.Entity(true, String.format(this.e.getString(2131895597), new Object[] { Integer.valueOf(paramInt2) }), AioAgent.Message.a(paramInt1, paramLong1, paramInt2), "");
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView2.setVisibility(8);
    paramTextView2.setTextColor(this.e.getResources().getColor(2131167006));
    paramTextView1.setTextColor(this.e.getResources().getColor(2131167006));
    paramImageView.setBackgroundResource(2130853376);
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.f.a == 3000)
    {
      ReportController.b(this.d, "dc00899", "Grp_Dis", "", "Grp_AIO", "Appear_Oneclk_read", 0, 0, this.f.b, "", "", "");
      return;
    }
    ReportController.b(this.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.f.b, "", "", "");
    if (this.a != null) {
      ReportController.b(this.d, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_new_msg", 0, 0, this.f.b, String.valueOf(this.a.e), "", "");
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 15) && (paramInt2 <= 200);
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (this.f.a == 3000)
    {
      ReportController.b(this.d, "dc00899", "Grp_Dis", "", "Grp_AIO", "Clk_Oneclk_read", 0, 0, this.f.b, "", "", "");
      return;
    }
    ReportController.b(this.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.f.b, "", "", "");
    if (this.a != null) {
      ReportController.b(this.d, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_new_msg", 0, 0, this.f.b, String.valueOf(this.a.e), "", "");
    }
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUnRead
 * JD-Core Version:    0.7.0.1
 */