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
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import mqq.app.MobileQQ;

public class BigEmotionDownloadedAdapter
  extends AbsBigEmotionUpdateAdapter
  implements View.OnClickListener
{
  private static final int COMIC_TYPE_ANIMATION = 100;
  private static final int COMIC_TYPE_COMIC = 1;
  public static final String TAG = "BigEmotionDownloadedAdapter";
  public static final int TYPE_BTN = 1;
  public static final int TYPE_DATA = 0;
  private int businessType;
  public Drawable defaultCommercialDrawable = null;
  public EmoticonPackage emotionPkg;
  private IPanelInteractionListener interactionListener;
  public ColorDrawable mDefaultDrawable = null;
  public URLDrawable.URLDrawableListener mURLDrawableListener = new BigEmotionDownloadedAdapter.8(this);
  private int tabIdx = -1;
  
  public BigEmotionDownloadedAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.emotionPkg = paramEmoticonPackage;
    this.interactionListener = paramIPanelInteractionListener;
    this.businessType = paramInt4;
    ThreadManager.post(new BigEmotionDownloadedAdapter.1(this), 8, null, true);
  }
  
  private View getRichIPSiteView(VipIPSiteInfo paramVipIPSiteInfo)
  {
    Object localObject6 = paramVipIPSiteInfo;
    Object localObject3 = null;
    Object localObject7 = null;
    if (localObject6 != null) {
      if (this.mDefaultDrawable == null) {
        this.mDefaultDrawable = new ColorDrawable(-1513240);
      }
    }
    try
    {
      i = NetworkUtil.getSystemNetwork(this.mContext);
    }
    catch (Exception localException2)
    {
      int i;
      label45:
      Object localObject4;
      Object localObject2;
      String str;
      Object localObject8;
      Object localObject1;
      Object localObject13;
      Object localObject14;
      Object localObject5;
      Object localObject9;
      Object localObject10;
      Object localObject11;
      Object localObject12;
      StringBuilder localStringBuilder;
      BaseApplication localBaseApplication;
      int j;
      break label45;
    }
    i = 0;
    localObject4 = "";
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            localObject2 = "";
            break label107;
          }
          str = "4G";
        }
        else
        {
          str = "3G";
        }
      }
      else {
        str = "2G";
      }
    }
    else {
      str = "wifi";
    }
    localObject2 = str;
    try
    {
      label107:
      str = String.valueOf(((VipIPSiteInfo)localObject6).ipID);
      localObject4 = str;
    }
    catch (Exception localException1)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("fillIPSiteViewPagerMode ipId error = ");
      ((StringBuilder)localObject3).append(localException1);
      QLog.e("BigEmotionDownloadedAdapter", 1, ((StringBuilder)localObject3).toString());
    }
    localObject3 = new BigEmotionDownloadedAdapter.3(this, (VipIPSiteInfo)localObject6, (String)localObject2, (String)localObject4);
    localObject8 = ((VipIPSiteInfo)localObject6).strType;
    if ("comic".equals(localObject8))
    {
      localObject1 = LayoutInflater.from(this.mContext).inflate(2131561605, null, false);
      localObject13 = (TextView)((View)localObject1).findViewById(2131362405);
      localObject14 = (TextView)((View)localObject1).findViewById(2131362386);
      ((RelativeLayout)((View)localObject1).findViewById(2131362401)).setOnClickListener((View.OnClickListener)localObject3);
      localObject5 = (RelativeLayout)((View)localObject1).findViewById(2131362378);
      localObject7 = (ImageView)((View)localObject1).findViewById(2131362382);
      localObject8 = (TextView)((View)localObject1).findViewById(2131362384);
      localObject9 = (TextView)((View)localObject1).findViewById(2131362379);
      localObject10 = (Button)((View)localObject1).findViewById(2131362407);
      localObject11 = (TextView)((View)localObject1).findViewById(2131362385);
      localObject3 = (RelativeLayout)((View)localObject1).findViewById(2131362380);
      localObject12 = (ImageView)((View)localObject1).findViewById(2131362381);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((VipIPSiteInfo)localObject6).ipName);
      localBaseApplication = MobileQQ.getContext();
      localStringBuilder.append(localBaseApplication.getString(2131699765));
      ((TextView)localObject13).setText(localStringBuilder.toString());
      ((TextView)localObject14).setText(IPSiteUtil.dealIPSiteString(((VipIPSiteInfo)localObject6).ipContent));
      if (((VipIPSiteInfo)localObject6).ipList != null)
      {
        i = 0;
        for (;;)
        {
          localObject6 = paramVipIPSiteInfo;
          if (i >= ((VipIPSiteInfo)localObject6).ipList.size()) {
            break;
          }
          localObject6 = ((VipIPSiteInfo)localObject6).ipList.get(i);
          if ((localObject6 instanceof IPSiteModel.Comic))
          {
            localObject13 = (IPSiteModel.Comic)localObject6;
            localObject14 = new BigEmotionDownloadedAdapter.4(this, (IPSiteModel.Comic)localObject13, (String)localObject2, (String)localObject4);
            localObject6 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
            j = ((IPSiteModel.Comic)localObject13).comicType;
            if (j != 1)
            {
              if (j == 100)
              {
                ((TextView)localObject11).setText(MobileQQ.getContext().getString(2131699709));
                ((ImageView)localObject12).setVisibility(0);
                if (localObject6 == null) {
                  localObject6 = new RelativeLayout.LayoutParams(EmotionUtils.a(140.0F, this.mContext.getResources()), EmotionUtils.a(75.0F, this.mContext.getResources()));
                }
                ((RelativeLayout.LayoutParams)localObject6).width = EmotionUtils.a(140.0F, this.mContext.getResources());
                ((RelativeLayout.LayoutParams)localObject6).height = EmotionUtils.a(75.0F, this.mContext.getResources());
                ((TextView)localObject8).setMaxWidth(EmotionUtils.a(90.0F, this.mContext.getResources()));
                ((TextView)localObject9).setMaxWidth(EmotionUtils.a(90.0F, this.mContext.getResources()));
              }
            }
            else
            {
              ((TextView)localObject11).setText(MobileQQ.getContext().getString(2131699723));
              ((ImageView)localObject12).setVisibility(8);
              if (localObject6 == null) {
                localObject6 = new RelativeLayout.LayoutParams(EmotionUtils.a(75.0F, this.mContext.getResources()), EmotionUtils.a(75.0F, this.mContext.getResources()));
              }
              ((RelativeLayout.LayoutParams)localObject6).width = EmotionUtils.a(75.0F, this.mContext.getResources());
              ((RelativeLayout.LayoutParams)localObject6).height = EmotionUtils.a(75.0F, this.mContext.getResources());
              ((TextView)localObject8).setMaxWidth(EmotionUtils.a(126.0F, this.mContext.getResources()));
              ((TextView)localObject9).setMaxWidth(EmotionUtils.a(126.0F, this.mContext.getResources()));
            }
            ((ImageView)localObject7).setImageDrawable(IPSiteUtil.getIPSiteDrawable(((IPSiteModel.Comic)localObject13).cover, this.mURLDrawableListener, this.mDefaultDrawable));
            ((TextView)localObject8).setText(((IPSiteModel.Comic)localObject13).name);
            ((TextView)localObject9).setText(((IPSiteModel.Comic)localObject13).desc);
            ((Button)localObject10).setOnClickListener((View.OnClickListener)localObject14);
            ((RelativeLayout)localObject5).setOnClickListener((View.OnClickListener)localObject14);
          }
          i += 1;
        }
      }
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "IP", "aio_comicshow", "", 0, 0, 0, (String)localObject2, (String)localObject4, "", "", "", "", "", 0, 0, 0, 0);
      paramVipIPSiteInfo = (VipIPSiteInfo)localObject1;
    }
    for (;;)
    {
      localObject1 = paramVipIPSiteInfo;
      break label2439;
      localObject5 = localObject2;
      if ("game".equals(localObject8))
      {
        localObject1 = LayoutInflater.from(this.mContext).inflate(2131561603, null, false);
        localObject10 = (TextView)((View)localObject1).findViewById(2131362405);
        localObject11 = (TextView)((View)localObject1).findViewById(2131362386);
        ((RelativeLayout)((View)localObject1).findViewById(2131362399)).setOnClickListener((View.OnClickListener)localObject3);
        localObject3 = (RelativeLayout)((View)localObject1).findViewById(2131362388);
        localObject6 = (ImageView)((View)localObject1).findViewById(2131362390);
        localObject7 = (TextView)((View)localObject1).findViewById(2131362392);
        localObject8 = (TextView)((View)localObject1).findViewById(2131362389);
        localObject9 = (Button)((View)localObject1).findViewById(2131362408);
        localObject12 = new StringBuilder();
        ((StringBuilder)localObject12).append(paramVipIPSiteInfo.ipName);
        ((StringBuilder)localObject12).append(this.mContext.getString(2131699765));
        ((TextView)localObject10).setText(((StringBuilder)localObject12).toString());
        ((TextView)localObject11).setText(IPSiteUtil.dealIPSiteString(paramVipIPSiteInfo.ipContent));
        if (paramVipIPSiteInfo.ipList != null)
        {
          i = 0;
          while (i < paramVipIPSiteInfo.ipList.size())
          {
            localObject10 = paramVipIPSiteInfo.ipList.get(i);
            if ((localObject10 instanceof IPSiteModel.Game))
            {
              localObject10 = (IPSiteModel.Game)localObject10;
              localObject11 = new BigEmotionDownloadedAdapter.5(this, (IPSiteModel.Game)localObject10, (String)localObject5, (String)localObject4);
              ((ImageView)localObject6).setImageDrawable(IPSiteUtil.getIPSiteDrawable(((IPSiteModel.Game)localObject10).cover, this.mURLDrawableListener, this.mDefaultDrawable));
              ((TextView)localObject7).setText(((IPSiteModel.Game)localObject10).name);
              ((TextView)localObject8).setText(((IPSiteModel.Game)localObject10).recommDesc);
              ((Button)localObject9).setOnClickListener((View.OnClickListener)localObject11);
              ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject11);
            }
            i += 1;
          }
        }
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "IP", "aio_gameshow", "", 0, 0, 0, (String)localObject5, (String)localObject4, "", "", "", "", "", 0, 0, 0, 0);
        break label2439;
      }
      if ("goods".equals(localObject8))
      {
        localObject1 = LayoutInflater.from(this.mContext).inflate(2131561602, null, false);
        localObject6 = (TextView)((View)localObject1).findViewById(2131362405);
        localObject7 = (TextView)((View)localObject1).findViewById(2131362386);
        ((RelativeLayout)((View)localObject1).findViewById(2131362398)).setOnClickListener((View.OnClickListener)localObject3);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramVipIPSiteInfo.ipName);
        ((StringBuilder)localObject3).append(this.mContext.getString(2131699765));
        ((TextView)localObject6).setText(((StringBuilder)localObject3).toString());
        ((TextView)localObject7).setText(IPSiteUtil.dealIPSiteString(paramVipIPSiteInfo.ipContent));
        localObject3 = (HorizontalListView)((View)localObject1).findViewById(2131362403);
        if (paramVipIPSiteInfo.ipList != null)
        {
          paramVipIPSiteInfo = new IPSiteListGoodsAdapter(this.mContext, paramVipIPSiteInfo.ipList, this.mURLDrawableListener, this.mDefaultDrawable, this.app.getCurrentUin(), (String)localObject4, (String)localObject5);
          ((HorizontalListView)localObject3).setDividerWidth(EmotionUtils.a(10.0F, this.mContext.getResources()));
          ((HorizontalListView)localObject3).setAdapter(paramVipIPSiteInfo);
        }
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "IP", "aio_productshow", "", 0, 0, 0, (String)localObject5, (String)localObject4, "", "", "", "", "", 0, 0, 0, 0);
        break label2439;
      }
      if (!"video".equals(localObject8)) {
        break;
      }
      localObject1 = LayoutInflater.from(this.mContext).inflate(2131561604, null, false);
      localObject11 = (TextView)((View)localObject1).findViewById(2131362405);
      localObject12 = (TextView)((View)localObject1).findViewById(2131362386);
      ((RelativeLayout)((View)localObject1).findViewById(2131362400)).setOnClickListener((View.OnClickListener)localObject3);
      localObject6 = (RelativeLayout)((View)localObject1).findViewById(2131362410);
      localObject7 = (ImageView)((View)localObject1).findViewById(2131362413);
      localObject8 = (TextView)((View)localObject1).findViewById(2131362415);
      localObject9 = (TextView)((View)localObject1).findViewById(2131362411);
      localObject10 = (Button)((View)localObject1).findViewById(2131362409);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramVipIPSiteInfo.ipName);
      ((StringBuilder)localObject3).append(this.mContext.getString(2131699765));
      ((TextView)localObject11).setText(((StringBuilder)localObject3).toString());
      ((TextView)localObject12).setText(IPSiteUtil.dealIPSiteString(paramVipIPSiteInfo.ipContent));
      localObject3 = localObject1;
      if (paramVipIPSiteInfo.ipList != null)
      {
        i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i >= paramVipIPSiteInfo.ipList.size()) {
            break;
          }
          localObject3 = paramVipIPSiteInfo.ipList.get(i);
          if ((localObject3 instanceof IPSiteModel.Video))
          {
            localObject12 = (IPSiteModel.Video)localObject3;
            localObject11 = new BigEmotionDownloadedAdapter.6(this, (IPSiteModel.Video)localObject12, (String)localObject5, (String)localObject4);
            if (TextUtils.isEmpty(((IPSiteModel.Video)localObject12).buttonDesc)) {
              localObject3 = this.mContext.getString(2131699714);
            } else {
              localObject3 = ((IPSiteModel.Video)localObject12).buttonDesc;
            }
            ((ImageView)localObject7).setImageDrawable(IPSiteUtil.getIPSiteDrawable(((IPSiteModel.Video)localObject12).cover, this.mURLDrawableListener, this.mDefaultDrawable));
            ((TextView)localObject8).setText(((IPSiteModel.Video)localObject12).name);
            if (TextUtils.isEmpty(((IPSiteModel.Video)localObject12).showDate))
            {
              ((TextView)localObject9).setText(((IPSiteModel.Video)localObject12).desc);
            }
            else
            {
              localObject13 = new StringBuilder();
              ((StringBuilder)localObject13).append(((IPSiteModel.Video)localObject12).showDate);
              ((StringBuilder)localObject13).append(this.mContext.getString(2131699764));
              ((TextView)localObject9).setText(((StringBuilder)localObject13).toString());
            }
            ((Button)localObject10).setText((CharSequence)localObject3);
            if (((String)localObject3).equals(this.mContext.getString(2131699714))) {
              j = 2130846457;
            } else {
              j = 2130846456;
            }
            ((Button)localObject10).setBackgroundResource(j);
            if (((String)localObject3).equals(this.mContext.getString(2131699714)))
            {
              localObject3 = this.mContext.getResources();
              j = 2131165418;
            }
            else
            {
              localObject3 = this.mContext.getResources();
              j = 2131165473;
            }
            ((Button)localObject10).setTextColor(((Resources)localObject3).getColor(j));
            ((Button)localObject10).setOnClickListener((View.OnClickListener)localObject11);
            ((RelativeLayout)localObject6).setOnClickListener((View.OnClickListener)localObject11);
          }
          i += 1;
        }
      }
      paramVipIPSiteInfo = (VipIPSiteInfo)localObject3;
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "IP", "aio_movieshow", "", 0, 0, 0, (String)localObject5, (String)localObject4, "", "", "", "", "", 0, 0, 0, 0);
    }
    localObject1 = localObject7;
    if ("book".equals(localObject8))
    {
      localObject1 = LayoutInflater.from(this.mContext);
      i = 0;
      localObject1 = ((LayoutInflater)localObject1).inflate(2131561606, null, false);
      localObject10 = (TextView)((View)localObject1).findViewById(2131362405);
      localObject11 = (TextView)((View)localObject1).findViewById(2131362386);
      ((RelativeLayout)((View)localObject1).findViewById(2131362402)).setOnClickListener((View.OnClickListener)localObject3);
      localObject3 = (RelativeLayout)((View)localObject1).findViewById(2131362372);
      localObject6 = (ImageView)((View)localObject1).findViewById(2131362374);
      localObject7 = (TextView)((View)localObject1).findViewById(2131362376);
      localObject8 = (TextView)((View)localObject1).findViewById(2131362373);
      localObject9 = (Button)((View)localObject1).findViewById(2131362406);
      localObject12 = new StringBuilder();
      ((StringBuilder)localObject12).append(paramVipIPSiteInfo.ipName);
      ((StringBuilder)localObject12).append(this.mContext.getString(2131699765));
      ((TextView)localObject10).setText(((StringBuilder)localObject12).toString());
      ((TextView)localObject11).setText(IPSiteUtil.dealIPSiteString(paramVipIPSiteInfo.ipContent));
      if (paramVipIPSiteInfo.ipList != null) {
        while (i < paramVipIPSiteInfo.ipList.size())
        {
          localObject10 = paramVipIPSiteInfo.ipList.get(i);
          if ((localObject10 instanceof IPSiteModel.Book))
          {
            localObject10 = (IPSiteModel.Book)localObject10;
            localObject11 = new BigEmotionDownloadedAdapter.7(this, (IPSiteModel.Book)localObject10, (String)localObject5, (String)localObject4);
            ((ImageView)localObject6).setImageDrawable(IPSiteUtil.getIPSiteDrawable(((IPSiteModel.Book)localObject10).cover, this.mURLDrawableListener, this.mDefaultDrawable));
            ((TextView)localObject7).setText(((IPSiteModel.Book)localObject10).name);
            ((TextView)localObject8).setText(((IPSiteModel.Book)localObject10).recommDesc);
            ((Button)localObject9).setOnClickListener((View.OnClickListener)localObject11);
            ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject11);
          }
          i += 1;
        }
      }
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "IP", "aio_bookshow", "", 0, 0, 0, (String)localObject5, (String)localObject4, "", "", "", "", "", 0, 0, 0, 0);
    }
    label2439:
    localObject3 = localObject1;
    if (localObject1 != null)
    {
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "IP", "aio_entershow", "", 0, 0, 0, (String)localObject2, (String)localObject4, "", "", "", "", "", 0, 0, 0, 0);
      localObject3 = localObject1;
    }
    return localObject3;
  }
  
  private boolean isKandianType()
  {
    return this.businessType == 1;
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
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView == null)
      {
        paramViewHolder = EmotionPanelViewPool.getInstance().getView(this.panelType);
        if (paramViewHolder == null)
        {
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";view from inflater");
            QLog.d("BigEmotionDownloadedAdapter", 2, paramViewHolder.toString());
          }
          paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.interactionListener), this.businessType);
          paramViewHolder.setPanelType(1);
          paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramViewHolder.setOrientation(0);
          if (paramInt == 0) {
            paramViewHolder.setPadding(0, (int)(this.density * 16.0F), 0, 0);
          } else {
            paramViewHolder.setPadding(0, (int)(this.density * 14.0F), 0, 0);
          }
          i = 0;
          for (;;)
          {
            paramView = paramViewHolder;
            if (i >= this.columnNum) {
              break;
            }
            paramView = super.getBigEmotionContentViewLayout();
            paramView.setVisibility(8);
            paramView.setFocusable(true);
            paramView.setFocusableInTouchMode(true);
            paramViewHolder.addView(paramView);
            i += 1;
          }
        }
        paramView = paramViewHolder;
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("getEmotionView position = ");
          paramView.append(paramInt);
          paramView.append(";view from cache");
          QLog.d("BigEmotionDownloadedAdapter", 2, paramView.toString());
          paramView = paramViewHolder;
        }
        ((EmoticonPanelLinearLayout)paramView).setCallBack(this.callback);
        recycleView(this.panelType, paramView);
        paramViewHolder = (ViewGroup)paramView;
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).contentViews = new RelativeLayout[this.columnNum];
        i = 0;
        while (i < this.columnNum)
        {
          ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).contentViews[i] = ((RelativeLayout)paramViewHolder.getChildAt(i));
          i += 1;
        }
        paramView.setTag(localObject1);
      }
      int i = 0;
      for (;;)
      {
        paramViewHolder = paramView;
        if (i >= this.columnNum) {
          break;
        }
        int j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1)
        {
          localObject1.contentViews[i].setTag(null);
          localObject1.contentViews[i].setVisibility(8);
        }
        else
        {
          paramViewHolder = localObject1.contentViews[i];
          paramViewGroup = (EmotionPanelData)this.data.get(j);
          if (((paramViewGroup instanceof PicEmoticonInfo)) && (this.businessType == 0))
          {
            paramViewHolder.setOnClickListener(this);
            paramViewHolder.setClickable(false);
            EmoticonReportDtHelper.bindAlbumEmotionView(paramViewHolder, (PicEmoticonInfo)paramViewGroup, j, this.tabIdx);
          }
          if (paramViewHolder != null)
          {
            if (paramViewGroup == paramViewHolder.getTag(2131380884)) {
              paramViewHolder.setVisibility(0);
            } else {
              paramViewHolder.setTag(2131380884, paramViewGroup);
            }
          }
          else
          {
            long l2 = System.currentTimeMillis();
            super.updateBigEmotionContentViewData(paramViewHolder, paramViewGroup);
            if (QLog.isColorLevel())
            {
              paramViewHolder = new StringBuilder();
              paramViewHolder.append("updateUi cost = ");
              paramViewHolder.append(System.currentTimeMillis() - l2);
              QLog.d("BigEmotionDownloadedAdapter", 2, paramViewHolder.toString());
            }
          }
        }
        i += 1;
      }
    }
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
          if (this.emotionPkg.ipSiteInfoBytes.length > 0) {
            paramViewHolder = ((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).getIPSiteInfoFromBytes(this.emotionPkg.ipSiteInfoBytes);
          }
        }
      }
      paramViewGroup = (CommercialDrainageManagerServiceProxy)this.app.getRuntimeService(ICommercialDrainageManagerService.class);
      boolean bool;
      if (paramViewGroup != null) {
        bool = paramViewGroup.isRichIPSite(paramViewHolder);
      } else {
        bool = false;
      }
      if (bool)
      {
        paramViewHolder = getRichIPSiteView(paramViewHolder);
        if (paramViewHolder != null) {
          paramViewHolder.setTag(localObject1);
        } else {
          paramViewHolder = paramView;
        }
      }
      else
      {
        paramViewHolder = EmoticonRecDressup.getEmotionRecommend(this.emotionPkg.epId, true);
        if (paramViewHolder != null) {
          bool = paramViewHolder.hasRecommendDressup;
        } else {
          bool = false;
        }
        paramView = new RelativeLayout(this.mContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(this.density * 46.0F)));
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
          paramViewHolder = MobileQQ.getContext();
          paramInt = 2131699777;
        }
        else
        {
          paramViewHolder = MobileQQ.getContext();
          paramInt = 2131699778;
        }
        localTextView.setText(paramViewHolder.getString(paramInt));
        localTextView.setTextColor(-8947849);
        paramViewGroup.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
        paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
        paramViewHolder.leftMargin = ((int)(this.density * 5.0F));
        paramViewHolder.gravity = 16;
        localObject2 = new ImageView(this.mContext);
        ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846444));
        paramViewGroup.addView((View)localObject2, paramViewHolder);
        paramView.addView(paramViewGroup);
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout = paramViewGroup;
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout.setOnClickListener(new BigEmotionDownloadedAdapter.2(this, bool));
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).linearLayout.setVisibility(0);
        paramView.setTag(localObject1);
        ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "exp_bq_detail", 0, 0, "", this.emotionPkg.epId, "", "");
        paramViewGroup = this.app.getCurrentAccountUin();
        localObject1 = this.emotionPkg.epId;
        if (bool) {
          paramViewHolder = "1";
        } else {
          paramViewHolder = "2";
        }
        VasWebviewUtil.a(paramViewGroup, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject1, paramViewHolder);
        paramViewHolder = paramView;
      }
    }
    else
    {
      paramViewHolder = paramView;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getEmotionView cost = ");
      paramView.append(System.currentTimeMillis() - l1);
      QLog.d("BigEmotionDownloadedAdapter", 2, paramView.toString());
    }
    return paramViewHolder;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (isKandianType()) {
      return 0;
    }
    if (paramInt == getCount() - 1) {
      return 1;
    }
    return 0;
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
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BigEmotionDownloadedAdapter", 2, "BigEmotionDownloadedAdapter itemView onClicked");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setTabIdx(int paramInt)
  {
    this.tabIdx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter
 * JD-Core Version:    0.7.0.1
 */