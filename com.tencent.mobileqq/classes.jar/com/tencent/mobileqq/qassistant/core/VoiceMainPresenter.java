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
  private IVoiceAssistantCore a;
  private VoiceModel b;
  private VoiceView c;
  private String d;
  private String e;
  private ClearSessionServlet f;
  private FriendSortHelper g;
  private boolean h = false;
  private int i;
  private volatile String j;
  private Instrumentation k;
  
  public VoiceMainPresenter(VoiceAssistantCoreImpl paramVoiceAssistantCoreImpl)
  {
    this.a = paramVoiceAssistantCoreImpl;
    this.b = new VoiceModel(this);
    this.c = new VoiceView(this);
    this.f = new ClearSessionServlet();
    this.d = AssistantUtils.a(2131917960);
    this.e = AssistantUtils.a(2131917974);
    g();
  }
  
  private void a(CommandInfo paramCommandInfo, List<VoiceItemInfo> paramList)
  {
    VoiceView localVoiceView = this.c;
    if (localVoiceView != null) {
      localVoiceView.a(paramCommandInfo, paramList);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.c;
    if ((localObject != null) && (this.a != null))
    {
      int n = ((VoiceView)localObject).e();
      int m = 2;
      if (n != 4)
      {
        if (n != 5)
        {
          if (n != 6)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("dealChooseResult error type = ");
              ((StringBuilder)localObject).append(this.c.e());
              QLog.d("VoiceMainPresenter", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            if (paramBoolean1) {
              b(CommandUtils.a(AssistantUtils.a(2131917966)));
            } else {
              p(CommandUtils.a(VoiceDataUtils.a(1), false));
            }
            if (this.h)
            {
              j();
              this.h = false;
            }
          }
        }
        else
        {
          if (paramBoolean1)
          {
            localObject = null;
            if (this.c.f() != null) {
              localObject = this.c.f().i;
            }
            this.a.onConfirmSend((ConfirmSendInfo)localObject);
            h(CommandUtils.b());
            ReportUtils.b(1);
          }
          else
          {
            this.a.cancelSendVoice();
            b(CommandUtils.a(AssistantUtils.a(2131917963)));
            ReportUtils.a(1);
          }
          if (this.h)
          {
            j();
            this.h = false;
          }
        }
      }
      else
      {
        localObject = VoiceTextUtils.a(this.c.f());
        if (paramBoolean1)
        {
          b(CommandUtils.a(AssistantUtils.a(2131917966)));
          if (this.h)
          {
            j();
            this.h = false;
          }
          if (localObject != null)
          {
            if (paramBoolean2) {
              m = 1;
            }
            ReportUtils.f(m);
          }
        }
        else
        {
          if (localObject != null)
          {
            if (paramBoolean2) {
              m = 1;
            }
            if (((FriendItemInfo)localObject).h >= FriendSortHelper.a())
            {
              ReportUtils.b(m, FriendSortHelper.a());
            }
            else
            {
              f();
              ReportUtils.a(m, FriendSortHelper.a());
            }
          }
          ThreadManager.getUIHandler().post(new VoiceMainPresenter.3(this));
          this.h = true;
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      CommandInfo localCommandInfo = this.c.f();
      if ((localCommandInfo != null) && (localCommandInfo.f != null) && (localCommandInfo.f.a == 115) && (localCommandInfo.d != null) && (localCommandInfo.d.size() > 0) && (localCommandInfo.d.get(0) != null) && (VoiceTextUtils.a(paramString, ((FriendItemInfo)localCommandInfo.d.get(0)).b))) {
        this.a.onStartRecord();
      }
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
    CommandInfo localCommandInfo = this.c.f();
    localCommandInfo.b = paramString;
    a(localCommandInfo, VoiceDataUtils.a(localCommandInfo.b, localCommandInfo.d));
    paramString = this.a;
    if (paramString != null) {
      paramString.play(localCommandInfo.b);
    }
  }
  
  private String e(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(",");
    int m = 0;
    while (m < VoiceDataUtils.a.length)
    {
      localStringBuffer.append(AssistantUtils.a(VoiceDataUtils.a[m]));
      localStringBuffer.append(",");
      m += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void g()
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.a;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.setPlayEventListener(this);
    }
  }
  
  private boolean h()
  {
    VoiceView localVoiceView = this.c;
    if ((localVoiceView != null) && (localVoiceView.f() != null)) {
      return VoiceTextUtils.c(this.c.f().b);
    }
    return false;
  }
  
  private boolean i()
  {
    VoiceView localVoiceView = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localVoiceView != null)
    {
      bool1 = bool2;
      if (localVoiceView.f() != null)
      {
        bool1 = bool2;
        if (this.c.f().f != null)
        {
          bool1 = bool2;
          if (this.c.f().f.a == 115) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void j()
  {
    ClearSessionServlet localClearSessionServlet = this.f;
    if (localClearSessionServlet != null) {
      localClearSessionServlet.a();
    }
  }
  
  private boolean k()
  {
    Object localObject = AssistantUtils.c();
    boolean bool2 = false;
    if ((localObject != null) && (AssistantUtils.c().isBackgroundPause))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "isNeedFilterBackCommand isBackgroundStop");
      }
      return false;
    }
    localObject = this.a;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if ((((IVoiceAssistantCore)localObject).getActivity() instanceof QBaseActivity))
      {
        localObject = ((QBaseActivity)this.a.getActivity()).getSupportFragmentManager();
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
  
  private boolean q(CommandInfo paramCommandInfo)
  {
    VoiceView localVoiceView = this.c;
    int n = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    int m = 0;
    boolean bool1 = bool4;
    if (localVoiceView != null)
    {
      bool1 = bool4;
      if (paramCommandInfo != null)
      {
        int i1 = localVoiceView.e();
        if (i1 == 5)
        {
          if ((paramCommandInfo.a == 9) || (paramCommandInfo.a == 8) || (paramCommandInfo.a == 11) || (paramCommandInfo.a == 5) || (paramCommandInfo.a == 6)) {
            m = 1;
          }
          return m ^ 0x1;
        }
        if (i1 == 11)
        {
          if ((paramCommandInfo.a != 8) && (paramCommandInfo.a != 9) && (paramCommandInfo.a != 5) && (paramCommandInfo.a != 11))
          {
            m = n;
            if (paramCommandInfo.a != 6) {}
          }
          else
          {
            m = 1;
          }
          return m ^ 0x1;
        }
        if (h())
        {
          bool1 = bool3;
          if (paramCommandInfo.a != 5) {
            bool1 = true;
          }
          return bool1;
        }
        if (VoiceTextUtils.a(paramCommandInfo.b)) {
          return false;
        }
        if (VoiceTextUtils.a(d()))
        {
          bool1 = bool4;
          if (paramCommandInfo.a == 5) {
            return true;
          }
        }
        else
        {
          if (i())
          {
            bool1 = bool2;
            if (paramCommandInfo.a != 5)
            {
              bool1 = bool2;
              if (paramCommandInfo.a != 10)
              {
                bool1 = bool2;
                if (paramCommandInfo.a != 0)
                {
                  bool1 = bool2;
                  if (paramCommandInfo.a != 1)
                  {
                    bool1 = bool2;
                    if (paramCommandInfo.a != 13) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
            return bool1;
          }
          bool1 = bool4;
          if (!TextUtils.isEmpty(paramCommandInfo.b))
          {
            bool1 = bool4;
            if (paramCommandInfo.b.equals(this.d))
            {
              if ((!TextUtils.isEmpty(this.j)) && ((this.j.equals(this.d)) || (this.j.equals(e(this.e))))) {
                return true;
              }
              if (i1 != 6)
              {
                bool1 = bool4;
                if (i1 != 4) {}
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
  
  public void a()
  {
    a(CommandUtils.a(this.e, true), VoiceDataUtils.b(this.e));
    IVoiceAssistantCore localIVoiceAssistantCore = this.a;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.play(e(this.e));
    }
    ReportUtils.c();
  }
  
  public void a(int paramInt)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.a;
    if (localIVoiceAssistantCore != null)
    {
      if (paramInt == 11)
      {
        localIVoiceAssistantCore.cancelSendVoice();
        b(CommandUtils.a(AssistantUtils.a(2131917963)));
        ReportUtils.a(1);
      }
      if (this.h)
      {
        j();
        this.h = false;
      }
    }
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.a;
    if ((localIVoiceAssistantCore != null) && (paramCommandInfo != null))
    {
      AssistantUtils.a(localIVoiceAssistantCore.getActivity(), paramCommandInfo);
      if (paramCommandInfo.f != null)
      {
        if (paramCommandInfo.f.e) {
          this.a.quiteVoicePanel(false, false);
        }
        if (paramCommandInfo.f.a == 115)
        {
          if (paramCommandInfo.f.f)
          {
            e(CommandUtils.a(paramCommandInfo.b, paramCommandInfo));
          }
          else
          {
            paramCommandInfo.a = 2;
            b(paramCommandInfo);
          }
        }
        else
        {
          paramCommandInfo.a = 2;
          a(paramCommandInfo, VoiceDataUtils.c(paramCommandInfo.b));
        }
      }
      this.h = false;
      ReportUtils.a(paramCommandInfo.f);
    }
  }
  
  public void a(FriendItemInfo paramFriendItemInfo)
  {
    if (paramFriendItemInfo != null)
    {
      a(CommandUtils.a(paramFriendItemInfo, paramFriendItemInfo.d, false));
      ReportUtils.c(1);
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCurrentSpeech = ");
    localStringBuilder.append(this.j);
    QLog.d("VoiceMainPresenter", 2, localStringBuilder.toString());
    this.j = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public View b()
  {
    VoiceView localVoiceView = this.c;
    if (localVoiceView != null) {
      return localVoiceView.c();
    }
    return null;
  }
  
  public void b(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.a == 2) && (!TextUtils.isEmpty(paramCommandInfo.b)))
    {
      a(paramCommandInfo, VoiceDataUtils.c(paramCommandInfo.b));
      IVoiceAssistantCore localIVoiceAssistantCore = this.a;
      if (localIVoiceAssistantCore != null) {
        localIVoiceAssistantCore.play(paramCommandInfo.b);
      }
      if (VoiceTextUtils.f(paramCommandInfo.b)) {
        this.h = true;
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.j)) && (paramString.equals(this.j))) {
      this.j = "";
    }
    ThreadManager.getUIHandler().post(new VoiceMainPresenter.1(this, paramString));
  }
  
  public void c(CommandInfo paramCommandInfo)
  {
    if (this.a != null)
    {
      paramCommandInfo = AssistantUtils.a(2131917962);
      this.a.executeCommand(new CommandInfo(2, paramCommandInfo));
      this.a.play(paramCommandInfo);
      this.h = false;
      this.i = 0;
      ReportUtils.d(3);
    }
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public List<VoiceItemInfo> d()
  {
    VoiceView localVoiceView = this.c;
    if (localVoiceView != null) {
      return localVoiceView.d();
    }
    return null;
  }
  
  public void d(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.a == 3) && (!TextUtils.isEmpty(paramCommandInfo.b)))
    {
      if ((VoiceTextUtils.d(paramCommandInfo.b)) && (VoiceTextUtils.a(d())))
      {
        p(CommandUtils.a(AssistantUtils.a(2131917957)));
        return;
      }
      Object localObject = this.c;
      if ((localObject != null) && (((VoiceView)localObject).e() == 7))
      {
        d(AssistantUtils.a(2131917961));
        return;
      }
      String str = paramCommandInfo.b;
      if (VoiceTextUtils.e(paramCommandInfo.b))
      {
        localObject = VoiceDataUtils.a(paramCommandInfo.b);
      }
      else if (ViewCommandModelCheck.a())
      {
        str = AssistantUtils.a(2131917973);
        localObject = VoiceDataUtils.b(str);
        paramCommandInfo.b = str;
        str = e(str);
        ViewCommandModelCheck.b();
      }
      else
      {
        localObject = VoiceDataUtils.a(paramCommandInfo.b);
      }
      a(paramCommandInfo, (List)localObject);
      if ((this.a != null) && (paramCommandInfo.c)) {
        this.a.play(str);
      }
    }
  }
  
  public void e()
  {
    VoiceView localVoiceView = this.c;
    if (localVoiceView != null) {
      localVoiceView.b();
    }
    if (this.h)
    {
      j();
      this.h = false;
    }
    this.i = 0;
    this.j = "";
  }
  
  public void e(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.a == 4) && (!TextUtils.isEmpty(paramCommandInfo.b)))
    {
      a(paramCommandInfo, VoiceDataUtils.d(paramCommandInfo.b));
      IVoiceAssistantCore localIVoiceAssistantCore = this.a;
      if (localIVoiceAssistantCore != null) {
        localIVoiceAssistantCore.play(paramCommandInfo.b);
      }
    }
  }
  
  public void f()
  {
    ThreadManager.getSubThreadHandler().post(new VoiceMainPresenter.2(this));
  }
  
  public void f(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.e != null) && (paramCommandInfo.a == 5)) {
      a(paramCommandInfo, VoiceDataUtils.a(paramCommandInfo.e.a, paramCommandInfo.e.b));
    }
  }
  
  public void g(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.e != null) && (paramCommandInfo.a == 11)) {
      a(paramCommandInfo, VoiceDataUtils.a(paramCommandInfo.e.a, paramCommandInfo.e.b, paramCommandInfo.e.c));
    }
  }
  
  public void h(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.a == 6))
    {
      a(paramCommandInfo, VoiceDataUtils.d(paramCommandInfo.b));
      IVoiceAssistantCore localIVoiceAssistantCore = this.a;
      if (localIVoiceAssistantCore != null) {
        localIVoiceAssistantCore.play(paramCommandInfo.b);
      }
    }
  }
  
  public void i(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (!TextUtils.isEmpty(paramCommandInfo.b)) && (paramCommandInfo.a == 7) && (paramCommandInfo.d != null) && (!paramCommandInfo.d.isEmpty()) && (this.a != null)) {
      if (paramCommandInfo.d.size() == 1)
      {
        paramCommandInfo = (FriendItemInfo)paramCommandInfo.d.get(0);
        a(CommandUtils.a(paramCommandInfo, true, paramCommandInfo.d ^ true));
        if (!paramCommandInfo.d)
        {
          if (paramCommandInfo.h < FriendSortHelper.a())
          {
            ReportUtils.e();
            return;
          }
          ReportUtils.d();
        }
      }
      else
      {
        if (this.g == null) {
          this.g = new FriendSortHelper();
        }
        List localList = this.g.a(paramCommandInfo.d);
        if ((localList != null) && (localList.size() > 0))
        {
          paramCommandInfo.d = localList;
          a(paramCommandInfo, VoiceDataUtils.a(paramCommandInfo.b, localList));
          this.a.play(paramCommandInfo.b);
          ReportUtils.a();
        }
        this.h = true;
      }
    }
  }
  
  public void j(CommandInfo paramCommandInfo)
  {
    Object localObject = this.c;
    if ((localObject != null) && ((((VoiceView)localObject).e() == 5) || (this.c.e() == 11)))
    {
      localObject = this.a;
      if (localObject != null) {
        ((IVoiceAssistantCore)localObject).cancelSendVoice();
      }
      if (paramCommandInfo != null) {
        b(CommandUtils.a(paramCommandInfo.b));
      }
      this.h = false;
      ReportUtils.a(2);
    }
  }
  
  public void k(CommandInfo paramCommandInfo)
  {
    Object localObject = this.c;
    if ((localObject != null) && ((((VoiceView)localObject).e() == 5) || (this.c.e() == 11)))
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IVoiceAssistantCore)localObject).onConfirmSend(paramCommandInfo.i);
        h(CommandUtils.b());
        this.h = false;
        ReportUtils.b(2);
      }
    }
  }
  
  public void l(CommandInfo paramCommandInfo)
  {
    if ((this.a != null) && (paramCommandInfo != null) && (paramCommandInfo.a == 10)) {
      a(paramCommandInfo.g, true);
    }
  }
  
  public void m(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.a == 12))
    {
      VoiceView localVoiceView = this.c;
      if ((localVoiceView != null) && (localVoiceView.e() == 7)) {
        d(paramCommandInfo.b);
      }
    }
  }
  
  public void n(CommandInfo paramCommandInfo)
  {
    if (k())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "backCommand isNeedFilterBackCommand");
      }
    }
    else
    {
      f();
      b(CommandUtils.a(AssistantUtils.a(2131917942)));
    }
  }
  
  public void o(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.a == 14) && (!TextUtils.isEmpty(paramCommandInfo.b))) {
      b(CommandUtils.a(paramCommandInfo.b));
    }
  }
  
  public void p(CommandInfo paramCommandInfo)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((VoiceView)localObject).g()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "panel is dragging, so return");
      }
      return;
    }
    if (q(paramCommandInfo))
    {
      if ((paramCommandInfo != null) && (this.c != null) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("not need execute command, currentType = ");
        ((StringBuilder)localObject).append(this.c.e());
        ((StringBuilder)localObject).append(", commandType = ");
        ((StringBuilder)localObject).append(paramCommandInfo.a);
        QLog.d("VoiceMainPresenter", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((paramCommandInfo != null) && (paramCommandInfo.a == 3) && (!TextUtils.isEmpty(paramCommandInfo.b)) && (paramCommandInfo.b.equals(this.d)))
    {
      this.i += 1;
      if (this.i > 3)
      {
        this.i = 0;
        a();
      }
    }
    else
    {
      this.i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      ((VoiceModel)localObject).a(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter
 * JD-Core Version:    0.7.0.1
 */