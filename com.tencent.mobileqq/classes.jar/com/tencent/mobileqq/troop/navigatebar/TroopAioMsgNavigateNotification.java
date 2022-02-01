package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.utils.NumberUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class TroopAioMsgNavigateNotification
  extends BaseTroopAioMsgNavigateBarDelegate
  implements Observer
{
  private long jdField_a_of_type_Long;
  private TroopFeedsDataManager.TroopNotify jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify;
  @Nullable
  private TroopFeedsDataManager jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
  @Nullable
  private TroopAioMsgNavigateBar jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar;
  private Object jdField_a_of_type_JavaLangObject;
  
  TroopAioMsgNavigateNotification(QQAppInterface paramQQAppInterface, Context paramContext, TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.jdField_a_of_type_Int = 102;
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar = paramTroopAioMsgNavigateBar;
  }
  
  public int a(int paramInt)
  {
    return 2130851144;
  }
  
  @Nullable
  public BaseTroopAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      return new BaseTroopAioMsgNavigateBarDelegate.Entity(true, this.jdField_a_of_type_AndroidContentContext.getString(2131697634), TroopAioAgent.Message.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = null;
    Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    long l = NumberUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if (l == -1L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = ((TroopInfoManager)localObject).a(Long.valueOf(l), true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
    if (localObject != null) {
      ((TroopFeedsDataManager)localObject).addObserver(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onInit");
    }
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView1.setVisibility(0);
    paramTextView2.setVisibility(8);
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    paramObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramObject != null)
    {
      paramObject = paramObject.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramObject != null)
      {
        boolean bool = paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131697646));
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
        long l = paramObject.dwGroupClassExt;
        if (bool) {
          paramObject = "2";
        } else {
          paramObject = "1";
        }
        ReportController.b(paramString, "dc00898", "", "", "", "0X800AACB", 0, 1, 0, str, String.valueOf(l), paramObject, "");
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onUnInit");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar = null;
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    paramObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramObject != null)
    {
      paramObject = paramObject.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramObject != null)
      {
        boolean bool = paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131697646));
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
        long l = paramObject.dwGroupClassExt;
        if (bool) {
          paramObject = "2";
        } else {
          paramObject = "1";
        }
        ReportController.b(paramString, "dc00898", "", "", "", "0X800AACC", 0, 1, 0, str, String.valueOf(l), paramObject, "");
      }
    }
  }
  
  void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "mTroopAioMsgNavigateBar = null");
      }
      return;
    }
    boolean bool2 = ((TroopAioMsgNavigateBar)localObject1).d();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showTroopNotifyBar troopNotifyData = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify);
      ((StringBuilder)localObject2).append(",  mFIsShow = ");
      ((StringBuilder)localObject2).append(bool2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = null;
      return;
    }
    boolean bool1 = false;
    if ((bool2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.b) && ((this.jdField_a_of_type_JavaLangObject instanceof MessageForArkApp)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.d))
    {
      localObject1 = (MessageForArkApp)this.jdField_a_of_type_JavaLangObject;
      if ((((MessageForArkApp)localObject1).ark_app_message != null) && ("com.tencent.mannounce".equals(((MessageForArkApp)localObject1).ark_app_message.appName))) {
        try
        {
          if (QLog.isColorLevel())
          {
            localObject2 = this.jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("showTroopNotifyBar ark.ark_app_message.metaList:");
            localStringBuilder.append(((MessageForArkApp)localObject1).ark_app_message.metaList);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
            localObject2 = this.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("showTroopNotifyBar mTroopNotifyData confirmRequired:");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.c);
            localStringBuilder.append(" fid:");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_JavaLangString);
            localStringBuilder.append(" isShowTipWindow:");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.b);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          localObject1 = new JSONObject(((MessageForArkApp)localObject1).ark_app_message.metaList).optJSONObject("mannounce");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a();
          if ((localObject1 != null) && (localObject2 != null) && (((JSONObject)localObject1).optString("fid").equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_JavaLangString)))
          {
            long l = ((MessageRecord)localObject2).shmsgseq;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
            if ((localObject1 != null) && (a((MessageRecord)localObject1, l, this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a())))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.c) {
                localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697646);
              } else {
                localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697634);
              }
              bool1 = true;
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[showTroopNotifyBar] ", localException);
        }
      }
    }
    String str = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a(new BaseTroopAioMsgNavigateBarDelegate.Entity(bool1, str, null, ""));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = null;
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showTroopNotifyBar mFIsShow:");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d(str, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopNotify update");
    }
    if (!(paramObject instanceof Integer)) {
      return;
    }
    paramObservable = (Integer)paramObject;
    if (QLog.isColorLevel())
    {
      paramObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update. notifyType = ");
      localStringBuilder.append(paramObservable);
      QLog.d(paramObject, 2, localStringBuilder.toString());
    }
    if ((paramObservable.intValue() == 1007) || (paramObservable.intValue() == 1011))
    {
      paramObservable = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
      if ((paramObservable != null) && (paramObservable.b != null)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = TroopFeedsDataManager.TroopNotify.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b);
          c();
          return;
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update. mNewNorNotice = null!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateNotification
 * JD-Core Version:    0.7.0.1
 */