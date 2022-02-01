package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardQFavBatchOption
  extends ForwardBaseOption
{
  boolean j = false;
  boolean k;
  
  public ForwardQFavBatchOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_k_of_type_Boolean = false;
  }
  
  private String a(Bundle paramBundle)
  {
    Object localObject1;
    if (paramBundle == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      int i;
      do
      {
        return localObject1;
        localObject2 = paramBundle.getString("forward_extra");
        i = paramBundle.getInt("qfavType");
        if ((i == 5) || (i == 8)) {
          break;
        }
        localObject1 = localObject2;
      } while (i != 2);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramBundle.getString("forward_extra");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramBundle.getString("forward_filepath");
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    return paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
  }
  
  private void a(Intent paramIntent, Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    paramString1 = ShortVideoBusiManager.a(3, 2);
    paramIntent.putExtras(paramBundle);
    paramIntent = ShortVideoBusiManager.a(2, paramIntent, paramString1);
    paramIntent.c = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    paramIntent.d = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    paramIntent.b = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    paramIntent.jdField_a_of_type_Int = 2;
    paramIntent.p = paramInt2;
    paramString1.a(paramIntent);
    ShortVideoBusiManager.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 5, 0, paramInt3);
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    String str = AppConstants.DATALINE_PC_UIN;
    paramBundle = QfavHelper.a(paramBundle, str, 7);
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramBundle, str, 6000, paramInt);
  }
  
  private void a(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    paramBundle.putString("struct_share_key_source_icon", BaseApplicationImpl.getContext().getString(2131692282));
    paramBundle.putString("app_name", BaseApplicationImpl.getContext().getString(2131692280));
    paramBundle.putString("struct_share_key_source_action", "plugin");
    paramBundle.putString("struct_share_key_source_action_data", "qqfav://operation/2");
    paramBundle.putInt("req_type", 133);
    boolean bool1 = false;
    int i = 0;
    boolean bool2 = paramBundle.getBoolean("bFriendCard", false);
    Object localObject1 = paramBundle.getByteArray("sBizDataList");
    Object localObject2;
    if (paramInt1 == 6)
    {
      i = paramBundle.getInt("nLinkType");
      if ((i == 4) || (i == 5))
      {
        localObject2 = new ArkAppMessage();
        ((ArkAppMessage)localObject2).fromAppXml(new String((byte[])localObject1));
        localObject2 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramInt2, (ArkAppMessage)localObject2);
        ForwardOrderManager.a().a(((MessageForArkApp)localObject2).uniseq, ((MessageForArkApp)localObject2).uniseq, paramInt3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, null);
        bool1 = true;
        i = 0;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (i != 0)
        {
          bool2 = bool1;
          if (localObject1 != null)
          {
            localObject1 = StructMsgFactory.a((byte[])localObject1, 0);
            bool2 = bool1;
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              i = MobileQQService.seq;
              MobileQQService.seq = i + 1;
              localObject2 = MessageRecordFactory.a((QQAppInterface)localObject2, paramString3, paramString1, paramString2, paramInt2, i, (AbsStructMsg)localObject1);
              ForwardOrderManager.a().a(((MessageForStructing)localObject2).uniseq, ((AbsStructMsg)localObject1).uniseq, paramInt3);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, null);
              bool2 = true;
            }
          }
        }
      }
      if (!bool2)
      {
        paramBundle = StructMsgFactory.a(paramBundle);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = MobileQQService.seq;
        MobileQQService.seq = i + 1;
        paramString1 = MessageRecordFactory.a((QQAppInterface)localObject1, paramString3, paramString1, paramString2, paramInt2, i, paramBundle);
        ForwardOrderManager.a().a(paramString1.uniseq, paramBundle.uniseq, paramInt3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, null);
      }
      if (paramInt1 == 8)
      {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 8, 0, paramInt4);
        return;
        if ((i == 6) || (i == 7))
        {
          i = 1;
          continue;
        }
        if (i != 8) {
          break label476;
        }
        bool1 = a((byte[])localObject1, paramString1, paramString1, paramString2, paramInt2, paramInt3);
        i = 0;
        continue;
        if ((bool2) && (localObject1 != null))
        {
          i = 1;
          bool1 = false;
        }
      }
      else
      {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 2, 0, paramInt4);
        return;
      }
      bool1 = false;
      continue;
      label476:
      i = 0;
    }
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    paramString4 = new SessionInfo();
    paramString4.jdField_a_of_type_JavaLangString = paramString2;
    paramString4.d = paramString1;
    paramString4.jdField_a_of_type_Int = paramInt1;
    paramString4.b = paramString3;
    paramString1 = paramBundle.getString("lat");
    paramString2 = paramBundle.getString("lon");
    paramString3 = paramBundle.getString("title");
    paramBundle = paramBundle.getString("address");
    this.jdField_a_of_type_AndroidOsBundle.putInt("isArk", 1);
    ChatActivityFacade.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString1, paramString2, paramBundle, paramString3, paramBundle, null, "", "", "", this.jdField_a_of_type_AndroidOsBundle);
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 7, 0, paramInt3);
  }
  
  private boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    Object localObject;
    for (paramArrayOfByte = new String(paramArrayOfByte);; paramArrayOfByte = (byte[])localObject) {
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        if (paramArrayOfByte == null) {
          return false;
        }
        paramArrayOfByte = paramArrayOfByte.optJSONObject("arkAppInfo");
        if (paramArrayOfByte == null) {
          return false;
        }
        localObject = paramArrayOfByte.optString("appName");
        String str1 = paramArrayOfByte.optString("appDesc");
        String str2 = paramArrayOfByte.optString("appMinVersion", "0.0.0.1");
        String str3 = paramArrayOfByte.optString("appView");
        String str4 = paramArrayOfByte.optString("appConfig");
        String str5 = paramArrayOfByte.optString("metaData");
        paramArrayOfByte = new ArkAppMessage(paramArrayOfByte.optString("promptText"), (String)localObject, str1, str3, str2, str5, str4, "");
        localObject = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, (String)localObject, this.jdField_a_of_type_AndroidOsBundle, paramArrayOfByte);
        if (localObject == null)
        {
          localObject = new SessionInfo();
          ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((SessionInfo)localObject).d = paramString1;
          ((SessionInfo)localObject).jdField_a_of_type_Int = paramInt1;
          ((SessionInfo)localObject).b = paramString3;
          paramArrayOfByte.forwardID = paramInt2;
          ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramArrayOfByte);
          return true;
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
  }
  
  private void b(Bundle paramBundle, int paramInt)
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    paramBundle = QfavHelper.a(paramBundle, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramBundle, str, i, paramInt);
  }
  
  private void b(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    String str = paramBundle.getString("text");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    paramBundle = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, paramString1, paramString2, paramInt2, (byte)1, (byte)0, (short)0, paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramBundle, null);
    }
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 1, 0, paramInt4);
  }
  
  private void c(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    paramString3 = paramBundle.getString("forward_filepath");
    paramBundle = paramString3;
    if (paramString3 == null) {
      paramBundle = "";
    }
    ThreadManager.post(new ForwardQFavBatchOption.3(this, paramBundle, paramString1, paramInt2, paramString2, paramInt3), 8, null, false);
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 3, 0, paramInt4);
  }
  
  public String a()
  {
    ArrayList localArrayList;
    if (!this.j)
    {
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      if (localArrayList == null) {}
    }
    for (this.jdField_a_of_type_JavaLangString = (localArrayList.size() + this.jdField_a_of_type_AndroidAppActivity.getString(2131698098));; this.jdField_a_of_type_JavaLangString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardQFavBatchOption", 2, "DialogContent:mForwardText=" + this.jdField_a_of_type_JavaLangString);
      }
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.j = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("bSinglePicSelected", false);
    if ((this.j) && (TextUtils.isEmpty(this.b))) {
      this.b = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_skip_confirm", false)) {
      x();
    }
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    if ((localObject != null) && (((ArrayList)localObject).size() == 1))
    {
      localObject = (Bundle)((ArrayList)localObject).get(0);
      if (localObject == null) {
        return false;
      }
      if (((Bundle)localObject).getInt("qfavType") == 5) {
        this.b = ((Bundle)localObject).getString("forward_thumb");
      }
    }
    return true;
  }
  
  protected void b()
  {
    super.b();
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    if (localObject != null)
    {
      m = 0;
      int i = 1;
      while (m < ((ArrayList)localObject).size())
      {
        if (((Bundle)((ArrayList)localObject).get(m)).getInt("qfavType") != 3) {
          i = 0;
        }
        m += 1;
      }
      m = i;
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = (Bundle)((ArrayList)localObject).get(0);
        int n = ((Bundle)localObject).getInt("qfavType");
        if ((n != 5) && (n != 8))
        {
          m = i;
          if (n != 2) {}
        }
        else
        {
          m = i;
          if (!((Bundle)localObject).getBoolean("k_dataline", false)) {}
        }
      }
    }
    for (int m = 1;; m = 1)
    {
      if (m != 0)
      {
        this.jdField_a_of_type_JavaUtilSet.add(f);
        this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("isJumpAIO", false);
      }
      return;
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int m = 0;
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    this.jdField_k_of_type_Boolean = true;
    ArrayList localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("isFromFavorites", true);
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("hasJumpAIO", false);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
    Object localObject;
    int i;
    if ((localArrayList != null) && (localArrayList.size() == 1))
    {
      localObject = (Bundle)localArrayList.get(0);
      i = ((Bundle)localObject).getInt("qfavType");
      if (i == 5)
      {
        paramIntent.putExtra("dataline_forward_type", 100);
        a((Bundle)localObject, n);
      }
    }
    else
    {
      label141:
      if ((localArrayList == null) || (localArrayList.size() <= 1)) {
        break label382;
      }
      boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("needStartChatActivity", false);
      paramIntent.putExtra("needStartChatActivity", bool);
      i = m;
      if (bool)
      {
        AIOUtils.a(paramIntent, null).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        i = m;
      }
      label200:
      if (i < localArrayList.size())
      {
        localObject = (Bundle)localArrayList.get(i);
        if (localObject != null)
        {
          paramIntent = ThreadManager.getUIHandler();
          localObject = new ForwardQFavBatchOption.2(this, (Bundle)localObject, n);
          if (i != 0) {
            break label384;
          }
        }
      }
    }
    label384:
    for (long l = 200L;; l = i * 10)
    {
      paramIntent.postDelayed((Runnable)localObject, l);
      i += 1;
      break label200;
      break;
      if ((i != 8) && (i != 2)) {
        break label141;
      }
      localObject = a((Bundle)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label141;
      }
      paramIntent.putExtra("dataline_forward_type", 101);
      paramIntent.putExtra("forward_filepath", (String)localObject);
      paramIntent.putExtra("forward_extra", (String)localObject);
      paramIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      QLog.d("ForwardOption.ForwardQFavBatchOption", 1, "sendDatalineSingle filePath: " + (String)localObject);
      paramIntent.putExtra("dataline_forward_path", (String)localObject);
      AutoSaveUtils.a(true, (String)localObject);
      break label141;
      label382:
      break;
    }
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type") == f.intValue()) {
      str = HardCodeUtil.a(2131694415);
    }
    return str;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getMessageTextView();
    ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
    localLayoutParams.width = -1;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(17);
  }
  
  protected void t()
  {
    if (this.j) {
      u();
    }
  }
  
  public void x()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject2 = new Intent();
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("needStartChatActivity", false);
    ((Intent)localObject2).putExtra("needStartChatActivity", bool);
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = AIOUtils.a((Intent)localObject2, null);
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("isFromFavorites", true);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    localObject1 = new Intent((Intent)localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i;
    ArrayList localArrayList;
    int m;
    label198:
    Object localObject3;
    MqqHandler localMqqHandler;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forwardFromAIO", false))
    {
      i = 2;
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
      m = 0;
      if (m >= localArrayList.size()) {
        break label295;
      }
      localObject3 = (Bundle)localArrayList.get(m);
      if (localObject3 != null)
      {
        localMqqHandler = ThreadManager.getUIHandler();
        localObject3 = new ForwardQFavBatchOption.1(this, (Bundle)localObject3, str2, str1, n, i1, (String)localObject2, i, str3, (Intent)localObject1);
        if (m != 0) {
          break label285;
        }
      }
    }
    label285:
    for (long l = 200L;; l = m * 10)
    {
      localMqqHandler.postDelayed((Runnable)localObject3, l);
      m += 1;
      break label198;
      i = 1;
      break;
    }
    label295:
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_BatchForwardSendBtnClick", 0, 0, localArrayList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption
 * JD-Core Version:    0.7.0.1
 */