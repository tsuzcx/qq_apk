package com.tencent.mobileqq.search.business.contact.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpellingAll;

public class ContactSearchModelGameMsgBox
  extends IContactSearchModel
{
  private final GameDetailInfo a;
  private final String b;
  private String c;
  private ChnToSpell.ChnSpelling d;
  private ChnToSpell.ChnSpelling e;
  
  public ContactSearchModelGameMsgBox(AppInterface paramAppInterface, int paramInt, long paramLong, String paramString, GameDetailInfo paramGameDetailInfo)
  {
    super(paramAppInterface, paramInt, paramLong);
    this.b = paramString;
    this.a = paramGameDetailInfo;
    if (!TextUtils.isEmpty(paramGameDetailInfo.e))
    {
      paramAppInterface = ChnToSpell.a(paramGameDetailInfo.e);
      if (paramAppInterface != null)
      {
        this.d = paramAppInterface.a();
        this.e = paramAppInterface.b();
      }
    }
  }
  
  public CharSequence a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131900740));
    localStringBuilder.append(this.a.k);
    return localStringBuilder.toString();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this.m, paramView.getContext(), this.b, 6);
    ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.c);
    SearchUtils.a(this.m, this.a.e, this.b, "", 10007);
  }
  
  public int b()
  {
    return 119;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.b;
  }
  
  public int j()
  {
    return 10007;
  }
  
  public String m()
  {
    return this.a.e;
  }
  
  public String n()
  {
    return "";
  }
  
  protected long n_(String paramString)
  {
    this.c = paramString;
    return SearchUtils.a(paramString, this.a.e, this.d, this.e, -9223372036854775808L);
  }
  
  public int o()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGameMsgBox
 * JD-Core Version:    0.7.0.1
 */