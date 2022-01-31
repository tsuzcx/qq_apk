package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import ajtk;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import ausu;
import auuw;
import auvd;
import avah;
import avan;
import avao;
import bbbd;
import bbev;
import bfni;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import cooperation.qzone.model.CoverCacheData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VipPhotoViewForSimple
  extends LinearLayout
  implements Handler.Callback
{
  public static float b;
  public float a;
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avan(this);
  View jdField_a_of_type_AndroidViewView;
  public HorizontalScrollView a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private auuw jdField_a_of_type_Auuw;
  public QQAppInterface a;
  public GridView a;
  CoverCacheData jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  private String jdField_a_of_type_JavaLangString;
  public List<avah> a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private View b;
  public int c = -1;
  public int d = -1;
  public int e = -1;
  public int f = -1;
  public int g = -1;
  public int h = -1;
  public int i = -1;
  private int j;
  
  static
  {
    jdField_b_of_type_Float = 1.43F;
  }
  
  public VipPhotoViewForSimple(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = 1.5F;
  }
  
  public VipPhotoViewForSimple(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 1.5F;
  }
  
  private List<avah> a(String paramString, List<Map<Integer, String>> paramList)
  {
    int m = 0;
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|vecUrls = ").append(paramList);
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.b = paramString;
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramList);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    int k;
    if (paramList != null) {
      k = paramList.size();
    }
    while ((m < k) && (m < 16))
    {
      paramString = (Map)paramList.get(m);
      if (paramString != null)
      {
        paramString = new avah(m, 100, paramString);
        paramString.c = localLinkedList.size();
        paramString.jdField_b_of_type_Int = m;
        localLinkedList.add(paramString);
      }
      m += 1;
      continue;
      k = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverData photoInfo size=" + localLinkedList.size());
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
  
  @TargetApi(9)
  public void a(BaseActivity paramBaseActivity, auuw paramauuw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_Auuw = paramauuw;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaLangString = paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2131561625, this, true);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371571));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371572));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371991));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373659);
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = paramBaseActivity.widthPixels;
    this.jdField_b_of_type_Int = paramBaseActivity.heightPixels;
    int k = (int)(this.jdField_a_of_type_Int / this.jdField_a_of_type_Float);
    this.c = k;
    this.f = k;
    this.d = ((int)(this.f / jdField_b_of_type_Float));
    this.h = getResources().getDimensionPixelSize(2131298349);
    this.i = getResources().getDimensionPixelSize(2131298348);
    this.g = (this.d + this.h + this.i);
    this.e = getResources().getDimensionPixelSize(2131298350);
    if (paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (bfni.c()) {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      }
      paramBaseActivity = this.jdField_a_of_type_JavaLangString;
      ThreadManager.post(new VipPhotoViewForSimple.1(this), 8, null, true);
      paramBaseActivity = Message.obtain();
      paramBaseActivity.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBaseActivity);
      return;
    }
  }
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverCacheData data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null) {
      a(a(paramCoverCacheData.b, paramCoverCacheData.jdField_a_of_type_JavaUtilArrayList));
    }
    if ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData != null) && (bbbd.a("PhotoWallCover", this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "need get req cover info");
      }
      paramCoverCacheData = Message.obtain();
      paramCoverCacheData.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCoverCacheData);
    }
  }
  
  public void a(List<avah> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updatePhotoView photoInfo size=" + paramList.size());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramList != null) {}
    for (int k = paramList.size(); k > 0; k = 0)
    {
      this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(0, this.h, 0, this.i);
      this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.c);
      this.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.e);
      avao localavao = new avao(this, this.jdField_a_of_type_AndroidAppActivity);
      localavao.a(paramList);
      k = paramList.size();
      paramList = new LinearLayout.LayoutParams((this.c + this.e) * k, this.g);
      this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(paramList);
      this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(k);
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(localavao);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      auvd.a(this.jdField_a_of_type_AndroidWidgetImageView, "src", this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd, "simpleAddSrc");
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(new ausu(25, null));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
      setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ",uin=" + paramString + ",mUin=" + this.jdField_a_of_type_JavaLangString);
    }
    if (!bbbd.a(paramString, this.jdField_a_of_type_JavaLangString)) {}
    label193:
    do
    {
      return;
      if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
      {
        paramString = new ArrayList();
        int k = 0;
        while (k < parammobile_sub_get_photo_wall_rsp.vecUrls.size())
        {
          paramString.add(((PhotoWall)parammobile_sub_get_photo_wall_rsp.vecUrls.get(k)).photoUrls);
          k += 1;
        }
        List localList = a("", paramString);
        k = 0;
        parammobile_sub_get_photo_wall_rsp = null;
        paramString = null;
        for (;;)
        {
          paramBoolean = bool;
          if (k < 16)
          {
            if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= k)) {
              break label287;
            }
            paramString = (avah)this.jdField_a_of_type_JavaUtilList.get(k);
            if ((localList == null) || (localList.size() <= k)) {
              break label292;
            }
          }
          for (parammobile_sub_get_photo_wall_rsp = (avah)localList.get(k);; parammobile_sub_get_photo_wall_rsp = null)
          {
            if (bbbd.a(paramString, parammobile_sub_get_photo_wall_rsp)) {
              break label297;
            }
            paramBoolean = true;
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
            }
            if ((!paramBoolean) && ((paramString != null) || (parammobile_sub_get_photo_wall_rsp != null))) {
              break;
            }
            a(localList);
            return;
            paramString = null;
            break label193;
          }
          k += 1;
        }
      }
    } while ((!bbev.a(BaseApplication.getContext())) || (this.j >= 3));
    label287:
    label292:
    label297:
    paramString = Message.obtain();
    paramString.what = 100;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
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
        QLog.d("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
      }
      ((ajtk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_JavaLangString, "");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(201);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (ajtk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (paramMessage != null)
      {
        paramMessage.a(this.jdField_a_of_type_JavaLangString, 2);
        this.j += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_UPDATE_PHOTO_VIEW");
      }
      if ((paramMessage.obj instanceof LinkedList)) {
        a((List)paramMessage.obj);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple
 * JD-Core Version:    0.7.0.1
 */