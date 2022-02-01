package dov.com.qq.im.ae.biz.qcircle;

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
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;
import dov.com.qq.im.ae.biz.qcircle.adapter.AlbumListAdapter;

public class AECircleAlbumListFragment
  extends ReportFragment
{
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  AlbumListBaseData jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData;
  XFrameLayout jdField_a_of_type_ComTencentWidgetXFrameLayout;
  public XListView a;
  public AECircleAlbumListFragment.IAlbumListBack a;
  public AECircleAlbumListLogic a;
  public AlbumListAdapter a;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout = ((XFrameLayout)paramView.findViewById(2131370481));
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout.setCornerRadiusAndMode(Utils.dp2px(10.0D), 5);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131362617));
    this.jdField_a_of_type_ComTencentWidgetXListView.setWrapByScroll(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new AECircleAlbumListFragment.AlbumListItemClickListener(this, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362648));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AECircleAlbumListFragment.1(this));
    paramView.findViewById(2131362647).setVisibility(8);
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new AECircleAlbumListFragment.2(this, i, j));
  }
  
  protected AECircleAlbumListLogic a()
  {
    return new AECircleAlbumListLogic(this);
  }
  
  public void a(AECircleAlbumListFragment.IAlbumListBack paramIAlbumListBack)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment$IAlbumListBack = paramIAlbumListBack;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561094, paramViewGroup, false);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListLogic = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData = this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListLogic.a;
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListLogic.a(paramViewGroup);
    a(paramLayoutInflater);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListLogic != null) {
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListLogic.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */