package com.tencent.mobileqq.filemanager.widget;

import alud;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
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
import aqpj;
import arbp;
import arbs;
import arre;
import arri;
import arrp;
import arrr;
import arso;
import arsq;
import arvj;
import arvl;
import arvm;
import arvn;
import arvo;
import arvp;
import arvt;
import arvy;
import arvz;
import bagk;
import bdjz;
import bety;
import bhuf;
import bhus;
import bisq;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SendBottomBar
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new arvn(this);
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqpj jdField_a_of_type_Aqpj;
  private arsq jdField_a_of_type_Arsq;
  public bdjz a;
  public bety a;
  public bhuf a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new arvo(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new arvp(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new arvt(this);
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = true;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Bhuf = null;
    this.jdField_a_of_type_Bdjz = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560663, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    h();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bhuf = null;
    this.jdField_a_of_type_Bdjz = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560663, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    h();
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
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new arvj(this));
    Object localObject = "";
    switch (i)
    {
    }
    for (;;)
    {
      localObject = arrr.a("排序方式:\n" + (String)localObject, (String)localObject, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return true;
      localObject = alud.a(2131714184);
      continue;
      localObject = alud.a(2131714193);
      continue;
      localObject = alud.a(2131714210);
    }
  }
  
  private boolean c()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (arrayOfInt == null)
    {
      this.jdField_a_of_type_Bhuf = null;
      return false;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g();
    this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null));
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int m = arrayOfInt[i];
      bhuf localbhuf;
      String str;
      boolean bool;
      switch (m)
      {
      default: 
        i += 1;
        break;
      case 1: 
        localbhuf = this.jdField_a_of_type_Bhuf;
        str = alud.a(2131714178);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbhuf.a(str, bool);
          break;
        }
      case 0: 
        localbhuf = this.jdField_a_of_type_Bhuf;
        str = alud.a(2131714194);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbhuf.a(str, bool);
          break;
        }
      case 2: 
        localbhuf = this.jdField_a_of_type_Bhuf;
        str = alud.a(2131714185);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbhuf.a(str, bool);
          break;
        }
      }
    }
    this.jdField_a_of_type_Bhuf.d(alud.a(2131714190));
    this.jdField_a_of_type_Bhuf.a(new arvm(this));
    return true;
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372248));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371216));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364240));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376385));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372245));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365389));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365390));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376361);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714188));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("_fm_select_showd", false);
  }
  
  private void i()
  {
    arrp.a("0x80087C5");
    b(2131695302);
    new Handler().postDelayed(new SendBottomBar.6(this), 100L);
  }
  
  private void j()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject3 = arbs.a();
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          bisq.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 16, (Bundle)localObject2);
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
  }
  
  private void k()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if ((1 == i) && (!bool))
    {
      arre.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698715, 2131698714, new arvy(this));
      return;
    }
    j();
  }
  
  private void l()
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
    f();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    if (localObject1 == null) {
      if (i == 5) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698217) + this.jdField_a_of_type_AndroidContentContext.getString(2131692725) + arbs.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692726);
      }
    }
    for (;;)
    {
      long l = arbs.d();
      Object localObject2 = "";
      if (l > 0L)
      {
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692544) + arso.a(l);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
      Object localObject3 = localObject2;
      if (arbs.e() > 0L)
      {
        localObject3 = localObject2;
        if (!arrr.a(this.jdField_a_of_type_AndroidContentContext)) {
          localObject3 = (String)localObject2 + this.jdField_a_of_type_AndroidContentContext.getString(2131692545) + arso.a(arbs.e());
        }
      }
      if (arrr.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131692544) + arbs.b() + alud.a(2131714187);
      }
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0))
      {
        l = arbs.b();
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        if (l > 99L) {
          localObject1 = alud.a(2131714191);
        }
        for (;;)
        {
          if (b())
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714195));
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165303);
            this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
            this.jdField_a_of_type_AndroidWidgetCheckBox.setCompoundDrawables(null, null, null, null);
            this.jdField_a_of_type_AndroidWidgetCheckBox.setTextColor(getResources().getColor(2131166910));
            this.jdField_a_of_type_AndroidWidgetCheckBox.setTextSize(1, 17.0F);
            if (l > 0L)
            {
              this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
              this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_e_of_type_AndroidWidgetTextView.setGravity(17);
              this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
              return;
              if (i == 6001)
              {
                localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692479) + this.jdField_a_of_type_AndroidContentContext.getString(2131692725) + arbs.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692726);
                break;
              }
              if (i == 10006)
              {
                localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694953);
                break;
              }
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692546) + this.jdField_a_of_type_AndroidContentContext.getString(2131692725) + arbs.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692726);
              break;
              if (l == 0L)
              {
                localObject1 = alud.a(2131714198);
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
                continue;
              }
              localObject1 = alud.a(2131714208) + String.valueOf(l) + ")";
              continue;
            }
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
            return;
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        return;
      }
      boolean bool1;
      if ((this.jdField_c_of_type_Boolean) && (!arrr.a(this.jdField_a_of_type_AndroidContentContext)))
      {
        l = arbs.b();
        localObject1 = alud.a(2131714196) + String.valueOf(l) + ")";
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (arbs.b() > 0L) {}
        for (bool1 = true;; bool1 = false)
        {
          ((TextView)localObject2).setEnabled(bool1);
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          return;
        }
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
          if (arrr.a(this.jdField_a_of_type_AndroidContentContext)) {
            if (arbs.b() == 0L)
            {
              this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              if (arrr.a() == null) {
                break label1209;
              }
              bool1 = true;
              label979:
              this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
              if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
                this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714182));
              }
              localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
              if (arbs.b() <= 0L) {
                break label1214;
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
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698694);
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698694);
        break;
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        break;
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        break;
        label1209:
        bool1 = false;
        break label979;
        label1214:
        bool2 = false;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      arri.a(2131694702);
      return;
    }
    if ((arrr.a()) && (arbs.c() > arbp.a()))
    {
      arrr.a(true, this.jdField_a_of_type_AndroidContentContext, new arvz(this), paramInt);
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
      new Handler().postDelayed(new SendBottomBar.13(this), 1500L);
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
    Object localObject1 = arbs.a();
    ArrayList localArrayList = arbs.b();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    label148:
    int i;
    if ((localObject1 != null) && (((Set)localObject1).size() > 0)) {
      if (((Set)localObject1).iterator().hasNext())
      {
        localObject1 = (FileInfo)((Set)localObject1).iterator().next();
        localTeamWorkFileImportInfo.c = ((FileInfo)localObject1).c();
        localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = ((FileInfo)localObject1).d();
        localTeamWorkFileImportInfo.e = arrr.a(((FileInfo)localObject1).d());
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 10;
        localTeamWorkFileImportInfo.jdField_d_of_type_Long = ((FileInfo)localObject1).a();
        if ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FMActivity))) {
          break label360;
        }
        localObject1 = (FMActivity)this.jdField_a_of_type_AndroidContentContext;
        localTeamWorkFileImportInfo.g = ((FMActivity)this.jdField_a_of_type_AndroidContentContext).e;
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
            localTeamWorkFileImportInfo.c = ((FileManagerEntity)localObject1).strFilePath;
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
            localTeamWorkFileImportInfo.g = ((FMActivity)this.jdField_a_of_type_AndroidContentContext).e;
          }
        }
      }
      label310:
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseFileAssistantActivity)) {}
      for (i = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext).c();; i = 0)
      {
        bagk.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
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
          localTeamWorkFileImportInfo.g = ((FMLocalFileActivity)this.jdField_a_of_type_AndroidContentContext).e;
          break label148;
        }
        if ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof LocalFileBrowserActivity))) {
          break label541;
        }
        localObject1 = (LocalFileBrowserActivity)this.jdField_a_of_type_AndroidContentContext;
        localTeamWorkFileImportInfo.g = ((LocalFileBrowserActivity)this.jdField_a_of_type_AndroidContentContext).e;
        break label148;
        label446:
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)this.jdField_a_of_type_AndroidContentContext;
          localTeamWorkFileImportInfo.g = ((FMLocalFileActivity)this.jdField_a_of_type_AndroidContentContext).e;
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
        localTeamWorkFileImportInfo.g = ((LocalFileBrowserActivity)this.jdField_a_of_type_AndroidContentContext).e;
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
    if (this.jdField_a_of_type_Bety != null) {
      d();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bety.isShowing()) {
        this.jdField_a_of_type_Bety.show();
      }
      return;
      this.jdField_a_of_type_Bety = new bety(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bety.setCancelable(false);
      this.jdField_a_of_type_Bety.a(alud.a(2131714211));
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  public void c()
  {
    b(2131695302);
    new Handler().postDelayed(new SendBottomBar.10(this), 100L);
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  @TargetApi(19)
  protected void f()
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131379475));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(localListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
  }
  
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
  
  public void setClickListener(arsq paramarsq)
  {
    this.jdField_a_of_type_Arsq = paramarsq;
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && ((this.jdField_a_of_type_Boolean) || (arbs.b())))
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isDebugVersion()) {
        QLog.i("TeamWorkSender", 1, "docsCheck[" + paramBoolean + "],bCheckSendToDocs[" + this.jdField_a_of_type_Boolean + "], selectAllDocs[" + arbs.b() + "] ,hasSelectDocsFile[" + arbs.c() + "]");
      }
      if (arbs.b() != 0L) {
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
          new Handler().postDelayed(new SendBottomBar.11(this), 3000L);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("_fm_select_showd", true).apply();
        if (!this.jdField_c_of_type_Boolean) {
          break label319;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setText(alud.a(2131714192));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new arvl(this));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        arrp.a("0X800942A");
        return;
        bool = false;
        break;
      } while ((arbs.b() <= 0L) || (arbs.c()));
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
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(alud.a(2131714181));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setText(alud.a(2131714205));
  }
  
  public void setSelectEvent(aqpj paramaqpj)
  {
    this.jdField_a_of_type_Aqpj = paramaqpj;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714204));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130838592));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */