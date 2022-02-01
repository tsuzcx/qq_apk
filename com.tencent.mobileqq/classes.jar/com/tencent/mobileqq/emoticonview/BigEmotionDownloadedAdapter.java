package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import mqq.app.MobileQQ;

public class BigEmotionDownloadedAdapter
  extends AbsBigEmotionUpdateAdapter
{
  private static final int COMIC_TYPE_ANIMATION = 100;
  private static final int COMIC_TYPE_COMIC = 1;
  public static final String TAG = "BigEmotionDownloadedAdapter";
  public static final int TYPE_BTN = 1;
  public static final int TYPE_DATA = 0;
  private int businessType;
  public Drawable defaultCommercialDrawable = null;
  public EmoticonPackage emotionPkg;
  public ColorDrawable mDefaultDrawable = null;
  public URLDrawable.URLDrawableListener mURLDrawableListener = new BigEmotionDownloadedAdapter.8(this);
  
  public BigEmotionDownloadedAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.emotionPkg = paramEmoticonPackage;
    this.businessType = paramInt4;
    ThreadManager.post(new BigEmotionDownloadedAdapter.1(this), 8, null, true);
  }
  
  private View getRichIPSiteView(VipIPSiteInfo paramVipIPSiteInfo)
  {
    if (paramVipIPSiteInfo != null)
    {
      if (this.mDefaultDrawable == null) {
        this.mDefaultDrawable = new ColorDrawable(-1513240);
      }
      int i;
      String str3;
      Object localObject5;
      Object localObject4;
      Object localObject3;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      String str2;
      try
      {
        i = NetworkUtil.a(this.mContext);
        String str1 = "";
        switch (i)
        {
        default: 
          str3 = "";
        }
        try
        {
          i = paramVipIPSiteInfo.ipID;
          str3 = String.valueOf(i);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject1;
            RelativeLayout localRelativeLayout;
            ImageView localImageView;
            QLog.e("BigEmotionDownloadedAdapter", 1, "fillIPSiteViewPagerMode ipId error = " + localException2);
            continue;
            ((TextView)localObject10).setText(MobileQQ.getContext().getString(2131699613));
            localImageView.setVisibility(8);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(EmotionUtils.a(75.0F, this.mContext.getResources()), EmotionUtils.a(75.0F, this.mContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = EmotionUtils.a(75.0F, this.mContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = EmotionUtils.a(75.0F, this.mContext.getResources());
            ((TextView)localObject7).setMaxWidth(EmotionUtils.a(126.0F, this.mContext.getResources()));
            ((TextView)localObject8).setMaxWidth(EmotionUtils.a(126.0F, this.mContext.getResources()));
            continue;
            ((TextView)localObject10).setText(MobileQQ.getContext().getString(2131699601));
            localImageView.setVisibility(0);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(EmotionUtils.a(140.0F, this.mContext.getResources()), EmotionUtils.a(75.0F, this.mContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = EmotionUtils.a(140.0F, this.mContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = EmotionUtils.a(75.0F, this.mContext.getResources());
            ((TextView)localObject7).setMaxWidth(EmotionUtils.a(90.0F, this.mContext.getResources()));
            ((TextView)localObject8).setMaxWidth(EmotionUtils.a(90.0F, this.mContext.getResources()));
          }
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_comicshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject4;
        }
        localObject5 = new BigEmotionDownloadedAdapter.3(this, paramVipIPSiteInfo, str1, str3);
        localObject1 = paramVipIPSiteInfo.strType;
        if ("comic".equals(localObject1))
        {
          localObject4 = LayoutInflater.from(this.mContext).inflate(2131561746, null, false);
          localObject1 = (TextView)((View)localObject4).findViewById(2131362449);
          localObject3 = (TextView)((View)localObject4).findViewById(2131362430);
          ((RelativeLayout)((View)localObject4).findViewById(2131362445)).setOnClickListener((View.OnClickListener)localObject5);
          localObject5 = (RelativeLayout)((View)localObject4).findViewById(2131362422);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131362426);
          localObject7 = (TextView)((View)localObject4).findViewById(2131362428);
          localObject8 = (TextView)((View)localObject4).findViewById(2131362423);
          localObject9 = (Button)((View)localObject4).findViewById(2131362451);
          localObject10 = (TextView)((View)localObject4).findViewById(2131362429);
          localRelativeLayout = (RelativeLayout)((View)localObject4).findViewById(2131362424);
          localImageView = (ImageView)((View)localObject4).findViewById(2131362425);
          ((TextView)localObject1).setText(paramVipIPSiteInfo.ipName + MobileQQ.getContext().getString(2131699638));
          ((TextView)localObject3).setText(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).dealIPSiteString(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject1 = paramVipIPSiteInfo.ipList.get(i);
              IPSiteModel.Comic localComic;
              BigEmotionDownloadedAdapter.4 local4;
              if ((localObject1 instanceof IPSiteModel.Comic))
              {
                localComic = (IPSiteModel.Comic)localObject1;
                local4 = new BigEmotionDownloadedAdapter.4(this, localComic, str1, str3);
                localObject1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
              }
              switch (localComic.comicType)
              {
              default: 
                ((ImageView)localObject6).setImageDrawable(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getIPSiteDrawable(localComic.cover, this.mURLDrawableListener, this.mDefaultDrawable));
                ((TextView)localObject7).setText(localComic.name);
                ((TextView)localObject8).setText(localComic.desc);
                ((Button)localObject9).setOnClickListener(local4);
                ((RelativeLayout)localObject5).setOnClickListener(local4);
                i += 1;
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i = 0;
          continue;
          str2 = "2G";
          continue;
          str2 = "3G";
          continue;
          str2 = "4G";
          continue;
          str2 = "wifi";
        }
      }
      for (;;)
      {
        if (paramVipIPSiteInfo != null) {
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_entershow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
        }
        return paramVipIPSiteInfo;
        Object localObject2;
        if ("game".equals(localException2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131561744, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131362449);
          localObject9 = (TextView)((View)localObject2).findViewById(2131362430);
          ((RelativeLayout)((View)localObject2).findViewById(2131362443)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131362432);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131362434);
          localObject5 = (TextView)((View)localObject2).findViewById(2131362436);
          localObject6 = (TextView)((View)localObject2).findViewById(2131362433);
          localObject7 = (Button)((View)localObject2).findViewById(2131362452);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + this.mContext.getString(2131699638));
          ((TextView)localObject9).setText(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).dealIPSiteString(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Game))
              {
                localObject8 = (IPSiteModel.Game)localObject8;
                localObject9 = new BigEmotionDownloadedAdapter.5(this, (IPSiteModel.Game)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getIPSiteDrawable(((IPSiteModel.Game)localObject8).cover, this.mURLDrawableListener, this.mDefaultDrawable));
                ((TextView)localObject5).setText(((IPSiteModel.Game)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Game)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_gameshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("goods".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131561743, null, false);
          localObject3 = (TextView)((View)localObject2).findViewById(2131362449);
          localObject4 = (TextView)((View)localObject2).findViewById(2131362430);
          ((RelativeLayout)((View)localObject2).findViewById(2131362442)).setOnClickListener((View.OnClickListener)localObject5);
          ((TextView)localObject3).setText(paramVipIPSiteInfo.ipName + this.mContext.getString(2131699638));
          ((TextView)localObject4).setText(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).dealIPSiteString(paramVipIPSiteInfo.ipContent));
          localObject3 = (HorizontalListView)((View)localObject2).findViewById(2131362447);
          if (paramVipIPSiteInfo.ipList != null)
          {
            paramVipIPSiteInfo = new IPSiteListGoodsAdapter(this.mContext, paramVipIPSiteInfo.ipList, this.mURLDrawableListener, this.mDefaultDrawable, this.app.getCurrentUin(), str3, str2);
            ((HorizontalListView)localObject3).setDividerWidth(EmotionUtils.a(10.0F, this.mContext.getResources()));
            ((HorizontalListView)localObject3).setAdapter(paramVipIPSiteInfo);
          }
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_productshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("video".equals(localObject2))
        {
          localObject3 = LayoutInflater.from(this.mContext).inflate(2131561745, null, false);
          localObject2 = (TextView)((View)localObject3).findViewById(2131362449);
          localObject9 = (TextView)((View)localObject3).findViewById(2131362430);
          ((RelativeLayout)((View)localObject3).findViewById(2131362444)).setOnClickListener((View.OnClickListener)localObject5);
          localObject4 = (RelativeLayout)((View)localObject3).findViewById(2131362454);
          localObject5 = (ImageView)((View)localObject3).findViewById(2131362457);
          localObject6 = (TextView)((View)localObject3).findViewById(2131362459);
          localObject7 = (TextView)((View)localObject3).findViewById(2131362455);
          localObject8 = (Button)((View)localObject3).findViewById(2131362453);
          ((TextView)localObject2).setText(paramVipIPSiteInfo.ipName + this.mContext.getString(2131699638));
          ((TextView)localObject9).setText(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).dealIPSiteString(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            if (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject2 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject2 instanceof IPSiteModel.Video))
              {
                localObject9 = (IPSiteModel.Video)localObject2;
                localObject10 = new BigEmotionDownloadedAdapter.6(this, (IPSiteModel.Video)localObject9, str2, str3);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).buttonDesc)) {
                  break label2034;
                }
                localObject2 = this.mContext.getString(2131699606);
                label1878:
                ((ImageView)localObject5).setImageDrawable(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getIPSiteDrawable(((IPSiteModel.Video)localObject9).cover, this.mURLDrawableListener, this.mDefaultDrawable));
                ((TextView)localObject6).setText(((IPSiteModel.Video)localObject9).name);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).showDate)) {
                  break label2044;
                }
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).desc);
                label1940:
                ((Button)localObject8).setText((CharSequence)localObject2);
                if (!((String)localObject2).equals(this.mContext.getString(2131699606))) {
                  break label2083;
                }
                j = 2130846578;
                label1969:
                ((Button)localObject8).setBackgroundResource(j);
                if (!((String)localObject2).equals(this.mContext.getString(2131699606))) {
                  break label2090;
                }
              }
              label2083:
              label2090:
              for (int j = this.mContext.getResources().getColor(2131165442);; j = this.mContext.getResources().getColor(2131165497))
              {
                ((Button)localObject8).setTextColor(j);
                ((Button)localObject8).setOnClickListener((View.OnClickListener)localObject10);
                ((RelativeLayout)localObject4).setOnClickListener((View.OnClickListener)localObject10);
                i += 1;
                break;
                label2034:
                localObject2 = ((IPSiteModel.Video)localObject9).buttonDesc;
                break label1878;
                label2044:
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).showDate + this.mContext.getString(2131699637));
                break label1940;
                j = 2130846577;
                break label1969;
              }
            }
          }
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_movieshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject3;
        }
        else if ("book".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131561747, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131362449);
          localObject9 = (TextView)((View)localObject2).findViewById(2131362430);
          ((RelativeLayout)((View)localObject2).findViewById(2131362446)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131362416);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131362418);
          localObject5 = (TextView)((View)localObject2).findViewById(2131362420);
          localObject6 = (TextView)((View)localObject2).findViewById(2131362417);
          localObject7 = (Button)((View)localObject2).findViewById(2131362450);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + this.mContext.getString(2131699638));
          ((TextView)localObject9).setText(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).dealIPSiteString(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Book))
              {
                localObject8 = (IPSiteModel.Book)localObject8;
                localObject9 = new BigEmotionDownloadedAdapter.7(this, (IPSiteModel.Book)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getIPSiteDrawable(((IPSiteModel.Book)localObject8).cover, this.mURLDrawableListener, this.mDefaultDrawable));
                ((TextView)localObject5).setText(((IPSiteModel.Book)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Book)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_bookshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else
        {
          paramVipIPSiteInfo = null;
        }
      }
    }
    return null;
  }
  
  private boolean isKandianType()
  {
    return ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).isKandianType(this.businessType);
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (isKandianType()) {
        return i;
      }
      return i + 1;
    }
    return 0;
  }
  
  public EmoticonPackage getEmoticonPackage()
  {
    return this.emotionPkg;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (BigEmotionDownloadedAdapter.BigEmotionHolder)paramViewHolder;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label1136;
      }
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, SystemEmotionPanelManager.a().a(this.mContext, true), this.businessType);
        paramView.setPanelType(1);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        if (paramInt == 0) {
          paramView.setPadding(0, (int)(16.0F * this.density), 0, 0);
        }
        for (;;)
        {
          i = 0;
          for (;;)
          {
            paramViewHolder = paramView;
            if (i >= this.columnNum) {
              break;
            }
            paramViewHolder = super.getBigEmotionContentViewLayout();
            paramViewHolder.setVisibility(8);
            paramViewHolder.setFocusable(true);
            paramViewHolder.setFocusableInTouchMode(true);
            paramView.addView(paramViewHolder);
            i += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.density), 0, 0);
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
      recycleView(this.panelType, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).contentViews = new RelativeLayout[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).contentViews[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(localObject1);
    }
    for (;;)
    {
      i = 0;
      if (i < this.columnNum)
      {
        int j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1)
        {
          localObject1.contentViews[i].setTag(null);
          localObject1.contentViews[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = localObject1.contentViews[i];
          paramViewGroup = (EmotionPanelData)this.data.get(j);
          if (paramView != null)
          {
            if (paramViewGroup == paramView.getTag(2131381651)) {
              paramView.setVisibility(0);
            } else {
              paramView.setTag(2131381651, paramViewGroup);
            }
          }
          else
          {
            long l2 = System.currentTimeMillis();
            super.updateBigEmotionContentViewData(paramView, paramViewGroup);
            if (QLog.isColorLevel()) {
              QLog.d("BigEmotionDownloadedAdapter", 2, "updateUi cost = " + (System.currentTimeMillis() - l2));
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView cost = " + (System.currentTimeMillis() - l1));
        }
        return paramViewHolder;
        paramViewHolder = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.emotionPkg.ipSiteInfo;
          paramViewHolder = paramViewGroup;
          if (paramViewGroup == null)
          {
            paramViewHolder = paramViewGroup;
            if (this.emotionPkg.ipSiteInfoBytes != null)
            {
              paramViewHolder = paramViewGroup;
              if (this.emotionPkg.ipSiteInfoBytes.length > 0)
              {
                localObject2 = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getIPSiteInfoFromBytes(this.app, this.emotionPkg.ipSiteInfoBytes);
                paramViewHolder = paramViewGroup;
                if ((localObject2 instanceof VipIPSiteInfo)) {
                  paramViewHolder = (VipIPSiteInfo)localObject2;
                }
              }
            }
          }
          if (!((IBigEmotionService)QRoute.api(IBigEmotionService.class)).isRichIPSite(this.app, paramViewHolder)) {
            break;
          }
          paramViewGroup = getRichIPSiteView(paramViewHolder);
          paramViewHolder = paramView;
          if (paramViewGroup != null)
          {
            paramViewGroup.setTag(localObject1);
            paramViewHolder = paramViewGroup;
          }
        }
      }
      boolean bool = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).hasRecommendDressup(this.emotionPkg.epId, true);
      paramView = new RelativeLayout(this.mContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(46.0F * this.density)));
      paramViewGroup = new LinearLayout(this.mContext);
      paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
      paramViewHolder.addRule(13, -1);
      paramViewGroup.setLayoutParams(paramViewHolder);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      paramViewGroup.setOrientation(0);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      TextView localTextView = new TextView(this.mContext);
      localTextView.setTextSize(14.0F);
      if (bool)
      {
        paramViewHolder = MobileQQ.getContext().getString(2131699647);
        label856:
        localTextView.setText(paramViewHolder);
        localTextView.setTextColor(-8947849);
        paramViewGroup.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
        paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
        paramViewHolder.leftMargin = ((int)(5.0F * this.density));
        paramViewHolder.gravity = 16;
        localObject2 = new ImageView(this.mContext);
        ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846566));
        paramViewGroup.addView((View)localObject2, paramViewHolder);
        paramView.addView(paramViewGroup);
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout = paramViewGroup;
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout.setOnClickListener(new BigEmotionDownloadedAdapter.2(this, bool));
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout.setVisibility(0);
        paramView.setTag(localObject1);
        if (this.app != null) {
          break label1116;
        }
        paramViewHolder = null;
        label1004:
        ReportController.b(paramViewHolder, "CliOper", "", "", "ep_mall", "exp_bq_detail", 0, 0, "", this.emotionPkg.epId, "", "");
        paramViewGroup = (IBigEmotionService)QRoute.api(IBigEmotionService.class);
        localObject1 = this.app.getCurrentAccountUin();
        localObject2 = this.emotionPkg.epId;
        if (!bool) {
          break label1129;
        }
      }
      label1116:
      label1129:
      for (paramViewHolder = "1";; paramViewHolder = "2")
      {
        paramViewGroup.reportCommercialDrainage((String)localObject1, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject2, paramViewHolder);
        paramViewHolder = paramView;
        break;
        paramViewHolder = MobileQQ.getContext().getString(2131699648);
        break label856;
        paramViewHolder = this.app.getQQAppInterface();
        break label1004;
      }
      label1136:
      paramViewHolder = paramView;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (isKandianType()) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (isKandianType()) {
      return 1;
    }
    return 2;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new BigEmotionDownloadedAdapter.BigEmotionHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter
 * JD-Core Version:    0.7.0.1
 */