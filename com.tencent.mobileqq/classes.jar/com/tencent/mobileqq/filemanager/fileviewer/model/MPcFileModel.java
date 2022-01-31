package com.tencent.mobileqq.filemanager.fileviewer.model;

import acth;
import acti;
import actj;
import actk;
import actl;
import actm;
import actn;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.MPFileFailedView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MPcFileModel
  extends DefaultFileModel
{
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  View jdField_a_of_type_AndroidViewView = null;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new actm(this);
  private MPFileFailedView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView;
  private MPFileVerifyPwdView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler;
  QQCustomSingleButtonDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  protected String f;
  
  public MPcFileModel(BaseActivity paramBaseActivity, List paramList, int paramInt)
  {
    super(paramBaseActivity);
    if (QLog.isColorLevel()) {
      QLog.i("MPcFileModel<FileAssistant>", 1, "FileBrowserModel init: type = mpc");
    }
    a(paramList, paramInt);
  }
  
  private void a(long paramLong)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "MPFileDoDownloadWithBuildConnection mConnPCSuc false!");
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,connPcSessionId:" + paramLong + ",mEntity.uniseq:" + localFileManagerEntity.uniseq + ",mEntity.peerDin:" + localFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + localFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + localFileManagerEntity.fileName + ",mEntity.fileSize:" + localFileManagerEntity.fileSize);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_b_of_type_Boolean = true;
    paramLong = localDataLineHandler.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramLong, this.jdField_b_of_type_Int);
    if (paramLong == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
      }
      FMToastUtil.a(2131427558);
      return;
    }
    localFileManagerEntity.uniseq = paramLong;
    localFileManagerEntity.status = 2;
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.c();
    }
    m();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = new MPFileFailedView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.b();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), new actj(this), paramInt, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().addView(this.jdField_a_of_type_AndroidViewView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void e(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      this.jdField_b_of_type_Int = 1;
      return;
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public int a()
  {
    int i = e();
    int j = super.a();
    if (j != 0) {
      return j;
    }
    switch (i)
    {
    default: 
      return 1;
    }
    return 6;
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new actn(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IUploadController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController;
  }
  
  public ArrayList a()
  {
    if (!FileUtil.a(b())) {
      return new ArrayList();
    }
    return super.a();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      i = new JSONObject(paramArrayOfByte).getInt("changePwd");
      if (i == 1)
      {
        FMToastUtil.b(2131427659);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.d();
        }
        return;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          int i = 0;
        }
        FMToastUtil.a(2131427661);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.d();
    }
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      this.f = new JSONObject(paramArrayOfByte).getString("nonce");
      if (paramBoolean) {
        this.jdField_c_of_type_Int += 1;
      }
      if (this.jdField_c_of_type_Int >= 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog = new QQCustomSingleButtonDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624515);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.setContentView(2130968853);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.setTitle(2131427663);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(2131427664);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(0, 0, null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(2131427501, new actl(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.show();
      }
      if ((paramBoolean) && (this.jdField_c_of_type_Int < 3)) {
        FMToastUtil.a(2131427653);
      }
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "RelayHttpMgrInfo roomno:" + this.f);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null) {
        l();
      }
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new acth(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.addAction(MpFileConstant.d);
      localIntentFilter.addAction(MpFileConstant.g);
      localIntentFilter.setPriority(200);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new acti(this);
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler != null) {
      AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  }
  
  public String e()
  {
    return "";
  }
  
  protected void l()
  {
    n();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = new MPFileVerifyPwdView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), new actk(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().addView(this.jdField_b_of_type_AndroidViewView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void m()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeView(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = null;
    }
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = null;
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE process_CS_SERVER_OK,mConnPCSuc:" + this.jdField_a_of_type_Boolean);
    this.jdField_c_of_type_Int = 0;
    a(this.jdField_c_of_type_Long);
    Object localObject = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getContext().getSystemService("input_method");
    boolean bool = ((InputMethodManager)localObject).isActive();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) && (bool))
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.getWindowToken(), 0);
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (!this.jdField_a_of_type_Boolean)
    {
      ((FileManagerEntity)localObject).mContext = "needMPFileC2C";
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + this.jdField_a_of_type_Boolean + ",create mEntity.mContext");
    }
    for (;;)
    {
      m();
      n();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.d();
      return;
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + this.jdField_a_of_type_Boolean + "mEntity.mContext = null");
      ((FileManagerEntity)localObject).mContext = null;
    }
  }
  
  public void p()
  {
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc CS_RES_403CHECK!");
  }
  
  public void q()
  {
    this.jdField_a_of_type_Boolean = false;
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc disconnect!");
  }
  
  public void r()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mConnPCSuc:" + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      if (localDataLineHandler.a().a())
      {
        this.jdField_c_of_type_Long = localDataLineHandler.a().a(1);
        QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "MPFile doDownload() mConnPCSuc false,mConnectPcSessionId:" + this.jdField_c_of_type_Long);
      }
    }
    label298:
    do
    {
      long l;
      do
      {
        return;
        this.jdField_c_of_type_Long = localDataLineHandler.a().a(2);
        break;
        QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mEntity.uniseq:" + localFileManagerEntity.uniseq + ",mEntity.peerDin:" + localFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + localFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + localFileManagerEntity.fileName + ",mEntity.fileSize:" + localFileManagerEntity.fileSize);
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
        this.jdField_b_of_type_Boolean = true;
        l = localDataLineHandler.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize);
        if (l != -1L) {
          break label298;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
        }
        FMToastUtil.a(2131427558);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.g();
      return;
      localFileManagerEntity.uniseq = l;
      localFileManagerEntity.status = 2;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
  }
  
  public void s()
  {
    this.jdField_b_of_type_Boolean = true;
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    localDataLineHandler.a().a(localFileManagerEntity.strDataLineMPFileID);
    localFileManagerEntity.status = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel
 * JD-Core Version:    0.7.0.1
 */