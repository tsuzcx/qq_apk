package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.ScreenshotEventReportListener;
import com.tencent.biz.pubaccount.util.SneakyCallback;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyDataProviderObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasConfig;
import com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragmentHelper;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentBubbleViewHelper;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyResetUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.Utils;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJUGCAccountPopupStep;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.ProteusPreloadManager;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView;
import com.tencent.mobileqq.kandian.biz.push.OnMainVideoTabRedChangeListener;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.RIJLockScreenPushReport;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.biz.push.ReadInJoyTabObserver;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.push.component.RIJPushComponentExtData;
import com.tencent.mobileqq.kandian.biz.push.component.RIJPushComponentExtDataProcessor;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJBadgeInterceptorWrapper;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeDispatcher;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeInfoExtKt;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeInterceptor;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeShowLevel;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.glue.baseconfig.RIJUserInfoAladdinConfig;
import com.tencent.mobileqq.kandian.glue.report.RIJMiniProgrameReporter;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.kandian.glue.report.task.TaskManager;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianLockScreenPushAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.config.AladdinListener;
import com.tencent.mobileqq.kandian.repo.aladdin.config.AladdinListenerUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianMsgBoxRedPntInfoUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo.Biu0x210Msg;
import com.tencent.mobileqq.kandian.repo.db.struct.MySelfNormalItemRedPointInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.channelcover.RIJMainChannelUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.InsertArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.push.api.IKanDianMergeManagerCallBack;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BiuBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;

public class KandianMergeManager
  implements Manager
{
  public static String b = "PUSH_0X210_ORANGE_KEY";
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new KandianMergeManager.8(this);
  private ScreenshotContentObserver jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new KandianMergeManager.36(this);
  KandianMergeManager.KandianReporter jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager$KandianReporter = new KandianMergeManager.KandianReporter();
  private KandianMergeManager.KandianSetTopInfo jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager$KandianSetTopInfo;
  private ReadInJoyGlobalReporter jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter = new ReadInJoyGlobalReporter();
  AladdinListener jdField_a_of_type_ComTencentMobileqqKandianRepoAladdinConfigAladdinListener = new KandianMergeManager.9(this);
  private volatile Kandian210Msg0xeeInfo jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandian210Msg0xeeInfo;
  private KandianOx210MsgInfo.Biu0x210Msg jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo$Biu0x210Msg;
  private KandianOx210MsgInfo jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
  private KandianRedDotInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = null;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
  private MiniAppNotify.IMiniAppNotifyListener jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener = new KandianMergeManager.7(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new KandianMergeManager.15(this);
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = null;
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<InsertArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  public boolean a;
  private int jdField_b_of_type_Int;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new KandianMergeManager.10(this);
  private KandianOx210MsgInfo jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
  private KandianRedDotInfo jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo;
  private List<IRIJBadgeInterceptor> jdField_b_of_type_JavaUtilList;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong;
  private KandianOx210MsgInfo jdField_c_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
  private KandianRedDotInfo jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = null;
  private String jdField_c_of_type_JavaLangString;
  private List<OnTabRedNumsChangeListenner> jdField_c_of_type_JavaUtilList;
  private AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String jdField_d_of_type_JavaLangString;
  private List<OnMainVideoTabRedChangeListener> jdField_d_of_type_JavaUtilList;
  private AtomicInteger jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String jdField_e_of_type_JavaLangString;
  private List<MessageObserver> jdField_e_of_type_JavaUtilList;
  private AtomicInteger jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String f;
  private String g = "";
  private String h = "";
  
  public KandianMergeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    QLog.i("KandianMergeManager", 1, "[KandianMergeManager] constructed.");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    u();
    w();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    ReadInJoyResetUtils.a();
    QQAladdinUtils.a();
    z();
    Utils.a();
    ReadinjoySPEventReport.g();
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 0)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        s();
      } else {
        ThreadManager.executeOnSubThread(new KandianMergeManager.1(this));
      }
      QLog.d("KandianMergeManager", 1, "do method[someInitInSubThread] in manager init ");
    }
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    ThreadManager.executeOnSubThread(new KandianMergeManager.2(this));
    ReadInJoyDataProviderObserver.getInstance().setReport(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager$KandianReporter);
    AladdinListenerUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoAladdinConfigAladdinListener);
    SneakyCallback.c();
    AwesomeCommentInfo.a();
    NativeAwesomeCommentView.setMaxLines(((Integer)RIJSPUtils.a(AwesomeCommentInfo.i, Integer.valueOf(1))).intValue());
    ReadInJoyAtlasConfig.a();
    paramQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    t();
    RIJUGCAccountPopupStep.i();
    G();
    a(new RIJXTabBadgeInterceptor(paramQQAppInterface, this));
  }
  
  private void A()
  {
    ThreadManager.post(new KandianMergeManager.13(this), 8, null, false);
  }
  
  private void B()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_e_of_type_Int;
    boolean bool2 = false;
    Object localObject1;
    boolean bool1;
    if (i == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString;
      long l = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_d_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.g == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = a((String)localObject1, (String)localObject2, l, bool1, true, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_e_of_type_Long));
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_a_of_type_Long);
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      a((MessageRecord)localObject1, true);
      this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
      this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    else
    {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("has 0x210 follow msg push , brief : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", showInFolder : ");
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", showLockScreen : ");
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.f == 1) {
        bool1 = true;
      }
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", redType : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.g);
      ((StringBuilder)localObject2).append(", msgSeq : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_Long);
      ((StringBuilder)localObject2).append(", orangeWord : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", msgCount : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_a_of_type_Int);
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("BID_TYPE", 2);
    a((MessageRecord)localObject1, KandianOx210MsgInfo.l, (Bundle)localObject2);
  }
  
  private void C()
  {
    Object localObject = this.jdField_c_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnTabRedNumsChangeListenner)((Iterator)localObject).next()).aD_();
      }
    }
  }
  
  private void D()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = new ScreenshotContentObserver(BaseApplicationImpl.getContext(), 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a(new ScreenshotContentObserver.ScreenshotEventReportListener());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.e("KandianMergeManager", 1, localSecurityException, new Object[0]);
    }
  }
  
  private void E()
  {
    ScreenshotContentObserver localScreenshotContentObserver = this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver;
    if (localScreenshotContentObserver != null)
    {
      localScreenshotContentObserver.a();
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
    }
  }
  
  private void F()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    long l;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      l = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue();
    } else {
      l = 0L;
    }
    a(l);
  }
  
  private void G()
  {
    ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localReadInJoyLogicManager != null) {
      localReadInJoyLogicManager.getReadInJoyLogicEngine().m();
    }
  }
  
  public static int a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramMessageRecord != null)
    {
      if (paramAppInterface == null) {
        return -1;
      }
      if (((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return -1;
      }
      if ((paramMessageRecord.extInt == 1) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return 0;
      }
      if ((paramMessageRecord.extInt == 2) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return 1;
      }
      if (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.NEW_KANDIAN_UIN)) {
        return 0;
      }
      if ((paramMessageRecord.istroop == 1008) && (ServiceAccountFolderManager.a(paramAppInterface, paramMessageRecord.frienduin))) {
        return 1;
      }
    }
    return -1;
  }
  
  private long a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      if (paramMessageRecord.structingMsg == null)
      {
        QLog.d("KandianMergeManager", 1, "getArticleIDFromMessageRecord : struct msg body is null");
        return 0L;
      }
      if ((paramMessageRecord.time >= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mArticleIds)))
      {
        paramMessageRecord = paramMessageRecord.structingMsg.mArticleIds.split("\\|");
        if (paramMessageRecord.length > 0) {
          try
          {
            if (!TextUtils.isEmpty(paramMessageRecord[0]))
            {
              long l = new BigInteger(paramMessageRecord[0]).longValue();
              return l;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getArticleIDFromMessageRecord has num format error : ");
            localStringBuilder.append(paramMessageRecord);
            QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
          }
        }
      }
    }
    return 0L;
  }
  
  private long a(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    paramKandian210Msg0xeeInfo = paramKandian210Msg0xeeInfo.notifyInfos.iterator();
    for (long l = 0L; paramKandian210Msg0xeeInfo.hasNext(); l = ((Kandian210Msg0xeeInfo.NotifyInfo)paramKandian210Msg0xeeInfo.next()).contextId) {}
    return l;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = paramMessageRecord;
    if (paramAppInfo.buffer.has())
    {
      localObject1 = paramAppInfo.buffer.get();
      paramAppInfo = new StringBuilder();
      paramAppInfo.append("handlerRedPntCenterNotify | buffer jsonStr ");
      paramAppInfo.append((String)localObject1);
      QLog.d("KandianMergeManager", 1, paramAppInfo.toString());
      paramAppInfo = paramMessageRecord;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        paramAppInfo = paramMessageRecord;
        Object localObject2 = ((JSONObject)localObject1).optString("_show_mission");
        paramAppInfo = paramMessageRecord;
        localObject1 = new JSONObject(new JSONObject(((JSONObject)localObject1).optString("param")).optString((String)localObject2)).optString("_red_ext_kd_push_msg_xml");
        paramAppInfo = paramMessageRecord;
        localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8"))).getElementsByTagName("msg").item(0);
        localObject1 = paramMessageRecord;
        if (localObject2 != null)
        {
          paramAppInfo = paramMessageRecord;
          localObject2 = ((Node)localObject2).getAttributes();
          localObject1 = paramMessageRecord;
          if (localObject2 != null)
          {
            paramAppInfo = paramMessageRecord;
            if (((NamedNodeMap)localObject2).getNamedItem("articleIds") != null)
            {
              paramAppInfo = paramMessageRecord;
              if (!TextUtils.isEmpty(this.h))
              {
                paramAppInfo = paramMessageRecord;
                if (this.h.equalsIgnoreCase(((NamedNodeMap)localObject2).getNamedItem("articleIds").getNodeValue())) {
                  return paramMessageRecord;
                }
              }
            }
            paramAppInfo = paramMessageRecord;
            paramMessageRecord = a((NamedNodeMap)localObject2);
            paramAppInfo = paramMessageRecord;
            localObject2 = new StringBuilder();
            paramAppInfo = paramMessageRecord;
            ((StringBuilder)localObject2).append("handlerRedPntCenterNotify | parseRedPntInfoAndSave ");
            if (paramMessageRecord == null) {
              break label371;
            }
            localObject1 = "succeed";
            paramAppInfo = paramMessageRecord;
            ((StringBuilder)localObject2).append((String)localObject1);
            paramAppInfo = paramMessageRecord;
            QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
            localObject1 = paramMessageRecord;
            if (paramMessageRecord != null)
            {
              paramAppInfo = paramMessageRecord;
              localObject1 = paramMessageRecord;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                paramAppInfo = paramMessageRecord;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
                return paramMessageRecord;
              }
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handlerRedPntCenterNotify JSONException ");
        ((StringBuilder)localObject1).append(paramMessageRecord);
        QLog.e("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
        localObject1 = paramAppInfo;
      }
      return localObject1;
      label371:
      localObject1 = "failed";
    }
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    if ((!paramBoolean) && ((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.msg, paramString1))) {
      return null;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, long paramLong, String paramString2)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN;
    localMessageRecord.senderuin = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN;
    localMessageRecord.istroop = 7225;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong;
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("msg_id", paramString2);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("put msgId error, e=");
      localStringBuilder.append(localJSONException.toString());
      QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
    }
    localMessageRecord.extStr = ((JSONObject)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createLockScreenInteractMessage, msg=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", msg_id=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("KandianMergeManager", 2, ((StringBuilder)localObject).toString());
    }
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 6;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    else
    {
      localMessageRecord.extLong |= 0x2;
    }
    localMessageRecord.isread = false;
    localMessageRecord.issend = 0;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong1;
    try
    {
      boolean bool = TextUtils.isEmpty(localMessageRecord.extStr);
      if (bool)
      {
        paramString1 = new JSONObject();
        paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
        paramString1.put("strategy_id", paramLong2);
        paramString1.put("algorithm_id", paramLong3);
        paramString1.put("article_id", paramLong4);
        paramString1.put("folder_status", paramLong5);
        localMessageRecord.extStr = paramString1.toString();
      }
      else
      {
        paramString1 = new JSONObject(localMessageRecord.extStr);
        paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
        paramString1.put("strategy_id", paramLong2);
        paramString1.put("algorithm_id", paramLong3);
        paramString1.put("article_id", paramLong4);
        paramString1.put("folder_status", paramLong5);
        localMessageRecord.extStr = paramString1.toString();
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      localMessageRecord.extStr = null;
    }
    localMessageRecord.vipBubbleID = -999L;
    RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    boolean bool = ReadInJoyHelper.p();
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 5;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    else
    {
      localMessageRecord.extLong |= 0x2;
    }
    if (paramBoolean2)
    {
      localMessageRecord.extInt = 2;
      bool = ReadInJoyHelper.c(paramString3);
    }
    localMessageRecord.issend = 0;
    localMessageRecord.isread = false;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong;
    try
    {
      this.jdField_c_of_type_JavaLangString = paramString3;
      paramBoolean2 = TextUtils.isEmpty(localMessageRecord.extStr);
      if (paramBoolean2)
      {
        paramString1 = new JSONObject();
        paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
        paramString1.put("kdUin", this.jdField_c_of_type_JavaLangString);
        paramString1.put("kdShouldShowMergedAvatar", bool);
        localMessageRecord.extStr = paramString1.toString();
      }
      else
      {
        paramString1 = new JSONObject(localMessageRecord.extStr);
        paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
        paramString1.put("kdUin", this.jdField_c_of_type_JavaLangString);
        paramString1.put("kdShouldShowMergedAvatar", bool);
        localMessageRecord.extStr = paramString1.toString();
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      localMessageRecord.extStr = null;
    }
    if (f())
    {
      localMessageRecord.vipBubbleID = -1000L;
    }
    else
    {
      if (paramBoolean1) {
        paramLong = -999L;
      } else {
        paramLong = -1000L;
      }
      localMessageRecord.vipBubbleID = paramLong;
    }
    if ((localMessageRecord.vipBubbleID == -1000L) && (!paramBoolean1)) {
      localMessageRecord.extStr = null;
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageRecord);
    paramString1.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return localMessageRecord;
  }
  
  private void a(long paramLong)
  {
    try
    {
      String str = new RIJTransMergeKanDianReport.ReportR5Builder().addArticleID(paramLong).build();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A8A", "0X8009A8A", 0, 0, "", "", "", str, false);
      QLog.d("KandianMergeManager", 2, new Object[] { "reportAbandonPushRedPoint action = 0X8009A8A, r5 = ", str });
      return;
    }
    catch (JSONException localJSONException)
    {
      label69:
      break label69;
    }
    QLog.d("KandianMergeManager", 1, "reportAbandonPushRedPoint exception.");
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    Object localObject = this.jdField_e_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MessageObserver)((Iterator)localObject).next()).a(paramMessageRecord, paramInt, paramBundle);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    paramMessageRecord.senderuin = AppConstants.KANDIAN_MERGE_UIN;
    paramMessageRecord.istroop = 7220;
    paramMessageRecord.msg = paramString1;
    try
    {
      paramMessageRecord.time = Long.parseLong(paramString2);
      paramMessageRecord.createMessageUniseq();
      if (paramInt == 0) {
        paramMessageRecord.extInt = 3;
      } else if (paramInt == 1) {
        paramMessageRecord.extInt = 4;
      } else if (paramInt == 5) {
        paramMessageRecord.extInt = paramInt;
      } else {
        paramMessageRecord.extInt = 0;
      }
      paramMessageRecord.extLong = 0;
      return;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  private void a(KandianOx210MsgInfo paramKandianOx210MsgInfo, long paramLong)
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.jdField_c_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
    int i = 0;
    boolean bool = false;
    if (localKandianOx210MsgInfo != null)
    {
      if (localKandianOx210MsgInfo != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("0x210Msg reached, oldSeq = ");
        localStringBuilder.append(localKandianOx210MsgInfo.jdField_b_of_type_Long);
        localStringBuilder.append(", newSeq = ");
        localStringBuilder.append(paramKandianOx210MsgInfo.jdField_b_of_type_Long);
        QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
      }
      if (localKandianOx210MsgInfo.jdField_b_of_type_Long >= paramKandianOx210MsgInfo.jdField_b_of_type_Long)
      {
        if (localKandianOx210MsgInfo.jdField_b_of_type_Long != paramKandianOx210MsgInfo.jdField_b_of_type_Long) {
          bool = true;
        }
        if (bool) {
          localKandianOx210MsgInfo.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel())
        {
          paramKandianOx210MsgInfo = new StringBuilder();
          paramKandianOx210MsgInfo.append("0x210msg delay reach , has a latest msg , no cover! needAddCount : ");
          paramKandianOx210MsgInfo.append(bool);
          QLog.d("KandianMergeManager", 2, paramKandianOx210MsgInfo.toString());
        }
        return;
      }
    }
    if (this.jdField_c_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo != null) {
      paramKandianOx210MsgInfo.jdField_a_of_type_Int += this.jdField_c_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_a_of_type_Int;
    }
    this.jdField_c_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo = paramKandianOx210MsgInfo;
    localKandianOx210MsgInfo = this.jdField_c_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
    localKandianOx210MsgInfo.jdField_d_of_type_Long = paramLong;
    localKandianOx210MsgInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    while (i < paramKandianOx210MsgInfo.jdField_a_of_type_JavaUtilArrayList.size())
    {
      a((MySelfNormalItemRedPointInfo)paramKandianOx210MsgInfo.jdField_a_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
  }
  
  private void a(IRedTouchManager paramIRedTouchManager, int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo, AladdinConfig paramAladdinConfig)
  {
    int i = 0;
    if (paramAladdinConfig.getIntegerFromString("use_new_route", 0) == 0)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | use old route, skip parse num push info");
      return;
    }
    if ((paramAppInfo.red_display_info.get() != null) && (((BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get()).red_type_info.get() != null))
    {
      paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
      if (paramAppInfo == null) {
        return;
      }
      paramAppInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.tab_display_info.get();
      if (paramAppInfo == null) {
        return;
      }
      paramAppInfo = paramAppInfo.red_content.get();
      paramAladdinConfig = paramIRedTouchManager.getNumRedPathListByAppId(paramInt);
      if (paramAladdinConfig != null)
      {
        if (paramAladdinConfig.isEmpty()) {
          return;
        }
        Object localObject = new ArrayList(paramAladdinConfig);
        int j = ((List)localObject).size();
        paramAladdinConfig = new long[j];
        while (i < j)
        {
          BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((List)localObject).get(i);
          if (localNumRedPath != null) {
            paramAladdinConfig[i] = localNumRedPath.uint64_msgid.get();
          }
          i += 1;
        }
        paramIRedTouchManager.getNumRedMsgByMsgIdArray(paramAladdinConfig, "kandian_num_red_pnt_buffer", new KandianMergeManager.16(this));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlerRedPntCenterNotify | numRedPoint num: ");
        ((StringBuilder)localObject).append(paramAppInfo);
        ((StringBuilder)localObject).append(", extraNum : ");
        ((StringBuilder)localObject).append(paramIRedTouchManager.getExtraNumRedTotalNum(paramInt));
        ((StringBuilder)localObject).append(", lastMsgID : ");
        ((StringBuilder)localObject).append(paramAladdinConfig[(paramAladdinConfig.length - 1)]);
        QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool;
    if (((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) {
      bool = RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab();
    } else if ((RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (!ReadInJoyChannelViewPagerController.b())) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("KandianMergeManager", 1, new Object[] { "isNeedToBlockPushRedPoint, ret = ", Boolean.valueOf(bool), ", tag = ", paramString });
    return bool;
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    paramArrayOfByte = KandianOx210MsgInfo.a(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 follow msg fail!");
      }
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
    if ((localObject1 != null) && (((KandianOx210MsgInfo)localObject1).jdField_b_of_type_Long > paramArrayOfByte.jdField_b_of_type_Long))
    {
      Object localObject2;
      if (paramArrayOfByte.jdField_e_of_type_Int == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("0x210msgc5 delay reach showFolder, has a latest msg , no cover! + oldMsg.msgSeq");
          ((StringBuilder)localObject2).append(((KandianOx210MsgInfo)localObject1).jdField_b_of_type_Long);
          ((StringBuilder)localObject2).append("msg.msgSeq:");
          ((StringBuilder)localObject2).append(paramArrayOfByte.jdField_b_of_type_Long);
          ((StringBuilder)localObject2).append("brief : ");
          ((StringBuilder)localObject2).append(paramArrayOfByte.jdField_b_of_type_JavaLangString);
          QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo != null) && (paramArrayOfByte.jdField_b_of_type_Long <= this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_Long))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("no upDate ox210ShowInFolderFollowPushMsg.msgSeq");
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_Long);
            ((StringBuilder)localObject1).append("msg.msgSeq:");
            ((StringBuilder)localObject1).append(paramArrayOfByte.jdField_b_of_type_Long);
            QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          if ((this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo != null) && (QLog.isColorLevel()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("upDate ox210ShowInFolderFollowPushMsg.msgSeq");
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_Long);
            ((StringBuilder)localObject1).append("msg.msgSeq:");
            ((StringBuilder)localObject1).append(paramArrayOfByte.jdField_b_of_type_Long);
            QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = paramArrayOfByte.jdField_b_of_type_JavaLangString;
          localObject2 = paramArrayOfByte.jdField_a_of_type_JavaLangString;
          paramLong = paramArrayOfByte.jdField_d_of_type_Long;
          int i = paramArrayOfByte.g;
          boolean bool2 = false;
          boolean bool1;
          if (i == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localObject1 = a((String)localObject1, (String)localObject2, paramLong, bool1, true, String.valueOf(paramArrayOfByte.jdField_e_of_type_Long));
          a((MessageRecord)localObject1, true);
          this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo = paramArrayOfByte;
          this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("has 0x210 follow msg push , brief : ");
            paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString);
            paramArrayOfByte.append(", showInFolder : ");
            if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            paramArrayOfByte.append(bool1);
            paramArrayOfByte.append(", showLockScreen : ");
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.f == 1) {
              bool1 = true;
            }
            paramArrayOfByte.append(bool1);
            paramArrayOfByte.append(", redType : ");
            paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.g);
            paramArrayOfByte.append(", msgSeq : ");
            paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_Long);
            paramArrayOfByte.append(", orangeWord : ");
            paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString);
            paramArrayOfByte.append(", msgCount : ");
            paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_a_of_type_Int);
            QLog.d("KandianMergeManager", 1, paramArrayOfByte.toString());
          }
          a((MessageRecord)localObject1, KandianOx210MsgInfo.l, null);
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0x210msgc5 delay reach discarded,  + oldMsg.msgSeq");
        ((StringBuilder)localObject2).append(((KandianOx210MsgInfo)localObject1).jdField_b_of_type_Long);
        ((StringBuilder)localObject2).append("msg.msgSeq:");
        ((StringBuilder)localObject2).append(paramArrayOfByte.jdField_b_of_type_Long);
        QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0x210msgc5 nomel , msg.msgSeq:");
      ((StringBuilder)localObject1).append(paramArrayOfByte.jdField_b_of_type_Long);
      QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo = paramArrayOfByte;
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
    paramArrayOfByte.jdField_d_of_type_Long = paramLong;
    paramArrayOfByte.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    B();
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong, IKanDianMergeManagerCallBack paramIKanDianMergeManagerCallBack)
  {
    int i = KandianOx210MsgInfo.a(paramArrayOfByte);
    if (i == KandianOx210MsgInfo.j) {
      return;
    }
    if (i == KandianOx210MsgInfo.l)
    {
      a(paramArrayOfByte);
      return;
    }
    KandianOx210MsgInfo localKandianOx210MsgInfo = KandianOx210MsgInfo.a(paramArrayOfByte);
    if (localKandianOx210MsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 msg fail!");
      }
      return;
    }
    i = KandianOx210MsgInfo.b(paramArrayOfByte);
    if (i == KandianOx210MsgInfo.m) {
      return;
    }
    int j = KandianOx210MsgInfo.n;
    boolean bool2 = false;
    if ((i != j) && (i != KandianOx210MsgInfo.o))
    {
      if (i == KandianOx210MsgInfo.p) {
        a(localKandianOx210MsgInfo, paramLong);
      }
    }
    else {
      ReadInJoyLogicEngine.a().b(0, "");
    }
    boolean bool3 = RIJAppSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool4 = RIJPushNotification.a();
    boolean bool1;
    if (!bool3)
    {
      bool1 = bool2;
      if (!bool4) {}
    }
    else
    {
      bool1 = bool2;
      if (localKandianOx210MsgInfo.f == 1)
      {
        bool1 = bool2;
        if (((Boolean)RIJSPUtils.a("sp_msg_box_80a_enable_receive", Boolean.valueOf(true))).booleanValue()) {
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      paramArrayOfByte = a(localKandianOx210MsgInfo.jdField_b_of_type_JavaLangString, localKandianOx210MsgInfo.jdField_d_of_type_Long, localKandianOx210MsgInfo.h);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false, false, true, false);
      paramIKanDianMergeManagerCallBack.a("handleGetKandian210Message", true, 1, true, false);
      if ((RIJKanDianLockScreenPushAladdinConfig.b() != 1) && (RIJMsgBoxUtils.b() == 2)) {
        i = 1;
      } else {
        i = 3;
      }
      paramArrayOfByte = new RIJTransMergeKanDianReport.ReportR5Builder().addValueSafe("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).addValueSafe("load_mode", Integer.valueOf(i)).addValueSafe("push_type", Integer.valueOf(9));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X80081DC", paramArrayOfByte.build());
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("isAppBackground=");
    paramArrayOfByte.append(bool3);
    paramArrayOfByte.append(",needNotificationForeground");
    paramArrayOfByte.append(bool4);
    paramArrayOfByte.append(",showLockScreen=");
    paramArrayOfByte.append(localKandianOx210MsgInfo.f);
    paramArrayOfByte.append(",needShow=");
    paramArrayOfByte.append(bool1);
    QLog.i("KandianMergeManager", 1, paramArrayOfByte.toString());
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needForceNotification(paramMessageRecord)) {
      ThreadManager.post(new KandianMergeManager.19(this), 8, null, false);
    }
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    MessageRecord localMessageRecord;
    if (localQQMessageFacade != null) {
      localMessageRecord = localQQMessageFacade.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } else {
      localMessageRecord = null;
    }
    if ((localMessageRecord != null) && (a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (localMessageRecord.extInt == 2) && (!localMessageRecord.isread))
    {
      if (QLog.isColorLevel())
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lastMr_info 【");
        ((StringBuilder)localObject1).append("msg: ");
        ((StringBuilder)localObject1).append(ReadInJoyUtils.a(localMessageRecord.msg));
        ((StringBuilder)localObject1).append(", msguid : ");
        ((StringBuilder)localObject1).append(localMessageRecord.msgUid);
        Object localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        if ((localMessageRecord instanceof MessageForStructing))
        {
          localObject3 = (MessageForStructing)localMessageRecord;
          ((MessageForStructing)localObject3).parse();
          localObject1 = localObject2;
          if (((MessageForStructing)localObject3).structingMsg != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(", title : ");
            ((StringBuilder)localObject1).append(ReadInJoyUtils.a(((MessageForStructing)localObject3).structingMsg.mMsgBrief));
            ((StringBuilder)localObject1).append(" 】");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("newMr_info 【");
        ((StringBuilder)localObject2).append("msg: ");
        ((StringBuilder)localObject2).append(ReadInJoyUtils.a(paramMessageRecord.msg));
        ((StringBuilder)localObject2).append(", senderUin : ");
        ((StringBuilder)localObject2).append(paramMessageRecord.senderuin);
        ((StringBuilder)localObject2).append(" , msguid : ");
        ((StringBuilder)localObject2).append(paramMessageRecord.msgUid);
        Object localObject3 = ((StringBuilder)localObject2).toString();
        localObject2 = localObject3;
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramMessageRecord = (MessageForStructing)paramMessageRecord;
          paramMessageRecord.parse();
          localObject2 = localObject3;
          if (paramMessageRecord.structingMsg != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject3);
            ((StringBuilder)localObject2).append(", title : ");
            ((StringBuilder)localObject2).append(ReadInJoyUtils.a(paramMessageRecord.structingMsg.mMsgBrief));
            ((StringBuilder)localObject2).append(" 】");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
        }
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("subscribe push msg cover ! \n");
        paramMessageRecord.append((String)localObject1);
        paramMessageRecord.append("\n");
        paramMessageRecord.append((String)localObject2);
        QLog.i("KandianMergeManager", 2, paramMessageRecord.toString());
      }
      localQQMessageFacade.a(localMessageRecord, false);
    }
  }
  
  private boolean e(MessageRecord paramMessageRecord)
  {
    boolean bool;
    if ((!RIJXTabBadgeInfoExtKt.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (RIJXTabBadgeStore.a(TabChannelCoverInfo.TYPE_CHANNEL_XTAB_FRIEND_CONFIG) != null) && (RIJXTabBadgeShowLevel.a() == 2)) {
      bool = true;
    } else {
      bool = false;
    }
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("isReceiveNormalRedPointWhenFriendBigRedDot=");
    paramMessageRecord.append(bool);
    QLog.i("KandianMergeManager", 1, paramMessageRecord.toString());
    return bool;
  }
  
  private void f(MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        Object localObject = (MessageForStructing)paramMessageRecord;
        ((MessageForStructing)localObject).parse();
        if (((MessageForStructing)localObject).structingMsg != null)
        {
          JSONObject localJSONObject = new JSONObject(((MessageForStructing)localObject).structingMsg.mMsgActionData);
          localObject = null;
          boolean bool3 = localJSONObject.has("showMergedAvatar");
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (bool3)
          {
            bool1 = bool2;
            if (localJSONObject.getInt("showMergedAvatar") == 1) {
              bool1 = true;
            }
          }
          if (localJSONObject.has("uin")) {
            this.jdField_c_of_type_JavaLangString = localJSONObject.getString("uin");
          }
          if (localJSONObject.has("biuUin"))
          {
            this.jdField_c_of_type_JavaLangString = localJSONObject.getString("biuUin");
            bool1 = ReadInJoyHelper.o();
          }
          if (localJSONObject.has("defaultAvatarUrl")) {
            localObject = localJSONObject.getString("defaultAvatarUrl");
          }
          if (TextUtils.isEmpty(paramMessageRecord.extStr)) {
            localJSONObject = new JSONObject();
          } else {
            localJSONObject = new JSONObject(paramMessageRecord.extStr);
          }
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            localJSONObject.put("kdUin", this.jdField_c_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localJSONObject.put("kdDefaultSourceAvatarUrl", localObject);
          }
          localJSONObject.put("kdShouldShowMergedAvatar", bool1);
          paramMessageRecord.extStr = localJSONObject.toString();
          return;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  private void s()
  {
    Object localObject = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b(0, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b(56, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b(70, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b(DailyModeConfigHandler.b(), 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().c(0);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().s();
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b();
    D();
    localObject = ProteusPreloadManager.a.a();
    ProteusPreloadManager.a.a((List)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload pts card, rules : ");
    localStringBuilder.append(localObject);
    QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
  }
  
  private void t()
  {
    ThreadManager.getFileThreadHandler().post(new KandianMergeManager.4(this));
  }
  
  private void u()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.5(this));
  }
  
  private void v()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.6(this));
  }
  
  private void w()
  {
    RIJMiniProgrameReporter.a.b();
  }
  
  private void x()
  {
    RIJMiniProgrameReporter.a.c();
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      try
      {
        IntentFilter localIntentFilter = new IntentFilter("qqplayer_exit_action");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void z()
  {
    Object localObject1 = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.h = ((SharedPreferences)localObject1).getString("kandian_red_touch_pnt_article_id", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initCache mLastRedTouchInfoArticleId : ");
    ((StringBuilder)localObject2).append(this.h);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = ((SharedPreferences)localObject1).getString("kandian_push_msg_xml", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      try
      {
        localObject2 = StructMsgFactory.a(PkgTools.hexToBytes((String)localObject2));
        boolean bool = TextUtils.isEmpty(((AbsStructMsg)localObject2).mArticleIds);
        if (!bool)
        {
          String[] arrayOfString = ((AbsStructMsg)localObject2).mArticleIds.split("\\|");
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          int i = 0;
          while (i < arrayOfString.length)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(arrayOfString[i]));
            i += 1;
          }
        }
        if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mMsgActionData)) {
          this.jdField_a_of_type_JavaLangString = ((AbsStructMsg)localObject2).mMsgActionData;
        }
        if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mAlgorithmIds)) {
          this.jdField_a_of_type_Long = Long.parseLong(localObject2.mAlgorithmIds.split("\\|")[0]);
        }
        if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mStrategyIds)) {
          this.jdField_b_of_type_Long = Long.parseLong(localObject2.mStrategyIds.split("\\|")[0]);
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
        l = ((SharedPreferences)localObject1).getLong("kandian_push_msg_time", 0L);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.jdField_e_of_type_JavaLangString = "";
    this.f = "";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
    long l = ((SharedPreferences)localObject1).getLong("subscribe_push_msg_time", 0L);
    if (l > 0L)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      this.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("subscribe_push_msg_uin", "");
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(((SharedPreferences)localObject1).getInt("subscribe_push_msg_status", -1));
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(((SharedPreferences)localObject1).getInt("subscribe_push_msg_msgtype", -1));
      if ((this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo$Biu0x210Msg = KandianOx210MsgInfo.Biu0x210Msg.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo = KandianOx210MsgInfo.b();
    this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo = KandianOx210MsgInfo.c();
    this.jdField_c_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo = KandianOx210MsgInfo.e();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo = KandianMsgBoxRedPntInfoUtils.a();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init msgbox info from sp. ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.getKandian210Msg0xeeInfoFromSp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(((KandianOx210MsgInfo)localObject1).jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager$KandianSetTopInfo = ((KandianMergeManager.KandianSetTopInfo)RIJSPUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_msgtab_settop", true));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("get from cache : ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager$KandianSetTopInfo);
    QLog.d("KandianMergeManager.SETTOP", 2, ((StringBuilder)localObject1).toString());
    A();
    this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk("kandian_video_tab_reddot_info", true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init mianVideoTabRed : ");
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk("kandian_red_pnt_lock_screen", true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("lock screen push info : ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo);
    QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject1).toString());
    ThreadManager.executeOnSubThread(new KandianMergeManager.11(this));
    RIJXTabBadgeStore.a.a();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return 0;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 0;
      }
      return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  @VisibleForTesting
  int a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public long a()
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
    if (localKandianOx210MsgInfo != null) {
      return localKandianOx210MsgInfo.c;
    }
    return 0L;
  }
  
  public Pair<Object, String> a()
  {
    if ((ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)))
    {
      if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)) {
        return null;
      }
      c(2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSubscribePushMsgTitle : ");
      localStringBuilder.append(RIJAppSetting.a(this.jdField_e_of_type_JavaLangString));
      localStringBuilder.append(" mSubscribePushMsgArticleID : ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
      localStringBuilder.append(" mInnerUniqId : ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" seedUIN :  ");
      localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      localStringBuilder.append(", isInterestedAccount : ");
      localStringBuilder.append(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        if ((TextUtils.isEmpty(this.f)) && (this.jdField_a_of_type_JavaLangLong.longValue() == -1L)) {
          return null;
        }
        if (!TextUtils.isEmpty(this.f)) {
          return new Pair(this.f, this.jdField_e_of_type_JavaLangString);
        }
        return new Pair(this.jdField_a_of_type_JavaLangLong, this.jdField_e_of_type_JavaLangString);
      }
    }
    return null;
  }
  
  public SparseIntArray a()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.append(0, b(0));
    localSparseIntArray.append(1, b(1));
    localSparseIntArray.append(2, b(2));
    localSparseIntArray.append(3, b(3));
    return localSparseIntArray;
  }
  
  @VisibleForTesting
  MessageRecord a()
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    Object localObject1 = null;
    if (localIRedTouchManager == null)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | RedTouchManager is null ");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = localIRedTouchManager.getAppInfoByPath("1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject2 = localIRedTouchManager.getNumRedPointInfo(7, "1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handlerRedPntCenterNotify | receive a red point push notify, size : ");
    ((StringBuilder)localObject2).append(localArrayList.size());
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
    int i = 0;
    while (i < localArrayList.size())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localArrayList.get(i);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handlerRedPntCenterNotify | parse redPntInfo type :  ");
      ((StringBuilder)localObject2).append(localAppInfo.type.get());
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
      localObject2 = Aladdin.getConfig(186);
      if (localAppInfo.type.get() == 5)
      {
        a(localIRedTouchManager, 1130, localAppInfo, (AladdinConfig)localObject2);
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if (localAppInfo.type.get() == 0) {
          localObject2 = a((MessageRecord)localObject1, localAppInfo);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify end !");
    return localObject1;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    IRIJBadgeInterceptor localIRIJBadgeInterceptor = a(paramMessageRecord);
    if (localIRIJBadgeInterceptor.b(paramMessageRecord)) {
      return null;
    }
    if (a(paramMessageRecord)) {
      return null;
    }
    if (e(paramMessageRecord)) {
      return null;
    }
    int i = localIRIJBadgeInterceptor.a(paramMessageRecord);
    if (i == 0)
    {
      if (!b(paramMessageRecord)) {
        return null;
      }
    }
    else if (i == -1) {
      return null;
    }
    e(paramMessageRecord);
    i = a(paramMessageRecord);
    MessageRecord localMessageRecord = a(paramMessageRecord, i);
    if (!localIRIJBadgeInterceptor.c(localMessageRecord)) {
      if (i == 0)
      {
        b(localMessageRecord);
      }
      else if (i == 1)
      {
        c(localMessageRecord);
        l();
      }
    }
    RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageRecord);
    d(paramMessageRecord);
    return localMessageRecord;
  }
  
  @VisibleForTesting
  MessageRecord a(MessageRecord paramMessageRecord, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.istroop = 7220;
    if (paramInt == 0)
    {
      localMessageRecord.extInt = 1;
      a(localMessageRecord, 0);
    }
    else if (paramInt == 1)
    {
      localMessageRecord.extInt = 2;
    }
    else
    {
      localMessageRecord.extInt = 0;
    }
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    else
    {
      localMessageRecord.extLong = (0x2 | localMessageRecord.extLong);
    }
    if (f()) {
      localMessageRecord.vipBubbleID = -1000L;
    } else {
      localMessageRecord.vipBubbleID = -999L;
    }
    f(localMessageRecord);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
    localMessageForStructing.istroop = 7220;
    localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageForStructing.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageForStructing.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageForStructing.time = RIJMergeKanDianMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localMessageForStructing.isread = false;
    localMessageForStructing.issend = 0;
    localMessageForStructing.extInt = 1;
    localMessageForStructing.extLong |= 0x20000000;
    localMessageForStructing.extLong |= 0x1;
    localMessageForStructing.structingMsg = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing.istroop, Long.valueOf(localMessageForStructing.senderuin).longValue(), paramString.getBytes(), 0);
    if (localMessageForStructing.structingMsg == null) {
      return null;
    }
    localMessageForStructing.msg = localMessageForStructing.structingMsg.mMsgBrief;
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    a(localMessageForStructing, 1);
    if (!b(localMessageForStructing)) {
      return null;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageForStructing);
    paramString.a(localMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return localMessageForStructing;
  }
  
  @VisibleForTesting
  MessageRecord a(NamedNodeMap paramNamedNodeMap)
  {
    if (paramNamedNodeMap == null)
    {
      QLog.d("KandianMergeManager", 2, "parseRedPntInfoAndSave redInfoMap null ");
      return null;
    }
    Object localObject = paramNamedNodeMap.getNamedItem("orangeWord");
    String str6 = "";
    if (localObject != null) {
      localObject = paramNamedNodeMap.getNamedItem("orangeWord").getNodeValue();
    } else {
      localObject = "";
    }
    String str1;
    if (paramNamedNodeMap.getNamedItem("brief") != null) {
      str1 = paramNamedNodeMap.getNamedItem("brief").getNodeValue();
    } else {
      str1 = "";
    }
    String str2;
    if (paramNamedNodeMap.getNamedItem("articleIds") != null) {
      str2 = paramNamedNodeMap.getNamedItem("articleIds").getNodeValue();
    } else {
      str2 = "";
    }
    String str3;
    if (paramNamedNodeMap.getNamedItem("algorithmIds") != null) {
      str3 = paramNamedNodeMap.getNamedItem("algorithmIds").getNodeValue();
    } else {
      str3 = "";
    }
    String str4;
    if (paramNamedNodeMap.getNamedItem("strategyIds") != null) {
      str4 = paramNamedNodeMap.getNamedItem("strategyIds").getNodeValue();
    } else {
      str4 = "";
    }
    String str5;
    if (paramNamedNodeMap.getNamedItem("actionData") != null) {
      str5 = paramNamedNodeMap.getNamedItem("actionData").getNodeValue();
    } else {
      str5 = "";
    }
    if (paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue") != null) {
      str6 = paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue").getNodeValue();
    }
    this.h = str2;
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.18(this));
    paramNamedNodeMap = (MessageForStructing)MessageRecordFactory.a(-2011);
    paramNamedNodeMap.msgtype = -2011;
    paramNamedNodeMap.structingMsg = StructMsgFactory.a();
    paramNamedNodeMap.structingMsg.mMsgServiceID = 142;
    paramNamedNodeMap.structingMsg.mMsgBrief = str1;
    paramNamedNodeMap.structingMsg.mOrangeWord = ((String)localObject);
    paramNamedNodeMap.structingMsg.mArticleIds = str2;
    paramNamedNodeMap.structingMsg.mStrategyIds = str4;
    paramNamedNodeMap.structingMsg.mAlgorithmIds = str3;
    paramNamedNodeMap.structingMsg.reportEventFolderStatusValue = str6;
    paramNamedNodeMap.structingMsg.mMsgActionData = str5;
    paramNamedNodeMap.extInt = 1;
    paramNamedNodeMap.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    paramNamedNodeMap.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    paramNamedNodeMap.senderuin = AppConstants.NEW_KANDIAN_UIN;
    paramNamedNodeMap.istroop = 7220;
    paramNamedNodeMap.issend = 0;
    paramNamedNodeMap.isread = false;
    paramNamedNodeMap.extLong = 0;
    paramNamedNodeMap.time = NetConnInfoCenter.getServerTime();
    paramNamedNodeMap.createMessageUniseq();
    paramNamedNodeMap.doPrewrite();
    return a(paramNamedNodeMap);
  }
  
  public MessageRecord a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      RIJPushComponentExtDataProcessor localRIJPushComponentExtDataProcessor = new RIJPushComponentExtDataProcessor();
      RIJPushComponentExtData localRIJPushComponentExtData = localRIJPushComponentExtDataProcessor.a(new String(paramArrayOfByte));
      JSONObject localJSONObject = localRIJPushComponentExtDataProcessor.a(new String(localRIJPushComponentExtData.jdField_a_of_type_ArrayOfByte));
      paramString = localRIJPushComponentExtDataProcessor.a(new String(localRIJPushComponentExtData.jdField_a_of_type_ArrayOfByte), paramString);
      paramArrayOfByte = (MessageForStructing)MessageRecordFactory.a(-2011);
      paramArrayOfByte.msgtype = -2011;
      paramArrayOfByte.structingMsg = StructMsgFactory.a();
      paramArrayOfByte.structingMsg.mMsgServiceID = 142;
      paramArrayOfByte.structingMsg.mArticleIds = localRIJPushComponentExtData.jdField_a_of_type_JavaLangString;
      paramArrayOfByte.structingMsg.mStrategyIds = localRIJPushComponentExtData.jdField_d_of_type_JavaLangString;
      paramArrayOfByte.structingMsg.mAlgorithmIds = localRIJPushComponentExtData.jdField_c_of_type_JavaLangString;
      paramArrayOfByte.structingMsg.reportEventFolderStatusValue = localRIJPushComponentExtData.jdField_b_of_type_JavaLangString;
      paramArrayOfByte.structingMsg.mMsgActionData = localJSONObject.toString();
      paramArrayOfByte.structingMsg.mExtraData = new String(localRIJPushComponentExtData.jdField_a_of_type_ArrayOfByte);
      paramArrayOfByte.structingMsg.mMsgBrief = paramString.optString("brief", "");
      paramArrayOfByte.structingMsg.mOrangeWord = paramString.optString("orangeWord", "");
      paramArrayOfByte.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      paramArrayOfByte.frienduin = AppConstants.KANDIAN_MERGE_UIN;
      paramArrayOfByte.senderuin = AppConstants.NEW_KANDIAN_UIN;
      paramArrayOfByte.istroop = 7220;
      paramArrayOfByte.extInt = 1;
      paramArrayOfByte.time = NetConnInfoCenter.getServerTime();
      paramArrayOfByte.isread = false;
      paramArrayOfByte.issend = 0;
      if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramArrayOfByte.extLong |= 0x20000000;
        paramArrayOfByte.extLong |= 0x1;
      }
      else
      {
        paramArrayOfByte.extLong |= 0x2;
      }
      paramString = new StringBuilder();
      paramString.append("createFakeMsgFrom0x135XmlBuffer fakeMr.structingMsg: ");
      paramString.append(paramArrayOfByte.structingMsg);
      QLog.d("KandianMergeManager", 1, paramString.toString());
      paramArrayOfByte.msg = paramArrayOfByte.structingMsg.mMsgBrief;
      paramArrayOfByte.msgData = paramArrayOfByte.structingMsg.getBytes();
      a(paramArrayOfByte, 0);
      if (RIJLockScreenPushReport.a(paramArrayOfByte))
      {
        paramString = new StringBuilder();
        paramString.append("createFakeMsgFrom0x135XmlBuffer receive daily push ! mr : ");
        paramString.append(paramArrayOfByte);
        QLog.d("KandianMergeManager", 1, paramString.toString());
        ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramArrayOfByte);
        return paramArrayOfByte;
      }
      d(paramArrayOfByte);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      RIJKanDianFolderStatus.updateLastKandianMsgRecord(paramArrayOfByte);
      paramString.a(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      return paramArrayOfByte;
    }
    return null;
  }
  
  public IRIJBadgeInterceptor a(MessageRecord paramMessageRecord)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject == null)
    {
      QLog.d("KandianMergeManager", 2, "getBadgeInterceptor --> interceptors is null!");
      return new RIJBadgeInterceptorWrapper(null);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IRIJBadgeInterceptor localIRIJBadgeInterceptor = (IRIJBadgeInterceptor)((Iterator)localObject).next();
      if (localIRIJBadgeInterceptor.a(paramMessageRecord))
      {
        QLog.d("KandianMergeManager", 2, "getBadgeInterceptor --> found an interceptor!");
        return new RIJBadgeInterceptorWrapper(localIRIJBadgeInterceptor);
      }
    }
    QLog.d("KandianMergeManager", 2, "getBadgeInterceptor --> no interceptor handle!");
    return new RIJBadgeInterceptorWrapper(null);
  }
  
  public KandianRedDotInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo;
  }
  
  @Nullable
  public KandianMsgBoxRedPntInfo a()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
    if ((localKandianMsgBoxRedPntInfo != null) && (localKandianMsgBoxRedPntInfo.isRead)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(Long paramLong)
  {
    if (paramLong.longValue() > 0L) {
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramLong);
    }
    return null;
  }
  
  public List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = RIJXTabBadgeStore.a;
    localObject = RIJXTabBadgeStore.a(0);
    if ((((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) && (localObject != null)) {}
    try
    {
      long l1 = Long.parseLong(((RIJXTabRedDotInfo)localObject).getArticleIds());
      long l2 = Long.parseLong(((RIJXTabRedDotInfo)localObject).getAlgorithmIds());
      long l3 = Long.parseLong(((RIJXTabRedDotInfo)localObject).getStrategyIds());
      localArrayList.add(Long.valueOf(l1));
      localArrayList.add(Long.valueOf(l2));
      localArrayList.add(Long.valueOf(l3));
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      label104:
      StringBuilder localStringBuilder;
      break label104;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getKandianArticleIdsWhenRefreshKandian failed --> ");
    localStringBuilder.append(localObject);
    QLog.e("KandianMergeManager", 2, localStringBuilder.toString());
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return localArrayList;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
      return localArrayList;
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_Long));
      localArrayList.add(Long.valueOf(this.jdField_b_of_type_Long));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getKandianArticleIdsWhenRefreshKandian: ");
    ((StringBuilder)localObject).append(localArrayList.toString());
    QLog.i("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  public void a()
  {
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 1) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.3(this));
    }
    l();
    RIJWebArticleUtil.a.a();
    PTSHelper.a();
    RIJMainChannelUtil.a.b();
    RIJChannelBannerUtil.a.a();
    RIJFeedsInsertUtil.a.a();
    RIJUserInfoAladdinConfig.a.a();
    VideoAudioControlUtil.a.a();
    TKDCommentFragmentHelper.a();
    RIJCommentBubbleViewHelper.a.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followListLength");
      localStringBuilder.append(paramInt);
      QLog.i("KandianMergeManager", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = paramInt;
    ThreadManager.post(new KandianMergeManager.12(this, paramInt), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianMergeManager.KandianSetTopInfo localKandianSetTopInfo = KandianMergeManager.KandianSetTopInfo.get(paramInt1, paramInt2);
    RIJSPUtils.a("kandian_msgtab_settop", localKandianSetTopInfo, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager$KandianSetTopInfo = localKandianSetTopInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update kandian push msg setTop info : ");
    localStringBuilder.append(localKandianSetTopInfo);
    QLog.d("KandianMergeManager.SETTOP", 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.g = paramString;
    if (!this.g.isEmpty()) {
      ReadInJoyLogicEngine.a().b(paramInt, this.g);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      paramMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.21(this, paramMessageRecord), 10, null, false);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return;
    }
    try
    {
      boolean bool = TextUtils.isEmpty(paramMessageRecord.extStr);
      if (bool)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("kandian_push_from", paramInt);
        paramMessageRecord.extStr = localJSONObject.toString();
        return;
      }
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      localJSONObject.put("kandian_push_from", paramInt);
      paramMessageRecord.extStr = localJSONObject.toString();
      return;
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  public void a(OnMainVideoTabRedChangeListener paramOnMainVideoTabRedChangeListener)
  {
    if (paramOnMainVideoTabRedChangeListener == null) {
      return;
    }
    if (this.jdField_d_of_type_JavaUtilList == null) {
      this.jdField_d_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add tabRedNumChangeObserver ");
    localStringBuilder.append(paramOnMainVideoTabRedChangeListener.getClass().getSimpleName());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramOnMainVideoTabRedChangeListener);
    QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    if (!this.jdField_d_of_type_JavaUtilList.contains(paramOnMainVideoTabRedChangeListener)) {
      this.jdField_d_of_type_JavaUtilList.add(paramOnMainVideoTabRedChangeListener);
    }
  }
  
  public void a(OnTabRedNumsChangeListenner paramOnTabRedNumsChangeListenner)
  {
    if (paramOnTabRedNumsChangeListenner == null) {
      return;
    }
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add tabRedNumChangeObserver ");
    localStringBuilder.append(paramOnTabRedNumsChangeListenner.getClass().getSimpleName());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramOnTabRedNumsChangeListenner);
    QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    if (!this.jdField_c_of_type_JavaUtilList.contains(paramOnTabRedNumsChangeListenner)) {
      this.jdField_c_of_type_JavaUtilList.add(paramOnTabRedNumsChangeListenner);
    }
  }
  
  public void a(ReadInJoyTabObserver paramReadInJoyTabObserver)
  {
    a(paramReadInJoyTabObserver);
    a(paramReadInJoyTabObserver);
    a(paramReadInJoyTabObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(paramReadInJoyTabObserver);
  }
  
  public void a(IRIJBadgeInterceptor paramIRIJBadgeInterceptor)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramIRIJBadgeInterceptor);
  }
  
  public void a(MySelfNormalItemRedPointInfo paramMySelfNormalItemRedPointInfo)
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.37(this, paramMySelfNormalItemRedPointInfo));
  }
  
  public void a(InsertArticleInfo paramInsertArticleInfo)
  {
    if (paramInsertArticleInfo == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramInsertArticleInfo);
      return;
    }
    finally
    {
      paramInsertArticleInfo = finally;
      throw paramInsertArticleInfo;
    }
  }
  
  public void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo != null)
    {
      if (paramKandianRedDotInfo.hasArticleID()) {
        this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = paramKandianRedDotInfo;
      } else {
        QLog.d("KandianMergeManager", 1, "main video tab fake red drop because of has reddot now!");
      }
    }
    else {
      this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = paramKandianRedDotInfo;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update mainVideoTab RedDot : ");
    localStringBuilder.append(paramKandianRedDotInfo);
    QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
    m();
    this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo.saveToDiskAsync();
  }
  
  public void a(MessageObserver paramMessageObserver)
  {
    if (paramMessageObserver == null) {
      return;
    }
    try
    {
      if (this.jdField_e_of_type_JavaUtilList == null) {
        this.jdField_e_of_type_JavaUtilList = new ArrayList();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add MsgObserver ");
      localStringBuilder.append(paramMessageObserver.getClass().getSimpleName());
      localStringBuilder.append(", ");
      localStringBuilder.append(paramMessageObserver);
      QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
      if (!this.jdField_e_of_type_JavaUtilList.contains(paramMessageObserver)) {
        this.jdField_e_of_type_JavaUtilList.add(paramMessageObserver);
      }
      return;
    }
    finally {}
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo != null) && (paramKandianMsgBoxRedPntInfo.mSeq <= this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mSeq))
    {
      str = this.g;
      if ((str == null) || (str.isEmpty()))
      {
        i = 1;
        break label48;
      }
    }
    int i = 0;
    label48:
    if ((paramKandianMsgBoxRedPntInfo != null) && (paramKandianMsgBoxRedPntInfo.mMsgCnt > 0) && (i == 0))
    {
      if (!paramKandianMsgBoxRedPntInfo.isRead)
      {
        QLog.i("KandianMergeManager", 1, "updateMsgRedPntInfo setXTabRedDotShowLevel low");
        RIJXTabBadgeShowLevel.a(1);
        RIJXTabBadgeDispatcher.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.asyncWriteToSP();
      this.g = "";
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mNeedShowInFolder)
      {
        paramKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mSummary;
        str = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mOrangeWord;
        long l = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mMsgTime;
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mRedType == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramKandianMsgBoxRedPntInfo = a(paramKandianMsgBoxRedPntInfo, str, l, bool, false, null);
      }
      else
      {
        paramKandianMsgBoxRedPntInfo = null;
      }
      a(paramKandianMsgBoxRedPntInfo, KandianOx210MsgInfo.k, null);
      l();
      paramKandianMsgBoxRedPntInfo = new StringBuilder();
      paramKandianMsgBoxRedPntInfo.append("update msgbox redpnt info. ");
      paramKandianMsgBoxRedPntInfo.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo);
      QLog.d("KandianMergeManager", 1, paramKandianMsgBoxRedPntInfo.toString());
      return;
    }
    QLog.d("KandianMergeManager", 1, new Object[] { "new msgbox red info has error, local : ", this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo, "new : ", paramKandianMsgBoxRedPntInfo });
  }
  
  public void a(String paramString)
  {
    try
    {
      if (TextUtils.equals(paramString, this.jdField_d_of_type_JavaLangString))
      {
        e();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
        if ((localMessageRecord != null) && (localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, paramString)))
        {
          paramString = b();
          if (paramString != null)
          {
            RIJKanDianFolderStatus.updateLastKandianMsgRecord(paramString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        return;
      }
      if (paramInt == 1) {
        return;
      }
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localQQMessageFacade != null) {
        ThreadManager.post(new KandianMergeManager.14(this, localQQMessageFacade, paramString1, paramString2, paramInt, paramBoolean), 10, null, false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RIJAppSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean ^ true);
  }
  
  public void a(boolean paramBoolean, Class paramClass)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.getSimpleName(), Boolean.valueOf(paramBoolean));
    String str = paramClass.getSimpleName();
    if (BaseActivity.sTopActivity != null) {
      paramClass = BaseActivity.sTopActivity.getClass().getSimpleName();
    } else {
      paramClass = "";
    }
    if ((TextUtils.equals(str, paramClass)) && (paramBoolean)) {
      o();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = localMsgBody.uint64_seq.get();
      long l2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Long;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("biu 0x210Msg reached, oldSeq = ");
      paramArrayOfByte.append(l2);
      paramArrayOfByte.append(", newSeq = ");
      paramArrayOfByte.append(l1);
      QLog.d("KandianMergeManager", 1, paramArrayOfByte.toString());
      if (l2 >= l1)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("KandianMergeManager", 2, "biu 0x210Msg delay reached, no updated!");
        return;
      }
      if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.has()) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get() != null) && (((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.has()))
      {
        l2 = ((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.get();
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo$Biu0x210Msg.jdField_b_of_type_Long = l2;
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo$Biu0x210Msg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("has biu 0x210 msg push, seq = ");
        paramArrayOfByte.append(l1);
        paramArrayOfByte.append(", uin = ");
        paramArrayOfByte.append(l2);
        QLog.d("KandianMergeManager", 1, paramArrayOfByte.toString());
        a(null, KandianOx210MsgInfo.l, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.decodeFromPbBytes(paramArrayOfByte);
    if (localKandian210Msg0xeeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 sub 0xee msg fail!");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandian210Msg0xeeInfo != null) && (localKandian210Msg0xeeInfo.msgSeq < this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandian210Msg0xeeInfo.msgSeq)) {
      return;
    }
    if ((localKandian210Msg0xeeInfo.notifyInfos != null) && (!localKandian210Msg0xeeInfo.notifyInfos.isEmpty()))
    {
      paramArrayOfByte = localKandian210Msg0xeeInfo.notifyInfos;
      boolean bool = false;
      if (!TextUtils.isEmpty(((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.get(0)).contextTitle))
      {
        if (a("processMsg0x210Sub0xee"))
        {
          a(a(localKandian210Msg0xeeInfo));
          return;
        }
        Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo;
        if (localKandian210Msg0xeeInfo.isArticleAppInPush())
        {
          this.jdField_a_of_type_Long = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).algorithmID;
          this.jdField_b_of_type_Long = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).strategyID;
          this.jdField_a_of_type_JavaLangString = ReadInJoyStringUtils.a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).extCookie, 0);
          localObject = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).orangeWord;
          paramArrayOfByte = (byte[])localObject;
          if (localObject == null) {
            paramArrayOfByte = HardCodeUtil.a(2131705991);
          }
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localObject = localKandian210Msg0xeeInfo.notifyInfos.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject).next();
            this.jdField_a_of_type_JavaUtilArrayList.add(0, Long.valueOf(localNotifyInfo.contextId));
          }
          paramArrayOfByte = a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).contextTitle, paramArrayOfByte, paramLong, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue(), ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).folderStatus);
          if (paramArrayOfByte != null) {
            c(paramArrayOfByte);
          }
          b(paramArrayOfByte);
        }
        else
        {
          paramArrayOfByte = "KandianMergeManager";
          if (!localKandian210Msg0xeeInfo.isVideoAppInPush()) {
            break label501;
          }
          if (!ReadInJoyHelper.l())
          {
            QLog.d(paramArrayOfByte, 2, "received video app in push , but user is not in video tab, drop it as wife");
            return;
          }
          paramArrayOfByte = new KandianRedDotInfo("kandian_video_tab_reddot_info");
          localObject = (Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0);
          paramArrayOfByte.algorithmID = ((Kandian210Msg0xeeInfo.NotifyInfo)localObject).algorithmID;
          paramArrayOfByte.cookie = Html.fromHtml(((Kandian210Msg0xeeInfo.NotifyInfo)localObject).extCookie).toString();
          localObject = localKandian210Msg0xeeInfo.notifyInfos.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject).next();
            paramArrayOfByte.articleIDList.add(0, Long.valueOf(localNotifyInfo.contextId));
          }
          a(paramArrayOfByte);
          m();
        }
        bool = true;
        break label540;
        label501:
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("received unknow app in push, bid ");
        ((StringBuilder)localObject).append(localKandian210Msg0xeeInfo.bid);
        QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
        label540:
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandian210Msg0xeeInfo = localKandian210Msg0xeeInfo;
          Kandian210Msg0xeeInfo.writeToSpAsync(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandian210Msg0xeeInfo);
          o();
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("process Msg 210 0xee canHandle : ");
        paramArrayOfByte.append(bool);
        paramArrayOfByte.append("\n InAppPush : ");
        paramArrayOfByte.append(localKandian210Msg0xeeInfo);
        QLog.d("KandianMergeManager", 2, paramArrayOfByte.toString());
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("0x210 sub 0xee msg title empty, just abandon ");
      paramArrayOfByte.append(localKandian210Msg0xeeInfo);
      QLog.d("KandianMergeManager", 2, paramArrayOfByte.toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, IKanDianMergeManagerCallBack paramIKanDianMergeManagerCallBack)
  {
    int i = KandianOx210MsgInfo.c(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processMsg0x210Sub0xc5, receiveMsg bidType= ");
    localStringBuilder.append(i);
    QLog.i("KandianMergeManager", 1, localStringBuilder.toString());
    if (i == 2)
    {
      b(paramArrayOfByte, paramLong);
      return;
    }
    b(paramArrayOfByte, paramLong, paramIKanDianMergeManagerCallBack);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("erasureTabRedWhenSwitchTab from: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", to: ");
      localStringBuilder.append(paramInt2);
      QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    }
    if ((paramInt1 != 0) && (paramInt2 == 0)) {
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return true;
    }
    if ((paramInt1 != 1) && (paramInt2 == 1))
    {
      if (b(1) > 0) {
        ThreadManager.getSubThreadHandler().post(new KandianMergeManager.31(this));
      }
      d(1);
      return true;
    }
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      if (b(1) > 0) {
        ThreadManager.getSubThreadHandler().post(new KandianMergeManager.32(this));
      }
      d(1);
      return true;
    }
    if (paramInt2 == 2)
    {
      d(2);
      return true;
    }
    if ((paramInt2 == 3) && (b(3) > 0)) {}
    return false;
  }
  
  @VisibleForTesting
  boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject == null) {
        return true;
      }
      if ((a(paramMessageRecord, (AppInterface)localObject) == 0) && (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        return true;
      }
      if ((((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needForceNotification(paramMessageRecord)) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isDailySceneType(paramMessageRecord)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("receive daily lock screen red point push ! mr : ");
        ((StringBuilder)localObject).append(paramMessageRecord);
        QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
        ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramMessageRecord);
        return true;
      }
      return false;
    }
    return true;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    try
    {
      l = paramMessageRecord.time;
      str2 = paramMessageRecord.senderuin;
      j = paramMessageRecord.msgtype;
      str1 = "";
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("kandian_replace_subscribe_msg")))
      {
        paramMessageRecord = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        if (paramMessageRecord != null) {
          paramMessageRecord.getReadInJoyLogicEngine().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
        }
        return false;
      }
      if (l <= this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) {
        break label568;
      }
      localObject1 = str1;
      if (paramBoolean) {
        break label597;
      }
      this.jdField_e_of_type_JavaLangString = "";
      this.f = "";
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, paramMessageRecord.msgtype))
      {
        localObject1 = "";
        bool = true;
        break label392;
      }
      if (!(paramMessageRecord instanceof MessageForStructing)) {
        break label366;
      }
      localObject2 = (MessageForStructing)paramMessageRecord;
      ((MessageForStructing)localObject2).parse();
      localObject1 = str1;
      if (((MessageForStructing)localObject2).structingMsg == null) {
        break label597;
      }
      str1 = PkgTools.toHexStr(((MessageForStructing)localObject2).structingMsg.getBytes());
      this.jdField_e_of_type_JavaLangString = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
      if (TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mInnerUniqIds)) {
        break label285;
      }
      localObject2 = ((MessageForStructing)localObject2).structingMsg.mInnerUniqIds.split("\\|");
      k = localObject2.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        long l;
        String str2;
        int j;
        String str1;
        Object localObject1;
        Object localObject2;
        int k;
        int i;
        label285:
        label568:
        for (;;)
        {
          label366:
          throw paramMessageRecord;
        }
        label392:
        i += 1;
        continue;
        label590:
        i += 1;
        continue;
        label597:
        boolean bool = false;
      }
    }
    localObject1 = str1;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.f = ((String)localObject1);
        localObject1 = str1;
        break label597;
        localObject1 = str1;
        if (TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mArticleIds)) {
          break label597;
        }
        localObject2 = ((MessageForStructing)localObject2).structingMsg.mArticleIds.split("\\|");
        k = localObject2.length;
        i = 0;
        localObject1 = str1;
        if (i >= k) {
          break label597;
        }
        localObject1 = localObject2[i];
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label590;
        }
        this.jdField_a_of_type_JavaLangLong = Long.valueOf((String)localObject1);
        localObject1 = str1;
        break label597;
        localObject1 = str1;
        if (!QLog.isColorLevel()) {
          break label597;
        }
        QLog.d("KandianMergeManager", 2, "parse subscribe push struct msg fail !");
        localObject1 = str1;
        break label597;
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
        this.jdField_d_of_type_JavaLangString = str2;
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
        this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(j);
        if ((paramBoolean) || (!ReadInJoyHelper.m())) {
          g();
        }
        ThreadManager.getSubThreadHandler().post(new KandianMergeManager.22(this, l, str2, 1, (String)localObject1, j));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("subscribe push, title : ");
        ((StringBuilder)localObject1).append(this.jdField_e_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", id : ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangLong);
        ((StringBuilder)localObject1).append(", msguid : ");
        ((StringBuilder)localObject1).append(paramMessageRecord.msgUid);
        ((StringBuilder)localObject1).append(", isInterestedAccount : ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
        return true;
        return false;
      }
    }
  }
  
  public int b()
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo;
    if (localKandianOx210MsgInfo != null) {
      return localKandianOx210MsgInfo.jdField_d_of_type_Int;
    }
    return 0;
  }
  
  public int b(int paramInt)
  {
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            i = d();
            break label74;
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandianOx210MsgInfo != null) {
          break label74;
        }
      }
      else
      {
        i = this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        if (i > 0) {
          break label74;
        }
      }
    }
    else
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i >= 0) {
        break label74;
      }
    }
    i = 0;
    label74:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTabRedNums tab: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", nums: ");
      localStringBuilder.append(i);
      QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return -1;
    }
    if (TextUtils.isEmpty(paramMessageRecord.extStr)) {
      return -1;
    }
    try
    {
      paramMessageRecord = new JSONObject(paramMessageRecord.extStr);
      if (paramMessageRecord.has("kandian_push_from"))
      {
        int i = Integer.parseInt(paramMessageRecord.getString("kandian_push_from"));
        return i;
      }
      return -1;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return -1;
  }
  
  public long b()
  {
    KandianMergeManager.KandianSetTopInfo localKandianSetTopInfo = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager$KandianSetTopInfo;
    if (localKandianSetTopInfo != null) {
      return KandianMergeManager.KandianSetTopInfo.access$1200(localKandianSetTopInfo);
    }
    return 0L;
  }
  
  public MessageRecord b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt != 2) && (localMessageRecord.extInt != 4) && (localMessageRecord.isValid) && (!MsgProxyUtils.b(localMessageRecord.msgtype))) {
          break label93;
        }
        i -= 1;
      }
    }
    MessageRecord localMessageRecord = null;
    label93:
    localObject = localMessageRecord;
    if (localMessageRecord == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, "extInt=1 OR extInt=3");
    }
    return localObject;
  }
  
  public KandianRedDotInfo b()
  {
    return this.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo;
  }
  
  public List<InsertArticleInfo> b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList.clear();
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("1130");
    if (localAppInfo != null) {
      localIRedTouchManager.onRedTouchItemExposure(localAppInfo, "");
    }
    localAppInfo = localIRedTouchManager.getNumRedPointInfo(7, "1130");
    if (localAppInfo != null) {
      localIRedTouchManager.onRedTouchItemExposure(localAppInfo, "");
    }
    QLog.d("KandianMergeManager", 1, "reportRedPntExposure");
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
      e();
    }
  }
  
  @VisibleForTesting
  void b(MessageRecord paramMessageRecord)
  {
    Object localObject = this.jdField_e_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MessageObserver)((Iterator)localObject).next()).a(paramMessageRecord);
      }
    }
  }
  
  public void b(OnMainVideoTabRedChangeListener paramOnMainVideoTabRedChangeListener)
  {
    if (paramOnMainVideoTabRedChangeListener != null)
    {
      Object localObject = this.jdField_d_of_type_JavaUtilList;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("remove tabRedNumChangeObserver ");
        ((StringBuilder)localObject).append(paramOnMainVideoTabRedChangeListener.getClass().getSimpleName());
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramOnMainVideoTabRedChangeListener);
        QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject).toString());
        this.jdField_d_of_type_JavaUtilList.remove(paramOnMainVideoTabRedChangeListener);
      }
    }
  }
  
  public void b(OnTabRedNumsChangeListenner paramOnTabRedNumsChangeListenner)
  {
    if (paramOnTabRedNumsChangeListenner == null) {
      return;
    }
    Object localObject = this.jdField_c_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remove tabRedNumChangeObserver ");
      ((StringBuilder)localObject).append(paramOnTabRedNumsChangeListenner.getClass().getSimpleName());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramOnTabRedNumsChangeListenner);
      QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject).toString());
      this.jdField_c_of_type_JavaUtilList.remove(paramOnTabRedNumsChangeListenner);
    }
  }
  
  public void b(ReadInJoyTabObserver paramReadInJoyTabObserver)
  {
    b(paramReadInJoyTabObserver);
    b(paramReadInJoyTabObserver);
    b(paramReadInJoyTabObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(paramReadInJoyTabObserver);
  }
  
  public void b(MessageObserver paramMessageObserver)
  {
    if (paramMessageObserver == null) {
      return;
    }
    try
    {
      if ((this.jdField_e_of_type_JavaUtilList != null) && (!this.jdField_e_of_type_JavaUtilList.isEmpty()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remove MsgObserver ");
        localStringBuilder.append(paramMessageObserver.getClass().getSimpleName());
        localStringBuilder.append(", ");
        localStringBuilder.append(paramMessageObserver);
        QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
        this.jdField_e_of_type_JavaUtilList.remove(paramMessageObserver);
        return;
      }
      return;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public boolean b()
  {
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubUnread : ");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    localStringBuilder.append(", SubStatus : ");
    localStringBuilder.append(this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    localStringBuilder.append(", mSubTitle : ");
    localStringBuilder.append(RIJAppSetting.a(this.jdField_e_of_type_JavaLangString));
    localStringBuilder.append(", KDUnread : ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1)) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccount(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))) {
      return false;
    }
    if ((ReadInJoyHelper.m()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_a_of_type_JavaLangLong.longValue() <= 0L) && (TextUtils.isEmpty(this.f)))
    {
      QLog.d("KandianMergeManager", 2, "subscribe push has not article id , give up auto refresh! only for kandian tab");
      return false;
    }
    return true;
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    int i = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 0) {
      return d(paramMessageRecord);
    }
    if (i == 1) {
      return a(paramMessageRecord, false);
    }
    return false;
  }
  
  public int c()
  {
    return ReadInJoyLogicEngine.a().a();
  }
  
  public long c()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
    if ((localKandianMsgBoxRedPntInfo != null) && (!localKandianMsgBoxRedPntInfo.isRead)) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mUin;
    }
    return -1L;
  }
  
  public MessageRecord c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt != 2) && (localMessageRecord.extInt != 4) && (localMessageRecord.extInt != 3) && ((localMessageRecord.extInt != 5) || (e())) && (localMessageRecord.isValid) && (!MsgProxyUtils.b(localMessageRecord.msgtype))) {
          break label119;
        }
        i -= 1;
      }
    }
    MessageRecord localMessageRecord = null;
    label119:
    localObject = localMessageRecord;
    if (localMessageRecord == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, "extInt=1");
    }
    return localObject;
  }
  
  public KandianRedDotInfo c()
  {
    return this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo;
  }
  
  public void c()
  {
    if (ReadInJoyHelper.m())
    {
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : isShowKandianTab give up clean !");
      return;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)
    {
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))
      {
        e();
        i = 1;
        break label92;
      }
      if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
        e();
      } else {
        c(3);
      }
    }
    int i = 0;
    label92:
    Object localObject1 = TroopBarAssistantManager.a();
    if (localObject1 != null) {
      ((TroopBarAssistantManager)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (i != 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
      long l;
      if (localObject1 != null)
      {
        if (((MessageRecord)localObject1).extInt != 1)
        {
          if (((MessageRecord)localObject1).extInt == 3) {
            return;
          }
          l = ((MessageRecord)localObject1).time;
        }
      }
      else {
        l = NetConnInfoCenter.getServerTime();
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131695229);
      }
      else if ((((MessageRecord)localObject1).extInt == 1) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject2 = (MessageForStructing)localObject1;
        ((MessageForStructing)localObject2).parse();
        if (((MessageForStructing)localObject2).structingMsg == null) {
          localObject1 = ((MessageRecord)localObject1).msg;
        } else {
          localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
        }
      }
      else
      {
        localObject1 = ((MessageRecord)localObject1).msg;
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131695229);
      }
      localObject1 = a((String)localObject2, String.valueOf(l), 0);
      RIJKanDianFolderStatus.updateLastKandianMsgRecord((MessageRecord)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cleanKandianMergeSummary : last msg is interested account,replace by kandian. ");
        ((StringBuilder)localObject2).append(((MessageRecord)localObject1).msg);
        QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 3) {}
    try
    {
      if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        e();
        return;
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.23(this, paramInt));
      return;
    }
    finally {}
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    Object localObject = this.jdField_e_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MessageObserver)((Iterator)localObject).next()).b(paramMessageRecord);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean c()
  {
    return ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) ^ true;
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    try
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a();
      localAbsStructMsg.uin = paramMessageRecord.frienduin;
      localAbsStructMsg.currentAccountUin = paramMessageRecord.selfuin;
      localAbsStructMsg.mMsgBrief = paramMessageRecord.msg;
      localAbsStructMsg.mMsgActionData = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((Long)localIterator.next());
        localStringBuilder.append("|");
      }
      localAbsStructMsg.mArticleIds = localStringBuilder.toString();
      localAbsStructMsg.mAlgorithmIds = String.valueOf(this.jdField_a_of_type_Long);
      localAbsStructMsg.mStrategyIds = String.valueOf(this.jdField_b_of_type_Long);
      long l = paramMessageRecord.time;
      paramMessageRecord = PkgTools.toHexStr(localAbsStructMsg.getBytes());
      if (l > this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
        ThreadManager.getSubThreadHandler().post(new KandianMergeManager.25(this, paramMessageRecord, l));
        if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2)) {
          c(2);
        } else if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)) {
          e();
        }
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("0xee push, ids: ");
          paramMessageRecord.append(this.jdField_a_of_type_JavaUtilArrayList);
          QLog.d("KandianMergeManager", 2, paramMessageRecord.toString());
        }
        return true;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramMessageRecord;
    }
  }
  
  public int d()
  {
    if (i()) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return 0;
  }
  
  public void d()
  {
    RIJKanDianFolderStatus.setLastKandianMsgRead();
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localMessageRecord != null) && (!localMessageRecord.isread))
    {
      localMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.20(this, localMessageRecord), 10, null, false);
    }
  }
  
  public void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("erasureTabRed index: ");
    localStringBuilder.append(paramInt);
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          if (b(paramInt) <= 0) {
            ReadInJoyLogicEngine.a().p();
          }
          localStringBuilder.append(", subscribe msg successful");
        }
      }
      else {
        this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    }
    l();
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramBoolean)
    {
      localAppInfo = ((IRedTouchManager)localObject).getNumRedPointInfo(7, "1130");
      if (localAppInfo != null) {
        ((IRedTouchManager)localObject).onRedTouchItemClick(localAppInfo, "");
      }
    }
    else
    {
      localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath("1130");
      if (localAppInfo != null) {
        ((IRedTouchManager)localObject).onRedTouchItemClick(localAppInfo, "");
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportRedPntClick, isNumRedPnt : ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    try
    {
      if (a("updateKandianPush2SP"))
      {
        a(a(paramMessageRecord));
        return false;
      }
      if (ReadInJoyLockScreenJumpDelegate.a(paramMessageRecord))
      {
        if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needForceNotification(paramMessageRecord)) {
          this.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_red_pnt_lock_screen");
        }
        QLog.i("KandianMergeManager", 1, "updateKandianPush2SP: block lock screen red dot.");
        return true;
      }
      if (!(paramMessageRecord instanceof MessageForStructing)) {
        break label728;
      }
      localObject1 = (MessageForStructing)paramMessageRecord;
      ((MessageForStructing)localObject1).parse();
      if (((MessageForStructing)localObject1).structingMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "kandian push msg : struct msg body is null");
        }
        return false;
      }
      localObject1 = PkgTools.toHexStr(((MessageForStructing)paramMessageRecord).structingMsg.getBytes());
      l = paramMessageRecord.time;
      if (paramMessageRecord.time < this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) {
        break label728;
      }
      if (TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds)) {
        break label298;
      }
      localObject2 = ((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds.split("\\|");
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        long l;
        Object localObject2;
        int i;
        int j;
        for (;;)
        {
          label298:
          label728:
          throw paramMessageRecord;
        }
        label743:
        i += 1;
      }
    }
    j = localObject2.length;
    if (i < j)
    {
      try
      {
        if (TextUtils.isEmpty(localObject2[i])) {
          break label743;
        }
        BigInteger localBigInteger = new BigInteger(localObject2[i]);
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(localBigInteger.longValue()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse kandian push articleID has num format error : ");
        localStringBuilder.append(localNumberFormatException);
        QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgActionData;
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds)) {
        this.jdField_a_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds)) {
        this.jdField_b_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds.split("\\|")[0]);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramMessageRecord.time);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      if ((((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needForceNotification(paramMessageRecord)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_red_pnt_lock_screen");
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo.saveToDiskAsync();
          if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo.hasArticleID())
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo.articleIDList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Long localLong = (Long)((Iterator)localObject2).next();
              this.jdField_a_of_type_JavaUtilMap.put(localLong, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo.extInfo);
            }
          }
        }
      }
      this.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_red_pnt_lock_screen");
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.26(this, (String)localObject1, l));
      if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2)) {
        c(2);
      } else if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)) {
        e();
      }
      f();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("kandian push, ids: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilArrayList);
      ((StringBuilder)localObject1).append(", msgUid : ");
      ((StringBuilder)localObject1).append(paramMessageRecord.msgUid);
      ((StringBuilder)localObject1).append(", isLockScreenMsg : ");
      ((StringBuilder)localObject1).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needForceNotification(paramMessageRecord));
      ((StringBuilder)localObject1).append(", pushContent : ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
      return true;
      return false;
    }
  }
  
  public int e()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
    if ((localKandianMsgBoxRedPntInfo != null) && (!localKandianMsgBoxRedPntInfo.isRead)) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return 0;
  }
  
  public void e()
  {
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      this.jdField_d_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.24(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructKandian210Msg0xeeInfo = null;
      Kandian210Msg0xeeInfo.removeKandian210Msg0xeeInfoFromSp();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean f()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMessageRecord != null)
    {
      if (localMessageRecord.isread) {
        return false;
      }
      bool1 = bool2;
      if (localMessageRecord.vipBubbleID == -1000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void g()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo.removeFromDiskAsync(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = null;
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.27(this));
      return;
    }
    finally {}
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo != null;
  }
  
  public void h()
  {
    RIJKanDianFolderStatus.setLastKandianMsgRead();
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
    String str;
    int i;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      str = AppConstants.KANDIAN_MERGE_UIN;
      i = 7220;
    }
    else
    {
      str = AppConstants.NEW_KANDIAN_UIN;
      i = 1008;
    }
    if ((localConversationFacade != null) && (localConversationFacade.a(str, i) > 0)) {
      ThreadManager.post(new KandianMergeManager.28(this, str, i), 8, null, false);
    }
  }
  
  public boolean h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("SplashActivity");
    if ((BaseActivity.sTopActivity != null) && ((ReadInJoyUtils.a() instanceof QQAppInterface)) && (!FrameHelperActivity.o))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      String str = localBaseActivity.getClass().getSimpleName();
      if (localArrayList.contains(str))
      {
        boolean bool2 = "SplashActivity".equals(str);
        boolean bool1 = true;
        if (bool2)
        {
          if (SplashActivity.currentFragment != 1) {
            return false;
          }
          if (((SplashActivity)localBaseActivity).getCurrentTab() == FrameControllerUtil.g) {
            return false;
          }
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null) {
          bool1 = ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(str)).booleanValue();
        }
        return bool1;
      }
    }
    return false;
  }
  
  public void i()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    localNewIntent.putExtra("cmd", "get_message_configuration");
    mobileqq_mp.GetMessageConfigurationRequest localGetMessageConfigurationRequest = new mobileqq_mp.GetMessageConfigurationRequest();
    localGetMessageConfigurationRequest.uin.set(2171946401L);
    localGetMessageConfigurationRequest.versionInfo.set(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getVersionInfo());
    localNewIntent.putExtra("data", localGetMessageConfigurationRequest.toByteArray());
    localNewIntent.setObserver(new KandianMergeManager.29(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean i()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
    return (localKandianMsgBoxRedPntInfo != null) && (!localKandianMsgBoxRedPntInfo.isRead);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager$KandianSetTopInfo != null) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.30(this));
    }
  }
  
  public boolean j()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilList.isEmpty();
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localObject != null) && (!((MessageRecord)localObject).isread))
    {
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
      if (localRecentUser == null) {
        return;
      }
      long l = System.currentTimeMillis() / 1000L;
      localRecentUser.lastmsgtime = l;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(l));
      localRecentUserProxy.b(localRecentUser);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stickKandianConversation successful! newTime : ");
      ((StringBuilder)localObject).append(l);
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void l()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      C();
      return;
    }
    ThreadManager.getUIHandler().post(new KandianMergeManager.33(this));
  }
  
  public void m()
  {
    ThreadManager.getUIHandler().post(new KandianMergeManager.34(this));
  }
  
  public void n()
  {
    KandianRedDotInfo localKandianRedDotInfo = this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo;
    if (localKandianRedDotInfo == null) {
      return;
    }
    localKandianRedDotInfo.removeFromDiskAsync(true);
    this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityKandianRedDotInfo = null;
    m();
  }
  
  public void o()
  {
    ThreadManager.executeOnSubThread(new KandianMergeManager.35(this));
  }
  
  public void onDestroy()
  {
    ReadInJoyHelper.d();
    E();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    ReadInJoyDataProviderObserver.getInstance().setReport(null);
    TaskManager.a().c();
    localObject = this.jdField_c_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.jdField_e_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    SneakyCallback.d();
    AladdinListenerUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoAladdinConfigAladdinListener);
    v();
    x();
    ProteusPreloadManager.a.a();
  }
  
  public void p()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
    if (localKandianMsgBoxRedPntInfo != null) {
      localKandianMsgBoxRedPntInfo.canDoAnimation = true;
    }
  }
  
  public void q()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
    if ((localObject != null) && (!((KandianMsgBoxRedPntInfo)localObject).isRead))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
      ((KandianMsgBoxRedPntInfo)localObject).isRead = true;
      ((KandianMsgBoxRedPntInfo)localObject).asyncWriteToSP();
      l();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clear msg box redPnt info, ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo);
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void r()
  {
    try
    {
      boolean bool = b();
      QLog.d("KandianMergeManager", 1, new Object[] { "switch to sub channel, clear kandian red point, hasRedPoint = ", Boolean.valueOf(bool) });
      if (bool)
      {
        F();
        g();
        f();
        l();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager
 * JD-Core Version:    0.7.0.1
 */