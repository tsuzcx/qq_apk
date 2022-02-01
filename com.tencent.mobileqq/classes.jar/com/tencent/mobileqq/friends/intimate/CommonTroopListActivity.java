package com.tencent.mobileqq.friends.intimate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class CommonTroopListActivity
  extends IphoneTitleBarFragment
{
  private ListView a;
  private QQAppInterface b;
  private BaseActivity c;
  private CommonTroopListActivity.CommonTroopAdapter d;
  private ArrayList<IntimateInfo.CommonTroopInfo> e;
  private int f = -1;
  private View.OnClickListener g = new CommonTroopListActivity.1(this);
  
  public static void a(Context paramContext, ArrayList<IntimateInfo.CommonTroopInfo> paramArrayList, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("common_troop_list", paramArrayList);
    localIntent.putExtra("report_friend_type", paramInt);
    PublicFragmentActivity.a(paramContext, localIntent, CommonTroopListActivity.class);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((ListView)this.mContentView.findViewById(2131431168));
    paramLayoutInflater = this.c;
    if (paramLayoutInflater != null)
    {
      setTitle(paramLayoutInflater.getString(2131890962));
      this.f = this.c.getIntent().getIntExtra("report_friend_type", -1);
      this.e = this.c.getIntent().getParcelableArrayListExtra("common_troop_list");
      this.d = new CommonTroopListActivity.CommonTroopAdapter(this, null);
      this.d.a(this.e);
      this.a.setAdapter(this.d);
      this.b = this.c.app;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009F53", "0X8009F53", this.f, 0, "", "", "", "");
  }
  
  protected int getContentLayoutId()
  {
    return 2131625188;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.c = getBaseActivity();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.CommonTroopListActivity
 * JD-Core Version:    0.7.0.1
 */