package com.tencent.mobileqq.friend.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.friend.inject.FriendInjectFactory;
import com.tencent.mobileqq.friend.inject.IContactFacadeInjectService;
import com.tencent.mobileqq.friend.name.AccountName;
import com.tencent.mobileqq.friend.name.AliasName;
import com.tencent.mobileqq.friend.name.IFriendName;
import com.tencent.mobileqq.friend.name.NickName;
import com.tencent.mobileqq.friend.name.PhoneContactName;
import com.tencent.mobileqq.friend.name.ProfileCardName;
import com.tencent.mobileqq.friend.name.PublicAccountName;
import com.tencent.mobileqq.friend.name.RemarkName;
import com.tencent.mobileqq.friend.name.UINName;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import mqq.app.AppRuntime;

public class FriendNameServiceImpl
  implements IFriendNameService
{
  private static final String STRATEGY_KEY_ACCOUNT_NAME = AccountName.class.getSimpleName();
  private static final String STRATEGY_KEY_FRIEND_ALIAS = AliasName.class.getSimpleName();
  private static final String STRATEGY_KEY_FRIEND_NICK;
  private static final String STRATEGY_KEY_FRIEND_REMARK = RemarkName.class.getSimpleName();
  private static final String STRATEGY_KEY_FRIEND_UIN = UINName.class.getSimpleName();
  private static final String STRATEGY_KEY_PHONE_CONTACT = PhoneContactName.class.getSimpleName();
  private static final String STRATEGY_KEY_PROFILE_CARD;
  private static final String STRATEGY_KEY_PUBLIC_ACCOUNT = PublicAccountName.class.getSimpleName();
  private static final String TAG = "IMCore.friend.FriendNameServiceImpl";
  private AppInterface mApp;
  private IContactFacadeInjectService mContactFacadeService;
  private IFriendDataService mFriendDataService;
  private HashMap<String, IFriendName> mFriendNameStrategies;
  
  static
  {
    STRATEGY_KEY_FRIEND_NICK = NickName.class.getSimpleName();
    STRATEGY_KEY_PROFILE_CARD = ProfileCardName.class.getSimpleName();
  }
  
  private String getFriendName(String paramString, List<String> paramList)
  {
    return getFriendName(paramString, paramList, false);
  }
  
  private String getFriendName(String paramString, List<String> paramList, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = null;
    if ((!bool) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return null;
      }
      Friends localFriends = this.mFriendDataService.getFriend(paramString, true, true);
      Iterator localIterator = paramList.iterator();
      paramList = null;
      Object localObject2;
      Object localObject1;
      do
      {
        do
        {
          localObject2 = localObject3;
          localObject1 = paramList;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (String)localIterator.next();
          localObject1 = (IFriendName)this.mFriendNameStrategies.get(localObject2);
        } while (localObject1 == null);
        localObject1 = ((IFriendName)localObject1).a(paramString, localFriends, this.mApp);
        paramList = (List<String>)localObject1;
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      if ((paramBoolean) && ((TextUtils.isEmpty((CharSequence)localObject2)) || (STRATEGY_KEY_FRIEND_UIN.equals(localObject2))))
      {
        paramList = this.mContactFacadeService;
        if (paramList != null) {
          paramList.a(this.mApp, paramString);
        }
      }
      return localObject1;
    }
    return null;
  }
  
  public String getBuddyName(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(STRATEGY_KEY_PUBLIC_ACCOUNT);
    localArrayList.add(STRATEGY_KEY_FRIEND_UIN);
    return getFriendName(paramString, localArrayList, paramBoolean);
  }
  
  public String getFriendAlias(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(STRATEGY_KEY_FRIEND_ALIAS);
    localArrayList.add(STRATEGY_KEY_FRIEND_UIN);
    return getFriendName(paramString, localArrayList);
  }
  
  public String getFriendName(String paramString)
  {
    return getFriendName(paramString, true);
  }
  
  public String getFriendName(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(STRATEGY_KEY_FRIEND_REMARK);
    localArrayList.add(STRATEGY_KEY_PHONE_CONTACT);
    localArrayList.add(STRATEGY_KEY_FRIEND_NICK);
    if (paramBoolean) {
      localArrayList.add(STRATEGY_KEY_FRIEND_UIN);
    }
    return getFriendName(paramString, localArrayList);
  }
  
  public String getFriendNick(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(STRATEGY_KEY_FRIEND_NICK);
    localArrayList.add(STRATEGY_KEY_PROFILE_CARD);
    localArrayList.add(STRATEGY_KEY_FRIEND_UIN);
    return getFriendName(paramString, localArrayList);
  }
  
  public String getFriendRemark(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(STRATEGY_KEY_FRIEND_REMARK);
    localArrayList.add(STRATEGY_KEY_FRIEND_UIN);
    return getFriendName(paramString, localArrayList);
  }
  
  public String getPhoneContactName(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(STRATEGY_KEY_PHONE_CONTACT);
    localArrayList.add(STRATEGY_KEY_FRIEND_UIN);
    return getFriendName(paramString, localArrayList);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    this.mFriendDataService = ((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "all"));
    this.mFriendNameStrategies = new HashMap();
    this.mFriendNameStrategies.put(STRATEGY_KEY_ACCOUNT_NAME, new AccountName());
    this.mFriendNameStrategies.put(STRATEGY_KEY_FRIEND_REMARK, new RemarkName());
    this.mFriendNameStrategies.put(STRATEGY_KEY_PHONE_CONTACT, new PhoneContactName());
    this.mFriendNameStrategies.put(STRATEGY_KEY_FRIEND_NICK, new NickName());
    this.mFriendNameStrategies.put(STRATEGY_KEY_PROFILE_CARD, new ProfileCardName());
    this.mFriendNameStrategies.put(STRATEGY_KEY_FRIEND_ALIAS, new AliasName());
    this.mFriendNameStrategies.put(STRATEGY_KEY_FRIEND_UIN, new UINName());
    this.mFriendNameStrategies.put(STRATEGY_KEY_PUBLIC_ACCOUNT, new PublicAccountName());
    this.mContactFacadeService = FriendInjectFactory.a();
  }
  
  public void onDestroy() {}
  
  public Friends saveFriendRemark(String paramString1, String paramString2)
  {
    Friends localFriends = this.mFriendDataService.getFriend(paramString1, true, true, true);
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      QLog.d("IMCore.friend.FriendNameServiceImpl", 1, "saveFriendRemark, remark is null");
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.mFriendDataService.saveFriend(localFriends);
    }
    return localFriends;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.impl.FriendNameServiceImpl
 * JD-Core Version:    0.7.0.1
 */