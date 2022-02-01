package com.tencent.mobileqq.businessCard.activity;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class BusinessCardEditActivity
  extends BaseActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  int jdField_a_of_type_Int;
  Dialog jdField_a_of_type_AndroidAppDialog;
  Intent jdField_a_of_type_AndroidContentIntent;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new BusinessCardEditActivity.17(this);
  BusinessCardManager jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new BusinessCardEditActivity.18(this);
  BusinessCardEditActivity.MaxBytesTextWatcher jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity$MaxBytesTextWatcher;
  BusinessCard jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
  CardOCRInfo jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
  ClearEllipsisEditText jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  private List<WeakReference<FaceDrawable>> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ClearEllipsisEditText jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 1;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 1;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 1;
  private boolean jdField_g_of_type_Boolean = false;
  
  private void a(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Object localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("bind_phone_num");
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_b_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        localObject2 = paramBusinessCard.mobilesNum.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_b_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramBusinessCard.mobilesNum.isEmpty())) {
        a(this.jdField_b_of_type_AndroidWidgetLinearLayout, null, 1);
      }
      if (!a())
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
        Object localObject4 = new ArrayList();
        localObject3 = new ArrayList();
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        if (a((ArrayList)localObject4, (ArrayList)localObject3, (ArrayList)localObject2, (ArrayList)localObject1))
        {
          localObject4 = ((ArrayList)localObject4).iterator();
          Object localObject6;
          Object localObject5;
          Object localObject7;
          Object localObject8;
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = (String)((Iterator)localObject4).next();
            localObject5 = LayoutInflater.from(this).inflate(2131560997, null);
            localObject7 = (ImageView)((View)localObject5).findViewById(2131368343);
            localObject8 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject6);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject8));
            ((ImageView)localObject7).setBackgroundDrawable((Drawable)localObject8);
            ((TextView)((View)localObject5).findViewById(2131371862)).setText(ContactUtils.f(this.app, (String)localObject6));
            ((TextView)((View)localObject5).findViewById(2131380150)).setText((CharSequence)localObject6);
            ((ImageView)((View)localObject5).findViewById(2131362983)).setVisibility(0);
            localObject7 = new BusinessCardEditActivity.ItemHolder(this);
            ((BusinessCardEditActivity.ItemHolder)localObject7).jdField_a_of_type_JavaLangString = ((String)localObject6);
            ((BusinessCardEditActivity.ItemHolder)localObject7).jdField_b_of_type_JavaLangString = ContactUtils.f(this.app, (String)localObject6);
            ((BusinessCardEditActivity.ItemHolder)localObject7).jdField_a_of_type_Boolean = false;
            ((View)localObject5).setTag(localObject7);
            ((View)localObject5).setOnClickListener(new BusinessCardEditActivity.6(this));
            localObject6 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
          }
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (String)((Iterator)localObject3).next();
            localObject4 = LayoutInflater.from(this).inflate(2131560997, null);
            localObject6 = (ImageView)((View)localObject4).findViewById(2131368343);
            localObject7 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject5);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject7));
            ((ImageView)localObject6).setBackgroundDrawable((Drawable)localObject7);
            localObject6 = (TextView)((View)localObject4).findViewById(2131371862);
            ((TextView)((View)localObject4).findViewById(2131380150)).setText((CharSequence)localObject5);
            localObject7 = (Button)((View)localObject4).findViewById(2131362215);
            ((Button)localObject7).setVisibility(0);
            localObject8 = new BusinessCardEditActivity.ItemHolder(this);
            ((BusinessCardEditActivity.ItemHolder)localObject8).jdField_a_of_type_JavaLangString = ((String)localObject5);
            ((BusinessCardEditActivity.ItemHolder)localObject8).jdField_b_of_type_JavaLangString = ContactUtils.b(this.app, (String)localObject5, true);
            ((BusinessCardEditActivity.ItemHolder)localObject8).jdField_a_of_type_Boolean = false;
            ((View)localObject4).setTag(localObject8);
            ((TextView)localObject6).setText(((BusinessCardEditActivity.ItemHolder)localObject8).jdField_b_of_type_JavaLangString);
            ((Button)localObject7).setTag(localObject8);
            ((Button)localObject7).setOnClickListener(new BusinessCardEditActivity.7(this));
            localObject5 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject7 = (String)((Iterator)localObject2).next();
            localObject3 = LayoutInflater.from(this).inflate(2131560997, null);
            localObject4 = (ImageView)((View)localObject3).findViewById(2131368343);
            localObject5 = (TextView)((View)localObject3).findViewById(2131371862);
            localObject8 = (TextView)((View)localObject3).findViewById(2131380150);
            localObject6 = (Button)((View)localObject3).findViewById(2131362215);
            ((Button)localObject6).setVisibility(0);
            ((TextView)localObject8).setText((CharSequence)localObject7);
            localObject8 = paramBusinessCard.getMobileInfoByMobile((String)localObject7);
            BusinessCardEditActivity.ItemHolder localItemHolder = new BusinessCardEditActivity.ItemHolder(this);
            localItemHolder.jdField_a_of_type_Boolean = true;
            if (localObject8 != null)
            {
              localObject7 = FaceDrawable.getFaceDrawable(this.app, 11, ((CardMobileInfo)localObject8).d);
              this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject7));
              ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject7);
              localItemHolder.jdField_a_of_type_JavaLangString = ((CardMobileInfo)localObject8).d;
              localItemHolder.jdField_b_of_type_JavaLangString = ((CardMobileInfo)localObject8).jdField_c_of_type_JavaLangString;
            }
            else
            {
              localItemHolder.jdField_a_of_type_JavaLangString = ((String)localObject7);
              localItemHolder.jdField_b_of_type_JavaLangString = ((String)localObject7);
            }
            ((View)localObject3).setTag(localItemHolder);
            ((TextView)localObject5).setText(localItemHolder.jdField_b_of_type_JavaLangString);
            ((Button)localObject6).setTag(localItemHolder);
            ((Button)localObject6).setOnClickListener(new BusinessCardEditActivity.8(this));
            localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            a(this.jdField_c_of_type_AndroidWidgetLinearLayout, (String)localObject2, 0);
          }
        }
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 0);
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localObject1 = (LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365541);
      Object localObject2 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365523);
      if (!paramBusinessCard.descs.isEmpty())
      {
        ((LinearLayout)localObject1).setVisibility(0);
        ((View)localObject2).setVisibility(0);
        localObject1 = new StringBuilder();
        paramBusinessCard = paramBusinessCard.descs.iterator();
        while (paramBusinessCard.hasNext())
        {
          localObject2 = (String)paramBusinessCard.next();
          if (((StringBuilder)localObject1).length() > 0) {
            ((StringBuilder)localObject1).append("\n");
          }
          ((StringBuilder)localObject1).append((String)localObject2);
        }
        if (!TextUtils.isEmpty(((StringBuilder)localObject1).toString())) {
          a(this.jdField_d_of_type_AndroidWidgetLinearLayout, ((StringBuilder)localObject1).toString(), 2);
        }
      }
      else
      {
        ((LinearLayout)localObject1).setVisibility(8);
        ((LinearLayout)localObject1).setVisibility(8);
      }
    }
  }
  
  private void a(BusinessCard paramBusinessCard, CardOCRInfo paramCardOCRInfo)
  {
    int k = 0;
    int j = 0;
    int i;
    if (paramBusinessCard != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        i = 0;
        while (i < paramBusinessCard.mobilesNum.size())
        {
          paramCardOCRInfo = (String)paramBusinessCard.mobilesNum.get(i);
          a(this.jdField_b_of_type_AndroidWidgetLinearLayout, paramCardOCRInfo, 1, 15);
          i += 1;
        }
        this.jdField_e_of_type_Int = paramBusinessCard.mobilesNum.size();
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getExtras() != null) {
        paramCardOCRInfo = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("add_phone_num", null);
      } else {
        paramCardOCRInfo = null;
      }
      if (paramCardOCRInfo != null)
      {
        i = this.jdField_e_of_type_Int;
        if (i < 3)
        {
          this.jdField_e_of_type_Int = (i + 1);
          a(this.jdField_b_of_type_AndroidWidgetLinearLayout, paramCardOCRInfo, 1, 15, true);
        }
      }
      if (this.jdField_e_of_type_Int >= 3) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_e_of_type_Int == 0)
      {
        a(this.jdField_b_of_type_AndroidWidgetLinearLayout, null, 1, 15);
        this.jdField_e_of_type_Int = 1;
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (!paramBusinessCard.uinInfos.isEmpty())
      {
        i = j;
        while (i < paramBusinessCard.uinInfos.size())
        {
          paramCardOCRInfo = ((CardUinInfo)paramBusinessCard.uinInfos.get(i)).jdField_a_of_type_JavaLangString;
          if (!TextUtils.isEmpty(paramCardOCRInfo)) {
            a(paramCardOCRInfo, i);
          }
          i += 1;
        }
        this.jdField_f_of_type_Int = paramBusinessCard.uinInfos.size();
        if (this.jdField_f_of_type_Int >= 2) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      else
      {
        a(null, 0);
        this.jdField_f_of_type_Int = 1;
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (!paramBusinessCard.descs.isEmpty())
      {
        paramCardOCRInfo = new StringBuilder();
        Iterator localIterator = paramBusinessCard.descs.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramCardOCRInfo.length() > 0) {
            paramCardOCRInfo.append("\n");
          }
          paramCardOCRInfo.append(str);
        }
        a(this.jdField_d_of_type_AndroidWidgetLinearLayout, paramCardOCRInfo.toString(), 2, 150);
        this.jdField_g_of_type_Int = paramBusinessCard.descs.size();
        if (this.jdField_g_of_type_Int >= 2) {
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      else
      {
        a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 2, 150);
        this.jdField_g_of_type_Int = 1;
      }
    }
    else if (paramCardOCRInfo != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        i = 0;
        while (i < paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size())
        {
          paramBusinessCard = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(i);
          a(this.jdField_b_of_type_AndroidWidgetLinearLayout, paramBusinessCard, 1, 15);
          i += 1;
        }
        this.jdField_e_of_type_Int = paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size();
      }
      else
      {
        a(this.jdField_b_of_type_AndroidWidgetLinearLayout, null, 1, 15);
        this.jdField_e_of_type_Int = 1;
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (!paramCardOCRInfo.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        i = k;
        while (i < paramCardOCRInfo.jdField_a_of_type_JavaUtilList.size())
        {
          a((String)paramCardOCRInfo.jdField_a_of_type_JavaUtilList.get(i), i);
          i += 1;
        }
        this.jdField_f_of_type_Int = paramCardOCRInfo.jdField_a_of_type_JavaUtilList.size();
      }
      else
      {
        a(null, 0);
        this.jdField_f_of_type_Int = 1;
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
      a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 2, 150);
      this.jdField_g_of_type_Int = 1;
    }
  }
  
  private void a(BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
    if (localObject != null)
    {
      paramBusinessCard.cardId = ((BusinessCard)localObject).cardId;
      paramBusinessCard.bindUin = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin;
      if (this.jdField_a_of_type_Int == 2) {
        paramBusinessCard.cardName = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName;
      }
    }
    if (this.jdField_a_of_type_Int != 2) {
      paramBusinessCard.cardName = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
    if (localObject != null)
    {
      paramBusinessCard.picUrl = ((CardOCRInfo)localObject).jdField_b_of_type_JavaLangString;
      paramBusinessCard.OCRInfo = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
      if (localObject != null)
      {
        paramBusinessCard.picUrl = ((BusinessCard)localObject).picUrl;
        paramBusinessCard.OCRInfo = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo;
      }
    }
    if (this.jdField_e_of_type_Boolean)
    {
      paramBusinessCard.picUrl = null;
      paramBusinessCard.OCRInfo = null;
    }
    paramBusinessCard.company = this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
    paramBusinessCard.mobilesNum.clear();
    int j = 0;
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = ((EditText)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getText().toString().trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBusinessCard.mobilesNum.add(localObject);
      }
      i += 1;
    }
    paramBusinessCard.qqNum.clear();
    i = 0;
    while (i < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject instanceof RelativeLayout))
      {
        localObject = (EditText)((View)localObject).findViewById(2131374258);
        if (localObject != null)
        {
          localObject = ((EditText)localObject).getText().toString().trim();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramBusinessCard.qqNum.add(localObject);
          }
        }
      }
      i += 1;
    }
    paramBusinessCard.descs.clear();
    i = 0;
    while (i < this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = ((EditText)this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getText().toString().trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBusinessCard.descs.add(localObject);
      }
      i += 1;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Int == 0)
      {
        if (TextUtils.isEmpty(paramBusinessCard.cardName)) {
          localObject = "1";
        } else {
          localObject = "0";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80064E7", "0X80064E7", 0, 0, (String)localObject, "", "", "");
        if (TextUtils.isEmpty(paramBusinessCard.company)) {
          localObject = "1";
        } else {
          localObject = "0";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80064E8", "0X80064E8", 0, 0, (String)localObject, "", "", "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBusinessCard.qqNum.size());
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        ReportController.b(this.app, "CliOper", "", "", "0X80064E9", "0X80064E9", 0, 0, (String)localObject, "", "", "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBusinessCard.descs.size());
        ((StringBuilder)localObject).append("");
        paramBusinessCard = ((StringBuilder)localObject).toString();
        ReportController.b(this.app, "CliOper", "", "", "0X80064EA", "0X80064EA", 0, 0, paramBusinessCard, "", "", "");
        return;
      }
      if (getIntent().getIntExtra("source_activity", 0) == 1)
      {
        if (!TextUtils.isEmpty(paramBusinessCard.cardName))
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8007749", "0X8007749", this.jdField_d_of_type_Int, 0, "", "", "", "");
          localObject = "1";
        }
        else
        {
          localObject = "0";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80064EF", "0X80064EF", 0, 0, (String)localObject, "", "", "");
        if (!TextUtils.isEmpty(paramBusinessCard.company))
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800774A", "0X800774A", this.jdField_d_of_type_Int, 0, "", "", "", "");
          localObject = "1";
        }
        else
        {
          localObject = "0";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80064F0", "0X80064F0", 0, 0, (String)localObject, "", "", "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBusinessCard.qqNum.size());
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        ReportController.b(this.app, "CliOper", "", "", "0X80064F1", "0X80064F1", 0, 0, (String)localObject, "", "", "");
        int k = paramBusinessCard.descs.size();
        i = 0;
        while (i < k)
        {
          if (!TextUtils.isEmpty((CharSequence)paramBusinessCard.descs.get(i))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774E", "0X800774E", this.jdField_d_of_type_Int, 0, "", "", "", "");
          }
          i += 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBusinessCard.descs.size());
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        ReportController.b(this.app, "CliOper", "", "", "0X80064F2", "0X80064F2", 0, 0, (String)localObject, "", "", "");
        k = paramBusinessCard.mobilesNum.size();
        i = j;
        while (i < k)
        {
          if ((i == 0) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774B", "0X800774B", this.jdField_d_of_type_Int, 0, "", "", "", "");
          }
          if ((i == 1) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774C", "0X800774C", this.jdField_d_of_type_Int, 0, "", "", "", "");
          }
          if ((i == 2) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774D", "0X800774D", this.jdField_d_of_type_Int, 0, "", "", "", "");
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Object localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("bind_phone_num");
      Object localObject2;
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_b_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if (!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        localObject2 = paramCardOCRInfo.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_b_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty())) {
        a(this.jdField_b_of_type_AndroidWidgetLinearLayout, null, 1);
      }
      if (!a())
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        localObject3 = new ArrayList();
        paramCardOCRInfo = new ArrayList();
        if (a((ArrayList)localObject2, (ArrayList)localObject1, (ArrayList)localObject3, paramCardOCRInfo))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          Object localObject4;
          Object localObject5;
          Object localObject6;
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (String)((Iterator)localObject2).next();
            localObject3 = LayoutInflater.from(this).inflate(2131560997, null);
            localObject5 = (ImageView)((View)localObject3).findViewById(2131368343);
            localObject6 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject4);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject6));
            ((ImageView)localObject5).setBackgroundDrawable((Drawable)localObject6);
            ((TextView)((View)localObject3).findViewById(2131371862)).setText(ContactUtils.f(this.app, (String)localObject4));
            ((TextView)((View)localObject3).findViewById(2131380150)).setText((CharSequence)localObject4);
            ((ImageView)((View)localObject3).findViewById(2131362983)).setVisibility(0);
            localObject5 = new BusinessCardEditActivity.ItemHolder(this);
            ((BusinessCardEditActivity.ItemHolder)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject4);
            ((BusinessCardEditActivity.ItemHolder)localObject5).jdField_b_of_type_JavaLangString = ContactUtils.f(this.app, (String)localObject4);
            ((BusinessCardEditActivity.ItemHolder)localObject5).jdField_a_of_type_Boolean = false;
            ((View)localObject3).setTag(localObject5);
            ((View)localObject3).setOnClickListener(new BusinessCardEditActivity.4(this));
            localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject2 = LayoutInflater.from(this).inflate(2131560997, null);
            localObject4 = (ImageView)((View)localObject2).findViewById(2131368343);
            localObject5 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject3);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject5));
            ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject5);
            localObject4 = (TextView)((View)localObject2).findViewById(2131371862);
            ((TextView)((View)localObject2).findViewById(2131380150)).setText((CharSequence)localObject3);
            localObject5 = (Button)((View)localObject2).findViewById(2131362215);
            ((Button)localObject5).setVisibility(0);
            localObject6 = new BusinessCardEditActivity.ItemHolder(this);
            ((BusinessCardEditActivity.ItemHolder)localObject6).jdField_a_of_type_JavaLangString = ((String)localObject3);
            ((BusinessCardEditActivity.ItemHolder)localObject6).jdField_b_of_type_JavaLangString = ContactUtils.b(this.app, (String)localObject3, true);
            ((BusinessCardEditActivity.ItemHolder)localObject6).jdField_a_of_type_Boolean = false;
            ((View)localObject2).setTag(localObject6);
            ((TextView)localObject4).setText(((BusinessCardEditActivity.ItemHolder)localObject6).jdField_b_of_type_JavaLangString);
            ((Button)localObject5).setTag(localObject6);
            ((Button)localObject5).setOnClickListener(new BusinessCardEditActivity.5(this));
            localObject3 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          paramCardOCRInfo = paramCardOCRInfo.iterator();
          while (paramCardOCRInfo.hasNext())
          {
            localObject1 = (String)paramCardOCRInfo.next();
            a(this.jdField_c_of_type_AndroidWidgetLinearLayout, (String)localObject1, 0);
          }
        }
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 0);
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
      paramCardOCRInfo = (LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365541);
      localObject1 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365523);
      paramCardOCRInfo.setVisibility(8);
      ((View)localObject1).setVisibility(8);
    }
  }
  
  private void a(String paramString1, String paramString2, List<String> paramList)
  {
    ContentValues localContentValues = new ContentValues();
    Uri localUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues);
    if ((localUri != null) && (ContentUris.parseId(localUri) > 0L))
    {
      long l = ContentUris.parseId(localUri);
      this.jdField_g_of_type_Boolean = true;
      if ((paramString1 != null) && (paramList != null) && (paramList.size() > 0))
      {
        localContentValues.clear();
        localContentValues.put("raw_contact_id", Long.valueOf(l));
        localContentValues.put("mimetype", "vnd.android.cursor.item/name");
        localContentValues.put("data2", paramString1);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
        if (paramString2 != null)
        {
          localContentValues.clear();
          localContentValues.put("raw_contact_id", Long.valueOf(l));
          localContentValues.put("mimetype", "vnd.android.cursor.item/organization");
          localContentValues.put("data1", paramString2);
          localContentValues.put("data2", Integer.valueOf(1));
          getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
        }
        paramString1 = paramList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          localContentValues.clear();
          localContentValues.put("raw_contact_id", Long.valueOf(l));
          localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
          localContentValues.put("data1", paramString2);
          localContentValues.put("data2", Integer.valueOf(2));
          getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
        }
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80064E4", "0X80064E4", 0, 0, "", "", "", "");
      return;
    }
    runOnUiThread(new BusinessCardEditActivity.15(this));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a().trim();
    Object localObject2 = str;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject3 = null;
      if (localObject2 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((FriendsManager)localObject2).a(paramString);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((Card)localObject1).strNick)))
      {
        localObject1 = ((Card)localObject1).strNick;
      }
      else
      {
        if (localObject2 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((FriendsManager)localObject2).e(paramString);
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((Friends)localObject2).name;
        }
      }
      localObject2 = str;
      if (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean)
      {
        localObject2 = str;
        if (str.equals(localObject1))
        {
          localObject2 = str;
          if (this.jdField_d_of_type_Boolean) {
            localObject2 = "";
          }
        }
      }
    }
    Object localObject1 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localObject1 != null)
    {
      ((FriendListHandler)localObject1).setFriendComment(paramString, (String)localObject2, false, paramBoolean);
      QZoneHelper.restartQzone();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    f();
    BusinessCard localBusinessCard = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
    if (localBusinessCard != null)
    {
      if (paramBoolean2) {
        c(localBusinessCard.picUrl);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, true);
    }
    a(paramBoolean3);
  }
  
  private boolean a(BusinessCard paramBusinessCard1, BusinessCard paramBusinessCard2)
  {
    if (paramBusinessCard2 == null) {
      return true;
    }
    if (!a(paramBusinessCard2.cardName, paramBusinessCard1.cardName)) {
      return true;
    }
    if (!a(paramBusinessCard2.picUrl, paramBusinessCard1.picUrl)) {
      return true;
    }
    if (!a(paramBusinessCard2.company, paramBusinessCard1.company)) {
      return true;
    }
    if (paramBusinessCard1.mobilesNum.size() != paramBusinessCard2.mobilesNum.size()) {
      return true;
    }
    int i = 0;
    while (i < paramBusinessCard2.mobilesNum.size())
    {
      if (!((String)paramBusinessCard1.mobilesNum.get(i)).equals(paramBusinessCard2.mobilesNum.get(i))) {
        return true;
      }
      i += 1;
    }
    if (paramBusinessCard1.descs.size() != paramBusinessCard2.descs.size()) {
      return true;
    }
    i = 0;
    while (i < paramBusinessCard2.descs.size())
    {
      if (!((String)paramBusinessCard1.descs.get(i)).equals(paramBusinessCard2.descs.get(i))) {
        return true;
      }
      i += 1;
    }
    if (paramBusinessCard1.qqNum.size() != paramBusinessCard2.uinInfos.size()) {
      return true;
    }
    i = 0;
    while (i < paramBusinessCard2.uinInfos.size())
    {
      if (!((String)paramBusinessCard1.qqNum.get(i)).equals(((CardUinInfo)paramBusinessCard2.uinInfos.get(i)).jdField_a_of_type_JavaLangString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return true;
    }
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2));
  }
  
  private boolean a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
    if (localObject1 != null)
    {
      if ((!TextUtils.isEmpty(((BusinessCard)localObject1).bindUin)) && ((((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardType == 1))) {
        paramArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.uinInfos.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CardUinInfo)((Iterator)localObject1).next();
        if (((CardUinInfo)localObject2).jdField_a_of_type_Boolean) {
          paramArrayList1.add(((CardUinInfo)localObject2).jdField_a_of_type_JavaLangString);
        } else if (((CardUinInfo)localObject2).jdField_b_of_type_Boolean) {
          paramArrayList2.add(((CardUinInfo)localObject2).jdField_a_of_type_JavaLangString);
        } else {
          paramArrayList4.add(((CardUinInfo)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobileInfos.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CardMobileInfo)((Iterator)localObject1).next();
        if (((CardMobileInfo)localObject2).jdField_a_of_type_Boolean) {
          paramArrayList1.add(((CardMobileInfo)localObject2).jdField_b_of_type_JavaLangString);
        } else {
          paramArrayList3.add(((CardMobileInfo)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
      if ((paramArrayList1.isEmpty()) && (paramArrayList2.isEmpty()) && (paramArrayList3.isEmpty())) {
        return !paramArrayList4.isEmpty();
      }
      return true;
    }
    return false;
  }
  
  private void b(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return;
    }
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a(), paramCardOCRInfo.jdField_a_of_type_JavaLangString);
    int j = 1;
    int k = bool ^ true;
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      String str = ((EditText)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getText().toString().trim();
      if (!TextUtils.isEmpty(str)) {
        ((ArrayList)localObject).add(str);
      }
      i += 1;
    }
    if ((!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) && (!((ArrayList)localObject).isEmpty()))
    {
      paramCardOCRInfo = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(0);
      if (!TextUtils.isEmpty(paramCardOCRInfo)) {
        localObject = ((ArrayList)localObject).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext()) {
        if (paramCardOCRInfo.equals((String)((Iterator)localObject).next())) {
          if ((paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) && (((ArrayList)localObject).isEmpty()))
          {
            i = 0;
            break label201;
          }
        }
      }
    }
    i = 1;
    label201:
    if ((k != 0) && (i != 0)) {
      i = j;
    } else if (k != 0) {
      i = 2;
    } else if (i != 0) {
      i = 3;
    } else {
      i = 0;
    }
    BusinessCardUtils.a(this.app.getCurrentAccountUin(), i);
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131364330);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131364305);
    Object localObject = (TextView)findViewById(2131371708);
    if (this.jdField_a_of_type_Int == 2)
    {
      ((TextView)localObject).setText(super.getResources().getString(2131693376));
      if (paramBoolean)
      {
        paramString1 = this.jdField_c_of_type_JavaLangString;
        if (paramString1 == null)
        {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.bindUin)))
          {
            localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            paramString1 = null;
            Card localCard;
            if (localObject == null) {
              localCard = null;
            } else {
              localCard = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
            }
            if ((localCard != null) && ((!TextUtils.isEmpty(localCard.strReMark)) || (!TextUtils.isEmpty(localCard.strNick))))
            {
              if (TextUtils.isEmpty(localCard.strReMark)) {
                localObject = localCard.strNick;
              } else {
                localObject = localCard.strReMark;
              }
              paramString1 = (String)localObject;
              if (!TextUtils.isEmpty(localCard.strReMark)) {
                break label297;
              }
              this.jdField_d_of_type_Boolean = true;
              paramString1 = (String)localObject;
              break label297;
            }
            if (localObject != null) {
              paramString1 = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
            }
            if (paramString1 != null)
            {
              if (!TextUtils.isEmpty(paramString1.remark))
              {
                paramString1 = paramString1.remark;
                break label297;
              }
              paramString1 = paramString1.name;
              this.jdField_d_of_type_Boolean = true;
              break label297;
            }
          }
          paramString1 = "";
        }
      }
    }
    else
    {
      ((TextView)localObject).setText(super.getResources().getString(2131698673));
    }
    label297:
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setEllipsisText(paramString1);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setEllipsisText(paramString2);
    if (this.jdField_a_of_type_Boolean)
    {
      localRelativeLayout1.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(true);
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131698676);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131698674);
      }
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity$MaxBytesTextWatcher = new BusinessCardEditActivity.MaxBytesTextWatcher(this, 96, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText, 1);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity$MaxBytesTextWatcher);
      localRelativeLayout2.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(true);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(true);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131698663);
      paramString1 = new BusinessCardEditActivity.MaxBytesTextWatcher(this, 30, this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.addTextChangedListener(paramString1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(HardCodeUtil.a(2131701472));
    if (TextUtils.isEmpty(paramString2))
    {
      localRelativeLayout2.setVisibility(8);
      return;
    }
    localRelativeLayout2.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(false);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(false);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(HardCodeUtil.a(2131701467));
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("/?01");
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      int i = getResources().getDisplayMetrics().widthPixels;
      int j = i * 600 / 1000;
      paramString = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramString.width = i;
      paramString.height = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramString);
      try
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mRequestWidth = 1000;
        paramString.mRequestHeight = 600;
        paramString.mLoadingDrawable = super.getResources().getDrawable(2130844945);
        paramString.mFailedDrawable = super.getResources().getDrawable(2130844945);
        paramString = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    findViewById(2131372722).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidContentIntent = super.getIntent();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("mode_type", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_edit_mode", false);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("cur_card_id");
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("cur_card_body"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = ((CardOCRInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("cur_ocr_info"));
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("source_activity", 0);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("finish_immedia", false);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("has_local_remark");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER));
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a((String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        ThreadManager.post(new BusinessCardEditActivity.1(this), 8, null, true);
      }
      if (this.jdField_a_of_type_Int != 3) {
        BusinessCardServlet.a(this.app, this.jdField_a_of_type_JavaLangString, false, 3);
      } else {
        BusinessCardServlet.a(this.app, this.jdField_a_of_type_JavaLangString, true, 3);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
      if (localObject != null) {
        this.jdField_a_of_type_JavaLangString = ((BusinessCard)localObject).cardId;
      }
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
      if ((localObject != null) && (!TextUtils.isEmpty(((BusinessCard)localObject).picUrl))) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 2) {
      this.jdField_d_of_type_Int = 1;
    } else if (i == 3) {
      this.jdField_d_of_type_Int = 2;
    } else {
      this.jdField_d_of_type_Int = 0;
    }
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    g();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void d(String paramString)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 2131692932, 2131693286, new BusinessCardEditActivity.13(this), new BusinessCardEditActivity.14(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void e()
  {
    super.setContentView(2131560992);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376828));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
    }
    a();
    f();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364338));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText = ((ClearEllipsisEditText)findViewById(2131364329));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setTag("name");
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setMaxLength(96, 1);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText = ((ClearEllipsisEditText)findViewById(2131364304));
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setMaxLength(30, 2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366065));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365748));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
    if (localObject != null)
    {
      c(((BusinessCard)localObject).picUrl);
      b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, true);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
      if (localObject != null)
      {
        c(((CardOCRInfo)localObject).jdField_b_of_type_JavaLangString);
        b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_JavaLangString, null, true);
      }
      else
      {
        c(null);
        b(null, null, true);
      }
    }
    a(true);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 2) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698669);
      } else if (i == 3) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698672);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698668);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692486);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(super.getResources().getDrawable(2130851066));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_Int == 3) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698672);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698667);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691859);
    if (this.jdField_b_of_type_Int == 2) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(super.getResources().getDrawable(2130851066));
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131698679);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
    if ((localObject != null) && (((((BusinessCard)localObject).OCRInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo.jdField_b_of_type_JavaLangString))) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() > 0)))
    {
      if ((this.jdField_a_of_type_Int != 3) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.isEmpty()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() > 0) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
      else {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
      if ((localObject != null) && (((CardOCRInfo)localObject).jdField_b_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        if ((this.jdField_a_of_type_Int != 3) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_JavaLangString)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.size() > 0) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          }
        }
        else {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      else {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  private void g()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new BusinessCardEditActivity.16(this, new Handler(this.app.getApp().getMainLooper()));
      this.app.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
      }
      this.jdField_g_of_type_Boolean = false;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369233));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363706));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363726));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 9999);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_max", 1);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, localIntent, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextSize(16.0F);
    localTextView.setHint(HardCodeUtil.a(2131701488));
    localTextView.setTextColor(super.getResources().getColor(2131167056));
    localTextView.setGravity(16);
    localTextView.setBackgroundDrawable(super.getResources().getDrawable(2130850723));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 44.0F));
    localTextView.setPadding(AIOUtils.b(28.0F, getResources()), 0, AIOUtils.b(50.0F, getResources()), 0);
    if (paramInt == 1)
    {
      localTextView.setTag(paramString);
      localTextView.setOnClickListener(new BusinessCardEditActivity.9(this));
      paramString = localLayoutParams;
    }
    else
    {
      paramString = localLayoutParams;
      if (paramInt == 2)
      {
        paramString = new LinearLayout.LayoutParams(-1, -2);
        localTextView.setMinHeight(DisplayUtil.a(this, 44.0F));
        localTextView.setPadding(AIOUtils.b(28.0F, getResources()), AIOUtils.b(12.0F, getResources()), AIOUtils.b(50.0F, getResources()), AIOUtils.b(10.0F, getResources()));
      }
    }
    paramLinearLayout.addView(localTextView, paramString);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2)
  {
    a(paramLinearLayout, paramString, paramInt1, paramInt2, false);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.b(44.0F, getResources()));
    Object localObject;
    if (paramInt1 != 2)
    {
      localObject = new ClearableEditText(this);
      ((EditText)localObject).setInputType(2);
      ((EditText)localObject).setSingleLine();
      ((EditText)localObject).setHint(2131698670);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130850723));
      ((EditText)localObject).setCompoundDrawablePadding(AIOUtils.b(5.0F, getResources()));
      ((EditText)localObject).setPadding(AIOUtils.b(28.0F, getResources()), 0, AIOUtils.b(10.0F, getResources()), 0);
    }
    else
    {
      localObject = new EditText(this);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130850723));
      ((EditText)localObject).setMinHeight(DisplayUtil.a(this, 44.0F));
      ((EditText)localObject).setOnEditorActionListener(this);
      ((EditText)localObject).setPadding(AIOUtils.b(28.0F, getResources()), AIOUtils.b(12.0F, getResources()), AIOUtils.b(50.0F, getResources()), AIOUtils.b(10.0F, getResources()));
      ((EditText)localObject).setHint(2131698665);
    }
    ((EditText)localObject).setText(paramString);
    ((EditText)localObject).setTextSize(16.0F);
    ((EditText)localObject).setTextColor(super.getResources().getColor(2131167056));
    ((EditText)localObject).setHintTextColor(super.getResources().getColor(2131165420));
    ((EditText)localObject).setGravity(16);
    paramLinearLayout.addView((View)localObject, localLayoutParams);
    ((EditText)localObject).addTextChangedListener(new BusinessCardEditActivity.MaxBytesTextWatcher(this, paramInt2, (EditText)localObject));
    if (paramBoolean)
    {
      ((EditText)localObject).setSelection(((EditText)localObject).getText().toString().length());
      ((EditText)localObject).postDelayed(new BusinessCardEditActivity.2(this, (EditText)localObject), 100L);
    }
  }
  
  void a(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(this);
    localActionSheet.addButton(2131698660);
    localActionSheet.addButton(2131698681);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new BusinessCardEditActivity.12(this, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(String paramString, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2131560996, null);
    localView.setTag(Integer.valueOf(paramInt));
    EditText localEditText = (EditText)localView.findViewById(2131374258);
    localEditText.addTextChangedListener(new BusinessCardEditActivity.MaxBytesTextWatcher(this, 15, localEditText));
    localEditText.setText(paramString);
    paramString = (ImageView)localView.findViewById(2131362239);
    paramString.setTag(Integer.valueOf(paramInt));
    paramString.setOnClickListener(new BusinessCardEditActivity.3(this));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 2;
      j = 2;
    }
    else
    {
      i = 1;
      j = 1;
    }
    paramString1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, i, paramString1, null, 3026, j, paramString2, null, BusinessCardEditActivity.class.getName(), setLastActivityName(), null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this, paramString1);
    ReportController.b(this.app, "CliOper", "", "", "0X80064E6", "0X80064E6", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371426));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374260));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131365528));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371420));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374039));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131365521));
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (a())
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374261).setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramBoolean) {
        a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131371426));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131374260));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365528));
      if (a())
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131374261).setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.w("BusinessCard_EditActivity", 2, "名片备注不应该出现详情态");
        }
      }
      if (paramBoolean)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
        if (localObject != null)
        {
          a((BusinessCard)localObject);
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
        if (localObject != null) {
          a((CardOCRInfo)localObject);
        }
      }
    }
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 3) || (i == 2) || (this.jdField_b_of_type_Int == 2);
  }
  
  void b()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void b(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    if (isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver != null)
    {
      try
      {
        this.app.getApp().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
        }
      }
      this.jdField_a_of_type_AndroidDatabaseContentObserver = null;
    }
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("CheckPermission", 1, "CheckPermission user denied = ");
    this.jdField_f_of_type_Boolean = false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {
        return;
      }
      paramInt2 = 0;
      if (paramInt1 != 11)
      {
        Object localObject;
        if (paramInt1 != 21)
        {
          paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
          if ((paramIntent != null) && (this.jdField_a_of_type_Boolean))
          {
            paramIntent = (ResultRecord)paramIntent.get(0);
            while (paramInt2 < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
            {
              localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt2);
              if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof Integer)) && (paramInt1 == ((Integer)((View)localObject).getTag()).intValue()))
              {
                localObject = (EditText)((View)localObject).findViewById(2131374258);
                if (localObject != null)
                {
                  ((EditText)localObject).setText(paramIntent.uin);
                  return;
                }
              }
              paramInt2 += 1;
            }
          }
        }
        else
        {
          paramIntent.putExtra("selfSet_leftViewText", getString(2131719442));
          localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          startActivity((Intent)localObject);
        }
      }
      else if ((this.jdField_a_of_type_Boolean) && (paramIntent.getBooleanExtra("delete_pic", false)))
      {
        this.jdField_e_of_type_Boolean = true;
        c(null);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    d();
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    c();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceDrawable localFaceDrawable = (FaceDrawable)((WeakReference)localIterator.next()).get();
      if (localFaceDrawable != null) {
        localFaceDrawable.cancel();
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_g_of_type_Boolean = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_d_of_type_Int != 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X8007751", "0X8007751", this.jdField_d_of_type_Int, 0, "", "", "", "");
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.jdField_f_of_type_Boolean) {
      ThreadManager.post(new BusinessCardEditActivity.11(this), 8, null, true);
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    InputMethodUtil.a(this);
    if (this.jdField_a_of_type_Boolean)
    {
      BusinessCard localBusinessCard = new BusinessCard();
      a(localBusinessCard, false);
      if (a(localBusinessCard, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
      {
        d(super.getResources().getString(2131695053));
        return true;
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (!isFinishing()))
      {
        finish();
        return true;
      }
      localBusinessCard = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
      if ((localBusinessCard != null) && (!TextUtils.isEmpty(localBusinessCard.cardId)))
      {
        a(false, false, false);
        return true;
      }
      super.finish();
      return true;
    }
    super.finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131374039: 
      a(null, this.jdField_f_of_type_Int);
      this.jdField_f_of_type_Int += 1;
      if (this.jdField_f_of_type_Int >= 2) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      break;
    case 2131371420: 
      a(this.jdField_b_of_type_AndroidWidgetLinearLayout, null, 1, 15);
      this.jdField_e_of_type_Int += 1;
      if (this.jdField_e_of_type_Int >= 3) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_d_of_type_Int != 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8007752", "0X8007752", this.jdField_d_of_type_Int, 0, "", "", "", "");
      }
      break;
    case 2131369233: 
      if (this.jdField_a_of_type_Boolean)
      {
        InputMethodUtil.a(this);
        localObject2 = new BusinessCard();
        a((BusinessCard)localObject2, true);
        if (this.jdField_c_of_type_Boolean)
        {
          b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
          this.jdField_c_of_type_Boolean = false;
        }
        if ((this.jdField_a_of_type_Int == 2) && (this.jdField_c_of_type_JavaLangString != null))
        {
          ((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a(((BusinessCard)localObject2).bindUin, (BusinessCard)localObject2);
          if (!isFinishing())
          {
            localObject1 = getIntent();
            this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
            ((Intent)localObject1).putExtra("has_local_remark", this.jdField_c_of_type_JavaLangString);
            setResult(-1, (Intent)localObject1);
            finish();
          }
        }
        else
        {
          if (this.jdField_a_of_type_Int == 2)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
            if (localObject1 != null) {
              a(((BusinessCard)localObject1).bindUin, getIntent().getBooleanExtra("notify_plugin", false));
            }
          }
          if (a((BusinessCard)localObject2, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
          {
            if (!NetworkUtil.isNetSupport(this))
            {
              a(2131694475, 1);
              break;
            }
            localObject1 = Boolean.valueOf(false);
            if (this.jdField_a_of_type_Int == 3) {
              localObject1 = Boolean.valueOf(true);
            }
            if ((((BusinessCard)localObject2).cardId != null) && (((BusinessCard)localObject2).cardId.length() > 0))
            {
              BusinessCardServlet.b(this.app, (BusinessCard)localObject2, ((Boolean)localObject1).booleanValue());
              b(HardCodeUtil.a(2131701468));
            }
            else
            {
              BusinessCardServlet.a(this.app, (BusinessCard)localObject2, ((Boolean)localObject1).booleanValue());
              b(HardCodeUtil.a(2131701462));
            }
          }
          else if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (!isFinishing()))
          {
            finish();
          }
          else
          {
            a(false, false, false);
          }
        }
        if (this.jdField_d_of_type_Int != 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007754", "0X8007754", this.jdField_d_of_type_Int, 0, "", "", "", "");
        }
      }
      else
      {
        a(true, false, true);
        ReportController.b(this.app, "CliOper", "", "", "0X80064E2", "0X80064E2", 0, 0, "", "", "", "");
      }
      break;
    case 2131369202: 
      onBackEvent();
      break;
    case 2131365521: 
      a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 2, 150);
      this.jdField_g_of_type_Int += 1;
      if (this.jdField_g_of_type_Int >= 2) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      break;
    case 2131364338: 
      localObject1 = new Intent(this, CardPicGalleryActivity.class);
      localObject2 = new ArrayList();
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        ((ArrayList)localObject2).add(this.jdField_b_of_type_JavaLangString);
      }
      ((Intent)localObject1).putStringArrayListExtra("business_card_pics", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("is_edit_mode", this.jdField_a_of_type_Boolean);
      int i = this.jdField_b_of_type_Int;
      if ((i == 1) || (i == 3)) {
        ((Intent)localObject1).putExtra("is_from_profile", true);
      }
      startActivityForResult((Intent)localObject1, 11);
      overridePendingTransition(2130772351, 0);
      break;
    case 2131363726: 
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null))
      {
        this.jdField_f_of_type_Boolean = true;
        requestPermissions(new BusinessCardEditActivity.10(this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramKeyEvent == null) {
      return false;
    }
    if (paramKeyEvent.getKeyCode() == 66) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity
 * JD-Core Version:    0.7.0.1
 */