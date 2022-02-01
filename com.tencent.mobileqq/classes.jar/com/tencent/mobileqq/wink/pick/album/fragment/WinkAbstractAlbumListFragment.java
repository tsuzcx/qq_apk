package com.tencent.mobileqq.wink.pick.album.fragment;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListBaseData;
import com.tencent.mobileqq.wink.pick.album.adapter.WinkAlbumListAdapter;
import com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogic;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public abstract class WinkAbstractAlbumListFragment
  extends ReportFragment
{
  public WinkAbstractAlbumListFragment.IAlbumListBack a;
  public WinkAlbumListLogic b;
  AlbumListBaseData c;
  FrameLayout d;
  public WinkAlbumListAdapter e;
  public XListView f;
  XFrameLayout g;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.g = ((XFrameLayout)paramView.findViewById(2131437304));
    this.g.setCornerRadiusAndMode(Utils.dp2px(10.0D), 5);
    this.f = ((XListView)paramView.findViewById(2131428186));
    this.f.setWrapByScroll(true);
    this.f.setAdapter(this.e);
    this.f.setOnItemClickListener(new WinkAbstractAlbumListFragment.AlbumListItemClickListener(this, null));
    this.f.setOverScrollMode(2);
    this.f.setDivider(null);
    this.f.setVerticalScrollBarEnabled(false);
    this.d = ((FrameLayout)paramView.findViewById(2131428217));
    this.d.setOnClickListener(new WinkAbstractAlbumListFragment.1(this));
    paramView.findViewById(2131428216).setVisibility(8);
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new WinkAbstractAlbumListFragment.2(this, i, j));
    this.b.b();
  }
  
  protected abstract WinkAlbumListLogic a();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131628231, paramViewGroup, false);
    this.b = a();
    this.c = this.b.c;
    paramViewGroup = getActivity().getIntent();
    this.b.a(paramViewGroup);
    a(paramLayoutInflater);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WinkAlbumListLogic localWinkAlbumListLogic = this.b;
    if (localWinkAlbumListLogic != null) {
      localWinkAlbumListLogic.dA_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.fragment.WinkAbstractAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */