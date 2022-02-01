package com.tencent.mobileqq.troop.homework.recite.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.config.ReciteConfig;
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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.protofile.homework.hw_recite_score.hw_recite_score.ReqReciteScore;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReciteFragment
  extends AbsHomeWorkFragment
  implements View.OnClickListener, AbsListView.OnScrollListener, CompoundButton.OnCheckedChangeListener, ReciteRecordLayout.OnReciteListener, ReciteDetectManager.ReciteDetectListener, HttpWebCgiAsyncTask.Callback, VoicePlayer.VoicePlayerListener
{
  long jdField_a_of_type_Long = 0L;
  protected Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ArticleInfo a;
  ReciteDisplayView.MyArticleAdapter jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter;
  ReciteDisplayView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView;
  protected ReciteEvaluateViewHolder a;
  ReciteRecordLayout jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout;
  ReciteDetectManager jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager;
  ReplayLyricManager jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager;
  protected TroopReciteCgiHandler a;
  protected HWReciteInfo a;
  protected HttpWebCgiAsyncTask2 a;
  protected VoicePlayer a;
  protected CalloutPopupWindow a;
  protected boolean a;
  protected int b;
  TextView b;
  TextView c = null;
  TextView d = null;
  
  public ReciteFragment()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static final String a(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("《"))
    {
      str = paramString;
      if (paramString.endsWith("》")) {
        str = paramString.substring(1, paramString.length() - 1);
      }
    }
    return str;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    AbsHomeWorkFragment.a((Activity)paramContext, ReciteFragment.class, localIntent, paramInt, paramString);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(true);
    int i = (int)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, new Object[] { "onCompleteRecite wordTotalCount=", Integer.valueOf(paramInt1), ", errorCount=", Integer.valueOf(paramInt2), ", remindCount=", Integer.valueOf(paramInt3), " time=", Integer.valueOf(i) });
    }
    hw_recite_score.ReqReciteScore localReqReciteScore = new hw_recite_score.ReqReciteScore();
    localReqReciteScore.error_times.set(paramInt2);
    localReqReciteScore.remind_times.set(paramInt3);
    localReqReciteScore.total_time.set((int)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long);
    localReqReciteScore.total_word.set(paramInt1);
    if ((paramInt1 <= 0) || (i <= 0)) {
      return;
    }
    ProtoUtils.a(super.getActivity().app, new ReciteFragment.7(this, paramInt3, paramInt2), localReqReciteScore.toByteArray(), "HwSvc.get_recite_score");
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager.a();
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = ((ReciteDisplayView)a(2131376691));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131376690));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131364500));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380548));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (!ThemeUtil.isInNightMode(super.a()))
    {
      this.vg.changeBg(true);
      this.vg.setBackgroundResource(2130838979);
      this.rightViewImg.setImageResource(2130844049);
      this.rightViewImg.setOnClickListener(new ReciteFragment.1(this));
      if (this.jdField_b_of_type_Int != 3) {
        break label342;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.rightViewImg.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout = ((ReciteRecordLayout)a(2131376804));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setOnReciteListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder = new ReciteEvaluateViewHolder(super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a((SpriteVideoView)a(2131378753));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.c();
      b();
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379751));
      if (this.jdField_b_of_type_Int == 3) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a(false, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.e);
      }
      this.jdField_a_of_type_AndroidViewView = a(2131368016);
      return;
      this.rightViewImg.setImageResource(2130844050);
      break;
      label342:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.rightViewImg.setVisibility(0);
    }
  }
  
  protected void a(Button paramButton, ReciteRecordLayout paramReciteRecordLayout)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new ReciteFragment.3(this, paramButton));
    paramButton.startAnimation(localAlphaAnimation);
    paramButton = new AlphaAnimation(0.0F, 1.0F);
    paramButton.setDuration(300L);
    paramButton.setStartOffset(160L);
    paramReciteRecordLayout.setVisibility(0);
    paramReciteRecordLayout.startAnimation(paramButton);
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
  
  public void a(@Nullable String paramString) {}
  
  public void a(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_JavaLangString = paramString;
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null)
    {
      c();
      return;
    }
    super.a();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setVisibility(8);
    }
    if (this.rightViewText != null) {
      this.rightViewText.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.b()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.d();
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_Int = 2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager = new ReplayLyricManager(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager.a();
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713183));
      this.rightViewImg.setVisibility(8);
    }
    for (;;)
    {
      VoiceRecognizer.shareInstance().destroy();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long = ((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.d();
      this.leftView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713182));
      this.rightViewImg.setVisibility(0);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler = new TroopReciteCgiHandler();
    QQAppInterface localQQAppInterface = super.a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler.a(localQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_JavaUtilList, 10003);
    }
  }
  
  protected void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a() == 3)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramString, new Handler(), 1);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(super.getActivity());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.smoothScrollToPosition(0);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
        k();
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  protected void c()
  {
    this.jdField_b_of_type_Int = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs != null))
    {
      if ((this.c == null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title)))
      {
        this.c = new TextView(super.getActivity());
        this.c.setTextSize(1, 32.0F);
        this.c.setTextColor(Color.parseColor("#424245"));
        this.c.setText(a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title));
        this.c.setGravity(1);
        this.c.setPadding(0, DisplayUtil.a(getActivity(), 26.0F), 0, 0);
        this.c.setIncludeFontPadding(false);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addHeaderView(this.c);
      }
      if ((this.d == null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.author)))
      {
        this.d = new TextView(super.getActivity());
        this.d.setTextSize(1, 18.0F);
        this.d.setTextColor(Color.parseColor("#777777"));
        this.d.setText(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.author);
        this.d.setGravity(1);
        this.d.setIncludeFontPadding(false);
        this.d.setPadding(0, DisplayUtil.a(getActivity(), 16.0F), 0, DisplayUtil.a(getActivity(), 12.0F));
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addHeaderView(this.d);
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.iterator();
      while (localIterator.hasNext()) {
        ((ParagraphInfo)localIterator.next()).resetWordsReciteStatus();
      }
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
      {
        ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(i)).resetWordsReciteStatus();
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter = new ReciteDisplayView.MyArticleAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type, ReciteDisplayView.MyArticleAdapter.c);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setArticleInfo(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setFragment(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setOnScrollListener(this);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    QQToast.a(super.getActivity(), HardCodeUtil.a(2131713191), 0).a();
  }
  
  public void d()
  {
    a(false);
    c();
  }
  
  public void e()
  {
    a(false);
    c();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString;; str = "")
    {
      TroopReportor.a("Grp_edu", "Grp_recite", "Disturb_Recite_Again_Clk", 0, 0, new String[] { str });
      return;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, "repeatRecite");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.d();
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(super.getActivity(), 230).setMessage(2131697685).setNegativeButton(HardCodeUtil.a(2131713184), new ReciteFragment.6(this)).setPositiveButton(HardCodeUtil.a(2131713192), new ReciteFragment.5(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  public int getContentLayoutId()
  {
    return 2131560787;
  }
  
  protected void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.isEmpty())) {
      QQToast.a(c(this), HardCodeUtil.a(2131713188), 0).a();
    }
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localQQAppInterface = super.a();
      } while (localQQAppInterface == null);
      if (QLog.isColorLevel())
      {
        TroopManager localTroopManager = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        QLog.d("ReciteFragment", 2, "StartRecite ReciteConfig| MaxAllowWrongNum = " + localTroopManager.a.jdField_d_of_type_Int + "; MaxDetectNumInRecite = " + localTroopManager.a.c);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.b()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.d();
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.a(super.getActivity())));
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.d();
    k();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    m();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    a(this.jdField_a_of_type_AndroidWidgetButton, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager = new ReciteDetectManager(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo, this, localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setmReciteDetectManager(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter = new ReciteDisplayView.MyArticleAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type, ReciteDisplayView.MyArticleAdapter.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter.notifyDataSetChanged();
    setLeftButton(HardCodeUtil.a(2131713186), this);
    setRightButton(2131697683, this);
    this.rightViewImg.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReplayLyricManager = new ReplayLyricManager(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$MyArticleAdapter, null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void i()
  {
    Object localObject = super.a();
    localObject = DialogUtil.a(super.getActivity(), 230).setMessage(2131697684).setNegativeButton(HardCodeUtil.a(2131713190), new ReciteFragment.9(this)).setPositiveButton(HardCodeUtil.a(2131713189), new ReciteFragment.8(this, (QQAppInterface)localObject));
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).show();
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    paramBundle = paramBundle.getString("HomeWorkConstants:homework_default_request_key");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo = new HWReciteInfo(new JSONObject(paramBundle));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Int == 1) {}
      for (this.jdField_b_of_type_Int = 3;; this.jdField_b_of_type_Int = 0)
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        new SoLibraryChecker(super.getActivity(), "3171", "libWXVoice.so", "WXVoice").a();
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
  
  protected void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a() == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.e();
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null)
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.a(super.getActivity()).b(0).a(true).a(HardCodeUtil.a(2131713187)).a(17.0F).b(0).c(50).a(-1)).b(-16777216).a(3).a().a();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.setOutsideTouchable(false);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(82);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(new ReciteFragment.10(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing())
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(this.rightViewImg);
      HWReciteUtils.a(super.a(), true);
    }
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.a();; bool = true)
    {
      switch (this.jdField_b_of_type_Int)
      {
      }
      while ((bool) && (super.onBackEvent()))
      {
        return true;
        i();
        return true;
        bool = true;
      }
      return false;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_JavaLangString))
    {
      if (!paramBoolean) {
        break label37;
      }
      b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label37:
      j();
    }
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = super.a();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Int == 0)
      {
        if (!SoLibraryChecker.a(super.getActivity(), "libWXVoice.so"))
        {
          QQCustomDialog localQQCustomDialog = DialogUtil.a(super.getActivity(), 230).setMessage(2131697476).setNegativeButton(2131697477, new ReciteFragment.2(this));
          localQQCustomDialog.setCancelable(false);
          localQQCustomDialog.show();
        }
        h();
        if (localQQAppInterface != null) {
          TroopReportor.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, "Grp_recite", "In_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b, "" });
        }
      }
      else if (this.jdField_b_of_type_Int == 2)
      {
        try
        {
          a(HWReciteInfo.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo));
          b(this);
          if (localQQAppInterface == null) {
            continue;
          }
          TroopReportor.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, "Grp_recite", "Finish_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b, "" });
          TroopReportor.a("Grp_edu", "Grp_recite", "Finish_Recite_Clk_another", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.e), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_Int) });
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        continue;
        h();
        if (localJSONException != null)
        {
          TroopReportor.a("Grp_edu", "Grp_recite", "Finish_Recite_Again_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_f_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.e), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_d_of_type_Int) });
          continue;
          if (this.jdField_b_of_type_Int == 1)
          {
            i();
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager.d();
            }
          }
        }
      }
    }
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
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.c();
    }
    k();
    m();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.b();
    }
    j();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder.a();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      setTitle("");
      return;
    }
    setTitle(a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title));
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((this.jdField_b_of_type_Int == 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (!HWReciteUtils.a(super.a())) {
        l();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment
 * JD-Core Version:    0.7.0.1
 */