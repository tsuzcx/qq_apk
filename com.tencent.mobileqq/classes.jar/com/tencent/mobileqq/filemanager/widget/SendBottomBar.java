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
import anvx;
import arjm;
import arjn;
import arjp;
import arln;
import arlt;
import atdd;
import atpj;
import atpm;
import audn;
import audr;
import audy;
import auea;
import auex;
import augk;
import augl;
import augm;
import augn;
import augo;
import augp;
import augr;
import augs;
import augt;
import augw;
import augx;
import augy;
import auha;
import bdla;
import beaz;
import bgjc;
import bgke;
import bhdj;
import bhzh;
import bisl;
import bixr;
import bkzi;
import bkzz;
import blyb;
import bmar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
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
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new augk(this);
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atdd jdField_a_of_type_Atdd;
  private auex jdField_a_of_type_Auex;
  public bisl a;
  public bkzi a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  public QQCustomDialog a;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new augs(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new augt(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new augw(this);
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = true;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Bkzi = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560834, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    i();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bkzi = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560834, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    i();
  }
  
  @NotNull
  private String a()
  {
    long l = atpm.d();
    String str1 = "";
    if (l > 0L)
    {
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692273) + FileUtil.filesizeToString(l);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
    String str2 = str1;
    if (atpm.e() > 0L)
    {
      str2 = str1;
      if (!auea.a(this.jdField_a_of_type_AndroidContentContext)) {
        str2 = str1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692274) + FileUtil.filesizeToString(atpm.e());
      }
    }
    if (auea.a(this.jdField_a_of_type_AndroidContentContext)) {
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692273) + atpm.b() + anvx.a(2131713247);
    }
    return str2;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0))
    {
      long l = atpm.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      Object localObject;
      if (l > 99L)
      {
        localObject = anvx.a(2131713251);
        if (!b()) {
          break label272;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713255));
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165342);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setCompoundDrawables(null, null, null, null);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTextColor(getResources().getColor(2131167033));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTextSize(1, 17.0F);
        if (l <= 0L) {
          break label260;
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
          localObject = anvx.a(2131713258);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          break;
        }
        localObject = anvx.a(2131713268) + String.valueOf(l) + ")";
        break;
        label260:
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        continue;
        label272:
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
      if (atpm.c() > 104857600L)
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
      Object localObject1 = arlt.c();
      if (((arln)localObject1).a())
      {
        localObject2 = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        if (!((arln)localObject1).a(this.jdField_a_of_type_AndroidContentContext, new SendBottomBar.8(this), paramBoolean, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_a_of_type_Boolean)) {}
      }
      label104:
      do
      {
        return;
        paramBoolean = false;
        break;
        if (bgke.a(this.jdField_a_of_type_AndroidContentContext) == 0)
        {
          bgjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697356));
          c();
          return;
        }
        if (!auea.a()) {
          break label265;
        }
      } while (!bixr.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new auha(this)));
      Object localObject2 = new augl(this);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697130);
      localObject2 = bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697353), (String)localObject1, 2131690697, 2131697549, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2);
      if ((arjp.c().b.jdField_a_of_type_Boolean) && (!bhzh.a().b())) {
        ((QQCustomDialog)localObject2).setMessageWithoutAutoLink(arjp.c().b.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject1));
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
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new augx(this));
    Object localObject = "";
    switch (i)
    {
    }
    for (;;)
    {
      localObject = auea.a("排序方式:\n" + (String)localObject, (String)localObject, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return true;
      localObject = anvx.a(2131713244);
      continue;
      localObject = anvx.a(2131713253);
      continue;
      localObject = anvx.a(2131713270);
    }
  }
  
  private boolean c()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (arrayOfInt == null)
    {
      this.jdField_a_of_type_Bkzi = null;
      return false;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g();
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null));
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int m = arrayOfInt[i];
      bkzi localbkzi;
      String str;
      boolean bool;
      switch (m)
      {
      default: 
        i += 1;
        break;
      case 1: 
        localbkzi = this.jdField_a_of_type_Bkzi;
        str = anvx.a(2131713238);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbkzi.a(str, bool);
          break;
        }
      case 0: 
        localbkzi = this.jdField_a_of_type_Bkzi;
        str = anvx.a(2131713254);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbkzi.a(str, bool);
          break;
        }
      case 2: 
        localbkzi = this.jdField_a_of_type_Bkzi;
        str = anvx.a(2131713245);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbkzi.a(str, bool);
          break;
        }
      }
    }
    this.jdField_a_of_type_Bkzi.d(anvx.a(2131713250));
    this.jdField_a_of_type_Bkzi.a(new augy(this));
    return true;
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity instanceof FMActivity))) {
      return ((FMActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity).i() == 1201;
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373131));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372043));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364592));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377339));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373128));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365794));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365795));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377313);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) || (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713248));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("_fm_select_showd", false);
  }
  
  private void j()
  {
    audy.a("0x80087C5");
    b(2131694656);
    new Handler().postDelayed(new SendBottomBar.7(this), 100L);
  }
  
  private void k()
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
      long l = atpm.b();
      bdla.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a() == 0) {
        break;
      }
      i = 4;
      break;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(atpm.a());
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("reslut_select_file_info_list", localArrayList);
      localIntent.putExtra("approval_attachment_customid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void m()
  {
    bdla.b(null, "dc00898", "", "", "0X800B378", "0X800B378", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c())
    {
      Object localObject2 = atpm.b();
      Object localObject1 = atpm.d();
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = new ArrayList();
      ((ArrayList)localObject3).addAll(atpm.a());
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (FileInfo)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject4 = bmar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, ((FileInfo)localObject4).c(), true);
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
          localObject3 = bmar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject3, "", false);
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
          localObject2 = bmar.a((WeiYunFileInfo)((Iterator)localObject1).next());
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
  
  private void n()
  {
    if ((auea.a()) && (atpm.c() > atpj.a()))
    {
      audn.a(SplashActivity.sTopActivity, 2131692476, 2131692481, new augm(this));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(atpm.a());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void o()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getStringExtra("posturl") != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(atpm.a());
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
  
  private void p()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i())
    {
      Object localObject2 = atpm.a();
      localObject1 = atpm.b();
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
      } while ((localFileInfo.a() <= 20971520L) || (!atpm.b(localFileInfo)));
      i = 1;
      if (i != 0) {
        break label198;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).fileSize > 20971520L) && (atpm.b((FileManagerEntity)localObject2))) {
          i = 1;
        }
      }
    }
    label198:
    for (;;)
    {
      if (i != 0)
      {
        audy.a("0X800942E");
        localObject1 = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697910);
        ((QQCustomDialog)localObject1).setPositiveButton(2131719492, new augn(this, k));
        ((QQCustomDialog)localObject1).show();
        return;
      }
      a(k);
      return;
      a(k);
      return;
    }
  }
  
  private void q()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject3 = atpm.a();
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
          blyb.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 16, (Bundle)localObject2);
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
  
  private void r()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if ((1 == i) && (!bool))
    {
      audn.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698084, 2131698083, new augo(this));
      return;
    }
    q();
  }
  
  private void s()
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
    f();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    if (localObject1 == null) {
      if (i == 5) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697536) + this.jdField_a_of_type_AndroidContentContext.getString(2131692446) + atpm.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692447);
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
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692206) + this.jdField_a_of_type_AndroidContentContext.getString(2131692446) + atpm.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692447);
        }
        else if (i == 10006)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694399);
        }
        else if (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694399);
          if (this.jdField_b_of_type_Long < atpm.b()) {
            bdla.b(null, "dc00898", "", "", "0X800B377", "0X800B377", 0, 0, "", "", "", "");
          }
          this.jdField_b_of_type_Long = atpm.b();
        }
        else
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692275) + this.jdField_a_of_type_AndroidContentContext.getString(2131692446) + atpm.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692447);
        }
      }
      else
      {
        if ((this.jdField_c_of_type_Boolean) && (!auea.a(this.jdField_a_of_type_AndroidContentContext)))
        {
          long l = atpm.b();
          localObject1 = anvx.a(2131713256) + l + ")";
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
          if (atpm.b() > 0L) {
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
            if (auea.a(this.jdField_a_of_type_AndroidContentContext)) {
              if (atpm.b() == 0L)
              {
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                if (auea.a() == null) {
                  break label832;
                }
                bool1 = true;
                label591:
                if (d()) {
                  bool1 = auea.b();
                }
                this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
                if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713242));
                }
                localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
                if (atpm.b() <= 0L) {
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
            this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698063);
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(9);
            this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            break;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698063);
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
      audr.a(2131694226);
      return;
    }
    if ((auea.a()) && (atpm.c() > atpj.a()))
    {
      auea.a(true, this.jdField_a_of_type_AndroidContentContext, new augp(this), paramInt);
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
      new Handler().postDelayed(new SendBottomBar.18(this), 1500L);
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
    Object localObject1 = atpm.a();
    ArrayList localArrayList = atpm.b();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    label148:
    int i;
    if ((localObject1 != null) && (((Set)localObject1).size() > 0)) {
      if (((Set)localObject1).iterator().hasNext())
      {
        localObject1 = (FileInfo)((Set)localObject1).iterator().next();
        localTeamWorkFileImportInfo.c = ((FileInfo)localObject1).c();
        localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = ((FileInfo)localObject1).d();
        localTeamWorkFileImportInfo.e = auea.a(((FileInfo)localObject1).d());
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
        beaz.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
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
    if (this.jdField_a_of_type_Bisl != null) {
      d();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bisl.isShowing()) {
        this.jdField_a_of_type_Bisl.show();
      }
      return;
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      this.jdField_a_of_type_Bisl.setCancelable(false);
      this.jdField_a_of_type_Bisl.a(anvx.a(2131713271));
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  public void c()
  {
    b(2131694656);
    new Handler().postDelayed(new SendBottomBar.15(this), 100L);
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.cancel();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131380650));
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
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
  }
  
  public void h() {}
  
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
  
  public void setClickListener(auex paramauex)
  {
    this.jdField_a_of_type_Auex = paramauex;
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && ((this.jdField_a_of_type_Boolean) || (atpm.b())))
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isDebugVersion()) {
        QLog.i("TeamWorkSender", 1, "docsCheck[" + paramBoolean + "],bCheckSendToDocs[" + this.jdField_a_of_type_Boolean + "], selectAllDocs[" + atpm.b() + "] ,hasSelectDocsFile[" + atpm.c() + "]");
      }
      if (atpm.b() != 0L) {
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
          new Handler().postDelayed(new SendBottomBar.16(this), 3000L);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("_fm_select_showd", true).apply();
        if (!this.jdField_c_of_type_Boolean) {
          break label319;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setText(anvx.a(2131713252));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new augr(this));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        audy.a("0X800942A");
        return;
        bool = false;
        break;
      } while ((atpm.b() <= 0L) || (atpm.c()));
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
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(anvx.a(2131713241));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setText(anvx.a(2131713265));
  }
  
  public void setSelectEvent(atdd paramatdd)
  {
    this.jdField_a_of_type_Atdd = paramatdd;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713264));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130838911));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */