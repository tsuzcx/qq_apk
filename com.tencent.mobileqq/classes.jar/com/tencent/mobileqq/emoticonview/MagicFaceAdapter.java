package com.tencent.mobileqq.emoticonview;

import amtj;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import areb;
import avsq;
import bjmp;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MagicFaceAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback
{
  public static final int CONTENT_HIGHT = 72;
  public static final int IMG_HEIGHT = 56;
  public static final String MAGIC_GRAY_PIC = "_panel_magic_gray";
  private static final int MSG_DOWNLOAD_END = 101;
  private static final int MSG_DOWNLOAD_START = 100;
  private static final int SIZE_BIG_EMOTICON = 63;
  public static final String TAG = "MagicFaceAdapter";
  private MqqHandler mUiHandler = new bjmp(Looper.getMainLooper(), this, true);
  List<ProgressBar> proBars = new ArrayList();
  
  public MagicFaceAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
  }
  
  private RelativeLayout getMagicView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "getMagicView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(72.0F * this.density)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131365977);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(56.0F * this.density), (int)(56.0F * this.density));
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(14, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView((View)localObject);
    localObject = new TextView(this.mContext);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setId(2131365982);
    ((TextView)localObject).setTextSize(11.0F);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(3, 2131365977);
    localLayoutParams1.topMargin = ((int)(5.0F * this.density));
    localLayoutParams1.addRule(14, -1);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setId(2131365983);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(8, 2131365977);
    localLayoutParams1.addRule(7, 2131365977);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131365984);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(5, 2131365977);
    localLayoutParams1.addRule(6, 2131365977);
    ProgressBar localProgressBar = new ProgressBar(this.mContext);
    localProgressBar.setVisibility(8);
    localProgressBar.setId(2131365981);
    localProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130839445));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams((int)(16.0F * this.density), (int)(16.0F * this.density));
    localLayoutParams2.addRule(14, -1);
    localLayoutParams2.topMargin = ((int)(20.0F * this.density));
    localRelativeLayout.addView(localProgressBar, localLayoutParams2);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    if (AppSetting.c) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private ProgressBar getProgressBarByEp(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    while ((this.proBars == null) || (this.proBars.size() <= 0)) {
      return null;
    }
    Iterator localIterator = this.proBars.iterator();
    while (localIterator.hasNext())
    {
      ProgressBar localProgressBar = (ProgressBar)localIterator.next();
      Object localObject = localProgressBar.getTag();
      if ((localObject instanceof String)) {}
      for (localObject = (String)localObject; (!TextUtils.isEmpty((CharSequence)localObject)) && (paramEmoticonPackage.epId.equals(localObject)); localObject = null) {
        return localProgressBar;
      }
    }
  }
  
  private void updateImageView(URLImageView paramURLImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramURLImageView == null) || (paramPicEmoticonInfo == null))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView view or info = null");
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)paramURLImageView.getLayoutParams();
    if ("push".equals(paramPicEmoticonInfo.action))
    {
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.density * 63.0F));
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(this.density * 63.0F));
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceAdapter", 2, "show push_btn drawable.");
      }
      paramPicEmoticonInfo = this.mContext.getSharedPreferences("mobileQQ", 0);
      localObject = this.app.getCurrentAccountUin();
      boolean bool = paramPicEmoticonInfo.getBoolean("magic_promotion_is_new_content_" + (String)localObject, false);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mContext.getResources().getDrawable(2130847023);
      if (bool)
      {
        paramPicEmoticonInfo = paramPicEmoticonInfo.getString("magic_promotion_gifUrl", "");
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        if (TextUtils.isEmpty(paramPicEmoticonInfo)) {
          break label250;
        }
      }
      for (;;)
      {
        try
        {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramPicEmoticonInfo, (URLDrawable.URLDrawableOptions)localObject));
          if (!AppSetting.c) {
            break;
          }
          paramURLImageView.setContentDescription(amtj.a(2131705535));
          return;
          paramPicEmoticonInfo = paramPicEmoticonInfo.getString("magic_promotion_imgUrl", "");
        }
        catch (IllegalArgumentException paramPicEmoticonInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.w("MagicFaceAdapter", 2, paramPicEmoticonInfo.getMessage());
          }
          paramURLImageView.setImageDrawable(null);
          continue;
        }
        label250:
        paramURLImageView.setImageDrawable(null);
      }
    }
    Emoticon localEmoticon = paramPicEmoticonInfo.emoticon;
    if ((localEmoticon == null) || (TextUtils.isEmpty(localEmoticon.epId)))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView emotion is null or epid is null");
      return;
    }
    EmoticonPackage localEmoticonPackage = ((avsq)this.app.getManager(14)).a(localEmoticon.epId);
    String str = localEmoticon.epId + "_" + localEmoticon.eId;
    localObject = str;
    if (localEmoticonPackage != null) {
      if (localEmoticonPackage.valid)
      {
        localObject = str;
        if (2 == localEmoticonPackage.status) {}
      }
      else
      {
        localObject = str;
        if (!paramPicEmoticonInfo.isDownLoad) {
          localObject = str + "_panel_magic_gray";
        }
      }
    }
    try
    {
      paramPicEmoticonInfo = new URL("emotion_pic", "fromPanel", (String)localObject);
      if (paramPicEmoticonInfo != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mContext.getResources().getDrawable(2130838035);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mContext.getResources().getDrawable(2130843781);
        paramPicEmoticonInfo = URLDrawable.getDrawable(paramPicEmoticonInfo, (URLDrawable.URLDrawableOptions)localObject);
        paramPicEmoticonInfo.setTag(localEmoticon);
        paramPicEmoticonInfo.addHeader("my_uin", this.app.getCurrentAccountUin());
        if (paramPicEmoticonInfo != null)
        {
          paramURLImageView.setImageDrawable(paramPicEmoticonInfo);
          paramURLImageView.setBackgroundDrawable(null);
          return;
        }
      }
    }
    catch (MalformedURLException paramPicEmoticonInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "updateImageView ,", paramPicEmoticonInfo);
        }
        paramPicEmoticonInfo = null;
        continue;
        paramURLImageView.setVisibility(4);
        continue;
        paramPicEmoticonInfo = null;
      }
    }
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "updateUI");
    }
    if ((paramView == null) || (paramEmotionPanelData == null)) {
      return;
    }
    if ((paramEmotionPanelData instanceof EmoticonInfo)) {}
    for (paramEmotionPanelData = (PicEmoticonInfo)paramEmotionPanelData;; paramEmotionPanelData = null)
    {
      if (paramEmotionPanelData == null)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView.setVisibility(0);
      paramView.setTag(paramEmotionPanelData);
      Object localObject1 = (URLImageView)paramView.findViewById(2131365977);
      ((URLImageView)localObject1).setVisibility(0);
      updateImageView((URLImageView)localObject1, paramEmotionPanelData);
      Object localObject2 = (TextView)paramView.findViewById(2131365982);
      ImageView localImageView = (ImageView)paramView.findViewById(2131365984);
      localObject1 = (ImageView)paramView.findViewById(2131365983);
      paramView = (ProgressBar)paramView.findViewById(2131365981);
      if ("push".equals(paramEmotionPanelData.action))
      {
        ((TextView)localObject2).setVisibility(8);
        localImageView.setVisibility(8);
        ((ImageView)localObject1).setVisibility(8);
        paramView.setVisibility(8);
        return;
      }
      paramEmotionPanelData = paramEmotionPanelData.emoticon;
      if ((paramEmotionPanelData == null) || (TextUtils.isEmpty(paramEmotionPanelData.epId)))
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotion is null or epid is null");
        return;
      }
      String str = paramEmotionPanelData.name;
      if (!TextUtils.isEmpty(str))
      {
        ((TextView)localObject2).setVisibility(0);
        if (str.length() > 5)
        {
          ((TextView)localObject2).setText(str.substring(0, 4) + "...");
          if (AppSetting.c) {
            ((TextView)localObject2).setContentDescription(str);
          }
          label269:
          localImageView.setVisibility(8);
          ((ImageView)localObject1).setVisibility(8);
          localObject2 = ((avsq)this.app.getManager(14)).a(paramEmotionPanelData.epId);
          if ((localObject2 != null) && (!((EmoticonPackage)localObject2).valid))
          {
            ((ImageView)localObject1).setImageResource(2130847032);
            ((ImageView)localObject1).setVisibility(0);
          }
          paramView.setVisibility(8);
          paramView.setTag(paramEmotionPanelData.epId);
          if (!this.proBars.contains(paramView)) {
            this.proBars.add(paramView);
          }
          if (((areb)this.app.getManager(43)).a(paramEmotionPanelData.epId) < 0.0F) {
            break label425;
          }
        }
      }
      label425:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label430;
        }
        paramView.setVisibility(0);
        return;
        ((TextView)localObject2).setText(str);
        break;
        ((TextView)localObject2).setVisibility(8);
        break label269;
      }
      label430:
      paramView.setVisibility(8);
      return;
    }
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (MagicFaceAdapter.MagicFaceViewHolder)paramViewHolder;
    int i;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "getEmotionView position = " + paramInt + ";view from infalter");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext);
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
            paramViewHolder = getMagicView();
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, -1);
            paramViewHolder.setGravity(17);
            paramViewHolder.setVisibility(8);
            paramViewHolder.setLayoutParams(localLayoutParams);
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
        QLog.d("MagicFaceAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
      recycleView(this.panelType, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.contentViews = new RelativeLayout[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        paramViewGroup.contentViews[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
      i = j;
    }
    for (;;)
    {
      try
      {
        if (i < this.columnNum)
        {
          j = this.columnNum * paramInt + i;
          if (j > this.data.size() - 1)
          {
            paramViewGroup.contentViews[i].setTag(null);
            paramViewGroup.contentViews[i].setVisibility(8);
          }
          else
          {
            updateUI(paramViewGroup.contentViews[i], (EmotionPanelData)this.data.get(j));
          }
        }
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI oom");
      }
      return paramViewHolder;
      paramViewHolder = paramView;
      i = j;
      continue;
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
      paramMessage = getProgressBarByEp((EmoticonPackage)paramMessage.obj);
      if (paramMessage != null)
      {
        paramMessage.setVisibility(0);
        continue;
        ProgressBar localProgressBar = getProgressBarByEp((EmoticonPackage)paramMessage.obj);
        int i = paramMessage.arg1;
        if (localProgressBar != null)
        {
          localProgressBar.setVisibility(8);
          if (i == 0) {
            refreshPanelData();
          }
        }
      }
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new MagicFaceAdapter.MagicFaceViewHolder();
  }
  
  public void packageDownloadEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "packageDownloadEnd");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramEmoticonPackage;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void packageDownloadStart(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "packageDownloadStart");
    }
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
      QLog.d("MagicFaceAdapter", 2, "refreshPanelData");
    }
    EmotionPanelDataBuilder.getInstance().AsyncGetEmotionPanelData(this.app, this.panelType, null, -1, 0, false, new MagicFaceAdapter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.MagicFaceAdapter
 * JD-Core Version:    0.7.0.1
 */