package com.tencent.mobileqq.nearby.profilecard.moment;

import aexc;
import aexd;
import aexh;
import aexj;
import aexk;
import aexl;
import aexm;
import aexn;
import aexo;
import aexp;
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
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  extends Fragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NearbyMomentFragment.FirstLoadDataCallback jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$FirstLoadDataCallback;
  private NearbyMomentManager.MomentDataChangeObserver jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver = new aexd(this);
  private NearbyProfileCardMomentAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  private MomentFeedInfo a(String paramString)
  {
    return (MomentFeedInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private List a(List paramList)
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
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a().size() != 0) {
        break label82;
      }
      a(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      NearbyMomentManager localNearbyMomentManager = (NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);
      localNearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, 20, new aexh(this, localNearbyMomentManager, paramRefreshCallback));
      return;
      label82:
      a(3);
    }
  }
  
  private void a(List paramList)
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, List paramList, NearbyMomentFragment.RefreshCallback paramRefreshCallback)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Boolean = paramBoolean2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("没有更多动态");
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a(paramList);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$FirstLoadDataCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$FirstLoadDataCallback.a(paramList.size());
      }
      if (paramRefreshCallback != null) {
        paramRefreshCallback.a(true, paramList);
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
    } while (paramRefreshCallback == null);
    paramRefreshCallback.a(false, null);
  }
  
  private int b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      PublishableMomentInfo localPublishableMomentInfo = (PublishableMomentInfo)localIterator.next();
      if ((localPublishableMomentInfo.a == null) || (localPublishableMomentInfo.a.publishState != 2)) {
        break label61;
      }
      i += 1;
    }
    label61:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private MomentFeedInfo b(String paramString)
  {
    return (MomentFeedInfo)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("加载中");
      ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_Int, 20, new aexj(this));
      return;
    }
    QLog.i("NearbyMomentFragment", 1, "loadMore, mCard == null");
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a().size();
    }
    return 0;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      NearbyMomentManager localNearbyMomentManager = (NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);
      if (localNearbyMomentManager != null) {
        localNearbyMomentManager.a();
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
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.l());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("附近内容正在加载中");
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new aexk(this));
        ThreadManager.post(new aexl(this, (URLDrawable)localObject), 8, null, false);
      }
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.l());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/fa8cc1bd068f40d08c3554d019ed445d.png", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      while (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("快来发表第一条动态");
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new aexm(this));
        ThreadManager.post(new aexn(this, (URLDrawable)localObject), 8, null, false);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("他的动态还在酝酿中");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.a;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)DeviceInfoUtil.l());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20171226/0920780d51ba4d7aad487bb9bb8b18e6.png", (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("网络异常，请点击重试");
      return;
      ((URLDrawable)localObject).setURLDrawableListener(new aexo(this));
      ThreadManager.post(new aexp(this, (URLDrawable)localObject), 8, null, false);
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      a(null);
    }
  }
  
  public void a(NearbyMomentFragment.FirstLoadDataCallback paramFirstLoadDataCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$FirstLoadDataCallback = paramFirstLoadDataCallback;
  }
  
  public void b()
  {
    int i = b();
    if (i <= 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      new NowVideoReporter().h("video_public").i("exp_failtip1").d("2").e(String.valueOf(i)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(i + "条动态消息上传失败");
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
    case 2131365255: 
      a(null);
      return;
    }
    PublicFragmentActivity.a(getActivity(), NearbyMomentFailedFragment.class);
    new NowVideoReporter().h("video_public").i("clk_failtip1").d("2").e(String.valueOf(b())).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((paramViewGroup == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      return null;
    }
    paramBundle = paramLayoutInflater.inflate(2130969124, null);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramBundle.findViewById(2131365252));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131365255));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramBundle.findViewById(2131365254));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter = new NearbyProfileCardMomentAdapter(paramViewGroup.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.width = ((int)DeviceInfoUtil.l());
    localLayoutParams.height = (localLayoutParams.width / 2);
    paramLayoutInflater = paramLayoutInflater.inflate(2130970437, null, false);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131370697);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370698));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(paramLayoutInflater);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramViewGroup.getContext());
    paramLayoutInflater = new AbsListView.LayoutParams(-1, -2);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramLayoutInflater);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, UIUtils.a(paramViewGroup.getContext(), 10.0F), 0, UIUtils.a(paramViewGroup.getContext(), 10.0F));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_c_of_type_Boolean = TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!this.jdField_c_of_type_Boolean)
    {
      paramLayoutInflater = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetListView.getLayoutParams();
      paramLayoutInflater.bottomMargin = UIUtils.a(BaseApplicationImpl.getContext(), 68.0F);
      this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramLayoutInflater);
    }
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new aexc(this));
    this.d = true;
    a(null);
    ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver);
    return paramBundle;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyProfileCardMomentAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment
 * JD-Core Version:    0.7.0.1
 */