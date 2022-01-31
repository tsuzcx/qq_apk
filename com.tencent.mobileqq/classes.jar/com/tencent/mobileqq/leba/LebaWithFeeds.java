package com.tencent.mobileqq.leba;

import aegz;
import aehx;
import aehy;
import aehz;
import aeia;
import aeic;
import aeif;
import aeih;
import aeii;
import aeij;
import aeil;
import aeim;
import aeio;
import aeip;
import aeiq;
import aeir;
import aeis;
import aeit;
import aeiu;
import aeiv;
import aeix;
import aeiy;
import aeiz;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.leba.UITemplate.BaseUITemplateInfo;
import com.tencent.mobileqq.leba.ark.LebaFeedsArkHelper;
import com.tencent.mobileqq.leba.header.LebaGridMenuAdapter;
import com.tencent.mobileqq.leba.header.LebaGridMenuAdapter.LebaGridItemViewHolder;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.leba.header.LebaGridUtils;
import com.tencent.mobileqq.leba.header.LebaPluginInfoObserver;
import com.tencent.mobileqq.leba.header.PluginActionFactory.PluginPool;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.leba.model.pluginactions.PluginAction;
import com.tencent.mobileqq.leba.view.LebaFPSXListView;
import com.tencent.mobileqq.leba.view.LebaGridMenuView;
import com.tencent.mobileqq.leba.view.LebaTopBarView;
import com.tencent.mobileqq.leba.view.LebaTopEntryView;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.EXReportController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.exreportitem.DC03309ReportItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class LebaWithFeeds
  extends Frame
  implements aegz, ViewStub.OnInflateListener, CommonLoadingView.OnFirstDrawListener
{
  private static List jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List jdField_e_of_type_JavaUtilList = new ArrayList();
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public DownloadIconsListener a;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("web_leba", "com.tencent.mobileqq:tool");
  private LebaFeedsAdapter jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter;
  private LebaFeedsManager jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager;
  private LebaFeedsObserver jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsObserver = new aeiq(this);
  private LebaTitleBar jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar;
  QZoneEntryController jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController;
  public LebaGridMenuAdapter a;
  private LebaPluginInfoObserver jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaPluginInfoObserver = new aeil(this);
  PluginActionFactory.PluginPool jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool = new PluginActionFactory.PluginPool();
  private LebaFPSXListView jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView;
  private LebaGridMenuView jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView;
  private LebaTopBarView jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new aeim(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new aeip(this);
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  public AdapterView.OnItemClickListener a;
  public List a;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private AbsListView.OnScrollListener jdField_c_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f;
  
  static
  {
    jdField_c_of_type_JavaUtilList.add("jiankang.qq.com");
    jdField_c_of_type_JavaUtilList.add("guahao.com");
    jdField_c_of_type_JavaUtilList.add("91160.com");
    jdField_d_of_type_JavaUtilList.add("m.gamecenter.qq.com");
    jdField_d_of_type_JavaUtilList.add("web.gamecenter.qq.com");
    jdField_d_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_d_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_d_of_type_JavaUtilList.add("youxi.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("cdn.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("comic.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("reader.sh.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("ac.tc.qq.com");
    jdField_e_of_type_JavaUtilList.add("img-qq.ac.qq.com");
  }
  
  public LebaWithFeeds()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new aeiu(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new aeif(this);
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new aeij(this);
  }
  
  private void A()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager = ((LebaFeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(276));
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter = new LebaFeedsAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView, this);
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.setListener(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar.setListener(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter);
    }
    this.jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a();
  }
  
  private void B()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localLebaGridItemInfo == null) || (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo == null) || (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId != 10001) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))) {}
      for (;;)
      {
        LebaGridMenuView localLebaGridMenuView;
        Bitmap localBitmap2;
        try
        {
          Bitmap localBitmap1 = BitmapFactory.decodeResource(a(), 2130842705);
          if ((localBitmap1 != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null))
          {
            localLebaGridMenuView = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a();
            if (localLebaGridMenuView != null) {
              a(localLebaGridMenuView, localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName, localBitmap1);
            }
            a(localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName, localBitmap1);
          }
          i += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.i("Q.lebatab.leba_with_feeds", 1, "refreshTopBarNearbyIcon, e=" + localOutOfMemoryError.toString());
          localBitmap2 = null;
          continue;
        }
        if (!TextUtils.isEmpty(localLebaGridItemInfo.jdField_a_of_type_JavaLangString))
        {
          localBitmap2 = (Bitmap)BaseApplicationImpl.sImageHashMap.get(localLebaGridItemInfo.jdField_a_of_type_JavaLangString);
          if ((localBitmap2 != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null))
          {
            localLebaGridMenuView = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a();
            if (localLebaGridMenuView != null) {
              a(localLebaGridMenuView, localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName, localBitmap2);
            }
            a(localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName, localBitmap2);
          }
        }
      }
    }
  }
  
  private void C()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a(i);
      LebaGridMenuAdapter.LebaGridItemViewHolder localLebaGridItemViewHolder;
      if (localView != null)
      {
        localLebaGridItemViewHolder = (LebaGridMenuAdapter.LebaGridItemViewHolder)localView.getTag();
        if ((localLebaGridItemViewHolder != null) && (localLebaGridItemViewHolder.a != null) && (localLebaGridItemViewHolder.a.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null)) {
          break label70;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label70:
        PluginAction localPluginAction = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a(localLebaGridItemViewHolder.a.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.getContext());
        if (localPluginAction != null) {
          localPluginAction.b(localView, localLebaGridItemViewHolder.a);
        }
      }
    }
  }
  
  private void D()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a(i);
      LebaGridMenuAdapter.LebaGridItemViewHolder localLebaGridItemViewHolder;
      if (localView != null)
      {
        localLebaGridItemViewHolder = (LebaGridMenuAdapter.LebaGridItemViewHolder)localView.getTag();
        if ((localLebaGridItemViewHolder != null) && (localLebaGridItemViewHolder.a != null) && (localLebaGridItemViewHolder.a.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null)) {
          break label70;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label70:
        PluginAction localPluginAction = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a(localLebaGridItemViewHolder.a.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.getContext());
        if (localPluginAction != null) {
          localPluginAction.c(localView, localLebaGridItemViewHolder.a);
        }
      }
    }
  }
  
  private View a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController = new QZoneEntryController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getContext());
    this.jdField_c_of_type_ComTencentWidgetAbsListView$OnScrollListener = this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController;
    return this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.a();
  }
  
  private LebaGridItemInfo a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)localIterator.next();
        if ((localLebaGridItemInfo != null) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName != null) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName != null) && ((localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName.equals("com.tx.gamecenter.android")) || (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131435087))))) {
          return localLebaGridItemInfo;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    String str = "";
    int j;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.getVisibility() == 0) {
        break label243;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView == null) {
        break label407;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a() + 1;
      bool = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a();
      if ((j - 1 >= this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a.length) || (paramInt != 1)) {
        break label101;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a[(j - 1)] == 0) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a[(j - 1)] = true;
    label101:
    str = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a(), bool);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a[(j - 1)] = true;
    int i = 1;
    paramInt = j;
    for (;;)
    {
      label135:
      DC03309ReportItem localDC03309ReportItem = new DC03309ReportItem();
      localDC03309ReportItem.i = "trends_tab";
      localDC03309ReportItem.j = "trends_plugin";
      localDC03309ReportItem.k = "plugin_exp";
      localDC03309ReportItem.jdField_a_of_type_Int = i;
      localDC03309ReportItem.jdField_b_of_type_Int = paramInt;
      localDC03309ReportItem.jdField_c_of_type_Int = 1;
      localDC03309ReportItem.jdField_a_of_type_Long = 0L;
      localDC03309ReportItem.jdField_a_of_type_JavaLangString = str;
      EXReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDC03309ReportItem);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("raymondguo", 2, "grid report is " + localDC03309ReportItem);
      return;
      label243:
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a()) {}
      for (i = 2;; i = 3)
      {
        if (i != 2) {
          break label388;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a() == null) {
          break label402;
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().a();
        j = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().a() + 1;
        if ((j - 1 < this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().a.length) && (paramInt == 1))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().a[(j - 1)] != 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().a[(j - 1)] = true;
        }
        str = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(j - 1, bool);
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().a[(j - 1)] = true;
        paramInt = j;
        break label135;
      }
      label388:
      paramInt = 0;
      str = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a();
      continue;
      label402:
      paramInt = 1;
      continue;
      label407:
      paramInt = 1;
      i = 1;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilList.size())) {}
    LebaGridItemInfo localLebaGridItemInfo;
    PluginAction localPluginAction;
    do
    {
      do
      {
        return;
        localLebaGridItemInfo = (LebaGridItemInfo)this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(paramView, paramInt);
      } while ((localLebaGridItemInfo == null) || (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo == null));
      localPluginAction = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a(localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId, a());
    } while (localPluginAction == null);
    localPluginAction.a(paramView, localLebaGridItemInfo);
    if (LebaGridUtils.a(localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.jumpInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    }
    localPluginAction.c(localLebaGridItemInfo);
    localPluginAction.b(localLebaGridItemInfo);
    a(new aeii(this, localPluginAction, localLebaGridItemInfo, paramView));
    a(localLebaGridItemInfo);
    a(localLebaGridItemInfo, paramInt);
  }
  
  private void a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    if ((!LebaGridUtils.a(paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.jumpInfo)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName))) {
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    }
  }
  
  private void a(LebaGridItemInfo paramLebaGridItemInfo, int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.getVisibility() != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      paramLebaGridItemInfo = Integer.toString(paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId);
      DC03309ReportItem localDC03309ReportItem = new DC03309ReportItem();
      localDC03309ReportItem.i = "trends_tab";
      localDC03309ReportItem.j = "trends_plugin";
      localDC03309ReportItem.k = "plugin_clk";
      localDC03309ReportItem.jdField_a_of_type_Int = i;
      localDC03309ReportItem.jdField_c_of_type_Int = 1;
      localDC03309ReportItem.jdField_a_of_type_JavaLangString = paramLebaGridItemInfo;
      localDC03309ReportItem.jdField_c_of_type_JavaLangString = Integer.toString(paramInt + 1);
      EXReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDC03309ReportItem);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.leba_with_feeds", 4, "click report " + localDC03309ReportItem);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a())
      {
        i = 2;
      }
      else
      {
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  private void a(LebaGridMenuView paramLebaGridMenuView, String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject1 = paramLebaGridMenuView.a(i);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (LebaGridMenuAdapter.LebaGridItemViewHolder)((View)localObject1).getTag();
        if ((localObject2 != null) && (((LebaGridMenuAdapter.LebaGridItemViewHolder)localObject2).a != null) && (((LebaGridMenuAdapter.LebaGridItemViewHolder)localObject2).a.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (paramString.equals(((LebaGridMenuAdapter.LebaGridItemViewHolder)localObject2).a.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName))) {
          break label95;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label95:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a(((LebaGridMenuAdapter.LebaGridItemViewHolder)localObject2).a.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId, paramLebaGridMenuView.getContext());
        localObject1 = (ImageView)((View)localObject1).findViewById(2131366368);
        if ((localObject1 != null) && (paramBitmap != null) && (localObject2 != null)) {
          ((PluginAction)localObject2).a((ImageView)localObject1, paramBitmap);
        }
      }
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a();
    if (localHorizontalListView != null)
    {
      int j = localHorizontalListView.getChildCount();
      int i = 0;
      if (i < j)
      {
        Object localObject1 = localHorizontalListView.getChildAt(i);
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = (BaseViewHolder)((View)localObject1).getTag();
          if (localObject2 != null) {
            break label64;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label64:
          if ((((BaseViewHolder)localObject2).a("dataItem") instanceof LebaGridItemInfo))
          {
            localObject2 = (LebaGridItemInfo)((BaseViewHolder)localObject2).a("dataItem");
            if ((localObject2 != null) && (((LebaGridItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (paramString.equals(((LebaGridItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName)))
            {
              localObject1 = (ImageView)((View)localObject1).findViewById(2131366368);
              if ((localObject1 != null) && (paramBitmap != null)) {
                if ((((LebaGridItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == 10001) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {
                  ((ImageView)localObject1).setImageResource(2130842705);
                } else {
                  ((ImageView)localObject1).setImageBitmap(paramBitmap);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "refreshFeedsData sendReq=" + paramBoolean + ", from=" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager == null)) {
      QLog.e("Q.lebatab.leba_with_feeds", 1, "refreshFeedsData app/feedsAdapter/mFeedsManager is null");
    }
    do
    {
      return;
      if (this.w) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.lebatab.leba_with_feeds", 2, "refreshFeedsData isResume==false, return");
    return;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      QLog.e("Q.lebatab.leba_with_feeds", 1, "refreshFeedsData lebaGridDatas.size() == 0");
      return;
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "refreshFeedsData local load state=" + k + ", sendReq=" + paramBoolean + ",mIsRefreshingFeeds=" + this.jdField_c_of_type_Boolean);
    }
    if ((k == 0) || (k == 1)) {}
    for (int i = 1;; i = 0)
    {
      if (k == 0) {
        ThreadManager.postImmediately(new aeir(this), null, false);
      }
      if (i == 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba_with_feeds", 2, "refreshFeedsData isLoadingCache==true");
      }
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a(false);
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a(new ArrayList(0));
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.notifyDataSetChanged();
      return;
    }
    i = j;
    if (paramBoolean)
    {
      i = j;
      if (!this.jdField_c_of_type_Boolean)
      {
        k = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a(1, this.jdField_b_of_type_Boolean);
        if (QLog.isColorLevel()) {
          QLog.i("Q.lebatab.leba_with_feeds", 2, "refreshFeedsData sendReq result=" + k);
        }
        this.jdField_b_of_type_Boolean = false;
        if (k != 0) {
          break label429;
        }
      }
    }
    label429:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      i = j;
      if (k == 0) {
        i = 1;
      }
      if ((this.f) && (i == 0) && (paramInt != 1) && (paramInt != 2)) {
        break;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a();
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a(localList);
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.notifyDataSetChanged();
      this.f = true;
      return;
    }
  }
  
  private String b()
  {
    Object localObject2 = IndividuationUrlHelper.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((LebaGridItemInfo)localObject3).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((LebaGridItemInfo)localObject3).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.jumpInfo;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((JumpAction)localObject3).a("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject2 = "http://gamecenter.qq.com/front/release/index/index.html";
        }
      }
      return localObject2;
    }
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "http://gamecenter.qq.com/front/release/index/index.html";
  }
  
  private void b(int paramInt)
  {
    PluginAction localPluginAction = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a(paramInt, a());
    if (localPluginAction != null) {
      localPluginAction.c(LebaGridUtils.a(paramInt, this.jdField_a_of_type_JavaUtilList));
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onSwitchToLebaDelay");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null)) {
      return;
    }
    WebProcessManager.c(true);
    q();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "trends_tab_exp", 1, 0, "", "", "", "");
    List localList = ((LebaGridManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211)).a(2);
    if (localList != null) {
      if (i < localList.size())
      {
        PluginInfo localPluginInfo = (PluginInfo)localList.get(i);
        if (localPluginInfo == null) {}
        while ((TextUtils.isEmpty(localPluginInfo.pkgName)) || (!localPluginInfo.pkgName.equals("m.tx.apphelper.android")))
        {
          i += 1;
          break;
        }
        long l = localPluginInfo.pluginId;
      }
    }
    LebaGridShowManager.a().a();
    l();
  }
  
  private void q()
  {
    Object localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    if (localObject1 == null) {}
    do
    {
      do
      {
        return;
        if (((WebProcessManager)localObject1).d()) {
          ((WebProcessManager)localObject1).a(202);
        }
      } while (!SonicPreloader.a());
      localObject1 = b();
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    long l2 = System.currentTimeMillis();
    Object localObject2 = a();
    if ((localObject2 != null) && (((LebaGridItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null)) {}
    for (long l1 = ((LebaGridItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId;; l1 = 489L)
    {
      localObject2 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      Object localObject3 = ((RedTouchManager)localObject2).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject2).a(String.valueOf(l1));
      Object localObject4 = SonicPreloader.a((BusinessInfoCheckUpdate.AppInfo)localObject3, 0);
      SparseArray localSparseArray = SonicPreloader.a(localAppInfo, 1002);
      localObject3 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i;
      if ((localObject4 != null) && (((SparseArray)localObject4).size() > 0)) {
        i = 0;
      }
      for (;;)
      {
        if (i < ((SparseArray)localObject4).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject4).valueAt(i);
          if (localSonicPreloadData.jdField_a_of_type_Int == 1002)
          {
            localSonicPreloadData.jdField_a_of_type_JavaLangString = ((String)localObject1);
            ((ArrayList)localObject3).add(localSonicPreloadData);
          }
        }
        else
        {
          if ((localSparseArray != null) && (localSparseArray.size() > 0))
          {
            localObject4 = (SonicPreloadData)localSparseArray.valueAt(0);
            ((SonicPreloadData)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject1);
            localArrayList.add(localObject4);
          }
          localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
          if (((WebProcessManager)localObject1).a((ArrayList)localObject3)) {
            ((RedTouchManager)localObject2).b(String.valueOf("200010.200011"));
          }
          if (((WebProcessManager)localObject1).a(localArrayList)) {
            localAppInfo.preload_ts.set(System.currentTimeMillis());
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.lebatab.leba_with_feeds", 2, "preloadWebProcess parse cost:" + (System.currentTimeMillis() - l2));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.gamecenter.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.music");
    this.jdField_a_of_type_JavaUtilSet.add("com.qq.yijianfankui");
    this.jdField_a_of_type_JavaUtilSet.add("com.life.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.citylife.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.android.txnews.new2");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.Health");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.ketang");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.zhibojian");
    this.jdField_a_of_type_JavaUtilSet.add("qzone_feedlist");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.campus");
  }
  
  private void s()
  {
    ThreadManager.post(new aeiv(this), 10, null, false);
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131370343));
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar = ((LebaTitleBar)a(2131370345));
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView = ((LebaTopBarView)a(2131370346));
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().setIndicatorListener(new aeix(this));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().setOnScrollStateChangedListener(new aeiy(this));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView = ((LebaFPSXListView)a(2131364900));
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setActTAG("actFPSLebaNew");
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setReportType(1);
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setNeedCheckSpringback(true);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      u();
      A();
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setOnScrollListener(new aeiz(this));
      o();
    }
  }
  
  private void u()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2130970404, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView, false);
      View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370347);
      localView.getLayoutParams().height = this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar.getHeight();
      localView.requestLayout();
    }
    y();
    x();
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter = new LebaGridMenuAdapter(a(), this.jdField_a_of_type_JavaUtilList, 4, 3);
      this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool);
      this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(new aehy(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView = ((LebaGridMenuView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370349));
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.setIndicatorListener(new aehz(this));
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.removeHeaderView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter, "feeds");
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.setPluginPool(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool);
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.setGridMenuAdapter(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter);
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.setGridMenuHeigh(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView);
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new aeia(this);
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370348));
      this.jdField_b_of_type_JavaUtilList = LebaGridShowManager.a().a();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((LebaGridItemInfo)localIterator.next()).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == 10000)
        {
          LebaTopEntryView localLebaTopEntryView = (LebaTopEntryView)a();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localLebaTopEntryView);
        }
      }
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new aeic(this), 100L);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130970403, null);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    try
    {
      t();
      LebaGridShowManager.a().b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaPluginInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsObserver);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.lebatab.leba_with_feeds", 1, "leba fillData->initLebaView exception:" + localException, localException);
      }
    }
  }
  
  public void a(LebaFeedInfo paramLebaFeedInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a(paramLebaFeedInfo);
    }
  }
  
  public void a(LebaFeedInfo paramLebaFeedInfo, HashMap paramHashMap)
  {
    if (paramLebaFeedInfo == null) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.jdField_b_of_type_Long < 1000L);
    this.jdField_b_of_type_Long = l;
    if (paramLebaFeedInfo.templateInfo != null) {}
    for (paramLebaFeedInfo = paramLebaFeedInfo.templateInfo.j;; paramLebaFeedInfo = null) {
      try
      {
        LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaFeedInfo, a(), paramHashMap);
        return;
      }
      catch (Exception paramLebaFeedInfo)
      {
        QLog.e("Q.lebatab.leba_with_feeds", 1, "jumpToFeedDetail " + paramLebaFeedInfo, paramLebaFeedInfo);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onResume");
    }
    AbstractGifImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.b();
    }
    if ((!this.jdField_a_of_type_Boolean) || ((LebaShowListManager.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      z();
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new aehx(this), 600L);
      if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.f();
      }
      if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()))
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(this.jdField_a_of_type_Int, true);
        this.jdField_a_of_type_Int = -1;
      }
      C();
      B();
      if (!paramBoolean) {
        p();
      }
      return;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134008);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134008, 250L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134006, 200L);
      if (LebaShowListManager.jdField_a_of_type_Int > 0)
      {
        ArrayList localArrayList = new ArrayList();
        LebaGridUtils.a(localArrayList, LebaGridShowManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) {
          this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a(localArrayList);
        }
        LebaShowListManager.jdField_a_of_type_Int = 0;
        if (this.jdField_a_of_type_JavaUtilList == null) {}
      }
    }
  }
  
  public void ai_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a() != 2) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba_with_feeds", 2, "onRetryClick state=" + this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a());
      }
    }
    do
    {
      do
      {
        return;
        if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onRetryClick mIsRefreshingFeeds || mIsLoadingMoreFeeds");
      return;
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long > 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.lebatab.leba_with_feeds", 2, "onRetryClick send req");
        }
        this.jdField_a_of_type_Long = l;
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.b();
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a(2, this.jdField_b_of_type_Boolean);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.lebatab.leba_with_feeds", 2, "onRetryClick duration < 1000ms");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onListScrollToBottom");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager == null)) {
      QLog.e("Q.lebatab.leba_with_feeds", 1, "onListScrollToBottom app/feedsAdapter/mFeedsManager is null");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("Q.lebatab.leba_with_feeds", 2, "onListScrollToBottom !mFeedsAdapter.isHasMoreFeeds()");
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a() == 4)
          {
            QLog.e("Q.lebatab.leba_with_feeds", 1, "onListScrollToBottom showing FOOTER_CLICK_TO_RETRY");
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a() == 2) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.lebatab.leba_with_feeds", 2, "onListScrollToBottom state=" + this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a());
        return;
        if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onListScrollToBottom mIsRefreshingFeeds || mIsLoadingMoreFeeds");
      return;
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long > 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.lebatab.leba_with_feeds", 2, "onListScrollToBottom send req");
        }
        this.jdField_a_of_type_Long = l;
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.b();
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager.a(2, this.jdField_b_of_type_Boolean);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.lebatab.leba_with_feeds", 2, "onListScrollToBottom duration < 1000ms");
  }
  
  public void b(LebaFeedInfo paramLebaFeedInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("jumpToFeedProvider ").append(paramLebaFeedInfo).append(", resId=");
      if (paramLebaFeedInfo == null)
      {
        localObject = "null";
        QLog.i("Q.lebatab.leba_with_feeds", 2, localObject);
      }
    }
    else
    {
      if (paramLebaFeedInfo != null) {
        break label74;
      }
    }
    label74:
    long l;
    do
    {
      return;
      localObject = Integer.valueOf(paramLebaFeedInfo.uiResID);
      break;
      l = System.currentTimeMillis();
    } while (l - this.jdField_b_of_type_Long < 1000L);
    this.jdField_b_of_type_Long = l;
    try
    {
      b(paramLebaFeedInfo.uiResID);
      return;
    }
    catch (Exception paramLebaFeedInfo)
    {
      QLog.e("Q.lebatab.leba_with_feeds", 1, "jumpToFeedProvider " + paramLebaFeedInfo, paramLebaFeedInfo);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onSwitchToLeba");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new aeio(this, paramBoolean), 150L);
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar != null)
    {
      localView = FrameHelperActivity.a(a()).c;
      if (!this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar.jdField_a_of_type_Boolean) {
        break label72;
      }
    }
    label72:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onAccountChanged");
    }
    LebaGridShowManager.a().a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    this.jdField_a_of_type_JavaUtilList.clear();
    super.c();
    LebaShowListManager.a().a();
    this.f = true;
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11340002, 200L);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134006, 200L);
    LebaFeedsArkHelper.a().d();
    LebaFeedsArkHelper.a().c();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager = ((LebaFeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(276));
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public boolean c()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.jdField_e_of_type_Boolean;
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.postDelayed(new aeih(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba_with_feeds", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  public void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new aeit(this));
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.i();
    }
  }
  
  protected void g()
  {
    super.g();
    r();
    ((ViewStub)a(2131364899)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131363833)).setOnFirstDrawListener(this);
  }
  
  protected void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onStart");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.h();
    }
  }
  
  public void i()
  {
    ApngImage.pauseByTag(4);
    super.i();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onPause");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new aeis(this), 10L);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.g();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.f();
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    NearbyProcessMonitor.c(0);
    D();
  }
  
  public void j()
  {
    super.j();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.i();
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaPluginInfoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsObserver);
    this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a();
    LebaGridShowManager.a().a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.j();
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter = null;
    }
    super.k();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.h();
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsManager = null;
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter = null;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject = (QZoneManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      com.tencent.mobileqq.servlet.QZoneNotifyServlet.jdField_a_of_type_Boolean = true;
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        ((QZoneManager)localObject).a(3);
      }
      localObject = (LebaGridHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(106);
      if (localObject != null) {
        ((LebaGridHandler)localObject).c();
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView != null) {
          this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.c();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().c();
        }
        a(0);
      }
    }
  }
  
  public void n()
  {
    o();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a();
    }
  }
  
  void o()
  {
    int j = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar == null) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    label260:
    label402:
    label409:
    label414:
    label417:
    for (;;)
    {
      return;
      ThemeBackground localThemeBackground;
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getTag() instanceof ThemeBackground))
      {
        localThemeBackground = (ThemeBackground)this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getTag();
        label48:
        if (!ThemeUtil.isNowThemeIsDIY()) {
          break label183;
        }
        if (localThemeBackground == null) {
          break label172;
        }
      }
      int i;
      for (;;)
      {
        ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localThemeBackground);
        if (("null".equals(localThemeBackground.path)) || (localThemeBackground.img == null)) {
          break label409;
        }
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setBackgroundDrawable(localThemeBackground.img);
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setTag(localThemeBackground);
        i = 1;
        if ((i == 0) && (j == 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setBackgroundResource(2130838220);
          this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setTag(null);
        }
        if ((j != 0) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        return;
        localThemeBackground = null;
        break label48;
        label172:
        localThemeBackground = new ThemeBackground();
      }
      label183:
      label193:
      Object localObject;
      if (ThemeUtil.isNowThemeIsAnimate()) {
        if (localThemeBackground != null)
        {
          localObject = ThemeUtil.getAnimatePathByTag(2);
          Drawable localDrawable = super.a().getDrawable(2130845888);
          localThemeBackground.img = VasApngUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "-conversation-", localDrawable, VasApngUtil.a, "-leba-", null);
          if (this.jdField_a_of_type_AndroidWidgetImageView == null)
          {
            if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
              continue;
            }
            i = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount() - 1;
            if (i < 0) {
              break label414;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView != this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i)) {
              break label402;
            }
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label417;
        }
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getContext());
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar.getId());
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView, i, (ViewGroup.LayoutParams)localObject);
        if ((localThemeBackground.img != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setBackgroundResource(0);
          this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setTag(localThemeBackground);
          ApngImage.playByTag(4);
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localThemeBackground.img);
          i = 0;
          j = 1;
          break;
          localThemeBackground = new ThemeBackground();
          break label193;
          i -= 1;
          break label260;
        }
        i = 0;
        break;
        i = -1;
      }
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    a();
    if (!this.jdField_a_of_type_Boolean) {
      a(true);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView.a().d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaWithFeeds
 * JD-Core Version:    0.7.0.1
 */