package com.tencent.mobileqq.richstatus;

import agej;
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
import anyw;
import anzj;
import aoho;
import bacp;
import bbty;
import bbtz;
import bbua;
import bbub;
import bbuc;
import bbud;
import bbue;
import bbuf;
import bbug;
import bbuh;
import bbui;
import bbuj;
import bbuk;
import bbul;
import bbum;
import bbun;
import bbuo;
import bbuv;
import bbuw;
import bbvd;
import bbvi;
import bbvk;
import bbvl;
import bbwc;
import bbwd;
import bbwe;
import bbwh;
import bbwi;
import bbwn;
import bdep;
import bdgb;
import bdll;
import bhgr;
import bhlg;
import bhlq;
import bhnv;
import bhpc;
import bhto;
import bhtq;
import bjbs;
import blgx;
import blih;
import blir;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import gc;
import gf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mvd;
import zps;

public class SignatureHistoryFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, bacp, bbwe, bbwi, blih
{
  protected int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View.OnClickListener a;
  View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new bbuh(this);
  public View.OnTouchListener a;
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected aoho a;
  private bbuo jdField_a_of_type_Bbuo;
  protected bbvd a;
  protected bbvi a;
  private bjbs jdField_a_of_type_Bjbs;
  private blir jdField_a_of_type_Blir;
  public SignatureHandler a;
  protected SignatureManager a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private CommentItem jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
  public XListView a;
  gf jdField_a_of_type_Gf = new bbub(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<bbwd> jdField_a_of_type_JavaUtilHashSet = new HashSet();
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
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  
  public SignatureHistoryFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new bbtz(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bbua(this);
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private int a(List<bbvk> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bbvk localbbvk = (bbvk)paramList.next();
      if ((localbbvk.a != null) && (paramString.equals(localbbvk.a.jdField_a_of_type_JavaLangString))) {
        return 1;
      }
    }
    return 0;
  }
  
  private static EmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new bbuc(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.jdField_c_of_type_Boolean = true;
    paramView.jdField_f_of_type_Boolean = true;
    paramView.jdField_a_of_type_Boolean = false;
    paramView.jdField_b_of_type_Boolean = true;
    paramView.jdField_e_of_type_Boolean = true;
    paramView.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new bbud());
    paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOverScrollMode(2);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131713008));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850440);
    if (paramInt == 3)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131712999));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131713004));
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
    blir localblir = blir.a(getActivity());
    localblir.a(2131692390, 3);
    localblir.c(2131690580);
    localblir.a(new bbug(this, paramCommentItem, paramString, localblir));
    localblir.show();
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
      localObject2 = (bbvk)((Iterator)localObject1).next();
    } while ((((bbvk)localObject2).a == null) || (!paramString2.equals(((bbvk)localObject2).a.jdField_a_of_type_JavaLangString)));
    ((Iterator)localObject1).remove();
    localHistorySignItem.totalLikeNum -= 1L;
    return;
    ((List)localObject1).add(0, new bbvk(NetConnInfoCenter.getServerTime() / 1000L, new bbvl(paramString2, a(paramString2))));
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
      blgx.b(paramView);
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
    str2 = getActivity().getString(2131691020) + ":";
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
    a(1, 2131718362);
    this.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837535);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690198));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new bbuf(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
    if (this.jdField_d_of_type_Int > bdep.jdField_b_of_type_Int / 4) {}
    for (int i = this.jdField_d_of_type_Int;; i = bdep.jdField_b_of_type_Int / 3)
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
      if ((localObject != null) && ((((View)localObject).getTag() instanceof bbwc)))
      {
        localObject = (bbwc)((View)localObject).getTag();
        ((bbwc)localObject).b(paramBoolean);
        if (((bbwc)localObject).a != null)
        {
          if (!paramBoolean) {
            break label110;
          }
          ((bbwc)localObject).a.pauseAnimation();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((bbwc)localObject).a.shouldStartAnimation = true;
        ((bbwc)localObject).a.startAnimation(false, false);
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
      bdll.b(null, "dc00898", "", "", "0X800A98B", "0X800A98B", 0, 0, "0", "0", "", "");
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131692262);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbuo.notifyDataSetChanged();
      return;
      bool = false;
      break;
      label82:
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131718270);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(false);
      blgx.a(this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    blgx.b(this.jdField_a_of_type_AndroidWidgetEditText);
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
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849880);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690197));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new bbue(this));
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
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getActivity().getResources().getColor(2131166954));
        this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131718265));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(null);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130847446);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getActivity().getResources().getColor(2131166953));
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getActivity().getResources().getString(2131718267), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mvd.a);
      }
    }
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131717465));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131167302));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839291);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public LinearLayout a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setOrientation(0);
    Object localObject = (CheckBox)LayoutInflater.from(getActivity()).inflate(2131561582, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = agej.a(16.0F, getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    int i = agej.a(10.0F, getResources());
    localObject = new LinearLayout.LayoutParams(bhtq.a() - i * 2, -2);
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
      localFriends = ((anyw)getActivity().app.getManager(51)).e(paramString);
    } while (localFriends == null);
    return localFriends.getFriendNickWithAlias();
  }
  
  public void a(int paramInt1, int paramInt2)
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
    Object localObject2 = paramView.getTag(2131377722);
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
        if (paramView.getTag(2131377730) == null) {
          break label348;
        }
        j = ((Integer)paramView.getTag(2131377730)).intValue();
        i = j;
        if (j <= 1) {
          break label348;
        }
        i = 1;
        m = i;
        if (paramView.getTag(2131377723) != null)
        {
          int n = ((Integer)paramView.getTag(2131377723)).intValue();
          m = i;
          k = n;
          if (n > 0)
          {
            m = 1;
            k = n;
          }
        }
        if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
          break;
        }
        this.jdField_a_of_type_Blir = blir.a(getActivity());
        if (((Integer)localObject1).intValue() == 2)
        {
          this.jdField_a_of_type_Blir.a(2131691688, false);
          i = 1;
          this.jdField_a_of_type_Blir.c(2131690580);
          this.jdField_a_of_type_Blir.show();
          this.jdField_a_of_type_Blir.a(new bbum(this, i, j, k));
          this.jdField_a_of_type_Blir.a(new bbun(this));
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
          this.jdField_a_of_type_Blir.a(2131691685, false);
          i = 3;
        }
        else
        {
          this.jdField_a_of_type_Blir.a(2131691687, false);
          i = 2;
        }
      }
      else
      {
        this.jdField_a_of_type_Blir.a(2131691684, false);
        i = 4;
        continue;
        label348:
        j = i;
        i = m;
      }
    }
  }
  
  public void a(View paramView, int paramInt, bbwd parambbwd)
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
        bdll.b(null, "dc00898", "", "", "0X800A989", "0X800A989", 0, 0, "0", "0", "", "");
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131697945);
        d(true);
        paramInt = a(paramView);
        int i = paramView.getHeight();
        this.jdField_a_of_type_AndroidViewView = paramView;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SignatureHistoryFragment.9(this, paramInt, i), 200L);
        if ((parambbwd instanceof bbwc))
        {
          paramView = ((bbwc)parambbwd).b;
          if ((paramView != null) && (getActivity() != null) && (getActivity().app != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = new CommentItem();
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId = 0L;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId = paramView.feedsId;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.toReplyUser = null;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.user = new bbvl(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue()));
            return;
            if (paramInt != 4) {
              break;
            }
            if (!this.jdField_e_of_type_Boolean)
            {
              bdll.b(null, "dc00898", "", "", "0X800A988", "0X800A988", 0, 0, "0", "0", "", "");
              if (!bhnv.d(getActivity()))
              {
                QQToast.a(getActivity(), 2131692905, 0).a();
                return;
              }
              if ((parambbwd instanceof bbwc))
              {
                if (((bbwc)parambbwd).f == 0) {
                  ((bbwc)parambbwd).f = 1;
                }
                for (paramInt = 1;; paramInt = 0)
                {
                  if ((((bbwc)parambbwd).b == null) || (TextUtils.isEmpty(((bbwc)parambbwd).b.feedsId))) {
                    break label462;
                  }
                  a(((bbwc)parambbwd).b.feedsId, this.jdField_b_of_type_JavaLangString, ((bbwc)parambbwd).f);
                  if (this.jdField_a_of_type_Bbuo != null) {
                    this.jdField_a_of_type_Bbuo.notifyDataSetChanged();
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(this.jdField_a_of_type_JavaLangString, ((bbwc)parambbwd).b.feedsId, 255, paramInt);
                  return;
                  ((bbwc)parambbwd).f = 0;
                }
              }
            }
          }
        }
      }
    } while ((paramInt != 2) || (!(parambbwd instanceof bbwc)) || (this.jdField_a_of_type_Blir != null));
    this.jdField_f_of_type_Boolean = true;
    a(((bbwc)parambbwd).c());
  }
  
  public void a(bbwh parambbwh, View paramView)
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick topic=", parambbwh });
      parambbwh = parambbwh.a();
    } while (!(parambbwh instanceof Pair));
    parambbwh = (Pair)parambbwh;
    if (QLog.isColorLevel()) {
      QLog.i("SignatureHistoryFragment", 2, String.format("history onTopicClick [%d,%s]", new Object[] { parambbwh.first, parambbwh.second }));
    }
    bbwn.a(getActivity(), bbwn.a(((Integer)parambbwh.first).intValue(), (String)parambbwh.second), -1);
  }
  
  public void a(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    View localView = localFragmentActivity.findViewById(2131371835);
    if (paramBoolean) {
      if (localView == null)
      {
        localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131371835);
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("SignatureHistoryFragment", 2, "updateData: refresh=" + paramBoolean1 + " user=" + paramBoolean2);
    long l;
    if (bhnv.d(getActivity()))
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
      if (this.jdField_a_of_type_Bbuo == null) {
        break label84;
      }
      this.jdField_a_of_type_Bbuo.notifyDataSetChanged();
      break label84;
    }
    startTitleProgress();
  }
  
  public boolean a(String paramString)
  {
    if ((getActivity() == null) || (getActivity().app == null)) {
      return false;
    }
    return ((anyw)getActivity().app.getManager(51)).b(paramString);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    ((gc)getActivity().app.getManager(42)).a(this.jdField_a_of_type_Gf);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaLangString = getActivity().getIntent().getStringExtra("key_uin_name");
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("key_uin");
    this.jdField_b_of_type_JavaLangString = getActivity().app.c();
    paramLayoutInflater = getActivity().getIntent().getStringExtra("key_open_via");
    VasWebviewUtil.reportCommercialDrainage(getActivity().app.c(), "signature", "signature_8", paramLayoutInflater, 1, 0, 0, "", "", "");
    label621:
    boolean bool;
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      i = 1;
      bdll.b(getActivity().app, "dc00898", "", "", "0X800A987", "0X800A987", i, 0, "0", "0", "", "");
      this.leftView.setTextColor(getResources().getColor(2131165343));
      this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840286));
      this.centerView.setTextColor(getResources().getColor(2131165343));
      paramLayoutInflater = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramLayoutInflater);
      i = paramLayoutInflater.widthPixels;
      int j = bhgr.a(getActivity(), 69.0F);
      this.jdField_b_of_type_Int = Math.min(bhgr.a(getActivity(), 260.0F), i - j);
      this.jdField_a_of_type_Int = ((this.jdField_b_of_type_Int - bhgr.a(getActivity(), 70.0F)) / bhgr.a(getActivity(), 28.0F));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)getActivity().app.getManager(58));
      this.jdField_a_of_type_Bbvd = ((bbvd)getActivity().app.getManager(15));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler = ((SignatureHandler)getActivity().app.a(41));
      this.jdField_a_of_type_Bbvi = new bbuw(this, null);
      getActivity().app.registObserver(this.jdField_a_of_type_Bbvi);
      this.jdField_a_of_type_Aoho = new bbuv(this, null);
      getActivity().app.addObserver(this.jdField_a_of_type_Aoho);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380088));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131718269);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380087));
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380086));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getText(2131690559));
      i = zps.a(getActivity(), 3.0F);
      j = zps.a(getActivity(), 10.0F);
      zps.a(this.jdField_d_of_type_AndroidWidgetTextView, i, i, j, j);
      if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        break label1504;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131718270);
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562935, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366039));
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366028));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839414);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131377704));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView = this.mContentView.findViewById(2131377703);
      f(false);
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562936, null);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377701));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377702));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377711));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131365065));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_c_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_Bbuo = new bbuo(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bbuo);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131379246);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new bbty(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131376852));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131366133));
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new bbui(this));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bbuj(this));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363931));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramLayoutInflater = this.jdField_b_of_type_AndroidWidgetButton;
      if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetButton.getText())) {
        break label1516;
      }
      bool = true;
      label1054:
      paramLayoutInflater.setEnabled(bool);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131365963));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131365991));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(mvd.a);
      paramLayoutInflater = (SoftInputDetectView)this.mContentView.findViewById(2131368740);
      paramLayoutInflater.setExcludeStatusBar(false);
      paramLayoutInflater.setOnImStateChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(getActivity().app, getActivity(), this.mContentView, 2131365964, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      if (getTitleBarView() != null) {
        getTitleBarView().setVisibility(8);
      }
      if ((getActivity() != null) && (getActivity().getWindow() != null))
      {
        getActivity().getWindow().setSoftInputMode(16);
        getActivity().getWindow().setBackgroundDrawable(getResources().getDrawable(2130847450));
        if (ImmersiveUtils.isSupporImmersive() != 0)
        {
          paramLayoutInflater = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
          paramLayoutInflater.init();
          if (!ImmersiveUtils.c()) {
            break label1522;
          }
          ImmersiveUtils.a(true, getActivity().getWindow());
          paramLayoutInflater.setStatusBarColor(getResources().getColor(2131167247));
        }
      }
      label1303:
      a();
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.equals(""))) {
        this.jdField_c_of_type_JavaLangString = bhlg.j(getActivity().app, this.jdField_a_of_type_JavaLangString);
      }
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      }
      if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        break label1532;
      }
    }
    label1504:
    label1516:
    label1522:
    label1532:
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A4ED", "0X800A4ED", i, 0, "" + i, "0", "", "");
      VasWebviewUtil.reportCommercialDrainage("signature_history", "pv", "", 0, 0, 0, "", "", "" + i, "", "", "", "", 0, 0, 0, 0);
      return;
      i = 2;
      break;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      break label621;
      bool = false;
      break label1054;
      paramLayoutInflater.setStatusBarColor(bdgb.jdField_a_of_type_Int);
      break label1303;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562939;
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
        a(1, 2131718362);
        return true;
        this.jdField_a_of_type_Bbuo.notifyDataSetChanged();
        return true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
        return true;
      } while (!isAdded());
      if (paramMessage.arg1 >= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131718268), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return true;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
      if (paramMessage.arg1 == 1)
      {
        a(1, 2131703286);
        return true;
      }
    } while (paramMessage.arg1 != 2);
    a(1, 2131695715);
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
      getActivity().overridePendingTransition(2130771988, 2130771989);
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
        if (!bhnv.d(getActivity()))
        {
          QQToast.a(getActivity(), getString(2131691989), 0).a();
        }
        else
        {
          bdll.b(null, "dc00898", "", "", "0X800A98C", "0X800A98C", 0, 0, "0", "0", "", "");
          bhlq.a(getActivity(), 230).setTitle(getString(2131718266)).setPositiveButton(getString(2131690639), new bbul(this)).setNegativeButton(getString(2131690580), new bbuk(this)).show();
        }
      }
      else
      {
        VasWebviewUtil.reportCommercialDrainage("signature_history", "edit_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        bhto.a(getActivity(), getActivity().app, 0, "signature_history");
        continue;
        if (this.jdField_a_of_type_AndroidWidgetEditText != null)
        {
          ??? = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (!TextUtils.isEmpty((CharSequence)???)) {
            if (!bhnv.d(getActivity()))
            {
              QQToast.a(getActivity(), getString(2131691989), 0).a();
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content = ((String)???);
              if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null)
              {
                if (this.jdField_a_of_type_Bjbs == null) {
                  this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
                }
                this.jdField_a_of_type_Bjbs.a(null);
                this.jdField_a_of_type_Bjbs.show();
                this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
              }
              a(paramView, true);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (getActivity() != null))
              {
                ((ClipboardManager)getActivity().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
                this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = null;
                continue;
                if (!bhnv.d(getActivity()))
                {
                  QQToast.a(getActivity(), 2131692905, 0).a();
                }
                else if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
                {
                  if (this.jdField_a_of_type_Bjbs == null) {
                    this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
                  }
                  this.jdField_a_of_type_Bjbs.a(null);
                  this.jdField_a_of_type_Bjbs.show();
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
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((bbwd)localIterator.next()).k();
    }
    getActivity().app.unRegistObserver(this.jdField_a_of_type_Bbvi);
    getActivity().app.removeObserver(this.jdField_a_of_type_Aoho);
    ((gc)getActivity().app.getManager(42)).b(this.jdField_a_of_type_Gf);
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