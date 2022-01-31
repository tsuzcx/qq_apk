package com.tencent.mobileqq.troop.homework.recite.ui;

import aiuh;
import aiui;
import aiuj;
import aiuk;
import aiul;
import aium;
import aiun;
import aiup;
import aiuq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.troop.homework.recite.utils.HWReciteUtils;
import com.tencent.mobileqq.troop.homework.recite.utils.ReciteDetectManager;
import com.tencent.mobileqq.troop.homework.recite.utils.ReciteDetectManager.ReciteDetectListener;
import com.tencent.mobileqq.troop.homework.recite.utils.ReplayLyricManager;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.troop.homework.recite.utils.TroopReciteCgiHandler;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.protofile.homework.hw_recite_score.hw_recite_score.ReqReciteScore;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReciteFragment
  extends AbsHomeWorkFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ReciteRecordLayout.OnReciteListener, ReciteDetectManager.ReciteDetectListener, HttpWebCgiAsyncTask.Callback, VoicePlayer.VoicePlayerListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo;
  ReciteDisplayView.MyArticleAdapter jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter;
  public ReciteDisplayView a;
  private ReciteEvaluateViewHolder jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder;
  ReciteRecordLayout jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout;
  ReciteDetectManager jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager;
  ReplayLyricManager jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager;
  private TroopReciteCgiHandler jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler;
  private HWReciteInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo;
  private HttpWebCgiAsyncTask2 jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private CalloutPopupWindow jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  TextView g;
  TextView h = null;
  TextView i = null;
  
  public ReciteFragment()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    AbsHomeWorkFragment.a((Activity)paramContext, ReciteFragment.class, localIntent, paramInt, paramString);
  }
  
  private void a(Button paramButton, ReciteRecordLayout paramReciteRecordLayout)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new aiuk(this, paramButton));
    paramButton.startAnimation(localAlphaAnimation);
    paramButton = new AlphaAnimation(0.0F, 1.0F);
    paramButton.setDuration(300L);
    paramButton.setStartOffset(160L);
    paramReciteRecordLayout.setVisibility(0);
    paramReciteRecordLayout.startAnimation(paramButton);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if (this.e != null) {
      this.e.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.b()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.c();
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_Int = 2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager = new ReplayLyricManager(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager.a();
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText("完成背诵");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.d();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setText("开始背诵");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
      o();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramString, new Handler(), 1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler = new TroopReciteCgiHandler();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler.a(localQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_JavaUtilList, 10003);
    }
  }
  
  private void h()
  {
    int k = 0;
    this.jdField_b_of_type_Int = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs != null))
    {
      if ((this.h == null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title)))
      {
        this.h = new TextView(getActivity());
        this.h.setTextSize(26.0F);
        this.h.setTextColor(Color.parseColor("#424245"));
        this.h.setText(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title);
        this.h.setGravity(1);
        this.h.setPadding(0, 20, 0, 20);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addHeaderView(this.h);
      }
      if ((this.i == null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.author)))
      {
        this.i = new TextView(getActivity());
        this.i.setTextSize(22.0F);
        this.i.setTextColor(Color.parseColor("#424245"));
        this.i.setText(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.author);
        this.i.setGravity(1);
        this.i.setPadding(0, 20, 0, 20);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addHeaderView(this.i);
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.iterator();
      int j;
      for (;;)
      {
        j = k;
        if (!localIterator.hasNext()) {
          break;
        }
        ((ParagraphInfo)localIterator.next()).resetWordsReciteStatus();
      }
      while (j < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
      {
        ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(j)).resetWordsReciteStatus();
        j += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter = new ReciteDisplayView.MyArticleAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setArticleInfo(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setFragment(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter);
      return;
    }
    QQToast.a(getActivity(), "网络异常，请检查网络设置", 0).a();
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.isEmpty())) {
      QQToast.a(getActivity(), "课文信息获取失败", 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.b()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.c();
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.a(getActivity())));
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.d();
    o();
    q();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    a(this.jdField_a_of_type_AndroidWidgetButton, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager = new ReciteDetectManager(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo, this, a(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter = new ReciteDisplayView.MyArticleAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, getActivity(), new ArrayList(1), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter.notifyDataSetChanged();
    b("退出背诵", this);
    b(2131430709, this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager = new ReplayLyricManager(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter, null);
  }
  
  private void n()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230).setMessage(2131430710).setNegativeButton("取消", new aiuq(this)).setPositiveButton("确定", new aiup(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null)
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.a(getActivity()).b(0).a(true).a("如何完成一次背诵作业？").a(17.0F).b(0).c(50).a(-1)).b(getResources().getColor(2131493767)).a(3).a().a();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.setOutsideTouchable(false);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(82);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(new aiui(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing())
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(this.jdField_a_of_type_AndroidWidgetImageView);
      HWReciteUtils.a(a(), true);
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
    }
  }
  
  protected int a()
  {
    return 2130969900;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, new Object[] { "onCompleteRecite wordTotalCount=", Integer.valueOf(paramInt1), ", errorCount", Integer.valueOf(paramInt2), ", remindCount", Integer.valueOf(paramInt3) });
    }
    a(true);
    hw_recite_score.ReqReciteScore localReqReciteScore = new hw_recite_score.ReqReciteScore();
    localReqReciteScore.error_times.set(paramInt2);
    localReqReciteScore.remind_times.set(paramInt3);
    localReqReciteScore.total_time.set((int)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long);
    localReqReciteScore.total_word.set(paramInt1);
    ProtoUtils.a(getActivity().app, new aiun(this, paramInt3, paramInt2), localReqReciteScore.toByteArray(), "HwSvc.get_recite_score");
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager.a();
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = paramBundle.getString("HomeWorkConstants:homework_default_request_key");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo = new HWReciteInfo(new JSONObject(paramBundle));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Int == 1) {}
      for (this.jdField_b_of_type_Int = 3;; this.jdField_b_of_type_Int = 0)
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        new SoLibraryChecker(getActivity(), "3171", "libWXVoice.so", "WXVoice").a();
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReciteFragment", 2, paramBundle, new Object[0]);
        }
      }
    }
  }
  
  public void a(WordInfo paramWordInfo)
  {
    if (paramWordInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter.a(paramWordInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager = new ReplayLyricManager(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager.a(paramWordInfo.paragraphPos, paramWordInfo.wordPos, paramWordInfo.getStatus());
  }
  
  protected void a(@Nullable String paramString) {}
  
  public void a(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long = ((paramDouble / 1000.0D));
    if (QLog.isColorLevel()) {
      QLog.i("ReciteFragment", 2, "onRecordEnd: totalTime = " + paramDouble);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    List localList;
    ReciteDisplayView.MyArticleAdapter localMyArticleAdapter;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager == null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null))
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs;
      localMyArticleAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo == null) {
        break label76;
      }
    }
    label76:
    for (paramString = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g;; paramString = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager = new ReplayLyricManager(localList, localMyArticleAdapter, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager.a(paramInt2);
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragmentReciteDetect", 2, "startTime:" + paramDouble1 + ", chinese:" + paramString1 + ", pinyin:" + paramString2 + ", isEnd:" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager.a(paramDouble1, paramString2.split(" "));
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = ArticleInfo.onHandleGetArticleDetail(paramBundle, paramJSONObject);
    h();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void b(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = ((ReciteDisplayView)a(2131368386));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131368389));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131368388));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368390));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (!ThemeUtil.isInNightMode(a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setBackgroundResource(2130838210);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841365);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aiuh(this));
      if (this.jdField_b_of_type_Int != 3) {
        break label337;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout = ((ReciteRecordLayout)a(2131368391));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setOnReciteListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder = new ReciteEvaluateViewHolder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a((SpriteVideoView)a(2131368392));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.c();
      g();
      this.g = ((TextView)a(2131368387));
      if (this.jdField_b_of_type_Int == 3) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a(false, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.e);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841366);
      break;
      label337:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if ((this.jdField_b_of_type_Int == 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (!HWReciteUtils.a(a())) {
        p();
      }
    }
  }
  
  public void c()
  {
    a(false);
    h();
  }
  
  public void d()
  {
    a(false);
    h();
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.a();; bool = true)
    {
      switch (this.jdField_b_of_type_Int)
      {
      }
      while ((bool) && (super.d()))
      {
        return true;
        n();
        return true;
        bool = true;
      }
      return false;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString;; str = "")
    {
      TroopReportor.a("Grp_edu", "Grp_recite", "Disturb_Recite_Again_Clk", 0, 0, new String[] { str });
      return;
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, "repeatRecite");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.c();
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230).setMessage(2131430711).setNegativeButton("退出背诵", new aium(this)).setPositiveButton("重新背诵", new aiul(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_JavaLangString))
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter.a();
        }
        b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.smoothScrollToPosition(0);
      }
    }
    else {
      return;
    }
    o();
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = a();
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (this.jdField_b_of_type_Int == 0)
            {
              if (!SoLibraryChecker.a(getActivity(), "libWXVoice.so"))
              {
                paramView = DialogUtil.a(getActivity(), 230).setMessage(2131431534).setNegativeButton(2131431535, new aiuj(this));
                paramView.setCancelable(false);
                paramView.show();
              }
              i();
              if (localQQAppInterface != null) {
                TroopReportor.a("Grp_edu", "Grp_recite", "In_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, TroopReportor.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, localQQAppInterface.getCurrentAccountUin()), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b });
              }
            }
            else if (this.jdField_b_of_type_Int == 2)
            {
              try
              {
                a(HWReciteInfo.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo));
                b();
                if (localQQAppInterface != null)
                {
                  TroopReportor.a("Grp_edu", "Grp_recite", "Finish_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, TroopReportor.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, localQQAppInterface.getCurrentAccountUin()), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b });
                  TroopReportor.a("Grp_edu", "Grp_recite", "Finish_Recite_Clk_another", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.e), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_Int) });
                  return;
                }
              }
              catch (JSONException paramView)
              {
                paramView.printStackTrace();
                return;
              }
            }
          }
          i();
        } while (localQQAppInterface == null);
        TroopReportor.a("Grp_edu", "Grp_recite", "Finish_Recite_Again_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.e), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_Int) });
        return;
      } while (this.jdField_b_of_type_Int != 1);
      n();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager.b();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2.cancel(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.e();
    }
    o();
    q();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.d();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment
 * JD-Core Version:    0.7.0.1
 */