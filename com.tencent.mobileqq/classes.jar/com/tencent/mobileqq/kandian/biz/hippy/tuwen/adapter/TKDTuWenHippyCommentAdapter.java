package com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.HippyCommentPageListener;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.ITKDHippy2NativeEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.ITKDHippy2TuWenEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.app.TKDTuWenHippyEngine;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenHippyEngineManager;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenHippyEngineManager.StatusChangeListener;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.HippyRootLayout;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;

public class TKDTuWenHippyCommentAdapter
  extends BaseAdapter
  implements TKDTuWenHippyEngineManager.StatusChangeListener
{
  private static final String TAG = "TKDTuWenHippyCommentAdapter";
  private int adTag;
  AnchorData anchorData;
  private int biuType;
  private ReadInJoyCommentDataManager commentDataManager;
  int contentSrc;
  private final QBaseActivity context;
  private TKDTuWenHippyCommentAdapter.MyDataChangeListener dataChangeListener;
  private TKDTuWenHippyEngineManager engineManager;
  private final ITKDHippyEventReceiver hippyCommentEventReceiver = new TKDTuWenHippyCommentAdapter.HippyCommentEventReceiver(this, null);
  private HippyCommentPageListener hippyCommentPageListener;
  private TKDTuWenHippyEngine hippyEngine;
  private RecyclerView.OnListScrollListener hippyScrollListener;
  private TKDTuWenHippyCommentAdapter.ActivityLifecycleCallbacks lifecycleCallbacks;
  AbsBaseArticleInfo mArticleInfo;
  boolean openCommentEditor;
  private ITKDHippy2NativeEventReceiver subHippyEventReceiver;
  private ITKDHippy2TuWenEventReceiver tuWenHippyCallback;
  private HippyRootLayout vContainer;
  private NSHippyListView vHippyList;
  private HippyRootView vHippyRoot;
  ListView vList;
  private WebViewProgressBar vProgress;
  
  public TKDTuWenHippyCommentAdapter(QBaseActivity paramQBaseActivity)
  {
    this.context = paramQBaseActivity;
  }
  
  private void addHippyViewToHippyLayout()
  {
    QLog.d("TKDTuWenHippyCommentAdapter", 1, "#addHippyViewToHippyLayout: begin");
    if (this.vContainer == null) {
      return;
    }
    if (this.vHippyRoot != null)
    {
      QLog.d("TKDTuWenHippyCommentAdapter", 1, "#addHippyViewToHippyLayout: vHippyRoot is not null");
      if (this.vHippyRoot.getParent() == null)
      {
        this.vContainer.addView(this.vHippyRoot);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#addHippyViewToHippyLayout: vHippyRoot setup parent, vContainer=");
        ((StringBuilder)localObject).append(this.vContainer);
        QLog.d("TKDTuWenHippyCommentAdapter", 1, ((StringBuilder)localObject).toString());
      }
      int i = this.vList.getMeasuredHeight();
      if (i > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#addHippyViewToHippyLayout: vContainer setMaxHeight=");
        ((StringBuilder)localObject).append(i);
        QLog.d("TKDTuWenHippyCommentAdapter", 1, ((StringBuilder)localObject).toString());
        this.vContainer.setMaxHeight(i);
      }
      this.vProgress.setVisibility(8);
    }
    else
    {
      this.vProgress.setVisibility(0);
    }
    Object localObject = (AbsListView.LayoutParams)this.vContainer.getLayoutParams();
    ((AbsListView.LayoutParams)localObject).height = this.vContainer.getDesiredHeight();
    this.vContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private HippyMap getPropMap()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean initHippyEngine()
  {
    this.engineManager = new TKDTuWenHippyEngineManager(this.context);
    this.hippyEngine = this.engineManager.getEngine();
    this.hippyEngine.getTKDHippyEventDispatcher().register(this.hippyCommentEventReceiver);
    int i = this.engineManager.getStatus();
    boolean bool = true;
    if (i != 1)
    {
      if (i != 3) {
        bool = false;
      } else {
        onEngineLoadSuccess();
      }
    }
    else {
      this.engineManager.setStatusChangeListener(this);
    }
    if (!bool) {
      notifyHippyLoadFinish(false);
    }
    return bool;
  }
  
  private void initView()
  {
    if (this.vContainer != null) {
      return;
    }
    this.vContainer = ((HippyRootLayout)LayoutInflater.from(this.context).inflate(2131626010, this.vList, false));
    this.vProgress = ((WebViewProgressBar)this.vContainer.findViewById(2131440737));
    WebViewProgressBarController localWebViewProgressBarController = new WebViewProgressBarController();
    localWebViewProgressBarController.a(this.vProgress);
    this.vProgress.setController(localWebViewProgressBarController);
    localWebViewProgressBarController.a((byte)0);
    addHippyViewToHippyLayout();
  }
  
  private void notifyDeleteMainComment(String paramString)
  {
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine != null) {
      localTKDTuWenHippyEngine.getTKDHippyEventDispatcher().onDeleteMainComment(paramString);
    }
  }
  
  private void notifyDeleteSubComment(String paramString1, String paramString2)
  {
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine != null) {
      localTKDTuWenHippyEngine.getTKDHippyEventDispatcher().onDeleteSubComment(paramString1, paramString2);
    }
  }
  
  private void notifyHippyLoadFinish(boolean paramBoolean)
  {
    HippyCommentPageListener localHippyCommentPageListener = this.hippyCommentPageListener;
    if (localHippyCommentPageListener != null) {
      localHippyCommentPageListener.a(paramBoolean);
    }
  }
  
  private void notifyInsertSubComment(String paramString1, String paramString2, String paramString3)
  {
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine != null) {
      localTKDTuWenHippyEngine.getTKDHippyEventDispatcher().onInsertSubComment(paramString1, paramString2, paramString3);
    }
  }
  
  private void notifyLikeMainComment(String paramString, boolean paramBoolean)
  {
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine != null) {
      localTKDTuWenHippyEngine.getTKDHippyEventDispatcher().onLikeMainCommentChanged(paramString, paramBoolean);
    }
  }
  
  private void onEngineLoadSuccess()
  {
    QLog.d("TKDTuWenHippyCommentAdapter", 1, "#onEngineLoadSuccess: begin");
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine == null)
    {
      QLog.d("TKDTuWenHippyCommentAdapter", 1, "#onEngineLoadSuccess: hippyEngine is null");
      return;
    }
    localTKDTuWenHippyEngine.getTKDHippyEventDispatcher().refreshNewAndHotData(getPropMap());
    initDelay();
    initView();
    this.vHippyRoot = this.hippyEngine.getHippyRootView();
    addHippyViewToHippyLayout();
    notifyHippyLoadFinish(true);
    notifyDataSetChanged();
    scrollToTop();
  }
  
  private void removeHippyScrollListener()
  {
    RecyclerView.OnListScrollListener localOnListScrollListener = this.hippyScrollListener;
    if (localOnListScrollListener != null)
    {
      NSHippyListView localNSHippyListView = this.vHippyList;
      if (localNSHippyListView != null) {
        localNSHippyListView.removeOnListScrollListener(localOnListScrollListener);
      }
    }
  }
  
  private void scrollToTop()
  {
    if (this.vHippyList == null) {
      this.vHippyList = ((NSHippyListView)TKDTuWenCommentUtil.rFindView(this.vContainer, NSHippyListView.class, true));
    }
    NSHippyListView localNSHippyListView = this.vHippyList;
    if (localNSHippyListView != null) {
      localNSHippyListView.scrollToTopRightAway();
    }
  }
  
  private void wrapperIntentForEditComment(Intent paramIntent)
  {
    if (paramIntent.hasExtra("comment_create_data")) {
      return;
    }
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.contentSrc, "");
    localFirstCommentCreateData.b(this.mArticleInfo.innerUniqueID);
    localFirstCommentCreateData.c(String.valueOf(this.mArticleInfo.mArticleID));
    localFirstCommentCreateData.b(0);
    paramIntent.putExtra("comment_create_data", localFirstCommentCreateData);
  }
  
  public void destroy()
  {
    removeHippyScrollListener();
    Object localObject = this.engineManager;
    if (localObject != null) {
      ((TKDTuWenHippyEngineManager)localObject).destroy();
    }
    localObject = this.hippyEngine;
    if (localObject != null)
    {
      ((TKDTuWenHippyEngine)localObject).getTKDHippyEventDispatcher().unregister(this.hippyCommentEventReceiver);
      this.hippyEngine = null;
    }
    this.hippyCommentPageListener = null;
    localObject = this.commentDataManager;
    if (localObject != null) {
      ((ReadInJoyCommentDataManager)localObject).b(this.dataChangeListener);
    }
    this.context.unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public ITKDHippy2NativeEventReceiver getSubHippyEventReceiver()
  {
    if (this.subHippyEventReceiver == null) {
      this.subHippyEventReceiver = new TKDTuWenHippyCommentAdapter.MySubHippyEventReceiver(this, null);
    }
    return this.subHippyEventReceiver;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    addHippyViewToHippyLayout();
    return this.vContainer;
  }
  
  public void init()
  {
    if (initHippyEngine()) {
      initView();
    }
  }
  
  void initDelay()
  {
    this.lifecycleCallbacks = new TKDTuWenHippyCommentAdapter.ActivityLifecycleCallbacks(this, null);
    this.lifecycleCallbacks.doOnActivityPostResumed(this.context);
    this.context.registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
    this.commentDataManager = ReadInJoyCommentDataManager.a(this.mArticleInfo, this.contentSrc);
    this.dataChangeListener = new TKDTuWenHippyCommentAdapter.MyDataChangeListener(this, null);
    this.commentDataManager.a(this.dataChangeListener);
    this.commentDataManager.i_(true);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 117) {
      wrapperIntentForEditComment(paramIntent);
    }
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine != null) {
      localTKDTuWenHippyEngine.getActivityLifecycleDispatcher().onActivityResult(this.context, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onOpenCommentEdit()
  {
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine != null) {
      localTKDTuWenHippyEngine.getTKDHippyEventDispatcher().onOpenCommentPublisher();
    }
  }
  
  public void onStatusChange(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#onStatusChange: status=");
    localStringBuilder.append(paramInt);
    QLog.d("TKDTuWenHippyCommentAdapter", 1, localStringBuilder.toString());
    if (paramInt != 3)
    {
      notifyHippyLoadFinish(false);
      return;
    }
    onEngineLoadSuccess();
  }
  
  public void sendCommentReadTime(long paramLong)
  {
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine != null) {
      localTKDTuWenHippyEngine.getTKDHippyEventDispatcher().sendCommentReadTime(paramLong);
    }
  }
  
  public void setHippyCommentPageListener(HippyCommentPageListener paramHippyCommentPageListener)
  {
    this.hippyCommentPageListener = paramHippyCommentPageListener;
  }
  
  public void setHippyScrollListener(RecyclerView.OnListScrollListener paramOnListScrollListener)
  {
    this.hippyScrollListener = paramOnListScrollListener;
    NSHippyListView localNSHippyListView = this.vHippyList;
    if (localNSHippyListView != null) {
      localNSHippyListView.addOnListScrollListener(paramOnListScrollListener);
    }
  }
  
  public void setTuWenHippyCallback(ITKDHippy2TuWenEventReceiver paramITKDHippy2TuWenEventReceiver)
  {
    this.tuWenHippyCallback = paramITKDHippy2TuWenEventReceiver;
  }
  
  public void updateFollowUI(long paramLong, int paramInt)
  {
    TKDTuWenHippyEngine localTKDTuWenHippyEngine = this.hippyEngine;
    if (localTKDTuWenHippyEngine != null) {
      localTKDTuWenHippyEngine.getTKDHippyEventDispatcher().updateFollowUI(paramLong, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter
 * JD-Core Version:    0.7.0.1
 */