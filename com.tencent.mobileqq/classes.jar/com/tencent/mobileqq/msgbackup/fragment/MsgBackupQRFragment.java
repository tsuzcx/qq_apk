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
  private Runnable aa;
  private Bitmap ab;
  private boolean ac;
  private MsgBackupGetQrRsp ad;
  private boolean ae;
  private boolean af;
  private boolean ag = false;
  private Runnable ah = new MsgBackupQRFragment.6(this);
  
  private void a(Bitmap paramBitmap)
  {
    Message localMessage = this.I.obtainMessage(10006);
    localMessage.obj = paramBitmap;
    this.I.sendMessage(localMessage);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.J.post(new MsgBackupQRFragment.4(this, paramBoolean2, paramBoolean1));
    }
    else
    {
      a(b(null));
      if (paramBoolean2) {
        u();
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
  
  private void c(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
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
    int i = paramMsgBackupGetQrRsp.d();
    MsgBackupManager localMsgBackupManager = MsgBackupManager.a();
    MsgBackupTransportProcessor localMsgBackupTransportProcessor = localMsgBackupManager.d();
    localMsgBackupTransportProcessor.d(str3);
    localMsgBackupManager.e().b(str1);
    localMsgBackupManager.e().a(str2);
    localMsgBackupManager.e().a(i);
    localMsgBackupTransportProcessor.g(2);
    this.J.postDelayed(this.ah, 800L);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.J.post(new MsgBackupQRFragment.5(this, paramMsgBackupGetQrRsp));
      return;
    }
    b(b(paramMsgBackupGetQrRsp));
  }
  
  private void d(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void t()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.J.post(new MsgBackupQRFragment.3(this));
      return;
    }
    a(b(null));
  }
  
  private void u()
  {
    Message localMessage = this.I.obtainMessage(10015);
    this.I.sendMessage(localMessage);
  }
  
  protected void a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
  {
    super.a(paramMsgBackupGetQrRsp);
    this.ag = false;
    c(paramMsgBackupGetQrRsp);
    MsgBackupManager.a().u();
  }
  
  protected void a(MsgBackupQryStateRsp paramMsgBackupQryStateRsp)
  {
    super.a(paramMsgBackupQryStateRsp);
    if (paramMsgBackupQryStateRsp != null) {
      if (paramMsgBackupQryStateRsp.a() == 2)
      {
        if (this.aa != null) {
          this.J.removeCallbacks(this.aa);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("processQueryStateRsp: ");
          ((StringBuilder)localObject).append(paramMsgBackupQryStateRsp);
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, ((StringBuilder)localObject).toString());
        }
        if (MsgBackupManager.t)
        {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
          return;
        }
        this.J.removeCallbacks(this.ah);
        Object localObject = paramMsgBackupQryStateRsp.c();
        String str1 = paramMsgBackupQryStateRsp.b();
        int k = paramMsgBackupQryStateRsp.e();
        String str2 = paramMsgBackupQryStateRsp.d().a();
        paramMsgBackupQryStateRsp = paramMsgBackupQryStateRsp.d().b();
        int j = paramMsgBackupQryStateRsp.size();
        int i = 0;
        if (j == 2)
        {
          i = ((Integer)paramMsgBackupQryStateRsp.get(0)).intValue();
          j = ((Integer)paramMsgBackupQryStateRsp.get(1)).intValue();
        }
        else
        {
          j = 0;
        }
        if (QLog.isColorLevel())
        {
          paramMsgBackupQryStateRsp = new StringBuilder();
          paramMsgBackupQryStateRsp.append("processQueryStateRsp: client ip = ");
          paramMsgBackupQryStateRsp.append(str2);
          paramMsgBackupQryStateRsp.append(", udpport = ");
          paramMsgBackupQryStateRsp.append(j);
          paramMsgBackupQryStateRsp.append(", tcpport = ");
          paramMsgBackupQryStateRsp.append(i);
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, paramMsgBackupQryStateRsp.toString());
        }
        paramMsgBackupQryStateRsp = MsgBackupManager.a();
        MsgBackupTransportProcessor localMsgBackupTransportProcessor = paramMsgBackupQryStateRsp.d();
        localMsgBackupTransportProcessor.d((String)localObject);
        localMsgBackupTransportProcessor.b(str2);
        localMsgBackupTransportProcessor.b(i);
        localMsgBackupTransportProcessor.a(j);
        paramMsgBackupQryStateRsp.e().a(k);
        paramMsgBackupQryStateRsp.e().b(str1);
        localMsgBackupTransportProcessor.g(2);
        localMsgBackupTransportProcessor.f(2);
        MsgBackupManager.t = true;
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
    this.ag = false;
    a(false, true);
  }
  
  public Bitmap b(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
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
    int i;
    int m;
    int j;
    label158:
    boolean bool;
    try
    {
      i = ViewUtils.dip2px(200.0F);
      paramMsgBackupGetQrRsp = new QRCodeWriter().a(paramMsgBackupGetQrRsp, i, i, (Map)localObject);
      k = paramMsgBackupGetQrRsp.a();
      m = paramMsgBackupGetQrRsp.b();
      localObject = new int[k * m];
      i = 0;
    }
    catch (Exception paramMsgBackupGetQrRsp)
    {
      int k;
      QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramMsgBackupGetQrRsp);
      return null;
    }
    if (j < k) {
      if (paramMsgBackupGetQrRsp.a(j, i))
      {
        localObject[(i * k + j)] = -16777216;
        break label261;
        if (this.ab == null) {
          this.ab = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        }
        if (this.ab == null) {
          break label275;
        }
        bool = true;
      }
    }
    for (;;)
    {
      MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
      this.ab.setPixels((int[])localObject, 0, k, 0, 0, k, m);
      paramMsgBackupGetQrRsp = this.ab;
      return paramMsgBackupGetQrRsp;
      for (;;)
      {
        if (i >= m) {
          break label273;
        }
        j = 0;
        break;
        label261:
        j += 1;
        break;
        i += 1;
      }
      label273:
      break label158;
      label275:
      bool = false;
    }
  }
  
  protected void b()
  {
    super.b();
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.O != null) {
      getQBaseActivity().removeObserver(this.O);
    }
    Object localObject = new HashSet(MsgBackupManager.a().h.size());
    ((HashSet)localObject).addAll(MsgBackupManager.a().h);
    MsgBackupManager.i = MsgBackupManager.a().h.size();
    MsgBackupReporter.a();
    MsgBackupReporter.a.g = MsgBackupManager.i;
    MsgBackupRequest localMsgBackupRequest = new MsgBackupRequest();
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    localMsgBackupRequest.a = ((HashSet)localObject);
    localMsgBackupRequest.b = 0;
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      if (localObject != null)
      {
        l1 = ((Intent)localObject).getLongExtra("session_start_time", 0L);
        l2 = ((Intent)localObject).getLongExtra("session_end_time", 0L);
        i = ((Intent)localObject).getIntExtra("session_content_type", 1);
        this.ae = ((Intent)localObject).getBooleanExtra("session_net_status", true);
        break label205;
      }
    }
    long l1 = 0L;
    long l2 = l1;
    int i = 1;
    label205:
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(this.ae) });
    boolean bool;
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localMsgBackupRequest.c = l1;
      localMsgBackupRequest.d = l2;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localMsgBackupRequest.e = bool;
    }
    else
    {
      localMsgBackupRequest.c = 0L;
      localMsgBackupRequest.d = 9223372036854775807L;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localMsgBackupRequest.e = bool;
    }
    getQBaseActivity().addObserver(this.O);
    MsgBackupManager.a().l();
    MsgBackupManager.a().a(localMsgBackupRequest);
    if (NetworkUtil.getSystemNetwork(getActivity()) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!this.ae) && (bool))
    {
      MsgBackupManager.a().a(false);
      this.af = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
      }
    }
    this.ac = bool;
    MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.ac) });
    if (!bool) {
      a(bool, false);
    }
    this.ad = MsgBackupManager.a().m();
    if ((this.ad != null) && (bool))
    {
      MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
      this.ag = false;
      c(this.ad);
    }
    this.J.post(this.aa);
  }
  
  protected void c()
  {
    super.c();
    a(getActivity().getString(2131887465));
  }
  
  protected void d()
  {
    super.d();
    if (AppSetting.e) {
      this.A.setContentDescription(HardCodeUtil.a(2131904800));
    }
    this.D.setText(getResources().getString(2131887519));
    this.D.setTextColor(getResources().getColor(2131167993));
    this.c.setVisibility(0);
    this.B.setVisibility(0);
    this.A.setOnClickListener(this);
    this.aa = new MsgBackupQRFragment.2(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
      }
      MsgBackupManager.a().g();
      onBackEvent();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void e()
  {
    super.e();
    this.p.setOnItemSelectListener(new MsgBackupQRFragment.1(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 10013)
    {
      if (j != 10015)
      {
        int i = 1;
        Object localObject;
        switch (j)
        {
        default: 
          break;
        case 10006: 
          localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
          ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
          if (this.A != null)
          {
            this.A.setImageDrawable((Drawable)localObject);
            if ((this.B != null) && (!this.ag)) {
              this.B.setVisibility(8);
            }
            MsgBackupManager.a().o();
          }
          MsgBackupReporter.a("0X800A239", 2);
          break;
        case 10005: 
          if (paramMessage.arg1 != 1) {
            i = 0;
          }
          if (i != 0)
          {
            ViewUtils.setViewVisibility(this.C, 0);
            ViewUtils.setViewVisibility(this.D, 8);
          }
          else
          {
            ViewUtils.setViewVisibility(this.C, 8);
            this.D.setText(getResources().getString(2131887519));
            this.D.setTextColor(getResources().getColor(2131167993));
            ViewUtils.setViewVisibility(this.D, 0);
          }
          break;
        case 10004: 
          if (paramMessage.arg1 == 1) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (this.A != null)
            {
              localObject = (Bitmap)paramMessage.obj;
              this.A.setImageBitmap((Bitmap)localObject);
              if (this.B != null) {
                this.B.setVisibility(8);
              }
              MsgBackupManager.a().o();
              MsgBackupReporter.a("0X800A239", 1);
            }
          }
          else
          {
            t();
            MsgBackupUtil.b("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
          }
          break;
        }
      }
      else
      {
        ViewUtils.setViewVisibility(this.C, 8);
        this.D.setText(getResources().getString(2131887520));
        this.D.setTextColor(getResources().getColor(2131166523));
        ViewUtils.setViewVisibility(this.D, 0);
      }
    }
    else {
      ViewUtils.setVisible(this.B, 0);
    }
    return super.handleMessage(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442821)
    {
      this.ag = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("qr_code_src request qr onclick, isWaitingQrRsp = ");
        ((StringBuilder)localObject).append(this.ag);
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.I.obtainMessage(10013);
      this.I.sendMessage((Message)localObject);
      this.J.post(new MsgBackupQRFragment.7(this));
      MsgBackupReporter.a("0X800A23C");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.af = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.O != null) {
      ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).removeObserver(this.O);
    }
    this.J.removeCallbacks(this.ah);
    this.J.removeCallbacks(this.aa);
    MsgBackupManager.a().p();
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
    MsgBackupManager.v = false;
  }
  
  public void onStop()
  {
    s();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment
 * JD-Core Version:    0.7.0.1
 */