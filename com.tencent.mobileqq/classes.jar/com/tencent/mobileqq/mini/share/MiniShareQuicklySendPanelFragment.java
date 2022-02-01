package com.tencent.mobileqq.mini.share;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.mobileqq.widget.ISlidePanelListener;
import com.tencent.mobileqq.widget.SlideBottomPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.List;

public class MiniShareQuicklySendPanelFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ISlidePanelListener
{
  public static final int QUCIKLY_SHARE_REQUEST_CODE = 678;
  public static final String TAG = "MiniShareQuicklySendPanelFragment";
  private MiniShareQuicklySendPanelAdapter adapter;
  private ImageView arrowView;
  private View backgroundView;
  private View contentView;
  private View footerView;
  private boolean isCallback = false;
  private boolean isShowedPanel = false;
  private XListView listView;
  private ScreenShotHelper mHelper;
  private View mRootView;
  private Handler mainHandler;
  private boolean needShareCallback = false;
  private SlideBottomPanel slidePanel;
  
  private void dealSendViewAnimation()
  {
    View localView = this.footerView;
    if ((localView != null) && (localView.getVisibility() == 8) && (this.slidePanel.b())) {
      showSendView(0, 1, 0);
    }
  }
  
  private View getBottomView()
  {
    View localView = new View(getBaseActivity());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(130.0F, getResources())));
    localView.setBackgroundResource(2130850703);
    return localView;
  }
  
  private void initData()
  {
    Bundle localBundle = getBaseActivity().getIntent().getExtras();
    this.mHelper = new ScreenShotHelper();
    List localList = this.mHelper.a(getBaseActivity(), getBaseActivity().app);
    if (localBundle != null)
    {
      this.needShareCallback = localBundle.getBoolean("needShareCallBack", false);
      localBundle.putBoolean("needShareCallBack", false);
    }
    this.adapter = new MiniShareQuicklySendPanelAdapter(getBaseActivity(), getBaseActivity().app, this.listView, localBundle);
    this.adapter.setData(wipeOutPC(localList));
    this.listView.setAdapter(this.adapter);
  }
  
  private void shareCallBack(boolean paramBoolean)
  {
    if ((this.needShareCallback) && (!this.isCallback))
    {
      this.isCallback = true;
      if (paramBoolean)
      {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
        return;
      }
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
    }
  }
  
  private void showSendView(int paramInt1, int paramInt2, int paramInt3)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramInt1, paramInt2);
    this.footerView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    this.footerView.setVisibility(paramInt3);
  }
  
  private ArrayList<MiniShareQuicklySendPanelAdapter.SendPanelData> wipeOutPC(List<RecentBaseData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)paramList.get(i);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wipeOutPC RecentBaseData :");
      localStringBuilder.append(localRecentBaseData.getTitleName());
      QLog.d(str, 4, localStringBuilder.toString());
      if (localRecentBaseData.getRecentUserType() == 6000) {
        paramList.remove(localRecentBaseData);
      } else {
        localArrayList.add(new MiniShareQuicklySendPanelAdapter.SendPanelData(localRecentBaseData));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void cancelAnimator() {}
  
  public void displayPanel()
  {
    dealSendViewAnimation();
    View localView = this.backgroundView;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  public void displayPanelFinish()
  {
    ImageView localImageView = this.arrowView;
    if (localImageView != null) {
      localImageView.setBackgroundResource(2130850002);
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    View localView = this.backgroundView;
    if (localView != null)
    {
      localView.setVisibility(0);
      this.backgroundView.setAlpha(paramFloat);
    }
  }
  
  public void hidePanel()
  {
    View localView = this.footerView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      showSendView(1, 0, 8);
    }
    localView = this.backgroundView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.mainHandler.postDelayed(new MiniShareQuicklySendPanelFragment.1(this), 500L);
  }
  
  public void hidePanelFinish()
  {
    ImageView localImageView = this.arrowView;
    if (localImageView != null) {
      localImageView.setBackgroundResource(2130850001);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult requestCode:");
    localStringBuilder.append(paramInt1);
    QLog.d(str, 4, localStringBuilder.toString());
    if (paramInt1 == 678) {
      if (paramInt2 == -1)
      {
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult RESULT_OK:");
        localStringBuilder.append(paramInt2);
        QLog.d(str, 4, localStringBuilder.toString());
        shareCallBack(true);
        this.adapter.notifyShareSuc();
      }
      else
      {
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult other:");
        localStringBuilder.append(paramInt2);
        QLog.d(str, 4, localStringBuilder.toString());
        this.adapter.notifyShareCancel();
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131377187) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 4, "R.id.send - onClick");
    }
    getBaseActivity().finish();
    getBaseActivity().overridePendingTransition(0, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getBaseActivity().app == null) {
      return null;
    }
    this.mainHandler = new Handler(Looper.getMainLooper());
    this.mRootView = paramLayoutInflater.inflate(2131562840, paramViewGroup, false);
    this.slidePanel = ((SlideBottomPanel)this.mRootView.findViewById(2131377660));
    this.contentView = this.mRootView.findViewById(2131365203);
    this.listView = ((XListView)this.mRootView.findViewById(2131370110));
    this.footerView = this.mRootView.findViewById(2131377234);
    this.backgroundView = this.mRootView.findViewById(2131363349);
    this.arrowView = ((ImageView)this.mRootView.findViewById(2131379075));
    this.listView.addFooterView(getBottomView());
    this.slidePanel.setSlidePanelListener(this);
    this.footerView.findViewById(2131377187).setOnClickListener(this);
    initData();
    return this.mRootView;
  }
  
  public void onDestroy()
  {
    MiniShareQuicklySendPanelAdapter localMiniShareQuicklySendPanelAdapter = this.adapter;
    if (localMiniShareQuicklySendPanelAdapter != null) {
      localMiniShareQuicklySendPanelAdapter.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    shareCallBack(false);
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    SlideBottomPanel localSlideBottomPanel = this.slidePanel;
    if ((localSlideBottomPanel != null) && (!this.isShowedPanel)) {
      localSlideBottomPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelFragment
 * JD-Core Version:    0.7.0.1
 */