package dov.com.qq.im.ae.biz.qcircle;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import dov.com.qq.im.ae.biz.qcircle.adapter.PhotoGridAdapter;
import java.util.List;

public class AECircleSinglePhotoListFragment
  extends ReportFragment
{
  private int jdField_a_of_type_Int;
  public RecyclerView a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private AECirclePhotoListLogic jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic;
  public PhotoGridAdapter a;
  
  public AECircleSinglePhotoListFragment()
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter = null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367092));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373021));
    ((DefaultItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter = new PhotoGridAdapter(getActivity(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter);
  }
  
  public AECircleSinglePhotoListFragment a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public AECircleSinglePhotoListFragment a(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(List<LocalMediaInfo> paramList)
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter != null)
    {
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic != null) {
        this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a());
      }
      this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter.a(paramList);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter.a();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.inflate(2131558510, paramViewGroup, false));
    c();
    paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleSinglePhotoListFragment
 * JD-Core Version:    0.7.0.1
 */