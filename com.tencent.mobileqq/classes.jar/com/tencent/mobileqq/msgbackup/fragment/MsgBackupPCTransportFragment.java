package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
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
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftBackVisible(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftButton(2131690561);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightButton(2131690543);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(new MsgBackupPCTransportFragment.1(this));
    if (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.hideLeft();
  }
  
  private void p()
  {
    this.g = true;
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (this.k != null)
      {
        this.k.setVisibility(0);
        this.k.setTextColor(getResources().getColor(2131165880));
        this.k.setText(2131690555);
      }
      if (this.jdField_b_of_type_Int == 1)
      {
        MsgBackupReporter.a("0X800A264", 1);
        return;
      }
      MsgBackupReporter.a("0X800A287", 1);
    }
  }
  
  private void q()
  {
    this.g = false;
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (this.k != null)
      {
        this.k.setVisibility(0);
        this.k.setTextColor(getResources().getColor(2131165881));
        this.k.setText(2131690558);
      }
    }
  }
  
  protected void a()
  {
    super.a();
    MsgBackupUtil.a();
    this.jdField_c_of_type_Int = MsgBackupManager.jdField_b_of_type_Int;
    int i = MsgBackupTransportProcessor.a().e();
    boolean bool2 = true;
    boolean bool1 = true;
    if (i == 1) {
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
    }
    i = this.jdField_a_of_type_Int;
    Object localObject1;
    Object localObject2;
    if (i != 2)
    {
      if (i != 5) {
        return;
      }
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
      if (MsgBackupTransportProcessor.a().e() == 1) {
        localObject1 = getActivity().getResources().getString(2131690607);
      } else {
        localObject1 = getActivity().getResources().getString(2131690606);
      }
      if (this.j != null)
      {
        localObject2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
        TextView localTextView = this.j;
        j = this.jdField_c_of_type_Int;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("B/s");
        localTextView.setText(String.format((String)localObject1, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localStringBuilder.toString() }));
      }
      if (MsgBackupTransportProcessor.a().b()) {
        q();
      } else {
        p();
      }
      MsgBackupManager.a().a().a(this);
      if (MsgBackupTransportProcessor.a().e() == 2)
      {
        if (this.f) {
          MsgBackupReporter.a("0X800A261");
        }
      }
      else {
        MsgBackupReporter.a("0X800A285");
      }
    }
    else
    {
      if (MsgBackupManager.a().a().a() == 1)
      {
        MsgBackupManager.a().a().a(this);
        if (this.f) {
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
        if (getActivity() != null)
        {
          localObject2 = getActivity().getIntent();
          if (localObject2 != null)
          {
            l1 = ((Intent)localObject2).getLongExtra("session_start_time", 0L);
            l2 = ((Intent)localObject2).getLongExtra("session_end_time", 0L);
            i = ((Intent)localObject2).getIntExtra("session_content_type", 1);
            break label493;
          }
        }
        long l1 = 0L;
        long l2 = l1;
        i = 1;
        label493:
        MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "select params startTime = %d ,endTime = %d,contentType = %d ", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
        if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
        {
          ((MsgBackupRequest)localObject1).jdField_a_of_type_Long = l1;
          ((MsgBackupRequest)localObject1).b = l2;
          if (i != 2) {
            bool1 = false;
          }
          ((MsgBackupRequest)localObject1).jdField_a_of_type_Boolean = bool1;
        }
        else
        {
          ((MsgBackupRequest)localObject1).jdField_a_of_type_Long = 0L;
          ((MsgBackupRequest)localObject1).b = 9223372036854775807L;
          if (i == 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          ((MsgBackupRequest)localObject1).jdField_a_of_type_Boolean = bool1;
        }
        MsgBackupManager.a().a((MsgBackupRequest)localObject1);
        return;
      }
      MsgBackupManager.a().a().a(this);
      MsgBackupManager.a().a().j(4);
      if (this.f) {
        MsgBackupManager.a().a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sessionProgress finishedSessions = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", totalSession = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", isStart = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
      if (paramInt1 == paramInt2) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_c_of_type_Int = paramInt2;
      this.jdField_d_of_type_Int = paramInt1;
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10003);
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("speedState!!! increment = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" , isStart = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", MsgBackupManager.isTransportStart = ");
      ((StringBuilder)localObject).append(MsgBackupManager.jdField_e_of_type_Boolean);
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_a_of_type_Boolean) || (MsgBackupManager.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_Long = paramLong;
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10002);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mBizType = ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      localObject1 = (MsgBackupConfirmQrRsp)paramObject;
      Object localObject2;
      int i;
      Object localObject3;
      int j;
      int k;
      if (this.jdField_b_of_type_Int == 1)
      {
        if (paramObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: backup data is null!");
          }
          return;
        }
        localObject2 = ((MsgBackupConfirmQrRsp)localObject1).b();
        paramObject = ((MsgBackupConfirmQrRsp)localObject1).a();
        i = ((MsgBackupConfirmQrRsp)localObject1).a();
        localObject3 = ((MsgBackupConfirmQrRsp)localObject1).a().a();
        if (((List)localObject3).size() == 2)
        {
          localObject1 = ((MsgBackupConfirmQrRsp)localObject1).a().a();
          j = ((Integer)((List)localObject3).get(0)).intValue();
          k = ((Integer)((List)localObject3).get(1)).intValue();
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("processConfirmQRRsp: backup client ip = ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(", udpport = ");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(", tcpport = ");
            ((StringBuilder)localObject3).append(j);
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject3).toString());
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
        }
      }
      else if (this.jdField_b_of_type_Int == 2)
      {
        if (paramObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: restore data is null!");
          }
          return;
        }
        localObject2 = ((MsgBackupConfirmQrRsp)localObject1).b();
        paramObject = ((MsgBackupConfirmQrRsp)localObject1).a();
        i = ((MsgBackupConfirmQrRsp)localObject1).a();
        localObject3 = ((MsgBackupConfirmQrRsp)localObject1).a().a();
        if (((List)localObject3).size() == 2)
        {
          localObject1 = ((MsgBackupConfirmQrRsp)localObject1).a().a();
          j = ((Integer)((List)localObject3).get(0)).intValue();
          k = ((Integer)((List)localObject3).get(1)).intValue();
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("processConfirmRsp: restore server ip = ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(", udpport = ");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(", tcpport = ");
            ((StringBuilder)localObject3).append(j);
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject3).toString());
          }
          localObject3 = MsgBackupManager.a().a();
          ((MsgBackupTransportProcessor)localObject3).d((String)localObject2);
          localObject2 = MsgBackupAuthProcessor.a();
          ((MsgBackupAuthProcessor)localObject2).b(paramObject);
          ((MsgBackupAuthProcessor)localObject2).a(i);
          ((MsgBackupTransportProcessor)localObject3).c((String)localObject1);
          ((MsgBackupTransportProcessor)localObject3).d(j);
          ((MsgBackupTransportProcessor)localObject3).c(k);
          ((MsgBackupTransportProcessor)localObject3).g(1);
          ((MsgBackupTransportProcessor)localObject3).f(1);
        }
      }
    }
  }
  
  public void aJ_()
  {
    super.aJ_();
    if ((this.f) && (this.jdField_b_of_type_Int == 1)) {
      if (this.g) {
        MsgBackupReporter.a("0X800A266", 3);
      } else if (!this.jdField_a_of_type_Boolean) {
        MsgBackupReporter.a("0X800A266", 1);
      } else {
        MsgBackupReporter.a("0X800A266", 2);
      }
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      if (!this.g)
      {
        MsgBackupReporter.a("0X800A288", 1);
        return;
      }
      MsgBackupReporter.a("0X800A288", 2);
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == 0) {
      return;
    }
    paramInt1 = paramInt1 * 100 / paramInt2;
    if (this.jdField_b_of_type_AndroidWidgetProgressBar != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Int == 1)
    {
      if (this.f) {
        MsgBackupReporter.a("0X800A25F");
      }
    }
    else if (this.jdField_b_of_type_Int == 2) {
      MsgBackupReporter.a("0X800A283");
    }
  }
  
  protected void d()
  {
    super.d();
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetLinearLayout, 8);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetLinearLayout, 8);
    ViewUtils.b(this.jdField_c_of_type_AndroidWidgetLinearLayout, 8);
    ViewUtils.b(this.jdField_d_of_type_AndroidWidgetLinearLayout, 0);
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841346);
    } else if (this.jdField_b_of_type_Int == 2) {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841345);
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 2)
    {
      if (i != 5) {
        return;
      }
      o();
      this.jdField_d_of_type_Boolean = MsgBackupTransportProcessor.a().b();
      if (this.jdField_d_of_type_Boolean)
      {
        q();
        return;
      }
      p();
      return;
    }
    this.j.setText(2131690605);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
    this.k.setText(2131690558);
    o();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "doOnKeyDown is called! KEYCODE_BACK");
      }
      aJ_();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void h_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "pc退出了！------------------>exit called! ");
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10008);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    String str1;
    String str2;
    int j;
    TextView localTextView;
    StringBuilder localStringBuilder;
    if (i != 10002)
    {
      if (i != 10003)
      {
        if (i != 10007)
        {
          if (i != 10008)
          {
            if ((i == 10014) && (this.j != null) && (this.j.getVisibility() == 0) && (!this.jdField_a_of_type_Boolean))
            {
              str1 = getActivity().getString(2131690605);
              i = this.jdField_e_of_type_Int + 1;
              this.jdField_e_of_type_Int = i;
              str1 = str1.substring(0, str1.length() - (2 - i % 3));
              this.j.setText(str1);
              this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
            }
          }
          else {
            m();
          }
        }
        else if (paramMessage.arg1 == 1) {
          q();
        } else {
          p();
        }
      }
      else if ((this.jdField_a_of_type_Boolean) || (MsgBackupManager.jdField_e_of_type_Boolean))
      {
        if (this.jdField_e_of_type_Boolean)
        {
          this.jdField_e_of_type_Boolean = false;
          if (this.jdField_b_of_type_Int == 1) {
            this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841346);
          } else if (this.jdField_b_of_type_Int == 2) {
            this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841345);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftButton(2131690561);
        str2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
        j = paramMessage.arg1;
        int k = paramMessage.arg2;
        c(j, k);
        if (j != k) {
          i = j + 1;
        } else {
          i = j;
        }
        if (MsgBackupTransportProcessor.a().e() == 1) {
          str1 = getActivity().getResources().getString(2131690607);
        } else {
          str1 = getActivity().getResources().getString(2131690606);
        }
        if (this.j != null)
        {
          localTextView = this.j;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str2);
          localStringBuilder.append("B/s");
          localTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(k), localStringBuilder.toString() }));
        }
        if (this.k != null) {
          this.k.setText(2131690558);
        }
        if (j == k)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionCompleted->>>>>>>>");
          }
          MsgBackupManager.a().a().a(null);
          if (MsgBackupTransportProcessor.a().e() == 1) {
            MsgBackupCompleteFragment.j(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
          } else {
            MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.f);
          }
        }
      }
    }
    else if ((this.jdField_a_of_type_Boolean) || (MsgBackupManager.jdField_e_of_type_Boolean))
    {
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841346);
        } else if (this.jdField_b_of_type_Int == 2) {
          this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841345);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftButton(2131690561);
      str2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
      MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), str2 });
      j = this.jdField_d_of_type_Int;
      i = j;
      if (j != MsgBackupManager.jdField_b_of_type_Int) {
        i = j + 1;
      }
      if (MsgBackupTransportProcessor.a().e() == 1) {
        str1 = getActivity().getResources().getString(2131690607);
      } else {
        str1 = getActivity().getResources().getString(2131690606);
      }
      if (this.j != null)
      {
        localTextView = this.j;
        j = MsgBackupManager.jdField_b_of_type_Int;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append("B/s");
        localTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localStringBuilder.toString() }));
      }
      if (this.k != null) {
        this.k.setText(2131690558);
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null)
    {
      if ((this.jdField_b_of_type_Int != 2) && (!this.f))
      {
        paramActivity.overridePendingTransition(2130772141, 2130772140);
        return;
      }
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  protected void j()
  {
    super.j();
    if (getActivity() != null)
    {
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841341);
      }
      if (this.j != null) {
        this.j.setText(getString(2131690581));
      }
      if (this.k != null)
      {
        this.k.setTextColor(getResources().getColor(2131165881));
        if (this.jdField_b_of_type_Int == 2) {
          this.k.setText(getString(2131690559));
        } else {
          this.k.setText(getString(2131690532));
        }
      }
      ViewUtils.b(this.jdField_b_of_type_AndroidWidgetProgressBar, 8);
      ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.hideLeftText();
    }
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
    k();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment
 * JD-Core Version:    0.7.0.1
 */