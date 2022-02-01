package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.Iterator;
import java.util.List;

@MiniKeep
public class MoreFragment
  extends MiniBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  public static final String MINI_APP_ID = "miniAppID";
  public static final String TAG = "MoreFragment";
  private RelativeLayout actionSheet;
  private String appID = null;
  private View mAfRootView;
  private TextView mCancelText;
  private Animation mExitAnimation;
  private List<MoreItem> mMoreItemList;
  private LinearLayout mMoreItemListLayout;
  private int mScreenHeight;
  private int mStatusBarHeight;
  
  private void dismiss(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      localIntent.putExtra("miniAppID", this.appID);
      localIntent.putExtra("more_item_id", paramInt);
      localIntent.putExtra("share_in_mini_process", paramBoolean);
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      if (getActivity() != null)
      {
        getActivity().setResult(-1, localIntent);
        getActivity().finish();
      }
    }
  }
  
  private void doActionSheetUpAnimation()
  {
    if (this.actionSheet == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.actionSheet.startAnimation(localAnimationSet);
  }
  
  private Intent getIntent()
  {
    if (getActivity() != null) {
      return getActivity().getIntent();
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.mAfRootView;
    int i = 0;
    boolean bool;
    if (paramView == localObject)
    {
      bool = false;
    }
    else if ((paramView != this.mCancelText) && ((paramView instanceof MoreItemView)))
    {
      localObject = ((MoreItemView)paramView).getMoreItem();
      i = ((MoreItem)localObject).id;
      bool = ((MoreItem)localObject).shareInMiniProcess;
    }
    else
    {
      bool = false;
      i = -1;
    }
    dismiss(i, bool, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mScreenHeight = getActivity().getResources().getDisplayMetrics().heightPixels;
    this.mStatusBarHeight = DisplayUtil.getStatusBarHeight(getActivity());
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.mini_sdk_more_actionsheet_layout, paramViewGroup, false);
    if (paramLayoutInflater == null)
    {
      getActivity().finish();
      return null;
    }
    this.mAfRootView = paramLayoutInflater.findViewById(R.id.af_root);
    this.mCancelText = ((TextView)paramLayoutInflater.findViewById(R.id.miniapp_dialog_cancel));
    this.mCancelText.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    paramViewGroup = getIntent();
    if (paramViewGroup == null)
    {
      QMLog.w("MoreFragment", "Failed to create MoreFragment, intent is null");
      if (getActivity() != null) {
        getActivity().finish();
      }
      return null;
    }
    if (paramViewGroup.getBooleanExtra("key_orientation_landscape", false)) {
      getActivity().findViewById(16908290).setBackgroundResource(R.drawable.mini_sdk_more_fragment_background);
    }
    this.mMoreItemListLayout = ((LinearLayout)paramLayoutInflater.findViewById(R.id.more_item_list_layout));
    this.mMoreItemList = paramViewGroup.getParcelableArrayListExtra("key_more_item_list");
    paramViewGroup = this.mMoreItemList;
    if (paramViewGroup == null)
    {
      QMLog.e("MoreFragment", "Failed to create MoreFragmentView. no items");
      getActivity().finish();
    }
    else
    {
      paramViewGroup = paramViewGroup.iterator();
      while (paramViewGroup.hasNext())
      {
        paramBundle = (MoreItem)paramViewGroup.next();
        MoreItemView localMoreItemView = new MoreItemView(getActivity());
        localMoreItemView.bind(paramBundle);
        localMoreItemView.setOnClickListener(this);
        this.mMoreItemListLayout.addView(localMoreItemView);
      }
    }
    this.actionSheet = ((RelativeLayout)paramLayoutInflater);
    this.actionSheet.setVisibility(0);
    doActionSheetUpAnimation();
    return paramLayoutInflater;
  }
  
  public void onStop()
  {
    dismiss(-1, false, null);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MoreFragment
 * JD-Core Version:    0.7.0.1
 */