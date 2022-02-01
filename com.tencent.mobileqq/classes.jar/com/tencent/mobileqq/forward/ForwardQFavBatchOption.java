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
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
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
    if (paramBundle == null) {
      return "";
    }
    Object localObject2 = paramBundle.getString("forward_extra");
    int i = paramBundle.getInt("qfavType");
    Object localObject1;
    if ((i != 5) && (i != 8))
    {
      localObject1 = localObject2;
      if (i != 2) {}
    }
    else
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramBundle.getString("forward_extra");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramBundle.getString("forward_filepath");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
    }
    return localObject1;
  }
  
  private void a(Intent paramIntent, Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    paramString1 = SVBusiUtil.a(3, 2);
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
    paramBundle.putString("struct_share_key_source_icon", BaseApplicationImpl.getContext().getString(2131692208));
    paramBundle.putString("app_name", BaseApplicationImpl.getContext().getString(2131692206));
    paramBundle.putString("struct_share_key_source_action", "plugin");
    paramBundle.putString("struct_share_key_source_action_data", "qqfav://operation/2");
    paramBundle.putInt("req_type", 133);
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = paramBundle.getBoolean("bFriendCard", false);
    Object localObject1 = paramBundle.getByteArray("sBizDataList");
    int i;
    Object localObject2;
    if (paramInt1 == 6)
    {
      i = paramBundle.getInt("nLinkType");
      if ((i != 4) && (i != 5))
      {
        if ((i != 6) && (i != 7))
        {
          if (i == 8) {
            bool1 = a((byte[])localObject1, paramString1, paramString1, paramString2, paramInt2, paramInt3);
          }
          i = 0;
        }
        else
        {
          i = 1;
          bool1 = bool2;
        }
      }
      else
      {
        localObject2 = new ArkAppMessage();
        ((ArkAppMessage)localObject2).fromAppXml(new String((byte[])localObject1));
        localObject2 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramInt2, (ArkAppMessage)localObject2);
        ForwardOrderManager.a().a(((MessageForArkApp)localObject2).uniseq, ((MessageForArkApp)localObject2).uniseq, paramInt3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, null);
        i = 0;
        bool1 = true;
      }
    }
    else
    {
      if ((bool3) && (localObject1 != null)) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = false;
    }
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
    }
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 2, 0, paramInt4);
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
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length <= 0) {
        return false;
      }
    }
    Object localObject;
    for (paramArrayOfByte = new String(paramArrayOfByte);; paramArrayOfByte = (byte[])localObject)
    {
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte).optJSONObject("arkAppInfo");
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
        if (localObject != null) {
          continue;
        }
        localObject = new SessionInfo();
        ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramString2;
        ((SessionInfo)localObject).d = paramString1;
        ((SessionInfo)localObject).jdField_a_of_type_Int = paramInt1;
        ((SessionInfo)localObject).b = paramString3;
        paramArrayOfByte.forwardID = paramInt2;
        ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramArrayOfByte);
        return true;
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      return false;
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
    Object localObject;
    if (!this.j)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ArrayList)localObject).size());
        localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131698105));
        this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DialogContent:mForwardText=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ForwardOption.ForwardQFavBatchOption", 2, ((StringBuilder)localObject).toString());
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    super.a();
    this.j = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("bSinglePicSelected", false);
    if ((this.j) && (TextUtils.isEmpty(this.b))) {
      this.b = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_skip_confirm", false)) {
      y();
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
    int n = 1;
    int i = n;
    if (localObject != null)
    {
      int m = 0;
      i = 1;
      while (m < ((ArrayList)localObject).size())
      {
        if (((Bundle)((ArrayList)localObject).get(m)).getInt("qfavType") != 3) {
          i = 0;
        }
        m += 1;
      }
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = (Bundle)((ArrayList)localObject).get(0);
        m = ((Bundle)localObject).getInt("qfavType");
        if (((m == 5) || (m == 8) || (m == 2)) && (((Bundle)localObject).getBoolean("k_dataline", false))) {
          i = n;
        }
      }
    }
    if (i != 0)
    {
      this.jdField_a_of_type_JavaUtilSet.add(f);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("isJumpAIO", false);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    this.jdField_k_of_type_Boolean = true;
    ArrayList localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("isFromFavorites", true);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    int m = 0;
    ((Intent)localObject).putExtra("hasJumpAIO", false);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
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
      else if ((i == 8) || (i == 2))
      {
        localObject = a((Bundle)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramIntent.putExtra("dataline_forward_type", 101);
          paramIntent.putExtra("forward_filepath", (String)localObject);
          paramIntent.putExtra("forward_extra", (String)localObject);
          paramIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendDatalineSingle filePath: ");
          localStringBuilder.append((String)localObject);
          QLog.d("ForwardOption.ForwardQFavBatchOption", 1, localStringBuilder.toString());
          paramIntent.putExtra("dataline_forward_path", (String)localObject);
          AutoSaveUtils.a(true, (String)localObject);
        }
      }
    }
    if ((localArrayList != null) && (localArrayList.size() > 1))
    {
      boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("needStartChatActivity", false);
      paramIntent.putExtra("needStartChatActivity", bool);
      i = m;
      if (bool)
      {
        AIOUtils.a(paramIntent, null).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        i = m;
      }
      while (i < localArrayList.size())
      {
        localObject = (Bundle)localArrayList.get(i);
        if (localObject != null)
        {
          paramIntent = ThreadManager.getUIHandler();
          localObject = new ForwardQFavBatchOption.2(this, (Bundle)localObject, n);
          long l;
          if (i == 0) {
            l = 200L;
          } else {
            l = i * 10;
          }
          paramIntent.postDelayed((Runnable)localObject, l);
        }
        i += 1;
      }
    }
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type") == f.intValue()) {
      str = HardCodeUtil.a(2131694380);
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
  
  protected void u()
  {
    if (this.j) {
      v();
    }
  }
  
  public void y()
  {
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject3 = new Intent();
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("needStartChatActivity", false);
    ((Intent)localObject3).putExtra("needStartChatActivity", bool);
    Object localObject1 = localObject3;
    if (bool)
    {
      localObject1 = AIOUtils.a((Intent)localObject3, null);
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("isFromFavorites", true);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    Object localObject4 = new Intent((Intent)localObject1);
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int m;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forwardFromAIO", false)) {
      m = 2;
    } else {
      m = 1;
    }
    localObject3 = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    int i2 = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
    int i = 0;
    localObject1 = localObject2;
    localObject2 = localObject4;
    while (i < ((ArrayList)localObject3).size())
    {
      Object localObject5 = (Bundle)((ArrayList)localObject3).get(i);
      if (localObject5 != null)
      {
        localObject4 = ThreadManager.getUIHandler();
        int n = i;
        localObject5 = new ForwardQFavBatchOption.1(this, (Bundle)localObject5, str1, str2, i1, i2, str3, m, (String)localObject1, (Intent)localObject2);
        long l;
        if (n == 0) {
          l = 200L;
        } else {
          l = n * 10;
        }
        ((MqqHandler)localObject4).postDelayed((Runnable)localObject5, l);
      }
      i += 1;
    }
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_BatchForwardSendBtnClick", 0, 0, ((ArrayList)localObject3).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption
 * JD-Core Version:    0.7.0.1
 */