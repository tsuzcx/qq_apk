package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerConfBean.BannerItem;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerInfo;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerTabItem;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerViewHolder;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerViewHolder.FeedBannerClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendFeedBannerView
  extends TabLayout
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FeedBannerInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo;
  private FeedBannerViewHolder jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder;
  private String jdField_a_of_type_JavaLangString = "school_tab";
  private boolean jdField_a_of_type_Boolean = true;
  
  public ExtendFriendFeedBannerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendFeedBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendFeedBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder == null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder = new FeedBannerViewHolder(this, paramFeedBannerClickListener, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo, 0);
  }
  
  private void b()
  {
    label137:
    ExtendFriendBannerConfBean.BannerItem localBannerItem;
    FeedBannerTabItem localFeedBannerTabItem;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo = new FeedBannerInfo();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = new FeedBannerTabItem();
        ((FeedBannerTabItem)localObject).jdField_a_of_type_Int = 0;
        ((FeedBannerTabItem)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131698767);
        ((FeedBannerTabItem)localObject).jdField_b_of_type_Int = -20771;
        ((FeedBannerTabItem)localObject).jdField_c_of_type_Int = -31578;
        ((FeedBannerTabItem)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      Object localObject = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      localBannerItem = (ExtendFriendBannerConfBean.BannerItem)((Iterator)localObject).next();
      localFeedBannerTabItem = new FeedBannerTabItem();
      if (!"0".equals(localBannerItem.type)) {
        break label293;
      }
      localFeedBannerTabItem.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localFeedBannerTabItem.jdField_a_of_type_JavaLangString = localBannerItem.title;
      localFeedBannerTabItem.jdField_a_of_type_Long = localBannerItem.id;
      localFeedBannerTabItem.jdField_b_of_type_JavaLangString = localBannerItem.subTitle;
      localFeedBannerTabItem.d = localBannerItem.schemeOrUrl;
      localFeedBannerTabItem.jdField_c_of_type_JavaLangString = localBannerItem.iconUrl;
      localFeedBannerTabItem.jdField_a_of_type_OrgJsonJSONObject = localBannerItem.extra;
      try
      {
        if (localBannerItem.bgBeginColor != null) {
          localFeedBannerTabItem.jdField_b_of_type_Int = Color.parseColor(localBannerItem.bgBeginColor);
        }
        if (localBannerItem.bgEndColor != null) {
          localFeedBannerTabItem.jdField_c_of_type_Int = Color.parseColor(localBannerItem.bgEndColor);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TabLayout", 1, "loadFeedBannerData fail.", localException);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList.add(localFeedBannerTabItem);
      break label137;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label293:
      if ("1".equals(localBannerItem.type)) {
        localFeedBannerTabItem.jdField_a_of_type_Int = 1;
      } else if ("2".equals(localBannerItem.type)) {
        localFeedBannerTabItem.jdField_a_of_type_Int = 2;
      } else if ("3".equals(localBannerItem.type)) {
        localFeedBannerTabItem.jdField_a_of_type_Int = 3;
      } else {
        localFeedBannerTabItem.jdField_a_of_type_Int = -1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder.a();
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    FeedBannerTabItem localFeedBannerTabItem = new FeedBannerTabItem();
    localFeedBannerTabItem.jdField_b_of_type_JavaLangString = (paramInt + getResources().getString(2131698792));
    localFeedBannerTabItem.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder.a(localFeedBannerTabItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    a(paramFeedBannerClickListener);
  }
  
  public void a(QQAppInterface paramQQAppInterface, FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramQQAppInterface, paramFeedBannerClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView
 * JD-Core Version:    0.7.0.1
 */