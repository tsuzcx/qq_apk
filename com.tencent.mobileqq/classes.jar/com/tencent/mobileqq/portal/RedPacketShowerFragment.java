package com.tencent.mobileqq.portal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class RedPacketShowerFragment
  extends QPublicBaseFragment
{
  View a;
  View b;
  ImageView c;
  ImageView d;
  ImageView e;
  Button f;
  QQAppInterface g;
  Map<String, String> h = new HashMap();
  int i;
  int j;
  int k;
  int l;
  String m;
  String n;
  String o;
  String p;
  String q;
  String r;
  QBaseActivity s;
  View.OnClickListener t = new RedPacketShowerFragment.2(this);
  private final int u = 1000;
  private final int v = 25;
  private final int w = 1;
  private long x = 0L;
  
  private void b()
  {
    this.s = getQBaseActivity();
    Bundle localBundle = this.s.getIntent().getExtras();
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI", localBundle });
    }
    try
    {
      localBundle.getInt("key_business_id", -1);
      this.i = localBundle.getInt("key_award_type", -1);
      this.k = localBundle.getInt("key_business_id", -1);
      this.l = localBundle.getInt("key_promotion_id", -1);
      this.j = localBundle.getInt("k_state", -1);
      this.r = localBundle.getString("k_pack_id");
      this.q = localBundle.getString("key_url");
      this.m = localBundle.getString("key_business_name");
      this.n = localBundle.getString("key_business_logo");
      this.o = localBundle.getString("key_business_name_pic");
      this.p = localBundle.getString("active_id");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initUI packId ");
        ((StringBuilder)localObject1).append(this.r);
        ((StringBuilder)localObject1).append("businessNamePic ");
        ((StringBuilder)localObject1).append(this.o);
        QLog.d("RedPacketShowerFragment", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (SpringFestivalEntryManager)this.g.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      Object localObject2 = ((SpringFestivalEntryManager)localObject1).a(this.o, "");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI bitmap = ");
        localStringBuilder.append(localObject2);
        QLog.d("RedPacketShowerFragment", 2, localStringBuilder.toString());
      }
      if (localObject2 == null) {
        ((SpringFestivalEntryManager)localObject1).a(new RedPacketShowerFragment.1(this, this.o, (SpringFestivalEntryManager)localObject1));
      } else {
        this.c.setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.l);
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("jackpot_id", ((StringBuilder)localObject2).toString());
      if (this.m != null) {
        this.h.put("business_name", this.m);
      }
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.k);
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("business_id", ((StringBuilder)localObject2).toString());
      if (this.p != null) {
        this.h.put("active_id", this.p);
      }
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localBundle.getLong("key_current_brush_progress_ms"));
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ext2", ((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI mParam", this.h });
      }
      SpringHbReporter.a(ReportConstant.Event.o, 0, 0, this.h, "exp", true);
      this.d.setOnClickListener(this.t);
      this.f.setOnClickListener(this.t);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RedPacketShowerFragment", 2, "getExtra Exception", localException);
      getActivity().finish();
    }
  }
  
  private void c()
  {
    this.b = this.a.findViewById(2131436546);
    this.d = ((ImageView)this.a.findViewById(2131436547));
    this.c = ((ImageView)this.a.findViewById(2131436544));
    this.f = ((Button)this.a.findViewById(2131429983));
    this.e = ((ImageView)this.a.findViewById(2131436548));
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    boolean bool;
    if (l1 - this.x >= 1000L) {
      bool = true;
    } else {
      bool = false;
    }
    this.x = l1;
    return bool;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772435, 2130772007);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = getQBaseActivity();
    if (paramBundle != null)
    {
      this.a = paramLayoutInflater.inflate(2131627763, paramViewGroup, false);
      if ((paramBundle.getAppRuntime() instanceof QQAppInterface)) {
        this.g = ((QQAppInterface)paramBundle.getAppRuntime());
      }
      if (this.g != null)
      {
        c();
        b();
      }
    }
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketShowerFragment
 * JD-Core Version:    0.7.0.1
 */