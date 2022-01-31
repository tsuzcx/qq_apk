package com.tencent.mobileqq.troop.homework.recite.ui;

import ajya;
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
import azyq;
import azyv;
import azyw;
import azzb;
import azzc;
import azzd;
import azze;
import azzf;
import azzg;
import azzh;
import azzi;
import azzj;
import azzx;
import baam;
import baan;
import baaq;
import baar;
import baas;
import baaw;
import babi;
import baic;
import baid;
import baxn;
import bbbp;
import bbdj;
import bbgu;
import bbly;
import bblz;
import bcql;
import bfxy;
import bfxz;
import bfya;
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
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.protofile.homework.hw_recite_score.hw_recite_score.ReqReciteScore;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mxf;
import org.json.JSONException;
import org.json.JSONObject;

public class ReciteFragment
  extends AbsHomeWorkFragment
  implements View.OnClickListener, AbsListView.OnScrollListener, CompoundButton.OnCheckedChangeListener, azzx, baaq, baic, bblz
{
  long jdField_a_of_type_Long = 0L;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  azyv jdField_a_of_type_Azyv;
  protected azyw a;
  baan jdField_a_of_type_Baan;
  baar jdField_a_of_type_Baar;
  protected baaw a;
  public babi a;
  protected baid a;
  protected bbly a;
  protected bfxy a;
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
    int i = (int)this.jdField_a_of_type_Babi.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, new Object[] { "onCompleteRecite wordTotalCount=", Integer.valueOf(paramInt1), ", errorCount=", Integer.valueOf(paramInt2), ", remindCount=", Integer.valueOf(paramInt3), " time=", Integer.valueOf(i) });
    }
    hw_recite_score.ReqReciteScore localReqReciteScore = new hw_recite_score.ReqReciteScore();
    localReqReciteScore.error_times.set(paramInt2);
    localReqReciteScore.remind_times.set(paramInt3);
    localReqReciteScore.total_time.set((int)this.jdField_a_of_type_Babi.jdField_a_of_type_Long);
    localReqReciteScore.total_word.set(paramInt1);
    if ((paramInt1 <= 0) || (i <= 0)) {
      return;
    }
    mxf.a(super.getActivity().app, new azzh(this, paramInt3, paramInt2), localReqReciteScore.toByteArray(), "HwSvc.get_recite_score");
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_Baar != null) {
      this.jdField_a_of_type_Baar.a();
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    if (this.jdField_a_of_type_Bbly != null)
    {
      this.jdField_a_of_type_Bbly.f();
      this.jdField_a_of_type_Bbly = null;
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = ((ReciteDisplayView)a(2131374896));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131374895));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131363982));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378312));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (!ThemeUtil.isInNightMode(super.a()))
    {
      this.vg.a(true);
      this.vg.setBackgroundResource(2130838514);
      this.rightViewImg.setImageResource(2130843202);
      this.rightViewImg.setOnClickListener(new azzb(this));
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
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout = ((ReciteRecordLayout)a(2131375014));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setOnReciteListener(this);
      this.jdField_a_of_type_Azyw = new azyw(super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView);
      this.jdField_a_of_type_Azyw.a((SpriteVideoView)a(2131376737));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addFooterView(this.jdField_a_of_type_Azyw.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Azyw.c();
      b();
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131377649));
      if (this.jdField_b_of_type_Int == 3) {
        this.jdField_a_of_type_Azyw.a(false, this.jdField_a_of_type_Babi.b, this.jdField_a_of_type_Babi.jdField_f_of_type_Int, this.jdField_a_of_type_Babi.jdField_a_of_type_Long, this.jdField_a_of_type_Babi.jdField_d_of_type_Int, this.jdField_a_of_type_Babi.e);
      }
      this.jdField_a_of_type_AndroidViewView = a(2131367134);
      return;
      this.rightViewImg.setImageResource(2130843203);
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
    localAlphaAnimation.setAnimationListener(new azze(this, paramButton));
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
    if (this.jdField_a_of_type_Azyv != null) {
      this.jdField_a_of_type_Azyv.a(paramWordInfo);
    }
    if (this.jdField_a_of_type_Baar == null) {
      this.jdField_a_of_type_Baar = new baar(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_Azyv, this.jdField_a_of_type_Babi.g);
    }
    this.jdField_a_of_type_Baar.a(paramWordInfo.paragraphPos, paramWordInfo.wordPos, paramWordInfo.getStatus());
  }
  
  public void a(@Nullable String paramString) {}
  
  public void a(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_Babi.jdField_d_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("ReciteFragment", 2, "onRecordEnd: totalTime = " + paramDouble);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    List localList;
    azyv localazyv;
    if ((this.jdField_a_of_type_Baar == null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null))
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs;
      localazyv = this.jdField_a_of_type_Azyv;
      if (this.jdField_a_of_type_Babi == null) {
        break label76;
      }
    }
    label76:
    for (paramString = this.jdField_a_of_type_Babi.g;; paramString = null)
    {
      this.jdField_a_of_type_Baar = new baar(localList, localazyv, paramString);
      if (this.jdField_a_of_type_Baar != null) {
        this.jdField_a_of_type_Baar.a(paramInt2);
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
    this.jdField_a_of_type_Baan.a(paramDouble1, paramString2.split(" "));
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
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.c();
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_Int = 2;
      if (this.jdField_a_of_type_Baar == null) {
        this.jdField_a_of_type_Baar = new baar(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_Azyv, this.jdField_a_of_type_Babi.g);
      }
      this.jdField_a_of_type_Babi.g = this.jdField_a_of_type_Baar.a();
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131713236));
      this.rightViewImg.setVisibility(8);
    }
    for (;;)
    {
      VoiceRecognizer.shareInstance().destroy();
      this.jdField_a_of_type_Babi.jdField_a_of_type_Long = ((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Azyw.d();
      this.leftView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131713235));
      this.rightViewImg.setVisibility(0);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Baaw = new baaw();
    QQAppInterface localQQAppInterface = super.a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_Baid = this.jdField_a_of_type_Baaw.a(localQQAppInterface, this, this.jdField_a_of_type_Babi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Babi.jdField_a_of_type_JavaUtilList, 10003);
    }
  }
  
  protected void b(String paramString)
  {
    if ((this.jdField_a_of_type_Bbly != null) && (this.jdField_a_of_type_Bbly.a() == 3)) {
      this.jdField_a_of_type_Bbly.c();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bbly == null)
      {
        if (this.jdField_a_of_type_Azyv != null) {
          this.jdField_a_of_type_Azyv.a();
        }
        this.jdField_a_of_type_Bbly = new bbly(paramString, new Handler(), 1);
        this.jdField_a_of_type_Bbly.a(super.getActivity());
        this.jdField_a_of_type_Bbly.a(this);
        this.jdField_a_of_type_Bbly.c();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.smoothScrollToPosition(0);
      }
      return;
      if (this.jdField_a_of_type_Bbly != null) {
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
        this.c.setPadding(0, baxn.a(getActivity(), 26.0F), 0, 0);
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
        this.d.setPadding(0, baxn.a(getActivity(), 16.0F), 0, baxn.a(getActivity(), 12.0F));
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
      this.jdField_a_of_type_Azyv = new azyv(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type, azyv.c);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setArticleInfo(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setFragment(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_Azyv);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setOnScrollListener(this);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    bcql.a(super.getActivity(), ajya.a(2131713244), 0).a();
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
    if (this.jdField_a_of_type_Babi != null) {}
    for (String str = this.jdField_a_of_type_Babi.jdField_f_of_type_JavaLangString;; str = "")
    {
      bbbp.a("Grp_edu", "Grp_recite", "Disturb_Recite_Again_Clk", 0, 0, new String[] { str });
      return;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, "repeatRecite");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.c();
    }
    bbgu localbbgu = bbdj.a(super.getActivity(), 230).setMessage(2131697937).setNegativeButton(ajya.a(2131713237), new azzg(this)).setPositiveButton(ajya.a(2131713245), new azzf(this));
    localbbgu.setCancelable(false);
    localbbgu.show();
  }
  
  public int getContentLayoutId()
  {
    return 2131560357;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.isEmpty())) {
      bcql.a(c(this), ajya.a(2131713241), 0).a();
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
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.c();
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.a(super.getActivity())));
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Azyw.d();
    k();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    m();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    a(this.jdField_a_of_type_AndroidWidgetButton, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout);
    this.jdField_a_of_type_Baan = new baan(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo, this, localQQAppInterface, this.jdField_a_of_type_Babi.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setmReciteDetectManager(this.jdField_a_of_type_Baan);
    this.jdField_a_of_type_Azyv = new azyv(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type, azyv.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_Azyv);
    this.jdField_a_of_type_Azyv.notifyDataSetChanged();
    setLeftButton(ajya.a(2131713239), this);
    setRightButton(2131697935, this);
    this.rightViewImg.setVisibility(8);
    this.jdField_a_of_type_Baar = new baar(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_Azyv, null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void i()
  {
    Object localObject = super.a();
    localObject = bbdj.a(super.getActivity(), 230).setMessage(2131697936).setNegativeButton(ajya.a(2131713243), new azzj(this)).setPositiveButton(ajya.a(2131713242), new azzi(this, (QQAppInterface)localObject));
    ((bbgu)localObject).setCancelable(false);
    ((bbgu)localObject).show();
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    paramBundle = paramBundle.getString("HomeWorkConstants:homework_default_request_key");
    try
    {
      this.jdField_a_of_type_Babi = new babi(new JSONObject(paramBundle));
      if (this.jdField_a_of_type_Babi.jdField_a_of_type_Int == 1) {}
      for (this.jdField_b_of_type_Int = 3;; this.jdField_b_of_type_Int = 0)
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        new baas(super.getActivity(), "3171", "libWXVoice.so", "WXVoice").a();
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
    if ((this.jdField_a_of_type_Bbly != null) && (this.jdField_a_of_type_Bbly.a() == 2)) {
      this.jdField_a_of_type_Bbly.e();
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Bbly != null)
    {
      this.jdField_a_of_type_Bbly.f();
      this.jdField_a_of_type_Bbly = null;
    }
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Bfxy == null)
    {
      this.jdField_a_of_type_Bfxy = new bfya(bfxy.a(super.getActivity()).b(0).a(true).a(ajya.a(2131713240)).a(17.0F).b(0).c(50).a(-1)).b(-16777216).a(3).a().a();
      this.jdField_a_of_type_Bfxy.setOutsideTouchable(false);
      this.jdField_a_of_type_Bfxy.setFocusable(false);
      this.jdField_a_of_type_Bfxy.a(82);
      this.jdField_a_of_type_Bfxy.a(new azzc(this));
    }
    if (!this.jdField_a_of_type_Bfxy.isShowing())
    {
      this.jdField_a_of_type_Bfxy.a(this.rightViewImg);
      baam.a(super.a(), true);
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Bfxy != null)
    {
      this.jdField_a_of_type_Bfxy.dismiss();
      this.jdField_a_of_type_Bfxy = null;
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Babi.jdField_d_of_type_JavaLangString))
    {
      if (paramBoolean) {
        b(this.jdField_a_of_type_Babi.jdField_d_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    j();
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = super.a();
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
              if (!baas.a(super.getActivity(), "libWXVoice.so"))
              {
                paramView = bbdj.a(super.getActivity(), 230).setMessage(2131697735).setNegativeButton(2131697736, new azzd(this));
                paramView.setCancelable(false);
                paramView.show();
              }
              h();
              if (localQQAppInterface != null) {
                bbbp.a(localQQAppInterface, this.jdField_a_of_type_Babi.jdField_f_of_type_JavaLangString, "Grp_recite", "In_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_Babi.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_Babi.b, "" });
              }
            }
            else if (this.jdField_b_of_type_Int == 2)
            {
              try
              {
                a(babi.a(this.jdField_a_of_type_Babi));
                b(this);
                if (localQQAppInterface != null)
                {
                  bbbp.a(localQQAppInterface, this.jdField_a_of_type_Babi.jdField_f_of_type_JavaLangString, "Grp_recite", "Finish_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_Babi.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_Babi.b, "" });
                  bbbp.a("Grp_edu", "Grp_recite", "Finish_Recite_Clk_another", 0, 0, new String[] { this.jdField_a_of_type_Babi.jdField_f_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Babi.e), String.valueOf(this.jdField_a_of_type_Babi.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Babi.jdField_d_of_type_Int) });
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
          h();
        } while (localQQAppInterface == null);
        bbbp.a("Grp_edu", "Grp_recite", "Finish_Recite_Again_Clk", 0, 0, new String[] { this.jdField_a_of_type_Babi.jdField_f_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Babi.e), String.valueOf(this.jdField_a_of_type_Babi.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Babi.jdField_d_of_type_Int) });
        return;
      } while (this.jdField_b_of_type_Int != 1);
      i();
      return;
    } while (this.jdField_a_of_type_Baan == null);
    this.jdField_a_of_type_Baan.d();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Azyw != null) {
      this.jdField_a_of_type_Azyw.b();
    }
    if (this.jdField_a_of_type_Baid != null) {
      this.jdField_a_of_type_Baid.cancel(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.e();
    }
    k();
    m();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Azyw != null) {
      this.jdField_a_of_type_Azyw.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.d();
    }
    j();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Azyw != null) {
      this.jdField_a_of_type_Azyw.a();
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
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((this.jdField_b_of_type_Int == 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (!baam.a(super.a())) {
        l();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment
 * JD-Core Version:    0.7.0.1
 */