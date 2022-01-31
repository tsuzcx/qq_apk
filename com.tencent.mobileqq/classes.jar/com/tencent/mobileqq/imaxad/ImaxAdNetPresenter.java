package com.tencent.mobileqq.imaxad;

import adss;
import adst;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.c2s.imax.IMaxService.IgnoreADMsg;
import tencent.im.c2s.imax.IMaxService.ReqBody;

public class ImaxAdNetPresenter
  implements Handler.Callback
{
  private static final ImaxAdNetPresenter jdField_a_of_type_ComTencentMobileqqImaxadImaxAdNetPresenter = new ImaxAdNetPresenter();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  
  public static ImaxAdNetPresenter a()
  {
    return jdField_a_of_type_ComTencentMobileqqImaxadImaxAdNetPresenter;
  }
  
  public void a(Message paramMessage)
  {
    paramMessage.setTarget(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 1000L);
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, int paramInt)
  {
    if ((paramAdvertisementItem == null) || (paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem == null)) {
      QLog.e("ImaxAdNetPresenter", 1, "doIMaxServiceRequest error " + paramAdvertisementItem);
    }
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    IMaxService.ReqBody localReqBody = new IMaxService.ReqBody();
    Object localObject = new IMaxService.IgnoreADMsg();
    paramAdvertisementItem = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c;
    long l = Long.parseLong(localAppRuntime.getAccount());
    ((IMaxService.IgnoreADMsg)localObject).uint64_uin.set(l);
    ((IMaxService.IgnoreADMsg)localObject).str_ad_id.set(paramAdvertisementItem);
    localReqBody.msg_ignoreAD.set((MessageMicro)localObject);
    localReqBody.int32_type.set(2);
    paramAdvertisementItem = new NewIntent(BaseApplicationImpl.getApplication(), ProtoServlet.class);
    localObject = new ImaxAdNetPresenter.IMaxServiceObserver(paramInt);
    ((ImaxAdNetPresenter.IMaxServiceObserver)localObject).b = 2;
    paramAdvertisementItem.putExtra("cmd", "iMaxServiceSvc.IgnoreADMsg");
    paramAdvertisementItem.putExtra("data", localReqBody.toByteArray());
    paramAdvertisementItem.putExtra("isResend", false);
    paramAdvertisementItem.setObserver((BusinessObserver)localObject);
    localAppRuntime.startServlet(paramAdvertisementItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem != null)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8009102", "0X8009102", 0, 0, paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, "", PublicAccountAdUtil.a(), "");
      a(paramAdvertisementItem, 4);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ImaxAdNetPresenter", 2, "do doDel Report fail");
  }
  
  void a(QQAppInterface paramQQAppInterface, RecentAdapter paramRecentAdapter, AbsListView paramAbsListView, String paramString)
  {
    int i;
    if ((paramAbsListView != null) && (paramRecentAdapter != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label137;
      }
      i -= 1;
    }
    label137:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      while (j < k + 1)
      {
        Object localObject = paramRecentAdapter.getItem(j);
        View localView = paramAbsListView.getChildAt(j - i);
        if ((localView != null) && (localObject != null) && ((localObject instanceof RecentItemImaxADData)))
        {
          localObject = (RecentItemImaxADData)localObject;
          localView.setTag(Integer.valueOf(j));
          b(paramQQAppInterface, ((RecentItemImaxADData)localObject).a.uin, ((RecentItemImaxADData)localObject).a.type, localView, paramString);
        }
        j += 1;
      }
      return;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, View paramView, String paramString2)
  {
    AdvertisementRecentUserManager localAdvertisementRecentUserManager = AdvertisementRecentUserManager.a();
    AdvertisementItem localAdvertisementItem = localAdvertisementRecentUserManager.a(paramString1);
    if ((localAdvertisementItem != null) && (ImaxAdUtil.a(paramView)) && (paramString2.equals(localAdvertisementItem.c)))
    {
      paramString2 = paramQQAppInterface.a();
      if (paramString2 != null)
      {
        paramString1 = paramString2.b(paramString1, paramInt);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
          if ("false".equals(paramString1.getExtInfoFromExtStr("recent_list_advertisement_message_first_report")))
          {
            paramString1.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "true");
            ThreadManager.post(new adss(this, paramQQAppInterface, paramString1), 5, null, false);
            if ((localAdvertisementItem != null) && (localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null))
            {
              ReportController.b(paramQQAppInterface, "dc00898", "", localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8008F5D", "0X8008F5D", 0, 0, localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), PublicAccountAdUtil.a(), "");
              ReportController.b(paramQQAppInterface, "dc00898", "", localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8008F5C", "0X8008F5C", 0, 0, localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, "", PublicAccountAdUtil.a(), "");
            }
          }
        }
      }
      if ((localAdvertisementItem != null) && (!localAdvertisementItem.jdField_a_of_type_Boolean))
      {
        localAdvertisementItem.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "do exposure Report");
        }
        localAdvertisementItem.a();
        localAdvertisementRecentUserManager.a(paramQQAppInterface, 1, localAdvertisementItem);
        if ((localAdvertisementItem != null) && (localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null)) {
          ReportController.b(paramQQAppInterface, "dc00898", "", localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8008F5F", "0X8008F5F", 0, 0, localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, "", "", "");
        }
      }
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, RecentAdapter paramRecentAdapter, AbsListView paramAbsListView, String paramString)
  {
    int i;
    if ((paramAbsListView != null) && (paramRecentAdapter != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      while (j < k + 1)
      {
        Object localObject = paramRecentAdapter.getItem(j);
        if ((localObject != null) && ((localObject instanceof RecentItemPublicAccountADFolderData)))
        {
          localObject = (RecentItemPublicAccountADFolderData)localObject;
          View localView = paramAbsListView.getChildAt(j - i);
          if (ImaxAdUtil.a(localView)) {
            a(paramQQAppInterface, ((RecentItemPublicAccountADFolderData)localObject).a.uin, ((RecentItemPublicAccountADFolderData)localObject).a.type, localView, paramString);
          }
        }
        j += 1;
      }
      return;
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, View paramView, String paramString2)
  {
    AdvertisementItem localAdvertisementItem2 = ImaxAdRecentUserManager.a().a(paramString1);
    AdvertisementItem localAdvertisementItem1 = localAdvertisementItem2;
    if (localAdvertisementItem2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdNetPresenter", 2, "isShowImaxAdItem item recreated " + paramString1);
      }
      localAdvertisementItem1 = AdvertisementItem.a(ImaxAdUtil.a(paramQQAppInterface.c(), paramString1));
      if (localAdvertisementItem1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdNetPresenter", 2, "isShowImaxAdItem item false " + paramString1);
        }
      }
    }
    do
    {
      do
      {
        return;
        ImaxAdRecentUserManager.a().a(localAdvertisementItem1);
      } while ((localAdvertisementItem1 == null) || (!ImaxAdUtil.a(paramView)) || (!paramString2.equals(localAdvertisementItem1.c)));
      paramString2 = paramQQAppInterface.a();
      if (paramString2 != null)
      {
        paramString1 = paramString2.b(paramString1, paramInt);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
          if ("false".equals(paramString1.getExtInfoFromExtStr("recent_list_advertisement_message_first_report")))
          {
            paramString1.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "true");
            ThreadManager.post(new adst(this, paramQQAppInterface, paramString1), 5, null, false);
            if ((localAdvertisementItem1 != null) && (localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null))
            {
              ReportController.b(paramQQAppInterface, "dc00898", "", localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8008F5D", "0X8008F5D", 0, 0, localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), PublicAccountAdUtil.a(), "");
              ReportController.b(paramQQAppInterface, "dc00898", "", localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8008F5C", "0X8008F5C", 0, 0, localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, "", PublicAccountAdUtil.a(), "");
            }
          }
        }
      }
    } while ((localAdvertisementItem1 == null) || (localAdvertisementItem1.jdField_a_of_type_Boolean) || (localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem == null));
    if (localAdvertisementItem1.a())
    {
      AdvertisementRecentUserManager.a().a(paramQQAppInterface, 1, localAdvertisementItem1);
      ImaxAdRecentUserManager.a().b(localAdvertisementItem1);
      localAdvertisementItem1.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdNetPresenter", 2, "do exposure Report");
      }
      localAdvertisementItem1.a();
      ReportController.b(paramQQAppInterface, "dc00898", "", localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8009129", "0X8009129", 0, 0, localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, "", PublicAccountAdUtil.a(), "");
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8008F5F", "0X8008F5F", 0, 0, localAdvertisementItem1.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = paramMessage.getData();
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getString("key_ad_id");
      Object localObject2 = (HashMap)paramMessage.obj;
      QQAppInterface localQQAppInterface = (QQAppInterface)((WeakReference)((HashMap)localObject2).get("key_app")).get();
      RecentAdapter localRecentAdapter = (RecentAdapter)((WeakReference)((HashMap)localObject2).get("key_adapter")).get();
      localObject2 = (AbsListView)((WeakReference)((HashMap)localObject2).get("key_listview")).get();
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return true;
        b(localQQAppInterface, localRecentAdapter, (AbsListView)localObject2, (String)localObject1);
        continue;
        a(localQQAppInterface, localRecentAdapter, (AbsListView)localObject2, (String)localObject1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdNetPresenter
 * JD-Core Version:    0.7.0.1
 */