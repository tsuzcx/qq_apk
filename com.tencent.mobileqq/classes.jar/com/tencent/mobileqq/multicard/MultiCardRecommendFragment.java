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
import anvk;
import aoep;
import aofu;
import axhf;
import axhg;
import axhh;
import axhi;
import axhj;
import axhk;
import axhq;
import axhr;
import axhs;
import axhu;
import axhv;
import axhx;
import axia;
import axib;
import bheg;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.ContactUtils;
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
  private anvk jdField_a_of_type_Anvk;
  aofu jdField_a_of_type_Aofu = new axhi(this);
  private axhq jdField_a_of_type_Axhq;
  axib jdField_a_of_type_Axib = new axhh(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new axhg(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  public MqqHandler a;
  private String b;
  
  public MultiCardRecommendFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new axhj(this);
  }
  
  private Object a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_Axhq == null) || (this.jdField_a_of_type_Axhq.a == null))
    {
      localObject1 = null;
      return localObject1;
    }
    Object[] arrayOfObject = this.jdField_a_of_type_Axhq.a.keySet().toArray();
    int j = 0;
    int i = 0;
    label55:
    if (j < this.jdField_a_of_type_Axhq.a.size())
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
      List localList = (List)this.jdField_a_of_type_Axhq.a.get(Integer.valueOf(i));
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
            if (!(localViewHolder instanceof axhr)) {
              break label286;
            }
            localObject2 = (axhs)((axhr)localViewHolder).b.get(k);
            localObject1 = localObject2;
            if (paramBitmap == null) {
              break;
            }
            localObject1 = localObject2;
            if (((axhs)localObject2).jdField_a_of_type_AndroidWidgetImageView == null) {
              break;
            }
            ((axhs)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
          for (;;)
          {
            k += 1;
            break label166;
            if ((localViewHolder instanceof axhu))
            {
              localObject2 = (axhv)((axhu)localViewHolder).b.get(k);
              localObject1 = localObject2;
              if (paramBitmap == null) {
                break;
              }
              localObject1 = localObject2;
              if (((axhv)localObject2).jdField_a_of_type_AndroidWidgetImageView == null) {
                break;
              }
              ((axhv)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376904));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376909));
    this.jdField_a_of_type_Axhq = new axhq(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramView = new LinearLayoutManager(getActivity());
    paramView.setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    paramView = new axhk(this, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Axhq);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new axhf(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axib);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener);
    this.jdField_a_of_type_Anvk = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    paramView = (axia)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER);
    if (paramView != null) {
      paramView.a(this.jdField_a_of_type_JavaLangString, 11, null);
    }
    ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(false, this.jdField_a_of_type_JavaLangString + "", "0", 9);
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_Axhq == null) || (this.jdField_a_of_type_Axhq.a == null)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.jdField_a_of_type_Axhq.a);
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
        this.jdField_a_of_type_Axhq.a.remove(Integer.valueOf(i));
      }
      j += 1;
      break label66;
      break;
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_a_of_type_Anvk.d(paramString);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_Axhq == null) || (this.jdField_a_of_type_Axhq.a == null)) {
      return;
    }
    Object[] arrayOfObject = this.jdField_a_of_type_Axhq.a.keySet().toArray();
    int j = 0;
    int i = 0;
    label48:
    if ((j < this.jdField_a_of_type_Axhq.a.size()) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(j) != null))
    {
      if ((arrayOfObject[j] == null) || (!(arrayOfObject[j] instanceof Integer))) {
        break label356;
      }
      i = ((Integer)arrayOfObject[j]).intValue();
    }
    label356:
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_Axhq.a.get(Integer.valueOf(i));
      RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(j));
      if (localViewHolder != null)
      {
        int k = 0;
        if (k < localList.size())
        {
          Object localObject1;
          Object localObject2;
          if ((localViewHolder instanceof axhr))
          {
            localObject1 = (axhr)localViewHolder;
            if ((((axhr)localObject1).b != null) && (k < ((axhr)localObject1).b.size()))
            {
              localObject2 = (axhs)((axhr)localObject1).b.get(k);
              if (((axhs)localObject2).jdField_a_of_type_AndroidWidgetImageView != null) {
                ((axhs)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((RecommendPerson)((axhr)localObject1).a.get(k)).uin));
              }
            }
          }
          for (;;)
          {
            k += 1;
            break;
            if ((localViewHolder instanceof axhu))
            {
              localObject1 = (axhu)localViewHolder;
              if ((((axhu)localObject1).b != null) && (k < ((axhu)localObject1).b.size()))
              {
                localObject2 = (axhv)((axhu)localObject1).b.get(k);
                if (((axhv)localObject2).jdField_a_of_type_AndroidWidgetImageView != null) {
                  ((axhv)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((RecommendPerson)((axhu)localObject1).a.get(k)).uin));
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
    if ((this.jdField_a_of_type_Axhq != null) && (this.jdField_a_of_type_Axhq.a != null))
    {
      if (this.jdField_a_of_type_Axhq.a.size() == 0)
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
    Map localMap = this.jdField_a_of_type_Axhq.a;
    this.jdField_a_of_type_Axhq = new axhq(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Axhq.a = localMap;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Axhq);
    this.jdField_a_of_type_Axhq.notifyDataSetChanged();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Axhq == null) || (this.jdField_a_of_type_Axhq.a == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      if ((localObject instanceof LinearLayoutManager))
      {
        localObject = (LinearLayoutManager)localObject;
        int j = ((LinearLayoutManager)localObject).findLastCompletelyVisibleItemPosition();
        int i = ((LinearLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
        localObject = this.jdField_a_of_type_Axhq.a.keySet().toArray();
        while (i <= j)
        {
          if ((i >= 0) && (i < this.jdField_a_of_type_Axhq.a.size()) && (localObject[i] != null) && ((localObject[i] instanceof Integer)))
          {
            int k = ((Integer)localObject[i]).intValue();
            List localList = (List)this.jdField_a_of_type_Axhq.a.get(Integer.valueOf(k));
            if ((localList != null) && (localList.size() > 0)) {
              axhx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecommendPerson)localList.get(0)).cardTypeID, i, localList);
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
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, "getFaceBitmap（） uin =  " + paramString + " bitmap =" + localBitmap);
    }
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 1, true);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, "requestDecodeFace（） uin =  " + paramString);
      }
    }
    return bheg.a();
  }
  
  public void a()
  {
    Object localObject;
    if ((!TextUtils.isEmpty(this.b)) && ((a(this.b)) || (this.jdField_a_of_type_Anvk.b(this.b))))
    {
      localObject = a(this.b, true, null);
      if (localObject != null)
      {
        if (!(localObject instanceof axhs)) {
          break label126;
        }
        localObject = (axhs)localObject;
        if ((localObject != null) && (((axhs)localObject).jdField_a_of_type_AndroidWidgetButton != null)) {
          ((axhs)localObject).jdField_a_of_type_AndroidWidgetButton.setText(2131718785);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 1200L);
      localObject = (axia)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER);
      if (localObject != null) {
        ((axia)localObject).a(this.jdField_a_of_type_JavaLangString, this.b);
      }
      return;
      label126:
      if ((localObject instanceof axhv))
      {
        localObject = (axhv)localObject;
        if ((localObject != null) && (((axhv)localObject).jdField_a_of_type_AndroidWidgetButton != null)) {
          ((axhv)localObject).jdField_a_of_type_AndroidWidgetButton.setText(2131718785);
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
    axhx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramRecommendPerson);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    if (paramViewHolder != null) {}
    for (int i = paramViewHolder.getAdapterPosition();; i = 0)
    {
      this.b = paramRecommendPerson.uin;
      int j = a(paramRecommendPerson);
      paramViewHolder = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramRecommendPerson.uin);
      startActivityForResult(AddFriendLogicActivity.a(getActivity(), 1, paramRecommendPerson.uin, this.jdField_a_of_type_JavaLangString, 3004, j, paramViewHolder, null, null, getString(2131689550), null), 111);
      axhx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 1, paramRecommendPerson);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131563018, paramViewGroup, false);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axib);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    this.jdField_a_of_type_Anvk = null;
    this.jdField_a_of_type_Axhq.a();
    this.jdField_a_of_type_Axhq = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Axib = null;
    this.jdField_a_of_type_Aofu = null;
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