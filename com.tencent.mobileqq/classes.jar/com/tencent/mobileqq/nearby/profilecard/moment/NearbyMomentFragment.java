package com.tencent.mobileqq.nearby.profilecard.moment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import ayqw;
import ayqx;
import ayqy;
import ayqz;
import ayra;
import ayrb;
import ayrc;
import ayrd;
import ayre;
import ayrf;
import ayrm;
import ayrz;
import aysh;
import aysk;
import beyq;
import bhlo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import zps;

public class NearbyMomentFragment
  extends ReportV4Fragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayrd jdField_a_of_type_Ayrd;
  private ayrm jdField_a_of_type_Ayrm = new ayqx(this);
  private ayrz jdField_a_of_type_Ayrz;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<aysk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, aysk> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<aysk> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  private boolean e;
  
  private aysk a(String paramString)
  {
    return (aysk)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private List<aysk> a(List<aysk> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aysk localaysk = (aysk)paramList.next();
        if (a(localaysk.c) == null) {
          localArrayList.add(localaysk);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(ayre paramayre)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_Ayrz.a().size() != 0) {
        break label93;
      }
      a(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      ((ayrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, 0, 20, new ayqy(this, paramayre));
      return;
      label93:
      a(3);
    }
  }
  
  private void a(List<aysk> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (aysk)paramList.next();
        this.jdField_a_of_type_JavaUtilMap.put(((aysk)localObject).c, localObject);
        if ((localObject instanceof aysh))
        {
          localObject = (aysh)localObject;
          this.jdField_a_of_type_JavaUtilMap.put(((aysh)localObject).a, localObject);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<aysk> paramList, ayre paramayre)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_Boolean = paramBoolean2;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131706108));
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Ayrz.a(paramList);
      if (this.jdField_a_of_type_Ayrd != null) {
        this.jdField_a_of_type_Ayrd.a(paramList.size());
      }
      if (paramayre != null) {
        paramayre.a(true, paramList);
      }
      if ((paramList == null) || (paramList.size() == 0)) {
        a(1);
      }
    }
    do
    {
      return;
      a(3);
      return;
      a(2);
    } while (paramayre == null);
    paramayre.a(false, null);
  }
  
  private aysk b(String paramString)
  {
    return (aysk)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if ((this.c) || (this.jdField_b_of_type_Boolean)) {
        return;
      }
      this.c = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131706100));
      ((ayrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, this.jdField_a_of_type_Int, 20, new ayqz(this));
      return;
    }
    QLog.i("NearbyMomentFragment", 1, "loadMore, mCard == null");
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ayrf localayrf = (ayrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
      if (localayrf != null) {
        localayrf.a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(0);
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = beyq.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bhlo.k());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131706103));
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new ayra(this));
        ThreadManager.post(new NearbyMomentFragment.5(this, (URLDrawable)localObject), 8, null, false);
      }
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = beyq.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bhlo.k());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/fa8cc1bd068f40d08c3554d019ed445d.png", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      while (this.d)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131706107));
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new ayrb(this));
        ThreadManager.post(new NearbyMomentFragment.7(this, (URLDrawable)localObject), 8, null, false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131706109));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131706101));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = beyq.a;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bhlo.k());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/0920780d51ba4d7aad487bb9bb8b18e6.png", (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131706104));
      return;
      ((URLDrawable)localObject).setURLDrawableListener(new ayrc(this));
      ThreadManager.post(new NearbyMomentFragment.9(this, (URLDrawable)localObject), 8, null, false);
    }
  }
  
  public void a(ayrd paramayrd)
  {
    this.jdField_a_of_type_Ayrd = paramayrd;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.e)
    {
      this.jdField_a_of_type_Ayrz.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      a(null);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((FragmentActivity)paramActivity).app;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(null);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((paramViewGroup == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater = paramLayoutInflater.inflate(2131559504, null);
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131371342));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379809));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131380387));
      this.jdField_a_of_type_Ayrz = new ayrz(paramViewGroup.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Ayrz.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramBundle.width = ((int)bhlo.k());
      paramBundle.height = (paramBundle.width / 2);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramViewGroup.getContext());
      paramBundle = new AbsListView.LayoutParams(-1, -2);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, zps.a(paramViewGroup.getContext(), 10.0F), 0, zps.a(paramViewGroup.getContext(), 10.0F));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.d = TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (!this.d)
      {
        paramViewGroup = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetListView.getLayoutParams();
        paramViewGroup.bottomMargin = zps.a(BaseApplicationImpl.getContext(), 68.0F);
        this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramViewGroup);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ayrz);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new ayqw(this));
      this.e = true;
      a(null);
      ((ayrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_Ayrm);
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((ayrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).b(this.jdField_a_of_type_Ayrm);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment
 * JD-Core Version:    0.7.0.1
 */