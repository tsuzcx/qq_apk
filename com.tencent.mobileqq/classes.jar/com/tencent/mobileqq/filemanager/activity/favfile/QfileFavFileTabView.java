package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

public class QfileFavFileTabView
  extends QfileBaseFavFileTabView
{
  protected TextView o;
  protected Drawable p;
  public View.OnClickListener q = new QfileFavFileTabView.1(this);
  protected ViewerMoreRelativeLayout r;
  public View.OnClickListener s = new QfileFavFileTabView.2(this);
  QfileFavFileBaseExpandableListAdapter.IAdapterCallBack t = new QfileFavFileTabView.3(this);
  
  public QfileFavFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext, paramQfileFavFileRecordProvider, paramITabBarViewProxy);
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(paramFavFileInfo.g);
  }
  
  public void a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    if ((B()) && (!paramBoolean))
    {
      if (FMDataCache.c(paramFavFileInfo))
      {
        FMDataCache.b(paramFavFileInfo);
      }
      else
      {
        FMDataCache.a(paramFavFileInfo);
        this.C.h(true);
      }
      C();
      r();
    }
    else
    {
      if (!v())
      {
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "click too fast , wait a minute.");
        }
        return;
      }
      w();
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openFavorite(this.C, this.D.getCurrentAccountUin(), paramFavFileInfo.a);
    }
    a(B());
  }
  
  protected void a(boolean paramBoolean)
  {
    ReportController.b(this.D, "dc00898", "", "", "0X800AFB3", "0X800AFB3", 0, 0, "", "", "", "");
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if ((q()) && (this.r.getVisibility() == 0)) {
      this.r.setGone();
    }
  }
  
  protected void e()
  {
    if ((this.o != null) && (this.p == null))
    {
      this.p = getResources().getDrawable(2130839585);
      this.o.setCompoundDrawablesWithIntrinsicBounds(this.p, null, null, null);
      ((Animatable)this.p).start();
    }
  }
  
  protected void f()
  {
    if (this.o != null)
    {
      Drawable localDrawable = this.p;
      if (localDrawable != null)
      {
        ((Animatable)localDrawable).stop();
        this.p = null;
        this.o.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  protected int getFileRecordType()
  {
    return 5;
  }
  
  public int getFootHeight()
  {
    return this.r.getHeight();
  }
  
  protected int getOnceShowCount()
  {
    return 15;
  }
  
  protected QfileBaseExpandableListAdapter getQfileFavFileBaseExpandableListAdapter()
  {
    return new QfileFavFileBaseExpandableListAdapter(getActivity(), this.c, getActivity(), this.s, null, null, this.t);
  }
  
  protected void o()
  {
    this.d.setOnGroupExpandListener(new QfileFavFileTabView.4(this));
    this.d.setOnGroupCollapseListener(new QfileFavFileTabView.5(this));
    this.r = new ViewerMoreRelativeLayout(getActivity());
    this.r.setOnClickListener(this.q);
    this.r.setGone();
    this.o = ((TextView)this.r.findViewById(2131449882));
    this.d.addFooterView(this.r);
  }
  
  protected void r()
  {
    if (q()) {
      this.r.setGone();
    } else if ((this.c != null) && (this.c.size() != 0)) {
      this.r.setVisible();
    } else {
      this.r.setGone();
    }
    super.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView
 * JD-Core Version:    0.7.0.1
 */