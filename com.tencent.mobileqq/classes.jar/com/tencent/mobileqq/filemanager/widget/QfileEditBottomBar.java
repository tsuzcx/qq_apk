package com.tencent.mobileqq.filemanager.widget;

import ajby;
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
import anzj;
import atqx;
import atup;
import atut;
import atyt;
import atyw;
import aukz;
import aumw;
import auna;
import aunj;
import auog;
import auoi;
import aupl;
import aupm;
import aupn;
import aupo;
import aupp;
import aupq;
import aupr;
import auxu;
import bdll;
import bdow;
import becb;
import bhlq;
import bhnv;
import bhpc;
import bjhk;
import blir;
import blji;
import bmko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
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
  private aukz jdField_a_of_type_Aukz;
  public auoi a;
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560870, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private long a(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = atyw.a().iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      FileManagerEntity localFileManagerEntity = aunj.a(localFileInfo);
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
  
  private long b(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = atyw.b().iterator();
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
    if (this.jdField_a_of_type_Auoi != null) {
      this.jdField_a_of_type_Auoi.e();
    }
  }
  
  private long c(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = atyw.d().iterator();
    long l = 0L;
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localWeiYunFileInfo.a);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localWeiYunFileInfo.a);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = aunj.a(localWeiYunFileInfo);
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localWeiYunFileInfo.a);
        if (localObject1 != null) {
          break label357;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localWeiYunFileInfo.a);
      }
    }
    label357:
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365824));
    this.b = ((ImageView)findViewById(2131365823));
    this.c = ((ImageView)findViewById(2131365828));
    this.d = ((ImageView)findViewById(2131365825));
    this.e = ((ImageView)findViewById(2131365822));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void e()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (this.jdField_a_of_type_Auoi != null) {
      this.jdField_a_of_type_Auoi.c();
    }
    atyw.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
    if (localArrayList.size() > 0) {
      auna.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692445));
    }
  }
  
  private void f()
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      aunj.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692905));
      return;
    }
    j();
    if (this.jdField_a_of_type_Auoi != null) {
      this.jdField_a_of_type_Auoi.d();
    }
    atyw.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
  }
  
  private void g()
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext)) {
      aunj.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692905));
    }
    do
    {
      do
      {
        return;
        if (!aunj.a(false, atyw.b())) {
          break;
        }
      } while (!bjhk.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 5, new aupm(this)));
      aumw.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131692326, 2131692329, new aupn(this));
      return;
      if ((atyw.c() <= atyt.a()) || (!aunj.a())) {
        break;
      }
    } while (!bjhk.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 5, new aupo(this)));
    aumw.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131692326, 2131692329, new aupp(this));
    return;
    e();
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + atyw.d().size() + "], offline[" + atyw.c().size() + "], recent[" + atyw.b().size() + "], localfile[" + atyw.a().size() + "]");
    }
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      aunj.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692905));
      return;
    }
    if (atyw.e() > atyt.a())
    {
      aunj.a(false, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new aupq(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_Auoi != null) {
      this.jdField_a_of_type_Auoi.b();
    }
    atyw.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aukz == null) {
      this.jdField_a_of_type_Aukz = new aukz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    }
    Object localObject2 = atyw.b();
    Object localObject1 = atyw.a();
    localObject2 = ((ArrayList)localObject2).iterator();
    int i = 0;
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject2).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
      if (localFileManagerEntity.nFileType == 13)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        if (!bmko.a(localFileManagerEntity.Uuid).c(str).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, str)) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      break;
      if (!bmko.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileManagerEntity, null, true))
      {
        i = 1;
        continue;
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((FileInfo)((Iterator)localObject1).next()).c();
          if ((auog.b((String)localObject2)) && (!bmko.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (String)localObject2))) {
            i = 1;
          }
        }
        if (i != 0) {
          aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131697475));
        }
        for (;;)
        {
          atyw.b();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
          return;
          auna.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131718463));
        }
      }
    }
  }
  
  private void j()
  {
    Object localObject4 = new Bundle();
    Object localObject2 = new Intent();
    Object localObject3 = new ArrayList();
    Object localObject5 = atyw.a();
    ArrayList localArrayList1 = atyw.b();
    ArrayList localArrayList2 = atyw.d();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = new ArrayList();
    int j;
    int i;
    if (becb.a(localArrayList1))
    {
      Iterator localIterator2 = localArrayList1.iterator();
      while (localIterator2.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator2.next();
        if (localFileManagerEntity.nFileType == 13) {
          ((List)localObject1).add(localFileManagerEntity);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        j = 1;
        if (!becb.a((Collection)localObject5)) {
          break label198;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i == 0) || (j == 0)) {
          break label272;
        }
        bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131692224)).setNegativeButton(2131718195, new aupr(this)).show();
        return;
        j = 0;
        break;
        label198:
        if (becb.a(localArrayList2)) {
          i = 1;
        } else if (localArrayList1.size() - ((List)localObject1).size() > 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    if (becb.a((Collection)localObject5)) {
      i = 1;
    }
    for (;;)
    {
      j = 0;
      break;
      if (becb.a(localArrayList2)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label272:
    if (i != 0) {
      if ((localObject5 == null) || (((Set)localObject5).size() <= 0)) {
        break label1064;
      }
    }
    label1064:
    for (long l1 = a((ArrayList)localObject3, localArrayList3) + 0L;; l1 = 0L)
    {
      long l2 = l1;
      if (localArrayList1 != null)
      {
        l2 = l1;
        if (localArrayList1.size() > 0) {
          l2 = l1 + b((ArrayList)localObject3, localArrayList3);
        }
      }
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        ((Intent)localObject2).putExtra("k_dataline", false);
      }
      for (l1 = l2 + c((ArrayList)localObject3, localArrayList3);; l1 = l2)
      {
        ((Bundle)localObject4).putInt("forward_type", 0);
        ((Bundle)localObject4).putParcelableArrayList("fileinfo_array", (ArrayList)localObject3);
        ((Bundle)localObject4).putBoolean("not_forward", true);
        ((Intent)localObject2).putExtra("sendMultiple", true);
        ((Bundle)localObject4).putParcelableArrayList("android.intent.extra.STREAM", localArrayList3);
        ((Intent)localObject2).putExtras((Bundle)localObject4);
        ((Intent)localObject2).putExtra("foward_editbar", true);
        ((Intent)localObject2).putExtra("forward_type", 0);
        localObject1 = anzj.a(2131708508);
        if (((ArrayList)localObject3).size() == 1) {
          localObject1 = anzj.a(2131708510) + aunj.d(((ForwardFileInfo)((ArrayList)localObject3).get(0)).d()) + anzj.a(2131708507) + auog.a(((ForwardFileInfo)((ArrayList)localObject3).get(0)).d()) + "。";
        }
        for (;;)
        {
          ((Intent)localObject2).putExtra("forward_text", (String)localObject1);
          ((Intent)localObject2).putExtra("k_favorites", false);
          auxu.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (Intent)localObject2, 103);
          return;
          if (((ArrayList)localObject3).size() > 1) {
            localObject1 = anzj.a(2131708511) + aunj.d(((ForwardFileInfo)((ArrayList)localObject3).get(0)).d()) + anzj.a(2131708512) + ((ArrayList)localObject3).size() + anzj.a(2131708513) + auog.a(l1) + "。";
          }
        }
        if (j == 0) {
          break;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A082", "0X800A082", 0, 0, "", "", "", "");
        if ((localObject1 != null) && (((List)localObject1).size() == 1))
        {
          localObject1 = (FileManagerEntity)((List)localObject1).get(0);
          try
          {
            localObject3 = new JSONObject(new String(((FileManagerEntity)localObject1).bombData));
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("forward_type", -3);
            ((Bundle)localObject1).putInt("structmsg_service_id", ((JSONObject)localObject3).getInt("structmsg_service_id"));
            ((Bundle)localObject1).putByteArray("stuctmsg_bytes", Base64.decode(((JSONObject)localObject3).getString("stuctmsg_bytes"), 0));
            ((Bundle)localObject1).putLong("structmsg_uniseq", ((JSONObject)localObject3).getLong("structmsg_uniseq"));
            ((Bundle)localObject1).putInt("accostType", ((JSONObject)localObject3).getInt("accostType"));
            ((Bundle)localObject1).putBoolean("forwardDirect", true);
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("forward_type", -3);
            ((Intent)localObject3).putExtras((Bundle)localObject1);
            ((Intent)localObject2).putExtra("forwardDirect", true);
            auxu.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (Intent)localObject3, 103);
            return;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            return;
          }
        }
        localObject2 = new ArrayList(localJSONException1.size());
        Iterator localIterator1 = localJSONException1.iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (FileManagerEntity)localIterator1.next();
          try
          {
            localObject4 = new JSONObject(new String(((FileManagerEntity)localObject3).bombData));
            localObject5 = new MessageForStructing();
            ((MessageForStructing)localObject5).structingMsg = bdow.a(Base64.decode(((JSONObject)localObject4).getString("stuctmsg_bytes"), 0));
            ((MessageForStructing)localObject5).senderuin = String.valueOf(((FileManagerEntity)localObject3).peerUin);
            ((MessageForStructing)localObject5).issend = 1;
            ((MessageForStructing)localObject5).msgtype = -2011;
            ((List)localObject2).add(localObject5);
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().a((List)localObject2);
        return;
      }
    }
  }
  
  public void a()
  {
    Object localObject = atyw.b().iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((FileManagerEntity)((Iterator)localObject).next()).fileSize <= 104857600L);
    for (int i = 1;; i = 0)
    {
      localObject = atyw.a().iterator();
      do
      {
        m = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((FileInfo)((Iterator)localObject).next()).a() <= 104857600L);
      int m = 1;
      localObject = atyw.b().iterator();
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
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + i + "] WeiYun [" + aunj.a(localFileManagerEntity) + "]");
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
      if (atyw.b() == i)
      {
        i = 1;
        if (atyw.b() != j) {
          break label628;
        }
        j = 1;
        if (atyw.b() != k) {
          break label633;
        }
        k = 1;
        if (atyw.b() != n) {
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
        if (atyw.b() <= 0L) {
          break label668;
        }
        this.e.setEnabled(true);
        label397:
        if (atyw.a())
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
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + aunj.a(localFileManagerEntity) + "]");
            break label217;
          }
          j += 1;
          i1 = i;
          i = k;
          k = i1;
          continue;
        }
        if ((localFileManagerEntity.getCloudType() == 6) && (!auog.b(localFileManagerEntity.getFilePath())))
        {
          if ((i != 0) || (j != 0))
          {
            if (!QLog.isDevelopLevel()) {
              break label217;
            }
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + aunj.a(localFileManagerEntity) + "]");
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
    paramView = (blir)blji.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
    paramView.a(2131692308, 3);
    if (this.jdField_a_of_type_Int != 3)
    {
      if (i == 0) {
        break label87;
      }
      paramView.a(anzj.a(2131708509));
    }
    for (;;)
    {
      paramView.c(2131690580);
      paramView.a(new aupl(this, paramView));
      paramView.show();
      return;
      label87:
      paramView.a(anzj.a(2131708514));
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131380590));
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
  
  public void setClickListener(auoi paramauoi)
  {
    this.jdField_a_of_type_Auoi = paramauoi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar
 * JD-Core Version:    0.7.0.1
 */