package com.tencent.mobileqq.filemanager.widget;

import adrk;
import adrl;
import adrm;
import adrp;
import adrr;
import adrv;
import adrw;
import adrx;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.qlink.QQProxyForQlink;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SendBottomBar
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adrk(this);
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private IBaseTabViewEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent;
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  public QQCustomDialog a;
  public QQProgressDialog a;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new adrl(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new adrm(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new adrr(this);
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130970038, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    e();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130970038, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368817));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368818));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131368816));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364132));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363530));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("确定");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
  }
  
  private void f()
  {
    FileManagerReporter.a("0x80087C5");
    a(2131436164);
    new Handler().postDelayed(new adrp(this), 100L);
  }
  
  private void g()
  {
    boolean bool = false;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    ArrayList localArrayList = FMDataCache.b();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < localArrayList.size())
    {
      ((ArrayList)localObject1).add(((FileInfo)localArrayList.get(i)).c());
      i += 1;
    }
    i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    if (222 == i)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
      return;
      if ((333 == i) || (666 == i))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(i, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
      }
      else if ((444 == i) || (555 == i))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
        if (444 == i) {
          bool = true;
        }
        ((Intent)localObject2).putExtra("_INIT_SEND_IOS_", bool);
        ((Intent)localObject2).putExtra("string_filepaths", (Serializable)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(i, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
      }
      else if ((777 == i) || (888 == i))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("string_filepaths", (ArrayList)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        QQProxyForQlink.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 16, (Bundle)localObject2);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, (List)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
        ((Intent)localObject1).putExtra("_UIN_", (String)localObject2);
        ((Intent)localObject1).putExtra("_SEND_QLINK_FILE_", true);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
      }
    }
  }
  
  private void h()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if ((1 == i) && (!bool))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131431856, 2131431857, new adrv(this));
      return;
    }
    g();
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  public void a()
  {
    boolean bool2 = true;
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    if (localObject1 == null) {
      if (i == 5) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131429698) + this.jdField_a_of_type_AndroidContentContext.getString(2131428244) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131428245);
      }
    }
    for (;;)
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131428133) + FileUtil.a(FMDataCache.c());
      Object localObject2 = str;
      if (FMDataCache.d() > 0L) {
        localObject2 = str + this.jdField_a_of_type_AndroidContentContext.getString(2131428134) + FileUtil.a(FMDataCache.d());
      }
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0)
      {
        long l = FMDataCache.a();
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        if (l > 99L) {
          localObject1 = "删除(99+)";
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          return;
          if (i == 6001)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131428129) + this.jdField_a_of_type_AndroidContentContext.getString(2131428244) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131428245);
            break;
          }
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131428124) + this.jdField_a_of_type_AndroidContentContext.getString(2131428244) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131428245);
          break;
          if (l == 0L)
          {
            localObject1 = "删除";
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          else
          {
            localObject1 = "删除(" + String.valueOf(l) + ")";
          }
        }
      }
      boolean bool1;
      switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
      {
      default: 
        i = this.jdField_b_of_type_AndroidWidgetTextView.getVisibility();
        if ((i == 4) || (i == 8))
        {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          if (FileManagerUtil.a() == null) {
            break label707;
          }
          bool1 = true;
          label513:
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText("确定");
          }
          localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
          if (FMDataCache.a() <= 0L) {
            break label712;
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
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131431855);
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131431855);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        break;
        label707:
        bool1 = false;
        break label513;
        label712:
        bool2 = false;
      }
    }
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      d();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131558448));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("请稍候...");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void b()
  {
    if ((FileManagerUtil.a()) && (FMDataCache.b() > FMConfig.a()))
    {
      FileManagerUtil.a(true, this.jdField_a_of_type_AndroidContentContext, new adrw(this));
      return;
    }
    c();
  }
  
  public void c()
  {
    a(2131436164);
    new Handler().postDelayed(new adrx(this), 100L);
  }
  
  public void d()
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
  
  public void setCheckAll(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setText("取消全选");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setText("全选");
  }
  
  public void setCheckAllEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(paramBoolean);
    }
  }
  
  public void setClickListener(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
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
  
  public void setSelectEvent(IBaseTabViewEvent paramIBaseTabViewEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = paramIBaseTabViewEvent;
  }
  
  public void setSelectedAllMode()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(1, this.jdField_a_of_type_AndroidWidgetCheckBox.getId());
    localLayoutParams.addRule(0, this.jdField_a_of_type_AndroidWidgetTextView.getId());
    localLayoutParams.addRule(13);
    this.jdField_d_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("删除");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */