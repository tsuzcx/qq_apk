package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;

public class SDKSetEmotionPreviewFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private int a;
  private int b;
  private GridView c;
  private SDKSetEmotionPreviewFragment.PreviewGridAdapter d;
  private ArrayList<String> e;
  
  private void a()
  {
    this.d = new SDKSetEmotionPreviewFragment.PreviewGridAdapter(this);
    this.c.setAdapter(this.d);
    this.d.a(this.e);
  }
  
  private void a(View paramView)
  {
    Object localObject = getResources();
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int j = AIOUtils.b(0.0F, (Resources)localObject);
    int k = AIOUtils.b(4.0F, (Resources)localObject);
    int m = AIOUtils.b(4.0F, (Resources)localObject);
    this.a = ((i - j * 2 - k * 3) / 4);
    this.b = this.a;
    localObject = ((Resources)localObject).getString(2131888282);
    setTitle((CharSequence)localObject, (String)localObject);
    this.c = ((GridView)paramView.findViewById(2131432433));
    this.c.setScrollBarStyle(0);
    this.c.setNumColumns(4);
    this.c.setColumnWidth(this.a);
    this.c.setHorizontalSpacing(k);
    this.c.setVerticalSpacing(m);
    paramView = this.c;
    paramView.setPadding(j, paramView.getPaddingTop(), j, this.c.getPaddingBottom());
    this.c.setOnItemClickListener(this);
    this.c.setMaximumVelocity((int)(getResources().getDisplayMetrics().density * 2500.0F));
  }
  
  public static void a(String paramString, Context paramContext, View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startToAioImagePreviewWithPath: path=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SDKSetEmotionPreviewFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (localQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new AIOImageData();
        ((AIOImageData)localObject).a = paramString;
        ((AIOImageData)localObject).b = paramString;
        ((AIOImageData)localObject).c = paramString;
        ((AIOImageData)localObject).j = false;
        paramString = new Bundle();
        if (paramView != null) {
          paramString.putParcelable("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
        }
        PeakUtils.a(paramContext, paramString, new AIOImageProviderService(localQQAppInterface.getCurrentUin(), null, 0, null), (AIORichMediaData)localObject, -1, 4);
      }
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(this.mContentView);
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131624750;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getBaseActivity().getIntent();
    if (paramBundle != null) {
      this.e = paramBundle.getStringArrayListExtra("path_list");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).setStatusBar(getBaseActivity());
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setContentDescription(getString(2131887440));
      this.leftView.setBackgroundResource(2130851519);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    if (this.vg != null) {
      this.vg.setBackgroundColor(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment
 * JD-Core Version:    0.7.0.1
 */