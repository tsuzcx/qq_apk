package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import java.util.List;

public class TroopAioMsgNavigateUnRead
  extends BaseTroopAioMsgNavigateBarDelegate
{
  public TroopAioMsgNavigateUnRead(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 1;
  }
  
  public int a(int paramInt)
  {
    return 2130851171;
  }
  
  @Nullable
  public BaseTroopAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    int j = 0;
    int i;
    if (paramLong3 >= paramLong2) {
      i = 0;
    }
    while (i != 0)
    {
      return new BaseTroopAioMsgNavigateBarDelegate.Entity(true, String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697818), new Object[] { Integer.valueOf(paramInt2) }), TroopAioAgent.Message.a(paramInt1, paramLong1, paramInt2), "");
      if (paramInt2 < 30)
      {
        paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        i = j;
        if (paramList != null)
        {
          long l = paramList.shmsgseq;
          for (paramLong3 = 0L;; paramLong3 += 1L)
          {
            i = j;
            if (paramLong3 >= paramInt2) {
              break;
            }
            paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
            if ((paramList != null) && (paramList.msgtype != -2058) && (paramList.shmsgseq < paramLong2))
            {
              i = 1;
              break;
            }
            l -= 1L;
          }
        }
      }
      else
      {
        i = 1;
      }
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView2.setVisibility(8);
    paramTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166262));
    paramTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166262));
    paramImageView.setBackgroundResource(2130851225);
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 15) && (paramInt2 <= 200);
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUnRead
 * JD-Core Version:    0.7.0.1
 */