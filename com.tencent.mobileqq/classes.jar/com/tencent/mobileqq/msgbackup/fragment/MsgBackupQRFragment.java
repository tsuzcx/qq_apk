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
import anvx;
import awzh;
import awzs;
import awzy;
import axag;
import axam;
import axbr;
import axcm;
import axct;
import axcw;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gr;
import gv;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgBackupQRFragment
  extends MsgBackupBaseFragment
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private axag jdField_a_of_type_Axag;
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
      axct.a("0X800A241", 1);
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
    if (NetworkUtil.getSystemNetwork(getActivity()) == 1)
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
  
  private void b(axag paramaxag)
  {
    if (paramaxag == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "refreshQRLayout QRCode fail, data is null!");
      }
      return;
    }
    String str1 = paramaxag.b();
    String str2 = paramaxag.a();
    String str3 = paramaxag.c();
    int i = paramaxag.a();
    awzs localawzs = awzs.a();
    axcm localaxcm = localawzs.a();
    localaxcm.d(str3);
    localawzs.a().b(str1);
    localawzs.a().a(str2);
    localawzs.a().a(i);
    localaxcm.g(2);
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_e_of_type_JavaLangRunnable, 800L);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.5(this, paramaxag));
      return;
    }
    b(a(paramaxag));
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
  
  public Bitmap a(axag paramaxag)
  {
    Object localObject;
    if (paramaxag == null)
    {
      paramaxag = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
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
        i = AIOUtils.dp2px(200.0F, getResources());
        paramaxag = new gv().a(paramaxag, i, i, (Map)localObject);
        k = paramaxag.a();
        m = paramaxag.b();
        localObject = new int[k * m];
        i = 0;
      }
      catch (Exception paramaxag)
      {
        int k;
        boolean bool;
        QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramaxag);
        return null;
      }
      if (j < k)
      {
        if (paramaxag.a(j, i)) {
          localObject[(i * k + j)] = -16777216;
        }
        j += 1;
        continue;
        paramaxag = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=" + paramaxag.a();
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
        axcw.b("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
        this.jdField_a_of_type_AndroidGraphicsBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
        paramaxag = this.jdField_a_of_type_AndroidGraphicsBitmap;
        return paramaxag;
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
    axcw.b("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.jdField_a_of_type_Awzi != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Awzi);
    }
    Object localObject = new HashSet(awzs.a().jdField_a_of_type_JavaUtilHashSet.size());
    ((HashSet)localObject).addAll(awzs.a().jdField_a_of_type_JavaUtilHashSet);
    awzs.b = awzs.a().jdField_a_of_type_JavaUtilHashSet.size();
    axct.a();
    axct.a.b = awzs.b;
    awzy localawzy = new awzy();
    axcw.b("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    localawzy.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    localawzy.jdField_a_of_type_Int = 0;
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
    axcw.b("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(this.f) });
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localawzy.jdField_a_of_type_Long = l1;
      localawzy.b = l2;
      if (i == 2)
      {
        bool = true;
        localawzy.jdField_a_of_type_Boolean = bool;
        getActivity().app.addObserver(this.jdField_a_of_type_Awzi);
        awzs.a().i();
        awzs.a().a(localawzy);
        if (NetworkUtil.getSystemNetwork(getActivity()) != 1) {
          break label541;
        }
      }
    }
    label541:
    for (boolean bool = true;; bool = false)
    {
      if ((!this.f) && (bool))
      {
        awzs.a().a(false);
        this.g = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
        }
      }
      this.jdField_e_of_type_Boolean = bool;
      axcw.b("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      if (!bool) {
        a(bool, false);
      }
      this.jdField_a_of_type_Axag = awzs.a().a();
      if ((this.jdField_a_of_type_Axag != null) && (bool))
      {
        axcw.b("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
        this.h = false;
        b(this.jdField_a_of_type_Axag);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.d);
      return;
      bool = false;
      break;
      localawzy.jdField_a_of_type_Long = 0L;
      localawzy.b = 9223372036854775807L;
      if (i == 2) {}
      for (bool = true;; bool = false)
      {
        localawzy.jdField_a_of_type_Boolean = bool;
        break;
      }
    }
  }
  
  protected void a(axag paramaxag)
  {
    super.a(paramaxag);
    this.h = false;
    b(paramaxag);
    awzs.a().o();
  }
  
  protected void a(axam paramaxam)
  {
    int i = 0;
    super.a(paramaxam);
    if (paramaxam != null)
    {
      if (paramaxam.a() != 2) {
        break label356;
      }
      if (this.d != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: " + paramaxam);
      }
      if (awzs.d) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    String str1 = paramaxam.b();
    String str2 = paramaxam.a();
    int k = paramaxam.b();
    String str3 = paramaxam.a().a();
    paramaxam = paramaxam.a().a();
    int j;
    if (paramaxam.size() == 2)
    {
      j = ((Integer)paramaxam.get(0)).intValue();
      i = ((Integer)paramaxam.get(1)).intValue();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: client ip = " + str3 + ", udpport = " + i + ", tcpport = " + j);
      }
      paramaxam = awzs.a();
      axcm localaxcm = paramaxam.a();
      localaxcm.d(str1);
      localaxcm.b(str3);
      localaxcm.b(j);
      localaxcm.a(i);
      paramaxam.a().a(k);
      paramaxam.a().b(str2);
      localaxcm.g(2);
      localaxcm.f(2);
      awzs.d = true;
      if ((getActivity() == null) || (getActivity().isFinishing())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has deal, so app will start transport page!");
      }
      paramaxam = new Intent();
      paramaxam.putExtra("param_start", 4);
      PublicFragmentActivity.a(getActivity(), paramaxam, MsgBackupTransportFragment.class, 1000);
      return;
      label356:
      if ((paramaxam.a() == 1) || (paramaxam.a() == 3) || (paramaxam.a() != 4)) {
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
    setTitle(getActivity().getString(2131690524));
  }
  
  protected void c()
  {
    super.c();
    if (AppSetting.c) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131706394));
    }
    this.c.setText(getResources().getString(2131690578));
    this.c.setTextColor(getResources().getColor(2131167026));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d = new MsgBackupQRFragment.2(this);
  }
  
  protected void d()
  {
    super.d();
    this.vg.setOnItemSelectListener(new axbr(this));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
      }
      awzs.a().d();
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
        awzs.a().k();
        axct.a("0X800A239", 1);
        break;
      }
      label136:
      k();
      axcw.b("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
      continue;
      if (paramMessage.arg1 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label196;
        }
        ViewUtils.setViewVisibility(this.jdField_e_of_type_AndroidWidgetLinearLayout, 0);
        ViewUtils.setViewVisibility(this.c, 8);
        break;
      }
      label196:
      ViewUtils.setViewVisibility(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690578));
      this.c.setTextColor(getResources().getColor(2131167026));
      ViewUtils.setViewVisibility(this.c, 0);
      continue;
      ViewUtils.setViewVisibility(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690579));
      this.c.setTextColor(getResources().getColor(2131165875));
      ViewUtils.setViewVisibility(this.c, 0);
      continue;
      Object localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
      ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (!this.h)) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        awzs.a().k();
      }
      axct.a("0X800A239", 2);
      continue;
      ViewUtils.setVisible(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
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
      axct.a("0X800A23C");
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
    if (this.jdField_a_of_type_Awzi != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Awzi);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
    awzs.a().l();
  }
  
  public void onPause()
  {
    super.onPause();
    awzs.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    awzs.a().a(getActivity());
    awzs.f = false;
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