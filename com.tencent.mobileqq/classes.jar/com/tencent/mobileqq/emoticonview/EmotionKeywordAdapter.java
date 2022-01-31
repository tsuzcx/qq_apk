package com.tencent.mobileqq.emoticonview;

import acfm;
import acfn;
import acfo;
import acfq;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ApngHandler;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class EmotionKeywordAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener
{
  public static Rect a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  EditText jdField_a_of_type_AndroidWidgetEditText;
  URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new acfn(this);
  URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new acfm(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  public List a;
  private int jdField_b_of_type_Int;
  private List jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int;
  private List jdField_c_of_type_JavaUtilList = new ArrayList();
  private int jdField_d_of_type_Int;
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  private List e;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public EmotionKeywordAdapter(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.e = new ArrayList();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * 77.0F));
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 80.0F));
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Float * 65.0F));
    this.jdField_d_of_type_Int = ((int)(this.jdField_a_of_type_Float * 65.0F));
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)paramQQAppInterface.getManager(13));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a()
  {
    int i = 1;
    int j = NetworkUtil.a(BaseApplication.getContext());
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
  
  private boolean a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_c_of_type_JavaUtilList);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        if (localArrayList.contains(this.jdField_a_of_type_JavaUtilList.get(i))) {
          localArrayList.remove(this.jdField_a_of_type_JavaUtilList.get(i));
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
        QLog.d("EmotionKeywordAdapter", 2, "isShowEmotionKeywordLayout showLayout = " + bool + ",keyword = " + this.jdField_a_of_type_JavaLangString);
      }
      return bool;
    }
  }
  
  private void e()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() < 1)) {
      QLog.e("EmotionKeywordAdapter", 1, "getFirstSreenData data error, keyword = " + this.jdField_a_of_type_JavaLangString);
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_JavaUtilList.size() < 5) {}
      for (this.jdField_c_of_type_JavaUtilList = new ArrayList(this.jdField_b_of_type_JavaUtilList); QLog.isColorLevel(); this.jdField_c_of_type_JavaUtilList = new ArrayList(this.jdField_b_of_type_JavaUtilList.subList(0, 5)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFirstScreenData: keyword = ").append(this.jdField_a_of_type_JavaLangString).append(":");
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
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
  
  private void f()
  {
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() < 1)) {
      QLog.e("EmotionKeywordAdapter", 1, "downloadFirstScreenDrawable data error keyword = " + this.jdField_a_of_type_JavaLangString);
    }
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFirstScreenDrawable : local success , keyword = " + this.jdField_a_of_type_JavaLangString + ":");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
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
            localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            localURLDrawableOptions.mPlayGifImage = true;
            Object localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            ((URLDrawable)localObject).setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
            ((URLDrawable)localObject).setTag(localEmoticon);
            if (((URLDrawable)localObject).getStatus() != 1)
            {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
              ((URLDrawable)localObject).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              ((URLDrawable)localObject).addHeader("emo_big", "true");
              ((URLDrawable)localObject).startDownload();
            }
            else
            {
              if (!this.jdField_a_of_type_JavaUtilList.contains(localEmoticon)) {
                this.jdField_a_of_type_JavaUtilList.add(localEmoticon);
              }
              localStringBuilder.append(";epId = ").append(localEmoticon.epId).append(",eid = ").append(localEmoticon.eId);
            }
          }
        }
      }
      a();
    } while (!QLog.isColorLevel());
    QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
  }
  
  public void a()
  {
    if ((a()) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(69));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "showEmotionKeywordLayout isshow = " + bool + ",keyword = " + this.jdField_a_of_type_JavaLangString + ",inputstring = " + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List paramList)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    this.jdField_c_of_type_JavaUtilList.clear();
    e();
    f();
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
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(paramString))) {}
    while (!paramBoolean) {
      return;
    }
    ThreadManager.post(new acfo(this, paramEmoticonResp, paramString), 5, null, true);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "resetExposeList");
    }
    this.e.clear();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "resetLoadFinishData");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "reportExposeData, keyword = " + this.jdField_a_of_type_JavaLangString);
    }
    int k = this.jdField_d_of_type_JavaUtilList.size();
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
        localEmoticon = (Emoticon)this.jdField_d_of_type_JavaUtilList.get(j);
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate", 0, 0, a() + "", "", localStringBuilder1.toString(), this.jdField_a_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_2", 0, 0, a() + "", "", localStringBuilder2.toString(), this.jdField_a_of_type_JavaLangString);
      if (localStringBuilder3.length() > 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate", 0, 0, a() + "", "", localStringBuilder3.toString(), this.jdField_a_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_2", 0, 0, a() + "", "", localStringBuilder4.toString(), this.jdField_a_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "reportExposeData : keyword = " + this.jdField_a_of_type_JavaLangString + "fistReportItem = " + localStringBuilder1.toString() + ";secondReportItem = " + localStringBuilder3 + ";fistEpReportItem = " + localStringBuilder2.toString() + ";secondEpReportItem = " + localStringBuilder4);
      }
      this.jdField_d_of_type_JavaUtilList.clear();
    }
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt >= this.jdField_b_of_type_JavaUtilList.size())
    {
      QLog.e("EmotionKeywordAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.jdField_b_of_type_JavaUtilList.size());
      return null;
    }
    if (paramView == null)
    {
      paramViewGroup = new acfq(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = new EmojiStickerManager.EmotionKeywordLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      paramView.addRule(13, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838596));
      paramView = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 30.0F), (int)(this.jdField_a_of_type_Float * 30.0F));
      paramView.addRule(13, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar, paramView);
      paramView = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(paramViewGroup);
    }
    Emoticon localEmoticon;
    for (;;)
    {
      localEmoticon = (Emoticon)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      if (localEmoticon != null) {
        break;
      }
      QLog.e("EmotionKeywordAdapter", 1, "getView emoticon empty position = " + paramInt);
      return null;
      paramViewGroup = (acfq)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
    paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    if (!paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId.equals("NONE"))
    {
      Object localObject1 = new EmotionKeyword();
      ((EmotionKeyword)localObject1).epId = localEmoticon.epId;
      ((EmotionKeyword)localObject1).eId = localEmoticon.eId;
      ((EmotionKeyword)localObject1).keyword = this.jdField_a_of_type_JavaLangString;
      if (!this.e.contains(localObject1))
      {
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b((EmotionKeyword)localObject1, false);
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a((EmotionKeyword)localObject1, false);
        this.e.add(localObject1);
      }
      if (!this.jdField_d_of_type_JavaUtilList.contains(localEmoticon)) {
        this.jdField_d_of_type_JavaUtilList.add(localEmoticon);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      try
      {
        localObject1 = new URL("emotion_pic", "fromAIO", localEmoticon.epId + "_" + localEmoticon.eId);
        if (localObject1 == null)
        {
          QLog.e("EmotionKeywordAdapter", 1, "getView url = null");
          return null;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("EmotionKeywordAdapter", 1, "getView url exception e = " + localMalformedURLException.getMessage());
          localObject2 = null;
        }
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        if (localEmoticon.isAPNG)
        {
          if (!ApngHandler.b.get()) {
            break label777;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EmotionKeywordAdapter", 2, "getView: APNG so loaded use apng image");
          }
          localURLDrawableOptions.mUseApngImage = true;
          localURLDrawableOptions.mPlayGifImage = false;
          localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
        }
      }
      Object localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
      if (((URLDrawable)localObject2).getStatus() != 1)
      {
        ((URLDrawable)localObject2).setTag(localEmoticon);
        ((URLDrawable)localObject2).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        ((URLDrawable)localObject2).addHeader("emo_big", "true");
        if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(localEmoticon.name);
        paramView.setOnClickListener(this);
        paramView.setOnLongClickListener(this);
        return paramView;
        label777:
        if (!ApngHandler.c())
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionKeywordAdapter", 2, "getView: restartDownload so");
          }
          ApngHandler localApngHandler = (ApngHandler)((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a("qq.android.native.apng_v700");
          if (localApngHandler == null) {
            break;
          }
          localApngHandler.a(true);
          break;
        }
        ApngHandler.d_();
        break;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      }
    }
    paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof acfq))) {}
    for (paramView = (acfq)paramView;; paramView = null)
    {
      if (paramView == null) {}
      do
      {
        do
        {
          return;
          paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
        } while ((paramView == null) || (paramView.epId.equals("NONE")));
        EmotionKeyword localEmotionKeyword = new EmotionKeyword();
        localEmotionKeyword.epId = paramView.epId;
        localEmotionKeyword.eId = paramView.eId;
        localEmotionKeyword.keyword = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(localEmotionKeyword, true);
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(localEmotionKeyword, true);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionKeywordAdapter", 2, "onClick , " + localEmotionKeyword);
        }
        int i = this.jdField_b_of_type_JavaUtilList.indexOf(paramView) + 1;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate", 0, 0, a() + "", paramView.epId, paramView.eId + "_" + i, this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionKeywordAdapter", 2, "onclick report log : keyword" + this.jdField_a_of_type_JavaLangString + "epId = " + paramView.epId + ",eid = " + paramView.eId + ",index = " + i);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501);
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      }
      for (;;)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
        return;
        QLog.e("EmotionKeywordAdapter", 1, "onClick input == null");
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null) && (EmojiStickerManager.e))
    {
      if ((paramView instanceof EmojiStickerManager.EmotionKeywordLayout)) {
        ((EmojiStickerManager.EmotionKeywordLayout)paramView).a = true;
      }
      paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
      EmojiStickerManager.StickerFrameLayout localStickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(this.jdField_a_of_type_AndroidContentContext);
      localStickerFrameLayout.setId(2131362314);
      URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      localURLImageView.setAdjustViewBounds(false);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      if ((paramView.getTag() instanceof acfq))
      {
        paramView = ((acfq)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqDataEmoticon;
        localURLImageView.setImageDrawable(EmojiStickerManager.a().a(this.jdField_a_of_type_AndroidContentContext, paramView));
        localStickerFrameLayout.setTag(paramView);
      }
      localStickerFrameLayout.addView(localURLImageView);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 20.0F), (int)(this.jdField_a_of_type_Float * 20.0F));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localStickerFrameLayout.addView(paramView, localLayoutParams);
      paramView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843994));
      paramView.setVisibility(4);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 20.0F), (int)(this.jdField_a_of_type_Float * 20.0F));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(12);
      localStickerFrameLayout.addView(paramView, localLayoutParams);
      paramView.setVisibility(4);
      paramView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844951));
      int k = (int)(5.0F * f);
      int i = (int)(110.0F * f);
      int j = (int)(110.0F * f);
      paramView = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      localStickerFrameLayout.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f));
      paramView.height = ((int)(f * 100.0F));
      paramView = new RelativeLayout.LayoutParams(i, j);
      paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (i - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
      k = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
      if (paramView.leftMargin + i > k) {
        paramView.leftMargin = (k - i);
      }
      paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - (j - jdField_a_of_type_AndroidGraphicsRect.height()) / 2 - (int)(15.0F * this.jdField_a_of_type_Float));
      paramView.width = i;
      paramView.height = j;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.addView(localStickerFrameLayout, paramView);
      i = paramView.leftMargin;
      j = paramView.topMargin;
      k = paramView.leftMargin;
      int m = paramView.width;
      int n = paramView.topMargin;
      localStickerFrameLayout.layout(i, j, k + m, paramView.height + n);
      localStickerFrameLayout.requestLayout();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aS();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter
 * JD-Core Version:    0.7.0.1
 */