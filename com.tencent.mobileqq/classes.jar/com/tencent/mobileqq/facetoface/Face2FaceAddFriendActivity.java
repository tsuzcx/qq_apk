package com.tencent.mobileqq.facetoface;

import acah;
import acai;
import acal;
import acam;
import acan;
import acao;
import acap;
import acaq;
import acar;
import acas;
import acat;
import acau;
import acav;
import acaw;
import acax;
import acaz;
import acba;
import acbb;
import acbc;
import acbd;
import acbh;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.NearFieldTroopObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  implements View.OnClickListener, View.OnTouchListener, Face2FaceAddFriendAnim.CompassAnimationEnd, INetInfoHandler
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
  private acbh jdField_a_of_type_Acbh = new acbh(this);
  public Point a;
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public EditText a;
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new acbd(this);
  public LBSHandler a;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new acbb(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new acbc(this);
  private NearFieldTroopObserver jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopObserver = new acai(this);
  public NewFriendManager a;
  public Face2FaceAddFriendAnim a;
  protected Face2FaceDetailBaseView.IFace2faceContext a;
  public Face2FaceFriendDetailView a;
  public Face2FaceTroopDetailView a;
  public Face2FaceTroopFriendListAdapter a;
  public SnowView a;
  public QQProgressDialog a;
  public XListView a;
  public ArrayList a;
  public HashMap a;
  public List a;
  public CopyOnWriteArrayList a;
  public boolean a;
  public int b;
  public long b;
  protected View b;
  ImageView b;
  public LinearLayout b;
  public TextView b;
  public HashMap b;
  public List b;
  public boolean b;
  public int c;
  protected long c;
  protected View c;
  protected TextView c;
  public HashMap c;
  public List c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 0L;
  protected View d;
  protected TextView d;
  public String d;
  public List d;
  public boolean d;
  public int e;
  long e;
  protected TextView e;
  public String e;
  public List e;
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
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext = new acat(this);
  }
  
  private int a(Face2FaceUserData paramFace2FaceUserData)
  {
    return this.jdField_d_of_type_JavaUtilList.indexOf(paramFace2FaceUserData);
  }
  
  private Face2FaceFriendBubbleView a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)localIterator.next();
      if ((paramString.equals(localFace2FaceFriendBubbleView.b())) && (localFace2FaceFriendBubbleView.a() == paramInt)) {
        return localFace2FaceFriendBubbleView;
      }
    }
    return null;
  }
  
  private Face2FaceUserData a()
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData正在查看详情Uin" + this.jdField_g_of_type_JavaLangString.substring(0, 4));
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    Face2FaceUserData localFace2FaceUserData;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localFace2FaceUserData = (Face2FaceUserData)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (localFace2FaceUserData.jdField_e_of_type_JavaLangString.equals(this.jdField_g_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData需要替换但是正在查看详情");
          }
        }
        else if ((localFace2FaceUserData.jdField_a_of_type_Int == 1) && (b(localFace2FaceUserData.jdField_e_of_type_JavaLangString)))
        {
          localObject = localFace2FaceUserData;
          if (QLog.isColorLevel())
          {
            localObject = localFace2FaceUserData;
            if (!TextUtils.isEmpty(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData可替换好友" + localFace2FaceUserData.jdField_e_of_type_JavaLangString.substring(0, 4));
            }
          }
        }
      }
    }
    for (localObject = localFace2FaceUserData;; localObject = null)
    {
      if ((localObject == null) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData 没有可替换好友");
      }
      return localObject;
    }
  }
  
  private List a(List paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt < 1)) {
      return localArrayList;
    }
    Object localObject = paramList.iterator();
    do
    {
      Face2FaceUserData localFace2FaceUserData;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localFace2FaceUserData = (Face2FaceUserData)((Iterator)localObject).next();
      } while (a(localFace2FaceUserData.jdField_e_of_type_JavaLangString));
      localArrayList.add(localFace2FaceUserData);
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
          localObject = (Face2FaceUserData)paramList.next();
        } while (!a(((Face2FaceUserData)localObject).jdField_e_of_type_JavaLangString));
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
    Face2FaceUserData localFace2FaceUserData2 = d();
    Face2FaceUserData localFace2FaceUserData1 = f();
    if (paramInt == 1) {
      if (localFace2FaceUserData2 != null)
      {
        localFace2FaceUserData1 = localFace2FaceUserData2;
        if (localFace2FaceUserData1 == null) {
          break label125;
        }
        e(localFace2FaceUserData1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyNeedReplace replaceData type" + localFace2FaceUserData1.jdField_a_of_type_Int);
        }
      }
    }
    label125:
    while (!QLog.isColorLevel())
    {
      return;
      if (localFace2FaceUserData1 != null)
      {
        break;
        if (localFace2FaceUserData1 != null) {
          break;
        }
        localFace2FaceUserData1 = localFace2FaceUserData2;
        if (localFace2FaceUserData2 != null) {
          break;
        }
      }
      localFace2FaceUserData1 = null;
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
      localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364593);
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364594);
      localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364602);
      if (paramInt == 3)
      {
        this.jdField_f_of_type_Boolean = true;
        a(localTextView, "请求添加你为好友");
        a(localButton, "同意并加为好友");
        localButton.setOnClickListener(new acas(this, paramString));
        return;
      }
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          paramString = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (!TextUtils.isEmpty(paramString)) {
            ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364592)).setText(paramString);
          }
        }
        a(localTextView, "已经是你的好友");
        localLinearLayout.setVisibility(8);
        return;
      }
    } while (paramInt != 4);
    a(localTextView, "等待好友确认");
    a(localButton, "加好友");
  }
  
  private void a(int paramInt, String paramString1, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString2, Bitmap paramBitmap)
  {
    this.jdField_e_of_type_JavaLangString = paramString1;
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364594);
    a((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364592), paramString2);
    ((ImageView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364590)).setImageBitmap(paramBitmap);
    paramBitmap = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364593);
    Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364602);
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new acao(this));
    localButton.setOnClickListener(new acap(this, paramString1));
    if (paramInt == 2)
    {
      a(paramBitmap, "已经是你的好友");
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = new acar(this, paramString1);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, paramFace2FaceFriendBubbleView, paramString1, this.jdField_a_of_type_JavaUtilHashMap, paramString2);
      return;
      if ((paramInt == 4) || (paramInt == 1))
      {
        if (paramInt == 4) {
          a(paramBitmap, "等待好友确认中...");
        }
        for (;;)
        {
          a(localButton, "加好友");
          localLinearLayout.setVisibility(0);
          break;
          a(paramBitmap, "");
        }
      }
      if (paramInt == 3)
      {
        this.jdField_f_of_type_Boolean = true;
        a(paramBitmap, "请求添加你为好友");
        localLinearLayout.setVisibility(0);
        a(localButton, "同意并加为好友");
        localButton.setOnClickListener(new acaq(this, paramString1));
      }
    }
  }
  
  private void a(long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_Acbh.obtainMessage(7);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendDelayAskRequest delaytime=" + paramLong);
    }
    this.jdField_a_of_type_Acbh.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.setContentDescription(paramString);
  }
  
  private void a(String paramString)
  {
    new ArrayList();
    Object localObject = this.app.a().b(AppConstants.K, 0);
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
      FriendSystemMsgController.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l1);
      FriendSystemMsgController.a().a(paramLong);
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
        Message localMessage = this.jdField_a_of_type_Acbh.obtainMessage();
        localMessage.what = 4;
        Object localObject = new Bundle();
        ((Bundle)localObject).putBoolean("key_data _ispush", paramBoolean1);
        ((Bundle)localObject).putBoolean("key_data _hasfriend", paramBoolean2);
        localMessage.setData((Bundle)localObject);
        localMessage.arg1 = paramInt;
        localObject = (Face2FaceUserData)this.jdField_d_of_type_JavaUtilList.get(paramInt);
        localMessage.arg2 = ((Face2FaceUserData)localObject).jdField_a_of_type_Int;
        localMessage.obj = localObject;
        if (this.jdField_a_of_type_Acbh.hasMessages(4)) {
          this.jdField_a_of_type_Acbh.removeMessages(4);
        }
        this.jdField_a_of_type_Acbh.sendMessageDelayed(localMessage, jdField_g_of_type_Int);
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
      QQToast.a(this, 2131434411, 0).b(getTitleBarHeight());
      return false;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
        if (localFriendsManager != null)
        {
          paramString = localFriendsManager.c(paramString);
          if ((paramString == null) || (paramString.groupid < 0)) {
            break;
          }
          QQToast.a(this.app.getApplication(), 2131434412, 0).b(getTitleBarHeight());
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
      paramString = null;
    }
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this.app.getApplication(), 2131434794, 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  private boolean a(Face2FaceUserData paramFace2FaceUserData)
  {
    if (paramFace2FaceUserData == null) {}
    while (((paramFace2FaceUserData.jdField_a_of_type_Int != 1) || (!b(paramFace2FaceUserData.jdField_e_of_type_JavaLangString))) && ((paramFace2FaceUserData.jdField_a_of_type_Int != 2) || (!a(paramFace2FaceUserData.jdField_e_of_type_JavaLangString)))) {
      return false;
    }
    return true;
  }
  
  private Face2FaceUserData b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a()) || (!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a.equals(localFace2FaceUserData)))
      {
        if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localFace2FaceUserData))) {
          return localFace2FaceUserData;
        }
        if ((localFace2FaceUserData.jdField_a_of_type_Int == 2) && (a(localFace2FaceUserData.jdField_e_of_type_JavaLangString))) {
          return localFace2FaceUserData;
        }
      }
    }
    return null;
  }
  
  private List b(List paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt < 1)) {
      return localArrayList;
    }
    Object localObject = paramList.iterator();
    do
    {
      Face2FaceUserData localFace2FaceUserData;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localFace2FaceUserData = (Face2FaceUserData)((Iterator)localObject).next();
      } while (b(localFace2FaceUserData.jdField_e_of_type_JavaLangString));
      localArrayList.add(localFace2FaceUserData);
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
          localObject = (Face2FaceUserData)paramList.next();
        } while (!b(((Face2FaceUserData)localObject).jdField_e_of_type_JavaLangString));
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
    Object localObject = LayoutInflater.from(getApplicationContext()).inflate(2130968813, null);
    Button localButton = (Button)((View)localObject).findViewById(2131363861);
    ((View)localObject).setBackgroundResource(2130839050);
    ((View)localObject).setOnClickListener(this);
    if (this.jdField_b_of_type_Int == 1) {
      ((TextView)((View)localObject).findViewById(2131363860)).setText(2131430543);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1));
    localButton.setOnClickListener(new acax(this, str, (View)localObject));
    return true;
  }
  
  private boolean b(String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    if ((localFriendsManager != null) && (!TextUtils.isEmpty(paramString))) {
      return localFriendsManager.b(paramString);
    }
    return false;
  }
  
  private Face2FaceUserData c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (b(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
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
  
  private Face2FaceUserData d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (!b(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private void d(Face2FaceUserData paramFace2FaceUserData)
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (paramFace2FaceUserData == null)) {
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
              QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.jdField_c_of_type_Int + "showtype=pushData.type=" + paramFace2FaceUserData.jdField_a_of_type_Int + "mFriendDataList.size()" + this.jdField_a_of_type_JavaUtilList.size() + "troop size" + this.jdField_b_of_type_JavaUtilList.size());
            }
          } while (this.jdField_d_of_type_JavaUtilList.contains(paramFace2FaceUserData));
          if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI face2FaceAddFriendAnim has null");
        return;
        if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() <= 10) {
          break;
        }
      } while (a(paramFace2FaceUserData));
      if (this.jdField_b_of_type_Int == 0)
      {
        e(paramFace2FaceUserData);
        this.jdField_g_of_type_Boolean = true;
        return;
      }
      e(paramFace2FaceUserData);
      return;
      if ((this.jdField_d_of_type_JavaUtilList.size() == 0) && (!this.jdField_i_of_type_Boolean))
      {
        this.jdField_d_of_type_JavaUtilList.add(paramFace2FaceUserData);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.jdField_c_of_type_Int + "hasData" + this.jdField_i_of_type_Boolean);
        }
        this.jdField_i_of_type_Boolean = true;
        return;
      }
      this.jdField_d_of_type_JavaUtilList.add(paramFace2FaceUserData);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.jdField_c_of_type_Int);
      }
    } while (this.jdField_d_of_type_JavaUtilList.size() != this.jdField_c_of_type_Int + 1);
    a(true, this.jdField_c_of_type_Int, false);
  }
  
  private Face2FaceUserData e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (a(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private void e(Face2FaceUserData paramFace2FaceUserData)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    int i2 = 0;
    int i1 = 0;
    if (((Iterator)localObject1).hasNext())
    {
      int i3;
      if (((Face2FaceUserData)((Iterator)localObject1).next()).jdField_a_of_type_Int == 1)
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
    if (paramFace2FaceUserData.jdField_a_of_type_Int == 1)
    {
      if (localObject1 != null) {}
      label264:
      for (;;)
      {
        label153:
        if (localObject1 != null)
        {
          localObject2 = ((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString;
          if ((localObject1 instanceof Face2FaceGroupProfile)) {
            localObject2 = ((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString + "_" + ((Face2FaceGroupProfile)localObject1).jdField_b_of_type_JavaLangString;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToReplace rRplaceData!=null && replace type=" + ((Face2FaceUserData)localObject1).jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a((String)localObject2);
          if (this.jdField_b_of_type_Int == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a((Face2FaceUserData)localObject1, bool);
            i1 = a((Face2FaceUserData)localObject1);
            if ((i1 == -1) || (i1 >= this.jdField_d_of_type_JavaUtilList.size())) {
              break;
            }
            this.jdField_d_of_type_JavaUtilList.set(i1, paramFace2FaceUserData);
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
            localObject1 = (Face2FaceUserData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i1);
            if ((localObject1 == null) || (((Face2FaceUserData)localObject1).jdField_a_of_type_Int != 2) || (a(((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString))) {
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
        localObject1 = (Face2FaceUserData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i1);
        if ((localObject1 != null) && (((Face2FaceUserData)localObject1).jdField_a_of_type_Int == 1) && (!b(((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString))) {}
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
  
  private Face2FaceUserData f()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (!a(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private void j()
  {
    this.jdField_n_of_type_Boolean = true;
    g();
    this.jdField_a_of_type_Acbh.sendEmptyMessageDelayed(3, 0L);
    a();
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendHeartRequest");
    }
    Message localMessage = this.jdField_a_of_type_Acbh.obtainMessage(5);
    this.jdField_a_of_type_Acbh.sendMessageDelayed(localMessage, jdField_h_of_type_Int);
  }
  
  private void l()
  {
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363836));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363837));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    m();
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView = new SnowView(this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView.setSnowView(this.jdField_a_of_type_AndroidGraphicsPoint);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView);
    localObject = getLayoutInflater();
    View localView = ((LayoutInflater)localObject).inflate(2130968990, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2130968991, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView = ((Face2FaceTroopDetailView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131364603));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView = ((Face2FaceFriendDetailView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131364588));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364597));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364600));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364599));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131364596));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new acau(this));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setInfc(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.setInfc(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363838);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363839));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363840));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131433502);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void m()
  {
    View localView = LayoutInflater.from(getApplicationContext()).inflate(2130968812, null);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim = new Face2FaceAddFriendAnim(this.app, this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(this.app, localView, this.jdField_b_of_type_Int, this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    this.jdField_d_of_type_AndroidViewView = localView;
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131363847);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363848));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363846));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131437916);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      localView.findViewById(2131363845).setOnClickListener(this);
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
        if (!a((Face2FaceUserData)((Iterator)localObject).next())) {
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
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopObserver);
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopObserver);
  }
  
  private void r()
  {
    if ((!this.app.c()) && (!this.app.k()) && (!this.app.l()) && (this.app.m()) && (this.jdField_m_of_type_Boolean)) {
      AudioUtil.b(2131230744, false);
    }
  }
  
  private void s()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "clearSystemMsgData");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.e();
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "findReplaceData ");
    }
    Face2FaceUserData localFace2FaceUserData2 = d();
    Face2FaceUserData localFace2FaceUserData3 = f();
    Face2FaceUserData localFace2FaceUserData1 = c();
    Face2FaceUserData localFace2FaceUserData4 = e();
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() < 10) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "findReplaceData friend count=" + this.jdField_a_of_type_JavaUtilList.size() + "troop count" + this.jdField_b_of_type_JavaUtilList.size());
      }
    }
    label198:
    for (;;)
    {
      return;
      if (localFace2FaceUserData3 != null) {
        localFace2FaceUserData1 = localFace2FaceUserData3;
      }
      for (;;)
      {
        if (localFace2FaceUserData1 == null) {
          break label198;
        }
        this.jdField_d_of_type_JavaUtilList.add(localFace2FaceUserData1);
        if (this.jdField_d_of_type_JavaUtilList.size() != this.jdField_c_of_type_Int + 1) {
          break;
        }
        a(true, this.jdField_c_of_type_Int, false);
        return;
        if (localFace2FaceUserData2 != null) {
          localFace2FaceUserData1 = localFace2FaceUserData2;
        } else if ((localFace2FaceUserData4 == null) && (localFace2FaceUserData1 == null)) {
          localFace2FaceUserData1 = null;
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
    Groups localGroups = ((FriendsManager)this.app.getManager(50)).a(paramInt + "");
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
    NearFieldTroopHandler localNearFieldTroopHandler = (NearFieldTroopHandler)this.app.a(57);
    if ((localNearFieldTroopHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, getBusinessHandler==null");
      }
      return;
    }
    if (!NetworkUtil.d(this))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.app.getApplication(), 2131434794, 0).b(getTitleBarHeight());
      return;
    }
    ThreadManager.post(new acah(this, localNearFieldTroopHandler), 8, null, false);
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
        this.jdField_a_of_type_Acbh.sendEmptyMessageDelayed(3, 0L);
        return;
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_Acbh.sendEmptyMessageDelayed(8, 0L);
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
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new acav(this));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839050);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839049);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839049);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839051);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839051);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839048);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839048);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839050);
      break label84;
      label300:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      switch (i1)
      {
      default: 
        break;
      case 1: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839049);
        break;
      case 2: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839051);
        break;
      case 3: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839048);
        break;
      case 4: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839050);
      }
    }
  }
  
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile)
  {
    if (paramFace2FaceGroupProfile == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteGroupData mhasShowList = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramFace2FaceGroupProfile))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramFace2FaceGroupProfile, true);
      String str = paramFace2FaceGroupProfile.jdField_e_of_type_JavaLangString + "_" + paramFace2FaceGroupProfile.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(str);
      this.jdField_d_of_type_JavaUtilList.remove(paramFace2FaceGroupProfile);
      this.jdField_b_of_type_JavaUtilList.remove(paramFace2FaceGroupProfile);
      if (this.jdField_c_of_type_Int > 0) {
        this.jdField_c_of_type_Int -= 1;
      }
      t();
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramFace2FaceGroupProfile);
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 14;
    localMessage.obj = paramFace2FaceUserData;
    this.jdField_a_of_type_Acbh.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onADDShowData isPush" + paramBoolean1 + "currentFriendIndex=" + this.jdField_c_of_type_Int + "isFilterShow=hasFriend=" + paramBoolean2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramFace2FaceUserData);
  }
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim == null) || (paramFace2FaceUserProfile == null)) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramFace2FaceUserProfile.jdField_e_of_type_JavaLangString);
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
    localAnimationSet.setAnimationListener(new acaz(this, (View)localObject1));
    ((View)localObject1).setClickable(false);
    ((View)localObject1).startAnimation(localAnimationSet);
    Object localObject1 = Message.obtain();
    ((Message)localObject1).what = 15;
    ((Message)localObject1).obj = paramFace2FaceUserProfile;
    this.jdField_a_of_type_Acbh.sendMessageDelayed((Message)localObject1, 1500L);
  }
  
  public void a(List paramList1, List paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)paramList2.next();
      if (!paramList1.contains(localFace2FaceUserData)) {
        paramList1.add(localFace2FaceUserData);
      }
    }
  }
  
  public boolean a()
  {
    Face2FaceUserData localFace2FaceUserData2;
    int i1;
    label168:
    do
    {
      Face2FaceUserData localFace2FaceUserData1;
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
              localFace2FaceUserData1 = (Face2FaceUserData)localIterator1.next();
              if ((localFace2FaceUserData1.jdField_a_of_type_Int != 1) || (!b(localFace2FaceUserData1.jdField_e_of_type_JavaLangString))) {
                break;
              }
              localIterator2 = this.jdField_b_of_type_JavaUtilList.iterator();
            } while (!localIterator2.hasNext());
            localFace2FaceUserData2 = (Face2FaceUserData)localIterator2.next();
            if ((this.jdField_d_of_type_JavaUtilList.contains(localFace2FaceUserData2)) || (a(localFace2FaceUserData2.jdField_e_of_type_JavaLangString))) {
              break;
            }
            i1 = this.jdField_d_of_type_JavaUtilList.indexOf(localFace2FaceUserData1);
            if (i1 == -1) {
              break;
            }
            this.jdField_d_of_type_JavaUtilList.set(i1, localFace2FaceUserData2);
            return true;
          } while ((localFace2FaceUserData1.jdField_a_of_type_Int != 2) || (!a(localFace2FaceUserData1.jdField_e_of_type_JavaLangString)));
          localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        localFace2FaceUserData2 = (Face2FaceUserData)localIterator2.next();
      } while ((this.jdField_d_of_type_JavaUtilList.contains(localFace2FaceUserData2)) || (b(localFace2FaceUserData2.jdField_e_of_type_JavaLangString)));
      i1 = this.jdField_d_of_type_JavaUtilList.indexOf(localFace2FaceUserData1);
    } while (i1 == -1);
    this.jdField_d_of_type_JavaUtilList.set(i1, localFace2FaceUserData2);
    return true;
    label247:
    return false;
  }
  
  public boolean a(Face2FaceUserData paramFace2FaceUserData, List paramList)
  {
    boolean bool = false;
    if (paramList.contains(paramFace2FaceUserData))
    {
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramFace2FaceUserData.jdField_e_of_type_JavaLangString))) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "datalist has contains data" + paramFace2FaceUserData.jdField_e_of_type_JavaLangString.substring(0, 4));
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
    TroopManager localTroopManager = (TroopManager)this.app.getManager(51);
    if (localTroopManager != null) {}
    for (paramString = localTroopManager.a(paramString + "");; paramString = null)
    {
      if (paramString != null) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.addObserver(paramBusinessObserver);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "closeFace2faceTroop, from_type=" + this.jdField_b_of_type_Int + ", fromTroopUin=" + this.jdField_d_of_type_JavaLangString);
    }
    NearFieldTroopHandler localNearFieldTroopHandler = (NearFieldTroopHandler)this.app.a(57);
    if (localNearFieldTroopHandler == null) {
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
      localNearFieldTroopHandler.a(Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), 1);
      return;
    }
    catch (Exception localException)
    {
      return;
    }
    localException.a(0L, 1);
  }
  
  public void b(Face2FaceUserData paramFace2FaceUserData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim == null) || (paramFace2FaceUserData == null) || (this.jdField_a_of_type_Acbh == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Acbh.removeMessages(14, paramFace2FaceUserData);
      paramFace2FaceUserData = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramFace2FaceUserData.jdField_e_of_type_JavaLangString);
    } while (paramFace2FaceUserData == null);
    paramFace2FaceUserData.setAnimation(new AlphaAnimation(1.0F, 1.0F));
  }
  
  public void b(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_c_of_type_Int += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInAnimEnd isPush" + paramBoolean1 + "currentFriendIndex=" + this.jdField_c_of_type_Int + "isFilterShow=hasFriend=" + paramBoolean2);
    }
    a(paramBoolean1, this.jdField_c_of_type_Int, false);
    if (this.jdField_b_of_type_Int == 1) {
      a(paramFace2FaceUserData);
    }
  }
  
  public void c()
  {
    this.jdField_l_of_type_Boolean = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      localObject = LayoutInflater.from(getApplicationContext());
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2130968994, null);
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364613);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        localView.setPadding(0, ImmersiveUtils.a(this), 0, 0);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364615));
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364616);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(localView);
      localObject = ((LayoutInflater)localObject).inflate(2130968992, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364611));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364614);
      ((TextView)localObject).setOnClickListener(this);
      ((TextView)localObject).setOnTouchListener(this);
      ((TextView)localObject).setPadding(((TextView)localObject).getPaddingLeft(), 0, ((TextView)localObject).getPaddingRight(), 0);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter = new Face2FaceTroopFriendListAdapter(this, this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.getCount()));
      localObject = AnimationUtils.loadAnimation(this, 2131034123);
      this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void c(Face2FaceUserData paramFace2FaceUserData)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramFace2FaceUserData)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramFace2FaceUserData);
    }
  }
  
  public void d()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2131034122);
    localAnimation.setAnimationListener(new acaw(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    e();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      DialogUtil.b(this, 230, getString(2131434764), getString(2131430544), 2131432998, 2131433502, new acal(this), new acam(this)).show();
      return;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoTitle(2130968811);
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
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131362822));
        this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.app.a(3));
        jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
        l();
        p();
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.app.getManager(33));
        AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this);
        if (AppNetConnInfo.getConnInfo() == -1) {
          QQToast.a(this.app.getApplication(), 2131434794, 0).b(getTitleBarHeight());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.c() != 0) {
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    q();
    s();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Face2FaceAddFriendActivity doOnDestroy");
    }
    this.p = true;
    Face2FaceAddFriendConstants.jdField_c_of_type_Long = System.currentTimeMillis();
    b();
    this.jdField_a_of_type_Acbh.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Acbh.removeMessages(5);
    this.jdField_a_of_type_Acbh.removeMessages(7);
    this.jdField_a_of_type_Acbh.removeMessages(9);
    this.jdField_a_of_type_Acbh.removeMessages(4);
    this.jdField_a_of_type_Acbh.removeMessages(11);
    if (this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(this.app.getCurrentAccountUin());
    }
    for (;;)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a();
      if (this.jdField_g_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X80050F2", "0X80050F2", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.V_();
      }
      ReportController.b(null, "CliOper", "", "", "0X80050EC", "0X80050EC", 0, 0, String.valueOf(this.jdField_j_of_type_Int), String.valueOf(this.jdField_k_of_type_Int), "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestroy mLbsHandler is null");
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnPause!");
    }
    this.jdField_m_of_type_Boolean = false;
    AudioUtil.a(this, false);
  }
  
  protected void doOnResume()
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
  
  protected void doOnStart()
  {
    super.doOnStart();
    AudioUtil.a(this, true);
    g();
    f();
    Face2FaceAddFriendConstants.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "face2face doOnStart inface2faceTime=" + a(Face2FaceAddFriendConstants.jdField_a_of_type_Long) + "showBkAnim=" + this.jdField_n_of_type_Boolean);
    }
    if (this.jdField_n_of_type_Boolean)
    {
      if (Face2FaceAddFriendConstants.jdField_a_of_type_Long >= Face2FaceAddFriendConstants.jdField_b_of_type_Long) {
        a(Face2FaceAddFriendConstants.jdField_a_of_type_Long, Face2FaceAddFriendConstants.jdField_b_of_type_Long);
      }
    }
    else {
      return;
    }
    a(Face2FaceAddFriendConstants.jdField_a_of_type_Long, 0L);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnStop!");
    }
    h();
    this.jdField_a_of_type_Acbh.removeMessages(4);
    Face2FaceAddFriendConstants.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "face2face doOnStop outface2faceTime=" + a(Face2FaceAddFriendConstants.jdField_b_of_type_Long));
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
    this.jdField_a_of_type_Acbh.removeMessages(9);
    long l1 = SystemClock.elapsedRealtime() - this.jdField_c_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("time_tick", 2, "checkTroopShareValidity, durition=" + l1 + ", mInitTroopShareTimeStamp=" + this.jdField_c_of_type_Long);
    }
    if (l1 >= 1200000L)
    {
      DialogUtil.b(this, 230, getString(2131434764), "此次分享已满20分钟", 2131432998, 2131433502, new acba(this), null).show();
      return;
    }
    this.jdField_a_of_type_Acbh.sendEmptyMessageDelayed(9, 10000L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Acbh.a(100L);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("snow", 2, "stopSnow");
    }
    this.jdField_a_of_type_Acbh.removeMessages(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Acbh.sendEmptyMessageDelayed(8, 0L);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a()) {}
    label15:
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView;
    Object localObject;
    label358:
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            do
            {
              break label15;
              break label15;
              break label15;
              break label15;
              do
              {
                return;
              } while (i1 == 2131363859);
              if (i1 == 2131363839)
              {
                doOnBackPressed();
                return;
              }
              if ((i1 != 2131363840) && (i1 != 2131363845) && (i1 != 2131363847) && (i1 != 2131363846)) {
                break;
              }
            } while (this.jdField_b_of_type_Int != 1);
            c();
            return;
            if (i1 != 2131364614) {
              break;
            }
          } while (this.jdField_b_of_type_Int != 1);
          d();
          return;
          localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)paramView;
          if (localFace2FaceFriendBubbleView.a() != 1) {
            break label358;
          }
          str = localFace2FaceFriendBubbleView.b();
          if (!TextUtils.isEmpty(str)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleview uin is null");
        return;
        this.jdField_g_of_type_JavaLangString = str;
        if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showdetail 进入详情页mShowDetailUin=" + this.jdField_g_of_type_JavaLangString.substring(0, 4));
        }
        localObject = this.app.a(str, (byte)3, true);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = ImageUtil.a();
        }
        localObject = (NearbyUser)localFace2FaceFriendBubbleView.a();
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleview nearbyUser is null");
      return;
      if (((NearbyUser)localObject).jdField_a_of_type_JavaLangString.equals("")) {}
      for (localObject = ((NearbyUser)localObject).jdField_b_of_type_JavaLangString;; localObject = ((NearbyUser)localObject).jdField_a_of_type_JavaLangString)
      {
        a(localFace2FaceFriendBubbleView.b(), str, localFace2FaceFriendBubbleView, (String)localObject, paramView);
        ReportController.b(null, "CliOper", "", "", "0X80050ED", "0X80050ED", 0, 0, "", "", "", "");
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
        ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_detail", 0, 0, this.jdField_d_of_type_JavaLangString, "", "", "");
        return;
      }
    } while (localFace2FaceFriendBubbleView.a() != 2);
    paramView = localFace2FaceFriendBubbleView.a();
    if (paramView != null)
    {
      this.jdField_f_of_type_JavaLangString = paramView.jdField_e_of_type_JavaLangString;
      this.jdField_g_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      localObject = new acan(this, paramView);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setBindData(paramView, (View.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(this.jdField_a_of_type_AndroidWidgetFrameLayout, localFace2FaceFriendBubbleView);
      if (this.jdField_b_of_type_Int == 1) {
        b(paramView);
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X80050EE", "0X80050EE", 0, 0, "", "", "", "");
  }
  
  public void onNetMobile2None()
  {
    this.jdField_a_of_type_Acbh.sendEmptyMessage(18);
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
    this.jdField_a_of_type_Acbh.sendEmptyMessage(18);
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
        paramView.setTextColor(getResources().getColor(2131492976));
      } else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setTextColor(getResources().getColor(2131492968));
      }
    }
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.removeObserver(paramBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity
 * JD-Core Version:    0.7.0.1
 */