package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import alkv;
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
import android.support.v4.view.ViewPager;
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
import awki;
import awmk;
import awrs;
import awrt;
import awru;
import awrw;
import bcyw;
import bdal;
import bdee;
import bhyk;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterViewPagerAdapter;
import com.tencent.widget.CirclePageIndicator;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QzonePhotoView
  extends LinearLayout
  implements Handler.Callback, bhyk
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new awrt(this);
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private awmk jdField_a_of_type_Awmk;
  public QQAppInterface a;
  CoverCacheData jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  private String jdField_a_of_type_JavaLangString;
  private List<awrw> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
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
  
  private List<awrw> a(String paramString, List<Map<Integer, String>> paramList)
  {
    int j = 0;
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|vecUrls = ").append(paramList);
      QLog.i("ProfileCard.QzonePhotoView", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.b = paramString;
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramList);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    int i;
    if (paramList != null) {
      i = paramList.size();
    }
    while ((j < i) && (j < 16))
    {
      paramString = (Map)paramList.get(j);
      if (paramString != null)
      {
        paramString = new awrw(j, 100, paramString);
        paramString.jdField_c_of_type_Int = localLinkedList.size();
        localLinkedList.add(paramString);
      }
      j += 1;
      continue;
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverData photoInfo size=" + localLinkedList.size());
    }
    return localLinkedList;
  }
  
  private void a(boolean paramBoolean)
  {
    String str = "http://ti.qq.com/photowall/index.html?_wv=1027";
    if (!paramBoolean) {
      str = "http://ti.qq.com/photowall/index.html?_wv=1027" + "&uin=" + this.jdField_a_of_type_JavaLangString;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", str);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 1022);
  }
  
  public CoverCacheData a()
  {
    return this.jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(BaseActivity paramBaseActivity, awmk paramawmk)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_Awmk = paramawmk;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.d = 0;
    this.jdField_a_of_type_JavaLangString = paramawmk.a.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2131561816, this, true);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = localDisplayMetrics.density;
    this.jdField_a_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i = getResources().getDimensionPixelSize(2131298372);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131298371);
    this.jdField_b_of_type_Int = ((this.jdField_a_of_type_Int - i * 2 - this.jdField_c_of_type_Int * 3) / 4);
    if (paramawmk.a.jdField_a_of_type_Int == 0) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    ThreadManager.post(new QzonePhotoView.1(this), 8, null, true);
    paramawmk = Message.obtain();
    paramawmk.what = 100;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramawmk);
    this.e = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramBaseActivity));
  }
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverCacheData data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null) {
      a(a(paramCoverCacheData.b, paramCoverCacheData.jdField_a_of_type_JavaUtilArrayList));
    }
    if ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData != null) && (bdal.a("PhotoWallCover", this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "need get req cover info");
      }
      paramCoverCacheData = Message.obtain();
      paramCoverCacheData.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCoverCacheData);
    }
  }
  
  public void a(List<awrw> paramList)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      try
      {
        if ((QLog.isColorLevel()) && (paramList != null)) {
          QLog.i("ProfileCard.QzonePhotoView", 2, "updatePhotoView photoInfo size=" + paramList.size());
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        if (paramList == null) {
          break label558;
        }
        i = paramList.size();
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372308));
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374114);
        this.jdField_b_of_type_AndroidViewView.setTag(new awki(25, null));
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject2 = bcyw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1L);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = bcyw.a(getContext(), 188);
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ((int)Math.ceil(((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight * 1.0D / 376.0D * 640.0D));
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(getResources().getColor(2131165394));
          localObject2 = URLDrawable.getDrawable(new File((String)localObject2, "qvip_profile_photo_black_addimage_tips.png"), (URLDrawable.URLDrawableOptions)localObject1);
          ((Drawable)localObject2).setBounds(0, 0, ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(new awki(25, null));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = (ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131371808);
        localObject2 = (CirclePageIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131371537);
        if (i > 0)
        {
          awru localawru = new awru(this);
          localawru.a(paramList);
          localawru.a(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          paramList = new AdapterViewPagerAdapter(getContext(), localawru, 8);
          paramList.a(new awrs(this));
          ViewGroup.LayoutParams localLayoutParams = ((ViewPager)localObject1).getLayoutParams();
          localLayoutParams.width = this.jdField_a_of_type_Int;
          if (localawru.getCount() > 4)
          {
            i = this.jdField_b_of_type_Int * 2 + this.jdField_c_of_type_Int;
            localLayoutParams.height = i;
            ((ViewPager)localObject1).setLayoutParams(localLayoutParams);
            ((ViewPager)localObject1).setAdapter(paramList);
            i = paramList.getCount();
            ((CirclePageIndicator)localObject2).setViewPager((ViewPager)localObject1);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            ((ViewPager)localObject1).setVisibility(0);
            if (i > 1)
            {
              ((CirclePageIndicator)localObject2).setVisibility(0);
              setVisibility(0);
            }
          }
          else
          {
            i = this.jdField_b_of_type_Int + this.jdField_c_of_type_Int;
            continue;
          }
          ((CirclePageIndicator)localObject2).setVisibility(8);
          continue;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label533;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      ((ViewPager)localObject1).setVisibility(8);
      ((CirclePageIndicator)localObject2).setVisibility(8);
      setVisibility(0);
      return;
      label533:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      setVisibility(8);
      return;
      label558:
      int i = 0;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ",uin=" + paramString + ",mUin=" + this.jdField_a_of_type_JavaLangString);
    }
    if (!bdal.a(paramString, this.jdField_a_of_type_JavaLangString)) {}
    label193:
    do
    {
      return;
      if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
      {
        paramString = new ArrayList();
        int i = 0;
        while (i < parammobile_sub_get_photo_wall_rsp.vecUrls.size())
        {
          paramString.add(((PhotoWall)parammobile_sub_get_photo_wall_rsp.vecUrls.get(i)).photoUrls);
          i += 1;
        }
        List localList = a("", paramString);
        i = 0;
        parammobile_sub_get_photo_wall_rsp = null;
        paramString = null;
        for (;;)
        {
          paramBoolean = bool;
          if (i < 16)
          {
            if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= i)) {
              break label287;
            }
            paramString = (awrw)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localList == null) || (localList.size() <= i)) {
              break label292;
            }
          }
          for (parammobile_sub_get_photo_wall_rsp = (awrw)localList.get(i);; parammobile_sub_get_photo_wall_rsp = null)
          {
            if (bdal.a(paramString, parammobile_sub_get_photo_wall_rsp)) {
              break label297;
            }
            paramBoolean = true;
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
            }
            if ((!paramBoolean) && ((paramString != null) || (parammobile_sub_get_photo_wall_rsp != null))) {
              break;
            }
            a(localList);
            return;
            paramString = null;
            break label193;
          }
          i += 1;
        }
      }
    } while ((!bdee.a(BaseApplication.getContext())) || (this.d >= 3));
    label287:
    label292:
    label297:
    paramString = Message.obtain();
    paramString.what = 100;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    ViewPager localViewPager = (ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131371808);
    paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    localViewPager.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    float f1 = paramMotionEvent.getRawY();
    int i;
    label136:
    boolean bool1;
    if ((localViewPager.getVisibility() == 0) && (f1 >= this.jdField_b_of_type_ArrayOfInt[1]) && (f1 < this.jdField_b_of_type_ArrayOfInt[1] + localViewPager.getHeight()))
    {
      i = 1;
      paramMotionEvent.offsetLocation(0.0F, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1]);
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool1 = false;
      }
    }
    label139:
    label585:
    for (;;)
    {
      for (;;)
      {
        if (bool1) {}
        try
        {
          bool2 = localViewPager.dispatchTouchEvent(paramMotionEvent);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.QzonePhotoView", 2, "photo pager dispatchTouchvent ret = " + bool2);
          }
          i = paramMotionEvent.getAction();
          if ((i != 0) && (bool1) && (bool2)) {}
          for (bool1 = bool3;; bool1 = false)
          {
            bool2 = bool1;
            return bool2;
            i = 0;
            break;
            if (i == 0) {
              break label136;
            }
            this.jdField_a_of_type_Boolean = true;
            this.f = 0;
            this.jdField_b_of_type_Float = paramMotionEvent.getX();
            this.jdField_c_of_type_Float = paramMotionEvent.getY();
            if (!QLog.isColorLevel()) {
              break label585;
            }
            QLog.d("ProfileCard.QzonePhotoView", 2, "Action down mInitialMotionX = " + this.jdField_b_of_type_Float);
            bool1 = true;
            break label139;
            if (i != 0)
            {
              if ((this.jdField_a_of_type_Boolean) && (this.f == 0))
              {
                f1 = Math.abs(paramMotionEvent.getX() - this.jdField_b_of_type_Float);
                f2 = Math.abs(paramMotionEvent.getY() - this.jdField_c_of_type_Float);
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileCard.QzonePhotoView", 2, "Action move curX = " + paramMotionEvent.getX() + " xDiff = " + f1 + " mTouchSlop = " + this.e);
                }
                if ((f1 > this.e) && (f1 * 0.5F > f2))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.QzonePhotoView", 2, "Action move beginDragged ");
                  }
                  this.f = 1;
                }
              }
              while (-1 != this.f) {
                for (;;)
                {
                  float f2;
                  bool4 = this.jdField_a_of_type_Boolean;
                  bool1 = bool4;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ProfileCard.QzonePhotoView", 2, "Action move touchHappened =  " + bool4);
                  bool1 = bool4;
                  break;
                  if (f2 > this.e) {
                    this.jdField_a_of_type_Boolean = false;
                  }
                }
              }
              return false;
            }
            if (1 != this.f) {
              break label136;
            }
            this.f = -1;
            bool1 = false;
            break label139;
            boolean bool4 = this.jdField_a_of_type_Boolean;
            bool1 = bool4;
            if (!this.jdField_a_of_type_Boolean) {
              break label139;
            }
            this.jdField_a_of_type_Boolean = false;
            this.f = 0;
            bool1 = bool4;
            break label139;
          }
          bool1 = true;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return false;
        }
      }
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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (alkv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (paramMessage != null)
      {
        paramMessage.a(this.jdField_a_of_type_JavaLangString, 2);
        this.d += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      continue;
      if ((paramMessage.obj instanceof LinkedList)) {
        a((List)paramMessage.obj);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(201);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.QzonePhotoView", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
      }
      ((alkv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_JavaLangString, "");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView
 * JD-Core Version:    0.7.0.1
 */