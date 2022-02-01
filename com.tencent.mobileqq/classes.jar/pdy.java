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
import org.json.JSONException;
import org.json.JSONObject;

public class pdy
{
  private ooz jdField_a_of_type_Ooz;
  private pea jdField_a_of_type_Pea;
  
  public pdy(pea parampea)
  {
    this.jdField_a_of_type_Pea = parampea;
  }
  
  private long a()
  {
    if ((d()) && (this.jdField_a_of_type_Pea.a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)this.jdField_a_of_type_Pea.a().getIntent().getSerializableExtra("channel_map_data");
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
  
  private void a(int paramInt, List<Long> paramList, pea parampea)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      a(pkm.a().a(Integer.valueOf(parampea.d()), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = pay.a();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(162)).a();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            parampea.a().setNoMoreData(true);
          }
        }
      }
      Object localObject2;
      StringBuilder localStringBuilder;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = pkm.a().a(parampea.d(), ((Long)localObject1).longValue());
        localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label316;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = pay.d((String)localObject1);
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
        QLog.d("RIJDataFetchManager_" + parampea.d(), 1, (String)localObject1);
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
      QLog.d("RIJDataFetchManager_" + parampea.d(), 1, ((StringBuilder)localObject1).toString());
      label361:
      paramList = pkm.a().a();
      if (paramList != null) {
        parampea.a().a(paramList.a(parampea.d()), parampea.a(), parampea.a(), parampea.d(), parampea.a());
      }
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
      this.jdField_a_of_type_Ooz = new ooz();
      this.jdField_a_of_type_Ooz.a(new pdz(this, localArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Ooz, 7, true, localArticleInfo, 1, i);
      return;
    }
    QLog.e("RIJDataFetchManager", 1, "handleMainFeedCommentRequest articleInfo is NULL");
  }
  
  private void a(pec parampec)
  {
    Intent localIntent = this.jdField_a_of_type_Pea.a().getIntent();
    if (localIntent != null)
    {
      ReadInJoyChannelActivity.SerializableMap localSerializableMap = (ReadInJoyChannelActivity.SerializableMap)localIntent.getSerializableExtra("channel_map_data");
      if (localSerializableMap != null)
      {
        Long localLong = (Long)localSerializableMap.getMap().remove("articleID");
        if (localLong != null)
        {
          parampec.jdField_a_of_type_JavaUtilList = new ArrayList();
          parampec.jdField_a_of_type_JavaUtilList.add(localLong);
          localIntent.putExtra("channel_map_data", localSerializableMap);
        }
        parampec.jdField_b_of_type_Int = 9;
        parampec.jdField_a_of_type_JavaLangString = ((String)localSerializableMap.getMap().get("pushContext"));
      }
    }
  }
  
  private void a(pec parampec, KandianMergeManager paramKandianMergeManager)
  {
    parampec.jdField_a_of_type_Int |= 0x2;
    KandianRedDotInfo localKandianRedDotInfo = paramKandianMergeManager.c();
    if (localKandianRedDotInfo != null)
    {
      if (!localKandianRedDotInfo.hasArticleID()) {
        break label79;
      }
      parampec.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
      parampec.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      parampec.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
      parampec.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
      parampec.jdField_b_of_type_Int = 1;
    }
    label79:
    for (parampec.jdField_a_of_type_Int |= 0x8;; parampec.jdField_a_of_type_Int |= 0x4)
    {
      paramKandianMergeManager.n();
      return;
    }
  }
  
  private void a(pec parampec, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (plv)paramQQAppInterface.getManager(274);
    if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().size() > 0))
    {
      parampec.jdField_a_of_type_JavaUtilList = new ArrayList(paramQQAppInterface.a());
      parampec.jdField_b_of_type_Int = 8;
      if (!TextUtils.isEmpty(paramQQAppInterface.a())) {
        parampec.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      }
    }
    paramQQAppInterface.a(this.jdField_a_of_type_Pea.a());
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 70) && (paramInt != 56) && (paramInt != 40677) && (!pcl.c(paramInt));
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Pea.a() != null)
    {
      Intent localIntent = this.jdField_a_of_type_Pea.a().getIntent();
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
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((BaseActivity)this.jdField_a_of_type_Pea.a()).app.getManager(162);
    long l;
    boolean bool3;
    label109:
    boolean bool2;
    label135:
    boolean bool1;
    boolean bool4;
    if (this.jdField_a_of_type_Pea.d() == 70)
    {
      l = ((Integer)bkwm.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
      if (pcl.a(this.jdField_a_of_type_Pea.d())) {
        l = b();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Pea.a().d <= l) {
        break label516;
      }
      bool3 = true;
      boolean bool6 = g();
      if ((!a()) || (this.jdField_a_of_type_Pea.f())) {
        break label522;
      }
      bool2 = true;
      bool1 = ((Boolean)bkwm.a("key_sp_entrance_follow", Boolean.valueOf(false))).booleanValue();
      if (bool1) {
        bkwm.a("key_sp_entrance_follow", Boolean.valueOf(false));
      }
      if ((!bkwm.j()) || (this.jdField_a_of_type_Pea.d() != 56) || (this.jdField_a_of_type_Pea.b() != 1001L) || (!localKandianMergeManager.g())) {
        break label528;
      }
      bool4 = true;
      label209:
      boolean bool7 = a(this.jdField_a_of_type_Pea.e());
      this.jdField_a_of_type_Pea.c(bool7);
      if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!this.jdField_a_of_type_Pea.e()) && (!bool1)) {
        break label534;
      }
      bool1 = true;
      label277:
      QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pea.d(), 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
      if (!e()) {
        break label544;
      }
      bool3 = ojc.c(this.jdField_a_of_type_Pea.d());
      if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!paramBoolean2)) {
        break label539;
      }
      bool1 = true;
      QLog.d("RIJDataFetchManager", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(paramBoolean2) }));
    }
    label516:
    label522:
    label528:
    label534:
    label539:
    label544:
    while (!a(this.jdField_a_of_type_Pea.d())) {
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
  
  private void b(pec parampec)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.jdField_a_of_type_Pea.a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if (localKandianRedDotInfo != null)
    {
      parampec.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      this.jdField_a_of_type_Pea.a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void b(pec parampec, KandianMergeManager paramKandianMergeManager)
  {
    int k = 1;
    if (this.jdField_a_of_type_Pea.a().jdField_a_of_type_Boolean)
    {
      parampec.jdField_a_of_type_JavaUtilList = a();
      parampec.jdField_a_of_type_Boolean = f();
      this.jdField_a_of_type_Pea.a().jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Pea.a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label350;
      }
    }
    label350:
    for (boolean bool = true;; bool = false)
    {
      parampec.jdField_b_of_type_Boolean = bool;
      parampec.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = ((LebaKDCellInfo)this.jdField_a_of_type_Pea.a().getIntent().getSerializableExtra("param_leba_cell_articleinfo"));
      if (parampec.jdField_a_of_type_JavaUtilList != null) {
        break label398;
      }
      parampec.jdField_a_of_type_JavaUtilList = paramKandianMergeManager.a();
      if ((parampec.jdField_a_of_type_JavaUtilList != null) && (parampec.jdField_a_of_type_JavaUtilList.size() > 2))
      {
        parampec.jdField_a_of_type_Long = ((Long)parampec.jdField_a_of_type_JavaUtilList.get(parampec.jdField_a_of_type_JavaUtilList.size() - 2)).longValue();
        parampec.jdField_b_of_type_Long = ((Long)parampec.jdField_a_of_type_JavaUtilList.get(parampec.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
        parampec.jdField_a_of_type_JavaUtilList = parampec.jdField_a_of_type_JavaUtilList.subList(0, parampec.jdField_a_of_type_JavaUtilList.size() - 2);
        parampec.jdField_b_of_type_Int = 1;
        parampec.jdField_a_of_type_JavaLangString = paramKandianMergeManager.a();
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
      parampec.jdField_a_of_type_JavaUtilList = new ArrayList();
      parampec.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject).cookie;
      int j = localArrayList.size() - 1;
      for (;;)
      {
        i = k;
        if (j < 0) {
          break;
        }
        localObject = (Long)localArrayList.get(j);
        parampec.jdField_a_of_type_JavaUtilList.add(0, localObject);
        j -= 1;
      }
    }
    int i = 0;
    label358:
    paramKandianMergeManager.g();
    paramKandianMergeManager.f();
    for (;;)
    {
      parampec.jdField_a_of_type_AndroidUtilPair = paramKandianMergeManager.a();
      paramKandianMergeManager.l();
      if (i != 0)
      {
        parampec.jdField_a_of_type_Int |= 0x20;
        pay.a(false);
      }
      return;
      label398:
      i = 0;
    }
  }
  
  private void b(pec parampec, QQAppInterface paramQQAppInterface)
  {
    long l = this.jdField_a_of_type_Pea.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    boolean bool = this.jdField_a_of_type_Pea.a().a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
    this.jdField_a_of_type_Pea.b(true);
    this.jdField_a_of_type_Pea.a(true);
    Object localObject;
    JSONObject localJSONObject;
    if (bool)
    {
      localObject = (ArticleInfo)this.jdField_a_of_type_Pea.a().a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
      if (localObject != null)
      {
        parampec.jdField_a_of_type_AndroidUtilPair = new Pair(((ArticleInfo)localObject).getInnerUniqueID(), ((ArticleInfo)localObject).mTitle);
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("ArticleId", pay.a(((ArticleInfo)localObject).mArticleID));
        localJSONObject.put("FeedsId", pay.a(((ArticleInfo)localObject).mFeedId));
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
        parampec.jdField_a_of_type_JavaLangString = localJSONObject.toString();
        parampec.jdField_b_of_type_Int = 5;
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        parampec.jdField_a_of_type_JavaLangString = null;
        continue;
      }
      parampec.jdField_a_of_type_JavaUtilList = new ArrayList();
      parampec.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
    }
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = ((BaseActivity)this.jdField_a_of_type_Pea.a()).app;
    Object localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(162);
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
    if (bkwm.a((QQAppInterface)localObject1))
    {
      bool1 = ((KandianMergeManager)localObject2).b();
      bool4 = this.jdField_a_of_type_Pea.a() instanceof ReadInJoyNewFeedsActivity;
      if (!bool4) {
        break label382;
      }
      l = bkwm.g((AppRuntime)localObject1);
      if (System.currentTimeMillis() - this.jdField_a_of_type_Pea.a().c <= l) {
        break label392;
      }
      i = 1;
      localObject1 = this.jdField_a_of_type_Pea.a().getIntent();
      bool5 = ((Intent)localObject1).getBooleanExtra("from_search", false);
      if ((!c()) || (!((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
        break label398;
      }
      bool3 = true;
      if (c()) {
        ((Intent)localObject1).removeExtra("force_refresh");
      }
      if (this.jdField_a_of_type_Pea.a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label404;
      }
      j = 1;
      if (!e()) {
        break label416;
      }
      bool6 = ojc.c(this.jdField_a_of_type_Pea.d());
      if ((!paramBoolean2) && (!bool1) && (!bool5) && (!bool6) && (j == 0) && (!bool3) && (!paramBoolean3)) {
        break label410;
      }
    }
    label392:
    label398:
    label404:
    label410:
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
        pay.b(j);
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
      label382:
      l = bkwm.f((AppRuntime)localObject1);
      break label67;
      i = 0;
      break label90;
      bool3 = false;
      break label135;
      j = 0;
      break label175;
    }
    label416:
    if ((paramBoolean2) || (bool1) || (bool5) || ((i != 0) && (paramBoolean1)) || (j != 0) || (bool3))
    {
      paramBoolean3 = true;
      label451:
      if ((i == 0) || (!paramBoolean1)) {
        break label543;
      }
    }
    label543:
    for (bool2 = true;; bool2 = false)
    {
      QLog.d("RIJDataFetchManager", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
      break;
      paramBoolean3 = false;
      break label451;
    }
  }
  
  private void d(List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_Pea.d() == 0) || (this.jdField_a_of_type_Pea.d() == 70) || (pcl.c(this.jdField_a_of_type_Pea.d()))))
    {
      this.jdField_a_of_type_Pea.b(NetConnInfoCenter.getServerTime());
      this.jdField_a_of_type_Pea.a(pkm.a().a(this.jdField_a_of_type_Pea.d(), ((Long)paramList.get(0)).longValue()));
      paramList = (QQAppInterface)pay.a();
      if ((this.jdField_a_of_type_Pea.a() != null) && (paramList != null))
      {
        if (this.jdField_a_of_type_Pea.d() != 0) {
          break label180;
        }
        paramList = ugf.b(paramList, this.jdField_a_of_type_Pea.a());
        String str = ugf.a(this.jdField_a_of_type_Pea.a());
        ugf.a(((BaseActivity)this.jdField_a_of_type_Pea.a().a()).app, str, String.valueOf(this.jdField_a_of_type_Pea.a()), paramList, false);
      }
    }
    label180:
    do
    {
      return;
      if (this.jdField_a_of_type_Pea.d() == 70)
      {
        ((KandianSubscribeManager)paramList.getManager(280)).a(this.jdField_a_of_type_Pea.a(), this.jdField_a_of_type_Pea.a());
        return;
      }
    } while (!pcl.c(this.jdField_a_of_type_Pea.d()));
    ((KandianDailyManager)paramList.getManager(296)).a(this.jdField_a_of_type_Pea.a());
  }
  
  private boolean f()
  {
    List localList = (List)this.jdField_a_of_type_Pea.a().a().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = ((Long)localList.get(0)).longValue(); Long.valueOf(l).longValue() != 0L; l = -1L) {
      return true;
    }
    return false;
  }
  
  private boolean g()
  {
    if ((d()) && (this.jdField_a_of_type_Pea.a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)this.jdField_a_of_type_Pea.a().getIntent().getSerializableExtra("channel_map_data");
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
    Object localObject = ((BaseActivity)this.jdField_a_of_type_Pea.a()).app;
    if ((this.jdField_a_of_type_Pea.d() == 70) || (pcl.c(this.jdField_a_of_type_Pea.d()))) {
      return this.jdField_a_of_type_Pea.a().getIntent().hasExtra("kandian_feeds_red_pnt_info");
    }
    if (this.jdField_a_of_type_Pea.d() == 40677)
    {
      localObject = (plv)((QQAppInterface)localObject).getManager(274);
      return (((plv)localObject).a() != null) && (((plv)localObject).a().size() > 0);
    }
    return this.jdField_a_of_type_Pea.d() == 40830;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Ooz != null) {
      this.jdField_a_of_type_Ooz.a();
    }
  }
  
  private void l()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Pea.a() != null) {}
    try
    {
      Parcelable localParcelable = ((pks)pay.a().getManager(163)).a().a(this.jdField_a_of_type_Pea.d());
      if (localParcelable != null)
      {
        this.jdField_a_of_type_Pea.a().onRestoreInstanceState(localParcelable);
        QLog.d("RIJDataFetchManager", 1, new Object[] { "channelID: ", Integer.valueOf(this.jdField_a_of_type_Pea.d()), " restoreToHistoryPos." });
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
  
  public int a()
  {
    if (this.jdField_a_of_type_Pea.a() != -1) {
      return this.jdField_a_of_type_Pea.a();
    }
    return this.jdField_a_of_type_Pea.a().getIntent().getIntExtra("channel_type", 0);
  }
  
  public List<Long> a()
  {
    Intent localIntent = this.jdField_a_of_type_Pea.a().a().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int i = localIntent.getIntExtra("channel_id", 0);
    if (this.jdField_a_of_type_Pea.d() == i) {
      localList = (List)localIntent.getSerializableExtra("subscription_all_article_id");
    }
    if ((localLong.longValue() > 0L) && (localList != null) && (localList.size() > 0))
    {
      localList.remove(localLong);
      localList.add(0, localLong);
    }
    return localList;
  }
  
  public pea a()
  {
    return this.jdField_a_of_type_Pea;
  }
  
  public void a()
  {
    k();
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, Intent paramIntent)
  {
    if ((ooy.a()) && (paramInt == 1699) && (ooh.b(paramArticleInfo)) && (this.jdField_a_of_type_Pea.d() == 0))
    {
      a(paramIntent);
      return;
    }
    oto.a(((BaseActivity)this.jdField_a_of_type_Pea.a()).app, paramIntent, paramInt);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_Pea.d() == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        oto.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        oto.a(paramArticleInfo, paramString1);
        QQToast.a(this.jdField_a_of_type_Pea.a(), 0, this.jdField_a_of_type_Pea.a().getString(2131717294), 0).a();
        QLog.d("RIJDataFetchManager", 2, "onSubmitCommentResult succeed ");
      }
    }
    else {
      return;
    }
    QLog.d("RIJDataFetchManager", 2, "onSubmitCommentResult failed " + paramInt);
    QQToast.a(this.jdField_a_of_type_Pea.a(), 1, paramString2, 0).a();
  }
  
  public void a(int paramInt, List<Long> paramList, peb parampeb)
  {
    a(paramInt, paramList, this.jdField_a_of_type_Pea);
    d(paramList);
    this.jdField_a_of_type_Pea.a().jdField_b_of_type_Long = 0L;
    if (!this.jdField_a_of_type_Pea.c())
    {
      bool = true;
      bool = a(bool, this.jdField_a_of_type_Pea, parampeb);
      this.jdField_a_of_type_Pea.f(bool);
      twx.a().a(this.jdField_a_of_type_Pea.d(), bool);
      if (bool)
      {
        if (pcl.c(paramInt)) {
          tvd.a.b();
        }
        if (paramInt == 0) {
          tvd.a.a();
        }
      }
      if (this.jdField_a_of_type_Pea.a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label290;
      }
    }
    for (int i = 1;; i = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)pay.a().getManager(162)).f();
        if (paramInt <= 0) {
          break label350;
        }
        paramInt = 1;
      }
      catch (Exception parampeb)
      {
        for (;;)
        {
          label290:
          parampeb.printStackTrace();
          paramInt = 0;
          continue;
          bool = pay.b(((ReadInJoyNewFeedsActivity)this.jdField_a_of_type_Pea.a()).b());
          continue;
          bool = true;
          continue;
          if (this.jdField_a_of_type_Pea.d() != 0)
          {
            l();
            continue;
            paramInt = 0;
          }
        }
      }
      if (!(this.jdField_a_of_type_Pea.a() instanceof ReadInJoyNewFeedsActivity)) {
        break label327;
      }
      if (i == 0) {
        break label306;
      }
      bool = true;
      if ((!this.jdField_a_of_type_Pea.b()) && (bool))
      {
        if ((i == 0) && (paramInt != 0)) {
          break label333;
        }
        l();
      }
      if (!this.jdField_a_of_type_Pea.b()) {
        pdt.a(this.jdField_a_of_type_Pea.a().b(0), this.jdField_a_of_type_Pea.a());
      }
      if (!this.jdField_a_of_type_Pea.c()) {
        this.jdField_a_of_type_Pea.e(true);
      }
      a(paramList);
      g();
      if ((this.jdField_a_of_type_Pea.d() == 0) && (qpd.a().b())) {
        f();
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void a(List<Long> paramList)
  {
    if ((this.jdField_a_of_type_Pea.d() == 40677) && (paramList != null) && (!paramList.isEmpty()))
    {
      long l = NetConnInfoCenter.getServerTime();
      QQAppInterface localQQAppInterface = (QQAppInterface)pay.a();
      if (localQQAppInterface != null)
      {
        paramList = ((pks)localQQAppInterface.getManager(163)).a().a(this.jdField_a_of_type_Pea.d(), ((Long)paramList.get(0)).longValue());
        if (paramList != null)
        {
          plv localplv = (plv)localQQAppInterface.getManager(274);
          if (localplv != null) {
            localplv.a(ugf.a(localQQAppInterface, paramList), l);
          }
        }
      }
    }
  }
  
  public void a(List<BaseArticleInfo> paramList, int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_Pea.a().a().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add((BaseArticleInfo)((Iterator)localObject2).next());
    }
    paramList = ptk.a().a(this.jdField_a_of_type_Pea.d(), paramList, (List)localObject1, paramInt);
    if (paramList != null) {
      paramList = plw.a.a(this.jdField_a_of_type_Pea.a(), paramList);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Pea.d() == 0) || (pcl.b(pcl.b()))) {
        this.jdField_a_of_type_Pea.a().d(true);
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
      this.jdField_a_of_type_Pea.a().a(paramList);
      this.jdField_a_of_type_Pea.a().notifyDataSetChanged();
      this.jdField_a_of_type_Pea.a().a(8);
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
      for (paramInt = -1; i < this.jdField_a_of_type_Pea.a().a().getChildCount(); paramInt = j)
      {
        Object localObject = this.jdField_a_of_type_Pea.a().a().getChildAt(i);
        j = paramInt;
        if (localObject != null)
        {
          j = paramInt;
          if (((View)localObject).getTag() != null)
          {
            j = paramInt;
            if ((((View)localObject).getTag() instanceof sjy))
            {
              localObject = (sjy)((View)localObject).getTag();
              j = paramInt;
              if (paramLong == ((sjy)localObject).jdField_a_of_type_Sdg.c) {
                j = ((sjy)localObject).jdField_a_of_type_Int;
              }
            }
          }
        }
        i += 1;
      }
      j = this.jdField_a_of_type_Pea.a().a().getHeaderViewsCount();
      i = this.jdField_a_of_type_Pea.a().a().getFirstVisiblePosition() - j;
      if (i >= 0) {
        break label404;
      }
      i = k;
    }
    label404:
    for (;;)
    {
      k = this.jdField_a_of_type_Pea.a().a().getLastVisiblePosition() - j;
      if ((paramInt + 1 >= i) && (paramInt + 1 <= k))
      {
        this.jdField_a_of_type_Pea.a().a(pkm.a().a(Integer.valueOf(this.jdField_a_of_type_Pea.d()), paramList));
        this.jdField_a_of_type_Pea.a().c(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_Pea.a().a();
        if (paramList != null) {
          paramList.a(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RIJDataFetchManager", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + i + ", lastVisblePosi=" + k + "， headerCount=" + j);
        }
        return;
        this.jdField_a_of_type_Pea.a().a(pkm.a().a(Integer.valueOf(this.jdField_a_of_type_Pea.d()), paramList));
        this.jdField_a_of_type_Pea.a().notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if ((paramBoolean1) && (paramList != null)) {
      a(pkm.a().a(Integer.valueOf(this.jdField_a_of_type_Pea.d()), paramList), 2);
    }
    boolean bool1;
    label69:
    ReadInJoyXListView localReadInJoyXListView;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean1 = true;
      bool1 = paramBoolean1;
      if (this.jdField_a_of_type_Pea.d() == 70)
      {
        if ((!paramBoolean1) && (!paramBoolean2)) {
          break label328;
        }
        paramBoolean1 = true;
        this.jdField_a_of_type_Pea.a().jdField_b_of_type_Boolean = paramBoolean1;
        bool1 = paramBoolean1;
      }
      localReadInJoyXListView = this.jdField_a_of_type_Pea.a();
      if (bool1) {
        break label333;
      }
    }
    label328:
    label333:
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      localReadInJoyXListView.a(paramBoolean1);
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.jdField_a_of_type_Pea.b(NetConnInfoCenter.getServerTime());
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJDataFetchManager", 2, "autoLoad:" + this.jdField_a_of_type_Pea.a() + " noMoreData:" + bool1 + " fore:" + GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_Pea.a()));
      }
      if ((!this.jdField_a_of_type_Pea.a()) && (bool1) && (GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_Pea.a())) && (this.jdField_a_of_type_Pea.d() != 70))
      {
        paramList = this.jdField_a_of_type_Pea.a().getResources().getString(2131717234);
        QQToast.a(this.jdField_a_of_type_Pea.a().getApplicationContext(), paramList, 0).a();
      }
      if ((pcl.a(this.jdField_a_of_type_Pea.d())) && ((this.jdField_a_of_type_Pea.a() instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_Pea.a()).g();
      }
      this.jdField_a_of_type_Pea.g(false);
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
      break label69;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!pch.b()) {
      pkp.a().l();
    }
    this.jdField_a_of_type_Pea.a().jdField_a_of_type_Long = System.currentTimeMillis();
    bkwm.a(this.jdField_a_of_type_Pea.d(), this.jdField_a_of_type_Pea.a().jdField_a_of_type_Long, (QQAppInterface)pay.a());
    pec localpec = new pec(null);
    Object localObject2 = ((BaseActivity)this.jdField_a_of_type_Pea.a()).app;
    Object localObject1 = (KandianMergeManager)((QQAppInterface)localObject2).getManager(162);
    label139:
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if ((this.jdField_a_of_type_Pea.d() == 0) || (this.jdField_a_of_type_Pea.d() == puf.a()))
    {
      b(localpec, (KandianMergeManager)localObject1);
      if (this.jdField_a_of_type_Pea.d() != 40830) {
        break label527;
      }
      a(localpec);
      if (this.jdField_a_of_type_Pea.a() != null) {
        this.jdField_a_of_type_Pea.a().d(paramBoolean1);
      }
      localArrayList1 = new ArrayList();
      if (c())
      {
        localArrayList1.addAll(((KandianMergeManager)localObject1).b());
        localpec.jdField_a_of_type_Int |= 0x80;
      }
      if (qpd.a().a()) {
        localpec.jdField_a_of_type_Int |= 0x1000;
      }
      localArrayList2 = new ArrayList();
      if (this.jdField_a_of_type_Pea.d() == 56)
      {
        localObject1 = new qlm();
        ((qlm)localObject1).jdField_a_of_type_JavaLangString = "com.tencent.weishi";
        ((qlm)localObject1).jdField_a_of_type_Boolean = bfwv.a(this.jdField_a_of_type_Pea.a(), ((qlm)localObject1).jdField_a_of_type_JavaLangString);
        localArrayList2.add(localObject1);
      }
      if (localpec.jdField_a_of_type_AndroidUtilPair != null) {
        break label734;
      }
      localObject1 = null;
      label305:
      if (localpec.jdField_a_of_type_AndroidUtilPair != null) {
        break label747;
      }
    }
    label527:
    label734:
    label747:
    for (localObject2 = null;; localObject2 = (String)localpec.jdField_a_of_type_AndroidUtilPair.second)
    {
      if (this.jdField_a_of_type_Pea.d() != 70) {
        break label763;
      }
      pkm.a().a(true, localpec.jdField_a_of_type_JavaLangString);
      pta.a().a(true);
      this.jdField_a_of_type_Pea.a().setNoMoreData(false);
      this.jdField_a_of_type_Pea.a().setCurrentStatus(1);
      this.jdField_a_of_type_Pea.c(this.jdField_a_of_type_Pea.b() + 1);
      uhv.a(paramInt, this.jdField_a_of_type_Pea.d(), this.jdField_a_of_type_Pea.a(), paramBoolean2, -this.jdField_a_of_type_Pea.a().getScrollY());
      return;
      if ((a()) && (!this.jdField_a_of_type_Pea.f()))
      {
        b(localpec, (QQAppInterface)localObject2);
        break;
      }
      if (this.jdField_a_of_type_Pea.d() == 70)
      {
        b(localpec);
        break;
      }
      if ((this.jdField_a_of_type_Pea.d() == 56) && (this.jdField_a_of_type_Pea.b() == 1001L))
      {
        a(localpec, (KandianMergeManager)localObject1);
        break;
      }
      if (this.jdField_a_of_type_Pea.d() != 40677) {
        break;
      }
      a(localpec, (QQAppInterface)localObject2);
      break;
      if (pcl.c(this.jdField_a_of_type_Pea.d()))
      {
        localObject2 = (KandianRedDotInfo)this.jdField_a_of_type_Pea.a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
        if ((localObject2 == null) || (((KandianRedDotInfo)localObject2).shouldRemoveFloatingRedPntArticleId())) {
          break label139;
        }
        localpec.jdField_a_of_type_Long = ((KandianRedDotInfo)localObject2).algorithmID;
        localpec.jdField_b_of_type_Long = ((KandianRedDotInfo)localObject2).strategyID;
        localpec.jdField_a_of_type_JavaUtilList = ((KandianRedDotInfo)localObject2).articleIDList;
        localpec.jdField_b_of_type_Int = 1;
        localpec.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject2).cookie;
        this.jdField_a_of_type_Pea.a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
        break label139;
      }
      l = a();
      if (this.jdField_a_of_type_Pea.a() == null) {
        break label139;
      }
      localObject2 = (ArticleInfo)this.jdField_a_of_type_Pea.a().b(0);
      if ((l == -1L) || (localObject2 == null) || (l == ((ArticleInfo)localObject2).mArticleID)) {
        break label139;
      }
      localpec.jdField_a_of_type_JavaUtilList = new ArrayList();
      localpec.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
      localpec.jdField_b_of_type_Int = 6;
      break label139;
      localObject1 = localpec.jdField_a_of_type_AndroidUtilPair.first;
      break label305;
    }
    label763:
    if ((this.jdField_a_of_type_Pea.c() == 6) || (this.jdField_a_of_type_Pea.c() == 7)) {
      localpec.jdField_a_of_type_Int |= 0x800;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("FeedsRefreshType", this.jdField_a_of_type_Pea.c());
    pkm localpkm = pkm.a();
    int i = this.jdField_a_of_type_Pea.d();
    List localList = localpec.jdField_a_of_type_JavaUtilList;
    int j = localpec.jdField_b_of_type_Int;
    paramBoolean1 = localpec.jdField_a_of_type_Boolean;
    int k = this.jdField_a_of_type_Pea.b();
    String str;
    if ((localObject1 instanceof String))
    {
      str = (String)localObject1;
      label883:
      if (!(localObject1 instanceof Long)) {
        break label972;
      }
    }
    label972:
    for (long l = ((Long)localObject1).longValue();; l = -1L)
    {
      localpkm.a(i, localList, j, true, paramBoolean1, k, str, l, (String)localObject2, a(), localpec.jdField_a_of_type_Long, localpec.jdField_b_of_type_Long, localpec.jdField_a_of_type_JavaLangString, paramInt, localpec.jdField_b_of_type_Boolean, localpec.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo, localpec.jdField_a_of_type_Int, localArrayList1, localArrayList2, localBundle);
      break;
      str = null;
      break label883;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Pea.d() == 56) && (this.jdField_a_of_type_Pea.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
  }
  
  public boolean a(boolean paramBoolean, pea parampea, peb parampeb)
  {
    if ((parampea.d() == 56) && (!parampea.a().f())) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool;
    int i;
    if (parampea.a().getCount() == 0)
    {
      bool = true;
      paramBoolean = a(paramBoolean, bool, ojc.a(parampea.d()));
      QLog.i("RIJDataFetchManager", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
      if ((!paramBoolean) && (!pru.a(parampea.d()))) {
        break label160;
      }
      i = 1;
      label97:
      if (i == 0) {
        break label177;
      }
      if ((parampea.d() == 0) || (pcl.c(parampea.d()))) {
        ple.a().a.jdField_a_of_type_Boolean = true;
      }
      if ((!pcl.c(parampea.d())) || (pcl.a())) {
        break label166;
      }
      b(true, 1, false);
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label160:
      i = 0;
      break label97;
      label166:
      parampeb.a(true, 2);
    }
    label177:
    parampeb = parampea.a();
    if (parampea.a().jdField_a_of_type_Long == 0L) {}
    for (;;)
    {
      parampeb.jdField_a_of_type_Long = l;
      return false;
      l = parampea.a().jdField_a_of_type_Long;
    }
  }
  
  public void b()
  {
    boolean bool1;
    int i;
    label31:
    label37:
    Object localObject;
    if (this.jdField_a_of_type_Pea.c() != 0)
    {
      bool1 = true;
      if ((pay.a()) && (!d()) && (!bool1)) {
        break label112;
      }
      i = 1;
      if (i == 0) {
        break label117;
      }
      i = 3;
      if (this.jdField_a_of_type_Pea.c() == 2) {
        break label208;
      }
      if (!(this.jdField_a_of_type_Pea.a() instanceof ReadInJoyNewFeedsActivity)) {
        break label124;
      }
      localObject = (ReadInJoyNewFeedsActivity)this.jdField_a_of_type_Pea.a();
      ((ReadInJoyNewFeedsActivity)localObject).g(1);
      if (this.jdField_a_of_type_Pea.d() == 0) {
        ((ReadInJoyNewFeedsActivity)localObject).c(false);
      }
      label95:
      pay.b(3);
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
      if (!(this.jdField_a_of_type_Pea.a() instanceof SplashActivity)) {
        break label95;
      }
      pkp.a().a(2, null);
      localObject = pay.a(this.jdField_a_of_type_Pea.a());
      boolean bool2 = pay.b(this.jdField_a_of_type_Pea.d(), this.jdField_a_of_type_Pea.c());
      if ((localObject != null) && (bool2)) {
        ((ReadinjoyTabFrame)localObject).a(1);
      }
      if (this.jdField_a_of_type_Pea.c() == 3) {
        break label95;
      }
      uhv.a(1);
      break label95;
      label208:
      if ((this.jdField_a_of_type_Pea.a() instanceof SplashActivity)) {
        pkp.a().a(2, null);
      }
      i = 1;
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Pea.d() == 0) && (paramInt != 2))
    {
      if (bkwm.t()) {
        pkm.a().a().a();
      }
    }
    else {
      return;
    }
    pkp.a().g(2);
  }
  
  public void b(List<Long> paramList)
  {
    Object localObject = pay.a();
    if ((!bkwm.C((AppRuntime)localObject)) || (!bkwm.D((AppRuntime)localObject))) {}
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
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Pea.a().a(this.jdField_a_of_type_Pea.d(), l);
        if ((localBaseArticleInfo != null) && (!pay.a(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        i += 1;
      }
      paramList = pkm.a().a();
    } while (paramList == null);
    paramList.a((List)localObject);
  }
  
  public void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Activity localActivity = this.jdField_a_of_type_Pea.a();
    if (pcl.c(this.jdField_a_of_type_Pea.d())) {}
    for (int i = 2;; i = 1)
    {
      uhh.a(localActivity, i, new RIJDataFetchManager.3(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_Pea.a().getIntent().getIntExtra("launch_from", -1);
    return (i == 9) || (i == 6);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Pea.a() != null) {
      try
      {
        if ((bkwm.j()) && ((this.jdField_a_of_type_Pea.a().a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_Pea.a().onSaveInstanceState();
        pks localpks = (pks)pay.a().getManager(163);
        localpks.a().a(this.jdField_a_of_type_Pea.d(), localParcelable);
        localpks.a().g(this.jdField_a_of_type_Pea.a().getPaddingTop());
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
    pum localpum = ((pks)pay.a().getManager(163)).a().a();
    if (localpum != null) {
      localpum.b(paramInt);
    }
  }
  
  public void c(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int j = this.jdField_a_of_type_Pea.a().a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_Pea.a().a(j, l);
          if ((localObject != null) && (!pay.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!pay.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Pea.a().a(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (aacg.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Pea.a().getIntent().getIntExtra("launch_from", -1) == 13;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Pea.d() == 56)
    {
      this.jdField_a_of_type_Pea.b(false);
      this.jdField_a_of_type_Pea.a(false);
      this.jdField_a_of_type_Pea.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Pea.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Pea.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_Pea.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Pea.d() != 0;
  }
  
  public void e()
  {
    if ((d()) && (g()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Pea.a().b(0);
      if (localArticleInfo != null) {
        pkm.a().a(this.jdField_a_of_type_Pea.d(), localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Pea.a() instanceof SplashActivity;
  }
  
  public void f()
  {
    if ((qpd.a().a()) && (this.jdField_a_of_type_Pea.a().getFirstVisiblePosition() == 0) && (!this.jdField_a_of_type_Pea.d()))
    {
      b(true, 0, false);
      this.jdField_a_of_type_Pea.d(true);
      return;
    }
    qpd.a().a();
  }
  
  public void g()
  {
    if (a())
    {
      if (this.jdField_a_of_type_Pea.a().a().getIntent().getIntExtra("channel_from", 0) != 1004) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pea.d(), 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
      }
    }
    label71:
    label751:
    label758:
    for (;;)
    {
      return;
      long l = this.jdField_a_of_type_Pea.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int i = this.jdField_a_of_type_Pea.a().a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_Pea.a().a();
      if ((i == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label758;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = pkm.a().a(Integer.valueOf(56));
        List localList = this.jdField_a_of_type_Pea.a().a();
        if ((localList == null) || (localList.isEmpty()) || (localObject2 == null) || (((List)localObject2).isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pea.d(), 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
          return;
        }
        if (((List)localObject2).contains(Long.valueOf(l)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pea.d(), 2, "handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =" + localObject1);
          }
          localObject2 = pkm.a().b(Integer.valueOf(56));
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
            pkm.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
            boolean bool = localList.remove(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pea.d(), 2, "delete duplicateArticleInfo: " + localObject2 + ", deleteDuplicateSuccess= " + bool);
            }
          }
          l = ((BaseArticleInfo)localList.get(0)).mRecommendSeq;
          localArticleInfo.mRecommendSeq = (1L + l);
          localArticleInfo.mChannelID = 56L;
          if (localArticleInfo.isTwoItemVideoFeed()) {
            localArticleInfo.mSubArtilceList = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_Pea.d(), 2, "handleJump2VideoChannelForceInsert(): sourceArticleInfo =" + localObject1 + ",firtstArticleSeq=" + l + "， insert cloneInfo=" + localArticleInfo);
          }
          localObject1 = new ArrayList();
          ((List)localObject1).add(localArticleInfo);
          pkm.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_Pea.a().notifyDataSetChanged();
          this.jdField_a_of_type_Pea.a().setAdapter(this.jdField_a_of_type_Pea.a());
          if (this.jdField_a_of_type_Pea.a().a() == null) {}
          for (i = 0;; i = 1)
          {
            this.jdField_a_of_type_Pea.a().setSelectionFromTop(i, 0);
            this.jdField_a_of_type_Pea.a().b(this.jdField_a_of_type_Pea.a(), slt.jdField_b_of_type_Int);
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
    this.jdField_a_of_type_Pea.a().jdField_b_of_type_Long = System.currentTimeMillis();
    if (d())
    {
      if (this.jdField_a_of_type_Pea.d() == 56) {
        this.jdField_a_of_type_Pea.a().d = bkwm.a((QQAppInterface)pay.a(), this.jdField_a_of_type_Pea.a());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Pea.a().d = bkwm.a((QQAppInterface)pay.a(), this.jdField_a_of_type_Pea.d());
  }
  
  public void j()
  {
    if (d())
    {
      if (this.jdField_a_of_type_Pea.d() == 56) {
        bkwm.a((QQAppInterface)pay.a(), System.currentTimeMillis(), this.jdField_a_of_type_Pea.a());
      }
    }
    else {
      return;
    }
    bkwm.a((QQAppInterface)pay.a(), System.currentTimeMillis(), this.jdField_a_of_type_Pea.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdy
 * JD-Core Version:    0.7.0.1
 */