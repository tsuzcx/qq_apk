package com.tencent.mobileqq.filemanager.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipTroopFileConfig;
import com.tencent.mobileqq.config.business.qvip.QVipTroopFileProcessor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class SendBottomBar
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new SendBottomBar.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox = null;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private IBaseTabViewEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = null;
  private IClickListenerVer51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
  public QQProgressDialog a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new SendBottomBar.2(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private boolean jdField_b_of_type_Boolean = false;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new SendBottomBar.3(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private boolean jdField_c_of_type_Boolean = false;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new SendBottomBar.4(this);
  private TextView jdField_d_of_type_AndroidWidgetTextView = null;
  private boolean jdField_d_of_type_Boolean = true;
  private TextView jdField_e_of_type_AndroidWidgetTextView = null;
  private boolean jdField_e_of_type_Boolean = false;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560925, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    j();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560925, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    j();
  }
  
  @NotNull
  private String a()
  {
    long l = FMDataCache.d();
    String str1 = "";
    if (l > 0L)
    {
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692405) + FileUtil.a(l);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
    String str2 = str1;
    if (FMDataCache.e() > 0L)
    {
      str2 = str1;
      if (!FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
        str2 = str1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692406) + FileUtil.a(FMDataCache.e());
      }
    }
    if (FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692405) + FMDataCache.b() + HardCodeUtil.a(2131713743);
    }
    return str2;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0))
    {
      long l = FMDataCache.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      Object localObject;
      if (l > 99L)
      {
        localObject = HardCodeUtil.a(2131713747);
        if (!b()) {
          break label273;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713751));
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165342);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setCompoundDrawables(null, null, null, null);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTextColor(getResources().getColor(2131167040));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTextSize(1, 17.0F);
        if (l <= 0L) {
          break label261;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
      for (;;)
      {
        return true;
        if (l == 0L)
        {
          localObject = HardCodeUtil.a(2131713754);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          break;
        }
        localObject = HardCodeUtil.a(2131713764) + String.valueOf(l) + ")";
        break;
        label261:
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        continue;
        label273:
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean) {
      if (FMDataCache.c() > 104857600L)
      {
        paramBoolean = true;
        if ((!paramBoolean) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_b_of_type_Boolean)) {
          break label104;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_b_of_type_Boolean) {
          break label270;
        }
        paramBoolean = bool;
      }
    }
    label265:
    label270:
    for (;;)
    {
      Object localObject1 = QVipTroopFileProcessor.c();
      if (((QVipTroopFileConfig)localObject1).a())
      {
        localObject2 = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        if (!((QVipTroopFileConfig)localObject1).a(this.jdField_a_of_type_AndroidContentContext, new SendBottomBar.8(this), paramBoolean, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_a_of_type_Boolean)) {}
      }
      label104:
      do
      {
        return;
        paramBoolean = false;
        break;
        if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) == 0)
        {
          TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697610));
          c();
          return;
        }
        if (!FileManagerUtil.a()) {
          break label265;
        }
      } while (!FreeWifiHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new SendBottomBar.9(this)));
      Object localObject2 = new SendBottomBar.10(this);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697384);
      localObject2 = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697607), (String)localObject1, 2131690800, 2131697803, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2);
      if ((KingCardProcessor.c().b.jdField_a_of_type_Boolean) && (!TMSManager.a().b())) {
        ((QQCustomDialog)localObject2).setMessageWithoutAutoLink(KingCardProcessor.c().b.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject1));
      }
      ((QQCustomDialog)localObject2).show();
      return;
      c();
      return;
    }
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g();
    if (i == -1) {
      return false;
    }
    if (!c()) {
      return false;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new SendBottomBar.5(this));
    Object localObject = "";
    switch (i)
    {
    }
    for (;;)
    {
      localObject = FileManagerUtil.a("排序方式:\n" + (String)localObject, (String)localObject, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return true;
      localObject = HardCodeUtil.a(2131713740);
      continue;
      localObject = HardCodeUtil.a(2131713749);
      continue;
      localObject = HardCodeUtil.a(2131713766);
    }
  }
  
  private boolean c()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (arrayOfInt == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
      return false;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null));
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int m = arrayOfInt[i];
      ActionSheet localActionSheet;
      String str;
      boolean bool;
      switch (m)
      {
      default: 
        i += 1;
        break;
      case 1: 
        localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
        str = HardCodeUtil.a(2131713734);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localActionSheet.addRadioButton(str, bool);
          break;
        }
      case 0: 
        localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
        str = HardCodeUtil.a(2131713750);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localActionSheet.addRadioButton(str, bool);
          break;
        }
      case 2: 
        localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
        str = HardCodeUtil.a(2131713741);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localActionSheet.addRadioButton(str, bool);
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(HardCodeUtil.a(2131713746));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListenerV2(new SendBottomBar.6(this));
    return true;
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity instanceof FMActivity))) {
      return ((FMActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity).i() == 1201;
    }
    return false;
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373457));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372347));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364706));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377759));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373454));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365957));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365958));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377734);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) || (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713744));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("_fm_select_showd", false);
  }
  
  private void k()
  {
    FileManagerReporter.a("0x80087C5");
    b(2131694893);
    new Handler().postDelayed(new SendBottomBar.7(this), 100L);
  }
  
  private void l()
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a() == 1)
    {
      i = 2;
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
      if ((TextUtils.isEmpty(str)) || (!str.equals(AppConstants.DATALINE_PC_UIN))) {
        break label110;
      }
      i = 3;
    }
    label110:
    for (;;)
    {
      long l = FMDataCache.b();
      ReportController.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a() == 0) {
        break;
      }
      i = 4;
      break;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FMDataCache.a());
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("reslut_select_file_info_list", localArrayList);
      localIntent.putExtra("approval_attachment_customid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void n()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B378", "0X800B378", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c())
    {
      Object localObject2 = FMDataCache.b();
      Object localObject1 = FMDataCache.d();
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = new ArrayList();
      ((ArrayList)localObject3).addAll(FMDataCache.a());
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (FileInfo)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject4 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, ((FileInfo)localObject4).c(), true);
          if (localObject4 != null) {
            localArrayList.add(localObject4);
          }
        }
      }
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          localObject3 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject3, "", false);
          if (localObject3 != null) {
            localArrayList.add(localObject3);
          }
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = QfavUtil.a((WeiYunFileInfo)((Iterator)localObject1).next());
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putParcelableArrayListExtra("reslut_select_file_info_list_for_fav", localArrayList);
      ((Intent)localObject1).putExtra("approval_attachment_customid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, (Intent)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void o()
  {
    if ((FileManagerUtil.a()) && (FMDataCache.c() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(SplashActivity.sTopActivity, 2131692609, 2131692614, new SendBottomBar.11(this));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(FMDataCache.a());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void p()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getStringExtra("posturl") != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(FMDataCache.a());
        localIntent.putParcelableArrayListExtra("fileinfo", localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void q()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i())
    {
      Object localObject2 = FMDataCache.a();
      localObject1 = FMDataCache.b();
      int j = 0;
      localObject2 = ((Set)localObject2).iterator();
      FileInfo localFileInfo;
      do
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localFileInfo = (FileInfo)((Iterator)localObject2).next();
      } while ((localFileInfo.a() <= 20971520L) || (!FMDataCache.b(localFileInfo)));
      i = 1;
      if (i != 0) {
        break label198;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).fileSize > 20971520L) && (FMDataCache.b((FileManagerEntity)localObject2))) {
          i = 1;
        }
      }
    }
    label198:
    for (;;)
    {
      if (i != 0)
      {
        FileManagerReporter.a("0X800942E");
        localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698167);
        ((QQCustomDialog)localObject1).setPositiveButton(2131720056, new SendBottomBar.12(this, k));
        ((QQCustomDialog)localObject1).show();
        return;
      }
      a(k);
      return;
      a(k);
      return;
    }
  }
  
  private void r()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject3 = FMDataCache.a();
    Object localObject1 = new ArrayList();
    localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((ArrayList)localObject1).add(((FileInfo)((Iterator)localObject3).next()).c());
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if (222 == i)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
      return;
      if ((333 == i) || (666 == i) || (3333 == i) || (6666 == i))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(i, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
      }
      else
      {
        if ((444 == i) || (555 == i))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
          if (444 == i) {}
          for (boolean bool = true;; bool = false)
          {
            ((Intent)localObject2).putExtra("_INIT_SEND_IOS_", bool);
            ((Intent)localObject2).putExtra("string_filepaths", (Serializable)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(i, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
            break;
          }
        }
        if ((777 == i) || (888 == i))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putStringArrayList("string_filepaths", (ArrayList)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink();
          QQProxyForQlink.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 16, (Bundle)localObject2);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink().a((String)localObject2, (List)localObject1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
          ((Intent)localObject1).putExtra("_UIN_", (String)localObject2);
          ((Intent)localObject1).putExtra("_SEND_QLINK_FILE_", true);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
        }
      }
    }
  }
  
  private void s()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if ((1 == i) && (!bool))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698360, 2131698359, new SendBottomBar.13(this));
      return;
    }
    r();
  }
  
  private void t()
  {
    Intent localIntent = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_b_of_type_Long != -1L)
    {
      localIntent = new Intent();
      localIntent.putExtra("qrlogin_appid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_b_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  public void a()
  {
    boolean bool2 = true;
    boolean bool1 = false;
    g();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    if (localObject1 == null) {
      if (i == 5) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697790) + this.jdField_a_of_type_AndroidContentContext.getString(2131692579) + FMDataCache.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692580);
      }
    }
    for (;;)
    {
      Object localObject2 = a();
      if (a((String)localObject2))
      {
        return;
        if (i == 6001)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692338) + this.jdField_a_of_type_AndroidContentContext.getString(2131692579) + FMDataCache.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692580);
        }
        else if (i == 10006)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694615);
        }
        else if (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694615);
          if (this.jdField_b_of_type_Long < FMDataCache.b()) {
            ReportController.b(null, "dc00898", "", "", "0X800B377", "0X800B377", 0, 0, "", "", "", "");
          }
          this.jdField_b_of_type_Long = FMDataCache.b();
        }
        else
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692407) + this.jdField_a_of_type_AndroidContentContext.getString(2131692579) + FMDataCache.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692580);
        }
      }
      else
      {
        if ((this.jdField_c_of_type_Boolean) && (!FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext)))
        {
          long l = FMDataCache.b();
          localObject1 = HardCodeUtil.a(2131713752) + l + ")";
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
          if (FMDataCache.b() > 0L) {
            bool1 = true;
          }
          ((TextView)localObject2).setEnabled(bool1);
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
        {
        default: 
          i = this.jdField_b_of_type_AndroidWidgetTextView.getVisibility();
          if ((i == 4) || (i == 8))
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
              if (FMDataCache.b() == 0L)
              {
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                if (FileManagerUtil.a() == null) {
                  break label832;
                }
                bool1 = true;
                label591:
                if (d()) {
                  bool1 = FileManagerUtil.b();
                }
                this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
                if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713738));
                }
                localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
                if (FMDataCache.b() <= 0L) {
                  break label837;
                }
              }
            }
          }
          break;
        }
        for (;;)
        {
          ((TextView)localObject1).setEnabled(bool2);
          this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(bool1);
          return;
          i = this.jdField_b_of_type_AndroidWidgetTextView.getVisibility();
          if ((i == 4) || (i == 8))
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698339);
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(9);
            this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            break;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698339);
          break;
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          break;
          this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          break;
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          break;
          label832:
          bool1 = false;
          break label591;
          label837:
          bool2 = false;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      FMToastUtil.a(2131694430);
      return;
    }
    if ((FileManagerUtil.a()) && (FMDataCache.c() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FileManagerUtil.a(true, this.jdField_a_of_type_AndroidContentContext, new SendBottomBar.14(this), paramInt);
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    float f2 = 1.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() != -1) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    label36:
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      if (paramBoolean) {
        f2 = 0.0F;
      }
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, f1, 1, f2);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(localTranslateAnimation);
      if (paramBoolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      new Handler().postDelayed(new SendBottomBar.19(this), 1500L);
      return;
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0) {
        break label36;
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    Object localObject2 = null;
    Object localObject1 = FMDataCache.a();
    ArrayList localArrayList = FMDataCache.b();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    label148:
    int i;
    if ((localObject1 != null) && (((Set)localObject1).size() > 0)) {
      if (((Set)localObject1).iterator().hasNext())
      {
        localObject1 = (FileInfo)((Set)localObject1).iterator().next();
        localTeamWorkFileImportInfo.c = ((FileInfo)localObject1).c();
        localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = ((FileInfo)localObject1).d();
        localTeamWorkFileImportInfo.e = FileManagerUtil.a(((FileInfo)localObject1).d());
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 10;
        localTeamWorkFileImportInfo.jdField_d_of_type_Long = ((FileInfo)localObject1).a();
        if ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FMActivity))) {
          break label360;
        }
        localObject1 = (FMActivity)this.jdField_a_of_type_AndroidContentContext;
        localTeamWorkFileImportInfo.g = ((FMActivity)this.jdField_a_of_type_AndroidContentContext).d;
        i = 1;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (localArrayList != null)
      {
        localObject1 = localObject2;
        if (localArrayList.size() > 0)
        {
          localObject1 = localObject2;
          if (i == 0)
          {
            localObject1 = (FileManagerEntity)localArrayList.get(0);
            localTeamWorkFileImportInfo.c = ((FileManagerEntity)localObject1).getFilePath();
            localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = ((FileManagerEntity)localObject1).fileName;
            localTeamWorkFileImportInfo.e = ((FileManagerEntity)localObject1).nFileType;
            localTeamWorkFileImportInfo.jdField_d_of_type_Long = ((FileManagerEntity)localObject1).fileSize;
            localTeamWorkFileImportInfo.jdField_d_of_type_Int = 10;
            localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = ((FileManagerEntity)localObject1).peerUin;
            localTeamWorkFileImportInfo.jdField_a_of_type_Long = ((FileManagerEntity)localObject1).uniseq;
            localTeamWorkFileImportInfo.jdField_a_of_type_Int = ((FileManagerEntity)localObject1).peerType;
            localTeamWorkFileImportInfo.jdField_b_of_type_Long = ((FileManagerEntity)localObject1).nSessionId;
            localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
            if ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FMActivity))) {
              break label446;
            }
            localObject1 = (FMActivity)this.jdField_a_of_type_AndroidContentContext;
            localTeamWorkFileImportInfo.g = ((FMActivity)this.jdField_a_of_type_AndroidContentContext).d;
          }
        }
      }
      label310:
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseFileAssistantActivity)) {}
      for (i = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext).c();; i = 0)
      {
        TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
        if (localObject1 != null) {
          ((Activity)localObject1).finish();
        }
        return;
        localObject1 = null;
        break;
        label360:
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)this.jdField_a_of_type_AndroidContentContext;
          localTeamWorkFileImportInfo.g = ((FMLocalFileActivity)this.jdField_a_of_type_AndroidContentContext).d;
          break label148;
        }
        if ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof LocalFileBrowserActivity))) {
          break label541;
        }
        localObject1 = (LocalFileBrowserActivity)this.jdField_a_of_type_AndroidContentContext;
        localTeamWorkFileImportInfo.g = ((LocalFileBrowserActivity)this.jdField_a_of_type_AndroidContentContext).d;
        break label148;
        label446:
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)this.jdField_a_of_type_AndroidContentContext;
          localTeamWorkFileImportInfo.g = ((FMLocalFileActivity)this.jdField_a_of_type_AndroidContentContext).d;
          break label310;
        }
        localObject1 = localObject2;
        if (this.jdField_a_of_type_AndroidContentContext == null) {
          break label310;
        }
        localObject1 = localObject2;
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof LocalFileBrowserActivity)) {
          break label310;
        }
        localObject1 = (LocalFileBrowserActivity)this.jdField_a_of_type_AndroidContentContext;
        localTeamWorkFileImportInfo.g = ((LocalFileBrowserActivity)this.jdField_a_of_type_AndroidContentContext).d;
        break label310;
      }
      label541:
      localObject1 = null;
      break label148;
      i = 0;
    }
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      e();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131713767));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void c()
  {
    DatalineDeviceChooseModel.a(FMDataCache.b(), FMDataCache.a()).a(this.jdField_a_of_type_AndroidContentContext, ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext).a(), new SendBottomBar.15(this));
  }
  
  public void d()
  {
    b(2131694893);
    new Handler().postDelayed(new SendBottomBar.16(this), 100L);
  }
  
  void e()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  @TargetApi(19)
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    ListView localListView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (localListView == null) {}
    while (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131381097));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(localListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    if (Build.VERSION.SDK_INT >= 24) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      return;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
  }
  
  public void i() {}
  
  public void setAttribution(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setCheckAllEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(paramBoolean);
    }
  }
  
  public void setClickListener(IClickListenerVer51 paramIClickListenerVer51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = paramIClickListenerVer51;
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && ((this.jdField_a_of_type_Boolean) || (FMDataCache.b())))
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isDebugVersion()) {
        QLog.i("TeamWorkSender", 1, "docsCheck[" + paramBoolean + "],bCheckSendToDocs[" + this.jdField_a_of_type_Boolean + "], selectAllDocs[" + FMDataCache.b() + "] ,hasSelectDocsFile[" + FMDataCache.c() + "]");
      }
      if (FMDataCache.b() != 0L) {
        break label284;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_Boolean = false;
    }
    for (this.jdField_c_of_type_Boolean = false;; this.jdField_c_of_type_Boolean = false)
    {
      label284:
      do
      {
        if ((this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          new Handler().postDelayed(new SendBottomBar.17(this), 3000L);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("_fm_select_showd", true).apply();
        if (!this.jdField_c_of_type_Boolean) {
          break label319;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setText(HardCodeUtil.a(2131713748));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new SendBottomBar.18(this));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        FileManagerReporter.a("0X800942A");
        return;
        bool = false;
        break;
      } while ((FMDataCache.b() <= 0L) || (FMDataCache.c()));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_Boolean = false;
    }
    label319:
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setEditBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      a();
      return;
    }
  }
  
  public void setOnlyDocsChecked()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void setSelectAllOrCancelAll(boolean paramBoolean)
  {
    CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(HardCodeUtil.a(2131713737));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setText(HardCodeUtil.a(2131713761));
  }
  
  public void setSelectEvent(IBaseTabViewEvent paramIBaseTabViewEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = paramIBaseTabViewEvent;
  }
  
  public void setSelectedAllMode()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    localLayoutParams.addRule(13);
    this.jdField_d_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713760));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130838979));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */