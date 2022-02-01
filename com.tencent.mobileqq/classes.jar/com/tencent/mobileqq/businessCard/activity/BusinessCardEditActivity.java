package com.tencent.mobileqq.businessCard.activity;

import Override;
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
import anvi;
import anvk;
import anvx;
import aqjm;
import aqjn;
import aqjo;
import aqjp;
import aqjq;
import aqjr;
import aqjs;
import aqjt;
import aqju;
import aqjv;
import aqjw;
import aqjx;
import aqjy;
import aqjz;
import aqka;
import aqkb;
import aqkc;
import aqkd;
import aqke;
import aqkw;
import bdla;
import bhdj;
import bisl;
import bisy;
import bkxz;
import bkzi;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
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
  public int a;
  public Dialog a;
  Intent jdField_a_of_type_AndroidContentIntent;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new aqju(this);
  public aqjm a;
  aqjn jdField_a_of_type_Aqjn = new aqjv(this);
  aqke jdField_a_of_type_Aqke;
  bisl jdField_a_of_type_Bisl;
  public BusinessCard a;
  CardOCRInfo jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
  ClearEllipsisEditText jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText;
  public String a;
  private List<WeakReference<FaceDrawable>> jdField_a_of_type_JavaUtilList;
  public boolean a;
  int jdField_b_of_type_Int;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ClearEllipsisEditText jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  public int c;
  public LinearLayout c;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  public int d;
  LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 1;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 1;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 1;
  private boolean jdField_g_of_type_Boolean;
  
  public BusinessCardEditActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
  }
  
  private void a(BusinessCard paramBusinessCard)
  {
    Object localObject1;
    if (paramBusinessCard != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("bind_phone_num");
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
            localObject5 = LayoutInflater.from(this).inflate(2131561045, null);
            localObject7 = (ImageView)((View)localObject5).findViewById(2131368381);
            localObject8 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject6);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject8));
            ((ImageView)localObject7).setBackgroundDrawable((Drawable)localObject8);
            ((TextView)((View)localObject5).findViewById(2131371966)).setText(ContactUtils.getFriendShowName(this.app, (String)localObject6));
            ((TextView)((View)localObject5).findViewById(2131380443)).setText((CharSequence)localObject6);
            ((ImageView)((View)localObject5).findViewById(2131362993)).setVisibility(0);
            localObject7 = new aqkd(this);
            ((aqkd)localObject7).jdField_a_of_type_JavaLangString = ((String)localObject6);
            ((aqkd)localObject7).jdField_b_of_type_JavaLangString = ContactUtils.getFriendShowName(this.app, (String)localObject6);
            ((aqkd)localObject7).jdField_a_of_type_Boolean = false;
            ((View)localObject5).setTag(localObject7);
            ((View)localObject5).setOnClickListener(new aqjz(this));
            localObject6 = new LinearLayout.LayoutParams(-1, DisplayUtil.dip2px(this, 70.0F));
            this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
          }
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (String)((Iterator)localObject3).next();
            localObject4 = LayoutInflater.from(this).inflate(2131561045, null);
            localObject6 = (ImageView)((View)localObject4).findViewById(2131368381);
            localObject7 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject5);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject7));
            ((ImageView)localObject6).setBackgroundDrawable((Drawable)localObject7);
            localObject6 = (TextView)((View)localObject4).findViewById(2131371966);
            ((TextView)((View)localObject4).findViewById(2131380443)).setText((CharSequence)localObject5);
            localObject7 = (Button)((View)localObject4).findViewById(2131362169);
            ((Button)localObject7).setVisibility(0);
            localObject8 = new aqkd(this);
            ((aqkd)localObject8).jdField_a_of_type_JavaLangString = ((String)localObject5);
            ((aqkd)localObject8).jdField_b_of_type_JavaLangString = ContactUtils.getBuddyNickName(this.app, (String)localObject5, true);
            ((aqkd)localObject8).jdField_a_of_type_Boolean = false;
            ((View)localObject4).setTag(localObject8);
            ((TextView)localObject6).setText(((aqkd)localObject8).jdField_b_of_type_JavaLangString);
            ((Button)localObject7).setTag(localObject8);
            ((Button)localObject7).setOnClickListener(new aqka(this));
            localObject5 = new LinearLayout.LayoutParams(-1, DisplayUtil.dip2px(this, 70.0F));
            this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject7 = (String)((Iterator)localObject2).next();
            localObject3 = LayoutInflater.from(this).inflate(2131561045, null);
            localObject4 = (ImageView)((View)localObject3).findViewById(2131368381);
            localObject5 = (TextView)((View)localObject3).findViewById(2131371966);
            localObject8 = (TextView)((View)localObject3).findViewById(2131380443);
            localObject6 = (Button)((View)localObject3).findViewById(2131362169);
            ((Button)localObject6).setVisibility(0);
            ((TextView)localObject8).setText((CharSequence)localObject7);
            localObject8 = paramBusinessCard.getMobileInfoByMobile((String)localObject7);
            aqkd localaqkd = new aqkd(this);
            localaqkd.jdField_a_of_type_Boolean = true;
            if (localObject8 != null)
            {
              localObject7 = FaceDrawable.getFaceDrawable(this.app, 11, ((CardMobileInfo)localObject8).d);
              this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject7));
              ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject7);
              localaqkd.jdField_a_of_type_JavaLangString = ((CardMobileInfo)localObject8).d;
            }
            for (localaqkd.jdField_b_of_type_JavaLangString = ((CardMobileInfo)localObject8).jdField_c_of_type_JavaLangString;; localaqkd.jdField_b_of_type_JavaLangString = ((String)localObject7))
            {
              ((View)localObject3).setTag(localaqkd);
              ((TextView)localObject5).setText(localaqkd.jdField_b_of_type_JavaLangString);
              ((Button)localObject6).setTag(localaqkd);
              ((Button)localObject6).setOnClickListener(new aqkb(this));
              localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.dip2px(this, 70.0F));
              this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
              break;
              localaqkd.jdField_a_of_type_JavaLangString = ((String)localObject7);
            }
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
      localObject1 = (LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365543);
      Object localObject2 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365525);
      if (paramBusinessCard.descs.isEmpty()) {
        break label1143;
      }
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
    return;
    label1143:
    ((LinearLayout)localObject1).setVisibility(8);
    ((LinearLayout)localObject1).setVisibility(8);
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
      if (this.jdField_a_of_type_AndroidContentIntent.getExtras() != null) {}
      for (paramCardOCRInfo = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("add_phone_num", null);; paramCardOCRInfo = null)
      {
        if ((paramCardOCRInfo != null) && (this.jdField_e_of_type_Int < 3))
        {
          this.jdField_e_of_type_Int += 1;
          a(this.jdField_b_of_type_AndroidWidgetLinearLayout, paramCardOCRInfo, 1, 15, true);
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
        if (paramBusinessCard.uinInfos.isEmpty()) {
          break label383;
        }
        i = j;
        while (i < paramBusinessCard.uinInfos.size())
        {
          paramCardOCRInfo = ((CardUinInfo)paramBusinessCard.uinInfos.get(i)).jdField_a_of_type_JavaLangString;
          if (!TextUtils.isEmpty(paramCardOCRInfo)) {
            a(paramCardOCRInfo, i);
          }
          i += 1;
        }
      }
      this.jdField_f_of_type_Int = paramBusinessCard.uinInfos.size();
      if (this.jdField_f_of_type_Int >= 2) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
        if (paramBusinessCard.descs.isEmpty()) {
          break label444;
        }
        paramCardOCRInfo = new StringBuilder();
        localIterator = paramBusinessCard.descs.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (paramCardOCRInfo.length() > 0) {
            paramCardOCRInfo.append("\n");
          }
          paramCardOCRInfo.append(str);
        }
        label383:
        a(null, 0);
        this.jdField_f_of_type_Int = 1;
      }
      a(this.jdField_d_of_type_AndroidWidgetLinearLayout, paramCardOCRInfo.toString(), 2, 150);
      this.jdField_g_of_type_Int = paramBusinessCard.descs.size();
      if (this.jdField_g_of_type_Int >= 2) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    label444:
    while (paramCardOCRInfo == null)
    {
      Iterator localIterator;
      String str;
      return;
      a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 2, 150);
      this.jdField_g_of_type_Int = 1;
      return;
    }
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
    }
    for (this.jdField_e_of_type_Int = paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size();; this.jdField_e_of_type_Int = 1)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (paramCardOCRInfo.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label666;
      }
      i = k;
      while (i < paramCardOCRInfo.jdField_a_of_type_JavaUtilList.size())
      {
        a((String)paramCardOCRInfo.jdField_a_of_type_JavaUtilList.get(i), i);
        i += 1;
      }
      a(this.jdField_b_of_type_AndroidWidgetLinearLayout, null, 1, 15);
    }
    for (this.jdField_f_of_type_Int = paramCardOCRInfo.jdField_a_of_type_JavaUtilList.size();; this.jdField_f_of_type_Int = 1)
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
      a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 2, 150);
      this.jdField_g_of_type_Int = 1;
      return;
      label666:
      a(null, 0);
    }
  }
  
  private void a(BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      paramBusinessCard.cardId = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
      paramBusinessCard.bindUin = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin;
      if (this.jdField_a_of_type_Int == 2) {
        paramBusinessCard.cardName = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName;
      }
    }
    if (this.jdField_a_of_type_Int != 2) {
      paramBusinessCard.cardName = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null)
    {
      paramBusinessCard.picUrl = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaLangString;
      paramBusinessCard.OCRInfo = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
    }
    Object localObject;
    for (;;)
    {
      if (this.jdField_e_of_type_Boolean)
      {
        paramBusinessCard.picUrl = null;
        paramBusinessCard.OCRInfo = null;
      }
      paramBusinessCard.company = this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
      paramBusinessCard.mobilesNum.clear();
      i = 0;
      while (i < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject = ((EditText)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getText().toString().trim();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramBusinessCard.mobilesNum.add(localObject);
        }
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
      {
        paramBusinessCard.picUrl = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl;
        paramBusinessCard.OCRInfo = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo;
      }
    }
    paramBusinessCard.qqNum.clear();
    int i = 0;
    while (i < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject instanceof RelativeLayout))
      {
        localObject = (EditText)((View)localObject).findViewById(2131374378);
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
      if (this.jdField_a_of_type_Int != 0) {
        break label643;
      }
      localObject = "0";
      if (TextUtils.isEmpty(paramBusinessCard.cardName)) {
        localObject = "1";
      }
      bdla.b(this.app, "CliOper", "", "", "0X80064E7", "0X80064E7", 0, 0, (String)localObject, "", "", "");
      localObject = "0";
      if (TextUtils.isEmpty(paramBusinessCard.company)) {
        localObject = "1";
      }
      bdla.b(this.app, "CliOper", "", "", "0X80064E8", "0X80064E8", 0, 0, (String)localObject, "", "", "");
      localObject = paramBusinessCard.qqNum.size() + "";
      bdla.b(this.app, "CliOper", "", "", "0X80064E9", "0X80064E9", 0, 0, (String)localObject, "", "", "");
      paramBusinessCard = paramBusinessCard.descs.size() + "";
      bdla.b(this.app, "CliOper", "", "", "0X80064EA", "0X80064EA", 0, 0, paramBusinessCard, "", "", "");
    }
    for (;;)
    {
      return;
      label643:
      if (getIntent().getIntExtra("source_activity", 0) == 1)
      {
        localObject = "0";
        if (!TextUtils.isEmpty(paramBusinessCard.cardName))
        {
          bdla.b(this.app, "CliOper", "", "", "0X8007749", "0X8007749", this.jdField_d_of_type_Int, 0, "", "", "", "");
          localObject = "1";
        }
        bdla.b(this.app, "CliOper", "", "", "0X80064EF", "0X80064EF", 0, 0, (String)localObject, "", "", "");
        localObject = "0";
        if (!TextUtils.isEmpty(paramBusinessCard.company))
        {
          bdla.b(this.app, "CliOper", "", "", "0X800774A", "0X800774A", this.jdField_d_of_type_Int, 0, "", "", "", "");
          localObject = "1";
        }
        bdla.b(this.app, "CliOper", "", "", "0X80064F0", "0X80064F0", 0, 0, (String)localObject, "", "", "");
        localObject = paramBusinessCard.qqNum.size() + "";
        bdla.b(this.app, "CliOper", "", "", "0X80064F1", "0X80064F1", 0, 0, (String)localObject, "", "", "");
        int j = paramBusinessCard.descs.size();
        i = 0;
        while (i < j)
        {
          if (!TextUtils.isEmpty((CharSequence)paramBusinessCard.descs.get(i))) {
            bdla.b(this.app, "CliOper", "", "", "0X800774E", "0X800774E", this.jdField_d_of_type_Int, 0, "", "", "", "");
          }
          i += 1;
        }
        localObject = paramBusinessCard.descs.size() + "";
        bdla.b(this.app, "CliOper", "", "", "0X80064F2", "0X80064F2", 0, 0, (String)localObject, "", "", "");
        j = paramBusinessCard.mobilesNum.size();
        i = 0;
        while (i < j)
        {
          if ((i == 0) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            bdla.b(this.app, "CliOper", "", "", "0X800774B", "0X800774B", this.jdField_d_of_type_Int, 0, "", "", "", "");
          }
          if ((i == 1) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            bdla.b(this.app, "CliOper", "", "", "0X800774C", "0X800774C", this.jdField_d_of_type_Int, 0, "", "", "", "");
          }
          if ((i == 2) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            bdla.b(this.app, "CliOper", "", "", "0X800774D", "0X800774D", this.jdField_d_of_type_Int, 0, "", "", "", "");
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
            localObject3 = LayoutInflater.from(this).inflate(2131561045, null);
            localObject5 = (ImageView)((View)localObject3).findViewById(2131368381);
            localObject6 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject4);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject6));
            ((ImageView)localObject5).setBackgroundDrawable((Drawable)localObject6);
            ((TextView)((View)localObject3).findViewById(2131371966)).setText(ContactUtils.getFriendShowName(this.app, (String)localObject4));
            ((TextView)((View)localObject3).findViewById(2131380443)).setText((CharSequence)localObject4);
            ((ImageView)((View)localObject3).findViewById(2131362993)).setVisibility(0);
            localObject5 = new aqkd(this);
            ((aqkd)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject4);
            ((aqkd)localObject5).jdField_b_of_type_JavaLangString = ContactUtils.getFriendShowName(this.app, (String)localObject4);
            ((aqkd)localObject5).jdField_a_of_type_Boolean = false;
            ((View)localObject3).setTag(localObject5);
            ((View)localObject3).setOnClickListener(new aqjx(this));
            localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.dip2px(this, 70.0F));
            this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject2 = LayoutInflater.from(this).inflate(2131561045, null);
            localObject4 = (ImageView)((View)localObject2).findViewById(2131368381);
            localObject5 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject3);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject5));
            ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject5);
            localObject4 = (TextView)((View)localObject2).findViewById(2131371966);
            ((TextView)((View)localObject2).findViewById(2131380443)).setText((CharSequence)localObject3);
            localObject5 = (Button)((View)localObject2).findViewById(2131362169);
            ((Button)localObject5).setVisibility(0);
            localObject6 = new aqkd(this);
            ((aqkd)localObject6).jdField_a_of_type_JavaLangString = ((String)localObject3);
            ((aqkd)localObject6).jdField_b_of_type_JavaLangString = ContactUtils.getBuddyNickName(this.app, (String)localObject3, true);
            ((aqkd)localObject6).jdField_a_of_type_Boolean = false;
            ((View)localObject2).setTag(localObject6);
            ((TextView)localObject4).setText(((aqkd)localObject6).jdField_b_of_type_JavaLangString);
            ((Button)localObject5).setTag(localObject6);
            ((Button)localObject5).setOnClickListener(new aqjy(this));
            localObject3 = new LinearLayout.LayoutParams(-1, DisplayUtil.dip2px(this, 70.0F));
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
      paramCardOCRInfo = (LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365543);
      localObject1 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365525);
      paramCardOCRInfo.setVisibility(8);
      ((View)localObject1).setVisibility(8);
    }
  }
  
  private void a(String paramString1, String paramString2, List<String> paramList)
  {
    ContentValues localContentValues = new ContentValues();
    Uri localUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues);
    if ((localUri == null) || (ContentUris.parseId(localUri) <= 0L))
    {
      runOnUiThread(new BusinessCardEditActivity.15(this));
      return;
    }
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
    bdla.b(this.app, "CliOper", "", "", "0X80064E4", "0X80064E4", 0, 0, "", "", "", "");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a().trim();
    anvk localanvk;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localanvk == null)
      {
        localObject1 = null;
        if ((localObject1 == null) || (TextUtils.isEmpty(((Card)localObject1).strNick))) {
          break label151;
        }
        localObject1 = ((Card)localObject1).strNick;
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Aqke.jdField_b_of_type_Boolean) && (((String)localObject2).equals(localObject1)) && (this.jdField_d_of_type_Boolean)) {}
      for (localObject1 = "";; localObject1 = localObject2)
      {
        localObject2 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (localObject2 != null)
        {
          ((FriendListHandler)localObject2).setFriendComment(paramString, (String)localObject1, false, paramBoolean);
          localObject1 = new QZoneDistributedAppCtrl.Control();
          ((QZoneDistributedAppCtrl.Control)localObject1).cmd = 5;
          QZoneDistributedAppCtrl.getInstance(paramString).submitCtrl((QZoneDistributedAppCtrl.Control)localObject1);
        }
        return;
        localObject1 = localanvk.b(paramString);
        break;
        label151:
        if (localanvk == null) {}
        for (localObject1 = null;; localObject1 = localanvk.e(paramString))
        {
          if (localObject1 == null) {
            break label186;
          }
          localObject1 = ((Friends)localObject1).name;
          break;
        }
      }
      label186:
      localObject1 = null;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      if (paramBoolean2) {
        c(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, true);
    }
    a(paramBoolean3);
  }
  
  private boolean a(BusinessCard paramBusinessCard1, BusinessCard paramBusinessCard2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBusinessCard2 == null)
    {
      bool1 = true;
      return bool1;
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
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramBusinessCard2.uinInfos.size()) {
        break;
      }
      if (!((String)paramBusinessCard1.qqNum.get(i)).equals(((CardUinInfo)paramBusinessCard2.uinInfos.get(i)).jdField_a_of_type_JavaLangString)) {
        return true;
      }
      i += 1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2))) {
      return true;
    }
    return false;
  }
  
  private boolean a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) && ((((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardType == 1))) {
        paramArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.uinInfos.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (CardUinInfo)localIterator.next();
        if (((CardUinInfo)localObject).jdField_a_of_type_Boolean) {
          paramArrayList1.add(((CardUinInfo)localObject).jdField_a_of_type_JavaLangString);
        } else if (((CardUinInfo)localObject).jdField_b_of_type_Boolean) {
          paramArrayList2.add(((CardUinInfo)localObject).jdField_a_of_type_JavaLangString);
        } else {
          paramArrayList4.add(((CardUinInfo)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      localIterator = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobileInfos.iterator();
      while (localIterator.hasNext())
      {
        localObject = (CardMobileInfo)localIterator.next();
        if (((CardMobileInfo)localObject).jdField_a_of_type_Boolean) {
          paramArrayList1.add(((CardMobileInfo)localObject).jdField_b_of_type_JavaLangString);
        } else {
          paramArrayList3.add(((CardMobileInfo)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      return (!paramArrayList1.isEmpty()) || (!paramArrayList2.isEmpty()) || (!paramArrayList3.isEmpty()) || (!paramArrayList4.isEmpty());
    }
    return false;
  }
  
  private void b(CardOCRInfo paramCardOCRInfo)
  {
    int k = 1;
    if (paramCardOCRInfo == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a(), paramCardOCRInfo.jdField_a_of_type_JavaLangString)) {}
    Object localObject;
    int i;
    for (int j = 1;; j = 0)
    {
      localObject = new ArrayList();
      i = 0;
      while (i < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        String str = ((EditText)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getText().toString().trim();
        if (!TextUtils.isEmpty(str)) {
          ((ArrayList)localObject).add(str);
        }
        i += 1;
      }
    }
    if ((!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) && (!((ArrayList)localObject).isEmpty()))
    {
      paramCardOCRInfo = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(0);
      if (TextUtils.isEmpty(paramCardOCRInfo)) {
        break label247;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramCardOCRInfo.equals((String)((Iterator)localObject).next())) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if ((j != 0) && (i != 0)) {
        i = k;
      }
      for (;;)
      {
        aqkw.a(this.app.getCurrentAccountUin(), i);
        return;
        if ((!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) || (!((ArrayList)localObject).isEmpty())) {
          break label247;
        }
        i = 0;
        break;
        if (j != 0) {
          i = 2;
        } else if (i != 0) {
          i = 3;
        } else {
          i = 0;
        }
      }
      label247:
      i = 1;
    }
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131364333);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131364308);
    Object localObject = (TextView)findViewById(2131371814);
    if (this.jdField_a_of_type_Int == 2)
    {
      ((TextView)localObject).setText(super.getResources().getString(2131693271));
      if (paramBoolean) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setEllipsisText(paramString1);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setEllipsisText(paramString2);
      if (this.jdField_a_of_type_Boolean)
      {
        localRelativeLayout1.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(true);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(true);
        if (this.jdField_a_of_type_Int == 2) {
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131698330);
        }
        for (;;)
        {
          this.jdField_a_of_type_Aqke = new aqke(this, 96, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText, 1);
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.addTextChangedListener(this.jdField_a_of_type_Aqke);
          localRelativeLayout2.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(true);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(true);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131698317);
          paramString1 = new aqke(this, 30, this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.addTextChangedListener(paramString1);
          return;
          if (this.jdField_c_of_type_JavaLangString != null)
          {
            paramString1 = this.jdField_c_of_type_JavaLangString;
            break;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin))) {
            break label531;
          }
          paramString1 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          Card localCard;
          if (paramString1 == null)
          {
            localCard = null;
            label268:
            if ((localCard == null) || ((TextUtils.isEmpty(localCard.strReMark)) && (TextUtils.isEmpty(localCard.strNick)))) {
              break label364;
            }
            if (!TextUtils.isEmpty(localCard.strReMark)) {
              break label354;
            }
          }
          label354:
          for (localObject = localCard.strNick;; localObject = localCard.strReMark)
          {
            paramString1 = (String)localObject;
            if (!TextUtils.isEmpty(localCard.strReMark)) {
              break;
            }
            this.jdField_d_of_type_Boolean = true;
            paramString1 = (String)localObject;
            break;
            localCard = paramString1.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
            break label268;
          }
          label364:
          if (paramString1 == null) {}
          for (paramString1 = null;; paramString1 = paramString1.e(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin))
          {
            if (paramString1 == null) {
              break label531;
            }
            if (TextUtils.isEmpty(paramString1.remark)) {
              break label407;
            }
            paramString1 = paramString1.remark;
            break;
          }
          label407:
          paramString1 = paramString1.name;
          this.jdField_d_of_type_Boolean = true;
          break;
          ((TextView)localObject).setText(super.getResources().getString(2131698327));
          break;
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131698328);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(false);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(anvx.a(2131700754));
      if (TextUtils.isEmpty(paramString2))
      {
        localRelativeLayout2.setVisibility(8);
        return;
      }
      localRelativeLayout2.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(false);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(false);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(anvx.a(2131700749));
      return;
      label531:
      paramString1 = "";
    }
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.jdField_b_of_type_JavaLangString = (paramString + "/?01");
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
        paramString.mLoadingDrawable = super.getResources().getDrawable(2130844907);
        paramString.mFailedDrawable = super.getResources().getDrawable(2130844907);
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
    findViewById(2131372816).setVisibility(8);
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
    this.jdField_a_of_type_Aqjm = ((aqjm)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER));
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.jdField_a_of_type_Aqjm.a(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        ThreadManager.post(new BusinessCardEditActivity.1(this), 8, null, true);
      }
      if (this.jdField_a_of_type_Int != 3)
      {
        aqjo.a(this.app, this.jdField_a_of_type_JavaLangString, false, 3);
        if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl))) {
          this.jdField_c_of_type_Int = 0;
        }
        if (this.jdField_a_of_type_Int != 2) {
          break label330;
        }
        this.jdField_d_of_type_Int = 1;
      }
    }
    for (;;)
    {
      this.app.registObserver(this.jdField_a_of_type_Aqjn);
      g();
      addObserver(this.jdField_a_of_type_Anvi);
      return;
      aqjo.a(this.app, this.jdField_a_of_type_JavaLangString, true, 3);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
      break;
      label330:
      if (this.jdField_a_of_type_Int == 3) {
        this.jdField_d_of_type_Int = 2;
      } else {
        this.jdField_d_of_type_Int = 0;
      }
    }
  }
  
  private void d(String paramString)
  {
    this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, paramString, 2131692828, 2131693181, new aqjr(this), new aqjs(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void e()
  {
    super.setContentView(2131561040);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376967));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
    }
    a();
    f();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364341));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText = ((ClearEllipsisEditText)findViewById(2131364332));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setTag("name");
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setMaxLength(96, 1);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText = ((ClearEllipsisEditText)findViewById(2131364307));
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setMaxLength(30, 2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365998));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365747));
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      c(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl);
      b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, true);
    }
    for (;;)
    {
      a(true);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null)
      {
        c(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaLangString);
        b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_JavaLangString, null, true);
      }
      else
      {
        c(null);
        b(null, null, true);
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698323);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692403);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(super.getResources().getDrawable(2130850724));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    label307:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int == 3)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698326);
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698322);
        break;
        if (this.jdField_a_of_type_Int == 3) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698326);
        }
        for (;;)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691815);
          if (this.jdField_b_of_type_Int == 2) {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(super.getResources().getDrawable(2130850724));
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131698333);
          if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo.jdField_b_of_type_JavaLangString))) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() <= 0))) {
            break label307;
          }
          if ((this.jdField_a_of_type_Int != 3) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.isEmpty()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName))) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698321);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() <= 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.size() <= 0)) {
        break label409;
      }
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.size() <= 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    return;
    label409:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void g()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new aqjt(this, new Handler(this.app.getApp().getMainLooper()));
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369278));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369231));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369262));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363684));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363703));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 9999);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_max", 1);
    startActivityForResult(localIntent, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bisy(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextSize(16.0F);
    localTextView.setHint(anvx.a(2131700770));
    localTextView.setTextColor(super.getResources().getColor(2131167026));
    localTextView.setGravity(16);
    localTextView.setBackgroundDrawable(super.getResources().getDrawable(2130850395));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.dip2px(this, 44.0F));
    localTextView.setPadding(AIOUtils.dp2px(28.0F, getResources()), 0, AIOUtils.dp2px(50.0F, getResources()), 0);
    if (paramInt == 1)
    {
      localTextView.setTag(paramString);
      localTextView.setOnClickListener(new aqkc(this));
      paramString = localLayoutParams;
    }
    for (;;)
    {
      paramLinearLayout.addView(localTextView, paramString);
      return;
      paramString = localLayoutParams;
      if (paramInt == 2)
      {
        paramString = new LinearLayout.LayoutParams(-1, -2);
        localTextView.setMinHeight(DisplayUtil.dip2px(this, 44.0F));
        localTextView.setPadding(AIOUtils.dp2px(28.0F, getResources()), AIOUtils.dp2px(12.0F, getResources()), AIOUtils.dp2px(50.0F, getResources()), AIOUtils.dp2px(10.0F, getResources()));
      }
    }
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2)
  {
    a(paramLinearLayout, paramString, paramInt1, paramInt2, false);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(44.0F, getResources()));
    Object localObject;
    if (paramInt1 != 2)
    {
      localObject = new ClearableEditText(this);
      ((EditText)localObject).setInputType(2);
      ((EditText)localObject).setSingleLine();
      ((EditText)localObject).setHint(2131698324);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130850395));
      ((EditText)localObject).setCompoundDrawablePadding(AIOUtils.dp2px(5.0F, getResources()));
      ((EditText)localObject).setPadding(AIOUtils.dp2px(28.0F, getResources()), 0, AIOUtils.dp2px(10.0F, getResources()), 0);
    }
    for (;;)
    {
      ((EditText)localObject).setText(paramString);
      ((EditText)localObject).setTextSize(16.0F);
      ((EditText)localObject).setTextColor(super.getResources().getColor(2131167026));
      ((EditText)localObject).setHintTextColor(super.getResources().getColor(2131165444));
      ((EditText)localObject).setGravity(16);
      paramLinearLayout.addView((View)localObject, localLayoutParams);
      ((EditText)localObject).addTextChangedListener(new aqke(this, paramInt2, (EditText)localObject));
      if (paramBoolean)
      {
        ((EditText)localObject).setSelection(((EditText)localObject).getText().toString().length());
        ((EditText)localObject).postDelayed(new BusinessCardEditActivity.2(this, (EditText)localObject), 100L);
      }
      return;
      localObject = new EditText(this);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130850395));
      ((EditText)localObject).setMinHeight(DisplayUtil.dip2px(this, 44.0F));
      ((EditText)localObject).setOnEditorActionListener(this);
      ((EditText)localObject).setPadding(AIOUtils.dp2px(28.0F, getResources()), AIOUtils.dp2px(12.0F, getResources()), AIOUtils.dp2px(50.0F, getResources()), AIOUtils.dp2px(10.0F, getResources()));
      ((EditText)localObject).setHint(2131698319);
    }
  }
  
  public void a(String paramString)
  {
    bkzi localbkzi = bkzi.a(this);
    localbkzi.b(2131698314);
    localbkzi.b(2131698335);
    localbkzi.c(2131690697);
    localbkzi.a(new aqjq(this, paramString, localbkzi));
    localbkzi.show();
  }
  
  public void a(String paramString, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2131561044, null);
    localView.setTag(Integer.valueOf(paramInt));
    EditText localEditText = (EditText)localView.findViewById(2131374378);
    localEditText.addTextChangedListener(new aqke(this, 15, localEditText));
    localEditText.setText(paramString);
    paramString = (ImageView)localView.findViewById(2131362194);
    paramString.setTag(Integer.valueOf(paramInt));
    paramString.setOnClickListener(new aqjw(this));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    if (paramBoolean)
    {
      j = 2;
      i = 2;
    }
    super.startActivity(AddFriendLogicActivity.a(this, i, paramString1, null, 3026, j, paramString2, null, BusinessCardEditActivity.class.getName(), setLastActivityName(), null));
    bdla.b(this.app, "CliOper", "", "", "0X80064E6", "0X80064E6", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371489));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374380));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131365530));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371483));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374182));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131365523));
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (a())
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374381).setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramBoolean) {
        a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131371489));
        this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131374380));
        this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131365530));
        if (a())
        {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131374381).setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.w("BusinessCard_EditActivity", 2, "名片备注不应该出现详情态");
          }
        }
      } while (!paramBoolean);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo == null);
    a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2) || (this.jdField_b_of_type_Int == 2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void b(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bisl == null) {
        this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Bisl.a(paramString);
      this.jdField_a_of_type_Bisl.setCancelable(false);
    } while (isFinishing());
    this.jdField_a_of_type_Bisl.show();
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver != null) {}
    try
    {
      this.app.getApp().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
      this.jdField_a_of_type_AndroidDatabaseContentObserver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
        }
      }
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null)) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      }
    } while ((paramIntent == null) || (!this.jdField_a_of_type_Boolean));
    paramIntent = (ResultRecord)paramIntent.get(0);
    paramInt2 = 0;
    while (paramInt2 < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt2);
      if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof Integer)) && (paramInt1 == ((Integer)((View)localObject).getTag()).intValue()))
      {
        localObject = (EditText)((View)localObject).findViewById(2131374378);
        if (localObject != null)
        {
          ((EditText)localObject).setText(paramIntent.uin);
          return;
          if ((!this.jdField_a_of_type_Boolean) || (!paramIntent.getBooleanExtra("delete_pic", false))) {
            break;
          }
          this.jdField_e_of_type_Boolean = true;
          c(null);
          return;
          paramIntent.putExtra("selfSet_leftViewText", getString(2131719161));
          localObject = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          startActivity((Intent)localObject);
          return;
        }
      }
      paramInt2 += 1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    d();
    e();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anvi);
    c();
    this.app.unRegistObserver(this.jdField_a_of_type_Aqjn);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceDrawable localFaceDrawable = (FaceDrawable)((WeakReference)localIterator.next()).get();
      if (localFaceDrawable != null) {
        localFaceDrawable.cancel();
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_d_of_type_Int != 0) {
      bdla.b(this.app, "CliOper", "", "", "0X8007751", "0X8007751", this.jdField_d_of_type_Int, 0, "", "", "", "");
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
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    bkxz.a(this);
    if (this.jdField_a_of_type_Boolean)
    {
      BusinessCard localBusinessCard = new BusinessCard();
      a(localBusinessCard, false);
      if (a(localBusinessCard, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
      {
        d(super.getResources().getString(2131694825));
        return true;
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (!isFinishing()))
      {
        finish();
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId)))
      {
        super.finish();
        return true;
      }
      a(false, false, false);
      return true;
    }
    super.finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onBackEvent();
      continue;
      Object localObject2;
      Object localObject1;
      if (this.jdField_a_of_type_Boolean)
      {
        bkxz.a(this);
        localObject2 = new BusinessCard();
        a((BusinessCard)localObject2, true);
        if (this.jdField_c_of_type_Boolean)
        {
          b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
          this.jdField_c_of_type_Boolean = false;
        }
        if ((this.jdField_a_of_type_Int == 2) && (this.jdField_c_of_type_JavaLangString != null))
        {
          ((aqjm)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a(((BusinessCard)localObject2).bindUin, (BusinessCard)localObject2);
          if (!isFinishing())
          {
            localObject1 = getIntent();
            this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
            ((Intent)localObject1).putExtra("has_local_remark", this.jdField_c_of_type_JavaLangString);
            setResult(-1, (Intent)localObject1);
            finish();
          }
        }
        while (this.jdField_d_of_type_Int != 0)
        {
          bdla.b(this.app, "CliOper", "", "", "0X8007754", "0X8007754", this.jdField_d_of_type_Int, 0, "", "", "", "");
          break;
          if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)) {
            a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin, getIntent().getBooleanExtra("notify_plugin", false));
          }
          if (a((BusinessCard)localObject2, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
          {
            if (!NetworkUtil.isNetSupport(this))
            {
              a(2131694305, 1);
              break;
            }
            localObject1 = Boolean.valueOf(false);
            if (this.jdField_a_of_type_Int == 3) {
              localObject1 = Boolean.valueOf(true);
            }
            if ((((BusinessCard)localObject2).cardId != null) && (((BusinessCard)localObject2).cardId.length() > 0))
            {
              aqjo.b(this.app, (BusinessCard)localObject2, ((Boolean)localObject1).booleanValue());
              b(anvx.a(2131700750));
              continue;
            }
            aqjo.a(this.app, (BusinessCard)localObject2, ((Boolean)localObject1).booleanValue());
            b(anvx.a(2131700744));
            continue;
          }
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (!isFinishing())) {
            finish();
          } else {
            a(false, false, false);
          }
        }
      }
      a(true, false, true);
      bdla.b(this.app, "CliOper", "", "", "0X80064E2", "0X80064E2", 0, 0, "", "", "", "");
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null))
      {
        this.jdField_f_of_type_Boolean = true;
        requestPermissions(new aqjp(this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        continue;
        a(this.jdField_b_of_type_AndroidWidgetLinearLayout, null, 1, 15);
        this.jdField_e_of_type_Int += 1;
        if (this.jdField_e_of_type_Int >= 3) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_d_of_type_Int != 0)
        {
          bdla.b(this.app, "CliOper", "", "", "0X8007752", "0X8007752", this.jdField_d_of_type_Int, 0, "", "", "", "");
          continue;
          a(null, this.jdField_f_of_type_Int);
          this.jdField_f_of_type_Int += 1;
          if (this.jdField_f_of_type_Int >= 2)
          {
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
            continue;
            a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 2, 150);
            this.jdField_g_of_type_Int += 1;
            if (this.jdField_g_of_type_Int >= 2)
            {
              this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
              continue;
              localObject1 = new Intent(this, CardPicGalleryActivity.class);
              localObject2 = new ArrayList();
              if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
                ((ArrayList)localObject2).add(this.jdField_b_of_type_JavaLangString);
              }
              ((Intent)localObject1).putStringArrayListExtra("business_card_pics", (ArrayList)localObject2);
              ((Intent)localObject1).putExtra("is_edit_mode", this.jdField_a_of_type_Boolean);
              if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 3)) {
                ((Intent)localObject1).putExtra("is_from_profile", true);
              }
              startActivityForResult((Intent)localObject1, 11);
              overridePendingTransition(2130772308, 0);
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent == null) {}
    while (paramKeyEvent.getKeyCode() != 66) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity
 * JD-Core Version:    0.7.0.1
 */