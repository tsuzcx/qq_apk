package com.tencent.mobileqq.wink.pick.circle.part;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.wink.pick.album.data.AlbumSelectionData;
import com.tencent.mobileqq.wink.pick.circle.WinkCircleAlbumListFragment;
import com.tencent.mobileqq.wink.pick.circle.WinkCircleAlbumListFragment.IAlbumListBack;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleTitleAlbumMenuChangeEvent;
import com.tencent.mobileqq.wink.pick.circle.part.base.WinkCircleBasePart;
import com.tencent.mobileqq.wink.pick.util.WinkFastClickThrottle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class WinkCircleAlbumListPart
  extends WinkCircleBasePart
  implements View.OnClickListener, WinkCircleAlbumListFragment.IAlbumListBack
{
  public static String b = "";
  public WinkCircleAlbumListFragment a;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> c;
  private FrameLayout f;
  private TextView g;
  private ImageView h;
  private RelativeLayout i;
  private int j;
  private int k;
  
  public WinkCircleAlbumListPart(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    super(paramWinkCirclePhotoListLogic);
    this.d.a(this);
  }
  
  private void d(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = j().getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4097);
    if ((paramBoolean) && (!this.a.isAdded())) {
      localFragmentTransaction.add(2131428189, this.a, null);
    } else {
      localFragmentTransaction.remove(this.a);
    }
    localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.commit();
    SimpleEventBus.getInstance().dispatchEvent(new WinkCircleTitleAlbumMenuChangeEvent(paramBoolean));
  }
  
  private void e()
  {
    if (this.a == null)
    {
      this.a = new WinkCircleAlbumListFragment();
      this.a.a(this);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    ObjectAnimator localObjectAnimator;
    if ((paramBoolean) && (!this.a.isAdded())) {
      localObjectAnimator = ObjectAnimator.ofInt(this.f, "backgroundColor", new int[] { this.k, this.j });
    } else {
      localObjectAnimator = ObjectAnimator.ofInt(this.f, "backgroundColor", new int[] { this.j, this.k });
    }
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.start();
  }
  
  public String a()
  {
    return "WinkCircleAlbumListPart";
  }
  
  public void a(View paramView)
  {
    this.f = ((FrameLayout)paramView.findViewById(2131428189));
    this.g = ((TextView)paramView.findViewById(2131436227));
    b = g().getResources().getString(2131918039);
    a(b);
    this.h = ((ImageView)paramView.findViewById(2131436224));
    this.i = ((RelativeLayout)paramView.findViewById(2131436174));
    this.i.setOnClickListener(this);
    this.j = g().getResources().getColor(2131165806);
    this.k = g().getResources().getColor(2131165795);
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAlbumListChoose--albumId=");
      localStringBuilder.append(paramQQAlbumInfo.id);
      AEQLog.b("WinkCircleAlbumListPart", localStringBuilder.toString());
      this.d.d.albumName = paramQQAlbumInfo.name;
      this.d.d.albumId = paramQQAlbumInfo.id;
      if (this.d.d.albumName != null) {
        paramQQAlbumInfo = this.d.d.albumName;
      } else {
        paramQQAlbumInfo = b;
      }
      a(paramQQAlbumInfo);
      this.e.y = true;
      c().runOnUiThread(new WinkCircleAlbumListPart.1(this));
    }
    b(false);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    c().setTitle(paramCharSequence);
    this.g.setText(paramCharSequence);
    AlbumSelectionData.a().a(paramCharSequence.toString());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = new WinkCircleAlbumListPart.QueryPhotoTask(this, paramBoolean1, paramBoolean2);
    this.c.execute(new Object[0]);
  }
  
  public void b()
  {
    b(false);
  }
  
  public void b(boolean paramBoolean)
  {
    e();
    d(paramBoolean);
    e(paramBoolean);
    c(paramBoolean ^ true);
    this.d.b(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 180.0F;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramBoolean) {
      f2 = 360.0F;
    } else {
      f2 = 180.0F;
    }
    RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(300L);
    localRotateAnimation.setFillAfter(true);
    this.h.startAnimation(localRotateAnimation);
  }
  
  public Boolean d()
  {
    WinkCircleAlbumListFragment localWinkCircleAlbumListFragment = this.a;
    boolean bool;
    if ((localWinkCircleAlbumListFragment != null) && (localWinkCircleAlbumListFragment.isAdded())) {
      bool = false;
    } else {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.c;
    if (paramActivity != null) {
      paramActivity.cancel(true);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.c = null;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.e.G)
    {
      if (this.c == null) {
        a(true, true);
      }
    }
    else {
      this.e.G = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.d != null) && (paramView.getId() == 2131436174) && (!WinkFastClickThrottle.a(paramView)))
    {
      WinkCircleAlbumListFragment localWinkCircleAlbumListFragment = this.a;
      boolean bool;
      if ((localWinkCircleAlbumListFragment != null) && (localWinkCircleAlbumListFragment.isAdded())) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool) {
        this.d.b(c().getIntent());
      }
      b(bool);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCircleAlbumListPart
 * JD-Core Version:    0.7.0.1
 */