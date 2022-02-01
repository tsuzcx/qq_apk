package com.tencent.mobileqq.receipt;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
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
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;

public class ReceiptHelper
  implements View.OnClickListener, OnFinishListener, ILifeCycleHelper
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  public boolean a;
  private View b;
  
  public ReceiptHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a(8);
    }
    ReceiptMsgManager.a().a();
    View localView = this.b;
    if (localView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b(localView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.c(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.c(this.jdField_a_of_type_AndroidWidgetTextView);
      this.b = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a()).addRule(2, 2131368875);
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if ((!this.jdField_a_of_type_Boolean) && (ReceiptUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()) <= 0))
    {
      QQToast.a((Context)localObject3, ((BaseActivity)localObject3).getString(2131698570), 0).b(((BaseActivity)localObject3).getResources().getDimensionPixelSize(2131299168));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_Boolean ^= true;
    ((FastImageHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(83)).b(true);
    ((AIOEmoticonGuideHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(54)).b();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
    Object localObject1 = ((InputUIContainer)localObject2).a();
    if (this.jdField_a_of_type_Boolean)
    {
      if (((InputUIContainer)localObject2).a().a()) {
        ((AIOInputRightHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(117)).b();
      }
      b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(1, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b(true);
      a(0);
      int i = ReceiptUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      localObject2 = String.valueOf(i);
      if (i < 4)
      {
        localObject3 = String.format(((BaseActivity)localObject3).getString(2131698584), new Object[] { localObject2 });
        SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
        localSpannableString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.getContext().getResources().getColor(2131167185)), ((String)localObject3).length() - ((String)localObject2).length() - 2, ((String)localObject3).length() - 2, 18);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698583);
      }
      i = BaseApplicationImpl.getContext().getResources().getColor(2131167186);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      ((EditTextUI)localObject1).a(null, null, null, null);
      ((EditTextUI)localObject1).a(2131373876, null);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "receipt_msg", true);
      localObject1 = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(52);
      if (localObject1 != null) {
        ((AIOShortcutBarHelper)localObject1).c(11);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a == 0) {
        i = 1;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a == 3000) {
        i = 2;
      } else {
        i = 3;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "CliOper", "", "", "0x80083E8", "0x80083E8", i, 0, "", "", "", "");
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.e();
      a(8);
      ((EditTextUI)localObject1).a().clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().post(new ReceiptHelper.1(this));
    }
    ((PhotoListPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(4)).a(this.jdField_a_of_type_Boolean);
    localObject1 = (AIOEmoticonUIHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(105);
    if (localObject1 != null) {
      ((AIOEmoticonUIHelper)localObject1).i();
    }
    ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(2)).a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().c();
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if (this.b == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View((Context)localObject);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      int i = Color.parseColor("#7f000000");
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_a_of_type_AndroidViewView.setId(2131374107);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      localLayoutParams.addRule(2, 2131374139);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView((Context)localObject);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(40.0F, ((BaseActivity)localObject).getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131374139);
      localLayoutParams.addRule(2, 2131368875);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      this.b = new View((Context)localObject);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131299168));
      this.b.setBackgroundColor(i);
      this.b.setId(2131374137);
      this.b.setOnClickListener(this);
      localLayoutParams.addRule(6, 2131376636);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(this.b, localLayoutParams);
    }
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a()).addRule(2, 2131374139);
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.b.setVisibility(paramInt);
    localObject = (ChatFragment)((BaseActivity)localObject).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      if (((ChatFragment)localObject).a == null) {
        return;
      }
      if (paramInt == 0)
      {
        ((ChatFragment)localObject).a.setStatusBarMask(new PorterDuffColorFilter(2130706432, PorterDuff.Mode.SRC_ATOP));
        return;
      }
      ((ChatFragment)localObject).a.setStatusBarMask(null);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a();
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.i()) {
      ((TroopAIOContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).g();
    }
  }
  
  public void d(int paramInt) {}
  
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
    if ((i == 2131374107) || (i == 2131374137)) {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 15) {
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptHelper
 * JD-Core Version:    0.7.0.1
 */