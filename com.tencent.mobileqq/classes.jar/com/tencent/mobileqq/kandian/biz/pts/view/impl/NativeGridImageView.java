package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.GridImageView;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NativeGridImageView
  extends GridView
  implements IView
{
  private NativeGridImageView.Adapter a;
  private AbsBaseArticleInfo b;
  
  public NativeGridImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NativeGridImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public NativeGridImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
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
    if (this.b == null) {
      QLog.d("Proteus.NativeGridImageView", 1, "reportData, but articleInfo is null.");
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.b;
    if (localAbsBaseArticleInfo != null)
    {
      RIJFrameworkReportManager.a(localAbsBaseArticleInfo, paramInt1, paramInt2);
      paramInt1 = (int)this.b.mChannelID;
      RIJFrameworkReportManager.a(this.b, paramInt1);
      return;
    }
    QLog.d("Proteus.NativeGridImageView", 1, "reportData failed, articleInfo is null!");
  }
  
  private void a(int paramInt, List<URL> paramList)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (paramList != null))
    {
      localObject1 = ((AbsBaseArticleInfo)localObject1).mArticleContentUrl;
      String str = this.b.mTitle;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)))
      {
        if (QLog.isColorLevel())
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ReadInJoy grid image show content url and title, articleUrl: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" articleTitle: ");
          localStringBuilder.append(str);
          QLog.d("Proteus.NativeGridImageView", 2, new Object[] { localObject2, localStringBuilder.toString() });
        }
        TroopNoticeJsHandler.a((Activity)getContext(), paramInt, a(paramList), null, null, false, false, "4", 100, null, (String)localObject1, str, this.b, "");
      }
      else
      {
        TroopNoticeJsHandler.a((Activity)getContext(), paramInt, a(paramList), null, null, false, false, "4", 100, null, this.b, "");
      }
      if (paramList != null) {
        a(paramInt, paramList.size());
      }
      return;
    }
    QLog.d("Proteus.NativeGridImageView", 1, "showPicture failed, mArticleInfo is null.");
  }
  
  public void a()
  {
    setOnItemClickListener(new NativeGridImageView.1(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(AIOUtils.b(3.0F, paramContext.getResources()));
    setHorizontalSpacing(AIOUtils.b(3.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
  }
  
  public void a(GridImageView paramGridImageView)
  {
    NativeGridImageView.Adapter localAdapter = this.a;
    if (localAdapter != null) {
      localAdapter.notifyDataSetChanged();
    }
    b(paramGridImageView);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      NativeGridImageView.Adapter localAdapter = this.a;
      if (localAdapter == null)
      {
        this.a = new NativeGridImageView.Adapter(this);
        this.a.a(new NativeGridImageView.GridImageModel(this, paramAbsBaseArticleInfo));
        setAdapter(this.a);
      }
      else
      {
        localAdapter.a(new NativeGridImageView.GridImageModel(this, paramAbsBaseArticleInfo));
      }
      this.b = paramAbsBaseArticleInfo;
    }
  }
  
  public void b(GridImageView paramGridImageView)
  {
    int i = getCount();
    if (i == 1) {
      setNumColumns(1);
    } else if ((i != 2) && (i != 4)) {
      setNumColumns(3);
    } else {
      setNumColumns(2);
    }
    Layout.Params localParams = paramGridImageView.getComLayoutParams();
    if (i == 4)
    {
      if (localParams != null)
      {
        i = (int)DeviceInfoUtil.H() - AIOUtils.b(24.0F, getResources());
        localParams.mLayoutWidth = ((i - AIOUtils.b(6.0F, getResources())) * 2 / 3 + AIOUtils.b(3.0F, getResources()));
        if (localParams.mLayoutWidth > 0) {
          paramGridImageView.setComLayoutParams(localParams);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Proteus.NativeGridImageView", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localParams.mLayoutWidth), ", MinOfWidthAndHeight: ", Long.valueOf(DeviceInfoUtil.H()) });
        }
      }
    }
    else if (localParams != null)
    {
      i = (int)DeviceInfoUtil.H() - AIOUtils.b(24.0F, getResources());
      localParams.mLayoutWidth = i;
      if (localParams.mLayoutWidth > 0) {
        paramGridImageView.setComLayoutParams(localParams);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Proteus.NativeGridImageView", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localParams.mLayoutWidth), ", MinOfWidthAndHeight: ", Long.valueOf(DeviceInfoUtil.H()) });
      }
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeGridImageView
 * JD-Core Version:    0.7.0.1
 */