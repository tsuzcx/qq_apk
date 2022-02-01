package com.tencent.mobileqq.qqlive.end;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class QQLiveEndFragment
  extends QQLiveBaseFragment
{
  private QQLiveEndPageInfo b = new QQLiveEndPageInfo();
  private EndLiveHelper c = new EndLiveHelper();
  
  private void a()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.b.uid = localBundle.getLong("uid");
      this.b.anchorUid = localBundle.getLong("anchorUid");
      this.b.headIcon = localBundle.getString("headIcon");
      this.b.nick = localBundle.getString("nick");
      this.b.time = localBundle.getLong("time");
      this.b.popularity = localBundle.getString("popularity");
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean, Intent paramIntent, QQLiveEndPageInfo paramQQLiveEndPageInfo)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("moduleId", "qq_live");
    localIntent.putExtra("uid", paramQQLiveEndPageInfo.uid);
    localIntent.putExtra("anchorUid", paramQQLiveEndPageInfo.anchorUid);
    localIntent.putExtra("headIcon", paramQQLiveEndPageInfo.headIcon);
    localIntent.putExtra("nick", paramQQLiveEndPageInfo.nick);
    localIntent.putExtra("time", paramQQLiveEndPageInfo.time);
    localIntent.putExtra("popularity", paramQQLiveEndPageInfo.popularity);
    localIntent.addFlags(536870912);
    if (paramBoolean) {
      paramIntent = QPublicFragmentActivityForTool.class;
    } else {
      paramIntent = QPublicFragmentActivity.class;
    }
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, paramIntent, QQLiveEndFragment.class);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    paramLayoutInflater = this.c.a(getQBaseActivity(), this.a, this.b, new QQLiveEndFragment.1(this)).getView();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.end.QQLiveEndFragment
 * JD-Core Version:    0.7.0.1
 */