package com.tencent.mobileqq.gamecenter.data;

import ahkf;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import aqrj;
import aqrk;
import aqrq;
import auko;
import bbco;
import bbdj;
import bbfd;
import bbqp;
import bich;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import yoc;
import yod;
import yom;

public class GameNoticeCenter
  implements yoc
{
  private static final Comparator<GameNoticeInfo> jdField_a_of_type_JavaUtilComparator = new aqrj();
  private final int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private aqrk jdField_a_of_type_Aqrk;
  private GameNoticeCenter.GameNoticeInfoList jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new GameNoticeCenter.1(this);
  private Date jdField_a_of_type_JavaUtilDate = new Date();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 2;
  private Runnable jdField_b_of_type_JavaLangRunnable = new GameNoticeCenter.3(this);
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  
  public GameNoticeCenter(QQAppInterface paramQQAppInterface)
  {
    GameCenterReceiver.a();
    GameCenterReceiver.a(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList = new GameNoticeCenter.GameNoticeInfoList(this, paramQQAppInterface.getEntityManagerFactory().createEntityManager());
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300000L);
  }
  
  private Date a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilDate.setTime(paramLong);
    return this.jdField_a_of_type_JavaUtilDate;
  }
  
  private final MqqHandler a()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!(localObject1 instanceof bbco))
        {
          QLog.e("GameNoticeCenter", 1, "getHandler not CustomHandler");
          localObject2 = null;
        }
      }
      return localObject2;
    }
  }
  
  private yom a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      localObject = new yom((AppInterface)localObject);
      ((yom)localObject).f("4").g("430").a("817");
      return localObject;
    }
  }
  
  private void a(int paramInt, WadlResult arg2)
  {
    int j = 1;
    if ((??? == null) || (???.a == null)) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Aqrk != null) && (aqrk.a(this.jdField_a_of_type_Aqrk) != null) && (???.a.a.equals(aqrk.a(this.jdField_a_of_type_Aqrk).appId)))
      {
        int i = j;
        if (paramInt == 1) {
          if (aqrk.a(this.jdField_a_of_type_Aqrk).bannerType != 1) {
            break label145;
          }
        }
        label145:
        for (i = j; i != 0; i = 0) {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            GameNoticeInfo localGameNoticeInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId(aqrk.a(this.jdField_a_of_type_Aqrk).appId);
            if (localGameNoticeInfo != null)
            {
              localGameNoticeInfo.shown = true;
              this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.updateDB(localGameNoticeInfo);
            }
            a(true);
            return;
          }
        }
      }
    }
  }
  
  private void a(List<aqrq> paramList)
  {
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = new ArrayList();
    }
    Object localObject2 = new StringBuilder().append("handleTaskInfos, taskInfos.size=").append(((List)localObject1).size()).append(",mGameNoticeInfos=");
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList != null) {}
    for (paramList = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.size());; paramList = "null")
    {
      QLog.d("GameNoticeCenter", 1, paramList);
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList != null) && (((List)localObject1).size() >= 1)) {
        break;
      }
      return;
    }
    paramList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    boolean bool;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aqrq)((Iterator)localObject1).next();
      bool = i | a((aqrq)localObject2);
      i = bool;
      if (!TextUtils.isEmpty(((aqrq)localObject2).a))
      {
        i = bool;
        if (!paramList.contains(((aqrq)localObject2).a))
        {
          paramList.add(((aqrq)localObject2).a);
          i = bool;
        }
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.listIterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (GameNoticeInfo)((Iterator)localObject1).next();
      if (!paramList.contains(((GameNoticeInfo)localObject2).appId))
      {
        ((Iterator)localObject1).remove();
        bool = i | 0x1;
        i = bool;
        if (QLog.isColorLevel())
        {
          QLog.d("GameNoticeCenter", 2, new Object[] { "handleTaskInfos, remove ", localObject2 });
          i = bool;
        }
      }
    }
    if (i != 0) {
      Collections.sort(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList, jdField_a_of_type_JavaUtilComparator);
    }
    QLog.d("GameNoticeCenter", 1, new Object[] { "handleTaskInfos end, remains ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.size()) });
    GameNoticeCenter.GameNoticeInfoList.access$000(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, new Object[] { "hideBanner: ", this.jdField_a_of_type_Aqrk, ", sendMessage=", Boolean.valueOf(paramBoolean) });
    }
    if (this.jdField_a_of_type_Aqrk != null)
    {
      if (paramBoolean)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          ahkf.a((QQAppInterface)localAppRuntime, aqrk.a(this.jdField_a_of_type_Aqrk));
        }
      }
      this.jdField_a_of_type_Aqrk = null;
    }
  }
  
  private boolean a(aqrq paramaqrq)
  {
    Object localObject = paramaqrq.a;
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId((String)localObject);
    switch (paramaqrq.d)
    {
    case 7: 
    case 8: 
    default: 
      if (localObject != null)
      {
        QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo(remove), ", paramaqrq });
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.remove(localObject);
        QLog.d("GameNoticeCenter", 1, new Object[] { "remove GameNoticeInfo: ", localObject });
        return true;
      }
      break;
    case 6: 
    case 9: 
    case 10: 
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, new Object[] { "processTaskInfo(add), ", paramaqrq });
      }
      if ((localObject != null) && ((((GameNoticeInfo)localObject).bannerType != GameNoticeInfo.convertToBannerType(paramaqrq)) || (((GameNoticeInfo)localObject).createTime != paramaqrq.c)))
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.remove(localObject);
        QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo: remove GameNoticeInfo: ", localObject });
        localObject = null;
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      if (localObject == null)
      {
        paramaqrq = new GameNoticeInfo(paramaqrq, BaseApplication.getContext());
        if (paramaqrq.isValid())
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.add(paramaqrq);
          QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo: add GameNoticeInfo: ", paramaqrq });
          return true;
        }
        QLog.e("GameNoticeCenter", 1, new Object[] { "processTaskInfo: invalid GameNoticeInfo: ", paramaqrq });
        return bool;
        return false;
      }
      return bool;
    }
  }
  
  private final boolean a(GameNoticeInfo paramGameNoticeInfo)
  {
    boolean bool = false;
    if (!paramGameNoticeInfo.infoRequested)
    {
      paramGameNoticeInfo.infoRequested = true;
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, new Object[] { "request register: ", paramGameNoticeInfo });
      }
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((bbqp)((QQAppInterface)localAppRuntime).a(71)).g(paramGameNoticeInfo.appId);
      }
      bool = true;
    }
    return bool;
  }
  
  private static void b(String paramString, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), GameCenterActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.addFlags(268435456);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    paramContext.startActivity(localIntent);
  }
  
  private void c()
  {
    if ((a() == null) || (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "checkBanner begin, now=" + l1 + ",mGameNoticeInfos size=" + this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.iterator();
    GameNoticeInfo localGameNoticeInfo;
    Object localObject;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localGameNoticeInfo = (GameNoticeInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 1, "checkBanner info=" + localGameNoticeInfo);
        }
        if (!localGameNoticeInfo.isValid())
        {
          localIterator.remove();
        }
        else
        {
          if ((localGameNoticeInfo.bannerType == 1) && (!TextUtils.isEmpty(localGameNoticeInfo.filePath)))
          {
            localObject = new File(localGameNoticeInfo.filePath);
            if (((File)localObject).exists())
            {
              long l2 = yod.a("KEY_RED_POINT_TIME_" + localGameNoticeInfo.appId);
              long l3 = ((File)localObject).lastModified();
              if (QLog.isColorLevel()) {
                QLog.d("GameNoticeCenter", 1, "redPointTime=" + l2 + ",now=" + l1 + ",fileLastModifiedTime=" + l3);
              }
              if ((l1 - l2 > 604800000L) || (l2 > l1))
              {
                l2 = l1 - l3;
                if (QLog.isColorLevel()) {
                  QLog.d("GameNoticeCenter", 1, "lostTime=" + l2 + ",compTime=" + 86400000L + " | " + 172800000L);
                }
                if ((l2 > 86400000L) && (l2 < 172800000L))
                {
                  yod.a("KEY_RED_POINT_TIME_" + localGameNoticeInfo.appId, l1);
                  if (!bbfd.a(BaseApplicationImpl.getApplication(), localGameNoticeInfo.packageName)) {
                    bich.a().a(9);
                  }
                }
              }
            }
          }
          if (l1 < localGameNoticeInfo.startTime)
          {
            if (!QLog.isColorLevel()) {
              break label931;
            }
            QLog.d("GameNoticeCenter", 1, new Object[] { "time miss, break! startTime=", a(localGameNoticeInfo.startTime) });
            localObject = null;
          }
        }
      }
    }
    for (;;)
    {
      label470:
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 2, "getting no banner to show");
        }
        a(true);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label929;
        }
        QLog.d("GameNoticeCenter", 2, "checkBanner end!!!");
        return;
        if (localGameNoticeInfo.shown)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("GameNoticeCenter", 2, "shown==true, continue! ");
          break;
        }
        if (localGameNoticeInfo.endTime < l1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 1, new Object[] { "time expired, continue! endTime=", a(localGameNoticeInfo.endTime) });
          }
          localGameNoticeInfo.shown = true;
          this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.updateDB(localGameNoticeInfo);
          break;
        }
        if (localGameNoticeInfo.bannerType == 1)
        {
          if (bbfd.a(BaseApplication.getContext(), localGameNoticeInfo.packageName)) {
            break;
          }
          localObject = localGameNoticeInfo;
          if (bbdj.a(localGameNoticeInfo.filePath)) {
            break label470;
          }
          break;
        }
        if ((localGameNoticeInfo.bannerType != 2) || (!bbfd.a(BaseApplication.getContext(), localGameNoticeInfo.packageName))) {
          break;
        }
        if (a(localGameNoticeInfo))
        {
          if (!QLog.isColorLevel()) {
            break label931;
          }
          QLog.d("GameNoticeCenter", 1, "request register info, break! ");
          localObject = null;
          break label470;
        }
        if (!TextUtils.isEmpty(localGameNoticeInfo.title))
        {
          localObject = localGameNoticeInfo;
          if (!TextUtils.isEmpty(localGameNoticeInfo.jumpUrl)) {
            break label470;
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GameNoticeCenter", 2, "title or jumpUrl is empty, break! ");
        break;
        if ((this.jdField_a_of_type_Aqrk != null) && (((GameNoticeInfo)localObject).equals(aqrk.a(this.jdField_a_of_type_Aqrk))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 2, new Object[] { "mCurrentBanner not changed, mCurrentBanner=", aqrk.a(this.jdField_a_of_type_Aqrk) });
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 1, new Object[] { "show banner=", localObject, ", hiding ", this.jdField_a_of_type_Aqrk });
          }
          a(false);
          this.jdField_a_of_type_Aqrk = new aqrk(this, (GameNoticeInfo)((GameNoticeInfo)localObject).clone());
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject instanceof QQAppInterface))
          {
            localObject = (QQAppInterface)localObject;
            aqrk.a(this.jdField_a_of_type_Aqrk, ahkf.a((QQAppInterface)localObject, 2, "com.tencent.mobileqq.gamecenter", aqrk.a(this.jdField_a_of_type_Aqrk).title, this.jdField_a_of_type_Aqrk));
            if (aqrk.a(this.jdField_a_of_type_Aqrk) == null) {
              a(false);
            }
          }
        }
      }
      label929:
      break;
      label931:
      localObject = null;
    }
  }
  
  /* Error */
  private final void d()
  {
    // Byte code:
    //   0: invokestatic 420	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: lload_1
    //   5: aload_0
    //   6: getfield 562	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:jdField_a_of_type_Long	J
    //   9: lsub
    //   10: ldc2_w 89
    //   13: lcmp
    //   14: ifle +42 -> 56
    //   17: aload_0
    //   18: lload_1
    //   19: putfield 562	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:jdField_a_of_type_Long	J
    //   22: new 564	aqrp
    //   25: dup
    //   26: invokestatic 361	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   29: invokespecial 567	aqrp:<init>	(Landroid/content/Context;)V
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload_0
    //   38: aload 4
    //   40: invokevirtual 570	aqrp:a	()Ljava/util/List;
    //   43: invokespecial 572	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:a	(Ljava/util/List;)V
    //   46: aload 4
    //   48: ifnull +8 -> 56
    //   51: aload 4
    //   53: invokevirtual 575	aqrp:close	()V
    //   56: return
    //   57: astore 5
    //   59: aconst_null
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: ldc 131
    //   67: iconst_1
    //   68: aload 5
    //   70: invokevirtual 578	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 4
    //   78: ifnull -22 -> 56
    //   81: aload 4
    //   83: invokevirtual 575	aqrp:close	()V
    //   86: return
    //   87: astore_3
    //   88: return
    //   89: astore 4
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 575	aqrp:close	()V
    //   101: aload 4
    //   103: athrow
    //   104: astore_3
    //   105: return
    //   106: astore_3
    //   107: goto -6 -> 101
    //   110: astore 4
    //   112: goto -19 -> 93
    //   115: astore 5
    //   117: goto -55 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	GameNoticeCenter
    //   3	16	1	l	long
    //   36	29	3	localaqrp1	aqrp
    //   87	1	3	localThrowable1	java.lang.Throwable
    //   92	6	3	localObject1	Object
    //   104	1	3	localThrowable2	java.lang.Throwable
    //   106	1	3	localThrowable3	java.lang.Throwable
    //   32	50	4	localaqrp2	aqrp
    //   89	13	4	localObject2	Object
    //   110	1	4	localObject3	Object
    //   57	12	5	localException1	java.lang.Exception
    //   115	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	34	57	java/lang/Exception
    //   81	86	87	java/lang/Throwable
    //   22	34	89	finally
    //   51	56	104	java/lang/Throwable
    //   97	101	106	java/lang/Throwable
    //   37	46	110	finally
    //   65	76	110	finally
    //   37	46	115	java/lang/Exception
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.initData();
      this.jdField_a_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(WadlResult paramWadlResult)
  {
    a(1, paramWadlResult);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    String str = paramJSONObject.optString("game_appid");
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        GameNoticeInfo localGameNoticeInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId(str);
        if (localGameNoticeInfo != null)
        {
          if (paramJSONObject.optInt("registered", 0) == 1)
          {
            localGameNoticeInfo.registered = bool;
            long l1 = paramJSONObject.optLong("bar_delay");
            long l2 = paramJSONObject.optLong("bar_interval");
            yod.a("MILLISECONDS_DELAY", l1);
            yod.a("MILLISECONDS_INTERVAL", l2);
            if (QLog.isColorLevel()) {
              QLog.d("GameNoticeCenter", 2, new Object[] { "parseGameRegisterInfo, ", localGameNoticeInfo, ", data:" + paramJSONObject.toString() });
            }
            this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.updateDB(localGameNoticeInfo);
            c();
          }
        }
        else {
          QLog.e("GameNoticeCenter", 1, new Object[] { "parseGameRegisterInfo, GameNoticeInfo for ", str, " not found!" });
        }
      }
      bool = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "checkBannerFromResume mInit=" + this.jdField_a_of_type_Boolean + ",mCheckBannerPosted=" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(WadlResult paramWadlResult)
  {
    a(2, paramWadlResult);
  }
  
  public void c(WadlResult paramWadlResult)
  {
    a(3, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter
 * JD-Core Version:    0.7.0.1
 */