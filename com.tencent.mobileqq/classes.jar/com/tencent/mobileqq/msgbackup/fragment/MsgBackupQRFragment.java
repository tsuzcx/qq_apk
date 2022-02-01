package com.tencent.mobileqq.msgbackup.fragment;

import agej;
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
import anzj;
import axfy;
import axgj;
import axgp;
import axgx;
import axhd;
import axii;
import axjd;
import axjk;
import axjn;
import bhnv;
import bhtq;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gt;
import gx;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgBackupQRFragment
  extends MsgBackupBaseFragment
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private axgx jdField_a_of_type_Axgx;
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
      axjk.a("0X800A241", 1);
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
    if (bhnv.a(getActivity()) == 1)
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
  
  private void b(axgx paramaxgx)
  {
    if (paramaxgx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "refreshQRLayout QRCode fail, data is null!");
      }
      return;
    }
    String str1 = paramaxgx.b();
    String str2 = paramaxgx.a();
    String str3 = paramaxgx.c();
    int i = paramaxgx.a();
    axgj localaxgj = axgj.a();
    axjd localaxjd = localaxgj.a();
    localaxjd.d(str3);
    localaxgj.a().b(str1);
    localaxgj.a().a(str2);
    localaxgj.a().a(i);
    localaxjd.g(2);
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_e_of_type_JavaLangRunnable, 800L);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.5(this, paramaxgx));
      return;
    }
    b(a(paramaxgx));
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
  
  public Bitmap a(axgx paramaxgx)
  {
    Object localObject;
    if (paramaxgx == null)
    {
      paramaxgx = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
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
        i = agej.a(200.0F, getResources());
        paramaxgx = new gx().a(paramaxgx, i, i, (Map)localObject);
        k = paramaxgx.a();
        m = paramaxgx.b();
        localObject = new int[k * m];
        i = 0;
      }
      catch (Exception paramaxgx)
      {
        int k;
        boolean bool;
        QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramaxgx);
        return null;
      }
      if (j < k)
      {
        if (paramaxgx.a(j, i)) {
          localObject[(i * k + j)] = -16777216;
        }
        j += 1;
        continue;
        paramaxgx = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=" + paramaxgx.a();
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
        axjn.b("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
        this.jdField_a_of_type_AndroidGraphicsBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
        paramaxgx = this.jdField_a_of_type_AndroidGraphicsBitmap;
        return paramaxgx;
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
    axjn.b("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.jdField_a_of_type_Axfz != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Axfz);
    }
    Object localObject = new HashSet(axgj.a().jdField_a_of_type_JavaUtilHashSet.size());
    ((HashSet)localObject).addAll(axgj.a().jdField_a_of_type_JavaUtilHashSet);
    axgj.b = axgj.a().jdField_a_of_type_JavaUtilHashSet.size();
    axjk.a();
    axjk.a.b = axgj.b;
    axgp localaxgp = new axgp();
    axjn.b("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    localaxgp.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    localaxgp.jdField_a_of_type_Int = 0;
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
    axjn.b("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(this.f) });
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localaxgp.jdField_a_of_type_Long = l1;
      localaxgp.b = l2;
      if (i == 2)
      {
        bool = true;
        localaxgp.jdField_a_of_type_Boolean = bool;
        getActivity().app.addObserver(this.jdField_a_of_type_Axfz);
        axgj.a().i();
        axgj.a().a(localaxgp);
        if (bhnv.a(getActivity()) != 1) {
          break label541;
        }
      }
    }
    label541:
    for (boolean bool = true;; bool = false)
    {
      if ((!this.f) && (bool))
      {
        axgj.a().a(false);
        this.g = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
        }
      }
      this.jdField_e_of_type_Boolean = bool;
      axjn.b("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      if (!bool) {
        a(bool, false);
      }
      this.jdField_a_of_type_Axgx = axgj.a().a();
      if ((this.jdField_a_of_type_Axgx != null) && (bool))
      {
        axjn.b("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
        this.h = false;
        b(this.jdField_a_of_type_Axgx);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.d);
      return;
      bool = false;
      break;
      localaxgp.jdField_a_of_type_Long = 0L;
      localaxgp.b = 9223372036854775807L;
      if (i == 2) {}
      for (bool = true;; bool = false)
      {
        localaxgp.jdField_a_of_type_Boolean = bool;
        break;
      }
    }
  }
  
  protected void a(axgx paramaxgx)
  {
    super.a(paramaxgx);
    this.h = false;
    b(paramaxgx);
    axgj.a().o();
  }
  
  protected void a(axhd paramaxhd)
  {
    int i = 0;
    super.a(paramaxhd);
    if (paramaxhd != null)
    {
      if (paramaxhd.a() != 2) {
        break label356;
      }
      if (this.d != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: " + paramaxhd);
      }
      if (axgj.d) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    String str1 = paramaxhd.b();
    String str2 = paramaxhd.a();
    int k = paramaxhd.b();
    String str3 = paramaxhd.a().a();
    paramaxhd = paramaxhd.a().a();
    int j;
    if (paramaxhd.size() == 2)
    {
      j = ((Integer)paramaxhd.get(0)).intValue();
      i = ((Integer)paramaxhd.get(1)).intValue();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: client ip = " + str3 + ", udpport = " + i + ", tcpport = " + j);
      }
      paramaxhd = axgj.a();
      axjd localaxjd = paramaxhd.a();
      localaxjd.d(str1);
      localaxjd.b(str3);
      localaxjd.b(j);
      localaxjd.a(i);
      paramaxhd.a().a(k);
      paramaxhd.a().b(str2);
      localaxjd.g(2);
      localaxjd.f(2);
      axgj.d = true;
      if ((getActivity() == null) || (getActivity().isFinishing())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has deal, so app will start transport page!");
      }
      paramaxhd = new Intent();
      paramaxhd.putExtra("param_start", 4);
      PublicFragmentActivity.a(getActivity(), paramaxhd, MsgBackupTransportFragment.class, 1000);
      return;
      label356:
      if ((paramaxhd.a() == 1) || (paramaxhd.a() == 3) || (paramaxhd.a() != 4)) {
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
    setTitle(getActivity().getString(2131690409));
  }
  
  protected void c()
  {
    super.c();
    if (AppSetting.c) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131705812));
    }
    this.c.setText(getResources().getString(2131690463));
    this.c.setTextColor(getResources().getColor(2131166990));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d = new MsgBackupQRFragment.2(this);
  }
  
  protected void d()
  {
    super.d();
    this.vg.setOnItemSelectListener(new axii(this));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
      }
      axgj.a().d();
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
        axgj.a().k();
        axjk.a("0X800A239", 1);
        break;
      }
      label136:
      k();
      axjn.b("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
      continue;
      if (paramMessage.arg1 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label196;
        }
        bhtq.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 0);
        bhtq.a(this.c, 8);
        break;
      }
      label196:
      bhtq.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690463));
      this.c.setTextColor(getResources().getColor(2131166990));
      bhtq.a(this.c, 0);
      continue;
      bhtq.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690464));
      this.c.setTextColor(getResources().getColor(2131165848));
      bhtq.a(this.c, 0);
      continue;
      Object localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
      ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (!this.h)) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        axgj.a().k();
      }
      axjk.a("0X800A239", 2);
      continue;
      bhtq.b(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
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
      axjk.a("0X800A23C");
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
    if (this.jdField_a_of_type_Axfz != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Axfz);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
    axgj.a().l();
  }
  
  public void onPause()
  {
    super.onPause();
    axgj.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    axgj.a().a(getActivity());
    axgj.f = false;
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