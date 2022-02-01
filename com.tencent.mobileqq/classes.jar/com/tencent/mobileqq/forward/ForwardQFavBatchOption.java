package com.tencent.mobileqq.forward;

import afur;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import anhk;
import anni;
import aszd;
import aufz;
import bgpa;
import bkfl;
import bljn;
import bljv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ForwardQFavBatchOption
  extends aufz
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
  
  private void a(Bundle paramBundle, int paramInt)
  {
    String str = anhk.z;
    paramBundle = bljn.a(paramBundle, str, 7);
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBundle, str, 6000, paramInt);
  }
  
  public String a()
  {
    ArrayList localArrayList;
    if (!this.i)
    {
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      if (localArrayList == null) {}
    }
    for (this.jdField_a_of_type_JavaLangString = (localArrayList.size() + this.jdField_a_of_type_AndroidAppActivity.getString(2131697336));; this.jdField_a_of_type_JavaLangString = null)
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
      w();
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
    this.jdField_a_of_type_Bgpa.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    TextView localTextView = this.jdField_a_of_type_Bgpa.getMessageTextView();
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
      label136:
      if ((localArrayList == null) || (localArrayList.size() <= 1)) {
        break label373;
      }
      boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("needStartChatActivity", false);
      paramIntent.putExtra("needStartChatActivity", bool);
      k = m;
      if (bool)
      {
        afur.a(paramIntent, null).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        k = m;
      }
      label193:
      if (k < localArrayList.size())
      {
        localObject = (Bundle)localArrayList.get(k);
        if (localObject != null)
        {
          paramIntent = ThreadManager.getUIHandler();
          localObject = new ForwardQFavBatchOption.2(this, (Bundle)localObject, n);
          if (k != 0) {
            break label375;
          }
        }
      }
    }
    label373:
    label375:
    for (long l = 200L;; l = k * 10)
    {
      paramIntent.postDelayed((Runnable)localObject, l);
      k += 1;
      break label193;
      break;
      if ((k != 8) && (k != 2)) {
        break label136;
      }
      localObject = a((Bundle)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label136;
      }
      paramIntent.putExtra("dataline_forward_type", 101);
      paramIntent.putExtra("forward_filepath", (String)localObject);
      paramIntent.putExtra("forward_extra", (String)localObject);
      paramIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      QLog.d("ForwardOption.ForwardQFavBatchOption", 1, "sendDatalineSingle filePath: " + (String)localObject);
      paramIntent.putExtra("dataline_forward_path", (String)localObject);
      bkfl.a(true, (String)localObject);
      break label136;
      break;
    }
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type") == f.intValue()) {
      str = anni.a(2131693904);
    }
    return str;
  }
  
  public void s()
  {
    if (this.i) {
      t();
    }
  }
  
  public void w()
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
      localObject1 = afur.a((Intent)localObject2, null);
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
    label196:
    Object localObject3;
    MqqHandler localMqqHandler;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forwardFromAIO", false))
    {
      k = 2;
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
      m = 0;
      if (m >= localArrayList.size()) {
        break label293;
      }
      localObject3 = (Bundle)localArrayList.get(m);
      if (localObject3 != null)
      {
        localMqqHandler = ThreadManager.getUIHandler();
        localObject3 = new ForwardQFavBatchOption.1(this, (Bundle)localObject3, str2, str1, n, i1, (String)localObject2, k, str3, (Intent)localObject1);
        if (m != 0) {
          break label283;
        }
      }
    }
    label283:
    for (long l = 200L;; l = m * 10)
    {
      localMqqHandler.postDelayed((Runnable)localObject3, l);
      m += 1;
      break label196;
      k = 1;
      break;
    }
    label293:
    bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_BatchForwardSendBtnClick", 0, 0, localArrayList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption
 * JD-Core Version:    0.7.0.1
 */