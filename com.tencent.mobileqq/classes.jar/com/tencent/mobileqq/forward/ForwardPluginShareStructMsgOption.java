package com.tencent.mobileqq.forward;

import adte;
import adtf;
import adtg;
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
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ForwardPluginShareStructMsgOption
  extends ForwardBaseOption
{
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new adtf(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  int b;
  int c;
  String f;
  String jdField_g_of_type_JavaLangString = "";
  boolean jdField_g_of_type_Boolean = false;
  
  public ForwardPluginShareStructMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      bool1 = bool2;
      if (paramAbsStructMsg != null) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramAbsStructMsg.size())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramAbsStructMsg.get(i);
        if (!(localAbsStructMsgElement instanceof StructMsgItemLayout2)) {
          break label95;
        }
        paramAbsStructMsg = (StructMsgItemLayout2)localAbsStructMsgElement;
        bool1 = bool2;
        if (paramAbsStructMsg.e != 1)
        {
          bool1 = bool2;
          if (paramAbsStructMsg.e != 3) {
            bool1 = true;
          }
        }
      }
      return bool1;
      label95:
      i += 1;
    }
  }
  
  private void b(QQCustomDialog paramQQCustomDialog)
  {
    int j = 1;
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
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130846175);
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
      int i = j;
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidOsBundle.getInt("title_max_line", -1) > 0) {
          i = this.jdField_a_of_type_AndroidOsBundle.getInt("title_max_line", 1);
        }
      }
      ((TextView)localObject2).setMaxLines(i);
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
  
  private void c(String paramString)
  {
    ThreadManager.post(new adtg(this, paramString), 5, null, true);
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_b_of_type_Int == 13) || ("public_account".equals(this.f)) || ("web_share".equals(this.f)) || ("struct_msg_from_h5".equals(this.f)) || ("struct_favorite".equals(this.f)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 10002) && (localRecentUser.type != 10004) && (localRecentUser.type != 1022) && (localRecentUser.type != 1029) && (localRecentUser.type != 1024) && (localRecentUser.type != 1025) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.type != 7000) && (localRecentUser.type != 6004) && (localRecentUser.type != 9501) && ((localRecentUser.type != 0) || (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) && (((localRecentUser.type == 0) && (a(jdField_b_of_type_JavaLangInteger))) || ((localRecentUser.type == 1) && (!a(localRecentUser.uin)) && (a(jdField_c_of_type_JavaLangInteger))) || ((localRecentUser.type == 3000) && (a(jdField_d_of_type_JavaLangInteger)) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.jdField_b_of_type_Boolean))))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("shareQQType", 13);
    if (((i & 0x8) != 0) && (h())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (((i & 0x4) != 0) && (i())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (((i & 0x1) != 0) && (j())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (super.l()) {
      this.jdField_a_of_type_JavaUtilSet.add(j);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "81");
      localBundle.putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
      localBundle.putString("intext_2", "" + ReportDef.RepUtil.a(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
      localBundle.putString("intext_3", "1");
      ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
    super.a(paramInt, paramBundle);
  }
  
  public void a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!(paramAbsStructMsg instanceof StructMsgForGeneralShare))) {}
    label454:
    label460:
    label461:
    label466:
    for (;;)
    {
      return;
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.size() != 0))
      {
        paramAbsStructMsg = paramAbsStructMsg.iterator();
        Object localObject1;
        do
        {
          if (!paramAbsStructMsg.hasNext()) {
            break;
          }
          localObject1 = (AbsStructMsgElement)paramAbsStructMsg.next();
        } while (!(localObject1 instanceof StructMsgItemLayout2));
        for (paramAbsStructMsg = (StructMsgItemLayout2)localObject1;; paramAbsStructMsg = null)
        {
          if (paramAbsStructMsg == null) {
            break label466;
          }
          paramAbsStructMsg = paramAbsStructMsg.a;
          if ((paramAbsStructMsg == null) || (paramAbsStructMsg.size() == 0)) {
            break;
          }
          localObject1 = paramAbsStructMsg.iterator();
          paramAbsStructMsg = null;
          label102:
          Object localObject2;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
            if (!(localObject2 instanceof StructMsgItemSummary)) {
              break label460;
            }
            paramAbsStructMsg = (StructMsgItemSummary)localObject2;
          }
          for (;;)
          {
            break label102;
            if (paramAbsStructMsg == null) {
              break label461;
            }
            localObject1 = paramAbsStructMsg.b();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
            StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
            int i = 0;
            int j;
            int[] arrayOfInt;
            if (i < localStringBuilder.length())
            {
              j = i;
              if ('ÿ' == localStringBuilder.charAt(i))
              {
                j = i;
                if (i + 3 < localStringBuilder.length())
                {
                  localObject1 = new char[4];
                  localObject1[0] = localStringBuilder.charAt(i + 3);
                  localObject1[1] = localStringBuilder.charAt(i + 2);
                  localObject1[2] = localStringBuilder.charAt(i + 1);
                  localObject1[3] = localStringBuilder.charAt(i);
                  j = 0;
                  if (j < 4)
                  {
                    if (localObject1[j] == 'ú') {
                      localObject1[j] = 10;
                    }
                    for (;;)
                    {
                      j += 1;
                      break;
                      if (localObject1[j] == 'þ') {
                        localObject1[j] = 13;
                      } else if (localObject1[j] == 'ý') {
                        localObject1[j] = 20;
                      }
                    }
                  }
                  arrayOfInt = EmosmUtils.a((char[])localObject1);
                  localObject2 = "[小表情]";
                  if (localEmoticonManager == null) {
                    break label454;
                  }
                }
              }
            }
            for (localObject1 = localEmoticonManager.a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));; localObject1 = null)
            {
              if (localObject1 != null) {}
              for (localObject1 = ((Emoticon)localObject1).character;; localObject1 = localObject2)
              {
                localStringBuilder.replace(i, i + 3, (String)localObject1);
                j = i + ((String)localObject1).length();
                i = j + 1;
                break;
                c(Integer.toString(arrayOfInt[0]));
              }
              if (TextUtils.isEmpty(localStringBuilder)) {
                break;
              }
              paramAbsStructMsg.a(localStringBuilder.toString());
              return;
            }
          }
          break;
        }
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption preloadData");
    }
    super.a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
    this.f = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
    this.e = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward _key_nojump", false);
    Object localObject = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 83) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 108) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 116))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 3);
      this.jdField_c_of_type_Int = 2;
    }
    for (;;)
    {
      localObject = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl);
      try
      {
        this.jdField_g_of_type_JavaLangString = ((Uri)localObject).getQueryParameter("article_id");
        if (this.jdField_g_of_type_JavaLangString == null) {
          this.jdField_g_of_type_JavaLangString = "";
        }
        if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("report_type", "102");
          ((Bundle)localObject).putString("act_type", "80");
          ((Bundle)localObject).putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
          ((Bundle)localObject).putString("intext_3", "1");
          ReportCenter.a().a((Bundle)localObject, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        }
        return true;
        if ((!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) && (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com"))) {
          continue;
        }
        this.jdField_c_of_type_Int = 1;
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
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
    if (localObject != null)
    {
      localObject = StructMsgFactory.a((byte[])localObject);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      a((AbsStructMsg)localObject);
      boolean bool = a((AbsStructMsg)localObject);
      if ((localObject instanceof StructMsgForAudioShare)) {
        localLayoutParams.setMargins(0, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      while (this.jdField_g_of_type_Boolean)
      {
        b(paramQQCustomDialog);
        return false;
        if (bool) {
          localLayoutParams.setMargins(0, 0, 0, 0);
        } else {
          localLayoutParams.setMargins(AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        }
      }
      paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      if (!bool) {
        a(((AbsStructMsg)localObject).getSourceName(), paramQQCustomDialog);
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
        if ((a(j)) && (super.a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected int d()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
    if ((!TextUtils.isEmpty(str)) && (QfavBuilder.a(str).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))) {}
    for (int i = 0;; i = -1)
    {
      if (i == 0) {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
    }
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 1)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131430276, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "82");
      ((Bundle)localObject1).putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
      ((Bundle)localObject1).putString("intext_2", "" + ReportDef.RepUtil.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
      ((Bundle)localObject1).putString("intext_3", "1");
      ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (c() != 0) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();; localObject1 = "")
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com")))
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        PublicAccountReportUtils.a(null, "", "0X8007236", "0X8007236", 0, 0, this.jdField_g_of_type_JavaLangString, "" + this.jdField_c_of_type_Int, (String)localObject2, "");
        PublicAccountReportUtils.a("0X8007236", "", this.jdField_g_of_type_JavaLangString, "" + this.jdField_c_of_type_Int, (String)localObject2, "");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!"".equals(localObject1))) {
          PublicAccountReportUtils.a(null, "", "0X8007237", "0X8007237", 0, 0, this.jdField_g_of_type_JavaLangString, "" + this.jdField_c_of_type_Int, (String)localObject2, "");
        }
      }
      this.jdField_a_of_type_AndroidContentIntent.getAction();
      Object localObject2 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false));
      Object localObject3 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_back", false));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=" + localObject2 + "iskeyBack=" + localObject3 + "isNOneedJumpToAIO=" + this.e);
      }
      Object localObject4;
      if (((Boolean)localObject2).booleanValue())
      {
        localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 });
        this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
        ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        a((Intent)localObject2);
        if (((Boolean)localObject3).booleanValue())
        {
          localObject3 = StructMsgFactory.a(((Intent)localObject2).getExtras());
          if ((this.jdField_b_of_type_Int == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
          {
            localObject4 = (StructMsgForGeneralShare)localObject3;
            StringBuilder localStringBuilder = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
            localStringBuilder.append("&msg=").append(((Intent)localObject2).getStringExtra("title")).append("&toUin=").append(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
            ((StructMsgForGeneralShare)localObject4).mMsgActionData = localStringBuilder.toString();
          }
          if (((AbsStructMsg)localObject3).mMsgServiceID == 83) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          if ((((AbsStructMsg)localObject3).mMsgServiceID == 108) || (((AbsStructMsg)localObject3).mMsgServiceID == 114) || (((AbsStructMsg)localObject3).mMsgServiceID == 116)) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          localObject4 = ForwardUtils.a((Intent)localObject2);
          ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), ((SessionInfo)localObject4).b, this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), (AbsStructMsg)localObject3, null);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ThreadManager.getSubThreadHandler().post(new adte(this, (SessionInfo)localObject4, (String)localObject1));
          }
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
          if (!"public_account".equals(this.f)) {
            break label1398;
          }
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
          if (localObject1 != null) {
            break label1504;
          }
          localObject1 = "";
        }
      }
      label1504:
      for (;;)
      {
        int i;
        int j;
        switch (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"))
        {
        default: 
          i = -1;
          j = 0;
          label996:
          if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false))
          {
            if (this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_uin") == null) {}
            localObject3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("strurt_msgid");
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject4 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
            localObject3 = localObject4;
            if (localObject4 == null) {
              localObject3 = "";
            }
            localObject4 = StructingMsgItemBuilder.a();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005456", "0X8005456", 0, 0, (String)localObject4, (String)localObject2, (String)localObject3, "" + i);
          }
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_11", "pbshare_success", j);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("report_type", "102");
            ((Bundle)localObject1).putString("act_type", "83");
            ((Bundle)localObject1).putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
            ((Bundle)localObject1).putString("intext_2", "" + ReportDef.RepUtil.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
            ((Bundle)localObject1).putString("intext_3", "1");
            ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
          }
          this.jdField_a_of_type_AndroidAppActivity.finish();
          return;
          if (this.e)
          {
            localObject1 = ForwardUtils.a((Intent)localObject2);
            ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, (Intent)localObject2);
            break;
          }
          if (ForwardOptionUtils.a((Intent)localObject2))
          {
            localObject1 = ForwardUtils.a((Intent)localObject2);
            ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, (Intent)localObject2);
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
          break;
          i = 1;
          j = 1001;
          break label996;
          i = 2;
          j = 1002;
          break label996;
          i = 3;
          j = 1003;
          break label996;
          label1398:
          if ("struct_msg_from_h5".equals(this.f))
          {
            localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_31", "share_succ");
            }
          }
          else if (ForwardOptionUtils.a((Intent)localObject2))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_AndroidOsBundle.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
          }
        }
        r();
        return;
      }
    }
  }
  
  protected void n()
  {
    super.n();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005457", "0X8005457", 0, 0, "", "", "android", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com")))
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      PublicAccountReportUtils.a(null, "", "0X8007235", "0X8007235", 0, 0, this.jdField_g_of_type_JavaLangString, "" + this.jdField_c_of_type_Int, str, "");
    }
  }
  
  protected void u()
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if (localAbsStructMsg != null) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), localAbsStructMsg);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption
 * JD-Core Version:    0.7.0.1
 */