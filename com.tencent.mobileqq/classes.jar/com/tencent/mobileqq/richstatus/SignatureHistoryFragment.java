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
import android.support.v4.app.FragmentActivity;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.FontManager.FontLoadCallback;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.bean.LikeItem;
import com.tencent.mobileqq.richstatus.comment.bean.User;
import com.tencent.mobileqq.richstatus.sign.HistorySignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder.OnClickListener;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SignatureHistoryFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, SoftInputDetectView.OnImStateChangedListener, ISignViewHolder.OnClickListener, ITopic.OnTopicClickListener, AbsListView.OnScrollListener
{
  protected int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new SignatureHistoryFragment.11(this);
  View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new SignatureHistoryFragment.19(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new SignatureHistoryFragment.10(this);
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FontManager.FontLoadCallback jdField_a_of_type_ComEtrumpMixlayoutFontManager$FontLoadCallback = new SignatureHistoryFragment.12(this);
  protected SignatureHandler a;
  protected SignatureManager a;
  protected SignatureObserver a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private SignatureHistoryFragment.DataAdapter jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter;
  protected StatusManager a;
  protected StatusObserver a;
  private CommentItem jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
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
    if ((paramList == null) || (paramList.size() <= 0) || (TextUtils.isEmpty(paramString))) {
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
    return 0;
  }
  
  private static EmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new SignatureHistoryFragment.13(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.disableGuide = true;
    paramView.disableMoreEmotionButton = true;
    paramView.hasBigEmotion = false;
    paramView.onlySysAndEmoji = true;
    paramView.disableAutoDownload = true;
    paramView.init(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new SignatureHistoryFragment.14());
    paramView.mEmoticonTabs.setOverScrollMode(2);
    return paramView;
  }
  
  private void a()
  {
    ThreadManager.getFileThreadHandler().post(new SignatureHistoryFragment.4(this));
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714083));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850874);
    if (paramInt == 3)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714074));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714079));
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidOsHandler.post(new SignatureHistoryFragment.17(this, paramInt1, i, paramInt2, paramBoolean));
  }
  
  private void a(CommentItem paramCommentItem)
  {
    if ((paramCommentItem != null) && (!TextUtils.isEmpty(paramCommentItem.feedId)) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        HistorySignItem localHistorySignItem = (HistorySignItem)localIterator.next();
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
  
  private void a(CommentItem paramCommentItem, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(getActivity());
    localActionSheet.addButton(2131692673, 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new SignatureHistoryFragment.18(this, paramCommentItem, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((getActivity() != null) && (!TextUtils.isEmpty(getActivity().getCurrentAccountUin())) && (getActivity().getCurrentAccountUin().equals(paramString))) {
      paramString = new ProfileActivity.AllInOne(paramString, 0);
    }
    for (;;)
    {
      ProfileActivity.b(getActivity(), paramString);
      return;
      if (a(paramString)) {
        paramString = new ProfileActivity.AllInOne(paramString, 1);
      } else {
        paramString = new ProfileActivity.AllInOne(paramString, 19);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    Iterator localIterator;
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1)) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    }
    HistorySignItem localHistorySignItem;
    Object localObject2;
    Object localObject1;
    label129:
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        while (localIterator.hasNext())
        {
          localHistorySignItem = (HistorySignItem)localIterator.next();
          if ((localHistorySignItem.richStatus != null) && (paramString1.equals(localHistorySignItem.richStatus.feedsId)))
          {
            localObject2 = localHistorySignItem.likeItemList;
            localObject1 = localObject2;
            if (paramInt == 1)
            {
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = new ArrayList();
              }
            }
            if ((localObject1 != null) && (!TextUtils.isEmpty(paramString2))) {
              break label129;
            }
          }
        }
        return;
        if (paramInt != 0) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
      }
      localObject2 = (LikeItem)((Iterator)localObject1).next();
    } while ((((LikeItem)localObject2).a == null) || (!paramString2.equals(((LikeItem)localObject2).a.jdField_a_of_type_JavaLangString)));
    ((Iterator)localObject1).remove();
    localHistorySignItem.totalLikeNum -= 1L;
    return;
    ((List)localObject1).add(0, new LikeItem(NetConnInfoCenter.getServerTime() / 1000L, new User(paramString2, a(paramString2))));
    localHistorySignItem.totalLikeNum += 1L;
  }
  
  private boolean a(View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0))
    {
      if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (paramBoolean)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      InputMethodUtil.b(paramView);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
      bool = true;
    }
    return bool;
  }
  
  private boolean a(CommentItem paramCommentItem)
  {
    if ((paramCommentItem != null) && (!TextUtils.isEmpty(paramCommentItem.feedId)) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      Object localObject;
      do
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (HistorySignItem)localIterator.next();
          } while ((((HistorySignItem)localObject).richStatus == null) || (!paramCommentItem.feedId.equals(((HistorySignItem)localObject).richStatus.feedsId)) || (((HistorySignItem)localObject).commentItemList == null) || (((HistorySignItem)localObject).commentItemList.size() <= 0));
          localObject = ((HistorySignItem)localObject).commentItemList.iterator();
        }
      } while (((CommentItem)((Iterator)localObject).next()).id != paramCommentItem.id);
      ((Iterator)localObject).remove();
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      return;
    }
    String str2 = this.jdField_c_of_type_JavaLangString;
    String str1 = str2;
    if (str2.length() == 0) {
      str1 = String.valueOf(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
    str2 = getActivity().getString(2131691252) + ":";
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str2 + str1);
  }
  
  private void b(boolean paramBoolean)
  {
    stopTitleProgress();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    a(1, 2131719529);
    this.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837535);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690326));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new SignatureHistoryFragment.16(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
    if (this.jdField_d_of_type_Int > ScreenUtil.SCREEN_HIGHT / 4) {}
    for (int i = this.jdField_d_of_type_Int;; i = ScreenUtil.SCREEN_HIGHT / 3)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams();
      localLayoutParams.height = i;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setMinimumHeight(localLayoutParams.height);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setLayoutParams(localLayoutParams);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = i;
      this.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
    int m = this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount();
    int i = j - 1;
    if (i <= k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(m + i - j);
      if ((localObject != null) && ((((View)localObject).getTag() instanceof HistorySignViewHolder)))
      {
        localObject = (HistorySignViewHolder)((View)localObject).getTag();
        ((HistorySignViewHolder)localObject).b(paramBoolean);
        if (((HistorySignViewHolder)localObject).a != null)
        {
          if (!paramBoolean) {
            break label110;
          }
          ((HistorySignViewHolder)localObject).a.pauseAnimation();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((HistorySignViewHolder)localObject).a.shouldStartAnimation = true;
        ((HistorySignViewHolder)localObject).a.startAnimation(false, false);
      }
    }
  }
  
  private void d()
  {
    boolean bool;
    if (!this.jdField_e_of_type_Boolean)
    {
      bool = true;
      this.jdField_e_of_type_Boolean = bool;
      if (!this.jdField_e_of_type_Boolean) {
        break label82;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A98B", "0X800A98B", 0, 0, "0", "0", "", "");
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131692534);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.notifyDataSetChanged();
      return;
      bool = false;
      break;
      label82:
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131719424);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
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
      c();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850288);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690325));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new SignatureHistoryFragment.15(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
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
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getActivity().getResources().getColor(2131166995));
        this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131719419));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(null);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130847800);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getActivity().getResources().getColor(2131166994));
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getActivity().getResources().getString(2131719421), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(UITools.a);
      }
    }
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131718561));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131167374));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839424);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public LinearLayout a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setOrientation(0);
    Object localObject = (CheckBox)LayoutInflater.from(getActivity()).inflate(2131561637, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = AIOUtils.a(16.0F, getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    int i = AIOUtils.a(10.0F, getResources());
    localObject = new LinearLayout.LayoutParams(ViewUtils.a() - i * 2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = i;
    ((LinearLayout.LayoutParams)localObject).rightMargin = i;
    localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
    return localLinearLayout;
  }
  
  public String a(String paramString)
  {
    if ((getActivity() == null) || (getActivity().app == null)) {}
    Friends localFriends;
    do
    {
      return paramString;
      localFriends = ((FriendsManager)getActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    } while (localFriends == null);
    return localFriends.getFriendNickWithAlias();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((getActivity() != null) && (getActivity().isResume())) {
      QQToast.a(getActivity(), paramInt1, getResources().getString(paramInt2), 0).b(getActivity().getTitleBarHeight());
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {}
    do
    {
      return;
      VasWebviewUtil.reportCommercialDrainage("signature_history", "cove_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    } while (!this.jdField_f_of_type_Boolean);
    this.jdField_f_of_type_Boolean = false;
    Object localObject2 = paramView.getTag(2131378174);
    int i = 1;
    int k = 0;
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    for (;;)
    {
      int m;
      int j;
      try
      {
        localObject1 = Integer.valueOf(0);
        m = 0;
        if (paramView.getTag(2131378182) == null) {
          break label348;
        }
        j = ((Integer)paramView.getTag(2131378182)).intValue();
        i = j;
        if (j <= 1) {
          break label348;
        }
        i = 1;
        m = i;
        if (paramView.getTag(2131378175) != null)
        {
          int n = ((Integer)paramView.getTag(2131378175)).intValue();
          m = i;
          k = n;
          if (n > 0)
          {
            m = 1;
            k = n;
          }
        }
        if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(getActivity());
        if (((Integer)localObject1).intValue() == 2)
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(2131691940, false);
          i = 1;
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new SignatureHistoryFragment.7(this, i, j, k));
          this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new SignatureHistoryFragment.8(this));
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (m != 0)
      {
        if (j > 1)
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(2131691937, false);
          i = 3;
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(2131691939, false);
          i = 2;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(2131691936, false);
        i = 4;
        continue;
        label348:
        j = i;
        i = m;
      }
    }
  }
  
  public void a(View paramView, int paramInt, ISignViewHolder paramISignViewHolder)
  {
    QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick viewType=", paramView });
    if (paramInt == 3) {
      if (!this.jdField_e_of_type_Boolean) {}
    }
    label462:
    do
    {
      for (;;)
      {
        return;
        ReportController.b(null, "dc00898", "", "", "0X800A989", "0X800A989", 0, 0, "0", "0", "", "");
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131698668);
        d(true);
        paramInt = a(paramView);
        int i = paramView.getHeight();
        this.jdField_a_of_type_AndroidViewView = paramView;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SignatureHistoryFragment.9(this, paramInt, i), 200L);
        if ((paramISignViewHolder instanceof HistorySignViewHolder))
        {
          paramView = ((HistorySignViewHolder)paramISignViewHolder).b;
          if ((paramView != null) && (getActivity() != null) && (getActivity().app != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = new CommentItem();
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId = 0L;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId = paramView.feedsId;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.toReplyUser = null;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.user = new User(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue()));
            return;
            if (paramInt != 4) {
              break;
            }
            if (!this.jdField_e_of_type_Boolean)
            {
              ReportController.b(null, "dc00898", "", "", "0X800A988", "0X800A988", 0, 0, "0", "0", "", "");
              if (!NetworkUtil.d(getActivity()))
              {
                QQToast.a(getActivity(), 2131693237, 0).a();
                return;
              }
              if ((paramISignViewHolder instanceof HistorySignViewHolder))
              {
                if (((HistorySignViewHolder)paramISignViewHolder).f == 0) {
                  ((HistorySignViewHolder)paramISignViewHolder).f = 1;
                }
                for (paramInt = 1;; paramInt = 0)
                {
                  if ((((HistorySignViewHolder)paramISignViewHolder).b == null) || (TextUtils.isEmpty(((HistorySignViewHolder)paramISignViewHolder).b.feedsId))) {
                    break label462;
                  }
                  a(((HistorySignViewHolder)paramISignViewHolder).b.feedsId, this.jdField_b_of_type_JavaLangString, ((HistorySignViewHolder)paramISignViewHolder).f);
                  if (this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter != null) {
                    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.notifyDataSetChanged();
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(this.jdField_a_of_type_JavaLangString, ((HistorySignViewHolder)paramISignViewHolder).b.feedsId, 255, paramInt);
                  return;
                  ((HistorySignViewHolder)paramISignViewHolder).f = 0;
                }
              }
            }
          }
        }
      }
    } while ((paramInt != 2) || (!(paramISignViewHolder instanceof HistorySignViewHolder)) || (this.jdField_a_of_type_ComTencentWidgetActionSheet != null));
    this.jdField_f_of_type_Boolean = true;
    a(((HistorySignViewHolder)paramISignViewHolder).c());
  }
  
  public void a(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    View localView = localFragmentActivity.findViewById(2131372298);
    if (paramBoolean) {
      if (localView == null)
      {
        localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131372298);
        localFragmentActivity.addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    while (localView == null)
    {
      return;
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = 0;
      this.jdField_d_of_type_Int = paramInt;
      e(false);
      f(true);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    if (this.jdField_c_of_type_Int == 1) {
      c();
    }
    for (;;)
    {
      f(false);
      break;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("SignatureHistoryFragment", 2, "updateData: refresh=" + paramBoolean1 + " user=" + paramBoolean2);
    long l;
    if (NetworkUtil.d(getActivity()))
    {
      this.jdField_c_of_type_Boolean = paramBoolean1;
      if (paramBoolean1)
      {
        l = 2147483647L;
        int i = (int)l;
        this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, i);
        label84:
        if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
          a(1);
        }
        if (!paramBoolean2) {
          break label192;
        }
        stopTitleProgress();
      }
    }
    label192:
    while (!paramBoolean1)
    {
      return;
      l = ((HistorySignItem)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_JavaUtilArrayList.size() - 1)).richStatus.time - 1L;
      break;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 1, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      if (paramBoolean1) {
        break label84;
      }
      this.jdField_e_of_type_Int = 3;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter == null) {
        break label84;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.notifyDataSetChanged();
      break label84;
    }
    startTitleProgress();
  }
  
  public boolean a(String paramString)
  {
    if ((getActivity() == null) || (getActivity().app == null)) {
      return false;
    }
    return ((FriendsManager)getActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    ((FontManager)getActivity().app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager$FontLoadCallback);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaLangString = getActivity().getIntent().getStringExtra("key_uin_name");
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("key_uin");
    this.jdField_b_of_type_JavaLangString = getActivity().app.getCurrentUin();
    paramLayoutInflater = getActivity().getIntent().getStringExtra("key_open_via");
    VasWebviewUtil.reportCommercialDrainage(getActivity().app.getCurrentUin(), "signature", "signature_8", paramLayoutInflater, 1, 0, 0, "", "", "");
    label625:
    boolean bool;
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      i = 1;
      ReportController.b(getActivity().app, "dc00898", "", "", "0X800A987", "0X800A987", i, 0, "0", "0", "", "");
      this.leftView.setTextColor(getResources().getColor(2131165357));
      this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840473));
      this.centerView.setTextColor(getResources().getColor(2131165357));
      paramLayoutInflater = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramLayoutInflater);
      i = paramLayoutInflater.widthPixels;
      int j = DisplayUtil.a(getActivity(), 69.0F);
      this.jdField_b_of_type_Int = Math.min(DisplayUtil.a(getActivity(), 260.0F), i - j);
      this.jdField_a_of_type_Int = ((this.jdField_b_of_type_Int - DisplayUtil.a(getActivity(), 70.0F)) / DisplayUtil.a(getActivity(), 28.0F));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)getActivity().app.getManager(QQManagerFactory.SIGNATURE_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)getActivity().app.getManager(QQManagerFactory.STATUS_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler = ((SignatureHandler)getActivity().app.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new SignatureHistoryFragment.MyStatusObserver(this, null);
      getActivity().app.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new SignatureHistoryFragment.MySignatureObserver(this, null);
      getActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380600));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131719423);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380599));
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380598));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getText(2131690778));
      i = UIUtils.a(getActivity(), 3.0F);
      j = UIUtils.a(getActivity(), 10.0F);
      UIUtils.a(this.jdField_d_of_type_AndroidWidgetTextView, i, i, j, j);
      if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        break label1508;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131719424);
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131563032, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366341));
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366330));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839549);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131378156));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView = this.mContentView.findViewById(2131378155);
      f(false);
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131563033, null);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378153));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378154));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378163));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131365314));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_c_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter = new SignatureHistoryFragment.DataAdapter(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131379735);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new SignatureHistoryFragment.1(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131377282));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131366435));
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new SignatureHistoryFragment.2(this));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new SignatureHistoryFragment.3(this));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131364131));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramLayoutInflater = this.jdField_b_of_type_AndroidWidgetButton;
      if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetButton.getText())) {
        break label1520;
      }
      bool = true;
      label1058:
      paramLayoutInflater.setEnabled(bool);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131366266));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131366294));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
      paramLayoutInflater = (SoftInputDetectView)this.mContentView.findViewById(2131369156);
      paramLayoutInflater.setExcludeStatusBar(false);
      paramLayoutInflater.setOnImStateChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(getActivity().app, getActivity(), this.mContentView, 2131366267, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      if (getTitleBarView() != null) {
        getTitleBarView().setVisibility(8);
      }
      if ((getActivity() != null) && (getActivity().getWindow() != null))
      {
        getActivity().getWindow().setSoftInputMode(16);
        getActivity().getWindow().setBackgroundDrawable(getResources().getDrawable(2130847804));
        if (ImmersiveUtils.isSupporImmersive() != 0)
        {
          paramLayoutInflater = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
          paramLayoutInflater.init();
          if (!ImmersiveUtils.couldSetStatusTextColor()) {
            break label1526;
          }
          ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
          paramLayoutInflater.setStatusBarColor(getResources().getColor(2131167305));
        }
      }
      label1307:
      a();
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.equals(""))) {
        this.jdField_c_of_type_JavaLangString = ContactUtils.j(getActivity().app, this.jdField_a_of_type_JavaLangString);
      }
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      }
      if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        break label1536;
      }
    }
    label1536:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A4ED", "0X800A4ED", i, 0, "" + i, "0", "", "");
      VasWebviewUtil.reportCommercialDrainage("signature_history", "pv", "", 0, 0, 0, "", "", "" + i, "", "", "", "", 0, 0, 0, 0);
      return;
      i = 2;
      break;
      label1508:
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      break label625;
      label1520:
      bool = false;
      break label1058;
      label1526:
      paramLayoutInflater.setStatusBarColor(SimpleUIUtil.jdField_a_of_type_Int);
      break label1307;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131563036;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          stopTitleProgress();
          this.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
        } while (paramMessage.arg1 != 1);
        if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
          a(2);
        }
        a(1, 2131719529);
        return true;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.notifyDataSetChanged();
        return true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
        return true;
      } while (!isAdded());
      if (paramMessage.arg1 >= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131719422), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return true;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
      if (paramMessage.arg1 == 1)
      {
        a(1, 2131704415);
        return true;
      }
    } while (paramMessage.arg1 != 2);
    a(1, 2131696357);
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(256);
  }
  
  public boolean onBackEvent()
  {
    if ((!getActivity().isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0))
    {
      e(false);
      return true;
    }
    if (("history-msglist".equalsIgnoreCase(getActivity().getIntent().getStringExtra("key_open_via"))) && (getActivity() != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)))
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 0);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("single_top", true);
      ProfileActivity.a(getActivity(), localAllInOne, localBundle);
      getActivity().overridePendingTransition(2130771990, 2130771991);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onBackEvent();
      continue;
      d();
      continue;
      if (this.jdField_e_of_type_Boolean)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
        }
        if (!NetworkUtil.d(getActivity()))
        {
          QQToast.a(getActivity(), getString(2131692257), 0).a();
        }
        else
        {
          ReportController.b(null, "dc00898", "", "", "0X800A98C", "0X800A98C", 0, 0, "0", "0", "", "");
          DialogUtil.a(getActivity(), 230).setTitle(getString(2131719420)).setPositiveButton(getString(2131690860), new SignatureHistoryFragment.6(this)).setNegativeButton(getString(2131690800), new SignatureHistoryFragment.5(this)).show();
        }
      }
      else
      {
        VasWebviewUtil.reportCommercialDrainage("signature_history", "edit_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        SignatureEditManager.a(getActivity(), getActivity().app, 0, "signature_history");
        continue;
        if (this.jdField_a_of_type_AndroidWidgetEditText != null)
        {
          ??? = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (!TextUtils.isEmpty((CharSequence)???)) {
            if (!NetworkUtil.d(getActivity()))
            {
              QQToast.a(getActivity(), getString(2131692257), 0).a();
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content = ((String)???);
              if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
                  this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
                }
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(null);
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
                this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
              }
              a(paramView, true);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (getActivity() != null))
              {
                ((ClipboardManager)getActivity().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
                this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = null;
                continue;
                if (!NetworkUtil.d(getActivity()))
                {
                  QQToast.a(getActivity(), 2131693237, 0).a();
                }
                else if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
                    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
                  }
                  this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(null);
                  this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
                  this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.id);
                  continue;
                  a(paramView);
                  continue;
                  if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_e_of_type_Boolean)) {
                    a(this.jdField_a_of_type_JavaLangString);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick topic=", paramITopic });
      paramITopic = paramITopic.getData();
    } while (!(paramITopic instanceof Pair));
    paramITopic = (Pair)paramITopic;
    if (QLog.isColorLevel()) {
      QLog.i("SignatureHistoryFragment", 2, String.format("history onTopicClick [%d,%s]", new Object[] { paramITopic.first, paramITopic.second }));
    }
    TopicUtil.a(getActivity(), TopicUtil.a(((Integer)paramITopic.first).intValue(), (String)paramITopic.second), -1);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((ISignViewHolder)localIterator.next()).k();
    }
    getActivity().app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    getActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
    ((FontManager)getActivity().app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).b(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager$FontLoadCallback);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a(true, false);
    if ((getActivity() != null) && (getActivity().app != null)) {
      a(ThemeUtil.isInNightMode(getActivity().app));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      VasFaceManager.b();
      ETTextView.enableAnimation = true;
      c(false);
      return;
    }
    URLDrawable.pause();
    VasFaceManager.a();
    ETTextView.enableAnimation = false;
    c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment
 * JD-Core Version:    0.7.0.1
 */