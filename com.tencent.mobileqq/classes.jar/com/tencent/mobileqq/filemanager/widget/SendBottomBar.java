package com.tencent.mobileqq.filemanager.widget;

import amtj;
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
import aqgf;
import aqgg;
import aqgi;
import aqid;
import aqij;
import aryx;
import asld;
import aslg;
import aszg;
import aszk;
import aszr;
import aszt;
import ataq;
import atcd;
import atce;
import atcf;
import atcg;
import atch;
import atci;
import atck;
import atcl;
import atcm;
import atcp;
import atcq;
import atcr;
import atct;
import bcef;
import bcua;
import bfaw;
import bfby;
import bfur;
import bgox;
import bhht;
import bhnb;
import bjnw;
import bjon;
import bkmt;
import bkpj;
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
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atcd(this);
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aryx jdField_a_of_type_Aryx;
  private ataq jdField_a_of_type_Ataq;
  public bhht a;
  public bjnw a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  public QQCustomDialog a;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new atcl(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new atcm(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new atcp(this);
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = true;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Bjnw = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560774, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    i();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bjnw = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560774, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    i();
  }
  
  @NotNull
  private String a()
  {
    long l = aslg.d();
    String str1 = "";
    if (l > 0L)
    {
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692183) + FileUtil.filesizeToString(l);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
    String str2 = str1;
    if (aslg.e() > 0L)
    {
      str2 = str1;
      if (!aszt.a(this.jdField_a_of_type_AndroidContentContext)) {
        str2 = str1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692184) + FileUtil.filesizeToString(aslg.e());
      }
    }
    if (aszt.a(this.jdField_a_of_type_AndroidContentContext)) {
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692183) + aslg.b() + amtj.a(2131712900);
    }
    return str2;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0))
    {
      long l = aslg.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      Object localObject;
      if (l > 99L)
      {
        localObject = amtj.a(2131712904);
        if (!b()) {
          break label272;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131712908));
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165339);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setCompoundDrawables(null, null, null, null);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTextColor(getResources().getColor(2131167019));
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
          localObject = amtj.a(2131712911);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          break;
        }
        localObject = amtj.a(2131712921) + String.valueOf(l) + ")";
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
      if (aslg.c() > 104857600L)
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
      Object localObject1 = aqij.c();
      if (((aqid)localObject1).a())
      {
        localObject2 = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        if (!((aqid)localObject1).a(this.jdField_a_of_type_AndroidContentContext, new SendBottomBar.8(this), paramBoolean, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_a_of_type_Boolean)) {}
      }
      label104:
      do
      {
        return;
        paramBoolean = false;
        break;
        if (bfby.a(this.jdField_a_of_type_AndroidContentContext) == 0)
        {
          bfaw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697079));
          c();
          return;
        }
        if (!aszt.a()) {
          break label265;
        }
      } while (!bhnb.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new atct(this)));
      Object localObject2 = new atce(this);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696862);
      localObject2 = bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697076), (String)localObject1, 2131690620, 2131697272, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2);
      if ((aqgi.c().b.jdField_a_of_type_Boolean) && (!bgox.a().b())) {
        ((QQCustomDialog)localObject2).setMessageWithoutAutoLink(aqgi.c().b.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject1));
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
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new atcq(this));
    Object localObject = "";
    switch (i)
    {
    }
    for (;;)
    {
      localObject = aszt.a("排序方式:\n" + (String)localObject, (String)localObject, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return true;
      localObject = amtj.a(2131712897);
      continue;
      localObject = amtj.a(2131712906);
      continue;
      localObject = amtj.a(2131712923);
    }
  }
  
  private boolean c()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    if (arrayOfInt == null)
    {
      this.jdField_a_of_type_Bjnw = null;
      return false;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g();
    this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null));
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int m = arrayOfInt[i];
      bjnw localbjnw;
      String str;
      boolean bool;
      switch (m)
      {
      default: 
        i += 1;
        break;
      case 1: 
        localbjnw = this.jdField_a_of_type_Bjnw;
        str = amtj.a(2131712891);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbjnw.a(str, bool);
          break;
        }
      case 0: 
        localbjnw = this.jdField_a_of_type_Bjnw;
        str = amtj.a(2131712907);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbjnw.a(str, bool);
          break;
        }
      case 2: 
        localbjnw = this.jdField_a_of_type_Bjnw;
        str = amtj.a(2131712898);
        if (j == m) {}
        for (bool = true;; bool = false)
        {
          localbjnw.a(str, bool);
          break;
        }
      }
    }
    this.jdField_a_of_type_Bjnw.d(amtj.a(2131712903));
    this.jdField_a_of_type_Bjnw.a(new atcr(this));
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
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372921));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371853));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364510));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377065));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372918));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365700));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365701));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377040);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) || (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131712901));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("_fm_select_showd", false);
  }
  
  private void j()
  {
    aszr.a("0x80087C5");
    b(2131694455);
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
      long l = aslg.b();
      bcef.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
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
      localArrayList.addAll(aslg.a());
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("reslut_select_file_info_list", localArrayList);
      localIntent.putExtra("approval_attachment_customid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void m()
  {
    bcef.b(null, "dc00898", "", "", "0X800B378", "0X800B378", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c())
    {
      Object localObject2 = aslg.b();
      Object localObject1 = aslg.d();
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = new ArrayList();
      ((ArrayList)localObject3).addAll(aslg.a());
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (FileInfo)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject4 = bkpj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, ((FileInfo)localObject4).c(), true);
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
          localObject3 = bkpj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject3, "", false);
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
          localObject2 = bkpj.a((WeiYunFileInfo)((Iterator)localObject1).next());
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
    if ((aszt.a()) && (aslg.c() > asld.a()))
    {
      aszg.a(SplashActivity.sTopActivity, 2131692374, 2131692379, new atcf(this));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(aslg.a());
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
        localArrayList.addAll(aslg.a());
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
      Object localObject2 = aslg.a();
      localObject1 = aslg.b();
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
      } while ((localFileInfo.a() <= 20971520L) || (!aslg.b(localFileInfo)));
      i = 1;
      if (i != 0) {
        break label198;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).fileSize > 20971520L) && (aslg.b((FileManagerEntity)localObject2))) {
          i = 1;
        }
      }
    }
    label198:
    for (;;)
    {
      if (i != 0)
      {
        aszr.a("0X800942E");
        localObject1 = bfur.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697630);
        ((QQCustomDialog)localObject1).setPositiveButton(2131719087, new atcg(this, k));
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
    Object localObject3 = aslg.a();
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
          bkmt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 16, (Bundle)localObject2);
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
      aszg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697801, 2131697800, new atch(this));
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
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697259) + this.jdField_a_of_type_AndroidContentContext.getString(2131692344) + aslg.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692345);
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
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692116) + this.jdField_a_of_type_AndroidContentContext.getString(2131692344) + aslg.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692345);
        }
        else if (i == 10006)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694201);
        }
        else if (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694201);
          if (this.jdField_b_of_type_Long < aslg.b()) {
            bcef.b(null, "dc00898", "", "", "0X800B377", "0X800B377", 0, 0, "", "", "", "");
          }
          this.jdField_b_of_type_Long = aslg.b();
        }
        else
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692185) + this.jdField_a_of_type_AndroidContentContext.getString(2131692344) + aslg.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692345);
        }
      }
      else
      {
        if ((this.jdField_c_of_type_Boolean) && (!aszt.a(this.jdField_a_of_type_AndroidContentContext)))
        {
          long l = aslg.b();
          localObject1 = amtj.a(2131712909) + l + ")";
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
          if (aslg.b() > 0L) {
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
            if (aszt.a(this.jdField_a_of_type_AndroidContentContext)) {
              if (aslg.b() == 0L)
              {
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                if (aszt.a() == null) {
                  break label832;
                }
                bool1 = true;
                label591:
                if (d()) {
                  bool1 = aszt.b();
                }
                this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
                if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131712895));
                }
                localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
                if (aslg.b() <= 0L) {
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
            this.jdField_d_of_type_AndroidWidgetTextView.setText(2131697780);
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(9);
            this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            break;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131697780);
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
      aszk.a(2131694035);
      return;
    }
    if ((aszt.a()) && (aslg.c() > asld.a()))
    {
      aszt.a(true, this.jdField_a_of_type_AndroidContentContext, new atci(this), paramInt);
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
    Object localObject1 = aslg.a();
    ArrayList localArrayList = aslg.b();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    label148:
    int i;
    if ((localObject1 != null) && (((Set)localObject1).size() > 0)) {
      if (((Set)localObject1).iterator().hasNext())
      {
        localObject1 = (FileInfo)((Set)localObject1).iterator().next();
        localTeamWorkFileImportInfo.c = ((FileInfo)localObject1).c();
        localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = ((FileInfo)localObject1).d();
        localTeamWorkFileImportInfo.e = aszt.a(((FileInfo)localObject1).d());
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
        bcua.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
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
    if (this.jdField_a_of_type_Bhht != null) {
      d();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bhht.isShowing()) {
        this.jdField_a_of_type_Bhht.show();
      }
      return;
      this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      this.jdField_a_of_type_Bhht.setCancelable(false);
      this.jdField_a_of_type_Bhht.a(amtj.a(2131712924));
      this.jdField_a_of_type_Bhht.show();
    }
  }
  
  public void c()
  {
    b(2131694455);
    new Handler().postDelayed(new SendBottomBar.15(this), 100L);
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
        this.jdField_a_of_type_Bhht.cancel();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131380315));
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
  
  public void setClickListener(ataq paramataq)
  {
    this.jdField_a_of_type_Ataq = paramataq;
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && ((this.jdField_a_of_type_Boolean) || (aslg.b())))
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isDebugVersion()) {
        QLog.i("TeamWorkSender", 1, "docsCheck[" + paramBoolean + "],bCheckSendToDocs[" + this.jdField_a_of_type_Boolean + "], selectAllDocs[" + aslg.b() + "] ,hasSelectDocsFile[" + aslg.c() + "]");
      }
      if (aslg.b() != 0L) {
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
        this.jdField_a_of_type_AndroidWidgetCheckBox.setText(amtj.a(2131712905));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new atck(this));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        aszr.a("0X800942A");
        return;
        bool = false;
        break;
      } while ((aslg.b() <= 0L) || (aslg.c()));
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
      this.jdField_a_of_type_AndroidWidgetCheckBox.setText(amtj.a(2131712894));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setText(amtj.a(2131712918));
  }
  
  public void setSelectEvent(aryx paramaryx)
  {
    this.jdField_a_of_type_Aryx = paramaryx;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131712917));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130838891));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */