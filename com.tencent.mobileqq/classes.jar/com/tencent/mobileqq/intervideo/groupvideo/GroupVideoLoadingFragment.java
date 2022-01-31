package com.tencent.mobileqq.intervideo.groupvideo;

import adtl;
import adtm;
import adto;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GroupVideoLoadingFragment
  extends PublicBaseFragment
{
  public static boolean a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new adto(this, Looper.getMainLooper());
  private GVideoLoadingUI jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoLoadingUI;
  private GroupVideoManager jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGroupVideoManager;
  private PluginLoadListener jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoPluginLoadListener = new adtm(this);
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
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
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGroupVideoManager.a(this.jdField_a_of_type_AndroidContentContext, str2, str3, i, str1, str5, str4, str6, str7, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoPluginLoadListener);
  }
  
  private void b()
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoLoadingUI.a("网络连接错误，请检查网络后再试!", "");
      this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoLoadingUI.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoLoadingUI.a("正在检查环境", "群视频体验群，可尝鲜更酷炫的多人互动");
    GroupVideoManager.a("group_video", new adtl(this));
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean d()
  {
    Monitor.b("2856633");
    StoryReportor.a("group_video", "exitLoadPage", this.jdField_b_of_type_Int, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), new String[] { "", "", "", "7.6.3" });
    return super.d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGroupVideoManager = ((GroupVideoManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(235));
    jdField_a_of_type_Boolean = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969024, null);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoLoadingUI = new GVideoLoadingUI();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoLoadingUI.a(getActivity(), paramLayoutInflater);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    b();
    Monitor.b("2856632");
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGroupVideoManager.a(getActivity());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoPluginLoadListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment
 * JD-Core Version:    0.7.0.1
 */