package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.Adapter;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReadinjoySPEventReport$UserOptInfo
  implements AbsListView.OnScrollListener
{
  public int a;
  public long a;
  private SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ReadinjoySPEventReport.ScreenFeedsInfo jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo;
  public ArrayList<Long> a;
  private HashMap<Long, ReadinjoySPEventReport.ArticleExposureInfoForReport> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  public long b;
  private ReadinjoySPEventReport.ScreenFeedsInfo jdField_b_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo;
  public ArrayList<Long> b;
  private HashMap<Long, Float> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_c_of_type_Int;
  public long c;
  private ArrayList<ReadinjoySPEventReport.ScrollStep> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d;
  public long d;
  private int e;
  public long e;
  private int f = 0;
  
  public ReadinjoySPEventReport$UserOptInfo(ReadinjoySPEventReport paramReadinjoySPEventReport)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private ReadinjoySPEventReport.ScreenFeedsInfo a(AbsListView paramAbsListView)
  {
    if (paramAbsListView != null)
    {
      if (paramAbsListView.getChildCount() <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int k = paramAbsListView.getFirstVisiblePosition();
      int i = 0;
      while (i < paramAbsListView.getChildCount())
      {
        Object localObject = a(paramAbsListView, k + i);
        if ((!(localObject instanceof AdvertisementInfo)) && ((localObject instanceof BaseArticleInfo)))
        {
          View localView = paramAbsListView.getChildAt(i);
          if (localView.getHeight() > 0)
          {
            int j;
            if (localView.getBottom() > paramAbsListView.getHeight()) {
              j = paramAbsListView.getHeight();
            } else {
              j = localView.getBottom();
            }
            float f1;
            if (localView.getTop() > 0)
            {
              f1 = (j - localView.getTop()) * 1.0F;
              j = localView.getHeight();
            }
            else
            {
              f1 = j * 1.0F;
              j = localView.getHeight();
            }
            f1 /= j;
            if (f1 > 0.0F) {
              localArrayList.add(new Pair((AbsBaseArticleInfo)localObject, Float.valueOf(f1)));
            }
          }
        }
        i += 1;
      }
      paramAbsListView = new ReadinjoySPEventReport.ScreenFeedsInfo(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport, null);
      paramAbsListView.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      paramAbsListView.jdField_a_of_type_Long = System.currentTimeMillis();
      long l1;
      long l2;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo == null)
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_d_of_type_Long;
      }
      else
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo.jdField_a_of_type_Long;
      }
      paramAbsListView.jdField_b_of_type_Long = (l1 - l2);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo = paramAbsListView;
      QLog.d("ReadinjoySPEventReport", 2, new Object[] { paramAbsListView });
      return paramAbsListView;
    }
    return null;
  }
  
  private ReadinjoySPEventReport.ScrollStep a(AbsListView paramAbsListView)
  {
    ReadinjoySPEventReport.ScrollStep localScrollStep = new ReadinjoySPEventReport.ScrollStep();
    localScrollStep.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
    localScrollStep.f = this.jdField_c_of_type_Int;
    int i = this.jdField_d_of_type_Int;
    int j = this.f;
    if (i - j > 0) {
      i -= j;
    } else {
      i = 0;
    }
    localScrollStep.g = i;
    localScrollStep.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
    localScrollStep.jdField_a_of_type_Long = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
    localScrollStep.h = this.f;
    localScrollStep.i = paramAbsListView.getWidth();
    paramAbsListView = (ReadInJoyXListView)paramAbsListView;
    localScrollStep.jdField_a_of_type_ArrayOfFloat = ((float[])paramAbsListView.jdField_a_of_type_ArrayOfFloat.clone());
    localScrollStep.b = ((float[])paramAbsListView.b.clone());
    return localScrollStep;
  }
  
  private Object a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView != null) && (paramInt >= 0))
    {
      if (paramAbsListView.getAdapter() == null) {
        return null;
      }
      paramAbsListView = paramAbsListView.getAdapter();
      if (paramInt >= paramAbsListView.getCount()) {
        return null;
      }
      try
      {
        paramAbsListView = paramAbsListView.getItem(paramInt);
        return paramAbsListView;
      }
      catch (Exception paramAbsListView)
      {
        paramAbsListView.printStackTrace();
      }
    }
    return null;
  }
  
  private void b()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  public String a()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values());
    Collections.sort((List)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((ReadinjoySPEventReport.ArticleExposureInfoForReport)((Iterator)localObject).next());
      localStringBuilder.append("|");
    }
    if (localStringBuilder.length() == 0) {
      return "nil";
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void a(int paramInt, AbsListView paramAbsListView)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFirstScreenArticleList from : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder = new StringBuilder(localStringBuilder.toString());
      if ((paramAbsListView != null) && (paramAbsListView.getChildCount() > 0) && (this.jdField_d_of_type_Long != 0L))
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          int i = this.jdField_a_of_type_Int;
          if ((i & paramInt) != 0) {
            return;
          }
        }
        if ((paramInt & 0x2) != 0)
        {
          boolean bool = this.jdField_a_of_type_Boolean;
          if (!bool) {
            return;
          }
          this.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Int = (paramInt | this.jdField_a_of_type_Int);
        paramAbsListView = a(paramAbsListView);
        if (paramAbsListView == null) {
          return;
        }
        a(paramAbsListView);
        this.jdField_a_of_type_JavaUtilArrayList = paramAbsListView.a();
        localStringBuilder.append(paramAbsListView);
        QLog.d("ReadinjoySPEventReport", 2, new Object[] { localStringBuilder });
        return;
      }
      return;
    }
    finally {}
  }
  
  public void a(View paramView, AbsListView paramAbsListView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramView != null) && (paramAbsBaseArticleInfo != null))
    {
      if (paramAbsListView == null) {
        return;
      }
      float f1 = paramView.getHeight() / 2.0F;
      float f2 = paramView.getTop();
      float f3 = paramAbsListView.getHeight();
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramAbsBaseArticleInfo.mArticleID), Float.valueOf((f2 + f1) / f3));
    }
  }
  
  public void a(ReadinjoySPEventReport.ScreenFeedsInfo paramScreenFeedsInfo)
  {
    if (paramScreenFeedsInfo != null)
    {
      if (this.jdField_d_of_type_Long == 0L) {
        return;
      }
      Iterator localIterator = paramScreenFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Pair)localIterator.next();
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Pair)localObject).first;
        long l1 = paramScreenFeedsInfo.jdField_b_of_type_Long;
        float f1 = ((Float)((Pair)localObject).second).floatValue();
        ReadinjoySPEventReport.ArticleExposureInfoForReport localArticleExposureInfoForReport = (ReadinjoySPEventReport.ArticleExposureInfoForReport)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localAbsBaseArticleInfo.mArticleID));
        localObject = localArticleExposureInfoForReport;
        if (localArticleExposureInfoForReport == null)
        {
          localObject = new ReadinjoySPEventReport.ArticleExposureInfoForReport(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport, null);
          ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_a_of_type_Long = localAbsBaseArticleInfo.mRecommendSeq;
          ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_b_of_type_Long = localAbsBaseArticleInfo.mArticleID;
          ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_a_of_type_JavaLangString = localAbsBaseArticleInfo.mTitle;
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localAbsBaseArticleInfo.mArticleID), localObject);
        }
        long l2 = ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_c_of_type_Long;
        if (f1 <= 0.8F) {
          l1 = 0L;
        }
        ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_c_of_type_Long = (l2 + l1);
        ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_a_of_type_Float = Math.max(((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_a_of_type_Float, f1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l = this.jdField_d_of_type_Long;
      if (l == 0L) {
        l = System.currentTimeMillis();
      }
      this.jdField_d_of_type_Long = l;
      return;
    }
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo;
    ArrayList localArrayList = null;
    if (localObject1 != null) {
      localObject1 = ((ReadinjoySPEventReport.ScreenFeedsInfo)localObject1).a();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo;
    if (localObject2 != null) {
      localArrayList = ((ReadinjoySPEventReport.ScreenFeedsInfo)localObject2).a();
    }
    localObject2 = new StringBuilder("exposure info : \n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ReadinjoySPEventReport.ArticleExposureInfoForReport localArticleExposureInfoForReport = (ReadinjoySPEventReport.ArticleExposureInfoForReport)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);
      if (localArticleExposureInfoForReport != null)
      {
        localArticleExposureInfoForReport.jdField_a_of_type_Int = 1;
        if (this.jdField_a_of_type_JavaUtilArrayList.contains(localLong)) {
          localArticleExposureInfoForReport.jdField_a_of_type_Int = 0;
        } else if ((localObject1 != null) && (((List)localObject1).contains(localLong))) {
          localArticleExposureInfoForReport.jdField_a_of_type_Int = 2;
        }
        if (this.jdField_b_of_type_JavaUtilArrayList.contains(localLong)) {
          localArticleExposureInfoForReport.jdField_a_of_type_Boolean = true;
        }
        if ((localArrayList != null) && (localArrayList.contains(localLong))) {
          localArticleExposureInfoForReport.jdField_b_of_type_Boolean = true;
        }
        if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localLong)) {
          localArticleExposureInfoForReport.jdField_b_of_type_JavaLangString = String.format("%.2f", new Object[] { this.jdField_b_of_type_JavaUtilHashMap.get(localLong) });
        }
        ((StringBuilder)localObject2).append(localArticleExposureInfoForReport.toString());
        ((StringBuilder)localObject2).append("\n");
      }
    }
    QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport;
    ((ReadinjoySPEventReport)localObject1).b = this;
    ((ReadinjoySPEventReport)localObject1).a = new UserOptInfo((ReadinjoySPEventReport)localObject1);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      localStringBuilder.append(((ReadinjoySPEventReport.ScrollStep)this.jdField_c_of_type_JavaUtilArrayList.get(i)).a());
      localStringBuilder.append("|");
      i += 1;
    }
    if (localStringBuilder.length() == 0) {
      return "nil";
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = paramInt2 + paramInt1 - 1;
    int i = paramAbsListView.getChildCount();
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_b_of_type_Int = (paramInt1 + 1);
      this.jdField_c_of_type_Int = paramInt1;
    }
    int j = this.jdField_b_of_type_Int;
    View localView;
    if (paramInt1 < j)
    {
      this.jdField_e_of_type_Int = 1;
      paramInt2 = 0;
      while ((paramInt2 < i) && (paramInt2 < j - paramInt1))
      {
        int k = paramInt1 + paramInt2;
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(k) != null)
        {
          this.jdField_d_of_type_Int += ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).intValue();
        }
        else
        {
          localView = paramAbsListView.getChildAt(paramInt2);
          if (localView != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(k, Integer.valueOf(localView.getHeight()));
            this.jdField_d_of_type_Int += localView.getHeight();
          }
        }
        paramInt2 += 1;
      }
      this.jdField_b_of_type_Int = paramInt1;
    }
    j = this.jdField_c_of_type_Int;
    if (paramInt3 > j)
    {
      this.jdField_e_of_type_Int = 0;
      paramInt2 = i - 1;
      paramInt1 = paramInt2;
      for (;;)
      {
        i = paramInt2 - paramInt1;
        if (i >= paramInt3 - j) {
          break;
        }
        i = paramInt3 - i;
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null)
        {
          this.jdField_d_of_type_Int += ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).intValue();
        }
        else
        {
          localView = paramAbsListView.getChildAt(paramInt1);
          if (localView != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(i, Integer.valueOf(localView.getHeight()));
            this.jdField_d_of_type_Int += localView.getHeight();
          }
        }
        paramInt1 -= 1;
      }
      this.jdField_c_of_type_Int = paramInt3;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 5) && (paramInt != 6)) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo = a(paramAbsListView);
        a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo);
        return;
      }
      b();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.f = paramAbsListView.getHeight();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo = a(paramAbsListView);
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo;
      this.jdField_b_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo = paramAbsListView;
      a(paramAbsListView);
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ReadinjoySPEventReport.ScrollStep localScrollStep = a(paramAbsListView);
    this.jdField_c_of_type_JavaUtilArrayList.add(localScrollStep);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$ScreenFeedsInfo = a(paramAbsListView);
    if ((paramAbsListView instanceof ReadInJoyXListView))
    {
      Object localObject = (ReadInJoyXListView)paramAbsListView;
      int i = ((ReadInJoyXListView)localObject).g;
      int j = ((ReadInJoyXListView)localObject).h;
      paramInt = Math.min(i, j);
      i = Math.max(i, j);
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("finger touch min :");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", max : ");
      ((StringBuilder)localObject).append(i);
      QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject).toString());
      while ((paramInt <= i) && (paramInt < paramAbsListView.getCount()))
      {
        localObject = a(paramAbsListView, paramInt);
        if (((localObject instanceof BaseArticleInfo)) && (!(localObject instanceof AdvertisementInfo))) {
          this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((AbsBaseArticleInfo)localObject).mArticleID));
        }
        paramInt += 1;
      }
    }
    paramAbsListView = new StringBuilder();
    paramAbsListView.append("one scroll ");
    paramAbsListView.append(localScrollStep.a());
    QLog.d("ReadinjoySPEventReport", 2, paramAbsListView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo
 * JD-Core Version:    0.7.0.1
 */