package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class QfileFavPicFileTabView
  extends QfileBaseFavFileTabView
{
  static String o = "QfileFavPicFileTabView<FileAssistant>";
  QfileFavImageExpandableListAdapter.IAdapterCallBack p = new QfileFavPicFileTabView.1(this);
  private View.OnClickListener q = new QfileFavPicFileTabView.2(this);
  private View.OnClickListener r = new QfileFavPicFileTabView.3(this);
  private QfilePinnedHeaderExpandableListView.OnSelectListener s = new QfileFavPicFileTabView.4(this);
  
  public QfileFavPicFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext, paramQfileFavFileRecordProvider, paramITabBarViewProxy);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (FavFileInfo)((ImageHolder)paramView.getTag()).i;
    if (paramBoolean)
    {
      if (FMDataCache.c(paramView))
      {
        FMDataCache.b(paramView);
      }
      else
      {
        FMDataCache.a(paramView);
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
          QLog.i(o, 2, "click too fast , wait a minute.");
        }
        return;
      }
      w();
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openFavorite(this.C, this.D.getCurrentAccountUin(), paramView.a);
    }
    a(B());
  }
  
  private boolean a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    if (paramFavFileInfo == null) {
      return false;
    }
    a(paramBoolean);
    if ((B()) && (((FMDataCache.c(paramFavFileInfo)) && (paramBoolean)) || ((!FMDataCache.c(paramFavFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (B()) {
      if (paramBoolean) {
        FMDataCache.a(paramFavFileInfo);
      } else {
        FMDataCache.b(paramFavFileInfo);
      }
    }
    return true;
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(paramFavFileInfo.g);
  }
  
  protected void a(boolean paramBoolean)
  {
    ReportController.b(this.D, "dc00898", "", "", "0X800AFAD", "0X800AFAD", 0, 0, "", "", "", "");
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    QfileFavImageExpandableListAdapter localQfileFavImageExpandableListAdapter = (QfileFavImageExpandableListAdapter)this.e;
    if ((q()) && (localQfileFavImageExpandableListAdapter.b())) {
      i();
    }
  }
  
  protected int getFileRecordType()
  {
    return 1;
  }
  
  protected int getOnceShowCount()
  {
    return 60;
  }
  
  protected QfileBaseExpandableListAdapter getQfileFavFileBaseExpandableListAdapter()
  {
    return new QfileFavImageExpandableListAdapter(this.p, getActivity(), this.c, this.q, this.r, null);
  }
  
  public void j()
  {
    if (this.l) {
      return;
    }
    super.j();
    setEditbarButton(true, true, false, true, true);
    this.d.setOnIndexChangedListener(this.s);
  }
  
  protected void o()
  {
    super.o();
    this.d.setWhetherImageTab(true);
    this.d.setGridSize(((QfileFavImageExpandableListAdapter)this.e).a());
  }
  
  public void s()
  {
    this.C.runOnUiThread(new QfileFavPicFileTabView.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView
 * JD-Core Version:    0.7.0.1
 */