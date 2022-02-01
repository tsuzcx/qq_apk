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
  public static String a = "Face2FaceAddFriendActivity";
  private static Calendar aL;
  public static String b = "Face2FaceAddFriendActivity.troop";
  public static String c = "Face2FaceAddFriendActivity.time";
  public static int d = 3021;
  public static int w = 500;
  public static int x = 300000;
  public static long y = 1000L;
  public static int z = 2000;
  long A = 0L;
  public List<String> B = new ArrayList();
  public boolean C = true;
  public boolean D = false;
  public boolean E = false;
  public boolean F = false;
  public int G = 0;
  public int H = 0;
  public INewFriendService I;
  public Face2FaceTroopDetailView J;
  public View K = null;
  public XListView L = null;
  public TextView M = null;
  public Face2FaceTroopFriendListAdapter N = null;
  public String O = null;
  public Face2FaceFriendDetailView P;
  public EditText Q = null;
  public TextView R = null;
  public LinearLayout S = null;
  public LinearLayout T = null;
  String U;
  public int V = 0;
  public HashMap<String, String> W = new HashMap();
  public HashMap<String, Integer> X = new HashMap();
  public HashMap<String, Integer> Y = new HashMap();
  Face2FaceAddFriendAnim Z;
  LBSObserver aA = new Face2FaceAddFriendActivity.7(this);
  MessageObserver aB = new Face2FaceAddFriendActivity.8(this);
  FriendObserver aC = new Face2FaceAddFriendActivity.9(this);
  FriendListObserver aD = new Face2FaceAddFriendActivity.10(this);
  AvatarObserver aE = new Face2FaceAddFriendActivity.11(this);
  protected long aF = 0L;
  protected QQProgressDialog aG = null;
  protected Face2FaceDetailBaseView.IFace2faceContext aH = new Face2FaceAddFriendActivity.21(this);
  private boolean aI = false;
  private Face2FaceAddFriendActivity.RefreshHandler aJ = new Face2FaceAddFriendActivity.RefreshHandler(this);
  private boolean aK = false;
  private NearFieldTroopObserver aM = new Face2FaceAddFriendActivity.12(this);
  boolean aa = false;
  boolean ab = true;
  protected View ac = null;
  protected View ad = null;
  protected TextView ae;
  protected TextView af;
  public boolean ag = true;
  LBSHandler ah;
  protected long ai = 0L;
  protected TextView aj;
  protected View ak;
  protected TextView al;
  protected boolean am = false;
  protected boolean an = false;
  protected String ao = "";
  ImageView ap;
  ImageView aq;
  AlphaAnimation ar;
  long as = 0L;
  long at = 0L;
  boolean au = false;
  int av = 0;
  int aw = 0;
  protected View ax = null;
  int ay = 0;
  ArrayList<Face2FaceUserProfile> az = new ArrayList();
  public int e = 0;
  public String f = null;
  public boolean g = false;
  FrameLayout h;
  public SnowView i;
  public Point j;
  int k = 0;
  int l = 0;
  public List<Face2FaceUserData> m = new ArrayList();
  public List<Face2FaceUserData> n = new ArrayList();
  public List<Face2FaceUserData> o = new ArrayList();
  public List<Face2FaceUserData> p = new ArrayList();
  public CopyOnWriteArrayList<Face2FaceUserData> q = new CopyOnWriteArrayList();
  public boolean r = false;
  public boolean s = false;
  public int t = 0;
  public int u = 0;
  public boolean v = false;
  
  private Face2FaceUserData A()
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (!b(localFace2FaceUserData.f)) && (!this.q.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private Face2FaceUserData B()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (a(localFace2FaceUserData.f)) && (!this.q.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private Face2FaceUserData C()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (!a(localFace2FaceUserData.f)) && (!this.q.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
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
        } while (a(localFace2FaceUserData.f));
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
          } while (!a(((Face2FaceUserData)localObject).f));
          localArrayList.add(localObject);
        } while (localArrayList.size() != paramInt);
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, String paramString1, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString2, Bitmap paramBitmap)
  {
    this.O = paramString1;
    LinearLayout localLinearLayout = (LinearLayout)this.P.findViewById(2131427803);
    a((TextView)this.P.findViewById(2131433802), paramString2);
    ((ImageView)this.P.findViewById(2131433769)).setImageBitmap(paramBitmap);
    paramBitmap = (TextView)this.P.findViewById(2131427805);
    Button localButton = (Button)this.P.findViewById(2131427797);
    if (this.W.containsKey(paramString1)) {
      paramString2 = (String)this.W.get(paramString1);
    } else {
      paramString2 = "";
    }
    this.Q.setText(paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      this.Q.setSelection(paramString2.length());
    }
    this.F = true;
    if (this.X.containsKey(paramString1)) {
      this.V = ((Integer)this.X.get(paramString1)).intValue();
    }
    this.R.setText(a(this.V));
    this.U = paramString1;
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.U, 3021, 0);
    this.S.setOnClickListener(new Face2FaceAddFriendActivity.16(this));
    localButton.setOnClickListener(new Face2FaceAddFriendActivity.17(this, paramString1));
    if (paramInt == 2)
    {
      a(paramBitmap, HardCodeUtil.a(2131902320));
      localLinearLayout.setVisibility(8);
    }
    else if ((paramInt != 4) && (paramInt != 1))
    {
      if (paramInt == 3)
      {
        this.D = true;
        a(paramBitmap, HardCodeUtil.a(2131902315));
        localLinearLayout.setVisibility(0);
        a(localButton, HardCodeUtil.a(2131902308));
        localButton.setOnClickListener(new Face2FaceAddFriendActivity.18(this, paramString1));
      }
    }
    else
    {
      if (paramInt == 4) {
        a(paramBitmap, HardCodeUtil.a(2131902310));
      } else {
        a(paramBitmap, "");
      }
      a(localButton, HardCodeUtil.a(2131902316));
      localLinearLayout.setVisibility(0);
    }
    paramString2 = new Face2FaceAddFriendActivity.19(this, paramString1);
    this.P.a(this, this.h, paramFace2FaceFriendBubbleView, paramString1, this.W, paramString2);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.setContentDescription(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = b(paramString, 1);
    if (localFace2FaceFriendBubbleView != null)
    {
      localFace2FaceFriendBubbleView.setStatusWithAnimation(paramInt);
      if (this.Y.containsKey(paramString))
      {
        this.Y.remove(paramString);
        this.Y.put(paramString, Integer.valueOf(paramInt));
        return;
      }
      this.Y.put(paramString, Integer.valueOf(paramInt));
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
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("delayPushToUI mShowdataList.size()=");
      ((StringBuilder)localObject2).append(this.p.size());
      ((StringBuilder)localObject2).append("ispush=");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append("changeIndex");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("isReplash=");
      ((StringBuilder)localObject2).append(paramBoolean2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i1 = this.k;
    if (!paramBoolean1) {
      paramInt = i1;
    }
    if (paramInt < this.p.size())
    {
      localObject1 = this.aJ.obtainMessage();
      ((Message)localObject1).what = 4;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("key_data _ispush", paramBoolean1);
      ((Bundle)localObject2).putBoolean("key_data _hasfriend", paramBoolean2);
      ((Message)localObject1).setData((Bundle)localObject2);
      ((Message)localObject1).arg1 = paramInt;
      localObject2 = (Face2FaceUserData)this.p.get(paramInt);
      ((Message)localObject1).arg2 = ((Face2FaceUserData)localObject2).e;
      ((Message)localObject1).obj = localObject2;
      if (this.aJ.hasMessages(4)) {
        this.aJ.removeMessages(4);
      }
      this.aJ.sendMessageDelayed((Message)localObject1, w);
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (paramInt != 1) {
      return false;
    }
    if (paramString.equals(this.app.getCurrentAccountUin()))
    {
      QQToast.makeText(this, 2131887656, 0).show(getTitleBarHeight());
      return false;
    }
    try
    {
      Long.parseLong(paramString);
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null) {
        paramString = localFriendsManager.m(paramString);
      } else {
        paramString = null;
      }
      if ((paramString != null) && (paramString.groupid >= 0))
      {
        QQToast.makeText(this.app.getApplication(), 2131886641, 0).show(getTitleBarHeight());
        return false;
      }
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this.app.getApplication(), 2131892104, 0).show(getTitleBarHeight());
        return false;
      }
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private Face2FaceFriendBubbleView b(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.Z.k.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)localIterator.next();
      if ((paramString.equals(localFace2FaceFriendBubbleView.getUin())) && (localFace2FaceFriendBubbleView.getUinType() == paramInt)) {
        return localFace2FaceFriendBubbleView;
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
        } while (b(localFace2FaceUserData.f));
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
          } while (!b(((Face2FaceUserData)localObject).f));
          localArrayList.add(localObject);
        } while (localArrayList.size() != paramInt);
      }
    }
    return localArrayList;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyNeedReplace ask replace type");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = null;
    Object localObject2 = A();
    Object localObject3 = C();
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
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("notifyNeedReplace replaceData type");
        ((StringBuilder)localObject3).append(((Face2FaceUserData)localObject1).e);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(a, 2, "notifyNeedReplace no data can replace");
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    if (!paramString.equals(this.O)) {
      return;
    }
    TextView localTextView = (TextView)this.P.findViewById(2131427805);
    LinearLayout localLinearLayout = (LinearLayout)this.P.findViewById(2131427803);
    Button localButton = (Button)this.P.findViewById(2131427797);
    if (paramInt == 3)
    {
      this.D = true;
      a(localTextView, HardCodeUtil.a(2131902312));
      a(localButton, HardCodeUtil.a(2131902317));
      localButton.setOnClickListener(new Face2FaceAddFriendActivity.20(this, paramString));
      return;
    }
    if (paramInt == 2)
    {
      if (this.W.containsKey(paramString))
      {
        paramString = (String)this.W.get(paramString);
        if (!TextUtils.isEmpty(paramString)) {
          ((TextView)this.P.findViewById(2131433802)).setText(paramString);
        }
      }
      a(localTextView, HardCodeUtil.a(2131902323));
      localLinearLayout.setVisibility(8);
      return;
    }
    if (paramInt == 4)
    {
      a(localTextView, HardCodeUtil.a(2131902322));
      a(localButton, HardCodeUtil.a(2131902319));
    }
  }
  
  private void b(long paramLong)
  {
    Message localMessage = this.aJ.obtainMessage(7);
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendDelayAskRequest delaytime=");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.aJ.sendMessageDelayed(localMessage, paramLong);
  }
  
  private boolean b(String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((localFriendsManager != null) && (!TextUtils.isEmpty(paramString))) {
      return localFriendsManager.n(paramString);
    }
    return false;
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "addFriend uin is null");
      }
      return false;
    }
    this.U = paramString;
    if (!a(1, paramString)) {
      return false;
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFriend uin");
      localStringBuilder.append(paramString.substring(0, 4));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(paramString));
    return true;
  }
  
  private void d(Face2FaceUserData paramFace2FaceUserData)
  {
    if ((this.p != null) && (paramFace2FaceUserData != null))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pushDataToUI mShowdataList=");
        localStringBuilder.append(this.p.size());
        localStringBuilder.append("currentFriendIndex=");
        localStringBuilder.append(this.k);
        localStringBuilder.append("showtype=pushData.type=");
        localStringBuilder.append(paramFace2FaceUserData.e);
        localStringBuilder.append("mFriendDataList.size()");
        localStringBuilder.append(this.m.size());
        localStringBuilder.append("troop size");
        localStringBuilder.append(this.n.size());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (this.p.contains(paramFace2FaceUserData)) {
        return;
      }
      if (this.Z == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "pushDataToUI face2FaceAddFriendAnim has null");
        }
        return;
      }
      if (this.m.size() + this.n.size() > 10)
      {
        if (g(paramFace2FaceUserData)) {
          return;
        }
        if (this.e == 0)
        {
          e(paramFace2FaceUserData);
          this.E = true;
          return;
        }
        e(paramFace2FaceUserData);
        return;
      }
      if ((this.p.size() == 0) && (!this.aa))
      {
        this.p.add(paramFace2FaceUserData);
        if (QLog.isColorLevel())
        {
          paramFace2FaceUserData = a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("pushDataToUI mShowdataList=");
          ((StringBuilder)localObject).append(this.p.size());
          ((StringBuilder)localObject).append("currentFriendIndex=");
          ((StringBuilder)localObject).append(this.k);
          ((StringBuilder)localObject).append("hasData");
          ((StringBuilder)localObject).append(this.aa);
          QLog.d(paramFace2FaceUserData, 2, ((StringBuilder)localObject).toString());
        }
        this.aa = true;
        return;
      }
      this.p.add(paramFace2FaceUserData);
      if (QLog.isColorLevel())
      {
        paramFace2FaceUserData = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pushDataToUI mShowdataList=");
        ((StringBuilder)localObject).append(this.p.size());
        ((StringBuilder)localObject).append("currentFriendIndex=");
        ((StringBuilder)localObject).append(this.k);
        QLog.d(paramFace2FaceUserData, 2, ((StringBuilder)localObject).toString());
      }
      int i1 = this.p.size();
      int i2 = this.k;
      if (i1 == i2 + 1) {
        a(true, i2, false);
      }
      return;
    }
    QLog.d(a, 2, "pushDataToUI mNeedShowList= nuull  pushData = null!");
  }
  
  private void d(String paramString)
  {
    new ArrayList();
    Object localObject2 = this.app.getMessageFacade().h(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "systemMsgList is null");
      }
      return;
    }
    if ((((List)localObject2).size() > 0) && (!(((List)localObject2).get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "systemMsgList error");
      }
      return;
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
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
          localObject3 = a;
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
        int i6 = this.V;
        localObject2 = this.Q.getText().toString();
        paramString = (String)localObject2;
        if (localObject2 == null) {
          paramString = "";
        }
        localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject3).get(0)).action_info.get();
        ((structmsg.SystemMsgActionInfo)localObject2).remark.set(paramString);
        ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(i6);
        this.app.getMsgHandler().B().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
        a((structmsg.StructMsg)localObject1, ((structmsg.StructMsg)localObject1).msg_seq.get());
        if (QLog.isColorLevel())
        {
          paramString = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("answerAddFriend  structMsg.req_uin:  ");
          ((StringBuilder)localObject2).append(String.valueOf(((structmsg.StructMsg)localObject1).req_uin.get()));
          QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(a, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
    }
  }
  
  private void e(Face2FaceUserData paramFace2FaceUserData)
  {
    if (this.Z == null) {
      return;
    }
    Object localObject1 = this.q.iterator();
    boolean bool = false;
    int i2 = 0;
    int i1 = 0;
    while (((Iterator)localObject1).hasNext()) {
      if (((Face2FaceUserData)((Iterator)localObject1).next()).e == 1) {
        i2 += 1;
      } else {
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pushDataToReplace 显示列表 mfriendCount=");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append("mtroopCount=");
      ((StringBuilder)localObject2).append(i1);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = x();
    Face2FaceUserData localFace2FaceUserData = y();
    Object localObject3 = null;
    StringBuilder localStringBuilder = null;
    Object localObject2 = null;
    if (paramFace2FaceUserData.e == 1)
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
        if (this.e != 0) {
          break label410;
        }
        i1 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i1 >= this.q.size()) {
            break;
          }
          localObject3 = (Face2FaceUserData)this.q.get(i1);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((Face2FaceUserData)localObject3).e == 2)
            {
              localObject1 = localObject2;
              if (!a(((Face2FaceUserData)localObject3).f)) {
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
            if (i1 >= this.q.size()) {
              break;
            }
            localObject3 = (Face2FaceUserData)this.q.get(i1);
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if (((Face2FaceUserData)localObject3).e == 1)
              {
                localObject1 = localObject2;
                if (!b(((Face2FaceUserData)localObject3).f)) {
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
      localObject2 = ((Face2FaceUserData)localObject1).f;
      if ((localObject1 instanceof Face2FaceGroupProfile))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((Face2FaceUserData)localObject1).f);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(((Face2FaceGroupProfile)localObject1).b);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (QLog.isColorLevel())
      {
        localObject3 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pushDataToReplace rRplaceData!=null && replace type=");
        localStringBuilder.append(((Face2FaceUserData)localObject1).e);
        QLog.d((String)localObject3, 2, localStringBuilder.toString());
      }
      this.Z.b((String)localObject2);
      if (this.e != 1) {
        bool = true;
      }
      this.Z.a((Face2FaceUserData)localObject1, bool);
      i1 = f((Face2FaceUserData)localObject1);
      if ((i1 != -1) && (i1 < this.p.size()))
      {
        this.p.set(i1, paramFace2FaceUserData);
        a(true, i1, true);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(a, 2, "pushDataToReplace rRplaceData=null 没有可以替换的数据");
    }
  }
  
  private int f(Face2FaceUserData paramFace2FaceUserData)
  {
    return this.p.indexOf(paramFace2FaceUserData);
  }
  
  private boolean g(Face2FaceUserData paramFace2FaceUserData)
  {
    boolean bool2 = false;
    if (paramFace2FaceUserData == null) {
      return false;
    }
    boolean bool1;
    if ((paramFace2FaceUserData.e != 1) || (!b(paramFace2FaceUserData.f)))
    {
      bool1 = bool2;
      if (paramFace2FaceUserData.e == 2)
      {
        bool1 = bool2;
        if (!a(paramFace2FaceUserData.f)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private void l()
  {
    this.au = true;
    g();
    this.aJ.sendEmptyMessageDelayed(3, 0L);
    a();
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "sendHeartRequest");
    }
    Message localMessage = this.aJ.obtainMessage(5);
    this.aJ.sendMessageDelayed(localMessage, x);
  }
  
  private void n()
  {
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.ap = ((ImageView)findViewById(2131440585));
    this.aq = ((ImageView)findViewById(2131431534));
    this.ar = new AlphaAnimation(0.0F, 1.0F);
    this.ar.setDuration(1500L);
    this.ar.setFillAfter(true);
    o();
    this.j = new Point(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.i = new SnowView(this);
    this.i.setSnowView(this.j);
    this.h.addView(this.i);
    localObject = getLayoutInflater();
    View localView = ((LayoutInflater)localObject).inflate(2131624773, null);
    this.h.addView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131624774, null);
    this.h.addView((View)localObject);
    this.J = ((Face2FaceTroopDetailView)this.h.findViewById(2131447923));
    this.P = ((Face2FaceFriendDetailView)this.h.findViewById(2131433758));
    this.Q = ((EditText)this.P.findViewById(2131433768));
    this.R = ((TextView)this.P.findViewById(2131433825));
    this.S = ((LinearLayout)this.P.findViewById(2131433817));
    this.T = ((LinearLayout)this.P.findViewById(2131433818));
    this.Q.addTextChangedListener(new Face2FaceAddFriendActivity.2(this));
    this.J.setInfc(this.aH);
    this.P.setInfc(this.aH);
    this.ac = findViewById(2131446152);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.ac.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.ae = ((TextView)findViewById(2131446150));
    this.af = ((TextView)findViewById(2131446151));
    this.ae.setOnClickListener(this);
    this.ae.setOnTouchListener(this);
    if (this.e == 1)
    {
      this.af.setVisibility(0);
      this.af.setOnClickListener(this);
      this.af.setOnTouchListener(this);
      this.ae.setText(2131889053);
      return;
    }
    this.af.setVisibility(8);
  }
  
  private void o()
  {
    View localView = LayoutInflater.from(getApplicationContext()).inflate(2131624550, null);
    this.Z = new Face2FaceAddFriendAnim(this.app, this);
    this.Z.a(this.app, localView, this.e, this.f);
    this.h.addView(localView);
    this.ax = localView;
    if (this.e == 1)
    {
      this.g = false;
      this.ak = localView.findViewById(2131431182);
      this.al = ((TextView)localView.findViewById(2131431178));
      this.aj = ((TextView)localView.findViewById(2131431181));
      this.aj.setText(2131889155);
      this.aj.setVisibility(0);
      localView.findViewById(2131431179).setOnClickListener(this);
      this.ak.setOnClickListener(this);
      this.aj.setOnClickListener(this);
    }
  }
  
  private boolean p()
  {
    String str;
    if (this.e == 1) {
      str = "sp_facetoface_showguide_for_troop";
    } else {
      str = "sp_facetoface_showguide";
    }
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (localObject == null) {
      return false;
    }
    this.aI = ((SharedPreferences)localObject).getBoolean(str, false);
    if (this.aI) {
      return false;
    }
    localObject = LayoutInflater.from(getApplicationContext()).inflate(2131624551, null);
    Button localButton = (Button)((View)localObject).findViewById(2131432717);
    ((View)localObject).setBackgroundResource(2130840318);
    ((View)localObject).setOnClickListener(this);
    if (this.e == 1) {
      ((TextView)((View)localObject).findViewById(2131432716)).setText(2131889127);
    }
    this.h.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1));
    localButton.setOnClickListener(new Face2FaceAddFriendActivity.4(this, str, (View)localObject));
    return true;
  }
  
  private void q()
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mergeShowList isFriendDataBack=");
      ((StringBuilder)localObject2).append(this.r);
      ((StringBuilder)localObject2).append("isTroopDataBack=");
      ((StringBuilder)localObject2).append(this.s);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mergeShowList isFriendBackSuccess=");
      ((StringBuilder)localObject2).append(this.t);
      ((StringBuilder)localObject2).append("isTroopBackSuccess=");
      ((StringBuilder)localObject2).append(this.u);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i1 = this.t;
    if (i1 != 0)
    {
      int i2 = this.u;
      if (i2 != 0)
      {
        if ((i1 == 1) && (i2 == 1) && ((!this.r) || (!this.s)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "mergeShowList return");
          }
          return;
        }
        if (this.v)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "mergeShowList return has merged");
          }
          return;
        }
        i1 = this.m.size();
        i2 = this.n.size();
        this.v = true;
        this.G += i1;
        this.H += i2;
        if (QLog.isColorLevel())
        {
          localObject1 = a;
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
            localObject1 = new ArrayList(b(this.m, 5));
            localObject2 = new ArrayList(a(this.n, 5));
            a(this.p, (List)localObject1);
            a(this.p, (List)localObject2);
          }
          else if (i1 < 5)
          {
            this.p.addAll(this.m);
            localObject1 = new ArrayList(a(this.n, 10 - this.m.size()));
            a(this.p, (List)localObject1);
          }
          else if (i2 < 5)
          {
            localObject1 = new ArrayList(b(this.m, 10 - this.n.size()));
            a(this.p, (List)localObject1);
          }
          localObject1 = this.p.iterator();
          i1 = 0;
          while (((Iterator)localObject1).hasNext()) {
            if (g((Face2FaceUserData)((Iterator)localObject1).next())) {
              i1 += 1;
            }
          }
          i2 = 0;
          while ((i2 < i1) && (i())) {
            i2 += 1;
          }
        }
        a(this.p, this.m);
        a(this.p, this.n);
        if (QLog.isColorLevel())
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mergeShowList size=");
          ((StringBuilder)localObject2).append(this.p.size());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        this.aa = true;
        i1 = this.k;
        if (i1 > 0) {
          a(false, i1, false);
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "mergeShowList return wait successStatus");
    }
  }
  
  private void r()
  {
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(this.U, 3021, 0, "");
  }
  
  private void s()
  {
    if (this.e == 0)
    {
      addObserver(this.aB);
      addObserver(this.aA);
    }
    addObserver(this.aD);
    addObserver(this.aC);
    addObserver(this.aE);
    addObserver(this.aM);
  }
  
  private void t()
  {
    if (this.e == 0)
    {
      removeObserver(this.aB);
      removeObserver(this.aA);
    }
    removeObserver(this.aD);
    removeObserver(this.aC);
    removeObserver(this.aE);
    removeObserver(this.aM);
  }
  
  private void u()
  {
    if ((!this.app.isVideoChatting()) && (!this.app.isRingerVibrate()) && (!this.app.isRingEqualsZero()) && (this.app.isCallIdle()) && (this.an)) {
      AudioUtil.b(2131230817, false);
    }
  }
  
  private void v()
  {
    if ((this.C) && (this.D))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "clearSystemMsgData");
      }
      this.I.markSystemMsgReaded();
    }
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "findReplaceData ");
    }
    Object localObject1 = null;
    Face2FaceUserData localFace2FaceUserData1 = A();
    Face2FaceUserData localFace2FaceUserData2 = C();
    Object localObject2 = z();
    Face2FaceUserData localFace2FaceUserData3 = B();
    if (this.m.size() + this.n.size() < 10)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("findReplaceData friend count=");
        ((StringBuilder)localObject2).append(this.m.size());
        ((StringBuilder)localObject2).append("troop count");
        ((StringBuilder)localObject2).append(this.n.size());
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
      this.p.add(localObject1);
      int i1 = this.p.size();
      int i2 = this.k;
      if (i1 == i2 + 1) {
        a(true, i2, false);
      }
    }
  }
  
  private Face2FaceUserData x()
  {
    Object localObject2;
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.ao)))
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getHasShowFriendData正在查看详情Uin");
      ((StringBuilder)localObject2).append(this.ao.substring(0, 4));
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.q.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Face2FaceUserData)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty(this.ao)) && (((Face2FaceUserData)localObject2).f.equals(this.ao)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "getHasShowFriendData需要替换但是正在查看详情");
        }
      }
      else if ((((Face2FaceUserData)localObject2).e == 1) && (b(((Face2FaceUserData)localObject2).f)))
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break label218;
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty(((Face2FaceUserData)localObject2).f)) {
          break label218;
        }
        localObject1 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHasShowFriendData可替换好友");
        localStringBuilder.append(((Face2FaceUserData)localObject2).f.substring(0, 4));
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
        localObject1 = localObject2;
        break label218;
      }
    }
    localObject1 = null;
    label218:
    if ((localObject1 == null) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "getHasShowFriendData 没有可替换好友");
    }
    return localObject1;
  }
  
  private Face2FaceUserData y()
  {
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((!this.J.d()) || (!this.J.o.equals(localFace2FaceUserData)))
      {
        if ((this.e == 1) && (this.az.contains(localFace2FaceUserData))) {
          return localFace2FaceUserData;
        }
        if ((localFace2FaceUserData.e == 2) && (a(localFace2FaceUserData.f))) {
          return localFace2FaceUserData;
        }
      }
    }
    return null;
  }
  
  private Face2FaceUserData z()
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (b(localFace2FaceUserData.f)) && (!this.q.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  public int a(long paramLong)
  {
    aL.setTimeInMillis(paramLong);
    return aL.get(11);
  }
  
  String a(int paramInt)
  {
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    String str = "";
    localStringBuilder.append("");
    localObject = ((FriendsManager)localObject).u(localStringBuilder.toString());
    if (localObject != null) {
      str = ((Groups)localObject).group_name;
    }
    return str;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openFace2FaceTroop, from_type=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", fromTroopUin=");
      localStringBuilder.append(this.f);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (NearFieldTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
    if ((localObject != null) && (this.ah != null))
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "openFace2FaceTroop, NetworkUtil.isNetSupport==false");
        }
        QQToast.makeText(this.app.getApplication(), 2131892104, 0).show(getTitleBarHeight());
        return;
      }
      ThreadManager.post(new Face2FaceAddFriendActivity.1(this, (NearFieldTroopHandler)localObject), 8, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "openFace2FaceTroop, getBusinessHandler==null");
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.aa)
    {
      if (this.ab == true) {
        this.ab = false;
      }
      this.aa = false;
      a(false, this.k, false);
      return;
    }
    if ((paramInt == 1) && (this.ab))
    {
      this.aJ.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    if (paramBoolean) {
      this.aJ.sendEmptyMessageDelayed(8, 0L);
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
      this.ap.setVisibility(0);
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4)
            {
              this.ap.setBackgroundResource(2130840316);
              this.aq.setBackgroundResource(2130840318);
            }
          }
          else
          {
            this.ap.setBackgroundResource(2130840319);
            this.aq.setBackgroundResource(2130840316);
          }
        }
        else
        {
          this.ap.setBackgroundResource(2130840317);
          this.aq.setBackgroundResource(2130840319);
        }
      }
      else
      {
        this.ap.setBackgroundResource(2130840318);
        this.aq.setBackgroundResource(2130840317);
      }
      this.aq.startAnimation(this.ar);
      this.ar.setAnimationListener(new Face2FaceAddFriendActivity.22(this));
    }
    else
    {
      this.ap.setVisibility(4);
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4) {
              this.aq.setBackgroundResource(2130840318);
            }
          }
          else {
            this.aq.setBackgroundResource(2130840316);
          }
        }
        else {
          this.aq.setBackgroundResource(2130840319);
        }
      }
      else {
        this.aq.setBackgroundResource(2130840317);
      }
    }
    if (QLog.isColorLevel())
    {
      String str = c;
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
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteGroupData mhasShowList = ");
      localStringBuilder.append(this.q.size());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.q.contains(paramFace2FaceGroupProfile))
    {
      this.Z.a(paramFace2FaceGroupProfile, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFace2FaceGroupProfile.f);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramFace2FaceGroupProfile.b);
      localObject = ((StringBuilder)localObject).toString();
      this.Z.b((String)localObject);
      this.p.remove(paramFace2FaceGroupProfile);
      this.n.remove(paramFace2FaceGroupProfile);
      int i1 = this.k;
      if (i1 > 0) {
        this.k = (i1 - 1);
      }
      w();
      return;
    }
    this.n.remove(paramFace2FaceGroupProfile);
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 14;
    localMessage.obj = paramFace2FaceUserData;
    this.aJ.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onADDShowData isPush");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("currentFriendIndex=");
      localStringBuilder.append(this.k);
      localStringBuilder.append("isFilterShow=hasFriend=");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.q.add(paramFace2FaceUserData);
  }
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile)
  {
    Object localObject1 = this.Z;
    if (localObject1 != null)
    {
      if (paramFace2FaceUserProfile == null) {
        return;
      }
      localObject1 = ((Face2FaceAddFriendAnim)localObject1).a(paramFace2FaceUserProfile.f);
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
      this.aJ.sendMessageDelayed((Message)localObject1, 1500L);
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
  
  public boolean a(Face2FaceUserData paramFace2FaceUserData, List<Face2FaceUserData> paramList)
  {
    if (paramList.contains(paramFace2FaceUserData))
    {
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramFace2FaceUserData.f)))
      {
        paramList = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("datalist has contains data");
        localStringBuilder.append(paramFace2FaceUserData.f.substring(0, 4));
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
      localObject = localTroopManager.f(((StringBuilder)localObject).toString());
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
      localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeFace2faceTroop, from_type=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", fromTroopUin=");
      localStringBuilder.append(this.f);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (NearFieldTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "closeFace2faceTroop, getBusinessHandler==null");
      }
      return;
    }
    if (this.e == 1) {
      if (TextUtils.isEmpty(this.f)) {
        return;
      }
    }
    try
    {
      ((NearFieldTroopHandler)localObject).b(Long.valueOf(this.f).longValue(), 1);
      return;
    }
    catch (Exception localException) {}
    ((NearFieldTroopHandler)localObject).b(0L, 1);
    return;
  }
  
  public void b(Face2FaceUserData paramFace2FaceUserData)
  {
    if ((this.Z != null) && (paramFace2FaceUserData != null))
    {
      Face2FaceAddFriendActivity.RefreshHandler localRefreshHandler = this.aJ;
      if (localRefreshHandler == null) {
        return;
      }
      localRefreshHandler.removeMessages(14, paramFace2FaceUserData);
      paramFace2FaceUserData = this.Z.a(paramFace2FaceUserData.f);
      if (paramFace2FaceUserData != null) {
        paramFace2FaceUserData.setAnimation(new AlphaAnimation(1.0F, 1.0F));
      }
    }
  }
  
  public void b(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.k += 1;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInAnimEnd isPush");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("currentFriendIndex=");
      localStringBuilder.append(this.k);
      localStringBuilder.append("isFilterShow=hasFriend=");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    a(paramBoolean1, this.k, false);
    if (this.e == 1) {
      a(paramFace2FaceUserData);
    }
  }
  
  public void c()
  {
    this.am = true;
    if (this.L == null)
    {
      localObject = LayoutInflater.from(getApplicationContext());
      this.K = ((LayoutInflater)localObject).inflate(2131624777, null);
      View localView = this.K.findViewById(2131447465);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      this.h.addView(this.K);
      this.L = ((XListView)this.K.findViewById(2131447873));
      localView = this.K.findViewById(2131432715);
      this.L.setEmptyView(localView);
      localObject = ((LayoutInflater)localObject).inflate(2131624775, this.L, false);
      this.M = ((TextView)((View)localObject).findViewById(2131447871));
      this.L.addHeaderView((View)localObject);
      localObject = (TextView)this.K.findViewById(2131436188);
      ((TextView)localObject).setOnClickListener(this);
      ((TextView)localObject).setOnTouchListener(this);
      ((TextView)localObject).setPadding(((TextView)localObject).getPaddingLeft(), 0, ((TextView)localObject).getPaddingRight(), 0);
      this.N = new Face2FaceTroopFriendListAdapter(this, this.L);
    }
    else
    {
      this.K.setVisibility(0);
    }
    this.N.a(this.m);
    this.M.setText(String.valueOf(this.N.getCount()));
    Object localObject = AnimationUtils.loadAnimation(this, 2130771996);
    this.K.startAnimation((Animation)localObject);
  }
  
  public void c(Face2FaceUserData paramFace2FaceUserData)
  {
    if (this.q.contains(paramFace2FaceUserData)) {
      this.q.remove(paramFace2FaceUserData);
    }
  }
  
  public void d()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130771995);
    localAnimation.setAnimationListener(new Face2FaceAddFriendActivity.3(this));
    this.K.startAnimation(localAnimation);
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
    this.V = paramInt1;
    this.R.setText(a(paramInt1));
    this.X.put(this.O, Integer.valueOf(this.V));
  }
  
  public void doOnBackPressed()
  {
    Object localObject = this.J;
    if ((localObject != null) && (((Face2FaceTroopDetailView)localObject).d()))
    {
      this.J.e();
      return;
    }
    localObject = this.P;
    if ((localObject != null) && (((Face2FaceFriendDetailView)localObject).d()))
    {
      this.P.e();
      return;
    }
    if (this.am)
    {
      localObject = this.K;
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        d();
        return;
      }
    }
    if ((this.e == 1) && (this.g))
    {
      DialogUtil.a(this, 230, getString(2131917233), getString(2131889125), 2131887648, 2131889053, new Face2FaceAddFriendActivity.13(this), new Face2FaceAddFriendActivity.14(this)).show();
      return;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoTitle(2131624549);
    this.ai = SystemClock.elapsedRealtime();
    paramBundle = getIntent();
    Object localObject = paramBundle.getStringExtra("options");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      try
      {
        paramBundle = new JSONObject((String)localObject);
        this.e = paramBundle.optInt("activity_from_type");
        this.f = paramBundle.optString("activity_troop_uin");
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    else
    {
      this.e = paramBundle.getIntExtra("activity_from_type", 0);
      this.f = paramBundle.getStringExtra("activity_troop_uin");
    }
    if (QLog.isColorLevel())
    {
      paramBundle = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnCreate, from_type=");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(", fromTroopUin=");
      ((StringBuilder)localObject).append(this.f);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
    this.h = ((FrameLayout)findViewById(2131445137));
    this.ah = ((LBSHandler)this.app.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER));
    aL = Calendar.getInstance();
    n();
    s();
    this.I = ((INewFriendService)this.app.getRuntimeService(INewFriendService.class));
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this);
    if (AppNetConnInfo.getConnInfo() == -1) {
      QQToast.makeText(this.app.getApplication(), 2131892104, 0).show(getTitleBarHeight());
    }
    if (this.I.getUnreadSystemMessageCount() == 0) {
      this.C = true;
    } else {
      this.C = false;
    }
    if (p())
    {
      this.au = false;
      return true;
    }
    l();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    t();
    v();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "Face2FaceAddFriendActivity doOnDestroy");
    }
    this.aK = true;
    Face2FaceAddFriendConstants.c = System.currentTimeMillis();
    b();
    this.aJ.removeCallbacksAndMessages(null);
    this.aJ.removeMessages(5);
    this.aJ.removeMessages(7);
    this.aJ.removeMessages(9);
    this.aJ.removeMessages(4);
    this.aJ.removeMessages(11);
    Object localObject = this.ah;
    if (localObject != null) {
      ((LBSHandler)localObject).a(this.app.getCurrentAccountUin());
    } else if (QLog.isColorLevel()) {
      QLog.d(a, 2, "doOnDestroy mLbsHandler is null");
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    this.Z.a();
    if (this.E) {
      ReportController.b(null, "CliOper", "", "", "0X80050F2", "0X80050F2", 0, 0, "", "", "", "");
    }
    localObject = this.N;
    if (localObject != null) {
      ((Face2FaceTroopFriendListAdapter)localObject).c();
    }
    ReportController.b(null, "CliOper", "", "", "0X80050EC", "0X80050EC", 0, 0, String.valueOf(this.G), String.valueOf(this.H), "", "");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "doOnPause!");
    }
    this.an = false;
    QQAudioUtils.a(this, false);
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "doOnResume!");
    }
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(-16777216);
      this.mSystemBarComp.setStatusBarColor(-16777216);
    }
    this.an = true;
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
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("face2face doOnStart inface2faceTime=");
      localStringBuilder.append(a(Face2FaceAddFriendConstants.a));
      localStringBuilder.append("showBkAnim=");
      localStringBuilder.append(this.au);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.au)
    {
      if (Face2FaceAddFriendConstants.a >= Face2FaceAddFriendConstants.b)
      {
        a(Face2FaceAddFriendConstants.a, Face2FaceAddFriendConstants.b);
        return;
      }
      a(Face2FaceAddFriendConstants.a, 0L);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "doOnStop!");
    }
    h();
    this.aJ.removeMessages(4);
    Face2FaceAddFriendConstants.b = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("face2face doOnStop outface2faceTime=");
      localStringBuilder.append(a(Face2FaceAddFriendConstants.b));
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    int i1 = this.m.size();
    if (i1 > 0)
    {
      Object localObject = this.aj;
      if ((localObject != null) && (((TextView)localObject).getVisibility() == 0)) {
        this.aj.setVisibility(8);
      }
      localObject = this.ak;
      if ((localObject != null) && (((View)localObject).getVisibility() != 0)) {
        this.ak.setVisibility(0);
      }
      this.al.setText(String.valueOf(i1));
    }
  }
  
  public void f()
  {
    if (this.e != 1) {
      return;
    }
    this.aJ.removeMessages(9);
    long l1 = SystemClock.elapsedRealtime() - this.ai;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkTroopShareValidity, durition=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", mInitTroopShareTimeStamp=");
      localStringBuilder.append(this.ai);
      QLog.d("time_tick", 2, localStringBuilder.toString());
    }
    if (l1 >= 1200000L)
    {
      DialogUtil.a(this, 230, getString(2131917233), "此次分享已满20分钟", 2131887648, 2131889053, new Face2FaceAddFriendActivity.6(this), null).show();
      return;
    }
    this.aJ.sendEmptyMessageDelayed(9, 10000L);
  }
  
  public void g()
  {
    this.aJ.a(100L);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("snow", 2, "stopSnow");
    }
    this.aJ.removeMessages(0);
  }
  
  public boolean i()
  {
    Face2FaceUserData localFace2FaceUserData2;
    int i1;
    label168:
    do
    {
      Face2FaceUserData localFace2FaceUserData1;
      do
      {
        Iterator localIterator1 = this.p.iterator();
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
              if ((localFace2FaceUserData1.e != 1) || (!b(localFace2FaceUserData1.f))) {
                break;
              }
              localIterator2 = this.n.iterator();
            } while (!localIterator2.hasNext());
            localFace2FaceUserData2 = (Face2FaceUserData)localIterator2.next();
            if ((this.p.contains(localFace2FaceUserData2)) || (a(localFace2FaceUserData2.f))) {
              break;
            }
            i1 = this.p.indexOf(localFace2FaceUserData1);
            if (i1 == -1) {
              break;
            }
            this.p.set(i1, localFace2FaceUserData2);
            return true;
          } while ((localFace2FaceUserData1.e != 2) || (!a(localFace2FaceUserData1.f)));
          localIterator2 = this.m.iterator();
        }
        localFace2FaceUserData2 = (Face2FaceUserData)localIterator2.next();
      } while ((this.p.contains(localFace2FaceUserData2)) || (b(localFace2FaceUserData2.f)));
      i1 = this.p.indexOf(localFace2FaceUserData1);
    } while (i1 == -1);
    this.p.set(i1, localFace2FaceUserData2);
    return true;
    label247:
    return false;
  }
  
  public void j()
  {
    this.aJ.sendEmptyMessageDelayed(8, 0L);
  }
  
  protected int k()
  {
    int i1;
    if (this.q.size() < this.p.size()) {
      i1 = (this.p.size() - this.q.size()) * 500 + 2500;
    } else {
      i1 = 2000;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getReplaceDelay=");
      localStringBuilder.append(i1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((!this.P.d()) && (i1 != 2131432769)) {
      if (i1 == 2131446150) {
        doOnBackPressed();
      } else if ((i1 != 2131446151) && (i1 != 2131431179) && (i1 != 2131431182) && (i1 != 2131431181))
      {
        if (i1 == 2131436188)
        {
          if (this.e == 1) {
            d();
          }
        }
        else
        {
          Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)paramView;
          Object localObject1;
          Object localObject2;
          if (localFace2FaceFriendBubbleView.getUinType() == 1)
          {
            String str = localFace2FaceFriendBubbleView.getUin();
            if (TextUtils.isEmpty(str))
            {
              if (QLog.isColorLevel()) {
                QLog.d(a, 2, "getBubbleview uin is null");
              }
            }
            else
            {
              this.ao = str;
              if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.ao)))
              {
                localObject1 = a;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("showdetail 进入详情页mShowDetailUin=");
                ((StringBuilder)localObject2).append(this.ao.substring(0, 4));
                QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
              }
              localObject2 = this.app.getFaceBitmap(str, (byte)3, true);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = ImageUtil.k();
              }
              localObject2 = (NearbyUser)localFace2FaceFriendBubbleView.getBindFriendInfo();
              if (localObject2 == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(a, 2, "getBubbleview nearbyUser is null");
                }
              }
              else
              {
                if (((NearbyUser)localObject2).b.equals("")) {
                  localObject2 = ((NearbyUser)localObject2).c;
                } else {
                  localObject2 = ((NearbyUser)localObject2).b;
                }
                a(localFace2FaceFriendBubbleView.getStatus(), str, localFace2FaceFriendBubbleView, (String)localObject2, (Bitmap)localObject1);
                ReportController.b(null, "CliOper", "", "", "0X80050ED", "0X80050ED", 0, 0, "", "", "", "");
                if (this.e == 1) {
                  ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_detail", 0, 0, this.f, "", "", "");
                }
              }
            }
          }
          else if (localFace2FaceFriendBubbleView.getUinType() == 2)
          {
            localObject1 = localFace2FaceFriendBubbleView.getBindFriendInfo();
            if (localObject1 != null)
            {
              this.U = ((Face2FaceUserData)localObject1).f;
              this.ao = this.U;
              localObject2 = new Face2FaceAddFriendActivity.15(this, (Face2FaceUserData)localObject1);
              this.J.setBindData((Face2FaceUserData)localObject1, (View.OnClickListener)localObject2);
              this.J.a(this.h, localFace2FaceFriendBubbleView);
              if (this.e == 1) {
                b((Face2FaceUserData)localObject1);
              }
            }
            ReportController.b(null, "CliOper", "", "", "0X80050EE", "0X80050EE", 0, 0, "", "", "", "");
          }
        }
      }
      else if (this.e == 1) {
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
    this.aJ.sendEmptyMessage(18);
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
      QLog.d(a, 2, "onNetWifi2None");
    }
    this.aJ.sendEmptyMessage(18);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446150: 
    case 2131446151: 
      paramView = (TextView)paramView;
      if (paramMotionEvent.getAction() == 0) {
        paramView.setTextColor(getResources().getColor(2131167940));
      } else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setTextColor(getResources().getColor(2131168464));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity
 * JD-Core Version:    0.7.0.1
 */