package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewConfigurationCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterViewPagerAdapter;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.XListView.MotionEventInterceptor;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QzonePhotoView
  extends LinearLayout
  implements Handler.Callback, XListView.MotionEventInterceptor
{
  QQAppInterface a;
  View b;
  CoverCacheData c;
  public boolean d;
  private float e;
  private int f;
  private int g;
  private int h;
  private boolean i = false;
  private Activity j;
  private ProfileCardInfo k;
  private Handler l;
  private String m;
  private int n;
  private List<QzonePhotoView.PhotoInfo> o;
  private int[] p = new int[2];
  private int[] q = new int[2];
  private int r;
  private int s;
  private ImageView t;
  private View u;
  private ITemplateUtils v;
  private View.OnClickListener w = new QzonePhotoView.3(this);
  private float x;
  private float y;
  
  public QzonePhotoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzonePhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private List<QzonePhotoView.PhotoInfo> a(String paramString, List<Map<Integer, String>> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update");
      ((StringBuilder)localObject).append("|type = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("|vecUrls = ");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("ProfileCard.QzonePhotoView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.c == null) {
      this.c = new CoverCacheData();
    }
    Object localObject = this.c;
    ((CoverCacheData)localObject).type = paramString;
    ((CoverCacheData)localObject).photoWall = ((ArrayList)paramList);
    ((CoverCacheData)localObject).uin = Long.parseLong(this.m);
    int i2 = 0;
    int i1;
    if (paramList != null) {
      i1 = paramList.size();
    } else {
      i1 = 0;
    }
    while ((i2 < i1) && (i2 < 16))
    {
      paramString = (Map)paramList.get(i2);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.PhotoInfo(i2, 100, paramString);
        paramString.e = localLinkedList.size();
        localLinkedList.add(paramString);
      }
      i2 += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("updateCoverData photoInfo size=");
      paramString.append(localLinkedList.size());
      QLog.i("ProfileCard.QzonePhotoView", 2, paramString.toString());
    }
    return localLinkedList;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = "https://ti.qq.com/photowall/index.html?_wv=1027";
    if (!paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://ti.qq.com/photowall/index.html?_wv=1027");
      ((StringBuilder)localObject).append("&uin=");
      ((StringBuilder)localObject).append(this.m);
      localObject = ((StringBuilder)localObject).toString();
    }
    Intent localIntent = new Intent(this.j, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", (String)localObject);
    if (!paramBoolean)
    {
      this.j.startActivity(localIntent);
      return;
    }
    this.j.startActivityForResult(localIntent, 100);
  }
  
  public void a()
  {
    this.l.removeCallbacksAndMessages(null);
  }
  
  public void a(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "initView");
    }
    this.a = ((QQAppInterface)paramQBaseActivity.getAppRuntime());
    this.j = paramQBaseActivity;
    this.k = paramProfileCardInfo;
    this.l = new Handler(this);
    boolean bool = false;
    this.n = 0;
    this.m = paramProfileCardInfo.allInOne.uin;
    this.b = LayoutInflater.from(this.a.getApplication()).inflate(2131628454, this, true);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.e = localDisplayMetrics.density;
    this.f = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i1 = getResources().getDimensionPixelSize(2131299336);
    this.h = getResources().getDimensionPixelSize(2131299335);
    this.g = ((this.f - i1 * 2 - this.h * 3) / 4);
    if (paramProfileCardInfo.allInOne.pa == 0) {
      bool = true;
    }
    this.i = bool;
    ThreadManager.post(new QzonePhotoView.1(this), 8, null, true);
    paramProfileCardInfo = Message.obtain();
    paramProfileCardInfo.what = 100;
    this.l.sendMessage(paramProfileCardInfo);
    this.r = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramQBaseActivity));
  }
  
  public void a(List<QzonePhotoView.PhotoInfo> paramList)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((QLog.isColorLevel()) && (paramList != null))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updatePhotoView photoInfo size=");
          ((StringBuilder)localObject1).append(paramList.size());
          QLog.i("ProfileCard.QzonePhotoView", 2, ((StringBuilder)localObject1).toString());
        }
        this.o = paramList;
        if (paramList != null)
        {
          i1 = paramList.size();
          this.t = ((ImageView)this.b.findViewById(2131440723));
          this.u = this.b.findViewById(2131443117);
          this.u.setTag(new DataTag(25, null));
          this.u.setOnClickListener(this.w);
          Object localObject2 = ProfileCardTemplateUtil.a(-1L);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ProfileCardUtil.a(getContext(), 188);
            int i2 = ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight;
            double d1 = i2;
            Double.isNaN(d1);
            d1 = d1 * 1.0D / 376.0D;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ((int)Math.ceil(d1 * 640.0D));
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(getResources().getColor(2131165715));
            localObject2 = URLDrawable.getDrawable(new File((String)localObject2, "qvip_profile_photo_black_addimage_tips.png"), (URLDrawable.URLDrawableOptions)localObject1);
            ((Drawable)localObject2).setBounds(0, 0, ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight);
            this.t.setImageDrawable((Drawable)localObject2);
          }
          this.t.setTag(new DataTag(25, null));
          this.t.setOnClickListener(this.w);
          localObject1 = (ViewPager)this.b.findViewById(2131440119);
          localObject2 = (CirclePageIndicator)this.b.findViewById(2131439795);
          if (i1 > 0)
          {
            QzonePhotoView.PhotoGridAdapter localPhotoGridAdapter = new QzonePhotoView.PhotoGridAdapter(this);
            localPhotoGridAdapter.a(paramList);
            localPhotoGridAdapter.a(this.g, this.g);
            paramList = new AdapterViewPagerAdapter(getContext(), localPhotoGridAdapter, 8);
            paramList.a(new QzonePhotoView.2(this));
            ViewGroup.LayoutParams localLayoutParams = ((ViewPager)localObject1).getLayoutParams();
            localLayoutParams.width = this.f;
            if (localPhotoGridAdapter.getCount() > 4)
            {
              i1 = this.g * 2 + this.h;
            }
            else
            {
              i1 = this.g;
              i1 = this.h + i1;
            }
            localLayoutParams.height = i1;
            ((ViewPager)localObject1).setLayoutParams(localLayoutParams);
            ((ViewPager)localObject1).setAdapter(paramList);
            i1 = paramList.getCount();
            ((CirclePageIndicator)localObject2).setViewPager((ViewPager)localObject1);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            ((ViewPager)localObject1).setVisibility(0);
            if (i1 > 1) {
              ((CirclePageIndicator)localObject2).setVisibility(0);
            } else {
              ((CirclePageIndicator)localObject2).setVisibility(8);
            }
            setVisibility(0);
            return;
          }
          if (this.i)
          {
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            ((ViewPager)localObject1).setVisibility(8);
            ((CirclePageIndicator)localObject2).setVisibility(8);
            setVisibility(0);
            return;
          }
          this.t.setVisibility(8);
          this.u.setVisibility(8);
          setVisibility(8);
          return;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      int i1 = 0;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetQZoneCover|isSuc = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",mUin=");
      ((StringBuilder)localObject).append(this.m);
      QLog.i("ProfileCard.QzonePhotoView", 2, ((StringBuilder)localObject).toString());
    }
    if (!Utils.a(paramString, this.m)) {
      return;
    }
    if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
    {
      paramString = new ArrayList();
      boolean bool = false;
      int i1 = 0;
      while (i1 < parammobile_sub_get_photo_wall_rsp.vecUrls.size())
      {
        paramString.add(((PhotoWall)parammobile_sub_get_photo_wall_rsp.vecUrls.get(i1)).photoUrls);
        i1 += 1;
      }
      localObject = a("", paramString);
      paramString = null;
      parammobile_sub_get_photo_wall_rsp = paramString;
      i1 = 0;
      for (;;)
      {
        paramBoolean = bool;
        if (i1 >= 16) {
          break;
        }
        paramString = this.o;
        if ((paramString != null) && (paramString.size() > i1)) {
          paramString = (QzonePhotoView.PhotoInfo)this.o.get(i1);
        } else {
          paramString = null;
        }
        if ((localObject != null) && (((List)localObject).size() > i1)) {
          parammobile_sub_get_photo_wall_rsp = (QzonePhotoView.PhotoInfo)((List)localObject).get(i1);
        } else {
          parammobile_sub_get_photo_wall_rsp = null;
        }
        if (!Utils.a(paramString, parammobile_sub_get_photo_wall_rsp))
        {
          paramBoolean = true;
          break;
        }
        i1 += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetQZoneCover  isNewPhoto=");
        localStringBuilder.append(String.valueOf(paramBoolean));
        QLog.i("ProfileCard.QzonePhotoView", 2, localStringBuilder.toString());
      }
      if ((paramBoolean) || ((paramString == null) && (parammobile_sub_get_photo_wall_rsp == null))) {
        a((List)localObject);
      }
    }
    else if ((NetworkUtil.isWifiEnabled(BaseApplication.getContext())) && (this.n < 3))
    {
      paramString = Message.obtain();
      paramString.what = 100;
      this.l.sendMessage(paramString);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.t.getVisibility() == 0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public CoverCacheData getCoverCacheData()
  {
    return this.c;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 100)
    {
      if (i1 != 200)
      {
        if (i1 == 201)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.QzonePhotoView", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
          }
          ((PhotoWallHandler)this.a.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(this.m, "");
          this.l.removeMessages(201);
        }
      }
      else
      {
        if ((paramMessage.obj instanceof LinkedList)) {
          a((List)paramMessage.obj);
        }
        this.l.sendEmptyMessage(201);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (paramMessage != null)
      {
        paramMessage.b(this.m, 2);
        this.n += 1;
      }
      this.l.removeMessages(100);
    }
    return false;
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    ViewPager localViewPager = (ViewPager)this.b.findViewById(2131440119);
    paramView.getLocationInWindow(this.p);
    localViewPager.getLocationInWindow(this.q);
    float f1 = paramMotionEvent.getRawY();
    int i1 = localViewPager.getVisibility();
    boolean bool3 = false;
    if (i1 == 0)
    {
      paramView = this.q;
      if ((f1 >= paramView[1]) && (f1 < paramView[1] + localViewPager.getHeight()))
      {
        i1 = 1;
        break label90;
      }
    }
    i1 = 0;
    label90:
    paramMotionEvent.offsetLocation(0.0F, this.p[1] - this.q[1]);
    int i2 = paramMotionEvent.getAction();
    boolean bool2;
    if (i2 != 0)
    {
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 != 3) {
            break label514;
          }
        }
        else
        {
          if (i1 != 0)
          {
            if ((this.d) && (this.s == 0))
            {
              f1 = Math.abs(paramMotionEvent.getX() - this.x);
              float f2 = Math.abs(paramMotionEvent.getY() - this.y);
              if (QLog.isColorLevel())
              {
                paramView = new StringBuilder();
                paramView.append("Action move curX = ");
                paramView.append(paramMotionEvent.getX());
                paramView.append(" xDiff = ");
                paramView.append(f1);
                paramView.append(" mTouchSlop = ");
                paramView.append(this.r);
                QLog.d("ProfileCard.QzonePhotoView", 2, paramView.toString());
              }
              if ((f1 > this.r) && (f1 * 0.5F > f2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileCard.QzonePhotoView", 2, "Action move beginDragged ");
                }
                this.s = 1;
              }
              else if (f2 > this.r)
              {
                this.d = false;
              }
            }
            else if (-1 == this.s)
            {
              return false;
            }
            bool2 = this.d;
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break label517;
            }
            paramView = new StringBuilder();
            paramView.append("Action move touchHappened =  ");
            paramView.append(bool2);
            QLog.d("ProfileCard.QzonePhotoView", 2, paramView.toString());
            bool1 = bool2;
            break label517;
          }
          if (1 != this.s) {
            break label514;
          }
          this.s = -1;
          break label514;
        }
      }
      bool2 = this.d;
      bool1 = bool2;
      if (!bool2) {
        break label517;
      }
      this.d = false;
      this.s = 0;
      bool1 = bool2;
      break label517;
    }
    else if (i1 != 0)
    {
      this.d = true;
      this.s = 0;
      this.x = paramMotionEvent.getX();
      this.y = paramMotionEvent.getY();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("Action down mInitialMotionX = ");
        paramView.append(this.x);
        QLog.d("ProfileCard.QzonePhotoView", 2, paramView.toString());
      }
      bool1 = true;
      break label517;
    }
    label514:
    boolean bool1 = false;
    label517:
    if (bool1) {
      try
      {
        boolean bool4 = localViewPager.dispatchTouchEvent(paramMotionEvent);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("photo pager dispatchTouchvent ret = ");
          paramView.append(bool4);
          QLog.d("ProfileCard.QzonePhotoView", 2, paramView.toString());
        }
        i1 = paramMotionEvent.getAction();
        bool2 = bool3;
        if (i1 != 0)
        {
          bool2 = bool3;
          if (bool1)
          {
            bool2 = bool3;
            if (bool4) {
              bool2 = true;
            }
          }
        }
        return bool2;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    return false;
  }
  
  public void setTemplateUtils(ITemplateUtils paramITemplateUtils)
  {
    this.v = paramITemplateUtils;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView
 * JD-Core Version:    0.7.0.1
 */