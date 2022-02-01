package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupRequest;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgBackupQRFragment
  extends MsgBackupBaseFragment
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private MsgBackupGetQrRsp jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp;
  private Runnable d;
  private Runnable jdField_e_of_type_JavaLangRunnable = new MsgBackupQRFragment.6(this);
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h = false;
  
  private void a(Bitmap paramBitmap)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10006);
    localMessage.obj = paramBitmap;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.4(this, paramBoolean2, paramBoolean1));
    }
    for (;;)
    {
      MsgBackupReporter.a("0X800A241", 1);
      return;
      a(a(null));
      if (paramBoolean2) {
        l();
      } else {
        d(paramBoolean1);
      }
    }
  }
  
  private void b(Bitmap paramBitmap)
  {
    int i = 1;
    boolean bool;
    Message localMessage;
    if (NetworkUtil.a(getActivity()) == 1)
    {
      bool = true;
      d(bool);
      localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10004);
      if (!bool) {
        break label64;
      }
    }
    for (;;)
    {
      localMessage.arg1 = i;
      localMessage.obj = paramBitmap;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      bool = false;
      break;
      label64:
      i = 0;
    }
  }
  
  private void b(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
  {
    if (paramMsgBackupGetQrRsp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "refreshQRLayout QRCode fail, data is null!");
      }
      return;
    }
    String str1 = paramMsgBackupGetQrRsp.b();
    String str2 = paramMsgBackupGetQrRsp.a();
    String str3 = paramMsgBackupGetQrRsp.c();
    int i = paramMsgBackupGetQrRsp.a();
    MsgBackupManager localMsgBackupManager = MsgBackupManager.a();
    MsgBackupTransportProcessor localMsgBackupTransportProcessor = localMsgBackupManager.a();
    localMsgBackupTransportProcessor.d(str3);
    localMsgBackupManager.a().b(str1);
    localMsgBackupManager.a().a(str2);
    localMsgBackupManager.a().a(i);
    localMsgBackupTransportProcessor.g(2);
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_e_of_type_JavaLangRunnable, 800L);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.5(this, paramMsgBackupGetQrRsp));
      return;
    }
    b(a(paramMsgBackupGetQrRsp));
  }
  
  private void d(boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10005);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
  }
  
  private void k()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.3(this));
      return;
    }
    a(a(null));
  }
  
  private void l()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10015);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public Bitmap a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
  {
    Object localObject;
    if (paramMsgBackupGetQrRsp == null)
    {
      paramMsgBackupGetQrRsp = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
      localObject = new Hashtable();
      ((Hashtable)localObject).put(EncodeHintType.MARGIN, Integer.valueOf(0));
      ((Hashtable)localObject).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    }
    for (;;)
    {
      int i;
      int m;
      int j;
      try
      {
        i = AIOUtils.a(200.0F, getResources());
        paramMsgBackupGetQrRsp = new QRCodeWriter().a(paramMsgBackupGetQrRsp, i, i, (Map)localObject);
        k = paramMsgBackupGetQrRsp.a();
        m = paramMsgBackupGetQrRsp.b();
        localObject = new int[k * m];
        i = 0;
      }
      catch (Exception paramMsgBackupGetQrRsp)
      {
        int k;
        boolean bool;
        QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramMsgBackupGetQrRsp);
        return null;
      }
      if (j < k)
      {
        if (paramMsgBackupGetQrRsp.a(j, i)) {
          localObject[(i * k + j)] = -16777216;
        }
        j += 1;
        continue;
        paramMsgBackupGetQrRsp = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=" + paramMsgBackupGetQrRsp.a();
        break;
      }
      i += 1;
      break label254;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        bool = true;
        MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
        this.jdField_a_of_type_AndroidGraphicsBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
        paramMsgBackupGetQrRsp = this.jdField_a_of_type_AndroidGraphicsBitmap;
        return paramMsgBackupGetQrRsp;
      }
      bool = false;
      continue;
      label254:
      if (i < m) {
        j = 0;
      }
    }
  }
  
  protected void a()
  {
    super.a();
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
    Object localObject = new HashSet(MsgBackupManager.a().jdField_a_of_type_JavaUtilHashSet.size());
    ((HashSet)localObject).addAll(MsgBackupManager.a().jdField_a_of_type_JavaUtilHashSet);
    MsgBackupManager.b = MsgBackupManager.a().jdField_a_of_type_JavaUtilHashSet.size();
    MsgBackupReporter.a();
    MsgBackupReporter.a.b = MsgBackupManager.b;
    MsgBackupRequest localMsgBackupRequest = new MsgBackupRequest();
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    localMsgBackupRequest.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    localMsgBackupRequest.jdField_a_of_type_Int = 0;
    long l3 = 0L;
    long l4 = 0L;
    int j = 1;
    int i = j;
    long l2 = l4;
    long l1 = l3;
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      i = j;
      l2 = l4;
      l1 = l3;
      if (localObject != null)
      {
        l1 = ((Intent)localObject).getLongExtra("session_start_time", 0L);
        l2 = ((Intent)localObject).getLongExtra("session_end_time", 0L);
        i = ((Intent)localObject).getIntExtra("session_content_type", 1);
        this.f = ((Intent)localObject).getBooleanExtra("session_net_status", true);
      }
    }
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(this.f) });
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localMsgBackupRequest.jdField_a_of_type_Long = l1;
      localMsgBackupRequest.b = l2;
      if (i == 2)
      {
        bool = true;
        localMsgBackupRequest.jdField_a_of_type_Boolean = bool;
        getActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
        MsgBackupManager.a().i();
        MsgBackupManager.a().a(localMsgBackupRequest);
        if (NetworkUtil.a(getActivity()) != 1) {
          break label541;
        }
      }
    }
    label541:
    for (boolean bool = true;; bool = false)
    {
      if ((!this.f) && (bool))
      {
        MsgBackupManager.a().a(false);
        this.g = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
        }
      }
      this.jdField_e_of_type_Boolean = bool;
      MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      if (!bool) {
        a(bool, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp = MsgBackupManager.a().a();
      if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp != null) && (bool))
      {
        MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
        this.h = false;
        b(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.d);
      return;
      bool = false;
      break;
      localMsgBackupRequest.jdField_a_of_type_Long = 0L;
      localMsgBackupRequest.b = 9223372036854775807L;
      if (i == 2) {}
      for (bool = true;; bool = false)
      {
        localMsgBackupRequest.jdField_a_of_type_Boolean = bool;
        break;
      }
    }
  }
  
  protected void a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
  {
    super.a(paramMsgBackupGetQrRsp);
    this.h = false;
    b(paramMsgBackupGetQrRsp);
    MsgBackupManager.a().o();
  }
  
  protected void a(MsgBackupQryStateRsp paramMsgBackupQryStateRsp)
  {
    int i = 0;
    super.a(paramMsgBackupQryStateRsp);
    if (paramMsgBackupQryStateRsp != null)
    {
      if (paramMsgBackupQryStateRsp.a() != 2) {
        break label356;
      }
      if (this.d != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: " + paramMsgBackupQryStateRsp);
      }
      if (MsgBackupManager.d) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    String str1 = paramMsgBackupQryStateRsp.b();
    String str2 = paramMsgBackupQryStateRsp.a();
    int k = paramMsgBackupQryStateRsp.b();
    String str3 = paramMsgBackupQryStateRsp.a().a();
    paramMsgBackupQryStateRsp = paramMsgBackupQryStateRsp.a().a();
    int j;
    if (paramMsgBackupQryStateRsp.size() == 2)
    {
      j = ((Integer)paramMsgBackupQryStateRsp.get(0)).intValue();
      i = ((Integer)paramMsgBackupQryStateRsp.get(1)).intValue();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: client ip = " + str3 + ", udpport = " + i + ", tcpport = " + j);
      }
      paramMsgBackupQryStateRsp = MsgBackupManager.a();
      MsgBackupTransportProcessor localMsgBackupTransportProcessor = paramMsgBackupQryStateRsp.a();
      localMsgBackupTransportProcessor.d(str1);
      localMsgBackupTransportProcessor.b(str3);
      localMsgBackupTransportProcessor.b(j);
      localMsgBackupTransportProcessor.a(i);
      paramMsgBackupQryStateRsp.a().a(k);
      paramMsgBackupQryStateRsp.a().b(str2);
      localMsgBackupTransportProcessor.g(2);
      localMsgBackupTransportProcessor.f(2);
      MsgBackupManager.d = true;
      if ((getActivity() == null) || (getActivity().isFinishing())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has deal, so app will start transport page!");
      }
      paramMsgBackupQryStateRsp = new Intent();
      paramMsgBackupQryStateRsp.putExtra("param_start", 4);
      PublicFragmentActivity.a(getActivity(), paramMsgBackupQryStateRsp, MsgBackupTransportFragment.class, 1000);
      return;
      label356:
      if ((paramMsgBackupQryStateRsp.a() == 1) || (paramMsgBackupQryStateRsp.a() == 3) || (paramMsgBackupQryStateRsp.a() != 4)) {
        break;
      }
      return;
      j = 0;
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.a(paramInteger);
    this.h = false;
    a(false, true);
  }
  
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131690626));
  }
  
  protected void c()
  {
    super.c();
    if (AppSetting.d) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706935));
    }
    this.c.setText(getResources().getString(2131690680));
    this.c.setTextColor(getResources().getColor(2131167033));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d = new MsgBackupQRFragment.2(this);
  }
  
  protected void d()
  {
    super.d();
    this.vg.setOnItemSelectListener(new MsgBackupQRFragment.1(this));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
      }
      MsgBackupManager.a().d();
      onBackEvent();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (paramMessage.arg1 == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label136;
        }
        if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
          break;
        }
        localObject = (Bitmap)paramMessage.obj;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        MsgBackupManager.a().k();
        MsgBackupReporter.a("0X800A239", 1);
        break;
      }
      label136:
      k();
      MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
      continue;
      if (paramMessage.arg1 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label196;
        }
        ViewUtils.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 0);
        ViewUtils.a(this.c, 8);
        break;
      }
      label196:
      ViewUtils.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690680));
      this.c.setTextColor(getResources().getColor(2131167033));
      ViewUtils.a(this.c, 0);
      continue;
      ViewUtils.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690681));
      this.c.setTextColor(getResources().getColor(2131165877));
      ViewUtils.a(this.c, 0);
      continue;
      Object localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
      ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (!this.h)) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        MsgBackupManager.a().k();
      }
      MsgBackupReporter.a("0X800A239", 2);
      continue;
      ViewUtils.b(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
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
      this.h = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "qr_code_src request qr onclick, isWaitingQrRsp = " + this.h);
      }
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10013);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.7(this));
      MsgBackupReporter.a("0X800A23C");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
    MsgBackupManager.a().l();
  }
  
  public void onPause()
  {
    super.onPause();
    MsgBackupManager.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    MsgBackupManager.a().a(getActivity());
    MsgBackupManager.f = false;
  }
  
  public void onStop()
  {
    j();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment
 * JD-Core Version:    0.7.0.1
 */