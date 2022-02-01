package com.tencent.mobileqq.nearby.gameroom;

import ahgc;
import amtj;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import awkw;
import awkx;
import bhab;
import bhaq;
import bhar;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public ahgc a;
  public bhar a;
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
    ((awkx)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ahgc paramahgc)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.curFriendUin;
    this.jdField_a_of_type_Ahgc = paramahgc;
    this.jdField_a_of_type_Bhar = ((bhab)paramQQAppInterface.getBusinessHandler(107)).a(this.jdField_a_of_type_JavaLangString);
    paramQQAppInterface = this.jdField_a_of_type_Bhar.a();
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
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131367422));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new awkw(this));
      paramQQAppInterface = new awkx(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label131:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(amtj.a(2131704178));
      this.jdField_a_of_type_JavaUtilArrayList.add(amtj.a(2131704179));
      this.jdField_a_of_type_JavaUtilArrayList.add(amtj.a(2131704182));
      this.jdField_a_of_type_JavaUtilArrayList.add(amtj.a(2131704181));
      this.jdField_a_of_type_JavaUtilArrayList.add(amtj.a(2131704180));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */