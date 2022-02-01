package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ShieldFriendsListFragment$ShieldFriendsAdapter
  extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  private List<Friends> a;
  private Context b;
  private IFaceDecoder c;
  private QQAppInterface d;
  
  public ShieldFriendsListFragment$ShieldFriendsAdapter(Context paramContext, IFaceDecoder paramIFaceDecoder, QQAppInterface paramQQAppInterface)
  {
    this.b = paramContext;
    this.a = new ArrayList(0);
    this.c = paramIFaceDecoder;
    this.d = paramQQAppInterface;
  }
  
  public void a(Friends paramFriends)
  {
    if ((this.a == null) || (paramFriends == null)) {
      this.a = new ArrayList(1);
    }
    this.a.add(paramFriends);
    notifyDataSetChanged();
  }
  
  public void a(List<Friends> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.a = paramList;
      notifyDataSetChanged();
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Friends)((Iterator)localObject).next()).uin.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.a;
    if (localList == null) {
      return null;
    }
    return localList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.b).inflate(2131627824, paramViewGroup, false);
      paramView = new ShieldFriendsListFragment.Holder();
      paramView.a = ((URLImageView)localView.findViewById(2131445836));
      paramView.b = ((TextView)localView.findViewById(2131445837));
      paramView.c = ((Switch)localView.findViewById(2131445838));
      paramView.c.setTag(paramView);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (ShieldFriendsListFragment.Holder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (Friends)getItem(paramInt);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShieldFriendsListActivity", 2, "friend == null,这种情况不应该出现的");
      }
    }
    else
    {
      paramView.d = ((Friends)localObject).uin;
      paramView.c.setOnCheckedChangeListener(null);
      paramView.c.setChecked(((Friends)localObject).isShield());
      paramView.c.setOnCheckedChangeListener(this);
      paramView.e = this;
      Bitmap localBitmap = this.c.getBitmapFromCache(1, ((Friends)localObject).uin, 0);
      if (localBitmap == null)
      {
        if (!this.c.isPausing()) {
          this.c.requestDecodeFace(((Friends)localObject).uin, 1, true);
        }
        paramView.a.setBackgroundDrawable((BitmapDrawable)ImageUtil.m());
      }
      else
      {
        paramView.a.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      }
      localObject = ContactUtils.a(this.d, ((Friends)localObject).uin, 0);
      paramView.b.setText((CharSequence)localObject);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.d;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8009DD1", "0X8009DD1", 0, i, "0", "0", "", "");
    int i = HttpUtil.getNetWorkType();
    if (i == -1) {
      i = 2;
    }
    localObject = (ShieldFriendsListFragment.Holder)paramCompoundButton.getTag();
    if (i == 0)
    {
      QQToast.makeText(this.b, 1, 2131893879, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
      paramCompoundButton.setOnCheckedChangeListener(null);
      paramCompoundButton.setChecked(paramBoolean ^ true);
      paramCompoundButton.setOnCheckedChangeListener(((ShieldFriendsListFragment.Holder)localObject).e);
    }
    else
    {
      ((FriendListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).changeFriendShieldFlag(Long.valueOf(((ShieldFriendsListFragment.Holder)localObject).d).longValue(), paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment.ShieldFriendsAdapter
 * JD-Core Version:    0.7.0.1
 */