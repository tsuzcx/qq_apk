package com.tencent.mobileqq.emoticonview.relateemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arxd;
import asdi;
import asdn;
import asdr;
import asdt;
import asdu;
import asdv;
import asdw;
import asdx;
import asdy;
import asdz;
import bcst;
import bgtn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class RelatedEmotionPanel
  extends LinearLayout
  implements DialogInterface.OnDismissListener, View.OnClickListener, asdt
{
  protected int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  protected View a;
  private arxd jdField_a_of_type_Arxd;
  private asdn jdField_a_of_type_Asdn;
  private asdr jdField_a_of_type_Asdr;
  private asdz jdField_a_of_type_Asdz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c;
  
  public RelatedEmotionPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public RelatedEmotionPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public RelatedEmotionPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, URLDrawable paramURLDrawable)
  {
    URLImageView localURLImageView = new URLImageView(getContext());
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    Object localObject1 = new LinearLayout.LayoutParams(bgtn.a(80.0F), bgtn.a(80.0F));
    ((LinearLayout.LayoutParams)localObject1).topMargin = bgtn.a(6.0F);
    localLinearLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131378792);
    localTextView.setTextSize(12.0F);
    View localView1;
    View localView2;
    if (bool)
    {
      localObject1 = "#8D8D93";
      localTextView.setTextColor(Color.parseColor((String)localObject1));
      localTextView.setText(getContext().getResources().getString(2131717296));
      localTextView.setGravity(17);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new RelativeLayout(getContext());
      localView1 = new View(getContext());
      localView2 = new View(getContext());
      if (!bool) {
        break label621;
      }
    }
    label621:
    for (localObject1 = "#3D3D41";; localObject1 = "#EBEDF5")
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, bgtn.a(0.5F));
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(0, 2131378792);
      localLayoutParams.leftMargin = bgtn.a(14.0F);
      localLayoutParams.rightMargin = bgtn.a(12.0F);
      localView1.setBackgroundColor(Color.parseColor((String)localObject1));
      localView1.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, bgtn.a(0.5F));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(1, 2131378792);
      localLayoutParams.leftMargin = bgtn.a(12.0F);
      localLayoutParams.rightMargin = bgtn.a(14.0F);
      localView2.setBackgroundColor(Color.parseColor((String)localObject1));
      localView2.setLayoutParams(localLayoutParams);
      ((RelativeLayout)localObject2).addView(localTextView);
      ((RelativeLayout)localObject2).addView(localView1);
      ((RelativeLayout)localObject2).addView(localView2);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = bgtn.a(16.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = bgtn.a(20.0F);
      localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131376267));
      localURLImageView.setImageDrawable(paramURLDrawable);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_Asdn = new asdn(paramQQAppInterface, getContext(), this.jdField_a_of_type_Arxd);
      this.jdField_a_of_type_Asdn.a(this.jdField_a_of_type_JavaLangString, this.c);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Asdn);
      this.jdField_a_of_type_Asdn.a(localLinearLayout, a(), new ArrayList());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new asdy(this));
      this.jdField_a_of_type_Asdr = new asdr(paramQQAppInterface, this);
      this.jdField_a_of_type_Asdr.a(paramChatMessage, this.c);
      return;
      localObject1 = "#878B99";
      break;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RelatedEmotionPanel", 2, "notifyFooterViewChange.");
    }
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368100);
    localTextView1.setTextSize(14.0F);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368099);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370226);
    localTextView2.setTextSize(14.0F);
    localTextView1.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int i = bgtn.a(74.0F);
    if (localLayoutParams.height != i)
    {
      localLayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    if (this.b == 0)
    {
      localView.setVisibility(0);
      localTextView2.setText(2131689852);
      localTextView1.setVisibility(4);
      return;
    }
    if (this.b == 2)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131689857);
      localView.setVisibility(4);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B11B", "0X800B11B", 0, 0, "", "", "", "");
      return;
    }
    if (this.b == 1)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131717298);
      localTextView1.setClickable(false);
      localView.setVisibility(4);
      return;
    }
    if (this.b == 3)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131717297);
      localTextView1.setClickable(false);
      localView.setVisibility(4);
      return;
    }
    localTextView1.setVisibility(8);
    localView.setVisibility(8);
    localLayoutParams.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  protected View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131558611, null);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RecyclerView.LayoutParams(-1, bgtn.a(74.0F)));
    }
    b();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_Asdn == null)) {
      return;
    }
    this.b = 2;
    if ((this.jdField_a_of_type_Asdn.a() == null) || (this.jdField_a_of_type_Asdn.a().isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.e("RelatedEmotionPanel", 4, " first load error " + paramInt);
      }
    }
    for (;;)
    {
      b();
      return;
      if (QLog.isColorLevel()) {
        QLog.e("RelatedEmotionPanel", 4, " load more error " + paramInt);
      }
    }
  }
  
  public void a(asdu paramasdu)
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_Asdn == null) || (paramasdu == null)) {
      return;
    }
    if ((a(this.jdField_a_of_type_Asdn.a())) && (a(paramasdu.jdField_a_of_type_JavaUtilList))) {
      this.b = 3;
    }
    for (;;)
    {
      b();
      return;
      this.b = 1;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramasdu.jdField_a_of_type_JavaUtilList.size())
      {
        asdi localasdi = new asdi((asdv)paramasdu.jdField_a_of_type_JavaUtilList.get(i), paramasdu.jdField_a_of_type_Int);
        localasdi.a(this.jdField_a_of_type_JavaLangString, this.c, i);
        localArrayList.add(localasdi);
        i += 1;
      }
      this.jdField_a_of_type_Asdn.a(localArrayList);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, arxd paramarxd, asdz paramasdz)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Asdz = paramasdz;
    this.jdField_a_of_type_Arxd = paramarxd;
  }
  
  public void a(ChatMessage paramChatMessage, URLDrawable paramURLDrawable, int paramInt)
  {
    if ((!(paramChatMessage instanceof MessageForPic)) && (!(paramChatMessage instanceof MessageForMarketFace))) {}
    while (((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) || (!(getContext() instanceof Activity)) || (((Activity)getContext()).isFinishing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
    this.c = paramChatMessage.istroop;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramURLDrawable);
    paramChatMessage = new RelatedEmoSlideBottomPanel(getContext());
    paramChatMessage.setContentHeight(paramInt);
    paramChatMessage.setContentView(this);
    paramChatMessage.setCallback(new asdw(this));
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getContext(), 2131755173);
    }
    this.jdField_a_of_type_AndroidAppDialog.setContentView(paramChatMessage);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this);
    this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new asdx(this, paramChatMessage));
    paramURLDrawable = this.jdField_a_of_type_AndroidAppDialog.getWindow();
    if (paramURLDrawable != null)
    {
      int i = bgtn.b() - bgtn.a(getContext());
      paramInt = i;
      if (i == 0) {
        paramInt = -1;
      }
      paramURLDrawable.setLayout(-1, paramInt);
      WindowManager.LayoutParams localLayoutParams = paramURLDrawable.getAttributes();
      localLayoutParams.gravity = 80;
      paramURLDrawable.setAttributes(localLayoutParams);
    }
    paramChatMessage.a();
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public <T> boolean a(List<T> paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368100)
    {
      this.b = 0;
      b();
      if (this.jdField_a_of_type_Asdr != null) {
        this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.c);
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B11C", "0X800B11C", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Asdz != null) {
      this.jdField_a_of_type_Asdz.a();
    }
    if (this.jdField_a_of_type_Asdr != null) {
      this.jdField_a_of_type_Asdr.a();
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B11A", "0X800B11A", 2, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = null;
    this.jdField_a_of_type_Asdn = null;
    this.jdField_a_of_type_Asdr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel
 * JD-Core Version:    0.7.0.1
 */