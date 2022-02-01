package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.emoticonview.EmoticonInfo;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class FavEmosmViewPage
  extends BaseAdapter
  implements Handler.Callback, View.OnClickListener, IEmosmView, AdapterView.OnItemClickListener, GestureSelectGridView.OnSelectListener
{
  private BaseQQAppInterface A;
  private Handler B;
  private int C;
  private volatile int D = 0;
  private volatile FavEmosmViewPage.IEmosmViewPagerListener E = null;
  LinearLayout a;
  Button b;
  TextView c;
  GestureSelectGridView d;
  public TextView e;
  public TextView f;
  public TextView g;
  RelativeLayout h;
  RelativeLayout i;
  int j;
  int k;
  List<EmoticonInfo> l = null;
  List<EmoticonInfo> m = null;
  LayoutInflater n;
  float o;
  TextView p;
  TextView q;
  Button r;
  QIphoneTitleBarActivity s;
  protected BaseEmosmStrategy t;
  protected boolean u;
  private boolean v;
  private boolean w = false;
  private int x = -2147483648;
  private int y = 2147483647;
  private volatile boolean z = false;
  
  public FavEmosmViewPage() {}
  
  public FavEmosmViewPage(BaseQQAppInterface paramBaseQQAppInterface, QIphoneTitleBarActivity paramQIphoneTitleBarActivity)
  {
    this.A = paramBaseQQAppInterface;
    this.s = paramQIphoneTitleBarActivity;
    this.n = paramQIphoneTitleBarActivity.getLayoutInflater();
    this.o = paramQIphoneTitleBarActivity.getApplicationContext().getResources().getDisplayMetrics().density;
    this.B = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.C = EmotionUtils.a(88.0F, paramQIphoneTitleBarActivity.getResources());
  }
  
  private void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_PANEL");
    }
    paramView = (FavEmosmViewPage.Holder)paramView.getTag();
    Object localObject = paramView.a.getDrawable();
    if ((localObject instanceof URLDrawable))
    {
      localObject = (URLDrawable)localObject;
      if ((((URLDrawable)localObject).getStatus() != 3) && (((URLDrawable)localObject).getStatus() != 2))
      {
        if (((URLDrawable)localObject).getStatus() == 1) {
          ((IEmosmService)QRoute.api(IEmosmService.class)).enterEmotionPreview(this.s, (EmoticonInfo)getItem(paramInt), ((IEmosmService)QRoute.api(IEmosmService.class)).getViewRect(paramView.a));
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("onItemClick restartDownload status = ");
          paramView.append(((URLDrawable)localObject).getStatus());
          QLog.d("FavEmosmViewPage", 2, paramView.toString());
        }
        ((URLDrawable)localObject).restartDownload();
      }
    }
  }
  
  private void a(URLImageView paramURLImageView, FavEmosmViewPage.Holder paramHolder)
  {
    if ((paramURLImageView.getDrawable() instanceof URLDrawable))
    {
      paramURLImageView = (URLDrawable)paramURLImageView.getDrawable();
      if (paramURLImageView.getStatus() == 0)
      {
        a(paramHolder);
        return;
      }
      if ((paramURLImageView.getStatus() != 2) && (paramURLImageView.getStatus() != 3))
      {
        c(paramHolder);
        return;
      }
      b(paramHolder);
    }
  }
  
  private void a(FavEmosmViewPage.Holder paramHolder)
  {
    paramHolder.c.setVisibility(8);
    paramHolder.d.setVisibility(0);
    paramHolder.e.setVisibility(8);
    paramHolder.a.setVisibility(0);
    Animatable localAnimatable = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839585);
    paramHolder.f.setImageDrawable((Drawable)localAnimatable);
    localAnimatable.start();
    paramHolder.f.setVisibility(0);
    if (this.D == 1)
    {
      paramHolder.b.setVisibility(0);
      return;
    }
    paramHolder.b.setVisibility(8);
  }
  
  private void a(EmoticonInfo paramEmoticonInfo, String paramString, FavEmosmViewPage.Holder paramHolder)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramHolder != null))
    {
      paramHolder.a.setURLDrawableDownListener(null);
      if (paramString.equals("needUpload"))
      {
        a(paramHolder);
        return;
      }
      if (paramString.equals("failed"))
      {
        b(paramHolder);
        return;
      }
      c(paramHolder);
      paramString = this.s.getBaseContext();
      int i1 = this.C;
      if ((paramEmoticonInfo.getZoomDrawable(paramString, 0.0F, i1, i1) instanceof URLDrawable))
      {
        paramHolder.a.setURLDrawableDownListener(new FavEmosmViewPage.6(this, paramEmoticonInfo, paramHolder));
        a(paramHolder.a, paramHolder);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "updateViewStatus holder is null");
    }
  }
  
  private boolean a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
    {
      paramEmoticonInfo = (FavoriteEmoticonInfo)paramEmoticonInfo;
      return (!TextUtils.isEmpty(paramEmoticonInfo.roamingType)) && (paramEmoticonInfo.roamingType.equals("failed"));
    }
    if ((paramEmoticonInfo instanceof PicEmoticonInfo))
    {
      paramEmoticonInfo = (PicEmoticonInfo)paramEmoticonInfo;
      return (!TextUtils.isEmpty(paramEmoticonInfo.roamingType)) && (paramEmoticonInfo.roamingType.equals("failed"));
    }
    return false;
  }
  
  private void b(FavEmosmViewPage.Holder paramHolder)
  {
    paramHolder.c.setVisibility(8);
    paramHolder.d.setVisibility(0);
    paramHolder.e.setVisibility(0);
    paramHolder.f.setVisibility(8);
    paramHolder.a.setVisibility(0);
    if (this.D == 1)
    {
      paramHolder.b.setVisibility(0);
      return;
    }
    paramHolder.b.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    if (this.D == 0)
    {
      this.s.setTitle(this.t.g());
      return;
    }
    if (this.D == 1)
    {
      String str = String.format(this.s.getString(2131888872), new Object[] { Integer.valueOf(paramInt) });
      this.s.setTitle(str);
    }
  }
  
  private void c(FavEmosmViewPage.Holder paramHolder)
  {
    d(paramHolder);
    paramHolder.d.setVisibility(8);
    paramHolder.e.setVisibility(8);
    paramHolder.f.setVisibility(8);
    paramHolder.a.setVisibility(0);
    if (this.D == 1)
    {
      paramHolder.b.setVisibility(0);
      return;
    }
    paramHolder.b.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.m;
    if ((localObject != null) && (paramInt < ((List)localObject).size()))
    {
      localObject = (EmoticonInfo)this.m.get(paramInt);
      this.m.remove(paramInt);
    }
    else
    {
      localObject = null;
    }
    List localList = this.l;
    if ((localList != null) && (localObject != null))
    {
      localList.remove(localObject);
      ((IFavroamingManagerService)this.A.getRuntimeService(IFavroamingManagerService.class)).removeCacheAccessibilityEmotionData(Integer.valueOf(((EmoticonInfo)localObject).emoId));
    }
  }
  
  private void d(FavEmosmViewPage.Holder paramHolder)
  {
    if (paramHolder.a == null) {
      return;
    }
    Object localObject = paramHolder.a.getTag(2131449867);
    if ((localObject instanceof ICustomEmotionInfo))
    {
      if (!((ICustomEmotionInfo)localObject).isChecked())
      {
        paramHolder.c.setVisibility(8);
        return;
      }
      paramHolder.c.setVisibility(0);
    }
  }
  
  private List<EmoticonInfo> e(List<EmoticonInfo> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = q();
    if ((paramList != null) && (paramList.size() > 0) && (localConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)localIterator.next();
        if (localConcurrentHashMap.containsKey(Integer.valueOf(localEmoticonInfo.emoId))) {
          localEmoticonInfo.isChecked = true;
        }
      }
    }
    return paramList;
  }
  
  private void p()
  {
    Object localObject = this.m;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EmoticonInfo)((Iterator)localObject).next()).isChecked = false;
    }
    notifyDataSetChanged();
    i();
  }
  
  private ConcurrentHashMap<Integer, Boolean> q()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)((Iterator)localObject).next();
        if (localEmoticonInfo.isChecked) {
          localConcurrentHashMap.put(Integer.valueOf(localEmoticonInfo.emoId), Boolean.valueOf(true));
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  private void r()
  {
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (this.s.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      this.s.requestPermissions(new FavEmosmViewPage.5(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    j();
    ReportController.b(this.A, "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
  }
  
  private void s()
  {
    if (this.z)
    {
      this.z = false;
      ((FavEmoRoamingHandler)this.A.getBusinessHandler(FavEmoRoamingHandler.a)).notifyUI(2, true, null);
    }
  }
  
  public void a()
  {
    this.u = true;
  }
  
  protected void a(int paramInt)
  {
    QQToast.makeText(this.s.getApplicationContext(), this.s.getString(paramInt), 0).show();
  }
  
  public void a(BaseEmosmStrategy paramBaseEmosmStrategy)
  {
    this.t = paramBaseEmosmStrategy;
    Object localObject = this.s.getResources();
    int i1 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int i2 = EmotionUtils.a(0.0F, (Resources)localObject);
    int i3 = EmotionUtils.a(4.0F, (Resources)localObject);
    int i4 = EmotionUtils.a(4.0F, (Resources)localObject);
    this.j = ((i1 - i2 * 2 - i3 * 3) / 4);
    this.k = this.j;
    this.q = this.s.rightViewText;
    this.p = this.s.leftView;
    this.p.setOnClickListener(this);
    this.q.setVisibility(0);
    this.q.setText(2131888873);
    this.q.setContentDescription(this.s.getString(2131888874));
    this.q.setOnClickListener(this);
    this.a = ((LinearLayout)this.s.findViewById(2131432404));
    this.b = ((Button)this.s.findViewById(2131432406));
    this.c = ((TextView)this.s.findViewById(2131432405));
    this.e = ((TextView)this.s.findViewById(2131432416));
    this.e.setContentDescription(this.s.getString(2131888866));
    this.g = ((TextView)this.s.findViewById(2131432407));
    this.g.setContentDescription(this.s.getString(2131888876));
    this.f = ((TextView)this.s.findViewById(2131438896));
    this.d = ((GestureSelectGridView)this.s.findViewById(2131432414));
    this.d.setSelectMode(false);
    this.h = ((RelativeLayout)this.s.findViewById(2131432415));
    this.i = ((RelativeLayout)this.s.findViewById(2131432356));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d.setScrollBarStyle(0);
    this.d.setNumColumns(4);
    this.d.setColumnWidth(this.j);
    this.d.setHorizontalSpacing(i3);
    this.d.setVerticalSpacing(i4);
    localObject = this.d;
    ((GestureSelectGridView)localObject).setPadding(i2, ((GestureSelectGridView)localObject).getPaddingTop(), i2, this.d.getPaddingBottom());
    this.d.setOnItemClickListener(this);
    this.d.setOnIndexChangedListener(this);
    this.d.setMaximumVelocity((int)(this.s.getResources().getDisplayMetrics().density * 2500.0F));
    if ((paramBaseEmosmStrategy.a(this.s)) && (paramBaseEmosmStrategy.e))
    {
      this.q.setText(2131897755);
      localObject = this.p;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      this.b.setVisibility(8);
    }
    this.r = ((Button)this.s.findViewById(2131429876));
    this.r.setOnClickListener(this);
    if ((paramBaseEmosmStrategy.d()) || (VasUtil.b((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getVipStatus().isSVip())) {
      this.h.setVisibility(8);
    }
  }
  
  public void a(FavEmosmViewPage.IEmosmViewPagerListener paramIEmosmViewPagerListener)
  {
    this.E = paramIEmosmViewPagerListener;
  }
  
  public void a(GridView paramGridView, int paramInt)
  {
    if (paramGridView != null)
    {
      if (paramInt < 0) {
        return;
      }
      int i1 = paramGridView.getFirstVisiblePosition();
      int i2 = paramGridView.getLastVisiblePosition();
      if ((paramInt >= i1) && (paramInt <= i2)) {
        getView(paramInt, paramGridView.getChildAt(paramInt - i1), paramGridView);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject1 = this.l;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (EmoticonInfo)((Iterator)localObject1).next();
          if ((localObject2 instanceof FavoriteEmoticonInfo))
          {
            localObject2 = (FavoriteEmoticonInfo)localObject2;
            if ((TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject2).path)) && (((FavoriteEmoticonInfo)localObject2).path.equals(paramString1))) {
              ((FavoriteEmoticonInfo)localObject2).roamingType = paramString2;
            }
          }
        }
      }
    }
  }
  
  public void a(List<EmoticonInfo> paramList)
  {
    if ((!this.t.c()) && (paramList == null)) {
      return;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ((IFavroamingManagerService)this.A.getRuntimeService(IFavroamingManagerService.class)).cacheAccessibilityEmotionData();
    if (this.D == 0)
    {
      if (this.t.c()) {
        if (((List)localObject).size() == 0)
        {
          paramList = new EmoticonInfo();
          paramList.operateType = 1;
          ((List)localObject).add(0, paramList);
        }
        else if (((EmoticonInfo)((List)localObject).get(0)).operateType != 1)
        {
          paramList = new EmoticonInfo();
          paramList.operateType = 1;
          ((List)localObject).add(0, paramList);
        }
      }
      c((List)localObject);
      d((List)localObject);
    }
    else
    {
      paramList = (List<EmoticonInfo>)localObject;
      if (o()) {
        paramList = e((List)localObject);
      }
      c(paramList);
      paramList = this.t.a(paramList);
      if (paramList != null) {
        d(paramList);
      } else if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "reloadFavEmotionFinished favEmoList is null");
      }
    }
    i();
  }
  
  public void b()
  {
    this.u = false;
  }
  
  public void b(int paramInt)
  {
    this.s.setTitle(paramInt);
  }
  
  public void b(List<EmoticonInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    if ((this.t.d != null) && (!this.t.d.isEmpty())) {
      paramList.addAll(this.t.d);
    }
    if ((this.t.c()) && (this.D == 0)) {
      if (paramList.size() == 0)
      {
        localObject = new EmoticonInfo();
        ((EmoticonInfo)localObject).operateType = 1;
        paramList.add(0, localObject);
      }
      else if (((EmoticonInfo)paramList.get(0)).operateType != 1)
      {
        localObject = new EmoticonInfo();
        ((EmoticonInfo)localObject).operateType = 1;
        paramList.add(0, localObject);
      }
    }
    ((IFavroamingManagerService)this.A.getRuntimeService(IFavroamingManagerService.class)).cacheAccessibilityEmotionData();
    Object localObject = paramList;
    if (o()) {
      localObject = e(paramList);
    }
    this.l = ((List)localObject);
    this.m = ((List)localObject);
    this.d.setAdapter(this);
    i();
  }
  
  protected void c()
  {
    if (this.D == 1)
    {
      this.D = 0;
      this.t.c.set(true);
      if ((!this.t.d()) && (!VasUtil.b((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getVipStatus().isSVip())) {
        this.h.setVisibility(0);
      }
      this.a.setVisibility(8);
      this.i.setVisibility(8);
      this.q.setText(2131888873);
      this.q.setContentDescription(this.s.getString(2131888874));
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonInfo)localIterator.next()).isChecked = false;
      }
      this.t.f();
      i();
      if (this.z)
      {
        s();
        k();
      }
      if (this.E != null) {
        this.E.onEditModeChanged(false);
      }
      ReportController.b(this.A, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
      return;
    }
    if (this.D == 0)
    {
      this.D = 1;
      this.d.setSelectMode(true);
      this.t.c.set(false);
      this.a.setVisibility(0);
      c(0);
      this.q.setText(2131889474);
      this.q.setContentDescription(this.s.getString(2131888859));
      if ((this.t.d()) || (VasUtil.b((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getVipStatus().isSVip())) {
        this.h.setVisibility(8);
      }
      this.c.setAlpha(0.3F);
      this.e.setAlpha(0.3F);
      this.g.setAlpha(0.3F);
      this.f.setAlpha(0.3F);
      this.t.e();
      this.t.i();
      if (this.E != null) {
        this.E.onEditModeChanged(true);
      }
      ReportController.b(this.A, "dc00898", "", "", "0X800B8BB", "0X800B8BB", 0, 0, "", "", "", "");
      ReportController.b(this.A, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
    }
  }
  
  public void c(List<EmoticonInfo> paramList)
  {
    this.l = paramList;
  }
  
  protected void d()
  {
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (this.s.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      this.s.requestPermissions(new FavEmosmViewPage.1(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    h();
    this.t.j();
  }
  
  public void d(List<EmoticonInfo> paramList)
  {
    this.m = paramList;
    super.notifyDataSetChanged();
  }
  
  protected void e()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(this.s, 2131892157, 1).show(this.s.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)localIterator.next();
      if (localEmoticonInfo.isChecked) {
        localArrayList.add(localEmoticonInfo);
      }
    }
    ReportController.b(this.A, "dc00898", "", "", "0X800B8BE", "0X800B8BE", localArrayList.size(), 0, "", "", "", "");
    if (localArrayList.isEmpty()) {
      ((IEmosmService)QRoute.api(IEmosmService.class)).toastFMDefault(2131889423);
    } else {
      ((IEmosmService)QRoute.api(IEmosmService.class)).launchFriendPicker(this.s, localArrayList);
    }
    p();
  }
  
  protected void f()
  {
    if (this.m != null)
    {
      this.z = true;
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Object localObject3 = new ArrayList();
      Object localObject1 = ((IFavroamingDBManagerService)this.A.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
      Object localObject4 = this.m.iterator();
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext()) {
          break label294;
        }
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)((Iterator)localObject4).next();
        if (localEmoticonInfo.isChecked)
        {
          i1 = 0;
          localEmoticonInfo.isChecked = false;
          if (a(localEmoticonInfo))
          {
            localArrayList2.add(localEmoticonInfo);
            i1 = 1;
          }
          else
          {
            localArrayList3.add(localEmoticonInfo);
          }
          if (localObject1 == null) {
            continue;
          }
          Iterator localIterator = ((List)localObject1).iterator();
          if (!localIterator.hasNext()) {
            continue;
          }
          CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
          if (localCustomEmotionData.emoId != localEmoticonInfo.emoId) {
            break;
          }
          if ((i1 == 0) && (!TextUtils.isEmpty(localCustomEmotionData.resid))) {
            localArrayList4.add(localCustomEmotionData.resid);
          }
          localArrayList1.add(localCustomEmotionData);
          continue;
        }
        if (a(localEmoticonInfo)) {
          ((List)localObject2).add(localEmoticonInfo);
        } else {
          ((List)localObject3).add(localEmoticonInfo);
        }
      }
      label294:
      if ((localArrayList3.size() == 0) && (localArrayList2.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmosmViewPage", 2, "handleEmotionMove selectedList is empty!");
        }
        return;
      }
      localObject4 = (FavEmoRoamingHandler)this.A.getBusinessHandler(FavEmoRoamingHandler.a);
      if (localObject4 != null) {
        ((FavEmoRoamingHandler)localObject4).a(localArrayList4);
      }
      localArrayList4 = new ArrayList();
      if (localArrayList2.size() > 0) {
        localArrayList4.addAll(localArrayList2);
      }
      if (((List)localObject2).size() > 0) {
        localArrayList4.addAll((Collection)localObject2);
      }
      if (localArrayList3.size() > 0) {
        localArrayList4.addAll(localArrayList3);
      }
      if (((List)localObject3).size() > 0) {
        localArrayList4.addAll((Collection)localObject3);
      }
      d(localArrayList4);
      localObject2 = (IFavroamingDBManagerService)this.A.getRuntimeService(IFavroamingDBManagerService.class);
      int i2 = localArrayList1.size();
      localObject1 = ((List)localObject1).iterator();
      int i1 = 1;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (CustomEmotionData)((Iterator)localObject1).next();
        if (i1 < ((CustomEmotionData)localObject3).emoId) {
          i1 = ((CustomEmotionData)localObject3).emoId;
        }
      }
      if (i2 > 0)
      {
        int i3 = i2 - 1;
        i2 = i1;
        i1 = i3;
        while (i1 >= 0)
        {
          localObject1 = (CustomEmotionData)localArrayList1.get(i1);
          ((IFavroamingDBManagerService)localObject2).deleteCustomEmotion((CustomEmotionData)localObject1);
          localObject1 = ((CustomEmotionData)localObject1).cloneEmotionData((CustomEmotionData)localObject1);
          i2 += 1;
          ((CustomEmotionData)localObject1).emoId = i2;
          ((IFavroamingDBManagerService)localObject2).insertCustomEmotion((CustomEmotionData)localObject1);
          i1 -= 1;
        }
        ((IFavroamingDBManagerService)localObject2).trimCache();
      }
      i1 = localArrayList3.size() + localArrayList2.size();
      ReportController.b(this.A, "dc00898", "", "", "0X800B8BC", "0X800B8BC", i1, 0, String.valueOf(i1), "", "", "");
    }
  }
  
  protected void g()
  {
    Object localObject = (ActionSheet)ActionSheetHelper.b(this.s, null);
    ((ActionSheet)localObject).setMainTitle(2131888861);
    ((ActionSheet)localObject).addButton(this.s.getString(2131889261), 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new FavEmosmViewPage.2(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    localObject = this.m;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext()) {
      if (((EmoticonInfo)((Iterator)localObject).next()).isChecked) {
        i1 += 1;
      }
    }
    ReportController.b(this.A, "dc00898", "", "", "0X800B8BF", "0X800B8BF", i1, 0, "", "", "", "");
  }
  
  public int getCount()
  {
    List localList = this.m;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.m.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    FavEmosmViewPage.Holder localHolder;
    if (paramView == null)
    {
      localView = this.n.inflate(2131627955, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.j, this.k));
      localHolder = new FavEmosmViewPage.Holder(this);
      localHolder.a = ((URLImageView)localView.findViewById(2131432411));
      localHolder.b = ((ImageView)localView.findViewById(2131432413));
      localHolder.c = localView.findViewById(2131432408);
      localHolder.d = localView.findViewById(2131432409);
      localHolder.e = localView.findViewById(2131432410);
      localHolder.f = ((ImageView)localView.findViewById(2131432412));
      localView.setTag(localHolder);
    }
    else
    {
      localHolder = (FavEmosmViewPage.Holder)paramView.getTag();
      localView = paramView;
    }
    EmoticonInfo localEmoticonInfo = (EmoticonInfo)this.m.get(paramInt);
    Object localObject;
    if (localEmoticonInfo != localHolder.a.getTag(2131449867))
    {
      if (localEmoticonInfo.operateType == 1)
      {
        localHolder.a.setImageResource(2130840102);
        if (AppSetting.e) {
          localHolder.a.setContentDescription(this.s.getString(2131888857));
        }
      }
      else
      {
        paramView = localHolder.a;
        localObject = this.s.getApplicationContext();
        float f1 = this.o;
        int i1 = this.C;
        paramView.setImageDrawable(localEmoticonInfo.getZoomDrawable((Context)localObject, f1, i1, i1));
      }
      localHolder.a.setTag(2131449867, localEmoticonInfo);
    }
    if ((localEmoticonInfo instanceof ICustomEmotionInfo))
    {
      ICustomEmotionInfo localICustomEmotionInfo = (ICustomEmotionInfo)localEmoticonInfo;
      a(localEmoticonInfo, localICustomEmotionInfo.getRoamingType(), localHolder);
      if (!localICustomEmotionInfo.isChecked())
      {
        localHolder.c.setVisibility(8);
        localHolder.b.setImageResource(2130847333);
      }
      else
      {
        localHolder.c.setVisibility(0);
        localHolder.b.setImageResource(2130847336);
      }
      if (this.D == 1) {
        localHolder.b.setVisibility(0);
      } else {
        localHolder.b.setVisibility(8);
      }
      if (localEmoticonInfo.operateType != 1)
      {
        localObject = this.t.a(localEmoticonInfo);
        paramView = (View)localObject;
        if (AppSetting.e)
        {
          paramView = (View)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramView = (View)localObject;
            if (localHolder.b.getVisibility() == 0) {
              if (!localICustomEmotionInfo.isChecked())
              {
                paramView = (View)localObject;
                if (AppSetting.e)
                {
                  paramView = (View)localObject;
                  if (!TextUtils.isEmpty((CharSequence)localObject))
                  {
                    paramView = new StringBuilder();
                    paramView.append((String)localObject);
                    paramView.append(",");
                    paramView.append(this.A.getApp().getString(2131897806));
                    paramView = paramView.toString();
                  }
                }
              }
              else
              {
                paramView = (View)localObject;
                if (AppSetting.e)
                {
                  paramView = (View)localObject;
                  if (!TextUtils.isEmpty((CharSequence)localObject))
                  {
                    paramView = new StringBuilder();
                    paramView.append((String)localObject);
                    paramView.append(",");
                    paramView.append(this.A.getApp().getString(2131897754));
                    paramView = paramView.toString();
                  }
                }
              }
            }
          }
        }
        localHolder.a.setContentDescription(paramView);
      }
    }
    if (localEmoticonInfo.operateType == 1)
    {
      localHolder.c.setVisibility(8);
      localHolder.b.setVisibility(8);
      localHolder.d.setVisibility(8);
      localHolder.e.setVisibility(8);
      localHolder.f.setVisibility(8);
    }
    paramView = this.t.a(paramInt, localView, localHolder, localEmoticonInfo);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  void h()
  {
    if (this.m == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.m.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)((Iterator)localObject).next();
      if (localEmoticonInfo.isChecked) {
        localArrayList.add(localEmoticonInfo);
      }
    }
    ReportController.b(this.A, "dc00898", "", "", "0X800B8BD", "0X800B8BD", localArrayList.size(), 0, "", "", "", "");
    if (localArrayList.isEmpty())
    {
      ((IEmosmService)QRoute.api(IEmosmService.class)).toastFMDefault(2131889423);
      return;
    }
    localObject = new FileSaveDialog(this.s);
    this.t.b().a(new FavEmosmViewPage.3(this, (FileSaveDialog)localObject));
    this.t.b().a(localArrayList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 207)
    {
      d(((Integer)paramMessage.obj).intValue());
      notifyDataSetChanged();
      i();
      m();
      return false;
    }
    if (paramMessage.what == 206)
    {
      a((List)paramMessage.obj);
      return false;
    }
    if ((paramMessage.what == 208) && ((paramMessage.obj instanceof Integer)))
    {
      paramMessage = (Integer)paramMessage.obj;
      int i1 = paramMessage.intValue();
      if ((i1 != 7) && (i1 != 8)) {
        return false;
      }
      boolean bool = CameraEmoAllSend.b;
      i1 = 2;
      QLog.e("FavEmosmViewPage", 1, new Object[] { "update ui, over limit flag:", Boolean.valueOf(bool), " ret:", paramMessage, " onResumed:", Boolean.valueOf(this.u) });
      if (!CameraEmoAllSend.b)
      {
        if (!this.u) {
          return false;
        }
        CameraEmoAllSend.b = true;
        if (paramMessage.intValue() == 7) {
          i1 = 1;
        }
        EmoAddedAuthCallback.b(this.A, this.s, i1);
      }
    }
    return false;
  }
  
  void i()
  {
    if (this.m == null) {
      return;
    }
    if (getCount() > 0)
    {
      this.b.setEnabled(true);
      this.b.setTextColor(Color.parseColor("#00a5e0"));
    }
    else
    {
      this.b.setEnabled(false);
      this.b.setTextColor(Color.parseColor("#cccccc"));
    }
    Iterator localIterator = this.m.iterator();
    int i1 = 0;
    while (localIterator.hasNext()) {
      if (((EmoticonInfo)localIterator.next()).isChecked) {
        i1 += 1;
      }
    }
    if (this.t.e)
    {
      if (i1 >= 0)
      {
        this.c.setEnabled(true);
        return;
      }
      this.c.setEnabled(false);
      return;
    }
    if (i1 > 0)
    {
      this.c.setEnabled(true);
      this.e.setEnabled(true);
      this.g.setEnabled(true);
      this.f.setEnabled(true);
      this.c.setAlpha(1.0F);
      this.e.setAlpha(1.0F);
      this.g.setAlpha(1.0F);
      this.f.setAlpha(1.0F);
    }
    else
    {
      this.c.setEnabled(false);
      this.e.setEnabled(false);
      this.g.setEnabled(false);
      this.f.setEnabled(false);
      this.c.setAlpha(0.3F);
      this.e.setAlpha(0.3F);
      this.g.setAlpha(0.3F);
      this.f.setAlpha(0.3F);
    }
    c(i1);
    this.c.setText(this.s.getString(2131888860));
  }
  
  protected void j()
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).enterNewPhotoList(this.s);
  }
  
  public void k()
  {
    this.t.a(new FavEmosmViewPage.4(this));
  }
  
  public Handler l()
  {
    return this.B;
  }
  
  void m()
  {
    BaseEmosmStrategy localBaseEmosmStrategy = this.t;
    if (localBaseEmosmStrategy != null) {
      localBaseEmosmStrategy.o();
    }
  }
  
  public void n()
  {
    s();
    this.E = null;
  }
  
  public boolean o()
  {
    return this.D == 1;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131436180)
    {
      ReportController.b(this.A, "dc00898", "", "", "0X800B8BA", "0X800B8BA", 0, 0, "", "", "", "");
      this.s.finish();
    }
    else if (i1 == 2131436211)
    {
      if (this.t.f)
      {
        ReportController.b(this.A, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
        this.s.finish();
      }
      else
      {
        c();
      }
    }
    else
    {
      Object localObject;
      if (i1 == 2131432406)
      {
        localObject = this.m;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            EmoticonInfo localEmoticonInfo = (EmoticonInfo)((Iterator)localObject).next();
            if ((localEmoticonInfo instanceof ICustomEmotionInfo)) {
              localEmoticonInfo.isChecked = true;
            }
          }
          notifyDataSetChanged();
          i();
          ReportController.b(this.A, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
        }
      }
      else if (i1 == 2131432405)
      {
        g();
      }
      else if (i1 == 2131429876)
      {
        localObject = this.s;
        VasH5PayUtil.a((Context)localObject, "mvip.n.a.bqsc_edit", 3, "1450000516", "CJCLUBT", ((QIphoneTitleBarActivity)localObject).getString(2131916948), "");
      }
      else if (i1 == 2131432416)
      {
        d();
      }
      else if (i1 == 2131432407)
      {
        e();
      }
      else if (i1 == 2131438896)
      {
        f();
        i();
        a(2131888865);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.t.a(paramAdapterView, paramView, paramInt, paramLong)) {
      return;
    }
    if (this.D == 0)
    {
      if ((this.t.c()) && (paramInt == 0))
      {
        paramAdapterView = this.m;
        if ((paramAdapterView != null) && (paramAdapterView.size() > 0) && (((EmoticonInfo)paramAdapterView.get(0)).operateType == 1))
        {
          r();
          return;
        }
      }
      paramAdapterView = getItem(paramInt);
      if ((paramAdapterView instanceof ICustomEmotionInfo))
      {
        paramAdapterView = (ICustomEmotionInfo)paramAdapterView;
        String str = paramAdapterView.getRoamingType();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemClick roamingType = ");
          localStringBuilder.append(str);
          QLog.d("FavEmosmViewPage", 2, localStringBuilder.toString());
        }
        if ((!TextUtils.isEmpty(str)) && (str.equals("needUpload")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_NEED_UPLOAD");
          }
        }
        else
        {
          if ((!TextUtils.isEmpty(str)) && (str.equals("failed")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_FAILED");
            }
            this.t.a(this.d, paramInt, paramAdapterView);
            return;
          }
          if ((!TextUtils.isEmpty(str)) && (str.equals("needDownload")))
          {
            a(paramView, paramInt);
            return;
          }
          paramAdapterView = (FavEmosmViewPage.Holder)paramView.getTag();
          ((IEmosmService)QRoute.api(IEmosmService.class)).enterEmotionPreview(this.s, (EmoticonInfo)getItem(paramInt), ((IEmosmService)QRoute.api(IEmosmService.class)).getViewRect(paramAdapterView.a));
        }
      }
      return;
    }
    paramAdapterView = getItem(paramInt);
    if ((paramAdapterView instanceof EmoticonInfo))
    {
      paramAdapterView = (EmoticonInfo)paramAdapterView;
      paramAdapterView.isChecked ^= true;
    }
    a(this.d, paramInt);
    i();
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (this.D == 0) {
      return;
    }
    if (getCount() <= paramInt) {
      return;
    }
    Object localObject = getItem(paramInt);
    if (!ICustomEmotionInfo.class.isInstance(localObject)) {
      return;
    }
    localObject = (ICustomEmotionInfo)localObject;
    this.w = ((ICustomEmotionInfo)localObject).isChecked();
    ((ICustomEmotionInfo)localObject).setIsChecked(this.w ^ true);
    this.d.invalidateViews();
    this.v = true;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onSelectBegin");
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (this.D == 0) {
      return;
    }
    if (!this.v) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, new Object[] { "onSelectBegin beginIndex:", Integer.valueOf(paramInt1), "  selectIndex:", Integer.valueOf(paramInt2) });
    }
    int i1;
    int i2;
    if (paramInt2 < paramInt1)
    {
      if (this.y > paramInt2) {
        this.y = paramInt2;
      }
      i1 = paramInt2;
      i2 = paramInt1;
    }
    else
    {
      i1 = paramInt1;
      i2 = paramInt2;
      if (this.x < paramInt2)
      {
        this.x = paramInt2;
        i2 = paramInt2;
        i1 = paramInt1;
      }
    }
    paramInt1 = i1;
    Object localObject;
    while (paramInt1 <= i2)
    {
      localObject = getItem(paramInt1);
      if (ICustomEmotionInfo.class.isInstance(localObject)) {
        ((ICustomEmotionInfo)localObject).setIsChecked(this.w ^ true);
      }
      paramInt1 += 1;
    }
    paramInt1 = i2 + 1;
    while (paramInt1 <= this.x)
    {
      localObject = getItem(paramInt1);
      if (ICustomEmotionInfo.class.isInstance(localObject)) {
        ((ICustomEmotionInfo)localObject).setIsChecked(this.w);
      }
      paramInt1 += 1;
    }
    paramInt1 = this.y;
    while (paramInt1 < i1)
    {
      localObject = getItem(paramInt1);
      if (ICustomEmotionInfo.class.isInstance(localObject)) {
        ((ICustomEmotionInfo)localObject).setIsChecked(this.w);
      }
      paramInt1 += 1;
    }
    this.d.invalidateViews();
    i();
  }
  
  public void onSelectEnd()
  {
    if (this.D == 0) {
      return;
    }
    if (!this.v) {
      return;
    }
    this.v = false;
    this.w = false;
    this.x = -2147483648;
    this.y = 2147483647;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onSelectEnd");
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage
 * JD-Core Version:    0.7.0.1
 */