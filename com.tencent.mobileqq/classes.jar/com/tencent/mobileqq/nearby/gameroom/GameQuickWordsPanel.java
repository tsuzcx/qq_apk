package com.tencent.mobileqq.nearby.gameroom;

import aeeh;
import ajjy;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import asfy;
import asfz;
import bbfc;
import bbfr;
import bbfs;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public aeeh a;
  public bbfs a;
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
    ((asfz)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aeeh paramaeeh)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aeeh = paramaeeh;
    this.jdField_a_of_type_Bbfs = ((bbfc)paramQQAppInterface.a(107)).a(this.jdField_a_of_type_JavaLangString);
    paramQQAppInterface = this.jdField_a_of_type_Bbfs.a();
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
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131301322));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new asfy(this));
      paramQQAppInterface = new asfz(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label131:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(ajjy.a(2131639266));
      this.jdField_a_of_type_JavaUtilArrayList.add(ajjy.a(2131639267));
      this.jdField_a_of_type_JavaUtilArrayList.add(ajjy.a(2131639270));
      this.jdField_a_of_type_JavaUtilArrayList.add(ajjy.a(2131639269));
      this.jdField_a_of_type_JavaUtilArrayList.add(ajjy.a(2131639268));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */