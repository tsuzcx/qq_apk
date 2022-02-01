package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import cooperation.qzone.mobilereport.MobileReportManager;

public class TextHeaderView
  extends RelativeLayout
  implements IHeaderView
{
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public TextHeaderView(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(0);
  }
  
  private void a(Activity paramActivity, int paramInt, QQVipMsgInfo paramQQVipMsgInfo)
  {
    if (!TextUtils.isEmpty(this.c))
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", this.c);
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", paramInt + 1 + "", "", "1", 102, 1);
      try
      {
        QQVipHelper.a(118, paramQQVipMsgInfo, paramInt);
        return;
      }
      catch (Throwable paramActivity)
      {
        paramActivity.printStackTrace();
      }
      QQVipHelper.a(paramActivity);
    }
  }
  
  public void a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramQQVipMsgInfo.title;
    this.jdField_b_of_type_JavaLangString = paramQQVipMsgInfo.contentText;
    this.c = paramQQVipMsgInfo.url;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131562014, this, false));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379432));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379091));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371065);
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/background_android@2x.png");
    this.jdField_a_of_type_AndroidViewView.setBackground(localURLDrawable);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365710).setOnClickListener(new TextHeaderView.1(this, paramActivity, paramInt, paramQQVipMsgInfo));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new TextHeaderView.2(this, paramActivity, paramInt, paramQQVipMsgInfo));
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    try
    {
      QQVipHelper.a(117, paramQQVipMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramQQVipMsgInfo)
    {
      paramQQVipMsgInfo.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.TextHeaderView
 * JD-Core Version:    0.7.0.1
 */