import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.3;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.4;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class pmz
{
  private owx jdField_a_of_type_Owx;
  private pnb jdField_a_of_type_Pnb;
  
  public pmz(pnb parampnb)
  {
    this.jdField_a_of_type_Pnb = parampnb;
  }
  
  private long a()
  {
    if ((d()) && (this.jdField_a_of_type_Pnb.a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)this.jdField_a_of_type_Pnb.a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        long l = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l;
        }
      }
    }
    return -1L;
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new RIJDataFetchManager.1(paramInt), 3000L);
  }
  
  private void a(int paramInt, List<Long> paramList, pnb parampnb)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      a(pvj.a().a(Integer.valueOf(parampnb.d()), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = pkh.a();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            parampnb.a().setNoMoreData(true);
          }
        }
      }
      Object localObject2;
      StringBuilder localStringBuilder;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = pvj.a().a(parampnb.d(), ((Long)localObject1).longValue());
        localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label316;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = pqu.a((String)localObject1);
        localStringBuilder = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label323;
        }
      }
      label316:
      label323:
      for (Object localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("RIJDataFetchManager_" + parampnb.d(), 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label361;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject2 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("RIJDataFetchManager_" + parampnb.d(), 1, ((StringBuilder)localObject1).toString());
      label361:
      paramList = pvj.a().a();
      if (paramList != null) {
        parampnb.a().a(paramList.a(parampnb.d()), parampnb.a(), parampnb.a(), parampnb.d(), parampnb.a());
      }
    }
  }
  
  private void a(int paramInt, @NotNull pnd parampnd, @NotNull List<puz> paramList)
  {
    Object localObject;
    if (parampnd.jdField_a_of_type_AndroidUtilPair == null)
    {
      localObject = null;
      if (parampnd.jdField_a_of_type_AndroidUtilPair != null) {
        break label85;
      }
    }
    label85:
    for (String str1 = null;; str1 = (String)parampnd.jdField_a_of_type_AndroidUtilPair.second)
    {
      if (this.jdField_a_of_type_Pnb.d() != 70) {
        break label100;
      }
      pvj.a().a(true, parampnd.jdField_a_of_type_JavaLangString);
      qdx.a().a(true);
      this.jdField_a_of_type_Pnb.a().setNoMoreData(false);
      this.jdField_a_of_type_Pnb.a().setCurrentStatus(1);
      return;
      localObject = parampnd.jdField_a_of_type_AndroidUtilPair.first;
      break;
    }
    label100:
    if ((this.jdField_a_of_type_Pnb.c() == 6) || (this.jdField_a_of_type_Pnb.c() == 7)) {
      parampnd.jdField_a_of_type_Int |= 0x800;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("FeedsRefreshType", this.jdField_a_of_type_Pnb.c());
    pvj localpvj = pvj.a();
    int i = this.jdField_a_of_type_Pnb.d();
    List localList = parampnd.jdField_a_of_type_JavaUtilList;
    int j = parampnd.jdField_b_of_type_Int;
    boolean bool = parampnd.jdField_a_of_type_Boolean;
    int k = this.jdField_a_of_type_Pnb.b();
    String str2;
    if ((localObject instanceof String))
    {
      str2 = (String)localObject;
      if (!(localObject instanceof Long)) {
        break label299;
      }
    }
    label299:
    for (long l = ((Long)localObject).longValue();; l = -1L)
    {
      localpvj.a(i, localList, j, true, bool, k, str2, l, str1, a(), parampnd.jdField_a_of_type_Long, parampnd.jdField_b_of_type_Long, parampnd.jdField_a_of_type_JavaLangString, paramInt, parampnd.jdField_b_of_type_Boolean, parampnd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo, parampnd.jdField_a_of_type_Int, paramList, b(), localBundle);
      return;
      str2 = null;
      break;
    }
  }
  
  private void a(Intent paramIntent)
  {
    int i = 2;
    QLog.d("RIJDataFetchManager", 1, "back from readInJoyList");
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      i = 1;
    }
    ArticleInfo localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
    if (localArticleInfo != null)
    {
      k();
      this.jdField_a_of_type_Owx = new owx();
      this.jdField_a_of_type_Owx.a(new pna(this, localArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Owx, 7, true, localArticleInfo, 1, i);
      return;
    }
    QLog.e("RIJDataFetchManager", 1, "handleMainFeedCommentRequest articleInfo is NULL");
  }
  
  private void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull KandianMergeManager paramKandianMergeManager, @NotNull pnd parampnd)
  {
    if ((this.jdField_a_of_type_Pnb.d() == 0) || (this.jdField_a_of_type_Pnb.d() == qez.a())) {
      b(parampnd, paramKandianMergeManager);
    }
    for (;;)
    {
      a(parampnd);
      return;
      if ((a()) && (!this.jdField_a_of_type_Pnb.f())) {
        b(parampnd, paramQQAppInterface);
      } else if (this.jdField_a_of_type_Pnb.d() == 70) {
        d(parampnd);
      } else if ((this.jdField_a_of_type_Pnb.d() == 56) && (this.jdField_a_of_type_Pnb.b() == 1001L)) {
        a(parampnd, paramKandianMergeManager);
      } else if (this.jdField_a_of_type_Pnb.d() == 40677) {
        a(parampnd, paramQQAppInterface);
      }
    }
  }
  
  private void a(@NotNull pnd parampnd)
  {
    if (this.jdField_a_of_type_Pnb.d() == 40830) {
      c(parampnd);
    }
    long l;
    ArticleInfo localArticleInfo;
    do
    {
      do
      {
        return;
        if (plm.c(this.jdField_a_of_type_Pnb.d()))
        {
          b(parampnd);
          return;
        }
        l = a();
      } while (this.jdField_a_of_type_Pnb.a() == null);
      localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Pnb.a().b(0);
    } while ((l == -1L) || (localArticleInfo == null) || (l == localArticleInfo.mArticleID));
    parampnd.jdField_a_of_type_JavaUtilList = new ArrayList();
    parampnd.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
    parampnd.jdField_b_of_type_Int = 6;
  }
  
  private void a(pnd parampnd, KandianMergeManager paramKandianMergeManager)
  {
    parampnd.jdField_a_of_type_Int |= 0x2;
    KandianRedDotInfo localKandianRedDotInfo = paramKandianMergeManager.c();
    if (localKandianRedDotInfo != null)
    {
      if (!localKandianRedDotInfo.hasArticleID()) {
        break label79;
      }
      parampnd.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
      parampnd.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      parampnd.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
      parampnd.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
      parampnd.jdField_b_of_type_Int = 1;
    }
    label79:
    for (parampnd.jdField_a_of_type_Int |= 0x8;; parampnd.jdField_a_of_type_Int |= 0x4)
    {
      paramKandianMergeManager.n();
      return;
    }
  }
  
  private void a(@NotNull pnd parampnd, @NotNull KandianMergeManager paramKandianMergeManager, @NotNull List<puz> paramList)
  {
    if (c())
    {
      paramList.addAll(paramKandianMergeManager.b());
      parampnd.jdField_a_of_type_Int |= 0x80;
    }
    if (rbi.a().a()) {
      parampnd.jdField_a_of_type_Int |= 0x1000;
    }
  }
  
  private void a(pnd parampnd, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (pws)paramQQAppInterface.getManager(QQManagerFactory.WEISHI_MANAGER);
    if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().size() > 0))
    {
      parampnd.jdField_a_of_type_JavaUtilList = new ArrayList(paramQQAppInterface.a());
      parampnd.jdField_b_of_type_Int = 8;
      if (!TextUtils.isEmpty(paramQQAppInterface.a())) {
        parampnd.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      }
    }
    paramQQAppInterface.a(this.jdField_a_of_type_Pnb.a());
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 70) && (paramInt != 56) && (paramInt != 40677) && (!plm.c(paramInt));
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Pnb.a() != null)
    {
      Intent localIntent = this.jdField_a_of_type_Pnb.a().getIntent();
      if (localIntent != null)
      {
        paramBoolean = bool;
        if (localIntent.getIntExtra("launch_from", 0) == 15) {
          paramBoolean = true;
        }
        return paramBoolean;
      }
    }
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool5 = h();
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((BaseActivity)this.jdField_a_of_type_Pnb.a()).app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    long l;
    boolean bool3;
    label109:
    boolean bool2;
    label135:
    boolean bool1;
    boolean bool4;
    if (this.jdField_a_of_type_Pnb.d() == 70)
    {
      l = ((Integer)bmhv.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
      if (plm.a(this.jdField_a_of_type_Pnb.d())) {
        l = b();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Pnb.a().d <= l) {
        break label517;
      }
      bool3 = true;
      boolean bool6 = g();
      if ((!a()) || (this.jdField_a_of_type_Pnb.f())) {
        break label523;
      }
      bool2 = true;
      bool1 = ((Boolean)bmhv.a("key_sp_entrance_follow", Boolean.valueOf(false))).booleanValue();
      if (bool1) {
        bmhv.a("key_sp_entrance_follow", Boolean.valueOf(false));
      }
      if ((!bmhv.m()) || (this.jdField_a_of_type_Pnb.d() != 56) || (this.jdField_a_of_type_Pnb.b() != 1001L) || (!localKandianMergeManager.g())) {
        break label529;
      }
      bool4 = true;
      label209:
      boolean bool7 = a(this.jdField_a_of_type_Pnb.e());
      this.jdField_a_of_type_Pnb.c(bool7);
      if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!this.jdField_a_of_type_Pnb.e()) && (!bool1)) {
        break label535;
      }
      bool1 = true;
      label277:
      QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pnb.d(), 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
      if (!e()) {
        break label545;
      }
      bool3 = oqy.c(this.jdField_a_of_type_Pnb.d());
      if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!paramBoolean2)) {
        break label540;
      }
      bool1 = true;
      QLog.d("RIJDataFetchManager", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(paramBoolean2) }));
    }
    label517:
    label523:
    label529:
    label535:
    label540:
    label545:
    while (!a(this.jdField_a_of_type_Pnb.d())) {
      for (;;)
      {
        return bool1;
        l = 300000L;
        break;
        bool3 = false;
        break label109;
        bool2 = false;
        break label135;
        bool4 = false;
        break label209;
        bool1 = false;
        break label277;
        bool1 = false;
      }
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (d()) {
      return a(paramBoolean2, paramBoolean3);
    }
    return b(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  private long b()
  {
    long l2 = 9223372036854775807L;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(161);
    long l1 = l2;
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("is_auto_refresh", 0);
      int j = localAladdinConfig.getIntegerFromString("daily_refresh_interval", 0);
      QLog.d("RIJDataFetchManager", 1, new Object[] { "getDailyRefreshTimeLimit, isAutoRefresh = ", Integer.valueOf(i), ", refreshInterval = ", Integer.valueOf(j) });
      l1 = l2;
      if (i == 1) {
        l1 = j * 60 * 1000;
      }
    }
    QLog.d("RIJDataFetchManager", 1, new Object[] { "getDailyRefreshTimeLimit, res = ", Long.valueOf(l1) });
    return l1;
  }
  
  private List<qxr> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Pnb.d() == 56)
    {
      qxr localqxr = new qxr();
      localqxr.jdField_a_of_type_JavaLangString = "com.tencent.weishi";
      localqxr.jdField_a_of_type_Boolean = bhfn.a(this.jdField_a_of_type_Pnb.a(), localqxr.jdField_a_of_type_JavaLangString);
      localArrayList.add(localqxr);
    }
    return localArrayList;
  }
  
  private void b(@NotNull pnd parampnd)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.jdField_a_of_type_Pnb.a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if ((localKandianRedDotInfo != null) && (!localKandianRedDotInfo.shouldRemoveFloatingRedPntArticleId()))
    {
      parampnd.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
      parampnd.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
      parampnd.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
      parampnd.jdField_b_of_type_Int = 1;
      parampnd.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      this.jdField_a_of_type_Pnb.a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void b(pnd parampnd, KandianMergeManager paramKandianMergeManager)
  {
    int k = 1;
    if (this.jdField_a_of_type_Pnb.a().jdField_a_of_type_Boolean)
    {
      parampnd.jdField_a_of_type_JavaUtilList = a();
      parampnd.jdField_a_of_type_Boolean = f();
      this.jdField_a_of_type_Pnb.a().jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Pnb.a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label350;
      }
    }
    label350:
    for (boolean bool = true;; bool = false)
    {
      parampnd.jdField_b_of_type_Boolean = bool;
      parampnd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = ((LebaKDCellInfo)this.jdField_a_of_type_Pnb.a().getIntent().getSerializableExtra("param_leba_cell_articleinfo"));
      if (parampnd.jdField_a_of_type_JavaUtilList != null) {
        break label394;
      }
      parampnd.jdField_a_of_type_JavaUtilList = paramKandianMergeManager.a();
      if ((parampnd.jdField_a_of_type_JavaUtilList != null) && (parampnd.jdField_a_of_type_JavaUtilList.size() > 2))
      {
        parampnd.jdField_a_of_type_Long = ((Long)parampnd.jdField_a_of_type_JavaUtilList.get(parampnd.jdField_a_of_type_JavaUtilList.size() - 2)).longValue();
        parampnd.jdField_b_of_type_Long = ((Long)parampnd.jdField_a_of_type_JavaUtilList.get(parampnd.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
        parampnd.jdField_a_of_type_JavaUtilList = parampnd.jdField_a_of_type_JavaUtilList.subList(0, parampnd.jdField_a_of_type_JavaUtilList.size() - 2);
        parampnd.jdField_b_of_type_Int = 1;
        parampnd.jdField_a_of_type_JavaLangString = paramKandianMergeManager.a();
      }
      if (!b()) {
        break;
      }
      Object localObject = paramKandianMergeManager.a();
      if (localObject == null) {
        break;
      }
      ArrayList localArrayList = ((KandianRedDotInfo)localObject).articleIDList;
      i = k;
      if (localArrayList == null) {
        break label358;
      }
      i = k;
      if (localArrayList.size() <= 0) {
        break label358;
      }
      parampnd.jdField_a_of_type_JavaUtilList = new ArrayList();
      parampnd.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject).cookie;
      int j = localArrayList.size() - 1;
      for (;;)
      {
        i = k;
        if (j < 0) {
          break;
        }
        localObject = (Long)localArrayList.get(j);
        parampnd.jdField_a_of_type_JavaUtilList.add(0, localObject);
        j -= 1;
      }
    }
    int i = 0;
    label358:
    paramKandianMergeManager.g();
    paramKandianMergeManager.f();
    for (;;)
    {
      parampnd.jdField_a_of_type_AndroidUtilPair = paramKandianMergeManager.a();
      paramKandianMergeManager.l();
      if (i != 0) {
        parampnd.jdField_a_of_type_Int |= 0x20;
      }
      return;
      label394:
      i = 0;
    }
  }
  
  private void b(pnd parampnd, QQAppInterface paramQQAppInterface)
  {
    long l = this.jdField_a_of_type_Pnb.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    boolean bool = this.jdField_a_of_type_Pnb.a().a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
    this.jdField_a_of_type_Pnb.b(true);
    this.jdField_a_of_type_Pnb.a(true);
    Object localObject;
    JSONObject localJSONObject;
    if (bool)
    {
      localObject = (ArticleInfo)this.jdField_a_of_type_Pnb.a().a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
      if (localObject != null)
      {
        parampnd.jdField_a_of_type_AndroidUtilPair = new Pair(((ArticleInfo)localObject).getInnerUniqueID(), ((ArticleInfo)localObject).mTitle);
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("ArticleId", prg.a(((ArticleInfo)localObject).mArticleID));
        localJSONObject.put("FeedsId", prg.a(((ArticleInfo)localObject).mFeedId));
        localJSONObject.put("algorithmIds", 0);
        localJSONObject.put("biuUin", 0);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("socialFeedsType", 1);
        localJSONObject.put("extension", localObject);
        localJSONObject.put("feedsType", 1);
        localJSONObject.put("id", 0);
        localJSONObject.put("network_type", 1);
        localJSONObject.put("orange", "");
        localJSONObject.put("pushMessage", "");
        localJSONObject.put("push_type", 0);
        localJSONObject.put("strategyIds", 0);
        localJSONObject.put("title", "");
        localJSONObject.put("uin", paramQQAppInterface.getLongAccountUin());
        parampnd.jdField_a_of_type_JavaLangString = localJSONObject.toString();
        parampnd.jdField_b_of_type_Int = 5;
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        parampnd.jdField_a_of_type_JavaLangString = null;
        continue;
      }
      parampnd.jdField_a_of_type_JavaUtilList = new ArrayList();
      parampnd.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
    }
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    qep localqep = pvj.a().a();
    if (localqep != null)
    {
      localqep.a().b(paramInt);
      localqep.a().a();
      bool = true;
    }
    return bool;
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = ((BaseActivity)this.jdField_a_of_type_Pnb.a()).app;
    Object localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    boolean bool1;
    boolean bool4;
    long l;
    label67:
    int i;
    label90:
    boolean bool5;
    boolean bool3;
    label135:
    int j;
    label175:
    boolean bool6;
    if (bmhv.a((QQAppInterface)localObject1))
    {
      bool1 = ((KandianMergeManager)localObject2).b();
      bool4 = this.jdField_a_of_type_Pnb.a() instanceof ReadInJoyNewFeedsActivity;
      if (!bool4) {
        break label383;
      }
      l = bmhv.g((AppRuntime)localObject1);
      if (System.currentTimeMillis() - this.jdField_a_of_type_Pnb.a().c <= l) {
        break label393;
      }
      i = 1;
      localObject1 = this.jdField_a_of_type_Pnb.a().getIntent();
      bool5 = ((Intent)localObject1).getBooleanExtra("from_search", false);
      if ((!c()) || (!((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
        break label399;
      }
      bool3 = true;
      if (c()) {
        ((Intent)localObject1).removeExtra("force_refresh");
      }
      if (this.jdField_a_of_type_Pnb.a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label405;
      }
      j = 1;
      if (!e()) {
        break label417;
      }
      bool6 = oqy.c(this.jdField_a_of_type_Pnb.d());
      if ((!paramBoolean2) && (!bool1) && (!bool5) && (!bool6) && (j == 0) && (!bool3) && (!paramBoolean3)) {
        break label411;
      }
    }
    label393:
    label399:
    label405:
    label411:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("RIJDataFetchManager", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, isLastExitChannelOverTimeLimit=%s, isInMessageKandian=%s, fromDaily=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(paramBoolean3) }));
      paramBoolean3 = bool2;
      int k = 1;
      j = k;
      if (i != 0)
      {
        j = k;
        if (paramBoolean1) {
          j = 6;
        }
      }
      if (paramBoolean3) {
        pno.a(j);
      }
      return paramBoolean3;
      localObject2 = a();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      label383:
      l = bmhv.f((AppRuntime)localObject1);
      break label67;
      i = 0;
      break label90;
      bool3 = false;
      break label135;
      j = 0;
      break label175;
    }
    label417:
    if ((paramBoolean2) || (bool1) || (bool5) || ((i != 0) && (paramBoolean1)) || (j != 0) || (bool3))
    {
      paramBoolean3 = true;
      label452:
      if ((i == 0) || (!paramBoolean1)) {
        break label545;
      }
    }
    label545:
    for (bool2 = true;; bool2 = false)
    {
      QLog.d("RIJDataFetchManager", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
      break;
      paramBoolean3 = false;
      break label452;
    }
  }
  
  private void c(pnd parampnd)
  {
    Intent localIntent = this.jdField_a_of_type_Pnb.a().getIntent();
    if (localIntent != null)
    {
      ReadInJoyChannelActivity.SerializableMap localSerializableMap = (ReadInJoyChannelActivity.SerializableMap)localIntent.getSerializableExtra("channel_map_data");
      if (localSerializableMap != null)
      {
        Long localLong = (Long)localSerializableMap.getMap().remove("articleID");
        if (localLong != null)
        {
          parampnd.jdField_a_of_type_JavaUtilList = new ArrayList();
          parampnd.jdField_a_of_type_JavaUtilList.add(localLong);
          localIntent.putExtra("channel_map_data", localSerializableMap);
        }
        parampnd.jdField_b_of_type_Int = 9;
        parampnd.jdField_a_of_type_JavaLangString = ((String)localSerializableMap.getMap().get("pushContext"));
      }
    }
  }
  
  private void d(pnd parampnd)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.jdField_a_of_type_Pnb.a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if (localKandianRedDotInfo != null)
    {
      parampnd.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      this.jdField_a_of_type_Pnb.a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void e(List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_Pnb.d() == 0) || (this.jdField_a_of_type_Pnb.d() == 70) || (plm.c(this.jdField_a_of_type_Pnb.d()))))
    {
      this.jdField_a_of_type_Pnb.b(NetConnInfoCenter.getServerTime());
      this.jdField_a_of_type_Pnb.a(pvj.a().a(this.jdField_a_of_type_Pnb.d(), ((Long)paramList.get(0)).longValue()));
      paramList = (QQAppInterface)pkh.a();
      if ((this.jdField_a_of_type_Pnb.a() != null) && (paramList != null))
      {
        if (this.jdField_a_of_type_Pnb.d() != 0) {
          break label180;
        }
        paramList = uuc.b(paramList, this.jdField_a_of_type_Pnb.a());
        String str = uuc.a(this.jdField_a_of_type_Pnb.a());
        uuc.a(((BaseActivity)this.jdField_a_of_type_Pnb.a().a()).app, str, String.valueOf(this.jdField_a_of_type_Pnb.a()), paramList, false);
      }
    }
    label180:
    do
    {
      return;
      if (this.jdField_a_of_type_Pnb.d() == 70)
      {
        ((KandianSubscribeManager)paramList.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this.jdField_a_of_type_Pnb.a(), this.jdField_a_of_type_Pnb.a());
        return;
      }
    } while (!plm.c(this.jdField_a_of_type_Pnb.d()));
    ((KandianDailyManager)paramList.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(this.jdField_a_of_type_Pnb.a());
  }
  
  private boolean f()
  {
    List localList = (List)this.jdField_a_of_type_Pnb.a().a().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = ((Long)localList.get(0)).longValue(); Long.valueOf(l).longValue() != 0L; l = -1L) {
      return true;
    }
    return false;
  }
  
  private boolean g()
  {
    if ((d()) && (this.jdField_a_of_type_Pnb.a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)this.jdField_a_of_type_Pnb.a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean h()
  {
    Object localObject = ((BaseActivity)this.jdField_a_of_type_Pnb.a()).app;
    if ((this.jdField_a_of_type_Pnb.d() == 70) || (plm.c(this.jdField_a_of_type_Pnb.d()))) {
      return this.jdField_a_of_type_Pnb.a().getIntent().hasExtra("kandian_feeds_red_pnt_info");
    }
    if (this.jdField_a_of_type_Pnb.d() == 40677)
    {
      localObject = (pws)((QQAppInterface)localObject).getManager(QQManagerFactory.WEISHI_MANAGER);
      return (((pws)localObject).a() != null) && (((pws)localObject).a().size() > 0);
    }
    return this.jdField_a_of_type_Pnb.d() == 40830;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Owx != null) {
      this.jdField_a_of_type_Owx.a();
    }
  }
  
  private void l()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Pnb.a() != null) {}
    try
    {
      Parcelable localParcelable = ((pvp)pkh.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a(this.jdField_a_of_type_Pnb.d());
      if (localParcelable != null)
      {
        this.jdField_a_of_type_Pnb.a().onRestoreInstanceState(localParcelable);
        QLog.d("RIJDataFetchManager", 1, new Object[] { "channelID: ", Integer.valueOf(this.jdField_a_of_type_Pnb.d()), " restoreToHistoryPos." });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("RIJDataFetchManager", 1, "restoreToHistoryPos Exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJDataFetchManager", 2, new Object[] { "restoreToHistoryPos cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  private void m()
  {
    szd localszd = this.jdField_a_of_type_Pnb.a();
    if (localszd != null)
    {
      pne localpne = localszd.a();
      if (localpne != null)
      {
        localpne.a();
        localszd.notifyDataSetChanged();
        QLog.d("RIJDataFetchManager", 1, "clearListViewArticles!");
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Pnb.a() != -1) {
      return this.jdField_a_of_type_Pnb.a();
    }
    return this.jdField_a_of_type_Pnb.a().getIntent().getIntExtra("channel_type", 0);
  }
  
  public List<Long> a()
  {
    Intent localIntent = this.jdField_a_of_type_Pnb.a().a().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int i = localIntent.getIntExtra("channel_id", 0);
    if (this.jdField_a_of_type_Pnb.d() == i) {
      localList = (List)localIntent.getSerializableExtra("subscription_all_article_id");
    }
    if ((localLong.longValue() > 0L) && (localList != null) && (localList.size() > 0))
    {
      localList.remove(localLong);
      localList.add(0, localLong);
    }
    return localList;
  }
  
  public pnb a()
  {
    return this.jdField_a_of_type_Pnb;
  }
  
  public void a()
  {
    k();
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, Intent paramIntent)
  {
    if ((oww.a()) && (paramInt == 1699) && (owf.b(paramArticleInfo)) && (this.jdField_a_of_type_Pnb.d() == 0))
    {
      a(paramIntent);
      return;
    }
    pbq.a(((BaseActivity)this.jdField_a_of_type_Pnb.a()).app, paramIntent, paramInt);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_Pnb.d() == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        pbq.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        pbq.a(paramArticleInfo, paramString1);
        QQToast.a(this.jdField_a_of_type_Pnb.a(), 0, this.jdField_a_of_type_Pnb.a().getString(2131717660), 0).a();
        QLog.d("RIJDataFetchManager", 2, "onSubmitCommentResult succeed ");
      }
    }
    else {
      return;
    }
    QLog.d("RIJDataFetchManager", 2, "onSubmitCommentResult failed " + paramInt);
    QQToast.a(this.jdField_a_of_type_Pnb.a(), 1, paramString2, 0).a();
  }
  
  public void a(int paramInt, List<Long> paramList, pnc parampnc)
  {
    a(paramInt, paramList, this.jdField_a_of_type_Pnb);
    e(paramList);
    this.jdField_a_of_type_Pnb.a().jdField_b_of_type_Long = 0L;
    if (!this.jdField_a_of_type_Pnb.c())
    {
      bool = true;
      bool = a(bool, this.jdField_a_of_type_Pnb, parampnc);
      this.jdField_a_of_type_Pnb.f(bool);
      uky.a().a(this.jdField_a_of_type_Pnb.d(), bool);
      if (bool)
      {
        if (plm.c(paramInt)) {
          ujd.a.b();
        }
        if (paramInt == 0) {
          ujd.a.a();
        }
      }
      if (this.jdField_a_of_type_Pnb.a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label290;
      }
    }
    for (int i = 1;; i = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).f();
        if (paramInt <= 0) {
          break label350;
        }
        paramInt = 1;
      }
      catch (Exception parampnc)
      {
        for (;;)
        {
          label290:
          parampnc.printStackTrace();
          paramInt = 0;
          continue;
          bool = pqu.a(((ReadInJoyNewFeedsActivity)this.jdField_a_of_type_Pnb.a()).b());
          continue;
          bool = true;
          continue;
          if (this.jdField_a_of_type_Pnb.d() != 0)
          {
            l();
            continue;
            paramInt = 0;
          }
        }
      }
      if (!(this.jdField_a_of_type_Pnb.a() instanceof ReadInJoyNewFeedsActivity)) {
        break label327;
      }
      if (i == 0) {
        break label306;
      }
      bool = true;
      if ((!this.jdField_a_of_type_Pnb.b()) && (bool))
      {
        if ((i == 0) && (paramInt != 0)) {
          break label333;
        }
        l();
      }
      if (!this.jdField_a_of_type_Pnb.b()) {
        pmu.a(this.jdField_a_of_type_Pnb.a().b(0), this.jdField_a_of_type_Pnb.a());
      }
      if (!this.jdField_a_of_type_Pnb.c()) {
        this.jdField_a_of_type_Pnb.e(true);
      }
      a(paramList);
      g();
      if ((this.jdField_a_of_type_Pnb.d() == 0) && (rbi.a().b())) {
        f();
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void a(List<Long> paramList)
  {
    if ((this.jdField_a_of_type_Pnb.d() == 40677) && (paramList != null) && (!paramList.isEmpty()))
    {
      long l = NetConnInfoCenter.getServerTime();
      QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
      if (localQQAppInterface != null)
      {
        paramList = ((pvp)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a(this.jdField_a_of_type_Pnb.d(), ((Long)paramList.get(0)).longValue());
        if (paramList != null)
        {
          pws localpws = (pws)localQQAppInterface.getManager(QQManagerFactory.WEISHI_MANAGER);
          if (localpws != null) {
            localpws.a(uuc.a(localQQAppInterface, paramList), l);
          }
        }
      }
    }
  }
  
  public void a(List<BaseArticleInfo> paramList, int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_Pnb.a().a().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add((BaseArticleInfo)((Iterator)localObject2).next());
    }
    paramList = qeh.a().a(this.jdField_a_of_type_Pnb.d(), paramList, (List)localObject1, paramInt);
    if (paramList != null) {
      paramList = pwt.a.a(this.jdField_a_of_type_Pnb.a(), paramList);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Pnb.d() == 0) || (plm.b(plm.b()))) {
        this.jdField_a_of_type_Pnb.a().d(true);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("setAdapterData: srcData size ");
        if (paramList != null) {}
        for (paramInt = paramList.size();; paramInt = 0)
        {
          QLog.d("RIJDataFetchManager", 2, paramInt);
          if (paramList == null) {
            break;
          }
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (BaseArticleInfo)((Iterator)localObject1).next();
            if (localObject2 != null) {
              QLog.d("RIJDataFetchManager", 2, "setAdapterData: " + ((BaseArticleInfo)localObject2).mTitle + " type: " + ((BaseArticleInfo)localObject2).mFeedType);
            }
          }
        }
      }
      this.jdField_a_of_type_Pnb.a().a(paramList);
      this.jdField_a_of_type_Pnb.a().notifyDataSetChanged();
      this.jdField_a_of_type_Pnb.a().a(8);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    int k = 0;
    int i;
    int j;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0) && (paramInt == 56))
    {
      i = 0;
      for (paramInt = -1; i < this.jdField_a_of_type_Pnb.a().a().getChildCount(); paramInt = j)
      {
        Object localObject = this.jdField_a_of_type_Pnb.a().a().getChildAt(i);
        j = paramInt;
        if (localObject != null)
        {
          j = paramInt;
          if (((View)localObject).getTag() != null)
          {
            j = paramInt;
            if ((((View)localObject).getTag() instanceof sxh))
            {
              localObject = (sxh)((View)localObject).getTag();
              j = paramInt;
              if (paramLong == ((sxh)localObject).jdField_a_of_type_Spk.c) {
                j = ((sxh)localObject).jdField_a_of_type_Int;
              }
            }
          }
        }
        i += 1;
      }
      j = this.jdField_a_of_type_Pnb.a().a().getHeaderViewsCount();
      i = this.jdField_a_of_type_Pnb.a().a().getFirstVisiblePosition() - j;
      if (i >= 0) {
        break label405;
      }
      i = k;
    }
    label405:
    for (;;)
    {
      k = this.jdField_a_of_type_Pnb.a().a().getLastVisiblePosition() - j;
      if ((paramInt + 1 >= i) && (paramInt + 1 <= k))
      {
        this.jdField_a_of_type_Pnb.a().a(pvj.a().a(Integer.valueOf(this.jdField_a_of_type_Pnb.d()), paramList));
        this.jdField_a_of_type_Pnb.a().c(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_Pnb.a().a();
        if (paramList != null) {
          paramList.a(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RIJDataFetchManager", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + i + ", lastVisblePosi=" + k + "， headerCount=" + j);
        }
        return;
        this.jdField_a_of_type_Pnb.a().a(pvj.a().a(Integer.valueOf(this.jdField_a_of_type_Pnb.d()), paramList));
        this.jdField_a_of_type_Pnb.a().notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if ((paramBoolean1) && (paramList != null)) {
      a(pvj.a().a(Integer.valueOf(this.jdField_a_of_type_Pnb.d()), paramList), 2);
    }
    boolean bool1;
    label69:
    ReadInJoyXListView localReadInJoyXListView;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean1 = true;
      bool1 = paramBoolean1;
      if (this.jdField_a_of_type_Pnb.d() == 70)
      {
        if ((!paramBoolean1) && (!paramBoolean2)) {
          break label329;
        }
        paramBoolean1 = true;
        this.jdField_a_of_type_Pnb.a().jdField_b_of_type_Boolean = paramBoolean1;
        bool1 = paramBoolean1;
      }
      localReadInJoyXListView = this.jdField_a_of_type_Pnb.a();
      if (bool1) {
        break label334;
      }
    }
    label329:
    label334:
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      localReadInJoyXListView.a(paramBoolean1);
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.jdField_a_of_type_Pnb.b(NetConnInfoCenter.getServerTime());
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJDataFetchManager", 2, "autoLoad:" + this.jdField_a_of_type_Pnb.a() + " noMoreData:" + bool1 + " fore:" + GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_Pnb.a()));
      }
      if ((!this.jdField_a_of_type_Pnb.a()) && (bool1) && (GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_Pnb.a())) && (this.jdField_a_of_type_Pnb.d() != 70))
      {
        paramList = this.jdField_a_of_type_Pnb.a().getResources().getString(2131717598);
        QQToast.a(this.jdField_a_of_type_Pnb.a().getApplicationContext(), paramList, 0).a();
      }
      if ((plm.a(this.jdField_a_of_type_Pnb.d())) && ((this.jdField_a_of_type_Pnb.a() instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_Pnb.a()).g();
      }
      this.jdField_a_of_type_Pnb.g(false);
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
      break label69;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!pli.b()) {
      pvm.a().l();
    }
    this.jdField_a_of_type_Pnb.a().jdField_a_of_type_Long = System.currentTimeMillis();
    bmhv.a(this.jdField_a_of_type_Pnb.d(), this.jdField_a_of_type_Pnb.a().jdField_a_of_type_Long, (QQAppInterface)pkh.a());
    pnd localpnd = new pnd(null);
    Object localObject = ((BaseActivity)this.jdField_a_of_type_Pnb.a()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    a((QQAppInterface)localObject, localKandianMergeManager, localpnd);
    if (this.jdField_a_of_type_Pnb.a() != null) {
      this.jdField_a_of_type_Pnb.a().d(paramBoolean1);
    }
    localObject = new ArrayList();
    a(localpnd, localKandianMergeManager, (List)localObject);
    a(paramInt, localpnd, (List)localObject);
    this.jdField_a_of_type_Pnb.c(this.jdField_a_of_type_Pnb.b() + 1);
    uvs.a(paramInt, this.jdField_a_of_type_Pnb.d(), this.jdField_a_of_type_Pnb.a(), paramBoolean2, -this.jdField_a_of_type_Pnb.a().getScrollY());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Pnb.d() == 56) && (this.jdField_a_of_type_Pnb.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
  }
  
  public boolean a(boolean paramBoolean, pnb parampnb, pnc parampnc)
  {
    if ((parampnb.d() == 56) && (!parampnb.a().f())) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool;
    int i;
    if (parampnb.a().getCount() == 0)
    {
      bool = true;
      paramBoolean = a(paramBoolean, bool, oqy.a(parampnb.d()));
      QLog.i("RIJDataFetchManager", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
      if ((!paramBoolean) && (!qcr.a(parampnb.d()))) {
        break label161;
      }
      i = 1;
      label98:
      if (i == 0) {
        break label178;
      }
      if ((parampnb.d() == 0) || (plm.c(parampnb.d()))) {
        pwb.a().a.jdField_a_of_type_Boolean = true;
      }
      if ((!plm.c(parampnb.d())) || (plm.a())) {
        break label167;
      }
      b(true, 1, false);
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label161:
      i = 0;
      break label98;
      label167:
      parampnc.a(true, 2);
    }
    label178:
    parampnc = parampnb.a();
    if (parampnb.a().jdField_a_of_type_Long == 0L) {}
    for (;;)
    {
      parampnc.jdField_a_of_type_Long = l;
      return false;
      l = parampnb.a().jdField_a_of_type_Long;
    }
  }
  
  public void b()
  {
    boolean bool1;
    int i;
    label31:
    label37:
    Object localObject;
    if (this.jdField_a_of_type_Pnb.c() != 0)
    {
      bool1 = true;
      if ((pnn.a()) && (!d()) && (!bool1)) {
        break label112;
      }
      i = 1;
      if (i == 0) {
        break label117;
      }
      i = 3;
      if (this.jdField_a_of_type_Pnb.c() == 2) {
        break label208;
      }
      if (!(this.jdField_a_of_type_Pnb.a() instanceof ReadInJoyNewFeedsActivity)) {
        break label124;
      }
      localObject = (ReadInJoyNewFeedsActivity)this.jdField_a_of_type_Pnb.a();
      ((ReadInJoyNewFeedsActivity)localObject).g(1);
      if (this.jdField_a_of_type_Pnb.d() == 0) {
        ((ReadInJoyNewFeedsActivity)localObject).c(false);
      }
      label95:
      pno.a(3);
    }
    for (;;)
    {
      b(true, i, bool1);
      return;
      bool1 = false;
      break;
      label112:
      i = 0;
      break label31;
      label117:
      i = 1001;
      break label37;
      label124:
      if (!(this.jdField_a_of_type_Pnb.a() instanceof SplashActivity)) {
        break label95;
      }
      pvm.a().a(2, null);
      localObject = pqx.a(this.jdField_a_of_type_Pnb.a());
      boolean bool2 = pqt.a(this.jdField_a_of_type_Pnb.d(), this.jdField_a_of_type_Pnb.c());
      if ((localObject != null) && (bool2)) {
        ((ReadinjoyTabFrame)localObject).a(1);
      }
      if (this.jdField_a_of_type_Pnb.c() == 3) {
        break label95;
      }
      uvs.a(1);
      break label95;
      label208:
      if ((this.jdField_a_of_type_Pnb.a() instanceof SplashActivity)) {
        pvm.a().a(2, null);
      }
      i = 1;
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = b(paramInt);
    if (bool) {
      m();
    }
    QLog.d("RIJDataFetchManager", 1, "deleteArticleInStudyMode, hasCleared=" + bool);
  }
  
  public void b(List<Long> paramList)
  {
    Object localObject = pkh.a();
    if ((!bmhv.C((AppRuntime)localObject)) || (!bmhv.D((AppRuntime)localObject))) {}
    do
    {
      do
      {
        return;
      } while ((paramList == null) || (paramList.isEmpty()));
      int j = Math.min(paramList.size(), 5);
      localObject = new ArrayList();
      int i = 0;
      while (i < j)
      {
        long l = ((Long)paramList.get(i)).longValue();
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Pnb.a().a(this.jdField_a_of_type_Pnb.d(), l);
        if ((localBaseArticleInfo != null) && (!pqw.a(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        i += 1;
      }
      paramList = pvj.a().a();
    } while (paramList == null);
    paramList.a((List)localObject);
  }
  
  public void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Activity localActivity = this.jdField_a_of_type_Pnb.a();
    if (plm.c(this.jdField_a_of_type_Pnb.d())) {}
    for (int i = 2;; i = 1)
    {
      uve.a(localActivity, i, new RIJDataFetchManager.3(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_Pnb.a().getIntent().getIntExtra("launch_from", -1);
    return (i == 9) || (i == 6);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Pnb.a() != null) {
      try
      {
        if ((bmhv.m()) && ((this.jdField_a_of_type_Pnb.a().a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_Pnb.a().onSaveInstanceState();
        pvp localpvp = (pvp)pkh.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        localpvp.a().a(this.jdField_a_of_type_Pnb.d(), localParcelable);
        localpvp.a().g(this.jdField_a_of_type_Pnb.a().getPaddingTop());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("RIJDataFetchManager", 1, "updateLeaveChannelPosInfo Exception.");
      }
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Pnb.d() == 0) && (paramInt != 2))
    {
      if (bmhv.w()) {
        pvj.a().a().a();
      }
    }
    else {
      return;
    }
    pvm.a().g(2);
  }
  
  public void c(List<Long> paramList)
  {
    if ((!udj.a.a()) || (!udj.a.c()) || (!udj.a.e())) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        int j = Math.min(paramList.size(), 4);
        int i = 0;
        while (i < j)
        {
          long l = ((Long)paramList.get(i)).longValue();
          BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Pnb.a().a(this.jdField_a_of_type_Pnb.d(), l);
          if (localBaseArticleInfo != null) {
            udf.a.a(localBaseArticleInfo);
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Pnb.a().getIntent().getIntExtra("launch_from", -1) == 13;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Pnb.d() == 56)
    {
      this.jdField_a_of_type_Pnb.b(false);
      this.jdField_a_of_type_Pnb.a(false);
      this.jdField_a_of_type_Pnb.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Pnb.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Pnb.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_Pnb.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  public void d(int paramInt)
  {
    qfg localqfg = ((pvp)pkh.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
    if (localqfg != null) {
      localqfg.b(paramInt);
    }
  }
  
  public void d(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int j = this.jdField_a_of_type_Pnb.a().a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_Pnb.a().a(j, l);
          if ((localObject != null) && (!pqw.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!pqw.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Pnb.a().a(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (aars.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Pnb.d() != 0;
  }
  
  public void e()
  {
    if ((d()) && (g()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Pnb.a().b(0);
      if (localArticleInfo != null) {
        pvj.a().a(this.jdField_a_of_type_Pnb.d(), localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Pnb.a() instanceof SplashActivity;
  }
  
  public void f()
  {
    if ((rbi.a().a()) && (this.jdField_a_of_type_Pnb.a().getFirstVisiblePosition() == 0) && (!this.jdField_a_of_type_Pnb.d()))
    {
      b(true, 0, false);
      this.jdField_a_of_type_Pnb.d(true);
      return;
    }
    rbi.a().a();
  }
  
  public void g()
  {
    if (a())
    {
      if (this.jdField_a_of_type_Pnb.a().a().getIntent().getIntExtra("channel_from", 0) != 1004) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pnb.d(), 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
      }
    }
    label71:
    label751:
    label758:
    for (;;)
    {
      return;
      long l = this.jdField_a_of_type_Pnb.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int i = this.jdField_a_of_type_Pnb.a().a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_Pnb.a().a();
      if ((i == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label758;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = pvj.a().a(Integer.valueOf(56));
        List localList = this.jdField_a_of_type_Pnb.a().a();
        if ((localList == null) || (localList.isEmpty()) || (localObject2 == null) || (((List)localObject2).isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pnb.d(), 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
          return;
        }
        if (((List)localObject2).contains(Long.valueOf(l)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pnb.d(), 2, "handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =" + localObject1);
          }
          localObject2 = pvj.a().b(Integer.valueOf(56));
          if (localObject2 == null) {
            break label751;
          }
          Iterator localIterator = ((List)localObject2).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (ArticleInfo)localIterator.next();
          } while (((ArticleInfo)localObject2).mArticleID != l);
        }
        for (;;)
        {
          if (localObject2 != null)
          {
            pvj.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
            boolean bool = localList.remove(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pnb.d(), 2, "delete duplicateArticleInfo: " + localObject2 + ", deleteDuplicateSuccess= " + bool);
            }
          }
          l = ((BaseArticleInfo)localList.get(0)).mRecommendSeq;
          localArticleInfo.mRecommendSeq = (1L + l);
          localArticleInfo.mChannelID = 56L;
          if (localArticleInfo.isTwoItemVideoFeed()) {
            localArticleInfo.mSubArtilceList = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pnb.d(), 2, "handleJump2VideoChannelForceInsert(): sourceArticleInfo =" + localObject1 + ",firtstArticleSeq=" + l + "， insert cloneInfo=" + localArticleInfo);
          }
          localObject1 = new ArrayList();
          ((List)localObject1).add(localArticleInfo);
          pvj.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_Pnb.a().notifyDataSetChanged();
          this.jdField_a_of_type_Pnb.a().setAdapter(this.jdField_a_of_type_Pnb.a());
          if (this.jdField_a_of_type_Pnb.a().a() == null) {}
          for (i = 0;; i = 1)
          {
            this.jdField_a_of_type_Pnb.a().setSelectionFromTop(i, 0);
            this.jdField_a_of_type_Pnb.a().b(this.jdField_a_of_type_Pnb.a(), szd.jdField_b_of_type_Int);
            return;
          }
          localObject2 = null;
        }
      }
    }
  }
  
  public void h()
  {
    ThreadManager.executeOnSubThread(new RIJDataFetchManager.4(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_Pnb.a().jdField_b_of_type_Long = System.currentTimeMillis();
    if (d())
    {
      if (this.jdField_a_of_type_Pnb.d() == 56) {
        this.jdField_a_of_type_Pnb.a().d = bmhv.a((QQAppInterface)pkh.a(), this.jdField_a_of_type_Pnb.a());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Pnb.a().d = bmhv.a((QQAppInterface)pkh.a(), this.jdField_a_of_type_Pnb.d());
  }
  
  public void j()
  {
    if (d())
    {
      if (this.jdField_a_of_type_Pnb.d() == 56) {
        bmhv.a((QQAppInterface)pkh.a(), System.currentTimeMillis(), this.jdField_a_of_type_Pnb.a());
      }
    }
    else {
      return;
    }
    bmhv.a((QQAppInterface)pkh.a(), System.currentTimeMillis(), this.jdField_a_of_type_Pnb.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmz
 * JD-Core Version:    0.7.0.1
 */