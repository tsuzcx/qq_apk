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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import org.json.JSONObject;

public class ReadInjoyFriendsBiuComponentFragment
  extends PublicBaseFragment
{
  ListView a;
  BaseActivity b;
  ImageView c;
  TextView d;
  ArrayList<MultiBiuSameContent> e = new ArrayList();
  View.OnClickListener f = new ReadInjoyFriendsBiuComponentFragment.1(this);
  AdapterView.OnItemClickListener g = new ReadInjoyFriendsBiuComponentFragment.2(this);
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  private String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.l);
    localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
    return localStringBuilder.toString();
  }
  
  private String a(long paramLong1, int paramInt, long paramLong2)
  {
    Object localObject1 = ReadInJoyConstants.f;
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
      localJSONObject.put("algorithmId", this.j);
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("feedsSource", this.k);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      localJSONObject.put("feeds_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(RIJAppSetting.b());
      localJSONObject.put("kandian_mode", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(RIJTransMergeKanDianReport.b());
      localJSONObject.put("tab_source", localStringBuilder.toString());
      localJSONObject.put("rowkey", this.l);
      localJSONObject.put("channel_id", this.m);
      PublicAccountReportUtils.a(null, String.valueOf(paramLong1), paramString, paramString, 0, 0, String.valueOf(paramLong2), "0", this.i, localJSONObject.toString(), false);
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
      ReadInJoyUtils.a(this.b, paramString);
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
    this.b = getBaseActivity();
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("friends_biu_list");
      this.e.addAll(localArrayList);
      this.h = paramBundle.getString("articleID");
      this.i = paramBundle.getString("stategyID");
      this.j = paramBundle.getString("algorithmId");
      this.l = paramBundle.getString("rowkey");
      this.m = paramBundle.getString("channel_id");
      this.k = paramBundle.getString("feedsSource");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate mContents:");
        paramBundle.append(this.e.size());
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131626255, paramViewGroup, false);
    this.d = ((TextView)paramLayoutInflater.findViewById(2131433833));
    this.a = ((ListView)paramLayoutInflater.findViewById(2131433749));
    this.a.setSelector(2131168376);
    this.a.setOverScrollMode(0);
    this.c = ((ImageView)paramLayoutInflater.findViewById(2131430806));
    this.c.setOnClickListener(this.f);
    paramLayoutInflater.findViewById(2131429220).setOnClickListener(this.f);
    paramViewGroup = (LinearLayout)paramLayoutInflater.findViewById(2131428354);
    paramBundle = new ReadInjoyFriendsBiuComponentFragment.FriensBiuAdapter(this, getBaseActivity(), this.e);
    this.a.setAdapter(paramBundle);
    this.a.setOnItemClickListener(this.g);
    if (this.e != null) {
      this.d.setText("Biu列表");
    }
    paramViewGroup.startAnimation(AnimationUtils.loadAnimation(getBaseActivity(), 2130771996));
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    BaseActivity localBaseActivity = this.b;
    if (localBaseActivity != null) {
      localBaseActivity.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment
 * JD-Core Version:    0.7.0.1
 */