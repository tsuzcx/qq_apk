package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupRequest;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;

public class MsgBackupPCTransportFragment
  extends MsgBackupPcBaseFragment
{
  private void n()
  {
    this.vg.setLeftBackVisible(8);
    this.vg.setLeftButton(2131690633);
    this.vg.setRightButton(2131690615);
    this.vg.setOnItemSelectListener(new MsgBackupPCTransportFragment.1(this));
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return;
    }
    this.vg.hideLeft();
  }
  
  private void o()
  {
    this.f = true;
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165877));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690627);
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      MsgBackupReporter.a("0X800A264", 1);
      return;
    }
    MsgBackupReporter.a("0X800A287", 1);
  }
  
  private void p()
  {
    this.f = false;
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (this.jdField_e_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165878));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690630);
  }
  
  protected void a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.a();
    MsgBackupUtil.a();
    this.jdField_c_of_type_Int = MsgBackupManager.jdField_b_of_type_Int;
    if (MsgBackupTransportProcessor.a().e() == 1) {
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
    }
    int i;
    Object localObject1;
    label161:
    Object localObject2;
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 5: 
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = MsgBackupManager.a().a();
      MsgBackupManager.jdField_a_of_type_Boolean = false;
      int j = MsgBackupManager.a().a();
      this.jdField_d_of_type_Int = j;
      c(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
      i = j;
      if (j != MsgBackupManager.jdField_b_of_type_Int) {
        i = j + 1;
      }
      if (MsgBackupTransportProcessor.a().e() == 1)
      {
        localObject1 = getActivity().getResources().getString(2131690679);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null)
        {
          localObject2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format((String)localObject1, new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_c_of_type_Int), (String)localObject2 + "B/s" }));
        }
        if (!MsgBackupTransportProcessor.a().b()) {
          break label296;
        }
        p();
      }
      for (;;)
      {
        MsgBackupManager.a().a().a(this);
        if (MsgBackupTransportProcessor.a().e() != 2) {
          break label303;
        }
        if (!this.jdField_e_of_type_Boolean) {
          break;
        }
        MsgBackupReporter.a("0X800A261");
        return;
        localObject1 = getActivity().getResources().getString(2131690678);
        break label161;
        label296:
        o();
      }
      label303:
      MsgBackupReporter.a("0X800A285");
      return;
    }
    long l2;
    long l1;
    if (MsgBackupManager.a().a().a() == 1)
    {
      MsgBackupManager.a().a().a(this);
      if (this.jdField_e_of_type_Boolean) {
        MsgBackupManager.a().a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      MsgBackupManager.jdField_b_of_type_Int = MsgBackupManager.a().jdField_a_of_type_JavaUtilHashSet.size();
      MsgBackupReporter.a();
      MsgBackupReporter.a.b = MsgBackupManager.jdField_b_of_type_Int;
      localObject1 = new MsgBackupRequest();
      localObject2 = new HashSet(MsgBackupManager.a().jdField_a_of_type_JavaUtilHashSet.size());
      ((HashSet)localObject2).addAll(MsgBackupManager.a().jdField_a_of_type_JavaUtilHashSet);
      ((MsgBackupRequest)localObject1).jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject2);
      ((MsgBackupRequest)localObject1).jdField_a_of_type_Int = 0;
      if (getActivity() == null) {
        break label658;
      }
      localObject2 = getActivity().getIntent();
      if (localObject2 == null) {
        break label658;
      }
      l2 = ((Intent)localObject2).getLongExtra("session_start_time", 0L);
      l1 = ((Intent)localObject2).getLongExtra("session_end_time", 0L);
      i = ((Intent)localObject2).getIntExtra("session_content_type", 1);
    }
    for (;;)
    {
      MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "select params startTime = %d ,endTime = %d,contentType = %d ", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      if ((l2 != 0L) && (l1 != 0L) && (l2 < l1))
      {
        ((MsgBackupRequest)localObject1).jdField_a_of_type_Long = l2;
        ((MsgBackupRequest)localObject1).b = l1;
        if (i == 2) {}
        for (;;)
        {
          ((MsgBackupRequest)localObject1).jdField_a_of_type_Boolean = bool1;
          MsgBackupManager.a().a((MsgBackupRequest)localObject1);
          return;
          bool1 = false;
        }
      }
      ((MsgBackupRequest)localObject1).jdField_a_of_type_Long = 0L;
      ((MsgBackupRequest)localObject1).b = 9223372036854775807L;
      if (i == 2) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ((MsgBackupRequest)localObject1).jdField_a_of_type_Boolean = bool1;
        break;
      }
      MsgBackupManager.a().a().a(this);
      MsgBackupManager.a().a().j(4);
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      MsgBackupManager.a().a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return;
      label658:
      i = 1;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionProgress finishedSessions = " + paramInt1 + ", totalSession = " + paramInt2 + ", isStart = " + this.jdField_a_of_type_Boolean);
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    if (paramInt1 == paramInt2) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt1;
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10003);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "speedState!!! increment = " + paramLong + " , isStart = " + this.jdField_a_of_type_Boolean + ", MsgBackupManager.isTransportStart = " + MsgBackupManager.jdField_e_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) || (MsgBackupManager.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_Long = paramLong;
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10002);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((!paramBoolean) && (this.jdField_c_of_type_JavaLangRunnable != null)) {
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.jdField_c_of_type_JavaLangRunnable);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10007);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "mBizType = " + this.jdField_b_of_type_Int);
    }
    if (paramBoolean)
    {
      localObject1 = (MsgBackupConfirmQrRsp)paramObject;
      if (this.jdField_b_of_type_Int != 1) {
        break label285;
      }
      if (paramObject != null) {
        break label81;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: backup data is null!");
      }
    }
    label81:
    int i;
    label285:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject2 = ((MsgBackupConfirmQrRsp)localObject1).b();
            paramObject = ((MsgBackupConfirmQrRsp)localObject1).a();
            i = ((MsgBackupConfirmQrRsp)localObject1).a();
            localObject3 = ((MsgBackupConfirmQrRsp)localObject1).a().a();
          } while (((List)localObject3).size() != 2);
          localObject1 = ((MsgBackupConfirmQrRsp)localObject1).a().a();
          j = ((Integer)((List)localObject3).get(0)).intValue();
          k = ((Integer)((List)localObject3).get(1)).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: backup client ip = " + (String)localObject1 + ", udpport = " + k + ", tcpport = " + j);
          }
          localObject3 = MsgBackupManager.a().a();
          ((MsgBackupTransportProcessor)localObject3).d((String)localObject2);
          localObject2 = MsgBackupAuthProcessor.a();
          ((MsgBackupAuthProcessor)localObject2).b(paramObject);
          ((MsgBackupAuthProcessor)localObject2).a(i);
          ((MsgBackupTransportProcessor)localObject3).b((String)localObject1);
          ((MsgBackupTransportProcessor)localObject3).b(j);
          ((MsgBackupTransportProcessor)localObject3).a(k);
          ((MsgBackupTransportProcessor)localObject3).g(2);
          ((MsgBackupTransportProcessor)localObject3).f(2);
          return;
        } while (this.jdField_b_of_type_Int != 2);
        if (paramObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: restore data is null!");
      return;
      localObject2 = ((MsgBackupConfirmQrRsp)localObject1).b();
      paramObject = ((MsgBackupConfirmQrRsp)localObject1).a();
      i = ((MsgBackupConfirmQrRsp)localObject1).a();
      localObject3 = ((MsgBackupConfirmQrRsp)localObject1).a().a();
    } while (((List)localObject3).size() != 2);
    Object localObject1 = ((MsgBackupConfirmQrRsp)localObject1).a().a();
    int j = ((Integer)((List)localObject3).get(0)).intValue();
    int k = ((Integer)((List)localObject3).get(1)).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmRsp: restore server ip = " + (String)localObject1 + ", udpport = " + k + ", tcpport = " + j);
    }
    Object localObject3 = MsgBackupManager.a().a();
    ((MsgBackupTransportProcessor)localObject3).d((String)localObject2);
    Object localObject2 = MsgBackupAuthProcessor.a();
    ((MsgBackupAuthProcessor)localObject2).b(paramObject);
    ((MsgBackupAuthProcessor)localObject2).a(i);
    ((MsgBackupTransportProcessor)localObject3).c((String)localObject1);
    ((MsgBackupTransportProcessor)localObject3).d(j);
    ((MsgBackupTransportProcessor)localObject3).c(k);
    ((MsgBackupTransportProcessor)localObject3).g(1);
    ((MsgBackupTransportProcessor)localObject3).f(1);
  }
  
  public void ay_()
  {
    super.ay_();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
    {
      if (!this.f) {
        break label56;
      }
      MsgBackupReporter.a("0X800A266", 3);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 2)
      {
        if (this.f) {
          break;
        }
        MsgBackupReporter.a("0X800A288", 1);
      }
      return;
      label56:
      if (!this.jdField_a_of_type_Boolean) {
        MsgBackupReporter.a("0X800A266", 1);
      } else {
        MsgBackupReporter.a("0X800A266", 2);
      }
    }
    MsgBackupReporter.a("0X800A288", 2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "pc退出了！------------------>exit called! ");
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10008);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  protected void c()
  {
    super.c();
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetLinearLayout, 8);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetLinearLayout, 8);
    ViewUtils.b(this.jdField_c_of_type_AndroidWidgetLinearLayout, 8);
    ViewUtils.b(this.jdField_d_of_type_AndroidWidgetLinearLayout, 0);
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841465);
    }
    for (;;)
    {
      switch (this.jdField_a_of_type_Int)
      {
      case 3: 
      case 4: 
      default: 
        return;
        if (this.jdField_b_of_type_Int == 2) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841464);
        }
        break;
      }
    }
    n();
    this.jdField_c_of_type_Boolean = MsgBackupTransportProcessor.a().b();
    if (this.jdField_c_of_type_Boolean)
    {
      p();
      return;
    }
    o();
    return;
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690677);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690630);
    n();
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == 0) {}
    do
    {
      return;
      paramInt1 = paramInt1 * 100 / paramInt2;
    } while (this.jdField_b_of_type_AndroidWidgetProgressBar == null);
    if (this.jdField_b_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Int == 1) {
      if (this.jdField_e_of_type_Boolean) {
        MsgBackupReporter.a("0X800A25F");
      }
    }
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    MsgBackupReporter.a("0X800A283");
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "doOnKeyDown is called! KEYCODE_BACK");
      }
      ay_();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    label112:
    String str2;
    int j;
    int k;
    switch (paramMessage.what)
    {
    default: 
    case 10008: 
    case 10003: 
      do
      {
        for (;;)
        {
          return super.handleMessage(paramMessage);
          l();
        }
      } while ((!this.jdField_a_of_type_Boolean) && (!MsgBackupManager.jdField_e_of_type_Boolean));
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841465);
        }
      }
      else
      {
        this.vg.setLeftButton(2131690633);
        str2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
        j = paramMessage.arg1;
        k = paramMessage.arg2;
        c(j, k);
        if (j == k) {
          break label754;
        }
      }
      break;
    }
    label357:
    label754:
    for (int i = j + 1;; i = j)
    {
      if (MsgBackupTransportProcessor.a().e() == 1) {}
      for (String str1 = getActivity().getResources().getString(2131690679);; str1 = getActivity().getResources().getString(2131690678))
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(k), str2 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690630);
        }
        if (j != k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionCompleted->>>>>>>>");
        }
        MsgBackupManager.a().a().a(null);
        if (MsgBackupTransportProcessor.a().e() != 1) {
          break label357;
        }
        MsgBackupCompleteFragment.j(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        break;
        if (this.jdField_b_of_type_Int != 2) {
          break label112;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841464);
        break label112;
      }
      MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Boolean);
      break;
      if ((!this.jdField_a_of_type_Boolean) && (!MsgBackupManager.jdField_e_of_type_Boolean)) {
        break;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841465);
        }
      }
      else
      {
        this.vg.setLeftButton(2131690633);
        str2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
        MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), str2 });
        j = this.jdField_d_of_type_Int;
        i = j;
        if (j != MsgBackupManager.jdField_b_of_type_Int) {
          i = j + 1;
        }
        if (MsgBackupTransportProcessor.a().e() != 1) {
          break label612;
        }
      }
      for (str1 = getActivity().getResources().getString(2131690679);; str1 = getActivity().getResources().getString(2131690678))
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(MsgBackupManager.jdField_b_of_type_Int), str2 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690630);
        break;
        if (this.jdField_b_of_type_Int != 2) {
          break label422;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841464);
        break label422;
      }
      if (paramMessage.arg1 == 1)
      {
        p();
        break;
      }
      o();
      break;
      if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      str1 = getActivity().getString(2131690677);
      i = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = i;
      str1 = str1.substring(0, str1.length() - (2 - i % 3));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      break;
    }
  }
  
  protected void i()
  {
    super.i();
    if (getActivity() != null)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841460);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131690653));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165878));
        if (this.jdField_b_of_type_Int != 2) {
          break label120;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131690631));
      }
    }
    for (;;)
    {
      ViewUtils.b(this.jdField_b_of_type_AndroidWidgetProgressBar, 8);
      ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.vg.hideLeftText();
      return;
      label120:
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131690604));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null)
    {
      if ((this.jdField_b_of_type_Int == 2) || (this.jdField_e_of_type_Boolean)) {
        paramActivity.overridePendingTransition(0, 0);
      }
    }
    else {
      return;
    }
    paramActivity.overridePendingTransition(2130772115, 2130772114);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (!MsgBackupManager.jdField_a_of_type_Boolean)
    {
      MsgBackupManager.a().d();
      MsgBackupManager.a().a().a(null);
    }
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
    MsgBackupManager.f = true;
  }
  
  public void onStop()
  {
    j();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment
 * JD-Core Version:    0.7.0.1
 */