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
  private ShareActionSheetBuilder a;
  private QQProgressDialog b;
  private QQAppInterface c;
  private Activity d;
  private String e;
  private String f;
  private String g;
  private Bitmap h;
  private boolean i;
  private int j;
  private ProfileCardShareHelper.OnShareListener k;
  private BroadcastReceiver l = new ProfileCardShareHelper.1(this);
  private AdapterView.OnItemClickListener m = new ProfileCardShareHelper.2(this);
  
  public ProfileCardShareHelper(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, ProfileCardShareHelper.OnShareListener paramOnShareListener)
  {
    this.c = paramQQAppInterface;
    this.d = paramActivity;
    this.c = paramQQAppInterface;
    this.j = paramInt;
    this.k = paramOnShareListener;
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
    this.i = false;
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://ti.qq.com/open_qq/index2.html?url=mqqapi%3a%2f%2fuserprofile%2ffriend_profile_card%3fsrc_type%3dweb%26version%3d1.0%26source%3d2%26uin%3d");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    WXShareHelper.a().d(String.valueOf(l1), paramString2, paramBitmap, "来自QQ的推荐好友", paramString1);
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] e()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.d.getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.d.getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void f()
  {
    if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)))
    {
      Object localObject4 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
      ((StringBuilder)localObject1).append(this.e);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AppCmd://OpenContactInfo/?uin=");
      ((StringBuilder)localObject2).append(this.e);
      localObject2 = ((StringBuilder)localObject2).toString();
      String str1 = HardCodeUtil.a(2131906214);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131906260));
      ((StringBuilder)localObject3).append(this.e);
      localObject3 = ((StringBuilder)localObject3).toString();
      String str2 = this.d.getResources().getString(2131915618);
      localObject4 = ((AbsShareMsg.Builder)localObject4).c(14);
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131906243));
      ((StringBuilder)localObject5).append(this.f);
      localObject4 = ((AbsShareMsg.Builder)localObject4).a(((StringBuilder)localObject5).toString()).a(2).a(1).a("plugin", "", (String)localObject2, (String)localObject1, (String)localObject1).d(str2).a();
      localObject5 = new StructMsgItemLayoutDefault();
      ((AbsStructMsgItem)localObject5).c(1);
      ((AbsStructMsgItem)localObject5).b(str1);
      StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
      localStructMsgItemLayout2.c(1);
      localStructMsgItemLayout2.a(new StructMsgItemCover((String)localObject1));
      localStructMsgItemLayout2.a(new StructMsgItemTitle(this.f));
      localStructMsgItemLayout2.a(new StructMsgItemSummary((String)localObject3));
      ((AbsShareMsg)localObject4).addItem((AbsStructMsgElement)localObject5);
      ((AbsShareMsg)localObject4).addItem(localStructMsgItemLayout2);
      localObject5 = new Bundle();
      ((Bundle)localObject5).putInt("forward_type", 20);
      ((Bundle)localObject5).putInt("structmsg_service_id", 14);
      ((Bundle)localObject5).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject4).getBytes());
      ((Bundle)localObject5).putBoolean("k_dataline", false);
      if (this.j == 1)
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
        ForwardBaseOption.a(this.d, (Intent)localObject4, 21);
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder(300);
        ((StringBuilder)localObject4).append("recommentFriend [title: ");
        ((StringBuilder)localObject4).append(str1);
        ((StringBuilder)localObject4).append(", nickname: ");
        ((StringBuilder)localObject4).append(this.f);
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
    QLog.d("ProfileCardShareHelper", 1, String.format("shareToFriend, uin or nickname is empty, uin: %s, nickname: %s", new Object[] { this.e, this.f }));
  }
  
  private void g()
  {
    if (this.i) {
      return;
    }
    int n;
    if (!WXShareHelper.a().b()) {
      n = 2131918154;
    } else if (!WXShareHelper.a().c()) {
      n = 2131918155;
    } else {
      n = -1;
    }
    if (n != -1)
    {
      QQToast.makeText(this.d, 1, n, 1).show();
      QLog.d("ProfileCardShareHelper", 1, "shareToWXFriend, but wechat is not install or version is too low");
      return;
    }
    this.i = true;
    Object localObject = this.h;
    if (localObject != null)
    {
      a(this.e, this.f, (Bitmap)localObject);
      return;
    }
    if (FileUtil.d(this.g))
    {
      a(this.g);
    }
    else
    {
      localObject = this.c;
      if (localObject != null)
      {
        this.g = ((QQAppInterface)localObject).getCustomFaceFilePath(1, this.e, 0);
        a(this.g);
      }
      else
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(this.e);
        Intent localIntent = new Intent("com.tencent.qqhead.getheadreq");
        localIntent.putExtra("faceType", 1);
        localIntent.putStringArrayListExtra("uinList", (ArrayList)localObject);
        this.d.sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      }
    }
    b();
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    this.d.registerReceiver(this.l, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
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
      if (!paramString1.equals(this.e)) {
        this.h = null;
      }
      this.e = paramString1;
      this.f = paramString2;
      if (this.a == null)
      {
        this.a = new ShareActionSheetBuilder(this.d);
        this.a.setActionSheetItems(e());
        this.a.setItemClickListener(this.m);
      }
      if (!this.a.isShowing()) {
        this.a.show();
      }
    }
  }
  
  protected void b()
  {
    Activity localActivity = this.d;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (this.b == null)
      {
        localActivity = this.d;
        this.b = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299920));
        this.b.setCancelable(false);
      }
      this.b.a(HardCodeUtil.a(2131906244));
      this.b.show();
    }
  }
  
  protected void c()
  {
    QQProgressDialog localQQProgressDialog = this.b;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.b.dismiss();
      this.b = null;
    }
  }
  
  public void d()
  {
    BroadcastReceiver localBroadcastReceiver = this.l;
    if (localBroadcastReceiver != null) {
      this.d.unregisterReceiver(localBroadcastReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper
 * JD-Core Version:    0.7.0.1
 */