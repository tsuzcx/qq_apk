package com.tencent.mobileqq.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListFragment
  extends IphoneTitleBarFragment
  implements DecodeTaskCompletionListener
{
  FriendListObserver a = new ShieldFriendsListFragment.2(this);
  private TextView b;
  private XListView c;
  private IFaceDecoder d;
  private ShieldFriendsListFragment.ShieldFriendsAdapter e;
  
  private void a()
  {
    ThreadManager.excute(new ShieldFriendsListFragment.1(this), 16, null, true);
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    int j = this.c.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.c.getChildAt(i);
      if (localObject != null)
      {
        localObject = (ShieldFriendsListFragment.Holder)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((ShieldFriendsListFragment.Holder)localObject).d).longValue()))
        {
          if (((ShieldFriendsListFragment.Holder)localObject).c.isChecked() != paramBoolean)
          {
            ((ShieldFriendsListFragment.Holder)localObject).c.setOnCheckedChangeListener(null);
            ((ShieldFriendsListFragment.Holder)localObject).c.setChecked(paramBoolean);
            ((ShieldFriendsListFragment.Holder)localObject).c.setOnCheckedChangeListener(((ShieldFriendsListFragment.Holder)localObject).e);
          }
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b()
  {
    if (this.e.getCount() <= 0)
    {
      this.c.setVisibility(8);
      this.b.setVisibility(0);
      return;
    }
    this.c.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    super.setTitle(getResources().getString(2131897288));
    this.mContentView.setBackgroundResource(2130838958);
    this.c = ((XListView)this.mContentView.findViewById(2131437317));
    this.b = ((TextView)this.mContentView.findViewById(2131433225));
    this.b.setText(2131897289);
    this.b.setBackgroundDrawable(null);
    this.b.setTextSize(2, 17.0F);
    this.b.setTextColor(getResources().getColor(2131168122));
    paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
    paramLayoutInflater.addRule(13);
    this.b.setLayoutParams(paramLayoutInflater);
    this.d = ((IQQAvatarService)getBaseActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getBaseActivity().app);
    this.d.setDecodeTaskCompletionListener(this);
    this.e = new ShieldFriendsListFragment.ShieldFriendsAdapter(getBaseActivity(), this.d, getBaseActivity().app);
    this.c.setAdapter(this.e);
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    paramLayoutInflater.topMargin = ((int)DisplayUtils.a(getBaseActivity(), 12.0F));
    this.c.setLayoutParams(paramLayoutInflater);
    a();
    getBaseActivity().addObserver(this.a);
    if (AppSetting.e) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131901576));
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627851;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",avatar= ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("ShieldFriendsListActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap == null) {
      return;
    }
    paramInt2 = this.c.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localObject = this.c.getChildAt(paramInt1);
      if (localObject != null)
      {
        localObject = (ShieldFriendsListFragment.Holder)((View)localObject).getTag();
        if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((ShieldFriendsListFragment.Holder)localObject).d)))
        {
          ((ShieldFriendsListFragment.Holder)localObject).a.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
          return;
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IFaceDecoder localIFaceDecoder = this.d;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    getBaseActivity().app.removeObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment
 * JD-Core Version:    0.7.0.1
 */