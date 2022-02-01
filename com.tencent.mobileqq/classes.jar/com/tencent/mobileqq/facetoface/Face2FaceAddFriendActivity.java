package com.tencent.mobileqq.facetoface;

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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.NearFieldTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
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
  implements View.OnClickListener, View.OnTouchListener, Face2FaceAddFriendAnim.CompassAnimationEnd, INetInfoHandler
{
  public static int a = 3021;
  public static long a = 1000L;
  public static String a = "Face2FaceAddFriendActivity";
  private static Calendar jdField_a_of_type_JavaUtilCalendar;
  public static String b = "Face2FaceAddFriendActivity.troop";
  public static String c = "Face2FaceAddFriendActivity.time";
  public static int g = 500;
  public static int h = 300000;
  public static int i = 2000;
  public Point a;
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public EditText a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new Face2FaceAddFriendActivity.10(this);
  LBSHandler jdField_a_of_type_ComTencentMobileqqAppLBSHandler;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new Face2FaceAddFriendActivity.7(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new Face2FaceAddFriendActivity.8(this);
  private NearFieldTroopObserver jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopObserver = new Face2FaceAddFriendActivity.12(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new Face2FaceAddFriendActivity.11(this);
  private Face2FaceAddFriendActivity.RefreshHandler jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler = new Face2FaceAddFriendActivity.RefreshHandler(this);
  Face2FaceAddFriendAnim jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim;
  protected Face2FaceDetailBaseView.IFace2faceContext a;
  public Face2FaceFriendDetailView a;
  public Face2FaceTroopDetailView a;
  public Face2FaceTroopFriendListAdapter a;
  public SnowView a;
  FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new Face2FaceAddFriendActivity.9(this);
  public INewFriendService a;
  protected QQProgressDialog a;
  public XListView a;
  ArrayList<Face2FaceUserProfile> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, String> a;
  public List<Face2FaceUserData> a;
  public CopyOnWriteArrayList<Face2FaceUserData> a;
  public boolean a;
  public int b;
  long jdField_b_of_type_Long = 0L;
  protected View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  public TextView b;
  public HashMap<String, Integer> b;
  public List<Face2FaceUserData> b;
  public boolean b;
  int c;
  protected long c;
  protected View c;
  protected TextView c;
  public HashMap<String, Integer> c;
  public List<Face2FaceUserData> c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 0L;
  protected View d;
  protected TextView d;
  public String d;
  public List<Face2FaceUserData> d;
  public boolean d;
  public int e;
  long e;
  protected View e;
  protected TextView e;
  public String e;
  public List<String> e;
  public boolean e;
  public int f;
  protected long f;
  protected TextView f;
  String f;
  public boolean f;
  protected String g;
  public boolean g;
  public boolean h;
  boolean i = false;
  public int j;
  boolean j;
  public int k;
  public boolean k;
  public int l;
  protected boolean l;
  int m;
  protected boolean m;
  int jdField_n_of_type_Int = 0;
  boolean jdField_n_of_type_Boolean = false;
  int jdField_o_of_type_Int = 0;
  private boolean jdField_o_of_type_Boolean = false;
  private boolean p = false;
  
  public Face2FaceAddFriendActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_e_of_type_Long = 0L;
    this.jdField_m_of_type_Int = 0;
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext = new Face2FaceAddFriendActivity.21(this);
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
    Object localObject2;
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getHasShowFriendData正在查看详情Uin");
      ((StringBuilder)localObject2).append(this.jdField_g_of_type_JavaLangString.substring(0, 4));
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Face2FaceUserData)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (((Face2FaceUserData)localObject2).jdField_e_of_type_JavaLangString.equals(this.jdField_g_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData需要替换但是正在查看详情");
        }
      }
      else if ((((Face2FaceUserData)localObject2).a == 1) && (b(((Face2FaceUserData)localObject2).jdField_e_of_type_JavaLangString)))
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break label218;
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty(((Face2FaceUserData)localObject2).jdField_e_of_type_JavaLangString)) {
          break label218;
        }
        localObject1 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHasShowFriendData可替换好友");
        localStringBuilder.append(((Face2FaceUserData)localObject2).jdField_e_of_type_JavaLangString.substring(0, 4));
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
        localObject1 = localObject2;
        break label218;
      }
    }
    localObject1 = null;
    label218:
    if ((localObject1 == null) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData 没有可替换好友");
    }
    return localObject1;
  }
  
  private List<Face2FaceUserData> a(List<Face2FaceUserData> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramInt < 1) {
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
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyNeedReplace ask replace type");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = null;
    Object localObject2 = d();
    Object localObject3 = f();
    if (paramInt == 1)
    {
      if (localObject2 != null) {
        break label89;
      }
      if (localObject3 == null) {
        break label91;
      }
    }
    else
    {
      if (localObject3 == null) {
        break label85;
      }
    }
    localObject1 = localObject3;
    break label91;
    label85:
    if (localObject2 != null) {
      label89:
      localObject1 = localObject2;
    }
    label91:
    if (localObject1 != null)
    {
      e((Face2FaceUserData)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("notifyNeedReplace replaceData type");
        ((StringBuilder)localObject3).append(((Face2FaceUserData)localObject1).a);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyNeedReplace no data can replace");
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (!paramString.equals(this.jdField_e_of_type_JavaLangString)) {
      return;
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362224);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362222);
    Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362216);
    if (paramInt == 3)
    {
      this.jdField_f_of_type_Boolean = true;
      a(localTextView, HardCodeUtil.a(2131704399));
      a(localButton, HardCodeUtil.a(2131704404));
      localButton.setOnClickListener(new Face2FaceAddFriendActivity.20(this, paramString));
      return;
    }
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        paramString = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (!TextUtils.isEmpty(paramString)) {
          ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367345)).setText(paramString);
        }
      }
      a(localTextView, HardCodeUtil.a(2131704410));
      localLinearLayout.setVisibility(8);
      return;
    }
    if (paramInt == 4)
    {
      a(localTextView, HardCodeUtil.a(2131704409));
      a(localButton, HardCodeUtil.a(2131704406));
    }
  }
  
  private void a(int paramInt, String paramString1, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString2, Bitmap paramBitmap)
  {
    this.jdField_e_of_type_JavaLangString = paramString1;
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362222);
    a((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367345), paramString2);
    ((ImageView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367312)).setImageBitmap(paramBitmap);
    paramBitmap = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362224);
    Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362216);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) {
      paramString2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } else {
      paramString2 = "";
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
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.jdField_f_of_type_JavaLangString, 3021, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new Face2FaceAddFriendActivity.16(this));
    localButton.setOnClickListener(new Face2FaceAddFriendActivity.17(this, paramString1));
    if (paramInt == 2)
    {
      a(paramBitmap, HardCodeUtil.a(2131704407));
      localLinearLayout.setVisibility(8);
    }
    else if ((paramInt != 4) && (paramInt != 1))
    {
      if (paramInt == 3)
      {
        this.jdField_f_of_type_Boolean = true;
        a(paramBitmap, HardCodeUtil.a(2131704402));
        localLinearLayout.setVisibility(0);
        a(localButton, HardCodeUtil.a(2131704395));
        localButton.setOnClickListener(new Face2FaceAddFriendActivity.18(this, paramString1));
      }
    }
    else
    {
      if (paramInt == 4) {
        a(paramBitmap, HardCodeUtil.a(2131704397));
      } else {
        a(paramBitmap, "");
      }
      a(localButton, HardCodeUtil.a(2131704403));
      localLinearLayout.setVisibility(0);
    }
    paramString2 = new Face2FaceAddFriendActivity.19(this, paramString1);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, paramFace2FaceFriendBubbleView, paramString1, this.jdField_a_of_type_JavaUtilHashMap, paramString2);
  }
  
  private void a(long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.obtainMessage(7);
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendDelayAskRequest delaytime=");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.setContentDescription(paramString);
  }
  
  private void a(String paramString)
  {
    new ArrayList();
    Object localObject2 = this.app.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList is null");
      }
      return;
    }
    if ((((List)localObject2).size() > 0) && (!(((List)localObject2).get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList error");
      }
      return;
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("answerAddFriend systemMsgList size");
      ((StringBuilder)localObject3).append(((List)localObject2).size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
    }
    int i1 = ((List)localObject2).size() - 1;
    Object localObject1 = null;
    while (i1 >= 0)
    {
      localObject1 = ((MessageForSystemMsg)((List)localObject2).get(i1)).getSystemMsg();
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("answerAddFriend structMsg.req_uin =");
          localStringBuilder.append(String.valueOf(((structmsg.StructMsg)localObject1).req_uin.get()));
          localStringBuilder.append("friendUin=");
          localStringBuilder.append(paramString);
          QLog.d((String)localObject3, 2, localStringBuilder.toString());
        }
        if (paramString.equals(String.valueOf(((structmsg.StructMsg)localObject1).req_uin.get()))) {
          break;
        }
      }
      i1 -= 1;
    }
    if ((localObject1 != null) && (paramString.equals(String.valueOf(((structmsg.StructMsg)localObject1).req_uin.get()))))
    {
      i1 = ((structmsg.StructMsg)localObject1).msg_type.get();
      long l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
      long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
      int i2 = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
      int i3 = ((structmsg.StructMsg)localObject1).msg.src_id.get();
      int i4 = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
      int i5 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
      localObject3 = ((structmsg.StructMsg)localObject1).msg.actions.get();
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        int i6 = this.jdField_l_of_type_Int;
        localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        paramString = (String)localObject2;
        if (localObject2 == null) {
          paramString = "";
        }
        localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject3).get(0)).action_info.get();
        ((structmsg.SystemMsgActionInfo)localObject2).remark.set(paramString);
        ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(i6);
        this.app.getMsgHandler().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
        a((structmsg.StructMsg)localObject1, ((structmsg.StructMsg)localObject1).msg_seq.get());
        if (QLog.isColorLevel())
        {
          paramString = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("answerAddFriend  structMsg.req_uin:  ");
          ((StringBuilder)localObject2).append(String.valueOf(((structmsg.StructMsg)localObject1).req_uin.get()));
          QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
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
        return;
      }
      this.jdField_c_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).putStructMsgToMap(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setCurrStructMsgKey(l1);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setCurrentUniseq(paramLong);
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("delayPushToUI mShowdataList.size()=");
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaUtilList.size());
      ((StringBuilder)localObject2).append("ispush=");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append("changeIndex");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("isReplash=");
      ((StringBuilder)localObject2).append(paramBoolean2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i1 = this.jdField_c_of_type_Int;
    if (!paramBoolean1) {
      paramInt = i1;
    }
    if (paramInt < this.jdField_d_of_type_JavaUtilList.size())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.obtainMessage();
      ((Message)localObject1).what = 4;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("key_data _ispush", paramBoolean1);
      ((Bundle)localObject2).putBoolean("key_data _hasfriend", paramBoolean2);
      ((Message)localObject1).setData((Bundle)localObject2);
      ((Message)localObject1).arg1 = paramInt;
      localObject2 = (Face2FaceUserData)this.jdField_d_of_type_JavaUtilList.get(paramInt);
      ((Message)localObject1).arg2 = ((Face2FaceUserData)localObject2).a;
      ((Message)localObject1).obj = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.hasMessages(4)) {
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendMessageDelayed((Message)localObject1, jdField_g_of_type_Int);
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (paramInt != 1) {
      return false;
    }
    if (paramString.equals(this.app.getCurrentAccountUin()))
    {
      QQToast.a(this, 2131690736, 0).b(getTitleBarHeight());
      return false;
    }
    try
    {
      Long.parseLong(paramString);
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null) {
        paramString = localFriendsManager.e(paramString);
      } else {
        paramString = null;
      }
      if ((paramString != null) && (paramString.groupid >= 0))
      {
        QQToast.a(this.app.getApplication(), 2131689998, 0).b(getTitleBarHeight());
        return false;
      }
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(this.app.getApplication(), 2131694424, 0).b(getTitleBarHeight());
        return false;
      }
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private boolean a(Face2FaceUserData paramFace2FaceUserData)
  {
    boolean bool2 = false;
    if (paramFace2FaceUserData == null) {
      return false;
    }
    boolean bool1;
    if ((paramFace2FaceUserData.a != 1) || (!b(paramFace2FaceUserData.jdField_e_of_type_JavaLangString)))
    {
      bool1 = bool2;
      if (paramFace2FaceUserData.a == 2)
      {
        bool1 = bool2;
        if (!a(paramFace2FaceUserData.jdField_e_of_type_JavaLangString)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
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
        if ((localFace2FaceUserData.a == 2) && (a(localFace2FaceUserData.jdField_e_of_type_JavaLangString))) {
          return localFace2FaceUserData;
        }
      }
    }
    return null;
  }
  
  private List<Face2FaceUserData> b(List<Face2FaceUserData> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramInt < 1) {
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
    }
    return localArrayList;
  }
  
  private boolean b()
  {
    String str;
    if (this.jdField_b_of_type_Int == 1) {
      str = "sp_facetoface_showguide_for_troop";
    } else {
      str = "sp_facetoface_showguide";
    }
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (localObject == null) {
      return false;
    }
    this.jdField_o_of_type_Boolean = ((SharedPreferences)localObject).getBoolean(str, false);
    if (this.jdField_o_of_type_Boolean) {
      return false;
    }
    localObject = LayoutInflater.from(getApplicationContext()).inflate(2131558921, null);
    Button localButton = (Button)((View)localObject).findViewById(2131366404);
    ((View)localObject).setBackgroundResource(2130840093);
    ((View)localObject).setOnClickListener(this);
    if (this.jdField_b_of_type_Int == 1) {
      ((TextView)((View)localObject).findViewById(2131366403)).setText(2131692144);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1));
    localButton.setOnClickListener(new Face2FaceAddFriendActivity.4(this, str, (View)localObject));
    return true;
  }
  
  private boolean b(String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addFriend uin is null");
      }
      return false;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    if (!a(1, paramString)) {
      return false;
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)))
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFriend uin");
      localStringBuilder.append(paramString.substring(0, 4));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(paramString));
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
    if ((this.jdField_d_of_type_JavaUtilList != null) && (paramFace2FaceUserData != null))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pushDataToUI mShowdataList=");
        localStringBuilder.append(this.jdField_d_of_type_JavaUtilList.size());
        localStringBuilder.append("currentFriendIndex=");
        localStringBuilder.append(this.jdField_c_of_type_Int);
        localStringBuilder.append("showtype=pushData.type=");
        localStringBuilder.append(paramFace2FaceUserData.a);
        localStringBuilder.append("mFriendDataList.size()");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
        localStringBuilder.append("troop size");
        localStringBuilder.append(this.jdField_b_of_type_JavaUtilList.size());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (this.jdField_d_of_type_JavaUtilList.contains(paramFace2FaceUserData)) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI face2FaceAddFriendAnim has null");
        }
        return;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() > 10)
      {
        if (a(paramFace2FaceUserData)) {
          return;
        }
        if (this.jdField_b_of_type_Int == 0)
        {
          e(paramFace2FaceUserData);
          this.jdField_g_of_type_Boolean = true;
          return;
        }
        e(paramFace2FaceUserData);
        return;
      }
      if ((this.jdField_d_of_type_JavaUtilList.size() == 0) && (!this.i))
      {
        this.jdField_d_of_type_JavaUtilList.add(paramFace2FaceUserData);
        if (QLog.isColorLevel())
        {
          paramFace2FaceUserData = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("pushDataToUI mShowdataList=");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaUtilList.size());
          ((StringBuilder)localObject).append("currentFriendIndex=");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
          ((StringBuilder)localObject).append("hasData");
          ((StringBuilder)localObject).append(this.i);
          QLog.d(paramFace2FaceUserData, 2, ((StringBuilder)localObject).toString());
        }
        this.i = true;
        return;
      }
      this.jdField_d_of_type_JavaUtilList.add(paramFace2FaceUserData);
      if (QLog.isColorLevel())
      {
        paramFace2FaceUserData = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pushDataToUI mShowdataList=");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaUtilList.size());
        ((StringBuilder)localObject).append("currentFriendIndex=");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        QLog.d(paramFace2FaceUserData, 2, ((StringBuilder)localObject).toString());
      }
      int i1 = this.jdField_d_of_type_JavaUtilList.size();
      int i2 = this.jdField_c_of_type_Int;
      if (i1 == i2 + 1) {
        a(true, i2, false);
      }
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mNeedShowList= nuull  pushData = null!");
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
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    boolean bool = false;
    int i2 = 0;
    int i1 = 0;
    while (((Iterator)localObject1).hasNext()) {
      if (((Face2FaceUserData)((Iterator)localObject1).next()).a == 1) {
        i2 += 1;
      } else {
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pushDataToReplace 显示列表 mfriendCount=");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append("mtroopCount=");
      ((StringBuilder)localObject2).append(i1);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = a();
    Face2FaceUserData localFace2FaceUserData = b();
    Object localObject3 = null;
    StringBuilder localStringBuilder = null;
    Object localObject2 = null;
    if (paramFace2FaceUserData.a == 1)
    {
      if (localObject1 != null) {
        break label302;
      }
      if (localFace2FaceUserData == null)
      {
        localObject1 = localStringBuilder;
        if (i2 >= 5) {
          break label410;
        }
        localObject1 = localStringBuilder;
        if (i1 <= 5) {
          break label410;
        }
        localObject1 = localStringBuilder;
        if (this.jdField_b_of_type_Int != 0) {
          break label410;
        }
        i1 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i1 >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
            break;
          }
          localObject3 = (Face2FaceUserData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i1);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((Face2FaceUserData)localObject3).a == 2)
            {
              localObject1 = localObject2;
              if (!a(((Face2FaceUserData)localObject3).jdField_e_of_type_JavaLangString)) {
                localObject1 = localObject3;
              }
            }
          }
          i1 += 1;
          localObject2 = localObject1;
        }
      }
    }
    else
    {
      if (localFace2FaceUserData == null) {
        break label297;
      }
    }
    localObject1 = localFace2FaceUserData;
    break label410;
    label297:
    if (localObject1 == null)
    {
      label302:
      localObject1 = localStringBuilder;
      if (i2 > 5)
      {
        localObject1 = localStringBuilder;
        if (i1 < 5)
        {
          i1 = 0;
          for (localObject2 = localObject3;; localObject2 = localObject1)
          {
            localObject1 = localObject2;
            if (i1 >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
              break;
            }
            localObject3 = (Face2FaceUserData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i1);
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if (((Face2FaceUserData)localObject3).a == 1)
              {
                localObject1 = localObject2;
                if (!b(((Face2FaceUserData)localObject3).jdField_e_of_type_JavaLangString)) {
                  localObject1 = localObject3;
                }
              }
            }
            i1 += 1;
          }
        }
      }
    }
    label410:
    if (localObject1 != null)
    {
      localObject2 = ((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString;
      if ((localObject1 instanceof Face2FaceGroupProfile))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(((Face2FaceGroupProfile)localObject1).jdField_b_of_type_JavaLangString);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (QLog.isColorLevel())
      {
        localObject3 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pushDataToReplace rRplaceData!=null && replace type=");
        localStringBuilder.append(((Face2FaceUserData)localObject1).a);
        QLog.d((String)localObject3, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a((String)localObject2);
      if (this.jdField_b_of_type_Int != 1) {
        bool = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a((Face2FaceUserData)localObject1, bool);
      i1 = a((Face2FaceUserData)localObject1);
      if ((i1 != -1) && (i1 < this.jdField_d_of_type_JavaUtilList.size()))
      {
        this.jdField_d_of_type_JavaUtilList.set(i1, paramFace2FaceUserData);
        a(true, i1, true);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToReplace rRplaceData=null 没有可以替换的数据");
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
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendEmptyMessageDelayed(3, 0L);
    a();
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendHeartRequest");
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.obtainMessage(5);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendMessageDelayed(localMessage, jdField_h_of_type_Int);
  }
  
  private void l()
  {
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373013));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365350));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    m();
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView = new SnowView(this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView.setSnowView(this.jdField_a_of_type_AndroidGraphicsPoint);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView);
    localObject = getLayoutInflater();
    View localView = ((LayoutInflater)localObject).inflate(2131559112, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131559113, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView = ((Face2FaceTroopDetailView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379186));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView = ((Face2FaceFriendDetailView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367301));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367311));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367368));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367360));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367361));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new Face2FaceAddFriendActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setInfc(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.setInfc(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377696);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377694));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377695));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692081);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void m()
  {
    View localView = LayoutInflater.from(getApplicationContext()).inflate(2131558920, null);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim = new Face2FaceAddFriendAnim(this.app, this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(this.app, localView, this.jdField_b_of_type_Int, this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    this.jdField_e_of_type_AndroidViewView = localView;
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_d_of_type_AndroidViewView = localView.findViewById(2131365049);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365045));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365048));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131692169);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      localView.findViewById(2131365046).setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void n()
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mergeShowList isFriendDataBack=");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject2).append("isTroopDataBack=");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_Boolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mergeShowList isFriendBackSuccess=");
      ((StringBuilder)localObject2).append(this.jdField_e_of_type_Int);
      ((StringBuilder)localObject2).append("isTroopBackSuccess=");
      ((StringBuilder)localObject2).append(this.jdField_f_of_type_Int);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i1 = this.jdField_e_of_type_Int;
    if (i1 != 0)
    {
      int i2 = this.jdField_f_of_type_Int;
      if (i2 != 0)
      {
        if ((i1 == 1) && (i2 == 1) && ((!this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return");
          }
          return;
        }
        if (this.jdField_d_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return has merged");
          }
          return;
        }
        i1 = this.jdField_a_of_type_JavaUtilList.size();
        i2 = this.jdField_b_of_type_JavaUtilList.size();
        this.jdField_d_of_type_Boolean = true;
        this.jdField_j_of_type_Int += i1;
        this.jdField_k_of_type_Int += i2;
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mergeShowList mFriendSize=");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append("mTroopSize=");
          ((StringBuilder)localObject2).append(i2);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        int i3 = i1 + i2;
        if (i3 == 0) {
          return;
        }
        if (i3 > 10)
        {
          if ((i1 >= 5) && (i2 >= 5))
          {
            localObject1 = new ArrayList(b(this.jdField_a_of_type_JavaUtilList, 5));
            localObject2 = new ArrayList(a(this.jdField_b_of_type_JavaUtilList, 5));
            a(this.jdField_d_of_type_JavaUtilList, (List)localObject1);
            a(this.jdField_d_of_type_JavaUtilList, (List)localObject2);
          }
          else if (i1 < 5)
          {
            this.jdField_d_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
            localObject1 = new ArrayList(a(this.jdField_b_of_type_JavaUtilList, 10 - this.jdField_a_of_type_JavaUtilList.size()));
            a(this.jdField_d_of_type_JavaUtilList, (List)localObject1);
          }
          else if (i2 < 5)
          {
            localObject1 = new ArrayList(b(this.jdField_a_of_type_JavaUtilList, 10 - this.jdField_b_of_type_JavaUtilList.size()));
            a(this.jdField_d_of_type_JavaUtilList, (List)localObject1);
          }
          localObject1 = this.jdField_d_of_type_JavaUtilList.iterator();
          i1 = 0;
          while (((Iterator)localObject1).hasNext()) {
            if (a((Face2FaceUserData)((Iterator)localObject1).next())) {
              i1 += 1;
            }
          }
          i2 = 0;
          while ((i2 < i1) && (a())) {
            i2 += 1;
          }
        }
        a(this.jdField_d_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
        a(this.jdField_d_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mergeShowList size=");
          ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaUtilList.size());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        this.i = true;
        i1 = this.jdField_c_of_type_Int;
        if (i1 > 0) {
          a(false, i1, false);
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return wait successStatus");
    }
  }
  
  private void o()
  {
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(this.jdField_f_of_type_JavaLangString, 3021, 0, "");
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
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
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopObserver);
  }
  
  private void r()
  {
    if ((!this.app.isVideoChatting()) && (!this.app.isRingerVibrate()) && (!this.app.isRingEqualsZero()) && (this.app.isCallIdle()) && (this.jdField_m_of_type_Boolean)) {
      AudioUtil.b(2131230749, false);
    }
  }
  
  private void s()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "clearSystemMsgData");
      }
      this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService.markSystemMsgReaded();
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "findReplaceData ");
    }
    Object localObject1 = null;
    Face2FaceUserData localFace2FaceUserData1 = d();
    Face2FaceUserData localFace2FaceUserData2 = f();
    Object localObject2 = c();
    Face2FaceUserData localFace2FaceUserData3 = e();
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() < 10)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("findReplaceData friend count=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList.size());
        ((StringBuilder)localObject2).append("troop count");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaUtilList.size());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (localFace2FaceUserData2 != null) {
      localObject1 = localFace2FaceUserData2;
    } else if (localFace2FaceUserData1 != null) {
      localObject1 = localFace2FaceUserData1;
    } else if ((localFace2FaceUserData3 != null) || (localObject2 != null)) {
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      this.jdField_d_of_type_JavaUtilList.add(localObject1);
      int i1 = this.jdField_d_of_type_JavaUtilList.size();
      int i2 = this.jdField_c_of_type_Int;
      if (i1 == i2 + 1) {
        a(true, i2, false);
      }
    }
  }
  
  protected int a()
  {
    int i1;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() < this.jdField_d_of_type_JavaUtilList.size()) {
      i1 = (this.jdField_d_of_type_JavaUtilList.size() - this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) * 500 + 2500;
    } else {
      i1 = 2000;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getReplaceDelay=");
      localStringBuilder.append(i1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public int a(long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    return jdField_a_of_type_JavaUtilCalendar.get(11);
  }
  
  String a(int paramInt)
  {
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    String str = "";
    localStringBuilder.append("");
    localObject = ((FriendsManager)localObject).a(localStringBuilder.toString());
    if (localObject != null) {
      str = ((Groups)localObject).group_name;
    }
    return str;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openFace2FaceTroop, from_type=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(", fromTroopUin=");
      localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (NearFieldTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null))
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, NetworkUtil.isNetSupport==false");
        }
        QQToast.a(this.app.getApplication(), 2131694424, 0).b(getTitleBarHeight());
        return;
      }
      ThreadManager.post(new Face2FaceAddFriendActivity.1(this, (NearFieldTroopHandler)localObject), 8, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, getBusinessHandler==null");
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.i)
    {
      if (this.jdField_j_of_type_Boolean == true) {
        this.jdField_j_of_type_Boolean = false;
      }
      this.i = false;
      a(false, this.jdField_c_of_type_Int, false);
      return;
    }
    if ((paramInt == 1) && (this.jdField_j_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendEmptyMessageDelayed(8, 0L);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i2 = a(paramLong1);
    int i3 = (int)((paramLong1 - paramLong2) / 1000L / 60L);
    int i1;
    if ((i2 >= 5) && (i2 < 11)) {
      i1 = 4;
    } else if ((i2 >= 11) && (i2 < 17)) {
      i1 = 1;
    } else if ((i2 >= 17) && (i2 < 23)) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    if (i3 >= 6)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840091);
              this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840093);
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840094);
            this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840091);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840092);
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840094);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840093);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840092);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new Face2FaceAddFriendActivity.22(this));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4) {
              this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840093);
            }
          }
          else {
            this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840091);
          }
        }
        else {
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840094);
        }
      }
      else {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840092);
      }
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startBkAnim 本次进入时间点：");
      localStringBuilder.append(i2);
      localStringBuilder.append("和上一次时间差");
      localStringBuilder.append(i3);
      localStringBuilder.append("小时");
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile)
  {
    if (paramFace2FaceGroupProfile == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteGroupData mhasShowList = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramFace2FaceGroupProfile))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramFace2FaceGroupProfile, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFace2FaceGroupProfile.jdField_e_of_type_JavaLangString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramFace2FaceGroupProfile.jdField_b_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a((String)localObject);
      this.jdField_d_of_type_JavaUtilList.remove(paramFace2FaceGroupProfile);
      this.jdField_b_of_type_JavaUtilList.remove(paramFace2FaceGroupProfile);
      int i1 = this.jdField_c_of_type_Int;
      if (i1 > 0) {
        this.jdField_c_of_type_Int = (i1 - 1);
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
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onADDShowData isPush");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("currentFriendIndex=");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("isFilterShow=hasFriend=");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramFace2FaceUserData);
  }
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim;
    if (localObject1 != null)
    {
      if (paramFace2FaceUserProfile == null) {
        return;
      }
      localObject1 = ((Face2FaceAddFriendAnim)localObject1).a(paramFace2FaceUserProfile.jdField_e_of_type_JavaLangString);
      if (localObject1 == null) {
        return;
      }
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
      localAnimationSet.setAnimationListener(new Face2FaceAddFriendActivity.5(this, (View)localObject1));
      ((View)localObject1).setClickable(false);
      ((View)localObject1).startAnimation(localAnimationSet);
      localObject1 = Message.obtain();
      ((Message)localObject1).what = 15;
      ((Message)localObject1).obj = paramFace2FaceUserProfile;
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendMessageDelayed((Message)localObject1, 1500L);
    }
  }
  
  public void a(List<Face2FaceUserData> paramList1, List<Face2FaceUserData> paramList2)
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
              if ((localFace2FaceUserData1.a != 1) || (!b(localFace2FaceUserData1.jdField_e_of_type_JavaLangString))) {
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
          } while ((localFace2FaceUserData1.a != 2) || (!a(localFace2FaceUserData1.jdField_e_of_type_JavaLangString)));
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
  
  public boolean a(Face2FaceUserData paramFace2FaceUserData, List<Face2FaceUserData> paramList)
  {
    if (paramList.contains(paramFace2FaceUserData))
    {
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramFace2FaceUserData.jdField_e_of_type_JavaLangString)))
      {
        paramList = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("datalist has contains data");
        localStringBuilder.append(paramFace2FaceUserData.jdField_e_of_type_JavaLangString.substring(0, 4));
        QLog.d(paramList, 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject = null;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("");
      localObject = localTroopManager.b(((StringBuilder)localObject).toString());
    }
    if (localObject != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.addObserver(paramBusinessObserver);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeFace2faceTroop, from_type=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(", fromTroopUin=");
      localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (NearFieldTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "closeFace2faceTroop, getBusinessHandler==null");
      }
      return;
    }
    if (this.jdField_b_of_type_Int == 1) {
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        return;
      }
    }
    try
    {
      ((NearFieldTroopHandler)localObject).a(Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), 1);
      return;
    }
    catch (Exception localException) {}
    ((NearFieldTroopHandler)localObject).a(0L, 1);
    return;
  }
  
  public void b(Face2FaceUserData paramFace2FaceUserData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim != null) && (paramFace2FaceUserData != null))
    {
      Face2FaceAddFriendActivity.RefreshHandler localRefreshHandler = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler;
      if (localRefreshHandler == null) {
        return;
      }
      localRefreshHandler.removeMessages(14, paramFace2FaceUserData);
      paramFace2FaceUserData = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramFace2FaceUserData.jdField_e_of_type_JavaLangString);
      if (paramFace2FaceUserData != null) {
        paramFace2FaceUserData.setAnimation(new AlphaAnimation(1.0F, 1.0F));
      }
    }
  }
  
  public void b(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_c_of_type_Int += 1;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInAnimEnd isPush");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("currentFriendIndex=");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("isFilterShow=hasFriend=");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    a(paramBoolean1, this.jdField_c_of_type_Int, false);
    if (this.jdField_b_of_type_Int == 1) {
      a(paramFace2FaceUserData);
    }
  }
  
  public void c()
  {
    this.jdField_l_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      localObject = LayoutInflater.from(getApplicationContext());
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559116, null);
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378786);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379137));
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366402);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(localView);
      localObject = ((LayoutInflater)localObject).inflate(2131559114, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379135));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369210);
      ((TextView)localObject).setOnClickListener(this);
      ((TextView)localObject).setOnTouchListener(this);
      ((TextView)localObject).setPadding(((TextView)localObject).getPaddingLeft(), 0, ((TextView)localObject).getPaddingRight(), 0);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter = new Face2FaceTroopFriendListAdapter(this, this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.getCount()));
    Object localObject = AnimationUtils.loadAnimation(this, 2130771993);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
  }
  
  public void c(Face2FaceUserData paramFace2FaceUserData)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramFace2FaceUserData)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramFace2FaceUserData);
    }
  }
  
  public void d()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130771992);
    localAnimation.setAnimationListener(new Face2FaceAddFriendActivity.3(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    e();
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
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 != 100) {
      return;
    }
    paramInt1 = paramIntent.getByteExtra("result", (byte)0);
    this.jdField_l_of_type_Int = paramInt1;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramInt1));
    this.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_e_of_type_JavaLangString, Integer.valueOf(this.jdField_l_of_type_Int));
  }
  
  public void doOnBackPressed()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView;
    if ((localObject != null) && (((Face2FaceTroopDetailView)localObject).a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.b();
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView;
    if ((localObject != null) && (((Face2FaceFriendDetailView)localObject).a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.b();
      return;
    }
    if (this.jdField_l_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        d();
        return;
      }
    }
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Boolean))
    {
      DialogUtil.a(this, 230, getString(2131719632), getString(2131692142), 2131690728, 2131692081, new Face2FaceAddFriendActivity.13(this), new Face2FaceAddFriendActivity.14(this)).show();
      return;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoTitle(2131558919);
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    paramBundle = getIntent();
    Object localObject = paramBundle.getStringExtra("options");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      try
      {
        paramBundle = new JSONObject((String)localObject);
        this.jdField_b_of_type_Int = paramBundle.optInt("activity_from_type");
        this.jdField_d_of_type_JavaLangString = paramBundle.optString("activity_troop_uin");
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    else
    {
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("activity_from_type", 0);
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("activity_troop_uin");
    }
    if (QLog.isColorLevel())
    {
      paramBundle = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnCreate, from_type=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(", fromTroopUin=");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131376809));
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.app.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER));
    jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    l();
    p();
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService = ((INewFriendService)this.app.getRuntimeService(INewFriendService.class));
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this);
    if (AppNetConnInfo.getConnInfo() == -1) {
      QQToast.a(this.app.getApplication(), 2131694424, 0).b(getTitleBarHeight());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService.getUnreadSystemMessageCount() == 0) {
      this.jdField_e_of_type_Boolean = true;
    } else {
      this.jdField_e_of_type_Boolean = false;
    }
    if (b())
    {
      this.jdField_n_of_type_Boolean = false;
      return true;
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
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(5);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(7);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(9);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(11);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler;
    if (localObject != null) {
      ((LBSHandler)localObject).a(this.app.getCurrentAccountUin());
    } else if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestroy mLbsHandler is null");
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a();
    if (this.jdField_g_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "0X80050F2", "0X80050F2", 0, 0, "", "", "", "");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter;
    if (localObject != null) {
      ((Face2FaceTroopFriendListAdapter)localObject).c();
    }
    ReportController.b(null, "CliOper", "", "", "0X80050EC", "0X80050EC", 0, 0, String.valueOf(this.jdField_j_of_type_Int), String.valueOf(this.jdField_k_of_type_Int), "", "");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnPause!");
    }
    this.jdField_m_of_type_Boolean = false;
    QQAudioUtils.a(this, false);
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
    QQAudioUtils.a(this, true);
    g();
    f();
    Face2FaceAddFriendConstants.a = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      String str = jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("face2face doOnStart inface2faceTime=");
      localStringBuilder.append(a(Face2FaceAddFriendConstants.a));
      localStringBuilder.append("showBkAnim=");
      localStringBuilder.append(this.jdField_n_of_type_Boolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_n_of_type_Boolean)
    {
      if (Face2FaceAddFriendConstants.a >= Face2FaceAddFriendConstants.jdField_b_of_type_Long)
      {
        a(Face2FaceAddFriendConstants.a, Face2FaceAddFriendConstants.jdField_b_of_type_Long);
        return;
      }
      a(Face2FaceAddFriendConstants.a, 0L);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnStop!");
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(4);
    Face2FaceAddFriendConstants.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      String str = jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("face2face doOnStop outface2faceTime=");
      localStringBuilder.append(a(Face2FaceAddFriendConstants.jdField_b_of_type_Long));
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      Object localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      if ((localObject != null) && (((TextView)localObject).getVisibility() == 0)) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject = this.jdField_d_of_type_AndroidViewView;
      if ((localObject != null) && (((View)localObject).getVisibility() != 0)) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.valueOf(i1));
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Int != 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(9);
    long l1 = SystemClock.elapsedRealtime() - this.jdField_c_of_type_Long;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkTroopShareValidity, durition=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", mInitTroopShareTimeStamp=");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      QLog.d("time_tick", 2, localStringBuilder.toString());
    }
    if (l1 >= 1200000L)
    {
      DialogUtil.a(this, 230, getString(2131719632), "此次分享已满20分钟", 2131690728, 2131692081, new Face2FaceAddFriendActivity.6(this), null).show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendEmptyMessageDelayed(9, 10000L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.a(100L);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("snow", 2, "stopSnow");
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.removeMessages(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendEmptyMessageDelayed(8, 0L);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a()) && (i1 != 2131366453)) {
      if (i1 == 2131377694) {
        doOnBackPressed();
      } else if ((i1 != 2131377695) && (i1 != 2131365046) && (i1 != 2131365049) && (i1 != 2131365048))
      {
        if (i1 == 2131369210)
        {
          if (this.jdField_b_of_type_Int == 1) {
            d();
          }
        }
        else
        {
          Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)paramView;
          Object localObject1;
          Object localObject2;
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
              if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)))
              {
                localObject1 = jdField_a_of_type_JavaLangString;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("showdetail 进入详情页mShowDetailUin=");
                ((StringBuilder)localObject2).append(this.jdField_g_of_type_JavaLangString.substring(0, 4));
                QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
              }
              localObject2 = this.app.getFaceBitmap(str, (byte)3, true);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = ImageUtil.f();
              }
              localObject2 = (NearbyUser)localFace2FaceFriendBubbleView.a();
              if (localObject2 == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleview nearbyUser is null");
                }
              }
              else
              {
                if (((NearbyUser)localObject2).jdField_a_of_type_JavaLangString.equals("")) {
                  localObject2 = ((NearbyUser)localObject2).jdField_b_of_type_JavaLangString;
                } else {
                  localObject2 = ((NearbyUser)localObject2).jdField_a_of_type_JavaLangString;
                }
                a(localFace2FaceFriendBubbleView.b(), str, localFace2FaceFriendBubbleView, (String)localObject2, (Bitmap)localObject1);
                ReportController.b(null, "CliOper", "", "", "0X80050ED", "0X80050ED", 0, 0, "", "", "", "");
                if (this.jdField_b_of_type_Int == 1) {
                  ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_detail", 0, 0, this.jdField_d_of_type_JavaLangString, "", "", "");
                }
              }
            }
          }
          else if (localFace2FaceFriendBubbleView.a() == 2)
          {
            localObject1 = localFace2FaceFriendBubbleView.a();
            if (localObject1 != null)
            {
              this.jdField_f_of_type_JavaLangString = ((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString;
              this.jdField_g_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
              localObject2 = new Face2FaceAddFriendActivity.15(this, (Face2FaceUserData)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setBindData((Face2FaceUserData)localObject1, (View.OnClickListener)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(this.jdField_a_of_type_AndroidWidgetFrameLayout, localFace2FaceFriendBubbleView);
              if (this.jdField_b_of_type_Int == 1) {
                b((Face2FaceUserData)localObject1);
              }
            }
            ReportController.b(null, "CliOper", "", "", "0X80050EE", "0X80050EE", 0, 0, "", "", "", "");
          }
        }
      }
      else if (this.jdField_b_of_type_Int == 1) {
        c();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onNetMobile2None()
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendEmptyMessage(18);
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
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$RefreshHandler.sendEmptyMessage(18);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131377694: 
    case 2131377695: 
      paramView = (TextView)paramView;
      if (paramMotionEvent.getAction() == 0) {
        paramView.setTextColor(getResources().getColor(2131167005));
      } else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setTextColor(getResources().getColor(2131167394));
      }
      break;
    }
    return false;
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.removeObserver(paramBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity
 * JD-Core Version:    0.7.0.1
 */