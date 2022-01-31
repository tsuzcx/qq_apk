package com.tencent.mobileqq.filemanager.widget;

import ajjy;
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
import aobe;
import aonj;
import aonm;
import apbx;
import apcb;
import apci;
import apck;
import apdh;
import apdj;
import apft;
import apfv;
import apfw;
import apfx;
import apfy;
import apfz;
import apgd;
import apgi;
import apgj;
import axea;
import bafb;
import bbms;
import begr;
import behe;
import bffc;
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
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new apfx(this);
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aobe jdField_a_of_type_Aobe;
  private apdj jdField_a_of_type_Apdj;
  public bafb a;
  public bbms a;
  public begr a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new apfy(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new apfz(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new apgd(this);
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = true;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Begr = null;
    this.jdField_a_of_type_Bafb = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131494898, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    h();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Begr = null;
    this.jdField_a_of_type_Bafb = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131494898, this, true);
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
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new apft(this));
    Object localObject = "";
    switch (i)
    {
    }
    for (;;)
    {
      localObject = apck.a("排序方式:\n" + (String)localObject, (String)localObject, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return true;
      localObject = ajjy.a(2131648002);
      continue;
      localObject = ajjy.a(2131648011);
      continue;
      localObject = ajjy.a(2131648028);
    }
  }
  
  private boolean c()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (arrayOfInt == null)
    {
      this.jdField_a_of_type_Begr = null;
      return false;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g();
    this.jdField_a_of_type_Begr = ((begr)behe.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null));
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int m = arrayOfInt[i];
      begr localbegr;
      String str;
      boolean bool;
      switch (m)
      {
      default: 
        i += 1;
        break;
      case 1: 
        localbegr = this.jdField_a_of_type_Begr;
        str = ajjy.a(2131647996);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbegr.a(str, bool);
          break;
        }
      case 0: 
        localbegr = this.jdField_a_of_type_Begr;
        str = ajjy.a(2131648012);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbegr.a(str, bool);
          break;
        }
      case 2: 
        localbegr = this.jdField_a_of_type_Begr;
        str = ajjy.a(2131648003);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbegr.a(str, bool);
          break;
        }
      }
    }
    this.jdField_a_of_type_Begr.d(ajjy.a(2131648008));
    this.jdField_a_of_type_Begr.a(new apfw(this));
    return true;
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131306212));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305215));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298619));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131310066));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131306209));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131299735));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299736));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131310043);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648006));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("_fm_select_showd", false);
  }
  
  private void i()
  {
    apci.a("0x80087C5");
    b(2131629460);
    new Handler().postDelayed(new SendBottomBar.6(this), 100L);
  }
  
  private void j()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject3 = aonm.a();
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
          bffc.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 16, (Bundle)localObject2);
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
      apbx.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131632667, 2131632666, new apgi(this));
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
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632302) + this.jdField_a_of_type_AndroidContentContext.getString(2131627006) + aonm.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131627007);
      }
    }
    for (;;)
    {
      long l = aonm.d();
      Object localObject2 = "";
      if (l > 0L)
      {
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131626853) + apdh.a(l);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
      Object localObject3 = localObject2;
      if (aonm.e() > 0L)
      {
        localObject3 = localObject2;
        if (!apck.a(this.jdField_a_of_type_AndroidContentContext)) {
          localObject3 = (String)localObject2 + this.jdField_a_of_type_AndroidContentContext.getString(2131626854) + apdh.a(aonm.e());
        }
      }
      if (apck.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131626853) + aonm.b() + ajjy.a(2131648005);
      }
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0))
      {
        l = aonm.b();
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        if (l > 99L) {
          localObject1 = ajjy.a(2131648009);
        }
        for (;;)
        {
          if (b())
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648013));
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131099734);
            this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
            this.jdField_a_of_type_AndroidWidgetCheckBox.setCompoundDrawables(null, null, null, null);
            this.jdField_a_of_type_AndroidWidgetCheckBox.setTextColor(getResources().getColor(2131101267));
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
                localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626801) + this.jdField_a_of_type_AndroidContentContext.getString(2131627006) + aonm.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131627007);
                break;
              }
              if (i == 10006)
              {
                localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131629116);
                break;
              }
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131626855) + this.jdField_a_of_type_AndroidContentContext.getString(2131627006) + aonm.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131627007);
              break;
              if (l == 0L)
              {
                localObject1 = ajjy.a(2131648016);
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
                continue;
              }
              localObject1 = ajjy.a(2131648026) + String.valueOf(l) + ")";
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
      if ((this.jdField_c_of_type_Boolean) && (!apck.a(this.jdField_a_of_type_AndroidContentContext)))
      {
        l = aonm.b();
        localObject1 = ajjy.a(2131648014) + String.valueOf(l) + ")";
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (aonm.b() > 0L) {}
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
          if (apck.a(this.jdField_a_of_type_AndroidContentContext)) {
            if (aonm.b() == 0L)
            {
              this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              if (apck.a() == null) {
                break label1209;
              }
              bool1 = true;
              label979:
              this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
              if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
                this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648000));
              }
              localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
              if (aonm.b() <= 0L) {
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
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131632646);
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131632646);
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
      apcb.a(2131628882);
      return;
    }
    if ((apck.a()) && (aonm.c() > aonj.a()))
    {
      apck.a(true, this.jdField_a_of_type_AndroidContentContext, new apgj(this), paramInt);
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
    Object localObject1 = aonm.a();
    ArrayList localArrayList = aonm.b();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    label148:
    int i;
    if ((localObject1 != null) && (((Set)localObject1).size() > 0)) {
      if (((Set)localObject1).iterator().hasNext())
      {
        localObject1 = (FileInfo)((Set)localObject1).iterator().next();
        localTeamWorkFileImportInfo.c = ((FileInfo)localObject1).c();
        localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = ((FileInfo)localObject1).d();
        localTeamWorkFileImportInfo.e = apck.a(((FileInfo)localObject1).d());
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
        axea.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
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
    if (this.jdField_a_of_type_Bbms != null) {
      d();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bbms.isShowing()) {
        this.jdField_a_of_type_Bbms.show();
      }
      return;
      this.jdField_a_of_type_Bbms = new bbms(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131167766));
      this.jdField_a_of_type_Bbms.setCancelable(false);
      this.jdField_a_of_type_Bbms.a(ajjy.a(2131648029));
      this.jdField_a_of_type_Bbms.show();
    }
  }
  
  public void c()
  {
    b(2131629460);
    new Handler().postDelayed(new SendBottomBar.10(this), 100L);
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
        this.jdField_a_of_type_Bbms.cancel();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131312968));
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
  
  public void setClickListener(apdj paramapdj)
  {
    this.jdField_a_of_type_Apdj = paramapdj;
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && ((this.jdField_a_of_type_Boolean) || (aonm.b())))
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isDebugVersion()) {
        QLog.i("TeamWorkSender", 1, "docsCheck[" + paramBoolean + "],bCheckSendToDocs[" + this.jdField_a_of_type_Boolean + "], selectAllDocs[" + aonm.b() + "] ,hasSelectDocsFile[" + aonm.c() + "]");
      }
      if (aonm.b() != 0L) {
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
        this.jdField_a_of_type_AndroidWidgetCheckBox.setText(ajjy.a(2131648010));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new apfv(this));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        apci.a("0X800942A");
        return;
        bool = false;
        break;
      } while ((aonm.b() <= 0L) || (aonm.c()));
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
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(ajjy.a(2131647999));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setText(ajjy.a(2131648023));
  }
  
  public void setSelectEvent(aobe paramaobe)
  {
    this.jdField_a_of_type_Aobe = paramaobe;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648022));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130838503));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */