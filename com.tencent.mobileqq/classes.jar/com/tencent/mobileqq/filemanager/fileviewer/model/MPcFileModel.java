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
  QQCustomSingleButtonDialog A;
  View B = null;
  private BroadcastReceiver C;
  private boolean D = true;
  private long E = 0L;
  private long F = 0L;
  private boolean G = false;
  private long H = 0L;
  private int I;
  private int J = 0;
  private INetEventHandler K = null;
  private View L;
  private MPFileVerifyPwdView M;
  private MPFileFailedView N = null;
  private MessageObserver O = new MPcFileModel.5(this);
  protected String z;
  
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
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!this.D)
    {
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "MPFileDoDownloadWithBuildConnection mConnPCSuc false!");
      return;
    }
    FileManagerEntity localFileManagerEntity = this.c.r();
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
    this.E = NetConnInfoCenter.getServerTimeMillis();
    this.G = true;
    paramLong = localDataLineHandler.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramLong, this.I);
    if (paramLong == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
      }
      FMToastUtil.a(2131891335);
      return;
    }
    localFileManagerEntity.uniseq = paramLong;
    localFileManagerEntity.status = 2;
  }
  
  private void g(int paramInt)
  {
    Object localObject = this.M;
    if (localObject != null) {
      ((MPFileVerifyPwdView)localObject).c();
    }
    au();
    this.N = new MPFileFailedView(this.k.getActivity(), this.a);
    this.N.b();
    this.B = this.N.a(this.k.a(), new MPcFileModel.2(this), paramInt, this.I);
    this.k.a().setVisibility(0);
    this.k.a().removeAllViews();
    this.k.a().addView(this.B);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.B.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void h(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      this.I = 1;
      return;
    }
    this.I = 0;
  }
  
  public String I()
  {
    return "";
  }
  
  public int W()
  {
    int i = z();
    int j = 1;
    if ((i != 0) && (i != 2) && (i != 13)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0;
    }
    if (FileUtils.fileExistsAndNotEmpty(y()))
    {
      i = j;
      if (this.k != null)
      {
        i = j;
        if (this.k.k()) {
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
  
  public IServiceInfo X()
  {
    String str = y();
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      return new LocalFileColorNoteServiceInfo(str);
    }
    return new DefaultFileColorNoteServiceInfo();
  }
  
  public int a()
  {
    int i = z();
    int j = super.a();
    if (j != 0) {
      return j;
    }
    if (i != 0) {
      return 1;
    }
    return 6;
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
      FMToastUtil.b(2131891869);
      paramArrayOfByte = this.M;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.d();
      }
    }
    else
    {
      FMToastUtil.a(2131891868);
      paramArrayOfByte = this.M;
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
      this.z = new JSONObject(paramArrayOfByte).getString("nonce");
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    if (paramBoolean) {
      this.J += 1;
    }
    if (this.J >= 3)
    {
      this.A = new QQCustomSingleButtonDialog(this.i, 2131953338);
      this.A.setContentView(2131624613);
      this.A.setTitle(2131891880);
      this.A.b(2131891879);
      this.A.a(0, 0, null);
      this.A.a(2131891322, new MPcFileModel.4(this));
      this.A.show();
    }
    if ((paramBoolean) && (this.J < 3)) {
      FMToastUtil.a(2131891922);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("RelayHttpMgrInfo roomno:");
    paramArrayOfByte.append(this.z);
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, paramArrayOfByte.toString());
    if (this.k != null) {
      this.k.a(false);
    }
    if (this.M == null) {
      h();
    }
  }
  
  protected void aA()
  {
    this.G = true;
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    FileManagerEntity localFileManagerEntity = this.c.r();
    localDataLineHandler.a().a(localFileManagerEntity.strDataLineMPFileID);
    localFileManagerEntity.status = 3;
  }
  
  public void au()
  {
    Object localObject = this.L;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.k.a().removeView(this.L);
    }
    localObject = this.M;
    if (localObject != null)
    {
      ((MPFileVerifyPwdView)localObject).a();
      this.M = null;
    }
  }
  
  protected void av()
  {
    Object localObject = this.B;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.k.a().removeView(this.B);
    }
    localObject = this.N;
    if (localObject != null)
    {
      ((MPFileFailedView)localObject).a();
      this.N = null;
    }
  }
  
  public void aw()
  {
    this.D = true;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("CLOUD_TYPE_DATALINEMPFILE process_CS_SERVER_OK,mConnPCSuc:");
    ((StringBuilder)localObject1).append(this.D);
    QLog.d("MPcFileModel<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    this.J = 0;
    a(this.H);
    localObject1 = (InputMethodManager)this.k.a().getContext().getSystemService("input_method");
    boolean bool = ((InputMethodManager)localObject1).isActive();
    Object localObject2 = this.M;
    if ((localObject2 != null) && (bool))
    {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(((MPFileVerifyPwdView)localObject2).getWindowToken(), 0);
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(this.k.a().getWindowToken(), 0);
    }
    localObject1 = this.M;
    if (localObject1 != null) {
      ((MPFileVerifyPwdView)localObject1).c();
    }
    localObject1 = this.c.r();
    if (!this.D)
    {
      ((FileManagerEntity)localObject1).mContext = "needMPFileC2C";
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mConnPCSuc:");
      ((StringBuilder)localObject1).append(this.D);
      ((StringBuilder)localObject1).append(",create mEntity.mContext");
      QLog.d("MPcFileModel<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mConnPCSuc:");
      ((StringBuilder)localObject2).append(this.D);
      ((StringBuilder)localObject2).append("mEntity.mContext = null");
      QLog.d("MPcFileModel<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
      ((FileManagerEntity)localObject1).mContext = null;
    }
    au();
    av();
    this.k.a().removeAllViews();
    this.k.b();
    this.k.h();
  }
  
  public void ax()
  {
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc CS_RES_403CHECK!");
  }
  
  public void ay()
  {
    this.D = false;
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc disconnect!");
  }
  
  public void az()
  {
    Object localObject = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    FileManagerEntity localFileManagerEntity = this.c.r();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CLOUD_TYPE_DATALINEMPFILE doDownload,mConnPCSuc:");
    localStringBuilder.append(this.D);
    QLog.d("MPcFileModel<FileAssistant>", 2, localStringBuilder.toString());
    if (!this.D)
    {
      if (((DataLineHandler)localObject).a().b()) {
        this.H = ((DataLineHandler)localObject).a().a(1);
      } else {
        this.H = ((DataLineHandler)localObject).a().a(2);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MPFile doDownload() mConnPCSuc false,mConnectPcSessionId:");
      ((StringBuilder)localObject).append(this.H);
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
    this.E = NetConnInfoCenter.getServerTimeMillis();
    this.G = true;
    long l = ((DataLineHandler)localObject).a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize);
    if (l == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
      }
      FMToastUtil.a(2131891335);
      if (this.q != null) {
        this.q.g();
      }
      return;
    }
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.status = 2;
    if (this.q != null) {
      this.q.d();
    }
  }
  
  protected void c()
  {
    if (this.C == null)
    {
      this.C = new MPcFileModel.DataLineMPReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.addAction(MpFileConstant.d);
      localIntentFilter.addAction(MpFileConstant.g);
      localIntentFilter.setPriority(200);
      this.i.registerReceiver(this.C, localIntentFilter);
    }
    if (this.K == null)
    {
      this.K = new MPcFileModel.1(this);
      AppNetConnInfo.registerNetChangeReceiver(this.i, this.K);
    }
  }
  
  protected void d()
  {
    if (this.C != null) {
      this.i.unregisterReceiver(this.C);
    }
    INetEventHandler localINetEventHandler = this.K;
    if (localINetEventHandler != null) {
      AppNetConnInfo.unregisterNetEventHandler(localINetEventHandler);
    }
    this.C = null;
    this.K = null;
  }
  
  public IUploadController e()
  {
    return this.p;
  }
  
  public IDownloadController f()
  {
    if (this.o == null) {
      this.o = new MPcFileModel.6(this);
    }
    return this.o;
  }
  
  protected void h()
  {
    av();
    this.M = new MPFileVerifyPwdView(this.k.getActivity(), this.a);
    this.L = this.M.a(this.k.a(), new MPcFileModel.3(this));
    this.M.b();
    this.k.a().setVisibility(0);
    this.k.a().removeAllViews();
    this.k.a().addView(this.L);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.L.setLayoutParams(localLayoutParams);
  }
  
  public String l()
  {
    return "biz_src_jc_file";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m()
  {
    if (!FileUtil.d(y())) {
      return null;
    }
    return super.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel
 * JD-Core Version:    0.7.0.1
 */