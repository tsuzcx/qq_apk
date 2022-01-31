package com.tencent.mobileqq.msgbackup.fragment;

import aciy;
import ajjy;
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
import arop;
import arpa;
import arpg;
import arpo;
import arpu;
import arqz;
import arrt;
import arsa;
import arsc;
import badq;
import bajq;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import gq;
import gu;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgBackupQRFragment
  extends MsgBackupBaseFragment
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private arpo jdField_a_of_type_Arpo;
  private Runnable d;
  private Runnable jdField_e_of_type_JavaLangRunnable = new MsgBackupQRFragment.6(this);
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h;
  
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
      arsa.a("0X800A241", 1);
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
    if (badq.a(getActivity()) == 1)
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
  
  private void b(arpo paramarpo)
  {
    if (paramarpo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "refreshQRLayout QRCode fail, data is null!");
      }
      return;
    }
    String str1 = paramarpo.b();
    String str2 = paramarpo.a();
    String str3 = paramarpo.c();
    int i = paramarpo.a();
    arpa localarpa = arpa.a();
    arrt localarrt = localarpa.a();
    localarrt.b(str3);
    localarpa.a().b(str1);
    localarpa.a().a(str2);
    localarpa.a().a(i);
    localarrt.c(2);
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_e_of_type_JavaLangRunnable, 800L);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.5(this, paramarpo));
      return;
    }
    b(a(paramarpo));
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
  
  public Bitmap a(arpo paramarpo)
  {
    Object localObject;
    if (paramarpo == null)
    {
      paramarpo = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
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
        i = aciy.a(200.0F, getResources());
        paramarpo = new gu().a(paramarpo, i, i, (Map)localObject);
        k = paramarpo.a();
        m = paramarpo.b();
        localObject = new int[k * m];
        i = 0;
      }
      catch (Exception paramarpo)
      {
        int k;
        boolean bool;
        QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramarpo);
        return null;
      }
      if (j < k)
      {
        if (paramarpo.a(j, i)) {
          localObject[(i * k + j)] = -16777216;
        }
        j += 1;
        continue;
        paramarpo = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=" + paramarpo.a();
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
        arsc.b("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
        this.jdField_a_of_type_AndroidGraphicsBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
        paramarpo = this.jdField_a_of_type_AndroidGraphicsBitmap;
        return paramarpo;
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
    arsc.b("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.jdField_a_of_type_Aroq != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Aroq);
    }
    Object localObject = new HashSet(arpa.a().jdField_a_of_type_JavaUtilHashSet.size());
    ((HashSet)localObject).addAll(arpa.a().jdField_a_of_type_JavaUtilHashSet);
    arpa.b = arpa.a().jdField_a_of_type_JavaUtilHashSet.size();
    arsa.a();
    arsa.a.b = arpa.b;
    arpg localarpg = new arpg();
    arsc.b("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    localarpg.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    localarpg.jdField_a_of_type_Int = 0;
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
    arsc.b("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(this.f) });
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localarpg.jdField_a_of_type_Long = l1;
      localarpg.b = l2;
      if (i == 2)
      {
        bool = true;
        localarpg.jdField_a_of_type_Boolean = bool;
        getActivity().app.addObserver(this.jdField_a_of_type_Aroq);
        arpa.a().i();
        arpa.a().a(localarpg);
        if (badq.a(getActivity()) != 1) {
          break label541;
        }
      }
    }
    label541:
    for (boolean bool = true;; bool = false)
    {
      if ((!this.f) && (bool))
      {
        arpa.a().a(false);
        this.g = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
        }
      }
      this.jdField_e_of_type_Boolean = bool;
      arsc.b("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      if (!bool) {
        a(bool, false);
      }
      this.jdField_a_of_type_Arpo = arpa.a().a();
      if ((this.jdField_a_of_type_Arpo != null) && (bool))
      {
        arsc.b("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
        this.h = false;
        b(this.jdField_a_of_type_Arpo);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.d);
      return;
      bool = false;
      break;
      localarpg.jdField_a_of_type_Long = 0L;
      localarpg.b = 9223372036854775807L;
      if (i == 2) {}
      for (bool = true;; bool = false)
      {
        localarpg.jdField_a_of_type_Boolean = bool;
        break;
      }
    }
  }
  
  protected void a(arpo paramarpo)
  {
    super.a(paramarpo);
    this.h = false;
    b(paramarpo);
    arpa.a().o();
  }
  
  protected void a(arpu paramarpu)
  {
    super.a(paramarpu);
    if (paramarpu != null)
    {
      if (paramarpu.a() != 2) {
        break label334;
      }
      if (this.d != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: " + paramarpu);
      }
      if (!arpa.d) {
        break label83;
      }
      QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
    }
    label83:
    while ((paramarpu.a() == 1) || (paramarpu.a() == 3) || (paramarpu.a() != 4))
    {
      do
      {
        return;
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        String str1 = paramarpu.b();
        String str2 = paramarpu.a();
        int i = paramarpu.b();
        MsgBackupEndPoint localMsgBackupEndPoint1 = new MsgBackupEndPoint();
        MsgBackupEndPoint localMsgBackupEndPoint2 = new MsgBackupEndPoint();
        int j = arsc.a(paramarpu.a().a());
        localMsgBackupEndPoint1.ipv4 = j;
        localMsgBackupEndPoint2.ipv4 = j;
        paramarpu = paramarpu.a().a();
        if (paramarpu.size() == 2)
        {
          localMsgBackupEndPoint2.port = ((Integer)paramarpu.get(0)).intValue();
          localMsgBackupEndPoint1.port = ((Integer)paramarpu.get(1)).intValue();
        }
        paramarpu = arpa.a();
        arrt localarrt = paramarpu.a();
        localarrt.b(str1);
        localarrt.b(localMsgBackupEndPoint2);
        localarrt.a(localMsgBackupEndPoint1);
        paramarpu.a().a(i);
        paramarpu.a().b(str2);
        localarrt.c(2);
        localarrt.b(2);
        arpa.d = true;
      } while ((getActivity() == null) || (getActivity().isFinishing()));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp has deal, so app will start transport page!");
      }
      paramarpu = new Intent();
      paramarpu.putExtra("param_start", 4);
      PublicFragmentActivity.a(getActivity(), paramarpu, MsgBackupTransportFragment.class, 1000);
      return;
    }
    label334:
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
    setTitle(getActivity().getString(2131624802));
  }
  
  protected void c()
  {
    super.c();
    if (AppSetting.c) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131641134));
    }
    this.c.setText(getResources().getString(2131624869));
    this.c.setTextColor(getResources().getColor(2131101260));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d = new MsgBackupQRFragment.2(this);
  }
  
  protected void d()
  {
    super.d();
    this.vg.setOnItemSelectListener(new arqz(this));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
      }
      arpa.a().d();
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
        arpa.a().k();
        arsa.a("0X800A239", 1);
        break;
      }
      label136:
      k();
      arsc.b("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
      continue;
      if (paramMessage.arg1 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label196;
        }
        bajq.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 0);
        bajq.a(this.c, 8);
        break;
      }
      label196:
      bajq.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131624869));
      this.c.setTextColor(getResources().getColor(2131101260));
      bajq.a(this.c, 0);
      continue;
      bajq.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131624870));
      this.c.setTextColor(getResources().getColor(2131100170));
      bajq.a(this.c, 0);
      continue;
      Object localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
      ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (!this.h)) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        arpa.a().k();
      }
      arsa.a("0X800A239", 2);
      continue;
      bajq.b(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.h = true;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupQRFragment", 2, "qr_code_src request qr onclick, isWaitingQrRsp = " + this.h);
    }
    paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10013);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramView);
    this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.7(this));
    arsa.a("0X800A23C");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Aroq != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Aroq);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
    arpa.a().l();
  }
  
  public void onPause()
  {
    super.onPause();
    arpa.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    arpa.a().a(getActivity());
    arpa.f = false;
  }
  
  public void onStop()
  {
    j();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment
 * JD-Core Version:    0.7.0.1
 */