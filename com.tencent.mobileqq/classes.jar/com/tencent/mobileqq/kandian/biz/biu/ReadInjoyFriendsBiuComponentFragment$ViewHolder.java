package com.tencent.mobileqq.kandian.biz.biu;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadInjoyFriendsBiuComponentFragment$ViewHolder
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ReadInJoyHeadImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
  IReadInJoyUserInfoModule.RefreshUserInfoCallBack jdField_a_of_type_ComTencentMobileqqKandianGlueMsfApiIReadInJoyUserInfoModule$RefreshUserInfoCallBack = new ReadInjoyFriendsBiuComponentFragment.ViewHolder.1(this);
  public String a;
  ArrayList<BiuCommentInfo> jdField_a_of_type_JavaUtilArrayList;
  long jdField_b_of_type_Long;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private final String jdField_b_of_type_JavaLangString = "5";
  TextView c;
  
  public ReadInjoyFriendsBiuComponentFragment$ViewHolder(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment, Context paramContext)
  {
    a(paramContext);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
  }
  
  private void a(long paramLong)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new ReadInjoyFriendsBiuComponentFragment.ViewHolder.2(this));
    String str = ReadInJoyUserInfoModule.a();
    if (localReadInJoyUserInfo != null) {
      str = localReadInJoyUserInfo.nick;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  private void a(ArrayList<BiuCommentInfo> paramArrayList)
  {
    paramArrayList = SocializeFeedsInfoUtils.a(null, "5", this.jdField_a_of_type_ComTencentMobileqqKandianGlueMsfApiIReadInJoyUserInfoModule$RefreshUserInfoCallBack, paramArrayList);
    this.c.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    this.c.setText(paramArrayList);
  }
  
  private boolean a(ArrayList<BiuCommentInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!TextUtils.isEmpty(((BiuCommentInfo)paramArrayList.next()).mBiuComment)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560209, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368064));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371862));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364910));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363660));
  }
  
  public void a(MultiBiuSameContent paramMultiBiuSameContent, int paramInt)
  {
    a(paramMultiBiuSameContent.jdField_a_of_type_Long);
    this.c.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuReadInjoyFriendsBiuComponentFragment.a);
    Object localObject = ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(paramMultiBiuSameContent.jdField_b_of_type_Int, true);
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(paramMultiBiuSameContent.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = paramMultiBiuSameContent.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int = paramMultiBiuSameContent.c;
    this.jdField_b_of_type_Long = paramMultiBiuSameContent.jdField_b_of_type_Long;
    this.c.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuReadInjoyFriendsBiuComponentFragment.a);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuReadInjoyFriendsBiuComponentFragment.a);
    this.jdField_a_of_type_JavaLangString = ReadInjoyFriendsBiuComponentFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuReadInjoyFriendsBiuComponentFragment, paramMultiBiuSameContent.jdField_a_of_type_Long, paramMultiBiuSameContent.c, paramMultiBiuSameContent.jdField_b_of_type_Long);
    try
    {
      if ((paramMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList != null) && (!paramMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList = paramMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList;
        if (a(paramMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList))
        {
          this.c.setVisibility(8);
          return;
        }
        a(this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      if (TextUtils.isEmpty(paramMultiBiuSameContent.jdField_a_of_type_JavaLangString))
      {
        this.c.setVisibility(8);
        return;
      }
      localObject = new SpannableStringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMultiBiuSameContent.jdField_a_of_type_JavaLangString);
      ((SpannableStringBuilder)localObject).append(new QQText(localStringBuilder, 7, 16));
      this.c.setText((CharSequence)localObject);
      return;
    }
    catch (Exception paramMultiBiuSameContent)
    {
      QLog.e("ReadInjoyFriendsBiuComponentFragment", 2, "setData: ", paramMultiBiuSameContent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder
 * JD-Core Version:    0.7.0.1
 */