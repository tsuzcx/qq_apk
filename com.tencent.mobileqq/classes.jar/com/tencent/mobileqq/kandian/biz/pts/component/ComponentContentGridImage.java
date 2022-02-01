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
  protected Object a;
  public int b = AIOUtils.b(12.0F, getResources());
  public int c = AIOUtils.b(12.0F, getResources());
  private CmpCtxt d;
  private ComponentContentGridImage.Adapter e;
  private int f;
  private ComponentContentGridImage.OnNoItemClickListener g;
  private boolean h = false;
  private ComponentContentGridImage.OnGalleryItemClickListener i;
  
  public ComponentContentGridImage(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComponentContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int j = paramInt2;
    if (paramInt2 == 9) {
      if (paramInt1 < 9) {
        j = 3;
      } else {
        return 9;
      }
    }
    if ((j == 3) && (paramInt1 >= 3)) {
      return 3;
    }
    return 1;
  }
  
  public static ComponentContentGridImage.Model a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.iterator();
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
        int j = localUGCPicInfo.a;
        int k = localUGCPicInfo.b;
        localObject = new URL(localUGCPicInfo.e);
        int m = localUGCPicInfo.f;
        bool = true;
        if (m != 1) {
          break label225;
        }
        localArrayList1.add(new SquareCornerTextImageView.PicInfo(j, k, (URL)localObject, bool));
        localArrayList2.add(new URL(localUGCPicInfo.d));
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
      paramObject = ((IReadInJoyModel)paramObject).k();
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
  
  static void a(int paramInt, ComponentContentGridImage.Model.Builder paramBuilder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3;
    int j;
    long l;
    boolean bool1;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size() > 0))
    {
      localArrayList3 = paramAbsBaseArticleInfo.mSocialFeedInfo.t.a;
      j = localArrayList3.size();
      l = 0L;
      if (((paramInt == 62) || (paramInt == 63) || (paramInt == 64) || (paramInt == 65)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.h != null))
      {
        l = paramAbsBaseArticleInfo.mSocialFeedInfo.t.h.a;
        paramInt = j;
        if (j > 0) {
          paramInt = a(j, paramAbsBaseArticleInfo.mSocialFeedInfo.b);
        }
        bool1 = true;
      }
      else
      {
        bool1 = false;
        paramInt = j;
      }
      j = 0;
      if (j >= paramInt) {}
    }
    for (;;)
    {
      try
      {
        if (localArrayList2.size() >= 9) {
          break label459;
        }
        Object localObject = (PGCPicInfo)localArrayList3.get(j);
        if ((((PGCPicInfo)localObject).d != null) || (((PGCPicInfo)localObject).e != null))
        {
          a(j, (PGCPicInfo)localObject);
          TraceUtils.traceBegin("ComponentContentGridImage.setImageUrl");
          if (((PGCPicInfo)localObject).d != null) {
            paramAbsBaseArticleInfo = ((PGCPicInfo)localObject).d;
          } else {
            paramAbsBaseArticleInfo = ((PGCPicInfo)localObject).e;
          }
          URL localURL = new URL(paramAbsBaseArticleInfo);
          if (((PGCPicInfo)localObject).e != null) {
            paramAbsBaseArticleInfo = ((PGCPicInfo)localObject).e;
          } else {
            paramAbsBaseArticleInfo = ((PGCPicInfo)localObject).d;
          }
          paramAbsBaseArticleInfo = new URL(paramAbsBaseArticleInfo);
          TraceUtils.traceEnd();
          localArrayList1.add(localURL);
          TraceUtils.traceBegin("ComponentContentGridImage.PicInfo");
          int k = ((PGCPicInfo)localObject).a;
          int m = ((PGCPicInfo)localObject).b;
          if (((PGCPicInfo)localObject).f != 1) {
            break label474;
          }
          bool2 = true;
          paramAbsBaseArticleInfo = new SquareCornerTextImageView.PicInfo(k, m, paramAbsBaseArticleInfo, bool2);
          if ((bool1) && (j == paramInt - 1))
          {
            paramAbsBaseArticleInfo.b(bool1);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131900498));
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
      j += 1;
      break;
      label459:
      paramBuilder.b(localArrayList1);
      paramBuilder.a(localArrayList2);
      return;
      label474:
      boolean bool2 = false;
    }
  }
  
  private static void a(int paramInt, PGCPicInfo paramPGCPicInfo)
  {
    TraceUtils.traceBegin("ComponentContentGridImage.log");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      if (paramPGCPicInfo.d != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Grid Image url [");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]: ");
        localStringBuilder.append(paramPGCPicInfo.d);
        QLog.d("Q.readinjoy.ui", 2, localStringBuilder.toString());
      }
      if (paramPGCPicInfo.e != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Grid thumbNail Image url [");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]: ");
        localStringBuilder.append(paramPGCPicInfo.e);
        QLog.d("Q.readinjoy.ui", 2, localStringBuilder.toString());
      }
    }
    TraceUtils.traceEnd();
  }
  
  private void a(int paramInt, List<URL> paramList)
  {
    String str1 = this.e.b();
    String str2 = this.e.c();
    Object localObject1 = this.a;
    if ((localObject1 instanceof IReadInJoyModel)) {
      localObject1 = ((IReadInJoyModel)localObject1).k();
    } else {
      localObject1 = null;
    }
    if (RIJFeedsType.z((AbsBaseArticleInfo)localObject1))
    {
      str1 = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.x.i;
      str2 = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.x.c;
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
        ((AbsBaseArticleInfo)localObject1).clickArea = getClickArea();
        RIJFrameworkReportManager.a(((ReadInJoyBaseAdapter)this.d.a.u()).F().getContext(), (AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentContentGridImage", 2, localNullPointerException.getLocalizedMessage());
      }
    }
    CmpCtxt localCmpCtxt = this.d;
    if ((localCmpCtxt != null) && (localCmpCtxt.a != null) && (this.d.a.u() != null) && (this.d.a.u().a() != null)) {
      TroopNoticeJsHandler.a(this.d.a.u().a(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, (AbsBaseArticleInfo)localObject1, "");
    }
    if (paramList != null) {
      b(paramInt, paramList.size());
    }
  }
  
  static void a(ComponentContentGridImage.Model.Builder paramBuilder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl)) {
      paramBuilder.a(paramAbsBaseArticleInfo.mArticleContentUrl);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if ((localObject instanceof IReadInJoyModel))
    {
      localObject = ((IReadInJoyModel)localObject).k();
      if (localObject != null)
      {
        RIJFrameworkReportManager.a((AbsBaseArticleInfo)localObject, paramInt1, paramInt2);
        paramInt2 = -1;
        CmpCtxt localCmpCtxt = this.d;
        paramInt1 = paramInt2;
        if (localCmpCtxt != null)
        {
          paramInt1 = paramInt2;
          if (localCmpCtxt.a != null) {
            paramInt1 = this.d.a.m();
          }
        }
        RIJFrameworkReportManager.a((AbsBaseArticleInfo)localObject, paramInt1);
        return;
      }
      QLog.d("ComponentContentGridImage", 1, "ComponentContentGridImage report data, articleInfo is null!");
    }
  }
  
  static void b(ComponentContentGridImage.Model.Builder paramBuilder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c)))
    {
      paramBuilder.b(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c);
      return;
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle)) {
      paramBuilder.b(paramAbsBaseArticleInfo.mTitle);
    }
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
    this.d = new CmpCtxt();
  }
  
  protected void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).e = false;
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
    this.f = paramObject.e();
    Object localObject = this.e;
    if (localObject == null)
    {
      this.e = new ComponentContentGridImage.Adapter(this, paramObject);
      setAdapter(this.e);
    }
    else
    {
      ((ComponentContentGridImage.Adapter)localObject).a(paramObject);
      this.e.notifyDataSetChanged();
    }
    b();
    paramObject = this.d;
    if (paramObject != null)
    {
      localObject = this.a;
      if ((localObject instanceof IReadInJoyModel)) {
        paramObject.a((IReadInJoyModel)localObject);
      }
    }
  }
  
  public void b()
  {
    int j = getCount();
    if (j == 1) {
      setNumColumns(1);
    } else if ((j != 2) && (j != 4)) {
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
      this.h = bool;
    }
    if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.h))
    {
      ComponentContentGridImage.OnNoItemClickListener localOnNoItemClickListener = this.g;
      if (localOnNoItemClickListener != null) {
        localOnNoItemClickListener.a();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected int getClickArea()
  {
    return 9;
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
    this.i = paramOnGalleryItemClickListener;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public void setOnNoItemClickListener(ComponentContentGridImage.OnNoItemClickListener paramOnNoItemClickListener)
  {
    this.g = paramOnNoItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */