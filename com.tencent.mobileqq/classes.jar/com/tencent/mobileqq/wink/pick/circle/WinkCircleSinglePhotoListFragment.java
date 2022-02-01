package com.tencent.mobileqq.wink.pick.circle;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class WinkCircleSinglePhotoListFragment
  extends ReportAndroidXFragment
{
  public RecyclerView a;
  public PhotoGridAdapter b = null;
  private FrameLayout c;
  private WinkCirclePhotoListLogic d;
  private int e;
  private boolean f = false;
  private int g = 0;
  
  private void e()
  {
    this.c = ((FrameLayout)this.c.findViewById(2131433282));
    this.a = ((RecyclerView)this.c.findViewById(2131440146));
    ((DefaultItemAnimator)this.a.getItemAnimator()).setSupportsChangeAnimations(false);
    this.a.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    this.b = new PhotoGridAdapter(getActivity(), this.a, this.d);
    this.b.a(this.e);
    this.a.setAdapter(this.b);
    this.a.addOnScrollListener(new WinkCircleSinglePhotoListFragment.1(this));
  }
  
  public WinkCircleSinglePhotoListFragment a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public WinkCircleSinglePhotoListFragment a(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    this.d = paramWinkCirclePhotoListLogic;
    return this;
  }
  
  public void a()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((WinkCirclePhotoListLogic)localObject).c != null) && (this.d.c.get() != null))
    {
      localObject = (WinkCirclePhotoListFragment)this.d.c.get();
      String str = (String)WinkDatongCurrentParams.params.get("xsj_camera_clck_ref_pgid");
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put("xsj_camera_clck_ref_pgid", str);
      }
      localHashMap.put("xsj_eid", "em_xsj_content");
      ((WinkCirclePhotoListFragment)localObject).b(null, "ev_xsj_camera_action", localHashMap);
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null)
    {
      WinkCirclePhotoListLogic localWinkCirclePhotoListLogic = this.d;
      if (localWinkCirclePhotoListLogic != null) {
        localPhotoGridAdapter.a(localWinkCirclePhotoListLogic.d());
      }
      this.b.a(paramList);
    }
  }
  
  public void b()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.h();
    }
  }
  
  public void b(int paramInt)
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.c(paramInt);
    }
  }
  
  public void c()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.b();
    }
  }
  
  public void d()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.c();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = ((FrameLayout)paramLayoutInflater.inflate(2131629694, paramViewGroup, false));
    e();
    paramLayoutInflater = this.c;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCircleSinglePhotoListFragment
 * JD-Core Version:    0.7.0.1
 */