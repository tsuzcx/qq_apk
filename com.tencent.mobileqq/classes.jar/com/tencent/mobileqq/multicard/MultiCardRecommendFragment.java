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
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new MultiCardRecommendFragment.2(this);
  private TroopMemRecommendRclAdapter jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter;
  TroopMemberRecommendObserver jdField_a_of_type_ComTencentMobileqqMulticardManagerTroopMemberRecommendObserver = new MultiCardRecommendFragment.3(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new MultiCardRecommendFragment.4(this);
  private String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MultiCardRecommendFragment.5(this);
  private String b;
  
  private Object a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter;
      if (localObject != null)
      {
        if (((TroopMemRecommendRclAdapter)localObject).a == null) {
          return null;
        }
        Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.keySet().toArray();
        int i = 0;
        int j;
        for (int k = 0; i < this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.size(); k = j)
        {
          if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i) == null) {
            return null;
          }
          j = k;
          if (arrayOfObject[i] != null)
          {
            j = k;
            if ((arrayOfObject[i] instanceof Integer)) {
              j = ((Integer)arrayOfObject[i]).intValue();
            }
          }
          List localList = (List)this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.get(Integer.valueOf(j));
          localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
          RecyclerView.ViewHolder localViewHolder = ((RecyclerView)localObject).getChildViewHolder(((RecyclerView)localObject).getChildAt(i));
          if (localViewHolder != null)
          {
            k = 0;
            while (k < localList.size())
            {
              localObject = (RecommendPerson)localList.get(k);
              if ((localObject != null) && (paramString.equals(((RecommendPerson)localObject).uin)))
              {
                localObject = (RecyclerView.ViewHolder)localViewHolder;
                if (paramBoolean)
                {
                  if ((localViewHolder instanceof TroopMemRecommendRclAdapter.ActiveViewHolder))
                  {
                    localObject = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localViewHolder).b.get(k);
                    if ((paramBitmap != null) && (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).jdField_a_of_type_AndroidWidgetImageView != null))
                    {
                      ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
                      break label346;
                    }
                    return localObject;
                  }
                  if (!(localViewHolder instanceof TroopMemRecommendRclAdapter.CommonViewHolder)) {
                    break label346;
                  }
                  TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView localCommonSubItemView = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localViewHolder).b.get(k);
                  localObject = localCommonSubItemView;
                  if (paramBitmap != null)
                  {
                    localObject = localCommonSubItemView;
                    if (localCommonSubItemView.jdField_a_of_type_AndroidWidgetImageView != null)
                    {
                      localCommonSubItemView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
                      break label346;
                    }
                  }
                }
                return localObject;
              }
              label346:
              k += 1;
            }
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376765));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376770));
    this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter = new TroopMemRecommendRclAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramView = new LinearLayoutManager(getBaseActivity());
    paramView.setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    paramView = new MultiCardRecommendFragment.SpaceItemDecoration(this, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new MultiCardRecommendFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqMulticardManagerTroopMemberRecommendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    paramView = (TroopMemberRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER);
    if (paramView != null) {
      paramView.a(this.jdField_a_of_type_JavaLangString, 11, null);
    }
    paramView = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("");
    paramView.a(false, localStringBuilder.toString(), "0", 9);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter;
      if (localObject != null)
      {
        if (((TroopMemRecommendRclAdapter)localObject).a == null) {
          return;
        }
        localObject = new HashMap();
        ((Map)localObject).putAll(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a);
        Object[] arrayOfObject = ((Map)localObject).keySet().toArray();
        int i = 0;
        int j;
        for (int k = 0; i < ((Map)localObject).size(); k = j)
        {
          j = k;
          if (arrayOfObject[i] != null)
          {
            j = k;
            if ((arrayOfObject[i] instanceof Integer)) {
              j = ((Integer)arrayOfObject[i]).intValue();
            }
          }
          List localList = (List)((Map)localObject).get(Integer.valueOf(j));
          k = 0;
          while (k < localList.size())
          {
            RecommendPerson localRecommendPerson = (RecommendPerson)localList.get(k);
            if ((localRecommendPerson != null) && (paramString.equals(localRecommendPerson.uin))) {
              localList.remove(localRecommendPerson);
            }
            k += 1;
          }
          if (localList.size() == 0) {
            this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.remove(Integer.valueOf(j));
          }
          i += 1;
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(paramString);
  }
  
  private void b()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.resume();
    }
  }
  
  private void c()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter;
      if (localObject1 != null)
      {
        if (((TroopMemRecommendRclAdapter)localObject1).a == null) {
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.keySet().toArray();
        int i = 0;
        int j;
        for (int k = 0; i < this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.size(); k = j)
        {
          if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i) == null) {
            return;
          }
          j = k;
          if (localObject1[i] != null)
          {
            j = k;
            if ((localObject1[i] instanceof Integer)) {
              j = ((Integer)localObject1[i]).intValue();
            }
          }
          List localList = (List)this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.get(Integer.valueOf(j));
          Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
          localObject2 = ((RecyclerView)localObject2).getChildViewHolder(((RecyclerView)localObject2).getChildAt(i));
          if (localObject2 != null)
          {
            k = 0;
            while (k < localList.size())
            {
              Object localObject3;
              Object localObject4;
              if ((localObject2 instanceof TroopMemRecommendRclAdapter.ActiveViewHolder))
              {
                localObject3 = (TroopMemRecommendRclAdapter.ActiveViewHolder)localObject2;
                if ((((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject3).b != null) && (k < ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject3).b.size()))
                {
                  localObject4 = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject3).b.get(k);
                  if (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject4).jdField_a_of_type_AndroidWidgetImageView != null) {
                    ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject4).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject3).a.get(k)).uin));
                  }
                }
              }
              else if ((localObject2 instanceof TroopMemRecommendRclAdapter.CommonViewHolder))
              {
                localObject3 = (TroopMemRecommendRclAdapter.CommonViewHolder)localObject2;
                if ((((TroopMemRecommendRclAdapter.CommonViewHolder)localObject3).b != null) && (k < ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject3).b.size()))
                {
                  localObject4 = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject3).b.get(k);
                  if (((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject4).jdField_a_of_type_AndroidWidgetImageView != null) {
                    ((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject4).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject3).a.get(k)).uin));
                  }
                }
              }
              k += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter;
    if ((localObject != null) && (((TroopMemRecommendRclAdapter)localObject).a != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.size() == 0)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a;
      this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter = new TroopMemRecommendRclAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      TroopMemRecommendRclAdapter localTroopMemRecommendRclAdapter = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter;
      localTroopMemRecommendRclAdapter.a = ((Map)localObject);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(localTroopMemRecommendRclAdapter);
      this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.notifyDataSetChanged();
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter;
    if (localObject != null)
    {
      if (((TroopMemRecommendRclAdapter)localObject).a == null) {
        return;
      }
      localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      if ((localObject instanceof LinearLayoutManager))
      {
        localObject = (LinearLayoutManager)localObject;
        int j = ((LinearLayoutManager)localObject).findLastCompletelyVisibleItemPosition();
        int i = ((LinearLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
        localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.keySet().toArray();
        while (i <= j)
        {
          if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.size()) && (localObject[i] != null) && ((localObject[i] instanceof Integer)))
          {
            int k = ((Integer)localObject[i]).intValue();
            List localList = (List)this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.get(Integer.valueOf(k));
            if ((localList != null) && (localList.size() > 0)) {
              TroopRecommendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecommendPerson)localList.get(0)).cardTypeID, i, localList);
            }
          }
          i += 1;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
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
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestDecodeFace（） uin =  ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    return ImageUtil.f();
  }
  
  public void a()
  {
    if ((!TextUtils.isEmpty(this.b)) && ((a(this.b)) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.b))))
    {
      Object localObject = a(this.b, true, null);
      if (localObject != null) {
        if ((localObject instanceof TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView))
        {
          localObject = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject;
          if ((localObject != null) && (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).jdField_a_of_type_AndroidWidgetButton != null)) {
            ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).jdField_a_of_type_AndroidWidgetButton.setText(2131719028);
          }
        }
        else if ((localObject instanceof TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView))
        {
          localObject = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject;
          if ((localObject != null) && (((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject).jdField_a_of_type_AndroidWidgetButton != null)) {
            ((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject).jdField_a_of_type_AndroidWidgetButton.setText(2131719028);
          }
        }
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 1200L);
      localObject = (TroopMemberRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER);
      if (localObject != null) {
        ((TroopMemberRecommendManager)localObject).a(this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    int i;
    if (paramViewHolder != null) {
      i = paramViewHolder.getAdapterPosition();
    } else {
      i = 0;
    }
    paramViewHolder = new AllInOne(paramRecommendPerson.uin, 113);
    paramViewHolder.extras.putSerializable("key_troop_recommend_person", paramRecommendPerson);
    paramViewHolder.extras.putInt("key_troop_recommend_position", i);
    paramViewHolder.subSourceId = a(paramRecommendPerson);
    paramViewHolder.profileEntryType = 122;
    ProfileUtils.openProfileCardForResult(getActivity(), paramViewHolder, 110);
    TroopRecommendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramRecommendPerson);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    int i;
    if (paramViewHolder != null) {
      i = paramViewHolder.getAdapterPosition();
    } else {
      i = 0;
    }
    this.b = paramRecommendPerson.uin;
    int j = a(paramRecommendPerson);
    paramViewHolder = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramRecommendPerson.uin);
    paramViewHolder = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(getActivity(), 1, paramRecommendPerson.uin, this.jdField_a_of_type_JavaLangString, 3004, j, paramViewHolder, null, null, getString(2131689589), null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(getActivity(), paramViewHolder, 111);
    TroopRecommendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 1, paramRecommendPerson);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131562996, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMulticardManagerTroopMemberRecommendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardManagerTroopMemberRecommendObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment
 * JD-Core Version:    0.7.0.1
 */