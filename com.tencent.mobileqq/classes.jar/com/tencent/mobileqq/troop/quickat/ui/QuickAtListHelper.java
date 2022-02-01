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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QuickAtListHelper
  implements PopupCardDialog.Listener
{
  QuickAtListAdapter a;
  boolean b;
  private Bitmap c;
  
  public QuickAtListHelper(QuickAtListAdapter paramQuickAtListAdapter)
  {
    this.a = paramQuickAtListAdapter;
    a();
  }
  
  public static ArrayList<ChatHistoryTroopMemberFragment.ATroopMember> a(String paramString, List<ChatHistoryTroopMemberFragment.ATroopMember> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.next();
      if ((!AtUtil.a(localATroopMember.k, paramString)) && (!AtUtil.a(localATroopMember.l, paramString)) && (!AtUtil.a(localATroopMember.m, paramString)))
      {
        if ((!AtUtil.a(localATroopMember.n, paramString)) && (!AtUtil.a(localATroopMember.p, paramString)) && (!AtUtil.a(localATroopMember.q, paramString)))
        {
          if ((!AtUtil.a(localATroopMember.h, paramString)) && (!AtUtil.a(localATroopMember.i, paramString)) && (!AtUtil.a(localATroopMember.j, paramString)))
          {
            String str1;
            String str2;
            String str3;
            if (AtUtil.a(localATroopMember.a, paramString))
            {
              str1 = AtUtil.c(localATroopMember);
              str2 = AtUtil.d(localATroopMember);
              str3 = AtUtil.e(localATroopMember);
              localATroopMember.S = str1;
              localATroopMember.T = str3;
              localATroopMember.U = str2;
              paramQQAppInterface.add(localATroopMember);
            }
            else if (a(localATroopMember, paramString, paramTroopInfo))
            {
              str1 = AtUtil.c(localATroopMember);
              str2 = AtUtil.d(localATroopMember);
              str3 = AtUtil.e(localATroopMember);
              localATroopMember.S = str1;
              localATroopMember.T = str3;
              localATroopMember.U = str2;
              paramQQAppInterface.add(localATroopMember);
            }
            else if (b(localATroopMember, paramString, paramTroopInfo))
            {
              str1 = AtUtil.c(localATroopMember);
              str2 = AtUtil.d(localATroopMember);
              str3 = AtUtil.e(localATroopMember);
              localATroopMember.S = str1;
              localATroopMember.T = str3;
              localATroopMember.U = str2;
              paramQQAppInterface.add(localATroopMember);
            }
            else if (c(localATroopMember, paramString, paramTroopInfo))
            {
              str1 = AtUtil.c(localATroopMember);
              str2 = AtUtil.d(localATroopMember);
              str3 = AtUtil.e(localATroopMember);
              localATroopMember.S = str1;
              localATroopMember.T = str3;
              localATroopMember.U = str2;
              paramQQAppInterface.add(localATroopMember);
            }
          }
          else
          {
            localATroopMember.S = localATroopMember.h;
            localATroopMember.T = localATroopMember.j;
            localATroopMember.U = localATroopMember.i;
            paramQQAppInterface.add(localATroopMember);
          }
        }
        else
        {
          localATroopMember.S = localATroopMember.n;
          localATroopMember.T = localATroopMember.q;
          localATroopMember.U = localATroopMember.p;
          paramQQAppInterface.add(localATroopMember);
        }
      }
      else
      {
        localATroopMember.S = localATroopMember.k;
        localATroopMember.T = localATroopMember.m;
        localATroopMember.U = localATroopMember.l;
        paramQQAppInterface.add(localATroopMember);
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<ChatHistoryTroopMemberFragment.ATroopMember> a(QQAppInterface paramQQAppInterface, List<ChatHistoryTroopMemberFragment.ATroopMember> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.next();
      if (!paramQQAppInterface.isRobotUin(localATroopMember.a)) {
        localArrayList.add(localATroopMember);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember, String paramString, TroopInfo paramTroopInfo)
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    if ((paramTroopInfo != null) && (paramATroopMember != null) && (paramTroopInfo.isTroopOwner(paramATroopMember.a)))
    {
      localATroopMember.c = HardCodeUtil.a(2131908841);
      localATroopMember.k = HardCodeUtil.a(2131908837);
      paramATroopMember = localATroopMember.k;
      boolean bool2 = true;
      localATroopMember.m = ChnToSpell.b(paramATroopMember, 1);
      localATroopMember.l = ChnToSpell.b(localATroopMember.k, 2);
      boolean bool1 = bool2;
      if (!AtUtil.a(localATroopMember.k, paramString))
      {
        bool1 = bool2;
        if (!AtUtil.a(localATroopMember.l, paramString))
        {
          if (AtUtil.a(localATroopMember.m, paramString)) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public static boolean a(String paramString, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if ("all".equalsIgnoreCase(paramString)) {
      return true;
    }
    String str1 = AtUtil.c(paramATroopMember);
    String str2 = AtUtil.d(paramATroopMember);
    paramATroopMember = AtUtil.e(paramATroopMember);
    if (AtUtil.a(str1, paramString)) {
      return true;
    }
    if (AtUtil.a(str2, paramString)) {
      return true;
    }
    return AtUtil.a(paramATroopMember, paramString);
  }
  
  private static boolean b(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember, String paramString, TroopInfo paramTroopInfo)
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    if ((paramTroopInfo != null) && (paramATroopMember != null) && (paramTroopInfo.isTroopAdmin(paramATroopMember.a)))
    {
      localATroopMember.c = HardCodeUtil.a(2131908833);
      localATroopMember.k = HardCodeUtil.a(2131908836);
      paramATroopMember = localATroopMember.k;
      boolean bool2 = true;
      localATroopMember.m = ChnToSpell.b(paramATroopMember, 1);
      localATroopMember.l = ChnToSpell.b(localATroopMember.k, 2);
      boolean bool1 = bool2;
      if (!AtUtil.a(localATroopMember.k, paramString))
      {
        bool1 = bool2;
        if (!AtUtil.a(localATroopMember.l, paramString))
        {
          if (AtUtil.a(localATroopMember.m, paramString)) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    return false;
  }
  
  private static boolean c(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember, String paramString, TroopInfo paramTroopInfo)
  {
    paramTroopInfo = new ChatHistoryTroopMemberFragment.ATroopMember();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramATroopMember != null)
    {
      bool1 = bool2;
      if (paramATroopMember.A)
      {
        paramTroopInfo.c = HardCodeUtil.a(2131908834);
        paramTroopInfo.k = HardCodeUtil.a(2131908838);
        paramTroopInfo.m = ChnToSpell.b(paramTroopInfo.k, 1);
        paramTroopInfo.l = ChnToSpell.b(paramTroopInfo.k, 2);
        if ((!AtUtil.a(paramTroopInfo.k, paramString)) && (!AtUtil.a(paramTroopInfo.l, paramString)))
        {
          bool1 = bool2;
          if (!AtUtil.a(paramTroopInfo.m, paramString)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static ChatHistoryTroopMemberFragment.ATroopMember d()
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    localATroopMember.a = "0";
    localATroopMember.c = HardCodeUtil.a(2131908839);
    localATroopMember.k = HardCodeUtil.a(2131908842);
    localATroopMember.h = HardCodeUtil.a(2131908840);
    localATroopMember.m = ChnToSpell.b(localATroopMember.k, 1);
    localATroopMember.l = ChnToSpell.b(localATroopMember.k, 2);
    return localATroopMember;
  }
  
  void a()
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130843506);
    QQAppInterface localQQAppInterface = this.a.b;
    this.c = QQAppInterface.getRoundFaceBitmap(localBitmap);
  }
  
  public void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.b)
      {
        paramView.setText(2131892030);
        if (this.a.d != null) {
          this.a.d.d();
        }
      }
      else
      {
        paramView.setText(2131889474);
        if (this.a.f) {
          this.a.notifyDataSetChanged();
        } else {
          this.a.d.a(this.a.e, true);
        }
        ReportController.b(this.a.b, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      }
      this.b ^= true;
    }
  }
  
  void a(ImageView paramImageView)
  {
    if (paramImageView != null) {
      paramImageView.setImageBitmap(this.c);
    }
  }
  
  void b()
  {
    QQToast.makeText(BaseApplicationImpl.context, 0, HardCodeUtil.a(2131908835), 0).show();
  }
  
  boolean c()
  {
    return this.a.c.size() >= 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.QuickAtListHelper
 * JD-Core Version:    0.7.0.1
 */