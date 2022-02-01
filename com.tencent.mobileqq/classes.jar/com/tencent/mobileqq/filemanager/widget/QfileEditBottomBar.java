package com.tencent.mobileqq.filemanager.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.CommonUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class QfileEditBottomBar
  extends RelativeLayout
  implements View.OnClickListener
{
  IClickListenerVer51 a;
  ImageView b;
  ImageView c;
  ImageView d;
  ImageView e;
  ImageView f;
  SparseArray<Integer> g = new SparseArray();
  int h = -1;
  private AppRuntime i = null;
  private Context j;
  private BaseFileAssistantActivity k;
  private QQBlurView l;
  
  public QfileEditBottomBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileEditBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QfileEditBottomBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627033, this, true);
    this.j = paramContext;
    d();
  }
  
  private long a(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = FMDataCache.g().iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      FileManagerEntity localFileManagerEntity = QQFileManagerUtil.a(localFileInfo);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10000);
      localForwardFileInfo.d(localFileManagerEntity.getCloudType());
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(localFileManagerEntity.fileName);
      localForwardFileInfo.c(localFileManagerEntity.uniseq);
      localForwardFileInfo.c(localFileManagerEntity.WeiYunFileId);
      localForwardFileInfo.d(localFileManagerEntity.fileSize);
      localForwardFileInfo.a(localFileManagerEntity.getFilePath());
      localForwardFileInfo.b(localFileManagerEntity.Uuid);
      if (!TextUtils.isEmpty(localFileManagerEntity.strLargeThumPath)) {
        localForwardFileInfo.f(localFileManagerEntity.strLargeThumPath);
      } else if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath)) {
        localForwardFileInfo.f(localFileManagerEntity.strMiddleThumPath);
      } else {
        localForwardFileInfo.f(localFileManagerEntity.strThumbPath);
      }
      paramArrayList1.add(Uri.parse(localFileInfo.d()));
      l1 += localForwardFileInfo.j();
      paramArrayList.add(localForwardFileInfo);
    }
    return l1;
  }
  
  private void a(ArrayList<ForwardFileInfo> paramArrayList, Set<FileInfo> paramSet, List<FileManagerEntity> paramList, List<WeiYunFileInfo> paramList1, ArrayList<Uri> paramArrayList1)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    long l2 = 0L;
    long l1 = l2;
    if (paramSet != null)
    {
      l1 = l2;
      if (paramSet.size() > 0) {
        l1 = 0L + a(paramArrayList, paramArrayList1);
      }
    }
    l2 = l1;
    if (paramList != null)
    {
      l2 = l1;
      if (paramList.size() > 0) {
        l2 = l1 + b(paramArrayList, paramArrayList1);
      }
    }
    boolean bool;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      l2 += c(paramArrayList, paramArrayList1);
      bool = false;
    }
    else
    {
      bool = true;
    }
    localBundle.putParcelableArrayList("fileinfo_array", paramArrayList);
    localBundle.putBoolean("not_forward", true);
    localIntent.putExtra("sendMultiple", true);
    localBundle.putParcelableArrayList("android.intent.extra.STREAM", paramArrayList1);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("foward_editbar", true);
    paramSet = HardCodeUtil.a(2131896102);
    if (paramArrayList.size() == 1)
    {
      paramSet = new StringBuilder();
      paramSet.append(HardCodeUtil.a(2131896071));
      paramSet.append(QQFileManagerUtil.b(((ForwardFileInfo)paramArrayList.get(0)).i()));
      paramSet.append(HardCodeUtil.a(2131896074));
      paramSet.append(FileUtil.a(((ForwardFileInfo)paramArrayList.get(0)).j()));
      paramSet.append("。");
      paramSet = paramSet.toString();
    }
    else if (paramArrayList.size() > 1)
    {
      paramSet = new StringBuilder();
      paramSet.append(HardCodeUtil.a(2131896071));
      paramSet.append(QQFileManagerUtil.b(((ForwardFileInfo)paramArrayList.get(0)).i()));
      paramSet.append(HardCodeUtil.a(2131896073));
      paramSet.append(paramArrayList.size());
      paramSet.append(HardCodeUtil.a(2131896072));
      paramSet.append(FileUtil.a(l2));
      paramSet.append("。");
      paramSet = paramSet.toString();
    }
    localIntent.putExtra("forward_text", paramSet);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startForwardByOriginFile(this.k, localIntent, bool);
  }
  
  private void a(List<FileManagerEntity> paramList)
  {
    ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).forwardTencentDocs(this.i, this.k, paramList, new QfileEditBottomBar.8(this));
  }
  
  private long b(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = FMDataCache.h().iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.sendCloudUnsuccessful()) && (localFileManagerEntity.nFileType != 13))
      {
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(10001);
        localForwardFileInfo.d(localFileManagerEntity.getCloudType());
        localForwardFileInfo.b(localFileManagerEntity.nSessionId);
        localForwardFileInfo.d(localFileManagerEntity.fileName);
        localForwardFileInfo.c(localFileManagerEntity.uniseq);
        localForwardFileInfo.c(localFileManagerEntity.WeiYunFileId);
        localForwardFileInfo.d(localFileManagerEntity.fileSize);
        localForwardFileInfo.a(localFileManagerEntity.getFilePath());
        localForwardFileInfo.b(localFileManagerEntity.Uuid);
        if (!TextUtils.isEmpty(localFileManagerEntity.strLargeThumPath)) {
          localForwardFileInfo.f(localFileManagerEntity.strLargeThumPath);
        } else if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath)) {
          localForwardFileInfo.f(localFileManagerEntity.strMiddleThumPath);
        } else {
          localForwardFileInfo.f(localFileManagerEntity.strThumbPath);
        }
        if ((localFileManagerEntity.getCloudType() == 3) && (localFileManagerEntity.getFilePath() != null) && (localFileManagerEntity.getFilePath().length() > 0)) {
          paramArrayList1.add(Uri.parse(localFileManagerEntity.getFilePath()));
        } else {
          paramArrayList1.add(Uri.parse(""));
        }
        l1 += localForwardFileInfo.j();
        paramArrayList.add(localForwardFileInfo);
      }
    }
    return l1;
  }
  
  private void b(View paramView)
  {
    a(paramView);
    paramView = this.a;
    if (paramView != null) {
      paramView.e();
    }
  }
  
  private long c(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Object localObject1 = FMDataCache.j();
    IQQFileEngine localIQQFileEngine = (IQQFileEngine)((BaseQQAppInterface)this.i).getRuntimeService(IQQFileEngine.class);
    IQQFileDataCenter localIQQFileDataCenter = (IQQFileDataCenter)((BaseQQAppInterface)this.i).getRuntimeService(IQQFileDataCenter.class);
    Iterator localIterator = ((List)localObject1).iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      Object localObject2 = localIQQFileEngine.queryFileEntityByFileId(localWeiYunFileInfo.a);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = localIQQFileDataCenter.queryByFileIdForMemory(localWeiYunFileInfo.a);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = QQFileManagerUtil.a(localWeiYunFileInfo);
        }
      }
      localObject2 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject2).b(10003);
      ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).getCloudType());
      ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
      ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileName);
      ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).uniseq);
      ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).WeiYunFileId);
      ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileSize);
      ((ForwardFileInfo)localObject2).a(((FileManagerEntity)localObject1).getFilePath());
      ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).Uuid);
      l1 += ((ForwardFileInfo)localObject2).j();
      paramArrayList.add(localObject2);
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strLargeThumPath)) {
        ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strLargeThumPath);
      } else if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strMiddleThumPath)) {
        ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strMiddleThumPath);
      } else {
        ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strThumbPath);
      }
      localObject2 = localIQQFileEngine.queryFileEntityByFileId(localWeiYunFileInfo.a);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localIQQFileDataCenter.queryByFileIdForMemory(localWeiYunFileInfo.a);
      }
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).getFilePath() != null) && (((FileManagerEntity)localObject1).getFilePath().length() > 0)) {
        paramArrayList1.add(Uri.parse(((FileManagerEntity)localObject1).getFilePath()));
      } else {
        paramArrayList1.add(Uri.parse(""));
      }
    }
    return l1;
  }
  
  private void d()
  {
    this.k = ((BaseFileAssistantActivity)this.j);
    this.i = this.k.getAppRuntime();
    this.b = ((ImageView)findViewById(2131432312));
    this.c = ((ImageView)findViewById(2131432311));
    this.d = ((ImageView)findViewById(2131432316));
    this.e = ((ImageView)findViewById(2131432313));
    this.f = ((ImageView)findViewById(2131432310));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void e()
  {
    ArrayList localArrayList = ((IQQFileEngine)((BaseQQAppInterface)this.i).getRuntimeService(IQQFileEngine.class)).saveAllSelectFileToWeiYun();
    IClickListenerVer51 localIClickListenerVer51 = this.a;
    if (localIClickListenerVer51 != null) {
      localIClickListenerVer51.c();
    }
    FMDataCache.d();
    this.k.f(false);
    this.k.a(localArrayList);
    this.k.m();
    this.k.c();
    if (localArrayList.size() > 0) {
      FMToastUtil.d(this.k.getString(2131889761));
    }
  }
  
  private void f()
  {
    if (!NetworkUtil.isNetSupport(this.j))
    {
      FMToastUtil.a(this.j.getString(2131896111));
      return;
    }
    j();
    IClickListenerVer51 localIClickListenerVer51 = this.a;
    if (localIClickListenerVer51 != null) {
      localIClickListenerVer51.d();
    }
    FMDataCache.d();
    this.k.m();
    this.k.f(false);
    this.k.c();
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetSupport(this.j))
    {
      FMToastUtil.a(this.j.getString(2131896111));
      return;
    }
    if (QQFileManagerUtil.a(false, FMDataCache.h()))
    {
      if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi(this.k, new QfileEditBottomBar.2(this))) {
        FMDialogUtil.a(this.k, 2131896097, 2131889587, new QfileEditBottomBar.3(this));
      }
    }
    else if ((FMDataCache.l() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()) && (QQFileManagerUtil.h()))
    {
      if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi(this.k, new QfileEditBottomBar.4(this))) {
        FMDialogUtil.a(this.k, 2131896097, 2131889587, new QfileEditBottomBar.5(this));
      }
    }
    else {
      e();
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downLoadAllSelectFiles,weiyun[");
      ((StringBuilder)localObject).append(FMDataCache.j().size());
      ((StringBuilder)localObject).append("], offline[");
      ((StringBuilder)localObject).append(FMDataCache.i().size());
      ((StringBuilder)localObject).append("], recent[");
      ((StringBuilder)localObject).append(FMDataCache.h().size());
      ((StringBuilder)localObject).append("], localfile[");
      ((StringBuilder)localObject).append(FMDataCache.g().size());
      ((StringBuilder)localObject).append("]");
      QLog.i("QfileEditBottomBar", 2, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetSupport(this.j))
    {
      FMToastUtil.a(this.j.getString(2131896111));
      return;
    }
    if (FMDataCache.n() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize())
    {
      QQFileManagerUtil.a(false, this.k, new QfileEditBottomBar.6(this));
      return;
    }
    ((IQQFileEngine)((BaseQQAppInterface)this.i).getRuntimeService(IQQFileEngine.class)).downLoadAllSelectFiles(this.j);
    Object localObject = this.a;
    if (localObject != null) {
      ((IClickListenerVer51)localObject).b();
    }
    FMDataCache.d();
    this.k.m();
    this.k.f(false);
    this.k.c();
  }
  
  private void i()
  {
    Object localObject2 = FMDataCache.h();
    Object localObject1 = FMDataCache.g();
    localObject2 = ((ArrayList)localObject2).iterator();
    int m = 0;
    while (((Iterator)localObject2).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
      if (localFileManagerEntity.nFileType == 13)
      {
        this.i.getCurrentUin();
        if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favBuilderNewLink(this.k, localFileManagerEntity.Uuid)) {
          break;
        }
      }
      else
      {
        for (;;)
        {
          m = 1;
          break;
          if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favBuilderNewFile(this.k, localFileManagerEntity)) {
            break;
          }
        }
      }
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((FileInfo)((Iterator)localObject1).next()).d();
      if ((FileUtils.fileExistsAndNotEmpty((String)localObject2)) && (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favBuilderNewFile(this.k, (String)localObject2))) {
        m = 1;
      }
    }
    if (m != 0) {
      FMToastUtil.a(this.k.getString(2131896096));
    } else {
      FMToastUtil.b(this.k.getString(2131916911));
    }
    FMDataCache.d();
    this.k.f(false);
    this.k.c();
  }
  
  private void j()
  {
    ArrayList localArrayList1 = new ArrayList();
    Set localSet = FMDataCache.g();
    ArrayList localArrayList2 = FMDataCache.h();
    ArrayList localArrayList3 = FMDataCache.j();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    boolean bool = CommonUtils.a(localArrayList2);
    int i1 = 1;
    int m = 1;
    int n;
    if (bool)
    {
      Iterator localIterator = localArrayList2.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (localFileManagerEntity.nFileType == 13) {
          localArrayList5.add(localFileManagerEntity);
        }
      }
      if (localArrayList5.size() > 0) {
        m = 1;
      } else {
        m = 0;
      }
      if (CommonUtils.a(localSet))
      {
        n = m;
        m = i1;
      }
      else if (CommonUtils.a(localArrayList3))
      {
        n = m;
        m = i1;
      }
      else if (localArrayList2.size() - localArrayList5.size() > 0)
      {
        n = m;
        m = i1;
      }
      else
      {
        i1 = 0;
        n = m;
        m = i1;
      }
    }
    else
    {
      if ((!CommonUtils.a(localSet)) && (!CommonUtils.a(localArrayList3))) {
        m = 0;
      }
      n = 0;
    }
    if ((m != 0) && (n != 0))
    {
      DialogUtil.a(this.j, 230).setMessage(this.j.getString(2131889418)).setNegativeButton(2131917392, new QfileEditBottomBar.7(this)).show();
      return;
    }
    if (m != 0)
    {
      a(localArrayList1, localSet, localArrayList2, localArrayList3, localArrayList4);
      return;
    }
    if (n != 0) {
      a(localArrayList5);
    }
  }
  
  public void a()
  {
    Object localObject1 = FMDataCache.h().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((FileManagerEntity)((Iterator)localObject1).next()).fileSize > 104857600L)
      {
        m = 1;
        break label45;
      }
    }
    int m = 0;
    label45:
    localObject1 = FMDataCache.g().iterator();
    do
    {
      n = m;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (((FileInfo)((Iterator)localObject1).next()).f() <= 104857600L);
    int n = 1;
    Object localObject2 = FMDataCache.h().iterator();
    m = 0;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
      if (((FileManagerEntity)localObject1).sendCloudUnsuccessful())
      {
        m += 1;
      }
      else if ((((FileManagerEntity)localObject1).getCloudType() != 3) && (((FileManagerEntity)localObject1).getCloudType() != 5))
      {
        if (((FileManagerEntity)localObject1).getCloudType() == 2)
        {
          if (i2 != 0)
          {
            if (!QLog.isDevelopLevel()) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("changeSelectCount nWeiYun [");
            ((StringBuilder)localObject2).append(i3);
            ((StringBuilder)localObject2).append("], Local[");
            ((StringBuilder)localObject2).append(QQFileManagerUtil.a((FileManagerEntity)localObject1));
            ((StringBuilder)localObject2).append("]");
            QLog.d("QfileEditBottomBar", 4, ((StringBuilder)localObject2).toString());
            break;
          }
          i3 += 1;
        }
        else if ((((FileManagerEntity)localObject1).getCloudType() == 6) && (!FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).getFilePath())))
        {
          if ((i2 == 0) && (i3 == 0))
          {
            i1 += 1;
          }
          else
          {
            if (!QLog.isDevelopLevel()) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("changeSelectCount nWeiYun [");
            ((StringBuilder)localObject2).append(i3);
            ((StringBuilder)localObject2).append("], Local[");
            ((StringBuilder)localObject2).append(QQFileManagerUtil.a((FileManagerEntity)localObject1));
            ((StringBuilder)localObject2).append("]");
            QLog.d("QfileEditBottomBar", 4, ((StringBuilder)localObject2).toString());
            break;
          }
        }
      }
      else
      {
        if (i3 != 0)
        {
          if (!QLog.isDevelopLevel()) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("changeSelectCount nLocal[");
          ((StringBuilder)localObject2).append(i2);
          ((StringBuilder)localObject2).append("] WeiYun [");
          ((StringBuilder)localObject2).append(QQFileManagerUtil.a((FileManagerEntity)localObject1));
          ((StringBuilder)localObject2).append("]");
          QLog.d("QfileEditBottomBar", 4, ((StringBuilder)localObject2).toString());
          break;
        }
        i2 += 1;
      }
    }
    if (FMDataCache.e() == i2) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (FMDataCache.e() == i3) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if (FMDataCache.e() == i1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (FMDataCache.e() == m) {
      m = 1;
    } else {
      m = 0;
    }
    this.c.setEnabled(i2 ^ 0x1);
    this.d.setEnabled(i3 ^ 0x1);
    this.e.setEnabled(i1 ^ 0x1);
    boolean bool;
    if ((i3 == 0) && (n == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.b.setEnabled(bool);
    if (m != 0)
    {
      this.c.setEnabled(false);
      this.d.setEnabled(false);
      this.e.setEnabled(false);
      this.b.setEnabled(false);
    }
    if (FMDataCache.e() > 0L) {
      this.f.setEnabled(true);
    } else {
      this.f.setEnabled(false);
    }
    if (FMDataCache.f())
    {
      this.c.setEnabled(false);
      this.d.setEnabled(false);
    }
  }
  
  void a(View paramView)
  {
    new ArrayList();
    int n = this.h;
    int m = 1;
    if (n != 1) {
      m = 0;
    }
    paramView = ActionSheet.create(this.k);
    paramView.addButton(2131889566, 3);
    if (this.h != 3) {
      if (m != 0) {
        paramView.setMainTitle(HardCodeUtil.a(2131896085));
      } else {
        paramView.setMainTitle(HardCodeUtil.a(2131896082));
      }
    }
    paramView.addCancelButton(2131887648);
    paramView.setOnButtonClickListener(new QfileEditBottomBar.1(this, paramView));
    paramView.show();
  }
  
  @TargetApi(19)
  protected void b()
  {
    QQBlurView localQQBlurView = this.l;
    if (localQQBlurView != null)
    {
      localQQBlurView.c();
      this.l = null;
    }
    this.l = ((QQBlurView)findViewById(2131449300));
    this.l.setVisibility(8);
  }
  
  public void c()
  {
    QQBlurView localQQBlurView = this.l;
    if (localQQBlurView != null) {
      localQQBlurView.c();
    }
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131432312) {
      i();
    } else if (m == 2131432311) {
      h();
    } else if (m == 2131432316) {
      g();
    } else if (m == 2131432313) {
      f();
    } else if (m == 2131432310) {
      b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setClickListener(IClickListenerVer51 paramIClickListenerVer51)
  {
    this.a = paramIClickListenerVer51;
  }
  
  public void setEditBtnVisible(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ImageView localImageView = this.b;
    int n = 0;
    int m;
    if (paramBoolean3) {
      m = 0;
    } else {
      m = 8;
    }
    localImageView.setVisibility(m);
    localImageView = this.c;
    if (paramBoolean1) {
      m = 0;
    } else {
      m = 8;
    }
    localImageView.setVisibility(m);
    localImageView = this.d;
    if (paramBoolean2) {
      m = 0;
    } else {
      m = 8;
    }
    localImageView.setVisibility(m);
    localImageView = this.e;
    if (paramBoolean3) {
      m = 0;
    } else {
      m = 8;
    }
    localImageView.setVisibility(m);
    localImageView = this.f;
    if (paramBoolean4) {
      m = n;
    } else {
      m = 8;
    }
    localImageView.setVisibility(m);
    b();
  }
  
  public void setTabType(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar
 * JD-Core Version:    0.7.0.1
 */