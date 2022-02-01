package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import java.util.ArrayList;
import java.util.List;

public class NearbyProfileCardMomentAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private NearbyCardMomentItemFactory a;
  private NearbyPeopleCard b;
  private final Context c;
  private final List<MomentFeedInfo> d = new ArrayList();
  
  public NearbyProfileCardMomentAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.c = paramContext;
    if (paramQQAppInterface != null) {
      this.a = new NearbyCardMomentItemFactory(paramQQAppInterface, paramContext);
    }
  }
  
  public List<MomentFeedInfo> a()
  {
    return this.d;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.b = paramNearbyPeopleCard;
  }
  
  public void a(List<MomentFeedInfo> paramList)
  {
    this.d.clear();
    if (paramList != null) {
      this.d.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    NearbyCardMomentItemFactory localNearbyCardMomentItemFactory = this.a;
    if (localNearbyCardMomentItemFactory == null) {
      return -1;
    }
    return localNearbyCardMomentItemFactory.a((MomentFeedInfo)this.d.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a == null) {
      return null;
    }
    MomentFeedInfo localMomentFeedInfo = (MomentFeedInfo)this.d.get(paramInt);
    int i = this.a.a(localMomentFeedInfo);
    BaseMomentItemBuilder localBaseMomentItemBuilder = this.a.a(i);
    paramViewGroup = paramView;
    if (localBaseMomentItemBuilder != null)
    {
      localBaseMomentItemBuilder.a(this.b);
      localBaseMomentItemBuilder.a(paramInt);
      paramViewGroup = localBaseMomentItemBuilder.a(localMomentFeedInfo, this.c, paramView);
    }
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    NearbyCardMomentItemFactory localNearbyCardMomentItemFactory = this.a;
    if (localNearbyCardMomentItemFactory == null) {
      return 1;
    }
    return localNearbyCardMomentItemFactory.a();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.equals(paramString, this.b.uin)) {
      return;
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyProfileCardMomentAdapter
 * JD-Core Version:    0.7.0.1
 */