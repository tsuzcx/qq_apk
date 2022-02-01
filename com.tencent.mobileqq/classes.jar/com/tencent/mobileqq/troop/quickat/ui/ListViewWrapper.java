package com.tencent.mobileqq.troop.quickat.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.OnIndexBarTouchListener;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipsLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class ListViewWrapper
  implements IndexBar.OnIndexBarTouchListener
{
  public Context a;
  private final View jdField_a_of_type_AndroidViewView;
  public IndexBar a;
  public IndexBarTipsLayout a;
  public QQAppInterface a;
  public QuickAtListAdapter a;
  public XListView a;
  private String jdField_a_of_type_JavaLangString = "";
  
  public ListViewWrapper(QQAppInterface paramQQAppInterface, Context paramContext, TroopChatPie paramTroopChatPie, View paramView, XListView paramXListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter = new QuickAtListAdapter(this, paramTroopChatPie);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout = ((IndexBarTipsLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368762));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar = ((IndexBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368761));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar.setOnIndexBarTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt, float paramFloat)
  {
    IndexBarTipsLayout localIndexBarTipsLayout = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout;
    if (localIndexBarTipsLayout != null) {
      localIndexBarTipsLayout.setText(paramString, paramFloat);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      if ("★".equals(paramString))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
        return;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.a(paramString);
      if (paramInt != -1)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetXListView;
        paramString.setSelection(paramInt + paramString.getHeaderViewsCount());
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("ListViewWrapper", 2, new Object[] { "onLetterTouching: invoked. ", " touching: ", Boolean.valueOf(paramBoolean) });
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    IndexBarTipsLayout localIndexBarTipsLayout = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout;
    if (localIndexBarTipsLayout != null)
    {
      if (!paramBoolean) {
        i = 8;
      }
      localIndexBarTipsLayout.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.ListViewWrapper
 * JD-Core Version:    0.7.0.1
 */