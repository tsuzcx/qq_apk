package com.tencent.mobileqq.nearby.profilecard.moment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NearbyMomentFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NearbyMomentFragment.FirstLoadDataCallback jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$FirstLoadDataCallback;
  private NearbyMomentManager.MomentDataChangeObserver jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver = new NearbyMomentFragment.10(this);
  private NearbyProfileCardMomentAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<MomentFeedInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, MomentFeedInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<MomentFeedInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  private boolean e;
  
  private MomentFeedInfo a(String paramString)
  {
    return (MomentFeedInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private List<MomentFeedInfo> a(List<MomentFeedInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MomentFeedInfo localMomentFeedInfo = (MomentFeedInfo)paramList.next();
        if (a(localMomentFeedInfo.c) == null) {
          localArrayList.add(localMomentFeedInfo);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(NearbyMomentFragment.RefreshCallback paramRefreshCallback)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a().size() == 0) {
        a(0);
      } else {
        a(3);
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, 0, 20, new NearbyMomentFragment.2(this, paramRefreshCallback));
    }
  }
  
  private void a(List<MomentFeedInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (MomentFeedInfo)paramList.next();
        this.jdField_a_of_type_JavaUtilMap.put(((MomentFeedInfo)localObject).c, localObject);
        if ((localObject instanceof ChangMomentFeedInfo))
        {
          localObject = (ChangMomentFeedInfo)localObject;
          this.jdField_a_of_type_JavaUtilMap.put(((ChangMomentFeedInfo)localObject).a, localObject);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<MomentFeedInfo> paramList, NearbyMomentFragment.RefreshCallback paramRefreshCallback)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_Boolean = paramBoolean2;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707254));
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a(paramList);
      NearbyMomentFragment.FirstLoadDataCallback localFirstLoadDataCallback = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$FirstLoadDataCallback;
      if (localFirstLoadDataCallback != null) {
        localFirstLoadDataCallback.a(paramList.size());
      }
      if (paramRefreshCallback != null) {
        paramRefreshCallback.a(true, paramList);
      }
      if ((paramList != null) && (paramList.size() != 0))
      {
        a(3);
        return;
      }
      a(1);
      return;
    }
    a(2);
    if (paramRefreshCallback != null) {
      paramRefreshCallback.a(false, null);
    }
  }
  
  private MomentFeedInfo b(String paramString)
  {
    return (MomentFeedInfo)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (!this.c)
      {
        if (this.jdField_b_of_type_Boolean) {
          return;
        }
        this.c = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707246));
        ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, this.jdField_a_of_type_Int, 20, new NearbyMomentFragment.3(this));
        return;
      }
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      localObject = (NearbyMomentManager)((QQAppInterface)localObject).getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
      if (localObject != null) {
        ((NearbyMomentManager)localObject).a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.k());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
        localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/0920780d51ba4d7aad487bb9bb8b18e6.png", (URLDrawable.URLDrawableOptions)localObject);
        if (((URLDrawable)localObject).getStatus() == 1)
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
        else
        {
          ((URLDrawable)localObject).setURLDrawableListener(new NearbyMomentFragment.8(this));
          ThreadManager.post(new NearbyMomentFragment.9(this, (URLDrawable)localObject), 8, null, false);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707250));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.k());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/fa8cc1bd068f40d08c3554d019ed445d.png", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      else
      {
        ((URLDrawable)localObject).setURLDrawableListener(new NearbyMomentFragment.6(this));
        ThreadManager.post(new NearbyMomentFragment.7(this, (URLDrawable)localObject), 8, null, false);
      }
      if (this.d)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707253));
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      if ((localObject != null) && (((NearbyPeopleCard)localObject).gender == 1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707255));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707247));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.k());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    else
    {
      ((URLDrawable)localObject).setURLDrawableListener(new NearbyMomentFragment.4(this));
      ThreadManager.post(new NearbyMomentFragment.5(this, (URLDrawable)localObject), 8, null, false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707249));
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      a(null);
    }
  }
  
  public void a(NearbyMomentFragment.FirstLoadDataCallback paramFirstLoadDataCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$FirstLoadDataCallback = paramFirstLoadDataCallback;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)paramActivity).app;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131379652) {
      return;
    }
    a(null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((paramViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
        return null;
      }
      paramLayoutInflater = paramLayoutInflater.inflate(2131559488, null);
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131371432));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379652));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131380153));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter = new NearbyProfileCardMomentAdapter(paramViewGroup.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramBundle.width = ((int)DeviceInfoUtil.k());
      paramBundle.height = (paramBundle.width / 2);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramViewGroup.getContext());
      paramBundle = new AbsListView.LayoutParams(-1, -2);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, UIUtils.a(paramViewGroup.getContext(), 10.0F), 0, UIUtils.a(paramViewGroup.getContext(), 10.0F));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.d = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isHostSelf;
      if (!this.d)
      {
        paramViewGroup = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetListView.getLayoutParams();
        paramViewGroup.bottomMargin = UIUtils.a(BaseApplicationImpl.getContext(), 68.0F);
        this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramViewGroup);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new NearbyMomentFragment.1(this));
      this.e = true;
      a(null);
      ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver);
      return paramLayoutInflater;
    }
    return null;
  }
  
  public void onDestroyView()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ((NearbyMomentManager)localQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment
 * JD-Core Version:    0.7.0.1
 */