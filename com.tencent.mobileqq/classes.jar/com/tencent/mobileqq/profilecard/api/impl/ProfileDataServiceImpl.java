package com.tencent.mobileqq.profilecard.api.impl;

import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ProfileDataServiceImpl
  implements IProfileDataService
{
  private static final Object PROFILE_CARD_CACHE_LOCK = new Object();
  private static final int PROFILE_CARD_CACHE_SIZE = 20;
  private static final String TAG = "ProfileDataServiceImpl";
  private AppRuntime appRuntime;
  private EntityManager entityManager;
  private MQLruCache<String, Card> profileCardCache;
  
  private boolean updateEntity(Entity paramEntity)
  {
    if (this.entityManager.isOpen())
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.entityManager.persistOrReplace(paramEntity);
        return paramEntity.getStatus() == 1001;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.entityManager.update(paramEntity);
      }
    }
    QLog.e("ProfileDataServiceImpl", 1, "updateEntity fail! entity manager closed.");
    return false;
  }
  
  public ContactCard getContactCardByMobileNo(String paramString, boolean paramBoolean)
  {
    ContactCard localContactCard2 = (ContactCard)this.entityManager.find(ContactCard.class, paramString);
    ContactCard localContactCard1 = localContactCard2;
    if (localContactCard2 == null)
    {
      localContactCard1 = localContactCard2;
      if (paramBoolean)
      {
        localContactCard1 = new ContactCard();
        localContactCard1.mobileNo = paramString;
        this.entityManager.persist(localContactCard1);
      }
    }
    return localContactCard1;
  }
  
  public Card getProfileCard(String paramString, boolean paramBoolean)
  {
    ??? = null;
    if (!TextUtils.isEmpty(paramString)) {}
    synchronized (PROFILE_CARD_CACHE_LOCK)
    {
      ??? = (Card)this.profileCardCache.get(paramString);
      ??? = ???;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileDataServiceImpl", 2, String.format("getProfileCard from cache. uin=%s card=%s", new Object[] { paramString, ??? }));
        ??? = ???;
      }
      ??? = ???;
      if (??? == null)
      {
        ??? = (Card)this.entityManager.find(Card.class, paramString);
        if ((??? == null) || (TextUtils.isEmpty(paramString))) {}
      }
      synchronized (PROFILE_CARD_CACHE_LOCK)
      {
        this.profileCardCache.put(paramString, ???);
        ??? = ???;
        if (QLog.isColorLevel())
        {
          QLog.d("ProfileDataServiceImpl", 2, String.format("getProfileCard from db. uin=%s card=%s", new Object[] { paramString, ??? }));
          ??? = ???;
        }
        ??? = ???;
        if (??? == null)
        {
          ??? = ???;
          if (paramBoolean)
          {
            ??? = new Card();
            ((Card)???).uin = paramString;
            ((Card)???).shGender = -1;
            this.entityManager.persist((Entity)???);
            if (TextUtils.isEmpty(paramString)) {}
          }
        }
      }
    }
    synchronized (PROFILE_CARD_CACHE_LOCK)
    {
      this.profileCardCache.put(paramString, ???);
      ??? = ???;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileDataServiceImpl", 2, String.format("getProfileCard from new. uin=%s card=%s", new Object[] { paramString, ??? }));
        ??? = ???;
      }
      return ???;
      paramString = finally;
      throw paramString;
      paramString = finally;
      throw paramString;
    }
  }
  
  public Card getProfileCardFromCache(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (PROFILE_CARD_CACHE_LOCK)
      {
        paramString = (Card)this.profileCardCache.get(paramString);
        return paramString;
      }
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
    this.entityManager = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    this.profileCardCache = new MQLruCache(20);
  }
  
  public void onDestroy() {}
  
  public boolean saveContactCard(ContactCard paramContactCard)
  {
    return updateEntity(paramContactCard);
  }
  
  public boolean saveProfileCard(Card paramCard)
  {
    return updateEntity(paramCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.impl.ProfileDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */