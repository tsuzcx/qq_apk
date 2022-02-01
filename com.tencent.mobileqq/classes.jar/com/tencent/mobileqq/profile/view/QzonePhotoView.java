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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QzonePhotoView.3(this);
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo;
  private ITemplateUtils jdField_a_of_type_ComTencentMobileqqProfilecardTemplateITemplateUtils;
  CoverCacheData jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  private String jdField_a_of_type_JavaLangString;
  private List<QzonePhotoView.PhotoInfo> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  private int f;
  
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
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    Object localObject = this.jdField_a_of_type_CooperationQzoneModelCoverCacheData;
    ((CoverCacheData)localObject).type = paramString;
    ((CoverCacheData)localObject).photoWall = ((ArrayList)paramList);
    ((CoverCacheData)localObject).uin = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    int j = 0;
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    while ((j < i) && (j < 16))
    {
      paramString = (Map)paramList.get(j);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.PhotoInfo(j, 100, paramString);
        paramString.jdField_c_of_type_Int = localLinkedList.size();
        localLinkedList.add(paramString);
      }
      j += 1;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", (String)localObject);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 100);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramQBaseActivity.getAppRuntime());
    this.jdField_a_of_type_AndroidAppActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    boolean bool = false;
    this.d = 0;
    this.jdField_a_of_type_JavaLangString = paramProfileCardInfo.allInOne.uin;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2131562028, this, true);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = localDisplayMetrics.density;
    this.jdField_a_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i = getResources().getDimensionPixelSize(2131298619);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131298618);
    this.jdField_b_of_type_Int = ((this.jdField_a_of_type_Int - i * 2 - this.jdField_c_of_type_Int * 3) / 4);
    if (paramProfileCardInfo.allInOne.pa == 0) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    ThreadManager.post(new QzonePhotoView.1(this), 8, null, true);
    paramProfileCardInfo = Message.obtain();
    paramProfileCardInfo.what = 100;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramProfileCardInfo);
    this.e = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramQBaseActivity));
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
        this.jdField_a_of_type_JavaUtilList = paramList;
        if (paramList != null)
        {
          i = paramList.size();
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373120));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374932);
          this.jdField_b_of_type_AndroidViewView.setTag(new DataTag(25, null));
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          Object localObject2 = ProfileCardTemplateUtil.a(-1L);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ProfileCardUtil.a(getContext(), 188);
            int j = ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight;
            double d1 = j;
            Double.isNaN(d1);
            d1 = d1 * 1.0D / 376.0D;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ((int)Math.ceil(d1 * 640.0D));
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(getResources().getColor(2131165418));
            localObject2 = URLDrawable.getDrawable(new File((String)localObject2, "qvip_profile_photo_black_addimage_tips.png"), (URLDrawable.URLDrawableOptions)localObject1);
            ((Drawable)localObject2).setBounds(0, 0, ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setTag(new DataTag(25, null));
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject1 = (ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131372581);
          localObject2 = (CirclePageIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131372285);
          if (i > 0)
          {
            QzonePhotoView.PhotoGridAdapter localPhotoGridAdapter = new QzonePhotoView.PhotoGridAdapter(this);
            localPhotoGridAdapter.a(paramList);
            localPhotoGridAdapter.a(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
            paramList = new AdapterViewPagerAdapter(getContext(), localPhotoGridAdapter, 8);
            paramList.a(new QzonePhotoView.2(this));
            ViewGroup.LayoutParams localLayoutParams = ((ViewPager)localObject1).getLayoutParams();
            localLayoutParams.width = this.jdField_a_of_type_Int;
            if (localPhotoGridAdapter.getCount() > 4)
            {
              i = this.jdField_b_of_type_Int * 2 + this.jdField_c_of_type_Int;
            }
            else
            {
              i = this.jdField_b_of_type_Int;
              i = this.jdField_c_of_type_Int + i;
            }
            localLayoutParams.height = i;
            ((ViewPager)localObject1).setLayoutParams(localLayoutParams);
            ((ViewPager)localObject1).setAdapter(paramList);
            i = paramList.getCount();
            ((CirclePageIndicator)localObject2).setViewPager((ViewPager)localObject1);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            ((ViewPager)localObject1).setVisibility(0);
            if (i > 1) {
              ((CirclePageIndicator)localObject2).setVisibility(0);
            } else {
              ((CirclePageIndicator)localObject2).setVisibility(8);
            }
            setVisibility(0);
            return;
          }
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            ((ViewPager)localObject1).setVisibility(8);
            ((CirclePageIndicator)localObject2).setVisibility(8);
            setVisibility(0);
            return;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          setVisibility(8);
          return;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      int i = 0;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("ProfileCard.QzonePhotoView", 2, ((StringBuilder)localObject).toString());
    }
    if (!Utils.a(paramString, this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
    {
      paramString = new ArrayList();
      boolean bool = false;
      int i = 0;
      while (i < parammobile_sub_get_photo_wall_rsp.vecUrls.size())
      {
        paramString.add(((PhotoWall)parammobile_sub_get_photo_wall_rsp.vecUrls.get(i)).photoUrls);
        i += 1;
      }
      localObject = a("", paramString);
      paramString = null;
      parammobile_sub_get_photo_wall_rsp = paramString;
      i = 0;
      for (;;)
      {
        paramBoolean = bool;
        if (i >= 16) {
          break;
        }
        paramString = this.jdField_a_of_type_JavaUtilList;
        if ((paramString != null) && (paramString.size() > i)) {
          paramString = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        } else {
          paramString = null;
        }
        if ((localObject != null) && (((List)localObject).size() > i)) {
          parammobile_sub_get_photo_wall_rsp = (QzonePhotoView.PhotoInfo)((List)localObject).get(i);
        } else {
          parammobile_sub_get_photo_wall_rsp = null;
        }
        if (!Utils.a(paramString, parammobile_sub_get_photo_wall_rsp))
        {
          paramBoolean = true;
          break;
        }
        i += 1;
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
    else if ((NetworkUtil.isWifiEnabled(BaseApplication.getContext())) && (this.d < 3))
    {
      paramString = Message.obtain();
      paramString.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 100)
    {
      if (i != 200)
      {
        if (i == 201)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.QzonePhotoView", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
          }
          ((PhotoWallHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(this.jdField_a_of_type_JavaLangString, "");
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(201);
        }
      }
      else
      {
        if ((paramMessage.obj instanceof LinkedList)) {
          a((List)paramMessage.obj);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(201);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (paramMessage != null)
      {
        paramMessage.a(this.jdField_a_of_type_JavaLangString, 2);
        this.d += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    }
    return false;
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    ViewPager localViewPager = (ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131372581);
    paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    localViewPager.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    float f1 = paramMotionEvent.getRawY();
    int i = localViewPager.getVisibility();
    boolean bool3 = false;
    if (i == 0)
    {
      paramView = this.jdField_b_of_type_ArrayOfInt;
      if ((f1 >= paramView[1]) && (f1 < paramView[1] + localViewPager.getHeight()))
      {
        i = 1;
        break label90;
      }
    }
    i = 0;
    label90:
    paramMotionEvent.offsetLocation(0.0F, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1]);
    int j = paramMotionEvent.getAction();
    boolean bool2;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            break label514;
          }
        }
        else
        {
          if (i != 0)
          {
            if ((this.jdField_a_of_type_Boolean) && (this.f == 0))
            {
              f1 = Math.abs(paramMotionEvent.getX() - this.jdField_b_of_type_Float);
              float f2 = Math.abs(paramMotionEvent.getY() - this.jdField_c_of_type_Float);
              if (QLog.isColorLevel())
              {
                paramView = new StringBuilder();
                paramView.append("Action move curX = ");
                paramView.append(paramMotionEvent.getX());
                paramView.append(" xDiff = ");
                paramView.append(f1);
                paramView.append(" mTouchSlop = ");
                paramView.append(this.e);
                QLog.d("ProfileCard.QzonePhotoView", 2, paramView.toString());
              }
              if ((f1 > this.e) && (f1 * 0.5F > f2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileCard.QzonePhotoView", 2, "Action move beginDragged ");
                }
                this.f = 1;
              }
              else if (f2 > this.e)
              {
                this.jdField_a_of_type_Boolean = false;
              }
            }
            else if (-1 == this.f)
            {
              return false;
            }
            bool2 = this.jdField_a_of_type_Boolean;
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
          if (1 != this.f) {
            break label514;
          }
          this.f = -1;
          break label514;
        }
      }
      bool2 = this.jdField_a_of_type_Boolean;
      bool1 = bool2;
      if (!bool2) {
        break label517;
      }
      this.jdField_a_of_type_Boolean = false;
      this.f = 0;
      bool1 = bool2;
      break label517;
    }
    else if (i != 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.f = 0;
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      this.jdField_c_of_type_Float = paramMotionEvent.getY();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("Action down mInitialMotionX = ");
        paramView.append(this.jdField_b_of_type_Float);
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
        i = paramMotionEvent.getAction();
        bool2 = bool3;
        if (i != 0)
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
    this.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateITemplateUtils = paramITemplateUtils;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView
 * JD-Core Version:    0.7.0.1
 */