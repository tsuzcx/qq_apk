package com.tencent.mobileqq.nearby.gameroom;

import aiav;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import anvx;
import axqy;
import axqz;
import bikt;
import bili;
import bilj;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public aiav a;
  public bilj a;
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
    ((axqz)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aiav paramaiav)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.curFriendUin;
    this.jdField_a_of_type_Aiav = paramaiav;
    this.jdField_a_of_type_Bilj = ((bikt)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(this.jdField_a_of_type_JavaLangString);
    paramQQAppInterface = this.jdField_a_of_type_Bilj.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0)) {
        break label132;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramQQAppInterface;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131367553));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new axqy(this));
      paramQQAppInterface = new axqz(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label132:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(anvx.a(2131704529));
      this.jdField_a_of_type_JavaUtilArrayList.add(anvx.a(2131704530));
      this.jdField_a_of_type_JavaUtilArrayList.add(anvx.a(2131704533));
      this.jdField_a_of_type_JavaUtilArrayList.add(anvx.a(2131704532));
      this.jdField_a_of_type_JavaUtilArrayList.add(anvx.a(2131704531));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */