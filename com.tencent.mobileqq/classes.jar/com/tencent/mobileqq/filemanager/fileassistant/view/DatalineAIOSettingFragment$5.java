package com.tencent.mobileqq.filemanager.fileassistant.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatSettingActivity.DeleteHistoryListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
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
    paramDialog = this.a;
    if (paramDialog != null)
    {
      if (paramBoolean)
      {
        paramDialog.a(this.b, 0);
        this.a.b(this.b, 0);
      }
      this.a.a(this.b, 1);
      this.a.b(this.b, 1);
    }
    Object localObject = new StringBuilder();
    paramView = (MessageRoamManager)this.b.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    paramView.a(this.c);
    int i = paramView.a(this.c, this.d, (StringBuilder)localObject);
    paramDialog = null;
    if (((StringBuilder)localObject).length() > 0) {
      paramDialog = ((StringBuilder)localObject).toString();
    }
    if (i <= 0)
    {
      QQToast.makeText(BaseApplication.getContext(), 2, 2131888442, 1).show();
      paramDialog = this.a;
      if (paramDialog != null) {
        paramDialog.a(this.e);
      }
    }
    else
    {
      localObject = this.b.getMessageFacade().h(this.c, this.d);
      long l1;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if (((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;
        } else {
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
        }
      }
      else {
        l1 = 0L;
      }
      if (FriendsStatusUtil.a(this.b, this.c, this.d))
      {
        FriendsStatusUtil.b(this.b, this.c, this.d);
        this.b.getMessageFacade().b(this.c, this.d, true, false);
      }
      else
      {
        this.b.getMessageFacade().c(this.c, this.d);
      }
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.b, "chat_history_c2c_start_del_msg");
      if (paramBoolean)
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.makeText(BaseApplication.getContext(), 2131888439, 1).show();
          return;
        }
        ((MessageRoamManager)this.b.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).t();
        this.b.getFileManagerDataCenter().a(this.c, this.d);
        paramView.G();
      }
      this.b.getMessageFacade().g(this.c, this.d);
      if (paramDialog != null)
      {
        long l2;
        try
        {
          l2 = Long.parseLong(paramDialog);
        }
        catch (Exception paramDialog)
        {
          paramDialog.printStackTrace();
          l2 = 0L;
        }
        l1 = Math.max(l2, l1);
        if (l1 > 0L) {
          this.b.getMsgCache().a(this.c, this.d, l1);
        }
      }
      paramView.b().c();
      paramView.i();
      if (paramBoolean) {
        paramView.G();
      }
      paramDialog = this.b.getHandler(Conversation.class);
      if (paramDialog != null)
      {
        paramView = paramDialog.obtainMessage(1017);
        paramView.obj = this.c;
        paramView.arg1 = this.d;
        paramDialog.sendMessage(paramView);
      }
      paramDialog = this.a;
      if (paramDialog != null) {
        paramDialog.a(this.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.view.DatalineAIOSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */