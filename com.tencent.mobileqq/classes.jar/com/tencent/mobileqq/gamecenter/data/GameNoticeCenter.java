package com.tencent.mobileqq.gamecenter.data;

import aacs;
import aact;
import aadd;
import ajbm;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import ashe;
import ashf;
import ashl;
import awbx;
import bdcs;
import bdem;
import bdpx;
import bkeu;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class GameNoticeCenter
  implements aacs
{
  private static final Comparator<GameNoticeInfo> jdField_a_of_type_JavaUtilComparator = new ashe();
  private final int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private ashf jdField_a_of_type_Ashf;
  private GameNoticeCenter.GameNoticeInfoList jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GameNoticeCenter.1(this);
  private Date jdField_a_of_type_JavaUtilDate = new Date();
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int jdField_b_of_type_Int = 2;
  private Runnable jdField_b_of_type_JavaLangRunnable = new GameNoticeCenter.4(this);
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int c = 3;
  
  public GameNoticeCenter(QQAppInterface paramQQAppInterface)
  {
    GameCenterReceiver.a();
    GameCenterReceiver.a(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList = new GameNoticeCenter.GameNoticeInfoList(this, paramQQAppInterface.getEntityManagerFactory().createEntityManager());
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300000L);
  }
  
  private aadd a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      localObject = new aadd((AppInterface)localObject);
      ((aadd)localObject).f("4").g("430").a("817");
      return localObject;
    }
  }
  
  private Date a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilDate.setTime(paramLong);
    return this.jdField_a_of_type_JavaUtilDate;
  }
  
  private void a(int paramInt, WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null)) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Ashf != null) && (ashf.a(this.jdField_a_of_type_Ashf) != null) && (paramWadlResult.a.a.equals(ashf.a(this.jdField_a_of_type_Ashf).appId)))
      {
        int i = 0;
        if (paramInt == 1)
        {
          paramInt = i;
          if (ashf.a(this.jdField_a_of_type_Ashf).bannerType != 1) {}
        }
        for (paramInt = 1; paramInt != 0; paramInt = 1)
        {
          paramWadlResult = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId(ashf.a(this.jdField_a_of_type_Ashf).appId);
          if (paramWadlResult != null)
          {
            paramWadlResult.shown = true;
            this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.updateDB(paramWadlResult);
          }
          a(true);
          return;
        }
      }
    }
  }
  
  private void a(List<ashl> paramList)
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
      localObject2 = (ashl)((Iterator)localObject1).next();
      bool = i | a((ashl)localObject2);
      i = bool;
      if (!TextUtils.isEmpty(((ashl)localObject2).a))
      {
        i = bool;
        if (!paramList.contains(((ashl)localObject2).a))
        {
          paramList.add(((ashl)localObject2).a);
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
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.sort();
    }
    QLog.d("GameNoticeCenter", 1, new Object[] { "handleTaskInfos end, remains ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.size()) });
    GameNoticeCenter.GameNoticeInfoList.access$100(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, new Object[] { "hideBanner: ", this.jdField_a_of_type_Ashf, ", sendMessage=", Boolean.valueOf(paramBoolean) });
    }
    if (this.jdField_a_of_type_Ashf != null)
    {
      if (paramBoolean)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          ajbm.a((QQAppInterface)localAppRuntime, ashf.a(this.jdField_a_of_type_Ashf));
        }
      }
      this.jdField_a_of_type_Ashf = null;
    }
  }
  
  private boolean a(ashl paramashl)
  {
    Object localObject = paramashl.a;
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId((String)localObject);
    switch (paramashl.d)
    {
    case 7: 
    case 8: 
    default: 
      if (localObject != null)
      {
        QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo(remove), ", paramashl });
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.remove(localObject);
        QLog.d("GameNoticeCenter", 1, new Object[] { "remove GameNoticeInfo: ", localObject });
        return true;
      }
      break;
    case 6: 
    case 9: 
    case 10: 
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, new Object[] { "processTaskInfo(add), ", paramashl });
      }
      if ((localObject != null) && ((((GameNoticeInfo)localObject).bannerType != GameNoticeInfo.convertToBannerType(paramashl)) || (((GameNoticeInfo)localObject).createTime != paramashl.c)))
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
        paramashl = new GameNoticeInfo(paramashl, BaseApplication.getContext());
        if (paramashl.isValid())
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.add(paramashl);
          QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo: add GameNoticeInfo: ", paramashl });
          return true;
        }
        QLog.e("GameNoticeCenter", 1, new Object[] { "processTaskInfo: invalid GameNoticeInfo: ", paramashl });
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
        ((bdpx)((QQAppInterface)localAppRuntime).a(71)).g(paramGameNoticeInfo.appId);
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
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList == null) {
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
              long l2 = aact.a("KEY_RED_POINT_TIME_" + localGameNoticeInfo.appId);
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
                  aact.a("KEY_RED_POINT_TIME_" + localGameNoticeInfo.appId, l1);
                  if (!bdem.a(BaseApplicationImpl.getApplication(), localGameNoticeInfo.packageName)) {
                    bkeu.a().a(9);
                  }
                }
              }
            }
          }
          if (l1 < localGameNoticeInfo.startTime)
          {
            if (!QLog.isColorLevel()) {
              break label924;
            }
            QLog.d("GameNoticeCenter", 1, new Object[] { "time miss, break! startTime=", a(localGameNoticeInfo.startTime) });
            localObject = null;
          }
        }
      }
    }
    for (;;)
    {
      label463:
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
          break label922;
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
          if (bdem.a(BaseApplication.getContext(), localGameNoticeInfo.packageName)) {
            break;
          }
          localObject = localGameNoticeInfo;
          if (bdcs.a(localGameNoticeInfo.filePath)) {
            break label463;
          }
          break;
        }
        if ((localGameNoticeInfo.bannerType != 2) || (!bdem.a(BaseApplication.getContext(), localGameNoticeInfo.packageName))) {
          break;
        }
        if (a(localGameNoticeInfo))
        {
          if (!QLog.isColorLevel()) {
            break label924;
          }
          QLog.d("GameNoticeCenter", 1, "request register info, break! ");
          localObject = null;
          break label463;
        }
        if (!TextUtils.isEmpty(localGameNoticeInfo.title))
        {
          localObject = localGameNoticeInfo;
          if (!TextUtils.isEmpty(localGameNoticeInfo.jumpUrl)) {
            break label463;
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GameNoticeCenter", 2, "title or jumpUrl is empty, break! ");
        break;
        if ((this.jdField_a_of_type_Ashf != null) && (((GameNoticeInfo)localObject).equals(ashf.a(this.jdField_a_of_type_Ashf))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 2, new Object[] { "mCurrentBanner not changed, mCurrentBanner=", ashf.a(this.jdField_a_of_type_Ashf) });
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 1, new Object[] { "show banner=", localObject, ", hiding ", this.jdField_a_of_type_Ashf });
          }
          a(false);
          this.jdField_a_of_type_Ashf = new ashf(this, (GameNoticeInfo)((GameNoticeInfo)localObject).clone());
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject instanceof QQAppInterface))
          {
            localObject = (QQAppInterface)localObject;
            ashf.a(this.jdField_a_of_type_Ashf, ajbm.a((QQAppInterface)localObject, 2, "com.tencent.mobileqq.gamecenter", ashf.a(this.jdField_a_of_type_Ashf).title, this.jdField_a_of_type_Ashf));
            if (ashf.a(this.jdField_a_of_type_Ashf) == null) {
              a(false);
            }
          }
        }
      }
      label922:
      break;
      label924:
      localObject = null;
    }
  }
  
  /* Error */
  private final void d()
  {
    // Byte code:
    //   0: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: lload_1
    //   5: aload_0
    //   6: getfield 547	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:jdField_a_of_type_Long	J
    //   9: lsub
    //   10: ldc2_w 95
    //   13: lcmp
    //   14: ifle +42 -> 56
    //   17: aload_0
    //   18: lload_1
    //   19: putfield 547	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:jdField_a_of_type_Long	J
    //   22: new 549	ashk
    //   25: dup
    //   26: invokestatic 350	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   29: invokespecial 552	ashk:<init>	(Landroid/content/Context;)V
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload_0
    //   38: aload 4
    //   40: invokevirtual 555	ashk:a	()Ljava/util/List;
    //   43: invokespecial 557	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:a	(Ljava/util/List;)V
    //   46: aload 4
    //   48: ifnull +8 -> 56
    //   51: aload 4
    //   53: invokevirtual 560	ashk:close	()V
    //   56: return
    //   57: astore 5
    //   59: aconst_null
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: ldc 234
    //   67: iconst_1
    //   68: aload 5
    //   70: invokevirtual 563	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokestatic 565	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 4
    //   78: ifnull -22 -> 56
    //   81: aload 4
    //   83: invokevirtual 560	ashk:close	()V
    //   86: return
    //   87: astore_3
    //   88: return
    //   89: astore 4
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 560	ashk:close	()V
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
    //   36	29	3	localashk1	ashk
    //   87	1	3	localThrowable1	java.lang.Throwable
    //   92	6	3	localObject1	Object
    //   104	1	3	localThrowable2	java.lang.Throwable
    //   106	1	3	localThrowable3	java.lang.Throwable
    //   32	50	4	localashk2	ashk
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
    int i;
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label52;
      }
      i = 1;
      if (i == 0) {
        break label57;
      }
      ThreadManagerV2.excute(new GameNoticeCenter.2(this), 16, null, true);
    }
    for (;;)
    {
      ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label52:
      i = 0;
      break;
      label57:
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.initData();
    }
  }
  
  public void a(WadlResult paramWadlResult)
  {
    a(1, paramWadlResult);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("game_appid");
    GameNoticeInfo localGameNoticeInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId(str);
    if (localGameNoticeInfo != null)
    {
      if (paramJSONObject.optInt("registered", 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localGameNoticeInfo.registered = bool;
        long l1 = paramJSONObject.optLong("bar_delay");
        long l2 = paramJSONObject.optLong("bar_interval");
        aact.a("MILLISECONDS_DELAY", l1);
        aact.a("MILLISECONDS_INTERVAL", l2);
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 2, new Object[] { "parseGameRegisterInfo, ", localGameNoticeInfo, ", data:" + paramJSONObject.toString() });
        }
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.updateDB(localGameNoticeInfo);
        c();
        return;
      }
    }
    QLog.e("GameNoticeCenter", 1, new Object[] { "parseGameRegisterInfo, GameNoticeInfo for ", str, " not found!" });
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "checkBannerFromResume mInit=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ",mCheckBannerPosted=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    while (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i != 0; i = 0)
    {
      ThreadManagerV2.excute(this.jdField_b_of_type_JavaLangRunnable, 16, null, true);
      return;
    }
    this.jdField_b_of_type_JavaLangRunnable.run();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter
 * JD-Core Version:    0.7.0.1
 */