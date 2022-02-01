package com.tencent.mobileqq.guild.chatpie.helper;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildChatPieFoldStatusListener;
import com.tencent.mobileqq.guild.chatpie.GuildHelperProvider;
import com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtManager;
import com.tencent.mobileqq.troop.quickat.ui.AtUtil;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnKeyEventPreImeListener;

public class GuildAtHelper
  implements IHelper, ILifeCycleHelper, XEditTextEx.OnKeyEventPreImeListener
{
  private final QBaseActivity a;
  private final GuildChatContext b;
  private GuildAtManager c;
  private final GuildChatPieFoldStatusListener d = new GuildAtHelper.1(this);
  
  public GuildAtHelper(GuildChatContext paramGuildChatContext)
  {
    this.b = paramGuildChatContext;
    this.a = paramGuildChatContext.b();
  }
  
  private void c(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.b.Q().getSelectionStart();
    int i = 0;
    boolean bool1;
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@'))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((paramInt3 == 0) && (j > 0))
    {
      paramInt1 = j - 1;
      if ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@'))
      {
        bool2 = true;
        break label102;
      }
    }
    boolean bool2 = false;
    label102:
    if ((bool1) || (bool2)) {
      f();
    }
    paramCharSequence = this.b.Q().getText().toString();
    int m = j - 1;
    paramInt3 = Math.max(paramCharSequence.lastIndexOf("＠", m), this.b.Q().getText().toString().lastIndexOf("@", m));
    int k = AtUtil.c(this.b.Q());
    int n = AtUtil.b(this.b.Q());
    paramCharSequence = null;
    if (m >= 0) {
      paramCharSequence = this.b.Q().getText().toString().substring(m, j);
    }
    if ((n >= 0) && (n == j)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    paramInt2 = i;
    if (n >= 0)
    {
      paramInt2 = i;
      if (n == m)
      {
        paramInt2 = i;
        if (paramCharSequence != null)
        {
          paramInt2 = i;
          if (paramCharSequence.equals(" ")) {
            paramInt2 = 1;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramCharSequence = new StringBuilder("selectIndex =");
      paramCharSequence.append(j);
      paramCharSequence.append(" isFirstAddAt=");
      paramCharSequence.append(bool1);
      paramCharSequence.append(" isFirstBackAt=");
      paramCharSequence.append(bool2);
      paramCharSequence.append(" max=");
      paramCharSequence.append(paramInt3);
      paramCharSequence.append(" lastSpanAt=");
      paramCharSequence.append(k);
      paramCharSequence.append(" mAtPanel=");
      paramCharSequence.append("mAtPanel");
      QLog.d("GuildAtHelper", 2, paramCharSequence.toString());
    }
    if ((k < paramInt3) && (paramInt3 >= 0) && (this.c != null))
    {
      paramCharSequence = this.b.Q().getText().toString().substring(paramInt3 + 1, j);
      View localView = this.a.findViewById(2131427929);
      this.c.a(localView, paramCharSequence);
      return;
    }
    paramCharSequence = this.c;
    if ((paramCharSequence != null) && (paramInt2 == 0) && (paramInt1 == 0)) {
      paramCharSequence.b();
    }
  }
  
  private void f()
  {
    if (this.c == null)
    {
      if (this.b.s().findViewById(2131427929) == null)
      {
        View localView = new View(this.a);
        localView.setId(2131427929);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(6, 2131435809);
        ((RelativeLayout)this.a.findViewById(2131430542)).addView(localView, 3, localLayoutParams);
      }
      this.c = new GuildAtManager(this.b);
      this.b.Q().setKeyEventPreImeListener(this);
    }
  }
  
  public void a()
  {
    GuildAtManager localGuildAtManager = this.c;
    if (localGuildAtManager != null) {
      localGuildAtManager.b();
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" beforeTextChanged:  start=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" after=");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" count=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("GuildAtHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if ((localObject != null) && (((GuildAtManager)localObject).d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildAtHelper", 2, "beforeTextChanged guildAtPanel spanChange");
      }
      return;
    }
    if ((paramInt3 == 0) && (paramInt2 > 0) && (paramCharSequence.length() > 0))
    {
      paramCharSequence = AtUtil.a(this.b.Q());
      paramInt2 = AtUtil.c(this.b.Q());
      if ((paramCharSequence != null) && (paramInt2 == paramInt1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildAtHelper", 2, new Object[] { " delete member:", paramCharSequence.a(), " nick:", paramCharSequence.b() });
        }
        localObject = this.c;
        if (localObject != null) {
          ((GuildAtManager)localObject).a(paramCharSequence.a());
        }
      }
    }
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 4)
    {
      paramKeyEvent = this.c;
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.b()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    ((GuildHelperProvider)this.b.d()).a(this.d);
  }
  
  public void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    GuildAtManager localGuildAtManager = this.c;
    if ((localGuildAtManager != null) && (localGuildAtManager.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildAtHelper", 2, "guildAtPanel spanChange");
      }
    }
    else if (this.b.k() != 3) {
      c(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void c()
  {
    ((GuildHelperProvider)this.b.d()).b(this.d);
    if (this.c != null)
    {
      View localView = this.b.b().findViewById(2131427929);
      if (localView != null) {
        this.b.s().removeView(localView);
      }
      this.c.c();
      this.b.Q().setKeyEventPreImeListener(null);
      this.c = null;
    }
  }
  
  public boolean d()
  {
    GuildAtManager localGuildAtManager = this.c;
    if (localGuildAtManager == null) {
      return false;
    }
    return localGuildAtManager.e();
  }
  
  public void e()
  {
    this.c.b();
  }
  
  public String getTag()
  {
    return "GuildAtHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildAtHelper
 * JD-Core Version:    0.7.0.1
 */