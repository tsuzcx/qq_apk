package com.tencent.mobileqq.richstatus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureHandler.RspGetHistorySig;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.bean.LikeItem;
import com.tencent.mobileqq.richstatus.comment.bean.User;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.richstatus.sign.HistorySignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder.OnClickListener;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class SignatureHistoryFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, SoftInputDetectView.OnImStateChangedListener, ISignViewHolder.OnClickListener, ITopic.OnTopicClickListener, AbsListView.OnScrollListener
{
  protected int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new SignatureHistoryFragment.15(this);
  View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new SignatureHistoryFragment.23(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new SignatureHistoryFragment.14(this);
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected SignatureHandler a;
  protected SignatureManager a;
  protected SignatureObserver a;
  private IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  private SignatureHistoryFragment.DataAdapter jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter;
  protected StatusManager a;
  protected StatusObserver a;
  private CommentItem jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
  FontLoadCallback jdField_a_of_type_ComTencentMobileqqVasFontApiFontLoadCallback = new SignatureHistoryFragment.16(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  protected XListView a;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<ISignViewHolder> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<HistorySignItem> jdField_b_of_type_JavaUtilArrayList;
  private HashMap<String, Boolean> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private int a(List<LikeItem> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LikeItem localLikeItem = (LikeItem)paramList.next();
        if ((localLikeItem.a != null) && (paramString.equals(localLikeItem.a.jdField_a_of_type_JavaLangString))) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  @NotNull
  private View a(int paramInt, View paramView)
  {
    HistorySignItem localHistorySignItem = (HistorySignItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    if (paramView == null)
    {
      paramView = new BoxShadowLayout(getBaseActivity());
      localObject1 = a(paramView);
      paramView = new HistorySignViewHolder(getBaseActivity(), getBaseActivity().app, paramView, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashSet.add(paramView);
      paramView.a(this);
      paramView.a(this);
      localObject2 = (LinearLayout)paramView.b();
      paramView.c().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramView.c().setOnClickListener(this);
      LayoutInflater.from(getBaseActivity()).inflate(2131561488, (ViewGroup)localObject2);
      ((View)localObject1).setTag(paramView);
    }
    else
    {
      localObject2 = (HistorySignViewHolder)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject1).findViewById(2131364379));
    a((View)localObject1, localHistorySignItem, paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView = ((LikesView)((View)localObject1).findViewById(2131370344));
    paramView.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.setOnItemClickListener(new SignatureHistoryFragment.10(this));
    ((View)localObject1).setTag(paramView);
    ((View)localObject1).setClickable(true);
    a(localHistorySignItem, paramView);
    paramView.jdField_a_of_type_Int = paramInt;
    paramView.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = localHistorySignItem.richStatus;
    paramView.b = ((RichStatus)localObject2);
    paramView.a((RichStatus)localObject2);
    if (((localHistorySignItem.likeItemList != null) && (localHistorySignItem.likeItemList.size() > 0)) || ((localHistorySignItem.commentItemList != null) && (localHistorySignItem.commentItemList.size() > 0)))
    {
      if (paramView.b() != null)
      {
        paramView.b().setVisibility(0);
        paramView.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.a(localHistorySignItem.likeItemList, localHistorySignItem.totalLikeNum);
        paramView.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.a(localHistorySignItem.commentItemList);
      }
    }
    else if (paramView.b() != null) {
      paramView.b().setVisibility(8);
    }
    paramView.f = a(localHistorySignItem.likeItemList, this.jdField_b_of_type_JavaLangString);
    paramView.j();
    return localObject1;
  }
  
  @NotNull
  private View a(View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = getBaseActivity().getLayoutInflater().inflate(2131559469, null);
      localView.setBackgroundColor(getResources().getColor(2131167333));
      paramView = new SignatureHistoryFragment.MoreViewHolder();
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376345));
      localView.findViewById(2131370354).setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371517));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165327));
    }
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_e_of_type_Int = 2;
      a(false, false);
    }
    paramView = (SignatureHistoryFragment.MoreViewHolder)localView.getTag();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    int i = this.jdField_e_of_type_Int;
    if (i == 3)
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714001));
      localLayoutParams.height = AIOUtils.b(60.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      return localView;
    }
    if (i == 2)
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713987));
      localLayoutParams.height = AIOUtils.b(60.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      return localView;
    }
    if (i == 0)
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localLayoutParams.height = (ScreenUtil.SCREEN_HIGHT / 4);
      localView.setLayoutParams(localLayoutParams);
    }
    return localView;
  }
  
  private static IEmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (IEmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new SignatureHistoryFragment.17(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.setDisableGuide(true);
    paramView.setDisableMoreEmotionButton(true);
    paramView.setHasBigEmotion(false);
    paramView.setOnlySysAndEmoji(true);
    paramView.setDisableAutoDownload(true);
    paramView.init(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new SignatureHistoryFragment.18());
    paramView.setTabListOverScrollMode(2);
    return paramView;
  }
  
  private QQCustomDialog a()
  {
    return DialogUtil.a(getBaseActivity(), 230).setTitle(getString(2131719138)).setPositiveButton(getString(2131690788), new SignatureHistoryFragment.6(this)).setNegativeButton(getString(2131690728), new SignatureHistoryFragment.5(this));
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (getTitleBarView() != null) {
      getTitleBarView().setVisibility(8);
    }
    if ((getBaseActivity() != null) && (getBaseActivity().getWindow() != null))
    {
      getBaseActivity().getWindow().setSoftInputMode(16);
      getBaseActivity().getWindow().setBackgroundDrawable(getResources().getDrawable(2130847671));
      if (ImmersiveUtils.isSupporImmersive() != 0)
      {
        SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
        localSystemBarCompact.init();
        if (ImmersiveUtils.couldSetStatusTextColor())
        {
          ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
          localSystemBarCompact.setStatusBarColor(getResources().getColor(2131167333));
          return;
        }
        localSystemBarCompact.setStatusBarColor(SimpleUIUtil.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714012));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850811);
    if (paramInt == 3)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714004));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714008));
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidOsHandler.post(new SignatureHistoryFragment.21(this, paramInt1, i, paramInt2, paramBoolean));
  }
  
  private void a(Message paramMessage)
  {
    stopTitleProgress();
    this.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
    if (paramMessage.arg1 == 1)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
        a(2);
      }
      a(1, 2131719247);
    }
  }
  
  private void a(View paramView, HistorySignItem paramHistorySignItem, HistorySignViewHolder paramHistorySignViewHolder)
  {
    paramHistorySignViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView = ((CommentsView)paramView.findViewById(2131364754));
    paramHistorySignViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnSpanItemClick(new SignatureHistoryFragment.11(this));
    paramHistorySignViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemClickListener(new SignatureHistoryFragment.12(this, paramHistorySignItem));
    paramHistorySignViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemLongClickListener(new SignatureHistoryFragment.13(this, paramHistorySignItem));
  }
  
  private void a(View paramView, ISignViewHolder paramISignViewHolder)
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A989", "0X800A989", 0, 0, "0", "0", "", "");
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131698737);
    d(true);
    int i = a(paramView);
    int j = paramView.getHeight();
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SignatureHistoryFragment.9(this, i, j), 200L);
    if ((paramISignViewHolder instanceof HistorySignViewHolder))
    {
      paramView = ((HistorySignViewHolder)paramISignViewHolder).b;
      if ((paramView != null) && (getBaseActivity() != null) && (getBaseActivity().app != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = new CommentItem();
        paramISignViewHolder = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
        paramISignViewHolder.targetId = 0L;
        paramISignViewHolder.feedId = paramView.feedsId;
        paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
        paramView.toReplyUser = null;
        paramISignViewHolder = this.jdField_b_of_type_JavaLangString;
        paramView.user = new User(paramISignViewHolder, this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(paramISignViewHolder).longValue()));
      }
    }
  }
  
  private void a(SignatureHandler.RspGetHistorySig paramRspGetHistorySig)
  {
    if ((getBaseActivity() != null) && (getBaseActivity().app != null)) {
      getBaseActivity().app.setVisibilityForStatus(true, true);
    }
    if ((paramRspGetHistorySig != null) && (paramRspGetHistorySig.historySignItems != null)) {
      b(paramRspGetHistorySig);
    }
  }
  
  private void a(HistorySignItem paramHistorySignItem, HistorySignViewHolder paramHistorySignViewHolder)
  {
    if ((paramHistorySignItem != null) && (paramHistorySignItem.richStatus != null) && (paramHistorySignItem.richStatus.feedsId != null)) {
      paramHistorySignViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramHistorySignItem.richStatus.feedsId);
    } else {
      paramHistorySignViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setTag("");
    }
    if (this.jdField_e_of_type_Boolean)
    {
      paramHistorySignViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramHistorySignViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      paramHistorySignViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    if ((paramHistorySignItem != null) && (paramHistorySignItem.richStatus != null) && (paramHistorySignItem.richStatus.feedsId != null))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramHistorySignItem.richStatus.feedsId))
      {
        paramHistorySignViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        return;
      }
      paramHistorySignViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    paramHistorySignViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  private void a(CommentItem paramCommentItem)
  {
    if ((paramCommentItem != null) && (!TextUtils.isEmpty(paramCommentItem.feedId)))
    {
      Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          HistorySignItem localHistorySignItem = (HistorySignItem)((Iterator)localObject).next();
          if ((localHistorySignItem.richStatus != null) && (paramCommentItem.feedId.equals(localHistorySignItem.richStatus.feedsId)))
          {
            if (localHistorySignItem.commentItemList == null) {
              localHistorySignItem.commentItemList = new ArrayList();
            }
            localHistorySignItem.commentItemList.add(paramCommentItem);
          }
        }
      }
    }
  }
  
  private void a(CommentItem paramCommentItem, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(getBaseActivity());
    localActionSheet.addButton(2131692630, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new SignatureHistoryFragment.22(this, paramCommentItem, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  private void a(ISignViewHolder paramISignViewHolder)
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A988", "0X800A988", 0, 0, "0", "0", "", "");
    boolean bool = NetworkUtil.isNetSupport(getBaseActivity());
    int i = 0;
    if (!bool)
    {
      QQToast.a(getBaseActivity(), 2131693191, 0).a();
      return;
    }
    if ((paramISignViewHolder instanceof HistorySignViewHolder))
    {
      paramISignViewHolder = (HistorySignViewHolder)paramISignViewHolder;
      if (paramISignViewHolder.f == 0)
      {
        paramISignViewHolder.f = 1;
        i = 1;
      }
      else
      {
        paramISignViewHolder.f = 0;
      }
      if ((paramISignViewHolder.b != null) && (!TextUtils.isEmpty(paramISignViewHolder.b.feedsId)))
      {
        a(paramISignViewHolder.b.feedsId, this.jdField_b_of_type_JavaLangString, paramISignViewHolder.f);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter;
        if (localObject != null) {
          ((SignatureHistoryFragment.DataAdapter)localObject).notifyDataSetChanged();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler;
        if (localObject != null) {
          ((SignatureHandler)localObject).a(this.jdField_a_of_type_JavaLangString, paramISignViewHolder.b.feedsId, 255, i);
        }
      }
    }
  }
  
  private void a(Integer paramInteger, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(getBaseActivity());
    int j = paramInteger.intValue();
    int i = 1;
    if (j == 2)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(2131691865, false);
    }
    else if (paramBoolean)
    {
      if (paramInt1 > 1)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(2131691862, false);
        i = 3;
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(2131691864, false);
        i = 2;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(2131691861, false);
      i = 4;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new SignatureHistoryFragment.7(this, i, paramInt1, paramInt2));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new SignatureHistoryFragment.8(this));
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((getActivity() != null) && (!TextUtils.isEmpty(getBaseActivity().getCurrentAccountUin())) && (getBaseActivity().getCurrentAccountUin().equals(paramString))) {
      paramString = new AllInOne(paramString, 0);
    } else if (a(paramString)) {
      paramString = new AllInOne(paramString, 1);
    } else {
      paramString = new AllInOne(paramString, 19);
    }
    ProfileUtils.openProfileCard(getActivity(), paramString);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1)))
    {
      Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        HistorySignItem localHistorySignItem;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localHistorySignItem = (HistorySignItem)((Iterator)localObject).next();
        } while ((localHistorySignItem.richStatus == null) || (!paramString1.equals(localHistorySignItem.richStatus.feedsId)) || (!a(paramString2, paramInt, localHistorySignItem, localHistorySignItem.likeItemList)));
      }
    }
  }
  
  private void a(List<byte[]> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      byte[] arrayOfByte = (byte[])paramList.next();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        HistorySignItem localHistorySignItem = (HistorySignItem)localIterator.next();
        if ((localHistorySignItem == null) || (localHistorySignItem.richStatus == null) || (!localHistorySignItem.richStatus.feedsId.equals(new String(arrayOfByte)))) {
          break;
        }
        localIterator.remove();
      }
    }
  }
  
  private void a(boolean paramBoolean, List<byte[]> paramList)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if ((paramBoolean) && (paramList != null))
    {
      if (getBaseActivity() != null) {
        a(2, 2131691487);
      }
      a(paramList);
      if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
        a(3);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131719142);
      f(false);
      paramList = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter;
      if (paramList != null) {
        paramList.notifyDataSetChanged();
      }
    }
    else if (getBaseActivity() != null)
    {
      a(1, 2131699203);
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      return false;
    }
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if ((localEditText != null) && (paramBoolean)) {
      localEditText.setText("");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    InputMethodUtil.b(paramView);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    return true;
  }
  
  private boolean a(CommentItem paramCommentItem)
  {
    if ((paramCommentItem != null) && (!TextUtils.isEmpty(paramCommentItem.feedId)))
    {
      Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (a(paramCommentItem, (HistorySignItem)((Iterator)localObject).next())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean a(CommentItem paramCommentItem, HistorySignItem paramHistorySignItem)
  {
    if ((paramHistorySignItem.richStatus != null) && (paramCommentItem.feedId.equals(paramHistorySignItem.richStatus.feedsId)) && (paramHistorySignItem.commentItemList != null) && (paramHistorySignItem.commentItemList.size() > 0))
    {
      paramHistorySignItem = paramHistorySignItem.commentItemList.iterator();
      while (paramHistorySignItem.hasNext()) {
        if (((CommentItem)paramHistorySignItem.next()).id == paramCommentItem.id)
        {
          paramHistorySignItem.remove();
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt, HistorySignItem paramHistorySignItem, List<LikeItem> paramList)
  {
    Object localObject = paramList;
    if (paramInt == 1)
    {
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
    }
    if (localObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      if (paramInt == 0)
      {
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = (LikeItem)paramList.next();
          if ((((LikeItem)localObject).a != null) && (paramString.equals(((LikeItem)localObject).a.jdField_a_of_type_JavaLangString)))
          {
            paramList.remove();
            paramHistorySignItem.totalLikeNum -= 1L;
            return true;
          }
        }
        return false;
      }
      ((List)localObject).add(0, new LikeItem(NetConnInfoCenter.getServerTime() / 1000L, new User(paramString, a(paramString))));
      paramHistorySignItem.totalLikeNum += 1L;
    }
    return true;
  }
  
  private boolean a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str != null)
      {
        ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
        if ((localArrayList != null) && (localArrayList.get(0) != null) && (((HistorySignItem)this.jdField_b_of_type_JavaUtilArrayList.get(0)).richStatus != null) && (((HistorySignItem)this.jdField_b_of_type_JavaUtilArrayList.get(0)).richStatus.feedsId != null))
        {
          if (str.equals(new String(((HistorySignItem)this.jdField_b_of_type_JavaUtilArrayList.get(0)).richStatus.feedsId))) {
            paramBoolean = true;
          }
          paramArrayList.add(str);
        }
      }
    }
    return paramBoolean;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131376739));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131366316));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new SignatureHistoryFragment.2(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new SignatureHistoryFragment.3(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131364052));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    Button localButton = this.jdField_b_of_type_AndroidWidgetButton;
    localButton.setEnabled(TextUtils.isEmpty(localButton.getText()) ^ true);
  }
  
  private void b(Message paramMessage)
  {
    if (paramMessage.arg1 == 1)
    {
      a(1, 2131704505);
      return;
    }
    if (paramMessage.arg1 == 2) {
      a(1, 2131696376);
    }
  }
  
  private void b(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!NetworkUtil.isNetSupport(getBaseActivity()))
        {
          QQToast.a(getBaseActivity(), getString(2131692183), 0).a();
          return;
        }
        CommentItem localCommentItem = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
        if (localCommentItem != null)
        {
          localCommentItem.content = ((String)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(null);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
          }
          a(paramView, true);
        }
      }
    }
  }
  
  private void b(SignatureHandler.RspGetHistorySig paramRspGetHistorySig)
  {
    boolean bool = paramRspGetHistorySig.over;
    paramRspGetHistorySig = paramRspGetHistorySig.historySignItems;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject1 = paramRspGetHistorySig.iterator();
      Object localObject2 = this.jdField_b_of_type_JavaUtilArrayList;
      localObject2 = ((HistorySignItem)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).richStatus;
      if (localObject2 != null) {
        while (((Iterator)localObject1).hasNext())
        {
          RichStatus localRichStatus = ((HistorySignItem)((Iterator)localObject1).next()).richStatus;
          if ((localRichStatus.time <= ((RichStatus)localObject2).time) && ((localRichStatus.time != ((RichStatus)localObject2).time) || (!Arrays.equals(localRichStatus.encode(), ((RichStatus)localObject2).encode())))) {
            break;
          }
          ((Iterator)localObject1).remove();
        }
      }
    }
    Object localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
    ((ArrayList)localObject1).addAll(((ArrayList)localObject1).size(), paramRspGetHistorySig);
    this.jdField_e_of_type_Int = (bool ^ true);
  }
  
  private void b(boolean paramBoolean)
  {
    stopTitleProgress();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    a(1, 2131719247);
    this.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
  
  private void c()
  {
    ThreadManager.getFileThreadHandler().post(new SignatureHistoryFragment.4(this));
  }
  
  private void c(Message paramMessage)
  {
    if (isAdded())
    {
      if (paramMessage.arg1 >= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131719140), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void c(View paramView)
  {
    int k = 0;
    this.jdField_f_of_type_Boolean = false;
    Object localObject2 = paramView.getTag(2131377595);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = Integer.valueOf(0);
        if (paramView.getTag(2131377598) != null)
        {
          int j = ((Integer)paramView.getTag(2131377598)).intValue();
          i = j;
          if (j <= 1) {
            break label161;
          }
          bool1 = true;
          i = j;
          j = k;
          boolean bool2 = bool1;
          if (paramView.getTag(2131377596) != null)
          {
            k = ((Integer)paramView.getTag(2131377596)).intValue();
            j = k;
            bool2 = bool1;
            if (k > 0)
            {
              bool2 = true;
              j = k;
            }
          }
          if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
            return;
          }
          a((Integer)localObject1, i, j, bool2);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      int i = 1;
      label161:
      boolean bool1 = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
    int m = this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount();
    int i = j - 1;
    while (i <= k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(m + i - j);
      if ((localObject != null) && ((((View)localObject).getTag() instanceof HistorySignViewHolder)))
      {
        localObject = (HistorySignViewHolder)((View)localObject).getTag();
        ((HistorySignViewHolder)localObject).b(paramBoolean);
        if (((HistorySignViewHolder)localObject).jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
          if (paramBoolean)
          {
            ((HistorySignViewHolder)localObject).jdField_a_of_type_ComEtrumpMixlayoutETTextView.pauseAnimation();
          }
          else
          {
            ((HistorySignViewHolder)localObject).jdField_a_of_type_ComEtrumpMixlayoutETTextView.shouldStartAnimation = true;
            ((HistorySignViewHolder)localObject).jdField_a_of_type_ComEtrumpMixlayoutETTextView.startAnimation(false, false);
          }
        }
      }
      i += 1;
    }
  }
  
  private void d()
  {
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).length() == 0) {
      localObject1 = String.valueOf(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getBaseActivity().getString(2131691173));
    ((StringBuilder)localObject2).append(":");
    localObject2 = ((StringBuilder)localObject2).toString();
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append((String)localObject1);
    localTextView.setContentDescription(localStringBuilder.toString());
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(false);
      InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_e_of_type_Boolean)) {
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_Int = 1;
        d(false);
        return;
      }
      i();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850215);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getBaseActivity().getString(2131690246));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new SignatureHistoryFragment.19(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setVisibility(8);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (getBaseActivity() != null))
    {
      ((ClipboardManager)getBaseActivity().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = null;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getBaseActivity().getResources().getColor(2131167017));
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getBaseActivity().getResources().getString(2131719139), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(UITools.a);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getBaseActivity().getResources().getColor(2131167018));
        this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131719137));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(null);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130847667);
      return;
    }
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131718229));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131167394));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839280);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetSupport(getBaseActivity()))
    {
      QQToast.a(getBaseActivity(), 2131693191, 0).a();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.id);
    }
  }
  
  private void h()
  {
    if (this.jdField_e_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          return;
        }
        if (!NetworkUtil.isNetSupport(getBaseActivity()))
        {
          QQToast.a(getBaseActivity(), getString(2131692183), 0).a();
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800A98C", "0X800A98C", 0, 0, "0", "0", "", "");
        a().show();
        return;
      }
    }
    VasWebviewUtil.a("signature_history", "edit_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    SignatureEditManager.a(getBaseActivity(), getBaseActivity().app, 0, "signature_history");
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837622);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getBaseActivity().getString(2131690247));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new SignatureHistoryFragment.20(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setVisibility(0);
    int i;
    if (this.jdField_d_of_type_Int > ScreenUtil.SCREEN_HIGHT / 4) {
      i = this.jdField_d_of_type_Int;
    } else {
      i = ScreenUtil.SCREEN_HIGHT / 3;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().getLayoutParams();
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setMinimumHeight(localLayoutParams.height);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setLayoutParams(localLayoutParams);
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = i;
    this.jdField_c_of_type_Int = 0;
  }
  
  private void j()
  {
    this.jdField_e_of_type_Boolean ^= true;
    if (this.jdField_e_of_type_Boolean)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A98B", "0X800A98B", 0, 0, "0", "0", "", "");
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131692486);
    }
    else
    {
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131719142);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.notifyDataSetChanged();
  }
  
  public LinearLayout a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(getBaseActivity());
    localLinearLayout.setOrientation(0);
    Object localObject = (CheckBox)LayoutInflater.from(getBaseActivity()).inflate(2131561487, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = AIOUtils.b(16.0F, getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    int i = AIOUtils.b(10.0F, getResources());
    localObject = new LinearLayout.LayoutParams(ViewUtils.a() - i * 2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = i;
    ((LinearLayout.LayoutParams)localObject).rightMargin = i;
    localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
    return localLinearLayout;
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (getBaseActivity() != null)
    {
      if (getBaseActivity().app == null) {
        return paramString;
      }
      Friends localFriends = ((FriendsManager)getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
      str = paramString;
      if (localFriends != null) {
        str = localFriends.getFriendNickWithAlias();
      }
    }
    return str;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((getBaseActivity() != null) && (getBaseActivity().isResume())) {
      QQToast.a(getBaseActivity(), paramInt1, getResources().getString(paramInt2), 0).b(getBaseActivity().getTitleBarHeight());
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    VasWebviewUtil.a("signature_history", "cove_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    c(paramView);
  }
  
  public void a(View paramView, int paramInt, ISignViewHolder paramISignViewHolder)
  {
    QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick viewType=", paramView });
    if (paramInt == 3)
    {
      a(paramView, paramISignViewHolder);
      return;
    }
    if (paramInt == 4)
    {
      a(paramISignViewHolder);
      return;
    }
    if ((paramInt == 2) && ((paramISignViewHolder instanceof HistorySignViewHolder)) && (this.jdField_a_of_type_ComTencentWidgetActionSheet == null))
    {
      this.jdField_f_of_type_Boolean = true;
      a(((HistorySignViewHolder)paramISignViewHolder).c());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    View localView = localBaseActivity.findViewById(2131371886);
    if (paramBoolean)
    {
      if (localView == null)
      {
        localView = new View(getBaseActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131371886);
        localBaseActivity.addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
        return;
      }
      localView.setVisibility(0);
      return;
    }
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = 0;
      this.jdField_d_of_type_Int = paramInt;
      e(false);
      f(true);
    }
    else
    {
      if (this.jdField_c_of_type_Int == 1) {
        i();
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      f(false);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateData: refresh=");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" user=");
    ((StringBuilder)localObject).append(paramBoolean2);
    QLog.d("SignatureHistoryFragment", 2, ((StringBuilder)localObject).toString());
    if (NetworkUtil.isNetSupport(getBaseActivity()))
    {
      this.jdField_c_of_type_Boolean = paramBoolean1;
      long l;
      if (paramBoolean1)
      {
        l = 2147483647L;
      }
      else
      {
        localObject = this.jdField_b_of_type_JavaUtilArrayList;
        l = ((HistorySignItem)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).richStatus.time - 1L;
      }
      int i = (int)l;
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, i);
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 1, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1000L);
      if (!paramBoolean1)
      {
        this.jdField_e_of_type_Int = 3;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter;
        if (localObject != null) {
          ((SignatureHistoryFragment.DataAdapter)localObject).notifyDataSetChanged();
        }
      }
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
      a(1);
    }
    if (paramBoolean2)
    {
      stopTitleProgress();
      return;
    }
    if (paramBoolean1) {
      startTitleProgress();
    }
  }
  
  public boolean a(String paramString)
  {
    if ((getBaseActivity() != null) && (getBaseActivity().app != null)) {
      return ((FriendsManager)getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
    }
    return false;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    if (getBaseActivity() != null)
    {
      if (getBaseActivity().app == null) {
        return;
      }
      ((IFontManagerService)getBaseActivity().app.getRuntimeService(IFontManagerService.class, "")).addFontLoadCallback(this.jdField_a_of_type_ComTencentMobileqqVasFontApiFontLoadCallback);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_c_of_type_JavaLangString = getBaseActivity().getIntent().getStringExtra("key_uin_name");
      this.jdField_a_of_type_JavaLangString = getBaseActivity().getIntent().getStringExtra("key_uin");
      this.jdField_b_of_type_JavaLangString = getBaseActivity().app.getCurrentUin();
      paramLayoutInflater = getBaseActivity().getIntent().getStringExtra("key_open_via");
      VasWebviewUtil.a(getBaseActivity().app.getCurrentUin(), "signature", "signature_8", paramLayoutInflater, 1, 0, 0, "", "", "");
      boolean bool = this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString);
      int j = 2;
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(getBaseActivity().app, "dc00898", "", "", "0X800A987", "0X800A987", i, 0, "0", "0", "", "");
      this.leftView.setTextColor(getResources().getColor(2131165327));
      this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840342));
      this.centerView.setTextColor(getResources().getColor(2131165327));
      paramLayoutInflater = new DisplayMetrics();
      getBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(paramLayoutInflater);
      int i = paramLayoutInflater.widthPixels;
      int k = DisplayUtil.a(getBaseActivity(), 69.0F);
      this.jdField_b_of_type_Int = Math.min(DisplayUtil.a(getBaseActivity(), 260.0F), i - k);
      this.jdField_a_of_type_Int = ((this.jdField_b_of_type_Int - DisplayUtil.a(getBaseActivity(), 70.0F)) / DisplayUtil.a(getBaseActivity(), 28.0F));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)getBaseActivity().app.getManager(QQManagerFactory.SIGNATURE_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)getBaseActivity().app.getManager(QQManagerFactory.STATUS_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler = ((SignatureHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new SignatureHistoryFragment.MyStatusObserver(this, null);
      getBaseActivity().app.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new SignatureHistoryFragment.MySignatureObserver(this, null);
      getBaseActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379881));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131719141);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379880));
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379879));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getText(2131690706));
      i = UIUtils.a(getBaseActivity(), 3.0F);
      k = UIUtils.a(getBaseActivity(), 10.0F);
      UIUtils.a(this.jdField_d_of_type_AndroidWidgetTextView, i, i, k, k);
      if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(2131719142);
      }
      else
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131562855, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366229));
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366218));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131377582));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView = this.mContentView.findViewById(2131377581);
      f(false);
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131562856, null);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377579));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377580));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377589));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131365189));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_c_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter = new SignatureHistoryFragment.DataAdapter(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131379073);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new SignatureHistoryFragment.1(this));
      b();
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131366154));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131366182));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
      paramLayoutInflater = (SoftInputDetectView)this.mContentView.findViewById(2131368888);
      paramLayoutInflater.setExcludeStatusBar(false);
      paramLayoutInflater.setOnImStateChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = a(getBaseActivity().app, getBaseActivity(), this.mContentView, 2131366155, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setVisibility(8);
      a();
      c();
      paramLayoutInflater = this.jdField_c_of_type_JavaLangString;
      if ((paramLayoutInflater == null) || (paramLayoutInflater.equals(""))) {
        this.jdField_c_of_type_JavaLangString = ContactUtils.d(getBaseActivity().app, this.jdField_a_of_type_JavaLangString);
      }
      d();
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler;
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      }
      i = j;
      if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        i = 1;
      }
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("");
      paramLayoutInflater.append(i);
      ReportController.b(null, "dc00898", "", "", "0X800A4ED", "0X800A4ED", i, 0, paramLayoutInflater.toString(), "0", "", "");
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("");
      paramLayoutInflater.append(i);
      VasWebviewUtil.a("signature_history", "pv", "", 0, 0, 0, "", "", paramLayoutInflater.toString(), "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131562859;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return true;
            }
            b(paramMessage);
            return true;
          }
          c(paramMessage);
          return true;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.notifyDataSetChanged();
      return true;
    }
    a(paramMessage);
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(256);
  }
  
  public boolean onBackEvent()
  {
    if ((!getBaseActivity().isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().getVisibility() == 0))
    {
      e(false);
      return true;
    }
    if (("history-msglist".equalsIgnoreCase(getBaseActivity().getIntent().getStringExtra("key_open_via"))) && (getBaseActivity() != null))
    {
      Object localObject = this.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)))
      {
        localObject = new AllInOne(this.jdField_a_of_type_JavaLangString, 0);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("single_top", true);
        ProfileActivity.a(getBaseActivity(), (AllInOne)localObject, localBundle);
        getBaseActivity().overridePendingTransition(2130772002, 2130772003);
      }
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131379880: 
      j();
      break;
    case 2131379879: 
      onBackEvent();
      break;
    case 2131377595: 
      a(paramView);
      break;
    case 2131377582: 
      h();
      break;
    case 2131377579: 
      e();
      break;
    case 2131365480: 
      g();
      break;
    case 2131365311: 
      f();
      break;
    case 2131364052: 
      b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick topic=", paramITopic });
    paramITopic = paramITopic.getData();
    if ((paramITopic instanceof Pair))
    {
      paramITopic = (Pair)paramITopic;
      if (QLog.isColorLevel()) {
        QLog.i("SignatureHistoryFragment", 2, String.format("history onTopicClick [%d,%s]", new Object[] { paramITopic.first, paramITopic.second }));
      }
      TopicUtil.a(getBaseActivity(), TopicUtil.a(((Integer)paramITopic.first).intValue(), (String)paramITopic.second), -1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ISignViewHolder)((Iterator)localObject).next()).k();
    }
    getBaseActivity().app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    getBaseActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
    ((IFontManagerService)getBaseActivity().app.getRuntimeService(IFontManagerService.class, "")).removeFontLoadCallback(this.jdField_a_of_type_ComTencentMobileqqVasFontApiFontLoadCallback);
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a(true, false);
    if ((getBaseActivity() != null) && (getBaseActivity().app != null)) {
      a(ThemeUtil.isInNightMode(getBaseActivity().app));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      VasFaceManager.b();
      com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
      c(false);
      return;
    }
    URLDrawable.pause();
    VasFaceManager.a();
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = false;
    c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment
 * JD-Core Version:    0.7.0.1
 */