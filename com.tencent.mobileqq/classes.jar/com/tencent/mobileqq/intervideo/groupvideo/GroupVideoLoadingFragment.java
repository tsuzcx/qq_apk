package com.tencent.mobileqq.intervideo.groupvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anzj;
import avzr;
import avzw;
import avzx;
import avzy;
import awaa;
import awal;
import awbj;
import bhnv;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GroupVideoLoadingFragment
  extends PublicBaseFragment
{
  public static boolean a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new avzy(this, Looper.getMainLooper());
  private avzr jdField_a_of_type_Avzr;
  private awaa jdField_a_of_type_Awaa;
  private awal jdField_a_of_type_Awal = new avzx(this);
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_a_of_type_Avzr.a(anzj.a(2131704301), "");
      this.jdField_a_of_type_Avzr.c();
      return;
    }
    this.jdField_a_of_type_Avzr.a(anzj.a(2131704297), anzj.a(2131704293));
    awaa.a("group_video", new avzw(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    String str2 = getArguments().getString("roomCode");
    String str3 = getArguments().getString("uin");
    int i = getArguments().getInt("isGroupCode");
    String str4 = getArguments().getString("backType");
    String str1 = getArguments().getString("action");
    String str5 = getArguments().getString("fromId");
    String str6 = getArguments().getString("openType");
    String str7 = getArguments().getString("extra");
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      str1 = "checkVersion";
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Awaa.a(this.jdField_a_of_type_AndroidContentContext, str2, str3, i, str1, str5, str4, str6, str7, this.jdField_a_of_type_Awal);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    awbj.b("2856633");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("exitLoadPage").opIn(this.jdField_b_of_type_Int).opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Awaa = ((awaa)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(236));
    jdField_a_of_type_Boolean = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559254, null);
    this.jdField_a_of_type_Avzr = new avzr();
    this.jdField_a_of_type_Avzr.a(getActivity(), paramLayoutInflater);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("group_video");
    a();
    awbj.b("2856632");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Awaa.a(getActivity());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Awal = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment
 * JD-Core Version:    0.7.0.1
 */