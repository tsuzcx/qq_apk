package com.tencent.mobileqq.kandian.biz.xtab.badge;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/RIJXTabBadgeShowLevel;", "", "()V", "LEVEL_HIGH", "", "LEVEL_LOW", "LEVEL_UNKNOWN", "SP_KEY_XTAB_RED_DOT_SHOW_LEVEL", "", "value", "level", "level$annotations", "getLevel", "()I", "setLevel", "(I)V", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBadgeShowLevel
{
  public static final RIJXTabBadgeShowLevel a = new RIJXTabBadgeShowLevel();
  
  public static final int a()
  {
    return RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, false).getInt("sp_key_xtab_red_dot_level", 0);
  }
  
  public static final void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, false).edit();
    localEditor.putInt("sp_key_xtab_red_dot_level", paramInt);
    RIJSPUtils.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeShowLevel
 * JD-Core Version:    0.7.0.1
 */