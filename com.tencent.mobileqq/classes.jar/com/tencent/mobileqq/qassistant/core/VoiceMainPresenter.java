package com.tencent.mobileqq.qassistant.core;

import android.app.Instrumentation;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.audio.ClearSessionServlet;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.RecordInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceDataUtils;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.tts.IPlayEventListener;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.util.VoiceTextUtils;
import com.tencent.mobileqq.qassistant.view.VoiceView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class VoiceMainPresenter
  implements IBasePresenter, IViewPresenter, IPlayEventListener
{
  private int jdField_a_of_type_Int;
  private Instrumentation jdField_a_of_type_AndroidAppInstrumentation;
  private ClearSessionServlet jdField_a_of_type_ComTencentMobileqqQassistantAudioClearSessionServlet;
  private FriendSortHelper jdField_a_of_type_ComTencentMobileqqQassistantCoreFriendSortHelper;
  private VoiceAssistantManager jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager;
  private VoiceModel jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceModel;
  private VoiceView jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  private volatile String c;
  
  public VoiceMainPresenter(VoiceAssistantManager paramVoiceAssistantManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager = paramVoiceAssistantManager;
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceModel = new VoiceModel(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView = new VoiceView(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantAudioClearSessionServlet = new ClearSessionServlet();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131720610);
    this.b = BaseApplicationImpl.getContext().getString(2131720624);
    d();
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString).append(",");
    int i = 0;
    while (i < VoiceDataUtils.a.length)
    {
      localStringBuffer.append(BaseApplicationImpl.getContext().getString(VoiceDataUtils.a[i])).append(",");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void a(CommandInfo paramCommandInfo, List<VoiceItemInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a(paramCommandInfo, paramList);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    int j = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null)) {
      switch (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a())
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("VoiceMainPresenter", 2, "dealChooseResult error type = " + this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a());
        }
        break;
      }
    }
    for (;;)
    {
      return;
      Object localObject = VoiceTextUtils.a(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a());
      if (paramBoolean1)
      {
        b(CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720616)));
        if (this.jdField_a_of_type_Boolean)
        {
          e();
          this.jdField_a_of_type_Boolean = false;
        }
        if (localObject != null)
        {
          if (paramBoolean2) {}
          for (i = j;; i = 2)
          {
            ReportUtils.f(i);
            return;
          }
        }
      }
      else
      {
        if (localObject != null)
        {
          if (paramBoolean2) {
            i = 1;
          }
          if (((FriendItemInfo)localObject).jdField_a_of_type_Float < FriendSortHelper.a()) {
            break label210;
          }
          ReportUtils.b(i, FriendSortHelper.a());
        }
        for (;;)
        {
          ThreadManager.getUIHandler().post(new VoiceMainPresenter.3(this));
          this.jdField_a_of_type_Boolean = true;
          return;
          label210:
          c();
          ReportUtils.a(i, FriendSortHelper.a());
        }
        if (paramBoolean1) {
          b(CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720616)));
        }
        while (this.jdField_a_of_type_Boolean)
        {
          e();
          this.jdField_a_of_type_Boolean = false;
          return;
          p(CommandUtils.a(VoiceDataUtils.a(1), false));
        }
        continue;
        if (paramBoolean1)
        {
          localObject = null;
          if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() != null) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a().jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo;
          }
          this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a((VoiceAssiatantRespInfo.ConfirmSendInfo)localObject);
          h(CommandUtils.b());
          ReportUtils.b(1);
        }
        while (this.jdField_a_of_type_Boolean)
        {
          e();
          this.jdField_a_of_type_Boolean = false;
          return;
          this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.c();
          b(CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720613)));
          ReportUtils.a(1);
        }
      }
    }
  }
  
  private boolean a(CommandInfo paramCommandInfo)
  {
    boolean bool = false;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && (paramCommandInfo != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a();
      if (i == 5) {
        if ((paramCommandInfo.jdField_a_of_type_Int == 9) || (paramCommandInfo.jdField_a_of_type_Int == 8) || (paramCommandInfo.jdField_a_of_type_Int == 11) || (paramCommandInfo.jdField_a_of_type_Int == 5) || (paramCommandInfo.jdField_a_of_type_Int == 6))
        {
          i = 1;
          if (i != 0) {
            break label83;
          }
        }
      }
    }
    label83:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return true;
            i = 0;
            break;
            return false;
            if (i != 11) {
              break label148;
            }
            if ((paramCommandInfo.jdField_a_of_type_Int == 8) || (paramCommandInfo.jdField_a_of_type_Int == 9) || (paramCommandInfo.jdField_a_of_type_Int == 5) || (paramCommandInfo.jdField_a_of_type_Int == 11) || (paramCommandInfo.jdField_a_of_type_Int == 6)) {}
            for (i = 1; i != 0; i = 0) {
              return false;
            }
          }
          if (!b()) {
            break label165;
          }
        } while (paramCommandInfo.jdField_a_of_type_Int != 5);
        return false;
        if (VoiceTextUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString)) {
          return false;
        }
        if (!VoiceTextUtils.a(a())) {
          break label197;
        }
      } while (paramCommandInfo.jdField_a_of_type_Int == 5);
      do
      {
        return false;
        if (c())
        {
          if ((paramCommandInfo.jdField_a_of_type_Int != 5) && (paramCommandInfo.jdField_a_of_type_Int != 10) && (paramCommandInfo.jdField_a_of_type_Int != 0) && (paramCommandInfo.jdField_a_of_type_Int != 1) && (paramCommandInfo.jdField_a_of_type_Int != 13)) {
            break;
          }
          return false;
        }
      } while ((TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)) || (!paramCommandInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)));
    } while ((!TextUtils.isEmpty(this.c)) && ((this.c.equals(this.jdField_a_of_type_JavaLangString)) || (this.c.equals(a(this.b)))));
    label148:
    label165:
    label197:
    if ((i == 6) || (i == 4)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() != null)) {
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
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.e();
      }
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() != null)
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
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(this);
    }
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "showOverSelectView commandDescription is null");
      }
    }
    CommandInfo localCommandInfo;
    do
    {
      return;
      localCommandInfo = this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a();
      localCommandInfo.jdField_a_of_type_JavaLangString = paramString;
      a(localCommandInfo, VoiceDataUtils.a(localCommandInfo.jdField_a_of_type_JavaLangString, localCommandInfo.jdField_a_of_type_JavaUtilList));
    } while (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager == null);
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(localCommandInfo.jdField_a_of_type_JavaLangString);
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a().isBackgroundPause)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "isNeedFilterBackCommand isBackgroundStop");
      }
    }
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager == null) || (!(this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a() instanceof SplashActivity)));
      localObject = ((SplashActivity)this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a()).getSupportFragmentManager();
    } while (localObject == null);
    Object localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if ((localObject != null) && (((Fragment)localObject).isVisible())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioClearSessionServlet != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioClearSessionServlet.a();
    }
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a();
    }
    return null;
  }
  
  public List<VoiceItemInfo> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a();
    }
    return null;
  }
  
  public void a()
  {
    a(CommandUtils.a(this.b, true), VoiceDataUtils.b(this.b));
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(a(this.b));
    }
    ReportUtils.c();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null)
    {
      if (paramInt == 11)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.c();
        b(CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720613)));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) && (paramCommandInfo != null))
    {
      AssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(), paramCommandInfo);
      if (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo != null)
      {
        if (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(false, false);
        }
        if (paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.jdField_a_of_type_Int != 115) {
          break label108;
        }
        if (!paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.b) {
          break label95;
        }
        e(CommandUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString, paramCommandInfo));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      ReportUtils.a(paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo);
      return;
      label95:
      paramCommandInfo.jdField_a_of_type_Int = 2;
      b(paramCommandInfo);
      continue;
      label108:
      paramCommandInfo.jdField_a_of_type_Int = 2;
      a(paramCommandInfo, VoiceDataUtils.c(paramCommandInfo.jdField_a_of_type_JavaLangString));
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
    QLog.d("VoiceMainPresenter", 2, "mCurrentSpeech = " + this.c);
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
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.b();
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
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramCommandInfo.jdField_a_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null)
    {
      paramCommandInfo = BaseApplicationImpl.getContext().getString(2131720612);
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(new CommandInfo(2, paramCommandInfo));
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramCommandInfo);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      ReportUtils.d(3);
    }
  }
  
  public void d(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)))
    {
      if ((VoiceTextUtils.d(paramCommandInfo.jdField_a_of_type_JavaLangString)) && (VoiceTextUtils.a(a()))) {
        p(CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720607)));
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() == 7))
    {
      d(BaseApplicationImpl.getContext().getString(2131720611));
      return;
    }
    String str = paramCommandInfo.jdField_a_of_type_JavaLangString;
    List localList;
    if (VoiceTextUtils.e(paramCommandInfo.jdField_a_of_type_JavaLangString)) {
      localList = VoiceDataUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      a(paramCommandInfo, localList);
      if ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager == null) || (!paramCommandInfo.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(str);
      return;
      if (ViewCommandModelCheck.a())
      {
        str = BaseApplicationImpl.getContext().getString(2131720623);
        localList = VoiceDataUtils.b(str);
        paramCommandInfo.jdField_a_of_type_JavaLangString = str;
        str = a(str);
        ViewCommandModelCheck.a();
      }
      else
      {
        localList = VoiceDataUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void e(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 4) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)))
    {
      a(paramCommandInfo, VoiceDataUtils.d(paramCommandInfo.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramCommandInfo.jdField_a_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramCommandInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void i(CommandInfo paramCommandInfo)
  {
    boolean bool = false;
    if ((paramCommandInfo != null) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString)) && (paramCommandInfo.jdField_a_of_type_Int == 7) && (paramCommandInfo.jdField_a_of_type_JavaUtilList != null) && (!paramCommandInfo.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null))
    {
      if (paramCommandInfo.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label123;
      }
      paramCommandInfo = (FriendItemInfo)paramCommandInfo.jdField_a_of_type_JavaUtilList.get(0);
      if (!paramCommandInfo.jdField_a_of_type_Boolean) {
        bool = true;
      }
      a(CommandUtils.a(paramCommandInfo, true, bool));
      if (!paramCommandInfo.jdField_a_of_type_Boolean)
      {
        if (paramCommandInfo.jdField_a_of_type_Float >= FriendSortHelper.a()) {
          break label119;
        }
        ReportUtils.e();
      }
    }
    return;
    label119:
    ReportUtils.d();
    return;
    label123:
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreFriendSortHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreFriendSortHelper = new FriendSortHelper();
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreFriendSortHelper.a(this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(), paramCommandInfo.jdField_a_of_type_JavaUtilList);
    if ((localList != null) && (localList.size() > 0))
    {
      paramCommandInfo.jdField_a_of_type_JavaUtilList = localList;
      a(paramCommandInfo, VoiceDataUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString, localList));
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramCommandInfo.jdField_a_of_type_JavaLangString);
      ReportUtils.a();
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void j(CommandInfo paramCommandInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() == 5) || (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() == 11)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.c();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() == 5) || (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() == 11)) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo);
      h(CommandUtils.b());
      this.jdField_a_of_type_Boolean = false;
      ReportUtils.b(2);
    }
  }
  
  public void l(CommandInfo paramCommandInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) && (paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 10)) {
      a(paramCommandInfo.b, true);
    }
  }
  
  public void m(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 12) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() == 7)) {
      d(paramCommandInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void n(CommandInfo paramCommandInfo)
  {
    if (d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "backCommand isNeedFilterBackCommand");
      }
      return;
    }
    c();
    b(CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720592)));
  }
  
  public void o(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.jdField_a_of_type_Int == 14) && (!TextUtils.isEmpty(paramCommandInfo.jdField_a_of_type_JavaLangString))) {
      b(CommandUtils.a(paramCommandInfo.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void p(CommandInfo paramCommandInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "panel is dragging, so return");
      }
    }
    do
    {
      do
      {
        return;
        if (!a(paramCommandInfo)) {
          break;
        }
      } while ((paramCommandInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView == null) || (!QLog.isColorLevel()));
      QLog.d("VoiceMainPresenter", 2, "not need execute command, currentType = " + this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceView.a() + ", commandType = " + paramCommandInfo.jdField_a_of_type_Int);
      return;
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
    } while (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceModel == null);
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceModel.a(paramCommandInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter
 * JD-Core Version:    0.7.0.1
 */