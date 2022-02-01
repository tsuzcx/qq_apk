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
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
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
  private Runnable e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public MsgBackupQRFragment()
  {
    this.jdField_i_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangRunnable = new MsgBackupQRFragment.6(this);
  }
  
  private void a(Bitmap paramBitmap)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10006);
    localMessage.obj = paramBitmap;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.4(this, paramBoolean2, paramBoolean1));
    }
    else
    {
      a(a(null));
      if (paramBoolean2) {
        m();
      } else {
        d(paramBoolean1);
      }
    }
    MsgBackupReporter.a("0X800A241", 1);
  }
  
  private void b(Bitmap paramBitmap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    int j = paramMsgBackupGetQrRsp.a();
    MsgBackupManager localMsgBackupManager = MsgBackupManager.a();
    MsgBackupTransportProcessor localMsgBackupTransportProcessor = localMsgBackupManager.a();
    localMsgBackupTransportProcessor.d(str3);
    localMsgBackupManager.a().b(str1);
    localMsgBackupManager.a().a(str2);
    localMsgBackupManager.a().a(j);
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void l()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.3(this));
      return;
    }
    a(a(null));
  }
  
  private void m()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10015);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public Bitmap a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
  {
    if (paramMsgBackupGetQrRsp == null)
    {
      paramMsgBackupGetQrRsp = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=");
      ((StringBuilder)localObject).append(paramMsgBackupGetQrRsp.a());
      paramMsgBackupGetQrRsp = ((StringBuilder)localObject).toString();
    }
    Object localObject = new Hashtable();
    ((Hashtable)localObject).put(EncodeHintType.MARGIN, Integer.valueOf(0));
    ((Hashtable)localObject).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    int j;
    int n;
    int k;
    label154:
    boolean bool;
    try
    {
      j = ViewUtils.a(200.0F);
      paramMsgBackupGetQrRsp = new QRCodeWriter().a(paramMsgBackupGetQrRsp, j, j, (Map)localObject);
      m = paramMsgBackupGetQrRsp.a();
      n = paramMsgBackupGetQrRsp.b();
      localObject = new int[m * n];
      j = 0;
    }
    catch (Exception paramMsgBackupGetQrRsp)
    {
      int m;
      QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramMsgBackupGetQrRsp);
      return null;
    }
    if (k < m) {
      if (paramMsgBackupGetQrRsp.a(k, j))
      {
        localObject[(j * m + k)] = -16777216;
        break label257;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
        }
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label271;
        }
        bool = true;
      }
    }
    for (;;)
    {
      MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
      this.jdField_a_of_type_AndroidGraphicsBitmap.setPixels((int[])localObject, 0, m, 0, 0, m, n);
      paramMsgBackupGetQrRsp = this.jdField_a_of_type_AndroidGraphicsBitmap;
      return paramMsgBackupGetQrRsp;
      for (;;)
      {
        if (j >= n) {
          break label269;
        }
        k = 0;
        break;
        label257:
        k += 1;
        break;
        j += 1;
      }
      label269:
      break label154;
      label271:
      bool = false;
    }
  }
  
  protected void a()
  {
    super.a();
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null) {
      getQBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
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
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      if (localObject != null)
      {
        l1 = ((Intent)localObject).getLongExtra("session_start_time", 0L);
        l2 = ((Intent)localObject).getLongExtra("session_end_time", 0L);
        j = ((Intent)localObject).getIntExtra("session_content_type", 1);
        this.g = ((Intent)localObject).getBooleanExtra("session_net_status", true);
        break label205;
      }
    }
    long l1 = 0L;
    long l2 = l1;
    int j = 1;
    label205:
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(j), Boolean.valueOf(this.g) });
    boolean bool;
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localMsgBackupRequest.jdField_a_of_type_Long = l1;
      localMsgBackupRequest.b = l2;
      if (j == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localMsgBackupRequest.jdField_a_of_type_Boolean = bool;
    }
    else
    {
      localMsgBackupRequest.jdField_a_of_type_Long = 0L;
      localMsgBackupRequest.b = 9223372036854775807L;
      if (j == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localMsgBackupRequest.jdField_a_of_type_Boolean = bool;
    }
    getQBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    MsgBackupManager.a().i();
    MsgBackupManager.a().a(localMsgBackupRequest);
    if (NetworkUtil.getSystemNetwork(getActivity()) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!this.g) && (bool))
    {
      MsgBackupManager.a().a(false);
      this.h = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
      }
    }
    this.f = bool;
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.f) });
    if (!bool) {
      a(bool, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp = MsgBackupManager.a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp != null) && (bool))
    {
      MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
      this.jdField_i_of_type_Boolean = false;
      b(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.post(this.jdField_d_of_type_JavaLangRunnable);
  }
  
  protected void a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
  {
    super.a(paramMsgBackupGetQrRsp);
    this.jdField_i_of_type_Boolean = false;
    b(paramMsgBackupGetQrRsp);
    MsgBackupManager.a().o();
  }
  
  protected void a(MsgBackupQryStateRsp paramMsgBackupQryStateRsp)
  {
    super.a(paramMsgBackupQryStateRsp);
    if (paramMsgBackupQryStateRsp != null) {
      if (paramMsgBackupQryStateRsp.a() == 2)
      {
        if (this.jdField_d_of_type_JavaLangRunnable != null) {
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("processQueryStateRsp: ");
          ((StringBuilder)localObject).append(paramMsgBackupQryStateRsp);
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, ((StringBuilder)localObject).toString());
        }
        if (MsgBackupManager.d)
        {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
          return;
        }
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        Object localObject = paramMsgBackupQryStateRsp.b();
        String str1 = paramMsgBackupQryStateRsp.a();
        int m = paramMsgBackupQryStateRsp.b();
        String str2 = paramMsgBackupQryStateRsp.a().a();
        paramMsgBackupQryStateRsp = paramMsgBackupQryStateRsp.a().a();
        int k = paramMsgBackupQryStateRsp.size();
        int j = 0;
        if (k == 2)
        {
          j = ((Integer)paramMsgBackupQryStateRsp.get(0)).intValue();
          k = ((Integer)paramMsgBackupQryStateRsp.get(1)).intValue();
        }
        else
        {
          k = 0;
        }
        if (QLog.isColorLevel())
        {
          paramMsgBackupQryStateRsp = new StringBuilder();
          paramMsgBackupQryStateRsp.append("processQueryStateRsp: client ip = ");
          paramMsgBackupQryStateRsp.append(str2);
          paramMsgBackupQryStateRsp.append(", udpport = ");
          paramMsgBackupQryStateRsp.append(k);
          paramMsgBackupQryStateRsp.append(", tcpport = ");
          paramMsgBackupQryStateRsp.append(j);
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, paramMsgBackupQryStateRsp.toString());
        }
        paramMsgBackupQryStateRsp = MsgBackupManager.a();
        MsgBackupTransportProcessor localMsgBackupTransportProcessor = paramMsgBackupQryStateRsp.a();
        localMsgBackupTransportProcessor.d((String)localObject);
        localMsgBackupTransportProcessor.b(str2);
        localMsgBackupTransportProcessor.b(j);
        localMsgBackupTransportProcessor.a(k);
        paramMsgBackupQryStateRsp.a().a(m);
        paramMsgBackupQryStateRsp.a().b(str1);
        localMsgBackupTransportProcessor.g(2);
        localMsgBackupTransportProcessor.f(2);
        MsgBackupManager.d = true;
        if ((getActivity() != null) && (!getActivity().isFinishing()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has deal, so app will start transport page!");
          }
          paramMsgBackupQryStateRsp = new Intent();
          paramMsgBackupQryStateRsp.putExtra("param_start", 4);
          QPublicFragmentActivity.startForResult(getActivity(), paramMsgBackupQryStateRsp, MsgBackupTransportFragment.class, 1000);
        }
      }
      else
      {
        if (paramMsgBackupQryStateRsp.a() == 1) {
          return;
        }
        if (paramMsgBackupQryStateRsp.a() == 3) {
          return;
        }
        paramMsgBackupQryStateRsp.a();
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.a(paramInteger);
    this.jdField_i_of_type_Boolean = false;
    a(false, true);
  }
  
  protected void c()
  {
    super.c();
    a(getActivity().getString(2131690554));
  }
  
  protected void d()
  {
    super.d();
    if (AppSetting.d) {
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706957));
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690608));
    this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_JavaLangRunnable = new MsgBackupQRFragment.2(this);
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
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(new MsgBackupQRFragment.1(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 10013)
    {
      if (k != 10015)
      {
        int j = 1;
        Object localObject;
        switch (k)
        {
        default: 
          break;
        case 10006: 
          localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
          ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
          if (this.jdField_d_of_type_AndroidWidgetImageView != null)
          {
            this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
            if ((this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (!this.jdField_i_of_type_Boolean)) {
              this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
            MsgBackupManager.a().k();
          }
          MsgBackupReporter.a("0X800A239", 2);
          break;
        case 10005: 
          if (paramMessage.arg1 != 1) {
            j = 0;
          }
          if (j != 0)
          {
            ViewUtils.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 0);
            ViewUtils.a(this.jdField_i_of_type_AndroidWidgetTextView, 8);
          }
          else
          {
            ViewUtils.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
            this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690608));
            this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
            ViewUtils.a(this.jdField_i_of_type_AndroidWidgetTextView, 0);
          }
          break;
        case 10004: 
          if (paramMessage.arg1 == 1) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            if (this.jdField_d_of_type_AndroidWidgetImageView != null)
            {
              localObject = (Bitmap)paramMessage.obj;
              this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
              if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              }
              MsgBackupManager.a().k();
              MsgBackupReporter.a("0X800A239", 1);
            }
          }
          else
          {
            l();
            MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
          }
          break;
        }
      }
      else
      {
        ViewUtils.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
        this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690609));
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165880));
        ViewUtils.a(this.jdField_i_of_type_AndroidWidgetTextView, 0);
      }
    }
    else {
      ViewUtils.b(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
    }
    return super.handleMessage(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374644)
    {
      this.jdField_i_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("qr_code_src request qr onclick, isWaitingQrRsp = ");
        ((StringBuilder)localObject).append(this.jdField_i_of_type_Boolean);
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10013);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.7(this));
      MsgBackupReporter.a("0X800A23C");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null) {
      ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
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
    k();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment
 * JD-Core Version:    0.7.0.1
 */