package com.tencent.mobileqq.emoticonview;

import amtj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import areb;
import arfl;
import avsq;
import bcef;
import bgcz;
import bjmp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class RecommendEmotionAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  public static final int CONTENT_HEIGHT = 148;
  public static final int IMG_HEIGHT = 85;
  public static final int MSG_DOWNLOAD_END = 101;
  public static final int MSG_REFRESH_PROGRESS = 100;
  public static final int MSG_SHOW_RECOMMEND_EFFECT = 102;
  public static final String TAG = "RecommendEmotionAdapter";
  private final int TOTAL_EFFECT_NUM = 2;
  protected List<ProgressButton> btns;
  private int businessType;
  VasQuickUpdateManager.CallBacker callBacker = new RecommendEmotionAdapter.5(this);
  protected ProgressButton clickPayBtn;
  protected int contentWidth;
  private avsq emp;
  private List<bgcz> invisiableExposeList;
  boolean isRedWhenClickRecommend;
  boolean kandianBiu = false;
  public AtomicBoolean mDownloadEffect = new AtomicBoolean(false);
  public Object mEffectLock = new Object();
  private Drawable mLoadingDrawable;
  private boolean mNeedShowRedEffect;
  public ArrayList<Integer> mShowedEffectList;
  public MqqHandler mUiHandler = new bjmp(Looper.getMainLooper(), this, true);
  public ArrayList<RecommendEmotionAdapter.RecommendEffectHolder> mWaitToShowList;
  protected List<ImageView> reds;
  private List<bgcz> visiableExposeList;
  
  public RecommendEmotionAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, int paramInt4, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.businessType = paramInt4;
    this.btns = new ArrayList();
    this.reds = new ArrayList();
    this.invisiableExposeList = new ArrayList();
    this.visiableExposeList = new ArrayList();
    this.emp = ((avsq)paramQQAppInterface.getManager(14));
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    this.mNeedShowRedEffect = paramQQAppInterface.getBoolean("recommemd_red_effect", false);
    this.isRedWhenClickRecommend = paramQQAppInterface.getBoolean("is_red_when_click_recommend", false);
    this.kandianBiu = paramBoolean;
  }
  
  private LinearLayout getEmotionLayout()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    Object localObject1 = new LinearLayout.LayoutParams(this.contentWidth, (int)(148.0F * this.density));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(85.0F * this.density), (int)(85.0F * this.density));
    localLayoutParams.gravity = 1;
    ((RelativeLayout)localObject1).setId(2131374632);
    Object localObject2 = new URLImageView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131366032);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localObject2 = new URLImageView(this.mContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131366031);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    localObject2 = new ImageView(this.mContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject2).setId(2131374633);
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(11, -1);
    ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130850321));
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new TextView(this.mContext);
    ((TextView)localObject1).setId(2131366033);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(18.0F * this.density));
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ((int)(this.density * 10.0F));
    ((TextView)localObject1).setTextSize(15.0F);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setMaxLines(1);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new ProgressButton(this.mContext);
    ((ProgressButton)localObject1).setId(2131366030);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.density));
    localLayoutParams.topMargin = ((int)(this.density * 10.0F));
    localLayoutParams.gravity = 1;
    ((ProgressButton)localObject1).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839360));
    ((ProgressButton)localObject1).setTextColor(-14894864);
    ((ProgressButton)localObject1).setPadding((int)(this.density * 15.0F), 0, (int)(this.density * 15.0F), 0);
    ((ProgressButton)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((ProgressButton)localObject1).setTextSize(13.0F);
    ((ProgressButton)localObject1).setGravity(17);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    return localLinearLayout;
  }
  
  private ProgressButton getProgressButton(EmoticonPackage paramEmoticonPackage)
  {
    if ((this.btns == null) || (this.btns.size() < 1) || (paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getProgressButton view or ep error");
      return null;
    }
    Iterator localIterator = this.btns.iterator();
    while (localIterator.hasNext())
    {
      ProgressButton localProgressButton = (ProgressButton)localIterator.next();
      bgcz localbgcz = getRecommendPkgByView(localProgressButton);
      if ((localbgcz != null) && (paramEmoticonPackage.epId.equals(localbgcz.a))) {
        return localProgressButton;
      }
    }
    return null;
  }
  
  private bgcz getRecommendPkgByView(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      paramView = paramView.getTag();
    } while (paramView == null);
    if ((paramView instanceof bgcz)) {}
    for (paramView = (bgcz)paramView;; paramView = null) {
      return paramView;
    }
  }
  
  private ImageView getRedPointViewByEp(bgcz parambgcz)
  {
    if ((this.reds == null) || (this.reds.size() < 1) || (parambgcz == null) || (TextUtils.isEmpty(parambgcz.a)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getRedPointViewByEp view or ep error");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "getRedPointViewByEp");
    }
    Iterator localIterator = this.reds.iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      bgcz localbgcz = getRecommendPkgByView(localImageView);
      if ((localbgcz != null) && (parambgcz.a.equals(localbgcz.a))) {
        return localImageView;
      }
    }
    return null;
  }
  
  private boolean isCurrentPanel()
  {
    boolean bool = false;
    if (EmotionPanelConstans.getPanelType(this.app, this.curPanelInfo) == this.panelType) {
      bool = true;
    }
    return bool;
  }
  
  private boolean isPkgDownloading(bgcz parambgcz)
  {
    return ((areb)this.app.getManager(43)).a(parambgcz.a) >= 0.0F;
  }
  
  private void openEmoticonDetailPage(bgcz parambgcz, int paramInt)
  {
    boolean bool = true;
    Intent localIntent1 = null;
    if (parambgcz.n == 4)
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    Intent localIntent2;
    if (paramInt == 1)
    {
      localIntent2 = localIntent1;
      if (localIntent1 == null) {
        localIntent2 = new Intent();
      }
      localIntent2.putExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", true);
    }
    for (;;)
    {
      if ((this.mContext instanceof Activity))
      {
        if (parambgcz.n == 4) {}
        for (;;)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.mContext, this.app.getAccount(), 8, parambgcz.a, false, localIntent2, bool);
          return;
          bool = false;
        }
      }
      QLog.e("RecommendEmotionAdapter", 1, "openEmoticonDetailPage error : context not activity");
      return;
      localIntent2 = localIntent1;
    }
  }
  
  private void sendSSORequest()
  {
    Object localObject = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    ((SharedPreferences)localObject).edit().putBoolean("isClickRecommendRedpoint", true).commit();
    int i = ((SharedPreferences)localObject).getInt("recommendRuleId", -1);
    String str = this.app.getCurrentUin();
    if (this.isRedWhenClickRecommend) {}
    for (localObject = "1";; localObject = "")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "ep_mall", "PageView", "", 0, 0, 0, "", "", "", (String)localObject, "", i + "", "", 0, 0, 0, 0);
      EmoticonMainPanel.sendRecommendSSORequest(this.app, this.businessType);
      return;
    }
  }
  
  private void updateUI(View paramView, bgcz parambgcz)
  {
    if ((paramView == null) || (parambgcz == null)) {
      return;
    }
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.emp != null)
    {
      if (!isCurrentPanel()) {
        break label799;
      }
      if (!this.visiableExposeList.contains(parambgcz))
      {
        this.emp.a(parambgcz);
        i = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int j = this.data.indexOf(parambgcz);
        localObject2 = this.app.getCurrentUin();
        localObject3 = parambgcz.a;
        String str = j + 1 + "";
        if (!this.isRedWhenClickRecommend) {
          break label791;
        }
        localObject1 = "1";
        label132:
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "ep_mall", "aioshow", "", 0, 0, 0, "", (String)localObject3, str, (String)localObject1, "", i + "", "", 0, 0, 0, 0);
        this.visiableExposeList.add(parambgcz);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "updateUI epid = " + parambgcz.a + "expose num = " + parambgcz.s);
      }
      paramView.setVisibility(0);
      if (parambgcz == paramView.getTag(2131380831)) {
        break;
      }
      paramView.setTag(2131380831, parambgcz);
      try
      {
        localObject1 = (URLImageView)paramView.findViewById(2131366032);
        localObject2 = this.mContext.getResources().getDrawable(2130847023);
        localObject3 = this.mContext.getResources().getDrawable(2130847024);
        ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(parambgcz.b, (Drawable)localObject2, (Drawable)localObject3));
        ((URLImageView)localObject1).setTag(parambgcz);
        ((URLImageView)localObject1).setOnClickListener(this);
        localObject2 = (TextView)paramView.findViewById(2131366033);
        ((TextView)localObject2).setText(parambgcz.c);
        ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131167096));
        ((URLImageView)localObject1).setContentDescription(parambgcz.c);
        localObject1 = (ProgressButton)paramView.findViewById(2131366030);
        ((ProgressButton)localObject1).setText(parambgcz.d);
        ((ProgressButton)localObject1).setTag(parambgcz);
        ((ProgressButton)localObject1).setContentDescription(parambgcz.d);
        ((ProgressButton)localObject1).setOnClickListener(this);
        ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
        if ((this.btns != null) && (!this.btns.contains(localObject1))) {
          this.btns.add(localObject1);
        }
        localObject2 = (URLImageView)paramView.findViewById(2131366031);
        ((URLImageView)localObject2).setImageDrawable(null);
        ((URLImageView)localObject2).setVisibility(8);
        localObject2 = (ImageView)paramView.findViewById(2131374633);
        ((ImageView)localObject2).setVisibility(8);
        ((ImageView)localObject2).setTag(parambgcz);
        if (parambgcz.r == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect mNeedShowRedEffect:" + this.mNeedShowRedEffect + ", id:" + parambgcz.a);
          }
          i = this.data.indexOf(parambgcz);
          if ((this.mNeedShowRedEffect) && (i < 2) && ((this.mShowedEffectList == null) || ((this.mShowedEffectList.size() < 2) && (this.mShowedEffectList.indexOf(Integer.valueOf(i)) < 0))))
          {
            localObject3 = new RecommendEmotionAdapter.RecommendEffectHolder(this);
            ((RecommendEmotionAdapter.RecommendEffectHolder)localObject3).contentView = paramView;
            ((RecommendEmotionAdapter.RecommendEffectHolder)localObject3).recommendPkg = parambgcz;
            ((RecommendEmotionAdapter.RecommendEffectHolder)localObject3).index = i;
            ThreadManager.post(new RecommendEmotionAdapter.1(this, (RecommendEmotionAdapter.RecommendEffectHolder)localObject3), 8, null, true);
          }
        }
        if ((this.reds != null) && (!this.reds.contains(localObject2))) {
          this.reds.add(localObject2);
        }
        float f = ((areb)this.app.getManager(43)).a(parambgcz.a);
        if (f < 0.0F) {
          break label826;
        }
        ((ProgressButton)localObject1).setProgress((int)f);
        ((ProgressButton)localObject1).setText(amtj.a(2131712385));
        return;
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("RecommendEmotionAdapter", 1, "updateUI oom e = " + paramView);
        return;
      }
      label791:
      localObject1 = "";
      break label132;
      label799:
      if (!this.invisiableExposeList.contains(parambgcz)) {
        this.invisiableExposeList.add(parambgcz);
      }
    }
    label826:
    ((ProgressButton)localObject1).setText(parambgcz.d);
    ((ProgressButton)localObject1).setProgress(0);
  }
  
  public void destory()
  {
    super.destory();
    if (this.btns != null)
    {
      this.btns.clear();
      this.btns = null;
    }
    if (this.reds != null)
    {
      this.reds.clear();
      this.reds = null;
    }
    if (this.app != null) {
      ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.callBacker);
    }
    if (this.mShowedEffectList != null)
    {
      this.mShowedEffectList.clear();
      this.mShowedEffectList = null;
    }
    if (this.mLoadingDrawable != null) {
      this.mLoadingDrawable = null;
    }
  }
  
  public void downloadOrPay(ProgressButton paramProgressButton, bgcz parambgcz, boolean paramBoolean, int paramInt)
  {
    if ((paramProgressButton == null) || (parambgcz == null) || (this.app == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "downloadOrPay epid = " + parambgcz.a);
    }
    if ((parambgcz.o == 2) || (parambgcz.o == 6))
    {
      openEmoticonDetailPage(parambgcz, paramInt);
      bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, parambgcz.a, "", "", parambgcz.r + "");
      paramInt = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
      int i = this.data.indexOf(parambgcz);
      localObject = this.app.getCurrentUin();
      parambgcz = parambgcz.a;
      String str = i + 1 + "";
      if (this.isRedWhenClickRecommend) {}
      for (paramProgressButton = "1";; paramProgressButton = "")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "ep_mall", "0X800613D", "", 0, 0, 0, "", parambgcz, str, paramProgressButton, "", paramInt + "", "", 0, 0, 0, 0);
        return;
      }
    }
    Object localObject = (areb)this.app.getManager(43);
    ((avsq)this.app.getManager(14)).a(parambgcz.a, -1, new RecommendEmotionAdapter.2(this, parambgcz, paramBoolean, (areb)localObject, paramProgressButton, paramInt));
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.contentWidth = (this.widthPixels / this.columnNum);
    System.currentTimeMillis();
    paramViewGroup = (RecommendEmotionAdapter.RecommendEmotionViewHolder)paramViewHolder;
    paramViewHolder = paramView;
    int i;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new LinearLayout(this.mContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        i = 0;
      }
    }
    for (;;)
    {
      paramViewHolder = paramView;
      if (i < this.columnNum)
      {
        try
        {
          paramViewHolder = getEmotionLayout();
          paramViewHolder.setVisibility(8);
          localObject = new LinearLayout.LayoutParams(this.contentWidth, -1);
          if (paramInt == 0) {}
          for (((LinearLayout.LayoutParams)localObject).topMargin = ((int)(22.0F * this.density));; ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * this.density)))
          {
            paramView.addView(paramViewHolder, (ViewGroup.LayoutParams)localObject);
            break;
          }
          paramViewHolder = paramView;
        }
        catch (Exception paramViewHolder)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView ; position = " + paramInt + "; has exception ,e = " + paramViewHolder.getMessage());
          paramView = null;
          return paramView;
        }
        catch (OutOfMemoryError paramViewHolder)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView oom");
        }
        if (QLog.isColorLevel())
        {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
          paramViewHolder = paramView;
        }
      }
      recycleView(this.panelType, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.contentViews = new LinearLayout[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        paramViewGroup.contentViews[i] = ((LinearLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
      i = 0;
      int j;
      for (;;)
      {
        paramView = paramViewHolder;
        if (i >= this.columnNum) {
          break;
        }
        j = this.columnNum * paramInt + i;
        if (j <= this.data.size() - 1) {
          break label440;
        }
        paramViewGroup.contentViews[i].setTag(null);
        paramViewGroup.contentViews[i].setVisibility(8);
        i += 1;
      }
      label440:
      Object localObject = paramViewGroup.contentViews[i];
      paramView = (EmotionPanelData)this.data.get(j);
      if ((paramView instanceof bgcz)) {}
      for (paramView = (bgcz)paramView;; paramView = null)
      {
        updateUI((View)localObject, paramView);
        if (paramView == null) {
          break;
        }
        bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, paramView.a, paramInt + "", "", paramView.r + "");
        break;
      }
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      Object localObject1 = getProgressButton(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      Object localObject2 = areb.a(((BaseActivity)this.mContext).getAppRuntime(), paramMessage.epId);
      if (localObject2 == null) {
        return true;
      }
      int i = (int)((arfl)localObject2).a();
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "handleMessage refreashProgress epid = " + paramMessage.epId + ";progress = " + i);
      }
      if (i == 100) {
        bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, paramMessage.epId, "", "", "");
      }
      ((ProgressButton)localObject1).setProgress(i);
      ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
      continue;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      paramMessage = getProgressButton(paramMessage);
      if (paramMessage == null) {
        return true;
      }
      localObject1 = getRecommendPkgByView(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      paramMessage.setProgress(0);
      paramMessage.setText(((bgcz)localObject1).d);
      refreshPanelData();
      bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X8005816", 0, 1, ((bgcz)localObject1).a, "", "", "");
      continue;
      if ((paramMessage.obj instanceof RecommendEmotionAdapter.RecommendEffectHolder))
      {
        paramMessage = (RecommendEmotionAdapter.RecommendEffectHolder)paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.isShow)) {
          return true;
        }
        paramMessage.isShow = true;
        if ((paramMessage.contentView == null) || (paramMessage.recommendPkg == null) || (paramMessage.effectFile == null) || (paramMessage.contentView.getVisibility() != 0)) {
          return true;
        }
        if (((URLImageView)paramMessage.contentView.findViewById(2131366032)).getTag() != paramMessage.recommendPkg) {
          return true;
        }
        if ((this.mShowedEffectList != null) && ((this.mShowedEffectList.size() >= 2) || (this.mShowedEffectList.indexOf(Integer.valueOf(paramMessage.index)) >= 0))) {
          return true;
        }
        localObject1 = paramMessage.effectFile.getAbsolutePath();
        try
        {
          localObject1 = new URL("vasapngdownloader", (String)localObject1, "local_recommendEffect");
          if (this.mLoadingDrawable == null)
          {
            localObject2 = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
            this.mLoadingDrawable = new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject2);
          }
          localObject2 = (URLImageView)paramMessage.contentView.findViewById(2131366031);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mUseApngImage = true;
          i = (int)(85.0F * this.density);
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mRequestWidth = i;
          localURLDrawableOptions.mLoadingDrawable = this.mLoadingDrawable;
          localURLDrawableOptions.mFailedDrawable = this.mLoadingDrawable;
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_loop", 1);
          localBundle.putBoolean("key_once_clear", true);
          localBundle.putLong("bundle_key_bid", 1003L);
          localBundle.putString("bundle_key_scid", "emotionRecommendEffect");
          localURLDrawableOptions.mExtraInfo = localBundle;
          localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
          ((URLImageView)localObject2).setVisibility(0);
          ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
          if (this.mShowedEffectList == null) {
            this.mShowedEffectList = new ArrayList();
          }
          this.mShowedEffectList.add(Integer.valueOf(paramMessage.index));
          if (this.mNeedShowRedEffect)
          {
            this.mNeedShowRedEffect = false;
            this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", false).commit();
          }
        }
        catch (Exception paramMessage)
        {
          QLog.e("RecommendEmotionAdapter", 1, "MSG_SHOW_RECOMMEND_EFFECT err:" + paramMessage.toString());
        }
      }
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new RecommendEmotionAdapter.RecommendEmotionViewHolder();
  }
  
  public void onAdapterSelected()
  {
    Object localObject;
    if (this.businessType == 0)
    {
      sendSSORequest();
      if (this.invisiableExposeList.size() <= 0) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected invisiableExposeList size > 0");
      }
      localObject = this.invisiableExposeList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bgcz localbgcz = (bgcz)((Iterator)localObject).next();
        if (!this.visiableExposeList.contains(localbgcz))
        {
          this.visiableExposeList.add(localbgcz);
          if (this.emp != null) {
            this.emp.a(localbgcz);
          }
        }
      }
      this.invisiableExposeList.clear();
    }
    label387:
    label390:
    for (;;)
    {
      return;
      label126:
      localObject = getCurrentListView();
      if (localObject != null)
      {
        int i = ((ListView)localObject).getFirstVisiblePosition();
        int j = ((ListView)localObject).getLastVisiblePosition();
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstShowPosition = " + i + ";lastShowPosition = " + j);
        }
        if (this.data != null)
        {
          this.visiableExposeList.clear();
          i = this.columnNum * i;
          int m = this.columnNum * (j + 1) - 1;
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstDataPosition = " + i + ";lastDataPosition = " + m);
          }
          if (i <= m)
          {
            j = 1;
            label277:
            if (i >= this.data.size()) {
              break label387;
            }
          }
          for (int k = 1;; k = 0)
          {
            if ((j & k) == 0) {
              break label390;
            }
            localObject = (EmotionPanelData)this.data.get(i);
            if ((localObject != null) && ((localObject instanceof bgcz)))
            {
              localObject = (bgcz)localObject;
              if (this.emp != null) {
                this.emp.a((bgcz)localObject);
              }
              if (!this.visiableExposeList.contains(localObject)) {
                this.visiableExposeList.add(localObject);
              }
            }
            i += 1;
            break;
            j = 0;
            break label277;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    bgcz localbgcz = getRecommendPkgByView(paramView);
    if (localbgcz == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ImageView localImageView = getRedPointViewByEp(localbgcz);
      if ((paramView instanceof URLImageView))
      {
        int i = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int j = this.data.indexOf(localbgcz);
        String str2 = this.app.getCurrentUin();
        String str3 = localbgcz.a;
        String str4 = j + 1 + "";
        if (this.isRedWhenClickRecommend) {}
        for (String str1 = "1";; str1 = "")
        {
          VasWebviewUtil.reportCommercialDrainage(str2, "ep_mall", "0X80065DD", "", 0, 0, 0, "", str3, str4, str1, "", i + "", "", 0, 0, 0, 0);
          bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, localbgcz.a, "", "", localbgcz.r + "");
          openEmoticonDetailPage(localbgcz, this.businessType);
          if ((localImageView == null) || (localImageView.getVisibility() != 0)) {
            break;
          }
          localImageView.setVisibility(8);
          localbgcz.r = 0;
          this.emp.i(localbgcz.a, this.businessType);
          break;
        }
      }
      if ((paramView instanceof ProgressButton))
      {
        bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, localbgcz.a, "", "", localbgcz.r + "");
        downloadOrPay((ProgressButton)paramView, localbgcz, false, this.businessType);
        if ((localImageView != null) && (localImageView.getVisibility() == 0))
        {
          localImageView.setVisibility(8);
          localbgcz.r = 0;
          this.emp.i(localbgcz.a, this.businessType);
        }
      }
    }
  }
  
  public void packageDownloadEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt != 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void payBack(int paramInt)
  {
    if (paramInt == 17)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "paback");
      }
      if (this.clickPayBtn == null) {
        QLog.e("RecommendEmotionAdapter", 1, "payBack view is null");
      }
    }
    else
    {
      return;
    }
    bgcz localbgcz = getRecommendPkgByView(this.clickPayBtn);
    if (localbgcz == null)
    {
      QLog.e("RecommendEmotionAdapter", 1, "payBack pkg is null");
      return;
    }
    bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, localbgcz.a, "", "", "0");
    downloadOrPay(this.clickPayBtn, localbgcz, true, this.businessType);
  }
  
  public void refreashProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void refreshPanelData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "refreshPanelData");
    }
    new QueryTask(new RecommendEmotionAdapter.3(this), new RecommendEmotionAdapter.4(this)).a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */