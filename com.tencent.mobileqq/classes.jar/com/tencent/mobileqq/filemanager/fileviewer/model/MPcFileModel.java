package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.activity.MPFileFailedView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.DefaultFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.LocalFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
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
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  View jdField_a_of_type_AndroidViewView = null;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new MPcFileModel.5(this);
  private MPFileFailedView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = null;
  private MPFileVerifyPwdView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  QQCustomSingleButtonDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private int d = 0;
  protected String g;
  
  public MPcFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("MPcFileModel<FileAssistant>", 1, "FileBrowserModel init: type = mpc");
    }
    a(paramList, paramInt);
  }
  
  private void a(long paramLong)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "MPFileDoDownloadWithBuildConnection mConnPCSuc false!");
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CLOUD_TYPE_DATALINEMPFILE doDownload,connPcSessionId:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",mEntity.uniseq:");
    localStringBuilder.append(localFileManagerEntity.uniseq);
    localStringBuilder.append(",mEntity.peerDin:");
    localStringBuilder.append(localFileManagerEntity.peerDin);
    localStringBuilder.append(",mEntity.strDataLineMPFileID:");
    localStringBuilder.append(localFileManagerEntity.strDataLineMPFileID);
    localStringBuilder.append(" ,mEntity.fileName:");
    localStringBuilder.append(localFileManagerEntity.fileName);
    localStringBuilder.append(",mEntity.fileSize:");
    localStringBuilder.append(localFileManagerEntity.fileSize);
    QLog.d("MPcFileModel<FileAssistant>", 2, localStringBuilder.toString());
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_b_of_type_Boolean = true;
    paramLong = localDataLineHandler.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramLong, this.jdField_c_of_type_Int);
    if (paramLong == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
      }
      FMToastUtil.a(2131693760);
      return;
    }
    localFileManagerEntity.uniseq = paramLong;
    localFileManagerEntity.status = 2;
  }
  
  private void g(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
    if (localObject != null) {
      ((MPFileVerifyPwdView)localObject).c();
    }
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = new MPFileFailedView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.b();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), new MPcFileModel.2(this), paramInt, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().addView(this.jdField_a_of_type_AndroidViewView);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void h(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public int a()
  {
    int i = e();
    int j = super.a();
    if (j != 0) {
      return j;
    }
    if (i != 0) {
      return 1;
    }
    return 6;
  }
  
  public IServiceInfo a()
  {
    String str = d();
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      return new LocalFileColorNoteServiceInfo(str);
    }
    return new DefaultFileColorNoteServiceInfo();
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new MPcFileModel.6(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IUploadController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new MPcFileModel.DataLineMPReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.addAction(MpFileConstant.d);
      localIntentFilter.addAction(MpFileConstant.g);
      localIntentFilter.setPriority(200);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new MPcFileModel.1(this);
      AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    int i;
    try
    {
      i = new JSONObject(paramArrayOfByte).getInt("changePwd");
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      i = 0;
    }
    if (i == 1)
    {
      FMToastUtil.b(2131694231);
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.d();
      }
    }
    else
    {
      FMToastUtil.a(2131694230);
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.d();
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      this.g = new JSONObject(paramArrayOfByte).getString("nonce");
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    if (paramBoolean) {
      this.d += 1;
    }
    if (this.d >= 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog = new QQCustomSingleButtonDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.setContentView(2131558980);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.setTitle(2131694242);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(2131694241);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(0, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(2131693747, new MPcFileModel.4(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.show();
    }
    if ((paramBoolean) && (this.d < 3)) {
      FMToastUtil.a(2131694284);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("RelayHttpMgrInfo roomno:");
    paramArrayOfByte.append(this.g);
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, paramArrayOfByte.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null) {
      d();
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (!FileUtil.b(d())) {
      return null;
    }
    return super.a();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    INetEventHandler localINetEventHandler = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler;
    if (localINetEventHandler != null) {
      AppNetConnInfo.unregisterNetEventHandler(localINetEventHandler);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  }
  
  protected void d()
  {
    q();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = new MPFileVerifyPwdView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), new MPcFileModel.3(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().addView(this.jdField_b_of_type_AndroidViewView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public String h()
  {
    return "";
  }
  
  public int j()
  {
    int i = e();
    int j = 1;
    if ((i != 0) && (i != 2) && (i != 13)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0;
    }
    if (FileUtils.fileExistsAndNotEmpty(d()))
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.e()) {
          return 2;
        }
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public void p()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeView(this.jdField_b_of_type_AndroidViewView);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
    if (localObject != null)
    {
      ((MPFileVerifyPwdView)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = null;
    }
  }
  
  protected void q()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeView(this.jdField_a_of_type_AndroidViewView);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView;
    if (localObject != null)
    {
      ((MPFileFailedView)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = null;
    }
  }
  
  public void r()
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("CLOUD_TYPE_DATALINEMPFILE process_CS_SERVER_OK,mConnPCSuc:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
    QLog.d("MPcFileModel<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    this.d = 0;
    a(this.jdField_c_of_type_Long);
    localObject1 = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getContext().getSystemService("input_method");
    boolean bool = ((InputMethodManager)localObject1).isActive();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
    if ((localObject2 != null) && (bool))
    {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(((MPFileVerifyPwdView)localObject2).getWindowToken(), 0);
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getWindowToken(), 0);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
    if (localObject1 != null) {
      ((MPFileVerifyPwdView)localObject1).c();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (!this.jdField_a_of_type_Boolean)
    {
      ((FileManagerEntity)localObject1).mContext = "needMPFileC2C";
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mConnPCSuc:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append(",create mEntity.mContext");
      QLog.d("MPcFileModel<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mConnPCSuc:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject2).append("mEntity.mContext = null");
      QLog.d("MPcFileModel<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
      ((FileManagerEntity)localObject1).mContext = null;
    }
    p();
    q();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
  }
  
  public void s()
  {
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc CS_RES_403CHECK!");
  }
  
  public void t()
  {
    this.jdField_a_of_type_Boolean = false;
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc disconnect!");
  }
  
  public void u()
  {
    Object localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CLOUD_TYPE_DATALINEMPFILE doDownload,mConnPCSuc:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    QLog.d("MPcFileModel<FileAssistant>", 2, localStringBuilder.toString());
    if (!this.jdField_a_of_type_Boolean)
    {
      if (((DataLineHandler)localObject).a().a()) {
        this.jdField_c_of_type_Long = ((DataLineHandler)localObject).a().a(1);
      } else {
        this.jdField_c_of_type_Long = ((DataLineHandler)localObject).a().a(2);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MPFile doDownload() mConnPCSuc false,mConnectPcSessionId:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("CLOUD_TYPE_DATALINEMPFILE doDownload,mEntity.uniseq:");
    localStringBuilder.append(localFileManagerEntity.uniseq);
    localStringBuilder.append(",mEntity.peerDin:");
    localStringBuilder.append(localFileManagerEntity.peerDin);
    localStringBuilder.append(",mEntity.strDataLineMPFileID:");
    localStringBuilder.append(localFileManagerEntity.strDataLineMPFileID);
    localStringBuilder.append(" ,mEntity.fileName:");
    localStringBuilder.append(localFileManagerEntity.fileName);
    localStringBuilder.append(",mEntity.fileSize:");
    localStringBuilder.append(localFileManagerEntity.fileSize);
    QLog.d("MPcFileModel<FileAssistant>", 2, localStringBuilder.toString());
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_b_of_type_Boolean = true;
    long l = ((DataLineHandler)localObject).a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize);
    if (l == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
      }
      FMToastUtil.a(2131693760);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.g();
      }
      return;
    }
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.status = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
    }
  }
  
  protected void v()
  {
    this.jdField_b_of_type_Boolean = true;
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    localDataLineHandler.a().a(localFileManagerEntity.strDataLineMPFileID);
    localFileManagerEntity.status = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel
 * JD-Core Version:    0.7.0.1
 */