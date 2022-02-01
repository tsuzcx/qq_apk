package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.TMG.utils.QLog;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView.MultiScrollListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler;
import com.tencent.mobileqq.kandian.repo.comment.constants.CommentInfoConstants;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, FlingExitLayout.OnGestureExitListener, ReadInJoyCommentUtils.CommentListListener, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener
{
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TimeSliceHelper jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper = new TimeSliceHelper();
  private LayoutInflateProcessor jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor;
  private RIJBiuAndCommentMixDataManager jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager;
  private FlingExitLayout jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout;
  private HippyCommentPageListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentHippyCommentPageListener = new ReadInJoyCommentListFragment.1(this);
  private ReadInJoyCommentHelper.ISecondCommentViewStateListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentHelper$ISecondCommentViewStateListener = null;
  private ReadInJoyCommentListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
  private ReadInJoyCommentListFragment.OnCreateViewListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$OnCreateViewListener = null;
  private ReadInJoyCommentListFragment.ViewParams jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams = null;
  private ReadInJoyCommentUtils.FirstCommentEvent jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent;
  private ReadInJoyCommentUtils.OnFragmentViewCreateListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$OnFragmentViewCreateListener;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
  private TKDCommentFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
  private AnchorData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData;
  private CommonCommentData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
  private GuidePopuppWindow jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow;
  private ITKDHippyEventDispatcher jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher = new TKDHippyEventDispatcher();
  private final ITKDHippyEventReceiver jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver = new ReadInJoyCommentListFragment.11(this);
  private ReadInJoyCommentListView.MultiScrollListener jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView$MultiScrollListener = null;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyCommentListFragment.5(this);
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ReadInJoyCommentListFragment.2(this);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "huawei_vog-al00", "huawei_vog-al10", "huawei_ele-al00", "samsung_sm-g9750" };
  private int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 5;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView = null;
  private boolean jdField_e_of_type_Boolean = false;
  private View jdField_f_of_type_AndroidViewView = null;
  private boolean jdField_f_of_type_Boolean = false;
  private View jdField_g_of_type_AndroidViewView = null;
  private boolean jdField_g_of_type_Boolean = false;
  private View jdField_h_of_type_AndroidViewView = null;
  private boolean jdField_h_of_type_Boolean = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = true;
  
  public ReadInJoyCommentListFragment()
  {
    this.jdField_a_of_type_Int = 2131377094;
  }
  
  private FragmentTransaction a()
  {
    if (this.j)
    {
      if (getChildFragmentManager() != null) {
        return getChildFragmentManager().beginTransaction();
      }
    }
    else if ((getQBaseActivity() != null) && (getQBaseActivity().getSupportFragmentManager() != null)) {
      return getQBaseActivity().getSupportFragmentManager().beginTransaction();
    }
    return null;
  }
  
  /* Error */
  public static void a(Intent paramIntent, RIJBiuAndCommentMixDataManager paramRIJBiuAndCommentMixDataManager, int paramInt1, boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 198	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   7: astore 10
    //   9: aload 10
    //   11: ldc 201
    //   13: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 10
    //   19: iload_2
    //   20: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 10
    //   26: ldc 210
    //   28: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 10
    //   34: iload_3
    //   35: invokevirtual 213	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 215
    //   41: iconst_1
    //   42: aload 10
    //   44: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 224	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: ldc 226
    //   53: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_0
    //   57: aload_0
    //   58: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: istore 7
    //   63: iconst_0
    //   64: istore 8
    //   66: iconst_0
    //   67: istore 9
    //   69: ldc 67
    //   71: astore 12
    //   73: iload 7
    //   75: ifne +131 -> 206
    //   78: new 240	org/json/JSONObject
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   86: astore_0
    //   87: aload_0
    //   88: ldc 245
    //   90: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 11
    //   95: aload_0
    //   96: ldc 250
    //   98: invokevirtual 254	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   101: istore 7
    //   103: aload_0
    //   104: ldc_w 256
    //   107: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 10
    //   112: aload_0
    //   113: ldc_w 258
    //   116: invokevirtual 254	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   119: istore 9
    //   121: aload_0
    //   122: ldc_w 260
    //   125: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_0
    //   129: iload 7
    //   131: istore 8
    //   133: iload 9
    //   135: istore 7
    //   137: goto +82 -> 219
    //   140: astore_0
    //   141: iload 7
    //   143: istore 8
    //   145: iload 9
    //   147: istore 7
    //   149: goto +47 -> 196
    //   152: astore_0
    //   153: goto +8 -> 161
    //   156: astore_0
    //   157: ldc 67
    //   159: astore 10
    //   161: iload 7
    //   163: istore 8
    //   165: goto +28 -> 193
    //   168: astore_0
    //   169: ldc 67
    //   171: astore 10
    //   173: iload 9
    //   175: istore 8
    //   177: goto +16 -> 193
    //   180: astore_0
    //   181: ldc 67
    //   183: astore 11
    //   185: aload 11
    //   187: astore 10
    //   189: iload 9
    //   191: istore 8
    //   193: iconst_0
    //   194: istore 7
    //   196: aload_0
    //   197: invokevirtual 263	org/json/JSONException:printStackTrace	()V
    //   200: ldc 67
    //   202: astore_0
    //   203: goto +16 -> 219
    //   206: ldc 67
    //   208: astore 11
    //   210: aload 11
    //   212: astore_0
    //   213: aload_0
    //   214: astore 10
    //   216: iconst_0
    //   217: istore 7
    //   219: aload 11
    //   221: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne +106 -> 330
    //   227: new 265	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData
    //   230: dup
    //   231: invokespecial 266	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:<init>	()V
    //   234: astore 13
    //   236: aload 13
    //   238: iload_3
    //   239: invokevirtual 270	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setBiu	(Z)V
    //   242: aload 13
    //   244: iload_2
    //   245: invokevirtual 274	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setContentSrc	(I)V
    //   248: aload 13
    //   250: aload 11
    //   252: invokevirtual 277	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setContentString	(Ljava/lang/String;)V
    //   255: aload 13
    //   257: iload 8
    //   259: invokevirtual 280	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setDiffuseToFriends	(Z)V
    //   262: aload 4
    //   264: ifnonnull +10 -> 274
    //   267: aload 12
    //   269: astore 11
    //   271: goto +10 -> 281
    //   274: aload 4
    //   276: getfield 285	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   279: astore 11
    //   281: aload 13
    //   283: aload 11
    //   285: invokevirtual 288	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setRowKey	(Ljava/lang/String;)V
    //   288: aload 13
    //   290: iload 5
    //   292: invokevirtual 291	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setListShowType	(I)V
    //   295: aload 13
    //   297: iload 6
    //   299: invokevirtual 294	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setCommentType	(I)V
    //   302: aload 13
    //   304: aload 10
    //   306: invokevirtual 297	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setReplyCommentId	(Ljava/lang/String;)V
    //   309: aload 13
    //   311: iload 7
    //   313: invokevirtual 300	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setIsSecondReply	(Z)V
    //   316: aload 13
    //   318: aload_0
    //   319: invokevirtual 303	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setReplyUin	(Ljava/lang/String;)V
    //   322: aload_1
    //   323: aload 4
    //   325: aload 13
    //   327: invokevirtual 308	com/tencent/mobileqq/kandian/biz/biu/RIJBiuAndCommentMixDataManager:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Lcom/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData;)V
    //   330: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramIntent	Intent
    //   0	331	1	paramRIJBiuAndCommentMixDataManager	RIJBiuAndCommentMixDataManager
    //   0	331	2	paramInt1	int
    //   0	331	3	paramBoolean	boolean
    //   0	331	4	paramAbsBaseArticleInfo	AbsBaseArticleInfo
    //   0	331	5	paramInt2	int
    //   0	331	6	paramInt3	int
    //   61	251	7	bool1	boolean
    //   64	194	8	bool2	boolean
    //   67	123	9	bool3	boolean
    //   7	298	10	localObject	Object
    //   93	191	11	str1	String
    //   71	197	12	str2	String
    //   234	92	13	localRIJBiuAndCommentRequestData	com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRequestData
    // Exception table:
    //   from	to	target	type
    //   121	129	140	org/json/JSONException
    //   112	121	152	org/json/JSONException
    //   103	112	156	org/json/JSONException
    //   95	103	168	org/json/JSONException
    //   78	95	180	org/json/JSONException
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout = ((FlingExitLayout)paramView);
    boolean bool = TKDCommentFragmentHelper.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableHippyComment: ");
    localStringBuilder.append(bool);
    QLog.d("ReadInJoyCommentListFragment", 1, localStringBuilder.toString());
    if (bool)
    {
      b(paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment == null) {
        d(paramView);
      }
    }
    else
    {
      d(paramView);
    }
  }
  
  private boolean a(AnchorData paramAnchorData)
  {
    if ((paramAnchorData == null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData == null)) {
      return true;
    }
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData != null) && (paramAnchorData != null) && (paramAnchorData.jdField_a_of_type_JavaLangString != null) && (paramAnchorData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.innerUniqueID != null) && (paramAbsBaseArticleInfo.innerUniqueID.equals(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID));
  }
  
  private boolean a(boolean paramBoolean, GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (getQBaseActivity() == null)
    {
      QLog.d("ReadInJoyCommentListFragment", 0, "showGuidePopupWindow | activity is null");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow = new GuidePopuppWindow(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    }
    if ((paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID)) || (!CommentGuideConfigHandler.b()))) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(new ReadInJoyCommentListFragment.9(this, paramOnGuideDismissListener));
    paramOnGuideDismissListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
    if (paramOnGuideDismissListener != null) {
      paramOnGuideDismissListener.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(getQBaseActivity().getWindow().getDecorView());
    return true;
  }
  
  private void b(View paramView)
  {
    t();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment = TKDCommentFragmentHelper.a(2131368189, getChildFragmentManager());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment != null)
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "createHippyFragment success");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentHippyCommentPageListener);
      c(paramView);
      j();
      l();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.getTKDHippyEventDispatcher().register(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.getTKDHippyEventDispatcher().merge(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher.clear();
      return;
    }
    QLog.d("ReadInJoyCommentListFragment", 1, "createHippyFragment failed");
  }
  
  private void b(AnchorData paramAnchorData)
  {
    if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initAnchor ");
      ((StringBuilder)localObject).append(paramAnchorData.jdField_a_of_type_JavaLangString);
      QLog.d("ReadInJoyCommentListFragment", 1, ((StringBuilder)localObject).toString());
      if ((!TextUtils.isEmpty(paramAnchorData.jdField_b_of_type_JavaLangString)) && (!paramAnchorData.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.setAlpha(0.0F);
        localObject = a();
        if (localObject != null)
        {
          ((FragmentTransaction)localObject).setCustomAnimations(2130772387, 0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramAnchorData.jdField_a_of_type_JavaLangString, paramAnchorData.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int);
          ((FragmentTransaction)localObject).show(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
          ((FragmentTransaction)localObject).commitAllowingStateLoss();
        }
        this.jdField_b_of_type_Int = 2;
        ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentListFragment.3(this), 1000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a(new ReadInJoyCommentListFragment.4(this));
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("write_comment_button").e(paramAbsBaseArticleInfo.innerUniqueID).c("click_write_comment").a().a());
  }
  
  private int c()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    if (localReadInJoyCommentDataManager != null) {
      return (int)localReadInJoyCommentDataManager.a();
    }
    return -1;
  }
  
  private void c(View paramView)
  {
    if (this.k)
    {
      paramView.setFitsSystemWindows(false);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.setOnGestureExitListener(this);
    if (paramBoolean)
    {
      TKDCommentFragment localTKDCommentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
      if (localTKDCommentFragment != null)
      {
        localTKDCommentFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout);
        QLog.d("ReadInJoyCommentListFragment", 1, "tkdCommentFragment set FlingExitLayout success");
        break label52;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.setListView(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView);
    label52:
    if (this.k) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.findViewById(2131381200).setBackgroundResource(2130841765);
    }
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379586));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363715));
    if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView = ((ReadInJoyCommentListView)paramView.findViewById(2131364967));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366758));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.findViewById(2131372940));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.findViewById(2131370329));
    t();
    c(paramView);
    b(1);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams != null)
    {
      p();
      u();
      o();
    }
    g(paramView);
    s();
    r();
    q();
    f(paramView);
    if (this.jdField_d_of_type_Boolean) {
      d();
    }
    m();
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$OnCreateViewListener;
    if (localObject != null) {
      ((ReadInJoyCommentListFragment.OnCreateViewListener)localObject).onViewCreated(this.jdField_a_of_type_Boolean);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((localObject != null) && (!this.jdField_h_of_type_Boolean))
    {
      a((AbsBaseArticleInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData, this.jdField_c_of_type_Boolean, 5, this.jdField_c_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, "onCreateView | fetchCommentDataByViola");
    }
    e(paramView);
    n();
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentHelper$ISecondCommentViewStateListener != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        if (!paramBoolean) {
          break label136;
        }
        Object localObject1 = "1";
        ((JSONObject)localObject2).put("replyViewStatus", localObject1);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentHelper$ISecondCommentViewStateListener.onViewState(paramBoolean, ((JSONObject)localObject2).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifySecondCommentViewStateChanged | visible ");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append("; jsonStr ");
        ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
        QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject1).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("notifySecondCommentViewStateChanged ");
        ((StringBuilder)localObject2).append(localJSONException.getMessage());
        QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject2).toString());
      }
      return;
      label136:
      String str = "2";
    }
  }
  
  private void e(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371901);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371917);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131373730);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(null);
  }
  
  private boolean e()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      a(false, null, null);
      return true;
    }
    ReadInJoyCommentUtils.FirstCommentEvent localFirstCommentEvent = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent;
    if ((localFirstCommentEvent != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter != null))
    {
      localFirstCommentEvent.a(c());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.jdField_b_of_type_Int = 0;
    }
    v();
    return false;
  }
  
  private void f(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView$MultiScrollListener = new ReadInJoyCommentListView.MultiScrollListener();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView$MultiScrollListener.addScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView$MultiScrollListener);
    paramView.findViewById(2131364710).setOnClickListener(this);
    paramView.findViewById(2131368874).setOnClickListener(this);
    paramView.findViewById(2131378784).setOnClickListener(this);
    paramView.findViewById(2131371902).setOnClickListener(this);
    ReadInJoyCommentUtils.OnFragmentViewCreateListener localOnFragmentViewCreateListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$OnFragmentViewCreateListener;
    if (localOnFragmentViewCreateListener != null) {
      localOnFragmentViewCreateListener.a(paramView);
    }
    ReadInJoyDropFrameHelper.a().a(6666, this);
  }
  
  private void g(View paramView)
  {
    View localView;
    if (this.jdField_e_of_type_Boolean)
    {
      localView = paramView.findViewById(2131364940);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.jdField_g_of_type_Boolean)
    {
      localView = paramView.findViewById(2131377375);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.jdField_f_of_type_Boolean)
    {
      paramView = paramView.findViewById(2131363650);
      paramView.setVisibility(0);
      paramView.setOnClickListener(this);
    }
  }
  
  private void h(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      d();
      if (paramView.getId() == 2131368874)
      {
        paramView = new ReadInJoyCommentUtils.CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null).a(this.jdField_e_of_type_Int).a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(RIJQQAppInterfaceUtil.b(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, paramView, false);
        b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      }
    }
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
    if (localObject != null)
    {
      localObject = ((TKDCommentFragment)localObject).getPerformanceData();
      if (localObject != null)
      {
        long l1 = ((Long)((HashMap)localObject).get("openPageStart")).longValue();
        long l2 = ((Long)((HashMap)localObject).get("loadModuleEnd")).longValue();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hippy cost: ");
        ((StringBuilder)localObject).append(l2 - l1);
        QLog.d("ReadInJoyCommentListFragment", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
    if (localObject == null) {
      return;
    }
    ((TKDCommentFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.a(this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.a(ReadInJoyCommentHelper.a(this.jdField_c_of_type_Int));
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout != null) {
      c(true);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData;
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.a((AnchorData)localObject);
    }
  }
  
  private void k()
  {
    ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.findViewById(2131376704)).setVisibility(0);
  }
  
  private void l()
  {
    ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.findViewById(2131376704)).setVisibility(8);
  }
  
  private void m()
  {
    if ((getQBaseActivity() != null) && (ThemeUtil.isInNightMode(RIJQQAppInterfaceUtil.b())))
    {
      View localView = new View(getQBaseActivity());
      localView.setBackgroundColor(1996488704);
      getQBaseActivity().addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  private void n()
  {
    this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(getQBaseActivity()).inflate(2131562699, null, false);
    this.jdField_f_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131371901);
    this.jdField_h_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131371917);
    this.jdField_g_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131370381);
    ReadInJoyCommentListView localReadInJoyCommentListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
    if ((localReadInJoyCommentListView != null) && (this.jdField_h_of_type_Boolean)) {
      localReadInJoyCommentListView.addHeaderView(this.jdField_e_of_type_AndroidViewView);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams;
      if ((localObject != null) && (((ReadInJoyCommentListFragment.ViewParams)localObject).jdField_a_of_type_Int > 0))
      {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_b_of_type_Int);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setPaddingTop : ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Int);
        QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_h_of_type_Boolean)
    {
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
    }
  }
  
  private void q()
  {
    c(false);
  }
  
  private void r()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("arg_comment_list_biu_btn", false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.b(this.jdField_h_of_type_Boolean);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams;
    if (localObject2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.b(((ReadInJoyCommentListFragment.ViewParams)localObject2).jdField_c_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initSubCommentFragment | setMarginTop ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_c_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject1, new ReadInJoyCommentListFragment.6(this));
    localObject1 = a();
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).add(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject1).hide(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject1).commitAllowingStateLoss();
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.initFooterView();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideFooterView();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter = new ReadInJoyCommentListAdapter(getQBaseActivity(), this, this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  private void t()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    boolean bool = false;
    this.j = localBundle.getBoolean("arg_comment_is_fragment_container", false);
    this.jdField_e_of_type_Boolean = localBundle.getBoolean("arg_comment_list_comment_btn", false);
    this.jdField_f_of_type_Boolean = localBundle.getBoolean("arg_comment_list_biu_btn", false);
    this.jdField_g_of_type_Boolean = localBundle.getBoolean("arg_comment_list_share_btn", false);
    this.jdField_d_of_type_Boolean = localBundle.getBoolean("readinjoy_open_comment_with_edit_panel", false);
    Object localObject = getQBaseActivity();
    if ((localObject != null) && (((Activity)localObject).getIntent() != null)) {
      this.k = ((Activity)localObject).getIntent().getBooleanExtra(CommentInfoConstants.READINJOY_IS_INDEPENDENT_COMPONENTS, true);
    }
    this.jdField_h_of_type_Boolean = localBundle.getBoolean("fromViola");
    this.i = localBundle.getBoolean("is_from_viola");
    this.jdField_e_of_type_Int = localBundle.getInt("bigT_report_entry", this.jdField_c_of_type_Int);
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams == null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams = new ReadInJoyCommentListFragment.ViewParams();
      }
      this.k = false;
      this.jdField_d_of_type_Int = localBundle.getInt("serviceType");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Boolean = (localBundle.getBoolean("isHiddenFirstPageEditorBar", false) ^ true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_b_of_type_Boolean = (localBundle.getBoolean("isHiddenHeaderRow", false) ^ true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_c_of_type_Boolean = (localBundle.getBoolean("isHiddenSecPageEditorBar", false) ^ true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Int = localBundle.getInt("padding_top");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_b_of_type_Int = localBundle.getInt("margin_bottom");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_c_of_type_Int = localBundle.getInt("secPageOffsetY");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams.jdField_d_of_type_Int = localBundle.getInt("secPageShowDirection", 2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams;
      if (localBundle.getInt("isHiddenSecPageMaskView", 0) == 0) {
        bool = true;
      }
      ((ReadInJoyCommentListFragment.ViewParams)localObject).jdField_d_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)localBundle.getParcelable("articleInfo"));
      this.jdField_c_of_type_Int = localBundle.getInt("source");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData = ((CommonCommentData)localBundle.getSerializable("commonCommentData"));
    }
  }
  
  private void u()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null)
    {
      ReadInJoyCommentListFragment.ViewParams localViewParams = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams;
      int m;
      if ((localViewParams != null) && (localViewParams.jdField_a_of_type_Boolean)) {
        m = 0;
      } else {
        m = 8;
      }
      localLinearLayout.setVisibility(m);
    }
  }
  
  private void v()
  {
    Object localObject = getQBaseActivity();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (localObject != null)) {
        ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, "onPanelClose", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  private void w()
  {
    ReadInJoyCommentListView localReadInJoyCommentListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
    if (localReadInJoyCommentListView == null) {
      return;
    }
    localReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setSelection(0);
  }
  
  private void x()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null)
    {
      localObject = new ReadInJoyCommentUtils.CommentReportR5Builder((AbsBaseArticleInfo)localObject, null).a(this.jdField_e_of_type_Int).b(1).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, (String)localObject, false);
    }
  }
  
  private void y()
  {
    RIJBiuAndCommentMixDataManager localRIJBiuAndCommentMixDataManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager;
    if (localRIJBiuAndCommentMixDataManager != null) {
      localRIJBiuAndCommentMixDataManager.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager = new RIJBiuAndCommentMixDataManager();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager.a(new ReadInJoyCommentListFragment.10(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    TimeSliceHelper localTimeSliceHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper;
    if (localTimeSliceHelper != null)
    {
      long l = localTimeSliceHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.c();
      return l;
    }
    return 0L;
  }
  
  ReadInJoyCommentUtils.FirstCommentEvent a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent;
  }
  
  @NonNull
  public ITKDHippyEventDispatcher a()
  {
    TKDCommentFragment localTKDCommentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
    if (localTKDCommentFragment == null) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher;
    }
    return localTKDCommentFragment.getTKDHippyEventDispatcher();
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      int m = this.jdField_d_of_type_Int;
      if (m == 0) {
        m = 5;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchCommentDataByViola by viola feedstype ");
      localStringBuilder.append(m);
      localStringBuilder.append("contentSrc ");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, localStringBuilder.toString());
      a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null, true, m, this.jdField_c_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(Bundle paramBundle, ReadInJoyCommentUtils.FirstCommentEvent paramFirstCommentEvent, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent = paramFirstCommentEvent;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    setArguments(paramBundle);
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor = paramLayoutInflateProcessor;
  }
  
  public void a(ReadInJoyCommentHelper.ISecondCommentViewStateListener paramISecondCommentViewStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentHelper$ISecondCommentViewStateListener = paramISecondCommentViewStateListener;
  }
  
  public void a(ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    ReadInJoyCommentListAdapter localReadInJoyCommentListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
    if (localReadInJoyCommentListAdapter != null) {
      localReadInJoyCommentListAdapter.a(paramOnScrollYOffsetListener);
    }
  }
  
  public void a(ReadInJoyCommentListFragment.OnCreateViewListener paramOnCreateViewListener)
  {
    if (paramOnCreateViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$OnCreateViewListener = paramOnCreateViewListener;
    }
  }
  
  public void a(AnchorData paramAnchorData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData = paramAnchorData;
    TKDCommentFragment localTKDCommentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
    if ((localTKDCommentFragment != null) && (paramAnchorData != null)) {
      localTKDCommentFragment.a(paramAnchorData);
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData = paramCommonCommentData;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    TKDCommentFragment localTKDCommentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
    if ((localTKDCommentFragment != null) && (paramAbsBaseArticleInfo != null)) {
      localTKDCommentFragment.a(paramAbsBaseArticleInfo);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    a(paramAbsBaseArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt)
  {
    if ((!a()) && (!TKDCommentFragmentHelper.a()) && (a(paramAbsBaseArticleInfo)) && (a(paramAnchorData)))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "cache fragment data");
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
      this.jdField_b_of_type_Boolean = true;
      paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
      if (paramAbsBaseArticleInfo != null) {
        paramAbsBaseArticleInfo.notifyDataSetChanged();
      }
      return;
    }
    a(paramAbsBaseArticleInfo, paramAnchorData, paramBoolean, 5, paramInt);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null)
    {
      localObject = ReadInJoyCommentDataManager.a((AbsBaseArticleInfo)localObject);
      if (localObject != null) {
        ((ReadInJoyCommentDataManager)localObject).a().a(false, this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView);
      }
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData = paramAnchorData;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (!a())
    {
      if (!NetworkUtil.isNetworkAvailable(getQBaseActivity())) {
        b(3);
      } else {
        b(1);
      }
      b(paramAnchorData);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
      if (localObject != null)
      {
        ((ReadInJoyCommentListAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a(paramAbsBaseArticleInfo, paramAnchorData, paramBoolean, paramInt1, paramInt2);
      }
      paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
      if (paramAbsBaseArticleInfo != null) {
        paramAbsBaseArticleInfo.resetState();
      }
      x();
      y();
      return;
    }
    if (this.i) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.getTKDHippyEventDispatcher().refreshNewAndHotData(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.a());
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent != null)
    {
      int m;
      if (paramBoolean) {
        m = 1;
      } else {
        m = 2;
      }
      RIJTransMergeKanDianReport.a(0, this.jdField_e_of_type_Int, m);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent.a(false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
    if (localObject != null) {
      ((TKDCommentFragment)localObject).a();
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.b();
    String str = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    if (this.jdField_c_of_type_Int == 2) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(localQQAppInterface, str, "0X800920E", "0X800920E", 0, 0, (String)localObject, String.valueOf(1), "", "", false);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSubCommentFragmentVisible | visible ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject).toString());
    d(paramBoolean);
    if (!paramBoolean)
    {
      paramString1 = a();
      if (paramString1 != null)
      {
        paramBoolean = TextUtils.isEmpty(paramString2);
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams;
        int m;
        if ((paramString2 != null) && (paramString2.jdField_d_of_type_Int == 2)) {
          m = 1;
        } else {
          m = 0;
        }
        if ((!(paramBoolean ^ true)) && (m == 0)) {
          paramString1.setCustomAnimations(2130771995, 2130772025);
        } else {
          paramString1.setCustomAnimations(2130772386, 0);
        }
        paramString1.hide(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.d();
        paramString1.commitAllowingStateLoss();
      }
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.setCommentLevel(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.a(true);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
      if (paramString1 != null) {
        paramString1.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        return;
      }
      localObject = a();
      if (localObject != null)
      {
        ReadInJoyCommentListFragment.ViewParams localViewParams = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams;
        if ((localViewParams != null) && (localViewParams.jdField_d_of_type_Int == 2)) {
          ((FragmentTransaction)localObject).setCustomAnimations(2130772386, 0);
        } else {
          ((FragmentTransaction)localObject).setCustomAnimations(2130771995, 2130772025);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramString1, paramString2, this.jdField_c_of_type_Int);
        ((FragmentTransaction)localObject).show(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.setCommentLevel(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.a(false);
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment != null;
  }
  
  public int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void b()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView == null) {
      return;
    }
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_d_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_h_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.jdField_f_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.jdField_g_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getHeaderViewsCount() > 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideLoadingFooter();
            return;
          }
          localObject = this.jdField_h_of_type_AndroidViewView;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideLoadingFooter();
          QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noNetworkView");
          return;
        }
        localObject = this.jdField_f_of_type_AndroidViewView;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
        if (localObject != null) {
          ((ReadInJoyCommentListView)localObject).loadingMoreComplete(false);
        }
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noCommentView");
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideLoadingFooter();
        return;
      }
      localObject = this.jdField_g_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideLoadingFooter();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader loadingView");
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
          QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideLoadingFooter();
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noNetworkView");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideLoadingFooter();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideLoadingFooter();
    QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader loadingView");
  }
  
  public void b(boolean paramBoolean)
  {
    TKDCommentFragment localTKDCommentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment;
    if (localTKDCommentFragment != null) {
      localTKDCommentFragment.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.findViewById(2131372940).setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean c()
  {
    ReadInJoyCommentListFragment.ViewParams localViewParams = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$ViewParams;
    if (localViewParams != null) {
      return localViewParams.jdField_b_of_type_Boolean;
    }
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return;
    }
    if (a(true, new ReadInJoyCommentListFragment.7(this))) {
      return;
    }
    int m;
    if (((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
    {
      m = 2;
    }
    else
    {
      if ((RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
      {
        if (RIJItemViewTypeUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int))
        {
          m = 9;
          break label151;
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mIsGallery != 0)
      {
        m = 17;
        break label151;
      }
      m = 4;
    }
    label151:
    ReadInJoyCommentUtils.a(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null, m, "", this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent, -1, this.jdField_c_of_type_Boolean);
  }
  
  public boolean d()
  {
    if (a())
    {
      v();
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.a();
    }
    return e();
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    ReadInJoyCommentListAdapter localReadInJoyCommentListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
    if ((localReadInJoyCommentListAdapter != null) && (localReadInJoyCommentListAdapter.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a().b(a(), 2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a().a();
    }
  }
  
  public void f()
  {
    AnchorData localAnchorData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData;
    if ((localAnchorData != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter != null))
    {
      if (localAnchorData.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.f();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.e();
    }
  }
  
  public void g()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.getActivityLifecycleDispatcher().onActivityResumed(getQBaseActivity());
    }
  }
  
  public void h()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.getActivityLifecycleDispatcher().onActivityPaused(getQBaseActivity());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("arg_result_json");
      paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
      paramInt2 = paramIntent.getIntExtra("comment_cmd", 0);
      paramIntent = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      if (paramIntent == null) {
        return;
      }
      if (paramInt2 == 1)
      {
        a(false, new ReadInJoyCommentListFragment.8(this));
        return;
      }
      ReadInJoyCommentListAdapter localReadInJoyCommentListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
      if (localReadInJoyCommentListAdapter != null)
      {
        if (paramInt1 == 2)
        {
          paramIntent.d(str, localReadInJoyCommentListAdapter.b());
          return;
        }
        if (paramInt1 == 3) {
          paramIntent.c_(str, localReadInJoyCommentListAdapter.b());
        }
      }
    }
    else if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == 1699))
    {
      if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager, this.jdField_c_of_type_Int, true, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.b(), paramInt1);
    }
  }
  
  public boolean onBackEvent()
  {
    return d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131378784: 
      w();
      return;
    case 2131372940: 
      a(false, null, null);
      return;
    case 2131371901: 
    case 2131371917: 
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter != null)
      {
        b(1);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a();
        return;
      }
      break;
    case 2131368874: 
    case 2131371902: 
      h(paramView);
      return;
    case 2131363650: 
    case 2131364710: 
    case 2131364940: 
    case 2131377375: 
      ReadInJoyCommentUtils.FirstCommentEvent localFirstCommentEvent = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent;
      if (localFirstCommentEvent != null)
      {
        localFirstCommentEvent.onClick(paramView);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent.a(c());
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
        if (paramView != null) {
          paramView.jdField_b_of_type_Int = 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
      }
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor;
    if (paramBundle != null) {
      paramLayoutInflater = paramBundle.a(2131560115, true, new ViewGroup.LayoutParams(-1, -1));
    } else {
      paramLayoutInflater = paramLayoutInflater.inflate(2131560115, paramViewGroup, false);
    }
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
    if (localObject != null)
    {
      ((ReadInJoyCommentListAdapter)localObject).d();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
    if (localObject != null)
    {
      ((ReadInJoySecondCommentListFragment)localObject).onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$FirstCommentEvent = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment$OnCreateViewListener = null;
    localObject = getQBaseActivity().getIntent().getBundleExtra("bundle");
    if (localObject != null) {
      ReadInJoyLogicEngineEventDispatcher.a().c(((Bundle)localObject).getInt("seq"));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager;
    if (localObject != null) {
      ((RIJBiuAndCommentMixDataManager)localObject).a();
    }
    ReadInJoyDropFrameHelper.a().b(6666, this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
    }
    ReadInJoySecondCommentListFragment localReadInJoySecondCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
    if (localReadInJoySecondCommentListFragment != null) {
      localReadInJoySecondCommentListFragment.a();
    }
    QLog.d("ReadInJoyCommentListFragment", 0, "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
    if (localObject != null) {
      ((ReadInJoySecondCommentListFragment)localObject).b();
    }
    if ((getQBaseActivity() != null) && (getQBaseActivity().isFinishing()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
      if (localObject != null)
      {
        ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, ((ReadInJoyCommentListAdapter)localObject).b());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStop | removeCommentDataManager feedsType ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.b());
        QLog.d("ReadInJoyCommentListFragment", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment
 * JD-Core Version:    0.7.0.1
 */