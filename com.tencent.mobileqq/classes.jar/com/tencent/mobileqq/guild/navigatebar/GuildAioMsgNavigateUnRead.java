package com.tencent.mobileqq.guild.navigatebar;

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
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBarDelegate;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBarDelegate.Entity;
import java.util.List;

public class GuildAioMsgNavigateUnRead
  extends BaseAioMsgNavigateBarDelegate
{
  public GuildAioMsgNavigateUnRead(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 1;
  }
  
  public int a(int paramInt)
  {
    return 2130853322;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    int i;
    if (paramInt2 < 30)
    {
      paramList = this.d.getMessageFacade().getLastMessage(this.f.b, this.f.a);
      if (paramList != null)
      {
        paramLong3 = paramList.shmsgseq;
        for (paramLong2 = 0L; paramLong2 < paramInt2; paramLong2 += 1L)
        {
          paramList = this.d.getMessageFacade().d(this.f.b, this.f.a, paramLong3);
          if ((paramList != null) && (paramList.msgtype != -2058)) {
            break label119;
          }
          paramLong3 -= 1L;
        }
      }
      i = 0;
    }
    else
    {
      label119:
      i = 1;
    }
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
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 >= 15;
  }
  
  public void b(int paramInt, Object paramObject, String paramString) {}
  
  public boolean b(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateUnRead
 * JD-Core Version:    0.7.0.1
 */