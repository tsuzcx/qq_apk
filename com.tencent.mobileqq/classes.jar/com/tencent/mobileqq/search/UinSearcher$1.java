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
import pb.unite.search.DynamicTabSearch.SubHotWord;

class UinSearcher$1
  extends UnifySearchObserver
{
  UinSearcher$1(UinSearcher paramUinSearcher) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    paramString2 = (QQAppInterface)UinSearcher.a(this.a).get();
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (UinSearcher.a(this.a) != null)
      {
        UinSearcher.a(this.a).dismiss();
        UinSearcher.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(UinSearcher.a(this.a), paramArrayOfLong)) || (!paramString1.equals(UinSearcher.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + UinSearcher.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString3)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString3, new Object[0]);
      }
      QQToast.a(BaseApplicationImpl.context, 0, 2131720356, 0).a();
      ReportController.b(paramString2, "dc00898", "", "", "0X800B0C0", "0X800B0C0", UinSearcher.a(UinSearcher.a(this.a)), 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ISearchResultGroupModel> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    if (!TextUtils.equals(paramString2, UinSearcher.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + UinSearcher.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + UinSearcher.b(this.a) + " isEnd1=" + paramBoolean2);
    }
    label805:
    label843:
    label874:
    label1018:
    do
    {
      return;
      paramString3 = (Context)UinSearcher.b(this.a).get();
      paramList1 = (QQAppInterface)UinSearcher.a(this.a).get();
      try
      {
        if (UinSearcher.a(this.a) != null)
        {
          UinSearcher.a(this.a).dismiss();
          UinSearcher.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + UinSearcher.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + UinSearcher.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(UinSearcher.a(this.a), paramArrayOfLong)) || (!paramString1.equals(UinSearcher.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + UinSearcher.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
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
          localActionSheet.setMainTitle(String.format(paramString3.getString(2131694586), new Object[] { UinSearcher.a(this.a) }));
          localActionSheet.addButton(2131691372, 1, 2131362366);
          localActionSheet.addButton(2131692258, 1, 2131362367);
          localActionSheet.addButton(2131691678, 1, 2131362365);
          localActionSheet.addButton(2131689612, 1, 2131362363);
          if ((!UinSearcher.a(this.a).isSend()) && (!UinSearcher.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(UinSearcher.a(this.a).senderuin))) {
            localActionSheet.addButton(2131689621, 1, 2131362364);
          }
          localActionSheet.addCancelButton(2131690800);
          localActionSheet.setOnButtonClickListener(local1);
          localActionSheet.setOnDismissListener(local2);
          localActionSheet.show();
          ReportController.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a(paramList1, UinSearcher.a(this.a), UinSearcher.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = SearchUtil.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (IModel)paramArrayOfByte.next();
          if ((paramList instanceof GroupBaseNetSearchModelItem)) {
            if (((GroupBaseNetSearchModelItem)paramList).d() == 1001) {
              paramArrayOfLong[0] = ((GroupBaseNetSearchModelItem)paramList);
            } else if (((GroupBaseNetSearchModelItem)paramList).d() == 1002) {
              paramString4[0] = ((GroupBaseNetSearchModelItem)paramList);
            } else if (((GroupBaseNetSearchModelItem)paramList).d() == 8001) {
              arrayOfGroupBaseNetSearchModelItem[0] = ((GroupBaseNetSearchModelItem)paramList);
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder().append("search result: person is null=");
          if (paramArrayOfLong[0] == null)
          {
            paramBoolean1 = true;
            paramArrayOfByte = paramArrayOfByte.append(paramBoolean1).append(", troop is null=");
            if (paramString4[0] != null) {
              break label1357;
            }
            paramBoolean1 = true;
            QLog.d("UinSearcher", 2, paramBoolean1);
          }
        }
        else
        {
          paramArrayOfByte = this.a;
          if (paramArrayOfLong[0] != null) {
            break label1368;
          }
          if (paramString4[0] != null) {
            break label1362;
          }
          paramInt = 4;
          UinSearcher.a(paramArrayOfByte, paramInt);
          paramInt = 2131694586;
          if (paramString4[0] == null) {
            break label1395;
          }
          if (paramArrayOfLong[0] != null) {
            break label1387;
          }
          paramInt = 2131720290;
          localActionSheet.setMainTitle(String.format(paramString3.getString(paramInt), new Object[] { paramString1 }));
          localActionSheet.addButton(2131691372, 1, 2131362366);
          localActionSheet.addButton(2131692258, 1, 2131362367);
          localActionSheet.addButton(2131691678, 1, 2131362365);
          localActionSheet.addButton(2131689612, 1, 2131362363);
          if ((arrayOfGroupBaseNetSearchModelItem[0] != null) && (!TextUtils.isEmpty(arrayOfGroupBaseNetSearchModelItem[0].n)))
          {
            if (!TextUtils.isEmpty(arrayOfGroupBaseNetSearchModelItem[0].m)) {
              break label1410;
            }
            localActionSheet.addButton(paramString3.getString(2131694835) + "\n" + arrayOfGroupBaseNetSearchModelItem[0].n, 65537, 2131362371);
          }
          if ((!UinSearcher.a(this.a).isSend()) && (!UinSearcher.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(UinSearcher.a(this.a).senderuin))) {
            localActionSheet.addButton(2131689621, 1, 2131362364);
          }
          paramList = (UinSearchConfProcessor.UinSearchConfigBean)QConfigManager.a().a(589);
          if (paramArrayOfLong[0] != null)
          {
            if (paramString2.b(paramString1)) {
              break label1489;
            }
            if ((TextUtils.isEmpty(paramArrayOfLong[0].c)) || (!paramList.a())) {
              break label1474;
            }
            localActionSheet.addButton(paramString3.getString(2131689577) + "\n" + paramArrayOfLong[0].c, 65537, 2131362362);
          }
          if (paramString4[0] != null)
          {
            if (((TroopManager)paramList1.getManager(QQManagerFactory.TROOP_MANAGER)).m(paramString1)) {
              break label1609;
            }
            if ((TextUtils.isEmpty(paramString4[0].c)) || (!paramList.a())) {
              break label1594;
            }
            localActionSheet.addButton(paramString3.getString(2131693553) + "\n" + paramString4[0].c, 65537, 2131362368);
          }
        }
        for (;;)
        {
          localActionSheet.addCancelButton(2131690800);
          localActionSheet.setOnButtonClickListener(local1);
          localActionSheet.setOnDismissListener(local2);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1696;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localActionSheet, paramArrayOfLong, paramString4, paramList, paramList1, arrayOfGroupBaseNetSearchModelItem));
            return;
          }
          catch (RuntimeException paramString1)
          {
            QLog.e("UinSearcher", 1, paramString1, new Object[0]);
            return;
          }
          paramBoolean1 = false;
          break;
          paramBoolean1 = false;
          break label805;
          paramInt = 2;
          break label843;
          if (paramString4[0] == null)
          {
            paramInt = 1;
            break label843;
          }
          paramInt = 3;
          break label843;
          paramInt = 2131694585;
          break label874;
          if (paramArrayOfLong[0] == null) {
            break label874;
          }
          paramInt = 2131694585;
          break label874;
          localActionSheet.addButton(paramString3.getString(2131694835) + "\n" + arrayOfGroupBaseNetSearchModelItem[0].n, 65537, 2131362371, Integer.valueOf(Color.parseColor(arrayOfGroupBaseNetSearchModelItem[0].m)));
          break label1018;
          localActionSheet.addButton(2131689577, 1, 2131362362);
          break label1177;
          paramString2 = null;
          if (paramList.a())
          {
            paramArrayOfByte = ContactUtils.c(paramList1, paramString1, false);
            paramString2 = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              paramString2 = paramArrayOfLong[0].c;
            }
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localActionSheet.addButton(paramString3.getString(2131694669) + "\n" + paramString2, 65537, 2131362369);
            break label1177;
          }
          localActionSheet.addButton(2131694669, 1, 2131362369);
          break label1177;
          localActionSheet.addButton(2131693553, 1, 2131362368);
          continue;
          if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a())) {
            localActionSheet.addButton(paramString3.getString(2131694687) + "\n" + paramString4[0].c, 65537, 2131362370);
          } else {
            localActionSheet.addButton(2131694687, 1, 2131362370);
          }
        }
      }
    } while (UinSearcher.a(this.a) == null);
    label1177:
    label1357:
    label1362:
    label1368:
    label1387:
    label1395:
    UinSearcher.a(this.a).dismiss();
    label1410:
    label1474:
    label1489:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1
 * JD-Core Version:    0.7.0.1
 */