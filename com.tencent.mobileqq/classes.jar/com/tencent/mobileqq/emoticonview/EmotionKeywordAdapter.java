package com.tencent.mobileqq.emoticonview;

import admh;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import awyr;
import bdla;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class EmotionKeywordAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final int EXPOSE_REPORT_MAX_EID_NUM = 5;
  public static final String TAG = "EmotionKeywordAdapter";
  public static Rect tmp = new Rect();
  private QQAppInterface app;
  private int contentHeight;
  private int contentWidth;
  private List<Emoticon> data;
  private awyr dbManager;
  private float density;
  URLDrawableDownListener drawableListener = new EmotionKeywordAdapter.1(this);
  private List<Emoticon> exposeReportData = new ArrayList();
  private List<EmotionKeyword> exposedList;
  private List<Emoticon> firstScreenData = new ArrayList();
  URLDrawable.URLDrawableListener firstScreenListener = new EmotionKeywordAdapter.2(this);
  ArrayList<URLDrawable> firstScreenURLDrawable = new ArrayList(5);
  private int imgHeight;
  private int imgWidth;
  EditText input;
  private String keyword;
  public List<Emoticon> loadFinishedData = new ArrayList();
  BaseChatPie mBaseChatPie;
  private Context mContext;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  private SessionInfo sessionInfo;
  
  public EmotionKeywordAdapter(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie)
  {
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.input = paramEditText;
    this.data = new ArrayList();
    this.exposedList = new ArrayList();
    this.density = this.mContext.getResources().getDisplayMetrics().density;
    this.contentWidth = ((int)(this.density * 77.0F));
    this.contentHeight = ((int)(this.density * 80.0F));
    this.imgWidth = ((int)(this.density * 65.0F));
    this.imgHeight = ((int)(this.density * 65.0F));
    this.dbManager = ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER));
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private void downloadFirstScreenDrawable()
  {
    if ((this.firstScreenData == null) || (this.firstScreenData.size() < 1)) {
      QLog.e("EmotionKeywordAdapter", 1, "downloadFirstScreenDrawable data error keyword = " + this.keyword);
    }
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFirstScreenDrawable : local success , keyword = " + this.keyword + ":");
      this.firstScreenURLDrawable.clear();
      Iterator localIterator = this.firstScreenData.iterator();
      while (localIterator.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)localIterator.next();
        if ((localEmoticon != null) && (!"NONE".equals(localEmoticon.epId))) {
          try
          {
            URL localURL = new URL("emotion_pic", "fromAIO", localEmoticon.epId + "_" + localEmoticon.eId);
            if (localURL == null) {
              QLog.e("EmotionKeywordAdapter", 1, "downloadFirstScreenDrawable url = null");
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              QLog.e("EmotionKeywordAdapter", 1, "downloadFirstScreenDrawable url exception e = " + localMalformedURLException.getMessage());
              localObject = null;
            }
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mLoadingDrawable = this.mEmptyDrawable;
            localURLDrawableOptions.mFailedDrawable = this.mEmptyDrawable;
            localURLDrawableOptions.mPlayGifImage = true;
            Object localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            ((URLDrawable)localObject).setURLDrawableListener(this.firstScreenListener);
            ((URLDrawable)localObject).setTag(localEmoticon);
            if (((URLDrawable)localObject).getStatus() != 1)
            {
              this.firstScreenURLDrawable.add(localObject);
              ((URLDrawable)localObject).addHeader("my_uin", this.app.getAccount());
              ((URLDrawable)localObject).addHeader("emo_big", "true");
              ((URLDrawable)localObject).startDownload();
            }
            else
            {
              if (!this.loadFinishedData.contains(localEmoticon)) {
                this.loadFinishedData.add(localEmoticon);
              }
              localStringBuilder.append(";epId = ").append(localEmoticon.epId).append(",eid = ").append(localEmoticon.eId);
            }
          }
        }
      }
      showEmotionKeywordLayout();
    } while (!QLog.isColorLevel());
    QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
  }
  
  private void getFirstScreenData()
  {
    if ((this.data == null) || (this.data.size() < 1)) {
      QLog.e("EmotionKeywordAdapter", 1, "getFirstSreenData data error, keyword = " + this.keyword);
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      return;
      if (this.data.size() < 5) {}
      for (this.firstScreenData = new ArrayList(this.data); QLog.isColorLevel(); this.firstScreenData = new ArrayList(this.data.subList(0, 5)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFirstScreenData: keyword = ").append(this.keyword).append(":");
        Iterator localIterator = this.firstScreenData.iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (localEmoticon != null) {
            localStringBuilder.append("eid=").append(localEmoticon.eId).append(",");
          }
        }
      }
    }
    QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
  }
  
  private int getReportNetType()
  {
    int i = 1;
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (j == 1) {
      i = 0;
    }
    while (j == 4) {
      return i;
    }
    if (j == 3) {
      return 2;
    }
    if (j == 2) {
      return 3;
    }
    return -1;
  }
  
  private boolean needShowEmotionKeywordLayout()
  {
    ArrayList localArrayList = new ArrayList(this.firstScreenData);
    int j = this.loadFinishedData.size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        if (localArrayList.contains(this.loadFinishedData.get(i))) {
          localArrayList.remove(this.loadFinishedData.get(i));
        }
        i += 1;
      }
    }
    if ((localArrayList.size() > 0) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isShowEmotionKeywordLayout not finishData:");
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)localIterator.next();
        if (localEmoticon != null) {
          localStringBuilder.append("eid=").append(localEmoticon.eId).append(",");
        }
      }
      QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
    }
    if (localArrayList.size() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "isShowEmotionKeywordLayout showLayout = " + bool + ",keyword = " + this.keyword);
      }
      return bool;
    }
  }
  
  public int getCount()
  {
    if (this.data == null) {
      return 0;
    }
    return this.data.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.data.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.data.size())
    {
      QLog.e("EmotionKeywordAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.data.size());
      localObject1 = paramView;
      paramView = null;
    }
    Emoticon localEmoticon;
    label357:
    Object localObject3;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (paramView == null)
      {
        localObject1 = new EmotionKeywordAdapter.ViewHolder(null);
        ((EmotionKeywordAdapter.ViewHolder)localObject1).contentLayout = new EmojiStickerManager.EmotionKeywordLayout(this.mContext, this.mBaseChatPie);
        paramView = new ViewGroup.LayoutParams(this.contentWidth, this.contentHeight);
        ((EmotionKeywordAdapter.ViewHolder)localObject1).contentLayout.setLayoutParams(paramView);
        ((EmotionKeywordAdapter.ViewHolder)localObject1).img = new URLImageView(this.mContext);
        paramView = new RelativeLayout.LayoutParams(this.imgWidth, this.imgHeight);
        paramView.addRule(13, -1);
        ((EmotionKeywordAdapter.ViewHolder)localObject1).contentLayout.addView(((EmotionKeywordAdapter.ViewHolder)localObject1).img, paramView);
        ((EmotionKeywordAdapter.ViewHolder)localObject1).progressBar = new ProgressBar(this.mContext);
        ((EmotionKeywordAdapter.ViewHolder)localObject1).progressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130839466));
        paramView = new RelativeLayout.LayoutParams((int)(this.density * 30.0F), (int)(this.density * 30.0F));
        paramView.addRule(13, -1);
        ((EmotionKeywordAdapter.ViewHolder)localObject1).contentLayout.addView(((EmotionKeywordAdapter.ViewHolder)localObject1).progressBar, paramView);
        paramView = ((EmotionKeywordAdapter.ViewHolder)localObject1).contentLayout;
        paramView.setTag(localObject1);
      }
      for (;;)
      {
        localEmoticon = (Emoticon)this.data.get(paramInt);
        if (localEmoticon != null) {
          break label357;
        }
        QLog.e("EmotionKeywordAdapter", 1, "getView emoticon empty position = " + paramInt);
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
        break;
        localObject1 = (EmotionKeywordAdapter.ViewHolder)paramView.getTag();
      }
      ((EmotionKeywordAdapter.ViewHolder)localObject1).emoticon = localEmoticon;
      ((EmotionKeywordAdapter.ViewHolder)localObject1).progressBar.setVisibility(0);
      if (((EmotionKeywordAdapter.ViewHolder)localObject1).emoticon.epId.equals("NONE")) {
        break label847;
      }
      Object localObject2 = new EmotionKeyword();
      ((EmotionKeyword)localObject2).epId = localEmoticon.epId;
      ((EmotionKeyword)localObject2).eId = localEmoticon.eId;
      ((EmotionKeyword)localObject2).keyword = this.keyword;
      if (!this.exposedList.contains(localObject2))
      {
        this.dbManager.b((EmotionKeyword)localObject2, false);
        this.dbManager.a((EmotionKeyword)localObject2, false);
        this.exposedList.add(localObject2);
      }
      if (!this.exposeReportData.contains(localEmoticon)) {
        this.exposeReportData.add(localEmoticon);
      }
      try
      {
        localObject2 = new URL("emotion_pic", "fromAIO", localEmoticon.epId + "_" + localEmoticon.eId);
        if (localObject2 == null)
        {
          QLog.e("EmotionKeywordAdapter", 1, "getView url = null");
          localObject2 = null;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("EmotionKeywordAdapter", 1, "getView url exception e = " + localMalformedURLException.getMessage());
          localObject3 = null;
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = this.mEmptyDrawable;
        localURLDrawableOptions.mFailedDrawable = this.mEmptyDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        if (localEmoticon.isAPNG)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionKeywordAdapter", 2, "getView: APNG so loaded use apng image");
          }
          localURLDrawableOptions.mUseApngImage = true;
          localURLDrawableOptions.mPlayGifImage = false;
          localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
        }
        localObject3 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
        if (((URLDrawable)localObject3).getStatus() == 1) {
          break label835;
        }
      }
    }
    ((URLDrawable)localObject3).setTag(localEmoticon);
    ((URLDrawable)localObject3).addHeader("my_uin", this.app.getAccount());
    ((URLDrawable)localObject3).addHeader("emo_big", "true");
    if ((((URLDrawable)localObject3).getStatus() == 2) || (((URLDrawable)localObject3).getStatus() == 3)) {
      ((URLDrawable)localObject3).restartDownload();
    }
    label753:
    ((EmotionKeywordAdapter.ViewHolder)localObject1).img.setImageDrawable((Drawable)localObject3);
    ((EmotionKeywordAdapter.ViewHolder)localObject1).img.setURLDrawableDownListener(this.drawableListener);
    ((EmotionKeywordAdapter.ViewHolder)localObject1).img.setTag(((EmotionKeywordAdapter.ViewHolder)localObject1).progressBar);
    ((EmotionKeywordAdapter.ViewHolder)localObject1).img.setFocusable(true);
    ((EmotionKeywordAdapter.ViewHolder)localObject1).img.setFocusableInTouchMode(true);
    ((EmotionKeywordAdapter.ViewHolder)localObject1).img.setContentDescription(localEmoticon.name);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
    for (;;)
    {
      localObject1 = paramView;
      break;
      label835:
      ((EmotionKeywordAdapter.ViewHolder)localObject1).progressBar.setVisibility(4);
      break label753;
      label847:
      ((EmotionKeywordAdapter.ViewHolder)localObject1).img.setImageDrawable(this.mEmptyDrawable);
    }
  }
  
  public void handleCloudEmotionForKeywordResp(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(this.keyword)) || (!this.keyword.equals(paramString))) {}
    while (!paramBoolean) {
      return;
    }
    ThreadManager.post(new EmotionKeywordAdapter.3(this, paramEmoticonResp, paramString), 5, null, true);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof EmotionKeywordAdapter.ViewHolder))) {}
    for (localObject = (EmotionKeywordAdapter.ViewHolder)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject = ((EmotionKeywordAdapter.ViewHolder)localObject).emoticon;
        } while ((localObject == null) || (((Emoticon)localObject).epId.equals("NONE")));
        EmotionKeyword localEmotionKeyword = new EmotionKeyword();
        localEmotionKeyword.epId = ((Emoticon)localObject).epId;
        localEmotionKeyword.eId = ((Emoticon)localObject).eId;
        localEmotionKeyword.keyword = this.keyword;
        this.dbManager.b(localEmotionKeyword, true);
        this.dbManager.a(localEmotionKeyword, true);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionKeywordAdapter", 2, "onClick , " + localEmotionKeyword);
        }
        int i = this.data.indexOf(localObject) + 1;
        bdla.b(this.app, "CliOper", "", "", "ep_mall", "Clk_associate", 0, 0, getReportNetType() + "", ((Emoticon)localObject).epId, ((Emoticon)localObject).eId + "_" + i, this.keyword);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionKeywordAdapter", 2, "onclick report log : keyword" + this.keyword + "epId = " + ((Emoticon)localObject).epId + ",eid = " + ((Emoticon)localObject).eId + ",index = " + i);
        }
      } while (this.sessionInfo.curType == 9501);
      if (this.input != null)
      {
        this.input.getEditableText().clear();
        this.input.setText("");
      }
      for (;;)
      {
        admh.a(this.app, this.mContext, this.sessionInfo, (Emoticon)localObject);
        break;
        QLog.e("EmotionKeywordAdapter", 1, "onClick input == null");
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.mBaseChatPie.mAIORootView != null) && (EmojiStickerManager.e))
    {
      if ((paramView instanceof EmojiStickerManager.EmotionKeywordLayout)) {
        ((EmojiStickerManager.EmotionKeywordLayout)paramView).a = true;
      }
      paramView.getGlobalVisibleRect(tmp);
      float f = this.mContext.getResources().getDisplayMetrics().density;
      EmojiStickerManager.StickerFrameLayout localStickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(this.mContext);
      localStickerFrameLayout.setId(2131374197);
      URLImageView localURLImageView = new URLImageView(this.mContext);
      localURLImageView.setAdjustViewBounds(false);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      if ((paramView.getTag() instanceof EmotionKeywordAdapter.ViewHolder))
      {
        paramView = ((EmotionKeywordAdapter.ViewHolder)paramView.getTag()).emoticon;
        localURLImageView.setImageDrawable(EmojiStickerManager.a().a(this.mContext, paramView));
        localStickerFrameLayout.setTag(paramView);
      }
      localStickerFrameLayout.addView(localURLImageView);
      paramView = new ImageView(this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 20.0F), (int)(this.density * 20.0F));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localStickerFrameLayout.addView(paramView, localLayoutParams);
      paramView.setImageDrawable(this.mContext.getResources().getDrawable(2130847177));
      paramView.setVisibility(4);
      paramView = new ImageView(this.mContext);
      localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 20.0F), (int)(this.density * 20.0F));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(12);
      localStickerFrameLayout.addView(paramView, localLayoutParams);
      paramView.setVisibility(4);
      paramView.setImageDrawable(this.mContext.getResources().getDrawable(2130848573));
      int k = (int)(5.0F * f);
      int i = (int)(110.0F * f);
      int j = (int)(110.0F * f);
      paramView = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      localStickerFrameLayout.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f));
      paramView.height = ((int)(f * 100.0F));
      paramView = new RelativeLayout.LayoutParams(i, j);
      paramView.leftMargin = (tmp.left - (i - tmp.width()) / 2);
      k = this.mContext.getResources().getDisplayMetrics().widthPixels;
      if (paramView.leftMargin + i > k) {
        paramView.leftMargin = (k - i);
      }
      paramView.topMargin = (tmp.top - (j - tmp.height()) / 2 - (int)(15.0F * this.density));
      paramView.width = i;
      paramView.height = j;
      this.mBaseChatPie.mAIORootView.addView(localStickerFrameLayout, paramView);
      i = paramView.leftMargin;
      j = paramView.topMargin;
      k = paramView.leftMargin;
      int m = paramView.width;
      int n = paramView.topMargin;
      localStickerFrameLayout.layout(i, j, k + m, paramView.height + n);
      localStickerFrameLayout.requestLayout();
      this.mBaseChatPie.setEmotionLayoutInvisible();
    }
    return true;
  }
  
  public void reportExposeData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "reportExposeData, keyword = " + this.keyword);
    }
    int k = this.exposeReportData.size();
    if (k > 0)
    {
      int i;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      StringBuilder localStringBuilder3;
      StringBuilder localStringBuilder4;
      int j;
      label94:
      Emoticon localEmoticon;
      if (k > 5)
      {
        i = 5;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder3 = new StringBuilder();
        localStringBuilder4 = new StringBuilder();
        j = 0;
        if (j >= k) {
          break label224;
        }
        localEmoticon = (Emoticon)this.exposeReportData.get(j);
        if (j >= i) {
          break label176;
        }
        localStringBuilder1.append(localEmoticon.eId);
        localStringBuilder2.append(localEmoticon.epId);
        if (j < i - 1)
        {
          localStringBuilder1.append("_");
          localStringBuilder2.append("_");
        }
      }
      for (;;)
      {
        j += 1;
        break label94;
        i = k;
        break;
        label176:
        localStringBuilder3.append(localEmoticon.eId);
        localStringBuilder4.append(localEmoticon.epId);
        if (j < k - 1)
        {
          localStringBuilder3.append("_");
          localStringBuilder4.append("_");
        }
      }
      label224:
      bdla.b(this.app, "CliOper", "", "", "ep_mall", "View_associate", 0, 0, getReportNetType() + "", "", localStringBuilder1.toString(), this.keyword);
      bdla.b(this.app, "CliOper", "", "", "ep_mall", "View_associate_2", 0, 0, getReportNetType() + "", "", localStringBuilder2.toString(), this.keyword);
      if (localStringBuilder3.length() > 0)
      {
        bdla.b(this.app, "CliOper", "", "", "ep_mall", "View_associate", 0, 0, getReportNetType() + "", "", localStringBuilder3.toString(), this.keyword);
        bdla.b(this.app, "CliOper", "", "", "ep_mall", "View_associate_2", 0, 0, getReportNetType() + "", "", localStringBuilder4.toString(), this.keyword);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "reportExposeData : keyword = " + this.keyword + "fistReportItem = " + localStringBuilder1.toString() + ";secondReportItem = " + localStringBuilder3 + ";fistEpReportItem = " + localStringBuilder2.toString() + ";secondEpReportItem = " + localStringBuilder4);
      }
      this.exposeReportData.clear();
    }
  }
  
  public void resetExposeList()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "resetExposeList");
    }
    this.exposedList.clear();
  }
  
  public void resetLoadFinishData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "resetLoadFinishData");
    }
    this.loadFinishedData.clear();
  }
  
  public void setData(List<Emoticon> paramList)
  {
    this.data.clear();
    this.data.addAll(paramList);
    this.firstScreenData.clear();
    getFirstScreenData();
    downloadFirstScreenDrawable();
    notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setData:");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)paramList.next();
        if (localEmoticon != null) {
          localStringBuilder.append("eid=").append(localEmoticon.eId).append(",");
        }
      }
      QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
    }
  }
  
  public void setKeyword(String paramString)
  {
    this.keyword = paramString;
  }
  
  public void showEmotionKeywordLayout()
  {
    if ((needShowEmotionKeywordLayout()) && (this.keyword.equals(this.input.getText().toString())))
    {
      MqqHandler localMqqHandler = this.app.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(69));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "showEmotionKeywordLayout isshow = " + bool + ",keyword = " + this.keyword + ",inputstring = " + this.input.getText().toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter
 * JD-Core Version:    0.7.0.1
 */