package com.tencent.mobileqq.newfriend.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class NewFriendVerifyBlockedListFragment
  extends QIphoneTitleBarFragment
  implements DecodeTaskCompletionListener
{
  MqqHandler a = new NewFriendVerifyBlockedListFragment.1(this);
  private ListView b;
  private TextView c;
  private View d;
  private QBaseActivity e;
  private NewFriendVerifyBlockedListFragment.CommonAdapter f;
  private List<AddFriendBlockedInfo> g = new ArrayList();
  private IFaceDecoder w;
  private NewFriendVerificationObserver x = new NewFriendVerifyBlockedListFragment.2(this);
  private AbsListView.OnScrollListener y = new NewFriendVerifyBlockedListFragment.3(this);
  
  public static void a(Activity paramActivity)
  {
    QPublicFragmentActivity.start(paramActivity, new Intent(), NewFriendVerifyBlockedListFragment.class);
  }
  
  private void b()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(getString(2131897067));
    localSpannableStringBuilder.setSpan(new NewFriendVerifyBlockedListFragment.5(this), 27, 31, 33);
    this.c.setText(localSpannableStringBuilder);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#4D94FF")), 27, 31, 33);
    this.c.setMovementMethod(LinkMovementMethod.getInstance());
    this.c.setText(localSpannableStringBuilder);
  }
  
  private void c()
  {
    if (this.f != null)
    {
      this.g.clear();
      this.g.addAll(NewFriendVerificationServiceImpl.getService(this.e.getAppRuntime()).addFriendBlockedInfoList);
      this.f.notifyDataSetChanged();
      if (this.g.isEmpty())
      {
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        return;
      }
      this.c.setVisibility(0);
      this.d.setVisibility(8);
    }
  }
  
  protected int a()
  {
    return 2131627995;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a(this.e.getString(2131897069));
    this.d = this.t.findViewById(2131432530);
    this.b = ((ListView)this.t.findViewById(2131431147));
    this.b.setNeedCheckSpringback(true);
    this.b.setOverscrollHeader(null);
    this.b.setOnScrollListener(this.y);
    this.c = ((TextView)this.t.findViewById(2131437283));
    this.f = new NewFriendVerifyBlockedListFragment.CommonAdapter(this, null);
    this.b.setAdapter(this.f);
    b();
    c(2131887800, new NewFriendVerifyBlockedListFragment.4(this));
    ((INewFriendVerificationService)this.e.getAppRuntime().getRuntimeService(INewFriendVerificationService.class, "")).getAddFriendBlockedList(this.e.getAppRuntime().getCurrentAccountUin());
    c();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100)
    {
      this.a.removeMessages(1);
      this.a.sendEmptyMessage(1);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.e = getQBaseActivity();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.e.getAppRuntime() instanceof AppInterface))
    {
      ((AppInterface)this.e.getAppRuntime()).addObserver(this.x);
      this.w = ((IQQAvatarService)this.e.getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)this.e.getAppRuntime());
      this.w.setDecodeTaskCompletionListener(this);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramInt2 = this.b.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.b.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)))
        {
          localObject = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject;
          if ((((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).a != null) && (paramString.equals(((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).a.a))) {
            ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).c.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.e.getAppRuntime() instanceof AppInterface))
    {
      ((AppInterface)this.e.getAppRuntime()).removeObserver(this.x);
      this.w.setDecodeTaskCompletionListener(null);
      this.w.destory();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.e = null;
  }
  
  public void onResume()
  {
    super.onResume();
    NewFriendVerifyBlockedListFragment.CommonAdapter localCommonAdapter = this.f;
    if (localCommonAdapter != null) {
      localCommonAdapter.b();
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3A6", "0X800A3A6", 0, 0, "", "", "", "");
  }
  
  public void onStop()
  {
    super.onStop();
    NewFriendVerifyBlockedListFragment.CommonAdapter localCommonAdapter = this.f;
    if (localCommonAdapter != null) {
      localCommonAdapter.a();
    }
    NewFriendVerificationServiceImpl.getService(this.e.getAppRuntime()).setBlockInfoHasRead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment
 * JD-Core Version:    0.7.0.1
 */