package com.tencent.mobileqq.leba.mgr;

import ajzx;
import ajzy;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anxo;
import aogw;
import aqxe;
import arbh;
import arkq;
import arkr;
import awdu;
import awed;
import awee;
import awef;
import bbbq;
import bdla;
import bdvn;
import bgyd;
import blhq;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;

public class LebaTableMgrFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private ajzx jdField_a_of_type_Ajzx;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private awdu jdField_a_of_type_Awdu;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    ((bbbq)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(paramAppInfo);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131369252));
    }
    arkq localarkq = arkr.c();
    boolean bool = bdvn.a();
    if ((!localarkq.a()) || (bool))
    {
      QLog.d("leba_sort_LebaTableMgrFragment", 1, "hide mRightIcon isShowIconEntry=" + localarkq.a() + ",isStudyMode=" + bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850241);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).b(53).a();
    c();
    if (AppSetting.c) {
      bgyd.a(this.jdField_a_of_type_AndroidWidgetImageView, getResources().getString(2131719333), Button.class.getName());
    }
    MobileReportManager.getInstance().reportAction("Theme", "4", "platform898", "1", null, 101, 1, System.currentTimeMillis());
  }
  
  private void c()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((bbbq)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH)).a("150000.150100");
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b(53).a().a((BusinessInfoCheckUpdate.AppInfo)localObject);
    a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  public QQAppInterface a()
  {
    if (getActivity() == null) {
      return null;
    }
    return (QQAppInterface)getActivity().getAppInterface();
  }
  
  public String a()
  {
    String str2 = arkr.c().a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public void a()
  {
    Object localObject = a();
    if (localObject == null) {
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "updateDate appInterface == null");
    }
    do
    {
      return;
      List localList = ajzy.a().a();
      int i = anxo.d((QQAppInterface)localObject);
      localObject = new LebaTableMgrFragment.1(this, localList, anxo.a((QQAppInterface)localObject, i), i);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break;
      }
    } while (getActivity() == null);
    getActivity().runOnUiThread((Runnable)localObject);
    return;
    ((Runnable)localObject).run();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ajzx = new ajzx();
    this.jdField_a_of_type_Ajzx.a(paramBoolean);
    this.jdField_a_of_type_Awdu = new awdu(getActivity(), this.jdField_a_of_type_Ajzx, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Awdu.a(paramBoolean);
    Object localObject = new GridLayoutManager(getActivity(), 3);
    ((GridLayoutManager)localObject).setSpanSizeLookup(new awee(this.jdField_a_of_type_Awdu));
    this.jdField_a_of_type_Awdu.a((GridLayoutManager)localObject);
    blhq localblhq = new blhq(new awef(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, this.jdField_a_of_type_Ajzx, this.jdField_a_of_type_Awdu));
    localblhq.attachToRecyclerView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView);
    this.jdField_a_of_type_Awdu.a(localblhq);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setItemAnimator((RecyclerView.ItemAnimator)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addItemDecoration(new awed(getActivity(), this.jdField_a_of_type_Awdu, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Awdu);
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        arbh localarbh = (arbh)aqxe.a().a(614);
        if (localarbh == null)
        {
          QLog.i("leba_sort_LebaTableMgrFragment", 1, "configBean == null");
          return false;
        }
        int i = localarbh.b;
        if (i != 1) {
          continue;
        }
        bool = true;
        try
        {
          QLog.i("leba_sort_LebaTableMgrFragment", 1, "isSupportSort " + bool);
          return bool;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        boolean bool = false;
        continue;
      }
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "isSupportSort", localException1);
      return bool;
      bool = false;
    }
  }
  
  @Nullable
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(null, false, null);
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnCreateView mIsNight=" + this.jdField_a_of_type_Boolean);
    setTitle(getString(2131693485));
    paramLayoutInflater = a();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.initLebaHelper();
    }
    paramLayoutInflater = this.mContentView.findViewById(2131369810);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.mContentView.findViewById(2131376423));
    if (this.jdField_a_of_type_Boolean) {
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165769));
    }
    for (;;)
    {
      a(a());
      b();
      return;
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165768));
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561204;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", ((String)localObject).replace("[uid]", "").replace("[lType]", "1"));
        startActivity(localIntent);
        localObject = a();
        bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X800AE51", "0X800AE51", aogw.a((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentUin(), false), 0, "0", "0", "", "");
        ((bbbq)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH)).b("150000.150100");
        MobileReportManager.getInstance().reportAction("Theme", "4", "platform898", "1", null, 102, 1, System.currentTimeMillis());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnCreate");
    ajzy.a |= 0x1;
    paramBundle = a();
    if (paramBundle != null) {
      bdla.b(paramBundle, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnDestroy");
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = null;
    this.jdField_a_of_type_Awdu = null;
    if (this.jdField_a_of_type_Ajzx != null)
    {
      this.jdField_a_of_type_Ajzx.a(a());
      this.jdField_a_of_type_Ajzx = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnResume");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.LebaTableMgrFragment
 * JD-Core Version:    0.7.0.1
 */