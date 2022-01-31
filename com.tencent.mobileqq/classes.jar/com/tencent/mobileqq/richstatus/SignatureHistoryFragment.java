package com.tencent.mobileqq.richstatus;

import aepi;
import alto;
import alud;
import amct;
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
import awwk;
import aycx;
import aycy;
import aycz;
import ayda;
import aydb;
import aydc;
import aydd;
import ayde;
import aydf;
import aydg;
import aydh;
import aydi;
import aydj;
import aydk;
import aydl;
import aydm;
import aydn;
import aydu;
import aydv;
import ayec;
import ayeh;
import ayej;
import ayek;
import ayfb;
import ayfc;
import ayfd;
import ayfg;
import ayfh;
import ayfm;
import azkz;
import azmk;
import azqs;
import bdaq;
import bdgc;
import bdgm;
import bdin;
import bdjz;
import bdom;
import bdoo;
import bety;
import bhsj;
import bhtv;
import bhuf;
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
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import fx;
import ga;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mww;
import xsm;

public class SignatureHistoryFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, awwk, ayfd, ayfh, bhtv
{
  protected int a;
  protected amct a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View.OnClickListener a;
  View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new aydg(this);
  public View.OnTouchListener a;
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aydn jdField_a_of_type_Aydn;
  protected ayec a;
  protected ayeh a;
  private bety jdField_a_of_type_Bety;
  private bhuf jdField_a_of_type_Bhuf;
  public SignatureHandler a;
  protected SignatureManager a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private CommentItem jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
  public XListView a;
  ga jdField_a_of_type_Ga = new ayda(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<ayfc> jdField_a_of_type_JavaUtilHashSet = new HashSet();
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
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new aycy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aycz(this);
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private int a(List<ayej> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ayej localayej = (ayej)paramList.next();
      if ((localayej.a != null) && (paramString.equals(localayej.a.jdField_a_of_type_JavaLangString))) {
        return 1;
      }
    }
    return 0;
  }
  
  private static EmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new aydb(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.jdField_c_of_type_Boolean = true;
    paramView.jdField_f_of_type_Boolean = true;
    paramView.jdField_a_of_type_Boolean = false;
    paramView.jdField_b_of_type_Boolean = true;
    paramView.jdField_e_of_type_Boolean = true;
    paramView.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new aydc());
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131714529));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849839);
    if (paramInt == 3)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131714520));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131714525));
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
    bhuf localbhuf = bhuf.a(getActivity());
    localbhuf.a(2131692822, 3);
    localbhuf.c(2131690648);
    localbhuf.a(new aydf(this, paramCommentItem, paramString, localbhuf));
    localbhuf.show();
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
      localObject2 = (ayej)((Iterator)localObject1).next();
    } while ((((ayej)localObject2).a == null) || (!paramString2.equals(((ayej)localObject2).a.jdField_a_of_type_JavaLangString)));
    ((Iterator)localObject1).remove();
    localHistorySignItem.totalLikeNum -= 1L;
    return;
    ((List)localObject1).add(0, new ayej(NetConnInfoCenter.getServerTime() / 1000L, new ayek(paramString2, a(paramString2))));
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
      bhsj.b(paramView);
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
    str2 = getActivity().getString(2131691216) + ":";
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
    a(1, 2131720337);
    this.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837526);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690365));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ayde(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
    if (this.jdField_d_of_type_Int > azkz.jdField_b_of_type_Int / 4) {}
    for (int i = this.jdField_d_of_type_Int;; i = azkz.jdField_b_of_type_Int / 3)
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
      if ((localObject != null) && ((((View)localObject).getTag() instanceof ayfb)))
      {
        localObject = (ayfb)((View)localObject).getTag();
        ((ayfb)localObject).b(paramBoolean);
        if (((ayfb)localObject).a != null)
        {
          if (!paramBoolean) {
            break label110;
          }
          ((ayfb)localObject).a.pauseAnimation();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((ayfb)localObject).a.shouldStartAnimation = true;
        ((ayfb)localObject).a.startAnimation(false, false);
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
      azqs.b(null, "dc00898", "", "", "0X800A98B", "0X800A98B", 0, 0, "0", "0", "", "");
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131692682);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aydn.notifyDataSetChanged();
      return;
      bool = false;
      break;
      label82:
      f(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131720190);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(false);
      bhsj.a(this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    bhsj.b(this.jdField_a_of_type_AndroidWidgetEditText);
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
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849318);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690364));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new aydd(this));
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
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getActivity().getResources().getColor(2131166868));
        this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131720184));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(null);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130846972);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getActivity().getResources().getColor(2131166867));
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getActivity().getResources().getString(2131720186), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mww.a);
      }
    }
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131719259));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131167194));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839108);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public LinearLayout a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setOrientation(0);
    Object localObject = (CheckBox)LayoutInflater.from(getActivity()).inflate(2131561311, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = aepi.a(16.0F, getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    int i = aepi.a(10.0F, getResources());
    localObject = new LinearLayout.LayoutParams(bdoo.a() - i * 2, -2);
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
      localFriends = ((alto)getActivity().app.getManager(51)).e(paramString);
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
    Object localObject2 = paramView.getTag(2131376762);
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
        if (paramView.getTag(2131376765) == null) {
          break label348;
        }
        j = ((Integer)paramView.getTag(2131376765)).intValue();
        i = j;
        if (j <= 1) {
          break label348;
        }
        i = 1;
        m = i;
        if (paramView.getTag(2131376763) != null)
        {
          int n = ((Integer)paramView.getTag(2131376763)).intValue();
          m = i;
          k = n;
          if (n > 0)
          {
            m = 1;
            k = n;
          }
        }
        if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
          break;
        }
        this.jdField_a_of_type_Bhuf = bhuf.a(getActivity());
        if (((Integer)localObject1).intValue() == 2)
        {
          this.jdField_a_of_type_Bhuf.a(2131692027, false);
          i = 1;
          this.jdField_a_of_type_Bhuf.c(2131690648);
          this.jdField_a_of_type_Bhuf.show();
          this.jdField_a_of_type_Bhuf.a(new aydl(this, i, j, k));
          this.jdField_a_of_type_Bhuf.a(new aydm(this));
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
          this.jdField_a_of_type_Bhuf.a(2131692024, false);
          i = 3;
        }
        else
        {
          this.jdField_a_of_type_Bhuf.a(2131692026, false);
          i = 2;
        }
      }
      else
      {
        this.jdField_a_of_type_Bhuf.a(2131692022, false);
        i = 4;
        continue;
        label348:
        j = i;
        i = m;
      }
    }
  }
  
  public void a(View paramView, int paramInt, ayfc paramayfc)
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
        azqs.b(null, "dc00898", "", "", "0X800A989", "0X800A989", 0, 0, "0", "0", "", "");
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131699069);
        d(true);
        paramInt = a(paramView);
        int i = paramView.getHeight();
        this.jdField_a_of_type_AndroidViewView = paramView;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SignatureHistoryFragment.9(this, paramInt, i), 200L);
        if ((paramayfc instanceof ayfb))
        {
          paramView = ((ayfb)paramayfc).b;
          if ((paramView != null) && (getActivity() != null) && (getActivity().app != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = new CommentItem();
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId = 0L;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId = paramView.feedsId;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.toReplyUser = null;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.user = new ayek(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue()));
            return;
            if (paramInt != 4) {
              break;
            }
            if (!this.jdField_e_of_type_Boolean)
            {
              azqs.b(null, "dc00898", "", "", "0X800A988", "0X800A988", 0, 0, "0", "0", "", "");
              if (!bdin.d(getActivity()))
              {
                QQToast.a(getActivity(), 2131693417, 0).a();
                return;
              }
              if ((paramayfc instanceof ayfb))
              {
                if (((ayfb)paramayfc).f == 0) {
                  ((ayfb)paramayfc).f = 1;
                }
                for (paramInt = 1;; paramInt = 0)
                {
                  if ((((ayfb)paramayfc).b == null) || (TextUtils.isEmpty(((ayfb)paramayfc).b.feedsId))) {
                    break label462;
                  }
                  a(((ayfb)paramayfc).b.feedsId, this.jdField_b_of_type_JavaLangString, ((ayfb)paramayfc).f);
                  if (this.jdField_a_of_type_Aydn != null) {
                    this.jdField_a_of_type_Aydn.notifyDataSetChanged();
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(this.jdField_a_of_type_JavaLangString, ((ayfb)paramayfc).b.feedsId, 255, paramInt);
                  return;
                  ((ayfb)paramayfc).f = 0;
                }
              }
            }
          }
        }
      }
    } while ((paramInt != 2) || (!(paramayfc instanceof ayfb)) || (this.jdField_a_of_type_Bhuf != null));
    this.jdField_f_of_type_Boolean = true;
    a(((ayfb)paramayfc).c());
  }
  
  public void a(ayfg paramayfg, View paramView)
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick topic=", paramayfg });
      paramayfg = paramayfg.a();
    } while (!(paramayfg instanceof Pair));
    paramayfg = (Pair)paramayfg;
    if (QLog.isColorLevel()) {
      QLog.i("SignatureHistoryFragment", 2, String.format("history onTopicClick [%d,%s]", new Object[] { paramayfg.first, paramayfg.second }));
    }
    ayfm.a(getActivity(), ayfm.a(((Integer)paramayfg.first).intValue(), (String)paramayfg.second), -1);
  }
  
  public void a(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    View localView = localFragmentActivity.findViewById(2131371169);
    if (paramBoolean) {
      if (localView == null)
      {
        localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131371169);
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
    if (bdin.d(getActivity()))
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
      if (this.jdField_a_of_type_Aydn == null) {
        break label84;
      }
      this.jdField_a_of_type_Aydn.notifyDataSetChanged();
      break label84;
    }
    startTitleProgress();
  }
  
  public boolean a(String paramString)
  {
    if ((getActivity() == null) || (getActivity().app == null)) {
      return false;
    }
    return ((alto)getActivity().app.getManager(51)).b(paramString);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    ((fx)getActivity().app.getManager(42)).a(this.jdField_a_of_type_Ga);
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
      azqs.b(getActivity().app, "dc00898", "", "", "0X800A987", "0X800A987", i, 0, "0", "0", "", "");
      this.leftView.setTextColor(getResources().getColor(2131165307));
      this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840097));
      this.centerView.setTextColor(getResources().getColor(2131165307));
      paramLayoutInflater = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramLayoutInflater);
      i = paramLayoutInflater.widthPixels;
      int j = bdaq.a(getActivity(), 69.0F);
      this.jdField_b_of_type_Int = Math.min(bdaq.a(getActivity(), 260.0F), i - j);
      this.jdField_a_of_type_Int = ((this.jdField_b_of_type_Int - bdaq.a(getActivity(), 70.0F)) / bdaq.a(getActivity(), 28.0F));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)getActivity().app.getManager(58));
      this.jdField_a_of_type_Ayec = ((ayec)getActivity().app.getManager(15));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler = ((SignatureHandler)getActivity().app.a(41));
      this.jdField_a_of_type_Ayeh = new aydv(this, null);
      getActivity().app.registObserver(this.jdField_a_of_type_Ayeh);
      this.jdField_a_of_type_Amct = new aydu(this, null);
      getActivity().app.addObserver(this.jdField_a_of_type_Amct);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379003));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131720189);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379002));
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379001));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getText(2131690623));
      i = xsm.a(getActivity(), 3.0F);
      j = xsm.a(getActivity(), 10.0F);
      xsm.a(this.jdField_d_of_type_AndroidWidgetTextView, i, i, j, j);
      if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        break label1504;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131720190);
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562662, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131365752));
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131365740));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839229);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131376744));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView = this.mContentView.findViewById(2131376743);
      f(false);
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562663, null);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376741));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376742));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376751));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131364790));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_c_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_Aydn = new aydn(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aydn);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131378228);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new aycx(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131375972));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131365836));
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new aydh(this));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aydi(this));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363704));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramLayoutInflater = this.jdField_b_of_type_AndroidWidgetButton;
      if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetButton.getText())) {
        break label1516;
      }
      bool = true;
      label1054:
      paramLayoutInflater.setEnabled(bool);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131365681));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131365709));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
      paramLayoutInflater = (SoftInputDetectView)this.mContentView.findViewById(2131368358);
      paramLayoutInflater.setExcludeStatusBar(false);
      paramLayoutInflater.setOnImStateChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(getActivity().app, getActivity(), this.mContentView, 2131365682, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      if (getTitleBarView() != null) {
        getTitleBarView().setVisibility(8);
      }
      if ((getActivity() != null) && (getActivity().getWindow() != null))
      {
        getActivity().getWindow().setSoftInputMode(16);
        getActivity().getWindow().setBackgroundDrawable(getResources().getDrawable(2130846976));
        if (ImmersiveUtils.isSupporImmersive() != 0)
        {
          paramLayoutInflater = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
          paramLayoutInflater.init();
          if (!ImmersiveUtils.c()) {
            break label1522;
          }
          ImmersiveUtils.a(true, getActivity().getWindow());
          paramLayoutInflater.setStatusBarColor(getResources().getColor(2131167140));
        }
      }
      label1303:
      a();
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.equals(""))) {
        this.jdField_c_of_type_JavaLangString = bdgc.j(getActivity().app, this.jdField_a_of_type_JavaLangString);
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
      azqs.b(null, "dc00898", "", "", "0X800A4ED", "0X800A4ED", i, 0, "" + i, "0", "", "");
      VasWebviewUtil.reportCommercialDrainage("signature_history", "pv", "", 0, 0, 0, "", "", "" + i, "", "", "", "", 0, 0, 0, 0);
      return;
      i = 2;
      break;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      break label621;
      bool = false;
      break label1054;
      paramLayoutInflater.setStatusBarColor(azmk.jdField_a_of_type_Int);
      break label1303;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562666;
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
        a(1, 2131720337);
        return true;
        this.jdField_a_of_type_Aydn.notifyDataSetChanged();
        return true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
        return true;
      } while (!isAdded());
      if (paramMessage.arg1 >= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131720188), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return true;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
      if (paramMessage.arg1 == 1)
      {
        a(1, 2131704782);
        return true;
      }
    } while (paramMessage.arg1 != 2);
    a(1, 2131696850);
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
                  if (!bdin.d(getActivity()))
                  {
                    QQToast.a(getActivity(), getString(2131692398), 0).a();
                    return;
                  }
                  azqs.b(null, "dc00898", "", "", "0X800A98C", "0X800A98C", 0, 0, "0", "0", "", "");
                  bdgm.a(getActivity(), 230).setTitle(getString(2131720185)).setPositiveButton(getString(2131690760), new aydk(this)).setNegativeButton(getString(2131690648), new aydj(this)).show();
                  return;
                }
                VasWebviewUtil.reportCommercialDrainage("signature_history", "edit_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                bdom.a(getActivity(), getActivity().app, 0, "signature_history");
                return;
              } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
              str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
            } while (TextUtils.isEmpty(str));
            if (!bdin.d(getActivity()))
            {
              QQToast.a(getActivity(), getString(2131692398), 0).a();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem == null);
          this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content = str;
          if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null)
          {
            if (this.jdField_a_of_type_Bety == null) {
              this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
            }
            this.jdField_a_of_type_Bety.a(null);
            this.jdField_a_of_type_Bety.show();
            this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
          }
          a(???, true);
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem == null) || (getActivity() == null));
        ((ClipboardManager)getActivity().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = null;
        return;
        if (!bdin.d(getActivity()))
        {
          QQToast.a(getActivity(), 2131693417, 0).a();
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)));
      if (this.jdField_a_of_type_Bety == null) {
        this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Bety.a(null);
      this.jdField_a_of_type_Bety.show();
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
      ((ayfc)localIterator.next()).k();
    }
    getActivity().app.unRegistObserver(this.jdField_a_of_type_Ayeh);
    getActivity().app.removeObserver(this.jdField_a_of_type_Amct);
    ((fx)getActivity().app.getManager(42)).b(this.jdField_a_of_type_Ga);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment
 * JD-Core Version:    0.7.0.1
 */