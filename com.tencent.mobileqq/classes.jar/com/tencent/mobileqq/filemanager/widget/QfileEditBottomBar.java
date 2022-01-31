package com.tencent.mobileqq.filemanager.widget;

import adra;
import adrd;
import adre;
import adrf;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QfileEditBottomBar
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  public IClickListener_Ver51 a;
  final String jdField_a_of_type_JavaLangString = "QfileEditBottomBar";
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130970017, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368757));
    this.b = ((ImageView)findViewById(2131368758));
    this.c = ((ImageView)findViewById(2131368760));
    this.d = ((ImageView)findViewById(2131368759));
    this.e = ((ImageView)findViewById(2131368761));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void c()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.d();
    }
    FMDataCache.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
    if (localArrayList.size() > 0)
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localArrayList.get(0);
      if (localArrayList.size() > 1) {
        FMToastUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428195));
      }
    }
    else
    {
      return;
    }
    FMToastUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428195));
  }
  
  private void d()
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    long l2 = 0L;
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = FMDataCache.b();
    Object localObject2 = FMDataCache.c();
    Object localObject1 = FMDataCache.e();
    ArrayList localArrayList2 = new ArrayList();
    long l1 = l2;
    Object localObject4;
    if (localObject3 != null)
    {
      l1 = l2;
      if (((List)localObject3).size() > 0)
      {
        localObject3 = ((List)localObject3).iterator();
        for (l1 = 0L; ((Iterator)localObject3).hasNext(); l1 = l2 + l1)
        {
          localObject4 = (FileInfo)((Iterator)localObject3).next();
          FileManagerEntity localFileManagerEntity = FileManagerUtil.a((FileInfo)localObject4);
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
          localArrayList2.add(Uri.parse(((FileInfo)localObject4).c()));
          l2 = localForwardFileInfo.d();
          localArrayList1.add(localForwardFileInfo);
        }
      }
    }
    l2 = l1;
    if (localObject2 != null)
    {
      l2 = l1;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          if (!((FileManagerEntity)localObject3).sendCloudUnsuccessful())
          {
            localObject4 = new ForwardFileInfo();
            ((ForwardFileInfo)localObject4).b(10001);
            ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).getCloudType());
            ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject3).nSessionId);
            ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).fileName);
            ((ForwardFileInfo)localObject4).c(((FileManagerEntity)localObject3).uniseq);
            ((ForwardFileInfo)localObject4).c(((FileManagerEntity)localObject3).WeiYunFileId);
            ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).fileSize);
            ((ForwardFileInfo)localObject4).a(((FileManagerEntity)localObject3).getFilePath());
            ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject3).Uuid);
            if ((((FileManagerEntity)localObject3).getCloudType() == 3) && (((FileManagerEntity)localObject3).getFilePath() != null) && (((FileManagerEntity)localObject3).getFilePath().length() > 0)) {
              localArrayList2.add(Uri.parse(((FileManagerEntity)localObject3).getFilePath()));
            }
            for (;;)
            {
              l2 = ((ForwardFileInfo)localObject4).d();
              localArrayList1.add(localObject4);
              l1 = l2 + l1;
              break;
              localArrayList2.add(Uri.parse(""));
            }
          }
        }
        l2 = l1;
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localIntent.putExtra("k_dataline", false);
      localObject3 = ((List)localObject1).iterator();
      l1 = l2;
      l2 = l1;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (WeiYunFileInfo)((Iterator)localObject3).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((WeiYunFileInfo)localObject4).jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((WeiYunFileInfo)localObject4).jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = FileManagerUtil.a((WeiYunFileInfo)localObject4);
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
        l1 += ((ForwardFileInfo)localObject2).d();
        localArrayList1.add(localObject2);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((WeiYunFileInfo)localObject4).jdField_a_of_type_JavaLangString);
        if (localObject1 != null) {
          break label1076;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((WeiYunFileInfo)localObject4).jdField_a_of_type_JavaLangString);
      }
    }
    label1076:
    for (;;)
    {
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).getFilePath() != null) && (((FileManagerEntity)localObject1).getFilePath().length() > 0))
      {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject1).getFilePath()));
        break;
      }
      localArrayList2.add(Uri.parse(""));
      break;
      localBundle.putInt("forward_type", 0);
      localBundle.putParcelableArrayList("fileinfo_array", localArrayList1);
      localBundle.putBoolean("not_forward", true);
      localIntent.putExtra("sendMultiple", true);
      localBundle.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("foward_editbar", true);
      localIntent.putExtra("forward_type", 0);
      localObject1 = "转发文件";
      if (localArrayList1.size() == 1) {
        localObject1 = "已选择" + FileManagerUtil.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "，大小" + FileUtil.a(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
      }
      for (;;)
      {
        localIntent.putExtra("forward_text", (String)localObject1);
        localIntent.putExtra("k_favorites", false);
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localIntent, 103);
        return;
        if (localArrayList1.size() > 1) {
          localObject1 = "已选择" + FileManagerUtil.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "等" + localArrayList1.size() + "个文件，大小" + FileUtil.a(l2) + "。";
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (FMDataCache.a() > 0L) {}
    int m;
    int k;
    int j;
    int i;
    FileManagerEntity localFileManagerEntity;
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localObject).setEnabled(bool);
      localObject = FMDataCache.c().iterator();
      m = 0;
      k = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label160;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          break;
        }
        m += 1;
      }
    }
    label160:
    label171:
    label182:
    label193:
    label206:
    label219:
    label239:
    int n;
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5))
    {
      if (j != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + i + "] WeiYun [" + FileManagerUtil.a(localFileManagerEntity) + "]");
        }
        if (FMDataCache.a() != i) {
          break label513;
        }
        i = 1;
        if (FMDataCache.a() != j) {
          break label518;
        }
        j = 1;
        if (FMDataCache.a() != k) {
          break label523;
        }
        k = 1;
        if (FMDataCache.a() != m) {
          break label528;
        }
        m = 1;
        localObject = this.b;
        if (i != 0) {
          break label534;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.c;
        if (j != 0) {
          break label540;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.d;
        if (k != 0) {
          break label546;
        }
        bool = true;
        label259:
        ((ImageView)localObject).setEnabled(bool);
        if (m != 0)
        {
          this.b.setEnabled(false);
          this.c.setEnabled(false);
          this.d.setEnabled(false);
        }
        if (FMDataCache.a() <= 0L) {
          break label552;
        }
        this.e.setEnabled(true);
        return;
      }
      n = k;
      k = i + 1;
      i = n;
    }
    for (;;)
    {
      n = k;
      k = i;
      i = n;
      break;
      if (localFileManagerEntity.getCloudType() == 2)
      {
        if (i != 0)
        {
          if (!QLog.isDevelopLevel()) {
            break label160;
          }
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + FileManagerUtil.a(localFileManagerEntity) + "]");
          break label160;
        }
        j += 1;
        n = i;
        i = k;
        k = n;
        continue;
      }
      if ((localFileManagerEntity.getCloudType() == 6) && (!FileUtil.b(localFileManagerEntity.getFilePath())))
      {
        if ((i != 0) || (j != 0))
        {
          if (!QLog.isDevelopLevel()) {
            break label160;
          }
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + FileManagerUtil.a(localFileManagerEntity) + "]");
          break label160;
        }
        n = k + 1;
        k = i;
        i = n;
        continue;
        label513:
        i = 0;
        break label171;
        label518:
        j = 0;
        break label182;
        label523:
        k = 0;
        break label193;
        label528:
        m = 0;
        break label206;
        label534:
        bool = false;
        break label219;
        label540:
        bool = false;
        break label239;
        label546:
        bool = false;
        break label259;
        label552:
        this.e.setEnabled(false);
        return;
      }
      n = i;
      i = k;
      k = n;
    }
  }
  
  void a(View paramView)
  {
    new ArrayList();
    int i = 0;
    if (this.jdField_a_of_type_Int == 1) {
      i = 1;
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
    paramView.a(2131428314, 3);
    if (this.jdField_a_of_type_Int != 3)
    {
      if (i == 0) {
        break label84;
      }
      paramView.a(" 删除本地文件后将无法找回，是否继续？");
    }
    for (;;)
    {
      paramView.c(2131433029);
      paramView.a(new adra(this, paramView));
      paramView.show();
      return;
      label84:
      paramView.a("删除文件记录及云端记录");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.b();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + FMDataCache.e().size() + "], offline[" + FMDataCache.d().size() + "], recent[" + FMDataCache.c().size() + "], localfile[" + FMDataCache.b().size() + "]");
      }
      if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
      {
        FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext.getString(2131437332));
        return;
      }
      if (FMDataCache.d() > FMConfig.a())
      {
        FileManagerUtil.a(false, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new adrd(this));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.c();
      }
      FMDataCache.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
      return;
      if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
      {
        FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext.getString(2131437332));
        return;
      }
      if (FileManagerUtil.a(false, FMDataCache.c()))
      {
        FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131428241, 2131428238, new adre(this));
        return;
      }
      if ((FMDataCache.b() > FMConfig.a()) && (FileManagerUtil.a()))
      {
        FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131428241, 2131428238, new adrf(this));
        return;
      }
      c();
      return;
      if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
      {
        FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext.getString(2131437332));
        return;
      }
      d();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.e();
      }
      FMDataCache.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
      return;
      a(paramView);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.f();
  }
  
  public void setClickListener(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
  }
  
  public void setEditBtnVisible(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    int j = 0;
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean1)
    {
      i = 0;
      localImageView.setVisibility(i);
      localImageView = this.b;
      if (!paramBoolean2) {
        break label114;
      }
      i = 0;
      label36:
      localImageView.setVisibility(i);
      localImageView = this.c;
      if (!paramBoolean3) {
        break label121;
      }
      i = 0;
      label56:
      localImageView.setVisibility(i);
      localImageView = this.d;
      if (!paramBoolean4) {
        break label128;
      }
      i = 0;
      label77:
      localImageView.setVisibility(i);
      localImageView = this.e;
      if (!paramBoolean5) {
        break label135;
      }
    }
    label128:
    label135:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
      i = 8;
      break;
      label114:
      i = 8;
      break label36;
      label121:
      i = 8;
      break label56;
      i = 8;
      break label77;
    }
  }
  
  public void setTabType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar
 * JD-Core Version:    0.7.0.1
 */