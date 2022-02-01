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
  BusinessCardManager A;
  String B;
  BusinessCard C;
  CardOCRInfo D;
  String E;
  String F;
  int G;
  int H = -1;
  int I = 0;
  boolean J = false;
  FriendListObserver K = new BusinessCardEditActivity.17(this);
  BusinessCardObserver L = new BusinessCardEditActivity.18(this);
  private int M = 1;
  private int N = 1;
  private int O = 1;
  private List<WeakReference<FaceDrawable>> P;
  private boolean Q = false;
  private boolean R = false;
  private ContentObserver S;
  RelativeLayout a;
  TextView b;
  TextView c;
  TextView d;
  LinearLayout e;
  Button f;
  ImageView g;
  ClearEllipsisEditText h;
  ClearEllipsisEditText i;
  RelativeLayout j;
  RelativeLayout k;
  LinearLayout l;
  LinearLayout m;
  LinearLayout n;
  TextView o;
  TextView p;
  TextView q;
  Dialog r;
  QQProgressDialog s;
  BusinessCardEditActivity.MaxBytesTextWatcher t;
  Intent u;
  int v;
  boolean w = false;
  boolean x = false;
  boolean y = false;
  boolean z = false;
  
  private void a(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null)
    {
      this.l.removeAllViews();
      Object localObject1 = this.u.getStringArrayListExtra("bind_phone_num");
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.l, (String)localObject3, 1);
        }
      }
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        localObject2 = paramBusinessCard.mobilesNum.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.l, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramBusinessCard.mobilesNum.isEmpty())) {
        a(this.l, null, 1);
      }
      if (!b())
      {
        this.m.removeAllViews();
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
            localObject5 = LayoutInflater.from(this).inflate(2131627338, null);
            localObject7 = (ImageView)((View)localObject5).findViewById(2131435219);
            localObject8 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject6);
            this.P.add(new WeakReference(localObject8));
            ((ImageView)localObject7).setBackgroundDrawable((Drawable)localObject8);
            ((TextView)((View)localObject5).findViewById(2131439303)).setText(ContactUtils.g(this.app, (String)localObject6));
            ((TextView)((View)localObject5).findViewById(2131449064)).setText((CharSequence)localObject6);
            ((ImageView)((View)localObject5).findViewById(2131428784)).setVisibility(0);
            localObject7 = new BusinessCardEditActivity.ItemHolder(this);
            ((BusinessCardEditActivity.ItemHolder)localObject7).a = ((String)localObject6);
            ((BusinessCardEditActivity.ItemHolder)localObject7).b = ContactUtils.g(this.app, (String)localObject6);
            ((BusinessCardEditActivity.ItemHolder)localObject7).c = false;
            ((View)localObject5).setTag(localObject7);
            ((View)localObject5).setOnClickListener(new BusinessCardEditActivity.6(this));
            localObject6 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.m.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
          }
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (String)((Iterator)localObject3).next();
            localObject4 = LayoutInflater.from(this).inflate(2131627338, null);
            localObject6 = (ImageView)((View)localObject4).findViewById(2131435219);
            localObject7 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject5);
            this.P.add(new WeakReference(localObject7));
            ((ImageView)localObject6).setBackgroundDrawable((Drawable)localObject7);
            localObject6 = (TextView)((View)localObject4).findViewById(2131439303);
            ((TextView)((View)localObject4).findViewById(2131449064)).setText((CharSequence)localObject5);
            localObject7 = (Button)((View)localObject4).findViewById(2131427796);
            ((Button)localObject7).setVisibility(0);
            localObject8 = new BusinessCardEditActivity.ItemHolder(this);
            ((BusinessCardEditActivity.ItemHolder)localObject8).a = ((String)localObject5);
            ((BusinessCardEditActivity.ItemHolder)localObject8).b = ContactUtils.b(this.app, (String)localObject5, true);
            ((BusinessCardEditActivity.ItemHolder)localObject8).c = false;
            ((View)localObject4).setTag(localObject8);
            ((TextView)localObject6).setText(((BusinessCardEditActivity.ItemHolder)localObject8).b);
            ((Button)localObject7).setTag(localObject8);
            ((Button)localObject7).setOnClickListener(new BusinessCardEditActivity.7(this));
            localObject5 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.m.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject7 = (String)((Iterator)localObject2).next();
            localObject3 = LayoutInflater.from(this).inflate(2131627338, null);
            localObject4 = (ImageView)((View)localObject3).findViewById(2131435219);
            localObject5 = (TextView)((View)localObject3).findViewById(2131439303);
            localObject8 = (TextView)((View)localObject3).findViewById(2131449064);
            localObject6 = (Button)((View)localObject3).findViewById(2131427796);
            ((Button)localObject6).setVisibility(0);
            ((TextView)localObject8).setText((CharSequence)localObject7);
            localObject8 = paramBusinessCard.getMobileInfoByMobile((String)localObject7);
            BusinessCardEditActivity.ItemHolder localItemHolder = new BusinessCardEditActivity.ItemHolder(this);
            localItemHolder.c = true;
            if (localObject8 != null)
            {
              localObject7 = FaceDrawable.getFaceDrawable(this.app, 11, ((CardMobileInfo)localObject8).e);
              this.P.add(new WeakReference(localObject7));
              ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject7);
              localItemHolder.a = ((CardMobileInfo)localObject8).e;
              localItemHolder.b = ((CardMobileInfo)localObject8).d;
            }
            else
            {
              localItemHolder.a = ((String)localObject7);
              localItemHolder.b = ((String)localObject7);
            }
            ((View)localObject3).setTag(localItemHolder);
            ((TextView)localObject5).setText(localItemHolder.b);
            ((Button)localObject6).setTag(localItemHolder);
            ((Button)localObject6).setOnClickListener(new BusinessCardEditActivity.8(this));
            localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.m.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            a(this.m, (String)localObject2, 0);
          }
        }
        a(this.m, null, 0);
      }
      this.n.removeAllViews();
      localObject1 = (LinearLayout)this.k.findViewById(2131431762);
      Object localObject2 = this.k.findViewById(2131431741);
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
          a(this.n, ((StringBuilder)localObject1).toString(), 2);
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
    int i3 = 0;
    int i2 = 0;
    int i1;
    if (paramBusinessCard != null)
    {
      this.l.removeAllViews();
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        i1 = 0;
        while (i1 < paramBusinessCard.mobilesNum.size())
        {
          paramCardOCRInfo = (String)paramBusinessCard.mobilesNum.get(i1);
          a(this.l, paramCardOCRInfo, 1, 15);
          i1 += 1;
        }
        this.M = paramBusinessCard.mobilesNum.size();
      }
      if (this.u.getExtras() != null) {
        paramCardOCRInfo = this.u.getExtras().getString("add_phone_num", null);
      } else {
        paramCardOCRInfo = null;
      }
      if (paramCardOCRInfo != null)
      {
        i1 = this.M;
        if (i1 < 3)
        {
          this.M = (i1 + 1);
          a(this.l, paramCardOCRInfo, 1, 15, true);
        }
      }
      if (this.M >= 3) {
        this.o.setVisibility(8);
      }
      if (this.M == 0)
      {
        a(this.l, null, 1, 15);
        this.M = 1;
      }
      this.m.removeAllViews();
      if (!paramBusinessCard.uinInfos.isEmpty())
      {
        i1 = i2;
        while (i1 < paramBusinessCard.uinInfos.size())
        {
          paramCardOCRInfo = ((CardUinInfo)paramBusinessCard.uinInfos.get(i1)).a;
          if (!TextUtils.isEmpty(paramCardOCRInfo)) {
            a(paramCardOCRInfo, i1);
          }
          i1 += 1;
        }
        this.N = paramBusinessCard.uinInfos.size();
        if (this.N >= 2) {
          this.p.setVisibility(8);
        }
      }
      else
      {
        a(null, 0);
        this.N = 1;
      }
      this.n.removeAllViews();
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
        a(this.n, paramCardOCRInfo.toString(), 2, 150);
        this.O = paramBusinessCard.descs.size();
        if (this.O >= 2) {
          this.q.setVisibility(8);
        }
      }
      else
      {
        a(this.n, null, 2, 150);
        this.O = 1;
      }
    }
    else if (paramCardOCRInfo != null)
    {
      this.l.removeAllViews();
      if (!paramCardOCRInfo.d.isEmpty())
      {
        i1 = 0;
        while (i1 < paramCardOCRInfo.d.size())
        {
          paramBusinessCard = (String)paramCardOCRInfo.d.get(i1);
          a(this.l, paramBusinessCard, 1, 15);
          i1 += 1;
        }
        this.M = paramCardOCRInfo.d.size();
      }
      else
      {
        a(this.l, null, 1, 15);
        this.M = 1;
      }
      this.m.removeAllViews();
      if (!paramCardOCRInfo.c.isEmpty())
      {
        i1 = i3;
        while (i1 < paramCardOCRInfo.c.size())
        {
          a((String)paramCardOCRInfo.c.get(i1), i1);
          i1 += 1;
        }
        this.N = paramCardOCRInfo.c.size();
      }
      else
      {
        a(null, 0);
        this.N = 1;
      }
      this.n.removeAllViews();
      a(this.n, null, 2, 150);
      this.O = 1;
    }
  }
  
  private void a(BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    Object localObject = this.C;
    if (localObject != null)
    {
      paramBusinessCard.cardId = ((BusinessCard)localObject).cardId;
      paramBusinessCard.bindUin = this.C.bindUin;
      if (this.v == 2) {
        paramBusinessCard.cardName = this.C.cardName;
      }
    }
    if (this.v != 2) {
      paramBusinessCard.cardName = this.h.getTotalText();
    }
    localObject = this.D;
    if (localObject != null)
    {
      paramBusinessCard.picUrl = ((CardOCRInfo)localObject).b;
      paramBusinessCard.OCRInfo = this.D;
    }
    else
    {
      localObject = this.C;
      if (localObject != null)
      {
        paramBusinessCard.picUrl = ((BusinessCard)localObject).picUrl;
        paramBusinessCard.OCRInfo = this.C.OCRInfo;
      }
    }
    if (this.J)
    {
      paramBusinessCard.picUrl = null;
      paramBusinessCard.OCRInfo = null;
    }
    paramBusinessCard.company = this.i.getTotalText();
    paramBusinessCard.mobilesNum.clear();
    int i2 = 0;
    int i1 = 0;
    while (i1 < this.l.getChildCount())
    {
      localObject = ((EditText)this.l.getChildAt(i1)).getText().toString().trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBusinessCard.mobilesNum.add(localObject);
      }
      i1 += 1;
    }
    paramBusinessCard.qqNum.clear();
    i1 = 0;
    while (i1 < this.m.getChildCount())
    {
      localObject = this.m.getChildAt(i1);
      if ((localObject instanceof RelativeLayout))
      {
        localObject = (EditText)((View)localObject).findViewById(2131442353);
        if (localObject != null)
        {
          localObject = ((EditText)localObject).getText().toString().trim();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramBusinessCard.qqNum.add(localObject);
          }
        }
      }
      i1 += 1;
    }
    paramBusinessCard.descs.clear();
    i1 = 0;
    while (i1 < this.n.getChildCount())
    {
      localObject = ((EditText)this.n.getChildAt(i1)).getText().toString().trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBusinessCard.descs.add(localObject);
      }
      i1 += 1;
    }
    if (paramBoolean)
    {
      if (this.v == 0)
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
          ReportController.b(this.app, "CliOper", "", "", "0X8007749", "0X8007749", this.I, 0, "", "", "", "");
          localObject = "1";
        }
        else
        {
          localObject = "0";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80064EF", "0X80064EF", 0, 0, (String)localObject, "", "", "");
        if (!TextUtils.isEmpty(paramBusinessCard.company))
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800774A", "0X800774A", this.I, 0, "", "", "", "");
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
        int i3 = paramBusinessCard.descs.size();
        i1 = 0;
        while (i1 < i3)
        {
          if (!TextUtils.isEmpty((CharSequence)paramBusinessCard.descs.get(i1))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774E", "0X800774E", this.I, 0, "", "", "", "");
          }
          i1 += 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBusinessCard.descs.size());
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        ReportController.b(this.app, "CliOper", "", "", "0X80064F2", "0X80064F2", 0, 0, (String)localObject, "", "", "");
        i3 = paramBusinessCard.mobilesNum.size();
        i1 = i2;
        while (i1 < i3)
        {
          if ((i1 == 0) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i1)))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774B", "0X800774B", this.I, 0, "", "", "", "");
          }
          if ((i1 == 1) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i1)))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774C", "0X800774C", this.I, 0, "", "", "", "");
          }
          if ((i1 == 2) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i1)))) {
            ReportController.b(this.app, "CliOper", "", "", "0X800774D", "0X800774D", this.I, 0, "", "", "", "");
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo != null)
    {
      this.l.removeAllViews();
      Object localObject1 = this.u.getStringArrayListExtra("bind_phone_num");
      Object localObject2;
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.l, (String)localObject3, 1);
        }
      }
      if (!paramCardOCRInfo.d.isEmpty())
      {
        localObject2 = paramCardOCRInfo.d.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.l, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramCardOCRInfo.d.isEmpty())) {
        a(this.l, null, 1);
      }
      if (!b())
      {
        this.m.removeAllViews();
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
            localObject3 = LayoutInflater.from(this).inflate(2131627338, null);
            localObject5 = (ImageView)((View)localObject3).findViewById(2131435219);
            localObject6 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject4);
            this.P.add(new WeakReference(localObject6));
            ((ImageView)localObject5).setBackgroundDrawable((Drawable)localObject6);
            ((TextView)((View)localObject3).findViewById(2131439303)).setText(ContactUtils.g(this.app, (String)localObject4));
            ((TextView)((View)localObject3).findViewById(2131449064)).setText((CharSequence)localObject4);
            ((ImageView)((View)localObject3).findViewById(2131428784)).setVisibility(0);
            localObject5 = new BusinessCardEditActivity.ItemHolder(this);
            ((BusinessCardEditActivity.ItemHolder)localObject5).a = ((String)localObject4);
            ((BusinessCardEditActivity.ItemHolder)localObject5).b = ContactUtils.g(this.app, (String)localObject4);
            ((BusinessCardEditActivity.ItemHolder)localObject5).c = false;
            ((View)localObject3).setTag(localObject5);
            ((View)localObject3).setOnClickListener(new BusinessCardEditActivity.4(this));
            localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.m.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject2 = LayoutInflater.from(this).inflate(2131627338, null);
            localObject4 = (ImageView)((View)localObject2).findViewById(2131435219);
            localObject5 = FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject3);
            this.P.add(new WeakReference(localObject5));
            ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject5);
            localObject4 = (TextView)((View)localObject2).findViewById(2131439303);
            ((TextView)((View)localObject2).findViewById(2131449064)).setText((CharSequence)localObject3);
            localObject5 = (Button)((View)localObject2).findViewById(2131427796);
            ((Button)localObject5).setVisibility(0);
            localObject6 = new BusinessCardEditActivity.ItemHolder(this);
            ((BusinessCardEditActivity.ItemHolder)localObject6).a = ((String)localObject3);
            ((BusinessCardEditActivity.ItemHolder)localObject6).b = ContactUtils.b(this.app, (String)localObject3, true);
            ((BusinessCardEditActivity.ItemHolder)localObject6).c = false;
            ((View)localObject2).setTag(localObject6);
            ((TextView)localObject4).setText(((BusinessCardEditActivity.ItemHolder)localObject6).b);
            ((Button)localObject5).setTag(localObject6);
            ((Button)localObject5).setOnClickListener(new BusinessCardEditActivity.5(this));
            localObject3 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.m.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          paramCardOCRInfo = paramCardOCRInfo.iterator();
          while (paramCardOCRInfo.hasNext())
          {
            localObject1 = (String)paramCardOCRInfo.next();
            a(this.m, (String)localObject1, 0);
          }
        }
        a(this.m, null, 0);
      }
      this.n.removeAllViews();
      paramCardOCRInfo = (LinearLayout)this.k.findViewById(2131431762);
      localObject1 = this.k.findViewById(2131431741);
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
      long l1 = ContentUris.parseId(localUri);
      this.R = true;
      if ((paramString1 != null) && (paramList != null) && (paramList.size() > 0))
      {
        localContentValues.clear();
        localContentValues.put("raw_contact_id", Long.valueOf(l1));
        localContentValues.put("mimetype", "vnd.android.cursor.item/name");
        localContentValues.put("data2", paramString1);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
        if (paramString2 != null)
        {
          localContentValues.clear();
          localContentValues.put("raw_contact_id", Long.valueOf(l1));
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
          localContentValues.put("raw_contact_id", Long.valueOf(l1));
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
    String str = this.h.getTotalText().trim();
    Object localObject2 = str;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject3 = null;
      if (localObject2 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((FriendsManager)localObject2).f(paramString);
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
          localObject2 = ((FriendsManager)localObject2).m(paramString);
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((Friends)localObject2).name;
        }
      }
      localObject2 = str;
      if (!this.t.d)
      {
        localObject2 = str;
        if (str.equals(localObject1))
        {
          localObject2 = str;
          if (this.z) {
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
    this.w = paramBoolean1;
    g();
    BusinessCard localBusinessCard = this.C;
    if (localBusinessCard != null)
    {
      if (paramBoolean2) {
        c(localBusinessCard.picUrl);
      }
      b(this.C.cardName, this.C.company, true);
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
    int i1 = 0;
    while (i1 < paramBusinessCard2.mobilesNum.size())
    {
      if (!((String)paramBusinessCard1.mobilesNum.get(i1)).equals(paramBusinessCard2.mobilesNum.get(i1))) {
        return true;
      }
      i1 += 1;
    }
    if (paramBusinessCard1.descs.size() != paramBusinessCard2.descs.size()) {
      return true;
    }
    i1 = 0;
    while (i1 < paramBusinessCard2.descs.size())
    {
      if (!((String)paramBusinessCard1.descs.get(i1)).equals(paramBusinessCard2.descs.get(i1))) {
        return true;
      }
      i1 += 1;
    }
    if (paramBusinessCard1.qqNum.size() != paramBusinessCard2.uinInfos.size()) {
      return true;
    }
    i1 = 0;
    while (i1 < paramBusinessCard2.uinInfos.size())
    {
      if (!((String)paramBusinessCard1.qqNum.get(i1)).equals(((CardUinInfo)paramBusinessCard2.uinInfos.get(i1)).a)) {
        return true;
      }
      i1 += 1;
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
    Object localObject1 = this.C;
    if (localObject1 != null)
    {
      if ((!TextUtils.isEmpty(((BusinessCard)localObject1).bindUin)) && ((((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.C.bindUin)) || (this.C.cardType == 1))) {
        paramArrayList1.add(this.C.bindUin);
      }
      localObject1 = this.C.uinInfos.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CardUinInfo)((Iterator)localObject1).next();
        if (((CardUinInfo)localObject2).b) {
          paramArrayList1.add(((CardUinInfo)localObject2).a);
        } else if (((CardUinInfo)localObject2).c) {
          paramArrayList2.add(((CardUinInfo)localObject2).a);
        } else {
          paramArrayList4.add(((CardUinInfo)localObject2).a);
        }
      }
      localObject1 = this.C.mobileInfos.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CardMobileInfo)((Iterator)localObject1).next();
        if (((CardMobileInfo)localObject2).c) {
          paramArrayList1.add(((CardMobileInfo)localObject2).b);
        } else {
          paramArrayList3.add(((CardMobileInfo)localObject2).a);
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
    boolean bool = a(this.h.getTotalText(), paramCardOCRInfo.a);
    int i2 = 1;
    int i3 = bool ^ true;
    Object localObject = new ArrayList();
    int i1 = 0;
    while (i1 < this.l.getChildCount())
    {
      String str = ((EditText)this.l.getChildAt(i1)).getText().toString().trim();
      if (!TextUtils.isEmpty(str)) {
        ((ArrayList)localObject).add(str);
      }
      i1 += 1;
    }
    if ((!paramCardOCRInfo.d.isEmpty()) && (!((ArrayList)localObject).isEmpty()))
    {
      paramCardOCRInfo = (String)paramCardOCRInfo.d.get(0);
      if (!TextUtils.isEmpty(paramCardOCRInfo)) {
        localObject = ((ArrayList)localObject).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext()) {
        if (paramCardOCRInfo.equals((String)((Iterator)localObject).next())) {
          if ((paramCardOCRInfo.d.isEmpty()) && (((ArrayList)localObject).isEmpty()))
          {
            i1 = 0;
            break label201;
          }
        }
      }
    }
    i1 = 1;
    label201:
    if ((i3 != 0) && (i1 != 0)) {
      i1 = i2;
    } else if (i3 != 0) {
      i1 = 2;
    } else if (i1 != 0) {
      i1 = 3;
    } else {
      i1 = 0;
    }
    BusinessCardUtils.a(this.app.getCurrentAccountUin(), i1);
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131430358);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131430329);
    Object localObject = (TextView)findViewById(2131439134);
    if (this.v == 2)
    {
      ((TextView)localObject).setText(super.getResources().getString(2131890925));
      if (paramBoolean)
      {
        paramString1 = this.F;
        if (paramString1 == null)
        {
          paramString1 = this.C;
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.bindUin)))
          {
            localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            paramString1 = null;
            Card localCard;
            if (localObject == null) {
              localCard = null;
            } else {
              localCard = ((FriendsManager)localObject).f(this.C.bindUin);
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
              this.z = true;
              paramString1 = (String)localObject;
              break label297;
            }
            if (localObject != null) {
              paramString1 = ((FriendsManager)localObject).m(this.C.bindUin);
            }
            if (paramString1 != null)
            {
              if (!TextUtils.isEmpty(paramString1.remark))
              {
                paramString1 = paramString1.remark;
                break label297;
              }
              paramString1 = paramString1.name;
              this.z = true;
              break label297;
            }
          }
          paramString1 = "";
        }
      }
    }
    else
    {
      ((TextView)localObject).setText(super.getResources().getString(2131896622));
    }
    label297:
    this.h.setEllipsisText(paramString1);
    this.i.setEllipsisText(paramString2);
    if (this.w)
    {
      localRelativeLayout1.setVisibility(0);
      this.h.setFocusable(true);
      this.h.setFocusableInTouchMode(true);
      if (this.v == 2) {
        this.h.setHint(2131896625);
      } else {
        this.h.setHint(2131896623);
      }
      this.t = new BusinessCardEditActivity.MaxBytesTextWatcher(this, 96, this.h, 1);
      this.h.addTextChangedListener(this.t);
      localRelativeLayout2.setVisibility(0);
      this.i.setFocusable(true);
      this.i.setFocusableInTouchMode(true);
      this.i.setHint(2131896612);
      paramString1 = new BusinessCardEditActivity.MaxBytesTextWatcher(this, 30, this.i);
      this.i.addTextChangedListener(paramString1);
      return;
    }
    this.h.setFocusable(false);
    this.h.setFocusableInTouchMode(false);
    this.h.setHint(HardCodeUtil.a(2131899496));
    if (TextUtils.isEmpty(paramString2))
    {
      localRelativeLayout2.setVisibility(8);
      return;
    }
    localRelativeLayout2.setVisibility(0);
    this.i.setFocusable(false);
    this.i.setFocusableInTouchMode(false);
    this.i.setHint(HardCodeUtil.a(2131899491));
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("/?01");
      this.E = localStringBuilder.toString();
      this.g.setVisibility(0);
      this.g.setOnClickListener(this);
      int i1 = getResources().getDisplayMetrics().widthPixels;
      int i2 = i1 * 600 / 1000;
      paramString = (LinearLayout.LayoutParams)this.g.getLayoutParams();
      paramString.width = i1;
      paramString.height = i2;
      this.g.setLayoutParams(paramString);
      try
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mRequestWidth = 1000;
        paramString.mRequestHeight = 600;
        paramString.mLoadingDrawable = super.getResources().getDrawable(2130846381);
        paramString.mFailedDrawable = super.getResources().getDrawable(2130846381);
        paramString = URLDrawable.getDrawable(this.E, paramString);
        this.g.setImageDrawable(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    findViewById(2131440268).setVisibility(8);
    this.g.setVisibility(8);
  }
  
  private void d(String paramString)
  {
    this.r = DialogUtil.a(this, paramString, 2131890045, 2131890834, new BusinessCardEditActivity.13(this), new BusinessCardEditActivity.14(this));
    if ((this.r != null) && (!isFinishing())) {
      this.r.show();
    }
  }
  
  private void e()
  {
    this.u = super.getIntent();
    this.v = this.u.getIntExtra("mode_type", 0);
    this.w = this.u.getBooleanExtra("is_edit_mode", false);
    this.B = this.u.getStringExtra("cur_card_id");
    this.C = ((BusinessCard)this.u.getParcelableExtra("cur_card_body"));
    this.D = ((CardOCRInfo)this.u.getParcelableExtra("cur_ocr_info"));
    this.G = this.u.getIntExtra("source_activity", 0);
    this.x = this.u.getBooleanExtra("finish_immedia", false);
    this.F = this.u.getStringExtra("has_local_remark");
    this.P = new ArrayList();
    this.A = ((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER));
    Object localObject = this.B;
    if (localObject != null)
    {
      this.C = this.A.a((String)localObject);
      if (this.C == null) {
        ThreadManager.post(new BusinessCardEditActivity.1(this), 8, null, true);
      }
      if (this.v != 3) {
        BusinessCardServlet.a(this.app, this.B, false, 3);
      } else {
        BusinessCardServlet.a(this.app, this.B, true, 3);
      }
    }
    else
    {
      localObject = this.C;
      if (localObject != null) {
        this.B = ((BusinessCard)localObject).cardId;
      }
    }
    if (this.v == 2)
    {
      localObject = this.C;
      if ((localObject != null) && (!TextUtils.isEmpty(((BusinessCard)localObject).picUrl))) {
        this.H = 0;
      }
    }
    int i1 = this.v;
    if (i1 == 2) {
      this.I = 1;
    } else if (i1 == 3) {
      this.I = 2;
    } else {
      this.I = 0;
    }
    this.app.registObserver(this.L);
    h();
    addObserver(this.K);
  }
  
  private void f()
  {
    super.setContentView(2131627333);
    this.a = ((RelativeLayout)findViewById(2131445159));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.a.setFitsSystemWindows(true);
    }
    a();
    g();
    this.g = ((ImageView)findViewById(2131430366));
    this.h = ((ClearEllipsisEditText)findViewById(2131430357));
    this.h.setOnEditorActionListener(this);
    this.h.setTag("name");
    this.h.setMaxLength(96, 1);
    this.i = ((ClearEllipsisEditText)findViewById(2131430328));
    this.i.setOnEditorActionListener(this);
    this.i.setMaxLength(30, 2);
    this.j = ((RelativeLayout)findViewById(2131432341));
    this.k = ((RelativeLayout)findViewById(2131431991));
    Object localObject = this.C;
    if (localObject != null)
    {
      c(((BusinessCard)localObject).picUrl);
      b(this.C.cardName, this.C.company, true);
    }
    else
    {
      localObject = this.D;
      if (localObject != null)
      {
        c(((CardOCRInfo)localObject).b);
        b(this.D.a, null, true);
      }
      else
      {
        c(null);
        b(null, null, true);
      }
    }
    a(true);
  }
  
  private void g()
  {
    if (this.w)
    {
      int i1 = this.v;
      if (i1 == 2) {
        this.b.setText(2131896618);
      } else if (i1 == 3) {
        this.b.setText(2131896621);
      } else {
        this.b.setText(2131896617);
      }
      this.d.setVisibility(0);
      this.d.setText(2131889474);
      this.c.setBackgroundDrawable(super.getResources().getDrawable(2130853297));
      this.e.setVisibility(8);
      return;
    }
    if (this.v == 3) {
      this.b.setText(2131896621);
    } else {
      this.b.setText(2131896616);
    }
    this.d.setText(2131888824);
    if (this.G == 2) {
      this.d.setVisibility(8);
    }
    this.c.setBackgroundDrawable(super.getResources().getDrawable(2130853297));
    this.f.setText(2131896628);
    Object localObject = this.C;
    if ((localObject != null) && (((((BusinessCard)localObject).OCRInfo != null) && (!TextUtils.isEmpty(this.C.OCRInfo.b))) || (this.C.mobilesNum.size() > 0)))
    {
      if ((this.v != 3) && (!this.C.mobilesNum.isEmpty()) && (!TextUtils.isEmpty(this.C.cardName)))
      {
        if (this.C.mobilesNum.size() > 0) {
          this.e.setVisibility(0);
        }
      }
      else {
        this.e.setVisibility(8);
      }
    }
    else
    {
      localObject = this.D;
      if ((localObject != null) && (((CardOCRInfo)localObject).d != null) && (this.D.d.size() > 0))
      {
        if ((this.v != 3) && (!this.D.d.isEmpty()) && (!TextUtils.isEmpty(this.D.a)))
        {
          if (this.D.d.size() > 0) {
            this.e.setVisibility(0);
          }
        }
        else {
          this.e.setVisibility(8);
        }
      }
      else {
        this.e.setVisibility(8);
      }
    }
  }
  
  private void h()
  {
    try
    {
      this.S = new BusinessCardEditActivity.16(this, new Handler(this.app.getApp().getMainLooper()));
      this.app.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.S);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
      }
      this.R = false;
    }
  }
  
  protected void a()
  {
    this.b = ((TextView)findViewById(2131436227));
    this.c = ((TextView)findViewById(2131436180));
    this.c.setOnClickListener(this);
    this.d = ((TextView)findViewById(2131436211));
    this.d.setOnClickListener(this);
    this.e = ((LinearLayout)findViewById(2131429624));
    this.f = ((Button)findViewById(2131429649));
    this.f.setOnClickListener(this);
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
    new QQToastNotifier(this).notifyUser(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextSize(16.0F);
    localTextView.setHint(HardCodeUtil.a(2131899511));
    localTextView.setTextColor(super.getResources().getColor(2131167993));
    localTextView.setGravity(16);
    localTextView.setBackgroundDrawable(super.getResources().getDrawable(2130852527));
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
      ((EditText)localObject).setHint(2131896619);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130852527));
      ((EditText)localObject).setCompoundDrawablePadding(AIOUtils.b(5.0F, getResources()));
      ((EditText)localObject).setPadding(AIOUtils.b(28.0F, getResources()), 0, AIOUtils.b(10.0F, getResources()), 0);
    }
    else
    {
      localObject = new EditText(this);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130852527));
      ((EditText)localObject).setMinHeight(DisplayUtil.a(this, 44.0F));
      ((EditText)localObject).setOnEditorActionListener(this);
      ((EditText)localObject).setPadding(AIOUtils.b(28.0F, getResources()), AIOUtils.b(12.0F, getResources()), AIOUtils.b(50.0F, getResources()), AIOUtils.b(10.0F, getResources()));
      ((EditText)localObject).setHint(2131896614);
    }
    ((EditText)localObject).setText(paramString);
    ((EditText)localObject).setTextSize(16.0F);
    ((EditText)localObject).setTextColor(super.getResources().getColor(2131167993));
    ((EditText)localObject).setHintTextColor(super.getResources().getColor(2131165717));
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
    localActionSheet.addButton(2131896609);
    localActionSheet.addButton(2131896630);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new BusinessCardEditActivity.12(this, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(String paramString, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2131627337, null);
    localView.setTag(Integer.valueOf(paramInt));
    EditText localEditText = (EditText)localView.findViewById(2131442353);
    localEditText.addTextChangedListener(new BusinessCardEditActivity.MaxBytesTextWatcher(this, 15, localEditText));
    localEditText.setText(paramString);
    paramString = (ImageView)localView.findViewById(2131427820);
    paramString.setTag(Integer.valueOf(paramInt));
    paramString.setOnClickListener(new BusinessCardEditActivity.3(this));
    this.m.addView(localView);
  }
  
  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i1;
    int i2;
    if (paramBoolean)
    {
      i1 = 2;
      i2 = 2;
    }
    else
    {
      i1 = 1;
      i2 = 1;
    }
    paramString1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, i1, paramString1, null, 3026, i2, paramString2, null, BusinessCardEditActivity.class.getName(), setLastActivityName(), null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this, paramString1);
    ReportController.b(this.app, "CliOper", "", "", "0X80064E6", "0X80064E6", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.w)
    {
      this.k.setVisibility(8);
      this.j.setVisibility(0);
      this.l = ((LinearLayout)this.j.findViewById(2131438791));
      this.m = ((LinearLayout)this.j.findViewById(2131442355));
      this.n = ((LinearLayout)this.j.findViewById(2131431746));
      this.o = ((TextView)this.j.findViewById(2131438785));
      this.o.setVisibility(0);
      this.o.setOnClickListener(this);
      this.p = ((TextView)this.j.findViewById(2131442133));
      this.p.setVisibility(0);
      this.p.setOnClickListener(this);
      this.q = ((TextView)this.j.findViewById(2131431739));
      this.q.setVisibility(8);
      this.q.setOnClickListener(this);
      if (b())
      {
        this.j.findViewById(2131442356).setVisibility(8);
        this.p.setVisibility(8);
      }
      if (paramBoolean) {
        a(this.C, this.D);
      }
    }
    else
    {
      this.k.setVisibility(0);
      this.j.setVisibility(8);
      this.l = ((LinearLayout)this.k.findViewById(2131438791));
      this.m = ((LinearLayout)this.k.findViewById(2131442355));
      this.n = ((LinearLayout)this.k.findViewById(2131431746));
      if (b())
      {
        this.k.findViewById(2131442356).setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.w("BusinessCard_EditActivity", 2, "名片备注不应该出现详情态");
        }
      }
      if (paramBoolean)
      {
        Object localObject = this.C;
        if (localObject != null)
        {
          a((BusinessCard)localObject);
          return;
        }
        localObject = this.D;
        if (localObject != null) {
          a((CardOCRInfo)localObject);
        }
      }
    }
  }
  
  void b(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.s == null) {
      this.s = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.s.a(paramString);
    this.s.setCancelable(false);
    if (isFinishing()) {
      return;
    }
    this.s.show();
  }
  
  public boolean b()
  {
    int i1 = this.v;
    return (i1 == 3) || (i1 == 2) || (this.G == 2);
  }
  
  void c()
  {
    QQProgressDialog localQQProgressDialog = this.s;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.s.dismiss();
    }
  }
  
  void d()
  {
    if (this.S != null)
    {
      try
      {
        this.app.getApp().getContentResolver().unregisterContentObserver(this.S);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
        }
      }
      this.S = null;
    }
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("CheckPermission", 1, "CheckPermission user denied = ");
    this.Q = false;
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
          if ((paramIntent != null) && (this.w))
          {
            paramIntent = (ResultRecord)paramIntent.get(0);
            while (paramInt2 < this.m.getChildCount())
            {
              localObject = this.m.getChildAt(paramInt2);
              if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof Integer)) && (paramInt1 == ((Integer)((View)localObject).getTag()).intValue()))
              {
                localObject = (EditText)((View)localObject).findViewById(2131442353);
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
          paramIntent.putExtra("selfSet_leftViewText", getString(2131917002));
          localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          startActivity((Intent)localObject);
        }
      }
      else if ((this.w) && (paramIntent.getBooleanExtra("delete_pic", false)))
      {
        this.J = true;
        c(null);
      }
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
    removeObserver(this.K);
    d();
    this.app.unRegistObserver(this.L);
    Iterator localIterator = this.P.iterator();
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
    this.R = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.I != 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X8007751", "0X8007751", this.I, 0, "", "", "", "");
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.Q) {
      ThreadManager.post(new BusinessCardEditActivity.11(this), 8, null, true);
    }
    this.Q = false;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    InputMethodUtil.a(this);
    if (this.w)
    {
      BusinessCard localBusinessCard = new BusinessCard();
      a(localBusinessCard, false);
      if (a(localBusinessCard, this.C))
      {
        d(super.getResources().getString(2131892781));
        return true;
      }
      if ((this.w) && (this.x) && (!isFinishing()))
      {
        finish();
        return true;
      }
      localBusinessCard = this.C;
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
    case 2131442133: 
      a(null, this.N);
      this.N += 1;
      if (this.N >= 2) {
        this.p.setVisibility(8);
      }
      break;
    case 2131438785: 
      a(this.l, null, 1, 15);
      this.M += 1;
      if (this.M >= 3) {
        this.o.setVisibility(8);
      }
      if (this.I != 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8007752", "0X8007752", this.I, 0, "", "", "", "");
      }
      break;
    case 2131436211: 
      if (this.w)
      {
        InputMethodUtil.a(this);
        localObject2 = new BusinessCard();
        a((BusinessCard)localObject2, true);
        if (this.y)
        {
          b(this.D);
          this.y = false;
        }
        if ((this.v == 2) && (this.F != null))
        {
          ((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a(((BusinessCard)localObject2).bindUin, (BusinessCard)localObject2);
          if (!isFinishing())
          {
            localObject1 = getIntent();
            this.F = this.h.getTotalText();
            ((Intent)localObject1).putExtra("has_local_remark", this.F);
            setResult(-1, (Intent)localObject1);
            finish();
          }
        }
        else
        {
          if (this.v == 2)
          {
            localObject1 = this.C;
            if (localObject1 != null) {
              a(((BusinessCard)localObject1).bindUin, getIntent().getBooleanExtra("notify_plugin", false));
            }
          }
          if (a((BusinessCard)localObject2, this.C))
          {
            if (!NetworkUtil.isNetSupport(this))
            {
              a(2131892157, 1);
              break;
            }
            localObject1 = Boolean.valueOf(false);
            if (this.v == 3) {
              localObject1 = Boolean.valueOf(true);
            }
            if ((((BusinessCard)localObject2).cardId != null) && (((BusinessCard)localObject2).cardId.length() > 0))
            {
              BusinessCardServlet.b(this.app, (BusinessCard)localObject2, ((Boolean)localObject1).booleanValue());
              b(HardCodeUtil.a(2131899492));
            }
            else
            {
              BusinessCardServlet.a(this.app, (BusinessCard)localObject2, ((Boolean)localObject1).booleanValue());
              b(HardCodeUtil.a(2131899487));
            }
          }
          else if ((this.w) && (this.x) && (!isFinishing()))
          {
            finish();
          }
          else
          {
            a(false, false, false);
          }
        }
        if (this.I != 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007754", "0X8007754", this.I, 0, "", "", "", "");
        }
      }
      else
      {
        a(true, false, true);
        ReportController.b(this.app, "CliOper", "", "", "0X80064E2", "0X80064E2", 0, 0, "", "", "", "");
      }
      break;
    case 2131436180: 
      onBackEvent();
      break;
    case 2131431739: 
      a(this.n, null, 2, 150);
      this.O += 1;
      if (this.O >= 2) {
        this.q.setVisibility(8);
      }
      break;
    case 2131430366: 
      localObject1 = new Intent(this, CardPicGalleryActivity.class);
      localObject2 = new ArrayList();
      if (!TextUtils.isEmpty(this.E)) {
        ((ArrayList)localObject2).add(this.E);
      }
      ((Intent)localObject1).putStringArrayListExtra("business_card_pics", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("is_edit_mode", this.w);
      int i1 = this.G;
      if ((i1 == 1) || (i1 == 3)) {
        ((Intent)localObject1).putExtra("is_from_profile", true);
      }
      startActivityForResult((Intent)localObject1, 11);
      overridePendingTransition(2130772443, 0);
      break;
    case 2131429649: 
      if ((this.C != null) || (this.D != null))
      {
        this.Q = true;
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
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)) {
      bool = true;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity
 * JD-Core Version:    0.7.0.1
 */