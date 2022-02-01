package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper.EntryBannerInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class ZanBannerView
  extends FrameLayout
{
  private static String a = "spKeyZanBannerIndex";
  private List<PraiseConfigHelper.EntryBannerInfo> b;
  private int c = -1;
  private PraiseConfigHelper.EntryBannerInfo d;
  private RelativeLayout e;
  private ZanBannerView.BannerHolder f;
  
  public ZanBannerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ZanBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ZanBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.e = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131628358, null));
    this.f = new ZanBannerView.BannerHolder(this.e);
    addView(this.e);
    this.c = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt(a, 0);
    if (this.c > 100) {
      this.c = 0;
    }
  }
  
  private void a(ZanBannerView.BannerHolder paramBannerHolder)
  {
    Object localObject = getNextInfo();
    if (localObject != null)
    {
      paramBannerHolder.b.setText(((PraiseConfigHelper.EntryBannerInfo)localObject).a);
      paramBannerHolder.c.setText(((PraiseConfigHelper.EntryBannerInfo)localObject).b);
      if (((PraiseConfigHelper.EntryBannerInfo)localObject).c != null)
      {
        int i = ((PraiseConfigHelper.EntryBannerInfo)localObject).c.size();
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int j = ViewUtils.dpToPx(36.0F);
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = j;
        URLDrawable localURLDrawable;
        if (i == 1)
        {
          localURLDrawable = URLDrawable.getDrawable((String)((PraiseConfigHelper.EntryBannerInfo)localObject).c.get(0), localURLDrawableOptions);
          paramBannerHolder.d.setImageDrawable(localURLDrawable);
          paramBannerHolder.e.setVisibility(8);
          return;
        }
        if (i > 1)
        {
          localURLDrawable = URLDrawable.getDrawable((String)((PraiseConfigHelper.EntryBannerInfo)localObject).c.get(0), localURLDrawableOptions);
          localObject = URLDrawable.getDrawable((String)((PraiseConfigHelper.EntryBannerInfo)localObject).c.get(1), localURLDrawableOptions);
          paramBannerHolder.d.setImageDrawable(localURLDrawable);
          paramBannerHolder.e.setImageDrawable((Drawable)localObject);
          paramBannerHolder.e.setVisibility(0);
        }
      }
    }
  }
  
  private boolean a()
  {
    List localList = this.b;
    return (localList == null) || (localList.isEmpty());
  }
  
  private PraiseConfigHelper.EntryBannerInfo getNextInfo()
  {
    if (a()) {
      return null;
    }
    List localList = this.b;
    int i = this.c;
    this.c = (i + 1);
    this.d = ((PraiseConfigHelper.EntryBannerInfo)localList.get(i % localList.size()));
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(a, this.c).commit();
    return this.d;
  }
  
  public String getCurrentClickUrl()
  {
    PraiseConfigHelper.EntryBannerInfo localEntryBannerInfo = this.d;
    if (localEntryBannerInfo != null) {
      return localEntryBannerInfo.d;
    }
    return null;
  }
  
  public String getCurrentReportName()
  {
    PraiseConfigHelper.EntryBannerInfo localEntryBannerInfo = this.d;
    if (localEntryBannerInfo != null) {
      return localEntryBannerInfo.e;
    }
    return "";
  }
  
  public void setInfoList(List<PraiseConfigHelper.EntryBannerInfo> paramList)
  {
    this.b = paramList;
    a(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanBannerView
 * JD-Core Version:    0.7.0.1
 */