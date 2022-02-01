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
  public List<DoutuData> b;
  public List<DoutuData> c;
  public String d;
  public String e;
  public String f;
  public MqqHandler g;
  public DoutuItem h;
  public long i;
  public HashMap<String, String> j;
  public DoutuData k;
  public IDoutuListener l;
  URLDrawableDownListener m;
  private float n;
  private int o;
  private int p;
  private int q;
  private int r;
  private BaseQQAppInterface s;
  private QBaseActivity t;
  private ColorDrawable u = new ColorDrawable();
  private boolean v;
  private int w;
  private DoutuData x;
  
  public DoutuEmotionAdapter(BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity, IDoutuListener paramIDoutuListener, String paramString1, String paramString2, String paramString3, MqqHandler paramMqqHandler, boolean paramBoolean, DoutuItem paramDoutuItem, int paramInt)
  {
    int i1 = 0;
    this.v = false;
    this.w = -1;
    this.x = new DoutuData("abababababababababababab", null);
    this.i = 0L;
    this.m = new DoutuEmotionAdapter.1(this);
    this.s = paramBaseQQAppInterface;
    this.t = paramQBaseActivity;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramMqqHandler;
    this.l = paramIDoutuListener;
    this.h = paramDoutuItem;
    if (paramBoolean)
    {
      paramBaseQQAppInterface = this.h;
      if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramBaseQQAppInterface.b)))
      {
        paramBoolean = true;
        break label137;
      }
    }
    paramBoolean = false;
    label137:
    this.v = paramBoolean;
    this.i = System.currentTimeMillis();
    if ((paramInt > 0) && (this.v)) {
      a = paramInt;
    }
    if (!this.v) {
      a = 9;
    }
    this.b = new ArrayList();
    paramInt = i1;
    while (paramInt < a)
    {
      this.b.add(new DoutuData());
      paramInt += 1;
    }
    this.n = this.t.getResources().getDisplayMetrics().density;
    this.o = Utils.a(80.0F, this.t.getResources());
    this.p = Utils.a(80.0F, this.t.getResources());
    this.q = Utils.a(70.0F, this.t.getResources());
    this.r = Utils.a(70.0F, this.t.getResources());
    this.j = new HashMap();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoutuEmotionAdapter", 2, "[doutu]resetData");
    }
    List localList = this.b;
    if (localList == null) {
      this.b = new ArrayList();
    } else {
      localList.clear();
    }
    localList = this.c;
    int i3 = 0;
    int i2 = 0;
    int i1 = i3;
    if (localList != null)
    {
      i1 = i3;
      if (localList.size() > 0)
      {
        i1 = i2;
        while ((i1 < a) && (i1 < this.c.size()))
        {
          this.b.add(this.c.get(i1));
          i1 += 1;
        }
      }
    }
    while (i1 < 9)
    {
      this.b.add(new DoutuData());
      i1 += 1;
    }
    if (this.v)
    {
      localList = this.c;
      if ((localList != null) && (localList.size() > 0))
      {
        i2 = this.c.size();
        i1 = a;
        if (i2 < i1) {
          i1 = this.c.size();
        }
        this.w = i1;
        this.c.add(this.w, this.x);
        this.b.add(this.w, this.x);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong != this.i)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeLoading key:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", timeKey:");
        ((StringBuilder)localObject).append(this.i);
        QLog.e("DoutuEmotionAdapter", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.b;
    if ((localObject != null) && (this.c != null))
    {
      int i2 = ((List)localObject).size();
      this.c.remove(this.x);
      localObject = new ArrayList();
      int i1 = 0;
      while ((i1 < i2) && (i1 < this.c.size()))
      {
        ((List)localObject).add(this.c.get(i1));
        i1 += 1;
      }
      a((List)localObject);
    }
    this.w = -1;
  }
  
  public void a(List<DoutuData> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    if (paramList != null)
    {
      this.b.clear();
      this.b.addAll(paramList);
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
    if (paramLong != this.i)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("addSmartPicList key:");
        paramList.append(paramLong);
        paramList.append(", timeKey:");
        paramList.append(this.i);
        QLog.e("DoutuEmotionAdapter", 2, paramList.toString());
      }
      return;
    }
    if ((this.b != null) && (this.c != null) && (paramList != null))
    {
      int i2 = paramList.size();
      int i1 = this.w;
      if (i1 > 0)
      {
        this.c.addAll(i1, paramList);
        this.w += paramList.size();
      }
      int i3 = this.b.size();
      paramList = new ArrayList();
      i1 = 0;
      while ((i1 < i3 + i2) && (i1 < this.c.size()))
      {
        if ((!paramBoolean) || (((DoutuData)this.c.get(i1)).picMd5 == null) || (!((DoutuData)this.c.get(i1)).picMd5.equalsIgnoreCase("abababababababababababab"))) {
          paramList.add(this.c.get(i1));
        }
        i1 += 1;
      }
      if (paramBoolean)
      {
        this.c.remove(this.x);
        this.w = -1;
      }
      a(paramList);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("addSmartPicList list:");
      paramList.append(this.b);
      paramList.append(", listAll:");
      paramList.append(this.c);
      QLog.e("DoutuEmotionAdapter", 2, paramList.toString());
    }
  }
  
  public void b()
  {
    List localList = this.b;
    if ((localList != null) && (this.c != null))
    {
      int i2 = localList.size();
      int i3 = this.c.size();
      if (i2 >= i3) {
        return;
      }
      this.b.clear();
      int i1 = 0;
      while ((i1 < i3) && (i1 < a + i2))
      {
        this.b.add(this.c.get(i1));
        i1 += 1;
      }
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = this.b.size();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = null;
    if (paramInt >= i1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get view position exception , position = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",size = ");
      ((StringBuilder)localObject1).append(this.b.size());
      QLog.e("DoutuEmotionAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    DoutuData localDoutuData;
    for (;;)
    {
      localObject1 = localURLDrawableOptions;
      Object localObject2 = paramView;
      break label711;
      localDoutuData = (DoutuData)this.b.get(paramInt);
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
          ((DoutuEmotionAdapter.ViewHolder)localObject1).a = new RelativeLayout(this.t);
          paramView = new ViewGroup.LayoutParams(this.o, this.p);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).a.setLayoutParams(paramView);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).b = new URLImageView(this.t);
          paramView = new RelativeLayout.LayoutParams(this.q, this.r);
          paramView.addRule(13, -1);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).a.addView(((DoutuEmotionAdapter.ViewHolder)localObject1).b, paramView);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).c = new ProgressBar(this.t);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).c.setIndeterminateDrawable(this.t.getResources().getDrawable(2130839585));
          float f1 = this.n;
          paramView = new RelativeLayout.LayoutParams((int)(f1 * 30.0F), (int)(f1 * 30.0F));
          paramView.addRule(13, -1);
          ((DoutuEmotionAdapter.ViewHolder)localObject1).a.addView(((DoutuEmotionAdapter.ViewHolder)localObject1).c, paramView);
          paramView = ((DoutuEmotionAdapter.ViewHolder)localObject1).a;
          paramView.setTag(localObject1);
        }
        ((DoutuEmotionAdapter.ViewHolder)localObject1).d = localDoutuData;
        ((DoutuEmotionAdapter.ViewHolder)localObject1).e = paramInt;
        ((DoutuEmotionAdapter.ViewHolder)localObject1).c.setVisibility(0);
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
    Object localObject4 = this.u;
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mExtraInfo = localDoutuData;
    Object localObject3 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
    if (((URLDrawable)localObject3).getStatus() != 1)
    {
      ((URLDrawable)localObject3).setTag(localDoutuData);
      ((URLDrawable)localObject3).addHeader("my_uin", this.s.getAccount());
      if ((((URLDrawable)localObject3).getStatus() == 2) || (((URLDrawable)localObject3).getStatus() == 3)) {
        ((URLDrawable)localObject3).restartDownload();
      }
    }
    else
    {
      ((DoutuEmotionAdapter.ViewHolder)localObject1).c.setVisibility(4);
      if (this.j == null) {
        this.j = new HashMap();
      }
      this.j.put(localDoutuData.picMd5, localDoutuData.picDownUrl);
    }
    ((DoutuEmotionAdapter.ViewHolder)localObject1).b.setImageDrawable((Drawable)localObject3);
    ((DoutuEmotionAdapter.ViewHolder)localObject1).b.setURLDrawableDownListener(this.m);
    ((DoutuEmotionAdapter.ViewHolder)localObject1).b.setTag(localObject1);
    ((DoutuEmotionAdapter.ViewHolder)localObject1).b.setFocusable(true);
    ((DoutuEmotionAdapter.ViewHolder)localObject1).b.setFocusableInTouchMode(true);
    paramView.setOnClickListener(this);
    break label705;
    label693:
    ((DoutuEmotionAdapter.ViewHolder)localObject1).b.setImageDrawable(this.u);
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
      DoutuData localDoutuData = ((DoutuEmotionAdapter.ViewHolder)localObject1).d;
      if ((localDoutuData != null) && (localDoutuData.thumbDownUrl != null))
      {
        Object localObject2 = (URLDrawable)((DoutuEmotionAdapter.ViewHolder)localObject1).b.getDrawable();
        if (localObject2 != null)
        {
          localObject2 = ((URLDrawable)localObject2).getFileInLocal();
          if (localObject2 != null)
          {
            localObject2 = ((File)localObject2).getPath();
            IDoutuListener localIDoutuListener = this.l;
            if (localIDoutuListener != null) {
              localIDoutuListener.a((String)localObject2, this.d, this.e, this.f, localDoutuData, this.t);
            }
            ReportController.b(this.s, "dc00898", "", "", "0X8007FAB", "0X8007FAB", 0, 0, "", String.valueOf(((DoutuEmotionAdapter.ViewHolder)localObject1).e + 1), localDoutuData.picMd5, localDoutuData.picDownUrl);
            this.k = localDoutuData;
            localObject1 = this.g;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */