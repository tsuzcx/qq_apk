package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ProfileCardShareHelper
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ProfileCardShareHelper.1(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new ProfileCardShareHelper.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileCardShareHelper.OnShareListener jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper$OnShareListener;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public ProfileCardShareHelper(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, ProfileCardShareHelper.OnShareListener paramOnShareListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper$OnShareListener = paramOnShareListener;
    if (paramQQAppInterface == null) {
      a();
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardShareHelper", 2, String.format("decodeFace: %s", new Object[] { paramString }));
    }
    ThreadManager.getSubThreadHandler().post(new ProfileCardShareHelper.3(this, paramString));
  }
  
  private void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Boolean = false;
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://ti.qq.com/open_qq/index2.html?url=mqqapi%3a%2f%2fuserprofile%2ffriend_profile_card%3fsrc_type%3dweb%26version%3d1.0%26source%3d2%26uin%3d");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    WXShareHelper.a().d(String.valueOf(l), paramString2, paramBitmap, "来自QQ的推荐好友", paramString1);
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidAppActivity.getString(2131696399);
    localActionSheetItem.icon = 2130839067;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidAppActivity.getString(2131696420);
    localActionSheetItem.icon = 2130839071;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject4 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AppCmd://OpenContactInfo/?uin=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      localObject2 = ((StringBuilder)localObject2).toString();
      String str1 = HardCodeUtil.a(2131708428);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131708474));
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      String str2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718140);
      localObject4 = ((AbsShareMsg.Builder)localObject4).c(14);
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131708457));
      ((StringBuilder)localObject5).append(this.b);
      localObject4 = ((AbsShareMsg.Builder)localObject4).a(((StringBuilder)localObject5).toString()).a(2).a(1).a("plugin", "", (String)localObject2, (String)localObject1, (String)localObject1).d(str2).a();
      localObject5 = new StructMsgItemLayoutDefault();
      ((AbsStructMsgItem)localObject5).b(1);
      ((AbsStructMsgItem)localObject5).a(str1);
      StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
      localStructMsgItemLayout2.b(1);
      localStructMsgItemLayout2.a(new StructMsgItemCover((String)localObject1));
      localStructMsgItemLayout2.a(new StructMsgItemTitle(this.b));
      localStructMsgItemLayout2.a(new StructMsgItemSummary((String)localObject3));
      ((AbsShareMsg)localObject4).addItem((AbsStructMsgElement)localObject5);
      ((AbsShareMsg)localObject4).addItem(localStructMsgItemLayout2);
      localObject5 = new Bundle();
      ((Bundle)localObject5).putInt("forward_type", 20);
      ((Bundle)localObject5).putInt("structmsg_service_id", 14);
      ((Bundle)localObject5).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject4).getBytes());
      ((Bundle)localObject5).putBoolean("k_dataline", false);
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject4 = new Intent();
        ((Bundle)localObject5).putString("sourceFrom", "share_from_troop_member_card");
        ((Intent)localObject4).putExtras((Bundle)localObject5);
        RouteUtils.a(BaseApplicationImpl.getContext(), (Intent)localObject4, "/share/toqq/activity");
      }
      else
      {
        localObject4 = new Intent();
        ((Intent)localObject4).putExtras((Bundle)localObject5);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject4, 21);
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder(300);
        ((StringBuilder)localObject4).append("recommentFriend [title: ");
        ((StringBuilder)localObject4).append(str1);
        ((StringBuilder)localObject4).append(", nickname: ");
        ((StringBuilder)localObject4).append(this.b);
        ((StringBuilder)localObject4).append(", info: ");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(", serviceId: ");
        ((StringBuilder)localObject4).append(14);
        ((StringBuilder)localObject4).append(", pActionData: ");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(", aActionData: ");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(", iActionData: ");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(", compatibleText: ");
        ((StringBuilder)localObject4).append(str2);
        ((StringBuilder)localObject4).append("]");
        QLog.i("ProfileCardShareHelper", 2, ((StringBuilder)localObject4).toString());
      }
      return;
    }
    QLog.d("ProfileCardShareHelper", 1, String.format("shareToFriend, uin or nickname is empty, uin: %s, nickname: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720478;
    } else if (!WXShareHelper.a().b()) {
      i = 2131720479;
    } else {
      i = -1;
    }
    if (i != -1)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, i, 1).a();
      QLog.d("ProfileCardShareHelper", 1, "shareToWXFriend, but wechat is not install or version is too low");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      a(this.jdField_a_of_type_JavaLangString, this.b, (Bitmap)localObject);
      return;
    }
    if (FileUtil.b(this.c))
    {
      a(this.c);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null)
      {
        this.c = ((QQAppInterface)localObject).getCustomFaceFilePath(1, this.jdField_a_of_type_JavaLangString, 0);
        a(this.c);
      }
      else
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(this.jdField_a_of_type_JavaLangString);
        Intent localIntent = new Intent("com.tencent.qqhead.getheadreq");
        localIntent.putExtra("faceType", 1);
        localIntent.putStringArrayListExtra("uinList", (ArrayList)localObject);
        this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      }
    }
    b();
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardShareHelper", 2, String.format("share, uin: %s, nickname: %s", new Object[] { paramString1, paramString2 }));
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      }
    }
  }
  
  protected void b()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        localActivity = this.jdField_a_of_type_AndroidAppActivity;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299168));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131708458));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  protected void c()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public void d()
  {
    BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localBroadcastReceiver != null) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(localBroadcastReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper
 * JD-Core Version:    0.7.0.1
 */