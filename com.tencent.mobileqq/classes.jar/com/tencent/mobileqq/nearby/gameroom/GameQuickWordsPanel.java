package com.tencent.mobileqq.nearby.gameroom;

import aepe;
import ajya;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import atce;
import atcf;
import bciq;
import bcjf;
import bcjg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public aepe a;
  public bcjg a;
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
    ((atcf)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aepe paramaepe)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aepe = paramaepe;
    this.jdField_a_of_type_Bcjg = ((bciq)paramQQAppInterface.a(107)).a(this.jdField_a_of_type_JavaLangString);
    paramQQAppInterface = this.jdField_a_of_type_Bcjg.a();
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
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131366932));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new atce(this));
      paramQQAppInterface = new atcf(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label131:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(ajya.a(2131705062));
      this.jdField_a_of_type_JavaUtilArrayList.add(ajya.a(2131705063));
      this.jdField_a_of_type_JavaUtilArrayList.add(ajya.a(2131705066));
      this.jdField_a_of_type_JavaUtilArrayList.add(ajya.a(2131705065));
      this.jdField_a_of_type_JavaUtilArrayList.add(ajya.a(2131705064));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */