package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class HotChatAnnounceDialog
  extends QQCustomDialog
  implements View.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  
  public HotChatAnnounceDialog(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, 2131755842);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561276, null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379487);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379496));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365328));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364824));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697627));
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setCancelable(true);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = ((int)(((DisplayMetrics)localObject).widthPixels - DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 30.0F)));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).gravity = 48;
    ((WindowManager.LayoutParams)localObject).y = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F) + AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
      Object localObject = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString);
      if (localObject != null)
      {
        ((JumpAction)localObject).a();
      }
      else
      {
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HotChatAnnounceDialog
 * JD-Core Version:    0.7.0.1
 */