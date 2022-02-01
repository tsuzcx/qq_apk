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
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

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
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = null;
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560799, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    j();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560799, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    j();
  }
  
  private FileManagerEntity a()
  {
    Object localObject3 = FMDataCache.b();
    Object localObject2 = FMDataCache.a();
    Object localObject1 = FMDataCache.d();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((Set)localObject2).size() > 0))
    {
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).a() == 0) {
          return QQFileManagerUtil.a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (QQFileManagerUtil.b(((WeiYunFileInfo)localObject2).c) == 0) {
          return QQFileManagerUtil.a((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  private String a()
  {
    long l = FMDataCache.d();
    Object localObject1;
    if (l > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692333));
      ((StringBuilder)localObject1).append(FileUtil.a(l));
      localObject1 = ((StringBuilder)localObject1).toString();
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (FMDataCache.e() > 0L)
    {
      localObject2 = localObject1;
      if (!QQFileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692334));
        ((StringBuilder)localObject2).append(FileUtil.a(FMDataCache.e()));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    if (QQFileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692333));
      ((StringBuilder)localObject1).append(FMDataCache.b());
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131698176));
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    return localObject2;
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
        localObject = HardCodeUtil.a(2131698182);
      }
      else if (l == 0L)
      {
        localObject = HardCodeUtil.a(2131698177);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131698183));
        ((StringBuilder)localObject).append(String.valueOf(l));
        ((StringBuilder)localObject).append(")");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (c())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131698177));
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165308);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setCompoundDrawables(null, null, null, null);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTextColor(getResources().getColor(2131167063));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTextSize(1, 17.0F);
        if (l > 0L)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setGravity(17);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          return true;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        return true;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      return true;
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      long l = FMDataCache.c();
      boolean bool = false;
      if (l > 104857600L) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_b_of_type_Boolean))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_b_of_type_Boolean) {
          paramBoolean = bool;
        }
        localObject1 = (IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
        if (((IQQFileTempUtils)localObject1).handleVipForTroopFile((Context)localObject2, ((BaseFileAssistantActivity)localObject2).jdField_a_of_type_Boolean, paramBoolean, new SendBottomBar.8(this))) {
          return;
        }
      }
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      FMToastUtil.a(2131698210);
      c();
      return;
    }
    if (QQFileManagerUtil.a())
    {
      if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi((Activity)this.jdField_a_of_type_AndroidContentContext, new SendBottomBar.9(this)))
      {
        localObject2 = new SendBottomBar.10(this);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698219);
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        localObject2 = DialogUtil.a(localContext, 230, localContext.getString(2131698209), (String)localObject1, 2131690728, 2131698235, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2);
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).changeKingCardWording((QQCustomDialog)localObject2, this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject1);
        ((QQCustomDialog)localObject2).show();
      }
    }
    else {
      c();
    }
  }
  
  private boolean b()
  {
    Object localObject = FMDataCache.e();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (QQFileManagerUtil.b(((FavFileInfo)((Iterator)localObject).next()).c) == 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g();
    if (i == -1) {
      return false;
    }
    if (!d()) {
      return false;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new SendBottomBar.5(this));
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          localObject = "";
        } else {
          localObject = HardCodeUtil.a(2131698233);
        }
      }
      else {
        localObject = HardCodeUtil.a(2131698227);
      }
    }
    else {
      localObject = HardCodeUtil.a(2131698232);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("排序方式:\n");
    localStringBuilder.append((String)localObject);
    Object localObject = QQFileManagerUtil.a(localStringBuilder.toString(), (String)localObject, null);
    this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    return true;
  }
  
  private boolean d()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (arrayOfInt == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
      return false;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    int k = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool2 = true;
      boolean bool3 = true;
      boolean bool1 = true;
      if (i >= k) {
        break;
      }
      int m = arrayOfInt[i];
      ActionSheet localActionSheet;
      String str;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m == 2)
          {
            localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
            str = HardCodeUtil.a(2131692345);
            if (j != m) {
              bool1 = false;
            }
            localActionSheet.addRadioButton(str, bool1);
          }
        }
        else
        {
          localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
          str = HardCodeUtil.a(2131692343);
          if (j == m) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          localActionSheet.addRadioButton(str, bool1);
        }
      }
      else
      {
        localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
        str = HardCodeUtil.a(2131692344);
        if (j == m) {
          bool1 = bool3;
        } else {
          bool1 = false;
        }
        localActionSheet.addRadioButton(str, bool1);
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(HardCodeUtil.a(2131692263));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListenerV2(new SendBottomBar.6(this));
    return true;
  }
  
  private boolean e()
  {
    BaseFileAssistantActivity localBaseFileAssistantActivity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBaseFileAssistantActivity != null)
    {
      bool1 = bool2;
      if ((localBaseFileAssistantActivity instanceof FMActivity))
      {
        bool1 = bool2;
        if (((FMActivity)localBaseFileAssistantActivity).i() == 1201) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373034));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371932));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364593));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377187));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373031));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365794));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365795));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377162);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) || (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131698175));
    }
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = ((BaseQQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getPreferences().getBoolean("_fm_select_showd", false);
  }
  
  private void k()
  {
    FileManagerReporter.a("0x80087C5");
    b(2131698226);
    new Handler().postDelayed(new SendBottomBar.7(this), 100L);
  }
  
  private void l()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    int i = 1;
    if (j == 1) {
      i = 2;
    } else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a() != 0) {
      i = 4;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(AppConstants.DATALINE_PC_UIN))) {
      i = 3;
    }
    long l = FMDataCache.b();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(l);
    ReportController.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, ((StringBuilder)localObject).toString(), "0", "", "");
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
          localObject4 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favUtilhandleFileEntry(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, null, ((FileInfo)localObject4).c(), true);
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
          localObject3 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favUtilhandleFileEntry(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (FileManagerEntity)localObject3, "", false);
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
          localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
          localObject2 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favUtilhandleWeiyunFile((WeiYunFileInfo)localObject2);
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
    if ((QQFileManagerUtil.a()) && (FMDataCache.c() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698196, 2131692566, new SendBottomBar.11(this));
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
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
    }
  }
  
  private void q()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i())
    {
      Object localObject2 = FMDataCache.a();
      Object localObject1 = FMDataCache.b();
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
      int i = 1;
      j = i;
      if (i == 0)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        do
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        } while ((((FileManagerEntity)localObject2).fileSize <= 20971520L) || (!FMDataCache.b((FileManagerEntity)localObject2)));
        j = 1;
      }
      if (j != 0)
      {
        FileManagerReporter.a("0X800942E");
        localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698223);
        ((QQCustomDialog)localObject1).setPositiveButton(2131719788, new SendBottomBar.12(this, k));
        ((QQCustomDialog)localObject1).show();
        return;
      }
      a(k);
      return;
    }
    a(k);
  }
  
  private void r()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject = FMDataCache.a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((FileInfo)((Iterator)localObject).next()).c());
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendQlinkFiles(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, str, localArrayList, i);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void s()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if ((1 == i) && (!bool))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698425, 2131698424, new SendBottomBar.13(this));
      return;
    }
    r();
  }
  
  private void t()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_b_of_type_Long != -1L)
    {
      localIntent = new Intent();
      localIntent.putExtra("qrlogin_appid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_b_of_type_Long);
    }
    else
    {
      localIntent = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  public void a()
  {
    g();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      if (i == 5)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698234));
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692531));
        ((StringBuilder)localObject1).append(FMDataCache.b());
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692532));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (i == 6001)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698165));
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692531));
        ((StringBuilder)localObject1).append(FMDataCache.b());
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692532));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (i == 10006)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694583);
      }
      else if (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694583);
        if (this.jdField_b_of_type_Long < FMDataCache.b()) {
          ReportController.b(null, "dc00898", "", "", "0X800B377", "0X800B377", 0, 0, "", "", "", "");
        }
        this.jdField_b_of_type_Long = FMDataCache.b();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131698218));
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692531));
        ((StringBuilder)localObject1).append(FMDataCache.b());
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692532));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localObject2 = a();
    if (a((String)localObject2)) {
      return;
    }
    boolean bool3 = this.jdField_c_of_type_Boolean;
    boolean bool2 = true;
    boolean bool1 = true;
    if ((bool3) && (!QQFileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext)))
    {
      long l = FMDataCache.b();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131698221));
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(")");
      localObject1 = ((StringBuilder)localObject1).toString();
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (FMDataCache.b() <= 0L) {
        bool1 = false;
      }
      ((TextView)localObject2).setEnabled(bool1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b() != 1)
    {
      i = this.jdField_b_of_type_AndroidWidgetTextView.getVisibility();
      if ((i != 4) && (i != 8))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (QQFileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext))
        {
          if (FMDataCache.b() == 0L)
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          else
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          }
        }
        else {
          this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        }
      }
    }
    else
    {
      i = this.jdField_b_of_type_AndroidWidgetTextView.getVisibility();
      if ((i != 4) && (i != 8))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698290);
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698290);
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(9);
        this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    if (a() != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (e()) {
      bool1 = b();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131698175));
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (FMDataCache.b() <= 0L) {
      bool2 = false;
    }
    ((TextView)localObject1).setEnabled(bool2);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(bool1);
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      FMToastUtil.a(2131698210);
      return;
    }
    if ((QQFileManagerUtil.a()) && (FMDataCache.c() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      QQFileManagerUtil.a(true, this.jdField_a_of_type_AndroidContentContext, new SendBottomBar.14(this), paramInt);
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() != -1) {
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    else if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0)
    {
      return;
    }
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramBoolean) {
      f2 = 0.0F;
    } else {
      f2 = 1.0F;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, f1, 1, f2);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(localTranslateAnimation);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      new Handler().postDelayed(new SendBottomBar.19(this), 1500L);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    Object localObject4 = FMDataCache.a();
    Object localObject3 = FMDataCache.b();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 0;
    if ((localObject4 != null) && (((Set)localObject4).size() > 0))
    {
      if (((Set)localObject4).iterator().hasNext()) {
        localObject1 = (FileInfo)((Set)localObject4).iterator().next();
      } else {
        localObject1 = null;
      }
      localTeamWorkFileImportInfo.c = ((FileInfo)localObject1).c();
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = ((FileInfo)localObject1).d();
      localTeamWorkFileImportInfo.e = QQFileManagerUtil.b(((FileInfo)localObject1).d());
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = 10;
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = ((FileInfo)localObject1).a();
      localObject4 = this.jdField_a_of_type_AndroidContentContext;
      if ((localObject4 != null) && ((localObject4 instanceof FMActivity)))
      {
        localObject1 = (FMActivity)localObject4;
        localTeamWorkFileImportInfo.g = ((FMActivity)localObject4).d;
      }
      else
      {
        localObject4 = this.jdField_a_of_type_AndroidContentContext;
        if ((localObject4 != null) && ((localObject4 instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)localObject4;
          localTeamWorkFileImportInfo.g = ((FMLocalFileActivity)localObject4).d;
        }
        else
        {
          localObject4 = this.jdField_a_of_type_AndroidContentContext;
          localObject1 = localObject2;
          if (localObject4 != null)
          {
            localObject1 = localObject2;
            if ((localObject4 instanceof LocalFileBrowserActivity))
            {
              localObject1 = (LocalFileBrowserActivity)localObject4;
              localTeamWorkFileImportInfo.g = ((LocalFileBrowserActivity)localObject4).d;
            }
          }
        }
      }
      i = 1;
      localObject2 = localObject1;
    }
    else
    {
      i = 0;
      localObject2 = localObject1;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((ArrayList)localObject3).size() > 0)
      {
        localObject1 = localObject2;
        if (i == 0)
        {
          localObject1 = (FileManagerEntity)((ArrayList)localObject3).get(0);
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
          localObject3 = this.jdField_a_of_type_AndroidContentContext;
          if ((localObject3 != null) && ((localObject3 instanceof FMActivity)))
          {
            localObject1 = (FMActivity)localObject3;
            localTeamWorkFileImportInfo.g = ((FMActivity)localObject3).d;
          }
          else
          {
            localObject3 = this.jdField_a_of_type_AndroidContentContext;
            if ((localObject3 != null) && ((localObject3 instanceof FMLocalFileActivity)))
            {
              localObject1 = (FMLocalFileActivity)localObject3;
              localTeamWorkFileImportInfo.g = ((FMLocalFileActivity)localObject3).d;
            }
            else
            {
              localObject3 = this.jdField_a_of_type_AndroidContentContext;
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if ((localObject3 instanceof LocalFileBrowserActivity))
                {
                  localObject1 = (LocalFileBrowserActivity)localObject3;
                  localTeamWorkFileImportInfo.g = ((LocalFileBrowserActivity)localObject3).d;
                }
              }
            }
          }
        }
      }
    }
    localObject2 = this.jdField_a_of_type_AndroidContentContext;
    int i = j;
    if ((localObject2 instanceof BaseFileAssistantActivity)) {
      i = ((BaseFileAssistantActivity)localObject2).c();
    }
    TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, i);
    if (localObject1 != null) {
      ((Activity)localObject1).finish();
    }
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      e();
    }
    else
    {
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localContext, localContext.getResources().getDimensionPixelSize(2131299168));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131698236));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void c()
  {
    ArrayList localArrayList = FMDataCache.b();
    Set localSet = FMDataCache.a();
    String str = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext).a();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).showDeviceChoose(this.jdField_a_of_type_AndroidContentContext, str, localArrayList, localSet, new SendBottomBar.15(this));
  }
  
  public void d()
  {
    b(2131694882);
    new Handler().postDelayed(new SendBottomBar.16(this), 100L);
  }
  
  void e()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  @TargetApi(19)
  protected void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (localObject == null) {
      return;
    }
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131380356));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a((View)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    ((QQBlurView)localObject).b((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setEnableBlur(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
  }
  
  public void h()
  {
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localQQBlurView != null) {
      localQQBlurView.c();
    }
  }
  
  public void i() {}
  
  public void setAttribution(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setCheckAllEnable(boolean paramBoolean)
  {
    CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (localCheckBox != null) {
      localCheckBox.setEnabled(paramBoolean);
    }
  }
  
  public void setClickListener(IClickListenerVer51 paramIClickListenerVer51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = paramIClickListenerVer51;
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && ((this.jdField_a_of_type_Boolean) || (FMDataCache.b()))) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("docsCheck[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("],bCheckSendToDocs[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("], selectAllDocs[");
      localStringBuilder.append(FMDataCache.b());
      localStringBuilder.append("] ,hasSelectDocsFile[");
      localStringBuilder.append(FMDataCache.c());
      localStringBuilder.append("]");
      QLog.i("TeamWorkSender", 1, localStringBuilder.toString());
    }
    if (FMDataCache.b() == 0L)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
    }
    else if ((FMDataCache.b() > 0L) && (!FMDataCache.c()))
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
    }
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      new Handler().postDelayed(new SendBottomBar.17(this), 3000L);
    }
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getPreferences().edit().putBoolean("_fm_select_showd", true).apply();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(HardCodeUtil.a(2131698220));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new SendBottomBar.18(this));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      FileManagerReporter.a("0X800942A");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setEditBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    a();
  }
  
  public void setOnlyDocsChecked()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void setSelectAllOrCancelAll(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean ^ true);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(HardCodeUtil.a(2131698216));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setText(HardCodeUtil.a(2131698167));
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131692543));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130838739));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */