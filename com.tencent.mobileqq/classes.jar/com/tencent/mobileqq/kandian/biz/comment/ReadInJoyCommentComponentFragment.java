package com.tencent.mobileqq.kandian.biz.comment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.ZhituSendListener;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.account.api.impl.RIJUserProtoUtils;
import com.tencent.mobileqq.kandian.biz.biu.AtFriendsSpan;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionTextWatcher;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.event.AddCommentLinkEvent;
import com.tencent.mobileqq.kandian.biz.comment.helper.DraftDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUi;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUi;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView.OnLinkDeleteListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.ugc.Utils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentComponentFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, SimpleEventReceiver, ZhituManager.ZhituSendListener, CommentLinkView.OnLinkDeleteListener
{
  private static final Editable.Factory aC = new ReadInJoyCommentComponentFragment.6();
  protected PublicAccountHotPicPanel A;
  protected int B = 1;
  protected int C = 1;
  protected boolean D = false;
  protected boolean E = false;
  protected boolean F = false;
  protected int G = 140;
  protected String H;
  protected int I = 0;
  protected int J = 0;
  protected boolean K = false;
  protected HotPicData L = null;
  protected int M = 0;
  protected int N = 0;
  protected boolean O = false;
  protected FrameLayout P = null;
  protected ViewGroup.LayoutParams Q = null;
  protected final MqqHandler R = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  TransProcessorHandler S = new ReadInJoyCommentComponentFragment.5(this);
  protected TextWatcher T = new ReadInJoyCommentComponentFragment.11(this);
  protected ViewTreeObserver.OnGlobalLayoutListener U = new ReadInJoyCommentComponentFragment.12(this);
  private ImageView V;
  private ImageView W;
  private CommentLinkView X;
  private View Y;
  private List<BaseCommentData.CommentLinkData> Z;
  protected RelativeLayout a;
  private boolean aA = true;
  private int aB = 0;
  private XPanelContainer.PanelCallback aD = new ReadInJoyCommentComponentFragment.7(this);
  private EmoticonCallback aE = new ReadInJoyCommentComponentFragment.8(this);
  private PublicAccountGifListener aF = new ReadInJoyCommentComponentFragment.9(this);
  private AbsBaseArticleInfo aG = null;
  private long aH = 0L;
  private String aI = "";
  private String aJ = "";
  private String[] aK = null;
  private int aL = 0;
  private boolean aa = true;
  private boolean ab = true;
  private boolean ac;
  private boolean ad = false;
  private ZhituPicData ae = null;
  private BaseActivity af = null;
  private SharedPreferences ag = null;
  private boolean ah = false;
  private boolean ai = false;
  private boolean aj = false;
  private boolean ak = false;
  private String al = null;
  private String am = "";
  private String an = "";
  private int ao = -1;
  private int ap = 1;
  private int aq = 1;
  private int ar = 0;
  private boolean as = false;
  private boolean at = false;
  private boolean au = true;
  private SimpleCommentData av = null;
  private int aw;
  private boolean ax;
  private RIJCommentTopicUi ay;
  private RIJCommentAtUi az;
  protected RelativeLayout b;
  protected ImageView c;
  protected ImageView d;
  protected ImageView e;
  protected BiuEditText f;
  protected ImageView g;
  protected ImageView h;
  protected TextView i;
  protected Button j;
  protected ImageView k;
  protected RelativeLayout l;
  protected QQProgressDialog m;
  protected ImageView n;
  protected TextView o;
  protected LinearLayout p;
  protected ImageView q;
  protected RelativeLayout r;
  protected RelativeLayout s;
  protected LinearLayout t;
  protected TextView u;
  protected TextView v;
  protected ImageView w;
  protected Button x;
  protected XPanelContainer y;
  protected IEmoticonMainPanel z;
  
  private void A()
  {
    B();
    z();
  }
  
  private void B()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    Bundle localBundle = new Bundle();
    int i2 = this.aw;
    Object localObject = this.Z;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((List)localObject).size();
    }
    localObject = getBaseActivity();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://viola.qq.com/js/commLinkSelector.js?_rij_violaUrl=1&v_tid=6&v_bundleName=commLinkSelector&hideNav=1&v_nav_immer=1&v_bid=3740&remainLinkCount=");
    localStringBuilder.append(i2 - i1);
    RIJJumpUtils.a((Context)localObject, localStringBuilder.toString(), localBundle);
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.aG), "0X800B085", "0X800B085", 0, 0, "", "", "", C(), false);
  }
  
  private String C()
  {
    return a(null);
  }
  
  private ZhituManager D()
  {
    Object localObject = this.af;
    if (localObject != null)
    {
      if (((BaseActivity)localObject).app == null) {
        return null;
      }
      localObject = this.af.app;
      Bundle localBundle = getArguments();
      if ((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) {
        return null;
      }
      if (ReadInJoyHelper.G((AppRuntime)localObject) != 0) {
        return null;
      }
      localObject = ZhituManager.a((AppInterface)localObject);
      if ((localObject != null) && (((ZhituManager)localObject).n())) {
        return localObject;
      }
    }
    return null;
  }
  
  private boolean E()
  {
    return ReadInJoyHelper.M(this.af.app) == 1;
  }
  
  private void F()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.aG;
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (((!RIJItemViewTypeUtils.e(this.aG)) && (ArticleInfoHelper.b(this.aG))) || (this.aG.mSocialFeedInfo.d()))) {
      this.ab = false;
    }
    if (!this.ab)
    {
      this.p.setVisibility(8);
      this.D = false;
    }
  }
  
  private void G()
  {
    if ((RIJBiuAndCommentAladdinUtils.a()) && (this.au)) {
      this.at = true;
    }
    if (!this.at)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 1, "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return;
    }
    H();
    J();
    M();
  }
  
  private void H()
  {
    this.p.setVisibility(8);
    this.j.setVisibility(8);
    this.r.setVisibility(0);
    if (TextUtils.isEmpty(this.aJ)) {
      this.s.setVisibility(0);
    }
    I();
  }
  
  private void I()
  {
    this.aK = RIJBiuAndCommentAladdinUtils.c().split("\\|");
    if (this.aK.length > 0) {
      this.aL = new Random().nextInt(this.aK.length);
    }
    if (!TextUtils.isEmpty(this.aK[this.aL])) {
      this.u.setText(this.aK[this.aL]);
    }
    String str = RIJBiuAndCommentAladdinUtils.d();
    if (!TextUtils.isEmpty(str)) {
      this.x.setText(str);
    }
    if (RIJBiuAndCommentAladdinUtils.h())
    {
      this.t.setVisibility(8);
      return;
    }
    this.t.setVisibility(0);
    str = RIJBiuAndCommentAladdinUtils.e();
    if (!TextUtils.isEmpty(str)) {
      this.v.setText(str);
    }
    if (RIJBiuAndCommentAladdinUtils.f()) {
      c(true);
    }
    if (RIJBiuAndCommentAladdinUtils.g())
    {
      if (((Boolean)RIJSPUtils.b("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue())
      {
        c(true);
        return;
      }
      c(false);
    }
  }
  
  private void J()
  {
    ReadInJoyCommentComponentFragment.13 local13 = new ReadInJoyCommentComponentFragment.13(this);
    this.t.setOnClickListener(local13);
    this.x.setOnClickListener(local13);
    this.u.setOnClickListener(local13);
  }
  
  private void K()
  {
    L();
    if (!w()) {
      return;
    }
    if (RIJBiuAndCommentAladdinUtils.g()) {
      RIJSPUtils.a("rij_sp_editor_last_check", Boolean.valueOf(this.E));
    }
    p();
    this.af.setResult(1699, N());
    this.af.finish();
  }
  
  private void L()
  {
    if (this.aG == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnClick | mArticleInfo is null");
      return;
    }
    String str;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("feeds_type", this.aG.mFeedType);
      ((JSONObject)localObject).put("feedsid", this.aG.mFeedId);
      ((JSONObject)localObject).put("version", VideoReporter.a);
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("entry", 1);
      ((JSONObject)localObject).put("place", 1);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, localJSONException.getMessage());
      str = "";
    }
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.aG), "0X800AB7B", "0X800AB7B", 0, 0, String.valueOf(this.aG.mArticleID), String.valueOf(this.J), this.aG.innerUniqueID, str, false);
  }
  
  private void M()
  {
    if (this.aG == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnExposure | mArticleInfo is null");
      return;
    }
    String str;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("feeds_type", this.aG.mFeedType);
      ((JSONObject)localObject).put("feedsid", this.aG.mFeedId);
      ((JSONObject)localObject).put("version", VideoReporter.a);
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("entry", 1);
      ((JSONObject)localObject).put("place", 1);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, localJSONException.getMessage());
      str = "";
    }
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.aG), "0X800AB7A", "0X800AB7A", 0, 0, String.valueOf(this.aG.mArticleID), String.valueOf(this.J), this.aG.innerUniqueID, str, false);
  }
  
  private Intent N()
  {
    String str1 = new String(Base64Util.encode(b().getBytes(), 0));
    Intent localIntent = x();
    Object localObject4 = new JSONObject();
    Object localObject3 = localObject4;
    Object localObject2;
    try
    {
      String str2 = localIntent.getStringExtra("arg_result_json");
      Object localObject1 = localObject4;
      localObject3 = localObject4;
      if (!TextUtils.isEmpty(str2))
      {
        localObject3 = localObject4;
        localObject1 = new JSONObject(str2);
      }
      localObject3 = localObject1;
      if (this.aj)
      {
        localObject3 = localObject1;
        if (TextUtils.isEmpty(this.al))
        {
          localObject4 = "";
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = this.al;
        }
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("replyUin", localObject4);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("isSecondReply", this.ak);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("commentId", this.am);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("commentUin", this.an);
      }
      localObject3 = localObject1;
      ((JSONObject)localObject1).put("comment", str1);
      localObject3 = localObject1;
      ((JSONObject)localObject1).put("select_to_friend", this.E);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject2 = localObject3;
    }
    localIntent.putExtra("arg_result_json", localObject2.toString());
    int i1;
    if (TextUtils.isEmpty(this.aJ)) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    localIntent.putExtra("click_comment_edit_src", i1);
    localIntent.putExtra("comment_article_info", this.aG);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("showCommentEditorNew getBiuAndCommentIntent result json is ");
    ((StringBuilder)localObject3).append(localObject2.toString());
    QLog.d("ReadInJoyCommentComponentFragment", 1, ((StringBuilder)localObject3).toString());
    return localIntent;
  }
  
  private String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    try
    {
      paramJSONObject.put("os", 1);
      Object localObject = this.av;
      if (localObject != null)
      {
        paramJSONObject.put("entry", this.av.j());
      }
      else
      {
        localObject = ReadInJoyCommentDataManager.a(this.aG);
        if (localObject != null) {
          paramJSONObject.put("entry", ((ReadInJoyCommentDataManager)localObject).a());
        } else {
          paramJSONObject.put("entry", 0);
        }
      }
      paramJSONObject.put("comment_level", ReadInJoyCommentUtils.a(this.ak, this.av, this.am));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject.toString();
  }
  
  private JSONObject a(boolean paramBoolean)
  {
    return a(paramBoolean, null);
  }
  
  private JSONObject a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        Object localObject;
        if (paramBoolean)
        {
          if (this.D)
          {
            localObject = "0";
            paramJSONObject.put("biu_comment", localObject);
          }
        }
        else
        {
          paramJSONObject.put("os", 1);
          localObject = this.av;
          if (localObject != null)
          {
            paramJSONObject.put("entry", this.av.j());
            paramJSONObject.put("scene", this.av.f());
            return paramJSONObject;
          }
          localObject = ReadInJoyCommentDataManager.a(this.aG);
          if (localObject != null) {
            paramJSONObject.put("entry", ((ReadInJoyCommentDataManager)localObject).a());
          } else {
            paramJSONObject.put("entry", 0);
          }
          paramJSONObject.put("scene", 0);
          return paramJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return paramJSONObject;
      }
      String str = "1";
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("comment_is_show_pic", false))
    {
      this.q.setVisibility(0);
      this.q.setOnClickListener(this);
      return;
    }
    this.q.setVisibility(8);
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    Object localObject = paramIntent.getStringExtra("comment_recreate_draft");
    paramIntent = (Intent)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramIntent = DraftDataUtil.b(l());
    }
    localObject = paramIntent;
    if (TextUtils.isEmpty(paramIntent)) {
      localObject = paramBundle.getString("defaultTxt", "");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.f.setText((CharSequence)localObject);
      this.f.setSelection(((CharSequence)localObject).length());
      y();
      return;
    }
    paramIntent = this.i;
    if (paramIntent != null) {
      paramIntent.setText(String.valueOf(this.G));
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.containsKey("isPgcAuthor"))
    {
      this.ax = paramBundle.getBoolean("isPgcAuthor");
      return;
    }
    paramBundle = this.aG;
    boolean bool;
    if ((paramBundle != null) && (ReadInJoyCommentDataManager.c(paramBundle.innerUniqueID))) {
      bool = true;
    } else {
      bool = false;
    }
    this.ax = bool;
  }
  
  private void a(View paramView)
  {
    this.r = ((RelativeLayout)paramView.findViewById(2131429558));
    this.s = ((RelativeLayout)paramView.findViewById(2131429561));
    this.t = ((LinearLayout)paramView.findViewById(2131429555));
    this.u = ((TextView)paramView.findViewById(2131429562));
    this.w = ((ImageView)paramView.findViewById(2131429557));
    this.x = ((Button)paramView.findViewById(2131429556));
    this.v = ((TextView)paramView.findViewById(2131429559));
  }
  
  private void a(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if (paramCommentLinkData != null)
    {
      if (this.Z == null) {
        this.Z = new ArrayList();
      }
      this.Z.add(paramCommentLinkData);
      this.X.setData(this.Z);
      this.X.setVisibility(0);
      this.Y.setVisibility(0);
    }
  }
  
  private void a(String paramString1, String paramString2, @NotNull Editable paramEditable, @NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList, @NotNull BiuNicknameSpan[] paramArrayOfBiuNicknameSpan)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(Arrays.asList(paramArrayOfBiuNicknameSpan));
    Collections.sort((List)localObject, new ReadInJoyCommentComponentFragment.BiuSpanComparator(this, paramEditable));
    Iterator localIterator = ((ArrayList)localObject).iterator();
    long l1 = 0L;
    int i2 = 0;
    int i1 = 0;
    String str;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      localObject = null;
      paramArrayOfBiuNicknameSpan = null;
      if (!bool) {
        break;
      }
      BiuNicknameSpan localBiuNicknameSpan = (BiuNicknameSpan)localIterator.next();
      int i4 = paramEditable.getSpanStart(localBiuNicknameSpan);
      int i3 = paramEditable.getSpanEnd(localBiuNicknameSpan);
      try
      {
        localObject = paramEditable.subSequence(i2, i4).toString();
        paramArrayOfBiuNicknameSpan = (BiuNicknameSpan[])localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (paramArrayOfBiuNicknameSpan != null)
      {
        str = Utils.a(paramArrayOfBiuNicknameSpan, paramString1).replaceAll("\n|\r\n", "");
        paramArrayOfBiuNicknameSpan = str;
        if (i2 == 0) {
          paramArrayOfBiuNicknameSpan = str.substring(str.indexOf(str.trim()));
        }
        paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, paramString2, l1, EmotionCodecUtils.a(Utils.b(paramArrayOfBiuNicknameSpan, paramString1)), i1));
      }
      if ((localBiuNicknameSpan instanceof AtFriendsSpan)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      paramString2 = localBiuNicknameSpan.a;
      l1 = localBiuNicknameSpan.b;
      i2 = i3;
    }
    try
    {
      paramEditable = paramEditable.subSequence(i2, paramEditable.length()).toString();
    }
    catch (Exception paramEditable)
    {
      paramEditable.printStackTrace();
      paramEditable = str;
    }
    if (paramEditable != null)
    {
      paramEditable = Utils.a(paramEditable, paramString1).replaceAll("\n|\r\n", "");
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, paramString2, l1, EmotionCodecUtils.a(Utils.b(paramEditable.substring(0, paramEditable.indexOf(paramEditable.trim()) + paramEditable.trim().length()), paramString1)), i1));
    }
  }
  
  private boolean a(String paramString, @NotNull Editable paramEditable, @NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    boolean bool1;
    if ((!TextUtils.isEmpty(this.aI)) && (!TextUtils.isEmpty(this.aJ)) && (this.aG != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((RIJFeedsType.e(this.aG)) && (this.ao == 1)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    String str1 = UUID.randomUUID().toString();
    String str2 = Utils.a(paramEditable.toString(), str1).trim();
    boolean bool3;
    if (TextUtils.isEmpty(str2))
    {
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, paramString, 0L, ""));
      bool3 = true;
    }
    else
    {
      bool3 = a(paramArrayList, paramString, paramEditable, str2, str1, bool1, bool2);
    }
    if (bool1)
    {
      paramString = new StringBuilder();
      paramString.append(": ");
      paramString.append(this.aI);
      this.aI = paramString.toString();
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, this.aJ, this.aG.mFeedId, this.aI, 0));
    }
    if (bool2) {
      b(paramArrayList);
    }
    return bool3;
  }
  
  private boolean a(@NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList, String paramString1, @NotNull Editable paramEditable, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    BiuNicknameSpan[] arrayOfBiuNicknameSpan = (BiuNicknameSpan[])paramEditable.getSpans(0, paramEditable.length(), BiuNicknameSpan.class);
    if ((arrayOfBiuNicknameSpan != null) && (arrayOfBiuNicknameSpan.length > 0))
    {
      a(paramString3, paramString1, paramEditable, paramArrayList, arrayOfBiuNicknameSpan);
      return false;
    }
    paramString2 = EmotionCodecUtils.a(Utils.b(paramString2.replaceAll("\n|\r\n", ""), paramString3));
    if (!paramBoolean1)
    {
      paramEditable = paramString2;
      if (!paramBoolean2) {}
    }
    else
    {
      paramEditable = new StringBuilder();
      paramEditable.append(paramString2);
      paramEditable.append("//");
      paramEditable = paramEditable.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append("：");
    paramString2.append(paramEditable);
    paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, paramString1, 0L, paramString2.toString()));
    return true;
  }
  
  private String b(boolean paramBoolean)
  {
    return b(paramBoolean, null);
  }
  
  private String b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    return a(paramBoolean, paramJSONObject).toString();
  }
  
  private void b(int paramInt)
  {
    this.B = paramInt;
    int i3 = 2130844023;
    int i4 = 2130844025;
    int i1;
    int i2;
    if (paramInt == 1)
    {
      localObject = this.y;
      i1 = i3;
      i2 = i4;
      if (localObject != null)
      {
        i1 = i3;
        i2 = i4;
        if (((XPanelContainer)localObject).getCurrentPanel() != 1)
        {
          this.y.a(1);
          i1 = i3;
          i2 = i4;
        }
      }
    }
    else if (paramInt == 2)
    {
      localObject = this.y;
      if ((localObject != null) && (((XPanelContainer)localObject).getCurrentPanel() != 3)) {
        this.y.a(3);
      }
      i1 = 2130851377;
      i2 = i4;
    }
    else if (paramInt == 3)
    {
      localObject = this.y;
      if ((localObject != null) && (((XPanelContainer)localObject).getCurrentPanel() != 24)) {
        this.y.a(24);
      }
      i2 = 2130851377;
      i1 = i3;
    }
    else
    {
      i1 = i3;
      i2 = i4;
      if (paramInt == 0)
      {
        localObject = this.y;
        i1 = i3;
        i2 = i4;
        if (localObject != null)
        {
          i1 = i3;
          i2 = i4;
          if (((XPanelContainer)localObject).getCurrentPanel() != 0)
          {
            this.y.b();
            i2 = i4;
            i1 = i3;
          }
        }
      }
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(i1);
    }
    localObject = this.h;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(i2);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (!paramBundle.getBoolean("arg_comment_gif_switch", true))
    {
      this.h.setVisibility(8);
      return;
    }
    if (ReadInJoyHelper.F(this.af.app) == 1) {
      this.h.setVisibility(8);
    }
  }
  
  private void b(@NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    Object localObject = this.aG;
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null) && (this.aG.mSocialFeedInfo.n != null) && (this.aG.mSocialFeedInfo.n.a != null))
    {
      localObject = this.aG.mSocialFeedInfo.n.a;
      int i2 = ((List)localObject).size();
      int i1 = 0;
      while (i1 < i2)
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)((List)localObject).get(i1);
        if (localBiuCommentInfo != null) {
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, String.valueOf(localBiuCommentInfo.mUin), localBiuCommentInfo.mFeedId.longValue(), localBiuCommentInfo.mBiuComment, localBiuCommentInfo.mOpType));
        }
        i1 += 1;
      }
    }
  }
  
  private void c(int paramInt)
  {
    this.ar = paramInt;
  }
  
  private void c(@NotNull Bundle paramBundle)
  {
    this.H = paramBundle.getString("placeholder", "");
    paramBundle = new StringBuilder();
    paramBundle.append("initData | comment_placeholder : ");
    paramBundle.append(this.H);
    QLog.d("ReadInJoyCommentComponentFragment", 2, paramBundle.toString());
    if (!TextUtils.isEmpty(this.H))
    {
      this.f.setHint(this.H);
      return;
    }
    this.f.setHint(HardCodeUtil.a(2131910450));
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.w.setImageResource(2130843904);
      this.E = true;
      return;
    }
    this.w.setImageResource(2130843903);
    this.E = false;
  }
  
  private void d(@NotNull Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("maxLength", -1);
    if (i1 > 0)
    {
      this.G = ReadInJoyHelper.b(i1);
    }
    else
    {
      this.G = ReadInJoyHelper.j();
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("initData | comment_mMaxCharCount : ");
        paramBundle.append(this.G);
        QLog.d("ReadInJoyCommentComponentFragment", 2, paramBundle.toString());
      }
    }
    if (this.G > 5000) {
      this.G = 5000;
    }
    if (this.G < 100) {
      this.G = 100;
    }
  }
  
  private void e(@NotNull Bundle paramBundle)
  {
    boolean bool2 = ReadInJoyHelper.k();
    boolean bool1 = this.ax;
    int i1 = 0;
    if ((bool1) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.aa = bool1;
    this.aw = ReadInJoyHelper.n();
    paramBundle = this.V;
    if ((!this.aa) || (this.aw <= 0)) {
      i1 = 8;
    }
    paramBundle.setVisibility(i1);
    paramBundle = new StringBuilder();
    paramBundle.append("linkSwitch = ");
    paramBundle.append(bool2);
    paramBundle.append(", insertLinkLimit = ");
    paramBundle.append(this.aw);
    paramBundle.append(", isPgcAuthor = ");
    paramBundle.append(this.ax);
    QLog.d("ReadInJoyCommentComponentFragment", 1, paramBundle.toString());
  }
  
  private void f(Bundle paramBundle)
  {
    boolean bool = TextUtils.isEmpty(this.H);
    int i3 = 1;
    int i1;
    if ((!bool) && (this.H.contains(getString(2131915287)))) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        if (this.aG != null) {
          localJSONObject.put("consume_time", TimeSliceHelper.a(this.aG.innerUniqueID, false) / 1000L);
        }
        localJSONObject.put("os", 1);
        localJSONObject.put("link_reply", paramBundle.getInt("comment_to_reply_contain_link", 2));
        paramBundle = this.av;
        if (paramBundle != null)
        {
          localJSONObject.put("entry", this.av.j());
          localJSONObject.put("scene", this.av.f());
        }
        else
        {
          paramBundle = ReadInJoyCommentDataManager.a(this.aG);
          if (paramBundle != null) {
            localJSONObject.put("entry", paramBundle.a());
          } else {
            localJSONObject.put("entry", 0);
          }
          localJSONObject.put("scene", 0);
        }
        if (!this.aa) {
          break label337;
        }
        i2 = 1;
        localJSONObject.put("link_entry", i2);
        if (this.W.getVisibility() != 0) {
          break label342;
        }
        i2 = 1;
        localJSONObject.put("subject", i2);
        if (this.e.getVisibility() != 0) {
          break label347;
        }
        i2 = i3;
        localJSONObject.put("at_entry", i2);
        paramBundle = localJSONObject.toString();
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        paramBundle = "";
      }
      PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.aG), "0X800844A", "0X800844A", 0, 0, String.valueOf(i1), String.valueOf(this.J), "", paramBundle, false);
      return;
      label337:
      int i2 = 0;
      continue;
      label342:
      i2 = 0;
      continue;
      label347:
      i2 = 0;
    }
  }
  
  private void i()
  {
    if (!this.aA) {
      return;
    }
    this.aA = false;
    int i1 = this.aB;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        this.C = 1;
        return;
      }
      this.C = 0;
      j();
      return;
    }
    this.C = 0;
    t();
  }
  
  private void j()
  {
    this.e.post(new ReadInJoyCommentComponentFragment.2(this));
  }
  
  private void k()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    if (localBundle.getBoolean("arg_comment_enable_anonymous", false)) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(8);
    }
    this.ab = localBundle.getBoolean("comment_can_biu", true);
    this.aB = localBundle.getInt("firstAction");
    c(localBundle);
    d(localBundle);
    b(localBundle);
    if (localBundle.getBoolean("arg_comment_transparent_bg", false)) {
      this.b.setBackgroundColor(0);
    }
    Object localObject = this.af.app.getCurrentAccountUin();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append((String)localObject);
    this.ag = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
    this.I = localBundle.getInt("commentType", 0);
    this.J = localBundle.getInt("sourceType", 0);
    this.ao = localBundle.getInt("click_comment_edit_src");
    this.as = localBundle.getBoolean("arg_ad_show_biu", true);
    this.au = localBundle.getBoolean("comment_type", true);
    this.av = ((SimpleCommentData)localBundle.getParcelable("comment_create_data"));
    localObject = this.af.getIntent();
    this.ak = ((Intent)localObject).getBooleanExtra("comment_reply_second", false);
    if (this.ak) {
      this.al = ((Intent)localObject).getStringExtra("comment_reply_second_uin");
    }
    this.aj = ((Intent)localObject).getBooleanExtra("comment_native", false);
    if (this.aj)
    {
      this.aG = ((AbsBaseArticleInfo)((Intent)localObject).getParcelableExtra("comment_article_info"));
      this.aI = ((Intent)localObject).getStringExtra("comment_val");
      this.aJ = ((Intent)localObject).getStringExtra("comment_author_uin");
      this.ap = ((Intent)localObject).getIntExtra("biu_src", 1);
      this.aq = ((Intent)localObject).getIntExtra("feedsType", 1);
      this.am = ((Intent)localObject).getStringExtra("comment_id");
      this.an = ((Intent)localObject).getStringExtra("first_comment_uin");
      this.ac = this.aG.mIsGalleryChannel;
      m();
    }
    a((Intent)localObject, localBundle);
    a(localBundle);
    e(localBundle);
    a((Intent)localObject);
    f(localBundle);
  }
  
  private String l()
  {
    return CommentArgumentModel.a(this.aG, this.am, this.av);
  }
  
  private void m()
  {
    if (n())
    {
      Object localObject = ReadInJoyCommentDataManager.a(this.aG);
      if (localObject != null)
      {
        localObject = ((ReadInJoyCommentDataManager)localObject).d();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initData | comment_default_input : ");
          localStringBuilder.append((String)localObject);
          QLog.d("ReadInJoyCommentComponentFragment", 2, localStringBuilder.toString());
          this.f.setHint((CharSequence)localObject);
        }
      }
    }
  }
  
  private boolean n()
  {
    return TextUtils.isEmpty(this.am);
  }
  
  private void o()
  {
    DraftDataUtil.a(l(), this.f.getEditableText());
  }
  
  private void p()
  {
    DraftDataUtil.a(l());
  }
  
  private void q()
  {
    if (this.ao == -1) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentComponentFragment.3(this));
  }
  
  private void r()
  {
    this.a.setVisibility(8);
    if (this.L != null) {
      PublicAccountReportUtils.a(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", b(false), false);
    } else if (this.ae != null) {
      PublicAccountReportUtils.a(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", b(false), false);
    }
    this.L = null;
    this.ae = null;
    y();
    this.n.setClickable(true);
    if (this.ai)
    {
      this.ai = false;
      this.n.setImageResource(2130843904);
    }
  }
  
  private void s()
  {
    this.F ^= true;
    if (this.F)
    {
      this.d.setBackgroundResource(2130843780);
      return;
    }
    this.d.setBackgroundResource(2130843779);
  }
  
  private void t()
  {
    int i2 = this.B;
    int i1 = 1;
    if (i2 == 2)
    {
      b(1);
    }
    else
    {
      b(2);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (this.aB == 1) {
          i1 = 2;
        }
        localJSONObject.put("place", i1);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoyCommentComponentFragment", 4, localJSONException.getMessage());
      }
      PublicAccountReportUtils.a(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", b(false, localJSONObject), false);
    }
    z();
  }
  
  private void u()
  {
    if (this.B == 3)
    {
      b(1);
    }
    else
    {
      b(3);
      PublicAccountReportUtils.a(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", b(false), false);
    }
    z();
  }
  
  private void v()
  {
    if (!w()) {
      return;
    }
    boolean bool = TextUtils.isEmpty(b());
    int i3 = 0;
    int i2;
    if (!bool) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1;
    if (this.L != null)
    {
      i1 = i2 + 2;
    }
    else
    {
      i1 = i2;
      if (this.ae != null) {
        i1 = i2 + 4;
      }
    }
    String str;
    if (this.ao == 1) {
      str = "0X80094A1";
    } else {
      str = "0X800844E";
    }
    JSONObject localJSONObject = a(true);
    for (;;)
    {
      try
      {
        if (this.Z == null) {
          break label319;
        }
        if (!this.Z.isEmpty()) {
          break label314;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        Iterator localIterator;
        localException.printStackTrace();
      }
      localJSONObject.put("link", i3);
      if (i2 == 0)
      {
        localStringBuilder = new StringBuilder();
        localIterator = this.Z.iterator();
        if (localIterator.hasNext())
        {
          localStringBuilder.append(((BaseCommentData.CommentLinkData)localIterator.next()).type);
          localStringBuilder.append(',');
          continue;
        }
        localJSONObject.put("link_type", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
      RIJEmotionUtil.a(this.f.getText(), localJSONObject);
      PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.aG), str, str, 0, 0, String.valueOf(this.I), String.valueOf(i1), "", localJSONObject.toString(), false);
      if (this.ae == null)
      {
        p();
        this.af.setResult(-1, x());
        this.af.finish();
        return;
      }
      a(2131892958);
      a(this.ae.b);
      return;
      label314:
      i2 = 0;
      break label321;
      label319:
      i2 = 1;
      label321:
      if (i2 == 0) {
        i3 = 1;
      }
    }
  }
  
  private boolean w()
  {
    if (this.K)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
      QQToast.makeText(this.af, 1, getString(2131915329), 0).show();
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(this.af))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
      }
      QQToast.makeText(this.af, 1, getString(2131915328), 0).show();
      return false;
    }
    return true;
  }
  
  private Intent x()
  {
    Intent localIntent = this.af.getIntent();
    Object localObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("isAnonymous", this.F);
        localObject1 = b().getBytes();
        i1 = 0;
        ((JSONObject)localObject2).put("comment", new String(Base64Util.encode((byte[])localObject1, 0)));
        RIJCommentRptDataUtil.a((JSONObject)localObject2, this.f.getText());
        localObject1 = this.ae;
        if ((localObject1 == null) && (this.L == null))
        {
          if (this.D) {
            i1 = 1;
          }
          ((JSONObject)localObject2).put("biuAfterComment", i1);
        }
        else
        {
          ((JSONObject)localObject2).put("biuAfterComment", 0);
        }
        if (this.aj)
        {
          if (TextUtils.isEmpty(this.al)) {
            localObject1 = "";
          } else {
            localObject1 = this.al;
          }
          ((JSONObject)localObject2).put("replyUin", localObject1);
          ((JSONObject)localObject2).put("isSecondReply", this.ak);
          ((JSONObject)localObject2).put("commentId", this.am);
          ((JSONObject)localObject2).put("commentUin", this.an);
        }
        if (this.D)
        {
          localObject1 = h();
          if (localObject1 != null) {
            ((JSONObject)localObject2).put("biu_info", localObject1);
          }
        }
        localObject1 = this.L;
        if (localObject1 != null)
        {
          localObject1 = new JSONArray();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("picType", 3);
          ((JSONObject)localObject3).put("url", this.L.originalUrl);
          ((JSONObject)localObject3).put("md5", this.L.originalMD5);
          ((JSONObject)localObject3).put("width", this.L.originalWidth);
          ((JSONObject)localObject3).put("height", this.L.originalHeight);
          ((JSONObject)localObject3).put("thumbnail_url", this.L.url);
          ((JSONObject)localObject3).put("thumbnail_md5", this.L.md5);
          ((JSONObject)localObject3).put("thumbnail_width", this.L.width);
          ((JSONObject)localObject3).put("thumbnail_height", this.L.height);
          ((JSONArray)localObject1).put(localObject3);
          ((JSONObject)localObject2).put("picInfoList", localObject1);
        }
        if ((this.Z != null) && (!this.Z.isEmpty())) {
          ((JSONObject)localObject2).put("linkList", new JSONArray(new Gson().toJson(this.Z)));
        }
        if ((this.ae == null) || (!this.ae.m)) {
          break label823;
        }
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.ae.b, (BitmapFactory.Options)localObject1);
        localObject3 = new JSONArray();
        localJSONObject = new JSONObject();
      }
      catch (JSONException localJSONException1)
      {
        Object localObject1;
        Object localObject3;
        JSONObject localJSONObject;
        boolean bool;
        continue;
      }
      try
      {
        localJSONObject.put("picType", 3);
        localJSONObject.put("url", this.ae.n);
        localJSONObject.put("md5", this.ae.o);
        localJSONObject.put("width", ((BitmapFactory.Options)localObject1).outWidth);
        localJSONObject.put("height", ((BitmapFactory.Options)localObject1).outHeight);
        localJSONObject.put("thumbnail_url", this.ae.n);
        localJSONObject.put("thumbnail_md5", this.ae.o);
        localJSONObject.put("thumbnail_width", ((BitmapFactory.Options)localObject1).outWidth);
        localJSONObject.put("thumbnail_height", ((BitmapFactory.Options)localObject1).outHeight);
        ((JSONArray)localObject3).put(localJSONObject);
        ((JSONObject)localObject2).put("picInfoList", localObject3);
        localObject1 = localIntent;
        localObject2 = ((JSONObject)localObject2).toString();
        ReadInJoyUserInfoModule.a(Long.parseLong(RIJQQAppInterfaceUtil.d()), null);
        bool = QLog.isColorLevel();
        i1 = 2;
        if (bool)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("finish resultJson=");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d("ReadInJoyCommentComponentFragment", 2, ((StringBuilder)localObject3).toString());
        }
      }
      catch (JSONException localJSONException2)
      {
        continue;
      }
      try
      {
        ((Intent)localObject1).putExtra("arg_result_json", (String)localObject2);
        ((Intent)localObject1).putExtra("comment_article_info", this.aG);
        ((Intent)localObject1).putExtra("comment_gallery_channel", this.ac);
        ((Intent)localObject1).putExtra("comment_cmd", this.ar);
        if (!TextUtils.isEmpty(this.aJ)) {
          break label826;
        }
        ((Intent)localObject1).putExtra("click_comment_edit_src", i1);
        return localObject1;
      }
      catch (JSONException localJSONException3)
      {
        return localJSONException2;
      }
      return localIntent;
      return localIntent;
      label823:
      continue;
      label826:
      int i1 = 3;
    }
  }
  
  private void y()
  {
    Object localObject = this.L;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject == null) {
      if (this.ae != null) {
        bool1 = bool2;
      } else if (!TextUtils.isEmpty(b())) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.j.setEnabled(bool1);
    localObject = this.x;
    if (localObject != null) {
      ((Button)localObject).setEnabled(bool1);
    }
  }
  
  private void z()
  {
    ZhituManager localZhituManager = D();
    if ((localZhituManager != null) && (this.ad))
    {
      localZhituManager.o();
      this.ad = false;
      this.k.setSelected(false);
    }
  }
  
  public void a()
  {
    if (this.f != null)
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f.getWindowToken(), 0);
      this.f.clearFocus();
    }
  }
  
  protected void a(int paramInt)
  {
    QQProgressDialog localQQProgressDialog = this.m;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.c(paramInt);
      if (!this.m.isShowing()) {
        this.m.show();
      }
    }
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    QQToast.makeText(this.af, paramInt, paramCharSequence, 0).show(this.af.getTitleBarHeight());
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onZhituSend:");
      localStringBuilder.append(paramZhituPicData);
      QLog.d("ReadInJoyCommentComponentFragment", 2, localStringBuilder.toString());
    }
    this.ae = paramZhituPicData;
    this.L = null;
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.10(this, paramZhituPicData));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUploadPic path=");
      localStringBuilder.append(paramString);
      QLog.d("ReadInJoyCommentComponentFragment", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      g();
      a(1, getString(2131915349));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentComponentFragment.4(this, paramString));
  }
  
  protected boolean a(ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return true;
    }
    Editable localEditable = ((BiuEditText)localObject).getText();
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = "0";
    }
    if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString()))) {
      return a((String)localObject, localEditable, paramArrayList);
    }
    paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, (String)localObject, 0L, ""));
    return false;
  }
  
  protected String b()
  {
    Object localObject = this.f.getEditableText();
    if ((localObject != null) && (((Editable)localObject).length() > 0)) {
      localObject = ReadInJoyCommentUtils.a(localObject.toString(), true);
    } else {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCommentString result=");
      localStringBuilder.append((String)localObject);
      QLog.d("ReadInJoyCommentComponentFragment", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void c()
  {
    List localList = this.Z;
    if ((localList == null) || (localList.isEmpty()))
    {
      this.X.setVisibility(8);
      this.Y.setVisibility(8);
    }
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.aG), "0X800B086", "0X800B086", 0, 0, "", "", "", C(), false);
  }
  
  protected void d()
  {
    if ((this.ae == null) && (this.L == null))
    {
      if (!this.D)
      {
        this.n.setImageResource(2130843904);
        this.D = true;
      }
      else
      {
        this.n.setImageResource(2130843903);
        this.D = false;
      }
      String str;
      if (this.D) {
        str = "0";
      } else {
        str = "1";
      }
      PublicAccountReportUtils.a(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", b(false), false);
      return;
    }
    QQToast.makeText(this.n.getContext(), HardCodeUtil.a(2131910477), 0).show();
  }
  
  protected void e()
  {
    c(1);
    this.af.setResult(-1, x());
    this.af.finish();
  }
  
  protected void f()
  {
    ZhituManager localZhituManager = D();
    if (localZhituManager != null) {
      if (this.ad)
      {
        z();
      }
      else
      {
        Editable localEditable = this.f.getText();
        if (!localZhituManager.a(localEditable))
        {
          QQToast.makeText(this.f.getContext(), HardCodeUtil.a(2131910267), 0).show();
          return;
        }
        if (localEditable.length() > 24)
        {
          QQToast.makeText(this.f.getContext(), "24个字符以内才支持转为智图。", 0).show();
          return;
        }
        localZhituManager.a(this.af, this.l, null, null, false, this.R);
        if (localZhituManager.a.getChildCount() > 1) {
          localZhituManager.a.removeViewAt(0);
        }
        localZhituManager.a(this.af.app, localEditable, null, 7220, false);
        localZhituManager.a(this);
        this.ad = true;
        this.k.setSelected(true);
        this.R.removeMessages(84);
        this.R.sendEmptyMessageDelayed(84, 10000L);
      }
    }
    PublicAccountReportUtils.a(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", b(false), false);
  }
  
  protected void g()
  {
    QQProgressDialog localQQProgressDialog = this.m;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.m.dismiss();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AddCommentLinkEvent.class);
    return localArrayList;
  }
  
  public JSONObject h()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      a(localArrayList);
      JSONObject localJSONObject1 = new JSONObject();
      new SocializeFeedsInfo().n = new BiuInfo();
      if ((this.aG.mSocialFeedInfo != null) && (this.aG.mSocialFeedInfo.n != null))
      {
        localJSONObject1.put("mOriFeedType", this.aG.mSocialFeedInfo.n.c);
        localJSONObject1.put("mOriFeedId", this.aG.mSocialFeedInfo.n.b);
      }
      localJSONObject1.put("biuSrc", this.ap);
      localJSONObject1.put("feedtype", this.aq);
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        ReadInJoyCommentComponentFragment.UserBiuInfo localUserBiuInfo = (ReadInJoyCommentComponentFragment.UserBiuInfo)localArrayList.get(i1);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localUserBiuInfo.c);
        localJSONObject2.put("biu_feedid", new Long(localUserBiuInfo.d));
        localJSONObject2.put("biu_optype", localUserBiuInfo.e);
        localJSONObject2.put("biu_uin", localUserBiuInfo.a);
        localJSONObject2.put("biu_nickname", localUserBiuInfo.b);
        localJSONArray.put(localJSONObject2);
        i1 += 1;
      }
      localJSONObject1.put("biuinfo", localJSONArray);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      label270:
      break label270;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "build article info error!");
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 84)
    {
      this.R.removeMessages(84);
      z();
    }
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setSoftInputMode(17);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.az.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    this.af.setResult(0, x());
    q();
    o();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131450395: 
      f();
      return;
    case 2131437253: 
      A();
      return;
    case 2131435535: 
      e();
      return;
    case 2131435438: 
      r();
      return;
    case 2131434224: 
      u();
      return;
    case 2131432400: 
      t();
      return;
    case 2131431725: 
      v();
      return;
    case 2131429565: 
      d();
      return;
    case 2131429220: 
      this.af.doOnBackPressed();
      return;
    case 2131428383: 
      s();
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.af = getBaseActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131626159, paramViewGroup, false);
    this.b = ((RelativeLayout)paramLayoutInflater.findViewById(2131429220));
    this.b.setOnClickListener(this);
    this.a = ((RelativeLayout)paramLayoutInflater.findViewById(2131435434));
    this.c = ((ImageView)paramLayoutInflater.findViewById(2131435435));
    this.c.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131435438).setOnClickListener(this);
    this.d = ((ImageView)paramLayoutInflater.findViewById(2131428383));
    this.d.setOnClickListener(this);
    this.g = ((ImageView)paramLayoutInflater.findViewById(2131432400));
    this.g.setOnClickListener(this);
    this.h = ((ImageView)paramLayoutInflater.findViewById(2131434224));
    this.q = ((ImageView)paramLayoutInflater.findViewById(2131435535));
    if (!HotPicManager.a(this.af.app).j()) {
      this.h.setVisibility(8);
    } else {
      this.h.setOnClickListener(this);
    }
    this.V = ((ImageView)paramLayoutInflater.findViewById(2131437253));
    this.V.setOnClickListener(this);
    this.X = ((CommentLinkView)paramLayoutInflater.findViewById(2131437262));
    this.X.setOnLinkEmptyListener(this);
    this.Y = paramLayoutInflater.findViewById(2131437259);
    this.i = ((TextView)paramLayoutInflater.findViewById(2131430525));
    this.j = ((Button)paramLayoutInflater.findViewById(2131431725));
    this.j.setOnClickListener(this);
    this.f = ((BiuEditText)paramLayoutInflater.findViewById(2131435808));
    this.f.requestFocus();
    try
    {
      this.f.setEditableFactory(aC);
    }
    catch (Exception paramViewGroup)
    {
      QLog.e("ReadInJoyCommentComponentFragment", 1, "input set error", paramViewGroup);
    }
    this.f.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
    paramViewGroup = this.f;
    paramViewGroup.addTextChangedListener(new RIJEmotionTextWatcher(paramViewGroup));
    this.y = ((XPanelContainer)paramLayoutInflater.findViewById(2131445137));
    this.y.a(this.f, false);
    this.y.setOnPanelChangeListener(this.aD);
    this.k = ((ImageView)paramLayoutInflater.findViewById(2131450395));
    this.k.setOnClickListener(this);
    this.l = ((RelativeLayout)paramLayoutInflater.findViewById(2131450398));
    this.W = ((ImageView)paramLayoutInflater.findViewById(2131447759));
    this.ay = new RIJCommentTopicUi(this.W, this.f, new ReadInJoyCommentComponentFragment.FuncReportRunnable(this, "0X800B9E0", null));
    this.e = ((ImageView)paramLayoutInflater.findViewById(2131428820));
    this.az = new RIJCommentAtUi(getActivity(), this.e, this.f, new ReadInJoyCommentComponentFragment.FuncReportRunnable(this, "0X800BAC1", null));
    this.f.addTextChangedListener(this.T);
    a(paramLayoutInflater);
    k();
    this.N = ImmersiveUtils.getStatusBarHeight(this.af);
    boolean bool;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.O = bool;
    this.P = ((FrameLayout)this.af.findViewById(2131433667));
    this.Q = this.P.getLayoutParams();
    this.y.getViewTreeObserver().addOnGlobalLayoutListener(this.U);
    if (ThemeUtil.isInNightMode(this.af.getAppRuntime()))
    {
      paramViewGroup = paramLayoutInflater.findViewById(2131439328);
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(0);
      }
    }
    paramViewGroup = this.af;
    this.m = new QQProgressDialog(paramViewGroup, paramViewGroup.getTitleBarHeight());
    this.m.setCanceledOnTouchOutside(true);
    this.n = ((ImageView)paramLayoutInflater.findViewById(2131431062));
    this.o = ((TextView)paramLayoutInflater.findViewById(2131431726));
    this.p = ((LinearLayout)paramLayoutInflater.findViewById(2131429565));
    try
    {
      if (this.aG.mSocialFeedInfo.t.f) {
        this.as = false;
      }
    }
    catch (NullPointerException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
    this.p.setVisibility(8);
    if (E())
    {
      this.n.setImageResource(2130843904);
      this.D = true;
    }
    F();
    G();
    RIJDtReportHelper.a.a(getBaseActivity());
    return paramLayoutInflater;
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.f;
    if (localObject != null) {
      ((BiuEditText)localObject).removeTextChangedListener(this.T);
    }
    localObject = this.ag;
    if (localObject != null)
    {
      ((SharedPreferences)localObject).edit().putBoolean("readinjoy_comment_biu_switch", this.D);
      this.ag.edit().commit();
    }
    localObject = this.z;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    localObject = this.A;
    if (localObject != null) {
      ((PublicAccountHotPicPanel)localObject).setPublicAccountGifListener(null);
    }
    localObject = this.y;
    if (localObject != null)
    {
      ((XPanelContainer)localObject).setReadyToShow(false);
      this.y.e();
      this.y.setOnPanelChangeListener(null);
      if (Build.VERSION.SDK_INT >= 16) {
        this.y.getViewTreeObserver().removeOnGlobalLayoutListener(this.U);
      }
    }
    localObject = D();
    if (localObject != null) {
      ((ZhituManager)localObject).a(null);
    }
    if (this.af == null) {
      this.af = getBaseActivity();
    }
    localObject = this.af;
    if (localObject != null) {
      ((ITransFileController)((BaseActivity)localObject).app.getRuntimeService(ITransFileController.class)).removeHandle(this.S);
    }
    a();
    localObject = this.f;
    if (localObject != null) {
      ((BiuEditText)localObject).a();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.ay.a();
    this.ay = null;
  }
  
  public void onFinish()
  {
    BaseActivity localBaseActivity = this.af;
    if (localBaseActivity != null) {
      localBaseActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    this.C = this.B;
    if (this.C == 0) {
      b(1);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AddCommentLinkEvent)) {
      a(((AddCommentLinkEvent)paramSimpleBaseEvent).linkData);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    AbstractGifImage.resumeAll();
    if (this.C == 1) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentComponentFragment.1(this), 300L);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    RIJUserProtoUtils.INSTANCE.check(getBaseActivity(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */