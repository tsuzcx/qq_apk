package com.tencent.mobileqq.nearby.gameroom;

import aikq;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import anzj;
import axxo;
import axxp;
import bitz;
import biuo;
import biup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public aikq a;
  public biup a;
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
    ((axxp)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aikq paramaikq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aikq = paramaikq;
    this.jdField_a_of_type_Biup = ((bitz)paramQQAppInterface.a(107)).a(this.jdField_a_of_type_JavaLangString);
    paramQQAppInterface = this.jdField_a_of_type_Biup.a();
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
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131367394));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new axxo(this));
      paramQQAppInterface = new axxp(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label131:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(anzj.a(2131703949));
      this.jdField_a_of_type_JavaUtilArrayList.add(anzj.a(2131703950));
      this.jdField_a_of_type_JavaUtilArrayList.add(anzj.a(2131703953));
      this.jdField_a_of_type_JavaUtilArrayList.add(anzj.a(2131703952));
      this.jdField_a_of_type_JavaUtilArrayList.add(anzj.a(2131703951));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */