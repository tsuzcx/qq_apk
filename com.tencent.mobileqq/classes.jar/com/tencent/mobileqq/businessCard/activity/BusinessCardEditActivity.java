package com.tencent.mobileqq.businessCard.activity;

import abts;
import abtu;
import abtv;
import abtw;
import abtx;
import abty;
import abtz;
import abua;
import abub;
import abuc;
import abud;
import abue;
import abuf;
import abug;
import abuh;
import abui;
import abuj;
import abuk;
import abul;
import abum;
import abun;
import abuo;
import abup;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
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
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BusinessCardEditActivity
  extends BaseActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  public int a;
  abup jdField_a_of_type_Abup;
  public Dialog a;
  Intent jdField_a_of_type_AndroidContentIntent;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new abuf(this);
  public BusinessCardManager a;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new abug(this);
  public BusinessCard a;
  public CardOCRInfo a;
  public ClearEllipsisEditText a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String a;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ClearEllipsisEditText jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  public int c;
  Button jdField_c_of_type_AndroidWidgetButton;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  public int d;
  Button jdField_d_of_type_AndroidWidgetButton;
  public LinearLayout d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 1;
  LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 1;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 1;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  
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
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("bind_phone_num");
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_c_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        localObject2 = paramBusinessCard.mobilesNum.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_c_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramBusinessCard.mobilesNum.isEmpty())) {
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1);
      }
      if (!a())
      {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
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
            localObject5 = LayoutInflater.from(this).inflate(2130970274, null);
            localObject7 = (ImageView)((View)localObject5).findViewById(2131362724);
            localObject8 = FaceDrawable.a(this.app, 1, (String)localObject6);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject8));
            ((ImageView)localObject7).setBackgroundDrawable((Drawable)localObject8);
            ((TextView)((View)localObject5).findViewById(2131369189)).setText(ContactUtils.n(this.app, (String)localObject6));
            ((TextView)((View)localObject5).findViewById(2131369882)).setText((CharSequence)localObject6);
            ((ImageView)((View)localObject5).findViewById(2131369884)).setVisibility(0);
            localObject7 = new abuo(this);
            ((abuo)localObject7).jdField_a_of_type_JavaLangString = ((String)localObject6);
            ((abuo)localObject7).jdField_b_of_type_JavaLangString = ContactUtils.n(this.app, (String)localObject6);
            ((abuo)localObject7).jdField_a_of_type_Boolean = false;
            ((View)localObject5).setTag(localObject7);
            ((View)localObject5).setOnClickListener(new abuj(this));
            localObject6 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
          }
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (String)((Iterator)localObject3).next();
            localObject4 = LayoutInflater.from(this).inflate(2130970274, null);
            localObject6 = (ImageView)((View)localObject4).findViewById(2131362724);
            localObject7 = FaceDrawable.a(this.app, 1, (String)localObject5);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject7));
            ((ImageView)localObject6).setBackgroundDrawable((Drawable)localObject7);
            localObject6 = (TextView)((View)localObject4).findViewById(2131369189);
            ((TextView)((View)localObject4).findViewById(2131369882)).setText((CharSequence)localObject5);
            localObject7 = (Button)((View)localObject4).findViewById(2131369883);
            ((Button)localObject7).setVisibility(0);
            localObject8 = new abuo(this);
            ((abuo)localObject8).jdField_a_of_type_JavaLangString = ((String)localObject5);
            ((abuo)localObject8).jdField_b_of_type_JavaLangString = ContactUtils.c(this.app, (String)localObject5, true);
            ((abuo)localObject8).jdField_a_of_type_Boolean = false;
            ((View)localObject4).setTag(localObject8);
            ((TextView)localObject6).setText(((abuo)localObject8).jdField_b_of_type_JavaLangString);
            ((Button)localObject7).setTag(localObject8);
            ((Button)localObject7).setOnClickListener(new abuk(this));
            localObject5 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject7 = (String)((Iterator)localObject2).next();
            localObject3 = LayoutInflater.from(this).inflate(2130970274, null);
            localObject4 = (ImageView)((View)localObject3).findViewById(2131362724);
            localObject5 = (TextView)((View)localObject3).findViewById(2131369189);
            localObject8 = (TextView)((View)localObject3).findViewById(2131369882);
            localObject6 = (Button)((View)localObject3).findViewById(2131369883);
            ((Button)localObject6).setVisibility(0);
            ((TextView)localObject8).setText((CharSequence)localObject7);
            localObject8 = paramBusinessCard.getMobileInfoByMobile((String)localObject7);
            abuo localabuo = new abuo(this);
            localabuo.jdField_a_of_type_Boolean = true;
            if (localObject8 != null)
            {
              localObject7 = FaceDrawable.a(this.app, 11, ((CardMobileInfo)localObject8).d);
              this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject7));
              ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject7);
              localabuo.jdField_a_of_type_JavaLangString = ((CardMobileInfo)localObject8).d;
            }
            for (localabuo.jdField_b_of_type_JavaLangString = ((CardMobileInfo)localObject8).jdField_c_of_type_JavaLangString;; localabuo.jdField_b_of_type_JavaLangString = ((String)localObject7))
            {
              ((View)localObject3).setTag(localabuo);
              ((TextView)localObject5).setText(localabuo.jdField_b_of_type_JavaLangString);
              ((Button)localObject6).setTag(localabuo);
              ((Button)localObject6).setOnClickListener(new abul(this));
              localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
              this.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
              break;
              localabuo.jdField_a_of_type_JavaLangString = ((String)localObject7);
            }
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            a(this.jdField_d_of_type_AndroidWidgetLinearLayout, (String)localObject2, 0);
          }
        }
        a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 0);
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localObject1 = (LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369846);
      Object localObject2 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369849);
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
        a(this.jdField_e_of_type_AndroidWidgetLinearLayout, ((StringBuilder)localObject1).toString(), 2);
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
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        i = 0;
        while (i < paramBusinessCard.mobilesNum.size())
        {
          paramCardOCRInfo = (String)paramBusinessCard.mobilesNum.get(i);
          a(this.jdField_c_of_type_AndroidWidgetLinearLayout, paramCardOCRInfo, 1, 15);
          i += 1;
        }
        this.jdField_e_of_type_Int = paramBusinessCard.mobilesNum.size();
        if (this.jdField_e_of_type_Int >= 3) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
        if (paramBusinessCard.uinInfos.isEmpty()) {
          break label314;
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
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1, 15);
        this.jdField_e_of_type_Int = 1;
      }
      this.jdField_f_of_type_Int = paramBusinessCard.uinInfos.size();
      if (this.jdField_f_of_type_Int >= 2) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
        if (paramBusinessCard.descs.isEmpty()) {
          break label375;
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
        label314:
        a(null, 0);
        this.jdField_f_of_type_Int = 1;
      }
      a(this.jdField_e_of_type_AndroidWidgetLinearLayout, paramCardOCRInfo.toString(), 2, 150);
      this.jdField_g_of_type_Int = paramBusinessCard.descs.size();
      if (this.jdField_g_of_type_Int >= 2) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    label375:
    while (paramCardOCRInfo == null)
    {
      Iterator localIterator;
      String str;
      return;
      a(this.jdField_e_of_type_AndroidWidgetLinearLayout, null, 2, 150);
      this.jdField_g_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      i = 0;
      while (i < paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size())
      {
        paramBusinessCard = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(i);
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, paramBusinessCard, 1, 15);
        i += 1;
      }
    }
    for (this.jdField_e_of_type_Int = paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size();; this.jdField_e_of_type_Int = 1)
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (paramCardOCRInfo.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label597;
      }
      i = k;
      while (i < paramCardOCRInfo.jdField_a_of_type_JavaUtilList.size())
      {
        a((String)paramCardOCRInfo.jdField_a_of_type_JavaUtilList.get(i), i);
        i += 1;
      }
      a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1, 15);
    }
    for (this.jdField_f_of_type_Int = paramCardOCRInfo.jdField_a_of_type_JavaUtilList.size();; this.jdField_f_of_type_Int = 1)
    {
      this.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
      a(this.jdField_e_of_type_AndroidWidgetLinearLayout, null, 2, 150);
      this.jdField_g_of_type_Int = 1;
      return;
      label597:
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
      while (i < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject = ((EditText)this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getText().toString().trim();
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
    while (i < this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject instanceof RelativeLayout))
      {
        localObject = (EditText)((View)localObject).findViewById(2131369880);
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
    while (i < this.jdField_e_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = ((EditText)this.jdField_e_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getText().toString().trim();
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
      ReportController.b(this.app, "CliOper", "", "", "0X80064E7", "0X80064E7", 0, 0, (String)localObject, "", "", "");
      localObject = "0";
      if (TextUtils.isEmpty(paramBusinessCard.company)) {
        localObject = "1";
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80064E8", "0X80064E8", 0, 0, (String)localObject, "", "", "");
      localObject = paramBusinessCard.qqNum.size() + "";
      ReportController.b(this.app, "CliOper", "", "", "0X80064E9", "0X80064E9", 0, 0, (String)localObject, "", "", "");
      paramBusinessCard = paramBusinessCard.descs.size() + "";
      ReportController.b(this.app, "CliOper", "", "", "0X80064EA", "0X80064EA", 0, 0, paramBusinessCard, "", "", "");
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
          ReportController.b(this.app, "CliOper", "", "", "0X8007749", "0X8007749", this.jdField_d_of_type_Int, 0, "", "", "", "");
          localObject = "1";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80064EF", "0X80064EF", 0, 0, (String)localObject, "", "", "");
        localObject = "0";
        if (!TextUtils.isEmpty(paramBusinessCard.company))
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800774A", "0X800774A", this.jdField_d_of_type_Int, 0, "", "", "", "");
          localObject = "1";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80064F0", "0X80064F0", 0, 0, (String)localObject, "", "", "");
        localObject = paramBusinessCard.qqNum.size() + "";
        ReportController.b(this.app, "CliOper", "", "", "0X80064F1", "0X80064F1", 0, 0, (String)localObject, "", "", "");
        int j = paramBusinessCard.descs.size();
        i = 0;
        while (i < j)
        {
          if (!TextUtils.isEmpty((CharSequence)paramBusinessCard.descs.get(i))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774E", "0X800774E", this.jdField_d_of_type_Int, 0, "", "", "", "");
          }
          i += 1;
        }
        localObject = paramBusinessCard.descs.size() + "";
        ReportController.b(this.app, "CliOper", "", "", "0X80064F2", "0X80064F2", 0, 0, (String)localObject, "", "", "");
        j = paramBusinessCard.mobilesNum.size();
        i = 0;
        while (i < j)
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
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Object localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("bind_phone_num");
      Object localObject2;
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_c_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if (!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        localObject2 = paramCardOCRInfo.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_c_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty())) {
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1);
      }
      if (!a())
      {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
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
            localObject3 = LayoutInflater.from(this).inflate(2130970274, null);
            localObject5 = (ImageView)((View)localObject3).findViewById(2131362724);
            localObject6 = FaceDrawable.a(this.app, 1, (String)localObject4);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject6));
            ((ImageView)localObject5).setBackgroundDrawable((Drawable)localObject6);
            ((TextView)((View)localObject3).findViewById(2131369189)).setText(ContactUtils.n(this.app, (String)localObject4));
            ((TextView)((View)localObject3).findViewById(2131369882)).setText((CharSequence)localObject4);
            ((ImageView)((View)localObject3).findViewById(2131369884)).setVisibility(0);
            localObject5 = new abuo(this);
            ((abuo)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject4);
            ((abuo)localObject5).jdField_b_of_type_JavaLangString = ContactUtils.n(this.app, (String)localObject4);
            ((abuo)localObject5).jdField_a_of_type_Boolean = false;
            ((View)localObject3).setTag(localObject5);
            ((View)localObject3).setOnClickListener(new abuh(this));
            localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject2 = LayoutInflater.from(this).inflate(2130970274, null);
            localObject4 = (ImageView)((View)localObject2).findViewById(2131362724);
            localObject5 = FaceDrawable.a(this.app, 1, (String)localObject3);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject5));
            ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject5);
            localObject4 = (TextView)((View)localObject2).findViewById(2131369189);
            ((TextView)((View)localObject2).findViewById(2131369882)).setText((CharSequence)localObject3);
            localObject5 = (Button)((View)localObject2).findViewById(2131369883);
            ((Button)localObject5).setVisibility(0);
            localObject6 = new abuo(this);
            ((abuo)localObject6).jdField_a_of_type_JavaLangString = ((String)localObject3);
            ((abuo)localObject6).jdField_b_of_type_JavaLangString = ContactUtils.c(this.app, (String)localObject3, true);
            ((abuo)localObject6).jdField_a_of_type_Boolean = false;
            ((View)localObject2).setTag(localObject6);
            ((TextView)localObject4).setText(((abuo)localObject6).jdField_b_of_type_JavaLangString);
            ((Button)localObject5).setTag(localObject6);
            ((Button)localObject5).setOnClickListener(new abui(this));
            localObject3 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          paramCardOCRInfo = paramCardOCRInfo.iterator();
          while (paramCardOCRInfo.hasNext())
          {
            localObject1 = (String)paramCardOCRInfo.next();
            a(this.jdField_d_of_type_AndroidWidgetLinearLayout, (String)localObject1, 0);
          }
        }
        a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 0);
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
      paramCardOCRInfo = (LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369846);
      localObject1 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369849);
      paramCardOCRInfo.setVisibility(8);
      ((View)localObject1).setVisibility(8);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, getString(2131437135, new Object[] { paramString1, paramString2 }), 2131433026, 2131433025, new abtw(this), new abtx(this, paramString2));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void a(String paramString1, String paramString2, List paramList)
  {
    ContentValues localContentValues = new ContentValues();
    Uri localUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues);
    if ((localUri == null) || (ContentUris.parseId(localUri) <= 0L))
    {
      runOnUiThread(new abuc(this));
      return;
    }
    long l = ContentUris.parseId(localUri);
    this.jdField_f_of_type_Boolean = true;
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
  }
  
  private void a(List paramList, LinearLayout paramLinearLayout, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList;
    int i;
    Object localObject;
    if (paramList.size() > 0)
    {
      localArrayList = new ArrayList();
      i = 0;
      if (i < paramLinearLayout.getChildCount())
      {
        localObject = paramLinearLayout.getChildAt(i);
        if ((localObject instanceof RelativeLayout)) {
          localObject = (EditText)((View)localObject).findViewById(2131369880);
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((EditText)localObject).getText().toString().trim();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
      break;
      if ((localObject instanceof EditText))
      {
        localObject = (EditText)localObject;
        continue;
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localArrayList.add(localObject);
          }
        }
        if (paramInt1 == 1) {}
        for (int j = 3;; j = 2)
        {
          if (localArrayList.size() > j) {}
          for (i = localArrayList.size() - j;; i = 0)
          {
            if (localArrayList.size() > 0) {
              paramLinearLayout.removeAllViews();
            }
            int k = i;
            int m = 0;
            if (k < localArrayList.size())
            {
              paramList = (String)localArrayList.get(k);
              if (paramInt1 != 0) {
                a(paramLinearLayout, paramList, paramInt1, paramInt2);
              }
              for (;;)
              {
                m += 1;
                k += 1;
                break;
                a(paramList, k - i);
              }
            }
            paramList = this.jdField_e_of_type_AndroidWidgetTextView;
            if (paramInt1 == 0) {
              paramList = this.jdField_f_of_type_AndroidWidgetTextView;
            }
            while (m == j)
            {
              paramList.setVisibility(8);
              return;
              if (paramInt1 == 2) {
                paramList = this.jdField_g_of_type_AndroidWidgetTextView;
              }
            }
            if ((paramInt1 == 0) && (a()))
            {
              paramList.setVisibility(8);
              return;
            }
            paramList.setVisibility(0);
            return;
          }
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    g();
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
  
  private boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) && ((((FriendsManager)this.app.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardType == 1))) {
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
      while (i < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        String str = ((EditText)this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getText().toString().trim();
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
        BusinessCardUtils.a(this.app.getCurrentAccountUin(), i);
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
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131369851);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131369853);
    Object localObject = (TextView)findViewById(2131365455);
    if (this.jdField_a_of_type_Int == 2)
    {
      ((TextView)localObject).setText(super.getResources().getString(2131433508));
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
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131437104);
        }
        for (;;)
        {
          this.jdField_a_of_type_Abup = new abup(this, 96, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText, 1);
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.addTextChangedListener(this.jdField_a_of_type_Abup);
          localRelativeLayout2.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(true);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(true);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131437106);
          paramString1 = new abup(this, 30, this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.addTextChangedListener(paramString1);
          return;
          if (this.jdField_c_of_type_JavaLangString != null)
          {
            paramString1 = this.jdField_c_of_type_JavaLangString;
            break;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin))) {
            break label524;
          }
          paramString1 = (FriendsManager)this.app.getManager(50);
          Card localCard;
          if (paramString1 == null)
          {
            localCard = null;
            label267:
            if ((localCard == null) || ((TextUtils.isEmpty(localCard.strReMark)) && (TextUtils.isEmpty(localCard.strNick)))) {
              break label363;
            }
            if (!TextUtils.isEmpty(localCard.strReMark)) {
              break label353;
            }
          }
          label353:
          for (localObject = localCard.strNick;; localObject = localCard.strReMark)
          {
            paramString1 = (String)localObject;
            if (!TextUtils.isEmpty(localCard.strReMark)) {
              break;
            }
            this.jdField_d_of_type_Boolean = true;
            paramString1 = (String)localObject;
            break;
            localCard = paramString1.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
            break label267;
          }
          label363:
          if (paramString1 == null) {}
          for (paramString1 = null;; paramString1 = paramString1.c(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin))
          {
            if (paramString1 == null) {
              break label524;
            }
            if (TextUtils.isEmpty(paramString1.remark)) {
              break label406;
            }
            paramString1 = paramString1.remark;
            break;
          }
          label406:
          paramString1 = paramString1.name;
          this.jdField_d_of_type_Boolean = true;
          break;
          ((TextView)localObject).setText(super.getResources().getString(2131437102));
          break;
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131437103);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(false);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint("未添加");
      if (TextUtils.isEmpty(paramString2))
      {
        localRelativeLayout2.setVisibility(8);
        return;
      }
      localRelativeLayout2.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(false);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(false);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint("未添加");
      return;
      label524:
      paramString1 = "";
    }
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.jdField_b_of_type_JavaLangString = (paramString + "/?01");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
        paramString.mLoadingDrawable = super.getResources().getDrawable(2130842370);
        paramString.mFailedDrawable = super.getResources().getDrawable(2130842370);
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
    findViewById(2131369858).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131437130));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void d(String paramString)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, super.getResources().getString(2131437119), 2131433029, 2131433030, new abty(this), new abtz(this, paramString));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentIntent = super.getIntent();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("mode_type", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_edit_mode", false);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("cur_card_id");
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("cur_card_body"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = ((CardOCRInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("cur_ocr_info"));
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("source_activity", 0);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("finish_immedia", false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_need_report_edit", false);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("has_local_remark");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(111));
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        ThreadManager.post(new abts(this), 8, null, true);
      }
      if (this.jdField_a_of_type_Int != 3)
      {
        BusinessCardServlet.a(this.app, this.jdField_a_of_type_JavaLangString, false, 3);
        if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl))) {
          this.jdField_c_of_type_Int = 0;
        }
        if (this.jdField_a_of_type_Int != 2) {
          break label344;
        }
        this.jdField_d_of_type_Int = 1;
      }
    }
    for (;;)
    {
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
      h();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      return;
      BusinessCardServlet.a(this.app, this.jdField_a_of_type_JavaLangString, true, 3);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
      break;
      label344:
      if (this.jdField_a_of_type_Int == 3) {
        this.jdField_d_of_type_Int = 2;
      } else {
        this.jdField_d_of_type_Int = 0;
      }
    }
  }
  
  private void e(String paramString)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 2131436313, 2131435770, new abua(this), new abub(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void f()
  {
    super.setContentView(2130970266);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362716));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
    }
    a();
    g();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369857));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369859));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText = ((ClearEllipsisEditText)findViewById(2131369852));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setTag("name");
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setMaxLength(96, 1);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText = ((ClearEllipsisEditText)findViewById(2131369855));
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setMaxLength(30, 2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368360));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369856));
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
  
  private void f(String paramString)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a().trim();
    FriendsManager localFriendsManager;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localFriendsManager = (FriendsManager)this.app.getManager(50);
      if (localFriendsManager == null)
      {
        localObject1 = null;
        if ((localObject1 == null) || (TextUtils.isEmpty(((Card)localObject1).strNick))) {
          break label142;
        }
        localObject1 = ((Card)localObject1).strNick;
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Abup.jdField_b_of_type_Boolean) && (((String)localObject2).equals(localObject1)) && (this.jdField_d_of_type_Boolean)) {}
      for (localObject1 = "";; localObject1 = localObject2)
      {
        localObject2 = (FriendListHandler)this.app.a(1);
        if (localObject2 != null)
        {
          ((FriendListHandler)localObject2).a(paramString, (String)localObject1, false);
          localObject1 = new QZoneDistributedAppCtrl.Control();
          ((QZoneDistributedAppCtrl.Control)localObject1).jdField_a_of_type_Int = 5;
          QZoneDistributedAppCtrl.a(paramString).a((QZoneDistributedAppCtrl.Control)localObject1);
        }
        return;
        localObject1 = localFriendsManager.a(paramString);
        break;
        label142:
        if (localFriendsManager == null) {}
        for (localObject1 = null;; localObject1 = localFriendsManager.c(paramString))
        {
          if (localObject1 == null) {
            break label176;
          }
          localObject1 = ((Friends)localObject1).name;
          break;
        }
      }
      label176:
      localObject1 = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437095);
        if (this.jdField_a_of_type_Int != 4) {
          break label172;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        label42:
        if (this.jdField_a_of_type_Int != 3) {
          break label193;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText("编辑");
        label60:
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(super.getResources().getDrawable(2130846346));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
          break label286;
        }
        if (this.jdField_a_of_type_Int != 4) {
          break label227;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetButton.setText(2131437121);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    label172:
    label193:
    label227:
    label619:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int == 3)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437091);
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437097);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131434550);
        break label42;
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText("更多");
          break label60;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText("取消");
        break label60;
        if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId)))
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetButton.setText(2131437120);
          this.jdField_c_of_type_AndroidWidgetButton.setText(2131437118);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
        if (this.jdField_a_of_type_Int == 3)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437091);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131434568);
          if (this.jdField_b_of_type_Int == 2) {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433712);
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(super.getResources().getDrawable(2130846346));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131437124);
          this.jdField_b_of_type_AndroidWidgetButton.setText(2131437123);
          if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo.jdField_b_of_type_JavaLangString))) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() <= 0))) {
            break label619;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (this.jdField_b_of_type_Int != 2) {
            break label528;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_Int != 3) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.isEmpty()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName))) {
            break label595;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437096);
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo.jdField_b_of_type_JavaLangString)))
          {
            this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
            if (this.jdField_a_of_type_Int == 3) {
              this.jdField_b_of_type_AndroidWidgetButton.setText(2131437122);
            }
          }
          else
          {
            this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() <= 0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.size() <= 0)) {
        break label738;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaUtilList.size() <= 0);
    label286:
    label595:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    label528:
    return;
    label738:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new abud(this, new Handler(this.app.getApp().getMainLooper()));
      this.app.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
      }
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  String a(String paramString)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str2)))
    {
      String str1 = paramString;
      if (this.jdField_a_of_type_Int == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName = paramString;
        }
        str1 = paramString;
        if (!TextUtils.isEmpty(str2))
        {
          a(str2, paramString);
          str1 = str2;
        }
      }
      return str1;
    }
    return str2;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363400));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363262));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363447));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369863));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369864));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131369865));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369860));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131369861));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131369862));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
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
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextSize(16.0F);
    localTextView.setHint("未添加");
    localTextView.setTextColor(super.getResources().getColor(2131494220));
    localTextView.setGravity(16);
    localTextView.setBackgroundDrawable(super.getResources().getDrawable(2130846103));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 44.0F));
    localTextView.setPadding(AIOUtils.a(28.0F, getResources()), 0, AIOUtils.a(50.0F, getResources()), 0);
    if (paramInt == 1)
    {
      localTextView.setTag(paramString);
      localTextView.setOnClickListener(new abum(this));
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
        localTextView.setMinHeight(DisplayUtil.a(this, 44.0F));
        localTextView.setPadding(AIOUtils.a(28.0F, getResources()), AIOUtils.a(12.0F, getResources()), AIOUtils.a(50.0F, getResources()), AIOUtils.a(10.0F, getResources()));
      }
    }
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(44.0F, getResources()));
    Object localObject;
    if (paramInt1 != 2)
    {
      localObject = new ClearableEditText(this);
      ((EditText)localObject).setInputType(2);
      ((EditText)localObject).setSingleLine();
      ((EditText)localObject).setHint(2131437108);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130846103));
      ((EditText)localObject).setCompoundDrawablePadding(AIOUtils.a(5.0F, getResources()));
      ((EditText)localObject).setPadding(AIOUtils.a(28.0F, getResources()), 0, AIOUtils.a(10.0F, getResources()), 0);
    }
    for (;;)
    {
      ((EditText)localObject).setText(paramString);
      ((EditText)localObject).setTextSize(16.0F);
      ((EditText)localObject).setTextColor(super.getResources().getColor(2131494220));
      ((EditText)localObject).setHintTextColor(super.getResources().getColor(2131493254));
      ((EditText)localObject).setGravity(16);
      paramLinearLayout.addView((View)localObject, localLayoutParams);
      ((EditText)localObject).addTextChangedListener(new abup(this, paramInt2, (EditText)localObject));
      return;
      localObject = new EditText(this);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130846103));
      ((EditText)localObject).setMinHeight(DisplayUtil.a(this, 44.0F));
      ((EditText)localObject).setOnEditorActionListener(this);
      ((EditText)localObject).setPadding(AIOUtils.a(28.0F, getResources()), AIOUtils.a(12.0F, getResources()), AIOUtils.a(50.0F, getResources()), AIOUtils.a(10.0F, getResources()));
      ((EditText)localObject).setHint(2131437114);
    }
  }
  
  public void a(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.b(2131437128);
    localActionSheet.b(2131437129);
    localActionSheet.c(2131433029);
    localActionSheet.a(new abtv(this, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(String paramString, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2130970273, null);
    localView.setTag(Integer.valueOf(paramInt));
    EditText localEditText = (EditText)localView.findViewById(2131369880);
    localEditText.addTextChangedListener(new abup(this, 15, localEditText));
    localEditText.setText(paramString);
    paramString = (ImageView)localView.findViewById(2131369881);
    paramString.setTag(Integer.valueOf(paramInt));
    paramString.setOnClickListener(new abue(this));
    this.jdField_d_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    if (paramBoolean)
    {
      j = 0;
      i = 2;
    }
    super.startActivity(AddFriendLogicActivity.a(this, i, paramString1, null, 3026, j, paramString2, null, BusinessCardEditActivity.class.getName(), setLastActivityName(), null));
    ReportController.b(this.app, "CliOper", "", "", "0X80064E6", "0X80064E6", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369838));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369843));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369848));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369867));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369869));
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369871));
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (a())
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369841).setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
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
        this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369838));
        this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369843));
        this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369848));
        if (a())
        {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131369841).setVisibility(8);
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
  
  void b()
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.b(2131437098);
    localActionSheet.b(2131437101);
    if (getIntent().getIntExtra("source_activity", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_Int != 2) || (this.jdField_d_of_type_Int != 0)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8007753", "0X8007753", this.jdField_d_of_type_Int, 0, "", "", "", "");
      }
      localActionSheet.c(2131433029);
      localActionSheet.a(new abtu(this, bool, localActionSheet));
      localActionSheet.show();
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    } while (isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void d()
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
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
    paramInt2 = i;
    while (paramInt2 < this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject = this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt2);
      if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof Integer)) && (paramInt1 == ((Integer)((View)localObject).getTag()).intValue()))
      {
        localObject = (EditText)((View)localObject).findViewById(2131369880);
        if (localObject != null)
        {
          ((EditText)localObject).setText(paramIntent.jdField_a_of_type_JavaLangString);
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          localObject = (CardOCRInfo)paramIntent.getParcelableExtra("extra_return_ocr_info");
          if (localObject != null)
          {
            if (this.jdField_c_of_type_Int == -1) {
              this.jdField_c_of_type_Int = 1;
            }
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = ((CardOCRInfo)localObject);
            str1 = a(((CardOCRInfo)localObject).jdField_a_of_type_JavaLangString);
            String str2 = this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
            c(((CardOCRInfo)localObject).jdField_b_of_type_JavaLangString);
            b(str1, str2, false);
            a(((CardOCRInfo)localObject).jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_AndroidWidgetLinearLayout, 1, 15);
            a(((CardOCRInfo)localObject).jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_AndroidWidgetLinearLayout, 0, 15);
            this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("extra_need_report_edit", false);
            this.jdField_e_of_type_Boolean = false;
            return;
          }
          if (!paramIntent.getBooleanExtra("delete_pic", false)) {
            break;
          }
          this.jdField_e_of_type_Boolean = true;
          c(null);
          return;
          localObject = (BusinessCard)paramIntent.getParcelableExtra("Extra_Result_Data");
          if ((localObject == null) || (!this.jdField_a_of_type_Boolean)) {
            break;
          }
          String str1 = a(((BusinessCard)localObject).cardName);
          paramIntent = this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
          if (!TextUtils.isEmpty(((BusinessCard)localObject).company)) {
            paramIntent = ((BusinessCard)localObject).company;
          }
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = ((BusinessCard)localObject).OCRInfo;
          if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId = ((BusinessCard)localObject).cardId;
            this.jdField_a_of_type_JavaLangString = ((BusinessCard)localObject).cardId;
          }
          if (!TextUtils.isEmpty(((BusinessCard)localObject).bindUin)) {
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(((BusinessCard)localObject).bindUin);
          }
          c(((BusinessCard)localObject).picUrl);
          b(str1, paramIntent, false);
          a(((BusinessCard)localObject).mobilesNum, this.jdField_c_of_type_AndroidWidgetLinearLayout, 1, 15);
          a(((BusinessCard)localObject).qqNum, this.jdField_d_of_type_AndroidWidgetLinearLayout, 0, 15);
          a(((BusinessCard)localObject).descs, this.jdField_e_of_type_AndroidWidgetLinearLayout, 2, 150);
          a(2131437132, 2);
          return;
          paramIntent.putExtra("selfSet_leftViewText", getString(2131433311));
          localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          startActivity((Intent)localObject);
          return;
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    e();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    d();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceDrawable localFaceDrawable = (FaceDrawable)((WeakReference)localIterator.next()).get();
      if (localFaceDrawable != null) {
        localFaceDrawable.a();
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      Intent localIntent = new Intent(this, FlowCameraPhotoActivity.class);
      localIntent.putExtra("is_upload_photo", true);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramIntent);
      localIntent.putExtra("extra_return_result", true);
      startActivityForResult(localIntent, 10);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_f_of_type_Boolean = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_d_of_type_Int != 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X8007751", "0X8007751", this.jdField_d_of_type_Int, 0, "", "", "", "");
    }
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
        e(super.getResources().getString(2131437547));
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
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131363262: 
    case 2131363447: 
    case 2131369864: 
      do
      {
        for (;;)
        {
          return;
          onBackEvent();
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          InputMethodUtil.a(this);
          localObject1 = new BusinessCard();
          a((BusinessCard)localObject1, true);
          if (this.jdField_c_of_type_Boolean)
          {
            b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
            this.jdField_c_of_type_Boolean = false;
          }
          if ((this.jdField_a_of_type_Int == 2) && (this.jdField_c_of_type_JavaLangString != null))
          {
            ((BusinessCardManager)this.app.getManager(111)).a(((BusinessCard)localObject1).bindUin, (BusinessCard)localObject1);
            if (!isFinishing())
            {
              paramView = getIntent();
              this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.a();
              paramView.putExtra("has_local_remark", this.jdField_c_of_type_JavaLangString);
              setResult(-1, paramView);
              finish();
            }
          }
          while (this.jdField_d_of_type_Int != 0)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8007754", "0X8007754", this.jdField_d_of_type_Int, 0, "", "", "", "");
            return;
            if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)) {
              f(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
            }
            if (a((BusinessCard)localObject1, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
            {
              if (!NetworkUtil.d(this))
              {
                a(2131434629, 1);
                return;
              }
              paramView = Boolean.valueOf(false);
              if (this.jdField_a_of_type_Int == 3) {
                paramView = Boolean.valueOf(true);
              }
              if ((((BusinessCard)localObject1).cardId != null) && (((BusinessCard)localObject1).cardId.length() > 0))
              {
                BusinessCardServlet.b(this.app, (BusinessCard)localObject1, paramView.booleanValue());
                b("修改名片...");
              }
              else
              {
                BusinessCardServlet.a(this.app, (BusinessCard)localObject1, paramView.booleanValue());
                b("创建名片...");
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
        }
        a(true, false, true);
        ReportController.b(this.app, "CliOper", "", "", "0X80064E2", "0X80064E2", 0, 0, "", "", "", "");
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo == null));
      ThreadManager.post(new abun(this), 8, null, true);
      return;
    case 2131369865: 
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo == null)) {
        break;
      }
    }
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo; paramView != null; paramView = null)
    {
      if (paramView.jdField_a_of_type_JavaLangString == null) {
        paramView.jdField_a_of_type_JavaLangString = "";
      }
      if ((paramView.jdField_b_of_type_JavaUtilList != null) && (paramView.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        localObject1 = (String)paramView.jdField_b_of_type_JavaUtilList.get(0);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      for (;;)
      {
        Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
        Object localObject3 = "url=" + paramView.jdField_b_of_type_JavaLangString + ";name=" + paramView.jdField_a_of_type_JavaLangString + ";phone=" + (String)localObject1;
        localObject2 = ((AbsShareMsg.Builder)localObject2).b(73).a(getString(2131437138, new Object[] { paramView.jdField_a_of_type_JavaLangString })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).b(getResources().getString(2131437139)).a();
        localObject3 = new StructMsgItemLayoutDefault();
        ((AbsStructMsgItem)localObject3).b(1);
        ((AbsStructMsgItem)localObject3).a(super.getString(2131437137));
        StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
        localStructMsgItemLayout2.b(3);
        localStructMsgItemLayout2.a(new StructMsgItemCover(paramView.jdField_b_of_type_JavaLangString + "/?02"));
        localStructMsgItemLayout2.a(new StructMsgItemTitle(paramView.jdField_a_of_type_JavaLangString));
        localStructMsgItemLayout2.a(new StructMsgItemSummary((String)localObject1));
        ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
        ((AbsShareMsg)localObject2).addItem(localStructMsgItemLayout2);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("req_type", 5);
        ((Bundle)localObject1).putString("image_url", paramView.jdField_b_of_type_JavaLangString);
        localObject1 = (StructMsgForImageShare)StructMsgFactory.a((Bundle)localObject1);
        BusinessCardUtils.a(paramView.jdField_b_of_type_JavaLangString);
        paramView = new Bundle();
        paramView.putInt("forward_type", 20);
        paramView.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
        paramView.putByteArray("struct_msg_show_in_dialog", ((StructMsgForImageShare)localObject1).getBytes());
        paramView.putBoolean("k_dataline", false);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras(paramView);
        ForwardBaseOption.a(this, (Intent)localObject1, 21);
        ReportController.b(this.app, "CliOper", "", "", "0X80064E5", "0X80064E5", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_Int == 4)
        {
          InputMethodUtil.a(this);
          paramView = new BusinessCard();
          a(paramView, true);
          if (!NetworkUtil.d(this))
          {
            a(2131434629, 1);
            return;
          }
          BusinessCardServlet.a(this.app, paramView, false);
          b("创建名片...");
          return;
        }
        paramView = new Intent(getActivity(), FlowCameraPhotoActivity.class);
        paramView.putExtra("extra_return_result", true);
        startActivityForResult(paramView, 10);
        return;
        localObject1 = this.jdField_a_of_type_JavaLangString;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          paramView = (View)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
          }
        }
        if (paramView == null) {
          break;
        }
        d(paramView);
        return;
        if (!this.jdField_a_of_type_Boolean) {
          a(true, false, true);
        }
        b();
        return;
        paramView = new Intent(this, CardPicGalleryActivity.class);
        localObject1 = new ArrayList();
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          ((ArrayList)localObject1).add(this.jdField_b_of_type_JavaLangString);
        }
        paramView.putStringArrayListExtra("business_card_pics", (ArrayList)localObject1);
        paramView.putExtra("is_edit_mode", this.jdField_a_of_type_Boolean);
        if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 3)) {
          paramView.putExtra("is_from_profile", true);
        }
        startActivityForResult(paramView, 11);
        overridePendingTransition(2131034389, 0);
        return;
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1, 15);
        this.jdField_e_of_type_Int += 1;
        if (this.jdField_e_of_type_Int >= 3) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_d_of_type_Int == 0) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8007752", "0X8007752", this.jdField_d_of_type_Int, 0, "", "", "", "");
        return;
        a(null, this.jdField_f_of_type_Int);
        this.jdField_f_of_type_Int += 1;
        if (this.jdField_f_of_type_Int < 2) {
          break;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        a(this.jdField_e_of_type_AndroidWidgetLinearLayout, null, 2, 150);
        this.jdField_g_of_type_Int += 1;
        if (this.jdField_g_of_type_Int < 2) {
          break;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        localObject1 = "";
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity
 * JD-Core Version:    0.7.0.1
 */