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
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a == null))
    {
      localObject1 = null;
      return localObject1;
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.keySet().toArray();
    int j = 0;
    int i = 0;
    label55:
    if (j < this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.size())
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(j) == null) {
        return null;
      }
      if ((arrayOfObject[j] == null) || (!(arrayOfObject[j] instanceof Integer))) {
        break label357;
      }
      i = ((Integer)arrayOfObject[j]).intValue();
    }
    label166:
    label357:
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.get(Integer.valueOf(i));
      RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(j));
      if (localViewHolder != null)
      {
        int k = 0;
        if (k < localList.size())
        {
          localObject1 = (RecommendPerson)localList.get(k);
          Object localObject2;
          if ((localObject1 != null) && (paramString.equals(((RecommendPerson)localObject1).uin)))
          {
            localObject1 = (RecyclerView.ViewHolder)localViewHolder;
            if (!paramBoolean) {
              break;
            }
            if (!(localViewHolder instanceof TroopMemRecommendRclAdapter.ActiveViewHolder)) {
              break label286;
            }
            localObject2 = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localViewHolder).b.get(k);
            localObject1 = localObject2;
            if (paramBitmap == null) {
              break;
            }
            localObject1 = localObject2;
            if (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject2).jdField_a_of_type_AndroidWidgetImageView == null) {
              break;
            }
            ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
          for (;;)
          {
            k += 1;
            break label166;
            if ((localViewHolder instanceof TroopMemRecommendRclAdapter.CommonViewHolder))
            {
              localObject2 = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localViewHolder).b.get(k);
              localObject1 = localObject2;
              if (paramBitmap == null) {
                break;
              }
              localObject1 = localObject2;
              if (((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject2).jdField_a_of_type_AndroidWidgetImageView == null) {
                break;
              }
              ((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
      }
      j += 1;
      break label55;
      return null;
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377311));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377316));
    this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter = new TroopMemRecommendRclAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramView = new LinearLayoutManager(getActivity());
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
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(false, this.jdField_a_of_type_JavaLangString + "", "0", 9);
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a == null)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a);
    Object[] arrayOfObject = localHashMap.keySet().toArray();
    int j = 0;
    int i = 0;
    label66:
    if (j < localHashMap.size())
    {
      if ((arrayOfObject[j] == null) || (!(arrayOfObject[j] instanceof Integer))) {
        break label220;
      }
      i = ((Integer)arrayOfObject[j]).intValue();
    }
    label220:
    for (;;)
    {
      List localList = (List)localHashMap.get(Integer.valueOf(i));
      int k = 0;
      while (k < localList.size())
      {
        RecommendPerson localRecommendPerson = (RecommendPerson)localList.get(k);
        if ((localRecommendPerson != null) && (paramString.equals(localRecommendPerson.uin))) {
          localList.remove(localRecommendPerson);
        }
        k += 1;
      }
      if (localList.size() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.remove(Integer.valueOf(i));
      }
      j += 1;
      break label66;
      break;
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(paramString);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a == null)) {
      return;
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.keySet().toArray();
    int j = 0;
    int i = 0;
    label48:
    if ((j < this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.size()) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(j) != null))
    {
      if ((arrayOfObject[j] == null) || (!(arrayOfObject[j] instanceof Integer))) {
        break label356;
      }
      i = ((Integer)arrayOfObject[j]).intValue();
    }
    label356:
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.get(Integer.valueOf(i));
      RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(j));
      if (localViewHolder != null)
      {
        int k = 0;
        if (k < localList.size())
        {
          Object localObject1;
          Object localObject2;
          if ((localViewHolder instanceof TroopMemRecommendRclAdapter.ActiveViewHolder))
          {
            localObject1 = (TroopMemRecommendRclAdapter.ActiveViewHolder)localViewHolder;
            if ((((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject1).b != null) && (k < ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject1).b.size()))
            {
              localObject2 = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject1).b.get(k);
              if (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject2).jdField_a_of_type_AndroidWidgetImageView != null) {
                ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject1).a.get(k)).uin));
              }
            }
          }
          for (;;)
          {
            k += 1;
            break;
            if ((localViewHolder instanceof TroopMemRecommendRclAdapter.CommonViewHolder))
            {
              localObject1 = (TroopMemRecommendRclAdapter.CommonViewHolder)localViewHolder;
              if ((((TroopMemRecommendRclAdapter.CommonViewHolder)localObject1).b != null) && (k < ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject1).b.size()))
              {
                localObject2 = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject1).b.get(k);
                if (((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject2).jdField_a_of_type_AndroidWidgetImageView != null) {
                  ((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject1).a.get(k)).uin));
                }
              }
            }
          }
        }
      }
      j += 1;
      break label48;
      break;
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a.size() == 0)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a;
    this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter = new TroopMemRecommendRclAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a = localMap;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter);
    this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.notifyDataSetChanged();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter.a == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
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
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, "getFaceBitmap（） uin =  " + paramString + " bitmap =" + localBitmap);
    }
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, true);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, "requestDecodeFace（） uin =  " + paramString);
      }
    }
    return ImageUtil.c();
  }
  
  public void a()
  {
    Object localObject;
    if ((!TextUtils.isEmpty(this.b)) && ((a(this.b)) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.b))))
    {
      localObject = a(this.b, true, null);
      if (localObject != null)
      {
        if (!(localObject instanceof TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)) {
          break label126;
        }
        localObject = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject;
        if ((localObject != null) && (((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).jdField_a_of_type_AndroidWidgetButton != null)) {
          ((TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)localObject).jdField_a_of_type_AndroidWidgetButton.setText(2131719310);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 1200L);
      localObject = (TroopMemberRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER);
      if (localObject != null) {
        ((TroopMemberRecommendManager)localObject).a(this.jdField_a_of_type_JavaLangString, this.b);
      }
      return;
      label126:
      if ((localObject instanceof TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView))
      {
        localObject = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject;
        if ((localObject != null) && (((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject).jdField_a_of_type_AndroidWidgetButton != null)) {
          ((TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)localObject).jdField_a_of_type_AndroidWidgetButton.setText(2131719310);
        }
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    int i = 0;
    if (paramViewHolder != null) {
      i = paramViewHolder.getAdapterPosition();
    }
    paramViewHolder = new ProfileActivity.AllInOne(paramRecommendPerson.uin, 113);
    paramViewHolder.b.putSerializable("key_troop_recommend_person", paramRecommendPerson);
    paramViewHolder.b.putInt("key_troop_recommend_position", i);
    paramViewHolder.l = a(paramRecommendPerson);
    paramViewHolder.h = 122;
    ProfileActivity.a(getActivity(), paramViewHolder, 110);
    TroopRecommendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramRecommendPerson);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    if (paramViewHolder != null) {}
    for (int i = paramViewHolder.getAdapterPosition();; i = 0)
    {
      this.b = paramRecommendPerson.uin;
      int j = a(paramRecommendPerson);
      paramViewHolder = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramRecommendPerson.uin);
      startActivityForResult(AddFriendLogicActivity.a(getActivity(), 1, paramRecommendPerson.uin, this.jdField_a_of_type_JavaLangString, 3004, j, paramViewHolder, null, null, getString(2131689557), null), 111);
      TroopRecommendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 1, paramRecommendPerson);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      e();
      continue;
      if (paramInt2 == -1) {
        a();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563172, paramViewGroup, false);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment
 * JD-Core Version:    0.7.0.1
 */