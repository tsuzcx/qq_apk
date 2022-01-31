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
import askv;
import aslg;
import aslm;
import aslq;
import asnb;
import asnz;
import asog;
import asoi;
import bbll;
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
    this.vg.setLeftButton(2131690371);
    this.vg.setRightButton(2131690347);
    this.vg.setOnItemSelectListener(new asnb(this));
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
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165760));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690365);
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      asog.a("0X800A264", 1);
      return;
    }
    asog.a("0X800A287", 1);
  }
  
  private void p()
  {
    this.f = false;
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (this.jdField_e_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165761));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690368);
  }
  
  protected void a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.a();
    asoi.a();
    this.jdField_c_of_type_Int = aslg.jdField_b_of_type_Int;
    if (asnz.a().a() == 1) {
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
      this.jdField_a_of_type_Long = aslg.a().a();
      aslg.jdField_a_of_type_Boolean = false;
      int j = aslg.a().a();
      this.jdField_d_of_type_Int = j;
      c(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
      i = j;
      if (j != aslg.jdField_b_of_type_Int) {
        i = j + 1;
      }
      if (asnz.a().a() == 1)
      {
        localObject1 = getActivity().getResources().getString(2131690429);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null)
        {
          localObject2 = asoi.a(this.jdField_a_of_type_Long);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format((String)localObject1, new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_c_of_type_Int), (String)localObject2 + "B/s" }));
        }
        if (!asnz.a().b()) {
          break label296;
        }
        p();
      }
      for (;;)
      {
        aslg.a().a().a(this);
        if (asnz.a().a() != 2) {
          break label303;
        }
        if (!this.jdField_e_of_type_Boolean) {
          break;
        }
        asog.a("0X800A261");
        return;
        localObject1 = getActivity().getResources().getString(2131690428);
        break label161;
        label296:
        o();
      }
      label303:
      asog.a("0X800A285");
      return;
    }
    long l2;
    long l1;
    if (aslg.a().a().a() == 1)
    {
      aslg.a().a().a(this);
      if (this.jdField_e_of_type_Boolean) {
        aslg.a().a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      aslg.jdField_b_of_type_Int = aslg.a().jdField_a_of_type_JavaUtilHashSet.size();
      asog.a();
      asog.a.b = aslg.jdField_b_of_type_Int;
      localObject1 = new aslm();
      localObject2 = new HashSet(aslg.a().jdField_a_of_type_JavaUtilHashSet.size());
      ((HashSet)localObject2).addAll(aslg.a().jdField_a_of_type_JavaUtilHashSet);
      ((aslm)localObject1).jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject2);
      ((aslm)localObject1).jdField_a_of_type_Int = 0;
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
      asoi.b("MsgBackup_MsgBackupPCTransportFragment", "select params startTime = %d ,endTime = %d,contentType = %d ", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      if ((l2 != 0L) && (l1 != 0L) && (l2 < l1))
      {
        ((aslm)localObject1).jdField_a_of_type_Long = l2;
        ((aslm)localObject1).b = l1;
        if (i == 2) {}
        for (;;)
        {
          ((aslm)localObject1).jdField_a_of_type_Boolean = bool1;
          aslg.a().a((aslm)localObject1);
          return;
          bool1 = false;
        }
      }
      ((aslm)localObject1).jdField_a_of_type_Long = 0L;
      ((aslm)localObject1).b = 9223372036854775807L;
      if (i == 2) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ((aslm)localObject1).jdField_a_of_type_Boolean = bool1;
        break;
      }
      aslg.a().a().a(this);
      aslg.a().a().f(4);
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      aslg.a().a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
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
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "speedState!!! increment = " + paramLong + " , isStart = " + this.jdField_a_of_type_Boolean + ", MsgBackupManager.isTransportStart = " + aslg.jdField_e_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) || (aslg.jdField_e_of_type_Boolean))
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
      localObject1 = (aslq)paramObject;
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
              paramObject = ((aslq)localObject1).b();
              str = ((aslq)localObject1).a();
              i = ((aslq)localObject1).a();
              localMsgBackupEndPoint1 = new MsgBackupEndPoint();
              localMsgBackupEndPoint2 = new MsgBackupEndPoint();
              j = asoi.a(((aslq)localObject1).a().a());
              localMsgBackupEndPoint1.ipv4 = j;
              localMsgBackupEndPoint2.ipv4 = j;
              localObject2 = ((aslq)localObject1).a().a();
            } while (((List)localObject2).size() != 2);
            localMsgBackupEndPoint2.port = ((Integer)((List)localObject2).get(0)).intValue();
            localMsgBackupEndPoint1.port = ((Integer)((List)localObject2).get(1)).intValue();
            asnz localasnz = aslg.a().a();
            askv localaskv = askv.a();
            localasnz.b(paramObject);
            localaskv.b(str);
            localaskv.a(i);
            localasnz.b(localMsgBackupEndPoint2);
            localasnz.a(localMsgBackupEndPoint1);
            localasnz.c(2);
            localasnz.b(2);
          } while (!QLog.isColorLevel());
          QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "onConfirmQrResponse: client ip = " + ((aslq)localObject1).a().a() + ", udpport = " + ((List)localObject2).get(1) + ", tcpport = " + ((List)localObject2).get(0));
          return;
        } while (this.jdField_b_of_type_Int != 2);
        if (paramObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "onConfirmQrResponse, data is null!");
      return;
      paramObject = ((aslq)localObject1).b();
      str = ((aslq)localObject1).a();
      i = ((aslq)localObject1).a();
      localMsgBackupEndPoint1 = new MsgBackupEndPoint();
      localMsgBackupEndPoint2 = new MsgBackupEndPoint();
      int j = asoi.a(((aslq)localObject1).a().a());
      localMsgBackupEndPoint1.ipv4 = j;
      localMsgBackupEndPoint2.ipv4 = j;
      localObject2 = ((aslq)localObject1).a().a();
    } while (((List)localObject2).size() != 2);
    localMsgBackupEndPoint2.port = ((Integer)((List)localObject2).get(0)).intValue();
    localMsgBackupEndPoint1.port = ((Integer)((List)localObject2).get(1)).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmRsp: server ip = " + ((aslq)localObject1).a().a() + ", udpport = " + ((List)localObject2).get(1) + ", tcpport = " + ((List)localObject2).get(0));
    }
    Object localObject1 = aslg.a().a();
    Object localObject2 = askv.a();
    ((asnz)localObject1).b(paramObject);
    ((askv)localObject2).b(str);
    ((askv)localObject2).a(i);
    ((asnz)localObject1).d(localMsgBackupEndPoint2);
    ((asnz)localObject1).c(localMsgBackupEndPoint1);
    ((asnz)localObject1).c(1);
    ((asnz)localObject1).b(1);
  }
  
  public void aK_()
  {
    super.aK_();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
    {
      if (!this.f) {
        break label56;
      }
      asog.a("0X800A266", 3);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 2)
      {
        if (this.f) {
          break;
        }
        asog.a("0X800A288", 1);
      }
      return;
      label56:
      if (!this.jdField_a_of_type_Boolean) {
        asog.a("0X800A266", 1);
      } else {
        asog.a("0X800A266", 2);
      }
    }
    asog.a("0X800A288", 2);
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
    bbll.b(this.jdField_a_of_type_AndroidWidgetLinearLayout, 8);
    bbll.b(this.jdField_b_of_type_AndroidWidgetLinearLayout, 8);
    bbll.b(this.jdField_c_of_type_AndroidWidgetLinearLayout, 8);
    bbll.b(this.jdField_d_of_type_AndroidWidgetLinearLayout, 0);
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840905);
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
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840904);
        }
        break;
      }
    }
    n();
    this.jdField_c_of_type_Boolean = asnz.a().b();
    if (this.jdField_c_of_type_Boolean)
    {
      p();
      return;
    }
    o();
    return;
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690427);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690368);
    n();
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    asoi.b("MsgBackup_MsgBackupPCTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        asog.a("0X800A25F");
      }
    }
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    asog.a("0X800A283");
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "doOnKeyDown is called! KEYCODE_BACK");
      }
      aK_();
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
      } while ((!this.jdField_a_of_type_Boolean) && (!aslg.jdField_e_of_type_Boolean));
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840905);
        }
      }
      else
      {
        this.vg.setLeftButton(2131690371);
        str2 = asoi.a(this.jdField_a_of_type_Long);
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
      if (asnz.a().a() == 1) {}
      for (String str1 = getActivity().getResources().getString(2131690429);; str1 = getActivity().getResources().getString(2131690428))
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(k), str2 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690368);
        }
        if (j != k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionCompleted->>>>>>>>");
        }
        aslg.a().a().a(null);
        if (asnz.a().a() != 1) {
          break label357;
        }
        MsgBackupCompleteFragment.j(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        break;
        if (this.jdField_b_of_type_Int != 2) {
          break label112;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840904);
        break label112;
      }
      MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Boolean);
      break;
      if ((!this.jdField_a_of_type_Boolean) && (!aslg.jdField_e_of_type_Boolean)) {
        break;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840905);
        }
      }
      else
      {
        this.vg.setLeftButton(2131690371);
        str2 = asoi.a(this.jdField_a_of_type_Long);
        asoi.b("MsgBackup_MsgBackupPCTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), str2 });
        j = this.jdField_d_of_type_Int;
        i = j;
        if (j != aslg.jdField_b_of_type_Int) {
          i = j + 1;
        }
        if (asnz.a().a() != 1) {
          break label612;
        }
      }
      for (str1 = getActivity().getResources().getString(2131690429);; str1 = getActivity().getResources().getString(2131690428))
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(aslg.jdField_b_of_type_Int), str2 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690368);
        break;
        if (this.jdField_b_of_type_Int != 2) {
          break label422;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840904);
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
      str1 = getActivity().getString(2131690427);
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840900);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131690394));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165761));
        if (this.jdField_b_of_type_Int != 2) {
          break label120;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131690369));
      }
    }
    for (;;)
    {
      bbll.b(this.jdField_b_of_type_AndroidWidgetProgressBar, 8);
      bbll.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.vg.b();
      return;
      label120:
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131690336));
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
    if (!aslg.jdField_a_of_type_Boolean)
    {
      aslg.a().d();
      aslg.a().a().a(null);
    }
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
    aslg.f = true;
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