package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import asgk;
import asoh;
import aspa;
import aspy;
import avse;
import bhsr;
import bhtq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;

public class EmoticonHotPicSearchPanelView
  extends RichTextPanelView
{
  private asgk jdField_a_of_type_Asgk;
  private aspa jdField_a_of_type_Aspa;
  private avse jdField_a_of_type_Avse;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private EmotionPanelListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  
  public EmoticonHotPicSearchPanelView(Context paramContext, BaseChatPie paramBaseChatPie, avse paramavse)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Avse = paramavse;
    this.jdField_a_of_type_Asgk = new asgk(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramavse);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = new EmotionPanelListView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setVerticalScrollBarEnabled(false);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    View localView = View.inflate(getContext(), 2131558597, null);
    localRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_Aspa = new aspa(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), 4, 14, 12, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setSelector(2130850683);
    this.jdField_a_of_type_Aspa.d = bhtq.a();
    this.jdField_a_of_type_Aspa.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView);
    this.jdField_a_of_type_Asgk.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, this.jdField_a_of_type_Aspa);
    this.jdField_a_of_type_Asgk.b(localView);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_Aspa);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEnableExtendPanle(true);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setPullAndFastScrollListener(this.jdField_a_of_type_Avse);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setOnScrollListener(new asoh(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, this.jdField_a_of_type_Avse, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.addOnScrollListener(this.jdField_a_of_type_Asgk);
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
      this.jdField_a_of_type_Asgk.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
  }
  
  public String a()
  {
    return getContext().getString(2131689864);
  }
  
  public void a()
  {
    String str2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
    {
      String str1 = this.jdField_a_of_type_Asgk.b();
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((!bhsr.a(str1)) && (str1.equals(str2))) {
        this.jdField_a_of_type_Asgk.b(3);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aspa.a(new ArrayList());
    this.jdField_a_of_type_Asgk.a(str2);
    this.jdField_a_of_type_Asgk.f();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHotPicSearchPanelView", 4, " reportDefaultExposedEvent ");
    }
    this.jdField_a_of_type_Asgk.A();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Asgk.a(paramBoolean);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aspy.a().a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    if ((this.jdField_a_of_type_Aspa != null) && (this.jdField_a_of_type_Aspa.d != paramInt1))
    {
      this.jdField_a_of_type_Aspa.d = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_Aspa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.EmoticonHotPicSearchPanelView
 * JD-Core Version:    0.7.0.1
 */