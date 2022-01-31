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
import arop;
import arpa;
import arpg;
import arpk;
import arqv;
import arrt;
import arsa;
import arsc;
import bajq;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
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
    this.vg.setLeftButton(2131624810);
    this.vg.setRightButton(2131624786);
    this.vg.setOnItemSelectListener(new arqv(this));
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return;
    }
    this.vg.a();
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
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131100170));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131624804);
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      arsa.a("0X800A264", 1);
      return;
    }
    arsa.a("0X800A287", 1);
  }
  
  private void p()
  {
    this.f = false;
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (this.jdField_e_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131100171));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131624807);
  }
  
  protected void a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.a();
    arsc.a();
    this.jdField_c_of_type_Int = arpa.jdField_b_of_type_Int;
    if (arrt.a().a() == 1) {
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
      this.jdField_a_of_type_Long = arpa.a().a();
      arpa.jdField_a_of_type_Boolean = false;
      int j = arpa.a().a();
      this.jdField_d_of_type_Int = j;
      c(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
      i = j;
      if (j != arpa.jdField_b_of_type_Int) {
        i = j + 1;
      }
      if (arrt.a().a() == 1)
      {
        localObject1 = getActivity().getResources().getString(2131624868);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null)
        {
          localObject2 = arsc.a(this.jdField_a_of_type_Long);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format((String)localObject1, new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_c_of_type_Int), (String)localObject2 + "B/s" }));
        }
        if (!arrt.a().b()) {
          break label296;
        }
        p();
      }
      for (;;)
      {
        arpa.a().a().a(this);
        if (arrt.a().a() != 2) {
          break label303;
        }
        if (!this.jdField_e_of_type_Boolean) {
          break;
        }
        arsa.a("0X800A261");
        return;
        localObject1 = getActivity().getResources().getString(2131624867);
        break label161;
        label296:
        o();
      }
      label303:
      arsa.a("0X800A285");
      return;
    }
    long l2;
    long l1;
    if (arpa.a().a().a() == 1)
    {
      arpa.a().a().a(this);
      if (this.jdField_e_of_type_Boolean) {
        arpa.a().a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      arpa.jdField_b_of_type_Int = arpa.a().jdField_a_of_type_JavaUtilHashSet.size();
      arsa.a();
      arsa.a.b = arpa.jdField_b_of_type_Int;
      localObject1 = new arpg();
      localObject2 = new HashSet(arpa.a().jdField_a_of_type_JavaUtilHashSet.size());
      ((HashSet)localObject2).addAll(arpa.a().jdField_a_of_type_JavaUtilHashSet);
      ((arpg)localObject1).jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject2);
      ((arpg)localObject1).jdField_a_of_type_Int = 0;
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
      arsc.b("MsgBackup_MsgBackupPCTransportFragment", "select params startTime = %d ,endTime = %d,contentType = %d ", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      if ((l2 != 0L) && (l1 != 0L) && (l2 < l1))
      {
        ((arpg)localObject1).jdField_a_of_type_Long = l2;
        ((arpg)localObject1).b = l1;
        if (i == 2) {}
        for (;;)
        {
          ((arpg)localObject1).jdField_a_of_type_Boolean = bool1;
          arpa.a().a((arpg)localObject1);
          return;
          bool1 = false;
        }
      }
      ((arpg)localObject1).jdField_a_of_type_Long = 0L;
      ((arpg)localObject1).b = 9223372036854775807L;
      if (i == 2) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ((arpg)localObject1).jdField_a_of_type_Boolean = bool1;
        break;
      }
      arpa.a().a().a(this);
      arpa.a().a().f(4);
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      arpa.a().a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
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
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "speedState!!! increment = " + paramLong + " , isStart = " + this.jdField_a_of_type_Boolean + ", MsgBackupManager.isTransportStart = " + arpa.jdField_e_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) || (arpa.jdField_e_of_type_Boolean))
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
      localObject1 = (arpk)paramObject;
      if (this.jdField_b_of_type_Int != 1) {
        break label337;
      }
      if (paramObject != null) {
        break label81;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "onConfirmQrResponse, data is null!");
      }
    }
    label81:
    String str;
    int i;
    MsgBackupEndPoint localMsgBackupEndPoint1;
    MsgBackupEndPoint localMsgBackupEndPoint2;
    label337:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramObject = ((arpk)localObject1).b();
              str = ((arpk)localObject1).a();
              i = ((arpk)localObject1).a();
              localMsgBackupEndPoint1 = new MsgBackupEndPoint();
              localMsgBackupEndPoint2 = new MsgBackupEndPoint();
              j = arsc.a(((arpk)localObject1).a().a());
              localMsgBackupEndPoint1.ipv4 = j;
              localMsgBackupEndPoint2.ipv4 = j;
              localObject2 = ((arpk)localObject1).a().a();
            } while (((List)localObject2).size() != 2);
            localMsgBackupEndPoint2.port = ((Integer)((List)localObject2).get(0)).intValue();
            localMsgBackupEndPoint1.port = ((Integer)((List)localObject2).get(1)).intValue();
            arrt localarrt = arpa.a().a();
            arop localarop = arop.a();
            localarrt.b(paramObject);
            localarop.b(str);
            localarop.a(i);
            localarrt.b(localMsgBackupEndPoint2);
            localarrt.a(localMsgBackupEndPoint1);
            localarrt.c(2);
            localarrt.b(2);
          } while (!QLog.isColorLevel());
          QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "onConfirmQrResponse: client ip = " + ((arpk)localObject1).a().a() + ", udpport = " + ((List)localObject2).get(1) + ", tcpport = " + ((List)localObject2).get(0));
          return;
        } while (this.jdField_b_of_type_Int != 2);
        if (paramObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "onConfirmQrResponse, data is null!");
      return;
      paramObject = ((arpk)localObject1).b();
      str = ((arpk)localObject1).a();
      i = ((arpk)localObject1).a();
      localMsgBackupEndPoint1 = new MsgBackupEndPoint();
      localMsgBackupEndPoint2 = new MsgBackupEndPoint();
      int j = arsc.a(((arpk)localObject1).a().a());
      localMsgBackupEndPoint1.ipv4 = j;
      localMsgBackupEndPoint2.ipv4 = j;
      localObject2 = ((arpk)localObject1).a().a();
    } while (((List)localObject2).size() != 2);
    localMsgBackupEndPoint2.port = ((Integer)((List)localObject2).get(0)).intValue();
    localMsgBackupEndPoint1.port = ((Integer)((List)localObject2).get(1)).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmRsp: server ip = " + ((arpk)localObject1).a().a() + ", udpport = " + ((List)localObject2).get(1) + ", tcpport = " + ((List)localObject2).get(0));
    }
    Object localObject1 = arpa.a().a();
    Object localObject2 = arop.a();
    ((arrt)localObject1).b(paramObject);
    ((arop)localObject2).b(str);
    ((arop)localObject2).a(i);
    ((arrt)localObject1).d(localMsgBackupEndPoint2);
    ((arrt)localObject1).c(localMsgBackupEndPoint1);
    ((arrt)localObject1).c(1);
    ((arrt)localObject1).b(1);
  }
  
  public void aN_()
  {
    super.aN_();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
    {
      if (!this.f) {
        break label56;
      }
      arsa.a("0X800A266", 3);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 2)
      {
        if (this.f) {
          break;
        }
        arsa.a("0X800A288", 1);
      }
      return;
      label56:
      if (!this.jdField_a_of_type_Boolean) {
        arsa.a("0X800A266", 1);
      } else {
        arsa.a("0X800A266", 2);
      }
    }
    arsa.a("0X800A288", 2);
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
    bajq.b(this.jdField_a_of_type_AndroidWidgetLinearLayout, 8);
    bajq.b(this.jdField_b_of_type_AndroidWidgetLinearLayout, 8);
    bajq.b(this.jdField_c_of_type_AndroidWidgetLinearLayout, 8);
    bajq.b(this.jdField_d_of_type_AndroidWidgetLinearLayout, 0);
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840843);
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
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840842);
        }
        break;
      }
    }
    n();
    this.jdField_c_of_type_Boolean = arrt.a().b();
    if (this.jdField_c_of_type_Boolean)
    {
      p();
      return;
    }
    o();
    return;
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131624866);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131624807);
    n();
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    arsc.b("MsgBackup_MsgBackupPCTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        arsa.a("0X800A25F");
      }
    }
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    arsa.a("0X800A283");
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "doOnKeyDown is called! KEYCODE_BACK");
      }
      aN_();
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
      } while ((!this.jdField_a_of_type_Boolean) && (!arpa.jdField_e_of_type_Boolean));
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840843);
        }
      }
      else
      {
        this.vg.setLeftButton(2131624810);
        str2 = arsc.a(this.jdField_a_of_type_Long);
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
      if (arrt.a().a() == 1) {}
      for (String str1 = getActivity().getResources().getString(2131624868);; str1 = getActivity().getResources().getString(2131624867))
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(k), str2 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131624807);
        }
        if (j != k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionCompleted->>>>>>>>");
        }
        arpa.a().a().a(null);
        if (arrt.a().a() != 1) {
          break label357;
        }
        MsgBackupCompleteFragment.j(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        break;
        if (this.jdField_b_of_type_Int != 2) {
          break label112;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840842);
        break label112;
      }
      MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Boolean);
      break;
      if ((!this.jdField_a_of_type_Boolean) && (!arpa.jdField_e_of_type_Boolean)) {
        break;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840843);
        }
      }
      else
      {
        this.vg.setLeftButton(2131624810);
        str2 = arsc.a(this.jdField_a_of_type_Long);
        arsc.b("MsgBackup_MsgBackupPCTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), str2 });
        j = this.jdField_d_of_type_Int;
        i = j;
        if (j != arpa.jdField_b_of_type_Int) {
          i = j + 1;
        }
        if (arrt.a().a() != 1) {
          break label612;
        }
      }
      for (str1 = getActivity().getResources().getString(2131624868);; str1 = getActivity().getResources().getString(2131624867))
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(arpa.jdField_b_of_type_Int), str2 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131624807);
        break;
        if (this.jdField_b_of_type_Int != 2) {
          break label422;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840842);
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
      str1 = getActivity().getString(2131624866);
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840838);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131624833));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131100171));
        if (this.jdField_b_of_type_Int != 2) {
          break label120;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131624808));
      }
    }
    for (;;)
    {
      bajq.b(this.jdField_b_of_type_AndroidWidgetProgressBar, 8);
      bajq.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.vg.b();
      return;
      label120:
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131624775));
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
    paramActivity.overridePendingTransition(2130772091, 2130772090);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (!arpa.jdField_a_of_type_Boolean)
    {
      arpa.a().d();
      arpa.a().a().a(null);
    }
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
    arpa.f = true;
  }
  
  public void onStop()
  {
    j();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment
 * JD-Core Version:    0.7.0.1
 */