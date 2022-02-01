package com.tencent.mobileqq.emoticonview.relateemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class RelatedEmotionPanel
  extends LinearLayout
  implements DialogInterface.OnDismissListener, View.OnClickListener, IRelatedEmotionPanel, RelatedEmoticonManager.Callback
{
  private static final int ITEM_TYPE_FIRST_LOAD_ERROR = 2;
  private static final int ITEM_TYPE_INIT = 0;
  private static final int ITEM_TYPE_LOAD_EMPTY = 3;
  private static final int ITEM_TYPE_NO_LOAD_MORE = 1;
  private static final String TAG = "RelatedEmotionPanel";
  private BaseQQAppInterface mApp;
  private EmoticonCallback mCallBack;
  private ChatMessage mChatMessage = null;
  protected String mCurFriendUin = "";
  private int mCurType = 0;
  private IAIORelatedEmotionExpandHelper mEmotionExpandHelper;
  private RelatedEmoticonListAdapter mEmotionSearchAdapter;
  protected View mFooterView;
  protected int mLastScrollState = 0;
  private int mLoadingStatus = 0;
  private RecyclerView mRecyclerView;
  private RelatedEmoticonManager mRelatedEmoticonManager;
  private boolean mReportedNoMore = false;
  private Dialog mSearchPanelDialog;
  
  public RelatedEmotionPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public RelatedEmotionPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RelatedEmotionPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void initData(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, URLDrawable paramURLDrawable)
  {
    URLImageView localURLImageView = new URLImageView(getContext());
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    Object localObject1 = new LinearLayout.LayoutParams(ViewUtils.dip2px(80.0F), ViewUtils.dip2px(80.0F));
    ((LinearLayout.LayoutParams)localObject1).topMargin = ViewUtils.dip2px(6.0F);
    localLinearLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    boolean bool = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.waitAppRuntime(null), false, null);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131447481);
    localTextView.setTextSize(12.0F);
    if (bool) {
      localObject1 = "#8D8D93";
    } else {
      localObject1 = "#878B99";
    }
    localTextView.setTextColor(Color.parseColor((String)localObject1));
    localTextView.setText(getContext().getResources().getString(2131915659));
    localTextView.setGravity(17);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout(getContext());
    View localView1 = new View(getContext());
    View localView2 = new View(getContext());
    if (bool) {
      localObject1 = "#3D3D41";
    } else {
      localObject1 = "#EBEDF5";
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(0.5F));
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(0, 2131447481);
    localLayoutParams.leftMargin = ViewUtils.dip2px(14.0F);
    localLayoutParams.rightMargin = ViewUtils.dip2px(12.0F);
    localView1.setBackgroundColor(Color.parseColor((String)localObject1));
    localView1.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(0.5F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(1, 2131447481);
    localLayoutParams.leftMargin = ViewUtils.dip2px(12.0F);
    localLayoutParams.rightMargin = ViewUtils.dip2px(14.0F);
    localView2.setBackgroundColor(Color.parseColor((String)localObject1));
    localView2.setLayoutParams(localLayoutParams);
    ((RelativeLayout)localObject2).addView(localTextView);
    ((RelativeLayout)localObject2).addView(localView1);
    ((RelativeLayout)localObject2).addView(localView2);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject1).topMargin = ViewUtils.dip2px(20.0F);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.mRecyclerView = ((RecyclerView)findViewById(2131444519));
    localURLImageView.setImageDrawable(paramURLDrawable);
    this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    this.mRecyclerView.setVerticalScrollBarEnabled(false);
    this.mEmotionSearchAdapter = new RelatedEmoticonListAdapter(paramBaseQQAppInterface, getContext(), this.mCallBack);
    this.mEmotionSearchAdapter.setReportMessage(this.mCurFriendUin, this.mCurType);
    this.mRecyclerView.setAdapter(this.mEmotionSearchAdapter);
    this.mEmotionSearchAdapter.setData(localLinearLayout, getFooterView(), new ArrayList());
    this.mRecyclerView.setOnScrollListener(new RelatedEmotionPanel.3(this));
    this.mRelatedEmoticonManager = new RelatedEmoticonManager(paramBaseQQAppInterface, this);
    this.mRelatedEmoticonManager.searchRelatedEmoticon(paramChatMessage, this.mCurType);
  }
  
  private void notifyFooterViewChange()
  {
    if (this.mFooterView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RelatedEmotionPanel", 2, "notifyFooterViewChange.");
    }
    TextView localTextView1 = (TextView)this.mFooterView.findViewById(2131435179);
    localTextView1.setTextSize(14.0F);
    View localView = this.mFooterView.findViewById(2131435178);
    TextView localTextView2 = (TextView)this.mFooterView.findViewById(2131437659);
    localTextView2.setTextSize(14.0F);
    localTextView1.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.mFooterView.getLayoutParams();
    int i = ViewUtils.dip2px(74.0F);
    if (localLayoutParams.height != i)
    {
      localLayoutParams.height = i;
      this.mFooterView.setLayoutParams(localLayoutParams);
    }
    i = this.mLoadingStatus;
    if (i == 0)
    {
      localView.setVisibility(0);
      localTextView2.setText(2131886495);
      localTextView1.setVisibility(4);
      return;
    }
    if (i == 2)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131886500);
      localView.setVisibility(4);
      ReportController.b(this.mApp, "dc00898", "", this.mCurFriendUin, "0X800B11B", "0X800B11B", 0, 0, "", "", "", "");
      return;
    }
    if (i == 1)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131915661);
      localTextView1.setClickable(false);
      localView.setVisibility(4);
      return;
    }
    if (i == 3)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131915660);
      localTextView1.setClickable(false);
      localView.setVisibility(4);
      return;
    }
    localTextView1.setVisibility(8);
    localView.setVisibility(8);
    localLayoutParams.height = -2;
    this.mFooterView.setLayoutParams(localLayoutParams);
  }
  
  public void dismissEmotionSearchWinow()
  {
    Dialog localDialog = this.mSearchPanelDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.mSearchPanelDialog.dismiss();
    }
  }
  
  protected View getFooterView()
  {
    if (this.mFooterView == null)
    {
      this.mFooterView = View.inflate(getContext(), 2131627959, null);
      this.mFooterView.setBackgroundColor(0);
      this.mFooterView.setLayoutParams(new RecyclerView.LayoutParams(-1, ViewUtils.dip2px(74.0F)));
    }
    notifyFooterViewChange();
    return this.mFooterView;
  }
  
  public void init(BaseQQAppInterface paramBaseQQAppInterface, EmoticonCallback paramEmoticonCallback, IAIORelatedEmotionExpandHelper paramIAIORelatedEmotionExpandHelper)
  {
    this.mApp = paramBaseQQAppInterface;
    this.mEmotionExpandHelper = paramIAIORelatedEmotionExpandHelper;
    this.mCallBack = paramEmoticonCallback;
  }
  
  public <T> boolean isEmpty(List<T> paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131435179)
    {
      this.mLoadingStatus = 0;
      notifyFooterViewChange();
      RelatedEmoticonManager localRelatedEmoticonManager = this.mRelatedEmoticonManager;
      if (localRelatedEmoticonManager != null) {
        localRelatedEmoticonManager.searchRelatedEmoticon(this.mChatMessage, this.mCurType);
      }
      ReportController.b(this.mApp, "dc00898", "", this.mCurFriendUin, "0X800B11C", "0X800B11C", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    this.mSearchPanelDialog = null;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.mEmotionExpandHelper;
    if (paramDialogInterface != null) {
      paramDialogInterface.onClosePanel();
    }
    paramDialogInterface = this.mRelatedEmoticonManager;
    if (paramDialogInterface != null) {
      paramDialogInterface.onDestroy();
    }
    this.mApp = null;
    this.mRecyclerView = null;
    this.mEmotionSearchAdapter = null;
    this.mRelatedEmoticonManager = null;
  }
  
  public void onError(int paramInt)
  {
    if (this.mRecyclerView != null)
    {
      Object localObject = this.mEmotionSearchAdapter;
      if (localObject == null) {
        return;
      }
      this.mLoadingStatus = 2;
      if ((((RelatedEmoticonListAdapter)localObject).getData() != null) && (!this.mEmotionSearchAdapter.getData().isEmpty()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" load more error ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.e("RelatedEmotionPanel", 4, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" first load error ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.e("RelatedEmotionPanel", 4, ((StringBuilder)localObject).toString());
      }
      notifyFooterViewChange();
    }
  }
  
  public void onResult(RelatedEmoticonManager.RelatedEmotionSearchResult paramRelatedEmotionSearchResult)
  {
    if (this.mRecyclerView != null)
    {
      Object localObject = this.mEmotionSearchAdapter;
      if (localObject != null)
      {
        if (paramRelatedEmotionSearchResult == null) {
          return;
        }
        if ((isEmpty(((RelatedEmoticonListAdapter)localObject).getData())) && (isEmpty(paramRelatedEmotionSearchResult.resultItems)))
        {
          this.mLoadingStatus = 3;
        }
        else
        {
          this.mLoadingStatus = 1;
          localObject = new ArrayList();
          int i = 0;
          while (i < paramRelatedEmotionSearchResult.resultItems.size())
          {
            RelatedEmoSearchEmoticonInfo localRelatedEmoSearchEmoticonInfo = new RelatedEmoSearchEmoticonInfo((RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem)paramRelatedEmotionSearchResult.resultItems.get(i), paramRelatedEmotionSearchResult.defaultCount);
            localRelatedEmoSearchEmoticonInfo.setReportMessage(this.mCurFriendUin, this.mCurType, i);
            ((List)localObject).add(localRelatedEmoSearchEmoticonInfo);
            i += 1;
          }
          this.mEmotionSearchAdapter.setData((List)localObject);
        }
        notifyFooterViewChange();
      }
    }
  }
  
  public void showEmotionSearchWindow(ChatMessage paramChatMessage, URLDrawable paramURLDrawable, int paramInt)
  {
    if ((!(paramChatMessage instanceof MessageForPic)) && (!(paramChatMessage instanceof MessageForMarketFace))) {
      return;
    }
    Object localObject = this.mSearchPanelDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    if ((getContext() instanceof Activity))
    {
      if (((Activity)getContext()).isFinishing()) {
        return;
      }
      this.mChatMessage = paramChatMessage;
      this.mCurFriendUin = paramChatMessage.frienduin;
      this.mCurType = paramChatMessage.istroop;
      initData(this.mApp, paramChatMessage, paramURLDrawable);
      paramChatMessage = new RelatedEmoSlideBottomPanel(getContext());
      paramChatMessage.setContentHeight(paramInt);
      paramChatMessage.setContentView(this);
      paramChatMessage.setCallback(new RelatedEmotionPanel.1(this));
      if (this.mSearchPanelDialog == null) {
        this.mSearchPanelDialog = new ReportDialog(getContext(), 2131952034);
      }
      this.mSearchPanelDialog.setContentView(paramChatMessage);
      this.mSearchPanelDialog.setOnDismissListener(this);
      this.mSearchPanelDialog.setOnKeyListener(new RelatedEmotionPanel.2(this, paramChatMessage));
      paramURLDrawable = this.mSearchPanelDialog.getWindow();
      if (paramURLDrawable != null)
      {
        int i = ViewUtils.getScreenHeight() - ViewUtils.getStatusBarHeight(getContext());
        paramInt = i;
        if (i == 0) {
          paramInt = -1;
        }
        paramURLDrawable.setLayout(-1, paramInt);
        localObject = paramURLDrawable.getAttributes();
        ((WindowManager.LayoutParams)localObject).gravity = 80;
        paramURLDrawable.setAttributes((WindowManager.LayoutParams)localObject);
      }
      paramChatMessage.displayPanel();
      this.mSearchPanelDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel
 * JD-Core Version:    0.7.0.1
 */