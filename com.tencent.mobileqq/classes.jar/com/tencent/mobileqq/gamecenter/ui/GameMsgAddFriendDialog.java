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
  private Activity a;
  private View b;
  private AppInterface c;
  private String d;
  private String e;
  private EditText f;
  private TextView g;
  private Button h;
  private String i;
  private int j;
  
  public GameMsgAddFriendDialog() {}
  
  public GameMsgAddFriendDialog(int paramInt1, AppInterface paramAppInterface, Activity paramActivity, View paramView, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    super(paramView, paramInt2, paramInt3);
    this.j = paramInt1;
    this.a = paramActivity;
    this.b = paramView;
    this.c = paramAppInterface;
    this.d = paramString1;
    this.e = paramString2;
    this.i = paramString3;
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.e("GameMsgAddFriendDialog", 1, "[initView], mRootView is NULL.");
      return;
    }
    ((ImageView)((View)localObject).findViewById(2131430806)).setOnClickListener(this);
    this.h = ((Button)this.b.findViewById(2131427797));
    this.h.setOnClickListener(this);
    this.f = ((EditText)this.b.findViewById(2131444692));
    this.f.addTextChangedListener(this);
    localObject = this.f;
    ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
    localObject = (TextView)this.b.findViewById(2131447463);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("添加好友");
    ((TextView)localObject).setText(localStringBuilder.toString());
    paramString2 = (TextView)this.b.findViewById(2131439109);
    this.g = ((TextView)this.b.findViewById(2131450228));
    if (TextUtils.isEmpty(paramString1)) {
      paramString2.setVisibility(8);
    } else {
      paramString2.setText(paramString1);
    }
    paramString1 = this.c;
    if (paramString1 != null)
    {
      paramString1 = ((IGameMsgManagerService)paramString1.getRuntimeService(IGameMsgManagerService.class, "")).getFriVerifyMsg(this.i);
      if (!TextUtils.isEmpty(paramString1))
      {
        this.f.setText(paramString1);
        paramString2 = new StringBuilder();
        paramString2.append("appId:");
        paramString2.append(this.i);
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
  
  public void a(int paramInt, AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramAppInterface = new GameMsgAddFriendDialog(paramInt, paramAppInterface, paramActivity, LayoutInflater.from(paramActivity).inflate(2131624886, null), -1, CommUtils.a(460.0F, paramActivity.getResources()), paramString3, paramString4, paramString5);
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
    this.f.removeTextChangedListener(this);
    localTranslateAnimation.setAnimationListener(new GameMsgAddFriendDialog.2(this));
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2131430806)
    {
      dismiss();
    }
    else if ((k == 2131427797) && (this.c != null) && (this.f != null))
    {
      CommUtils.a(this.a);
      String str1 = this.f.getText().toString();
      String str2 = ((IGameMsgHandlerNameApi)QRoute.api(IGameMsgHandlerNameApi.class)).getGameMsgHandlerName();
      ((GameCenterUnissoHandler)this.c.getBusinessHandler(str2)).a(this.j, 1, this.e, this.d, str1);
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
    TextView localTextView = this.g;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
    paramCharSequence = this.h;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.GameMsgAddFriendDialog
 * JD-Core Version:    0.7.0.1
 */