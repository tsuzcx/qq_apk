package com.tencent.qidian;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.biz.ui.PhotoHorizontalScrollView;
import com.tencent.qidian.data.CompanyShowCaseInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.List;

@TargetApi(9)
public class PhotoWallViewForQiDianProfile
  extends LinearLayout
{
  View a;
  public List<CompanyShowCaseInfo> b;
  public PhotoWallViewForQiDianProfile.PhotoWallCallback c;
  public int d = -1;
  public int e = -1;
  public int f = -1;
  public GridView g;
  public PhotoHorizontalScrollView h;
  private Context i;
  private ImageView j;
  private View k;
  private AdapterView.OnItemClickListener l = new PhotoWallViewForQiDianProfile.1(this);
  
  public PhotoWallViewForQiDianProfile(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhotoWallViewForQiDianProfile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public PhotoWallViewForQiDianProfile(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if ((QLog.isColorLevel()) && (this.b != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePhotoView urlList size=");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.i("PhotoWallViewForQiDianProfile", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    int m;
    if (localObject != null) {
      m = ((List)localObject).size();
    } else {
      m = 0;
    }
    if (m > 0)
    {
      this.g.setColumnWidth(this.d);
      this.g.setStretchMode(0);
      this.g.setHorizontalSpacing(this.f);
      localObject = new PhotoWallViewForQiDianProfile.PhotoAdapter(this, this.i);
      ((PhotoWallViewForQiDianProfile.PhotoAdapter)localObject).a(this.b);
      m = this.b.size();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((this.d + this.f) * m, this.e);
      this.g.setLayoutParams(localLayoutParams);
      this.g.setNumColumns(m);
      this.g.setAdapter((ListAdapter)localObject);
      this.g.setOnItemClickListener(this.l);
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      this.g.setVisibility(0);
      setVisibility(0);
    }
  }
  
  public void a(Context paramContext, List<CompanyShowCaseInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoWallViewForQiDianProfile", 2, "initView");
    }
    this.i = paramContext;
    this.b = paramList;
    this.a = LayoutInflater.from(this.i).inflate(2131625589, this, true);
    this.g = ((GridView)this.a.findViewById(2131440206));
    this.g.setClickable(true);
    this.h = ((PhotoHorizontalScrollView)this.a.findViewById(2131440207));
    this.j = ((ImageView)this.a.findViewById(2131440723));
    this.k = this.a.findViewById(2131443117);
    this.f = getResources().getDimensionPixelSize(2131298829);
    this.d = getResources().getDimensionPixelSize(2131298831);
    this.e = getResources().getDimensionPixelSize(2131298830);
    if (VersionUtils.c()) {
      this.h.setOverScrollMode(2);
    }
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPhotoWallCallback(PhotoWallViewForQiDianProfile.PhotoWallCallback paramPhotoWallCallback)
  {
    this.c = paramPhotoWallCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.PhotoWallViewForQiDianProfile
 * JD-Core Version:    0.7.0.1
 */