package com.tencent.mobileqq.gamecenter.ui;

import android.app.Activity;
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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHandlerNameApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.utils.CommUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GameMsgAddFriendDialog
  extends PopupWindow
  implements TextWatcher, View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public GameMsgAddFriendDialog() {}
  
  public GameMsgAddFriendDialog(AppInterface paramAppInterface, Activity paramActivity, View paramView, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null)
    {
      QLog.e("GameMsgAddFriendDialog", 1, "[initView], mRootView is NULL.");
      return;
    }
    ((ImageView)((View)localObject).findViewById(2131364703)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362216));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131376459));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("添加好友");
    ((TextView)localObject).setText(localStringBuilder.toString());
    paramString2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371685);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381179));
    if (TextUtils.isEmpty(paramString1)) {
      paramString2.setVisibility(8);
    } else {
      paramString2.setText(paramString1);
    }
    paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (paramString1 != null)
    {
      paramString1 = ((IGameMsgManagerService)paramString1.getRuntimeService(IGameMsgManagerService.class, "")).getFriVerifyMsg(this.c);
      if (!TextUtils.isEmpty(paramString1))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString1);
        paramString2 = new StringBuilder();
        paramString2.append("appId:");
        paramString2.append(this.c);
        paramString2.append(",verifyMsg:");
        paramString2.append(paramString1);
        QLog.i("GameMsgAddFriendDialog", 1, paramString2.toString());
      }
    }
  }
  
  private static void b(Float paramFloat, Window paramWindow)
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
      QLog.e("GameMsgAddFriendDialog", 1, paramFloat.getMessage());
    }
  }
  
  public void a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramAppInterface = new GameMsgAddFriendDialog(paramAppInterface, paramActivity, LayoutInflater.from(paramActivity).inflate(2131559138, null), -1, CommUtils.a(460.0F, paramActivity.getResources()), paramString3, paramString4, paramString5);
    paramAppInterface.a(paramString1, paramString2);
    paramAppInterface.setFocusable(true);
    paramAppInterface.setInputMethodMode(1);
    paramAppInterface.setSoftInputMode(16);
    paramAppInterface.setOutsideTouchable(true);
    b(Float.valueOf(0.5F), paramActivity.getWindow());
    paramString1 = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
    paramString1.setInterpolator(new AccelerateInterpolator());
    paramString1.setDuration(200L);
    paramString1.setAnimationListener(new GameMsgAddFriendDialog.1(this));
    paramAppInterface.showAtLocation(paramActivity.getWindow().getDecorView(), 80, 0, 0);
    paramAppInterface.getContentView().startAnimation(paramString1);
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
    int i = paramView.getId();
    if (i == 2131364703)
    {
      dismiss();
    }
    else if ((i == 2131362216) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
    {
      CommUtils.a(this.jdField_a_of_type_AndroidAppActivity);
      String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      String str2 = ((IGameMsgHandlerNameApi)QRoute.api(IGameMsgHandlerNameApi.class)).getGameMsgHandlerName();
      ((GameCenterUnissoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(str2)).a(1, this.b, this.jdField_a_of_type_JavaLangString, str1);
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    paramInt1 = paramCharSequence.length();
    paramCharSequence = new StringBuilder();
    paramCharSequence.append(paramInt1);
    paramCharSequence.append("/");
    paramCharSequence.append(16);
    paramCharSequence = paramCharSequence.toString();
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
    paramCharSequence = this.jdField_a_of_type_AndroidWidgetButton;
    if (paramCharSequence == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      paramCharSequence.setEnabled(false);
      return;
    }
    paramCharSequence.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.GameMsgAddFriendDialog
 * JD-Core Version:    0.7.0.1
 */