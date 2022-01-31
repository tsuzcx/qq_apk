package com.tencent.mobileqq.nearby.gameroom;

import agqq;
import alud;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import auxm;
import auxn;
import bema;
import bemp;
import bemq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public agqq a;
  public bemq a;
  public SessionInfo a;
  public QQAppInterface a;
  XListView a;
  public String a;
  public ArrayList<String> a;
  
  public GameQuickWordsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  public void a()
  {
    ((auxn)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, agqq paramagqq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Agqq = paramagqq;
    this.jdField_a_of_type_Bemq = ((bema)paramQQAppInterface.a(107)).a(this.jdField_a_of_type_JavaLangString);
    paramQQAppInterface = this.jdField_a_of_type_Bemq.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0)) {
        break label131;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramQQAppInterface;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131367060));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new auxm(this));
      paramQQAppInterface = new auxn(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label131:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(alud.a(2131705446));
      this.jdField_a_of_type_JavaUtilArrayList.add(alud.a(2131705447));
      this.jdField_a_of_type_JavaUtilArrayList.add(alud.a(2131705450));
      this.jdField_a_of_type_JavaUtilArrayList.add(alud.a(2131705449));
      this.jdField_a_of_type_JavaUtilArrayList.add(alud.a(2131705448));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */