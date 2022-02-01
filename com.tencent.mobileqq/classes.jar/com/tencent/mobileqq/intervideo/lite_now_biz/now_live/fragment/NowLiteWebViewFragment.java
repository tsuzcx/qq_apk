package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.fragment;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment.LiteLiveWebViewFragment;

public class NowLiteWebViewFragment
  extends LiteLiveWebViewFragment
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowUIJs(getWebView(), getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.fragment.NowLiteWebViewFragment
 * JD-Core Version:    0.7.0.1
 */