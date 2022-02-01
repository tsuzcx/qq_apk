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
  private long jdField_a_of_type_Long = 0L;
  
  QidianProfileCardActivity$16(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.jdField_a_of_type_Long) >= 1000L)
      {
        this.jdField_a_of_type_Long = l;
        Object localObject1 = (DataTag)paramView.getTag();
        int i = ((DataTag)localObject1).jdField_a_of_type_Int;
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
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.e();
                  break;
                case 54: 
                  localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, String.valueOf(((DataTag)localObject1).jdField_a_of_type_JavaLangObject));
                  if (localObject1 == null) {
                    break;
                  }
                  ((JumpAction)localObject1).a();
                  break;
                case 53: 
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.d();
                  break;
                case 52: 
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a(String.valueOf(((DataTag)localObject1).jdField_a_of_type_JavaLangObject));
                  break;
                case 51: 
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.d(String.valueOf(((DataTag)localObject1).jdField_a_of_type_JavaLangObject));
                  break;
                case 49: 
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.c(String.valueOf(((DataTag)localObject1).jdField_a_of_type_JavaLangObject));
                  break;
                case 48: 
                  localObject2 = (String[])((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
                  localObject1 = localObject2[0];
                  localObject2 = localObject2[1];
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a((String)localObject1, (String)localObject2);
                  break;
                case 47: 
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.e(String.valueOf(((DataTag)localObject1).jdField_a_of_type_JavaLangObject));
                  break;
                  localObject1 = String.valueOf(((DataTag)localObject1).jdField_a_of_type_JavaLangObject);
                  if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).contains("|"))) {
                    break;
                  }
                  localObject1 = ((String)localObject1).split("\\|");
                  if ((localObject1 == null) || (localObject1.length != 2)) {
                    break;
                  }
                  QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, localObject1[0], localObject1[1]);
                  break;
                  QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, String.valueOf(((DataTag)localObject1).jdField_a_of_type_JavaLangObject));
                  break;
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.d(((Integer)((DataTag)localObject1).jdField_a_of_type_JavaLangObject).intValue());
                  break;
                  this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.f();
                  break;
                }
              }
              else
              {
                this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a((PublicAccountItem)((DataTag)localObject1).jdField_a_of_type_JavaLangObject, ((DataTag)localObject1).jdField_a_of_type_Int);
              }
            }
            else if (!QidianProfileCardActivity.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity))
            {
              QidianProfileCardActivity.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, true);
              if ((this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card != null))
              {
                localObject1 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity;
                ((QidianProfileCardActivity)localObject1).a(((QidianProfileCardActivity)localObject1).jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.vQzoneCoverInfo);
              }
              else
              {
                this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a(2131695275);
                localObject1 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler;
                localObject2 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app.getCurrentAccountUin();
                String str = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin;
                l = ProfileUtils.getControl(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne, false);
                ((CardHandler)localObject1).a((String)localObject2, str, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)0);
              }
            }
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app, "dc00899", "Qidian", "", "0X8008FEB", "qidianMasterVideo", 1, 1, 0, "1", "1", "", "");
            if (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.c == 6)
            {
              localObject1 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app;
              localObject2 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity;
              ChatActivityUtils.a((QQAppInterface)localObject1, (Context)localObject2, 1024, ((QidianProfileCardActivity)localObject2).jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname, null, true, null, true, true, null, "from_internal");
            }
            else
            {
              localObject1 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app;
              localObject2 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity;
              ProfileBottomContainer.enterAudioCall((QQAppInterface)localObject1, (QBaseActivity)localObject2, ((QidianProfileCardActivity)localObject2).jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo);
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.b(String.valueOf(((DataTag)localObject1).jdField_a_of_type_JavaLangObject));
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.16
 * JD-Core Version:    0.7.0.1
 */