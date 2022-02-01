package com.tencent.mobileqq.receipt;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOInputRightHelper;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class ReceiptHelper
  implements View.OnClickListener, OnFinishListener, ILifeCycleHelper
{
  public boolean a;
  private final AIOContext b;
  private View c;
  private TextView d;
  private View e;
  
  public ReceiptHelper(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
  }
  
  private void d()
  {
    if (this.a)
    {
      this.a = false;
      a(8);
    }
    ReceiptMsgManager.a().b();
    View localView = this.e;
    if (localView != null)
    {
      this.b.b(localView);
      this.b.c(this.c);
      this.b.c(this.d);
      this.e = null;
      this.c = null;
      this.d = null;
      ((RelativeLayout.LayoutParams)this.b.e().b().x()).addRule(2, 2131435809);
    }
  }
  
  public void a()
  {
    Object localObject3 = this.b.b();
    if ((!this.a) && (ReceiptUtil.b(this.b.a()) <= 0))
    {
      QQToast.makeText((Context)localObject3, ((BaseActivity)localObject3).getString(2131896517), 0).show(((BaseActivity)localObject3).getResources().getDimensionPixelSize(2131299920));
      ReportController.b(this.b.a(), "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
      return;
    }
    this.a ^= true;
    ((FastImageHelper)this.b.a(83)).b(true);
    ((AIOEmoticonGuideHelper)this.b.a(54)).b();
    Object localObject2 = this.b.p().d();
    Object localObject1 = ((InputUIContainer)localObject2).f();
    if (this.a)
    {
      if (((InputUIContainer)localObject2).c().d()) {
        ((AIOInputRightHelper)this.b.a(117)).b();
      }
      b();
      this.b.a(1, true);
      this.b.b(true);
      a(0);
      int i = ReceiptUtil.b(this.b.a());
      localObject2 = String.valueOf(i);
      if (i < 4)
      {
        localObject3 = String.format(((BaseActivity)localObject3).getString(2131896531), new Object[] { localObject2 });
        SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
        localSpannableString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.getContext().getResources().getColor(2131168170)), ((String)localObject3).length() - ((String)localObject2).length() - 2, ((String)localObject3).length() - 2, 18);
        this.d.setText(localSpannableString);
      }
      else
      {
        this.d.setText(2131896530);
      }
      i = BaseApplicationImpl.getContext().getResources().getColor(2131168171);
      this.d.setTextColor(i);
      ((EditTextUI)localObject1).a(null, null, null, null);
      ((EditTextUI)localObject1).a(2131441550, null);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.b.a(), "receipt_msg", true);
      localObject1 = (AIOShortcutBarHelper)this.b.a(52);
      if (localObject1 != null) {
        ((AIOShortcutBarHelper)localObject1).d(11);
      }
      if (this.b.O().a == 0) {
        i = 1;
      } else if (this.b.O().a == 3000) {
        i = 2;
      } else {
        i = 3;
      }
      ReportController.b(this.b.a(), "CliOper", "", "", "0x80083E8", "0x80083E8", i, 0, "", "", "", "");
    }
    else
    {
      this.b.q().a(false, this.b.b(), this.b.p().d().f().b());
      this.b.J();
      a(8);
      ((EditTextUI)localObject1).a().clear();
      this.b.g().post(new ReceiptHelper.1(this));
    }
    ((PhotoListPanelProvider)this.b.q().f(4)).a(this.a);
    localObject1 = (AIOEmoticonUIHelper)this.b.a(105);
    if (localObject1 != null) {
      ((AIOEmoticonUIHelper)localObject1).o();
    }
    ((AudioPanelProvider)this.b.q().f(2)).b();
    this.b.p().d().d().c();
  }
  
  public void a(int paramInt)
  {
    BaseActivity localBaseActivity = this.b.b();
    if (this.e == null)
    {
      this.c = new View(localBaseActivity);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      int i = Color.parseColor("#7f000000");
      this.c.setBackgroundColor(i);
      this.c.setId(2131442202);
      this.c.setOnClickListener(this);
      localLayoutParams.addRule(2, 2131442234);
      this.b.b(this.c, localLayoutParams);
      this.d = new TextView(localBaseActivity);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(40.0F, localBaseActivity.getResources()));
      this.d.setGravity(17);
      this.d.setTextSize(14.0F);
      this.d.setId(2131442234);
      localLayoutParams.addRule(2, 2131435809);
      this.b.b(this.d, localLayoutParams);
      this.e = new View(localBaseActivity);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, localBaseActivity.getResources().getDimensionPixelSize(2131299920));
      this.e.setBackgroundColor(i);
      this.e.setId(2131442232);
      this.e.setOnClickListener(this);
      localLayoutParams.addRule(6, 2131444897);
      this.b.a(this.e, localLayoutParams);
    }
    ((RelativeLayout.LayoutParams)this.b.e().b().x()).addRule(2, 2131442234);
    this.c.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
    this.e.setVisibility(paramInt);
    if ((ChatFragment)localBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName()) == null) {}
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  protected void b()
  {
    if (this.b.H()) {
      ((TroopAIOContext)this.b).Q();
    }
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public boolean d(int paramInt)
  {
    if (this.a)
    {
      a();
      return true;
    }
    return false;
  }
  
  public void e(int paramInt) {}
  
  @NonNull
  public String getTag()
  {
    return "ReceiptHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15 };
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131442202) || (i == 2131442232)) {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 15) {
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptHelper
 * JD-Core Version:    0.7.0.1
 */