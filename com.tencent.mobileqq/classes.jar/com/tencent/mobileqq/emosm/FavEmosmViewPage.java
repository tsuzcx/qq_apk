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
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  QIphoneTitleBarActivity jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity;
  protected BaseEmosmStrategy a;
  private volatile FavEmosmViewPage.IEmosmViewPagerListener jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$IEmosmViewPagerListener = null;
  GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  List<EmoticonInfo> jdField_a_of_type_JavaUtilList = null;
  protected boolean a;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  List<EmoticonInfo> jdField_b_of_type_JavaUtilList = null;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -2147483648;
  public TextView c;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 2147483647;
  public TextView d;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private volatile int jdField_f_of_type_Int = 0;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  
  public FavEmosmViewPage() {}
  
  public FavEmosmViewPage(BaseQQAppInterface paramBaseQQAppInterface, QIphoneTitleBarActivity paramQIphoneTitleBarActivity)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity = paramQIphoneTitleBarActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramQIphoneTitleBarActivity.getLayoutInflater();
    this.jdField_a_of_type_Float = paramQIphoneTitleBarActivity.getApplicationContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Int = EmotionUtils.a(88.0F, paramQIphoneTitleBarActivity.getResources());
  }
  
  private List<EmoticonInfo> a(List<EmoticonInfo> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = a();
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
  
  private ConcurrentHashMap<Integer, Boolean> a()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = this.jdField_b_of_type_JavaUtilList;
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
  
  private void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_PANEL");
    }
    paramView = (FavEmosmViewPage.Holder)paramView.getTag();
    Object localObject = paramView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
    if ((localObject instanceof URLDrawable))
    {
      localObject = (URLDrawable)localObject;
      if ((((URLDrawable)localObject).getStatus() != 3) && (((URLDrawable)localObject).getStatus() != 2))
      {
        if (((URLDrawable)localObject).getStatus() == 1) {
          ((IEmosmService)QRoute.api(IEmosmService.class)).enterEmotionPreview(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity, (EmoticonInfo)getItem(paramInt), ((IEmosmService)QRoute.api(IEmosmService.class)).getViewRect(paramView.jdField_a_of_type_ComTencentImageURLImageView));
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
    paramHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramHolder.c.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    Animatable localAnimatable = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839401);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localAnimatable);
    localAnimatable.start();
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_f_of_type_Int == 1)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(EmoticonInfo paramEmoticonInfo, String paramString, FavEmosmViewPage.Holder paramHolder)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramHolder != null))
    {
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(null);
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
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getBaseContext();
      int i = this.jdField_e_of_type_Int;
      if ((paramEmoticonInfo.getZoomDrawable(paramString, 0.0F, i, i) instanceof URLDrawable))
      {
        paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new FavEmosmViewPage.6(this, paramEmoticonInfo, paramHolder));
        a(paramHolder.jdField_a_of_type_ComTencentImageURLImageView, paramHolder);
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
    paramHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramHolder.c.setVisibility(0);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (this.jdField_f_of_type_Int == 1)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_f_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.setTitle(this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a());
      return;
    }
    if (this.jdField_f_of_type_Int == 1)
    {
      String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131691905), new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.setTitle(str);
    }
  }
  
  private void c(FavEmosmViewPage.Holder paramHolder)
  {
    d(paramHolder);
    paramHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramHolder.c.setVisibility(8);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (this.jdField_f_of_type_Int == 1)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (paramInt < ((List)localObject).size()))
    {
      localObject = (EmoticonInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      this.jdField_b_of_type_JavaUtilList.remove(paramInt);
    }
    else
    {
      localObject = null;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localObject != null))
    {
      localList.remove(localObject);
      ((IFavroamingManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).removeCacheAccessibilityEmotionData(Integer.valueOf(((EmoticonInfo)localObject).emoId));
    }
  }
  
  private void d(FavEmosmViewPage.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    Object localObject = paramHolder.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131380884);
    if ((localObject instanceof ICustomEmotionInfo))
    {
      if (!((ICustomEmotionInfo)localObject).isChecked())
      {
        paramHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      paramHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void n()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
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
  
  private void o()
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.requestPermissions(new FavEmosmViewPage.5(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    j();
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
  }
  
  private void p()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      ((FavEmoRoamingHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.a)).notifyUI(2, true, null);
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(paramInt), 0).a();
  }
  
  public void a(BaseEmosmStrategy paramBaseEmosmStrategy)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy = paramBaseEmosmStrategy;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getResources();
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int j = EmotionUtils.a(0.0F, (Resources)localObject);
    int k = EmotionUtils.a(4.0F, (Resources)localObject);
    int m = EmotionUtils.a(4.0F, (Resources)localObject);
    this.jdField_a_of_type_Int = ((i - j * 2 - k * 3) / 4);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_f_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.rightViewText;
    this.jdField_e_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.leftView;
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131691906);
    this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131691907));
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131366118));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131366120));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131366119));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131366130));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131691899));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131366121));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131691909));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131371520));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131366128));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131366129));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131366078));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(m);
    localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
    ((GestureSelectGridView)localObject).setPadding(j, ((GestureSelectGridView)localObject).getPaddingTop(), j, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getResources().getDisplayMetrics().density * 2500.0F));
    if ((paramBaseEmosmStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity)) && (paramBaseEmosmStrategy.jdField_a_of_type_Boolean))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131699722);
      localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131363920));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((paramBaseEmosmStrategy.b()) || (VasUtil.a((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getVipStatus().isSVip())) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void a(FavEmosmViewPage.IEmosmViewPagerListener paramIEmosmViewPagerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$IEmosmViewPagerListener = paramIEmosmViewPagerListener;
  }
  
  public void a(GridView paramGridView, int paramInt)
  {
    if (paramGridView != null)
    {
      if (paramInt < 0) {
        return;
      }
      int i = paramGridView.getFirstVisiblePosition();
      int j = paramGridView.getLastVisiblePosition();
      if ((paramInt >= i) && (paramInt <= j)) {
        getView(paramInt, paramGridView.getChildAt(paramInt - i), paramGridView);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilList;
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
    if ((!this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a()) && (paramList == null)) {
      return;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ((IFavroamingManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).cacheAccessibilityEmotionData();
    if (this.jdField_f_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a()) {
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
      if (a()) {
        paramList = a((List)localObject);
      }
      c(paramList);
      paramList = this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a(paramList);
      if (paramList != null) {
        d(paramList);
      } else if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "reloadFavEmotionFinished favEmoList is null");
      }
    }
    i();
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Int == 1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.setTitle(paramInt);
  }
  
  public void b(List<EmoticonInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.jdField_a_of_type_JavaUtilList);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a()) && (this.jdField_f_of_type_Int == 0)) {
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
    ((IFavroamingManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).cacheAccessibilityEmotionData();
    Object localObject = paramList;
    if (a()) {
      localObject = a(paramList);
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    this.jdField_b_of_type_JavaUtilList = ((List)localObject);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this);
    i();
  }
  
  protected void c()
  {
    if (this.jdField_f_of_type_Int == 1)
    {
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.b()) && (!VasUtil.a((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getVipStatus().isSVip())) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131691906);
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131691907));
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonInfo)localIterator.next()).isChecked = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.c();
      i();
      if (this.jdField_d_of_type_Boolean)
      {
        p();
        k();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$IEmosmViewPagerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$IEmosmViewPagerListener.onEditModeChanged(false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_f_of_type_Int == 0)
    {
      this.jdField_f_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
      this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      c(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131692486);
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131691892));
      if ((this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.b()) || (VasUtil.a((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getVipStatus().isSVip())) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      this.jdField_d_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.b();
      this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.e();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$IEmosmViewPagerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$IEmosmViewPagerListener.onEditModeChanged(true);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800B8BB", "0X800B8BB", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
    }
  }
  
  public void c(List<EmoticonInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected void d()
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.requestPermissions(new FavEmosmViewPage.1(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.f();
  }
  
  public void d(List<EmoticonInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  protected void e()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity, 2131694475, 1).b(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)localIterator.next();
      if (localEmoticonInfo.isChecked) {
        localArrayList.add(localEmoticonInfo);
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800B8BE", "0X800B8BE", localArrayList.size(), 0, "", "", "", "");
    if (localArrayList.isEmpty()) {
      ((IEmosmService)QRoute.api(IEmosmService.class)).toastFMDefault(2131692435);
    } else {
      ((IEmosmService)QRoute.api(IEmosmService.class)).launchFriendPicker(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity, localArrayList);
    }
    n();
  }
  
  protected void f()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_d_of_type_Boolean = true;
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Object localObject3 = new ArrayList();
      Object localObject1 = ((IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
      Object localObject4 = this.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext()) {
          break label294;
        }
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)((Iterator)localObject4).next();
        if (localEmoticonInfo.isChecked)
        {
          i = 0;
          localEmoticonInfo.isChecked = false;
          if (a(localEmoticonInfo))
          {
            localArrayList2.add(localEmoticonInfo);
            i = 1;
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
          if ((i == 0) && (!TextUtils.isEmpty(localCustomEmotionData.resid))) {
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
      localObject4 = (FavEmoRoamingHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.a);
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
      localObject2 = (IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
      int j = localArrayList1.size();
      localObject1 = ((List)localObject1).iterator();
      int i = 1;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (CustomEmotionData)((Iterator)localObject1).next();
        if (i < ((CustomEmotionData)localObject3).emoId) {
          i = ((CustomEmotionData)localObject3).emoId;
        }
      }
      if (j > 0)
      {
        int k = j - 1;
        j = i;
        i = k;
        while (i >= 0)
        {
          localObject1 = (CustomEmotionData)localArrayList1.get(i);
          ((IFavroamingDBManagerService)localObject2).deleteCustomEmotion((CustomEmotionData)localObject1);
          localObject1 = ((CustomEmotionData)localObject1).cloneEmotionData((CustomEmotionData)localObject1);
          j += 1;
          ((CustomEmotionData)localObject1).emoId = j;
          ((IFavroamingDBManagerService)localObject2).insertCustomEmotion((CustomEmotionData)localObject1);
          i -= 1;
        }
        ((IFavroamingDBManagerService)localObject2).trimCache();
      }
      i = localArrayList3.size() + localArrayList2.size();
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800B8BC", "0X800B8BC", i, 0, String.valueOf(i), "", "", "");
    }
  }
  
  protected void g()
  {
    Object localObject = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity, null);
    ((ActionSheet)localObject).setMainTitle(2131691894);
    ((ActionSheet)localObject).addButton(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131692273), 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new FavEmosmViewPage.2(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      if (((EmoticonInfo)((Iterator)localObject).next()).isChecked) {
        i += 1;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800B8BF", "0X800B8BF", i, 0, "", "", "", "");
  }
  
  public int getCount()
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561592, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      localHolder = new FavEmosmViewPage.Holder(this);
      localHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131366125));
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366127));
      localHolder.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366122);
      localHolder.jdField_b_of_type_AndroidViewView = localView.findViewById(2131366123);
      localHolder.c = localView.findViewById(2131366124);
      localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366126));
      localView.setTag(localHolder);
    }
    else
    {
      localHolder = (FavEmosmViewPage.Holder)paramView.getTag();
      localView = paramView;
    }
    EmoticonInfo localEmoticonInfo = (EmoticonInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localEmoticonInfo != localHolder.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131380884))
    {
      if (localEmoticonInfo.operateType == 1)
      {
        localHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130839633);
        if (AppSetting.jdField_d_of_type_Boolean) {
          localHolder.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131691890));
        }
      }
      else
      {
        paramView = localHolder.jdField_a_of_type_ComTencentImageURLImageView;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getApplicationContext();
        float f1 = this.jdField_a_of_type_Float;
        int i = this.jdField_e_of_type_Int;
        paramView.setImageDrawable(localEmoticonInfo.getZoomDrawable((Context)localObject, f1, i, i));
      }
      localHolder.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131380884, localEmoticonInfo);
    }
    if ((localEmoticonInfo instanceof ICustomEmotionInfo))
    {
      ICustomEmotionInfo localICustomEmotionInfo = (ICustomEmotionInfo)localEmoticonInfo;
      a(localEmoticonInfo, localICustomEmotionInfo.getRoamingType(), localHolder);
      if (!localICustomEmotionInfo.isChecked())
      {
        localHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845863);
      }
      else
      {
        localHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845866);
      }
      if (this.jdField_f_of_type_Int == 1) {
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (localEmoticonInfo.operateType != 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a(localEmoticonInfo);
        paramView = (View)localObject;
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          paramView = (View)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramView = (View)localObject;
            if (localHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
              if (!localICustomEmotionInfo.isChecked())
              {
                paramView = (View)localObject;
                if (AppSetting.jdField_d_of_type_Boolean)
                {
                  paramView = (View)localObject;
                  if (!TextUtils.isEmpty((CharSequence)localObject))
                  {
                    paramView = new StringBuilder();
                    paramView.append((String)localObject);
                    paramView.append(",");
                    paramView.append(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApp().getString(2131699773));
                    paramView = paramView.toString();
                  }
                }
              }
              else
              {
                paramView = (View)localObject;
                if (AppSetting.jdField_d_of_type_Boolean)
                {
                  paramView = (View)localObject;
                  if (!TextUtils.isEmpty((CharSequence)localObject))
                  {
                    paramView = new StringBuilder();
                    paramView.append((String)localObject);
                    paramView.append(",");
                    paramView.append(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApp().getString(2131699721));
                    paramView = paramView.toString();
                  }
                }
              }
            }
          }
        }
        localHolder.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(paramView);
      }
    }
    if (localEmoticonInfo.operateType == 1)
    {
      localHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      localHolder.c.setVisibility(8);
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a(paramInt, localView, localHolder, localEmoticonInfo);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  void h()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)((Iterator)localObject).next();
      if (localEmoticonInfo.isChecked) {
        localArrayList.add(localEmoticonInfo);
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800B8BD", "0X800B8BD", localArrayList.size(), 0, "", "", "", "");
    if (localArrayList.isEmpty())
    {
      ((IEmosmService)QRoute.api(IEmosmService.class)).toastFMDefault(2131692435);
      return;
    }
    localObject = new FileSaveDialog(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity);
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a().a(new FavEmosmViewPage.3(this, (FileSaveDialog)localObject));
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a().a(localArrayList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 207)
    {
      d(((Integer)paramMessage.obj).intValue());
      notifyDataSetChanged();
      i();
      l();
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
      int i = paramMessage.intValue();
      if ((i != 7) && (i != 8)) {
        return false;
      }
      boolean bool = CameraEmoAllSend.jdField_b_of_type_Boolean;
      i = 2;
      QLog.e("FavEmosmViewPage", 1, new Object[] { "update ui, over limit flag:", Boolean.valueOf(bool), " ret:", paramMessage, " onResumed:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      if (!CameraEmoAllSend.jdField_b_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_Boolean) {
          return false;
        }
        CameraEmoAllSend.jdField_b_of_type_Boolean = true;
        if (paramMessage.intValue() == 7) {
          i = 1;
        }
        EmoAddedAuthCallback.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity, i);
      }
    }
    return false;
  }
  
  void i()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (getCount() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#00a5e0"));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#cccccc"));
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((EmoticonInfo)localIterator.next()).isChecked) {
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.jdField_a_of_type_Boolean)
    {
      if (i >= 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      return;
    }
    if (i > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      this.jdField_d_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.3F);
    }
    c(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131691893));
  }
  
  protected void j()
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).enterNewPhotoList(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a(new FavEmosmViewPage.4(this));
  }
  
  void l()
  {
    BaseEmosmStrategy localBaseEmosmStrategy = this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy;
    if (localBaseEmosmStrategy != null) {
      localBaseEmosmStrategy.j();
    }
  }
  
  public void m()
  {
    p();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$IEmosmViewPagerListener = null;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369202)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800B8BA", "0X800B8BA", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.finish();
    }
    else if (i == 2131369233)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.jdField_b_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.finish();
      }
      else
      {
        c();
      }
    }
    else
    {
      Object localObject;
      if (i == 2131366120)
      {
        localObject = this.jdField_b_of_type_JavaUtilList;
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
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
        }
      }
      else if (i == 2131366119)
      {
        g();
      }
      else if (i == 2131363920)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity;
        VasH5PayUtil.a((Context)localObject, "mvip.n.a.bqsc_edit", 3, "1450000516", "CJCLUBT", ((QIphoneTitleBarActivity)localObject).getString(2131719393), "");
      }
      else if (i == 2131366130)
      {
        d();
      }
      else if (i == 2131366121)
      {
        e();
      }
      else if (i == 2131371520)
      {
        f();
        i();
        a(2131691898);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a(paramAdapterView, paramView, paramInt, paramLong)) {
      return;
    }
    if (this.jdField_f_of_type_Int == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a()) && (paramInt == 0))
      {
        paramAdapterView = this.jdField_b_of_type_JavaUtilList;
        if ((paramAdapterView != null) && (paramAdapterView.size() > 0) && (((EmoticonInfo)paramAdapterView.get(0)).operateType == 1))
        {
          o();
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
            this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, paramInt, paramAdapterView);
            return;
          }
          if ((!TextUtils.isEmpty(str)) && (str.equals("needDownload")))
          {
            a(paramView, paramInt);
            return;
          }
          paramAdapterView = (FavEmosmViewPage.Holder)paramView.getTag();
          ((IEmosmService)QRoute.api(IEmosmService.class)).enterEmotionPreview(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity, (EmoticonInfo)getItem(paramInt), ((IEmosmService)QRoute.api(IEmosmService.class)).getViewRect(paramAdapterView.jdField_a_of_type_ComTencentImageURLImageView));
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
    a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, paramInt);
    i();
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (this.jdField_f_of_type_Int == 0) {
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
    this.jdField_c_of_type_Boolean = ((ICustomEmotionInfo)localObject).isChecked();
    ((ICustomEmotionInfo)localObject).setIsChecked(this.jdField_c_of_type_Boolean ^ true);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onSelectBegin");
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (this.jdField_f_of_type_Int == 0) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, new Object[] { "onSelectBegin beginIndex:", Integer.valueOf(paramInt1), "  selectIndex:", Integer.valueOf(paramInt2) });
    }
    int i;
    int j;
    if (paramInt2 < paramInt1)
    {
      if (this.jdField_d_of_type_Int > paramInt2) {
        this.jdField_d_of_type_Int = paramInt2;
      }
      i = paramInt2;
      j = paramInt1;
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
      if (this.jdField_c_of_type_Int < paramInt2)
      {
        this.jdField_c_of_type_Int = paramInt2;
        j = paramInt2;
        i = paramInt1;
      }
    }
    paramInt1 = i;
    Object localObject;
    while (paramInt1 <= j)
    {
      localObject = getItem(paramInt1);
      if (ICustomEmotionInfo.class.isInstance(localObject)) {
        ((ICustomEmotionInfo)localObject).setIsChecked(this.jdField_c_of_type_Boolean ^ true);
      }
      paramInt1 += 1;
    }
    paramInt1 = j + 1;
    while (paramInt1 <= this.jdField_c_of_type_Int)
    {
      localObject = getItem(paramInt1);
      if (ICustomEmotionInfo.class.isInstance(localObject)) {
        ((ICustomEmotionInfo)localObject).setIsChecked(this.jdField_c_of_type_Boolean);
      }
      paramInt1 += 1;
    }
    paramInt1 = this.jdField_d_of_type_Int;
    while (paramInt1 < i)
    {
      localObject = getItem(paramInt1);
      if (ICustomEmotionInfo.class.isInstance(localObject)) {
        ((ICustomEmotionInfo)localObject).setIsChecked(this.jdField_c_of_type_Boolean);
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    i();
  }
  
  public void onSelectEnd()
  {
    if (this.jdField_f_of_type_Int == 0) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = 2147483647;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onSelectEnd");
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage
 * JD-Core Version:    0.7.0.1
 */