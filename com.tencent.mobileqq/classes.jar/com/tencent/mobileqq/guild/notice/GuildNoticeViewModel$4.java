package com.tencent.mobileqq.guild.notice;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.callback.IGetMoreNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GuildNoticeViewModel$4
  implements IGetMoreNoticeListCallback
{
  GuildNoticeViewModel$4(GuildNoticeViewModel paramGuildNoticeViewModel) {}
  
  public void a(int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, List<GuildNotice> paramList)
  {
    if (paramInt1 == 0)
    {
      GuildNoticeViewModel.c(this.a).setValue(Boolean.valueOf(paramBoolean2));
      GuildNoticeViewModel.a(this.a, paramInt2);
      paramString = paramList;
      if (paramList == null) {
        paramString = new ArrayList();
      }
      if (paramBoolean1)
      {
        GuildNoticeViewModel.b(this.a).setValue(GuildNoticeViewModel.a(this.a, paramString));
      }
      else
      {
        List localList1 = (List)GuildNoticeViewModel.b(this.a).getValue();
        if (localList1 == null)
        {
          paramList = GuildNoticeViewModel.a(this.a, paramString);
        }
        else
        {
          List localList2 = GuildNoticeViewModel.a(this.a, paramString);
          Iterator localIterator = localList2.iterator();
          for (;;)
          {
            paramList = localList1;
            paramString = localList2;
            if (!localIterator.hasNext()) {
              break;
            }
            paramString = (GuildNotice)localIterator.next();
            if (!localList1.contains(paramString))
            {
              localList1.add(paramString);
            }
            else
            {
              paramList = new StringBuilder();
              paramList.append("onGetMoreGuildNoticeList find same item:");
              paramList.append(paramString.toString());
              QLog.d("GuildNoticeViewModel", 1, paramList.toString());
            }
          }
        }
        GuildNoticeViewModel.b(this.a).setValue(paramList);
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onGetMoreGuildNoticeList listOffset=");
        paramList.append(paramInt2);
        paramList.append(" isEnd=");
        paramList.append(paramBoolean2);
        paramList.append(" data size=");
        paramList.append(paramString.size());
        QLog.d("GuildNoticeViewModel", 1, paramList.toString());
      }
    }
    GuildNoticeViewModel.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeViewModel.4
 * JD-Core Version:    0.7.0.1
 */