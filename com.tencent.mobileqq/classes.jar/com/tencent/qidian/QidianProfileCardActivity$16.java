package com.tencent.qidian;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qidian.data.PublicAccountItem;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QidianProfileCardActivity$16
  implements View.OnClickListener
{
  private long b = 0L;
  
  QidianProfileCardActivity$16(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.b) >= 1000L)
      {
        this.b = l;
        Object localObject1 = (DataTag)paramView.getTag();
        int i = ((DataTag)localObject1).a;
        if (i != 4)
        {
          Object localObject2;
          if (i != 20)
          {
            if (i != 82)
            {
              if (i != 106)
              {
                if (i != 7) {
                  if (i != 8) {
                    if (i != 75) {
                      if (i == 76) {}
                    }
                  }
                }
                switch (i)
                {
                default: 
                  break;
                case 55: 
                  this.a.f();
                  break;
                case 54: 
                  localObject1 = JumpParser.a(this.a.app, this.a, String.valueOf(((DataTag)localObject1).b));
                  if (localObject1 == null) {
                    break;
                  }
                  ((JumpAction)localObject1).a();
                  break;
                case 53: 
                  this.a.e();
                  break;
                case 52: 
                  this.a.a(String.valueOf(((DataTag)localObject1).b));
                  break;
                case 51: 
                  this.a.d(String.valueOf(((DataTag)localObject1).b));
                  break;
                case 49: 
                  this.a.c(String.valueOf(((DataTag)localObject1).b));
                  break;
                case 48: 
                  localObject2 = (String[])((DataTag)localObject1).b;
                  localObject1 = localObject2[0];
                  localObject2 = localObject2[1];
                  this.a.a((String)localObject1, (String)localObject2);
                  break;
                case 47: 
                  this.a.e(String.valueOf(((DataTag)localObject1).b));
                  break;
                  localObject1 = String.valueOf(((DataTag)localObject1).b);
                  if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).contains("|"))) {
                    break;
                  }
                  localObject1 = ((String)localObject1).split("\\|");
                  if ((localObject1 == null) || (localObject1.length != 2)) {
                    break;
                  }
                  QidianProfileCardActivity.a(this.a, localObject1[0], localObject1[1]);
                  break;
                  QidianProfileCardActivity.a(this.a, String.valueOf(((DataTag)localObject1).b));
                  break;
                  this.a.d(((Integer)((DataTag)localObject1).b).intValue());
                  break;
                  this.a.g();
                  break;
                }
              }
              else
              {
                this.a.a((PublicAccountItem)((DataTag)localObject1).b, ((DataTag)localObject1).a);
              }
            }
            else if (!QidianProfileCardActivity.c(this.a))
            {
              QidianProfileCardActivity.b(this.a, true);
              if ((this.a.e != null) && (this.a.e.card != null))
              {
                localObject1 = this.a;
                ((QidianProfileCardActivity)localObject1).a(((QidianProfileCardActivity)localObject1).e.card.vQzoneCoverInfo);
              }
              else
              {
                this.a.a(2131893010);
                localObject1 = this.a.u;
                localObject2 = this.a.app.getCurrentAccountUin();
                String str = this.a.e.allInOne.uin;
                l = ProfileUtils.getControl(this.a.e.allInOne, false);
                ((CardHandler)localObject1).a((String)localObject2, str, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)0);
              }
            }
          }
          else
          {
            ReportController.b(this.a.app, "dc00899", "Qidian", "", "0X8008FEB", "qidianMasterVideo", 1, 1, 0, "1", "1", "", "");
            if (this.a.m == 6)
            {
              localObject1 = this.a.app;
              localObject2 = this.a;
              ChatActivityUtils.a((QQAppInterface)localObject1, (Context)localObject2, 1024, ((QidianProfileCardActivity)localObject2).e.allInOne.uin, this.a.g.nickname, null, true, null, true, true, null, "from_internal");
            }
            else
            {
              localObject1 = this.a.app;
              localObject2 = this.a;
              ProfileBottomContainer.enterAudioCall((QQAppInterface)localObject1, (QBaseActivity)localObject2, ((QidianProfileCardActivity)localObject2).e);
            }
          }
        }
        else
        {
          this.a.b(String.valueOf(((DataTag)localObject1).b));
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.16
 * JD-Core Version:    0.7.0.1
 */