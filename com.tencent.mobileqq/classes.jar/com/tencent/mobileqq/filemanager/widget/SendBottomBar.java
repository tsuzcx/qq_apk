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
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SendBottomBar
  extends RelativeLayout
{
  private View.OnClickListener A = new SendBottomBar.3(this);
  private boolean B = false;
  private View.OnClickListener C = new SendBottomBar.4(this);
  public QQProgressDialog a;
  ActionSheet b = null;
  QQCustomDialog c = null;
  private BaseQQAppInterface d = null;
  private Context e;
  private TextView f = null;
  private TextView g = null;
  private TextView h = null;
  private TextView i = null;
  private CheckBox j = null;
  private BaseFileAssistantActivity k;
  private IClickListenerVer51 l;
  private IBaseTabViewEvent m = null;
  private boolean n = false;
  private boolean o = false;
  private FrameLayout p = null;
  private TextView q = null;
  private boolean r = false;
  private View s;
  private boolean t = true;
  private QQBlurView u = null;
  private long v = 0L;
  private int w;
  private long x = 0L;
  private View.OnClickListener y = new SendBottomBar.1(this);
  private View.OnClickListener z = new SendBottomBar.2(this);
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627057, this);
    this.e = paramContext;
    k();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627057, this, true);
    this.e = paramContext;
    k();
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2)
  {
    a(paramBaseQQAppInterface, paramString1, paramString2, FMDataCache.g());
    b(paramBaseQQAppInterface, paramString1, paramString2);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, Set<FileInfo> paramSet)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendLocalFileToGuild(paramBaseQQAppInterface, paramString1, paramString2, paramSet);
  }
  
  private boolean a(String paramString)
  {
    if ((this.o) && (this.j.getVisibility() == 0))
    {
      long l1 = FMDataCache.e();
      this.f.setEnabled(true);
      this.i.setVisibility(0);
      Object localObject;
      if (l1 > 99L)
      {
        localObject = HardCodeUtil.a(2131896083);
      }
      else if (l1 == 0L)
      {
        localObject = HardCodeUtil.a(2131896078);
        this.i.setVisibility(8);
        this.f.setEnabled(false);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131896084));
        ((StringBuilder)localObject).append(String.valueOf(l1));
        ((StringBuilder)localObject).append(")");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (m())
      {
        this.f.setText(HardCodeUtil.a(2131896078));
        localObject = this.e.getResources().getColorStateList(2131165544);
        this.f.setBackgroundDrawable(null);
        this.f.setTextColor((ColorStateList)localObject);
        this.f.setTextSize(1, 17.0F);
        this.j.setCompoundDrawables(null, null, null, null);
        this.j.setTextColor(getResources().getColor(2131168001));
        this.j.setTextSize(1, 17.0F);
        if (l1 > 0L)
        {
          this.q.setText(paramString);
          this.q.setVisibility(0);
          this.q.setGravity(17);
          this.p.setVisibility(0);
          return true;
        }
        this.p.setVisibility(8);
        return true;
      }
      this.f.setText((CharSequence)localObject);
      this.i.setText(paramString);
      return true;
    }
    return false;
  }
  
  private FileInfo b(String paramString)
  {
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.f(paramString);
    localFileInfo.d(FileUtils.getFileName(paramString));
    localFileInfo.a(FileUtil.f(paramString));
    return localFileInfo;
  }
  
  private void b(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject = FMDataCache.h();
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      HashSet localHashSet = new HashSet();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if ((localFileManagerEntity != null) && (!TextUtils.isEmpty(localFileManagerEntity.strFilePath)) && (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strFilePath))) {
          localHashSet.add(b(localFileManagerEntity.strFilePath));
        }
      }
      if (!localHashSet.isEmpty()) {
        a(paramBaseQQAppInterface, paramString1, paramString2, localHashSet);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      long l1 = FMDataCache.l();
      boolean bool = false;
      if (l1 > 104857600L) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if ((paramBoolean) || (this.k.f))
      {
        if (this.k.f) {
          paramBoolean = bool;
        }
        localObject1 = (IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class);
        localObject2 = this.k;
        if (((IQQFileTempUtils)localObject1).handleVipForTroopFile((Context)localObject2, ((BaseFileAssistantActivity)localObject2).e, paramBoolean, new SendBottomBar.8(this))) {
          return;
        }
      }
    }
    if (!NetworkUtil.isNetSupport(this.k))
    {
      FMToastUtil.a(2131896111);
      c();
      return;
    }
    if (QQFileManagerUtil.h())
    {
      if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi((Activity)this.e, new SendBottomBar.9(this)))
      {
        localObject2 = new SendBottomBar.10(this);
        localObject1 = this.e.getString(2131896120);
        Context localContext = this.e;
        localObject2 = DialogUtil.a(localContext, 230, localContext.getString(2131896110), (String)localObject1, 2131887648, 2131896136, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2);
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).changeKingCardWording((QQCustomDialog)localObject2, this.e, (CharSequence)localObject1);
        ((QQCustomDialog)localObject2).show();
      }
    }
    else {
      c();
    }
  }
  
  private String getSelectedCountHint()
  {
    long l1 = FMDataCache.m();
    Object localObject1;
    if (l1 > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.e.getString(2131889321));
      ((StringBuilder)localObject1).append(FileUtil.a(l1));
      localObject1 = ((StringBuilder)localObject1).toString();
      this.i.setOnClickListener(null);
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (FMDataCache.n() > 0L)
    {
      localObject2 = localObject1;
      if (!QQFileManagerUtil.c(this.e))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.e.getString(2131889322));
        ((StringBuilder)localObject2).append(FileUtil.a(FMDataCache.n()));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    if (QQFileManagerUtil.c(this.e))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.e.getString(2131889321));
      ((StringBuilder)localObject1).append(FMDataCache.e());
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131896077));
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    return localObject2;
  }
  
  private FileManagerEntity getSelectedEntity()
  {
    Object localObject3 = FMDataCache.h();
    Object localObject2 = FMDataCache.g();
    Object localObject1 = FMDataCache.j();
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
        if (((FileInfo)localObject3).l() == 0) {
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
        if (QQFileManagerUtil.k(((WeiYunFileInfo)localObject2).c) == 0) {
          return QQFileManagerUtil.a((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  private void k()
  {
    this.k = ((BaseFileAssistantActivity)this.e);
    this.h = ((TextView)findViewById(2131440613));
    this.i = ((TextView)findViewById(2131439377));
    this.j = ((CheckBox)findViewById(2131430662));
    this.f = ((TextView)findViewById(2131445568));
    this.f.setOnClickListener(this.C);
    this.g = ((TextView)findViewById(2131440610));
    this.g.setOnClickListener(this.y);
    this.p = ((FrameLayout)findViewById(2131432051));
    this.p.setVisibility(8);
    this.q = ((TextView)findViewById(2131432052));
    this.q.setVisibility(8);
    this.s = findViewById(2131445540);
    this.s.setVisibility(8);
    if ((1 == this.k.u()) || (10 == this.k.u())) {
      this.f.setText(HardCodeUtil.a(2131896076));
    }
    this.d = ((BaseQQAppInterface)this.k.getAppRuntime());
    this.t = this.d.getPreferences().getBoolean("_fm_select_showd", false);
  }
  
  private boolean l()
  {
    Object localObject = FMDataCache.k();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (QQFileManagerUtil.k(((FavFileInfo)((Iterator)localObject).next()).d) == 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean m()
  {
    int i1 = this.k.L();
    if (i1 == -1) {
      return false;
    }
    if (!n()) {
      return false;
    }
    this.i.setOnClickListener(new SendBottomBar.5(this));
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          localObject = "";
        } else {
          localObject = HardCodeUtil.a(2131896134);
        }
      }
      else {
        localObject = HardCodeUtil.a(2131896128);
      }
    }
    else {
      localObject = HardCodeUtil.a(2131896133);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("排序方式:\n");
    localStringBuilder.append((String)localObject);
    Object localObject = QQFileManagerUtil.a(localStringBuilder.toString(), (String)localObject, null);
    this.i.setText((CharSequence)localObject);
    this.i.setVisibility(0);
    return true;
  }
  
  private boolean n()
  {
    int[] arrayOfInt = this.k.M();
    if (arrayOfInt == null)
    {
      this.b = null;
      return false;
    }
    int i2 = this.k.L();
    this.b = ActionSheet.create(this.k);
    int i3 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool2 = true;
      boolean bool3 = true;
      boolean bool1 = true;
      if (i1 >= i3) {
        break;
      }
      int i4 = arrayOfInt[i1];
      ActionSheet localActionSheet;
      String str;
      if (i4 != 0)
      {
        if (i4 != 1)
        {
          if (i4 == 2)
          {
            localActionSheet = this.b;
            str = HardCodeUtil.a(2131889333);
            if (i2 != i4) {
              bool1 = false;
            }
            localActionSheet.addRadioButton(str, bool1);
          }
        }
        else
        {
          localActionSheet = this.b;
          str = HardCodeUtil.a(2131889331);
          if (i2 == i4) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          localActionSheet.addRadioButton(str, bool1);
        }
      }
      else
      {
        localActionSheet = this.b;
        str = HardCodeUtil.a(2131889332);
        if (i2 == i4) {
          bool1 = bool3;
        } else {
          bool1 = false;
        }
        localActionSheet.addRadioButton(str, bool1);
      }
      i1 += 1;
    }
    this.b.addCancelButton(HardCodeUtil.a(2131889250));
    this.b.setOnButtonClickListenerV2(new SendBottomBar.6(this));
    return true;
  }
  
  private void o()
  {
    FileManagerReporter.a("0x80087C5");
    b(2131896127);
    new Handler().postDelayed(new SendBottomBar.7(this), 100L);
  }
  
  private void p()
  {
    int i2 = this.k.t();
    int i1 = 1;
    if (i2 == 1) {
      i1 = 2;
    } else if (this.k.t() != 0) {
      i1 = 4;
    }
    Object localObject = this.k.r();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(AppConstants.DATALINE_PC_UIN))) {
      i1 = 3;
    }
    long l1 = FMDataCache.e();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(l1);
    ReportController.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i1, 0, ((StringBuilder)localObject).toString(), "0", "", "");
  }
  
  private void q()
  {
    if (this.k.q())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FMDataCache.g());
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("reslut_select_file_info_list", localArrayList);
      localIntent.putExtra("approval_attachment_customid", this.k.H());
      this.k.setResult(-1, localIntent);
    }
    this.k.finish();
  }
  
  private void r()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B378", "0X800B378", 0, 0, "", "", "", "");
    if (this.k.q())
    {
      Object localObject2 = FMDataCache.h();
      Object localObject1 = FMDataCache.j();
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = new ArrayList();
      ((ArrayList)localObject3).addAll(FMDataCache.g());
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (FileInfo)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject4 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favUtilhandleFileEntry(this.d, null, ((FileInfo)localObject4).d(), true);
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
          localObject3 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favUtilhandleFileEntry(this.d, (FileManagerEntity)localObject3, "", false);
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
      ((Intent)localObject1).putExtra("approval_attachment_customid", this.k.H());
      this.k.setResult(-1, (Intent)localObject1);
    }
    this.k.finish();
  }
  
  private void s()
  {
    if ((QQFileManagerUtil.h()) && (FMDataCache.l() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this.k, 2131896097, 2131889589, new SendBottomBar.11(this));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(FMDataCache.g());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    this.k.setResult(-1, localIntent);
    this.k.finish();
  }
  
  private void t()
  {
    Intent localIntent = this.k.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getStringExtra("posturl") != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(FMDataCache.g());
        localIntent.putParcelableArrayListExtra("fileinfo", localArrayList);
        this.k.setResult(-1, localIntent);
        this.k.finish();
        return;
      }
      this.k.setResult(-1, localIntent);
      this.k.finish();
    }
  }
  
  private void u()
  {
    int i3 = this.k.t();
    if (this.k.I())
    {
      Object localObject2 = FMDataCache.g();
      Object localObject1 = FMDataCache.h();
      int i2 = 0;
      localObject2 = ((Set)localObject2).iterator();
      FileInfo localFileInfo;
      do
      {
        i1 = i2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localFileInfo = (FileInfo)((Iterator)localObject2).next();
      } while ((localFileInfo.f() <= 20971520L) || (!FMDataCache.d(localFileInfo)));
      int i1 = 1;
      i2 = i1;
      if (i1 == 0)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        do
        {
          i2 = i1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        } while ((((FileManagerEntity)localObject2).fileSize <= 20971520L) || (!FMDataCache.d((FileManagerEntity)localObject2)));
        i2 = 1;
      }
      if (i2 != 0)
      {
        FileManagerReporter.a("0X800942E");
        localObject1 = DialogUtil.a(this.k, 2131896124);
        ((QQCustomDialog)localObject1).setPositiveButton(2131917392, new SendBottomBar.12(this, i3));
        ((QQCustomDialog)localObject1).show();
        return;
      }
      a(i3);
      return;
    }
    a(i3);
  }
  
  private void v()
  {
    String str = this.k.r();
    Object localObject = FMDataCache.g();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((FileInfo)((Iterator)localObject).next()).d());
    }
    int i1 = this.k.w();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendQlinkFiles(this.k, str, localArrayList, i1);
    this.k.finish();
  }
  
  private void w()
  {
    int i1 = this.k.w();
    boolean bool = this.k.x();
    if ((1 == i1) && (!bool))
    {
      FMDialogUtil.a(this.k, 2131896349, 2131896348, new SendBottomBar.13(this));
      return;
    }
    v();
  }
  
  private void x()
  {
    Intent localIntent;
    if (this.k.C != -1L)
    {
      localIntent = new Intent();
      localIntent.putExtra("qrlogin_appid", this.k.C);
    }
    else
    {
      localIntent = null;
    }
    this.k.setResult(-1, localIntent);
    this.k.finish();
  }
  
  private boolean y()
  {
    BaseFileAssistantActivity localBaseFileAssistantActivity = this.k;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBaseFileAssistantActivity != null)
    {
      bool1 = bool2;
      if ((localBaseFileAssistantActivity instanceof FMActivity))
      {
        bool1 = bool2;
        if (((FMActivity)localBaseFileAssistantActivity).O() == 1201) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a()
  {
    h();
    int i1 = this.k.t();
    Object localObject2 = this.k.y();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      if (i1 == 5)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.e.getResources().getString(2131896135));
        ((StringBuilder)localObject1).append(this.e.getString(2131889554));
        ((StringBuilder)localObject1).append(FMDataCache.e());
        ((StringBuilder)localObject1).append(this.e.getString(2131889555));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (i1 == 6001)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.e.getResources().getString(2131896066));
        ((StringBuilder)localObject1).append(this.e.getString(2131889554));
        ((StringBuilder)localObject1).append(FMDataCache.e());
        ((StringBuilder)localObject1).append(this.e.getString(2131889555));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (i1 == 10006)
      {
        localObject1 = this.e.getResources().getString(2131892267);
      }
      else if (10 == this.k.u())
      {
        localObject1 = this.e.getResources().getString(2131892267);
        if (this.x < FMDataCache.e()) {
          ReportController.b(null, "dc00898", "", "", "0X800B377", "0X800B377", 0, 0, "", "", "", "");
        }
        this.x = FMDataCache.e();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.e.getString(2131896119));
        ((StringBuilder)localObject1).append(this.e.getString(2131889554));
        ((StringBuilder)localObject1).append(FMDataCache.e());
        ((StringBuilder)localObject1).append(this.e.getString(2131889555));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localObject2 = getSelectedCountHint();
    if (a((String)localObject2)) {
      return;
    }
    boolean bool3 = this.r;
    boolean bool2 = true;
    boolean bool1 = true;
    if ((bool3) && (!QQFileManagerUtil.c(this.e)))
    {
      long l1 = FMDataCache.e();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131896122));
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(")");
      localObject1 = ((StringBuilder)localObject1).toString();
      this.i.setVisibility(8);
      this.p.setVisibility(0);
      this.q.setVisibility(0);
      this.q.setText((CharSequence)localObject2);
      this.j.setEnabled(true);
      localObject2 = this.f;
      if (FMDataCache.e() <= 0L) {
        bool1 = false;
      }
      ((TextView)localObject2).setEnabled(bool1);
      this.f.setText((CharSequence)localObject1);
      return;
    }
    this.p.setVisibility(8);
    this.q.setVisibility(8);
    this.j.setVisibility(8);
    if (this.k.u() != 1)
    {
      i1 = this.g.getVisibility();
      if ((i1 != 4) && (i1 != 8))
      {
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.h.setText((CharSequence)localObject2);
      }
      else
      {
        this.i.setVisibility(0);
        this.h.setVisibility(8);
        if (QQFileManagerUtil.c(this.e))
        {
          if (FMDataCache.e() == 0L)
          {
            this.i.setVisibility(8);
          }
          else
          {
            this.i.setVisibility(0);
            this.i.setText((CharSequence)localObject2);
          }
        }
        else {
          this.i.setText((CharSequence)localObject2);
        }
      }
    }
    else
    {
      i1 = this.g.getVisibility();
      if ((i1 != 4) && (i1 != 8))
      {
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.h.setText(2131896191);
      }
      else
      {
        this.i.setVisibility(0);
        this.h.setVisibility(8);
        this.i.setText(2131896191);
        localObject2 = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(9);
        this.i.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    if (getSelectedEntity() != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (y()) {
      bool1 = l();
    }
    this.f.setText((CharSequence)localObject1);
    if (1 == this.k.u()) {
      this.f.setText(HardCodeUtil.a(2131896076));
    }
    localObject1 = this.f;
    if (FMDataCache.e() <= 0L) {
      bool2 = false;
    }
    ((TextView)localObject1).setEnabled(bool2);
    this.g.setEnabled(bool1);
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      FMToastUtil.a(2131896111);
      return;
    }
    if ((QQFileManagerUtil.h()) && (FMDataCache.l() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      QQFileManagerUtil.a(true, this.e, new SendBottomBar.14(this), paramInt);
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.k.L() != -1) {
      return;
    }
    if (paramBoolean)
    {
      if (this.p.getVisibility() == 0) {
        return;
      }
      this.p.setVisibility(0);
    }
    else if (this.p.getVisibility() != 0)
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
    this.p.startAnimation(localTranslateAnimation);
    if (!paramBoolean)
    {
      this.p.setVisibility(8);
      new Handler().postDelayed(new SendBottomBar.19(this), 1500L);
    }
  }
  
  public void b()
  {
    Object localObject4 = FMDataCache.g();
    Object localObject3 = FMDataCache.h();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    Object localObject1 = null;
    Object localObject2 = null;
    int i2 = 0;
    if ((localObject4 != null) && (((Set)localObject4).size() > 0))
    {
      if (((Set)localObject4).iterator().hasNext()) {
        localObject1 = (FileInfo)((Set)localObject4).iterator().next();
      } else {
        localObject1 = null;
      }
      localTeamWorkFileImportInfo.d = ((FileInfo)localObject1).d();
      localTeamWorkFileImportInfo.c = ((FileInfo)localObject1).e();
      localTeamWorkFileImportInfo.u = QQFileManagerUtil.k(((FileInfo)localObject1).e());
      localTeamWorkFileImportInfo.n = 10;
      localTeamWorkFileImportInfo.K = ((FileInfo)localObject1).f();
      localObject4 = this.e;
      if ((localObject4 != null) && ((localObject4 instanceof FMActivity)))
      {
        localObject1 = (FMActivity)localObject4;
        localTeamWorkFileImportInfo.v = ((FMActivity)localObject4).A;
      }
      else
      {
        localObject4 = this.e;
        if ((localObject4 != null) && ((localObject4 instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)localObject4;
          localTeamWorkFileImportInfo.v = ((FMLocalFileActivity)localObject4).A;
        }
        else
        {
          localObject4 = this.e;
          localObject1 = localObject2;
          if (localObject4 != null)
          {
            localObject1 = localObject2;
            if ((localObject4 instanceof LocalFileBrowserActivity))
            {
              localObject1 = (LocalFileBrowserActivity)localObject4;
              localTeamWorkFileImportInfo.v = ((LocalFileBrowserActivity)localObject4).A;
            }
          }
        }
      }
      i1 = 1;
      localObject2 = localObject1;
    }
    else
    {
      i1 = 0;
      localObject2 = localObject1;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((ArrayList)localObject3).size() > 0)
      {
        localObject1 = localObject2;
        if (i1 == 0)
        {
          localObject1 = (FileManagerEntity)((ArrayList)localObject3).get(0);
          localTeamWorkFileImportInfo.d = ((FileManagerEntity)localObject1).getFilePath();
          localTeamWorkFileImportInfo.c = ((FileManagerEntity)localObject1).fileName;
          localTeamWorkFileImportInfo.u = ((FileManagerEntity)localObject1).nFileType;
          localTeamWorkFileImportInfo.K = ((FileManagerEntity)localObject1).fileSize;
          localTeamWorkFileImportInfo.n = 10;
          localTeamWorkFileImportInfo.b = ((FileManagerEntity)localObject1).peerUin;
          localTeamWorkFileImportInfo.e = ((FileManagerEntity)localObject1).uniseq;
          localTeamWorkFileImportInfo.a = ((FileManagerEntity)localObject1).peerType;
          localTeamWorkFileImportInfo.f = ((FileManagerEntity)localObject1).nSessionId;
          localTeamWorkFileImportInfo.m = true;
          localObject3 = this.e;
          if ((localObject3 != null) && ((localObject3 instanceof FMActivity)))
          {
            localObject1 = (FMActivity)localObject3;
            localTeamWorkFileImportInfo.v = ((FMActivity)localObject3).A;
          }
          else
          {
            localObject3 = this.e;
            if ((localObject3 != null) && ((localObject3 instanceof FMLocalFileActivity)))
            {
              localObject1 = (FMLocalFileActivity)localObject3;
              localTeamWorkFileImportInfo.v = ((FMLocalFileActivity)localObject3).A;
            }
            else
            {
              localObject3 = this.e;
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if ((localObject3 instanceof LocalFileBrowserActivity))
                {
                  localObject1 = (LocalFileBrowserActivity)localObject3;
                  localTeamWorkFileImportInfo.v = ((LocalFileBrowserActivity)localObject3).A;
                }
              }
            }
          }
        }
      }
    }
    localObject2 = this.e;
    int i1 = i2;
    if ((localObject2 instanceof BaseFileAssistantActivity)) {
      i1 = ((BaseFileAssistantActivity)localObject2).v();
    }
    TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.e, this.d, i1);
    if (localObject1 != null) {
      ((Activity)localObject1).finish();
    }
  }
  
  void b(int paramInt)
  {
    if (this.a != null)
    {
      e();
    }
    else
    {
      Context localContext = this.e;
      this.a = new QQProgressDialog(localContext, localContext.getResources().getDimensionPixelSize(2131299920));
      this.a.setCancelable(false);
      this.a.a(HardCodeUtil.a(2131896137));
      this.a.show();
    }
    if (!this.a.isShowing()) {
      this.a.show();
    }
  }
  
  public void c()
  {
    ArrayList localArrayList = FMDataCache.h();
    Set localSet = FMDataCache.g();
    String str = ((BaseFileAssistantActivity)this.e).r();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).showDeviceChoose(this.e, str, localArrayList, localSet, new SendBottomBar.15(this));
  }
  
  public void d()
  {
    b(2131892585);
    new Handler().postDelayed(new SendBottomBar.16(this), 100L);
  }
  
  void e()
  {
    try
    {
      if ((this.a != null) && (this.a.isShowing()))
      {
        this.a.cancel();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean f()
  {
    return this.n;
  }
  
  public void g()
  {
    if (this.k != null)
    {
      View localView = this.s;
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        this.t = true;
        this.s.setVisibility(8);
      }
    }
  }
  
  @TargetApi(19)
  protected void h()
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      this.u = null;
    }
    localObject = this.k.i();
    if (localObject == null) {
      return;
    }
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      return;
    }
    this.u = ((QQBlurView)findViewById(2131449300));
    this.u.setVisibility(0);
    this.u.a((View)localObject);
    localObject = this.u;
    ((QQBlurView)localObject).b((View)localObject);
    this.u.c(-1);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    this.u.setEnableBlur(bool);
    this.u.b(0);
    this.u.a(8.0F);
    this.u.a(8);
    this.u.d();
    this.u.a();
  }
  
  public void i()
  {
    QQBlurView localQQBlurView = this.u;
    if (localQQBlurView != null) {
      localQQBlurView.c();
    }
  }
  
  public void j() {}
  
  public void setAttribution(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setCheckAllEnable(boolean paramBoolean)
  {
    CheckBox localCheckBox = this.j;
    if (localCheckBox != null) {
      localCheckBox.setEnabled(paramBoolean);
    }
  }
  
  public void setClickListener(IClickListenerVer51 paramIClickListenerVer51)
  {
    this.l = paramIClickListenerVer51;
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && ((this.n) || (FMDataCache.p()))) {
      bool = true;
    } else {
      bool = false;
    }
    this.r = bool;
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("docsCheck[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("],bCheckSendToDocs[");
      localStringBuilder.append(this.n);
      localStringBuilder.append("], selectAllDocs[");
      localStringBuilder.append(FMDataCache.p());
      localStringBuilder.append("] ,hasSelectDocsFile[");
      localStringBuilder.append(FMDataCache.q());
      localStringBuilder.append("]");
      QLog.i("TeamWorkSender", 1, localStringBuilder.toString());
    }
    if (FMDataCache.e() == 0L)
    {
      this.j.setChecked(false);
      this.n = false;
      this.r = false;
    }
    else if ((FMDataCache.e() > 0L) && (!FMDataCache.q()))
    {
      this.j.setChecked(false);
      this.n = false;
      this.r = false;
    }
    if ((this.r) && (!this.t))
    {
      this.s.setVisibility(0);
      new Handler().postDelayed(new SendBottomBar.17(this), 3000L);
    }
    this.d.getPreferences().edit().putBoolean("_fm_select_showd", true).apply();
    if (this.r)
    {
      this.j.setVisibility(0);
      this.j.setEnabled(true);
      this.j.setText(HardCodeUtil.a(2131896121));
      this.j.setOnClickListener(new SendBottomBar.18(this));
      this.i.setVisibility(8);
      this.p.setVisibility(0);
      this.q.setVisibility(0);
      FileManagerReporter.a("0X800942A");
      return;
    }
    this.j.setVisibility(8);
    this.p.setVisibility(8);
    this.q.setVisibility(8);
  }
  
  public void setEditBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.g;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localTextView.setVisibility(i1);
    a();
  }
  
  public void setOnlyDocsChecked()
  {
    this.n = true;
    this.j.setChecked(true);
  }
  
  public void setSelectAllOrCancelAll(boolean paramBoolean)
  {
    this.j.setChecked(paramBoolean ^ true);
    if (paramBoolean)
    {
      this.j.setText(HardCodeUtil.a(2131896117));
      return;
    }
    this.j.setText(HardCodeUtil.a(2131896068));
  }
  
  public void setSelectEvent(IBaseTabViewEvent paramIBaseTabViewEvent)
  {
    this.m = paramIBaseTabViewEvent;
  }
  
  public void setSelectedAllMode()
  {
    this.o = true;
    this.j.setVisibility(0);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.j.setOnClickListener(this.z);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    localLayoutParams.addRule(13);
    this.i.setGravity(1);
    this.i.setLayoutParams(localLayoutParams);
    this.i.setVisibility(0);
    this.f.setVisibility(0);
    this.f.setText(HardCodeUtil.a(2131889566));
    this.f.setOnClickListener(this.A);
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.q.setBackgroundDrawable(getResources().getDrawable(2130838958));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */