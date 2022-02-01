package com.tencent.mobileqq.kandian.biz.biu;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import org.json.JSONObject;

public class ReadInjoyFriendsBiuComponentFragment
  extends PublicBaseFragment
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ReadInjoyFriendsBiuComponentFragment.1(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ReadInjoyFriendsBiuComponentFragment.2(this);
  ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<MultiBiuSameContent> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.k);
    localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
    return localStringBuilder.toString();
  }
  
  private String a(long paramLong1, int paramInt, long paramLong2)
  {
    Object localObject1 = ReadInJoyConstants.e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("uin=");
    ((StringBuilder)localObject2).append(Base64Util.encodeToString(String.valueOf(paramLong1).getBytes(), 0).replace('\n', ' ').trim());
    localObject2 = ((String)localObject1).replace("uin=", ((StringBuilder)localObject2).toString());
    localObject1 = localObject2;
    if (((String)localObject2).contains("&feedstype="))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&feedstype=");
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = ((String)localObject2).replace("&feedstype=", ((StringBuilder)localObject1).toString());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramLong2);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&jumptype=");
    ((StringBuilder)localObject2).append(4);
    return ((StringBuilder)localObject2).toString();
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithmId", this.c);
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("feedsSource", this.d);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      localJSONObject.put("feeds_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(RIJAppSetting.a());
      localJSONObject.put("kandian_mode", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(RIJTransMergeKanDianReport.a());
      localJSONObject.put("tab_source", localStringBuilder.toString());
      localJSONObject.put("rowkey", this.e);
      localJSONObject.put("channel_id", this.f);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(paramLong1), paramString, paramString, 0, 0, String.valueOf(paramLong2), "0", this.b, localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jumpUrl url:");
        localStringBuilder.append(paramString);
        QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("friends_biu_list");
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("articleID");
      this.b = paramBundle.getString("stategyID");
      this.c = paramBundle.getString("algorithmId");
      this.e = paramBundle.getString("rowkey");
      this.f = paramBundle.getString("channel_id");
      this.d = paramBundle.getString("feedsSource");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate mContents:");
        paramBundle.append(this.jdField_a_of_type_JavaUtilArrayList.size());
        QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, paramBundle.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "onCreate mContents is null or empty");
    }
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560208, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367376));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131367292));
    this.jdField_a_of_type_ComTencentWidgetListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollMode(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364703));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramLayoutInflater.findViewById(2131363342).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewGroup = (LinearLayout)paramLayoutInflater.findViewById(2131362685);
    paramBundle = new ReadInjoyFriendsBiuComponentFragment.FriensBiuAdapter(this, getBaseActivity(), this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("Biu列表");
    }
    paramViewGroup.startAnimation(AnimationUtils.loadAnimation(getBaseActivity(), 2130771993));
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity != null) {
      localBaseActivity.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment
 * JD-Core Version:    0.7.0.1
 */