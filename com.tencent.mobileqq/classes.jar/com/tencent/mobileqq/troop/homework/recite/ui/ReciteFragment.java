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
import anzj;
import bgbq;
import bgbv;
import bgbw;
import bgcb;
import bgcc;
import bgcd;
import bgce;
import bgcf;
import bgcg;
import bgch;
import bgci;
import bgcj;
import bgcx;
import bgdm;
import bgdn;
import bgdq;
import bgdr;
import bgds;
import bgdw;
import bgei;
import bgpp;
import bgpq;
import bhgr;
import bhju;
import bhlq;
import bhpc;
import bhud;
import bhue;
import blrr;
import blrs;
import blrt;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.protofile.homework.hw_recite_score.hw_recite_score.ReqReciteScore;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import nkm;
import org.json.JSONException;
import org.json.JSONObject;

public class ReciteFragment
  extends AbsHomeWorkFragment
  implements View.OnClickListener, AbsListView.OnScrollListener, CompoundButton.OnCheckedChangeListener, bgcx, bgdq, bgpp, bhue
{
  long jdField_a_of_type_Long = 0L;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bgbv jdField_a_of_type_Bgbv;
  protected bgbw a;
  bgdn jdField_a_of_type_Bgdn;
  bgdr jdField_a_of_type_Bgdr;
  protected bgdw a;
  public bgei a;
  protected bgpq a;
  protected bhud a;
  protected blrr a;
  public ArticleInfo a;
  ReciteDisplayView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView;
  ReciteRecordLayout jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout;
  protected boolean a;
  protected int b;
  TextView b;
  TextView c = null;
  TextView d = null;
  
  public ReciteFragment()
  {
    this.jdField_b_of_type_Int = 0;
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
    int i = (int)this.jdField_a_of_type_Bgei.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, new Object[] { "onCompleteRecite wordTotalCount=", Integer.valueOf(paramInt1), ", errorCount=", Integer.valueOf(paramInt2), ", remindCount=", Integer.valueOf(paramInt3), " time=", Integer.valueOf(i) });
    }
    hw_recite_score.ReqReciteScore localReqReciteScore = new hw_recite_score.ReqReciteScore();
    localReqReciteScore.error_times.set(paramInt2);
    localReqReciteScore.remind_times.set(paramInt3);
    localReqReciteScore.total_time.set((int)this.jdField_a_of_type_Bgei.jdField_a_of_type_Long);
    localReqReciteScore.total_word.set(paramInt1);
    if ((paramInt1 <= 0) || (i <= 0)) {
      return;
    }
    nkm.a(super.getActivity().app, new bgch(this, paramInt3, paramInt2), localReqReciteScore.toByteArray(), "HwSvc.get_recite_score");
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_Bgdr != null) {
      this.jdField_a_of_type_Bgdr.a();
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    if (this.jdField_a_of_type_Bhud != null)
    {
      this.jdField_a_of_type_Bhud.e();
      this.jdField_a_of_type_Bhud = null;
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = ((ReciteDisplayView)a(2131376283));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131376282));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131364293));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380028));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (!ThemeUtil.isInNightMode(super.a()))
    {
      this.vg.changeBg(true);
      this.vg.setBackgroundResource(2130838778);
      this.rightViewImg.setImageResource(2130843778);
      this.rightViewImg.setOnClickListener(new bgcb(this));
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
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout = ((ReciteRecordLayout)a(2131376398));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setOnReciteListener(this);
      this.jdField_a_of_type_Bgbw = new bgbw(super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView);
      this.jdField_a_of_type_Bgbw.a((SpriteVideoView)a(2131378270));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addFooterView(this.jdField_a_of_type_Bgbw.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Bgbw.c();
      b();
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379262));
      if (this.jdField_b_of_type_Int == 3) {
        this.jdField_a_of_type_Bgbw.a(false, this.jdField_a_of_type_Bgei.b, this.jdField_a_of_type_Bgei.jdField_f_of_type_Int, this.jdField_a_of_type_Bgei.jdField_a_of_type_Long, this.jdField_a_of_type_Bgei.jdField_d_of_type_Int, this.jdField_a_of_type_Bgei.e);
      }
      this.jdField_a_of_type_AndroidViewView = a(2131367640);
      return;
      this.rightViewImg.setImageResource(2130843779);
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
    localAlphaAnimation.setAnimationListener(new bgce(this, paramButton));
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
    if (this.jdField_a_of_type_Bgbv != null) {
      this.jdField_a_of_type_Bgbv.a(paramWordInfo);
    }
    if (this.jdField_a_of_type_Bgdr == null) {
      this.jdField_a_of_type_Bgdr = new bgdr(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_Bgbv, this.jdField_a_of_type_Bgei.g);
    }
    this.jdField_a_of_type_Bgdr.a(paramWordInfo.paragraphPos, paramWordInfo.wordPos, paramWordInfo.getStatus());
  }
  
  public void a(@Nullable String paramString) {}
  
  public void a(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_Bgei.jdField_d_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("ReciteFragment", 2, "onRecordEnd: totalTime = " + paramDouble);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    List localList;
    bgbv localbgbv;
    if ((this.jdField_a_of_type_Bgdr == null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null))
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs;
      localbgbv = this.jdField_a_of_type_Bgbv;
      if (this.jdField_a_of_type_Bgei == null) {
        break label76;
      }
    }
    label76:
    for (paramString = this.jdField_a_of_type_Bgei.g;; paramString = null)
    {
      this.jdField_a_of_type_Bgdr = new bgdr(localList, localbgbv, paramString);
      if (this.jdField_a_of_type_Bgdr != null) {
        this.jdField_a_of_type_Bgdr.a(paramInt2);
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
    this.jdField_a_of_type_Bgdn.a(paramDouble1, paramString2.split(" "));
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
  
  public void a(boolean paramBoolean)
  {
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setVisibility(8);
    }
    if (this.rightViewText != null) {
      this.rightViewText.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.b()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.e();
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_Int = 2;
      if (this.jdField_a_of_type_Bgdr == null) {
        this.jdField_a_of_type_Bgdr = new bgdr(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_Bgbv, this.jdField_a_of_type_Bgei.g);
      }
      this.jdField_a_of_type_Bgei.g = this.jdField_a_of_type_Bgdr.a();
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131712108));
      this.rightViewImg.setVisibility(8);
    }
    for (;;)
    {
      VoiceRecognizer.shareInstance().destroy();
      this.jdField_a_of_type_Bgei.jdField_a_of_type_Long = ((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Bgbw.d();
      this.leftView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131712107));
      this.rightViewImg.setVisibility(0);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bgdw = new bgdw();
    QQAppInterface localQQAppInterface = super.a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_Bgpq = this.jdField_a_of_type_Bgdw.a(localQQAppInterface, this, this.jdField_a_of_type_Bgei.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bgei.jdField_a_of_type_JavaUtilList, 10003);
    }
  }
  
  protected void b(String paramString)
  {
    if ((this.jdField_a_of_type_Bhud != null) && (this.jdField_a_of_type_Bhud.a() == 3)) {
      this.jdField_a_of_type_Bhud.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bhud == null)
      {
        if (this.jdField_a_of_type_Bgbv != null) {
          this.jdField_a_of_type_Bgbv.a();
        }
        this.jdField_a_of_type_Bhud = new bhud(paramString, new Handler(), 1);
        this.jdField_a_of_type_Bhud.a(super.getActivity());
        this.jdField_a_of_type_Bhud.a(this);
        this.jdField_a_of_type_Bhud.b();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.smoothScrollToPosition(0);
      }
      return;
      if (this.jdField_a_of_type_Bhud != null) {
        k();
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
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
        this.c.setPadding(0, bhgr.a(getActivity(), 26.0F), 0, 0);
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
        this.d.setPadding(0, bhgr.a(getActivity(), 16.0F), 0, bhgr.a(getActivity(), 12.0F));
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
      this.jdField_a_of_type_Bgbv = new bgbv(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type, bgbv.c);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setArticleInfo(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setFragment(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_Bgbv);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setOnScrollListener(this);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    QQToast.a(super.getActivity(), anzj.a(2131712116), 0).a();
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
    if (this.jdField_a_of_type_Bgei != null) {}
    for (String str = this.jdField_a_of_type_Bgei.jdField_f_of_type_JavaLangString;; str = "")
    {
      bhju.a("Grp_edu", "Grp_recite", "Disturb_Recite_Again_Clk", 0, 0, new String[] { str });
      return;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, "repeatRecite");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.e();
    }
    bhpc localbhpc = bhlq.a(super.getActivity(), 230).setMessage(2131697012).setNegativeButton(anzj.a(2131712109), new bgcg(this)).setPositiveButton(anzj.a(2131712117), new bgcf(this));
    localbhpc.setCancelable(false);
    localbhpc.show();
  }
  
  public int getContentLayoutId()
  {
    return 2131560634;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.isEmpty())) {
      QQToast.a(c(this), anzj.a(2131712113), 0).a();
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
        TroopManager localTroopManager = (TroopManager)localQQAppInterface.getManager(52);
        QLog.d("ReciteFragment", 2, "StartRecite ReciteConfig| MaxAllowWrongNum = " + localTroopManager.a.jdField_d_of_type_Int + "; MaxDetectNumInRecite = " + localTroopManager.a.c);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.b()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.e();
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.a(super.getActivity())));
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Bgbw.d();
    k();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    m();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    a(this.jdField_a_of_type_AndroidWidgetButton, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout);
    this.jdField_a_of_type_Bgdn = new bgdn(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo, this, localQQAppInterface, this.jdField_a_of_type_Bgei.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setmReciteDetectManager(this.jdField_a_of_type_Bgdn);
    this.jdField_a_of_type_Bgbv = new bgbv(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type, bgbv.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_Bgbv);
    this.jdField_a_of_type_Bgbv.notifyDataSetChanged();
    setLeftButton(anzj.a(2131712111), this);
    setRightButton(2131697010, this);
    this.rightViewImg.setVisibility(8);
    this.jdField_a_of_type_Bgdr = new bgdr(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_Bgbv, null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void i()
  {
    Object localObject = super.a();
    localObject = bhlq.a(super.getActivity(), 230).setMessage(2131697011).setNegativeButton(anzj.a(2131712115), new bgcj(this)).setPositiveButton(anzj.a(2131712114), new bgci(this, (QQAppInterface)localObject));
    ((bhpc)localObject).setCancelable(false);
    ((bhpc)localObject).show();
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    paramBundle = paramBundle.getString("HomeWorkConstants:homework_default_request_key");
    try
    {
      this.jdField_a_of_type_Bgei = new bgei(new JSONObject(paramBundle));
      if (this.jdField_a_of_type_Bgei.jdField_a_of_type_Int == 1) {}
      for (this.jdField_b_of_type_Int = 3;; this.jdField_b_of_type_Int = 0)
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        new bgds(super.getActivity(), "3171", "libWXVoice.so", "WXVoice").a();
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
    if ((this.jdField_a_of_type_Bhud != null) && (this.jdField_a_of_type_Bhud.a() == 2)) {
      this.jdField_a_of_type_Bhud.d();
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Bhud != null)
    {
      this.jdField_a_of_type_Bhud.e();
      this.jdField_a_of_type_Bhud = null;
    }
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Blrr == null)
    {
      this.jdField_a_of_type_Blrr = new blrt(blrr.a(super.getActivity()).b(0).a(true).a(anzj.a(2131712112)).a(17.0F).b(0).c(50).a(-1)).b(-16777216).a(3).a().a();
      this.jdField_a_of_type_Blrr.setOutsideTouchable(false);
      this.jdField_a_of_type_Blrr.setFocusable(false);
      this.jdField_a_of_type_Blrr.a(82);
      this.jdField_a_of_type_Blrr.a(new bgcc(this));
    }
    if (!this.jdField_a_of_type_Blrr.isShowing())
    {
      this.jdField_a_of_type_Blrr.a(this.rightViewImg);
      bgdm.a(super.a(), true);
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Blrr != null)
    {
      this.jdField_a_of_type_Blrr.dismiss();
      this.jdField_a_of_type_Blrr = null;
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bgei.jdField_d_of_type_JavaLangString))
    {
      if (!paramBoolean) {
        break label37;
      }
      b(this.jdField_a_of_type_Bgei.jdField_d_of_type_JavaLangString);
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
        if (!bgds.a(super.getActivity(), "libWXVoice.so"))
        {
          bhpc localbhpc = bhlq.a(super.getActivity(), 230).setMessage(2131696807).setNegativeButton(2131696808, new bgcd(this));
          localbhpc.setCancelable(false);
          localbhpc.show();
        }
        h();
        if (localQQAppInterface != null) {
          bhju.a(localQQAppInterface, this.jdField_a_of_type_Bgei.jdField_f_of_type_JavaLangString, "Grp_recite", "In_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_Bgei.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_Bgei.b, "" });
        }
      }
      else if (this.jdField_b_of_type_Int == 2)
      {
        try
        {
          a(bgei.a(this.jdField_a_of_type_Bgei));
          b(this);
          if (localQQAppInterface == null) {
            continue;
          }
          bhju.a(localQQAppInterface, this.jdField_a_of_type_Bgei.jdField_f_of_type_JavaLangString, "Grp_recite", "Finish_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_Bgei.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_Bgei.b, "" });
          bhju.a("Grp_edu", "Grp_recite", "Finish_Recite_Clk_another", 0, 0, new String[] { this.jdField_a_of_type_Bgei.jdField_f_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Bgei.e), String.valueOf(this.jdField_a_of_type_Bgei.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Bgei.jdField_d_of_type_Int) });
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        continue;
        h();
        if (localJSONException != null)
        {
          bhju.a("Grp_edu", "Grp_recite", "Finish_Recite_Again_Clk", 0, 0, new String[] { this.jdField_a_of_type_Bgei.jdField_f_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Bgei.e), String.valueOf(this.jdField_a_of_type_Bgei.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Bgei.jdField_d_of_type_Int) });
          continue;
          if (this.jdField_b_of_type_Int == 1)
          {
            i();
            continue;
            if (this.jdField_a_of_type_Bgdn != null) {
              this.jdField_a_of_type_Bgdn.d();
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bgbw != null) {
      this.jdField_a_of_type_Bgbw.b();
    }
    if (this.jdField_a_of_type_Bgpq != null) {
      this.jdField_a_of_type_Bgpq.cancel(true);
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
    if (this.jdField_a_of_type_Bgbw != null) {
      this.jdField_a_of_type_Bgbw.a();
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
    if (this.jdField_a_of_type_Bgbw != null) {
      this.jdField_a_of_type_Bgbw.a();
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
      if (!bgdm.a(super.a())) {
        l();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment
 * JD-Core Version:    0.7.0.1
 */