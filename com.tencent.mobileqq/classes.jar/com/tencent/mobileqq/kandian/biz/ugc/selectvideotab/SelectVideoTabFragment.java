package com.tencent.mobileqq.kandian.biz.ugc.selectvideotab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoFragment;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;

public class SelectVideoTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static String a = "KEY_BUNDLE";
  private static final int[] b = { 2131915417, 2131915433 };
  private ImmersiveTitleBar2 c;
  private ViewPagerCompat d;
  private TabLayoutCompat e;
  private ArrayList<QBaseFragment> f = new ArrayList();
  private ImageView g;
  private QBaseFragment h;
  private ViolaFragment i;
  private Activity j;
  private int k = 0;
  private String l = "";
  private ReadInJoyObserver m = new SelectVideoTabFragment.1(this);
  
  private void a()
  {
    if ((VersionUtils.k()) && (!SystemUtil.d()) && (!SystemUtil.g()))
    {
      getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.c.setBackgroundColor(-1);
    }
  }
  
  private void b()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      ColumnInfo localColumnInfo = (ColumnInfo)localBundle.getParcelable("key_column_info");
      int n;
      if (localColumnInfo != null) {
        n = localColumnInfo.columnID;
      } else {
        n = 0;
      }
      this.k = n;
      this.l = localBundle.getString("arg_callback");
    }
  }
  
  private void c()
  {
    this.h = SelectVideoFragment.a(false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(RIJUgcUtils.t());
    localStringBuilder.append(this.k);
    this.i = ViolaFragment.newInstance(localStringBuilder.toString(), null, true);
    this.f.add(this.h);
    this.f.add(this.i);
  }
  
  private void d()
  {
    this.e.a(new SelectVideoTabFragment.2(this));
    this.e.setTabMode(1);
    this.e.setTabGravity(1);
    this.e.setSelectedTabIndicatorHeight(DisplayUtil.a(getBaseActivity(), 2.0F));
    this.e.setSelectedTabIndicatorColor(Color.parseColor("#262626"));
    this.e.setSelectedTabIndicatorPaddingLeft(DisplayUtil.a(getBaseActivity(), 32.0F));
    this.e.setSelectedTabIndicatorPaddingRight(DisplayUtil.a(getBaseActivity(), 32.0F));
    this.e.setSelectedTabIndicatorPaddingBottom(DisplayUtil.a(getBaseActivity(), 0.0F));
    this.e.setTabTextColors(Color.parseColor("#737373"), Color.parseColor("#262626"));
    this.e.setTabTextSize(DisplayUtil.c(getBaseActivity(), 16.0F));
    this.e.setupWithViewPager(this.d, false);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && (paramInt2 == -1)) {
      this.j.finish();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.j = paramActivity;
    ReadInJoyLogicEngineEventDispatcher.a().a(this.m);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430821) {
      getBaseActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    RIJDtReportHelper.a.a(getBaseActivity());
    return View.inflate(this.j, 2131626326, null);
  }
  
  public void onDetach()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.m);
    super.onDetach();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.c = ((ImmersiveTitleBar2)paramView.findViewById(2131447582));
    this.g = ((ImageView)paramView.findViewById(2131430821));
    this.g.setOnClickListener(this);
    this.d = ((ViewPagerCompat)paramView.findViewById(2131445543));
    this.e = ((TabLayoutCompat)paramView.findViewById(2131445539));
    b();
    c();
    d();
    this.d.setScrollable(false);
    getBaseActivity().getSupportFragmentManager();
    this.d.setCurrentItem(0);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideotab.SelectVideoTabFragment
 * JD-Core Version:    0.7.0.1
 */