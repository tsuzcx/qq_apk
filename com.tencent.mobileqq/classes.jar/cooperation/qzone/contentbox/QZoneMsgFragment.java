package cooperation.qzone.contentbox;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQzoneRuntimeService;
import com.tencent.qzonehub.api.contentbox.IFeedViewHolderInterface;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import com.tencent.qzonehub.api.impl.QZoneApiProxyImpl;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.contentbox.model.BottomItem;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

public class QZoneMsgFragment
  extends BaseFragment
  implements Handler.Callback, QZoneMsgAdapter.OnGetViewLinstener
{
  public static final int CLICK_CLOSE_GUIDECARD = 6;
  public static final int CLICK_PUBLISH_GUIDECARD = 7;
  public static final int CLICK_TYPE_COMMENT = 2;
  public static final int CLICK_TYPE_DETAIL = 0;
  public static final int CLICK_TYPE_FRIENDFEED = 5;
  public static final int CLICK_TYPE_LIKE = 1;
  public static final int CLICK_TYPE_SHAREQQ = 3;
  public static final int CLICK_TYPE_SHAREQZONE = 4;
  private static final String EMPTY_IMG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190613205313_O1p1qwgOqi.png";
  private static final int IDLE = 0;
  private static final int LOADDING_MORE = 1;
  private static final int MSG_SET_READED = 1001;
  private static final int REFREHING = 2;
  public static final String SCHEME_EVENT_TRAVEL_PHOTO_RECOMMAND_DETAIL = "mqqzone://arouse/photogrouprecommenddetail?usecache=true&checkgroup=false&unikey=";
  private static final String TAG = "QZoneMsgManager.QZoneMsgFragment";
  QZoneMsgAdapter adapter;
  volatile QQAppInterface app;
  protected int footerPreState = 5;
  private Handler handler;
  private volatile boolean hasMore = true;
  private boolean isNightMode;
  private MsgCardView lastCardView;
  private MsgNewLargeCardView lastNewLargeCarView;
  private MsgNewSmallCardView lastNewSmallCardView;
  private ListView listView;
  private IFeedViewHolderInterface mFeedHolder;
  private FootNavigationLayout mFootNavigationLayout;
  private LocalPhotoGroupData mLocalPhotoGroupData;
  private boolean mShowFeeds;
  BroadcastReceiver mSyncCommentLikeReceiver = new QZoneMsgFragment.2(this);
  private boolean mUseNewUI;
  private boolean manual = false;
  MsgOnClickListener msgOnClickListener = new QZoneMsgFragment.10(this);
  QZoneMsgFragment.QZoneMsgUIObserver observer;
  private final AbsListView.OnScrollListener onScrollListener = new QZoneMsgFragment.7(this);
  private volatile boolean refreshed = false;
  private int requestState = 0;
  LinearLayout viewFooterContainer;
  MsgFootTips viewListFooter;
  
  private MQMsg getLastMQMsg()
  {
    QZoneMsgAdapter localQZoneMsgAdapter = this.adapter;
    if (localQZoneMsgAdapter == null)
    {
      QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "getLastMQMsg failed: adapter == null");
      return null;
    }
    return localQZoneMsgAdapter.getLastMQMsg();
  }
  
  private void initEmptyView(View paramView) {}
  
  private void initFootView(boolean paramBoolean)
  {
    if (this.listView == null) {
      return;
    }
    this.viewFooterContainer = new LinearLayout(getBaseActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.viewFooterContainer.setLayoutParams(localLayoutParams);
    this.viewFooterContainer.setOrientation(1);
    this.viewFooterContainer.setGravity(1);
    this.listView.addFooterView(this.viewFooterContainer);
    this.viewListFooter = new MsgFootTips(getBaseActivity(), this.handler);
    this.viewListFooter.setLoadingDataText(getString(2131692248));
    this.viewListFooter.setLoadingMoreDataText(getString(2131692249));
    if (!paramBoolean)
    {
      setFooterState(5);
    }
    else
    {
      this.footerPreState = 3;
      setFooterState(3);
    }
    this.viewFooterContainer.addView(this.viewListFooter);
  }
  
  private void initLastCardView()
  {
    Object localObject = this.lastCardView;
    if ((localObject != null) && (((MsgCardView)localObject).getFeedsListView() != null)) {
      this.lastCardView.getFeedsListView().onStart();
    }
    localObject = this.lastNewSmallCardView;
    if ((localObject != null) && (((MsgNewSmallCardView)localObject).getFeedsListView() != null)) {
      this.lastNewSmallCardView.getFeedsListView().onStart();
    }
    localObject = this.lastNewLargeCarView;
    if ((localObject != null) && (((MsgNewLargeCardView)localObject).getFeedsListView() != null)) {
      this.lastNewLargeCarView.getFeedsListView().onStart();
    }
  }
  
  private boolean isAllNewMsgCard(ArrayList<IMQMsg> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() < 1) {
        return false;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!((IMQMsg)paramArrayList.next()).isNewStyleCard()) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private void loadMore(boolean paramBoolean) {}
  
  private void loadMoreFinish(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.manual)) {
      ToastUtil.a().a(HardCodeUtil.a(2131711977));
    }
    setMoreFootState(paramBoolean);
    this.requestState = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMoreFinish ，requestState=");
      localStringBuilder.append(this.requestState);
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, localStringBuilder.toString());
    }
  }
  
  private void playFirstVisibleItem()
  {
    Object localObject = this.listView;
    if (localObject == null) {
      return;
    }
    int k = ((ListView)localObject).getChildCount();
    if (k <= 0) {
      return;
    }
    int i = 0;
    int j = 0;
    while (i < k)
    {
      localObject = this.listView.getChildAt(i);
      if ((localObject instanceof MsgCardView))
      {
        localObject = (MsgCardView)localObject;
        if ((j == 0) && ((((MsgCardView)localObject).isLargePhotoTotalVisible()) || (this.mUseNewUI)))
        {
          ((MsgCardView)localObject).startPlay();
          j = 1;
        }
        else
        {
          ((MsgCardView)localObject).stopPlay();
        }
      }
      i += 1;
    }
    localObject = this.listView.getChildAt(k - 1);
    if ((localObject instanceof MsgCardView)) {
      this.lastCardView = ((MsgCardView)localObject);
    } else if ((localObject instanceof MsgNewSmallCardView)) {
      this.lastNewSmallCardView = ((MsgNewSmallCardView)localObject);
    } else if ((localObject instanceof MsgNewLargeCardView)) {
      this.lastNewLargeCarView = ((MsgNewLargeCardView)localObject);
    }
    initLastCardView();
  }
  
  private void recycleListItem()
  {
    Object localObject = this.mFeedHolder;
    if (localObject != null)
    {
      ((IFeedViewHolderInterface)localObject).onDestroy();
      this.mFeedHolder = null;
      localObject = this.adapter;
      if (localObject != null) {
        ((QZoneMsgAdapter)localObject).setFeedHolder(null, this.mShowFeeds, this.mUseNewUI);
      }
    }
    localObject = this.listView;
    if (localObject == null) {
      return;
    }
    int j = ((ListView)localObject).getChildCount();
    if (j <= 0) {
      return;
    }
    int i = 0;
    while (i < j)
    {
      localObject = this.listView.getChildAt(i);
      if ((localObject instanceof MsgCardView)) {
        ((MsgCardView)localObject).recycle();
      }
      i += 1;
    }
  }
  
  private void refresh()
  {
    this.requestState = 2;
    ((IQzoneRuntimeService)this.app.getRuntimeService(IQzoneRuntimeService.class)).refreshQzoneMsg();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh ，requestState=");
      localStringBuilder.append(this.requestState);
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, localStringBuilder.toString());
    }
  }
  
  private void refreshFinish(boolean paramBoolean)
  {
    setRefreshFootState(paramBoolean);
    this.requestState = 0;
    Object localObject;
    if (this.adapter.getCount() > 0)
    {
      localObject = (MQMsg)this.adapter.getItem(0);
      if (localObject != null)
      {
        updatePromptText(((MQMsg)localObject).promot);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updatePromptText ，mqMsg.promot=");
          localStringBuilder.append(((MQMsg)localObject).promot);
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText mqMsg ==null");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshFinish ，requestState=");
      ((StringBuilder)localObject).append(this.requestState);
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void refreshLastMsgFeedList()
  {
    Object localObject = this.lastCardView;
    if ((localObject != null) && (((MsgCardView)localObject).getFeedsListView() != null)) {
      this.lastCardView.getFeedsListView().loadMore(this.lastCardView);
    }
    localObject = this.lastNewSmallCardView;
    if ((localObject != null) && (((MsgNewSmallCardView)localObject).getFeedsListView() != null)) {
      this.lastNewSmallCardView.getFeedsListView().loadMore(this.lastNewSmallCardView);
    }
    localObject = this.lastNewLargeCarView;
    if ((localObject != null) && (((MsgNewLargeCardView)localObject).getFeedsListView() != null)) {
      this.lastNewLargeCarView.getFeedsListView().loadMore(this.lastNewLargeCarView);
    }
  }
  
  private boolean removeLastEmptyMQMsg()
  {
    QZoneMsgAdapter localQZoneMsgAdapter = this.adapter;
    if (localQZoneMsgAdapter == null)
    {
      QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "removeLastEmptyMQMsg failed: adapter == null");
      return false;
    }
    return localQZoneMsgAdapter.removeLastEmptyMQMsg();
  }
  
  private void setFootNavigationInfo(QZoneMsgEntityNew paramQZoneMsgEntityNew)
  {
    if (paramQZoneMsgEntityNew == null)
    {
      paramQZoneMsgEntityNew = new ArrayList();
      paramQZoneMsgEntityNew.add(new BottomItem(HardCodeUtil.a(2131719439), "mqqzone://arouse/activefeed"));
      paramQZoneMsgEntityNew.add(new BottomItem(HardCodeUtil.a(2131711973), "mqqzone://arouse/albumlist"));
    }
    else
    {
      paramQZoneMsgEntityNew = paramQZoneMsgEntityNew.bottomItems;
    }
    Handler localHandler = this.handler;
    if (localHandler != null) {
      localHandler.post(new QZoneMsgFragment.6(this, paramQZoneMsgEntityNew));
    }
  }
  
  private void setMoreFootState(boolean paramBoolean) {}
  
  private void setReaded()
  {
    ThreadManagerV2.excute(new QZoneMsgFragment.3(this), 32, null, true);
  }
  
  private void setRefreshFootState(boolean paramBoolean) {}
  
  private void updateMQMsg()
  {
    Object localObject1 = this.mLocalPhotoGroupData;
    if ((localObject1 != null) && (((LocalPhotoGroupData)localObject1).pathList != null) && (!this.mLocalPhotoGroupData.pathList.isEmpty()))
    {
      localObject1 = getLastMQMsg();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: getLastMQMsg == null");
        }
        return;
      }
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setLocalPhotoGroupData: getLastMQMsg{\nmsgType='");
        ((StringBuilder)localObject2).append(((MQMsg)localObject1).msgType);
        ((StringBuilder)localObject2).append('\'');
        ((StringBuilder)localObject2).append('\n');
        ((StringBuilder)localObject2).append(", title=");
        ((StringBuilder)localObject2).append(((MQMsg)localObject1).title);
        ((StringBuilder)localObject2).append('\'');
        ((StringBuilder)localObject2).append('\n');
        ((StringBuilder)localObject2).append(", eventTitle='");
        ((StringBuilder)localObject2).append(((MQMsg)localObject1).eventTitle);
        ((StringBuilder)localObject2).append('\'');
        ((StringBuilder)localObject2).append('\n');
        ((StringBuilder)localObject2).append(", uniKey='");
        ((StringBuilder)localObject2).append(((MQMsg)localObject1).uniKey);
        ((StringBuilder)localObject2).append('\'');
        ((StringBuilder)localObject2).append('\n');
        ((StringBuilder)localObject2).append('}');
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, ((StringBuilder)localObject2).toString());
        if ((((MQMsg)localObject1).msgBody != null) && (((MQMsg)localObject1).msgBody.photolist != null)) {
          localObject2 = ((MQMsg)localObject1).msgBody.photolist.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MQPhotoCell)((Iterator)localObject2).next();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("updateMQMsg: cell.coverUrl=");
          ((StringBuilder)localObject4).append(((MQPhotoCell)localObject3).coverUrl);
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, ((StringBuilder)localObject4).toString());
          continue;
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: mqMsg.msgBody.photolist==null");
        }
      }
      if (((((MQMsg)localObject1).msgBody == null) || (((MQMsg)localObject1).msgBody.photolist == null) || (((MQMsg)localObject1).msgBody.photolist.isEmpty()) || (StringUtil.a(((MQPhotoCell)((MQMsg)localObject1).msgBody.photolist.get(0)).coverUrl))) && (((MQMsg)localObject1).msgType == 9))
      {
        ((MQMsg)localObject1).uniKey = this.mLocalPhotoGroupData.unikey;
        ((MQMsg)localObject1).eventTitle = this.mLocalPhotoGroupData.title;
        ((MQMsg)localObject1).capTime = this.mLocalPhotoGroupData.capTime;
        localObject2 = new ArrayList();
        localObject3 = this.mLocalPhotoGroupData.pathList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          MQPhotoCell localMQPhotoCell = new MQPhotoCell();
          localMQPhotoCell.coverUrl = ((String)localObject4);
          ((ArrayList)localObject2).add(localMQPhotoCell);
        }
        ((MQMsg)localObject1).msgBody.photolist = ((ArrayList)localObject2);
        this.handler.post(new QZoneMsgFragment.9(this, (MQMsg)localObject1));
        QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: update last empty MQMsg.");
      }
      return;
    }
    boolean bool = removeLastEmptyMQMsg();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setLocalPhotoGroupData: removeLastEmptyMQMsg:");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append(", mLocalPhotoGroupData == null || mLocalPhotoGroupData.pathList == null || mLocalPhotoGroupData.pathList.isEmpty()");
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, ((StringBuilder)localObject1).toString());
  }
  
  private void updatePromptText(String paramString)
  {
    ThreadManager.postImmediately(new QZoneMsgFragment.4(this, paramString), null, false);
  }
  
  public IFeedViewHolderInterface getFeedHolder()
  {
    return this.mFeedHolder;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != -10000)
    {
      if (i != 46)
      {
        if (i == 1001)
        {
          setReaded();
          return true;
        }
      }
      else {
        this.adapter.notifyDataSetChanged();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "EVENT_LOAD_MORE_MANUAL loadMore");
      }
      loadMore(true);
    }
    return false;
  }
  
  public void jumpToDetail(MQMsg paramMQMsg)
  {
    Object localObject;
    if ((paramMQMsg != null) && (!TextUtils.isEmpty(paramMQMsg.jumpUrlToDetail)))
    {
      localObject = JumpParser.a(this.app, getBaseActivity(), paramMQMsg.jumpUrlToDetail);
      if (localObject != null)
      {
        ((JumpAction)localObject).a();
        return;
      }
      localObject = new Intent(getBaseActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramMQMsg.jumpUrlToDetail);
      QZoneHelper.addSource((Intent)localObject);
      startActivity((Intent)localObject);
      LpReportInfo_dc02880.report(paramMQMsg.jumpUrlToDetail, paramMQMsg.reportValue, paramMQMsg.getReportRev6());
      return;
    }
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "msg.jumpUrlToDetail is null");
    if ((paramMQMsg != null) && (paramMQMsg.msgType == 9) && (!StringUtil.a(paramMQMsg.uniKey)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqzone://arouse/photogrouprecommenddetail?usecache=true&checkgroup=false&unikey=");
      ((StringBuilder)localObject).append(paramMQMsg.uniKey);
      localObject = ((StringBuilder)localObject).toString();
      jumpToPhotoGroupRecommendDetail((String)localObject);
      LpReportInfo_dc02880.report(2, 2, (String)localObject, "29", false, true, paramMQMsg.getReportRev6());
      LpReportInfo_pf00064.allReport(133, 14, String.valueOf(paramMQMsg.msgType));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToPhotoGroupRecommendDetail: uniKey=");
      ((StringBuilder)localObject).append(paramMQMsg.uniKey);
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "msg == null | msg.msgType != ENUM_PUSH_MSG_TYPE._ENUM_TRAVEL_ALBUM | StringUtil.isEmpty(msg.uniKey)");
  }
  
  public void jumpToPhotoGroupRecommendDetail(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString));
    localIntent.setPackage("com.tencent.mobileqq");
    getBaseActivity().getApplicationContext().startActivity(localIntent);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ThreadManagerV2.excute(new QZoneMsgFragment.5(this), 32, null, true);
    refresh();
    this.handler.sendEmptyMessage(1001);
    QZoneLoginReportHelper.reportLoginFromQZoneMsgBox();
    paramBundle = new LpReportInfo_dc02880(7, 1);
    LpReportManager.getInstance().reportToDC02880(paramBundle, false, true);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "fragment onAttach  ");
    }
    this.app = ((BaseActivity)paramActivity).app;
    this.observer = new QZoneMsgFragment.QZoneMsgUIObserver(this);
    this.app.registObserver(this.observer);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.qzone.sync_comment_like");
    getBaseActivity().registerReceiver(this.mSyncCommentLikeReceiver, (IntentFilter)localObject);
    this.handler = new Handler(Looper.getMainLooper(), this);
    this.mUseNewUI = ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).needShowSubFeedList(paramActivity, this.app);
    if (QZoneApiProxy.needLoadQZoneEnv())
    {
      if (QzonePluginProxyActivity.getQZonePluginClassLoaderInUI() == null)
      {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneMsgFragment.1(this, paramActivity));
        this.mShowFeeds = false;
      }
      else
      {
        this.mShowFeeds = this.mUseNewUI;
      }
    }
    else {
      this.mShowFeeds = false;
    }
    if (this.mShowFeeds)
    {
      localObject = QZoneApiProxy.getLastRuntime();
      if (this.app != localObject) {
        QZoneApiProxy.onAccountChange(paramActivity, this.app);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.isNightMode = QQTheme.d();
    if (this.isNightMode) {
      paramViewGroup.setBackgroundColor(-16777216);
    } else {
      paramViewGroup.setBackgroundColor(-1380874);
    }
    return paramLayoutInflater.inflate(2080636934, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "fragment onDetach  ");
    }
    recycleListItem();
    if (this.observer != null) {
      this.app.unRegistObserver(this.observer);
    }
    getBaseActivity().unregisterReceiver(this.mSyncCommentLikeReceiver);
  }
  
  public void onGetView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt >= this.adapter.getCount() - 1) && (this.adapter.getCount() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onGetView loadMore");
      }
      loadMore(false);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.lastCardView;
    if ((localObject != null) && (((MsgCardView)localObject).getFeedsListView() != null)) {
      this.lastCardView.getFeedsListView().onResume();
    }
    localObject = this.lastNewSmallCardView;
    if ((localObject != null) && (((MsgNewSmallCardView)localObject).getFeedsListView() != null)) {
      this.lastNewSmallCardView.getFeedsListView().onResume();
    }
    localObject = this.lastNewLargeCarView;
    if ((localObject != null) && (((MsgNewLargeCardView)localObject).getFeedsListView() != null)) {
      this.lastNewLargeCarView.getFeedsListView().onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = this.mFeedHolder;
    if (localObject != null) {
      ((IFeedViewHolderInterface)localObject).onStart();
    }
    localObject = this.lastCardView;
    if ((localObject != null) && (((MsgCardView)localObject).getFeedsListView() != null)) {
      this.lastCardView.getFeedsListView().onStart();
    }
    localObject = this.lastNewSmallCardView;
    if ((localObject != null) && (((MsgNewSmallCardView)localObject).getFeedsListView() != null)) {
      this.lastNewSmallCardView.getFeedsListView().onStart();
    }
    localObject = this.lastNewLargeCarView;
    if ((localObject != null) && (((MsgNewLargeCardView)localObject).getFeedsListView() != null)) {
      this.lastNewLargeCarView.getFeedsListView().onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = this.mFeedHolder;
    if (localObject != null) {
      ((IFeedViewHolderInterface)localObject).onStop();
    }
    localObject = this.lastCardView;
    if ((localObject != null) && (((MsgCardView)localObject).getFeedsListView() != null)) {
      this.lastCardView.getFeedsListView().onStop();
    }
    localObject = this.lastNewSmallCardView;
    if ((localObject != null) && (((MsgNewSmallCardView)localObject).getFeedsListView() != null)) {
      this.lastNewSmallCardView.getFeedsListView().onStop();
    }
    localObject = this.lastNewLargeCarView;
    if ((localObject != null) && (((MsgNewLargeCardView)localObject).getFeedsListView() != null)) {
      this.lastNewLargeCarView.getFeedsListView().onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.listView = ((ListView)paramView.findViewById(2080571477));
    paramBundle = paramView.findViewById(2080571495);
    this.listView.setEmptyView(paramBundle);
    paramBundle = getBaseActivity();
    if ((this.mShowFeeds) && (paramBundle != null))
    {
      this.mFeedHolder = QZoneApiProxyImpl.createMsgFeedViewHolder(paramBundle);
      paramBundle = this.mFeedHolder;
      if (paramBundle != null) {
        paramBundle.setHandler(this.handler);
      }
    }
    else
    {
      paramBundle = this.mFeedHolder;
      if (paramBundle != null)
      {
        paramBundle.onDestroy();
        this.mFeedHolder = null;
      }
    }
    this.adapter = new QZoneMsgAdapter(getBaseActivity());
    this.adapter.setNightMode(this.isNightMode);
    this.adapter.setFeedHolder(this.mFeedHolder, this.mShowFeeds, this.mUseNewUI);
    this.adapter.setOnGetViewLinstener(this);
    this.adapter.setMsgOnClickListener(this.msgOnClickListener);
    this.listView.setOnScrollListener(this.onScrollListener);
    this.listView.setAdapter(this.adapter);
    this.mFootNavigationLayout = ((FootNavigationLayout)paramView.findViewById(2080571476));
    paramBundle = this.mFootNavigationLayout;
    int i;
    if (this.mUseNewUI) {
      i = 0;
    } else {
      i = 8;
    }
    paramBundle.setArrowVisible(i);
    if (this.isNightMode) {
      this.mFootNavigationLayout.setNightMode(true);
    }
    setFootNavigationInfo(null);
    initEmptyView(paramView);
  }
  
  public void sendNegativeFeedBack(int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      QZoneMsgNegativeManager localQZoneMsgNegativeManager = (QZoneMsgNegativeManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QZONE_MSGCARD_NEGATIVE_MANAGER);
      localObject = new QZoneMsgNegativeRequest(0L, ((QQAppInterface)localObject).getLongAccountUin(), paramInt1, paramInt2);
      ((QZoneMsgNegativeRequest)localObject).setType(0);
      localQZoneMsgNegativeManager.sendRequest((QZoneMsgNegativeRequest)localObject);
    }
  }
  
  protected final void setFooterState(int paramInt)
  {
    setFooterState(paramInt, true);
  }
  
  protected final void setFooterState(int paramInt, boolean paramBoolean)
  {
    if (this.viewFooterContainer != null)
    {
      if (this.listView == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QZoneMsgManager.QZoneMsgFragment setFooterState(), state: ");
      localStringBuilder.append(paramInt);
      QZLog.i("QZoneMsgManager.QZoneMsgFragment", localStringBuilder.toString());
      this.viewListFooter.setState(paramInt);
      if (paramBoolean) {
        this.footerPreState = paramInt;
      }
      if (paramInt == 3)
      {
        if (this.viewFooterContainer.getVisibility() != 8) {
          this.viewFooterContainer.setVisibility(8);
        }
      }
      else if (this.viewFooterContainer.getVisibility() != 0) {
        this.viewFooterContainer.setVisibility(0);
      }
    }
  }
  
  public void setLocalPhotoGroupData(LocalPhotoGroupData paramLocalPhotoGroupData)
  {
    this.mLocalPhotoGroupData = paramLocalPhotoGroupData;
    paramLocalPhotoGroupData = this.handler;
    if (paramLocalPhotoGroupData != null) {
      paramLocalPhotoGroupData.post(new QZoneMsgFragment.8(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment
 * JD-Core Version:    0.7.0.1
 */