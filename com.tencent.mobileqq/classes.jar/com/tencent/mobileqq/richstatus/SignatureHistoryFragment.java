package com.tencent.mobileqq.richstatus;

import actj;
import ajxl;
import ajya;
import akgo;
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
import avao;
import awdl;
import awdm;
import awdn;
import awdo;
import awdp;
import awdq;
import awdr;
import awds;
import awdt;
import awdu;
import awdv;
import awdw;
import awdx;
import awdy;
import awdz;
import awea;
import aweb;
import awei;
import awej;
import aweq;
import awev;
import awex;
import awey;
import awfp;
import awfq;
import awfr;
import awfu;
import awfv;
import awga;
import axlk;
import axmv;
import axqy;
import baxn;
import bbcz;
import bbdj;
import bbfj;
import bbgu;
import bblj;
import bbll;
import bcqf;
import bcql;
import bfni;
import bfos;
import bfpc;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import ho;
import hr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import muc;
import vzl;

public class SignatureHistoryFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, avao, awfr, awfv, bfos
{
  protected int a;
  protected akgo a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View.OnClickListener a;
  View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new awdu(this);
  public View.OnTouchListener a;
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aweb jdField_a_of_type_Aweb;
  protected aweq a;
  protected awev a;
  private bcqf jdField_a_of_type_Bcqf;
  private bfpc jdField_a_of_type_Bfpc;
  public SignatureHandler a;
  protected SignatureManager a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private CommentItem jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
  public XListView a;
  hr jdField_a_of_type_Hr = new awdo(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<awfq> jdField_a_of_type_JavaUtilHashSet = new HashSet();
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
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new awdm(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new awdn(this);
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private int a(List<awex> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      awex localawex = (awex)paramList.next();
      if ((localawex.a != null) && (paramString.equals(localawex.a.jdField_a_of_type_JavaLangString))) {
        return 1;
      }
    }
    return 0;
  }
  
  private static EmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new awdp(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.jdField_c_of_type_Boolean = true;
    paramView.jdField_f_of_type_Boolean = true;
    paramView.jdField_a_of_type_Boolean = false;
    paramView.jdField_b_of_type_Boolean = true;
    paramView.jdField_e_of_type_Boolean = true;
    paramView.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new awdq());
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131714145));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849333);
    if (paramInt == 3)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131714136));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131714141));
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
    bfpc localbfpc = bfpc.a(getActivity());
    localbfpc.a(2131692738, 3);
    localbfpc.c(2131690596);
    localbfpc.a(new awdt(this, paramCommentItem, paramString, localbfpc));
    localbfpc.show();
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
      localObject2 = (awex)((Iterator)localObject1).next();
    } while ((((awex)localObject2).a == null) || (!paramString2.equals(((awex)localObject2).a.jdField_a_of_type_JavaLangString)));
    ((Iterator)localObject1).remove();
    localHistorySignItem.totalLikeNum -= 1L;
    return;
    ((List)localObject1).add(0, new awex(NetConnInfoCenter.getServerTime() / 1000L, new awey(paramString2, a(paramString2))));
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
      bfni.b(paramView);
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
    str2 = getActivity().getString(2131691162) + ":";
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
    a(1, 2131719799);
    this.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837526);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690314));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new awds(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
    if (this.jdField_d_of_type_Int > axlk.jdField_b_of_type_Int / 4) {}
    for (int i = this.jdField_d_of_type_Int;; i = axlk.jdField_b_of_type_Int / 3)
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
      if ((localObject != null) && ((((View)localObject).getTag() instanceof awfp)))
      {
        localObject = (awfp)((View)localObject).getTag();
        ((awfp)localObject).b(paramBoolean);
        if (((awfp)localObject).a != null)
        {
          if (!paramBoolean) {
            break label110;
          }
          ((awfp)localObject).a.pauseAnimation();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((awfp)localObject).a.shouldStartAnimation = true;
        ((awfp)localObject).a.startAnimation(false, false);
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
      axqy.b(null, "dc00898", "", "", "0X800A98B", "0X800A98B", 0, 0, "0", "0", "", "");
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131692601);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aweb.notifyDataSetChanged();
      return;
      bool = false;
      break;
      label82:
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131719646);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(false);
      bfni.a(this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    bfni.b(this.jdField_a_of_type_AndroidWidgetEditText);
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
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130848814);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690313));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new awdr(this));
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
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getActivity().getResources().getColor(2131166819));
        this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131719640));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(null);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130846518);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getActivity().getResources().getColor(2131166818));
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getActivity().getResources().getString(2131719642), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(muc.a);
      }
    }
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131718774));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131167134));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839026);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public LinearLayout a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setOrientation(0);
    Object localObject = (CheckBox)LayoutInflater.from(getActivity()).inflate(2131561106, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = actj.a(16.0F, getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    int i = actj.a(10.0F, getResources());
    localObject = new LinearLayout.LayoutParams(bbll.a() - i * 2, -2);
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
      localFriends = ((ajxl)getActivity().app.getManager(51)).e(paramString);
    } while (localFriends == null);
    return localFriends.getFriendNickWithAlias();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((getActivity() != null) && (getActivity().isResume())) {
      bcql.a(getActivity(), paramInt1, getResources().getString(paramInt2), 0).b(getActivity().getTitleBarHeight());
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
    Object localObject2 = paramView.getTag(2131376206);
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
        if (paramView.getTag(2131376209) == null) {
          break label348;
        }
        j = ((Integer)paramView.getTag(2131376209)).intValue();
        i = j;
        if (j <= 1) {
          break label348;
        }
        i = 1;
        m = i;
        if (paramView.getTag(2131376207) != null)
        {
          int n = ((Integer)paramView.getTag(2131376207)).intValue();
          m = i;
          k = n;
          if (n > 0)
          {
            m = 1;
            k = n;
          }
        }
        if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
          break;
        }
        this.jdField_a_of_type_Bfpc = bfpc.a(getActivity());
        if (((Integer)localObject1).intValue() == 2)
        {
          this.jdField_a_of_type_Bfpc.a(2131691971, false);
          i = 1;
          this.jdField_a_of_type_Bfpc.c(2131690596);
          this.jdField_a_of_type_Bfpc.show();
          this.jdField_a_of_type_Bfpc.a(new awdz(this, i, j, k));
          this.jdField_a_of_type_Bfpc.a(new awea(this));
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
          this.jdField_a_of_type_Bfpc.a(2131691968, false);
          i = 3;
        }
        else
        {
          this.jdField_a_of_type_Bfpc.a(2131691970, false);
          i = 2;
        }
      }
      else
      {
        this.jdField_a_of_type_Bfpc.a(2131691966, false);
        i = 4;
        continue;
        label348:
        j = i;
        i = m;
      }
    }
  }
  
  public void a(View paramView, int paramInt, awfq paramawfq)
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
        axqy.b(null, "dc00898", "", "", "0X800A989", "0X800A989", 0, 0, "0", "0", "", "");
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131698759);
        d(true);
        paramInt = a(paramView);
        int i = paramView.getHeight();
        this.jdField_a_of_type_AndroidViewView = paramView;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SignatureHistoryFragment.9(this, paramInt, i), 200L);
        if ((paramawfq instanceof awfp))
        {
          paramView = ((awfp)paramawfq).b;
          if ((paramView != null) && (getActivity() != null) && (getActivity().app != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = new CommentItem();
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId = 0L;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId = paramView.feedsId;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.toReplyUser = null;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.user = new awey(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue()));
            return;
            if (paramInt != 4) {
              break;
            }
            if (!this.jdField_e_of_type_Boolean)
            {
              axqy.b(null, "dc00898", "", "", "0X800A988", "0X800A988", 0, 0, "0", "0", "", "");
              if (!bbfj.d(getActivity()))
              {
                bcql.a(getActivity(), 2131693314, 0).a();
                return;
              }
              if ((paramawfq instanceof awfp))
              {
                if (((awfp)paramawfq).f == 0) {
                  ((awfp)paramawfq).f = 1;
                }
                for (paramInt = 1;; paramInt = 0)
                {
                  if ((((awfp)paramawfq).b == null) || (TextUtils.isEmpty(((awfp)paramawfq).b.feedsId))) {
                    break label462;
                  }
                  a(((awfp)paramawfq).b.feedsId, this.jdField_b_of_type_JavaLangString, ((awfp)paramawfq).f);
                  if (this.jdField_a_of_type_Aweb != null) {
                    this.jdField_a_of_type_Aweb.notifyDataSetChanged();
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(this.jdField_a_of_type_JavaLangString, ((awfp)paramawfq).b.feedsId, 255, paramInt);
                  return;
                  ((awfp)paramawfq).f = 0;
                }
              }
            }
          }
        }
      }
    } while ((paramInt != 2) || (!(paramawfq instanceof awfp)) || (this.jdField_a_of_type_Bfpc != null));
    this.jdField_f_of_type_Boolean = true;
    a(((awfp)paramawfq).c());
  }
  
  public void a(awfu paramawfu, View paramView)
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick topic=", paramawfu });
      paramawfu = paramawfu.a();
    } while (!(paramawfu instanceof Pair));
    paramawfu = (Pair)paramawfu;
    if (QLog.isColorLevel()) {
      QLog.i("SignatureHistoryFragment", 2, String.format("history onTopicClick [%d,%s]", new Object[] { paramawfu.first, paramawfu.second }));
    }
    awga.a(getActivity(), awga.a(((Integer)paramawfu.first).intValue(), (String)paramawfu.second), -1);
  }
  
  public void a(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    View localView = localFragmentActivity.findViewById(2131370840);
    if (paramBoolean) {
      if (localView == null)
      {
        localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131370840);
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
    if (bbfj.d(getActivity()))
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
      if (this.jdField_a_of_type_Aweb == null) {
        break label84;
      }
      this.jdField_a_of_type_Aweb.notifyDataSetChanged();
      break label84;
    }
    startTitleProgress();
  }
  
  public boolean a(String paramString)
  {
    if ((getActivity() == null) || (getActivity().app == null)) {
      return false;
    }
    return ((ajxl)getActivity().app.getManager(51)).b(paramString);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    ((ho)getActivity().app.getManager(42)).a(this.jdField_a_of_type_Hr);
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
      axqy.b(getActivity().app, "dc00898", "", "", "0X800A987", "0X800A987", i, 0, "0", "0", "", "");
      this.leftView.setTextColor(getResources().getColor(2131165275));
      this.leftView.setBackgroundDrawable(getResources().getDrawable(2130839748));
      this.centerView.setTextColor(getResources().getColor(2131165275));
      paramLayoutInflater = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramLayoutInflater);
      i = paramLayoutInflater.widthPixels;
      int j = baxn.a(getActivity(), 69.0F);
      this.jdField_b_of_type_Int = Math.min(baxn.a(getActivity(), 260.0F), i - j);
      this.jdField_a_of_type_Int = ((this.jdField_b_of_type_Int - baxn.a(getActivity(), 70.0F)) / baxn.a(getActivity(), 28.0F));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)getActivity().app.getManager(58));
      this.jdField_a_of_type_Aweq = ((aweq)getActivity().app.getManager(15));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler = ((SignatureHandler)getActivity().app.a(41));
      this.jdField_a_of_type_Awev = new awej(this, null);
      getActivity().app.registObserver(this.jdField_a_of_type_Awev);
      this.jdField_a_of_type_Akgo = new awei(this, null);
      getActivity().app.addObserver(this.jdField_a_of_type_Akgo);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378351));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131719645);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378350));
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378349));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getText(2131690572));
      i = vzl.a(getActivity(), 3.0F);
      j = vzl.a(getActivity(), 10.0F);
      vzl.a(this.jdField_d_of_type_AndroidWidgetTextView, i, i, j, j);
      if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        break label1504;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131719646);
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562440, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131365666));
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131365654));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839144);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131376188));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView = this.mContentView.findViewById(2131376187);
      f(false);
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562441, null);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376185));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376186));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376195));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131364710));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_c_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_Aweb = new aweb(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aweb);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131377632);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new awdl(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131375432));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131365748));
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new awdv(this));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new awdw(this));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363649));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramLayoutInflater = this.jdField_b_of_type_AndroidWidgetButton;
      if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetButton.getText())) {
        break label1516;
      }
      bool = true;
      label1054:
      paramLayoutInflater.setEnabled(bool);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131365596));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131365624));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(muc.a);
      paramLayoutInflater = (SoftInputDetectView)this.mContentView.findViewById(2131368201);
      paramLayoutInflater.setExcludeStatusBar(false);
      paramLayoutInflater.setOnImStateChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(getActivity().app, getActivity(), this.mContentView, 2131365597, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      if (getTitleBarView() != null) {
        getTitleBarView().setVisibility(8);
      }
      if ((getActivity() != null) && (getActivity().getWindow() != null))
      {
        getActivity().getWindow().setSoftInputMode(16);
        getActivity().getWindow().setBackgroundDrawable(getResources().getDrawable(2130846522));
        if (ImmersiveUtils.isSupporImmersive() != 0)
        {
          paramLayoutInflater = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
          paramLayoutInflater.init();
          if (!ImmersiveUtils.c()) {
            break label1522;
          }
          ImmersiveUtils.a(true, getActivity().getWindow());
          paramLayoutInflater.setStatusBarColor(getResources().getColor(2131167087));
        }
      }
      label1303:
      a();
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.equals(""))) {
        this.jdField_c_of_type_JavaLangString = bbcz.j(getActivity().app, this.jdField_a_of_type_JavaLangString);
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
      axqy.b(null, "dc00898", "", "", "0X800A4ED", "0X800A4ED", i, 0, "" + i, "0", "", "");
      VasWebviewUtil.reportCommercialDrainage("signature_history", "pv", "", 0, 0, 0, "", "", "" + i, "", "", "", "", 0, 0, 0, 0);
      return;
      i = 2;
      break;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      break label621;
      bool = false;
      break label1054;
      paramLayoutInflater.setStatusBarColor(axmv.jdField_a_of_type_Int);
      break label1303;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562444;
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
        a(1, 2131719799);
        return true;
        this.jdField_a_of_type_Aweb.notifyDataSetChanged();
        return true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
        return true;
      } while (!isAdded());
      if (paramMessage.arg1 >= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131719644), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return true;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
      if (paramMessage.arg1 == 1)
      {
        a(1, 2131704398);
        return true;
      }
    } while (paramMessage.arg1 != 2);
    a(1, 2131696673);
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
  
  public void onClick(View arg1)
  {
    switch (???.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              do
              {
                return;
                onBackEvent();
                return;
                d();
                return;
                if (this.jdField_e_of_type_Boolean)
                {
                  synchronized (this.jdField_a_of_type_JavaUtilArrayList)
                  {
                    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
                      return;
                    }
                  }
                  if (!bbfj.d(getActivity()))
                  {
                    bcql.a(getActivity(), getString(2131692321), 0).a();
                    return;
                  }
                  axqy.b(null, "dc00898", "", "", "0X800A98C", "0X800A98C", 0, 0, "0", "0", "", "");
                  bbdj.a(getActivity(), 230).setTitle(getString(2131719641)).setPositiveButton(getString(2131690708), new awdy(this)).setNegativeButton(getString(2131690596), new awdx(this)).show();
                  return;
                }
                VasWebviewUtil.reportCommercialDrainage("signature_history", "edit_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                bblj.a(getActivity(), getActivity().app, 0, "signature_history");
                return;
              } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
              str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
            } while (TextUtils.isEmpty(str));
            if (!bbfj.d(getActivity()))
            {
              bcql.a(getActivity(), getString(2131692321), 0).a();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem == null);
          this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content = str;
          if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null)
          {
            if (this.jdField_a_of_type_Bcqf == null) {
              this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
            }
            this.jdField_a_of_type_Bcqf.a(null);
            this.jdField_a_of_type_Bcqf.show();
            this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
          }
          a(???, true);
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem == null) || (getActivity() == null));
        ((ClipboardManager)getActivity().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = null;
        return;
        if (!bbfj.d(getActivity()))
        {
          bcql.a(getActivity(), 2131693314, 0).a();
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)));
      if (this.jdField_a_of_type_Bcqf == null) {
        this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Bcqf.a(null);
      this.jdField_a_of_type_Bcqf.show();
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.id);
      return;
      a(???);
      return;
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_e_of_type_Boolean));
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((awfq)localIterator.next()).k();
    }
    getActivity().app.unRegistObserver(this.jdField_a_of_type_Awev);
    getActivity().app.removeObserver(this.jdField_a_of_type_Akgo);
    ((ho)getActivity().app.getManager(42)).b(this.jdField_a_of_type_Hr);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment
 * JD-Core Version:    0.7.0.1
 */