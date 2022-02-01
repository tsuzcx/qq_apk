package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
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
  protected List<ProgressButton> btns;
  private int businessType;
  CallBacker callBacker = new RecommendEmotionAdapter.5(this);
  protected ProgressButton clickPayBtn;
  protected int contentWidth;
  private List<PromotionEmoticonPkg> invisiableExposeList;
  boolean isRedWhenClickRecommend;
  boolean kandianBiu = false;
  public AtomicBoolean mDownloadEffect = new AtomicBoolean(false);
  public Object mEffectLock = new Object();
  private Drawable mLoadingDrawable;
  private boolean mNeedShowRedEffect;
  public ArrayList<Integer> mShowedEffectList;
  private final int mTotalEffectNum = 2;
  public MqqHandler mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  public ArrayList<RecommendEmotionAdapter.RecommendEffectHolder> mWaitToShowList;
  protected List<ImageView> reds;
  private List<PromotionEmoticonPkg> visiableExposeList;
  
  public RecommendEmotionAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, int paramInt4, boolean paramBoolean)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.businessType = paramInt4;
    this.btns = new ArrayList();
    this.reds = new ArrayList();
    this.invisiableExposeList = new ArrayList();
    this.visiableExposeList = new ArrayList();
    paramIEmoticonMainPanelApp = paramIEmoticonMainPanelApp.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    this.mNeedShowRedEffect = paramIEmoticonMainPanelApp.getBoolean("recommemd_red_effect", false);
    this.isRedWhenClickRecommend = paramIEmoticonMainPanelApp.getBoolean("is_red_when_click_recommend", false);
    this.kandianBiu = paramBoolean;
  }
  
  private LinearLayout getEmotionLayout()
  {
    int i = -2;
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    Object localObject1 = new LinearLayout.LayoutParams(this.contentWidth, (int)(148.0F * this.density));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(85.0F * this.density), (int)(85.0F * this.density));
    localLayoutParams.gravity = 1;
    ((RelativeLayout)localObject1).setId(2131375251);
    Object localObject2 = new URLImageView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131374862);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localObject2 = new URLImageView(this.mContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131374861);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    localObject2 = new ImageView(this.mContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject2).setId(2131375252);
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(11, -1);
    ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130850830));
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new TextView(this.mContext);
    ((TextView)localObject1).setId(2131374863);
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
    ((ProgressButton)localObject1).setId(2131374860);
    if (this.app.getQQAppInterface() != null) {}
    for (;;)
    {
      localLayoutParams = new LinearLayout.LayoutParams(i, (int)(25.0F * this.density));
      localLayoutParams.topMargin = ((int)(this.density * 10.0F));
      localLayoutParams.gravity = 1;
      ((ProgressButton)localObject1).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846563));
      ((ProgressButton)localObject1).setTextColor(-14894864);
      ((ProgressButton)localObject1).setPadding((int)(this.density * 15.0F), 0, (int)(this.density * 15.0F), 0);
      ((ProgressButton)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((ProgressButton)localObject1).setTextSize(13.0F);
      ((ProgressButton)localObject1).setGravity(17);
      localLinearLayout.addView((View)localObject1, localLayoutParams);
      return localLinearLayout;
      i = (int)(60.0F * this.density);
    }
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
      PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkgByView(localProgressButton);
      if ((localPromotionEmoticonPkg != null) && (paramEmoticonPackage.epId.equals(localPromotionEmoticonPkg.id))) {
        return localProgressButton;
      }
    }
    return null;
  }
  
  private PromotionEmoticonPkg getRecommendPkgByView(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      paramView = paramView.getTag();
    } while (paramView == null);
    if ((paramView instanceof PromotionEmoticonPkg)) {}
    for (paramView = (PromotionEmoticonPkg)paramView;; paramView = null) {
      return paramView;
    }
  }
  
  private ImageView getRedPointViewByEp(PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if ((this.reds == null) || (this.reds.size() < 1) || (paramPromotionEmoticonPkg == null) || (TextUtils.isEmpty(paramPromotionEmoticonPkg.id)))
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
      PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkgByView(localImageView);
      if ((localPromotionEmoticonPkg != null) && (paramPromotionEmoticonPkg.id.equals(localPromotionEmoticonPkg.id))) {
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
  
  private boolean isPkgDownloading(PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    return ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getEmoticonPackageLoadingProgress(this.app, paramPromotionEmoticonPkg.id) >= 0.0F;
  }
  
  private void openEmoticonDetailPage(PromotionEmoticonPkg paramPromotionEmoticonPkg, int paramInt)
  {
    ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).openEmoticonDetailPage(this.mContext, this.app, paramPromotionEmoticonPkg, paramInt);
  }
  
  private void sendSSORequest()
  {
    Object localObject = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    ((SharedPreferences)localObject).edit().putBoolean("isClickRecommendRedpoint", true).commit();
    int i = ((SharedPreferences)localObject).getInt("recommendRuleId", -1);
    IBigEmotionService localIBigEmotionService = (IBigEmotionService)QRoute.api(IBigEmotionService.class);
    String str = this.app.getCurrentUin();
    if (this.isRedWhenClickRecommend) {}
    for (localObject = "1";; localObject = "")
    {
      localIBigEmotionService.reportCommercialDrainage(str, "ep_mall", "PageView", "", 0, 0, 0, "", "", "", (String)localObject, "", i + "", "", 0, 0, 0, 0);
      ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).sendRecommendSSORequest(this.app, this.businessType);
      return;
    }
  }
  
  private void updateUI(View paramView, PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if ((paramView == null) || (paramPromotionEmoticonPkg == null)) {
      return;
    }
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (isCurrentPanel()) {
      if (!this.visiableExposeList.contains(paramPromotionEmoticonPkg))
      {
        ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).recordRecommendEpExpose(this.app, paramPromotionEmoticonPkg);
        i = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int j = this.data.indexOf(paramPromotionEmoticonPkg);
        localObject2 = (IBigEmotionService)QRoute.api(IBigEmotionService.class);
        localObject3 = this.app.getCurrentUin();
        String str1 = paramPromotionEmoticonPkg.id;
        String str2 = j + 1 + "";
        if (!this.isRedWhenClickRecommend) {
          break label820;
        }
        localObject1 = "1";
        label151:
        ((IBigEmotionService)localObject2).reportCommercialDrainage((String)localObject3, "ep_mall", "aioshow", "", 0, 0, 0, "", str1, str2, (String)localObject1, "", i + "", "", 0, 0, 0, 0);
        this.visiableExposeList.add(paramPromotionEmoticonPkg);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "updateUI epid = " + paramPromotionEmoticonPkg.id + "expose num = " + paramPromotionEmoticonPkg.exposureNum);
      }
      paramView.setVisibility(0);
      if (paramPromotionEmoticonPkg == paramView.getTag(2131381651)) {
        break;
      }
      paramView.setTag(2131381651, paramPromotionEmoticonPkg);
      try
      {
        localObject1 = (URLImageView)paramView.findViewById(2131374862);
        localObject2 = this.mContext.getResources().getDrawable(2130846569);
        localObject3 = this.mContext.getResources().getDrawable(2130846570);
        ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramPromotionEmoticonPkg.imgUrl, (Drawable)localObject2, (Drawable)localObject3));
        ((URLImageView)localObject1).setTag(paramPromotionEmoticonPkg);
        ((URLImageView)localObject1).setOnClickListener(this);
        localObject2 = (TextView)paramView.findViewById(2131374863);
        ((TextView)localObject2).setText(paramPromotionEmoticonPkg.pkgDesc);
        ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131167117));
        ((URLImageView)localObject1).setContentDescription(paramPromotionEmoticonPkg.pkgDesc);
        localObject1 = (ProgressButton)paramView.findViewById(2131374860);
        ((ProgressButton)localObject1).setText(paramPromotionEmoticonPkg.btnDesc);
        ((ProgressButton)localObject1).setTag(paramPromotionEmoticonPkg);
        ((ProgressButton)localObject1).setContentDescription(paramPromotionEmoticonPkg.btnDesc);
        ((ProgressButton)localObject1).setOnClickListener(this);
        ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
        if ((this.btns != null) && (!this.btns.contains(localObject1))) {
          this.btns.add(localObject1);
        }
        localObject2 = (URLImageView)paramView.findViewById(2131374861);
        ((URLImageView)localObject2).setImageDrawable(null);
        ((URLImageView)localObject2).setVisibility(8);
        localObject2 = (ImageView)paramView.findViewById(2131375252);
        ((ImageView)localObject2).setVisibility(8);
        ((ImageView)localObject2).setTag(paramPromotionEmoticonPkg);
        if (paramPromotionEmoticonPkg.redpointFlag == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect mNeedShowRedEffect:" + this.mNeedShowRedEffect + ", id:" + paramPromotionEmoticonPkg.id);
          }
          i = this.data.indexOf(paramPromotionEmoticonPkg);
          if ((this.mNeedShowRedEffect) && (i < 2) && ((this.mShowedEffectList == null) || ((this.mShowedEffectList.size() < 2) && (this.mShowedEffectList.indexOf(Integer.valueOf(i)) < 0))))
          {
            localObject3 = new RecommendEmotionAdapter.RecommendEffectHolder(this);
            ((RecommendEmotionAdapter.RecommendEffectHolder)localObject3).contentView = paramView;
            ((RecommendEmotionAdapter.RecommendEffectHolder)localObject3).recommendPkg = paramPromotionEmoticonPkg;
            ((RecommendEmotionAdapter.RecommendEffectHolder)localObject3).index = i;
            ThreadManager.post(new RecommendEmotionAdapter.1(this, (RecommendEmotionAdapter.RecommendEffectHolder)localObject3), 8, null, true);
          }
        }
        if ((this.reds != null) && (!this.reds.contains(localObject2))) {
          this.reds.add(localObject2);
        }
        float f = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getEmoticonPackageLoadingProgress(this.app, paramPromotionEmoticonPkg.id);
        if (f < 0.0F) {
          break label855;
        }
        ((ProgressButton)localObject1).setProgress((int)f);
        ((ProgressButton)localObject1).setText(this.mContext.getString(2131699611));
        return;
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("RecommendEmotionAdapter", 1, "updateUI oom e = " + paramView);
        return;
      }
      label820:
      localObject1 = "";
      break label151;
      if (!this.invisiableExposeList.contains(paramPromotionEmoticonPkg)) {
        this.invisiableExposeList.add(paramPromotionEmoticonPkg);
      }
    }
    label855:
    ((ProgressButton)localObject1).setText(paramPromotionEmoticonPkg.btnDesc);
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
    ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).removeCallBacker(this.app, this.callBacker);
    if (this.mShowedEffectList != null)
    {
      this.mShowedEffectList.clear();
      this.mShowedEffectList = null;
    }
    if (this.mLoadingDrawable != null) {
      this.mLoadingDrawable = null;
    }
  }
  
  public void downloadOrPay(ProgressButton paramProgressButton, PromotionEmoticonPkg paramPromotionEmoticonPkg, boolean paramBoolean, int paramInt)
  {
    if ((paramProgressButton == null) || (paramPromotionEmoticonPkg == null) || (this.app == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "downloadOrPay epid = " + paramPromotionEmoticonPkg.id);
    }
    if ((paramPromotionEmoticonPkg.feeType == 2) || (paramPromotionEmoticonPkg.feeType == 6))
    {
      openEmoticonDetailPage(paramPromotionEmoticonPkg, paramInt);
      ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, paramPromotionEmoticonPkg.id, "", "", paramPromotionEmoticonPkg.redpointFlag + "");
      paramInt = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
      int i = this.data.indexOf(paramPromotionEmoticonPkg);
      IBigEmotionService localIBigEmotionService = (IBigEmotionService)QRoute.api(IBigEmotionService.class);
      String str1 = this.app.getCurrentUin();
      paramPromotionEmoticonPkg = paramPromotionEmoticonPkg.id;
      String str2 = i + 1 + "";
      if (this.isRedWhenClickRecommend) {}
      for (paramProgressButton = "1";; paramProgressButton = "")
      {
        localIBigEmotionService.reportCommercialDrainage(str1, "ep_mall", "0X800613D", "", 0, 0, 0, "", paramPromotionEmoticonPkg, str2, paramProgressButton, "", paramInt + "", "", 0, 0, 0, 0);
        return;
      }
    }
    ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).asyncFindEmoticonPackage(this.app, paramPromotionEmoticonPkg.type, paramPromotionEmoticonPkg.feeType, paramPromotionEmoticonPkg.id, -1, new RecommendEmotionAdapter.2(this, paramPromotionEmoticonPkg, paramBoolean, paramProgressButton, paramInt));
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
      if ((paramView instanceof PromotionEmoticonPkg)) {}
      for (paramView = (PromotionEmoticonPkg)paramView;; paramView = null)
      {
        updateUI((View)localObject, paramView);
        if (paramView == null) {
          break;
        }
        ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, paramView.id, paramInt + "", "", paramView.redpointFlag + "");
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
      int i = (int)((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getStatusPercent(this.app, paramMessage.epId);
      if (i < 0) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "handleMessage refreashProgress epid = " + paramMessage.epId + ";progress = " + i);
      }
      if (i == 100) {
        ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, paramMessage.epId, "", "", "");
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
      paramMessage.setText(((PromotionEmoticonPkg)localObject1).btnDesc);
      refreshPanelData();
      ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005816", 0, 1, ((PromotionEmoticonPkg)localObject1).id, "", "", "");
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
        if (((URLImageView)paramMessage.contentView.findViewById(2131374862)).getTag() != paramMessage.recommendPkg) {
          return true;
        }
        if ((this.mShowedEffectList != null) && ((this.mShowedEffectList.size() >= 2) || (this.mShowedEffectList.indexOf(Integer.valueOf(paramMessage.index)) >= 0))) {
          return true;
        }
        localObject1 = paramMessage.effectFile.getAbsolutePath();
        try
        {
          if (this.mLoadingDrawable == null)
          {
            localObject2 = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
            this.mLoadingDrawable = new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject2);
          }
          Object localObject2 = (URLImageView)paramMessage.contentView.findViewById(2131374861);
          localObject1 = ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).getApngDrawable(this.mLoadingDrawable, (String)localObject1, (int)(85.0F * this.density));
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
    if (((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).isAIOBusiness(this.businessType))
    {
      sendSSORequest();
      if (this.invisiableExposeList.size() <= 0) {
        break label144;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected invisiableExposeList size > 0");
      }
      localObject = this.invisiableExposeList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PromotionEmoticonPkg localPromotionEmoticonPkg = (PromotionEmoticonPkg)((Iterator)localObject).next();
        if (!this.visiableExposeList.contains(localPromotionEmoticonPkg))
        {
          this.visiableExposeList.add(localPromotionEmoticonPkg);
          ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).recordRecommendEpExpose(this.app, localPromotionEmoticonPkg);
        }
      }
      this.invisiableExposeList.clear();
    }
    label144:
    label409:
    label412:
    for (;;)
    {
      return;
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
            label295:
            if (i >= this.data.size()) {
              break label409;
            }
          }
          for (int k = 1;; k = 0)
          {
            if ((j & k) == 0) {
              break label412;
            }
            localObject = (EmotionPanelData)this.data.get(i);
            if ((localObject != null) && ((localObject instanceof PromotionEmoticonPkg)))
            {
              localObject = (PromotionEmoticonPkg)localObject;
              ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).recordRecommendEpExpose(this.app, localObject);
              if (!this.visiableExposeList.contains(localObject)) {
                this.visiableExposeList.add(localObject);
              }
            }
            i += 1;
            break;
            j = 0;
            break label295;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkgByView(paramView);
    if (localPromotionEmoticonPkg == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ImageView localImageView = getRedPointViewByEp(localPromotionEmoticonPkg);
      if ((paramView instanceof URLImageView))
      {
        int i = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int j = this.data.indexOf(localPromotionEmoticonPkg);
        IBigEmotionService localIBigEmotionService = (IBigEmotionService)QRoute.api(IBigEmotionService.class);
        String str2 = this.app.getCurrentUin();
        String str3 = localPromotionEmoticonPkg.id;
        String str4 = j + 1 + "";
        if (this.isRedWhenClickRecommend) {}
        for (String str1 = "1";; str1 = "")
        {
          localIBigEmotionService.reportCommercialDrainage(str2, "ep_mall", "0X80065DD", "", 0, 0, 0, "", str3, str4, str1, "", i + "", "", 0, 0, 0, 0);
          ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, localPromotionEmoticonPkg.id, "", "", localPromotionEmoticonPkg.redpointFlag + "");
          openEmoticonDetailPage(localPromotionEmoticonPkg, this.businessType);
          if ((localImageView == null) || (localImageView.getVisibility() != 0)) {
            break;
          }
          localImageView.setVisibility(8);
          localPromotionEmoticonPkg.redpointFlag = 0;
          ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).setRecommendEpRedFlag(this.app, localPromotionEmoticonPkg.id, this.businessType);
          break;
        }
      }
      if ((paramView instanceof ProgressButton))
      {
        ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, localPromotionEmoticonPkg.id, "", "", localPromotionEmoticonPkg.redpointFlag + "");
        downloadOrPay((ProgressButton)paramView, localPromotionEmoticonPkg, false, this.businessType);
        if ((localImageView != null) && (localImageView.getVisibility() == 0))
        {
          localImageView.setVisibility(8);
          localPromotionEmoticonPkg.redpointFlag = 0;
          ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).setRecommendEpRedFlag(this.app, localPromotionEmoticonPkg.id, this.businessType);
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
    PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkgByView(this.clickPayBtn);
    if (localPromotionEmoticonPkg == null)
    {
      QLog.e("RecommendEmotionAdapter", 1, "payBack pkg is null");
      return;
    }
    ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, localPromotionEmoticonPkg.id, "", "", "0");
    downloadOrPay(this.clickPayBtn, localPromotionEmoticonPkg, true, this.businessType);
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
    new QueryTask(new RecommendEmotionAdapter.3(this), new RecommendEmotionAdapter.4(this)).execute(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */