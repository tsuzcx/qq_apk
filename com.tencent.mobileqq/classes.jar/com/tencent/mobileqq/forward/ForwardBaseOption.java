package com.tencent.mobileqq.forward;

import adad;
import adaf;
import adag;
import adah;
import adaj;
import adak;
import adal;
import adan;
import adao;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ForwardBaseOption
  implements DialogInterface.OnDismissListener, ForwardAbility, ForwardAbility.ForwardAbilityType, ForwardConstants, ForwardDialogBuilder
{
  static int jdField_a_of_type_Int;
  public static String e;
  public float a;
  public long a;
  public Activity a;
  public Context a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  public Intent a;
  public Bundle a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected ShareResultDialog a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new adao(this);
  public QQAppInterface a;
  public QQCustomDialog a;
  protected QQProgressDialog a;
  public String a;
  protected Set a;
  public boolean a;
  DialogInterface.OnClickListener b;
  public String b;
  protected boolean b;
  DialogInterface.OnClickListener c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  boolean e;
  boolean f;
  
  static
  {
    jdField_e_of_type_JavaLangString = "key_thumb_style_centerinside";
  }
  
  public ForwardBaseOption(Intent paramIntent)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    if (paramIntent.getExtras() != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = new Bundle())
    {
      this.jdField_a_of_type_AndroidOsBundle = paramIntent;
      this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Class paramClass, int paramInt)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, ForwardRecentActivity.class);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class paramClass)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, paramClass);
      paramContext.startActivity(paramIntent);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "startPhotoPlus: path=" + paramString1);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, true, true, true, true, true, 2, 99, 6);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2131034165, 2131034167);
    }
  }
  
  private void w()
  {
    if (jdField_a_of_type_Int <= 0)
    {
      Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558597);
      int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558595);
      jdField_a_of_type_Int = (localDisplay.getWidth() - i * 2 - j * 3) / 4;
    }
  }
  
  private void x()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if ((i == jdField_f_of_type_JavaLangInteger.intValue()) || (i == k.intValue()) || (i == g.intValue()) || (i == j.intValue()) || (i == m.intValue()) || (i == jdField_e_of_type_JavaLangInteger.intValue())) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("is_ark_display_share", false);
    }
  }
  
  public int a()
  {
    return 2131432998;
  }
  
  protected final DialogInterface.OnClickListener a()
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new adad(this);
    }
    return this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "DialogContent:mForwardText=" + this.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 10002) && (localRecentUser.type != 10004) && (localRecentUser.type != 1022) && (localRecentUser.type != 1029) && (localRecentUser.type != 1032) && (localRecentUser.type != 1033) && (localRecentUser.type != 1034) && (localRecentUser.type != 7000) && (localRecentUser.type != 6004) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && (localRecentUser.type != 9501) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 0) || (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardBaseOption", 2, "getForwardRecentList result size is: " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public Set a()
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      a();
    }
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  protected void a()
  {
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (g()) {
      this.jdField_a_of_type_JavaUtilSet.add(h);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_e_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!e()) {
      return;
    }
    if (paramInt >= 0) {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    }
    j();
  }
  
  protected void a(Intent paramIntent) {}
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      URLDrawableHelper.a((URLDrawable)paramDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {}
    while (paramBoolean) {
      return;
    }
    paramDrawable.setBounds(ImageUtil.a(paramDrawable, 36, 100, this.jdField_a_of_type_Float));
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    a(paramDrawable, paramBoolean, paramInt, false);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adaj(this, paramDrawable, paramBoolean1, paramInt, paramBoolean2));
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
  }
  
  public void a(QQCustomDialog paramQQCustomDialog) {}
  
  public void a(String paramString) {}
  
  protected final void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "addSourceNameView start! sourceName =" + paramString);
    }
    if ((paramString == null) || ("".equals(paramString)) || (paramQQCustomDialog == null)) {
      return;
    }
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    localTextView.setText(paramString);
    localTextView.setTextSize(12.0F);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setIncludeFontPadding(false);
    localTextView.setTextColor(-8355712);
    paramQQCustomDialog.addView(localTextView);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.jdField_d_of_type_Boolean = true;
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", 1);
    localBundle.putString("uinname", "群聊" + paramString2);
    a(ForwardAbility.ForwardAbilityType.jdField_d_of_type_JavaLangInteger.intValue(), localBundle);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_thumb");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_urldrawable", false);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_urldrawable_thumb_url");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_urldrawable_big_url");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_text");
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_from_jump", false);
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1) == 11) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id", 0L);
    }
    w();
    return true;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt2 == jdField_f_of_type_JavaLangInteger.intValue()) || (paramInt2 == k.intValue())) {}
    boolean bool1;
    do
    {
      do
      {
        return false;
      } while ((this.jdField_c_of_type_Boolean) || ((this instanceof ForwardSendHongBaoOption)) || ((this instanceof ForwardChooseFriendOption)) || (this.jdField_a_of_type_AndroidOsBundle.getInt("cmshow_game_id") > 0) || (this.jdField_a_of_type_AndroidOsBundle.getLong("gold_msg_amount_of_money", 0L) > 0L));
      bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
      bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    } while ((bool1) || (bool2));
    if (paramInt1 == 1) {
      if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramString, true).jdField_a_of_type_Boolean)
      {
        bool1 = false;
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if ((this instanceof ForwardFileOption))
          {
            paramString = (ForwardFileOption)this;
            bool2 = bool1;
            if (paramString.a != null)
            {
              bool2 = bool1;
              if (paramString.a.b() != 10006) {}
            }
          }
        }
      }
    }
    for (boolean bool2 = false;; bool2 = true)
    {
      return bool2;
      bool1 = true;
      break;
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
    boolean bool1 = bool2;
    if (!bool2)
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.equals(this.jdField_a_of_type_AndroidAppActivity.getString(2131431600))) {
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131433280));
      paramIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromAIOPlus");
    return (bool1) && (bool2);
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    boolean bool = true;
    if (paramLightAppSettingInfo == null) {}
    do
    {
      return false;
      paramLightAppSettingInfo = paramLightAppSettingInfo.a;
    } while ((paramLightAppSettingInfo == null) || (this.jdField_a_of_type_AndroidOsBundle == null));
    switch (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"))
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
        break;
      }
      continue;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11003))) {
        break;
      }
    }
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    return true;
  }
  
  public boolean a(Integer paramInteger)
  {
    return (this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramInteger));
  }
  
  public boolean a(String paramString)
  {
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    return (localHotChatManager != null) && (localHotChatManager.b(paramString));
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    return null;
  }
  
  public int b()
  {
    return 2131433614;
  }
  
  protected final DialogInterface.OnClickListener b()
  {
    if (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new adaf(this);
    }
    return this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_forward_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "发送到";
    }
    return str1;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->forwardToDataLine--type = " + paramInt);
    }
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if ((bool1) || (bool2) || (bool3))
    {
      if ((bool2) || (bool3))
      {
        this.jdField_a_of_type_AndroidOsBundle.remove("PhotoConst.SEND_FLAG");
        this.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_FLAG");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->forwardToDataLine jumpAIO ");
      }
      c(paramInt);
      return;
    }
    Bundle localBundle = new Bundle();
    String str = AppConstants.y;
    if (paramInt == k.intValue()) {
      str = AppConstants.z;
    }
    for (;;)
    {
      localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      Intent localIntent = new Intent();
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      adal localadal = new adal(this);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
      {
        a(localIntent);
        localBundle.putAll(localIntent.getExtras());
      }
      for (paramInt = localDataLineHandler.a().a(str, localBundle, localadal);; paramInt = localDataLineHandler.a().b(str, localBundle, localadal))
      {
        if ((localadal.jdField_a_of_type_Boolean) && (paramInt != 0)) {
          break label340;
        }
        DirectForwarder.b(this.jdField_a_of_type_AndroidAppActivity, paramInt);
        if (localadal.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("NOCANCEL4DATALIN", true);
        this.jdField_a_of_type_AndroidAppActivity.setResult(0, this.jdField_a_of_type_AndroidContentIntent);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        b(localIntent);
        localBundle.putAll(localIntent.getExtras());
      }
      label340:
      break;
    }
  }
  
  protected void b(Intent paramIntent) {}
  
  protected void b(String paramString)
  {
    Object localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Object localObject2 = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(paramString));
    ((SmartDeviceProxyMgr)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, (DeviceInfo)localObject2, false);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false)) {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
    }
    for (;;)
    {
      localObject2 = (RouterHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(48);
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(new FileInfo((String)localObject1));
        label93:
        ((RouterHandler)localObject2).a(localArrayList, null, null, Long.parseLong(paramString));
        return;
        localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        break label93;
      }
    }
  }
  
  protected final void b(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView: filepath=" + paramString);
    }
    ThreadManager.post(new adak(this, paramString, paramQQCustomDialog), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView end! ");
    }
  }
  
  protected int c()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", 0);
  }
  
  protected final DialogInterface.OnClickListener c()
  {
    if (this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new adag(this);
    }
    return this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public String c()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    Object localObject2;
    long l;
    if (i == jdField_e_of_type_JavaLangInteger.intValue())
    {
      localObject1 = "QQ空间";
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "发送给 " + (String)localObject1;
      }
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("gold_msg_amount_of_money", 0L);
      localObject1 = localObject2;
      if (l > 0L) {
        if (l % 100L != 0L) {
          break label272;
        }
      }
    }
    label272:
    for (Object localObject1 = String.valueOf(l / 100L);; localObject1 = String.valueOf((float)l / 100.0F))
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131432301);
      Object localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = "";
      }
      localObject1 = String.format(str, new Object[] { localObject3, localObject1 });
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "dialogTitle=" + (String)localObject1);
      }
      return localObject1;
      if (i == jdField_f_of_type_JavaLangInteger.intValue())
      {
        localObject1 = "我的电脑";
        break;
      }
      if (i == k.intValue())
      {
        localObject1 = "我的iPad";
        break;
      }
      if (i == g.intValue())
      {
        localObject1 = "我的收藏";
        break;
      }
      if (i == m.intValue())
      {
        localObject1 = "日迹";
        break;
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
      break;
    }
  }
  
  public void c()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "0", "", "", "");
  }
  
  protected void c(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    if (paramInt == k.intValue())
    {
      localIntent.putExtra("targetUin", AppConstants.z);
      localIntent.putExtra("device_type", 1);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
      }
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localIntent.putExtra("MigSdkShareNotDone", false);
      if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false)) {
        break label204;
      }
      a(localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(0, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      localIntent.putExtra("targetUin", AppConstants.y);
      localIntent.putExtra("device_type", 0);
      break;
      label204:
      b(localIntent);
    }
  }
  
  protected boolean c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
  
  protected int d()
  {
    return -1;
  }
  
  public void d() {}
  
  protected void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--code = " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    t();
    adan localadan = new adan(this);
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = new ShareResultDialog(this.jdField_a_of_type_AndroidAppActivity);
    }
    for (;;)
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131433681);
      Object localObject = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"))) {
        localObject = str + this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      }
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a((String)localObject, localadan);
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131429898);
      localObject = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog;
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        ((ShareResultDialog)localObject).a(bool);
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131431585);
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(0);
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.c(2131431584);
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131431588), localadan);
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.show();
        return;
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
        continue;
        bool = false;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--resultDlg.show() failed");
      }
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e() {}
  
  protected boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    t();
    return true;
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    a();
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_favorites", true)) {
      this.jdField_a_of_type_JavaUtilSet.add(g);
    }
  }
  
  protected boolean g()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if ((localPhoneContactManager != null) && (localPhoneContactManager.c())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowPhoneContactAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomArkDialog)) {
      ((QQCustomArkDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).a(0);
    }
  }
  
  protected boolean h()
  {
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((DiscussionManager)localObject).a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowDiscussAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomArkDialog)) {
      ((QQCustomArkDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).a(1);
    }
  }
  
  protected boolean i()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowTroopAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  @TargetApi(11)
  public final void j()
  {
    x();
    int i = c();
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->buildConfirmDialog--editTextType = " + i);
    }
    if (i == 0) {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131432998, b());
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131433614, a());
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.adjustTitle();
      b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMsgMaxLineWithEnd(this.jdField_a_of_type_JavaLangString, 3);
      if (a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) {
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      }
      if (this.jdField_a_of_type_AndroidOsBundle.getInt(jdField_e_of_type_JavaLangString, 0) == 1) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImageScaleType(true);
      }
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
      if (this.jdField_a_of_type_AndroidOsBundle.getLong("gold_msg_amount_of_money", 0L) > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, c(), a(), a(), b(), a(), b());
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, c(), a(), a(), b(), a(), b());
      continue;
      if (i == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b());
        continue;
      }
      Object localObject1;
      if (i == 2) {
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share", false))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle);
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("shareArkInfo");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
      }
      try
      {
        Object localObject2 = new JSONObject((String)localObject1);
        localObject1 = ((JSONObject)localObject2).optString("app");
        String str = ((JSONObject)localObject2).optString("view");
        localObject2 = ((JSONObject)localObject2).optString("meta");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "AIOArkSdkSelectSend", 1, 0, 0L, 0L, 0L, str, "");
        }
        label493:
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131432998, b());
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131433614, a());
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), 0);
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
        boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_ability_entrence_show_in_share", false);
        if ((i != jdField_e_of_type_JavaLangInteger.intValue()) || (!bool)) {
          continue;
        }
        localObject1 = (QQCustomDialogWtihEmoticonInput)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
        ((QQCustomDialogWtihEmoticonInput)localObject1).a();
        ((QQCustomDialogWtihEmoticonInput)localObject1).getEditText().setHint("说点什么吧");
        continue;
        if (i == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), 0, false);
          continue;
        }
        if (i == 4)
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("choose_friend_content");
          str = this.jdField_a_of_type_AndroidOsBundle.getString("choose_friend_subcontent");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("choose_friend_feedbacks");
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), (String)localObject1, str, (ArrayList)localObject2, null, a(), b(), 36, false);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, c(), a(), a(), b(), a(), b());
      }
      catch (JSONException localJSONException)
      {
        break label493;
      }
    }
  }
  
  protected boolean j()
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).d();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (((Groups)((Iterator)localObject).next()).group_friend_count <= 0);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowFriendAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  public void k() {}
  
  protected boolean k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowQZoneAbility--allow = false");
    }
    return false;
  }
  
  public void l() {}
  
  protected boolean l()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false);
    int i;
    if (MultiMsgManager.a().e() > 1)
    {
      i = 1;
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("from_busi_type");
      if ((!bool3) && (i == 0) && (j != 2)) {
        break label84;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowSmartDeviceAbility--allow = false");
        bool2 = bool1;
      }
    }
    label84:
    do
    {
      return bool2;
      i = 0;
      break;
      Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((SmartDeviceProxyMgr)localObject).a())
        {
          localObject = ((SmartDeviceProxyMgr)localObject).a();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (localObject.length > 0) {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowSmartDeviceAbility--allow = " + bool1);
    return bool1;
  }
  
  public void m()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    r();
  }
  
  public void n()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void o() {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof DirectForwardActivity)) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  protected void p()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_photo_shortvideo_is_edited", false);
    if ((this.jdField_a_of_type_AndroidViewView$OnClickListener == null) && (!bool)) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new adah(this, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setImageOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void q()
  {
    int i = d();
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    d(i);
  }
  
  protected void r()
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 6002) {
      b(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
    }
    while (c()) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void u() {}
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption
 * JD-Core Version:    0.7.0.1
 */