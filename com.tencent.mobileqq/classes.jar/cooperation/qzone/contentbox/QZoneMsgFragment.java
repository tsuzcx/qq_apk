package cooperation.qzone.contentbox;

import amtj;
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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import bfvp;
import bfwg;
import bhzt;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.FeedViewHolderInterface;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.contentbox.model.BottomItem;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
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
  extends ReportV4Fragment
  implements Handler.Callback, QZoneMsgAdapter.OnGetViewLinstener
{
  public static final String ACTION = "action";
  public static final String ACTION_SYNC_QZONE_COMMENT_LIKE = "com.qzone.sync_comment_like";
  public static final int CLICK_TYPE_COMMENT = 2;
  public static final int CLICK_TYPE_DETAIL = 0;
  public static final int CLICK_TYPE_FRIENDFEED = 5;
  public static final int CLICK_TYPE_LIKE = 1;
  public static final int CLICK_TYPE_SHAREQQ = 3;
  public static final int CLICK_TYPE_SHAREQZONE = 4;
  private static final String EMPTY_IMG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190613205313_O1p1qwgOqi.png";
  public static final String FEED = "feed";
  private static final int IDLE = 0;
  private static final int LOADDING_MORE = 1;
  private static final int MSG_SET_READED = 1001;
  private static final int REFREHING = 2;
  public static final String SCHEME_EVENT_TRAVEL_PHOTO_RECOMMAND_DETAIL = "mqqzone://arouse/photogrouprecommenddetail?usecache=true&checkgroup=false&unikey=";
  public static final String SYNC_QZONE_COMMENT_COMMENT_NUM = "sync_comment_commentnum";
  public static final String SYNC_QZONE_COMMENT_HASLIKE = "sync_comment_haslike";
  public static final String SYNC_QZONE_COMMENT_LIKE_KEY = "sync_comment_likekey";
  public static final String SYNC_QZONE_COMMENT_LIKE_NUM = "sync_comment_likenum";
  private static final String TAG = "QZoneMsgManager.QZoneMsgFragment";
  QZoneMsgAdapter adapter;
  volatile QQAppInterface app;
  protected int footerPreState = 5;
  private Handler handler;
  private volatile boolean hasMore = true;
  private boolean isNightMode;
  private ListView listView;
  private FeedViewHolderInterface mFeedHolder;
  private FootNavigationLayout mFootNavigationLayout;
  private LocalPhotoGroupData mLocalPhotoGroupData;
  private boolean mShowFeeds;
  BroadcastReceiver mSyncCommentLikeReceiver = new QZoneMsgFragment.2(this);
  private boolean mUseNewUI;
  private boolean manual;
  MsgOnClickListener msgOnClickListener = new QZoneMsgFragment.9(this);
  QZoneMsgFragment.QZoneMsgUIObserver observer;
  private final AbsListView.OnScrollListener onScrollListener = new QZoneMsgFragment.7(this);
  private volatile boolean refreshed;
  private int requestState = 0;
  LinearLayout viewFooterContainer;
  MsgFootTips viewListFooter;
  
  private MQMsg getLastMQMsg()
  {
    if (this.adapter == null)
    {
      QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "getLastMQMsg failed: adapter == null");
      return null;
    }
    return this.adapter.getLastMQMsg();
  }
  
  private void initEmptyView(View paramView) {}
  
  private void initFootView(boolean paramBoolean)
  {
    if (this.listView == null) {
      return;
    }
    this.viewFooterContainer = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.viewFooterContainer.setLayoutParams(localLayoutParams);
    this.viewFooterContainer.setOrientation(1);
    this.viewFooterContainer.setGravity(1);
    this.listView.addFooterView(this.viewFooterContainer);
    this.viewListFooter = new MsgFootTips(getActivity(), this.handler);
    this.viewListFooter.setLoadingDataText(getString(2131692097));
    this.viewListFooter.setLoadingMoreDataText(getString(2131692098));
    if (!paramBoolean) {
      setFooterState(5);
    }
    for (;;)
    {
      this.viewFooterContainer.addView(this.viewListFooter);
      return;
      this.footerPreState = 3;
      setFooterState(3);
    }
  }
  
  private void loadMore(boolean paramBoolean) {}
  
  private void loadMoreFinish(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.manual)) {
      bhzt.a().a(amtj.a(2131711140));
    }
    setMoreFootState(paramBoolean);
    this.requestState = 0;
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "loadMoreFinish ，requestState=" + this.requestState);
    }
  }
  
  private void playFirstVisibleItem()
  {
    if (this.listView == null) {}
    int k;
    do
    {
      return;
      k = this.listView.getChildCount();
    } while (k <= 0);
    int j = 0;
    int i = 0;
    label24:
    Object localObject;
    if (j < k)
    {
      localObject = this.listView.getChildAt(j);
      if ((localObject instanceof MsgCardView)) {
        break label54;
      }
    }
    for (;;)
    {
      j += 1;
      break label24;
      break;
      label54:
      localObject = (MsgCardView)localObject;
      if ((i == 0) && ((((MsgCardView)localObject).isLargePhotoTotalVisible()) || (this.mUseNewUI)))
      {
        ((MsgCardView)localObject).startPlay();
        i = 1;
      }
      else
      {
        ((MsgCardView)localObject).stopPlay();
      }
    }
  }
  
  private void recycleListItem()
  {
    if (this.mFeedHolder != null)
    {
      this.mFeedHolder.onDestroy();
      this.mFeedHolder = null;
      if (this.adapter != null) {
        this.adapter.setFeedHolder(null, this.mShowFeeds, this.mUseNewUI);
      }
    }
    if (this.listView == null) {}
    int j;
    do
    {
      return;
      j = this.listView.getChildCount();
    } while (j <= 0);
    int i = 0;
    label66:
    View localView;
    if (i < j)
    {
      localView = this.listView.getChildAt(i);
      if ((localView instanceof MsgCardView)) {
        break label94;
      }
    }
    for (;;)
    {
      i += 1;
      break label66;
      break;
      label94:
      ((MsgCardView)localView).recycle();
    }
  }
  
  private void refresh()
  {
    this.requestState = 2;
    ((QZoneMsgManager)this.app.getManager(293)).refreshQZoneMsg();
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "refresh ，requestState=" + this.requestState);
    }
  }
  
  private void refreshFinish(boolean paramBoolean)
  {
    setRefreshFootState(paramBoolean);
    this.requestState = 0;
    if (this.adapter.getCount() > 0)
    {
      MQMsg localMQMsg = (MQMsg)this.adapter.getItem(0);
      if (localMQMsg == null) {
        break label115;
      }
      updatePromptText(localMQMsg.promot);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText ，mqMsg.promot=" + localMQMsg.promot);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "refreshFinish ，requestState=" + this.requestState);
      }
      return;
      label115:
      if (QLog.isColorLevel()) {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText mqMsg ==null");
      }
    }
  }
  
  private boolean removeLastEmptyMQMsg()
  {
    if (this.adapter == null)
    {
      QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "removeLastEmptyMQMsg failed: adapter == null");
      return false;
    }
    return this.adapter.removeLastEmptyMQMsg();
  }
  
  private void setFootNavigationInfo(QZoneMsgEntityNew paramQZoneMsgEntityNew)
  {
    if (paramQZoneMsgEntityNew == null)
    {
      paramQZoneMsgEntityNew = new ArrayList();
      paramQZoneMsgEntityNew.add(new BottomItem(amtj.a(2131718769), "mqqzone://arouse/activefeed"));
      paramQZoneMsgEntityNew.add(new BottomItem(amtj.a(2131711136), "mqqzone://arouse/albumlist"));
    }
    for (;;)
    {
      if (this.handler != null) {
        this.handler.post(new QZoneMsgFragment.6(this, paramQZoneMsgEntityNew));
      }
      return;
      paramQZoneMsgEntityNew = paramQZoneMsgEntityNew.bottomItems;
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
    if ((this.mLocalPhotoGroupData == null) || (this.mLocalPhotoGroupData.pathList == null) || (this.mLocalPhotoGroupData.pathList.isEmpty()))
    {
      boolean bool = removeLastEmptyMQMsg();
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: removeLastEmptyMQMsg:" + bool + ", mLocalPhotoGroupData == null || mLocalPhotoGroupData.pathList == null || mLocalPhotoGroupData.pathList.isEmpty()");
    }
    MQMsg localMQMsg;
    do
    {
      do
      {
        return;
        localMQMsg = getLastMQMsg();
        if (localMQMsg != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: getLastMQMsg == null");
      return;
      if (QLog.isColorLevel())
      {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: getLastMQMsg{\nmsgType='" + localMQMsg.msgType + '\'' + '\n' + ", title=" + localMQMsg.title + '\'' + '\n' + ", eventTitle='" + localMQMsg.eventTitle + '\'' + '\n' + ", uniKey='" + localMQMsg.uniKey + '\'' + '\n' + '}');
        if ((localMQMsg.msgBody != null) && (localMQMsg.msgBody.photolist != null)) {
          localObject1 = localMQMsg.msgBody.photolist.iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MQPhotoCell)((Iterator)localObject1).next();
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: cell.coverUrl=" + ((MQPhotoCell)localObject2).coverUrl);
          continue;
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: mqMsg.msgBody.photolist==null");
        }
      }
    } while (((localMQMsg.msgBody.photolist != null) && (!localMQMsg.msgBody.photolist.isEmpty()) && (!StringUtil.isEmpty(((MQPhotoCell)localMQMsg.msgBody.photolist.get(0)).coverUrl))) || (localMQMsg.msgType != 9));
    localMQMsg.uniKey = this.mLocalPhotoGroupData.unikey;
    localMQMsg.eventTitle = this.mLocalPhotoGroupData.title;
    localMQMsg.capTime = this.mLocalPhotoGroupData.capTime;
    Object localObject1 = new ArrayList();
    Object localObject2 = this.mLocalPhotoGroupData.pathList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      MQPhotoCell localMQPhotoCell = new MQPhotoCell();
      localMQPhotoCell.coverUrl = str;
      ((ArrayList)localObject1).add(localMQPhotoCell);
    }
    localMQMsg.msgBody.photolist = ((ArrayList)localObject1);
    this.handler.post(new QZoneMsgFragment.8(this, localMQMsg));
    QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: update last empty MQMsg.");
  }
  
  private void updatePromptText(String paramString)
  {
    ThreadManager.postImmediately(new QZoneMsgFragment.4(this, paramString), null, false);
  }
  
  public FeedViewHolderInterface getFeedHolder()
  {
    return this.mFeedHolder;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      setReaded();
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "EVENT_LOAD_MORE_MANUAL loadMore");
      }
      loadMore(true);
      continue;
      this.adapter.notifyDataSetChanged();
    }
  }
  
  public void jumpToDetail(MQMsg paramMQMsg)
  {
    Object localObject;
    if ((paramMQMsg != null) && (!TextUtils.isEmpty(paramMQMsg.jumpUrlToDetail)))
    {
      localObject = bfwg.a(this.app, getActivity(), paramMQMsg.jumpUrlToDetail);
      if (localObject != null)
      {
        ((bfvp)localObject).a();
        return;
      }
      localObject = new Intent(getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramMQMsg.jumpUrlToDetail);
      QZoneHelper.addSource((Intent)localObject);
      startActivity((Intent)localObject);
      return;
    }
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "msg.jumpUrlToDetail is null");
    if ((paramMQMsg != null) && (paramMQMsg.msgType == 9) && (!StringUtil.isEmpty(paramMQMsg.uniKey)))
    {
      localObject = "mqqzone://arouse/photogrouprecommenddetail?usecache=true&checkgroup=false&unikey=" + paramMQMsg.uniKey;
      jumpToPhotoGroupRecommendDetail((String)localObject);
      LpReportInfo_dc02880.report(2, 2, (String)localObject, "29", false, true);
      LpReportInfo_pf00064.allReport(133, 14, String.valueOf(paramMQMsg.msgType));
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "jumpToPhotoGroupRecommendDetail: uniKey=" + paramMQMsg.uniKey);
      return;
    }
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "msg == null | msg.msgType != ENUM_PUSH_MSG_TYPE._ENUM_TRAVEL_ALBUM | StringUtil.isEmpty(msg.uniKey)");
  }
  
  public void jumpToPhotoGroupRecommendDetail(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString));
    localIntent.setPackage("com.tencent.mobileqq");
    getActivity().getApplicationContext().startActivity(localIntent);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ThreadManagerV2.excute(new QZoneMsgFragment.5(this, (QZoneMsgManager)this.app.getManager(293)), 32, null, true);
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
    getActivity().registerReceiver(this.mSyncCommentLikeReceiver, (IntentFilter)localObject);
    this.handler = new Handler(Looper.getMainLooper(), this);
    this.mUseNewUI = QZoneApiProxy.needShowSubFeedList(paramActivity, this.app);
    if (QZoneApiProxy.needLoadQZoneEnv()) {
      if (QzonePluginProxyActivity.getQZonePluginClassLoaderInUI() == null)
      {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneMsgFragment.1(this, paramActivity));
        this.mShowFeeds = false;
      }
    }
    for (;;)
    {
      if (this.mShowFeeds)
      {
        localObject = QZoneApiProxy.getLastRuntime();
        if (this.app != localObject) {
          QZoneApiProxy.onAccountChange(paramActivity, this.app);
        }
      }
      return;
      this.mShowFeeds = this.mUseNewUI;
      continue;
      this.mShowFeeds = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.isNightMode = ThemeUtil.isNowThemeIsNightForQzone();
    if (this.isNightMode) {
      paramViewGroup.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131562350, paramViewGroup, false);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramViewGroup.setBackgroundColor(-1380874);
    }
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
    getActivity().unregisterReceiver(this.mSyncCommentLikeReceiver);
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
  
  public void onStart()
  {
    super.onStart();
    if (this.mFeedHolder != null) {
      this.mFeedHolder.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mFeedHolder != null) {
      this.mFeedHolder.onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.listView = ((ListView)paramView.findViewById(2131371439));
    paramBundle = paramView.findViewById(2131375235);
    this.listView.setEmptyView(paramBundle);
    paramBundle = getActivity();
    if ((this.mShowFeeds) && (paramBundle != null))
    {
      this.mFeedHolder = QZoneApiProxy.createMsgFeedViewHolder(paramBundle);
      if (this.mFeedHolder != null) {
        this.mFeedHolder.setHandler(this.handler);
      }
      this.adapter = new QZoneMsgAdapter(getActivity());
      this.adapter.setNightMode(this.isNightMode);
      this.adapter.setFeedHolder(this.mFeedHolder, this.mShowFeeds, this.mUseNewUI);
      this.adapter.setOnGetViewLinstener(this);
      this.adapter.setMsgOnClickListener(this.msgOnClickListener);
      this.listView.setOnScrollListener(this.onScrollListener);
      this.listView.setAdapter(this.adapter);
      this.mFootNavigationLayout = ((FootNavigationLayout)paramView.findViewById(2131371433));
      paramBundle = this.mFootNavigationLayout;
      if (!this.mUseNewUI) {
        break label249;
      }
    }
    label249:
    for (int i = 0;; i = 8)
    {
      paramBundle.setArrowVisible(i);
      if (this.isNightMode) {
        this.mFootNavigationLayout.setNightMode(true);
      }
      setFootNavigationInfo(null);
      initEmptyView(paramView);
      return;
      if (this.mFeedHolder == null) {
        break;
      }
      this.mFeedHolder.onDestroy();
      this.mFeedHolder = null;
      break;
    }
  }
  
  protected final void setFooterState(int paramInt)
  {
    setFooterState(paramInt, true);
  }
  
  protected final void setFooterState(int paramInt, boolean paramBoolean)
  {
    if ((this.viewFooterContainer == null) || (this.listView == null)) {}
    do
    {
      do
      {
        return;
        QZLog.i("QZoneMsgManager.QZoneMsgFragment", "QZoneMsgManager.QZoneMsgFragment setFooterState(), state: " + paramInt);
        this.viewListFooter.setState(paramInt);
        if (paramBoolean) {
          this.footerPreState = paramInt;
        }
        if (paramInt != 3) {
          break;
        }
      } while (this.viewFooterContainer.getVisibility() == 8);
      this.viewFooterContainer.setVisibility(8);
      return;
    } while (this.viewFooterContainer.getVisibility() == 0);
    this.viewFooterContainer.setVisibility(0);
  }
  
  public void setLocalPhotoGroupData(LocalPhotoGroupData paramLocalPhotoGroupData)
  {
    this.mLocalPhotoGroupData = paramLocalPhotoGroupData;
    updateMQMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment
 * JD-Core Version:    0.7.0.1
 */