package com.tencent.mobileqq.doutu;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.doutu.api.IDoutuEmotionAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class DoutuEmotionAdapter
  extends BaseAdapter
  implements View.OnClickListener, IDoutuEmotionAdapter
{
  public static int a = 4;
  private float jdField_a_of_type_Float;
  public long a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  public DoutuData a;
  public DoutuItem a;
  public IDoutuListener a;
  public String a;
  public HashMap<String, String> a;
  public List<DoutuData> a;
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private DoutuData jdField_b_of_type_ComTencentMobileqqDoutuDoutuData;
  public String b;
  public List<DoutuData> b;
  private int c;
  public String c;
  private int d;
  private int e;
  private int f;
  
  public DoutuEmotionAdapter(BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity, IDoutuListener paramIDoutuListener, String paramString1, String paramString2, String paramString3, MqqHandler paramMqqHandler, boolean paramBoolean, DoutuItem paramDoutuItem, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = false;
    this.f = -1;
    this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData = new DoutuData("abababababababababababab", null);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener = new DoutuEmotionAdapter.1(this);
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener = paramIDoutuListener;
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem = paramDoutuItem;
    if (paramBoolean)
    {
      paramBaseQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem;
      if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramBaseQQAppInterface.jdField_b_of_type_JavaLangString)))
      {
        paramBoolean = true;
        break label137;
      }
    }
    paramBoolean = false;
    label137:
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((paramInt > 0) && (this.jdField_a_of_type_Boolean)) {
      jdField_a_of_type_Int = paramInt;
    }
    if (!this.jdField_a_of_type_Boolean) {
      jdField_a_of_type_Int = 9;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramInt = i;
    while (paramInt < jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_JavaUtilList.add(new DoutuData());
      paramInt += 1;
    }
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = Utils.a(80.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources());
    this.jdField_c_of_type_Int = Utils.a(80.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources());
    this.d = Utils.a(70.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources());
    this.e = Utils.a(70.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoutuEmotionAdapter", 2, "[doutu]resetData");
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    } else {
      localList.clear();
    }
    localList = this.jdField_b_of_type_JavaUtilList;
    int k = 0;
    int j = 0;
    int i = k;
    if (localList != null)
    {
      i = k;
      if (localList.size() > 0)
      {
        i = j;
        while ((i < jdField_a_of_type_Int) && (i < this.jdField_b_of_type_JavaUtilList.size()))
        {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
          i += 1;
        }
      }
    }
    while (i < 9)
    {
      this.jdField_a_of_type_JavaUtilList.add(new DoutuData());
      i += 1;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localList = this.jdField_b_of_type_JavaUtilList;
      if ((localList != null) && (localList.size() > 0))
      {
        j = this.jdField_b_of_type_JavaUtilList.size();
        i = jdField_a_of_type_Int;
        if (j < i) {
          i = this.jdField_b_of_type_JavaUtilList.size();
        }
        this.f = i;
        this.jdField_b_of_type_JavaUtilList.add(this.f, this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData);
        this.jdField_a_of_type_JavaUtilList.add(this.f, this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong != this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeLoading key:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", timeKey:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        QLog.e("DoutuEmotionAdapter", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (this.jdField_b_of_type_JavaUtilList != null))
    {
      int j = ((List)localObject).size();
      this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData);
      localObject = new ArrayList();
      int i = 0;
      while ((i < j) && (i < this.jdField_b_of_type_JavaUtilList.size()))
      {
        ((List)localObject).add(this.jdField_b_of_type_JavaUtilList.get(i));
        i += 1;
      }
      a((List)localObject);
    }
    this.f = -1;
  }
  
  public void a(List<DoutuData> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void a(List<DoutuData> paramList, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addSmartPicList removeEmptyData:");
      localStringBuilder.append(paramBoolean);
      QLog.i("DoutuEmotionAdapter", 2, localStringBuilder.toString());
    }
    if (paramLong != this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("addSmartPicList key:");
        paramList.append(paramLong);
        paramList.append(", timeKey:");
        paramList.append(this.jdField_a_of_type_Long);
        QLog.e("DoutuEmotionAdapter", 2, paramList.toString());
      }
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList != null) && (paramList != null))
    {
      int j = paramList.size();
      int i = this.f;
      if (i > 0)
      {
        this.jdField_b_of_type_JavaUtilList.addAll(i, paramList);
        this.f += paramList.size();
      }
      int k = this.jdField_a_of_type_JavaUtilList.size();
      paramList = new ArrayList();
      i = 0;
      while ((i < k + j) && (i < this.jdField_b_of_type_JavaUtilList.size()))
      {
        if ((!paramBoolean) || (((DoutuData)this.jdField_b_of_type_JavaUtilList.get(i)).picMd5 == null) || (!((DoutuData)this.jdField_b_of_type_JavaUtilList.get(i)).picMd5.equalsIgnoreCase("abababababababababababab"))) {
          paramList.add(this.jdField_b_of_type_JavaUtilList.get(i));
        }
        i += 1;
      }
      if (paramBoolean)
      {
        this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData);
        this.f = -1;
      }
      a(paramList);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("addSmartPicList list:");
      paramList.append(this.jdField_a_of_type_JavaUtilList);
      paramList.append(", listAll:");
      paramList.append(this.jdField_b_of_type_JavaUtilList);
      QLog.e("DoutuEmotionAdapter", 2, paramList.toString());
    }
  }
  
  public void b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (this.jdField_b_of_type_JavaUtilList != null))
    {
      int j = localList.size();
      int k = this.jdField_b_of_type_JavaUtilList.size();
      if (j >= k) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      int i = 0;
      while ((i < k) && (i < jdField_a_of_type_Int + j))
      {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
        i += 1;
      }
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = null;
    if (paramInt >= i)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get view position exception , position = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",size = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.e("DoutuEmotionAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    DoutuData localDoutuData;
    for (;;)
    {
      localObject1 = localURLDrawableOptions;
      Object localObject2 = paramView;
      break label711;
      localDoutuData = (DoutuData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localDoutuData == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getView emoticon empty position = ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.e("DoutuEmotionAdapter", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        if ((paramView != null) && (paramView.getTag() != null))
        {
          localObject1 = (DoutuEmotionAdapter.ViewHolder)paramView.getTag();
        }
        else
        {
          localObject1 = new DoutuEmotionAdapter.ViewHolder(null);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
          paramView = new ViewGroup.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
          paramView = new RelativeLayout.LayoutParams(this.d, this.e);
          paramView.addRule(13, -1);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView, paramView);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839401));
          float f1 = this.jdField_a_of_type_Float;
          paramView = new RelativeLayout.LayoutParams((int)(f1 * 30.0F), (int)(f1 * 30.0F));
          paramView.addRule(13, -1);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar, paramView);
          paramView = ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
          paramView.setTag(localObject1);
        }
        ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDoutuDoutuData = localDoutuData;
        ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_Int = paramInt;
        ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if (localDoutuData.thumbDownUrl == null) {
          break label693;
        }
        try
        {
          localObject2 = new URL(localDoutuData.thumbDownUrl);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getView url exception e = ");
          ((StringBuilder)localObject4).append(localMalformedURLException.getMessage());
          QLog.e("DoutuEmotionAdapter", 1, ((StringBuilder)localObject4).toString());
          localObject3 = null;
        }
        if (localObject3 != null) {
          break;
        }
        QLog.e("DoutuEmotionAdapter", 1, "getView url = null");
      }
    }
    localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject4 = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mExtraInfo = localDoutuData;
    Object localObject3 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
    if (((URLDrawable)localObject3).getStatus() != 1)
    {
      ((URLDrawable)localObject3).setTag(localDoutuData);
      ((URLDrawable)localObject3).addHeader("my_uin", this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getAccount());
      if ((((URLDrawable)localObject3).getStatus() == 2) || (((URLDrawable)localObject3).getStatus() == 3)) {
        ((URLDrawable)localObject3).restartDownload();
      }
    }
    else
    {
      ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localDoutuData.picMd5, localDoutuData.picDownUrl);
    }
    ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject3);
    ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
    ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setTag(localObject1);
    ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
    ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
    paramView.setOnClickListener(this);
    break label705;
    label693:
    ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    label705:
    localObject3 = paramView;
    Object localObject1 = paramView;
    label711:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject3, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof DoutuEmotionAdapter.ViewHolder))) {
      localObject1 = (DoutuEmotionAdapter.ViewHolder)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      DoutuData localDoutuData = ((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDoutuDoutuData;
      if ((localDoutuData != null) && (localDoutuData.thumbDownUrl != null))
      {
        Object localObject2 = (URLDrawable)((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
        if (localObject2 != null)
        {
          localObject2 = ((URLDrawable)localObject2).getFileInLocal();
          if (localObject2 != null)
          {
            localObject2 = ((File)localObject2).getPath();
            IDoutuListener localIDoutuListener = this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener;
            if (localIDoutuListener != null) {
              localIDoutuListener.a((String)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, localDoutuData, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X8007FAB", "0X8007FAB", 0, 0, "", String.valueOf(((DoutuEmotionAdapter.ViewHolder)localObject1).jdField_a_of_type_Int + 1), localDoutuData.picMd5, localDoutuData.picDownUrl);
            this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData = localDoutuData;
            localObject1 = this.jdField_a_of_type_MqqOsMqqHandler;
            if (localObject1 != null) {
              ((MqqHandler)localObject1).obtainMessage(80).sendToTarget();
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */