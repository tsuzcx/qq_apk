package dov.com.qq.im.ae.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.HashMap;

public class AEBaseDataReporter
{
  private final int a = 10;
  
  private AEBaseDataReporter()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
  }
  
  public static AEBaseDataReporter a()
  {
    return AEBaseDataReporter.SingletonHolder.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, AEBaseReportParam.a().a(), paramBoolean);
      return;
    }
    b(paramString, AEBaseDataUtil.a(AEBaseReportParam.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((AEBaseReportParam.a().a()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  public void A()
  {
    a("click#shoot_edit#cancel_video", null);
  }
  
  public void B()
  {
    a("click#shoot_edit#video_drag", null);
  }
  
  public void C()
  {
    a("click#shoot_edit#change_location", null);
  }
  
  public void D()
  {
    a("expose#shoot_view#view", null);
  }
  
  public void E()
  {
    a("click#shoot_view#cancel_btn", null);
  }
  
  public void F()
  {
    a("click#shoot_view#local_btn", null);
  }
  
  public void G()
  {
    a("click#shoot_view#flash_btn", null);
  }
  
  public void H()
  {
    a("click#shoot_view#switch_btn", null);
  }
  
  public void I()
  {
    a("click#shoot_view#face_btn", null);
  }
  
  public void J()
  {
    a("click#shoot_view#photo_switch", null);
  }
  
  public void K()
  {
    a("click#shoot_view#emoticon_switch", null);
  }
  
  public void L()
  {
    a("click#shoot_view#module_btn", null);
  }
  
  public void M()
  {
    a("click#shoot_view#make_btn", AEBaseReportParam.a().b());
  }
  
  public void N()
  {
    a("click#shoot_view#photo_make", AEBaseReportParam.a().b());
  }
  
  public void O()
  {
    a("click#shoot_view#now_make", AEBaseReportParam.a().b());
  }
  
  public void P()
  {
    a("click#shoot_view#banner_icon", AEBaseReportParam.a().e());
  }
  
  public void Q()
  {
    a("expose#shoot_view#banner_icon", AEBaseReportParam.a().e());
  }
  
  public void R()
  {
    a("click#shoot_view#face_item_list", AEBaseReportParam.a().f());
  }
  
  public void S()
  {
    a("click#shoot_view#aggregate_icon", AEBaseReportParam.a().g());
  }
  
  public void T()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void U()
  {
    a("click#shoot_view#next_btn", AEBaseReportParam.a().c());
  }
  
  public void V()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void W()
  {
    a("click#shoot_view#done_btn", AEBaseReportParam.a().d());
  }
  
  public void X()
  {
    a("click#shoot_view#rephoto_btn", AEBaseReportParam.a().d());
  }
  
  public void Y()
  {
    a("click#transmit_view#cancel_btn", AEBaseReportParam.a().t());
  }
  
  public void Z()
  {
    if (AEBaseReportParam.a().c())
    {
      a("performance#camera_app#launch", AEBaseReportParam.a().u());
      AEBaseReportParam.a().f();
    }
  }
  
  public HashMap<String, String> a(int paramInt)
  {
    HashMap localHashMap = AEBaseReportParam.a().a(paramInt);
    a("click#shoot_edit#edit_done", localHashMap);
    return localHashMap;
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", AEBaseReportParam.a().j());
  }
  
  public void a(float paramFloat, String paramString)
  {
    a("click#shoot_edit#change_speed", AEBaseReportParam.a().a(paramFloat, paramString));
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", AEBaseReportParam.a().b(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("resultCode", Integer.toString(paramInt1));
    localHashMap.put("relation", Integer.toString(paramInt2));
    localHashMap.put("gameId", paramString2);
    localHashMap.put("myRoleId", paramString3);
    localHashMap.put("friendRoleId", paramString4);
    localHashMap.put("errorMsg", paramString1);
    a("game_center_msg_send_result", localHashMap, true);
  }
  
  public void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext_int1", String.valueOf(paramInt));
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#knead_face_failed#page_stop_time", localHashMap, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    a("click#emoticon_edit#recomm_save_btn", AEBaseReportParam.a().a(paramInt, paramString));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", AEBaseReportParam.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("click#shoot_edit#cut_btn", AEBaseReportParam.a().c(paramLong));
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    a("click#shoot_edit#com_video_next", AEBaseReportParam.a().a(paramLong, paramInt, paramString));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a("performance#camera_app#cost_time", AEBaseReportParam.a().a(paramLong1, paramLong2));
  }
  
  public void a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#video", AEBaseReportParam.a().a(paramLocalMediaInfo), true);
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", AEBaseReportParam.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", AEBaseReportParam.a().f(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", AEBaseReportParam.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", AEBaseReportParam.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", AEBaseReportParam.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localHashMap.put("combine_type", str);
      a("click#shoot_edit#combine_btn", localHashMap);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("performance#camera_app#res_download", AEBaseReportParam.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void aA()
  {
    a("face_recognition_page#camera_page#picture_guide_expose", null, true);
  }
  
  public void aB()
  {
    a("face_recognition_page#camera_page#click_start_scanning", null, true);
  }
  
  public void aC()
  {
    a("face_recognition_page#camera_page#click_close_btn", null, true);
  }
  
  public void aD()
  {
    a("face_recognition_page#photos_page#expose", null, true);
  }
  
  public void aE()
  {
    a("face_recognition_page#photos_page#click_check_btn", null, true);
  }
  
  public void aF()
  {
    a("face_recognition_page#photos_page#click_close_btn", null, true);
  }
  
  public void aG()
  {
    a("face_recognition_page#preview_page#click_sure", null, true);
  }
  
  public void aH()
  {
    a("face_recognition_page#preview_page#click_return", null, true);
  }
  
  public void aI()
  {
    a("face_recognition_page#knead_face_success#expose", null, true);
  }
  
  public void aJ()
  {
    a("face_recognition_page#knead_face_success#click_done", null, true);
  }
  
  public void aK()
  {
    a("face_recognition_page#knead_face_success#click_again_scanning", null, true);
  }
  
  public void aL()
  {
    a("face_recognition_page#knead_face_failed#click_again_scanning", null, true);
  }
  
  public void aa()
  {
    a("expose#camera_app#view", null);
  }
  
  public void ab()
  {
    a("performance#camera_app#shader", AEBaseReportParam.a().v());
  }
  
  public void ac()
  {
    a("expose#basics_view#pic_view", null);
  }
  
  public void ad()
  {
    a("expose#basics_view#photo_view", null);
  }
  
  public void ae()
  {
    a("expose#emoticon_view#view", null);
  }
  
  public void af()
  {
    a("click#emoticon_view#photo_btn", AEBaseReportParam.a().x());
  }
  
  public void ag()
  {
    a("click#emoticon_view#emoticon_item", AEBaseReportParam.a().y());
  }
  
  public void ah()
  {
    a("click#emoticon_view#emo_sort_tab", AEBaseReportParam.a().z());
  }
  
  public void ai()
  {
    a("click#emoticon_view#emo_background", null);
  }
  
  public void aj()
  {
    a("enter#emoticon_edit#view", AEBaseReportParam.a().w());
  }
  
  public void ak()
  {
    a("click#emoticon_edit#save_btn", AEBaseReportParam.a().A());
  }
  
  public void al()
  {
    a("click#emoticon_edit#send_btn", AEBaseReportParam.a().A());
  }
  
  public void am()
  {
    a("click#emoticon_edit#save_btn", AEBaseReportParam.a().B());
  }
  
  public void an()
  {
    a("click#emoticon_edit#word_return", AEBaseReportParam.a().C());
  }
  
  public void ao()
  {
    a("click#emoticon_edit#word_done", AEBaseReportParam.a().C());
  }
  
  public void ap()
  {
    a("click#shoot_view#watermark_icon", null);
  }
  
  public void aq()
  {
    a("click#shoot_view#watermark", null);
  }
  
  public void ar()
  {
    a("expose#watermark_view#view", null);
  }
  
  public void as()
  {
    a("expose#watermark_view#default_watermark", null);
  }
  
  public void at()
  {
    a("click#watermark_view#cancel_btn", null);
  }
  
  public void au()
  {
    a("expose#current_position#view", null);
  }
  
  public void av()
  {
    a("click#current_position#cancel_btn", null);
  }
  
  public void aw()
  {
    a("face_recognition_page#first_enter_guide#expose", null, true);
  }
  
  public void ax()
  {
    a("face_recognition_page#first_enter_guide#click_knead_face", null, true);
  }
  
  public void ay()
  {
    a("face_recognition_page#camera_page#expose", null, true);
  }
  
  public void az()
  {
    a("face_recognition_page#camera_page#click_photos_btn", null, true);
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", AEBaseReportParam.a().h());
  }
  
  public void b(int paramInt)
  {
    a("click#shoot_edit#change_scale", AEBaseReportParam.a().c(paramInt));
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_edit#edit_choose", AEBaseReportParam.a().d(paramLong));
  }
  
  public void b(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#picture", AEBaseReportParam.a().b(paramLocalMediaInfo));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", AEBaseReportParam.a().g(paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    if (AEBaseDataUtil.a())
    {
      a("performance#camera_app#res_ready", AEBaseReportParam.a().a(paramBoolean));
      AEBaseDataUtil.a();
    }
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", AEBaseReportParam.a().i());
  }
  
  public void c(int paramInt)
  {
    a("performance#camera_app#api_level", AEBaseReportParam.a().d(paramInt));
  }
  
  public void c(long paramLong)
  {
    a("enter#shoot_view#view", AEBaseReportParam.a().a(paramLong));
  }
  
  public void c(String paramString)
  {
    a("click#shoot_edit#ai_color_frame_on", AEBaseReportParam.a().h(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext_int1", String.valueOf(paramInt));
    a("face_recognition_page#knead_face_failed#expose", localHashMap, true);
  }
  
  public void d(long paramLong)
  {
    a("click#shoot_view#photo_btn", AEBaseReportParam.a().b(paramLong));
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#face_item", AEBaseReportParam.a().a(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", AEBaseReportParam.a().b());
  }
  
  public void e(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#camera_page#page_stop_time", localHashMap, true);
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_ai", AEBaseReportParam.a().b(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", AEBaseReportParam.a().b());
  }
  
  public void f(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#photos_page#page_stop_time", localHashMap, true);
  }
  
  public void f(String paramString)
  {
    a("click#shoot_view#filter_item", AEBaseReportParam.a().c(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", AEBaseReportParam.a().b());
  }
  
  public void g(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#knead_face_success#page_stop_time", localHashMap, true);
  }
  
  public void g(String paramString)
  {
    a("expose#shoot_view#face_item", AEBaseReportParam.a().d(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", AEBaseReportParam.a().b());
  }
  
  public void h(String paramString)
  {
    a("expose#shoot_view#tab_item", AEBaseReportParam.a().e(paramString));
  }
  
  public void i()
  {
    a("click#shoot_edit#edit_done", AEBaseReportParam.a().k());
  }
  
  public void i(String paramString)
  {
    a("expose#shoot_view#gift_btn", AEBaseReportParam.a().e(paramString));
  }
  
  public void j()
  {
    a("click#shoot_edit#text_btn", AEBaseReportParam.a().l());
  }
  
  public void j(String paramString)
  {
    a("click#shoot_view#gift_btn", AEBaseReportParam.a().e(paramString));
  }
  
  public void k()
  {
    a("click#shoot_edit#music_btn", AEBaseReportParam.a().m());
  }
  
  public void k(String paramString)
  {
    a("click#emoticon_view#filter_item", AEBaseReportParam.a().i(paramString));
  }
  
  public void l()
  {
    a("click#shoot_edit#apply_btn", AEBaseReportParam.a().m());
  }
  
  public void l(String paramString)
  {
    a("click#emoticon_edit#text_ai", AEBaseReportParam.a().j(paramString));
  }
  
  public void m()
  {
    a("click#shoot_edit#music_item", AEBaseReportParam.a().n());
  }
  
  public void m(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", AEBaseReportParam.a().k(paramString));
  }
  
  public void n()
  {
    a("click#shoot_edit#lyric_btn", AEBaseReportParam.a().o());
  }
  
  public void n(String paramString)
  {
    a("expose#emoticon_edit#edit_word", AEBaseReportParam.a().l(paramString));
  }
  
  public void o()
  {
    a("click#shoot_edit#more_music_btn", AEBaseReportParam.a().m());
  }
  
  public void o(String paramString)
  {
    a("click#watermark_view#watermark", AEBaseReportParam.a().m(paramString));
  }
  
  public void p()
  {
    a("click#shoot_edit#giveup_btn", AEBaseReportParam.a().m());
  }
  
  public void p(String paramString)
  {
    a("click#watermark_view#watermark_edit", AEBaseReportParam.a().m(paramString));
  }
  
  public void q()
  {
    a("click#shoot_edit#exit_btn", AEBaseReportParam.a().m());
  }
  
  public void q(String paramString)
  {
    a("click#current_position#position", AEBaseReportParam.a().n(paramString));
  }
  
  public void r()
  {
    a("expose#shoot_edit#edit_video", AEBaseReportParam.a().p());
  }
  
  public void s()
  {
    a("click#shoot_edit#color_match", AEBaseReportParam.a().q());
  }
  
  public void t()
  {
    a("expose#shoot_edit#text_item", AEBaseReportParam.a().r());
  }
  
  public void u()
  {
    a("click#shoot_edit#text_item", AEBaseReportParam.a().r());
  }
  
  public void v()
  {
    a("expose#shoot_edit#edit_word", AEBaseReportParam.a().s());
  }
  
  public void w()
  {
    a("click#shoot_edit#word_return", AEBaseReportParam.a().s());
  }
  
  public void x()
  {
    a("click#shoot_edit#word_done", AEBaseReportParam.a().s());
  }
  
  public void y()
  {
    a("expose#shoot_edit#com_video_page", null);
  }
  
  public void z()
  {
    a("click#shoot_edit#add_video", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.report.AEBaseDataReporter
 * JD-Core Version:    0.7.0.1
 */