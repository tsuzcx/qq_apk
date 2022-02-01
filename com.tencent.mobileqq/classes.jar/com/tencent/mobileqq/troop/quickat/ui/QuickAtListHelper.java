package com.tencent.mobileqq.troop.quickat.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QuickAtListHelper
  implements PopupCardDialog.Listener
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  QuickAtListAdapter jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter;
  boolean jdField_a_of_type_Boolean;
  
  public QuickAtListHelper(QuickAtListAdapter paramQuickAtListAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter = paramQuickAtListAdapter;
    a();
  }
  
  public static ChatHistoryTroopMemberFragment.ATroopMember a()
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = "0";
    localATroopMember.b = HardCodeUtil.a(2131711205);
    localATroopMember.j = HardCodeUtil.a(2131711208);
    localATroopMember.g = HardCodeUtil.a(2131711206);
    localATroopMember.l = ChnToSpell.a(localATroopMember.j, 1);
    localATroopMember.k = ChnToSpell.a(localATroopMember.j, 2);
    return localATroopMember;
  }
  
  public static ArrayList<ChatHistoryTroopMemberFragment.ATroopMember> a(String paramString, List<ChatHistoryTroopMemberFragment.ATroopMember> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.next();
      if ((AtUtil.a(localATroopMember.j, paramString)) || (AtUtil.a(localATroopMember.k, paramString)) || (AtUtil.a(localATroopMember.l, paramString)))
      {
        localATroopMember.v = localATroopMember.j;
        localATroopMember.w = localATroopMember.l;
        localATroopMember.x = localATroopMember.k;
        paramQQAppInterface.add(localATroopMember);
      }
      else if ((AtUtil.a(localATroopMember.m, paramString)) || (AtUtil.a(localATroopMember.n, paramString)) || (AtUtil.a(localATroopMember.o, paramString)))
      {
        localATroopMember.v = localATroopMember.m;
        localATroopMember.w = localATroopMember.o;
        localATroopMember.x = localATroopMember.n;
        paramQQAppInterface.add(localATroopMember);
      }
      else if ((AtUtil.a(localATroopMember.g, paramString)) || (AtUtil.a(localATroopMember.h, paramString)) || (AtUtil.a(localATroopMember.i, paramString)))
      {
        localATroopMember.v = localATroopMember.g;
        localATroopMember.w = localATroopMember.i;
        localATroopMember.x = localATroopMember.h;
        paramQQAppInterface.add(localATroopMember);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (AtUtil.a(localATroopMember.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = AtUtil.c(localATroopMember);
          str2 = AtUtil.d(localATroopMember);
          str3 = AtUtil.e(localATroopMember);
          localATroopMember.v = str1;
          localATroopMember.w = str3;
          localATroopMember.x = str2;
          paramQQAppInterface.add(localATroopMember);
        }
        else if (a(localATroopMember, paramString, paramTroopInfo))
        {
          str1 = AtUtil.c(localATroopMember);
          str2 = AtUtil.d(localATroopMember);
          str3 = AtUtil.e(localATroopMember);
          localATroopMember.v = str1;
          localATroopMember.w = str3;
          localATroopMember.x = str2;
          paramQQAppInterface.add(localATroopMember);
        }
        else if (b(localATroopMember, paramString, paramTroopInfo))
        {
          str1 = AtUtil.c(localATroopMember);
          str2 = AtUtil.d(localATroopMember);
          str3 = AtUtil.e(localATroopMember);
          localATroopMember.v = str1;
          localATroopMember.w = str3;
          localATroopMember.x = str2;
          paramQQAppInterface.add(localATroopMember);
        }
        else if (c(localATroopMember, paramString, paramTroopInfo))
        {
          str1 = AtUtil.c(localATroopMember);
          str2 = AtUtil.d(localATroopMember);
          str3 = AtUtil.e(localATroopMember);
          localATroopMember.v = str1;
          localATroopMember.w = str3;
          localATroopMember.x = str2;
          paramQQAppInterface.add(localATroopMember);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<ChatHistoryTroopMemberFragment.ATroopMember> a(QQAppInterface paramQQAppInterface, List<ChatHistoryTroopMemberFragment.ATroopMember> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (TroopRobotManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.next();
      if (!paramQQAppInterface.b(localATroopMember.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localATroopMember);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramATroopMember != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramATroopMember.jdField_a_of_type_JavaLangString))
        {
          localATroopMember.b = HardCodeUtil.a(2131711207);
          localATroopMember.j = HardCodeUtil.a(2131711203);
          localATroopMember.l = ChnToSpell.a(localATroopMember.j, 1);
          localATroopMember.k = ChnToSpell.a(localATroopMember.j, 2);
          if ((!AtUtil.a(localATroopMember.j, paramString)) && (!AtUtil.a(localATroopMember.k, paramString)))
          {
            bool1 = bool2;
            if (!AtUtil.a(localATroopMember.l, paramString)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if ("all".equalsIgnoreCase(paramString)) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = AtUtil.c(paramATroopMember);
      str2 = AtUtil.d(paramATroopMember);
      paramATroopMember = AtUtil.e(paramATroopMember);
    } while ((AtUtil.a(str1, paramString)) || (AtUtil.a(str2, paramString)) || (AtUtil.a(paramATroopMember, paramString)));
    return false;
  }
  
  private static boolean b(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramATroopMember != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramATroopMember.jdField_a_of_type_JavaLangString))
        {
          localATroopMember.b = HardCodeUtil.a(2131711199);
          localATroopMember.j = HardCodeUtil.a(2131711202);
          localATroopMember.l = ChnToSpell.a(localATroopMember.j, 1);
          localATroopMember.k = ChnToSpell.a(localATroopMember.j, 2);
          if ((!AtUtil.a(localATroopMember.j, paramString)) && (!AtUtil.a(localATroopMember.k, paramString)))
          {
            bool1 = bool2;
            if (!AtUtil.a(localATroopMember.l, paramString)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean c(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new ChatHistoryTroopMemberFragment.ATroopMember();
    boolean bool1 = bool2;
    if (paramATroopMember != null)
    {
      bool1 = bool2;
      if (paramATroopMember.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = HardCodeUtil.a(2131711200);
        paramTroopInfo.j = HardCodeUtil.a(2131711204);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!AtUtil.a(paramTroopInfo.j, paramString)) && (!AtUtil.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!AtUtil.a(paramTroopInfo.l, paramString)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  void a()
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842654);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidGraphicsBitmap = QQAppInterface.getRoundFaceBitmap(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131694391);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener.a();
        }
        if (!this.jdField_a_of_type_Boolean) {
          bool = true;
        }
        this.jdField_a_of_type_Boolean = bool;
      }
    }
    else
    {
      return;
    }
    paramView.setText(2131692534);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.b) {
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener.a(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.jdField_a_of_type_JavaLangString, true);
    }
  }
  
  void a(ImageView paramImageView)
  {
    if (paramImageView != null) {
      paramImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    QQToast.a(BaseApplicationImpl.context, 0, HardCodeUtil.a(2131711201), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.QuickAtListHelper
 * JD-Core Version:    0.7.0.1
 */