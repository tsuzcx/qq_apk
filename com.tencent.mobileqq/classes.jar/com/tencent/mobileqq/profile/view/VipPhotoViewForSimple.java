package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
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
import android.widget.ListAdapter;
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
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
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
  public static float b = 1.43F;
  public float a;
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new VipPhotoViewForSimple.2(this);
  View jdField_a_of_type_AndroidViewView;
  public HorizontalScrollView a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo;
  private ITemplateUtils jdField_a_of_type_ComTencentMobileqqProfilecardTemplateITemplateUtils;
  public GridView a;
  CoverCacheData jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  private String jdField_a_of_type_JavaLangString;
  public List<QzonePhotoView.PhotoInfo> a;
  private boolean jdField_a_of_type_Boolean = false;
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
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    Object localObject = this.jdField_a_of_type_CooperationQzoneModelCoverCacheData;
    ((CoverCacheData)localObject).type = paramString;
    ((CoverCacheData)localObject).photoWall = ((ArrayList)paramList);
    ((CoverCacheData)localObject).uin = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    int m = 0;
    int k;
    if (paramList != null) {
      k = paramList.size();
    } else {
      k = 0;
    }
    while ((m < k) && (m < 16))
    {
      paramString = (Map)paramList.get(m);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.PhotoInfo(m, 100, paramString);
        paramString.c = localLinkedList.size();
        paramString.jdField_b_of_type_Int = m;
        localLinkedList.add(paramString);
      }
      m += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("updateCoverData photoInfo size=");
      paramString.append(localLinkedList.size());
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, paramString.toString());
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
  
  @TargetApi(9)
  public void a(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramQBaseActivity.getAppRuntime());
    this.jdField_a_of_type_AndroidAppActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaLangString = paramProfileCardInfo.allInOne.uin;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2131562027, this, true);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372660));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372661));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373120));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374932);
    paramQBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = paramQBaseActivity.widthPixels;
    this.jdField_b_of_type_Int = paramQBaseActivity.heightPixels;
    int k = (int)(this.jdField_a_of_type_Int / this.jdField_a_of_type_Float);
    this.c = k;
    this.f = k;
    this.d = ((int)(this.f / jdField_b_of_type_Float));
    this.h = getResources().getDimensionPixelSize(2131298622);
    this.i = getResources().getDimensionPixelSize(2131298621);
    this.g = (this.d + this.h + this.i);
    this.e = getResources().getDimensionPixelSize(2131298623);
    boolean bool;
    if (paramProfileCardInfo.allInOne.pa == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (VersionUtils.c()) {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
    }
    paramQBaseActivity = this.jdField_a_of_type_JavaLangString;
    ThreadManager.post(new VipPhotoViewForSimple.1(this), 8, null, true);
    paramQBaseActivity = Message.obtain();
    paramQBaseActivity.what = 100;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramQBaseActivity);
  }
  
  public void a(List<QzonePhotoView.PhotoInfo> paramList)
  {
    Object localObject;
    if ((QLog.isColorLevel()) && (paramList != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePhotoView photoInfo size=");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    int k;
    if (paramList != null) {
      k = paramList.size();
    } else {
      k = 0;
    }
    if (k > 0)
    {
      this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(0, this.h, 0, this.i);
      this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.c);
      this.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.e);
      localObject = new VipPhotoViewForSimple.PhotoAdapter(this, this.jdField_a_of_type_AndroidAppActivity);
      ((VipPhotoViewForSimple.PhotoAdapter)localObject).a(paramList);
      k = paramList.size();
      paramList = new LinearLayout.LayoutParams((this.c + this.e) * k, this.g);
      this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(paramList);
      this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(k);
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateITemplateUtils.updateViewAttr(this.jdField_a_of_type_AndroidWidgetImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.currentTemplate, "simpleAddSrc");
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(new DataTag(25, null));
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
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, ((StringBuilder)localObject).toString());
    }
    if (!Utils.a(paramString, this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
    {
      paramString = new ArrayList();
      boolean bool = false;
      int k = 0;
      while (k < parammobile_sub_get_photo_wall_rsp.vecUrls.size())
      {
        paramString.add(((PhotoWall)parammobile_sub_get_photo_wall_rsp.vecUrls.get(k)).photoUrls);
        k += 1;
      }
      localObject = a("", paramString);
      paramString = null;
      parammobile_sub_get_photo_wall_rsp = paramString;
      k = 0;
      for (;;)
      {
        paramBoolean = bool;
        if (k >= 16) {
          break;
        }
        paramString = this.jdField_a_of_type_JavaUtilList;
        if ((paramString != null) && (paramString.size() > k)) {
          paramString = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(k);
        } else {
          paramString = null;
        }
        if ((localObject != null) && (((List)localObject).size() > k)) {
          parammobile_sub_get_photo_wall_rsp = (QzonePhotoView.PhotoInfo)((List)localObject).get(k);
        } else {
          parammobile_sub_get_photo_wall_rsp = null;
        }
        if (!Utils.a(paramString, parammobile_sub_get_photo_wall_rsp))
        {
          paramBoolean = true;
          break;
        }
        k += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetQZoneCover  isNewPhoto=");
        localStringBuilder.append(String.valueOf(paramBoolean));
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, localStringBuilder.toString());
      }
      if ((paramBoolean) || ((paramString == null) && (parammobile_sub_get_photo_wall_rsp == null))) {
        a((List)localObject);
      }
    }
    else if ((NetworkUtil.isWifiEnabled(BaseApplication.getContext())) && (this.j < 3))
    {
      paramString = Message.obtain();
      paramString.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 100)
    {
      if (k != 200)
      {
        if (k == 201)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
          }
          ((PhotoWallHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(this.jdField_a_of_type_JavaLangString, "");
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(201);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_UPDATE_PHOTO_VIEW");
        }
        if ((paramMessage.obj instanceof LinkedList)) {
          a((List)paramMessage.obj);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(201);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (paramMessage != null)
      {
        paramMessage.a(this.jdField_a_of_type_JavaLangString, 2);
        this.j += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    }
    return false;
  }
  
  public void setTemplateUtils(ITemplateUtils paramITemplateUtils)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateITemplateUtils = paramITemplateUtils;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple
 * JD-Core Version:    0.7.0.1
 */