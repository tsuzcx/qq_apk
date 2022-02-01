package com.tencent.mobileqq.multicard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class MultiCardRecommendFragment
  extends PublicBaseFragment
{
  DecodeTaskCompletionListener a = new MultiCardRecommendFragment.2(this);
  TroopMemberRecommendObserver b = new MultiCardRecommendFragment.3(this);
  TroopObserver c = new MultiCardRecommendFragment.4(this);
  MqqHandler d = new MultiCardRecommendFragment.5(this);
  private QQAppInterface e;
  private String f;
  private RecyclerView g;
  private RelativeLayout h;
  private FriendsManager i;
  private IFaceDecoder j;
  private TroopMemRecommendRclAdapter k;
  private String l;
  
  private Object a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    if (this.g != null)
    {
      Object localObject = this.k;
      if (localObject != null)
      {
        if (((TroopMemRecommendRclAdapter)localObject).a == null) {
          return null;
        }
        Object[] arrayOfObject = this.k.a.keySet().toArray();
        int m = 0;
        int n;
        for (int i1 = 0; m < this.k.a.size(); i1 = n)
        {
          if (this.g.getChildAt(m) == null) {
            return null;
          }
          n = i1;
          if (arrayOfObject[m] != null)
          {
            n = i1;
            if ((arrayOfObject[m] instanceof Integer)) {
              n = ((Integer)arrayOfObject[m]).intValue();
            }
          }
          List localList = (List)this.k.a.get(Integer.valueOf(n));
          localObject = this.g;
          RecyclerView.ViewHolder localViewHolder = ((RecyclerView)localObject).getChildViewHolder(((RecyclerView)localObject).getChildAt(m));
          if (localViewHolder != null)
          {
            i1 = 0;
            while (i1 < localList.size())
            {
              localObject = (RecommendPerson)localList.get(i1);
              if ((localObject != null) && (paramString.equals(((RecommendPerson)localObject).uin)))
              {
                localObject = (RecyclerView.ViewHolder)localViewHolder;
                if (paramBoolean)
                {
                  if ((localViewHolder instanceof TroopMemRecommendRclAdapter.ActiveViewHolder))
                  {
                    localObject = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localViewHolder).b.get(i1);
                    if ((paramBitmap != null) && (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).b != null))
                    {
                      ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).b.setImageBitmap(paramBitmap);
                      break label346;
                    }
                    return localObject;
                  }
                  if (!(localViewHolder instanceof TroopMemRecommendRclAdapter.CommonViewHolder)) {
                    break label346;
                  }
                  TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView localCommonSubItemView = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localViewHolder).b.get(i1);
                  localObject = localCommonSubItemView;
                  if (paramBitmap != null)
                  {
                    localObject = localCommonSubItemView;
                    if (localCommonSubItemView.b != null)
                    {
                      localCommonSubItemView.b.setImageBitmap(paramBitmap);
                      break label346;
                    }
                  }
                }
                return localObject;
              }
              label346:
              i1 += 1;
            }
          }
          m += 1;
        }
      }
    }
    return null;
  }
  
  private void a(View paramView)
  {
    this.g = ((RecyclerView)paramView.findViewById(2131445058));
    this.h = ((RelativeLayout)paramView.findViewById(2131445063));
    this.k = new TroopMemRecommendRclAdapter(this, this.e);
    paramView = new LinearLayoutManager(getBaseActivity());
    paramView.setOrientation(1);
    this.g.setLayoutManager(paramView);
    paramView = new MultiCardRecommendFragment.SpaceItemDecoration(this, null);
    this.g.addItemDecoration(paramView);
    this.g.setAdapter(this.k);
    this.g.addOnScrollListener(new MultiCardRecommendFragment.1(this));
    this.e.addObserver(this.b);
    this.e.addObserver(this.c);
    this.j = ((IQQAvatarService)this.e.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.e);
    this.j.setDecodeTaskCompletionListener(this.a);
    this.i = ((FriendsManager)this.e.getManager(QQManagerFactory.FRIENDS_MANAGER));
    paramView = (TroopMemberRecommendManager)this.e.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER);
    if (paramView != null) {
      paramView.a(this.f, 11, null);
    }
    paramView = (ITroopMemberListHandler)this.e.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("");
    paramView.a(false, localStringBuilder.toString(), "0", 9);
  }
  
  private void b()
  {
    IFaceDecoder localIFaceDecoder = this.j;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.resume();
    }
  }
  
  private void b(String paramString)
  {
    if (this.g != null)
    {
      Object localObject = this.k;
      if (localObject != null)
      {
        if (((TroopMemRecommendRclAdapter)localObject).a == null) {
          return;
        }
        localObject = new HashMap();
        ((Map)localObject).putAll(this.k.a);
        Object[] arrayOfObject = ((Map)localObject).keySet().toArray();
        int m = 0;
        int n;
        for (int i1 = 0; m < ((Map)localObject).size(); i1 = n)
        {
          n = i1;
          if (arrayOfObject[m] != null)
          {
            n = i1;
            if ((arrayOfObject[m] instanceof Integer)) {
              n = ((Integer)arrayOfObject[m]).intValue();
            }
          }
          List localList = (List)((Map)localObject).get(Integer.valueOf(n));
          i1 = 0;
          while (i1 < localList.size())
          {
            RecommendPerson localRecommendPerson = (RecommendPerson)localList.get(i1);
            if ((localRecommendPerson != null) && (paramString.equals(localRecommendPerson.uin))) {
              localList.remove(localRecommendPerson);
            }
            i1 += 1;
          }
          if (localList.size() == 0) {
            this.k.a.remove(Integer.valueOf(n));
          }
          m += 1;
        }
      }
    }
  }
  
  private void c()
  {
    IFaceDecoder localIFaceDecoder = this.j;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.cancelPendingRequests();
      this.j.pause();
    }
  }
  
  private boolean c(String paramString)
  {
    return this.i.v(paramString);
  }
  
  private void d()
  {
    if (this.g != null)
    {
      Object localObject1 = this.k;
      if (localObject1 != null)
      {
        if (((TroopMemRecommendRclAdapter)localObject1).a == null) {
          return;
        }
        localObject1 = this.k.a.keySet().toArray();
        int m = 0;
        int n;
        for (int i1 = 0; m < this.k.a.size(); i1 = n)
        {
          if (this.g.getChildAt(m) == null) {
            return;
          }
          n = i1;
          if (localObject1[m] != null)
          {
            n = i1;
            if ((localObject1[m] instanceof Integer)) {
              n = ((Integer)localObject1[m]).intValue();
            }
          }
          List localList = (List)this.k.a.get(Integer.valueOf(n));
          Object localObject2 = this.g;
          localObject2 = ((RecyclerView)localObject2).getChildViewHolder(((RecyclerView)localObject2).getChildAt(m));
          if (localObject2 != null)
          {
            i1 = 0;
            while (i1 < localList.size())
            {
              Object localObject3;
              Object localObject4;
              if ((localObject2 instanceof TroopMemRecommendRclAdapter.ActiveViewHolder))
              {
                localObject3 = (TroopMemRecommendRclAdapter.ActiveViewHolder)localObject2;
                if ((((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject3).b != null) && (i1 < ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject3).b.size()))
                {
                  localObject4 = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject3).b.get(i1);
                  if (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject4).b != null) {
                    ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject4).b.setImageBitmap(a(((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject3).a.get(i1)).uin));
                  }
                }
              }
              else if ((localObject2 instanceof TroopMemRecommendRclAdapter.CommonViewHolder))
              {
                localObject3 = (TroopMemRecommendRclAdapter.CommonViewHolder)localObject2;
                if ((((TroopMemRecommendRclAdapter.CommonViewHolder)localObject3).b != null) && (i1 < ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject3).b.size()))
                {
                  localObject4 = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject3).b.get(i1);
                  if (((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject4).b != null) {
                    ((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject4).b.setImageBitmap(a(((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject3).a.get(i1)).uin));
                  }
                }
              }
              i1 += 1;
            }
          }
          m += 1;
        }
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((TroopMemRecommendRclAdapter)localObject).a != null))
    {
      if (this.k.a.size() == 0)
      {
        this.g.setVisibility(8);
        this.h.setVisibility(0);
        return;
      }
      this.g.setVisibility(0);
      this.h.setVisibility(8);
      localObject = this.k.a;
      this.k = new TroopMemRecommendRclAdapter(this, this.e);
      TroopMemRecommendRclAdapter localTroopMemRecommendRclAdapter = this.k;
      localTroopMemRecommendRclAdapter.a = ((Map)localObject);
      this.g.setAdapter(localTroopMemRecommendRclAdapter);
      this.k.notifyDataSetChanged();
    }
  }
  
  private void f()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      if (((TroopMemRecommendRclAdapter)localObject).a == null) {
        return;
      }
      localObject = this.g.getLayoutManager();
      if ((localObject instanceof LinearLayoutManager))
      {
        localObject = (LinearLayoutManager)localObject;
        int n = ((LinearLayoutManager)localObject).findLastCompletelyVisibleItemPosition();
        int m = ((LinearLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
        localObject = this.k.a.keySet().toArray();
        while (m <= n)
        {
          if ((m >= 0) && (m < this.k.a.size()) && (localObject[m] != null) && ((localObject[m] instanceof Integer)))
          {
            int i1 = ((Integer)localObject[m]).intValue();
            List localList = (List)this.k.a.get(Integer.valueOf(i1));
            if ((localList != null) && (localList.size() > 0)) {
              TroopRecommendReport.a(this.e, ((RecommendPerson)localList.get(0)).cardTypeID, m, localList);
            }
          }
          m += 1;
        }
      }
    }
  }
  
  public int a(RecommendPerson paramRecommendPerson)
  {
    if (paramRecommendPerson.cardTypeID == 101) {
      return 18;
    }
    if (paramRecommendPerson.cardTypeID == 102) {
      return 19;
    }
    if (paramRecommendPerson.cardTypeID == 103) {
      return 20;
    }
    if (paramRecommendPerson.cardTypeID == 104) {
      return 21;
    }
    return 22;
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject = this.j.getBitmapFromCache(1, paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFaceBitmap（） uin =  ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" bitmap =");
      localStringBuilder.append(localObject);
      QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, localStringBuilder.toString());
    }
    if (localObject != null) {
      return localObject;
    }
    if (!this.j.isPausing())
    {
      this.j.requestDecodeFace(paramString, 1, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestDecodeFace（） uin =  ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    return ImageUtil.k();
  }
  
  public void a()
  {
    if ((!TextUtils.isEmpty(this.l)) && ((c(this.l)) || (this.i.n(this.l))))
    {
      Object localObject = a(this.l, true, null);
      if (localObject != null) {
        if ((localObject instanceof TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView))
        {
          localObject = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject;
          if ((localObject != null) && (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).e != null)) {
            ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).e.setText(2131916564);
          }
        }
        else if ((localObject instanceof TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView))
        {
          localObject = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject;
          if ((localObject != null) && (((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject).e != null)) {
            ((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject).e.setText(2131916564);
          }
        }
      }
      this.d.sendEmptyMessageDelayed(2, 1200L);
      localObject = (TroopMemberRecommendManager)this.e.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER);
      if (localObject != null) {
        ((TroopMemberRecommendManager)localObject).a(this.f, this.l);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    int m;
    if (paramViewHolder != null) {
      m = paramViewHolder.getAdapterPosition();
    } else {
      m = 0;
    }
    paramViewHolder = new AllInOne(paramRecommendPerson.uin, 113);
    paramViewHolder.extras.putSerializable("key_troop_recommend_person", paramRecommendPerson);
    paramViewHolder.extras.putInt("key_troop_recommend_position", m);
    paramViewHolder.subSourceId = a(paramRecommendPerson);
    paramViewHolder.profileEntryType = 122;
    ProfileUtils.openProfileCardForResult(getActivity(), paramViewHolder, 110);
    TroopRecommendReport.a(this.e, m, paramRecommendPerson);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.e = paramQQAppInterface;
    this.f = paramString;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    int m;
    if (paramViewHolder != null) {
      m = paramViewHolder.getAdapterPosition();
    } else {
      m = 0;
    }
    this.l = paramRecommendPerson.uin;
    int n = a(paramRecommendPerson);
    paramViewHolder = ContactUtils.b(this.e, this.f, paramRecommendPerson.uin);
    paramViewHolder = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(getActivity(), 1, paramRecommendPerson.uin, this.f, 3004, n, paramViewHolder, null, null, getString(2131886199), null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(getActivity(), paramViewHolder, 111);
    TroopRecommendReport.a(this.e, m, 1, paramRecommendPerson);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 110)
    {
      if ((paramInt1 == 111) && (paramInt2 == -1)) {
        a();
      }
    }
    else {
      e();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629604, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.removeObserver(this.b);
    this.e.removeObserver(this.c);
    this.j.setDecodeTaskCompletionListener(null);
    this.j.destory();
    this.i = null;
    this.k.a();
    this.k = null;
    this.e = null;
    this.b = null;
    this.c = null;
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
  
  public void onStop()
  {
    super.onStop();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment
 * JD-Core Version:    0.7.0.1
 */