package com.tencent.mobileqq.werewolves;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class WerewolvesHostInterface$4
  implements BusinessObserver
{
  WerewolvesHostInterface$4(WerewolvesHostInterface paramWerewolvesHostInterface, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
      if (!paramBoolean) {
        break label397;
      }
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label397;
      }
      localObject = new WebSsoBody.WebSsoResponseBody();
      ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
      paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
      localObject = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
      if (paramInt != 0)
      {
        paramBundle = ((JSONObject)localObject).optString("msg");
        if ((TextUtils.isEmpty(paramBundle)) || (!QLog.isColorLevel())) {
          break label397;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendOperateFollowUser,targetUin:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(", op:");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(", errMsg:");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, ((StringBuilder)localObject).toString());
        QQToast.a(BaseApplicationImpl.getContext(), 1, paramBundle, 0).a();
        return;
      }
      paramBundle = ((JSONObject)localObject).getJSONObject("result");
      if (((JSONObject)localObject).optInt("retcode") != 0) {
        break label397;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface.manager.a().a(5, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      localObject = BaseApplicationImpl.getContext();
      localBaseApplication = BaseApplicationImpl.getContext();
      if (!this.b.equals("1")) {
        break label558;
      }
      paramInt = 2131694391;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject;
        BaseApplication localBaseApplication;
        label397:
        continue;
        label558:
        paramInt = 2131694399;
      }
    }
    QQToast.a((Context)localObject, 2, localBaseApplication.getString(paramInt), 0).a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendOperateFollowUser,targetUin:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", op:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", result:");
      ((StringBuilder)localObject).append(paramBundle.toString());
      QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, ((StringBuilder)localObject).toString());
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.WerewolvesHostInterface", 2, "sendOperateFollowUser, Exception");
    }
    paramBundle = BaseApplicationImpl.getContext();
    if (this.b.equals("1")) {
      paramInt = 2131694390;
    } else {
      paramInt = 2131694398;
    }
    paramBundle = paramBundle.getString(paramInt);
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramBundle, 0).a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendOperateFollowUser,targetUin:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", op:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", re:");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface.manager.a().a(5, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.jdField_a_of_type_Boolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHostInterface.4
 * JD-Core Version:    0.7.0.1
 */