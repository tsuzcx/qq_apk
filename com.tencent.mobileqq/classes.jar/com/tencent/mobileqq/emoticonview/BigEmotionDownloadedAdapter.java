package com.tencent.mobileqq.emoticonview;

import amtj;
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
import avsp;
import avsq;
import bcef;
import bgae;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class BigEmotionDownloadedAdapter
  extends BaseEmotionAdapter
{
  private static final int COMIC_TYPE_ANIMATION = 100;
  private static final int COMIC_TYPE_COMIC = 1;
  public static final String TAG = "BigEmotionDownloadedAdapter";
  public static final int TYPE_BTN = 1;
  public static final int TYPE_DATA = 0;
  private int businessType;
  public Drawable defaultCommercialDrawable;
  public EmoticonPackage emotionPkg;
  private BaseChatPie mBaseChatPie;
  public ColorDrawable mDefaultDrawable;
  public URLDrawable.URLDrawableListener mURLDrawableListener = new BigEmotionDownloadedAdapter.8(this);
  
  public BigEmotionDownloadedAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.emotionPkg = paramEmoticonPackage;
    this.mBaseChatPie = paramBaseChatPie;
    this.businessType = paramInt4;
    ThreadManager.post(new BigEmotionDownloadedAdapter.1(this, paramContext), 8, null, true);
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
        i = NetworkUtil.getSystemNetwork(this.mContext);
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
            ((TextView)localObject10).setText(amtj.a(2131700248));
            localImageView.setVisibility(8);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(75.0F, this.mContext.getResources()), AIOUtils.dp2px(75.0F, this.mContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.dp2px(75.0F, this.mContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.dp2px(75.0F, this.mContext.getResources());
            ((TextView)localObject7).setMaxWidth(AIOUtils.dp2px(126.0F, this.mContext.getResources()));
            ((TextView)localObject8).setMaxWidth(AIOUtils.dp2px(126.0F, this.mContext.getResources()));
            continue;
            ((TextView)localObject10).setText(amtj.a(2131700241));
            localImageView.setVisibility(0);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(140.0F, this.mContext.getResources()), AIOUtils.dp2px(75.0F, this.mContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.dp2px(140.0F, this.mContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.dp2px(75.0F, this.mContext.getResources());
            ((TextView)localObject7).setMaxWidth(AIOUtils.dp2px(90.0F, this.mContext.getResources()));
            ((TextView)localObject8).setMaxWidth(AIOUtils.dp2px(90.0F, this.mContext.getResources()));
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_comicshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject4;
        }
        localObject5 = new BigEmotionDownloadedAdapter.3(this, paramVipIPSiteInfo, str1, str3);
        localObject1 = paramVipIPSiteInfo.strType;
        if ("comic".equals(localObject1))
        {
          localObject4 = LayoutInflater.from(this.mContext).inflate(2131559142, null, false);
          localObject1 = (TextView)((View)localObject4).findViewById(2131362413);
          localObject3 = (TextView)((View)localObject4).findViewById(2131362394);
          ((RelativeLayout)((View)localObject4).findViewById(2131362409)).setOnClickListener((View.OnClickListener)localObject5);
          localObject5 = (RelativeLayout)((View)localObject4).findViewById(2131362386);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131362390);
          localObject7 = (TextView)((View)localObject4).findViewById(2131362392);
          localObject8 = (TextView)((View)localObject4).findViewById(2131362387);
          localObject9 = (Button)((View)localObject4).findViewById(2131362415);
          localObject10 = (TextView)((View)localObject4).findViewById(2131362393);
          localRelativeLayout = (RelativeLayout)((View)localObject4).findViewById(2131362388);
          localImageView = (ImageView)((View)localObject4).findViewById(2131362389);
          ((TextView)localObject1).setText(paramVipIPSiteInfo.ipName + amtj.a(2131700243));
          ((TextView)localObject3).setText(bgae.a(paramVipIPSiteInfo.ipContent));
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
                ((ImageView)localObject6).setImageDrawable(bgae.a(localComic.cover, this.mURLDrawableListener, this.mDefaultDrawable));
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
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_entershow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
        }
        return paramVipIPSiteInfo;
        Object localObject2;
        if ("game".equals(localException2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131559140, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131362413);
          localObject9 = (TextView)((View)localObject2).findViewById(2131362394);
          ((RelativeLayout)((View)localObject2).findViewById(2131362407)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131362396);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131362398);
          localObject5 = (TextView)((View)localObject2).findViewById(2131362400);
          localObject6 = (TextView)((View)localObject2).findViewById(2131362397);
          localObject7 = (Button)((View)localObject2).findViewById(2131362416);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + amtj.a(2131700246));
          ((TextView)localObject9).setText(bgae.a(paramVipIPSiteInfo.ipContent));
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
                ((ImageView)localObject4).setImageDrawable(bgae.a(((IPSiteModel.Game)localObject8).cover, this.mURLDrawableListener, this.mDefaultDrawable));
                ((TextView)localObject5).setText(((IPSiteModel.Game)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Game)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_gameshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("goods".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131559139, null, false);
          localObject3 = (TextView)((View)localObject2).findViewById(2131362413);
          localObject4 = (TextView)((View)localObject2).findViewById(2131362394);
          ((RelativeLayout)((View)localObject2).findViewById(2131362406)).setOnClickListener((View.OnClickListener)localObject5);
          ((TextView)localObject3).setText(paramVipIPSiteInfo.ipName + amtj.a(2131700239));
          ((TextView)localObject4).setText(bgae.a(paramVipIPSiteInfo.ipContent));
          localObject3 = (HorizontalListView)((View)localObject2).findViewById(2131362411);
          if (paramVipIPSiteInfo.ipList != null)
          {
            paramVipIPSiteInfo = new IPSiteListGoodsAdapter(this.mContext, paramVipIPSiteInfo.ipList, this.mURLDrawableListener, this.mDefaultDrawable, this.app.getCurrentUin(), str3, str2);
            ((HorizontalListView)localObject3).setDividerWidth(AIOUtils.dp2px(10.0F, this.mContext.getResources()));
            ((HorizontalListView)localObject3).setAdapter(paramVipIPSiteInfo);
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_productshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("video".equals(localObject2))
        {
          localObject3 = LayoutInflater.from(this.mContext).inflate(2131559141, null, false);
          localObject2 = (TextView)((View)localObject3).findViewById(2131362413);
          localObject9 = (TextView)((View)localObject3).findViewById(2131362394);
          ((RelativeLayout)((View)localObject3).findViewById(2131362408)).setOnClickListener((View.OnClickListener)localObject5);
          localObject4 = (RelativeLayout)((View)localObject3).findViewById(2131362418);
          localObject5 = (ImageView)((View)localObject3).findViewById(2131362421);
          localObject6 = (TextView)((View)localObject3).findViewById(2131362423);
          localObject7 = (TextView)((View)localObject3).findViewById(2131362419);
          localObject8 = (Button)((View)localObject3).findViewById(2131362417);
          ((TextView)localObject2).setText(paramVipIPSiteInfo.ipName + amtj.a(2131700247));
          ((TextView)localObject9).setText(bgae.a(paramVipIPSiteInfo.ipContent));
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
                  break label1874;
                }
                localObject2 = amtj.a(2131700238);
                label1736:
                ((ImageView)localObject5).setImageDrawable(bgae.a(((IPSiteModel.Video)localObject9).cover, this.mURLDrawableListener, this.mDefaultDrawable));
                ((TextView)localObject6).setText(((IPSiteModel.Video)localObject9).name);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).showDate)) {
                  break label1884;
                }
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).desc);
                label1788:
                ((Button)localObject8).setText((CharSequence)localObject2);
                if (!((String)localObject2).equals(amtj.a(2131700244))) {
                  break label1919;
                }
                j = 2130839665;
                label1813:
                ((Button)localObject8).setBackgroundResource(j);
                if (!((String)localObject2).equals(amtj.a(2131700237))) {
                  break label1926;
                }
              }
              label1926:
              for (int j = this.mContext.getResources().getColor(2131165436);; j = this.mContext.getResources().getColor(2131165491))
              {
                ((Button)localObject8).setTextColor(j);
                ((Button)localObject8).setOnClickListener((View.OnClickListener)localObject10);
                ((RelativeLayout)localObject4).setOnClickListener((View.OnClickListener)localObject10);
                i += 1;
                break;
                label1874:
                localObject2 = ((IPSiteModel.Video)localObject9).buttonDesc;
                break label1736;
                label1884:
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).showDate + amtj.a(2131700236));
                break label1788;
                label1919:
                j = 2130839664;
                break label1813;
              }
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_movieshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject3;
        }
        else if ("book".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131559143, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131362413);
          localObject9 = (TextView)((View)localObject2).findViewById(2131362394);
          ((RelativeLayout)((View)localObject2).findViewById(2131362410)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131362380);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131362382);
          localObject5 = (TextView)((View)localObject2).findViewById(2131362384);
          localObject6 = (TextView)((View)localObject2).findViewById(2131362381);
          localObject7 = (Button)((View)localObject2).findViewById(2131362414);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + amtj.a(2131700245));
          ((TextView)localObject9).setText(bgae.a(paramVipIPSiteInfo.ipContent));
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
                ((ImageView)localObject4).setImageDrawable(bgae.a(((IPSiteModel.Book)localObject8).cover, this.mURLDrawableListener, this.mDefaultDrawable));
                ((TextView)localObject5).setText(((IPSiteModel.Book)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Book)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_bookshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
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
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (this.businessType == 1) {
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
        break label1080;
      }
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, this.businessType);
        paramView.setPanelType(EmoticonPanelLinearLayout.PANEL_TYPE_BIG_EMOTION);
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
            if (paramViewGroup == paramView.getTag(2131380831)) {
              paramView.setVisibility(0);
            } else {
              paramView.setTag(2131380831, paramViewGroup);
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
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView cost = " + (System.currentTimeMillis() - l1));
        }
        return paramViewHolder;
        paramViewHolder = paramView;
      } while (paramView != null);
      paramViewGroup = (avsp)this.app.getManager(200);
      Object localObject2 = (avsq)this.app.getManager(14);
      paramViewHolder = this.emotionPkg.ipSiteInfo;
      if ((paramViewHolder == null) && (this.emotionPkg.ipSiteInfoBytes != null) && (this.emotionPkg.ipSiteInfoBytes.length > 0)) {
        paramViewHolder = ((avsq)localObject2).a(this.emotionPkg.ipSiteInfoBytes);
      }
      for (;;)
      {
        if (paramViewGroup != null) {}
        for (boolean bool = paramViewGroup.a(paramViewHolder);; bool = false)
        {
          if (bool)
          {
            paramViewGroup = getRichIPSiteView(paramViewHolder);
            paramViewHolder = paramView;
            if (paramViewGroup == null) {
              break;
            }
            paramViewGroup.setTag(localObject1);
            paramViewHolder = paramViewGroup;
            break;
          }
          paramView = new RelativeLayout(this.mContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(46.0F * this.density)));
          localObject2 = new LinearLayout(this.mContext);
          paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
          paramViewHolder.addRule(13, -1);
          ((LinearLayout)localObject2).setLayoutParams(paramViewHolder);
          paramViewGroup = EmoticonRecDressup.getEmotionRecommend(this.emotionPkg.epId, true);
          Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout)localObject2).setOrientation(0);
          ((LinearLayout.LayoutParams)localObject3).gravity = 16;
          TextView localTextView = new TextView(this.mContext);
          localTextView.setTextSize(14.0F);
          if (paramViewGroup.hasRecommendDressup)
          {
            paramViewHolder = amtj.a(2131700240);
            label826:
            localTextView.setText(paramViewHolder);
            localTextView.setTextColor(-8947849);
            ((LinearLayout)localObject2).addView(localTextView, (ViewGroup.LayoutParams)localObject3);
            paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
            paramViewHolder.leftMargin = ((int)(5.0F * this.density));
            paramViewHolder.gravity = 16;
            localObject3 = new ImageView(this.mContext);
            ((ImageView)localObject3).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847025));
            ((LinearLayout)localObject2).addView((View)localObject3, paramViewHolder);
            paramView.addView((View)localObject2);
            ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout = ((LinearLayout)localObject2);
            ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout.setOnClickListener(new BigEmotionDownloadedAdapter.2(this, paramViewGroup));
            ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout.setVisibility(0);
            paramView.setTag(localObject1);
            bcef.b(this.app, "CliOper", "", "", "ep_mall", "exp_bq_detail", 0, 0, "", this.emotionPkg.epId, "", "");
            localObject1 = this.app.getCurrentAccountUin();
            localObject2 = this.emotionPkg.epId;
            if (!paramViewGroup.hasRecommendDressup) {
              break label1064;
            }
          }
          label1064:
          for (paramViewHolder = "1";; paramViewHolder = "2")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject1, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject2, paramViewHolder);
            paramViewHolder = paramView;
            break;
            paramViewHolder = amtj.a(2131700242);
            break label826;
          }
        }
      }
      label1080:
      paramViewHolder = paramView;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.businessType == 1) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (this.businessType == 1) {
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