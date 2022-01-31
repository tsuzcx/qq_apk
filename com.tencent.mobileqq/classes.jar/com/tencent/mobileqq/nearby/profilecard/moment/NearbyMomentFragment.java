package com.tencent.mobileqq.nearby.profilecard.moment;

import ajya;
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
import atvj;
import atvk;
import atvl;
import atvm;
import atvn;
import atvo;
import atvp;
import atvq;
import atvr;
import atvs;
import atvz;
import atwm;
import atwu;
import atwx;
import aywm;
import bbdh;
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
import vzl;

public class NearbyMomentFragment
  extends Fragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atvq jdField_a_of_type_Atvq;
  private atvz jdField_a_of_type_Atvz = new atvk(this);
  private atwm jdField_a_of_type_Atwm;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<atwx> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, atwx> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<atwx> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  private boolean e;
  
  private atwx a(String paramString)
  {
    return (atwx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private List<atwx> a(List<atwx> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        atwx localatwx = (atwx)paramList.next();
        if (a(localatwx.c) == null) {
          localArrayList.add(localatwx);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(atvr paramatvr)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_Atwm.a().size() != 0) {
        break label93;
      }
      a(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      ((atvs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, 0, 20, new atvl(this, paramatvr));
      return;
      label93:
      a(3);
    }
  }
  
  private void a(List<atwx> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (atwx)paramList.next();
        this.jdField_a_of_type_JavaUtilMap.put(((atwx)localObject).c, localObject);
        if ((localObject instanceof atwu))
        {
          localObject = (atwu)localObject;
          this.jdField_a_of_type_JavaUtilMap.put(((atwu)localObject).a, localObject);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<atwx> paramList, atvr paramatvr)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_Boolean = paramBoolean2;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131707226));
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Atwm.a(paramList);
      if (this.jdField_a_of_type_Atvq != null) {
        this.jdField_a_of_type_Atvq.a(paramList.size());
      }
      if (paramatvr != null) {
        paramatvr.a(true, paramList);
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
    } while (paramatvr == null);
    paramatvr.a(false, null);
  }
  
  private atwx b(String paramString)
  {
    return (atwx)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131707218));
      ((atvs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, this.jdField_a_of_type_Int, 20, new atvm(this));
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
      atvs localatvs = (atvs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
      if (localatvs != null) {
        localatvs.a();
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
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bbdh.k());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131707221));
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new atvn(this));
        ThreadManager.post(new NearbyMomentFragment.5(this, (URLDrawable)localObject), 8, null, false);
      }
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bbdh.k());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/fa8cc1bd068f40d08c3554d019ed445d.png", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      while (this.d)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131707225));
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new atvo(this));
        ThreadManager.post(new NearbyMomentFragment.7(this, (URLDrawable)localObject), 8, null, false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131707227));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131707219));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bbdh.k());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/0920780d51ba4d7aad487bb9bb8b18e6.png", (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131707222));
      return;
      ((URLDrawable)localObject).setURLDrawableListener(new atvp(this));
      ThreadManager.post(new NearbyMomentFragment.9(this, (URLDrawable)localObject), 8, null, false);
    }
  }
  
  public void a(atvq paramatvq)
  {
    this.jdField_a_of_type_Atvq = paramatvq;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.e)
    {
      this.jdField_a_of_type_Atwm.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559333, null);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370355));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378155));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131378600));
    this.jdField_a_of_type_Atwm = new atwm(paramViewGroup.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Atwm.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    paramBundle.width = ((int)bbdh.k());
    paramBundle.height = (paramBundle.width / 2);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramViewGroup.getContext());
    paramBundle = new AbsListView.LayoutParams(-1, -2);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, vzl.a(paramViewGroup.getContext(), 10.0F), 0, vzl.a(paramViewGroup.getContext(), 10.0F));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.d = TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!this.d)
    {
      paramViewGroup = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetListView.getLayoutParams();
      paramViewGroup.bottomMargin = vzl.a(BaseApplicationImpl.getContext(), 68.0F);
      this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Atwm);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new atvj(this));
    this.e = true;
    a(null);
    ((atvs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_Atvz);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((atvs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).b(this.jdField_a_of_type_Atvz);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment
 * JD-Core Version:    0.7.0.1
 */