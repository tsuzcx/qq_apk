package com.tencent.mobileqq.msgbackup.fragment;

import aekt;
import alpo;
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
import aubu;
import aucf;
import aucl;
import auct;
import aucz;
import auee;
import auey;
import auff;
import aufh;
import bdee;
import bdkf;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import gs;
import gw;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgBackupQRFragment
  extends MsgBackupBaseFragment
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private auct jdField_a_of_type_Auct;
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
      auff.a("0X800A241", 1);
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
    if (bdee.a(getActivity()) == 1)
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
  
  private void b(auct paramauct)
  {
    if (paramauct == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "refreshQRLayout QRCode fail, data is null!");
      }
      return;
    }
    String str1 = paramauct.b();
    String str2 = paramauct.a();
    String str3 = paramauct.c();
    int i = paramauct.a();
    aucf localaucf = aucf.a();
    auey localauey = localaucf.a();
    localauey.b(str3);
    localaucf.a().b(str1);
    localaucf.a().a(str2);
    localaucf.a().a(i);
    localauey.c(2);
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_e_of_type_JavaLangRunnable, 800L);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.post(new MsgBackupQRFragment.5(this, paramauct));
      return;
    }
    b(a(paramauct));
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
  
  public Bitmap a(auct paramauct)
  {
    Object localObject;
    if (paramauct == null)
    {
      paramauct = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
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
        i = aekt.a(200.0F, getResources());
        paramauct = new gw().a(paramauct, i, i, (Map)localObject);
        k = paramauct.a();
        m = paramauct.b();
        localObject = new int[k * m];
        i = 0;
      }
      catch (Exception paramauct)
      {
        int k;
        boolean bool;
        QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramauct);
        return null;
      }
      if (j < k)
      {
        if (paramauct.a(j, i)) {
          localObject[(i * k + j)] = -16777216;
        }
        j += 1;
        continue;
        paramauct = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=" + paramauct.a();
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
        aufh.b("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
        this.jdField_a_of_type_AndroidGraphicsBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
        paramauct = this.jdField_a_of_type_AndroidGraphicsBitmap;
        return paramauct;
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
    aufh.b("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.jdField_a_of_type_Aubv != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Aubv);
    }
    Object localObject = new HashSet(aucf.a().jdField_a_of_type_JavaUtilHashSet.size());
    ((HashSet)localObject).addAll(aucf.a().jdField_a_of_type_JavaUtilHashSet);
    aucf.b = aucf.a().jdField_a_of_type_JavaUtilHashSet.size();
    auff.a();
    auff.a.b = aucf.b;
    aucl localaucl = new aucl();
    aufh.b("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    localaucl.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    localaucl.jdField_a_of_type_Int = 0;
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
    aufh.b("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(this.f) });
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localaucl.jdField_a_of_type_Long = l1;
      localaucl.b = l2;
      if (i == 2)
      {
        bool = true;
        localaucl.jdField_a_of_type_Boolean = bool;
        getActivity().app.addObserver(this.jdField_a_of_type_Aubv);
        aucf.a().i();
        aucf.a().a(localaucl);
        if (bdee.a(getActivity()) != 1) {
          break label541;
        }
      }
    }
    label541:
    for (boolean bool = true;; bool = false)
    {
      if ((!this.f) && (bool))
      {
        aucf.a().a(false);
        this.g = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
        }
      }
      this.jdField_e_of_type_Boolean = bool;
      aufh.b("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      if (!bool) {
        a(bool, false);
      }
      this.jdField_a_of_type_Auct = aucf.a().a();
      if ((this.jdField_a_of_type_Auct != null) && (bool))
      {
        aufh.b("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
        this.h = false;
        b(this.jdField_a_of_type_Auct);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.d);
      return;
      bool = false;
      break;
      localaucl.jdField_a_of_type_Long = 0L;
      localaucl.b = 9223372036854775807L;
      if (i == 2) {}
      for (bool = true;; bool = false)
      {
        localaucl.jdField_a_of_type_Boolean = bool;
        break;
      }
    }
  }
  
  protected void a(auct paramauct)
  {
    super.a(paramauct);
    this.h = false;
    b(paramauct);
    aucf.a().o();
  }
  
  protected void a(aucz paramaucz)
  {
    super.a(paramaucz);
    if (paramaucz != null)
    {
      if (paramaucz.a() != 2) {
        break label334;
      }
      if (this.d != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: " + paramaucz);
      }
      if (!aucf.d) {
        break label83;
      }
      QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
    }
    label83:
    while ((paramaucz.a() == 1) || (paramaucz.a() == 3) || (paramaucz.a() != 4))
    {
      do
      {
        return;
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        String str1 = paramaucz.b();
        String str2 = paramaucz.a();
        int i = paramaucz.b();
        MsgBackupEndPoint localMsgBackupEndPoint1 = new MsgBackupEndPoint();
        MsgBackupEndPoint localMsgBackupEndPoint2 = new MsgBackupEndPoint();
        int j = aufh.a(paramaucz.a().a());
        localMsgBackupEndPoint1.ipv4 = j;
        localMsgBackupEndPoint2.ipv4 = j;
        paramaucz = paramaucz.a().a();
        if (paramaucz.size() == 2)
        {
          localMsgBackupEndPoint2.port = ((Integer)paramaucz.get(0)).intValue();
          localMsgBackupEndPoint1.port = ((Integer)paramaucz.get(1)).intValue();
        }
        paramaucz = aucf.a();
        auey localauey = paramaucz.a();
        localauey.b(str1);
        localauey.b(localMsgBackupEndPoint2);
        localauey.a(localMsgBackupEndPoint1);
        paramaucz.a().a(i);
        paramaucz.a().b(str2);
        localauey.c(2);
        localauey.b(2);
        aucf.d = true;
      } while ((getActivity() == null) || (getActivity().isFinishing()));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp has deal, so app will start transport page!");
      }
      paramaucz = new Intent();
      paramaucz.putExtra("param_start", 4);
      PublicFragmentActivity.a(getActivity(), paramaucz, MsgBackupTransportFragment.class, 1000);
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
    setTitle(getActivity().getString(2131690414));
  }
  
  protected void c()
  {
    super.c();
    if (AppSetting.c) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131707302));
    }
    this.c.setText(getResources().getString(2131690481));
    this.c.setTextColor(getResources().getColor(2131166901));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d = new MsgBackupQRFragment.2(this);
  }
  
  protected void d()
  {
    super.d();
    this.vg.setOnItemSelectListener(new auee(this));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
      }
      aucf.a().d();
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
        aucf.a().k();
        auff.a("0X800A239", 1);
        break;
      }
      label136:
      k();
      aufh.b("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
      continue;
      if (paramMessage.arg1 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label196;
        }
        bdkf.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 0);
        bdkf.a(this.c, 8);
        break;
      }
      label196:
      bdkf.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690481));
      this.c.setTextColor(getResources().getColor(2131166901));
      bdkf.a(this.c, 0);
      continue;
      bdkf.a(this.jdField_e_of_type_AndroidWidgetLinearLayout, 8);
      this.c.setText(getResources().getString(2131690482));
      this.c.setTextColor(getResources().getColor(2131165798));
      bdkf.a(this.c, 0);
      continue;
      Object localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
      ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (!this.h)) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        aucf.a().k();
      }
      auff.a("0X800A239", 2);
      continue;
      bdkf.b(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
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
    auff.a("0X800A23C");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Aubv != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Aubv);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.d);
    aucf.a().l();
  }
  
  public void onPause()
  {
    super.onPause();
    aucf.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    aucf.a().a(getActivity());
    aucf.f = false;
  }
  
  public void onStop()
  {
    j();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment
 * JD-Core Version:    0.7.0.1
 */