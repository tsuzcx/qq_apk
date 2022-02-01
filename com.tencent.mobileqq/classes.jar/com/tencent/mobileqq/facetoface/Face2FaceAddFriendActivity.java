package com.tencent.mobileqq.facetoface;

import Override;
import ajka;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import antf;
import anui;
import anyu;
import anyw;
import anzj;
import aoat;
import aoau;
import aocj;
import aocv;
import aocw;
import aoti;
import atfi;
import atfl;
import atfm;
import atfn;
import atfo;
import atfp;
import atfq;
import atfr;
import atfs;
import atft;
import atfu;
import atfv;
import atfw;
import atfx;
import atfz;
import atga;
import atgb;
import atgc;
import atgd;
import atgh;
import atgi;
import atgp;
import atgs;
import atgx;
import atgy;
import atha;
import athb;
import athc;
import bdll;
import bdzh;
import bhkm;
import bhlq;
import bhmq;
import bhnv;
import bhpc;
import bjbs;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class Face2FaceAddFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, INetInfoHandler
{
  public static int a;
  public static long a;
  public static String a;
  private static Calendar jdField_a_of_type_JavaUtilCalendar;
  public static String b;
  public static String c;
  public static int g;
  public static int h;
  public static int i;
  public ajka a;
  public Point a;
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public EditText a;
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  anyu jdField_a_of_type_Anyu = new atgd(this);
  public aoat a;
  aoau jdField_a_of_type_Aoau = new atgb(this);
  aocj jdField_a_of_type_Aocj = new atgc(this);
  private aocw jdField_a_of_type_Aocw = new atfi(this);
  private atgh jdField_a_of_type_Atgh = new atgh(this);
  public atgi a;
  protected atgs a;
  public atgy a;
  public bjbs a;
  public FriendListHandler a;
  public Face2FaceFriendDetailView a;
  public Face2FaceTroopDetailView a;
  public SnowView a;
  public XListView a;
  public ArrayList<athb> a;
  public HashMap<String, String> a;
  public List<atha> a;
  public CopyOnWriteArrayList<atha> a;
  public boolean a;
  public int b;
  public long b;
  protected View b;
  ImageView b;
  public LinearLayout b;
  public TextView b;
  public HashMap<String, Integer> b;
  public List<atha> b;
  public boolean b;
  public int c;
  protected long c;
  protected View c;
  protected TextView c;
  public HashMap<String, Integer> c;
  public List<atha> c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 0L;
  protected View d;
  protected TextView d;
  public String d;
  public List<atha> d;
  public boolean d;
  public int e;
  long e;
  protected TextView e;
  public String e;
  public List<String> e;
  public boolean e;
  public int f;
  public long f;
  protected TextView f;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public boolean h;
  boolean i;
  public int j;
  boolean j;
  public int k;
  public boolean k;
  public int l;
  public boolean l;
  int m;
  protected boolean m;
  int n;
  public boolean n;
  public int o;
  private boolean o;
  private boolean p;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Face2FaceAddFriendActivity";
    jdField_b_of_type_JavaLangString = "Face2FaceAddFriendActivity.troop";
    jdField_c_of_type_JavaLangString = "Face2FaceAddFriendActivity.time";
    jdField_a_of_type_Int = 3021;
    jdField_g_of_type_Int = 500;
    jdField_h_of_type_Int = 300000;
    jdField_a_of_type_Long = 1000L;
    jdField_i_of_type_Int = 2000;
  }
  
  public Face2FaceAddFriendActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_e_of_type_Long = 0L;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Atgs = new atft(this);
  }
  
  private int a(atha paramatha)
  {
    return this.jdField_d_of_type_JavaUtilList.indexOf(paramatha);
  }
  
  private atha a()
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData正在查看详情Uin" + this.jdField_g_of_type_JavaLangString.substring(0, 4));
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    atha localatha;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localatha = (atha)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (localatha.jdField_e_of_type_JavaLangString.equals(this.jdField_g_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData需要替换但是正在查看详情");
          }
        }
        else if ((localatha.jdField_a_of_type_Int == 1) && (b(localatha.jdField_e_of_type_JavaLangString)))
        {
          localObject = localatha;
          if (QLog.isColorLevel())
          {
            localObject = localatha;
            if (!TextUtils.isEmpty(localatha.jdField_e_of_type_JavaLangString)) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData可替换好友" + localatha.jdField_e_of_type_JavaLangString.substring(0, 4));
            }
          }
        }
      }
    }
    for (localObject = localatha;; localObject = null)
    {
      if ((localObject == null) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData 没有可替换好友");
      }
      return localObject;
    }
  }
  
  private Face2FaceFriendBubbleView a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_Atgi.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)localIterator.next();
      if ((paramString.equals(localFace2FaceFriendBubbleView.b())) && (localFace2FaceFriendBubbleView.a() == paramInt)) {
        return localFace2FaceFriendBubbleView;
      }
    }
    return null;
  }
  
  private List<atha> a(List<atha> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt < 1)) {
      return localArrayList;
    }
    Object localObject = paramList.iterator();
    do
    {
      atha localatha;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localatha = (atha)((Iterator)localObject).next();
      } while (a(localatha.jdField_e_of_type_JavaLangString));
      localArrayList.add(localatha);
    } while (localArrayList.size() != paramInt);
    if (localArrayList.size() < paramInt)
    {
      paramList = paramList.iterator();
      do
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (atha)paramList.next();
        } while (!a(((atha)localObject).jdField_e_of_type_JavaLangString));
        localArrayList.add(localObject);
      } while (localArrayList.size() != paramInt);
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyNeedReplace ask replace type" + paramInt);
    }
    atha localatha2 = d();
    atha localatha1 = f();
    if (paramInt == 1) {
      if (localatha2 != null)
      {
        localatha1 = localatha2;
        if (localatha1 == null) {
          break label125;
        }
        e(localatha1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyNeedReplace replaceData type" + localatha1.jdField_a_of_type_Int);
        }
      }
    }
    label125:
    while (!QLog.isColorLevel())
    {
      return;
      if (localatha1 != null)
      {
        break;
        if (localatha1 != null) {
          break;
        }
        localatha1 = localatha2;
        if (localatha2 != null) {
          break;
        }
      }
      localatha1 = null;
      break;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyNeedReplace no data can replace");
  }
  
  private void a(int paramInt, String paramString)
  {
    if (!paramString.equals(this.jdField_e_of_type_JavaLangString)) {}
    TextView localTextView;
    Button localButton;
    do
    {
      return;
      localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362175);
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362172);
      localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362166);
      if (paramInt == 3)
      {
        this.jdField_f_of_type_Boolean = true;
        a(localTextView, anzj.a(2131703179));
        a(localButton, anzj.a(2131703184));
        localButton.setOnClickListener(new atfs(this, paramString));
        return;
      }
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          paramString = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (!TextUtils.isEmpty(paramString)) {
            ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367253)).setText(paramString);
          }
        }
        a(localTextView, anzj.a(2131703190));
        localLinearLayout.setVisibility(8);
        return;
      }
    } while (paramInt != 4);
    a(localTextView, anzj.a(2131703189));
    a(localButton, anzj.a(2131703186));
  }
  
  private void a(int paramInt, String paramString1, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString2, Bitmap paramBitmap)
  {
    this.jdField_e_of_type_JavaLangString = paramString1;
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362172);
    a((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367253), paramString2);
    ((ImageView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367223)).setImageBitmap(paramBitmap);
    paramBitmap = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362175);
    Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362166);
    paramString2 = "";
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) {
      paramString2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString2.length());
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1)) {
      this.jdField_l_of_type_Int = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString1)).intValue();
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_l_of_type_Int));
    this.jdField_f_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, 3021, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new atfo(this));
    localButton.setOnClickListener(new atfp(this, paramString1));
    if (paramInt == 2)
    {
      a(paramBitmap, anzj.a(2131703187));
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = new atfr(this, paramString1);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, paramFace2FaceFriendBubbleView, paramString1, this.jdField_a_of_type_JavaUtilHashMap, paramString2);
      return;
      if ((paramInt == 4) || (paramInt == 1))
      {
        if (paramInt == 4) {
          a(paramBitmap, anzj.a(2131703177));
        }
        for (;;)
        {
          a(localButton, anzj.a(2131703183));
          localLinearLayout.setVisibility(0);
          break;
          a(paramBitmap, "");
        }
      }
      if (paramInt == 3)
      {
        this.jdField_f_of_type_Boolean = true;
        a(paramBitmap, anzj.a(2131703182));
        localLinearLayout.setVisibility(0);
        a(localButton, anzj.a(2131703175));
        localButton.setOnClickListener(new atfq(this, paramString1));
      }
    }
  }
  
  private void a(long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_Atgh.obtainMessage(7);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendDelayAskRequest delaytime=" + paramLong);
    }
    this.jdField_a_of_type_Atgh.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.setContentDescription(paramString);
  }
  
  private void a(String paramString)
  {
    new ArrayList();
    Object localObject = this.app.a().b(antf.M, 0);
    structmsg.StructMsg localStructMsg = null;
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList is null");
      }
    }
    int i1;
    label139:
    long l1;
    long l2;
    int i2;
    int i3;
    int i4;
    int i5;
    do
    {
      do
      {
        return;
        if ((((List)localObject).size() <= 0) || ((((List)localObject).get(0) instanceof MessageForSystemMsg))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList error");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend systemMsgList size" + ((List)localObject).size());
      }
      i1 = ((List)localObject).size() - 1;
      if (i1 >= 0)
      {
        localStructMsg = ((MessageForSystemMsg)((List)localObject).get(i1)).getSystemMsg();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend structMsg.req_uin =" + String.valueOf(localStructMsg.req_uin.get()) + "friendUin=" + paramString);
        }
        if (!paramString.equals(String.valueOf(localStructMsg.req_uin.get()))) {
          break;
        }
      }
      if ((localStructMsg == null) || (!paramString.equals(String.valueOf(localStructMsg.req_uin.get())))) {
        break label522;
      }
      i1 = localStructMsg.msg_type.get();
      l1 = localStructMsg.msg_seq.get();
      l2 = localStructMsg.req_uin.get();
      i2 = localStructMsg.msg.sub_type.get();
      i3 = localStructMsg.msg.src_id.get();
      i4 = localStructMsg.msg.sub_src_id.get();
      i5 = localStructMsg.msg.group_msg_type.get();
      localObject = localStructMsg.msg.actions.get();
    } while ((localObject == null) || (((List)localObject).size() >= 0));
    int i6 = this.jdField_l_of_type_Int;
    paramString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).remark.set(paramString);
      ((structmsg.SystemMsgActionInfo)localObject).group_id.set(i6);
      this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)localObject, 0, localStructMsg, false);
      a(localStructMsg, localStructMsg.msg_seq.get());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend  structMsg.req_uin:  " + String.valueOf(localStructMsg.req_uin.get()));
      return;
      i1 -= 1;
      break label139;
      label522:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
      return;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = a(paramString, 1);
    if (localFace2FaceFriendBubbleView != null)
    {
      localFace2FaceFriendBubbleView.setStatusWithAnimation(paramInt);
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
        this.jdField_c_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdzh.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      bdzh.a().b(l1);
      bdzh.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "delayPushToUI mShowdataList.size()=" + this.jdField_d_of_type_JavaUtilList.size() + "ispush=" + paramBoolean1 + "changeIndex" + paramInt + "isReplash=" + paramBoolean2);
    }
    int i1 = this.jdField_c_of_type_Int;
    if (paramBoolean1) {}
    for (;;)
    {
      if (paramInt < this.jdField_d_of_type_JavaUtilList.size())
      {
        Message localMessage = this.jdField_a_of_type_Atgh.obtainMessage();
        localMessage.what = 4;
        Object localObject = new Bundle();
        ((Bundle)localObject).putBoolean("key_data _ispush", paramBoolean1);
        ((Bundle)localObject).putBoolean("key_data _hasfriend", paramBoolean2);
        localMessage.setData((Bundle)localObject);
        localMessage.arg1 = paramInt;
        localObject = (atha)this.jdField_d_of_type_JavaUtilList.get(paramInt);
        localMessage.arg2 = ((atha)localObject).jdField_a_of_type_Int;
        localMessage.obj = localObject;
        if (this.jdField_a_of_type_Atgh.hasMessages(4)) {
          this.jdField_a_of_type_Atgh.removeMessages(4);
        }
        this.jdField_a_of_type_Atgh.sendMessageDelayed(localMessage, jdField_g_of_type_Int);
      }
      return;
      paramInt = i1;
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (paramString.equals(this.app.getCurrentAccountUin()))
    {
      QQToast.a(this, 2131690587, 0).b(getTitleBarHeight());
      return false;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        anyw localanyw = (anyw)this.app.getManager(51);
        if (localanyw != null)
        {
          paramString = localanyw.e(paramString);
          if ((paramString == null) || (paramString.groupid < 0)) {
            break;
          }
          QQToast.a(this.app.getApplication(), 2131689992, 0).b(getTitleBarHeight());
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
      paramString = null;
    }
    if (!bhnv.d(this))
    {
      QQToast.a(this.app.getApplication(), 2131693965, 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  private boolean a(atha paramatha)
  {
    if (paramatha == null) {}
    while (((paramatha.jdField_a_of_type_Int != 1) || (!b(paramatha.jdField_e_of_type_JavaLangString))) && ((paramatha.jdField_a_of_type_Int != 2) || (!a(paramatha.jdField_e_of_type_JavaLangString)))) {
      return false;
    }
    return true;
  }
  
  private atha b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      atha localatha = (atha)localIterator.next();
      if ((!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a()) || (!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a.equals(localatha)))
      {
        if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localatha))) {
          return localatha;
        }
        if ((localatha.jdField_a_of_type_Int == 2) && (a(localatha.jdField_e_of_type_JavaLangString))) {
          return localatha;
        }
      }
    }
    return null;
  }
  
  private List<atha> b(List<atha> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt < 1)) {
      return localArrayList;
    }
    Object localObject = paramList.iterator();
    do
    {
      atha localatha;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localatha = (atha)((Iterator)localObject).next();
      } while (b(localatha.jdField_e_of_type_JavaLangString));
      localArrayList.add(localatha);
    } while (localArrayList.size() != paramInt);
    if (localArrayList.size() < paramInt)
    {
      paramList = paramList.iterator();
      do
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (atha)paramList.next();
        } while (!b(((atha)localObject).jdField_e_of_type_JavaLangString));
        localArrayList.add(localObject);
      } while (localArrayList.size() != paramInt);
    }
    return localArrayList;
  }
  
  private boolean b()
  {
    if (this.jdField_b_of_type_Int == 1) {}
    for (String str = "sp_facetoface_showguide_for_troop";; str = "sp_facetoface_showguide")
    {
      localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (localObject != null) {
        break;
      }
      return false;
    }
    this.jdField_o_of_type_Boolean = ((SharedPreferences)localObject).getBoolean(str, false);
    if (this.jdField_o_of_type_Boolean) {
      return false;
    }
    Object localObject = LayoutInflater.from(getApplicationContext()).inflate(2131558951, null);
    Button localButton = (Button)((View)localObject).findViewById(2131366216);
    ((View)localObject).setBackgroundResource(2130840085);
    ((View)localObject).setOnClickListener(this);
    if (this.jdField_b_of_type_Int == 1) {
      ((TextView)((View)localObject).findViewById(2131366215)).setText(2131691951);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1));
    localButton.setOnClickListener(new atfx(this, str, (View)localObject));
    return true;
  }
  
  private boolean b(String paramString)
  {
    anyw localanyw = (anyw)this.app.getManager(51);
    if ((localanyw != null) && (!TextUtils.isEmpty(paramString))) {
      return localanyw.b(paramString);
    }
    return false;
  }
  
  private atha c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      atha localatha = (atha)localIterator.next();
      if ((localatha != null) && (b(localatha.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localatha))) {
        return localatha;
      }
    }
    return null;
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addFriend uin is null");
      }
    }
    do
    {
      return false;
      this.jdField_f_of_type_JavaLangString = paramString;
    } while (!a(1, paramString));
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString))) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addFriend uin" + paramString.substring(0, 4));
    }
    ((FriendListHandler)this.app.a(1)).a("OidbSvc.0x476_147", Long.parseLong(paramString), 147);
    return true;
  }
  
  private atha d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      atha localatha = (atha)localIterator.next();
      if ((localatha != null) && (!b(localatha.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localatha))) {
        return localatha;
      }
    }
    return null;
  }
  
  private void d(atha paramatha)
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (paramatha == null)) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mNeedShowList= nuull  pushData = null!");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.jdField_c_of_type_Int + "showtype=pushData.type=" + paramatha.jdField_a_of_type_Int + "mFriendDataList.size()" + this.jdField_a_of_type_JavaUtilList.size() + "troop size" + this.jdField_b_of_type_JavaUtilList.size());
            }
          } while (this.jdField_d_of_type_JavaUtilList.contains(paramatha));
          if (this.jdField_a_of_type_Atgi != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI face2FaceAddFriendAnim has null");
        return;
        if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() <= 10) {
          break;
        }
      } while (a(paramatha));
      if (this.jdField_b_of_type_Int == 0)
      {
        e(paramatha);
        this.jdField_g_of_type_Boolean = true;
        return;
      }
      e(paramatha);
      return;
      if ((this.jdField_d_of_type_JavaUtilList.size() == 0) && (!this.jdField_i_of_type_Boolean))
      {
        this.jdField_d_of_type_JavaUtilList.add(paramatha);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.jdField_c_of_type_Int + "hasData" + this.jdField_i_of_type_Boolean);
        }
        this.jdField_i_of_type_Boolean = true;
        return;
      }
      this.jdField_d_of_type_JavaUtilList.add(paramatha);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.jdField_c_of_type_Int);
      }
    } while (this.jdField_d_of_type_JavaUtilList.size() != this.jdField_c_of_type_Int + 1);
    a(true, this.jdField_c_of_type_Int, false);
  }
  
  private atha e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      atha localatha = (atha)localIterator.next();
      if ((localatha != null) && (a(localatha.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localatha))) {
        return localatha;
      }
    }
    return null;
  }
  
  private void e(atha paramatha)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Atgi == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    int i2 = 0;
    int i1 = 0;
    if (((Iterator)localObject1).hasNext())
    {
      int i3;
      if (((atha)((Iterator)localObject1).next()).jdField_a_of_type_Int == 1)
      {
        i3 = i2;
        i2 = i1 + 1;
      }
      for (i1 = i3;; i1 = i3)
      {
        i3 = i2;
        i2 = i1;
        i1 = i3;
        break;
        i3 = i2 + 1;
        i2 = i1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToReplace 显示列表 mfriendCount=" + i1 + "mtroopCount=" + i2);
    }
    localObject1 = a();
    Object localObject2 = b();
    if (paramatha.jdField_a_of_type_Int == 1)
    {
      if (localObject1 != null) {}
      label264:
      for (;;)
      {
        label153:
        if (localObject1 != null)
        {
          localObject2 = ((atha)localObject1).jdField_e_of_type_JavaLangString;
          if ((localObject1 instanceof atgx)) {
            localObject2 = ((atha)localObject1).jdField_e_of_type_JavaLangString + "_" + ((atgx)localObject1).jdField_b_of_type_JavaLangString;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToReplace rRplaceData!=null && replace type=" + ((atha)localObject1).jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_Atgi.a((String)localObject2);
          if (this.jdField_b_of_type_Int == 1)
          {
            this.jdField_a_of_type_Atgi.a((atha)localObject1, bool);
            i1 = a((atha)localObject1);
            if ((i1 == -1) || (i1 >= this.jdField_d_of_type_JavaUtilList.size())) {
              break;
            }
            this.jdField_d_of_type_JavaUtilList.set(i1, paramatha);
            a(true, i1, true);
            return;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              continue;
            }
            if ((i1 >= 5) || (i2 <= 5) || (this.jdField_b_of_type_Int != 0)) {
              break label549;
            }
            i1 = 0;
            localObject2 = null;
            label354:
            localObject1 = localObject2;
            if (i1 >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
              continue;
            }
            localObject1 = (atha)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i1);
            if ((localObject1 == null) || (((atha)localObject1).jdField_a_of_type_Int != 2) || (a(((atha)localObject1).jdField_e_of_type_JavaLangString))) {
              break label555;
            }
          }
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      localObject2 = localObject1;
      break label354;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        break label153;
      }
      if (localObject1 != null) {
        break label153;
      }
      if ((i1 > 5) && (i2 < 5))
      {
        i1 = 0;
        localObject2 = null;
        label454:
        localObject1 = localObject2;
        if (i1 >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
          break label153;
        }
        localObject1 = (atha)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i1);
        if ((localObject1 != null) && (((atha)localObject1).jdField_a_of_type_Int == 1) && (!b(((atha)localObject1).jdField_e_of_type_JavaLangString))) {}
        for (;;)
        {
          i1 += 1;
          localObject2 = localObject1;
          break label454;
          bool = true;
          break label264;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToReplace rRplaceData=null 没有可以替换的数据");
          return;
          localObject1 = localObject2;
        }
      }
      label549:
      localObject1 = null;
      break label153;
      label555:
      localObject1 = localObject2;
    }
  }
  
  private atha f()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      atha localatha = (atha)localIterator.next();
      if ((localatha != null) && (!a(localatha.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localatha))) {
        return localatha;
      }
    }
    return null;
  }
  
  private void j()
  {
    this.jdField_n_of_type_Boolean = true;
    g();
    this.jdField_a_of_type_Atgh.sendEmptyMessageDelayed(3, 0L);
    a();
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendHeartRequest");
    }
    Message localMessage = this.jdField_a_of_type_Atgh.obtainMessage(5);
    this.jdField_a_of_type_Atgh.sendMessageDelayed(localMessage, jdField_h_of_type_Int);
  }
  
  private void l()
  {
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372930));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365238));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    m();
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView = new SnowView(this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView.setSnowView(this.jdField_a_of_type_AndroidGraphicsPoint);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView);
    localObject = getLayoutInflater();
    View localView = ((LayoutInflater)localObject).inflate(2131559165, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131559166, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView = ((Face2FaceTroopDetailView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379369));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView = ((Face2FaceFriendDetailView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367218));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367222));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367276));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367268));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367269));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new atfu(this));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setInfc(this.jdField_a_of_type_Atgs);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.setInfc(this.jdField_a_of_type_Atgs);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377833);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377831));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377832));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691895);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void m()
  {
    View localView = LayoutInflater.from(getApplicationContext()).inflate(2131558950, null);
    this.jdField_a_of_type_Atgi = new atgi(this.app, this);
    this.jdField_a_of_type_Atgi.a(this.app, localView, this.jdField_b_of_type_Int, this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    this.jdField_d_of_type_AndroidViewView = localView;
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131364922);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364918));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364921));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131691975);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      localView.findViewById(2131364919).setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList isFriendDataBack=" + this.jdField_b_of_type_Boolean + "isTroopDataBack=" + this.jdField_c_of_type_Boolean);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList isFriendBackSuccess=" + this.jdField_e_of_type_Int + "isTroopBackSuccess=" + this.jdField_f_of_type_Int);
    }
    if ((this.jdField_e_of_type_Int == 0) || (this.jdField_f_of_type_Int == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return wait successStatus");
      }
    }
    int i1;
    int i2;
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_e_of_type_Int != 1) || (this.jdField_f_of_type_Int != 1) || ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return");
        return;
        if (!this.jdField_d_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return has merged");
      return;
      i1 = this.jdField_a_of_type_JavaUtilList.size();
      i2 = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_d_of_type_Boolean = true;
      this.jdField_j_of_type_Int += i1;
      this.jdField_k_of_type_Int += i2;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList mFriendSize=" + i1 + "mTroopSize=" + i2);
      }
    } while (i1 + i2 == 0);
    Object localObject;
    if (i1 + i2 > 10) {
      if ((i1 >= 5) && (i2 >= 5))
      {
        localObject = new ArrayList(b(this.jdField_a_of_type_JavaUtilList, 5));
        ArrayList localArrayList = new ArrayList(a(this.jdField_b_of_type_JavaUtilList, 5));
        a(this.jdField_d_of_type_JavaUtilList, (List)localObject);
        a(this.jdField_d_of_type_JavaUtilList, localArrayList);
        label360:
        localObject = this.jdField_d_of_type_JavaUtilList.iterator();
        i1 = 0;
        label372:
        if (!((Iterator)localObject).hasNext()) {
          break label508;
        }
        if (!a((atha)((Iterator)localObject).next())) {
          break label620;
        }
        i1 += 1;
      }
    }
    label620:
    for (;;)
    {
      break label372;
      if (i1 < 5)
      {
        this.jdField_d_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
        localObject = new ArrayList(a(this.jdField_b_of_type_JavaUtilList, 10 - this.jdField_a_of_type_JavaUtilList.size()));
        a(this.jdField_d_of_type_JavaUtilList, (List)localObject);
        break label360;
      }
      if (i2 >= 5) {
        break label360;
      }
      localObject = new ArrayList(b(this.jdField_a_of_type_JavaUtilList, 10 - this.jdField_b_of_type_JavaUtilList.size()));
      a(this.jdField_d_of_type_JavaUtilList, (List)localObject);
      break label360;
      label508:
      i2 = 0;
      label510:
      if ((i2 >= i1) || (!a())) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList size=" + this.jdField_d_of_type_JavaUtilList.size());
        }
        this.jdField_i_of_type_Boolean = true;
        if (this.jdField_c_of_type_Int <= 0) {
          break;
        }
        a(false, this.jdField_c_of_type_Int, false);
        return;
        i2 += 1;
        break label510;
        a(this.jdField_d_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
        a(this.jdField_d_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      }
    }
  }
  
  private void o()
  {
    ((FriendListHandler)this.app.a(1)).a(this.jdField_f_of_type_JavaLangString, 3021, 0, "");
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      addObserver(this.jdField_a_of_type_Aocj);
      addObserver(this.jdField_a_of_type_Aoau);
    }
    addObserver(this.jdField_a_of_type_Anyu);
    addObserver(this.jdField_a_of_type_Aocw);
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      removeObserver(this.jdField_a_of_type_Aocj);
      removeObserver(this.jdField_a_of_type_Aoau);
    }
    removeObserver(this.jdField_a_of_type_Anyu);
    removeObserver(this.jdField_a_of_type_Aocw);
  }
  
  private void r()
  {
    if ((!this.app.d()) && (!this.app.q()) && (!this.app.r()) && (this.app.s()) && (this.jdField_m_of_type_Boolean)) {
      bhkm.b(2131230745, false);
    }
  }
  
  private void s()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "clearSystemMsgData");
      }
      this.jdField_a_of_type_Ajka.g();
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "findReplaceData ");
    }
    atha localatha2 = d();
    atha localatha3 = f();
    atha localatha1 = c();
    atha localatha4 = e();
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() < 10) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "findReplaceData friend count=" + this.jdField_a_of_type_JavaUtilList.size() + "troop count" + this.jdField_b_of_type_JavaUtilList.size());
      }
    }
    label198:
    for (;;)
    {
      return;
      if (localatha3 != null) {
        localatha1 = localatha3;
      }
      for (;;)
      {
        if (localatha1 == null) {
          break label198;
        }
        this.jdField_d_of_type_JavaUtilList.add(localatha1);
        if (this.jdField_d_of_type_JavaUtilList.size() != this.jdField_c_of_type_Int + 1) {
          break;
        }
        a(true, this.jdField_c_of_type_Int, false);
        return;
        if (localatha2 != null) {
          localatha1 = localatha2;
        } else if ((localatha4 == null) && (localatha1 == null)) {
          localatha1 = null;
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() < this.jdField_d_of_type_JavaUtilList.size()) {}
    for (int i1 = (this.jdField_d_of_type_JavaUtilList.size() - this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) * 500 + 2500;; i1 = 2000)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getReplaceDelay=" + i1);
      }
      return i1;
    }
  }
  
  public int a(long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    return jdField_a_of_type_JavaUtilCalendar.get(11);
  }
  
  public String a(int paramInt)
  {
    Groups localGroups = ((anyw)this.app.getManager(51)).a(paramInt + "");
    if (localGroups != null) {
      return localGroups.group_name;
    }
    return "";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, from_type=" + this.jdField_b_of_type_Int + ", fromTroopUin=" + this.jdField_d_of_type_JavaLangString);
    }
    aocv localaocv = (aocv)this.app.a(57);
    if ((localaocv == null) || (this.jdField_a_of_type_Aoat == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, getBusinessHandler==null");
      }
      return;
    }
    if (!bhnv.d(this))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.app.getApplication(), 2131693965, 0).b(getTitleBarHeight());
      return;
    }
    ThreadManager.post(new Face2FaceAddFriendActivity.1(this, localaocv), 8, null, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_i_of_type_Boolean)
    {
      if (this.jdField_j_of_type_Boolean == true) {
        this.jdField_j_of_type_Boolean = false;
      }
      this.jdField_i_of_type_Boolean = false;
      a(false, this.jdField_c_of_type_Int, false);
    }
    do
    {
      return;
      if ((paramInt == 1) && (this.jdField_j_of_type_Boolean))
      {
        this.jdField_a_of_type_Atgh.sendEmptyMessageDelayed(3, 0L);
        return;
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_Atgh.sendEmptyMessageDelayed(8, 0L);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i2 = a(paramLong1);
    int i3 = (int)((paramLong1 - paramLong2) / 1000L / 60L);
    int i1;
    if ((i2 >= 5) && (i2 < 11))
    {
      i1 = 4;
      if (i3 < 6) {
        break label300;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (i1)
      {
      default: 
        label84:
        this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new atfv(this));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "startBkAnim 本次进入时间点：" + i2 + "和上一次时间差" + i3 + "小时");
      }
      return;
      if ((i2 >= 11) && (i2 < 17))
      {
        i1 = 1;
        break;
      }
      if ((i2 >= 17) && (i2 < 23))
      {
        i1 = 2;
        break;
      }
      i1 = 3;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840085);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840084);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840084);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840086);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840086);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840083);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840083);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840085);
      break label84;
      label300:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      switch (i1)
      {
      default: 
        break;
      case 1: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840084);
        break;
      case 2: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840086);
        break;
      case 3: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840083);
        break;
      case 4: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840085);
      }
    }
  }
  
  public void a(atgx paramatgx)
  {
    if (paramatgx == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteGroupData mhasShowList = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramatgx))
    {
      this.jdField_a_of_type_Atgi.a(paramatgx, true);
      String str = paramatgx.jdField_e_of_type_JavaLangString + "_" + paramatgx.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Atgi.a(str);
      this.jdField_d_of_type_JavaUtilList.remove(paramatgx);
      this.jdField_b_of_type_JavaUtilList.remove(paramatgx);
      if (this.jdField_c_of_type_Int > 0) {
        this.jdField_c_of_type_Int -= 1;
      }
      t();
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramatgx);
  }
  
  public void a(atha paramatha)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 14;
    localMessage.obj = paramatha;
    this.jdField_a_of_type_Atgh.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void a(atha paramatha, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onADDShowData isPush" + paramBoolean1 + "currentFriendIndex=" + this.jdField_c_of_type_Int + "isFilterShow=hasFriend=" + paramBoolean2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramatha);
  }
  
  public void a(athb paramathb)
  {
    if ((this.jdField_a_of_type_Atgi == null) || (paramathb == null)) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_Atgi.a(paramathb.jdField_e_of_type_JavaLangString);
    } while (localObject1 == null);
    Object localObject2 = getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject2).widthPixels / 2;
    int i2 = ((View)localObject1).getLeft();
    int i3 = ((View)localObject1).getWidth() / 2;
    int i4 = ((DisplayMetrics)localObject2).heightPixels / 2;
    int i5 = ((View)localObject1).getTop();
    int i6 = ((View)localObject1).getHeight() / 2;
    localObject2 = new TranslateAnimation(0.0F, i1 - i2 - i3, 0.0F, i4 - i5 - i6);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(1000L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new atfz(this, (View)localObject1));
    ((View)localObject1).setClickable(false);
    ((View)localObject1).startAnimation(localAnimationSet);
    Object localObject1 = Message.obtain();
    ((Message)localObject1).what = 15;
    ((Message)localObject1).obj = paramathb;
    this.jdField_a_of_type_Atgh.sendMessageDelayed((Message)localObject1, 1500L);
  }
  
  public void a(List<atha> paramList1, List<atha> paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      atha localatha = (atha)paramList2.next();
      if (!paramList1.contains(localatha)) {
        paramList1.add(localatha);
      }
    }
  }
  
  public boolean a()
  {
    atha localatha2;
    int i1;
    label168:
    do
    {
      atha localatha1;
      do
      {
        Iterator localIterator1 = this.jdField_d_of_type_JavaUtilList.iterator();
        break label168;
        break label168;
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          do
          {
            do
            {
              if (!localIterator1.hasNext()) {
                break label247;
              }
              localatha1 = (atha)localIterator1.next();
              if ((localatha1.jdField_a_of_type_Int != 1) || (!b(localatha1.jdField_e_of_type_JavaLangString))) {
                break;
              }
              localIterator2 = this.jdField_b_of_type_JavaUtilList.iterator();
            } while (!localIterator2.hasNext());
            localatha2 = (atha)localIterator2.next();
            if ((this.jdField_d_of_type_JavaUtilList.contains(localatha2)) || (a(localatha2.jdField_e_of_type_JavaLangString))) {
              break;
            }
            i1 = this.jdField_d_of_type_JavaUtilList.indexOf(localatha1);
            if (i1 == -1) {
              break;
            }
            this.jdField_d_of_type_JavaUtilList.set(i1, localatha2);
            return true;
          } while ((localatha1.jdField_a_of_type_Int != 2) || (!a(localatha1.jdField_e_of_type_JavaLangString)));
          localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        localatha2 = (atha)localIterator2.next();
      } while ((this.jdField_d_of_type_JavaUtilList.contains(localatha2)) || (b(localatha2.jdField_e_of_type_JavaLangString)));
      i1 = this.jdField_d_of_type_JavaUtilList.indexOf(localatha1);
    } while (i1 == -1);
    this.jdField_d_of_type_JavaUtilList.set(i1, localatha2);
    return true;
    label247:
    return false;
  }
  
  public boolean a(atha paramatha, List<atha> paramList)
  {
    boolean bool = false;
    if (paramList.contains(paramatha))
    {
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramatha.jdField_e_of_type_JavaLangString))) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "datalist has contains data" + paramatha.jdField_e_of_type_JavaLangString.substring(0, 4));
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager != null) {}
    for (paramString = localTroopManager.b(paramString + "");; paramString = null)
    {
      if (paramString != null) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void addObserver(anui paramanui)
  {
    if (this.app != null) {
      this.app.addObserver(paramanui);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "closeFace2faceTroop, from_type=" + this.jdField_b_of_type_Int + ", fromTroopUin=" + this.jdField_d_of_type_JavaLangString);
    }
    aocv localaocv = (aocv)this.app.a(57);
    if (localaocv == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "closeFace2faceTroop, getBusinessHandler==null");
      }
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
    } while (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString));
    try
    {
      localaocv.a(Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), 1);
      return;
    }
    catch (Exception localException)
    {
      return;
    }
    localException.a(0L, 1);
  }
  
  public void b(atha paramatha)
  {
    if ((this.jdField_a_of_type_Atgi == null) || (paramatha == null) || (this.jdField_a_of_type_Atgh == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Atgh.removeMessages(14, paramatha);
      paramatha = this.jdField_a_of_type_Atgi.a(paramatha.jdField_e_of_type_JavaLangString);
    } while (paramatha == null);
    paramatha.setAnimation(new AlphaAnimation(1.0F, 1.0F));
  }
  
  public void b(atha paramatha, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_c_of_type_Int += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInAnimEnd isPush" + paramBoolean1 + "currentFriendIndex=" + this.jdField_c_of_type_Int + "isFilterShow=hasFriend=" + paramBoolean2);
    }
    a(paramBoolean1, this.jdField_c_of_type_Int, false);
    if (this.jdField_b_of_type_Int == 1) {
      a(paramatha);
    }
  }
  
  public void c()
  {
    this.jdField_l_of_type_Boolean = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      localObject = LayoutInflater.from(getApplicationContext());
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559169, null);
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378938);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379319));
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366214);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(localView);
      localObject = ((LayoutInflater)localObject).inflate(2131559167, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379317));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369050);
      ((TextView)localObject).setOnClickListener(this);
      ((TextView)localObject).setOnTouchListener(this);
      ((TextView)localObject).setPadding(((TextView)localObject).getPaddingLeft(), 0, ((TextView)localObject).getPaddingRight(), 0);
      this.jdField_a_of_type_Atgy = new atgy(this, this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atgy.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Atgy.getCount()));
      localObject = AnimationUtils.loadAnimation(this, 2130771979);
      this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void c(atha paramatha)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramatha)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramatha);
    }
  }
  
  public void d()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130771978);
    localAnimation.setAnimationListener(new atfw(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    e();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramInt1 = paramIntent.getByteExtra("result", (byte)0);
    this.jdField_l_of_type_Int = paramInt1;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramInt1));
    this.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_e_of_type_JavaLangString, Integer.valueOf(this.jdField_l_of_type_Int));
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView != null) && (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.b();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView != null) && (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.b();
      return;
    }
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      d();
      return;
    }
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Boolean))
    {
      bhlq.a(this, 230, getString(2131718699), getString(2131691949), 2131690580, 2131691895, new atfl(this), new atfm(this)).show();
      return;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoTitle(2131558949);
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    paramBundle = getIntent();
    String str = paramBundle.getStringExtra("options");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(str);
        this.jdField_b_of_type_Int = paramBundle.optInt("activity_from_type");
        this.jdField_d_of_type_JavaLangString = paramBundle.optString("activity_troop_uin");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnCreate, from_type=" + this.jdField_b_of_type_Int + ", fromTroopUin=" + this.jdField_d_of_type_JavaLangString);
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131376925));
        this.jdField_a_of_type_Aoat = ((aoat)this.app.a(3));
        jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
        l();
        p();
        this.jdField_a_of_type_Ajka = ((ajka)this.app.getManager(34));
        AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this);
        if (AppNetConnInfo.getConnInfo() == -1) {
          QQToast.a(this.app.getApplication(), 2131693965, 0).b(getTitleBarHeight());
        }
        if (this.jdField_a_of_type_Ajka.c() != 0) {
          break label279;
        }
        this.jdField_e_of_type_Boolean = true;
        if (!b()) {
          break;
        }
        this.jdField_n_of_type_Boolean = false;
        return true;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("activity_from_type", 0);
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("activity_troop_uin");
      continue;
      label279:
      this.jdField_e_of_type_Boolean = false;
    }
    j();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    q();
    s();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Face2FaceAddFriendActivity doOnDestroy");
    }
    this.p = true;
    atgp.jdField_c_of_type_Long = System.currentTimeMillis();
    b();
    this.jdField_a_of_type_Atgh.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Atgh.removeMessages(5);
    this.jdField_a_of_type_Atgh.removeMessages(7);
    this.jdField_a_of_type_Atgh.removeMessages(9);
    this.jdField_a_of_type_Atgh.removeMessages(4);
    this.jdField_a_of_type_Atgh.removeMessages(11);
    if (this.jdField_a_of_type_Aoat != null) {
      this.jdField_a_of_type_Aoat.a(this.app.getCurrentAccountUin());
    }
    for (;;)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this);
      this.jdField_a_of_type_Atgi.a();
      if (this.jdField_g_of_type_Boolean) {
        bdll.b(null, "CliOper", "", "", "0X80050F2", "0X80050F2", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Atgy != null) {
        this.jdField_a_of_type_Atgy.c();
      }
      bdll.b(null, "CliOper", "", "", "0X80050EC", "0X80050EC", 0, 0, String.valueOf(this.jdField_j_of_type_Int), String.valueOf(this.jdField_k_of_type_Int), "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestroy mLbsHandler is null");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnPause!");
    }
    this.jdField_m_of_type_Boolean = false;
    bhkm.a(this, false);
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnResume!");
    }
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(-16777216);
      this.mSystemBarComp.setStatusBarColor(-16777216);
    }
    this.jdField_m_of_type_Boolean = true;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    bhkm.a(this, true);
    g();
    f();
    atgp.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "face2face doOnStart inface2faceTime=" + a(atgp.jdField_a_of_type_Long) + "showBkAnim=" + this.jdField_n_of_type_Boolean);
    }
    if (this.jdField_n_of_type_Boolean)
    {
      if (atgp.jdField_a_of_type_Long >= atgp.jdField_b_of_type_Long) {
        a(atgp.jdField_a_of_type_Long, atgp.jdField_b_of_type_Long);
      }
    }
    else {
      return;
    }
    a(atgp.jdField_a_of_type_Long, 0L);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnStop!");
    }
    h();
    this.jdField_a_of_type_Atgh.removeMessages(4);
    atgp.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "face2face doOnStop outface2faceTime=" + a(atgp.jdField_b_of_type_Long));
    }
  }
  
  public void e()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.valueOf(i1));
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Int != 1) {
      return;
    }
    this.jdField_a_of_type_Atgh.removeMessages(9);
    long l1 = SystemClock.elapsedRealtime() - this.jdField_c_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("time_tick", 2, "checkTroopShareValidity, durition=" + l1 + ", mInitTroopShareTimeStamp=" + this.jdField_c_of_type_Long);
    }
    if (l1 >= 1200000L)
    {
      bhlq.a(this, 230, getString(2131718699), "此次分享已满20分钟", 2131690580, 2131691895, new atga(this), null).show();
      return;
    }
    this.jdField_a_of_type_Atgh.sendEmptyMessageDelayed(9, 10000L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Atgh.a(100L);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("snow", 2, "stopSnow");
    }
    this.jdField_a_of_type_Atgh.removeMessages(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Atgh.sendEmptyMessageDelayed(8, 0L);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i1 != 2131366271) {
        if (i1 == 2131377831)
        {
          doOnBackPressed();
        }
        else if ((i1 == 2131377832) || (i1 == 2131364919) || (i1 == 2131364922) || (i1 == 2131364921))
        {
          if (this.jdField_b_of_type_Int == 1) {
            c();
          }
        }
        else if (i1 == 2131369050)
        {
          if (this.jdField_b_of_type_Int == 1) {
            d();
          }
        }
        else
        {
          Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)paramView;
          Object localObject2;
          Object localObject1;
          if (localFace2FaceFriendBubbleView.a() == 1)
          {
            String str = localFace2FaceFriendBubbleView.b();
            if (TextUtils.isEmpty(str))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleview uin is null");
              }
            }
            else
            {
              this.jdField_g_of_type_JavaLangString = str;
              if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "showdetail 进入详情页mShowDetailUin=" + this.jdField_g_of_type_JavaLangString.substring(0, 4));
              }
              localObject2 = this.app.a(str, (byte)3, true);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = bhmq.a();
              }
              localObject2 = (athc)localFace2FaceFriendBubbleView.a();
              if (localObject2 == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleview nearbyUser is null");
                }
              }
              else
              {
                if (((athc)localObject2).jdField_a_of_type_JavaLangString.equals("")) {}
                for (localObject2 = ((athc)localObject2).jdField_b_of_type_JavaLangString;; localObject2 = ((athc)localObject2).jdField_a_of_type_JavaLangString)
                {
                  a(localFace2FaceFriendBubbleView.b(), str, localFace2FaceFriendBubbleView, (String)localObject2, (Bitmap)localObject1);
                  bdll.b(null, "CliOper", "", "", "0X80050ED", "0X80050ED", 0, 0, "", "", "", "");
                  if (this.jdField_b_of_type_Int != 1) {
                    break;
                  }
                  bdll.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_detail", 0, 0, this.jdField_d_of_type_JavaLangString, "", "", "");
                  break;
                }
              }
            }
          }
          else if (localFace2FaceFriendBubbleView.a() == 2)
          {
            localObject1 = localFace2FaceFriendBubbleView.a();
            if (localObject1 != null)
            {
              this.jdField_f_of_type_JavaLangString = ((atha)localObject1).jdField_e_of_type_JavaLangString;
              this.jdField_g_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
              localObject2 = new atfn(this, (atha)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setBindData((atha)localObject1, (View.OnClickListener)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(this.jdField_a_of_type_AndroidWidgetFrameLayout, localFace2FaceFriendBubbleView);
              if (this.jdField_b_of_type_Int == 1) {
                b((atha)localObject1);
              }
            }
            bdll.b(null, "CliOper", "", "", "0X80050EE", "0X80050EE", 0, 0, "", "", "", "");
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
  
  public void onNetMobile2None()
  {
    this.jdField_a_of_type_Atgh.sendEmptyMessage(18);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a();
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetWifi2None");
    }
    this.jdField_a_of_type_Atgh.sendEmptyMessage(18);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      paramView = (TextView)paramView;
      if (paramMotionEvent.getAction() == 0) {
        paramView.setTextColor(getResources().getColor(2131166943));
      } else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setTextColor(getResources().getColor(2131167302));
      }
    }
  }
  
  public void removeObserver(anui paramanui)
  {
    if (this.app != null) {
      this.app.removeObserver(paramanui);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity
 * JD-Core Version:    0.7.0.1
 */