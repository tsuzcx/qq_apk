package com.tencent.mobileqq.qassistant.core;

import android.app.Instrumentation;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.api.IQAssistantTempApi;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.api.impl.VoiceAssistantCoreImpl;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.RecordInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.listener.IPlayEventListener;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.util.VoiceDataUtils;
import com.tencent.mobileqq.qassistant.util.VoiceTextUtils;
import com.tencent.mobileqq.qassistant.view.VoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class VoiceMainPresenter
  implements IBasePresenter, IViewPresenter, IPlayEventListener
{
  private int jdField_a_of_type_Int;
  private Instrumentation jdField_a_of_type_AndroidAppInstrumentation;
  private IVoiceAssistantCore jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
  private ClearSessionServlet jdField_a_of_type_ComTencentMobileqqQassistantCoreClearSessionServlet;
  private FriendSortHelper jdField_a_of_type_ComTencentMobileqqQassistantCoreFriendSortHelper;
  private VoiceModel jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceModel;
  private VoiceView jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  private volatile String c;
  
  public VoiceMainPresenter(VoiceAssistantCoreImpl paramVoiceAssistantCoreImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore = paramVoiceAssistantCoreImpl;
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceModel = new VoiceModel(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView = new VoiceView(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreClearSessionServlet = new ClearSessionServlet();
    this.jdField_a_of_type_JavaLangString = AssistantUtils.a(2131720325);
    this.b = AssistantUtils.a(2131720339);
    d();
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(",");
    int i = 0;
    while (i < VoiceDataUtils.a.length)
    {
      localStringBuffer.append(AssistantUtils.a(VoiceDataUtils.a[i]));
      localStringBuffer.append(",");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void a(CommandInfo paramCommandInfo, List<VoiceItemInfo> paramList)
  {
    VoiceView localVoiceView = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if (localVoiceView != null) {
      localVoiceView.a(paramCommandInfo, paramList);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore != null))
    {
      int j = ((VoiceView)localObject).a();
      int i = 2;
      if (j != 4)
      {
        if (j != 5)
        {
          if (j != 6)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("dealChooseResult error type = ");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a());
              QLog.d("VoiceMainPresenter", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            if (paramBoolean1) {
              b(CommandUtils.a(AssistantUtils.a(2131720331)));
            } else {
              p(CommandUtils.a(VoiceDataUtils.a(1), false));
            }
            if (this.jdField_a_of_type_Boolean)
            {
              e();
              this.jdField_a_of_type_Boolean = false;
            }
          }
        }
        else
        {
          if (paramBoolean1)
          {
            localObject = null;
            if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() != null) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a().jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo;
            }
            this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.onConfirmSend((ConfirmSendInfo)localObject);
            h(CommandUtils.b());
            ReportUtils.b(1);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.cancelSendVoice();
            b(CommandUtils.a(AssistantUtils.a(2131720328)));
            ReportUtils.a(1);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            e();
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
      else
      {
        localObject = VoiceTextUtils.a(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a());
        if (paramBoolean1)
        {
          b(CommandUtils.a(AssistantUtils.a(2131720331)));
          if (this.jdField_a_of_type_Boolean)
          {
            e();
            this.jdField_a_of_type_Boolean = false;
          }
          if (localObject != null)
          {
            if (paramBoolean2) {
              i = 1;
            }
            ReportUtils.f(i);
          }
        }
        else
        {
          if (localObject != null)
          {
            if (paramBoolean2) {
              i = 1;
            }
            if (((FriendItemInfo)localObject).jdField_a_of_type_Float >= FriendSortHelper.a())
            {
              ReportUtils.b(i, FriendSortHelper.a());
            }
            else
            {
              c();
              ReportUtils.a(i, FriendSortHelper.a());
            }
          }
          ThreadManager.getUIHandler().post(new VoiceMainPresenter.3(this));
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  private boolean a(CommandInfo paramCommandInfo)
  {
    VoiceView localVoiceView = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    int j = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    int i = 0;
    boolean bool1 = bool4;
    if (localVoiceView != null)
    {
      bool1 = bool4;
      if (paramCommandInfo != null)
      {
        int k = localVoiceView.a();
        if (k == 5)
        {
          if ((paramCommandInfo.jdField_a_of_type_Int == 9) || (paramCommandInfo.jdField_a_of_type_Int == 8) || (paramCommandInfo.jdField_a_of_type_Int == 11) || (paramCommandInfo.jdField_a_of_type_Int == 5) || (paramCommandInfo.jdField_a_of_type_Int == 6)) {
            i = 1;
          }
          return i ^ 0x1;
        }
        if (k == 11)
        {
          if ((paramCommandInfo.jdField_a_of_type_Int != 8) && (paramCommandInfo.jdField_a_of_type_Int != 9) && (paramCommandInfo.jdField_a_of_type_Int != 5) && (paramCommandInfo.jdField_a_of_type_Int != 11))
          {
            i = j;
            if (paramCommandInfo.jdField_a_of_type_Int != 6) {}
          }
          else
          {
            i = 1;
          }
          return i ^ 0x1;
        }
        if (b())
        {
          bool1 = bool3;
          if (paramCommandInfo.jdField_a_of_type_Int != 5) {
            bool1 = true;
          }
          return bool1;
        }
        if (VoiceTextUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString)) {
          return false;
        }
        if (VoiceTextUtils.a(a()))
        {
          bool1 = bool4;
          if (paramCommandInfo.jdField_a_of_type_Int == 5) {
            return true;
          }
        }
        else
        {
          if (c())
          {
            bool1 = bool2;
            if (paramCommandInfo.jdField_a_of_type_Int != 5)
            {
              bool1 = bool2;
              if (paramCommandInfo.jdField_a_of_type_Int != 10)
              {
                bool1 = bool2;
                if (paramCommandInfo.jdField_a_of_type_Int != 0)
                {
                  bool1 = bool2;
                  if (paramCommandInfo.jdField_a_of_type_Int != 1)
                  {
                    bool1 = bool2;
                    if (paramCommandInfo.jdField_a_of_type_Int != 13) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
            return bool1;
          }
          bool1 = bool4;
          if (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString))
          {
            bool1 = bool4;
            if (paramCommandInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
            {
              if ((!TextUtils.isEmpty(this.c)) && ((this.c.equals(this.jdField_a_of_type_JavaLangString)) || (this.c.equals(a(this.b))))) {
                return true;
              }
              if (k != 6)
              {
                bool1 = bool4;
                if (k != 4) {}
              }
              else
              {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b()
  {
    VoiceView localVoiceView = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if ((localVoiceView != null) && (localVoiceView.a() != null)) {
      return VoiceTextUtils.c(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a().jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      CommandInfo localCommandInfo = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a();
      if ((localCommandInfo != null) && (localCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo != null) && (localCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.jdField_a_of_type_Int == 115) && (localCommandInfo.jdField_a_of_type_JavaUtilList != null) && (localCommandInfo.jdField_a_of_type_JavaUtilList.size() > 0) && (localCommandInfo.jdField_a_of_type_JavaUtilList.get(0) != null) && (VoiceTextUtils.a(paramString, ((FriendItemInfo)localCommandInfo.jdField_a_of_type_JavaUtilList.get(0)).b))) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.onStartRecord();
      }
    }
  }
  
  private boolean c()
  {
    VoiceView localVoiceView = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localVoiceView != null)
    {
      bool1 = bool2;
      if (localVoiceView.a() != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a().jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a().jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.jdField_a_of_type_Int == 115) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.setPlayEventListener(this);
    }
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "showOverSelectView commandDescription is null");
      }
      return;
    }
    CommandInfo localCommandInfo = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a();
    localCommandInfo.jdField_a_of_type_JavaLangString = paramString;
    a(localCommandInfo, VoiceDataUtils.a(localCommandInfo.jdField_a_of_type_JavaLangString, localCommandInfo.jdField_a_of_type_JavaUtilList));
    paramString = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (paramString != null) {
      paramString.play(localCommandInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private boolean d()
  {
    Object localObject = AssistantUtils.a();
    boolean bool2 = false;
    if ((localObject != null) && (AssistantUtils.a().isBackgroundPause))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "isNeedFilterBackCommand isBackgroundStop");
      }
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if ((((IVoiceAssistantCore)localObject).getActivity() instanceof QBaseActivity))
      {
        localObject = ((QBaseActivity)this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.getActivity()).getSupportFragmentManager();
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((FragmentManager)localObject).findFragmentByTag(((IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class)).getMainFragmentClassName());
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (((Fragment)localObject).isVisible()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void e()
  {
    ClearSessionServlet localClearSessionServlet = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreClearSessionServlet;
    if (localClearSessionServlet != null) {
      localClearSessionServlet.a();
    }
  }
  
  public View a()
  {
    VoiceView localVoiceView = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if (localVoiceView != null) {
      return localVoiceView.a();
    }
    return null;
  }
  
  public List<VoiceItemInfo> a()
  {
    VoiceView localVoiceView = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if (localVoiceView != null) {
      return localVoiceView.a();
    }
    return null;
  }
  
  public void a()
  {
    a(CommandUtils.a(this.b, true), VoiceDataUtils.b(this.b));
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.play(a(this.b));
    }
    ReportUtils.c();
  }
  
  public void a(int paramInt)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (localIVoiceAssistantCore != null)
    {
      if (paramInt == 11)
      {
        localIVoiceAssistantCore.cancelSendVoice();
        b(CommandUtils.a(AssistantUtils.a(2131720328)));
        ReportUtils.a(1);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        e();
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if ((localIVoiceAssistantCore != null) && (paramCommandInfo != null))
    {
      AssistantUtils.a(localIVoiceAssistantCore.getActivity(), paramCommandInfo);
      if (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo != null)
      {
        if (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.quiteVoicePanel(false, false);
        }
        if (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.jdField_a_of_type_Int == 115)
        {
          if (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.b)
          {
            e(CommandUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString, paramCommandInfo));
          }
          else
          {
            paramCommandInfo.jdField_a_of_type_Int = 2;
            b(paramCommandInfo);
          }
        }
        else
        {
          paramCommandInfo.jdField_a_of_type_Int = 2;
          a(paramCommandInfo, VoiceDataUtils.c(paramCommandInfo.jdField_a_of_type_JavaLangString));
        }
      }
      this.jdField_a_of_type_Boolean = false;
      ReportUtils.a(paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo);
    }
  }
  
  public void a(FriendItemInfo paramFriendItemInfo)
  {
    if (paramFriendItemInfo != null)
    {
      a(CommandUtils.a(paramFriendItemInfo, paramFriendItemInfo.jdField_a_of_type_Boolean, false));
      ReportUtils.c(1);
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCurrentSpeech = ");
    localStringBuilder.append(this.c);
    QLog.d("VoiceMainPresenter", 2, localStringBuilder.toString());
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    VoiceView localVoiceView = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if (localVoiceView != null) {
      localVoiceView.b();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Int = 0;
    this.c = "";
  }
  
  public void b(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 2) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)))
    {
      a(paramCommandInfo, VoiceDataUtils.c(paramCommandInfo.jdField_a_of_type_JavaLangString));
      IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
      if (localIVoiceAssistantCore != null) {
        localIVoiceAssistantCore.play(paramCommandInfo.jdField_a_of_type_JavaLangString);
      }
      if (VoiceTextUtils.f(paramCommandInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.c)) && (paramString.equals(this.c))) {
      this.c = "";
    }
    ThreadManager.getUIHandler().post(new VoiceMainPresenter.1(this, paramString));
  }
  
  public void c()
  {
    ThreadManager.getSubThreadHandler().post(new VoiceMainPresenter.2(this));
  }
  
  public void c(CommandInfo paramCommandInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore != null)
    {
      paramCommandInfo = AssistantUtils.a(2131720327);
      this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.executeCommand(new CommandInfo(2, paramCommandInfo));
      this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.play(paramCommandInfo);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      ReportUtils.d(3);
    }
  }
  
  public void d(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)))
    {
      if ((VoiceTextUtils.d(paramCommandInfo.jdField_a_of_type_JavaLangString)) && (VoiceTextUtils.a(a())))
      {
        p(CommandUtils.a(AssistantUtils.a(2131720322)));
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
      if ((localObject != null) && (((VoiceView)localObject).a() == 7))
      {
        d(AssistantUtils.a(2131720326));
        return;
      }
      String str = paramCommandInfo.jdField_a_of_type_JavaLangString;
      if (VoiceTextUtils.e(paramCommandInfo.jdField_a_of_type_JavaLangString))
      {
        localObject = VoiceDataUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString);
      }
      else if (ViewCommandModelCheck.a())
      {
        str = AssistantUtils.a(2131720338);
        localObject = VoiceDataUtils.b(str);
        paramCommandInfo.jdField_a_of_type_JavaLangString = str;
        str = a(str);
        ViewCommandModelCheck.a();
      }
      else
      {
        localObject = VoiceDataUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString);
      }
      a(paramCommandInfo, (List)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore != null) && (paramCommandInfo.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.play(str);
      }
    }
  }
  
  public void e(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 4) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)))
    {
      a(paramCommandInfo, VoiceDataUtils.d(paramCommandInfo.jdField_a_of_type_JavaLangString));
      IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
      if (localIVoiceAssistantCore != null) {
        localIVoiceAssistantCore.play(paramCommandInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void f(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataRecordInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 5)) {
      a(paramCommandInfo, VoiceDataUtils.a(paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataRecordInfo.jdField_a_of_type_JavaLangString, paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataRecordInfo.b));
    }
  }
  
  public void g(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataRecordInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 11)) {
      a(paramCommandInfo, VoiceDataUtils.a(paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataRecordInfo.jdField_a_of_type_JavaLangString, paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataRecordInfo.b, paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataRecordInfo.c));
    }
  }
  
  public void h(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 6))
    {
      a(paramCommandInfo, VoiceDataUtils.d(paramCommandInfo.jdField_a_of_type_JavaLangString));
      IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
      if (localIVoiceAssistantCore != null) {
        localIVoiceAssistantCore.play(paramCommandInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void i(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)) && (paramCommandInfo.jdField_a_of_type_Int == 7) && (paramCommandInfo.jdField_a_of_type_JavaUtilList != null) && (!paramCommandInfo.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore != null)) {
      if (paramCommandInfo.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        paramCommandInfo = (FriendItemInfo)paramCommandInfo.jdField_a_of_type_JavaUtilList.get(0);
        a(CommandUtils.a(paramCommandInfo, true, paramCommandInfo.jdField_a_of_type_Boolean ^ true));
        if (!paramCommandInfo.jdField_a_of_type_Boolean)
        {
          if (paramCommandInfo.jdField_a_of_type_Float < FriendSortHelper.a())
          {
            ReportUtils.e();
            return;
          }
          ReportUtils.d();
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreFriendSortHelper == null) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantCoreFriendSortHelper = new FriendSortHelper();
        }
        List localList = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreFriendSortHelper.a(paramCommandInfo.jdField_a_of_type_JavaUtilList);
        if ((localList != null) && (localList.size() > 0))
        {
          paramCommandInfo.jdField_a_of_type_JavaUtilList = localList;
          a(paramCommandInfo, VoiceDataUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString, localList));
          this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.play(paramCommandInfo.jdField_a_of_type_JavaLangString);
          ReportUtils.a();
        }
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void j(CommandInfo paramCommandInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if ((localObject != null) && ((((VoiceView)localObject).a() == 5) || (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() == 11)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
      if (localObject != null) {
        ((IVoiceAssistantCore)localObject).cancelSendVoice();
      }
      if (paramCommandInfo != null) {
        b(CommandUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString));
      }
      this.jdField_a_of_type_Boolean = false;
      ReportUtils.a(2);
    }
  }
  
  public void k(CommandInfo paramCommandInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if ((localObject != null) && ((((VoiceView)localObject).a() == 5) || (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() == 11)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
      if (localObject != null)
      {
        ((IVoiceAssistantCore)localObject).onConfirmSend(paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo);
        h(CommandUtils.b());
        this.jdField_a_of_type_Boolean = false;
        ReportUtils.b(2);
      }
    }
  }
  
  public void l(CommandInfo paramCommandInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore != null) && (paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 10)) {
      a(paramCommandInfo.b, true);
    }
  }
  
  public void m(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 12))
    {
      VoiceView localVoiceView = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
      if ((localVoiceView != null) && (localVoiceView.a() == 7)) {
        d(paramCommandInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void n(CommandInfo paramCommandInfo)
  {
    if (d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "backCommand isNeedFilterBackCommand");
      }
    }
    else
    {
      c();
      b(CommandUtils.a(AssistantUtils.a(2131720307)));
    }
  }
  
  public void o(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 14) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString))) {
      b(CommandUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void p(CommandInfo paramCommandInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
    if ((localObject != null) && (((VoiceView)localObject).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "panel is dragging, so return");
      }
      return;
    }
    if (a(paramCommandInfo))
    {
      if ((paramCommandInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("not need execute command, currentType = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a());
        ((StringBuilder)localObject).append(", commandType = ");
        ((StringBuilder)localObject).append(paramCommandInfo.jdField_a_of_type_Int);
        QLog.d("VoiceMainPresenter", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)) && (paramCommandInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int > 3)
      {
        this.jdField_a_of_type_Int = 0;
        a();
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceModel;
    if (localObject != null) {
      ((VoiceModel)localObject).a(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter
 * JD-Core Version:    0.7.0.1
 */