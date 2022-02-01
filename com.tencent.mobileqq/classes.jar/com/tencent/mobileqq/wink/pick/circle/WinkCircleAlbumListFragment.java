package com.tencent.mobileqq.wink.pick.circle;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListBaseData;
import com.tencent.mobileqq.wink.pick.circle.adapter.AlbumListAdapter;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public class WinkCircleAlbumListFragment
  extends ReportAndroidXFragment
{
  public WinkCircleAlbumListFragment.IAlbumListBack a;
  public WinkCircleAlbumListLogic b;
  AlbumListBaseData c;
  FrameLayout d;
  public AlbumListAdapter e;
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
    this.f.setOnItemClickListener(new WinkCircleAlbumListFragment.AlbumListItemClickListener(this, null));
    this.f.setOverScrollMode(2);
    this.f.setVerticalScrollBarEnabled(false);
    this.d = ((FrameLayout)paramView.findViewById(2131428217));
    this.d.setOnClickListener(new WinkCircleAlbumListFragment.1(this));
    paramView.findViewById(2131428216).setVisibility(8);
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new WinkCircleAlbumListFragment.2(this, i, j));
  }
  
  protected WinkCircleAlbumListLogic a()
  {
    return new WinkCircleAlbumListLogic(this);
  }
  
  public void a(WinkCircleAlbumListFragment.IAlbumListBack paramIAlbumListBack)
  {
    this.a = paramIAlbumListBack;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131628232, paramViewGroup, false);
    this.b = a();
    this.c = this.b.c;
    paramViewGroup = getActivity().getIntent();
    this.b.a(paramViewGroup);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WinkCircleAlbumListLogic localWinkCircleAlbumListLogic = this.b;
    if (localWinkCircleAlbumListLogic != null) {
      localWinkCircleAlbumListLogic.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCircleAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */