package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.List;

public class CoverSelectTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final String[] b = { ReadInJoyUtils.b(2131915306), ReadInJoyUtils.b(2131915305) };
  protected Activity a;
  private ImmersiveTitleBar2 c;
  private ViewPagerCompat d;
  private TabLayoutCompat e;
  private View f;
  private View g;
  private boolean h = false;
  private int i;
  private VideoCaptureFragment j;
  private GalleryFragment k;
  private List<BaseFragment> l = new ArrayList();
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat, String paramString, UgcVideo paramUgcVideo)
  {
    a(paramActivity, paramInt1, paramInt2, paramFloat, paramString, paramUgcVideo.filePath, paramUgcVideo.width, paramUgcVideo.height);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_SELECTED_ITEM", paramInt2);
    localIntent.putExtra("ARG_VIDEO_URL", paramString2);
    localIntent.putExtra("ARG_INITIAL_PROGRESS", paramFloat);
    localIntent.putExtra("ARG_VIDEO_WIDTH", paramInt3);
    localIntent.putExtra("ARG_VIDEO_HEIGHT", paramInt4);
    localIntent.putExtra("ARG_PLACEHOLDER_URL", paramString1);
    PublicFragmentActivity.a(paramActivity, localIntent, CoverSelectTabFragment.class, paramInt1);
  }
  
  private void a(OutputPicListener paramOutputPicListener)
  {
    if (this.h) {
      return;
    }
    this.h = true;
    if (this.d.getCurrentItem() == 0)
    {
      this.j.a(paramOutputPicListener);
      return;
    }
    this.k.a(paramOutputPicListener);
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_SELECTED_COVER", paramString);
    localIntent.putExtra("ARG_SELECTED_ITEM", paramInt);
    if (paramInt == 0) {
      localIntent.putExtra("ARG_INITIAL_PROGRESS", this.j.d());
    } else if (paramInt == 1) {
      localIntent.putExtra("ARG_PLACEHOLDER_URL", paramString);
    }
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
  
  private void b()
  {
    Object localObject = getArguments();
    if (localObject == null) {
      return;
    }
    String str = ((Bundle)localObject).getString("ARG_VIDEO_URL");
    float f1 = ((Bundle)localObject).getFloat("ARG_INITIAL_PROGRESS");
    this.i = ((Bundle)localObject).getInt("ARG_SELECTED_ITEM");
    int m = ((Bundle)localObject).getInt("ARG_VIDEO_WIDTH");
    int n = ((Bundle)localObject).getInt("ARG_VIDEO_HEIGHT");
    localObject = ((Bundle)localObject).getString("ARG_PLACEHOLDER_URL");
    this.j = VideoCaptureFragment.a(str, f1);
    this.k = GalleryFragment.a(m, n, (String)localObject);
    this.l.add(this.j);
    this.l.add(this.k);
    this.j.a(new CoverSelectTabFragment.2(this));
  }
  
  private void c()
  {
    this.e.a(new CoverSelectTabFragment.3(this));
    this.e.setTabMode(1);
    this.e.setTabGravity(1);
    this.e.setSelectedTabIndicatorHeight(DisplayUtil.a(this.a, 3.0F));
    this.e.setSelectedTabIndicatorColor(-1);
    this.e.setSelectedTabIndicatorPaddingLeft(DisplayUtil.a(this.a, 32.0F));
    this.e.setSelectedTabIndicatorPaddingRight(DisplayUtil.a(this.a, 32.0F));
    this.e.setSelectedTabIndicatorPaddingBottom(DisplayUtil.a(this.a, 6.0F));
    this.e.setTabTextColors(this.a.getResources().getColor(2131165879), -1);
    this.e.setTabTextSize(DisplayUtil.c(this.a, 16.0F));
    this.e.setupWithViewPager(this.d, false);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == this.f.getId())
    {
      a(new CoverSelectTabFragment.4(this));
      return;
    }
    if (m == this.g.getId()) {
      this.a.finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return View.inflate(getBaseActivity(), 2131626020, null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.c = ((ImmersiveTitleBar2)paramView.findViewById(2131447582));
    this.d = ((ViewPagerCompat)paramView.findViewById(2131431482));
    this.e = ((TabLayoutCompat)paramView.findViewById(2131431480));
    this.f = paramView.findViewById(2131431481);
    this.g = paramView.findViewById(2131431479);
    this.c.resetBkColor(0);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    b();
    c();
    this.d.setScrollable(false);
    this.d.setAdapter(new CoverSelectTabFragment.1(this, getBaseActivity().getSupportFragmentManager()));
    if (this.i == 1)
    {
      this.d.setCurrentItem(1);
      return;
    }
    this.d.setCurrentItem(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.CoverSelectTabFragment
 * JD-Core Version:    0.7.0.1
 */