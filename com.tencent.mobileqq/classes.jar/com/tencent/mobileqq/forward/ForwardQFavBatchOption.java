package com.tencent.mobileqq.forward;

import aean;
import agej;
import agsg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import antf;
import anzj;
import atqx;
import auxu;
import bcpt;
import bcry;
import bcwu;
import bcxn;
import bdow;
import bhpc;
import blgp;
import bmkq;
import bmky;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ForwardQFavBatchOption
  extends auxu
{
  boolean i = false;
  boolean j = false;
  
  public ForwardQFavBatchOption(Intent paramIntent)
  {
    super(paramIntent);
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
      int k;
      do
      {
        return localObject1;
        localObject2 = paramBundle.getString("forward_extra");
        k = paramBundle.getInt("qfavType");
        if ((k == 5) || (k == 8)) {
          break;
        }
        localObject1 = localObject2;
      } while (k != 2);
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
    paramString1 = bcwu.a(3, 2);
    paramIntent.putExtras(paramBundle);
    paramIntent = bcwu.a(2, paramIntent, paramString1);
    paramIntent.c = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    paramIntent.d = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    paramIntent.b = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    paramIntent.jdField_a_of_type_Int = 2;
    paramIntent.p = paramInt2;
    paramString1.a(paramIntent);
    bcwu.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 5, 0, paramInt3);
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    String str = antf.z;
    paramBundle = bmkq.a(paramBundle, str, 7);
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBundle, str, 6000, paramInt);
  }
  
  private void a(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    paramBundle.putString("struct_share_key_source_icon", BaseApplicationImpl.getContext().getString(2131692014));
    paramBundle.putString("app_name", BaseApplicationImpl.getContext().getString(2131692012));
    paramBundle.putString("struct_share_key_source_action", "plugin");
    paramBundle.putString("struct_share_key_source_action_data", "qqfav://operation/2");
    paramBundle.putInt("req_type", 133);
    int n = 0;
    int k = 0;
    boolean bool = paramBundle.getBoolean("bFriendCard", false);
    Object localObject1 = paramBundle.getByteArray("sBizDataList");
    int i1;
    Object localObject2;
    int m;
    if (paramInt1 == 6)
    {
      i1 = paramBundle.getInt("nLinkType");
      if ((i1 == 4) || (i1 == 5))
      {
        localObject2 = new ArkAppMessage();
        ((ArkAppMessage)localObject2).fromAppXml(new String((byte[])localObject1));
        localObject2 = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramInt2, (ArkAppMessage)localObject2);
        agsg.a().a(((MessageForArkApp)localObject2).uniseq, ((MessageForArkApp)localObject2).uniseq, paramInt3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, null);
        m = 1;
        n = m;
        m = k;
        k = n;
      }
    }
    for (;;)
    {
      n = k;
      if (k == 0)
      {
        n = k;
        if (m != 0)
        {
          n = k;
          if (localObject1 != null)
          {
            localObject1 = bdow.a((byte[])localObject1, 0);
            n = k;
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              k = bcpt.jdField_a_of_type_Int;
              bcpt.jdField_a_of_type_Int = k + 1;
              localObject2 = bcry.a((QQAppInterface)localObject2, paramString3, paramString1, paramString2, paramInt2, k, (AbsStructMsg)localObject1);
              agsg.a().a(((MessageForStructing)localObject2).uniseq, ((AbsStructMsg)localObject1).uniseq, paramInt3);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, null);
              n = 1;
            }
          }
        }
      }
      if (n == 0)
      {
        paramBundle = bdow.a(paramBundle);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        k = bcpt.jdField_a_of_type_Int;
        bcpt.jdField_a_of_type_Int = k + 1;
        paramString1 = bcry.a((QQAppInterface)localObject1, paramString3, paramString1, paramString2, paramInt2, k, paramBundle);
        agsg.a().a(paramString1.uniseq, paramBundle.uniseq, paramInt3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, null);
      }
      if (paramInt1 == 8)
      {
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 8, 0, paramInt4);
        return;
        if (i1 != 6)
        {
          m = n;
          if (i1 != 7) {
            break;
          }
        }
        k = 1;
        m = n;
        break;
        if ((!bool) || (localObject1 == null)) {
          break label458;
        }
        k = 0;
        m = 1;
        continue;
      }
      bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 2, 0, paramInt4);
      return;
      label458:
      k = 0;
      m = 0;
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
    aean.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString1, paramString2, paramBundle, paramString3, paramBundle, null, "", "", "", this.jdField_a_of_type_AndroidOsBundle);
    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 7, 0, paramInt3);
  }
  
  private void b(Bundle paramBundle, int paramInt)
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    paramBundle = bmkq.a(paramBundle, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBundle, str, k, paramInt);
  }
  
  private void b(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    String str = paramBundle.getString("text");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    paramBundle = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, paramString1, paramString2, paramInt2, (byte)1, (byte)0, (short)0, paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBundle, null);
    }
    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 1, 0, paramInt4);
  }
  
  private void c(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    paramString3 = paramBundle.getString("forward_filepath");
    paramBundle = paramString3;
    if (paramString3 == null) {
      paramBundle = "";
    }
    ThreadManager.post(new ForwardQFavBatchOption.3(this, paramBundle, paramString1, paramInt2, paramString2, paramInt3), 8, null, false);
    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 3, 0, paramInt4);
  }
  
  public String a()
  {
    ArrayList localArrayList;
    if (!this.i)
    {
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      if (localArrayList == null) {}
    }
    for (this.jdField_a_of_type_JavaLangString = (localArrayList.size() + this.jdField_a_of_type_AndroidAppActivity.getString(2131697416));; this.jdField_a_of_type_JavaLangString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardQFavBatchOption", 2, "DialogContent:mForwardText=" + this.jdField_a_of_type_JavaLangString);
      }
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    if (localObject != null)
    {
      m = 0;
      int k = 1;
      while (m < ((ArrayList)localObject).size())
      {
        if (((Bundle)((ArrayList)localObject).get(m)).getInt("qfavType") != 3) {
          k = 0;
        }
        m += 1;
      }
      m = k;
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = (Bundle)((ArrayList)localObject).get(0);
        int n = ((Bundle)localObject).getInt("qfavType");
        if ((n != 5) && (n != 8))
        {
          m = k;
          if (n != 2) {}
        }
        else
        {
          m = k;
          if (!((Bundle)localObject).getBoolean("k_dataline", false)) {}
        }
      }
    }
    for (int m = 1;; m = 1)
    {
      if (m != 0)
      {
        this.jdField_a_of_type_JavaUtilSet.add(f);
        this.jdField_a_of_type_JavaUtilSet.add(k);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("isJumpAIO", false);
      }
      return;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.i = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("bSinglePicSelected", false);
    if ((this.i) && (TextUtils.isEmpty(this.b))) {
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
  
  public void b()
  {
    this.jdField_a_of_type_Bhpc.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    TextView localTextView = this.jdField_a_of_type_Bhpc.getMessageTextView();
    ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
    localLayoutParams.width = -1;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(17);
  }
  
  public void b(Intent paramIntent)
  {
    int m = 0;
    if (this.j) {
      return;
    }
    this.j = true;
    ArrayList localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("isFromFavorites", true);
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("hasJumpAIO", false);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
    Object localObject;
    int k;
    if ((localArrayList != null) && (localArrayList.size() == 1))
    {
      localObject = (Bundle)localArrayList.get(0);
      k = ((Bundle)localObject).getInt("qfavType");
      if (k == 5)
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
      k = m;
      if (bool)
      {
        agej.a(paramIntent, null).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        k = m;
      }
      label200:
      if (k < localArrayList.size())
      {
        localObject = (Bundle)localArrayList.get(k);
        if (localObject != null)
        {
          paramIntent = ThreadManager.getUIHandler();
          localObject = new ForwardQFavBatchOption.2(this, (Bundle)localObject, n);
          if (k != 0) {
            break label384;
          }
        }
      }
    }
    label384:
    for (long l = 200L;; l = k * 10)
    {
      paramIntent.postDelayed((Runnable)localObject, l);
      k += 1;
      break label200;
      break;
      if ((k != 8) && (k != 2)) {
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
      blgp.a(true, (String)localObject);
      break label141;
      label382:
      break;
    }
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type") == f.intValue()) {
      str = anzj.a(2131693921);
    }
    return str;
  }
  
  public void t()
  {
    if (this.i) {
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
      localObject1 = agej.a((Intent)localObject2, null);
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("isFromFavorites", true);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    localObject1 = new Intent((Intent)localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int k;
    ArrayList localArrayList;
    int m;
    label198:
    Object localObject3;
    MqqHandler localMqqHandler;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forwardFromAIO", false))
    {
      k = 2;
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
        localObject3 = new ForwardQFavBatchOption.1(this, (Bundle)localObject3, str2, str1, n, i1, (String)localObject2, k, str3, (Intent)localObject1);
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
      k = 1;
      break;
    }
    label295:
    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_BatchForwardSendBtnClick", 0, 0, localArrayList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption
 * JD-Core Version:    0.7.0.1
 */