package com.tencent.mobileqq.search.business.contact.model;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ContactSearchModelNewTroopMember
  extends ContactSearchModelGlobalTroopMember
{
  public ContactSearchModelNewTroopMember(AppInterface paramAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public CharSequence a()
  {
    if (SearchUtils.a(this.b)) {
      return HardCodeUtil.a(2131702732);
    }
    return HardCodeUtil.a(2131702698);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!SearchUtils.a(this.b)) {
      SearchUtils.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.b) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroopMember
 * JD-Core Version:    0.7.0.1
 */