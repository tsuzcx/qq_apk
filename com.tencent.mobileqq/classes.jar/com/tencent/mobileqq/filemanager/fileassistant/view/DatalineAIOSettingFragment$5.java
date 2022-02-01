package com.tencent.mobileqq.filemanager.fileassistant.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatSettingActivity.DeleteHistoryListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

class DatalineAIOSettingFragment$5
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  DatalineAIOSettingFragment$5(DatalineAIOSettingFragment paramDatalineAIOSettingFragment, ChatSettingActivity.DeleteHistoryListener paramDeleteHistoryListener, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Activity paramActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    }
    paramDialog = new StringBuilder();
    paramView = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    paramView.a(this.jdField_a_of_type_JavaLangString);
    int i = paramView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramDialog);
    if ((paramDialog != null) && (paramDialog.length() > 0)) {}
    for (paramDialog = paramDialog.toString();; paramDialog = null)
    {
      if (i <= 0)
      {
        QQToast.a(BaseApplication.getContext(), 2, 2131691562, 1).a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.a(this.jdField_a_of_type_AndroidAppActivity);
        }
        return;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      long l1;
      if ((localList != null) && (!localList.isEmpty())) {
        if (((MessageRecord)localList.get(localList.size() - 1)).isSendFromLocal()) {
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time + 2L;
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
          {
            FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, false);
          }
          for (;;)
          {
            ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history_c2c_start_del_msg");
            if (!paramBoolean) {
              break label443;
            }
            if (NetworkUtil.d(BaseApplication.getContext())) {
              break label405;
            }
            QQToast.a(BaseApplication.getContext(), 2131691559, 1).a();
            return;
            l1 = ((MessageRecord)localList.get(localList.size() - 1)).time;
            break;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          }
          label405:
          ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).i();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          paramView.n();
          label443:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().e(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          if (paramDialog != null) {}
          try
          {
            l2 = Long.parseLong(paramDialog);
            l1 = Math.max(l2, l1);
            if (l1 > 0L) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, l1);
            }
            paramView.a().c();
            paramView.b();
            if (paramBoolean) {
              paramView.n();
            }
            paramDialog = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
            if (paramDialog != null)
            {
              paramView = paramDialog.obtainMessage(1017);
              paramView.obj = this.jdField_a_of_type_JavaLangString;
              paramView.arg1 = this.jdField_a_of_type_Int;
              paramDialog.sendMessage(paramView);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.a(this.jdField_a_of_type_AndroidAppActivity);
            return;
          }
          catch (Exception paramDialog)
          {
            for (;;)
            {
              paramDialog.printStackTrace();
              long l2 = 0L;
            }
          }
        }
        l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.view.DatalineAIOSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */