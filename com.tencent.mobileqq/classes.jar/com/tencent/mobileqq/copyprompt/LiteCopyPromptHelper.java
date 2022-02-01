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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class LiteCopyPromptHelper
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new LiteCopyPromptHelper.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private SoftKeyboardObserver jdField_a_of_type_ComTencentBizSoftKeyboardObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LiteCopyPromptHelper.4(this);
  
  public LiteCopyPromptHelper(Context paramContext, ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, XEditTextEx paramXEditTextEx)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = paramXEditTextEx;
  }
  
  private View a(String paramString)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559705, this.jdField_a_of_type_AndroidViewViewGroup, false);
    ((TextView)localView.findViewById(2131373587)).setText(new QQText(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131369142);
    paramString.leftMargin = AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364598)).addView(localView, paramString);
    return localView;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new LiteCopyPromptHelper.3(this, paramString));
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver == null) {
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = new SoftKeyboardObserver(this.jdField_a_of_type_AndroidViewViewGroup, new LiteCopyPromptHelper.2(this));
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable.run();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver != null)
    {
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver.a();
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = null;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.COPY_PROMPT_MANAGER);
    if ((localObject instanceof CopyPromptManager))
    {
      localObject = ((CopyPromptManager)localObject).a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        d();
        this.jdField_a_of_type_AndroidViewView = a((String)localObject);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        c();
        a((String)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper
 * JD-Core Version:    0.7.0.1
 */