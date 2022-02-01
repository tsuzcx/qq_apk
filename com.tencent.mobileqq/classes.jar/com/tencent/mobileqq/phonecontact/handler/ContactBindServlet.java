package com.tencent.mobileqq.phonecontact.handler;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.CompressedPackage;
import SecurityAccountServer.LastLoginInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RequestBindMobileV2;
import SecurityAccountServer.RequestCancelBindMobile;
import SecurityAccountServer.RequestDisableMobileBind;
import SecurityAccountServer.RequestHeader;
import SecurityAccountServer.RequestHideContact;
import SecurityAccountServer.RequestQueryLastLoginState;
import SecurityAccountServer.RequestQueryNewUserRecommendedList;
import SecurityAccountServer.RequestQueryNewUserRecommendedListNotBind;
import SecurityAccountServer.RequestQueryQQBindingStat;
import SecurityAccountServer.RequestQueryQQMobileContactsV2;
import SecurityAccountServer.RequestQueryQQMobileContactsV3;
import SecurityAccountServer.RequestReBindMblWTLogin;
import SecurityAccountServer.RequestReBindMobile;
import SecurityAccountServer.RequestResendSmscode;
import SecurityAccountServer.RequestUpdateAddressBook;
import SecurityAccountServer.RequestUpdateAddressBookNotBind;
import SecurityAccountServer.RequestUploadAddressBook;
import SecurityAccountServer.RequestUploadAddressBookNotBind;
import SecurityAccountServer.RequestUploadAddressBookV2;
import SecurityAccountServer.RequestVerifySmscode;
import SecurityAccountServer.RequestVerifyWTLogin;
import SecurityAccountServer.RespondHeader;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SecurityAccountServer.ResponeBindMobileV2;
import SecurityAccountServer.ResponeQueryLastLoginState;
import SecurityAccountServer.ResponeQueryNewUserRecommendedList;
import SecurityAccountServer.ResponeQueryNewUserRecommendedListNotBind;
import SecurityAccountServer.ResponeQueryQQMobileContactsV3;
import SecurityAccountServer.ResponeReBindMobile;
import SecurityAccountServer.ResponeUpdateAddressBook;
import SecurityAccountServer.ResponeUpdateAddressBookNotBind;
import SecurityAccountServer.ResponeUploadAddressBook;
import SecurityAccountServer.ResponeUploadAddressBookNotBind;
import SecurityAccountServer.ResponeUploadAddressBookV2;
import SecurityAccountServer.ResponseReBindMblWTLogin;
import SecurityAccountServer.ResponseVerifyWTLogin;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.RecommendContactInfo;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class ContactBindServlet
  extends MSFServlet
{
  private IPhoneContactService a;
  private boolean b = false;
  private boolean c = false;
  private int[] d = new int[0];
  
  public static RequestHeader a(int paramInt1, int paramInt2, int paramInt3)
  {
    RequestHeader localRequestHeader = new RequestHeader();
    localRequestHeader.ver = 100;
    localRequestHeader.cmd = paramInt1;
    localRequestHeader.requestID = paramInt2;
    localRequestHeader.svrSeqNo = paramInt3;
    localRequestHeader.account = "";
    localRequestHeader.appid = 0;
    localRequestHeader.sbid = "";
    localRequestHeader.channel_id = "";
    localRequestHeader.ksid = "";
    localRequestHeader.uin = 0L;
    return localRequestHeader;
  }
  
  private ResponeQueryQQMobileContactsV3 a(UniPacket paramUniPacket)
  {
    CompressedPackage localCompressedPackage = (CompressedPackage)paramUniPacket.getByClass("CompressedPackage", new CompressedPackage());
    if (localCompressedPackage != null)
    {
      ResponeQueryQQMobileContactsV3 localResponeQueryQQMobileContactsV3 = new ResponeQueryQQMobileContactsV3();
      if (localCompressedPackage.compressed) {
        paramUniPacket = a(localCompressedPackage.buffer);
      } else {
        paramUniPacket = localCompressedPackage.buffer;
      }
      paramUniPacket = new JceInputStream(paramUniPacket);
      paramUniPacket.setServerEncoding("utf-8");
      localResponeQueryQQMobileContactsV3.readFrom(paramUniPacket);
      paramUniPacket = localResponeQueryQQMobileContactsV3;
      if (QLog.isColorLevel())
      {
        QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "getRspQueryContacts_v3 | compress != null | read from JceInputStream");
        return localResponeQueryQQMobileContactsV3;
      }
    }
    else
    {
      paramUniPacket = (ResponeQueryQQMobileContactsV3)paramUniPacket.getByClass("ResponeQueryQQMobileContactsV3", new ResponeQueryQQMobileContactsV3());
    }
    return paramUniPacket;
  }
  
  private UniPacket a(FromServiceMsg paramFromServiceMsg)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
    return localUniPacket;
  }
  
  private IPhoneContactService a()
  {
    if (this.a == null) {
      this.a = ((IPhoneContactService)getAppRuntime().getRuntimeService(IPhoneContactService.class, ""));
    }
    return this.a;
  }
  
  private void a(ResponeQueryQQMobileContactsV3 paramResponeQueryQQMobileContactsV3)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    localRespondQueryQQBindingStat.nationCode = paramResponeQueryQQMobileContactsV3.nationCode;
    localRespondQueryQQBindingStat.mobileNo = paramResponeQueryQQMobileContactsV3.mobileNo;
    localRespondQueryQQBindingStat.MobileUniqueNo = paramResponeQueryQQMobileContactsV3.MobileUniqueNo;
    localRespondQueryQQBindingStat.isRecommend = paramResponeQueryQQMobileContactsV3.isRecommend;
    localRespondQueryQQBindingStat.originBinder = paramResponeQueryQQMobileContactsV3.originBinder;
    localRespondQueryQQBindingStat.bindingTime = paramResponeQueryQQMobileContactsV3.bindingTime;
    localRespondQueryQQBindingStat.lastUsedFlag = paramResponeQueryQQMobileContactsV3.lastUsedFlag;
    localRespondQueryQQBindingStat.type = paramResponeQueryQQMobileContactsV3.type;
    localRespondQueryQQBindingStat.isStopFindMatch = paramResponeQueryQQMobileContactsV3.isInactive;
    localRespondQueryQQBindingStat.isPhoneSwitched = paramResponeQueryQQMobileContactsV3.isChangeDev;
    localRespondQueryQQBindingStat.noBindUploadContacts = paramResponeQueryQQMobileContactsV3.noBindUploadContacts;
    a().saveBindInfo(localRespondQueryQQBindingStat, "saveBindStatAndBindStrategy");
    a().saveQueryInterval(paramResponeQueryQQMobileContactsV3.nextQueryTimeInterval * 1000L, paramResponeQueryQQMobileContactsV3.nextReLoginTimeInterval * 1000L, paramResponeQueryQQMobileContactsV3.nextReconnectionTimeInterval * 1000L);
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      UniPacket localUniPacket = a(paramFromServiceMsg);
      RespondHeader localRespondHeader = (RespondHeader)localUniPacket.getByClass("RespondHeader", new RespondHeader());
      if (localRespondHeader == null)
      {
        notifyObserver(paramIntent, 26, false, localBundle, ContactBindObserver.class);
        return;
      }
      paramFromServiceMsg = null;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGetBindUinWithPhone respHeader.result =");
        localStringBuilder.append(localRespondHeader.result);
        QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, localStringBuilder.toString());
      }
      int i = localRespondHeader.result;
      boolean bool1 = true;
      boolean bool2 = false;
      if (i == 107)
      {
        paramFromServiceMsg = String.valueOf(((ResponseVerifyWTLogin)localUniPacket.getByClass("ResponseVerifyWTLogin", new ResponseVerifyWTLogin())).preBindUin);
      }
      else if (localRespondHeader.result == 0)
      {
        bool1 = false;
        bool2 = true;
      }
      else
      {
        bool1 = false;
      }
      localBundle.putBoolean("bindOK", bool2);
      localBundle.putBoolean("hadBind", bool1);
      localBundle.putString("bindUin", paramFromServiceMsg);
      notifyObserver(paramIntent, 26, true, localBundle, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 26, false, localBundle, ContactBindObserver.class);
  }
  
  public static void a(AppInterface paramAppInterface, byte[] paramArrayOfByte, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 27);
    localNewIntent.putExtra("cmd_param_phone_bind_sign", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_phone_uin", paramString);
    localNewIntent.setWithouLogin(true);
    paramAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 26);
    localNewIntent.putExtra("cmd_param_phone_bind_sign", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_phone_uin", paramString);
    localNewIntent.setWithouLogin(true);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      InflaterInputStream localInflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = localInflaterInputStream.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
      }
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramArrayOfByte;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1 = false;
    if (bool2)
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      Object localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      if (localObject == null)
      {
        localBundle.putBoolean("bind_state", false);
        notifyObserver(paramIntent, 27, false, localBundle, ContactBindObserver.class);
        return;
      }
      if (((RespondHeader)localObject).result == 0)
      {
        bool2 = true;
        paramFromServiceMsg = (ResponseReBindMblWTLogin)paramFromServiceMsg.getByClass("ResponseReBindMblWTLogin", new ResponseReBindMblWTLogin());
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handlerReBindMblWTLogin resp = ");
          ((StringBuilder)localObject).append(paramFromServiceMsg.result);
          QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject).toString());
          bool1 = bool2;
        }
      }
      localBundle.putBoolean("bind_state", bool1);
      notifyObserver(paramIntent, 27, true, localBundle, ContactBindObserver.class);
      return;
    }
    localBundle.putBoolean("bind_state", false);
    notifyObserver(paramIntent, 27, false, localBundle, ContactBindObserver.class);
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      UniPacket localUniPacket = a(paramFromServiceMsg);
      RespondHeader localRespondHeader = (RespondHeader)localUniPacket.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = null;
      if (localRespondHeader.result == 105)
      {
        localBundle.putBoolean("bind_state", false);
      }
      else
      {
        paramFromServiceMsg = (RespondQueryQQBindingStat)localUniPacket.getByClass("RespondQueryQQBindingStat", new RespondQueryQQBindingStat());
        localBundle.putBoolean("bind_state", true);
      }
      a().saveBindInfo(paramFromServiceMsg, "handleQueryBindState");
      notifyObserver(paramIntent, 12, true, localBundle, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 12, false, null, ContactBindObserver.class);
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      localObject = (ResponeBindMobileV2)((UniPacket)localObject).getByClass("ResponeBindMobileV2", new ResponeBindMobileV2());
      a().updateSessionId(((ResponeBindMobileV2)localObject).sessionSid);
      Bundle localBundle = new Bundle();
      localBundle.putInt("k_result", paramFromServiceMsg.result);
      localBundle.putBoolean("k_buto_bind", ((ResponeBindMobileV2)localObject).bindSuccess);
      if (paramFromServiceMsg.result == 107) {
        localBundle.putString("k_uin", ((ResponeBindMobileV2)localObject).alreadyBindedUin);
      } else if (paramFromServiceMsg.result == 106) {
        localBundle.putString("k_uin", "");
      }
      notifyObserver(paramIntent, 35, true, localBundle, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 35, false, null, ContactBindObserver.class);
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (a().isDestroyed()) {
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      localObject = (ResponeReBindMobile)((UniPacket)localObject).getByClass("ResponeReBindMobile", new ResponeReBindMobile());
      a().updateSessionId(((ResponeReBindMobile)localObject).sessionSid);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("k_result", paramFromServiceMsg.result);
      if ((paramFromServiceMsg.result != 0) && (paramFromServiceMsg.result != 104))
      {
        if (QLog.isColorLevel()) {
          QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "BindNumberBusiness  rebind failed ,返回码不正确");
        }
        notifyObserver(paramIntent, 19, false, (Bundle)localObject, ContactBindObserver.class);
        return;
      }
      notifyObserver(paramIntent, 19, true, (Bundle)localObject, ContactBindObserver.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "BindNumberBusiness  rebind failed ,response isSuccess = false");
    }
    notifyObserver(paramIntent, 19, false, null, ContactBindObserver.class);
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader());
      if ((paramFromServiceMsg.result != 0) && (paramFromServiceMsg.result != 105))
      {
        notifyObserver(paramIntent, 20, false, null, ContactBindObserver.class);
        return;
      }
      a().saveBindInfo(null, "handleCancelBind");
      notifyObserver(paramIntent, 20, true, null, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 20, false, null, ContactBindObserver.class);
  }
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.ContactBindServlet", 2, "handleDisableMobileBind");
    }
    if (paramFromServiceMsg.isSuccess())
    {
      if (((RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader())).result == 0)
      {
        a().OnDisableMobileBindSuc();
        notifyObserver(paramIntent, 33, true, null, ContactBindObserver.class);
        return;
      }
      notifyObserver(paramIntent, 33, false, null, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 33, false, null, ContactBindObserver.class);
  }
  
  private void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("k_result", paramFromServiceMsg.result);
      notifyObserver(paramIntent, 16, true, localBundle, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 16, false, null, ContactBindObserver.class);
  }
  
  private void i(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = paramIntent.getExtras();
    int k = localBundle.getInt("upload_package_no");
    Object localObject = localBundle.getString("unique_phone_no");
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 14);
    localNewIntent.putExtra("unique_phone_no", (String)localObject);
    if (a().isDestroyed()) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = 3;
    if (bool)
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = (ResponeUploadAddressBook)paramFromServiceMsg.getByClass("ResponeUploadAddressBook", new ResponeUploadAddressBook());
      if (((RespondHeader)localObject).result == 0)
      {
        localObject = (ArrayList)localBundle.getSerializable("contact_list");
        int m = k * 50;
        int j = m + 50;
        i = j;
        if (j > ((ArrayList)localObject).size()) {
          i = ((ArrayList)localObject).size();
        }
        localObject = ((ArrayList)localObject).subList(m, i);
        a().markUploadedContact((List)localObject);
        if (paramFromServiceMsg.nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
          localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        notifyObserver(paramIntent, 14, true, null, ContactBindObserver.class);
        return;
      }
      if ((((RespondHeader)localObject).result != 105) && (((RespondHeader)localObject).result != 107))
      {
        if (localBundle.getBoolean("is_resend"))
        {
          paramFromServiceMsg = new Bundle();
          if (k == 0) {
            i = 2;
          }
          paramFromServiceMsg.putInt("param_fail_reason", i);
          notifyObserver(paramIntent, 14, false, paramFromServiceMsg, ContactBindObserver.class);
          return;
        }
        localNewIntent.putExtra("is_resend", true);
        localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
        localNewIntent.putExtra("upload_package_no", k);
        localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
        localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
        localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
        getAppRuntime().startServlet(localNewIntent);
        return;
      }
      a().saveBindInfo(null, "handleUploadContact");
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putInt("param_fail_reason", 1);
      notifyObserver(paramIntent, 14, false, paramFromServiceMsg, ContactBindObserver.class);
      return;
    }
    if (localBundle.getBoolean("is_resend"))
    {
      paramFromServiceMsg = new Bundle();
      if (k == 0) {
        i = 2;
      }
      paramFromServiceMsg.putInt("param_fail_reason", i);
      notifyObserver(paramIntent, 14, false, paramFromServiceMsg, ContactBindObserver.class);
      return;
    }
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
    localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
  }
  
  private void j(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      Thread.sleep(1000L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    Bundle localBundle = paramIntent.getExtras();
    int k = localBundle.getInt("upload_package_no");
    Object localObject1 = localBundle.getString("unique_phone_no");
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 31);
    localNewIntent.putExtra("unique_phone_no", (String)localObject1);
    boolean bool1 = a().isDestroyed();
    boolean bool2 = QLog.isColorLevel();
    int i = 2;
    if (bool2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleUploadContactV2, ");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject1).append(", packageNo = ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(" isMgrDestroyed = ");
      ((StringBuilder)localObject1).append(bool1);
      QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool1) {
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      localObject1 = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = (ResponeUploadAddressBookV2)paramFromServiceMsg.getByClass("ResponeUploadAddressBookV2", new ResponeUploadAddressBookV2());
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleUploadContactV2, result = ");
        ((StringBuilder)localObject2).append(((RespondHeader)localObject1).result);
        QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject2).toString());
      }
      if (((RespondHeader)localObject1).result == 0)
      {
        localObject1 = (ArrayList)localBundle.getSerializable("contact_list");
        int m = k * 50;
        int j = m + 50;
        i = j;
        if (j > ((ArrayList)localObject1).size()) {
          i = ((ArrayList)localObject1).size();
        }
        localObject2 = ((ArrayList)localObject1).subList(m, i);
        a().markUploadedContact((List)localObject2);
        a().saveContactFromServer(true, k, paramFromServiceMsg.nextFlag, true, paramFromServiceMsg.timeStamp, paramFromServiceMsg.MaxsignTimeStamp, paramFromServiceMsg.BindFriendContacts, paramFromServiceMsg.BindNotFriendContacts);
        localObject2 = new Bundle();
        if (((ArrayList)localObject1).size() != 0) {
          j = m * 100 / ((ArrayList)localObject1).size();
        } else {
          j = 100;
        }
        if (((ArrayList)localObject1).size() != 0) {
          i = (i + 50) * 100 / ((ArrayList)localObject1).size();
        } else {
          i = 100;
        }
        i = Math.min(i, 100);
        ((Bundle)localObject2).putInt("current_percentage", j);
        ((Bundle)localObject2).putInt("expected_percentage", i);
        notifyObserver(paramIntent, 100, true, (Bundle)localObject2, ContactBindObserver.class);
        if (paramFromServiceMsg.nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
          localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        notifyObserver(paramIntent, 31, true, null, ContactBindObserver.class);
        return;
      }
      if ((((RespondHeader)localObject1).result != 105) && (((RespondHeader)localObject1).result != 107))
      {
        if (localBundle.getBoolean("is_resend"))
        {
          paramFromServiceMsg = new Bundle();
          if (k != 0) {
            i = 3;
          }
          paramFromServiceMsg.putInt("param_fail_reason", i);
          notifyObserver(paramIntent, 31, false, paramFromServiceMsg, ContactBindObserver.class);
          return;
        }
        localNewIntent.putExtra("is_resend", true);
        localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
        localNewIntent.putExtra("upload_package_no", k);
        localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
        localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
        localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
        getAppRuntime().startServlet(localNewIntent);
        return;
      }
      a().saveBindInfo(null, "handleUploadContactV2_temp");
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putInt("param_fail_reason", 1);
      notifyObserver(paramIntent, 31, false, paramFromServiceMsg, ContactBindObserver.class);
      return;
    }
    if (localBundle.getBoolean("is_resend"))
    {
      paramFromServiceMsg = new Bundle();
      if (k != 0) {
        i = 3;
      }
      paramFromServiceMsg.putInt("param_fail_reason", i);
      notifyObserver(paramIntent, 31, false, paramFromServiceMsg, ContactBindObserver.class);
      return;
    }
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
    localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
  }
  
  private void k(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = paramIntent.getExtras();
    int k = localBundle.getInt("upload_package_no");
    Object localObject1 = localBundle.getString("unique_phone_no");
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 37);
    localNewIntent.putExtra("unique_phone_no", (String)localObject1);
    boolean bool1 = a().isDestroyed();
    boolean bool2 = QLog.isColorLevel();
    i = 2;
    if (bool2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleUploadContactNotBind, ");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject1).append(", packageNo = ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(" isMgrDestroyed = ");
      ((StringBuilder)localObject1).append(bool1);
      QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool1) {
      return;
    }
    try
    {
      bool1 = paramFromServiceMsg.isSuccess();
      if (!bool1) {
        break label791;
      }
      paramFromServiceMsg = a(paramFromServiceMsg);
      localObject1 = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = (ResponeUploadAddressBookNotBind)paramFromServiceMsg.getByClass("ResponeUploadAddressBookNotBind", new ResponeUploadAddressBookNotBind());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleUploadContactNotBind, result = ");
        ((StringBuilder)localObject2).append(((RespondHeader)localObject1).result);
        QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject2).toString());
      }
      if (((RespondHeader)localObject1).result != 0) {
        break label581;
      }
      localObject1 = (ArrayList)localBundle.getSerializable("contact_list");
      int m = k * 50;
      j = m + 50;
      i = j;
      if (j > ((ArrayList)localObject1).size()) {
        i = ((ArrayList)localObject1).size();
      }
      localObject2 = ((ArrayList)localObject1).subList(m, i);
      a().markUploadedContactNotBind((List)localObject2);
      a().saveContactFromServerNotBind(true, k, paramFromServiceMsg.nextFlag, paramFromServiceMsg.timeStamp, paramFromServiceMsg.BindFriendContacts, paramFromServiceMsg.BindNotFriendContacts);
      localObject2 = new Bundle();
      if (((ArrayList)localObject1).size() == 0) {
        break label951;
      }
      j = m * 100 / ((ArrayList)localObject1).size();
    }
    catch (Exception paramFromServiceMsg)
    {
      for (;;)
      {
        Object localObject2;
        label581:
        continue;
        label791:
        int j = 100;
        continue;
        i = 100;
        continue;
        i = 3;
        continue;
        i = 5;
        continue;
        i = 3;
      }
    }
    if (((ArrayList)localObject1).size() != 0)
    {
      i = (i + 50) * 100 / ((ArrayList)localObject1).size();
      i = Math.min(i, 100);
      ((Bundle)localObject2).putInt("current_percentage", j);
      ((Bundle)localObject2).putInt("expected_percentage", i);
      notifyObserver(paramIntent, 100, true, (Bundle)localObject2, ContactBindObserver.class);
      if (paramFromServiceMsg.nextFlag != 4294967295L)
      {
        localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
        localNewIntent.putExtra("upload_package_no", k + 1);
        localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
        localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
        localNewIntent.putExtra("is_resend", false);
        localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
        getAppRuntime().startServlet(localNewIntent);
        return;
      }
      notifyObserver(paramIntent, 37, true, null, ContactBindObserver.class);
      return;
      if ((((RespondHeader)localObject1).result != 109) && (((RespondHeader)localObject1).result != 108))
      {
        if (localBundle.getBoolean("is_resend"))
        {
          paramFromServiceMsg = new Bundle();
          if (k != 0) {
            break label964;
          }
          paramFromServiceMsg.putInt("param_fail_reason", i);
          notifyObserver(paramIntent, 37, false, paramFromServiceMsg, ContactBindObserver.class);
          return;
        }
        localNewIntent.putExtra("is_resend", true);
        localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
        localNewIntent.putExtra("upload_package_no", k);
        localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
        localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
        localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
        getAppRuntime().startServlet(localNewIntent);
        return;
      }
      paramFromServiceMsg = new Bundle();
      if (((RespondHeader)localObject1).result != 109) {
        break label969;
      }
      i = 4;
      paramFromServiceMsg.putInt("param_fail_reason", i);
      notifyObserver(paramIntent, 37, false, paramFromServiceMsg, ContactBindObserver.class);
      return;
      if (localBundle.getBoolean("is_resend"))
      {
        paramFromServiceMsg = new Bundle();
        if (k != 0) {
          break label974;
        }
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 37, false, paramFromServiceMsg, ContactBindObserver.class);
        return;
      }
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
      localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
      return;
      notifyObserver(paramIntent, 37, false, null, ContactBindObserver.class);
    }
  }
  
  private void l(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (a().isDestroyed()) {
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      Bundle localBundle = paramIntent.getExtras();
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      ResponeQueryLastLoginState localResponeQueryLastLoginState = (ResponeQueryLastLoginState)((UniPacket)localObject).getByClass("ResponeQueryLastLoginState", new ResponeQueryLastLoginState());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(100);
        ((StringBuilder)localObject).append("handleLastLogin, nextflag = ");
        ((StringBuilder)localObject).append(localResponeQueryLastLoginState.nextFlag);
        ((StringBuilder)localObject).append(", result = ");
        ((StringBuilder)localObject).append(paramFromServiceMsg.result);
        ((StringBuilder)localObject).append(", lastUsedFlag = ");
        ((StringBuilder)localObject).append(localResponeQueryLastLoginState.lastUsedFlag);
        ((StringBuilder)localObject).append(", mobile = ");
        boolean bool;
        if ((!TextUtils.isEmpty(localResponeQueryLastLoginState.mobileNo)) && (!TextUtils.isEmpty(localResponeQueryLastLoginState.nationCode))) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject).append(bool);
        QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramFromServiceMsg.result == 0) && (!TextUtils.isEmpty(localResponeQueryLastLoginState.mobileNo)) && (!TextUtils.isEmpty(localResponeQueryLastLoginState.nationCode)) && (localResponeQueryLastLoginState.lastUsedFlag == 1L))
      {
        localObject = localBundle.getStringArrayList("param_last_login_list");
        paramFromServiceMsg = (FromServiceMsg)localObject;
        if (localObject == null) {
          paramFromServiceMsg = new ArrayList();
        }
        if (localResponeQueryLastLoginState.lastLoginList.size() > 0)
        {
          paramFromServiceMsg.ensureCapacity(paramFromServiceMsg.size() + localResponeQueryLastLoginState.lastLoginList.size());
          localObject = localResponeQueryLastLoginState.lastLoginList.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramFromServiceMsg.add(((LastLoginInfo)((Iterator)localObject).next()).contactsInfoEncrypt);
          }
        }
        if (localResponeQueryLastLoginState.nextFlag != 4294967295L)
        {
          paramIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
          paramIntent.putExtra("req_type", 32);
          paramIntent.putExtra("next_flag", localResponeQueryLastLoginState.nextFlag);
          paramIntent.putExtra("time_stamp", localResponeQueryLastLoginState.timeStamp);
          paramIntent.putExtra("unique_phone_no", localBundle.getString("unique_phone_no"));
          paramIntent.putExtra("param_last_login_list", paramFromServiceMsg);
          getAppRuntime().startServlet(paramIntent);
          return;
        }
        a().saveLastLoginList(paramFromServiceMsg, localResponeQueryLastLoginState.timeStamp, localResponeQueryLastLoginState.interval);
        notifyObserver(paramIntent, 32, true, null, ContactBindObserver.class);
        return;
      }
      notifyObserver(paramIntent, 32, false, null, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 32, false, null, ContactBindObserver.class);
  }
  
  private void m(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 15);
    localNewIntent.putExtra("unique_phone_no", localBundle.getString("unique_phone_no"));
    int k = localBundle.getInt("upload_package_no");
    if (a().isDestroyed()) {
      return;
    }
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      Object localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = (ResponeUpdateAddressBook)paramFromServiceMsg.getByClass("ResponeUpdateAddressBook", new ResponeUpdateAddressBook());
      if (((RespondHeader)localObject).result == 0)
      {
        localObject = (ArrayList)localBundle.getSerializable("add_contact_list");
        int m = k * 50;
        if (m < ((List)localObject).size())
        {
          int j = m + 50;
          i = j;
          if (j > ((List)localObject).size()) {
            i = ((List)localObject).size();
          }
          localObject = ((List)localObject).subList(m, i);
          a().markUploadedContact((List)localObject);
        }
        if (paramFromServiceMsg.nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
          localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
          localNewIntent.putExtra("rename_contact_list", (ArrayList)localBundle.getSerializable("rename_contact_list"));
          localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        notifyObserver(paramIntent, 15, true, null, ContactBindObserver.class);
        if (localBundle.containsKey("add_contact_list"))
        {
          paramIntent = (ArrayList)localBundle.getSerializable("rename_contact_list");
          if (paramIntent.size() == 0) {
            return;
          }
          a().updateRenameList(paramIntent);
        }
      }
      else
      {
        if (((RespondHeader)localObject).result == 105)
        {
          a().saveBindInfo(null, "handleUpdateContact");
          paramFromServiceMsg = new Bundle();
          paramFromServiceMsg.putInt("param_fail_reason", 1);
          notifyObserver(paramIntent, 15, false, paramFromServiceMsg, ContactBindObserver.class);
          return;
        }
        if (localBundle.getBoolean("is_resend"))
        {
          paramFromServiceMsg = new Bundle();
          if (k == 0) {
            i = 2;
          } else {
            i = 3;
          }
          paramFromServiceMsg.putInt("param_fail_reason", i);
          notifyObserver(paramIntent, 15, false, paramFromServiceMsg, ContactBindObserver.class);
          return;
        }
        localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
        localNewIntent.putExtra("upload_package_no", k);
        localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
        localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
        localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
        localNewIntent.putExtra("is_resend", true);
        localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
        getAppRuntime().startServlet(localNewIntent);
      }
    }
    else
    {
      if (localBundle.getBoolean("is_resend"))
      {
        paramFromServiceMsg = new Bundle();
        if (k == 0) {
          i = 2;
        } else {
          i = 3;
        }
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 15, false, paramFromServiceMsg, ContactBindObserver.class);
        return;
      }
      localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
      localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
      localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
    }
  }
  
  private void n(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 38);
    localNewIntent.putExtra("unique_phone_no", localBundle.getString("unique_phone_no"));
    int k = localBundle.getInt("upload_package_no");
    if (a().isDestroyed()) {
      return;
    }
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      localObject = (ResponeUpdateAddressBookNotBind)((UniPacket)localObject).getByClass("ResponeUpdateAddressBookNotBind", new ResponeUpdateAddressBookNotBind());
      if (paramFromServiceMsg.result == 0)
      {
        paramFromServiceMsg = (ArrayList)localBundle.getSerializable("add_contact_list");
        int m = k * 50;
        if (m < paramFromServiceMsg.size())
        {
          int j = m + 50;
          i = j;
          if (j > paramFromServiceMsg.size()) {
            i = paramFromServiceMsg.size();
          }
          paramFromServiceMsg = paramFromServiceMsg.subList(m, i);
          a().markUploadedContactNotBind(paramFromServiceMsg);
        }
        if (((ResponeUpdateAddressBookNotBind)localObject).nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", ((ResponeUpdateAddressBookNotBind)localObject).nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("add_contact_list", localBundle.getSerializable("add_contact_list"));
          localNewIntent.putExtra("del_contact_list", localBundle.getSerializable("del_contact_list"));
          localNewIntent.putExtra("rename_contact_list", localBundle.getSerializable("rename_contact_list"));
          localNewIntent.putExtra("session_id", ((ResponeUpdateAddressBookNotBind)localObject).sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        notifyObserver(paramIntent, 38, true, null, ContactBindObserver.class);
        if (localBundle.containsKey("add_contact_list"))
        {
          paramIntent = (ArrayList)localBundle.getSerializable("rename_contact_list");
          if (paramIntent.size() == 0) {
            return;
          }
          a().updateRenameList(paramIntent);
        }
      }
      else
      {
        if ((paramFromServiceMsg.result != 109) && (paramFromServiceMsg.result != 108))
        {
          if (localBundle.getBoolean("is_resend"))
          {
            paramFromServiceMsg = new Bundle();
            if (k == 0) {
              i = 2;
            } else {
              i = 3;
            }
            paramFromServiceMsg.putInt("param_fail_reason", i);
            notifyObserver(paramIntent, 38, false, paramFromServiceMsg, ContactBindObserver.class);
            return;
          }
          localNewIntent.putExtra("next_flag", ((ResponeUpdateAddressBookNotBind)localObject).nextFlag);
          localNewIntent.putExtra("upload_package_no", k);
          localNewIntent.putExtra("add_contact_list", localBundle.getSerializable("add_contact_list"));
          localNewIntent.putExtra("del_contact_list", localBundle.getSerializable("del_contact_list"));
          localNewIntent.putExtra("session_id", ((ResponeUpdateAddressBookNotBind)localObject).sessionSid);
          localNewIntent.putExtra("is_resend", true);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        a().saveBindInfo(null, "handleUpdateContactNotBind");
        localBundle = new Bundle();
        if (paramFromServiceMsg.result == 109) {
          i = 4;
        } else {
          i = 5;
        }
        localBundle.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 38, false, localBundle, ContactBindObserver.class);
      }
    }
    else
    {
      if (localBundle.getBoolean("is_resend"))
      {
        paramFromServiceMsg = new Bundle();
        if (k == 0) {
          i = 2;
        } else {
          i = 3;
        }
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 38, false, paramFromServiceMsg, ContactBindObserver.class);
        return;
      }
      localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("add_contact_list", localBundle.getSerializable("add_contact_list"));
      localNewIntent.putExtra("del_contact_list", localBundle.getSerializable("del_contact_list"));
      localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
    }
  }
  
  private void o(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (((RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader())).result == 0)
      {
        notifyObserver(paramIntent, 17, true, null, ContactBindObserver.class);
        return;
      }
      notifyObserver(paramIntent, 17, false, null, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 17, false, null, ContactBindObserver.class);
  }
  
  private void p(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = a().isDestroyed();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Query contact v3 resp, ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject).append(" isMgrDestroyed = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject).toString());
    }
    if (bool) {
      return;
    }
    bool = paramFromServiceMsg.isSuccess();
    int j = 0;
    int i = j;
    if (bool)
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = a(paramFromServiceMsg);
      i = j;
      if (localObject != null)
      {
        i = j;
        if (paramFromServiceMsg != null)
        {
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("after get respHeader | result = ");
            localStringBuilder.append(((RespondHeader)localObject).result);
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, localStringBuilder.toString());
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleQueryContactV3 isInactive ");
            localStringBuilder.append(paramFromServiceMsg.isInactive);
            localStringBuilder.append(", ");
            localStringBuilder.append(paramFromServiceMsg.isChangeDev);
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, localStringBuilder.toString());
          }
          i = paramIntent.getExtras().getInt("query_package_no", 0);
          j = paramIntent.getExtras().getInt("param_update_flag", 0);
          long l1 = paramIntent.getExtras().getLong("param_query_from");
          if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, String.format("handleQueryContactV3 pno:%s, flag:%s, from:%s, state: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(paramIntent.getExtras().getInt("param_bind_state")) }));
          }
          if (((RespondHeader)localObject).result == 0)
          {
            a(paramFromServiceMsg);
            localObject = a();
            long l2 = paramFromServiceMsg.nextFlag;
            if (paramFromServiceMsg.queryFlag == 1) {
              bool = true;
            } else {
              bool = false;
            }
            j |= ((IPhoneContactService)localObject).saveContactFromServer(false, i, l2, bool, paramFromServiceMsg.timeStamp, paramFromServiceMsg.MaxsignTimeStamp, paramFromServiceMsg.BindFriendContacts, paramFromServiceMsg.BindNotFriendContacts);
            if (paramFromServiceMsg.nextFlag != 4294967295L)
            {
              int k = a().getBindStateForServer();
              localObject = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
              ((NewIntent)localObject).putExtra("req_type", 30);
              ((NewIntent)localObject).putExtra("query_package_no", i + 1);
              ((NewIntent)localObject).putExtra("next_flag", paramFromServiceMsg.nextFlag);
              ((NewIntent)localObject).putExtra("time_stamp", paramFromServiceMsg.timeStamp);
              ((NewIntent)localObject).putExtra("richinfo_time_stamp", paramFromServiceMsg.MaxsignTimeStamp);
              ((NewIntent)localObject).putExtra("session_id", paramFromServiceMsg.sessionSid);
              ((NewIntent)localObject).putExtra("force_query_list", paramFromServiceMsg.queryFlag);
              ((NewIntent)localObject).putExtra("param_update_flag", j);
              ((NewIntent)localObject).putExtra("unique_phone_no", paramIntent.getExtras().getString("unique_phone_no"));
              ((NewIntent)localObject).putExtra("param_query_from", l1);
              ((NewIntent)localObject).putExtra("param_bind_state", k);
              ((NewIntent)localObject).setObserver(((NewIntent)paramIntent).getObserver());
              getAppRuntime().startServlet((NewIntent)localObject);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "Query contact finish.");
              }
              localObject = new Bundle();
              ((Bundle)localObject).putBoolean("bind_state", true);
              notifyObserver(paramIntent, 12, true, (Bundle)localObject, ContactBindObserver.class);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("param_update_flag", j);
              notifyObserver(paramIntent, 30, true, (Bundle)localObject, ContactBindObserver.class);
            }
          }
          else
          {
            if ((((RespondHeader)localObject).result == 105) || (((RespondHeader)localObject).result == 107)) {
              break label745;
            }
            notifyObserver(paramIntent, 12, false, null, ContactBindObserver.class);
          }
          break label780;
          label745:
          a(paramFromServiceMsg);
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("bind_state", false);
          notifyObserver(paramIntent, 12, true, (Bundle)localObject, ContactBindObserver.class);
          label780:
          a().saveUIBits(paramFromServiceMsg.UIBits);
          i = 1;
        }
      }
    }
    if (i == 0)
    {
      notifyObserver(paramIntent, 12, false, null, ContactBindObserver.class);
      if (a().getSelfBindState() == 9) {
        notifyObserver(paramIntent, 30, false, null, ContactBindObserver.class);
      }
    }
  }
  
  private void q(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespondHeader)a(paramFromServiceMsg).getByClass("RespondHeader", new RespondHeader());
      if (paramFromServiceMsg == null)
      {
        notifyObserver(paramIntent, 34, false, localBundle, ContactBindObserver.class);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleHideContact respHeader.result =");
        localStringBuilder.append(paramFromServiceMsg.result);
        QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, localStringBuilder.toString());
      }
      if (paramFromServiceMsg.result == 0)
      {
        boolean bool = paramIntent.getBooleanExtra("param_hiden_flag", false);
        a().changeHidenStatus(paramIntent.getStringExtra("unique_phone_no"), bool);
        notifyObserver(paramIntent, 34, true, localBundle, ContactBindObserver.class);
        return;
      }
      notifyObserver(paramIntent, 34, false, localBundle, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 34, false, localBundle, ContactBindObserver.class);
  }
  
  private void r(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      localObject1 = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      if ((localObject1 != null) && (((RespondHeader)localObject1).result == 0))
      {
        localObject1 = ((ResponeQueryNewUserRecommendedList)paramFromServiceMsg.getByClass("ResponeQueryNewUserRecommendedList", new ResponeQueryNewUserRecommendedList())).RecommendedContacts;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFromServiceMsg = new ArrayList();
          Object localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            RecommendedContactInfo localRecommendedContactInfo = (RecommendedContactInfo)((Iterator)localObject2).next();
            RecommendContactInfo localRecommendContactInfo = new RecommendContactInfo(localRecommendedContactInfo);
            if (a(localRecommendedContactInfo, localRecommendContactInfo)) {
              paramFromServiceMsg.add(localRecommendContactInfo);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleGetNewer origin: ");
            ((StringBuilder)localObject2).append(((List)localObject1).size());
            ((StringBuilder)localObject2).append(", handled: ");
            ((StringBuilder)localObject2).append(paramFromServiceMsg.size());
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject2).toString());
          }
          bool = true;
          break label228;
        }
      }
    }
    boolean bool = false;
    paramFromServiceMsg = null;
    label228:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGetNewerGuideRecommended ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putParcelableArrayList(RecommendContactInfo.class.getSimpleName(), paramFromServiceMsg);
    notifyObserver(paramIntent, 36, true, (Bundle)localObject1, ContactBindObserver.class);
  }
  
  private void s(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      localObject1 = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      if ((localObject1 != null) && (((RespondHeader)localObject1).result == 0))
      {
        localObject1 = ((ResponeQueryNewUserRecommendedListNotBind)paramFromServiceMsg.getByClass("ResponeQueryNewUserRecommendedListNotBind", new ResponeQueryNewUserRecommendedListNotBind())).RecommendedContacts;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFromServiceMsg = new ArrayList();
          Object localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            RecommendedContactInfo localRecommendedContactInfo = (RecommendedContactInfo)((Iterator)localObject2).next();
            RecommendContactInfo localRecommendContactInfo = new RecommendContactInfo(localRecommendedContactInfo);
            if (a(localRecommendedContactInfo, localRecommendContactInfo)) {
              paramFromServiceMsg.add(localRecommendContactInfo);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleGetNewerGuideRecommendedNotBind origin: ");
            ((StringBuilder)localObject2).append(((List)localObject1).size());
            ((StringBuilder)localObject2).append(", handled: ");
            ((StringBuilder)localObject2).append(paramFromServiceMsg.size());
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject2).toString());
          }
          bool = true;
          break label228;
        }
      }
    }
    boolean bool = false;
    paramFromServiceMsg = null;
    label228:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGetNewerGuideRecommendedNotBind ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putParcelableArrayList(RecommendContactInfo.class.getSimpleName(), paramFromServiceMsg);
    notifyObserver(paramIntent, 40, true, (Bundle)localObject1, ContactBindObserver.class);
  }
  
  public boolean a(RecommendedContactInfo paramRecommendedContactInfo, RecommendContactInfo paramRecommendContactInfo)
  {
    if (!TextUtils.isEmpty(paramRecommendedContactInfo.contactsInfoEncrypt))
    {
      paramRecommendedContactInfo.contactsInfoEncrypt = paramRecommendedContactInfo.contactsInfoEncrypt.toUpperCase();
      PhoneContact localPhoneContact = a().getPhoneContactByMD5(paramRecommendedContactInfo.contactsInfoEncrypt);
      if (localPhoneContact != null)
      {
        paramRecommendContactInfo.g = PhoneContactUtils.a(paramRecommendedContactInfo.MobileNoMask, localPhoneContact.mobileNo);
        paramRecommendContactInfo.h = localPhoneContact.name;
        if ((!TextUtils.isEmpty(paramRecommendContactInfo.g)) && (!TextUtils.isEmpty(paramRecommendContactInfo.h))) {
          return true;
        }
      }
      else
      {
        paramRecommendContactInfo = new StringBuilder();
        paramRecommendContactInfo.append("test .. fillNewerGuideInfo no contact ");
        paramRecommendContactInfo.append(paramRecommendedContactInfo.contactsInfoEncrypt);
        QLog.d("newerguide", 2, paramRecommendContactInfo.toString());
      }
    }
    return false;
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "account.ResponseNotifyForRecommendUpdate" };
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str == null) {
      return;
    }
    if (str.equals("account.RequestQueryQQBindingStat"))
    {
      c(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestBindMobileV2"))
    {
      d(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestReBindMobile"))
    {
      e(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestCancelBindMobile"))
    {
      f(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestDisableMobileBind"))
    {
      g(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestVerifyBindingSmscode"))
    {
      h(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestResendBindingSmscode"))
    {
      o(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestQueryQQMobileContactsV2")) {
      return;
    }
    if (str.equals("account.RequestQueryQQMobileContactsV3"))
    {
      ThreadManager.excute(new ContactBindServlet.1(this, paramIntent, paramFromServiceMsg), 16, null, false);
      return;
    }
    if (str.equals("account.RequestUploadAddressBook"))
    {
      i(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestUpdateAddressBook"))
    {
      m(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestGetRecommendedListV2")) {
      return;
    }
    if (str.equals("account.ResponseNotifyForRecommendUpdate")) {
      return;
    }
    if (str.equals("account.RequestVerifyWTLogin_emp"))
    {
      a(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestReBindMblWTLogin_emp"))
    {
      b(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestUploadAddressBookV2"))
    {
      j(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestQueryLastLoginState"))
    {
      l(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestHideContact"))
    {
      q(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestQueryNewUserRecommendedList"))
    {
      r(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestQueryNewUserRecommendedListNotBind"))
    {
      s(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestUploadAddressBookNotBind"))
    {
      k(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str.equals("account.RequestUpdateAddressBookNotBind")) {
      n(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {
      return;
    }
    paramPacket.setServantName("AccountServer");
    paramPacket.setFuncName("AccountServerFunc");
    Object localObject2 = a(0, 0, 0);
    Object localObject3;
    int k;
    int j;
    int i;
    int m;
    switch (((Bundle)localObject1).getInt("req_type", 0))
    {
    case 13: 
    case 18: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 29: 
    case 39: 
    default: 
      return;
    case 40: 
      paramPacket.setSSOCommand("account.RequestQueryNewUserRecommendedListNotBind");
      ((RequestHeader)localObject2).cmd = 40;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryNewUserRecommendedListNotBind();
      paramIntent.MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      paramIntent.WantNum = ((Bundle)localObject1).getInt("wantCount");
      paramPacket.addRequestPacket("RequestQueryNewUserRecommendedListNotBind", paramIntent);
      return;
    case 38: 
      paramPacket.setSSOCommand("account.RequestUpdateAddressBookNotBind");
      ((RequestHeader)localObject2).cmd = 38;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("add_contact_list");
      localObject2 = (ArrayList)((Bundle)localObject1).getSerializable("del_contact_list");
      localObject3 = new RequestUpdateAddressBookNotBind();
      ((RequestUpdateAddressBookNotBind)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      ((RequestUpdateAddressBookNotBind)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      k = ((Bundle)localObject1).getInt("upload_package_no") * 50;
      j = k + 50;
      if (((paramIntent != null) && (j < paramIntent.size())) || ((localObject2 != null) && (j < ((ArrayList)localObject2).size()))) {
        ((RequestUpdateAddressBookNotBind)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag");
      } else {
        ((RequestUpdateAddressBookNotBind)localObject3).nextFlag = 4294967295L;
      }
      if ((paramIntent != null) && (k < paramIntent.size()))
      {
        i = j;
        if (j > paramIntent.size()) {
          i = paramIntent.size();
        }
        ((RequestUpdateAddressBookNotBind)localObject3).AddressBookAddList = new ArrayList(paramIntent.subList(k, i));
      }
      else
      {
        ((RequestUpdateAddressBookNotBind)localObject3).AddressBookAddList = null;
        i = j;
      }
      if ((localObject2 != null) && (k < ((ArrayList)localObject2).size()))
      {
        j = i;
        if (i > ((ArrayList)localObject2).size()) {
          j = ((ArrayList)localObject2).size();
        }
        ((RequestUpdateAddressBookNotBind)localObject3).AddressBookDelList = new ArrayList(((ArrayList)localObject2).subList(k, j));
      }
      else
      {
        ((RequestUpdateAddressBookNotBind)localObject3).AddressBookDelList = null;
      }
      paramPacket.addRequestPacket("RequestUpdateAddressBookNotBind", (JceStruct)localObject3);
      return;
    case 37: 
      paramPacket.setSSOCommand("account.RequestUploadAddressBookNotBind");
      ((RequestHeader)localObject2).cmd = 37;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      j = ((Bundle)localObject1).getInt("upload_package_no");
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("contact_list");
      k = j * 50;
      m = paramIntent.size();
      i = k + 50;
      if (m <= i - 1) {
        i = paramIntent.size();
      }
      localObject2 = paramIntent.subList(k, i);
      localObject3 = new RequestUploadAddressBookNotBind();
      ((RequestUploadAddressBookNotBind)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      ((RequestUploadAddressBookNotBind)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      if ((j + 1) * 50 >= paramIntent.size()) {
        ((RequestUploadAddressBookNotBind)localObject3).nextFlag = 4294967295L;
      } else {
        ((RequestUploadAddressBookNotBind)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag");
      }
      ((RequestUploadAddressBookNotBind)localObject3).AddressBookList = new ArrayList((Collection)localObject2);
      paramPacket.addRequestPacket("RequestUploadAddressBookNotBind", (JceStruct)localObject3);
      return;
    case 36: 
      paramPacket.setSSOCommand("account.RequestQueryNewUserRecommendedList");
      ((RequestHeader)localObject2).cmd = 36;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryNewUserRecommendedList();
      paramIntent.MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      paramIntent.WantNum = ((Bundle)localObject1).getInt("wantCount");
      paramPacket.addRequestPacket("RequestQueryNewUserRecommendedList", paramIntent);
      return;
    case 35: 
      paramPacket.setSSOCommand("account.RequestBindMobileV2");
      ((RequestHeader)localObject2).cmd = 35;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestBindMobileV2();
      paramIntent.nationCode = ((Bundle)localObject1).getString("country_code");
      if (((Bundle)localObject1).getBoolean("cmd_param_is_encrypt", false))
      {
        paramIntent.isSecNewReq = true;
        paramIntent.encrptBindMobileInfo = ((Bundle)localObject1).getByteArray("cmd_param_encrypt_mobile");
      }
      else
      {
        paramIntent.mobileNo = ((Bundle)localObject1).getString("phone_number");
      }
      paramIntent.type = ((Bundle)localObject1).getInt("cmd_param_bind_type");
      paramIntent.isFromUni = ((Bundle)localObject1).getBoolean("cmd_param_is_from_uni", false);
      paramIntent.isFromChangeBind = ((Bundle)localObject1).getBoolean("cmd_param_is_from_change_bind", false);
      paramPacket.addRequestPacket("RequestBindMobileV2", paramIntent);
      return;
    case 34: 
      paramPacket.setSSOCommand("account.RequestHideContact");
      ((RequestHeader)localObject2).cmd = 34;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestHideContact();
      paramIntent.contact = ((AddressBookItem)((Bundle)localObject1).getSerializable("param_hiden_mobile"));
      paramIntent.isHide = ((Bundle)localObject1).getBoolean("param_hiden_flag");
      paramPacket.addRequestPacket("RequestHideContact", paramIntent);
      return;
    case 33: 
      paramPacket.setSSOCommand("account.RequestDisableMobileBind");
      ((RequestHeader)localObject2).cmd = 33;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      localObject1 = paramIntent.getStringExtra("country_code");
      paramIntent = paramIntent.getStringExtra("phone_number");
      localObject2 = new RequestDisableMobileBind((String)localObject1, paramIntent);
      ((RequestDisableMobileBind)localObject2).nationCode = ((String)localObject1);
      ((RequestDisableMobileBind)localObject2).mobileNo = paramIntent;
      paramPacket.addRequestPacket("RequestDisableMobileBind", (JceStruct)localObject2);
      return;
    case 32: 
      paramPacket.setSSOCommand("account.RequestQueryLastLoginState");
      ((RequestHeader)localObject2).cmd = 32;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryLastLoginState();
      paramIntent.nextFlag = ((Bundle)localObject1).getLong("next_flag");
      paramIntent.timeStamp = ((Bundle)localObject1).getLong("time_stamp");
      paramIntent.MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      paramPacket.addRequestPacket("RequestQueryLastLoginState", paramIntent);
      return;
    case 31: 
      paramPacket.setSSOCommand("account.RequestUploadAddressBookV2");
      ((RequestHeader)localObject2).cmd = 31;
      ((RequestHeader)localObject2).cmd = 31;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      j = ((Bundle)localObject1).getInt("upload_package_no");
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("contact_list");
      k = j * 50;
      m = paramIntent.size();
      i = k + 50;
      if (m <= i - 1) {
        i = paramIntent.size();
      }
      localObject2 = paramIntent.subList(k, i);
      localObject3 = new RequestUploadAddressBookV2();
      ((RequestUploadAddressBookV2)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      ((RequestUploadAddressBookV2)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      if ((j + 1) * 50 >= paramIntent.size()) {
        ((RequestUploadAddressBookV2)localObject3).nextFlag = 4294967295L;
      } else {
        ((RequestUploadAddressBookV2)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag");
      }
      ((RequestUploadAddressBookV2)localObject3).AddressBookList = new ArrayList((Collection)localObject2);
      paramPacket.addRequestPacket("RequestUploadAddressBookV2", (JceStruct)localObject3);
      return;
    case 30: 
      paramPacket.setSSOCommand("account.RequestQueryQQMobileContactsV3");
      ((RequestHeader)localObject2).cmd = 30;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryQQMobileContactsV3();
      paramIntent.Compressd = true;
      paramIntent.nextFlag = ((Bundle)localObject1).getLong("next_flag");
      paramIntent.timeStamp = ((Bundle)localObject1).getLong("time_stamp");
      paramIntent.sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      paramIntent.MaxsignTimeStamp = ((Bundle)localObject1).getLong("richinfo_time_stamp");
      paramIntent.MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      paramIntent.queryFlag = ((Bundle)localObject1).getInt("force_query_list");
      paramIntent.queryFrom = ((Bundle)localObject1).getLong("param_query_from");
      paramIntent.OmitOffline = true;
      paramIntent.bindState = ((Bundle)localObject1).getInt("param_bind_state");
      paramPacket.addRequestPacket("RequestQueryQQMobileContactsV3", paramIntent);
      return;
    case 28: 
      paramPacket.setSSOCommand("account.RequestQueryQQMobileContactsV2");
      ((RequestHeader)localObject2).cmd = 28;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryQQMobileContactsV2();
      paramIntent.Compressd = true;
      paramIntent.nextFlag = ((Bundle)localObject1).getLong("next_flag");
      paramIntent.timeStamp = ((Bundle)localObject1).getLong("time_stamp");
      paramIntent.sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      paramPacket.addRequestPacket("RequestQueryQQMobileContactsV2", paramIntent);
      return;
    case 27: 
      paramPacket.setAccount("0");
      paramPacket.setSSOCommand("account.RequestReBindMblWTLogin_emp");
      ((RequestHeader)localObject2).cmd = 27;
      try
      {
        ((RequestHeader)localObject2).uin = Long.parseLong(((Bundle)localObject1).getString("cmd_param_phone_uin"));
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestReBindMblWTLogin();
      paramIntent.encryptBuffer = ((Bundle)localObject1).getByteArray("cmd_param_phone_bind_sign");
      paramPacket.addRequestPacket("RequestReBindMblWTLogin", paramIntent);
      return;
    case 26: 
      paramPacket.setAccount("0");
      paramPacket.setSSOCommand("account.RequestVerifyWTLogin_emp");
      ((RequestHeader)localObject2).cmd = 26;
      try
      {
        ((RequestHeader)localObject2).uin = Long.parseLong(((Bundle)localObject1).getString("cmd_param_phone_uin"));
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestVerifyWTLogin();
      paramIntent.encryptBuffer = ((Bundle)localObject1).getByteArray("cmd_param_phone_bind_sign");
      paramPacket.addRequestPacket("RequestVerifyWTLogin", paramIntent);
      return;
    case 20: 
      paramPacket.setSSOCommand("account.RequestCancelBindMobile");
      ((RequestHeader)localObject2).cmd = 20;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestCancelBindMobile();
      paramIntent.nationCode = ((Bundle)localObject1).getString("country_code");
      if (((Bundle)localObject1).getBoolean("cmd_param_is_encrypt", false))
      {
        paramIntent.isSecNewReq = true;
        paramIntent.encrptCancelMobileInfo = ((Bundle)localObject1).getByteArray("cmd_param_encrypt_mobile");
      }
      else
      {
        paramIntent.mobileNo = ((Bundle)localObject1).getString("phone_number");
      }
      paramIntent.isFromUni = ((Bundle)localObject1).getBoolean("cmd_param_is_from_uni", false);
      paramIntent.isFromChangeBind = ((Bundle)localObject1).getBoolean("cmd_param_is_from_change_bind", false);
      paramPacket.addRequestPacket("RequestCancelBindMobile", paramIntent);
      return;
    case 19: 
      paramPacket.setSSOCommand("account.RequestReBindMobile");
      ((RequestHeader)localObject2).cmd = 19;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestReBindMobile();
      paramIntent.nationCode = ((Bundle)localObject1).getString("country_code");
      if (((Bundle)localObject1).getBoolean("cmd_param_is_encrypt", false))
      {
        paramIntent.isSecNewReq = true;
        paramIntent.encrptBindMobileInfo = ((Bundle)localObject1).getByteArray("cmd_param_encrypt_mobile");
      }
      else
      {
        paramIntent.mobileNo = ((Bundle)localObject1).getString("phone_number");
      }
      paramIntent.type = ((Bundle)localObject1).getInt("cmd_param_bind_type");
      paramIntent.isFromUni = ((Bundle)localObject1).getBoolean("cmd_param_is_from_uni", false);
      paramIntent.isFromChangeBind = ((Bundle)localObject1).getBoolean("cmd_param_is_from_change_bind", false);
      paramPacket.addRequestPacket("RequestReBindMobile", paramIntent);
      return;
    case 17: 
      paramPacket.setSSOCommand("account.RequestResendBindingSmscode");
      ((RequestHeader)localObject2).cmd = 17;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestResendSmscode();
      paramIntent.sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      paramPacket.addRequestPacket("RequestResendSmscode", paramIntent);
      return;
    case 16: 
      paramPacket.setSSOCommand("account.RequestVerifyBindingSmscode");
      ((RequestHeader)localObject2).cmd = 16;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestVerifySmscode();
      paramIntent.smsCode = ((Bundle)localObject1).getString("verify_smscode");
      paramIntent.sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      paramIntent.type = ((Bundle)localObject1).getInt("cmd_param_bind_type");
      paramIntent.isFromUni = ((Bundle)localObject1).getBoolean("cmd_param_is_from_uni", false);
      paramIntent.isFromChangeBind = ((Bundle)localObject1).getBoolean("cmd_param_is_from_change_bind", false);
      paramPacket.addRequestPacket("RequestVerifySmscode", paramIntent);
      return;
    case 15: 
      paramPacket.setSSOCommand("account.RequestUpdateAddressBook");
      ((RequestHeader)localObject2).cmd = 15;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("add_contact_list");
      localObject2 = (ArrayList)((Bundle)localObject1).getSerializable("del_contact_list");
      localObject3 = new RequestUpdateAddressBook();
      ((RequestUpdateAddressBook)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      ((RequestUpdateAddressBook)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      k = ((Bundle)localObject1).getInt("upload_package_no") * 50;
      j = k + 50;
      if (((paramIntent != null) && (j < paramIntent.size())) || ((localObject2 != null) && (j < ((ArrayList)localObject2).size()))) {
        ((RequestUpdateAddressBook)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag");
      } else {
        ((RequestUpdateAddressBook)localObject3).nextFlag = 4294967295L;
      }
      if ((paramIntent != null) && (k < paramIntent.size()))
      {
        i = j;
        if (j > paramIntent.size()) {
          i = paramIntent.size();
        }
        ((RequestUpdateAddressBook)localObject3).AddressBookAddList = new ArrayList(paramIntent.subList(k, i));
      }
      else
      {
        ((RequestUpdateAddressBook)localObject3).AddressBookAddList = null;
        i = j;
      }
      if ((localObject2 != null) && (k < ((ArrayList)localObject2).size()))
      {
        j = i;
        if (i > ((ArrayList)localObject2).size()) {
          j = ((ArrayList)localObject2).size();
        }
        ((RequestUpdateAddressBook)localObject3).AddressBookDelList = new ArrayList(((ArrayList)localObject2).subList(k, j));
      }
      else
      {
        ((RequestUpdateAddressBook)localObject3).AddressBookDelList = null;
      }
      paramPacket.addRequestPacket("RequestUpdateAddressBook", (JceStruct)localObject3);
      return;
    case 14: 
      paramPacket.setSSOCommand("account.RequestUploadAddressBook");
      ((RequestHeader)localObject2).cmd = 14;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      j = ((Bundle)localObject1).getInt("upload_package_no");
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("contact_list");
      k = j * 50;
      m = paramIntent.size();
      i = k + 50;
      if (m <= i - 1) {
        i = paramIntent.size();
      }
      localObject2 = paramIntent.subList(k, i);
      localObject3 = new RequestUploadAddressBook();
      ((RequestUploadAddressBook)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      ((RequestUploadAddressBook)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      if ((j + 1) * 50 >= paramIntent.size()) {
        ((RequestUploadAddressBook)localObject3).nextFlag = 4294967295L;
      } else {
        ((RequestUploadAddressBook)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag");
      }
      ((RequestUploadAddressBook)localObject3).AddressBookList = new ArrayList((Collection)localObject2);
      paramPacket.addRequestPacket("RequestUploadAddressBook", (JceStruct)localObject3);
      return;
    }
    paramPacket.setSSOCommand("account.RequestQueryQQBindingStat");
    ((RequestHeader)localObject2).cmd = 12;
    paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
    paramPacket.addRequestPacket("RequestQueryQQBindingStat", new RequestQueryQQBindingStat(a().getUNIQUE_NO()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.handler.ContactBindServlet
 * JD-Core Version:    0.7.0.1
 */