package com.tencent.mobileqq.forward;

import adcm;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppActivity;

public class ForwardStructingMsgOption
  extends ForwardBaseOption
{
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new adcm(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  String f = "";
  boolean g = false;
  
  public ForwardStructingMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private boolean a(AbsShareMsg paramAbsShareMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsShareMsg = ((StructMsgForGeneralShare)paramAbsShareMsg).getStructMsgItemLists();
      bool1 = bool2;
      if (paramAbsShareMsg != null) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      Object localObject;
      int j;
      if (i < paramAbsShareMsg.size())
      {
        localObject = (AbsStructMsgElement)paramAbsShareMsg.get(i);
        if (!(localObject instanceof StructMsgItemLayout5)) {
          break label139;
        }
        localObject = ((StructMsgItemLayout5)localObject).a;
        if (localObject == null) {
          break label179;
        }
        j = 0;
        if (j >= ((List)localObject).size()) {
          break label179;
        }
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((List)localObject).get(j);
        if ((!(localAbsStructMsgElement instanceof StructMsgItemVideo)) || (((StructMsgItemVideo)localAbsStructMsgElement).a())) {
          break label132;
        }
        bool1 = true;
      }
      label132:
      label139:
      do
      {
        do
        {
          return bool1;
          j += 1;
          break;
          if (!(localObject instanceof StructMsgItemLayout2)) {
            break label179;
          }
          paramAbsShareMsg = (StructMsgItemLayout2)localObject;
          bool1 = bool2;
        } while (paramAbsShareMsg.e == 1);
        bool1 = bool2;
      } while (paramAbsShareMsg.e == 3);
      return true;
      label179:
      i += 1;
    }
  }
  
  private void b(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.setBodyLayoutNoMargin();
    Object localObject1 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.a(152.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 116))
    {
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((URLImageView)localObject1).setBackgroundColor(Color.parseColor("#dcdfe4"));
    Object localObject3 = ChatHistoryStructAdapter.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, "cover");
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130845965);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = URLDrawable.getDrawable((String)localObject3, -1, AIOUtils.a(165.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), localDrawable, localDrawable, true);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 2)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1))
      {
        ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((URLImageView)localObject1).setBackgroundDrawable(null);
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
    }
    for (;;)
    {
      paramQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
      localObject1 = ChatHistoryStructAdapter.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, "title");
      localObject2 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextSize(16.0F);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setTextColor(-16777216);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setPadding(AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      paramQQCustomDialog.addView((View)localObject2);
      return;
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((URLImageView)localObject1).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      break;
      ((URLImageView)localObject1).setImageDrawable(localDrawable);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
  }
  
  protected void a()
  {
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (super.l())) {
      this.jdField_a_of_type_JavaUtilSet.add(j);
    }
  }
  
  public boolean a()
  {
    super.a();
    Object localObject = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 83) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 108) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 114) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 116)) {
        break label146;
      }
      this.g = true;
      this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 3);
    }
    for (;;)
    {
      localObject = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl);
      try
      {
        this.f = ((Uri)localObject).getQueryParameter("article_id");
        if (this.f == null) {
          this.f = "";
        }
        return true;
        label146:
        if ((!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) && (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com"))) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    boolean bool2 = true;
    if (paramLightAppSettingInfo == null) {}
    do
    {
      return false;
      paramLightAppSettingInfo = paramLightAppSettingInfo.a;
    } while ((paramLightAppSettingInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null));
    boolean bool1 = bool2;
    switch (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
        break;
      }
      bool1 = bool2;
      continue;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11003))) {
        break;
      }
      bool1 = bool2;
    }
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare)) {
        if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 97)) {
          localLayoutParams.setMargins(AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "updateImageView addStructView");
        }
        if (!this.g) {
          break;
        }
        b(paramQQCustomDialog);
        return false;
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
          localLayoutParams.setMargins(0, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        } else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
          localLayoutParams.setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        }
      }
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      if ((!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) && (!bool) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_sources", true))) {
        a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    localObject = new LightAppUtil();
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((LightAppUtil)localObject).a(localDeviceInfo);
        if (QLog.isColorLevel()) {
          QLog.e("ForwardStructingMsgOption", 2, "settingInfo = " + localLightAppSettingInfo);
        }
        if ((a(j)) && (a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.adjustMessageBottomMargin(17.0F);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextColor(2131493794);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextSize(14.0F);
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97))
    {
      ViewGroup.LayoutParams localLayoutParams = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131363771)).getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(0, 0, 0, 0);
      }
    }
  }
  
  protected boolean c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)) {
      QLog.d("forward", 2, "ForwardStructingMsgOption realForwardTo  mShareMsg.mMsgServiceID=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
    {
      StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), null, 0);
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("k_back", true))
      {
        localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class), null);
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgBrief != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgBrief.equals(this.jdField_a_of_type_AndroidAppActivity.getString(2131429285)))) {
      ReportController.b(null, "CliOper", "", "", "0X8005403", "0X8005403", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) && ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 32) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97)))
    {
      localObject = ForwardUtils.a(localIntent);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject, localIntent);
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97) {
        return false;
      }
    }
    if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("forwardDirect", false)) && ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))) {
      ForwardUtils.a((QQAppInterface)((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime(), this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), localIntent, null);
    }
    localIntent.putExtra("uin", this.jdField_a_of_type_AndroidOsBundle.getString("uin", ""));
    localIntent.putExtra("uintype", this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0));
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
  
  protected int d()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
    {
      localObject1 = QfavUtil.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
      if ((localObject1 == null) || (!QfavBuilder.b(((StructMsgItemImage)localObject1).u).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))) {}
    }
    else
    {
      for (i = 0;; i = 0)
      {
        if (i == 0) {
          QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
        }
        return i;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData)) {
          break;
        }
        String[] arrayOfString1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData.split("&");
        int j = arrayOfString1.length;
        i = 0;
        Object localObject4 = null;
        Object localObject3 = null;
        Object localObject2 = null;
        localObject1 = null;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          Object localObject5 = localObject4;
          Object localObject6 = localObject3;
          Object localObject7 = localObject2;
          Object localObject8 = localObject1;
          if (arrayOfString2.length > 1)
          {
            if (!arrayOfString2[0].trim().equals("lat")) {
              break label225;
            }
            localObject8 = arrayOfString2[1];
            localObject7 = localObject2;
            localObject6 = localObject3;
            localObject5 = localObject4;
          }
          for (;;)
          {
            i += 1;
            localObject4 = localObject5;
            localObject3 = localObject6;
            localObject2 = localObject7;
            localObject1 = localObject8;
            break;
            label225:
            if (arrayOfString2[0].trim().equals("lon"))
            {
              localObject7 = arrayOfString2[1];
              localObject5 = localObject4;
              localObject6 = localObject3;
              localObject8 = localObject1;
            }
            else if (arrayOfString2[0].trim().equals("loc"))
            {
              localObject6 = arrayOfString2[1];
              localObject5 = localObject4;
              localObject7 = localObject2;
              localObject8 = localObject1;
            }
            else
            {
              localObject5 = localObject4;
              localObject6 = localObject3;
              localObject7 = localObject2;
              localObject8 = localObject1;
              if (arrayOfString2[0].trim().equals("title"))
              {
                localObject5 = arrayOfString2[1];
                localObject6 = localObject3;
                localObject7 = localObject2;
                localObject8 = localObject1;
              }
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 32) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(localObject2)) || (TextUtils.isEmpty(localObject3)) || (!QfavBuilder.a(Float.valueOf((String)localObject1).floatValue(), Float.valueOf(localObject2).floatValue(), localObject4, localObject3, null).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))) {
          break label539;
        }
      }
      localObject1 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
      if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
        break label544;
      }
    }
    label539:
    label544:
    for (int i = 2;; i = 0)
    {
      if (QfavBuilder.a(i, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject1, false, 0L).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
      {
        i = 0;
        break;
      }
      i = -1;
      break;
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("structmsg_service_id", -1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800567B", "0X800567B", 0, 0, i + "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      localObject1 = (StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
      Iterator localIterator = ((StructMsgForGeneralShare)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (AbsStructMsgElement)localIterator.next();
        if ((localObject2 instanceof StructMsgItemLayout5))
        {
          localObject2 = ((StructMsgItemLayout5)localObject2).a.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
            if ((localObject3 instanceof StructMsgItemVideo))
            {
              localObject3 = (StructMsgItemVideo)localObject3;
              if (((StructMsgItemVideo)localObject3).a()) {
                VideoReporter.a("0X80065FF", ((StructMsgForGeneralShare)localObject1).uinType, VideoReporter.a(((StructMsgItemVideo)localObject3).k, ((StructMsgForGeneralShare)localObject1).mSourceName), ((StructMsgItemVideo)localObject3).w, "");
              }
            }
          }
        }
      }
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) && (AIOGallerySceneWithBusiness.b(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData)))
    {
      localObject1 = AIOGallerySceneWithBusiness.b(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData);
      if ((localObject1 != null) && (localObject1.length > 3))
      {
        localObject1 = localObject1[3];
        if ((localObject1 != null) && (((String)localObject1).equals("1")))
        {
          PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X80072A5", "0X80072A5", 0, 0, "", "", "", "");
          PublicAccountReportUtils.a("0X80072A5", "", "", "", "", "");
        }
      }
    }
    i = c();
    Object localObject1 = "";
    if (i != 0) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
    super.m();
  }
  
  protected void n()
  {
    super.n();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
  }
  
  protected void u()
  {
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardStructingMsgOption
 * JD-Core Version:    0.7.0.1
 */