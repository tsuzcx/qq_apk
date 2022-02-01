package com.tencent.mobileqq.medalwall;

import SummaryCard.TMedalWallInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;

public class MedalWallMng
  implements Handler.Callback, Manager
{
  protected static final String a = Environment.getExternalStorageDirectory().getAbsolutePath();
  protected static final String b;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static int g = 5;
  public static int h = 6;
  public static int i = 7;
  protected final SparseArray<MedalInfo> j;
  protected final ArrayList<MedalWallMng.NeedGuideMedal> k;
  protected int l;
  protected int m;
  protected QQAppInterface n;
  protected boolean o = false;
  protected final WeakReferenceHandler p;
  private String q;
  private String r;
  private String s;
  private boolean t = false;
  private int u = -2147483648;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tencent/MobileQQ/medal/");
    b = localStringBuilder.toString();
  }
  
  public MedalWallMng(QQAppInterface paramQQAppInterface)
  {
    this.n = paramQQAppInterface;
    this.j = new SparseArray(3);
    this.k = new ArrayList();
    this.p = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.l = 0;
  }
  
  public static String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("validateUrl>>> url=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.startsWith("https://")) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("validateUrl<<< url=%s", new Object[] { paramString }));
    }
    return paramString;
  }
  
  public static void a(MedalInfo paramMedalInfo, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalInfo[");
    paramStringBuilder.append("iId: ");
    paramStringBuilder.append(paramMedalInfo.iId);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iType: ");
    paramStringBuilder.append(paramMedalInfo.iType);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iLevel: ");
    paramStringBuilder.append(paramMedalInfo.iLevel);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iLevelCount: ");
    paramStringBuilder.append(paramMedalInfo.iLevelCount);
    paramStringBuilder.append(",");
    paramStringBuilder.append("lEndTime: ");
    paramStringBuilder.append(paramMedalInfo.lEndTime);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iUnreadLevel1: ");
    paramStringBuilder.append(paramMedalInfo.iUnreadLevel1);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iUnreadLevel2: ");
    paramStringBuilder.append(paramMedalInfo.iUnreadLevel2);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iUnreadLevel3: ");
    paramStringBuilder.append(paramMedalInfo.iUnreadLevel3);
    paramStringBuilder.append(",");
    paramStringBuilder.append("iNoProgress: ");
    paramStringBuilder.append(paramMedalInfo.iNoProgress);
    paramStringBuilder.append(",");
    paramStringBuilder.append("strName: ");
    paramStringBuilder.append(paramMedalInfo.strName);
    paramStringBuilder.append("] ");
  }
  
  public static void a(MedalID paramMedalID, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalID[");
    paramStringBuilder.append("id: ");
    paramStringBuilder.append(paramMedalID.a);
    paramStringBuilder.append(",");
    paramStringBuilder.append("level: ");
    paramStringBuilder.append(paramMedalID.b);
    paramStringBuilder.append("] ");
  }
  
  private void a(MedalWallMng.NeedGuideMedal paramNeedGuideMedal)
  {
    if (paramNeedGuideMedal != null)
    {
      if (paramNeedGuideMedal.a == null) {
        return;
      }
      if (!FileUtils.fileExistsAndNotEmpty(paramNeedGuideMedal.c)) {
        return;
      }
      try
      {
        Resources localResources = BaseApplicationImpl.getApplication().getResources();
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int i1 = localResources.getDimensionPixelSize(2131299071);
        localURLDrawableOptions.mRequestWidth = i1;
        localURLDrawableOptions.mRequestHeight = i1;
        URLDrawable.getDrawable(new File(paramNeedGuideMedal.c), localURLDrawableOptions).startDownload(true);
        return;
      }
      catch (Exception paramNeedGuideMedal)
      {
        QLog.e("MedalWallMng", 1, "tryPreloadImg fail.", paramNeedGuideMedal);
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCheckResFlag value: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.n.getAccount() });
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4);
    if (((SharedPreferences)localObject).getInt("MEDAL_CHECK_RES_STATE", 0) != paramInt) {
      ((SharedPreferences)localObject).edit().putInt("MEDAL_CHECK_RES_STATE", paramInt).apply();
    }
  }
  
  private void f()
  {
    try
    {
      boolean bool = this.o;
      if (bool) {
        return;
      }
      StringBuilder localStringBuilder = null;
      if (QLog.isColorLevel()) {
        localStringBuilder = new StringBuilder(200);
      }
      Object localObject3 = this.n.getEntityManagerFactory().createEntityManager().query(MedalInfo.class);
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        synchronized (this.j)
        {
          this.j.clear();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            MedalInfo localMedalInfo = (MedalInfo)((Iterator)localObject3).next();
            if (localMedalInfo != null)
            {
              this.j.put(localMedalInfo.iId, localMedalInfo);
              if ((QLog.isColorLevel()) && (localStringBuilder != null))
              {
                a(localMedalInfo, localStringBuilder);
                localStringBuilder.append("\r\n");
              }
            }
          }
        }
      }
      this.o = true;
      if ((QLog.isColorLevel()) && (localObject1 != null)) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "init size: %d \r\n{%s}", new Object[] { Integer.valueOf(this.j.size()), localObject1.toString() }));
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckMedalRes checkedCount: %d", new Object[] { Integer.valueOf(this.l) }));
    }
    int i1;
    label182:
    Object localObject2;
    label187:
    label192:
    label199:
    synchronized (this.k)
    {
      if (this.l > 0)
      {
        i1 = this.l - 1;
        break label182;
        if (i1 >= this.k.size()) {
          break label199;
        }
        MedalWallMng.NeedGuideMedal localNeedGuideMedal = (MedalWallMng.NeedGuideMedal)this.k.get(i1);
        if ((localNeedGuideMedal != null) && (!localNeedGuideMedal.e))
        {
          if (!localNeedGuideMedal.a()) {
            break label187;
          }
          this.l = (i1 + 1);
          a(localNeedGuideMedal);
          break label192;
        }
        this.l = (i1 + 1);
        break label192;
        if (i1 != 0)
        {
          ThreadManager.post(new MedalWallMng.DownloadResTask(this, localNeedGuideMedal), 5, null, false);
          return;
        }
        if (this.m > 0)
        {
          c(2);
          return;
        }
        c(1);
      }
    }
  }
  
  private void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "doCheckForLogin");
    }
    this.p.removeMessages(3);
    Object localObject = (LocalRedTouchManager)this.n.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(10015);
    boolean bool = ((LocalRedTouchManager)localObject).b(localRedTouchItem);
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("doCheckForLogin item=%s hasMedalRedPoint=%s", new Object[] { localRedTouchItem, Boolean.valueOf(bool) }));
    }
    int i1;
    if (bool)
    {
      localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.n.getAccount() });
      i1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4).getInt("MEDAL_CHECK_RES_STATE", 0);
      if (i1 == 2) {
        c();
      } else {
        d();
      }
    }
    else
    {
      c(0);
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("doCheckForLogin hasMedalRedPoint=%s, flag=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i1) }));
    }
  }
  
  private boolean i()
  {
    boolean bool;
    if (SharedPreUtils.am(this.n.getApplication(), this.n.getCurrentAccountUin()) != 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.t = bool;
    if (this.t) {
      return true;
    }
    if (((FriendsManager)this.n.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.n.getCurrentAccountUin()).medalSwitchDisable) {
      return true;
    }
    return Utils.c(this.n.getCurrentAccountUin());
  }
  
  private void j()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    this.q = localSharedPreferences.getString("hostUrl", "");
    this.r = localSharedPreferences.getString("guestUrl", "");
    this.s = localSharedPreferences.getString("shareUrl", "");
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,local hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { this.q, this.r, this.s }));
    }
    if (TextUtils.isEmpty(this.q)) {
      this.q = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    }
    if (TextUtils.isEmpty(this.r)) {
      this.r = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    }
    if (TextUtils.isEmpty(this.s)) {
      this.s = "https://ti.qq.com/qqmedal2/share.html?_wv=16777217&_wwv=4&_bid=2450";
    }
  }
  
  public Card a(TMedalWallInfo paramTMedalWallInfo, boolean paramBoolean)
  {
    Object localObject1 = this.j;
    int i6 = 0;
    int i5 = 0;
    int i1 = 0;
    for (;;)
    {
      try
      {
        Object localObject2;
        if (i6 < this.j.size())
        {
          localObject2 = (MedalInfo)this.j.valueAt(i6);
          if (localObject2 == null)
          {
            i3 = i5;
            i4 = i1;
          }
          else if (((MedalInfo)localObject2).iLevel == 255)
          {
            i3 = i5;
            i4 = i1;
            if (((MedalInfo)localObject2).iUnreadLevel1 == 1)
            {
              i3 = i5 + 1;
              i4 = i1;
            }
          }
          else
          {
            i3 = i5;
            i4 = i1;
            if (((MedalInfo)localObject2).iLevelCount > 1)
            {
              int i2 = i5;
              if (((MedalInfo)localObject2).iLevel >= 1)
              {
                i2 = i5;
                if (((MedalInfo)localObject2).iUnreadLevel1 == 1) {
                  i2 = i5 + 1;
                }
              }
              i5 = i1;
              if (((MedalInfo)localObject2).iLevel >= 2)
              {
                i5 = i1;
                if (((MedalInfo)localObject2).iUnreadLevel2 == 1) {
                  i5 = i1 + 1;
                }
              }
              i3 = i2;
              i4 = i5;
              if (((MedalInfo)localObject2).iLevel >= 3)
              {
                i3 = i2;
                i4 = i5;
                if (((MedalInfo)localObject2).iUnreadLevel3 == 1)
                {
                  i4 = i5 + 1;
                  i3 = i2;
                }
              }
            }
          }
        }
        else
        {
          localObject1 = (FriendsManager)this.n.getManager(QQManagerFactory.FRIENDS_MANAGER);
          localObject2 = ((FriendsManager)localObject1).g(this.n.getCurrentAccountUin());
          if (paramTMedalWallInfo != null)
          {
            ((Card)localObject2).iMedalCount = paramTMedalWallInfo.iMedalCount;
            if (QLog.isColorLevel()) {
              QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo needCheck: %s, compute[iNewCount: %d, iUpgradeCount: %d] server[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i5), Integer.valueOf(i1), Integer.valueOf(paramTMedalWallInfo.iNewCount), Integer.valueOf(paramTMedalWallInfo.iUpgradeCount), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
            }
            if ((paramBoolean) && ((paramTMedalWallInfo.iNewCount > i5) || (paramTMedalWallInfo.iUpgradeCount > i1)))
            {
              paramTMedalWallInfo.iNewCount = Math.min(paramTMedalWallInfo.iNewCount, i5);
              paramTMedalWallInfo.iUpgradeCount = Math.min(paramTMedalWallInfo.iUpgradeCount, i1);
            }
            ((Card)localObject2).iNewCount = paramTMedalWallInfo.iNewCount;
            ((Card)localObject2).iUpgradeCount = paramTMedalWallInfo.iUpgradeCount;
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo compute[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(i5), Integer.valueOf(i1), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
            }
            ((Card)localObject2).iNewCount = Math.min(((Card)localObject2).iNewCount, i5);
            ((Card)localObject2).iUpgradeCount = Math.min(((Card)localObject2).iUpgradeCount, i1);
          }
          ((FriendsManager)localObject1).a((Card)localObject2);
          return localObject2;
        }
      }
      finally
      {
        int i3;
        int i4;
        continue;
        throw paramTMedalWallInfo;
        continue;
        i6 += 1;
        i5 = i3;
        i1 = i4;
      }
    }
  }
  
  public String a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.q == null) || (this.r == null) || (this.s == null)) {
      j();
    }
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.r);
      localStringBuilder.append("&tuin=");
      localStringBuilder.append(NearbyURLSafeUtil.b(paramString));
      paramString = localStringBuilder;
    }
    else
    {
      paramString = new StringBuilder(this.q);
    }
    paramString.append("&from=");
    paramString.append(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "getMedalWallUrl url: %s", new Object[] { paramString }));
    }
    return paramString.toString();
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetMedalStrongReminderConfig value: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    ??? = this.n.getEntityManagerFactory().createEntityManager();
    Object localObject1 = new ArrayList(5);
    int i3 = 0;
    if (paramInt == 2) {}
    for (;;)
    {
      int i1;
      try
      {
        ??? = this.j;
        i1 = 0;
        try
        {
          if (i1 < this.j.size())
          {
            MedalInfo localMedalInfo = (MedalInfo)this.j.valueAt(i1);
            localMedalInfo.putReportInfo((ArrayList)localObject1);
            localMedalInfo.setRead();
            if (localMedalInfo.getStatus() == 1000)
            {
              ((EntityManager)???).persistOrReplace(localMedalInfo);
              break label577;
            }
            if ((localMedalInfo.getStatus() != 1001) && (localMedalInfo.getStatus() != 1002)) {
              break label577;
            }
            ((EntityManager)???).update(localMedalInfo);
            break label577;
          }
          synchronized (this.k)
          {
            this.k.clear();
          }
          if (!(paramObject instanceof MedalWallMng.NeedGuideMedal)) {
            continue;
          }
        }
        finally {}
        paramObject = (MedalWallMng.NeedGuideMedal)paramObject;
        i1 = paramObject.a.iId;
        try
        {
          ??? = paramObject.a;
          ((MedalInfo)???).putReportInfo((ArrayList)localObject1);
          ((MedalInfo)???).setRead();
          if (((MedalInfo)???).getStatus() == 1000) {
            ((EntityManager)???).persistOrReplace((Entity)???);
          } else if ((((MedalInfo)???).getStatus() == 1001) || (((MedalInfo)???).getStatus() == 1002)) {
            ((EntityManager)???).update((Entity)???);
          }
          synchronized (this.k)
          {
            this.k.remove(paramObject);
          }
          i1 = 0;
        }
        catch (Throwable paramObject) {}
      }
      catch (Throwable paramObject)
      {
        i1 = 0;
        paramObject.printStackTrace();
      }
      if (paramInt == 0)
      {
        paramObject = a(null, true);
      }
      else
      {
        ??? = (FriendsManager)this.n.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramObject = ((FriendsManager)???).g(this.n.getCurrentAccountUin());
        if (paramObject != null)
        {
          paramObject.iUpgradeCount = 0;
          paramObject.iNewCount = 0;
          ((FriendsManager)???).a(paramObject);
        }
      }
      ??? = (LocalRedTouchManager)this.n.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
      if ((paramInt != 1) && (paramInt != 2))
      {
        if ((paramObject == null) || ((paramObject.iNewCount == 0) && (paramObject.iUpgradeCount == 0))) {
          ((LocalRedTouchManager)???).b(10015);
        }
      }
      else
      {
        ((LocalRedTouchManager)???).b(10015);
        ((LocalRedTouchManager)???).b(10016);
      }
      if (!((ArrayList)localObject1).isEmpty()) {
        ((CardHandler)this.n.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).b((ArrayList)localObject1);
      }
      if ((paramObject == null) || ((paramObject.iNewCount == 0) && (paramObject.iUpgradeCount == 0))) {
        c(0);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = Locale.getDefault();
        int i2;
        if (paramObject == null) {
          i2 = 0;
        } else {
          i2 = paramObject.iNewCount;
        }
        if (paramObject != null) {
          i3 = paramObject.iUpgradeCount;
        }
        QLog.i("MedalWallMng", 2, String.format((Locale)localObject1, "reportReadSelfNewObtainedMedal [nActionType: %d, id: %d, iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) }));
      }
      return;
      label577:
      i1 += 1;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { paramString1, paramString2, paramString3 }));
    }
    if ((this.q == null) || (this.r == null) || (this.s == null)) {
      j();
    }
    if ((Utils.a(paramString1, this.q)) && (Utils.a(paramString2, this.r)) && (Utils.a(paramString3, this.s)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 4, "onGetConfig, no change return.");
      }
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putString("hostUrl", paramString1);
    localEditor.putString("guestUrl", paramString2);
    localEditor.putString("shareUrl", paramString3);
    localEditor.commit();
    this.q = paramString1;
    this.r = paramString2;
    this.s = paramString3;
    if (paramInt != 1) {
      bool1 = true;
    }
    this.t = bool1;
  }
  
  public void a(boolean paramBoolean, TMedalWallInfo paramTMedalWallInfo, SparseArray<MedalInfo> paramSparseArray)
  {
    f();
    int i1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(200);
      ((StringBuilder)???).append("onGetSelfNewObtainedMedaInfo isSuc:");
      ((StringBuilder)???).append(paramBoolean);
      if (paramTMedalWallInfo != null)
      {
        ((StringBuilder)???).append(", iMedalCount:");
        ((StringBuilder)???).append(paramTMedalWallInfo.iMedalCount);
        ((StringBuilder)???).append(", iNewCount:");
        ((StringBuilder)???).append(paramTMedalWallInfo.iNewCount);
        ((StringBuilder)???).append(", iUpgradeCount:");
        ((StringBuilder)???).append(paramTMedalWallInfo.iUpgradeCount);
      }
      if (paramSparseArray != null)
      {
        ((StringBuilder)???).append(", medalInfoArrayList: ");
        ((StringBuilder)???).append(paramSparseArray.size());
        i1 = 0;
        while (i1 < paramSparseArray.size())
        {
          localObject2 = (MedalInfo)paramSparseArray.valueAt(i1);
          if (localObject2 != null)
          {
            ((StringBuilder)???).append("\r\n info [id: ");
            ((StringBuilder)???).append(((MedalInfo)localObject2).iId);
            ((StringBuilder)???).append(", iLevel: ");
            ((StringBuilder)???).append(((MedalInfo)localObject2).iLevel);
            ((StringBuilder)???).append(", name: ");
            ((StringBuilder)???).append(((MedalInfo)localObject2).strName);
            ((StringBuilder)???).append(", res: ");
            ((StringBuilder)???).append(((MedalInfo)localObject2).strResJson);
            ((StringBuilder)???).append("]");
          }
          i1 += 1;
        }
      }
      QLog.i("MedalWallMng", 2, ((StringBuilder)???).toString());
    }
    Object localObject3;
    if (!paramBoolean)
    {
      c(2);
    }
    else
    {
      localObject2 = this.n.getEntityManagerFactory().createEntityManager();
      localObject3 = this.j;
      i1 = 0;
    }
    try
    {
      if (i1 >= this.j.size()) {
        break label475;
      }
      localMedalInfo = (MedalInfo)this.j.valueAt(i1);
      if (localMedalInfo == null) {
        break label636;
      }
      if (paramSparseArray == null) {
        break label628;
      }
      ??? = (MedalInfo)paramSparseArray.get(localMedalInfo.iId);
    }
    finally
    {
      label475:
      label628:
      do
      {
        MedalInfo localMedalInfo;
        for (;;)
        {
          throw paramTMedalWallInfo;
        }
        ??? = null;
      } while (??? == null);
      label636:
      i1 += 1;
    }
    if (localMedalInfo.isUnread())
    {
      localMedalInfo.setRead();
      if (localMedalInfo.getStatus() == 1000) {
        ((EntityManager)localObject2).persistOrReplace(localMedalInfo);
      } else if ((localMedalInfo.getStatus() == 1001) || (localMedalInfo.getStatus() == 1002)) {
        ((EntityManager)localObject2).update(localMedalInfo);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetSelfNewObtainedMedaInfo just local is unread [id: %d, level: %d, name: %s]", new Object[] { Integer.valueOf(localMedalInfo.iId), Integer.valueOf(localMedalInfo.iLevel), localMedalInfo.strName }));
        break label636;
        i1 = 0;
      }
    }
    for (;;)
    {
      if ((paramSparseArray != null) && (i1 < paramSparseArray.size()))
      {
        localObject3 = (MedalInfo)paramSparseArray.valueAt(i1);
        if (localObject3 != null)
        {
          if (((MedalInfo)localObject3).getStatus() == 1000) {
            ((EntityManager)localObject2).persistOrReplace((Entity)localObject3);
          } else if ((((MedalInfo)localObject3).getStatus() == 1001) || (((MedalInfo)localObject3).getStatus() == 1002)) {
            ((EntityManager)localObject2).update((Entity)localObject3);
          }
          synchronized (this.j)
          {
            this.j.put(((MedalInfo)localObject3).iId, localObject3);
          }
        }
      }
      else
      {
        a(paramTMedalWallInfo, true);
        c(0);
        d();
        return;
        break;
      }
      i1 += 1;
    }
  }
  
  public boolean a()
  {
    int i1 = this.u;
    boolean bool = false;
    if (i1 == -2147483648)
    {
      this.u = SharedPreUtils.v(this.n.getApp(), this.n.getCurrentAccountUin(), 3);
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "isMedalStrongReminderOff value: %s", new Object[] { Integer.valueOf(this.u) }));
      }
    }
    if (this.u == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, View paramView, int paramInt, Object paramObject)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkShowMedalGuide medal strong reminder is off!");
      }
      return false;
    }
    if (this.t)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkShowMedalGuide isMedalConfigOff: %s", new Object[] { Boolean.valueOf(this.t) }));
      }
      return false;
    }
    Object localObject1 = (LocalRedTouchManager)this.n.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    Object localObject2 = ((LocalRedTouchManager)localObject1).a(10015);
    boolean bool = ((LocalRedTouchManager)localObject1).b((RedTouchItem)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("checkShowMedalGuide item=%s hasMedalRedPoint=%s", new Object[] { localObject2, Boolean.valueOf(bool) }));
    }
    if (!bool)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no red point");
      }
      return false;
    }
    localObject2 = null;
    localObject1 = null;
    try
    {
      Iterator localIterator = this.k.iterator();
      Object localObject3;
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = localObject1;
        localObject3 = (MedalWallMng.NeedGuideMedal)localIterator.next();
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!((MedalWallMng.NeedGuideMedal)localObject3).h)
          {
            localObject2 = localObject1;
            if (((MedalWallMng.NeedGuideMedal)localObject3).e)
            {
              localObject2 = localObject1;
              if (!TextUtils.isEmpty(((MedalWallMng.NeedGuideMedal)localObject3).b))
              {
                localObject2 = localObject1;
                if (!TextUtils.isEmpty(((MedalWallMng.NeedGuideMedal)localObject3).c))
                {
                  localObject2 = localObject1;
                  if (((MedalWallMng.NeedGuideMedal)localObject3).f != 2)
                  {
                    localObject2 = localObject1;
                    if (((MedalWallMng.NeedGuideMedal)localObject3).a != null) {
                      if (localObject1 != null)
                      {
                        localObject2 = localObject1;
                        bool = ((MedalWallMng.NeedGuideMedal)localObject3).a.isNewer(((MedalWallMng.NeedGuideMedal)localObject1).a);
                        if (!bool) {}
                      }
                      else
                      {
                        localObject1 = localObject3;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      MedalInfo localMedalInfo;
      int i1;
      int i3;
      int i4;
      int i2;
      label522:
      label529:
      return false;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localObject3 = localObject2;
      if ((localObject3 != null) && (((MedalWallMng.NeedGuideMedal)localObject3).a != null))
      {
        ((MedalWallMng.NeedGuideMedal)localObject3).h = true;
        localMedalInfo = ((MedalWallMng.NeedGuideMedal)localObject3).a;
        if ((paramObject instanceof Card))
        {
          paramObject = (Card)paramObject;
          if (localMedalInfo.iLevel == 255)
          {
            if (localMedalInfo.iUnreadLevel1 == 1)
            {
              i1 = 1;
              break label522;
            }
          }
          else if (localMedalInfo.iLevelCount > 1)
          {
            if ((localMedalInfo.iLevel >= 1) && (localMedalInfo.iUnreadLevel1 == 1)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if ((localMedalInfo.iLevel >= 2) && (localMedalInfo.iUnreadLevel2 == 1)) {
              i3 = 1;
            } else {
              i3 = 0;
            }
            i4 = i1;
            i2 = i3;
            if (localMedalInfo.iLevel < 3) {
              break label529;
            }
            i4 = i1;
            i2 = i3;
            if (localMedalInfo.iUnreadLevel3 != 1) {
              break label529;
            }
            i2 = i3 + 1;
            i4 = i1;
            break label529;
          }
          i1 = 0;
          i2 = 0;
          i4 = i1;
          paramObject.iNewCount -= i4;
          paramObject.iUpgradeCount -= i2;
        }
        paramObject = Message.obtain();
        paramObject.what = 4;
        paramObject.obj = localObject3;
        this.p.sendMessage(paramObject);
        MedalGuideView.a((MedalWallMng.NeedGuideMedal)localObject3, paramQBaseActivity, paramView, paramInt);
        if (QLog.isDevelopLevel()) {
          QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "checkShowMedalGuide [%d, %d,  %s]", new Object[] { Integer.valueOf(localMedalInfo.iId), Integer.valueOf(localMedalInfo.iLevel), localMedalInfo.strName }));
        }
        return true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no medal to show");
      }
    }
  }
  
  public MedalInfo b(int paramInt)
  {
    f();
    synchronized (this.j)
    {
      MedalInfo localMedalInfo = (MedalInfo)this.j.get(paramInt);
      ??? = localMedalInfo;
      if (localMedalInfo == null)
      {
        ??? = new MedalInfo();
        ((MedalInfo)???).iId = paramInt;
        ((MedalInfo)???).iLevel = 0;
        ((MedalInfo)???).iUnreadLevel1 = 0;
        ((MedalInfo)???).iUnreadLevel2 = 0;
        ((MedalInfo)???).iUnreadLevel3 = 0;
      }
      return ???;
    }
  }
  
  public ArrayList<MedalID> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i1;
      try
      {
        paramString = paramString.replaceAll("new_medals=", "").replaceAll("update_medals=", "").replaceAll("&", ",").split(",");
        i1 = 0;
        if (i1 < paramString.length)
        {
          if ((paramString[i1] == null) || (paramString[i1].isEmpty())) {
            break label309;
          }
          localObject = paramString[i1].split("_");
          if (localObject.length != 3) {
            break label309;
          }
          localArrayList.add(new MedalID(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1])));
          break label309;
        }
        i1 = localArrayList.size() - 1;
        if (i1 < 0) {
          break label306;
        }
        paramString = (MedalID)localArrayList.get(i1);
        Object localObject = b(paramString.a);
        i2 = paramString.b;
        if (i2 != 1)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if ((i2 != 255) || (((MedalInfo)localObject).iUnreadLevel1 != 2)) {
                break label316;
              }
              break label321;
            }
            if (((MedalInfo)localObject).iUnreadLevel3 != 2) {
              break label316;
            }
            break label321;
          }
          if (((MedalInfo)localObject).iUnreadLevel2 != 2) {
            break label316;
          }
          break label321;
        }
        if (((MedalInfo)localObject).iUnreadLevel1 != 2) {
          break label316;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          break label306;
        }
        QLog.i("MedalWallMng", 2, "summarycard", paramString);
      }
      if (i2 != 0)
      {
        localArrayList.remove(i1);
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "parsePromptParams local read [id: %d , level: %d]", new Object[] { Integer.valueOf(paramString.a), Integer.valueOf(paramString.b) }));
        }
      }
      i1 -= 1;
      continue;
      label306:
      return localArrayList;
      label309:
      i1 += 1;
      continue;
      label316:
      int i2 = 0;
      continue;
      label321:
      i2 = 1;
    }
  }
  
  public void b()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkForLogin medal strong reminder is off!");
      }
      return;
    }
    if (i())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkForLogin medal is off!");
      }
      return;
    }
    this.p.removeMessages(3);
    this.p.sendEmptyMessageDelayed(3, 1000L);
  }
  
  public void c()
  {
    boolean bool1 = a();
    boolean bool2 = i();
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("onGetSelfObtainNewMedalNotice isMedalStrongReminderOff=%s isMedalOff=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    if (!bool1)
    {
      if (bool2) {
        return;
      }
      this.p.removeMessages(3);
      ((CardHandler)this.n.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).n();
    }
  }
  
  protected void d()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkMedalWall medal strong reminder is off!");
      }
      return;
    }
    if (i())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkMedalWall medal is off!");
      }
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i1 = 0;
    if (bool) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalWall mIsInit: %s", new Object[] { Boolean.valueOf(this.o) }));
    }
    this.p.removeMessages(3);
    this.p.removeMessages(1);
    this.l = 0;
    this.m = 0;
    f();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      synchronized (this.j)
      {
        if (i1 < this.j.size())
        {
          MedalInfo localMedalInfo = (MedalInfo)this.j.valueAt(i1);
          if ((localMedalInfo != null) && (localMedalInfo.isUnread()))
          {
            MedalWallMng.NeedGuideMedal localNeedGuideMedal = new MedalWallMng.NeedGuideMedal();
            localNeedGuideMedal.a = localMedalInfo;
            localArrayList.add(localNeedGuideMedal);
          }
        }
        else
        {
          synchronized (this.k)
          {
            this.k.clear();
            this.k.addAll(localArrayList);
            if (this.l < this.k.size()) {
              this.p.sendEmptyMessage(1);
            }
            return;
          }
        }
      }
    }
  }
  
  public String e()
  {
    if ((this.q == null) || (this.r == null) || (this.s == null)) {
      j();
    }
    return this.s;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return true;
          }
          if ((paramMessage.obj instanceof MedalWallMng.NeedGuideMedal))
          {
            a(0, (MedalWallMng.NeedGuideMedal)paramMessage.obj);
            return true;
          }
        }
        else
        {
          h();
          return true;
        }
      }
      else
      {
        MedalWallMng.NeedGuideMedal localNeedGuideMedal = (MedalWallMng.NeedGuideMedal)paramMessage.obj;
        if (localNeedGuideMedal != null)
        {
          if (localNeedGuideMedal.f == 2) {
            this.m += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "MSG_DOWNLOAD_RES_RESULT failCount: %d, cost: %d, failCode: %d, url: %s", new Object[] { Integer.valueOf(this.m), Integer.valueOf(paramMessage.arg1), Integer.valueOf(localNeedGuideMedal.g), localNeedGuideMedal.b }));
          }
        }
        if (this.l < this.k.size())
        {
          this.p.sendEmptyMessage(1);
          return true;
        }
      }
    }
    else {
      g();
    }
    return true;
  }
  
  public void onDestroy()
  {
    synchronized (this.j)
    {
      this.j.clear();
      synchronized (this.k)
      {
        this.k.clear();
        this.o = false;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng
 * JD-Core Version:    0.7.0.1
 */