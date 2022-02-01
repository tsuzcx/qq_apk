package com.tencent.mobileqq.gamecenter.message;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GameMsgAddFriendDialog
  extends PopupWindow
  implements TextWatcher, View.OnClickListener
{
  public static final String a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String b;
  private String c;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = GameMsgChatPie.g;
  }
  
  public GameMsgAddFriendDialog(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramQQAppInterface = new GameMsgAddFriendDialog(paramQQAppInterface, paramBaseActivity, LayoutInflater.from(paramBaseActivity).inflate(2131559264, null), -1, AIOUtils.a(460.0F, paramBaseActivity.getResources()), paramString3, paramString4, paramString5);
    paramQQAppInterface.a(paramString1, paramString2);
    paramQQAppInterface.setFocusable(true);
    paramQQAppInterface.setInputMethodMode(1);
    paramQQAppInterface.setSoftInputMode(16);
    paramQQAppInterface.setOutsideTouchable(true);
    a(Float.valueOf(0.5F), paramBaseActivity.getWindow());
    paramString1 = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
    paramString1.setInterpolator(new AccelerateInterpolator());
    paramString1.setDuration(200L);
    paramString1.setAnimationListener(new GameMsgAddFriendDialog.1());
    paramQQAppInterface.showAtLocation(paramBaseActivity.getWindow().getDecorView(), 80, 0, 0);
    paramQQAppInterface.getContentView().startAnimation(paramString1);
  }
  
  public static void a(Float paramFloat, Window paramWindow)
  {
    try
    {
      WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
      localLayoutParams.alpha = paramFloat.floatValue();
      paramWindow.addFlags(2);
      paramWindow.setAttributes(localLayoutParams);
      return;
    }
    catch (Throwable paramFloat)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramFloat.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[initView], mRootView is NULL.");
    }
    label266:
    for (;;)
    {
      return;
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364815)).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362190));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131376969));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379432)).setText(paramString2 + "添加好友");
      paramString2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372093);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381975));
      if (TextUtils.isEmpty(paramString1)) {
        paramString2.setVisibility(8);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label266;
        }
        paramString1 = ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).b(this.d);
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString1);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "appId:" + this.d + ",verifyMsg:" + paramString1);
        return;
        paramString2.setText(paramString1);
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void dismiss()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation.setDuration(200L);
    getContentView().startAnimation(localTranslateAnimation);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
    localTranslateAnimation.setAnimationListener(new GameMsgAddFriendDialog.2(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        ((GameCenterUnissoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER)).a(1, this.c, this.b, str);
        dismiss();
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {}
    do
    {
      return;
      paramInt1 = paramCharSequence.length();
      paramCharSequence = paramInt1 + "/" + 16;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      }
    } while (this.jdField_a_of_type_AndroidWidgetButton == null);
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAddFriendDialog
 * JD-Core Version:    0.7.0.1
 */