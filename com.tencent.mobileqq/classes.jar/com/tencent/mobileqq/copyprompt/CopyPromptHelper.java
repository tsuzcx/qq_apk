package com.tencent.mobileqq.copyprompt;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class CopyPromptHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new CopyPromptHelper.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private SoftKeyboardObserver jdField_a_of_type_ComTencentBizSoftKeyboardObserver;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CopyPromptHelper.4(this);
  
  public CopyPromptHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private View a(String paramString)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2131559705, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c, false);
    ((TextView)localView.findViewById(2131373587)).setText(new QQText(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131369142);
    paramString.leftMargin = AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364598)).addView(localView, paramString);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", "", "0X800B22B", "0X800B22B", 0, 0, "", "", "", "");
    return localView;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new CopyPromptHelper.3(this, paramString));
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364695).getVisibility() == 0;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.COPY_PROMPT_MANAGER);
    if ((localObject instanceof CopyPromptManager))
    {
      localObject = ((CopyPromptManager)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("CopyPromptHelper", 2, "handlePrompt content : " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a();
        this.jdField_a_of_type_AndroidViewView = a((String)localObject);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        c();
        a((String)localObject);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver == null) {
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = new SoftKeyboardObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c, new CopyPromptHelper.2(this));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public String getTag()
  {
    return "CopyPromptHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14 };
  }
  
  public void onClick(View paramView)
  {
    if (!a()) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable.run();
      if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver != null)
      {
        this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver.a();
        this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = null;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper
 * JD-Core Version:    0.7.0.1
 */