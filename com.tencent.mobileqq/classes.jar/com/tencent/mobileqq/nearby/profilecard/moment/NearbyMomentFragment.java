package com.tencent.mobileqq.nearby.profilecard.moment;

import alpo;
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
import avmj;
import avmk;
import avml;
import avmm;
import avmn;
import avmo;
import avmp;
import avmq;
import avmr;
import avms;
import avmz;
import avnm;
import avnu;
import avnx;
import baul;
import bdcb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import xod;

public class NearbyMomentFragment
  extends Fragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avmq jdField_a_of_type_Avmq;
  private avmz jdField_a_of_type_Avmz = new avmk(this);
  private avnm jdField_a_of_type_Avnm;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<avnx> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, avnx> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<avnx> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  private boolean e;
  
  private avnx a(String paramString)
  {
    return (avnx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private List<avnx> a(List<avnx> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        avnx localavnx = (avnx)paramList.next();
        if (a(localavnx.c) == null) {
          localArrayList.add(localavnx);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(avmr paramavmr)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_Avnm.a().size() != 0) {
        break label93;
      }
      a(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      ((avms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, 0, 20, new avml(this, paramavmr));
      return;
      label93:
      a(3);
    }
  }
  
  private void a(List<avnx> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (avnx)paramList.next();
        this.jdField_a_of_type_JavaUtilMap.put(((avnx)localObject).c, localObject);
        if ((localObject instanceof avnu))
        {
          localObject = (avnu)localObject;
          this.jdField_a_of_type_JavaUtilMap.put(((avnu)localObject).a, localObject);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<avnx> paramList, avmr paramavmr)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_Boolean = paramBoolean2;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131707598));
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Avnm.a(paramList);
      if (this.jdField_a_of_type_Avmq != null) {
        this.jdField_a_of_type_Avmq.a(paramList.size());
      }
      if (paramavmr != null) {
        paramavmr.a(true, paramList);
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
    } while (paramavmr == null);
    paramavmr.a(false, null);
  }
  
  private avnx b(String paramString)
  {
    return (avnx)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131707590));
      ((avms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, this.jdField_a_of_type_Int, 20, new avmm(this));
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
      avms localavms = (avms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
      if (localavms != null) {
        localavms.a();
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
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bdcb.k());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131707593));
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new avmn(this));
        ThreadManager.post(new NearbyMomentFragment.5(this, (URLDrawable)localObject), 8, null, false);
      }
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bdcb.k());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/fa8cc1bd068f40d08c3554d019ed445d.png", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      while (this.d)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131707597));
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new avmo(this));
        ThreadManager.post(new NearbyMomentFragment.7(this, (URLDrawable)localObject), 8, null, false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131707599));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131707591));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bdcb.k());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/0920780d51ba4d7aad487bb9bb8b18e6.png", (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131707594));
      return;
      ((URLDrawable)localObject).setURLDrawableListener(new avmp(this));
      ThreadManager.post(new NearbyMomentFragment.9(this, (URLDrawable)localObject), 8, null, false);
    }
  }
  
  public void a(avmq paramavmq)
  {
    this.jdField_a_of_type_Avmq = paramavmq;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.e)
    {
      this.jdField_a_of_type_Avnm.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
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
    default: 
      return;
    }
    a(null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((paramViewGroup == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      return null;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131559384, null);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370660));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378713));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131379216));
    this.jdField_a_of_type_Avnm = new avnm(paramViewGroup.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Avnm.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    paramBundle.width = ((int)bdcb.k());
    paramBundle.height = (paramBundle.width / 2);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramViewGroup.getContext());
    paramBundle = new AbsListView.LayoutParams(-1, -2);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, xod.a(paramViewGroup.getContext(), 10.0F), 0, xod.a(paramViewGroup.getContext(), 10.0F));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.d = TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!this.d)
    {
      paramViewGroup = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetListView.getLayoutParams();
      paramViewGroup.bottomMargin = xod.a(BaseApplicationImpl.getContext(), 68.0F);
      this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Avnm);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new avmj(this));
    this.e = true;
    a(null);
    ((avms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_Avmz);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((avms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).b(this.jdField_a_of_type_Avmz);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment
 * JD-Core Version:    0.7.0.1
 */