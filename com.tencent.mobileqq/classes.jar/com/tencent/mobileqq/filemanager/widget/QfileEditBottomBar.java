package com.tencent.mobileqq.filemanager.widget;

import afck;
import ajyc;
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
import aouq;
import aoza;
import aoze;
import apee;
import apeh;
import aptr;
import aptv;
import apue;
import apvb;
import apvd;
import apxm;
import apxn;
import apxo;
import apxp;
import apxq;
import apxr;
import apxs;
import aqbc;
import axqw;
import axuy;
import ayfv;
import bbcv;
import bbev;
import bbgg;
import bcvm;
import bfol;
import bfoy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
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
  public apvd a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560447, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365463));
    this.b = ((ImageView)findViewById(2131365460));
    this.c = ((ImageView)findViewById(2131365465));
    this.d = ((ImageView)findViewById(2131365461));
    this.e = ((ImageView)findViewById(2131365459));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void e()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (this.jdField_a_of_type_Apvd != null) {
      this.jdField_a_of_type_Apvd.d();
    }
    apeh.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
    if (localArrayList.size() > 0)
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localArrayList.get(0);
      if (localArrayList.size() > 1) {
        aptv.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692829));
      }
    }
    else
    {
      return;
    }
    aptv.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692829));
  }
  
  private void f()
  {
    Object localObject5 = new Bundle();
    Object localObject3 = new Intent();
    long l1 = 0L;
    Object localObject4 = new ArrayList();
    Object localObject7 = apeh.a();
    Object localObject2 = apeh.b();
    Object localObject1 = apeh.d();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject6 = new ArrayList();
    Object localObject8;
    Object localObject9;
    int j;
    int i;
    if (ayfv.a((Collection)localObject2))
    {
      localObject8 = ((List)localObject2).iterator();
      while (((Iterator)localObject8).hasNext())
      {
        localObject9 = (FileManagerEntity)((Iterator)localObject8).next();
        if (((FileManagerEntity)localObject9).nFileType == 13) {
          ((List)localObject6).add(localObject9);
        }
      }
      if (((List)localObject6).size() > 0)
      {
        j = 1;
        if (!ayfv.a((Collection)localObject7)) {
          break label198;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i == 0) || (j == 0)) {
          break label272;
        }
        bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131692554)).setNegativeButton(2131719540, new apxs(this)).show();
        return;
        j = 0;
        break;
        label198:
        if (ayfv.a((Collection)localObject1)) {
          i = 1;
        } else if (((List)localObject2).size() - ((List)localObject6).size() > 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    if (ayfv.a((Collection)localObject7)) {
      i = 1;
    }
    for (;;)
    {
      j = 0;
      break;
      if (ayfv.a((Collection)localObject1)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label272:
    long l2;
    if (i != 0)
    {
      l2 = l1;
      if (localObject7 != null)
      {
        l2 = l1;
        if (((Set)localObject7).size() > 0)
        {
          localObject6 = ((Set)localObject7).iterator();
          l2 = l1;
          if (((Iterator)localObject6).hasNext())
          {
            localObject7 = (FileInfo)((Iterator)localObject6).next();
            localObject8 = apue.a((FileInfo)localObject7);
            localObject9 = new ForwardFileInfo();
            ((ForwardFileInfo)localObject9).b(10000);
            ((ForwardFileInfo)localObject9).d(((FileManagerEntity)localObject8).getCloudType());
            ((ForwardFileInfo)localObject9).b(((FileManagerEntity)localObject8).nSessionId);
            ((ForwardFileInfo)localObject9).d(((FileManagerEntity)localObject8).fileName);
            ((ForwardFileInfo)localObject9).c(((FileManagerEntity)localObject8).uniseq);
            ((ForwardFileInfo)localObject9).c(((FileManagerEntity)localObject8).WeiYunFileId);
            ((ForwardFileInfo)localObject9).d(((FileManagerEntity)localObject8).fileSize);
            ((ForwardFileInfo)localObject9).a(((FileManagerEntity)localObject8).getFilePath());
            ((ForwardFileInfo)localObject9).b(((FileManagerEntity)localObject8).Uuid);
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject8).strLargeThumPath)) {
              ((ForwardFileInfo)localObject9).f(((FileManagerEntity)localObject8).strLargeThumPath);
            }
            for (;;)
            {
              localArrayList2.add(Uri.parse(((FileInfo)localObject7).c()));
              l2 = ((ForwardFileInfo)localObject9).d();
              ((ArrayList)localObject4).add(localObject9);
              l1 = l2 + l1;
              break;
              if (!TextUtils.isEmpty(((FileManagerEntity)localObject8).strMiddleThumPath)) {
                ((ForwardFileInfo)localObject9).f(((FileManagerEntity)localObject8).strMiddleThumPath);
              } else {
                ((ForwardFileInfo)localObject9).f(((FileManagerEntity)localObject8).strThumbPath);
              }
            }
          }
        }
      }
      l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        if (((List)localObject2).size() > 0)
        {
          localObject2 = ((List)localObject2).iterator();
          l1 = l2;
          while (((Iterator)localObject2).hasNext())
          {
            localObject6 = (FileManagerEntity)((Iterator)localObject2).next();
            if ((!((FileManagerEntity)localObject6).sendCloudUnsuccessful()) && (((FileManagerEntity)localObject6).nFileType != 13))
            {
              localObject7 = new ForwardFileInfo();
              ((ForwardFileInfo)localObject7).b(10001);
              ((ForwardFileInfo)localObject7).d(((FileManagerEntity)localObject6).getCloudType());
              ((ForwardFileInfo)localObject7).b(((FileManagerEntity)localObject6).nSessionId);
              ((ForwardFileInfo)localObject7).d(((FileManagerEntity)localObject6).fileName);
              ((ForwardFileInfo)localObject7).c(((FileManagerEntity)localObject6).uniseq);
              ((ForwardFileInfo)localObject7).c(((FileManagerEntity)localObject6).WeiYunFileId);
              ((ForwardFileInfo)localObject7).d(((FileManagerEntity)localObject6).fileSize);
              ((ForwardFileInfo)localObject7).a(((FileManagerEntity)localObject6).getFilePath());
              ((ForwardFileInfo)localObject7).b(((FileManagerEntity)localObject6).Uuid);
              if (!TextUtils.isEmpty(((FileManagerEntity)localObject6).strLargeThumPath))
              {
                ((ForwardFileInfo)localObject7).f(((FileManagerEntity)localObject6).strLargeThumPath);
                label721:
                if ((((FileManagerEntity)localObject6).getCloudType() != 3) || (((FileManagerEntity)localObject6).getFilePath() == null) || (((FileManagerEntity)localObject6).getFilePath().length() <= 0)) {
                  break label823;
                }
                localArrayList2.add(Uri.parse(((FileManagerEntity)localObject6).getFilePath()));
              }
              for (;;)
              {
                l2 = ((ForwardFileInfo)localObject7).d();
                ((ArrayList)localObject4).add(localObject7);
                l1 = l2 + l1;
                break;
                if (!TextUtils.isEmpty(((FileManagerEntity)localObject6).strMiddleThumPath))
                {
                  ((ForwardFileInfo)localObject7).f(((FileManagerEntity)localObject6).strMiddleThumPath);
                  break label721;
                }
                ((ForwardFileInfo)localObject7).f(((FileManagerEntity)localObject6).strThumbPath);
                break label721;
                label823:
                localArrayList2.add(Uri.parse(""));
              }
            }
          }
        }
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        ((Intent)localObject3).putExtra("k_dataline", false);
        localObject6 = ((List)localObject1).iterator();
        label872:
        l2 = l1;
        if (!((Iterator)localObject6).hasNext()) {
          break label1225;
        }
        localObject7 = (WeiYunFileInfo)((Iterator)localObject6).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((WeiYunFileInfo)localObject7).jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((WeiYunFileInfo)localObject7).jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = apue.a((WeiYunFileInfo)localObject7);
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
        ((ArrayList)localObject4).add(localObject2);
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strLargeThumPath))
        {
          ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strLargeThumPath);
          label1090:
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((WeiYunFileInfo)localObject7).jdField_a_of_type_JavaLangString);
          if (localObject1 != null) {
            break label1918;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((WeiYunFileInfo)localObject7).jdField_a_of_type_JavaLangString);
        }
      }
    }
    label1225:
    label1918:
    for (;;)
    {
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).getFilePath() != null) && (((FileManagerEntity)localObject1).getFilePath().length() > 0))
      {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject1).getFilePath()));
        break label872;
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strMiddleThumPath))
        {
          ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strMiddleThumPath);
          break label1090;
        }
        ((ForwardFileInfo)localObject2).f(((FileManagerEntity)localObject1).strThumbPath);
        break label1090;
      }
      localArrayList2.add(Uri.parse(""));
      break label872;
      l2 = l1;
      ((Bundle)localObject5).putInt("forward_type", 0);
      ((Bundle)localObject5).putParcelableArrayList("fileinfo_array", (ArrayList)localObject4);
      ((Bundle)localObject5).putBoolean("not_forward", true);
      ((Intent)localObject3).putExtra("sendMultiple", true);
      ((Bundle)localObject5).putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
      ((Intent)localObject3).putExtras((Bundle)localObject5);
      ((Intent)localObject3).putExtra("foward_editbar", true);
      ((Intent)localObject3).putExtra("forward_type", 0);
      localObject1 = ajyc.a(2131709628);
      if (((ArrayList)localObject4).size() == 1) {
        localObject1 = ajyc.a(2131709630) + apue.d(((ForwardFileInfo)((ArrayList)localObject4).get(0)).d()) + ajyc.a(2131709627) + apvb.a(((ForwardFileInfo)((ArrayList)localObject4).get(0)).d()) + "。";
      }
      for (;;)
      {
        ((Intent)localObject3).putExtra("forward_text", (String)localObject1);
        ((Intent)localObject3).putExtra("k_favorites", false);
        aqbc.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (Intent)localObject3, 103);
        return;
        if (((ArrayList)localObject4).size() > 1) {
          localObject1 = ajyc.a(2131709631) + apue.d(((ForwardFileInfo)((ArrayList)localObject4).get(0)).d()) + ajyc.a(2131709632) + ((ArrayList)localObject4).size() + ajyc.a(2131709633) + apvb.a(l2) + "。";
        }
      }
      if (j == 0) {
        break;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A082", "0X800A082", 0, 0, "", "", "", "");
      if ((localObject6 != null) && (((List)localObject6).size() == 1))
      {
        localObject1 = (FileManagerEntity)((List)localObject6).get(0);
        try
        {
          localObject2 = new JSONObject(new String(((FileManagerEntity)localObject1).bombData));
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("forward_type", -3);
          ((Bundle)localObject1).putInt("structmsg_service_id", ((JSONObject)localObject2).getInt("structmsg_service_id"));
          ((Bundle)localObject1).putByteArray("stuctmsg_bytes", Base64.decode(((JSONObject)localObject2).getString("stuctmsg_bytes"), 0));
          ((Bundle)localObject1).putLong("structmsg_uniseq", ((JSONObject)localObject2).getLong("structmsg_uniseq"));
          ((Bundle)localObject1).putInt("accostType", ((JSONObject)localObject2).getInt("accostType"));
          ((Bundle)localObject1).putBoolean("forwardDirect", true);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("forward_type", -3);
          ((Intent)localObject2).putExtras((Bundle)localObject1);
          ((Intent)localObject3).putExtra("forwardDirect", true);
          aqbc.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (Intent)localObject2, 103);
          return;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          return;
        }
      }
      ArrayList localArrayList1 = new ArrayList(((List)localObject6).size());
      localObject2 = ((List)localObject6).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
        try
        {
          localObject4 = new JSONObject(new String(((FileManagerEntity)localObject3).bombData));
          localObject5 = new MessageForStructing();
          ((MessageForStructing)localObject5).structingMsg = axuy.a(Base64.decode(((JSONObject)localObject4).getString("stuctmsg_bytes"), 0));
          ((MessageForStructing)localObject5).senderuin = String.valueOf(((FileManagerEntity)localObject3).peerUin);
          ((MessageForStructing)localObject5).issend = 1;
          ((MessageForStructing)localObject5).msgtype = -2011;
          localArrayList1.add(localObject5);
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().a(localArrayList1);
      return;
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (apeh.b() > 0L) {}
    int m;
    int k;
    int j;
    int i;
    FileManagerEntity localFileManagerEntity;
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localObject).setEnabled(bool);
      localObject = apeh.b().iterator();
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
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + i + "] WeiYun [" + apue.a(localFileManagerEntity) + "]");
        }
        if (apeh.b() != i) {
          break label535;
        }
        i = 1;
        if (apeh.b() != j) {
          break label540;
        }
        j = 1;
        if (apeh.b() != k) {
          break label545;
        }
        k = 1;
        if (apeh.b() != m) {
          break label550;
        }
        m = 1;
        localObject = this.b;
        if (i != 0) {
          break label556;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.c;
        if (j != 0) {
          break label562;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.d;
        if (k != 0) {
          break label568;
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
        if (apeh.b() <= 0L) {
          break label574;
        }
        this.e.setEnabled(true);
        label311:
        if (apeh.a())
        {
          this.b.setEnabled(false);
          this.c.setEnabled(false);
        }
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
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + apue.a(localFileManagerEntity) + "]");
          break label160;
        }
        j += 1;
        n = i;
        i = k;
        k = n;
        continue;
      }
      if ((localFileManagerEntity.getCloudType() == 6) && (!apvb.b(localFileManagerEntity.getFilePath())))
      {
        if ((i != 0) || (j != 0))
        {
          if (!QLog.isDevelopLevel()) {
            break label160;
          }
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + apue.a(localFileManagerEntity) + "]");
          break label160;
        }
        n = k + 1;
        k = i;
        i = n;
        continue;
        label535:
        i = 0;
        break label171;
        label540:
        j = 0;
        break label182;
        label545:
        k = 0;
        break label193;
        label550:
        m = 0;
        break label206;
        label556:
        bool = false;
        break label219;
        label562:
        bool = false;
        break label239;
        label568:
        bool = false;
        break label259;
        label574:
        this.e.setEnabled(false);
        break label311;
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
    paramView = (bfol)bfoy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
    paramView.a(2131692654, 3);
    if (this.jdField_a_of_type_Int != 3)
    {
      if (i == 0) {
        break label87;
      }
      paramView.a(ajyc.a(2131709629));
    }
    for (;;)
    {
      paramView.c(2131690596);
      paramView.a(new apxm(this, paramView));
      paramView.show();
      return;
      label87:
      paramView.a(ajyc.a(2131709634));
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131378793));
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
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
          } while (this.jdField_a_of_type_Apvd == null);
          this.jdField_a_of_type_Apvd.b();
          return;
          if (QLog.isColorLevel()) {
            QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + apeh.d().size() + "], offline[" + apeh.c().size() + "], recent[" + apeh.b().size() + "], localfile[" + apeh.a().size() + "]");
          }
          if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
          {
            apue.a(this.jdField_a_of_type_AndroidContentContext.getString(2131693313));
            return;
          }
          if (apeh.e() > apee.a())
          {
            apue.a(false, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new apxn(this));
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_AndroidContentContext);
          if (this.jdField_a_of_type_Apvd != null) {
            this.jdField_a_of_type_Apvd.c();
          }
          apeh.b();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
          return;
          if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
          {
            apue.a(this.jdField_a_of_type_AndroidContentContext.getString(2131693313));
            return;
          }
          if (!apue.a(false, apeh.b())) {
            break;
          }
        } while (!bcvm.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 5, new apxo(this)));
        aptr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131692672, 2131692675, new apxp(this));
        return;
        if ((apeh.c() <= apee.a()) || (!apue.a())) {
          break;
        }
      } while (!bcvm.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 5, new apxq(this)));
      aptr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131692672, 2131692675, new apxr(this));
      return;
      e();
      return;
      if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
      {
        apue.a(this.jdField_a_of_type_AndroidContentContext.getString(2131693313));
        return;
      }
      f();
      if (this.jdField_a_of_type_Apvd != null) {
        this.jdField_a_of_type_Apvd.e();
      }
      apeh.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
      return;
      a(paramView);
    } while (this.jdField_a_of_type_Apvd == null);
    this.jdField_a_of_type_Apvd.f();
  }
  
  public void setClickListener(apvd paramapvd)
  {
    this.jdField_a_of_type_Apvd = paramapvd;
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
        break label118;
      }
      i = 0;
      label36:
      localImageView.setVisibility(i);
      localImageView = this.c;
      if (!paramBoolean3) {
        break label125;
      }
      i = 0;
      label56:
      localImageView.setVisibility(i);
      localImageView = this.d;
      if (!paramBoolean4) {
        break label132;
      }
      i = 0;
      label77:
      localImageView.setVisibility(i);
      localImageView = this.e;
      if (!paramBoolean5) {
        break label139;
      }
    }
    label132:
    label139:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      b();
      return;
      i = 8;
      break;
      label118:
      i = 8;
      break label36;
      label125:
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