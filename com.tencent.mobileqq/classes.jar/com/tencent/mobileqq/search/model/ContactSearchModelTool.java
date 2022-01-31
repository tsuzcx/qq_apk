package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.MobileQQ;

public class ContactSearchModelTool
  extends IContactSearchModel
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = IContactSearchable.L;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public ContactSearchModelTool(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    super(paramQQAppInterface, paramInt1, paramLong);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    a();
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 6000: 
    case 9002: 
    case 5000: 
    case 7120: 
    case 7210: 
    case 7230: 
    case 1001: 
    case 10002: 
    case 7000: 
      do
      {
        for (;;)
        {
          if (!TextUtils.isEmpty(this.c))
          {
            this.d = ChnToSpell.a(this.c, 1).toLowerCase();
            this.e = ChnToSpell.a(this.c, 2).toLowerCase();
          }
          return;
          this.c = BaseApplicationImpl.sApplication.getString(2131427485);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131437234);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131435186);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131437935);
          continue;
          this.c = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          continue;
          this.c = ServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131434024);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131434025);
        }
        this.c = BaseApplicationImpl.sApplication.getString(2131436397);
      } while (AppConstants.w.equals(this.jdField_a_of_type_JavaLangString));
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject1 == null) {
        break;
      }
    }
    for (Object localObject1 = ((FriendsManager)localObject1).c(this.jdField_a_of_type_JavaLangString);; localObject1 = null)
    {
      if ((localObject1 != null) && (((Friends)localObject1).name != null)) {}
      for (Object localObject2 = ((Friends)localObject1).name;; localObject2 = this.jdField_a_of_type_JavaLangString)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals(this.jdField_a_of_type_JavaLangString)) {}
        }
        else
        {
          String str = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = str;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.jdField_a_of_type_JavaLangString;
        }
        this.c = (this.c + "(" + (String)localObject2 + ")");
        break;
      }
      this.c = BaseApplicationImpl.sApplication.getString(2131433276);
      break;
      this.c = BaseApplicationImpl.sApplication.getString(2131438250);
      break;
      this.c = BaseApplicationImpl.sApplication.getString(2131433315);
      break;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, AppConstants.ar)) {
        break;
      }
      this.c = PublicAccountConfigUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
      break;
      this.c = PublicAccountConfigUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
      break;
    }
  }
  
  public int a()
  {
    return ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString).first).intValue();
  }
  
  protected long a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = -9223372036854775808L;
    long l = SearchUtils.b(paramString, this.c, IContactSearchable.l);
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
    if ((this.jdField_a_of_type_Int == 7220) || ((this.jdField_a_of_type_Int == 1008) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, AppConstants.ar))))
    {
      l = SearchUtils.b(paramString, "看点", IContactSearchable.l);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    if ((ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_Int == 7220))
    {
      l = SearchUtils.b(paramString, String.format(BaseApplicationImpl.sApplication.getString(2131433556), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()), PublicAccountConfigUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()), PublicAccountConfigUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) }), IContactSearchable.p);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    if (this.jdField_a_of_type_Int == 9002)
    {
      l = SearchUtils.b(paramString, BaseApplicationImpl.sApplication.getString(2131437232), IContactSearchable.p);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    if (this.jdField_b_of_type_Long != -9223372036854775808L)
    {
      this.jdField_b_of_type_Long += IContactSearchable.N;
      if ((AppConstants.aa.equals(a())) && (("购".equals(paramString)) || ("购物".equals(paramString)) || ("购物号".equals(paramString)))) {
        this.jdField_b_of_type_Long = (IContactSearchable.x + 1L);
      }
    }
    return this.jdField_b_of_type_Long;
  }
  
  public Object a()
  {
    return "tool:" + this.jdField_a_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      switch (this.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Object localObject;
            EcShopAssistantManager localEcShopAssistantManager;
            int j;
            int i;
            localNumberFormatException.printStackTrace();
          }
        }
        SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, (int)l1, paramView);
        return;
        localObject = new Intent(paramView.getContext(), LiteActivity.class);
        ((Intent)localObject).putExtra("targetUin", AppConstants.y);
        RecentUtil.a = true;
        RecentUtil.a((Intent)localObject);
        paramView.getContext().startActivity((Intent)localObject);
        continue;
        localObject = new Intent(paramView.getContext(), ActivateFriendActivity.class);
        ((Intent)localObject).putExtra("af_key_from", 5);
        paramView.getContext().startActivity((Intent)localObject);
        if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 1))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006477", "0X8006477", this.jdField_b_of_type_Int, 0, "", "", "", "");
          continue;
          localObject = new Intent(paramView.getContext(), EcshopWebActivity.class);
          ((Intent)localObject).putExtra("from_search", true);
          ((Intent)localObject).setFlags(67108864);
          localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
          if (localEcShopAssistantManager != null) {
            localEcShopAssistantManager.a((Intent)localObject, paramView.getContext(), -1);
          }
          paramView.getContext().startActivity((Intent)localObject);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Clk_Searchshopfolder", 0, 0, "", "", "", "");
          continue;
          localObject = TroopBarAssistantManager.a();
          ((TroopBarAssistantManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          ((TroopBarAssistantManager)localObject).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
          for (localObject = ReadInJoyActivityHelper.a(paramView.getContext(), 0, 1);; localObject = ReadInJoyActivityHelper.a(paramView.getContext(), -1, 1))
          {
            ((Intent)localObject).putExtra("come_from", 1);
            ((Intent)localObject).setFlags(67108864);
            paramView.getContext().startActivity((Intent)localObject);
            break;
          }
          localObject = new Intent(paramView.getContext(), ServiceAccountFolderActivity.class);
          ((Intent)localObject).putExtra("from_source", "from_search");
          ((Intent)localObject).setFlags(67108864);
          paramView.getContext().startActivity((Intent)localObject);
          if (QLog.isColorLevel())
          {
            QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
            continue;
            MsgBoxListActivity.a(paramView.getContext(), 1001, String.valueOf(9999L));
            continue;
            localObject = new Intent(paramView.getContext(), TroopAssistantActivity.class);
            ((Intent)localObject).setFlags(67108864);
            paramView.getContext().startActivity((Intent)localObject);
            continue;
            SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
            continue;
            localObject = new Intent();
            ((Intent)localObject).putExtra("key_tab_mode", 2);
            ((Intent)localObject).setClass(paramView.getContext(), TroopActivity.class);
            j = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            i = j;
            if (j <= 0) {
              i = RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.S, 9000, -i);
            paramView.getContext().startActivity((Intent)localObject);
            continue;
            localObject = new Intent(paramView.getContext(), BlessActivity.class);
            ((Intent)localObject).putExtra("PARAM_IS_FROM_SEARCH", true);
            paramView.getContext().startActivity((Intent)localObject);
            continue;
            localObject = new Intent(paramView.getContext(), NewFriendActivity.class);
            ((Intent)localObject).setFlags(67108864);
            paramView.getContext().startActivity((Intent)localObject);
            continue;
            if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, AppConstants.ar))
            {
              PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
              ReadInJoyActivityHelper.a(paramView.getContext(), null, -1L, 1);
              PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
              SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_Int);
              continue;
              ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), 1, 0);
              PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
              PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
              SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_Int);
            }
          }
        }
      }
    }
    SearchUtils.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 9002: 
      return SearchUtils.a(BaseApplicationImpl.sApplication.getString(2131437232), this.jdField_b_of_type_JavaLangString, 255);
    }
    return SearchUtils.a(String.format(BaseApplicationImpl.sApplication.getString(2131433556), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()), PublicAccountConfigUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()), PublicAccountConfigUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) }), this.jdField_b_of_type_JavaLangString, 255);
  }
  
  public String c()
  {
    return this.c;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContactSearchModelTool
 * JD-Core Version:    0.7.0.1
 */