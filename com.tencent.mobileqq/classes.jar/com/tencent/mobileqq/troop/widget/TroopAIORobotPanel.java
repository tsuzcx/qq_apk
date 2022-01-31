package com.tencent.mobileqq.troop.widget;

import ajev;
import ajew;
import ajex;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.OnTalkingChangeListener;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.mobileqq.widget.DraggableGridView.OnGridItemClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopAIORobotPanel
  extends DraggableGridView
  implements TroopRobotManager.OnTalkingChangeListener, DraggableGridView.OnGridItemClickListener
{
  protected BaseTroopChatPie a;
  public TroopAIORobotPanel.DataListAdapter a;
  public String a;
  public ArrayList a;
  public String b;
  public String c;
  
  public TroopAIORobotPanel(Context paramContext)
  {
    super(paramContext);
    paramContext = a();
    if (paramContext != null) {
      paramContext.a(this);
    }
    for (;;)
    {
      setBackgroundColor(-1);
      setVerticalScrollBarEnabled(false);
      setOnGridItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$DataListAdapter = new TroopAIORobotPanel.DataListAdapter(this);
      setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$DataListAdapter);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotPanel", 2, "troopRobotManager = null");
      }
    }
  }
  
  public TroopRobotManager a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (TroopRobotManager)((QQAppInterface)localAppRuntime).getManager(202);
    }
    return null;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$DataListAdapter.c();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    TroopRobotManager localTroopRobotManager = a();
    if (localTroopRobotManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotPanel", 2, "troopRobotManager = null");
      }
      return;
    }
    TroopAIORobotPanel.RobotPanelItemData localRobotPanelItemData = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$DataListAdapter.a(paramInt1, paramInt2);
    Object localObject1 = localRobotPanelItemData.a.jdField_a_of_type_JavaLangString;
    int i;
    if (!TextUtils.isEmpty(localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString)) {
      if (localRobotPanelItemData.jdField_b_of_type_Boolean)
      {
        localRobotPanelItemData.jdField_b_of_type_Boolean = false;
        localTroopRobotManager.a();
        i = localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$RobotPanelItemInfoData.c.indexOf("content=");
        if (i <= 0) {
          break label913;
        }
      }
    }
    label901:
    label906:
    label913:
    for (localObject1 = localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$RobotPanelItemInfoData.c.substring(i + 8);; localObject1 = "")
    {
      Object localObject2 = localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString;
      TroopRobotManager.a("panel", "talk_out", this.jdField_a_of_type_JavaLangString, this.b, "1", "");
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      try
      {
        localTroopRobotManager.b(Long.parseLong(this.jdField_a_of_type_JavaLangString), localObject3, new ajew(this, localRobotPanelItemData));
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$DataListAdapter.a(paramView, paramInt1, paramInt2);
        paramView = (View)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopAIORobotPanel", 2, "talking: " + localRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
          paramView = (View)localObject1;
        }
        for (;;)
        {
          TroopRobotManager.a("panel", "clk", this.jdField_a_of_type_JavaLangString, this.b, paramView, "");
          return;
          localRobotPanelItemData.jdField_b_of_type_Boolean = true;
          localTroopRobotManager.a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
          i = localRobotPanelItemData.a.c.indexOf("content=");
          if (i <= 0) {
            break label906;
          }
          localObject2 = localRobotPanelItemData.a.c.substring(i + 8);
          TroopRobotManager.a("panel", "talk_in", this.jdField_a_of_type_JavaLangString, this.b, "", "");
          localObject3 = localObject2;
          break;
          if (localRobotPanelItemData.a.c.startsWith("inputKeyOp://sendToRobot"))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.U = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.ak();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.U = false;
            if (!localTroopRobotManager.a())
            {
              paramView = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_JavaLangString, this.b, this.c, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.a(this.b, this.c, true, 0);
            }
            if (QLog.isColorLevel())
            {
              QLog.d("TroopAIORobotPanel", 2, "send to robot: " + localRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
              paramView = (View)localObject1;
            }
          }
          else if (!localRobotPanelItemData.a.c.startsWith("inputKeyOp://sendToBackEnd")) {}
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
            paramInt1 = localRobotPanelItemData.a.c.indexOf("content=");
            if (paramInt1 <= 0) {
              break label901;
            }
            paramView = localRobotPanelItemData.a.c.substring(paramInt1 + 8);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.U = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.F = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.ak();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.U = false;
            if (!localTroopRobotManager.a())
            {
              localObject2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_JavaLangString, this.b, this.c, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.a(this.b, this.c, true, 0);
            }
            localTroopRobotManager.a(l, paramView, new ajex(this, localRobotPanelItemData));
          }
          catch (Exception paramView)
          {
            label786:
            break label786;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("TroopAIORobotPanel", 2, "send to server: " + localRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
            paramView = (View)localObject1;
            continue;
            if (localRobotPanelItemData.a.c.startsWith("http"))
            {
              paramView = new Intent(getContext(), QQBrowserActivity.class);
              paramView.putExtra("url", localRobotPanelItemData.a.c);
              getContext().startActivity(paramView);
            }
          }
          paramView = (View)localObject1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          paramView = null;
          continue;
          String str = "";
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, BaseTroopChatPie paramBaseTroopChatPie, TroopAIORobotPanel.GetListDataCallback paramGetListDataCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie = paramBaseTroopChatPie;
    paramBaseTroopChatPie = a();
    if (paramBaseTroopChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotPanel", 2, "troopRobotManager = null");
      }
      return;
    }
    try
    {
      l = Long.parseLong(paramString1);
      int i = SharedPreUtils.aK(getContext(), paramString1 + "_" + paramString2);
      paramBaseTroopChatPie.a(l, i, new ajev(this, i, paramString2, paramString1, paramString3, paramGetListDataCallback));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotPanel
 * JD-Core Version:    0.7.0.1
 */