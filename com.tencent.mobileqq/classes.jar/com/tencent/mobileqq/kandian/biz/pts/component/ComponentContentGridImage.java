package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView.PicInfo;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.GalleryPGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import com.tencent.widget.TraceUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentContentGridImage
  extends GridView
  implements ComponentView
{
  public int a;
  private CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  private ComponentContentGridImage.Adapter jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Adapter;
  private ComponentContentGridImage.OnGalleryItemClickListener jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$OnGalleryItemClickListener;
  private ComponentContentGridImage.OnNoItemClickListener jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$OnNoItemClickListener;
  protected Object a;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  private int c;
  
  public ComponentContentGridImage(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComponentContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = AIOUtils.b(12.0F, getResources());
    this.jdField_b_of_type_Int = AIOUtils.b(12.0F, getResources());
    a(paramContext);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 == 9) {
      if (paramInt1 < 9) {
        i = 3;
      } else {
        return 9;
      }
    }
    if ((i == 3) && (paramInt1 >= 3)) {
      return 3;
    }
    return 1;
  }
  
  public static ComponentContentGridImage.Model a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
    UGCPicInfo localUGCPicInfo;
    if (paramAbsBaseArticleInfo.hasNext()) {
      localUGCPicInfo = (UGCPicInfo)paramAbsBaseArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        if (localArrayList1.size() >= 9) {
          break label204;
        }
        int i = localUGCPicInfo.jdField_a_of_type_Int;
        int j = localUGCPicInfo.jdField_b_of_type_Int;
        localObject = new URL(localUGCPicInfo.jdField_c_of_type_JavaLangString);
        int k = localUGCPicInfo.jdField_c_of_type_Int;
        bool = true;
        if (k != 1) {
          break label225;
        }
        localArrayList1.add(new SquareCornerTextImageView.PicInfo(i, j, (URL)localObject, bool));
        localArrayList2.add(new URL(localUGCPicInfo.jdField_b_of_type_JavaLangString));
      }
      catch (MalformedURLException localMalformedURLException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Malformed URL: ");
      ((StringBuilder)localObject).append(localMalformedURLException.getMessage());
      QLog.d("ComponentContentGridImage", 2, ((StringBuilder)localObject).toString());
      break;
      label204:
      return new ComponentContentGridImage.Model.Builder().a(localArrayList1).b(localArrayList2).a();
      label225:
      boolean bool = false;
    }
  }
  
  public static ComponentContentGridImage.Model a(Object paramObject, int paramInt)
  {
    ComponentContentGridImage.Model.Builder localBuilder = new ComponentContentGridImage.Model.Builder();
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).a();
      a(paramInt, localBuilder, paramObject);
      if (paramObject != null)
      {
        a(localBuilder, paramObject);
        b(localBuilder, paramObject);
      }
      localBuilder.a(paramInt);
    }
    return localBuilder.a();
  }
  
  private ArrayList<String> a(List<URL> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((URL)localIterator.next()).toString();
      paramList = str;
      if (str.contains("https")) {
        paramList = str.replaceFirst("https", "http");
      }
      localArrayList.add(paramList);
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if ((localObject instanceof IReadInJoyModel))
    {
      localObject = ((IReadInJoyModel)localObject).a();
      if (localObject != null)
      {
        RIJFrameworkReportManager.a((AbsBaseArticleInfo)localObject, paramInt1, paramInt2);
        paramInt2 = -1;
        CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
        paramInt1 = paramInt2;
        if (localCmpCtxt != null)
        {
          paramInt1 = paramInt2;
          if (localCmpCtxt.a != null) {
            paramInt1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c();
          }
        }
        RIJFrameworkReportManager.a((AbsBaseArticleInfo)localObject, paramInt1);
        return;
      }
      QLog.d("ComponentContentGridImage", 1, "ComponentContentGridImage report data, articleInfo is null!");
    }
  }
  
  static void a(int paramInt, ComponentContentGridImage.Model.Builder paramBuilder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3;
    int i;
    long l;
    boolean bool1;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList3 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList;
      i = localArrayList3.size();
      l = 0L;
      if (((paramInt == 62) || (paramInt == 63) || (paramInt == 64) || (paramInt == 65)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityGalleryPGCFeedsInfo != null))
      {
        l = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityGalleryPGCFeedsInfo.a;
        paramInt = i;
        if (i > 0) {
          paramInt = a(i, paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
        }
        bool1 = true;
      }
      else
      {
        bool1 = false;
        paramInt = i;
      }
      i = 0;
      if (i >= paramInt) {}
    }
    for (;;)
    {
      try
      {
        if (localArrayList2.size() >= 9) {
          break label461;
        }
        Object localObject = (PGCPicInfo)localArrayList3.get(i);
        if ((((PGCPicInfo)localObject).jdField_b_of_type_JavaLangString != null) || (((PGCPicInfo)localObject).jdField_c_of_type_JavaLangString != null))
        {
          a(i, (PGCPicInfo)localObject);
          TraceUtils.traceBegin("ComponentContentGridImage.setImageUrl");
          if (((PGCPicInfo)localObject).jdField_b_of_type_JavaLangString != null) {
            paramAbsBaseArticleInfo = ((PGCPicInfo)localObject).jdField_b_of_type_JavaLangString;
          } else {
            paramAbsBaseArticleInfo = ((PGCPicInfo)localObject).jdField_c_of_type_JavaLangString;
          }
          URL localURL = new URL(paramAbsBaseArticleInfo);
          if (((PGCPicInfo)localObject).jdField_c_of_type_JavaLangString != null) {
            paramAbsBaseArticleInfo = ((PGCPicInfo)localObject).jdField_c_of_type_JavaLangString;
          } else {
            paramAbsBaseArticleInfo = ((PGCPicInfo)localObject).jdField_b_of_type_JavaLangString;
          }
          paramAbsBaseArticleInfo = new URL(paramAbsBaseArticleInfo);
          TraceUtils.traceEnd();
          localArrayList1.add(localURL);
          TraceUtils.traceBegin("ComponentContentGridImage.PicInfo");
          int j = ((PGCPicInfo)localObject).jdField_a_of_type_Int;
          int k = ((PGCPicInfo)localObject).jdField_b_of_type_Int;
          if (((PGCPicInfo)localObject).jdField_c_of_type_Int != 1) {
            break label476;
          }
          bool2 = true;
          paramAbsBaseArticleInfo = new SquareCornerTextImageView.PicInfo(j, k, paramAbsBaseArticleInfo, bool2);
          if ((bool1) && (i == paramInt - 1))
          {
            paramAbsBaseArticleInfo.b(bool1);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131702502));
            paramAbsBaseArticleInfo.a(((StringBuilder)localObject).toString());
          }
          TraceUtils.traceEnd();
          localArrayList2.add(paramAbsBaseArticleInfo);
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.ui", 2, "url error");
        }
      }
      i += 1;
      break;
      label461:
      paramBuilder.b(localArrayList1);
      paramBuilder.a(localArrayList2);
      return;
      label476:
      boolean bool2 = false;
    }
  }
  
  private static void a(int paramInt, PGCPicInfo paramPGCPicInfo)
  {
    TraceUtils.traceBegin("ComponentContentGridImage.log");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      if (paramPGCPicInfo.jdField_b_of_type_JavaLangString != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Grid Image url [");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]: ");
        localStringBuilder.append(paramPGCPicInfo.jdField_b_of_type_JavaLangString);
        QLog.d("Q.readinjoy.ui", 2, localStringBuilder.toString());
      }
      if (paramPGCPicInfo.jdField_c_of_type_JavaLangString != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Grid thumbNail Image url [");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]: ");
        localStringBuilder.append(paramPGCPicInfo.jdField_c_of_type_JavaLangString);
        QLog.d("Q.readinjoy.ui", 2, localStringBuilder.toString());
      }
    }
    TraceUtils.traceEnd();
  }
  
  private void a(int paramInt, List<URL> paramList)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Adapter.a();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Adapter.b();
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if ((localObject1 instanceof IReadInJoyModel)) {
      localObject1 = ((IReadInJoyModel)localObject1).a();
    } else {
      localObject1 = null;
    }
    if (RIJFeedsType.t((AbsBaseArticleInfo)localObject1))
    {
      str1 = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.f;
      str2 = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel())
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ReadInJoy grid image show content url and title, articleUrl: ");
      ((StringBuilder)localObject2).append(str1);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" articleTitle: ");
      localStringBuilder.append(str2);
      QLog.d("Q.readinjoy.ui", 2, new Object[] { localObject2, localStringBuilder.toString() });
    }
    if ((localObject1 != null) && (((AbsBaseArticleInfo)localObject1).isPGCShortContent())) {
      try
      {
        ((AbsBaseArticleInfo)localObject1).clickArea = a();
        RIJFrameworkReportManager.a(((ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()).a().getContext(), (AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentContentGridImage", 2, localNullPointerException.getLocalizedMessage());
      }
    }
    CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
    if ((localCmpCtxt != null) && (localCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a() != null)) {
      TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, (AbsBaseArticleInfo)localObject1, "");
    }
    if (paramList != null) {
      a(paramInt, paramList.size());
    }
  }
  
  static void a(ComponentContentGridImage.Model.Builder paramBuilder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl)) {
      paramBuilder.a(paramAbsBaseArticleInfo.mArticleContentUrl);
    }
  }
  
  static void b(ComponentContentGridImage.Model.Builder paramBuilder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaLangString)))
    {
      paramBuilder.b(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle)) {
      paramBuilder.b(paramAbsBaseArticleInfo.mTitle);
    }
  }
  
  protected int a()
  {
    return 9;
  }
  
  public void a()
  {
    setOnItemClickListener(new ComponentContentGridImage.1(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(AIOUtils.b(1.0F, paramContext.getResources()));
    setHorizontalSpacing(AIOUtils.b(1.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
  }
  
  protected void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).jdField_a_of_type_Boolean = false;
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof ComponentContentGridImage.Model))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    paramObject = (ComponentContentGridImage.Model)paramObject;
    this.jdField_c_of_type_Int = paramObject.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Adapter;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Adapter = new ComponentContentGridImage.Adapter(this, paramObject);
      setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Adapter);
    }
    else
    {
      ((ComponentContentGridImage.Adapter)localObject).a(paramObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Adapter.notifyDataSetChanged();
    }
    b();
    paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
    if (paramObject != null)
    {
      localObject = this.jdField_a_of_type_JavaLangObject;
      if ((localObject instanceof IReadInJoyModel)) {
        paramObject.a((IReadInJoyModel)localObject);
      }
    }
  }
  
  public void b()
  {
    int i = getCount();
    if (i == 1) {
      setNumColumns(1);
    } else if ((i != 2) && (i != 4)) {
      setNumColumns(3);
    } else {
      setNumColumns(2);
    }
    ViewGroup.LayoutParams localLayoutParams2 = getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    setLayoutParams(localLayoutParams1);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      boolean bool;
      if (pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
    }
    if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean))
    {
      ComponentContentGridImage.OnNoItemClickListener localOnNoItemClickListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$OnNoItemClickListener;
      if (localOnNoItemClickListener != null) {
        localOnNoItemClickListener.a();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setGalleryClickListener(ComponentContentGridImage.OnGalleryItemClickListener paramOnGalleryItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$OnGalleryItemClickListener = paramOnGalleryItemClickListener;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(ComponentContentGridImage.OnNoItemClickListener paramOnNoItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$OnNoItemClickListener = paramOnNoItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */