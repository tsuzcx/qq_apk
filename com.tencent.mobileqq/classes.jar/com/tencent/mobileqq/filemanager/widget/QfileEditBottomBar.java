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
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  IClickListenerVer51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = null;
  ImageView b;
  ImageView c;
  ImageView d;
  ImageView e;
  
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560775, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private long a(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = FMDataCache.a().iterator();
    long l = 0L;
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
      paramArrayList1.add(Uri.parse(localFileInfo.c()));
      l += localForwardFileInfo.d();
      paramArrayList.add(localForwardFileInfo);
    }
    return l;
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
    paramSet = HardCodeUtil.a(2131698201);
    if (paramArrayList.size() == 1)
    {
      paramSet = new StringBuilder();
      paramSet.append(HardCodeUtil.a(2131698170));
      paramSet.append(QQFileManagerUtil.b(((ForwardFileInfo)paramArrayList.get(0)).d()));
      paramSet.append(HardCodeUtil.a(2131698173));
      paramSet.append(FileUtil.a(((ForwardFileInfo)paramArrayList.get(0)).d()));
      paramSet.append("。");
      paramSet = paramSet.toString();
    }
    else if (paramArrayList.size() > 1)
    {
      paramSet = new StringBuilder();
      paramSet.append(HardCodeUtil.a(2131698170));
      paramSet.append(QQFileManagerUtil.b(((ForwardFileInfo)paramArrayList.get(0)).d()));
      paramSet.append(HardCodeUtil.a(2131698172));
      paramSet.append(paramArrayList.size());
      paramSet.append(HardCodeUtil.a(2131698171));
      paramSet.append(FileUtil.a(l2));
      paramSet.append("。");
      paramSet = paramSet.toString();
    }
    localIntent.putExtra("forward_text", paramSet);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startForwardByOriginFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localIntent, bool);
  }
  
  private void a(List<FileManagerEntity> paramList)
  {
    ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).forwardTencentDocs(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramList, new QfileEditBottomBar.8(this));
  }
  
  private long b(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = FMDataCache.b().iterator();
    long l = 0L;
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
        l += localForwardFileInfo.d();
        paramArrayList.add(localForwardFileInfo);
      }
    }
    return l;
  }
  
  private void b(View paramView)
  {
    a(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51;
    if (paramView != null) {
      paramView.e();
    }
  }
  
  private long c(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Object localObject1 = FMDataCache.d();
    IQQFileEngine localIQQFileEngine = (IQQFileEngine)((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IQQFileEngine.class);
    IQQFileDataCenter localIQQFileDataCenter = (IQQFileDataCenter)((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IQQFileDataCenter.class);
    Iterator localIterator = ((List)localObject1).iterator();
    long l = 0L;
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
      l += ((ForwardFileInfo)localObject2).d();
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
    return l;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366036));
    this.b = ((ImageView)findViewById(2131366035));
    this.c = ((ImageView)findViewById(2131366040));
    this.d = ((ImageView)findViewById(2131366037));
    this.e = ((ImageView)findViewById(2131366034));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void e()
  {
    ArrayList localArrayList = ((IQQFileEngine)((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IQQFileEngine.class)).saveAllSelectFileToWeiYun();
    IClickListenerVer51 localIClickListenerVer51 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51;
    if (localIClickListenerVer51 != null) {
      localIClickListenerVer51.c();
    }
    FMDataCache.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
    if (localArrayList.size() > 0) {
      FMToastUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692690));
    }
  }
  
  private void f()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext.getString(2131698210));
      return;
    }
    j();
    IClickListenerVer51 localIClickListenerVer51 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51;
    if (localIClickListenerVer51 != null) {
      localIClickListenerVer51.d();
    }
    FMDataCache.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext.getString(2131698210));
      return;
    }
    if (QQFileManagerUtil.a(false, FMDataCache.b()))
    {
      if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new QfileEditBottomBar.2(this))) {
        FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698196, 2131692564, new QfileEditBottomBar.3(this));
      }
    }
    else if ((FMDataCache.c() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()) && (QQFileManagerUtil.a()))
    {
      if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new QfileEditBottomBar.4(this))) {
        FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698196, 2131692564, new QfileEditBottomBar.5(this));
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
      ((StringBuilder)localObject).append(FMDataCache.d().size());
      ((StringBuilder)localObject).append("], offline[");
      ((StringBuilder)localObject).append(FMDataCache.c().size());
      ((StringBuilder)localObject).append("], recent[");
      ((StringBuilder)localObject).append(FMDataCache.b().size());
      ((StringBuilder)localObject).append("], localfile[");
      ((StringBuilder)localObject).append(FMDataCache.a().size());
      ((StringBuilder)localObject).append("]");
      QLog.i("QfileEditBottomBar", 2, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext.getString(2131698210));
      return;
    }
    if (FMDataCache.e() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize())
    {
      QQFileManagerUtil.a(false, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new QfileEditBottomBar.6(this));
      return;
    }
    ((IQQFileEngine)((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IQQFileEngine.class)).downLoadAllSelectFiles(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51;
    if (localObject != null) {
      ((IClickListenerVer51)localObject).b();
    }
    FMDataCache.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
  }
  
  private void i()
  {
    Object localObject2 = FMDataCache.b();
    Object localObject1 = FMDataCache.a();
    localObject2 = ((ArrayList)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
      if (localFileManagerEntity.nFileType == 13)
      {
        this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin();
        if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favBuilderNewLink(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileManagerEntity.Uuid)) {
          break;
        }
      }
      else
      {
        for (;;)
        {
          i = 1;
          break;
          if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favBuilderNewFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileManagerEntity)) {
            break;
          }
        }
      }
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((FileInfo)((Iterator)localObject1).next()).c();
      if ((FileUtils.fileExistsAndNotEmpty((String)localObject2)) && (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).favBuilderNewFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (String)localObject2))) {
        i = 1;
      }
    }
    if (i != 0) {
      FMToastUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131698195));
    } else {
      FMToastUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131719359));
    }
    FMDataCache.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
  }
  
  private void j()
  {
    ArrayList localArrayList1 = new ArrayList();
    Set localSet = FMDataCache.a();
    ArrayList localArrayList2 = FMDataCache.b();
    ArrayList localArrayList3 = FMDataCache.d();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    boolean bool = CommonUtils.a(localArrayList2);
    int k = 1;
    int i = 1;
    int j;
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
        i = 1;
      } else {
        i = 0;
      }
      if (CommonUtils.a(localSet))
      {
        j = i;
        i = k;
      }
      else if (CommonUtils.a(localArrayList3))
      {
        j = i;
        i = k;
      }
      else if (localArrayList2.size() - localArrayList5.size() > 0)
      {
        j = i;
        i = k;
      }
      else
      {
        k = 0;
        j = i;
        i = k;
      }
    }
    else
    {
      if ((!CommonUtils.a(localSet)) && (!CommonUtils.a(localArrayList3))) {
        i = 0;
      }
      j = 0;
    }
    if ((i != 0) && (j != 0))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131692430)).setNegativeButton(2131719788, new QfileEditBottomBar.7(this)).show();
      return;
    }
    if (i != 0)
    {
      a(localArrayList1, localSet, localArrayList2, localArrayList3, localArrayList4);
      return;
    }
    if (j != 0) {
      a(localArrayList5);
    }
  }
  
  public void a()
  {
    Object localObject1 = FMDataCache.b().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((FileManagerEntity)((Iterator)localObject1).next()).fileSize > 104857600L)
      {
        i = 1;
        break label45;
      }
    }
    int i = 0;
    label45:
    localObject1 = FMDataCache.a().iterator();
    do
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (((FileInfo)((Iterator)localObject1).next()).a() <= 104857600L);
    int j = 1;
    Object localObject2 = FMDataCache.b().iterator();
    i = 0;
    int m = 0;
    int n = 0;
    int k = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
      if (((FileManagerEntity)localObject1).sendCloudUnsuccessful())
      {
        i += 1;
      }
      else if ((((FileManagerEntity)localObject1).getCloudType() != 3) && (((FileManagerEntity)localObject1).getCloudType() != 5))
      {
        if (((FileManagerEntity)localObject1).getCloudType() == 2)
        {
          if (m != 0)
          {
            if (!QLog.isDevelopLevel()) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("changeSelectCount nWeiYun [");
            ((StringBuilder)localObject2).append(n);
            ((StringBuilder)localObject2).append("], Local[");
            ((StringBuilder)localObject2).append(QQFileManagerUtil.a((FileManagerEntity)localObject1));
            ((StringBuilder)localObject2).append("]");
            QLog.d("QfileEditBottomBar", 4, ((StringBuilder)localObject2).toString());
            break;
          }
          n += 1;
        }
        else if ((((FileManagerEntity)localObject1).getCloudType() == 6) && (!FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).getFilePath())))
        {
          if ((m == 0) && (n == 0))
          {
            k += 1;
          }
          else
          {
            if (!QLog.isDevelopLevel()) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("changeSelectCount nWeiYun [");
            ((StringBuilder)localObject2).append(n);
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
        if (n != 0)
        {
          if (!QLog.isDevelopLevel()) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("changeSelectCount nLocal[");
          ((StringBuilder)localObject2).append(m);
          ((StringBuilder)localObject2).append("] WeiYun [");
          ((StringBuilder)localObject2).append(QQFileManagerUtil.a((FileManagerEntity)localObject1));
          ((StringBuilder)localObject2).append("]");
          QLog.d("QfileEditBottomBar", 4, ((StringBuilder)localObject2).toString());
          break;
        }
        m += 1;
      }
    }
    if (FMDataCache.b() == m) {
      m = 1;
    } else {
      m = 0;
    }
    if (FMDataCache.b() == n) {
      n = 1;
    } else {
      n = 0;
    }
    if (FMDataCache.b() == k) {
      k = 1;
    } else {
      k = 0;
    }
    if (FMDataCache.b() == i) {
      i = 1;
    } else {
      i = 0;
    }
    this.b.setEnabled(m ^ 0x1);
    this.c.setEnabled(n ^ 0x1);
    this.d.setEnabled(k ^ 0x1);
    boolean bool;
    if ((n == 0) && (j == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(bool);
    if (i != 0)
    {
      this.b.setEnabled(false);
      this.c.setEnabled(false);
      this.d.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    if (FMDataCache.b() > 0L) {
      this.e.setEnabled(true);
    } else {
      this.e.setEnabled(false);
    }
    if (FMDataCache.a())
    {
      this.b.setEnabled(false);
      this.c.setEnabled(false);
    }
  }
  
  void a(View paramView)
  {
    new ArrayList();
    int j = this.jdField_a_of_type_Int;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    paramView = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    paramView.addButton(2131692543, 3);
    if (this.jdField_a_of_type_Int != 3) {
      if (i != 0) {
        paramView.setMainTitle(HardCodeUtil.a(2131698184));
      } else {
        paramView.setMainTitle(HardCodeUtil.a(2131698181));
      }
    }
    paramView.addCancelButton(2131690728);
    paramView.setOnButtonClickListener(new QfileEditBottomBar.1(this, paramView));
    paramView.show();
  }
  
  @TargetApi(19)
  protected void b()
  {
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localQQBlurView != null)
    {
      localQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131380356));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
  }
  
  public void c()
  {
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localQQBlurView != null) {
      localQQBlurView.c();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131366036) {
      i();
    } else if (i == 2131366035) {
      h();
    } else if (i == 2131366040) {
      g();
    } else if (i == 2131366037) {
      f();
    } else if (i == 2131366034) {
      b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setClickListener(IClickListenerVer51 paramIClickListenerVer51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = paramIClickListenerVer51;
  }
  
  public void setEditBtnVisible(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int j = 0;
    int i;
    if (paramBoolean3) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    localImageView = this.b;
    if (paramBoolean1) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    localImageView = this.c;
    if (paramBoolean2) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    localImageView = this.d;
    if (paramBoolean3) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    localImageView = this.e;
    if (paramBoolean4) {
      i = j;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    b();
  }
  
  public void setTabType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar
 * JD-Core Version:    0.7.0.1
 */