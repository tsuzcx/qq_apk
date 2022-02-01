package com.tencent.mobileqq.emoticonview;

import android.content.Context;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VasQuickUpdateManagerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
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
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    Object localObject1 = new LinearLayout.LayoutParams(this.contentWidth, (int)(this.density * 148.0F));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.density * 85.0F), (int)(this.density * 85.0F));
    localLayoutParams.gravity = 1;
    ((RelativeLayout)localObject1).setId(2131442955);
    Object localObject2 = new URLImageView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131442562);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localObject2 = new URLImageView(this.mContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131442561);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    localObject2 = new ImageView(this.mContext);
    int i = -2;
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject2).setId(2131442956);
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(11, -1);
    ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130852588));
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new TextView(this.mContext);
    ((TextView)localObject1).setId(2131442563);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(this.density * 18.0F));
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ((int)(this.density * 10.0F));
    ((TextView)localObject1).setTextSize(15.0F);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setMaxLines(1);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new ProgressButton(this.mContext);
    ((ProgressButton)localObject1).setId(2131442560);
    if (this.app.getQQAppInterface() == null) {
      i = (int)(this.density * 60.0F);
    }
    localLayoutParams = new LinearLayout.LayoutParams(i, (int)(this.density * 25.0F));
    localLayoutParams.topMargin = ((int)(this.density * 10.0F));
    localLayoutParams.gravity = 1;
    ((ProgressButton)localObject1).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847913));
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
    Object localObject = this.btns;
    if ((localObject != null) && (((List)localObject).size() >= 1) && (paramEmoticonPackage != null) && (!TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      localObject = this.btns.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ProgressButton localProgressButton = (ProgressButton)((Iterator)localObject).next();
        PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkgByView(localProgressButton);
        if ((localPromotionEmoticonPkg != null) && (paramEmoticonPackage.epId.equals(localPromotionEmoticonPkg.id))) {
          return localProgressButton;
        }
      }
      return null;
    }
    QLog.e("RecommendEmotionAdapter", 1, "getProgressButton view or ep error");
    return null;
  }
  
  private PromotionEmoticonPkg getRecommendPkgByView(View paramView)
  {
    Object localObject1 = null;
    if (paramView == null) {
      return null;
    }
    Object localObject2 = paramView.getTag();
    if (localObject2 == null) {
      return null;
    }
    paramView = localObject1;
    if ((localObject2 instanceof PromotionEmoticonPkg)) {
      paramView = (PromotionEmoticonPkg)localObject2;
    }
    return paramView;
  }
  
  private ImageView getRedPointViewByEp(PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    Object localObject = this.reds;
    if ((localObject != null) && (((List)localObject).size() >= 1) && (paramPromotionEmoticonPkg != null) && (!TextUtils.isEmpty(paramPromotionEmoticonPkg.id)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "getRedPointViewByEp");
      }
      localObject = this.reds.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ImageView localImageView = (ImageView)((Iterator)localObject).next();
        PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkgByView(localImageView);
        if ((localPromotionEmoticonPkg != null) && (paramPromotionEmoticonPkg.id.equals(localPromotionEmoticonPkg.id))) {
          return localImageView;
        }
      }
      return null;
    }
    QLog.e("RecommendEmotionAdapter", 1, "getRedPointViewByEp view or ep error");
    return null;
  }
  
  private boolean isCurrentPanel()
  {
    return EmotionPanelConstans.getPanelType(this.app, this.curPanelInfo) == this.panelType;
  }
  
  private boolean isPkgDownloading(PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    return ((EmojiManagerServiceProxy)this.app.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(paramPromotionEmoticonPkg.id) >= 0.0F;
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
    String str = this.app.getCurrentUin();
    if (this.isRedWhenClickRecommend) {
      localObject = "1";
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    VasWebviewUtil.a(str, "ep_mall", "PageView", "", 0, 0, 0, "", "", "", (String)localObject, "", localStringBuilder.toString(), "", 0, 0, 0, 0);
    EmotionUtils.a(this.app, this.businessType);
  }
  
  private void updateUI(View paramView, PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if (paramView != null)
    {
      if (paramPromotionEmoticonPkg == null) {
        return;
      }
      int i;
      Object localObject2;
      Object localObject3;
      Object localObject1;
      if (isCurrentPanel())
      {
        if (!this.visiableExposeList.contains(paramPromotionEmoticonPkg))
        {
          ((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).recordRecommendEpExpose(paramPromotionEmoticonPkg);
          i = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
          int j = this.data.indexOf(paramPromotionEmoticonPkg);
          localObject2 = this.app.getCurrentUin();
          localObject3 = paramPromotionEmoticonPkg.id;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(j + 1);
          ((StringBuilder)localObject1).append("");
          String str = ((StringBuilder)localObject1).toString();
          if (this.isRedWhenClickRecommend) {
            localObject1 = "1";
          } else {
            localObject1 = "";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("");
          VasWebviewUtil.a((String)localObject2, "ep_mall", "aioshow", "", 0, 0, 0, "", (String)localObject3, str, (String)localObject1, "", localStringBuilder.toString(), "", 0, 0, 0, 0);
          this.visiableExposeList.add(paramPromotionEmoticonPkg);
        }
      }
      else if (!this.invisiableExposeList.contains(paramPromotionEmoticonPkg)) {
        this.invisiableExposeList.add(paramPromotionEmoticonPkg);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateUI epid = ");
        ((StringBuilder)localObject1).append(paramPromotionEmoticonPkg.id);
        ((StringBuilder)localObject1).append("expose num = ");
        ((StringBuilder)localObject1).append(paramPromotionEmoticonPkg.exposureNum);
        QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject1).toString());
      }
      paramView.setVisibility(0);
      if (paramPromotionEmoticonPkg == paramView.getTag(2131449867)) {
        return;
      }
      paramView.setTag(2131449867, paramPromotionEmoticonPkg);
      try
      {
        localObject1 = (URLImageView)paramView.findViewById(2131442562);
        localObject2 = this.mContext.getResources().getDrawable(2130847921);
        localObject3 = this.mContext.getResources().getDrawable(2130847922);
        ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramPromotionEmoticonPkg.imgUrl, (Drawable)localObject2, (Drawable)localObject3));
        ((URLImageView)localObject1).setTag(paramPromotionEmoticonPkg);
        ((URLImageView)localObject1).setOnClickListener(this);
        localObject2 = (TextView)paramView.findViewById(2131442563);
        ((TextView)localObject2).setText(paramPromotionEmoticonPkg.pkgDesc);
        ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131168122));
        ((URLImageView)localObject1).setContentDescription(paramPromotionEmoticonPkg.pkgDesc);
        localObject1 = (ProgressButton)paramView.findViewById(2131442560);
        ((ProgressButton)localObject1).setText(paramPromotionEmoticonPkg.btnDesc);
        ((ProgressButton)localObject1).setTag(paramPromotionEmoticonPkg);
        ((ProgressButton)localObject1).setContentDescription(paramPromotionEmoticonPkg.btnDesc);
        ((ProgressButton)localObject1).setOnClickListener(this);
        ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
        if ((this.btns != null) && (!this.btns.contains(localObject1))) {
          this.btns.add(localObject1);
        }
        localObject2 = (URLImageView)paramView.findViewById(2131442561);
        ((URLImageView)localObject2).setImageDrawable(null);
        ((URLImageView)localObject2).setVisibility(8);
        localObject2 = (ImageView)paramView.findViewById(2131442956);
        ((ImageView)localObject2).setVisibility(8);
        ((ImageView)localObject2).setTag(paramPromotionEmoticonPkg);
        if (paramPromotionEmoticonPkg.redpointFlag == 1)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("emoticon Effect mNeedShowRedEffect:");
            ((StringBuilder)localObject3).append(this.mNeedShowRedEffect);
            ((StringBuilder)localObject3).append(", id:");
            ((StringBuilder)localObject3).append(paramPromotionEmoticonPkg.id);
            QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject3).toString());
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
        float f = ((EmojiManagerServiceProxy)this.app.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(paramPromotionEmoticonPkg.id);
        if (f >= 0.0F)
        {
          ((ProgressButton)localObject1).setProgress((int)f);
          ((ProgressButton)localObject1).setText(this.mContext.getString(2131897752));
          return;
        }
        ((ProgressButton)localObject1).setText(paramPromotionEmoticonPkg.btnDesc);
        ((ProgressButton)localObject1).setProgress(0);
        return;
      }
      catch (OutOfMemoryError paramView)
      {
        paramPromotionEmoticonPkg = new StringBuilder();
        paramPromotionEmoticonPkg.append("updateUI oom e = ");
        paramPromotionEmoticonPkg.append(paramView);
        QLog.e("RecommendEmotionAdapter", 1, paramPromotionEmoticonPkg.toString());
      }
    }
  }
  
  public void destory()
  {
    super.destory();
    Object localObject = this.btns;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.btns = null;
    }
    localObject = this.reds;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.reds = null;
    }
    if (this.app != null) {
      ((VasQuickUpdateManagerProxy)this.app.getRuntimeService(IVasQuickUpdateService.class)).removeCallBacker(this.callBacker);
    }
    localObject = this.mShowedEffectList;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.mShowedEffectList = null;
    }
    if (this.mLoadingDrawable != null) {
      this.mLoadingDrawable = null;
    }
  }
  
  public void downloadOrPay(ProgressButton paramProgressButton, PromotionEmoticonPkg paramPromotionEmoticonPkg, boolean paramBoolean, int paramInt)
  {
    if ((paramProgressButton != null) && (paramPromotionEmoticonPkg != null))
    {
      if (this.app == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downloadOrPay epid = ");
        ((StringBuilder)localObject1).append(paramPromotionEmoticonPkg.id);
        QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject1).toString());
      }
      if ((paramPromotionEmoticonPkg.feeType != 2) && (paramPromotionEmoticonPkg.feeType != 6))
      {
        localObject1 = paramPromotionEmoticonPkg.id;
        i = paramPromotionEmoticonPkg.type;
        int j = paramPromotionEmoticonPkg.feeType;
        ((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage((String)localObject1, -1, new RecommendEmotionAdapter.2(this, i, (String)localObject1, j, paramPromotionEmoticonPkg, paramBoolean, paramProgressButton, paramInt));
        return;
      }
      openEmoticonDetailPage(paramPromotionEmoticonPkg, paramInt);
      paramProgressButton = this.app.getQQAppInterface();
      Object localObject1 = paramPromotionEmoticonPkg.id;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramPromotionEmoticonPkg.redpointFlag);
      ((StringBuilder)localObject2).append("");
      ReportController.b(paramProgressButton, "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, (String)localObject1, "", "", ((StringBuilder)localObject2).toString());
      paramInt = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
      int i = this.data.indexOf(paramPromotionEmoticonPkg);
      localObject1 = this.app.getCurrentUin();
      paramPromotionEmoticonPkg = paramPromotionEmoticonPkg.id;
      paramProgressButton = new StringBuilder();
      paramProgressButton.append(i + 1);
      paramProgressButton.append("");
      localObject2 = paramProgressButton.toString();
      if (this.isRedWhenClickRecommend) {
        paramProgressButton = "1";
      } else {
        paramProgressButton = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      VasWebviewUtil.a((String)localObject1, "ep_mall", "0X800613D", "", 0, 0, 0, "", paramPromotionEmoticonPkg, (String)localObject2, paramProgressButton, "", localStringBuilder.toString(), "", 0, 0, 0, 0);
    }
  }
  
  public URLDrawable getApngDrawable(Drawable paramDrawable, String paramString, int paramInt)
  {
    try
    {
      paramString = new URL("vasapngdownloader", paramString, "local_recommendEffect");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mRequestHeight = paramInt;
      localURLDrawableOptions.mRequestWidth = paramInt;
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      paramDrawable = new Bundle();
      paramDrawable.putInt("key_loop", 1);
      paramDrawable.putBoolean("key_once_clear", true);
      paramDrawable.putLong("bundle_key_bid", 1003L);
      paramDrawable.putString("bundle_key_scid", "emotionRecommendEffect");
      localURLDrawableOptions.mExtraInfo = paramDrawable;
      paramDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      return paramDrawable;
    }
    catch (Exception paramDrawable)
    {
      paramString = new StringBuilder();
      paramString.append("getApngDrawable exception = ");
      paramString.append(paramDrawable.getMessage());
      QLog.d("RecommendEmotionServiceImpl", 2, paramString.toString());
    }
    return null;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.contentWidth = (this.widthPixels / this.columnNum);
    System.currentTimeMillis();
    paramViewGroup = (RecommendEmotionAdapter.RecommendEmotionViewHolder)paramViewHolder;
    j = 0;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append(";view from inflater");
          QLog.d("RecommendEmotionAdapter", 2, paramViewHolder.toString());
        }
        paramView = new LinearLayout(this.mContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        i = 0;
        for (;;)
        {
          paramViewHolder = paramView;
          if (i >= this.columnNum) {
            break;
          }
          try
          {
            paramViewHolder = getEmotionLayout();
            paramViewHolder.setVisibility(8);
            localObject1 = new LinearLayout.LayoutParams(this.contentWidth, -1);
            if (paramInt == 0) {
              ((LinearLayout.LayoutParams)localObject1).topMargin = ((int)(this.density * 22.0F));
            } else {
              ((LinearLayout.LayoutParams)localObject1).topMargin = ((int)(this.density * 20.0F));
            }
            paramView.addView(paramViewHolder, (ViewGroup.LayoutParams)localObject1);
          }
          catch (Exception paramViewHolder)
          {
            Object localObject1;
            paramView = new StringBuilder();
            paramView.append("getEmotionView ; position = ");
            paramView.append(paramInt);
            paramView.append("; has exception ,e = ");
            paramView.append(paramViewHolder.getMessage());
            QLog.e("RecommendEmotionAdapter", 1, paramView.toString());
            return null;
            paramViewHolder = paramView;
            if (!QLog.isColorLevel()) {
              break;
            }
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";view from cache");
            QLog.d("RecommendEmotionAdapter", 2, paramViewHolder.toString());
            paramViewHolder = paramView;
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
            i = j;
            break label408;
            paramViewHolder = paramView;
            i = j;
            while (i < this.columnNum)
            {
              j = this.columnNum * paramInt + i;
              if (j > this.data.size() - 1)
              {
                paramViewGroup.contentViews[i].setTag(null);
                paramViewGroup.contentViews[i].setVisibility(8);
              }
              else
              {
                localObject1 = paramViewGroup.contentViews[i];
                paramView = (EmotionPanelData)this.data.get(j);
                if ((paramView instanceof PromotionEmoticonPkg)) {
                  paramView = (PromotionEmoticonPkg)paramView;
                } else {
                  paramView = null;
                }
                updateUI((View)localObject1, paramView);
                if (paramView != null)
                {
                  localObject1 = this.app.getQQAppInterface();
                  String str = paramView.id;
                  Object localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(paramInt);
                  ((StringBuilder)localObject2).append("");
                  localObject2 = ((StringBuilder)localObject2).toString();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(paramView.redpointFlag);
                  localStringBuilder.append("");
                  ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, str, (String)localObject2, "", localStringBuilder.toString());
                }
              }
              i += 1;
            }
            return paramViewHolder;
          }
          catch (OutOfMemoryError paramViewHolder)
          {
            label205:
            break label205;
          }
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView oom");
          i += 1;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 102: 
      if ((paramMessage.obj instanceof RecommendEmotionAdapter.RecommendEffectHolder))
      {
        paramMessage = (RecommendEmotionAdapter.RecommendEffectHolder)paramMessage.obj;
        if (paramMessage != null)
        {
          if (paramMessage.isShow) {
            return true;
          }
          paramMessage.isShow = true;
          if ((paramMessage.contentView != null) && (paramMessage.recommendPkg != null) && (paramMessage.effectFile != null))
          {
            if (paramMessage.contentView.getVisibility() != 0) {
              return true;
            }
            if (((URLImageView)paramMessage.contentView.findViewById(2131442562)).getTag() != paramMessage.recommendPkg) {
              return true;
            }
            localObject1 = this.mShowedEffectList;
            if ((localObject1 != null) && ((((ArrayList)localObject1).size() >= 2) || (this.mShowedEffectList.indexOf(Integer.valueOf(paramMessage.index)) >= 0))) {
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
              localObject2 = (URLImageView)paramMessage.contentView.findViewById(2131442561);
              localObject1 = getApngDrawable(this.mLoadingDrawable, (String)localObject1, (int)(this.density * 85.0F));
              ((URLImageView)localObject2).setVisibility(0);
              ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
              if (this.mShowedEffectList == null) {
                this.mShowedEffectList = new ArrayList();
              }
              this.mShowedEffectList.add(Integer.valueOf(paramMessage.index));
              if (!this.mNeedShowRedEffect) {
                break;
              }
              this.mNeedShowRedEffect = false;
              this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", false).commit();
              return true;
            }
            catch (Exception paramMessage)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("MSG_SHOW_RECOMMEND_EFFECT err:");
              ((StringBuilder)localObject1).append(paramMessage.toString());
              QLog.e("RecommendEmotionAdapter", 1, ((StringBuilder)localObject1).toString());
              return true;
            }
          }
        }
        return true;
      }
      break;
    case 101: 
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
      return true;
    case 100: 
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      localObject1 = getProgressButton(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      int i = (int)((EmojiManagerServiceProxy)this.app.getRuntimeService(IEmojiManagerService.class)).getStatusPercent(paramMessage.epId);
      if (i < 0) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleMessage refreashProgress epid = ");
        ((StringBuilder)localObject2).append(paramMessage.epId);
        ((StringBuilder)localObject2).append(";progress = ");
        ((StringBuilder)localObject2).append(i);
        QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      if (i == 100) {
        ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, paramMessage.epId, "", "", "");
      }
      ((ProgressButton)localObject1).setProgress(i);
      ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
    }
    return true;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new RecommendEmotionAdapter.RecommendEmotionViewHolder();
  }
  
  public void onAdapterSelected()
  {
    if (this.businessType == 0)
    {
      sendSSORequest();
      if (this.invisiableExposeList.size() > 0)
      {
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
            ((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).recordRecommendEpExpose(localPromotionEmoticonPkg);
          }
        }
        this.invisiableExposeList.clear();
        return;
      }
      Object localObject = getCurrentListView();
      if (localObject != null)
      {
        int j = ((ListView)localObject).getFirstVisiblePosition();
        int i = ((ListView)localObject).getLastVisiblePosition();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onAdapterSelected firstShowPosition = ");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(";lastShowPosition = ");
          ((StringBuilder)localObject).append(i);
          QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject).toString());
        }
        if (this.data != null)
        {
          this.visiableExposeList.clear();
          j = this.columnNum * j;
          int m = this.columnNum * (i + 1) - 1;
          i = j;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onAdapterSelected firstDataPosition = ");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(";lastDataPosition = ");
            ((StringBuilder)localObject).append(m);
            QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject).toString());
            i = j;
          }
          for (;;)
          {
            int k = 0;
            if (i <= m) {
              j = 1;
            } else {
              j = 0;
            }
            if (i < this.data.size()) {
              k = 1;
            }
            if ((k & j) == 0) {
              break;
            }
            localObject = (EmotionPanelData)this.data.get(i);
            if ((localObject != null) && ((localObject instanceof PromotionEmoticonPkg)))
            {
              localObject = (PromotionEmoticonPkg)localObject;
              ((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).recordRecommendEpExpose((PromotionEmoticonPkg)localObject);
              if (!this.visiableExposeList.contains(localObject)) {
                this.visiableExposeList.add(localObject);
              }
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkgByView(paramView);
    if (localPromotionEmoticonPkg != null)
    {
      ImageView localImageView = getRedPointViewByEp(localPromotionEmoticonPkg);
      String str1;
      Object localObject2;
      Object localObject1;
      if ((paramView instanceof URLImageView))
      {
        int i = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int j = this.data.indexOf(localPromotionEmoticonPkg);
        str1 = this.app.getCurrentUin();
        localObject2 = localPromotionEmoticonPkg.id;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(j + 1);
        ((StringBuilder)localObject1).append("");
        String str2 = ((StringBuilder)localObject1).toString();
        if (this.isRedWhenClickRecommend) {
          localObject1 = "1";
        } else {
          localObject1 = "";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        VasWebviewUtil.a(str1, "ep_mall", "0X80065DD", "", 0, 0, 0, "", (String)localObject2, str2, (String)localObject1, "", localStringBuilder.toString(), "", 0, 0, 0, 0);
        localObject1 = this.app.getQQAppInterface();
        str1 = localPromotionEmoticonPkg.id;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localPromotionEmoticonPkg.redpointFlag);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, str1, "", "", ((StringBuilder)localObject2).toString());
        openEmoticonDetailPage(localPromotionEmoticonPkg, this.businessType);
        if ((localImageView != null) && (localImageView.getVisibility() == 0))
        {
          localImageView.setVisibility(8);
          localPromotionEmoticonPkg.redpointFlag = 0;
          ((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).setRecommendEpRedFlag(localPromotionEmoticonPkg.id, this.businessType);
        }
      }
      else if ((paramView instanceof ProgressButton))
      {
        localObject1 = this.app.getQQAppInterface();
        str1 = localPromotionEmoticonPkg.id;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localPromotionEmoticonPkg.redpointFlag);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, str1, "", "", ((StringBuilder)localObject2).toString());
        downloadOrPay((ProgressButton)paramView, localPromotionEmoticonPkg, false, this.businessType);
        if ((localImageView != null) && (localImageView.getVisibility() == 0))
        {
          localImageView.setVisibility(8);
          localPromotionEmoticonPkg.redpointFlag = 0;
          ((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).setRecommendEpRedFlag(localPromotionEmoticonPkg.id, this.businessType);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void packageDownloadEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramInt == 0)
    {
      if (paramEmoticonPackage == null) {
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 101;
      localMessage.obj = paramEmoticonPackage;
      this.mUiHandler.sendMessage(localMessage);
    }
  }
  
  public void payBack(int paramInt)
  {
    if (paramInt == 17)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "paback");
      }
      Object localObject = this.clickPayBtn;
      if (localObject == null)
      {
        QLog.e("RecommendEmotionAdapter", 1, "payBack view is null");
        return;
      }
      localObject = getRecommendPkgByView((View)localObject);
      if (localObject == null)
      {
        QLog.e("RecommendEmotionAdapter", 1, "payBack pkg is null");
        return;
      }
      ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, ((PromotionEmoticonPkg)localObject).id, "", "", "0");
      downloadOrPay(this.clickPayBtn, (PromotionEmoticonPkg)localObject, true, this.businessType);
    }
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