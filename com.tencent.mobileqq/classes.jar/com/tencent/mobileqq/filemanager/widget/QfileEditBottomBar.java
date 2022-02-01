package com.tencent.mobileqq.filemanager.widget;

import ahwi;
import amtj;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import asdg;
import asgz;
import ashd;
import asld;
import aslg;
import asxj;
import aszg;
import aszk;
import aszt;
import ataq;
import atbt;
import atbu;
import atbv;
import atbw;
import atbx;
import atby;
import atbz;
import atky;
import bcef;
import bchh;
import bcvs;
import bfur;
import bhnb;
import bjnw;
import bjon;
import bkov;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class QfileEditBottomBar
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private asxj jdField_a_of_type_Asxj;
  public ataq a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560750, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private long a(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = aslg.a().iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      FileManagerEntity localFileManagerEntity = aszt.a(localFileInfo);
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
      }
      for (;;)
      {
        paramArrayList1.add(Uri.parse(localFileInfo.c()));
        long l2 = localForwardFileInfo.d();
        paramArrayList.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath)) {
          localForwardFileInfo.f(localFileManagerEntity.strMiddleThumPath);
        } else {
          localForwardFileInfo.f(localFileManagerEntity.strThumbPath);
        }
      }
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
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      localIntent.putExtra("k_dataline", false);
    }
    for (l1 = l2 + c(paramArrayList, paramArrayList1);; l1 = l2)
    {
      localBundle.putInt("forward_type", 0);
      localBundle.putParcelableArrayList("fileinfo_array", paramArrayList);
      localBundle.putBoolean("not_forward", true);
      localIntent.putExtra("sendMultiple", true);
      localBundle.putParcelableArrayList("android.intent.extra.STREAM", paramArrayList1);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("foward_editbar", true);
      localIntent.putExtra("forward_type", 0);
      paramSet = amtj.a(2131708740);
      if (paramArrayList.size() == 1) {
        paramSet = amtj.a(2131708742) + aszt.d(((ForwardFileInfo)paramArrayList.get(0)).d()) + amtj.a(2131708739) + FileUtil.filesizeToString(((ForwardFileInfo)paramArrayList.get(0)).d()) + "。";
      }
      for (;;)
      {
        localIntent.putExtra("forward_text", paramSet);
        localIntent.putExtra("k_favorites", false);
        atky.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localIntent, 103);
        return;
        if (paramArrayList.size() > 1) {
          paramSet = amtj.a(2131708743) + aszt.d(((ForwardFileInfo)paramArrayList.get(0)).d()) + amtj.a(2131708744) + paramArrayList.size() + amtj.a(2131708745) + FileUtil.filesizeToString(l1) + "。";
        }
      }
    }
  }
  
  private void a(List<FileManagerEntity> paramList)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A082", "0X800A082", 0, 0, "", "", "", "");
    if ((paramList != null) && (paramList.size() == 1))
    {
      paramList = (FileManagerEntity)paramList.get(0);
      try
      {
        localObject = new JSONObject(new String(paramList.bombData));
        paramList = new Bundle();
        paramList.putInt("forward_type", -3);
        paramList.putInt("structmsg_service_id", ((JSONObject)localObject).getInt("structmsg_service_id"));
        paramList.putByteArray("stuctmsg_bytes", Base64.decode(((JSONObject)localObject).getString("stuctmsg_bytes"), 0));
        paramList.putLong("structmsg_uniseq", ((JSONObject)localObject).getLong("structmsg_uniseq"));
        paramList.putInt("accostType", ((JSONObject)localObject).getInt("accostType"));
        paramList.putBoolean("forwardDirect", true);
        localObject = new Intent();
        ((Intent)localObject).putExtra("forward_type", -3);
        ((Intent)localObject).putExtras(paramList);
        atky.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (Intent)localObject, 103);
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        return;
      }
    }
    Object localObject = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
      try
      {
        JSONObject localJSONObject = new JSONObject(new String(localFileManagerEntity.bombData));
        MessageForStructing localMessageForStructing = new MessageForStructing();
        localMessageForStructing.structingMsg = bchh.a(Base64.decode(localJSONObject.getString("stuctmsg_bytes"), 0));
        localMessageForStructing.senderuin = String.valueOf(localFileManagerEntity.peerUin);
        localMessageForStructing.issend = 1;
        localMessageForStructing.msgtype = -2011;
        ((List)localObject).add(localMessageForStructing);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().a((List)localObject);
  }
  
  private long b(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = aslg.b().iterator();
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
        if (!TextUtils.isEmpty(localFileManagerEntity.strLargeThumPath))
        {
          localForwardFileInfo.f(localFileManagerEntity.strLargeThumPath);
          label170:
          if ((localFileManagerEntity.getCloudType() != 3) || (localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() <= 0)) {
            break label270;
          }
          paramArrayList1.add(Uri.parse(localFileManagerEntity.getFilePath()));
        }
        for (;;)
        {
          long l2 = localForwardFileInfo.d();
          paramArrayList.add(localForwardFileInfo);
          l1 = l2 + l1;
          break;
          if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath))
          {
            localForwardFileInfo.f(localFileManagerEntity.strMiddleThumPath);
            break label170;
          }
          localForwardFileInfo.f(localFileManagerEntity.strThumbPath);
          break label170;
          label270:
          paramArrayList1.add(Uri.parse(""));
        }
      }
    }
    return l1;
  }
  
  private void b(View paramView)
  {
    a(paramView);
    if (this.jdField_a_of_type_Ataq != null) {
      this.jdField_a_of_type_Ataq.e();
    }
  }
  
  private long c(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = aslg.d().iterator();
    long l = 0L;
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(localWeiYunFileInfo.a);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localWeiYunFileInfo.a);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = aszt.a(localWeiYunFileInfo);
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
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strLargeThumPath))
      {
        ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strLargeThumPath);
        label226:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(localWeiYunFileInfo.a);
        if (localObject1 != null) {
          break label358;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localWeiYunFileInfo.a);
      }
    }
    label358:
    for (;;)
    {
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).getFilePath() != null) && (((FileManagerEntity)localObject1).getFilePath().length() > 0))
      {
        paramArrayList1.add(Uri.parse(((FileManagerEntity)localObject1).getFilePath()));
        break;
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strMiddleThumPath))
        {
          ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strMiddleThumPath);
          break label226;
        }
        ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strThumbPath);
        break label226;
      }
      paramArrayList1.add(Uri.parse(""));
      break;
      return l;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365856));
    this.b = ((ImageView)findViewById(2131365855));
    this.c = ((ImageView)findViewById(2131365860));
    this.d = ((ImageView)findViewById(2131365857));
    this.e = ((ImageView)findViewById(2131365854));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void e()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a();
    if (this.jdField_a_of_type_Ataq != null) {
      this.jdField_a_of_type_Ataq.c();
    }
    aslg.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
    if (localArrayList.size() > 0) {
      aszk.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692493));
    }
  }
  
  private void f()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      aszt.c(this.jdField_a_of_type_AndroidContentContext.getString(2131692955));
      return;
    }
    j();
    if (this.jdField_a_of_type_Ataq != null) {
      this.jdField_a_of_type_Ataq.d();
    }
    aslg.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) {
      aszt.c(this.jdField_a_of_type_AndroidContentContext.getString(2131692955));
    }
    do
    {
      do
      {
        return;
        if (!aszt.a(false, aslg.b())) {
          break;
        }
      } while (!bhnb.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 5, new atbu(this)));
      aszg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131692374, 2131692377, new atbv(this));
      return;
      if ((aslg.c() <= asld.a()) || (!aszt.a())) {
        break;
      }
    } while (!bhnb.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 5, new atbw(this)));
    aszg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131692374, 2131692377, new atbx(this));
    return;
    e();
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + aslg.d().size() + "], offline[" + aslg.c().size() + "], recent[" + aslg.b().size() + "], localfile[" + aslg.a().size() + "]");
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      aszt.c(this.jdField_a_of_type_AndroidContentContext.getString(2131692955));
      return;
    }
    if (aslg.e() > asld.a())
    {
      aszt.a(false, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new atby(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_Ataq != null) {
      this.jdField_a_of_type_Ataq.b();
    }
    aslg.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Asxj == null) {
      this.jdField_a_of_type_Asxj = new asxj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    }
    Object localObject2 = aslg.b();
    Object localObject1 = aslg.a();
    localObject2 = ((ArrayList)localObject2).iterator();
    int i = 0;
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject2).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
      if (localFileManagerEntity.nFileType == 13)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        if (!bkov.a(localFileManagerEntity.Uuid).c(str).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, str)) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      break;
      if (!bkov.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileManagerEntity, null, true))
      {
        i = 1;
        continue;
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((FileInfo)((Iterator)localObject1).next()).c();
          if ((FileUtil.fileExistsAndNotEmpty((String)localObject2)) && (!bkov.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (String)localObject2))) {
            i = 1;
          }
        }
        if (i != 0) {
          aszt.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131697621));
        }
        for (;;)
        {
          aslg.b();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
          return;
          aszk.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131718711));
        }
      }
    }
  }
  
  private void j()
  {
    int j = 1;
    int m = 1;
    ArrayList localArrayList1 = new ArrayList();
    Set localSet = aslg.a();
    ArrayList localArrayList2 = aslg.b();
    ArrayList localArrayList3 = aslg.d();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    int i;
    int k;
    if (bcvs.a(localArrayList2))
    {
      Iterator localIterator = localArrayList2.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (localFileManagerEntity.nFileType == 13) {
          localArrayList5.add(localFileManagerEntity);
        }
      }
      if (localArrayList5.size() > 0)
      {
        i = 1;
        if (!bcvs.a(localSet)) {
          break label188;
        }
        j = m;
        k = i;
        label134:
        if ((j == 0) || (k == 0)) {
          break label257;
        }
        bfur.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131692272)).setNegativeButton(2131718436, new atbz(this)).show();
      }
    }
    label188:
    do
    {
      return;
      i = 0;
      break;
      k = i;
      j = m;
      if (bcvs.a(localArrayList3)) {
        break label134;
      }
      k = i;
      j = m;
      if (localArrayList2.size() - localArrayList5.size() > 0) {
        break label134;
      }
      j = 0;
      k = i;
      break label134;
      if (bcvs.a(localSet)) {}
      for (;;)
      {
        k = 0;
        break;
        if (!bcvs.a(localArrayList3)) {
          j = 0;
        }
      }
      if (j != 0)
      {
        a(localArrayList1, localSet, localArrayList2, localArrayList3, localArrayList4);
        return;
      }
    } while (k == 0);
    label257:
    a(localArrayList5);
  }
  
  public void a()
  {
    Object localObject = aslg.b().iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((FileManagerEntity)((Iterator)localObject).next()).fileSize <= 104857600L);
    for (int i = 1;; i = 0)
    {
      localObject = aslg.a().iterator();
      do
      {
        m = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((FileInfo)((Iterator)localObject).next()).a() <= 104857600L);
      int m = 1;
      localObject = aslg.b().iterator();
      int n = 0;
      int k = 0;
      int j = 0;
      i = 0;
      FileManagerEntity localFileManagerEntity;
      while (((Iterator)localObject).hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if (localFileManagerEntity.sendCloudUnsuccessful())
        {
          n += 1;
        }
        else
        {
          if ((localFileManagerEntity.getCloudType() != 3) && (localFileManagerEntity.getCloudType() != 5)) {
            break label441;
          }
          if (j == 0) {
            break label420;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + i + "] WeiYun [" + aszt.a(localFileManagerEntity) + "]");
          }
        }
      }
      label217:
      label228:
      label239:
      label250:
      boolean bool;
      label263:
      label276:
      label296:
      label316:
      label335:
      int i1;
      if (aslg.b() == i)
      {
        i = 1;
        if (aslg.b() != j) {
          break label628;
        }
        j = 1;
        if (aslg.b() != k) {
          break label633;
        }
        k = 1;
        if (aslg.b() != n) {
          break label638;
        }
        n = 1;
        localObject = this.b;
        if (i != 0) {
          break label644;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.c;
        if (j != 0) {
          break label650;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.d;
        if (k != 0) {
          break label656;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        if ((j != 0) || (m != 0)) {
          break label662;
        }
        bool = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(bool);
        if (n != 0)
        {
          this.b.setEnabled(false);
          this.c.setEnabled(false);
          this.d.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        }
        if (aslg.b() <= 0L) {
          break label668;
        }
        this.e.setEnabled(true);
        label397:
        if (aslg.a())
        {
          this.b.setEnabled(false);
          this.c.setEnabled(false);
        }
        return;
        label420:
        i1 = k;
        k = i + 1;
        i = i1;
      }
      for (;;)
      {
        i1 = k;
        k = i;
        i = i1;
        break;
        label441:
        if (localFileManagerEntity.getCloudType() == 2)
        {
          if (i != 0)
          {
            if (!QLog.isDevelopLevel()) {
              break label217;
            }
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + aszt.a(localFileManagerEntity) + "]");
            break label217;
          }
          j += 1;
          i1 = i;
          i = k;
          k = i1;
          continue;
        }
        if ((localFileManagerEntity.getCloudType() == 6) && (!FileUtil.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())))
        {
          if ((i != 0) || (j != 0))
          {
            if (!QLog.isDevelopLevel()) {
              break label217;
            }
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + aszt.a(localFileManagerEntity) + "]");
            break label217;
          }
          i1 = k + 1;
          k = i;
          i = i1;
          continue;
          i = 0;
          break label228;
          label628:
          j = 0;
          break label239;
          label633:
          k = 0;
          break label250;
          label638:
          n = 0;
          break label263;
          label644:
          bool = false;
          break label276;
          label650:
          bool = false;
          break label296;
          label656:
          bool = false;
          break label316;
          label662:
          bool = false;
          break label335;
          label668:
          this.e.setEnabled(false);
          break label397;
        }
        i1 = i;
        i = k;
        k = i1;
      }
    }
  }
  
  void a(View paramView)
  {
    new ArrayList();
    int i = 0;
    if (this.jdField_a_of_type_Int == 1) {
      i = 1;
    }
    paramView = (bjnw)bjon.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
    paramView.a(2131692356, 3);
    if (this.jdField_a_of_type_Int != 3)
    {
      if (i == 0) {
        break label87;
      }
      paramView.a(amtj.a(2131708741));
    }
    for (;;)
    {
      paramView.c(2131690620);
      paramView.a(new atbt(this, paramView));
      paramView.show();
      return;
      label87:
      paramView.a(amtj.a(2131708746));
    }
  }
  
  @TargetApi(19)
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131380315));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i();
      continue;
      h();
      continue;
      g();
      continue;
      f();
      continue;
      b(paramView);
    }
  }
  
  public void setClickListener(ataq paramataq)
  {
    this.jdField_a_of_type_Ataq = paramataq;
  }
  
  public void setEditBtnVisible(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int j = 0;
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean3)
    {
      i = 0;
      localImageView.setVisibility(i);
      localImageView = this.b;
      if (!paramBoolean1) {
        break label117;
      }
      i = 0;
      label36:
      localImageView.setVisibility(i);
      localImageView = this.c;
      if (!paramBoolean2) {
        break label124;
      }
      i = 0;
      label56:
      localImageView.setVisibility(i);
      localImageView = this.d;
      if (!paramBoolean3) {
        break label131;
      }
      i = 0;
      label76:
      localImageView.setVisibility(i);
      localImageView = this.e;
      if (!paramBoolean4) {
        break label138;
      }
    }
    label131:
    label138:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      b();
      return;
      i = 8;
      break;
      label117:
      i = 8;
      break label36;
      label124:
      i = 8;
      break label56;
      i = 8;
      break label76;
    }
  }
  
  public void setTabType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar
 * JD-Core Version:    0.7.0.1
 */