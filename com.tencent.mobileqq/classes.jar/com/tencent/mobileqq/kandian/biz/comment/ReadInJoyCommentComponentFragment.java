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
import com.tencent.mobileqq.kandian.biz.account.api.IRIJUserProtoUtils;
import com.tencent.mobileqq.kandian.biz.biu.AtFriendsSpan;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionTextWatcher;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.event.AddCommentLinkEvent;
import com.tencent.mobileqq.kandian.biz.comment.helper.DraftDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUi;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUi;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView.OnLinkDeleteListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
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
  private static final Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new ReadInJoyCommentComponentFragment.5();
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup.LayoutParams a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected Button a;
  protected FrameLayout a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  private ZhituPicData jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData = null;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new ReadInJoyCommentComponentFragment.7(this);
  protected IEmoticonMainPanel a;
  protected HotPicData a;
  private PublicAccountGifListener jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = new ReadInJoyCommentComponentFragment.8(this);
  protected PublicAccountHotPicPanel a;
  protected BiuEditText a;
  private SimpleCommentData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData = null;
  private RIJCommentAtUi jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataAtRIJCommentAtUi;
  private RIJCommentTopicUi jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataTopicRIJCommentTopicUi;
  private CommentLinkView jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentLinkView;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = null;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ReadInJoyCommentComponentFragment.4(this);
  protected QQProgressDialog a;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = new ReadInJoyCommentComponentFragment.6(this);
  protected XPanelContainer a;
  protected String a;
  private List<BaseCommentData.CommentLinkData> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  protected boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  protected int b;
  protected Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected RelativeLayout b;
  protected TextView b;
  private String b;
  protected boolean b;
  protected int c;
  protected ImageView c;
  protected RelativeLayout c;
  protected TextView c;
  private String c;
  protected boolean c;
  protected int d;
  protected ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  private String d;
  protected boolean d;
  protected int e;
  protected ImageView e;
  protected RelativeLayout e;
  private String e;
  protected boolean e;
  protected int f;
  protected ImageView f;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  protected int g;
  protected ImageView g;
  private boolean g;
  private int jdField_h_of_type_Int = -1;
  protected ImageView h;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 1;
  protected ImageView i;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int = 1;
  private ImageView jdField_j_of_type_AndroidWidgetImageView;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = 0;
  private ImageView jdField_k_of_type_AndroidWidgetImageView;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int = 0;
  private boolean jdField_m_of_type_Boolean = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = true;
  private boolean q;
  
  public ReadInJoyCommentComponentFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 140;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = null;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_AndroidTextTextWatcher = new ReadInJoyCommentComponentFragment.10(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ReadInJoyCommentComponentFragment.11(this);
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnClick | mArticleInfo is null");
      return;
    }
    String str;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("feeds_type", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType);
      ((JSONObject)localObject).put("feedsid", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
      ((JSONObject)localObject).put("version", VideoReporter.jdField_a_of_type_JavaLangString);
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X800AB7B", "0X800AB7B", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, str, false);
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnExposure | mArticleInfo is null");
      return;
    }
    String str;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("feeds_type", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType);
      ((JSONObject)localObject).put("feedsid", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
      ((JSONObject)localObject).put("version", VideoReporter.jdField_a_of_type_JavaLangString);
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X800AB7A", "0X800AB7A", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, str, false);
  }
  
  private Intent a()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    Object localObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("isAnonymous", this.jdField_c_of_type_Boolean);
        localObject1 = a().getBytes();
        i1 = 0;
        ((JSONObject)localObject2).put("comment", new String(Base64Util.encode((byte[])localObject1, 0)));
        RIJCommentRptDataUtil.a((JSONObject)localObject2, this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getText());
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData;
        if ((localObject1 == null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null))
        {
          if (this.jdField_a_of_type_Boolean) {
            i1 = 1;
          }
          ((JSONObject)localObject2).put("biuAfterComment", i1);
        }
        else
        {
          ((JSONObject)localObject2).put("biuAfterComment", 0);
        }
        if (this.jdField_l_of_type_Boolean)
        {
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            localObject1 = "";
          } else {
            localObject1 = this.jdField_b_of_type_JavaLangString;
          }
          ((JSONObject)localObject2).put("replyUin", localObject1);
          ((JSONObject)localObject2).put("isSecondReply", this.jdField_m_of_type_Boolean);
          ((JSONObject)localObject2).put("commentId", this.jdField_c_of_type_JavaLangString);
          ((JSONObject)localObject2).put("commentUin", this.jdField_d_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = a();
          if (localObject1 != null) {
            ((JSONObject)localObject2).put("biu_info", localObject1);
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData;
        if (localObject1 != null)
        {
          localObject1 = new JSONArray();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("picType", 3);
          ((JSONObject)localObject3).put("url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalUrl);
          ((JSONObject)localObject3).put("md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalMD5);
          ((JSONObject)localObject3).put("width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalWidth);
          ((JSONObject)localObject3).put("height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalHeight);
          ((JSONObject)localObject3).put("thumbnail_url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url);
          ((JSONObject)localObject3).put("thumbnail_md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.md5);
          ((JSONObject)localObject3).put("thumbnail_width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.width);
          ((JSONObject)localObject3).put("thumbnail_height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.height);
          ((JSONArray)localObject1).put(localObject3);
          ((JSONObject)localObject2).put("picInfoList", localObject1);
        }
        if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          ((JSONObject)localObject2).put("linkList", new JSONArray(new Gson().toJson(this.jdField_a_of_type_JavaUtilList)));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_c_of_type_Boolean)) {
          break label822;
        }
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
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
        localJSONObject.put("url", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_f_of_type_JavaLangString);
        localJSONObject.put("md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.g);
        localJSONObject.put("width", ((BitmapFactory.Options)localObject1).outWidth);
        localJSONObject.put("height", ((BitmapFactory.Options)localObject1).outHeight);
        localJSONObject.put("thumbnail_url", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_f_of_type_JavaLangString);
        localJSONObject.put("thumbnail_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.g);
        localJSONObject.put("thumbnail_width", ((BitmapFactory.Options)localObject1).outWidth);
        localJSONObject.put("thumbnail_height", ((BitmapFactory.Options)localObject1).outHeight);
        ((JSONArray)localObject3).put(localJSONObject);
        ((JSONObject)localObject2).put("picInfoList", localObject3);
        localObject1 = localIntent;
        localObject2 = ((JSONObject)localObject2).toString();
        ReadInJoyUserInfoModule.a(Long.parseLong(RIJQQAppInterfaceUtil.a()), null);
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
        ((Intent)localObject1).putExtra("comment_article_info", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        ((Intent)localObject1).putExtra("comment_gallery_channel", this.jdField_h_of_type_Boolean);
        ((Intent)localObject1).putExtra("comment_cmd", this.jdField_k_of_type_Int);
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          break label825;
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
      label822:
      continue;
      label825:
      int i1 = 3;
    }
  }
  
  private ZhituManager a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localObject != null)
    {
      if (((BaseActivity)localObject).app == null) {
        return null;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      Bundle localBundle = getArguments();
      if ((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) {
        return null;
      }
      if (ReadInJoyHelper.i((AppRuntime)localObject) != 0) {
        return null;
      }
      localObject = ZhituManager.a((AppInterface)localObject);
      if ((localObject != null) && (((ZhituManager)localObject).e())) {
        return localObject;
      }
    }
    return null;
  }
  
  private String a(boolean paramBoolean)
  {
    return a(paramBoolean).toString();
  }
  
  private JSONObject a(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        Object localObject;
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = "0";
            localJSONObject.put("biu_comment", localObject);
          }
        }
        else
        {
          localJSONObject.put("os", 1);
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData;
          if (localObject != null)
          {
            localJSONObject.put("entry", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData.d());
            localJSONObject.put("scene", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData.b());
            return localJSONObject;
          }
          localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
          if (localObject != null) {
            localJSONObject.put("entry", ((ReadInJoyCommentDataManager)localObject).a());
          } else {
            localJSONObject.put("entry", 0);
          }
          localJSONObject.put("scene", 0);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject;
      }
      String str = "1";
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("comment_is_show_pic", false))
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    Object localObject = paramIntent.getStringExtra("comment_recreate_draft");
    paramIntent = (Intent)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramIntent = DraftDataUtil.a(b());
    }
    localObject = paramIntent;
    if (TextUtils.isEmpty(paramIntent)) {
      localObject = paramBundle.getString("arg_comment_default_txt", "");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.setSelection(((CharSequence)localObject).length());
      q();
      return;
    }
    paramIntent = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramIntent != null) {
      paramIntent.setText(String.valueOf(this.jdField_c_of_type_Int));
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.containsKey("comment_is_pgc_author"))
    {
      this.q = paramBundle.getBoolean("comment_is_pgc_author");
      return;
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool;
    if ((paramBundle != null) && (ReadInJoyCommentDataManager.a(paramBundle.innerUniqueID))) {
      bool = true;
    } else {
      bool = false;
    }
    this.q = bool;
  }
  
  private void a(View paramView)
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363645));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363648));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363642));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363649));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363644));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363643));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363646));
  }
  
  private void a(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if (paramCommentLinkData != null)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramCommentLinkData);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentLinkView.setData(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentLinkView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      paramString2 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
      l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
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
  
  private void a(@NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList;
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
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130842948);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130842947);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    return TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
  }
  
  private boolean a(String paramString, @NotNull Editable paramEditable, @NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    boolean bool1;
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((RIJFeedsType.e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (this.jdField_h_of_type_Int == 1)) {
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
      paramString.append(this.jdField_e_of_type_JavaLangString);
      this.jdField_e_of_type_JavaLangString = paramString.toString();
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId, this.jdField_e_of_type_JavaLangString, 0));
    }
    if (bool2) {
      a(paramArrayList);
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
  
  private Intent b()
  {
    String str1 = new String(Base64Util.encode(a().getBytes(), 0));
    Intent localIntent = a();
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
      if (this.jdField_l_of_type_Boolean)
      {
        localObject3 = localObject1;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          localObject4 = "";
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = this.jdField_b_of_type_JavaLangString;
        }
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("replyUin", localObject4);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("isSecondReply", this.jdField_m_of_type_Boolean);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("commentId", this.jdField_c_of_type_JavaLangString);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("commentUin", this.jdField_d_of_type_JavaLangString);
      }
      localObject3 = localObject1;
      ((JSONObject)localObject1).put("comment", str1);
      localObject3 = localObject1;
      ((JSONObject)localObject1).put("select_to_friend", this.jdField_b_of_type_Boolean);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject2 = localObject3;
    }
    localIntent.putExtra("arg_result_json", localObject2.toString());
    int i1;
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    localIntent.putExtra("click_comment_edit_src", i1);
    localIntent.putExtra("comment_article_info", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("showCommentEditorNew getBiuAndCommentIntent result json is ");
    ((StringBuilder)localObject3).append(localObject2.toString());
    QLog.d("ReadInJoyCommentComponentFragment", 1, ((StringBuilder)localObject3).toString());
    return localIntent;
  }
  
  private String b()
  {
    return CommentArgumentModel.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int i3 = 2130843068;
    int i4 = 2130843070;
    int i1;
    int i2;
    if (paramInt == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
      i1 = i3;
      i2 = i4;
      if (localObject != null)
      {
        i1 = i3;
        i2 = i4;
        if (((XPanelContainer)localObject).a() != 1)
        {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
          i1 = i3;
          i2 = i4;
        }
      }
    }
    else if (paramInt == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
      if ((localObject != null) && (((XPanelContainer)localObject).a() != 3)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      }
      i1 = 2130849672;
      i2 = i4;
    }
    else if (paramInt == 3)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
      if ((localObject != null) && (((XPanelContainer)localObject).a() != 24)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(24);
      }
      i2 = 2130849672;
      i1 = i3;
    }
    else
    {
      i1 = i3;
      i2 = i4;
      if (paramInt == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
        i1 = i3;
        i2 = i4;
        if (localObject != null)
        {
          i1 = i3;
          i2 = i4;
          if (((XPanelContainer)localObject).a() != 0)
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
            i2 = i4;
            i1 = i3;
          }
        }
      }
    }
    Object localObject = this.jdField_d_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(i1);
    }
    localObject = this.jdField_e_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(i2);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (!paramBundle.getBoolean("arg_comment_gif_switch", true))
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (ReadInJoyHelper.h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app) == 1) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private boolean b()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, getString(2131717856), 0).a();
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, getString(2131717855), 0).a();
      return false;
    }
    return true;
  }
  
  private String c()
  {
    JSONObject localJSONObject = new JSONObject();
    int i2 = 1;
    for (;;)
    {
      try
      {
        localJSONObject.put("os", 1);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData;
        if (localObject != null)
        {
          localJSONObject.put("entry", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData.d());
        }
        else
        {
          localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
          if (localObject != null) {
            localJSONObject.put("entry", ((ReadInJoyCommentDataManager)localObject).a());
          } else {
            localJSONObject.put("entry", 0);
          }
        }
        if ((this.jdField_m_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData instanceof SubCommentCreateData))) {
          break label156;
        }
        i1 = i2;
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          i1 = i2;
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData == null) {
            i1 = 0;
          }
        }
        localJSONObject.put("comment_level", i1);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject.toString();
      label156:
      int i1 = 2;
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  private void c(@NotNull Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("arg_comment_placeholder", "");
    paramBundle = new StringBuilder();
    paramBundle.append("initData | comment_placeholder : ");
    paramBundle.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("ReadInJoyCommentComponentFragment", 2, paramBundle.toString());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.setHint(this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.setHint(HardCodeUtil.a(2131712880));
  }
  
  private boolean c()
  {
    return ReadInJoyHelper.o(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app) == 1;
  }
  
  private void d(@NotNull Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("arg_comment_max_length", -1);
    if (i1 > 0)
    {
      this.jdField_c_of_type_Int = ReadInJoyHelper.a(i1);
    }
    else
    {
      this.jdField_c_of_type_Int = ReadInJoyHelper.a();
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("initData | comment_mMaxCharCount : ");
        paramBundle.append(this.jdField_c_of_type_Int);
        QLog.d("ReadInJoyCommentComponentFragment", 2, paramBundle.toString());
      }
    }
    if (this.jdField_c_of_type_Int > 5000) {
      this.jdField_c_of_type_Int = 5000;
    }
    if (this.jdField_c_of_type_Int < 100) {
      this.jdField_c_of_type_Int = 100;
    }
  }
  
  private void e(@NotNull Bundle paramBundle)
  {
    boolean bool2 = ReadInJoyHelper.e();
    boolean bool1 = this.q;
    int i1 = 0;
    if ((bool1) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_f_of_type_Boolean = bool1;
    this.jdField_l_of_type_Int = ReadInJoyHelper.b();
    paramBundle = this.jdField_j_of_type_AndroidWidgetImageView;
    if ((!this.jdField_f_of_type_Boolean) || (this.jdField_l_of_type_Int <= 0)) {
      i1 = 8;
    }
    paramBundle.setVisibility(i1);
    paramBundle = new StringBuilder();
    paramBundle.append("linkSwitch = ");
    paramBundle.append(bool2);
    paramBundle.append(", insertLinkLimit = ");
    paramBundle.append(this.jdField_l_of_type_Int);
    paramBundle.append(", isPgcAuthor = ");
    paramBundle.append(this.q);
    QLog.d("ReadInJoyCommentComponentFragment", 1, paramBundle.toString());
  }
  
  private void f(Bundle paramBundle)
  {
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    int i3 = 1;
    int i1;
    if ((!bool) && (this.jdField_a_of_type_JavaLangString.contains(getString(2131717812)))) {
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
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) {
          localJSONObject.put("consume_time", TimeSliceHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, false) / 1000L);
        }
        localJSONObject.put("os", 1);
        localJSONObject.put("link_reply", paramBundle.getInt("comment_to_reply_contain_link", 2));
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData;
        if (paramBundle != null)
        {
          localJSONObject.put("entry", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData.d());
          localJSONObject.put("scene", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData.b());
        }
        else
        {
          paramBundle = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
          if (paramBundle != null) {
            localJSONObject.put("entry", paramBundle.a());
          } else {
            localJSONObject.put("entry", 0);
          }
          localJSONObject.put("scene", 0);
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label347;
        }
        i2 = 1;
        localJSONObject.put("link_entry", i2);
        if (this.jdField_k_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break label352;
        }
        i2 = 1;
        localJSONObject.put("subject", i2);
        if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break label357;
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
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X800844A", "0X800844A", 0, 0, String.valueOf(i1), String.valueOf(this.jdField_e_of_type_Int), "", paramBundle, false);
      return;
      label347:
      int i2 = 0;
      continue;
      label352:
      i2 = 0;
      continue;
      label357:
      i2 = 0;
    }
  }
  
  private void g()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    if (localBundle.getBoolean("arg_comment_enable_anonymous", false)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_g_of_type_Boolean = localBundle.getBoolean("comment_can_biu", true);
    c(localBundle);
    d(localBundle);
    b(localBundle);
    if (localBundle.getBoolean("arg_comment_transparent_bg", false)) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append((String)localObject);
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
    this.jdField_d_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
    this.jdField_e_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
    this.jdField_h_of_type_Int = localBundle.getInt("click_comment_edit_src");
    this.n = localBundle.getBoolean("arg_ad_show_biu", true);
    this.p = localBundle.getBoolean("comment_type", true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData = ((SimpleCommentData)localBundle.getParcelable("comment_create_data"));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_m_of_type_Boolean = ((Intent)localObject).getBooleanExtra("comment_reply_second", false);
    if (this.jdField_m_of_type_Boolean) {
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_reply_second_uin");
    }
    this.jdField_l_of_type_Boolean = ((Intent)localObject).getBooleanExtra("comment_native", false);
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)((Intent)localObject).getParcelableExtra("comment_article_info"));
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_val");
      this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_author_uin");
      this.jdField_i_of_type_Int = ((Intent)localObject).getIntExtra("biu_src", 1);
      this.jdField_j_of_type_Int = ((Intent)localObject).getIntExtra("feedsType", 1);
      this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_id");
      this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("first_comment_uin");
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mIsGalleryChannel;
      h();
    }
    a((Intent)localObject, localBundle);
    a(localBundle);
    e(localBundle);
    a((Intent)localObject);
    f(localBundle);
  }
  
  private void h()
  {
    if (a())
    {
      Object localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      if (localObject != null)
      {
        localObject = ((ReadInJoyCommentDataManager)localObject).a();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initData | comment_default_input : ");
          localStringBuilder.append((String)localObject);
          QLog.d("ReadInJoyCommentComponentFragment", 2, localStringBuilder.toString());
          this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.setHint((CharSequence)localObject);
        }
      }
    }
  }
  
  private void i()
  {
    DraftDataUtil.a(b(), this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getEditableText());
  }
  
  private void j()
  {
    DraftDataUtil.a(b());
  }
  
  private void k()
  {
    if (this.jdField_h_of_type_Int == -1) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentComponentFragment.2(this));
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", a(false), false);
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", a(false), false);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData = null;
    q();
    this.jdField_g_of_type_AndroidWidgetImageView.setClickable(true);
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842948);
    }
  }
  
  private void m()
  {
    this.jdField_c_of_type_Boolean ^= true;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842824);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842823);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      b(1);
    }
    else
    {
      b(2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", a(false), false);
    }
    r();
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Int == 3)
    {
      b(1);
    }
    else
    {
      b(3);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", a(false), false);
    }
    r();
  }
  
  private void p()
  {
    if (!b()) {
      return;
    }
    boolean bool = TextUtils.isEmpty(a());
    int i3 = 0;
    int i2;
    if (!bool) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null)
    {
      i1 = i2 + 2;
    }
    else
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) {
        i1 = i2 + 4;
      }
    }
    String str;
    if (this.jdField_h_of_type_Int == 1) {
      str = "0X80094A1";
    } else {
      str = "0X800844E";
    }
    JSONObject localJSONObject = a(true);
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label330;
        }
        if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label325;
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
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localStringBuilder.append(((BaseCommentData.CommentLinkData)localIterator.next()).type);
          localStringBuilder.append(',');
          continue;
        }
        localJSONObject.put("link_type", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
      RIJEmotionUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getText(), localJSONObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), str, str, 0, 0, String.valueOf(this.jdField_d_of_type_Int), String.valueOf(i1), "", localJSONObject.toString(), false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData == null)
      {
        j();
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, a());
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
        return;
      }
      a(2131695224);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString);
      return;
      label325:
      i2 = 0;
      break label332;
      label330:
      i2 = 1;
      label332:
      if (i2 == 0) {
        i3 = 1;
      }
    }
  }
  
  private void q()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) {
        bool1 = bool2;
      } else if (!TextUtils.isEmpty(a())) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool1);
    localObject = this.jdField_b_of_type_AndroidWidgetButton;
    if (localObject != null) {
      ((Button)localObject).setEnabled(bool1);
    }
  }
  
  private void r()
  {
    ZhituManager localZhituManager = a();
    if ((localZhituManager != null) && (this.jdField_i_of_type_Boolean))
    {
      localZhituManager.c();
      this.jdField_i_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
  }
  
  private void s()
  {
    t();
    r();
  }
  
  private void t()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    Bundle localBundle = new Bundle();
    int i2 = this.jdField_l_of_type_Int;
    Object localObject = this.jdField_a_of_type_JavaUtilList;
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X800B085", "0X800B085", 0, 0, "", "", "", c(), false);
  }
  
  private void u()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (((!RIJItemViewTypeUtils.e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (ArticleInfoHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) || (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.b()))) {
      this.jdField_g_of_type_Boolean = false;
    }
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void v()
  {
    if ((RIJBiuAndCommentAladdinUtils.a()) && (this.p)) {
      this.o = true;
    }
    if (!this.o)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 1, "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return;
    }
    w();
    y();
    B();
  }
  
  private void w()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    x();
  }
  
  private void x()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = RIJBiuAndCommentAladdinUtils.b().split("\\|");
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      this.jdField_m_of_type_Int = new Random().nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_m_of_type_Int])) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_m_of_type_Int]);
    }
    String str = RIJBiuAndCommentAladdinUtils.c();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    }
    if (RIJBiuAndCommentAladdinUtils.d())
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    str = RIJBiuAndCommentAladdinUtils.d();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
    }
    if (RIJBiuAndCommentAladdinUtils.b()) {
      a(true);
    }
    if (RIJBiuAndCommentAladdinUtils.c())
    {
      if (((Boolean)RIJSPUtils.a("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue())
      {
        a(true);
        return;
      }
      a(false);
    }
  }
  
  private void y()
  {
    ReadInJoyCommentComponentFragment.12 local12 = new ReadInJoyCommentComponentFragment.12(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(local12);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(local12);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(local12);
  }
  
  private void z()
  {
    A();
    if (!b()) {
      return;
    }
    if (RIJBiuAndCommentAladdinUtils.c()) {
      RIJSPUtils.a("rij_sp_editor_last_check", Boolean.valueOf(this.jdField_b_of_type_Boolean));
    }
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(1699, b());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  protected String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getEditableText();
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
  
  public JSONObject a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      a(localArrayList);
      JSONObject localJSONObject1 = new JSONObject();
      new SocializeFeedsInfo().jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = new BiuInfo();
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null))
      {
        localJSONObject1.put("mOriFeedType", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b);
        localJSONObject1.put("mOriFeedId", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaLangLong);
      }
      localJSONObject1.put("biuSrc", this.jdField_i_of_type_Int);
      localJSONObject1.put("feedtype", this.jdField_j_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        ReadInJoyCommentComponentFragment.UserBiuInfo localUserBiuInfo = (ReadInJoyCommentComponentFragment.UserBiuInfo)localArrayList.get(i1);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localUserBiuInfo.b);
        localJSONObject2.put("biu_feedid", new Long(localUserBiuInfo.jdField_a_of_type_Long));
        localJSONObject2.put("biu_optype", localUserBiuInfo.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localUserBiuInfo.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localUserBiuInfo.jdField_a_of_type_JavaLangCharSequence);
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
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText != null)
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.clearFocus();
    }
  }
  
  protected void a(int paramInt)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.c(paramInt);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, paramCharSequence, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData = paramZhituPicData;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.9(this, paramZhituPicData));
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
      f();
      a(1, getString(2131717876));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentComponentFragment.3(this, paramString));
  }
  
  protected boolean a(ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText;
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
  
  public void b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList == null) || (localList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentLinkView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X800B086", "0X800B086", 0, 0, "", "", "", c(), false);
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData == null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null))
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842948);
        this.jdField_a_of_type_Boolean = true;
      }
      else
      {
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842947);
        this.jdField_a_of_type_Boolean = false;
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str;
      if (this.jdField_a_of_type_Boolean) {
        str = "0";
      } else {
        str = "1";
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", a(false), false);
      return;
    }
    QQToast.a(this.jdField_g_of_type_AndroidWidgetImageView.getContext(), HardCodeUtil.a(2131712907), 0).a();
  }
  
  protected void d()
  {
    c(1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, a());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  protected void e()
  {
    ZhituManager localZhituManager = a();
    if (localZhituManager != null) {
      if (this.jdField_i_of_type_Boolean)
      {
        r();
      }
      else
      {
        Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getText();
        if (!localZhituManager.a(localEditable))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getContext(), HardCodeUtil.a(2131712689), 0).a();
          return;
        }
        if (localEditable.length() > 24)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getContext(), "24个字符以内才支持转为智图。", 0).a();
          return;
        }
        localZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, false, this.jdField_a_of_type_MqqOsMqqHandler);
        if (localZhituManager.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1) {
          localZhituManager.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(0);
        }
        localZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, localEditable, null, 7220, false);
        localZhituManager.a(this);
        this.jdField_i_of_type_Boolean = true;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(true);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", a(false), false);
  }
  
  protected void f()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AddCommentLinkEvent.class);
    return localArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 84)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      r();
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataAtRIJCommentAtUi.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(0, a());
    k();
    i();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131381342: 
      e();
      return;
    case 2131370091: 
      s();
      return;
    case 2131368623: 
      d();
      return;
    case 2131368534: 
      l();
      return;
    case 2131367678: 
      o();
      return;
    case 2131366114: 
      n();
      return;
    case 2131365511: 
      p();
      return;
    case 2131363652: 
      c();
      return;
    case 2131363342: 
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.doOnBackPressed();
      return;
    case 2131362702: 
      m();
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131560112, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131363342));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131368530));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368531));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131368534).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362702));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366114));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367678));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368623));
    if (!HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).b()) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    } else {
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131370091));
    this.jdField_j_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentLinkView = ((CommentLinkView)paramLayoutInflater.findViewById(2131370100));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentLinkView.setOnLinkEmptyListener(this);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131370097);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364468));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131365511));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText = ((BiuEditText)paramLayoutInflater.findViewById(2131368874));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.requestFocus();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    }
    catch (Exception paramViewGroup)
    {
      QLog.e("ReadInJoyCommentComponentFragment", 1, "input set error", paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText;
    paramViewGroup.addTextChangedListener(new RIJEmotionTextWatcher(paramViewGroup));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)paramLayoutInflater.findViewById(2131376809));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText, false);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131381342));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131381345));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131379036));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataTopicRIJCommentTopicUi = new RIJCommentTopicUi(this.jdField_k_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText, new ReadInJoyCommentComponentFragment.FuncReportRunnable(this, "0X800B9E0", null));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131363016));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataAtRIJCommentAtUi = new RIJCommentAtUi(getActivity(), this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText, new ReadInJoyCommentComponentFragment.FuncReportRunnable(this, "0X800BAC1", null));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    a(paramLayoutInflater);
    g();
    this.jdField_g_of_type_Int = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    boolean bool;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_e_of_type_Boolean = bool;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131367211));
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()))
    {
      paramViewGroup = paramLayoutInflater.findViewById(2131371885);
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(0);
      }
    }
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramViewGroup, paramViewGroup.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364938));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365512));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131363652));
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_Boolean) {
        this.n = false;
      }
    }
    catch (NullPointerException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (c())
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842948);
      this.jdField_a_of_type_Boolean = true;
    }
    u();
    v();
    RIJDtReportHelper.a.a(getBaseActivity());
    return paramLayoutInflater;
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText;
    if (localObject != null) {
      ((BiuEditText)localObject).removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject != null)
    {
      ((SharedPreferences)localObject).edit().putBoolean("readinjoy_comment_biu_switch", this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().commit();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
    if (localObject != null) {
      ((PublicAccountHotPicPanel)localObject).setPublicAccountGifListener(null);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localObject != null)
    {
      ((XPanelContainer)localObject).setReadyToShow(false);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.c();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    localObject = a();
    if (localObject != null) {
      ((ZhituManager)localObject).a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localObject != null) {
      ((ITransFileController)((BaseActivity)localObject).app.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
    a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText;
    if (localObject != null) {
      ((BiuEditText)localObject).a();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataTopicRIJCommentTopicUi.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataTopicRIJCommentTopicUi = null;
  }
  
  public void onFinish()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity != null) {
      localBaseActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
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
    AbstractGifImage.resumeAll();
    if (this.jdField_b_of_type_Int == 1) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentComponentFragment.1(this), 300L);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((IRIJUserProtoUtils)QRoute.api(IRIJUserProtoUtils.class)).check(getBaseActivity(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */