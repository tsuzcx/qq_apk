package com.tencent.mobileqq.gamecenter.view;

import aekt;
import alpo;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import asjc;
import asjl;
import askb;
import askc;
import askd;
import aske;
import azui;
import azvd;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TextHeaderView
  extends RelativeLayout
  implements asjl
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public TextHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    MessageForStructing localMessageForStructing;
    do
    {
      return;
      localMessageForStructing = (MessageForStructing)paramMessageRecord;
    } while (!(localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare));
    try
    {
      Object localObject1 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
      this.jdField_a_of_type_JavaLangString = ((StructMsgForGeneralShare)localObject1).mMsgUrl;
      Object localObject2 = (azui)((ArrayList)((StructMsgForGeneralShare)localObject1).getStructMsgItemLists()).get(1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      localObject1 = new RelativeLayout.LayoutParams(aekt.a(355.0F, getResources()), -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      Object localObject3 = new RelativeLayout.LayoutParams(-1, aekt.a(293.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = aekt.a(46.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, aekt.a(283.0F, getResources()));
      localLayoutParams.topMargin = aekt.a(46.0F, getResources());
      ((RelativeLayout)localObject3).setPadding(aekt.a(20.0F, getResources()), 0, aekt.a(20.0F, getResources()), 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aekt.a(60.0F, getResources());
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(14);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367034);
      ((RelativeLayout)localObject3).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aekt.a(6.0F, getResources());
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(3, 2131367034);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
      ((RelativeLayout)localObject3).addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
      this.c = new TextView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131367034);
      localLayoutParams.topMargin = aekt.a(56.0F, getResources());
      this.c.setTextColor(-16777216);
      this.c.setTextSize(14.0F);
      ((RelativeLayout)localObject3).addView(this.c, localLayoutParams);
      this.d = new TextView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aekt.a(106.0F, getResources());
      localLayoutParams.addRule(3, 2131367034);
      this.d.setTextSize(14.0F);
      this.d.setTextColor(-7829368);
      ((RelativeLayout)localObject3).addView(this.d, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
      localObject3 = new RelativeLayout.LayoutParams(aekt.a(188.0F, getResources()), aekt.a(51.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = aekt.a(296.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131715236));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839107);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetButton, (ViewGroup.LayoutParams)localObject3);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localObject3 = new RelativeLayout.LayoutParams(aekt.a(92.0F, getResources()), aekt.a(92.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
      localObject3 = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412143112_EarvNaW2y5.png");
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject3);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((azvd)((azui)localObject2).a.get(1)).Y);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((azvd)((azui)localObject2).a.get(0)).Y);
      this.c.setText(((azvd)((azui)localObject2).a.get(2)).Y);
      this.d.setText(((azvd)((azui)localObject2).a.get(3)).Y);
      localObject2 = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190408192858_cRS59qwdjG.png");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(asjc.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new askb(this, paramActivity, paramMessageRecord, localMessageForStructing));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new askc(this, paramActivity, paramMessageRecord, localMessageForStructing));
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject1);
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("TextHeaderView", 2, "textHeader parse error " + paramMessageRecord.toString());
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramQQGameMsgInfo.url;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(aekt.a(355.0F, getResources()), -1);
      localLayoutParams1.addRule(14);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      Object localObject = new RelativeLayout.LayoutParams(-1, aekt.a(293.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).topMargin = aekt.a(46.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, aekt.a(283.0F, getResources()));
      localLayoutParams2.topMargin = aekt.a(46.0F, getResources());
      ((RelativeLayout)localObject).setPadding(aekt.a(20.0F, getResources()), 0, aekt.a(20.0F, getResources()), 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = aekt.a(60.0F, getResources());
      localLayoutParams2.addRule(10);
      localLayoutParams2.addRule(14);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367034);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams2);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = aekt.a(6.0F, getResources());
      localLayoutParams2.addRule(14);
      localLayoutParams2.addRule(3, 2131367034);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
      ((RelativeLayout)localObject).addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams2);
      this.c = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(3, 2131367034);
      localLayoutParams2.topMargin = aekt.a(56.0F, getResources());
      this.c.setTextColor(-16777216);
      this.c.setTextSize(14.0F);
      ((RelativeLayout)localObject).addView(this.c, localLayoutParams2);
      this.d = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = aekt.a(106.0F, getResources());
      localLayoutParams2.addRule(3, 2131367034);
      this.d.setTextSize(14.0F);
      this.d.setTextColor(-7829368);
      ((RelativeLayout)localObject).addView(this.d, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
      localObject = new RelativeLayout.LayoutParams(aekt.a(188.0F, getResources()), aekt.a(51.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).topMargin = aekt.a(296.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131715236));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839107);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetButton, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(aekt.a(92.0F, getResources()), aekt.a(92.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412143112_EarvNaW2y5.png");
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQGameMsgInfo.title);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQGameMsgInfo.dateTitle);
      this.c.setText(paramQQGameMsgInfo.contentText);
      this.d.setText(paramQQGameMsgInfo.limitText);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190408192858_cRS59qwdjG.png");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(asjc.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new askd(this, paramActivity, paramQQGameMsgInfo, paramInt));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aske(this, paramActivity, paramQQGameMsgInfo, paramInt));
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      QLog.e("TextHeaderView", 2, "textHeader parse error " + paramQQGameMsgInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView
 * JD-Core Version:    0.7.0.1
 */