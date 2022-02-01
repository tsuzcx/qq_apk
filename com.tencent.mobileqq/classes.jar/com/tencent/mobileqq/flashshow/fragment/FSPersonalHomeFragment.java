package com.tencent.mobileqq.flashshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.events.FSFeedLikeStateUpdateEvent;
import com.tencent.mobileqq.flashshow.part.FSBaseBlockPart;
import com.tencent.mobileqq.flashshow.part.FSPersonTitlePart;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalBottomBlock;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalInfoBlock;
import com.tencent.mobileqq.flashshow.personal.viewmodel.FSPersonalViewModel;
import com.tencent.mobileqq.flashshow.personal.widget.FSRefreshHeaderView;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSCompatUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

public class FSPersonalHomeFragment
  extends FSBaseFragment
{
  private boolean b = false;
  private String c = "";
  private FSBaseBlockPart d;
  private FSPersonalInfoBlock e;
  private FSPersonalBottomBlock f;
  private FSPersonalViewModel g;
  private int h;
  private int i;
  private FSPersonTitlePart j;
  
  private void a(int paramInt)
  {
    this.h += paramInt;
    float f1 = this.h * 1.0F / this.i;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("computeShowTitleBarAnimation  dy:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("  mDistance:");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("  percent:");
    ((StringBuilder)localObject).append(f1);
    QLog.d("FSPersonalHomeFragment", 1, ((StringBuilder)localObject).toString());
    int k = (int)(f1 * 255.0F);
    if (k > 255)
    {
      paramInt = 255;
    }
    else
    {
      paramInt = k;
      if (k < 0) {
        paramInt = 0;
      }
    }
    localObject = Message.obtain();
    ((Message)localObject).what = paramInt;
    this.j.a("personal_page_action_title_bar_animation", localObject);
  }
  
  private void a(Bundle paramBundle)
  {
    this.e = new FSPersonalInfoBlock(paramBundle, this.g.g());
    this.e.setOnLoadDataDelegate(new FSPersonalHomeFragment.4(this));
  }
  
  private void a(BlockContainer paramBlockContainer)
  {
    paramBlockContainer.getRecyclerView().addOnScrollListener(new FSPersonalHomeFragment.5(this, paramBlockContainer));
  }
  
  private void a(FSFeedLikeStateUpdateEvent paramFSFeedLikeStateUpdateEvent)
  {
    if (!this.b) {
      return;
    }
    String str = paramFSFeedLikeStateUpdateEvent.getFeedId();
    int k = paramFSFeedLikeStateUpdateEvent.getLikeState();
    this.g.a(str, k);
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.g = ((FSPersonalViewModel)a(FSPersonalViewModel.class));
    this.g.a(paramStUser);
    this.g.d().observe(this, new FSPersonalHomeFragment.1(this));
    this.g.b().observe(this, new FSPersonalHomeFragment.2(this));
    this.g.e().observe(this, new FSPersonalHomeFragment.3(this));
    this.g.a(true);
  }
  
  private void b(Bundle paramBundle)
  {
    this.f = new FSPersonalBottomBlock(paramBundle);
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    this.j = new FSPersonTitlePart(paramStUser);
  }
  
  private void h()
  {
    if (getActivity() != null)
    {
      if (getActivity().getIntent() == null) {
        return;
      }
      Object localObject = getActivity().getIntent();
      if ((localObject != null) && (((Intent)localObject).hasExtra("fs_key_bundle_common_init_bean")))
      {
        localObject = ((Intent)localObject).getSerializableExtra("fs_key_bundle_common_init_bean");
        if (!(localObject instanceof FSPersonalDetailBean))
        {
          QLog.i("FSPersonalHomeFragment", 1, "InitBean is not FSPersonalDetailBean");
          return;
        }
        localObject = (FSPersonalDetailBean)localObject;
        FeedCloudMeta.StUser localStUser = ((FSPersonalDetailBean)localObject).getUser();
        this.c = ((FSPersonalDetailBean)localObject).getUin();
        this.b = FSCommonUtil.a(this.c);
        b(localStUser);
        a(localStUser);
        return;
      }
      QLog.i("FSPersonalHomeFragment", 1, "InitBean is null");
    }
  }
  
  private List<MultiViewBlock> i()
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    localBundle.putString("fs_key_bundle_personal_user_uin", this.c);
    a(localBundle);
    b(localBundle);
    localArrayList.add(this.e);
    localArrayList.add(this.f);
    return localArrayList;
  }
  
  private void k()
  {
    this.i = ViewUtils.dip2px(200.0F);
    BlockContainer localBlockContainer = this.d.i();
    localBlockContainer.setEnableLoadMore(false);
    localBlockContainer.setParentFragment(this);
    localBlockContainer.getRecyclerView().setTransDispatchDelegate(FSCompatUtil.a());
    localBlockContainer.setRefreshHeader(new FSRefreshHeaderView(getContext()));
    localBlockContainer.setEnableRefresh(true);
    a(localBlockContainer);
  }
  
  private void l()
  {
    this.h = 0;
    a(0);
  }
  
  private void m()
  {
    FSPersonalViewModel localFSPersonalViewModel = this.g;
    if ((localFSPersonalViewModel != null) && (!TextUtils.isEmpty(localFSPersonalViewModel.h())))
    {
      FSLpReportDc11001.a(new DataBuilder(f()).setActionType(11).setSubActionType(1).setThrActionType(0).setToUin(this.g.h()));
      return;
    }
    QLog.i("FSPersonalHomeFragment", 1, "mViewModel did not set StUser");
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    k();
  }
  
  public String b()
  {
    return "FSPersonalHomeFragment";
  }
  
  protected int c()
  {
    return 2131624838;
  }
  
  protected List<Part> d()
  {
    h();
    ArrayList localArrayList = new ArrayList();
    this.d = new FSBaseBlockPart(2131433865, i(), 3, 1);
    localArrayList.add(this.d);
    localArrayList.add(this.j);
    return localArrayList;
  }
  
  public String e()
  {
    return "pg_ks_profile";
  }
  
  public FSBaseBlockPart g()
  {
    return this.d;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(FSFeedLikeStateUpdateEvent.class);
    return localArrayList;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d("FSPersonalHomeFragment", 1, "fs_lifecycle onPause");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof FSFeedLikeStateUpdateEvent)) {
      a((FSFeedLikeStateUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("FSPersonalHomeFragment", 1, "fs_lifecycle onResume");
    m();
    if (this.b)
    {
      FSPersonalViewModel localFSPersonalViewModel = this.g;
      if (localFSPersonalViewModel != null) {
        localFSPersonalViewModel.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalHomeFragment
 * JD-Core Version:    0.7.0.1
 */