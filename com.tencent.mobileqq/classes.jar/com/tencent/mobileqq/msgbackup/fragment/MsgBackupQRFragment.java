package com.tencent.mobileqq.msgbackup.fragment;

import actj;
import ajya;
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
import askv;
import aslg;
import aslm;
import aslu;
import asma;
import asnf;
import asnz;
import asog;
import asoi;
import bbfj;
import bbll;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import ij;
import in;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgBackupQRFragment
  extends MsgBackupBaseFragment
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private aslu jdField_a_of_type_Aslu;
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
      asog.a("0X800A241", 1);
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
    if (bbfj.a(getActivity()) == 1)
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
  
  private void b(aslu paramaslu)
  {
    if (paramaslu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "refreshQRLayout QRCode fail, data is null!");
      }
      return;
    }
    String str1 = paramaslu.b();
    String str2 = paramaslu.a();
    String str3 = paramaslu.c();
    int i = paramaslu.a();
    aslg localaslg = aslg.a();
    asnz localasnz = localaslg.a();
    localasnz.b(str3);
    localaslg.a().b(str1);
    localaslg.a().a(str2);
    localaslg.a().a(i);
    localasnz.c(2);
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_e_of_type_JavaLangRunnable, 800L);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.5(this, paramaslu));
      return;
    }
    b(a(paramaslu));
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
  
  public Bitmap a(aslu paramaslu)
  {
    Object localObject;
    if (paramaslu == null)
    {
      paramaslu = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
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
        i = actj.a(200.0F, getResources());
        paramaslu = new in().a(paramaslu, i, i, (Map)localObject);
        k = paramaslu.a();
        m = paramaslu.b();
        localObject = new int[k * m];
        i = 0;
      }
      catch (Exception paramaslu)
      {
        int k;
        boolean bool;
        QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramaslu);
        return null;
      }
      if (j < k)
      {
        if (paramaslu.a(j, i)) {
          localObject[(i * k + j)] = -16777216;
        }
        j += 1;
        continue;
        paramaslu = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=" + paramaslu.a();
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
        asoi.b("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
        this.jdField_a_of_type_AndroidGraphicsBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
        paramaslu = this.jdField_a_of_type_AndroidGraphicsBitmap;
        return paramaslu;
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
    asoi.b("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.jdField_a_of_type_Askw != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Askw);
    }
    Object localObject = new HashSet(aslg.a().jdField_a_of_type_JavaUtilHashSet.size());
    ((HashSet)localObject).addAll(aslg.a().jdField_a_of_type_JavaUtilHashSet);
    aslg.b = aslg.a().jdField_a_of_type_JavaUtilHashSet.size();
    asog.a();
    asog.a.b = aslg.b;
    aslm localaslm = new aslm();
    asoi.b("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    localaslm.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    localaslm.jdField_a_of_type_Int = 0;
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
    asoi.b("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(this.f) });
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localaslm.jdField_a_of_type_Long = l1;
      localaslm.b = l2;
      if (i == 2)
      {
        bool = true;
        localaslm.jdField_a_of_type_Boolean = bool;
        getActivity().app.addObserver(this.jdField_a_of_type_Askw);
        aslg.a().i();
        aslg.a().a(localaslm);
        if (bbfj.a(getActivity()) != 1) {
          break label541;
        }
      }
    }
    label541:
    for (boolean bool = true;; bool = false)
    {
      if ((!this.f) && (bool))
      {
        aslg.a().a(false);
        this.g = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
        }
      }
      this.jdField_e_of_type_Boolean = bool;
      asoi.b("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      if (!bool) {
        a(bool, false);
      }
      this.jdField_a_of_type_Aslu = aslg.a().a();
      if ((this.jdField_a_of_type_Aslu != null) && (bool))
      {
        asoi.b("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
        this.h = false;
        b(this.jdField_a_of_type_Aslu);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.d);
      return;
      bool = false;
      break;
      localaslm.jdField_a_of_type_Long = 0L;
      localaslm.b = 9223372036854775807L;
      if (i == 2) {}
      for (bool = true;; bool = false)
      {
        localaslm.jdField_a_of_type_Boolean = bool;
        break;
      }
    }
  }
  
  protected void a(aslu paramaslu)
  {
    super.a(paramaslu);
    this.h = false;
    b(paramaslu);
    aslg.a().o();
  }
  
  protected void a(asma paramasma)
  {
    super.a(paramasma);
    if (paramasma != null)
    {
      if (paramasma.a() != 2) {
        break label334;
      }
      if (this.d != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: " + paramasma);
      }
      if (!aslg.d) {
        break label83;
      }
      QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
    }
    label83:
    while ((paramasma.a() == 1) || (paramasma.a() == 3) || (paramasma.a() != 4))
    {
      do
      {
        return;
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        String str1 = paramasma.b();
        String str2 = paramasma.a();
        int i = paramasma.b();
        MsgBackupEndPoint localMsgBackupEndPoint1 = new MsgBackupEndPoint();
        MsgBackupEndPoint localMsgBackupEndPoint2 = new MsgBackupEndPoint();
        int j = asoi.a(paramasma.a().a());
        localMsgBackupEndPoint1.ipv4 = j;
        localMsgBackupEndPoint2.ipv4 = j;
        paramasma = paramasma.a().a();
        if (paramasma.size() == 2)
        {
          localMsgBackupEndPoint2.port = ((Integer)paramasma.get(0)).intValue();
          localMsgBackupEndPoint1.port = ((Integer)paramasma.get(1)).intValue();
        }
        paramasma = aslg.a();
        asnz localasnz = paramasma.a();
        localasnz.b(str1);
        localasnz.b(localMsgBackupEndPoint2);
        localasnz.a(localMsgBackupEndPoint1);
        paramasma.a().a(i);
        paramasma.a().b(str2);
        localasnz.c(2);
        localasnz.b(2);
        aslg.d = true;
      } while ((getActivity() == null) || (getActivity().isFinishing()));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp has deal, so app will start transport page!");
      }
      paramasma = new Intent();
      paramasma.putExtra("param_start", 4);
      PublicFragmentActivity.a(getActivity(), paramasma, MsgBackupTransportFragment.class, 1000);
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
    setTitle(getActivity().getString(2131690363));
  }
  
  protected void c()
  {
    super.c();
    if (AppSetting.d) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131706930));
    }
    this.c.setText(getResources().getString(2131690430));
    this.c.setTextColor(getResources().getColor(2131166854));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d = new MsgBackupQRFragment.2(this);
  }
  
  protected void d()
  {
    super.d();
    this.vg.setOnItemSelectListener(new asnf(this));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
      }
      aslg.a().d();
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
        aslg.a().k();
        asog.a("0X800A239", 1);
        break;
      }
      label136:
      k();
      asoi.b("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
      continue;
      if (paramMessage.arg1 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label196;
        }
        bbll.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 0);
        bbll.a(this.c, 8);
        break;
      }
      label196:
      bbll.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690430));
      this.c.setTextColor(getResources().getColor(2131166854));
      bbll.a(this.c, 0);
      continue;
      bbll.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690431));
      this.c.setTextColor(getResources().getColor(2131165760));
      bbll.a(this.c, 0);
      continue;
      Object localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
      ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (!this.h)) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        aslg.a().k();
      }
      asog.a("0X800A239", 2);
      continue;
      bbll.b(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
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
    asog.a("0X800A23C");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Askw != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Askw);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
    aslg.a().l();
  }
  
  public void onPause()
  {
    super.onPause();
    aslg.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    aslg.a().a(getActivity());
    aslg.f = false;
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