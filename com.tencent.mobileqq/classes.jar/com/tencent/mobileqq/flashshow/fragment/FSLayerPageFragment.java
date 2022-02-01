package com.tencent.mobileqq.flashshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.data.FSRecentlyFeedStateData;
import com.tencent.mobileqq.flashshow.part.FSCommentPanelPart;
import com.tencent.mobileqq.flashshow.part.FSDebugPart;
import com.tencent.mobileqq.flashshow.part.FSLayerBasePart;
import com.tencent.mobileqq.flashshow.part.FSLayerPageBottomPart;
import com.tencent.mobileqq.flashshow.part.FSLayerPageDetailPart;
import com.tencent.mobileqq.flashshow.part.FSLayerPageListPart;
import com.tencent.mobileqq.flashshow.part.FSLayerPageTitleViewPart;
import com.tencent.mobileqq.flashshow.part.FSRichMediaDownLoadPart;
import com.tencent.mobileqq.flashshow.part.FSSharePart;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

public class FSLayerPageFragment
  extends FSBaseFragment
{
  private FSLayerPageInitBean b;
  private FSLayerBasePart c;
  private FSLayerPageBottomPart d;
  private FSLayerPageTitleViewPart e;
  private FSCommentPanelPart f;
  private FSSharePart g;
  
  private void a(int paramInt)
  {
    if (this.b == null)
    {
      QLog.e("FSLayerPageFragment", 1, "mInitBean is null");
      return;
    }
    MutableLiveData localMutableLiveData = FSDataCenter.a().b();
    if ((paramInt == 1) && (localMutableLiveData != null) && (localMutableLiveData.getValue() != null) && (TextUtils.equals(this.b.getUserId(), ((FSRecentlyFeedStateData)localMutableLiveData.getValue()).b.id.get()))) {
      return;
    }
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(this.b.getUserId());
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(this.b.getFeedId());
    localStFeed.createTime.set(this.b.getCreateTime());
    FSRecentlyFeedStateData localFSRecentlyFeedStateData = new FSRecentlyFeedStateData();
    localFSRecentlyFeedStateData.a = localStFeed;
    localFSRecentlyFeedStateData.b = localStUser;
    localMutableLiveData.postValue(localFSRecentlyFeedStateData);
  }
  
  private FSLayerBasePart g()
  {
    Object localObject2 = this.b;
    Object localObject1 = null;
    if (localObject2 == null)
    {
      QLog.e("FSLayerPageFragment", 1, "initLayerPagePart  mInitBean == null");
      return null;
    }
    a(((FSLayerPageInitBean)localObject2).getSourceType());
    int i = this.b.getSourceType();
    if (i != 1)
    {
      if ((i != 2) && (i != 1002)) {
        QLog.e("FSLayerPageFragment", 1, "initLayerPagePart  no sourceType , layerPart == null");
      } else {
        localObject1 = new FSLayerPageDetailPart(this.b);
      }
    }
    else {
      localObject1 = new FSLayerPageListPart(this.b);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initLayerPagePart  sourceType = ");
    ((StringBuilder)localObject2).append(this.b.getSourceType());
    QLog.i("FSLayerPageFragment", 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private void h()
  {
    if (getActivity() == null) {
      return;
    }
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("fs_key_bundle_common_init_bean"))) {
      this.b = ((FSLayerPageInitBean)localIntent.getSerializableExtra("fs_key_bundle_common_init_bean"));
    }
  }
  
  public String b()
  {
    return "FSLayerPageFragment";
  }
  
  protected int c()
  {
    return 2131624808;
  }
  
  protected List<Part> d()
  {
    h();
    ArrayList localArrayList = new ArrayList();
    this.c = g();
    FSLayerBasePart localFSLayerBasePart = this.c;
    if (localFSLayerBasePart != null) {
      localArrayList.add(localFSLayerBasePart);
    }
    this.e = new FSLayerPageTitleViewPart();
    localArrayList.add(this.e);
    this.d = new FSLayerPageBottomPart();
    localArrayList.add(this.d);
    this.f = new FSCommentPanelPart();
    localArrayList.add(this.f);
    this.g = new FSSharePart();
    localArrayList.add(this.g);
    if (!HostAppSettingUtil.isPublicVersion()) {
      localArrayList.add(new FSDebugPart());
    }
    localArrayList.add(new FSRichMediaDownLoadPart());
    return localArrayList;
  }
  
  public String e()
  {
    return "pg_ks_layer_page";
  }
  
  public int j()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSLayerPageFragment
 * JD-Core Version:    0.7.0.1
 */