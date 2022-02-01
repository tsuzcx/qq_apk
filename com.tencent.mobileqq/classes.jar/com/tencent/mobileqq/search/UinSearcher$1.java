package com.tencent.mobileqq.search;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.search.UinSearchConfProcessor.UinSearchConfigBean;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import tencent.im.oidb.search.DynamicTabSearch.SubHotWord;

class UinSearcher$1
  extends UnifySearchObserver
{
  UinSearcher$1(UinSearcher paramUinSearcher) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    paramString2 = (QQAppInterface)UinSearcher.a(this.a).get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unify handleTabSearchError.  resultCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg=");
      localStringBuilder.append(paramString3);
      QLog.d("UinSearcher", 2, localStringBuilder.toString());
    }
    try
    {
      if (UinSearcher.b(this.a) != null)
      {
        UinSearcher.b(this.a).dismiss();
        UinSearcher.c(this.a);
      }
    }
    catch (RuntimeException paramString3)
    {
      QLog.e("UinSearcher", 1, paramString3, new Object[0]);
    }
    if ((ActiveEntitySearchFragment.a(UinSearcher.d(this.a), paramArrayOfLong)) && (paramString1.equals(UinSearcher.e(this.a))))
    {
      QQToast.makeText(BaseApplicationImpl.context, 0, 2131917720, 0).show();
      ReportController.b(paramString2, "dc00898", "", "", "0X800B0C0", "0X800B0C0", UinSearcher.a(UinSearcher.f(this.a)), 0, "", "", "", "");
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("Unify handleTabSearchError.  reqKeyword=");
    paramString2.append(paramString1);
    paramString2.append(" keyword=");
    paramString2.append(UinSearcher.e(this.a));
    QLog.d("UinSearcher", 2, paramString2.toString());
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ISearchResultGroupModel> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    if (!TextUtils.equals(paramString2, UinSearcher.g(this.a)))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unify handleTabSearchResult. reqKeyword=");
      paramArrayOfByte.append(paramString1);
      paramArrayOfByte.append(" keyword=");
      paramArrayOfByte.append(UinSearcher.e(this.a));
      paramArrayOfByte.append(" reqTime=");
      paramArrayOfByte.append(paramString2);
      paramArrayOfByte.append(" lastReqTime=");
      paramArrayOfByte.append(UinSearcher.g(this.a));
      paramArrayOfByte.append(" isEnd1=");
      paramArrayOfByte.append(paramBoolean2);
      QLog.d("UinSearcher", 2, paramArrayOfByte.toString());
      return;
    }
    paramString3 = (Context)UinSearcher.h(this.a).get();
    paramList1 = (QQAppInterface)UinSearcher.a(this.a).get();
    try
    {
      if (UinSearcher.b(this.a) != null)
      {
        UinSearcher.b(this.a).dismiss();
        UinSearcher.c(this.a);
      }
    }
    catch (RuntimeException paramArrayOfByte)
    {
      QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
    }
    if ((paramString3 != null) && (paramList1 != null))
    {
      if ((ActiveEntitySearchFragment.a(UinSearcher.d(this.a), paramArrayOfLong)) && (paramString1.equals(UinSearcher.e(this.a))))
      {
        paramArrayOfLong = new GroupBaseNetSearchModelItem[1];
        paramString4 = new GroupBaseNetSearchModelItem[1];
        GroupBaseNetSearchModelItem[] arrayOfGroupBaseNetSearchModelItem = new GroupBaseNetSearchModelItem[1];
        UinSearcher.a(this.a, 4);
        ActionSheet localActionSheet = ActionSheet.create(paramString3);
        UinSearcher.1.1 local1 = new UinSearcher.1.1(this, paramString3, paramString1, paramList1, paramArrayOfLong, paramString4, arrayOfGroupBaseNetSearchModelItem, localActionSheet);
        UinSearcher.1.2 local2 = new UinSearcher.1.2(this, paramList1);
        paramString2 = (FriendsManager)paramList1.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          localActionSheet.setMainTitle(String.format(paramString3.getString(2131892238), new Object[] { UinSearcher.e(this.a) }));
          localActionSheet.addButton(2131888244, 1, 2131427922);
          localActionSheet.addButton(2131889171, 1, 2131427923);
          localActionSheet.addButton(2131888562, 1, 2131427921);
          localActionSheet.addButton(2131886255, 1, 2131427919);
          if ((!UinSearcher.j(this.a).isSend()) && (!UinSearcher.j(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.n(UinSearcher.j(this.a).senderuin))) {
            localActionSheet.addButton(2131886264, 1, 2131427920);
          }
          localActionSheet.addCancelButton(2131887648);
          localActionSheet.setOnButtonClickListener(local1);
          localActionSheet.setOnDismissListener(local2);
          localActionSheet.show();
          ReportController.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a(paramList1, UinSearcher.f(this.a), UinSearcher.l(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = SearchUtil.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (IModel)paramArrayOfByte.next();
          if ((paramList instanceof GroupBaseNetSearchModelItem))
          {
            paramList = (GroupBaseNetSearchModelItem)paramList;
            if (paramList.j() == 1001) {
              paramArrayOfLong[0] = paramList;
            } else if (paramList.j() == 1002) {
              paramString4[0] = paramList;
            } else if (paramList.j() == 8001) {
              arrayOfGroupBaseNetSearchModelItem[0] = paramList;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("search result: person is null=");
          if (paramArrayOfLong[0] == null) {
            paramBoolean1 = true;
          } else {
            paramBoolean1 = false;
          }
          paramArrayOfByte.append(paramBoolean1);
          paramArrayOfByte.append(", troop is null=");
          if (paramString4[0] == null) {
            paramBoolean1 = true;
          } else {
            paramBoolean1 = false;
          }
          paramArrayOfByte.append(paramBoolean1);
          QLog.d("UinSearcher", 2, paramArrayOfByte.toString());
        }
        paramArrayOfByte = this.a;
        if (paramArrayOfLong[0] == null)
        {
          if (paramString4[0] == null) {
            paramInt = 4;
          } else {
            paramInt = 2;
          }
        }
        else if (paramString4[0] == null) {
          paramInt = 1;
        } else {
          paramInt = 3;
        }
        UinSearcher.a(paramArrayOfByte, paramInt);
        if (paramString4[0] != null)
        {
          if (paramArrayOfLong[0] == null)
          {
            paramInt = 2131917650;
            break label841;
          }
        }
        else {
          if (paramArrayOfLong[0] == null) {
            break label837;
          }
        }
        paramInt = 2131892237;
        break label841;
        label837:
        paramInt = 2131892238;
        label841:
        localActionSheet.setMainTitle(String.format(paramString3.getString(paramInt), new Object[] { paramString1 }));
        localActionSheet.addButton(2131888244, 1, 2131427922);
        localActionSheet.addButton(2131889171, 1, 2131427923);
        localActionSheet.addButton(2131888562, 1, 2131427921);
        localActionSheet.addButton(2131886255, 1, 2131427919);
        if ((arrayOfGroupBaseNetSearchModelItem[0] != null) && (!TextUtils.isEmpty(arrayOfGroupBaseNetSearchModelItem[0].E))) {
          if (TextUtils.isEmpty(arrayOfGroupBaseNetSearchModelItem[0].D))
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append(paramString3.getString(2131892525));
            paramArrayOfByte.append("\n");
            paramArrayOfByte.append(arrayOfGroupBaseNetSearchModelItem[0].E);
            localActionSheet.addButton(paramArrayOfByte.toString(), 65537, 2131427927);
          }
          else
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append(paramString3.getString(2131892525));
            paramArrayOfByte.append("\n");
            paramArrayOfByte.append(arrayOfGroupBaseNetSearchModelItem[0].E);
            localActionSheet.addButton(paramArrayOfByte.toString(), 65537, 2131427927, Integer.valueOf(Color.parseColor(arrayOfGroupBaseNetSearchModelItem[0].D)));
          }
        }
        if ((!UinSearcher.j(this.a).isSend()) && (!UinSearcher.j(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.n(UinSearcher.j(this.a).senderuin))) {
          localActionSheet.addButton(2131886264, 1, 2131427920);
        }
        paramList = (UinSearchConfProcessor.UinSearchConfigBean)QConfigManager.b().b(589);
        if (paramArrayOfLong[0] != null) {
          if (!paramString2.n(paramString1))
          {
            if ((!TextUtils.isEmpty(paramArrayOfLong[0].c)) && (paramList.a()))
            {
              paramString2 = new StringBuilder();
              paramString2.append(paramString3.getString(2131886219));
              paramString2.append("\n");
              paramString2.append(paramArrayOfLong[0].c);
              localActionSheet.addButton(paramString2.toString(), 65537, 2131427918);
            }
            else
            {
              localActionSheet.addButton(2131886219, 1, 2131427918);
            }
          }
          else
          {
            paramString2 = null;
            if (paramList.a())
            {
              paramArrayOfByte = ContactUtils.a(paramList1, paramString1, false);
              paramString2 = paramArrayOfByte;
              if (TextUtils.isEmpty(paramArrayOfByte)) {
                paramString2 = paramArrayOfLong[0].c;
              }
            }
            if (!TextUtils.isEmpty(paramString2))
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append(paramString3.getString(2131892322));
              paramArrayOfByte.append("\n");
              paramArrayOfByte.append(paramString2);
              localActionSheet.addButton(paramArrayOfByte.toString(), 65537, 2131427925);
            }
            else
            {
              localActionSheet.addButton(2131892322, 1, 2131427925);
            }
          }
        }
        if (paramString4[0] != null) {
          if (!((TroopManager)paramList1.getManager(QQManagerFactory.TROOP_MANAGER)).Y(paramString1))
          {
            if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a()))
            {
              paramString1 = new StringBuilder();
              paramString1.append(paramString3.getString(2131891062));
              paramString1.append("\n");
              paramString1.append(paramString4[0].c);
              localActionSheet.addButton(paramString1.toString(), 65537, 2131427924);
            }
            else
            {
              localActionSheet.addButton(2131891062, 1, 2131427924);
            }
          }
          else if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a()))
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramString3.getString(2131892348));
            paramString1.append("\n");
            paramString1.append(paramString4[0].c);
            localActionSheet.addButton(paramString1.toString(), 65537, 2131427926);
          }
          else
          {
            localActionSheet.addButton(2131892348, 1, 2131427926);
          }
        }
        localActionSheet.addCancelButton(2131887648);
        localActionSheet.setOnButtonClickListener(local1);
        localActionSheet.setOnDismissListener(local2);
        try
        {
          if (((paramString3 instanceof Activity)) && (!((Activity)paramString3).isFinishing()))
          {
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localActionSheet, paramArrayOfLong, paramString4, paramList, paramList1, arrayOfGroupBaseNetSearchModelItem));
            return;
          }
          if (UinSearcher.b(this.a) != null)
          {
            UinSearcher.b(this.a).dismiss();
            return;
          }
        }
        catch (RuntimeException paramString1)
        {
          QLog.e("UinSearcher", 1, paramString1, new Object[0]);
        }
        return;
      }
      paramString2 = new StringBuilder();
      paramString2.append("Unify handleTabSearchResult.  reqKeyword=");
      paramString2.append(paramString1);
      paramString2.append(" keyword=");
      paramString2.append(UinSearcher.e(this.a));
      paramString2.append(" isEnd1=");
      paramString2.append(paramBoolean2);
      QLog.d("UinSearcher", 2, paramString2.toString());
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Unify handleTabSearchResult, fragment is detached ..., reqKeyword=");
    paramArrayOfByte.append(paramString1);
    paramArrayOfByte.append(" keyword=");
    paramArrayOfByte.append(UinSearcher.e(this.a));
    paramArrayOfByte.append(" reqTime=");
    paramArrayOfByte.append(paramString2);
    paramArrayOfByte.append(" lastReqTime=");
    paramArrayOfByte.append(UinSearcher.g(this.a));
    paramArrayOfByte.append(" isEnd1=");
    paramArrayOfByte.append(paramBoolean2);
    QLog.e("UinSearcher", 1, paramArrayOfByte.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1
 * JD-Core Version:    0.7.0.1
 */