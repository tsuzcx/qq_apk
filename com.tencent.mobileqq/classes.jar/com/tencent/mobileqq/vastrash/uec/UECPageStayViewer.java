package com.tencent.mobileqq.vastrash.uec;

import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class UECPageStayViewer
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private UECPageStayViewer.TableQueryAdapter jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer$TableQueryAdapter;
  private UECPageStayViewer jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer;
  private ArrayList<QQStayTimeInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private Button b;
  
  public UECPageStayViewer(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131561502, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131378249));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368179));
    this.b = ((Button)findViewById(2131364665));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365894));
    this.jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer$TableQueryAdapter = new UECPageStayViewer.TableQueryAdapter(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer$TableQueryAdapter);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer = this;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new UECPageStayViewer.1(this));
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new UECPageStayViewer.2(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer$TableQueryAdapter.notifyDataSetChanged();
  }
  
  public void a(ArrayList<QQStayTimeInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QQStayTimeInfo localQQStayTimeInfo = (QQStayTimeInfo)paramArrayList.next();
      this.jdField_a_of_type_JavaUtilArrayList.add(0, localQQStayTimeInfo);
    }
    b();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364665)
    {
      if (i == 2131368179) {
        UECPageStayController.a().a();
      }
    }
    else {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayViewer
 * JD-Core Version:    0.7.0.1
 */